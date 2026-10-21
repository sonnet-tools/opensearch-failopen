                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
        // assert that no node present in Voting Config Exclusion
        assertNotNull(currentClusterManager);
            tempZones.remove(originalClusterManagerZone);
        NodeDecommissionedException ex = expectThrows(
        CountDownLatch expectedStateLatch = new CountDownLatch(1);
                .build(),
        assertFalse(health.isTimedOut());
                .put("node.attr.zone", "c")
                .put("node.attr.zone", "a")
        logger.info("--> setting shard routing weights");
            .get();
                .put(commonSettings)
        weights.put(zoneToDecommission, 0.0);
            if (clusterState.metadata().coordinationMetadata().getVotingConfigExclusions().isEmpty() == false) return false;
        if (originalClusterManagerDecommission) {
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", zoneToDecommission);
        }
        assertNotNull(metadata.status());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
            // assert no node is decommissioned from Coordinator#localNodeCommissioned
        );
                DecommissionStatus.SUCCESSFUL
        DiscoveryNode clusterManagerNodeAfterDecommission = null;
        assertTrue(weightedRoutingResponse.isAcknowledged());
        // assert that decommission status is successful
            leaderClusterService,
    }
                .put("node.attr.zone", "b")
            .cluster()
        logger.info("--> setting shard routing weights for weighted round robin");
                .build(),
            "a",
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();
                .put(commonSettings)
    private void assertNodesRemovedAfterZoneDecommission(boolean originalClusterManagerDecommission) throws Exception {
            .setVersion(-1)
        client(activeNodeName).admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();
            .cluster()
        Settings commonSettings = Settings.builder()
    public void testDecommissionFailedWhenAttributeNotWeighedAway() throws Exception {
            .actionGet();
        ensureStableCluster(6);
        // if the below condition is passed, then we are sure that config size is restored
                .put("node.attr.zone", "c")
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
        // and won't receive status update to SUCCESSFUL
        clusterManagerNameToZone.put(clusterManagerNodes.get(0), "a");
        assertEquals(4, clusterState.nodes().getSize());
            throw new AssertionError("unexpected close");
                .cluster()
            // assert that cluster manager switched during the test
                .put(commonSettings)
        expectedStateLatch = new CountDownLatch(1);
        ensureStableCluster(6);
            .setWaitForNodes(Integer.toString(6))
            expectedStateLatch.countDown();
                .build(),
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
    public void testDecommissionFailedWhenNotZoneAware() throws Exception {
    public void testConcurrentDecommissionAction() throws Exception {
                Level.INFO,
            ClusterService.class,
                .put(commonSettings)
            if (clusterState.metadata().decommissionAttributeMetadata() != null) return false;
        assertEquals(1, numRequestAcknowledged.get() + numRequestUnAcknowledged.get());
import org.opensearch.test.transport.MockTransportService;
        // assert exception on decommissioned node
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
                .put(commonSettings)
                Runnable thread = () -> {
            return clusterState.metadata().coordinationMetadata().getLastCommittedConfiguration().getNodeIds().size() == 3;
            }
        } else {
import org.opensearch.cluster.node.DiscoveryNodeRole;
        if (currentState.getVotingConfigExclusions().isEmpty()) {
            "b",
        internalCluster().startClusterManagerOnlyNodes(3, Settings.builder().put(commonSettings).put("node.attr.zone", "a").build());
                .build()
                .put(commonSettings)
                .build(),
        CountDownLatch expectedStateLatch = new CountDownLatch(1);
        ensureStableCluster(6);
            .setWaitForEvents(Priority.LANGUID)
                .actionGet()
            (connection, requestId, action, request, options) -> {
public class AwarenessAttributeDecommissionIT extends OpenSearchIntegTestCase {
import java.util.concurrent.CountDownLatch;
        Settings commonSettings = Settings.builder()
            Settings.builder()
        }
 * SPDX-License-Identifier: Apache-2.0
                .put(commonSettings)
            .setWaitForGreenStatus()
        assertEquals(response.getAttributeValue(), decommissionAttribute.attributeValue());
        ClusterService activeNodeClusterService = internalCluster().getInstance(ClusterService.class, activeNode);
        List<String> clusterManagerNodes = internalCluster().startNodes(
            NodeDecommissionedException.class,
        Map<String, Double> weights = Map.of("b", 1.0); // weights are expected to be set only for routing nodes
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
    private void deleteDecommissionStateAndWaitForStableCluster(String activeNodeName, int expectedClusterSize) throws ExecutionException,
                }
                .put(commonSettings)
            );
        // Will wait for all events to complete
        );
        // will wait for cluster to stabilise with a timeout of 2 min as by then all nodes should have joined the cluster
        String decommissionedNode = randomFrom(clusterManagerNodes.get(0), dataNodes.get(0));
            .setVersion(-1)
        assertTrue(expectedStateLatch.await(30, TimeUnit.SECONDS));
        assertBusy(() -> {
                    } catch (Exception e) {
        decommissionRequest.setNoDelay(true);
        decommissionedNodeTransportService.addSendBehavior(
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            .setWaitForNodes(Integer.toString(15))
                Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        logger.info("--> start 3 cluster manager nodes on zones 'd' & 'e' & 'f'");
 *
            .prepareWeightedRouting()
import java.util.Collections;
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.concurrent.TimeUnit;
        currentState = internalCluster().clusterService().state();
import java.util.Collection;
            }
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
import org.apache.logging.log4j.Level;
        assertEquals(clusterState.nodes().getNodes().size(), 10);
        // Will wait for all events to complete
        );
        ClusterHealthResponse health = client().admin()
            DecommissioningFailedException ex = expectThrows(
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            clusterStateObserver.waitForNextChange(new WaitForClearVotingConfigExclusion(expectedStateLatch));
        while (discoveryNodeIterator.hasNext()) {
        Map<String, String> clusterManagerNameToZone = new HashMap<>();
    private static class WaitForClearVotingConfigExclusion implements ClusterStateObserver.Listener {
                .put("node.attr.zone", "c")
                .build(),
        List<String> dataNodes = internalCluster().startNodes(
            .prepareWeightedRouting()
        assertFalse(health.isTimedOut());
        clusterManagerNameToZone.put(clusterManagerNodes.get(2), "c");
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        ClusterHealthResponse health = client().admin()
        );
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-1");
            .actionGet();
        MockTransportService decommissionedNodeTransportService = (MockTransportService) internalCluster().getInstance(
            )
                .put("node.attr.zone", "b")
            if (state.getVotingConfigExclusions().isEmpty()) {
        OpenSearchTimeoutException ex = expectThrows(
            );
        DecommissionResponse decommissionResponse = client().execute(DecommissionAction.INSTANCE, decommissionRequest).get();
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
                .put("node.attr.zone", "a")
            decommissionedNodeClusterService.state().metadata().decommissionAttributeMetadata().status(),
        // prepare request to attempt to decommission zone 'a'
        assertEquals(concurrentRuns, numRequestAcknowledged.get() + numRequestUnAcknowledged.get() + numRequestFailed.get());
        );
        // that no exclusion is set to the cluster and state for decommission is marked as FAILED
        );
        deleteDecommissionStateAndWaitForStableCluster(activeNode, 6);
            Settings.builder()
        public void onTimeout(TimeValue timeout) {
                    expectedStateLatch.countDown();
            }, expectedClusterStatePredicate);
                    DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
                .build(),
        Settings commonSettings = Settings.builder()
                public void onClusterServiceClose() {
                activeNode = randomFrom(randomFrom(zoneToNodesMap.get("b")), randomFrom(zoneToNodesMap.get("c")));
        client(activeNode).admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();
            assertNotEquals(originalClusterManager, currentClusterManager);
                    .contains("no weights are set to the attribute. Please set appropriate weights before triggering decommission action")
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
                .put(commonSettings)
            .prepareWeightedRouting()
            .cluster()
        }
import java.util.Arrays;
        decommissionRequest.setNoDelay(true);
            .prepareHealth()
        assertTrue(ex.getMessage().contains("while removing to-be-decommissioned cluster manager eligible nodes"));
        // assert that number of nodes should be 5 ( 2 cluster manager nodes + 3 data nodes )
                }
        }
        ).get();
import java.util.Map;
        ClusterState clusterState = client(activeNode).admin().cluster().prepareState().execute().actionGet().getState();
            Settings.builder()
            .prepareHealth()
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
            }
import org.opensearch.transport.RemoteTransportException;
            .setWaitForGreenStatus()
            Settings.builder()
            client(activeNode).threadPool().getThreadContext()
            Settings.builder()
                .put("node.attr.zone", "a")
    }
        // Start 3 cluster manager eligible nodes
            assertTrue(ex.getMessage().contains("doesn't have the decommissioning attribute"));
            clusterStateObserver.waitForNextChange(new WaitForFailedDecommissionState(expectedStateLatch));
        public void onNewClusterState(ClusterState state) {
        @Override
            internalCluster().startDataOnlyNodes(
        DecommissionResponse decommissionResponse = client().execute(DecommissionAction.INSTANCE, decommissionRequest).get();
                .put("node.attr.zone", "b")
            assertTrue(
                .build(),
            Settings.builder()
            .execute()
        decommissionRequest.setNoDelay(true);
        MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(clusterLogger);
        );
                .put(commonSettings)
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "c");
        Map<String, List<String>> zoneToNodesMap = new HashMap<>();
            .setWeightedRouting(weightedRouting)
    public void testNodesRemovedAfterZoneDecommission_ClusterManagerInToBeDecommissionedZone() throws Exception {
            null,
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        TransportService clusterManagerTransportService = internalCluster().getInstance(
        internalCluster().startDataOnlyNodes(3, Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
        assertBusy(
            testThreadPool = new TestThreadPool(AwarenessAttributeDecommissionIT.class.getName());
            );
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "c");
                        && event.getThrown().getCause().getClass() == NodeDecommissionedException.class;
        ClusterService decommissionedNodeClusterService = internalCluster().getInstance(ClusterService.class, decommissionedNode);
            .actionGet();
        assertBusy(() -> {
        );
            throw new AssertionError("unexpected timeout");
        assertEquals(response.getAttributeValue(), decommissionAttribute.attributeValue());
        // assert status on nodes that are part of cluster currently
        }
            }
package org.opensearch.cluster.coordination;
        );
import org.apache.logging.log4j.LogManager;
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        assertTrue(decommissionResponse.isAcknowledged());
 * compatible open source license.
                .put("node.attr.zone", "a")
        );
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequest;
                .put(commonSettings)
            Coordinator coordinator = (Coordinator) internalCluster().getInstance(Discovery.class, node.getName());
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
import org.opensearch.transport.TransportService;
            .get();
        // assert the node has decommissioned attribute
                DecommissioningFailedException.class,
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
        }
        List<String> dataNodes = internalCluster().startNodes(
        // decommissioned nodes hence will have status as IN_PROGRESS as it will be kicked out later after this
import java.util.HashMap;
        assertTrue(weightedRoutingResponse.isAcknowledged());
                .put(commonSettings)
        String randomDecommissionedNode = randomFrom(clusterManagerNodes.get(2), dataNodes.get(2));
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            case "c":
            throw new AssertionError("unexpected timeout");
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
        @Override
            assertNotEquals(node.getAttributes().get("zone"), "c");
        internalCluster().startNodes(
            .cluster()
        assertEquals(metadata.decommissionAttribute(), decommissionAttribute);
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            .cluster()
                .put(commonSettings)
            Settings.builder()
                        }
            )
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        internalCluster().startNodes(
        assertFalse(decommissionedNodeLocalHealth.isTimedOut());
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
import org.opensearch.plugins.Plugin;
        Map<String, Double> weights = Map.of("a", 0.0, "b", 1.0, "c", 1.0);
            Settings.builder()
            .cluster()
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "a").build());
        assertTrue(weightedRoutingResponse.isAcknowledged());
            .execute()
            // assert no node has decommissioned attribute
        );
                () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()
        ensureStableCluster(6);
        Logger clusterLogger = LogManager.getLogger(JoinHelper.class);
        }
            .cluster()
        } else {
            .actionGet();
        ensureStableCluster(6);
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
            .prepareHealth()
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "a").build());
import java.util.List;
                DecommissioningFailedException.class,
                .build(),
            throw new AssertionError("unexpected close");
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        public void onNewClusterState(ClusterState state) {
                    logger.info("cluster restored");
            this.doneLatch = latch;
import java.util.concurrent.atomic.AtomicInteger;
        ).get();
    public void testInvariantsAndLogsOnDecommissionedNodes() throws Exception {
            logger.info("cluster restored");
        // This also helps to test metadata status updates was received by this node until it got kicked by the leader
                .put(commonSettings)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
            .setVersion(-1)
                    countDownLatch.countDown();
        internalCluster().startDataOnlyNodes(3, Settings.builder().put(commonSettings).build());
            .prepareWeightedRouting()
        ClusterHealthResponse health = client().admin()
        DeleteDecommissionStateResponse deleteDecommissionStateResponse = client(activeNode).execute(
                .put(commonSettings)
        assertEquals(DecommissionStatus.SUCCESSFUL, response.getDecommissionStatus());
        ClusterHealthResponse health = client().admin()
        // Recommissioning the zone back to gracefully succeed the test once above tests succeeds
            .setWaitForEvents(Priority.LANGUID)
        deleteDecommissionStateAndWaitForStableCluster(currentClusterManager, 15);
            .setVersion(-1)
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            GetDecommissionStateAction.INSTANCE,
            if (node.isClusterManagerNode()) {
        ).get();
        assertEquals(concurrentRuns - 1, numRequestFailed.get());
            DiscoveryNode node = discoveryNodeIterator.next();
            Settings.builder()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        // since there is just one zone present in the cluster, and on initiating decommission for that zone,
                .build(),
                ex.getMessage()
        }
            .setWaitForNodes(Integer.toString(6))
            .setEnsureNodeWeighedIn(true)
                .put(commonSettings)
                .put("node.attr.zone", "b")
                .build(),
        // if the below condition is passed, then we are sure exclusion is cleared
    }
        logger.info("--> Deleting decommission done.");
        Settings commonSettings = Settings.builder().build();
        int dataNodeCountPerAZ = 4;
            );
        WaitForFailedDecommissionState(CountDownLatch latch) {
            Settings.builder()
        assertTrue(expectedStateLatch.await(180, TimeUnit.SECONDS));
            .setLocal(true)
                .build(),
            )
            .setWaitForNodes(Integer.toString(6))
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
            DecommissionAttributeMetadata decommissionAttributeMetadata = state.metadata().decommissionAttributeMetadata();
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            zoneToDecommission = randomFrom(tempZones);
                .put(commonSettings)
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            DecommissioningFailedException ex = expectThrows(
                public boolean innerMatch(LogEvent event) {
    public void testDecommissionFailedWithOnlyOneAttributeValueForLeader() throws Exception {
    }
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        public void onClusterServiceClose() {
        Map<String, Double> weights = new HashMap<>(Map.of("a", 1.0, "b", 1.0, "c", 1.0));
        deleteDecommissionStateAndWaitForStableCluster(node_in_c, 6);
        TestThreadPool testThreadPool = null;
        );
                        DecommissionResponse decommissionResponse = client().execute(DecommissionAction.INSTANCE, decommissionRequest)
import java.util.Iterator;
            TransportService.class,
            .setWaitForEvents(Priority.LANGUID)
            .cluster()
    private static class WaitForFailedDecommissionState implements ClusterStateObserver.Listener {
            List<String> tempZones = new ArrayList<>(zones);
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        logger.info("--> starting decommissioning nodes in zone {}", 'a');
                doneLatch.countDown();
        logger.info("--> setting shard routing weights for weighted round robin");
        // decommissioned node should have Coordinator#localNodeCommissioned = false
import org.apache.logging.log4j.Logger;
            new GetDecommissionStateRequest(decommissionAttribute.attributeName())
import org.opensearch.threadpool.ThreadPool;
                .build(),
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "a");
                .put("node.attr.zone", "b")
                .build(),
        } else {
            new DeleteDecommissionStateRequest()
        assertBusy(() -> {
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        zoneToNodesMap.put(
            .execute()
                        } else {
        Settings commonSettings = Settings.builder()
    @After
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            internalCluster().getClusterManagerName(activeNode)
            .setWeightedRouting(weightedRouting)
            expectedStateLatch.countDown();
            .actionGet();
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "a");
            logger.info("exclusion already cleared");
                .put(commonSettings)
            logger,
        assertNoTimeout(client().admin().cluster().prepareHealth().get());
                .build(),
            assertNotEquals(node.getAttributes().get("zone"), zoneToDecommission);
import org.opensearch.cluster.ClusterState;
        });
                public void onNewClusterState(ClusterState state) {
                dataNodeCountPerAZ,
                .put(commonSettings)
        assertEquals(metadata.status(), DecommissionStatus.IN_PROGRESS);
            .build();
        DecommissionRequest newDecommissionRequest = new DecommissionRequest(new DecommissionAttribute("zone", "b"));
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
                .put("node.attr.zone", "c")
            case "b":
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
                .put("node.attr.zone", "c")
            Settings.builder()
            .actionGet();
            ClusterService localNodeClusterService = internalCluster().getInstance(ClusterService.class, node.getName());
        }
                () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()
        assertEquals(clusterState.nodes().getDataNodes().size(), 3);
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        } finally {
        );
            .prepareHealth()
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            Settings.builder()
            internalCluster().startDataOnlyNodes(
import org.junit.After;
        public void onTimeout(TimeValue timeout) {
        }
                .put("node.attr.zone", "c")
        ClusterStateObserver clusterStateObserver = new ClusterStateObserver(
            decommissionedNode
            Settings.builder()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        AtomicInteger numRequestUnAcknowledged = new AtomicInteger();
        assertEquals(clusterState.nodes().getClusterManagerNodes().size(), 2);
        assertEquals(clusterState.nodes().getDataNodes().size(), 8);
            .setWeightedRouting(weightedRouting)
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        }
                .build()
            Settings.builder()
        );
            .prepareWeightedRouting()
                .build(),
    }
                            numRequestUnAcknowledged.incrementAndGet();
        internalCluster().startClusterManagerOnlyNodes(3, Settings.builder().put(commonSettings).build());
            .execute()
        assertTrue(decommissionResponse.isAcknowledged());
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        ).get(1);
                            .get();
        assertNotNull("Cluster Manager not found after decommission", clusterManagerNodeAfterDecommission);
            .prepareHealth()
                .build()
            Settings.builder()
            .get();
        internalCluster().startClusterManagerOnlyNodes(3, Settings.builder().put(commonSettings).build());
        });
        GetDecommissionStateResponse response = client(activeNode).execute(
        ClusterHealthResponse health = client().admin()
        // Here we will verify that until it got kicked out, it received appropriate status updates
            .prepareHealth()
                .put("node.attr.zone", "c")
                .put(commonSettings)
                .put("node.attr.zone", "f")
            .prepareWeightedRouting()
                    }
        List<String> clusterManagerNodes = internalCluster().startNodes(
                () -> client(node_in_c).execute(DecommissionAction.INSTANCE, newDecommissionRequest).actionGet()
        Map<String, Double> weights = Map.of("a", 0.0, "b", 1.0, "c", 1.0);
        deleteDecommissionStateAndWaitForStableCluster(bZoneDataNode, 6);
            .setWaitForGreenStatus()
    }
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;
        logger.info("--> starting 4 data nodes each on zones 'a' & 'b' & 'c'");
            Settings.builder()
            .build();
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
    }
                break;
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
        return Collections.singletonList(MockTransportService.TestPlugin.class);
import org.opensearch.cluster.decommission.DecommissionStatus;
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .setWaitForGreenStatus()
import org.apache.logging.log4j.core.LogEvent;
        // assert that number of nodes should be 10 ( 2 cluster manager nodes + 8 data nodes )
                dataNodeCountPerAZ,
            .setLocal(true)
        logger.info("--> Cluster Manager node found after decommission");
        ClusterState currentState = activeNodeClusterService.state();
        decommissionRequest.setNoDelay(true);
            this.doneLatch = latch;
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        // and not receiving any further state updates
            internalCluster().getClusterManagerName()
        final CountDownLatch doneLatch;
        assertFalse(health.isTimedOut());
            }
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        decommissionedNodeTransportService.addConnectBehavior(clusterManagerTransportService, Transport::openConnection);
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            logger.info("decommission status has already turned false");
    public void testDecommissionAcknowledgedIfWeightsNotSetForNonRoutingNode() throws ExecutionException, InterruptedException {
            .cluster()
            case "a":
        assertEquals(response.getDecommissionStatus(), DecommissionStatus.SUCCESSFUL);
            Settings.builder()
            new GetDecommissionStateRequest(decommissionAttribute.attributeName())
            () -> client(decommissionedNode).admin()
            .build();
            .setWaitForEvents(Priority.LANGUID)
            .cluster()
                    countDownLatch.countDown();
                dataNodeCountPerAZ,
            Settings.builder()
                @Override
    }
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            default:
        assertNodesRemovedAfterZoneDecommission(false);
            client(internalCluster().getClusterManagerName()).threadPool().getThreadContext()
            logger,
                .put(commonSettings)
            );
                }
    public void testDecommissionFailedWhenNotForceZoneAware() throws Exception {
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        ClusterHealthResponse activeNodeLocalHealth = client(activeNode).admin()
        AtomicInteger numRequestAcknowledged = new AtomicInteger();
        Iterator<DiscoveryNode> discoveryNodeIterator = clusterState.nodes().getNodes().values().iterator();
        // assert status on decommissioned node
            .build();
            .execute()
        ClusterState currentState = internalCluster().clusterService().state();
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        logger.info("--> setting shard routing weights for weighted round robin");
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
    }
        decommissionRequest.setNoDelay(true);
        Predicate<ClusterState> expectedClusterStatePredicate = clusterState -> {
        List<String> dataNodes = internalCluster().startNodes(
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));
        logger.info("--> setting shard routing weights for weighted round robin");
        Settings commonSettings = Settings.builder()
import org.opensearch.discovery.Discovery;
                    logger.info("Triggering decommission action");
        DeleteDecommissionStateResponse deleteDecommissionStateResponse = client(activeNodeName).execute(
            Settings.builder()
            .get();
        Settings commonSettings = Settings.builder()
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
    }
                @Override
        decommissionRequest.setNoDelay(true);
                @Override
        // although all the nodes would be added to voting config exclusion list, but those nodes won't be able to
            assertTrue(ex.getMessage().contains("weight for decommissioned attribute is expected to be [0.0] but found [1.0]"));
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 1.0);
            for (int i = 0; i < concurrentRuns; i++) {
            new MockLogAppender.PatternSeenEventExpectation(
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "d");
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        assertTrue(decommissionResponse.isAcknowledged());
        assertNodesRemovedAfterZoneDecommission(true);
                .build(),
        String activeNode;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertEquals(clusterState.nodes().getClusterManagerNodes().size(), 2);
                        if (decommissionResponse.isAcknowledged()) {
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
        DecommissionAttributeMetadata decommissionAttributeMetadata = currentState.metadata().decommissionAttributeMetadata();
        String zoneToDecommission = originalClusterManagerZone;
        assertEquals(clusterState.metadata().coordinationMetadata().getVotingConfigExclusions().size(), 0);
        ensureStableCluster(6);
            .setWaitForEvents(Priority.LANGUID)
import org.opensearch.cluster.ClusterStateObserver;
            .setWaitForEvents(Priority.LANGUID)
            .setWeightedRouting(weightedRouting)
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
            .setWaitForEvents(Priority.LANGUID)
                .put("node.attr.zone", "c")
                        && event.getThrown().getClass() == RemoteTransportException.class
            Settings.builder()
                DecommissioningFailedException.class,
            List<Runnable> operationThreads = new ArrayList<>();
                .put(commonSettings)
        );
        DecommissionResponse decommissionResponse = client().execute(DecommissionAction.INSTANCE, decommissionRequest).get();
            null,
                    try {
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
                .build()
            .cluster()
            Settings.builder()
            .get();
        logger.info("--> setting shard routing weights for weighted round robin");
import org.opensearch.cluster.service.ClusterService;
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                .put("node.attr.zone", "e")
                .put("node.attr.zone", "a")
        assertTrue(deleteDecommissionStateResponse.isAcknowledged());
            .cluster()
        // and hence due to which the leader won't get abdicated and decommission request should eventually fail.
        ClusterStateObserver clusterStateObserver = new ClusterStateObserver(
            Settings.builder()
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionAction;
        }
            // decommission one zone where active cluster manager is not present
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
                .put("node.attr.zone", "b")
            Settings.builder()
            .setWaitForNodes(Integer.toString(6))
            );
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
        assertEquals(clusterState.nodes().getNodes().size(), 5);
            .build();
        // if the below condition is passed, then we are sure current decommission status is marked FAILED
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        ensureStableCluster(6);
            .setWeightedRouting(weightedRouting)
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                }
            .get();
                operationThreads.add(thread);
            .setWaitForNodes(Integer.toString(6))
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "c").build());
import org.opensearch.common.settings.Settings;
                .put("node.attr.zone", "b")
            .setWaitForGreenStatus()
        @Override
                @Override
                .put(commonSettings)
                .build(),
                }
                .put("node.attr.zone", "c")
                .build()
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        mockLogAppender.addExpectation(
            .build();
            clusterManagerTransportService,
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
            )
            .setWeightedRouting(weightedRouting)
        try {
        );
        zoneToNodesMap.put(
            assertEquals(
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        DecommissionAttributeMetadata metadata = decommissionedNodeClusterService.state()
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);
            DecommissioningFailedException ex = expectThrows(
                .put("node.attr.zone", "b")
            Settings.builder()
    private final Logger logger = LogManager.getLogger(AwarenessAttributeDecommissionIT.class);
                    decommissionRequest.setNoDelay(true);
            .prepareHealth()
        if (originalClusterManagerDecommission == false) {
            .cluster()
        // Set the timeout to 0 to do immediate Decommission
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        );
        // start 3 data nodes
        assertTrue(deleteDecommissionStateResponse.isAcknowledged());
    }
            if (clusterState.nodes().getNodes().size() != 6) return false;
            Settings.builder()
        logger.info("--> starting {} concurrent decommission action in zone {}", concurrentRuns, 'a');
import org.opensearch.common.unit.TimeValue;
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
        assertTrue(expectedStateLatch.await(30, TimeUnit.SECONDS));
                .put(commonSettings)
                .put("node.attr.zone", "a")
        countDownLatch.await();
            .execute()
        ClusterService leaderClusterService = internalCluster().getInstance(
                    return event.getThrown() != null
                break;
        Settings commonSettings = Settings.builder()
        );
            .execute()
            () -> expectThrows(
    }
        );
            "c",
            new DeleteDecommissionStateRequest()
        });
        // Start 3 cluster manager eligible nodes in zone a
                    throw new AssertionError("unexpected close");
                throw new IllegalStateException("unexpected zone decommissioned");
    }
            new MockLogAppender.SeenEventExpectation("test", JoinHelper.class.getCanonicalName(), Level.INFO, "failed to join") {
                .put("node.attr.zone", "a")
                .build()
                .put("node.attr.zone", "c")
            .build();
        Iterator<DiscoveryNode> discoveryNodeIterator = clusterState.nodes().getNodes().values().iterator();
        ).get();
        Settings commonSettings = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build();
        if (decommissionAttributeMetadata != null && decommissionAttributeMetadata.status().equals(DecommissionStatus.FAILED)) {
        assertFalse(activeNodeLocalHealth.isTimedOut());
        );
                .build()
        String activeNode = dataNodes.get(1);
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                            numRequestAcknowledged.incrementAndGet();
            TestThreadPool finalTestThreadPool = testThreadPool;
import java.util.concurrent.ExecutionException;
            .get();
        assertTrue(decommissionResponse.isAcknowledged());
            .setWeightedRouting(weightedRouting)
        ClusterState clusterState = client(dataNodes.get(0)).admin().cluster().prepareState().execute().actionGet().getState();
        ensureStableCluster(6);
        ensureStableCluster(expectedClusterSize, TimeValue.timeValueSeconds(121));
            // assert all the nodes has status as SUCCESSFUL
        );
        client(dataNodes.get(0)).admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();
            .execute()
        zoneToNodesMap.put(
            .get();
        logger.info("--> starting 1 nodes each on zones 'a' & 'b' & 'c'");
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                .setEnsureNodeWeighedIn(true)
            .build();
        assertTrue(weightedRoutingResponse.isAcknowledged());
            DecommissionStatus.IN_PROGRESS
            .cluster()
            .execute()
            .setWaitForGreenStatus()
            Settings.builder()
        switch (zoneToDecommission) {
        }
                DecommissioningFailedException.class,
 * The OpenSearch Contributors require contributions made to
            DecommissioningFailedException ex = expectThrows(
        assertTrue(ex.getMessage().contains("local node is decommissioned"));
            .prepareWeightedRouting()
        // as by then all nodes should have joined the cluster
                    DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "a");
import org.opensearch.cluster.decommission.DecommissionAttribute;
        deleteDecommissionStateAndWaitForStableCluster(dataNodes.get(0), 6);
        logger.info("--> starting decommissioning nodes in zone {}", zoneToDecommission);
        logger.info("--> starting data node each on zones 'a' & 'b' & 'c'");
                localNodeClusterService.state().metadata().decommissionAttributeMetadata().status(),
        }
        String currentClusterManager = internalCluster().getClusterManagerName(activeNode);
            Settings.builder()
                .put(commonSettings)
    public void testNodesRemovedAfterZoneDecommission_ClusterManagerNotInToBeDecommissionedZone() throws Exception {
                activeNode = randomFrom(randomFrom(zoneToNodesMap.get("a")), randomFrom(zoneToNodesMap.get("c")));
        String activeNode = randomFrom(dataNodes.get(0), dataNodes.get(1));
        String originalClusterManagerZone = clusterManagerNameToZone.get(originalClusterManager);
            .cluster()
            .setVersion(-1)
                if (action.equals(JoinHelper.JOIN_ACTION_NAME)) {
                break;
        // And in this case, to ensure decommission request doesn't leave mutating change in the cluster, we ensure
        ensureStableCluster(15);
        ensureStableCluster(6, TimeValue.timeValueMinutes(2));
        assertEquals(decommissionedNodeClusterService.localNode().getAttributes().get("zone"), "a");
            .setVersion(-1)
            .actionGet();
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        logger.info("--> Got cluster state with 4 nodes.");
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
        // Check cluster health API for decommissioned and active node
            GetDecommissionStateAction.INSTANCE,
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
            clusterStateObserver.waitForNextChange(new ClusterStateObserver.Listener() {
        assertFalse(health.isTimedOut());
                doneLatch.countDown();
        logger.info("--> Decommission status is successful");
        // Start 3 cluster manager eligible nodes
        }
                };
import org.opensearch.cluster.decommission.NodeDecommissionedException;
            activeNodeClusterService,
                .build(),
import org.opensearch.test.MockLogAppender;
            () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()
                .build(),
            .cluster()
                .put("node.attr.zone", "d")
import static org.opensearch.test.NodeRoles.onlyRole;
        clusterManagerNameToZone.put(clusterManagerNodes.get(1), "b");
            // assert no node has decommissioned attribute
            DeleteDecommissionStateAction.INSTANCE,
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateResponse;
import org.opensearch.transport.Transport;
import org.opensearch.OpenSearchTimeoutException;
            .prepareHealth()
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
            TransportService.class,
        ClusterState clusterState = client(activeNode).admin().cluster().prepareState().execute().actionGet().getState();
        Coordinator coordinator = (Coordinator) internalCluster().getInstance(Discovery.class, decommissionedNode);
            .prepareWeightedRouting()
        int concurrentRuns = randomIntBetween(5, 10);
                "local node is decommissioned \\[.*]\\. Will not be able to join the cluster"
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
        ensureStableCluster(6);
        assertBusy(() -> {
                .build()
                .put("node.attr.zone", "a")
import org.opensearch.cluster.decommission.DecommissioningFailedException;
        logger.info("--> setting shard routing weights for weighted round robin");
        if (expectedClusterStatePredicate.test(currentState)) {
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
                Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
                .put(commonSettings)
    @Override
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        List<String> clusterManagerNodes = internalCluster().startNodes(
                activeNode = randomFrom(randomFrom(zoneToNodesMap.get("a")), randomFrom(zoneToNodesMap.get("b")));
                .put(commonSettings)
            Settings.builder()
        Map<String, Double> weights = Map.of("a", 0.0, "b", 1.0, "c", 1.0);
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        ensureStableCluster(6);
        assertEquals(
        client(activeNode).admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateAction;
        internalCluster().startDataOnlyNodes(3, Settings.builder().put(commonSettings).build());
        ClusterHealthResponse health = client().admin()
            OpenSearchTimeoutException.class,
    public void cleanup() throws Exception {
        assertFalse(health.isTimedOut());
            Settings.builder()
        // Start 3 data nodes in zone b
                .put("node.attr.zone", "a")
        assertFalse(health.isTimedOut());
                DecommissioningFailedException.class,
        logger.info("--> Verified the decommissioned node has in_progress state.");
                .put("node.attr.zone", "b")
        );
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;
                clusterManagerNodeAfterDecommission = node;
            DiscoveryNode node = discoveryNodeIterator.next();
                        && event.getThrown().getCause() != null
        );
            Settings.builder()
            .execute()
            .setWaitForNodes(Integer.toString(6))
            Settings.builder()
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
/*
            expectedStateLatch.countDown();
        assertTrue(weightedRoutingResponse.isAcknowledged());
        List<String> zones = new ArrayList<>(Arrays.asList("a", "b", "c"));
            .put("cluster.routing.allocation.awareness.force.zone.values", "b") // force zone values is only set for zones of routing nodes
        assertTrue(weightedRoutingResponse.isAcknowledged());
                public void onTimeout(TimeValue timeout) {
        while (discoveryNodeIterator.hasNext()) {
        // start 3 data nodes
            assertTrue(coordinator.localNodeCommissioned());
import java.util.ArrayList;
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateAction;
                .setLocal(true)
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
import org.opensearch.cluster.routing.WeightedRouting;
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
            .metadata()
import org.opensearch.test.OpenSearchIntegTestCase;
        // Set the timeout to 0 to do immediate Decommission
            .setWaitForGreenStatus()
import java.util.function.Predicate;
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
                        numRequestFailed.incrementAndGet();
                .build(),
        ClusterHealthResponse health = client().admin()
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
                connection.sendRequest(requestId, action, request, options);
        DecommissionRequest decommissionRequest = new DecommissionRequest(new DecommissionAttribute("zone", "a"));
                .build(),
        // The decommissioned node would not be having status as SUCCESS as it was kicked out later
        logger.info("--> starting decommissioning nodes in zone {}", 'c');
            .setWeightedRouting(weightedRouting)
                () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()
                Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        mockLogAppender.assertAllExpectationsMatched();
        assertFalse(health.isTimedOut());
            assertTrue(ex.getMessage().contains("invalid awareness attribute requested for decommissioning"));
import org.opensearch.threadpool.TestThreadPool;
        logger.info("--> original cluster manager - name {}, zone {}", originalClusterManager, originalClusterManagerZone);
        // Start 3 cluster manager eligible nodes
    }
            internalCluster().startDataOnlyNodes(
                JoinHelper.class.getCanonicalName(),
            .prepareHealth()
        Settings commonSettings = Settings.builder()
    public void testDecommissionStatusUpdatePublishedToAllNodes() throws ExecutionException, InterruptedException {
        @Override
        DecommissionResponse decommissionResponse = client(activeNode).execute(DecommissionAction.INSTANCE, decommissionRequest).get();
        final String bZoneDataNode = internalCluster().startNodes(
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "a");
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            }
        // will wait for cluster to stabilise with a timeout of 2 min (findPeerInterval for decommissioned nodes)
                .put(commonSettings)
        ClusterHealthResponse decommissionedNodeLocalHealth = client(decommissionedNode).admin()
        // assert that decommission status is successful
            if (decommissionAttributeMetadata != null && decommissionAttributeMetadata.status().equals(DecommissionStatus.FAILED)) {
                .put(commonSettings)
            countDownLatch.await();
            .cluster()
        ClusterService decommissionedNodeClusterService = internalCluster().getInstance(ClusterService.class, randomDecommissionedNode);
        String node_in_c = internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "c").build());
                .put(commonSettings)
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
                .build()
        } else {
        // ensure all nodes are part of cluster
        assertTrue(decommissionResponse.isAcknowledged());
        InterruptedException {
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
            assertEquals(originalClusterManager, currentClusterManager);
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(weightedRoutingResponse.isAcknowledged());
        );
        public void onClusterServiceClose() {
            .setVersion(-1)
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
 */
                "test",
                .put("node.attr.zone", "a")
        );
            .prepareHealth()
        internalCluster().startNodes(
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            .setWaitForNodes(Integer.toString(6))
    }
        }
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            .setVersion(-1)
import org.opensearch.common.Priority;
            Settings.builder()
        };
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                .build(),
        // abdicate themselves as we wouldn't have any other leader eligible node which would be declare itself cluster manager
                .put(commonSettings)
                .put("node.attr.zone", "b")
            // assert that cluster manager didn't switch during test
            )
                .build()
        assertTrue(weightedRoutingResponse.isAcknowledged());
        DecommissionResponse decommissionResponse = client(dataNodes.get(0)).execute(DecommissionAction.INSTANCE, decommissionRequest)
                .put(commonSettings)
    }
        logger.info("--> starting decommissioning nodes in zone {}", 'a');
    }
        ClusterHealthResponse health = client().admin()
        });
                .prepareHealth()
            Settings.builder()
                .put(commonSettings)
            .actionGet();
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            .setWaitForEvents(Priority.LANGUID)
        logger.info("--> starting decommissioning nodes in zone {}", 'd');
        String originalClusterManager = internalCluster().getClusterManagerName();
                    throw new AssertionError("unexpected timeout");
        @Override
                () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()
        mockLogAppender.addExpectation(
        final CountDownLatch doneLatch;
        List<String> clusterManagerNodes = internalCluster().startNodes(
            .custom(DecommissionAttributeMetadata.TYPE);
            .actionGet();
        assertFalse(health.isTimedOut());
        GetDecommissionStateResponse response = client(activeNode).execute(
            .get();
        AtomicInteger numRequestFailed = new AtomicInteger();
            .setWaitForGreenStatus()
        }
                .build()
            .cluster()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        logger.info("--> setting shard routing weights for weighted round robin");
        WaitForClearVotingConfigExclusion(CountDownLatch latch) {
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
        logger.info("--> Received LANGUID event");
}
        // Recommissioning the zone back to gracefully succeed the test once above tests succeeds
            DeleteDecommissionStateAction.INSTANCE,
        @Override
            .actionGet();
                .execute()
    public void testDecommissionFailedWhenDifferentAttributeAlreadyDecommissioned() throws Exception {
        assertFalse(coordinator.localNodeCommissioned());
