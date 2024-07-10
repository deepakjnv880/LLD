package lld.CacheDesign.EvictionPolicy;

import lld.CacheDesign.Model.DoublyLinkedList;
import lld.CacheDesign.Model.DoublyLinkedListNode;

import java.util.HashMap;

public class FIFOEvictionStrategy<K, V> implements EvictionStrategy<K, V> {
    @Override
    public void evict(DoublyLinkedList<K, V> doublyLinkedList, HashMap<K, DoublyLinkedListNode<K, V>> hashMap) {
        DoublyLinkedListNode<K, V> firstNode = doublyLinkedList.head.next;
        doublyLinkedList.deleteNode(firstNode);
        hashMap.remove(firstNode.key);
        System.out.println("As per FIFO eviction policy, deleted node with key " + firstNode.key);
    }

    @Override
    public void keyAccessed(DoublyLinkedListNode<K, V> doublyLinkedListNode, DoublyLinkedList<K, V> doublyLinkedList) {
    }
}
