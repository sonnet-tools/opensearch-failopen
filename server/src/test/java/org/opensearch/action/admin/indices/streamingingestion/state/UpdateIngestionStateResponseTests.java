                assertEquals(0, deserializedResponse.getShardFailureList()[0].shard());
    public void testSerialization() throws IOException {  
}  
                assertEquals(2, deserializedResponse.getSuccessfulShards());
                assertEquals(3, deserializedResponse.getTotalShards());
                assertEquals("test error", deserializedResponse.getErrorMessage());
                assertEquals(1, deserializedResponse.getFailedShards());  
            response.writeTo(out);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import java.util.List;
            new DefaultShardOperationFailedException("index1", 0, new Exception("test failure"))
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        UpdateIngestionStateResponse response = new UpdateIngestionStateResponse(true, 3, 2, 1, shardFailures);
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
 */  
        );  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        }
            try (StreamInput in = out.bytes().streamInput()) {
                assertEquals(1, deserializedResponse.getShardFailureList().length);
 *
public class UpdateIngestionStateResponseTests extends OpenSearchTestCase {
package org.opensearch.action.admin.indices.streamingingestion.state;
 * this file be licensed under the Apache-2.0 license or a
                assertEquals("index1", deserializedResponse.getShardFailureList()[0].index());  
        response.setErrorMessage("test error");
import java.util.Collections;
            }  
                assertNotNull(deserializedResponse.getShardFailureList());
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertTrue(deserializedResponse.isAcknowledged());  
                UpdateIngestionStateResponse deserializedResponse = new UpdateIngestionStateResponse(in);
    }
 * compatible open source license.
import java.io.IOException;  
