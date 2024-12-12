package lld.CacheDesign.EvictionPolicy;

import lld.CacheDesign.Model.DoublyLinkedList;
import lld.CacheDesign.Model.DoublyLinkedListNode;

import java.util.HashMap;

public interface EvictionStrategy<K, V> {
    void evict(DoublyLinkedList<K, V> doublyLinkedList, HashMap<K, DoublyLinkedListNode<K, V>> hashMap);

    void keyAccessed(DoublyLinkedListNode<K, V> doublyLinkedListNode, DoublyLinkedList<K, V> doublyLinkedList);
}
