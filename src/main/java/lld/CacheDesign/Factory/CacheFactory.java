package lld.CacheDesign.Factory;

import lld.CacheDesign.Cache.Cache;
import lld.CacheDesign.Cache.HashMapAndDoublyLinkedListCache;
import lld.CacheDesign.EvictionPolicy.EvictionStrategy;
import lld.CacheDesign.EvictionPolicy.FIFOEvictionStrategy;
import lld.CacheDesign.EvictionPolicy.LRUEvictionStrategy;

public class CacheFactory {
    public static <K, V> Cache<K, V> getCache(int capacity, EvictionStrategy<K, V> evictionStrategy) {
        if (evictionStrategy instanceof LRUEvictionStrategy) {
            return new HashMapAndDoublyLinkedListCache<>(capacity, evictionStrategy);
        } else if (evictionStrategy instanceof FIFOEvictionStrategy) {
            //letter it can be moved to use LinkedList only
            return new HashMapAndDoublyLinkedListCache<>(capacity, evictionStrategy);
        }
        return null;
    }
}
