package lld.CacheDesign.EvictionPolicy;

import lld.CacheDesign.Model.DoublyLinkedList;
import lld.CacheDesign.Model.DoublyLinkedListNode;

import java.util.HashMap;

public class LRUEvictionStrategy<K, V> implements EvictionStrategy<K, V> {
    @Override
    public void evict(DoublyLinkedList<K, V> doublyLinkedList, HashMap<K, DoublyLinkedListNode<K, V>> hashMap) {
        DoublyLinkedListNode<K, V> doublyLinkedListNodeToBeDelete = doublyLinkedList.tail.pre;
        doublyLinkedList.deleteNode(doublyLinkedListNodeToBeDelete);
        hashMap.remove(doublyLinkedListNodeToBeDelete.key);
        System.out.println("As per LRU eviction policy, deleted node with key " + doublyLinkedListNodeToBeDelete.key);
    }

    @Override
    public void keyAccessed(DoublyLinkedListNode<K, V> doublyLinkedListNode, DoublyLinkedList<K, V> doublyLinkedList) {
        doublyLinkedList.deleteNode(doublyLinkedListNode);
        doublyLinkedList.insertAtHead(doublyLinkedListNode);
    }
}
