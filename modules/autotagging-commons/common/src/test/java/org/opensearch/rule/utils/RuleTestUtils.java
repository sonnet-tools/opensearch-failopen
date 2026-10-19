    public static final Map<Attribute, Set<String>> ATTRIBUTE_MAP = Map.of(  
import org.opensearch.rule.autotagging.AutoTaggingRegistry;
    public static final String ATTRIBUTE_VALUE_TWO = "mock_attribute_two";
    public static final String TIMESTAMP_ONE = "2024-01-26T08:58:57.558Z";  
import java.util.Comparator;  
    public static final String FEATURE_TYPE_NAME = "mock_feature_type";  
    public static void assertEqualRule(Rule one, Rule two, boolean ruleUpdated) {  
import org.opensearch.rule.autotagging.FeatureType;  
            AutoTaggingRegistry.registerFeatureType(INSTANCE);
import java.util.Map;
        .updatedAt(TIMESTAMP_TWO)
import java.util.Set;  
        }
        MOCK_RULE_ATTRIBUTE_ONE(ATTRIBUTE_VALUE_ONE),
import org.opensearch.rule.autotagging.Rule;
    public static final String SEARCH_AFTER = "search_after";
        public String getName() {
            assertEquals(one.getAttributeMap(), two.getAttributeMap());  
        public String getName() {  
        for (int i = 0; i < mapOne.size(); i++) {
            assertEquals(one.getDescription(), two.getDescription());
 * The OpenSearch Contributors require contributions made to  
    public static final String FEATURE_VALUE_ONE = "feature_value_one";  
        } else {
            MockRuleAttributes.MOCK_RULE_ATTRIBUTE_TWO,  
            assertEquals(one, two);
            return PRIORITIZED_ATTRIBUTES;
            assertEquals(one.getAttributeMap(), two.getAttributeMap());
    public static final String ATTRIBUTE_VALUE_ONE = "mock_attribute_one";  
        .featureType(RuleTestUtils.MockRuleFeatureType.INSTANCE)
        Set.of(ATTRIBUTE_VALUE_ONE)
import org.opensearch.rule.autotagging.Attribute;
/*  
        mapOne.sort(Comparator.comparing(Rule::getId));
public class RuleTestUtils {
    public static void assertEqualRules(List<Rule> mapOne, List<Rule> mapTwo, boolean ruleUpdated) {  
package org.opensearch.rule.utils;
    }
    public static final String TIMESTAMP_TWO = "2023-01-26T08:58:57.558Z";
        MockRuleAttributes(String name) {
    public static final String FEATURE_VALUE_TWO = "feature_value_two";
    public static final String _ID_ONE = "e9f35a73-ece2-3fa7-857e-7c1af877fc75";
        .attributeMap(ATTRIBUTE_MAP)
        .id(_ID_TWO)  
            this.name = name;
        }  
        .updatedAt(TIMESTAMP_ONE)
        MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE,
    public static final String DESCRIPTION_TWO = "description_2";
        @Override
        }
        static {  
    public static final String _ID_TWO = "b55aa7e6-5aae-38e8-bf43-803599996ffe";
    public static final Rule ruleTwo = Rule.builder()
        INVALID_ATTRIBUTE(RuleTestUtils.INVALID_ATTRIBUTE);  
        MOCK_RULE_ATTRIBUTE_TWO(ATTRIBUTE_VALUE_TWO),
import static org.junit.Assert.assertEquals;
            return name;
        }  
        .featureValue(FEATURE_VALUE_TWO)  
    public static class MockRuleFeatureType implements FeatureType {  
        if (ruleUpdated) {
    public static final Rule ruleOne = Rule.builder()
        @Override  
            assertEquals(one.getFeatureValue(), two.getFeatureValue());
        }  
        return Map.of(_ID_ONE, ruleOne, _ID_TWO, ruleTwo);  
 */  
        .featureValue(FEATURE_VALUE_ONE)  
        .featureType(RuleTestUtils.MockRuleFeatureType.INSTANCE)
        .id(_ID_ONE)  
    }
    }
        @Override
    public static final String DESCRIPTION_ONE = "description_1";
    public static Map<String, Rule> ruleMap() {
 * compatible open source license.
        .description(DESCRIPTION_TWO)
 *
}
        }
        .build();  
            2
        public Map<Attribute, Integer> getOrderedAttributes() {
        private static final Map<Attribute, Integer> PRIORITIZED_ATTRIBUTES = Map.of(  
            assertEqualRule(mapOne.get(i), mapTwo.get(i), ruleUpdated);
 * this file be licensed under the Apache-2.0 license or a
    }
 * SPDX-License-Identifier: Apache-2.0
        }  
        assertEquals(mapOne.size(), mapTwo.size());
import java.util.List;
    public static final String INVALID_ATTRIBUTE = "invalid_attribute";
    );  
        );
        private final String name;
        .build();  
            return FEATURE_TYPE_NAME;  
        .attributeMap(Map.of(RuleTestUtils.MockRuleAttributes.MOCK_RULE_ATTRIBUTE_TWO, Set.of(ATTRIBUTE_VALUE_TWO)))
        .description(DESCRIPTION_ONE)
            MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE,
        mapTwo.sort(Comparator.comparing(Rule::getId));  
    public enum MockRuleAttributes implements Attribute {  
    public static final String TEST_INDEX_NAME = ".test_index_for_rule";
    }  
            1,
        private MockRuleFeatureType() {}
            assertEquals(one.getFeatureType(), two.getFeatureType());  
        public static final MockRuleFeatureType INSTANCE = new MockRuleFeatureType();
