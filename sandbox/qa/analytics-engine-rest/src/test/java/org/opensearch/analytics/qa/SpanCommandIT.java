package org.opensearch.analytics.qa;
        assertBucket(rows.get(3), 15.0, 2);
 * compatible open source license.
        double last = ((Number) rows.get(rows.size() - 1).get(1)).doubleValue();
 * <p><b>Scope:</b> numeric span only. Date/time span like
    // Row count distribution over the 17 calcs rows:
import java.util.List;
/*
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            "source=" + DATASET.indexName + " | stats count() as c by span(num1, 5) as s"
        Map<String, Object> response = executePpl(
    }
    // For num1 (no nulls, range [2.47, 16.81]) and span=5, the bin-start
    //    = -3*5 = -15 (floor), not -10 (truncation-toward-zero). ─────────
    //
 * PPL {@code stats count() by span(f, n) as a} &rarr;
        assertBucket(rows.get(1), 5.0, 9);
        assertNotNull("rows missing", rows);
        );
    // sort s (nulls last by default in PPL).
 */
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("-15 bucket must exist (floor(-12.3/5)*5 under floor semantics)", found_neg_15);
        assertEquals("largest bin-start must be 15.0 (for 16.42/16.81)", 15.0, last, 1e-9);
    }
    //   5.0: 9   (8.42, 6.71, 9.78, 7.43, 9.05, 9.38, 9.47, 7.1, 7.12)
    // num1=2.47) and the largest is 15.0 (for 16.42/16.81).
        assertEquals("unexpected bin_start", expectedBinStart, ((Number) row.get(1)).doubleValue(), 1e-9);
    //   11.38..12.05 → 10.0 or 12.5 depending on exact value
    //   ...
        // bin_starts at span=2.5: 0 (2.47), 5 (6.71,7.1,7.12,7.43), 7.5 (8.42,9.05,
    }
    //
    }
 * as age_span} for grouping).
    // group by default, unless `bucket_nullable=false` is set).
        assertTrue("-5 bucket must exist (floor(-3.5/5)*5)", found_neg_5);
        );
    }
 * {@link org.opensearch.be.datafusion.SpanAdapter} rewrites to local
                }
 * {@code CalciteRexNodeVisitor.visitSpan} emits {@code SPAN(field, n, NULL)} &rarr;
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> response = executePpl(
        //         10.32, 10.37, 11.38, 12.05, 12.4, 16.42, 16.81}
        assertNotNull("rows missing", rows);
        assertEquals("5 distinct fractional bin-starts expected", 5, rows.size());
            total += ((Number) r.get(0)).longValue();
 * a VARCHAR label. Aggregation rows are keyed by the numeric bin-start.
        assertEquals("total count across all buckets must equal row count of calcs", 17L, total);
 * DataFusion resolves the {@code span} Rust UDF by name &rarr;
/**
    // ── Basic grouping by numeric span ─────────────────────────────────────
    // The span aggregation must account for every row in calcs (17). This
                    found_neg_20 = true;
            "source=" + DATASET.indexName + " | stats count() as c by span(num0, 5) as s | sort s"
    // Rather than enumerate every bucket (risky with fp), assert just the
                    found_neg_15 = true;
            "source=" + DATASET.indexName + " | stats count() as c by span(num1, 2.5) as s | sort s"
 * NOT exercised here. A follow-up will cover the time-unit path once the
                    assertEquals("count for -15 bucket", 1L, ((Number) r.get(0)).longValue());
            }
    @Override
            "source=" + DATASET.indexName + " | stats count() as c by span(num1, 5) as s | sort s"
    private static boolean dataProvisioned = false;
 * {@code span} SqlFunction &rarr;
    //
    //   15.7 → 15
    //    0   → 0
        // → 5 distinct buckets
        assertNotNull("rows missing", rows);
 *
 * {@code span(@ts, 1d)} is bridged on the coordinator in this PR and is
        }
    protected void onBeforeQuery() throws IOException {
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            if (s instanceof Number) {
    // values are 0.0, 5.0, 10.0, 15.0. Row counts:
                } else if (v == -20.0) {
 * {@code floor(value/n) * n}.
    public void testStatsBySpanFloorsNegativeValuesTowardNegativeInfinity() throws IOException {
                double v = ((Number) s).doubleValue();
                if (v == -15.0) {
    // ── Negative values — floor semantics (documented divergence from Java
            DatasetProvisioner.provision(client(), DATASET);
    // Distinct span(num0, 5) values (excluding null-propagations):
        boolean found_neg_15 = false;
        boolean found_neg_5 = false;
    //    3.5 → 0
        @SuppressWarnings("unchecked")
import java.util.Map;
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
import java.util.Arrays;
public class SpanCommandIT extends AnalyticsRestTestCase {
        assertBucket(rows.get(0), 0.0, 1);
    //  -15.7 → -20
    //
        @SuppressWarnings("unchecked")
    //   -20: 1 (-15.7)
    // num0 ∈ {12.3, -12.3, 15.7, -15.7, 3.5, -3.5, 0, null, 10, null, ...}.
import org.opensearch.client.Response;
    private static void assertBucket(List<Object> row, double expectedBinStart, long expectedCount) {
    // ── Fractional interval produces fractional bin-starts ──────────────────
 * chrono-backed Rust kernel lands or the coord bridge is pinned down.
    //    -5: 1 (-3.5)
        assertEquals("smallest bin-start must be 0.0 (for num1=2.47)", 0.0, first, 1e-9);
        }
        long total = 0;
        Map<String, Object> response = executePpl(
    //   10..12.4 → 10.0
 * The OpenSearch Contributors require contributions made to
    // guards against planner bugs that silently drop rows during the
        @SuppressWarnings("unchecked")
                } else if (v == -5.0) {
    //
                    found_neg_5 = true;
    //  -12.3 → -15
    public void testStatsBySpanBucketsRowsByNumericBinStart() throws IOException {
    //   Distinct values for num1 ∈ [2.47, 16.81]:
    //   12.3 → 10
 *
        );
import java.io.IOException;
    // Plus nulls for 9 rows where num0 is null (they become one null-key
        // from Java integer-trunc). Don't assume null ordering; just scan.
 * {@code rust/src/udf/span.rs}'s numeric branch returns
}
            dataProvisioned = true;
    // span → group-by lowering.
    //    SPAN(-12.3, 5) on the DataFusion backend yields floor(-12.3/5)*5
    // sort s puts them in ascending numeric order.
        double first = ((Number) rows.get(0).get(1)).doubleValue();
    //  15.0: 2   (16.42, 16.81)
    //    15: 1 (15.7)
        }
        assertTrue("-20 bucket must exist (floor(-15.7/5)*5)", found_neg_20);
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    //  10.0: 5   (11.38, 12.4, 10.32, 12.05, 10.37)
 * <p>Pipeline:
 * span kernel (see {@code CalciteExplainIT} /
        assertEquals("unexpected count for bin_start " + expectedBinStart, expectedCount, ((Number) row.get(0)).longValue());
    public void testStatsByFractionalSpanProducesFractionalBinStarts() throws IOException {
        assertBucket(rows.get(2), 10.0, 5);
 */
        Map<String, Object> response = executePpl(
    //    integer-trunc for integer fields). SpanAdapter's Javadoc notes that
 * analytics-engine route. Exercises the {@code stats ... by span(field,
        @SuppressWarnings("unchecked")
            Object s = r.get(1);
    //    10: 2 (12.3, 10)
    //   2.47  → floor(0.988)*2.5 = 0.0
 * <p>SPAN returns a numeric bin-start (same type as arg0 — the field), not
    //   -3.5 → -5
        // num1 ∈ {2.47, 6.71, 7.1, 7.12, 7.43, 8.42, 9.05, 9.38, 9.47, 9.78,
    public void testStatsBySpanAccountsForEveryRow() throws IOException {
        assertEquals("4 distinct numeric bin-starts expected", 4, rows.size());
    // ── Total row count sanity check ────────────────────────────────────────
    // ── helpers ─────────────────────────────────────────────────────────────
 *
        boolean found_neg_20 = false;
                    assertEquals("count for -5 bucket", 1L, ((Number) r.get(0)).longValue());
 * interval) as alias} surface, which is how PPL users invoke the numeric-
 *
import org.opensearch.client.Request;
        // Find the -15 bucket to verify floor semantics (the documented divergence
    //     0: 2 (3.5, 0)
 * Self-contained integration test for PPL's numeric-{@code span} on the
    //   ~5..7 → 5.0
    //   7.x..9.99 → 7.5
        );
                    assertEquals("count for -20 bucket", 1L, ((Number) r.get(0)).longValue());
 * {@code CalcitePPLJoinIT}'s extensive use of {@code by span(age, 10)
        for (List<Object> r : rows) {
        for (List<Object> r : rows) {
    }
        if (dataProvisioned == false) {
    //   -15: 1 (-12.3)
    //    10  → 10
    // count of distinct buckets and that the smallest bin-start is 0.0 (for
        //   9.38,9.47,9.78), 10 (10.32,10.37,11.38,12.05,12.4), 15 (16.42,16.81)
    //  null: 9 (nulls in num0)
    // span(num1, 2.5): floor(num1/2.5)*2.5.
    //   0.0: 1   (2.47)
