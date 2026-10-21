 *       into a {@code now()}-symbolic comparison (or a TIMESTAMP literal for absolute
            6L
    public void testIfBranchesOnBoolean() throws IOException {
    }
     * {@code ifnull(a, b)} where both operands are non-null literals — first wins, second never
        assertFirstRowString(
    /** Non-null input passes through. */
            "fallback"
package org.opensearch.analytics.qa;
 *       {@code "one"} on key00.</li>
        assertTrue(cell instanceof Number);
    }
        assertEquals(1L, ((Number) cell).longValue());
    }
 *       of 17.</li>
    }
     * {@code ifnull(a, b)} — PPL aliases to stock {@code SqlStdOperatorTable.COALESCE}.
    public void testIsblankOnNonEmpty() throws IOException {
        assertNull("nullif(x, x) should be NULL but was " + cell, cell);
    }
    /**
     * cast in {@code EarliestLatestAdapter}, the enclosing Project's cached rowType (nullable
    public void testIsemptyOnEmptyLiteral() throws IOException {
     */
     * row that's in the past relative to "now".
        // int0 is NULL on key02; coalesce(int0, 42) → 42.
    }
     * rows are in 2004, so a 100-year lookback keeps all 17. Exercises the
    public void testIfConstantConditions() throws IOException {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    /**
    public void testCaseTwoBranches() throws IOException {
        assertFirstRowBoolean(oneRow("key00") + "| eval v = isblank(str2) | fields v", false);
     */
    // ── regexp_match ────────────────────────────────────────────────────────
    private void assertFirstRowLong(String ppl, long expected) throws IOException {
    /**
        // int0 is NULL for key02; ifnull should substitute the default.
            oneRow("key00") + "| eval v = coalesce(str2, int0, 'fallback') | fields v",
    public void testIsemptyOnNullInput() throws IOException {
    }
        assertFirstRowBoolean(oneRow("key02") + "| eval v = int0 is null | fields v", true);
    }
 *   <li>{@code str0}: never null across the 17 rows; one of {@code FURNITURE},
/**
        Map<String, Object> response = executePpl(ppl);
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
    /**
 */
        Object cell = firstRowFirstCell(oneRow("key02") + "| eval v = coalesce(int0, 42) | fields v");
        );
            11L
    public void testNullifSameColumnProducesNull() throws IOException {
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
            oneRow("key01") + "| where earliest('2004-07-26 00:00:00', `datetime0`) | stats count() as cnt",
        assertEquals(7.0, ((Number) cell).doubleValue(), 1e-9);
    private Object firstRowFirstCell(String ppl) throws IOException {
     * just above the threshold survives (1 row), a key just below is filtered
            "match"
 *       {@code 2004-07-04T22:49:28Z} (key08) to {@code 2004-08-02T07:59:23Z} (key02).</li>
    }
 *   <li><b>Native structural (no adapter)</b> — {@code case ... when ... end}, {@code if}
            dataProvisioned = true;
        Object cell = firstRowFirstCell(oneRow("key07") + "| eval v = coalesce(int0, num0, 7) | fields v");
 * </ul>
    }
            oneRow("key00") + "| eval v = case(str2 = 'two', 'a', str2 = 'three', 'b') | fields v"
    protected void onBeforeQuery() throws IOException {
        );
 * this file be licensed under the Apache-2.0 license or a
     */
            17L
    /** CASE without an else clause returns NULL on fall-through. */
        assertFirstRowString(
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = nullif(str2, 'one') | fields v");
        assertFirstRowLong(
    public void testNullifMatching() throws IOException {
    /**
     * Regression: {@code earliest} inside an {@code eval} (Project context) over a non-null
    /** {@code if(cond, t, f)} — registers this to {@code SqlStdOperatorTable.CASE}. */
        assertFirstRowBoolean(oneRow("key02") + "| eval v = int0 is not null | fields v", false);
 *   <li><b>Datafusion-side adapter</b> — scalar {@code where earliest(literal, ts)} /
    public void testIfnullBothArgsNullProducesNull() throws IOException {
import org.opensearch.client.Request;
    }
                + " | where is_after | stats count() as cnt",
        );
            1L
 *   <li>{@code int0}: nullable BIGINT — 6 null rows (key01, key02, key03, key07, key08, key12) out
     */
    // ── case ────────────────────────────────────────────────────────────────
    //       the sandbox extension catalog) → DataFusion SimplifyExpressions
        // key07: int0=null, num0=null → coalesce falls through to 7.
        assertFirstRowBoolean(oneRow("key00") + "| eval v = regexp_match(str2, '^z') | fields v", false);
     * All 17 calcs rows have {@code datetime0 >= 1900-01-01}, so the predicate is true everywhere.
    public void testIfnullPassesNonNullThrough() throws IOException {
            "else"
        assertTrue(cell instanceof Number);
        assertFirstRowString(oneRow("key00") + "| eval v = if(true, 'first', 'second') | fields v", "first");
    public void testCaseNoElseFallsThroughToNull() throws IOException {
     * {@code ifnull(x, x)} with a null column — both arguments resolve to NULL, so the result is
    }
    }
 *
    public void testNullifNonMatching() throws IOException {
     * BOOLEAN) trips Calcite's {@code BOOLEAN vs BOOLEAN NOT NULL} assertion at execution.
        assertFirstRowBoolean(oneRow("key12") + "| eval v = isempty(str2) | fields v", true);
 *       against the engine's {@code query_execution_start_time}.</li>
 * End-to-end coverage for PPL
    public void testCoalesceMixedTypes() throws IOException {
    }
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
        @SuppressWarnings("unchecked")
    @Override
    public void testEarliestAbsoluteLiteralSelectsSpecificRows() throws IOException {
        assertNull("ifnull(null, null) should be NULL but was " + cell, cell);
    private void assertFirstRowBoolean(String ppl, boolean expected) throws IOException {
    // ── nullif ──────────────────────────────────────────────────────────────
    public void testIspresent() throws IOException {
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = ifnull(200, int0) | fields v");
            17L
    public void testIfnullReplacesNull() throws IOException {
     * calcs rows are in 2004 so they all qualify.
    /**
     */
        Object cell = firstRowFirstCell(ppl);
            "source = " + DATASET.indexName + " | eval is_after = earliest('1900-01-01 00:00:00', `datetime0`)"
 * functions</a>.
    public void testEarliestInProjectOverNotNullTimestampDoesNotCrash() throws IOException {
        assertTrue("coalesce result should be numeric, got: " + cell, cell instanceof Number);
        );
    public void testEarliestRelativeOffsetKeepsAllRows() throws IOException {
        }
import org.opensearch.client.Response;
    }
 * The OpenSearch Contributors require contributions made to
    public void testLatestRelativeOneYearKeepsAllPastRows() throws IOException {
     * {@code coalesce(a, b, ...)} — returns the first non-null argument
     */
        Object cell = firstRowFirstCell(oneRow("key02") + "| eval v = ifnull(int0, -1) | fields v");
    public void testIsNotNullInProject() throws IOException {
    public void testEarliestAbsoluteLiteralCount() throws IOException {
 * <ul>
 *   <li>{@code num0}: nullable DOUBLE — nulls on key07, key09–key16.</li>
 *       (aliased to CASE by PPL), {@code ifnull} (aliased to COALESCE by PPL), {@code nullif}
     * out (0 rows).
    public void testCoalescePassesNonNullThrough() throws IOException {
 *   <li><b>Predicate-shape in project</b> — {@code x IS NULL} / {@code x IS NOT NULL} /
        assertFirstRowString(oneRow("key00") + "| eval v = if(false, 'first', 'second') | fields v", "second");
     * {@code regexp_match(x, pattern)}.
     * TIMESTAMP column. The {@code datetime0} column is non-null, and a folded TIMESTAMP literal
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
     * {@code now()} on the RHS; the predicate becomes {@code ts <= now()}. All
     */
    }
 *       (lowered to {@code CASE(EQUALS(a,b), NULL, a)} by PPL), {@code regexp_match}
 * <a href="https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/condition/">conditional
     */
    }
     * The real coercion exercises on key12 (str2=null, int0=null), where the third literal
     * {@code if(true, a, b)} and {@code if(false, a, b)} — constant-condition shape.
     */
    /** Multi-branch CASE with fall-through to the final default arm. */
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    }
     * {@code latest('-1y', ts)} — 1-year-ago threshold. All calcs rows are in
        assertFirstRowLong(
        assertFirstRowBoolean(oneRow("key00") + "| eval s = '   ' | eval v = isblank(s) | fields v", true);
        Object cell = firstRowFirstCell(
    //         ts >=|<= [TIMESTAMP_LITERAL | DATETIME_PLUS(now(), INTERVAL) | date_trunc(unit, now())]
    }
    }
 * <ul>
     *
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = ifnull(int0, -1) | fields v");
        assertFirstRowBoolean(oneRow("key00") + "| eval v = regexp_match(str2, 'on.') | fields v", true);
            oneRow("key00") + "| eval v = case(str2 = 'one', 'match' else 'nomatch') | fields v",
        assertFirstRowLong(
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = coalesce(int0, 99) | fields v");
/*
        assertFirstRowLong(
    /** {@code x IS NULL} in an eval projection. */
     * Per-row predicate selectivity for {@code earliest(literal, ts)}: a key
        if (dataProvisioned == false) {
     * {@code where earliest(absolute_literal, ts)} keeps rows with {@code ts >=}
            "source = " + DATASET.indexName + " | where latest('-1y', `datetime0`) | stats count() as cnt",
     * {@code earliest('-100y', ts)} — relative offset 100 years back. All calcs
        Object cell = firstRowFirstCell(ppl);
        assertFirstRowString(
    /**
     * consulted.
            DatasetProvisioner.provision(client(), DATASET);
    /**
    public void testLatestAbsoluteLiteralCount() throws IOException {
 *       {@code OFFICE SUPPLIES}, or {@code TECHNOLOGY}.</li>
    /**
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).longValue());
 * </ul>
    }
    public void testCoalesceReturnsFirstNonNull() throws IOException {
        assertFirstRowBoolean(oneRow("key00") + "| eval v = isempty(str2) | fields v", false);
        );
        assertFirstRowBoolean(oneRow("key00") + "| eval s = '' | eval v = isempty(s) | fields v", true);
     * {@code where latest(absolute_literal, ts)} keeps rows with {@code ts <=}
            0L
    }
    //     → BackendPlanAdapter resolves ScalarFunction.EARLIEST / LATEST →
    // ── earliest / latest ───────────────────────────────────────────────────
    /**
     */
        assertFirstRowLong(
        );
        assertEquals(1L, ((Number) cell).longValue());
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
    //       EarliestLatestAdapter rewrites the call to
        assertFirstRowLong(
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
    }
        assertNull("nullif('one', 'one') should be NULL, got: " + cell, cell);
    }
            "source = " + DATASET.indexName + " | where earliest('-100y', `datetime0`) | stats count() as cnt",
    }
     */
    //     → Substrait emit (now(), INTERVAL_DAY/MONTH, date_trunc resolve via
    }
        );
    }
    }
     * the literal. 6 rows have {@code datetime0 <= 2004-07-15}.
    /**
        Object cell = firstRowFirstCell(oneRow("key02") + "| eval v = ifnull(int0, int0) | fields v");
            "source = " + DATASET.indexName + " | where latest('+100y', `datetime0`) | stats count() as cnt",
            "source = " + DATASET.indexName + " | where earliest('2004-07-15 00:00:00', `datetime0`) | stats count() as cnt",
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
    public void testCaseMultiBranchDefault() throws IOException {
    /**
            17L
    }
            oneRow("key00") + "| eval v = case(str2 = 'two', 'a', str2 = 'three', 'b' else 'else') | fields v",
import java.util.List;
    /**
    // ── ifnull ──────────────────────────────────────────────────────────────
 *       (aliased to REGEXP_CONTAINS). The backend sees standard Substrait primitives and
        assertTrue("Expected boolean result for query [" + ppl + "] but got: " + cell, cell instanceof Boolean);
     * rewrites the IS_EMPTY arm to {@code CHAR_LENGTH(x) = 0}.
        );
    }
        assertFirstRowBoolean(oneRow("key00") + "| eval v = ispresent(int0) | fields v", true);
     * NULL.
    // ── if ──────────────────────────────────────────────────────────────────
    //
        // str2 is NULL on key12.
    }
    }
        assertTrue(cell instanceof Number);
    }
        );
    /** {@code x IS NOT NULL} in an eval projection. */
    }
 * SPDX-License-Identifier: Apache-2.0
        );
    // ── coalesce ────────────────────────────────────────────────────────────
     * {@code isempty(x)} — lowered to {@code OR(IS_NULL(x), IS_EMPTY(x))}; the adapter
     * which DataFusion folds at engine plan time.
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
     * — but the {@code earliest} call was declared nullable BOOLEAN. Without the type-pinning
     * PPL lowers {@code nullif(a, b)} to {@code CASE WHEN a = b THEN NULL ELSE a END}.
    // ── helpers ─────────────────────────────────────────────────────────────
    /**
    /** Basic two-branch CASE with else — exercises the structural IfThen shape. */
        assertEquals(200L, ((Number) cell).longValue());
    }
            oneRow("key12") + "| eval v = coalesce(str2, int0, 'fallback') | fields v",
    //       folds now() against query_execution_start_time → native timestamp
        );
     */
    }
     * {@code latest('now', ts)} — the literal "now" lowers to a bare
public class ConditionalFunctionsIT extends AnalyticsRestTestCase {
    private void assertFirstRowString(String ppl, String expected) throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = if(str2 = 'two', 'yes', 'no') | fields v", "no");
     * Mixed-type coalesce with VARCHAR + numeric.
     */
 * <p>Fixture columns from the {@code calcs} dataset (per row keyed by {@code key}):
            "one"
    }
        );
    public void testIsemptyOnNonEmptyString() throws IOException {
    public void testIsblankOnNullInput() throws IOException {
            oneRow("key00") + "| where earliest('2004-07-26 00:00:00', `datetime0`) | stats count() as cnt",
    /**
 *       DataFusion's substrait consumer handles each natively.</li>
    /**
     * the literal. 11 of 17 calcs rows have {@code datetime0 >= 2004-07-15}.
    /** {@code ispresent(x)} — PPL aliases to {@code IS_NOT_NULL}. */
 * compatible open source license.
        return rows.get(0).get(0);
 */
     * is also non-null, so the comparison's inferred return type is {@code BOOLEAN NOT NULL}
        assertFirstRowBoolean(oneRow("key00") + "| eval v = int0 is null | fields v", false);
    // ── isempty ─────────────────────────────────────────────────────────────
        assertNull("case without else on no-match should be NULL but was " + cell, cell);
        assertFirstRowLong(
        assertFirstRowLong(
        // str2 is NULL on key12.
     * {@code latest('+100y', ts)} — symmetric: 100 years forward keeps every
     * 2004 so they're older than 1 year; the predicate keeps all 17.
     * pure-offset path: {@code DATETIME_PLUS(now(), INTERVAL_MONTH(-1200))}
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = nullif(str2, str2) | fields v");
    public void testIfnullTwoNonNullLiteralsReturnsFirst() throws IOException {
        );
    /**
            17L
    /**
    public void testRegexpMatchNoMatch() throws IOException {
        assertEquals(42L, ((Number) cell).longValue());
     */
     */
     * {@code isblank(x)} — lowered to {@code OR(IS_NULL(x), IS_EMPTY(TRIM(x)))}. With
import java.io.IOException;
     * the adapter, the IS_EMPTY(TRIM(x)) arm becomes {@code CHAR_LENGTH(TRIM(x)) = 0}.
 *   <li>{@code str2}: nullable VARCHAR — null on key03, key06, key12, key16. Non-null value
    //       comparison.
    /** Non-null first operand passes through. */
    @AwaitsFix(bugUrl = "Real opensearch-sql plugin: \"Failed to start streaming fragment on [calcs][0]\" - head|where|where residual filter is mis-routed through the indexed executor (ffm.rs routes on the always-present __row_id__ column). Needs the ffm routing + countFilters<=1 fix (engine/rust fix, separate PR).")
    private static boolean dataProvisioned = false;
    public void testLatestRelativeOffsetKeepsAllRows() throws IOException {
     */
    public void testIsblankOnWhitespaceOnly() throws IOException {
        Object cell = firstRowFirstCell(ppl);
        assertFirstRowString(
 *       {@code where latest(literal, ts)} are rewritten by {@code EarliestLatestAdapter}
    // Pipeline:
        assertFirstRowLong(
    public void testCoalesceThreeArgs() throws IOException {
        assertTrue("ifnull result should be numeric, got: " + cell, cell instanceof Number);
     */
    }
        assertFirstRowString(oneRow("key00") + "| eval v = if(str2 = 'one', 'yes', 'no') | fields v", "yes");
    public void testLatestNowKeepsAllPastRows() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = nullif(str2, 'two') | fields v", "one");
        assertFirstRowBoolean(oneRow("key02") + "| eval v = ispresent(int0) | fields v", false);
        assertNotNull("Expected non-null boolean result for query [" + ppl + "]", cell);
    // ── x IS NULL / IS NOT NULL / ispresent (project side) ───────────────────
    public void testIsNullInProject() throws IOException {
import java.util.Map;
}
     * <p>key00 has str2='one', int0=1 — so coalesce(str2, int0, 'fallback') resolves to 'one'.
 *       inputs). DataFusion's {@code SimplifyExpressions} then folds {@code now()}
 *   <li>{@code datetime0}: non-null TIMESTAMP — spans
    // ── isblank ─────────────────────────────────────────────────────────────
 *       {@code ispresent(x)} (PPL aliases the last to IS_NOT_NULL).</li>
        assertFirstRowBoolean(oneRow("key12") + "| eval v = isblank(str2) | fields v", true);
            "source = " + DATASET.indexName + " | where latest('2004-07-15 00:00:00', `datetime0`) | stats count() as cnt",
    private String oneRow(String key) {
     * 'fallback' wins.
        assertTrue(cell instanceof Number);
    }
     */
            17L
        assertEquals(-1L, ((Number) cell).longValue());
    public void testRegexpMatchMatches() throws IOException {
 *
    }
        // int0 = 1 on key00.
            "source = " + DATASET.indexName + " | where latest('now', `datetime0`) | stats count() as cnt",
        );
        assertFirstRowBoolean(oneRow("key00") + "| eval v = int0 is not null | fields v", true);
    //   PPL parser → Calcite RexCall (operator name "EARLIEST" / "LATEST")
 *
