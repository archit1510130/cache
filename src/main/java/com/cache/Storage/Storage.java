package com.cache.Storage;

import com.cache.exceptions.NotFoundException;
import com.cache.exceptions.StorageFullException;

public interface Storage<Key,Value> {

    Value getValue(Key key) throws NotFoundException;
    void removeKey(Key key) ;
    void add(Key key, Value value) throws StorageFullException;
}
