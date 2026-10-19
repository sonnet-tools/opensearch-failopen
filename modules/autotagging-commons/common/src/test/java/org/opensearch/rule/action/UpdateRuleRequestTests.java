    }
        assertEquals(request.getId(), otherRequest.getId());  
import static org.opensearch.rule.utils.RuleTestUtils.FEATURE_VALUE_ONE;
}
            RuleTestUtils.MockRuleFeatureType.INSTANCE  
        assertNull(request.getDescription());
        assertEquals(request.getDescription(), otherRequest.getDescription());
        );  
        BytesStreamOutput out = new BytesStreamOutput();
     */
            DESCRIPTION_TWO,  
        request.writeTo(out);
import org.opensearch.rule.utils.RuleTestUtils;  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(request.getAttributeMap(), otherRequest.getAttributeMap());  
        request = new UpdateRuleRequest(_ID_ONE, DESCRIPTION_ONE, ATTRIBUTE_MAP, "", RuleTestUtils.MockRuleFeatureType.INSTANCE);
            _ID_ONE,
    }
        assertEquals(request.getFeatureValue(), otherRequest.getFeatureValue());  
            FEATURE_VALUE_ONE,
import static org.opensearch.rule.utils.RuleTestUtils.DESCRIPTION_TWO;
            "",
        assertEquals(request.getAttributeMap(), otherRequest.getAttributeMap());
    }  
        UpdateRuleRequest request = new UpdateRuleRequest(  
            ATTRIBUTE_MAP,  
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.common.io.stream.BytesStreamOutput;
            ATTRIBUTE_MAP,
        assertEquals(request.getId(), otherRequest.getId());
     */
            RuleTestUtils.MockRuleFeatureType.INSTANCE
package org.opensearch.rule.action;
        UpdateRuleRequest otherRequest = new UpdateRuleRequest(streamInput);
        );
    public void testSerialization() throws IOException {  
        StreamInput streamInput = out.bytes().streamInput();  
public class UpdateRuleRequestTests extends OpenSearchTestCase {
        UpdateRuleRequest request = new UpdateRuleRequest(_ID_ONE, null, ATTRIBUTE_MAP, null, RuleTestUtils.MockRuleFeatureType.INSTANCE);
import org.opensearch.core.common.io.stream.StreamInput;
        UpdateRuleRequest request = new UpdateRuleRequest(
        assertNull(request.validate());  
 * The OpenSearch Contributors require contributions made to  
        StreamInput streamInput = out.bytes().streamInput();
     * Test case to verify the serialization and deserialization of UpdateRuleRequest when some fields are null
     * Test case to verify the serialization and deserialization of UpdateRuleRequest
        assertNull(request.getFeatureValue());  
        assertEquals(RuleTestUtils.MockRuleFeatureType.INSTANCE, request.getFeatureType());
/*  
            FEATURE_VALUE_ONE,
import static org.opensearch.rule.utils.RuleTestUtils.ATTRIBUTE_MAP;
import static org.opensearch.rule.utils.RuleTestUtils._ID_ONE;  
        UpdateRuleRequest otherRequest = new UpdateRuleRequest(streamInput);
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
        assertNull(request.validate());
        assertEquals(request.getFeatureValue(), otherRequest.getFeatureValue());
import java.io.IOException;  
    public void testSerializationWithNull() throws IOException {  
        assertNull(request.validate());  
        assertEquals(request.getDescription(), otherRequest.getDescription());
        request.writeTo(out);  
        assertEquals(_ID_ONE, request.getId());
import static org.opensearch.rule.utils.RuleTestUtils.DESCRIPTION_ONE;  
    /**  
 */  
 * compatible open source license.
    public void testValidate() {
            _ID_ONE,
    /**  
 *
