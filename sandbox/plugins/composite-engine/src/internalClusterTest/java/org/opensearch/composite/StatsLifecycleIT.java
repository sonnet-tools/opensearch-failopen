            assertCounterAtLeast(
     * Race-condition safety: 4 threads index 250 docs each concurrently. After all threads
                "indices.lifecycle-idx.merge.merge_total",
    }
                    long current = getCounter(r, "indices." + idx + ".indexing.docs_indexed_total");
            luceneIndexStats(idx),
        assertTrue("parquet docs must be absent (-1) or 0 for non-composite index, got " + parquetDocs, parquetDocs <= 0L);
        refreshIndex("accumulate-idx");
    public void testStatsLifecycle_SingleShard() throws Exception {
                    if (current < prev) {
        final int totalDocs = threadCount * docsPerThread;
        );
        assertCounter("lucene flush_total zero", l, "indices.empty-idx.flush.flush_total", 0L);
            "lucene final must match",
        assertCounterAtLeast("stage 1 parquet index_time", r1, "indices.lifecycle-idx.indexing.index_time_millis", 0L);
        }
        assertCounter(
        long v2Lucene = getCounter(luceneIndexStats("accumulate-idx"), "indices.accumulate-idx.indexing.docs_indexed_total");
            parquetIndexStats(idx),
        for (Future<?> f : futures) {
        Map<String, Object> l2 = luceneIndexStats("lifecycle-idx");
    /**
            client().prepareIndex("plain-idx").setSource("name", "doc_" + i).get();
                "stage 5 parquet flush_and_sort_chunk_total",
     * Verifies that stats for multiple indices are isolated — querying one index
        // commit_failures must stay 0 in the happy path.
            "post-recreate parquet native_write zero",
import java.util.concurrent.Future;
        assertCounter("parquet idx3", parquetIndexStats("idx3"), "indices.idx3.indexing.docs_indexed_total", 30L);
                    Thread.sleep(1);
     * Verifies that parquet primary and lucene secondary see the same operations.
        assertCounter("parquet idx2", parquetIndexStats("idx2"), "indices.idx2.indexing.docs_indexed_total", 20L);
        assertCounter("pre-delete parquet docs", parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total", 100L);
        assertTrue("lucene docs must be absent (-1) or 0 for non-composite index, got " + luceneDocs, luceneDocs <= 0L);
        refreshIndex("lifecycle-idx");
                    return;
package org.opensearch.composite;
        for (int i = 0; i < 5; i++) {
                    start.await();
    /**
        assertCounter("pre-delete lucene docs", luceneIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total", 100L);
 * Integration tests for stats API lifecycle behavior on a single-node, single-shard topology.
    /**
            assertTrue("expected 4xx, got " + code, code >= 400 && code < 500);
            wildcardResponse.getEntity().getContent(),
        AtomicLong lastSeen = new AtomicLong(0);
        assertCounter("stage 0 lucene refresh", l0, "indices.lifecycle-idx.refresh.refresh_total", 0L);
     */
            // after merging 5 batches of 40 docs (=260 total) on a single-shard index, max is 260.
        pool.shutdown();
        assertCounter("post-recreate lucene docs zero", luceneIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total", 0L);
    }
        // Stage 2 — refresh
     * nonexistent index, response shape, and content-type.
        // Delete and recreate same name.
            true
        Map<String, Object> l3 = luceneIndexStats("lifecycle-idx");
        indexDocs("accumulate-idx", 30, 0);
    public void testNonCompositeIndexReturnsEmpty() throws Exception {
            "final docs_indexed_total must be exactly " + totalDocs,
        // Stage 5 — force_merge to 1 segment. Parquet merges asynchronously off the force_merge call,
        querier.join(5000);
     * <p>A separate querier thread polls the stats endpoint at ~1ms intervals while indexing
        // Stage 3 — flush
        // Post-condition: counters must be 0 — no carryover from the deleted index's tracker.
        try {
        // Multiple parquet files are needed for force_merge to actually invoke a parquet merge:
        long v1Refresh = getCounter(luceneIndexStats("accumulate-idx"), "indices.accumulate-idx.refresh.refresh_total");
     *
        // Response must contain the indices block. The plain-idx entry must NOT have any DFA
        indexDocs("idx2", 20, 0);
        final int docsPerThread = 250;
import java.util.concurrent.atomic.AtomicBoolean;
                        client().prepareIndex(idx).setSource("name", "doc_" + docId, "value", docId).get();
        querier.start();
        assertEquals(30L, v1Lucene);
    }
 * Tests counter accuracy across indexing, refresh, flush, merge stages and REST contract negatives.
                        int docId = threadId * docsPerThread + i;
            while (keepQuerying.get()) {
        } catch (ResponseException e) {
    /**
        assertCounter("parquet vsr_rotations_total zero", p, "indices.empty-idx.vsr.vsr_rotations_total", 0L);
}
                }
        Map<String, Object> l1 = luceneIndexStats("lifecycle-idx");
        assertTrue("Content-Type must be application/json, got: " + contentType, contentType.startsWith("application/json"));
/*
        assertCounter("parquet native_finalize_total zero", p, "indices.empty-idx.native_write.native_finalize_total", 0L);
            // dispatches to both the primary (parquet) and secondary (lucene) mergers. We
    /**
        assertCounter("stage 4 lucene docs accumulate", l4, "indices.lifecycle-idx.indexing.docs_indexed_total", 260L);
            "indices." + idx + ".native_write.native_write_total",
        refreshIndex(idx);
                org.opensearch.common.settings.Settings.builder()
     * Flagship accuracy test: walks through 7 stages of index lifecycle and asserts
            .indices()
        String idx = "reset-on-delete-idx";
                260L
        assertCounter("stage 3 lucene commit_failures", l3, "indices.lifecycle-idx.commit.commit_failures", 0L);
        assertCounter("lucene merge_total zero", l, "indices.empty-idx.merge.merge_total", 0L);
        Map<String, Object> r1 = parquetIndexStats("lifecycle-idx");
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)
        assertEquals("lucene docs accumulate exactly", v1Lucene + 70L, v2Lucene);
        flushIndex("lifecycle-idx");
    public void testRESTContractNegatives() throws Exception {
import java.util.Map;
     */
        // Stage 1 — index 100 docs (no refresh yet)
     * still slip through. The primary correctness invariant is the final-count assertion at
            assertCounter(
    public void testCountersAccumulateAcrossOperations() throws Exception {
        assertCounter("lucene idx3", luceneIndexStats("idx3"), "indices.idx3.indexing.docs_indexed_total", 30L);
        assertEquals("parquet docs accumulate exactly", v1Parquet + 70L, v2Parquet);
        assertCounterAtLeast("stage 2 native_write", r2, "indices.lifecycle-idx.native_write.native_write_total", 1L);
        assertCounter(
        Thread querier = new Thread(() -> {
        // Final accuracy check.
import java.util.concurrent.TimeUnit;
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        // 2. Wrong method POST -> 405
                    }
     */
                1L
            refreshIndex("lifecycle-idx");
    public void testCountersResetOnIndexDelete() throws Exception {
                    }
        // (We use a wildcard pattern; bare /_plugins/parquet/_stats is not a registered route.)
            // row_id_mapping_max equals the largest merge output's row count for this shard;
        assertCounterAtLeast("stage 2 lucene refresh_total", l2, "indices.lifecycle-idx.refresh.refresh_total", 1L);
 *
        Map<String, Object> r4 = parquetIndexStats("lifecycle-idx");
        // Every parquet counter that's been wired must be zero, not absent (catches tracker-not-registered bugs).
        indexDocs("idx1", 10, 0);
        } catch (ResponseException e) {
        // Stage 0 — fresh index
    }
            .setSettings(
import java.util.concurrent.CountDownLatch;
            );
        // Verify no querier errors.
                    .put(org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        long parquetDocs = getCounter(p, "indices.cross-format-idx.indexing.docs_indexed_total");
        Map<String, Object> l4 = luceneIndexStats("lifecycle-idx");
                }
            assertCounterAtLeast("stage 5 parquet merge_input_files", r5, "indices.lifecycle-idx.merge.merge_input_files_total", 2L);
                    lastSeen.set(Math.max(prev, current));
        assertCounterAtLeast("lucene refresh after refresh", l, "indices.cross-format-idx.refresh.refresh_total", 1L);
 * The OpenSearch Contributors require contributions made to
        long luceneDocs = getCounter(l, "indices.cross-format-idx.indexing.docs_indexed_total");
            Map<String, Object> r5 = parquetIndexStats("lifecycle-idx");
     * is in flight and asserts the docs_indexed_total counter never goes backwards. This is a
        refreshIndex("accumulate-idx");
        assertCounter("stage 0 docs", r0, "indices.lifecycle-idx.indexing.docs_indexed_total", 0L);
                } catch (Exception e) {
    public void testEmptyIndexAllCountersZero() throws Exception {
        Map<String, Object> r2 = parquetIndexStats("lifecycle-idx");
            assertCounterAtLeast(
 */
    /**
        createCompositeIndex("cross-format-idx", true);
        assertCounterAtLeast("stage 3 lucene flush", l3, "indices.lifecycle-idx.flush.flush_total", 1L);
        refreshIndex("contract-idx");
        createCompositeIndex("empty-idx", true);
        assertTrue("response must contain 'indices' key", l.containsKey("indices"));
            assertCounterAtLeast(
        long parquetDocs = getCounter(p, "indices.plain-idx.indexing.docs_indexed_total");
        assertCounter(
import java.util.concurrent.Executors;
        // Single querier thread: read-then-update of `lastSeen` is safe without compare-and-swap
    }
        assertCounter("parquet merge_total zero", p, "indices.empty-idx.merge.merge_total", 0L);
                try {
     * Verifies that a plain Lucene index (no composite engine) returns 200 with effectively-empty stats.
        Map<String, Object> l0 = luceneIndexStats("lifecycle-idx");
            assertCounterAtLeast("stage 5 parquet merge_total", r5, "indices.lifecycle-idx.merge.merge_total", 1L);
        long v1Lucene = getCounter(luceneIndexStats("accumulate-idx"), "indices.accumulate-idx.indexing.docs_indexed_total");
        assertEquals(260L, parquetDocs);
     */
                "stage 5 lucene merge_total >= 1 (composite force_merge dispatches to lucene merger too)",
    }
        createCompositeIndex("accumulate-idx", true);
        // Same for lucene. Note: index creation may trigger an initial commit, so commit_total may be 0 or 1.
                } catch (Throwable t) {
        // policy doesn't merge fewer than 2 files, and we want headroom above the threshold.
    }
        ExecutorService pool = Executors.newFixedThreadPool(threadCount);
    }
                1L
import java.util.concurrent.atomic.AtomicLong;
        assertCounter("stage 0 native_write", r0, "indices.lifecycle-idx.native_write.native_write_total", 0L);
            .get();
                    Thread.currentThread().interrupt();
import java.util.concurrent.ExecutorService;
        long v2Refresh = getCounter(luceneIndexStats("accumulate-idx"), "indices.accumulate-idx.refresh.refresh_total");
                    Map<String, Object> r = parquetIndexStats(idx);
        // 1. Unknown format -> 400
        indexDocs("lifecycle-idx", 100, 0);
import java.util.List;
        assertCounterAtLeast("stage 4 lucene refresh count", l4, "indices.lifecycle-idx.refresh.refresh_total", 5L);
        forceMerge("lifecycle-idx", 1);
        for (int t = 0; t < threadCount; t++) {
            (long) totalDocs
        client().admin().indices().prepareDelete(idx).get();
                    return;
                    queryError.set(t);
     * Verifies a freshly-created index with no operations has all counters at zero.
            // force-merge during flush.
            assertEquals(405, e.getResponse().getStatusLine().getStatusCode());
        // Batch 2: 70 more docs, refresh, capture v2
        indexDocs("cross-format-idx", 50, 0);
        } catch (ResponseException e) {
 * @opensearch.experimental
        assertCounterAtLeast("stage 3 lucene commit", l3, "indices.lifecycle-idx.commit.commit_total", 1L);
        for (int batch = 1; batch <= 4; batch++) {
        assertEquals("cross-format doc count must match", parquetDocs, luceneDocs);
            fail("expected 4xx for nonexistent index");
        // commit_total may be 0 or 1 — index creation can trigger an initial Lucene commit.
        assertCounter("lucene refresh_total zero", l, "indices.empty-idx.refresh.refresh_total", 0L);
        // Batch 1: 30 docs, refresh, capture v1
        createCompositeIndex("lifecycle-idx", true);
        Map<String, Object> p = parquetIndexStats("empty-idx");
        // Flush fires lucene flush+commit; parquet does not have a flush counter (it finalizes per refresh).
        assertCounter("stage 1 lucene docs", l1, "indices.lifecycle-idx.indexing.docs_indexed_total", 100L);
        assertCounterAtLeast("lucene commit after flush", l, "indices.cross-format-idx.commit.commit_total", 1L);
        }
        // Create index WITHOUT composite engine — plain Lucene only.
    public void testMultipleIndicesIsolation() throws Exception {
        // counters: with no tracker registered, FormatStatsResponse aggregation produces an
            );
            // flush.flush_force_merge_time_millis also records time spent in the internal
/**
        assertCounterAtLeast("lucene flush after flush", l, "indices.cross-format-idx.flush.flush_total", 1L);
    }
                    long prev = lastSeen.get();
        assertCounterAtLeast("stage 2 native_finalize", r2, "indices.lifecycle-idx.native_write.native_finalize_total", 1L);
        assertTrue("refresh_total must be at least 1 after batch 1", v1Refresh >= 1L);
 */
                r5,
            assertCounterAtLeast(
        assertTrue("response must contain 'indices' key", p.containsKey("indices"));
        flushIndex("cross-format-idx");
        // Doc counters must be exactly v1 + 70.
                "indices.lifecycle-idx.flush.flush_force_merge_time_millis",
            fail("expected 400 for unknown format");
        indexDocs("accumulate-idx", 70, 30);
        // Accepting -1 OR 0 makes the assertion robust to future shape changes (e.g., emitting
                return null;
import org.opensearch.client.Response;
                "indices.lifecycle-idx.merge.flush_and_sort_chunk_total",
        // Concurrent stats queries while indexing — best-effort monotonicity check at ~1ms cadence.
        assertCounterAtLeast("stage 2 lucene refresh_time", l2, "indices.lifecycle-idx.refresh.refresh_time_millis", 0L);
            );
                } catch (InterruptedException ie) {
     */
            getRestClient().performRequest(new Request("POST", "/_plugins/parquet/contract-idx/_stats"));
        // Refresh fires native_finalize on parquet AND refresh_total on lucene.
            .setMapping("name", "type=keyword")
        Map<String, Object> p = parquetIndexStats("plain-idx");
            assertCounter("stage 5 lucene merge_failures", l5, "indices.lifecycle-idx.merge.merge_failures", 0L);
        long commitTotal = getCounter(l, "indices.empty-idx.commit.commit_total");
        assertCounter("parquet index_time zero", p, "indices.empty-idx.indexing.index_time_millis", 0L);
     * Verifies that stats counters reset to 0 when an index is deleted and recreated with the
        refreshIndex("cross-format-idx");
        createCompositeIndex(idx, true);
        }, 30, java.util.concurrent.TimeUnit.SECONDS);
        keepQuerying.set(false);
            "indices." + idx + ".indexing.docs_indexed_total",
        try {
        long v1Parquet = getCounter(parquetIndexStats("accumulate-idx"), "indices.accumulate-idx.indexing.docs_indexed_total");
        // so wrap merge-counter assertions in assertBusy to wait for the native merge to finalize.
            final int threadId = t;
        Map<String, Object> wildcardBody = org.opensearch.common.xcontent.XContentHelper.convertToMap(
        final int threadCount = 4;
        start.countDown();
            // expect merge_total >= number_of_primary_shards (1 here, single-shard test).
            f.get(90, TimeUnit.SECONDS);
        assertCounter("stage 1 parquet docs", r1, "indices.lifecycle-idx.indexing.docs_indexed_total", 100L);
                l5,
            assertEquals(400, e.getResponse().getStatusLine().getStatusCode());
        assertEquals("both formats must observe identical doc count", parquetDocs, luceneDocs);
     * the end of the test.
        assertCounter("happy parquet native_write_failures", rf, "indices.lifecycle-idx.native_write.native_write_failures", 0L);
        assertTrue("response must have 'indices' key", wildcardBody.containsKey("indices"));
        AtomicBoolean keepQuerying = new AtomicBoolean(true);
        // The response must NOT have a server error.
            );
        // Index some docs — these go to plain Lucene, not DFA.
        // 3. Nonexistent index -> 4xx
        createCompositeIndex("idx1", true);
        // explicit zeros rather than omitting fields).
        String idx = "concurrent-idx";
        assertCounter("happy lucene merge_failures", lf, "indices.lifecycle-idx.merge.merge_failures", 0L);
     * best-effort check: a transient backwards-jump that resolves within a poll window could
        assertCounterAtLeast("parquet finalize after refresh", p, "indices.cross-format-idx.native_write.native_finalize_total", 1L);
        }
        // empty object for the index, so docs_indexed_total is absent (getCounter returns -1L).
                "stage 5 parquet row_id_mapping_max equals merged row count",
        });
        // Stage 4 — index 4 more batches with refresh between each, to produce 5 parquet files total.
                "stage 5 lucene flush_force_merge_time_millis",
        // Pre-condition: counters reflect the indexed docs.
        }
            // Lucene merger fires per shard during composite force_merge — CompositeMerger
        refreshIndex("idx3");
        List<Future<?>> futures = new ArrayList<>();
     */
     */
    /**
                0L
            futures.add(pool.submit(() -> {
        );
                try {
                "indices.lifecycle-idx.merge.flush_and_sort_chunk_time_millis",
        assertEquals(30L, v1Parquet);
        try {
     * Verifies counters increment correctly across multiple write batches — no resets, no drift.
        }
     * returns only that index's counters.
        assertCounter("parquet docs zero", p, "indices.empty-idx.indexing.docs_indexed_total", 0L);
        // 5. Content-Type assertion
        long parquetDocs = getCounter(rf, "indices.lifecycle-idx.indexing.docs_indexed_total");
        assertTrue("refresh count must strictly increase: v1=" + v1Refresh + ", v2=" + v2Refresh, v2Refresh > v1Refresh);
            org.opensearch.common.xcontent.json.JsonXContent.jsonXContent,
        client().admin()
import java.util.concurrent.atomic.AtomicReference;
     */
        Map<String, Object> l = luceneIndexStats("plain-idx");
        // Stage 6 — final cross-format consistency
        long luceneDocs = getCounter(lf, "indices.lifecycle-idx.indexing.docs_indexed_total");
            0L
        }
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> l = luceneIndexStats("empty-idx");
        assertCounter("happy parquet merge_failures", rf, "indices.lifecycle-idx.merge.merge_failures", 0L);
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.client.Request;
            // per-shard merge metrics — must populate after force_merge runs at least one merge.
        // Both stats endpoints must return HTTP 200 with no parquet/lucene tracker data for this index.
 * SPDX-License-Identifier: Apache-2.0
    public void testConcurrentIndexingAccuracy() throws Exception {
            )
                r5,
            throw new AssertionError("querier thread saw an error", queryError.get());
        createCompositeIndex("idx2", true);
        assertCounter("parquet idx1", parquetIndexStats("idx1"), "indices.idx1.indexing.docs_indexed_total", 10L);
        long luceneDocs = getCounter(l, "indices.plain-idx.indexing.docs_indexed_total");
     * same name. Catches tracker leaks in the per-format provider registry.
        assertCounter("lucene docs zero", l, "indices.empty-idx.indexing.docs_indexed_total", 0L);
        Map<String, Object> rf = parquetIndexStats("lifecycle-idx");
        CountDownLatch start = new CountDownLatch(1);
        assertBusy(() -> {
        createCompositeIndex(idx, true);
                "indices.lifecycle-idx.merge.row_id_mapping_max",
        assertCounter("post-recreate lucene refresh zero", luceneIndexStats(idx), "indices." + idx + ".refresh.refresh_total", 0L);
        createCompositeIndex("contract-idx", true);
                    for (int i = 0; i < docsPerThread; i++) {
        // Note: ParquetShardStats does NOT have docs_indexed_failures — only lucene does
     * complete, docs_indexed_total must be exactly 1000.
        assertCounter("stage 1 lucene refresh_total", l1, "indices.lifecycle-idx.refresh.refresh_total", 0L);
        AtomicReference<Throwable> queryError = new AtomicReference<>();
     */
        indexDocs("idx3", 30, 0);
        // Release indexer threads.
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/no-such-idx/_stats"));
            parquetIndexStats(idx),
            Map<String, Object> l5 = luceneIndexStats("lifecycle-idx");
        Map<String, Object> lf = luceneIndexStats("lifecycle-idx");
                    throw new RuntimeException("thread " + threadId + " failed", e);
        refreshIndex("plain-idx");
        assertTrue("lucene commit_total must be 0 or 1 for empty index, got " + commitTotal, commitTotal >= 0L && commitTotal <= 1L);
    /**
            );
        createCompositeIndex("idx3", true);
        // All failure counters zero in happy path
        if (queryError.get() != null) {
            indexDocs("lifecycle-idx", 40, 100 + (batch - 1) * 40);
                    .put(org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Map<String, Object> p = parquetIndexStats("cross-format-idx");
            fail("expected 405 for POST");
public class StatsLifecycleIT extends BaseStatsIT {
        ensureGreen("plain-idx");
            getRestClient().performRequest(new Request("GET", "/_plugins/orc/contract-idx/_stats"));
        String contentType = successResponse.getEntity().getContentType();
        assertCounter("stage 4 parquet docs accumulate", r4, "indices.lifecycle-idx.indexing.docs_indexed_total", 260L);
        assertCounter("parquet native_write_total zero", p, "indices.empty-idx.native_write.native_write_total", 0L);
     * counters increment correctly for both parquet and lucene formats.
            }));
import org.opensearch.client.ResponseException;
        assertCounter("lucene idx2", luceneIndexStats("idx2"), "indices.idx2.indexing.docs_indexed_total", 20L);
                r5,
        indexDocs("contract-idx", 5, 0);
     * Tests REST contract negative cases: unknown format, wrong HTTP method,
        assertEquals(50L, parquetDocs);
        Response successResponse = getRaw("/_plugins/parquet/contract-idx/_stats");
        indexDocs(idx, 100, 0);
        }
                "stage 5 parquet flush_and_sort_chunk_time_millis",
            "indices." + idx + ".indexing.docs_indexed_total",
            int code = e.getResponse().getStatusLine().getStatusCode();
        // because there is no other writer.
                l5,
import java.util.ArrayList;
        // Refresh count must increase strictly (we issued at least one more refresh).
        Response wildcardResponse = getRaw("/_plugins/parquet/*/_stats");
 *
        Map<String, Object> r0 = parquetIndexStats("lifecycle-idx");
        }
        refreshIndex("idx1");
            assertCounter("stage 5 parquet merge_failures", r5, "indices.lifecycle-idx.merge.merge_failures", 0L);
        Map<String, Object> l = luceneIndexStats("cross-format-idx");
    /**
        // 4. Verify a successful all-shards query returns proper structure.
 * compatible open source license.
                1L
        assertCounter("post-recreate parquet docs zero", parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total", 0L);
        long v2Parquet = getCounter(parquetIndexStats("accumulate-idx"), "indices.accumulate-idx.indexing.docs_indexed_total");
    public void testCrossFormatConsistency() throws Exception {
            }
        assertCounter("lucene idx1", luceneIndexStats("idx1"), "indices.idx1.indexing.docs_indexed_total", 10L);
            .prepareCreate("plain-idx")
        refreshIndex(idx);
        createCompositeIndex(idx, true);
            (long) totalDocs
        );
        refreshIndex("idx2");
        );
                        throw new AssertionError("counter went backwards: prev=" + prev + ", current=" + current);
