    }
import java.util.Collections;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.io.stream.BytesStreamOutput;
                GetIngestionStateResponse deserializedResponse = new GetIngestionStateResponse(in);
package org.opensearch.action.admin.indices.streamingingestion.state;
                assertEquals(response.getSuccessfulShards(), deserializedResponse.getSuccessfulShards());  
                assertEquals(response.getFailedShards(), deserializedResponse.getFailedShards());
        ShardIngestionState[] shardStates = new ShardIngestionState[] {
                assertEquals(response.getShardStates()[0].getShardId(), deserializedResponse.getShardStates()[0].getShardId());  
        }  
        GetIngestionStateResponse response = new GetIngestionStateResponse(shardStates, 2, 2, 0, null, Collections.emptyList());
import java.io.IOException;
import org.opensearch.test.OpenSearchTestCase;  
public class GetIngestionStateResponseTests extends OpenSearchTestCase {
    public void testSerialization() throws IOException {
 * The OpenSearch Contributors require contributions made to  
/*  
                assertEquals(response.getTotalShards(), deserializedResponse.getTotalShards());
 */  
import org.opensearch.core.common.io.stream.StreamInput;
 *
            response.writeTo(out);
            try (StreamInput in = out.bytes().streamInput()) {
}
            new ShardIngestionState("index1", 1, "PAUSED", "BLOCK", true, false, "", true, "node") };
            new ShardIngestionState("index1", 0, "POLLING", "DROP", false, false, "", true, "node"),  
                assertEquals(response.getShardStates()[1].getShardId(), deserializedResponse.getShardStates()[1].getShardId());
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
