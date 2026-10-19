        PruneFileCacheRequest globalRequest = new PruneFileCacheRequest();
            IllegalArgumentException.class,
            "warm-node-1",
import org.opensearch.threadpool.TestThreadPool;  
            fail("Default request should not fail: " + e.getMessage());  
            "data-node-1",
            new NodePruneFileCacheResponse(clusterService.state().nodes().get("warm-node-1"), 1048576L, 10737418240L),  
            TransportPruneFileCacheAction nullCacheAction = new TransportPruneFileCacheAction(
                Arrays.stream(defaultRequest.concreteNodes()).anyMatch(node -> "warm-node-2".equals(node.getId()))  
            buildNewFakeTransportAddress(),
    private void setupClusterWithWarmNodes() {  
            NodePruneFileCacheResponse response = nullCacheAction.nodeOperation(nodeRequest);  
        setupClusterWithWarmNodes();
        NodePruneFileCacheResponse response = action.nodeOperation(nodeRequest);
            null,
    public void testNodeOperation() {
            nullTransport.close();  
            "Error message should mention warm nodes",  
            Set.of(DiscoveryNodeRole.DATA_ROLE),
            "data-node-1",  
        transportService = transport.createTransportService(
import org.opensearch.cluster.ClusterState;
import org.opensearch.test.OpenSearchTestCase;
    }  
            clusterService.getSettings(),
import org.opensearch.cluster.node.DiscoveryNodeRole;  
    public void testRequestPreparationAndTargeting() {
        DiscoveryNode warmNode1 = new DiscoveryNode(  
import static org.opensearch.test.ClusterServiceUtils.setState;  
import org.opensearch.transport.TransportService;
        PruneFileCacheRequest request = new PruneFileCacheRequest();  
            assertEquals("Should resolve to 2 warm nodes", 2, defaultRequest.concreteNodes().length);
            Collections.emptySet(),
    private ClusterService clusterService;  
        when(fileCache.prune()).thenThrow(new RuntimeException("Cache corruption"));  
            );
        DiscoveryNode dataNode1 = new DiscoveryNode(
        RuntimeException exception = expectThrows(RuntimeException.class, () -> action.nodeOperation(nodeRequest));
            Version.CURRENT
        assertNotNull("Aggregated response should not be null", aggregatedResponse);
        PruneFileCacheRequest invalidRequest = new PruneFileCacheRequest("data-node-1");
package org.opensearch.action.admin.cluster.filecache;
                "Should include warm-node-2",
        } catch (IllegalArgumentException e) {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        TransportPruneFileCacheAction.NodeRequest nodeRequest = new TransportPruneFileCacheAction.NodeRequest(globalRequest);  
        try {  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        assertNotNull("Response should not be null", response);
        threadPool.shutdown();
    public void setUp() throws Exception {
                threadPool,
        assertTrue("Exception should mention failure", exception.getMessage().contains("failed"));
    public void testSpecificNodeTargeting() {
        PruneFileCacheResponse aggregatedResponse = action.newResponse(request, responses, failures);  
        IllegalArgumentException exception = expectThrows(  
        super.setUp();  
        threadPool = new TestThreadPool("test");
            Collections.emptyMap(),  
 */  
            TransportPruneFileCacheAction.NodeRequest nodeRequest = new TransportPruneFileCacheAction.NodeRequest(globalRequest);
            nullTransportService.close();
                Arrays.stream(defaultRequest.concreteNodes()).anyMatch(node -> "warm-node-1".equals(node.getId()))
        );  
                nullTransportService,
        TransportPruneFileCacheAction.NodeRequest nodeRequest = new TransportPruneFileCacheAction.NodeRequest(globalRequest);  
        nodesBuilder.localNodeId(warmNode1.getId());  
        assertNotNull("Node request should not be null", nodeRequest);  
            x -> clusterService.localNode(),  
        );
    private TransportPruneFileCacheAction action;
        clusterService.close();  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
 *
            );  
            threadPool,
    }  
        assertEquals("Should have no failures", 0, aggregatedResponse.failures().size());
    }
        transport = new CapturingTransport();  
            buildNewFakeTransportAddress(),
    private TransportService transportService;
        fileCache = mock(FileCache.class);  
        assertTrue(
        when(fileCache.prune()).thenReturn(1048576L);  
            Set.of(DiscoveryNodeRole.WARM_ROLE),
import static org.mockito.Mockito.when;  
import static org.mockito.Mockito.verify;
        PruneFileCacheRequest request = new PruneFileCacheRequest();  
        );
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(
        );
import org.opensearch.test.transport.CapturingTransport;
            new NodePruneFileCacheResponse(clusterService.state().nodes().get("warm-node-2"), 2097152L, 10737418240L)
                null  
            "warm-node-1",
    }  
    }
/**
            "warm-node-2",  
            );
        }
                actionFilters,
    private FileCache fileCache;
    public void testResponseAggregation() {
        nodesBuilder.add(warmNode1).add(warmNode2).add(dataNode1);
import org.opensearch.action.support.ActionFilters;  
import java.util.List;
            exception.getMessage().contains("FileCache operations can only target warm nodes")
            assertEquals("Capacity should be 0 for null cache", 0L, response.getCacheCapacity());  
        DiscoveryNode warmNode2 = new DiscoveryNode(
import org.junit.After;  
        PruneFileCacheRequest specificRequest = new PruneFileCacheRequest("warm-node-1");  
            Version.CURRENT
        List<NodePruneFileCacheResponse> responses = Arrays.asList(
        super.tearDown();  
        } finally {
    private CapturingTransport transport;
        clusterService = createClusterService(threadPool);
            Set.of(DiscoveryNodeRole.WARM_ROLE),
    }
    }
            null,
    private ThreadPool threadPool;
        assertEquals("Should resolve to 1 warm node", 1, specificRequest.concreteNodes().length);
 */
            assertEquals("Pruned bytes should be 0 for null cache", 0L, response.getPrunedBytes());
/*  
        nullTransportService.acceptIncomingRequests();
        PruneFileCacheRequest globalRequest = new PruneFileCacheRequest();
    }  
 * Tests enhanced multi-node architecture and warm node intelligence.
        );  
public class TransportPruneFileCacheActionTests extends OpenSearchTestCase {  
import org.opensearch.index.store.remote.filecache.FileCache;  
    }
            PruneFileCacheRequest globalRequest = new PruneFileCacheRequest();  
        ClusterState clusterState = ClusterState.builder(clusterService.getClusterName()).nodes(nodesBuilder).build();  
        );  
        TransportPruneFileCacheAction.NodeRequest nodeRequest = action.newNodeRequest(request);
            action.resolveRequest(defaultRequest, clusterService.state());  
            Collections.emptyMap(),
        actionFilters = new ActionFilters(Collections.emptySet());
        assertEquals("Should target warm-node-1", "warm-node-1", specificRequest.concreteNodes()[0].getId());
        TransportService nullTransportService = nullTransport.createTransportService(  
import java.util.Set;  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Should have 2 successful nodes", 2, aggregatedResponse.getNodes().size());  
 * Tests for {@link TransportPruneFileCacheAction} using TransportNodesAction pattern.  
        setState(clusterService, clusterState);
 * compatible open source license.
            null
        CapturingTransport nullTransport = new CapturingTransport();
            threadPool,
        nodesBuilder.clusterManagerNodeId(warmNode1.getId());
                "Should include warm-node-1",
}
            Collections.emptySet(),  
import org.junit.Before;
        );
        assertTrue("Exception should contain node ID", exception.getMessage().contains("node"));
            Collections.emptyMap(),  
    public void testWarmNodeResolution() {
    public void tearDown() throws Exception {
        assertEquals("Capacity should match", 10737418240L, response.getCacheCapacity());  
            "warm-node-2",
import org.opensearch.cluster.service.ClusterService;
    }
        PruneFileCacheRequest defaultRequest = new PruneFileCacheRequest();  
                clusterService,  
        when(fileCache.capacity()).thenReturn(10737418240L);
        assertTrue("Should be completely successful", aggregatedResponse.isCompletelySuccessful());  
            assertTrue(  
            clusterService.getSettings(),  
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
        transportService.acceptIncomingRequests();  
        verify(fileCache).prune();
        assertEquals("Node request should wrap original request", request, nodeRequest.getRequest());
        assertEquals("Pruned bytes should match", 1048576L, response.getPrunedBytes());
        verify(fileCache).capacity();  
    }
 * The OpenSearch Contributors require contributions made to  
        try {
        action.resolveRequest(specificRequest, clusterService.state());
import org.opensearch.action.FailedNodeException;
import java.util.Collections;
        nullTransportService.start();  
            () -> action.resolveRequest(invalidRequest, clusterService.state())
    @After
        );
        }
        List<FailedNodeException> failures = Collections.emptyList();
import org.opensearch.cluster.node.DiscoveryNodes;
        assertEquals("Total pruned bytes should be sum", 3145728L, aggregatedResponse.getTotalPrunedBytes());
            buildNewFakeTransportAddress(),  
        transportService.start();
        action = new TransportPruneFileCacheAction(threadPool, clusterService, transportService, actionFilters, fileCache);
            null  
        transport.close();
import org.opensearch.Version;
    public void testNullFileCache() {  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.node.DiscoveryNode;
            x -> clusterService.localNode(),
import static org.mockito.Mockito.mock;
    @Before
            Version.CURRENT  
import java.util.Arrays;  
    private ActionFilters actionFilters;  
    public void testInvalidNodeTargeting() {
    public void testFileCacheException() {
