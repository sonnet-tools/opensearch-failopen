import java.io.IOException;
            + "  \"id\" : \"e9f35a73-ece2-3fa7-857e-7c1af877fc75\",\n"
import org.opensearch.common.io.stream.BytesStreamOutput;
public class UpdateRuleResponseTests extends OpenSearchTestCase {
import static org.opensearch.rule.utils.RuleTestUtils.ruleOne;
            + "  \"mock_attribute_one\" : [\n"
 *
     * Test case to verify the toXContent of GetRuleResponse
    }
import org.opensearch.common.xcontent.json.JsonXContent;
    public void testSerialization() throws IOException {  
}  
package org.opensearch.rule.action;
        response.writeTo(out);  
        BytesStreamOutput out = new BytesStreamOutput();
        String expected = "{\n"
     */
            + "  ],\n"  
import org.opensearch.core.xcontent.XContentBuilder;
 */  
     */
        UpdateRuleResponse response = new UpdateRuleResponse(ruleOne);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;  
     * Test case to verify the serialization and deserialization of UpdateRuleResponse
            + "    \"mock_attribute_one\"\n"
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();  
import static org.mockito.Mockito.mock;  
import org.opensearch.core.xcontent.ToXContent;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(expected, actual);
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            + "  \"mock_feature_type\" : \"feature_value_one\",\n"
            + "  \"description\" : \"description_1\",\n"  
import org.opensearch.test.OpenSearchTestCase;  
        StreamInput streamInput = out.bytes().streamInput();
            + "}";  
import static org.opensearch.rule.utils.RuleTestUtils.assertEqualRule;
    /**  
/*  
    }
 * this file be licensed under the Apache-2.0 license or a
        UpdateRuleResponse otherResponse = new UpdateRuleResponse(streamInput);
 * compatible open source license.
            + "  \"updated_at\" : \"2024-01-26T08:58:57.558Z\"\n"
    /**  
        UpdateRuleResponse response = new UpdateRuleResponse(ruleOne);
        assertEqualRule(response.getRule(), otherResponse.getRule(), false);  
    public void testToXContent() throws IOException {  
