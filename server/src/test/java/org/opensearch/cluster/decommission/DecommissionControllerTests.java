    }
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.node.DiscoveryNode;
                    countDownLatch.countDown();
        Metadata metadata = state.metadata();
    final private static Set<DiscoveryNodeRole> CLUSTER_MANAGER_DATA_ROLE = Collections.unmodifiableSet(
        nodesToBeRemoved.add(clusterService.state().nodes().get("node15"));
        );
import org.opensearch.cluster.coordination.CoordinationMetadata;
import org.junit.Before;
            nodesToBeRemoved,
            for (DecommissionStatus val : entry.getValue()) {
            clusterState.nodes().get("node6"),
import org.opensearch.common.settings.ClusterSettings;
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
            null,
        for (DiscoveryNode node : nodes) {
            transportService,
    }
    public void testSuccessfulDecommissionStatusMetadataUpdateForFailedState() throws InterruptedException {
import java.util.Arrays;
        decommissionController.removeDecommissionedNodes(
            clusterService,
            new ActionListener<>() {
    private static ClusterService clusterService;
/*
    private AllocationService allocationService;
            new ActionFilters(emptySet()),
    }
import static org.opensearch.cluster.ClusterState.builder;
                countDownLatch.countDown();
import org.opensearch.common.settings.Settings;
            clusterService,
        ClusterState state = clusterService.state();
        // test all 5 nodes removed and cluster has 10 nodes
                }
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.add(newNode(nodeId, singletonMap("zone", zone))));
        final CoordinationMetadata.VotingConfiguration votingConfiguration = CoordinationMetadata.VotingConfiguration.of(
            threadPool,
        clusterState = addNodes(clusterState, "zone_1", "node1", "node2", "node3", "node4", "node5");
            assertNotEquals(node.getAttributes().get("zone"), "zone-1");
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService.getClusterApplierService().state().nodes().spliterator(), false)
            DecommissionStatus.INIT,
        throws InterruptedException {
import static org.hamcrest.Matchers.notNullValue;
            new ActionFilters(emptySet()),
    }
            DecommissionStatus.IN_PROGRESS,
    private static ThreadPool threadPool;
    );
        final Settings.Builder nodeSettingsBuilder = Settings.builder();
        clusterState = addNodes(clusterState, "zone_2", "node6", "node7", "node8", "node9", "node10");
        Set<DiscoveryNode> nodesToBeRemoved = new HashSet<>();
        mdBuilder.decommissionAttributeMetadata(oldMetadata);
    }
        MatcherAssert.assertThat(exceptionReference.get().getMessage(), containsString("waiting for removal of decommissioned nodes"));
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
    private static DiscoveryNode newNode(String nodeId, Map<String, String> attributes) {
        transportService.acceptIncomingRequests();
        clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        transportService = transport.createTransportService(
            clusterState.nodes().get("node1"),
import java.util.Collections;
                    .lastAcceptedConfiguration(votingConfiguration)
        final ClusterState.Builder builder = builder(clusterState);
            Set.of(DecommissionStatus.IN_PROGRESS),
                @Override
                }
        clusterState = setThreeNodesInVotingConfig(clusterState);
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());
            emptySet(),
    }
        return new DiscoveryNode(nodeId, nodeId, buildNewFakeTransportAddress(), attributes, CLUSTER_MANAGER_DATA_ROLE, Version.CURRENT);
        nodesToBeRemoved.add(clusterService.state().nodes().get("node13"));
        ClusterState newState = clusterService.getClusterApplierService().state();
        Map<DecommissionStatus, Set<DecommissionStatus>> decommissionStateTransitionMap = Map.of(
        setState(clusterService, builder);
            "unit-test-timeout",
            Set.of(DecommissionStatus.FAILED),
        );
            transportService,
import org.opensearch.cluster.service.ClusterService;
        );
import org.junit.After;
        );
import java.util.stream.Collectors;
    private TransportService transportService;
    public void setTransportServiceAndDefaultClusterState() {
        nodesToBeRemoved.add(clusterService.state().nodes().get("node14"));
import org.hamcrest.MatcherAssert;
import org.opensearch.core.action.ActionListener;
                public void onFailure(Exception e) {
    private ClusterSettings clusterSettings;
import static org.hamcrest.Matchers.instanceOf;
        Set<DiscoveryNode> nodesToBeRemoved = new HashSet<>();
        state = ClusterState.builder(state).metadata(mdBuilder).build();
        nodesToBeRemoved.add(clusterService.state().nodes().get("node12"));
        threadPool = new TestThreadPool("test", Settings.EMPTY);
        // test no nodes part of zone-3
        return clusterState;
        Metadata.Builder builder = Metadata.builder()
    }
                CoordinationMetadata.builder()
        logger.info("--> adding five nodes on same zone_2");
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.threadpool.TestThreadPool;
    public void testSuccessfulDecommissionStatusMetadataUpdate() throws InterruptedException {
        );
    public void testTimesOut() throws InterruptedException {
        nodesToBeRemoved.add(clusterService.state().nodes().get("node11"));
            .coordinationMetadata(
        clusterService.stop();
                }
            boundTransportAddress -> clusterService.state().nodes().get("node1"),
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import java.util.concurrent.TimeUnit;
        allocationService = createAllocationService();
        clusterState = ClusterState.builder(clusterState).metadata(builder).build();
    }
        nodesToBeRemoved.add(clusterService.state().nodes().get("node15"));
        final Settings nodeSettings = nodeSettingsBuilder.build();
            clusterState.nodes().get("node11")
            @Override
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
import org.opensearch.OpenSearchTimeoutException;
            }
                    .lastCommittedConfiguration(votingConfiguration)
                verifyDecommissionStatusTransition(entry.getKey(), val);
        decommissionController.removeDecommissionedNodes(
        return clusterState;
            DecommissionStatus.DRAINING,
        Metadata.Builder mdBuilder = Metadata.builder(metadata);
        nodeBuilder.clusterManagerNodeId(nodeId);
            Set.of(DecommissionStatus.FAILED)
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        ); // registers action
import java.util.Set;
import org.opensearch.action.support.ActionFilters;
        DecommissionAttributeMetadata decommissionAttributeMetadata = newState.metadata().decommissionAttributeMetadata();
import java.util.stream.StreamSupport;
            TimeValue.timeValueMillis(0),
                fail("decommission status update failed");
        DecommissionAttributeMetadata oldMetadata = new DecommissionAttributeMetadata(
        new TransportClearVotingConfigExclusionsAction(
import org.opensearch.cluster.metadata.Metadata;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            }
                    countDownLatch.countDown();
            TimeValue.timeValueSeconds(30L),
 * SPDX-License-Identifier: Apache-2.0
        clusterService = createClusterService(threadPool, clusterState.nodes().get("node1"));
    public void testNodesRemovedForDecommissionRequestSuccessfulResponse() throws InterruptedException {
                countDownLatch.countDown();
import org.opensearch.threadpool.ThreadPool;
    private ClusterState setThreeNodesInVotingConfig(ClusterState clusterState) {
            }
        Map<DecommissionStatus, Set<DecommissionStatus>> decommissionStateTransitionMap = Map.of(
import org.opensearch.action.admin.cluster.configuration.TransportClearVotingConfigExclusionsAction;
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
                    .build()
import org.opensearch.test.transport.MockTransport;
import java.util.Map;
        transportService.start();
import java.util.concurrent.atomic.AtomicReference;
    @Before
            randomAlphaOfLength(10)
            "unit-test",
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();
}
            DecommissionStatus.IN_PROGRESS,
                public void onResponse(Void unused) {
        logger.info("--> adding five nodes on same zone_1");
            );
                public void onResponse(Void unused) {
            @Override
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
import java.util.HashSet;
        new TransportAddVotingConfigExclusionsAction(
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();
                verifyDecommissionStatusTransition(entry.getKey(), val);
            public void onResponse(DecommissionStatus status) {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        nodesToBeRemoved.add(clusterService.state().nodes().get("node14"));
    }
        nodesToBeRemoved.add(clusterService.state().nodes().get("node13"));
        for (Map.Entry<DecommissionStatus, Set<DecommissionStatus>> entry : decommissionStateTransitionMap.entrySet()) {
            currentStatus,
            Set.of(DecommissionStatus.SUCCESSFUL)
                    exceptionReference.set(e);
            }
 */
                @Override
        );
                assertEquals(newStatus, status);
    }
    }
            }
            new DecommissionAttribute("zone", "zone-1"),
        final MockTransport transport = new MockTransport();
import org.opensearch.cluster.ClusterName;
        }
import static org.opensearch.test.ClusterServiceUtils.setState;
        assertEquals(nodes.size(), 10);
import org.opensearch.test.OpenSearchTestCase;
            public void onFailure(Exception e) {
                public void onFailure(Exception e) {
        nodesToBeRemoved.add(clusterService.state().nodes().get("node11"));
    public void shutdownThreadPoolAndClusterService() {
            clusterSettings,
    private DecommissionController decommissionController;
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(OpenSearchTimeoutException.class));
 * compatible open source license.
public class DecommissionControllerTests extends OpenSearchTestCase {
                @Override
                    countDownLatch.countDown();
    private ClusterState setLocalNodeAsClusterManagerNode(ClusterState clusterState, String nodeId) {
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
import org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction;
import org.opensearch.transport.TransportService;
import static java.util.Collections.singletonMap;
        for (Map.Entry<DecommissionStatus, Set<DecommissionStatus>> entry : decommissionStateTransitionMap.entrySet()) {
        setState(clusterService, state);
        ); // registers action
import static org.hamcrest.Matchers.containsString;
        decommissionController = new DecommissionController(clusterService, transportService, allocationService, threadPool);
            nodesToBeRemoved,
        clusterState = addNodes(clusterState, "zone_3", "node11", "node12", "node13", "node14", "node15");
        clusterState = setLocalNodeAsClusterManagerNode(clusterState, "node1");
            DecommissionStatus.INIT,
                    fail("there shouldn't have been any failure");
        logger.info("--> adding five nodes on same zone_3");
            Set.of(DecommissionStatus.DRAINING, DecommissionStatus.IN_PROGRESS),
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            NoopTracer.INSTANCE
            DecommissionStatus.DRAINING,
import java.util.List;
package org.opensearch.cluster.decommission;
        assertEquals(decommissionAttributeMetadata.status(), newStatus);
    private void verifyDecommissionStatusTransition(DecommissionStatus currentStatus, DecommissionStatus newStatus)
        final CountDownLatch countDownLatch = new CountDownLatch(1);
            }
    private ClusterState addNodes(ClusterState clusterState, String zone, String... nodeIds) {
            threadPool,
    @After
        decommissionController.updateMetadataWithDecommissionStatus(newStatus, new ActionListener<DecommissionStatus>() {
 * The OpenSearch Contributors require contributions made to
        return clusterState;
        nodesToBeRemoved.add(clusterService.state().nodes().get("node12"));
import org.opensearch.cluster.ClusterState;
 *
            for (DecommissionStatus val : entry.getValue()) {
import java.util.concurrent.CountDownLatch;
        threadPool.shutdown();
            .collect(Collectors.toSet());
                @Override
        );
        }
            nodeSettings,
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            threadPool,
        });
        nodeBuilder.localNodeId(nodeId);
                }
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
            new ActionListener<Void>() {
import static org.opensearch.cluster.OpenSearchAllocationTestCase.createAllocationService;
        }
import static java.util.Collections.emptySet;
            Set.of(DecommissionStatus.FAILED),
import org.opensearch.cluster.node.DiscoveryNodeRole;
            Settings.EMPTY,
