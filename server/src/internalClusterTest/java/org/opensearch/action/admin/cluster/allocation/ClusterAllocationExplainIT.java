                } else if (token == Token.END_OBJECT) {
        assertFalse(allocateDecision.isDecisionTaken());
        // stopping all of them at end of test.
                    || allocationDecision.equals(AllocationDecision.AWAITING_INFO.toString())
        // verify current node info
            parser.nextToken();
        assertTrue(moveDecision.canRebalanceCluster());
import org.opensearch.core.xcontent.XContentParser.Token;
        final IndexMetadata.State indexState = randomIndexState();
        for (int i = 0; i < 10; i++) {
        assertEquals("index", parser.currentName());
        verifyClusterInfo(clusterInfo, includeDiskInfo, 3);
        ShardId shardId = explanation.getShard();
                    assertEquals(Decision.Type.NO, d.type());
                        .put("index.number_of_replicas", numReplicas)
            assertNotNull(result.getNode());
                    parser.text()
                );
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.UNASSIGNED);
        NodeAllocationResult result = moveDecision.getNodeDecisions().get(0);
                    ++numObjects;
        if (decisionToAllocate == AllocationDecision.AWAITING_INFO) {
        }
        for (Decision d : result.getCanAllocateDecision().getDecisions()) {
        if (logger.isDebugEnabled()) {
        internalCluster().startNode(Settings.builder().put("node.name", nodes.get(0)).put(node0DataPathSettings).build());
                assertEquals("cannot allocate because allocation is not permitted to any of the nodes", parser.text());
            parser.nextToken();
            assertEquals(AllocationDecision.YES.toString(), parser.text());
        boolean isPrimary = explanation.isPrimary();
                nodeDecisions.put(nodeName, AllocationDecision.NO);
    private void verifyStaleShardCopyNodeDecisions(XContentParser parser, int numNodes, Set<String> foundStores) throws IOException {
            String allocationDecision = parser.text();
            assertTrue(explanation.getShardAllocationDecision().getAllocateDecision().isDecisionTaken());
            assertEquals(
                        );
        }
        assertNotNull(moveDecision.getClusterRebalanceDecision());
        while (!parser.currentName().equals("node_decision")) {
        boolean includeYesDecisions = randomBoolean();
        boolean isPrimary = explanation.isPrimary();
                                    AllocationDecision.AWAITING_INFO.toString(),
        parser.nextToken();
            assertEquals(
        internalCluster().startNode(Settings.builder().put("node.name", nodes.get(1)).put(node1DataPathSettings).build());
                            + primaryNodeName
            assertEquals(AllocationDecision.NO, result.getNodeDecision());
        List<String> nodes = internalCluster().startNodes(3);
        NodeAllocationResult result = moveDecision.getNodeDecisions().get(0);
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.WORSE_BALANCE, true), includeYesDecisions, false);
        String firstNode = internalCluster().startNode();
        assertEquals(60000L, allocateDecision.getConfiguredDelayInMillis());
        verifyClusterInfo(clusterInfo, includeDiskInfo, 3);
            assertEquals(Token.END_OBJECT, parser.currentToken());
/*
                        d.getExplanation()
                assertEquals("deciders", parser.currentName());
        // verify JSON output
            assertEquals("can_rebalance_to_other_node", parser.currentName());
 * Unless required by applicable law or agreed to in writing,
        boolean includeDiskInfo = randomBoolean();
        flushAndRefresh("idx");
        assertEquals(0, shardId.getId());
            assertEquals("can_rebalance_cluster_decisions", parser.currentName());
        try (XContentParser parser = getParser(explanation)) {
        assertEquals(AllocationStatus.NO_ATTEMPT, unassignedInfo.getLastAllocationStatus());
        }
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
                // shouldn't be able to allocate to the same node as the primary, the same shard decider should say no
            if (includeYesDecisions) {
        }
                parser.nextToken();
                assertEquals(Decision.Type.YES, d.type());
        assertFalse(moveDecision.isDecisionTaken());
import java.util.HashMap;
            assertEquals(
        assertNotNull(unassignedInfo);
        for (NodeAllocationResult nodeAllocationResult : allocateDecision.getNodeDecisions()) {
                        assertThat(
        assertTrue(isPrimary);
        assertFalse(moveDecision.isDecisionTaken());
                    );
                .cluster()
            }
            assertThat(clusterHealthResponse.getStatus().value(), lessThanOrEqualTo(ClusterHealthStatus.YELLOW.value()));
            Token token;
                parser.nextToken();
                    );
        assertFalse(moveDecision.isDecisionTaken());
            if (nodeAllocationResult.getNode().getName().equals(restartedNode)) {
        final int numPrimaries,
                                    AllocationDecision.NO_VALID_SHARD_COPY.toString(),
    ) {
                    "cannot allocate because a previous copy of the primary shard existed but can no longer be found "
        client().admin()
        assertNull(allocateDecision.getAllocationId());
                parser.nextToken();
        assertEquals(Decision.Type.YES, moveDecision.getClusterRebalanceDecision().type());
        ensureStableCluster(1);
            randomIndexState(),
import org.opensearch.cluster.routing.UnassignedInfo;
        ensureStableCluster(1);
                        + "on the nodes in the cluster",
            parser.nextToken();
            assertEquals("can_move_to_other_node", parser.currentName());
        prepareIndex(1, 0);
        // verify JSON output
            assertEquals("rebalance_explanation", parser.currentName());
        assertEquals("node_id", parser.currentName());
            );
                if (token == Token.START_OBJECT) {
            parser.nextToken();
        boolean includeYesDecisions = randomBoolean();
            assertEquals(
            logger.info("--> close the index, now the replica is stale");
        // verify shard info
        }
        assertEquals("primary", parser.currentName());
 *
        // verify current node info
                        parser.nextToken();
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
                if (token == XContentParser.Token.FIELD_NAME) {
        boolean includeDiskInfo = randomBoolean();
        final String primaryNode = internalCluster().startNode();
 * license agreements. See the NOTICE file distributed with
        assertEquals(0L, allocateDecision.getRemainingDelayInMillis());
        boolean includeYesDecisions = randomBoolean();
        parser.nextToken();
        }
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(Token.END_OBJECT, parser.nextToken());
                allocateDecision.getExplanation()
            parser.nextToken();
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
            assertEquals(0, result.getCanAllocateDecision().getDecisions().size());
            parser.nextToken();
            builder.prettyPrint();
            .indices()
        }
        assertBusy(() ->
        assertFalse(allocateDecision.isDecisionTaken());
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
                // if we are not including YES decisions, then the node holding the primary should have 1 NO decision,
        // verify cluster info
            parser.nextToken();
        boolean atLeastOneMatchingDecisionFound = false;
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);
            }
    private boolean verifyDeciders(XContentParser parser, AllocationDecision allocationDecision) throws IOException {
        assertEquals(replicaNode().getName(), currentNode.getName());
            parser.nextToken();
            assertEquals("explanation", parser.currentName());
        if (includeDiskInfo) {
                .indices()
        ensureClusterSizeConsistency(); // wait for the cluster-manager to finish processing join.
            "cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance",
 * You may obtain a copy of the License at
                    // Skip past attributes object
            parser.nextToken();
    private void verifyClusterInfo(ClusterInfo clusterInfo, boolean includeDiskInfo, int numNodes) {
        logger.info("--> starting 2 nodes");
        assertFalse(moveDecision.forceMove());
                verifyStaleShardCopyNodeDecisions(parser, 1, Collections.emptySet());
            }
        assertNull(allocateDecision.getTargetNode());
        }
        internalCluster().startNode();
        }
        // verify decision objects
        ));
            assertEquals(Token.START_OBJECT, parser.nextToken());
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", firstNode))
        assertEquals(2, moveDecision.getCurrentNodeRanking());
        assertNull(allocateDecision.getTargetNode());
        // verify JSON output
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
            assertEquals("decision", parser.currentName());
        for (Decision d : moveDecision.getClusterRebalanceDecision().getDecisions()) {
        }
            parser.nextToken();
        }
        return clusterState.getRoutingNodes().node(nodeId).node();
    private static IndexMetadata.State randomIndexState() {
        parser.nextToken();
        assertEquals(AllocationStatus.DECIDERS_NO, unassignedInfo.getLastAllocationStatus());
    }
        );
        if (includeYesDecisions) {
            "cannot move shard to another node, even though it is not allowed to remain on its current node",
        assertNotEquals(ShardRoutingState.STARTED, shardRoutingState);
                if (d.label().equals("same_shard") && nodeHoldingPrimary) {
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
                .get()
        } else {
            .get();
            assertEquals(AllocationDecision.NO.toString(), parser.text());
            verifyStaleShardCopyNodeDecisions(parser, 2, Collections.singleton(restartedNode));
            while ((token = parser.nextToken()) != Token.END_OBJECT) { // until we reach end of unassigned_info
        ShardId shardId = explanation.getShard();
            verifyNodeDecisions(parser, nodeDecisions, includeYesDecisions, true);
            parser.nextToken();
            // disk info is included, just verify the object is there
                    assertNotNull(d.getExplanation());
import org.opensearch.cluster.routing.UnassignedInfo.Reason;
            moveDecision.getExplanation()
            if (includeYesDecisions) {
        parser.nextToken();
    }
        logger.info("--> stopping the node with the primary");
            assertEquals(AllocationDecision.NO.toString(), parser.text());
                assertTrue("store info should not be present", reuseStore);
                } else {
            "rebalancing is not allowed, even though there is at least one node on which the shard can be allocated",
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        }
            parser.nextToken();
        assertNotNull(currentNode);
        parser.nextToken();
            verifyNodeDecisions(parser, nodes, includeYesDecisions, true);
        throws IOException {
            assertEquals(AllocationDecision.NO_VALID_SHARD_COPY.toString(), parser.text());
        assertTrue(isPrimary);
            assertNotNull(d.getExplanation());
import org.opensearch.common.unit.TimeValue;
        boolean includeDiskInfo = randomBoolean();
import org.opensearch.core.xcontent.XContentParser;
            .prepareAllocationExplain()
        DiscoveryNode currentNode = explanation.getCurrentNode();
                assertNotNull(nodeAllocationResult.getShardStoreInfo());
                assertEquals("cannot allocate because allocation is not permitted to any of the nodes", parser.text());
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
        parser.nextToken();
                .cluster()
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals("idx", shardId.getIndexName());
            parser.nextToken();
        assertTrue(allocateDecision.isDecisionTaken());
                assertNull(nodeAllocationResult.getShardStoreInfo().getStoreException());
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.NO, true), includeYesDecisions, false);
                "cannot allocate because information about existing shard data is still being retrieved from some of the nodes",
        boolean includeDiskInfo = randomBoolean();
            .get();
        assertEquals("idx", shardId.getIndexName());
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
        assertEquals("idx", shardId.getIndexName());
                    parser.text()
                assertNull(result.getShardStoreInfo());
        assertEquals(AllocationDecision.NO_VALID_SHARD_COPY, allocateDecision.getAllocationDecision());
            }
        assertNull(allocateDecision.getAllocationId());
        final int numNodes = expectedNodeDecisions.size();
        assertTrue(
        }
        assertFalse(moveDecision.canRebalanceCluster());
                    "node does not match index setting [index.routing.allocation.include] filters [_name:\"non_existent_node\"]",
            boolean nodeHoldingPrimary = result.getNode().getName().equals(primaryNodeName);
        assertEquals(0, shardId.getId());
        prepareIndex(
        boolean includeYesDecisions = randomBoolean();
 *
            assertThat(clusterInfo.getNodeLeastAvailableDiskUsages().size(), greaterThanOrEqualTo(0));
            if ("store".equals(parser.currentName())) {
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);
import org.opensearch.cluster.health.ClusterHealthStatus;
        assertNotNull(moveDecision.getCanRemainDecision());
        Settings replicaDataPathSettings = internalCluster().dataPathSettings(replicaNode);
        for (NodeAllocationResult result : allocateDecision.getNodeDecisions()) {
            assertEquals(AllocationDecision.YES.toString(), parser.text());
 * Licensed to Elasticsearch under one or more contributor
        nodes.remove(primaryNodeName);
 * software distributed under the License is distributed on an
        String nodeName = parser.text();
            assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));
                }
        final ActiveShardCount activeShardCount
                .getExplanation()
            Map<String, AllocationDecision> nodeDecisions = new HashMap<>();
        return createParser(explanation.toXContent(builder, ToXContent.EMPTY_PARAMS));
    }
        assertEquals(AllocationDecision.NO, allocateDecision.getAllocationDecision());
            assertEquals(Token.START_OBJECT, parser.nextToken());
        assertEquals("idx", shardId.getIndexName());
        final String clusterManagerNode = internalCluster().startNode();
                parser.nextToken();
import org.opensearch.core.xcontent.ToXContent;
                    assertTrue(
                if (d.label().equals("same_shard") && nodeHoldingPrimary) {
import static org.hamcrest.Matchers.equalTo;
                .prepareAllocationExplain()
        assertThat(allocateDecision.getRemainingDelayInMillis(), greaterThan(0L));
            while ((token = parser.nextToken()) != Token.END_OBJECT) { // until we reach end of current_node
                parser.nextToken();
            .prepareUpdateSettings("idx")
                    "cannot allocate because information about existing shard data is still being retrieved " + "from some of the nodes",
            assertEquals("rebalance_explanation", parser.currentName());
                atLeastOneMatchingDecisionFound = true;
                assertNotNull(d.getExplanation());
        assertEquals("idx", shardId.getIndexName());
            assertEquals(
        assertTrue(decisionToAllocate == AllocationDecision.AWAITING_INFO || decisionToAllocate == AllocationDecision.NO);
                .setWaitForEvents(Priority.LANGUID)
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
        final IndexMetadata.State state,
            parser.nextToken();
            } else {
 */
            index("idx", "t", Integer.toString(i), Collections.singletonMap("f1", Integer.toString(i)));
                .getShardAllocationDecision()
                .prepareHealth("idx")
        client().admin()
import org.opensearch.cluster.metadata.IndexMetadata;
        boolean includeDiskInfo = randomBoolean();
 * The OpenSearch Contributors require contributions made to
        assertEquals(AllocationDecision.WORSE_BALANCE, result.getNodeDecision());
        assertEquals(AllocationDecision.ALLOCATION_DELAYED, allocateDecision.getAllocationDecision());
        return runExplain(primary, null, includeYesDecisions, includeDiskInfo);
                .get();
    }
                .get()
        try (XContentParser parser = getParser(explanation)) {
        for (Decision d : result.getCanAllocateDecision().getDecisions()) {
            for (String nodeName : internalCluster().getNodeNames()) {
                assertEquals("weight_ranking", parser.currentName());
            moveDecision.getExplanation()
            } else {
            .get();
            assertEquals("rebalancing is not allowed", parser.text());
        assertTrue(
            parser.nextToken();
            } else {
                        d.getExplanation()
        assertFalse(moveDecision.forceMove());
            parser.nextToken();
        // verify shard info
        assertEquals("node_allocation_decisions", parser.currentName());
            assertEquals("can_remain_on_current_node", parser.currentName());
        // verify node decisions
        String restartedNode = internalCluster().startDataOnlyNode(replicaDataPathSettings);
                            || parser.currentName().equals("weight_ranking")
            assertEquals("move_explanation", parser.currentName());
        assertEquals(AllocationDecision.YES, result.getNodeDecision());
        assertEquals("node_name", parser.currentName());
                } else if (d.label().equals("filter") && nodeHoldingPrimary == false) {
            parser.nextToken();
                "rebalancing is not allowed, even though there is at least one node on which the shard can be allocated",
        ensureStableCluster(2);
                    if (parser.currentName().equals("attributes")) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                parser.nextToken();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(0)));
            .getExplanation();
        } else {
            assertEquals(Token.END_OBJECT, parser.nextToken());
        assertEquals(Reason.NODE_LEFT, unassignedInfo.getReason());
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", "non_existent_node"))
        DiscoveryNode currentNode = explanation.getCurrentNode();
        assertNotNull(moveDecision.getCanRemainDecision());
                        }
import org.opensearch.common.settings.Settings;
            parser.nextToken();
                parser.nextToken();
                    + "found on the nodes in the cluster",
        }
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
                    assertTrue(token.isValue());
        // verify cluster info
            parser.nextToken();
        }
            if (nodeHoldingPrimary) {
    }
        if (allocateDecision.getAllocationDecision() == AllocationDecision.NO_VALID_SHARD_COPY) {
                assertEquals("can_allocate", parser.currentName());
        parser.nextToken();
    }
            assertEquals("can_rebalance_cluster_decisions", parser.currentName());
            Token token;
        for (Decision d : result.getCanAllocateDecision().getDecisions()) {
        ensureStableCluster(2);
import org.opensearch.test.InternalTestCluster;
            }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode().getName()));
                    );
        client().admin()
        assertEquals(0, shardId.getId());
                );
            );
        String primaryNodeName = primaryNodeName();
    }
package org.opensearch.action.admin.cluster.allocation;
                assertEquals(nodeHoldingPrimary ? 1 : 0, result.getCanAllocateDecision().getDecisions().size());
            parser.nextToken();
        assertEquals(AllocationStatus.NO_ATTEMPT, unassignedInfo.getLastAllocationStatus());
        }
        assertEquals(Reason.NODE_LEFT, unassignedInfo.getReason());
        boolean includeDiskInfo = randomBoolean();
        // verify unassigned info
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    }
        while (parser.nextToken() != Token.END_ARRAY) {
        // verify current node info
        }
            assertThat(clusterHealthResponse.getStatus().value(), lessThanOrEqualTo(ClusterHealthStatus.YELLOW.value()));
        // verify unassigned info
    public void testUnassignedPrimaryWithExistingIndex() throws Exception {
            }
        assertFalse(allocateDecision.isDecisionTaken());
                assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
        for (Decision d : moveDecision.getClusterRebalanceDecision().getDecisions()) {
        // verify node decisions
                assertFalse(parser.booleanValue());
            assertEquals(1, result.getWeightRanking());
        internalCluster().startNode();
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("shard", parser.currentName());
        // verify node decisions
        return atLeastOneMatchingDecisionFound;
            assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));
        return randomFrom(IndexMetadata.State.values());
            assertEquals(AllocationDecision.YES.toString(), parser.text());
        parser.nextToken();
            if (foundStores.contains(nodeName)) {
        } else {
        }
                parser.nextToken();
                } else {
        ensureStableCluster(1);
        assertTrue(isPrimary);
            Settings.builder()
            containsString("despite being allowed to allocate the shard to at least one other node")
        // verify decision objects
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
                assertNull(nodeAllocationResult.getShardStoreInfo().getAllocationId());
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
            for (Decision d : result.getCanAllocateDecision().getDecisions()) {
                || unassignedInfo.getLastAllocationStatus() == AllocationStatus.NO_VALID_SHARD_COPY
            IndexMetadata.State.OPEN,
    private XContentParser getParser(ClusterAllocationExplanation explanation) throws IOException {
        logger.info("--> starting a single node");
                        parser.currentName().equals("id")
        assertNull(unassignedInfo);
                }
            } else {
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.UNASSIGNED);
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
                );
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.NO, false), includeYesDecisions, false);
        DiscoveryNode currentNode = explanation.getCurrentNode();
        // verify cluster info
    private void indexData() {
        // verify cluster info
            assertNull(clusterInfo);
        } else {
            String[] currentNodes = internalCluster().getNodeNames();
        }
            } else {
                    d.getExplanation()
                }
            parser.nextToken();
                assertThat(parser.intValue(), greaterThan(0));
            Settings.builder().put("index.routing.allocation.exclude._name", excludedNode).build(),
                            parser.text(),
                .setShard(0)
        ShardRoutingState shardRoutingState = explanation.getShardState();
                assertEquals(AllocationDecision.YES, result.getNodeDecision());
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
        assertEquals("idx", shardId.getIndexName());
            parser.nextToken();
            verifyShardInfo(parser, false, includeDiskInfo, ShardRoutingState.STARTED);
        boolean reuseStore
            if (allocationDecision == AllocationDecision.NO || allocationDecision == AllocationDecision.THROTTLED || includeYesDecisions) {
            }
            }
        assertEquals(Token.START_OBJECT, parser.nextToken());
                parser.nextToken();
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals(1, moveDecision.getCurrentNodeRanking());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    public void testCannotAllocateStaleReplicaExplanation() throws Exception {
        assertFalse(allocateDecision.isDecisionTaken());
            }
        if (state == ShardRoutingState.UNASSIGNED) {
                }
import org.opensearch.cluster.routing.allocation.MoveDecision;
                nodeDecisions.put(nodeName, AllocationDecision.NO);
            assertEquals(Token.START_OBJECT, parser.nextToken());
            }
        assertNotNull(result.getNode());
        assertNull(currentNode);
                    assertEquals(Decision.Type.NO, d.type());
        ClusterInfo clusterInfo = explanation.getClusterInfo();
                assertNotNull(d.getExplanation());
        DiscoveryNode currentNode = explanation.getCurrentNode();
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        assertFalse(isPrimary);
                parser.text()
 * Tests for the cluster allocation explanation
            assertNotNull(d.getExplanation());
        // verify shard info
            parser.nextToken();
        logger.info("--> stop the node with the primary");
            parser.nextToken();
                "cannot allocate because information about existing shard data is still being retrieved from some of the nodes",
        assertNotNull(moveDecision.getClusterRebalanceDecision());
        // verify shard info
        internalCluster().startNode();
        client().admin()
        DiscoveryNode currentNode = explanation.getCurrentNode();
            if (d.label().equals("enable")) {
                assertEquals(AllocationDecision.NO_VALID_SHARD_COPY.toString(), parser.text());
        // verify decision object
            );
            .prepareUpdateSettings()
                .setTimeout(TimeValue.timeValueSeconds(30))
        assertTrue(moveDecision.isDecisionTaken());
                }
        ensureStableCluster(2);
            assertEquals(AllocationDecision.YES.toString(), parser.text());
                                )
            assertEquals(AllocationDecision.NO.toString(), parser.text());
import org.opensearch.action.support.ActiveShardCount;
        ShardRoutingState shardRoutingState = explanation.getShardState();
            client().admin()
        // verify decision objects
        assertEquals(
                .cluster()
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.YES, true), includeYesDecisions, false);
        assertNull(allocateDecision.getAllocationId());
                                    AllocationDecision.NO_ATTEMPT.toString()
        String primaryNodeName = primaryNodeName();
 */
        // verify node decisions
        }
            );
        assertEquals(0L, allocateDecision.getConfiguredDelayInMillis());
                .getAllocationDecision()
            parser.nextToken();
import org.opensearch.cluster.routing.allocation.AllocationDecision;
        } else {
            assertEquals(AllocationDecision.NO.toString(), parser.text());
    }
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
            assertEquals(Token.START_OBJECT, parser.currentToken());
                    assertEquals(Decision.Type.NO, d.type());
        parser.nextToken();
    private Map<String, AllocationDecision> allNodeDecisions(AllocationDecision allocationDecision, boolean removePrimary) {
        assertNotNull(unassignedInfo);
    public void testUnassignedReplicaDelayedAllocation() throws Exception {
                parser.nextToken();
            verifyDeciders(parser, AllocationDecision.NO);
        ClusterInfo clusterInfo = explanation.getClusterInfo();
                .getAllocateDecision()
        for (Decision d : moveDecision.getClusterRebalanceDecision().getDecisions()) {
        // verify unassigned info
    public void testAssignedReplicaOnSpecificNode() throws Exception {
            logger.debug("--> explain json output: \n{}", explanation.toXContent(builder, ToXContent.EMPTY_PARAMS).toString());
        // verify shard info
        boolean includeYesDecisions = randomBoolean();
import org.opensearch.cluster.ClusterInfo;
            .prepareUpdateSettings("idx")
        // verifying cluster rebalance decision object
        assertNotNull(currentNode);
        for (String nodeName : allNodes) {
        // verify unassigned info
                .prepareAllocationExplain()
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
            parser.nextToken();
        logger.info("--> shutting down all nodes except the one that holds the primary");
        // verify JSON output
        boolean includeYesDecisions = randomBoolean();
        if (state == IndexMetadata.State.CLOSE) {
                .cluster()
                        .put(settings)
        assertThat(replicaNode().getName(), equalTo(replicaNode));
            assertNotNull(result.getNode());
        NodeAllocationResult result = moveDecision.getNodeDecisions().get(0);
                .setWaitForActiveShards(ActiveShardCount.ONE)
        assertNull(allocateDecision.getAllocationId());
        boolean includeDiskInfo = randomBoolean();
        // verify shard info
                || allocateDecision.getAllocationDecision() == AllocationDecision.AWAITING_INFO
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);
                assertNull(nodeAllocationResult.getShardStoreInfo().getStoreException());
            assertEquals("can_allocate", parser.currentName());
            .cluster()
            if (d.label().equals("filter")) {
            verifyNodeDecisions(parser, allNodeDecisions(AllocationDecision.NO, true), includeYesDecisions, false);
import org.opensearch.cluster.routing.ShardRoutingState;
        assertEquals("idx", shardId.getIndexName());
                if (d.label().equals("filter")) {
                            + "filters [_name:\""
            assertEquals(AllocationDecision.NO.toString(), parser.text());
            );
                    d.getExplanation()
                                oneOf(
        assertEquals(
        final Settings settings,
                );
        assertNotNull(result.getNode());
        logger.info("--> starting another node, with the rebalance threshold so high, it should not get any shards");
            );
 * this file be licensed under the Apache-2.0 license or a
        } else {
        boolean includeYesDecisions,
                        "decision was " + allocationDecision + " but found no node's with that decision",
    public void testAllocationFilteringOnIndexCreation() throws Exception {
        assertFalse(moveDecision.isDecisionTaken());
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
        assertTrue(isPrimary);
        assertEquals(1, moveDecision.getNodeDecisions().size());
                allocateDecision.getExplanation()
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        assertNotNull(moveDecision.getCanRemainDecision());
        // verify decision objects
        assertEquals(2, moveDecision.getNodeDecisions().size());
        // verify cluster info
        return explanation;
    }
        assertNull(allocateDecision.getTargetNode());
    }
        assertFalse(moveDecision.isDecisionTaken());
            verifyNodeDecisions(parser, nodeDecisions, includeYesDecisions, false);
        logger.info("--> starting 3 nodes");
        assertEquals(0, shardId.getId());
        ShardId shardId = explanation.getShard();
        assertTrue(moveDecision.canRebalanceCluster());
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        // verify decision object
    private String primaryNodeName() {
                                    AllocationDecision.NO.toString(),
            parser.nextToken();
                assertEquals(
        assertEquals(ShardRoutingState.UNASSIGNED, shardRoutingState);
        ShardRoutingState shardRoutingState = explanation.getShardState();
        Set<String> allNodes = Sets.newHashSet(internalCluster().getNodeNames());
        for (int i = 0; i < numNodes; i++) {
                .setTimeout(TimeValue.timeValueSeconds(30))
        // verify cluster info
            .indices()
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
        boolean isPrimary = explanation.isPrimary();
        client().admin()
        }
        ShardRoutingState shardRoutingState = explanation.getShardState();
        assertNull(unassignedInfo);
        internalCluster().startNodes(2);
        for (NodeAllocationResult result : moveDecision.getNodeDecisions()) {
                assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
        DiscoveryNode currentNode = explanation.getCurrentNode();
            String decisionText = parser.text();
    }
        assertEquals("rebalancing is not allowed", moveDecision.getExplanation());
        if (includeYesDecisions) {
        // verify unassigned info
                    d.getExplanation()
        assertEquals(0, parser.intValue());
        parser.nextToken();
        ShardId shardId = explanation.getShard();
            Map<String, AllocationDecision> nodes = new HashMap<>();
                assertEquals(AllocationDecision.NO, result.getNodeDecision());
        assertTrue(moveDecision.isDecisionTaken());
            builder.humanReadable(true);
    private void verifyNodeDecisions(
        assertTrue(moveDecision.canRemain());
        prepareIndex(5, 0);
            assertEquals(60000L, parser.longValue());
        ShardId shardId = explanation.getShard();
            } else {
            assertEquals("can_rebalance_cluster", parser.currentName());
        logger.info("--> starting another node, with rebalancing disabled, it should get no shards");
                    assertNotEquals("delayed", parser.currentName()); // we should never display "delayed" from unassigned info
        // verify decision object
                allocateDecision.getExplanation()
        }
            assertEquals(Token.END_OBJECT, parser.nextToken());
                assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));
            assertNotNull(result.getNode());
        assertEquals(Decision.Type.NO, moveDecision.getCanRemainDecision().type());
            parser.nextToken();
            parser.nextToken();
import java.util.Set;
        // verify current node info
            allocateDecision.getExplanation(),
        assertTrue(moveDecision.canRemain());
        }
            ClusterAllocationExplanation explanation = client().admin()
                parser.nextToken();
        );
        // verify shard info
                    assertEquals(Decision.Type.YES, d.type());
                assertNotNull(nodeAllocationResult.getShardStoreInfo());
        assertTrue(moveDecision.isDecisionTaken());
        assertFalse(moveDecision.forceMove());
                            parser.nextToken();
        List<String> nodes = internalCluster().startNodes(3);
        assertEquals(Token.START_ARRAY, parser.nextToken());
        boolean isPrimary = explanation.isPrimary();
        assertNull(moveDecision.getTargetNode());
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
            while (numObjects > 0) {
            ActiveShardCount.ONE
 * KIND, either express or implied.  See the License for the
                .prepareCreate("idx")
                .setWaitForActiveShards(activeShardCount)
            parser.nextToken();
        assertTrue(moveDecision.canRemain());
            for (String nodeName : internalCluster().getNodeNames()) {
import org.opensearch.cluster.node.DiscoveryNode;
                .setWaitForNoInitializingShards(true)
                .setPrimary(true)
        assertEquals("node_decision", parser.currentName());
            assertAcked(client().admin().indices().prepareClose("idx"));
        assertFalse(moveDecision.forceMove());
            String nodeName = verifyNodeDecisionPrologue(parser);
                assertEquals(
            }
            parser.nextToken();
            .get();
        ShardId shardId = explanation.getShard();
    public void testUnassignedReplicaWithPriorCopy() throws Exception {
            assertEquals(Decision.Type.YES, d.type());
        );
        logger.info("--> setting allocation filtering to only allow allocation on the currently running node");
        prepareIndex(1, 1);
            parser.nextToken();
            assertEquals("can_allocate", parser.currentName());
        );
            for (Decision d : result.getCanAllocateDecision().getDecisions()) {
            }
        assertFalse(allocateDecision.isDecisionTaken());
            assertEquals("cannot allocate because all found copies of the shard are either stale or corrupt", parser.text());
            parser.nextToken();
            parser.nextToken();
                    assertTrue(
                verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.UNASSIGNED);
            );
            parser.nextToken();
        assertEquals(state.toString().toLowerCase(Locale.ROOT), parser.text());
            1,
            assertNotNull(d.getExplanation());
            }
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.STARTED);
            assertEquals(AllocationDecision.NO.toString(), parser.text());
            }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
            parser.nextToken();
                            + "\"]",
            parser.nextToken();
        assertEquals(Token.START_OBJECT, parser.currentToken());
        boolean isPrimary = explanation.isPrimary();
            assertEquals("cluster_info", parser.currentName());
                assertEquals("found", parser.currentName());
        assertEquals(Token.END_ARRAY, parser.nextToken());
                assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));
        boolean isPrimary = explanation.isPrimary();
        assertEquals(Token.END_ARRAY, parser.nextToken());
        );
            assertNotNull(parser.text());
            assertEquals(
        assertNotNull(moveDecision.getCanRemainDecision());
        assertEquals(1, result.getWeightRanking());
            assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
        for (int i = 0; i < numNodes; i++) {
                } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            parser.nextToken();
            assertEquals("cannot allocate because allocation is not permitted to any of the nodes", allocateDecision.getExplanation());
            assertEquals("allocate_explanation", parser.currentName());
        assertEquals(0L, allocateDecision.getRemainingDelayInMillis());
}
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        assertEquals(0, shardId.getId());
        assertEquals(1, moveDecision.getNodeDecisions().size());
        }
                assertFalse(nodeAllocationResult.getShardStoreInfo().isInSync());
                assertEquals("in_sync", parser.currentName());
        assertEquals(1, moveDecision.getNodeDecisions().size());
            .setIncludeDiskInfo(includeDiskInfo)
            }
            );
        // verify decision object
        // verify decision object
        }
    private ClusterAllocationExplanation runExplain(boolean primary, String nodeId, boolean includeYesDecisions, boolean includeDiskInfo)
        DiscoveryNode currentNode = explanation.getCurrentNode();
            AllocationDecision allocationDecision = expectedNodeDecisions.get(nodeName);
            assertNotNull(decisionText);
        try (XContentParser parser = getParser(explanation)) {
        logger.info("--> starting 3 nodes");
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", primaryNodeName))
                "cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance",
        if (indexState == IndexMetadata.State.OPEN) {
                parser.nextToken();
        assertFalse(moveDecision.forceMove());
            parser.nextToken();
            assertTrue(
        // verify JSON output
        try (XContentParser parser = getParser(explanation)) {
            );
                assertNotNull(nodeAllocationResult.getShardStoreInfo().getAllocationId());
        assertEquals(0L, allocateDecision.getRemainingDelayInMillis());
            if (reuseStore == false) {
                .build(),
            parser.nextToken();
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
        return clusterState.getRoutingNodes().node(nodeId).node().getName();
 */
    public void testAllocationFilteringPreventsShardMove() throws Exception {
        ClusterAllocationExplanation explanation = client().admin()
        assertNull(moveDecision.getTargetNode());
        logger.info("--> observing delayed allocation...");
            assertEquals("can_rebalance_to_other_node", parser.currentName());
            parser.nextToken();
            parser.nextToken();
            verifyShardInfo(parser, false, includeDiskInfo, ShardRoutingState.UNASSIGNED);
        assertEquals(Reason.NODE_LEFT, unassignedInfo.getReason());
            indexData();
        logger.info("--> stop node with the replica shard");
        }
            assertEquals(Token.START_OBJECT, parser.nextToken());
            assertEquals("can_allocate", parser.currentName());
        ClusterAllocationExplanation explanation = runExplain(false, replicaNode().getId(), includeYesDecisions, includeDiskInfo);
    }
import org.opensearch.cluster.ClusterState;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName()));
            assertEquals(AllocationDecision.YES.toString(), parser.text());
        // verifying cluster rebalance decision object
            assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(0));
                .put("index.routing.allocation.exclude._name", clusterManagerNode)
            assertEquals(Token.END_OBJECT, parser.nextToken());
        parser.nextToken();
            assertEquals("store", parser.currentName());
        // verify decision objects
            parser.nextToken();
        // verify shard info
            }
        assertEquals(AllocationDecision.NO, result.getNodeDecision());
        assertNotEquals(ShardRoutingState.STARTED, shardRoutingState);
        for (Decision d : moveDecision.getCanRemainDecision().getDecisions()) {
            assertNotNull(result.getNode());
        }
            assertEquals(AllocationDecision.NO.toString(), parser.text());
        logger.info("--> creating an index with 1 primary, 0 replicas, with allocation filtering so the primary can't be assigned");
        assertNull(currentNode);
import static org.hamcrest.Matchers.greaterThan;
            parser.nextToken();
            1,
                    assertNotNull(d.getExplanation());
        // verify unassigned info
    }
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
            parser.nextToken();
        assertNotNull(moveDecision.getClusterRebalanceDecision());
        String excludedNode = nodes.get(randomIntBetween(0, 2));
        assertNull(allocateDecision.getTargetNode());
        client().admin()
                assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
            parser.nextToken();
        }
                );
            assertEquals(Decision.Type.YES, d.type());
            assertEquals("configured_delay_in_millis", parser.currentName());
            Map<String, AllocationDecision> nodeDecisions = new HashMap<>();
        final int numReplicas,
        String primaryNodeName = primaryNodeName();
/*
        ShardId shardId = explanation.getShard();
        // verify current node info
        ClusterInfo clusterInfo = explanation.getClusterInfo();
        assertEquals(2, allocateDecision.getNodeDecisions().size());
            assertEquals("rebalance_explanation", parser.currentName());
        boolean isPrimary = explanation.isPrimary();
        ClusterInfo clusterInfo = explanation.getClusterInfo();
        if (activeShardCount != ActiveShardCount.NONE) {
        }
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.STARTED);
                assertEquals(
        prepareIndex(randomIndexState(), numPrimaries, numReplicas, Settings.EMPTY, ActiveShardCount.ALL);
                "cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance",
            } else {
        // verify JSON output
            parser.nextToken();
        ensureStableCluster(2);
        assertThat(
import static org.hamcrest.Matchers.oneOf;
    private void prepareIndex(
    }
        internalCluster().startNodes(2);
        parser.nextToken();
                        while (!parser.nextToken().equals(Token.END_OBJECT)) {
        ShardRoutingState shardRoutingState = explanation.getShardState();
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        assertEquals(
        internalCluster().startNodes(2);
        assertEquals(Token.START_ARRAY, parser.nextToken());
                        .put("index.number_of_shards", numPrimaries)
                .setWaitForActiveShards(activeShardCount)
        assertEquals(
        // verify node decisions
        DiscoveryNode currentNode = explanation.getCurrentNode();
        assertNotNull(result.getNode());
                if (allocationDecision == AllocationDecision.NO || allocationDecision == AllocationDecision.THROTTLED) {
        assertEquals(1, moveDecision.getNodeDecisions().size());
    }
    }
        boolean isPrimary = explanation.isPrimary();
                assertThat(parser.longValue(), greaterThan(0L));
            parser.nextToken();
        assertEquals(Token.START_ARRAY, parser.nextToken());
            assertEquals(ShardRoutingState.STARTED, state);
            }
                parser.nextToken();
        assertEquals("idx", shardId.getIndexName());
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(1)));
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.STARTED);
                    "node does not match index setting [index.routing.allocation.include] filters [_name:\"non_existent_node\"]",
        });
    public void testRebalancingNotAllowed() throws Exception {
            parser.nextToken();
            verifyShardInfo(parser, false, includeDiskInfo, ShardRoutingState.UNASSIGNED);
            for (Decision d : result.getCanAllocateDecision().getDecisions()) {
    }
        }
import org.opensearch.common.util.set.Sets;
        // verify JSON output
                .setWaitForEvents(Priority.LANGUID)
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
        assertEquals("cannot allocate because allocation is not permitted to any of the nodes", allocateDecision.getExplanation());
        assertNull(moveDecision.getTargetNode());
        assertNotNull(moveDecision.getCanRemainDecision());
        assertEquals(3, allocateDecision.getNodeDecisions().size());
        ClusterAllocationExplanation explanation = runExplain(false, includeYesDecisions, includeDiskInfo);
                assertNotNull(parser.text());
                        "node does not match index setting [index.routing.allocation.include] "
            } else {
                assertFalse(parser.booleanValue());
                encounteredNo = true;
                assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));
                    assertEquals(Decision.Type.NO, d.type());
                    assertEquals(
        ShardId shardId = explanation.getShard();
            assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(0));
        logger.info("--> starting a single node");
        boolean isPrimary = explanation.isPrimary();
                assertEquals(Token.START_OBJECT, parser.nextToken());
        logger.info("--> stopping the node with the replica");
            1,
                // no shard data was found on the node
                    assertThat(d.label(), is(oneOf("filter", "same_shard")));
            assertEquals(Token.END_OBJECT, parser.nextToken());
            parser.nextToken();
        logger.info("--> starting 2 nodes");
            assertEquals("can_remain_decisions", parser.currentName());
        logger.info("--> starting 3 nodes");
            } else {
        assertNotNull(parser.text());
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
            parser.nextToken();
            assertEquals(Token.END_OBJECT, parser.nextToken());
    private void prepareIndex(final int numPrimaries, final int numReplicas) {
        assertEquals(2, allocateDecision.getNodeDecisions().size());
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
                boolean atLeastOneMatchingDecisionFound = verifyDeciders(parser, allocationDecision);
            final ClusterHealthResponse clusterHealthResponse = client().admin()
                if (d.type() == Decision.Type.NO) {
                );
                assertEquals(
            String nodeName = verifyNodeDecisionPrologue(parser);
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
        assertEquals(1, result.getWeightRanking());
        assertNotEquals(ShardRoutingState.STARTED, shardState);
public final class ClusterAllocationExplainIT extends OpenSearchIntegTestCase {
        AllocationDecision decisionToAllocate = allocateDecision.getAllocationDecision();
            verifyDeciders(parser, AllocationDecision.NO);
        assertTrue(moveDecision.canRemain());
        }
                        break;
        Settings node1DataPathSettings = internalCluster().dataPathSettings(nodes.get(1));
        assertEquals("idx", parser.text());
        // verify JSON output
                .getExplanation();
        assertEquals(Decision.Type.NO, moveDecision.getClusterRebalanceDecision().type());
        assertNotNull(unassignedInfo);
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
        // verify shard info
            }
                // shard data was found on the node, but it is stale
        ShardId shardId = explanation.getShard();
        assertEquals(0L, allocateDecision.getConfiguredDelayInMillis());
            .setPrimary(primary)
                "cannot allocate because a previous copy of the primary shard existed but can no longer be "
        assertTrue(allocateDecision.isDecisionTaken());
        for (Decision d : result.getCanAllocateDecision().getDecisions()) {
        assertTrue(isPrimary);
            .get()
            AllocationDecision.ALLOCATION_DELAYED,
            parser.nextToken();
        XContentBuilder builder = JsonXContent.contentBuilder();
            nodes.put(currentNodes[0].equals(primaryNodeName) ? currentNodes[1] : currentNodes[0], AllocationDecision.YES);
                assertEquals(Decision.Type.YES, d.type());
        );
import org.opensearch.cluster.routing.allocation.decider.Decision;
        assertNotNull(currentNode);
            // verify JSON output
            assertEquals(Token.END_OBJECT, parser.nextToken());
                allocationDecision.equals(AllocationDecision.NO.toString())
        assertEquals(0, shardId.getId());
            String allocationDecision = parser.text();
        logger.info("--> starting another node, with filtering not allowing allocation to the new node, it should not get any shards");
            assertEquals(AllocationDecision.YES.toString(), parser.text());
                assertFalse("encountered a YES node decision after a NO node decision - sort order is wrong", encounteredNo);
        );
        // verify unassigned info
            assertEquals("can_rebalance_cluster", parser.currentName());
            ActiveShardCount.from(2)
                parser.nextToken();
                    assertEquals(Decision.Type.YES, d.type());
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", (String) null))
    public void testBetterBalanceButCannotAllocate() throws Exception {
            Settings.builder().put("index.routing.allocation.include._name", "non_existent_node").build(),
        assertThat(primaryNodeName(), equalTo(primaryNode));
            } else {
        assertNull(unassignedInfo);
            nodeDecisions.put(nodeName, allocationDecision);
        ensureStableCluster(1);
                    }
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
        allNodes.remove(removePrimary ? primaryNodeName() : replicaNode().getName());
            parser.nextToken();
        return nodeDecisions;
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
            .get();
        logger.info("--> disabling rebalancing on the index");
                assertThat(result.getCanAllocateDecision().getDecisions().size(), greaterThan(1));
        assertNotNull(currentNode);
            parser.nextToken();
    private ClusterAllocationExplanation runExplain(boolean primary, boolean includeYesDecisions, boolean includeDiskInfo)
        ensureStableCluster(1);
            parser.nextToken();
        boolean isPrimary = explanation.isPrimary();
    public void testWorseBalance() throws Exception {
    private void verifyShardInfo(XContentParser parser, boolean primary, boolean includeDiskInfo, ShardRoutingState state)
        assertEquals(Reason.INDEX_CREATED, unassignedInfo.getReason());
            assertEquals("rebalance_explanation", parser.currentName());
        assertEquals("transport_address", parser.currentName());
            parser.nextToken();
                )
        assertFalse(isPrimary);
        assertNotNull(unassignedInfo);
            parser.nextToken();
            assertEquals(Token.END_OBJECT, parser.currentToken());
        ClusterInfo clusterInfo = explanation.getClusterInfo();
        assertNull(currentNode);
        assertNull(currentNode);
 * specific language governing permissions and limitations
        // verify current node info
 * GitHub history for details.
        assertEquals("node_attributes", parser.currentName());
                }
import java.util.Collections;
                .setPrimary(false)
            .prepareUpdateSettings("idx")
            .indices()
            assertEquals("cannot move shard to another node, even though it is not allowed to remain on its current node", parser.text());
        if (includeYesDecisions) {
        }
        assertNotNull(result.getNode());
        // verify unassigned info
        XContentParser parser,
                parser.text()
            .indices()
            .setShard(0)
                            || parser.currentName().equals("name")
        );
                AllocationDecision.NO_VALID_SHARD_COPY,
                assertEquals("no rebalancing is allowed due to index setting [index.routing.rebalance.enable=none]", d.getExplanation());
            assertNotNull(parser.text());
        return nodeName;
 * Modifications Copyright OpenSearch Contributors. See
        ClusterInfo clusterInfo = explanation.getClusterInfo();
        }
                    assertNotNull(parser.text());
 * compatible open source license.
        prepareIndex(5, 0);
        throws Exception {
                    if (parser.currentName().equals("last_allocation_status")) {
    }
        ensureStableCluster(3);
        assertNotNull(moveDecision.getClusterRebalanceDecision());
        logger.info("--> creating a {} index with {} primary, {} replicas", state, numPrimaries, numReplicas);
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());
            }
        parser.nextToken();
        final String replicaNode = internalCluster().startNode();
                assertNotNull(d.getExplanation());
                parser.text()
        logger.info("--> restarting the stopped nodes");
    }
            assertThat(clusterInfo.getNodeLeastAvailableDiskUsages().size(), lessThanOrEqualTo(numNodes));
            assertEquals(Token.END_OBJECT, parser.nextToken());
        // verifying cluster rebalance decision object
            final ClusterHealthResponse clusterHealthResponse = client().admin()
        // verify current node info
        } else {
            .cluster()
            parser.nextToken();
        assertEquals(2, allocateDecision.getNodeDecisions().size());
            verifyShardInfo(parser, true, includeDiskInfo, ShardRoutingState.STARTED);
                assertEquals("allocate_explanation", parser.currentName());
            allocateDecision.getAllocationDecision() == AllocationDecision.NO_VALID_SHARD_COPY
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
        ShardRoutingState shardRoutingState = explanation.getShardState();
        // verify cluster info
            assertEquals(Token.END_OBJECT, parser.nextToken());
        ClusterInfo clusterInfo = explanation.getClusterInfo();
import static org.hamcrest.Matchers.is;
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());
                .put("index.routing.allocation.include._name", primaryNode)
            parser.nextToken();
            parser.nextToken();
            assertEquals("can_remain_on_current_node", parser.currentName());
            .setCurrentNode(nodeId)
            }
        logger.info("--> restart the node with the stale replica");
        // verify current node info
                assertEquals(Decision.Type.NO, d.type());
    private String verifyNodeDecisionPrologue(XContentParser parser) throws IOException {
                    Settings.builder()
        assertEquals(Decision.Type.YES, moveDecision.getClusterRebalanceDecision().type());
        // verify shard info
            parser.nextToken();
                .get()
        assertTrue(moveDecision.isDecisionTaken());
        assertFalse(isPrimary);
            } else {
                .setSettings(
        // verifying cluster rebalance decision object
            assertThat(parser.longValue(), greaterThan(0L));
/*
        boolean includeDiskInfo = randomBoolean();
            if (includeYesDecisions) {
import java.util.List;
                .setIndex("idx")
        logger.info("--> setting up allocation filtering to prevent allocation to both nodes");
        assertEquals(0, shardId.getId());
            }
        boolean includeYesDecisions = randomBoolean();
            2,
            parser.nextToken();
            } else {
            }
        DiscoveryNode currentNode = explanation.getCurrentNode();
            }
        assertFalse(moveDecision.canRebalanceCluster());
                assertNotNull(d.getExplanation());
/**
        try (XContentParser parser = getParser(explanation)) {
        Settings node0DataPathSettings = internalCluster().dataPathSettings(nodes.get(0));
        throws Exception {
        assertNull(currentNode);
        assertNull(moveDecision.getClusterRebalanceDecision());
            assertEquals("can_rebalance_cluster", parser.currentName());
        ShardRoutingState shardRoutingState = explanation.getShardState();
        assertNotNull(parser.text());
            assertEquals("allocate_explanation", parser.currentName());
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
                assertEquals(Decision.Type.YES, d.type());
        assertEquals(Decision.Type.NO, moveDecision.getClusterRebalanceDecision().type());
        }
 * under the License.
                    assertEquals(
        verifyClusterInfo(clusterInfo, includeDiskInfo, 1);
        assertNotNull(currentNode);
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());
            assertEquals("current_node", parser.currentName());
        assertEquals(2, moveDecision.getCurrentNodeRanking());
        try (XContentParser parser = getParser(explanation)) {
                    || allocationDecision.equals(AllocationDecision.AWAITING_INFO.toString())
    }
            assertEquals("decider", parser.currentName());
        // verify cluster info
        // wait until the system has fetched shard data and we know there is no valid shard copy
        Map<String, AllocationDecision> nodeDecisions = new HashMap<>();
        verifyClusterInfo(clusterInfo, includeDiskInfo, 2);
        } else {
            assertEquals(Token.END_OBJECT, parser.nextToken());
        // verifying can remain decision object
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        // verify JSON output
                explanation.getShardAllocationDecision().getAllocateDecision().getAllocationDecision()
        assertNotEquals(ShardRoutingState.STARTED, shardRoutingState);
            assertEquals("allocate_explanation", parser.currentName());
            0,
import java.util.Locale;
        String nodeId = clusterState.getRoutingTable().index("idx").shard(0).primaryShard().currentNodeId();
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());
                allocationDecision.equals(AllocationDecision.NO.toString())
                        atLeastOneMatchingDecisionFound
        assertFalse(moveDecision.canRemain());
        ShardRoutingState shardState = explanation.getShardState();
                    "node does not match index setting [index.routing.allocation.include] filters [_name:\"" + primaryNodeName + "\"]",
        assertAcked(
        if (includeDiskInfo) {
            logger.info("--> index more data, now the replica is stale");
            assertEquals(
        assertFalse(moveDecision.canRebalanceCluster());
                    "cannot allocate because information about existing shard data is still being retrieved " + "from some of the nodes",
        assertNotNull(nodeName);
        assertEquals(0, shardId.getId());
        // skip past node_attributes object
                        "node does not match index setting [index.routing.allocation.include] filters " + "[_name:\"non_existent_node\"]",
            }
        logger.info("--> starting a single node");
        }
        for (NodeAllocationResult result : allocateDecision.getNodeDecisions()) {
        // verify cluster info
import static org.hamcrest.Matchers.containsString;
        } else {
                    }
            boolean nodeHoldingPrimary = result.getNode().getName().equals(primaryNodeName);
        assertNull(moveDecision.getTargetNode());
                .setIndex("idx")
        prepareIndex(
                            is(
            client().admin()
        ensureGreen();
        parser.nextToken();
        prepareIndex(1, 0);
        // verify current node info
            .indices()
        logger.info("--> setting up allocation filtering to only allow allocation to the current node");
            assertAcked(client().admin().indices().prepareClose("idx"));
        assertEquals(primary, parser.booleanValue());
            assertEquals(Decision.Type.YES, d.type());
        // start replica node first, so it's path will be used first when we start a node after
        assertTrue(moveDecision.isDecisionTaken());
            for (Decision d : result.getCanAllocateDecision().getDecisions()) {
            assertEquals(0, result.getCanAllocateDecision().getDecisions().size());
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
            nodes.put(primaryNodeName, AllocationDecision.NO);
        Map<String, AllocationDecision> expectedNodeDecisions,
            assertTrue(
            .get();
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        internalCluster().startNode();
            }
                }
        ShardRoutingState shardRoutingState = explanation.getShardState();
        assertEquals(AllocationDecision.NO, moveDecision.getAllocationDecision());
        ShardId shardId = explanation.getShard();
            }
            assertEquals(AllocationDecision.ALLOCATION_DELAYED.toString(), parser.text());
        assertEquals("idx", shardId.getIndexName());
        prepareIndex(
                    assertThat(d.getExplanation(), startsWith("a copy of this shard is already allocated to this node ["));
            parser.nextToken();
            parser.nextToken();
        }
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);
        assertEquals("idx", shardId.getIndexName());
 *
        assertNull(unassignedInfo);
        boolean encounteredNo = false;
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
                            || parser.currentName().equals("attributes")
            if ((allocationDecision == AllocationDecision.NO && decisionText.equals("NO")
        try (XContentParser parser = getParser(explanation)) {
            parser.nextToken();
        assertEquals(0, moveDecision.getCurrentNodeRanking());
        assertTrue(allocateDecision.isDecisionTaken());
        ClusterAllocationExplanation explanation = runExplain(false, includeYesDecisions, includeDiskInfo);
        ClusterInfo clusterInfo = explanation.getClusterInfo();
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
                .get();
        // verify unassigned info
            int numObjects = 1;
        logger.info("--> starting 3 nodes");
        assertEquals(0, shardId.getId());
            verifyDeciders(parser, AllocationDecision.NO);
            assertEquals(AllocationDecision.NO.toString(), parser.text());
        internalCluster().startNodes(3);
            assertEquals(AllocationDecision.NO, result.getNodeDecision());
        boolean includeDiskInfo = randomBoolean();
            parser.nextToken();
        }
                assertEquals("allocation_id", parser.currentName());
        }
            if (allocationDecision != AllocationDecision.YES) {
        ClusterInfo clusterInfo = explanation.getClusterInfo();
        assertTrue(isPrimary);
            assertThat(clusterInfo.getNodeMostAvailableDiskUsages().size(), greaterThanOrEqualTo(0));
                .prepareHealth("idx")
            assertEquals(AllocationDecision.NO.toString(), parser.text());
        assertTrue(isPrimary);
        }
import org.opensearch.common.Priority;
                assertThat(result.getShardStoreInfo().getMatchingBytes(), greaterThan(0L));
            assertEquals("can_remain_on_current_node", parser.currentName());
            "cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance",
 * not use this file except in compliance with the License.
        MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
            parser.nextToken();
            parser.nextToken();
            assertEquals(1, result.getCanAllocateDecision().getDecisions().size());
            if (d.label().equals("filter")) {
        ClusterAllocationExplanation explanation = runExplain(true, includeYesDecisions, includeDiskInfo);
            parser.nextToken();
        logger.info("--> starting 2 nodes");
            assertEquals("can_rebalance_to_other_node", parser.currentName());
            assertEquals("can_remain_on_current_node", parser.currentName());
    }
            assertEquals("can_rebalance_cluster", parser.currentName());
        assertBusy(() -> {
                }
        }
                    parser.text()
        assertThat(allocateDecision.getExplanation(), startsWith("cannot allocate because the cluster is still waiting"));
            try (XContentParser parser = getParser(explanation)) {
            parser.nextToken();
                Token token = parser.nextToken();
            assertNotNull(d.getExplanation());
        boolean includeDiskInfo = randomBoolean();
        assertNotNull(unassignedInfo);
                assertEquals(Decision.Type.NO, d.type());
        assertEquals(0, shardId.getId());
        // verify current node info
                    );
        // verify unassigned info
                assertEquals(Decision.Type.NO, d.type());
        assertEquals(1, result.getWeightRanking());
        assertEquals(AllocationDecision.NO, result.getNodeDecision());
        DiscoveryNode currentNode = explanation.getCurrentNode();
        parser.nextToken();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertTrue(allocateDecision.isDecisionTaken());
            parser.nextToken();
        boolean includeYesDecisions = randomBoolean();
            IndexMetadata.State.OPEN,
            assertEquals(AllocationDecision.NO, result.getNodeDecision());
    }
            assertEquals("can_allocate", parser.currentName());
        prepareIndex(5, 0);
            .setTransientSettings(Settings.builder().put("cluster.routing.allocation.balance.threshold", 1000.0f))
            parser.nextToken();
            } else {
        boolean includeYesDecisions = randomBoolean();
        parser.nextToken();
        if (allocateDecision.getAllocationDecision() == AllocationDecision.NO_VALID_SHARD_COPY) {
        internalCluster().startNode();
            assertEquals("can_rebalance_to_other_node", parser.currentName());
            if (d.label().equals("filter")) {
            assertEquals(allocationDecision.toString(), parser.text());
                assertEquals(
                    --numObjects;
                || (allocationDecision == AllocationDecision.THROTTLED && decisionText.equals("THROTTLE")))) {
            assertEquals(Token.END_OBJECT, parser.nextToken());
                            )
import static org.hamcrest.Matchers.startsWith;
                if (token == Token.FIELD_NAME) {
    }
        assertNull(unassignedInfo);
                assertEquals("matching_size_in_bytes", parser.currentName());
 * ownership. Elasticsearch licenses this file to you under
        // wait till we have passed any pending shard data fetching
            assertEquals("allocate_explanation", parser.currentName());
            XContentBuilder builder = JsonXContent.contentBuilder();
            parser.nextToken();
        AllocateUnassignedDecision allocateDecision = explanation.getShardAllocationDecision().getAllocateDecision();
            assertThat(clusterInfo.getNodeMostAvailableDiskUsages().size(), lessThanOrEqualTo(numNodes));
        );
            parser.nextToken();
        parser.nextToken();
        ShardRoutingState shardRoutingState = explanation.getShardState();
        parser.nextToken();
            moveDecision.getExplanation()
        prepareIndex(1, 1);
                assertEquals(
        if (includeYesDecisions) {
            moveDecision.getExplanation()
            assertThat(parser.text(), startsWith("cannot allocate because the cluster is still waiting"));
                assertNotNull(d.getExplanation());
                .setShard(0)
        assertEquals(ShardRoutingState.STARTED, shardRoutingState);
            .prepareUpdateSettings("idx")
            assertEquals("remaining_delay_in_millis", parser.currentName());
            indexData();
                assertFalse(nodeAllocationResult.getShardStoreInfo().isInSync());
                // the other node should have zero NO decisions
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
            }
            } else {
                assertEquals(Decision.Type.NO, d.type());
            assertEquals(Decision.Type.YES, d.type());
    }
    ) throws IOException {
        );
        NodeAllocationResult result = moveDecision.getNodeDecisions().get(0);
        try (XContentParser parser = getParser(explanation)) {
                    assertThat(d.getExplanation(), startsWith("a copy of this shard is already allocated to this node ["));
        }
        assertNull(moveDecision.getTargetNode());
            .prepareUpdateSettings("idx")
        String nodeId = clusterState.getRoutingTable().index("idx").shard(0).replicaShards().get(0).currentNodeId();
            assertEquals("can_remain_on_current_node", parser.currentName());
import org.opensearch.core.index.shard.ShardId;
        logger.info("--> setting balancing threshold really high, so it won't be met");
            }
import java.io.IOException;
        assertTrue(allocateDecision.isDecisionTaken());
        UnassignedInfo unassignedInfo = explanation.getUnassignedInfo();
            unassignedInfo.getLastAllocationStatus() == AllocationStatus.FETCHING_SHARD_DATA
        );
        assertEquals("current_state", parser.currentName());
            if (allocationDecision.equals("awaiting_info")) {
 * this work for additional information regarding copyright
            assertEquals("unassigned_info", parser.currentName());
        }
 */
        assertEquals(0L, allocateDecision.getConfiguredDelayInMillis());
        parser.nextToken();
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            parser.nextToken();
            .setIncludeYesDecisions(includeYesDecisions)
        assertEquals("node_allocation_decisions", parser.currentName());
    }
            .setIndex("idx")
            if (allocationDecision.equals("awaiting_info")) {
            ActiveShardCount.NONE
                            || parser.currentName().equals("transport_address")
                assertEquals(Decision.Type.YES, d.type());
        for (NodeAllocationResult result : allocateDecision.getNodeDecisions()) {
        boolean includeYesDecisions = randomBoolean();
    private DiscoveryNode replicaNode() {
            1,
import org.opensearch.common.xcontent.json.JsonXContent;
            assertEquals(1, allocateDecision.getNodeDecisions().size());
        assertEquals(1, result.getWeightRanking());
            if (includeYesDecisions) {
        assertEquals(
        try (XContentParser parser = getParser(explanation)) {
import java.util.Map;
            .setSettings(Settings.builder().put("index.routing.rebalance.enable", "none"))
