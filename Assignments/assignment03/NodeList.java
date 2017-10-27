package assignment03;

public class NodeList {
    private Node first;
    
    public Node getFirst() {
        return first;
    }
    
    public void makeList(int max) {
        first = new Node(2);
        Node current = first;
        for (int i=3; i <= max; i++) {
            current.setNext(new Node(i));
            current = current.getNext();
        }
    }
    
    public void listNodeValues() {
        Node temp = first;
        int count = 0;
        while (temp != null) {
            if (temp.getNext() != null) {
                System.out.print(temp.getValue() + ", ");
            } else {
                System.out.println(temp.getValue());
            }
            temp = temp.getNext();
            count++;
            if (count % 20 == 0) {
                System.out.println();
            }
        }
    }
    
    public void sieve(Node curr) {
        Node temp = curr;
        int n = temp.getValue();
        while(temp.getNext() != null) {
            temp =  temp.getNext();
            if (temp.getNext() != null && temp.getNext().getValue() % n == 0) {
                temp.setNext(temp.getNext().getNext());
            }
        }
        if (curr.getNext() != null) {
            sieve(curr.getNext());
        }
    }
 
    public static void main(String[] args) {
        NodeList list = new NodeList();
        list.makeList(90);
        list.listNodeValues();
        list.sieve(list.getFirst());
        list.listNodeValues();
    }
}

