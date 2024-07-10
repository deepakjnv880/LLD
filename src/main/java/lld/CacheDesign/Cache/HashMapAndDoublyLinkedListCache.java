package lld.CacheDesign.Cache;

import lld.CacheDesign.EvictionPolicy.EvictionStrategy;
import lld.CacheDesign.Model.DoublyLinkedList;
import lld.CacheDesign.Model.DoublyLinkedListNode;

import java.util.HashMap;

public class HashMapAndDoublyLinkedListCache<K, V> implements Cache<K,V>{
    int capacity;
    EvictionStrategy<K, V> evictionStrategy;
    HashMap<K, DoublyLinkedListNode<K, V>> hashMap;
    DoublyLinkedList<K, V> doublyLinkedList;

    public HashMapAndDoublyLinkedListCache(int capacity, EvictionStrategy<K, V> evictionStrategy) {
        this.capacity = capacity;
        this.evictionStrategy = evictionStrategy;
        hashMap = new HashMap<>();
        DoublyLinkedListNode<K, V> head = new DoublyLinkedListNode<>();
        DoublyLinkedListNode<K, V> tail = new DoublyLinkedListNode<>();
        head.next = tail;
        tail.pre = head;
        doublyLinkedList = new DoublyLinkedList<>(head, tail);
    }

    @Override
    public V get(K key) {
        System.out.println("get (" + key + ")");
        if (!hashMap.containsKey(key)) {
            return null;
        }
        DoublyLinkedListNode<K, V> doublyLinkedListNode = hashMap.get(key);
        evictionStrategy.keyAccessed(doublyLinkedListNode, doublyLinkedList);
        return doublyLinkedListNode.value;
    }

    @Override
    public void put(K key, V value) {
        System.out.println("put (" + key + "," + value + ")");
        DoublyLinkedListNode<K, V> doublyLinkedListNode;
        if (hashMap.containsKey(key)) {
            doublyLinkedListNode = hashMap.get(key);
            doublyLinkedListNode.value=value;
            evictionStrategy.keyAccessed(doublyLinkedListNode, doublyLinkedList);
            return;
        }

        if (hashMap.size() == capacity) {
            System.out.println("Cache is full ...");
            evictionStrategy.evict(doublyLinkedList, hashMap);
        }
        doublyLinkedListNode = new DoublyLinkedListNode<>(key, value);
        hashMap.put(key, doublyLinkedListNode);
        doublyLinkedList.insertAtTail(doublyLinkedListNode);
    }
}
