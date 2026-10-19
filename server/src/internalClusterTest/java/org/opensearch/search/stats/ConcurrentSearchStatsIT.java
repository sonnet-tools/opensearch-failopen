            NodesStatsAction.INSTANCE  
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),  
 */  
            refresh();  
                .build()
            expectedConcurrency,
package org.opensearch.search.stats;
            .build();
        client().prepareSearch(INDEX).execute().actionGet();  
                } catch (InterruptedException e) {
            .actionGet();
import org.opensearch.search.SearchService;  
        IndicesStatsResponse stats = builder.execute().actionGet();
        assertThat(stats.getTotal().search.getTotal().getConcurrentQueryTimeInMillis(), greaterThan(0L));  
                return true;
            .execute()
        }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.IndexMetadata;
            .execute()
        double expectedConcurrency = SEGMENT_SLICE_COUNT;
        assertEquals(  
            .put(super.indexSettings())
            .execute()
        stats = indicesStatsResponse.getIndices().get(INDEX);
        assertEquals(
            .cluster()
            .setSettings(Settings.builder().put("search.concurrent_segment_search.enabled", false))
        for (int i = 0; i < 4; i++) {
                    throw new RuntimeException(e);
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);
        ).setNodesIds().all();
        int NUM_SHARDS = randomIntBetween(1, 5);
        client().admin()
                .build()
            0  
            expectedConcurrency,
            .setTransientSettings(Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), 2))
            0
            .execute()  
        createIndex(
        client().prepareSearch(INDEX_1).execute().actionGet();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
            .execute()  
            client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("field", "value" + i).get();
    @Override
        return Settings.builder()  
            .prepareUpdateSettings(INDEX)  
            .prepareUpdateSettings()
            if (stats.getName().equals(ThreadPool.Names.INDEX_SEARCHER)) {  
        );
 * this file be licensed under the Apache-2.0 license or a
        client().admin()
        for (ThreadPoolStats.Stats stats : threadPoolStats) {
            return Collections.singletonMap(SCRIPT_NAME, params -> {
            stats.getTotal().search.getTotal().getConcurrentQueryTimeInMillis(),
import org.opensearch.script.ScriptType;
        client().prepareSearch(INDEX).execute().actionGet();
            .actionGet();
            INDEX_2,  
        indicesStatsResponse = client().admin().indices().prepareStats().execute().actionGet();
    public void testAvgConcurrencyIndexLevel() throws InterruptedException {  
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY, SEGMENT_SLICE_COUNT)
import org.opensearch.threadpool.ThreadPool;  
        assertEquals(
    public void testConcurrentQueryCount() throws Exception {
    private final int SEGMENT_SLICE_COUNT = 4;  
import static org.hamcrest.Matchers.greaterThan;  
        @SuppressForbidden(reason = "Sleeping to simulate slow task")
        expectedConcurrency = (SEGMENT_SLICE_COUNT + 1 + SEGMENT_SLICE_COUNT) / 3.0;
            false,  
        // Filter/Query cache is cleaned periodically, default is 60s, so make sure it runs often. Thread.sleep for 60s is bad  
        ensureGreen();
        static final String SCRIPT_NAME = "search_timeout";
            .build();
            client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("field", "value" + i).setRouting("0").get();
public class ConcurrentSearchStatsIT extends OpenSearchIntegTestCase {
        }
import org.opensearch.threadpool.ThreadPoolStats;
        expectedConcurrency = (SEGMENT_SLICE_COUNT + 1) / 2.0;  
        // Create index test1 with 4 segments  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        // Check that non-concurrent search requests do not affect the average concurrency  
        assertThat(stats.getTotal().search.getTotal().getQueryTimeInMillis(), greaterThan(0L));
        assertEquals(2 * NUM_SHARDS, stats.getTotal().search.getTotal().getConcurrentQueryCount());
        indicesStatsResponse = client().admin().indices().prepareStats().execute().actionGet();  
            0
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);  
        ensureGreen();  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)  
            client().prepareIndex(INDEX_1).setId(Integer.toString(i)).setSource("field", "value" + i).get();
        String INDEX_2 = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
 *
            .actionGet();  
            client().prepareIndex(INDEX_1).setId("2").setSource("foo", "baz"),  
        int NUM_SHARDS = 1;
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().prepareStats().execute().actionGet();
     */  
import java.util.Map;
        for (int i = 4; i < 8; i++) {
        forceMerge();
            refresh();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
                .build()  
        forceMerge();
        assertEquals(
import org.opensearch.common.settings.Settings;  
            refresh();
        client().prepareSearch(INDEX_1).execute().actionGet();
        ensureGreen();  
    protected Settings nodeSettings(int nodeOrdinal) {
        assertNotNull(stats);
import org.opensearch.indices.IndicesQueryCache;  
            .actionGet();  
            INDEX_2,  
        );  
            client().prepareIndex(INDEX_2).setId("2").setSource("foo", "baz")
                }  
    /**
            SEGMENT_SLICE_COUNT,  
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);
        String INDEX = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
            .prepareUpdateSettings(INDEX_1)
            Settings.builder()
        nodesStatsResponse = client().admin().cluster().prepareNodesStats().execute().actionGet();  
        int NUM_SHARDS = 2;
            INDEX,
        assertNotNull(stats);  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.indices.IndicesService;
        client().prepareSearch(INDEX_2).execute().actionGet();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import java.util.Collection;
        ThreadPoolStats threadPoolStats = nodesStatsResponse.getNodes().get(0).getThreadPool();  
        );  
        }
import org.opensearch.script.Script;
        assertEquals(expectedConcurrency, stats.getTotal().getSearch().getTotal().getConcurrentAvgSliceCount(), 0);  
                try {
        createIndex(
            client().prepareIndex(INDEX_2).setId("1").setSource("foo", "bar"),
            .execute()
        }
        IndexStats stats = indicesStatsResponse.getIndices().get(INDEX);  
    }  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING;
import org.opensearch.test.OpenSearchIntegTestCase;
        String INDEX = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);  
            .indices()  
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequestBuilder;
import org.opensearch.plugins.Plugin;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)  
        createIndex(  
            INDEX,
    }
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedDelayedPlugin.SCRIPT_NAME, Collections.emptyMap())))  
            Settings.builder()  
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);
        client().prepareSearch(INDEX_2).execute().actionGet();
            Settings.builder()  
        for (int i = 0; i < 4; i++) {
        );
     * Test average concurrency is correctly calculated across shard for the same index
        );
            expectedConcurrency,  
            client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("field", "value" + i).setRouting("1").get();  
     * Test average concurrency is correctly calculated across indices for the same node
        assertEquals(expectedConcurrency, stats.getTotal().getSearch().getTotal().getConcurrentAvgSliceCount(), 0);
            });
import org.opensearch.test.InternalSettingsPlugin;
        createIndex(
}
        client().prepareSearch(INDEX_1, INDEX_2)
            .execute()  
        for (int i = 0; i < 10; i++) {  
        createIndex(  
    public void testThreadPoolWaitTime() throws Exception {
            .indices()  
            .actionGet();  
        // Create 4 segments on each shard  
            .actionGet();
                .put(indexSettings())  
        client().prepareSearch(INDEX_1)  
        client().admin()
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().prepareNodesStats().execute().actionGet();
        refresh(); // ensure merged segments are searchable
                .put(indexSettings())
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        ensureGreen();
                .build()
    @Override
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        nodesStatsResponse = client().admin().cluster().prepareNodesStats().execute().actionGet();
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
        // Search with custom plugin to ensure that queryTime is significant
    }
            .cluster()  
    public static class ScriptedDelayedPlugin extends MockScriptPlugin {
        createIndex(
        client().prepareSearch(INDEX).execute().actionGet();
        @Override
            .actionGet();
        refresh(); // ensure merged segments are searchable  
        // Create second index test2 with 4 segments
            .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), false)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        for (int i = 0; i < 4; i++) {
        client().admin()
            .setTransientSettings(Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), 10))
        );  
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
    }
        );
            .actionGet();
        );  
        expectedConcurrency = (SEGMENT_SLICE_COUNT + 1 + SEGMENT_SLICE_COUNT + 1) / 4.0;  
            .indices()
        double expectedConcurrency = (SEGMENT_SLICE_COUNT * NUM_SHARDS) / (double) NUM_SHARDS;
                .put("search.concurrent_segment_search.enabled", false)  
    }
     */
        refresh();
        client().prepareSearch(INDEX_2).execute().actionGet();  
    }
            client().prepareIndex(INDEX_2).setId(Integer.toString(i)).setSource("field", "value" + i).get();  
        // Check that non-concurrent search requests do not affect the average concurrency
        NodesStatsRequestBuilder nodesStatsRequestBuilder = new NodesStatsRequestBuilder(
        );
            0
        forceMerge();  
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),
                    Thread.sleep(500);  
        expectedConcurrency = (SEGMENT_SLICE_COUNT * NUM_SHARDS + 1 * NUM_SHARDS) / (NUM_SHARDS * 2.0);  
import org.opensearch.index.IndexSettings;
import java.util.Collections;
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1ms")  
            INDEX_1,
            lessThan(stats.getTotal().search.getTotal().getQueryTimeInMillis())  
            Settings.builder()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
/*  
    @Override
        indexRandom(
            Settings.builder()
        client().prepareSearch(INDEX_2)
        assertEquals(1, nodesStatsResponse.getNodes().size(), 0);
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
        );
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),  
import org.opensearch.script.MockScriptPlugin;  
            refresh();
    public void testAvgConcurrencyNodeLevel() throws InterruptedException {
        assertEquals(4 * NUM_SHARDS, stats.getTotal().search.getTotal().getQueryCount());  
        client().admin()
            client().admin().cluster(),
 * SPDX-License-Identifier: Apache-2.0
            .put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true)  
        client().prepareSearch(INDEX).execute().actionGet();
            .setSettings(Settings.builder().put("search.concurrent_segment_search.enabled", false))
import java.util.Arrays;  
        int NUM_SHARDS = 1;
        String INDEX_1 = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);  
        assertEquals(
        ensureGreen();
            client().prepareIndex(INDEX_1).setId("1").setSource("foo", "bar"),
            expectedConcurrency,
        nodesStatsResponse = client().admin().cluster().prepareNodesStats().execute().actionGet();  
import static org.hamcrest.Matchers.lessThan;
        assertThat(
            .prepareUpdateSettings(INDEX_2)
                .put(indexSettings())
                .build()  
import java.util.function.Function;
                .put(indexSettings())
    }
        String INDEX_2 = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
            true,
                .put(indexSettings())
            INDEX_1,
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        String INDEX_1 = "test-" + randomAlphaOfLength(5).toLowerCase(Locale.ROOT);  
        }
            refresh();  
        return Settings.builder()
import org.opensearch.action.admin.indices.stats.IndexStats;
    public Settings indexSettings() {
        }  
                .build()  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
import org.opensearch.common.SuppressForbidden;
        );
        refresh(); // ensure merged segments are searchable  
        NodesStatsResponse nodesStatsResponse = nodesStatsRequestBuilder.execute().actionGet();
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),
            nodesStatsResponse.getNodes().get(0).getIndices().getSearch().getTotal().getConcurrentAvgSliceCount(),
            .execute()  
            .put(super.nodeSettings(nodeOrdinal))
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedDelayedPlugin.SCRIPT_NAME, Collections.emptyMap())))
    /**  
        stats = indicesStatsResponse.getIndices().get(INDEX);
            0
        client().prepareSearch(INDEX_1).execute().actionGet();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        );
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
                assertThat(stats.getWaitTime().micros(), greaterThan(0L));
            .prepareUpdateSettings()  
        }  
import java.util.Locale;  
        return Arrays.asList(ScriptedDelayedPlugin.class, InternalSettingsPlugin.class);
 * compatible open source license.
            }
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedDelayedPlugin.SCRIPT_NAME, Collections.emptyMap())))
    }
            Settings.builder()
                .put(indexSettings())  
            .setSettings(Settings.builder().put("search.concurrent_segment_search.enabled", false))
        assertNotNull(stats);
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
import org.opensearch.index.IndexModule;
        );
        assertEquals(expectedConcurrency, stats.getTotal().getSearch().getTotal().getConcurrentAvgSliceCount(), 0);
