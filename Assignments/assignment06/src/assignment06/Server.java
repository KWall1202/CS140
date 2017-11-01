package assignment06;

public class Server {
	private MComp allMenus;

	public Server(MComp allMenus) {
		super();
		this.allMenus = allMenus;
	}
	
	public void printMenu() {
		allMenus.print();
	}
	
	private void printVegetarianMenuHelper(MComp menus) {
		for(MComp comp: menus) {
			if(comp instanceof MenuItem) {
				if(comp.isVegetarian()) comp.print();
			} else {
				printVegetarianMenuHelper(comp);
			}
		}
	}
	
	public void printVegetarianMenu() {
		System.out.println("\nVEGETARIAN MENU\n----");
		printVegetarianMenuHelper(allMenus);
	}
}
