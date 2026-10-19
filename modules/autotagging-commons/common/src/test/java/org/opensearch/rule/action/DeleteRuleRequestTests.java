}
        assertEquals(request.getRuleId(), deserialized.getRuleId());  
        assertEquals(request.getFeatureType(), deserialized.getFeatureType());
import org.opensearch.core.common.io.stream.StreamInput;
public class DeleteRuleRequestTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        DeleteRuleRequest request = new DeleteRuleRequest(_ID_ONE, RuleTestUtils.MockRuleFeatureType.INSTANCE);
    public void testSerialization() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
    }
import static org.opensearch.rule.utils.RuleTestUtils._ID_ONE;
        DeleteRuleRequest request = new DeleteRuleRequest("", RuleTestUtils.MockRuleFeatureType.INSTANCE);
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
        assertNotNull(request.validate());  
        StreamInput in = out.bytes().streamInput();
import org.opensearch.common.io.stream.BytesStreamOutput;
        BytesStreamOutput out = new BytesStreamOutput();
        DeleteRuleRequest deserialized = new DeleteRuleRequest(in);
 */  
/*  
package org.opensearch.rule.action;
 *
import org.opensearch.rule.utils.RuleTestUtils;  
    }
 * compatible open source license.
        request.writeTo(out);  
    public void testValidate_withMissingId() {
