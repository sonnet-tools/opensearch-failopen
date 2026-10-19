 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        BytesStreamOutput out = new BytesStreamOutput();
 *
     * Test case to verify the serialization and deserialization of CreateRuleRequest.
     */
        StreamInput streamInput = out.bytes().streamInput();
 * SPDX-License-Identifier: Apache-2.0
public class CreateRuleRequestTests extends OpenSearchTestCase {
import static org.opensearch.rule.utils.RuleTestUtils.assertEqualRule;
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEqualRule(ruleOne, otherRequest.getRule(), false);  
 * compatible open source license.
}
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.rule.action;
    }
    public void testSerialization() throws IOException {  
/*  
import org.opensearch.test.OpenSearchTestCase;  
import java.io.IOException;
        CreateRuleRequest otherRequest = new CreateRuleRequest(streamInput);
        CreateRuleRequest request = new CreateRuleRequest(ruleOne);
        request.writeTo(out);  
 */  
    /**  
import static org.opensearch.rule.utils.RuleTestUtils.ruleOne;
