            {
            cluster.stabilise();
        }
 * specific language governing permissions and limitations
                    // Each follower may have just sent a leader check, which receives no response
                assertThat(clusterNode.getId() + " should be a candidate", clusterNode.coordinator.getMode(), equalTo(Mode.CANDIDATE));
                // the first election should succeed, because only one node knows of the initial configuration and therefore can win a
        }
                    lastCommittedConfiguration.getNodeIds(),
            final ClusterNode originalLeader = cluster.getAnyLeader();
            // This is VERY BAD: setting a _different_ initial configuration. Yet it works if the first attempt will never be a quorum.
            logger.info("--> changing health of newly added nodes to unhealthy");
                    (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(
                )
                    cluster.deterministicTaskQueue.getCurrentTimeMillis() + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,
                logger.info("--> restarting {}", clusterNode);
package org.opensearch.cluster.coordination;
            leader.submitSetAutoShrinkVotingConfiguration(true);
                );
            follower.blackhole();
            ClusterNode newNode1 = cluster.new ClusterNode(
            cluster.stabilise(
        try (Cluster cluster = new Cluster(2, false, Settings.EMPTY)) {
            cluster.stabilise();
 */
        }
                                    "cluster-manager not discovered or elected yet, an election requires at least 2 nodes with ids from ["
                    new MockLogAppender.SeenEventExpectation("test1", JoinHelper.class.getCanonicalName(), Level.INFO, "*failed to join*")
            cluster.stabilise();
            cluster.runFor(
                        cn.transportService.disconnectFromNode(clusterNode.getLocalNode());
            cluster.runRandomly();
            disconnect1.disconnect();
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info")
                    // wait for the removal to be committed
            cluster.runFor(
        }
        }
                assertThat(nodeId + " has the applied value", value(appliedState), is(finalValue));
                    // followup reconfiguration
import org.opensearch.discovery.DiscoveryModule;
                    + Math.max(
            newNode.close();
        }
            logger.info("--> adding three new healthy nodes");
            disconnect2.heal();
                assertThat(
                        // there might be a term bump causing another election
                    public void run() {
    public void testCannotSetInitialConfigurationTwice() {
import org.opensearch.cluster.block.ClusterBlock;
    public void testLogsWarningPeriodicallyIfClusterNotFormed() throws IllegalAccessException {
import java.util.HashMap;
 * this work for additional information regarding copyright
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder(currentState.coordinationMetadata());
            }
                                        .equals(getNodeIdForLogContext(n.getLocalNode()))
    public void testAppliesNoClusterManagerBlockMetadataWritesIfConfigured() {
                    @Override
            assertTrue("expected eventual nack from " + follower0, ackCollector.hasAckedUnsuccessfully(follower0));
            logger.info("--> disconnecting {}", disconnect3);
            long finalValue = randomLong();
            disconnect1.disconnect();
            logger.info("--> submitting value [{}] to [{}]", finalValue, leader);
        static final String EXCEPTION_MESSAGE = "simulated";
import org.opensearch.test.telemetry.TestInMemoryCounter;
                    )
                assertThat(nodeId + " last accepted in term 0", clusterNode.coordinator.getLastAcceptedState().term(), is(0L));
            );
                    ) + DEFAULT_DELAY_VARIABILITY,
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(newNode2.getId()));
            );
                    // then wait for the followup reconfiguration
            cluster.stabilise(
            final AtomicBoolean failed = new AtomicBoolean();
                        + DEFAULT_ELECTION_DELAY
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
                    "waiting for messages to be emitted"
                                    n -> event.getContextData()
            cluster.runFor(10000, "failing join validation");
    private ClusterState buildNewClusterStateWithVotingConfigExclusion(
                    assertThat(e.getCause(), instanceOf(OpenSearchException.class));
            cluster.stabilise();
            toHeal.heal();
    public void testLeaderDisconnectionWithoutDisconnectEventDetectedQuickly() {
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
                        // then wait for the exception response, causing the follower to become a candidate
                assertThat(lastCommittedConfiguration + " should be 3 nodes", lastCommittedConfiguration.getNodeIds().size(), equalTo(3));
        DiscoveryNodes newNodes = DiscoveryNodes.builder(currentState.nodes())
                    // then wait for the followup reconfiguration
                allOf(
    }
                    (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(
                        LagDetector.class.getCanonicalName(),
                    nonLeader.coordinator.becomeCandidate("forced");
            assertFalse("expected no immediate ack from " + leader, ackCollector.hasAcked(leader));
                            + brokenNode.getLocalNode()
                        }
                    )
                        "after [*] publication of cluster state version [*] is still waiting for "
            cluster.runRandomly();
    }
                    new Runnable() {
            );
            logger.info("--> disconnecting leader {}", originalLeader);
            cluster.stabilise();
            cluster.stabilise();
            {
                assertThat(nodeId + " is in term 0", clusterNode.coordinator.getCurrentTerm(), is(0L));
                final ClusterNode newLeader = cluster.getAnyLeader();
                .collect(Collectors.toMap(Function.identity(), cn -> cn.coordinator.stats().getPublishStats()));
        try (Cluster cluster = new Cluster(5)) {
                        "after [*] publication of cluster state version [*] is still waiting for "
        if (randomBoolean()) {
                throw new IllegalArgumentException("join validation failed");
            );
                    postPublishStats.get(cn).getCompatibleClusterStateDiffReceivedCount()
                "awaiting removal of asymmetrically-partitioned node"
        }
        public String getWriteableName() {
            assertThat(exceptionMessage, equalTo("local node is not part of initial configuration"));
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect1.getId()));
            cluster.stabilise();
            cluster.stabilise();
                                message,
                );
                assertEquals(Double.valueOf(1.0), counterValuesByTags.get(tags2));
            cluster.stabilise();
                assertTrue(lastCommittedConfiguration.getNodeIds().contains(disconnect3.getId()));
                final VotingConfiguration lastCommittedConfiguration = newLeader.getLastAppliedClusterState()
            }));
import org.opensearch.monitor.StatusInfo;
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);
            cluster.stabilise(defaultMillis(PUBLISH_TIMEOUT_SETTING));
            cluster.runRandomly();
            cluster.runRandomly();
            disconnect1.disconnect();
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING)
                    + 2 * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY
    }
                    // first wait for all the followers to notice the leader has gone
            final ClusterNode nodeInOtherCluster;
                            );
            logger.info("--> disconnecting {}", disconnect4);
                ise.getMessage(),
                ackCollector.getSuccessfulAckIndex(leader),
        @Override
                                .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
            }
            cluster.stabilise();
            logger.info("--> blackholing leader {}", originalLeader);
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
            final ClusterNode leader = cluster.getAnyLeader();
                    // wait for the removal to be committed
            cluster.stabilise();
                (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(
import org.opensearch.common.unit.TimeValue;
                    // wait for the leader to notice that the follower is unresponsive
        try (Cluster cluster = new Cluster(1)) {
            assertEquals(prePublishStats.getFullClusterStateReceivedCount() + 1, postPublishStats.getFullClusterStateReceivedCount());
                .build();
                postPublishStats.getIncompatibleClusterStateDiffReceivedCount()
    }
            );
                                startsWith(
            cluster.bootstrapIfNecessary();
                    cn -> cn == clusterNode ? cn.restartedNode(Function.identity(), Function.identity(), Settings.EMPTY) : cn
                MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(
                logger.info("setting auto-shrink reconfiguration to false");
            if (randomBoolean()) {
        testAppliesNoClusterManagerBlock("all", NO_CLUSTER_MANAGER_BLOCK_ALL);
    public void testNodesJoinAfterStableCluster() {
                )
                    lastCommittedConfiguration + " should be all nodes",
            logger.info("--> publishing another value");
                        + DEFAULT_DELAY_VARIABILITY
            } else {
                    // then wait for a follower to be promoted to leader
                ConcurrentHashMap<Map<String, ?>, Double> counterValuesByTags = nodeLeftCounter.getCounterValueForTags();
            disconnect2.disconnect();
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
    }
            final ClusterNode leader = cluster.getAnyLeader();
        try (Cluster cluster = new Cluster(3)) {
                cluster.deterministicTaskQueue.scheduleAt(
    public void testUnhealthyNodesGetsRemoved() {
            cluster.stabilise(); // would not work if disconnect1 were removed from the configuration
        try (Cluster cluster = new Cluster(randomIntBetween(1, 3), true, Settings.EMPTY, () -> nodeHealthServiceStatus.get())) {
            })));
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
            );
    }
            final Coordinator coordinator = cluster.getAnyLeader().coordinator;
            cluster1.runRandomly();
                "detecting disconnection"
            if (chosenNodeIsLeader == false) {
                    lastCommittedConfiguration + " should be all nodes",
            cluster.getAnyLeader().submitSetAutoShrinkVotingConfiguration(false);
            cluster.getAnyLeader().extraJoinValidators.clear();
            Set<CoordinationMetadata.VotingConfigExclusion> newVotingConfigExclusion2 = singleton(
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
            }
                        @Override
            final ClusterNode follower = cluster.getAnyNodeExcept(leader);
            cluster.stabilise();
                @Override
            cluster.stabilise();
        }
                            final String message = event.getMessage().getFormattedMessage();
    public void testUnHealthyLeaderRemoved() {
import org.opensearch.core.common.io.stream.StreamOutput;
            cluster.setEmptySeedHostsList();
    }
            // detection and ongoing publications do not time out
            cluster.runRandomly();
import static org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.DEFAULT_DELAY_VARIABILITY;
        try (Cluster cluster = new Cluster(between(3, 5))) {
                    new MockLogAppender.SeenEventExpectation(
    public void testAckListenerReceivesNacksFromFollowerInHigherTerm() {
    }
            final ClusterNode disconnect2 = cluster.getAnyNodeExcept(disconnect1);
                );
                                )
        Set<CoordinationMetadata.VotingConfigExclusion> newVotingConfigExclusion
            cluster.runFor(DEFAULT_STABILISATION_TIME, "allowing time for fault detection");
    public void testFollowerRemovedIfUnableToSendRequestsToClusterManager() {
        }
            addedNodes.forEach(cn -> cn.extraJoinValidators.add((discoveryNode, clusterState) -> {
                );
                    )
            assertTrue(cluster.clusterNodes.stream().allMatch(cn -> cn.getLastAppliedClusterState().version() == 0));
            leader.submitValue(finalValue);
                        // then wait for the followup reconfiguration
            cluster.stabilise();
            assertTrue(addedNodes.stream().allMatch(ClusterNode::isCandidate));
                            Function.identity(),
import java.util.Arrays;
            {
            assertEquals(
            assertThat(
            final long originalTerm = leader.coordinator.getCurrentTerm();
            final long startingTerm = leader.coordinator.getCurrentTerm();
            )
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES;
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))
            final long finalValue = randomLong();
        }
            final Set<DiscoveryNode> validatedNodes = new HashSet<>();
    ) {
            follower.disconnect();
            ClusterState newState1 = buildNewClusterStateWithVotingConfigExclusion(currentState, newVotingConfigExclusion1);
            logger.debug("rebooting [{}]", clusterNode.getId());
            Cluster cluster = new Cluster(
        try (Cluster cluster1 = new Cluster(randomIntBetween(1, 3))) {
            final String exceptionMessage = expectThrows(
                        + DEFAULT_ELECTION_DELAY,
            cluster.stabilise(DEFAULT_ELECTION_DELAY);
                assertThat(leader.coordinator.getMode(), is(Mode.LEADER));
            {
            clusterNode.close();
            final ClusterNode leader1 = cluster.getAnyLeader();
                        // then wait for the follower to check the leader
                defaultMillis(ELECTION_INITIAL_TIMEOUT_SETTING)
            );
                    + DEFAULT_DELAY_VARIABILITY
            }
import org.opensearch.cluster.node.DiscoveryNode;
            return "broken";
                IllegalStateException.class,
                assertThat(leader.coordinator.getMode(), is(Mode.LEADER));
                        "publication info message",
                    .build();
                    )
                cluster.getAnyLeader().submitValue(randomLong());
                    // Commit a new cluster state with the new node(s). Might be split into multiple commits, and each might need a
                assertEquals(Double.valueOf(1.0), counterValuesByTags.get(tags1));
                );
            final ClusterNode leader = cluster.getAnyLeader();
                            + ']'
    }
                tags2.put("reason", "health.check.fail");
            );
            final ClusterNode leader = cluster.getAnyLeader();
    }
            }).run();
            follower.blackhole();
                logger.debug("forcing {} to become candidate", nonLeader.getId());
            );
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_INTERVAL_SETTING;
                    // Then allow time for all the other nodes to join, each of which might cause a reconfiguration
            assertEquals(cluster.size() % 2, newNodePublishStats.getCompatibleClusterStateDiffReceivedCount());
                                                                                                                                    // for
            cluster.clusterNodes.add(newNode1);
            // cluster has two nodes in mode LEADER, in different terms ofc, and the one in the lower term won’t be able to publish anything
            final ClusterNode follower = cluster.getAnyNodeExcept(leader);
                DEFAULT_DELAY_VARIABILITY // disconnect is scheduled
                assertTrue(node.coordinator.localNodeCommissioned());
                )
            assertFalse(Coordinator.validVotingConfigExclusionState(newState1));
        }
                cluster2.runRandomly();
            final ClusterNode leader = cluster.getAnyLeader();
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
            cluster.stabilise();
            final ClusterNode leader = cluster.getAnyLeader();
            final ClusterNode disconnect3 = cluster.getAnyNodeExcept(disconnect1, disconnect2);
            }
                            assertThat(
        }
            cluster.runRandomly();
        }
            .add(
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            cluster.stabilise();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            {
            cluster.runRandomly();
                randomBoolean(),
                        // and the first publication times out because of the unresponsive node
            disconnect2.disconnect();
                assertThat(nodeId + " has the applied value", value(appliedState), is(finalValue));
            cluster.stabilise();
                cluster.runRandomly(true, false, delayVariabilityMillis);
            cluster.stabilise();
                assertThat(value(cn.getLastAppliedClusterState()), is(finalValue));
                        "publication warning",
                validatedNodes.add(discoveryNode);
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                            // 1. the term bumping publication to time out
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
                // drop the publication messages to one node, but then restore connectivity so it remains in the cluster and does not fail
            cluster.stabilise();
                settingsBuilder.put(NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), noClusterManagerBlockSetting);
                    defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)
            follower0.onDisconnectEventFrom(leader);
        ClusterState currentState,
    public void testUnresponsiveFollowerDetectedEventually() {
            assertEquals(previousClusterStateVersion, newClusterStateVersion);
    public void testFollowerDisconnectionDetectedQuickly() {
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))
            assertEquals(validatedNodes, addedNodes.stream().map(ClusterNode::getLocalNode).collect(Collectors.toSet()));
                    containsString("does not have quorum in voting configuration")
        }
 *
    }
        @Override
            cluster.getAllNodesExcept(originalLeader).forEach(cn -> cn.onDisconnectEventFrom(originalLeader));
    public void testSingleNodeDiscoveryWithoutQuorum() {
                DEFAULT_DELAY_VARIABILITY // disconnect is scheduled
            throw new OpenSearchException(EXCEPTION_MESSAGE);
            disconnect1.heal();
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
import java.util.concurrent.atomic.AtomicReference;
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            assertThat(cluster.getAnyLeader().getId(), equalTo(leader.getId()));
import java.util.Map;
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
            follower0.heal();
            final long currentTerm = cluster.getAnyLeader().coordinator.getCurrentTerm();
                    lastCommittedConfiguration + " should be all nodes",
    public void testStateRecoveryResetAfterPreviousLeadership() {
                public String toString() {
            final ClusterNode leader = cluster.getAnyLeader();
                final VotingConfiguration lastCommittedConfiguration = newLeader.getLastAppliedClusterState()
                equalTo(cluster.clusterNodes.size() - 1)
            final ClusterNode disconnect2 = cluster.getAnyNodeExcept(disconnect1);
            }
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
                    defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)
            final Map<ClusterNode, PublishClusterStateStats> prePublishStats = cluster.clusterNodes.stream()
            cluster.stabilise();
                    )
                            nodesLogged.add(matchingNodes.get(0).getLocalNode());
    }
    }
            cluster.runRandomly(false, true, EXTREME_DELAY_VARIABILITY);
     * one of them becomes leader and publishes first state (with STATE_NOT_RECOVERED_BLOCK) to old leader, which accepts it.
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL;
            cluster.runFor(10000, "failing join validation");
 * license agreements. See the NOTICE file distributed with
                    FOLLOWER_CHECK_RETRY_COUNT_SETTING
        }
 *
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING;
    }
        }
import static org.opensearch.cluster.coordination.Reconfigurator.CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION;
            final ClusterNode follower = cluster.getAnyNodeExcept(leader);
                        // then wait for the exception response
                new CoordinationMetadata.VotingConfigExclusion(
            disconnect3.disconnect();
            cluster.runRandomly();
                                FOLLOWER_CHECK_RETRY_COUNT_SETTING
            logger.info("--> submitting first value to {}", leader);
        }
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
                cluster.clusterNodes.replaceAll(cn -> cn == clusterNode ? cn.restartedNode() : cn);
    public void testLocalNodeAlwaysCommissionedWithoutDecommissionedException() {
                            brokenNode.heal();
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
                                nodesLogged,
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
                    // ALSO the follower may have just sent a leader check, which receives no response
        try (Cluster cluster = new Cluster(1)) {
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
            final ClusterNode leader = cluster.getAnyLeader();
            randomValueOtherThanMany(
            final ClusterNode leader = cluster.getAnyLeader();
            logger.info("--> submitting value [{}] to [{}]", finalValue, leader);
import org.opensearch.gateway.GatewayService;
            cluster.stabilise();
                        final Set<DiscoveryNode> nodesLogged = new HashSet<>();
                    LogManager.getLogger(Coordinator.CoordinatorPublication.class),
            disconnect2.disconnect();
import java.util.HashSet;
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();
            final ClusterNode restartedNode = removedNode.restartedNode();
                cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
                        + DEFAULT_DELAY_VARIABILITY
            leader.allowClusterStateApplicationFailure();
                    emptyMap(),
            final ClusterNode leader = cluster.getAnyLeader();
                        (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING))
 * the Apache License, Version 2.0 (the "License"); you may
                term -> DetachClusterCommand.updateCurrentTerm(),
            // A cluster using single-node discovery should not apply any timeouts to joining or cluster state publication. There are no
                                    message
            cluster.stabilise();
    public void testAckListenerReceivesNackFromLeader() {
                assertTrue(
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
                final ClusterNode newLeader = cluster.getAnyLeader();
                1,
import java.io.IOException;
                    // then wait for the followup reconfiguration
                "stabilising"
                    (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)) * defaultInt(
            // restart follower1 and follower2
                );
    }
            return builder;
                public void run() {
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,
            assertThat(
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))
                }
            final long newClusterStateVersion = cluster.getAnyLeader().getLastAppliedClusterState().version();
                // pre-voting round and proceed to an election, so there cannot be any collisions
        }
                    // Commit a new cluster state with the new node(s). Might be split into multiple commits, and each might need a
            cluster.runRandomly();
            final ClusterNode leader = cluster.getAnyLeader();
            cluster.runRandomly();
                // health checks
    }
            );
            nodeHealthServiceStatus.getAndSet(new StatusInfo(UNHEALTHY, "unhealthy-info"));
    }
                assertThat(nonLeader.coordinator.getMode(), equalTo(CANDIDATE));
                    // One message delay to send a join
    }
        try (Cluster cluster = new Cluster(3)) {
            }
            for (ClusterNode node : cluster.clusterNodes) {
                        "node ["
                    MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(
                    cn.toString(),
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
    public void testNodeCannotJoinIfJoinValidationFailsOnJoiningNode() {
                            // 2. the new leader to notice that the old leader is unresponsive
            assertTrue(leader.coordinator.getMode() != Coordinator.Mode.LEADER || leader.coordinator.getCurrentTerm() > startingTerm);
                assertThat(lastCommittedConfiguration + " should be 3 nodes", lastCommittedConfiguration.getNodeIds().size(), equalTo(3));
            leader.submitSetAutoShrinkVotingConfiguration(true);
                            return "healing " + brokenNode;
            cluster.stabilise(
                assertEquals(
            assertEquals(0, newNode.getLastAppliedClusterState().version());
            final ClusterNode disconnect4 = cluster.getAnyNodeExcept(disconnect1, disconnect2, disconnect3);
                );
            // let followers elect a leader among themselves before healing the leader and running the publication
            disconnect4.disconnect();
 * SPDX-License-Identifier: Apache-2.0
                partitionedNode.blackhole();
                    // One message delay to send a join
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
        }
        try (Cluster cluster = new Cluster(5)) {
                leader.getLastAppliedClusterState().nodes().toString(),
                leader.submitSetAutoShrinkVotingConfiguration(true);
            }
            disconnect1.disconnect();
        }
                assertThat(
            cluster.stabilise();
    }
            );
            cluster.stabilise();
            final ClusterNode detachedNode = newNode.restartedNode(
            final long expectedTerm = leader.coordinator.getCurrentTerm();
                        FOLLOWER_CHECK_RETRY_COUNT_SETTING
                            Function.identity(),
    public void testNodeCannotJoinIfJoinValidationFailsOnClusterManager() {
            cluster.stabilise();
                assertThat(clusterNode.getId() + " should be a candidate", clusterNode.coordinator.getMode(), equalTo(Mode.CANDIDATE));
            logger.info("--> disconnecting leader {}", originalLeader);
                        // then wait for the followup reconfiguration
                        : cn
            }
                        @Override
                tags2.put("follower_node_id", newNode2.getId());
                    LogManager.getLogger(LagDetector.class)
            AckCollector ackCollector = leader.submitValue(randomLong());
            cluster.stabilise();
                ELECTION_INITIAL_TIMEOUT_SETTING.get(Settings.EMPTY).millis() + delayVariabilityMillis + 4 * delayVariabilityMillis // two
                    + DEFAULT_ELECTION_DELAY,
            final ClusterNode disconnect1 = cluster.getAnyNode();
            // check that if node join validation fails on cluster-manager, the nodes can't join
                );
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect2.getId()));
                // the leader, otherwise restarting the other cluster-manager-eligible node triggers an election
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                    // and the first publication times out because of the unresponsive node
            cluster.stabilise();
            cluster.clusterNodes.remove(clusterNode); // to avoid closing it twice
        }
            );
        }
            // we require another node to heal to recover
                nodes -> cluster.initialConfiguration.hasQuorum(
            cluster.runRandomly();
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING)
    }
            cluster.runRandomly();
        public void writeTo(StreamOutput out) throws IOException {
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
        @Override
    }
                        + defaultMillis(LEADER_CHECK_INTERVAL_SETTING)
    public void testClusterRecoversAfterExceptionDuringSerialization() {
            cluster.stabilise();
            logger.info("--> changing health status of leader {} to unhealthy", leader);
                mockLogAppender.addExpectation(
        }
            logger.info("--> disconnecting follower {}", follower);
                );
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect2.getId()));
                    + 4 * DEFAULT_DELAY_VARIABILITY
                "initial discovery phase"
            cluster.stabilise();
                        LEADER_CHECK_RETRY_COUNT_SETTING
                assertTrue(node.coordinator.localNodeCommissioned());
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;
                            assertThat(
            assertThat(cluster.getAnyLeader().getId(), not(equalTo(originalLeader.getId())));
        try (Cluster cluster = new Cluster(3, true, settings)) {
                final String nodeId = clusterNode.getId();
        }
                Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE).build()
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                randomBoolean(),
    public void testDiffBasedPublishing() {
                    + 3 * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                Sets.newHashSet(coordinator.getLocalNode().getId(), "unknown-node")
            disconnect1.heal();
            cluster.stabilise(
    public void testAckListenerReceivesNacksIfLeaderStandsDown() {
            final Map<ClusterNode, PublishClusterStateStats> postPublishStats = cluster.clusterNodes.stream()
    }
            final ClusterNode leader = cluster.getAnyLeader();
            final long previousClusterStateVersion = cluster.getAnyLeader().getLastAppliedClusterState().version();
 * software distributed under the License is distributed on an
            }
                    defaultMillis(PUBLISH_TIMEOUT_SETTING) + 2 * DEFAULT_DELAY_VARIABILITY + defaultMillis(
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
                cluster.getAnyLeader().getLastAppliedClusterState().getLastCommittedConfiguration().getNodeIds(),
            );
                    .metadata(Metadata.builder(cs.metadata()).persistentSettings(settingsBuilder.build()))
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "committing setting update");
            settings = Settings.builder()
            );
                );
                    )
                )
            );
            AckCollector ackCollector = leader.submitValue(randomLong());
            // check that if node join validation fails on joining node, the nodes can't join
                    // there might be a term bump causing another election
            cluster.stabilise();
            cluster.clusterNodes.replaceAll(cn -> cn == removedNode ? restartedNode : cn);
                                )
            cluster.stabilise();
                postPublishStats.getCompatibleClusterStateDiffReceivedCount()
            follower0.coordinator.onFollowerCheckRequest(
            assertTrue("expected ack from " + follower1, ackCollector.hasAckedSuccessfully(follower1));
            // however we do not tolerate the loss of yet another one
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING;
                final String nodeId = clusterNode.getId();
                cluster.clusterNodes.replaceAll(
 */
 * You may obtain a copy of the License at
            cluster.runRandomly();
            cluster.runRandomly();
            follower1.blackhole();
            cluster.runRandomly();
                Math.max(
                }
                ), nodeInOtherCluster.nodeSettings, () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info")
                defaultMillis(LEADER_CHECK_TIMEOUT_SETTING) // to wait for any in-flight check to time out
            logger.info("--> disconnecting {}", disconnect3);
                final ClusterNode leader = cluster.getAnyLeader();
                        + defaultMillis(LEADER_CHECK_INTERVAL_SETTING)
                    )
                startsWith("not enough nodes discovered to form a quorum in the initial configuration [knownNodes=[")
                            + " ["
            }
                    }
                    }
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
            final ClusterNode newNode = cluster1.new ClusterNode(
                        + defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING)
            cluster.runRandomly();
            );
            cluster.stabilise();
        } else {
                        // then wait for the exception response
            originalLeader.disconnect();
    public void testAckListenerReceivesNackFromFollower() {
            IllegalStateException ise = expectThrows(
                            + " ["
        }
            final long termBeforeRestart = cluster.getAnyNode().coordinator.getCurrentTerm();
            cluster.runFor(
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                    failed.set(true);
                }
                cluster.clusterNodes.forEach(cn -> cluster.deterministicTaskQueue.scheduleNow(cn.onNode(new Runnable() {
                );
import org.opensearch.common.util.set.Sets;
            cluster.blackholeConnectionsFrom(otherNode, leader);
            final ClusterNode leader = cluster.getAnyLeader();
            cluster.clusterNodes.add(decommissionedNode);
                throw new IllegalArgumentException("join validation failed");
            logger.info("setting auto-shrink reconfiguration to true");
import org.opensearch.Version;
public class CoordinatorTests extends AbstractCoordinatorTestCase {
            cluster.stabilise();
            leader.submitSetAutoShrinkVotingConfiguration(true);
        try (
                assertThat(clusterNode.getId() + " is CANDIDATE", clusterNode.coordinator.getMode(), is(CANDIDATE));
                () -> randomSubsetOf(cluster.clusterNodes)
        }
                cluster.getAnyLeader().getLastAppliedClusterState().getLastAcceptedConfiguration().getNodeIds(),
            leader.onDisconnectEventFrom(follower);
                new FollowersChecker.FollowerCheckRequest(originalTerm + 1, leader.coordinator.getLocalNode())
                final ClusterState appliedState = clusterNode.getLastAppliedClusterState();
                DEFAULT_DELAY_VARIABILITY // disconnect is scheduled
                        // 2. the new leader to notice that the old leader is unresponsive
                cn -> cn == chosenNode ? cn.restartedNode(Function.identity(), Function.identity(), nonClusterManagerNode()) : cn
            cluster.stabilise();
        AtomicReference<StatusInfo> healthStatusInfo = new AtomicReference<>(new StatusInfo(HEALTHY, "healthy-info"));
            final VotingConfiguration unknownNodeConfiguration = new VotingConfiguration(Sets.newHashSet("unknown-node"));
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info")
            restartedNode.disconnect();
                    + 3 * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY
        }
                    singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                    + 4 * DEFAULT_DELAY_VARIABILITY
                    cluster.runFor(warningDelayMillis + DEFAULT_DELAY_VARIABILITY, "waiting for warning to be emitted");
            cluster.runRandomly();
                    // ALSO wait for the leader to notice that its followers are unresponsive
            final Coordinator coordinator = cluster.getAnyNode().coordinator;
import static org.hamcrest.Matchers.instanceOf;
            for (ClusterNode node : cluster.clusterNodes) {
            leader.setClusterStateApplyResponse(ClusterStateApplyResponse.SUCCEED);
            }
                assertNotNull("node.left.count counter should be present", nodeLeftCounter);
                        // then wait for a new election
            assertTrue(coordinator.setInitialConfiguration(VotingConfiguration.of(coordinator.getLocalNode())));
                assertTrue(counterValuesByTags.containsKey(tags2));
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            assertTrue("expected nack from " + follower0, ackCollector.hasAckedUnsuccessfully(follower0));
            logger.info("--> submitting value [{}] to [{}]", finalValue, leader2);
            cluster.stabilise(
                throw new IllegalArgumentException("join validation failed");
            );
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
            warningDelayMillis = ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.get(settings).millis();
            assertFalse(decommissionedNode.coordinator.localNodeCommissioned());
                // Check for newNode1
                    @Override
            cluster.stabilise(
            leader.blackhole();
            try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(JoinHelper.class))) {
            cluster.runRandomly();
                        // then wait for the follower to check the leader
                        + DEFAULT_DELAY_VARIABILITY,
                assertThat(
    }
    public void testSingleNodeDiscoveryStabilisesEvenWhenDisrupted() {
            );
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
                }
                    prePublishStats.get(cn).getCompatibleClusterStateDiffReceivedCount() + 1,
                            + Publication.PublicationTargetState.SENT_PUBLISH_REQUEST
                    .getLastCommittedConfiguration();
            }
            }
    }
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect1.getId()));
                final String nodeId = clusterNode.getId();
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();
            assertTrue(leader.getLocalNode().isClusterManagerNode());
            // turn leader into candidate, which stabilisation asserts at the end
                logger.debug("simulate follower check coming through from {} to {}", leader.getId(), nonLeader.getId());
                );
            final ClusterNode clusterNode = cluster.getAnyNode();
            final ClusterNode disconnect1 = cluster.getAnyNode();
 */
            final ClusterNode follower2 = cluster.getAnyNodeExcept(leader, follower1);
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
            assertTrue("expected nack from " + follower0, ackCollector.hasAckedUnsuccessfully(follower0));
                    clusterNode.coordinator.getLastAcceptedState().getLastCommittedConfiguration().isEmpty()
                                .filter(
                not(hasItem(chosenNode.getId()))
            cluster.stabilise(); // would not work if disconnect1 were removed from the configuration
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        + Math.max(
    public void testCannotSetInitialConfigurationWithoutLocalNode() {
                    + DEFAULT_ELECTION_DELAY
                    .getLastCommittedConfiguration();
                        + defaultMillis(LEADER_CHECK_INTERVAL_SETTING)
/*
                    lastCommittedConfiguration.getNodeIds(),
                new CoordinationMetadata.VotingConfigExclusion(
            final ClusterNode toHeal = randomBoolean() ? disconnect3 : disconnect4;
                    + 2 * DEFAULT_DELAY_VARIABILITY, // to send the failing check and receive the disconnection response
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info")
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))
                                                                                                                                    // trips
                1,
    public void testSettingInitialConfigurationTriggersElection() {
                try (
            cluster.runRandomly();
            final ClusterNode leader = cluster.getAnyLeader();
            logger.info("--> disconnecting {} and {}", disconnect1, disconnect2);
            {
    }
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "cluster state update");
                                                                                                                                    // pre-voting
 * Modifications Copyright OpenSearch Contributors. See
        logger.info("--> emitting warnings every [{}ms]", warningDelayMillis);
            logger.info("setting auto-shrink reconfiguration to true");
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
            assertThat(
            }
            logger.info("--> disconnecting {}", disconnect2);
            settings = Settings.EMPTY;
                    // Then a commit of the updated cluster state
                    () -> nonLeader.coordinator.onFollowerCheckRequest(
                assertEquals(
            final String exceptionMessage = expectThrows(
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
                    lastCommittedConfiguration + " should be all nodes",
            assertTrue(bootstrapNode.getId() + " has been bootstrapped", bootstrapNode.coordinator.isInitialConfigurationSet());
                    mockLogAppender.addExpectation(new MockLogAppender.LoggingExpectation() {
            final Coordinator coordinator = cluster.getAnyNode().coordinator;
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING;
            final ClusterNode newNode = cluster.clusterNodes.get(cluster.clusterNodes.size() - 1);
    }
        }
            assertEquals(currentTerm, newTerm);
            cluster1.clusterNodes.replaceAll(cn -> cn == newNode ? detachedNode : cn);
            {
            cluster.stabilise();
                                nodesLogged + " vs " + cluster.clusterNodes,
            logger.info("--> healing {}", toHeal);
                    // ALSO the leader may have just sent a follower check, which receives no response
                // first wait for all the followers to notice the leader has gone
                ) == false,
            assertTrue("expected ack from " + follower1, ackCollector.hasAckedSuccessfully(follower1));
                cluster2.stabilise();
            logger.info("--> submitting second value to {}", leader);
            final VotingConfiguration unknownNodeConfiguration = new VotingConfiguration(
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING) * 2
            );
                        // wait for the leader to check its followers
            cluster.clusterNodes.forEach(cn -> cluster.deterministicTaskQueue.scheduleNow(cn.onNode(new Runnable() {
                    return "disconnect from " + clusterNode.getLocalNode() + " after shutdown";
                mockAppender.assertAllExpectationsMatched();
                mockLogAppender.addExpectation(
import org.opensearch.cluster.AbstractDiffable;
            follower.onDisconnectEventFrom(leader); // to turn follower into candidate, which stabilisation asserts at the end
                prePublishStats.getCompatibleClusterStateDiffReceivedCount(),
            assertThat(
                assertThat(leader.coordinator.getMode(), is(Mode.LEADER));
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);
            // once cluster stabilises the node joins and would be commissioned
            cluster.stabilise(
            cluster.clusterNodes.add(newNode3);
                ) + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,
 * Unless required by applicable law or agreed to in writing,
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
            );
            cluster.runFor(2 * DEFAULT_DELAY_VARIABILITY + 1, "processing broken task");
                    new MockLogAppender.SeenEventExpectation(
            );
            cluster.stabilise();
            cluster.runRandomly();
            cluster.runFor(DEFAULT_STABILISATION_TIME, "allowing time for fault detection");
                    // FINALLY:
            assertTrue(decommissionedNode.coordinator.localNodeCommissioned());
            logger.info("--> disconnecting {}", disconnect1);
    }
import java.util.stream.Collectors;
                    nodeId + " has an empty last-accepted configuration",
            }
    public void testAppliesNoClusterManagerBlockWritesIfConfigured() {
    public void testDoesNotPerformElectionWhenRestartingFollower() {
        try (Cluster cluster = new Cluster(randomIntBetween(1, 3))) {
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            logger.info("--> disconnecting {}", disconnect1);
            cluster.runRandomly();
            addedNodes.forEach(cn -> cn.extraJoinValidators.clear());
            final ClusterNode leader = cluster.getAnyLeader();
                )
            assertThat(cluster.getAnyLeader(), sameInstance(clusterNode));
    /**
                assertTrue(
                "broken-task",
            // cf. DEFAULT_STABILISATION_TIME, but stabilisation is quicker when there's a single node - there's no meaningful fault
                clusterNode.disconnect();
                    }
            // moreover we are still stuck even if two other nodes heal
        return ClusterState.builder(currentState).nodes(newNodes).metadata(newMetadata).build();
            ).getMessage();
    }
                    (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)) * defaultInt(
            cluster.stabilise();
            final ClusterNode leader = cluster.getAnyLeader();
                        + DEFAULT_ELECTION_DELAY
                cs -> ClusterState.builder(cs).putCustom("broken", new BrokenCustom()).build(),
            final ClusterNode partitionedNode = cluster.getAnyNode();
        try (Cluster cluster = new Cluster(3)) {
            cluster.stabilise(
                            )
        newVotingConfigExclusion.forEach(coordMetadataBuilder::addVotingConfigExclusion);
import java.util.List;
                assertTrue("expected ack from " + clusterNode, ackCollector.hasAckedSuccessfully(clusterNode));
        try (Cluster cluster = new Cluster(3)) {
            );
    public void testFollowerDisconnectionWithoutDisconnectEventDetectedQuickly() {
            cluster.stabilise();
            cluster.stabilise();
                            + brokenNode.getLocalNode()
            cluster.stabilise(DEFAULT_STABILISATION_TIME * 2);
                );
                            );
    }
    public void testImproveConfigurationPerformsVotingConfigExclusionStateCheck() {
                )
            cluster.stabilise();
            }
            AckCollector ackCollector = leader.submitValue(randomLong());
                clusterNode.close();
            assertTrue("expected nack from " + leader, ackCollector.hasAckedUnsuccessfully(leader));
        testAppliesNoClusterManagerBlock(null, NO_CLUSTER_MANAGER_BLOCK_WRITES);
 * under the License.
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
    }
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> healthStatusInfo.get()
            List<ClusterNode> addedNodes = cluster.addNodes(randomIntBetween(1, 2));
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
            cluster.runRandomly();
            cluster.stabilise();
import org.opensearch.core.xcontent.XContentBuilder;
/*
    public void testExpandsConfigurationWhenGrowingFromThreeToFiveNodesAndShrinksBackToThreeOnFailure() {
                    + DEFAULT_ELECTION_DELAY
                        + DEFAULT_DELAY_VARIABILITY
                Math.max(
            cluster.stabilise();
                        public void match(LogEvent event) {
            return Version.V_EMPTY;
                assertThat(clusterNode.getId() + " should be a candidate", clusterNode.coordinator.getMode(), equalTo(Mode.CANDIDATE));
                            + "] is lagging at cluster state version [*], "
import static org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.EXTREME_DELAY_VARIABILITY;
            logger.info("--> healing {} and {}", disconnect1, disconnect2);
                    // wait for the removal to be committed
        }
                Math.max(
                cluster.getAnyLeader().getLastAppliedClusterState().getLastAcceptedConfiguration().getNodeIds(),
                    mockLogAppender.assertAllExpectationsMatched();
            final long delayVariabilityMillis = randomLongBetween(DEFAULT_DELAY_VARIABILITY, TimeValue.timeValueMinutes(10).millis());
                    "resolvableNodeName"
            }
                Map<String, Object> tags2 = new HashMap<>();
    }
                    // then wait for the followup reconfiguration
            final ClusterNode disconnect2 = cluster.getAnyNodeExcept(disconnect1);
            final ClusterNode disconnect1 = cluster.getAnyNode();
            final long newTerm = cluster.getAnyLeader().coordinator.getCurrentTerm();
import static org.hamcrest.Matchers.startsWith;
     * Simulates a situation where a follower becomes disconnected from the leader, but only for such a short time where
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
        }
                    defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)
            AckCollector ackCollector = leader.submitValue(randomLong());
            leader.submitValue(randomLong());
            );
            assertTrue(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(leader.getLastAppliedClusterState().metadata().settings()));
            );
    public void testJoiningNodeReceivesFullState() {
                final ClusterState appliedState = clusterNode.getLastAppliedClusterState();
        try (Cluster cluster = new Cluster(3)) {
            ClusterNode newNode3 = cluster.new ClusterNode(
            AckCollector ackCollector = leader.submitValue(randomLong());
            logger.info("--> disconnecting all nodes");
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING;
            cluster.runRandomly();
    public void testReconfiguresToExcludeClusterManagerIneligibleNodesInVotingConfig() {
            cluster.runRandomly();
            logger.info("--> blocking cluster state application on {}", follower0);
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);
    }
                    // ALSO wait for the follower to notice the leader is unresponsive
            cluster.clusterNodes.add(newNode1);
    }
            assertThat(cluster.getAnyLeader().getId(), not(equalTo(originalLeader.getId())));
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                    nodes.stream().map(ClusterNode::getLocalNode).map(DiscoveryNode::getId).collect(Collectors.toSet())
                        }
            leader.submitUpdateTask("update NO_CLUSTER_MANAGER_BLOCK_SETTING", cs -> {
                                    "*have discovered *" + matchingNodes.get(0).toString() + "*discovery will continue*",
            final ClusterNode leader = cluster.getAnyLeader();
                // Interval is updated to decommissioned find peer interval
import org.apache.logging.log4j.core.LogEvent;
import static org.hamcrest.Matchers.is;
        final Settings settings;
                ) {
            final ClusterNode leader = cluster.getAnyLeader();
            cluster.runRandomly();
                )
                // in the 2-node case, auto-shrinking the voting configuration is required to reduce the voting configuration down to just
    private static class BrokenCustom extends AbstractDiffable<ClusterState.Custom> implements ClusterState.Custom {
            // we still tolerate the loss of one more node here
            );
    private void testAppliesNoClusterManagerBlock(String noClusterManagerBlockSetting, ClusterBlock expectedBlock) {
                })));
                        public void run() {
        try (Cluster cluster = new Cluster(3)) {
        }
            cluster.runRandomly();
    }
            )
            final long previousClusterStateVersion = cluster.getAnyLeader().getLastAppliedClusterState().version();
                    + DEFAULT_DELAY_VARIABILITY
            assertThat(cluster.getAnyLeader().getId(), equalTo(leader.getId()));
            for (ClusterNode cn : cluster.clusterNodes) {
            assertThat(exceptionMessage, containsString(coordinator.getLocalNode().toString()));
            final ClusterNode bootstrapNode = cluster.getAnyBootstrappableNode();
            assertTrue("expected nack from " + follower0, ackCollector.hasAckedUnsuccessfully(follower0));
                        return "disconnect from " + clusterNode.getLocalNode() + " after shutdown";
                    )
                        Coordinator.CoordinatorPublication.class.getCanonicalName(),
                final ClusterNode newLeader = cluster.getAnyLeader();
            assertThat(cluster.getAnyLeader().getId(), equalTo(leader.getId()));
            assertFalse("expected no ack from " + leader, ackCollector.hasAckedSuccessfully(leader));
                final ClusterNode newLeader = cluster.getAnyLeader();
                .put(ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.getKey(), warningDelayMillis + "ms")
                () -> coordinator.setInitialConfiguration(unknownNodeConfiguration)
                    public String toString() {
            follower0.blackhole();
            });
    public void testSingleNodeDiscoveryWithQuorum() {
import static java.util.Collections.emptyMap;
            cluster.stabilise();
            cluster.addNodesAndStabilise(2);
 * this file be licensed under the Apache-2.0 license or a
            assertTrue("expected nack from " + follower1, ackCollector.hasAckedUnsuccessfully(follower1));
     * 3 cluster-manager-eligible nodes (leader, follower1, follower2), the followers are shut down (leader remains), when followers come back
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING) * 2 + randomLongBetween(0, 60000),
                cluster.stabilise();
            cluster.stabilise();
            final PublishClusterStateStats prePublishStats = follower.coordinator.stats().getPublishStats();
import java.util.Set;
            final boolean chosenNodeIsLeader = chosenNode == cluster.getAnyLeader();
    }
            cluster.clusterNodes.add(newNode2);
            assertFalse("expected no immediate ack from " + follower1, ackCollector.hasAcked(follower1));
        }
    }
            cluster.stabilise(
        }
            cluster.stabilise();
            assertThat(
        try (Cluster cluster = new Cluster(3)) {
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
    public void testAckListenerReceivesAcksFromAllNodes() {
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
import java.util.concurrent.atomic.AtomicBoolean;
            assertThat(cluster.getAnyLeader().coordinator.getCurrentTerm(), greaterThanOrEqualTo(originalTerm + 1));
                    )
                () -> coordinator.setInitialConfiguration(unknownNodeConfiguration)
                        // then wait for the removal to be committed
                            + "although publication of cluster state version [*] completed [*] ago"
            cluster.clusterNodes.replaceAll(
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                        @Override
    }
            // possible follow-up reconfiguration was published as a diff
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "committing value");
                    // then wait for the new leader to commit a state without the old leader
                mockLogAppender.addExpectation(
import org.opensearch.OpenSearchException;
            cluster.stabilise();
import org.opensearch.cluster.node.DiscoveryNodeRole;
                final Builder settingsBuilder = Settings.builder().put(cs.metadata().persistentSettings());
                nextNodeIndex.getAndIncrement(), nodeInOtherCluster.getLocalNode(), n -> cluster1.new MockPersistedState(
import static org.opensearch.cluster.coordination.Coordinator.PUBLISH_TIMEOUT_SETTING;
import org.opensearch.test.MockLogAppender;
                                                                                                                                    // round
            assertThat(
            disconnect3.disconnect();
                TestInMemoryMetricsRegistry clusterManagerMetricsRegistry = leader.getMetricsRegistry();
                return ClusterState.builder(cs)
            logger.info("--> adding two new healthy nodes");
                            );
            }
            ClusterNode decommissionedNode = cluster.new ClusterNode(
        }
                    // the leader may have just sent a follower check, which receives no response
            logger.info("--> submitting broken task to [{}]", leader1);
            chosenNode.close();
                        Level.WARN,
            cluster.runRandomly();
 * compatible open source license.
            final ClusterNode leader = cluster.getAnyLeader();
            );
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
            cluster.stabilise(
                assertThat(clusterNode.getId() + " should be a candidate", clusterNode.coordinator.getMode(), equalTo(Mode.CANDIDATE));
            final ClusterNode brokenNode = cluster.getAnyNodeExcept(cluster.getAnyLeader());
            cluster.runRandomly();
                    lastCommittedConfiguration.getNodeIds(),
            cluster.stabilise();
        }
    public void testDiscoveryUsesNodesFromLastClusterState() {
            logger.info("--> blackholing {}", follower);
            logger.info("--> disconnecting {} and {}", disconnect1, disconnect2);
            final ClusterNode disconnect1 = cluster.getAnyNode();
            cluster.runFor(
            cluster1.clusterNodes.add(newNode);
            originalLeader.blackhole();
                    LEADER_CHECK_RETRY_COUNT_SETTING
            if (cluster.clusterNodes.stream().filter(n -> n.getLocalNode().isClusterManagerNode()).count() == 2) {
            }, (source, e) -> {});
        }
            cluster1.stabilise();
    }
                    nodeId + " has an empty last-committed configuration",
            );
            );
            cluster.stabilise();
                    buildNewFakeTransportAddress(),
                    .getLastCommittedConfiguration();
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                "waiting for leader failure"
            AckCollector ackCollector = leader.submitValue(randomLong());
    public void testCannotSetInitialConfigurationWithoutQuorum() {
            cluster.runRandomly();
            );
                tags1.put("follower_node_id", newNode1.getId());
import org.opensearch.common.regex.Regex;
                new DiscoveryNode(
                    postPublishStats.get(cn).getIncompatibleClusterStateDiffReceivedCount()
                // Check for newNode2
                    // followup reconfiguration
                assertThat(lastCommittedConfiguration + " should be 3 nodes", lastCommittedConfiguration.getNodeIds().size(), equalTo(3));
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                    CoordinationMetadata.VotingConfigExclusion.MISSING_VALUE_MARKER,
            final ClusterNode leader = cluster.getAnyLeader();
                );
            // initial cluster state send when joining
            );
                                )
            final ClusterNode originalLeader = cluster.getAnyLeader();
            }
            follower0.setClusterStateApplyResponse(ClusterStateApplyResponse.FAIL);
                    CoordinationStateRejectedException.class,
import static org.opensearch.discovery.PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING;
                        )
                assertFalse(nodeId + " has not received an initial configuration", clusterNode.coordinator.isInitialConfigurationSet());
        }
     * This test was added to verify that state recovery is properly reset on a node after it has become cluster-manager and successfully
            cluster.addNodesAndStabilise(2);
        testAppliesNoClusterManagerBlock("write", NO_CLUSTER_MANAGER_BLOCK_WRITES);
import org.opensearch.cluster.node.DiscoveryNodes;
    public void testAckListenerReceivesNoAckFromHangingFollower() {
    public void testClusterCannotFormWithFailingJoinValidation() {
            }
            );
    }
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
                            assertThat(matchingNodes, hasSize(1));
            assertTrue("expected ack from " + follower1, ackCollector.hasAckedSuccessfully(follower1));
            follower0.setClusterStateApplyResponse(ClusterStateApplyResponse.HANG);
        try (Cluster cluster = new Cluster(randomIntBetween(2, 5), false, Settings.EMPTY)) {
                anyOf(equalTo(newNode1.getId()), equalTo(newNode2.getId()), equalTo(newNode3.getId()))
                validatedNodes.add(discoveryNode);
                    // then wait for a new election
            removedNode.disconnect();
            assertEquals(0L, newNodePublishStats.getIncompatibleClusterStateDiffReceivedCount());
            cluster.stabilise();
                    + (cluster.size() - 1) * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY
        }
        testAppliesNoClusterManagerBlock("metadata_write", NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES);
            long finalValue = randomLong();
            assertTrue(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(leader.getLastAppliedClusterState().metadata().settings()));
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();
            assertFalse(Coordinator.validVotingConfigExclusionState(newState2));
    public void testIncompatibleDiffResendsFullState() {
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);
            );
            cluster.addNodesAndStabilise(randomIntBetween(1, 2));
            cluster.runRandomly();
            assertTrue(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(leader.getLastAppliedClusterState().metadata().settings()));
            final Coordinator coordinator = cluster.getAnyNode().coordinator;
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info")
            final ClusterNode nonLeader = cluster.getAnyNodeExcept(leader);
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);
            final ClusterNode leader = cluster.getAnyLeader();
                            final List<ClusterNode> matchingNodes = cluster.clusterNodes.stream()
 * GitHub history for details.
            cluster.stabilise(DEFAULT_STABILISATION_TIME * 2);
            cluster.runRandomly();
    /**
            final ClusterNode chosenNode = cluster.getAnyNode();
                    "resolvableNodeId",
                .collect(Collectors.toMap(Function.identity(), cn -> cn.coordinator.stats().getPublishStats()));
            cluster.getAnyLeader().extraJoinValidators.add((discoveryNode, clusterState) -> {
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            cluster.stabilise();
            assertThat(restartedNode.getLastAppliedClusterState().blocks().global(), hasItem(expectedBlock));
                    defaultMillis(LEADER_CHECK_TIMEOUT_SETTING) + defaultMillis(LEADER_CHECK_INTERVAL_SETTING)
            cluster.runRandomly();
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader);
                exceptionMessage,
                        Level.INFO,
            final ClusterNode originalLeader = cluster.getAnyLeader();
 * not use this file except in compliance with the License.
            follower1.heal();
import org.apache.logging.log4j.Level;
            final PublishClusterStateStats newNodePublishStats = newNode.coordinator.stats().getPublishStats();
            leader.submitValue(randomLong());
            );
                )
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();
                    new MockLogAppender.SeenEventExpectation(
                @Override
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            );
            logger.info("--> disconnecting follower {}", follower);
        @Override
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                () -> cluster.clusterNodes.replaceAll(
            try (
        final long warningDelayMillis;
            // fail join validation on a majority of nodes in the initial configuration
                Map<String, Object> tags1 = new HashMap<>();
import static org.opensearch.cluster.coordination.Coordinator.Mode.CANDIDATE;
                    // One message delay to send a join
            Cluster cluster = new Cluster(
            assertEquals(
            );
    }
            logger.info("--> leader {} and follower {} get disconnect event", leader, follower);
        Metadata newMetadata = Metadata.builder(currentState.metadata()).coordinationMetadata(coordMetadataBuilder.build()).build();
            );
                        // then wait for the leader to commit a state without the follower
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING;
        }
        }
                cluster.getAnyLeader().getLastAppliedClusterState().getLastCommittedConfiguration().getNodeIds(),
import org.apache.logging.log4j.LogManager;
            cluster.runRandomly();
            final long newClusterStateVersion = cluster.getAnyLeader().getLastAppliedClusterState().version();
            Set<CoordinationMetadata.VotingConfigExclusion> newVotingConfigExclusion1 = singleton(
            disconnect1.heal();
            final ClusterNode disconnect3 = cluster.getAnyNodeExcept(disconnect1, disconnect2);
            cluster.addNodesAndStabilise(1);
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                        // then wait for both of:
                )
            cluster.runRandomly();
            cluster.stabilise();
/*
                mockLogAppender.assertAllExpectationsMatched();
            cluster.runFor(10000, "failing join validation");
                );
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect1.getId()));
            logger.info("--> healing {}", follower);
                        Level.WARN,
            final ClusterNode leader = cluster.getAnyLeader();
            .build();
                hasItem(chosenNode.getId())
    }
                    "resolvableNodeId",
                final VotingConfiguration lastCommittedConfiguration = newLeader.getLastAppliedClusterState()
            cluster.runRandomly();
    public void testDoesNotShrinkConfigurationBelowThreeNodes() {
            cluster.stabilise();
            cluster1.stabilise();
        try (Cluster cluster = new Cluster(randomIntBetween(1, 3))) {
            cluster.stabilise();
     * recovered a state (see {@link GatewayService}). The situation which triggers this with a decent likelihood is as follows:
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> healthStatusInfo.get()
            final Set<DiscoveryNode> validatedNodes = new HashSet<>();
            logger.info("--> blackholing follower {}", follower);
                        // then wait for the leader to try and commit a state removing them, causing it to stand down
                        // 1. the term bumping publication to time out
                    // then wait for both of:
                    + 7 * delayVariabilityMillis, // see definition of DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                                Regex.simpleMatch(
    }
import org.opensearch.common.settings.Settings.Builder;
            disconnect1.disconnect();
                    defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING) + defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING),
                        public String toString() {
        try (Cluster cluster = new Cluster(3)) {
            cluster.stabilise();
            leader2.submitValue(finalValue);
                assertThat(nodeId + " should have found all peers", foundPeers, hasSize(cluster.size()));
            final PublishClusterStateStats postPublishStats = follower.coordinator.stats().getPublishStats();
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            }
                    defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)
                cluster.runFor(
                    // time for joining
                                .build()
            follower0.allowClusterStateApplicationFailure();
                        LogManager.getLogger(ClusterFormationFailureHelper.class)
        }
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,
            {
            cluster.stabilise(
            cluster.runRandomly();
    }
                    + DEFAULT_DELAY_VARIABILITY
            assertTrue("expected eventual ack from " + leader, ackCollector.hasAckedSuccessfully(leader));
import org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.ClusterNode;
    public void testAckListenerReceivesNacksIfPublicationTimesOut() {
                        + defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING)
                    postPublishStats.get(cn).getFullClusterStateReceivedCount()
                synchronized (nonLeader.coordinator.mutex) {
            );
                        // then wait for the followup reconfiguration
            }
            follower.heal();
            final ClusterNode removedNode = cluster.getAnyNode();
            );
                expectThrows(
                            defaultMillis(PUBLISH_TIMEOUT_SETTING),
                        + defaultMillis(PUBLISH_TIMEOUT_SETTING)
            assertFalse(coordinator.setInitialConfiguration(coordinator.getLastAcceptedState().getLastCommittedConfiguration()));
            );
import static org.hamcrest.Matchers.anyOf;
                    cn.toString(),
                        public void assertMatched() {
        public Version getMinimalSupportedVersion() {
            final ClusterNode leader2 = cluster.getAnyLeader();
        try (Cluster cluster = new Cluster(3)) {
                final Set<DiscoveryNode> foundPeers = new HashSet<>();
            cluster.runFor(
        }
                    });
                        LEADER_CHECK_RETRY_COUNT_SETTING
                cluster.stabilise(2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY); // 1st delay for the setting update, 2nd for the reconfiguration
            nonLeader.onNode(() -> {
     * successfully completed state recovery, is never reset to a state where state recovery can be retried.
                    CoordinationMetadata.VotingConfigExclusion.MISSING_VALUE_MARKER
            follower.disconnect();
import static org.hamcrest.Matchers.containsString;
            final ClusterNode leader = cluster.getAnyLeader();
                clusterNode.close();
            leader.submitValue(finalValue);
            assertTrue(addedNodes.stream().allMatch(ClusterNode::isCandidate));
            cluster.runFor(
                )
            cluster.stabilise();
            for (int i = scaledRandomIntBetween(1, 10); i >= 0; i--) {
                        )
                        }
            disconnect2.disconnect();
    }
        }
        try (Cluster cluster = new Cluster(3)) {
                        // then wait for a follower to be promoted to leader
            final ClusterNode clusterNode = cluster.getAnyNode();
            assertTrue("expected immediate ack from " + follower1, ackCollector.hasAckedSuccessfully(follower1));
            leader.heal();
                "leader should be last to ack",
            }
 * The OpenSearch Contributors require contributions made to
                    )
                leader.submitSetAutoShrinkVotingConfiguration(false);
            List<ClusterNode> addedNodes = cluster.addNodes(randomIntBetween(1, 2));
        AtomicReference<StatusInfo> nodeHealthServiceStatus = new AtomicReference<>(new StatusInfo(HEALTHY, "healthy-info"));
                    prePublishStats.get(cn).getIncompatibleClusterStateDiffReceivedCount(),
                        // then wait for the exception response
                // The first pinging discovers the cluster-manager
            cluster.stabilise();
                }
                hasItem(chosenNode.getId())
            );
                logger.info("--> disconnecting {}", partitionedNode);
            cluster.runRandomly();
                        + DEFAULT_DELAY_VARIABILITY
            assertTrue("expected nack from " + leader, ackCollector.hasAckedUnsuccessfully(leader));
            try (Cluster cluster2 = new Cluster(3)) {
            assertFalse("expected no immediate ack from " + follower0, ackCollector.hasAcked(follower0));
                        // then wait for the new leader to commit a state without the old leader
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING)
                        LagDetector.CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING
            cluster.getAllNodesExcept(originalLeader).forEach(originalLeader::onDisconnectEventFrom);
                        + defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING)
        }
            warningDelayMillis = randomLongBetween(1, 100000);
            follower1.onDisconnectEventFrom(leader);
            assertThat(
                assertThat(nodeId + " is CANDIDATE", clusterNode.coordinator.getMode(), is(CANDIDATE));
            originalLeader.disconnect();
                    // Commit a new cluster state with the new node(s). Might be split into multiple commits, and each might need a
    public void testDoesNotElectNonClusterManagerNode() {
import java.util.concurrent.ConcurrentHashMap;
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
import org.opensearch.cluster.ClusterState;
        }
            assertTrue("expected ack from " + leader, ackCollector.hasAckedSuccessfully(leader));
                DetachClusterCommand::updateMetadata,
            // within which we expect to converge, so use a mix of both
                assertThat(lastCommittedConfiguration + " should be 3 nodes", lastCommittedConfiguration.getNodeIds().size(), equalTo(3));
                assertThat(
                                                                                                                                    // voting
                assertThat("term did not change", cluster.getAnyNode().coordinator.getCurrentTerm(), is(termBeforeRestart));
            logger.info("--> disconnecting {} and {}", disconnect1, disconnect2);
 * ownership. Elasticsearch licenses this file to you under
            // well just wait.
            cluster.runRandomly();
            cluster.runFor(DEFAULT_STABILISATION_TIME, "allowing time for fault detection");
                                .collect(Collectors.toList());
                            + Publication.PublicationTargetState.SENT_PUBLISH_REQUEST
        }
            assertThat(removedNode.getLastAppliedClusterState().blocks().global(), hasItem(expectedBlock));
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING;
                    cn.toString(),
    public void testExpandsConfigurationWhenGrowingFromOneNodeToThreeButDoesNotShrink() {
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY * 2); // allow for a reconfiguration
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "committing value");
        }
            ) {
                    defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)
    }
    }
    public void testCanUpdateClusterStateAfterStabilisation() {
                // The first pinging discovers the cluster-manager
        }
    public void testCannotJoinClusterWithDifferentUUID() throws IllegalAccessException {
     * and join the leader again.
        }
import static java.util.Collections.singleton;
            for (ClusterNode clusterNode : Arrays.asList(follower1, follower2)) {
            );
        try (
            partitionedNode.heal();
import static org.hamcrest.Matchers.hasSize;
            assertEquals(validatedNodes, addedNodes.stream().map(ClusterNode::getLocalNode).collect(Collectors.toSet()));
    public void testAppliesNoClusterManagerBlockWritesByDefault() {
     * does not notice the node disconnecting, it is important for the node not to be turned back into a follower but try
import static org.hamcrest.Matchers.hasItem;
            } else {
        ) {
                    defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)
            assertTrue("expected ack from " + leader, ackCollector.hasAckedSuccessfully(leader));
    }
            cluster.stabilise();
            assertTrue("expected eventual nack from " + leader, ackCollector.hasAckedUnsuccessfully(leader));
            );
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(newNode1.getId()));
            for (final ClusterNode clusterNode : cluster.getAllNodesExcept(leader)) {
            ).getMessage();
                CoordinationStateRejectedException.class,
                "elect new leader"
            ClusterNode newNode2 = cluster.new ClusterNode(
        try (Cluster cluster = new Cluster(3)) {
            {
            assertThat(
     */
            final ClusterState currentState = coordinator.getLastAcceptedState();
            {
                        }
                Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE).build()
                cluster.deterministicTaskQueue.setExecutionDelayVariabilityMillis(delayVariabilityMillis);
                                equalTo(cluster.clusterNodes.stream().map(ClusterNode::getLocalNode).collect(Collectors.toSet()))
                        Coordinator.CoordinatorPublication.class.getCanonicalName(),
                final VotingConfiguration lastCommittedConfiguration = newLeader.getLastAppliedClusterState()
import static org.hamcrest.Matchers.not;
        }
            cluster.stabilise();
    }
                ) + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,
            assertTrue(leader.coordinator.getMode() != Coordinator.Mode.LEADER || leader.coordinator.getCurrentTerm() > startingTerm);
    }
                            + ']'
            cluster.runRandomly();
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES;
            assertTrue(failed.get());
            bootstrapNode.applyInitialConfiguration();
                CoordinationStateRejectedException.class,
    public void testAppliesNoClusterManagerBlockAllIfConfigured() {
            // larger variability is are good for checking that we don't time out, but smaller variability also tightens up the time bound
     * it becomes candidate and puts up a NO_MASTER_BLOCK, but then receives a follower check from the leader. If the leader
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
        }
                    lastCommittedConfiguration.getNodeIds(),
                        FOLLOWER_CHECK_RETRY_COUNT_SETTING
                Math.max(
                        "lag warning",
            cluster.stabilise();
            cluster.stabilise(
    public void testLogsMessagesIfPublicationDelayed() throws IllegalAccessException {
            )
            ClusterState newState2 = buildNewClusterStateWithVotingConfigExclusion(currentState, newVotingConfigExclusion2);
}
                    // Allow two round-trip for pre-voting and voting
                ) + (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + DEFAULT_DELAY_VARIABILITY) * defaultInt(
                        defaultMillis(PUBLISH_TIMEOUT_SETTING),
                    // then wait for the followup reconfiguration
            }
            cluster.runRandomly();
                assertFalse(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(leader.getLastAppliedClusterState().metadata().settings()));
                assertThat(nodeId + " last accepted version 0", clusterNode.coordinator.getLastAcceptedState().version(), is(0L));
                            Settings.builder()
                        // wait for the leader to check the follower
                    prePublishStats.get(cn).getFullClusterStateReceivedCount(),
    public void testLeaderDisconnectionWithDisconnectEventDetectedQuickly() {
            }
            cluster.stabilise(
                    "resolvableNodeName",
                TestInMemoryCounter nodeLeftCounter = clusterManagerMetricsRegistry.getCounterStore().get("node.left.count");
            );
            assertThat(cluster.getAnyLeader().getId(), not(equalTo(originalLeader.getId())));
        try (Cluster cluster = new Cluster(3)) {
                    // followup reconfiguration
            AckCollector ackCollector = leader.submitValue(randomLong());
                cluster1.runFor(DEFAULT_STABILISATION_TIME, "failing join validation");
import static org.hamcrest.Matchers.allOf;
                tags1.put("reason", "health.check.fail");
                assertTrue(nodeId + " should not have discovered itself", foundPeers.add(clusterNode.getLocalNode()));
            assertThat(exceptionMessage, containsString("unknown-node"));
                    Version.CURRENT
            // other options, so there's no point in failing and retrying from scratch no matter how badly disrupted we are and we may as
                                                                                                                                    // and
            assertEquals(1L, newNodePublishStats.getFullClusterStateReceivedCount());
            assertFalse("expected no ack from " + follower0, ackCollector.hasAcked(follower0));
    }
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5), false, Settings.EMPTY)) {
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);
            cluster.stabilise();
            cluster.runRandomly();
                    lastCommittedConfiguration.getNodeIds(),
    public void testUnresponsiveLeaderDetectedEventually() {
import org.opensearch.common.settings.Settings;
                    .getLastCommittedConfiguration();
            leader.setClusterStateApplyResponse(ClusterStateApplyResponse.FAIL);
    }
 * KIND, either express or implied.  See the License for the
            cluster.stabilise();
                        + DEFAULT_DELAY_VARIABILITY
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
                logger.info("--> blackholing {}", partitionedNode);
import org.opensearch.cluster.coordination.Coordinator.Mode;
                                        .<String>getValue(NODE_ID_LOG_CONTEXT_KEY)
                );
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                mockAppender.addExpectation(
    public void testDoesNotShrinkConfigurationBelowFiveNodesIfAutoShrinkDisabled() {
                Math.max(
            final ClusterNode follower = cluster.getAnyNodeExcept(leader);
                assertEquals(
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();
                    // Then a commit of the new leader's first cluster state
            }));
            cluster.clusterNodes.add(newNode2);
import org.opensearch.cluster.metadata.Metadata;
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect2.getId()));
    public void testStayCandidateAfterReceivingFollowerCheckFromKnownClusterManager() {
                not(hasItem(chosenNode.getId()))
     */
                partitionedNode.disconnect();
                Math.max(
                equalTo(2)
                        new FollowersChecker.FollowerCheckRequest(leader.coordinator.getCurrentTerm(), leader.getLocalNode())
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "committing value");
            }
            }
import static org.hamcrest.Matchers.sameInstance;
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
                        // then wait for the exception response
    }
                            + brokenNode
                    // FINALLY:
            cluster.runRandomly();
                prePublishStats.getIncompatibleClusterStateDiffReceivedCount() + 1,
            ).forEach(cn -> cn.extraJoinValidators.add((discoveryNode, clusterState) -> {
                    containsString("cannot start with [discovery.type] set to [single-node] when local node"),
    public void testClusterStabilisesForPreviouslyDecommissionedNode() {
            logger.info("--> restarting [{}] as a cluster-manager-ineligible node", chosenNode);
        try (Cluster cluster = new Cluster(3)) {
                cluster.getAnyLeader().getId(),
            ClusterNode newNode1 = cluster.new ClusterNode(
            logger.info("setting auto-shrink reconfiguration to true");
    public void testCanShrinkFromFiveNodesToThree() {
            cluster.runFor(DEFAULT_STABILISATION_TIME, "allowing time for fault detection");
 *
    }
                        // then wait for the exception response
                    // Each follower may have just sent a leader check, which receives no response
                            (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(
            final ClusterNode leader = cluster.getAnyLeader();
            cluster.runRandomly();
            if (randomBoolean()) {
            assertTrue("expected ack from " + follower0, ackCollector.hasAckedSuccessfully(follower0));
                    // ALSO the leader may have just sent a follower check, which receives no response
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                    assertThat(e.getCause().getMessage(), equalTo(BrokenCustom.EXCEPTION_MESSAGE));
                );
                nodeInOtherCluster = randomFrom(cluster2.clusterNodes);
                    cn.transportService.disconnectFromNode(clusterNode.getLocalNode());
                assertThat("term should not change", cluster.getAnyNode().coordinator.getCurrentTerm(), is(expectedTerm));
        }
        }
            final ClusterNode disconnect1 = cluster.getAnyNode();
            }
            cluster.clearBlackholedConnections();
                    lastCommittedConfiguration + " should be all nodes",
                        @Override
            assertTrue("expected eventual nack from " + follower1, ackCollector.hasAckedUnsuccessfully(follower1));
                    clusterNode.coordinator.getLastAcceptedState().getLastAcceptedConfiguration().isEmpty()
                )
                (source, e) -> {
                newNode.nodeSettings
            logger.info("--> followers get disconnect event for leader {} ", originalLeader);
            cluster.stabilise();
import static org.hamcrest.Matchers.equalTo;
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
                // time for the disconnected node to find the cluster-manager again
            removedNode.close();
                    + DEFAULT_ELECTION_DELAY
                    + defaultMillis(PUBLISH_TIMEOUT_SETTING)
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,
                        ? cn.restartedNode(
                    cn -> cn == clusterNode
    }
        }
            assertThat(
            final ClusterNode leader = cluster.getAnyLeader();
                );
                    n, nodeInOtherCluster.persistedStateRegistry, Function.identity(), Function.identity()
                            assertTrue(
     * Old leader is initiating an election at the same time, and wins election. It becomes leader again, but as it previously
                        // wait for the leader to check its followers
                leader.getLastAppliedClusterState().nodes().getSize(),
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            );
            }
                (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + defaultMillis(LEADER_CHECK_TIMEOUT_SETTING))
            }
    }
            final ClusterNode disconnect2 = cluster.getAnyNodeExcept(disconnect1);
            assertThat("leader should be last to ack", ackCollector.getSuccessfulAckIndex(leader), equalTo(1));
            decommissionedNode.coordinator.onNodeCommissionStatusChange(false);
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            cluster.stabilise();
            cluster.stabilise();
import java.util.function.Function;
        try (Cluster cluster = new Cluster(3)) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            cluster.runRandomly();
            healthStatusInfo.getAndSet(new StatusInfo(UNHEALTHY, "unhealthy-info"));
                assertTrue(counterValuesByTags.containsKey(tags1));
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
            final ClusterNode otherNode = cluster.getAnyNodeExcept(leader);
import static org.opensearch.discovery.PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING;
            );
            leader1.submitUpdateTask(
            }
            }
                assertThat(
                brokenNode.blackhole();
 * Licensed to Elasticsearch under one or more contributor
            ClusterNode newNode2 = cluster.new ClusterNode(
        ) {
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING;
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "publish first state");
    }
                clusterNode.coordinator.getFoundPeers().forEach(foundPeers::add);
                        // then wait for the follower to check the leader
                    + defaultMillis(LEADER_CHECK_INTERVAL_SETTING) // to wait for the next check to be sent
            assertEquals(previousClusterStateVersion, newClusterStateVersion);
