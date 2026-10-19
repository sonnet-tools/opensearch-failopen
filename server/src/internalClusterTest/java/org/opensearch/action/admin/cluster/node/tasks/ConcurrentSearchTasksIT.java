     * <p>
public class ConcurrentSearchTasksIT extends AbstractTasksIT {  
            .get(indexName)
                .build()
     * we should improve this test to use those methods.
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.common.settings.FeatureFlagSettings;
    }  
            Map<Long, List<ThreadResourceInfo>> threadStats = getThreadStats(SearchAction.NAME + "[*]", taskInfo.getTaskId());
    private static final int INDEX_SEARCHER_THREADS = 10;
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
            .actionGet()  
import org.opensearch.action.search.SearchAction;
        for (Setting builtInFlag : FeatureFlagSettings.BUILT_IN_FEATURE_FLAGS) {  
                                                         // we index 7 docs flushing between each to create new segments
            featureSettings.put(builtInFlag.getKey(), builtInFlag.getDefaultRaw(Settings.EMPTY));
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
            INDEX_NAME,  
            .getIndices()
            .getShards()[0].getSegments()
            // Concurrent search forks each slice of 5 segments to different thread (see please
import java.util.Map;  
    public void testConcurrentSearchTaskTracking() {
    protected Settings featureFlagSettings() {
        final String INDEX_NAME = "test";
        assertEquals(NUM_SHARDS, shardTasks.size()); // We should only have 1 shard search task per shard
package org.opensearch.action.admin.cluster.node.tasks;
        Settings.Builder featureSettings = Settings.builder();
            .build();
        }
            Settings.builder()
            .size();  
            .put("thread_pool.index_searcher.queue_size", INDEX_SEARCHER_THREADS)  
            .put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true)
 * Integration tests for task management API with Concurrent Segment Search
            .getShards()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
 * The OpenSearch Contributors require contributions made to  
     * the way concurrent search creates leaf slices from segments. Once more concurrency controls are introduced
 * The way the test framework bootstraps the test cluster makes it difficult to parameterize the feature flag.  
import org.opensearch.common.collect.Tuple;
    }
    /**  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            assertEquals(mainTaskInfo.getTaskId(), taskInfo.getParentTaskId());
 */  
            .segments(new IndicesSegmentsRequest(indexName))
        List<TaskInfo> mainTask = findEvents(SearchAction.NAME, Tuple::v1);  
/**  
        registerTaskManagerListeners(SearchAction.NAME + "[*]");  // shard task
            .indices()
import static org.hamcrest.Matchers.notNullValue;
            .put("thread_pool.index_searcher.size", INDEX_SEARCHER_THREADS)
    }  
            MatcherAssert.assertThat(taskInfo.getDescription().length(), greaterThan(0));
import org.opensearch.tasks.TaskInfo;
    @Override
 * compatible open source license.
import org.opensearch.common.settings.Settings;
        assertEquals(1, mainTask.size());
        return client().admin()  
        final int NUM_DOCS = 7;
}
import org.opensearch.index.query.QueryBuilders;  
        ensureGreen(INDEX_NAME); // Make sure all shards are allocated to catch replication tasks  
        registerTaskManagerListeners(SearchAction.NAME);  // coordinator task  
            // https://github.com/apache/lucene/issues/12498)  
 *
        for (TaskInfo taskInfo : shardTasks) {  
        final int NUM_SHARDS = 1;  
import static org.hamcrest.Matchers.greaterThan;  
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.search.SearchService;
    protected Settings nodeSettings(int nodeOrdinal) {
 * Once concurrent search is moved behind a cluster setting we can parameterize these tests behind the setting.
/*  
import java.util.List;
            MatcherAssert.assertThat(taskInfo.getParentTaskId(), notNullValue());
        return featureSettings.build();  
            assertEquals((int) Math.ceil(getSegmentCount(INDEX_NAME) / 5.0), threadStats.size());
        TaskInfo mainTaskInfo = mainTask.get(0);
        List<TaskInfo> shardTasks = findEvents(SearchAction.NAME + "[*]", Tuple::v1);
 */
        }
            .get(0)
    @Override  
        return Settings.builder()  
            // assert that all task descriptions have non-zero length  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Setting;  
    }
        indexDocumentsWithRefresh(INDEX_NAME, NUM_DOCS); // Concurrent search requires >5 segments or >250,000 docs to have concurrency, so
        assertSearchResponse(client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get());  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        createIndex(
        // the search operation should produce one coordinator task
     */  
        );
import org.hamcrest.MatcherAssert;  
     * Tests the number of threads that worked on a search task.
 * <p>
     * Currently, we try to control concurrency by creating an index with 7 segments and rely on  
    private int getSegmentCount(String indexName) {
 * SPDX-License-Identifier: Apache-2.0
