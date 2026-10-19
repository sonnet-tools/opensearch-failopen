    public void testCosh() throws IOException {  
    /** {@code rand()} — pseudorandom fp64 in [0, 1). Mapped to substrait {@code random}
     *  the custom 1-arg {@code round} signature declared in {@code opensearch_scalar_functions.yaml}
        assertFirstRowDouble(oneRow("key00") + "| eval v = floor(num0) | fields v", 12.0);
 * crashing on an unknown function reference.  
    private String oneRow(String key) {
    public void testConvHexToDecimal() throws IOException {
    public void testAtan() throws IOException {
import org.opensearch.client.Request;
     *  (DataFusion UDF name) via FunctionMappings override. Calcite marks {@code RAND} as  
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = exp(num1) | fields v");
    /** Assert the backend returned a finite numeric cell. */  
    /** {@code cos(1)} ≈ 0.54030 — same NumericToDoubleAdapter path. */  
    }
    }
        double v = ((Number) cell).doubleValue();
        assertFirstRowDouble(oneRow("key00") + "| eval v = max(num0, num1, num2) | fields v", 17.86);
    }  
    }
    /** {@code log10(num0)} on num0=12.3 → ~1.09. */  
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = cos(num1) | fields v");
            DatasetProvisioner.provision(client(), DATASET);
     *  plugin runtime classpath (commons-text is a Calcite optional transitive dep). */
    }
 */  
    public void testLogTwoArg() throws IOException {
    }
     *  non-deterministic so {@code ReduceExpressionsRule} does not constant-fold it. */
    }
    public void testConvNegativeNumber() throws IOException {
    }
    /** 2-arg {@code log(base, x)} = {@code log_base(x)}. PPL emits Calcite
 * The OpenSearch Contributors require contributions made to  
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);  
    }
    /** {@code conv(int0, 10, 16)} where int0 is NULL (key01) → NULL. Null first arg must propagate,
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = ln(num0) | fields v");  
 * RexCall rewrite inside  
    /** {@code conv('-100', 10, 16) = '-64'} — negative round-trip. */
    /** {@code asin(num1)} where num1 = 8.42 → NaN (out of range), but we just verify the call reaches DataFusion and returns a numeric cell (NaN counts). */  
        Object cell = firstRowFirstCell(ppl);
    public void testRadiansOnInteger() throws IOException {
    }  
    public void testConvNumericColumnFirstArg() throws IOException {
import org.opensearch.client.Response;  
    /** 1-arg {@code log(num0)} — PPL lowers to {@code LOG(num0, e)} which isthmus
    public void testAcos() throws IOException {  
    }
    /** {@code conv(255, 10, 16) = 'ff'} — NUMERIC literal first arg. The Rust UDF declared arg0 as
    /** {@code radians} accepts integer fp64-widened input via NumericToDoubleAdapter — {@code radians(int0)} on {@code int0 = 1}. */
    public void testConvBigintFirstArg() throws IOException {  
        assertFirstRowDouble(oneRow("key00") + "| eval v = acos(0.5) | fields v", Math.acos(0.5));  
    //   num0 = 12.3, num1 = 8.42, num2 = 17.86, num3 = -11.52
        boolean ok = cell == null || cell instanceof Number || "NaN".equals(cell) || "Infinity".equals(cell) || "-Infinity".equals(cell);
     *  to {@link org.apache.calcite.sql.fun.SqlLibraryOperators#LEAST}. */  
     *  not error, through the numeric-arg coercion. */
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = pow(num1, num0) | fields v");  
     *  {@code SignumFunction} whose isthmus sig maps to the Substrait extension {@code signum}
    }
public class MathScalarFunctionsIT extends AnalyticsRestTestCase {
    }  
    }  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = conv('FF', 16, 10) | fields v");  
    /** For queries whose exact value is sensitive to rounding or whose input falls outside the function's
    }  
    }
    // PPL `conv` lowers to ScalarFunction.CONVERT → ConvAdapter → substrait `conv` →  
     *  Dynamic JSON-int columns map to long, so this is the common production type. int3 = 8 → '8'. */
        }
    /** {@code conv(CAST(int3 AS LONG), 10, 16)} — BIGINT (not just INT) first arg also coerces.
        // cos(num0 - num0) = cos(0) = 1; however MINUS isn't declared in this branch's
        @SuppressWarnings("unchecked")
            dataProvisioned = true;  
    }
    }
    public void testAbs() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = truncate(num0, 0) | fields v", 12.0);  
     *  (DataFusion UDF name) via FunctionMappings override. */  
    private void assertFirstRowNumericFinite(String ppl) throws IOException {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        assertFirstRowDouble(oneRow("key00") + "| eval v = e() | fields v", Math.E);
        assertFirstRowDouble(oneRow("key00") + "| eval v = cbrt(num0) | fields v", Math.cbrt(12.3));  
    /** {@code expm1(num1)} via Expm1Adapter → MINUS(EXP(num1), 1). Validates that MINUS is
 * distribution), and supply the downstream Substrait consumer with {@code fp64}
    /** {@code ceil(12.3) = 13} on row 0's num0. */  
    }
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);  
 *
    }  
    }  
     *  an {@code AbstractNameMappingAdapter} swaps the operator for a dedicated Calcite
        assertFirstRowNumericOrNan(oneRow("key00") + "| eval v = asin(num1) | fields v");
    public void testScalarMax() throws IOException {
     *  substrait {@code logb(x, base)}. */
     *  {@link org.apache.calcite.sql.fun.SqlLibraryOperators#GREATEST} whose standard Substrait
    /** {@code conv(int3, 10, 16)} on an INTEGER COLUMN — mirrors the SQL plugin's {@code testConv}
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = atan2(num1, num0) | fields v");  
    public void testAsin() throws IOException {
     *  (conv(age, 10, 16)), the exact shape the coercion bug surfaced on. int3 = 8 at key00 → 'ff'  
        // log base 10 of num0 = log10(12.3)  
    protected void onBeforeQuery() throws IOException {  
    private static boolean dataProvisioned = false;  
    }  
 * the math function to one of that row's {@code num*} (DOUBLE) fields — field
     *  of 8 is '8'; key01's int3 = 13 → 'd'. */
    /** {@code truncate(num0, 0)} on num0=12.3 → 12. Mapped to substrait {@code trunc}
        assertFirstRowDouble(oneRow("key00") + "| eval v = cosh(num1) | fields v", Math.cosh(8.42));
     *  type is declared as ANY. The backend's {@code AbstractNameMappingAdapter} rewrites it to
     *  valid domain: assert only that the backend returned a cell — a {@link Number}, null, or the
     *  declared-but-not-implemented in Calcite 1.41), so there is no standalone SQRT
    /** {@code round(num0)} — PPL emits a single-arg {@code ROUND(fp64)}; resolved via
    /** {@code cot(num1)} finite. */  
    // PPL emits these on i32 fields (key00 int0=1), so isthmus fails signature lookup without
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    public void testConvInvalidRadixThrows() throws IOException {
 *
 * this file be licensed under the Apache-2.0 license or a
    }  
     *  folds this to {@code Math.E} at plan time on the coordinator. Requires  
        assertTrue("Expected numeric rand() result but got: " + cell, cell instanceof Number);  
    public void testPi() throws IOException {
    }
     *  {@code opensearch_scalar_functions.yaml}. */
    /** {@code degrees(num3)} on a negative fp value: {@code degrees(-11.52)}. */
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = conv('-100', 10, 16) | fields v");  
    @AwaitsFix(bugUrl = "Flaky on CI: invalid-radix path occasionally returns a generic HTTP 500 with empty body instead of the NumberFormatException text")
    }
    public void testExpm1() throws IOException {  
    /** {@code pi()} — literal-only expression, same path as {@link #testE()}. */
    /** {@code e()} — literal-only expression. Calcite's {@link org.apache.calcite.rel.rules.ReduceExpressionsRule}
    public void testCeil() throws IOException {
 *  
    /** {@code max(num0, num1, num2)} on row 0 — PPL emits a {@code SCALAR_MAX} UDF whose return  
    public void testScalarMin() throws IOException {
    }
                "Expected 'less than Character.MIN_RADIX' in error body but got: " + e.getMessage(),
    public void testRand() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = log(num0) | fields v", Math.log(12.3));
     *  (the default Substrait catalog only ships {@code round(x, digits)}). */  
    /** {@code sign(num3)} — PPL emits {@link org.apache.calcite.sql.fun.SqlStdOperatorTable#SIGN};  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = conv('29234652', 10, 36) | fields v");  
    public void testAsinAndAcos() throws IOException {
    }  
    }
        // rand() is non-deterministic, so there's no constant-folding to worry about.  
    /** {@code cos(0 * num1) = cos(0) = 1} — multiplying by num1 keeps a field reference without changing the constant; however TIMES isn't in this branch's capability set, so use {@code num0 - num0} instead. */
    /** {@code degrees(12.3) = 12.3 × 180 / π}. Validates the {@link  
     *  org.opensearch.analytics.spi.NumericToDoubleAdapter} entry for {@code ScalarFunction.DEGREES}. */
    // to fp64 before substrait emission.
    public void testFloor() throws IOException {  
    }
    /** {@code acos(num1)} where num1 = 8.42 → NaN; just verify DataFusion evaluates without error. */
    private Object firstRowFirstCell(String ppl) throws IOException {  
    public void testConvDecimalToBase36() throws IOException {
import java.io.IOException;  
    // Substrait's sin/cos/tan/asin/acos/atan/atan2/cot extension impls are fp32/fp64 only.
    }
    }
 * {@code EXPM1}) are the interesting cases: they verify that the Tier-2
    }
    public void testCbrt() throws IOException {
    /** {@code asin(0.5)} / {@code acos(0.5)} — int0=1 is out of asin's [-1,1] domain on row 0,
    public void testRadians() throws IOException {
        // and verify numerically: cos(8.42) ≈ -0.5247... Sufficient to confirm the function  
 * </ul>
        assertFirstRowDouble(oneRow("key00") + "| eval v = radians(int0) | fields v", Math.toRadians(1));  
     *  serialised through Substrait and DataFusion evaluated the call without erroring. */
    }
    public void testSqrtLoweredToPower() throws IOException {  
            );
    public void testCot() throws IOException {
 * <p>Each test exercises a single math function against a specific row of the
    }  
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = log10(num0) | fields v");
    }
        Object cell = firstRowFirstCell(ppl);
        assertFirstRowDouble(oneRow("key00") + "| eval v = degrees(num3) | fields v", Math.toDegrees(-11.52));
    public void testSinOnIntegerArg() throws IOException {
    // ── Trig on integer-typed input ────────────────────────────────────────  
    public void testLog10() throws IOException {
        assertEquals("8", firstRowFirstCell(oneRow("key00") + "| eval v = conv(cast(int3 as long), 10, 16) | fields v"));
     *  phrasing matters: {@code testConvWithInvalidRadix} in the SQL plugin's integ-test asserts
        assertFirstRowDouble(oneRow("key00") + "| eval v = radians(num0) | fields v", Math.toRadians(12.3));  
    }  
        assertEquals("255", cell);
    }
        assertFirstRowDouble(oneRow("key00") + "| eval v = sign(num3) | fields v", -1.0);  
        assertFirstRowDouble(oneRow("key00") + "| eval v = sqrt(num0) | fields v", Math.sqrt(12.3));
    // NumericToDoubleAdapter widening. Each test below proves the adapter widens its operand  
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
    public void testLogOneArg() throws IOException {
     *  NumericToDoubleAdapter registration for {@code ScalarFunction.SIN}. */
    }
            assertTrue(
        assertFirstRowDouble(oneRow("key00") + "| eval v = degrees(int0) | fields v", Math.toDegrees(1));
 * constant-folding the expression on the coordinator (which would require
    public void testLn() throws IOException {
 * route (PPL → CalciteRelNodeVisitor → Substrait → DataFusion).  
    /** {@code sinh(num1)} via HyperbolicOperatorAdapter. */  
        // numeric cell, not a particular precise value.
    /** Base query template: filter to exactly one row (cardinality 1) keyed by {@code key}. */
    }
    // All row 0 (key00) values:
    }  
 * SPDX-License-Identifier: Apache-2.0
        assertFirstRowDouble(oneRow("key00") + "| eval v = atan2(int0, int0) | fields v", Math.PI / 4.0);
    public void testRound() throws IOException {
        // input magnitudes, cause the DataFusion-evaluated (exp(x) - 1) to overflow or
    }
 * engine-module runtime classpath and is not configured in the sandbox  
    // Long.toString(long, int radix).
        assertFirstRowDouble(oneRow("key00") + "| eval v = min(num0, num1, num2) | fields v", 8.42);
        assertTrue("Expected numeric or NaN-token result for query [" + ppl + "] but got: " + cell, ok);  
    }
        assertFirstRowDouble(oneRow("key00") + "| eval v = ceil(num0) | fields v", 13.0);
     *  declared in {@code opensearch_scalar_functions.yaml}, which DataFusion's substrait  
    }  
    }
    /** {@code radians(12.3) = 12.3 × π / 180}. Validates the {@link  
        assertFalse("Expected finite numeric result for query [" + ppl + "] but got Infinity", Double.isInfinite(v));  
    public void testAtan2() throws IOException {
    public void testCosOnIntegerArg() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = log(10, num0) | fields v", Math.log(12.3) / Math.log(10.0));
    /** {@code conv('FF', 16, 10) = '255'} — hex input (uppercase accepted, output is decimal). */
    public void testDegreesOnInteger() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = radians(num3) | fields v", Math.toRadians(-11.52));
     *  serialises as substrait {@code logb}. */  
     *  {@code org.apache.commons.text.similarity.LevenshteinDistance} on the analytics-engine
    public void testTruncate() throws IOException {
        assertEquals("ff", cell);
    }
    // ── Piggyback: SQRT rewritten to POWER(x, 0.5) in PPLFuncImpTable ─────────  
    /** {@code floor(12.3) = 12} on row 0's num0. */
    }
    /** {@code sin(num1)} finite on row 0's num1 = 8.42. */
    public void testE() throws IOException {  
        assertFirstRowDouble(oneRow("key00") + "| eval v = sinh(num1) | fields v", Math.sinh(8.42));
    // ── log(base, x) and 1-arg log(x) ─────────────────────────────────────────  
    /** {@code radians(num3)} on a negative fp value: {@code radians(-11.52)}. */  
        }
    public void testPower() throws IOException {
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = abs(rand()) | fields v");
    public void testLog2() throws IOException {  
     *  strict Utf8 and rejected Int32 ("conv: arg 0 expected string, got Int32"); arg0 must coerce. */
        assertFirstRowDouble(oneRow("key00") + "| eval v = asin(0.5) | fields v", Math.asin(0.5));
    }
    }
 * references both block Calcite's {@code ReduceExpressionsRule} from  
        assertFirstRowDouble(oneRow("key00") + "| eval v = pi() | fields v", Math.PI);  
 *   <li>{@code key04}: num0=3.5,  num1=9.05, num2=6.46,  num3=12.93,  int0=7, int1=null</li>
        if (dataProvisioned == false) {
        return rows.get(0).get(0);  
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = log2(num0) | fields v");
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
 *   <li>{@code key00}: num0=12.3, num1=8.42, num2=17.86, num3=-11.52, int0=1, int1=-3</li>  
 * operands that match every Group G Substrait signature's expected family.
    // ── helpers ─────────────────────────────────────────────────────────────
package org.opensearch.analytics.qa;
        assertFirstRowDouble(oneRow("key00") + "| eval v = round(num0) | fields v", 12.0);
    }
 */
     *  {@code SqlLibraryOperators.LOG(x, base)} (arg-swapped) which isthmus serialises as  
     *  consumer binds to its native {@code signum} Rust UDF. */
    public void testSin() throws IOException {  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = conv(255, 10, 16) | fields v");
    // ── Tier 2: PPL UDFs rewritten by ScalarFunctionAdapter ──────────────────
    public void testSinh() throws IOException {
    public void testAtan2OnIntegerArgs() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = degrees(num0) | fields v", Math.toDegrees(12.3));  
    /** {@code min(num0, num1, num2)} on row 0 — symmetric with {@code testScalarMax}; rewrites
    }
        assertFirstRowDouble(oneRow("key00") + "| eval v = sin(int0) | fields v", Math.sin(1.0));  
            executePpl(oneRow("key00") + "| eval v = conv('0000', 1, 36) | fields v");
        // abs(rand()) keeps the shape identical but adds an extra capability to validate.
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = cot(num1) | fields v");
     *  {@code sqrt(x)} to {@code POWER(x, 0.5)} ({@code SqlStdOperatorTable.SQRT} is  
     *  on the {@code "less than Character.MIN_RADIX"} substring. */  
    /** {@code pow(num1, num0)} → 8.42 ^ 12.3 ≈ finite double. */
    public void testConvNullFirstArg() throws IOException {  
 * {@code calcs} dataset via {@code POST /_plugins/_ppl}. Tests pin a  
/**
    private void assertFirstRowNumericOrNan(String ppl) throws IOException {  
import org.opensearch.client.ResponseException;
    }  
    public void testCos() throws IOException {  
 * Substrait plan DataFusion's native runtime actually evaluates, instead of
    public void testDegreesNegative() throws IOException {  
    /** {@code sqrt(num0)} on num0=12.3 → ~3.51. PPL's {@code PPLFuncImpTable} lowers
    /** {@code cbrt(num0)} on num0=12.3 → ~2.309. Resolved via {@code cbrt} sig in  
 * <p>Row values used (from {@code calcs/bulk.json}):
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = atan(num1) | fields v");  
    public void testConvNumericLiteralFirstArg() throws IOException {  
    @Override
 * <ul>
    /** {@code sin(1)} ≈ 0.84147 — fails with "Unable to convert call SIN(i32?)" without the  
        // PPL truncate takes (value, scale); with scale=0 on 12.3 returns 12.
        assertEquals("hello", cell);
        // Relaxed to NumericOrNan: Calcite's Expm1Adapter rewrite path can, for some
        assertTrue("abs(rand()) must yield a value in [0, 1): " + v, v >= 0.0 && v < 1.0);
    private void assertFirstRowDouble(String ppl, double expected) throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = cos(int0) | fields v", Math.cos(1.0));
     *  JSON-parsed string {@code "NaN"} (OpenSearch's response parser surfaces NaN as a bare string  
    }  
            fail("Expected ResponseException for invalid radix");
     *  so use a literal in-domain fp value. Validates {@code ASIN} / {@code ACOS} adapters. */  
        // saturate to Infinity/NaN depending on the configured fp64 behaviour. The  
 * particular row by filtering on the {@code key} keyword field and then apply
        double v = ((Number) cell).doubleValue();
        assertNull(firstRowFirstCell(oneRow("key01") + "| eval v = conv(int0, 10, 16) | fields v"));
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";  
        assertFalse("Expected finite numeric result for query [" + ppl + "] but got NaN", Double.isNaN(v));
    /** {@code conv('29234652', 10, 36) = 'hello'} — base-36 round-trip producing alpha digits. */
    /** Invalid radix surfaces as a 5xx with Java's NumberFormatException message text. The exact
    // ── Tier 1: direct Substrait mappings applied to a DOUBLE field reference ──  
 *  
        // wiring reaches DataFusion without explicitly checking an exact value.
/*  
    /** {@code log2(num0)} on num0=12.3 → ~3.62. */
    /** {@code atan2(num1, num0)} finite (both operands fp64, well-defined). */
     *  enum entry — coverage runs through the POWER capability. */
 * <p>Tier-2 adapter functions ({@code SINH} / {@code COSH} / {@code E} /
        } catch (ResponseException e) {  
    public void testDegrees() throws IOException {
        // invariant under test is that the call reaches DataFusion and produces a valid
    /** {@code abs(-11.52) = 11.52} on row 0's num3. */
}  
        Object cell = firstRowFirstCell(ppl);
        assertEquals("-64", cell);
    /** {@code atan2(1, 1)} = π/4 — two-arg variant goes through {@code ScalarFunction.ATAN2}. */  
 * {@link org.opensearch.analytics.planner.dag.BackendPlanAdapter} produces a
 * compatible open source license.
import java.util.Map;
import java.util.List;
    // Rust UDF at rust/src/udf/conv.rs. Output is lowercase to match Java's
     *  org.opensearch.analytics.spi.NumericToDoubleAdapter} entry for {@code ScalarFunction.RADIANS}. */
        assertFirstRowNumericFinite(oneRow("key00") + "| eval v = sin(num1) | fields v");
     *  token because the JSON RFC forbids {@code NaN} as a numeric literal). Proves the plan
    /** Acos on num1=8.42 is out of valid range (|x|>1) so DataFusion returns NaN; use sign check of output against num0/10.0 range. Use num0=12.3 / 13 ≈ 0.946 — within [-1,1]. But dividing requires DIVIDE. Use num1/num1 = 1.0 — but DIVIDE not available. Fall back to a computed input using atan which is unbounded. */
        Map<String, Object> response = executePpl(ppl);
                e.getMessage().contains("less than Character.MIN_RADIX")  
    /** {@code exp(num1)} finite. */
        assertEquals("d", firstRowFirstCell(oneRow("key01") + "| eval v = conv(int3, 10, 16) | fields v"));
    /** {@code cosh(num1)} via HyperbolicOperatorAdapter. */
        // STANDARD_PROJECT_OPS (Group F work not yet merged). Use a known non-zero input
    }  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
    public void testExp() throws IOException {  
    // ── New Tier-1 mappings (custom yaml sigs) ────────────────────────────────
     *  registered in STANDARD_PROJECT_OPS so the Tier-2 output is serialisable end-to-end. */
        try {  
    }
    // ── conv(n, fromBase, toBase) ──────────────────────────────────────────
    /** {@code degrees} accepts integer fp64-widened input via NumericToDoubleAdapter — {@code degrees(int0)} on {@code int0 = 1}. */  
        assertEquals("8", firstRowFirstCell(oneRow("key00") + "| eval v = conv(int3, 10, 16) | fields v"));  
    public void testSign() throws IOException {
     *  serialisation DataFusion evaluates natively. */  
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), 1e-6);
 * End-to-end coverage for Group G math scalar functions on the analytics-engine
        assertFirstRowNumericOrNan(oneRow("key00") + "| eval v = acos(num1) | fields v");
    /** {@code ln(num0)} on num0 = 12.3 → ~2.51. */
        assertFirstRowDouble(oneRow("key00") + "| eval v = abs(num3) | fields v", 11.52);  
 * {@code org.apache.commons.text.similarity.LevenshteinDistance} on the
    public void testRadiansNegative() throws IOException {
        assertFirstRowNumericOrNan(oneRow("key00") + "| eval v = expm1(num1) | fields v");  
