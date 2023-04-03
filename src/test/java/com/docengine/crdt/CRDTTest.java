package com.docengine.crdt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CRDTTest {
    @Test
    void testGCounterMerge() {
        GCounter c1 = new GCounter();
        GCounter c2 = new GCounter();
        c1.increment("node1");
        c2.increment("node2");
        GCounter merged = c1.merge(c2);
        assertEquals(2, merged.total());
    }
    @Test
    void testORSetAdd() {
        ORSet<String> set = new ORSet<>();
        set.add("item1", "tag1");
        assertTrue(set.getElements().contains("item1"));
    }
}
