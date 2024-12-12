package helloWorld.cache;

import helloWorld.cache.evictionStrategy.EvictionStrategy;
import helloWorld.cache.modal.DoublyLinkedList;
import helloWorld.cache.modal.Node;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {

    private final EvictionStrategy<K, V> evictionStrategy;
    private final Map<K, Node<K, V>> cacheMap;
    private final DoublyLinkedList<K, V> list;
    private final int capacity;

    public Cache(int capacity, EvictionStrategy<K, V> evictionStrategy) {
        this.capacity = capacity;
        this.evictionStrategy = evictionStrategy;
        this.cacheMap = new HashMap<>();
        Node<K, V> head = new Node<>(null, null);
        Node<K, V> tail = new Node<>(null, null);
        head.setNext(tail);
        tail.setPre(head);
        this.list = new DoublyLinkedList<>(head, tail);
    }


    public V get(K key) {
        if (cacheMap.containsKey(key)) {
            evictionStrategy.access(list, cacheMap.get(key));
            return cacheMap.get(key).getValue();
        }
        return null;
    }

    public void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.get(key).setValue(value);
            evictionStrategy.access(list, cacheMap.get(key));
        }
        if (cacheMap.size() == capacity) {
            evictionStrategy.evict(cacheMap, list);
        }

        //new
        Node<K, V> newNode = new Node<>(key, value);
        list.insertAtHead(newNode);
        cacheMap.put(key, newNode);
    }
}
