        assertEquals("d", merged.getKey(3));
    }
        assertEquals("b", t.getKey(1));
            assertTrue(merged.getKey(i).compareTo(merged.getKey(i + 1)) < 0);
        Tags b = Tags.ofStringPairs("a", "1", "b", "2", "c", "3", "d", "4");
        assertEquals(3, t.size());
        Tags b = Tags.ofStringPairs("k", "v", "k2", "v2");
        assertEquals(a.hashCode(), b.hashCode());
        assertEquals(2, merged.size());  
    public void testDifferentSizeNotEqual() {  
    // --- of(key, value) ---  
        Tags b = Tags.ofStringPairs("b", "2", "c", "4");  
        Tags a = Tags.ofStringPairs("a", "1", "c", "3");
        for (int i = 0; i < merged.size() - 1; i++) {  
        Tags merged = Tags.concat(a, b);
        assertSame(a, Tags.concat(a, Tags.EMPTY));
        assertEquals(3, merged.size());
        assertEquals(1, merged.size());
        assertEquals("1", merged.getValue(0));
    }
    // --- fromMap ---
        assertEquals("a", merged.getKey(0));
        Tags original = Tags.create();  
    public void testConcatFullOverlapBWins() {
        assertEquals(2, merged.size());
        assertEquals("new_a", merged.getValue(0));
        assertEquals(5, merged.size());  
    }
    }  
    public void testNotEqualToNonTagsObject() {
        Tags a = Tags.of("k", "old");
    }
    public void testDifferentTagsAreNotEqual() {
    }
    }  
        assertEquals("d", merged.getKey(3));
        Map<String, String> map = new HashMap<>();
        assertEquals("Tags{}", Tags.EMPTY.toString());  
    }
        Tags merged = Tags.concat(a, b);
    }
        assertEquals("e", merged.getKey(4));
        assertNotSame(original, updated);
        assertEquals("c", t.getKey(2));  
        assertEquals("z", merged.getKey(4));  
        assertEquals("1", t.getValue(0));  
        Tags t = Tags.ofStringPairs("z", "1", "a", "2", "m", "3");  
        assertEquals("b", merged.getKey(1));  
        Tags t = Tags.of("env", "prod");  
        assertEquals("b", merged.getKey(1));
        assertNotEquals(a, b);
    }
    public void testEmptyHasZeroSize() {
        Tags viaConcat = Tags.concat(Tags.of("a", "1"), Tags.of("b", "2"));  
        assertEquals("z", t.getKey(2));
        assertEquals(t, t);
    }  
        assertEquals(1, t.size());
        assertEquals("env", t.getKey(0));
        Tags b = Tags.ofStringPairs("x", "1", "y", "2");
    public void testOfStringPairsNull() {  
        Tags updated = original.addTag("k", "v");
    }
        assertEquals("new", t.getValue(0));  
        assertEquals("retries", t.getKey(0));
        Tags t = Tags.fromMap(map);
    public void testConcatInterleavedNoOverlap() {
    public void testAddTagBoolean() {  
    public void testOfStringPairsOddLengthThrows() {
        assertNotEquals(a, b);  
        expectThrows(IllegalArgumentException.class, () -> Tags.ofStringPairs("a", "b", "c"));
    public void testOfSingleTag() {
    }
        assertEquals("a", merged.getKey(0));
        Tags a = Tags.ofStringPairs("x", "1", "y", "2");
    public void testNotEqualToNull() {
 * compatible open source license.
    }
public class TagsTests extends OpenSearchTestCase {  
        assertSame(a, Tags.concat(Tags.EMPTY, a));
    }  
        Tags merged = Tags.concat(a, b);
    }
        Tags b = Tags.ofStringPairs("b", "2", "d", "4");
    }  
        assertEquals(1, updated.size());
    }
    public void testToStringWithTags() {  
        assertEquals(1, t.size());
    // --- concat ---
        assertEquals(1, t.size());
        assertSame(Tags.EMPTY, Tags.fromMap(null));
        Tags t = Tags.of("num", 42L);  
    }
        assertEquals("b", merged.getKey(1));
        assertEquals("b", t.getKey(1));
        Tags merged = Tags.concat(a, b);  
        assertEquals("26", merged.getValue(4));
        assertSame(Tags.EMPTY, Tags.ofStringPairs((String[]) null));
    // --- equals / hashCode ---
        assertEquals(1, t.size());
    }
        Tags b = Tags.of("k", "new");
        map.put("a", "1");
        assertEquals(viaOfStringPairs, viaConcat);
        assertEquals("2", t.getValue(1));
    public void testFromMapNullReturnsEmpty() {
    }  
        map.put("k", null);
        assertEquals(0, Tags.EMPTY.size());
    }
        assertSame(Tags.EMPTY, Tags.create());
        assertEquals("a", t.getKey(0));
        assertEquals(1, t.size());
    public void testUsableAsMapKey() {
    }
    public void testAddTagReturnsNewInstance() {
    }
    }
        Tags t = Tags.of("enabled", true);
        Tags merged = Tags.concat(a, b);
        Tags a = Tags.of("k", "v");  
    }
        assertEquals("found", map.get(t2));
    }  
        expectThrows(NullPointerException.class, () -> Tags.of(null, "v"));
        assertEquals(42L, t.getTagsMap().get("num"));
        assertEquals("prod", t.getValue(0));  
        Tags a = Tags.of("k", "v");
        Tags t = Tags.create().addTag("k", "old").addTag("k", "new");
/*  
        Tags t = Tags.create().addTag("num", 42L);
    // --- toString ---  
    }
    }  
    // --- EMPTY ---
        assertEquals(1, t.size());
        expectThrows(NullPointerException.class, () -> Tags.fromMap(map));  
    // --- Concurrent safety: Tags is immutable so no sharing issues ---  
        assertNotEquals(Tags.of("k", "v"), null);
        Tags a = Tags.of("x", "1");
    // --- ofStringPairs(varargs) ---  
    public void testOfNullValueThrows() {
    public void testIdentityEquals() {
        assertEquals("Tags{a=1}", t.toString());
        assertEquals(3, t.size());  
    }
        assertEquals(viaOfStringPairs.hashCode(), viaConcat.hashCode());
        assertEquals(Tags.EMPTY, Tags.create());
        assertEquals(1, t.size());
    }  
    public void testConcatPartialOverlapMergesAndDeduplicates() {
        assertEquals(5, merged.size());  
    public void testOfStringPairsEmpty() {
    }
    public void testEmptyGetTagsMapReturnsEmptyMap() {
        Tags t = Tags.of("k", "v");  
    public void testAddTagDouble() {  
        assertEquals("new_b", merged.getValue(1));
        Tags t2 = Tags.of("k", "v");
    }
        Tags b = Tags.ofStringPairs("a", "2", "m", "3");
    public void testGetTagsMapPreservesOriginalTypes() {
    public void testFromMapEmptyReturnsEmpty() {
    public void testCreateReturnsEmpty() {
    }
        assertEquals(2, t.size());  
        Tags viaOfStringPairs = Tags.ofStringPairs("a", "1", "b", "2");
        assertEquals(0, original.size());  
        Tags merged = Tags.concat(a, b);
    public void testConcatBWinsOnCollision() {  
        Tags t = Tags.create().addTag("flag", true);
        map.put(t1, "found");  
        Tags b = Tags.of("x", "2");  
        Map<Tags, String> map = new HashMap<>();
    public void testAddTagLong() {  
        assertEquals("c", merged.getKey(2));  
    }  
        Tags merged = Tags.concat(a, b);  
        Tags t = Tags.of("a", "1");
 * The OpenSearch Contributors require contributions made to  
}  
    public void testOfBoolean() {  
import java.util.Map;
        Tags a = Tags.of("z", "26");  
        assertEquals("m", t.getKey(1));  
package org.opensearch.telemetry.metrics.tags;
        assertNotEquals(Tags.of("k", "v"), "not a Tags");  
    public void testConcatResultIsSorted() {
    public void testAddTagChaining() {
    }  
    public void testOfNullKeyThrows() {  
        assertEquals(true, t.getValue(0));  
        Tags a = Tags.of("a", "1");
    public void testConcatLargeRemainderPath() {
        Tags t = Tags.create().addTag("a", "1").addTag("b", "2").addTag("c", "3");
        assertEquals("a", t.getKey(0));
    public void testOfStringPairsSorted() {
    public void testConcatBothNullReturnsEmpty() {
    }  
    public void testAddTagOverwritesPreviousValue() {  
        assertSame(Tags.EMPTY, Tags.fromMap(Map.of()));  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("c", merged.getKey(2));
    }  
 *
    public void testConcatWithNullReturnsOther() {
        assertEquals("4", merged.getValue(2));
        Tags a = Tags.of("k", "v");  
    // --- getTagsMap ---  
    }  
        assertEquals("a", t.getKey(0));
    public void testFromMapNullValueThrows() {  
        assertSame(Tags.EMPTY, Tags.concat(Tags.EMPTY, null));
    public void testConcatEmptyWithNullReturnsEmpty() {  
    public void testOfLong() {
    }
        Tags b = Tags.of("b", "2");
    }
        assertEquals(true, t.getValue(0));  
        assertSame(Tags.EMPTY, Tags.concat(null, null));  
        Tags a = Tags.ofStringPairs("a", "1", "c", "3", "e", "5");  
        Tags a = Tags.ofStringPairs("a", "old_a", "b", "old_b");  
        assertSame(a, Tags.concat(a, null));
    }
    public void testEmptyEqualsEmpty() {
        assertEquals(a, b);  
    }  
        assertEquals("a", merged.getKey(0));  
    }
        Tags a = Tags.of("x", "1");  
    public void testConcatHashConsistency() {
        Tags t = Tags.create().addTag("val", 3.14);
    public void testOfDouble() {  
    // --- Deprecated API backward compatibility ---
 * this file be licensed under the Apache-2.0 license or a
        Map<String, String> map = new HashMap<>();
        assertEquals(1, t.size());
        Tags b = Tags.ofStringPairs("a", "new_a", "b", "new_b");
        expectThrows(NullPointerException.class, () -> Tags.of("k", (String) null));
 */  
    public void testConcatWithEmptyReturnsOther() {
    public void testToStringEmpty() {
        Tags t1 = Tags.of("k", "v");  
        assertEquals(3L, t.getValue(0));  
        }
import java.util.HashMap;  
    }  
        assertEquals("2", merged.getValue(1));  
    public void testConcatMergesTwoTags() {  
        map.put("b", "2");  
        assertEquals("a", merged.getKey(0));
        assertEquals(42L, t.getValue(0));  
        assertEquals(1.5, t.getValue(0));  
    }
        assertSame(Tags.EMPTY, Tags.ofStringPairs(new String[0]));  
        assertTrue(Tags.EMPTY.getTagsMap().isEmpty());  
        assertEquals(3.14, t.getValue(0));  
        Tags t = Tags.of("latency", 1.5);
        assertEquals("new", merged.getValue(0));
    public void testEqualTagsAreEqual() {  
 * SPDX-License-Identifier: Apache-2.0
        Tags t = Tags.of("retries", 3L);  
        assertSame(a, Tags.concat(null, a));
    public void testFromMapRoundTrips() {
