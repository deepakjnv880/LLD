package helloWorld.cache.evictionStrategy;

import helloWorld.cache.modal.DoublyLinkedList;
import helloWorld.cache.modal.Node;

import java.util.Map;

public interface EvictionStrategy<K, V> {
    void access(DoublyLinkedList<K, V> dll, Node<K, V> node);

    void evict(Map<K, Node<K, V>> map, DoublyLinkedList<K, V> dll);
}
