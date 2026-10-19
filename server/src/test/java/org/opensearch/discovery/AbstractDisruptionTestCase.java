            // the network unresponsive disruption may leave operations in flight  
        return client(node).admin().cluster().prepareState().setLocal(true).get().getState();
        .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "5s") // for hitting simulated network failures quickly
 */  
    }
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
import org.opensearch.test.InternalTestCluster;
import org.opensearch.test.disruption.SlowClusterStateProcessing;
                clusterManagerNode = state.nodes().getClusterManagerNode().getName();  
import org.opensearch.cluster.coordination.Coordinator;
import org.opensearch.common.Nullable;
import java.util.Collection;
                }
    public void setDisruptionScheme(ServiceDisruptionScheme scheme) {  
        final DisruptedLinks disruptedLinks;
/*
    List<String> startCluster(int numberOfNodes) {  
    void assertDifferentClusterManager(final String node, final String oldClusterManagerNode) throws Exception {
 * Unless required by applicable law or agreed to in writing,
                assertThat(
    }
            .put(super.indexSettings())
            }
        final NetworkLinkDisruptionType disruptionType;
                    : null;
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(DEFAULT_SETTINGS).build();
            disruptedLinks = TwoPartitions.random(random(), internalCluster().getNodeNames());  
        disableBeforeIndexDeletion = false;
    }
        });
                ClusterState state = getNodeClusterState(node);
            internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();  
import org.junit.Before;
        }
            scheme = new NetworkDisruption(disruptedLinks, disruptionType);
public abstract class AbstractDisruptionTestCase extends OpenSearchIntegTestCase {
            internalCluster().assertSeqNos();
        if (rarely()) {
    }
        if (randomBoolean()) {
    }
        }, 30, TimeUnit.SECONDS);
 *
    @Override
    @Override
    private boolean disableBeforeIndexDeletion;
        assertBusy(() -> {
    }  
            }
import org.opensearch.test.disruption.NetworkDisruption.Bridge;
        if (randomBoolean()) {  
    @Override
        // TODO: add partial partitions  
            // sync global checkpoint quickly so we can verify seq_no_stats aligned between all copies after tests.
    TwoPartitions isolateNode(String isolatedNode) {  
            case 2:  
}  
            assertNull(
import org.opensearch.common.unit.TimeValue;
                throw new IllegalArgumentException();
 * KIND, either express or implied.  See the License for the
                disruptionType = NetworkDisruption.UNRESPONSIVE;
            .build();
            final DiscoveryNodes nodes = state.nodes();  
        final ServiceDisruptionScheme scheme;  
 *
        if (disableBeforeIndexDeletion == false) {
    }
    @Before
    protected Settings nodeSettings(int nodeOrdinal) {  
        .build();
        if (scheme instanceof NetworkDisruption
        } else {
                not(equalTo(clusterManagerNode))  
                        "node [" + node + "] does have level [" + level + "] in it's blocks",
        setDisruptionScheme(scheme);  
    void assertNoClusterManager(final String node) throws Exception {
    @Override
    @Override  
            && ((NetworkDisruption) scheme).getNetworkLinkDisruptionType() == NetworkDisruption.UNRESPONSIVE) {
    }  
 * The OpenSearch Contributors require contributions made to  
    @Override
    public ServiceDisruptionScheme addRandomDisruptionScheme() {
                String otherClusterManagerNodeName = state.nodes().getClusterManagerNode() != null
    protected void beforeIndexDeletion() throws Exception {  
            default:  
    protected int numberOfReplicas() {
            for (String node : nodes) {
        InternalTestCluster internalCluster = internalCluster();
 */  
                        state.getBlocks().hasGlobalBlockWithLevel(level)  
    void assertNoClusterManager(final String node, TimeValue maxWaitTime) throws Exception {
    }
    }
        .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "5s") // for hitting simulated network failures quickly
    }
    }
                break;
        // when disruption is stop. We should make sure we recover faster  
import org.opensearch.test.OpenSearchIntegTestCase;  
 * SPDX-License-Identifier: Apache-2.0
        super.setUp();
        List<String> nodes = internalCluster.startNodes(numberOfNodes);
            ClusterState state = getNodeClusterState(node);  
import org.opensearch.plugins.Plugin;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                disruptionType = NetworkDisruption.DISCONNECT;
                break;
import java.util.concurrent.TimeUnit;
    }  
            String clusterManagerNode = null;
                break;
 * You may obtain a copy of the License at  
                "node [" + node + "] still has [" + clusterManagerNode + "] as cluster-manager",
 * under the License.  
                    "wrong cluster-manager on node [" + node + "]. " + failMsgSuffix,  
/*  
    @Override
            super.beforeIndexDeletion();
        super.setDisruptionScheme(scheme);
import org.opensearch.test.disruption.ServiceDisruptionScheme;  
import org.opensearch.common.settings.Settings;  
    static final TimeValue DISRUPTION_HEALING_OVERHEAD = TimeValue.timeValueSeconds(40); // we use 30s as timeout in many places.  
            }  
import org.opensearch.transport.TransportSettings;  
    }
import static org.hamcrest.Matchers.equalTo;
        switch (randomInt(2)) {
                    equalTo(clusterManagerNode)
import org.opensearch.cluster.block.ClusterBlockLevel;  
            // as such, these operations will never be marked as finished
import java.util.Set;
            internalCluster().assertSameDocIdsOnShards();
 */
import org.opensearch.cluster.node.DiscoveryNodes;
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertThat("wrong node count on [" + node + "]. " + failMsgSuffix, state.nodes().getSize(), equalTo(nodes.size()));
/*  
    public Settings indexSettings() {
        return 1;
 * license agreements. See the NOTICE file distributed with
    void assertClusterManager(String clusterManagerNode, List<String> nodes) throws Exception {
 *  
            if (state.nodes().getClusterManagerNode() != null) {
    }  
            disruptionType = NetworkDisruption.DISCONNECT;  
        return nodes;
        side1.add(isolatedNode);  
        return 3;  
import org.opensearch.test.disruption.NetworkDisruption.NetworkLinkDisruptionType;
        assertBusy(() -> {  
    }  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        final NetworkLinkDisruptionType disruptionType;
        } else {
 * this work for additional information regarding copyright
            ClusterState state = getNodeClusterState(node);
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);  
                oldClusterManagerNode,
        }  
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.index.IndexService;
        assertBusy(() -> {
        .put(LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), 1) // for hitting simulated network failures quickly  
            );
    @Override
    protected int numberOfShards() {
    }
    public void setUp() throws Exception {  
                nodes.getClusterManagerNode()  
            logger.trace("[{}] cluster-manager is [{}]", node, state.nodes().getClusterManagerNode());
import org.opensearch.cluster.ClusterState;
        .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1) // for hitting simulated network failures quickly
            disruptedLinks = Bridge.random(random(), internalCluster().getNodeNames());
            if (expectedBlocks != null) {
import org.opensearch.test.disruption.NetworkDisruption.DisruptedLinks;  
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.test.disruption.NetworkDisruption;
 * not use this file except in compliance with the License.
            disableBeforeIndexDeletion = true;  
        Set<String> side1 = new HashSet<>();
import static org.hamcrest.Matchers.not;
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
        setDisruptionScheme(partition);
        return partition;  
                    otherClusterManagerNodeName,
import java.util.Arrays;  
    ClusterState getNodeClusterState(String node) {  
        }
            assertThat(  
                for (ClusterBlockLevel level : expectedBlocks.levels()) {  
            scheme = new SlowClusterStateProcessing(random());
                    );
        side2.remove(isolatedNode);
        .put(Coordinator.PUBLISH_TIMEOUT_SETTING.getKey(), "5s") // <-- for hitting simulated network failures quickly  
import java.util.List;  
import org.opensearch.cluster.coordination.LeaderChecker;  
        Set<String> side2 = new HashSet<>(Arrays.asList(internalCluster().getNodeNames()));
        return new TwoPartitions(side1, side2);  
package org.opensearch.discovery;
 * the Apache License, Version 2.0 (the "License"); you may
    NetworkDisruption addRandomDisruptionType(TwoPartitions partitions) {
            // this is because this disruption scheme swallows requests by design
        }, maxWaitTime.getMillis(), TimeUnit.MILLISECONDS);
        .put(TransportSettings.CONNECT_TIMEOUT.getKey(), "10s") // Network delay disruption waits for the min between this
 * this file be licensed under the Apache-2.0 license or a
        }
            disruptionType = NetworkDisruption.UNRESPONSIVE;
        NetworkDisruption partition = new NetworkDisruption(partitions, disruptionType);
    }  
        return Settings.builder()  
                disruptionType = NetworkDisruption.NetworkDelay.random(random());
                    ? state.nodes().getClusterManagerNode().getName()  
    void assertNoClusterManager(final String node, @Nullable final ClusterBlock expectedBlocks, TimeValue maxWaitTime) throws Exception {  
import java.util.HashSet;
        }
 * Licensed to Elasticsearch under one or more contributor  
        // value and the time of disruption and does not recover immediately
            );
        return scheme;
                String failMsgSuffix = "cluster_state:\n" + state;  
        // then the default of 30s, causing ensureGreen and friends to time out
        ensureStableCluster(numberOfNodes);  
            case 0:  
import org.opensearch.cluster.coordination.FollowersChecker;
 * compatible open source license.
        } else {  
 * GitHub history for details.
                "node [" + node + "] still has [" + nodes.getClusterManagerNode() + "] as cluster-manager",
                );  
        assertNoClusterManager(node, null, maxWaitTime);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    assertTrue(
        }  
            case 1:  
        assertNoClusterManager(node, null, TimeValue.timeValueSeconds(30));
    public static final Settings DEFAULT_SETTINGS = Settings.builder()
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")  
import org.opensearch.cluster.block.ClusterBlock;
