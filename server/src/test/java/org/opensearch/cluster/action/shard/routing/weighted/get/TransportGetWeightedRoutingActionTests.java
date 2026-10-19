        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_C", "nodeMC");
        transportService.acceptIncomingRequests();  
import org.opensearch.common.settings.Settings;  
            ClusterGetWeightedRoutingAction.INSTANCE
        assertEquals(weights, response.weights().weights());  
import java.util.List;
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingAction;
            new ActionFilters(emptySet()),  
                )
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        state = setLocalNode(state, "nodeB1");
        ClusterState.Builder builder = ClusterState.builder(state);
        client = new NodeClient(Settings.EMPTY, threadPool);  
import org.opensearch.action.support.ActionTestUtils;
            Settings.EMPTY,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
 * The OpenSearch Contributors require contributions made to  
            client,
        state = setLocalNode(state, "nodeB1");
            transportService,
import org.opensearch.cluster.ClusterName;
    private ThreadPool threadPool;
        request.setAwarenessAttribute("zone");
        ClusterGetWeightedRoutingResponse response = ActionTestUtils.executeBlocking(transportGetWeightedRoutingAction, request.request());
    private ClusterState setLocalNode(ClusterState clusterState, String nodeId) {  
        List.of(nodeIds)
import org.opensearch.test.ClusterServiceUtils;
        super.setUp();
        request.setRequestLocal(true);
            ClusterGetWeightedRoutingAction.INSTANCE
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        );
    }
                        nodeId,
        return clusterState;
    }  
import org.opensearch.cluster.node.DiscoveryNodes;  
import org.opensearch.threadpool.TestThreadPool;
    }
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        clusterService.stop();
        transportService = transport.createTransportService(  
            client,
            Collections.emptySet(),  
import java.util.Collections;  
    }  
 */  
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 0.0, "zone_C", 1.0);  
                        buildNewFakeTransportAddress(),  
    }  
                        Version.CURRENT  
import org.junit.After;  
    }
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;  
            client,
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
    private ClusterService clusterService;  
            mock(IndexNameExpressionResolver.class)
        ClusterState.Builder builder = ClusterState.builder(clusterState);
import org.opensearch.cluster.ClusterState;  
        ClusterServiceUtils.setState(clusterService, builder);  
            );
        ClusterState.Builder builder = ClusterState.builder(state);
        transportService.start();
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
 *
    }
package org.opensearch.cluster.action.shard.routing.weighted.get;
        List.of(nodeIds)
import org.opensearch.Version;
                nodeId -> nodeBuilder.add(  
        return clusterState;
 * this file be licensed under the Apache-2.0 license or a
        ClusterState state = clusterService.state();
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        ClusterServiceUtils.setState(clusterService, builder);  
import org.opensearch.transport.client.node.NodeClient;
import org.junit.Before;
import static org.mockito.Mockito.mock;
            threadPool,
            ClusterGetWeightedRoutingAction.INSTANCE  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone");
        state = setWeightedRoutingWeights(state, weights);
    private ClusterState addDataNodes(ClusterState clusterState) {  
    }
import org.opensearch.cluster.routing.WeightedRouting;
        );
import org.opensearch.threadpool.ThreadPool;  
        request.setAwarenessAttribute("zone");
    public void setUp() throws Exception {
    private ClusterState addDataNodeForAZone(ClusterState clusterState, String zone, String... nodeIds) {
        return clusterState;
                        Version.CURRENT
        Settings.Builder settingsBuilder = Settings.builder()
 * compatible open source license.
        ClusterState.Builder builder = ClusterState.builder(state);
        ClusterGetWeightedRoutingRequestBuilder request = new ClusterGetWeightedRoutingRequestBuilder(  
                    new DiscoveryNode(
        clusterState = setLocalNode(clusterState, "nodeA1");  
            null,
                    new DiscoveryNode(
        assertEquals(null, response.getWeightedRouting());
    @After
                        CLUSTER_MANAGER_ROLE,  
import static java.util.Collections.emptySet;  
                nodeId -> nodeBuilder.add(
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());  
    );  
    }
                        nodeId,  
    public void testGetWeightedRoutingLocalWeight_WeightsSetInMetadata() {  
        return clusterState;
        nodeBuilder.clusterManagerNodeId(nodeId);  
        ClusterState state = clusterService.state();
                    )
        threadPool.shutdown();
    public void setUpService() {
    }
        assertEquals(weights, response.getWeightedRouting().weights());
        ClusterServiceUtils.setState(clusterService, builder);
    private TransportService transportService;
                    )
        );
    }  
    private WeightedRoutingService weightedRoutingService;
import java.util.Set;
    private ClusterState setWeightedRoutingWeights(ClusterState clusterState, Map<String, Double> weights) {
            ClusterGetWeightedRoutingAction.INSTANCE  
}
        clusterState = addDataNodes(clusterState);
                        Collections.singletonMap("zone", zone),
        ClusterGetWeightedRoutingResponse response = ActionTestUtils.executeBlocking(transportGetWeightedRoutingAction, request.request());
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
    private ClusterState addClusterManagerNodeForAZone(ClusterState clusterState, String zone, String... nodeIds) {
import org.opensearch.common.settings.ClusterSettings;
            .forEach(  
    final private static Set<DiscoveryNodeRole> DATA_ROLE = Collections.unmodifiableSet(
    }  
            threadPool,
        clusterState = addDataNodeForAZone(clusterState, "zone_A", "nodeA1", "nodeA2", "nodeA3");
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
    @Override  
        state = setWeightedRoutingWeights(state, weights);
public class TransportGetWeightedRoutingActionTests extends OpenSearchTestCase {  
        clusterState = addClusterManagerNodes(clusterState);
    public void testGetWeightedRouting_WeightsNotSetInMetadata() {
/*  
        this.weightedRoutingService = new WeightedRoutingService(clusterService, threadPool, settingsBuilder.build(), clusterSettings);
                )  
        ClusterGetWeightedRoutingRequestBuilder request = new ClusterGetWeightedRoutingRequestBuilder(
        final ClusterGetWeightedRoutingRequestBuilder request = new ClusterGetWeightedRoutingRequestBuilder(
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.test.transport.MockTransport;
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        return clusterState;
import java.util.Map;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.TransportService;
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
        state = setLocalNode(state, "nodeB1");  
        clusterState = addDataNodeForAZone(clusterState, "zone_B", "nodeB1", "nodeB2", "nodeB3");
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
        ClusterState state = clusterService.state();
    );
        final MockTransport transport = new MockTransport();
        request.setAwarenessAttribute("zone");
    NodeClient client;
            weightedRoutingService,
                        DATA_ROLE,
    @Before
        this.transportGetWeightedRoutingAction = new TransportGetWeightedRoutingAction(
        ClusterGetWeightedRoutingResponse response = ActionTestUtils.executeBlocking(transportGetWeightedRoutingAction, request.request());
    private ClusterState addClusterManagerNodes(ClusterState clusterState) {
        ClusterServiceUtils.setState(clusterService, builder);  
        clusterSettings = new ClusterSettings(settingsBuilder.build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            boundTransportAddress -> clusterService.state().nodes().get("nodes1"),
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.DATA_ROLE))  
    public void shutdown() {  
    }  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.TransportGetWeightedRoutingAction;
import org.opensearch.action.support.ActionFilters;  
            clusterService,  
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequestBuilder;  
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_B", "nodeMB");  
    public void testGetWeightedRoutingLocalWeight_WeightsNotSetInMetadata() {
import org.opensearch.cluster.routing.WeightedRoutingService;
        );  
    private TransportGetWeightedRoutingAction transportGetWeightedRoutingAction;  
            client,  
        );
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingResponse;
    final private static Set<DiscoveryNodeRole> CLUSTER_MANAGER_ROLE = Collections.unmodifiableSet(
        );
            NoopTracer.INSTANCE
        clusterState = addDataNodeForAZone(clusterState, "zone_C", "nodeC1", "nodeC2", "nodeC3");  
        ClusterState state = clusterService.state();  
            .forEach(
                        Collections.singletonMap("zone", zone),
        nodeBuilder.localNodeId(nodeId);
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
    private ClusterSettings clusterSettings;
        request.setAwarenessAttribute("zone");  
        return clusterState;  
import org.opensearch.cluster.node.DiscoveryNode;
        ClusterGetWeightedRoutingRequestBuilder request = new ClusterGetWeightedRoutingRequestBuilder(
        threadPool = new TestThreadPool("test", Settings.EMPTY);  
        request.setRequestLocal(true);
        assertEquals(response.weights(), null);  
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_A", "nodeMA");
        assertEquals(true, response.getDiscoveredClusterManager());  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import java.util.HashSet;
import org.opensearch.test.OpenSearchTestCase;  
        ClusterGetWeightedRoutingResponse response = ActionTestUtils.executeBlocking(transportGetWeightedRoutingAction, request.request());
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);  
    public void testGetWeightedRouting_WeightsSetInMetadata() {  
            );  
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 0.0, "zone_C", 1.0);  
                        buildNewFakeTransportAddress(),
