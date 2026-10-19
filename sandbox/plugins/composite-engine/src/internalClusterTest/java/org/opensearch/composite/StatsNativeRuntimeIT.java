    }  
     * After a force_merge runs, the parquet node-stats endpoint must include a  
                ((Number) rayon.get("merge_tasks_in_flight")).longValue()  
            for (Map.Entry<String, Object> e : shards.entrySet()) {  
            assertTrue("node entry must contain native_runtime block", nodeStats.containsKey("native_runtime"));  
                }
            assertTrue("response must have nodes block", resp.containsKey("nodes"));
}
            Map<String, Object> indexBlock = (Map<String, Object>) indices.get(idx);  
 * Verifies that rayon + tokio runtime metrics are collected and surfaced after a merge  
            indexDocs(idx, 30, batch * 30);
            assertNotNull("rayon merge_tasks_in_flight derived field present", rayon.get("merge_tasks_in_flight"));
        assertBusy(() -> {  
            assertEquals(
     * non-empty native_runtime block with rayon + tokio metrics.
        for (int batch = 0; batch < 5; batch++) {
/*  
            // — new rayon counters + derived fields  
                "rayon merge_tasks_panicked must be 0 in happy path",
            );  
            indexDocs(idx, 40, batch * 40);  
 *
            );
    @SuppressWarnings("unchecked")  
            assertNotNull("tokio blocking_queue_depth field present", tokio.get("blocking_queue_depth"));  
 * compatible open source license.
            assertNotNull("tokio local_queue_depth_total field present", tokio.get("local_queue_depth_total"));
 *
import java.util.concurrent.TimeUnit;
 * operation runs, but never appear at shard level or in cluster-aggregate /{idx}/_stats.
 * The OpenSearch Contributors require contributions made to  
            assertTrue("native_runtime must contain parquet_merge block", nativeRuntime.containsKey("parquet_merge"));  
            Map<String, Object> nativeRuntime = (Map<String, Object>) nodeStats.get("native_runtime");
            assertTrue("rayon merge_tasks_started must be >= 1", ((Number) rayon.get("merge_tasks_started")).longValue() >= 1);
        forceMerge(idx, 1);
/**
import java.util.Map;
                "rayon merge_tasks_in_flight must be 0 after merges complete",
            assertTrue(  
    public void testNativeRuntimeAbsentAtShardLevel() throws Exception {  
                for (Map<String, Object> copy : copies) {
            assertFalse("nodes block must not be empty", nodes.isEmpty());  
            assertTrue("rayon merge_tasks_queue_depth must be >= 0", ((Number) rayon.get("merge_tasks_queue_depth")).longValue() >= 0);
        createCompositeIndex(idx, true);
            assertTrue("native_runtime must contain parquet_io block", nativeRuntime.containsKey("parquet_io"));
     * The native_runtime block must NOT appear in shard-level entries either.  
        createCompositeIndex(idx, true);
        for (int batch = 0; batch < 3; batch++) {  
            assertFalse("index-level response must NOT have native_runtime block", indexBlock.containsKey("native_runtime"));
                java.util.List<Map<String, Object>> copies = (java.util.List<Map<String, Object>>) e.getValue();
            Map<String, Object> shards = (Map<String, Object>) indexBlock.get("shards");
     * The native_runtime block must NOT appear in the cluster-aggregate /{idx}/_stats response.  
        String idx = "native-runtime-absent-idx";
            assertNotNull("tokio overflow_count_total field present", tokio.get("overflow_count_total"));  
            refreshIndex(idx);
package org.opensearch.composite;
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        }
     */
            );
public class StatsNativeRuntimeIT extends BaseStatsIT {  
    @SuppressWarnings("unchecked")
        }, 10, TimeUnit.SECONDS);
        assertBusy(() -> {  
    @SuppressWarnings("unchecked")
     */
 * this file be licensed under the Apache-2.0 license or a
    }
                ((Number) rayon.get("merge_tasks_completed")).longValue() >= 1
            indexDocs(idx, 30, batch * 30);
        forceMerge(idx, 1);
     */
    /**
            assertTrue("index block must contain shards", indexBlock.containsKey("shards"));
            }
                "rayon merge_tasks_completed must be >= 1 after successful merge",
            refreshIndex(idx);
    public void testNativeRuntimeStatsAppearAtNodeLevel() throws Exception {
            // — new tokio fields
    }  
        createCompositeIndex(idx, true);  
            Map<String, Object> nodeStats = (Map<String, Object>) nodes.values().iterator().next();
            refreshIndex(idx);
            Map<String, Object> idxResp = parquetIndexStats(idx);
                "rayon merge_tasks_submitted must be >= 1 after force_merge",  
                ((Number) rayon.get("merge_tasks_submitted")).longValue() >= 1
            Map<String, Object> indices = (Map<String, Object>) shardResp.get("indices");
        }, 30, TimeUnit.SECONDS);
            assertTrue("tokio polls_count_total must be > 0 after merge IO", ((Number) tokio.get("polls_count_total")).longValue() > 0);
            assertNotNull("rayon merge_tasks_queue_depth derived field present", rayon.get("merge_tasks_queue_depth"));  
            assertEquals(  
                    assertFalse("shard-level entry must NOT have native_runtime block", copy.containsKey("native_runtime"));  
            assertEquals("rayon merge_tasks_failed must be 0 in happy path", 0L, ((Number) rayon.get("merge_tasks_failed")).longValue());
        }, 10, TimeUnit.SECONDS);  
 * @opensearch.experimental  
 * SPDX-License-Identifier: Apache-2.0
            assertNotNull("tokio polls_count_total field present", tokio.get("polls_count_total"));
                ((Number) tokio.get("num_workers")).longValue() > 0  
            Map<String, Object> indexBlock = (Map<String, Object>) indices.get(idx);  
        assertBusy(() -> {
        forceMerge(idx, 1);  
 * Integration tests for the parquet native_runtime stats block at the node-level endpoint.
            Map<String, Object> nodes = (Map<String, Object>) resp.get("nodes");
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 */
            Map<String, Object> tokio = (Map<String, Object>) nativeRuntime.get("parquet_io");  
                0L,  
            );
            Map<String, Object> shardResp = parquetIndexStats(idx, "level", "shards");
        String idx = "native-runtime-idx";
    /**
    public void testNativeRuntimeAbsentAtIndexLevel() throws Exception {  
        }  
        }  
            assertTrue(
 */  
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)
                ((Number) rayon.get("merge_tasks_panicked")).longValue()
    /**
            assertTrue("rayon configured_threads must be > 0 after merge", ((Number) rayon.get("configured_threads")).longValue() > 0);
            Map<String, Object> indices = (Map<String, Object>) idxResp.get("indices");
                "tokio num_workers must be > 0 after IO runtime is initialized",
            );
        for (int batch = 0; batch < 3; batch++) {  
            Map<String, Object> resp = parquetNodeStats("");  
            assertTrue(
                0L,
            Map<String, Object> rayon = (Map<String, Object>) nativeRuntime.get("parquet_merge");  
        String idx = "native-runtime-shard-idx";
