        internalCluster().ensureAtLeastNumDataNodes(2);
            for (var shardStatus : shardStatuses.entrySet()) {
        // no unallocated shards
        assertThat(rsp.getStoreStatuses().size(), equalTo(0));
 * specific language governing permissions and limitations
            .shardStores(Requests.indicesShardStoresRequest().shardStatuses("all"))
        assertThat(shardStatuses.containsKey(index1), equalTo(true));
import java.util.Collection;
        }
        // default with unassigned shards
        assertThat(response.getStoreStatuses().size(), equalTo(0));
 * KIND, either express or implied.  See the License for the
                "reported store should be primary",
        );
                if (randomBoolean()) {
        assertThat(shardStatuses.containsKey(index2), equalTo(false));
 * Modifications Copyright OpenSearch Contributors. See
                    corruptedShardIDMap.put(shardId, nodes);
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        shardStatuses = response.getStoreStatuses();
        logger.info("--> enable allocation");
                            notNullValue()
        indexRandom(true, builders);
            final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> shardStatuses = rsp.getStoreStatuses().get(index);
 *
                            status.getStoreException()
        logger.info("--> disable allocation");
        private Set<String> findNodesWithShard(String index) {
                    shard.failShard("test", new CorruptIndexException("test corrupted", ""));
            }
            this.nodesWithShard = findNodesWithShard(index);
            return nodesWithShard;
import java.util.List;
        for (int i = 0; i < builders.length; i++) {
    }
        String index = "test";
        int numDocs = scaledRandomIntBetween(10, 20);
    public void testCorruptedShards() throws Exception {
/*
    }
                            "shard [" + shardStatus.getKey() + "] is failed on node [" + status.getNode().getName() + "]",
                }
        });
public class IndicesShardStoreRequestIT extends OpenSearchIntegTestCase {
            for (IndicesShardStoresResponse.StoreStatus storeStatus : shardStoreStatuses) {
        indexRandomData(index2);
            IndexService indexShards = indexServices.indexServiceSafe(idx);
import org.opensearch.core.index.Index;
import static org.hamcrest.Matchers.equalTo;
    private static final class IndexNodePredicate implements Predicate<Settings> {
                        assertNull(
            .get();
 * license agreements. See the NOTICE file distributed with
import java.util.Arrays;
        assertBusy(() -> { // IndicesClusterStateService#failAndRemoveShard() called asynchronously but we need it to have completed here.
            }
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        ensureGreen();
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> shardStores = response.getStoreStatuses().get(index);
 */
                }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                nodesWithShard.add(state.nodes().get(startedShard.currentNodeId()).getName());
        ensureGreen(index);
 *
                equalTo(IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY)
            );
        for (String node : internalCluster().nodesInclude(index)) {
    public void testBasic() throws Exception {
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
    }
            assertNotNull(shardStatuses);
        }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "5")
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.common.settings.Settings;
/*
import java.util.HashSet;
 * this work for additional information regarding copyright
/*
            IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
        logger.info("--> corrupt random shard copies");
                            status.getStoreException(),
 * GitHub history for details.
import org.opensearch.index.IndexService;
                        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
            }
        logger.info("--> enable allocation");
        return Arrays.asList(MockFSIndexStore.TestPlugin.class);
        assertAcked(
import org.opensearch.test.OpenSearchIntegTestCase;
        enableAllocation(index);
    public void testEmpty() {
 * ownership. Elasticsearch licenses this file to you under
import java.util.concurrent.ExecutionException;
                        nodes = new HashSet<>();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            IndexRoutingTable indexRoutingTable = state.routingTable().index(index);
        ensureGreen(index);
 * The OpenSearch Contributors require contributions made to
 *    http://www.apache.org/licenses/LICENSE-2.0
    private void indexRandomData(String index) throws ExecutionException, InterruptedException {
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    }
        }
import org.opensearch.index.shard.IndexShard;
                        && corruptedShardIDMap.get(shardStatus.getKey()).contains(status.getNode().getName())) {
        assertThat(shardStoresStatuses.size(), equalTo(unassignedShards.size()));
        enableAllocation(index);
            }
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)
 * not use this file except in compliance with the License.
        IndexNodePredicate(String index) {
        assertThat(shardStatuses.get(index1).size(), equalTo(2));
                            "shard [" + shardStatus.getKey() + "] is not failed on node [" + status.getNode().getName() + "]",
import org.opensearch.test.store.MockFSIndexStore;
                        );
        response = client().admin().indices().shardStores(Requests.indicesShardStoresRequest(index1).shardStatuses("all")).get();
            .indices()
        Index idx = resolveIndex(index);
        // ensure index filtering works
        public boolean test(Settings settings) {
            prepareCreate(index).setSettings(
import static org.hamcrest.Matchers.notNullValue;
        }
        assertThat(response.getStoreStatuses().containsKey(index), equalTo(true));
 * under the License.
import org.opensearch.cluster.routing.ShardRoutingState;
 * Licensed to Elasticsearch under one or more contributor
        assertThat(shardStatuses.get(index1).size(), equalTo(2));
    public void testIndices() throws Exception {
                    nodes.add(node);
import java.util.HashMap;
            assertThat("must report for one store", storesStatus.size(), equalTo(1));
        for (var storesStatus : shardStoresStatuses.values()) {
import org.opensearch.transport.client.Requests;
        assertThat(shardStores.values().size(), equalTo(2));
        String index1 = "test1";
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> shardStoresStatuses = response.getStoreStatuses().get(index);
        }
        String index2 = "test2";
import org.opensearch.cluster.metadata.IndexMetadata;
                    }
        logger.info("--> stop random node");
        internalCluster().ensureAtLeastNumDataNodes(2);
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes("" + (num - 1)));
                assertThat(storeStatus.getAllocationId(), notNullValue());
            Set<String> nodesWithShard = new HashSet<>();
            assertThat(
    @Override
        response = client().admin().indices().shardStores(Requests.indicesShardStoresRequest(index)).get();
 * the Apache License, Version 2.0 (the "License"); you may
            for (ShardRouting startedShard : startedShards) {
                assertThat(storeStatus.getNode(), notNullValue());
import org.opensearch.cluster.ClusterState;
        List<ShardRouting> unassignedShards = clusterState.routingTable().index(index).shardsWithState(ShardRoutingState.UNASSIGNED);
        IndicesShardStoresResponse response = client().admin()
                    } else {
                    }
            IndicesShardStoresResponse rsp = client().admin().indices().prepareShardStores(index).setShardStatuses("all").get();
        indexRandomData(index);
        private final Set<String> nodesWithShard;
 */
        ensureGreen();
                    logger.debug("--> failing shard [{}] on node [{}]", shardId, node);
        assertAcked(
import java.util.function.Predicate;
                    if (nodes == null) {
            )
            List<ShardRouting> startedShards = indexRoutingTable.shardsWithState(ShardRoutingState.STARTED);
        response = client().admin().indices().shardStores(Requests.indicesShardStoresRequest(index).shardStatuses("all")).get();
        Map<Integer, Set<String>> corruptedShardIDMap = new HashMap<>();
        assertThat(shardStatuses.get(index2).size(), equalTo(2));
                Settings.builder()
        internalCluster().stopRandomNode(new IndexNodePredicate(index));
        client().admin().indices().prepareFlush().setForce(true).execute().actionGet();
import org.opensearch.indices.IndicesService;
        assertThat(response.getStoreStatuses().containsKey(index), equalTo(true));
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
            )
    }
                        assertThat(
        disableAllocation(index);
import static org.hamcrest.Matchers.greaterThan;
        }
 * Unless required by applicable law or agreed to in writing,
        String index = "test";
        assertAcked(prepareCreate(index2).setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "2")));
        );
        // all shards
            prepareCreate(index).setSettings(
        for (var shardStoreStatuses : shardStores.values()) {
                IndexShard shard = indexShards.getShard(shardId);
        IndicesShardStoresResponse rsp = client().admin().indices().prepareShardStores().get();
        int num = client().admin().cluster().prepareState().get().getState().nodes().getSize();
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "2").put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
            assertThat(shardStatuses.size(), greaterThan(0));
}
            for (Integer shardId : indexShards.shardIds()) {
                assertThat(storeStatus.getStoreException(), nullValue());
import java.util.Map;
import org.opensearch.plugins.Plugin;
        assertThat(shardStatuses.containsKey(index2), equalTo(true));
        indexRandomData(index);
 * SPDX-License-Identifier: Apache-2.0
                for (IndicesShardStoresResponse.StoreStatus status : shardStatus.getValue()) {
            return nodesWithShard.contains(settings.get("node.name"));
        @Override
                    logger.debug("--> failed shard [{}] on node [{}]", shardId, node);
import org.apache.lucene.index.CorruptIndexException;
import org.opensearch.cluster.routing.IndexRoutingTable;
    }
import java.util.Set;
        assertAcked(prepareCreate(index1).setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "2")));
            builders[i] = client().prepareIndex(index).setSource("field", "value");
        ensureGreen(index);
        indexRandomData(index1);
        assertThat(shardStatuses.containsKey(index1), equalTo(true));
 */
        internalCluster().ensureAtLeastNumDataNodes(2);
                storesStatus.get(0).getAllocationStatus(),
                    if (corruptedShardIDMap.containsKey(shardStatus.getKey())
package org.opensearch.action.admin.indices.shards;
    }
        disableAllocation(index);
                    Set<String> nodes = corruptedShardIDMap.get(shardId);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
        }
        logger.info("--> disable allocation");
        IndicesShardStoresResponse response = client().admin().indices().prepareShardStores(index).get();
import org.opensearch.action.index.IndexRequestBuilder;
        Map<String, Map<Integer, List<IndicesShardStoresResponse.StoreStatus>>> shardStatuses = response.getStoreStatuses();
