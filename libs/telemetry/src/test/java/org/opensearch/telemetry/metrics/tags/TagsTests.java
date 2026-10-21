    public void testOfSingleTag() {
    }
    }
        Tags b = Tags.of("x", "2");
        assertEquals("c", merged.getKey(2));
        assertEquals(viaOfStringPairs.hashCode(), viaConcat.hashCode());
        Tags merged = Tags.concat(a, b);
        assertEquals("z", merged.getKey(4));
        Tags t = Tags.of("num", 42L);
        assertEquals(a.hashCode(), b.hashCode());
 * The OpenSearch Contributors require contributions made to
        assertEquals("retries", t.getKey(0));
    }
        assertEquals("new_a", merged.getValue(0));
        assertEquals("Tags{a=1}", t.toString());
        assertEquals(1, t.size());
    public void testIdentityEquals() {
    }
        Tags b = Tags.ofStringPairs("k", "v", "k2", "v2");
        Tags merged = Tags.concat(a, b);
    }
    }
        assertEquals(42L, t.getTagsMap().get("num"));
    // --- ofStringPairs(varargs) ---
        }
        assertEquals("26", merged.getValue(4));
        assertEquals(1.5, t.getValue(0));
    // --- fromMap ---
    public void testEqualTagsAreEqual() {
    public void testDifferentSizeNotEqual() {
        assertEquals(0, original.size());
        assertEquals("d", merged.getKey(3));
        assertTrue(Tags.EMPTY.getTagsMap().isEmpty());
        Tags a = Tags.of("a", "1");
        assertEquals("z", t.getKey(2));
        Tags a = Tags.ofStringPairs("x", "1", "y", "2");
    }
        assertEquals(3L, t.getValue(0));
        expectThrows(NullPointerException.class, () -> Tags.fromMap(map));
        assertSame(a, Tags.concat(Tags.EMPTY, a));
        assertNotEquals(Tags.of("k", "v"), "not a Tags");
        assertEquals(2, t.size());
 * compatible open source license.
        Tags viaConcat = Tags.concat(Tags.of("a", "1"), Tags.of("b", "2"));
    public void testConcatFullOverlapBWins() {
    public void testConcatWithNullReturnsOther() {
    public void testAddTagBoolean() {
    public void testAddTagLong() {
    }
        assertEquals(a, b);
    }
        assertSame(Tags.EMPTY, Tags.concat(null, null));
    // --- Concurrent safety: Tags is immutable so no sharing issues ---
    }
        assertEquals("b", merged.getKey(1));
        Map<Tags, String> map = new HashMap<>();
    public void testOfStringPairsOddLengthThrows() {
        assertEquals("e", merged.getKey(4));
        assertSame(a, Tags.concat(a, Tags.EMPTY));
        Tags merged = Tags.concat(a, b);
    }
    public void testOfStringPairsNull() {
        assertEquals("prod", t.getValue(0));
        Tags b = Tags.ofStringPairs("b", "2", "c", "4");
    }
        assertEquals("a", t.getKey(0));
 * SPDX-License-Identifier: Apache-2.0
    public void testOfLong() {
    }
        assertEquals(1, t.size());
    }
    public void testCreateReturnsEmpty() {
        assertEquals(Tags.EMPTY, Tags.create());
        assertSame(a, Tags.concat(a, null));
        assertEquals(t, t);
        Tags merged = Tags.concat(a, b);
        assertEquals("1", merged.getValue(0));
        Tags original = Tags.create();
    }
        Tags a = Tags.of("k", "old");
        map.put("k", null);
        Tags t = Tags.of("k", "v");
        Tags t = Tags.create().addTag("a", "1").addTag("b", "2").addTag("c", "3");
public class TagsTests extends OpenSearchTestCase {
        assertEquals(true, t.getValue(0));
    // --- equals / hashCode ---
    }
    public void testEmptyHasZeroSize() {
    }
    public void testAddTagDouble() {
        assertEquals("new", merged.getValue(0));
    public void testFromMapRoundTrips() {
        assertEquals("Tags{}", Tags.EMPTY.toString());
        assertEquals("a", merged.getKey(0));
    public void testFromMapEmptyReturnsEmpty() {
        assertEquals(1, t.size());
    }
        Tags merged = Tags.concat(a, b);
        assertEquals("a", merged.getKey(0));
        assertSame(Tags.EMPTY, Tags.fromMap(null));
    public void testAddTagOverwritesPreviousValue() {
        assertEquals(1, t.size());
        expectThrows(NullPointerException.class, () -> Tags.of(null, "v"));
        map.put(t1, "found");
        assertNotSame(original, updated);
        assertEquals("a", merged.getKey(0));
        Tags a = Tags.ofStringPairs("a", "1", "c", "3", "e", "5");
    }
    // --- getTagsMap ---
    }
        assertEquals("b", t.getKey(1));
    }
        assertEquals(3, merged.size());
        Tags t = Tags.of("latency", 1.5);
        assertNotEquals(a, b);
        assertEquals(1, t.size());
        Tags b = Tags.ofStringPairs("a", "2", "m", "3");
import java.util.Map;
    }
    }
        assertSame(Tags.EMPTY, Tags.concat(Tags.EMPTY, null));
        for (int i = 0; i < merged.size() - 1; i++) {
    public void testFromMapNullReturnsEmpty() {
        assertEquals("b", t.getKey(1));
        Tags t = Tags.of("enabled", true);
        Tags t = Tags.fromMap(map);
        assertEquals("c", merged.getKey(2));
        assertNotEquals(Tags.of("k", "v"), null);
        Tags a = Tags.ofStringPairs("a", "1", "c", "3");
    }
            assertTrue(merged.getKey(i).compareTo(merged.getKey(i + 1)) < 0);
    }
    }
    public void testOfStringPairsSorted() {
        Tags a = Tags.of("x", "1");
    // --- EMPTY ---
        Tags t = Tags.of("retries", 3L);
        assertEquals("4", merged.getValue(2));
        Tags a = Tags.of("k", "v");
        assertEquals(5, merged.size());
        Tags b = Tags.ofStringPairs("a", "1", "b", "2", "c", "3", "d", "4");
        assertSame(Tags.EMPTY, Tags.ofStringPairs((String[]) null));
    public void testConcatHashConsistency() {
    }
        Tags a = Tags.ofStringPairs("a", "old_a", "b", "old_b");
        assertEquals(2, merged.size());
    public void testEmptyGetTagsMapReturnsEmptyMap() {
        assertEquals("a", merged.getKey(0));
import org.opensearch.test.OpenSearchTestCase;
        Tags merged = Tags.concat(a, b);
/*
        assertEquals("new_b", merged.getValue(1));
    }
}
        assertEquals("a", t.getKey(0));
    public void testConcatPartialOverlapMergesAndDeduplicates() {
        assertEquals(1, merged.size());
    }
    }
        Tags t = Tags.create().addTag("flag", true);
    public void testConcatLargeRemainderPath() {
    }
 * this file be licensed under the Apache-2.0 license or a
        Tags b = Tags.of("b", "2");
        assertSame(a, Tags.concat(null, a));
        assertEquals(1, t.size());
        assertEquals(1, t.size());
    public void testOfStringPairsEmpty() {
        Tags t = Tags.create().addTag("k", "old").addTag("k", "new");
    public void testConcatEmptyWithNullReturnsEmpty() {
        Tags a = Tags.of("k", "v");
    }
        map.put("a", "1");
    public void testOfBoolean() {
        Tags t = Tags.create().addTag("val", 3.14);
        assertNotEquals(a, b);
        assertEquals(3.14, t.getValue(0));
        assertSame(Tags.EMPTY, Tags.create());
    }
import java.util.HashMap;
        assertEquals("env", t.getKey(0));
        assertEquals(viaOfStringPairs, viaConcat);
package org.opensearch.telemetry.metrics.tags;
        Tags updated = original.addTag("k", "v");
    public void testConcatResultIsSorted() {
    public void testGetTagsMapPreservesOriginalTypes() {
    }
        Tags merged = Tags.concat(a, b);
    public void testFromMapNullValueThrows() {
    // --- toString ---
        assertEquals("found", map.get(t2));
    public void testConcatInterleavedNoOverlap() {
    }
        assertEquals("m", t.getKey(1));
        Tags a = Tags.of("z", "26");
    public void testAddTagChaining() {
    public void testDifferentTagsAreNotEqual() {
    public void testEmptyEqualsEmpty() {
        assertEquals("b", merged.getKey(1));
    public void testNotEqualToNonTagsObject() {
        Tags viaOfStringPairs = Tags.ofStringPairs("a", "1", "b", "2");
    // --- concat ---
        assertEquals("b", merged.getKey(1));
        assertEquals(3, t.size());
    public void testAddTagReturnsNewInstance() {
        assertEquals(5, merged.size());
        Tags t = Tags.create().addTag("num", 42L);
    public void testConcatMergesTwoTags() {
        Map<String, String> map = new HashMap<>();
        assertSame(Tags.EMPTY, Tags.fromMap(Map.of()));
        Tags t1 = Tags.of("k", "v");
        assertEquals(1, updated.size());
        Map<String, String> map = new HashMap<>();
    public void testOfNullKeyThrows() {
        assertEquals(true, t.getValue(0));
        assertEquals(3, t.size());
        assertEquals("2", merged.getValue(1));
    }
        assertEquals(2, merged.size());
    }
        Tags b = Tags.ofStringPairs("b", "2", "d", "4");
        Tags t2 = Tags.of("k", "v");
    }
    }
    // --- of(key, value) ---
        Tags b = Tags.ofStringPairs("a", "new_a", "b", "new_b");
    }
        Tags b = Tags.of("k", "new");
        assertEquals("a", t.getKey(0));
 */
        assertEquals("new", t.getValue(0));
    public void testToStringWithTags() {
    // --- Deprecated API backward compatibility ---
        Tags b = Tags.ofStringPairs("x", "1", "y", "2");
        assertEquals(42L, t.getValue(0));
    }
 *
    public void testNotEqualToNull() {
        assertEquals(0, Tags.EMPTY.size());
        assertEquals("c", t.getKey(2));
    public void testUsableAsMapKey() {
        assertEquals(1, t.size());
        expectThrows(NullPointerException.class, () -> Tags.of("k", (String) null));
    }
        Tags t = Tags.of("a", "1");
        Tags t = Tags.ofStringPairs("z", "1", "a", "2", "m", "3");
        map.put("b", "2");
    }
        assertEquals("1", t.getValue(0));
        Tags t = Tags.of("env", "prod");
    public void testConcatBothNullReturnsEmpty() {
        assertSame(Tags.EMPTY, Tags.ofStringPairs(new String[0]));
    public void testOfDouble() {
    }
    public void testConcatBWinsOnCollision() {
    public void testConcatWithEmptyReturnsOther() {
        Tags a = Tags.of("k", "v");
        Tags a = Tags.of("x", "1");
    public void testOfNullValueThrows() {
    }
        expectThrows(IllegalArgumentException.class, () -> Tags.ofStringPairs("a", "b", "c"));
        assertEquals("d", merged.getKey(3));
    public void testToStringEmpty() {
    }
        assertEquals("2", t.getValue(1));
