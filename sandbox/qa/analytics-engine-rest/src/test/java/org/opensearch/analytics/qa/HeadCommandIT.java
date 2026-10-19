    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
 */
import java.util.Map;
        @SuppressWarnings("unchecked")  
    }
    // ── head after stats (limit-over-aggregate) ─────────────────────────────────
    public void testHeadAfterGroupedStatsLimitsRowCount() throws IOException {
    }  
        @SuppressWarnings("unchecked")  
 */  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
    }
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    @SafeVarargs
        assertRowCount("source=" + DATASET.indexName + " | fields str2 | head", 10);  
        // `head N from M` skips M rows and returns the next N. With 17 rows total,
    @SuppressWarnings("varargs")  
            row("one"),
        for (int i = 0; i < expected.length; i++) {
    public void testHeadDefault() throws IOException {
    // being provably <= 1 row (scalar aggregate), so a grouped aggregate's limit is preserved.
        assertRowCount("source=" + DATASET.indexName + " | stats count() as c | head 5", 1);
        assertRowCount("source=" + DATASET.indexName + " | fields str2 | head 100", 17);  
                "Cell mismatch at row " + i + " for query: " + ppl,  
import org.opensearch.client.Request;
    public void testHeadWithCount() throws IOException {  
            row("three"),
        // `head` without a count defaults to 10.
    protected void onBeforeQuery() throws IOException {  
            row("two"),  
}  
    // discarding a user `head N` after a grouped `stats`. The drop is now gated on the input  
                expected[i],
        assertRowCount("source=" + DATASET.indexName + " | stats count() as c by str0, str3 | head 2", 2);
    }
import java.util.List;  
 * Pure relational op, no scalar surface — exercises the row-cap path through
 * <p>Mirrors {@code CalciteHeadCommandIT}. {@code head N} lowers to {@code LogicalSort}  
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
            );  
import org.opensearch.client.Response;
 * {@code OpenSearchSort} and the DataFusion fragment driver's limit propagation.  
    public void testHeadFromOffset() throws IOException {  
        assertRowCount("source=" + DATASET.indexName + " | stats count() as c by str0 | head 2", 2);
    private static List<Object> row(Object... values) {
    }
        assertRowCount("source=" + DATASET.indexName + " | fields str2 | head 5 from 14", 3);  
 * SPDX-License-Identifier: Apache-2.0
        return Arrays.asList(values);
            assertEquals(
    // OpenSearchSortRule once dropped any collation-less limit over an aggregate, silently
import java.io.IOException;
        // (key00..key04) have str2 = one, two, three, null, five.
import java.util.Arrays;
    // ── helpers ─────────────────────────────────────────────────────────────────
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Row count for query: " + ppl, expected, rows.size());  
            dataProvisioned = true;  
 * The OpenSearch Contributors require contributions made to  
/**  
            DatasetProvisioner.provision(client(), DATASET);
    private static boolean dataProvisioned = false;  
    }
    @Override
    }
 * Self-contained integration test for PPL {@code head} on the analytics-engine route.
        // Calcs has 17 rows. Asking for more should cap at 17, not error.
        }
        }
    public void testHeadWithCountLargerThanData() throws IOException {
    public void testHeadAfterScalarStatsReturnsSingleRow() throws IOException {  
    public void testHeadValuesMatchInsertionOrder() throws IOException {  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        // `head 5 from 14` returns rows 14, 15, 16 (only 3 left).
            row("five")  
/*  
        // str0 (3) x str3 (2 non-null + nulls) yields >2 groups; head 2 must cap to exactly 2.  
package org.opensearch.analytics.qa;
        Map<String, Object> response = executePpl(ppl);
        if (dataProvisioned == false) {
        assertRowCount("source=" + DATASET.indexName + " | stats count() as c by str0 | head 10", 3);
        Map<String, Object> response = executePpl(ppl);
    }
        assertRowCount("source=" + DATASET.indexName + " | stats count() as c by str0 | sort - c | head 2", 2);  
    }  
            row((Object) null),
        assertRowCount("source=" + DATASET.indexName + " | fields str2 | head 3", 3);
 *
        );
            "source=" + DATASET.indexName + " | fields str2 | head 5",
public class HeadCommandIT extends AnalyticsRestTestCase {
        assertEquals("Row count for query: " + ppl, expected.length, actualRows.size());  
    }  
        // Parquet returns rows in storage / insertion order. The first 5 calcs rows
        // Scalar count() is one row; head N over it is a no-op but must still return that row.
    }
    // calcs str0 has 3 distinct groups (FURNITURE/OFFICE SUPPLIES/TECHNOLOGY); str3 has 2.
    }
    }
 * with {@code fetch=N} (no sort key); {@code head N from M} adds {@code offset=M}.
    public void testHeadAfterCompositeGroupedStatsLimitsRowCount() throws IOException {
        assertRowsEqual(  
    private void assertRowCount(String ppl, int expected) throws IOException {
                actualRows.get(i)
    public void testHeadAboveGroupCountReturnsAllGroups() throws IOException {
 *
    }  
 * compatible open source license.
    public void testSortedTopNAfterGroupedStatsLimitsRowCount() throws IOException {
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
