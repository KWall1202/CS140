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
	
	public void printVegetarianMenu() {
		System.out.println("\nVEGETARIAN MENU\n----");
		for(MComp comp: allMenus) {
			if(comp instanceof MenuItem) {
				if(comp.isVegetarian()) comp.print();
			}
		}
	}
}
