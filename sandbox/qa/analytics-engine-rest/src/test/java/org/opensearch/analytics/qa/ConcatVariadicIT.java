        return Arrays.asList(values);
    @SafeVarargs
            DatasetProvisioner.provision(client(), DATASET);
 * VARCHAR / FixedChar operand list (the natural shape when fields and short string  
        assertRowsEqual(
        assertNotNull("Response missing 'datarows' for query: " + ppl, actualRows);
import java.util.Map;
        }
    }
 * every non-VARCHAR operand to VARCHAR so substrait emits a uniform-typed call.
            row("one-e")  
            "source=" + DATASET.indexName + " | eval r = concat(upper(str3), lower(str0)) | fields r | head 1",  
        // VARCHAR-typed scalar call, so the variadic adapter makes no change. `FUR` + `CLA`.  
 */  
            row("FURCLA")  
    }
        // substring(_,1,3) yields `FUR` and `CLA` → `FUR|CLA`.
 * str2="one", str3="e".  
    protected void onBeforeQuery() throws IOException {  
        // concat of two different scalar-function operands, no literal: upper(str3)=`E`,
 * addition to the field/literal shapes — the natural form of queries like
            for (int j = 0; j < want.size(); j++) {
        // Mixed shape: VARCHAR field + FixedChar literal + VARCHAR field. First row of
 */
        );
 * compatible open source license.
    public void testConcatUpperAndLowerScalarFns() throws IOException {
        // calcs has str2=`one` and str3=`e`, so the result is `one-e`.  
            List<Object> want = expected[i];
    private static boolean dataProvisioned = false;  
        // 3-arg concat(scalarFn, literal, scalarFn) with two distinct functions around a FixedChar  
        );
                + " | where str0 != '' and str1 != ''"  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    public void testConcatSubstringLiteralSubstringWithFilter() throws IOException {
/**  
                + DATASET.indexName
        }
        Map<String, Object> response = executePpl(ppl);
 *
 * <p>Fixture row 0 ({@code key00}) of calcs: str0="FURNITURE", str1="CLAMP ON LAMPS",
            }  
            "source="
    public void testConcatScalarFnLiteralScalarFnDistinctFns() throws IOException {
    @Override
        assertRowsEqual(
            row("Efurniture")
    }
                + " | fields r | head 1",
        );
 * <p>Operand-shape coverage matters here: a concat operand can be a field reference
        // 2-arg concat of two SUBSTRING calls, no middle literal — every operand is an already
    }
 * SPDX-License-Identifier: Apache-2.0
        assertRowsEqual(  
    }  
 * call ({@code RexCall}, e.g. {@code substring(...)}). These travel different conversion  
 * ({@code RexInputRef}), a string literal ({@code RexLiteral}), or a nested scalar-function
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {  
            dataProvisioned = true;  
 * this file be licensed under the Apache-2.0 license or a
    }
                + " | eval r = concat(substring(str0, 1, 3), '|', substring(str1, 1, 3))"
        assertRowsEqual(
 * {@code concat(substring(url, 1, 10), '|', substring(referer, 1, 10))}.  
public class ConcatVariadicIT extends AnalyticsRestTestCase {
        // 3-arg concat of short literals — every operand is FixedChar, so the cast
        );  
            "source=" + DATASET.indexName + " | eval r = concat('He', 'll', 'o') | fields r | head 1",
        // operands are RexCalls (not field refs) typed VARCHAR.
package org.opensearch.analytics.qa;
        // 3-arg concat where the outer operands are SUBSTRING scalar-function calls (RexCall, not
        for (int i = 0; i < expected.length; i++) {  
import java.util.List;  
 *
/*  
            "source=" + DATASET.indexName + " | eval r = concat(left(str0, 3), '#', right(str0, 3)) | fields r | head 1",
        );
    @SuppressWarnings("varargs")
        assertRowsEqual(
    }
    }
            row("FUR|CLA")  
        @SuppressWarnings("unchecked")
    private static List<Object> row(Object... values) {  
        assertRowsEqual(  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    public void testConcatFieldAndLiteralAndField() throws IOException {
            "source=" + DATASET.indexName + " | eval r = concat(substring(str0, 1, 3), substring(str1, 1, 3)) | fields r | head 1",
            List<Object> got = actualRows.get(i);
 * Substrait declares {@code concat} with CONSISTENT parameter consistency, so a mixed
                assertEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, want.get(j), got.get(j));
        // same fields. Row 0 of calcs has str0=`FURNITURE` and str1=`CLAMP ON LAMPS`, so
            row("Hello")  
        );
            "source=" + DATASET.indexName + " | eval r = concat(str2, '-', str3) | fields r | head 1",
}  
    }
 * literals appear together) trips isthmus' consistency check. The adapter pre-casts
import java.io.IOException;
        // literal: left(str0,3)=`FUR`, right(str0,3)=`URE` → `FUR#URE`. Exercises the cast path on
 * End-to-end coverage for variadic {@code concat(...)} over the shared `calcs` dataset.
        // lower(str0)=`furniture` → `Efurniture`. Confirms the adapter's no-op path holds when  
    public void testConcatTwoSubstringsNoLiteral() throws IOException {
        // path is exercised across all three slots.  
import java.util.Arrays;
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());  
        if (dataProvisioned == false) {
 *  
            row("FUR#URE")
 * paths, so the tests below exercise concat over <em>scalar-function operands</em> in
        // field refs) and the middle operand is a short string literal, above a WHERE filter on the  
    public void testConcatThreeStringLiterals() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        // the middle literal while both outer operands are scalar-function calls.
