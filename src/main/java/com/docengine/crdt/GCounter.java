package com.docengine.crdt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class GCounter implements CRDT<GCounter> {
    private final Map<String, Integer> counts = new ConcurrentHashMap<>();
    public void increment(String nodeId) {
        counts.merge(nodeId, 1, Integer::sum);
    }
    public int total() {
        return counts.values().stream().mapToInt(Integer::intValue).sum();
    }
    @Override
    public GCounter merge(GCounter other) {
        GCounter result = new GCounter();
        counts.keySet().forEach(key -> 
            result.counts.put(key, Math.max(counts.get(key), other.counts.getOrDefault(key, 0)))
        );
        return result;
    }
    @Override
    public String serialize() { return counts.toString(); }
}
