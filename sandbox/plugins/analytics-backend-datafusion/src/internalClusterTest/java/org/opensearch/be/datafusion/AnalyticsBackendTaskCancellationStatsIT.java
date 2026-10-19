        assertThat("native_memory stats should be present", nodeStats.getAnalyticsBackendNativeMemoryStats(), notNullValue());
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
        assertNotNull("task_cancellation key should exist in XContent", taskCancellation);  
import org.opensearch.action.index.IndexRequestBuilder;
        assertNotNull("task_cancellation stats should be present", taskCancellationStats);  
            .actionGet();
                    .put("index.pluggable.dataformat", "composite")  
                    .put("index.number_of_replicas", 0)
            "classpath plugin",  
                    .put("index.number_of_shards", 1)
            Version.CURRENT,
            ).setMapping("value", "type=integer")
        IndexRequestBuilder[] docs = new IndexRequestBuilder[10];
        NodesStatsResponse nodesStatsResponse = client().admin()
            "1.8",  
        builder.startObject();
        xBuilder.startObject();
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                Settings.builder()
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
            extendedPlugins,  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    protected Settings nodeSettings(int nodeOrdinal) {  
        assertNotNull("analytics_search_shard_task key should exist", analyticsShardTask);
        NodesStatsResponse nodesStatsResponse = client().admin()
}  
import org.opensearch.core.xcontent.XContentBuilder;
        TaskCancellationStats taskCancellationStats = nodeStats.getTaskCancellationStats();
 */  
                    .put("index.pluggable.dataformat.enabled", true)  
        assertNotNull(searchResponse.getHits());
                    .put("index.number_of_replicas", 0)
import org.opensearch.common.xcontent.XContentHelper;  
            .nodesStats(new NodesStatsRequest().addMetric("native_memory"))  
            prepareCreate(indexName).setSettings(
        NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);
            pluginClass.getName(),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    @Override
        Map<String, Object> statsMap = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), xBuilder.toString(), false);
            .cluster()
import org.opensearch.tasks.TaskCancellationStats;  
        builder.endObject();
        xBuilder.endObject();  
        client().prepareSearch(indexName).setSize(1).get();
            .actionGet();
            false
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.action.search.SearchResponse;  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
        assertNotNull(analyticsSearchTask.get("current_count_post_cancel"));
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        refresh(indexName);  
        return List.of(FlightStreamPlugin.class, CompositeDataFormatPlugin.class, LucenePlugin.class);  
        client().prepareIndex(indexName).setSource("value", 42).get();
        refresh(indexName);
            "NA",
            .actionGet();
        Map<String, Object> taskCancellation = (Map<String, Object>) statsMap.get("task_cancellation");  
/**  
        String indexName = "test-stats-index";
            ).setMapping("status", "type=integer", "message", "type=text")
        XContentBuilder builder = JsonXContent.contentBuilder();
        assertThat(nodeStats.getAnalyticsBackendNativeMemoryStats().getResidentBytes(), greaterThanOrEqualTo(0L));
                    .put("index.number_of_shards", 1)  
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);
            .cluster()
        Map<String, Object> analyticsSearchTask = (Map<String, Object>) taskCancellation.get("analytics_search_task");
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> analyticsShardTask = (Map<String, Object>) taskCancellation.get("analytics_search_shard_task");
import org.opensearch.common.xcontent.json.JsonXContent;
        Map<String, Object> taskCancellation = (Map<String, Object>) statsMap.get("task_cancellation");
    }  
import org.opensearch.plugins.PluginInfo;
            pluginClass.getName(),
    }
        assertNotNull("task_cancellation key should exist", taskCancellation);
    @Override  
import org.opensearch.Version;
import java.util.Map;  
    }
        Map<String, Object> statsMap = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), false);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
 * are correctly reported through the _nodes/stats API when the DataFusion plugin is loaded.
package org.opensearch.be.datafusion;
        assertFalse(nodesStatsResponse.getNodes().isEmpty());  
import java.util.Collections;
        assertNotNull("analytics_search_task should be present", taskCancellation.get("analytics_search_task"));
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
        assertNotNull("analytics_search_shard_task should be present", taskCancellation.get("analytics_search_shard_task"));  
    }
    protected Collection<PluginInfo> additionalNodePlugins() {
        nodeStats.getTaskCancellationStats().toXContent(builder, ToXContent.EMPTY_PARAMS);  
    public void testNativeMemoryStatsAvailable() throws Exception {  
 * Integration test validating that analytics backend task cancellation stats
        XContentBuilder xBuilder = JsonXContent.contentBuilder();  
        String indexName = "test-xcontent-index";  
            docs[i] = client().prepareIndex(indexName).setSource("status", 200 + (i % 5), "message", "test message " + i);  
import org.opensearch.composite.CompositeDataFormatPlugin;
import java.util.List;
        NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);  
 *
/*  
        assertThat(nodeStats.getAnalyticsBackendNativeMemoryStats().getAllocatedBytes(), greaterThanOrEqualTo(0L));  
        assertAcked(  
        assertNotNull(analyticsShardTask.get("total_count_post_cancel"));
        indexRandom(true, docs);
        }
                Settings.builder()  
    }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.core.xcontent.ToXContent;
        @SuppressWarnings("unchecked")
            classpathPlugin(ParquetDataFormatPlugin.class, Collections.emptyList()),
    public void testTaskCancellationStatsAvailableAfterSearch() throws Exception {
        assertFalse(nodesStatsResponse.getNodes().isEmpty());  
 * compatible open source license.
                    .put("index.pluggable.dataformat", "composite")
            .nodesStats(new NodesStatsRequest().addMetric("task_cancellation"))  
            .cluster()
import org.opensearch.analytics.AnalyticsPlugin;
        assertNotNull("analytics_search_task key should exist", analyticsSearchTask);  
import java.util.Collection;  
        taskCancellationStats.toXContent(xBuilder, ToXContent.EMPTY_PARAMS);
import static org.hamcrest.Matchers.notNullValue;
    public void testStatsSerializedInXContent() throws Exception {
        );
        for (int i = 0; i < 10; i++) {
        assertAcked(
        );  
import org.opensearch.test.OpenSearchIntegTestCase;
        NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);
            .nodesStats(new NodesStatsRequest().addMetric("task_cancellation"))  
            null,
        SearchResponse searchResponse = client().prepareSearch(indexName).setSize(5).get();  
import org.opensearch.plugins.Plugin;
    @Override
        return new PluginInfo(
        NodesStatsResponse nodesStatsResponse = client().admin()
        assertNotNull(analyticsSearchTask.get("total_count_post_cancel"));
        // Verify native stats are present via XContent serialization (getNativeStats() is protected)
public class AnalyticsBackendTaskCancellationStatsIT extends OpenSearchIntegTestCase {
        return Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull(analyticsShardTask.get("current_count_post_cancel"));  
        return List.of(
        );  
    }
 */  
import org.opensearch.be.lucene.LucenePlugin;  
            prepareCreate(indexName).setSettings(
                    .put("index.pluggable.dataformat.enabled", true)
    @SuppressWarnings("unchecked")
        );
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
        ensureGreen(indexName);  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            .build();
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.parquet.ParquetDataFormatPlugin;  
