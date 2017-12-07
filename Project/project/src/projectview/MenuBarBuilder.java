package projectview;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

public class MenuBarBuilder implements Observer{
	private JMenuItem assemble = new JMenuItem("Assemble Source...");
	private JMenuItem load = new JMenuItem("Load File...");
	private JMenuItem exit = new JMenuItem("Exit");
	private JMenuItem go = new JMenuItem("Go");
	private ViewMediator mediator;

	public MenuBarBuilder(ViewMediator view) {
		mediator = view;
		view.addObserver(this);
	}

	JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		assemble.setMnemonic(KeyEvent.VK_M);
		assemble.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		assemble.addActionListener(e -> mediator.assembleFile());
		menu.add(assemble);
		menu.addSeparator(); //Test with this line removed
		load.setMnemonic(KeyEvent.VK_M);
		load.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		load.addActionListener(e -> mediator.loadFile());
		menu.add(load);
		menu.addSeparator();
		exit.setMnemonic(KeyEvent.VK_M);
		exit.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		exit.addActionListener(e -> mediator.exit());
		menu.add(exit);
		return menu;
	}
	
	JMenu createExecuteMenu() {
		JMenu menu = new JMenu("Execute");
		go.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		go.addActionListener(e -> mediator.execute());
		menu.add(go);
		return menu;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		assemble.setEnabled(mediator.getCurrentState().getAssembleFileActive());
		load.setEnabled(mediator.getCurrentState().getLoadFileActive());
		go.setEnabled(mediator.getCurrentState().getStepActive());
	}
}