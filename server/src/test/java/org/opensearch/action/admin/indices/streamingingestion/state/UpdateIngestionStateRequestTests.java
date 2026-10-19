    public void testSerialization() throws IOException {
import org.opensearch.common.io.stream.BytesStreamOutput;  
        request.setIngestionPaused(false);  
 * compatible open source license.
        String[] indices = new String[] { "index1", "index2" };  
        }  
                assertArrayEquals(request.getIndex(), deserializedRequest.getIndex());
                new ResumeIngestionRequest.ResetSettings(0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0") }  
import org.opensearch.test.OpenSearchTestCase;
        String[] indices = new String[] { "index1", "index2" };  
        assertNull(validationException);  
package org.opensearch.action.admin.indices.streamingingestion.state;
        int[] shards = new int[] { 0, 1, 2 };
            request.writeTo(out);
        assertNotNull(validationException);
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
    }
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(indices, shards);
            try (StreamInput in = out.bytes().streamInput()) {  
public class UpdateIngestionStateRequestTests extends OpenSearchTestCase {  
 *
    }
    public void testConstructor() {
    public void testValidation() {  
        assertArrayEquals(shards, request.getShards());
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(indices, shards);
import org.opensearch.core.common.io.stream.StreamInput;
        request.setResetSettings(
        // Test with valid indices  
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(null, new int[] {});
        // Test with null indices
                UpdateIngestionStateRequest deserializedRequest = new UpdateIngestionStateRequest(in);
                assertEquals(request.getResetSettings()[0].getValue(), deserializedRequest.getResetSettings()[0].getValue());  
                assertArrayEquals(request.getShards(), deserializedRequest.getShards());  
 * The OpenSearch Contributors require contributions made to  
 */  
 * SPDX-License-Identifier: Apache-2.0
            new ResumeIngestionRequest.ResetSettings[] {
                assertFalse(deserializedRequest.getIngestionPaused());
            }
        assertNull(request.getIngestionPaused());
    }  
        assertArrayEquals(indices, request.getIndex());  
/*  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        request = new UpdateIngestionStateRequest(new String[] { "index1" }, new int[] {});
        );
import org.opensearch.action.ActionRequestValidationException;
        validationException = request.validate();
                assertEquals(request.getResetSettings()[0].getMode(), deserializedRequest.getResetSettings()[0].getMode());
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
        ActionRequestValidationException validationException = request.validate();  
}
        int[] shards = new int[] { 0, 1, 2 };
                assertEquals(request.getResetSettings()[0].getShard(), deserializedRequest.getResetSettings()[0].getShard());
