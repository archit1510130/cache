package com.cache;

import com.cache.Storage.Storage;
import com.cache.evictionPolicy.EvictionPolicy;
import com.cache.exceptions.NotFoundException;
import com.cache.exceptions.StorageFullException;

public class Cache<Key,Value>{

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key,Value> storage;

    public Cache (EvictionPolicy<Key> evictionPolicy,Storage<Key,Value> storage)
    {
        this.evictionPolicy=evictionPolicy;
        this.storage=storage;
    }
    public void putKey(Key key,Value value)
    {
        try{
            this.evictionPolicy.keyAccessed(key);
            this.storage.add(key, value);
        }
        catch(StorageFullException exception)
        {
            System.out.println("Storage is full , will remove key from there");
            Key removedKey=this.evictionPolicy.evictKey();
            if(key==null)
            throw new RuntimeException("Dont know what is happening");
            this.storage.removeKey(removedKey);
            System.out.println("Remove key");
            this.storage.add(key, value);
        }

    }

    public Value getValue(Key key){
        try{
            evictionPolicy.keyAccessed(key);
            Value value =this.storage.getValue(key);
            return value;
        }
        catch(NotFoundException ex)
        {
            System.out.println("Key Not found");
            return null;

        }
    }

    
}
