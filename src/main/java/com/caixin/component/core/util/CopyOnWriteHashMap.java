package com.caixin.component.core.util;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CopyOnWriteHashMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private volatile Map<K, V> internalMap;

    public CopyOnWriteHashMap() {
        internalMap = new HashMap<>();
    }

    public V put(K key, V value) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<>(internalMap);
            V val = newMap.put(key, value);
            internalMap = newMap;
            return val;
        }
    }

    @Override
    public int size() {
        return internalMap.size();
    }

    @Override
    public boolean isEmpty() {
        return internalMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return internalMap.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return containsValue(o);
    }

    public V get(Object key) {
        return internalMap.get(key);
    }

    public void putAll(Map<? extends K, ? extends V> newData) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<>(internalMap);
            newMap.putAll(newData);
            internalMap = newMap;
        }
    }

    public V remove(Object key) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<>(internalMap);
            V val = newMap.remove(key);
            internalMap = newMap;
            return val;
        }
    }

    public void clear() {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<>(internalMap);
            newMap.clear();
            internalMap = newMap;
        }
    }

    @Override
    public Set<K> keySet() {
        return internalMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return internalMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return internalMap.entrySet();
    }


}
