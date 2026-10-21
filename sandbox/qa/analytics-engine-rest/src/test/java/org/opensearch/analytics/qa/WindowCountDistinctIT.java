            "SELECT `key`, COUNT(str0) OVER(ORDER BY `key`) AS cnt FROM "
            row("key13", 3L),
            row("key06", 2L),
            row("key01", 3L),
 * COUNT. The DataFusion plugin's {@link org.opensearch.be.datafusion.WindowFunctionAdapters}
            row("key10", 11L),
        );
    }
            row("key16", 17L)
        );
            row("key16", 3L)
                + DATASET.indexName + " ORDER BY `key`"
 * rewrites the call to a sandbox-namespace UDAF {@code os_count_distinct(x)}, encoding
            row("key06", 3L),
            row("key08", 3L),
        );
            row("key03", "e",  1L),
            row("key05", 2L),
 * TECHNOLOGY) is a 3-distinct, fully-populated string column; {@code str3} ('e' or null) is
 * <ul>
 * <p>Uses the shared {@code calcs} dataset. {@code str0} (FURNITURE / OFFICE SUPPLIES /
            row("key03", 2L),
            row("key08", null, 1L),
            row("key11", null, 1L),
    private static List<Object> row(Object... values) {
/*
            row("key13", "TECHNOLOGY", 1L),
            row("key06", 7L),
    }
            "SELECT `key`, str3, COUNT(DISTINCT str3) OVER(ORDER BY `key`) AS dc FROM "
            response,
import java.util.Arrays;
            row("key10", 3L),
        );
            "SELECT `key`, COUNT(DISTINCT str0) OVER() AS dc FROM "
            row("key07", "e",  1L),
            row("key14", 3L),
            row("key08", 9L),
    public void testCountDistinctOverEmpty() throws IOException {
            row("key08", 3L),
        if (v instanceof Number n) return n.longValue();
            row("key05", "OFFICE SUPPLIES", 1L),
            row("key13", 3L),
    }
            row("key07", 2L),
            row("key04", "OFFICE SUPPLIES", 1L),
        assertEquals("Row count mismatch", expected.length, actualRows.size());
    private static Object normalize(Object v) {
            row("key10", "TECHNOLOGY", 1L),
        return Arrays.asList(values);
            row("key03", 3L),
 * <p>DataFusion 54.x's substrait window consumer hardcodes {@code distinct: false} on
            row("key16", 3L)
     *  str0 has 3 values appearing in key order: FURNITURE (key00..01), OFFICE SUPPLIES
            response,
            row("key01", "e",  1L),
        assertRowsEqual(
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 * compatible open source license.
        assertRowsEqual(
}
 */
            List<Object> got = actualRows.get(i);
            row("key15", 3L),
 * Integration test for {@code COUNT(DISTINCT x) OVER(...)} on the analytics-engine route.
            row("key12", null, 1L),
     *  every COUNT-OVER call, but only DISTINCT-flagged ones get rewritten to os_count_distinct. */
        }
    }
            response,
            row("key16", null, 1L)
     *  then 2 starting at key02, then 3 starting at key08. */
 * SPDX-License-Identifier: Apache-2.0
        );
        );
            row("key00", 1L),
     *  is registered for {@link org.opensearch.analytics.spi.WindowFunction#COUNT} so it sees
            row("key11", "TECHNOLOGY", 1L),
    }
        );
package org.opensearch.analytics.qa;
            row("key07", 8L),
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
            row("key02", "OFFICE SUPPLIES", 1L),
            row("key11", 3L),
            row("key05", 6L),
        }
            row("key07", 3L),
            row("key09", "e",  1L),
            row("key06", "OFFICE SUPPLIES", 1L),
    public void testCountDistinctOverOrderBy() throws IOException {
     *  never increments because there's only one distinct non-null value. */
/**
            row("key02", 3L),
            response,
            row("key06", "e",  1L),
    @SuppressWarnings({"unchecked", "varargs"})
            row("key15", 3L),
            row("key10", "e",  1L),
                + DATASET.indexName + " ORDER BY `key`"
        assertRowsEqual(
                + " FROM " + DATASET.indexName + " ORDER BY str0, `key`"
            row("key14", "TECHNOLOGY", 1L),
    private final void assertRowsEqual(Map<String, Object> response, List<Object>... expected) {
                + DATASET.indexName + " ORDER BY `key`"
            row("key05", null, 1L),
 * shapes from {@code WindowFunctionIT} (sql plugin):
                assertEquals("Cell mismatch at row " + i + ", col " + j,
            List<Object> want = expected[i];
            DatasetProvisioner.provision(client(), DATASET);
        Map<String, Object> response = executeSql(
    /** {@code COUNT(DISTINCT x) OVER()} — global distinct count repeated on every row.
            row("key01", 2L),
            row("key02", "e",  1L),
        Map<String, Object> response = executeSql(
        for (int i = 0; i < expected.length; i++) {
        assertRowsEqual(
 *
    }
            row("key07", "OFFICE SUPPLIES", 1L),
            assertEquals("Column count mismatch at row " + i, want.size(), got.size());
        );
    // ── Helpers ────────────────────────────────────────────────────────────────
import java.util.Map;
            row("key11", 3L),
            row("key00", 1L),
     *  Calcs has 3 distinct {@code str0} values, so every row returns 3. */
    @Override
            row("key15", 16L),
import java.io.IOException;
            row("key04", null, 1L),
            row("key01", "FURNITURE", 1L),
            row("key14", "e",  1L),
            row("key00", 3L),
            row("key13", null, 1L),
            row("key04", 5L),
        assertNotNull("Response missing 'datarows'", actualRows);
 * DISTINCT in the operator name so the bug doesn't matter. This IT pins the three failing
            row("key15", "TECHNOLOGY", 1L),
        return v;
            row("key09", "TECHNOLOGY", 1L),
        );
    }
 *   <li>{@code OVER(ORDER BY ...)} — running cumulative distinct count</li>
    /** {@code COUNT(DISTINCT x) OVER(PARTITION BY ... ORDER BY ...)} — per-partition running
            row("key16", "TECHNOLOGY", 1L)
     *  distinct count. Each {@code str0} partition has exactly one {@code str0} value (the
 * a 1-distinct string column with 7 nulls.
            for (int j = 0; j < want.size(); j++) {
            row("key14", 3L),
 * The OpenSearch Contributors require contributions made to
            row("key12", "TECHNOLOGY", 1L),
            "SELECT `key`, str0, COUNT(DISTINCT str0) OVER(PARTITION BY str0 ORDER BY `key`) AS dc"
            row("key09", 10L),
 * so a vanilla {@code COUNT(DISTINCT x) OVER(...)} would lower to a plain non-distinct
    public void testNonDistinctCountOverIsUnaffected() throws IOException {
 * </ul>
    public void testCountDistinctOverPartition() throws IOException {
import java.util.List;
            row("key13", 14L),
            row("key00", "FURNITURE", 1L),
 *   <li>{@code OVER(PARTITION BY ... ORDER BY ...)} — per-partition running distinct count</li>
            row("key02", 3L),
            }
     *  partition key itself), so the running distinct count is always 1 within the partition. */
            row("key15", "e",  1L),
                + DATASET.indexName + " ORDER BY `key`"
    }
            row("key10", 3L),
        Map<String, Object> response = executeSql(
            row("key14", 15L),
 *
            dataProvisioned = true;
            row("key09", 3L),
            row("key03", "OFFICE SUPPLIES", 1L),
            row("key02", 2L),
    /** Jackson returns Integer/Long interchangeably — coerce to Long for COUNT comparisons. */
 * window-aggregate calls (see
            row("key04", 2L),
    @SafeVarargs
            row("key09", 3L),
    protected void onBeforeQuery() throws IOException {
            row("key12", 13L),
            row("key01", 1L),
    /** {@code COUNT(DISTINCT x) OVER(ORDER BY key)} — running cumulative distinct count.
 */
        );
                    normalize(want.get(j)), normalize(got.get(j)));
public class WindowCountDistinctIT extends AnalyticsRestTestCase {
            row("key12", 3L),
            row("key05", 3L),
        Map<String, Object> response = executeSql(
    private static boolean dataProvisioned = false;
    public void testCountDistinctIgnoresNulls() throws IOException {
     *  (key02..07), TECHNOLOGY (key08..16). The running distinct count over str0 walks 1,1,
 *
            "SELECT `key`, COUNT(DISTINCT str0) OVER(ORDER BY `key`) AS dc FROM "
            row("key00", "e",  1L),
            row("key04", 3L),
        assertRowsEqual(
    /** Sanity check: non-distinct {@code COUNT(x) OVER(...)} must keep working — the adapter
            row("key12", 3L),
     *  should ignore nulls — the running count stays at 1 once the first non-null is seen and
    /** {@code str3} has 7 nulls + 10 'e' rows. {@code COUNT(DISTINCT str3) OVER(ORDER BY key)}
        if (dataProvisioned == false) {
 *   <li>{@code OVER()} — global distinct count repeated on every row</li>
 * {@code datafusion/substrait/src/logical_plan/consumer/expr/window_function.rs:116}),
    }
 * this file be licensed under the Apache-2.0 license or a
            row("key11", 12L),
            response,
            row("key08", "TECHNOLOGY", 1L),
        Map<String, Object> response = executeSql(
            row("key03", 4L),
