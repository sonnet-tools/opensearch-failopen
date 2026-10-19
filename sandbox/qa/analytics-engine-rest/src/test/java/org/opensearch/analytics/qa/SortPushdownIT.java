        assertTrue("two arm exchanges, plan:\n" + plan, plan.lines().filter(l -> l.contains("ExchangeReducer")).count() >= 2);
        ensureProvisioned();
    private static double num(Object cell) {
        ensureProvisioned();
    /** Multi-key sort: lexicographic ordering (primary asc, secondary asc on ties) survives the exchange. */
        String where = "where " + COL + " > 0";
/**
    private Map<String, Object> executeExplain(String ppl) throws Exception {
        Request request = new Request("POST", "/_analytics/ppl/_explain");
            assertTrue("primary key ascending at " + i, p0 <= p1);
                assertTrue("a Sort must be pushed below each arm exchange, plan:\n" + plan, lines[i + 1].contains("OpenSearchSort"));
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | " + filter + "stats " + agg));
        assertEquals(globalAgg("max", null), num(rows.get(0).get(0)), 0.0);
            assertTrue("rows not " + (ascending ? "ascending" : "descending") + " at " + i, ascending ? prev <= cur : prev >= cur);
            }
    }
            double p0 = num(rows.get(i - 1).get(0)), p1 = num(rows.get(i).get(0));
        }
    public void testSortAscHead_globalBottomN() throws Exception {
        return num(rows.get(0).get(0));
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | sort " + COL + " | head 10 | fields " + COL));
    /** Pure LIMIT (no ORDER BY): rewriter must skip; coordinator still bounds the result to N globally. */
    public void testLargeHead_globalOrder() throws Exception {
import java.util.Map;
 * End-to-end tests for non-aggregate sort pushdown on a multi-shard index. The result tests
        ensureProvisioned();
    }
            }
        ensureProvisioned();
        ensureProvisioned();
        assertEquals(Math.min(100, total), rows.size());
        assertMonotonic(rows, true);
        for (int i = 0; i + 1 < lines.length; i++) {
        assertEquals("top row must equal global max (union of index with itself)", globalAgg("max", null), num(rows.get(0).get(0)), 0.0);
        ensureProvisioned();
        long filtered = (long) globalAgg("count", where);
        }
    }
    /** Sort + WHERE: pushdown coexists with filter delegation; result is the filtered global top-N. */
    @SuppressWarnings("unchecked")
        return ((Number) cell).doubleValue();
        assertMonotonic(rows, false);
        );
        }
        assertMonotonic(rows, false);
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | head 10 | fields " + COL));
            provisioned = true;
            assertEquals("top must equal filtered max", globalAgg("max", where), num(rows.get(0).get(0)), 0.0);
    /** UNION ALL ({@code | append}): result is the global top-N, and the Sort is pushed below each arm's exchange. */
        long sorts = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
        for (int i = 1; i < rows.size(); i++) {
        String[] lines = plan.split("\n", -1);
            for (List<Object> r : rows) {
        if (provisioned == false) {
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | sort - " + COL + " | head 100 | fields " + COL));
 *
        Map<String, Object> profile = (Map<String, Object>) executeExplain("source = " + INDEX + " | sort - " + COL + " | head 10")
            if (lines[i].contains("ExchangeReducer")) {
            DatasetProvisioner.provision(client(), ClickBenchTestHelper.DATASET, 2);
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        assertEquals(Math.min(10, filtered), rows.size());
        assertMonotonic(rows, false);
        int er = plan.indexOf("ExchangeReducer");
        ensureProvisioned();
    private static List<List<Object>> datarows(Map<String, Object> result) {
import org.opensearch.client.Request;
        }
    public void testSortDescHead_globalTopN() throws Exception {
            }
    public void testPureLimit_noSort_count() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    }
        String plan = String.join("\n", (List<String>) profile.get("full_plan"));
    }
    private static final String COL = "ResolutionWidth";
        return assertOkAndParse(client().performRequest(request), "EXPLAIN: " + ppl);
    private double globalAgg(String fn, String where) throws Exception {
        String filter = where == null ? "" : where + " | ";
            .get("profile");
        for (int i = 1; i < rows.size(); i++) {
    private static final String INDEX = "parquet_hits";
            double cur = num(rows.get(i).get(0));
            executePpl("source = " + INDEX + " | sort " + COL + ", AdvEngineID | head 20 | fields " + COL + ", AdvEngineID")
 * assert the merged output is the correct, globally-ordered top-N (catches dropped rows /
/*
    public void testMultiKeySort_lexicographicOrder() throws Exception {
 */
        assertEquals(Math.min(10, total), rows.size());
        assertMonotonic(rows, false);
 * wrong ordering); {@link #testExplain_sortPushedToShardFragment()} asserts via EXPLAIN that
    /** sort asc + head 10 → global bottom-10, ascending. Top row must equal the global min. */
        String agg = "count".equals(fn) ? "count() as v" : fn + "(" + COL + ") as v";
        assertEquals("top row must equal global min", globalAgg("min", null), num(rows.get(0).get(0)), 0.0);
    /** EXPLAIN confirms the collated Sort is pushed below the exchange (into the shard fragment). */
    private void ensureProvisioned() throws Exception {
 * the collated Sort is actually pushed below the exchange (into the shard fragment).
    /** head larger than per-shard cardinality: still globally ordered, top == global max. */
    @SuppressWarnings("unchecked")
        assertEquals(10, rows.size());
        assertTrue("expected coordinator + pushed shard Sort, plan:\n" + plan, sorts >= 2);
    private static volatile boolean provisioned = false;
    /** sort desc + head 10 → global top-10, descending. Top row must equal the global max. */
public class SortPushdownIT extends AnalyticsRestTestCase {
            if (p0 == p1) {
    }
    }
    }
    public void testUnionAll_sortPushedIntoEachArm() throws Exception {
}
        List<List<Object>> rows = datarows(
        return (List<List<Object>>) result.get("datarows");
    }
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | sort - " + COL + " | head 10 | fields " + COL));
                assertTrue("secondary key ascending on tie at " + i, num(rows.get(i - 1).get(1)) <= num(rows.get(i).get(1)));
 * compatible open source license.
    public void testExplain_sortPushedToShardFragment() throws Exception {
        assertEquals(10, rows.size());
    /** {@code fn} is count/min/max; {@code where} is an optional leading filter clause (may be null). */
        assertEquals("top row must equal global max", globalAgg("max", null), num(rows.get(0).get(0)), 0.0);
    }
 * The OpenSearch Contributors require contributions made to
package org.opensearch.analytics.qa;
        assertTrue("a Sort must sit below the exchange (pushed down), plan:\n" + plan, er >= 0 && plan.indexOf("OpenSearchSort", er) > er);
        assertEquals(10, rows.size());
 * SPDX-License-Identifier: Apache-2.0
        List<List<Object>> rows = datarows(executePpl(union + " | fields " + COL));
        List<List<Object>> rows = datarows(executePpl("source = " + INDEX + " | " + where + " | sort - " + COL + " | head 10 | fields " + COL));
    }
        long total = (long) globalAgg("count", null);
        long total = (long) globalAgg("count", null);
    }
        if (filtered > 0) {
    @SuppressWarnings("unchecked")
 */
        String union = "source = " + INDEX + " | append [ source = " + INDEX + " ] | sort - " + COL + " | head 10";
        assertTrue("expected 1..20 rows", rows.size() > 0 && rows.size() <= 20);
        ensureProvisioned();
            double prev = num(rows.get(i - 1).get(0));
import java.util.List;
    }
                assertTrue("every row satisfies the filter", num(r.get(0)) > 0);
    }
        }
    public void testSortWithFilter_globalTopN() throws Exception {
    private static void assertMonotonic(List<List<Object>> rows, boolean ascending) {
        String plan = String.join("\n", (List<String>) ((Map<String, Object>) executeExplain(union).get("profile")).get("full_plan"));
