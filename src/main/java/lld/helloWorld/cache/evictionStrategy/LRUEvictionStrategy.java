package helloWorld.cache.evictionStrategy;

import helloWorld.cache.modal.DoublyLinkedList;
import helloWorld.cache.modal.Node;

import java.util.Map;

public class LRUEvictionStrategy<K, V> implements EvictionStrategy<K, V> {

    @Override
    public void access(DoublyLinkedList<K, V> dll, Node<K, V> node) {
        dll.remove(node);
        dll.insertAtHead(node);
    }

    @Override
    public void evict(Map<K, Node<K, V>> map, DoublyLinkedList<K, V> dll) {
        Node<K, V> nodeToBeRemoved = dll.getTail().getPre();
        dll.remove(nodeToBeRemoved);
        map.remove(nodeToBeRemoved.getKey());
        System.out.println("Evicting " + nodeToBeRemoved.getKey());
    }
}
