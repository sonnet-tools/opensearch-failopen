        response.toXContent(builder, null);  
        // Add a failed shard response  
                true,   // needs sync
        BytesStreamOutput output = new BytesStreamOutput();  
            new ScaleIndexShardResponse(
            )  
        List<ScaleIndexNodeResponse> nodeResponses = Collections.singletonList(new ScaleIndexNodeResponse(node, shardResponses));
    }
                shardId1,
        StreamInput input = output.bytes().streamInput();
 * compatible open source license.
        List<ScaleIndexNodeResponse> nodeResponses = new ArrayList<>();
        ScaleIndexResponse originalResponse = new ScaleIndexResponse(nodeResponses);  
        assertTrue("Failure reason should mention shard 1", failureReason.contains("Shard " + shardId1));  
        assertTrue("Failure reason should mention sync needed", failureReason.contains("needs sync"));
        // Convert to XContent
        ScaleIndexResponse response = new ScaleIndexResponse(nodeResponses);
    }  
                new ShardId(new Index("test_index", "test_uuid"), 0),  
import java.util.Collections;  
        );
        assertTrue("Failure reason should mention shard 1", failureReason.contains("Shard " + shardId1));  
        assertTrue("Failure reason should mention uncommitted operations", failureReason.contains("has uncommitted operations"));
        ScaleIndexResponse response = new ScaleIndexResponse(Collections.emptyList());
            Collections.emptyMap(),  
        );
        ScaleIndexResponse response = new ScaleIndexResponse(nodeResponses);  
        assertNull("Failure reason should be null", response.buildFailureReason());
            new ScaleIndexShardResponse(
import java.net.InetAddress;
        // Verify serialization preserved state
        nodeResponses.add(new ScaleIndexNodeResponse(node1, shardResponses1));  
        List<ScaleIndexShardResponse> shardResponses2 = Collections.singletonList(
        // Serialize
 */  
            new ScaleIndexShardResponse(
        );
        DiscoveryNode node = createTestNode();  
            new ScaleIndexShardResponse(  
                shardId1,  
                new ShardId(new Index("test_index", "test_uuid"), 0),  
        List<ScaleIndexNodeResponse> nodeResponses = Collections.singletonList(new ScaleIndexNodeResponse(node, shardResponses));
        DiscoveryNode node = createTestNode();  
        // Create an Index instance
        assertTrue("XContent should contain failure_reason field", json.contains("\"failure_reason\""));
 *
        assertTrue("Response should have failures", response.hasFailures());  
    public void testToXContent() throws Exception {
        DiscoveryNode node1 = createTestNode();
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        String failureReason = response.buildFailureReason();
        // Verify XContent output contains only the fields defined in toXContent()  
                0       // no uncommitted operations  
        assertNotNull("Failure reason should not be null", response.buildFailureReason());
            new TransportAddress(InetAddress.getByName("127.0.0.2"), 9300),
        );
            "test_node2",  
        assertEquals(
                new ShardId(new Index("test_index", "test_uuid"), 1),
            deserializedResponse.buildFailureReason()
                5       // has uncommitted operations  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.transport.TransportAddress;
                false,  // doesn't need sync
    public void testMultiNodeResponse() throws Exception {  
        assertNull("Empty response should have null failure reason", response.buildFailureReason());  
        // Add mixed success/failure responses  
        List<ScaleIndexNodeResponse> deserializedNodeResponses = input.readList(ScaleIndexNodeResponse::new);
            )
public class ScaleIndexResponseTests extends OpenSearchTestCase {
import org.opensearch.cluster.node.DiscoveryNode;
            Version.CURRENT
        shardResponses.add(
    }  
                0       // no uncommitted operations
                0       // no uncommitted operations
        // The failure reason will contain details about the failure
        ShardId shardId1 = new ShardId(index, 1);
        // Add successful shard responses
                3       // has uncommitted operations  
        assertTrue("Response should have failures due to node2", response.hasFailures());  
        // Create two nodes  
    }  
        // Create index and shards
        );
        );
            originalResponse.buildFailureReason(),  
import org.opensearch.core.common.io.stream.StreamInput;  
                0      // no uncommitted operations  
    public void testSuccessfulResponse() throws Exception {
        return new DiscoveryNode(
    public void testEmptyResponse() throws Exception {  
                true,   // needs sync
        assertFalse("Response should not have failures", response.hasFailures());  
        shardResponses.add(
}
        // Verify response state
        );
        DiscoveryNode node2 = new DiscoveryNode(
        String failureReason = response.buildFailureReason();
        List<ScaleIndexShardResponse> shardResponses = new ArrayList<>();  
import org.opensearch.core.index.shard.ShardId;  
        ScaleIndexResponse deserializedResponse = new ScaleIndexResponse(deserializedNodeResponses);  
import java.util.Set;
            new ScaleIndexShardResponse(  
        String json = builder.toString();
        Index index = new Index("test_index", "test_uuid");  
                true,   // needs sync
        assertTrue("Failure reason should mention node2", failureReason.contains("test_node2"));
import org.opensearch.core.xcontent.XContentBuilder;
            new ScaleIndexShardResponse(  
    public void testResponseWithFailures() throws Exception {
        List<ScaleIndexNodeResponse> nodeResponses = Collections.singletonList(new ScaleIndexNodeResponse(node, shardResponses));  
import java.util.List;
import org.opensearch.core.index.Index;
        // Verify empty response state
            )  
        DiscoveryNode node = createTestNode();
        // Deserialize - first read the node responses  
        );
        originalResponse.writeTo(output);
            Collections.emptyMap(),
        shardResponses.add(
        ShardId shardId0 = new ShardId(index, 0);
        List<ScaleIndexShardResponse> shardResponses1 = Collections.singletonList(
            )
            new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300),
        // Create test node and responses with no failures  
            "test_node_id",  
        );
        List<ScaleIndexShardResponse> shardResponses = new ArrayList<>();
        // Verify response state
                shardId0,  
            )
                2       // has uncommitted operations
        assertEquals("Failure state should match after serialization", originalResponse.hasFailures(), deserializedResponse.hasFailures());  
import org.opensearch.common.io.stream.BytesStreamOutput;
                false,  // doesn't need sync
                false,  // doesn't need sync
        List<ScaleIndexNodeResponse> nodeResponses = Collections.singletonList(new ScaleIndexNodeResponse(node, shardResponses));
                true,   // needs sync
            Set.of(DiscoveryNodeRole.DATA_ROLE),
        assertTrue("Failure reason should mention shard 0", failureReason.contains("Shard " + shardId0));
                shardId0,
        );  
            )
        shardResponses.add(
            Version.CURRENT
        // Verify the exact shard IDs appear in the failure reason
        ShardId shardId0 = new ShardId(index, 0);  
import java.util.ArrayList;
        );
        // Add another failed shard response (has uncommitted operations)  
    }
        List<ScaleIndexShardResponse> shardResponses = new ArrayList<>();
            new ScaleIndexShardResponse(  
            "test_node_id2",
        ShardId shardId1 = new ShardId(index, 1);
        // Verify multi-node response
            "test_node",
        XContentBuilder builder = XContentFactory.jsonBuilder();
        shardResponses.add(
            )  
    }
            )  
        // Create response with empty node responses
        assertFalse("Empty response should not have failures", response.hasFailures());
        // Add responses from both nodes
/*  
import org.opensearch.common.xcontent.XContentFactory;
        ScaleIndexResponse response = new ScaleIndexResponse(nodeResponses);  
 * this file be licensed under the Apache-2.0 license or a
        // Add a failed shard response (needs sync)
        Index index = new Index("test_index", "test_uuid");  
            "Failure reason should match after serialization",
                0       // no uncommitted operations
import org.opensearch.test.OpenSearchTestCase;
    public void testSerialization() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            Set.of(DiscoveryNodeRole.DATA_ROLE),  
            new ScaleIndexShardResponse(
        ScaleIndexResponse response = new ScaleIndexResponse(nodeResponses);  
    }
                false,  // doesn't need sync
        List<ScaleIndexShardResponse> shardResponses = new ArrayList<>();
    private DiscoveryNode createTestNode() throws Exception {  
        assertTrue("XContent should contain failure details", json.contains("Shard") && json.contains("needs sync"));  
package org.opensearch.action.admin.indices.scale.searchonly;
import org.opensearch.Version;
        nodeResponses.add(new ScaleIndexNodeResponse(node2, shardResponses2));
        DiscoveryNode node = createTestNode();
        shardResponses.add(
                new ShardId(new Index("test_index", "test_uuid"), 0),
