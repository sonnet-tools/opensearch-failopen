        assertEquals(request.getId(), otherRequest.getId());  
import static org.opensearch.rule.utils.RuleTestUtils.ATTRIBUTE_VALUE_ONE;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(request.getId(), otherRequest.getId());
    private final Map<String, Set<String>> attributeFilters = Map.of(
 */  
        RuleTestUtils.MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE.getName(),  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * compatible open source license.
        request.writeTo(out);
     */  
    /**
import java.util.Map;
import org.opensearch.test.OpenSearchTestCase;
    }
        assertEquals(request.getAttributeFilters(), otherRequest.getAttributeFilters());
        assertEquals(RuleTestUtils.MockRuleFeatureType.INSTANCE, request.getFeatureType());
    public void testValidate() {
    );
import java.util.HashMap;
        assertEquals(request.getAttributeFilters(), otherRequest.getAttributeFilters());
            SEARCH_AFTER,
import static org.opensearch.rule.utils.RuleTestUtils._ID_ONE;
    public void testSerializationWithNull() throws IOException {
/*  
}
        StreamInput streamInput = out.bytes().streamInput();
        request = new GetRuleRequest(_ID_ONE, attributeFilters, "", RuleTestUtils.MockRuleFeatureType.INSTANCE);
        GetRuleRequest otherRequest = new GetRuleRequest(streamInput);
        assertEquals(_ID_ONE, request.getId());
            new HashMap<>(),
import org.opensearch.core.common.io.stream.StreamInput;
    }  
        assertNull(request.getId());
        assertThrows(IllegalArgumentException.class, request::validate);  
package org.opensearch.rule.action;
        request.writeTo(out);  
    }
        BytesStreamOutput out = new BytesStreamOutput();  
 * SPDX-License-Identifier: Apache-2.0
        assertThrows(IllegalArgumentException.class, request::validate);
     * Test case to verify the serialization and deserialization of GetRuleRequest
        assertNull(request.getSearchAfter());  
public class GetRuleRequestTests extends OpenSearchTestCase {  
import java.util.Set;  
            (String) null,  
        assertNull(request.validate());
        StreamInput streamInput = out.bytes().streamInput();
        Set.of(ATTRIBUTE_VALUE_ONE)
        GetRuleRequest request = new GetRuleRequest(_ID_ONE, attributeFilters, null, RuleTestUtils.MockRuleFeatureType.INSTANCE);  
     * Test case to verify the serialization and deserialization of GetRuleRequest when name is null
 *
        GetRuleRequest request = new GetRuleRequest("", attributeFilters, null, RuleTestUtils.MockRuleFeatureType.INSTANCE);  
            RuleTestUtils.MockRuleFeatureType.INSTANCE  
        GetRuleRequest otherRequest = new GetRuleRequest(streamInput);  
        BytesStreamOutput out = new BytesStreamOutput();
import java.io.IOException;  
     */  
import org.opensearch.rule.utils.RuleTestUtils;  
 * this file be licensed under the Apache-2.0 license or a
    /**
        GetRuleRequest request = new GetRuleRequest(
import static org.opensearch.rule.utils.RuleTestUtils.SEARCH_AFTER;  
        );
    public void testSerialization() throws IOException {
