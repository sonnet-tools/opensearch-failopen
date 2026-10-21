        transportService.start();
            }
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), attributes, DATA_ROLE, Version.CURRENT);
            }
import org.opensearch.cluster.node.DiscoveryNode;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
            Settings.EMPTY,
            decommissionAttribute,
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
import static org.hamcrest.Matchers.instanceOf;
import org.junit.Before;
        final CoordinationMetadata.VotingConfiguration votingConfiguration = CoordinationMetadata.VotingConfiguration.of(nodes);
        };
            DecommissionStatus.DRAINING,
        );
            clusterService,
import org.opensearch.common.settings.ClusterSettings;
            public void onResponse(DecommissionResponse decommissionResponse) {
                countDownLatch.countDown();
                countDownLatch.countDown();
            clusterService,
 * The OpenSearch Contributors require contributions made to
                assertThat(e.getMessage(), Matchers.endsWith("invalid awareness attribute requested for decommissioning"));
import static org.hamcrest.Matchers.containsString;
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
            Set.of(decommissionedNode1, decommissionedNode2),
    private TransportService transportService;
import org.opensearch.threadpool.TestThreadPool;
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone_1");
            @Override
            @Override
import org.opensearch.cluster.node.DiscoveryNodes;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import java.util.concurrent.TimeUnit;
            public void onResponse(DecommissionResponse decommissionResponse) {
        return clusterState;
            }
        this.decommissionService = new DecommissionService(
        ClusterState.Builder builder = ClusterState.builder(clusterState);
        DecommissionService decommissionService = new DecommissionService(
    private ClusterState addClusterManagerNodes(ClusterState clusterState, String zone, String... nodeIds) {
    }
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
            decommissionAttribute,
        DecommissionStatus oldStatus = DecommissionStatus.INIT;
import org.opensearch.test.OpenSearchTestCase;
        this.decommissionService.startRecommissionAction(listener);
    public void testDecommissioningFailedWhenAnotherRequestForSameAttributeIsExecuted() throws InterruptedException {
                    Matchers.containsString("weight for decommissioned attribute is expected to be [0.0] but found [1.0]")
    private AllocationService allocationService;
        DecommissionAttributeMetadata oldMetadata = new DecommissionAttributeMetadata(
            randomAlphaOfLength(10)
            nodeSettingsBuilder.build(),
    public void testScheduleNodesDecommissionOnTimeout() {
    public void testRecommissionAction() throws InterruptedException {
            oldStatus,
            mockTransportService,
import static org.hamcrest.Matchers.notNullValue;
            threadPool,
            clusterState.nodes().get("node1"),
        AtomicReference<Exception> exceptionReference = new AtomicReference<>();
        );
            public void onResponse(DecommissionResponse decommissionResponse) {
        clusterState = setLocalNodeAsClusterManagerNode(clusterState, "node1");
import org.opensearch.cluster.ClusterState;
            clusterState.nodes().get("node11")
    }
            @Override
import static org.opensearch.cluster.OpenSearchAllocationTestCase.createAllocationService;
        setState(clusterService, state);
                assertTrue(e instanceof DecommissioningFailedException);
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    .build()
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        );
        nodeBuilder.clusterManagerNodeId(nodeId);
                assertTrue(e instanceof DecommissioningFailedException);
        decommissionService.drainNodesWithDecommissionedAttribute(request);
                            .addVotingConfigExclusion(
        );
            clusterSettings,
    public void setUpService() {
    @After
            threadPool,
            public void onResponse(DecommissionResponse decommissionResponse) {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            public void onFailure(Exception e) {
        request.setRequestID(requestID);
            builder.metadata(
        DecommissionRequest request = new DecommissionRequest(new DecommissionAttribute("zone", "zone_1"));
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            @Override
        logger.info("--> adding four data nodes on zone_1");
        clusterService = createClusterService(threadPool);
import org.opensearch.threadpool.ThreadPool;
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
import static java.util.Collections.emptySet;
            oldStatus,
            builder.metadata(Metadata.builder(clusterService.state().metadata()).decommissionAttributeMetadata(oldMetadata).build())
import java.util.concurrent.CountDownLatch;
            randomAlphaOfLength(10)
    }
            .coordinationMetadata(
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("rack", "rack-a");
        request.setNoDelay(true);
                fail("on response shouldn't have been called");
        clusterState = addDataNodes(clusterState, "zone_2", "node7", "node8", "node9", "node10");
            randomAlphaOfLength(10)
                        Matchers.endsWith("already successfully decommissioned, recommission before triggering another decommission")
            DecommissionRequest.DEFAULT_NODE_DRAINING_TIMEOUT
 * compatible open source license.
                clusterStateAtomicReference.set(clusterService.state());
            }
        setState(
            clusterService,
        clusterState = addDataNodes(clusterState, "zone_1", "node2", "node3", "node4", "node5");
                fail("on response shouldn't have been called");
        return clusterState;
        };
import org.opensearch.test.ClusterServiceUtils;
        setWeightedRoutingWeights(weights);
        );
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {
        ActionListener<DeleteDecommissionStateResponse> listener = new ActionListener<>() {
        final ClusterState.Builder builder = builder(clusterService.state());
                fail("on response shouldn't have been called");
        Mockito.when(mockTransportService.getLocalNode()).thenReturn(Mockito.mock(DiscoveryNode.class));
            public void onResponse(DecommissionResponse decommissionResponse) {
            public void onFailure(Exception e) {
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
    }
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-2");
        Metadata.Builder builder = Metadata.builder()
            public void onFailure(Exception e) {
    }
    public void testDrainNodesWithDecommissionedAttributeWithNoDelay() {
    }
            allocationService
        };
        DiscoveryNode decommissionedNode2 = Mockito.mock(DiscoveryNode.class);
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
import org.hamcrest.Matchers;
                                new CoordinationMetadata.VotingConfigExclusion(clusterService.state().nodes().get("node6"))
    private ClusterState addDataNodes(ClusterState clusterState, String zone, String... nodeIds) {
package org.opensearch.cluster.decommission;
            public void onFailure(Exception e) {
                    .lastAcceptedConfiguration(votingConfiguration)
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-2");
    private ThreadPool threadPool;
import org.opensearch.cluster.metadata.Metadata;
                        CoordinationMetadata.builder()
        new HashSet<>(Collections.singletonList(DiscoveryNodeRole.DATA_ROLE))
    }
    public void shutdownThreadPoolAndClusterService() {
public class DecommissionServiceTests extends OpenSearchTestCase {
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {
                    .coordinationMetadata(
                    e.getMessage(),
                            .build()
import java.util.concurrent.atomic.AtomicReference;
            @Override
        decommissionService.startDecommissionAction(new DecommissionRequest(decommissionAttribute), listener);
                countDownLatch.countDown();
        };
    }
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();
import org.opensearch.cluster.coordination.CoordinationMetadata;
            new DecommissionAttribute("zone", "zone_1"),
import static org.opensearch.cluster.ClusterState.builder;
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;
    private ClusterSettings clusterSettings;
import org.opensearch.common.unit.TimeValue;
        );
            randomAlphaOfLength(10)
    @Before
                fail("on response shouldn't have been called");
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            clusterState.nodes().get("node6"),
            @Override
            }
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-2");
            builder.metadata(Metadata.builder(clusterService.state().metadata()).decommissionAttributeMetadata(oldMetadata).build())
        );
    private DecommissionService decommissionService;
            @Override
            clusterState,
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            DecommissionStatus.INIT,
        clusterState = addDataNodes(clusterState, "zone_3", "node12", "node13", "node14", "node15");
                assertThat(
    final private static Set<DiscoveryNodeRole> CLUSTER_MANAGER_ROLE = Collections.unmodifiableSet(
                fail("on response shouldn't have been called");
        logger.info("--> adding four data nodes on zone_2");
                fail("on failure shouldn't have been called");
import java.util.List;
            oldStatus,
}
    @SuppressWarnings("unchecked")
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        logger.info("--> adding cluster manager node on zone_2");
    private ClusterService clusterService;
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone_1");
        clusterState = addClusterManagerNodes(clusterState, "zone_2", "node6");
                    .decommissionAttributeMetadata(decommissionAttributeMetadata)
            boundTransportAddress -> clusterService.state().nodes().get("node1"),
        transportService.acceptIncomingRequests();
            @Override
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
            randomAlphaOfLength(10)
        decommissionService.scheduleNodesDecommissionOnTimeout(
        threadPool = new TestThreadPool("test", Settings.EMPTY);
                    assertThat(
                if (oldStatus.equals(DecommissionStatus.SUCCESSFUL)) {
        logger.info("--> adding four data nodes on zone_3");
            @Override
    public void testDecommissionNotStartedWithoutWeighingAwayAttribute_1() throws InterruptedException {
        return clusterState;
                countDownLatch.countDown();
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.add(newDataNode(nodeId, singletonMap("zone", zone))));
import java.util.Collections;
        MatcherAssert.assertThat(exceptionReference.get().getMessage(), containsString("same request is already in status [INIT]"));
        decommissionService.startDecommissionAction(request, listener);
                }
    public void testDecommissionNotStartedWithoutWeighingAwayAttribute_2() throws InterruptedException {
            }
        final Settings.Builder nodeSettingsBuilder = Settings.builder()
            public void onFailure(Exception e) {
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.add(newClusterManagerNode(nodeId, singletonMap("zone", zone))));
        setState(
                );
        decommissionService.startDecommissionAction(request, listener);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        final ClusterState.Builder builder = builder(clusterService.state());
        assertThat(exceptionReference.get().getMessage(), Matchers.endsWith("same request is already in status [INIT]"));
            public void onFailure(Exception e) {
        AtomicReference<ClusterState> clusterStateAtomicReference = new AtomicReference<>();
        };
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {
            clusterService,
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> adding cluster manager node on zone_3");
        Mockito.when(mockTransportService.getThreadPool()).thenReturn(mockThreadPool);
                countDownLatch.countDown();
        );
        setState(clusterService, builder);
import org.junit.After;
                Metadata.builder(clusterService.state().metadata())
            Settings.EMPTY,
            @Override
                assertThat(
                    .build()
import org.hamcrest.MatcherAssert;
        AtomicReference<Exception> exceptionReference = new AtomicReference<>();
            @Override
/*
import org.opensearch.core.action.ActionListener;
            clusterService,
            builder.metadata(Metadata.builder(clusterService.state().metadata()).decommissionAttributeMetadata(oldMetadata).build())
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        e.getMessage(),
    );
        return clusterState;
    private static DiscoveryNode newDataNode(String nodeId, Map<String, String> attributes) {
        clusterState = addClusterManagerNodes(clusterState, "zone_3", "node11");
        setState(clusterService, state);
        assertNull(clusterStateAtomicReference.get().metadata().decommissionAttributeMetadata());
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
            NoopTracer.INSTANCE
        Mockito.verify(mockThreadPool).schedule(Mockito.any(Runnable.class), Mockito.any(TimeValue.class), Mockito.anyString());
import static java.util.Collections.singletonMap;
            .put("cluster.routing.allocation.awareness.force.zone.values", "zone_1,zone_2,zone_3");
        setState(
                    e.getMessage(),
            public void onResponse(DecommissionResponse decommissionResponse) {
            allocationService
        DiscoveryNode decommissionedNode1 = Mockito.mock(DiscoveryNode.class);
    }
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {
        clusterState = setNodesInVotingConfig(
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());
            );
        clusterService.stop();
            clusterService,
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        setState(
        Metadata metadata = Metadata.builder().putCustom(DecommissionAttributeMetadata.TYPE, decommissionAttributeMetadata).build();
        DecommissionAttributeMetadata oldMetadata = new DecommissionAttributeMetadata(
 *
                exceptionReference.set(e);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        clusterState = addClusterManagerNodes(clusterState, "zone_1", "node1");
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
import org.opensearch.common.settings.Settings;
                countDownLatch.countDown();
            emptySet(),
                assertTrue(e instanceof DecommissioningFailedException);
        decommissionService.startDecommissionAction(new DecommissionRequest(decommissionAttribute), listener);
    }
        clusterState = ClusterState.builder(clusterState).metadata(builder).build();
        );
    }
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            }
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
    @SuppressWarnings("unchecked")
        final ClusterState.Builder builder = builder(clusterService.state());
            public void onFailure(Exception e) {
        nodeBuilder.localNodeId(nodeId);
            @Override
import org.opensearch.cluster.ClusterName;
                exceptionReference.set(e);
            }
            threadPool,
        final MockTransport transport = new MockTransport();
        assertEquals(0, clusterStateAtomicReference.get().coordinationMetadata().getVotingConfigExclusions().size());
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
            @Override
        DecommissionAttributeMetadata oldMetadata = new DecommissionAttributeMetadata(
import org.opensearch.test.transport.MockTransport;
    public void testDecommissioningNotStartedForInvalidAttributeName() throws InterruptedException {
    private static DiscoveryNode newClusterManagerNode(String nodeId, Map<String, String> attributes) {
        decommissionService.startDecommissionAction(new DecommissionRequest(decommissionAttribute), listener);
            null,
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), attributes, CLUSTER_MANAGER_ROLE, Version.CURRENT);
import org.mockito.Mockito;
        allocationService = createAllocationService();
        };
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(DecommissioningFailedException.class));
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
            }
        );
        };
        );
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
            DecommissionStatus.SUCCESSFUL,
import org.opensearch.cluster.routing.allocation.AllocationService;
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
                assertTrue(e instanceof DecommissioningFailedException);
 * SPDX-License-Identifier: Apache-2.0
            )
                    Matchers.containsString(
            }
                assertTrue(e instanceof DecommissioningFailedException);
            clusterSettings,
                            )
        DecommissionRequest request = new DecommissionRequest(new DecommissionAttribute("zone", "zone_1"));
        transportService = transport.createTransportService(
        threadPool.shutdown();
                        "no weights are set to the attribute. Please set appropriate weights before triggering decommission action"
            decommissionAttribute,
    );
        final CountDownLatch countDownLatch = new CountDownLatch(1);
            }
                    );
        assertTrue(exceptionReference.get() instanceof DecommissioningFailedException);
        DecommissionRequest request = new DecommissionRequest(decommissionAttribute);
    }
        );
        ClusterServiceUtils.setState(clusterService, builder);
    private void setWeightedRoutingWeights(Map<String, Double> weights) {
                    )
                );
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        DecommissionStatus oldStatus = DecommissionStatus.INIT;
        logger.info("--> adding cluster manager node on zone_1");
                    )
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
            new DecommissionAttribute("zone", "zone_1"),
            @Override
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
        decommissionService.startDecommissionAction(request, listener);
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
            }
    private ClusterState setLocalNodeAsClusterManagerNode(ClusterState clusterState, String nodeId) {
            public void onResponse(DeleteDecommissionStateResponse decommissionResponse) {
import java.util.Map;
    }
 */
    }
import org.opensearch.cluster.service.ClusterService;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        );
                    .lastCommittedConfiguration(votingConfiguration)
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        final ClusterState.Builder builder = builder(clusterService.state());
    private ClusterState setNodesInVotingConfig(ClusterState clusterState, DiscoveryNode... nodes) {
        ActionListener<DecommissionResponse> listener = new ActionListener<DecommissionResponse>() {
                fail("on response shouldn't have been called");
    }
        clusterSettings = new ClusterSettings(nodeSettingsBuilder.build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
        Metadata metadata = Metadata.builder().putCustom(DecommissionAttributeMetadata.TYPE, decommissionAttributeMetadata).build();
    public void testDecommissioningFailedWhenAnotherAttributeDecommissioningSuccessful() throws InterruptedException {
                countDownLatch.countDown();
        TransportService mockTransportService = Mockito.mock(TransportService.class);
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
import static org.opensearch.test.ClusterServiceUtils.setState;
            requestID
            }
                countDownLatch.countDown();
import org.opensearch.Version;
import java.util.Set;
        DecommissionRequest request = new DecommissionRequest(new DecommissionAttribute("zone", "zone_2"));
            transportService,
import org.opensearch.transport.TransportService;
        );
        String requestID = randomAlphaOfLength(10);
    }
    }
        DecommissionStatus oldStatus = randomFrom(DecommissionStatus.SUCCESSFUL, DecommissionStatus.IN_PROGRESS, DecommissionStatus.INIT);
                    assertThat(e.getMessage(), Matchers.endsWith("is in progress, cannot process this request"));
import org.opensearch.cluster.routing.WeightedRouting;
        Map<String, Double> weights = Map.of("zone_1", 1.0, "zone_2", 1.0, "zone_3", 0.0);
        ClusterState clusterState = clusterService.state();
import java.util.HashSet;
                } else {
        // Decommission Attribute should be removed.
    final private static Set<DiscoveryNodeRole> DATA_ROLE = Collections.unmodifiableSet(
                CoordinationMetadata.builder()
    public void testExternalDecommissionRetryNotAllowed() throws InterruptedException {
                countDownLatch.countDown();
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        final ClusterState.Builder builder = builder(clusterState);
        );
            new DecommissionAttribute("zone", "zone_1"),
            }
