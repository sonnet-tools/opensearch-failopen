        CountDownLatch expectedStateLatch = new CountDownLatch(1);  
        client(activeNode).admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();
        public void onTimeout(TimeValue timeout) {
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
                .build()
        );  
        assertNoTimeout(client().admin().cluster().prepareHealth().get());
        zoneToNodesMap.put(  
        Settings commonSettings = Settings.builder()  
                }  
            .get();
        Map<String, Double> weights = new HashMap<>(Map.of("a", 1.0, "b", 1.0, "c", 1.0));
            }
            Settings.builder()
        TransportService clusterManagerTransportService = internalCluster().getInstance(
        assertEquals(response.getAttributeValue(), decommissionAttribute.attributeValue());
            Settings.builder()
        );
        logger.info("--> setting shard routing weights for weighted round robin");
import org.opensearch.OpenSearchTimeoutException;
            .cluster()
            Settings.builder()  
    }
        );  
            () -> expectThrows(
        DecommissionResponse decommissionResponse = client(dataNodes.get(0)).execute(DecommissionAction.INSTANCE, decommissionRequest)
            if (decommissionAttributeMetadata != null && decommissionAttributeMetadata.status().equals(DecommissionStatus.FAILED)) {
        client(activeNodeName).admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();  
        logger.info("--> starting decommissioning nodes in zone {}", 'a');
        internalCluster().startDataOnlyNodes(3, Settings.builder().put(commonSettings).build());
            );
        clusterManagerNameToZone.put(clusterManagerNodes.get(1), "b");
                DecommissioningFailedException.class,
            .cluster()
        Map<String, List<String>> zoneToNodesMap = new HashMap<>();  
        int dataNodeCountPerAZ = 4;
                    return event.getThrown() != null
            logger.info("decommission status has already turned false");  
        if (originalClusterManagerDecommission == false) {  
            .build();
        assertTrue(decommissionResponse.isAcknowledged());  
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionAction;  
            DeleteDecommissionStateAction.INSTANCE,
        // Set the timeout to 0 to do immediate Decommission  
        ClusterHealthResponse health = client().admin()
                () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()  
                .build(),
        assertEquals(4, clusterState.nodes().getSize());  
        switch (zoneToDecommission) {
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
                .execute()
        List<String> zones = new ArrayList<>(Arrays.asList("a", "b", "c"));  
                .build(),
                .put(commonSettings)
        ClusterState clusterState = client(dataNodes.get(0)).admin().cluster().prepareState().execute().actionGet().getState();
        assertFalse(coordinator.localNodeCommissioned());
            }  
                DecommissionStatus.SUCCESSFUL
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "c").build());  
            .build();
        decommissionedNodeTransportService.addSendBehavior(
            .cluster()  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))  
        }
        assertEquals(clusterState.metadata().coordinationMetadata().getVotingConfigExclusions().size(), 0);
        internalCluster().startDataOnlyNodes(3, Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-1");
    }
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);  
            .get();  
            assertTrue(ex.getMessage().contains("doesn't have the decommissioning attribute"));
        assertNodesRemovedAfterZoneDecommission(true);
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
        zoneToNodesMap.put(
            Settings.builder()
            .setWaitForEvents(Priority.LANGUID)  
        assertTrue(deleteDecommissionStateResponse.isAcknowledged());  
        InterruptedException {
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            decommissionedNode
    }
        if (currentState.getVotingConfigExclusions().isEmpty()) {
            .custom(DecommissionAttributeMetadata.TYPE);
        logger.info("--> setting shard routing weights for weighted round robin");  
            .execute()  
        }
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
                .put(commonSettings)  
            .setWaitForEvents(Priority.LANGUID)  
            .setWaitForGreenStatus()
                @Override
        // assert that decommission status is successful
                @Override
        deleteDecommissionStateAndWaitForStableCluster(currentClusterManager, 15);
                .put("node.attr.zone", "a")
                .put(commonSettings)
    private static class WaitForClearVotingConfigExclusion implements ClusterStateObserver.Listener {  
        ensureStableCluster(6);
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "c");
        // and not receiving any further state updates
                .build()  
                .put("node.attr.zone", "b")  
        assertTrue(ex.getMessage().contains("while removing to-be-decommissioned cluster manager eligible nodes"));
            .cluster()  
import org.opensearch.test.OpenSearchIntegTestCase;
                .put(commonSettings)
            OpenSearchTimeoutException.class,
            .cluster()
        public void onNewClusterState(ClusterState state) {  
        weights.put(zoneToDecommission, 0.0);  
                .put(commonSettings)
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));
                .setEnsureNodeWeighedIn(true)
        String node_in_c = internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "c").build());
        logger.info("--> Deleting decommission done.");
            .cluster()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            }  
            logger.info("cluster restored");
                .put(commonSettings)
        GetDecommissionStateResponse response = client(activeNode).execute(
            client(activeNode).threadPool().getThreadContext()
import org.apache.logging.log4j.Level;
                () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()
                break;
        }
            .setWeightedRouting(weightedRouting)  
        logger.info("--> setting shard routing weights for weighted round robin");
        assertTrue(weightedRoutingResponse.isAcknowledged());
            .setWaitForNodes(Integer.toString(15))
            .prepareHealth()
        deleteDecommissionStateAndWaitForStableCluster(dataNodes.get(0), 6);
                .put(commonSettings)  
        );
        );
                .put(commonSettings)
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");  
            assertEquals(  
        }  
            .cluster()  
}
            activeNodeClusterService,
                            numRequestUnAcknowledged.incrementAndGet();  
            ClusterService.class,
            .build();
            DecommissioningFailedException ex = expectThrows(  
        );
        public void onClusterServiceClose() {
                    logger.info("cluster restored");
                .build(),  
            .build();  
            DecommissionAttributeMetadata decommissionAttributeMetadata = state.metadata().decommissionAttributeMetadata();
                    decommissionRequest.setNoDelay(true);
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
        );
            clusterStateObserver.waitForNextChange(new ClusterStateObserver.Listener() {
                .put(commonSettings)  
        ClusterHealthResponse decommissionedNodeLocalHealth = client(decommissionedNode).admin()
                .build(),
        // assert that number of nodes should be 5 ( 2 cluster manager nodes + 3 data nodes )  
        while (discoveryNodeIterator.hasNext()) {  
        assertNotNull("Cluster Manager not found after decommission", clusterManagerNodeAfterDecommission);
        );
        assertFalse(decommissionedNodeLocalHealth.isTimedOut());
        try {
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "a");  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
        deleteDecommissionStateAndWaitForStableCluster(node_in_c, 6);
        assertEquals(clusterState.nodes().getNodes().size(), 10);
            .setVersion(-1)  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")  
        assertNotNull(currentClusterManager);
            List<Runnable> operationThreads = new ArrayList<>();
                .put(commonSettings)  
        // Recommissioning the zone back to gracefully succeed the test once above tests succeeds
    }  
                .build(),
            .setVersion(-1)
            .actionGet();
                .put("node.attr.zone", "a")
            .setWaitForNodes(Integer.toString(6))
            }  
        // decommissioned node should have Coordinator#localNodeCommissioned = false  
                .build(),  
        assertBusy(
            .setWaitForGreenStatus()
        TestThreadPool testThreadPool = null;  
            assertEquals(originalClusterManager, currentClusterManager);
                .put("node.attr.zone", "b")
import org.opensearch.cluster.decommission.DecommissioningFailedException;
        Iterator<DiscoveryNode> discoveryNodeIterator = clusterState.nodes().getNodes().values().iterator();
        DecommissionResponse decommissionResponse = client().execute(DecommissionAction.INSTANCE, decommissionRequest).get();
                .put(commonSettings)
            .prepareHealth()  
                        } else {
        Settings commonSettings = Settings.builder()  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
        assertNotNull(metadata.status());
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            .execute()  
import org.opensearch.cluster.node.DiscoveryNodeRole;
            decommissionedNodeClusterService.state().metadata().decommissionAttributeMetadata().status(),  
                        && event.getThrown().getClass() == RemoteTransportException.class
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        }  
                    }
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 1.0);
                .setLocal(true)  
            .setWaitForGreenStatus()
        internalCluster().startClusterManagerOnlyNodes(3, Settings.builder().put(commonSettings).build());
            );  
        );
        @Override
        decommissionRequest.setNoDelay(true);
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        Map<String, Double> weights = Map.of("a", 0.0, "b", 1.0, "c", 1.0);
        public void onTimeout(TimeValue timeout) {  
            .execute()
            .cluster()
        client(activeNode).admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();
        DecommissionRequest decommissionRequest = new DecommissionRequest(new DecommissionAttribute("zone", "a"));
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
        MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(clusterLogger);  
            .get();
        }  
            .prepareWeightedRouting()  
            }
        DecommissionResponse decommissionResponse = client().execute(DecommissionAction.INSTANCE, decommissionRequest).get();
            logger.info("exclusion already cleared");  
        String currentClusterManager = internalCluster().getClusterManagerName(activeNode);  
    public void testNodesRemovedAfterZoneDecommission_ClusterManagerNotInToBeDecommissionedZone() throws Exception {
        );
            new GetDecommissionStateRequest(decommissionAttribute.attributeName())
            Settings.builder()  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
    public void testDecommissionFailedWhenDifferentAttributeAlreadyDecommissioned() throws Exception {
package org.opensearch.cluster.coordination;
                .put("node.attr.zone", "a")
            Settings.builder()
        // Start 3 cluster manager eligible nodes
                .put("node.attr.zone", "a")
        assertFalse(health.isTimedOut());
        deleteDecommissionStateAndWaitForStableCluster(bZoneDataNode, 6);
import org.opensearch.test.transport.MockTransportService;
        // Will wait for all events to complete  
                    try {  
    }
                .build(),
        ).get();  
            Settings.builder()
        );
        assertTrue(expectedStateLatch.await(180, TimeUnit.SECONDS));
            .get();
        assertTrue(weightedRoutingResponse.isAcknowledged());  
            .prepareHealth()
            Settings.builder()
            // assert no node has decommissioned attribute
                .put(commonSettings)
                .build()  
                ex.getMessage()
        // prepare request to attempt to decommission zone 'a'
        ClusterService decommissionedNodeClusterService = internalCluster().getInstance(ClusterService.class, randomDecommissionedNode);
        final CountDownLatch doneLatch;
        ClusterService leaderClusterService = internalCluster().getInstance(
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            .build();
        ClusterState currentState = activeNodeClusterService.state();
                .build()
                            numRequestAcknowledged.incrementAndGet();
        final CountDownLatch doneLatch;
        NodeDecommissionedException ex = expectThrows(
    public void testDecommissionFailedWhenAttributeNotWeighedAway() throws Exception {
        assertTrue(expectedStateLatch.await(30, TimeUnit.SECONDS));
        decommissionedNodeTransportService.addConnectBehavior(clusterManagerTransportService, Transport::openConnection);
            .actionGet();
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
        @Override  
                .put("node.attr.zone", "a")  
        decommissionRequest.setNoDelay(true);  
    public void testDecommissionFailedWhenNotForceZoneAware() throws Exception {  
        Map<String, Double> weights = Map.of("a", 0.0, "b", 1.0, "c", 1.0);  
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
            NodeDecommissionedException.class,
                .put("node.attr.zone", "c")
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
        }
        // as by then all nodes should have joined the cluster
                JoinHelper.class.getCanonicalName(),
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
        assertTrue(weightedRoutingResponse.isAcknowledged());
            new GetDecommissionStateRequest(decommissionAttribute.attributeName())
        });  
            DeleteDecommissionStateAction.INSTANCE,  
            Settings.builder()
        logger.info("--> Got cluster state with 4 nodes.");
            .cluster()
        assertEquals(DecommissionStatus.SUCCESSFUL, response.getDecommissionStatus());
        internalCluster().startDataOnlyNodes(3, Settings.builder().put(commonSettings).build());
                .put(commonSettings)  
        // assert that decommission status is successful
            .cluster()
    }  
            .setWaitForEvents(Priority.LANGUID)
            .setWeightedRouting(weightedRouting)
import java.util.ArrayList;
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            )
        }  
        List<String> clusterManagerNodes = internalCluster().startNodes(
        assertFalse(activeNodeLocalHealth.isTimedOut());  
import org.apache.logging.log4j.LogManager;
        assertEquals(concurrentRuns - 1, numRequestFailed.get());
                .put("node.attr.zone", "c")
 * this file be licensed under the Apache-2.0 license or a
        assertBusy(() -> {
            internalCluster().startDataOnlyNodes(
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
            .setWaitForEvents(Priority.LANGUID)  
        countDownLatch.await();  
        Settings commonSettings = Settings.builder()
            internalCluster().getClusterManagerName(activeNode)
import org.opensearch.test.MockLogAppender;  
import java.util.concurrent.ExecutionException;
                .put(commonSettings)  
import java.util.Map;
            .setWaitForEvents(Priority.LANGUID)
        assertTrue(ex.getMessage().contains("local node is decommissioned"));
            () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()  
        DecommissionResponse decommissionResponse = client(activeNode).execute(DecommissionAction.INSTANCE, decommissionRequest).get();  
        ).get();  
        List<String> dataNodes = internalCluster().startNodes(  
        assertTrue(decommissionResponse.isAcknowledged());
            GetDecommissionStateAction.INSTANCE,
                break;
        // will wait for cluster to stabilise with a timeout of 2 min as by then all nodes should have joined the cluster  
            .setWaitForNodes(Integer.toString(6))
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
        mockLogAppender.addExpectation(
            Settings.builder()
        ClusterHealthResponse health = client().admin()
        // will wait for cluster to stabilise with a timeout of 2 min (findPeerInterval for decommissioned nodes)
                .build()
        ).get();
                "local node is decommissioned \\[.*]\\. Will not be able to join the cluster"  
                        numRequestFailed.incrementAndGet();  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            // assert no node is decommissioned from Coordinator#localNodeCommissioned
                .put("node.attr.zone", "a")  
            this.doneLatch = latch;
        Settings commonSettings = Settings.builder().build();  
        logger.info("--> setting shard routing weights for weighted round robin");  
        public void onClusterServiceClose() {
            internalCluster().startDataOnlyNodes(
        assertEquals(1, numRequestAcknowledged.get() + numRequestUnAcknowledged.get());
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
        assertTrue(decommissionResponse.isAcknowledged());  
        ClusterHealthResponse activeNodeLocalHealth = client(activeNode).admin()
            .setLocal(true)
        } else {
        ClusterState currentState = internalCluster().clusterService().state();
        DecommissionRequest newDecommissionRequest = new DecommissionRequest(new DecommissionAttribute("zone", "b"));  
        ensureStableCluster(6);
            );  
                .build(),
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
        DiscoveryNode clusterManagerNodeAfterDecommission = null;
            Settings.builder()  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            new DeleteDecommissionStateRequest()
        // and won't receive status update to SUCCESSFUL
            (connection, requestId, action, request, options) -> {
                .put("node.attr.zone", "a")  
            .actionGet();
                .build()
        Logger clusterLogger = LogManager.getLogger(JoinHelper.class);
                () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()
        assertEquals(clusterState.nodes().getClusterManagerNodes().size(), 2);  
                .build(),  
                .put(commonSettings)
import org.opensearch.plugins.Plugin;
    }
            .build();  
                .put("node.attr.zone", "c")  
            .prepareHealth()  
            throw new AssertionError("unexpected close");
        );  
            .execute()  
                connection.sendRequest(requestId, action, request, options);
        }
                .put("node.attr.zone", "b")
                    throw new AssertionError("unexpected timeout");  
        Coordinator coordinator = (Coordinator) internalCluster().getInstance(Discovery.class, decommissionedNode);
        logger.info("--> starting {} concurrent decommission action in zone {}", concurrentRuns, 'a');
 *
                .put("node.attr.zone", "f")  
        Map<String, Double> weights = Map.of("a", 0.0, "b", 1.0, "c", 1.0);
            internalCluster().startDataOnlyNodes(  
                    expectedStateLatch.countDown();
                        if (decommissionResponse.isAcknowledged()) {  
            assertNotEquals(originalClusterManager, currentClusterManager);
                .put(commonSettings)
        logger.info("--> setting shard routing weights for weighted round robin");
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))  
                @Override
                .put("node.attr.zone", "b")
            Settings.builder()
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
            )
            }, expectedClusterStatePredicate);
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .setWaitForNodes(Integer.toString(6))
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateAction;  
        List<String> dataNodes = internalCluster().startNodes(
            Coordinator coordinator = (Coordinator) internalCluster().getInstance(Discovery.class, node.getName());  
        }
            .execute()
        // start 3 data nodes  
import org.opensearch.cluster.ClusterStateObserver;  
            leaderClusterService,  
    }  
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "c");
                dataNodeCountPerAZ,
        OpenSearchTimeoutException ex = expectThrows(
                doneLatch.countDown();
            .execute()
        DeleteDecommissionStateResponse deleteDecommissionStateResponse = client(activeNode).execute(
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");  
import org.opensearch.common.Priority;
    }  
                .put(commonSettings)  
                .put(commonSettings)  
        } else {
            // assert that cluster manager switched during the test  
        // assert exception on decommissioned node
            Settings.builder()  
        ensureStableCluster(6);
        // Here we will verify that until it got kicked out, it received appropriate status updates  
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
        ensureStableCluster(6);
            DecommissioningFailedException ex = expectThrows(
 */  
            if (clusterState.nodes().getNodes().size() != 6) return false;
        deleteDecommissionStateAndWaitForStableCluster(activeNode, 6);
            logger,  
                .put("node.attr.zone", "b")
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateResponse;
                .cluster()
        );
            for (int i = 0; i < concurrentRuns; i++) {  
                        && event.getThrown().getCause().getClass() == NodeDecommissionedException.class;
    }
        if (decommissionAttributeMetadata != null && decommissionAttributeMetadata.status().equals(DecommissionStatus.FAILED)) {
        assertEquals(clusterState.nodes().getDataNodes().size(), 3);
                Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()  
            .get();
            .setWaitForNodes(Integer.toString(6))  
            Settings.builder()
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        assertFalse(health.isTimedOut());  
                    logger.info("Triggering decommission action");
        WaitForFailedDecommissionState(CountDownLatch latch) {
            Settings.builder()  
            }  
        ensureStableCluster(6);  
            .get();
                Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            if (state.getVotingConfigExclusions().isEmpty()) {
            Settings.builder()  
            DecommissioningFailedException ex = expectThrows(
        // Start 3 cluster manager eligible nodes in zone a
            .setWeightedRouting(weightedRouting)
    public void testDecommissionStatusUpdatePublishedToAllNodes() throws ExecutionException, InterruptedException {
                .build()  
import org.opensearch.transport.RemoteTransportException;
        ClusterHealthResponse health = client().admin()  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                .put(commonSettings)
            .execute()  
        // Check cluster health API for decommissioned and active node
                DecommissioningFailedException.class,
import org.opensearch.transport.TransportService;
        // abdicate themselves as we wouldn't have any other leader eligible node which would be declare itself cluster manager  
            // decommission one zone where active cluster manager is not present
        logger.info("--> setting shard routing weights for weighted round robin");
                    DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
            .setWaitForNodes(Integer.toString(6))
    }
            new MockLogAppender.PatternSeenEventExpectation(
            countDownLatch.await();
        expectedStateLatch = new CountDownLatch(1);
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                activeNode = randomFrom(randomFrom(zoneToNodesMap.get("b")), randomFrom(zoneToNodesMap.get("c")));  
        } else {  
import org.opensearch.discovery.Discovery;
                .put("node.attr.zone", "b")  
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
        return Collections.singletonList(MockTransportService.TestPlugin.class);  
                .put("node.attr.zone", "d")
        List<String> clusterManagerNodes = internalCluster().startNodes(
            .prepareWeightedRouting()
        // assert status on decommissioned node
            .setWaitForGreenStatus()
            );
import org.opensearch.cluster.decommission.DecommissionStatus;  
        } else {
        internalCluster().startNodes(
        internalCluster().startNodes(  
            .cluster()
        decommissionRequest.setNoDelay(true);
                .build(),
    }  
            .setLocal(true)
        }  
    private final Logger logger = LogManager.getLogger(AwarenessAttributeDecommissionIT.class);
    @After  
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()  
            // assert all the nodes has status as SUCCESSFUL
                .put("node.attr.zone", "a")
            .setVersion(-1)
        Settings commonSettings = Settings.builder()
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
                Runnable thread = () -> {
            .prepareHealth()
    public void testConcurrentDecommissionAction() throws Exception {
            .setWaitForGreenStatus()  
        assertBusy(() -> {  
                .build(),  
            .setWeightedRouting(weightedRouting)
                .build()
        String originalClusterManagerZone = clusterManagerNameToZone.get(originalClusterManager);
            Settings.builder()  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        assertTrue(decommissionResponse.isAcknowledged());
                .build(),  
            .setWaitForNodes(Integer.toString(6))
                DecommissioningFailedException.class,  
            .prepareWeightedRouting()
        logger.info("--> setting shard routing weights for weighted round robin");  
            Settings.builder()
            .cluster()
        assertEquals(metadata.status(), DecommissionStatus.IN_PROGRESS);
        }
            .prepareWeightedRouting()
            .build();
                        }
        logger.info("--> starting decommissioning nodes in zone {}", 'a');
        );  
                .put(commonSettings)  
            // assert no node has decommissioned attribute
        String activeNode = dataNodes.get(1);  
            expectedStateLatch.countDown();
            Settings.builder()
                        && event.getThrown().getCause() != null  
        });
            Settings.builder()
                .put("node.attr.zone", "b")  
        assertBusy(() -> {  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
                .put(commonSettings)
        assertFalse(health.isTimedOut());
                .put(commonSettings)
        assertEquals(clusterState.nodes().getNodes().size(), 5);
                Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        assertTrue(weightedRoutingResponse.isAcknowledged());
        internalCluster().startClusterManagerOnlyNodes(3, Settings.builder().put(commonSettings).build());
        while (discoveryNodeIterator.hasNext()) {  
        ClusterService decommissionedNodeClusterService = internalCluster().getInstance(ClusterService.class, decommissionedNode);
    }
            .setVersion(-1)  
        // Start 3 cluster manager eligible nodes
    }
                .put("node.attr.zone", "a")  
                public boolean innerMatch(LogEvent event) {  
    public void testNodesRemovedAfterZoneDecommission_ClusterManagerInToBeDecommissionedZone() throws Exception {  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
            case "a":
            case "c":
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
        // decommissioned nodes hence will have status as IN_PROGRESS as it will be kicked out later after this
import java.util.concurrent.TimeUnit;
        ensureStableCluster(6);
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
        assertFalse(health.isTimedOut());
import org.opensearch.cluster.ClusterState;
            .actionGet();  
            .prepareWeightedRouting()
        logger.info("--> starting decommissioning nodes in zone {}", 'd');
                .put(commonSettings)
        assertFalse(health.isTimedOut());
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
        List<String> clusterManagerNodes = internalCluster().startNodes(  
            internalCluster().getClusterManagerName()  
        AtomicInteger numRequestAcknowledged = new AtomicInteger();
            .prepareHealth()
            if (clusterState.metadata().coordinationMetadata().getVotingConfigExclusions().isEmpty() == false) return false;  
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                operationThreads.add(thread);
import org.apache.logging.log4j.core.LogEvent;
        internalCluster().startClusterManagerOnlyNodes(3, Settings.builder().put(commonSettings).put("node.attr.zone", "a").build());  
                            .get();
            .setWeightedRouting(weightedRouting)  
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
            Settings.builder()  
            .setVersion(-1)
        // assert that number of nodes should be 10 ( 2 cluster manager nodes + 8 data nodes )  
                .build()
        assertFalse(health.isTimedOut());  
        List<String> dataNodes = internalCluster().startNodes(
import org.junit.After;
    public void testDecommissionFailedWithOnlyOneAttributeValueForLeader() throws Exception {  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        assertTrue(deleteDecommissionStateResponse.isAcknowledged());
        assertBusy(() -> {
            .build();  
            testThreadPool = new TestThreadPool(AwarenessAttributeDecommissionIT.class.getName());  
            .setWeightedRouting(weightedRouting)  
        // if the below condition is passed, then we are sure current decommission status is marked FAILED  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        assertTrue(expectedStateLatch.await(30, TimeUnit.SECONDS));  
        decommissionRequest.setNoDelay(true);
                .put(commonSettings)
            .prepareWeightedRouting()
            .execute()
        );
        if (originalClusterManagerDecommission) {
        DecommissionAttributeMetadata metadata = decommissionedNodeClusterService.state()  
        internalCluster().startNodes(
            DecommissioningFailedException ex = expectThrows(
            );
        assertFalse(health.isTimedOut());
            .get();
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            clusterStateObserver.waitForNextChange(new WaitForClearVotingConfigExclusion(expectedStateLatch));  
                        DecommissionResponse decommissionResponse = client().execute(DecommissionAction.INSTANCE, decommissionRequest)
            throw new AssertionError("unexpected timeout");
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());  
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
            assertTrue(ex.getMessage().contains("invalid awareness attribute requested for decommissioning"));
        Settings commonSettings = Settings.builder()  
                public void onTimeout(TimeValue timeout) {
        MockTransportService decommissionedNodeTransportService = (MockTransportService) internalCluster().getInstance(  
            .actionGet();
            )
        ClusterState clusterState = client(activeNode).admin().cluster().prepareState().execute().actionGet().getState();
        ClusterService activeNodeClusterService = internalCluster().getInstance(ClusterService.class, activeNode);
            .cluster()  
        assertNodesRemovedAfterZoneDecommission(false);  
                .put("node.attr.zone", "b")
    private static class WaitForFailedDecommissionState implements ClusterStateObserver.Listener {  
                .put("node.attr.zone", "a")
            assertNotEquals(node.getAttributes().get("zone"), "c");  
            TransportService.class,  
                .build(),
            .actionGet();
                .build(),
                .build()
                    DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "a");  
import java.util.Collection;  
            Settings.builder()
        });
            .setWaitForEvents(Priority.LANGUID)  
        logger.info("--> Verified the decommissioned node has in_progress state.");  
        currentState = internalCluster().clusterService().state();  
            assertNotEquals(node.getAttributes().get("zone"), zoneToDecommission);  
            .setWaitForGreenStatus()  
            .setWaitForEvents(Priority.LANGUID)
                "test",  
        ensureStableCluster(expectedClusterSize, TimeValue.timeValueSeconds(121));  
                .put("node.attr.zone", "c")
        // This also helps to test metadata status updates was received by this node until it got kicked by the leader
        final String bZoneDataNode = internalCluster().startNodes(  
    private void assertNodesRemovedAfterZoneDecommission(boolean originalClusterManagerDecommission) throws Exception {
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        decommissionRequest.setNoDelay(true);  
        logger.info("--> start 3 cluster manager nodes on zones 'd' & 'e' & 'f'");
        @Override
        assertTrue(weightedRoutingResponse.isAcknowledged());
                .put(commonSettings)
            () -> client(decommissionedNode).admin()  
            .setWaitForGreenStatus()
        Map<String, Double> weights = Map.of("b", 1.0); // weights are expected to be set only for routing nodes  
            .prepareHealth()
        String decommissionedNode = randomFrom(clusterManagerNodes.get(0), dataNodes.get(0));
        int concurrentRuns = randomIntBetween(5, 10);
            .cluster()  
            TransportService.class,
                .actionGet()  
import java.util.concurrent.CountDownLatch;  
        ClusterHealthResponse health = client().admin()  
    }
        ).get();
            .setVersion(-1)  
        GetDecommissionStateResponse response = client(activeNode).execute(  
import java.util.concurrent.atomic.AtomicInteger;  
            .put("cluster.routing.allocation.awareness.force.zone.values", "b") // force zone values is only set for zones of routing nodes  
import org.opensearch.cluster.node.DiscoveryNode;  
        mockLogAppender.addExpectation(  
            null,
                dataNodeCountPerAZ,
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();  
        decommissionRequest.setNoDelay(true);
            );  
        }
        );
            .prepareWeightedRouting()  
        CountDownLatch expectedStateLatch = new CountDownLatch(1);
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()  
            Settings.builder()
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
            .prepareHealth()
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");  
                .put("node.attr.zone", "e")
        ClusterHealthResponse health = client().admin()  
    public void testDecommissionFailedWhenNotZoneAware() throws Exception {
            .metadata()
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()  
            .cluster()  
                .build(),
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            Settings.builder()
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateAction;  
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
        public void onNewClusterState(ClusterState state) {  
            Settings.builder()  
        // and hence due to which the leader won't get abdicated and decommission request should eventually fail.
    @Override
            DiscoveryNode node = discoveryNodeIterator.next();
            .actionGet();
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;
                    } catch (Exception e) {
import org.opensearch.threadpool.ThreadPool;
            .actionGet();  
        Settings commonSettings = Settings.builder()
                .build(),
        String zoneToDecommission = originalClusterManagerZone;
            assertTrue(ex.getMessage().contains("weight for decommissioned attribute is expected to be [0.0] but found [1.0]"));
        ClusterHealthResponse health = client().admin()  
        }
        ensureStableCluster(6);
        WaitForClearVotingConfigExclusion(CountDownLatch latch) {
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                public void onClusterServiceClose() {  
                .build(),
import java.util.function.Predicate;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        // although all the nodes would be added to voting config exclusion list, but those nodes won't be able to
                activeNode = randomFrom(randomFrom(zoneToNodesMap.get("a")), randomFrom(zoneToNodesMap.get("c")));  
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "a");  
            )  
        assertEquals(decommissionedNodeClusterService.localNode().getAttributes().get("zone"), "a");
 * The OpenSearch Contributors require contributions made to  
        assertTrue(weightedRoutingResponse.isAcknowledged());  
        }
                @Override
                activeNode = randomFrom(randomFrom(zoneToNodesMap.get("a")), randomFrom(zoneToNodesMap.get("b")));  
        );
        ensureStableCluster(6);  
                DecommissioningFailedException.class,  
        assertEquals(concurrentRuns, numRequestAcknowledged.get() + numRequestUnAcknowledged.get() + numRequestFailed.get());  
        zoneToNodesMap.put(
                break;
        // Recommissioning the zone back to gracefully succeed the test once above tests succeeds
        @Override
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        assertTrue(weightedRoutingResponse.isAcknowledged());  
            default:
                .put("node.attr.zone", "b")
        // that no exclusion is set to the cluster and state for decommission is marked as FAILED  
        assertEquals(
 * compatible open source license.
            .cluster()
import java.util.List;
            client(internalCluster().getClusterManagerName()).threadPool().getThreadContext()  
    public void testInvariantsAndLogsOnDecommissionedNodes() throws Exception {
        Settings commonSettings = Settings.builder()
            DiscoveryNode node = discoveryNodeIterator.next();
import org.opensearch.transport.Transport;  
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "a").build());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
                if (action.equals(JoinHelper.JOIN_ACTION_NAME)) {
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", zoneToDecommission);
        logger.info("--> starting 1 nodes each on zones 'a' & 'b' & 'c'");
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))  
        // Will wait for all events to complete
            .get();  
        Map<String, String> clusterManagerNameToZone = new HashMap<>();  
import org.opensearch.common.unit.TimeValue;  
                .put(commonSettings)
        DecommissionAttributeMetadata decommissionAttributeMetadata = currentState.metadata().decommissionAttributeMetadata();
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            )
import org.opensearch.cluster.service.ClusterService;  
        clusterManagerNameToZone.put(clusterManagerNodes.get(0), "a");
        logger.info("--> Received LANGUID event");  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            expectedStateLatch.countDown();
        };  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
        );  
                .prepareHealth()
                public void onNewClusterState(ClusterState state) {  
    private void deleteDecommissionStateAndWaitForStableCluster(String activeNodeName, int expectedClusterSize) throws ExecutionException,
        );
                .build(),
        ClusterState clusterState = client(activeNode).admin().cluster().prepareState().execute().actionGet().getState();
            ClusterService localNodeClusterService = internalCluster().getInstance(ClusterService.class, node.getName());
            GetDecommissionStateAction.INSTANCE,  
            if (node.isClusterManagerNode()) {
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            null,
            if (clusterState.metadata().decommissionAttributeMetadata() != null) return false;
        ensureStableCluster(15);
                () -> client(node_in_c).execute(DecommissionAction.INSTANCE, newDecommissionRequest).actionGet()
        } finally {  
                .put(commonSettings)  
        logger.info("--> starting decommissioning nodes in zone {}", 'c');  
                .put("node.attr.zone", "c")
import org.opensearch.cluster.decommission.DecommissionAttribute;
import java.util.HashMap;
        logger.info("--> original cluster manager - name {}, zone {}", originalClusterManager, originalClusterManagerZone);
            .execute()
            .prepareHealth()
        client(dataNodes.get(0)).admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();
            .get();
        }
                .put("node.attr.zone", "c")
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
public class AwarenessAttributeDecommissionIT extends OpenSearchIntegTestCase {
        );
            Settings.builder()  
            assertTrue(  
                }
        );  
        // since there is just one zone present in the cluster, and on initiating decommission for that zone,
            List<String> tempZones = new ArrayList<>(zones);
            Settings.builder()
                .put(commonSettings)
            .actionGet();
                .put(commonSettings)
                .put("node.attr.zone", "b")
            assertTrue(coordinator.localNodeCommissioned());
    public void cleanup() throws Exception {
                    countDownLatch.countDown();  
        );
        assertTrue(decommissionResponse.isAcknowledged());  
        ClusterStateObserver clusterStateObserver = new ClusterStateObserver(  
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
                doneLatch.countDown();  
                .build(),  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        ClusterStateObserver clusterStateObserver = new ClusterStateObserver(
                .build(),
        // ensure all nodes are part of cluster  
        // if the below condition is passed, then we are sure that config size is restored
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequest;
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
                .build(),  
            Settings.builder()  
                    throw new AssertionError("unexpected close");
        ensureStableCluster(6);  
            .setEnsureNodeWeighedIn(true)  
                localNodeClusterService.state().metadata().decommissionAttributeMetadata().status(),
                }
    }  
        // And in this case, to ensure decommission request doesn't leave mutating change in the cluster, we ensure
        Iterator<DiscoveryNode> discoveryNodeIterator = clusterState.nodes().getNodes().values().iterator();
        // assert status on nodes that are part of cluster currently  
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
                DecommissioningFailedException.class,
                dataNodeCountPerAZ,  
            .setVersion(-1)
        ensureStableCluster(6, TimeValue.timeValueMinutes(2));
                .put("node.attr.zone", "c")  
import org.opensearch.threadpool.TestThreadPool;  
                    countDownLatch.countDown();
        logger.info("--> Cluster Manager node found after decommission");  
import java.util.Collections;
        ClusterHealthResponse health = client().admin()
        mockLogAppender.assertAllExpectationsMatched();
                .put(commonSettings)
            "b",  
        // assert that no node present in Voting Config Exclusion  
            clusterStateObserver.waitForNextChange(new WaitForFailedDecommissionState(expectedStateLatch));  
        @Override
        DeleteDecommissionStateResponse deleteDecommissionStateResponse = client(activeNodeName).execute(  
                };  
            Settings.builder()
                .put(commonSettings)  
            clusterManagerTransportService,  
            new MockLogAppender.SeenEventExpectation("test", JoinHelper.class.getCanonicalName(), Level.INFO, "failed to join") {
        logger.info("--> starting decommissioning nodes in zone {}", zoneToDecommission);
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))  
        // start 3 data nodes  
                }
            .setWaitForGreenStatus()
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(weightedRoutingResponse.isAcknowledged());
            // assert that cluster manager didn't switch during test  
            expectedStateLatch.countDown();
            "a",
                .put("node.attr.zone", "c")  
            .prepareHealth()
            DecommissionStatus.IN_PROGRESS
        assertEquals(response.getAttributeValue(), decommissionAttribute.attributeValue());  
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
            .setWeightedRouting(weightedRouting)
        logger.info("--> Decommission status is successful");
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);  
        @Override  
            .setWaitForNodes(Integer.toString(6))  
                }
        });  
                .build(),
import static org.opensearch.test.NodeRoles.onlyRole;  
            zoneToDecommission = randomFrom(tempZones);
        AtomicInteger numRequestFailed = new AtomicInteger();
import java.util.Iterator;  
        Predicate<ClusterState> expectedClusterStatePredicate = clusterState -> {
            .setWeightedRouting(weightedRouting)
            .prepareWeightedRouting()
        assertEquals(response.getDecommissionStatus(), DecommissionStatus.SUCCESSFUL);
        );
        Settings commonSettings = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build();
    public void testDecommissionAcknowledgedIfWeightsNotSetForNonRoutingNode() throws ExecutionException, InterruptedException {
        assertEquals(clusterState.nodes().getDataNodes().size(), 8);
        // assert the node has decommissioned attribute
            throw new AssertionError("unexpected close");  
                    .contains("no weights are set to the attribute. Please set appropriate weights before triggering decommission action")
        assertEquals(metadata.decommissionAttribute(), decommissionAttribute);  
        assertFalse(health.isTimedOut());
        internalCluster().startDataOnlyNode(Settings.builder().put(commonSettings).put("node.attr.zone", "a").build());
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        assertEquals(clusterState.nodes().getClusterManagerNodes().size(), 2);  
                clusterManagerNodeAfterDecommission = node;
        String activeNode = randomFrom(dataNodes.get(0), dataNodes.get(1));
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "d");  
            this.doneLatch = latch;
import org.apache.logging.log4j.Logger;  
        logger.info("--> setting shard routing weights");
            return clusterState.metadata().coordinationMetadata().getLastCommittedConfiguration().getNodeIds().size() == 3;
        }
        ensureStableCluster(6);
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
        String randomDecommissionedNode = randomFrom(clusterManagerNodes.get(2), dataNodes.get(2));  
                .put(commonSettings)
        String activeNode;  
            Settings.builder()
                .put("node.attr.zone", "c")
            .execute()  
        DecommissionRequest decommissionRequest = new DecommissionRequest(decommissionAttribute);
            TestThreadPool finalTestThreadPool = testThreadPool;  
                .build()  
            "c",
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "a");
            Settings.builder()
        ).get(1);
            .setWaitForEvents(Priority.LANGUID)
            throw new AssertionError("unexpected timeout");
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
import java.util.Arrays;
                .put(commonSettings)
        if (expectedClusterStatePredicate.test(currentState)) {  
        // if the below condition is passed, then we are sure exclusion is cleared
        logger.info("--> starting 4 data nodes each on zones 'a' & 'b' & 'c'");
        String originalClusterManager = internalCluster().getClusterManagerName();  
        // Set the timeout to 0 to do immediate Decommission
        // The decommissioned node would not be having status as SUCCESS as it was kicked out later  
        Settings commonSettings = Settings.builder()
            .cluster()  
            tempZones.remove(originalClusterManagerZone);  
        );  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                () -> client().execute(DecommissionAction.INSTANCE, decommissionRequest).actionGet()  
        // Start 3 cluster manager eligible nodes
        ClusterHealthResponse health = client().admin()
        AtomicInteger numRequestUnAcknowledged = new AtomicInteger();  
            .setVersion(-1)
            logger,
            new DeleteDecommissionStateRequest()
import org.opensearch.cluster.routing.WeightedRouting;
        logger.info("--> starting data node each on zones 'a' & 'b' & 'c'");  
            Settings.builder()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        DecommissionResponse decommissionResponse = client().execute(DecommissionAction.INSTANCE, decommissionRequest).get();  
        // Start 3 data nodes in zone b
                .put("node.attr.zone", "c")
    }
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
        clusterManagerNameToZone.put(clusterManagerNodes.get(2), "c");  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
import org.opensearch.common.settings.Settings;
            Settings.builder()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            case "b":
import org.opensearch.cluster.decommission.NodeDecommissionedException;
        );
                Level.INFO,
                throw new IllegalStateException("unexpected zone decommissioned");  
            .actionGet();
/*  
        List<String> clusterManagerNodes = internalCluster().startNodes(
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);
            .cluster()
