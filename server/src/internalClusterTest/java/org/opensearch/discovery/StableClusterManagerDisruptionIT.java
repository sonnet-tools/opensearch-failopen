    public void testFollowerCheckerDetectsDisconnectedNodeAfterClusterManagerReelection() throws Exception {
    public void testFailWithMinimumClusterManagerNodesConfigured() throws Exception {
        logger.info("--> new detected cluster-manager node [{}]", newClusterManagerNode);
import org.opensearch.plugins.Plugin;
import java.util.Map;
        clusterManagerNodeDisruption.startDisrupting();
                }
                    + transitions,
    public void testFollowerCheckerDetectsUnresponsiveNodeAfterClusterManagerReelection() throws Exception {
        internalCluster().startNodes(4, settings);
            });
 * specific language governing permissions and limitations
        logger.info("---> legit elected cluster-manager node={}", clusterManagerNode);
 * You may obtain a copy of the License at
    /**
import java.util.stream.Collectors;
    private void testFollowerCheckerAfterClusterManagerReelection(NetworkLinkDisruptionType networkLinkDisruptionType, Settings settings)
        setDisruptionScheme(networkDisruption);
                }
        ensureStableCluster(3);
        ensureStableCluster(3);
import java.util.HashMap;
        // Keeps track of the previous and current cluster-manager when a cluster-manager node transition took place on each node on the
        // queued and
                    return ClusterState.builder(currentState).build();
 * not detect a cluster-manager failure too quickly.
        final String otherNode = nonClusterManagers.get(nonClusterManagers.get(0).equals(isolatedNode) ? 1 : 0);
import org.opensearch.common.util.set.Sets;
import org.opensearch.cluster.ClusterStateUpdateTask;
import org.opensearch.core.common.Strings;
    }
                    );
        );
            () -> assertNull(
                    String previousClusterManagerNodeName = previousClusterManager != null ? previousClusterManager.getName() : null;
 * Tests relating to the loss of the cluster-manager, but which work with the default fault detection settings which are rather lenient and will
        ensureStableCluster(4);
     */
/*
        logger.info("--> unfreezing node [{}]", oldClusterManagerNode);
            new NetworkDisruption.TwoPartitions(clusterManagerNode, unluckyNode),
 * software distributed under the License is distributed on an
        ensureNoMaster(isolatedNode);
import java.util.concurrent.CountDownLatch;
                    + nodeName
        internalCluster().getInstance(ClusterService.class, oldClusterManagerNode).addListener(event -> {
                public void onFailure(String source, Exception e) {
 * ownership. Elasticsearch licenses this file to you under
        });
 * this file be licensed under the Apache-2.0 license or a
        ensureStableCluster(2, clusterManager);
            }
 */
        });
 * not use this file except in compliance with the License.
     * Verify that nodes fault detection detects a disconnected node after cluster-manager reelection
                if (!Objects.equals(previousClusterManager, currentClusterManager)) {
                DiscoveryNode previousClusterManager = event.previousState().nodes().getClusterManagerNode();
import org.opensearch.test.disruption.SingleNodeDisruption;
        testFollowerCheckerAfterClusterManagerReelection(
        // state where it is
/**
import static java.util.Collections.singleton;
                .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
        final String clusterManagerNode = internalCluster().getClusterManagerName();
import org.opensearch.test.OpenSearchIntegTestCase;
            .filter(n -> clusterManager.equals(n) == false)
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
import org.opensearch.test.disruption.NetworkDisruption.NetworkLinkDisruptionType;
        final NetworkDisruption networkDisruption = new NetworkDisruption(
                .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
            }
    }
     * following another elected cluster-manager node. These nodes should reject this cluster state and prevent them from following the stale cluster-manager.
            if (event.state().nodes().getClusterManagerNodeId() == null) {
        final String oldClusterManagerNode = internalCluster().getClusterManagerName();
        majoritySide.remove(oldClusterManagerNode);
            )
                    + oldClusterManagerNode
 * Licensed to Elasticsearch under one or more contributor
            new TwoPartitions(singleton(isolatedNode), Sets.newHashSet(clusterManager, otherNode)),
                    logger.info(
import static org.hamcrest.Matchers.lessThan;
        // majority side:
                    + "] should not apply state from old cluster-manager ["
     */
        clusterManagerNodeDisruption.stopDisrupting();
import org.opensearch.cluster.coordination.FollowersChecker;
        logger.info("--> [{}] stepped down as cluster-manager", oldClusterManagerNode);
        networkDisconnect.startDisrupting();
 * the Apache License, Version 2.0 (the "License"); you may
                client(node).admin().cluster().state(new ClusterStateRequest().local(true)).get().getState().nodes().getClusterManagerNode()
    }
        oldClusterManagerNodeSteppedDown.await(30, TimeUnit.SECONDS);
        internalCluster().stopCurrentClusterManagerNode();
                .build()
            assertTrue(
        throws Exception {
                @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * Verify that nodes fault detection detects an unresponsive node after cluster-manager reelection
 * license agreements. See the NOTICE file distributed with
        final List<String> nodes = internalCluster().startNodes(
import java.util.Collections;
 */
                "["
 * Unless required by applicable law or agreed to in writing,
        // The elected cluster-manager shouldn't have changed, since the unlucky node never could have elected itself as cluster-manager
import static org.hamcrest.Matchers.equalTo;
            3,
        assertThat(internalCluster().getClusterManagerName(), equalTo(clusterManagerNode));
     * Test that no split brain occurs under partial network partition. See https://github.com/elastic/elasticsearch/issues/2488
    public void testStaleClusterManagerNotHijackingMajority() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .collect(Collectors.toList());
 * under the License.
import org.opensearch.common.Priority;
import java.util.ArrayList;
            networkLinkDisruptionType
        );
 *
            Settings.builder()
        networkDisconnect.stopDisrupting();
package org.opensearch.discovery;
                oldClusterManagerNodeSteppedDown.countDown();
            NetworkDisruption.UNRESPONSIVE,
 *    http://www.apache.org/licenses/LICENSE-2.0
        logger.info("--> waiting for cluster-manager to remove it");
/*
 */
        final String clusterManager = internalCluster().getClusterManagerName();
        networkDisruption.stopDisrupting();
        for (final String node : majoritySide) {
            for (final Map.Entry<String, List<Tuple<String, String>>> entry : clusterManagers.entrySet()) {
import org.opensearch.common.settings.Settings;
        // Figure out what is the elected cluster-manager node
        );
        Set<String> nonClusterManagers = new HashSet<>(nodes);
    /**
        // Simulating a painful gc by suspending all threads for a long time on the current elected cluster-manager node.
        logger.info("--> stopping current cluster-manager");
        // Wait until the cluster-manager node sees all 3 nodes again.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.concurrent.TimeUnit;
        ensureStableCluster(3);
                }
        // The unlucky node must report *no* cluster-manager node, since it can't connect to cluster-manager and in fact it should
        logger.info("--> freezing node [{}]", oldClusterManagerNode);
        List<String> nodes = internalCluster().startNodes(3);
        // continuously ping until network failures have been resolved. However
        // Pick a node that isn't the elected cluster-manager.
    /**
        }
                        node,
        internalCluster().setDisruptionScheme(clusterManagerNodeDisruption);
 * Modifications Copyright OpenSearch Contributors. See
        ensureStableCluster(2, clusterManagerNode);
            NetworkDisruption.DISCONNECT
    private void ensureNoMaster(String node) throws Exception {
        final Map<String, List<Tuple<String, String>>> clusterManagers = Collections.synchronizedMap(new HashMap<>());
import java.util.Set;
        for (Map.Entry<String, List<Tuple<String, String>>> entry : clusterManagers.entrySet()) {
        final String newClusterManagerNode = internalCluster().getClusterManagerName(majoritySide.get(0));
    @Override
import org.opensearch.test.disruption.NetworkDisruption;
        final String unluckyNode = randomFrom(nonClusterManagers.toArray(Strings.EMPTY_ARRAY));
 */
import org.opensearch.cluster.coordination.Coordinator;
        // It may a take a bit before the node detects it has been cut off from the elected cluster-manager
        setDisruptionScheme(networkDisconnect);
        final List<String> majoritySide = new ArrayList<>(nodes);
            clusterManagers.put(node, new ArrayList<>());
        );
    }
                        event.previousState()
import org.opensearch.cluster.ClusterState;
import java.util.Collection;
        internalCluster().getInstance(ClusterService.class, oldClusterManagerNode)
        // Stop disruption
import org.opensearch.common.collect.Tuple;
        // The old cluster-manager node is frozen, but here we submit a cluster state update task that doesn't get executed, but will be
 * GitHub history for details.
                .put(Coordinator.PUBLISH_TIMEOUT_SETTING.getKey(), "2s")
 * SPDX-License-Identifier: Apache-2.0
                @Override
 * The OpenSearch Contributors require contributions made to
import org.opensearch.test.disruption.LongGCDisruption;
    }
        // Wait until elected cluster-manager has removed that the unlucky node...
    /**
        // once the old cluster-manager node un-freezes it gets executed. The old cluster-manager node will send this update + the cluster
                transitions.stream().noneMatch(t -> oldClusterManagerNode.equals(t.v2()))
import java.util.List;
 * KIND, either express or implied.  See the License for the
    }
            Settings.builder()
import java.util.HashSet;
        assertBusy(
 *
        final String isolatedNode = randomFrom(nonClusterManagers);
        return Collections.singletonList(MockTransportService.TestPlugin.class);
                    String currentClusterManagerNodeName = currentClusterManager != null ? currentClusterManager.getName() : null;
                DiscoveryNode currentClusterManager = event.state().nodes().getClusterManagerNode();
            String nodeName = entry.getKey();
     */
     */
            );
}
        assertThat(clusterManagers.size(), equalTo(2));
        // Save the new elected cluster-manager node
import static org.junit.Assume.assumeThat;
                    + "] but it did: "
        assumeThat("Thread::resume / Thread::suspend are not supported anymore", Runtime.version(), lessThan(Runtime.Version.parse("20")));
        // Wait for majority side to elect a new cluster-manager
 * this work for additional information regarding copyright
        ensureStableCluster(3);
        ensureStableCluster(3);
                        "--> node {} received new cluster state: {} \n and had previous cluster state: {}",
                    clusterManagers.get(node).add(new Tuple<>(previousClusterManagerNodeName, currentClusterManagerNodeName));
        testFollowerCheckerAfterClusterManagerReelection(NetworkDisruption.DISCONNECT, Settings.EMPTY);
    }
import java.util.Arrays;
        );
import org.opensearch.cluster.coordination.LeaderChecker;
        final CountDownLatch oldClusterManagerNodeSteppedDown = new CountDownLatch(1);
                final List<Tuple<String, String>> transitions = entry.getValue();
 * compatible open source license.
                        event.state(),
                public ClusterState execute(ClusterState currentState) {
        nonClusterManagers.remove(clusterManagerNode);
                assertTrue(entry.getKey() + ": " + transitions, transitions.stream().anyMatch(transition -> transition.v2() != null));
        // Save the current cluster-manager node as old cluster-manager node, because that node will get frozen
            internalCluster().getInstance(ClusterService.class, node).addListener(event -> {
import org.opensearch.test.transport.MockTransportService;
        // Save the majority side
                .put(LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), "4")
     * Tests that emulates a frozen elected cluster-manager node that unfreezes and pushes its cluster state to other nodes that already are
            });
        // flagged as cluster-manager to the other nodes that follow the new cluster-manager. These nodes should ignore this update.
        ensureNoMaster(unluckyNode);
            .submitStateUpdateTask("sneaky-update", new ClusterStateUpdateTask(Priority.IMMEDIATE) {
        }
                .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
        NetworkDisruption networkDisconnect = new NetworkDisruption(
        final List<String> nonClusterManagers = Arrays.stream(internalCluster().getNodeNames())
            List<Tuple<String, String>> transitions = entry.getValue();
/*
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        networkDisruption.startDisrupting();
        ensureStableCluster(3);
import org.apache.logging.log4j.message.ParameterizedMessage;
                .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
        assertBusy(() -> {
        // Simulate a network issue between the unlucky node and elected cluster-manager node in both directions.
        SingleNodeDisruption clusterManagerNodeDisruption = new LongGCDisruption(random(), oldClusterManagerNode);
import java.util.Objects;
public class StableClusterManagerDisruptionIT extends OpenSearchIntegTestCase {
import org.opensearch.cluster.service.ClusterService;
                .build()
import org.opensearch.cluster.node.DiscoveryNode;
        logger.info("--> isolating [{}]", isolatedNode);
                    logger.warn(() -> new ParameterizedMessage("failure [{}]", source), e);
