                actionFilters,
 */  
        assertEquals(2, response.getNodes().size());  
        BlockCache failingCache = mock(BlockCache.class);  
import org.opensearch.test.transport.CapturingTransport;  
            Version.CURRENT  
import static org.mockito.Mockito.when;
import org.opensearch.cluster.node.DiscoveryNode;
    public void testResponseAggregationWithFailure() {
        expectThrows(IllegalArgumentException.class, () -> action.resolveRequest(request, clusterService.state()));
            x -> clusterService.localNode(),
                clusterService,  
        assertEquals(0, response.failures().size());
            "warm-node-1",  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
        );
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.plugins.BlockCache;  
                new TransportPruneBlockCacheAction.NodeRequest(request)
        setupClusterWithWarmNodes();
            "data-node-1",
import java.util.Arrays;
            PruneBlockCacheRequest request = new PruneBlockCacheRequest();
            null
            Set.of(DiscoveryNodeRole.WARM_ROLE),
        threadPool.shutdown();  
    public void testNodeOperationPartialFailure() {
    private CapturingTransport transport;
        assertEquals("warm-node-1", request.concreteNodes()[0].getId());  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        when(blockCache.clear()).thenReturn(true);
            Collections.emptySet(),  
import org.junit.Before;
            buildNewFakeTransportAddress(),  
            Version.CURRENT
            clusterService.getSettings(),
                null  
        assertEquals(1, request.concreteNodes().length);
            null,
        assertEquals(1, response.getNodes().size());
        PruneBlockCacheRequest request = new PruneBlockCacheRequest("data-node-1");
            "warm-node-2",
        NodePruneBlockCacheResponse response = action.nodeOperation(new TransportPruneBlockCacheAction.NodeRequest(request));
        PruneBlockCacheRequest request = new PruneBlockCacheRequest();
import org.opensearch.action.support.ActionFilters;  
        transportService = transport.createTransportService(
        );
import static org.opensearch.test.ClusterServiceUtils.setState;
        super.tearDown();
        clusterService = createClusterService(threadPool);
    private ActionFilters actionFilters;  
 * SPDX-License-Identifier: Apache-2.0
        );  
        PruneBlockCacheResponse response = action.newResponse(new PruneBlockCacheRequest(), responses, failures);
        assertTrue("cleared should be true", response.isCleared());
    public void tearDown() throws Exception {
        transportService.acceptIncomingRequests();  
        assertTrue(Arrays.stream(request.concreteNodes()).anyMatch(n -> "warm-node-2".equals(n.getId())));
import org.opensearch.cluster.ClusterState;
        assertTrue(Arrays.stream(request.concreteNodes()).anyMatch(n -> "warm-node-1".equals(n.getId())));  
            assertFalse("cleared should be false when registry is null", response.isCleared());  
        PruneBlockCacheRequest request = new PruneBlockCacheRequest();
            NodePruneBlockCacheResponse response = nullRegistryAction.nodeOperation(  
            Collections.emptyMap(),  
        List<NodePruneBlockCacheResponse> responses = Collections.singletonList(
    private void setupClusterWithWarmNodes() {
        DiscoveryNode warmNode2 = new DiscoveryNode(  
        PruneBlockCacheRequest request = new PruneBlockCacheRequest();
            "warm-node-1",
            nullTransport.close();  
        DiscoveryNode dataNode = new DiscoveryNode(
        NodePruneBlockCacheResponse response = action.nodeOperation(new TransportPruneBlockCacheAction.NodeRequest(request));
            new NodePruneBlockCacheResponse(clusterService.state().nodes().get("warm-node-2"), true)
            TransportPruneBlockCacheAction nullRegistryAction = new TransportPruneBlockCacheAction(
    public void testWarmNodeResolution() {
        transportService.start();
            "data-node-1",  
        );
import org.opensearch.test.OpenSearchTestCase;
        registry = mock(BlockCacheRegistry.class);
import java.util.List;  
            Set.of(DiscoveryNodeRole.WARM_ROLE),  
/*  
import org.opensearch.action.FailedNodeException;
    public void testNullRegistry() {
            x -> clusterService.localNode(),  
            threadPool,
                nullTransportService,
        );
            );
        DiscoveryNode warmNode1 = new DiscoveryNode(
            null  
    }
            threadPool,
            nullTransportService.close();
        when(registry.all()).thenReturn(List.of(blockCache));  
import org.opensearch.threadpool.ThreadPool;
        List<NodePruneBlockCacheResponse> responses = Arrays.asList(  
    }  
        TransportService nullTransportService = nullTransport.createTransportService(  
            "warm-node-2",
    public void testNodeOperation() {  
    }
        transport.close();
 *
import java.util.Collections;
        );
        assertFalse("cleared should be false when any cache fails", response.isCleared());
    }
        nullTransportService.acceptIncomingRequests();
    public void testNonWarmNodeTargetingThrows() {  
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();  
            new FailedNodeException("warm-node-2", "simulated failure", new RuntimeException())  
        setState(clusterService, ClusterState.builder(clusterService.getClusterName()).nodes(nodesBuilder).build());  
}
    @Before
            Version.CURRENT
            );
            null,
                threadPool,
    }  
        threadPool = new TestThreadPool("test");
 * compatible open source license.
    public void testResponseAggregation() {
    }
        } finally {
import java.util.Set;
import static org.mockito.Mockito.verify;  
    @After  
        when(registry.all()).thenReturn(List.of(blockCache, failingCache));
    }
    }
        verify(blockCache).clear();
    }  
        action.resolveRequest(request, clusterService.state());  
        PruneBlockCacheResponse response = action.newResponse(new PruneBlockCacheRequest(), responses, Collections.emptyList());
        List<FailedNodeException> failures = Collections.singletonList(
        nodesBuilder.localNodeId(warmNode1.getId()).clusterManagerNodeId(warmNode1.getId());
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.transport.TransportService;  
        transport = new CapturingTransport();  
        action = new TransportPruneBlockCacheAction(threadPool, clusterService, transportService, actionFilters, registry);  
import org.opensearch.Version;
        action.resolveRequest(request, clusterService.state());  
import org.opensearch.cluster.service.ClusterService;
    public void testSpecificNodeTargeting() {
            buildNewFakeTransportAddress(),
            new NodePruneBlockCacheResponse(clusterService.state().nodes().get("warm-node-1"), true),
        when(failingCache.clear()).thenReturn(false);
        blockCache = mock(BlockCache.class);  
    private ThreadPool threadPool;
            buildNewFakeTransportAddress(),
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.admin.cluster.blockcache;
            Set.of(DiscoveryNodeRole.DATA_ROLE),
    private BlockCacheRegistry registry;
import org.opensearch.plugins.BlockCacheRegistry;
    }  
        assertEquals(2, request.concreteNodes().length);
        nullTransportService.start();  
    }
            Collections.emptySet(),
            Collections.emptyMap(),
    private TransportService transportService;
            new NodePruneBlockCacheResponse(clusterService.state().nodes().get("warm-node-1"), true)  
public class TransportPruneBlockCacheActionTests extends OpenSearchTestCase {  
        );
        PruneBlockCacheRequest request = new PruneBlockCacheRequest("warm-node-1");
    private TransportPruneBlockCacheAction action;  
    public void setUp() throws Exception {  
        actionFilters = new ActionFilters(Collections.emptySet());
        CapturingTransport nullTransport = new CapturingTransport();
        nodesBuilder.add(warmNode1).add(warmNode2).add(dataNode);
            clusterService.getSettings(),  
        assertEquals(1, response.failures().size());
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        );  
    private ClusterService clusterService;  
    private BlockCache blockCache;
        try {  
import org.opensearch.threadpool.TestThreadPool;
        clusterService.close();
            Collections.emptyMap(),
        super.setUp();
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.mock;
import org.junit.After;
        }
