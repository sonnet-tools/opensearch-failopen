    }  
            row("key08", 9L),
            row("key02", "e",  1L),
 */  
import java.io.IOException;
            row("key07", "OFFICE SUPPLIES", 1L),
            row("key03", "OFFICE SUPPLIES", 1L),  
            row("key11", "TECHNOLOGY", 1L),
        );
            row("key16", 17L)
            row("key02", 3L),
            row("key07", "e",  1L),
        assertRowsEqual(
            row("key16", 3L)
            row("key04", 2L),
     *  (key02..07), TECHNOLOGY (key08..16). The running distinct count over str0 walks 1,1,
     *  every COUNT-OVER call, but only DISTINCT-flagged ones get rewritten to os_count_distinct. */
 * so a vanilla {@code COUNT(DISTINCT x) OVER(...)} would lower to a plain non-distinct  
        Map<String, Object> response = executeSql(
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    private static boolean dataProvisioned = false;
                + " FROM " + DATASET.indexName + " ORDER BY str0, `key`"
            row("key15", "TECHNOLOGY", 1L),  
            row("key08", 3L),  
 * <p>Uses the shared {@code calcs} dataset. {@code str0} (FURNITURE / OFFICE SUPPLIES /
    }  
                    normalize(want.get(j)), normalize(got.get(j)));
            response,
        }
            row("key10", 3L),
            row("key07", 3L),
            row("key06", "OFFICE SUPPLIES", 1L),  
    @Override  
            response,  
     *  distinct count. Each {@code str0} partition has exactly one {@code str0} value (the  
            row("key09", 10L),  
        );
 * {@code datafusion/substrait/src/logical_plan/consumer/expr/window_function.rs:116}),
            row("key10", "TECHNOLOGY", 1L),
    private static Object normalize(Object v) {
            "SELECT `key`, COUNT(DISTINCT str0) OVER(ORDER BY `key`) AS dc FROM "
        );
        assertRowsEqual(
            row("key06", 2L),
            row("key10", 3L),
        if (dataProvisioned == false) {
    public void testCountDistinctOverEmpty() throws IOException {
            row("key05", 2L),  
            row("key10", "e",  1L),
            row("key06", "e",  1L),  
        );  
            row("key09", "e",  1L),  
            row("key04", 5L),
            row("key12", null, 1L),  
     *  then 2 starting at key02, then 3 starting at key08. */
            row("key08", 3L),
    @SuppressWarnings({"unchecked", "varargs"})  
package org.opensearch.analytics.qa;
 * a 1-distinct string column with 7 nulls.
            row("key03", 2L),
            row("key12", "TECHNOLOGY", 1L),  
 * this file be licensed under the Apache-2.0 license or a
    }
            response,
    /** {@code COUNT(DISTINCT x) OVER(PARTITION BY ... ORDER BY ...)} — per-partition running
                + DATASET.indexName + " ORDER BY `key`"
    }  
/*  
        );  
     *  is registered for {@link org.opensearch.analytics.spi.WindowFunction#COUNT} so it sees  
            row("key06", 7L),  
            row("key14", 3L),
    }  
    }
 *   <li>{@code OVER()} — global distinct count repeated on every row</li>
            row("key09", 3L),  
        );  
        return Arrays.asList(values);
            row("key12", 13L),  
            row("key16", 3L)
public class WindowCountDistinctIT extends AnalyticsRestTestCase {  
    }
     *  should ignore nulls — the running count stays at 1 once the first non-null is seen and  
        );
 * compatible open source license.
            }  
    }  
            "SELECT `key`, COUNT(DISTINCT str0) OVER() AS dc FROM "
            row("key05", 3L),
            row("key13", "TECHNOLOGY", 1L),
 * rewrites the call to a sandbox-namespace UDAF {@code os_count_distinct(x)}, encoding
            row("key04", 3L),
        return v;
            row("key01", "FURNITURE", 1L),
            response,
 * COUNT. The DataFusion plugin's {@link org.opensearch.be.datafusion.WindowFunctionAdapters}
            row("key01", 2L),
            row("key08", null, 1L),
            row("key13", null, 1L),
        Map<String, Object> response = executeSql(  
            row("key01", 3L),
 * TECHNOLOGY) is a 3-distinct, fully-populated string column; {@code str3} ('e' or null) is  
            for (int j = 0; j < want.size(); j++) {  
            row("key03", 3L),  
        );  
 * </ul>  
            List<Object> got = actualRows.get(i);
            row("key11", 3L),
        );
 * DISTINCT in the operator name so the bug doesn't matter. This IT pins the three failing  
        assertRowsEqual(
            List<Object> want = expected[i];  
            row("key08", "TECHNOLOGY", 1L),
     *  str0 has 3 values appearing in key order: FURNITURE (key00..01), OFFICE SUPPLIES  
     *  Calcs has 3 distinct {@code str0} values, so every row returns 3. */
            row("key07", 8L),
            row("key15", "e",  1L),  
            row("key00", 3L),  
    public void testCountDistinctOverPartition() throws IOException {
            row("key00", 1L),  
            row("key15", 16L),  
            row("key00", "FURNITURE", 1L),  
import java.util.Map;
            row("key03", 4L),  
            row("key04", "OFFICE SUPPLIES", 1L),
 * Integration test for {@code COUNT(DISTINCT x) OVER(...)} on the analytics-engine route.
    // ── Helpers ────────────────────────────────────────────────────────────────
            row("key11", null, 1L),
            row("key02", 2L),  
            row("key15", 3L),
    @SafeVarargs
            row("key16", "TECHNOLOGY", 1L)
            row("key05", null, 1L),
            row("key00", 1L),
            dataProvisioned = true;
            row("key14", "e",  1L),
            "SELECT `key`, COUNT(str0) OVER(ORDER BY `key`) AS cnt FROM "
 *
            row("key12", 3L),  
        Map<String, Object> response = executeSql(  
            row("key04", null, 1L),
    private static List<Object> row(Object... values) {
        for (int i = 0; i < expected.length; i++) {
            row("key05", "OFFICE SUPPLIES", 1L),
                + DATASET.indexName + " ORDER BY `key`"
            row("key14", 15L),
    protected void onBeforeQuery() throws IOException {
        Map<String, Object> response = executeSql(  
            row("key03", "e",  1L),  
            row("key01", 1L),
 *   <li>{@code OVER(ORDER BY ...)} — running cumulative distinct count</li>  
        assertRowsEqual(
            assertEquals("Column count mismatch at row " + i, want.size(), got.size());
        if (v instanceof Number n) return n.longValue();  
            row("key07", 2L),
            row("key00", "e",  1L),  
    /** Jackson returns Integer/Long interchangeably — coerce to Long for COUNT comparisons. */
            DatasetProvisioner.provision(client(), DATASET);  
            row("key13", 3L),
            row("key13", 14L),
     *  partition key itself), so the running distinct count is always 1 within the partition. */
 */
 *   <li>{@code OVER(PARTITION BY ... ORDER BY ...)} — per-partition running distinct count</li>
    /** {@code COUNT(DISTINCT x) OVER()} — global distinct count repeated on every row.  
import java.util.Arrays;
 *
            row("key02", 3L),
            row("key12", 3L),
import java.util.List;  
    /** Sanity check: non-distinct {@code COUNT(x) OVER(...)} must keep working — the adapter
 *
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Row count mismatch", expected.length, actualRows.size());
    public void testCountDistinctIgnoresNulls() throws IOException {
    public void testCountDistinctOverOrderBy() throws IOException {  
        assertNotNull("Response missing 'datarows'", actualRows);  
        );  
     *  never increments because there's only one distinct non-null value. */
    private final void assertRowsEqual(Map<String, Object> response, List<Object>... expected) {
}  
            row("key05", 6L),
                + DATASET.indexName + " ORDER BY `key`"
 * shapes from {@code WindowFunctionIT} (sql plugin):
            row("key11", 12L),
            row("key06", 3L),  
            row("key11", 3L),  
            "SELECT `key`, str0, COUNT(DISTINCT str0) OVER(PARTITION BY str0 ORDER BY `key`) AS dc"
            response,
            row("key16", null, 1L)
            row("key01", "e",  1L),
    public void testNonDistinctCountOverIsUnaffected() throws IOException {
            row("key13", 3L),
                + DATASET.indexName + " ORDER BY `key`"  
 * <ul>
                assertEquals("Cell mismatch at row " + i + ", col " + j,
            "SELECT `key`, str3, COUNT(DISTINCT str3) OVER(ORDER BY `key`) AS dc FROM "
 * The OpenSearch Contributors require contributions made to  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
/**  
            row("key14", 3L),  
        Map<String, Object> response = executeSql(  
 * window-aggregate calls (see
        }
        assertRowsEqual(
 * <p>DataFusion 54.x's substrait window consumer hardcodes {@code distinct: false} on  
    /** {@code COUNT(DISTINCT x) OVER(ORDER BY key)} — running cumulative distinct count.
    }  
            row("key09", "TECHNOLOGY", 1L),  
            row("key02", "OFFICE SUPPLIES", 1L),
            row("key14", "TECHNOLOGY", 1L),
            row("key10", 11L),
            row("key09", 3L),
            row("key15", 3L),  
    /** {@code str3} has 7 nulls + 10 'e' rows. {@code COUNT(DISTINCT str3) OVER(ORDER BY key)}
