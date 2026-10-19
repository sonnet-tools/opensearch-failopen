            threadPool,
    private CapturingTransport transport;
 */
 * compatible open source license.
            Collections.emptySet(),
        IllegalArgumentException exception = expectThrows(
        }
            buildNewFakeTransportAddress(),
        try {
        );
        super.setUp();
import org.opensearch.index.store.remote.filecache.FileCache;
        );
            x -> clusterService.localNode(),
        );
            threadPool,
import java.util.Collections;
            Set.of(DiscoveryNodeRole.DATA_ROLE),
            PruneFileCacheRequest globalRequest = new PruneFileCacheRequest();
    private TransportPruneFileCacheAction action;
    }
import org.opensearch.action.support.ActionFilters;
import java.util.Arrays;
        CapturingTransport nullTransport = new CapturingTransport();
    public void setUp() throws Exception {
            new NodePruneFileCacheResponse(clusterService.state().nodes().get("warm-node-2"), 2097152L, 10737418240L)
    public void testWarmNodeResolution() {
import static org.mockito.Mockito.verify;
            action.resolveRequest(defaultRequest, clusterService.state());
            "warm-node-1",
    public void testSpecificNodeTargeting() {
        when(fileCache.prune()).thenReturn(1048576L);
        RuntimeException exception = expectThrows(RuntimeException.class, () -> action.nodeOperation(nodeRequest));
                threadPool,
import static org.mockito.Mockito.when;
        PruneFileCacheRequest globalRequest = new PruneFileCacheRequest();
        PruneFileCacheRequest request = new PruneFileCacheRequest();
            Set.of(DiscoveryNodeRole.WARM_ROLE),
            fail("Default request should not fail: " + e.getMessage());
            buildNewFakeTransportAddress(),
        assertNotNull("Aggregated response should not be null", aggregatedResponse);
/**
            new NodePruneFileCacheResponse(clusterService.state().nodes().get("warm-node-1"), 1048576L, 10737418240L),
import org.opensearch.cluster.node.DiscoveryNodes;
        transportService = transport.createTransportService(
            Version.CURRENT
import org.opensearch.test.transport.CapturingTransport;
        NodePruneFileCacheResponse response = action.nodeOperation(nodeRequest);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertTrue(
        action = new TransportPruneFileCacheAction(threadPool, clusterService, transportService, actionFilters, fileCache);
    }
        action.resolveRequest(specificRequest, clusterService.state());
            null,
        PruneFileCacheResponse aggregatedResponse = action.newResponse(request, responses, failures);
            assertEquals("Capacity should be 0 for null cache", 0L, response.getCacheCapacity());
            exception.getMessage().contains("FileCache operations can only target warm nodes")
        assertEquals("Should target warm-node-1", "warm-node-1", specificRequest.concreteNodes()[0].getId());
            "warm-node-1",
        transport.close();
            nullTransportService.close();
}
    public void testRequestPreparationAndTargeting() {
    }
        DiscoveryNode dataNode1 = new DiscoveryNode(
import org.opensearch.threadpool.ThreadPool;
            () -> action.resolveRequest(invalidRequest, clusterService.state())
        TransportPruneFileCacheAction.NodeRequest nodeRequest = new TransportPruneFileCacheAction.NodeRequest(globalRequest);
import java.util.Set;
        assertEquals("Pruned bytes should match", 1048576L, response.getPrunedBytes());
        );
        List<FailedNodeException> failures = Collections.emptyList();
            null,
            "data-node-1",
        nullTransportService.start();
        super.tearDown();
        }
        transportService.acceptIncomingRequests();
import org.opensearch.action.FailedNodeException;
        } finally {
import org.junit.Before;
import org.opensearch.cluster.ClusterState;
            Version.CURRENT
        );
        setState(clusterService, clusterState);
/*
    private void setupClusterWithWarmNodes() {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertEquals("Capacity should match", 10737418240L, response.getCacheCapacity());
        assertNotNull("Node request should not be null", nodeRequest);
            Set.of(DiscoveryNodeRole.WARM_ROLE),
 */
            Collections.emptyMap(),
    }
    private FileCache fileCache;
            nullTransport.close();
        threadPool = new TestThreadPool("test");
public class TransportPruneFileCacheActionTests extends OpenSearchTestCase {
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
            Version.CURRENT
            "warm-node-2",
    public void testInvalidNodeTargeting() {
            null
        assertTrue("Exception should mention failure", exception.getMessage().contains("failed"));
        ClusterState clusterState = ClusterState.builder(clusterService.getClusterName()).nodes(nodesBuilder).build();
 * The OpenSearch Contributors require contributions made to
        PruneFileCacheRequest defaultRequest = new PruneFileCacheRequest();
                "Should include warm-node-2",
            null
import static org.mockito.Mockito.mock;
                actionFilters,
import org.opensearch.threadpool.TestThreadPool;
        assertEquals("Should resolve to 1 warm node", 1, specificRequest.concreteNodes().length);
            "Error message should mention warm nodes",
        nodesBuilder.add(warmNode1).add(warmNode2).add(dataNode1);
        setupClusterWithWarmNodes();
    }
        List<NodePruneFileCacheResponse> responses = Arrays.asList(
        PruneFileCacheRequest globalRequest = new PruneFileCacheRequest();
            );
import java.util.List;
import org.opensearch.transport.TransportService;
 * this file be licensed under the Apache-2.0 license or a
        TransportPruneFileCacheAction.NodeRequest nodeRequest = action.newNodeRequest(request);
    private ClusterService clusterService;
            assertTrue(
    }
import static org.opensearch.test.ClusterServiceUtils.setState;
        assertTrue("Exception should contain node ID", exception.getMessage().contains("node"));
            clusterService.getSettings(),
        try {
import org.opensearch.cluster.service.ClusterService;
 * SPDX-License-Identifier: Apache-2.0
        );
import org.opensearch.Version;
        PruneFileCacheRequest specificRequest = new PruneFileCacheRequest("warm-node-1");
            Collections.emptyMap(),
        );
                Arrays.stream(defaultRequest.concreteNodes()).anyMatch(node -> "warm-node-1".equals(node.getId()))
                clusterService,
package org.opensearch.action.admin.cluster.filecache;
    }
        TransportPruneFileCacheAction.NodeRequest nodeRequest = new TransportPruneFileCacheAction.NodeRequest(globalRequest);
        nodesBuilder.clusterManagerNodeId(warmNode1.getId());
            );
                "Should include warm-node-1",
        transportService.start();
        assertNotNull("Response should not be null", response);
            Collections.emptySet(),
    }
            assertEquals("Pruned bytes should be 0 for null cache", 0L, response.getPrunedBytes());
                Arrays.stream(defaultRequest.concreteNodes()).anyMatch(node -> "warm-node-2".equals(node.getId()))
import org.opensearch.test.OpenSearchTestCase;
 *
        when(fileCache.prune()).thenThrow(new RuntimeException("Cache corruption"));
    }
        PruneFileCacheRequest request = new PruneFileCacheRequest();
        assertTrue("Should be completely successful", aggregatedResponse.isCompletelySuccessful());
        verify(fileCache).capacity();
        verify(fileCache).prune();
            clusterService.getSettings(),
        TransportService nullTransportService = nullTransport.createTransportService(
    }
        actionFilters = new ActionFilters(Collections.emptySet());
            IllegalArgumentException.class,
 * Tests enhanced multi-node architecture and warm node intelligence.
        clusterService.close();
import org.junit.After;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
import org.opensearch.cluster.node.DiscoveryNode;
    }
            );
            "warm-node-2",
        DiscoveryNode warmNode1 = new DiscoveryNode(
    public void tearDown() throws Exception {
        threadPool.shutdown();
        nullTransportService.acceptIncomingRequests();
        nodesBuilder.localNodeId(warmNode1.getId());
 * Tests for {@link TransportPruneFileCacheAction} using TransportNodesAction pattern.
            NodePruneFileCacheResponse response = nullCacheAction.nodeOperation(nodeRequest);
    private TransportService transportService;
            Collections.emptyMap(),
    private ThreadPool threadPool;
            assertEquals("Should resolve to 2 warm nodes", 2, defaultRequest.concreteNodes().length);
                null
        fileCache = mock(FileCache.class);
        when(fileCache.capacity()).thenReturn(10737418240L);
        } catch (IllegalArgumentException e) {
        PruneFileCacheRequest invalidRequest = new PruneFileCacheRequest("data-node-1");
    private ActionFilters actionFilters;
    public void testNullFileCache() {
            TransportPruneFileCacheAction.NodeRequest nodeRequest = new TransportPruneFileCacheAction.NodeRequest(globalRequest);
            "data-node-1",
        transport = new CapturingTransport();
    public void testNodeOperation() {
        assertEquals("Total pruned bytes should be sum", 3145728L, aggregatedResponse.getTotalPrunedBytes());
            buildNewFakeTransportAddress(),
            assertTrue(
        assertEquals("Node request should wrap original request", request, nodeRequest.getRequest());
    @Before
    public void testFileCacheException() {
    @After
            x -> clusterService.localNode(),
        );
        clusterService = createClusterService(threadPool);
        assertEquals("Should have 2 successful nodes", 2, aggregatedResponse.getNodes().size());
import org.opensearch.cluster.node.DiscoveryNodeRole;
        assertEquals("Should have no failures", 0, aggregatedResponse.failures().size());
            TransportPruneFileCacheAction nullCacheAction = new TransportPruneFileCacheAction(
                nullTransportService,
    public void testResponseAggregation() {
        DiscoveryNode warmNode2 = new DiscoveryNode(
