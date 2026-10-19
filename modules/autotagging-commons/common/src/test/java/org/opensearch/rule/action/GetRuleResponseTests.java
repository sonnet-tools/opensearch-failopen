        list.add(ruleOne);
        GetRuleResponse response = new GetRuleResponse(List.of(ruleOne), SEARCH_AFTER);  
    /**
            + "      \"mock_attribute_one\" : [\n"
/*  
        BytesStreamOutput out = new BytesStreamOutput();  
     * Test case to verify the toXContent of GetRuleResponse  
        GetRuleResponse otherResponse = new GetRuleResponse(streamInput);
    public void testToXContentGetSingleRule() throws IOException {
        BytesStreamOutput out = new BytesStreamOutput();
package org.opensearch.rule.action;
        assertEquals(response.getRules(), list);  
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        assertEqualRules(response.getRules(), otherResponse.getRules(), false);
        response.writeTo(out);  
        GetRuleResponse response = new GetRuleResponse(list, SEARCH_AFTER);  
            + "    }\n"
        GetRuleResponse response = new GetRuleResponse(list, SEARCH_AFTER);
    /**
 *
        assertEquals(response.getRules(), list);
            + "  ],\n"
        GetRuleResponse otherResponse = new GetRuleResponse(streamInput);
        assertEquals(0, otherResponse.getRules().size());
        List<Rule> list = new ArrayList<>();
public class GetRuleResponseTests extends OpenSearchTestCase {
import static org.opensearch.rule.utils.RuleTestUtils.SEARCH_AFTER;
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
import org.opensearch.core.common.io.stream.StreamInput;  
import static org.opensearch.rule.utils.RuleTestUtils.ruleOne;  
        StreamInput streamInput = out.bytes().streamInput();  
        assertEquals(expected, actual);  
import static org.mockito.Mockito.mock;
        GetRuleResponse otherResponse = new GetRuleResponse(new ArrayList<>(), null);  
            + "      \"id\" : \"e9f35a73-ece2-3fa7-857e-7c1af877fc75\",\n"  
    }
     * Test case to verify the serialization and deserialization of GetRuleResponse when the result contains multiple rules
            + "    {\n"
        String expected = "{\n"  
        StreamInput streamInput = out.bytes().streamInput();
        assertEquals(2, otherResponse.getRules().size());  
        response.writeTo(out);
            + "      \"description\" : \"description_1\",\n"
            + "      ],\n"
import static org.opensearch.rule.utils.RuleTestUtils.ruleTwo;
import java.util.ArrayList;
        assertEquals(expected, actual);
 * The OpenSearch Contributors require contributions made to  
            + "  ]\n"
        String actual = otherResponse.toXContent(builder, mock(ToXContent.Params.class)).toString();
        response.writeTo(out);
        list.add(ruleOne);  
     * Test case to verify the serialization and deserialization of GetRuleResponse when the result is empty
            + "}";  
 * compatible open source license.
 */  
import java.util.List;
        List<Rule> list = new ArrayList<>();
    public void testSerializationMultipleRule() throws IOException {
        String expected = "{\n" + "  \"rules\" : [ ]\n" + "}";
import org.opensearch.core.xcontent.ToXContent;
            + "      \"mock_feature_type\" : \"feature_value_one\",\n"
import static org.opensearch.rule.utils.RuleTestUtils.assertEqualRules;
     * Test case to verify toXContent of GetRuleResponse when the result contains zero Rule
     */
        GetRuleResponse response = new GetRuleResponse(list, null);
    /**
    /**
        BytesStreamOutput out = new BytesStreamOutput();
    }
        GetRuleResponse otherResponse = new GetRuleResponse(streamInput);  
        list.add(ruleTwo);
            + "    \"search_after\"\n"
     */  
    }
     */  
    }
    /**
}
            + "  \"search_after\" : [\n"  
    }  
            + "      \"updated_at\" : \"2024-01-26T08:58:57.558Z\"\n"  
     */
    public void testSerializationNull() throws IOException {
    public void testSerializationSingleRule() throws IOException {
            + "        \"mock_attribute_one\"\n"  
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.xcontent.XContentBuilder;
 * SPDX-License-Identifier: Apache-2.0
        List<Rule> list = new ArrayList<>();  
    public void testToXContentGetZeroRule() throws IOException {
     */  
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
        assertEqualRules(response.getRules(), otherResponse.getRules(), false);
import org.opensearch.common.xcontent.json.JsonXContent;
     * Test case to verify the serialization and deserialization of GetRuleResponse  
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
import org.opensearch.rule.autotagging.Rule;  
import java.io.IOException;  
        StreamInput streamInput = out.bytes().streamInput();
            + "  \"rules\" : [\n"
