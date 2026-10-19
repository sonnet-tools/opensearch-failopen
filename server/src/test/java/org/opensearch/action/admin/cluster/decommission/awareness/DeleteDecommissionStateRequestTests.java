        }
 *
 */  
        assertEquals(cloneRequest.clusterManagerNodeTimeout(), originalRequest.clusterManagerNodeTimeout());
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
            try (StreamInput in = out.bytes().streamInput()) {
 * compatible open source license.
                cloneRequest = new DeleteDecommissionStateRequest(in);
    }  
public class DeleteDecommissionStateRequestTests extends OpenSearchTestCase {
}
/*  
            originalRequest.writeTo(out);  
        final DeleteDecommissionStateRequest cloneRequest;
import org.opensearch.common.io.stream.BytesStreamOutput;
            }  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.cluster.decommission.awareness;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.io.stream.StreamInput;  
 * The OpenSearch Contributors require contributions made to  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        final DeleteDecommissionStateRequest originalRequest = new DeleteDecommissionStateRequest();
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
    public void testSerialization() throws IOException {
