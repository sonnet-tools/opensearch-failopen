 */  
}
    public void testIsAliveReadsBits() {
        assertTrue(liveDocs.isAlive(1L, 2));
        long[] bits = new long[] { 0b1011L };
 * compatible open source license.
    }
 *
package org.opensearch.index.engine.dataformat;
    public void testFromPackedBitsNullReturnsAllAlive() {
    }
        assertTrue(liveDocs.isAlive(2L, 0));
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(5L, new long[] { 0b1L }));
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(liveDocs.isAlive(1L, 1));
        raw.put(1L, bits);  
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0L }));
        assertTrue(liveDocs.isAlive(1L, 1_000_000));
 * Unit tests for {@link LiveDocs}.
        assertFalse(liveDocs.isAlive(1L, 63));
 * The OpenSearch Contributors require contributions made to  
    }
        Map<Long, long[]> raw = new HashMap<>();
    // ========== packedBits ==========
        assertEquals(0, LiveDocs.ALL_ALIVE.segmentsWithDeletes());
        assertTrue(liveDocs.isAlive(1L, 64));
    public void testIsAliveAtWordBoundaries() {
    // ========== fromPackedBits ==========
    public void testIsAliveBeyondBitsetReturnsTrueDefensively() {
    }  
        assertNull(liveDocs.packedBits(8L));  
        assertFalse(liveDocs.isAlive(1L, 1));  
    }  
    }
        // Word index 1 is beyond the one-word bitset — treated as alive.  
        assertTrue("LiveDocs must clone input arrays", liveDocs.isAlive(1L, 0));
    }
        assertFalse(liveDocs.allAlive());  
        assertTrue("other segments have no deletes", liveDocs.allAlive(6L));
        LiveDocs liveDocs = LiveDocs.fromPackedBits(raw);
    public void testPackedBitsReturnsBitsForSegmentWithDeletes() {
        // Segment 2 has no entry — everything is alive.  
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(7L, bits));  
        assertTrue(liveDocs.isAlive(1L, 63));
        // Within the bitset, all bits are 0 — dead.  
import java.util.HashMap;  
        assertFalse(liveDocs.allAlive(5L));
    }  
    public void testSegmentsWithDeletesCountsEntries() {  
        long[] bits = new long[] { 0b101L };
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(liveDocs.isAlive(1L, 0));
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b101L }));
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(1L, bits));
        assertTrue(LiveDocs.ALL_ALIVE.allAlive(randomLong()));  
    }  
        assertFalse(liveDocs.isAlive(1L, 0));
    public void testFromPackedBitsEmptyMapReturnsAllAlive() {
        assertEquals(1, liveDocs.segmentsWithDeletes());  
        assertTrue(LiveDocs.ALL_ALIVE.allAlive());
        assertNull(LiveDocs.ALL_ALIVE.packedBits(7L));
/**  
    public void testAllAliveSingleton() {
public class LiveDocsTests extends OpenSearchTestCase {  
/*  
    public void testPackedBitsReturnsNullForSegmentWithoutDeletes() {
        assertSame(LiveDocs.ALL_ALIVE, LiveDocs.fromPackedBits(null));
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L }, 2L, new long[] { 0b10L }));
import java.util.Map;
    }
 */
        // Word 0: only bit 63 set. Word 1: only bit 0 set (row 64).  
    }
    public void testAllAliveFalseWhenSegmentHasDeletes() {
        // rows 0 and 2 alive, row 1 dead  
        long[] bits = new long[] { 1L << 63, 1L };
        bits[0] = 0L;
        assertArrayEquals(bits, liveDocs.packedBits(7L));
        // Mutating the caller's array must not affect the LiveDocs instance.  
    }  
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b101L }));
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(liveDocs.isAlive(1L, 0));  
        assertTrue(liveDocs.isAlive(2L, randomLongBetween(0, 1_000_000)));
    public void testIsAliveForSegmentWithoutDeletesReturnsTrue() {
    public void testFromPackedBitsDefensivelyClonesArrays() {  
    // ========== allAlive ==========
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(7L, new long[] { 0b1L }));
    // ========== isAlive ==========  
        assertTrue(liveDocs.isAlive(1L, 64));
        assertSame(LiveDocs.ALL_ALIVE, LiveDocs.fromPackedBits(Map.of()));  
        assertFalse(liveDocs.isAlive(1L, 62));  
        assertEquals(2, liveDocs.segmentsWithDeletes());
    // ========== segmentsWithDeletes ==========
        assertFalse(liveDocs.isAlive(1L, 65));
