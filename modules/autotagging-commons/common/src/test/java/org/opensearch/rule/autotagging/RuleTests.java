 * compatible open source license.
    }
public class RuleTests extends AbstractSerializingTestCase<Rule> {
        String id = RuleUtils.computeRuleHash(description, FEATURE_TYPE, ATTRIBUTE_MAP, featureValue);
import org.opensearch.core.common.io.stream.Writeable;
import java.util.Set;  
package org.opensearch.rule.autotagging;
    public static final String FEATURE_VALUE = "feature_value";
import org.opensearch.rule.RuleUtils;  
    public enum TestAttribute implements Attribute {
            AutoTaggingRegistry.registerFeatureType(INSTANCE);
        @Override  
import java.io.IOException;  
        String updatedAt,  
        String id = RuleUtils.computeRuleHash(description, featureType, attributeListMap, featureValue);  
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.core.xcontent.ToXContent;  
    static Rule buildRule(
        TestAttribute(String name) {
            "{\"id\":\""
                + "\",\"description\":\"description\",\"test_attr1\":[\"value1\"],\"test_feature_type\":\"feature_value\",\"updated_at\":\""  
        return Rule.fromXContent(parser, FEATURE_TYPE);
        }  
    @Override  
 * The OpenSearch Contributors require contributions made to  
                + "\"}",
        assertNotNull(rule.getFeatureValue());
    public static final TestFeatureType FEATURE_TYPE = TestFeatureType.INSTANCE;  
    }
        assertEquals(UPDATED_AT, rule.getUpdatedAt());
        String description
        public int getMaxNumberOfValuesPerAttribute() {
                + RuleUtils.computeRuleHash(DESCRIPTION, FEATURE_TYPE, map, FEATURE_VALUE)
        String featureValue = randomAlphaOfLength(5);  
import static org.opensearch.rule.autotagging.RuleTests.TestAttribute.TEST_ATTRIBUTE_1;
        public String getName() {  
    ) {
    public static final String UPDATED_AT = "2025-02-24T07:42:10.123456Z";
        }
        );
    public static final String TEST_ATTR2_NAME = "test_attr2";
        Map<Attribute, Set<String>> map = Map.of(TEST_ATTRIBUTE_1, Set.of("value1"));
        @Override
            this.name = name;
    }  
        assertEquals(FEATURE_VALUE, rule.getFeatureValue());
        Rule rule = buildRule(FEATURE_VALUE, FEATURE_TYPE, ATTRIBUTE_MAP, UPDATED_AT, DESCRIPTION);  
        TEST_ATTRIBUTE_1(TEST_ATTR1_NAME),
import org.opensearch.test.AbstractSerializingTestCase;
        @Override
    protected Rule createTestInstance() {
    protected Rule doParseInstance(XContentParser parser) throws IOException {  
    public static final String DESCRIPTION = "description";  
 * this file be licensed under the Apache-2.0 license or a
        return Rule.builder()
            return NAME;
import java.time.Instant;
        public static final TestFeatureType INSTANCE = new TestFeatureType();  
        String featureValue,  
import java.util.Map;
    public static final String _ID = "test_id";
            .build();
 */  
        }
            .attributeMap(attributeListMap)  
        private static final int MAX_ATTRIBUTE_VALUES = 10;
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(rule.getFeatureType());
            return MAX_ATTRIBUTE_VALUE_LENGTH;
        }  
            .updatedAt(updatedAt)
        assertNotNull(resultMap);  
        private static final String NAME = TEST_FEATURE_TYPE;
        static {
    public void testToXContent() throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
    }  
        Map<Attribute, Set<String>> attributeListMap,
            .id(id)
        }
    public static final Map<Attribute, Set<String>> ATTRIBUTE_MAP = Map.of(TEST_ATTRIBUTE_1, Set.of("value1"));
        private static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;  
        return Rule::new;
        assertNotNull(rule.getUpdatedAt());  
    public static final String INVALID_ATTRIBUTE = "invalid_attribute";  
        Map<Attribute, Set<String>> resultMap = rule.getAttributeMap();
        @Override
}  
    }  
        Rule rule = buildRule(FEATURE_VALUE, FEATURE_TYPE, map, updatedAt, DESCRIPTION);
            builder.toString()  
            .featureType(featureType)
    public static final String TEST_ATTR1_NAME = "test_attr1";  
        assertEquals(  
    @Override
            return name;
    @Override  
        public int getMaxCharLengthPerAttributeValue() {  
import org.opensearch.core.xcontent.XContentParser;
        public Map<Attribute, Integer> getOrderedAttributes() {
        String description = randomAlphaOfLength(10);
    protected Writeable.Reader<Rule> instanceReader() {
    public static final String TEST_FEATURE_TYPE = "test_feature_type";
        FeatureType featureType,
        public String getName() {  
/*  
        return new Rule(id, description, ATTRIBUTE_MAP, FEATURE_TYPE, featureValue, updatedAt);  
    }
    public static class TestFeatureType implements FeatureType {
                + updatedAt
        }
            .description(description)
        String updatedAt = Instant.now().toString();  
        private final String name;
        assertFalse(resultMap.isEmpty());
            return MAX_ATTRIBUTE_VALUES;
    }  
        rule.toXContent(builder, ToXContent.EMPTY_PARAMS);
    public static final String INVALID_FEATURE = "invalid_feature";
            .featureValue(featureValue)  
 *
    public void testValidRule() {
        @Override
        }  
        String updatedAt = Instant.now().toString();
        public TestFeatureType() {}
        XContentBuilder builder = JsonXContent.contentBuilder();
import static org.opensearch.rule.autotagging.RuleTests.TestAttribute.TEST_ATTRIBUTE_2;  
            return Map.of(TEST_ATTRIBUTE_1, 1, TEST_ATTRIBUTE_2, 2);  
    }  
        TEST_ATTRIBUTE_2(TEST_ATTR2_NAME);  
