package com.cache.evictionPolicy;

public interface EvictionPolicy<Key> {


    // when some policy access key then something will happen
    void  keyAccessed(Key key );

    // remove key according to your policy;
    Key evictKey();
}
