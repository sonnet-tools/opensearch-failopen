            assertEquals("Shard ID should match", original.id(), deserialized.id());
        List<ShardId> shardIds = new ArrayList<>(count);
    }
import org.opensearch.core.index.Index;  
        }  
import org.opensearch.core.index.shard.ShardId;
        List<ShardId> shardIds = createTestShardIds(indexName, 3);
import java.util.ArrayList;
    private List<ShardId> createTestShardIds(String indexName, int count) {
public class ScaleIndexNodeRequestTests extends OpenSearchTestCase {
        String indexName = "test_index";  
        ScaleIndexNodeRequest deserializedRequest = new ScaleIndexNodeRequest(input);  
        assertTrue("Empty shard list should survive serialization", deserializedRequest.getShardIds().isEmpty());
            shardIds.add(new ShardId(index, i));
import org.opensearch.test.OpenSearchTestCase;
        String indexName = "test_index";
package org.opensearch.action.admin.indices.scale.searchonly;
            ShardId original = shardIds.get(i);
    }
 */  
import org.opensearch.core.common.io.stream.StreamInput;
    public void testSerializationWithMultipleShards() throws IOException {
        assertEquals("Index name should survive serialization", originalRequest.getIndex(), deserializedRequest.getIndex());  
        StreamInput input = output.bytes().streamInput();
        return shardIds;
            shardIds.size(),  
        assertEquals("Shard IDs should survive serialization", originalRequest.getShardIds(), deserializedRequest.getShardIds());  
        assertEquals(
            ShardId deserialized = deserializedRequest.getShardIds().get(i);  
            "Should have correct number of shards after deserialization",
        ScaleIndexNodeRequest originalRequest = new ScaleIndexNodeRequest(indexName, emptyShardIds);
        List<ShardId> shardIds = createTestShardIds(indexName, 5);  
    public void testSerializationWithEmptyShardList() throws IOException {  
        }
        BytesStreamOutput output = new BytesStreamOutput();
 * this file be licensed under the Apache-2.0 license or a
        StreamInput input = output.bytes().streamInput();
import org.opensearch.common.io.stream.BytesStreamOutput;
        List<ShardId> shardIds = createTestShardIds(indexName, 3);  
        );
        ScaleIndexNodeRequest deserializedRequest = new ScaleIndexNodeRequest(input);
        for (int i = 0; i < count; i++) {
            assertEquals("Index name should match", original.getIndexName(), deserialized.getIndexName());  
        ScaleIndexNodeRequest deserializedRequest = new ScaleIndexNodeRequest(input);
        originalRequest.writeTo(output);  
 * compatible open source license.
/*  
        BytesStreamOutput output = new BytesStreamOutput();  
    }
import java.util.List;  
    public void testConstructorAndGetters() {
        originalRequest.writeTo(output);
        BytesStreamOutput output = new BytesStreamOutput();
            deserializedRequest.getShardIds().size()
        for (int i = 0; i < shardIds.size(); i++) {
    }
 *
import java.io.IOException;
}  
        assertEquals("Index name should match", indexName, request.getIndex());
        ScaleIndexNodeRequest request = new ScaleIndexNodeRequest(indexName, shardIds);
        ScaleIndexNodeRequest originalRequest = new ScaleIndexNodeRequest(indexName, shardIds);  
        assertEquals("Index name should survive serialization", originalRequest.getIndex(), deserializedRequest.getIndex());
    public void testSerializationRoundTrip() throws IOException {
        Index index = new Index(indexName, "uuid");  
        String indexName = "test_index";
        originalRequest.writeTo(output);
        List<ShardId> emptyShardIds = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Shard IDs should match", shardIds, request.getShardIds());
        ScaleIndexNodeRequest originalRequest = new ScaleIndexNodeRequest(indexName, shardIds);
        String indexName = "test_index";
    }  
 * The OpenSearch Contributors require contributions made to  
        StreamInput input = output.bytes().streamInput();  
