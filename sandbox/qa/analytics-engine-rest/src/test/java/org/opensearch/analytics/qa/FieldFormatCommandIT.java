 * {@code opensearch-sql}'s {@code UnifiedQueryService} sets the cluster setting  
            row(1, "Code: 1 pts"),
            row(3, "Code: 3 pts"),
            DatasetProvisioner.provision(client(), DATASET);
        // `'Hello ' + str0` — Calcite emits || (CONCAT). calcs has 17 rows; str0 has three  
        // `"Code: ".CAST(int0 AS STRING)` — prefix string + CAST-to-string of an integer,
    }  
    // ── helpers ─────────────────────────────────────────────────────────────────
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
        );
                assertCellEquals(  
    // ── dotted-concat: CAST(int AS STRING).suffix ────────────────────────────────
 * <p>{@code fieldformat} is a Calcite-only command (gated on
        // needed since isthmus' default catalog binds the || operator natively.
 * repository so the analytics-engine path can be verified inside core without
        // distinct values: FURNITURE (×2), OFFICE SUPPLIES (×6), TECHNOLOGY (×9). After
    }
                + " | sort int0"  
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
        assertRows(  
        assertRows(
        // StringDotlogicalExpression branch emits a Let with prefix=literal, expression=CAST,
                + " | where isnotnull(int0)"
import java.util.Arrays;
 * {@code STANDARD_PROJECT_OPS}.
                    want.get(j),
 * {@code AstBuilder.visitFieldformatCommand} in the SQL plugin. The unique surface
    private static List<Object> row(Object... values) {  
            "source=" + DATASET.indexName
 * {@link DatasetProvisioner}.
    private static boolean dataProvisioned = false;
                + " | where isnotnull(int0)"  
        @SuppressWarnings("unchecked")
    public void testFieldformatPrefixDotCastDotSuffix() throws IOException {
    // ── dotted-concat: prefix.CAST(int AS STRING) ────────────────────────────────
}
        // sort by both key and a deterministic int0 first.
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    }  
                + " | where isnotnull(int0)"
        }  
        );
 *
        // `head 3 | sort str0`, the first three are the FURNITURE/FURNITURE pair plus the
            row("FURNITURE", "Hello FURNITURE"),
    // ── dotted-concat: prefix.CAST(int AS STRING).suffix ─────────────────────────
 * route through Calcite's {@code ||} operator and resolve to  
        // and the Eval's CalciteRexNodeVisitor wraps both in a CONCAT.
    }
                + " | fieldformat code_desc = \"Code: \".CAST(int0 AS STRING).\" pts\""
    }
 * a chain of {@code CONCAT} calls. Both {@code +}-style concat and the dotted form
import org.opensearch.client.Request;
import java.util.List;  
            double a = ((Number) actual).doubleValue();
                got.size()  
            }
                + " | fields int0, code_desc",
            return;  
    // ── basic +-concat — same expression shape as `eval x = 'lit' + field` ─────  
            List<Object> got = actualRows.get(i);
 * {@code plugins.calcite.enabled}; the gate is satisfied here because
                + " | fieldformat greeting = \"Hello \" + str0"  
                    got.get(j)  
package org.opensearch.analytics.qa;
 * SPDX-License-Identifier: Apache-2.0
            row(4, "4 pts")
        if (expected == null || actual == null) {
        if (expected instanceof Number && actual instanceof Number) {  
            "source=" + DATASET.indexName
        }
        assertRows(
/**  
            row("OFFICE SUPPLIES", "Hello OFFICE SUPPLIES")
            "source=" + DATASET.indexName  
            return;
                + " | sort int0"
            row("FURNITURE", "Hello FURNITURE"),  
 * vs plain {@code eval} is the prefix-{@code .} and suffix-{@code .} string-concat  
                + " | head 3"
            if (Double.compare(e, a) != 0) {  
        // whose expression is CONCAT(CONCAT(prefix, CAST(...)), suffix). All three operands  
    @SafeVarargs
        // Combined prefix + middle expression + suffix. The Eval emitted has a single Let
            assertEquals(message, expected, actual);  
/*  
 * <p>Mirrors {@code CalciteFieldFormatCommandIT} from the {@code opensearch-project/sql}  
 * cross-plugin dependencies on the SQL plugin.
 * Self-contained integration test for PPL {@code fieldformat} on the analytics-engine route.
import org.opensearch.client.Response;
                );
            assertEquals(  
    protected void onBeforeQuery() throws IOException {
        Map<String, Object> response = executePpl(ppl);
        assertEquals(message, expected, actual);
        );
            row(3, "Code: 3"),
        assertRows(  
                want.size(),
    private static void assertCellEquals(String message, Object expected, Object actual) {
        // first OFFICE SUPPLIES — but ordering inside identical str0 isn't pinned, so we  
import java.util.Map;
        }
        // Mirror image of the prefix case — LogicalExpressionDotString branch emits a Let
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < expected.length; i++) {  
 * to true on every request). It lowers to a plain {@code Eval} node — see
    }
        return Arrays.asList(values);
                + " | sort str0, int0"
import java.io.IOException;
            row(1, "1 pts"),
        // route through the CONCAT capability in STANDARD_PROJECT_OPS — no extension lookup
 */  
 *
                + " | head 3"
    @Override
 */  
 * The OpenSearch Contributors require contributions made to  
 *  
 * sugar: {@code fieldformat x = "prefix".CAST(y AS STRING)." suffix"} expands to
            dataProvisioned = true;
                "Column count mismatch at row " + i + " for query: " + ppl,
        );
        // with suffix=literal, expression=CAST. Output column type is string regardless of
 *  
    public void testFieldformatPrefixDotCast() throws IOException {
                + " | head 3"
            double e = ((Number) expected).doubleValue();
 * {@link org.opensearch.analytics.spi.ScalarFunction#CONCAT}, already in
    public void testFieldformatPlusConcat() throws IOException {
            row(3, "3 pts"),  
            for (int j = 0; j < want.size(); j++) {
                + " | fields int0, code_desc",  
            }
        if (dataProvisioned == false) {  
                + " | sort int0"  
                + " | fields int0, code_desc",  
 * compatible open source license.
            row(1, "Code: 1"),
                + " | fieldformat code_desc = \"Code: \".CAST(int0 AS STRING)"
        }  
    }
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    }  
            List<Object> want = expected[i];
    @SuppressWarnings("varargs")
            );
            row(4, "Code: 4 pts")  
        // chained with the `.` form unique to fieldformat. AstExpressionBuilder's  
                + " | fields str0, greeting",
            row(4, "Code: 4")  
        // input type because CAST coerces and CONCAT preserves string.  
                + " | head 3"
            "source=" + DATASET.indexName
public class FieldFormatCommandIT extends AnalyticsRestTestCase {
                + " | fieldformat code_desc = CAST(int0 AS STRING).\" pts\""  
    public void testFieldformatCastDotSuffix() throws IOException {  
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
