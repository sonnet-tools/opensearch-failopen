    public void testGetWeightedRouting_WeightsSetInMetadata() {
        ClusterGetWeightedRoutingResponse response = ActionTestUtils.executeBlocking(transportGetWeightedRoutingAction, request.request());
            boundTransportAddress -> clusterService.state().nodes().get("nodes1"),
            clusterService,
/*
            client,
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingAction;
        nodeBuilder.clusterManagerNodeId(nodeId);
package org.opensearch.cluster.action.shard.routing.weighted.get;
import static java.util.Collections.emptySet;
        assertEquals(response.weights(), null);
    }
    public void setUpService() {
public class TransportGetWeightedRoutingActionTests extends OpenSearchTestCase {
import java.util.HashSet;
            NoopTracer.INSTANCE
        return clusterState;
            ClusterGetWeightedRoutingAction.INSTANCE
    }
        clusterService.stop();
        state = setLocalNode(state, "nodeB1");
        assertEquals(true, response.getDiscoveredClusterManager());
            threadPool,
            ClusterGetWeightedRoutingAction.INSTANCE
        );
    public void testGetWeightedRoutingLocalWeight_WeightsNotSetInMetadata() {
        List.of(nodeIds)
import org.opensearch.cluster.routing.WeightedRouting;
        clusterState = addDataNodeForAZone(clusterState, "zone_C", "nodeC1", "nodeC2", "nodeC3");
import org.opensearch.common.settings.Settings;
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_C", "nodeMC");
            Collections.emptySet(),
    @Before
        state = setLocalNode(state, "nodeB1");
    }
            .forEach(
            ClusterGetWeightedRoutingAction.INSTANCE
        ClusterGetWeightedRoutingRequestBuilder request = new ClusterGetWeightedRoutingRequestBuilder(
import org.junit.After;
        transportService.acceptIncomingRequests();
 * The OpenSearch Contributors require contributions made to
        state = setLocalNode(state, "nodeB1");
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingResponse;
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        final ClusterGetWeightedRoutingRequestBuilder request = new ClusterGetWeightedRoutingRequestBuilder(
        request.setRequestLocal(true);
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
import org.opensearch.test.OpenSearchTestCase;
        ClusterState state = clusterService.state();
        return clusterState;
import java.util.Collections;
        );
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
import org.opensearch.cluster.ClusterState;
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
        assertEquals(null, response.getWeightedRouting());
    private ClusterState addDataNodeForAZone(ClusterState clusterState, String zone, String... nodeIds) {
    private TransportService transportService;
        ClusterState.Builder builder = ClusterState.builder(state);
    private WeightedRoutingService weightedRoutingService;
import org.opensearch.test.transport.MockTransport;
        ClusterState state = clusterService.state();
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequestBuilder;
import org.opensearch.Version;
import java.util.List;
    }
        clusterSettings = new ClusterSettings(settingsBuilder.build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * SPDX-License-Identifier: Apache-2.0
    public void testGetWeightedRoutingLocalWeight_WeightsSetInMetadata() {
        ClusterState state = clusterService.state();
        Settings.Builder settingsBuilder = Settings.builder()
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.DATA_ROLE))
        threadPool.shutdown();
    }
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
}
        ClusterGetWeightedRoutingRequestBuilder request = new ClusterGetWeightedRoutingRequestBuilder(
            );
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
    private ThreadPool threadPool;
import static org.mockito.Mockito.mock;
        transportService = transport.createTransportService(
                        Collections.singletonMap("zone", zone),
        return clusterState;
    }
        ClusterState.Builder builder = ClusterState.builder(state);
    );
    }
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.node.DiscoveryNode;
        clusterState = addClusterManagerNodes(clusterState);
                    new DiscoveryNode(
    public void testGetWeightedRouting_WeightsNotSetInMetadata() {
    private TransportGetWeightedRoutingAction transportGetWeightedRoutingAction;
                        DATA_ROLE,
                )
                    )
                        buildNewFakeTransportAddress(),
    }
        ClusterServiceUtils.setState(clusterService, builder);
import org.junit.Before;
    }
                nodeId -> nodeBuilder.add(
        return clusterState;
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.TransportGetWeightedRoutingAction;
 */
        request.setAwarenessAttribute("zone");
    }
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_B", "nodeMB");
            new ActionFilters(emptySet()),
 *
import org.opensearch.transport.client.node.NodeClient;
        assertEquals(weights, response.weights().weights());
        clusterState = addDataNodes(clusterState);
        state = setWeightedRoutingWeights(state, weights);
        ClusterState state = clusterService.state();
    private ClusterState addClusterManagerNodeForAZone(ClusterState clusterState, String zone, String... nodeIds) {
    }
    @Override
                    new DiscoveryNode(
                    )
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
    NodeClient client;
        ClusterGetWeightedRoutingRequestBuilder request = new ClusterGetWeightedRoutingRequestBuilder(
        return clusterState;
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 0.0, "zone_C", 1.0);
                        nodeId,
        final MockTransport transport = new MockTransport();
                        CLUSTER_MANAGER_ROLE,
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 0.0, "zone_C", 1.0);
            client,
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
        );
    );
    public void setUp() throws Exception {
        clusterState = setLocalNode(clusterState, "nodeA1");
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        request.setRequestLocal(true);
import java.util.Set;
            client,
            );
        assertEquals(weights, response.getWeightedRouting().weights());
    private ClusterSettings clusterSettings;
            null,
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
    }
 * this file be licensed under the Apache-2.0 license or a
        ClusterGetWeightedRoutingResponse response = ActionTestUtils.executeBlocking(transportGetWeightedRoutingAction, request.request());
    private ClusterState setLocalNode(ClusterState clusterState, String nodeId) {
        ClusterState.Builder builder = ClusterState.builder(clusterState);
 * compatible open source license.
            Settings.EMPTY,
    private ClusterState setWeightedRoutingWeights(ClusterState clusterState, Map<String, Double> weights) {
        return clusterState;
        request.setAwarenessAttribute("zone");
import org.opensearch.transport.TransportService;
            .forEach(
    private ClusterState addDataNodes(ClusterState clusterState) {
            mock(IndexNameExpressionResolver.class)
        request.setAwarenessAttribute("zone");
import org.opensearch.cluster.metadata.Metadata;
                        Version.CURRENT
            weightedRoutingService,
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
        this.transportGetWeightedRoutingAction = new TransportGetWeightedRoutingAction(
                        Collections.singletonMap("zone", zone),
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
    @After
            ClusterGetWeightedRoutingAction.INSTANCE
        state = setWeightedRoutingWeights(state, weights);
import org.opensearch.cluster.routing.WeightedRoutingService;
                nodeId -> nodeBuilder.add(
        ClusterGetWeightedRoutingResponse response = ActionTestUtils.executeBlocking(transportGetWeightedRoutingAction, request.request());
    private ClusterService clusterService;
                )
        );
        this.weightedRoutingService = new WeightedRoutingService(clusterService, threadPool, settingsBuilder.build(), clusterSettings);
        clusterState = addDataNodeForAZone(clusterState, "zone_A", "nodeA1", "nodeA2", "nodeA3");
                        Version.CURRENT
import org.opensearch.threadpool.TestThreadPool;
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        ClusterGetWeightedRoutingResponse response = ActionTestUtils.executeBlocking(transportGetWeightedRoutingAction, request.request());
import org.opensearch.cluster.node.DiscoveryNodeRole;
        super.setUp();
import org.opensearch.test.ClusterServiceUtils;
    final private static Set<DiscoveryNodeRole> CLUSTER_MANAGER_ROLE = Collections.unmodifiableSet(
    public void shutdown() {
import java.util.Map;
        transportService.start();
import org.opensearch.action.support.ActionTestUtils;
    private ClusterState addClusterManagerNodes(ClusterState clusterState) {
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        client = new NodeClient(Settings.EMPTY, threadPool);
        request.setAwarenessAttribute("zone");
import org.opensearch.cluster.ClusterName;
        threadPool = new TestThreadPool("test", Settings.EMPTY);
                        buildNewFakeTransportAddress(),
        ClusterServiceUtils.setState(clusterService, builder);
        clusterState = addDataNodeForAZone(clusterState, "zone_B", "nodeB1", "nodeB2", "nodeB3");
import org.opensearch.cluster.service.ClusterService;
        ClusterServiceUtils.setState(clusterService, builder);
        nodeBuilder.localNodeId(nodeId);
import org.opensearch.cluster.node.DiscoveryNodes;
                        nodeId,
    }
            client,
import org.opensearch.action.support.ActionFilters;
import org.opensearch.common.settings.ClusterSettings;
    final private static Set<DiscoveryNodeRole> DATA_ROLE = Collections.unmodifiableSet(
            transportService,
        );
        );
        List.of(nodeIds)
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_A", "nodeMA");
            threadPool,
        ClusterServiceUtils.setState(clusterService, builder);
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone");
        ClusterState.Builder builder = ClusterState.builder(state);
