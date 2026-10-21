    private void seedDriftingSegments() throws IOException {
        // Sanity: match() alone agrees with the residual-combined count (residual is always true).
        assertEquals("scalar count should return exactly 1 column for: " + ppl, 1, rows.get(0).size());
 * {@code match()} on a <em>dynamically-added</em> field across segments is a separate, known
            }
                // (With non-negative pads, a misresolution onto a pad would still satisfy
 *       (hits {@code eval_leaf} / {@code prune_rg} on the parquet-only path).</li>
        "echo foxtrot golf",
 *
        List<List<Object>> topk = datarows(
    private static final String TARGET = "alpha";
 * <p>Pre-fix, the always-true {@code severity >= 0} residual prunes drifted segments and the
 * compatible open source license.
                // severity >= 0 and silently hide the bug.)
 * divergence reliable; small fixtures (a handful of fields) do not drift and pass even without
        assertEquals("match()+filter+sort+limit row count under schema drift", Math.min(k, (int) totalMatching), combined.size());
 * SPDX-License-Identifier: Apache-2.0
     */
public class SchemaDriftPruneNoMergeIT extends AnalyticsRestTestCase {
    /** Docs per segment. With row_group_max_rows small this yields multiple RGs per segment. */
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "create index");
                String message = matching
                doc.append("}");
            + "  \"number_of_shards\": 1,"
        List<List<Object>> rows = datarows(parsed);
        }
                bulk.append(doc).append("\n");
    private void flush() throws IOException {
                doc.append("{\"message\":\"").append(escapeJson(message)).append("\"");
     * {@code severity}, so {@code severity >= 0} is always true and must never prune.
        "juliet kilo alpha lima" };
            assertTrue("every returned row satisfies severity >= 0", num(r.get(0)) >= 0);
    private long totalMatching = 0L;
 * union ordinal. The high field count (~300 in the widest segment) is what makes the
            + "  \"number_of_replicas\": 0,"
            req.setJsonEntity(bulk.toString());
    private static final int MAX_PAD_FIELDS = 300;
            executePpl("source = " + INDEX + " | where severity >= 0 | sort - severity | head " + k + " | fields severity")
            + "  \"index.pluggable.dataformat.enabled\": true,"
 */
    private static List<List<Object>> datarows(Map<String, Object> result) {
    }
        Request req = new Request("POST", "/" + INDEX + "/_flush");
 * <p><b>Query shapes</b> (each asserted against a ground truth computed during ingest):
        createIndex.setJsonEntity(body);
 * <p>The {@code text} field is declared in the initial mapping on purpose:
    private static final String INDEX = "schema_drift_prune";
        health.addParameter("timeout", "30s");
        createCompositeIndex();
            assertFalse("bulk errors in segment " + s + ": " + parsed, Boolean.TRUE.equals(parsed.get("errors")));
 * silently dropping matching rows. The fix resolves stats against each segment's <em>own</em>
                    + "| sort - severity | head " + k + " | fields severity"
    }
        );
 * Regression test for parquet row-group / page statistics pruning under dynamic-mapping
            + "    \"severity\": { \"type\": \"byte\" }"
 * segments, but each individual segment's parquet column order follows the Java mapper's
    private static int padWidthForSegment(int s) {
                boolean matching = i < MATCHING_PER_SEGMENT;
     * drifts to a different ordinal than its union-schema ordinal. Every doc has a non-negative
        try {
import org.opensearch.client.Response;
            + "\"mappings\": {"
                bulk.append("{\"index\":{}}\n");
 * {@code integTestNoMerge} cluster variant in build.gradle), and {@code row_group_max_rows} is
 * issue ({@code DynamicMappingSearchIT#testSearchOnDynamicallyAddedFields}, {@code @AwaitsFix}
 * {@code page_pruner.rs}, and {@code rg_provably_excluded} in {@code dynamic_filter.rs}) used
        assertEquals("scalar count should return exactly 1 row for: " + ppl, 1, rows.size());
     * Seeds {@link #SEGMENTS} segments of growing width. Segment {@code s} writes documents
        for (List<Object> r : topk) {
    // cluster reproduction (24 segments, dynamic widths up to ~300, multi-RG segments) and were
        //    filtered set must return exactly min(k, totalDocs) rows, all with severity >= 0.
    private static final int ROW_GROUP_MAX_ROWS = 100;
        return ((Number) cell).doubleValue();
 * </ol>
 *   <li>match() + numeric residual — {@code where match(message,'alpha') and severity >= 0 | stats count()}
        int w = (int) (((long) (s + 1) * MAX_PAD_FIELDS) / SEGMENTS);
            + "  \"index.parquet.row_group_max_rows\": " + ROW_GROUP_MAX_ROWS + ","
 *
 * this file be licensed under the Apache-2.0 license or a
/*
                for (int p = 0; p < width; p++) {
    }
    private static final int MATCHING_PER_SEGMENT = 300;
        health.addParameter("wait_for_status", "green");
            + "  \"index.mapping.total_fields.limit\": 2000,"
        return ((Number) v).longValue();
            + "  \"dynamic\": true,"
 * <b>schema drift</b> across segments. Automates the manual cluster reproduction that
        List<List<Object>> combined = datarows(
 * {@code HashMap} iteration order for <em>that segment's own field set</em>. When segments
        int k = 50;
    // segments of widely-varying width (smaller fixtures — e.g. 4 segments up to 150 fields —
            Request req = new Request("POST", "/" + INDEX + "/_bulk");
        req.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
                // pad column (positional drift), the wrong column's max < 0 makes the always-true
    /** Matching (contain TARGET) docs per segment; the rest are non-matching. */
     * carrying {@code pad_0..pad_{W(s)-1}} dynamically-mapped numeric fields, where {@code W(s)}
            + "  \"index.composite.primary_data_format\": \"parquet\","
            totalMatching += MATCHING_PER_SEGMENT;
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        "bravo charlie delta",
 *       (adds the {@code DynamicRgPruner} / {@code rg_provably_excluded} path).</li>
 *   <li>Numeric filter only — {@code where severity >= 0 | stats count()}
    }
        }
    // ── REST helpers ───────────────────────────────────────────────────────────────
        long matchOnly = scalarCount("source = " + INDEX + " | where match(message, '" + TARGET + "') | stats count()");
 *
                doc.append(",\"severity\":").append(severity);
            )
     * different-sized field sets → divergent per-segment HashMap column order → {@code severity}
            for (int i = 0; i < DOCS_PER_SEGMENT; i++) {
    private static final String[] NON_MATCHING_TEMPLATES = new String[] {
 * <em>positionally</em>: it finds the column's ordinal in the Arrow schema it is handed and
import java.util.List;
    // verified to fail without the fix (match()+severity>=0 returned 6600 instead of 7200).
 *       (the production shape: Lucene-delegated text predicate AND a stats-pruned residual).</li>
    }
    /** Parquet row-group size — small so each segment has several row groups (multi-RG like prod). */
 * <p><b>The bug.</b> {@code StatisticsConverter} resolves a column name to a parquet leaf
    }
        Response resp = client().performRequest(req);
        // 4) match() + filter + sort + limit: all three prune paths together.
        long filterOnly = scalarCount("source = " + INDEX + " | where severity >= 0 | stats count()");
            Map<String, Object> parsed = assertOkAndParse(client().performRequest(req), "bulk segment " + s);
    // ── Setup / ingest ───────────────────────────────────────────────────────────
                }
    private void createCompositeIndex() throws IOException {
package org.opensearch.analytics.qa;
        assertEquals("match() alone equals match()+residual (residual is always true)", matchOnly, matchAndResidual);
        client().performRequest(req);
        // total_fields.limit is raised to admit the ~300 dynamic pad fields; row_group_max_rows
                    doc.append(",\"pad_").append(p).append("\":").append(-1000000 - p);
        Object v = rows.get(0).get(0);
import java.io.IOException;
        // is small so each segment has several row groups.
 *
                    ? MATCHING_TEMPLATES[i % MATCHING_TEMPLATES.length]
            executePpl(
                // Pad values are strongly NEGATIVE so that if `severity` misresolves onto a
        } catch (Exception ignored) {
            + "  \"index.pluggable.dataformat\": \"composite\","
        }
 * small (multi-RG segments), successive segments carry differently-sized field sets — the
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
        assertNotNull("PPL response missing datarows for: " + ppl, rows);
        }
        // be auto-mapped per segment, producing the schema drift this test depends on.
 * <ol>
        req.addParameter("force", "true");
 * always-true residual {@code severity >= 0} wrongly prunes those row groups / segments,
    @SuppressWarnings("unchecked")
        client().performRequest(health);
 * PR #21701), so the full-text field stays stable and only the numeric pad fields drift.
 * to pass the <em>union table schema</em>. That schema's field order is first-seen across
}
        seedDriftingSegments();
/**
        for (List<Object> r : combined) {
            + "    \"message\": { \"type\": \"text\" },"
    private long scalarCount(String ppl) throws IOException {
        "papa quebec romeo sierra" };
    // Ground truth accumulated during ingest.
    /** Each flush becomes one parquet segment; widths grow so per-segment field sets differ. */
            + "},"
    }
        Request req = new Request("POST", "/_plugins/_ppl");
 * Because every flush becomes its own parquet segment, merge is disabled (see the
            totalDocs += DOCS_PER_SEGMENT;
 *
        assertEquals("numeric filter only (severity>=0) must not drop rows under schema drift", totalDocs, filterOnly);
            int width = padWidthForSegment(s);
        return (List<List<Object>>) result.get("datarows");
    private static double num(Object cell) {
    }
                    : NON_MATCHING_TEMPLATES[i % NON_MATCHING_TEMPLATES.length];
        assertEquals("sort+limit row count under schema drift", Math.min(k, (int) totalDocs), topk.size());
            StringBuilder bulk = new StringBuilder(DOCS_PER_SEGMENT * 64);
        for (int s = 0; s < SEGMENTS; s++) {
    private static final int SEGMENTS = 24;
                int severity = (i % 18);
 * have different-sized field sets (dynamic mapping adding fields over time), {@code severity}
 * <p><b>How drift is induced.</b> {@code message} (text) and {@code severity} (byte) are
        );
    private long totalDocs = 0L;
 * the fix.
 *   <li>Sort + limit (TopK) — {@code where severity >= 0 | sort - severity | head k}
    // diverging from its first-seen ordinal in the union table schema, so the positional
            client().performRequest(new Request("DELETE", "/" + INDEX));
                "source = " + INDEX + " | where match(message, '" + TARGET + "') and severity >= 0 "
        assertEquals("match() AND severity>=0 must not drop rows under schema drift", totalMatching, matchAndResidual);
        return Math.max(1, Math.min(MAX_PAD_FIELDS, w));
    // order scatters `severity` to a different ordinal in each differently-sized segment,
        assertNotNull("scalar count value must not be null for: " + ppl, v);
import java.util.Map;
    // StatisticsConverter lookup reads the wrong/no column. Reproducing it reliably needs many
        //    stats-pruned residual. Must equal the matching-doc ground truth.
 * counts come in <em>below</em> ground truth. Post-fix every count matches exactly.
            + "}"
                // severity in 0..17, always non-negative.
 * numeric fields {@code pad_0..pad_W(s)} (segment {@code s} is wider than segment {@code s-1}).
 *   <li>match() + filter + sort + limit — all three prune paths at once.</li>
        assertEquals(true, response.get("acknowledged"));
        long matchAndResidual = scalarCount(
            + "  }"
        "bravo alpha charlie",
        "alpha golf hotel india",
import org.opensearch.client.Request;
 */
     * grows from a few fields up to {@link #MAX_PAD_FIELDS}. Successive segments therefore have
            refresh();
 * lookup then reads the wrong leaf — or finds none — yielding all-null stats, and the
 * The OpenSearch Contributors require contributions made to
            // index may not exist yet
        "hotel india juliet kilo",
            + "\"settings\": {"
    // The bug is driven by per-segment dynamic-field WIDTH: the Java mapper's HashMap column
 * HashMap-order divergence that drifts {@code severity}'s per-segment ordinal away from its
    public void testStatsPruningCorrectUnderSchemaDrift() throws Exception {
        Request createIndex = new Request("PUT", "/" + INDEX);
        "delta alpha echo foxtrot",
            + "}";
    /**
        // 3) match() + numeric residual: the production shape. Lucene-delegated match() AND a
        // message + severity declared up front; dynamic:true (the default) lets pad_* fields
 * surfaced the bug (24 segments, wide dynamic schemas, merges off).
 *
        );
            + "  \"properties\": {"
                // `severity >= 0` evaluate to "cannot match" → the RG/segment is wrongly pruned.
    private static final int DOCS_PER_SEGMENT = 500;
    // do not diverge enough and pass even without the fix). These values mirror the manual
        String body = "{"
    }
 * declared up front, but each flush also indexes a <em>growing</em> set of dynamically-mapped
            "source = " + INDEX + " | where match(message, '" + TARGET + "') and severity >= 0 | stats count()"
    /** Growing pad width per segment: a few fields in segment 0 up to MAX_PAD_FIELDS in the last. */
            assertTrue("every combined row satisfies severity >= 0", num(r.get(0)) >= 0);
    private void refresh() throws IOException {
        Map<String, Object> parsed = assertOkAndParse(resp, "PPL: " + ppl);
 * The stats-pruning paths ({@code eval_leaf} / {@code PagePruner::prune_rg} in
        // 1) Numeric-filter-only: severity >= 0 is true for every doc → full count.
        client().performRequest(new Request("POST", "/" + INDEX + "/_refresh"));
            flush(); // force a parquet segment write; merge is disabled on this cluster variant
    /** Widest segment's pad-field count. Segment s carries pad_0..pad_{W(s)-1}. */
 * lands at a different ordinal in each segment than it has in the union schema. The positional
                StringBuilder doc = new StringBuilder();
 * arrow schema (derived from its parquet footer).
    private static final String[] MATCHING_TEMPLATES = new String[] {
        // 2) Sort + limit (TopK): exercises the dynamic-filter prune path. head k over the
 * uses that ordinal to index into the parquet file (parquet crate {@code parquet_column}).
