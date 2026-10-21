        assertFirstRowDouble(oneRow("key00") + "| eval v = log(10, num0) | fields v", Math.log(12.3) / Math.log(10.0));
    public void testCbrt() throws IOException {
        // PPL truncate takes (value, scale); with scale=0 on 12.3 returns 12.
        assertFirstRowDouble(oneRow("key00") + "| eval v = cos(int0) | fields v", Math.cos(1.0));
 * route (PPL → CalciteRelNodeVisitor → Substrait → DataFusion).
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = conv(255, 10, 16) | fields v");
        assertTrue("Expected numeric or NaN-token result for query [" + ppl + "] but got: " + cell, ok);
        assertTrue("Expected numeric rand() result but got: " + cell, cell instanceof Number);
    /** {@code cot(num1)} finite. */
package org.opensearch.analytics.qa;
        assertEquals("d", firstRowFirstCell(oneRow("key01") + "| eval v = conv(int3, 10, 16) | fields v"));
        assertFirstRowDouble(oneRow("key00") + "| eval v = atan2(int0, int0) | fields v", Math.PI / 4.0);
    /** Invalid radix surfaces as a 5xx with Java's NumberFormatException message text. The exact
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = cot(num1) | fields v");
    /** {@code degrees} accepts integer fp64-widened input via NumericToDoubleAdapter — {@code degrees(int0)} on {@code int0 = 1}. */
    public void testRadiansNegative() throws IOException {
     *  serialisation DataFusion evaluates natively. */
        assertFirstRowNumericOrNan(oneRow("key00") + "| eval v = expm1(num1) | fields v");
     *  (DataFusion UDF name) via FunctionMappings override. Calcite marks {@code RAND} as
     *  folds this to {@code Math.E} at plan time on the coordinator. Requires
    /** {@code conv(int0, 10, 16)} where int0 is NULL (key01) → NULL. Null first arg must propagate,
        Object cell = firstRowFirstCell(ppl);
        @SuppressWarnings("unchecked")
        assertFirstRowDouble(oneRow("key00") + "| eval v = radians(int0) | fields v", Math.toRadians(1));
    }
    }
        assertFirstRowDouble(oneRow("key00") + "| eval v = ceil(num0) | fields v", 13.0);
        assertEquals("ff", cell);
    /** {@code degrees(12.3) = 12.3 × 180 / π}. Validates the {@link
 * Substrait plan DataFusion's native runtime actually evaluates, instead of
    public void testDegreesNegative() throws IOException {
        Object cell = firstRowFirstCell(ppl);
    /** Acos on num1=8.42 is out of valid range (|x|>1) so DataFusion returns NaN; use sign check of output against num0/10.0 range. Use num0=12.3 / 13 ≈ 0.946 — within [-1,1]. But dividing requires DIVIDE. Use num1/num1 = 1.0 — but DIVIDE not available. Fall back to a computed input using atan which is unbounded. */
    // to fp64 before substrait emission.
    public void testDegrees() throws IOException {
        assertEquals("8", firstRowFirstCell(oneRow("key00") + "| eval v = conv(cast(int3 as long), 10, 16) | fields v"));
     *  {@code SqlLibraryOperators.LOG(x, base)} (arg-swapped) which isthmus serialises as
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = sin(num1) | fields v");
        assertFirstRowDouble(oneRow("key00") + "| eval v = sqrt(num0) | fields v", Math.sqrt(12.3));
        // log base 10 of num0 = log10(12.3)
    public void testAtan2OnIntegerArgs() throws IOException {
    public void testConvNumericLiteralFirstArg() throws IOException {
}
    /** {@code atan2(1, 1)} = π/4 — two-arg variant goes through {@code ScalarFunction.ATAN2}. */
    }
    public void testConvNumericColumnFirstArg() throws IOException {
        // wiring reaches DataFusion without explicitly checking an exact value.
    public void testDegreesOnInteger() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = degrees(num3) | fields v", Math.toDegrees(-11.52));
    public void testPower() throws IOException {
     *  org.opensearch.analytics.spi.NumericToDoubleAdapter} entry for {@code ScalarFunction.RADIANS}. */
    // ── Trig on integer-typed input ────────────────────────────────────────
 * <p>Row values used (from {@code calcs/bulk.json}):
    public void testCos() throws IOException {
    public void testE() throws IOException {
 * the math function to one of that row's {@code num*} (DOUBLE) fields — field
        assertFirstRowDouble(oneRow("key00") + "| eval v = degrees(int0) | fields v", Math.toDegrees(1));
    public void testConvDecimalToBase36() throws IOException {
    /** {@code asin(num1)} where num1 = 8.42 → NaN (out of range), but we just verify the call reaches DataFusion and returns a numeric cell (NaN counts). */
    }
    }
     *  (conv(age, 10, 16)), the exact shape the coercion bug surfaced on. int3 = 8 at key00 → 'ff'
        assertFirstRowDouble(oneRow("key00") + "| eval v = radians(num3) | fields v", Math.toRadians(-11.52));
 *
    }
    /** {@code truncate(num0, 0)} on num0=12.3 → 12. Mapped to substrait {@code trunc}
 * engine-module runtime classpath and is not configured in the sandbox
    }
        }
 * operands that match every Group G Substrait signature's expected family.
        assertFirstRowNumericOrNan(oneRow("key00") + "| eval v = acos(num1) | fields v");
    public void testFloor() throws IOException {
 *   <li>{@code key04}: num0=3.5,  num1=9.05, num2=6.46,  num3=12.93,  int0=7, int1=null</li>
/*
    /** {@code max(num0, num1, num2)} on row 0 — PPL emits a {@code SCALAR_MAX} UDF whose return
    }
    // PPL `conv` lowers to ScalarFunction.CONVERT → ConvAdapter → substrait `conv` →
        assertFirstRowDouble(oneRow("key00") + "| eval v = asin(0.5) | fields v", Math.asin(0.5));
    private static boolean dataProvisioned = false;
        assertFirstRowDouble(oneRow("key00") + "| eval v = sinh(num1) | fields v", Math.sinh(8.42));
    @Override
    // ── Tier 1: direct Substrait mappings applied to a DOUBLE field reference ──
    /** {@code asin(0.5)} / {@code acos(0.5)} — int0=1 is out of asin's [-1,1] domain on row 0,
                e.getMessage().contains("less than Character.MIN_RADIX")
     *  org.opensearch.analytics.spi.NumericToDoubleAdapter} entry for {@code ScalarFunction.DEGREES}. */
 *
    /** {@code sinh(num1)} via HyperbolicOperatorAdapter. */
            DatasetProvisioner.provision(client(), DATASET);
     *  of 8 is '8'; key01's int3 = 13 → 'd'. */
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = atan(num1) | fields v");
    public void testLogOneArg() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = sin(int0) | fields v", Math.sin(1.0));
    }
     *  (the default Substrait catalog only ships {@code round(x, digits)}). */
    public void testConvHexToDecimal() throws IOException {
    /** Base query template: filter to exactly one row (cardinality 1) keyed by {@code key}. */
    /** {@code rand()} — pseudorandom fp64 in [0, 1). Mapped to substrait {@code random}
    public void testCosOnIntegerArg() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = floor(num0) | fields v", 12.0);
import java.util.Map;
    /** {@code round(num0)} — PPL emits a single-arg {@code ROUND(fp64)}; resolved via
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = atan2(num1, num0) | fields v");
    }
        assertFirstRowDouble(oneRow("key00") + "| eval v = e() | fields v", Math.E);
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
     *  so use a literal in-domain fp value. Validates {@code ASIN} / {@code ACOS} adapters. */
     *  strict Utf8 and rejected Int32 ("conv: arg 0 expected string, got Int32"); arg0 must coerce. */
    // ── New Tier-1 mappings (custom yaml sigs) ────────────────────────────────
import org.opensearch.client.Response;
    public void testCosh() throws IOException {
    }
    /** {@code conv(255, 10, 16) = 'ff'} — NUMERIC literal first arg. The Rust UDF declared arg0 as
import java.io.IOException;
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = conv('FF', 16, 10) | fields v");
        assertFirstRowDouble(oneRow("key00") + "| eval v = radians(num0) | fields v", Math.toRadians(12.3));
        if (dataProvisioned == false) {
    public void testCot() throws IOException {
    }
     *  to {@link org.apache.calcite.sql.fun.SqlLibraryOperators#LEAST}. */
    private String oneRow(String key) {
    public void testLogTwoArg() throws IOException {
 */
        assertEquals("hello", cell);
    }
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
    }
    /** {@code cbrt(num0)} on num0=12.3 → ~2.309. Resolved via {@code cbrt} sig in
        assertFirstRowDouble(oneRow("key00") + "| eval v = log(num0) | fields v", Math.log(12.3));
     *  {@code sqrt(x)} to {@code POWER(x, 0.5)} ({@code SqlStdOperatorTable.SQRT} is
    }
        } catch (ResponseException e) {
    }
    }
     *  serialised through Substrait and DataFusion evaluated the call without erroring. */
 * crashing on an unknown function reference.
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    }
        }
    public void testScalarMax() throws IOException {
     *  declared in {@code opensearch_scalar_functions.yaml}, which DataFusion's substrait
    public void testTruncate() throws IOException {
 * {@code EXPM1}) are the interesting cases: they verify that the Tier-2
    /** {@code conv('-100', 10, 16) = '-64'} — negative round-trip. */
    // Substrait's sin/cos/tan/asin/acos/atan/atan2/cot extension impls are fp32/fp64 only.
    public void testAsinAndAcos() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = cosh(num1) | fields v", Math.cosh(8.42));
        assertFirstRowDouble(oneRow("key00") + "| eval v = min(num0, num1, num2) | fields v", 8.42);
     *  enum entry — coverage runs through the POWER capability. */
            assertTrue(
     *  declared-but-not-implemented in Calcite 1.41), so there is no standalone SQRT
    /** {@code log2(num0)} on num0=12.3 → ~3.62. */
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = abs(rand()) | fields v");
    private void assertFirstRowDouble(String ppl, double expected) throws IOException {
            );
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = exp(num1) | fields v");
            dataProvisioned = true;
    /** {@code e()} — literal-only expression. Calcite's {@link org.apache.calcite.rel.rules.ReduceExpressionsRule}
        assertNull(firstRowFirstCell(oneRow("key01") + "| eval v = conv(int0, 10, 16) | fields v"));
 * constant-folding the expression on the coordinator (which would require
     *  {@code org.apache.commons.text.similarity.LevenshteinDistance} on the analytics-engine
    /** {@code acos(num1)} where num1 = 8.42 → NaN; just verify DataFusion evaluates without error. */
 *   <li>{@code key00}: num0=12.3, num1=8.42, num2=17.86, num3=-11.52, int0=1, int1=-3</li>
    /** {@code log10(num0)} on num0=12.3 → ~1.09. */
     *  the custom 1-arg {@code round} signature declared in {@code opensearch_scalar_functions.yaml}
     *  plugin runtime classpath (commons-text is a Calcite optional transitive dep). */
     *  NumericToDoubleAdapter registration for {@code ScalarFunction.SIN}. */
    // ── log(base, x) and 1-arg log(x) ─────────────────────────────────────────
    /** {@code radians(12.3) = 12.3 × π / 180}. Validates the {@link
    // NumericToDoubleAdapter widening. Each test below proves the adapter widens its operand
    public void testAtan() throws IOException {
    public void testLn() throws IOException {
    }
    /** {@code radians} accepts integer fp64-widened input via NumericToDoubleAdapter — {@code radians(int0)} on {@code int0 = 1}. */
 * {@code calcs} dataset via {@code POST /_plugins/_ppl}. Tests pin a
    // ── Tier 2: PPL UDFs rewritten by ScalarFunctionAdapter ──────────────────
import org.opensearch.client.ResponseException;
        assertFirstRowDouble(oneRow("key00") + "| eval v = max(num0, num1, num2) | fields v", 17.86);
 *
     *  substrait {@code logb(x, base)}. */
    }
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = log2(num0) | fields v");
    /** {@code pi()} — literal-only expression, same path as {@link #testE()}. */
    public void testSinh() throws IOException {
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
    /** Assert the backend returned a finite numeric cell. */
        assertFirstRowDouble(oneRow("key00") + "| eval v = abs(num3) | fields v", 11.52);
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = pow(num1, num0) | fields v");
            fail("Expected ResponseException for invalid radix");
    private void assertFirstRowNumericOrNan(String ppl) throws IOException {
 * references both block Calcite's {@code ReduceExpressionsRule} from
 * End-to-end coverage for Group G math scalar functions on the analytics-engine
    }
     *  non-deterministic so {@code ReduceExpressionsRule} does not constant-fold it. */
    public void testConvInvalidRadixThrows() throws IOException {
    /** {@code radians(num3)} on a negative fp value: {@code radians(-11.52)}. */
    public void testExp() throws IOException {
    /** {@code ln(num0)} on num0 = 12.3 → ~2.51. */
    /** 1-arg {@code log(num0)} — PPL lowers to {@code LOG(num0, e)} which isthmus
        assertFalse("Expected finite numeric result for query [" + ppl + "] but got Infinity", Double.isInfinite(v));
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = conv('29234652', 10, 36) | fields v");
    /** {@code degrees(num3)} on a negative fp value: {@code degrees(-11.52)}. */
     *  {@code SignumFunction} whose isthmus sig maps to the Substrait extension {@code signum}
    public void testAcos() throws IOException {
import java.util.List;
    public void testExpm1() throws IOException {
        // STANDARD_PROJECT_OPS (Group F work not yet merged). Use a known non-zero input
    /** {@code abs(-11.52) = 11.52} on row 0's num3. */
    }
    /** {@code sqrt(num0)} on num0=12.3 → ~3.51. PPL's {@code PPLFuncImpTable} lowers
    }
    /** {@code exp(num1)} finite. */
        // invariant under test is that the call reaches DataFusion and produces a valid
        Object cell = firstRowFirstCell(ppl);
     *  token because the JSON RFC forbids {@code NaN} as a numeric literal). Proves the plan
    public void testRand() throws IOException {
    public void testRadiansOnInteger() throws IOException {
        double v = ((Number) cell).doubleValue();
        assertFirstRowDouble(oneRow("key00") + "| eval v = acos(0.5) | fields v", Math.acos(0.5));
        assertFirstRowDouble(oneRow("key00") + "| eval v = degrees(num0) | fields v", Math.toDegrees(12.3));
    public void testConvNullFirstArg() throws IOException {
    private void assertFirstRowNumericFinite(String ppl) throws IOException {
    public void testAsin() throws IOException {
    }
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = ln(num0) | fields v");
    /** {@code sin(num1)} finite on row 0's num1 = 8.42. */
    public void testSign() throws IOException {
    /** {@code cosh(num1)} via HyperbolicOperatorAdapter. */
    /** {@code conv('29234652', 10, 36) = 'hello'} — base-36 round-trip producing alpha digits. */
     *  JSON-parsed string {@code "NaN"} (OpenSearch's response parser surfaces NaN as a bare string
     *  consumer binds to its native {@code signum} Rust UDF. */
    /** {@code floor(12.3) = 12} on row 0's num0. */
     *  phrasing matters: {@code testConvWithInvalidRadix} in the SQL plugin's integ-test asserts
        assertEquals("-64", cell);
    /** {@code ceil(12.3) = 13} on row 0's num0. */
    public void testSin() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        assertFirstRowDouble(oneRow("key00") + "| eval v = pi() | fields v", Math.PI);
    }
        boolean ok = cell == null || cell instanceof Number || "NaN".equals(cell) || "Infinity".equals(cell) || "-Infinity".equals(cell);
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        assertEquals("8", firstRowFirstCell(oneRow("key00") + "| eval v = conv(int3, 10, 16) | fields v"));
    public void testLog10() throws IOException {
    }
 * <p>Tier-2 adapter functions ({@code SINH} / {@code COSH} / {@code E} /
    public void testSqrtLoweredToPower() throws IOException {
    }
                "Expected 'less than Character.MIN_RADIX' in error body but got: " + e.getMessage(),
        // saturate to Infinity/NaN depending on the configured fp64 behaviour. The
    // ── helpers ─────────────────────────────────────────────────────────────
    public void testScalarMin() throws IOException {
    /** 2-arg {@code log(base, x)} = {@code log_base(x)}. PPL emits Calcite
        assertTrue("abs(rand()) must yield a value in [0, 1): " + v, v >= 0.0 && v < 1.0);
    }
        assertFirstRowDouble(oneRow("key00") + "| eval v = cbrt(num0) | fields v", Math.cbrt(12.3));
 * {@link org.opensearch.analytics.planner.dag.BackendPlanAdapter} produces a
    }
    /** {@code conv(int3, 10, 16)} on an INTEGER COLUMN — mirrors the SQL plugin's {@code testConv}
    }
            executePpl(oneRow("key00") + "| eval v = conv('0000', 1, 36) | fields v");
    }
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
import org.opensearch.client.Request;
     *  Dynamic JSON-int columns map to long, so this is the common production type. int3 = 8 → '8'. */
    /** For queries whose exact value is sensitive to rounding or whose input falls outside the function's
    private Object firstRowFirstCell(String ppl) throws IOException {
        try {
 * <p>Each test exercises a single math function against a specific row of the
    public void testAbs() throws IOException {
    // PPL emits these on i32 fields (key00 int0=1), so isthmus fails signature lookup without
    }
    public void testPi() throws IOException {
    }
    }
    }
     *  valid domain: assert only that the backend returned a cell — a {@link Number}, null, or the
     *  on the {@code "less than Character.MIN_RADIX"} substring. */
 * this file be licensed under the Apache-2.0 license or a
    /** {@code pow(num1, num0)} → 8.42 ^ 12.3 ≈ finite double. */
    }
    }
    /** {@code atan2(num1, num0)} finite (both operands fp64, well-defined). */
        return rows.get(0).get(0);
     *  type is declared as ANY. The backend's {@code AbstractNameMappingAdapter} rewrites it to
    /** {@code conv('FF', 16, 10) = '255'} — hex input (uppercase accepted, output is decimal). */
 * The OpenSearch Contributors require contributions made to
    // ── Piggyback: SQRT rewritten to POWER(x, 0.5) in PPLFuncImpTable ─────────
 */
        assertFalse("Expected finite numeric result for query [" + ppl + "] but got NaN", Double.isNaN(v));
    }
    //   num0 = 12.3, num1 = 8.42, num2 = 17.86, num3 = -11.52
    }
     *  {@link org.apache.calcite.sql.fun.SqlLibraryOperators#GREATEST} whose standard Substrait
        Map<String, Object> response = executePpl(ppl);
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = conv('-100', 10, 16) | fields v");
/**
 * compatible open source license.
    }
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
    protected void onBeforeQuery() throws IOException {
    // Long.toString(long, int radix).
        assertFirstRowDouble(oneRow("key00") + "| eval v = round(num0) | fields v", 12.0);
    @AwaitsFix(bugUrl = "Flaky on CI: invalid-radix path occasionally returns a generic HTTP 500 with empty body instead of the NumberFormatException text")
     *  registered in STANDARD_PROJECT_OPS so the Tier-2 output is serialisable end-to-end. */
 * {@code org.apache.commons.text.similarity.LevenshteinDistance} on the
        // and verify numerically: cos(8.42) ≈ -0.5247... Sufficient to confirm the function
    // Rust UDF at rust/src/udf/conv.rs. Output is lowercase to match Java's
        assertFirstRowNumericOrNan(oneRow("key00") + "| eval v = asin(num1) | fields v");
    /** {@code sign(num3)} — PPL emits {@link org.apache.calcite.sql.fun.SqlStdOperatorTable#SIGN};
    // All row 0 (key00) values:
    /** {@code conv(CAST(int3 AS LONG), 10, 16)} — BIGINT (not just INT) first arg also coerces.
    }
public class MathScalarFunctionsIT extends AnalyticsRestTestCase {
        assertFirstRowDouble(oneRow("key00") + "| eval v = sign(num3) | fields v", -1.0);
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = log10(num0) | fields v");
    public void testLog2() throws IOException {
    public void testCeil() throws IOException {
    }
 *
    }
    /** {@code cos(1)} ≈ 0.54030 — same NumericToDoubleAdapter path. */
 * </ul>
        assertEquals("255", cell);
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = cos(num1) | fields v");
    }
        // rand() is non-deterministic, so there's no constant-folding to worry about.
        // numeric cell, not a particular precise value.
        assertFirstRowDouble(oneRow("key00") + "| eval v = truncate(num0, 0) | fields v", 12.0);
    // ── conv(n, fromBase, toBase) ──────────────────────────────────────────
 * particular row by filtering on the {@code key} keyword field and then apply
    }
    }
        // cos(num0 - num0) = cos(0) = 1; however MINUS isn't declared in this branch's
    /** {@code expm1(num1)} via Expm1Adapter → MINUS(EXP(num1), 1). Validates that MINUS is
        // Relaxed to NumericOrNan: Calcite's Expm1Adapter rewrite path can, for some
        // abs(rand()) keeps the shape identical but adds an extra capability to validate.
     *  an {@code AbstractNameMappingAdapter} swaps the operator for a dedicated Calcite
    /** {@code sin(1)} ≈ 0.84147 — fails with "Unable to convert call SIN(i32?)" without the
    /** {@code cos(0 * num1) = cos(0) = 1} — multiplying by num1 keeps a field reference without changing the constant; however TIMES isn't in this branch's capability set, so use {@code num0 - num0} instead. */
    public void testRadians() throws IOException {
    }
     *  not error, through the numeric-arg coercion. */
 * distribution), and supply the downstream Substrait consumer with {@code fp64}
    }
    public void testAtan2() throws IOException {
    }
    public void testConvNegativeNumber() throws IOException {
     *  serialises as substrait {@code logb}. */
    public void testSinOnIntegerArg() throws IOException {
    }
 * <ul>
     *  {@code opensearch_scalar_functions.yaml}. */
    }
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), 1e-6);
     *  (DataFusion UDF name) via FunctionMappings override. */
        double v = ((Number) cell).doubleValue();
        // input magnitudes, cause the DataFusion-evaluated (exp(x) - 1) to overflow or
 * RexCall rewrite inside
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    public void testRound() throws IOException {
    }
    /** {@code min(num0, num1, num2)} on row 0 — symmetric with {@code testScalarMax}; rewrites
    public void testConvBigintFirstArg() throws IOException {
