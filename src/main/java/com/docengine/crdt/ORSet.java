package com.docengine.crdt;
import java.util.*;
public class ORSet<T> implements CRDT<ORSet<T>> {
    private final Map<T, Set<String>> elements = new HashMap<>();
    private final Set<String> tombstones = new HashSet<>();
    public void add(T element, String tag) {
        elements.computeIfAbsent(element, k -> new HashSet<>()).add(tag);
    }
    public void remove(T element) {
        if (elements.containsKey(element)) {
            tombstones.addAll(elements.get(element));
            elements.remove(element);
        }
    }
    public Set<T> getElements() { return elements.keySet(); }
    @Override
    public ORSet<T> merge(ORSet<T> other) {
        ORSet<T> result = new ORSet<>();
        elements.forEach((k, v) -> v.forEach(tag -> result.add(k, tag)));
        return result;
    }
    @Override
    public String serialize() { return elements.keySet().toString(); }
}
