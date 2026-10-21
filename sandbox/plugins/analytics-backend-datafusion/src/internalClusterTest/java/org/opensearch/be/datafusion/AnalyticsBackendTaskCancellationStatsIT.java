        assertNotNull(analyticsShardTask.get("current_count_post_cancel"));
        SearchResponse searchResponse = client().prepareSearch(indexName).setSize(5).get();
        assertNotNull("analytics_search_shard_task should be present", taskCancellation.get("analytics_search_shard_task"));
import java.util.Map;
        NodesStatsResponse nodesStatsResponse = client().admin()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            ).setMapping("value", "type=integer")
    @SuppressWarnings("unchecked")
        nodeStats.getTaskCancellationStats().toXContent(builder, ToXContent.EMPTY_PARAMS);
        indexRandom(true, docs);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
            .nodesStats(new NodesStatsRequest().addMetric("task_cancellation"))
        assertNotNull("analytics_search_task key should exist", analyticsSearchTask);
            .actionGet();
import java.util.Collection;
import org.opensearch.core.xcontent.XContentBuilder;
        NodesStatsResponse nodesStatsResponse = client().admin()
            .actionGet();
        Map<String, Object> taskCancellation = (Map<String, Object>) statsMap.get("task_cancellation");
        assertNotNull("analytics_search_task should be present", taskCancellation.get("analytics_search_task"));
    }
import org.opensearch.core.xcontent.ToXContent;
            ).setMapping("status", "type=integer", "message", "type=text")
        return List.of(
        builder.startObject();
            Version.CURRENT,
            false
        Map<String, Object> taskCancellation = (Map<String, Object>) statsMap.get("task_cancellation");
    public void testStatsSerializedInXContent() throws Exception {
                    .put("index.pluggable.dataformat", "composite")
import org.opensearch.parquet.ParquetDataFormatPlugin;
        client().prepareSearch(indexName).setSize(1).get();
                    .put("index.number_of_shards", 1)
import org.opensearch.composite.CompositeDataFormatPlugin;
        assertFalse(nodesStatsResponse.getNodes().isEmpty());
import org.opensearch.Version;
            extendedPlugins,
        return Settings.builder()
            "NA",
import java.util.Collections;
 * Integration test validating that analytics backend task cancellation stats
        String indexName = "test-xcontent-index";
        Map<String, Object> analyticsSearchTask = (Map<String, Object>) taskCancellation.get("analytics_search_task");
        NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        IndexRequestBuilder[] docs = new IndexRequestBuilder[10];
import org.opensearch.plugins.PluginInfo;
    public void testNativeMemoryStatsAvailable() throws Exception {
        assertThat(nodeStats.getAnalyticsBackendNativeMemoryStats().getResidentBytes(), greaterThanOrEqualTo(0L));
import org.opensearch.common.settings.Settings;
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            .cluster()
package org.opensearch.be.datafusion;
import org.opensearch.plugins.Plugin;
        assertAcked(
        NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);
 */
 * compatible open source license.
            pluginClass.getName(),
    public void testTaskCancellationStatsAvailableAfterSearch() throws Exception {
        );
                    .put("index.number_of_shards", 1)
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
/**
        return new PluginInfo(
        NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
                    .put("index.pluggable.dataformat.enabled", true)
        return List.of(FlightStreamPlugin.class, CompositeDataFormatPlugin.class, LucenePlugin.class);
        TaskCancellationStats taskCancellationStats = nodeStats.getTaskCancellationStats();
            .build();
        assertNotNull("task_cancellation key should exist in XContent", taskCancellation);
    @Override
        NodesStatsResponse nodesStatsResponse = client().admin()
 * this file be licensed under the Apache-2.0 license or a
 */
    }
        taskCancellationStats.toXContent(xBuilder, ToXContent.EMPTY_PARAMS);
    }
    }
                Settings.builder()
        assertAcked(
        assertNotNull("task_cancellation stats should be present", taskCancellationStats);
/*
            classpathPlugin(ParquetDataFormatPlugin.class, Collections.emptyList()),
        String indexName = "test-stats-index";
 * The OpenSearch Contributors require contributions made to
        Map<String, Object> statsMap = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), false);
            pluginClass.getName(),
            .cluster()
    }
        builder.endObject();
        XContentBuilder xBuilder = JsonXContent.contentBuilder();
        );
            .nodesStats(new NodesStatsRequest().addMetric("native_memory"))
        assertNotNull(analyticsSearchTask.get("current_count_post_cancel"));
    @Override
        assertNotNull("task_cancellation key should exist", taskCancellation);
            "classpath plugin",
    protected Collection<PluginInfo> additionalNodePlugins() {
                Settings.builder()
        Map<String, Object> statsMap = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), xBuilder.toString(), false);
        // Verify native stats are present via XContent serialization (getNativeStats() is protected)
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
 * are correctly reported through the _nodes/stats API when the DataFusion plugin is loaded.
import org.opensearch.action.search.SearchResponse;
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    .put("index.number_of_replicas", 0)
        assertThat(nodeStats.getAnalyticsBackendNativeMemoryStats().getAllocatedBytes(), greaterThanOrEqualTo(0L));
    @Override
            "1.8",
        }
import java.util.List;
public class AnalyticsBackendTaskCancellationStatsIT extends OpenSearchIntegTestCase {
            .actionGet();
        assertNotNull(analyticsSearchTask.get("total_count_post_cancel"));
}
import org.opensearch.common.util.FeatureFlags;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        Map<String, Object> analyticsShardTask = (Map<String, Object>) taskCancellation.get("analytics_search_shard_task");
 *
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.common.xcontent.json.JsonXContent;
            .put(super.nodeSettings(nodeOrdinal))
        refresh(indexName);
        assertNotNull(searchResponse.getHits());
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat("native_memory stats should be present", nodeStats.getAnalyticsBackendNativeMemoryStats(), notNullValue());
        xBuilder.startObject();
            docs[i] = client().prepareIndex(indexName).setSource("status", 200 + (i % 5), "message", "test message " + i);
        assertFalse(nodesStatsResponse.getNodes().isEmpty());
        assertNotNull(analyticsShardTask.get("total_count_post_cancel"));
            .cluster()
import org.opensearch.analytics.AnalyticsPlugin;
    }
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);
    }
import org.opensearch.be.lucene.LucenePlugin;
import org.opensearch.tasks.TaskCancellationStats;
        for (int i = 0; i < 10; i++) {
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            .nodesStats(new NodesStatsRequest().addMetric("task_cancellation"))
 * SPDX-License-Identifier: Apache-2.0
            prepareCreate(indexName).setSettings(
                    .put("index.pluggable.dataformat", "composite")
        xBuilder.endObject();
        refresh(indexName);
        @SuppressWarnings("unchecked")
        );
                    .put("index.pluggable.dataformat.enabled", true)
            prepareCreate(indexName).setSettings(
            null,
        ensureGreen(indexName);
import org.opensearch.action.index.IndexRequestBuilder;
        client().prepareIndex(indexName).setSource("value", 42).get();
        XContentBuilder builder = JsonXContent.contentBuilder();
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
import static org.hamcrest.Matchers.notNullValue;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        assertNotNull("analytics_search_shard_task key should exist", analyticsShardTask);
                    .put("index.number_of_replicas", 0)
