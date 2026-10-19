        forceMerge();
public class ConcurrentSearchStatsIT extends OpenSearchIntegTestCase {
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1ms")
import org.opensearch.common.SuppressForbidden;
        refresh(); // ensure merged segments are searchable
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedDelayedPlugin.SCRIPT_NAME, Collections.emptyMap())))
            expectedConcurrency,
            SEGMENT_SLICE_COUNT,
        assertEquals(
            .indices()
            lessThan(stats.getTotal().search.getTotal().getQueryTimeInMillis())
            INDEX_2,
            INDEX_1,
        nodesStatsResponse = client().admin().cluster().prepareNodesStats().execute().actionGet();
import org.opensearch.script.MockScriptPlugin;
                .put(indexSettings())
            INDEX_1,
            }
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),
    public static class ScriptedDelayedPlugin extends MockScriptPlugin {
            .build();
            INDEX,
        @Override
            .prepareUpdateSettings()
import org.opensearch.script.Script;
        );
        String INDEX_2 = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
            INDEX_2,
        IndexStats stats = indicesStatsResponse.getIndices().get(INDEX);
        expectedConcurrency = (SEGMENT_SLICE_COUNT + 1 + SEGMENT_SLICE_COUNT + 1) / 4.0;
        assertThat(stats.getTotal().search.getTotal().getQueryTimeInMillis(), greaterThan(0L));
            .cluster()
import java.util.Collections;
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().prepareNodesStats().execute().actionGet();
package org.opensearch.search.stats;
            0
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);
        double expectedConcurrency = SEGMENT_SLICE_COUNT;
            .actionGet();
            Settings.builder()
    public void testAvgConcurrencyNodeLevel() throws InterruptedException {
        createIndex(
                try {
    @Override
        createIndex(
            .actionGet();
        assertEquals(
            .prepareUpdateSettings()
                .build()
    }
        client().admin()
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
import static org.hamcrest.Matchers.greaterThan;
    }
    @Override
    @Override
     * Test average concurrency is correctly calculated across indices for the same node
        String INDEX = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
        assertEquals(
        client().prepareSearch(INDEX).execute().actionGet();
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedDelayedPlugin.SCRIPT_NAME, Collections.emptyMap())))
        client().prepareSearch(INDEX).execute().actionGet();
import java.util.Arrays;
            .execute()
        client().prepareSearch(INDEX).execute().actionGet();
        expectedConcurrency = (SEGMENT_SLICE_COUNT + 1) / 2.0;
        );
            .setTransientSettings(Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), 2))
    }
        client().prepareSearch(INDEX_2)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            Settings.builder()
        client().prepareSearch(INDEX_1).execute().actionGet();
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();
                .put(indexSettings())
        static final String SCRIPT_NAME = "search_timeout";
        assertNotNull(stats);
        assertNotNull(stats);
                return true;
            .setSettings(Settings.builder().put("search.concurrent_segment_search.enabled", false))
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        client().admin()
            client().prepareIndex(INDEX_2).setId("2").setSource("foo", "baz")
        );
        assertThat(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        nodesStatsResponse = client().admin().cluster().prepareNodesStats().execute().actionGet();
            client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("field", "value" + i).get();
    protected Settings nodeSettings(int nodeOrdinal) {
        assertEquals(expectedConcurrency, stats.getTotal().getSearch().getTotal().getConcurrentAvgSliceCount(), 0);
                } catch (InterruptedException e) {
            .put(super.indexSettings())
    public Settings indexSettings() {
import org.opensearch.search.SearchService;
        // Create 4 segments on each shard
            .actionGet();
            .execute()
import org.opensearch.index.IndexSettings;
            Settings.builder()
        return Settings.builder()
    }
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
import java.util.Locale;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
            refresh();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
 *
            client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("field", "value" + i).setRouting("1").get();
        NodesStatsRequestBuilder nodesStatsRequestBuilder = new NodesStatsRequestBuilder(
 * SPDX-License-Identifier: Apache-2.0
        );
            Settings.builder()
                .build()
        client().prepareSearch(INDEX_1).execute().actionGet();
            Settings.builder()
            return Collections.singletonMap(SCRIPT_NAME, params -> {
            .execute()
        for (int i = 0; i < 4; i++) {
import org.opensearch.test.InternalSettingsPlugin;
            INDEX,
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING;
        @SuppressForbidden(reason = "Sleeping to simulate slow task")
        client().prepareSearch(INDEX_1).execute().actionGet();
        client().admin()
            Settings.builder()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        assertEquals(expectedConcurrency, stats.getTotal().getSearch().getTotal().getConcurrentAvgSliceCount(), 0);
            });
                .build()
    public void testThreadPoolWaitTime() throws Exception {
    }
            stats.getTotal().search.getTotal().getConcurrentQueryTimeInMillis(),
    }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequestBuilder;
        ensureGreen();
        for (ThreadPoolStats.Stats stats : threadPoolStats) {
        assertNotNull(stats);
    }
        // Create second index test2 with 4 segments
                .build()
                .build()
        }
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedDelayedPlugin.SCRIPT_NAME, Collections.emptyMap())))
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
/*
import org.opensearch.script.ScriptType;
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
     * Test average concurrency is correctly calculated across shard for the same index
                assertThat(stats.getWaitTime().micros(), greaterThan(0L));
import org.opensearch.test.OpenSearchIntegTestCase;
        IndicesStatsResponse stats = builder.execute().actionGet();
        );
            .execute()
            .actionGet();
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
        String INDEX_1 = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
            .put(super.nodeSettings(nodeOrdinal))
        client().admin()
            .actionGet();
        );
        refresh(); // ensure merged segments are searchable
        for (int i = 0; i < 4; i++) {
import java.util.Collection;
                }
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY, SEGMENT_SLICE_COUNT)
        expectedConcurrency = (SEGMENT_SLICE_COUNT * NUM_SHARDS + 1 * NUM_SHARDS) / (NUM_SHARDS * 2.0);
                .put(indexSettings())
            .execute()
            .prepareUpdateSettings(INDEX)
        }
        expectedConcurrency = (SEGMENT_SLICE_COUNT + 1 + SEGMENT_SLICE_COUNT) / 3.0;
import static org.hamcrest.Matchers.lessThan;
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),
import org.opensearch.index.IndexModule;
            refresh();
            .indices()
        stats = indicesStatsResponse.getIndices().get(INDEX);
        client().prepareSearch(INDEX).execute().actionGet();
        // Create index test1 with 4 segments
                    Thread.sleep(500);
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < 4; i++) {
    public void testAvgConcurrencyIndexLevel() throws InterruptedException {
    }
        refresh();
        ThreadPoolStats threadPoolStats = nodesStatsResponse.getNodes().get(0).getThreadPool();
            client().prepareIndex(INDEX_1).setId(Integer.toString(i)).setSource("field", "value" + i).get();
        client().prepareSearch(INDEX_1, INDEX_2)
            0
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),
            .actionGet();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(2 * NUM_SHARDS, stats.getTotal().search.getTotal().getConcurrentQueryCount());
            client().prepareIndex(INDEX_2).setId("1").setSource("foo", "bar"),
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("field", "value" + i).setRouting("0").get();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true)
        // Filter/Query cache is cleaned periodically, default is 60s, so make sure it runs often. Thread.sleep for 60s is bad
            .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), false)
        assertEquals(expectedConcurrency, stats.getTotal().getSearch().getTotal().getConcurrentAvgSliceCount(), 0);
        return Arrays.asList(ScriptedDelayedPlugin.class, InternalSettingsPlugin.class);
            .execute()
        NodesStatsResponse nodesStatsResponse = nodesStatsRequestBuilder.execute().actionGet();
        double expectedConcurrency = (SEGMENT_SLICE_COUNT * NUM_SHARDS) / (double) NUM_SHARDS;
        client().admin()
        createIndex(
        indicesStatsResponse = client().admin().indices().prepareStats().execute().actionGet();
        createIndex(
                .put(indexSettings())
        }
                .put(indexSettings())
        int NUM_SHARDS = 2;
import java.util.function.Function;
        // Check that non-concurrent search requests do not affect the average concurrency
            client().prepareIndex(INDEX_1).setId("1").setSource("foo", "bar"),
        indicesStatsResponse = client().admin().indices().prepareStats().execute().actionGet();
        assertThat(stats.getTotal().search.getTotal().getConcurrentQueryTimeInMillis(), greaterThan(0L));
            .cluster()
        int NUM_SHARDS = 1;
        assertEquals(
                    throw new RuntimeException(e);
        );
        );
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        indexRandom(
            NodesStatsAction.INSTANCE
            .execute()
}
        );
import org.opensearch.cluster.metadata.IndexMetadata;
            .indices()
        ensureGreen();
        );
        }
            .setSettings(Settings.builder().put("search.concurrent_segment_search.enabled", false))
        String INDEX_1 = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
        client().prepareSearch(INDEX_1)
            .build();
import org.opensearch.indices.IndicesService;
                .put("search.concurrent_segment_search.enabled", false)
            client().admin().cluster(),
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .prepareUpdateSettings(INDEX_1)
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
            false,
        String INDEX_2 = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
    /**
                .put(indexSettings())
            expectedConcurrency,
        }
import org.opensearch.indices.IndicesQueryCache;
        refresh(); // ensure merged segments are searchable
        createIndex(
        int NUM_SHARDS = 1;
        return Settings.builder()
            .prepareUpdateSettings(INDEX_2)
        ).setNodesIds().all();
 * The OpenSearch Contributors require contributions made to
            .execute()
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().prepareStats().execute().actionGet();
        int NUM_SHARDS = randomIntBetween(1, 5);
        );
        }
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
            expectedConcurrency,
            client().prepareIndex(INDEX_1).setId("2").setSource("foo", "baz"),
        assertEquals(4 * NUM_SHARDS, stats.getTotal().search.getTotal().getQueryCount());
        ensureGreen();
            expectedConcurrency,
                .build()
        for (int i = 4; i < 8; i++) {
import org.opensearch.threadpool.ThreadPoolStats;
import org.opensearch.threadpool.ThreadPool;
            if (stats.getName().equals(ThreadPool.Names.INDEX_SEARCHER)) {
            .setSettings(Settings.builder().put("search.concurrent_segment_search.enabled", false))
            refresh();
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),
        for (int i = 0; i < 10; i++) {
            0
    public void testConcurrentQueryCount() throws Exception {
        String INDEX = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
        assertEquals(
import java.util.Map;
        ensureGreen();
        nodesStatsResponse = client().admin().cluster().prepareNodesStats().execute().actionGet();
            .setTransientSettings(Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), 10))
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            0
            refresh();
        ensureGreen();
     */
 * compatible open source license.
        createIndex(
            client().prepareIndex(INDEX_2).setId(Integer.toString(i)).setSource("field", "value" + i).get();
 */
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .actionGet();
import org.opensearch.plugins.Plugin;
            .actionGet();
        client().prepareSearch(INDEX_2).execute().actionGet();
        );
        client().prepareSearch(INDEX_2).execute().actionGet();
        // Search with custom plugin to ensure that queryTime is significant
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
import org.opensearch.action.admin.indices.stats.IndexStats;
            refresh();
            0
        forceMerge();
    private final int SEGMENT_SLICE_COUNT = 4;
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),
     */
    /**
        stats = indicesStatsResponse.getIndices().get(INDEX);
        client().prepareSearch(INDEX_2).execute().actionGet();
        }
            true,
        forceMerge();
        );
import org.opensearch.common.settings.Settings;
        // Check that non-concurrent search requests do not affect the average concurrency
