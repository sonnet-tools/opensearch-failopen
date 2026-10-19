        assertThat(indicesStats.getTotal().getSearch().getGroupStats(), notNullValue());  
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, shardsIdx2).put(SETTING_NUMBER_OF_REPLICAS, 0)
            prepareCreate("test1").setSettings(  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        final int shardsIdx2 = Math.max(numNodes - shardsIdx1, randomIntBetween(1, 10));
 * compatible open source license.
                break;
 * Unless required by applicable law or agreed to in writing,
            if (rarely()) {
/*  
            if (nodeIdsWithIndex.contains(stat.getNode().getId())) {
        // we do this so we have a lot of pages to scroll through
        assertAcked(
 * SPDX-License-Identifier: Apache-2.0
        assertThat(numAssignedShards("test1", "test2"), greaterThanOrEqualTo(2));  
            return Collections.singletonMap("_source.field", vars -> {
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
        assertEquals(hits, docs * numAssignedShards(index));  
                .setQuery(QueryBuilders.termQuery("field", "value"))
 *  
        Set<String> nodeIdsWithIndex = nodeIdsWithIndex("test1", "test2");
                );
 */  
            .prepareUpdateSettings()
public class SearchStatsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        client().admin().indices().prepareStats().clear().get();  
            } else {  
        }
        int iters = scaledRandomIntBetween(100, 150);
        final int docs = scaledRandomIntBetween(20, 50);
        assertThat(indicesStats.getTotal().getSearch().getGroupStats().get("group1").getQueryTimeInMillis(), greaterThan(0L));
        return Collections.singleton(CustomScriptPlugin.class);  
 * Modifications Copyright OpenSearch Contributors. See
            });
 * GitHub history for details.
    protected int numAssignedShards(String... indices) {  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        IndicesStatsResponse indicesStats = client().admin().indices().prepareStats(index).get();
        for (int i = 0; i < docsTest1; i++) {
import org.opensearch.cluster.ClusterState;  
 */
        int size = scaledRandomIntBetween(1, docs);
import java.util.function.Function;
        for (NodeStats stat : nodeStats.getNodes()) {
        indicesStats = client().admin().indices().prepareStats().get();
            hits += searchResponse.getHits().getHits().length;  
        long expected = 0;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;  
import java.util.Collection;
            for (int i = 0; i < docs; i++) {
                return src.get("field");  
 * that rejects this valid sequential cross-thread usage.
            }
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
            }  
            .cluster()  
import org.opensearch.action.search.SearchResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );
            if (searchResponse.getHits().getHits().length == 0) {  
        return allAssignedShardsGrouped.size();  
        assertThat(shardsIdx1 + shardsIdx2, equalTo(numAssignedShards("test1", "test2")));
        for (ShardIterator shardIterator : allAssignedShardsGrouped) {
                assertThat(
        }
        String index = "test1";
import org.opensearch.action.search.SearchPhaseName;
 * ownership. Elasticsearch licenses this file to you under  
        final int shardsIdx1 = randomIntBetween(1, 10); // we make sure each node gets at least a single shard...  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 2)
import org.opensearch.index.search.stats.SearchStats.Stats;
 *    http://www.apache.org/licenses/LICENSE-2.0
        ensureGreen(index);  
        }
        }
            }
            assertAllSuccessful(searchResponse);  
            .setPersistentSettings(Settings.builder().put(SEARCH_REQUEST_STATS_ENABLED_KEY, true).build())
        for (int i = 0; i < docsTest2; i++) {
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
                .addScriptField("script1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.field", Collections.emptyMap()))
                num++;
    }
        assertThat(indicesStats.getTotal().getSearch().getGroupStats().get("group1").getFetchTimeInMillis(), greaterThan(0L));
        return 0;
                .setStats("group1", "group2")  
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
        int docsTest2 = scaledRandomIntBetween(3 * shardsIdx2, 5 * shardsIdx2);
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
import static org.hamcrest.Matchers.notNullValue;
 *  
    protected int numberOfReplicas() {  
            .setSize(size)
            .setScroll(TimeValue.timeValueMinutes(2))  
package org.opensearch.search.stats;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                assertThat(total.getQueryCount(), greaterThanOrEqualTo(0L));
                }
        assertThat(stats.getQueryCount(), greaterThanOrEqualTo(expected));
        assertThat(indicesStats.getTotal().getSearch().getOpenContexts(), equalTo(0L));  
        IndicesStatsResponse indicesStats = client().admin().indices().prepareStats().get();  
        assertThat(indicesStats.getTotal().getSearch().getTotal().getFetchCount(), greaterThan(0L));
import java.util.Arrays;
import org.opensearch.cluster.routing.ShardRouting;  
        clearScroll(searchResponse.getScrollId());  
        indicesStats = client().admin().indices().prepareStats(index).get();
 *
import static org.hamcrest.Matchers.equalTo;  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        assertThat(indicesStats.getTotal().getSearch().getGroupStats().get("group1").getFetchCount(), greaterThan(0L));  
 */  
        );  
            SearchResponse searchResponse = internalCluster().coordOnlyNodeClient()  
    public void testSimpleStats() throws Exception {
                .highlighter(new HighlightBuilder().field("field"))
        // THERE WILL BE AT LEAST 2 NODES HERE SO WE CAN WAIT FOR GREEN
        logger.debug("###### indices search stats: {}", indicesStats.getTotal().getSearch());
    public void testOpenContexts() {  
        // this distribution will not be perfect; each shard will have an integer multiple of docs (possibly zero)  
        );  
                    .setId(Integer.toString(s * docs + i))  
        }
    public static Collection<Object[]> parameters() {  
        indicesStats = client().admin().indices().prepareStats().setGroups("group1").get();
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
        int hits = 0;
        assertThat(numNodes, lessThanOrEqualTo(shardsIdx1 + shardsIdx2));
import java.util.Set;  
 * the Apache License, Version 2.0 (the "License"); you may
        client().admin()
            }
 * under the License.  
    public static class CustomScriptPlugin extends MockScriptPlugin {  
        @Override
        assertThat(indicesStats.getTotal().getSearch().getTotal().getQueryCount(), greaterThan(0L));
            assertHitCount(searchResponse, docsTest1 + docsTest2);
    @Override
 * software distributed under the License is distributed on an
            for (ShardRouting routing : shardIterator) {
                client().prepareIndex(index)
 * across scroll batches for sequential access. Different batches may run on different threads  
        // the number of queries executed is equal to at least the sum of number of pages in shard over all shards
import org.opensearch.common.unit.TimeValue;
                );  
import static org.opensearch.action.search.SearchRequestStats.SEARCH_REQUEST_STATS_ENABLED_KEY;  
        GroupShardsIterator allAssignedShardsGrouped = state.routingTable().allAssignedShardsGrouped(indices, true);
        assertThat(stats.getScrollCount(), equalTo((long) numAssignedShards(index)));
}
import org.opensearch.script.ScriptType;
import org.apache.lucene.tests.util.LuceneTestCase;  
                assertThat(total.getQueryTimeInMillis(), greaterThan(0L));
        return Arrays.asList(
import java.util.Collections;  
/*
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(indicesStats.getTotal().getSearch().getTotal().getQueryTimeInMillis(), greaterThan(0L));  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
import org.opensearch.common.settings.Settings;
            }  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                assertThat(total.getQueryTimeInMillis(), equalTo(0L));
        final int numNodes = cluster().numDataNodes();
            if (rarely()) {
import static org.hamcrest.Matchers.greaterThan;
                numOfCoordinators += 1;  
        assertSearchResponse(searchResponse);
                    .get();  
                    total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTotal()
        SearchResponse searchResponse = client().prepareSearch()  
    public SearchStatsIT(Settings staticSettings) {
        }
import java.util.HashSet;
 * KIND, either express or implied.  See the License for the
    }
            }
        client().admin().indices().prepareRefresh(index).get();  
        assertThat(indicesStats.getTotal().getSearch().getTotal().getScrollCurrent(), equalTo((long) numAssignedShards(index)));
        createIndex(index);
        int numOfCoordinators = 0;  
@LuceneTestCase.SuppressCodecs("*")  
            expected += (long) Math.ceil(r.getShards()[s].getStats().getDocs().getCount() / size);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        );
    }  
            if (total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.QUERY.getName()).getTimeInMillis() > 0) {
                );
        assertAcked(
                refresh();
import static org.hamcrest.Matchers.nullValue;
                assertThat(total.getQueryCount(), greaterThan(0L));  
        indicesStats = client().admin().indices().prepareStats().get();
        }  
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
        super(staticSettings);
        refresh();  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        assertThat(indicesStats.getTotal().getSearch().getGroupStats().get("group1").getQueryCount(), greaterThan(0L));
            .get();
            client().prepareIndex("test2").setId(Integer.toString(i)).setSource("field", "value").get();  
 */
        for (int s = 0; s < numAssignedShards(index); s++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertThat(indicesStats.getTotal().getSearch().getOpenContexts(), equalTo(0L));
        GroupShardsIterator<ShardIterator> allAssignedShardsGrouped = state.routingTable().allAssignedShardsGrouped(indices, true);
        // clear all stats first
            client().prepareIndex("test1").setId(Integer.toString(i)).setSource("field", "value").get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                .prepareSearch()
import org.opensearch.cluster.routing.ShardIterator;
            Stats total = stat.getIndices().getSearch().getTotal();  
 * license agreements. See the NOTICE file distributed with
                .get();
        // refresh the stats now that scroll contexts are opened
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .setQuery(matchAllQuery())
        assertThat(num, greaterThan(0));  
                Map<?, ?> src = (Map) vars.get("_source");
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.QueryBuilders;  
                    total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTotal()
                assertEquals(
                    total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.EXPAND.getName()).getTotal()  
        assertThat(numOfCoordinators, greaterThan(0));
import java.util.Map;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, shardsIdx1).put(SETTING_NUMBER_OF_REPLICAS, 0)
        int num = 0;
 * not use this file except in compliance with the License.
                    iters,
    }
        stats = indicesStats.getTotal().getSearch().getTotal();  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        Stats stats = indicesStats.getTotal().getSearch().getTotal();
            }  
            prepareCreate("test2").setSettings(  
                    iters,  
                refresh();
/*  
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                assertEquals(
        ensureGreen();
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
 * this work for additional information regarding copyright
                    greaterThan(0L)
                    iters,
        for (int i = 0; i < iters; i++) {
                assertEquals(  
        for (int s = 0; s < numAssignedShards(index); s++) {  
import org.opensearch.cluster.routing.GroupShardsIterator;
                .setSize(100)  
        IndicesStatsResponse r = client().admin().indices().prepareStats(index).get();  
                if (routing.active()) {  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
                    total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTimeInMillis(),  
    }
    }  
        assertThat(numNodes, greaterThanOrEqualTo(2));
                    .setSource("field", "value")
        assertThat(indicesStats.getTotal().getSearch().getOpenContexts(), equalTo((long) numAssignedShards(index)));
        int docsTest1 = scaledRandomIntBetween(3 * shardsIdx1, 5 * shardsIdx1);
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances
import org.opensearch.script.Script;
            .get();  
        assertThat(stats.getScrollTimeInMillis(), greaterThan(0L));  
    private Set<String> nodeIdsWithIndex(String... indices) {  
        }
        assertThat(indicesStats.getTotal().getSearch().getTotal().getFetchTimeInMillis(), greaterThan(0L));
            )
        // create shards * docs number of docs and attempt to distribute them equally
            )
 *
/**
    @Override
                    nodes.add(routing.currentNodeId());
    }
import org.opensearch.script.MockScriptPlugin;  
import org.opensearch.plugins.Plugin;
        return nodes;  
        assertThat(indicesStats.getTotal().getSearch().getGroupStats(), nullValue());  
                    .setRouting(Integer.toString(s))
    }
        }
        Set<String> nodes = new HashSet<>();  
        while (true) {
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
    @ParametersFactory
