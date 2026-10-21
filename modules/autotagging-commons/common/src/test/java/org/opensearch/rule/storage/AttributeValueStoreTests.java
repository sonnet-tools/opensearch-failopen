        }
        assertEquals(Set.of("no_constraint"), extractFeatureValues(subjectUnderTest.getMatches("")));
            @Override
    public void testBareWildcardValueMatchesEveryNonEmptyRequest() {
        subjectUnderTest.put("fox", "lucy");
            readerThreads.get(i).start();
    }
        assertTrue(result.isEmpty());
            }
        }
    }
    public void testGetWhenNoProperPrefixIsPresent() {
        List<MatchLabel<String>> exactMatches = store.getExactMatch("foo");
    }
            } catch (InterruptedException ignored) {}
 * compatible open source license.
        public void run() {
    public static String generateRandom(int maxLength) {
/*
    private Set<String> extractFeatureValues(List<MatchLabel<String>> labels) {
        subjectUnderTest.put("foo", "sing");
                    subjectUnderTest.getMatches(key);
    public void testPut() {
        private final List<String> toWriteKeys;
import java.util.Set;
    public void testGet() {
        assertTrue(subjectUnderTest.getMatches("foxtail").isEmpty());
        return labels.stream().map(MatchLabel::getFeatureValue).collect(Collectors.toSet());
        store.remove("foo", "bar");
        subjectUnderTest.put("fox", "exact");
        private final List<String> toReadKeys;
        assertEquals(Set.of("exact", "prefix"), extractFeatureValues(subjectUnderTest.getMatches("fox")));
    AttributeValueStore<String, String> subjectUnderTest;
        class DummyStore implements AttributeValueStore<String, String> {
            try {
    public void testExactValueDoesNotPrefixMatch() {
        assertTrue(subjectUnderTest.getMatches("fo").isEmpty());
        subjectUnderTest = new DefaultAttributeValueStore<>(new PatriciaTrie<>());
        StringBuilder sb = new StringBuilder(length);
            boolean removeCalled = false;
        assertTrue(subjectUnderTest.getMatches("foo").isEmpty());
        @Override
                }
        // Stem "fox" (length 3) over request "fox*" (length 4) scores 0.75; without the exact-branch guard the
        assertTrue(extractFeatureValues(subjectUnderTest.getMatches("foo")).contains("bar"));
        for (int i = 0; i < 100; i++) {
            sb.append(ALPHA_NUMERIC.charAt(random().nextInt(ALPHA_NUMERIC.length())));
        subjectUnderTest.put("fox*", "lucy");
        subjectUnderTest.put("fox", "exact");
        // A wildcard request key must not exact-match a non-wildcard stored value of the same stem.
        assertEquals(Set.of("lucy"), extractFeatureValues(subjectUnderTest.getMatches("fox*")));
        assertEquals(0, subjectUnderTest.size());
        for (int i = 0; i < 10; i++) {
 * this file be licensed under the Apache-2.0 license or a
            readerThreads.add(new AttributeValueStoreReader(subjectUnderTest, randomStrings));
        assertEquals(2, subjectUnderTest.getMatches("foo").size());
        subjectUnderTest.put("foo", "bar");
        assertEquals(0.75f, matches.get(0).getMatchScore(), 0.0f);
}
        subjectUnderTest.put("foo", "sing");
    private static class AttributeValueStoreWriter extends Thread {
    public void testExactAndWildcardValuesWithSameStemAreDistinct() {
        assertEquals(1, matches.size());
        subjectUnderTest.put("foo", "bar");
    }
                return 0;
        List<Thread> writerThreads = new ArrayList<>();
    }
        List<MatchLabel<String>> matches = subjectUnderTest.getMatches("anything");
        assertNotNull(exactMatches);
public class AttributeValueStoreTests extends OpenSearchTestCase {
        assertEquals(0f, subjectUnderTest.getMatches("anything").get(0).getMatchScore(), 0.0f);
        }
        List<MatchLabel<String>> matches = subjectUnderTest.getMatches("fox*");
                    subjectUnderTest.put(key, key);
        assertEquals("no_constraint", matches.get(0).getFeatureValue());
        }
import org.apache.commons.collections4.trie.PatriciaTrie;
        assertEquals(Set.of("prefix"), extractFeatureValues(subjectUnderTest.getMatches("foxtail")));
            try {
        assertTrue(extractFeatureValues(subjectUnderTest.getMatches("fox")).contains("lucy"));
    public void testClear() {
        // Values stored under the empty key represent "no constraint" and must match any request key at score 0.
    }
    public void testConcurrentUpdatesAndReads() {
            writerThreads.add(new AttributeValueStoreWriter(subjectUnderTest, randomStrings));
    }
        assertTrue(subjectUnderTest.getMatches("foxtail").isEmpty());
                return Optional.empty();
import java.util.List;
    private static class AttributeValueStoreReader extends Thread {
            public void remove(String key) {
        super.setUp();
            @Override
        subjectUnderTest.put("foodip", "sing");
    public void setUp() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
    }
    }
import org.opensearch.rule.MatchLabel;
    public void testWildcardRequestKeyMatchesWildcardValueOnce() {
 * The OpenSearch Contributors require contributions made to
                for (String key : toReadKeys) {
        assertTrue(subjectUnderTest.getMatches("").isEmpty());
        return sb.toString();
        // This pins the explicit empty-key lookup in getMatches; without it, unconstrained-attribute rules stop matching.
import java.util.Optional;
        // Request "fox" matches the exact value (score 1.0) and the wildcard stem (score 1.0).
        }
            public void put(String key, String value) {}
        assertNotNull(result);
        assertTrue(extractFeatureValues(subjectUnderTest.getMatches("foo")).contains("bar"));
        subjectUnderTest.put("fox*", "lucy");
        // A value stored with a trailing wildcard matches both the exact stem and longer values.
        List<Thread> readerThreads = new ArrayList<>();
        assertTrue(extractFeatureValues(subjectUnderTest.getMatches("fox")).contains("lucy"));
            randomStrings.add(generateRandom(20));
        final List<String> randomStrings = new ArrayList<>();
            }
        subjectUnderTest.put("foo", "bar");
                removeCalled = true;
        assertEquals(0, subjectUnderTest.size());
            public Optional<String> get(String key) {
    public void testRemove() {
        DummyStore store = new DummyStore();
        @Override
        assertEquals("lucy", matches.get(0).getFeatureValue());
                for (String key : toWriteKeys) {
        assertTrue(extractFeatureValues(subjectUnderTest.getMatches("foo")).contains("sing"));
 *
import java.util.stream.Collectors;
    }
            this.toWriteKeys = toWriteKeys;
            @Override
            writerThreads.get(i).start();
        assertTrue(store.removeCalled);
            public int size() {
        // only once (via the prefix branch), not additionally via an exact match, to avoid inflating score.
import org.opensearch.test.OpenSearchTestCase;
import java.util.ArrayList;
            @Override
    }
        private final AttributeValueStore<String, String> subjectUnderTest;
            }
        assertEquals(Set.of("catch_all"), extractFeatureValues(subjectUnderTest.getMatches("anything")));
        subjectUnderTest.put("foo", "bar");
            this.subjectUnderTest = subjectUnderTest;
        subjectUnderTest.put("foo", "bar");
        subjectUnderTest.put("fox*", "prefix");
        assertTrue(subjectUnderTest.getMatches("foo").isEmpty());
    }
    }
        List<MatchLabel<String>> result = store.getMatches("foo");
            } catch (InterruptedException e) {}
        assertTrue(exactMatches.isEmpty());
    public void testEmptyKeyValueMatchesEveryRequestAsNoConstraint() {
        public void run() {
        // A longer request matches only the wildcard value.
        // "fox" (exact) and "fox*" (prefix) are stored under distinct keys and matched independently.
        assertEquals(1, matches.size());
                Thread.sleep(random().nextInt(100));
        // A wildcard value "fox*" prefix-matches the request "foxtail".
        }
        // A bare "*" value (valid per RuleValidator) is reached via the shrinking-prefix loop at the empty prefix,
    }
        for (int i = 0; i < length; i++) {
package org.opensearch.rule.storage;
        AttributeValueStoreReader(AttributeValueStore<String, String> subjectUnderTest, List<String> toReadKeys) {
            this.toReadKeys = toReadKeys;
    @Override
    }
            @Override
        assertTrue(extractFeatureValues(subjectUnderTest.getMatches("foxtail")).contains("lucy"));
    public void testWildcardValuePrefixMatches() {
                }
        private final AttributeValueStore<String, String> subjectUnderTest;
        assertEquals(0f, matches.get(0).getMatchScore(), 0.0f);
        }
    }
 */
        AttributeValueStoreWriter(AttributeValueStore<String, String> subjectUnderTest, List<String> toWriteKeys) {
            this.subjectUnderTest = subjectUnderTest;
        // so it matches every non-empty request key at score 0, but does not match an empty request key.
        subjectUnderTest.clear();
        int length = random().nextInt(maxLength) + 1;
    }
    public void testDefaultMethods() {
        // A value stored without a trailing wildcard is matched exactly, not as a prefix.
        }
    final static String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        subjectUnderTest.put("", "no_constraint");
        subjectUnderTest.remove("foo", "bar");
        assertFalse(subjectUnderTest.getMatches("foxtail").isEmpty());
        subjectUnderTest.put("*", "catch_all");
        assertTrue(extractFeatureValues(subjectUnderTest.getMatches("foo")).contains("sing"));
        subjectUnderTest.put("fox*", "lucy");
        }
        assertEquals(2, subjectUnderTest.getMatches("foo").size());
            public void clear() {}
        for (int i = 0; i < 10; i++) {
        // exact hit on "fox*" would add a second 1.0 match and the caller's score summation would inflate it.
        // A request key that is itself a wildcard expression ("fox*") must match a stored "fox*" value
    }
                Thread.sleep(random().nextInt(100));
