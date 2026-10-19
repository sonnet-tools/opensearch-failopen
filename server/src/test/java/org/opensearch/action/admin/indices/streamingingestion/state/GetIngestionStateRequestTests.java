        // Test with valid indices
}
 * SPDX-License-Identifier: Apache-2.0
 */  
package org.opensearch.action.admin.indices.streamingingestion.state;
            }
/*  
    }  
    }
        int[] shards = new int[] { 0, 1, 2 };  
 * The OpenSearch Contributors require contributions made to  
            try (StreamInput in = out.bytes().streamInput()) {
 * this file be licensed under the Apache-2.0 license or a
        GetIngestionStateRequest request = new GetIngestionStateRequest(indices);
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.test.OpenSearchTestCase;
                GetIngestionStateRequest deserializedRequest = new GetIngestionStateRequest(in);
    public void testValidation() {  
        request.setShards(shards);
        GetIngestionStateRequest request1 = new GetIngestionStateRequest(new String[] { "index1", "index2" });
        }  
        String[] indices = new String[] { "index1", "index2" };
                assertArrayEquals(request.getShards(), deserializedRequest.getShards());
                assertArrayEquals(request.indices(), deserializedRequest.indices());  
public class GetIngestionStateRequestTests extends OpenSearchTestCase {
 *
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertNotNull(e);
        GetIngestionStateRequest request2 = new GetIngestionStateRequest((String[]) null);  
        ActionRequestValidationException e = request2.validate();
    public void testSerialization() throws IOException {
import java.io.IOException;  
        assertNull(request1.validate());  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        // Test with null indices
            request.writeTo(out);
