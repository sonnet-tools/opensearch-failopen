            parser.nextToken();
        boolean includeDiskInfo = randomBoolean();
import org.opensearch.common.xcontent.json.JsonXContent;  
            Map<String, AllocationDecision> nodes = new HashMap<>();  
            parser.nextToken();
            parser.nextToken();
        // verify shard info
        assertNotNull(moveDecision.getCanRemainDecision());
            } else {
            .get();
                    parser.text()
            parser.nextToken();
            assertNotNull(result.getNode());
        assertNotEquals(ShardRoutingState.STARTED, shardState);
                            || parser.currentName().equals("transport_address")
                .put("index.routing.allocation.include._name", primaryNode)
        // verify shard info
                }
            }  
                allocationDecision.equals(AllocationDecision.NO.toString())
            assertThat(clusterInfo.getNodeLeastAvailableDiskUsages().size(), greaterThanOrEqualTo(0));
                parser.text()  
import org.opensearch.action.support.ActiveShardCount;
        }  
            for (String nodeName : internalCluster().getNodeNames()) {
        allNodes.remove(removePrimary ? primaryNodeName() : replicaNode().getName());
                            || parser.currentName().equals("name")
import org.opensearch.common.util.set.Sets;
                .setWaitForEvents(Priority.LANGUID)
            assertEquals("cluster_info", parser.currentName());
        }
        parser.nextToken();
        assertEquals(3, allocateDecision.getNodeDecisions().size());
    private void verifyClusterInfo(ClusterInfo clusterInfo, boolean includeDiskInfo, int numNodes) {
        NodeAllocationResult result = moveDecision.getNodeDecisions().get(0);
        assertEquals(1, moveDecision.getNodeDecisions().size());  
        internalCluster().startNodes(2);
            assertThat(clusterHealthResponse.getStatus().value(), lessThanOrEqualTo(ClusterHealthStatus.YELLOW.value()));
        // verify shard info
            .setIndex("idx")
        assertNull(unassignedInfo);
                            is(  
                assertEquals(Decision.Type.NO, d.type());  
                parser.nextToken();
        logger.info("--> starting 3 nodes");
        logger.info("--> stop node with the replica shard");
            assertNotNull(decisionText);  
            assertThat(parser.text(), startsWith("cannot allocate because the cluster is still waiting"));  
 * You may obtain a copy of the License at  
                    assertEquals(Decision.Type.NO, d.type());
        logger.info("--> setting balancing threshold really high, so it won't be met");  
            parser.nextToken();
        }
        );
        assertEquals(Reason.NODE_LEFT, unassignedInfo.getReason());
                if (d.label().equals("same_shard") && nodeHoldingPrimary) {
            parser.nextToken();  
    }
        for (Decision d : moveDecision.getClusterRebalanceDecision().getDecisions()) {
                assertThat(parser.longValue(), greaterThan(0L));  
        assertNotNull(result.getNode());
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());  
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();  
            parser.nextToken();
            assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));  
                parser.nextToken();
 * Tests for the cluster allocation explanation
                || unassignedInfo.getLastAllocationStatus() == AllocationStatus.NO_VALID_SHARD_COPY
        try (XContentParser parser = getParser(explanation)) {
        assertEquals("current_state", parser.currentName());  
    private void indexData() {  
        // verify current node info
            assertEquals(Token.START_OBJECT, parser.currentToken());
                        d.getExplanation()  
                } else if (d.label().equals("filter") && nodeHoldingPrimary == false) {
        assertNotNull(moveDecision.getCanRemainDecision());
                if (allocationDecision == AllocationDecision.NO || allocationDecision == AllocationDecision.THROTTLED) {
                    assertEquals(Decision.Type.NO, d.type());
                    + "found on the nodes in the cluster",
        assertEquals(Reason.NODE_LEFT, unassignedInfo.getReason());  
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.NO, true), includeYesDecisions, false);
        assertNotNull(unassignedInfo);  
        assertEquals("idx", shardId.getIndexName());  
            parser.nextToken();  
        ShardId shardId = explanation.getShard();
        boolean includeDiskInfo = randomBoolean();
            assertEquals(Token.START_OBJECT, parser.nextToken());
import java.io.IOException;  
    private boolean verifyDeciders(XContentParser parser, AllocationDecision allocationDecision) throws IOException {
        assertEquals(1, moveDecision.getNodeDecisions().size());  
                        break;
            assertEquals("can_rebalance_to_other_node", parser.currentName());
                assertFalse(nodeAllocationResult.getShardStoreInfo().isInSync());
        // verify unassigned info
    }
        throws Exception {
            .setPrimary(primary)  
            if (nodeHoldingPrimary) {  
                }
            assertNotNull(d.getExplanation());
        // verify shard info
            assertEquals("decision", parser.currentName());
            assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
import java.util.Collections;
                        while (!parser.nextToken().equals(Token.END_OBJECT)) {
                                )  
            assertEquals("can_rebalance_cluster", parser.currentName());
        ensureStableCluster(2);
            parser.nextToken();
            if (foundStores.contains(nodeName)) {
            }
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
        assertNull(moveDecision.getTargetNode());
        final int numNodes = expectedNodeDecisions.size();
        // verify cluster info
        // verify decision object  
                    || allocationDecision.equals(AllocationDecision.AWAITING_INFO.toString())  
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
                    "cannot allocate because information about existing shard data is still being retrieved " + "from some of the nodes",  
        assertEquals(Decision.Type.NO, moveDecision.getCanRemainDecision().type());
        parser.nextToken();  
        assertFalse(allocateDecision.isDecisionTaken());
        client().admin()
                assertNotNull(d.getExplanation());
            assertEquals(0, result.getCanAllocateDecision().getDecisions().size());  
            .get()
                .getShardAllocationDecision()
                } else {
        // verify decision object  
            if (includeYesDecisions) {
                parser.nextToken();
        assertNull(moveDecision.getTargetNode());
                assertNotNull(d.getExplanation());
        assertFalse(moveDecision.forceMove());
        // verify current node info
            parser.nextToken();  
                .put("index.routing.allocation.exclude._name", clusterManagerNode)
    }
                parser.nextToken();  
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertFalse(allocateDecision.isDecisionTaken());  
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
        assertFalse(moveDecision.forceMove());  
                } else if (token == Token.END_OBJECT) {
        // verify cluster info  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        // wait until the system has fetched shard data and we know there is no valid shard copy
        ensureStableCluster(1);
        ensureStableCluster(1);
        parser.nextToken();
            }
            logger.info("--> index more data, now the replica is stale");
        assertEquals(Decision.Type.YES, moveDecision.getClusterRebalanceDecision().type());  
                .setShard(0)
            assertEquals("can_allocate", parser.currentName());
        NodeAllocationResult result = moveDecision.getNodeDecisions().get(0);
            .setIncludeDiskInfo(includeDiskInfo)
        try (XContentParser parser = getParser(explanation)) {  
        assertEquals(0, shardId.getId());
    }  
            assertEquals(Token.END_OBJECT, parser.nextToken());  
        assertFalse(moveDecision.isDecisionTaken());  
import org.opensearch.cluster.ClusterState;
                .setIndex("idx")  
    }  
                .prepareCreate("idx")
        logger.info("--> restarting the stopped nodes");
        }
                    // Skip past attributes object  
            assertEquals(AllocationDecision.NO.toString(), parser.text());
        Settings node0DataPathSettings = internalCluster().dataPathSettings(nodes.get(0));  
        assertEquals(0, shardId.getId());
                assertThat(result.getShardStoreInfo().getMatchingBytes(), greaterThan(0L));  
        assertEquals("shard", parser.currentName());
        assertFalse(moveDecision.isDecisionTaken());
            assertEquals("rebalancing is not allowed", parser.text());
                parser.nextToken();
            assertEquals(AllocationDecision.NO.toString(), parser.text());
            if (allocationDecision.equals("awaiting_info")) {
        if (state == ShardRoutingState.UNASSIGNED) {  
                }
        // verify cluster info  
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        // verify shard info
import static org.hamcrest.Matchers.containsString;  
        assertNull(currentNode);  
                    assertTrue(
            assertEquals(AllocationDecision.NO_VALID_SHARD_COPY.toString(), parser.text());
            if (includeYesDecisions) {
        assertNotNull(unassignedInfo);
                assertEquals("can_allocate", parser.currentName());
                assertEquals("no rebalancing is allowed due to index setting [index.routing.rebalance.enable=none]", d.getExplanation());
            .prepareUpdateSettings("idx")
        List<String> nodes = internalCluster().startNodes(3);
        assertNull(currentNode);  
            0,
            builder.prettyPrint();
                .get()  
            1,
                assertEquals(Decision.Type.NO, d.type());  
        List<String> nodes = internalCluster().startNodes(3);
        Settings node1DataPathSettings = internalCluster().dataPathSettings(nodes.get(1));
        assertEquals(0, shardId.getId());
        logger.info("--> starting another node, with the rebalance threshold so high, it should not get any shards");
            assertEquals(1, result.getWeightRanking());
            assertEquals("can_rebalance_cluster_decisions", parser.currentName());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            parser.nextToken();
        assertFalse(moveDecision.isDecisionTaken());
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", (String) null))
            indexData();
        boolean isPrimary = explanation.isPrimary();  
    }  
            parser.nextToken();
        assertEquals("idx", shardId.getIndexName());  
                .indices()  
        if (logger.isDebugEnabled()) {  
            .get();
            parser.nextToken();  
        assertFalse(allocateDecision.isDecisionTaken());
                    "cannot allocate because a previous copy of the primary shard existed but can no longer be found "  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode().getName()));  
        assertNotNull(unassignedInfo);  
            verifyNodeDecisions(parser, nodeDecisions, includeYesDecisions, false);
            moveDecision.getExplanation()  
        }
        // verifying can remain decision object
                .setWaitForActiveShards(ActiveShardCount.ONE)
        prepareIndex(
        assertEquals("idx", shardId.getIndexName());  
            }
            parser.nextToken();
        ShardId shardId = explanation.getShard();
        ClusterInfo clusterInfo = explanation.getClusterInfo();
            parser.nextToken();
        ClusterInfo clusterInfo = explanation.getClusterInfo();
            parser.nextToken();
        boolean isPrimary = explanation.isPrimary();
        ensureStableCluster(3);
                }
import java.util.Map;
                assertNull(nodeAllocationResult.getShardStoreInfo().getStoreException());
            for (Decision d : result.getCanAllocateDecision().getDecisions()) {  
        final IndexMetadata.State indexState = randomIndexState();
        logger.info("--> shutting down all nodes except the one that holds the primary");
        try (XContentParser parser = getParser(explanation)) {  
                .setSettings(
            verifyShardInfo(parser, false, includeDiskInfo, ShardRoutingState.STARTED);
                    assertEquals(  
            }
            assertEquals(
                .getExplanation()
                .get();
            logger.info("--> close the index, now the replica is stale");
                        "node does not match index setting [index.routing.allocation.include] filters " + "[_name:\"non_existent_node\"]",
        // skip past node_attributes object
                assertEquals(nodeHoldingPrimary ? 1 : 0, result.getCanAllocateDecision().getDecisions().size());
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);  
                .cluster()
        assertEquals("rebalancing is not allowed", moveDecision.getExplanation());
/*  
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
            for (Decision d : result.getCanAllocateDecision().getDecisions()) {  
            }
        assertBusy(() -> {
            ActiveShardCount.ONE
            Token token;
        parser.nextToken();  
            verifyDeciders(parser, AllocationDecision.NO);  
        assertEquals(1, result.getWeightRanking());  
        for (Decision d : moveDecision.getClusterRebalanceDecision().getDecisions()) {
                    assertNotEquals("delayed", parser.currentName()); // we should never display "delayed" from unassigned info
            assertNotNull(parser.text());  
            assertEquals(60000L, parser.longValue());
        parser.nextToken();
        }
        if (includeYesDecisions) {  
                assertEquals(
        assertFalse(moveDecision.canRemain());
import org.opensearch.core.xcontent.XContentParser;
                        "decision was " + allocationDecision + " but found no node's with that decision",
            assertEquals("can_remain_on_current_node", parser.currentName());
                "cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance",
                assertNotNull(nodeAllocationResult.getShardStoreInfo());
        if (includeDiskInfo) {  
                assertFalse(nodeAllocationResult.getShardStoreInfo().isInSync());  
            index("idx", "t", Integer.toString(i), Collections.singletonMap("f1", Integer.toString(i)));
            boolean nodeHoldingPrimary = result.getNode().getName().equals(primaryNodeName);
 */
            parser.nextToken();  
    }  
            assertEquals(Decision.Type.YES, d.type());  
                    d.getExplanation()
            assertEquals("can_allocate", parser.currentName());  
        assertEquals(0, shardId.getId());
            if (allocationDecision == AllocationDecision.NO || allocationDecision == AllocationDecision.THROTTLED || includeYesDecisions) {
        assertTrue(allocateDecision.isDecisionTaken());
        assertNull(allocateDecision.getAllocationId());  
                }
                assertEquals("allocate_explanation", parser.currentName());  
    public void testUnassignedReplicaWithPriorCopy() throws Exception {  
        assertEquals(
        if (includeDiskInfo) {
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
            }
                assertEquals(AllocationDecision.YES, result.getNodeDecision());
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.NO, true), includeYesDecisions, false);
        );
        assertNotEquals(ShardRoutingState.STARTED, shardRoutingState);
        prepareIndex(5, 0);  
            parser.nextToken();  
                assertEquals("found", parser.currentName());
        // verify JSON output
        assertFalse(moveDecision.canRebalanceCluster());  
        logger.info("--> starting 2 nodes");
                assertEquals("in_sync", parser.currentName());
            assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(0));
            assertEquals(Token.END_OBJECT, parser.currentToken());  
        // start replica node first, so it's path will be used first when we start a node after
        assertEquals(AllocationDecision.ALLOCATION_DELAYED, allocateDecision.getAllocationDecision());  
            assertAcked(client().admin().indices().prepareClose("idx"));
        DiscoveryNode currentNode = explanation.getCurrentNode();  
            assertEquals("rebalance_explanation", parser.currentName());
        assertNull(allocateDecision.getTargetNode());
        assertFalse(isPrimary);
                // shard data was found on the node, but it is stale  
        } else {  
        assertTrue(allocateDecision.isDecisionTaken());
        DiscoveryNode currentNode = explanation.getCurrentNode();
        }
            Map<String, AllocationDecision> nodeDecisions = new HashMap<>();
        assertEquals(60000L, allocateDecision.getConfiguredDelayInMillis());
        verifyClusterInfo(clusterInfo, includeDiskInfo, 1);
            assertEquals("cannot allocate because all found copies of the shard are either stale or corrupt", parser.text());  
        assertEquals("node_id", parser.currentName());
        assertTrue(moveDecision.canRemain());
        // verify JSON output
            }
            if (includeYesDecisions) {
                            )
        assertEquals(2, moveDecision.getNodeDecisions().size());
                .setWaitForEvents(Priority.LANGUID)
            assertEquals(  
                parser.nextToken();  
            String nodeName = verifyNodeDecisionPrologue(parser);  
        logger.info("--> starting 3 nodes");
            String nodeName = verifyNodeDecisionPrologue(parser);
                );
                assertEquals(Decision.Type.YES, d.type());
            assertEquals(  
            parser.nextToken();
                allocateDecision.getExplanation()
                            + "\"]",
import org.opensearch.cluster.routing.ShardRoutingState;
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", firstNode))  
            try (XContentParser parser = getParser(explanation)) {
import org.opensearch.cluster.routing.UnassignedInfo.Reason;
                assertEquals("allocation_id", parser.currentName());
        internalCluster().startNodes(2);  
        client().admin()  
        // verify cluster info  
            parser.nextToken();
        client().admin()
        assertEquals(2, allocateDecision.getNodeDecisions().size());
            assertEquals(Token.END_OBJECT, parser.currentToken());
        verifyClusterInfo(clusterInfo, includeDiskInfo, 3);
        assertNull(unassignedInfo);  
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", primaryNodeName))
            parser.nextToken();  
        assertEquals(0, shardId.getId());
        logger.info("--> starting 2 nodes");
        assertTrue(moveDecision.canRemain());
                if (token == Token.FIELD_NAME) {
            assertNotNull(d.getExplanation());
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());  
        assertNotNull(currentNode);  
        return nodeDecisions;
            parser.nextToken();
        final int numReplicas,
            nodes.put(currentNodes[0].equals(primaryNodeName) ? currentNodes[1] : currentNodes[0], AllocationDecision.YES);  
        assertFalse(isPrimary);
                    d.getExplanation()  
            }
        );
        assertTrue(
        // verify shard info
        logger.info("--> setting up allocation filtering to only allow allocation to the current node");
        parser.nextToken();
        boolean includeDiskInfo = randomBoolean();
        ensureStableCluster(2);
            assertNotNull(result.getNode());
        assertNull(allocateDecision.getAllocationId());
import org.opensearch.core.index.shard.ShardId;
        internalCluster().startNode();
        assertNotNull(currentNode);
 */
        for (Decision d : result.getCanAllocateDecision().getDecisions()) {
                    assertEquals(
            assertEquals(AllocationDecision.NO.toString(), parser.text());  
                parser.nextToken();
            parser.nextToken();
    }
        assertEquals(
                "cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance",
        // verify JSON output
        // verify unassigned info
            if (reuseStore == false) {
                        assertThat(
        }
            assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(0));
        boolean includeDiskInfo = randomBoolean();
    public void testRebalancingNotAllowed() throws Exception {
            verifyShardInfo(parser, false, includeDiskInfo, ShardRoutingState.UNASSIGNED);
            assertEquals(AllocationDecision.YES.toString(), parser.text());  
        });
        boolean reuseStore
        parser.nextToken();
        nodes.remove(primaryNodeName);  
            boolean nodeHoldingPrimary = result.getNode().getName().equals(primaryNodeName);
        assertNull(moveDecision.getTargetNode());  
                assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
        // verify unassigned info  
            assertEquals(
                            + "filters [_name:\""
 */  
        }  
        NodeAllocationResult result = moveDecision.getNodeDecisions().get(0);
        logger.info("--> stop the node with the primary");  
        assertEquals("node_name", parser.currentName());  
    public void testCannotAllocateStaleReplicaExplanation() throws Exception {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        boolean includeDiskInfo = randomBoolean();  
            } else {  
        return clusterState.getRoutingNodes().node(nodeId).node();
        assertEquals(0, shardId.getId());
    private void verifyShardInfo(XContentParser parser, boolean primary, boolean includeDiskInfo, ShardRoutingState state)  
    }
                "cannot allocate because information about existing shard data is still being retrieved from some of the nodes",
            assertEquals("can_remain_on_current_node", parser.currentName());  
            }
                }
                );
        }
            parser.nextToken();  
        boolean encounteredNo = false;  
            .get();  
        // verify unassigned info
        final String primaryNode = internalCluster().startNode();  
        parser.nextToken();
            String decisionText = parser.text();
    public void testAssignedReplicaOnSpecificNode() throws Exception {  
        try (XContentParser parser = getParser(explanation)) {  
        boolean includeYesDecisions = randomBoolean();
    }
        assertEquals(1, result.getWeightRanking());  
                encounteredNo = true;
            } else {
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);  
        // wait till we have passed any pending shard data fetching  
        assertFalse(moveDecision.forceMove());  
            assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));  
        ShardId shardId = explanation.getShard();  
import org.opensearch.core.xcontent.XContentBuilder;  
        assertNotNull(moveDecision.getClusterRebalanceDecision());
            parser.nextToken();  
                assertEquals(Token.END_OBJECT, parser.nextToken());
        throws Exception {
        ensureStableCluster(1);
                    );
            .get();
        assertNull(allocateDecision.getTargetNode());
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
            assertNotNull(result.getNode());
        ShardRoutingState shardRoutingState = explanation.getShardState();
        // verify node decisions
            parser.nextToken();  
        assertEquals(Token.START_OBJECT, parser.nextToken());  
            }
            parser.nextToken();
            String allocationDecision = parser.text();
                parser.nextToken();
            .prepareUpdateSettings("idx")  
        boolean includeDiskInfo = randomBoolean();
        }
                assertNotNull(nodeAllocationResult.getShardStoreInfo().getAllocationId());  
                assertFalse(parser.booleanValue());  
        }
        // verify cluster info  
                assertNull(nodeAllocationResult.getShardStoreInfo().getAllocationId());
        } else {
                assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
 * Licensed to Elasticsearch under one or more contributor  
            parser.nextToken();
                        .put("index.number_of_replicas", numReplicas)
        assertEquals("node_allocation_decisions", parser.currentName());
        // verify current node info
        assertNull(unassignedInfo);  
        ClusterInfo clusterInfo = explanation.getClusterInfo();
                            || parser.currentName().equals("attributes")
                assertThat(parser.intValue(), greaterThan(0));
                    );  
        // verifying cluster rebalance decision object
                .prepareHealth("idx")  
        for (NodeAllocationResult result : allocateDecision.getNodeDecisions()) {  
                    --numObjects;  
        assertEquals(0L, allocateDecision.getRemainingDelayInMillis());
            parser.nextToken();
            parser.nextToken();  
import org.opensearch.cluster.routing.allocation.MoveDecision;
        assertTrue(allocateDecision.isDecisionTaken());
                "cannot allocate because information about existing shard data is still being retrieved from some of the nodes",
        assertEquals(0L, allocateDecision.getConfiguredDelayInMillis());  
        Set<String> allNodes = Sets.newHashSet(internalCluster().getNodeNames());  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            }
        // verify decision objects
        assertEquals("node_attributes", parser.currentName());  
                assertEquals(Decision.Type.NO, d.type());
        }
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);
        assertNotNull(result.getNode());  
        assertTrue(allocateDecision.isDecisionTaken());
        internalCluster().startNodes(2);
        assertTrue(decisionToAllocate == AllocationDecision.AWAITING_INFO || decisionToAllocate == AllocationDecision.NO);
    }
    }  
        }
        logger.info("--> observing delayed allocation...");
        assertEquals("cannot allocate because allocation is not permitted to any of the nodes", allocateDecision.getExplanation());
                boolean atLeastOneMatchingDecisionFound = verifyDeciders(parser, allocationDecision);  
        internalCluster().startNode();
            parser.nextToken();  
        ShardRoutingState shardRoutingState = explanation.getShardState();
            assertEquals(AllocationDecision.YES.toString(), parser.text());
        assertEquals(2, allocateDecision.getNodeDecisions().size());
import org.opensearch.cluster.health.ClusterHealthStatus;
        logger.info("--> stopping the node with the replica");
        DiscoveryNode currentNode = explanation.getCurrentNode();
            Settings.builder().put("index.routing.allocation.exclude._name", excludedNode).build(),  
            assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
            .prepareUpdateSettings("idx")
        return runExplain(primary, null, includeYesDecisions, includeDiskInfo);
        ClusterInfo clusterInfo = explanation.getClusterInfo();  
                assertFalse("encountered a YES node decision after a NO node decision - sort order is wrong", encounteredNo);  
        prepareIndex(5, 0);  
            assertEquals("store", parser.currentName());
            }
        AllocationDecision decisionToAllocate = allocateDecision.getAllocationDecision();  
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.STARTED);
        Map<String, AllocationDecision> expectedNodeDecisions,
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
            parser.nextToken();
            } else {
            verifyNodeDecisions(parser, nodeDecisions, includeYesDecisions, true);
                assertNull(nodeAllocationResult.getShardStoreInfo().getStoreException());
        for (NodeAllocationResult result : allocateDecision.getNodeDecisions()) {
    private static IndexMetadata.State randomIndexState() {
                                    AllocationDecision.NO_ATTEMPT.toString()
        boolean isPrimary = explanation.isPrimary();
import org.opensearch.core.xcontent.ToXContent;
            parser.nextToken();
            parser.nextToken();
            } else {
        assertFalse(isPrimary);
        assertTrue(isPrimary);  
                if (token == Token.START_OBJECT) {  
        DiscoveryNode currentNode = explanation.getCurrentNode();  
        assertFalse(moveDecision.canRebalanceCluster());
        assertEquals("transport_address", parser.currentName());
    private XContentParser getParser(ClusterAllocationExplanation explanation) throws IOException {
        assertFalse(moveDecision.isDecisionTaken());  
        ensureClusterSizeConsistency(); // wait for the cluster-manager to finish processing join.
        }  
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.STARTED);
            parser.nextToken();  
        client().admin()
            parser.nextToken();
                allocateDecision.getExplanation()
    }
            parser.nextToken();  
            assertEquals(ShardRoutingState.STARTED, state);
                if (d.type() == Decision.Type.NO) {
            assertEquals(AllocationDecision.YES.toString(), parser.text());
                        );
        ensureStableCluster(1);
        parser.nextToken();  
            assertEquals("can_rebalance_to_other_node", parser.currentName());
                assertEquals(
            IndexMetadata.State.OPEN,  
        boolean includeYesDecisions = randomBoolean();
            assertThat(parser.longValue(), greaterThan(0L));
            Settings.builder()  
            }
            client().admin()  
            assertEquals(Token.END_OBJECT, parser.nextToken());
        internalCluster().startNode(Settings.builder().put("node.name", nodes.get(0)).put(node0DataPathSettings).build());
        assertEquals(0, shardId.getId());  
            for (Decision d : result.getCanAllocateDecision().getDecisions()) {  
        // verify JSON output
        assertEquals("idx", shardId.getIndexName());
                // the other node should have zero NO decisions  
        assertNotNull(moveDecision.getClusterRebalanceDecision());  
        );
            moveDecision.getExplanation()  
        assertNotNull(moveDecision.getCanRemainDecision());  
            AllocationDecision allocationDecision = expectedNodeDecisions.get(nodeName);
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
        logger.info("--> starting a single node");
            } else {  
        boolean isPrimary = explanation.isPrimary();  
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.NO, false), includeYesDecisions, false);  
        // verifying cluster rebalance decision object
                    assertEquals(Decision.Type.NO, d.type());  
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * Modifications Copyright OpenSearch Contributors. See
        if (allocateDecision.getAllocationDecision() == AllocationDecision.NO_VALID_SHARD_COPY) {
            nodeDecisions.put(nodeName, allocationDecision);  
            "cannot move shard to another node, even though it is not allowed to remain on its current node",
            assertEquals(0, result.getCanAllocateDecision().getDecisions().size());
            assertEquals(AllocationDecision.NO.toString(), parser.text());  
                );  
        return clusterState.getRoutingNodes().node(nodeId).node().getName();
        parser.nextToken();  
        // verifying cluster rebalance decision object
                parser.nextToken();
        assertTrue(isPrimary);
        // verify current node info
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();  
            assertEquals(Decision.Type.YES, d.type());  
        // verify node decisions
            assertEquals(AllocationDecision.NO.toString(), parser.text());  
        assertNull(moveDecision.getTargetNode());  
                assertEquals(
            final ClusterHealthResponse clusterHealthResponse = client().admin()  
        boolean isPrimary = explanation.isPrimary();
        assertEquals(Token.START_ARRAY, parser.nextToken());  
    public void testWorseBalance() throws Exception {
 * GitHub history for details.
            } else {  
        // verifying cluster rebalance decision object
        assertEquals(Decision.Type.NO, moveDecision.getClusterRebalanceDecision().type());  
        }
            parser.nextToken();
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
            }
        ShardRoutingState shardRoutingState = explanation.getShardState();  
        // verify shard info  
        }  
        ensureStableCluster(1);
            assertEquals("unassigned_info", parser.currentName());
        // verify JSON output
        if (decisionToAllocate == AllocationDecision.AWAITING_INFO) {
        logger.info("--> starting a single node");
                .setWaitForNoInitializingShards(true)  
            if (allocationDecision != AllocationDecision.YES) {  
        assertThat(primaryNodeName(), equalTo(primaryNode));  
        prepareIndex(1, 1);
        // verify unassigned info
        assertEquals(0L, allocateDecision.getRemainingDelayInMillis());  
            // verify JSON output
    private ClusterAllocationExplanation runExplain(boolean primary, String nodeId, boolean includeYesDecisions, boolean includeDiskInfo)
        assertNull(currentNode);  
                .setPrimary(true)
            assertEquals(Token.END_OBJECT, parser.nextToken());  
        if (activeShardCount != ActiveShardCount.NONE) {  
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();  
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();  
        boolean includeDiskInfo = randomBoolean();
        assertEquals(2, moveDecision.getCurrentNodeRanking());  
        }  
        assertThat(allocateDecision.getRemainingDelayInMillis(), greaterThan(0L));  
        }  
        if (allocateDecision.getAllocationDecision() == AllocationDecision.NO_VALID_SHARD_COPY) {
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.YES, true), includeYesDecisions, false);  
            .indices()
                verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.UNASSIGNED);  
            .get();
        assertTrue(allocateDecision.isDecisionTaken());
        ShardId shardId = explanation.getShard();
    }
            parser.nextToken();
        );
            );  
            if (d.label().equals("filter")) {  
            if (allocationDecision.equals("awaiting_info")) {
            parser.nextToken();
                    d.getExplanation()
        assertEquals("node_allocation_decisions", parser.currentName());
import org.opensearch.common.Priority;
        assertNull(allocateDecision.getAllocationId());
                    assertNotNull(parser.text());  
 * this work for additional information regarding copyright
        assertEquals(1, result.getWeightRanking());
                    Settings.builder()  
            1,
        assertNotNull(parser.text());
        assertNull(currentNode);
        for (NodeAllocationResult result : moveDecision.getNodeDecisions()) {  
        try (XContentParser parser = getParser(explanation)) {  
        final ActiveShardCount activeShardCount  
        prepareIndex(
            while ((token = parser.nextToken()) != Token.END_OBJECT) { // until we reach end of current_node  
                    assertEquals(Decision.Type.YES, d.type());
        ensureStableCluster(2);  
        try (XContentParser parser = getParser(explanation)) {
            ActiveShardCount.NONE
                assertEquals(Decision.Type.YES, d.type());  
        assertEquals(  
            assertEquals(Token.END_OBJECT, parser.nextToken());
        logger.info("--> creating a {} index with {} primary, {} replicas", state, numPrimaries, numReplicas);  
 * this file be licensed under the Apache-2.0 license or a
        } else {
            assertThat(clusterInfo.getNodeLeastAvailableDiskUsages().size(), lessThanOrEqualTo(numNodes));
                Token token = parser.nextToken();
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.STARTED);  
    public void testUnassignedReplicaDelayedAllocation() throws Exception {  
        }
        assertTrue(isPrimary);
    private String primaryNodeName() {
        parser.nextToken();  
            );  
        }
            parser.nextToken();
 * the Apache License, Version 2.0 (the "License"); you may
        boolean isPrimary = explanation.isPrimary();  
        // verify cluster info
        assertNotNull(moveDecision.getClusterRebalanceDecision());
        throws IOException {
        internalCluster().startNodes(3);
            parser.nextToken();
        // verify decision objects  
            assertEquals("current_node", parser.currentName());  
                        parser.nextToken();  
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();  
        assertEquals(  
        String restartedNode = internalCluster().startDataOnlyNode(replicaDataPathSettings);
        assertNotNull(unassignedInfo);
import org.opensearch.core.xcontent.XContentParser.Token;
            assertEquals(AllocationDecision.ALLOCATION_DELAYED.toString(), parser.text());
        logger.info("--> starting 3 nodes");  
            assertEquals("can_move_to_other_node", parser.currentName());
                .prepareAllocationExplain()
                )
                assertEquals(Decision.Type.YES, d.type());  
        for (NodeAllocationResult result : allocateDecision.getNodeDecisions()) {  
            int numObjects = 1;  
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();  
        boolean includeYesDecisions = randomBoolean();
        assertTrue(moveDecision.isDecisionTaken());
        );
            }
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        // verify node decisions
            assertEquals(AllocationDecision.YES.toString(), parser.text());
            assertNotNull(result.getNode());  
                .setPrimary(false)
            parser.nextToken();
            assertTrue(  
                assertEquals(Decision.Type.NO, d.type());
        } else {  
        assertFalse(moveDecision.forceMove());  
        internalCluster().startNode();
        } else {
            assertEquals(AllocationDecision.NO.toString(), parser.text());
        return nodeName;
                assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));  
 * KIND, either express or implied.  See the License for the
        assertEquals(1, moveDecision.getNodeDecisions().size());
        }  
            verifyNodeDecisions(parser, nodes, includeYesDecisions, true);
                    || allocationDecision.equals(AllocationDecision.AWAITING_INFO.toString())
                .setShard(0)
        ShardId shardId = explanation.getShard();
                .cluster()
            logger.debug("--> explain json output: \n{}", explanation.toXContent(builder, ToXContent.EMPTY_PARAMS).toString());
        assertNull(allocateDecision.getTargetNode());  
            assertEquals(Decision.Type.YES, d.type());
        boolean includeYesDecisions,  
                assertNotNull(d.getExplanation());
        assertFalse(moveDecision.canRebalanceCluster());
/*  
        ShardId shardId = explanation.getShard();  
        boolean isPrimary = explanation.isPrimary();  
                    }  
                assertEquals(AllocationDecision.NO_VALID_SHARD_COPY.toString(), parser.text());
        // verify current node info
        return atLeastOneMatchingDecisionFound;
        while (parser.nextToken() != Token.END_ARRAY) {
    private void prepareIndex(
        logger.info("--> starting another node, with filtering not allowing allocation to the new node, it should not get any shards");  
            .setSettings(Settings.builder().put("index.routing.rebalance.enable", "none"))  
        ShardRoutingState shardRoutingState = explanation.getShardState();
        client().admin()
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.WORSE_BALANCE, true), includeYesDecisions, false);
        prepareIndex(1, 1);
        } else {
        if (includeYesDecisions) {
        // verify unassigned info
                }
        assertTrue(moveDecision.isDecisionTaken());
                    assertEquals(Decision.Type.YES, d.type());
            for (Decision d : result.getCanAllocateDecision().getDecisions()) {
        parser.nextToken();
        boolean includeYesDecisions = randomBoolean();
            moveDecision.getExplanation()
        assertEquals("idx", shardId.getIndexName());
 * under the License.  
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);  
                assertNotNull(d.getExplanation());
            assertEquals(AllocationDecision.YES.toString(), parser.text());
        parser.nextToken();  
                .setIndex("idx")  
        assertFalse(moveDecision.isDecisionTaken());  
import java.util.Set;  
                    assertNotNull(d.getExplanation());  
            parser.nextToken();
        ShardRoutingState shardRoutingState = explanation.getShardState();
        ClusterInfo clusterInfo = explanation.getClusterInfo();
            assertEquals(Token.END_OBJECT, parser.nextToken());
            .cluster()
                AllocationDecision.NO_VALID_SHARD_COPY,
        assertTrue(moveDecision.canRebalanceCluster());
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName()));
                "rebalancing is not allowed, even though there is at least one node on which the shard can be allocated",  
            } else {
            parser.nextToken();  
        } else {  
        return randomFrom(IndexMetadata.State.values());  
                    assertThat(d.getExplanation(), startsWith("a copy of this shard is already allocated to this node ["));  
        );
                            parser.nextToken();  
                .prepareHealth("idx")
            if (includeYesDecisions) {
            containsString("despite being allowed to allocate the shard to at least one other node")
        }  
            assertEquals(AllocationDecision.YES.toString(), parser.text());
        ClusterInfo clusterInfo = explanation.getClusterInfo();  
                if (d.label().equals("same_shard") && nodeHoldingPrimary) {
                if (d.label().equals("filter")) {
                        "node does not match index setting [index.routing.allocation.include] "
        // verify current node info
        // verify JSON output
            );
            parser.nextToken();  
                            parser.text(),
            }
        assertNotNull(currentNode);  
        assertEquals(0, parser.intValue());  
        // verify current node info  
            "rebalancing is not allowed, even though there is at least one node on which the shard can be allocated",
                                    AllocationDecision.NO.toString(),
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
    public void testBetterBalanceButCannotAllocate() throws Exception {
    private void verifyNodeDecisions(  
            assertEquals(  
                allocationDecision.equals(AllocationDecision.NO.toString())
            .get();
            assertEquals(  
        }  
            .indices()
    private void prepareIndex(final int numPrimaries, final int numReplicas) {  
/**  
        assertTrue(isPrimary);
        }  
 * not use this file except in compliance with the License.
            .indices()
        ShardId shardId = explanation.getShard();  
        logger.info("--> stopping the node with the primary");  
import org.opensearch.cluster.ClusterInfo;  
            assertEquals("rebalance_explanation", parser.currentName());
        ClusterInfo clusterInfo = explanation.getClusterInfo();
            assertEquals("can_remain_on_current_node", parser.currentName());  
            ActiveShardCount.from(2)
            assertEquals("rebalance_explanation", parser.currentName());  
            assertEquals(AllocationDecision.NO, result.getNodeDecision());  
            assertEquals("can_rebalance_cluster", parser.currentName());  
    }
            }
            parser.nextToken();
        assertNotEquals(ShardRoutingState.STARTED, shardRoutingState);
        for (String nodeName : allNodes) {
    public void testUnassignedPrimaryWithExistingIndex() throws Exception {  
            assertEquals("can_allocate", parser.currentName());  
        ShardRoutingState shardRoutingState = explanation.getShardState();
        parser.nextToken();
        assertEquals("idx", shardId.getIndexName());
            indexData();
        // verify current node info
            } else {
        assertEquals("index", parser.currentName());  
/*
                atLeastOneMatchingDecisionFound = true;
                );  
            } else {
        DiscoveryNode currentNode = explanation.getCurrentNode();  
            nodes.put(primaryNodeName, AllocationDecision.NO);
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();  
            assertEquals("rebalance_explanation", parser.currentName());  
    private void verifyStaleShardCopyNodeDecisions(XContentParser parser, int numNodes, Set<String> foundStores) throws IOException {  
        );  
            }  
                        .put(settings)  
        flushAndRefresh("idx");
        // verify decision object
        assertNull(unassignedInfo);
                nodeDecisions.put(nodeName, AllocationDecision.NO);
        ensureStableCluster(2);
        assertEquals(Decision.Type.YES, moveDecision.getClusterRebalanceDecision().type());
        assertTrue(
        prepareIndex(
        }
                    parser.text()
                    assertEquals(Decision.Type.NO, d.type());
        ));
        ShardId shardId = explanation.getShard();
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.UNASSIGNED);
            parser.nextToken();
        assertEquals(Token.START_ARRAY, parser.nextToken());
        final String replicaNode = internalCluster().startNode();
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();  
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();  
            parser.nextToken();
    }
        // verify JSON output  
        ClusterAllocationExplanation explanation = runExplain(false, replicaNode().getId(), includeYesDecisions, includeDiskInfo);  
        boolean includeDiskInfo = randomBoolean();  
        }
            .prepareUpdateSettings("idx")
                    "node does not match index setting [index.routing.allocation.include] filters [_name:\"" + primaryNodeName + "\"]",  
        assertNull(unassignedInfo);
            unassignedInfo.getLastAllocationStatus() == AllocationStatus.FETCHING_SHARD_DATA  
            assertEquals("can_remain_on_current_node", parser.currentName());  
            assertEquals("explanation", parser.currentName());
        internalCluster().startNode(Settings.builder().put("node.name", nodes.get(1)).put(node1DataPathSettings).build());  
        }  
    }
        assertEquals(AllocationDecision.NO, result.getNodeDecision());
                    "node does not match index setting [index.routing.allocation.include] filters [_name:\"non_existent_node\"]",
            parser.nextToken();
            parser.nextToken();
        ClusterInfo clusterInfo = explanation.getClusterInfo();
        // verify cluster info
                    "node does not match index setting [index.routing.allocation.include] filters [_name:\"non_existent_node\"]",  
            XContentBuilder builder = JsonXContent.contentBuilder();
                assertEquals(AllocationDecision.NO, result.getNodeDecision());
            assertThat(clusterInfo.getNodeMostAvailableDiskUsages().size(), lessThanOrEqualTo(numNodes));  
        assertTrue(moveDecision.canRemain());
                parser.nextToken();  
        assertEquals(state.toString().toLowerCase(Locale.ROOT), parser.text());
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);  
import org.opensearch.test.OpenSearchIntegTestCase;
            assertEquals("remaining_delay_in_millis", parser.currentName());  
            parser.nextToken();  
import org.opensearch.common.settings.Settings;  
            assertThat(clusterInfo.getNodeMostAvailableDiskUsages().size(), greaterThanOrEqualTo(0));
        String nodeId = clusterState.getRoutingTable().index("idx").shard(0).replicaShards().get(0).currentNodeId();  
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);  
            .prepareUpdateSettings("idx")  
        assertNull(moveDecision.getTargetNode());  
                assertEquals(Token.START_OBJECT, parser.nextToken());
                } else {
        NodeAllocationResult result = moveDecision.getNodeDecisions().get(0);  
        DiscoveryNode currentNode = explanation.getCurrentNode();
        for (Decision d : moveDecision.getCanRemainDecision().getDecisions()) {
            }  
            );  
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", "non_existent_node"))
        // verify decision objects  
                assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));  
                assertEquals("deciders", parser.currentName());
                .get()  
            for (String nodeName : internalCluster().getNodeNames()) {
            );  
        XContentBuilder builder = JsonXContent.contentBuilder();
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);  
import static org.hamcrest.Matchers.greaterThan;
                    assertThat(d.label(), is(oneOf("filter", "same_shard")));
        parser.nextToken();  
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());  
            parser.nextToken();
            parser.nextToken();
import org.opensearch.test.InternalTestCluster;  
        try (XContentParser parser = getParser(explanation)) {
        DiscoveryNode currentNode = explanation.getCurrentNode();
        assertTrue(isPrimary);
            .setTransientSettings(Settings.builder().put("cluster.routing.allocation.balance.threshold", 1000.0f))
        // verify shard info
        assertEquals(AllocationStatus.NO_ATTEMPT, unassignedInfo.getLastAllocationStatus());
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);  
 *
            if (d.label().equals("filter")) {  
                assertEquals(Decision.Type.YES, d.type());
            assertEquals("allocate_explanation", parser.currentName());  
            }  
                                    AllocationDecision.NO_VALID_SHARD_COPY.toString(),  
                assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));
        DiscoveryNode currentNode = explanation.getCurrentNode();
                assertEquals("cannot allocate because allocation is not permitted to any of the nodes", parser.text());
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();  
        assertEquals(Token.END_ARRAY, parser.nextToken());  
            String allocationDecision = parser.text();  
        boolean isPrimary = explanation.isPrimary();
        ShardRoutingState shardRoutingState = explanation.getShardState();  
        assertNotNull(parser.text());
        internalCluster().startNode();  
            .cluster()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(0)));
            parser.nextToken();
 * ownership. Elasticsearch licenses this file to you under  
public final class ClusterAllocationExplainIT extends OpenSearchIntegTestCase {
        client().admin()  
                assertTrue("store info should not be present", reuseStore);
        );
    }
import org.opensearch.cluster.routing.UnassignedInfo;  
        final Settings settings,
            parser.nextToken();
        assertEquals(1, moveDecision.getCurrentNodeRanking());
        assertEquals(0, shardId.getId());  
    private DiscoveryNode replicaNode() {
        assertEquals(AllocationDecision.NO, result.getNodeDecision());
            parser.nextToken();  
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());
            assertNotNull(d.getExplanation());
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);
        assertEquals(Token.START_OBJECT, parser.currentToken());
            assertEquals("can_rebalance_to_other_node", parser.currentName());  
            assertThat(clusterHealthResponse.getStatus().value(), lessThanOrEqualTo(ClusterHealthStatus.YELLOW.value()));  
                    assertThat(d.getExplanation(), startsWith("a copy of this shard is already allocated to this node ["));  
            parser.nextToken();
                .get()  
            assertEquals(Token.END_OBJECT, parser.nextToken());
            );
        verifyClusterInfo(clusterInfo, includeDiskInfo, 3);
                    assertNotNull(d.getExplanation());  
        assertNotEquals(ShardRoutingState.STARTED, shardRoutingState);
                    );
        assertNotNull(moveDecision.getClusterRebalanceDecision());
        boolean includeYesDecisions = randomBoolean();
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();  
        assertNull(currentNode);
            assertNull(clusterInfo);  
            verifyShardInfo(parser, false, includeDiskInfo, ShardRoutingState.UNASSIGNED);
            .prepareAllocationExplain()  
        assertEquals(AllocationDecision.YES, result.getNodeDecision());  
        // verify current node info
        logger.info("--> starting 3 nodes");
import org.opensearch.common.unit.TimeValue;
                    ++numObjects;
        assertEquals(0, shardId.getId());
        assertEquals("idx", shardId.getIndexName());  
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
        }
            assertEquals(Token.END_OBJECT, parser.nextToken());
            } else {  
                            || parser.currentName().equals("weight_ranking")  
        for (Decision d : result.getCanAllocateDecision().getDecisions()) {
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
        assertThat(
        boolean includeDiskInfo = randomBoolean();  
                                oneOf(
import java.util.List;  
                assertNotNull(parser.text());
            assertEquals("configured_delay_in_millis", parser.currentName());
        parser.nextToken();
                    "cannot allocate because information about existing shard data is still being retrieved " + "from some of the nodes",
        assertFalse(allocateDecision.isDecisionTaken());  
            assertEquals("decider", parser.currentName());
        assertEquals(
        assertEquals("idx", shardId.getIndexName());  
                .prepareAllocationExplain()
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        // verify shard info
    }
        boolean includeYesDecisions = randomBoolean();
        }  
        String primaryNodeName = primaryNodeName();
        assertEquals(Token.END_ARRAY, parser.nextToken());
            parser.nextToken();
        assertEquals("node_decision", parser.currentName());
        logger.info("--> disabling rebalancing on the index");
            );
                parser.nextToken();
        for (int i = 0; i < numNodes; i++) {
        assertEquals(0L, allocateDecision.getConfiguredDelayInMillis());
                .getAllocateDecision()  
    private String verifyNodeDecisionPrologue(XContentParser parser) throws IOException {
            assertEquals("allocate_explanation", parser.currentName());
                .getAllocationDecision()
        // verify node decisions
        assertTrue(moveDecision.isDecisionTaken());
            final ClusterHealthResponse clusterHealthResponse = client().admin()
            ClusterAllocationExplanation explanation = client().admin()  
        }
            parser.nextToken();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        return explanation;  
            parser.nextToken();  
                // shouldn't be able to allocate to the same node as the primary, the same shard decider should say no
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
            .indices()  
        assertEquals("idx", shardId.getIndexName());
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();  
            assertEquals(Decision.Type.YES, d.type());
                || allocateDecision.getAllocationDecision() == AllocationDecision.AWAITING_INFO  
        assertNull(moveDecision.getClusterRebalanceDecision());
                .build(),  
        ClusterAllocationExplanation explanation = runExplain(false, includeYesDecisions, includeDiskInfo);
                .setWaitForActiveShards(activeShardCount)
        for (int i = 0; i < 10; i++) {
        logger.info("--> restart the node with the stale replica");  
                assertEquals(
        }
            assertEquals("can_rebalance_cluster", parser.currentName());
            assertEquals(AllocationDecision.NO.toString(), parser.text());
        logger.info("--> starting another node, with rebalancing disabled, it should get no shards");  
            }  
        assertNull(allocateDecision.getTargetNode());
            .setCurrentNode(nodeId)  
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
    private Map<String, AllocationDecision> allNodeDecisions(AllocationDecision allocationDecision, boolean removePrimary) {
                    if (parser.currentName().equals("attributes")) {
            assertEquals(AllocationDecision.NO, result.getNodeDecision());  
            } else {  
        // verify cluster info  
            }
        ClusterInfo clusterInfo = explanation.getClusterInfo();
        assertEquals(0, shardId.getId());
            assertEquals(Token.END_OBJECT, parser.nextToken());  
            assertEquals(1, allocateDecision.getNodeDecisions().size());
                    parser.text()
                );
            }
            );
                // if we are not including YES decisions, then the node holding the primary should have 1 NO decision,
                parser.nextToken();  
        DiscoveryNode currentNode = explanation.getCurrentNode();
                    if (parser.currentName().equals("last_allocation_status")) {
            assertEquals("allocate_explanation", parser.currentName());
        ShardRoutingState shardState = explanation.getShardState();
        parser.nextToken();
        boolean includeYesDecisions = randomBoolean();
                assertNull(result.getShardStoreInfo());  
        }
            assertEquals("cannot allocate because allocation is not permitted to any of the nodes", allocateDecision.getExplanation());
        parser.nextToken();
                        d.getExplanation()
import java.util.Locale;
                assertEquals("cannot allocate because allocation is not permitted to any of the nodes", parser.text());
 */  
        // verify current node info  
            .setIncludeYesDecisions(includeYesDecisions)
        for (Decision d : result.getCanAllocateDecision().getDecisions()) {  
        assertThat(allocateDecision.getExplanation(), startsWith("cannot allocate because the cluster is still waiting"));
import static org.hamcrest.Matchers.startsWith;
            verifyDeciders(parser, AllocationDecision.NO);  
                assertEquals("weight_ranking", parser.currentName());
            parser.nextToken();
                }  
        // verify decision objects  
        }  
        assertEquals(1, result.getWeightRanking());
    }
                assertEquals(  
        assertNotNull(result.getNode());
        assertEquals("primary", parser.currentName());
        for (int i = 0; i < numNodes; i++) {
            client().admin()
                        }
        logger.info("--> setting allocation filtering to only allow allocation on the currently running node");  
            assertEquals(AllocationDecision.NO.toString(), parser.text());  
        Map<String, AllocationDecision> nodeDecisions = new HashMap<>();
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.STARTED);
        boolean atLeastOneMatchingDecisionFound = false;  
        String primaryNodeName = primaryNodeName();
        assertEquals(ShardRoutingState.UNASSIGNED, shardRoutingState);
            while (numObjects > 0) {
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
import org.opensearch.cluster.routing.allocation.decider.Decision;
                        .put("index.number_of_shards", numPrimaries)
}
        prepareIndex(randomIndexState(), numPrimaries, numReplicas, Settings.EMPTY, ActiveShardCount.ALL);
            parser.nextToken();  
        }
        if (indexState == IndexMetadata.State.OPEN) {  
            }
            assertEquals(Token.START_OBJECT, parser.nextToken());  
        Settings replicaDataPathSettings = internalCluster().dataPathSettings(replicaNode);
            assertEquals(Token.END_OBJECT, parser.nextToken());
            moveDecision.getExplanation()
        final String clusterManagerNode = internalCluster().startNode();
        // verify JSON output
        // verify decision object
            assertAcked(client().admin().indices().prepareClose("idx"));
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());
                "cannot allocate because a previous copy of the primary shard existed but can no longer be "
            assertTrue(
        for (NodeAllocationResult nodeAllocationResult : allocateDecision.getNodeDecisions()) {  
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
                || (allocationDecision == AllocationDecision.THROTTLED && decisionText.equals("THROTTLE")))) {  
                assertNotNull(d.getExplanation());
        );  
 * software distributed under the License is distributed on an
    ) {
        assertEquals(0L, allocateDecision.getConfiguredDelayInMillis());
 * SPDX-License-Identifier: Apache-2.0
        prepareIndex(1, 0);
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
        }
            assertEquals("allocate_explanation", parser.currentName());
        assertNotNull(currentNode);
        assertEquals(Reason.INDEX_CREATED, unassignedInfo.getReason());
                // no shard data was found on the node  
        }  
        // verify decision object
                assertNotNull(nodeAllocationResult.getShardStoreInfo());
        boolean includeDiskInfo = randomBoolean();  
        assertEquals(1, moveDecision.getNodeDecisions().size());
            Token token;
        assertNotNull(moveDecision.getCanRemainDecision());
        } else {
 *  
            assertEquals("can_rebalance_cluster_decisions", parser.currentName());
        }  
        assertEquals(Decision.Type.NO, moveDecision.getClusterRebalanceDecision().type());  
            parser.nextToken();
import java.util.HashMap;
            parser.nextToken();
            assertNotNull(parser.text());
        assertEquals(Reason.NODE_LEFT, unassignedInfo.getReason());  
            verifyStaleShardCopyNodeDecisions(parser, 2, Collections.singleton(restartedNode));
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
            parser.nextToken();
        assertEquals(AllocationDecision.WORSE_BALANCE, result.getNodeDecision());
    }
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;  
                .setTimeout(TimeValue.timeValueSeconds(30))  
        while (!parser.currentName().equals("node_decision")) {
        assertEquals(Token.START_ARRAY, parser.nextToken());
        assertNull(allocateDecision.getAllocationId());  
                assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));
            parser.nextToken();  
        final int numPrimaries,  
            assertEquals("move_explanation", parser.currentName());
            Map<String, AllocationDecision> nodeDecisions = new HashMap<>();  
        // verify node decisions  
package org.opensearch.action.admin.cluster.allocation;
            assertEquals(Token.START_OBJECT, parser.nextToken());
        boolean isPrimary = explanation.isPrimary();
                assertFalse(parser.booleanValue());  
    private ClusterAllocationExplanation runExplain(boolean primary, boolean includeYesDecisions, boolean includeDiskInfo)
            );  
        logger.info("--> setting up allocation filtering to prevent allocation to both nodes");
            if (d.label().equals("enable")) {
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();  
            }  
        String nodeName = parser.text();
 * The OpenSearch Contributors require contributions made to  
                nodeDecisions.put(nodeName, AllocationDecision.NO);  
        assertAcked(
            "cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance",
        assertTrue(isPrimary);
            .getExplanation();
        parser.nextToken();
        if (includeYesDecisions) {
            parser.nextToken();
            "cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance",
                    );  
import static org.hamcrest.Matchers.oneOf;  
            assertEquals(AllocationDecision.NO, result.getNodeDecision());
        }
        // verify cluster info
                    assertTrue(token.isValue());
            assertNotNull(d.getExplanation());  
            parser.nextToken();
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;  
        ensureGreen();  
        assertTrue(isPrimary);  
            parser.nextToken();
        try (XContentParser parser = getParser(explanation)) {  
        ShardId shardId = explanation.getShard();
        // verify JSON output  
            .setShard(0)
        boolean includeYesDecisions = randomBoolean();
                allocateDecision.getExplanation()  
            // disk info is included, just verify the object is there
            while ((token = parser.nextToken()) != Token.END_OBJECT) { // until we reach end of unassigned_info
        assertEquals(AllocationStatus.DECIDERS_NO, unassignedInfo.getLastAllocationStatus());
        logger.info("--> creating an index with 1 primary, 0 replicas, with allocation filtering so the primary can't be assigned");
        assertNotNull(unassignedInfo);
 *
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(1)));  
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);  
        final IndexMetadata.State state,
            }  
        assertFalse(allocateDecision.isDecisionTaken());
            Settings.builder().put("index.routing.allocation.include._name", "non_existent_node").build(),  
        // stopping all of them at end of test.  
        assertEquals(2, moveDecision.getCurrentNodeRanking());  
                .setTimeout(TimeValue.timeValueSeconds(30))
        ShardRoutingState shardRoutingState = explanation.getShardState();
            verifyDeciders(parser, AllocationDecision.NO);
        boolean includeYesDecisions = randomBoolean();  
            parser.nextToken();  
                } else {
        assertThat(replicaNode().getName(), equalTo(replicaNode));
        if (includeYesDecisions) {
                assertEquals(
            .prepareUpdateSettings()  
            assertEquals(allocationDecision.toString(), parser.text());
        assertBusy(() ->
                    }  
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.UNASSIGNED);
    public void testAllocationFilteringOnIndexCreation() throws Exception {  
            assertEquals(Token.END_OBJECT, parser.nextToken());
        if (state == IndexMetadata.State.CLOSE) {  
        // verify unassigned info
            assertEquals("can_rebalance_to_other_node", parser.currentName());
        assertEquals(0, moveDecision.getCurrentNodeRanking());
                explanation.getShardAllocationDecision().getAllocateDecision().getAllocationDecision()
 * specific language governing permissions and limitations
        // verify shard info  
    }
 * compatible open source license.
            assertEquals("can_remain_on_current_node", parser.currentName());
    }
        assertTrue(moveDecision.canRemain());
            randomIndexState(),  
                            + primaryNodeName  
            builder.humanReadable(true);  
        for (Decision d : result.getCanAllocateDecision().getDecisions()) {
        XContentParser parser,
import org.opensearch.cluster.node.DiscoveryNode;
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        assertTrue(moveDecision.isDecisionTaken());
        ShardRoutingState shardRoutingState = explanation.getShardState();
                .cluster()
            assertEquals("can_allocate", parser.currentName());  
            assertEquals("cannot move shard to another node, even though it is not allowed to remain on its current node", parser.text());
            allocateDecision.getExplanation(),  
        }  
        assertNotNull(nodeName);  
    ) throws IOException {
        for (Decision d : moveDecision.getClusterRebalanceDecision().getDecisions()) {
            1,
            assertEquals(  
        DiscoveryNode currentNode = explanation.getCurrentNode();
                        + "on the nodes in the cluster",
        // verify unassigned info
            } else {  
 * Unless required by applicable law or agreed to in writing,
    }
        assertEquals("idx", shardId.getIndexName());  
        prepareIndex(1, 0);
    public void testAllocationFilteringPreventsShardMove() throws Exception {
        try (XContentParser parser = getParser(explanation)) {  
        } else {
                assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
        assertEquals(AllocationStatus.NO_ATTEMPT, unassignedInfo.getLastAllocationStatus());
            AllocationDecision.ALLOCATION_DELAYED,
        }  
            String[] currentNodes = internalCluster().getNodeNames();
            if ((allocationDecision == AllocationDecision.NO && decisionText.equals("NO")
        assertEquals("idx", parser.text());
            }  
        assertFalse(moveDecision.forceMove());
            IndexMetadata.State.OPEN,  
            parser.nextToken();  
        // verify unassigned info  
            2,
        logger.info("--> starting 2 nodes");
        internalCluster().startNode();
                                    AllocationDecision.AWAITING_INFO.toString(),
            assertEquals(AllocationDecision.NO.toString(), parser.text());  
        ShardId shardId = explanation.getShard();
        );
        String nodeId = clusterState.getRoutingTable().index("idx").shard(0).primaryShard().currentNodeId();  
            .indices()
            parser.nextToken();
            if ("store".equals(parser.currentName())) {  
        ClusterAllocationExplanation explanation = runExplain(false, includeYesDecisions, includeDiskInfo);
            } else {
    }  
        prepareIndex(5, 0);
        assertEquals(2, allocateDecision.getNodeDecisions().size());
            1,
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        assertEquals(AllocationDecision.NO_VALID_SHARD_COPY, allocateDecision.getAllocationDecision());
                parser.text()
        return createParser(explanation.toXContent(builder, ToXContent.EMPTY_PARAMS));  
                        parser.currentName().equals("id")  
        ClusterAllocationExplanation explanation = client().admin()
                assertEquals("matching_size_in_bytes", parser.currentName());
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
        assertEquals(AllocationDecision.NO, allocateDecision.getAllocationDecision());
            allocateDecision.getAllocationDecision() == AllocationDecision.NO_VALID_SHARD_COPY
                .cluster()
import static org.hamcrest.Matchers.equalTo;
        }  
            assertEquals("can_rebalance_cluster", parser.currentName());
        assertNotNull(moveDecision.getCanRemainDecision());
        assertNotNull(currentNode);  
        assertEquals(replicaNode().getName(), currentNode.getName());
import static org.hamcrest.Matchers.is;
        // verify unassigned info  
            assertEquals(Token.START_OBJECT, parser.nextToken());  
                    assertTrue(  
                        atLeastOneMatchingDecisionFound
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));  
                .setWaitForActiveShards(activeShardCount)
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
            assertTrue(explanation.getShardAllocationDecision().getAllocateDecision().isDecisionTaken());
        assertEquals(primary, parser.booleanValue());
        assertTrue(moveDecision.isDecisionTaken());
                parser.nextToken();
                .get();  
                parser.nextToken();
                if (token == XContentParser.Token.FIELD_NAME) {  
import org.opensearch.cluster.routing.allocation.AllocationDecision;
        assertEquals(0L, allocateDecision.getRemainingDelayInMillis());
                parser.text()
        boolean includeYesDecisions = randomBoolean();
            if (nodeAllocationResult.getNode().getName().equals(restartedNode)) {
                verifyStaleShardCopyNodeDecisions(parser, 1, Collections.emptySet());
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);
                );
        logger.info("--> starting a single node");  
        String primaryNodeName = primaryNodeName();
            if (d.label().equals("filter")) {
            assertEquals("can_remain_decisions", parser.currentName());
        String excludedNode = nodes.get(randomIntBetween(0, 2));
        String firstNode = internalCluster().startNode();  
            parser.nextToken();
    }
            parser.nextToken();  
        assertNotNull(result.getNode());
                .getExplanation();
        boolean isPrimary = explanation.isPrimary();  
        // verify decision objects
        assertTrue(moveDecision.canRebalanceCluster());  
