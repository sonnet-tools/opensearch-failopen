            "test_node_id2",
        // Verify serialization preserved state
                new ShardId(new Index("test_index", "test_uuid"), 0),
    public void testResponseWithFailures() throws Exception {
        );
        assertTrue("Failure reason should mention node2", failureReason.contains("test_node2"));
        response.toXContent(builder, null);
    }
        // Create index and shards
    }
        // Add responses from both nodes
                true,   // needs sync
        // Add successful shard responses
            new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300),
    public void testSuccessfulResponse() throws Exception {
            )
import org.opensearch.Version;
                true,   // needs sync
    public void testSerialization() throws Exception {
                0      // no uncommitted operations
        DiscoveryNode node1 = createTestNode();
        assertTrue("Response should have failures due to node2", response.hasFailures());
        shardResponses.add(
        DiscoveryNode node = createTestNode();
    }
        assertTrue("XContent should contain failure details", json.contains("Shard") && json.contains("needs sync"));
        assertNull("Empty response should have null failure reason", response.buildFailureReason());
    public void testEmptyResponse() throws Exception {
            Collections.emptyMap(),
        ScaleIndexResponse originalResponse = new ScaleIndexResponse(nodeResponses);
        XContentBuilder builder = XContentFactory.jsonBuilder();
    }
                5       // has uncommitted operations
                0       // no uncommitted operations
 * SPDX-License-Identifier: Apache-2.0
}
        List<ScaleIndexShardResponse> shardResponses2 = Collections.singletonList(
        // Verify empty response state
        List<ScaleIndexShardResponse> shardResponses = new ArrayList<>();
                shardId1,
                shardId0,
        BytesStreamOutput output = new BytesStreamOutput();
import org.opensearch.core.index.shard.ShardId;
 * compatible open source license.
        assertFalse("Response should not have failures", response.hasFailures());
        assertNull("Failure reason should be null", response.buildFailureReason());
import org.opensearch.common.io.stream.BytesStreamOutput;
        ShardId shardId1 = new ShardId(index, 1);
        assertTrue("Failure reason should mention shard 1", failureReason.contains("Shard " + shardId1));
import java.util.List;
        ShardId shardId0 = new ShardId(index, 0);
        List<ScaleIndexNodeResponse> nodeResponses = Collections.singletonList(new ScaleIndexNodeResponse(node, shardResponses));
        ScaleIndexResponse response = new ScaleIndexResponse(Collections.emptyList());
/*
        List<ScaleIndexShardResponse> shardResponses = new ArrayList<>();
                0       // no uncommitted operations
        assertEquals("Failure state should match after serialization", originalResponse.hasFailures(), deserializedResponse.hasFailures());
        // Serialize
        List<ScaleIndexNodeResponse> nodeResponses = Collections.singletonList(new ScaleIndexNodeResponse(node, shardResponses));
        assertTrue("Failure reason should mention sync needed", failureReason.contains("needs sync"));
            new ScaleIndexShardResponse(
        ShardId shardId0 = new ShardId(index, 0);
        List<ScaleIndexShardResponse> shardResponses = new ArrayList<>();
        String failureReason = response.buildFailureReason();
            Set.of(DiscoveryNodeRole.DATA_ROLE),
        );
        );
        // Add a failed shard response (needs sync)
                new ShardId(new Index("test_index", "test_uuid"), 0),
            Version.CURRENT
        ShardId shardId1 = new ShardId(index, 1);
            originalResponse.buildFailureReason(),
                false,  // doesn't need sync
            "test_node2",
    }
import java.util.Set;
                0       // no uncommitted operations
        // Add a failed shard response
        assertNotNull("Failure reason should not be null", response.buildFailureReason());
        // Verify multi-node response
        ScaleIndexResponse response = new ScaleIndexResponse(nodeResponses);
        // Verify response state
        );
            new TransportAddress(InetAddress.getByName("127.0.0.2"), 9300),
        );
import org.opensearch.common.xcontent.XContentFactory;
        assertTrue("XContent should contain failure_reason field", json.contains("\"failure_reason\""));
 * this file be licensed under the Apache-2.0 license or a
        List<ScaleIndexShardResponse> shardResponses = new ArrayList<>();
        // Verify XContent output contains only the fields defined in toXContent()
        assertTrue("Failure reason should mention shard 1", failureReason.contains("Shard " + shardId1));
            )
        ScaleIndexResponse response = new ScaleIndexResponse(nodeResponses);
                true,   // needs sync
                shardId0,
                true,   // needs sync
        List<ScaleIndexNodeResponse> deserializedNodeResponses = input.readList(ScaleIndexNodeResponse::new);
        assertTrue("Failure reason should mention shard 0", failureReason.contains("Shard " + shardId0));
            Version.CURRENT
        ScaleIndexResponse deserializedResponse = new ScaleIndexResponse(deserializedNodeResponses);
            "test_node_id",
        List<ScaleIndexNodeResponse> nodeResponses = new ArrayList<>();
        assertEquals(
            )
        Index index = new Index("test_index", "test_uuid");
        List<ScaleIndexNodeResponse> nodeResponses = Collections.singletonList(new ScaleIndexNodeResponse(node, shardResponses));
 * The OpenSearch Contributors require contributions made to
 *
        // Create an Index instance
                false,  // doesn't need sync
            Set.of(DiscoveryNodeRole.DATA_ROLE),
                false,  // doesn't need sync
import org.opensearch.core.xcontent.XContentBuilder;
    }
        List<ScaleIndexShardResponse> shardResponses1 = Collections.singletonList(
        StreamInput input = output.bytes().streamInput();
        // Convert to XContent
package org.opensearch.action.admin.indices.scale.searchonly;
        return new DiscoveryNode(
        );
                0       // no uncommitted operations
        );
        // Deserialize - first read the node responses
        );
            deserializedResponse.buildFailureReason()
        // Create response with empty node responses
    public void testToXContent() throws Exception {
        originalResponse.writeTo(output);
                new ShardId(new Index("test_index", "test_uuid"), 1),
            new ScaleIndexShardResponse(
            "test_node",
    }
import java.net.InetAddress;
        shardResponses.add(
        // Create test node and responses with no failures
        );
            new ScaleIndexShardResponse(
        DiscoveryNode node2 = new DiscoveryNode(
                new ShardId(new Index("test_index", "test_uuid"), 0),
            )
        );
            )
        shardResponses.add(
        // Add another failed shard response (has uncommitted operations)
        assertTrue("Failure reason should mention uncommitted operations", failureReason.contains("has uncommitted operations"));
            new ScaleIndexShardResponse(
            )
        assertFalse("Empty response should not have failures", response.hasFailures());
public class ScaleIndexResponseTests extends OpenSearchTestCase {
        String failureReason = response.buildFailureReason();
            "Failure reason should match after serialization",
    private DiscoveryNode createTestNode() throws Exception {
        String json = builder.toString();
import org.opensearch.core.common.io.stream.StreamInput;
        // The failure reason will contain details about the failure
            Collections.emptyMap(),
                shardId1,
import org.opensearch.test.OpenSearchTestCase;
        // Create two nodes
        );
import org.opensearch.cluster.node.DiscoveryNode;
        ScaleIndexResponse response = new ScaleIndexResponse(nodeResponses);
        shardResponses.add(
        // Verify the exact shard IDs appear in the failure reason
import org.opensearch.core.index.Index;
        // Verify response state
        ScaleIndexResponse response = new ScaleIndexResponse(nodeResponses);
        shardResponses.add(
import java.util.Collections;
            )
                false,  // doesn't need sync
                3       // has uncommitted operations
import org.opensearch.cluster.node.DiscoveryNodeRole;
        nodeResponses.add(new ScaleIndexNodeResponse(node1, shardResponses1));
        DiscoveryNode node = createTestNode();
            new ScaleIndexShardResponse(
        Index index = new Index("test_index", "test_uuid");
            new ScaleIndexShardResponse(
            new ScaleIndexShardResponse(
        List<ScaleIndexNodeResponse> nodeResponses = Collections.singletonList(new ScaleIndexNodeResponse(node, shardResponses));
        DiscoveryNode node = createTestNode();
 */
                2       // has uncommitted operations
import java.util.ArrayList;
            )
        shardResponses.add(
        DiscoveryNode node = createTestNode();
        // Add mixed success/failure responses
        nodeResponses.add(new ScaleIndexNodeResponse(node2, shardResponses2));
import org.opensearch.core.common.transport.TransportAddress;
            new ScaleIndexShardResponse(
    public void testMultiNodeResponse() throws Exception {
        assertTrue("Response should have failures", response.hasFailures());
