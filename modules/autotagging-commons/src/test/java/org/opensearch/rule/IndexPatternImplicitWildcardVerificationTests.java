        AttributeValueStoreFactory factory = new AttributeValueStoreFactory(IndexFeatureType.INSTANCE, DefaultAttributeValueStore::new);
        assertFalse(evaluateForIndex(sut, "my-index").isPresent());
            @Override  
        return new Rule(  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        // A longer index matches only the wildcard rule.
        InMemoryRuleProcessingService sut = newService();
        public Map<Attribute, Integer> getOrderedAttributes() {
        assertTrue(exact.isPresent());  
import org.opensearch.rule.autotagging.Rule;
        return new InMemoryRuleProcessingService(factory, IndexFeatureType.INSTANCE.getOrderedAttributes());
    }
        return sut.evaluateLabel(extractors);
        assertEquals("groupExact", exact.get());
            }
import java.util.Optional;
import org.opensearch.rule.storage.DefaultAttributeValueStore;
            return Map.of(RuleAttribute.INDEX_PATTERN, 1);
        sut.add(indexRule("my-index", "groupA"));
        InMemoryRuleProcessingService sut = newService();
package org.opensearch.rule;
import static org.opensearch.rule.attribute_extractor.AttributeExtractor.LogicalOperator.AND;
            AutoTaggingRegistry.registerFeatureType(INSTANCE);
import java.util.List;
            "rule_" + group,
import org.opensearch.test.OpenSearchTestCase;
    }
        // score, so the exact rule wins.
        Optional<String> label = evaluateForIndex(sut, "my-index");
    }
                return List.of(requestIndex);
import org.opensearch.rule.autotagging.FeatureType;
    }
        Optional<String> exact = evaluateForIndex(sut, "my-index");
}  
        sut.add(indexRule("my-index*", "groupA"));
                return RuleAttribute.INDEX_PATTERN;  
 * SPDX-License-Identifier: Apache-2.0
        sut.add(indexRule("my-index", "groupA"));  
    public void testExactRuleWinsOverShorterPrefixRule() {
                return AND;
    private Optional<String> evaluateForIndex(InMemoryRuleProcessingService sut, String requestIndex) {
import java.util.Map;  
        InMemoryRuleProcessingService sut = newService();
            IndexFeatureType.INSTANCE,
        @Override  
    public void testExactIndexPatternMatchesExactRequestIndex() {  
 *
import org.opensearch.rule.autotagging.Attribute;
import java.util.ArrayList;
        @Override
        }  
        InMemoryRuleProcessingService sut = newService();
        assertEquals("groupA", prefixed.get());
        Optional<String> longer = evaluateForIndex(sut, "my-index-1");
 */  
 * Tests that an index_pattern rule matches by prefix only when its value ends in a wildcard,
        sut.add(indexRule("my-index*", "groupPrefix"));
        sut.add(indexRule("my-index", "groupExact"));  
        }
    }  
            }
            "2025-02-24T07:42:10.123456Z"  
            return "index_verification_feature";  
import java.util.Set;
        );
        // Exact rule "my-index" must NOT match a longer index that merely shares the prefix.
 * and matches exactly otherwise.
        assertEquals("groupPrefix", longer.get());
            public LogicalOperator getLogicalOperator() {  
        InMemoryRuleProcessingService sut = newService();
            "rule for " + indexPattern,
/*  
        });  
 */  
        sut.add(indexRule("my-index", "groupExact"));  
    private InMemoryRuleProcessingService newService() {  
    }
    public enum IndexFeatureType implements FeatureType {  
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
    public void testExactRuleAndEqualStemWildcardRuleTie() {
            Map.of(RuleAttribute.INDEX_PATTERN, Set.of(indexPattern)),  
    }
        static {  
        INSTANCE;
        assertFalse(evaluateForIndex(sut, "my-index-1").isPresent());  
        }
        // Request "my-index" matches the exact rule (1.0) and the wildcard rule "my-index*" whose stem  
            group,
            public Iterable<String> extract() {
    }
        sut.add(indexRule("my*", "groupPrefix"));
        // Request "my-index" matches the exact rule at score 1.0 and the shorter prefix "my*" at a lower  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(label.isPresent());
        assertEquals("groupA", label.get());  
        assertEquals("groupA", exact.get());  
            }  
        extractors.add(new AttributeExtractor<>() {  
        List<AttributeExtractor<String>> extractors = new ArrayList<>();
        Optional<String> prefixed = evaluateForIndex(sut, "my-index-1");
            @Override
        Optional<String> exact = evaluateForIndex(sut, "my-index");
    }
import org.opensearch.rule.autotagging.AutoTaggingRegistry;  
            public Attribute getAttribute() {
        // equals the request (also 1.0). The scores tie and cannot be broken, so no group is assigned.
        assertTrue(longer.isPresent());  
import org.opensearch.rule.storage.AttributeValueStoreFactory;  
    public void testWildcardIndexPatternMatchesByPrefix() {  
        public String getName() {
    private Rule indexRule(String indexPattern, String group) {
public class IndexPatternImplicitWildcardVerificationTests extends OpenSearchTestCase {
/**  
        assertTrue(exact.isPresent());
        assertTrue(prefixed.isPresent());  
            @Override
    public void testExactIndexPatternDoesNotMatchLongerRequestIndex() {
