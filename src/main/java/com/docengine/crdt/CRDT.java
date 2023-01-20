package com.docengine.crdt;
public interface CRDT<T> {
    T merge(T other);
    String serialize();
    static CRDT<?> deserialize(String data) { return null; }
}
