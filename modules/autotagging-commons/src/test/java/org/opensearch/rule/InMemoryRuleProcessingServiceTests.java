        assertTrue(label.isPresent());
    public void testRemove() {
import org.opensearch.rule.autotagging.FeatureType;
            }
 *
    }
                return extractedAttributes;
        Optional<String> label = sut.evaluateLabel(extractors);
    public void testEvaluateLabelForNoMatch() {
import static org.opensearch.rule.attribute_extractor.AttributeExtractor.LogicalOperator.OR;
        sut.remove(wildcardRule);
import org.opensearch.rule.storage.DefaultAttributeValueStore;
        sut.add(getRule(Set.of("test1*", "change"), "test_id"));
        // Two wildcard rules both prefix-match the request; the one with the longer matching prefix scores higher and wins.
    public enum TestAttribute implements Attribute {
        Optional<String> label = sut.evaluateLabel(extractors);
        sut.add(getRule(Set.of("test", "double"), "test_id1"));
        assertFalse(label.isPresent());
        Optional<String> label = sut.evaluateLabel(extractors);
        sut.add(getRule(Set.of("test1", "change"), "test_id"));
        assertTrue(label.isPresent());
        extractors.add(new AttributeExtractor<String>() {
        sut.add(getRule(Set.of("key12", "double"), "test_id1"));
        @Override
import java.util.Map;
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("testing"));
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("key1", "key2"));
        assertFalse(label.isPresent());
        Optional<String> label = sut.evaluateLabel(extractors);
 * SPDX-License-Identifier: Apache-2.0
    InMemoryRuleProcessingService sut;
        sut.add(getRule(Set.of("test*"), "short_prefix"));
    }
        assertEquals("prefix_group", sut.evaluateLabel(getAttributeExtractors(List.of("my-index"))).orElse(null));
        public void validateAttribute() {}
import org.opensearch.rule.autotagging.Attribute;
        assertEquals("prefix_group", sut.evaluateLabel(getAttributeExtractors(List.of("my-index-1"))).orElse(null));
        Optional<String> label = sut.evaluateLabel(extractors);
        sut.add(wildcardRule);
        Optional<String> label = sut.evaluateLabel(extractors);
        );
        super.setUp();
        Optional<String> label = sut.evaluateLabel(extractors);
        return new Rule(
    private static Rule getRule(Set<String> attributeValues, String label) {
            public LogicalOperator getLogicalOperator() {
    }
    public void testRemoveExactValueLeavesSiblingWildcardValue() {
 */
    public void testEvaluateLabelForExactMatch() {
    public void testAdd() {
        // A value stored without a trailing wildcard is matched exactly, so a longer request does not match.
        sut.add(getRule(Set.of("test1", "change"), "test_id"));
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
        sut.add(getRule(Set.of("key2", "double"), "new_id"));
    public enum WLMFeatureType implements FeatureType {
    public void setUp() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rule.autotagging.AutoTaggingRegistry;
import java.util.Optional;
import org.opensearch.test.OpenSearchTestCase;
}
        public String getName() {
            return Map.of(TestAttribute.TEST_ATTRIBUTE, 1);
            DefaultAttributeValueStore::new
            "test description",
        TestAttribute(String name) {
    }
            return "wlm";
        assertFalse(label.isPresent());
        });
    private static List<AttributeExtractor<String>> getAttributeExtractors(List<String> extractedAttributes) {
        sut.add(getRule(Set.of("testi*"), "long_prefix"));
package org.opensearch.rule;
        sut.remove(exactRule);
    }
        }
        assertFalse(label.isPresent());
        assertEquals("test_id1", label.get());
    }
        @Override
import java.util.List;
            AutoTaggingRegistry.registerFeatureType(WLM);
        }
            @Override
                return TestAttribute.TEST_ATTRIBUTE;
        static {
        private final String name;
        sut.remove(rule);
        @Override
        // Exact "my-index" and wildcard "my-index*" are stored under distinct keys; removing the exact rule must
    }
        assertTrue(label.isPresent());
    }
        Optional<String> label = sut.evaluateLabel(extractors);
    }
    public void testEvaluateLabelForLongestWildcardPrefixWins() {
import org.opensearch.rule.storage.AttributeValueStoreFactory;
        Rule rule = getRule(Set.of("test", "change"), "test_id");
        Rule exactRule = getRule(Set.of("my-index"), "exact_group");
    }
            @Override
        // not remove the wildcard rule (the pre-fix code stripped '*', conflating the two keys).
        assertFalse(label.isPresent());
 * compatible open source license.
        assertEquals("test_id1", label.get());
        assertEquals("long_prefix", label.get());
    }
                return OR;
        Rule wildcardRule = getRule(Set.of("my-index*"), "prefix_group");
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("key"));
        INVALID_ATTRIBUTE("invalid_attribute");
        public String getName() {
        sut.add(exactRule);
public class InMemoryRuleProcessingServiceTests extends OpenSearchTestCase {
        List<AttributeExtractor<String>> extractors = new ArrayList<>();
        sut.add(getRule(Set.of("test*", "double"), "test_id1"));
        sut.add(getRule(Set.of("test", "change"), "test_id"));
        // The wildcard rule still matches both the exact stem and a longer index.
/*
        sut.add(rule);
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("test-index"));
    public void testEvaluateLabelForExactMatchWithLongestMatchingPrefixCase() {
            label,
        Optional<String> label = sut.evaluateLabel(extractors);
        sut.remove(rule);
    public void testAddThenRemoveWithWildcard() {
    }
        return extractors;
        Optional<String> label = sut.evaluateLabel(extractors);
        Rule rule = getRule(Set.of("test-*"), "test_id");
            }
import java.util.ArrayList;
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("test"));
        assertTrue(label.isPresent());
            }
            this.name = name;
            public Attribute getAttribute() {
        sut.add(getRule(Set.of("key1", "change"), "test_id"));
    }
            WLMFeatureType.WLM,
            @Override
        assertEquals("test_id", label.get());
        sut.add(getRule(Set.of("key1", "change"), "test_id"));
            "2025-02-24T07:42:10.123456Z"
    public void testEvaluateLabelForExactValueDoesNotPrefixMatch() {
        assertFalse(label.isPresent());
            WLMFeatureType.WLM,
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("dummy_test"));
    }
        }
        );
        TEST_ATTRIBUTE("test_attribute"),
        WLM;
            public Iterable<String> extract() {
        sut.add(getRule(Set.of("test", "double"), "test_id"));
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("test"));
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("testing"));
        public Map<Attribute, Integer> getOrderedAttributes() {
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("testing"));
        sut.add(rule);
        }
import org.opensearch.rule.autotagging.Rule;
        sut.add(getRule(Set.of("test", "change"), "test_id"));
        sut = new InMemoryRuleProcessingService(attributeValueStoreFactory, WLMFeatureType.WLM.getOrderedAttributes());
    public void testEvaluateLabelForMultiMatch() {
        }
 * The OpenSearch Contributors require contributions made to
    public void testEvaluateLabelForNoMatchWithLongestMatchingPrefixCase() {
        List<AttributeExtractor<String>> extractors = getAttributeExtractors(List.of("test"));
    }
            return name;
            randomAlphaOfLength(5),
        AttributeValueStoreFactory attributeValueStoreFactory = new AttributeValueStoreFactory(
    }
            Map.of(TestAttribute.TEST_ATTRIBUTE, attributeValues),
        assertFalse(sut.evaluateLabel(getAttributeExtractors(List.of("my-index-1"))).isPresent());
import java.util.Set;
        @Override
