        );
        assertTrue("Should contain nodes section", jsonString.contains("\"nodes\""));
        PruneFileCacheRequest originalRequest = new PruneFileCacheRequest("node1", "node2");
            Collections.emptyList(),
    }
        PruneFileCacheResponse response = createMultiNodeResponse(1048576L, 2097152L);
        NodePruneFileCacheResponse originalResponse = new NodePruneFileCacheResponse(realNode, 1048576L, 10737418240L);  
/*  
        );
    }  
        if (prunedBytesPerNode.length > 0) {
            Collections.emptySet(),
        assertTrue("Should be acknowledged", deserializedResponse.isAcknowledged());
            new NodePruneFileCacheResponse(createRealNode("node1", "successful-node"), 1048576L, 10737418240L)
        DiscoveryNode realNode = createRealNode("test-node", "test-node-name");
            Collections.emptyList(),
 */  
        );
 *
import org.opensearch.cluster.ClusterName;  
        assertEquals("All-failure response total should be 0", 0L, allFailureResponse.getTotalPrunedBytes());
        StreamInput in = out.bytes().streamInput();  
        List<NodePruneFileCacheResponse> successfulNodes = Arrays.asList(
        assertFalse("Should not be completely successful", response.isCompletelySuccessful());  
        assertEquals("Node count should match", 2, deserializedResponse.getNodes().size());
        assertTrue("Should contain total_pruned_bytes", jsonString.contains("\"total_pruned_bytes\":3145728"));
        assertTrue("Should contain failed node ID", jsonString.contains("\"node_id\":\"node2\""));
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        assertNull("Targeted request validation should be null", targetedRequest.validate());
import org.opensearch.core.xcontent.ToXContent;
/**
    public void testPruneCacheRequestDefaultParameters() throws IOException {  
        PruneFileCacheRequest singleNodeRequest = new PruneFileCacheRequest("node1");  
        PruneFileCacheRequest originalRequest = new PruneFileCacheRequest();
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
        assertArrayEquals("Empty array should be preserved", new String[0], emptyRequest.nodesIds());
        StreamInput in = out.bytes().streamInput();  
        );
import java.io.IOException;  
    public void testPruneCacheResponseEnhancedJSON() throws IOException {  
        assertTrue("Should be partially successful", response.isPartiallySuccessful());
            new ClusterName("test"),
    }
    public void testPruneCacheRequestValidation() {  
        ClusterName clusterName = new ClusterName("test-cluster");
    }
            Collections.emptyMap(),
        assertTrue("Should contain failures array", jsonString.contains("\"failures\""));
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals("Zero bytes should sum correctly", 0L, zeroResponse.getTotalPrunedBytes());  
        PruneFileCacheResponse originalResponse = createMultiNodeResponse(1048576L, 2097152L);
        List<FailedNodeException> failures = Arrays.asList(
        assertEquals("Cache capacity should match", originalResponse.getCacheCapacity(), deserializedResponse.getCacheCapacity());
    public void testPruneCacheResponseJSONWithFailures() throws IOException {  
        originalRequest.writeTo(out);
        String jsonString = builder.toString();  
        List<FailedNodeException> failures = Collections.emptyList();
        );
import java.util.List;  
        PruneFileCacheRequest targetedRequest = new PruneFileCacheRequest("node1", "node2");
 * The OpenSearch Contributors require contributions made to  
        PruneFileCacheResponse largeResponse = createMultiNodeResponse(Long.MAX_VALUE / 2, Long.MAX_VALUE / 2);
public class PruneFileCacheRequestResponseTests extends OpenSearchTestCase {  
    }
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertTrue("Should contain successful_nodes count", jsonString.contains("\"successful_nodes\":2"));
        BytesStreamOutput out = new BytesStreamOutput();  
            for (int i = 0; i < prunedBytesPerNode.length; i++) {
        return new PruneFileCacheResponse(clusterName, nodeResponses, failures);  
    }  
                DiscoveryNode node = createRealNode("node" + i, "test-node-" + i);
    }
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.action.FailedNodeException;
        assertEquals("Empty response total should be 0", 0L, emptyResponse.getTotalPrunedBytes());
        PruneFileCacheResponse deserializedResponse = new PruneFileCacheResponse(in);
        assertEquals("Mixed results should sum correctly", 3145728L, mixedResponse.getTotalPrunedBytes());  
        PruneFileCacheRequest deserializedRequest = new PruneFileCacheRequest(in);
        assertTrue("Should contain acknowledged field", jsonString.contains("\"acknowledged\":true"));
import org.opensearch.common.io.stream.BytesStreamOutput;
        PruneFileCacheResponse emptyResponse = new PruneFileCacheResponse(  
    private DiscoveryNode createRealNode(String nodeId, String nodeName) {
        assertFalse("Should not be partially successful", deserializedResponse.isPartiallySuccessful());
        );
 * Tests for {@link PruneFileCacheRequest} and {@link PruneFileCacheResponse} with enhanced multi-node architecture.  
        PruneFileCacheRequest deserializedRequest = new PruneFileCacheRequest(in);
    }
        assertTrue("Should contain summary section", jsonString.contains("\"summary\""));  
        assertFalse("All-failure response should not be successful", allFailureResponse.isCompletelySuccessful());  
            nodeName,
        PruneFileCacheResponse response = new PruneFileCacheResponse(clusterName, successfulNodes, failures);  
        PruneFileCacheRequest multiNodeRequest = new PruneFileCacheRequest("node1", "node2", "node3");  
        originalResponse.writeTo(out);
        ClusterName clusterName = new ClusterName("test-cluster");
        PruneFileCacheRequest request = new PruneFileCacheRequest();
        assertArrayEquals("Multiple nodes should be set", new String[] { "node1", "node2", "node3" }, multiNodeRequest.nodesIds());
            new FailedNodeException("node2", "Test failure message", new RuntimeException("Root cause"))  
        assertTrue("Should contain caused_by", jsonString.contains("\"caused_by\":\"RuntimeException\""));
        List<NodePruneFileCacheResponse> successfulNodes = Arrays.asList(  
    public void testPruneCacheRequestNodeTargeting() {
    public void testResponseAggregationEdgeCases() {
    public void testPruneCacheRequestSerialization() throws IOException {  
            Version.CURRENT  
        StreamInput in = out.bytes().streamInput();
    public void testPruneCacheResponseScenarios() {
        assertEquals(originalRequest.timeout(), deserializedRequest.timeout());  
    }
import org.opensearch.common.xcontent.XContentFactory;  
    public void testPruneCacheResponseMultiNodeSerialization() throws IOException {  
        assertEquals("Pruned bytes should match", originalResponse.getPrunedBytes(), deserializedResponse.getPrunedBytes());
        );
 * Covers node targeting and rich response aggregation.
            buildNewFakeTransportAddress(),  
        assertFalse("All-failure response should not be partially successful", allFailureResponse.isPartiallySuccessful());
}  
import org.opensearch.Version;
package org.opensearch.action.admin.cluster.filecache;
        assertEquals("getPrunedBytes should work", 3145728L, deserializedResponse.getPrunedBytes());
            new FailedNodeException("node2", "Cache operation failed", new RuntimeException("Test failure"))
        assertEquals("Large values should sum correctly", Long.MAX_VALUE - 1, largeResponse.getTotalPrunedBytes());  
import java.util.Arrays;
        List<FailedNodeException> failures = Arrays.asList(  
        String jsonString = builder.toString();
    }
        assertArrayEquals(originalRequest.nodesIds(), deserializedRequest.nodesIds());  
        PruneFileCacheRequest defaultRequest = new PruneFileCacheRequest();  
                nodeResponses.add(new NodePruneFileCacheResponse(node, prunedBytesPerNode[i], 10737418240L));  
            Arrays.asList(new FailedNodeException("node1", "Test failure", new RuntimeException()))  
        BytesStreamOutput out = new BytesStreamOutput();  
            nodeId,
        }
        PruneFileCacheResponse mixedResponse = createMultiNodeResponse(1048576L, 0L, 2097152L);
        assertEquals("Should have one failure", 1, response.failures().size());
            }
            Collections.emptyList()  
 * compatible open source license.
        List<NodePruneFileCacheResponse> nodeResponses = Arrays.asList();
        assertEquals("Total pruned bytes should match", 3145728L, deserializedResponse.getTotalPrunedBytes());  
import org.opensearch.core.common.io.stream.StreamInput;
        assertTrue("Should be completely successful", deserializedResponse.isCompletelySuccessful());  
    public void testNodePruneCacheResponseSerialization() throws IOException {
 */
        originalResponse.writeTo(out);  
        NodePruneFileCacheResponse deserializedResponse = new NodePruneFileCacheResponse(in);  
        assertNull("Default request should have null nodeIds", defaultRequest.nodesIds());
            nodeResponses = new java.util.ArrayList<>();  
    }
    }
        PruneFileCacheResponse response = new PruneFileCacheResponse(clusterName, successfulNodes, failures);
        PruneFileCacheResponse allFailureResponse = new PruneFileCacheResponse(  
        assertFalse("Empty response should not be partially successful (no nodes processed)", emptyResponse.isPartiallySuccessful());
    public void testPruneCacheResponseWithFailures() {
        assertTrue("Should contain failed_nodes count", jsonString.contains("\"failed_nodes\":0"));  
        assertTrue("Should contain failure reason", jsonString.contains("\"reason\""));  
        assertArrayEquals("Single node should be set", new String[] { "node1" }, singleNodeRequest.nodesIds());
import java.util.Collections;
        ClusterName clusterName = new ClusterName("test-cluster");
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals("Should have one successful node", 1, response.getNodes().size());  
        assertFalse("Empty response should not be completely successful (no nodes processed)", emptyResponse.isCompletelySuccessful());  
    }
    private PruneFileCacheResponse createMultiNodeResponse(long... prunedBytesPerNode) {
            new ClusterName("test"),
        BytesStreamOutput out = new BytesStreamOutput();  
        return new DiscoveryNode(  
 * this file be licensed under the Apache-2.0 license or a
        originalRequest.writeTo(out);
        PruneFileCacheRequest emptyRequest = new PruneFileCacheRequest(new String[0]);  
        PruneFileCacheResponse zeroResponse = createMultiNodeResponse(0L, 0L);
        XContentBuilder builder = XContentFactory.jsonBuilder();
        StreamInput in = out.bytes().streamInput();  
            new NodePruneFileCacheResponse(createRealNode("node1", "good-node"), 1048576L, 10737418240L)  
        assertNull("Validation should be null", request.validate());
