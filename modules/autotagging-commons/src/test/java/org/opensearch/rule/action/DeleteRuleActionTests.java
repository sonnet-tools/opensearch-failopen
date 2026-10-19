        StreamInput in = out.bytes().streamInput();  
import org.opensearch.core.common.io.stream.Writeable;  
import java.io.IOException;  
import org.opensearch.common.io.stream.BytesStreamOutput;
    public void testGetName() {  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.io.stream.StreamInput;
 *
public class DeleteRuleActionTests extends OpenSearchTestCase {
 * compatible open source license.
    public void testGetResponseReader() throws IOException {
package org.opensearch.rule.action;
        out.writeBoolean(true);
}
        BytesStreamOutput out = new BytesStreamOutput();
        assertNotNull(DeleteRuleAction.INSTANCE.getResponseReader().read(in));
 * The OpenSearch Contributors require contributions made to  
 */  
        assertTrue(DeleteRuleAction.INSTANCE.getResponseReader() instanceof Writeable.Reader);
    }
    }  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("cluster:admin/opensearch/rule/_delete", DeleteRuleAction.NAME);
