                "overflow_count_total",  
 *   <li>parquet {@code native_runtime.parquet_merge.merge_tasks_started / merge_tasks_failed}</li>
        assertBusy(() -> {
    // ===================================================================
                "index-level flush_and_sort_chunk_time_millis = sum of primary shards",
        String idx = "pr2-commit-failures-idx";
        }, 30, TimeUnit.SECONDS);
            );  
            assertNotNull("native_runtime block must be present", nativeRuntime);
                "flush_and_sort_chunk_time_millis at index level",
        for (int batch = 0; batch < 4; batch++) {  
        createCompositeIndex(idx, true);  
        assertBusy(() -> {
                    Map<String, Object> merge = (Map<String, Object>) copy.get("merge");
            long inFlight = ((Number) rayon.get("merge_tasks_in_flight")).longValue();
                    chunkTotalSum += ((Number) merge.get("flush_and_sort_chunk_total")).longValue();
    public void testParquetMergeRayonStatsAfterMerge() throws Exception {  
        // Multiple refreshes → multiple parquet files → force_merge has real work to do.
            // Index-level aggregate  
                }  
}
    public void testFlushAndSortChunkPresentAtAllShardIndexLevels() throws Exception {  
 *   <li>parquet {@code merge.flush_and_sort_chunk_total} / {@code _time_millis}</li>
            indexDocs(idx, 30, batch * 30);  
    // Rayon native_runtime — node-level only
                );
    @SuppressWarnings("unchecked")
        }, 30, TimeUnit.SECONDS);  
                "indices." + idx + ".commit.commit_total",
            indexDocs(idx, 40, batch * 40);
            }
    // ===================================================================  
    // Negative tests — fields gated correctly
        forceMerge(idx, 1);  
                    assertNotNull("merge block exists on shard copy", merge);
                "in_flight derivation: max(0, started - completed - failed - panicked)",  
        indexDocs(idx, 50, 0);
                "num_blocking_threads",  
            refreshIndex(idx);
                    "row_id_mapping_max [" + rowIdMax + "] must not exceed total rows [" + expectedRows + "]",
                    Map<String, Object> routing = (Map<String, Object>) copy.get("routing");
 * SPDX-License-Identifier: Apache-2.0
/*  
                "global_queue_depth",
                    assertNotNull("flush_and_sort_chunk_total on node", merge.get("flush_and_sort_chunk_total"));
                Math.max(0L, started - completed - failed - panicked),
            Map<String, Object> nodeStats = (Map<String, Object>) nodes.values().iterator().next();  
            );  
            assertCounterPresent(
            assertCounter(
        forceMerge(idx, 1);  
    public void testFlushAndSortChunkAggregatesAtIndexLevel() throws Exception {
            assertTrue("num_workers must be > 0 once tokio runtime is initialized: " + workers, workers > 0);
            // After IO activity (merge writes via spawn_blocking), the runtime polls tasks.
                    Map<String, Object> merge = (Map<String, Object>) copy.get("merge");
 * Integration tests for stats counters added on top of the baseline set: Validates the new counters  
                assertNotNull("primary shard must have merge block", merge);
    // Parquet flush_and_sort_chunk + row_id_mapping_max — per-shard
    public void testLuceneCommitFailuresIsZeroInHappyPath() throws Exception {
import java.util.concurrent.TimeUnit;  
        }, 30, TimeUnit.SECONDS);  
                Map<String, Object> nodeStats = (Map<String, Object>) n;
    }
        }
            Map<String, Object> shards = (Map<String, Object>) indexBlock.get("shards");
        }, 30, TimeUnit.SECONDS);  
import java.util.Map;
                "blocking_queue_depth",  
        forceMerge(idx, 1);
                "num_workers",
                rowIdMaxAcross
                Map<String, Object> primary = null;  
            long polls = ((Number) tokio.get("polls_count_total")).longValue();
                    rowIdMaxAcross = Math.max(rowIdMaxAcross, ((Number) merge.get("row_id_mapping_max")).longValue());
        createCompositeIndex(idx, true);
            long chunkTimeSum = 0;  
                "lucene commit_total should be >= 1 after force_merge",
            assertCounterPresent("lucene commit_failures field must be present", resp, "indices." + idx + ".commit.commit_failures");
        // Sanity: per-shard fields must appear at every level (shard / index / node-aggregate).
                "indices." + idx + ".merge.flush_and_sort_chunk_total"
        String idx = "pr2-fchunk-idx-agg";
        forceMerge(idx, 1);  
                }
 * this file be licensed under the Apache-2.0 license or a
    @SuppressWarnings("unchecked")
            // Node level — also has these per-shard counters summed  
                idx  
                1L
            assertFalse("nodes block must not be empty", nodes.isEmpty());
    // ===================================================================  
            Map<String, Object> shardResp = parquetIndexStats(idx, "level", "shards");
            refreshIndex(idx);
                "index-level flush_and_sort_chunk_total = sum of primary shards",
        for (int batch = 0; batch < 2; batch++) {
                assertTrue(
                // After a force-merge to 1 segment, that's at most the shard's total rows.
 *   <li>parquet {@code native_runtime.parquet_io.blocking_queue_depth / local_queue_depth_total}</li>  
            long failed = ((Number) rayon.get("merge_tasks_failed")).longValue();
    // ===================================================================  
 *  
            assertEquals("in_flight should be 0 after merges complete", 0L, inFlight);
            assertEquals("queue_depth derivation: max(0, submitted - started)", Math.max(0L, submitted - started), queueDepth);
                "active_tasks",
            Map<String, Object> resp = parquetNodeStats("");  
    public void testParquetIoNewTokioFieldsPresent() throws Exception {
        for (int batch = 0; batch < 4; batch++) {
            Map<String, Object> shards = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) shardResp.get("indices")).get(
                Map<String, Object> merge = (Map<String, Object>) nodeStats.get("merge");
                "indices." + idx + ".merge.flush_and_sort_chunk_time_millis"
            assertCounter(
                "flush_and_sort_chunk_total at index level",  
        String idx = "pr2-rayon-idx";
            assertNotNull("parquet_merge block must be present", rayon);
            assertCounterPresent("row_id_mapping_max at index level", idxResp, "indices." + idx + ".merge.row_id_mapping_max");  
            long rowIdMaxAcross = 0;
            Map<String, Object> nativeRuntime = (Map<String, Object>) nodeStats.get("native_runtime");
                Map<String, Object> merge = (Map<String, Object>) primary.get("merge");
            Map<String, Object> nodes = (Map<String, Object>) resp.get("nodes");  
            for (Map.Entry<String, Object> entry : shards.entrySet()) {
                for (Map<String, Object> copy : copies) {
    }
            );  
            Map<String, Object> resp = parquetNodeStats("");
            assertEquals("merge_tasks_failed must be 0 in happy path", 0L, failed);  
                "polls_count_total",
        createCompositeIndex(idx, true);
            Map<String, Object> rayon = (Map<String, Object>) nativeRuntime.get("parquet_merge");
                "indices." + idx + ".merge.flush_and_sort_chunk_total",
            refreshIndex(idx);
                assertTrue("flush_and_sort_chunk_total must be >= 1 after force_merge: " + chunkTotal, chunkTotal >= 1);
                        break;
    // ===================================================================
                long rowIdMax = ((Number) merge.get("row_id_mapping_max")).longValue();  
            Map<String, Object> indexBlock = (Map<String, Object>) indices.get(idx);  
            Map<String, Object> shards = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) shardResp.get("indices")).get(
 * behave correctly at shard, index, and node-aggregate scopes:
                    Map<String, Object> routing = (Map<String, Object>) copy.get("routing");
        String idx = "pr2-fields-everywhere-idx";  
            );  
        for (int batch = 0; batch < 3; batch++) {
                "workers_busy_millis_total" }) {
                    if (routing != null && Boolean.TRUE.equals(routing.get("primary"))) {  
            // Derived: queue_depth = max(0, submitted - started). After merges complete, should be 0.  
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)  
        assertBusy(() -> {
            Map<String, Object> nodes = (Map<String, Object>) nodeResp.get("nodes");
    // ===================================================================
        forceMerge(idx, 1);  
    }
 *   <li>lucene {@code commit.commit_failures}</li>
            // Snapshot fields must be >= 0 (current depth, not cumulative).  
    // ===================================================================
            long completed = ((Number) rayon.get("merge_tasks_completed")).longValue();  
 * </ul>
            for (Map.Entry<String, Object> entry : shards.entrySet()) {
            Map<String, Object> nodes = (Map<String, Object>) resp.get("nodes");
            assertCounterAtLeast(
            long submitted = ((Number) rayon.get("merge_tasks_submitted")).longValue();
            // After force_merge has settled, no merges in flight.
            for (Map.Entry<String, Object> entry : shards.entrySet()) {
        assertBusy(() -> {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            Map<String, Object> tokio = (Map<String, Object>) ((Map<String, Object>) nodeStats.get("native_runtime")).get("parquet_io");  
                chunkTimeSum
 * <ul>  
            assertTrue("merge_tasks_completed must be >= 1: " + completed, completed >= 1);
                        primary = copy;
        }
            totalDocs += 50;  
                assertNotNull("each shard entry must have a primary copy", primary);
 *   <li>parquet {@code merge.row_id_mapping_max} (max-of-maxes when aggregated)</li>  
                inFlight
        }, 30, TimeUnit.SECONDS);
            }
 * compatible open source license.
 */  
                    if (routing == null || !Boolean.TRUE.equals(routing.get("primary"))) continue;  
            Map<String, Object> resp = luceneIndexStats(idx);
 */
            // Index level  
            );
            )).get("shards");
                idxResp,  
                "index-level row_id_mapping_max = max-of-maxes (NOT sum)",
    // ===================================================================
                idxResp,  
            assertTrue("merge_tasks_started must be >= 1: " + started, started >= 1);
                idxResp,  
            Map<String, Object> indices = (Map<String, Object>) shardResp.get("indices");
        String idx = "pr2-fchunk-shard-idx";
            indexDocs(idx, 40, batch * 40);  
    // Tokio parquet_io — new fields present + non-negative
                "indices." + idx + ".merge.flush_and_sort_chunk_time_millis",
            Map<String, Object> shardResp = parquetIndexStats(idx, "level", "shards");  
 *   <li>parquet {@code native_runtime.parquet_io.polls_count_total / overflow_count_total}</li>
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            Map<String, Object> shardResp = parquetIndexStats(idx, "level", "shards");
                    assertNotNull("row_id_mapping_max on node", merge.get("row_id_mapping_max"));  
                idxResp,
                "spawned_tasks_total",
            assertTrue("local_queue_depth_total must be >= 0", ((Number) tokio.get("local_queue_depth_total")).longValue() >= 0);
            }  
                long chunkTime = ((Number) merge.get("flush_and_sort_chunk_time_millis")).longValue();
            Map<String, Object> nodeStats = (Map<String, Object>) nodes.values().iterator().next();
 * @opensearch.experimental
 *   <li>parquet {@code native_runtime.parquet_merge.merge_tasks_queue_depth / merge_tasks_in_flight} (derived)</li>
    @SuppressWarnings("unchecked")  
                List<Map<String, Object>> copies = (List<Map<String, Object>>) entry.getValue();
            assertTrue("workers_busy_millis_total must be >= 0: " + busyMillis, busyMillis >= 0);
    }
                    rowIdMax <= expectedRows  
            assertEquals("merge_tasks_panicked must be 0 in happy path", 0L, panicked);
 * The OpenSearch Contributors require contributions made to  
                if (merge != null) {  
        refreshIndex(idx);
        createCompositeIndex(idx, true);  
    @SuppressWarnings("unchecked")
            assertTrue("blocking_queue_depth must be >= 0", ((Number) tokio.get("blocking_queue_depth")).longValue() >= 0);
        }, 30, TimeUnit.SECONDS);
        createCompositeIndex(idx, true);
                "indices." + idx + ".merge.row_id_mapping_max",
            indexDocs(idx, 30, batch * 30);  
/**
                List<Map<String, Object>> copies = (List<Map<String, Object>>) entry.getValue();  
            assertCounter(
                for (Map<String, Object> copy : copies) {  
        assertBusy(() -> {
            refreshIndex(idx);
            // Index-level aggregate (default: no level=shards)
            long workers = ((Number) tokio.get("num_workers")).longValue();  
                    assertNotNull("row_id_mapping_max exists on shard", merge.get("row_id_mapping_max"));
            long started = ((Number) rayon.get("merge_tasks_started")).longValue();
public class StatsExtendedMetricsIT extends BaseStatsIT {
                resp,  
                chunkTotalSum
        // Distinct from row_id_mapping_max which uses max-of-maxes aggregation.
        final int expectedRows = totalDocs;  
        createCompositeIndex(idx, true);
    }
                    }  
        for (int batch = 0; batch < 3; batch++) {
            );  
            refreshIndex(idx);  
                "local_queue_depth_total",
            Map<String, Object> idxResp = parquetIndexStats(idx);  
            assertEquals(
            assertCounter("lucene commit_failures should be 0 in happy path", resp, "indices." + idx + ".commit.commit_failures", 0L);  
                    assertNotNull("flush_and_sort_chunk_time_millis on node", merge.get("flush_and_sort_chunk_time_millis"));
 *
            assertFalse("shards block must not be empty", shards.isEmpty());
                // row_id_mapping_max equals the row count of the largest merge output for this shard.
                idxResp,  
                    assertNotNull("flush_and_sort_chunk_total exists on shard", merge.get("flush_and_sort_chunk_total"));  
        String idx = "pr2-tokio-idx";  
    // ===================================================================  
        }
package org.opensearch.composite;
    @SuppressWarnings("unchecked")
    // Lucene commit_failures — always 0 in happy path
                assertNotNull("parquet_io must contain field: " + field, tokio.get(field));  
            Map<String, Object> nodeResp = parquetNodeStats("");
            assertCounterPresent(
                }
            long panicked = ((Number) rayon.get("merge_tasks_panicked")).longValue();
        assertBusy(() -> {
        forceMerge(idx, 1);
                }
                    chunkTimeSum += ((Number) merge.get("flush_and_sort_chunk_time_millis")).longValue();  
            // Shard level
        int totalDocs = 0;
                    assertNotNull("flush_and_sort_chunk_time_millis exists on shard", merge.get("flush_and_sort_chunk_time_millis"));
            indexDocs(idx, 50, batch * 50);
                assertTrue("row_id_mapping_max must be > 0 after force_merge: " + rowIdMax, rowIdMax > 0);  
                for (Map<String, Object> copy : copies) {
        }
            long busyMillis = ((Number) tokio.get("workers_busy_millis_total")).longValue();
                assertTrue("flush_and_sort_chunk_time_millis must be >= 0: " + chunkTime, chunkTime >= 0);  
            // Shard level — counters live on the actual primary shard  
    // ===================================================================  
            assertTrue("polls_count_total must be > 0 after merge IO: " + polls, polls > 0);  
            long chunkTotalSum = 0;
            )).get("shards");  
    public void testFlushAndSortChunkAndRowIdMappingMaxAtShardLevel() throws Exception {  
            );  
            assertTrue("overflow_count_total must be >= 0", ((Number) tokio.get("overflow_count_total")).longValue() >= 0);  
                idx
            assertNotNull("parquet_io block must be present", tokio);
            }
            assertTrue("merge_tasks_submitted must be >= 1: " + submitted, submitted >= 1);  
                long chunkTotal = ((Number) merge.get("flush_and_sort_chunk_total")).longValue();
            for (String field : new String[] {
            for (Object n : nodes.values()) {  
                List<Map<String, Object>> copies = (List<Map<String, Object>>) entry.getValue();
            long queueDepth = ((Number) rayon.get("merge_tasks_queue_depth")).longValue();  
            // All fields present (existing + new from Task 5).  
            }
        }
    }
 *
import java.util.List;
            // Sum of per-shard chunk_total values (level=shards)  
            Map<String, Object> idxResp = parquetIndexStats(idx);
