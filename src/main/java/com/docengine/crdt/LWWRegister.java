package com.docengine.crdt;
import java.time.LocalDateTime;
public class LWWRegister<T> implements CRDT<LWWRegister<T>> {
    private T value;
    private LocalDateTime timestamp;
    private String nodeId;
    public LWWRegister(T value, String nodeId) {
        this.value = value;
        this.timestamp = LocalDateTime.now();
        this.nodeId = nodeId;
    }
    public void set(T newValue, String nodeId) {
        if (LocalDateTime.now().isAfter(timestamp)) {
            this.value = newValue;
            this.timestamp = LocalDateTime.now();
            this.nodeId = nodeId;
        }
    }
    @Override
    public LWWRegister<T> merge(LWWRegister<T> other) {
        if (other.timestamp.isAfter(this.timestamp)) {
            return other;
        }
        return this;
    }
    public T getValue() { return value; }
    @Override
    public String serialize() { return value.toString(); }
}
