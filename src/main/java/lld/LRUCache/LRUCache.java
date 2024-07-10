package lld.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a cache service with LRU or least recently used policy.
 * We can think of simple idea but time complexity will be linear.
 * We need everything in O(1).
 **/
public class LRUCache {
    Map<Integer, Dll> map;
    Dll head, tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Dll(-1, -1);
        this.tail = new Dll(-1, -1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(1));
        cache.put(1, 123);
        System.out.println(cache.get(1));
        cache.put(1, 133);
        System.out.println(cache.get(1));
        cache.put(2, 13);
        System.out.println(cache.get(2));
        cache.put(3, 1343);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Dll node = map.get(key);
            delete(node);
            put(node.key, node.value);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        //LRU or leastRecentlyUsed policy
        if (map.size() == capacity) delete(tail.pre);
        insertAtHead(new Dll(key, value));
    }

    private void delete(Dll node) {
        map.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void insertAtHead(Dll node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        map.put(node.key, node);
    }

    private static class Dll {
        Dll pre, next;
        int key, value;

        public Dll(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
    }
}
