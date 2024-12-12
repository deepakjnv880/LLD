package lld.CacheDesign.Model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DoublyLinkedListNode<K, V> {

    public K key;
    public V value;
    public DoublyLinkedListNode<K, V> next;
    public DoublyLinkedListNode<K, V> pre;

    public DoublyLinkedListNode(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
        pre = null;
    }
}
