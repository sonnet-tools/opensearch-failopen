        logger.debug("###### indices search stats: {}", indicesStats.getTotal().getSearch());
import org.opensearch.index.query.QueryBuilders;
        assertThat(indicesStats.getTotal().getSearch().getGroupStats().get("group1").getFetchCount(), greaterThan(0L));
        int docsTest2 = scaledRandomIntBetween(3 * shardsIdx2, 5 * shardsIdx2);
    protected int numAssignedShards(String... indices) {
 *
    }
        // THERE WILL BE AT LEAST 2 NODES HERE SO WE CAN WAIT FOR GREEN
                .setSize(100)
        for (int i = 0; i < docsTest1; i++) {
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 2)
        String index = "test1";
                assertThat(total.getQueryCount(), greaterThan(0L));
        assertThat(indicesStats.getTotal().getSearch().getTotal().getFetchCount(), greaterThan(0L));
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                break;
import static org.opensearch.action.search.SearchRequestStats.SEARCH_REQUEST_STATS_ENABLED_KEY;
                    .get();
 * Modifications Copyright OpenSearch Contributors. See
            if (total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.QUERY.getName()).getTimeInMillis() > 0) {
                );
        return nodes;
 * this work for additional information regarding copyright
        }
        ClusterState state = client().admin().cluster().prepareState().get().getState();
import static org.hamcrest.Matchers.equalTo;
        }
            }
        Stats stats = indicesStats.getTotal().getSearch().getTotal();
                    .setSource("field", "value")
                .setQuery(QueryBuilders.termQuery("field", "value"))
        final int shardsIdx1 = randomIntBetween(1, 10); // we make sure each node gets at least a single shard...
            prepareCreate("test2").setSettings(
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                refresh();
        // clear all stats first
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
        assertEquals(hits, docs * numAssignedShards(index));
        assertThat(indicesStats.getTotal().getSearch().getGroupStats().get("group1").getQueryTimeInMillis(), greaterThan(0L));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import java.util.Map;
import java.util.Set;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import static org.hamcrest.Matchers.notNullValue;
        final int numNodes = cluster().numDataNodes();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import org.opensearch.cluster.routing.GroupShardsIterator;
    }
 * under the License.
                .highlighter(new HighlightBuilder().field("field"))
        for (int i = 0; i < iters; i++) {
import java.util.HashSet;
                );
        client().admin()
 * The OpenSearch Contributors require contributions made to
                numOfCoordinators += 1;
        int docsTest1 = scaledRandomIntBetween(3 * shardsIdx1, 5 * shardsIdx1);
            .setSize(size)
import org.opensearch.script.Script;
        assertThat(indicesStats.getTotal().getSearch().getTotal().getFetchTimeInMillis(), greaterThan(0L));
        int numOfCoordinators = 0;
 * SPDX-License-Identifier: Apache-2.0
/*
        assertThat(indicesStats.getTotal().getSearch().getOpenContexts(), equalTo(0L));
            .setPersistentSettings(Settings.builder().put(SEARCH_REQUEST_STATS_ENABLED_KEY, true).build())
            )
 * KIND, either express or implied.  See the License for the
                assertEquals(
        assertThat(shardsIdx1 + shardsIdx2, equalTo(numAssignedShards("test1", "test2")));
        assertThat(indicesStats.getTotal().getSearch().getTotal().getQueryCount(), greaterThan(0L));
 * across scroll batches for sequential access. Different batches may run on different threads
        for (int s = 0; s < numAssignedShards(index); s++) {
        assertThat(indicesStats.getTotal().getSearch().getTotal().getQueryTimeInMillis(), greaterThan(0L));
/**
                    .setRouting(Integer.toString(s))
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                return src.get("field");
import java.util.function.Function;
            assertAllSuccessful(searchResponse);
                );
import java.util.Collection;
            }
        assertThat(indicesStats.getTotal().getSearch().getOpenContexts(), equalTo((long) numAssignedShards(index)));
            });
 * software distributed under the License is distributed on an
                assertThat(total.getQueryTimeInMillis(), equalTo(0L));
    public void testSimpleStats() throws Exception {
        return Arrays.asList(
import org.opensearch.script.MockScriptPlugin;
            .get();
        IndicesStatsResponse r = client().admin().indices().prepareStats(index).get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 *
            for (int i = 0; i < docs; i++) {
        SearchResponse searchResponse = client().prepareSearch()
 */
                refresh();
import java.util.Collections;
        assertThat(indicesStats.getTotal().getSearch().getGroupStats(), nullValue());
            .setScroll(TimeValue.timeValueMinutes(2))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        GroupShardsIterator allAssignedShardsGrouped = state.routingTable().allAssignedShardsGrouped(indices, true);
    protected int numberOfReplicas() {
        int size = scaledRandomIntBetween(1, docs);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public static class CustomScriptPlugin extends MockScriptPlugin {
        client().admin().indices().prepareStats().clear().get();
        // we do this so we have a lot of pages to scroll through
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
import org.opensearch.common.settings.Settings;
        return allAssignedShardsGrouped.size();
 *
                .addScriptField("script1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_source.field", Collections.emptyMap()))
        assertThat(numAssignedShards("test1", "test2"), greaterThanOrEqualTo(2));
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
        return 0;
            if (rarely()) {
        );
        );
                    iters,
        }
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
 */
@LuceneTestCase.SuppressCodecs("*")
        indicesStats = client().admin().indices().prepareStats().get();
/*
            )
        @Override
            }
        assertThat(stats.getQueryCount(), greaterThanOrEqualTo(expected));
        assertThat(indicesStats.getTotal().getSearch().getGroupStats().get("group1").getFetchTimeInMillis(), greaterThan(0L));
        IndicesStatsResponse indicesStats = client().admin().indices().prepareStats(index).get();
            }
            SearchResponse searchResponse = internalCluster().coordOnlyNodeClient()
/*
        clearScroll(searchResponse.getScrollId());
        indicesStats = client().admin().indices().prepareStats(index).get();
                assertEquals(
            .setQuery(matchAllQuery())
        // the number of queries executed is equal to at least the sum of number of pages in shard over all shards
        int num = 0;
            if (rarely()) {
        assertThat(indicesStats.getTotal().getSearch().getOpenContexts(), equalTo(0L));
        return Collections.singleton(CustomScriptPlugin.class);
import org.opensearch.common.unit.TimeValue;
        assertThat(num, greaterThan(0));
                    .setId(Integer.toString(s * docs + i))
            hits += searchResponse.getHits().getHits().length;
    }
        }
            .get();
        // refresh the stats now that scroll contexts are opened
                );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
        assertThat(indicesStats.getTotal().getSearch().getGroupStats().get("group1").getQueryCount(), greaterThan(0L));
                    total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.EXPAND.getName()).getTotal()
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.plugins.Plugin;
                assertThat(total.getQueryCount(), greaterThanOrEqualTo(0L));
import org.opensearch.cluster.routing.ShardRouting;
        );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
    }
 * ownership. Elasticsearch licenses this file to you under
        IndicesStatsResponse indicesStats = client().admin().indices().prepareStats().get();
            prepareCreate("test1").setSettings(
                }
                    iters,
            }
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        for (int i = 0; i < docsTest2; i++) {
        for (NodeStats stat : nodeStats.getNodes()) {
 *
        long expected = 0;
import static org.hamcrest.Matchers.greaterThan;
 * GitHub history for details.
}
            }
        }
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, shardsIdx1).put(SETTING_NUMBER_OF_REPLICAS, 0)
        // create shards * docs number of docs and attempt to distribute them equally
import org.opensearch.script.ScriptType;
import org.apache.lucene.tests.util.LuceneTestCase;
 * license agreements. See the NOTICE file distributed with
            client().prepareIndex("test2").setId(Integer.toString(i)).setSource("field", "value").get();
        }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        assertAcked(
        final int docs = scaledRandomIntBetween(20, 50);
        ensureGreen(index);
import org.opensearch.test.OpenSearchIntegTestCase;
                .get();
        ClusterState state = client().admin().cluster().prepareState().get().getState();
                if (routing.active()) {
 * Licensed to Elasticsearch under one or more contributor
 * specific language governing permissions and limitations
    public void testOpenContexts() {
            assertHitCount(searchResponse, docsTest1 + docsTest2);
        assertThat(indicesStats.getTotal().getSearch().getTotal().getScrollCurrent(), equalTo((long) numAssignedShards(index)));
            return Collections.singletonMap("_source.field", vars -> {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            }
        indicesStats = client().admin().indices().prepareStats().setGroups("group1").get();
            expected += (long) Math.ceil(r.getShards()[s].getStats().getDocs().getCount() / size);
                    nodes.add(routing.currentNodeId());
                num++;
        assertAcked(
    public static Collection<Object[]> parameters() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.cluster.ClusterState;
import java.util.Arrays;
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances
        for (int s = 0; s < numAssignedShards(index); s++) {
    private Set<String> nodeIdsWithIndex(String... indices) {
            .cluster()
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, shardsIdx2).put(SETTING_NUMBER_OF_REPLICAS, 0)
                    total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTotal()
        Set<String> nodes = new HashSet<>();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
 */
        }
        int iters = scaledRandomIntBetween(100, 150);
        super(staticSettings);
 * this file be licensed under the Apache-2.0 license or a
                assertThat(
                .setStats("group1", "group2")
import org.opensearch.action.search.SearchPhaseName;
                    iters,
 */
    }
    }
            .prepareUpdateSettings()
        // this distribution will not be perfect; each shard will have an integer multiple of docs (possibly zero)
public class SearchStatsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * that rejects this valid sequential cross-thread usage.
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } else {
        ensureGreen();
        GroupShardsIterator<ShardIterator> allAssignedShardsGrouped = state.routingTable().allAssignedShardsGrouped(indices, true);
        assertThat(numNodes, lessThanOrEqualTo(shardsIdx1 + shardsIdx2));
    @Override
        final int shardsIdx2 = Math.max(numNodes - shardsIdx1, randomIntBetween(1, 10));
            if (searchResponse.getHits().getHits().length == 0) {
        assertSearchResponse(searchResponse);
            for (ShardRouting routing : shardIterator) {
 * Unless required by applicable law or agreed to in writing,
        }
import org.opensearch.cluster.routing.ShardIterator;
                Map<?, ?> src = (Map) vars.get("_source");
    }
        while (true) {
        createIndex(index);
    @ParametersFactory
import org.opensearch.index.search.stats.SearchStats.Stats;
 * compatible open source license.
        assertThat(numNodes, greaterThanOrEqualTo(2));
    }
        for (ShardIterator shardIterator : allAssignedShardsGrouped) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertThat(numOfCoordinators, greaterThan(0));
            if (nodeIdsWithIndex.contains(stat.getNode().getId())) {
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.action.search.SearchResponse;
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            client().prepareIndex("test1").setId(Integer.toString(i)).setSource("field", "value").get();
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                    total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTimeInMillis(),
                    greaterThan(0L)
                .prepareSearch()
        stats = indicesStats.getTotal().getSearch().getTotal();
        assertThat(indicesStats.getTotal().getSearch().getGroupStats(), notNullValue());
                assertEquals(
        Set<String> nodeIdsWithIndex = nodeIdsWithIndex("test1", "test2");
            Stats total = stat.getIndices().getSearch().getTotal();
        assertThat(stats.getScrollCount(), equalTo((long) numAssignedShards(index)));
 * You may obtain a copy of the License at
package org.opensearch.search.stats;
        refresh();
                    total.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTotal()
        client().admin().indices().prepareRefresh(index).get();
        indicesStats = client().admin().indices().prepareStats().get();
                client().prepareIndex(index)
    @Override
    public SearchStatsIT(Settings staticSettings) {
                assertThat(total.getQueryTimeInMillis(), greaterThan(0L));
        assertThat(stats.getScrollTimeInMillis(), greaterThan(0L));
        int hits = 0;
