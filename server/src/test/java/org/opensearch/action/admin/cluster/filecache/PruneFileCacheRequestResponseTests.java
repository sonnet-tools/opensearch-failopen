        originalResponse.writeTo(out);
        assertFalse("All-failure response should not be partially successful", allFailureResponse.isPartiallySuccessful());
        assertEquals("Cache capacity should match", originalResponse.getCacheCapacity(), deserializedResponse.getCacheCapacity());
        ClusterName clusterName = new ClusterName("test-cluster");
    }
        PruneFileCacheResponse mixedResponse = createMultiNodeResponse(1048576L, 0L, 2097152L);
        XContentBuilder builder = XContentFactory.jsonBuilder();
        PruneFileCacheRequest targetedRequest = new PruneFileCacheRequest("node1", "node2");
        assertFalse("All-failure response should not be successful", allFailureResponse.isCompletelySuccessful());
        BytesStreamOutput out = new BytesStreamOutput();
        assertFalse("Should not be completely successful", response.isCompletelySuccessful());
}
        assertEquals("All-failure response total should be 0", 0L, allFailureResponse.getTotalPrunedBytes());
    public void testPruneCacheResponseJSONWithFailures() throws IOException {
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
    public void testPruneCacheRequestDefaultParameters() throws IOException {
            new NodePruneFileCacheResponse(createRealNode("node1", "successful-node"), 1048576L, 10737418240L)
        StreamInput in = out.bytes().streamInput();
import org.opensearch.core.xcontent.XContentBuilder;
        StreamInput in = out.bytes().streamInput();
import java.io.IOException;
        PruneFileCacheResponse emptyResponse = new PruneFileCacheResponse(
        PruneFileCacheResponse response = new PruneFileCacheResponse(clusterName, successfulNodes, failures);
import org.opensearch.Version;
            nodeName,
        assertEquals("Large values should sum correctly", Long.MAX_VALUE - 1, largeResponse.getTotalPrunedBytes());
        PruneFileCacheResponse response = new PruneFileCacheResponse(clusterName, successfulNodes, failures);
            Collections.emptyMap(),
            buildNewFakeTransportAddress(),
        assertFalse("Empty response should not be partially successful (no nodes processed)", emptyResponse.isPartiallySuccessful());
    private DiscoveryNode createRealNode(String nodeId, String nodeName) {
        assertTrue("Should contain nodes section", jsonString.contains("\"nodes\""));
        PruneFileCacheResponse zeroResponse = createMultiNodeResponse(0L, 0L);
/*
        );
        ClusterName clusterName = new ClusterName("test-cluster");
        );
        PruneFileCacheRequest request = new PruneFileCacheRequest();
        StreamInput in = out.bytes().streamInput();
    }
        return new PruneFileCacheResponse(clusterName, nodeResponses, failures);
            Version.CURRENT
    }
    }
    public void testPruneCacheResponseEnhancedJSON() throws IOException {
    }
    }
        return new DiscoveryNode(
        PruneFileCacheRequest defaultRequest = new PruneFileCacheRequest();
        }
        PruneFileCacheResponse allFailureResponse = new PruneFileCacheResponse(
            Collections.emptyList()
        assertArrayEquals("Empty array should be preserved", new String[0], emptyRequest.nodesIds());
        assertEquals("Should have one successful node", 1, response.getNodes().size());
        DiscoveryNode realNode = createRealNode("test-node", "test-node-name");
        PruneFileCacheResponse response = createMultiNodeResponse(1048576L, 2097152L);
        assertNull("Validation should be null", request.validate());
        assertEquals("Node count should match", 2, deserializedResponse.getNodes().size());
public class PruneFileCacheRequestResponseTests extends OpenSearchTestCase {
        assertTrue("Should contain failures array", jsonString.contains("\"failures\""));
    private PruneFileCacheResponse createMultiNodeResponse(long... prunedBytesPerNode) {
import org.opensearch.action.FailedNodeException;
        PruneFileCacheRequest originalRequest = new PruneFileCacheRequest();
 */
package org.opensearch.action.admin.cluster.filecache;
        PruneFileCacheRequest multiNodeRequest = new PruneFileCacheRequest("node1", "node2", "node3");
                nodeResponses.add(new NodePruneFileCacheResponse(node, prunedBytesPerNode[i], 10737418240L));
        assertTrue("Should contain acknowledged field", jsonString.contains("\"acknowledged\":true"));
import org.opensearch.common.xcontent.XContentFactory;
        assertTrue("Should contain failed_nodes count", jsonString.contains("\"failed_nodes\":0"));
        assertEquals("Should have one failure", 1, response.failures().size());
    public void testResponseAggregationEdgeCases() {
        List<FailedNodeException> failures = Arrays.asList(
        PruneFileCacheRequest originalRequest = new PruneFileCacheRequest("node1", "node2");
        assertEquals("getPrunedBytes should work", 3145728L, deserializedResponse.getPrunedBytes());
        assertFalse("Should not be partially successful", deserializedResponse.isPartiallySuccessful());
        );
        List<FailedNodeException> failures = Arrays.asList(
 * Tests for {@link PruneFileCacheRequest} and {@link PruneFileCacheResponse} with enhanced multi-node architecture.
    }
        PruneFileCacheResponse originalResponse = createMultiNodeResponse(1048576L, 2097152L);
    public void testPruneCacheResponseScenarios() {
        ClusterName clusterName = new ClusterName("test-cluster");
        assertEquals("Mixed results should sum correctly", 3145728L, mixedResponse.getTotalPrunedBytes());
        List<NodePruneFileCacheResponse> nodeResponses = Arrays.asList();
            Collections.emptySet(),
        assertTrue("Should be completely successful", deserializedResponse.isCompletelySuccessful());
 *
    }
        originalRequest.writeTo(out);
import org.opensearch.core.xcontent.ToXContent;
            new ClusterName("test"),
    public void testPruneCacheRequestValidation() {
 */
            nodeResponses = new java.util.ArrayList<>();
                DiscoveryNode node = createRealNode("node" + i, "test-node-" + i);
        assertNull("Default request should have null nodeIds", defaultRequest.nodesIds());
        NodePruneFileCacheResponse originalResponse = new NodePruneFileCacheResponse(realNode, 1048576L, 10737418240L);
    }
        String jsonString = builder.toString();
        BytesStreamOutput out = new BytesStreamOutput();
            new NodePruneFileCacheResponse(createRealNode("node1", "good-node"), 1048576L, 10737418240L)
        assertTrue("Should contain summary section", jsonString.contains("\"summary\""));
import java.util.Collections;
import org.opensearch.common.io.stream.BytesStreamOutput;
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
        BytesStreamOutput out = new BytesStreamOutput();
        assertTrue("Should contain successful_nodes count", jsonString.contains("\"successful_nodes\":2"));
        List<NodePruneFileCacheResponse> successfulNodes = Arrays.asList(
import java.util.List;
        assertFalse("Empty response should not be completely successful (no nodes processed)", emptyResponse.isCompletelySuccessful());
        PruneFileCacheRequest deserializedRequest = new PruneFileCacheRequest(in);
        PruneFileCacheRequest singleNodeRequest = new PruneFileCacheRequest("node1");
    }
        List<NodePruneFileCacheResponse> successfulNodes = Arrays.asList(
        assertNull("Targeted request validation should be null", targetedRequest.validate());
            new FailedNodeException("node2", "Cache operation failed", new RuntimeException("Test failure"))
    public void testPruneCacheRequestNodeTargeting() {
/**
            new ClusterName("test"),
        assertArrayEquals(originalRequest.nodesIds(), deserializedRequest.nodesIds());
        assertArrayEquals("Single node should be set", new String[] { "node1" }, singleNodeRequest.nodesIds());
            }
        List<FailedNodeException> failures = Collections.emptyList();
    }
    }
        assertEquals("Empty response total should be 0", 0L, emptyResponse.getTotalPrunedBytes());
            Arrays.asList(new FailedNodeException("node1", "Test failure", new RuntimeException()))
        assertTrue("Should contain caused_by", jsonString.contains("\"caused_by\":\"RuntimeException\""));
            nodeId,
        assertArrayEquals("Multiple nodes should be set", new String[] { "node1", "node2", "node3" }, multiNodeRequest.nodesIds());
        BytesStreamOutput out = new BytesStreamOutput();
        assertTrue("Should contain failure reason", jsonString.contains("\"reason\""));
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
        originalResponse.writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;
        XContentBuilder builder = XContentFactory.jsonBuilder();
        originalRequest.writeTo(out);
        assertTrue("Should contain failed node ID", jsonString.contains("\"node_id\":\"node2\""));
        PruneFileCacheResponse largeResponse = createMultiNodeResponse(Long.MAX_VALUE / 2, Long.MAX_VALUE / 2);
    public void testPruneCacheResponseWithFailures() {
    public void testPruneCacheRequestSerialization() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        );
        assertEquals("Total pruned bytes should match", 3145728L, deserializedResponse.getTotalPrunedBytes());
    public void testPruneCacheResponseMultiNodeSerialization() throws IOException {
            Collections.emptyList(),
        );
    }
import org.opensearch.test.OpenSearchTestCase;
        assertTrue("Should be acknowledged", deserializedResponse.isAcknowledged());
        assertTrue("Should contain total_pruned_bytes", jsonString.contains("\"total_pruned_bytes\":3145728"));
import org.opensearch.cluster.node.DiscoveryNode;
            for (int i = 0; i < prunedBytesPerNode.length; i++) {
    public void testNodePruneCacheResponseSerialization() throws IOException {
 * Covers node targeting and rich response aggregation.
import java.util.Arrays;
            Collections.emptyList(),
        assertEquals("Zero bytes should sum correctly", 0L, zeroResponse.getTotalPrunedBytes());
        assertEquals("Pruned bytes should match", originalResponse.getPrunedBytes(), deserializedResponse.getPrunedBytes());
        NodePruneFileCacheResponse deserializedResponse = new NodePruneFileCacheResponse(in);
        );
        String jsonString = builder.toString();
        );
import org.opensearch.cluster.ClusterName;
        PruneFileCacheRequest deserializedRequest = new PruneFileCacheRequest(in);
        if (prunedBytesPerNode.length > 0) {
        StreamInput in = out.bytes().streamInput();
            new FailedNodeException("node2", "Test failure message", new RuntimeException("Root cause"))
        PruneFileCacheRequest emptyRequest = new PruneFileCacheRequest(new String[0]);
        assertTrue("Should be partially successful", response.isPartiallySuccessful());
        PruneFileCacheResponse deserializedResponse = new PruneFileCacheResponse(in);
        assertEquals(originalRequest.timeout(), deserializedRequest.timeout());
