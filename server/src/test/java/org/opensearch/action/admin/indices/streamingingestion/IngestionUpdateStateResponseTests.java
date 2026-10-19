    }  
 * The OpenSearch Contributors require contributions made to  
            new IngestionStateShardFailure("index1", 0, "test failure") };
package org.opensearch.action.admin.indices.streamingingestion;
                assertTrue(deserializedResponse.isAcknowledged());  
        assertEquals(0, groupedFailures.get("index1").get(0).shard());
 * this file be licensed under the Apache-2.0 license or a
                IngestionUpdateStateResponse deserializedResponse = new IngestionUpdateStateResponse(in);
            new IngestionStateShardFailure("index1", 0, "failure 1"),
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(0, groupedFailures.get("index2").get(0).shard());  
            }
import java.io.IOException;
            new IngestionStateShardFailure("index2", 0, "failure 3") };  
            response.writeTo(out);
import org.opensearch.common.io.stream.BytesStreamOutput;
 * SPDX-License-Identifier: Apache-2.0
                assertEquals("test error", deserializedResponse.getErrorMessage());  
/*  
        assertEquals(1, groupedFailures.get("index2").size());  
import java.util.Map;
                assertTrue(deserializedResponse.isShardsAcknowledged());
public class IngestionUpdateStateResponseTests extends OpenSearchTestCase {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 */  
                assertEquals(0, deserializedResponse.getShardFailures()[0].shard());
        assertEquals(2, groupedFailures.get("index1").size());
import org.opensearch.core.common.io.stream.StreamInput;
        Map<String, List<IngestionStateShardFailure>> groupedFailures = IngestionStateShardFailure.groupShardFailuresByIndex(shardFailures);  
 * compatible open source license.
}
        IngestionStateShardFailure[] shardFailures = new IngestionStateShardFailure[] {  
        }
    public void testShardFailureGrouping() {
                assertEquals("index1", deserializedResponse.getShardFailures()[0].index());
    }
                assertEquals(1, deserializedResponse.getShardFailures().length);  
    public void testSerialization() throws IOException {
        IngestionStateShardFailure[] shardFailures = new IngestionStateShardFailure[] {  
import java.util.List;  
                assertNotNull(deserializedResponse.getShardFailures());
        IngestionUpdateStateResponse response = new IngestionUpdateStateResponse(true, true, shardFailures, "test error");
            try (StreamInput in = out.bytes().streamInput()) {
        assertEquals(2, groupedFailures.size());
        IngestionUpdateStateResponse response = new IngestionUpdateStateResponse(true, true, shardFailures, "test error");
            new IngestionStateShardFailure("index1", 1, "failure 2"),
        assertEquals(1, groupedFailures.get("index1").get(1).shard());
 *
