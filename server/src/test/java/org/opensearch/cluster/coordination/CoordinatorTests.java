            follower0.heal();  
    public void testDoesNotPerformElectionWhenRestartingFollower() {
        public Version getMinimalSupportedVersion() {
                        // then wait for the exception response
                            // 1. the term bumping publication to time out
import static org.opensearch.cluster.coordination.Coordinator.Mode.CANDIDATE;
            cluster.runRandomly();
            cluster.stabilise();
                        // then wait for the new leader to commit a state without the old leader
            for (final ClusterNode clusterNode : cluster.clusterNodes) {  
            assertFalse("expected no ack from " + leader, ackCollector.hasAckedSuccessfully(leader));
            );  
 */
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
                    emptyMap(),
        }
                assertEquals(
                cluster.clusterNodes.replaceAll(cn -> cn == clusterNode ? cn.restartedNode() : cn);  
            );
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                // Check for newNode2
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info")
                    (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(
                partitionedNode.blackhole();
            assertEquals(0L, newNodePublishStats.getIncompatibleClusterStateDiffReceivedCount());
                        // then wait for the exception response
                        // then wait for the followup reconfiguration
                    lastCommittedConfiguration + " should be all nodes",
            cluster.runRandomly();
                    // ALSO the leader may have just sent a follower check, which receives no response  
                        cn.transportService.disconnectFromNode(clusterNode.getLocalNode());
            final ClusterNode leader2 = cluster.getAnyLeader();  
        if (randomBoolean()) {  
            assertEquals(
 * compatible open source license.
            disconnect2.heal();
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))
                startsWith("not enough nodes discovered to form a quorum in the initial configuration [knownNodes=[")
            if (randomBoolean()) {
                                        .<String>getValue(NODE_ID_LOG_CONTEXT_KEY)  
    }  
                        "publication warning",  
            if (cluster.clusterNodes.stream().filter(n -> n.getLocalNode().isClusterManagerNode()).count() == 2) {
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);
            assertThat(cluster.getAnyLeader().getId(), not(equalTo(originalLeader.getId())));
    }
    }  
            removedNode.disconnect();
                final VotingConfiguration lastCommittedConfiguration = newLeader.getLastAppliedClusterState()
            final ClusterNode leader = cluster.getAnyLeader();
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
                                equalTo(cluster.clusterNodes.stream().map(ClusterNode::getLocalNode).collect(Collectors.toSet()))  
            cluster.runRandomly();  
            logger.info("--> blackholing follower {}", follower);  
            final ClusterNode chosenNode = cluster.getAnyNode();
            follower0.setClusterStateApplyResponse(ClusterStateApplyResponse.FAIL);
                    + DEFAULT_DELAY_VARIABILITY  
                        }
            final ClusterNode originalLeader = cluster.getAnyLeader();
            cluster.stabilise();
                IllegalStateException.class,
        }
            cluster.runRandomly();  
            );
            assertTrue("expected eventual nack from " + follower1, ackCollector.hasAckedUnsuccessfully(follower1));
                nextNodeIndex.getAndIncrement(), nodeInOtherCluster.getLocalNode(), n -> cluster1.new MockPersistedState(
                assertThat(clusterNode.getId() + " should be a candidate", clusterNode.coordinator.getMode(), equalTo(Mode.CANDIDATE));
            final Map<ClusterNode, PublishClusterStateStats> postPublishStats = cluster.clusterNodes.stream()
                assertThat(nodeId + " has the applied value", value(appliedState), is(finalValue));
        try (Cluster cluster = new Cluster(3)) {
                    + defaultMillis(PUBLISH_TIMEOUT_SETTING)
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
                    CoordinationStateRejectedException.class,
        try (Cluster cluster = new Cluster(2, false, Settings.EMPTY)) {
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;  
        testAppliesNoClusterManagerBlock("all", NO_CLUSTER_MANAGER_BLOCK_ALL);
import static org.hamcrest.Matchers.anyOf;  
import static org.hamcrest.Matchers.containsString;
                mockLogAppender.addExpectation(
    public void testCannotSetInitialConfigurationTwice() {
                logger.debug("forcing {} to become candidate", nonLeader.getId());
        try (Cluster cluster = new Cluster(3)) {  
                    postPublishStats.get(cn).getIncompatibleClusterStateDiffReceivedCount()
                        }
                    lastCommittedConfiguration + " should be all nodes",
        }
                            + brokenNode.getLocalNode()
            cluster.stabilise();  
            cluster.runRandomly();
                () -> randomSubsetOf(cluster.clusterNodes)
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                public String toString() {
                        // then wait for the exception response  
    /**
                    // FINALLY:
            }
                clusterNode.disconnect();  
    public void testSingleNodeDiscoveryStabilisesEvenWhenDisrupted() {
    public void testLeaderDisconnectionWithoutDisconnectEventDetectedQuickly() {
                    // wait for the removal to be committed
            disconnect1.disconnect();  
            assertTrue("expected nack from " + follower0, ackCollector.hasAckedUnsuccessfully(follower0));
            assertTrue("expected ack from " + leader, ackCollector.hasAckedSuccessfully(leader));
            }, (source, e) -> {});
import org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.ClusterNode;
            logger.info("--> healing {}", follower);  
                    )  
            cluster.clusterNodes.add(newNode2);
 *
            // well just wait.  
            {  
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING;  
    public void testExpandsConfigurationWhenGrowingFromOneNodeToThreeButDoesNotShrink() {
        }  
                    new Runnable() {
            restartedNode.disconnect();  
                        + DEFAULT_DELAY_VARIABILITY
            cluster.stabilise(
                            + Publication.PublicationTargetState.SENT_PUBLISH_REQUEST  
            {  
    public void testCannotJoinClusterWithDifferentUUID() throws IllegalAccessException {  
            });  
                cluster.getAnyLeader().getLastAppliedClusterState().getLastAcceptedConfiguration().getNodeIds(),
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
    public void testSingleNodeDiscoveryWithQuorum() {
                            );
                    + 3 * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            final Coordinator coordinator = cluster.getAnyLeader().coordinator;
     */  
    /**  
                    lastCommittedConfiguration.getNodeIds(),
            final ClusterNode leader1 = cluster.getAnyLeader();
            );
                equalTo(2)
            assertTrue(cluster.clusterNodes.stream().allMatch(cn -> cn.getLastAppliedClusterState().version() == 0));
                        // then wait for the follower to check the leader
                        + DEFAULT_ELECTION_DELAY  
        }
            logger.info("--> disconnecting follower {}", follower);
                hasItem(chosenNode.getId())  
                        + defaultMillis(PUBLISH_TIMEOUT_SETTING)
                    + 2 * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY  
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                    (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)) * defaultInt(  
                            assertThat(matchingNodes, hasSize(1));
            cluster.runRandomly();  
    }
                assertThat(clusterNode.getId() + " should be a candidate", clusterNode.coordinator.getMode(), equalTo(Mode.CANDIDATE));
            ClusterNode decommissionedNode = cluster.new ClusterNode(
            }  
    }
            // cluster has two nodes in mode LEADER, in different terms ofc, and the one in the lower term won’t be able to publish anything
                hasItem(chosenNode.getId())
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                        + defaultMillis(LEADER_CHECK_INTERVAL_SETTING)
                                                                                                                                    // trips  
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "committing value");
            cluster.clusterNodes.add(newNode1);
                            Settings.builder()
                assertTrue(counterValuesByTags.containsKey(tags2));  
            bootstrapNode.applyInitialConfiguration();
    }
    public void testFollowerRemovedIfUnableToSendRequestsToClusterManager() {  
                    .getLastCommittedConfiguration();  
                    .getLastCommittedConfiguration();
        }  
            assertFalse("expected no immediate ack from " + follower0, ackCollector.hasAcked(follower0));
            cluster.runRandomly();
            final ClusterNode leader = cluster.getAnyLeader();
            cluster.runRandomly();
            logger.info("--> submitting second value to {}", leader);
            assertFalse("expected no ack from " + follower0, ackCollector.hasAcked(follower0));
            );  
    }
            cluster.stabilise();
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
                        }
            );
 * Modifications Copyright OpenSearch Contributors. See  
            )
            ).getMessage();
                        Coordinator.CoordinatorPublication.class.getCanonicalName(),  
                );
            // possible follow-up reconfiguration was published as a diff
                    + 7 * delayVariabilityMillis, // see definition of DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            {
            assertEquals(1L, newNodePublishStats.getFullClusterStateReceivedCount());
            {
            addedNodes.forEach(cn -> cn.extraJoinValidators.add((discoveryNode, clusterState) -> {  
            final ClusterNode disconnect3 = cluster.getAnyNodeExcept(disconnect1, disconnect2);
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                logger.info("--> disconnecting {}", partitionedNode);  
            // we require another node to heal to recover
            final long delayVariabilityMillis = randomLongBetween(DEFAULT_DELAY_VARIABILITY, TimeValue.timeValueMinutes(10).millis());
                cluster.getAnyLeader().getId(),  
            originalLeader.blackhole();  
            return Version.V_EMPTY;  
                    )
                            + ']'
                    // wait for the removal to be committed
                assertThat(lastCommittedConfiguration + " should be 3 nodes", lastCommittedConfiguration.getNodeIds().size(), equalTo(3));
                        // 2. the new leader to notice that the old leader is unresponsive
            logger.info("--> disconnecting {} and {}", disconnect1, disconnect2);
            assertThat(
        }  
                final String nodeId = clusterNode.getId();
                    cn.transportService.disconnectFromNode(clusterNode.getLocalNode());
                assertTrue(node.coordinator.localNodeCommissioned());  
        AtomicReference<StatusInfo> healthStatusInfo = new AtomicReference<>(new StatusInfo(HEALTHY, "healthy-info"));
            if (randomBoolean()) {
                    + defaultMillis(LEADER_CHECK_INTERVAL_SETTING) // to wait for the next check to be sent
            cluster.stabilise();
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
            cluster.runRandomly();
        }  
            assertTrue("expected eventual nack from " + follower0, ackCollector.hasAckedUnsuccessfully(follower0));  
            .build();
                                    "*have discovered *" + matchingNodes.get(0).toString() + "*discovery will continue*",
            cluster.stabilise();  
            assertThat(restartedNode.getLastAppliedClusterState().blocks().global(), hasItem(expectedBlock));  
            disconnect1.heal();
            )  
            );
            );
                    defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING) + defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING),
        try (Cluster cluster = new Cluster(3)) {
     * Simulates a situation where a follower becomes disconnected from the leader, but only for such a short time where
            final ClusterNode disconnect1 = cluster.getAnyNode();
            assertTrue(addedNodes.stream().allMatch(ClusterNode::isCandidate));
            cluster.runRandomly();
     * it becomes candidate and puts up a NO_MASTER_BLOCK, but then receives a follower check from the leader. If the leader
            leader.submitSetAutoShrinkVotingConfiguration(true);
    }
                    new MockLogAppender.SeenEventExpectation("test1", JoinHelper.class.getCanonicalName(), Level.INFO, "*failed to join*")
                    // ALSO wait for the leader to notice that its followers are unresponsive  
            {
            ClusterNode newNode2 = cluster.new ClusterNode(  
                final String nodeId = clusterNode.getId();
    }
            );
            toHeal.heal();
            }  
                        "after [*] publication of cluster state version [*] is still waiting for "
                .build();
                "initial discovery phase"
            assertThat(cluster.getAnyLeader().coordinator.getCurrentTerm(), greaterThanOrEqualTo(originalTerm + 1));
        }
                        + defaultMillis(LEADER_CHECK_INTERVAL_SETTING)  
    }
                final Set<DiscoveryNode> foundPeers = new HashSet<>();
            cluster.getAllNodesExcept(originalLeader).forEach(originalLeader::onDisconnectEventFrom);
                            (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(
            cluster.stabilise(
                final ClusterState appliedState = clusterNode.getLastAppliedClusterState();  
    }  
                        // then wait for the exception response, causing the follower to become a candidate  
                    // then wait for the new leader to commit a state without the old leader
                        @Override
    }  
                "stabilising"  
            final ClusterNode clusterNode = cluster.getAnyNode();
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))  
                );  
            // This is VERY BAD: setting a _different_ initial configuration. Yet it works if the first attempt will never be a quorum.
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
            }  
                cluster.deterministicTaskQueue.setExecutionDelayVariabilityMillis(delayVariabilityMillis);
                    )
                                    n -> event.getContextData()
            assertTrue(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(leader.getLastAppliedClusterState().metadata().settings()));  
            final PublishClusterStateStats prePublishStats = follower.coordinator.stats().getPublishStats();
                    // then wait for the followup reconfiguration  
                    // Each follower may have just sent a leader check, which receives no response
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {  
                assertThat(
                        + DEFAULT_DELAY_VARIABILITY,
            assertEquals(prePublishStats.getFullClusterStateReceivedCount() + 1, postPublishStats.getFullClusterStateReceivedCount());  
        }
    public void testFollowerDisconnectionWithoutDisconnectEventDetectedQuickly() {
                            return "healing " + brokenNode;  
            assertThat(cluster.getAnyLeader().getId(), not(equalTo(originalLeader.getId())));  
                            Function.identity(),  
            final ClusterNode disconnect2 = cluster.getAnyNodeExcept(disconnect1);  
            final long newTerm = cluster.getAnyLeader().coordinator.getCurrentTerm();
                );
                assertThat(nodeId + " has the applied value", value(appliedState), is(finalValue));
 */
        }
                        // then wait for the exception response
            final ClusterNode leader = cluster.getAnyLeader();
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,  
                Map<String, Object> tags1 = new HashMap<>();
            cluster.stabilise();
import java.util.Map;
            final long expectedTerm = leader.coordinator.getCurrentTerm();
            final ClusterNode disconnect3 = cluster.getAnyNodeExcept(disconnect1, disconnect2);
                "detecting disconnection"
    }
                        // then wait for the exception response
        try (Cluster cluster = new Cluster(3)) {  
        }
            cluster.stabilise();
            follower.heal();
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY  
    }
                        + DEFAULT_ELECTION_DELAY,
                    defaultMillis(LEADER_CHECK_TIMEOUT_SETTING) + defaultMillis(LEADER_CHECK_INTERVAL_SETTING)
            chosenNode.close();
                    cn -> cn == clusterNode  
                new CoordinationMetadata.VotingConfigExclusion(
                        // then wait for the followup reconfiguration  
            try (
        }  
                    // the leader may have just sent a follower check, which receives no response  
            ClusterNode newNode1 = cluster.new ClusterNode(  
            final ClusterNode follower = cluster.getAnyNodeExcept(leader);
                new DiscoveryNode(
        }  
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);
            final ClusterNode disconnect2 = cluster.getAnyNodeExcept(disconnect1);  
                term -> DetachClusterCommand.updateCurrentTerm(),  
                .collect(Collectors.toMap(Function.identity(), cn -> cn.coordinator.stats().getPublishStats()));  
                cluster2.stabilise();
                ConcurrentHashMap<Map<String, ?>, Double> counterValuesByTags = nodeLeftCounter.getCounterValueForTags();
                ), nodeInOtherCluster.nodeSettings, () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info")
            leader.submitSetAutoShrinkVotingConfiguration(true);
            follower1.heal();
            );
                throw new IllegalArgumentException("join validation failed");
    public void testAckListenerReceivesNacksFromFollowerInHigherTerm() {  
            cluster.runRandomly();
            cluster.stabilise(); // would not work if disconnect1 were removed from the configuration
            final ClusterNode leader = cluster.getAnyLeader();  
                "awaiting removal of asymmetrically-partitioned node"
                // Check for newNode1
                    cn.toString(),  
                        return "disconnect from " + clusterNode.getLocalNode() + " after shutdown";  
    }
            final ClusterNode leader = cluster.getAnyLeader();
                "broken-task",
            follower1.blackhole();  
            }
            assertTrue(failed.get());
            final ClusterNode disconnect4 = cluster.getAnyNodeExcept(disconnect1, disconnect2, disconnect3);
        }
        try (Cluster cluster = new Cluster(3)) {
                    // followup reconfiguration
                            assertThat(  
            }
    }
                assertTrue(
            cluster1.stabilise();
            cluster.stabilise();
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info")  
    }
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            final ClusterNode leader = cluster.getAnyLeader();
            cluster.stabilise();
                    prePublishStats.get(cn).getCompatibleClusterStateDiffReceivedCount() + 1,
                        Level.INFO,
            })));
                    defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)
import static org.hamcrest.Matchers.is;
            cluster.getAnyLeader().extraJoinValidators.clear();
    }  
            for (final ClusterNode clusterNode : cluster.clusterNodes) {  
                    clusterNode.coordinator.getLastAcceptedState().getLastCommittedConfiguration().isEmpty()
            assertThat(cluster.getAnyLeader().getId(), not(equalTo(originalLeader.getId())));  
            logger.info("--> blocking cluster state application on {}", follower0);  
            cluster.stabilise(  
                    // time for joining  
            cluster.stabilise();
                logger.info("--> restarting {}", clusterNode);  
        }
import org.opensearch.cluster.ClusterState;  
            originalLeader.disconnect();
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            logger.info("setting auto-shrink reconfiguration to true");  
            AckCollector ackCollector = leader.submitValue(randomLong());
            final ClusterNode follower2 = cluster.getAnyNodeExcept(leader, follower1);
            cluster.runRandomly();
            );
                    lastCommittedConfiguration.getNodeIds(),  
            cluster.stabilise();  
            logger.info("--> disconnecting {} and {}", disconnect1, disconnect2);
            assertTrue("expected ack from " + follower1, ackCollector.hasAckedSuccessfully(follower1));
            );
                final ClusterNode newLeader = cluster.getAnyLeader();
    }  
                new FollowersChecker.FollowerCheckRequest(originalTerm + 1, leader.coordinator.getLocalNode())
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING) * 2 + randomLongBetween(0, 60000),  
                        new FollowersChecker.FollowerCheckRequest(leader.coordinator.getCurrentTerm(), leader.getLocalNode())
                randomBoolean(),  
                assertThat("term should not change", cluster.getAnyNode().coordinator.getCurrentTerm(), is(expectedTerm));  
            cluster.stabilise();
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "cluster state update");
                cluster.getAnyLeader().getLastAppliedClusterState().getLastCommittedConfiguration().getNodeIds(),
                mockAppender.assertAllExpectationsMatched();
            final ClusterNode disconnect1 = cluster.getAnyNode();
        }
                        Level.WARN,  
    }
            logger.info("--> restarting [{}] as a cluster-manager-ineligible node", chosenNode);  
                    defaultMillis(PUBLISH_TIMEOUT_SETTING) + 2 * DEFAULT_DELAY_VARIABILITY + defaultMillis(  
                assertThat(  
                Math.max(
                        "lag warning",
            assertEquals(validatedNodes, addedNodes.stream().map(ClusterNode::getLocalNode).collect(Collectors.toSet()));  
            final Coordinator coordinator = cluster.getAnyNode().coordinator;  
            cluster.runFor(10000, "failing join validation");
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {  
     * and join the leader again.
                Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE).build()  
            {  
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect2.getId()));
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                DetachClusterCommand::updateMetadata,
            final ClusterNode follower = cluster.getAnyNodeExcept(leader);
            // however we do not tolerate the loss of yet another one
            final ClusterNode leader = cluster.getAnyLeader();  
            cluster.runRandomly();
                    lastCommittedConfiguration + " should be all nodes",  
        final Settings settings;
            cluster.stabilise();  
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5), false, Settings.EMPTY)) {
            assertThat(exceptionMessage, containsString(coordinator.getLocalNode().toString()));
        }
            cluster.stabilise(  
                    // then wait for a follower to be promoted to leader
        }  
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
                tags1.put("follower_node_id", newNode1.getId());  
            cluster.runRandomly();
                CoordinationStateRejectedException.class,  
import org.opensearch.test.MockLogAppender;
            cluster.runFor(
    public void testDoesNotShrinkConfigurationBelowFiveNodesIfAutoShrinkDisabled() {  
                                                                                                                                    // pre-voting
            cluster.stabilise();
 * software distributed under the License is distributed on an
                            + brokenNode
            cluster.runFor(  
    public void testUnHealthyLeaderRemoved() {
                );  
            logger.info("--> disconnecting {} and {}", disconnect1, disconnect2);
            final ClusterNode disconnect2 = cluster.getAnyNodeExcept(disconnect1);  
            // A cluster using single-node discovery should not apply any timeouts to joining or cluster state publication. There are no
                                )
                return ClusterState.builder(cs)
                // drop the publication messages to one node, but then restore connectivity so it remains in the cluster and does not fail
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);  
                            final List<ClusterNode> matchingNodes = cluster.clusterNodes.stream()  
            cluster.stabilise();
                        // and the first publication times out because of the unresponsive node
                    mockLogAppender.assertAllExpectationsMatched();
            cluster.addNodesAndStabilise(2);
            leader1.submitUpdateTask(
            assertFalse(coordinator.setInitialConfiguration(coordinator.getLastAcceptedState().getLastCommittedConfiguration()));
                );
            );
            disconnect2.disconnect();  
                                                                                                                                    // for
                    )
                assertEquals(  
                assertTrue(lastCommittedConfiguration.getNodeIds().contains(disconnect3.getId()));
                    "resolvableNodeName",
            cluster.stabilise(DEFAULT_ELECTION_DELAY);  
                        Coordinator.CoordinatorPublication.class.getCanonicalName(),
        }
            );
 * You may obtain a copy of the License at  
        try (
                );  
            follower.onDisconnectEventFrom(leader); // to turn follower into candidate, which stabilisation asserts at the end
    }
import static org.opensearch.cluster.coordination.Reconfigurator.CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION;
        }
                        + DEFAULT_DELAY_VARIABILITY
            cluster.setEmptySeedHostsList();  
                assertEquals(Double.valueOf(1.0), counterValuesByTags.get(tags1));  
import static org.opensearch.discovery.PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING;
                        LagDetector.class.getCanonicalName(),
            );
            // other options, so there's no point in failing and retrying from scratch no matter how badly disrupted we are and we may as
                    )
                validatedNodes.add(discoveryNode);
            follower0.blackhole();
                // The first pinging discovers the cluster-manager
            logger.info("--> healing {} and {}", disconnect1, disconnect2);
    }
                assertThat(leader.coordinator.getMode(), is(Mode.LEADER));
                Map<String, Object> tags2 = new HashMap<>();  
                        // then wait for a new election  
                nodeInOtherCluster = randomFrom(cluster2.clusterNodes);
            );  
            cluster.clusterNodes.remove(clusterNode); // to avoid closing it twice
            leader2.submitValue(finalValue);
            }
            logger.debug("rebooting [{}]", clusterNode.getId());
                Math.max(
    public void testUnresponsiveFollowerDetectedEventually() {
            cluster.stabilise();  
            final long currentTerm = cluster.getAnyLeader().coordinator.getCurrentTerm();
                final Builder settingsBuilder = Settings.builder().put(cs.metadata().persistentSettings());  
import org.opensearch.common.unit.TimeValue;  
                        // then wait for the followup reconfiguration
            assertThat(
                DEFAULT_DELAY_VARIABILITY // disconnect is scheduled
            final ClusterNode toHeal = randomBoolean() ? disconnect3 : disconnect4;  
                )
                                startsWith(
            assertThat(cluster.getAnyLeader(), sameInstance(clusterNode));  
                anyOf(equalTo(newNode1.getId()), equalTo(newNode2.getId()), equalTo(newNode3.getId()))
import static java.util.Collections.singleton;
        try (Cluster cluster = new Cluster(3)) {  
        }  
    }
            assertTrue(leader.coordinator.getMode() != Coordinator.Mode.LEADER || leader.coordinator.getCurrentTerm() > startingTerm);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertFalse(nodeId + " has not received an initial configuration", clusterNode.coordinator.isInitialConfigurationSet());  
            }
 * the Apache License, Version 2.0 (the "License"); you may
            final ClusterNode clusterNode = cluster.getAnyNode();
                );
                () -> coordinator.setInitialConfiguration(unknownNodeConfiguration)
            for (final ClusterNode clusterNode : cluster.clusterNodes) {  
                    // One message delay to send a join
                    CoordinationMetadata.VotingConfigExclusion.MISSING_VALUE_MARKER,
            }
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {  
            final ClusterNode disconnect1 = cluster.getAnyNode();
                }
                            nodesLogged.add(matchingNodes.get(0).getLocalNode());
            cluster.addNodesAndStabilise(1);  
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);  
                    defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)  
            }
            cluster.clusterNodes.add(decommissionedNode);  
            final ClusterNode originalLeader = cluster.getAnyLeader();
            final ClusterNode originalLeader = cluster.getAnyLeader();  
                                Regex.simpleMatch(
        DiscoveryNodes newNodes = DiscoveryNodes.builder(currentState.nodes())
                )
            cluster.getAnyLeader().submitSetAutoShrinkVotingConfiguration(false);
                                                                                                                                    // and  
                                nodesLogged + " vs " + cluster.clusterNodes,
    }  
    }
            cluster.clusterNodes.forEach(cn -> cluster.deterministicTaskQueue.scheduleNow(cn.onNode(new Runnable() {
                    nonLeader.coordinator.becomeCandidate("forced");
                            + " ["
            assertEquals(previousClusterStateVersion, newClusterStateVersion);  
            // within which we expect to converge, so use a mix of both  
    public void testJoiningNodeReceivesFullState() {
            );
            }
                    + DEFAULT_ELECTION_DELAY  
            assertEquals(previousClusterStateVersion, newClusterStateVersion);  
                Math.max(
            disconnect1.disconnect();
    }
                        // 1. the term bumping publication to time out
            follower.disconnect();
            final ClusterNode leader = cluster.getAnyLeader();
            ClusterNode newNode3 = cluster.new ClusterNode(
            cluster.stabilise();
                    // Commit a new cluster state with the new node(s). Might be split into multiple commits, and each might need a
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {  
        try (Cluster cluster = new Cluster(3)) {
        return ClusterState.builder(currentState).nodes(newNodes).metadata(newMetadata).build();
            logger.info("--> leader {} and follower {} get disconnect event", leader, follower);  
                // health checks  
            follower.blackhole();
            );
            cluster.stabilise(
    public void testUnhealthyNodesGetsRemoved() {
                assertThat(nodeId + " last accepted version 0", clusterNode.coordinator.getLastAcceptedState().version(), is(0L));
     * one of them becomes leader and publishes first state (with STATE_NOT_RECOVERED_BLOCK) to old leader, which accepts it.  
            // detection and ongoing publications do not time out
        public String getWriteableName() {  
            // cf. DEFAULT_STABILISATION_TIME, but stabilisation is quicker when there's a single node - there's no meaningful fault
                assertThat(
            );
    ) {
                            + brokenNode.getLocalNode()  
                    + 3 * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            {
        public void writeTo(StreamOutput out) throws IOException {
            cluster.runRandomly();
            // let followers elect a leader among themselves before healing the leader and running the publication
            );  
            );  
    public void testCannotSetInitialConfigurationWithoutQuorum() {
                            assertThat(
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        }
            assertTrue("expected nack from " + leader, ackCollector.hasAckedUnsuccessfully(leader));  
                // pre-voting round and proceed to an election, so there cannot be any collisions
            cluster.getAllNodesExcept(originalLeader).forEach(cn -> cn.onDisconnectEventFrom(originalLeader));  
            cluster.stabilise();
                not(hasItem(chosenNode.getId()))  
            cluster.stabilise();  
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();  
            final ClusterNode restartedNode = removedNode.restartedNode();
        Set<CoordinationMetadata.VotingConfigExclusion> newVotingConfigExclusion  
        }
     */
                    // there might be a term bump causing another election  
            final long startingTerm = leader.coordinator.getCurrentTerm();  
            );  
                        public void run() {  
            assertFalse(decommissionedNode.coordinator.localNodeCommissioned());
                DEFAULT_DELAY_VARIABILITY // disconnect is scheduled
                    // then wait for a new election
                            defaultMillis(PUBLISH_TIMEOUT_SETTING),  
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            cluster.addNodesAndStabilise(2);
                ) + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,  
                cluster.clusterNodes.replaceAll(
 * GitHub history for details.
            logger.info("--> disconnecting {}", disconnect2);
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {  
                                .build()  
            disconnect3.disconnect();  
        }
                                .filter(
            final ClusterNode nodeInOtherCluster;
                        ? cn.restartedNode(
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
package org.opensearch.cluster.coordination;
                final VotingConfiguration lastCommittedConfiguration = newLeader.getLastAppliedClusterState()  
        }
import java.io.IOException;
                logger.debug("simulate follower check coming through from {} to {}", leader.getId(), nonLeader.getId());  
            final ClusterNode nonLeader = cluster.getAnyNodeExcept(leader);  
                CoordinationStateRejectedException.class,  
            assertTrue(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(leader.getLastAppliedClusterState().metadata().settings()));  
        }
                    buildNewFakeTransportAddress(),
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            // once cluster stabilises the node joins and would be commissioned
            cluster.clusterNodes.add(newNode1);  
                assertThat(clusterNode.getId() + " should be a candidate", clusterNode.coordinator.getMode(), equalTo(Mode.CANDIDATE));
    }
import java.util.Set;
                        FOLLOWER_CHECK_RETRY_COUNT_SETTING
        try (Cluster cluster = new Cluster(randomIntBetween(1, 3), true, Settings.EMPTY, () -> nodeHealthServiceStatus.get())) {  
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES;
            );  
        }
            return builder;
                    // then wait for the followup reconfiguration  
                postPublishStats.getIncompatibleClusterStateDiffReceivedCount()
                    @Override
import org.opensearch.common.settings.Settings;
            cluster.runRandomly();
                        // wait for the leader to check its followers
            assertThat(  
            clusterNode.close();  
            cluster.stabilise();  
    private void testAppliesNoClusterManagerBlock(String noClusterManagerBlockSetting, ClusterBlock expectedBlock) {
                assertThat(
            logger.info("--> submitting first value to {}", leader);  
                    clusterNode.coordinator.getLastAcceptedState().getLastAcceptedConfiguration().isEmpty()  
            cluster.clusterNodes.replaceAll(  
import static org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.EXTREME_DELAY_VARIABILITY;  
                leader.getLastAppliedClusterState().nodes().getSize(),  
            cluster.stabilise();
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
        try (  
                final VotingConfiguration lastCommittedConfiguration = newLeader.getLastAppliedClusterState()  
                        @Override
    public void testLogsWarningPeriodicallyIfClusterNotFormed() throws IllegalAccessException {  
            } else {
                        // there might be a term bump causing another election  
                            + " ["
    }
            assertFalse(Coordinator.validVotingConfigExclusionState(newState2));  
            leader.blackhole();
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect1.getId()));
            final ClusterNode leader = cluster.getAnyLeader();
                settingsBuilder.put(NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), noClusterManagerBlockSetting);
                );
        }  
            // moreover we are still stuck even if two other nodes heal
                                )
        try (Cluster cluster1 = new Cluster(randomIntBetween(1, 3))) {
            cluster.runRandomly();  
    public void testCannotSetInitialConfigurationWithoutLocalNode() {
        }
        }
            final VotingConfiguration unknownNodeConfiguration = new VotingConfiguration(
                );
     * 3 cluster-manager-eligible nodes (leader, follower1, follower2), the followers are shut down (leader remains), when followers come back
                final String nodeId = clusterNode.getId();
                // Interval is updated to decommissioned find peer interval
            cluster.runRandomly();
        try (Cluster cluster = new Cluster(5)) {
                })));
import org.opensearch.cluster.node.DiscoveryNode;  
 *
                clusterNode.coordinator.getFoundPeers().forEach(foundPeers::add);
                                    message  
                cluster.stabilise(2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY); // 1st delay for the setting update, 2nd for the reconfiguration
                            + "although publication of cluster state version [*] completed [*] ago"
            randomValueOtherThanMany(
            follower.blackhole();
            final ClusterNode leader = cluster.getAnyLeader();
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))
 * under the License.  
                    cluster.deterministicTaskQueue.getCurrentTimeMillis() + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,  
                @Override
                    failed.set(true);
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
    }  
                DEFAULT_DELAY_VARIABILITY // disconnect is scheduled
            leader.onDisconnectEventFrom(follower);
            cluster.stabilise(  
    }  
            // turn leader into candidate, which stabilisation asserts at the end
            partitionedNode.heal();  
import static org.opensearch.discovery.PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING;  
                )  
                    // Each follower may have just sent a leader check, which receives no response  
            cluster.runFor(2 * DEFAULT_DELAY_VARIABILITY + 1, "processing broken task");
            Set<CoordinationMetadata.VotingConfigExclusion> newVotingConfigExclusion1 = singleton(
                    // Commit a new cluster state with the new node(s). Might be split into multiple commits, and each might need a  
import org.opensearch.common.util.set.Sets;
            final Coordinator coordinator = cluster.getAnyNode().coordinator;  
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
                cluster.runFor(
            leader.allowClusterStateApplicationFailure();
                        "after [*] publication of cluster state version [*] is still waiting for "  
            final ClusterNode otherNode = cluster.getAnyNodeExcept(leader);  
 * license agreements. See the NOTICE file distributed with
                )  
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    // then wait for the followup reconfiguration  
        }
                equalTo(cluster.clusterNodes.size() - 1)
            assertEquals(currentTerm, newTerm);  
            cluster.stabilise(
            }  
            );  
            leader.heal();  
            assertTrue(leader.coordinator.getMode() != Coordinator.Mode.LEADER || leader.coordinator.getCurrentTerm() > startingTerm);  
                );  
import static org.hamcrest.Matchers.startsWith;
            cluster.runRandomly();  
                Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE).build()
                cluster.runRandomly(true, false, delayVariabilityMillis);  
            );
            assertThat(
            cluster.stabilise();
    public void testAppliesNoClusterManagerBlockMetadataWritesIfConfigured() {
                        // then wait for both of:  
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            cluster.stabilise();
                partitionedNode.disconnect();
            cluster.stabilise();
            }
        try (Cluster cluster = new Cluster(between(3, 5))) {  
     * Old leader is initiating an election at the same time, and wins election. It becomes leader again, but as it previously
            cluster.runFor(  
                }
                    CoordinationMetadata.VotingConfigExclusion.MISSING_VALUE_MARKER
            cluster.stabilise();
            cluster.stabilise();  
import java.util.concurrent.atomic.AtomicReference;
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING;  
            cluster.addNodesAndStabilise(randomIntBetween(1, 2));  
        }  
                    + 2 * DEFAULT_DELAY_VARIABILITY, // to send the failing check and receive the disconnection response  
            }  
                    FOLLOWER_CHECK_RETRY_COUNT_SETTING  
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();
            cluster.stabilise();
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING;
                    assertThat(e.getCause().getMessage(), equalTo(BrokenCustom.EXCEPTION_MESSAGE));  
                        "publication info message",
            cluster.stabilise();  
            try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(JoinHelper.class))) {  
                    defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)
                        LEADER_CHECK_RETRY_COUNT_SETTING  
            final ClusterNode leader = cluster.getAnyLeader();  
                final ClusterNode newLeader = cluster.getAnyLeader();
            logger.info("--> submitting broken task to [{}]", leader1);
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING;
                        // wait for the leader to check its followers
            cluster.stabilise(  
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY  
            final long previousClusterStateVersion = cluster.getAnyLeader().getLastAppliedClusterState().version();
                mockLogAppender.addExpectation(  
     * does not notice the node disconnecting, it is important for the node not to be turned back into a follower but try  
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING) * 2
                            final String message = event.getMessage().getFormattedMessage();
                "leader should be last to ack",  
                            );
                cluster.getAnyLeader().getLastAppliedClusterState().getLastAcceptedConfiguration().getNodeIds(),
            return "broken";
 * KIND, either express or implied.  See the License for the
            assertTrue("expected eventual ack from " + leader, ackCollector.hasAckedSuccessfully(leader));
                    // ALSO the leader may have just sent a follower check, which receives no response  
            cluster.stabilise();
            cluster.runRandomly();  
            cluster.runRandomly();
            // larger variability is are good for checking that we don't time out, but smaller variability also tightens up the time bound
            final ClusterNode leader = cluster.getAnyLeader();
                );
import static org.hamcrest.Matchers.not;
    public void testNodeCannotJoinIfJoinValidationFailsOnClusterManager() {
            final ClusterNode leader = cluster.getAnyLeader();
            }
            cluster.runRandomly();
import static org.hamcrest.Matchers.sameInstance;  
            }).run();
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);  
        try (Cluster cluster = new Cluster(3)) {  
                )  
                assertThat("term did not change", cluster.getAnyNode().coordinator.getCurrentTerm(), is(termBeforeRestart));  
            cluster.stabilise(  
                assertNotNull("node.left.count counter should be present", nodeLeftCounter);
            cluster.runRandomly();
                not(hasItem(chosenNode.getId()))
                Math.max(  
                    // first wait for all the followers to notice the leader has gone
            );  
    private ClusterState buildNewClusterStateWithVotingConfigExclusion(
                    (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(  
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);
                    containsString("cannot start with [discovery.type] set to [single-node] when local node"),
            disconnect1.disconnect();  
            assertThat(  
            cluster.stabilise();
            final ClusterNode leader = cluster.getAnyLeader();  
        try (Cluster cluster = new Cluster(1)) {
            final Set<DiscoveryNode> validatedNodes = new HashSet<>();
            }  
                    new MockLogAppender.SeenEventExpectation(
                assertTrue("expected ack from " + clusterNode, ackCollector.hasAckedSuccessfully(clusterNode));  
            cluster.runFor(  
                cluster.clusterNodes.forEach(cn -> cluster.deterministicTaskQueue.scheduleNow(cn.onNode(new Runnable() {
        @Override
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING)  
                    lastCommittedConfiguration + " should be all nodes",
            cluster.stabilise();
    public void testAckListenerReceivesNacksIfPublicationTimesOut() {  
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info")
            final Set<DiscoveryNode> validatedNodes = new HashSet<>();
                    .getLastCommittedConfiguration();  
                final VotingConfiguration lastCommittedConfiguration = newLeader.getLastAppliedClusterState()
                )
            logger.info("--> disconnecting follower {}", follower);
 * SPDX-License-Identifier: Apache-2.0
                                                                                                                                    // voting
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "committing setting update");  
            assertThat(
            follower0.coordinator.onFollowerCheckRequest(  
                    return "disconnect from " + clusterNode.getLocalNode() + " after shutdown";  
                    }
            cluster.runFor(DEFAULT_STABILISATION_TIME, "allowing time for fault detection");
            cluster.clusterNodes.add(newNode2);
            final long newClusterStateVersion = cluster.getAnyLeader().getLastAppliedClusterState().version();
 * this work for additional information regarding copyright
    public void testDoesNotElectNonClusterManagerNode() {  
                    )  
                    Version.CURRENT
                        // wait for the leader to check the follower
            if (chosenNodeIsLeader == false) {
                final ClusterNode newLeader = cluster.getAnyLeader();
            cluster.stabilise(DEFAULT_STABILISATION_TIME * 2);
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();
            assertTrue(coordinator.setInitialConfiguration(VotingConfiguration.of(coordinator.getLocalNode())));
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(newNode1.getId()));
                        + DEFAULT_DELAY_VARIABILITY
            final long finalValue = randomLong();
                        final Set<DiscoveryNode> nodesLogged = new HashSet<>();  
        testAppliesNoClusterManagerBlock("metadata_write", NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES);
            ).forEach(cn -> cn.extraJoinValidators.add((discoveryNode, clusterState) -> {  
                )
            logger.info("--> followers get disconnect event for leader {} ", originalLeader);
                                    "cluster-manager not discovered or elected yet, an election requires at least 2 nodes with ids from ["
            cluster.stabilise();
            cluster.runRandomly();
            logger.info("--> blackholing leader {}", originalLeader);
import java.util.function.Function;  
            cluster.runFor(DEFAULT_STABILISATION_TIME, "allowing time for fault detection");
            cluster.stabilise();
    }
            );
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                    mockLogAppender.addExpectation(new MockLogAppender.LoggingExpectation() {
                        + DEFAULT_DELAY_VARIABILITY
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);  
                    n, nodeInOtherCluster.persistedStateRegistry, Function.identity(), Function.identity()  
    public void testAckListenerReceivesNoAckFromHangingFollower() {
        }
                assertEquals(
    }
            settings = Settings.EMPTY;
                        }
            assertFalse("expected no immediate ack from " + follower1, ackCollector.hasAcked(follower1));
                );  
import org.opensearch.discovery.DiscoveryModule;
            final ClusterNode newNode = cluster.clusterNodes.get(cluster.clusterNodes.size() - 1);
                prePublishStats.getCompatibleClusterStateDiffReceivedCount(),
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))
            cluster.runRandomly();
    public void testCanUpdateClusterStateAfterStabilisation() {
            cluster.runRandomly();
                nodes -> cluster.initialConfiguration.hasQuorum(
import org.opensearch.cluster.AbstractDiffable;
                );  
            logger.info("--> adding three new healthy nodes");  
            cluster.stabilise(
            assertThat(removedNode.getLastAppliedClusterState().blocks().global(), hasItem(expectedBlock));
            leader.submitUpdateTask("update NO_CLUSTER_MANAGER_BLOCK_SETTING", cs -> {
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING;  
            logger.info("--> disconnecting leader {}", originalLeader);
                cn -> cn == chosenNode ? cn.restartedNode(Function.identity(), Function.identity(), nonClusterManagerNode()) : cn
                assertThat(lastCommittedConfiguration + " should be 3 nodes", lastCommittedConfiguration.getNodeIds().size(), equalTo(3));
import org.opensearch.cluster.block.ClusterBlock;
    public void testClusterStabilisesForPreviouslyDecommissionedNode() {
public class CoordinatorTests extends AbstractCoordinatorTestCase {  
                expectThrows(
                        )
    }  
            assertThat(exceptionMessage, containsString("unknown-node"));
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_INTERVAL_SETTING;
            disconnect3.disconnect();
            final ClusterNode detachedNode = newNode.restartedNode(
                }
            assertTrue("expected ack from " + follower1, ackCollector.hasAckedSuccessfully(follower1));  
                @Override
                        // then wait for the follower to check the leader
            cluster.runFor(10000, "failing join validation");
                    nodeId + " has an empty last-committed configuration",  
                ) {
 */  
            }  
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> healthStatusInfo.get()
            disconnect2.disconnect();
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,
            cluster.blackholeConnectionsFrom(otherNode, leader);
                    cluster.runFor(warningDelayMillis + DEFAULT_DELAY_VARIABILITY, "waiting for warning to be emitted");
                    lastCommittedConfiguration.getNodeIds(),
        final long warningDelayMillis;
/*
            logger.info("--> disconnecting all nodes");  
                exceptionMessage,
            assertFalse(Coordinator.validVotingConfigExclusionState(newState1));
    }
                        "node ["
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
            cluster.runRandomly();  
        try (Cluster cluster = new Cluster(randomIntBetween(1, 3))) {
                            assertTrue(  
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING;  
            nonLeader.onNode(() -> {
                    "resolvableNodeId",  
                throw new IllegalArgumentException("join validation failed");
import static org.hamcrest.Matchers.equalTo;
                        Level.WARN,
                assertThat(nodeId + " is in term 0", clusterNode.coordinator.getCurrentTerm(), is(0L));  
            for (ClusterNode cn : cluster.clusterNodes) {
 * not use this file except in compliance with the License.
            }
                brokenNode.blackhole();
    public void testAppliesNoClusterManagerBlockAllIfConfigured() {  
                newNode.nodeSettings
                1,
            logger.info("--> publishing another value");  
                    cn.toString(),
            final ClusterState currentState = coordinator.getLastAcceptedState();
            );
                        public void match(LogEvent event) {  
                mockAppender.addExpectation(
                    )
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                    )
                            );
            );
                throw new IllegalArgumentException("join validation failed");
            }
                    + (cluster.size() - 1) * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                // first wait for all the followers to notice the leader has gone  
                );
            ClusterNode newNode2 = cluster.new ClusterNode(
                assertThat(
                "waiting for leader failure"
        }
import static org.hamcrest.Matchers.hasItem;
                final ClusterState appliedState = clusterNode.getLastAppliedClusterState();  
            cluster.stabilise();  
    }
        try (Cluster cluster = new Cluster(3)) {  
            nodeHealthServiceStatus.getAndSet(new StatusInfo(UNHEALTHY, "unhealthy-info"));  
        }
                    LogManager.getLogger(LagDetector.class)
            cluster.stabilise();  
                assertFalse(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(leader.getLastAppliedClusterState().metadata().settings()));
import org.opensearch.common.settings.Settings.Builder;
            leader.setClusterStateApplyResponse(ClusterStateApplyResponse.SUCCEED);
            healthStatusInfo.getAndSet(new StatusInfo(UNHEALTHY, "unhealthy-info"));
                    new MockLogAppender.SeenEventExpectation(  
    public void testDoesNotShrinkConfigurationBelowThreeNodes() {
        }
            final ClusterNode leader = cluster.getAnyLeader();
            final ClusterNode follower = cluster.getAnyNodeExcept(leader);
    }
    }
                            )
            cluster.stabilise(
            assertTrue("expected immediate ack from " + follower1, ackCollector.hasAckedSuccessfully(follower1));
            follower0.allowClusterStateApplicationFailure();  
            cluster.runFor(
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY  
        try (Cluster cluster = new Cluster(3)) {  
                assertThat(lastCommittedConfiguration + " should be 3 nodes", lastCommittedConfiguration.getNodeIds().size(), equalTo(3));
    }  
                    postPublishStats.get(cn).getCompatibleClusterStateDiffReceivedCount()
            }
            assertTrue("expected eventual nack from " + leader, ackCollector.hasAckedUnsuccessfully(leader));
                    assertThat(e.getCause(), instanceOf(OpenSearchException.class));
            assertThat("leader should be last to ack", ackCollector.getSuccessfulAckIndex(leader), equalTo(1));
            }
            cluster.stabilise();  
            addedNodes.forEach(cn -> cn.extraJoinValidators.clear());
            }  
    }  
                assertThat(nodeId + " last accepted in term 0", clusterNode.coordinator.getLastAcceptedState().term(), is(0L));
    public void testLogsMessagesIfPublicationDelayed() throws IllegalAccessException {
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,  
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING;
import java.util.stream.Collectors;
                    () -> nonLeader.coordinator.onFollowerCheckRequest(  
                "elect new leader"  
            cluster.stabilise();
            cluster.stabilise(
                ) == false,
            final ClusterNode removedNode = cluster.getAnyNode();
            Set<CoordinationMetadata.VotingConfigExclusion> newVotingConfigExclusion2 = singleton(  
                cluster.getAnyLeader().submitValue(randomLong());
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "publish first state");
            cluster.runRandomly();
            // check that if node join validation fails on joining node, the nodes can't join  
            throw new OpenSearchException(EXCEPTION_MESSAGE);
        static final String EXCEPTION_MESSAGE = "simulated";  
            leader.submitValue(randomLong());  
                    defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)
    }
                assertThat(value(cn.getLastAppliedClusterState()), is(finalValue));
                assertThat(lastCommittedConfiguration + " should be 3 nodes", lastCommittedConfiguration.getNodeIds().size(), equalTo(3));
            cluster.stabilise();
                    }
    public void testUnresponsiveLeaderDetectedEventually() {
            assertThat(cluster.getAnyLeader().getId(), equalTo(leader.getId()));
            logger.info("--> disconnecting {}", disconnect3);
    public void testNodeCannotJoinIfJoinValidationFailsOnJoiningNode() {
            );
    }  
        try (Cluster cluster = new Cluster(1)) {  
                    )  
            }));
                cluster1.runFor(DEFAULT_STABILISATION_TIME, "failing join validation");
                    containsString("does not have quorum in voting configuration")  
            final ClusterNode disconnect1 = cluster.getAnyNode();
            // check that if node join validation fails on cluster-manager, the nodes can't join  
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader);
                    prePublishStats.get(cn).getIncompatibleClusterStateDiffReceivedCount(),  
            for (final ClusterNode clusterNode : cluster.getAllNodesExcept(leader)) {
                    });  
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder(currentState.coordinationMetadata());  
        logger.info("--> emitting warnings every [{}ms]", warningDelayMillis);  
            for (ClusterNode node : cluster.clusterNodes) {  
            for (final ClusterNode clusterNode : cluster.clusterNodes) {  
            Cluster cluster = new Cluster(  
import java.util.HashMap;
                    MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(
        AtomicReference<StatusInfo> nodeHealthServiceStatus = new AtomicReference<>(new StatusInfo(HEALTHY, "healthy-info"));
    public void testClusterRecoversAfterExceptionDuringSerialization() {  
/*  
            ) {
            } else {
            long finalValue = randomLong();
                        FOLLOWER_CHECK_RETRY_COUNT_SETTING
            cluster.stabilise();
        }
                    // One message delay to send a join
            final long newClusterStateVersion = cluster.getAnyLeader().getLastAppliedClusterState().version();
            newNode.close();  
            cluster.stabilise();
            {
            }
    public void testLeaderDisconnectionWithDisconnectEventDetectedQuickly() {  
    }
                // in the 2-node case, auto-shrinking the voting configuration is required to reduce the voting configuration down to just
                assertEquals(Double.valueOf(1.0), counterValuesByTags.get(tags2));
            ).getMessage();
    }  
                (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(
                try (  
                synchronized (nonLeader.coordinator.mutex) {  
import org.opensearch.common.regex.Regex;  
                    LogManager.getLogger(Coordinator.CoordinatorPublication.class),
                        public void assertMatched() {
            List<ClusterNode> addedNodes = cluster.addNodes(randomIntBetween(1, 2));
            cluster.runRandomly();
            final String exceptionMessage = expectThrows(
                    postPublishStats.get(cn).getFullClusterStateReceivedCount()  
            cluster.stabilise(defaultMillis(PUBLISH_TIMEOUT_SETTING));  
            final ClusterNode brokenNode = cluster.getAnyNodeExcept(cluster.getAnyLeader());  
                            Function.identity(),
        try (Cluster cluster = new Cluster(3)) {
        try (Cluster cluster = new Cluster(3)) {
            AckCollector ackCollector = leader.submitValue(randomLong());
            );
    public void testLocalNodeAlwaysCommissionedWithoutDecommissionedException() {
                postPublishStats.getCompatibleClusterStateDiffReceivedCount()  
                        LogManager.getLogger(ClusterFormationFailureHelper.class)
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> healthStatusInfo.get()
            );
                            brokenNode.heal();
            }
        }
        try (Cluster cluster = new Cluster(5)) {
 *  
            cluster.runRandomly();
import org.opensearch.gateway.GatewayService;
                leader.submitSetAutoShrinkVotingConfiguration(false);  
            assertTrue("expected nack from " + leader, ackCollector.hasAckedUnsuccessfully(leader));  
            AckCollector ackCollector = leader.submitValue(randomLong());
            settings = Settings.builder()
            cluster.stabilise();
            leader.submitValue(randomLong());
                cluster2.runRandomly();
    public void testReconfiguresToExcludeClusterManagerIneligibleNodesInVotingConfig() {
                    // followup reconfiguration
 * specific language governing permissions and limitations
                    .getLastCommittedConfiguration();
            final ClusterNode leader = cluster.getAnyLeader();
            cluster.runRandomly();
        } else {  
                                .collect(Collectors.toList());  
import org.opensearch.core.xcontent.XContentBuilder;  
        }  
            cluster.stabilise();
            cluster.runRandomly();  
            logger.info("setting auto-shrink reconfiguration to true");
                                nodesLogged,
            assertTrue("expected nack from " + follower0, ackCollector.hasAckedUnsuccessfully(follower0));
                Math.max(  
            cluster.stabilise(); // would not work if disconnect1 were removed from the configuration
                    @Override
            final Map<ClusterNode, PublishClusterStateStats> prePublishStats = cluster.clusterNodes.stream()
            cluster.stabilise();
                        // then wait for a follower to be promoted to leader
                assertTrue(nodeId + " should not have discovered itself", foundPeers.add(clusterNode.getLocalNode()));  
import static org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.DEFAULT_DELAY_VARIABILITY;
                    + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                                        .equals(getNodeIdForLogContext(n.getLocalNode()))
            cluster.stabilise();
            assertTrue("expected ack from " + follower0, ackCollector.hasAckedSuccessfully(follower0));
                    // then wait for the followup reconfiguration
            cluster1.clusterNodes.add(newNode);
        }  
            cluster.runRandomly(false, true, EXTREME_DELAY_VARIABILITY);
            final ClusterNode leader = cluster.getAnyLeader();
                        + defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING)  
                assertTrue(node.coordinator.localNodeCommissioned());
                                FOLLOWER_CHECK_RETRY_COUNT_SETTING  
        ) {
            );
            cluster.runRandomly();
                                message,  
                        @Override
import java.util.Arrays;  
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect1.getId()));
            assertEquals(
            cluster.stabilise();
            leader.submitValue(finalValue);
 *     http://www.apache.org/licenses/LICENSE-2.0
                tags1.put("reason", "health.check.fail");
import org.opensearch.cluster.node.DiscoveryNodes;
                TestInMemoryMetricsRegistry clusterManagerMetricsRegistry = leader.getMetricsRegistry();
            final PublishClusterStateStats postPublishStats = follower.coordinator.stats().getPublishStats();
            long finalValue = randomLong();
        }
        try (Cluster cluster = new Cluster(randomIntBetween(1, 3))) {
            cluster1.stabilise();  
            cluster.runFor(DEFAULT_STABILISATION_TIME, "allowing time for fault detection");
        }
                ) + (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + DEFAULT_DELAY_VARIABILITY) * defaultInt(
            )
                }
            final ClusterNode leader = cluster.getAnyLeader();
    }
import org.apache.logging.log4j.Level;  
            disconnect2.disconnect();  
            );  
                        LEADER_CHECK_RETRY_COUNT_SETTING
import org.opensearch.core.common.io.stream.StreamOutput;
            }
    }
                        + DEFAULT_DELAY_VARIABILITY
    public void testAckListenerReceivesAcksFromAllNodes() {  
            final ClusterNode leader = cluster.getAnyLeader();
            cluster.clusterNodes.add(newNode3);  
                assertThat(nodeId + " is CANDIDATE", clusterNode.coordinator.getMode(), is(CANDIDATE));
    public void testAppliesNoClusterManagerBlockWritesByDefault() {
    }
            logger.info("--> blackholing {}", follower);  
            cluster.runRandomly();
                    cn.toString(),
                    defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)
import static java.util.Collections.emptyMap;  
                )  
                }  
                assertTrue(
                    // wait for the leader to notice that the follower is unresponsive
            disconnect1.disconnect();
    public void testAckListenerReceivesNackFromLeader() {
            assertTrue("expected ack from " + leader, ackCollector.hasAckedSuccessfully(leader));  
            cluster.runFor(
                assertThat(clusterNode.getId() + " should be a candidate", clusterNode.coordinator.getMode(), equalTo(Mode.CANDIDATE));
                    ) + DEFAULT_DELAY_VARIABILITY,
    }
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
                        + defaultMillis(LEADER_CHECK_INTERVAL_SETTING)
                        // then wait for the follower to check the leader
                )  
                ackCollector.getSuccessfulAckIndex(leader),
 * The OpenSearch Contributors require contributions made to  
            // initial cluster state send when joining  
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
                prePublishStats.getIncompatibleClusterStateDiffReceivedCount() + 1,  
            cluster.stabilise();  
import java.util.concurrent.ConcurrentHashMap;  
            cluster.runRandomly();  
            logger.info("--> disconnecting {}", disconnect1);  
                // the leader, otherwise restarting the other cluster-manager-eligible node triggers an election  
            final ClusterNode disconnect2 = cluster.getAnyNodeExcept(disconnect1);
                    // and the first publication times out because of the unresponsive node
            cluster.stabilise();
            );
 * Licensed to Elasticsearch under one or more contributor  
                    + 4 * DEFAULT_DELAY_VARIABILITY
        testAppliesNoClusterManagerBlock("write", NO_CLUSTER_MANAGER_BLOCK_WRITES);  
            cluster.stabilise();
        Metadata newMetadata = Metadata.builder(currentState.metadata()).coordinationMetadata(coordMetadataBuilder.build()).build();
                    "resolvableNodeName"  
                        // then wait for the leader to commit a state without the follower  
                    cn -> cn == clusterNode ? cn.restartedNode(Function.identity(), Function.identity(), Settings.EMPTY) : cn  
            cluster.stabilise();  
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING)  
        }
            cluster.runRandomly();
    public void testImproveConfigurationPerformsVotingConfigExclusionStateCheck() {
        @Override  
            leader.submitValue(finalValue);
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
            for (int i = scaledRandomIntBetween(1, 10); i >= 0; i--) {
            disconnect4.disconnect();  
                    prePublishStats.get(cn).getFullClusterStateReceivedCount(),
import org.opensearch.OpenSearchException;  
                        + Math.max(
            assertTrue(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(leader.getLastAppliedClusterState().metadata().settings()));
            follower0.onDisconnectEventFrom(leader);  
            assertTrue(leader.getLocalNode().isClusterManagerNode());  
                defaultMillis(LEADER_CHECK_TIMEOUT_SETTING) // to wait for any in-flight check to time out
                    nodes.stream().map(ClusterNode::getLocalNode).map(DiscoveryNode::getId).collect(Collectors.toSet())  
            logger.info("--> disconnecting {}", disconnect1);  
            logger.info("--> changing health status of leader {} to unhealthy", leader);
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);  
    }
            disconnect1.heal();
            }  
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "committing value");
            leader.setClusterStateApplyResponse(ClusterStateApplyResponse.FAIL);  
                allOf(
            final long termBeforeRestart = cluster.getAnyNode().coordinator.getCurrentTerm();
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            cluster.stabilise();  
            cluster.stabilise();
            logger.info("--> disconnecting leader {}", originalLeader);  
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING)
import org.opensearch.Version;
            ClusterNode newNode1 = cluster.new ClusterNode(
    public void testDiscoveryUsesNodesFromLastClusterState() {
            );
            disconnect2.disconnect();
            cluster.runRandomly();  
        ) {  
            final long originalTerm = leader.coordinator.getCurrentTerm();
import org.apache.logging.log4j.core.LogEvent;
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);  
                    // Then a commit of the updated cluster state
                )  
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(newNode2.getId()));  
                                                                                                                                    // round
                final ClusterNode newLeader = cluster.getAnyLeader();
                    singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
            );  
            cluster.clusterNodes.replaceAll(cn -> cn == removedNode ? restartedNode : cn);
import static org.hamcrest.Matchers.instanceOf;  
        }
            final ClusterNode leader = cluster.getAnyLeader();
            final String exceptionMessage = expectThrows(
            // fail join validation on a majority of nodes in the initial configuration  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();  
                    defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)  
                // The first pinging discovers the cluster-manager  
            cluster.runRandomly();
                Sets.newHashSet(coordinator.getLocalNode().getId(), "unknown-node")  
            cluster.runRandomly();  
                leader.submitSetAutoShrinkVotingConfiguration(true);
                cluster.getAnyLeader().getLastAppliedClusterState().getLastCommittedConfiguration().getNodeIds(),
                        // then wait for the leader to try and commit a state removing them, causing it to stand down
import org.opensearch.test.telemetry.TestInMemoryCounter;
                clusterNode.close();
            );  
        }  
    public void testNodesJoinAfterStableCluster() {  
            cluster.stabilise();
                1,
                leader.getLastAppliedClusterState().nodes().toString(),
            final ClusterNode leader = cluster.getAnyLeader();
                            + Publication.PublicationTargetState.SENT_PUBLISH_REQUEST
                    + DEFAULT_DELAY_VARIABILITY
     * successfully completed state recovery, is never reset to a state where state recovery can be retried.
            logger.info("--> submitting value [{}] to [{}]", finalValue, leader);  
                    new MockLogAppender.SeenEventExpectation(
                        @Override
                mockLogAppender.addExpectation(
            final PublishClusterStateStats newNodePublishStats = newNode.coordinator.stats().getPublishStats();
            final ClusterNode follower = cluster.getAnyNodeExcept(leader);  
                cs -> ClusterState.builder(cs).putCustom("broken", new BrokenCustom()).build(),  
            logger.info("--> healing {}", toHeal);
            final AtomicBoolean failed = new AtomicBoolean();  
        }
        }
                    lastCommittedConfiguration + " should be all nodes",  
    }
            logger.info("--> adding two new healthy nodes");
            }));  
            final ClusterNode disconnect1 = cluster.getAnyNode();
                    public String toString() {
    public void testAckListenerReceivesNacksIfLeaderStandsDown() {  
                assertTrue(counterValuesByTags.containsKey(tags1));
                assertThat(nodeId + " should have found all peers", foundPeers, hasSize(cluster.size()));
 * Unless required by applicable law or agreed to in writing,
                        + defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING)  
    }
            leader.submitSetAutoShrinkVotingConfiguration(true);
            {  
                            + ']'  
    }  
    public void testStateRecoveryResetAfterPreviousLeadership() {
                    // then wait for the followup reconfiguration  
            assertEquals(0, newNode.getLastAppliedClusterState().version());
            IllegalStateException ise = expectThrows(  
            assertTrue("expected nack from " + follower0, ackCollector.hasAckedUnsuccessfully(follower0));
import org.opensearch.cluster.coordination.Coordinator.Mode;
                    // Allow two round-trip for pre-voting and voting  
                    // FINALLY:
            cluster.stabilise();
            }
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
            for (ClusterNode clusterNode : Arrays.asList(follower1, follower2)) {
            );
            assertTrue(addedNodes.stream().allMatch(ClusterNode::isCandidate));
                    }
                    // ALSO the follower may have just sent a leader check, which receives no response
            cluster.stabilise();  
                    // One message delay to send a join
            );
                    )
                logger.info("setting auto-shrink reconfiguration to false");
            for (ClusterNode node : cluster.clusterNodes) {
                tags2.put("reason", "health.check.fail");
            cluster1.runRandomly();
            warningDelayMillis = randomLongBetween(1, 100000);
            // restart follower1 and follower2
                final VotingConfiguration lastCommittedConfiguration = leader.getLastAppliedClusterState().getLastCommittedConfiguration();  
            final VotingConfiguration unknownNodeConfiguration = new VotingConfiguration(Sets.newHashSet("unknown-node"));
                assertThat(leader.coordinator.getMode(), is(Mode.LEADER));
            cluster.stabilise();
    public void testClusterCannotFormWithFailingJoinValidation() {
            disconnect1.heal();  
                randomBoolean(),
    }
                    .metadata(Metadata.builder(cs.metadata()).persistentSettings(settingsBuilder.build()))  
            Cluster cluster = new Cluster(
            follower0.setClusterStateApplyResponse(ClusterStateApplyResponse.HANG);
                clusterNode.close();  
                    // wait for the removal to be committed
        }
                        : cn
            AckCollector ackCollector = leader.submitValue(randomLong());
        }
            // we still tolerate the loss of one more node here  
            cluster.getAnyLeader().extraJoinValidators.add((discoveryNode, clusterState) -> {  
                    + DEFAULT_ELECTION_DELAY  
                new CoordinationMetadata.VotingConfigExclusion(
import static org.opensearch.cluster.coordination.Coordinator.PUBLISH_TIMEOUT_SETTING;
            final ClusterNode bootstrapNode = cluster.getAnyBootstrappableNode();
            logger.info("--> changing health of newly added nodes to unhealthy");  
            cluster.runFor(DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "committing value");
 * ownership. Elasticsearch licenses this file to you under  
                        )
                assertThat(nonLeader.coordinator.getMode(), equalTo(CANDIDATE));
            cluster.stabilise();  
                    + Math.max(
            .add(  
                () -> cluster.clusterNodes.replaceAll(
            }
                .put(ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.getKey(), warningDelayMillis + "ms")  
            cluster.clearBlackholedConnections();
                        + DEFAULT_CLUSTER_STATE_UPDATE_DELAY
            {  
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect2.getId()));  
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
            logger.info("--> disconnecting {}", disconnect4);
                tags2.put("follower_node_id", newNode2.getId());
        testAppliesNoClusterManagerBlock(null, NO_CLUSTER_MANAGER_BLOCK_WRITES);
            final boolean chosenNodeIsLeader = chosenNode == cluster.getAnyLeader();  
            assertThat(
    public void testExpandsConfigurationWhenGrowingFromThreeToFiveNodesAndShrinksBackToThreeOnFailure() {
            }
        ClusterState currentState,
            logger.info("setting auto-shrink reconfiguration to true");  
            final ClusterNode leader = cluster.getAnyLeader();
                    LEADER_CHECK_RETRY_COUNT_SETTING
     * recovered a state (see {@link GatewayService}). The situation which triggers this with a decent likelihood is as follows:
            cluster.stabilise();  
                public void run() {  
            cluster1.clusterNodes.replaceAll(cn -> cn == newNode ? detachedNode : cn);  
                                )  
            cluster.stabilise(DEFAULT_STABILISATION_TIME * 2);
            assertThat(
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
            follower.disconnect();  
import java.util.List;  
        }  
            originalLeader.disconnect();
                // the first election should succeed, because only one node knows of the initial configuration and therefore can win a  
                mockLogAppender.assertAllExpectationsMatched();  
                        defaultMillis(PUBLISH_TIMEOUT_SETTING),  
                (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + defaultMillis(LEADER_CHECK_TIMEOUT_SETTING))
        try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
            assertTrue("expected nack from " + follower1, ackCollector.hasAckedUnsuccessfully(follower1));
                        + defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING)  
            }
            cluster.stabilise();
            removedNode.close();  
    private static class BrokenCustom extends AbstractDiffable<ClusterState.Custom> implements ClusterState.Custom {
    public void testStayCandidateAfterReceivingFollowerCheckFromKnownClusterManager() {  
            warningDelayMillis = ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.get(settings).millis();
                validatedNodes.add(discoveryNode);
        try (Cluster cluster = new Cluster(3)) {  
            cluster.runFor(10000, "failing join validation");
            );
/*
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            cluster.runRandomly();  
            cluster.stabilise();  
            AckCollector ackCollector = leader.submitValue(randomLong());
import static org.hamcrest.Matchers.hasSize;
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
            List<ClusterNode> addedNodes = cluster.addNodes(randomIntBetween(1, 2));
                (source, e) -> {
            disconnect1.disconnect();
                    // followup reconfiguration
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL;
import org.opensearch.cluster.metadata.Metadata;
                ) + DEFAULT_CLUSTER_STATE_UPDATE_DELAY,  
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);  
    public void testFollowerDisconnectionDetectedQuickly() {  
import org.opensearch.monitor.StatusInfo;  
    }  
        @Override
                .collect(Collectors.toMap(Function.identity(), cn -> cn.coordinator.stats().getPublishStats()));
            logger.info("--> submitting value [{}] to [{}]", finalValue, leader2);  
            assertThat(  
        }
                cluster.stabilise();
                    (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)) * defaultInt(
            cluster.runRandomly();  
     * This test was added to verify that state recovery is properly reset on a node after it has become cluster-manager and successfully  
        @Override
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES;
                    // then wait for both of:  
        try (Cluster cluster = new Cluster(3)) {
import static org.hamcrest.Matchers.allOf;
                        public String toString() {
                );  
                assertThat(leader.coordinator.getMode(), is(Mode.LEADER));
            );
                    + DEFAULT_DELAY_VARIABILITY
                    equalTo(cluster.clusterNodes.stream().map(ClusterNode::getId).collect(Collectors.toSet()))
                );  
            final ClusterNode leader = cluster.getAnyLeader();  
            assertFalse("expected no immediate ack from " + leader, ackCollector.hasAcked(leader));  
            assertThat(cluster.getAnyLeader().getId(), equalTo(leader.getId()));
                final ClusterNode leader = cluster.getAnyLeader();
            cluster.stabilise();
}
        try (Cluster cluster = new Cluster(3, true, settings)) {
        try (Cluster cluster = new Cluster(randomIntBetween(2, 5), false, Settings.EMPTY)) {  
    }
                cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);
                        // then wait for the removal to be committed  
                () -> coordinator.setInitialConfiguration(unknownNodeConfiguration)
            cluster.runRandomly();  
            }
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect2.getId()));  
            assertEquals(cluster.size() % 2, newNodePublishStats.getCompatibleClusterStateDiffReceivedCount());  
                assertThat(clusterNode.getId() + " is CANDIDATE", clusterNode.coordinator.getMode(), is(CANDIDATE));
                    // Then a commit of the new leader's first cluster state
            final ClusterNode leader = cluster.getAnyLeader();  
            }
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
            cluster.stabilise();  
            cluster.runFor(DEFAULT_STABILISATION_TIME, "allowing time for fault detection");
            cluster.stabilise();
            cluster.runRandomly();
                );
            ClusterState newState1 = buildNewClusterStateWithVotingConfigExclusion(currentState, newVotingConfigExclusion1);
                );
import org.apache.logging.log4j.LogManager;
            cluster.bootstrapIfNecessary();  
            for (final ClusterNode clusterNode : cluster.clusterNodes) {
            logger.info("--> disconnecting {}", disconnect3);  
                    .build();
        }
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {
    public void testAckListenerReceivesNackFromFollower() {
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY);  
            cluster.stabilise(DEFAULT_CLUSTER_STATE_UPDATE_DELAY * 2); // allow for a reconfiguration
                    // ALSO wait for the follower to notice the leader is unresponsive
                TestInMemoryCounter nodeLeftCounter = clusterManagerMetricsRegistry.getCounterStore().get("node.left.count");  
                    lastCommittedConfiguration.getNodeIds(),  
                    + DEFAULT_ELECTION_DELAY
                    nodeId + " has an empty last-accepted configuration",
                            + "] is lagging at cluster state version [*], "  
            AckCollector ackCollector = leader.submitValue(randomLong());
                    public void run() {  
    public void testAppliesNoClusterManagerBlockWritesIfConfigured() {
                    "resolvableNodeId",  
            final Coordinator coordinator = cluster.getAnyNode().coordinator;
                nextNodeIndex.getAndIncrement(), true, leader.nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info")
                    "waiting for messages to be emitted"  
            ClusterState newState2 = buildNewClusterStateWithVotingConfigExclusion(currentState, newVotingConfigExclusion2);
            );  
            final ClusterNode partitionedNode = cluster.getAnyNode();
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;  
        }  
        newVotingConfigExclusion.forEach(coordMetadataBuilder::addVotingConfigExclusion);
            decommissionedNode.coordinator.onNodeCommissionStatusChange(false);
    public void testCanShrinkFromFiveNodesToThree() {
                    lastCommittedConfiguration.getNodeIds(),
            );
        }
            cluster.stabilise(
            final ClusterNode newNode = cluster1.new ClusterNode(
                    // Commit a new cluster state with the new node(s). Might be split into multiple commits, and each might need a  
                        + DEFAULT_ELECTION_DELAY
            final long previousClusterStateVersion = cluster.getAnyLeader().getLastAppliedClusterState().version();
    public void testIncompatibleDiffResendsFullState() {
            }  
            try (Cluster cluster2 = new Cluster(3)) {  
    }
                ELECTION_INITIAL_TIMEOUT_SETTING.get(Settings.EMPTY).millis() + delayVariabilityMillis + 4 * delayVariabilityMillis // two
    public void testSingleNodeDiscoveryWithoutQuorum() {
                )
                // time for the disconnected node to find the cluster-manager again
                assertFalse(lastCommittedConfiguration.getNodeIds().contains(disconnect1.getId()));  
                    + 4 * DEFAULT_DELAY_VARIABILITY
    }  
                Math.max(
            assertTrue(bootstrapNode.getId() + " has been bootstrapped", bootstrapNode.coordinator.isInitialConfigurationSet());  
                    + DEFAULT_ELECTION_DELAY,
            follower1.onDisconnectEventFrom(leader);
                                .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
            assertEquals(validatedNodes, addedNodes.stream().map(ClusterNode::getLocalNode).collect(Collectors.toSet()));  
            AckCollector ackCollector = leader.submitValue(randomLong());
            cluster.stabilise();
                ise.getMessage(),  
            logger.info("--> submitting value [{}] to [{}]", finalValue, leader);
                logger.info("--> blackholing {}", partitionedNode);  
            final ClusterNode follower0 = cluster.getAnyNodeExcept(leader);
            final ClusterNode leader = cluster.getAnyLeader();  
            );  
            final ClusterNode follower1 = cluster.getAnyNodeExcept(leader, follower0);  
            assertThat(exceptionMessage, equalTo("local node is not part of initial configuration"));  
    public void testDiffBasedPublishing() {
    public void testSettingInitialConfigurationTriggersElection() {  
                MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(  
                    // Then allow time for all the other nodes to join, each of which might cause a reconfiguration
            cluster.runRandomly();  
                        (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING))
                defaultMillis(ELECTION_INITIAL_TIMEOUT_SETTING)
                        LagDetector.CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING
        try (Cluster cluster = new Cluster(randomIntBetween(3, 5))) {  
                cluster.deterministicTaskQueue.scheduleAt(
            assertTrue(decommissionedNode.coordinator.localNodeCommissioned());  
                            // 2. the new leader to notice that the old leader is unresponsive
            assertThat(cluster.getAnyLeader().getId(), equalTo(leader.getId()));  
            assertTrue("expected ack from " + follower1, ackCollector.hasAckedSuccessfully(follower1));
