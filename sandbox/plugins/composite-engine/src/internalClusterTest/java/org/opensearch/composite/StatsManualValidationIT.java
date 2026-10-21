        for (int batch = 0; batch < 4; batch++) {
        printAssertion("routing.primary == true", Boolean.TRUE.equals(routing.get("primary")));
        printAssertion("shards.0[0] has routing sub-object", routing != null);
        printAssertion("rayon.configured_threads > 0", ((Number) rayon.get("configured_threads")).longValue() > 0);
        );
        // Parquet merge is async; wait for counters to populate
 *       --tests "org.opensearch.composite.StatsManualValidationIT" \
 * the actual JSON responses to stdout for human verification. Logs a structured
            "lucene.indexing.docs_indexed_total == 260",
            "parquet.indexing.docs_indexed_total == 260",
        // Stage 2 — refresh
        printSection("STAGE 3: Flush — flush_total>=1, commit_total>=1");
        );
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)
            idx
        printAssertion(
 * </pre>
        printResponse("parquet (post-merge)", p5);
import java.util.Map;
        Map<String, Object> p5 = parquetIndexStats(idx);
        printAssertion("native_runtime block present at node level", firstNode.containsKey("native_runtime"));
import java.util.concurrent.TimeUnit;
        refreshIndex(idx);
        LOGGER.info("    >>> {}", label);
    // (forbidden-apis disallows direct System.out usage).
        Map<String, Object> nativeRuntime = (Map<String, Object>) firstNode.get("native_runtime");
        // — per-shard flush_and_sort_chunk and row_id_mapping_max
 * <p>Not part of the standard test suite; runs only when explicitly requested:
                LOGGER.info("    {}", line);
        LOGGER.info("════════════════════════════════════════════════════════════════════════");
        printAssertion("tokio.spawned_tasks_total > 0", ((Number) tokio.get("spawned_tasks_total")).longValue() > 0);
            getCounter(l5, "indices." + idx + ".flush.flush_force_merge_time_millis") > 0L
        // Note: lucene.merge.merge_total stays 0 in composite-engine flow because the
 * The OpenSearch Contributors require contributions made to
                l4,
        printAssertion("lucene.flush.flush_total >= 1", getCounter(l3, "indices." + idx + ".flush.flush_total") >= 1L);
        Map<String, Object> routing = (Map<String, Object>) shard0.get("routing");
        printResponse("parquet", p4);
        LOGGER.info("");
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            Map<String, Object> ignoreResp = parquetIndexStats(idx + ",no-such-idx", "ignore_unavailable", "true");
        // Stage 7 — index-level response must NOT have native_runtime
        // Stage 8 — shard-level routing sub-object
        // lucene secondary uses flush+addIndexes (not standalone IndexWriter.maybeMerge).
        } catch (Exception e) {
        assertBusy(() -> {
        // The lucene-side force-merge work is captured in flush.flush_force_merge_time_millis.
        // ─────────────────────────────────────────────────────────────────────────
        if (!ok) {
 *
        printAssertion(
/**
            "parquet.native_write.native_finalize_total >= 1",
        printAssertion(
        // ─────────────────────────────────────────────────────────────────────────
            )
            getCounter(p4, "indices." + idx + ".indexing.docs_indexed_total") == 260L
        printAssertion("routing.state is non-null", routing.get("state") != null);
        printAssertion("rayon.merge_tasks_completed >= 1", ((Number) rayon.get("merge_tasks_completed")).longValue() >= 1);
        LOGGER.info("    {}  {}", ok ? "✅" : "❌", label);
        printSection("STAGE 9: ?ignore_unavailable=true with mixed missing/available indices");
        Map<String, Object> nodeStats = parquetNodeStats("");
                "indices." + idx + ".indexing.docs_indexed_total"
        // ─────────────────────────────────────────────────────────────────────────
        printSection("MANUAL VALIDATION COMPLETE — all assertions verified");
        LOGGER.info("");
            getCounter(p4, "indices." + idx + ".indexing.docs_indexed_total") == getCounter(
}
        // ─────────────────────────────────────────────────────────────────────────
            Map<String, Object> r = parquetIndexStats(idx);
 *
            assertCounterAtLeast("parquet.merge.merge_total >= 1", r, "indices." + idx + ".merge.merge_total", 1L);
    public void testFullManualValidation() throws Exception {
        // ─────────────────────────────────────────────────────────────────────────
        printAssertion("tokio.num_workers > 0", ((Number) tokio.get("num_workers")).longValue() > 0);
        );
        printSection("STAGE 8: ?level=shards — verify routing sub-object");
        Map<String, Object> firstNode = (Map<String, Object>) nodes.values().iterator().next();
public class StatsManualValidationIT extends BaseStatsIT {
        printSection("STAGE 5: force_merge to 1 segment — rayon/tokio counters should engage");
        // ─────────────────────────────────────────────────────────────────────────
    }
        );
        printAssertion("parquet.merge.row_id_mapping_max == 260", getCounter(p5, "indices." + idx + ".merge.row_id_mapping_max") == 260L);
        printAssertion("lucene.refresh.refresh_total >= 1", getCounter(l2, "indices." + idx + ".refresh.refresh_total") >= 1L);
        printResponse("GET /_plugins/lucene/" + idx + "/_stats", luceneIndexStats(idx));
            refreshIndex(idx);
        );
import java.io.IOException;
        // ─────────────────────────────────────────────────────────────────────────
    }
            "cross-format consistency: parquet == lucene",
 *       -Dtests.verbose=true --info
        );
        // Stage 3 — flush
        }
 * Each println uses a stable header so the output is easy to grep through.
            getCounter(p5, "indices." + idx + ".merge.flush_and_sort_chunk_time_millis") >= 0L
        // ─────────────────────────────────────────────────────────────────────────
        Map<String, Object> l4 = luceneIndexStats(idx);
        indexDocs(idx, 100, 0);
        printAssertion("parquet.merge.merge_total >= 1", getCounter(p5, "indices." + idx + ".merge.merge_total") >= 1L);
 *   ./gradlew :sandbox:plugins:composite-engine:internalClusterTest \
        printAssertion("parquet.merge.merge_failures == 0", getCounter(p5, "indices." + idx + ".merge.merge_failures") == 0L);
        Map<String, Object> rayon = (Map<String, Object>) nativeRuntime.get("parquet_merge");
        }
        LOGGER.info("  {}", title);
        }
        printAssertion(
        // ─────────────────────────────────────────────────────────────────────────
            "parquet.merge.merge_output_rows_total == 260",
        printAssertion("lucene.merge.merge_failures == 0", getCounter(l5, "indices." + idx + ".merge.merge_failures") == 0L);
        printAssertion(
        // Stage 1 — index 100 docs (no refresh)
        // ─────────────────────────────────────────────────────────────────────────
import java.util.LinkedHashMap;
        String idx = "manual-idx";
        // ─────────────────────────────────────────────────────────────────────────
        LOGGER.info("════════════════════════════════════════════════════════════════════════");
        Map<String, Object> p2 = parquetIndexStats(idx);
    // ─────────────────────────────────────────────────────────────────────────────
        Map<String, Object> l5 = luceneIndexStats(idx);
        );
        printSection("STAGE 4: 4 more batches × 40 docs = 160 more (total=260)");
        // ─────────────────────────────────────────────────────────────────────────
 * compatible open source license.
        // ─────────────────────────────────────────────────────────────────────────
        printAssertion(
            LOGGER.info("    [error rendering body: {}]", e.getMessage());
            }
        printAssertion("index-level response does NOT have native_runtime", !indexBlock.containsKey("native_runtime"));
        // ─────────────────────────────────────────────────────────────────────────
            logger.error("ignore_unavailable threw", e);
        printSection("STAGE 6: /_nodes/_stats — native_runtime (rayon + tokio) must populate");
        printResponse("parquet", p1);
            "lucene.flush.flush_force_merge_time_millis > 0 (force-merge ran via flush path)",
    private static void printResponse(String label, Map<String, Object> body) {
    // ─────────────────────────────────────────────────────────────────────────────
        printAssertion(
        try {
            throw new AssertionError("assertion failed: " + label);
            "parquet.merge.merge_input_files_total > 1",
            Map<String, Object> ignoreIdx = (Map<String, Object>) ignoreResp.get("indices");
        printAssertion("lucene.commit.commit_total >= 1", getCounter(l3, "indices." + idx + ".commit.commit_total") >= 1L);
        Map<String, Object> shard0 = (Map<String, Object>) ((java.util.List<?>) shards.get("0")).get(0);
    private static final Logger LOGGER = LogManager.getLogger(StatsManualValidationIT.class);
 * SPDX-License-Identifier: Apache-2.0
        printResponse("lucene (post-merge)", l5);
        Map<String, Object> p1 = parquetIndexStats(idx);
 * report covering: all old per-shard/per-index/per-node counters, the new
        Map<String, Object> shardLevel = parquetIndexStats(idx, "level", "shards");
        // ─────────────────────────────────────────────────────────────────────────
        printAssertion(
        printSection("STAGE 1: Indexed 100 docs (no refresh) — docs_indexed_total=100, refresh_total=0");
        // ─────────────────────────────────────────────────────────────────────────
        printResponse("GET /_plugins/parquet/_nodes/_stats", nodeStats);
    // Output helpers — emit via Log4j so they appear in test logs
        try {
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> indices = (Map<String, Object>) p5.get("indices");
            getCounter(l4, "indices." + idx + ".indexing.docs_indexed_total") == 260L
        forceMerge(idx, 1);
        Map<String, Object> indexBlock = (Map<String, Object>) indices.get(idx);
        printAssertion("routing.node is non-null", routing.get("node") != null);
        printAssertion(
        printAssertion(
        );
        printAssertion(
        // ─────────────────────────────────────────────────────────────────────────
 * @opensearch.experimental
        printAssertion(
        printResponse("GET /_plugins/parquet/" + idx + "/_stats", parquetIndexStats(idx));
import org.apache.logging.log4j.LogManager;
 *
            printAssertion("ignore_unavailable=true did NOT throw", false);
 * routing sub-object, rayon/tokio native runtime stats, and filter behavior.
        printResponse("lucene", l1);
        // ─────────────────────────────────────────────────────────────────────────
        // Stage 6 — node-stats: native_runtime block must appear
            getCounter(p5, "indices." + idx + ".merge.merge_input_files_total") > 1L
        );
        printAssertion("lucene.refresh.refresh_total == 0", getCounter(l1, "indices." + idx + ".refresh.refresh_total") == 0L);
        )).get("shards");
            "parquet.merge.flush_and_sort_chunk_time_millis >= 0",
        printSection("STAGE 0: Empty index — all counters should be 0");
            printAssertion("ignore_unavailable=true does NOT include missing index", !ignoreIdx.containsKey("no-such-idx"));
        Map<String, Object> nodes = (Map<String, Object>) nodeStats.get("nodes");
 */
            String json = JsonXContent.contentBuilder().map(body == null ? new LinkedHashMap<>() : body).toString();
        // Stage 10 — final summary
            getCounter(p2, "indices." + idx + ".native_write.native_write_total") >= 1L
            "parquet.merge.flush_and_sort_chunk_total >= 1",
        printResponse("parquet", p2);
        printResponse("parquet ?level=shards", shardLevel);
        Map<String, Object> p4 = parquetIndexStats(idx);
    @SuppressWarnings("unchecked")
        } catch (IOException e) {
        Map<String, Object> shards = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) shardLevel.get("indices")).get(
        printResponse("lucene", l2);
 */
        // ─────────────────────────────────────────────────────────────────────────
        Map<String, Object> tokio = (Map<String, Object>) nativeRuntime.get("parquet_io");
            getCounter(p5, "indices." + idx + ".merge.merge_output_rows_total") == 260L
        printSection("STAGE 7: Index-level /{idx}/_stats must NOT contain native_runtime");
        }
        );
            "parquet.native_write.native_write_total >= 1",
        }, 30, TimeUnit.SECONDS);
        Map<String, Object> l2 = luceneIndexStats(idx);
        printAssertion("rayon.merge_tasks_submitted >= 1", ((Number) rayon.get("merge_tasks_submitted")).longValue() >= 1);
        printAssertion("rayon.merge_tasks_panicked == 0", ((Number) rayon.get("merge_tasks_panicked")).longValue() == 0);
            getCounter(l1, "indices." + idx + ".indexing.docs_indexed_total") == 100L
        Map<String, Object> l3 = luceneIndexStats(idx);
        );
        flushIndex(idx);
package org.opensearch.composite;
        Map<String, Object> l1 = luceneIndexStats(idx);
        // ─────────────────────────────────────────────────────────────────────────
        createCompositeIndex(idx, true);
        // ─────────────────────────────────────────────────────────────────────────
        );
            printAssertion("ignore_unavailable=true returns 200 with available index", ignoreIdx.containsKey(idx));
import org.apache.logging.log4j.Logger;
        // Stage 4 — index more in 4 batches with refreshes (5 segments total)
    }
        printResponse("lucene", l4);
import org.opensearch.common.xcontent.json.JsonXContent;
        // Stage 9 — filter params
            getCounter(p1, "indices." + idx + ".indexing.docs_indexed_total") == 100L
            getCounter(p2, "indices." + idx + ".native_write.native_finalize_total") >= 1L
        // Stage 0 — empty index
 * <pre>
        // ─────────────────────────────────────────────────────────────────────────
    private static void printAssertion(String label, boolean ok) {
        printResponse("lucene", l3);
            getCounter(p5, "indices." + idx + ".merge.flush_and_sort_chunk_total") >= 1L
        // Stage 5 — force_merge to 1 (triggers rayon/tokio paths)
    private static void printSection(String title) {
            "parquet.indexing.docs_indexed_total == 100",
            for (String line : json.split("\n")) {
        printSection("STAGE 2: Refresh — refresh_total=1, native_finalize_total>=1");
 *
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
/*
        printAssertion("lucene.commit.commit_failures == 0", getCounter(l5, "indices." + idx + ".commit.commit_failures") == 0L);
            "lucene.indexing.docs_indexed_total == 100",
 * Manual-validation IT — drives the full stats API surface end-to-end and prints
            indexDocs(idx, 40, 100 + batch * 40);
    }
