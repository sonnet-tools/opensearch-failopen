        {
import org.opensearch.rule.storage.XContentRuleParser;
    RuleEntityParser sut;  
import java.util.Locale;
        }
public class XContentRuleParserTests extends OpenSearchTestCase {  
import org.opensearch.rule.utils.RuleTestUtils;  
        }
    public void setUp() throws Exception {
        super.setUp();  
 * SPDX-License-Identifier: Apache-2.0
            "id": "%s",  
    public static final String VALID_JSON = String.format(Locale.ROOT, """
            "name": "TestRule",
    public void testParseRule_InvalidJson() {
 * this file be licensed under the Apache-2.0 license or a
        """;
import java.time.Instant;
 */  
import java.io.IOException;  
/*  
}  
package org.opensearch.rule;
        Exception exception = assertThrows(RuntimeException.class, () -> sut.parse(INVALID_JSON));  
        assertTrue(exception.getMessage().contains("mock_attribute_three is not a valid attribute within the mock_feature_type feature."));
        Rule parsedRule = sut.parse(VALID_JSON);
        assertEquals(RuleTestUtils.MockRuleFeatureType.INSTANCE, parsedRule.getFeatureType());
            "mock_feature_type": "feature value",
    }
        """, _ID_ONE, RuleTestUtils.DESCRIPTION_ONE, Instant.now().toString());  
    }  
        sut = new XContentRuleParser(RuleTestUtils.MockRuleFeatureType.INSTANCE);
import org.opensearch.test.OpenSearchTestCase;
    private static final String INVALID_JSON = """
            "mock_attribute_three": ["attribute_value_one", "attribute_value_two"]  
import org.opensearch.rule.autotagging.Rule;
 * The OpenSearch Contributors require contributions made to  
            "updated_at": "%s"
        assertEquals(RuleTestUtils.DESCRIPTION_ONE, parsedRule.getDescription());
 *
            "description": "%s",
    }
        assertNotNull(parsedRule);  
    public void testParseRule_Success() throws IOException {
import static org.opensearch.rule.utils.RuleTestUtils._ID_ONE;
            "description": "A test rule for unit testing",
            "mock_attribute_one": ["attribute_value_one", "attribute_value_two"],  
 * compatible open source license.
        {  
