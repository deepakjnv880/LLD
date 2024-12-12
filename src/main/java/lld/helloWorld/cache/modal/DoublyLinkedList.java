package helloWorld.cache.modal;


public class DoublyLinkedList<K, V> {
    private final Node<K, V> head;
    private final Node<K, V> tail;


    public DoublyLinkedList(Node<K, V> head, Node<K, V> tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node<K, V> getTail() {
        return tail;
    }

    public Node<K, V> getHead() {
        return head;
    }

    public void remove(Node<K, V> node) {
        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
    }

    public void insertAtHead(Node<K, V> node) {
        node.setNext(head.getNext());
        head.getNext().setPre(node);
        head.setNext(node);
    }
}
