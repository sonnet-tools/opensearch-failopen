     *  
 * on parquet). The two paths walk independent code, so they must return the same row count
package org.opensearch.analytics.qa;
    public void testMatchVsLikeParityAcrossRefreshFlushMerge() throws Exception {
 *  
 * <ul>  
        return String.format(Locale.ROOT, "bulk(matching=%d, non=%d)", matching, nonMatching);  
 * </ol>
        long matchCount = queryScalarCount("source = " + INDEX_NAME + " | where match(message, '" + TARGET + "') | stats count()");
            } else {
import java.util.Random;
        assertFalse("bulk response has errors=" + parsed, Boolean.TRUE.equals(errors));
import org.opensearch.client.Request;
            int batchMatching = 50 + random.nextInt(951);      // 50..1000  
import java.util.List;
 * {@code ./gradlew :...:integTest -Dtests.seed=HEX} to reproduce.  
        "alpha golf hotel india",
        assertEquals("match(message,'" + TARGET + "') count diverged from ground truth (" + ctx + ")", expectedMatching, matchCount);
                "iter={} ingest matching={} non_matching={} cumulative_matching={} cumulative_total={} phase={}",
 * <p><b>Reproducibility.</b> Uses {@link #randomLong()} from
        assertEquals("message LIKE '%" + TARGET + "%' count diverged from ground truth (" + ctx + ")", expectedMatching, likeCount);  
            );  
            + "}";
     * the test's random schedule so each iteration's docs land in their own segment.
        assertEquals(true, response.get("acknowledged"));  
     * and {@code message LIKE '%alpha%'} both select these.  
 *
    }  
                // Refresh again to pick up the merged segment view.
    }
        "papa quebec romeo sierra",  
                phase
                iter,  
                forceMerge(target);  
        req.addParameter("max_num_segments", String.valueOf(maxNumSegments));  
        Request req = new Request("POST", "/" + INDEX_NAME + "/_flush");
    }
        client().performRequest(health);
        assertEquals("PPL scalar count should return exactly 1 row for: " + ppl, 1, rows.size());
                batchNonMatching,
        }
                batchMatching,
                cumulativeMatching,  
            + "\"settings\": {"  
 * compatible open source license.
        for (int i = 0; i < matching; i++) order[i] = 1;  
 * refresh/flush/merge cycles was the signal that surfaced the segment ordinal ↔ writer
     * {@code alphabet}, {@code alphas}, etc. that would break the substring invariant.
        long likeCount = queryScalarCount("source = " + INDEX_NAME + " | where message LIKE '%" + TARGET + "%' | stats count()");
        Request req = new Request("POST", "/" + INDEX_NAME + "/_forcemerge");
            int j = random.nextInt(i + 1);  
                message = MATCHING_TEMPLATES[random.nextInt(MATCHING_TEMPLATES.length)];
 * generation misalignment in the filter-delegation path. This test randomizes ingest batch  
        logger.info("MatchLikeParityIT iterations={}", iterations);  
 * against the one interleaving someone remembered.  
        "bravo alpha charlie",  
        String body = "{"
     * Templates that contain none of {@code alpha} as a substring. {@code match} and  
            // Always refresh so the newly-ingested docs become searchable in this iteration.
 *   <li>Randomly force-merge to a random target segment count
            // index may not exist yet
import org.opensearch.client.Response;
        Request req = new Request("POST", "/" + INDEX_NAME + "/_bulk");  
        Map<String, Object> parsed = assertOkAndParse(client().performRequest(req), "PPL: " + ppl);
    /**
    private void refresh() throws IOException {  
            // Randomly force-merge. Not all iterations — some leave the segment graph
            // produce on-disk parquet segments.  
     */  
        // hid the alignment bug because leaf index 0 happens to be the only option; this  
        "mike november alpha oscar papa",
 * <p><b>Corpus design.</b> Every document's {@code message} is one of two families:
                cumulativeMatching + cumulativeNonMatching,
 * on a carefully-constructed corpus.
    // ── Helpers ────────────────────────────────────────────────────────────────
 * this file be licensed under the Apache-2.0 license or a
        List<List<Object>> rows = (List<List<Object>>) parsed.get("datarows");  
    /**
 *  
        "tango uniform victor whiskey",
    }
        health.addParameter("timeout", "30s");
    private static final String[] NON_MATCHING_TEMPLATES = new String[] {
 *   <li>Always refresh (so docs become searchable this iteration).</li>  
        "sierra tango alpha uniform victor" };  
        for (int i = total - 1; i > 0; i--) {
     */
        // step documents that the earlier assertions are meaningful precisely because they
     */  
 *   <li><i>Non-matching</i>: exclusively uses tokens that don't contain the target word as
        @SuppressWarnings("unchecked")
            order[j] = tmp;  
import java.util.Map;
        Request createIndex = new Request("PUT", "/" + INDEX_NAME);  
 * sizes and the refresh/flush/merge schedule so the specific interleaving that caused the
                refresh();
            cumulativeNonMatching += batchNonMatching;
        Request req = new Request("POST", "/_plugins/_ppl");
            }
    }
            + "  \"number_of_shards\": 1,"
            int batchNonMatching = 50 + random.nextInt(951);   // 50..1000
        Map<String, Object> parsed = assertOkAndParse(resp, "bulk index");  
        "echo foxtrot golf",  
     * so a failure message points at which side drifted.
            + "    \"message\": { \"type\": \"text\" }"
            + "  \"index.pluggable.dataformat.enabled\": true,"  
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "create index");
            + "\"mappings\": {"
        // Shuffle (Fisher–Yates) so matching/non-matching docs don't cluster by position.
 *       lowercases + whitespace-splits) and parquet {@code LIKE '%alpha%'} (substring on the  
    private long queryScalarCount(String ppl) throws IOException {
 * {@code OpenSearchTestCase}, so the seed is printed on failure. Re-run with
        // Final force-merge-to-one and re-query. Historically the all-in-one-segment path
            bulk.append("{\"message\":\"").append(escapeJson(message)).append("\"}\n");  
import java.io.IOException;
        "lima mike november oscar",
    private void assertMatchAndLikeAgreeOnCount(int iter, long expectedMatching) throws IOException {  
            client().performRequest(new Request("DELETE", "/" + INDEX_NAME));  
        "delta alpha echo foxtrot",
        Boolean errors = (Boolean) parsed.get("errors");
        client().performRequest(req);
 * via filter-delegation) and the native {@code LIKE '%target%'} query (executed directly  
 *   <li>Run both queries and assert each equals the running ground-truth and equals each other.</li>
            + "  \"index.composite.primary_data_format\": \"parquet\","
     * {@code LIKE '%alpha%'} both reject these. Deliberately avoids words like
        }  
        health.addParameter("wait_for_status", "green");  
        } catch (Exception ignored) {
            // multi-segment so the next query can exercise the multi-leaf path.  
        assertEquals("match and LIKE counts must agree (" + ctx + ")", matchCount, likeCount);
        logger.info("MatchLikeParityIT seed={} (re-run with -Dtests.seed={})", seed, Long.toHexString(seed));
            + "  \"properties\": {"  
            if (random.nextInt(3) == 0) {
        req.addParameter("force", "true");  
 *   <li>Randomly flush (forces parquet write).</li>
 * drift keeps getting re-rolled on every run. A fixed-input regression test can only guard
}
 * <p><b>Why this exists.</b> Counts drifting between {@code match} and {@code LIKE} after
    }
    }  
        forceMerge(1);  
            if (random.nextInt(5) < 4) {
        for (int o : order) {
            logger.info(
     */
 *
     * Templates where the target token appears as a whole word. {@code match(message, 'alpha')}
    private static final String INDEX_NAME = "match_like_parity";
        "juliet kilo alpha lima",  
     * Intentionally does <em>not</em> pass {@code refresh=true} — refresh is driven by
    private static final String TARGET = "alpha";
        "hotel india juliet kilo",
        createIndex.setJsonEntity(body);
            }  
        Random random = new Random(seed);  
        assertMatchAndLikeAgreeOnCount(iterations, cumulativeMatching);
        try {
import java.util.Locale;  
        String ctx = "iter=" + iter + " expected_matching=" + expectedMatching + " match=" + matchCount + " like=" + likeCount;
 *   <li><i>Matching</i>: the target token appears as a whole word, surrounded by spaces
 *
            + "  \"index.composite.secondary_data_formats\": \"lucene\""  
    private void createCompositeIndex() throws IOException {
            bulk.append("{\"index\":{}}\n");
     * @return a short tag describing the bulk size, for log lines.
     * agree with each other. We assert both separately (not just equality to each other)  
            + "  }"
 *       raw value) select these.</li>
    /**
            String message;
            String phase = indexBatch(batchMatching, batchNonMatching, random);  
        assertEquals("PPL scalar count should return exactly 1 column for: " + ppl, 1, rows.get(0).size());  
 *       {@code LIKE '%alpha%'} selects these.</li>
                int target = 1 + random.nextInt(3); // 1..3 segments
    private void forceMerge(int maxNumSegments) throws IOException {
        createCompositeIndex();  
        long seed = randomLong();
    private static final String[] MATCHING_TEMPLATES = new String[] {
        assertNotNull("PPL response missing `rows` for: " + ppl, rows);
 *   <li>Random-sized batch of matching + non-matching docs via {@code _bulk}.</li>
        }  
        refresh();
            cumulativeMatching += batchMatching;
     * Bulk-indexes {@code matching + nonMatching} docs interleaved in a random order.  
/*  
 * The two families are disjoint and exhaustive, so ground-truth is simply the count of  
    private String indexBatch(int matching, int nonMatching, Random random) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        int iterations = 4 + random.nextInt(9); // 4..12 inclusive
            order[i] = order[j];
        req.setJsonEntity(bulk.toString());
        long cumulativeNonMatching = 0L;  
        "bravo charlie delta",
            }  
        "alpha quebec romeo",
        int[] order = new int[total];
        return ((Number) v).longValue();  
    }
     * The core assertion: both queries must return {@code expectedMatching}, and they must
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);
 * <ol>
 * </ul>
    /**
            if (o == 1) {  
            + "},"
            + "  \"number_of_replicas\": 0,"
                flush();
        Object v = rows.get(0).get(0);
    private void flush() throws IOException {
 *       a substring (e.g. {@code "bravo charlie delta"}). Neither {@code match} nor  
 * matching docs ingested so far.
     */
 * The OpenSearch Contributors require contributions made to  
 *       (exercises the merge-output writer-generation stamping and segment realignment).</li>  
        Response resp = client().performRequest(req);
 * <p><b>What each iteration exercises.</b>  
 * Randomized parity test between the delegated {@code match(...)} query (lowered to Lucene
            + "  \"index.pluggable.dataformat\": \"composite\","
        "xray yankee zulu" };
        // ran before the single-leaf shortcut.
        StringBuilder bulk = new StringBuilder(total * 64);  
                message = NON_MATCHING_TEMPLATES[random.nextInt(NON_MATCHING_TEMPLATES.length)];  
            assertMatchAndLikeAgreeOnCount(iter, cumulativeMatching);
 */  
        int total = matching + nonMatching;
            refresh();  
 */
     * Run a PPL query expected to produce a single scalar count (one row, one column).
        }
 *       (e.g. {@code "bravo alpha charlie"}). Both the Lucene analyzer (standard tokenizer
/**
        long cumulativeMatching = 0L;
public class MatchLikeParityIT extends AnalyticsRestTestCase {
        assertNotNull("PPL scalar count value must not be null for: " + ppl, v);
        for (int iter = 0; iter < iterations; iter++) {
        req.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");  
        client().performRequest(req);
        client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_refresh"));
            + "}"  
            // Randomly flush to force parquet writes. Biased toward true so most iterations
    /**
            int tmp = order[i];
