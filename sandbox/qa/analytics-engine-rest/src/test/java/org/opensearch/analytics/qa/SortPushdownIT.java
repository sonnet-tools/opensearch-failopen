                assertTrue("every row satisfies the filter", num(r.get(0)) > 0);
    }
        long total = (long) globalAgg("count", null);  
        assertEquals("top row must equal global max (union of index with itself)", globalAgg("max", null), num(rows.get(0).get(0)), 0.0);
        assertTrue("a Sort must sit below the exchange (pushed down), plan:\n" + plan, er >= 0 && plan.indexOf("OpenSearchSort", er) > er);
        ensureProvisioned();  
    }  
    /** Pure LIMIT (no ORDER BY): rewriter must skip; coordinator still bounds the result to N globally. */  
        Request request = new Request("POST", "/_analytics/ppl/_explain");  
        assertEquals(Math.min(10, filtered), rows.size());
 * this file be licensed under the Apache-2.0 license or a
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | " + filter + "stats " + agg));
    private static final String INDEX = "parquet_hits";  
}
        assertEquals(Math.min(100, total), rows.size());
        return assertOkAndParse(client().performRequest(request), "EXPLAIN: " + ppl);
    }
            if (lines[i].contains("ExchangeReducer")) {
import java.util.List;  
        for (int i = 1; i < rows.size(); i++) {
    /** EXPLAIN confirms the collated Sort is pushed below the exchange (into the shard fragment). */  
        return num(rows.get(0).get(0));  
        int er = plan.indexOf("ExchangeReducer");  
    private double globalAgg(String fn, String where) throws Exception {
        assertEquals("top row must equal global max", globalAgg("max", null), num(rows.get(0).get(0)), 0.0);
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
 */  
        ensureProvisioned();
    public void testMultiKeySort_lexicographicOrder() throws Exception {
    private static void assertMonotonic(List<List<Object>> rows, boolean ascending) {  
 * wrong ordering); {@link #testExplain_sortPushedToShardFragment()} asserts via EXPLAIN that  
    private void ensureProvisioned() throws Exception {  
public class SortPushdownIT extends AnalyticsRestTestCase {  
        List<List<Object>> rows = datarows(executePpl(union + " | fields " + COL));
            double prev = num(rows.get(i - 1).get(0));
            double p0 = num(rows.get(i - 1).get(0)), p1 = num(rows.get(i).get(0));  
        assertMonotonic(rows, false);  
        }
            }
    /** {@code fn} is count/min/max; {@code where} is an optional leading filter clause (may be null). */
            if (p0 == p1) {
 * The OpenSearch Contributors require contributions made to  
        if (provisioned == false) {
/**  
    /** Sort + WHERE: pushdown coexists with filter delegation; result is the filtered global top-N. */
        assertEquals(10, rows.size());
        }  
    public void testSortAscHead_globalBottomN() throws Exception {
    @SuppressWarnings("unchecked")
    private Map<String, Object> executeExplain(String ppl) throws Exception {
        assertMonotonic(rows, false);
        ensureProvisioned();  
        String union = "source = " + INDEX + " | append [ source = " + INDEX + " ] | sort - " + COL + " | head 10";
            }  
    @SuppressWarnings("unchecked")
    public void testPureLimit_noSort_count() throws Exception {
        ensureProvisioned();  
        ensureProvisioned();
 * the collated Sort is actually pushed below the exchange (into the shard fragment).
/*  
    /** UNION ALL ({@code | append}): result is the global top-N, and the Sort is pushed below each arm's exchange. */
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | head 10 | fields " + COL));
    }  
        return (List<List<Object>>) result.get("datarows");
        long filtered = (long) globalAgg("count", where);  
            executePpl("source = " + INDEX + " | sort " + COL + ", AdvEngineID | head 20 | fields " + COL + ", AdvEngineID")
    }
    private static List<List<Object>> datarows(Map<String, Object> result) {  
        );  
        assertEquals(globalAgg("max", null), num(rows.get(0).get(0)), 0.0);  
    }
        }
    }
 * SPDX-License-Identifier: Apache-2.0
        List<List<Object>> rows = datarows(
    /** head larger than per-shard cardinality: still globally ordered, top == global max. */
    public void testExplain_sortPushedToShardFragment() throws Exception {
    }  
    @SuppressWarnings("unchecked")
    public void testSortWithFilter_globalTopN() throws Exception {  
    private static double num(Object cell) {
    /** Multi-key sort: lexicographic ordering (primary asc, secondary asc on ties) survives the exchange. */
 * compatible open source license.
    public void testUnionAll_sortPushedIntoEachArm() throws Exception {  
            double cur = num(rows.get(i).get(0));  
            for (List<Object> r : rows) {  
            provisioned = true;  
    public void testLargeHead_globalOrder() throws Exception {  
        ensureProvisioned();
            .get("profile");
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | sort " + COL + " | head 10 | fields " + COL));
 * assert the merged output is the correct, globally-ordered top-N (catches dropped rows /
    }
        String where = "where " + COL + " > 0";
        assertMonotonic(rows, true);  
 */
    public void testSortDescHead_globalTopN() throws Exception {
            assertTrue("primary key ascending at " + i, p0 <= p1);
 *
        String agg = "count".equals(fn) ? "count() as v" : fn + "(" + COL + ") as v";
    /** sort asc + head 10 → global bottom-10, ascending. Top row must equal the global min. */
                assertTrue("a Sort must be pushed below each arm exchange, plan:\n" + plan, lines[i + 1].contains("OpenSearchSort"));
        long total = (long) globalAgg("count", null);
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | sort - " + COL + " | head 100 | fields " + COL));  
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | " + where + " | sort - " + COL + " | head 10 | fields " + COL));
        if (filtered > 0) {
    private static volatile boolean provisioned = false;
import org.opensearch.client.Request;
        assertMonotonic(rows, false);  
 * End-to-end tests for non-aggregate sort pushdown on a multi-shard index. The result tests
                assertTrue("secondary key ascending on tie at " + i, num(rows.get(i - 1).get(1)) <= num(rows.get(i).get(1)));  
        assertEquals("top row must equal global min", globalAgg("min", null), num(rows.get(0).get(0)), 0.0);
        String plan = String.join("\n", (List<String>) ((Map<String, Object>) executeExplain(union).get("profile")).get("full_plan"));  
        String filter = where == null ? "" : where + " | ";  
        assertEquals(10, rows.size());
        Map<String, Object> profile = (Map<String, Object>) executeExplain("source = " + INDEX + " | sort - " + COL + " | head 10")
    }
        String plan = String.join("\n", (List<String>) profile.get("full_plan"));  
    private static final String COL = "ResolutionWidth";
        String[] lines = plan.split("\n", -1);
        assertTrue("expected coordinator + pushed shard Sort, plan:\n" + plan, sorts >= 2);
            assertEquals("top must equal filtered max", globalAgg("max", where), num(rows.get(0).get(0)), 0.0);
        assertEquals(Math.min(10, total), rows.size());
        }
    }  
        for (int i = 0; i + 1 < lines.length; i++) {  
        long sorts = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
import java.util.Map;
        ensureProvisioned();
    }  
    /** sort desc + head 10 → global top-10, descending. Top row must equal the global max. */
            assertTrue("rows not " + (ascending ? "ascending" : "descending") + " at " + i, ascending ? prev <= cur : prev >= cur);
            }
        assertEquals(10, rows.size());
package org.opensearch.analytics.qa;
    }
        ensureProvisioned();  
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | sort - " + COL + " | head 10 | fields " + COL));
        assertTrue("two arm exchanges, plan:\n" + plan, plan.lines().filter(l -> l.contains("ExchangeReducer")).count() >= 2);
        assertTrue("expected 1..20 rows", rows.size() > 0 && rows.size() <= 20);
            DatasetProvisioner.provision(client(), ClickBenchTestHelper.DATASET, 2);
        }
        for (int i = 1; i < rows.size(); i++) {
        return ((Number) cell).doubleValue();
    }
        assertMonotonic(rows, false);  
