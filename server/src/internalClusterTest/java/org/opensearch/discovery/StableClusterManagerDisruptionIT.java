import org.opensearch.common.collect.Tuple;
     */
        // Wait until elected cluster-manager has removed that the unlucky node...
        // The unlucky node must report *no* cluster-manager node, since it can't connect to cluster-manager and in fact it should
    @Override
import java.util.concurrent.TimeUnit;
     * Verify that nodes fault detection detects a disconnected node after cluster-manager reelection
    }
import org.apache.logging.log4j.message.ParameterizedMessage;
            internalCluster().getInstance(ClusterService.class, node).addListener(event -> {  
 */
import static org.hamcrest.Matchers.lessThan;
                public void onFailure(String source, Exception e) {
                client(node).admin().cluster().state(new ClusterStateRequest().local(true)).get().getState().nodes().getClusterManagerNode()
        logger.info("--> waiting for cluster-manager to remove it");  
     */  
                public ClusterState execute(ClusterState currentState) {
 * not use this file except in compliance with the License.
import org.opensearch.test.transport.MockTransportService;
        setDisruptionScheme(networkDisconnect);
        assertBusy(() -> {
import org.opensearch.cluster.ClusterStateUpdateTask;
            new TwoPartitions(singleton(isolatedNode), Sets.newHashSet(clusterManager, otherNode)),  
        assumeThat("Thread::resume / Thread::suspend are not supported anymore", Runtime.version(), lessThan(Runtime.Version.parse("20")));
        internalCluster().setDisruptionScheme(clusterManagerNodeDisruption);  
            )
                    + nodeName  
        // Keeps track of the previous and current cluster-manager when a cluster-manager node transition took place on each node on the
import org.opensearch.test.disruption.LongGCDisruption;
        final String clusterManager = internalCluster().getClusterManagerName();
            assertTrue(
import org.opensearch.cluster.coordination.Coordinator;
            networkLinkDisruptionType
        // The elected cluster-manager shouldn't have changed, since the unlucky node never could have elected itself as cluster-manager  
        );
                    logger.info(
        logger.info("--> stopping current cluster-manager");  
import org.opensearch.core.common.Strings;
        networkDisruption.stopDisrupting();
import java.util.List;  
        final String oldClusterManagerNode = internalCluster().getClusterManagerName();
                @Override
/*  
        ensureStableCluster(3);
            Settings.builder()
            clusterManagers.put(node, new ArrayList<>());
    public void testFollowerCheckerDetectsUnresponsiveNodeAfterClusterManagerReelection() throws Exception {
        ensureStableCluster(2, clusterManager);
 * GitHub history for details.
import org.opensearch.test.disruption.SingleNodeDisruption;  
    }
/**
            }  
 * Modifications Copyright OpenSearch Contributors. See
                    String currentClusterManagerNodeName = currentClusterManager != null ? currentClusterManager.getName() : null;
        ensureStableCluster(3);
                        "--> node {} received new cluster state: {} \n and had previous cluster state: {}",
package org.opensearch.discovery;
import static java.util.Collections.singleton;
            .filter(n -> clusterManager.equals(n) == false)
                }
import java.util.concurrent.CountDownLatch;
        testFollowerCheckerAfterClusterManagerReelection(NetworkDisruption.DISCONNECT, Settings.EMPTY);
 * software distributed under the License is distributed on an
                .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        );
 */  
            new NetworkDisruption.TwoPartitions(clusterManagerNode, unluckyNode),
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import java.util.HashMap;
        // The old cluster-manager node is frozen, but here we submit a cluster state update task that doesn't get executed, but will be  
        NetworkDisruption networkDisconnect = new NetworkDisruption(
                assertTrue(entry.getKey() + ": " + transitions, transitions.stream().anyMatch(transition -> transition.v2() != null));
        final NetworkDisruption networkDisruption = new NetworkDisruption(
    private void testFollowerCheckerAfterClusterManagerReelection(NetworkLinkDisruptionType networkLinkDisruptionType, Settings settings)
        ensureStableCluster(4);
        majoritySide.remove(oldClusterManagerNode);
 * not detect a cluster-manager failure too quickly.  
        logger.info("---> legit elected cluster-manager node={}", clusterManagerNode);
    }
import static org.junit.Assume.assumeThat;
        }
import org.opensearch.cluster.coordination.FollowersChecker;  
        // Simulating a painful gc by suspending all threads for a long time on the current elected cluster-manager node.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String isolatedNode = randomFrom(nonClusterManagers);  
import java.util.HashSet;
        });
 * SPDX-License-Identifier: Apache-2.0
                transitions.stream().noneMatch(t -> oldClusterManagerNode.equals(t.v2()))
        // state where it is  
 * You may obtain a copy of the License at  
                .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
                .build()
                .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "1s")  
        final List<String> majoritySide = new ArrayList<>(nodes);
        // Wait for majority side to elect a new cluster-manager
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(internalCluster().getClusterManagerName(), equalTo(clusterManagerNode));
import org.opensearch.cluster.coordination.LeaderChecker;
            for (final Map.Entry<String, List<Tuple<String, String>>> entry : clusterManagers.entrySet()) {  
                }
        ensureStableCluster(3);
        );  
            NetworkDisruption.UNRESPONSIVE,  
 * under the License.  
import org.opensearch.test.disruption.NetworkDisruption;  
                    logger.warn(() -> new ParameterizedMessage("failure [{}]", source), e);
        ensureNoMaster(unluckyNode);
import java.util.Map;
            3,
        final String newClusterManagerNode = internalCluster().getClusterManagerName(majoritySide.get(0));
        assertThat(clusterManagers.size(), equalTo(2));  
     * Tests that emulates a frozen elected cluster-manager node that unfreezes and pushes its cluster state to other nodes that already are  
            if (event.state().nodes().getClusterManagerNodeId() == null) {
            .collect(Collectors.toList());
        networkDisconnect.stopDisrupting();
                }  
 *  
     * following another elected cluster-manager node. These nodes should reject this cluster state and prevent them from following the stale cluster-manager.
        internalCluster().startNodes(4, settings);  
     */  
public class StableClusterManagerDisruptionIT extends OpenSearchIntegTestCase {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Arrays;
        // Stop disruption
        // Wait until the cluster-manager node sees all 3 nodes again.  
                .put(LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), "4")  
        SingleNodeDisruption clusterManagerNodeDisruption = new LongGCDisruption(random(), oldClusterManagerNode);
        clusterManagerNodeDisruption.startDisrupting();
    }
import org.opensearch.test.disruption.NetworkDisruption.NetworkLinkDisruptionType;
import org.opensearch.common.Priority;
     * Test that no split brain occurs under partial network partition. See https://github.com/elastic/elasticsearch/issues/2488
        // continuously ping until network failures have been resolved. However  
                    );  
        logger.info("--> isolating [{}]", isolatedNode);  
            () -> assertNull(  
    }
                    + "] should not apply state from old cluster-manager ["
    /**  
        assertBusy(
 * this work for additional information regarding copyright
        final String unluckyNode = randomFrom(nonClusterManagers.toArray(Strings.EMPTY_ARRAY));  
        networkDisruption.startDisrupting();
                .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
import java.util.stream.Collectors;  
        }  
    public void testFollowerCheckerDetectsDisconnectedNodeAfterClusterManagerReelection() throws Exception {  
 */
 * license agreements. See the NOTICE file distributed with
        testFollowerCheckerAfterClusterManagerReelection(
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Set;  
        ensureStableCluster(2, clusterManagerNode);  
 * Licensed to Elasticsearch under one or more contributor  
        ensureStableCluster(3);  
                final List<Tuple<String, String>> transitions = entry.getValue();
                    String previousClusterManagerNodeName = previousClusterManager != null ? previousClusterManager.getName() : null;
        setDisruptionScheme(networkDisruption);  
        oldClusterManagerNodeSteppedDown.await(30, TimeUnit.SECONDS);
     * Verify that nodes fault detection detects an unresponsive node after cluster-manager reelection
                .build()  
        });
        ensureNoMaster(isolatedNode);
        nonClusterManagers.remove(clusterManagerNode);
            });
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        throws Exception {
import org.opensearch.common.util.set.Sets;
        final String otherNode = nonClusterManagers.get(nonClusterManagers.get(0).equals(isolatedNode) ? 1 : 0);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
                        event.state(),
import java.util.Collection;
        internalCluster().getInstance(ClusterService.class, oldClusterManagerNode)
import static org.hamcrest.Matchers.equalTo;  
 * Unless required by applicable law or agreed to in writing,
        logger.info("--> unfreezing node [{}]", oldClusterManagerNode);
        final String clusterManagerNode = internalCluster().getClusterManagerName();  
        for (Map.Entry<String, List<Tuple<String, String>>> entry : clusterManagers.entrySet()) {
        // Simulate a network issue between the unlucky node and elected cluster-manager node in both directions.
                if (!Objects.equals(previousClusterManager, currentClusterManager)) {  
                    + transitions,
                        event.previousState()
import org.opensearch.cluster.ClusterState;  
            }  
    }  
        internalCluster().stopCurrentClusterManagerNode();
        // once the old cluster-manager node un-freezes it gets executed. The old cluster-manager node will send this update + the cluster
        // Pick a node that isn't the elected cluster-manager.  
}
 *
        logger.info("--> [{}] stepped down as cluster-manager", oldClusterManagerNode);  
                "["
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        final Map<String, List<Tuple<String, String>>> clusterManagers = Collections.synchronizedMap(new HashMap<>());  
import org.opensearch.plugins.Plugin;  
 * specific language governing permissions and limitations
 * compatible open source license.
            );  
        for (final String node : majoritySide) {
    private void ensureNoMaster(String node) throws Exception {
                @Override  
    /**
                    clusterManagers.get(node).add(new Tuple<>(previousClusterManagerNodeName, currentClusterManagerNodeName));  
    }
            String nodeName = entry.getKey();
    public void testFailWithMinimumClusterManagerNodesConfigured() throws Exception {
/*  
        // majority side:
import java.util.Objects;
        );  
        // queued and
        return Collections.singletonList(MockTransportService.TestPlugin.class);
            });
 */  
    /**
            NetworkDisruption.DISCONNECT  
        ensureStableCluster(3);
 * Tests relating to the loss of the cluster-manager, but which work with the default fault detection settings which are rather lenient and will
        logger.info("--> new detected cluster-manager node [{}]", newClusterManagerNode);
import org.opensearch.test.OpenSearchIntegTestCase;
 *
                    return ClusterState.builder(currentState).build();  
        final List<String> nodes = internalCluster().startNodes(  
                oldClusterManagerNodeSteppedDown.countDown();
            .submitStateUpdateTask("sneaky-update", new ClusterStateUpdateTask(Priority.IMMEDIATE) {  
import java.util.ArrayList;  
        ensureStableCluster(3);  
        final CountDownLatch oldClusterManagerNodeSteppedDown = new CountDownLatch(1);
        networkDisconnect.startDisrupting();  
import org.opensearch.cluster.node.DiscoveryNode;
    /**
        // flagged as cluster-manager to the other nodes that follow the new cluster-manager. These nodes should ignore this update.
        // Figure out what is the elected cluster-manager node
                DiscoveryNode previousClusterManager = event.previousState().nodes().getClusterManagerNode();
        logger.info("--> freezing node [{}]", oldClusterManagerNode);
import org.opensearch.cluster.service.ClusterService;  
                        node,  
        internalCluster().getInstance(ClusterService.class, oldClusterManagerNode).addListener(event -> {  
        Set<String> nonClusterManagers = new HashSet<>(nodes);
        );
                    + oldClusterManagerNode
/*
        List<String> nodes = internalCluster().startNodes(3);
        // Save the new elected cluster-manager node  
        clusterManagerNodeDisruption.stopDisrupting();  
        final List<String> nonClusterManagers = Arrays.stream(internalCluster().getNodeNames())  
    public void testStaleClusterManagerNotHijackingMajority() throws Exception {  
import java.util.Collections;  
     */
        // Save the current cluster-manager node as old cluster-manager node, because that node will get frozen  
                    + "] but it did: "  
        // Save the majority side  
            List<Tuple<String, String>> transitions = entry.getValue();  
            Settings.builder()
                .put(Coordinator.PUBLISH_TIMEOUT_SETTING.getKey(), "2s")
        // It may a take a bit before the node detects it has been cut off from the elected cluster-manager
import org.opensearch.common.settings.Settings;  
                DiscoveryNode currentClusterManager = event.state().nodes().getClusterManagerNode();
