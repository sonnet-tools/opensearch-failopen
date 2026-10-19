        assertEquals("match() alone equals match()+residual (residual is always true)", matchOnly, matchAndResidual);
 *
                for (int p = 0; p < width; p++) {
 * segments, but each individual segment's parquet column order follows the Java mapper's
        // total_fields.limit is raised to admit the ~300 dynamic pad fields; row_group_max_rows  
import org.opensearch.client.Request;
    private static List<List<Object>> datarows(Map<String, Object> result) {
     * grows from a few fields up to {@link #MAX_PAD_FIELDS}. Successive segments therefore have  
        Request health = new Request("GET", "/_cluster/health/" + INDEX);  
                    doc.append(",\"pad_").append(p).append("\":").append(-1000000 - p);
            + "  \"number_of_replicas\": 0,"
 *   <li>match() + filter + sort + limit — all three prune paths at once.</li>
            + "  \"index.mapping.total_fields.limit\": 2000,"  
    private static final int ROW_GROUP_MAX_ROWS = 100;  
        seedDriftingSegments();
                    ? MATCHING_TEMPLATES[i % MATCHING_TEMPLATES.length]  
        long matchAndResidual = scalarCount(  
    // ── Setup / ingest ───────────────────────────────────────────────────────────
        // 1) Numeric-filter-only: severity >= 0 is true for every doc → full count.
        );
        return (List<List<Object>>) result.get("datarows");  
        Request req = new Request("POST", "/_plugins/_ppl");  
        }
 *  
                String message = matching
 *  
        "bravo alpha charlie",  
                // Pad values are strongly NEGATIVE so that if `severity` misresolves onto a
 */  
        // is small so each segment has several row groups.
 * The stats-pruning paths ({@code eval_leaf} / {@code PagePruner::prune_rg} in
 * </ol>
        "papa quebec romeo sierra" };  
            req.setJsonEntity(bulk.toString());
     * carrying {@code pad_0..pad_{W(s)-1}} dynamically-mapped numeric fields, where {@code W(s)}
 *
            + "  \"index.parquet.row_group_max_rows\": " + ROW_GROUP_MAX_ROWS + ","
 * <p><b>How drift is induced.</b> {@code message} (text) and {@code severity} (byte) are
        } catch (Exception ignored) {  
            client().performRequest(new Request("DELETE", "/" + INDEX));
        client().performRequest(health);  
 * PR #21701), so the full-text field stays stable and only the numeric pad fields drift.  
    public void testStatsPruningCorrectUnderSchemaDrift() throws Exception {  
 * <p><b>Query shapes</b> (each asserted against a ground truth computed during ingest):
 * SPDX-License-Identifier: Apache-2.0
 * declared up front, but each flush also indexes a <em>growing</em> set of dynamically-mapped
import java.util.Map;  
            + "},"  
 * divergence reliable; small fixtures (a handful of fields) do not drift and pass even without  
        }
    private void createCompositeIndex() throws IOException {  
        req.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
 * surfaced the bug (24 segments, wide dynamic schemas, merges off).
    // segments of widely-varying width (smaller fixtures — e.g. 4 segments up to 150 fields —
            + "  \"index.pluggable.dataformat\": \"composite\","  
        return Math.max(1, Math.min(MAX_PAD_FIELDS, w));
    /** Growing pad width per segment: a few fields in segment 0 up to MAX_PAD_FIELDS in the last. */
            flush(); // force a parquet segment write; merge is disabled on this cluster variant
 * the fix.
        );
            for (int i = 0; i < DOCS_PER_SEGMENT; i++) {  
    private void refresh() throws IOException {
    private static final int SEGMENTS = 24;
    }
            + "  \"properties\": {"  
            int width = padWidthForSegment(s);
        Map<String, Object> parsed = assertOkAndParse(resp, "PPL: " + ppl);  
                "source = " + INDEX + " | where match(message, '" + TARGET + "') and severity >= 0 "  
    }
        assertNotNull("PPL response missing datarows for: " + ppl, rows);
    private long scalarCount(String ppl) throws IOException {
        List<List<Object>> topk = datarows(
                // `severity >= 0` evaluate to "cannot match" → the RG/segment is wrongly pruned.
    /** Matching (contain TARGET) docs per segment; the rest are non-matching. */
    /** Widest segment's pad-field count. Segment s carries pad_0..pad_{W(s)-1}. */  
            + "  }"  
 * <b>schema drift</b> across segments. Automates the manual cluster reproduction that
        List<List<Object>> rows = datarows(parsed);
        for (List<Object> r : combined) {
        assertEquals(true, response.get("acknowledged"));
        assertEquals("match() AND severity>=0 must not drop rows under schema drift", totalMatching, matchAndResidual);  
 * to pass the <em>union table schema</em>. That schema's field order is first-seen across  
        createCompositeIndex();
    private static final int MATCHING_PER_SEGMENT = 300;
            executePpl("source = " + INDEX + " | where severity >= 0 | sort - severity | head " + k + " | fields severity")  
        for (int s = 0; s < SEGMENTS; s++) {  
    // verified to fail without the fix (match()+severity>=0 returned 6600 instead of 7200).
            + "}"
            + "\"mappings\": {"
            refresh();  
            executePpl(
 * {@code match()} on a <em>dynamically-added</em> field across segments is a separate, known
 * union ordinal. The high field count (~300 in the widest segment) is what makes the
        // be auto-mapped per segment, producing the schema drift this test depends on.
    }  
    // order scatters `severity` to a different ordinal in each differently-sized segment,
    private void flush() throws IOException {
 *       (adds the {@code DynamicRgPruner} / {@code rg_provably_excluded} path).</li>
                doc.append("}");
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "create index");  
                // severity in 0..17, always non-negative.
        health.addParameter("wait_for_status", "green");
                doc.append(",\"severity\":").append(severity);
        long filterOnly = scalarCount("source = " + INDEX + " | where severity >= 0 | stats count()");
            + "  \"number_of_shards\": 1,"
        // Sanity: match() alone agrees with the residual-combined count (residual is always true).
            + "  \"dynamic\": true,"
        Response resp = client().performRequest(req);
    /**  
            totalMatching += MATCHING_PER_SEGMENT;
    private long totalMatching = 0L;
     * Seeds {@link #SEGMENTS} segments of growing width. Segment {@code s} writes documents
    private static final String[] MATCHING_TEMPLATES = new String[] {
        client().performRequest(new Request("POST", "/" + INDEX + "/_refresh"));
            + "    \"message\": { \"type\": \"text\" },"
 * <p><b>The bug.</b> {@code StatisticsConverter} resolves a column name to a parquet leaf
    private long totalDocs = 0L;  
        int k = 50;
    }
 * arrow schema (derived from its parquet footer).
        Object v = rows.get(0).get(0);
 *   <li>Numeric filter only — {@code where severity >= 0 | stats count()}
            + "}";
    @SuppressWarnings("unchecked")
 * {@code HashMap} iteration order for <em>that segment's own field set</em>. When segments
    }
    }
            )
            Map<String, Object> parsed = assertOkAndParse(client().performRequest(req), "bulk segment " + s);  
 * silently dropping matching rows. The fix resolves stats against each segment's <em>own</em>
 * {@code page_pruner.rs}, and {@code rg_provably_excluded} in {@code dynamic_filter.rs}) used
 *  
            + "    \"severity\": { \"type\": \"byte\" }"
            "source = " + INDEX + " | where match(message, '" + TARGET + "') and severity >= 0 | stats count()"
        "alpha golf hotel india",
            + "  \"index.pluggable.dataformat.enabled\": true,"
    private static final String TARGET = "alpha";
        //    stats-pruned residual. Must equal the matching-doc ground truth.
        long matchOnly = scalarCount("source = " + INDEX + " | where match(message, '" + TARGET + "') | stats count()");  
        String body = "{"
        assertEquals("numeric filter only (severity>=0) must not drop rows under schema drift", totalDocs, filterOnly);  
}  
        "juliet kilo alpha lima" };  
                // (With non-negative pads, a misresolution onto a pad would still satisfy
 *   <li>Sort + limit (TopK) — {@code where severity >= 0 | sort - severity | head k}  
        List<List<Object>> combined = datarows(
 * compatible open source license.
        assertEquals("scalar count should return exactly 1 row for: " + ppl, 1, rows.size());  
        createIndex.setJsonEntity(body);
        assertNotNull("scalar count value must not be null for: " + ppl, v);  
 * counts come in <em>below</em> ground truth. Post-fix every count matches exactly.
     * different-sized field sets → divergent per-segment HashMap column order → {@code severity}
    private static final int DOCS_PER_SEGMENT = 500;  
 * uses that ordinal to index into the parquet file (parquet crate {@code parquet_column}).  
            // index may not exist yet
/**
    /** Docs per segment. With row_group_max_rows small this yields multiple RGs per segment. */
        try {
 * <p>The {@code text} field is declared in the initial mapping on purpose:  
 * The OpenSearch Contributors require contributions made to  
        // 4) match() + filter + sort + limit: all three prune paths together.  
        Request req = new Request("POST", "/" + INDEX + "/_flush");  
 * always-true residual {@code severity >= 0} wrongly prunes those row groups / segments,  
                // pad column (positional drift), the wrong column's max < 0 makes the always-true  
    private static double num(Object cell) {  
            Request req = new Request("POST", "/" + INDEX + "/_bulk");
        assertEquals("match()+filter+sort+limit row count under schema drift", Math.min(k, (int) totalMatching), combined.size());
 * HashMap-order divergence that drifts {@code severity}'s per-segment ordinal away from its
    // Ground truth accumulated during ingest.
 * have different-sized field sets (dynamic mapping adding fields over time), {@code severity}  
                int severity = (i % 18);  
                StringBuilder doc = new StringBuilder();
 * lands at a different ordinal in each segment than it has in the union schema. The positional
 * <p>Pre-fix, the always-true {@code severity >= 0} residual prunes drifted segments and the
        );  
 * this file be licensed under the Apache-2.0 license or a
        "echo foxtrot golf",
    private static final String[] NON_MATCHING_TEMPLATES = new String[] {
        return ((Number) cell).doubleValue();
        }
            totalDocs += DOCS_PER_SEGMENT;  
 * lookup then reads the wrong leaf — or finds none — yielding all-null stats, and the
    /** Parquet row-group size — small so each segment has several row groups (multi-RG like prod). */
import java.util.List;
        assertEquals("scalar count should return exactly 1 column for: " + ppl, 1, rows.get(0).size());
        req.addParameter("force", "true");
                doc.append("{\"message\":\"").append(escapeJson(message)).append("\"");  
        for (List<Object> r : topk) {  
 * Regression test for parquet row-group / page statistics pruning under dynamic-mapping  
        "bravo charlie delta",  
        // 2) Sort + limit (TopK): exercises the dynamic-filter prune path. head k over the
            }
        health.addParameter("timeout", "30s");
            assertFalse("bulk errors in segment " + s + ": " + parsed, Boolean.TRUE.equals(parsed.get("errors")));
import org.opensearch.client.Response;
 *       (the production shape: Lucene-delegated text predicate AND a stats-pruned residual).</li>  
        assertEquals("sort+limit row count under schema drift", Math.min(k, (int) totalDocs), topk.size());
            + "\"settings\": {"  
        int w = (int) (((long) (s + 1) * MAX_PAD_FIELDS) / SEGMENTS);
    // do not diverge enough and pass even without the fix). These values mirror the manual
 */  
        //    filtered set must return exactly min(k, totalDocs) rows, all with severity >= 0.  
                    : NON_MATCHING_TEMPLATES[i % NON_MATCHING_TEMPLATES.length];
 * <ol>  
    private static int padWidthForSegment(int s) {  
 * <em>positionally</em>: it finds the column's ordinal in the Arrow schema it is handed and
package org.opensearch.analytics.qa;
    // The bug is driven by per-segment dynamic-field WIDTH: the Java mapper's HashMap column  
 *   <li>match() + numeric residual — {@code where match(message,'alpha') and severity >= 0 | stats count()}
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
            StringBuilder bulk = new StringBuilder(DOCS_PER_SEGMENT * 64);
     * {@code severity}, so {@code severity >= 0} is always true and must never prune.  
    private void seedDriftingSegments() throws IOException {
            assertTrue("every returned row satisfies severity >= 0", num(r.get(0)) >= 0);
        return ((Number) v).longValue();
     * drifts to a different ordinal than its union-schema ordinal. Every doc has a non-negative
        "delta alpha echo foxtrot",
 * Because every flush becomes its own parquet segment, merge is disabled (see the
                }  
import java.io.IOException;
    }  
                bulk.append("{\"index\":{}}\n");  
    }  
    // StatisticsConverter lookup reads the wrong/no column. Reproducing it reliably needs many  
    // ── REST helpers ───────────────────────────────────────────────────────────────
 * numeric fields {@code pad_0..pad_W(s)} (segment {@code s} is wider than segment {@code s-1}).  
    // cluster reproduction (24 segments, dynamic widths up to ~300, multi-RG segments) and were  
        // 3) match() + numeric residual: the production shape. Lucene-delegated match() AND a
            + "  \"index.composite.primary_data_format\": \"parquet\","
    }  
        }
    private static final String INDEX = "schema_drift_prune";  
                // severity >= 0 and silently hide the bug.)  
 * {@code integTestNoMerge} cluster variant in build.gradle), and {@code row_group_max_rows} is
        "hotel india juliet kilo",
 * small (multi-RG segments), successive segments carry differently-sized field sets — the  
/*  
    /** Each flush becomes one parquet segment; widths grow so per-segment field sets differ. */  
 *       (hits {@code eval_leaf} / {@code prune_rg} on the parquet-only path).</li>
                    + "| sort - severity | head " + k + " | fields severity"
        // message + severity declared up front; dynamic:true (the default) lets pad_* fields
        Request createIndex = new Request("PUT", "/" + INDEX);
    // diverging from its first-seen ordinal in the union table schema, so the positional
            assertTrue("every combined row satisfies severity >= 0", num(r.get(0)) >= 0);  
     */
public class SchemaDriftPruneNoMergeIT extends AnalyticsRestTestCase {
                bulk.append(doc).append("\n");
 *
    private static final int MAX_PAD_FIELDS = 300;
 * issue ({@code DynamicMappingSearchIT#testSearchOnDynamicallyAddedFields}, {@code @AwaitsFix}
        client().performRequest(req);
                boolean matching = i < MATCHING_PER_SEGMENT;
