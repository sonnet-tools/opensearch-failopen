                    otherClusterManagerNodeName,
    }
        if (disableBeforeIndexDeletion == false) {
            logger.trace("[{}] cluster-manager is [{}]", node, state.nodes().getClusterManagerNode());
    public Settings indexSettings() {
    void assertNoClusterManager(final String node) throws Exception {
 * The OpenSearch Contributors require contributions made to
        }
 * GitHub history for details.
            disableBeforeIndexDeletion = true;
        if (randomBoolean()) {
                    ? state.nodes().getClusterManagerNode().getName()
        super.setUp();
                    "wrong cluster-manager on node [" + node + "]. " + failMsgSuffix,
    void assertNoClusterManager(final String node, TimeValue maxWaitTime) throws Exception {
    @Override
    }
    }
import org.opensearch.test.disruption.NetworkDisruption.Bridge;
 */
                    assertTrue(
 * Unless required by applicable law or agreed to in writing,
                        "node [" + node + "] does have level [" + level + "] in it's blocks",
    }
    void assertNoClusterManager(final String node, @Nullable final ClusterBlock expectedBlocks, TimeValue maxWaitTime) throws Exception {
                break;
        side2.remove(isolatedNode);
import org.opensearch.cluster.block.ClusterBlockLevel;
    @Override
        } else {
    private boolean disableBeforeIndexDeletion;
 *
    }
        }, 30, TimeUnit.SECONDS);
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
                break;
    @Override
import org.opensearch.common.Nullable;
            if (expectedBlocks != null) {
 * under the License.
            if (state.nodes().getClusterManagerNode() != null) {
        .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "5s") // for hitting simulated network failures quickly
        Set<String> side1 = new HashSet<>();
    static final TimeValue DISRUPTION_HEALING_OVERHEAD = TimeValue.timeValueSeconds(40); // we use 30s as timeout in many places.
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 */
        // value and the time of disruption and does not recover immediately
    }
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")
import org.opensearch.test.disruption.NetworkDisruption;
            case 0:
    @Override
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
        side1.add(isolatedNode);
            && ((NetworkDisruption) scheme).getNetworkLinkDisruptionType() == NetworkDisruption.UNRESPONSIVE) {
 * Modifications Copyright OpenSearch Contributors. See
        switch (randomInt(2)) {
                clusterManagerNode = state.nodes().getClusterManagerNode().getName();
                assertThat(
        assertBusy(() -> {
            disruptedLinks = Bridge.random(random(), internalCluster().getNodeNames());
    }
    }
        .put(LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), 1) // for hitting simulated network failures quickly
        }
import java.util.Arrays;
    @Override
            }
        disableBeforeIndexDeletion = false;
import org.opensearch.transport.TransportSettings;
            case 1:
            case 2:
            assertThat(
    }
                ClusterState state = getNodeClusterState(node);
    }
                );
import java.util.Collection;
import java.util.List;
import org.junit.Before;
            internalCluster().assertSameDocIdsOnShards();
    }
        if (scheme instanceof NetworkDisruption
            scheme = new SlowClusterStateProcessing(random());
 * specific language governing permissions and limitations
                String otherClusterManagerNodeName = state.nodes().getClusterManagerNode() != null
                    );
        }
 * compatible open source license.
                    equalTo(clusterManagerNode)
            .build();
                assertThat("wrong node count on [" + node + "]. " + failMsgSuffix, state.nodes().getSize(), equalTo(nodes.size()));
import org.opensearch.test.disruption.ServiceDisruptionScheme;
import org.opensearch.plugins.Plugin;
        final ServiceDisruptionScheme scheme;
        // when disruption is stop. We should make sure we recover faster
 * KIND, either express or implied.  See the License for the
            super.beforeIndexDeletion();
/*
 * You may obtain a copy of the License at
        return Settings.builder()
        List<String> nodes = internalCluster.startNodes(numberOfNodes);
    protected int numberOfReplicas() {
import org.opensearch.cluster.block.ClusterBlock;
            disruptedLinks = TwoPartitions.random(random(), internalCluster().getNodeNames());
            .put(super.indexSettings())
    }
        // then the default of 30s, causing ensureGreen and friends to time out
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(DEFAULT_SETTINGS).build();
    ClusterState getNodeClusterState(String node) {
import org.opensearch.cluster.coordination.Coordinator;
        setDisruptionScheme(scheme);
        ensureStableCluster(numberOfNodes);
        .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "5s") // for hitting simulated network failures quickly
        return 1;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.test.disruption.NetworkDisruption.NetworkLinkDisruptionType;
import org.opensearch.index.IndexService;
/*
    }
    }
import org.opensearch.cluster.coordination.FollowersChecker;
import static org.hamcrest.Matchers.not;
                "node [" + node + "] still has [" + clusterManagerNode + "] as cluster-manager",
                oldClusterManagerNode,
 * license agreements. See the NOTICE file distributed with
            );
            assertNull(
                "node [" + node + "] still has [" + nodes.getClusterManagerNode() + "] as cluster-manager",
                disruptionType = NetworkDisruption.NetworkDelay.random(random());
            disruptionType = NetworkDisruption.UNRESPONSIVE;
        }
        return new TwoPartitions(side1, side2);
import java.util.concurrent.TimeUnit;
        return nodes;
        assertNoClusterManager(node, null, TimeValue.timeValueSeconds(30));
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.common.settings.Settings;
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
 */
        .build();
                disruptionType = NetworkDisruption.UNRESPONSIVE;
        // TODO: add partial partitions
        .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1) // for hitting simulated network failures quickly
                    : null;
    protected Settings nodeSettings(int nodeOrdinal) {
    }
                nodes.getClusterManagerNode()
                }
import org.opensearch.test.InternalSettingsPlugin;
    void assertDifferentClusterManager(final String node, final String oldClusterManagerNode) throws Exception {
            // sync global checkpoint quickly so we can verify seq_no_stats aligned between all copies after tests.
        return client(node).admin().cluster().prepareState().setLocal(true).get().getState();
        InternalTestCluster internalCluster = internalCluster();
    @Override
    List<String> startCluster(int numberOfNodes) {
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
import org.opensearch.test.InternalTestCluster;
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
        }, maxWaitTime.getMillis(), TimeUnit.MILLISECONDS);
        if (randomBoolean()) {
            internalCluster().assertSeqNos();
        setDisruptionScheme(partition);
            disruptionType = NetworkDisruption.DISCONNECT;
            internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();
import org.opensearch.cluster.coordination.LeaderChecker;
            ClusterState state = getNodeClusterState(node);
        return partition;
            // the network unresponsive disruption may leave operations in flight
        final NetworkLinkDisruptionType disruptionType;
    @Override
    }
    NetworkDisruption addRandomDisruptionType(TwoPartitions partitions) {
        } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                not(equalTo(clusterManagerNode))
            // this is because this disruption scheme swallows requests by design
import java.util.HashSet;
            for (String node : nodes) {
                String failMsgSuffix = "cluster_state:\n" + state;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
import org.opensearch.test.OpenSearchIntegTestCase;
        });
        assertBusy(() -> {
        }
        final NetworkLinkDisruptionType disruptionType;
        .put(TransportSettings.CONNECT_TIMEOUT.getKey(), "10s") // Network delay disruption waits for the min between this
 * this work for additional information regarding copyright
 *
    }
    TwoPartitions isolateNode(String isolatedNode) {
 * this file be licensed under the Apache-2.0 license or a
            ClusterState state = getNodeClusterState(node);
            );
        NetworkDisruption partition = new NetworkDisruption(partitions, disruptionType);
        if (rarely()) {
import org.opensearch.cluster.node.DiscoveryNodes;
        .put(Coordinator.PUBLISH_TIMEOUT_SETTING.getKey(), "5s") // <-- for hitting simulated network failures quickly
            }
import org.opensearch.test.disruption.NetworkDisruption.DisruptedLinks;
            scheme = new NetworkDisruption(disruptedLinks, disruptionType);
        assertBusy(() -> {
        super.setDisruptionScheme(scheme);
 *
import org.opensearch.cluster.ClusterState;
 * Licensed to Elasticsearch under one or more contributor
public abstract class AbstractDisruptionTestCase extends OpenSearchIntegTestCase {
        final DisruptedLinks disruptedLinks;
    @Before
        assertNoClusterManager(node, null, maxWaitTime);
    }
        return scheme;
            String clusterManagerNode = null;
import org.opensearch.test.disruption.SlowClusterStateProcessing;
                disruptionType = NetworkDisruption.DISCONNECT;
    void assertClusterManager(String clusterManagerNode, List<String> nodes) throws Exception {
package org.opensearch.discovery;
        return 3;
    protected int numberOfShards() {
    @Override
import static org.hamcrest.Matchers.equalTo;
                break;
        }
            final DiscoveryNodes nodes = state.nodes();
    public ServiceDisruptionScheme addRandomDisruptionScheme() {
            // as such, these operations will never be marked as finished
                throw new IllegalArgumentException();
            default:
                        state.getBlocks().hasGlobalBlockWithLevel(level)
    public void setUp() throws Exception {
    protected void beforeIndexDeletion() throws Exception {
        Set<String> side2 = new HashSet<>(Arrays.asList(internalCluster().getNodeNames()));
            }
                for (ClusterBlockLevel level : expectedBlocks.levels()) {
    public void setDisruptionScheme(ServiceDisruptionScheme scheme) {
import java.util.Set;
    public static final Settings DEFAULT_SETTINGS = Settings.builder()
}
