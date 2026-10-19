     * <pre>
     * sub-second handling.  
 *       with {@code interval > 1}:</b> bucketed via integer-seconds arithmetic
    @Override  
        assertNotNull("rows missing", rows);
import java.util.Map;
            total += ((Number) r.get(0)).longValue();  
        );  
public class SpanTimeCommandIT extends AnalyticsRestTestCase {  
        @SuppressWarnings("unchecked")
 * compatible open source license.
 *
     */
    }
            total += ((Number) r.get(0)).longValue();
    }  
     * {@code span(@timestamp, 250us)} — sub-second microsecond bucket. With 5 rows spaced
    /** {@code span(@timestamp, 1h)} — all 5 rows fall in a single hour bucket. */  
    }
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 1ms) as s"
    /** {@code span(@timestamp, 2h)} — all 5 rows fall in a single 2-hour bucket. */
        }
    public void testSpanFortyMillisecondsBucketsEachRowDistinctly() throws IOException {
    private long assertSingleHourBucketTotal() throws IOException {  
        @SuppressWarnings("unchecked")  
}
 * {@code Unable to convert call SPAN(precision_timestamp<0>?, i32, char<1>)}.
     * far enough apart that each lands in a distinct 40ms bucket. Previously failed with
    // ── date_trunc path: N == 1 ───────────────────────────────────────────────
        @SuppressWarnings("unchecked")
    }  
package org.opensearch.analytics.qa;
        assertEquals("bucket labels must be distinct", 5, distinctBuckets.size());
        for (List<Object> r : rows) {
            DatasetProvisioner.provision(client(), DATASET);  
     * date_bin path as ms, but with the second sub-second unit.
 *
        Set<Object> distinctBuckets = new HashSet<>();  
        assertEquals("row total must equal the 5 source rows", 5L, total);  
 *       {@code to_unixtime} returns BIGINT seconds.</li>  
 *   <li><b>Sub-second unit ({@code us}/{@code ms}) with {@code interval > 1}:</b>  
        Map<String, Object> response = executePpl(
        Map<String, Object> response = executePpl(  
 *       through {@code to_unixtime} / {@code from_unixtime}.</li>
            assertEquals("each 40ms bucket must contain exactly 1 row", 1L, ((Number) r.get(0)).longValue());
        assertEquals("2h bucketing must collapse to a single bucket", 1, rows.size());  
        // dataset, just resolved through a different lowering path.  
        }
 * this file be licensed under the Apache-2.0 license or a
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 2h) as s"
        assertNotNull("rows missing", rows);  
    }  
 */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            distinctBuckets.add(r.get(1));  
        assertEquals("row total must equal the 5 source rows", 5L, total);
        );
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 *  
 * numeric-span Rust kernel and explicitly scopes out date/time.
 *
 * <p>Exercises all three lowering paths in  
     * 2026-05-20T00:07:57.200Z   WARN
import java.util.HashSet;
        assertEquals("each of 5 rows must fall in a distinct 40ms bucket", 5, rows.size());  
        return ((Number) rows.get(0).get(0)).longValue();
 *   <li><b>Fixed-length unit ({@code s}/{@code m}/{@code h}/{@code d}/{@code w})  
        assertNotNull("rows missing", rows);  
    public void testSpanMultiUnitHoursLowersToArithmetic() throws IOException {
 */  
    /**  
    public void testSpanUnitOneHourLowersToDateTrunc() throws IOException {
 *       rewritten to DataFusion's native {@code date_bin("<N> <unit>", field)}.
     * milliseconds apart, each must land in its own 250us bucket. Exercises the same  
        long total = 0;
import org.opensearch.client.Request;
    /**
        assertNotNull("rows missing", rows);
 *   <li><b>{@code interval == 1}, any unit:</b> rewritten to
        // executes successfully — the precise bucket layout is the same as 250us in this
 * timestamps) rather than the {@code calcs} dataset because {@code calcs}'s
        // produces 5 buckets, one per row. The point of this assertion is that the query
        @SuppressWarnings("unchecked")  
    }
     * Regression guard: {@code span(@timestamp, 1ms)} must stay on the cheaper
    // ── fixed-second arithmetic path: N > 1, unit in {s, m, h, d, w} ──────────
        assertEquals("1h bucketing must collapse to a single bucket", 1, rows.size());
    private static boolean dataProvisioned = false;
     * 2026-05-20T00:07:56.500Z   INFO  
     * {@code Unable to convert call SPAN(...)} on the analytics-engine route.  
     * adapter must check {@code isUnitInterval} before falling through to
     */
import java.io.IOException;
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 1h) as s"
        if (dataProvisioned == false) {
    // ── helpers ─────────────────────────────────────────────────────────────
 * </ul>
 * <ul>  
        );
 * bucketing meaningfully.
        assertEquals("all 5 rows fall in the 00:00 hour bucket", 5L, total);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("each of 5 rows must fall in a distinct 250us bucket", 5, rows.size());
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 40ms) as s"
     */
            dataProvisioned = true;
 *       The arithmetic path can't preserve sub-second precision because
        Map<String, Object> response = executePpl(  
 * Self-contained integration test for PPL's time-mode {@code span} on the
    /**
        for (List<Object> r : rows) {
     * 2026-05-20T00:07:58.000Z   WARN
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 250us) as s"
     * 2026-05-20T00:07:56.114Z   INFO
import java.util.Set;
    public void testSpanMicrosecondsBucketsEachRowDistinctly() throws IOException {  
        @SuppressWarnings("unchecked")  
     * {@code span(@timestamp, 40ms)} — the dashboard-trigger case. The 5 rows are spaced
    /**
        long total = assertSingleHourBucketTotal();
    private static final Dataset DATASET = new Dataset("span_time", "span_time");
        );
     * {@code date_bin} sub-second path. The unit is "ms" but N is 1, so the
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
        // All source @timestamp values have distinct millisecond values, so 1ms truncation  
 * {@code datetime0} field has whole-second values and can't exercise 40ms  
 *       {@code date_trunc(<unit>, field)}.</li>
 * histogram emits {@code span(@timestamp, 40ms)} and previously surfaced
        Map<String, Object> response = executePpl(
/**
/*  
        }
     */
 * {@code org.opensearch.be.datafusion.SpanAdapter}:
        long total = 0;
import org.opensearch.client.Response;
        assertNotNull("rows missing", rows);
     * 2026-05-20T00:08:00.000Z   INFO  
    protected void onBeforeQuery() throws IOException {
     * {@code date_trunc} path (N == 1, any unit) rather than the new  
 * analytics-engine route. Sister to {@link SpanCommandIT}, which covers the  
 * <p>Uses a focused {@code span_time} dataset (5 rows with explicit sub-second
 *
        assertEquals("all 5 rows fall in the 00:00 2h bucket", 5L, ((Number) rows.get(0).get(0)).longValue());
     * </pre>
 * <p>The sub-second multi-unit path is the dashboard-trigger case: the logs-tab  
        Map<String, Object> response = executePpl(  
     * Sample data summary (5 rows in {@code datasets/span_time/bulk.json}):  
    }
    // ── date_bin path (new): N > 1, sub-second unit ───────────────────────────
    public void testSpanOneMillisecondStaysOnDateTruncPath() throws IOException {
        );  
