            .build();
                    RuleTestUtils.MockRuleAttributes.MOCK_RULE_ATTRIBUTE_TWO,  
                Map.of(  
        Optional<String> result = RuleUtils.getDuplicateRuleId(differentFeatureTypeRule, List.of(ruleOne));
    public void testDuplicateRuleWithSameId() {
 *
 */  
import static org.opensearch.rule.utils.RuleTestUtils.ATTRIBUTE_VALUE_ONE;
        Set<String> principalValues = Set.of("username|admin", "role|user");
}  
import java.util.Set;  
        assertEquals(_ID_ONE, updatedRule.getId());
    }  
import static org.opensearch.rule.utils.RuleTestUtils.DESCRIPTION_TWO;
        assertTrue(result.isPresent());  
            .id(_ID_TWO)
            .featureType(RuleTestUtils.MockRuleFeatureType.INSTANCE)
import org.opensearch.test.OpenSearchTestCase;  
 * SPDX-License-Identifier: Apache-2.0
            .featureType(RuleTestUtils.MockRuleFeatureType.INSTANCE)  
            .featureValue(FEATURE_VALUE_ONE)
                )
        assertEquals(Set.of("my-index"), result.get("index_pattern"));  
            _ID_ONE,
        Rule rule = mock(Rule.class);
        Optional<String> result = RuleUtils.getDuplicateRuleId(ruleOne, List.of(ruleOne));
        when(rule.getAttributeMap()).thenReturn(attributeMap);  
        assertEquals(Set.of("user"), result.get("principal.role"));
import org.opensearch.rule.utils.RuleTestUtils;
        assertTrue(result.containsKey("principal.role"));  
            Map.of(MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE, Set.of(ATTRIBUTE_VALUE_TWO)),  
            .featureValue(FEATURE_VALUE_ONE)
        attributeMap.put(principal, principalValues);  
                    Set.of(ATTRIBUTE_VALUE_TWO)
        when(indexPattern.getWeightedSubfields()).thenReturn(new TreeMap<>());
            .id(_ID_TWO)  
        assertTrue(result.isEmpty());
        Optional<String> result = RuleUtils.getDuplicateRuleId(ruleWithPartialOverlap, List.of(ruleOne));
        Rule testRule = Rule.builder()  
            .updatedAt(TIMESTAMP_ONE)
    public void testDifferentFeatureTypes() {  
    }
    }  
        assertTrue(result.containsKey("principal.username"));
            .updatedAt(TIMESTAMP_ONE)
    }
import static org.opensearch.rule.utils.RuleTestUtils._ID_TWO;
    public void testNoAttributeIntersection() {  
            .featureType(RuleTestUtils.MockRuleFeatureType.INSTANCE)
        assertEquals(RuleTestUtils.MockRuleFeatureType.INSTANCE, updatedRule.getFeatureType());
                    RuleTestUtils.MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE,
            .featureValue(FEATURE_VALUE_ONE)
import static org.opensearch.rule.utils.RuleTestUtils._ID_ONE;  
import static org.opensearch.rule.utils.RuleTestUtils.ruleTwo;  
        assertEquals(Set.of("admin"), result.get("principal.username"));
        );  
        attributeMap.put(indexPattern, indexValues);
import static org.opensearch.rule.utils.RuleTestUtils.MockRuleAttributes;
    }
    public void testDuplicateRuleFound() {  
        assertTrue(result.isEmpty());
        Attribute indexPattern = mock(Attribute.class);
import static org.opensearch.rule.utils.RuleTestUtils.FEATURE_VALUE_ONE;
            .build();  
        assertTrue(result.isEmpty());
            .description(DESCRIPTION_ONE)  
            RuleTestUtils.MockRuleFeatureType.INSTANCE
    public void testComposeUpdateAllFields() {
        Attribute principal = mock(Attribute.class);  
        when(principal.getWeightedSubfields()).thenReturn(Map.of("username", 1f, "role", 0.09f));
import java.util.Map;
            .attributeMap(ATTRIBUTE_MAP)  
            .build();
import static org.opensearch.rule.utils.RuleTestUtils.ATTRIBUTE_VALUE_TWO;
            .attributeMap(
            .attributeMap(RuleTests.ATTRIBUTE_MAP)  
    public void testPartialAttributeValueIntersection() {
        Map<String, Set<String>> result = RuleUtils.buildAttributeFilters(rule);
        assertTrue(result.isPresent());
        Map<Attribute, Set<String>> attributeMap = new HashMap<>();
        assertEquals(_ID_TWO, result.get());  
import static org.opensearch.rule.utils.RuleTestUtils.FEATURE_VALUE_TWO;  
        assertTrue(result.containsKey("index_pattern"));
package org.opensearch.rule;
    }
    }
import org.opensearch.rule.autotagging.RuleTests;
            .id(_ID_ONE)
public class RuleUtilsTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
    public void testBuildAttributeFiltersWithMock() {
        UpdateRuleRequest request = new UpdateRuleRequest(  
            FEATURE_VALUE_TWO,
        Rule ruleWithPartialOverlap = Rule.builder()
            .build();
import org.opensearch.rule.action.UpdateRuleRequest;
            .attributeMap(Map.of(RuleTestUtils.MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE, Set.of(ATTRIBUTE_VALUE_ONE, "extra_value")))
                    Set.of(ATTRIBUTE_VALUE_ONE),
            .id(_ID_ONE)
        when(indexPattern.getName()).thenReturn("index_pattern");  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
/*  
import java.util.Optional;
        Set<String> indexValues = Set.of("my-index");
import static org.opensearch.rule.utils.RuleTestUtils.DESCRIPTION_ONE;  
        Rule updatedRule = RuleUtils.composeUpdatedRule(ruleOne, request, RuleTestUtils.MockRuleFeatureType.INSTANCE);
        assertEquals(DESCRIPTION_TWO, updatedRule.getDescription());
        assertFalse(result.isPresent());  
    }
import static org.opensearch.rule.utils.RuleTestUtils.ATTRIBUTE_MAP;  
        Rule differentFeatureTypeRule = Rule.builder()
            .description(DESCRIPTION_ONE)
import org.opensearch.rule.autotagging.Rule;  
        Optional<String> result = RuleUtils.getDuplicateRuleId(ruleOne, List.of(ruleTwo));
            .updatedAt(TIMESTAMP_ONE)
        assertEquals(3, result.size());
    public void testAttributeSizeMismatch() {
        assertEquals(FEATURE_VALUE_TWO, updatedRule.getFeatureValue());  
        Optional<String> result = RuleUtils.getDuplicateRuleId(ruleOne, List.of(testRule));  
            )  
        Rule testRule = Rule.builder()
import java.util.List;  
            .featureValue(FEATURE_VALUE_ONE)  
        when(principal.getName()).thenReturn("principal");
import static org.mockito.Mockito.when;
            .updatedAt(TIMESTAMP_ONE)
        Optional<String> result = RuleUtils.getDuplicateRuleId(ruleOne, List.of(testRule));
import static org.opensearch.rule.utils.RuleTestUtils.TIMESTAMP_ONE;
import static org.mockito.Mockito.mock;
            .description(DESCRIPTION_ONE)  
            DESCRIPTION_TWO,
            .featureType(RuleTests.TestFeatureType.INSTANCE)
import java.util.HashMap;
import java.util.TreeMap;
            .description(DESCRIPTION_ONE)
import org.opensearch.rule.autotagging.Attribute;
import static org.opensearch.rule.utils.RuleTestUtils.ruleOne;
        assertEquals(_ID_ONE, result.get());
