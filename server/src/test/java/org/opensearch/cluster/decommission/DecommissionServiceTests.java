            DecommissionStatus.SUCCESSFUL,
    }
            }
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone_1");  
        };
import org.opensearch.cluster.ClusterState;  
    private ClusterState addDataNodes(ClusterState clusterState, String zone, String... nodeIds) {
package org.opensearch.cluster.decommission;
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.add(newDataNode(nodeId, singletonMap("zone", zone))));
            public void onResponse(DecommissionResponse decommissionResponse) {
            null,  
    final private static Set<DiscoveryNodeRole> CLUSTER_MANAGER_ROLE = Collections.unmodifiableSet(
                countDownLatch.countDown();
    public void testRecommissionAction() throws InterruptedException {
    public void testDrainNodesWithDecommissionedAttributeWithNoDelay() {
            emptySet(),
    }  
                    e.getMessage(),
        clusterState = addClusterManagerNodes(clusterState, "zone_1", "node1");
        );
import org.mockito.Mockito;  
            decommissionAttribute,  
import org.opensearch.cluster.node.DiscoveryNode;
            allocationService  
        clusterState = addClusterManagerNodes(clusterState, "zone_2", "node6");  
                assertTrue(e instanceof DecommissioningFailedException);  
        setState(clusterService, state);
                        e.getMessage(),
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.decommissionService = new DecommissionService(
        DecommissionRequest request = new DecommissionRequest(new DecommissionAttribute("zone", "zone_1"));
        clusterState = ClusterState.builder(clusterState).metadata(builder).build();
            clusterState.nodes().get("node1"),  
            @Override
        decommissionService.drainNodesWithDecommissionedAttribute(request);
        clusterState = setLocalNodeAsClusterManagerNode(clusterState, "node1");  
        decommissionService.startDecommissionAction(new DecommissionRequest(decommissionAttribute), listener);  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();
        logger.info("--> adding cluster manager node on zone_1");  
        transportService = transport.createTransportService(
import java.util.Map;  
                countDownLatch.countDown();
import org.opensearch.threadpool.ThreadPool;
    private ClusterService clusterService;  
        logger.info("--> adding four data nodes on zone_2");
import org.opensearch.test.ClusterServiceUtils;
        DiscoveryNode decommissionedNode2 = Mockito.mock(DiscoveryNode.class);  
            DecommissionRequest.DEFAULT_NODE_DRAINING_TIMEOUT
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
            NoopTracer.INSTANCE
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {
    public void testScheduleNodesDecommissionOnTimeout() {
        };
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
        nodeBuilder.clusterManagerNodeId(nodeId);
import java.util.concurrent.atomic.AtomicReference;
    }  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
    final private static Set<DiscoveryNodeRole> DATA_ROLE = Collections.unmodifiableSet(
                fail("on response shouldn't have been called");  
                        Matchers.endsWith("already successfully decommissioned, recommission before triggering another decommission")
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), attributes, CLUSTER_MANAGER_ROLE, Version.CURRENT);
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();  
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
            oldStatus,  
import java.util.List;
                countDownLatch.countDown();  
        // Decommission Attribute should be removed.  
                exceptionReference.set(e);  
import static java.util.Collections.singletonMap;  
        logger.info("--> adding cluster manager node on zone_2");
        DecommissionService decommissionService = new DecommissionService(  
        DecommissionRequest request = new DecommissionRequest(decommissionAttribute);
        nodeBuilder.localNodeId(nodeId);  
                countDownLatch.countDown();
import java.util.concurrent.TimeUnit;  
        Metadata metadata = Metadata.builder().putCustom(DecommissionAttributeMetadata.TYPE, decommissionAttributeMetadata).build();
    private AllocationService allocationService;
            @Override
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone_1");
import org.opensearch.cluster.ClusterName;
                exceptionReference.set(e);
        DecommissionAttributeMetadata oldMetadata = new DecommissionAttributeMetadata(
import static java.util.Collections.emptySet;
                            .addVotingConfigExclusion(  
            DecommissionStatus.DRAINING,
            }  
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();  
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        request.setRequestID(requestID);
        );
            public void onFailure(Exception e) {  
            clusterService,
        return clusterState;
                fail("on response shouldn't have been called");
        logger.info("--> adding four data nodes on zone_1");  
        DecommissionRequest request = new DecommissionRequest(new DecommissionAttribute("zone", "zone_1"));  
import org.hamcrest.Matchers;
    private void setWeightedRoutingWeights(Map<String, Double> weights) {  
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;  
    }
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;
        clusterState = addDataNodes(clusterState, "zone_1", "node2", "node3", "node4", "node5");
            public void onResponse(DecommissionResponse decommissionResponse) {  
            builder.metadata(
import org.opensearch.common.unit.TimeValue;
            }
        clusterState = addDataNodes(clusterState, "zone_3", "node12", "node13", "node14", "node15");
            clusterService,  
import org.hamcrest.MatcherAssert;
        allocationService = createAllocationService();
    private ThreadPool threadPool;
        clusterState = addDataNodes(clusterState, "zone_2", "node7", "node8", "node9", "node10");  
        final Settings.Builder nodeSettingsBuilder = Settings.builder()
import static org.hamcrest.Matchers.containsString;
    }
        DecommissionAttributeMetadata oldMetadata = new DecommissionAttributeMetadata(
    }  
    }
            public void onFailure(Exception e) {  
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                    .coordinationMetadata(
            clusterService,
            oldStatus,  
import org.opensearch.cluster.metadata.Metadata;
            @Override  
        ActionListener<DeleteDecommissionStateResponse> listener = new ActionListener<>() {
        DecommissionStatus oldStatus = DecommissionStatus.INIT;
            clusterState.nodes().get("node6"),
    private ClusterState setNodesInVotingConfig(ClusterState clusterState, DiscoveryNode... nodes) {  
        ClusterServiceUtils.setState(clusterService, builder);
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {
        decommissionService.startDecommissionAction(new DecommissionRequest(decommissionAttribute), listener);
            clusterState.nodes().get("node11")
    );  
                assertTrue(e instanceof DecommissioningFailedException);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
    }
        );
    @SuppressWarnings("unchecked")  
        };  
                fail("on response shouldn't have been called");  
            randomAlphaOfLength(10)
            clusterService,
        final ClusterState.Builder builder = builder(clusterService.state());
        logger.info("--> adding four data nodes on zone_3");
                countDownLatch.countDown();
    public void testDecommissionNotStartedWithoutWeighingAwayAttribute_1() throws InterruptedException {
            clusterState,
        ClusterState clusterState = clusterService.state();
            @Override  
    }
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.add(newClusterManagerNode(nodeId, singletonMap("zone", zone))));
            @Override  
        threadPool = new TestThreadPool("test", Settings.EMPTY);
    public void testDecommissioningFailedWhenAnotherAttributeDecommissioningSuccessful() throws InterruptedException {
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
        TransportService mockTransportService = Mockito.mock(TransportService.class);
            public void onFailure(Exception e) {
            }  
            decommissionAttribute,
            );  
import org.opensearch.cluster.service.ClusterService;
        logger.info("--> adding cluster manager node on zone_3");
        setState(  
        DiscoveryNode decommissionedNode1 = Mockito.mock(DiscoveryNode.class);
            clusterService,
        );
                countDownLatch.countDown();
        assertThat(exceptionReference.get().getMessage(), Matchers.endsWith("same request is already in status [INIT]"));
/*  
    public void testDecommissionNotStartedWithoutWeighingAwayAttribute_2() throws InterruptedException {  
        Mockito.when(mockTransportService.getLocalNode()).thenReturn(Mockito.mock(DiscoveryNode.class));
            randomAlphaOfLength(10)
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();  
            randomAlphaOfLength(10)
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-2");
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), attributes, DATA_ROLE, Version.CURRENT);  
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
    }
                    .lastAcceptedConfiguration(votingConfiguration)  
        AtomicReference<Exception> exceptionReference = new AtomicReference<>();
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {  
            }
        assertTrue(exceptionReference.get() instanceof DecommissioningFailedException);  
    );
            requestID
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {  
        Map<String, Double> weights = Map.of("zone_1", 1.0, "zone_2", 1.0, "zone_3", 0.0);  
                    assertThat(e.getMessage(), Matchers.endsWith("is in progress, cannot process this request"));
    public void testExternalDecommissionRetryNotAllowed() throws InterruptedException {
            @Override
        return clusterState;
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                    Matchers.containsString("weight for decommissioned attribute is expected to be [0.0] but found [1.0]")  
    }
                    .decommissionAttributeMetadata(decommissionAttributeMetadata)  
            @Override
        final ClusterState.Builder builder = builder(clusterState);
                countDownLatch.countDown();
            public void onFailure(Exception e) {  
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(DecommissioningFailedException.class));
    private TransportService transportService;
import org.junit.After;  
import static org.hamcrest.Matchers.instanceOf;  
        );
        decommissionService.startDecommissionAction(request, listener);
        final CoordinationMetadata.VotingConfiguration votingConfiguration = CoordinationMetadata.VotingConfiguration.of(nodes);
            clusterSettings,
import static org.opensearch.test.ClusterServiceUtils.setState;
        AtomicReference<ClusterState> clusterStateAtomicReference = new AtomicReference<>();
            clusterSettings,  
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import org.opensearch.threadpool.TestThreadPool;
        final ClusterState.Builder builder = builder(clusterService.state());  
            DecommissionStatus.INIT,
            }  
import java.util.HashSet;
            }
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {  
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
            public void onResponse(DecommissionResponse decommissionResponse) {
        DecommissionStatus oldStatus = randomFrom(DecommissionStatus.SUCCESSFUL, DecommissionStatus.IN_PROGRESS, DecommissionStatus.INIT);  
                assertTrue(e instanceof DecommissioningFailedException);
            threadPool,  
import org.opensearch.core.action.ActionListener;
                                new CoordinationMetadata.VotingConfigExclusion(clusterService.state().nodes().get("node6"))
            nodeSettingsBuilder.build(),
            public void onResponse(DeleteDecommissionStateResponse decommissionResponse) {  
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("rack", "rack-a");
 */  
import org.opensearch.test.transport.MockTransport;  
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        String requestID = randomAlphaOfLength(10);
                    )
            public void onResponse(DecommissionResponse decommissionResponse) {
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());
    public void testDecommissioningFailedWhenAnotherRequestForSameAttributeIsExecuted() throws InterruptedException {  
            public void onFailure(Exception e) {
                );
        };  
            @Override
        final MockTransport transport = new MockTransport();  
                    .build()
        request.setNoDelay(true);  
    }
                );
        this.decommissionService.startRecommissionAction(listener);
        clusterService = createClusterService(threadPool);  
    private DecommissionService decommissionService;  
import java.util.Set;
public class DecommissionServiceTests extends OpenSearchTestCase {  
}
import static org.opensearch.cluster.OpenSearchAllocationTestCase.createAllocationService;
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        );
            new DecommissionAttribute("zone", "zone_1"),
            }
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(  
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());  
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;
    }  
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.DATA_ROLE))  
                CoordinationMetadata.builder()
import org.opensearch.transport.TransportService;  
    @SuppressWarnings("unchecked")
        );  
                } else {
            oldStatus,
            @Override
    }  
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
            new DecommissionAttribute("zone", "zone_1"),
                assertThat(
        setState(
            threadPool,  
 * The OpenSearch Contributors require contributions made to  
            }
        setState(clusterService, builder);
            @Override
            Settings.EMPTY,
import org.opensearch.common.settings.Settings;  
                if (oldStatus.equals(DecommissionStatus.SUCCESSFUL)) {
    }  
                fail("on response shouldn't have been called");
            }  
            @Override
    public void testDecommissioningNotStartedForInvalidAttributeName() throws InterruptedException {  
            transportService,
    public void shutdownThreadPoolAndClusterService() {  
            }
        setState(clusterService, state);  
        transportService.acceptIncomingRequests();
            public void onResponse(DecommissionResponse decommissionResponse) {
        threadPool.shutdown();
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        Mockito.when(mockTransportService.getThreadPool()).thenReturn(mockThreadPool);
            }  
            }
import org.opensearch.cluster.routing.allocation.AllocationService;
import static org.hamcrest.Matchers.notNullValue;
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
    }  
            mockTransportService,
            Set.of(decommissionedNode1, decommissionedNode2),
        assertEquals(0, clusterStateAtomicReference.get().coordinationMetadata().getVotingConfigExclusions().size());  
        ClusterState.Builder builder = ClusterState.builder(clusterState);
    private ClusterState setLocalNodeAsClusterManagerNode(ClusterState clusterState, String nodeId) {
            allocationService
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
                    );  
                    e.getMessage(),
        );  
                clusterStateAtomicReference.set(clusterService.state());
    private static DiscoveryNode newDataNode(String nodeId, Map<String, String> attributes) {
                        CoordinationMetadata.builder()
        clusterState = addClusterManagerNodes(clusterState, "zone_3", "node11");
        );
        clusterState = setNodesInVotingConfig(
            threadPool,
        setWeightedRoutingWeights(weights);
        );
            decommissionAttribute,  
        transportService.start();
        );  
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
        clusterSettings = new ClusterSettings(nodeSettingsBuilder.build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        DecommissionStatus oldStatus = DecommissionStatus.INIT;  
                    .build()
import org.junit.Before;
            public void onFailure(Exception e) {
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-2");
                    )
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                assertThat(  
import org.opensearch.cluster.routing.WeightedRouting;
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);  
            .coordinationMetadata(
            public void onResponse(DecommissionResponse decommissionResponse) {
        clusterService.stop();
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    Matchers.containsString(
import static org.opensearch.cluster.ClusterState.builder;
            @Override  
                assertTrue(e instanceof DecommissioningFailedException);
        MatcherAssert.assertThat(exceptionReference.get().getMessage(), containsString("same request is already in status [INIT]"));  
        DecommissionRequest request = new DecommissionRequest(new DecommissionAttribute("zone", "zone_2"));
    private ClusterSettings clusterSettings;
        decommissionService.startDecommissionAction(request, listener);
        };  
        Metadata metadata = Metadata.builder().putCustom(DecommissionAttributeMetadata.TYPE, decommissionAttributeMetadata).build();
                countDownLatch.countDown();
        );  
import java.util.concurrent.CountDownLatch;
        final ClusterState.Builder builder = builder(clusterService.state());  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                assertThat(e.getMessage(), Matchers.endsWith("invalid awareness attribute requested for decommissioning"));  
        return clusterState;  
    }
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();  
            builder.metadata(Metadata.builder(clusterService.state().metadata()).decommissionAttributeMetadata(oldMetadata).build())
 * compatible open source license.
                        "no weights are set to the attribute. Please set appropriate weights before triggering decommission action"  
        );  
            randomAlphaOfLength(10)  
    public void setUpService() {
        assertNull(clusterStateAtomicReference.get().metadata().decommissionAttributeMetadata());
import org.opensearch.cluster.node.DiscoveryNodes;  
                            )
        };
        return clusterState;  
        );
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;  
 *
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
                Metadata.builder(clusterService.state().metadata())
                    assertThat(  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                fail("on response shouldn't have been called");
                fail("on response shouldn't have been called");  
            }
    @Before  
            Settings.EMPTY,
        decommissionService.startDecommissionAction(new DecommissionRequest(decommissionAttribute), listener);
        decommissionService.startDecommissionAction(request, listener);
        Mockito.verify(mockThreadPool).schedule(Mockito.any(Runnable.class), Mockito.any(TimeValue.class), Mockito.anyString());
        };
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);  
                            .build()  
import org.opensearch.Version;
            clusterService,  
        );  
            )  
            builder.metadata(Metadata.builder(clusterService.state().metadata()).decommissionAttributeMetadata(oldMetadata).build())  
 * SPDX-License-Identifier: Apache-2.0
            new DecommissionAttribute("zone", "zone_1"),
        final ClusterState.Builder builder = builder(clusterService.state());
import org.opensearch.cluster.coordination.CoordinationMetadata;
                    .lastCommittedConfiguration(votingConfiguration)
    }
            @Override
        decommissionService.scheduleNodesDecommissionOnTimeout(  
            builder.metadata(Metadata.builder(clusterService.state().metadata()).decommissionAttributeMetadata(oldMetadata).build())  
            .put("cluster.routing.allocation.awareness.force.zone.values", "zone_1,zone_2,zone_3");
                assertTrue(e instanceof DecommissioningFailedException);
            @Override
                }  
            boundTransportAddress -> clusterService.state().nodes().get("node1"),
import java.util.Collections;  
        Metadata.Builder builder = Metadata.builder()  
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-2");  
        AtomicReference<Exception> exceptionReference = new AtomicReference<>();
    private static DiscoveryNode newClusterManagerNode(String nodeId, Map<String, String> attributes) {  
        setState(
    @After
        DecommissionAttributeMetadata oldMetadata = new DecommissionAttributeMetadata(  
            public void onFailure(Exception e) {
                fail("on failure shouldn't have been called");
            randomAlphaOfLength(10)  
    private ClusterState addClusterManagerNodes(ClusterState clusterState, String zone, String... nodeIds) {  
                countDownLatch.countDown();  
        setState(
