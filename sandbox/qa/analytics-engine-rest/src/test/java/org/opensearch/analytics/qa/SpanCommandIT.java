 *
    // ── Total row count sanity check ────────────────────────────────────────
        // from Java integer-trunc). Don't assume null ordering; just scan.
        @SuppressWarnings("unchecked")
import java.io.IOException;
        @SuppressWarnings("unchecked")
    //
    //   2.47  → floor(0.988)*2.5 = 0.0  
    public void testStatsByFractionalSpanProducesFractionalBinStarts() throws IOException {  
            DatasetProvisioner.provision(client(), DATASET);
    //   15.7 → 15
import java.util.Arrays;
    @Override
        assertEquals("unexpected count for bin_start " + expectedBinStart, expectedCount, ((Number) row.get(0)).longValue());
        assertBucket(rows.get(1), 5.0, 9);  
        assertTrue("-20 bucket must exist (floor(-15.7/5)*5)", found_neg_20);
 * analytics-engine route. Exercises the {@code stats ... by span(field,
 * chrono-backed Rust kernel lands or the coord bridge is pinned down.
        for (List<Object> r : rows) {
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        assertTrue("-15 bucket must exist (floor(-12.3/5)*5 under floor semantics)", found_neg_15);  
                } else if (v == -20.0) {  
    public void testStatsBySpanBucketsRowsByNumericBinStart() throws IOException {  
                double v = ((Number) s).doubleValue();
    //    3.5 → 0
                    found_neg_5 = true;
    // ── helpers ─────────────────────────────────────────────────────────────
        double last = ((Number) rows.get(rows.size() - 1).get(1)).doubleValue();
    }
    }  
        assertEquals("largest bin-start must be 15.0 (for 16.42/16.81)", 15.0, last, 1e-9);
    //    integer-trunc for integer fields). SpanAdapter's Javadoc notes that  
                    found_neg_20 = true;
        @SuppressWarnings("unchecked")
        assertEquals("unexpected bin_start", expectedBinStart, ((Number) row.get(1)).doubleValue(), 1e-9);
    }  
        // num1 ∈ {2.47, 6.71, 7.1, 7.12, 7.43, 8.42, 9.05, 9.38, 9.47, 9.78,
        assertEquals("4 distinct numeric bin-starts expected", 4, rows.size());
    //  -15.7 → -20  
    //   12.3 → 10  
                    found_neg_15 = true;
        }  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 *
 * a VARCHAR label. Aggregation rows are keyed by the numeric bin-start.  
    // group by default, unless `bucket_nullable=false` is set).  
        assertBucket(rows.get(0), 0.0, 1);
 * {@code rust/src/udf/span.rs}'s numeric branch returns
            "source=" + DATASET.indexName + " | stats count() as c by span(num1, 2.5) as s | sort s"
 * compatible open source license.
    //    SPAN(-12.3, 5) on the DataFusion backend yields floor(-12.3/5)*5
    // values are 0.0, 5.0, 10.0, 15.0. Row counts:  
        assertBucket(rows.get(3), 15.0, 2);
    //    15: 1 (15.7)
        assertBucket(rows.get(2), 10.0, 5);
    // count of distinct buckets and that the smallest bin-start is 0.0 (for
    //   0.0: 1   (2.47)
    // For num1 (no nulls, range [2.47, 16.81]) and span=5, the bin-start
 * <p>SPAN returns a numeric bin-start (same type as arg0 — the field), not
            }
    //   5.0: 9   (8.42, 6.71, 9.78, 7.43, 9.05, 9.38, 9.47, 7.1, 7.12)
                    assertEquals("count for -20 bucket", 1L, ((Number) r.get(0)).longValue());
    // Plus nulls for 9 rows where num0 is null (they become one null-key
    //     0: 2 (3.5, 0)  
    //  -12.3 → -15
        assertNotNull("rows missing", rows);  
                if (v == -15.0) {  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
    //   10..12.4 → 10.0  
    private static void assertBucket(List<Object> row, double expectedBinStart, long expectedCount) {  
 * Self-contained integration test for PPL's numeric-{@code span} on the
        assertNotNull("rows missing", rows);
        assertTrue("-5 bucket must exist (floor(-3.5/5)*5)", found_neg_5);
        Map<String, Object> response = executePpl(
    // Distinct span(num0, 5) values (excluding null-propagations):
    public void testStatsBySpanFloorsNegativeValuesTowardNegativeInfinity() throws IOException {
    public void testStatsBySpanAccountsForEveryRow() throws IOException {  
 */  
    //  
public class SpanCommandIT extends AnalyticsRestTestCase {
 * span kernel (see {@code CalciteExplainIT} /
    }
    // ── Basic grouping by numeric span ─────────────────────────────────────  
 * {@code span(@ts, 1d)} is bridged on the coordinator in this PR and is  
        );
 * as age_span} for grouping).  
    // span(num1, 2.5): floor(num1/2.5)*2.5.
        );  
}
 * {@code CalcitePPLJoinIT}'s extensive use of {@code by span(age, 10)
    //  10.0: 5   (11.38, 12.4, 10.32, 12.05, 10.37)  
    //   ~5..7 → 5.0
/**  
        assertEquals("5 distinct fractional bin-starts expected", 5, rows.size());  
    //  15.0: 2   (16.42, 16.81)
        for (List<Object> r : rows) {
 * {@code floor(value/n) * n}.  
 *
    }  
        boolean found_neg_5 = false;
        );  
    // The span aggregation must account for every row in calcs (17). This  
    //   -3.5 → -5
    // sort s (nulls last by default in PPL).
        assertEquals("smallest bin-start must be 0.0 (for num1=2.47)", 0.0, first, 1e-9);  
 * NOT exercised here. A follow-up will cover the time-unit path once the
        if (dataProvisioned == false) {  
        assertEquals("total count across all buckets must equal row count of calcs", 17L, total);
        @SuppressWarnings("unchecked")  
        // Find the -15 bucket to verify floor semantics (the documented divergence  
 * PPL {@code stats count() by span(f, n) as a} &rarr;  
    //   Distinct values for num1 ∈ [2.47, 16.81]:
    // num0 ∈ {12.3, -12.3, 15.7, -15.7, 3.5, -3.5, 0, null, 10, null, ...}.
    //    10  → 10
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        boolean found_neg_15 = false;
        //         10.32, 10.37, 11.38, 12.05, 12.4, 16.42, 16.81}
        }
 * The OpenSearch Contributors require contributions made to  
        long total = 0;  
        Map<String, Object> response = executePpl(
    //    0   → 0  
    // span → group-by lowering.
    //    -5: 1 (-3.5)
            total += ((Number) r.get(0)).longValue();
        // bin_starts at span=2.5: 0 (2.47), 5 (6.71,7.1,7.12,7.43), 7.5 (8.42,9.05,  
        boolean found_neg_20 = false;  
                    assertEquals("count for -15 bucket", 1L, ((Number) r.get(0)).longValue());
        Map<String, Object> response = executePpl(  
            "source=" + DATASET.indexName + " | stats count() as c by span(num0, 5) as s | sort s"
    // Row count distribution over the 17 calcs rows:
            if (s instanceof Number) {
 * <p><b>Scope:</b> numeric span only. Date/time span like
        double first = ((Number) rows.get(0).get(1)).doubleValue();
    // ── Negative values — floor semantics (documented divergence from Java
    private static boolean dataProvisioned = false;
 * <p>Pipeline:
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
                }  
import java.util.Map;
    //  
 * {@link org.opensearch.be.datafusion.SpanAdapter} rewrites to local
    //
 * {@code span} SqlFunction &rarr;  
 * this file be licensed under the Apache-2.0 license or a
            Object s = r.get(1);  
 * {@code CalciteRexNodeVisitor.visitSpan} emits {@code SPAN(field, n, NULL)} &rarr;
    // ── Fractional interval produces fractional bin-starts ──────────────────
            "source=" + DATASET.indexName + " | stats count() as c by span(num1, 5) as s"
    //   -15: 1 (-12.3)
    // Rather than enumerate every bucket (risky with fp), assert just the  
                    assertEquals("count for -5 bucket", 1L, ((Number) r.get(0)).longValue());
 * DataFusion resolves the {@code span} Rust UDF by name &rarr;
 * interval) as alias} surface, which is how PPL users invoke the numeric-  
/*  
    }
            dataProvisioned = true;
        assertNotNull("rows missing", rows);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
import org.opensearch.client.Request;
package org.opensearch.analytics.qa;
    //
    //   -20: 1 (-15.7)  
    // guards against planner bugs that silently drop rows during the
 *
    //    = -3*5 = -15 (floor), not -10 (truncation-toward-zero). ─────────
    // num1=2.47) and the largest is 15.0 (for 16.42/16.81).
    //  null: 9 (nulls in num0)  
    //   ...
        Map<String, Object> response = executePpl(
        //   9.38,9.47,9.78), 10 (10.32,10.37,11.38,12.05,12.4), 15 (16.42,16.81)
    //   11.38..12.05 → 10.0 or 12.5 depending on exact value
        }  
        );  
    //   7.x..9.99 → 7.5
        // → 5 distinct buckets
    protected void onBeforeQuery() throws IOException {
                } else if (v == -5.0) {  
import org.opensearch.client.Response;
 */  
    //    10: 2 (12.3, 10)
            "source=" + DATASET.indexName + " | stats count() as c by span(num1, 5) as s | sort s"
    // sort s puts them in ascending numeric order.
