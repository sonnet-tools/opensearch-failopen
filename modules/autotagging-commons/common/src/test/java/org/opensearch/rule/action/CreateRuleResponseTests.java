            + "  \"description\" : \"description_1\",\n"
            + "  \"mock_attribute_one\" : [\n"
            + "  ],\n"
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.test.OpenSearchTestCase;
    }  
    /**
/*  
        CreateRuleResponse otherResponse = new CreateRuleResponse(streamInput);
    /**
import static org.opensearch.rule.utils.RuleTestUtils.ruleOne;  
package org.opensearch.rule.action;
public class CreateRuleResponseTests extends OpenSearchTestCase {  
        BytesStreamOutput out = new BytesStreamOutput();
        assertEqualRule(responseRule, otherResponseRule, false);
import static org.opensearch.rule.utils.RuleTestUtils.assertEqualRule;
        CreateRuleResponse response = new CreateRuleResponse(ruleOne);  
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
        response.writeTo(out);
 * this file be licensed under the Apache-2.0 license or a
    public void testToXContentCreateRule() throws IOException {
 *
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
import org.opensearch.core.xcontent.ToXContent;
import static org.mockito.Mockito.mock;
import org.opensearch.core.common.io.stream.StreamInput;  
import java.io.IOException;  
        Rule responseRule = response.getRule();
     */  
        String expected = "{\n"
            + "  \"updated_at\" : \"2024-01-26T08:58:57.558Z\"\n"  
import org.opensearch.rule.autotagging.Rule;  
        assertEquals(expected, actual);
 * SPDX-License-Identifier: Apache-2.0
            + "}";
        Rule otherResponseRule = otherResponse.getRule();  
    public void testSerialization() throws IOException {
            + "  \"mock_feature_type\" : \"feature_value_one\",\n"
        CreateRuleResponse response = new CreateRuleResponse(ruleOne);  
 * The OpenSearch Contributors require contributions made to  
            + "  \"id\" : \"e9f35a73-ece2-3fa7-857e-7c1af877fc75\",\n"  
            + "    \"mock_attribute_one\"\n"  
}
import org.opensearch.common.xcontent.json.JsonXContent;
    }
        StreamInput streamInput = out.bytes().streamInput();  
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
     * Test case to validate the toXContent method of CreateRuleResponse
     * Test case to verify serialization and deserialization of CreateRuleResponse  
     */
 */  
