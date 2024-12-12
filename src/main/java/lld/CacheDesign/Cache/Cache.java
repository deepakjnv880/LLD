package lld.CacheDesign.Cache;

public interface Cache<K, V> {
    void put(K key, V value);

    V get(K key);
}

/*
Cache cache= CacheFactor.get(evictionStrategy)
factory check instance of evictionStrategy and based on that create hashMap with dll/stack/queue and take evictionStrategy as constructor parameter
 Cross questioon -> why not only use FACTORy("LRU") because infuture it ocmes handy when two eviection strategy can be used with one type of cache
 */