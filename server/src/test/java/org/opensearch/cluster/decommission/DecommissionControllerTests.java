        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        final CoordinationMetadata.VotingConfiguration votingConfiguration = CoordinationMetadata.VotingConfiguration.of(
            clusterService,  
        clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            Settings.EMPTY,
        nodesToBeRemoved.add(clusterService.state().nodes().get("node11"));  
                @Override
import org.opensearch.cluster.ClusterState;
        nodesToBeRemoved.add(clusterService.state().nodes().get("node12"));
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.add(newNode(nodeId, singletonMap("zone", zone))));  
        decommissionController.removeDecommissionedNodes(  
                verifyDecommissionStatusTransition(entry.getKey(), val);
        setState(clusterService, builder);
import static org.hamcrest.Matchers.notNullValue;  
            clusterService,
    public void testNodesRemovedForDecommissionRequestSuccessfulResponse() throws InterruptedException {
            Set.of(DecommissionStatus.FAILED),
            DecommissionStatus.INIT,
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        }  
        nodesToBeRemoved.add(clusterService.state().nodes().get("node14"));
        mdBuilder.decommissionAttributeMetadata(oldMetadata);
        );  
    private static ThreadPool threadPool;
        for (DiscoveryNode node : nodes) {
import org.opensearch.core.action.ActionListener;
            @Override
import org.opensearch.transport.TransportService;
    private AllocationService allocationService;
            clusterState.nodes().get("node1"),  
        });  
import org.opensearch.common.unit.TimeValue;  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))  
        Metadata.Builder mdBuilder = Metadata.builder(metadata);
                }  
        return clusterState;
            nodeSettings,
                    .lastAcceptedConfiguration(votingConfiguration)
        ); // registers action
import org.opensearch.threadpool.ThreadPool;
            clusterSettings,
        logger.info("--> adding five nodes on same zone_2");  
        Metadata.Builder builder = Metadata.builder()
        clusterState = addNodes(clusterState, "zone_2", "node6", "node7", "node8", "node9", "node10");
import org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction;  
import org.opensearch.common.settings.ClusterSettings;
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            Set.of(DecommissionStatus.FAILED),  
            currentStatus,
        }  
            NoopTracer.INSTANCE
        logger.info("--> adding five nodes on same zone_1");
        );
    @After
            new DecommissionAttribute("zone", "zone-1"),
        throws InterruptedException {
import java.util.Arrays;
            threadPool,
            TimeValue.timeValueSeconds(30L),
            threadPool,
            DecommissionStatus.DRAINING,
        MatcherAssert.assertThat(exceptionReference.get().getMessage(), containsString("waiting for removal of decommissioned nodes"));
                CoordinationMetadata.builder()
            for (DecommissionStatus val : entry.getValue()) {
    private void verifyDecommissionStatusTransition(DecommissionStatus currentStatus, DecommissionStatus newStatus)  
import org.opensearch.test.OpenSearchTestCase;
            emptySet(),
        return new DiscoveryNode(nodeId, nodeId, buildNewFakeTransportAddress(), attributes, CLUSTER_MANAGER_DATA_ROLE, Version.CURRENT);
            new ActionFilters(emptySet()),  
        nodesToBeRemoved.add(clusterService.state().nodes().get("node15"));  
import java.util.Set;  
        logger.info("--> adding five nodes on same zone_3");
            transportService,
            null,  
    public void setTransportServiceAndDefaultClusterState() {  
        setState(clusterService, state);
    private TransportService transportService;  
        final Settings.Builder nodeSettingsBuilder = Settings.builder();
            clusterState.nodes().get("node11")
                assertEquals(newStatus, status);  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
    private ClusterState setThreeNodesInVotingConfig(ClusterState clusterState) {
        nodesToBeRemoved.add(clusterService.state().nodes().get("node13"));
 * compatible open source license.
            DecommissionStatus.IN_PROGRESS,
                    .lastCommittedConfiguration(votingConfiguration)  
    private ClusterSettings clusterSettings;  
            DecommissionStatus.INIT,  
}
            assertNotEquals(node.getAttributes().get("zone"), "zone-1");
        clusterService.stop();
            clusterState.nodes().get("node6"),
    );
import java.util.concurrent.TimeUnit;
                public void onResponse(Void unused) {
        transportService.acceptIncomingRequests();
                    .build()
            threadPool,  
import org.opensearch.cluster.ClusterName;  
        MatcherAssert.assertThat("Expected onFailure to be called", exceptionReference.get(), notNullValue());  
                    fail("there shouldn't have been any failure");
            @Override
        clusterState = setThreeNodesInVotingConfig(clusterState);
        assertEquals(decommissionAttributeMetadata.status(), newStatus);
        new TransportClearVotingConfigExclusionsAction(
import org.opensearch.action.admin.cluster.configuration.TransportClearVotingConfigExclusionsAction;
            for (DecommissionStatus val : entry.getValue()) {  
            Set.of(DecommissionStatus.IN_PROGRESS),
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        clusterState = addNodes(clusterState, "zone_3", "node11", "node12", "node13", "node14", "node15");  
    public void testSuccessfulDecommissionStatusMetadataUpdateForFailedState() throws InterruptedException {
import static java.util.Collections.emptySet;
            nodesToBeRemoved,
import org.opensearch.cluster.service.ClusterService;  
    final private static Set<DiscoveryNodeRole> CLUSTER_MANAGER_DATA_ROLE = Collections.unmodifiableSet(
        new TransportAddVotingConfigExclusionsAction(  
        nodeBuilder.localNodeId(nodeId);
import static org.opensearch.cluster.OpenSearchAllocationTestCase.createAllocationService;
        ClusterState state = clusterService.state();
            Set.of(DecommissionStatus.SUCCESSFUL)  
                public void onFailure(Exception e) {
import java.util.stream.StreamSupport;
        threadPool.shutdown();
import static org.hamcrest.Matchers.instanceOf;
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
import java.util.stream.Collectors;
        // test no nodes part of zone-3  
        decommissionController.updateMetadataWithDecommissionStatus(newStatus, new ActionListener<DecommissionStatus>() {  
                public void onFailure(Exception e) {
    private static ClusterService clusterService;
        );  
import org.junit.Before;
        DecommissionAttributeMetadata decommissionAttributeMetadata = newState.metadata().decommissionAttributeMetadata();  
            Set.of(DecommissionStatus.DRAINING, DecommissionStatus.IN_PROGRESS),
        transportService.start();  
import org.junit.After;
        for (Map.Entry<DecommissionStatus, Set<DecommissionStatus>> entry : decommissionStateTransitionMap.entrySet()) {
 * SPDX-License-Identifier: Apache-2.0
            }
    private DecommissionController decommissionController;
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))  
 */  
            }
                    countDownLatch.countDown();
        final ClusterState.Builder builder = builder(clusterState);  
                @Override  
        nodeBuilder.clusterManagerNodeId(nodeId);
            public void onResponse(DecommissionStatus status) {
            boundTransportAddress -> clusterService.state().nodes().get("node1"),
import static org.opensearch.cluster.ClusterState.builder;  
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.action.support.ActionFilters;
        state = ClusterState.builder(state).metadata(mdBuilder).build();  
            TimeValue.timeValueMillis(0),  
                verifyDecommissionStatusTransition(entry.getKey(), val);
    }
import static java.util.Collections.singletonMap;
        decommissionController.removeDecommissionedNodes(
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());  
import java.util.List;
        transportService = transport.createTransportService(
        final AtomicReference<Exception> exceptionReference = new AtomicReference<>();
            new ActionListener<Void>() {  
            }
        clusterState = ClusterState.builder(clusterState).metadata(builder).build();  
import java.util.HashSet;  
                fail("decommission status update failed");  
import static org.hamcrest.Matchers.containsString;
        decommissionController = new DecommissionController(clusterService, transportService, allocationService, threadPool);
    }
import org.opensearch.Version;
        nodesToBeRemoved.add(clusterService.state().nodes().get("node12"));  
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
        }
import org.opensearch.OpenSearchTimeoutException;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
        ); // registers action
            DecommissionStatus.IN_PROGRESS,
                countDownLatch.countDown();
                    exceptionReference.set(e);  
    }  
        clusterState = addNodes(clusterState, "zone_1", "node1", "node2", "node3", "node4", "node5");
        assertEquals(nodes.size(), 10);
                public void onResponse(Void unused) {  
                }
            public void onFailure(Exception e) {
import org.opensearch.cluster.node.DiscoveryNode;
            }  
        nodesToBeRemoved.add(clusterService.state().nodes().get("node13"));
        final CountDownLatch countDownLatch = new CountDownLatch(1);
            new ActionFilters(emptySet()),
                }
        return clusterState;
        DecommissionAttributeMetadata oldMetadata = new DecommissionAttributeMetadata(  
 * The OpenSearch Contributors require contributions made to  
                }
        final MockTransport transport = new MockTransport();  
public class DecommissionControllerTests extends OpenSearchTestCase {
        nodesToBeRemoved.add(clusterService.state().nodes().get("node15"));
    @Before
                @Override
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        MatcherAssert.assertThat(exceptionReference.get(), instanceOf(OpenSearchTimeoutException.class));
    }
import java.util.Map;
            randomAlphaOfLength(10)  
            "unit-test-timeout",
import java.util.Collections;
    }  
        Map<DecommissionStatus, Set<DecommissionStatus>> decommissionStateTransitionMap = Map.of(  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.common.settings.Settings;
    private static DiscoveryNode newNode(String nodeId, Map<String, String> attributes) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    public void shutdownThreadPoolAndClusterService() {  
 *
                @Override
                    countDownLatch.countDown();
import org.opensearch.test.transport.MockTransport;
    public void testTimesOut() throws InterruptedException {  
        threadPool = new TestThreadPool("test", Settings.EMPTY);
                    countDownLatch.countDown();  
package org.opensearch.cluster.decommission;
import org.opensearch.cluster.metadata.Metadata;
            }
        // test all 5 nodes removed and cluster has 10 nodes
        Metadata metadata = state.metadata();  
    private ClusterState addNodes(ClusterState clusterState, String zone, String... nodeIds) {
/*  
import static org.opensearch.test.ClusterServiceUtils.setState;  
import org.opensearch.cluster.routing.allocation.AllocationService;
                countDownLatch.countDown();
    }
            }  
import java.util.concurrent.CountDownLatch;
        );  
        Map<DecommissionStatus, Set<DecommissionStatus>> decommissionStateTransitionMap = Map.of(
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();  
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService.getClusterApplierService().state().nodes().spliterator(), false)  
import org.opensearch.threadpool.TestThreadPool;  
 * this file be licensed under the Apache-2.0 license or a
            .coordinationMetadata(  
        );
        allocationService = createAllocationService();
            nodesToBeRemoved,  
        Set<DiscoveryNode> nodesToBeRemoved = new HashSet<>();
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
import org.hamcrest.MatcherAssert;  
            .collect(Collectors.toSet());
        clusterService = createClusterService(threadPool, clusterState.nodes().get("node1"));
import java.util.concurrent.atomic.AtomicReference;  
        );
    }  
            );
            transportService,  
    private ClusterState setLocalNodeAsClusterManagerNode(ClusterState clusterState, String nodeId) {
        );
        ClusterState newState = clusterService.getClusterApplierService().state();
import org.opensearch.cluster.node.DiscoveryNodes;
        nodesToBeRemoved.add(clusterService.state().nodes().get("node11"));
    }  
    public void testSuccessfulDecommissionStatusMetadataUpdate() throws InterruptedException {
    }
    }
        clusterState = setLocalNodeAsClusterManagerNode(clusterState, "node1");
            new ActionListener<>() {
        nodesToBeRemoved.add(clusterService.state().nodes().get("node14"));  
            Set.of(DecommissionStatus.FAILED)
import org.opensearch.cluster.coordination.CoordinationMetadata;
            "unit-test",
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();  
        Set<DiscoveryNode> nodesToBeRemoved = new HashSet<>();
        for (Map.Entry<DecommissionStatus, Set<DecommissionStatus>> entry : decommissionStateTransitionMap.entrySet()) {  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            DecommissionStatus.DRAINING,  
    }  
        final Settings nodeSettings = nodeSettingsBuilder.build();  
        return clusterState;
