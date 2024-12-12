package helloWorld.cache;

import helloWorld.cache.evictionStrategy.FIFOEvictionStrategy;
import helloWorld.cache.evictionStrategy.LRUEvictionStrategy;

public class Driver {
    public static void main(String[] args) {
        Cache<Integer, String> cache = new Cache<>(3, new LRUEvictionStrategy<>());
        cache.put(1, "deepak");
        cache.put(2, "priya");
        cache.put(3, "nikhil");
        System.out.println(cache.get(1));
        cache.put(4, "aman");
        cache = new Cache<>(3, new FIFOEvictionStrategy<>());
        cache.put(1, "deepak");
        cache.put(2, "priya");
        cache.put(3, "nikhil");
        System.out.println(cache.get(1));
        cache.put(4, "aman");
    }
}
