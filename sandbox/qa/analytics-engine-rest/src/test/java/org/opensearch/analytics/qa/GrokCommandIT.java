 * Self-contained integration test for the PPL {@code grok} command on the
    public void testGrokAddressOverriding() throws IOException {
        return Arrays.asList(values);
            "source=" + DATASET.indexName  
                assertEquals(
                "Column count mismatch at row " + i + " for query: " + ppl,
                want.size(),  
            "source=" + DATASET.indexName  
    public void testGrokEmailHost() throws IOException {
     * Lazily provision the grok dataset on first invocation. Mirrors  
                got.size()
import java.util.Map;
        if (dataProvisioned == false) {
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
    // ── HOSTNAME extraction (RE2-clean pattern) ────────────────────────────────
        // the synthetic-group → field remapping (name0 → host) still requires the  
    /**
        // "%{COMMONAPACHELOG}" recursively expands IPORHOST / HTTPDATE / NUMBER /  
                + " | sort id | grok email '.+@%{HOSTNAME:host}' | fields email, host",
 * address) and {@code weblogs} (apache log line) values asserted by
        // lookbehind `(?<![0-9.+-])` and an atomic group `(?>…)`, both rejected by  
import java.util.Arrays;
            row("amberduke@pyrami.com", "pyrami.com"),
        Map<String, Object> response = executePpl(ppl);
        assertRows(  
                );
    /**
 * compatible open source license.
    }
 * SPDX-License-Identifier: Apache-2.0
    // ── NUMBER + GREEDYDATA (lookbehind + atomic group) ────────────────────────
        @SuppressWarnings("unchecked")  
        // grok-aware UDF rather than the raw `parse` path.
    @SuppressWarnings("varargs")  
 *
            row("Bristol Street"),
        // "%{NUMBER} %{GREEDYDATA:address}" — NUMBER → BASE10NUM uses a negative
    // ── helpers ────────────────────────────────────────────────────────────────
        );  
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
    private static boolean dataProvisioned = false;  
            }  
 * call per named group. The {@code grok} Rust UDF carries the default grok pattern
    private static final Dataset DATASET = new Dataset("grok", "grok");
                + " | sort id | grok address '%{NUMBER} %{GREEDYDATA:address}' | fields address",
    @Override  
        for (int i = 0; i < expected.length; i++) {
        assertRows(
            row("28/Sep/2022:10:15:57 -0700", "301")
     */
        // etc. into a large regex riddled with lookarounds and atomic groups.
 * with {@code fancy-regex} (the resolved patterns use lookbehind / atomic groups  
        // source `address` column.
 * {@code CalcitePPLGrokIT}, sorted by {@code id} for deterministic ordering.  
/**  
 * Substrait → DataFusion pipeline.  
     */
        assertRows(
            List<Object> want = expected[i];
    }  
 * which runs the {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} →
 * {@code parse}: it lowers to one {@code ITEM(GROK(field, pattern, "grok"), "<field>")}  
 *
            assertEquals(
 * <p>The data is a small index whose rows reproduce the {@code bank} (email,
 * dictionary, recursively resolves {@code %{NAME:field}} references, and matches
import java.io.IOException;
            );
 */
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
            row("28/Sep/2022:10:15:57 -0700", "404"),
    }  
 * The OpenSearch Contributors require contributions made to  
    protected void onBeforeQuery() throws IOException {
            row("hattiebond@netagy.com", "netagy.com"),  
 * <p>{@code grok <field> '<grok-pattern>'} is the grok-syntax sibling of
            dataProvisioned = true;
                    want.get(j),  
package org.opensearch.analytics.qa;
    @SafeVarargs
    }
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());  
            DatasetProvisioner.provision(client(), DATASET);  
     * {@link ParseCommandIT}'s pattern — {@code client()} is unavailable at static init.
 */  
            row("nanettebates@quility.com", "quility.com")
    }  
        // ".+@%{HOSTNAME:host}" — HOSTNAME resolves to a lookaround-free regex, but
            row("28/Sep/2022:10:15:57 -0700", "100"),  
            for (int j = 0; j < want.size(); j++) {  
 *  
/*  
    }  
        }
        }
        );
 * {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql} plugin),
        );
    private static List<Object> row(Object... values) {
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
 * this file be licensed under the Apache-2.0 license or a
            List<Object> got = actualRows.get(i);  
 * is unanchored, mirroring Java grok's {@code Matcher.find()}.
     * Send a PPL query and assert each returned row equals the expected positional row.  
            row("Holmes Lane"),  
                    got.get(j)
 * repository so the analytics-engine path can be verified inside core without a
 * the RE2-based {@code regex} crate behind {@code parse} cannot compile). Matching
    public void testGrokApacheLog() throws IOException {
}  
 * cross-plugin dependency on the SQL plugin. Each test sends a PPL query through  
public class GrokCommandIT extends AnalyticsRestTestCase {
import java.util.List;  
            "source=" + DATASET.indexName
        // the RE2-based `regex` crate. The grok field name `address` overrides the
                + " | sort id | grok log '%{COMMONAPACHELOG}' | fields timestamp, response",
 * analytics-engine route.
    // ── COMMONAPACHELOG (lookbehind, lookahead, atomic groups, recursion) ──────  
 * <p>Mirrors {@code CalcitePPLGrokIT} from the {@code opensearch-project/sql}
            row("Madison Street")
 *  
