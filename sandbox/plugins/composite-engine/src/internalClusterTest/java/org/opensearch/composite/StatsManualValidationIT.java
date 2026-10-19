    private static void printAssertion(String label, boolean ok) {
 *       -Dtests.verbose=true --info
            "cross-format consistency: parquet == lucene",
        printSection("STAGE 1: Indexed 100 docs (no refresh) — docs_indexed_total=100, refresh_total=0");
        );
            "parquet.indexing.docs_indexed_total == 260",
/**  
        Map<String, Object> indexBlock = (Map<String, Object>) indices.get(idx);
            "parquet.merge.merge_output_rows_total == 260",
            }
            getCounter(l4, "indices." + idx + ".indexing.docs_indexed_total") == 260L
            getCounter(l1, "indices." + idx + ".indexing.docs_indexed_total") == 100L
        // ─────────────────────────────────────────────────────────────────────────  
        Map<String, Object> nodes = (Map<String, Object>) nodeStats.get("nodes");
        printAssertion("rayon.configured_threads > 0", ((Number) rayon.get("configured_threads")).longValue() > 0);
        // ─────────────────────────────────────────────────────────────────────────
        printAssertion("lucene.commit.commit_failures == 0", getCounter(l5, "indices." + idx + ".commit.commit_failures") == 0L);
        }
 * routing sub-object, rayon/tokio native runtime stats, and filter behavior.
        // ─────────────────────────────────────────────────────────────────────────  
            getCounter(p5, "indices." + idx + ".merge.flush_and_sort_chunk_time_millis") >= 0L
        printSection("STAGE 8: ?level=shards — verify routing sub-object");
        printResponse("parquet", p2);  
        printAssertion("index-level response does NOT have native_runtime", !indexBlock.containsKey("native_runtime"));
        printAssertion("lucene.refresh.refresh_total == 0", getCounter(l1, "indices." + idx + ".refresh.refresh_total") == 0L);  
        printAssertion("shards.0[0] has routing sub-object", routing != null);  
            indexDocs(idx, 40, 100 + batch * 40);  
        );  
            for (String line : json.split("\n")) {  
            getCounter(l5, "indices." + idx + ".flush.flush_force_merge_time_millis") > 0L  
        Map<String, Object> l3 = luceneIndexStats(idx);
            LOGGER.info("    [error rendering body: {}]", e.getMessage());
                "indices." + idx + ".indexing.docs_indexed_total"
        printSection("STAGE 6: /_nodes/_stats — native_runtime (rayon + tokio) must populate");
        // ─────────────────────────────────────────────────────────────────────────
        // ─────────────────────────────────────────────────────────────────────────
        // Stage 7 — index-level response must NOT have native_runtime  
        // Note: lucene.merge.merge_total stays 0 in composite-engine flow because the
        // ─────────────────────────────────────────────────────────────────────────
        Map<String, Object> indices = (Map<String, Object>) p5.get("indices");  
        assertBusy(() -> {
    }  
 *       --tests "org.opensearch.composite.StatsManualValidationIT" \  
}
        Map<String, Object> l1 = luceneIndexStats(idx);
 *   ./gradlew :sandbox:plugins:composite-engine:internalClusterTest \
 * Manual-validation IT — drives the full stats API surface end-to-end and prints
        Map<String, Object> p5 = parquetIndexStats(idx);  
            getCounter(p4, "indices." + idx + ".indexing.docs_indexed_total") == getCounter(
        printResponse("lucene", l4);  
            "parquet.merge.flush_and_sort_chunk_time_millis >= 0",
    }
        LOGGER.info("════════════════════════════════════════════════════════════════════════");
        printAssertion(
        LOGGER.info("    >>> {}", label);  
 * Each println uses a stable header so the output is easy to grep through.
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        // Stage 2 — refresh  
        printSection("STAGE 9: ?ignore_unavailable=true with mixed missing/available indices");
        Map<String, Object> firstNode = (Map<String, Object>) nodes.values().iterator().next();
        // Stage 3 — flush
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    private static void printSection(String title) {  
            getCounter(p4, "indices." + idx + ".indexing.docs_indexed_total") == 260L  
        printResponse("GET /_plugins/lucene/" + idx + "/_stats", luceneIndexStats(idx));
        );
        Map<String, Object> l2 = luceneIndexStats(idx);
 * report covering: all old per-shard/per-index/per-node counters, the new  
        printAssertion(
        } catch (Exception e) {
import org.apache.logging.log4j.Logger;
        // Stage 9 — filter params  
        printResponse("lucene", l2);
        // ─────────────────────────────────────────────────────────────────────────  
        printResponse("lucene", l1);  
        );
        // Stage 10 — final summary
        );
            "parquet.indexing.docs_indexed_total == 100",
        // ─────────────────────────────────────────────────────────────────────────
        // lucene secondary uses flush+addIndexes (not standalone IndexWriter.maybeMerge).
        // ─────────────────────────────────────────────────────────────────────────
        printAssertion("routing.node is non-null", routing.get("node") != null);
        LOGGER.info("════════════════════════════════════════════════════════════════════════");
            logger.error("ignore_unavailable threw", e);
        printAssertion("rayon.merge_tasks_panicked == 0", ((Number) rayon.get("merge_tasks_panicked")).longValue() == 0);
        printAssertion("lucene.refresh.refresh_total >= 1", getCounter(l2, "indices." + idx + ".refresh.refresh_total") >= 1L);
            "parquet.merge.flush_and_sort_chunk_total >= 1",  
        printSection("MANUAL VALIDATION COMPLETE — all assertions verified");
 * <pre>
        printAssertion(  
        // ─────────────────────────────────────────────────────────────────────────
                LOGGER.info("    {}", line);
        );
        );  
        Map<String, Object> shardLevel = parquetIndexStats(idx, "level", "shards");
 *
        printResponse("lucene", l3);  
        // ─────────────────────────────────────────────────────────────────────────
        Map<String, Object> routing = (Map<String, Object>) shard0.get("routing");
        // — per-shard flush_and_sort_chunk and row_id_mapping_max
        printAssertion(  
        } catch (IOException e) {  
 * this file be licensed under the Apache-2.0 license or a
 *
            "lucene.indexing.docs_indexed_total == 100",  
            "parquet.native_write.native_write_total >= 1",  
        printResponse("GET /_plugins/parquet/" + idx + "/_stats", parquetIndexStats(idx));
        printAssertion("rayon.merge_tasks_completed >= 1", ((Number) rayon.get("merge_tasks_completed")).longValue() >= 1);  
 */  
 * <p>Not part of the standard test suite; runs only when explicitly requested:  
        LOGGER.info("");
        printAssertion("lucene.flush.flush_total >= 1", getCounter(l3, "indices." + idx + ".flush.flush_total") >= 1L);
            "parquet.merge.merge_input_files_total > 1",  
                l4,  
        flushIndex(idx);
            )
        // ─────────────────────────────────────────────────────────────────────────  
 * </pre>
            getCounter(p5, "indices." + idx + ".merge.flush_and_sort_chunk_total") >= 1L
        Map<String, Object> rayon = (Map<String, Object>) nativeRuntime.get("parquet_merge");
        printAssertion("parquet.merge.merge_failures == 0", getCounter(p5, "indices." + idx + ".merge.merge_failures") == 0L);  
        printAssertion("tokio.spawned_tasks_total > 0", ((Number) tokio.get("spawned_tasks_total")).longValue() > 0);  
        printResponse("lucene (post-merge)", l5);  
 * compatible open source license.
import java.util.Map;  
    public void testFullManualValidation() throws Exception {
        // The lucene-side force-merge work is captured in flush.flush_force_merge_time_millis.  
        Map<String, Object> shards = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) shardLevel.get("indices")).get(
        // ─────────────────────────────────────────────────────────────────────────  
        printAssertion("parquet.merge.row_id_mapping_max == 260", getCounter(p5, "indices." + idx + ".merge.row_id_mapping_max") == 260L);
        indexDocs(idx, 100, 0);
        if (!ok) {
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)
        printSection("STAGE 0: Empty index — all counters should be 0");  
 * SPDX-License-Identifier: Apache-2.0
            getCounter(p2, "indices." + idx + ".native_write.native_finalize_total") >= 1L
        // ─────────────────────────────────────────────────────────────────────────  
        LOGGER.info("");
        printAssertion("native_runtime block present at node level", firstNode.containsKey("native_runtime"));  
        printResponse("parquet ?level=shards", shardLevel);  
    // Output helpers — emit via Log4j so they appear in test logs
            getCounter(p2, "indices." + idx + ".native_write.native_write_total") >= 1L
        refreshIndex(idx);  
        printSection("STAGE 5: force_merge to 1 segment — rayon/tokio counters should engage");
        Map<String, Object> p4 = parquetIndexStats(idx);  
            printAssertion("ignore_unavailable=true did NOT throw", false);  
        Map<String, Object> nodeStats = parquetNodeStats("");
import org.apache.logging.log4j.LogManager;
        forceMerge(idx, 1);  
    // ─────────────────────────────────────────────────────────────────────────────
        // Stage 5 — force_merge to 1 (triggers rayon/tokio paths)  
            "parquet.native_write.native_finalize_total >= 1",
        printSection("STAGE 2: Refresh — refresh_total=1, native_finalize_total>=1");
        Map<String, Object> p2 = parquetIndexStats(idx);
        printAssertion(
        printAssertion("parquet.merge.merge_total >= 1", getCounter(p5, "indices." + idx + ".merge.merge_total") >= 1L);
    @SuppressWarnings("unchecked")
        printAssertion("routing.state is non-null", routing.get("state") != null);  
        );
            Map<String, Object> ignoreIdx = (Map<String, Object>) ignoreResp.get("indices");
        LOGGER.info("  {}", title);  
        }
            refreshIndex(idx);
        // ─────────────────────────────────────────────────────────────────────────
        printResponse("parquet", p1);
        // Stage 1 — index 100 docs (no refresh)
/*  
import java.util.concurrent.TimeUnit;
 *
        printAssertion(  
        // ─────────────────────────────────────────────────────────────────────────
        printResponse("parquet (post-merge)", p5);
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
            Map<String, Object> r = parquetIndexStats(idx);  
        // Stage 4 — index more in 4 batches with refreshes (5 segments total)
        printAssertion(
        LOGGER.info("    {}  {}", ok ? "✅" : "❌", label);  
        Map<String, Object> p1 = parquetIndexStats(idx);  
        Map<String, Object> tokio = (Map<String, Object>) nativeRuntime.get("parquet_io");  
        String idx = "manual-idx";  
            throw new AssertionError("assertion failed: " + label);
        // ─────────────────────────────────────────────────────────────────────────
    }
        try {
            getCounter(p5, "indices." + idx + ".merge.merge_input_files_total") > 1L
        printSection("STAGE 7: Index-level /{idx}/_stats must NOT contain native_runtime");
import java.util.LinkedHashMap;
            printAssertion("ignore_unavailable=true returns 200 with available index", ignoreIdx.containsKey(idx));  
        printAssertion("lucene.commit.commit_total >= 1", getCounter(l3, "indices." + idx + ".commit.commit_total") >= 1L);
    private static void printResponse(String label, Map<String, Object> body) {
        try {  
        // ─────────────────────────────────────────────────────────────────────────
        // ─────────────────────────────────────────────────────────────────────────
            getCounter(p5, "indices." + idx + ".merge.merge_output_rows_total") == 260L
        // Stage 8 — shard-level routing sub-object
        printAssertion(
    private static final Logger LOGGER = LogManager.getLogger(StatsManualValidationIT.class);
            assertCounterAtLeast("parquet.merge.merge_total >= 1", r, "indices." + idx + ".merge.merge_total", 1L);
 *  
        printAssertion("lucene.merge.merge_failures == 0", getCounter(l5, "indices." + idx + ".merge.merge_failures") == 0L);
        // ─────────────────────────────────────────────────────────────────────────
        printAssertion(
        // Stage 6 — node-stats: native_runtime block must appear
        }
            printAssertion("ignore_unavailable=true does NOT include missing index", !ignoreIdx.containsKey("no-such-idx"));
        printAssertion("tokio.num_workers > 0", ((Number) tokio.get("num_workers")).longValue() > 0);
        );
        Map<String, Object> shard0 = (Map<String, Object>) ((java.util.List<?>) shards.get("0")).get(0);
        );  
        printSection("STAGE 3: Flush — flush_total>=1, commit_total>=1");  
 * @opensearch.experimental  
            idx
        // ─────────────────────────────────────────────────────────────────────────
package org.opensearch.composite;
            "lucene.flush.flush_force_merge_time_millis > 0 (force-merge ran via flush path)",
        printResponse("GET /_plugins/parquet/_nodes/_stats", nodeStats);  
            String json = JsonXContent.contentBuilder().map(body == null ? new LinkedHashMap<>() : body).toString();
        );  
        // Stage 0 — empty index
        Map<String, Object> l4 = luceneIndexStats(idx);
        printSection("STAGE 4: 4 more batches × 40 docs = 160 more (total=260)");
 * the actual JSON responses to stdout for human verification. Logs a structured
    }
        printResponse("parquet", p4);
        Map<String, Object> l5 = luceneIndexStats(idx);
        createCompositeIndex(idx, true);
public class StatsManualValidationIT extends BaseStatsIT {  
        for (int batch = 0; batch < 4; batch++) {
        )).get("shards");  
        printAssertion(
        printAssertion(  
        printAssertion(
 */
        // ─────────────────────────────────────────────────────────────────────────  
        Map<String, Object> nativeRuntime = (Map<String, Object>) firstNode.get("native_runtime");
            getCounter(p1, "indices." + idx + ".indexing.docs_indexed_total") == 100L  
            Map<String, Object> ignoreResp = parquetIndexStats(idx + ",no-such-idx", "ignore_unavailable", "true");
        // Parquet merge is async; wait for counters to populate
            "lucene.indexing.docs_indexed_total == 260",  
        }  
        );
        }, 30, TimeUnit.SECONDS);
    // (forbidden-apis disallows direct System.out usage).  
        printAssertion("routing.primary == true", Boolean.TRUE.equals(routing.get("primary")));
    // ─────────────────────────────────────────────────────────────────────────────
        printAssertion("rayon.merge_tasks_submitted >= 1", ((Number) rayon.get("merge_tasks_submitted")).longValue() >= 1);
import org.opensearch.common.xcontent.json.JsonXContent;  
