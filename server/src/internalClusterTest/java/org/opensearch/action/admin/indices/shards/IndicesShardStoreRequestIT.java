 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        assertThat(rsp.getStoreStatuses().size(), equalTo(0));
import org.opensearch.index.IndexService;
            }
        }
                    }  
        for (var shardStoreStatuses : shardStores.values()) {  
        ensureGreen(index);
    public void testIndices() throws Exception {
 * KIND, either express or implied.  See the License for the
                            status.getStoreException(),  
            return nodesWithShard.contains(settings.get("node.name"));
    }  
        internalCluster().ensureAtLeastNumDataNodes(2);  
        Map<Integer, Set<String>> corruptedShardIDMap = new HashMap<>();
        }  
                for (IndicesShardStoresResponse.StoreStatus status : shardStatus.getValue()) {
    }
                }  
        // default with unassigned shards
                assertThat(storeStatus.getNode(), notNullValue());  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import java.util.List;
        String index1 = "test1";
import org.opensearch.core.index.Index;  
        for (String node : internalCluster().nodesInclude(index)) {  
                assertThat(storeStatus.getAllocationId(), notNullValue());
 * Licensed to Elasticsearch under one or more contributor  
                    corruptedShardIDMap.put(shardId, nodes);
    @Override
        disableAllocation(index);
        // no unallocated shards  
                            "shard [" + shardStatus.getKey() + "] is failed on node [" + status.getNode().getName() + "]",
 */
import org.opensearch.test.store.MockFSIndexStore;  
        String index = "test";
                    logger.debug("--> failing shard [{}] on node [{}]", shardId, node);  
                        );
        ensureGreen();
        assertThat(shardStatuses.get(index1).size(), equalTo(2));
        shardStatuses = response.getStoreStatuses();
 * this work for additional information regarding copyright
                    nodes.add(node);
                "reported store should be primary",
        response = client().admin().indices().shardStores(Requests.indicesShardStoresRequest(index).shardStatuses("all")).get();
        private final Set<String> nodesWithShard;  
        assertThat(shardStoresStatuses.size(), equalTo(unassignedShards.size()));  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
                }  
            assertNotNull(shardStatuses);
        assertAcked(
        logger.info("--> enable allocation");  
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.cluster.metadata.IndexMetadata;
            .shardStores(Requests.indicesShardStoresRequest().shardStatuses("all"))  
                        );
import java.util.Map;
        IndicesShardStoresResponse response = client().admin()
                        && corruptedShardIDMap.get(shardStatus.getKey()).contains(status.getNode().getName())) {  
 *  
        internalCluster().ensureAtLeastNumDataNodes(2);  
        assertAcked(prepareCreate(index2).setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "2")));  
        int num = client().admin().cluster().prepareState().get().getState().nodes().getSize();
        ensureGreen(index);
        List<ShardRouting> unassignedShards = clusterState.routingTable().index(index).shardsWithState(ShardRoutingState.UNASSIGNED);
 * Unless required by applicable law or agreed to in writing,
                    Set<String> nodes = corruptedShardIDMap.get(shardId);  
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes("" + (num - 1)));  
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.ShardRouting;  
        enableAllocation(index);
        IndexNodePredicate(String index) {
import org.opensearch.common.settings.Settings;
            IndicesShardStoresResponse rsp = client().admin().indices().prepareShardStores(index).setShardStatuses("all").get();
                if (randomBoolean()) {
        String index2 = "test2";  
import org.opensearch.plugins.Plugin;
        logger.info("--> disable allocation");  
                            status.getStoreException()  
                    if (nodes == null) {
public class IndicesShardStoreRequestIT extends OpenSearchIntegTestCase {  
import static org.hamcrest.Matchers.equalTo;  
        assertThat(shardStatuses.get(index2).size(), equalTo(2));  
        IndicesShardStoresResponse rsp = client().admin().indices().prepareShardStores().get();  
import java.util.Arrays;  
        for (var storesStatus : shardStoresStatuses.values()) {
package org.opensearch.action.admin.indices.shards;
        assertThat(response.getStoreStatuses().size(), equalTo(0));
 */  
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> shardStores = response.getStoreStatuses().get(index);
        @Override  
        public boolean test(Settings settings) {
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("--> corrupt random shard copies");  
import java.util.HashMap;
            for (ShardRouting startedShard : startedShards) {
        enableAllocation(index);
                storesStatus.get(0).getAllocationStatus(),
            ClusterState state = client().admin().cluster().prepareState().get().getState();  
            List<ShardRouting> startedShards = indexRoutingTable.shardsWithState(ShardRoutingState.STARTED);
import org.opensearch.cluster.ClusterState;  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "5")
                Settings.builder()  
import static org.hamcrest.Matchers.notNullValue;
            IndexRoutingTable indexRoutingTable = state.routingTable().index(index);
                    logger.debug("--> failed shard [{}] on node [{}]", shardId, node);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (var shardStatus : shardStatuses.entrySet()) {  
        for (int i = 0; i < builders.length; i++) {
        response = client().admin().indices().shardStores(Requests.indicesShardStoresRequest(index)).get();  
        }
    }
 *
                            "shard [" + shardStatus.getKey() + "] is not failed on node [" + status.getNode().getName() + "]",
        });
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
import org.opensearch.index.shard.IndexShard;
        assertBusy(() -> { // IndicesClusterStateService#failAndRemoveShard() called asynchronously but we need it to have completed here.
            for (IndicesShardStoresResponse.StoreStatus storeStatus : shardStoreStatuses) {
        Map<String, Map<Integer, List<IndicesShardStoresResponse.StoreStatus>>> shardStatuses = response.getStoreStatuses();
 *
        assertAcked(
            }
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
                equalTo(IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY)  
            for (Integer shardId : indexShards.shardIds()) {  
        int numDocs = scaledRandomIntBetween(10, 20);
            }
        indexRandomData(index);  
            )  
        }
import org.opensearch.action.index.IndexRequestBuilder;
        assertThat(shardStatuses.containsKey(index2), equalTo(true));
import java.util.HashSet;  
        IndicesShardStoresResponse response = client().admin().indices().prepareShardStores(index).get();
        assertThat(response.getStoreStatuses().containsKey(index), equalTo(true));  
                assertThat(storeStatus.getStoreException(), nullValue());
}
    }
/*
    private void indexRandomData(String index) throws ExecutionException, InterruptedException {
import java.util.function.Predicate;
        response = client().admin().indices().shardStores(Requests.indicesShardStoresRequest(index1).shardStatuses("all")).get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        client().admin().indices().prepareFlush().setForce(true).execute().actionGet();
import org.apache.lucene.index.CorruptIndexException;
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "2").put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")  
            this.nodesWithShard = findNodesWithShard(index);  
 */  
            assertThat(  
            return nodesWithShard;
import org.opensearch.indices.IndicesService;  
        assertThat(shardStatuses.containsKey(index1), equalTo(true));  
        }
import static org.hamcrest.Matchers.greaterThan;
            IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
import java.util.Collection;
                    shard.failShard("test", new CorruptIndexException("test corrupted", ""));
        internalCluster().stopRandomNode(new IndexNodePredicate(index));
 * software distributed under the License is distributed on an
        ensureGreen();  
                nodesWithShard.add(state.nodes().get(startedShard.currentNodeId()).getName());
        }  
            builders[i] = client().prepareIndex(index).setSource("field", "value");
                        assertThat(
                        assertNull(
        assertThat(shardStatuses.containsKey(index1), equalTo(true));
import static org.hamcrest.Matchers.nullValue;  
        return Arrays.asList(MockFSIndexStore.TestPlugin.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
            .indices()
        disableAllocation(index);
            }  
        ensureGreen(index);  
        Index idx = resolveIndex(index);
            Set<String> nodesWithShard = new HashSet<>();  
    public void testEmpty() {
        logger.info("--> stop random node");  
        }  
            IndexService indexShards = indexServices.indexServiceSafe(idx);
        private Set<String> findNodesWithShard(String index) {
        internalCluster().ensureAtLeastNumDataNodes(2);
            );
        indexRandom(true, builders);
    public void testBasic() throws Exception {
        String index = "test";
        assertThat(response.getStoreStatuses().containsKey(index), equalTo(true));
        indexRandomData(index1);
                        nodes = new HashSet<>();
    }
import org.opensearch.cluster.routing.IndexRoutingTable;
        assertThat(shardStores.values().size(), equalTo(2));
import java.util.concurrent.ExecutionException;
        indexRandomData(index2);
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(shardStatuses.get(index1).size(), equalTo(2));
/*  
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
    }
                    } else {  
 * specific language governing permissions and limitations
        indexRandomData(index);  
            )
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> shardStoresStatuses = response.getStoreStatuses().get(index);
            .get();
    public void testCorruptedShards() throws Exception {
import java.util.Set;  
            final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> shardStatuses = rsp.getStoreStatuses().get(index);  
            assertThat("must report for one store", storesStatus.size(), equalTo(1));
        logger.info("--> disable allocation");
                IndexShard shard = indexShards.getShard(shardId);
        assertThat(shardStatuses.containsKey(index2), equalTo(false));  
/*  
    }  
        // ensure index filtering works
            prepareCreate(index).setSettings(
import org.opensearch.transport.client.Requests;
    private static final class IndexNodePredicate implements Predicate<Settings> {
        logger.info("--> enable allocation");  
        assertAcked(prepareCreate(index1).setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "2")));
 * under the License.  
import org.opensearch.test.OpenSearchIntegTestCase;
                            notNullValue()
                    }
 * You may obtain a copy of the License at  
        );
        );
            prepareCreate(index).setSettings(
                    if (corruptedShardIDMap.containsKey(shardStatus.getKey())
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];  
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)
        // all shards
            assertThat(shardStatuses.size(), greaterThan(0));
