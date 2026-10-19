            assertCounter(  
        // Refresh count must increase strictly (we issued at least one more refresh).
        Map<String, Object> l = luceneIndexStats("cross-format-idx");
        assertCounter("parquet index_time zero", p, "indices.empty-idx.indexing.index_time_millis", 0L);
        assertCounter("lucene idx2", luceneIndexStats("idx2"), "indices.idx2.indexing.docs_indexed_total", 20L);  
     * counters increment correctly for both parquet and lucene formats.  
     * Verifies counters increment correctly across multiple write batches — no resets, no drift.  
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/no-such-idx/_stats"));
        assertCounterAtLeast("lucene flush after flush", l, "indices.cross-format-idx.flush.flush_total", 1L);
        assertCounter("parquet idx1", parquetIndexStats("idx1"), "indices.idx1.indexing.docs_indexed_total", 10L);
        // 3. Nonexistent index -> 4xx
        createCompositeIndex("lifecycle-idx", true);  
                "stage 5 parquet flush_and_sort_chunk_time_millis",
                "indices.lifecycle-idx.merge.row_id_mapping_max",  
                260L
        assertCounter("parquet native_write_total zero", p, "indices.empty-idx.native_write.native_write_total", 0L);
        createCompositeIndex("accumulate-idx", true);  
        assertCounter("stage 1 lucene docs", l1, "indices.lifecycle-idx.indexing.docs_indexed_total", 100L);
        // Every parquet counter that's been wired must be zero, not absent (catches tracker-not-registered bugs).
        // so wrap merge-counter assertions in assertBusy to wait for the native merge to finalize.
    public void testCountersResetOnIndexDelete() throws Exception {  
                try {
        }
    /**
        createCompositeIndex("empty-idx", true);  
            wildcardResponse.getEntity().getContent(),
        Thread querier = new Thread(() -> {  
     */
        refreshIndex("idx2");
        assertCounter("post-recreate lucene refresh zero", luceneIndexStats(idx), "indices." + idx + ".refresh.refresh_total", 0L);
 * The OpenSearch Contributors require contributions made to  
        long commitTotal = getCounter(l, "indices.empty-idx.commit.commit_total");
                } catch (InterruptedException ie) {
                "indices.lifecycle-idx.merge.merge_total",  
        // Stage 4 — index 4 more batches with refresh between each, to produce 5 parquet files total.  
     * returns only that index's counters.  
        assertCounter("lucene flush_total zero", l, "indices.empty-idx.flush.flush_total", 0L);
     * best-effort check: a transient backwards-jump that resolves within a poll window could
        // Response must contain the indices block. The plain-idx entry must NOT have any DFA
            assertEquals(400, e.getResponse().getStatusLine().getStatusCode());  
            throw new AssertionError("querier thread saw an error", queryError.get());  
     * still slip through. The primary correctness invariant is the final-count assertion at  
        );  
            0L  
        flushIndex("lifecycle-idx");
        createCompositeIndex(idx, true);
        indexDocs("idx1", 10, 0);
        Map<String, Object> p = parquetIndexStats("empty-idx");
    public void testNonCompositeIndexReturnsEmpty() throws Exception {
        // empty object for the index, so docs_indexed_total is absent (getCounter returns -1L).  
        // The response must NOT have a server error.
        assertCounter("lucene docs zero", l, "indices.empty-idx.indexing.docs_indexed_total", 0L);
    /**
            .indices()
        querier.join(5000);
        // policy doesn't merge fewer than 2 files, and we want headroom above the threshold.
        refreshIndex("accumulate-idx");
                org.opensearch.common.settings.Settings.builder()
        } catch (ResponseException e) {
            assertCounterAtLeast(
        createCompositeIndex("idx1", true);  
                try {
        assertCounter("stage 0 docs", r0, "indices.lifecycle-idx.indexing.docs_indexed_total", 0L);
                }
        Map<String, Object> l3 = luceneIndexStats("lifecycle-idx");  
            futures.add(pool.submit(() -> {
        Map<String, Object> r2 = parquetIndexStats("lifecycle-idx");  
        Map<String, Object> l = luceneIndexStats("empty-idx");  
            getRestClient().performRequest(new Request("POST", "/_plugins/parquet/contract-idx/_stats"));
            "post-recreate parquet native_write zero",  
        // 2. Wrong method POST -> 405  
        // commit_failures must stay 0 in the happy path.  
    /**
        // counters: with no tracker registered, FormatStatsResponse aggregation produces an
        // Stage 2 — refresh
        assertCounterAtLeast("stage 2 lucene refresh_time", l2, "indices.lifecycle-idx.refresh.refresh_time_millis", 0L);
            assertCounterAtLeast(  
                1L
                r5,  
            // dispatches to both the primary (parquet) and secondary (lucene) mergers. We
            )
            );  
            // expect merge_total >= number_of_primary_shards (1 here, single-shard test).  
        CountDownLatch start = new CountDownLatch(1);
    }
                "stage 5 parquet flush_and_sort_chunk_total",
        indexDocs("cross-format-idx", 50, 0);
        assertCounter("stage 3 lucene commit_failures", l3, "indices.lifecycle-idx.commit.commit_failures", 0L);
        assertCounter("pre-delete lucene docs", luceneIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total", 100L);
     */
 *
     * Tests REST contract negative cases: unknown format, wrong HTTP method,
        ensureGreen("plain-idx");
            client().prepareIndex("plain-idx").setSource("name", "doc_" + i).get();
/*  
            "indices." + idx + ".indexing.docs_indexed_total",
        Map<String, Object> rf = parquetIndexStats("lifecycle-idx");
        createCompositeIndex("cross-format-idx", true);
        final int totalDocs = threadCount * docsPerThread;  
                r5,  
            "final docs_indexed_total must be exactly " + totalDocs,  
        AtomicBoolean keepQuerying = new AtomicBoolean(true);
        // because there is no other writer.
        final int threadCount = 4;
 */  
package org.opensearch.composite;
        // commit_total may be 0 or 1 — index creation can trigger an initial Lucene commit.  
import java.util.concurrent.Future;
        assertTrue("refresh count must strictly increase: v1=" + v1Refresh + ", v2=" + v2Refresh, v2Refresh > v1Refresh);
        indexDocs("accumulate-idx", 30, 0);  
        assertCounter("lucene idx3", luceneIndexStats("idx3"), "indices.idx3.indexing.docs_indexed_total", 30L);
        } catch (ResponseException e) {
import java.util.concurrent.atomic.AtomicReference;
        }  
        assertCounter("parquet docs zero", p, "indices.empty-idx.indexing.docs_indexed_total", 0L);  
            org.opensearch.common.xcontent.json.JsonXContent.jsonXContent,  
            while (keepQuerying.get()) {
            .prepareCreate("plain-idx")
            f.get(90, TimeUnit.SECONDS);
        indexDocs("lifecycle-idx", 100, 0);
        // Delete and recreate same name.
        refreshIndex("idx1");
        client().admin().indices().prepareDelete(idx).get();
        assertEquals(260L, parquetDocs);  
}  
        final int docsPerThread = 250;
        assertCounter("parquet idx3", parquetIndexStats("idx3"), "indices.idx3.indexing.docs_indexed_total", 30L);
            );
                    .put(org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            int code = e.getResponse().getStatusLine().getStatusCode();
        assertEquals(50L, parquetDocs);  
            assertCounterAtLeast("stage 5 parquet merge_input_files", r5, "indices.lifecycle-idx.merge.merge_input_files_total", 2L);
        assertEquals("both formats must observe identical doc count", parquetDocs, luceneDocs);
        }  
        // Stage 6 — final cross-format consistency  
        }
     */
            );  
        assertCounter("parquet merge_total zero", p, "indices.empty-idx.merge.merge_total", 0L);
    }
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import java.util.Map;  
        long v1Lucene = getCounter(luceneIndexStats("accumulate-idx"), "indices.accumulate-idx.indexing.docs_indexed_total");  
        // Both stats endpoints must return HTTP 200 with no parquet/lucene tracker data for this index.  
    }
        refreshIndex("lifecycle-idx");
    public void testEmptyIndexAllCountersZero() throws Exception {
    /**
                l5,
        // explicit zeros rather than omitting fields).
            indexDocs("lifecycle-idx", 40, 100 + (batch - 1) * 40);
     * the end of the test.
        for (int i = 0; i < 5; i++) {
        try {  
                "stage 5 lucene merge_total >= 1 (composite force_merge dispatches to lucene merger too)",
        // All failure counters zero in happy path
        for (int t = 0; t < threadCount; t++) {
        // Accepting -1 OR 0 makes the assertion robust to future shape changes (e.g., emitting
        assertCounter("stage 4 lucene docs accumulate", l4, "indices.lifecycle-idx.indexing.docs_indexed_total", 260L);
    public void testConcurrentIndexingAccuracy() throws Exception {  
        assertEquals("parquet docs accumulate exactly", v1Parquet + 70L, v2Parquet);
import java.util.concurrent.Executors;  
     * same name. Catches tracker leaks in the per-format provider registry.
                    }
        indexDocs("idx2", 20, 0);
        }, 30, java.util.concurrent.TimeUnit.SECONDS);
        assertEquals("lucene docs accumulate exactly", v1Lucene + 70L, v2Lucene);  
            "indices." + idx + ".native_write.native_write_total",
            Map<String, Object> l5 = luceneIndexStats("lifecycle-idx");  
                "stage 5 parquet row_id_mapping_max equals merged row count",
     */
        refreshIndex("plain-idx");
            );
    }  
    /**
        ExecutorService pool = Executors.newFixedThreadPool(threadCount);
        // Single querier thread: read-then-update of `lastSeen` is safe without compare-and-swap
        Map<String, Object> wildcardBody = org.opensearch.common.xcontent.XContentHelper.convertToMap(
        forceMerge("lifecycle-idx", 1);  
    /**  
        long parquetDocs = getCounter(rf, "indices.lifecycle-idx.indexing.docs_indexed_total");  
import org.opensearch.client.Request;
        Map<String, Object> l = luceneIndexStats("plain-idx");
        assertCounter(
 * Tests counter accuracy across indexing, refresh, flush, merge stages and REST contract negatives.  
                    long prev = lastSeen.get();
 * this file be licensed under the Apache-2.0 license or a
            // row_id_mapping_max equals the largest merge output's row count for this shard;
        for (int batch = 1; batch <= 4; batch++) {  
import java.util.concurrent.TimeUnit;
            parquetIndexStats(idx),
        // Flush fires lucene flush+commit; parquet does not have a flush counter (it finalizes per refresh).  
            );
        createCompositeIndex(idx, true);  
            fail("expected 400 for unknown format");
        // Stage 1 — index 100 docs (no refresh yet)  
                    queryError.set(t);  
        Map<String, Object> l1 = luceneIndexStats("lifecycle-idx");  
            .setMapping("name", "type=keyword")
     * Verifies that parquet primary and lucene secondary see the same operations.
     * Verifies that a plain Lucene index (no composite engine) returns 200 with effectively-empty stats.
                    Map<String, Object> r = parquetIndexStats(idx);  
        assertTrue("lucene docs must be absent (-1) or 0 for non-composite index, got " + luceneDocs, luceneDocs <= 0L);  
        long luceneDocs = getCounter(l, "indices.cross-format-idx.indexing.docs_indexed_total");
    }
        Response successResponse = getRaw("/_plugins/parquet/contract-idx/_stats");
        assertCounter("parquet vsr_rotations_total zero", p, "indices.empty-idx.vsr.vsr_rotations_total", 0L);
        // Same for lucene. Note: index creation may trigger an initial commit, so commit_total may be 0 or 1.
        indexDocs("contract-idx", 5, 0);
            assertEquals(405, e.getResponse().getStatusLine().getStatusCode());
import java.util.concurrent.atomic.AtomicLong;
        );
        assertCounter("post-recreate parquet docs zero", parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total", 0L);  
     * Verifies that stats for multiple indices are isolated — querying one index
            assertCounter("stage 5 parquet merge_failures", r5, "indices.lifecycle-idx.merge.merge_failures", 0L);
public class StatsLifecycleIT extends BaseStatsIT {
    public void testMultipleIndicesIsolation() throws Exception {
        // 4. Verify a successful all-shards query returns proper structure.
        assertCounter(
        refreshIndex(idx);
        assertTrue("parquet docs must be absent (-1) or 0 for non-composite index, got " + parquetDocs, parquetDocs <= 0L);
                "stage 5 lucene flush_force_merge_time_millis",
            // flush.flush_force_merge_time_millis also records time spent in the internal
            "lucene final must match",  
        assertCounter("pre-delete parquet docs", parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total", 100L);
import org.opensearch.client.Response;
            .setSettings(  
        assertCounterAtLeast("stage 2 native_finalize", r2, "indices.lifecycle-idx.native_write.native_finalize_total", 1L);
            (long) totalDocs  
        assertCounterAtLeast("stage 2 lucene refresh_total", l2, "indices.lifecycle-idx.refresh.refresh_total", 1L);
                    throw new RuntimeException("thread " + threadId + " failed", e);  
        Map<String, Object> p = parquetIndexStats("plain-idx");
     * is in flight and asserts the docs_indexed_total counter never goes backwards. This is a
     * <p>A separate querier thread polls the stats endpoint at ~1ms intervals while indexing  
                    return;
        assertEquals("cross-format doc count must match", parquetDocs, luceneDocs);
     * Verifies that stats counters reset to 0 when an index is deleted and recreated with the  
                "indices.lifecycle-idx.flush.flush_force_merge_time_millis",  
    public void testRESTContractNegatives() throws Exception {
        // Release indexer threads.
        refreshIndex("contract-idx");
            luceneIndexStats(idx),
        // Post-condition: counters must be 0 — no carryover from the deleted index's tracker.
                        client().prepareIndex(idx).setSource("name", "doc_" + docId, "value", docId).get();  
            final int threadId = t;  
        );
                    Thread.currentThread().interrupt();  
        try {
        assertCounter("parquet idx2", parquetIndexStats("idx2"), "indices.idx2.indexing.docs_indexed_total", 20L);  
                0L
        );
                    for (int i = 0; i < docsPerThread; i++) {
     */
        assertCounter("lucene merge_total zero", l, "indices.empty-idx.merge.merge_total", 0L);
    public void testCountersAccumulateAcrossOperations() throws Exception {
            assertCounterAtLeast("stage 5 parquet merge_total", r5, "indices.lifecycle-idx.merge.merge_total", 1L);  
     * complete, docs_indexed_total must be exactly 1000.
     */
        // 1. Unknown format -> 400
        assertCounter("lucene idx1", luceneIndexStats("idx1"), "indices.idx1.indexing.docs_indexed_total", 10L);
        Map<String, Object> l0 = luceneIndexStats("lifecycle-idx");  
        assertBusy(() -> {
        }  
            // after merging 5 batches of 40 docs (=260 total) on a single-shard index, max is 260.
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)
        createCompositeIndex("idx2", true);
        assertCounter("lucene refresh_total zero", l, "indices.empty-idx.refresh.refresh_total", 0L);  
        // Stage 0 — fresh index
                }
 * compatible open source license.
        // Multiple parquet files are needed for force_merge to actually invoke a parquet merge:
        String idx = "reset-on-delete-idx";
        long parquetDocs = getCounter(p, "indices.cross-format-idx.indexing.docs_indexed_total");  
        Map<String, Object> l4 = luceneIndexStats("lifecycle-idx");  
    }
 *
        assertCounter("stage 0 native_write", r0, "indices.lifecycle-idx.native_write.native_write_total", 0L);
        indexDocs("idx3", 30, 0);  
        assertCounter("happy parquet merge_failures", rf, "indices.lifecycle-idx.merge.merge_failures", 0L);  
        // Index some docs — these go to plain Lucene, not DFA.  
                    start.await();  
        long v1Parquet = getCounter(parquetIndexStats("accumulate-idx"), "indices.accumulate-idx.indexing.docs_indexed_total");
                    }
            parquetIndexStats(idx),
                        int docId = threadId * docsPerThread + i;
            fail("expected 405 for POST");  
                    Thread.sleep(1);
        pool.shutdown();  
        assertTrue("response must have 'indices' key", wildcardBody.containsKey("indices"));
        indexDocs(idx, 100, 0);  
        AtomicLong lastSeen = new AtomicLong(0);  
                } catch (Throwable t) {
 * @opensearch.experimental
import org.opensearch.client.ResponseException;  
     */  
            // Lucene merger fires per shard during composite force_merge — CompositeMerger
        Map<String, Object> r1 = parquetIndexStats("lifecycle-idx");
     * Verifies a freshly-created index with no operations has all counters at zero.  
import java.util.concurrent.atomic.AtomicBoolean;  
        querier.start();
                    lastSeen.set(Math.max(prev, current));  
        assertTrue("response must contain 'indices' key", l.containsKey("indices"));
        // (We use a wildcard pattern; bare /_plugins/parquet/_stats is not a registered route.)  
    }  
        keepQuerying.set(false);
            }));  
                "indices.lifecycle-idx.merge.flush_and_sort_chunk_total",
        assertCounter("happy parquet native_write_failures", rf, "indices.lifecycle-idx.native_write.native_write_failures", 0L);
        try {
                l5,
     * Flagship accuracy test: walks through 7 stages of index lifecycle and asserts
        Map<String, Object> r4 = parquetIndexStats("lifecycle-idx");
        long luceneDocs = getCounter(lf, "indices.lifecycle-idx.indexing.docs_indexed_total");
        Map<String, Object> r0 = parquetIndexStats("lifecycle-idx");  
                        throw new AssertionError("counter went backwards: prev=" + prev + ", current=" + current);
        assertCounterAtLeast("stage 3 lucene commit", l3, "indices.lifecycle-idx.commit.commit_total", 1L);
        assertCounter("post-recreate lucene docs zero", luceneIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total", 0L);
        List<Future<?>> futures = new ArrayList<>();  
 * Integration tests for stats API lifecycle behavior on a single-node, single-shard topology.
            (long) totalDocs  
     */
        indexDocs("accumulate-idx", 70, 30);
                1L
            true
        refreshIndex("cross-format-idx");  
        long v1Refresh = getCounter(luceneIndexStats("accumulate-idx"), "indices.accumulate-idx.refresh.refresh_total");
     * nonexistent index, response shape, and content-type.  
        // Refresh fires native_finalize on parquet AND refresh_total on lucene.
        // Batch 1: 30 docs, refresh, capture v1
                return null;
        }
        long v2Parquet = getCounter(parquetIndexStats("accumulate-idx"), "indices.accumulate-idx.indexing.docs_indexed_total");  
            "indices." + idx + ".indexing.docs_indexed_total",
                    return;
        // Final accuracy check.  
                "indices.lifecycle-idx.merge.flush_and_sort_chunk_time_millis",
        createCompositeIndex("idx3", true);
            .get();  
        // Doc counters must be exactly v1 + 70.
        assertEquals(30L, v1Lucene);  
     *
        // Create index WITHOUT composite engine — plain Lucene only.
    }  
                } catch (Exception e) {
        assertCounterAtLeast("stage 4 lucene refresh count", l4, "indices.lifecycle-idx.refresh.refresh_total", 5L);
        long luceneDocs = getCounter(l, "indices.plain-idx.indexing.docs_indexed_total");
 * SPDX-License-Identifier: Apache-2.0
            // per-shard merge metrics — must populate after force_merge runs at least one merge.  
    /**
        assertEquals(30L, v1Parquet);
        Map<String, Object> l2 = luceneIndexStats("lifecycle-idx");  
        createCompositeIndex(idx, true);
            assertCounterAtLeast(
        assertCounter("parquet native_finalize_total zero", p, "indices.empty-idx.native_write.native_finalize_total", 0L);  
        assertCounterAtLeast("stage 2 native_write", r2, "indices.lifecycle-idx.native_write.native_write_total", 1L);
        assertCounterAtLeast("stage 1 parquet index_time", r1, "indices.lifecycle-idx.indexing.index_time_millis", 0L);
        // Pre-condition: counters reflect the indexed docs.  
                    if (current < prev) {  
            fail("expected 4xx for nonexistent index");
        // Stage 3 — flush
        // Verify no querier errors.
            }  
        } catch (ResponseException e) {  
        assertCounter("stage 4 parquet docs accumulate", r4, "indices.lifecycle-idx.indexing.docs_indexed_total", 260L);
        assertCounterAtLeast("parquet finalize after refresh", p, "indices.cross-format-idx.native_write.native_finalize_total", 1L);  
 */  
import java.util.List;
        Response wildcardResponse = getRaw("/_plugins/parquet/*/_stats");
        assertCounterAtLeast("stage 3 lucene flush", l3, "indices.lifecycle-idx.flush.flush_total", 1L);
    public void testCrossFormatConsistency() throws Exception {  
        flushIndex("cross-format-idx");
import java.util.concurrent.CountDownLatch;
        assertCounter(
        refreshIndex(idx);
        assertTrue("response must contain 'indices' key", p.containsKey("indices"));  
        }
        start.countDown();
            Map<String, Object> r5 = parquetIndexStats("lifecycle-idx");
        assertCounter("stage 0 lucene refresh", l0, "indices.lifecycle-idx.refresh.refresh_total", 0L);
        // 5. Content-Type assertion  
/**
            getRestClient().performRequest(new Request("GET", "/_plugins/orc/contract-idx/_stats"));  
    /**
        // Stage 5 — force_merge to 1 segment. Parquet merges asynchronously off the force_merge call,
        Map<String, Object> lf = luceneIndexStats("lifecycle-idx");
        assertCounter("happy lucene merge_failures", lf, "indices.lifecycle-idx.merge.merge_failures", 0L);
        refreshIndex("accumulate-idx");
        refreshIndex("idx3");  
        assertCounterAtLeast("lucene commit after flush", l, "indices.cross-format-idx.commit.commit_total", 1L);
    }  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertTrue("refresh_total must be at least 1 after batch 1", v1Refresh >= 1L);
        // Batch 2: 70 more docs, refresh, capture v2  
        });
        assertCounter("stage 1 lucene refresh_total", l1, "indices.lifecycle-idx.refresh.refresh_total", 0L);
import java.util.concurrent.ExecutorService;
        if (queryError.get() != null) {
                    .put(org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            assertCounter("stage 5 lucene merge_failures", l5, "indices.lifecycle-idx.merge.merge_failures", 0L);  
        for (Future<?> f : futures) {  
        assertTrue("lucene commit_total must be 0 or 1 for empty index, got " + commitTotal, commitTotal >= 0L && commitTotal <= 1L);
        createCompositeIndex("contract-idx", true);  
        client().admin()  
        }  
        assertTrue("Content-Type must be application/json, got: " + contentType, contentType.startsWith("application/json"));  
                1L
                    long current = getCounter(r, "indices." + idx + ".indexing.docs_indexed_total");
    public void testStatsLifecycle_SingleShard() throws Exception {
        // Concurrent stats queries while indexing — best-effort monotonicity check at ~1ms cadence.  
        long v2Lucene = getCounter(luceneIndexStats("accumulate-idx"), "indices.accumulate-idx.indexing.docs_indexed_total");
            refreshIndex("lifecycle-idx");
            assertCounterAtLeast(  
        Map<String, Object> p = parquetIndexStats("cross-format-idx");  
        assertCounter("stage 1 parquet docs", r1, "indices.lifecycle-idx.indexing.docs_indexed_total", 100L);  
     */
            // force-merge during flush.
        AtomicReference<Throwable> queryError = new AtomicReference<>();
        long parquetDocs = getCounter(p, "indices.plain-idx.indexing.docs_indexed_total");  
        long v2Refresh = getCounter(luceneIndexStats("accumulate-idx"), "indices.accumulate-idx.refresh.refresh_total");
     * Race-condition safety: 4 threads index 250 docs each concurrently. After all threads  
        assertCounterAtLeast("lucene refresh after refresh", l, "indices.cross-format-idx.refresh.refresh_total", 1L);
        String idx = "concurrent-idx";
        String contentType = successResponse.getEntity().getContentType();
        // Note: ParquetShardStats does NOT have docs_indexed_failures — only lucene does
import java.util.ArrayList;
                r5,
    /**
            assertTrue("expected 4xx, got " + code, code >= 400 && code < 500);
