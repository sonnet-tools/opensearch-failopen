    }
        expectThrows(NullPointerException.class, () -> new PackedRowIdMapping(new long[0], null, Map.of()));  
        assertEquals(-1L, m.getOldRowId(2));  
 * compatible open source license.
        PackedRowIdMapping m = new PackedRowIdMapping(mappingArray, offsets, sizes);  
        long[] mapping = { 0, 1 };
        PackedRowIdMapping m = new PackedRowIdMapping(mappingArray, false);
        assertEquals(Map.of(1L, 0), m.getGenerationOffsets());
    }
    }  
        String str = m.toString();  
        Map<Long, Integer> offsets = Map.of(1L, 0);
        PackedRowIdMapping m = new PackedRowIdMapping(mapping, false);
    }
        PackedRowIdMapping m = new PackedRowIdMapping(mappingArray, offsets, sizes);  
        Map<Long, Integer> offsets = Map.of(1L, 0);  
        // forward: old 0 -> new 2, old 1 -> new 0, old 2 -> new 1
        PackedRowIdMapping m = new PackedRowIdMapping(mappingArray, Map.of(1L, 0), Map.of(1L, 3));
        assertEquals(0, m.size());  
        for (int i = 0; i < 100; i++) {
    public void testOutOfBoundsRowIdReturnsNegativeOne() {
    public void testSingleGenWithReverseSupport() {
    public void testNullArgumentsThrow() {
        assertEquals(0L, m.getNewRowId(1, RowIdMapping.SINGLE_GEN));  
        assertTrue(str.contains("generations=1"));
        assertEquals(2L, m.getNewRowId(2, 1L));
    public void testEmptyMapping() {  
        assertEquals(-1L, m.getNewRowId(0, 99L));
    }  
        assertEquals(4L, m.getNewRowId(0, 1L));
    public void testToStringContainsInfo() {  
        assertEquals(0L, m.getNewRowId(1, RowIdMapping.SINGLE_GEN));  
        assertEquals(-1L, m.getOldRowId(-1));
        long[] mappingArray = { 5, 6 };
    public void testSingleGenConstructorForwardLookup() {
        Map<Long, Integer> offsets = Map.of(1L, 0, 2L, 3);  
        assertEquals(3, m.size());
        assertEquals(0L, m.getNewRowId(1, 2L));  
        // gen=2 (2 rows at offset 3): 0->1, 1->0
    }  
        long[] mappingArray = { 0, 1 };  
        assertEquals(2, m.getGenerationSize(2L));
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(1L, m.getNewRowId(2, RowIdMapping.SINGLE_GEN));
        PackedRowIdMapping m = new PackedRowIdMapping(mapping, true);
        // reverse: new 0 -> old 1, new 1 -> old 2, new 2 -> old 0  
        assertEquals(1L, m.getOldRowId(0));
        PackedRowIdMapping withoutReverse = new PackedRowIdMapping(mappingArray, false);
        assertTrue(str.contains("size=3"));
        long[] mappingArray = { 0, 1, 2, 3, 4 };
        long[] mappingArray = { 0, 1 };
    public void testRamBytesUsedWithReverse() {
 * Tests for {@link PackedRowIdMapping}.  
    public void testReverseOutOfBoundsReturnsNegativeOne() {
        PackedRowIdMapping m = new PackedRowIdMapping(mapping, false);  
        assertEquals(2L, m.getNewRowId(0, RowIdMapping.SINGLE_GEN));
        assertTrue(withReverse.ramBytesUsed() > withoutReverse.ramBytesUsed());  
        assertEquals(-1L, m.getNewRowId(-1, 1L));
        }  
        PackedRowIdMapping withReverse = new PackedRowIdMapping(mappingArray, true);
        expectThrows(NullPointerException.class, () -> new PackedRowIdMapping(new long[0], Map.of(), null));
package org.opensearch.index.engine.dataformat;
        assertEquals(1L, m.getNewRowId(0, 2L));
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(UnsupportedOperationException.class, () -> m.getGenerationOffsets().put(2L, 1));
        long[] mapping = { 2, 0, 1 };  
}
import java.util.Map;  
    }
    public void testGetGenerationSizes() {
        long[] mappingArray = new long[100];  
        assertTrue(m.isNewToOldSupported());  
/**
        assertEquals(-1L, m.getNewRowId(2, 1L));
        long[] mappingArray = {};
 */  
    public void testUnknownGenerationReturnsNegativeOne() {
/*  
    }
        assertEquals(3L, m.getNewRowId(1, 1L));  
        assertFalse(m.isNewToOldSupported());
    }  
 * The OpenSearch Contributors require contributions made to  
        PackedRowIdMapping m = new PackedRowIdMapping(mappingArray, Map.of(1L, 0), Map.of(1L, 2));  
    }
        long[] mapping = { 2, 0, 1 };
        Map<Long, Integer> sizes = Map.of(1L, 2);
        assertEquals(2L, m.getNewRowId(0, RowIdMapping.SINGLE_GEN));
        assertTrue(m.ramBytesUsed() > 0);
        assertEquals(-1L, m.getNewRowId(0, 1L));
        PackedRowIdMapping m = new PackedRowIdMapping(mapping, true);
        long[] mapping = { 1, 0 };  
        Map<Long, Integer> sizes = Map.of(1L, 2);
        PackedRowIdMapping m = new PackedRowIdMapping(mappingArray, Map.of(), Map.of());
        long[] mappingArray = { 1, 0 };  
    public void testRamBytesUsedPositive() {
        assertEquals(5, m.size());
        expectThrows(UnsupportedOperationException.class, () -> m.getOldRowId(0));
        // gen=1 (3 rows at offset 0): 0->4, 1->3, 2->2  
        expectThrows(UnsupportedOperationException.class, () -> m.getGenerationSizes().put(2L, 1));  
    public void testGenerationSize() {  
public class PackedRowIdMappingTests extends OpenSearchTestCase {
        assertEquals(0L, m.getOldRowId(2));  
    public void testReverseUnsupportedThrows() {  
    }  
 */
        PackedRowIdMapping m = new PackedRowIdMapping(mappingArray, offsets, sizes);
    public void testMultiGenerationLookup() {
        assertEquals(0, m.getGenerationSize(99L));
    }
        long[] mappingArray = { 0, 1, 2 };
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2L, m.getOldRowId(1));
        long[] mappingArray = { 0 };
        Map<Long, Integer> sizes = Map.of(1L, 3, 2L, 2);  
        assertEquals(Map.of(1L, 2), m.getGenerationSizes());
    }  
        expectThrows(NullPointerException.class, () -> new PackedRowIdMapping(null, Map.of(), Map.of()));
        PackedRowIdMapping m = new PackedRowIdMapping(mappingArray, Map.of(1L, 0), Map.of(1L, 1));  
        Map<Long, Integer> offsets = Map.of(1L, 0, 2L, 3);
    public void testGetGenerationOffsets() {
    }
        assertEquals(3, m.getGenerationSize(1L));  
    }  
        Map<Long, Integer> sizes = Map.of(1L, 3, 2L, 2);
 *
        assertEquals(1L, m.getNewRowId(2, RowIdMapping.SINGLE_GEN));
        PackedRowIdMapping m = new PackedRowIdMapping(mappingArray, offsets, sizes);
        long[] mappingArray = { 4, 3, 2, 1, 0 };
            mappingArray[i] = i;
