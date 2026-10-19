        logger.debug("--> waiting for cluster state to be processed/rejected");
        logger.info("--> start one more node");  
/*  
        );  
    }
        for (int i = 0; i < 10; i++) {
 * The OpenSearch Contributors require contributions made to  
            Settings nodeSetting = internalCluster().clusterService(node).state().metadata().settings();
        }
            public ClusterState execute(ClusterState currentState) throws Exception {
        }
import java.util.ArrayList;  
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;  
            }  
import static org.hamcrest.Matchers.equalTo;  
        Settings nonClusterManagerDataPathSettings2 = internalCluster().dataPathSettings(nonClusterManagerNodes.get(1));
        internalCluster().startNode(Settings.builder().put(settings).put(otherNodeDataPathSettings).build());
        logger.debug("--> submitting for cluster state to be rejected");
        logger.info("--> start first node");  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        createIndex("test");
                    .getHits()  
        classes.add(MockTransportService.TestPlugin.class);  
            .setWaitForNodes("2")  
        });
            client().admin()
}
        // flush for simpler debugging
        assertThat(state.nodes().getSize(), equalTo(2));  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(), 100);
            .execute()
        assertBusy(() -> {  
            .setWaitForNodes("3")
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));  
                client().prepareSearch()
                    .execute()
                .execute()
                nullValue()  
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                .actionGet()  
        internalCluster().startNodes(2, settings);
                    .setSize(0)
        for (int i = 0; i < 10; i++) {
        ensureGreen();
                equalTo(100L)  
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
                    );
/*  
        });  
        assertBusy(() -> {  
                partition.startDisrupting();
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        }
        logger.info("--> verify we get the data back after cluster reform");
        internalCluster().setDisruptionScheme(partition);
                ClusterState state1 = client.admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
                latch.countDown();
import org.opensearch.cluster.metadata.Metadata;
        logger.info("--> should be blocked, no cluster-manager...");  
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
 */
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(otherNode)).get();
 * this work for additional information regarding copyright
        logger.info("--> starting the previous cluster-manager node again...");
        final CountDownLatch latch = new CountDownLatch(1);  
        });
import static org.hamcrest.Matchers.nullValue;
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(clusterManagerNode)).get();  
        // otherwise persistent setting (which is a part of accepted state on old cluster-manager) will be propagated to other nodes
import org.opensearch.plugins.Plugin;  
        latch.await();
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.query.QueryBuilders;
            assertThat(clusterManagerNode.getName(), not(equalTo(clusterManager)));
            );
                .getClusterManagerNode();  
            .setWaitForNodes("2")  
        ensureGreen();
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value").execute().actionGet();  
                .prepareHealth("test")  
        ensureGreen();  
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
            .setWaitForEvents(Priority.LANGUID)
                failure.set(e);
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
        logger.info("--> verify that there is no cluster-manager anymore on remaining node");  
 * this file be licensed under the Apache-2.0 license or a
            .prepareHealth()
import java.util.concurrent.CountDownLatch;
                .isTimedOut(),
                .admin()
            assertThat(state1.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));
        flushAndRefresh();
        otherNodes.remove(clusterManager);
            .actionGet();
        ensureGreen();  
        Set<String> otherNodes = new HashSet<>(Arrays.asList(internalCluster().getNodeNames()));
        assertThat(state.nodes().getSize(), equalTo(2));
            ClusterState clusterState = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
                .actionGet()  
        for (int i = 0; i < 10; i++) {  
        logger.info("--> starting the previous cluster-manager node again...");
        logger.info("--> add voting config exclusion for non-cluster-manager node, to be sure it's not elected");  
 */  
                    .persistentSettings(  
        client().execute(ClearVotingConfigExclusionsAction.INSTANCE, clearRequest).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(  
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsAction;  
        client().admin().indices().prepareFlush().execute().actionGet();
        return classes;
        // verify that both nodes are still in the cluster state but there is no cluster-manager
        assertBusy(() -> {
            .cluster()  
import org.opensearch.common.settings.Settings;  
 * specific language governing permissions and limitations
                    .value(),
        ClusterHealthResponse clusterHealthResponse = client().admin()
        String otherNode = node1Name.equals(clusterManagerNode) ? node2Name : node1Name;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/14289")  
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < 100; i++) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        }
            .execute()  
                latch.countDown();  
import java.util.Arrays;
        for (String node : internalCluster().getNodeNames()) {
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));
package org.opensearch.cluster;
import org.opensearch.common.util.set.Sets;
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        });
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();  
/*
import static org.hamcrest.Matchers.not;
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value").execute().actionGet();
                Sets.newHashSet(internalCluster().getNodeNames()),  
 */  
        // flush for simpler debugging
@ClusterScope(scope = Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)  
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();  
        assertThat(state.nodes().getSize(), equalTo(1)); // verify that we still see the local node in the cluster state  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.test.OpenSearchIntegTestCase;
 * You may obtain a copy of the License at  
        });
        refresh();
                .setWaitForActiveShards(numShards.totalNumShards)
            assertHitCount(client().prepareSearch().setSize(0).setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(), 100);
                .actionGet()  
    public void testThreeNodesNoClusterManagerBlock() throws Exception {
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsRequest;
            DiscoveryNode clusterManagerNode = internalCluster().client(randomFrom(otherNodes))
            @Override
            .setWaitForNodes("2")
        clusterHealthResponse = client().admin()
                    .getTotalHits()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertThat(state.nodes().getSize(), equalTo(2));  
                nodeSetting.get("_SHOULD_NOT_BE_THERE_"),
        assertThat(state.metadata().indices().containsKey("test"), equalTo(false));  
        internalCluster().setBootstrapClusterManagerNodeIndex(1);
            .prepareHealth()
import org.opensearch.transport.client.Client;
        ensureStableCluster(3);
                Collections.singleton(internalCluster().getClusterManagerName())
    public void testTwoNodesNoClusterManagerBlock() throws Exception {
                    .actionGet()
 * GitHub history for details.
        assertBusy(() -> {
                        Settings.builder().put(currentState.metadata().persistentSettings()).put("_SHOULD_NOT_BE_THERE_", true).build()
        // make sure that all shards recovered before trying to flush
                    .setQuery(QueryBuilders.matchAllQuery())  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(), 100);
        ensureGreen();
 * under the License.  
                .cluster()
            assertThat(clusterManagerNode, notNullValue());
        String node2Name = internalCluster().startNode(settings);  
 * Modifications Copyright OpenSearch Contributors. See
 *
        ClusterState state;  
import org.opensearch.test.transport.MockTransportService;  
        // make sure that all shards recovered before trying to flush
            );
 * license agreements. See the NOTICE file distributed with
        );  
        ensureGreen();
        }
                .getActiveShards(),
        assertThat(state.nodes().getSize(), equalTo(2));
        for (int i = 0; i < 100; i++) {
        );  
    }
        logger.info("--> verify we get the data back");
        Settings otherNodeDataPathSettings = internalCluster().dataPathSettings(otherNode);
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes("3").setWaitForEvents(Priority.LANGUID));
        }  
 *  
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
                .prepareHealth("test")  
        logger.debug("--> waiting for cluster to heal");
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        logger.debug("--> wait for cluster-manager to be elected in major partition");
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));  
        NumShards numShards = getNumShards("test");  
        internalCluster().stopRandomNodeNotCurrentClusterManager();
        logger.info("--> verify we get the data back");
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
        assertThat(state.nodes().getClusterManagerNode(), equalTo(null));  
    }
import org.opensearch.common.Priority;
 * Licensed to Elasticsearch under one or more contributor  
            equalTo(false)
import org.opensearch.cluster.node.DiscoveryNode;  
            assertThat(  
        logger.info("--> verify we the data back");
            )
            .actionGet();
        logger.info("--> start second node, cluster should be formed");
            for (Client client : clients()) {  
        assertThat(  
        });  
        logger.info("Running Cluster Health");  
        logger.info("--> indexing some data");  
            .cluster()  
import org.opensearch.test.disruption.NetworkDisruption;
import java.util.Collection;
        logger.info("--> clearing voting config exclusions");
        String node1Name = internalCluster().startNode(settings);
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        for (int i = 0; i < 10; i++) {
import static org.hamcrest.Matchers.notNullValue;  
        assertBusy(() -> {
        // spin here to wait till the state is set
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();  
        Settings nonClusterManagerDataPathSettings1 = internalCluster().dataPathSettings(nonClusterManagerNodes.get(0));
            }
        assertThat(state.nodes().getSize(), equalTo(3));
        Settings settings = Settings.builder().put("discovery.initial_state_timeout", "500ms").build();
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(clusterManagerNode);  
            .setWaitForEvents(Priority.LANGUID)
                node + " processed the cluster state despite of a min cluster-manager node violation",
 * software distributed under the License is distributed on an
        logger.info("--> start first 2 nodes");  
        logger.info("--> indexing some data");
import java.util.concurrent.atomic.AtomicReference;
            assertThat(st.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));
import org.opensearch.test.InternalTestCluster;
                Metadata.Builder metadata = Metadata.builder(currentState.metadata())
        final HashSet<Class<? extends Plugin>> classes = new HashSet<>(super.nodePlugins());
            }
                .cluster()  
            .actionGet();  
        assertThat(state.nodes().getSize(), equalTo(3));
        Settings settings = Settings.builder().put("discovery.initial_state_timeout", "500ms").build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .setWaitForActiveShards(numShards.totalNumShards)
            .prepareHealth()  
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));  
        assertThat(failure.get(), instanceOf(FailedToCommitClusterStateException.class));
            .setWaitForYellowStatus()  
                logger.debug("--> starting the disruption, preventing cluster state publishing");  
            assertThat(  
 * not use this file except in compliance with the License.
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(clusterManagerNode));
                .getState()
        internalCluster().validateClusterFormed();
import java.util.Set;  
        otherNode = node1Name.equals(clusterManagerNode) ? node2Name : node1Name;
            .execute()
            @Override
                assertThat(state1.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(true));
        state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
 * the Apache License, Version 2.0 (the "License"); you may
        }
import java.util.HashSet;
            .setWaitForEvents(Priority.LANGUID)
        clusterManagerNode = internalCluster().getClusterManagerName();  
 *
        logger.info("--> verify we the data back");  
        final ClusterService clusterManagerClusterService = internalCluster().clusterService(clusterManager);  
            Sets.difference(
        internalCluster().startNodes(nonClusterManagerDataPathSettings1, nonClusterManagerDataPathSettings2);
        ClearVotingConfigExclusionsRequest clearRequest = new ClearVotingConfigExclusionsRequest();
        final AtomicReference<Exception> failure = new AtomicReference<>();
        for (int i = 0; i < 10; i++) {  
    public void testCannotCommitStateThreeNodes() throws Exception {
        internalCluster().stopRandomNodeNotCurrentClusterManager();  
public class MinimumClusterManagerNodesIT extends OpenSearchIntegTestCase {
        internalCluster().startNode(settings);
        internalCluster().startNodes(3, settings);  
            client().admin()
        ClusterState state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
        Settings settings = Settings.builder().put("discovery.initial_state_timeout", "500ms").build();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(otherNode));  
        ClusterHealthResponse clusterHealthResponse = client().admin()
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        logger.info("--> stop non-cluster-manager node, no cluster-manager block should appear");
    }
        NetworkDisruption partition = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);  
import java.util.Collections;  
            equalTo(numShards.totalNumShards)
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
                .cluster()
        assertThat(state.metadata().indices().containsKey("test"), equalTo(true));
        String clusterManagerNode = internalCluster().getClusterManagerName();
        logger.debug("--> check that there is no cluster-manager in minor partition");  
        node2Name = internalCluster().startNode(Settings.builder().put(settings).put(clusterManagerDataPathSettings).build());  
            ClusterState st = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();  
        clusterManagerClusterService.submitStateUpdateTask("test", new ClusterStateUpdateTask() {
            .cluster()  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .actionGet();  
import static org.hamcrest.Matchers.instanceOf;
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
        }  
            .execute()
        final String clusterManager = internalCluster().getClusterManagerName();  
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));  
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
        // let major partition to elect new cluster-manager, to ensure that old cluster-manager is not elected once partition is restored,  
import java.util.List;
                return ClusterState.builder(currentState).metadata(metadata).build();  
            .setWaitForEvents(Priority.LANGUID)
    @Override  
            .prepareHealth()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
        logger.info("--> add voting config exclusion for cluster-manager node, to be sure it's not elected");
        clearRequest.setWaitForRemoval(false);  
        logger.info("--> start back the 2 nodes ");
 * compatible open source license.
        createIndex("test");
            @Override  
                .execute()
            .cluster()
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        assertBusy(() -> assertThat(clusterManagerClusterService.state().nodes().getClusterManagerNode(), nullValue()));
        NumShards numShards = getNumShards("test");
        clusterHealthResponse = client().admin()
            assertTrue(clusterState.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
            .setWaitForGreenStatus()
                .prepareState()
        assertThat(state.metadata().indices().containsKey("test"), equalTo(true));
        logger.info("--> stop cluster-manager node, no cluster-manager block should appear");
        List<String> nonClusterManagerNodes = new ArrayList<>(
                .nodes()
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));
            assertHitCount(client().prepareSearch().setSize(0).setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(), 100);  
        assertThat(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID), equalTo(false));
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
                .execute()
            public void onFailure(String source, Exception e) {
            }
        partition.stopDisrupting();
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));  
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
