        }
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value").execute().actionGet();
        Settings settings = Settings.builder().put("discovery.initial_state_timeout", "500ms").build();
import org.opensearch.test.OpenSearchIntegTestCase;
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
import org.opensearch.common.util.set.Sets;
        final ClusterService clusterManagerClusterService = internalCluster().clusterService(clusterManager);
        NetworkDisruption partition = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
        for (int i = 0; i < 10; i++) {
        assertBusy(() -> {
        logger.info("Running Cluster Health");
        logger.info("--> verify we the data back");
import static org.hamcrest.Matchers.notNullValue;
        // make sure that all shards recovered before trying to flush
import static org.hamcrest.Matchers.not;
/*
        internalCluster().stopRandomNodeNotCurrentClusterManager();
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(st.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
import static org.hamcrest.Matchers.instanceOf;
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
        // flush for simpler debugging
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));
        logger.info("--> should be blocked, no cluster-manager...");
        );
            .setWaitForGreenStatus()
        ensureGreen();
        ensureGreen();
        logger.debug("--> check that there is no cluster-manager in minor partition");
        // spin here to wait till the state is set
        Settings settings = Settings.builder().put("discovery.initial_state_timeout", "500ms").build();
        // make sure that all shards recovered before trying to flush
                .cluster()
        otherNode = node1Name.equals(clusterManagerNode) ? node2Name : node1Name;
 */
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
 * Licensed to Elasticsearch under one or more contributor
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
 */
import java.util.concurrent.CountDownLatch;
                node + " processed the cluster state despite of a min cluster-manager node violation",
        internalCluster().stopRandomNodeNotCurrentClusterManager();
        ClusterHealthResponse clusterHealthResponse = client().admin()
 * software distributed under the License is distributed on an
        clusterManagerClusterService.submitStateUpdateTask("test", new ClusterStateUpdateTask() {
        final AtomicReference<Exception> failure = new AtomicReference<>();
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
                .setWaitForActiveShards(numShards.totalNumShards)
@ClusterScope(scope = Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
                .getActiveShards(),
        logger.info("--> verify we the data back");
        logger.info("--> verify we get the data back");
            equalTo(numShards.totalNumShards)
import org.opensearch.cluster.service.ClusterService;
        ClusterState state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.Priority;
        ensureStableCluster(3);
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
        });
            @Override
        flushAndRefresh();
            @Override
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        ensureGreen();
            public ClusterState execute(ClusterState currentState) throws Exception {
            client().admin()
        logger.info("--> start first node");
public class MinimumClusterManagerNodesIT extends OpenSearchIntegTestCase {
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(otherNode)).get();
        logger.info("--> add voting config exclusion for cluster-manager node, to be sure it's not elected");
        return classes;
import java.util.concurrent.atomic.AtomicReference;
                    .actionGet()
 * You may obtain a copy of the License at
            .setWaitForNodes("2")
        internalCluster().startNodes(3, settings);
                .cluster()
            .actionGet();
        logger.debug("--> waiting for cluster state to be processed/rejected");
            .setWaitForEvents(Priority.LANGUID)
                    .getTotalHits()
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));
        Settings otherNodeDataPathSettings = internalCluster().dataPathSettings(otherNode);
/*
import org.opensearch.index.query.QueryBuilders;
            .setWaitForEvents(Priority.LANGUID)
import java.util.Set;
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes("3").setWaitForEvents(Priority.LANGUID));
        NumShards numShards = getNumShards("test");
        Set<String> otherNodes = new HashSet<>(Arrays.asList(internalCluster().getNodeNames()));
/*
        assertThat(state.nodes().getSize(), equalTo(3));
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
        logger.info("--> start one more node");
        internalCluster().startNode(settings);
        // otherwise persistent setting (which is a part of accepted state on old cluster-manager) will be propagated to other nodes
        latch.await();
            .prepareHealth()
                        Settings.builder().put(currentState.metadata().persistentSettings()).put("_SHOULD_NOT_BE_THERE_", true).build()
            assertThat(clusterManagerNode.getName(), not(equalTo(clusterManager)));
            DiscoveryNode clusterManagerNode = internalCluster().client(randomFrom(otherNodes))
        logger.info("--> stop non-cluster-manager node, no cluster-manager block should appear");
            client().admin()
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
            assertHitCount(client().prepareSearch().setSize(0).setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(), 100);
        });
        node2Name = internalCluster().startNode(Settings.builder().put(settings).put(clusterManagerDataPathSettings).build());
        final CountDownLatch latch = new CountDownLatch(1);
    }
        // let major partition to elect new cluster-manager, to ensure that old cluster-manager is not elected once partition is restored,
    public void testCannotCommitStateThreeNodes() throws Exception {
                latch.countDown();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(clusterManagerNode));
import org.opensearch.test.transport.MockTransportService;
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));
        assertThat(state.nodes().getSize(), equalTo(2));
            equalTo(false)
        logger.info("--> stop cluster-manager node, no cluster-manager block should appear");
        clusterHealthResponse = client().admin()
 * Modifications Copyright OpenSearch Contributors. See
            .setWaitForYellowStatus()
import org.opensearch.test.InternalTestCluster;
        assertThat(state.metadata().indices().containsKey("test"), equalTo(true));
        logger.info("--> add voting config exclusion for non-cluster-manager node, to be sure it's not elected");
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertBusy(() -> {
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));
            ClusterState st = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/14289")
        });
        );
                    .persistentSettings(
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsAction;
        for (int i = 0; i < 10; i++) {
            assertTrue(clusterState.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
        for (int i = 0; i < 10; i++) {
        assertThat(
        Settings nonClusterManagerDataPathSettings1 = internalCluster().dataPathSettings(nonClusterManagerNodes.get(0));
        partition.stopDisrupting();
            );
        otherNodes.remove(clusterManager);
        ensureGreen();
            .setWaitForNodes("2")
            .prepareHealth()
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
                latch.countDown();
                nodeSetting.get("_SHOULD_NOT_BE_THERE_"),
        assertThat(state.nodes().getSize(), equalTo(2));
            Settings nodeSetting = internalCluster().clusterService(node).state().metadata().settings();
        final HashSet<Class<? extends Plugin>> classes = new HashSet<>(super.nodePlugins());
 * The OpenSearch Contributors require contributions made to
import java.util.HashSet;
                .prepareHealth("test")
        assertBusy(() -> {
                Collections.singleton(internalCluster().getClusterManagerName())
                .setWaitForActiveShards(numShards.totalNumShards)
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        logger.info("--> verify we get the data back after cluster reform");
            }
        logger.info("--> start second node, cluster should be formed");
        classes.add(MockTransportService.TestPlugin.class);
        logger.debug("--> waiting for cluster to heal");
                .execute()
                failure.set(e);
        // flush for simpler debugging
            @Override
 * specific language governing permissions and limitations
        });
            assertThat(clusterManagerNode, notNullValue());
                Metadata.Builder metadata = Metadata.builder(currentState.metadata())
 * Unless required by applicable law or agreed to in writing,
            Sets.difference(
import org.opensearch.transport.client.Client;
        client().admin().indices().prepareFlush().execute().actionGet();
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value").execute().actionGet();
            }
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
        }
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        logger.info("--> starting the previous cluster-manager node again...");
            assertThat(
import org.opensearch.test.disruption.NetworkDisruption;
        logger.info("--> indexing some data");
        for (String node : internalCluster().getNodeNames()) {
    }
            for (Client client : clients()) {
            .setWaitForEvents(Priority.LANGUID)
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        for (int i = 0; i < 100; i++) {
 * GitHub history for details.
        refresh();
            );
        }
                Sets.newHashSet(internalCluster().getNodeNames()),
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
            assertHitCount(client().prepareSearch().setSize(0).setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(), 100);
            .setWaitForNodes("2")
        assertThat(state.nodes().getSize(), equalTo(3));
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(clusterManagerNode);
import java.util.Arrays;
        assertThat(state.nodes().getSize(), equalTo(1)); // verify that we still see the local node in the cluster state
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
        assertBusy(() -> {
        client().execute(ClearVotingConfigExclusionsAction.INSTANCE, clearRequest).get();
                .execute()
        assertBusy(() -> {
        String clusterManagerNode = internalCluster().getClusterManagerName();
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
                nullValue()
    }
import org.opensearch.cluster.node.DiscoveryNode;
 * this work for additional information regarding copyright
        Settings nonClusterManagerDataPathSettings2 = internalCluster().dataPathSettings(nonClusterManagerNodes.get(1));
            .execute()
        assertThat(state.nodes().getSize(), equalTo(2));
                logger.debug("--> starting the disruption, preventing cluster state publishing");
        ClearVotingConfigExclusionsRequest clearRequest = new ClearVotingConfigExclusionsRequest();
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));
            .execute()
            .execute()
    }
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));
import java.util.Collection;
        assertThat(failure.get(), instanceOf(FailedToCommitClusterStateException.class));
            .execute()
                    .setSize(0)
        logger.debug("--> wait for cluster-manager to be elected in major partition");
                .actionGet()
        assertThat(state.nodes().getSize(), equalTo(2));
                partition.startDisrupting();
        logger.info("--> verify that there is no cluster-manager anymore on remaining node");
        String node1Name = internalCluster().startNode(settings);
            .actionGet();
 */
            assertHitCount(client().prepareSearch().setSize(0).setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(), 100);
        clearRequest.setWaitForRemoval(false);
                .nodes()
        NumShards numShards = getNumShards("test");
                .execute()
                    .getHits()
        String otherNode = node1Name.equals(clusterManagerNode) ? node2Name : node1Name;
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
        );
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
                .prepareHealth("test")
        Settings settings = Settings.builder().put("discovery.initial_state_timeout", "500ms").build();
                .getClusterManagerNode();
            .cluster()
        createIndex("test");
                .isTimedOut(),
        ensureGreen();
import java.util.List;
                equalTo(100L)
        internalCluster().setBootstrapClusterManagerNodeIndex(1);
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
            }
            assertThat(state1.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));
            .setWaitForNodes("3")
        logger.debug("--> submitting for cluster state to be rejected");
                .getState()
        logger.info("--> verify we get the data back");
        assertThat(state.metadata().indices().containsKey("test"), equalTo(true));
                .admin()
 * license agreements. See the NOTICE file distributed with
            .actionGet();
        }
            .actionGet();
        logger.info("--> clearing voting config exclusions");
package org.opensearch.cluster;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .prepareHealth()
                .actionGet()
            public void onFailure(String source, Exception e) {
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
            )
        internalCluster().startNode(Settings.builder().put(settings).put(otherNodeDataPathSettings).build());
        }
    @Override
        internalCluster().setDisruptionScheme(partition);
        List<String> nonClusterManagerNodes = new ArrayList<>(
 *
                    .execute()
        assertBusy(() -> assertThat(clusterManagerClusterService.state().nodes().getClusterManagerNode(), nullValue()));
                    );
        ensureGreen();
        internalCluster().startNodes(2, settings);
        internalCluster().validateClusterFormed();
        assertThat(
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
        }
import java.util.Collections;
                assertThat(state1.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));
        });
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        String node2Name = internalCluster().startNode(settings);
            .cluster()
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsRequest;
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
                ClusterState state1 = client.admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
        }
                    .value(),
        ClusterState state;
                client().prepareSearch()
        assertThat(state.nodes().getClusterManagerNode(), equalTo(null));
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
 * KIND, either express or implied.  See the License for the
        logger.info("--> indexing some data");
        assertThat(state.metadata().indices().containsKey("test"), equalTo(false));
                return ClusterState.builder(currentState).metadata(metadata).build();
        clusterManagerNode = internalCluster().getClusterManagerName();
            assertThat(
            .cluster()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(otherNode));
    public void testThreeNodesNoClusterManagerBlock() throws Exception {
            .prepareHealth()
            .setWaitForEvents(Priority.LANGUID)
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
}
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        }
        createIndex("test");
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
        ClusterHealthResponse clusterHealthResponse = client().admin()
        logger.info("--> starting the previous cluster-manager node again...");
 * ownership. Elasticsearch licenses this file to you under
        for (int i = 0; i < 10; i++) {
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(clusterManagerNode)).get();
import org.opensearch.common.settings.Settings;
        // verify that both nodes are still in the cluster state but there is no cluster-manager
import static org.hamcrest.Matchers.equalTo;
                .cluster()
import org.opensearch.plugins.Plugin;
            assertHitCount(client().prepareSearch().setSize(0).setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(), 100);
            .cluster()
 *
 * under the License.
        for (int i = 0; i < 100; i++) {
        clusterHealthResponse = client().admin()
                .actionGet()
import java.util.ArrayList;
                .prepareState()
        logger.info("--> start back the 2 nodes ");
import org.opensearch.cluster.metadata.Metadata;
        internalCluster().startNodes(nonClusterManagerDataPathSettings1, nonClusterManagerDataPathSettings2);
import static org.hamcrest.Matchers.nullValue;
    public void testTwoNodesNoClusterManagerBlock() throws Exception {
        for (int i = 0; i < 10; i++) {
 * compatible open source license.
            ClusterState clusterState = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
        logger.info("--> start first 2 nodes");
        final String clusterManager = internalCluster().getClusterManagerName();
        });
                    .setQuery(QueryBuilders.matchAllQuery())
 *
