package helloWorld.cache.modal;

public class Node<K, V> {
    K key;
    V value;
    private Node<K, V> pre;
    private Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Node<K, V> getPre() {
        return pre;
    }

    public void setPre(Node<K, V> pre) {
        this.pre = pre;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}