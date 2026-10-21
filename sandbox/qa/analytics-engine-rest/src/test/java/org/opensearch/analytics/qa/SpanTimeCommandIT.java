 * SPDX-License-Identifier: Apache-2.0
    // ── helpers ─────────────────────────────────────────────────────────────
     * 2026-05-20T00:07:56.500Z   INFO
 *       rewritten to DataFusion's native {@code date_bin("<N> <unit>", field)}.
/**
 * <p>Uses a focused {@code span_time} dataset (5 rows with explicit sub-second
package org.opensearch.analytics.qa;
        @SuppressWarnings("unchecked")
 *       {@code to_unixtime} returns BIGINT seconds.</li>
            dataProvisioned = true;
}
 * bucketing meaningfully.
        );
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
     */
     * Sample data summary (5 rows in {@code datasets/span_time/bulk.json}):
        assertEquals("all 5 rows fall in the 00:00 hour bucket", 5L, total);
        Map<String, Object> response = executePpl(
        Map<String, Object> response = executePpl(
            distinctBuckets.add(r.get(1));
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 2h) as s"
 *
        assertNotNull("rows missing", rows);
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    // ── fixed-second arithmetic path: N > 1, unit in {s, m, h, d, w} ──────────
        assertEquals("1h bucketing must collapse to a single bucket", 1, rows.size());
     * {@code span(@timestamp, 250us)} — sub-second microsecond bucket. With 5 rows spaced
 * analytics-engine route. Sister to {@link SpanCommandIT}, which covers the
    public void testSpanUnitOneHourLowersToDateTrunc() throws IOException {
        assertNotNull("rows missing", rows);
    }
     * date_bin path as ms, but with the second sub-second unit.
    }
        Map<String, Object> response = executePpl(
    /**
        @SuppressWarnings("unchecked")
        for (List<Object> r : rows) {
     * {@code date_bin} sub-second path. The unit is "ms" but N is 1, so the
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 *   <li><b>Fixed-length unit ({@code s}/{@code m}/{@code h}/{@code d}/{@code w})
        for (List<Object> r : rows) {
import java.util.Set;
            assertEquals("each 40ms bucket must contain exactly 1 row", 1L, ((Number) r.get(0)).longValue());
import java.io.IOException;
 * Self-contained integration test for PPL's time-mode {@code span} on the
 *   <li><b>Sub-second unit ({@code us}/{@code ms}) with {@code interval > 1}:</b>
import java.util.HashSet;
 *       through {@code to_unixtime} / {@code from_unixtime}.</li>
 *
        assertNotNull("rows missing", rows);
     * far enough apart that each lands in a distinct 40ms bucket. Previously failed with
        return ((Number) rows.get(0).get(0)).longValue();
            total += ((Number) r.get(0)).longValue();
     * {@code Unable to convert call SPAN(...)} on the analytics-engine route.
     * 2026-05-20T00:07:58.000Z   WARN
        assertEquals("row total must equal the 5 source rows", 5L, total);
        assertEquals("2h bucketing must collapse to a single bucket", 1, rows.size());
 *       with {@code interval > 1}:</b> bucketed via integer-seconds arithmetic
    }
        assertEquals("all 5 rows fall in the 00:00 2h bucket", 5L, ((Number) rows.get(0).get(0)).longValue());
        assertNotNull("rows missing", rows);
        assertEquals("row total must equal the 5 source rows", 5L, total);
    public void testSpanMultiUnitHoursLowersToArithmetic() throws IOException {
     * {@code date_trunc} path (N == 1, any unit) rather than the new
 *
        long total = assertSingleHourBucketTotal();
     * 2026-05-20T00:07:56.114Z   INFO
 * timestamps) rather than the {@code calcs} dataset because {@code calcs}'s
    private static boolean dataProvisioned = false;
 *
import org.opensearch.client.Request;
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 40ms) as s"
        // dataset, just resolved through a different lowering path.
     * Regression guard: {@code span(@timestamp, 1ms)} must stay on the cheaper
     * <pre>
import java.util.Map;
 */
        );
 * compatible open source license.
    /**
    // ── date_trunc path: N == 1 ───────────────────────────────────────────────
    public void testSpanFortyMillisecondsBucketsEachRowDistinctly() throws IOException {
    /**
    /** {@code span(@timestamp, 1h)} — all 5 rows fall in a single hour bucket. */
     * </pre>
    private long assertSingleHourBucketTotal() throws IOException {
 * </ul>
 *
        );
     * sub-second handling.
        // executes successfully — the precise bucket layout is the same as 250us in this
    /** {@code span(@timestamp, 2h)} — all 5 rows fall in a single 2-hour bucket. */
        assertEquals("each of 5 rows must fall in a distinct 250us bucket", 5, rows.size());
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 * {@code org.opensearch.be.datafusion.SpanAdapter}:
 * The OpenSearch Contributors require contributions made to
    /**
        }
        }
        @SuppressWarnings("unchecked")
public class SpanTimeCommandIT extends AnalyticsRestTestCase {
     */
            DatasetProvisioner.provision(client(), DATASET);
        Map<String, Object> response = executePpl(
 * {@code Unable to convert call SPAN(precision_timestamp<0>?, i32, char<1>)}.
     * milliseconds apart, each must land in its own 250us bucket. Exercises the same
 * numeric-span Rust kernel and explicitly scopes out date/time.
 * <p>The sub-second multi-unit path is the dashboard-trigger case: the logs-tab
        }
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 1h) as s"
        Map<String, Object> response = executePpl(
        // All source @timestamp values have distinct millisecond values, so 1ms truncation
    }
import org.opensearch.client.Response;
     * 2026-05-20T00:07:57.200Z   WARN
        @SuppressWarnings("unchecked")
        assertNotNull("rows missing", rows);
    @Override
 *       {@code date_trunc(<unit>, field)}.</li>
     */
     * 2026-05-20T00:08:00.000Z   INFO
 */
        long total = 0;
    // ── date_bin path (new): N > 1, sub-second unit ───────────────────────────
        Set<Object> distinctBuckets = new HashSet<>();
     * {@code span(@timestamp, 40ms)} — the dashboard-trigger case. The 5 rows are spaced
        assertEquals("each of 5 rows must fall in a distinct 40ms bucket", 5, rows.size());
 *   <li><b>{@code interval == 1}, any unit:</b> rewritten to
/*
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        );
 *       The arithmetic path can't preserve sub-second precision because
        assertEquals("bucket labels must be distinct", 5, distinctBuckets.size());
 * <p>Exercises all three lowering paths in
 * <ul>
    }
    }
import java.util.List;
     */
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 1ms) as s"
    }
 * this file be licensed under the Apache-2.0 license or a
    private static final Dataset DATASET = new Dataset("span_time", "span_time");
 * histogram emits {@code span(@timestamp, 40ms)} and previously surfaced
 * {@code datetime0} field has whole-second values and can't exercise 40ms
        );
            total += ((Number) r.get(0)).longValue();
        @SuppressWarnings("unchecked")
        long total = 0;
     * adapter must check {@code isUnitInterval} before falling through to
        // produces 5 buckets, one per row. The point of this assertion is that the query
            "source=" + DATASET.indexName + " | stats count() as c by span(`@timestamp`, 250us) as s"
    protected void onBeforeQuery() throws IOException {
    public void testSpanMicrosecondsBucketsEachRowDistinctly() throws IOException {
        if (dataProvisioned == false) {
    public void testSpanOneMillisecondStaysOnDateTruncPath() throws IOException {
