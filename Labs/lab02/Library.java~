package lab02;

public class Library {
    public static void main(String[] args) {
        Book[] library = {new Book("Turtles All The Way Down", 189), new Book("The Wizard of Oz", 340), new Book("The Cat in the Hat", 38)};
        for(int i=0; i < library.length; i++){
            System.out.println(library[i].getTitle());
        }
        for(Book text : library){
            System.out.println(text.getNumPages());
        }
        System.out.println("Expected: 567");
        System.out.println(numPagesInLibrary(library));
        System.out.println("Expected: 340");
        System.out.println(mostPages(library));
    }  
    
    public static int numPagesInLibrary(Book[] books) {
        int totalNumPages = 0;
        for(Book text : books) {
            totalNumPages = totalNumPages + text.getNumPages();
        }
        return totalNumPages;
    }
    
    public static int mostPages(Book[] books) {
        int mostPages = 0;
        for(Book text : books) {
            if(text.getNumPages() > mostPages) {
                mostPages = text.getNumPages();
            }
        }
        return mostPages;
    }
}
