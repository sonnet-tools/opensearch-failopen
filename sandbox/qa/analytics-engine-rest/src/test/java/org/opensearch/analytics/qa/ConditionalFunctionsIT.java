     * is also non-null, so the comparison's inferred return type is {@code BOOLEAN NOT NULL}
    }
    public void testCoalescePassesNonNullThrough() throws IOException {
     * {@code latest('now', ts)} — the literal "now" lowers to a bare  
        );
    // ── coalesce ────────────────────────────────────────────────────────────
     * row that's in the past relative to "now".  
        assertFirstRowLong(
            "match"
        assertFirstRowLong(
        // int0 is NULL on key02; coalesce(int0, 42) → 42.
     */  
     */  
     * PPL lowers {@code nullif(a, b)} to {@code CASE WHEN a = b THEN NULL ELSE a END}.  
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
        assertEquals(7.0, ((Number) cell).doubleValue(), 1e-9);  
        assertFirstRowString(
        assertFirstRowBoolean(oneRow("key02") + "| eval v = ispresent(int0) | fields v", false);  
            oneRow("key00") + "| eval v = case(str2 = 'one', 'match' else 'nomatch') | fields v",  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
    /**  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    private void assertFirstRowLong(String ppl, long expected) throws IOException {
            dataProvisioned = true;
    }
    // ── x IS NULL / IS NOT NULL / ispresent (project side) ───────────────────
    }
    }
     */
            17L
     * the literal. 11 of 17 calcs rows have {@code datetime0 >= 2004-07-15}.
    private Object firstRowFirstCell(String ppl) throws IOException {
     * {@code latest('-1y', ts)} — 1-year-ago threshold. All calcs rows are in
        assertFirstRowBoolean(oneRow("key00") + "| eval v = isempty(str2) | fields v", false);
        assertTrue(cell instanceof Number);
        assertTrue("ifnull result should be numeric, got: " + cell, cell instanceof Number);  
    public void testCoalesceThreeArgs() throws IOException {
        assertTrue(cell instanceof Number);  
    }
     *
     * {@code ifnull(a, b)} where both operands are non-null literals — first wins, second never
     * which DataFusion folds at engine plan time.
    public void testNullifMatching() throws IOException {
     * {@code if(true, a, b)} and {@code if(false, a, b)} — constant-condition shape.  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = coalesce(int0, 99) | fields v");  
    }
    /** {@code ispresent(x)} — PPL aliases to {@code IS_NOT_NULL}. */  
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = nullif(str2, 'one') | fields v");  
            oneRow("key01") + "| where earliest('2004-07-26 00:00:00', `datetime0`) | stats count() as cnt",  
            oneRow("key00") + "| eval v = coalesce(str2, int0, 'fallback') | fields v",  
    public void testLatestRelativeOneYearKeepsAllPastRows() throws IOException {
     * {@code isblank(x)} — lowered to {@code OR(IS_NULL(x), IS_EMPTY(TRIM(x)))}. With
 * <ul>  
        Object cell = firstRowFirstCell(  
    /** {@code x IS NULL} in an eval projection. */  
        // int0 = 1 on key00.  
    /**  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = ifnull(200, int0) | fields v");
    }  
}
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
        assertTrue(cell instanceof Number);
    }  
        assertEquals("Value mismatch for query: " + ppl, expected, cell);  
     * consulted.
    public void testIsblankOnNonEmpty() throws IOException {
    //       folds now() against query_execution_start_time → native timestamp  
    /**
        assertFirstRowBoolean(oneRow("key00") + "| eval v = ispresent(int0) | fields v", true);
     */  
    }  
    }  
        assertFirstRowLong(
     */
    // ── if ──────────────────────────────────────────────────────────────────  
    }  
            oneRow("key00") + "| eval v = case(str2 = 'two', 'a', str2 = 'three', 'b') | fields v"
    }  
    public void testIsNullInProject() throws IOException {
     */
    /** CASE without an else clause returns NULL on fall-through. */
     * calcs rows are in 2004 so they all qualify.
    public void testCaseTwoBranches() throws IOException {
        assertEquals(1L, ((Number) cell).longValue());
     * the literal. 6 rows have {@code datetime0 <= 2004-07-15}.
 *   <li>{@code int0}: nullable BIGINT — 6 null rows (key01, key02, key03, key07, key08, key12) out
 * The OpenSearch Contributors require contributions made to  
     * {@code ifnull(a, b)} — PPL aliases to stock {@code SqlStdOperatorTable.COALESCE}.
 * functions</a>.
        assertNull("nullif('one', 'one') should be NULL, got: " + cell, cell);
    public void testLatestAbsoluteLiteralCount() throws IOException {  
        assertFirstRowLong(  
    }
    public void testNullifNonMatching() throws IOException {
/**
    /**
    /**  
     * Per-row predicate selectivity for {@code earliest(literal, ts)}: a key
    public void testIsblankOnNullInput() throws IOException {  
    public void testLatestNowKeepsAllPastRows() throws IOException {
    /** Non-null first operand passes through. */
 * this file be licensed under the Apache-2.0 license or a
    //
        assertEquals(42L, ((Number) cell).longValue());
    private String oneRow(String key) {  
    /**
            "source = " + DATASET.indexName + " | where latest('+100y', `datetime0`) | stats count() as cnt",
 *       into a {@code now()}-symbolic comparison (or a TIMESTAMP literal for absolute
 *       {@code 2004-07-04T22:49:28Z} (key08) to {@code 2004-08-02T07:59:23Z} (key02).</li>
    public void testIfnullPassesNonNullThrough() throws IOException {
 */  
        Object cell = firstRowFirstCell(oneRow("key07") + "| eval v = coalesce(int0, num0, 7) | fields v");
    public void testIspresent() throws IOException {
    }
     * cast in {@code EarliestLatestAdapter}, the enclosing Project's cached rowType (nullable
 *       DataFusion's substrait consumer handles each natively.</li>
    }
     */  
     */
     * just above the threshold survives (1 row), a key just below is filtered  
     * rows are in 2004, so a 100-year lookback keeps all 17. Exercises the
    /** Basic two-branch CASE with else — exercises the structural IfThen shape. */  
     */  
    public void testIsblankOnWhitespaceOnly() throws IOException {
 * </ul>
        assertTrue("Expected boolean result for query [" + ppl + "] but got: " + cell, cell instanceof Boolean);  
 *   <li><b>Native structural (no adapter)</b> — {@code case ... when ... end}, {@code if}
 *   <li>{@code datetime0}: non-null TIMESTAMP — spans  
    public void testEarliestAbsoluteLiteralCount() throws IOException {
        assertNotNull("Expected non-null boolean result for query [" + ppl + "]", cell);
    /**  
            "fallback"
    /** {@code x IS NOT NULL} in an eval projection. */  
        assertFirstRowBoolean(oneRow("key00") + "| eval s = '   ' | eval v = isblank(s) | fields v", true);
    public void testEarliestAbsoluteLiteralSelectsSpecificRows() throws IOException {
        assertFirstRowBoolean(oneRow("key12") + "| eval v = isempty(str2) | fields v", true);
        // int0 is NULL for key02; ifnull should substitute the default.
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);  
     */  
        assertFirstRowString(oneRow("key00") + "| eval v = if(false, 'first', 'second') | fields v", "second");
                + " | where is_after | stats count() as cnt",
    //         ts >=|<= [TIMESTAMP_LITERAL | DATETIME_PLUS(now(), INTERVAL) | date_trunc(unit, now())]  
        @SuppressWarnings("unchecked")  
    public void testCoalesceMixedTypes() throws IOException {
 *
 *       {@code OFFICE SUPPLIES}, or {@code TECHNOLOGY}.</li>  
     * 2004 so they're older than 1 year; the predicate keeps all 17.
    public void testLatestRelativeOffsetKeepsAllRows() throws IOException {
    /**
    //     → BackendPlanAdapter resolves ScalarFunction.EARLIEST / LATEST →
     */
    public void testRegexpMatchMatches() throws IOException {
        Object cell = firstRowFirstCell(oneRow("key02") + "| eval v = ifnull(int0, -1) | fields v");
        );  
    public void testIsemptyOnNonEmptyString() throws IOException {  
    private void assertFirstRowString(String ppl, String expected) throws IOException {  
    // ── isempty ─────────────────────────────────────────────────────────────  
    //       the sandbox extension catalog) → DataFusion SimplifyExpressions
    //       comparison.
        return rows.get(0).get(0);
        assertFirstRowString(oneRow("key00") + "| eval v = if(true, 'first', 'second') | fields v", "first");  
    // ── helpers ─────────────────────────────────────────────────────────────
        assertFirstRowString(oneRow("key00") + "| eval v = if(str2 = 'one', 'yes', 'no') | fields v", "yes");
package org.opensearch.analytics.qa;
    /** {@code if(cond, t, f)} — registers this to {@code SqlStdOperatorTable.CASE}. */
    }
        assertFirstRowBoolean(oneRow("key02") + "| eval v = int0 is null | fields v", true);
            DatasetProvisioner.provision(client(), DATASET);
        assertFirstRowBoolean(oneRow("key00") + "| eval v = isblank(str2) | fields v", false);  
    //       EarliestLatestAdapter rewrites the call to
        assertFirstRowBoolean(oneRow("key00") + "| eval v = regexp_match(str2, '^z') | fields v", false);  
    /**
     * {@code latest('+100y', ts)} — symmetric: 100 years forward keeps every
        if (dataProvisioned == false) {  
            "source = " + DATASET.indexName + " | where latest('now', `datetime0`) | stats count() as cnt",  
        );
        }  
import org.opensearch.client.Request;  
     * BOOLEAN) trips Calcite's {@code BOOLEAN vs BOOLEAN NOT NULL} assertion at execution.
        );
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        );
 * End-to-end coverage for PPL
    public void testEarliestInProjectOverNotNullTimestampDoesNotCrash() throws IOException {
     * The real coercion exercises on key12 (str2=null, int0=null), where the third literal
    /**
 *   <li>{@code str0}: never null across the 17 rows; one of {@code FURNITURE},
     * pure-offset path: {@code DATETIME_PLUS(now(), INTERVAL_MONTH(-1200))}  
        Object cell = firstRowFirstCell(oneRow("key02") + "| eval v = ifnull(int0, int0) | fields v");
            17L  
    /**  
        );
     * {@code regexp_match(x, pattern)}.
            "one"
    public void testNullifSameColumnProducesNull() throws IOException {
public class ConditionalFunctionsIT extends AnalyticsRestTestCase {
     * Mixed-type coalesce with VARCHAR + numeric.
            0L
    /**
/*  
    @Override
        );
        assertFirstRowBoolean(oneRow("key00") + "| eval v = int0 is not null | fields v", true);  
     */
            "else"  
    public void testCaseMultiBranchDefault() throws IOException {  
    private static boolean dataProvisioned = false;
     * Regression: {@code earliest} inside an {@code eval} (Project context) over a non-null  
    }
     * {@code where earliest(absolute_literal, ts)} keeps rows with {@code ts >=}
     * out (0 rows).
    protected void onBeforeQuery() throws IOException {
            "source = " + DATASET.indexName + " | where latest('-1y', `datetime0`) | stats count() as cnt",  
import java.io.IOException;  
 */  
        Object cell = firstRowFirstCell(ppl);
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).longValue());
 *       against the engine's {@code query_execution_start_time}.</li>  
        );
     * 'fallback' wins.
    // ── ifnull ──────────────────────────────────────────────────────────────
import java.util.List;
 *   <li>{@code num0}: nullable DOUBLE — nulls on key07, key09–key16.</li>
    }  
     */  
import java.util.Map;
            oneRow("key12") + "| eval v = coalesce(str2, int0, 'fallback') | fields v",
        assertNull("ifnull(null, null) should be NULL but was " + cell, cell);  
    // ── earliest / latest ───────────────────────────────────────────────────  
        assertFirstRowString(
    // Pipeline:
    public void testIsemptyOnEmptyLiteral() throws IOException {
        assertNull("case without else on no-match should be NULL but was " + cell, cell);  
    /**  
import org.opensearch.client.Response;
        assertFirstRowBoolean(oneRow("key00") + "| eval v = regexp_match(str2, 'on.') | fields v", true);
     * All 17 calcs rows have {@code datetime0 >= 1900-01-01}, so the predicate is true everywhere.  
    }
        );
 *   <li>{@code str2}: nullable VARCHAR — null on key03, key06, key12, key16. Non-null value
 *       {@code "one"} on key00.</li>
     */
    public void testCaseNoElseFallsThroughToNull() throws IOException {
    public void testCoalesceReturnsFirstNonNull() throws IOException {  
    /**  
 *       (aliased to CASE by PPL), {@code ifnull} (aliased to COALESCE by PPL), {@code nullif}
    /**
        assertTrue("coalesce result should be numeric, got: " + cell, cell instanceof Number);  
        // str2 is NULL on key12.
        // key07: int0=null, num0=null → coalesce falls through to 7.  
        );
    }
 *
    }
    private void assertFirstRowBoolean(String ppl, boolean expected) throws IOException {  
     * the adapter, the IS_EMPTY(TRIM(x)) arm becomes {@code CHAR_LENGTH(TRIM(x)) = 0}.
    @AwaitsFix(bugUrl = "Real opensearch-sql plugin: \"Failed to start streaming fragment on [calcs][0]\" - head|where|where residual filter is mis-routed through the indexed executor (ffm.rs routes on the always-present __row_id__ column). Needs the ffm routing + countFilters<=1 fix (engine/rust fix, separate PR).")  
    /** Non-null input passes through. */
     */
 *       (aliased to REGEXP_CONTAINS). The backend sees standard Substrait primitives and
    }
 *       inputs). DataFusion's {@code SimplifyExpressions} then folds {@code now()}
    public void testIfConstantConditions() throws IOException {
    }
    //   PPL parser → Calcite RexCall (operator name "EARLIEST" / "LATEST")  
        assertFirstRowString(  
        assertFirstRowBoolean(oneRow("key00") + "| eval v = int0 is null | fields v", false);  
        assertFirstRowString(
 *
        assertFirstRowLong(
    }  
    // ── case ────────────────────────────────────────────────────────────────
     * {@code earliest('-100y', ts)} — relative offset 100 years back. All calcs
        assertFirstRowLong(  
     * {@code now()} on the RHS; the predicate becomes {@code ts <= now()}. All
        // str2 is NULL on key12.  
        Object cell = firstRowFirstCell(oneRow("key02") + "| eval v = coalesce(int0, 42) | fields v");
 *       (lowered to {@code CASE(EQUALS(a,b), NULL, a)} by PPL), {@code regexp_match}  
    public void testIfnullReplacesNull() throws IOException {  
        assertTrue(cell instanceof Number);
     * {@code isempty(x)} — lowered to {@code OR(IS_NULL(x), IS_EMPTY(x))}; the adapter  
            "source = " + DATASET.indexName + " | where earliest('2004-07-15 00:00:00', `datetime0`) | stats count() as cnt",  
    }
    /**  
    }
            oneRow("key00") + "| eval v = case(str2 = 'two', 'a', str2 = 'three', 'b' else 'else') | fields v",
            oneRow("key00") + "| where earliest('2004-07-26 00:00:00', `datetime0`) | stats count() as cnt",
 *   <li><b>Datafusion-side adapter</b> — scalar {@code where earliest(literal, ts)} /
    // ── regexp_match ────────────────────────────────────────────────────────
        assertEquals(-1L, ((Number) cell).longValue());
    /**  
    }
 * compatible open source license.
            6L  
    }  
        assertFirstRowString(oneRow("key00") + "| eval v = if(str2 = 'two', 'yes', 'no') | fields v", "no");
    // ── nullif ──────────────────────────────────────────────────────────────  
     */  
 * SPDX-License-Identifier: Apache-2.0
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = ifnull(int0, -1) | fields v");
        assertFirstRowString(oneRow("key00") + "| eval v = nullif(str2, 'two') | fields v", "one");
        assertEquals(1L, ((Number) cell).longValue());  
    /**
        );
 * <a href="https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/condition/">conditional  
        assertNull("nullif(x, x) should be NULL but was " + cell, cell);
        assertFirstRowBoolean(oneRow("key00") + "| eval s = '' | eval v = isempty(s) | fields v", true);
     * {@code coalesce(a, b, ...)} — returns the first non-null argument
    public void testIsNotNullInProject() throws IOException {
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
    public void testIfnullBothArgsNullProducesNull() throws IOException {
            1L
    }
     * TIMESTAMP column. The {@code datetime0} column is non-null, and a folded TIMESTAMP literal
    }
    public void testIfBranchesOnBoolean() throws IOException {  
    public void testIsemptyOnNullInput() throws IOException {
        assertFirstRowLong(
     * NULL.
 * <p>Fixture columns from the {@code calcs} dataset (per row keyed by {@code key}):  
        assertFirstRowLong(  
    public void testRegexpMatchNoMatch() throws IOException {
            11L
        );
    }
            "source = " + DATASET.indexName + " | where latest('2004-07-15 00:00:00', `datetime0`) | stats count() as cnt",
    }
        );  
        Map<String, Object> response = executePpl(ppl);
     * {@code where latest(absolute_literal, ts)} keeps rows with {@code ts <=}  
    }
     * rewrites the IS_EMPTY arm to {@code CHAR_LENGTH(x) = 0}.
        assertEquals(200L, ((Number) cell).longValue());
    }
        Object cell = firstRowFirstCell(ppl);
    }  
 * <ul>
     * {@code ifnull(x, x)} with a null column — both arguments resolve to NULL, so the result is
    }
     */
        assertFirstRowLong(
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);  
            "source = " + DATASET.indexName + " | eval is_after = earliest('1900-01-01 00:00:00', `datetime0`)"
        Object cell = firstRowFirstCell(ppl);
     * — but the {@code earliest} call was declared nullable BOOLEAN. Without the type-pinning  
    }  
     */
            "source = " + DATASET.indexName + " | where earliest('-100y', `datetime0`) | stats count() as cnt",
 *       of 17.</li>  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = nullif(str2, str2) | fields v");  
 * </ul>
 *       {@code where latest(literal, ts)} are rewritten by {@code EarliestLatestAdapter}  
            17L  
    //     → Substrait emit (now(), INTERVAL_DAY/MONTH, date_trunc resolve via
        assertFirstRowBoolean(oneRow("key02") + "| eval v = int0 is not null | fields v", false);
 *   <li><b>Predicate-shape in project</b> — {@code x IS NULL} / {@code x IS NOT NULL} /  
 *       {@code ispresent(x)} (PPL aliases the last to IS_NOT_NULL).</li>
    /** Multi-branch CASE with fall-through to the final default arm. */
        );  
            17L
    }
    public void testIfnullTwoNonNullLiteralsReturnsFirst() throws IOException {
    }
    // ── isblank ─────────────────────────────────────────────────────────────
        assertFirstRowBoolean(oneRow("key12") + "| eval v = isblank(str2) | fields v", true);
    }
    public void testEarliestRelativeOffsetKeepsAllRows() throws IOException {  
    }
            17L
     * <p>key00 has str2='one', int0=1 — so coalesce(str2, int0, 'fallback') resolves to 'one'.  
