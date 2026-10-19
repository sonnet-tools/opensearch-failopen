                        buildNewFakeTransportAddress(),
import java.util.concurrent.atomic.AtomicReference;  
            }
            @Override
                fail("on failure shouldn't have been called");
import org.junit.After;
import org.opensearch.cluster.node.DiscoveryNodeRole;
    private ClusterState setWeightedRoutingWeights(ClusterState clusterState, Map<String, Double> weights) {  
/*  
                        buildNewFakeTransportAddress(),
    private ClusterState addDataNodes(ClusterState clusterState) {
    }
            ClusterAddWeightedRoutingAction.INSTANCE
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());
            ClusterAddWeightedRoutingAction.INSTANCE
            @Override
    }  
        };
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);
                        CLUSTER_MANAGER_ROLE,
            );
        assertThrows(  
                countDownLatch.countDown();
    public void testAddWeightedRoutingFailsWhenDecommissionOngoing() throws InterruptedException {
        MatcherAssert.assertThat(
                assertTrue(clusterStateUpdateResponse.isAcknowledged());  
            ClusterAddWeightedRoutingAction.INSTANCE
    private ClusterState setDecommissionAttribute(ClusterState clusterState, DecommissionStatus status) {  
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
            ClusterAddWeightedRoutingAction.INSTANCE  
import org.opensearch.core.action.ActionListener;
        );
        );
    }  
            exceptionReference.get().getMessage(),  
                )
        );
    }  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
                    new DiscoveryNode(
    private ClusterState addClusterManagerNodeForAZone(ClusterState clusterState, String zone, String... nodeIds) {  
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", weights);
            null,  
            client,
                countDownLatch.countDown();
            public void onFailure(Exception e) {
        final MockTransport transport = new MockTransport();  
        transportService = transport.createTransportService(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        return clusterState;
import static org.hamcrest.Matchers.notNullValue;
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();  
                        DATA_ROLE,  
    }
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {  
        ClusterState.Builder builder = ClusterState.builder(clusterState);  
                countDownLatch.countDown();  
            Settings.EMPTY,
            @Override
    private ClusterSettings clusterSettings;
    private ClusterService clusterService;
        super.setUp();  
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
        clusterDeleteWeightedRoutingRequest.setVersion(0);
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);  
            .forEach(  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
    private TransportService transportService;  
    final private static Set<DiscoveryNodeRole> CLUSTER_MANAGER_ROLE = Collections.unmodifiableSet(
import org.opensearch.cluster.service.ClusterService;
            containsString("Maximum expected number of routing weights having zero weight is [1]")  
        state = setWeightedRoutingWeights(state, weights);
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();
        ClusterDeleteWeightedRoutingRequest clusterDeleteWeightedRoutingRequest = new ClusterDeleteWeightedRoutingRequest("zone");
                assertTrue(clusterStateUpdateResponse.isAcknowledged());
            }  
                        nodeId,
import org.opensearch.threadpool.TestThreadPool;  
            client,
    }
            public void onFailure(Exception e) {
        clusterState = addClusterManagerNodes(clusterState);
                assertTrue(clusterDeleteWeightedRoutingResponse.isAcknowledged());
                    )
            }
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();  
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.weightedRoutingService = new WeightedRoutingService(clusterService, threadPool, settingsBuilder.build(), clusterSettings);  
        ClusterState state = clusterService.state();  
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
            status,
    public void testVerifyAwarenessAttribute_ValidAttributeName() {
            () -> weightedRoutingService.verifyAwarenessAttribute("zone2")  
    @Override
    NodeClient client;  
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);
                )  
    }
            @Override
            containsString("weight for [zone_B] is not set and it is part of forced awareness value or a routing node has this attribute.")
    public void testVerifyAwarenessAttribute_InvalidAttributeName() {
                exceptionReference.set(e);
        );  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.decommission.DecommissionAttribute;
        ClusterServiceUtils.setState(clusterService, builder);
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone_A");
        );
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            @Override
            ClusterAddWeightedRoutingAction.INSTANCE  
        };  
        DecommissionStatus status = DecommissionStatus.SUCCESSFUL;
            @Override
import org.opensearch.transport.TransportService;
            @Override  
                assertTrue(clusterStateUpdateResponse.isAcknowledged());  
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
    public void testAddWeightedRoutingPassesWhenDecommissionFailed() throws InterruptedException {
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());  
            @Override
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
public class WeightedRoutingServiceTests extends OpenSearchTestCase {  
            @Override
            }
            }
        ClusterServiceUtils.setState(clusterService, builder);
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
    public void testAddWeightedRoutingPassesWhenWeightOfDecommissionedAttributeStillZero() throws InterruptedException {  
        MatcherAssert.assertThat(
        );
                countDownLatch.countDown();  
        ClusterServiceUtils.setState(clusterService, builder);
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
        state = setDecommissionAttribute(state, status);  
    public void testRegisterWeightedRoutingMetadataWithSameWeights() throws InterruptedException {
        );
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {  
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
    }
        DecommissionStatus status = randomFrom(DecommissionStatus.INIT, DecommissionStatus.IN_PROGRESS, DecommissionStatus.SUCCESSFUL);  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
        );  
    private ClusterState addDataNodeForAZone(ClusterState clusterState, String zone, String... nodeIds) {  
        };
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
    @After
        state = setWeightedRoutingWeights(state, weights);
 *
            }
 * compatible open source license.
        ClusterState state = clusterService.state();
            exceptionReference.get().getMessage(),
import static org.hamcrest.Matchers.instanceOf;  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
    }
        nodeBuilder.localNodeId(nodeId);  
            Collections.emptySet(),
import java.util.Collections;
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
import org.opensearch.Version;
        );  
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequestBuilder;  
            public void onFailure(Exception e) {
    }
                nodeId -> nodeBuilder.add(
    public void testAddWeightedRoutingFailsWhenWeightsForMoreThanHalfIsZero() throws InterruptedException {
                        Version.CURRENT
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());
        request.setWeightedRouting(updatedWeightedRouting);  
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();  
        client = new NodeClient(Settings.EMPTY, threadPool);
        Settings.Builder settingsBuilder = Settings.builder()
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();
            client,  
            client,
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
        ClusterServiceUtils.setState(clusterService, builder);  
        Map<String, Double> updatedWeights = Map.of("zone_A", 0.0, "zone_B", 2.0, "zone_C", 1.0);
                    new DiscoveryNode(  
        weightedRoutingService.deleteWeightedRoutingMetadata(clusterDeleteWeightedRoutingRequest, listener);
    public void setUpService() {  
    }  
import java.util.Map;
import org.hamcrest.MatcherAssert;
            ClusterAddWeightedRoutingAction.INSTANCE
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(  
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_A", "nodeMA");  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone");  
        try {
                        nodeId,  
            fail("verify awareness attribute should not fail");
        request.setWeightedRouting(updatedWeightedRouting);  
    @Before
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);  
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
        };  
        request.setWeightedRouting(updatedWeightedRouting);
            @Override  
    }
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        ClusterState.Builder builder = ClusterState.builder(state);
        ClusterState state = clusterService.state();
        state = setDecommissionAttribute(state, status);  
                assertEquals(updatedWeightedRouting, clusterService.state().metadata().weightedRoutingMetadata().getWeightedRouting());
import org.opensearch.cluster.metadata.Metadata;
        threadPool.shutdown();
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {  
        };
        request.setWeightedRouting(updatedWeightedRouting);  
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);  
            public void onResponse(ClusterDeleteWeightedRoutingResponse clusterDeleteWeightedRoutingResponse) {  
            @Override
        ClusterState.Builder builder = ClusterState.builder(state);  
        Map<String, Double> weights = Map.of("zone_A", 0.0, "zone_B", 1.0, "zone_C", 1.0);
            .forEach(
            public void onFailure(Exception e) {}
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", weights);
        state = setWeightedRoutingWeights(state, weights);  
            }
import static org.hamcrest.Matchers.containsString;
        ClusterState.Builder builder = ClusterState.builder(state);
        List.of(nodeIds)  
            "invalid awareness attribute %s requested for updating weighted routing",
            @Override
    }
        return clusterState;  
import java.util.HashSet;  
import org.opensearch.cluster.node.DiscoveryNode;  
        ClusterState.Builder builder = ClusterState.builder(state);
    }
            weightedRoutingService.verifyAwarenessAttribute("zone");  
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.DATA_ROLE))
        );
import org.opensearch.cluster.ClusterName;
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
        clusterState = addDataNodeForAZone(clusterState, "zone_B", "nodeB1", "nodeB2", "nodeB3");  
            threadPool,  
        ClusterState state = clusterService.state();
            @Override  
                fail("request should not fail");
        return clusterState;  
            ActionRequestValidationException.class,
import org.opensearch.cluster.node.DiscoveryNodes;
        );  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
import org.opensearch.test.ClusterServiceUtils;  
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(ActionRequestValidationException.class));  
        ClusterServiceUtils.setState(clusterService, builder);
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterAddWeightedRoutingAction;
        };
                fail("request should not fail");
    final private static Set<DiscoveryNodeRole> DATA_ROLE = Collections.unmodifiableSet(  
        clusterState = addDataNodeForAZone(clusterState, "zone_C", "nodeC1", "nodeC2", "nodeC3");
        request.setWeightedRouting(weightedRouting);
        MatcherAssert.assertThat(
                        Collections.singletonMap("zone", zone),  
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;  
        ClusterState state = clusterService.state();
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {  
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
    public void testDeleteWeightedRoutingMetadata() throws InterruptedException {  
import org.opensearch.cluster.ClusterState;
        return clusterState;
        request.setWeightedRouting(weightedRouting);  
            exceptionReference.get().getMessage(),
    public void shutdown() {
import org.opensearch.action.ActionRequestValidationException;
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);
    }  
package org.opensearch.cluster.routing;
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();
                nodeId -> nodeBuilder.add(
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 0.0));  
import org.opensearch.common.settings.Settings;  
        List.of(nodeIds)
            client,
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {  
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(UnsupportedWeightedRoutingStateException.class));  
 */  
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);  
    private WeightedRoutingService weightedRoutingService;
            decommissionAttribute,  
                countDownLatch.countDown();
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(  
            );
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;  
    private ThreadPool threadPool;
            }  
 * SPDX-License-Identifier: Apache-2.0
            client,
        weightedRoutingService.registerWeightedRoutingMetadata(request.request(), listener);
            }
            @Override  
        return clusterState;
        );
        ActionListener<ClusterDeleteWeightedRoutingResponse> listener = new ActionListener<ClusterDeleteWeightedRoutingResponse>() {
            public void onFailure(Exception e) {  
    public void testAddWeightedRoutingFailsWhenWeightsNotSetForAllDiscoveredZones() throws InterruptedException {  
    public void setUp() throws Exception {
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
        DecommissionStatus status = DecommissionStatus.FAILED;  
    }
                assertEquals(updatedWeightedRouting, clusterService.state().metadata().weightedRoutingMetadata().getWeightedRouting());
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
 * The OpenSearch Contributors require contributions made to  
                        Version.CURRENT
        } catch (Exception e) {
            public void onFailure(Exception e) {}  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_B", "nodeMB");
    private ClusterState addClusterManagerNodes(ClusterState clusterState) {
        };
import java.util.List;
            }
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
        state = setWeightedRoutingWeights(state, weights);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
import org.opensearch.transport.client.node.NodeClient;  
            }  
                countDownLatch.countDown();  
                countDownLatch.countDown();  
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(UnsupportedWeightedRoutingStateException.class));
                exceptionReference.set(e);
        request.setWeightedRouting(updatedWeightedRouting);
                countDownLatch.countDown();  
            containsString("weight for [zone_A] must be set to [0.0] as it is under decommission action")  
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_C", 1.0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
}
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
    }
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(updatedWeightedRouting, clusterService.state().metadata().weightedRoutingMetadata().getWeightedRouting());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import org.junit.Before;  
        );  
            randomAlphaOfLength(10)
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 1.0, "zone_C", 1.0);
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
        transportService.start();  
        Map<String, Double> weights = Map.of("zone_A", 0.0, "zone_B", 0.0, "zone_C", 1.0, "zone_D", 1.0, "zone_E", 1.0, "zone_F", 1.0);
import org.opensearch.common.settings.ClusterSettings;
            public void onFailure(Exception e) {  
        clusterState = addDataNodeForAZone(clusterState, "zone_A", "nodeA1", "nodeA2", "nodeA3");
    }  
        ClusterState state = clusterService.state();  
import java.util.concurrent.CountDownLatch;
            public void onFailure(Exception e) {
    }
    );
        ClusterState.Builder builder = ClusterState.builder(state);
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", updatedWeights);
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;
import org.opensearch.test.transport.MockTransport;
            ClusterAddWeightedRoutingAction.INSTANCE  
        ClusterState.Builder builder = ClusterState.builder(state);  
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());  
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(  
            }
    private ClusterState setLocalNode(ClusterState clusterState, String nodeId) {
        metadataBuilder.decommissionAttributeMetadata(decommissionAttributeMetadata);
            @Override  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        WeightedRouting updatedWeightedRouting = new WeightedRouting("zone", weights);
                exceptionReference.set(e);  
import java.util.concurrent.TimeUnit;
            }
        };  
            }  
        state = setWeightedRoutingWeights(state, weights);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                assertEquals(updatedWeightedRouting, clusterService.state().metadata().weightedRoutingMetadata().getWeightedRouting());
        state = setDecommissionAttribute(state, status);
    }
                        Collections.singletonMap("zone", zone),
                assertTrue(clusterStateUpdateResponse.isAcknowledged());
        ClusterServiceUtils.setState(clusterService, builder);
        state = setWeightedRoutingWeights(state, weights);
    );
        clusterSettings = new ClusterSettings(settingsBuilder.build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                countDownLatch.countDown();
                    )  
import java.util.Set;  
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
        threadPool = new TestThreadPool("test", Settings.EMPTY);
                countDownLatch.countDown();
        ClusterServiceUtils.setState(clusterService, builder);
            NoopTracer.INSTANCE
        nodeBuilder.clusterManagerNodeId(nodeId);
            client,
import org.opensearch.cluster.decommission.DecommissionStatus;  
        ClusterPutWeightedRoutingRequestBuilder request = new ClusterPutWeightedRoutingRequestBuilder(
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        clusterState = addClusterManagerNodeForAZone(clusterState, "zone_C", "nodeMC");
            boundTransportAddress -> clusterService.state().nodes().get("nodes1"),
        clusterState = addDataNodes(clusterState);  
        ActionListener<ClusterStateUpdateResponse> listener = new ActionListener<ClusterStateUpdateResponse>() {
        transportService.acceptIncomingRequests();
        clusterState = setLocalNode(clusterState, "nodeA1");
        return clusterState;  
        clusterService.stop();  
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {  
            @Override
    public void testRegisterWeightedRoutingMetadataWithChangedWeights() throws InterruptedException {
        }  
        return clusterState;  
                countDownLatch.countDown();  
