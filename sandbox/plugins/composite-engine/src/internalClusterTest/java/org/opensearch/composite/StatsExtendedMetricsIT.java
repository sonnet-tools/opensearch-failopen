            assertCounter(
        String idx = "pr2-fields-everywhere-idx";
 */
                    chunkTotalSum += ((Number) merge.get("flush_and_sort_chunk_total")).longValue();
    public void testFlushAndSortChunkAndRowIdMappingMaxAtShardLevel() throws Exception {
            Map<String, Object> resp = parquetNodeStats("");
            Map<String, Object> resp = parquetNodeStats("");
package org.opensearch.composite;
                "overflow_count_total",
        refreshIndex(idx);
                    Map<String, Object> merge = (Map<String, Object>) copy.get("merge");
                    assertNotNull("merge block exists on shard copy", merge);
            assertEquals("in_flight should be 0 after merges complete", 0L, inFlight);
    // ===================================================================
                idxResp,
                "global_queue_depth",
            );
    // ===================================================================
            totalDocs += 50;
            refreshIndex(idx);
    @SuppressWarnings("unchecked")
                "active_tasks",
            assertTrue("overflow_count_total must be >= 0", ((Number) tokio.get("overflow_count_total")).longValue() >= 0);
        assertBusy(() -> {
                // row_id_mapping_max equals the row count of the largest merge output for this shard.
            long rowIdMaxAcross = 0;
            assertTrue("merge_tasks_completed must be >= 1: " + completed, completed >= 1);
            Map<String, Object> nodeStats = (Map<String, Object>) nodes.values().iterator().next();
            long queueDepth = ((Number) rayon.get("merge_tasks_queue_depth")).longValue();
                    rowIdMaxAcross = Math.max(rowIdMaxAcross, ((Number) merge.get("row_id_mapping_max")).longValue());
                "indices." + idx + ".merge.flush_and_sort_chunk_time_millis",
    // ===================================================================
}
        assertBusy(() -> {
        createCompositeIndex(idx, true);
                        primary = copy;
            long polls = ((Number) tokio.get("polls_count_total")).longValue();
    @SuppressWarnings("unchecked")
            long busyMillis = ((Number) tokio.get("workers_busy_millis_total")).longValue();
    public void testParquetMergeRayonStatsAfterMerge() throws Exception {
        // Multiple refreshes → multiple parquet files → force_merge has real work to do.
            // Shard level
                "num_blocking_threads",
            // Index level
    }
            indexDocs(idx, 50, batch * 50);
            }
 *   <li>lucene {@code commit.commit_failures}</li>
 *   <li>parquet {@code native_runtime.parquet_io.blocking_queue_depth / local_queue_depth_total}</li>
        }, 30, TimeUnit.SECONDS);
            // All fields present (existing + new from Task 5).
                "indices." + idx + ".merge.flush_and_sort_chunk_total",
                assertTrue("row_id_mapping_max must be > 0 after force_merge: " + rowIdMax, rowIdMax > 0);
            for (Map.Entry<String, Object> entry : shards.entrySet()) {
        forceMerge(idx, 1);
        // Distinct from row_id_mapping_max which uses max-of-maxes aggregation.
 * <ul>
                "spawned_tasks_total",
            Map<String, Object> nodeStats = (Map<String, Object>) nodes.values().iterator().next();
        }
 * SPDX-License-Identifier: Apache-2.0
                Map<String, Object> merge = (Map<String, Object>) primary.get("merge");
            // Index-level aggregate (default: no level=shards)
                if (merge != null) {
                    assertNotNull("flush_and_sort_chunk_time_millis exists on shard", merge.get("flush_and_sort_chunk_time_millis"));
 * compatible open source license.
 */
        }
    @SuppressWarnings("unchecked")
            assertEquals(
                Math.max(0L, started - completed - failed - panicked),
                }
            assertCounter("lucene commit_failures should be 0 in happy path", resp, "indices." + idx + ".commit.commit_failures", 0L);
    }
                long chunkTotal = ((Number) merge.get("flush_and_sort_chunk_total")).longValue();
            Map<String, Object> nodeResp = parquetNodeStats("");
    @SuppressWarnings("unchecked")
                "index-level flush_and_sort_chunk_total = sum of primary shards",
    // ===================================================================
            long panicked = ((Number) rayon.get("merge_tasks_panicked")).longValue();
                Map<String, Object> nodeStats = (Map<String, Object>) n;
        createCompositeIndex(idx, true);
            )).get("shards");
 * The OpenSearch Contributors require contributions made to
                "indices." + idx + ".merge.flush_and_sort_chunk_time_millis"
                // After a force-merge to 1 segment, that's at most the shard's total rows.
        int totalDocs = 0;
    // Negative tests — fields gated correctly
 * this file be licensed under the Apache-2.0 license or a
            assertNotNull("parquet_merge block must be present", rayon);
                    if (routing == null || !Boolean.TRUE.equals(routing.get("primary"))) continue;
                idx
        for (int batch = 0; batch < 4; batch++) {
            refreshIndex(idx);
/**
                for (Map<String, Object> copy : copies) {
                1L
    // ===================================================================
import java.util.List;
            // Index-level aggregate
        }, 30, TimeUnit.SECONDS);
            for (Map.Entry<String, Object> entry : shards.entrySet()) {
        assertBusy(() -> {
                "local_queue_depth_total",
    }
/*
        String idx = "pr2-commit-failures-idx";
        createCompositeIndex(idx, true);
            assertTrue("merge_tasks_submitted must be >= 1: " + submitted, submitted >= 1);
                "lucene commit_total should be >= 1 after force_merge",
        for (int batch = 0; batch < 4; batch++) {
                "indices." + idx + ".commit.commit_total",
            refreshIndex(idx);
    // Tokio parquet_io — new fields present + non-negative
 *   <li>parquet {@code merge.flush_and_sort_chunk_total} / {@code _time_millis}</li>
                    }
    }
            long chunkTimeSum = 0;
            // Shard level — counters live on the actual primary shard
        final int expectedRows = totalDocs;
            indexDocs(idx, 40, batch * 40);
                assertNotNull("each shard entry must have a primary copy", primary);
            assertEquals("merge_tasks_failed must be 0 in happy path", 0L, failed);
            Map<String, Object> idxResp = parquetIndexStats(idx);
            Map<String, Object> shardResp = parquetIndexStats(idx, "level", "shards");
                    Map<String, Object> merge = (Map<String, Object>) copy.get("merge");
        forceMerge(idx, 1);
                rowIdMaxAcross
            assertCounter(
    @SuppressWarnings("unchecked")
            }
            Map<String, Object> indices = (Map<String, Object>) shardResp.get("indices");
            assertNotNull("parquet_io block must be present", tokio);
            )).get("shards");
                "indices." + idx + ".merge.flush_and_sort_chunk_total"
    public void testFlushAndSortChunkPresentAtAllShardIndexLevels() throws Exception {
        String idx = "pr2-tokio-idx";
                chunkTimeSum
                idxResp,
            long workers = ((Number) tokio.get("num_workers")).longValue();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            );
        indexDocs(idx, 50, 0);
            assertTrue("blocking_queue_depth must be >= 0", ((Number) tokio.get("blocking_queue_depth")).longValue() >= 0);
            refreshIndex(idx);
            indexDocs(idx, 30, batch * 30);
                "num_workers",
 *   <li>parquet {@code native_runtime.parquet_merge.merge_tasks_started / merge_tasks_failed}</li>
                idxResp,
            // Node level — also has these per-shard counters summed
            assertCounterAtLeast(
            }
            Map<String, Object> nativeRuntime = (Map<String, Object>) nodeStats.get("native_runtime");
        forceMerge(idx, 1);
 *
            assertTrue("merge_tasks_started must be >= 1: " + started, started >= 1);
        String idx = "pr2-fchunk-idx-agg";
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            indexDocs(idx, 30, batch * 30);
                idxResp,
            );
        // Sanity: per-shard fields must appear at every level (shard / index / node-aggregate).
            assertFalse("nodes block must not be empty", nodes.isEmpty());
    // Rayon native_runtime — node-level only
                    "row_id_mapping_max [" + rowIdMax + "] must not exceed total rows [" + expectedRows + "]",
            long started = ((Number) rayon.get("merge_tasks_started")).longValue();
            Map<String, Object> resp = luceneIndexStats(idx);
                assertNotNull("primary shard must have merge block", merge);
            );
 * </ul>
    // ===================================================================
            }
                chunkTotalSum
            // Derived: queue_depth = max(0, submitted - started). After merges complete, should be 0.
            assertTrue("workers_busy_millis_total must be >= 0: " + busyMillis, busyMillis >= 0);
                    assertNotNull("row_id_mapping_max exists on shard", merge.get("row_id_mapping_max"));
            assertEquals("queue_depth derivation: max(0, submitted - started)", Math.max(0L, submitted - started), queueDepth);
            // After IO activity (merge writes via spawn_blocking), the runtime polls tasks.
            Map<String, Object> shards = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) shardResp.get("indices")).get(
        }
        }, 30, TimeUnit.SECONDS);
                long rowIdMax = ((Number) merge.get("row_id_mapping_max")).longValue();
            assertNotNull("native_runtime block must be present", nativeRuntime);
                List<Map<String, Object>> copies = (List<Map<String, Object>>) entry.getValue();
                    chunkTimeSum += ((Number) merge.get("flush_and_sort_chunk_time_millis")).longValue();
            assertEquals("merge_tasks_panicked must be 0 in happy path", 0L, panicked);
        }, 30, TimeUnit.SECONDS);
public class StatsExtendedMetricsIT extends BaseStatsIT {
            );
        createCompositeIndex(idx, true);
import java.util.Map;
        for (int batch = 0; batch < 3; batch++) {
            long completed = ((Number) rayon.get("merge_tasks_completed")).longValue();
    // Lucene commit_failures — always 0 in happy path
        for (int batch = 0; batch < 2; batch++) {
                "index-level flush_and_sort_chunk_time_millis = sum of primary shards",
import java.util.concurrent.TimeUnit;
            Map<String, Object> indexBlock = (Map<String, Object>) indices.get(idx);
    public void testFlushAndSortChunkAggregatesAtIndexLevel() throws Exception {
            assertCounterPresent(
                    Map<String, Object> routing = (Map<String, Object>) copy.get("routing");
                "blocking_queue_depth",
            Map<String, Object> shardResp = parquetIndexStats(idx, "level", "shards");
 * @opensearch.experimental
            assertTrue("num_workers must be > 0 once tokio runtime is initialized: " + workers, workers > 0);
                Map<String, Object> primary = null;
            assertTrue("polls_count_total must be > 0 after merge IO: " + polls, polls > 0);
            long chunkTotalSum = 0;
        String idx = "pr2-rayon-idx";
                assertTrue("flush_and_sort_chunk_time_millis must be >= 0: " + chunkTime, chunkTime >= 0);
            Map<String, Object> nodes = (Map<String, Object>) resp.get("nodes");
                }
                for (Map<String, Object> copy : copies) {
                idxResp,
                }
    // ===================================================================
            for (Object n : nodes.values()) {
            // After force_merge has settled, no merges in flight.
                "polls_count_total",
    // ===================================================================
 *   <li>parquet {@code native_runtime.parquet_merge.merge_tasks_queue_depth / merge_tasks_in_flight} (derived)</li>
 * behave correctly at shard, index, and node-aggregate scopes:
            );
            Map<String, Object> tokio = (Map<String, Object>) ((Map<String, Object>) nodeStats.get("native_runtime")).get("parquet_io");
                );
            assertCounterPresent("row_id_mapping_max at index level", idxResp, "indices." + idx + ".merge.row_id_mapping_max");
            long inFlight = ((Number) rayon.get("merge_tasks_in_flight")).longValue();
        assertBusy(() -> {
 *   <li>parquet {@code merge.row_id_mapping_max} (max-of-maxes when aggregated)</li>
                assertTrue("flush_and_sort_chunk_total must be >= 1 after force_merge: " + chunkTotal, chunkTotal >= 1);
                    if (routing != null && Boolean.TRUE.equals(routing.get("primary"))) {
            long failed = ((Number) rayon.get("merge_tasks_failed")).longValue();
                    assertNotNull("flush_and_sort_chunk_time_millis on node", merge.get("flush_and_sort_chunk_time_millis"));
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)
                        break;
        createCompositeIndex(idx, true);
        }
 *   <li>parquet {@code native_runtime.parquet_io.polls_count_total / overflow_count_total}</li>
        assertBusy(() -> {
            Map<String, Object> nodes = (Map<String, Object>) resp.get("nodes");
        }
            for (Map.Entry<String, Object> entry : shards.entrySet()) {
            Map<String, Object> shards = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) shardResp.get("indices")).get(
    // Parquet flush_and_sort_chunk + row_id_mapping_max — per-shard
    }
                "indices." + idx + ".merge.row_id_mapping_max",
                "in_flight derivation: max(0, started - completed - failed - panicked)",
            assertCounterPresent("lucene commit_failures field must be present", resp, "indices." + idx + ".commit.commit_failures");
                    rowIdMax <= expectedRows
        }, 30, TimeUnit.SECONDS);
            for (String field : new String[] {
 *
            indexDocs(idx, 40, batch * 40);
                    assertNotNull("flush_and_sort_chunk_total on node", merge.get("flush_and_sort_chunk_total"));
            assertFalse("shards block must not be empty", shards.isEmpty());
    // ===================================================================
        assertBusy(() -> {
            long submitted = ((Number) rayon.get("merge_tasks_submitted")).longValue();
    }
 *
            );
            Map<String, Object> shards = (Map<String, Object>) indexBlock.get("shards");
                long chunkTime = ((Number) merge.get("flush_and_sort_chunk_time_millis")).longValue();
            refreshIndex(idx);
                resp,
 * Integration tests for stats counters added on top of the baseline set: Validates the new counters
        String idx = "pr2-fchunk-shard-idx";
                assertTrue(
            Map<String, Object> nodes = (Map<String, Object>) nodeResp.get("nodes");
                    Map<String, Object> routing = (Map<String, Object>) copy.get("routing");
                }
        }, 30, TimeUnit.SECONDS);
                List<Map<String, Object>> copies = (List<Map<String, Object>>) entry.getValue();
                assertNotNull("parquet_io must contain field: " + field, tokio.get(field));
                inFlight
                "index-level row_id_mapping_max = max-of-maxes (NOT sum)",
        for (int batch = 0; batch < 3; batch++) {
        forceMerge(idx, 1);
                "flush_and_sort_chunk_time_millis at index level",
            Map<String, Object> rayon = (Map<String, Object>) nativeRuntime.get("parquet_merge");
                    assertNotNull("row_id_mapping_max on node", merge.get("row_id_mapping_max"));
                List<Map<String, Object>> copies = (List<Map<String, Object>>) entry.getValue();
            // Sum of per-shard chunk_total values (level=shards)
                idx
            Map<String, Object> shardResp = parquetIndexStats(idx, "level", "shards");
        createCompositeIndex(idx, true);
            assertCounter(
    public void testLuceneCommitFailuresIsZeroInHappyPath() throws Exception {
            }
        forceMerge(idx, 1);
                    assertNotNull("flush_and_sort_chunk_total exists on shard", merge.get("flush_and_sort_chunk_total"));
    // ===================================================================
                "flush_and_sort_chunk_total at index level",
            // Snapshot fields must be >= 0 (current depth, not cumulative).
            assertCounterPresent(
                for (Map<String, Object> copy : copies) {
                Map<String, Object> merge = (Map<String, Object>) nodeStats.get("merge");
            assertTrue("local_queue_depth_total must be >= 0", ((Number) tokio.get("local_queue_depth_total")).longValue() >= 0);
    public void testParquetIoNewTokioFieldsPresent() throws Exception {
        forceMerge(idx, 1);
                "workers_busy_millis_total" }) {
            Map<String, Object> idxResp = parquetIndexStats(idx);
