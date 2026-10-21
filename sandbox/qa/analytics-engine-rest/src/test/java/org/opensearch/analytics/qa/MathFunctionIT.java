    }
    @Override
        assertFirstRowDouble(
    }
            25.0);
            25.0);
    }
    /** All tests pin to one row so assertions are deterministic. {@code int0=1} on this row. */
            12.3 * 12.3);
            oneRow() + "| eval result = floor(int2) | fields result",
package org.opensearch.analytics.qa;
        Object cell = firstRowFirstCell(ppl);
        @SuppressWarnings("unchecked")
    /** {@code exp(cast as long)} — i64 input, covered by standard substrait yaml. */
 *   <li>{@link org.opensearch.analytics.spi.NumericToDoubleAdapter} — widens operands of
    /** {@code truncate(int, int_scale)} 2-arg — both i32. */
            oneRow() + "| eval result = truncate(num0, 1) | fields result", // num0 = 12.3
 *       transcendental fns ({@code EXP/LN/LOG/POWER/...}) whose Calcite return type is
    /** {@code power(i32, fp64)} — i32 base, fp64 (double literal) exponent. */
    // ── trunc(i32) / trunc(i32, i32) → i32 ──────────────────────────────────
        if (dataProvisioned == false) {
/*
import org.opensearch.client.Request;
    // ── signum(i32) → i32 ───────────────────────────────────────────────────
    public void testExpOnIntLiteral() throws IOException {
    // ── log2(i32) ───────────────────────────────────────────────────────────
    }
            Math.log(8) / Math.log(2));
 *
            -1.0);
        assertFirstRowDouble(
        Map<String, Object> response = executePpl(ppl);
 * standard yaml declares math fns for {@code i64/fp32/fp64} only; Calcite emits them with
            oneRow() + "| eval result = pow(num0, 2.0) | fields result", // num0 = 12.3
            Math.exp(2));
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
            Math.log(5));
            oneRow() + "| eval result = truncate(int2) | fields result",
import java.util.List;
            oneRow() + "| eval result = ln(int2) | fields result",
    public void testSqrtOnIntColumn() throws IOException {
    public void testLog2OnIntColumn() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            Math.sqrt(5));
            oneRow() + "| eval result = pow(int2, cast(2.0 as float)) | fields result",
 * SPDX-License-Identifier: Apache-2.0
    /** {@code power(i32, i32)} → fp64 per Calcite return-type rules. */
    }
 * compatible open source license.
            oneRow() + "| eval result = pow(int2, cast(2 as long)) | fields result",
    }
            5.0);
public class MathFunctionIT extends AnalyticsRestTestCase {
    /** {@code ceil(int)} is a no-op (no fractional part). Our overload preserves the i32 width. */
    private Object firstRowFirstCell(String ppl) throws IOException {
            -1.0);
    public void testLnOnIntColumn() throws IOException {
    /** {@code ceil(double_col)} — fp64 → i32 (Calcite return type) handled by standard yaml. */
    /** {@code exp(int_column)} — i32 column input, our i32 overload. */
        assertFirstRowDouble(
    public void testExpOnLongCast() throws IOException {
    /** {@code truncate(int)} 1-arg — i32 no-op overload. */
    }
    // ── ceil(i32) / floor(i32) — return i32 unchanged ───────────────────────
            25.0);
    }
            oneRow() + "| eval result = sqrt(int2) | fields result", // int2 = 5
            13.0);
    // ── helpers (mirror ArrayFunctionIT) ────────────────────────────────────
import org.opensearch.client.Response;
    public void testPowerIntInt() throws IOException {
    }
            Math.exp(1));
            12.0);
 *       {@code CEIL(int)} / {@code FLOOR(int)} / {@code SIGN(int)} / {@code TRUNCATE(int [, scale])}
    private String oneRow() {
    /** {@code power(i32, i64)} — i32 base, cast-to-long exponent. */
 *       already {@code fp64}.</li>
    // ── power: 4 mixed-type combinations the i32-left overloads cover ───────
        }
            oneRow() + "| eval result = ceil(num0) | fields result", // num0 = 12.3
            DatasetProvisioner.provision(client(), DATASET);
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
/**
            oneRow() + "| eval result = exp(int0) | fields result",
        assertFirstRowDouble(
 *   <li>{@link org.opensearch.analytics.spi.IntegerRoundingCastAdapter} — wraps
        assertFirstRowDouble(
        assertFirstRowDouble(
    public void testExpOnIntColumn() throws IOException {
        assertFirstRowDouble(
        assertFirstRowDouble(
 * End-to-end coverage for PPL math functions on the analytics-engine route. Substrait's
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
 */
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    protected void onBeforeQuery() throws IOException {
    /** {@code power(i32, fp32)} — i32 base, cast-to-float exponent. */
    }
    /** {@code power(fp64, fp64)} — both fp64, covered by standard substrait. */
        assertFirstRowDouble(
    public void testPowerIntLong() throws IOException {
    public void testTruncateIntIntScale() throws IOException {
            oneRow() + "| eval result = ceil(int2) | fields result",
    private void assertFirstRowDouble(String ppl, double expected) throws IOException {
import java.io.IOException;
        assertFirstRowDouble(
            oneRow() + "| eval result = sign(num3) | fields result", // num3 = -11.52
    public void testPowerIntDouble() throws IOException {
            oneRow() + "| eval result = floor(num0) | fields result",
    }
    private static boolean dataProvisioned = false;
    public void testSignumOnDoubleColumn() throws IOException {
    public void testTruncateIntOneArg() throws IOException {
        assertFirstRowDouble(
 * </ul>
    public void testTruncateDoubleIntScale() throws IOException {
            oneRow() + "| eval result = pow(int2, 2) | fields result",
        assertFirstRowDouble(
    public void testCeilOnDoubleColumn() throws IOException {
            oneRow() + "| eval result = pow(int2, 2.0) | fields result",
            5.0);
            oneRow() + "| eval result = exp(cast(2 as long)) | fields result",
            oneRow() + "| eval result = truncate(int2, 0) | fields result",
        assertFirstRowDouble(
        assertFirstRowDouble(
            Math.log10(8));
    // ── ln(i32) ─────────────────────────────────────────────────────────────
        return rows.get(0).get(0);
        assertFirstRowDouble(
    public void testSignumOnIntColumn() throws IOException {
        return "source=" + DATASET.indexName + " | head 1 ";
        assertFirstRowDouble(
            oneRow() + "| eval result = sign(int1) | fields result", // int1 = -3
    }
 * the gap before substrait conversion:
            oneRow() + "| eval result = exp(2) | fields result",
    }
 * <ul>
    public void testPowerIntFloat() throws IOException {
    // ── exp(i32) ────────────────────────────────────────────────────────────
        assertFirstRowDouble(
    }
    }
 * {@code i32} args from PPL int literals and OS {@code integer} columns. Two adapters bridge
    /** {@code truncate(double, int_scale)} 2-arg — fp64 + i32 scale, covered by existing yaml. */
    }
    public void testFloorOnDoubleColumn() throws IOException {
    // ── sqrt(i32) ───────────────────────────────────────────────────────────
    }
    public void testCeilOnIntColumn() throws IOException {
            12.3);
 *       as {@code CAST(<udf>(CAST(int_first_arg AS DOUBLE) [, trailing_args...]) AS <orig_int_type>)}
    }
    // ── log10(i32) ──────────────────────────────────────────────────────────
}
            5.0);
    public void testPowerDoubleDouble() throws IOException {
    }
            25.0);
            oneRow() + "| eval result = log2(int3) | fields result",
    }
            Math.exp(2));
        assertFirstRowDouble(
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), 1e-9);
            dataProvisioned = true;
    public void testLog10OnIntColumn() throws IOException {
 *       so isthmus binds the standard {@code <udf>(fp64) → fp64} impl while preserving the
            5.0);
    }
        assertFirstRowDouble(
    }
    }
        assertFirstRowDouble(
import java.util.Map;
 *       user-visible "same type as input" return contract.</li>
        assertFirstRowDouble(
    }
    }
 */
            oneRow() + "| eval result = log10(int3) | fields result", // int3 = 8
    public void testFloorOnIntColumn() throws IOException {
    /** {@code exp(int_literal)} — i32 literal input. */
    /** {@code sign(int)} via Calcite SIGN → SignumFunction → DataFusion signum. */
 * The OpenSearch Contributors require contributions made to
