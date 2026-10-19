    }
        ShardId shardId = createTestShardId();  
        assertEquals("Shard ID should survive serialization", originalResponse.getShardId(), deserializedResponse.getShardId());  
            originalResponse.hasUncommittedOperations(),
    public void testConstructorAndGetters() {
        ScaleIndexShardResponse originalResponse = new ScaleIndexShardResponse(shardId, true, Integer.MAX_VALUE);
    }
        int uncommittedOps = randomIntBetween(0, 100);
        for (int shardNum : new int[] { 0, 1, 100, Integer.MAX_VALUE }) {
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.action.admin.indices.scale.searchonly;
        );  
        StreamInput input = output.bytes().streamInput();  
        BytesStreamOutput output = new BytesStreamOutput();  
        originalResponse.writeTo(output);
import org.opensearch.common.io.stream.BytesStreamOutput;
        ScaleIndexShardResponse response = new ScaleIndexShardResponse(shardId, randomBoolean(), 0);
    public void testZeroUncommittedOperations() {  
    }
import org.opensearch.core.index.Index;  
        }
        ScaleIndexShardResponse response = new ScaleIndexShardResponse(shardId, needsSync, uncommittedOps);
 * compatible open source license.
        ShardId shardId = createTestShardId();
        // Test with Integer.MAX_VALUE uncommitted operations  
    }  
    }
    public void testSerializationRoundTrip() throws IOException {
        int uncommittedOps = randomIntBetween(0, 100);
        assertEquals("Needs sync flag should match", needsSync, response.needsSync());
}
        ShardId shardId = createTestShardId();
        BytesStreamOutput output = new BytesStreamOutput();  
    public void testNonZeroUncommittedOperations() {
            ScaleIndexShardResponse deserializedResponse = new ScaleIndexShardResponse(input);
import org.opensearch.core.index.shard.ShardId;
 *
        int uncommittedOps = randomIntBetween(1, 100);  
 */  
        assertEquals(
        // Test with different shard numbers
        boolean needsSync = randomBoolean();
public class ScaleIndexShardResponseTests extends OpenSearchTestCase {  
            "Uncommitted operations status should survive serialization",  
        StreamInput input = output.bytes().streamInput();  
        ScaleIndexShardResponse response = new ScaleIndexShardResponse(shardId, randomBoolean(), uncommittedOps);
        originalResponse.writeTo(output);
    public void testSerializationWithExtremeValues() throws IOException {  
            assertEquals("Shard number should survive serialization", shardId.id(), deserializedResponse.getShardId().id());  
        assertTrue("Should report uncommitted operations when count is > 0", response.hasUncommittedOperations());  
        ScaleIndexShardResponse deserializedResponse = new ScaleIndexShardResponse(input);
 * this file be licensed under the Apache-2.0 license or a
        assertFalse("Should report no uncommitted operations when count is 0", response.hasUncommittedOperations());
            deserializedResponse.hasUncommittedOperations()
            ShardId shardId = new ShardId(new Index("test_index", "uuid"), shardNum);  
    public void testSerializationWithVariousShardIds() throws IOException {  
    }
        boolean needsSync = randomBoolean();
 * The OpenSearch Contributors require contributions made to  
            BytesStreamOutput output = new BytesStreamOutput();  
        ShardId shardId = createTestShardId();
        return new ShardId(new Index("test_index", "uuid"), randomIntBetween(0, 10));
import java.io.IOException;
            originalResponse.writeTo(output);
/*  
 * SPDX-License-Identifier: Apache-2.0
        ScaleIndexShardResponse deserializedResponse = new ScaleIndexShardResponse(input);
        assertTrue("Max value should be preserved and indicate uncommitted operations", deserializedResponse.hasUncommittedOperations());  
            StreamInput input = output.bytes().streamInput();  
        ScaleIndexShardResponse originalResponse = new ScaleIndexShardResponse(shardId, needsSync, uncommittedOps);
        assertEquals("Needs sync flag should survive serialization", originalResponse.needsSync(), deserializedResponse.needsSync());
            ScaleIndexShardResponse originalResponse = new ScaleIndexShardResponse(shardId, randomBoolean(), randomIntBetween(0, 100));
        assertEquals("Shard ID should match", shardId, response.getShardId());  
        assertEquals("Uncommitted operations status should match", uncommittedOps > 0, response.hasUncommittedOperations());
        ShardId shardId = createTestShardId();  
import org.opensearch.test.OpenSearchTestCase;
    private ShardId createTestShardId() {
    }  
