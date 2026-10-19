    /**
import org.opensearch.client.ResponseException;  
            + " | left semi join left=a, right=b ON a.str0 = b.str0"
     */
     * joins.  
    public void testCrossJoin() throws IOException {
        assertTrue(  
        assertTrue(
     * through planner + substrait + DataFusion is what's being exercised.
 * SPDX-License-Identifier: Apache-2.0
    public void tearDown() throws Exception {
    private void assertErrorContains(String ppl, String expectedSubstring) {
        assertSingleCountBothMppModes(ppl, 17L);
        assertRowCountPositiveBothMppModes(ppl);  
     * Cross join (join predicate {@code 1=1}). Exercises the degenerate  
 * The OpenSearch Contributors require contributions made to  
            + CALCS_ALT.indexName
     * the implicit upstream input.  
     * SINGLETON output satisfies the aggregate's input demand; no PARTIAL/FINAL
        assertRowCountPositiveBothMppModes(ppl);
import java.io.IOException;
            + CALCS.indexName  
 * analytics-engine route (POST /_plugins/_ppl).
     */
            + " | appendcol [ stats count() as alt_total ]"  
     */
    /**
     * asserting a single non-negative count row under both modes. Used where the
        // 3 distinct str0 values after grouping.  
            + " | stats count() as cnt";
        @SuppressWarnings("unchecked")  
    }
    }
            + " | inner join left=ab, right=c ON ab.str0 = c.str0"
import java.util.List;  
    // ── lookup (LogicalJoin LEFT) ──────────────────────────────────────────────
        applySetting("analytics.mpp.enabled", "false");  
        Map<String, Object> response = executePpl(ppl);
            + " key REPLACE str0 AS str2"  
        final String ppl = "source="  
    }
 *   <li>{@code lookup} — LogicalJoin (LEFT) with rename/replace semantics</li>
        final String ppl = "source="
     * collapses CBO to the COORD-singleton alternative and the {@code mpp.enabled}  
            + " | inner join left=a, right=b ON a.str0 = b.str0"
 * split rules are skipped, every join routes through coordinator-centric) and
    /** Left semi join — returns left rows that have at least one match on the right. */  
            + " | stats count() as cnt";
            String body;  
    private void resetSetting(String key) throws IOException {
            "[" + mode + "] Expected numeric count for query: " + ppl + " but got: " + actual,  
     * and hash-shuffle split rules are eligible to fire under {@code mpp.enabled=true}.
    private void assertRowCountPositive(String ppl, String mode) throws IOException {
    private static final Dataset CALCS_ALT = new Dataset("calcs", "calcs_alt");  
            + CALCS_ALT.indexName  
        assertSingleCountBothMppModes(ppl, 3L);
            + " | stats count() as cnt";
            + CALCS.indexName
    @Override  
            + CALCS.indexName
    /**
            + " | stats count() as cnt";  
        );  
            + CALCS.indexName
    /**
            + " | stats count() as cnt";
            fail("Unexpected IOException: " + e);
    }  
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");  
        Request request = new Request("PUT", "/_cluster/settings");
     */  
            "[" + mode + "] Expected numeric count for query: " + ppl + " but got: " + actual,  
        final String ppl = "source="
        assertEquals("[" + mode + "] Count mismatch for query: " + ppl, expected, ((Number) actual).longValue());  
     * the same expected single-row count under both modes.
    /**
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    }
            + " | inner join left=a, right=b ON a.str0 = b.str0"
    }
        }  
    }
 */
            + " [ source=" + CALCS_ALT.indexName + " | fields key, str0 ]"  
     * scan is gathered to coord with its own per-side ER; the outer join sits over
    /** Left anti join — returns left rows with NO match on the right. */
    public void testLookup() throws IOException {
            + " | where str0 = 'TECHNOLOGY' | fields key, str0 ]"  
        assertSingleCountBothMppModes(ppl, 3L);
            + " | stats count() as cnt";
     * row is retained.  
        final String ppl = "source="  
 *   <li>{@code join} — direct LogicalJoin (inner / left / cross)</li>  
            + " | stats count() as cnt";  
        // Data is provisioned by the onBeforeQuery() hook (fired via @Before before each test).
        applySetting("analytics.mpp.enabled", "true");
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
        assertSingleCountBothMppModes(ppl, 89L);
            + " | fields key, int0, str0"  
            DatasetProvisioner.provision(client(), CALCS, SHARDS);  
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");  
     * filter so some right rows have no match and appear with nulls on the left.
    private void assertRowCountPositiveBothMppModes(String ppl) throws IOException {
        super.tearDown();
            + " | where str0 = 'TECHNOLOGY' | fields key, str0 ]"  
    /**
     */  
        final String ppl = "source="
 * without pulling in a second dataset. Row-count assertions are used for this
    // ── join (direct LogicalJoin) ──────────────────────────────────────────────  
/**  
    @Override
            + " | stats count() as cnt";
            + " | stats count() as right_cnt by str0 ]"
    private static final int SHARDS = 3;  
            + " | lookup "  
import java.util.Map;
 *
    }  
            + CALCS.indexName
            ((Number) actual).longValue() >= 0
 * a graph-shaped dataset with self-referential edges that the calcs dataset  
            + CALCS_ALT.indexName
        // Reset the MPP gate after every test so a failure can't leak state into the next.  
     * converted to pin an expected error rather than skip entirely.
    }
    }
            + " | stats count() as left_cnt by str0"
     * split fires (no shuffle to split across).
        final String ppl = "source="
        // Use transient so a test failure doesn't leave a persistent setting on the cluster.
            }
     */
            + " [ source=" + CALCS_ALT.indexName + " | stats count() as right_cnt by str0 ]"
            + " | stats count() as total by str0 | sort str0"
    /**  
            + " | stats count() as cnt";
        assertNotNull("[" + mode + "] Response missing 'datarows' for query: " + ppl, rows);
        assertSingleCountBothMppModes(ppl, 3L);  
            + " | stats count() as cnt";  
 * <p>{@code graphLookup} is intentionally out of scope for this IT — it requires
        resetSetting("analytics.mpp.enabled");
     * Inner equi-join across two indices of the calcs dataset, grouped on  
 * once with {@code analytics.mpp.enabled=true} (CBO is free to pick BROADCAST or  
    protected void onBeforeQuery() throws IOException {
     * is a non-negative number. Used for join kinds where exact row-count expectations  
        );
    private void applySetting(String key, String value) throws IOException {  
        Object actual = rows.get(0).get(0);
        );
     * Execute a PPL query expected to return a single {@code cnt} row and assert the count
    private void assertSingleCountBothMppModes(String ppl, long expected) throws IOException {
     * Lookup with REPLACE: left table rows are enriched with {@code str0} from
            + " [ source="
     * methods — {@code client()} is not available in {@code @BeforeClass}.
    public void testChainedInnerJoin() throws IOException {
            + CALCS.indexName  
            + " | fields key ]"
                body = e.getMessage();
    }
 * HASH_SHUFFLE, though the small calcs dataset and aggregated probes typically
    /**
     */
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    }
 */  
 * <p>Every test runs the same query twice — once with  
     * the lookup → LogicalJoin lowering.
     * Both rules require multi-shard SHARD scans on both sides; single-shard data
 * both modes — that guards both code paths against regressions on these shapes  
     */  
 * compatible open source license.
     * Lazily provision both calcs indices on first invocation. Called inside test  
            dataProvisioned = true;
    /**
        assertRowCountPositive(ppl, "mpp.enabled=false");
        assertSingleCount(ppl, expected, "mpp.enabled=false");
 * {@code analytics.mpp.enabled=false} (kill switch on; broadcast and hash-shuffle
    public void testLookupReplaceWithRename() throws IOException {  
                body.contains(expectedSubstring)
            );  
     * rel, which DataFusion executes as a NestedLoopJoin.
            + CALCS_ALT.indexName
    public void testAppendcol() throws IOException {
     * Run the PPL twice — once with each {@code analytics.mpp.enabled} value —
            + " | stats count() as cnt";  
        assertTrue(
 * exploratory coverage — the IT focuses on whether each command plans, converts  
        assertEquals("[" + mode + "] Expected single count row for query: " + ppl, 1, rows.size());  
     */
            + " | inner join left=a, right=b ON a.str0 = b.str0"
     * appendcol pairs the outer pipeline with a subsearch by synthesized row
        assertRowCountPositive(ppl, "mpp.enabled=true");
        Map<String, Object> response = executePpl(ppl);
    // ── appendcol (LogicalJoin FULL OUTER by row_num) ──────────────────────────
            + " | fields key"
     * number, lowered to {@code ROW_NUMBER() OVER (ORDER BY …)} + a FULL OUTER  
 * keep CBO on coord-centric anyway). The same expected count is asserted under
    }  
        assertEquals("[" + mode + "] Expected single count row for query: " + ppl, 1, rows.size());  
     * toggle has no effect on the physical plan.
 * does not provide.
    }
            + " | sort str0"  
     * two indices then a SINGLE aggregate above the join. The Join's COORDINATOR  
     * {@code str0}. Both sides are pre-aggregated to a narrow keyword-only
    /** Execute a PPL query expected to return a single {@code cnt} row and assert the value. */  
        assertSingleCountBothMppModes(ppl, 3L);
 * Integration tests for PPL commands that lower to {@code LogicalJoin} on the
     */
            + CALCS_ALT.indexName
     * Mirrors {@code PlanShapeTests.testJoinThenAggregate_2shard}: inner join across
            + " | left anti join left=a, right=b ON a.str0 = b.str0"  
        final String ppl = "source="
     * schema so the join output is scalar-only.
            Map<String, Object> response = executePpl(ppl);  
        final String ppl = "source="  
            + CALCS_ALT.indexName
    }  
 * <ul>
     * coordinator-centric) and once with {@code true} (let CBO pick) — asserting
        try {
            + CALCS_ALT.indexName
            assertTrue(  
    }
            + CALCS.indexName
     * Left outer join. Drops one str0 value from the right side via a filter so
     * over the joined output. Sort runs at coord (Join already delivers SINGLETON)  
    /**
        assertNotNull("[" + mode + "] Response missing 'datarows' for query: " + ppl, rows);
        }  
            "[" + mode + "] Expected non-negative count for query: " + ppl + " but got: " + actual,
    private static boolean dataProvisioned = false;
            + " | where str0 = 'TECHNOLOGY' | fields key, str0"  
     * Lookup with REPLACE … AS rename — the right-side value overwrites a
            + " | lookup "
            + " [ source=" + CALCS.indexName + " | stats count() as cnt_c by str0 ]"  
            + " | fields key, int0, str0"
    }
 *
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
     */
        Object actual = rows.get(0).get(0);
     */
            + CALCS.indexName
     * Run the PPL twice — once with {@code analytics.mpp.enabled=false} (force  
        assertSingleCount(ppl, expected, "mpp.enabled=true");  
     * differently-named left column. Exercises the projection wrapper emitted by  
     * with no extra ER between them.
        client().performRequest(request);
        // Data is provisioned by the onBeforeQuery() hook (fired via @Before before each test).  
    private static final Dataset CALCS = new Dataset("calcs", "calcs");
            + " | fields key, str0"
            + " | inner join left=a, right=b ON a.str0 = b.str0"  
     * no-equi-condition shape — Isthmus emits it as a Substrait {@code Cross}
 * <p>Exercises the three commands that produce a join RelNode:
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
    public void testJoinThenAggregate() throws IOException {
            + " | fields key, str0 ]"
    }
            + " | join left=a, right=b on 1=1"
            + " [ source="  
            + " | stats count() as cnt by str0"
            + " [ source=" + CALCS_ALT.indexName + " | stats count() as cnt_b by str0 ]"
        } catch (ResponseException e) {
            + " | stats count() as cnt_a by str0"
    public void testLeftOuterJoin() throws IOException {
        assertRowCountPositiveBothMppModes(ppl);
        // All 3 chained joins on str0 — each side groups to 3 rows, equi-join yields 3.
    private void assertSingleCount(String ppl, long expected, String mode) throws IOException {
     * LogicalJoin on the row numbers. PPL grammar does not allow {@code source=…}
    /**
 * and {@code calcs_alt}) so two-table joins have distinct right-hand operands
    public void testJoinThenSort() throws IOException {  
import org.opensearch.client.Response;
     * Right outer join — mirror of left outer. Drops a value from the LEFT side via a  
 * </ul>  
 *   <li>{@code appendcol} — LogicalJoin (FULL OUTER) by synthesized row number</li>
 * regardless of whether MPP fires.
        client().performRequest(request);
    // ── Combinations: matches the structural UTs in PlanShapeTests ──────────────
            + " | fields key, str0"
    @SuppressWarnings("unused")  
     * {@code expectedSubstring}. Kept for future use when a gated test is  
     * exact row count over the calcs dataset isn't pinned (right/semi/anti).  
            + " [ source="
     * a subset of left rows have no match and appear with nulls on the right.  
    }
            + " | fields key, str0"
     */
            + CALCS.indexName  
    public void testRightOuterJoin() throws IOException {  
        } catch (IOException e) {
        assertSingleCountBothMppModes(ppl, 3L);
     * the inner join's SINGLETON output. Verifies trait propagation through nested
     * the right table, matched on {@code key}. LEFT join semantics — every left
     */  
            } catch (Exception ioe) {  
    public void testLeftAntiJoin() throws IOException {
 *
    public void testInnerJoin() throws IOException {
            + " key REPLACE str0"
            DatasetProvisioner.provision(client(), CALCS_ALT, SHARDS);
 *
            + CALCS_ALT.indexName
        final String ppl = "source="
    /**
            actual instanceof Number
            actual instanceof Number
            + " | right join left=a, right=b ON a.str0 = b.str0"
        applySetting("analytics.mpp.enabled", "true");  
            + " | fields key, str0 ]"
            + " | fields key, str0"
            + " [ source="
            + " | stats count() as cnt";
 *  
    /**
     * inside the {@code appendcol [ … ]} brackets — the subsearch operates on
        assertSingleCountBothMppModes(ppl, 17L);
            + " | stats count() as left_cnt by str0"  
/*  
            try {
 * this file be licensed under the Apache-2.0 license or a
            + " | left join left=a, right=b ON a.str0 = b.str0"  
     * Mirrors {@code PlanShapeTests.testChainedJoin_2shard}: A ⨝ B ⨝ C. Each leaf  
    /**
        Request request = new Request("PUT", "/_cluster/settings");
        final String ppl = "source="
        final String ppl = "source="  
        @SuppressWarnings("unchecked")  
     * Send a PPL query expecting a failure and assert the response body contains
     */
import org.opensearch.client.Request;
        final String ppl = "source="  
    // ── helpers ────────────────────────────────────────────────────────────────  
 * to Substrait, and executes end-to-end rather than on exact row values.
     * aren't pinned (right/semi/anti over the calcs dataset) but end-to-end execution
            + CALCS.indexName  
    public void testLeftSemiJoin() throws IOException {
     * Mirrors {@code PlanShapeTests.testJoinThenSort_2shard}: inner join then Sort
            + CALCS.indexName
}
     */  
public class JoinCommandIT extends AnalyticsRestTestCase {  
    }  
        if (dataProvisioned == false) {
    /**
    }  
     * Override the calcs mapping's default {@code number_of_shards: 1} so the broadcast  
            + CALCS.indexName
package org.opensearch.analytics.qa;
            + " [ source="  
        applySetting("analytics.mpp.enabled", "false");
            + " [ source="  
 * <p>Uses the {@code calcs} dataset provisioned into two indices ({@code calcs}  
        assertSingleCountBothMppModes(ppl, 289L);
    /**  
