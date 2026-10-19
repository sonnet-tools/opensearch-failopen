 */  
            try (StreamInput in = out.bytes().streamInput()) {
 *
        request.indicesOptions(IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean()));
            }
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
public class PauseIngestionRequestTests extends OpenSearchTestCase {  
                assertEquals(request.indicesOptions(), deserializedRequest.indicesOptions());
        // Test with valid indices
import org.opensearch.action.ActionRequestValidationException;
        // Test with empty indices
import org.opensearch.common.io.stream.BytesStreamOutput;  
                PauseIngestionRequest deserializedRequest = new PauseIngestionRequest(in);
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertNotNull(e);
        String[] indices = new String[] { "index1", "index2" };  
            request.writeTo(out);
        }  
import org.opensearch.action.support.IndicesOptions;
        PauseIngestionRequest request = new PauseIngestionRequest(indices);
}
        PauseIngestionRequest request2 = new PauseIngestionRequest(new String[0]);  
import org.opensearch.test.OpenSearchTestCase;
        PauseIngestionRequest request = new PauseIngestionRequest(new String[] { "index1", "index2" });
    public void testSerialization() throws IOException {
/*  
    }
    public void testValidation() {  
        assertNull(request.validate());  
    }  
 * compatible open source license.
        ActionRequestValidationException e = request2.validate();
                assertArrayEquals(request.indices(), deserializedRequest.indices());  
package org.opensearch.action.admin.indices.streamingingestion.pause;
