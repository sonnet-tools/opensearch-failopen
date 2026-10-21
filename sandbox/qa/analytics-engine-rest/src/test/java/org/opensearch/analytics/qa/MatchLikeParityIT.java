            int batchNonMatching = 50 + random.nextInt(951);   // 50..1000
     * and {@code message LIKE '%alpha%'} both select these.
        return String.format(Locale.ROOT, "bulk(matching=%d, non=%d)", matching, nonMatching);
        "tango uniform victor whiskey",
        Request req = new Request("POST", "/" + INDEX_NAME + "/_flush");
    public void testMatchVsLikeParityAcrossRefreshFlushMerge() throws Exception {
            // multi-segment so the next query can exercise the multi-leaf path.
                flush();
 *   <li>Random-sized batch of matching + non-matching docs via {@code _bulk}.</li>
            + "}"
            } else {
    private void flush() throws IOException {
 * {@code OpenSearchTestCase}, so the seed is printed on failure. Re-run with
        assertEquals("PPL scalar count should return exactly 1 row for: " + ppl, 1, rows.size());
            order[j] = tmp;
    }
    private static final String[] MATCHING_TEMPLATES = new String[] {
    /**
        assertEquals("message LIKE '%" + TARGET + "%' count diverged from ground truth (" + ctx + ")", expectedMatching, likeCount);
 * via filter-delegation) and the native {@code LIKE '%target%'} query (executed directly
            if (random.nextInt(3) == 0) {
     * {@code alphabet}, {@code alphas}, etc. that would break the substring invariant.
        client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_refresh"));
                message = MATCHING_TEMPLATES[random.nextInt(MATCHING_TEMPLATES.length)];
     */
        }
    }
            + "  \"index.pluggable.dataformat\": \"composite\","
        assertEquals("match(message,'" + TARGET + "') count diverged from ground truth (" + ctx + ")", expectedMatching, matchCount);
        health.addParameter("timeout", "30s");
            client().performRequest(new Request("DELETE", "/" + INDEX_NAME));
     * The core assertion: both queries must return {@code expectedMatching}, and they must
            + "  \"number_of_replicas\": 0,"
 * matching docs ingested so far.
        req.addParameter("max_num_segments", String.valueOf(maxNumSegments));
    private void createCompositeIndex() throws IOException {
import org.opensearch.client.Request;
     *
 * <p><b>Reproducibility.</b> Uses {@link #randomLong()} from
        Object v = rows.get(0).get(0);
    // ── Helpers ────────────────────────────────────────────────────────────────
        "xray yankee zulu" };
     * the test's random schedule so each iteration's docs land in their own segment.
import java.util.List;
import java.util.Locale;
 */
 * against the one interleaving someone remembered.
                iter,
 * <ol>
 *   <li>Randomly flush (forces parquet write).</li>
     */
        for (int i = 0; i < matching; i++) order[i] = 1;
 *
        // Final force-merge-to-one and re-query. Historically the all-in-one-segment path
        // Shuffle (Fisher–Yates) so matching/non-matching docs don't cluster by position.
 * {@code ./gradlew :...:integTest -Dtests.seed=HEX} to reproduce.
                int target = 1 + random.nextInt(3); // 1..3 segments
        String ctx = "iter=" + iter + " expected_matching=" + expectedMatching + " match=" + matchCount + " like=" + likeCount;
            bulk.append("{\"message\":\"").append(escapeJson(message)).append("\"}\n");
        "juliet kilo alpha lima",
        long cumulativeNonMatching = 0L;
        "mike november alpha oscar papa",
        Request createIndex = new Request("PUT", "/" + INDEX_NAME);
    private void forceMerge(int maxNumSegments) throws IOException {
            }
 * generation misalignment in the filter-delegation path. This test randomizes ingest batch
        Response resp = client().performRequest(req);
        for (int iter = 0; iter < iterations; iter++) {
 * <p><b>Corpus design.</b> Every document's {@code message} is one of two families:
 * refresh/flush/merge cycles was the signal that surfaced the segment ordinal ↔ writer
        client().performRequest(req);
    /**
                phase
        health.addParameter("wait_for_status", "green");
            bulk.append("{\"index\":{}}\n");
 * compatible open source license.
     * @return a short tag describing the bulk size, for log lines.
                // Refresh again to pick up the merged segment view.
 * this file be licensed under the Apache-2.0 license or a
        "bravo alpha charlie",
 *   <li><i>Non-matching</i>: exclusively uses tokens that don't contain the target word as
                "iter={} ingest matching={} non_matching={} cumulative_matching={} cumulative_total={} phase={}",
            + "    \"message\": { \"type\": \"text\" }"
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "create index");
        int total = matching + nonMatching;
        }
            if (o == 1) {
        List<List<Object>> rows = (List<List<Object>>) parsed.get("datarows");
    private static final String TARGET = "alpha";
     * Run a PPL query expected to produce a single scalar count (one row, one column).
 * <ul>
 * drift keeps getting re-rolled on every run. A fixed-input regression test can only guard
        logger.info("MatchLikeParityIT seed={} (re-run with -Dtests.seed={})", seed, Long.toHexString(seed));
        client().performRequest(req);
            assertMatchAndLikeAgreeOnCount(iter, cumulativeMatching);
        long likeCount = queryScalarCount("source = " + INDEX_NAME + " | where message LIKE '%" + TARGET + "%' | stats count()");
        @SuppressWarnings("unchecked")
        createIndex.setJsonEntity(body);
public class MatchLikeParityIT extends AnalyticsRestTestCase {
        assertNotNull("PPL response missing `rows` for: " + ppl, rows);
            // Always refresh so the newly-ingested docs become searchable in this iteration.
        assertMatchAndLikeAgreeOnCount(iterations, cumulativeMatching);
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
 *       lowercases + whitespace-splits) and parquet {@code LIKE '%alpha%'} (substring on the
            if (random.nextInt(5) < 4) {
    private static final String INDEX_NAME = "match_like_parity";
            int j = random.nextInt(i + 1);
            }
        Map<String, Object> parsed = assertOkAndParse(resp, "bulk index");
        refresh();
            + "  \"index.pluggable.dataformat.enabled\": true,"
 *
 *
 * on parquet). The two paths walk independent code, so they must return the same row count
 *       (e.g. {@code "bravo alpha charlie"}). Both the Lucene analyzer (standard tokenizer
        "bravo charlie delta",
        for (int i = total - 1; i > 0; i--) {
        }
    private long queryScalarCount(String ppl) throws IOException {
            }
            + "\"mappings\": {"
            refresh();
 *   <li>Always refresh (so docs become searchable this iteration).</li>
/**
 *   <li><i>Matching</i>: the target token appears as a whole word, surrounded by spaces
/*
    }
            logger.info(
        createCompositeIndex();
            + "\"settings\": {"
                message = NON_MATCHING_TEMPLATES[random.nextInt(NON_MATCHING_TEMPLATES.length)];
                forceMerge(target);
        // hid the alignment bug because leaf index 0 happens to be the only option; this
     * Intentionally does <em>not</em> pass {@code refresh=true} — refresh is driven by
 *
                cumulativeMatching,
     */
        long cumulativeMatching = 0L;
    /**
        } catch (Exception ignored) {
import java.io.IOException;
        // ran before the single-leaf shortcut.
     * Bulk-indexes {@code matching + nonMatching} docs interleaved in a random order.
     * {@code LIKE '%alpha%'} both reject these. Deliberately avoids words like
package org.opensearch.analytics.qa;
        req.addParameter("force", "true");
        Map<String, Object> parsed = assertOkAndParse(client().performRequest(req), "PPL: " + ppl);
        "echo foxtrot golf",
            + "  \"number_of_shards\": 1,"
        "alpha quebec romeo",
            cumulativeMatching += batchMatching;
    }
            + "  \"properties\": {"
        "lima mike november oscar",
        Request req = new Request("POST", "/_plugins/_ppl");
     * Templates that contain none of {@code alpha} as a substring. {@code match} and
            int batchMatching = 50 + random.nextInt(951);      // 50..1000
        long matchCount = queryScalarCount("source = " + INDEX_NAME + " | where match(message, '" + TARGET + "') | stats count()");
    }
            + "},"
     */
        assertFalse("bulk response has errors=" + parsed, Boolean.TRUE.equals(errors));
                batchNonMatching,
        assertEquals("match and LIKE counts must agree (" + ctx + ")", matchCount, likeCount);
                cumulativeMatching + cumulativeNonMatching,
            int tmp = order[i];
    }
 *       {@code LIKE '%alpha%'} selects these.</li>
    private void refresh() throws IOException {
    }
        "sierra tango alpha uniform victor" };
        // step documents that the earlier assertions are meaningful precisely because they
        req.setJsonEntity(bulk.toString());
     * Templates where the target token appears as a whole word. {@code match(message, 'alpha')}
        "delta alpha echo foxtrot",
            // produce on-disk parquet segments.
        Random random = new Random(seed);
 * <p><b>What each iteration exercises.</b>
 * The OpenSearch Contributors require contributions made to
 * The two families are disjoint and exhaustive, so ground-truth is simply the count of
 */
            String phase = indexBatch(batchMatching, batchNonMatching, random);
            + "}";
 *       a substring (e.g. {@code "bravo charlie delta"}). Neither {@code match} nor
        String body = "{"
        int iterations = 4 + random.nextInt(9); // 4..12 inclusive
            );
        for (int o : order) {
 *       raw value) select these.</li>
            cumulativeNonMatching += batchNonMatching;
import org.opensearch.client.Response;
 * on a carefully-constructed corpus.
        forceMerge(1);
        logger.info("MatchLikeParityIT iterations={}", iterations);
            + "  }"
 *   <li>Run both queries and assert each equals the running ground-truth and equals each other.</li>
    private void assertMatchAndLikeAgreeOnCount(int iter, long expectedMatching) throws IOException {
            String message;
     */
 * sizes and the refresh/flush/merge schedule so the specific interleaving that caused the
        StringBuilder bulk = new StringBuilder(total * 64);
        Request req = new Request("POST", "/" + INDEX_NAME + "/_forcemerge");
 * <p><b>Why this exists.</b> Counts drifting between {@code match} and {@code LIKE} after
    /**
import java.util.Random;
     * so a failure message points at which side drifted.
 *
        try {
        "papa quebec romeo sierra",
        assertEquals(true, response.get("acknowledged"));
        assertNotNull("PPL scalar count value must not be null for: " + ppl, v);
            // Randomly flush to force parquet writes. Biased toward true so most iterations
        return ((Number) v).longValue();
        long seed = randomLong();
            + "  \"index.composite.primary_data_format\": \"parquet\","
 * </ol>
            order[i] = order[j];
                batchMatching,
 *       (exercises the merge-output writer-generation stamping and segment realignment).</li>
    /**
 * Randomized parity test between the delegated {@code match(...)} query (lowered to Lucene
 *   <li>Randomly force-merge to a random target segment count
}
    }
        client().performRequest(health);
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        "alpha golf hotel india",
        Boolean errors = (Boolean) parsed.get("errors");
 * </ul>
            // Randomly force-merge. Not all iterations — some leave the segment graph
     * agree with each other. We assert both separately (not just equality to each other)
    private String indexBatch(int matching, int nonMatching, Random random) throws IOException {
                refresh();
        Request req = new Request("POST", "/" + INDEX_NAME + "/_bulk");
            // index may not exist yet
    private static final String[] NON_MATCHING_TEMPLATES = new String[] {
        "hotel india juliet kilo",
        assertEquals("PPL scalar count should return exactly 1 column for: " + ppl, 1, rows.get(0).size());
        }
        int[] order = new int[total];
        req.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);
