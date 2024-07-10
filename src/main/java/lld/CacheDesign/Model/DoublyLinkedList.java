package lld.CacheDesign.Model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DoublyLinkedList<K, V> {
    public DoublyLinkedListNode<K, V> head;
    public DoublyLinkedListNode<K, V> tail;

    public void insertAtHead(DoublyLinkedListNode<K, V> doublyLinkedListNode) {
        DoublyLinkedListNode<K, V> temp = head.next;
        head.next = doublyLinkedListNode;
        doublyLinkedListNode.pre = head;
        doublyLinkedListNode.next = temp;
        temp.pre = doublyLinkedListNode;
    }

    public void deleteNode(DoublyLinkedListNode<K, V> doublyLinkedListNode) {
        doublyLinkedListNode.pre.next = doublyLinkedListNode.next;
        doublyLinkedListNode.next.pre = doublyLinkedListNode.pre;
    }

    public void insertAtTail(DoublyLinkedListNode<K, V> doublyLinkedListNode) {
        DoublyLinkedListNode<K, V> temp = tail.pre;
        tail.pre = doublyLinkedListNode;
        doublyLinkedListNode.next = tail;
        temp.next = doublyLinkedListNode;
        doublyLinkedListNode.pre = temp;
    }
}
