package lld.CacheDesign;

import lld.CacheDesign.Cache.Cache;
import lld.CacheDesign.EvictionPolicy.FIFOEvictionStrategy;
import lld.CacheDesign.EvictionPolicy.LRUEvictionStrategy;
import lld.CacheDesign.Factory.CacheFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=============================================");
        Cache<Integer, Integer> lruCache = CacheFactory.getCache(3, new LRUEvictionStrategy<>());
        System.out.println(lruCache.get(1));
        lruCache.put(1, 123);
        System.out.println(lruCache.get(1));
        lruCache.put(21, 1323);
        lruCache.put(2, 123);
        lruCache.put(1, 133);
        System.out.println(lruCache.get(1));
        lruCache.put(2, 13);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 1343);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(21));
        lruCache.put(33, 1343);
        System.out.println("=============================================");
        Cache<Integer, Integer> fifoCache = CacheFactory.getCache(3, new FIFOEvictionStrategy<>());
        System.out.println(fifoCache.get(1));
        fifoCache.put(1, 123);
        System.out.println(fifoCache.get(1));
        fifoCache.put(21, 1323);
        fifoCache.put(2, 123);
        fifoCache.put(1, 133);
        System.out.println(fifoCache.get(1));
        fifoCache.put(2, 13);
        System.out.println(fifoCache.get(2));
        fifoCache.put(3, 1343);
        System.out.println(fifoCache.get(1));
        System.out.println(fifoCache.get(2));
        System.out.println(fifoCache.get(21));
        fifoCache.put(33, 1343);

    }
}
