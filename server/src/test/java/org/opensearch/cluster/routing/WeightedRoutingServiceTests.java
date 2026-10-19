        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
    @After
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
import org.opensearch.threadpool.TestThreadPool;
                assertTrue(clusterDeleteWeightedRoutingResponse.isAcknowledged());
    private TransportService transportService;
            ClusterAddWeightedRoutingAction.INSTANCE
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterAddWeightedRoutingAction;
        );
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.ClusterName;
        );
        );
        Map<String, Double> updatedWeights = Map.of("zone_A", 0.0, "zone_B", 2.0, "zone_C", 1.0);
        List.of(nodeIds)
        ClusterState state = clusterService.state();
        threadPool = new TestThreadPool("test", Settings.EMPTY);
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);
        ClusterServiceUtils.setState(clusterService, builder);
        state = setWeightedRoutingWeights(state, weights);
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
            @Override
    }
            public void onFailure(Exception e) {
package org.opensearch.cluster.routing;
    final private static Set<DiscoveryNodeRole> DATA_ROLE = Collections.unmodifiableSet(
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
import org.opensearch.action.ActionRequestValidationException;
/*
        clusterState = addDataNodeForAZone(clusterState, "zone_C", "nodeC1", "nodeC2", "nodeC3");
        };
        request.setWeightedRouting(updatedWeightedRouting);
                nodeId -> nodeBuilder.add(
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(UnsupportedWeightedRoutingStateException.class));
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();
        state = setWeightedRoutingWeights(state, weights);
    public void testDeleteWeightedRoutingMetadata() throws InterruptedException {
        return clusterState;
        ClusterState.Builder builder = ClusterState.builder(state);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
    public void testVerifyAwarenessAttribute_ValidAttributeName() {
        }
    }
        return clusterState;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
    public void testAddWeightedRoutingFailsWhenWeightsForMoreThanHalfIsZero() throws InterruptedException {
import java.util.List;
        );
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
import java.util.concurrent.atomic.AtomicReference;
    }
        );
    private ClusterSettings clusterSettings;
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
            decommissionAttribute,
                exceptionReference.set(e);
}
    public void testVerifyAwarenessAttribute_InvalidAttributeName() {
            ClusterAddWeightedRoutingAction.INSTANCE
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_B", "nodeMB");
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);
        MatcherAssert.assertThat(
        return clusterState;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.Version;
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        return clusterState;
import org.opensearch.cluster.service.ClusterService;
            public void onFailure(Exception e) {}
            @Override
        ClusterServiceUtils.setState(clusterService, builder);
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
        state = setWeightedRoutingWeights(state, weights);
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
        nodeBuilder.clusterManagerNodeId(nodeId);
    }
import org.opensearch.cluster.decommission.DecommissionStatus;
                nodeId -> nodeBuilder.add(
            @Override
            Settings.EMPTY,
            ClusterAddWeightedRoutingAction.INSTANCE
        nodeBuilder.localNodeId(nodeId);
            }
    }
                countDownLatch.countDown();
                        nodeId,
            }
        );
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());
import org.opensearch.cluster.decommission.DecommissionAttribute;
        transportService.acceptIncomingRequests();
            ClusterAddWeightedRoutingAction.INSTANCE
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.DATA_ROLE))
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
    public void testAddWeightedRoutingPassesWhenDecommissionFailed() throws InterruptedException {
        request.setWeightedRouting(updatedWeightedRouting);
import org.opensearch.transport.TransportService;
 *
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);
            @Override
        };
            public void onResponse(ClusterDeleteWeightedRoutingResponse clusterDeleteWeightedRoutingResponse) {
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
        try {
        return clusterState;
import org.opensearch.common.settings.Settings;
                )
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 0.0));
        ClusterState state = clusterService.state();
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", updatedWeights);
    );
import java.util.Set;
            ActionRequestValidationException.class,
            }
        request.setWeightedRouting(updatedWeightedRouting);
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_A", "nodeMA");
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            exceptionReference.get().getMessage(),
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
    public void testAddWeightedRoutingPassesWhenWeightOfDecommissionedAttributeStillZero() throws InterruptedException {
            @Override
                fail("request should not fail");
 * The OpenSearch Contributors require contributions made to
import org.opensearch.threadpool.ThreadPool;
        ClusterState.Builder builder = ClusterState.builder(state);
    final private static Set<DiscoveryNodeRole> CLUSTER_MANAGER_ROLE = Collections.unmodifiableSet(
            NoopTracer.INSTANCE
        return clusterState;
import static org.hamcrest.Matchers.notNullValue;
    public void setUp() throws Exception {
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(ActionRequestValidationException.class));
        ClusterServiceUtils.setState(clusterService, builder);
                assertTrue(clusterStateUpdateResponse.isAcknowledged());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();
        };
        );
        super.setUp();
                assertTrue(clusterStateUpdateResponse.isAcknowledged());
    private ClusterState setLocalNode(ClusterState clusterState, String nodeId) {
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
        );
                fail("on failure shouldn't have been called");
import org.opensearch.common.settings.ClusterSettings;
import java.util.concurrent.TimeUnit;
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_C", 1.0);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
    }
            ClusterAddWeightedRoutingAction.INSTANCE
        return clusterState;
    private ClusterService clusterService;
    private ThreadPool threadPool;
        );
            exceptionReference.get().getMessage(),
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", weights);
            @Override
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
        request.setWeightedRouting(updatedWeightedRouting);
        this.weightedRoutingService = new WeightedRoutingService(clusterService, threadPool, settingsBuilder.build(), clusterSettings);
        client = new NodeClient(Settings.EMPTY, threadPool);
            );
import java.util.concurrent.CountDownLatch;
        ClusterState.Builder builder = ClusterState.builder(state);
    private ClusterState addClusterManagerNodeForAZone(ClusterState clusterState, String zone, String... nodeIds) {
    public void testAddWeightedRoutingFailsWhenDecommissionOngoing() throws InterruptedException {
        request.setWeightedRouting(updatedWeightedRouting);
            client,
            @Override
import static org.hamcrest.Matchers.containsString;
    public void testRegisterWeightedRoutingMetadataWithSameWeights() throws InterruptedException {
            }
            }
            @Override
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", weights);
import org.hamcrest.MatcherAssert;
        state = setDecommissionAttribute(state, status);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                        CLUSTER_MANAGER_ROLE,
        assertEquals(updatedWeightedRouting, clusterService.state().metadata().weightedRoutingMetadata().getWeightedRouting());
    private WeightedRoutingService weightedRoutingService;
            .forEach(
                countDownLatch.countDown();
    }
        clusterState = setLocalNode(clusterState, "nodeA1");
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(UnsupportedWeightedRoutingStateException.class));
        metadataBuilder.decommissionAttributeMetadata(decommissionAttributeMetadata);
 * SPDX-License-Identifier: Apache-2.0
    }
                )
        };
    public void setUpService() {
            @Override
                countDownLatch.countDown();
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
    public void shutdown() {
            @Override
import org.opensearch.cluster.node.DiscoveryNodeRole;
            client,
                assertTrue(clusterStateUpdateResponse.isAcknowledged());
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();
            .forEach(
            boundTransportAddress -> clusterService.state().nodes().get("nodes1"),
                fail("request should not fail");
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
import java.util.HashSet;
                    )
            @Override
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
                        nodeId,
                        Collections.singletonMap("zone", zone),
                        buildNewFakeTransportAddress(),
        ClusterServiceUtils.setState(clusterService, builder);
            @Override
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
            containsString("weight for [zone_B] is not set and it is part of forced awareness value or a routing node has this attribute.")
import java.util.Map;
        state = setWeightedRoutingWeights(state, weights);
                exceptionReference.set(e);
    }
        ClusterState.Builder builder = ClusterState.builder(state);
            exceptionReference.get().getMessage(),
import org.opensearch.test.OpenSearchTestCase;
        request.setWeightedRouting(weightedRouting);
                assertTrue(clusterStateUpdateResponse.isAcknowledged());
import org.opensearch.cluster.node.DiscoveryNode;
            }
        request.setWeightedRouting(weightedRouting);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            @Override
            ClusterAddWeightedRoutingAction.INSTANCE
                countDownLatch.countDown();
        ClusterState state = clusterService.state();
            @Override
        state = setDecommissionAttribute(state, status);
            }
    private ClusterState setDecommissionAttribute(ClusterState clusterState, DecommissionStatus status) {
        };
        DecommissionStatus status = DecommissionStatus.SUCCESSFUL;
            threadPool,
import static org.hamcrest.Matchers.instanceOf;
    public void testAddWeightedRoutingFailsWhenWeightsNotSetForAllDiscoveredZones() throws InterruptedException {
                        Version.CURRENT
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
import org.opensearch.core.action.ActionListener;
        DecommissionStatus status = DecommissionStatus.FAILED;
            Collections.emptySet(),
        };
            fail("verify awareness attribute should not fail");
            null,
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
import org.opensearch.test.transport.MockTransport;
                countDownLatch.countDown();
                countDownLatch.countDown();
        MatcherAssert.assertThat(
        clusterState = addDataNodeForAZone(clusterState, "zone_A", "nodeA1", "nodeA2", "nodeA3");
                exceptionReference.set(e);
        ClusterState.Builder builder = ClusterState.builder(state);
        clusterState = addClusterManagerNodes(clusterState);
        state = setWeightedRoutingWeights(state, weights);
        ClusterState state = clusterService.state();
    }
        transportService = transport.createTransportService(
import org.opensearch.test.ClusterServiceUtils;
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);
            }
    private ClusterState setWeightedRoutingWeights(ClusterState clusterState, Map<String, Double> weights) {
                        Collections.singletonMap("zone", zone),
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
            client,
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            @Override
            public void onFailure(Exception e) {
import org.junit.After;
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;
        ClusterServiceUtils.setState(clusterService, builder);
            }
public class WeightedRoutingServiceTests extends OpenSearchTestCase {
                countDownLatch.countDown();
        DecommissionStatus status = randomFrom(DecommissionStatus.INIT, DecommissionStatus.IN_PROGRESS, DecommissionStatus.SUCCESSFUL);
        ClusterState.Builder builder = ClusterState.builder(clusterState);
        List.of(nodeIds)
                    new DiscoveryNode(
    );
        );
            client,
        final CountDownLatch countDownLatch = new CountDownLatch(1);
    }
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
                        buildNewFakeTransportAddress(),
        } catch (Exception e) {
    }
        ClusterServiceUtils.setState(clusterService, builder);
            public void onFailure(Exception e) {
    }
            public void onFailure(Exception e) {}
    }
            @Override
        state = setDecommissionAttribute(state, status);
    }
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
            public void onFailure(Exception e) {
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequestBuilder;
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        clusterDeleteWeightedRoutingRequest.setVersion(0);
import org.opensearch.cluster.metadata.Metadata;
    }
        ClusterDeleteWeightedRoutingRequest clusterDeleteWeightedRoutingRequest = new ClusterDeleteWeightedRoutingRequest("zone");
import java.util.Collections;
        ClusterState state = clusterService.state();
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        clusterSettings = new ClusterSettings(settingsBuilder.build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
        ClusterState state = clusterService.state();
    private ClusterState addDataNodes(ClusterState clusterState) {
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
            ClusterAddWeightedRoutingAction.INSTANCE
 */
        };
            containsString("Maximum expected number of routing weights having zero weight is [1]")
    public void testRegisterWeightedRoutingMetadataWithChangedWeights() throws InterruptedException {
        ActionListener<ClusterDeleteWeightedRoutingResponse> listener = new ActionListener<ClusterDeleteWeightedRoutingResponse>() {
            weightedRoutingService.verifyAwarenessAttribute("zone");
            client,
    }
            "invalid awareness attribute %s requested for updating weighted routing",
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_C", "nodeMC");
                countDownLatch.countDown();
        );
            public void onFailure(Exception e) {
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;
import org.opensearch.cluster.ClusterState;
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
            }
            public void onFailure(Exception e) {
        );
        transportService.start();
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
            containsString("weight for [zone_A] must be set to [0.0] as it is under decommission action")
    }
            client,
                countDownLatch.countDown();
        state = setWeightedRoutingWeights(state, weights);
                assertEquals(updatedWeightedRouting, clusterService.state().metadata().weightedRoutingMetadata().getWeightedRouting());
            client,
            }
        clusterService.stop();
            status,
                assertEquals(updatedWeightedRouting, clusterService.state().metadata().weightedRoutingMetadata().getWeightedRouting());
                assertEquals(updatedWeightedRouting, clusterService.state().metadata().weightedRoutingMetadata().getWeightedRouting());
            }
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone_A");
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
    }
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);
        ClusterState.Builder builder = ClusterState.builder(state);
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", weights);
        MatcherAssert.assertThat(
    }
                    new DiscoveryNode(
import org.opensearch.transport.client.node.NodeClient;
        Settings.Builder settingsBuilder = Settings.builder()
                        DATA_ROLE,
            randomAlphaOfLength(10)
    private ClusterState addDataNodeForAZone(ClusterState clusterState, String zone, String... nodeIds) {
                    )
        clusterState = addDataNodes(clusterState);
        weightedRoutingService.deleteWeightedRoutingMetadata(clusterDeleteWeightedRoutingRequest, listener);
        Map<String, Double> weights = Map.of("zone_A", 0.0, "zone_B", 0.0, "zone_C", 1.0, "zone_D", 1.0, "zone_E", 1.0, "zone_F", 1.0);
        ClusterServiceUtils.setState(clusterService, builder);
            );
        };
        Map<String, Double> weights = Map.of("zone_A", 0.0, "zone_B", 1.0, "zone_C", 1.0);
                countDownLatch.countDown();
import org.junit.Before;
            }
 * compatible open source license.
            () -> weightedRoutingService.verifyAwarenessAttribute("zone2")
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
        );
    @Override
        final MockTransport transport = new MockTransport();
            }
        assertThrows(
    NodeClient client;
        clusterState = addDataNodeForAZone(clusterState, "zone_B", "nodeB1", "nodeB2", "nodeB3");
                        Version.CURRENT
    private ClusterState addClusterManagerNodes(ClusterState clusterState) {
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
        threadPool.shutdown();
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
                countDownLatch.countDown();
    @Before
