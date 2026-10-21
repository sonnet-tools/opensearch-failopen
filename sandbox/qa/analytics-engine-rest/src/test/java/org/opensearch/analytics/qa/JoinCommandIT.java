     * the right table, matched on {@code key}. LEFT join semantics — every left
            try {
     * split fires (no shuffle to split across).
     * Run the PPL twice — once with each {@code analytics.mpp.enabled} value —
 *   <li>{@code lookup} — LogicalJoin (LEFT) with rename/replace semantics</li>
 * this file be licensed under the Apache-2.0 license or a
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
        } catch (ResponseException e) {
        );
     */
            + " | stats count() as left_cnt by str0"
    /**
    /**
            + CALCS.indexName
     * Override the calcs mapping's default {@code number_of_shards: 1} so the broadcast
     * Mirrors {@code PlanShapeTests.testJoinThenSort_2shard}: inner join then Sort
                body.contains(expectedSubstring)
        try {
        final String ppl = "source="
    }
 */
            DatasetProvisioner.provision(client(), CALCS_ALT, SHARDS);
        assertSingleCount(ppl, expected, "mpp.enabled=true");
    private void applySetting(String key, String value) throws IOException {
            + CALCS_ALT.indexName
            + " | lookup "
/**
     * Left outer join. Drops one str0 value from the right side via a filter so
            DatasetProvisioner.provision(client(), CALCS, SHARDS);
            + CALCS_ALT.indexName
            + " | appendcol [ stats count() as alt_total ]"
            + CALCS.indexName
     * scan is gathered to coord with its own per-side ER; the outer join sits over
    protected void onBeforeQuery() throws IOException {
    /**
     * rel, which DataFusion executes as a NestedLoopJoin.
    }
        assertSingleCountBothMppModes(ppl, 17L);
    }
package org.opensearch.analytics.qa;
            }
    }
    @SuppressWarnings("unused")
 *   <li>{@code join} — direct LogicalJoin (inner / left / cross)</li>
            + " | inner join left=ab, right=c ON ab.str0 = c.str0"
        // Data is provisioned by the onBeforeQuery() hook (fired via @Before before each test).
        applySetting("analytics.mpp.enabled", "false");
     * with no extra ER between them.
            + " | fields key, str0 ]"
    public void testJoinThenAggregate() throws IOException {
        final String ppl = "source="
    // ── appendcol (LogicalJoin FULL OUTER by row_num) ──────────────────────────
            + " [ source="
            + " | inner join left=a, right=b ON a.str0 = b.str0"
     * schema so the join output is scalar-only.
     */
    public void testChainedInnerJoin() throws IOException {
     */
 * The OpenSearch Contributors require contributions made to
        assertTrue(
            fail("Unexpected IOException: " + e);
            + " [ source="
    }
     * Execute a PPL query expected to return a single {@code cnt} row and assert the count
            dataProvisioned = true;
        assertSingleCountBothMppModes(ppl, 3L);
            );
        applySetting("analytics.mpp.enabled", "true");
     */
        assertSingleCountBothMppModes(ppl, 3L);
 * <p>Every test runs the same query twice — once with
    }
            + " | stats count() as left_cnt by str0"
            + " | lookup "
     * Lazily provision both calcs indices on first invocation. Called inside test
    }
    }
     * aren't pinned (right/semi/anti over the calcs dataset) but end-to-end execution
            + " | stats count() as cnt by str0"
     * Run the PPL twice — once with {@code analytics.mpp.enabled=false} (force
    }
 * <ul>
            + " | fields key, int0, str0"
    }
        client().performRequest(request);
     * Send a PPL query expecting a failure and assert the response body contains
     * number, lowered to {@code ROW_NUMBER() OVER (ORDER BY …)} + a FULL OUTER
        assertTrue(
            + " | inner join left=a, right=b ON a.str0 = b.str0"
    }
 *
            + " | stats count() as cnt";
        assertRowCountPositiveBothMppModes(ppl);
            + " | stats count() as cnt";
     * and hash-shuffle split rules are eligible to fire under {@code mpp.enabled=true}.
            + " [ source="
            + " | stats count() as cnt";
    }
 *
    public void testInnerJoin() throws IOException {
 * {@code analytics.mpp.enabled=false} (kill switch on; broadcast and hash-shuffle
 * a graph-shaped dataset with self-referential edges that the calcs dataset
     * SINGLETON output satisfies the aggregate's input demand; no PARTIAL/FINAL
    public void testCrossJoin() throws IOException {
        // 3 distinct str0 values after grouping.
            + " | fields key, str0"
        applySetting("analytics.mpp.enabled", "false");
    // ── join (direct LogicalJoin) ──────────────────────────────────────────────
    public void testLookupReplaceWithRename() throws IOException {
     */
            + " | fields key, str0"
        super.tearDown();
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
     */
    private static final int SHARDS = 3;
            + " | stats count() as cnt";
        assertRowCountPositiveBothMppModes(ppl);
    }
    /**
                body = e.getMessage();
        Object actual = rows.get(0).get(0);
            + " | stats count() as right_cnt by str0 ]"
            ((Number) actual).longValue() >= 0
    @Override
    /**
     */
     * converted to pin an expected error rather than skip entirely.
            + " [ source=" + CALCS_ALT.indexName + " | stats count() as cnt_b by str0 ]"
import java.util.List;
        final String ppl = "source="
     * through planner + substrait + DataFusion is what's being exercised.
            + " | inner join left=a, right=b ON a.str0 = b.str0"
            + " | stats count() as cnt";
     * filter so some right rows have no match and appear with nulls on the left.
     * methods — {@code client()} is not available in {@code @BeforeClass}.
            + CALCS_ALT.indexName
        client().performRequest(request);
        );
 * compatible open source license.
            + " | stats count() as total by str0 | sort str0"
import org.opensearch.client.Response;
            + CALCS.indexName
 * without pulling in a second dataset. Row-count assertions are used for this
     * coordinator-centric) and once with {@code true} (let CBO pick) — asserting
 * <p>{@code graphLookup} is intentionally out of scope for this IT — it requires
        assertEquals("[" + mode + "] Expected single count row for query: " + ppl, 1, rows.size());
        );
        final String ppl = "source="
     * {@code str0}. Both sides are pre-aggregated to a narrow keyword-only
    // ── Combinations: matches the structural UTs in PlanShapeTests ──────────────
    /**
        Object actual = rows.get(0).get(0);
    // ── lookup (LogicalJoin LEFT) ──────────────────────────────────────────────
            + " | join left=a, right=b on 1=1"
     * no-equi-condition shape — Isthmus emits it as a Substrait {@code Cross}
            + " [ source="
    private void assertRowCountPositiveBothMppModes(String ppl) throws IOException {
 * exploratory coverage — the IT focuses on whether each command plans, converts
public class JoinCommandIT extends AnalyticsRestTestCase {
     * LogicalJoin on the row numbers. PPL grammar does not allow {@code source=…}
            + " | where str0 = 'TECHNOLOGY' | fields key, str0"
 *
            + " [ source=" + CALCS_ALT.indexName + " | fields key, str0 ]"
    /** Left semi join — returns left rows that have at least one match on the right. */
 * Integration tests for PPL commands that lower to {@code LogicalJoin} on the
            + " | stats count() as cnt";
            + " | fields key, str0"
        final String ppl = "source="
 * split rules are skipped, every join routes through coordinator-centric) and
            + " [ source=" + CALCS.indexName + " | stats count() as cnt_c by str0 ]"
        assertSingleCountBothMppModes(ppl, 17L);
 * and {@code calcs_alt}) so two-table joins have distinct right-hand operands
            assertTrue(
 * once with {@code analytics.mpp.enabled=true} (CBO is free to pick BROADCAST or
            + " key REPLACE str0 AS str2"
            + CALCS.indexName
     */
     * row is retained.
        assertTrue(
    }
 * both modes — that guards both code paths against regressions on these shapes
    }
     * the same expected single-row count under both modes.
            actual instanceof Number
        Request request = new Request("PUT", "/_cluster/settings");
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
        assertNotNull("[" + mode + "] Response missing 'datarows' for query: " + ppl, rows);
        final String ppl = "source="
     * differently-named left column. Exercises the projection wrapper emitted by
            + " key REPLACE str0"
            + " [ source="
 */
        } catch (IOException e) {
     * inside the {@code appendcol [ … ]} brackets — the subsearch operates on
     */
}
            + " [ source=" + CALCS_ALT.indexName + " | stats count() as right_cnt by str0 ]"
            + " | stats count() as cnt";
    private void assertSingleCount(String ppl, long expected, String mode) throws IOException {
        final String ppl = "source="
     * a subset of left rows have no match and appear with nulls on the right.
            "[" + mode + "] Expected numeric count for query: " + ppl + " but got: " + actual,
     * Inner equi-join across two indices of the calcs dataset, grouped on
     */
            + CALCS.indexName
     * exact row count over the calcs dataset isn't pinned (right/semi/anti).
     * the lookup → LogicalJoin lowering.
    public void testLookup() throws IOException {
        assertSingleCountBothMppModes(ppl, 3L);
 *
 *   <li>{@code appendcol} — LogicalJoin (FULL OUTER) by synthesized row number</li>
            + " | stats count() as cnt";
     * Mirrors {@code PlanShapeTests.testJoinThenAggregate_2shard}: inner join across
            + CALCS.indexName
    /**
     */
    /**
        assertRowCountPositive(ppl, "mpp.enabled=true");
     * asserting a single non-negative count row under both modes. Used where the
            + " | where str0 = 'TECHNOLOGY' | fields key, str0 ]"
            + CALCS.indexName
     * appendcol pairs the outer pipeline with a subsearch by synthesized row
    /**
    public void testLeftOuterJoin() throws IOException {
     */
     * over the joined output. Sort runs at coord (Join already delivers SINGLETON)
        // Reset the MPP gate after every test so a failure can't leak state into the next.
        assertNotNull("[" + mode + "] Response missing 'datarows' for query: " + ppl, rows);
        assertSingleCountBothMppModes(ppl, 3L);
 * HASH_SHUFFLE, though the small calcs dataset and aggregated probes typically
    /**
            String body;
    private static final Dataset CALCS_ALT = new Dataset("calcs", "calcs_alt");
    }
    private void assertSingleCountBothMppModes(String ppl, long expected) throws IOException {
    // ── helpers ────────────────────────────────────────────────────────────────
     * Both rules require multi-shard SHARD scans on both sides; single-shard data
            + " | left join left=a, right=b ON a.str0 = b.str0"
        @SuppressWarnings("unchecked")
    /**
            + CALCS_ALT.indexName
    /**
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("[" + mode + "] Count mismatch for query: " + ppl, expected, ((Number) actual).longValue());
     * Mirrors {@code PlanShapeTests.testChainedJoin_2shard}: A ⨝ B ⨝ C. Each leaf
import org.opensearch.client.Request;
import java.io.IOException;
        final String ppl = "source="
            + " | stats count() as cnt";
 * keep CBO on coord-centric anyway). The same expected count is asserted under
            Map<String, Object> response = executePpl(ppl);
     * toggle has no effect on the physical plan.
            "[" + mode + "] Expected non-negative count for query: " + ppl + " but got: " + actual,
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
            + CALCS.indexName
        assertSingleCountBothMppModes(ppl, 289L);
 *
    public void testAppendcol() throws IOException {
    /**
    private static final Dataset CALCS = new Dataset("calcs", "calcs");
        final String ppl = "source="
            + CALCS_ALT.indexName
        Map<String, Object> response = executePpl(ppl);
        assertSingleCountBothMppModes(ppl, 89L);
    /**
        Request request = new Request("PUT", "/_cluster/settings");
    /**
    public void tearDown() throws Exception {
 * </ul>
            + " | sort str0"
        final String ppl = "source="
            + " | inner join left=a, right=b ON a.str0 = b.str0"
        // Data is provisioned by the onBeforeQuery() hook (fired via @Before before each test).
 * <p>Uses the {@code calcs} dataset provisioned into two indices ({@code calcs}
     * Lookup with REPLACE … AS rename — the right-side value overwrites a
            + CALCS.indexName
        @SuppressWarnings("unchecked")
            + CALCS.indexName
    }
            + " | stats count() as cnt";
        assertSingleCountBothMppModes(ppl, 3L);
    @Override
        final String ppl = "source="
        applySetting("analytics.mpp.enabled", "true");
        final String ppl = "source="
    }
    private static boolean dataProvisioned = false;
 * <p>Exercises the three commands that produce a join RelNode:
        assertRowCountPositive(ppl, "mpp.enabled=false");
        assertSingleCount(ppl, expected, "mpp.enabled=false");
import org.opensearch.client.ResponseException;
            + " | stats count() as cnt";
     * {@code expectedSubstring}. Kept for future use when a gated test is
            + CALCS_ALT.indexName
    public void testJoinThenSort() throws IOException {
            + " | fields key, str0 ]"
        if (dataProvisioned == false) {
        assertRowCountPositiveBothMppModes(ppl);
            + " | fields key ]"
            } catch (Exception ioe) {
    /** Left anti join — returns left rows with NO match on the right. */
     * joins.
            + " | stats count() as cnt";
    public void testRightOuterJoin() throws IOException {
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
    }
            + " | stats count() as cnt_a by str0"
 * to Substrait, and executes end-to-end rather than on exact row values.
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    }
        }
 * analytics-engine route (POST /_plugins/_ppl).
    private void assertRowCountPositive(String ppl, String mode) throws IOException {
        Map<String, Object> response = executePpl(ppl);
     * Right outer join — mirror of left outer. Drops a value from the LEFT side via a
    private void resetSetting(String key) throws IOException {
            + " | fields key, int0, str0"
     */
            actual instanceof Number
 * does not provide.
            + " | fields key"
            + CALCS.indexName
     * the inner join's SINGLETON output. Verifies trait propagation through nested
        resetSetting("analytics.mpp.enabled");
            + " | where str0 = 'TECHNOLOGY' | fields key, str0 ]"
     * Lookup with REPLACE: left table rows are enriched with {@code str0} from
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
     */
            + " [ source="
     * two indices then a SINGLE aggregate above the join. The Join's COORDINATOR
            + " | fields key, str0"
            "[" + mode + "] Expected numeric count for query: " + ppl + " but got: " + actual,
     */
        // All 3 chained joins on str0 — each side groups to 3 rows, equi-join yields 3.
        // Use transient so a test failure doesn't leave a persistent setting on the cluster.
            + " | left anti join left=a, right=b ON a.str0 = b.str0"
     * collapses CBO to the COORD-singleton alternative and the {@code mpp.enabled}
import java.util.Map;
    private void assertErrorContains(String ppl, String expectedSubstring) {
    /** Execute a PPL query expected to return a single {@code cnt} row and assert the value. */
            + CALCS_ALT.indexName
            + " | left semi join left=a, right=b ON a.str0 = b.str0"
     * the implicit upstream input.
    public void testLeftSemiJoin() throws IOException {
            + CALCS_ALT.indexName
        assertEquals("[" + mode + "] Expected single count row for query: " + ppl, 1, rows.size());
/*
    }
     * Cross join (join predicate {@code 1=1}). Exercises the degenerate
 * regardless of whether MPP fires.
            + " | right join left=a, right=b ON a.str0 = b.str0"
     */
        }
            + CALCS.indexName
     * is a non-negative number. Used for join kinds where exact row-count expectations
    public void testLeftAntiJoin() throws IOException {
    /**
