        // `'Hello ' + str0` — Calcite emits || (CONCAT). calcs has 17 rows; str0 has three
 * SPDX-License-Identifier: Apache-2.0
        }
        if (expected instanceof Number && actual instanceof Number) {
            assertEquals(message, expected, actual);
        }
 */
            return;
    @SafeVarargs
 * repository so the analytics-engine path can be verified inside core without
            row(3, "3 pts"),
 * {@code STANDARD_PROJECT_OPS}.
            row(3, "Code: 3 pts"),
                got.size()
                + " | head 3"
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
    }
            row(1, "1 pts"),
        // Mirror image of the prefix case — LogicalExpressionDotString branch emits a Let
    }
 *
import java.util.Arrays;
        );
 *
            row(3, "Code: 3"),
            "source=" + DATASET.indexName
        // needed since isthmus' default catalog binds the || operator natively.
                + " | fields int0, code_desc",
        // Combined prefix + middle expression + suffix. The Eval emitted has a single Let
        // first OFFICE SUPPLIES — but ordering inside identical str0 isn't pinned, so we
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
        );
                + " | where isnotnull(int0)"
 * {@code AstBuilder.visitFieldformatCommand} in the SQL plugin. The unique surface
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
                + " | fields str0, greeting",
    public void testFieldformatPrefixDotCastDotSuffix() throws IOException {
                + " | where isnotnull(int0)"
            "source=" + DATASET.indexName
    // ── basic +-concat — same expression shape as `eval x = 'lit' + field` ─────
            if (Double.compare(e, a) != 0) {
                + " | sort int0"
        );
            DatasetProvisioner.provision(client(), DATASET);
            row(1, "Code: 1"),
                + " | fields int0, code_desc",
        Map<String, Object> response = executePpl(ppl);
        // input type because CAST coerces and CONCAT preserves string.
    // ── dotted-concat: CAST(int AS STRING).suffix ────────────────────────────────
    }
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        assertRows(
            row(4, "4 pts")
                + " | fieldformat code_desc = CAST(int0 AS STRING).\" pts\""
 * sugar: {@code fieldformat x = "prefix".CAST(y AS STRING)." suffix"} expands to
        assertRows(
                + " | head 3"
 * compatible open source license.
                + " | fieldformat code_desc = \"Code: \".CAST(int0 AS STRING)"
 * The OpenSearch Contributors require contributions made to
        // with suffix=literal, expression=CAST. Output column type is string regardless of
        assertRows(
                want.size(),
        }
            }
 * {@code opensearch-sql}'s {@code UnifiedQueryService} sets the cluster setting
            }
                + " | head 3"
    }
}
                + " | head 3"
import org.opensearch.client.Request;
    public void testFieldformatCastDotSuffix() throws IOException {
        // chained with the `.` form unique to fieldformat. AstExpressionBuilder's
        // whose expression is CONCAT(CONCAT(prefix, CAST(...)), suffix). All three operands
                );
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
 * {@link org.opensearch.analytics.spi.ScalarFunction#CONCAT}, already in
            dataProvisioned = true;
package org.opensearch.analytics.qa;
/**
        );
 * {@code plugins.calcite.enabled}; the gate is satisfied here because
    }
            row("FURNITURE", "Hello FURNITURE"),
    @Override
/*
 */
            row(1, "Code: 1 pts"),
 * {@link DatasetProvisioner}.
 * route through Calcite's {@code ||} operator and resolve to
                + " | sort int0"
 * <p>Mirrors {@code CalciteFieldFormatCommandIT} from the {@code opensearch-project/sql}
import java.io.IOException;
    }
import java.util.Map;
            List<Object> got = actualRows.get(i);
                + " | sort int0"
 * vs plain {@code eval} is the prefix-{@code .} and suffix-{@code .} string-concat
        // and the Eval's CalciteRexNodeVisitor wraps both in a CONCAT.
        assertEquals(message, expected, actual);
                + " | sort str0, int0"
            double a = ((Number) actual).doubleValue();
    private static void assertCellEquals(String message, Object expected, Object actual) {
                + " | fields int0, code_desc",
        // `"Code: ".CAST(int0 AS STRING)` — prefix string + CAST-to-string of an integer,
 *
        if (dataProvisioned == false) {
    // ── dotted-concat: prefix.CAST(int AS STRING) ────────────────────────────────
                    got.get(j)
        @SuppressWarnings("unchecked")
        for (int i = 0; i < expected.length; i++) {
                + " | fieldformat greeting = \"Hello \" + str0"
 * this file be licensed under the Apache-2.0 license or a
            row("FURNITURE", "Hello FURNITURE"),
    }
        if (expected == null || actual == null) {
        assertRows(
            assertEquals(
        // StringDotlogicalExpression branch emits a Let with prefix=literal, expression=CAST,
            double e = ((Number) expected).doubleValue();
import org.opensearch.client.Response;
        // `head 3 | sort str0`, the first three are the FURNITURE/FURNITURE pair plus the
            "source=" + DATASET.indexName
            row(4, "Code: 4 pts")
    }
 * <p>{@code fieldformat} is a Calcite-only command (gated on
        // sort by both key and a deterministic int0 first.
    public void testFieldformatPlusConcat() throws IOException {
            return;
    public void testFieldformatPrefixDotCast() throws IOException {
    private static boolean dataProvisioned = false;
                    want.get(j),
 * cross-plugin dependencies on the SQL plugin.
            row("OFFICE SUPPLIES", "Hello OFFICE SUPPLIES")
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
                "Column count mismatch at row " + i + " for query: " + ppl,
            List<Object> want = expected[i];
                + " | where isnotnull(int0)"
        return Arrays.asList(values);
 * a chain of {@code CONCAT} calls. Both {@code +}-style concat and the dotted form
 *
public class FieldFormatCommandIT extends AnalyticsRestTestCase {
            );
 * Self-contained integration test for PPL {@code fieldformat} on the analytics-engine route.
    private static List<Object> row(Object... values) {
import java.util.List;
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
            row(4, "Code: 4")
                assertCellEquals(
    @SuppressWarnings("varargs")
        // route through the CONCAT capability in STANDARD_PROJECT_OPS — no extension lookup
        // distinct values: FURNITURE (×2), OFFICE SUPPLIES (×6), TECHNOLOGY (×9). After
    // ── dotted-concat: prefix.CAST(int AS STRING).suffix ─────────────────────────
            "source=" + DATASET.indexName
    // ── helpers ─────────────────────────────────────────────────────────────────
 * to true on every request). It lowers to a plain {@code Eval} node — see
                + " | fieldformat code_desc = \"Code: \".CAST(int0 AS STRING).\" pts\""
        }
    protected void onBeforeQuery() throws IOException {
            for (int j = 0; j < want.size(); j++) {
