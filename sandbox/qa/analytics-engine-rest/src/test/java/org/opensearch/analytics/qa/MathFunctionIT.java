    // ── sqrt(i32) ───────────────────────────────────────────────────────────  
 *       so isthmus binds the standard {@code <udf>(fp64) → fp64} impl while preserving the
        assertFirstRowDouble(
        assertFirstRowDouble(
    /** {@code power(i32, i32)} → fp64 per Calcite return-type rules. */
    }
    }  
            oneRow() + "| eval result = truncate(int2, 0) | fields result",
    private void assertFirstRowDouble(String ppl, double expected) throws IOException {
            -1.0);
        assertFirstRowDouble(
        assertFirstRowDouble(  
            Math.log10(8));  
    public void testLog2OnIntColumn() throws IOException {
        }
}
    }
            5.0);
            12.0);  
        if (dataProvisioned == false) {
            Math.log(8) / Math.log(2));
            oneRow() + "| eval result = truncate(num0, 1) | fields result", // num0 = 12.3
        assertFirstRowDouble(
    /** {@code exp(int_literal)} — i32 literal input. */
        assertFirstRowDouble(
    /** {@code exp(cast as long)} — i64 input, covered by standard substrait yaml. */
    // ── trunc(i32) / trunc(i32, i32) → i32 ──────────────────────────────────
 *       as {@code CAST(<udf>(CAST(int_first_arg AS DOUBLE) [, trailing_args...]) AS <orig_int_type>)}
    public void testLog10OnIntColumn() throws IOException {  
import org.opensearch.client.Response;
    /** {@code exp(int_column)} — i32 column input, our i32 overload. */  
 *       transcendental fns ({@code EXP/LN/LOG/POWER/...}) whose Calcite return type is  
    // ── power: 4 mixed-type combinations the i32-left overloads cover ───────  
        assertFirstRowDouble(  
    @Override  
            oneRow() + "| eval result = truncate(int2) | fields result",  
    public void testExpOnIntLiteral() throws IOException {
    }  
            oneRow() + "| eval result = ln(int2) | fields result",  
 *       already {@code fp64}.</li>
    /** {@code power(fp64, fp64)} — both fp64, covered by standard substrait. */  
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);  
 * the gap before substrait conversion:  
    public void testTruncateDoubleIntScale() throws IOException {  
        assertFirstRowDouble(
        assertFirstRowDouble(
    }  
    public void testPowerIntFloat() throws IOException {
        assertFirstRowDouble(
        Object cell = firstRowFirstCell(ppl);  
            Math.sqrt(5));
    /** All tests pin to one row so assertions are deterministic. {@code int0=1} on this row. */
    /** {@code power(i32, fp32)} — i32 base, cast-to-float exponent. */
    }
 * standard yaml declares math fns for {@code i64/fp32/fp64} only; Calcite emits them with
    /** {@code power(i32, fp64)} — i32 base, fp64 (double literal) exponent. */
 *   <li>{@link org.opensearch.analytics.spi.IntegerRoundingCastAdapter} — wraps
            oneRow() + "| eval result = sign(num3) | fields result", // num3 = -11.52  
import org.opensearch.client.Request;
    }
            -1.0);
    private String oneRow() {  
    }
            oneRow() + "| eval result = log10(int3) | fields result", // int3 = 8
    }
/**
            dataProvisioned = true;
    public void testExpOnIntColumn() throws IOException {
            5.0);
        assertFirstRowDouble(
            Math.log(5));
            25.0);
            12.3 * 12.3);
    protected void onBeforeQuery() throws IOException {
    public void testCeilOnDoubleColumn() throws IOException {  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    // ── log10(i32) ──────────────────────────────────────────────────────────
        assertFirstRowDouble(  
            25.0);  
    /** {@code truncate(int, int_scale)} 2-arg — both i32. */
 * <ul>
        assertFirstRowDouble(  
        assertFirstRowDouble(  
            oneRow() + "| eval result = sqrt(int2) | fields result", // int2 = 5
    // ── log2(i32) ───────────────────────────────────────────────────────────  
            oneRow() + "| eval result = log2(int3) | fields result",
    }
        return "source=" + DATASET.indexName + " | head 1 ";
    public void testFloorOnIntColumn() throws IOException {
            oneRow() + "| eval result = pow(int2, 2) | fields result",
            oneRow() + "| eval result = exp(cast(2 as long)) | fields result",
        assertFirstRowDouble(  
    // ── exp(i32) ────────────────────────────────────────────────────────────
    }
    // ── ln(i32) ─────────────────────────────────────────────────────────────
    private static boolean dataProvisioned = false;
import java.util.Map;  
    }  
            oneRow() + "| eval result = pow(int2, cast(2.0 as float)) | fields result",
 * SPDX-License-Identifier: Apache-2.0
    }  
            oneRow() + "| eval result = sign(int1) | fields result", // int1 = -3  
 * this file be licensed under the Apache-2.0 license or a
        assertFirstRowDouble(
 *   <li>{@link org.opensearch.analytics.spi.NumericToDoubleAdapter} — widens operands of
            DatasetProvisioner.provision(client(), DATASET);  
        @SuppressWarnings("unchecked")
 */  
    public void testSignumOnIntColumn() throws IOException {
    /** {@code ceil(int)} is a no-op (no fractional part). Our overload preserves the i32 width. */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    public void testPowerIntInt() throws IOException {  
    }  
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
    public void testCeilOnIntColumn() throws IOException {
            oneRow() + "| eval result = pow(num0, 2.0) | fields result", // num0 = 12.3  
    }
    public void testLnOnIntColumn() throws IOException {
        assertFirstRowDouble(
    }
 * The OpenSearch Contributors require contributions made to  
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
            oneRow() + "| eval result = exp(int0) | fields result",  
            13.0);  
    public void testPowerDoubleDouble() throws IOException {
            oneRow() + "| eval result = pow(int2, cast(2 as long)) | fields result",  
public class MathFunctionIT extends AnalyticsRestTestCase {  
            oneRow() + "| eval result = ceil(num0) | fields result", // num0 = 12.3
        assertFirstRowDouble(
    /** {@code sign(int)} via Calcite SIGN → SignumFunction → DataFusion signum. */  
    private Object firstRowFirstCell(String ppl) throws IOException {
    public void testSignumOnDoubleColumn() throws IOException {
 * End-to-end coverage for PPL math functions on the analytics-engine route. Substrait's  
 *       user-visible "same type as input" return contract.</li>  
            12.3);  
    public void testFloorOnDoubleColumn() throws IOException {  
 * {@code i32} args from PPL int literals and OS {@code integer} columns. Two adapters bridge
/*  
    // ── helpers (mirror ArrayFunctionIT) ────────────────────────────────────  
        assertFirstRowDouble(
            25.0);  
    }
    public void testPowerIntDouble() throws IOException {  
    public void testPowerIntLong() throws IOException {
    /** {@code truncate(double, int_scale)} 2-arg — fp64 + i32 scale, covered by existing yaml. */
    }  
            oneRow() + "| eval result = floor(num0) | fields result",
    }
            Math.exp(2));  
            Math.exp(1));
            oneRow() + "| eval result = exp(2) | fields result",
    }  
            oneRow() + "| eval result = floor(int2) | fields result",
 * compatible open source license.
    // ── ceil(i32) / floor(i32) — return i32 unchanged ───────────────────────
    }
            oneRow() + "| eval result = pow(int2, 2.0) | fields result",
 * </ul>
 *       {@code CEIL(int)} / {@code FLOOR(int)} / {@code SIGN(int)} / {@code TRUNCATE(int [, scale])}  
        Map<String, Object> response = executePpl(ppl);  
        assertFirstRowDouble(
            Math.exp(2));
    public void testTruncateIntOneArg() throws IOException {
    /** {@code power(i32, i64)} — i32 base, cast-to-long exponent. */  
package org.opensearch.analytics.qa;
        assertFirstRowDouble(  
    }  
    public void testTruncateIntIntScale() throws IOException {
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), 1e-9);
    // ── signum(i32) → i32 ───────────────────────────────────────────────────
import java.io.IOException;
        return rows.get(0).get(0);
    public void testExpOnLongCast() throws IOException {  
    public void testSqrtOnIntColumn() throws IOException {
    /** {@code truncate(int)} 1-arg — i32 no-op overload. */  
            oneRow() + "| eval result = ceil(int2) | fields result",
import java.util.List;
    }  
 */
            5.0);
            5.0);
    }
    /** {@code ceil(double_col)} — fp64 → i32 (Calcite return type) handled by standard yaml. */
            25.0);
 *
    }
