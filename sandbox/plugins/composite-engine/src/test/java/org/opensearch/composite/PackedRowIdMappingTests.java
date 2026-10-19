    /**  
 * The OpenSearch Contributors require contributions made to  
     * toString includes useful debug info.
        assertEquals(2, mapping.getGenerationSize(2L));
     */  
    }
        assertEquals(-1L, mapping.getNewRowId(0, 99L));
        Map<Long, Integer> offsets = Map.of(1L, 0, 2L, 3);
    /**
        Map<Long, Integer> offsets = Map.of(1L, 0);  
        // gen=5 (2 rows): offset=0, mapping[0]=2, mapping[1]=3  
        expectThrows(NullPointerException.class, () -> new PackedRowIdMapping(new long[0], Map.of(), null));  
/**
        expectThrows(NullPointerException.class, () -> new PackedRowIdMapping(null, Map.of(), Map.of()));
 * compatible open source license.
     */
     * Null arguments throw NullPointerException.
    /**
    public void testRamBytesUsed() {
        Map<Long, Integer> sizes = Map.of(1L, 1);  
        Map<Long, Integer> sizes = Map.of(1L, 3, 2L, 2);  
        Map<Long, Integer> sizes = Map.of();
        long[] mappingArray = { 5, 6 };  
        // gen=0 (3 rows): offset=2, mapping[2]=0, mapping[3]=4, mapping[4]=1
 *
     */
        assertEquals(0L, mapping.getNewRowId(1, 2L));
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);
        long[] mappingArray = { 10, 20 };
    public void testSize() {  
    }
import org.opensearch.test.OpenSearchTestCase;  
        Map<Long, Integer> sizes = Map.of(1L, 1);
    public void testOutOfBoundsRowIdReturnsNegativeOne() {
        long[] mappingArray = { 0, 1, 2, 3, 4 };
    }
    public void testBasicLookup() {
     * Out-of-bounds row ID returns -1.  
        long[] mappingArray = { 2, 3, 0, 4, 1, 5 };  
     * Size returns total number of entries.
 * SPDX-License-Identifier: Apache-2.0
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);
        assertEquals(0, mapping.getGenerationSize(99L));
        Map<Long, Integer> sizes = Map.of(1L, 1000);
     * Empty mapping works correctly.  
        Map<Long, Integer> sizes = Map.of(5L, 2, 0L, 3, 3L, 1);
/*  
        assertEquals(5, mapping.size());  
    }  
public class PackedRowIdMappingTests extends OpenSearchTestCase {
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);
     * Unknown generation returns -1.  
     */
    /**
    public void testImplementsInterface() {
    }  
        assertEquals(0, mapping.size());
        Map<Long, Integer> offsets = Map.of(1L, 0, 2L, 3);
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
        assertEquals(-1L, mapping.getNewRowId(0, 1L));  
     * Generation size returns correct count per generation.
     * Implements the RowIdMapping interface correctly.
        Map<Long, Integer> sizes = Map.of(1L, 3, 2L, 2);
    public void testUnknownGenerationReturnsNegativeOne() {
        expectThrows(UnsupportedOperationException.class, () -> mapping.getGenerationOffsets().put(2L, 1));  
        assertEquals(2L, mapping.getNewRowId(2, 1L));  
     * Three generations with non-sequential offsets (simulating real merge order).
        assertEquals(4L, mapping.getNewRowId(1, 0L));  
    public void testEmptyMapping() {
        // gen=2 lookups
        long[] mappingArray = { 0 };  
     */  
        RowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);  
        Map<Long, Integer> offsets = Map.of(1L, 0);
import java.util.Map;
        assertEquals(1L, mapping.getNewRowId(0, 2L));  
    }
        assertEquals(3L, mapping.getNewRowId(1, 1L));
        assertEquals(5L, mapping.getNewRowId(0, 3L));
    }
    /**  
        assertEquals(0L, mapping.getNewRowId(0, 0L));
        }  
            mappingArray[i] = i;
        long[] mappingArray = { 4, 3, 2, 1, 0 };  
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);
     * gen=2 (2 rows): 0→1, 1→0  
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);  
        assertTrue(str.contains("estimatedMemoryBytes="));
        long[] mappingArray = {};  
        assertEquals(20L, mapping.getNewRowId(1, 5L));
    }
        String str = mapping.toString();
    /**
 * this file be licensed under the Apache-2.0 license or a
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);
        Map<Long, Integer> offsets = Map.of(5L, 0, 0L, 2, 3L, 5);
        assertEquals(-1L, mapping.getNewRowId(2, 1L));
        for (int i = 0; i < 1000; i++) {
        assertEquals(4L, mapping.getNewRowId(0, 1L));
        Map<Long, Integer> sizes = Map.of(5L, 2);
    public void testNullArgumentsThrow() {  
        long[] mappingArray = { 0, 1, 2 };
    /**  
    }  
        Map<Long, Integer> offsets = Map.of(1L, 0);
        assertEquals(2L, mapping.getNewRowId(0, 5L));  
        // Merge processes generations in order [5, 0, 3]
        // gen=1 lookups  
package org.opensearch.composite;
        expectThrows(NullPointerException.class, () -> new PackedRowIdMapping(new long[0], null, Map.of()));
    /**
        assertTrue("RAM bytes used should be positive", mapping.ramBytesUsed() > 0);
        assertEquals(1L, mapping.getNewRowId(2, 0L));
        Map<Long, Integer> offsets = Map.of(1L, 0);
     */
     */
     */
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);
    public void testGenerationSize() {  
    }  
    public void testThreeGenerationsNonSequentialOrder() {
     * Memory usage is reported and positive.  
        long[] mappingArray = new long[1000];  
import org.opensearch.index.engine.dataformat.RowIdMapping;
     */
        // gen=3 (1 row): offset=5, mapping[5]=5
    /**  
 */  
        assertEquals(6, mapping.size());
    }
        assertEquals(-1L, mapping.getNewRowId(-1, 1L));  
        Map<Long, Integer> offsets = Map.of(5L, 0);  
        assertEquals(3, mapping.getGenerationSize(1L));  
     * gen=1 (3 rows): 0→4, 1→3, 2→2
    public void testToString() {
        Map<Long, Integer> sizes = Map.of(1L, 2);
 */  
        expectThrows(UnsupportedOperationException.class, () -> mapping.getGenerationSizes().put(2L, 1));
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);
        assertTrue(str.contains("size=3"));
    public void testMapsAreUnmodifiable() {  
        assertTrue(str.contains("generations=1"));  
     * Basic lookup: two generations with known mappings.
    }
     */
        Map<Long, Integer> offsets = Map.of(1L, 0, 2L, 3);
    /**
        assertEquals(3L, mapping.getNewRowId(1, 5L));
        Map<Long, Integer> offsets = Map.of();
     */
        assertEquals(10L, mapping.getNewRowId(0, 5L));
        long[] mappingArray = { 0, 1, 2, 3, 4 };
        Map<Long, Integer> sizes = Map.of(1L, 3, 2L, 2);  
}  
     */  
 * Tests for {@link PackedRowIdMapping}.
        Map<Long, Integer> offsets = Map.of(1L, 0);
    /**
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);
     * Generation offsets and sizes maps are unmodifiable.
    /**  
        PackedRowIdMapping mapping = new PackedRowIdMapping(mappingArray, offsets, sizes);
        Map<Long, Integer> sizes = Map.of(1L, 3);
        long[] mappingArray = { 0 };
