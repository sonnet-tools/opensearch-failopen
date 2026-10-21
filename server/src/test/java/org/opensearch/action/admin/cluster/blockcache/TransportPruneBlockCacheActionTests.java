import org.opensearch.cluster.node.DiscoveryNodeRole;
            new FailedNodeException("warm-node-2", "simulated failure", new RuntimeException())
        blockCache = mock(BlockCache.class);
    @After
            Collections.emptyMap(),
    }
    private ThreadPool threadPool;
        transportService.acceptIncomingRequests();
        clusterService.close();
        assertEquals(1, response.getNodes().size());
 */
        action = new TransportPruneBlockCacheAction(threadPool, clusterService, transportService, actionFilters, registry);
        nodesBuilder.add(warmNode1).add(warmNode2).add(dataNode);
        super.setUp();
public class TransportPruneBlockCacheActionTests extends OpenSearchTestCase {
            Collections.emptySet(),
        );
        setState(clusterService, ClusterState.builder(clusterService.getClusterName()).nodes(nodesBuilder).build());
        TransportService nullTransportService = nullTransport.createTransportService(
            nullTransport.close();
        CapturingTransport nullTransport = new CapturingTransport();
        DiscoveryNode warmNode1 = new DiscoveryNode(
        PruneBlockCacheResponse response = action.newResponse(new PruneBlockCacheRequest(), responses, Collections.emptyList());
            "data-node-1",
    }
        List<NodePruneBlockCacheResponse> responses = Arrays.asList(
            Set.of(DiscoveryNodeRole.DATA_ROLE),
        assertTrue("cleared should be true", response.isCleared());
        expectThrows(IllegalArgumentException.class, () -> action.resolveRequest(request, clusterService.state()));
    public void testWarmNodeResolution() {
            );
import org.opensearch.plugins.BlockCacheRegistry;
        transport = new CapturingTransport();
    }
        setupClusterWithWarmNodes();
        );
        assertEquals(0, response.failures().size());
            "warm-node-1",
    private void setupClusterWithWarmNodes() {
import java.util.Collections;
            "warm-node-1",
            new NodePruneBlockCacheResponse(clusterService.state().nodes().get("warm-node-2"), true)
    }
            null,
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.Version;
    public void testNonWarmNodeTargetingThrows() {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            TransportPruneBlockCacheAction nullRegistryAction = new TransportPruneBlockCacheAction(
        action.resolveRequest(request, clusterService.state());
            Version.CURRENT
import static org.mockito.Mockito.mock;
    private ClusterService clusterService;
        nullTransportService.start();
            nullTransportService.close();
    }
import org.opensearch.action.FailedNodeException;
    }
        assertFalse("cleared should be false when any cache fails", response.isCleared());
        verify(blockCache).clear();
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.node.DiscoveryNode;
            );
    public void testNullRegistry() {
import org.opensearch.test.transport.CapturingTransport;
import org.opensearch.cluster.node.DiscoveryNodes;
    public void setUp() throws Exception {
import org.opensearch.threadpool.ThreadPool;
            new NodePruneBlockCacheResponse(clusterService.state().nodes().get("warm-node-1"), true)
    private BlockCacheRegistry registry;
        nullTransportService.acceptIncomingRequests();
        );
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
        PruneBlockCacheRequest request = new PruneBlockCacheRequest("warm-node-1");
            threadPool,
        when(failingCache.clear()).thenReturn(false);
        when(registry.all()).thenReturn(List.of(blockCache, failingCache));
        PruneBlockCacheResponse response = action.newResponse(new PruneBlockCacheRequest(), responses, failures);
            null
            Set.of(DiscoveryNodeRole.WARM_ROLE),
        assertEquals("warm-node-1", request.concreteNodes()[0].getId());
    public void tearDown() throws Exception {
        clusterService = createClusterService(threadPool);
        transportService = transport.createTransportService(
    private TransportService transportService;
            NodePruneBlockCacheResponse response = nullRegistryAction.nodeOperation(
        transportService.start();
import static org.mockito.Mockito.when;
import java.util.List;
        registry = mock(BlockCacheRegistry.class);
                actionFilters,
        DiscoveryNode dataNode = new DiscoveryNode(
                new TransportPruneBlockCacheAction.NodeRequest(request)
                clusterService,
    public void testSpecificNodeTargeting() {
        } finally {
    private CapturingTransport transport;
            threadPool,
import org.opensearch.threadpool.TestThreadPool;
import org.junit.Before;
    @Before
    }
                threadPool,
            Version.CURRENT
        assertEquals(1, response.failures().size());
        transport.close();
import java.util.Set;
import org.opensearch.plugins.BlockCache;
        PruneBlockCacheRequest request = new PruneBlockCacheRequest();
        );
            buildNewFakeTransportAddress(),
        nodesBuilder.localNodeId(warmNode1.getId()).clusterManagerNodeId(warmNode1.getId());
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
    private BlockCache blockCache;
        DiscoveryNode warmNode2 = new DiscoveryNode(
        PruneBlockCacheRequest request = new PruneBlockCacheRequest();
    }
            assertFalse("cleared should be false when registry is null", response.isCleared());
}
package org.opensearch.action.admin.cluster.blockcache;
import java.util.Arrays;
    public void testResponseAggregationWithFailure() {
        );
        );
    }
        NodePruneBlockCacheResponse response = action.nodeOperation(new TransportPruneBlockCacheAction.NodeRequest(request));
        assertTrue(Arrays.stream(request.concreteNodes()).anyMatch(n -> "warm-node-2".equals(n.getId())));
            PruneBlockCacheRequest request = new PruneBlockCacheRequest();
    private ActionFilters actionFilters;
                nullTransportService,
import org.opensearch.cluster.ClusterState;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
            x -> clusterService.localNode(),
        NodePruneBlockCacheResponse response = action.nodeOperation(new TransportPruneBlockCacheAction.NodeRequest(request));
        threadPool.shutdown();
    }
            clusterService.getSettings(),
        );
            buildNewFakeTransportAddress(),
/*
            buildNewFakeTransportAddress(),
        assertEquals(2, response.getNodes().size());
    public void testResponseAggregation() {
            null
        );
    private TransportPruneBlockCacheAction action;
import static org.opensearch.test.ClusterServiceUtils.setState;
            x -> clusterService.localNode(),
            Collections.emptySet(),
        when(registry.all()).thenReturn(List.of(blockCache));
        actionFilters = new ActionFilters(Collections.emptySet());
        assertEquals(2, request.concreteNodes().length);
        PruneBlockCacheRequest request = new PruneBlockCacheRequest("data-node-1");
 * The OpenSearch Contributors require contributions made to
            Set.of(DiscoveryNodeRole.WARM_ROLE),
                null
        threadPool = new TestThreadPool("test");
            "warm-node-2",
        action.resolveRequest(request, clusterService.state());
        List<NodePruneBlockCacheResponse> responses = Collections.singletonList(
        when(blockCache.clear()).thenReturn(true);
 *
    }
            clusterService.getSettings(),
            "data-node-1",
            new NodePruneBlockCacheResponse(clusterService.state().nodes().get("warm-node-1"), true),
        assertTrue(Arrays.stream(request.concreteNodes()).anyMatch(n -> "warm-node-1".equals(n.getId())));
import org.opensearch.action.support.ActionFilters;
            "warm-node-2",
        try {
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        PruneBlockCacheRequest request = new PruneBlockCacheRequest();
import org.junit.After;
        super.tearDown();
            Collections.emptyMap(),
import org.opensearch.test.OpenSearchTestCase;
    public void testNodeOperationPartialFailure() {
        }
        List<FailedNodeException> failures = Collections.singletonList(
        BlockCache failingCache = mock(BlockCache.class);
            Collections.emptyMap(),
            null,
import static org.mockito.Mockito.verify;
            Version.CURRENT
    public void testNodeOperation() {
        assertEquals(1, request.concreteNodes().length);
