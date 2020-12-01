package sample;

public class Node {
    private Node next;
    private final Figure data;

    Node(Figure data) {
        this.data = data;
        this.next = null;
    }

    public Figure getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}