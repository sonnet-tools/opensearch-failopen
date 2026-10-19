    public void testMinOnObjectField() throws IOException {
    }
    public void testMaxOnDeeplyNestedObjectField() throws IOException {
        }  
            "source=" + DATASET.indexName + " | where city.name='Seattle' | fields account.owner",  
        assertRowsEqual(
            "source=" + DATASET.indexName + " | stats max(city.location.latitude)",
            row(2380000)  
import java.util.Map;
            row("Seattle"),
    // a fetch stage pulls the doc from the shard, and the parent sub-object is
            List<Object> got = actualRows.get(i);
    // through QualifiedNameResolver and throw "Field [city.location] not found".
            row("Seattle", 47.6062),
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);  
        );
            row("Portland", "bob"),
    }
            row(Map.of("name", "Seattle", "population", 750000, "location", Map.of("latitude", 47.6062, "longitude", -122.3321)))
            row("Portland")
import java.util.List;  
    }  
            "source=" + DATASET.indexName + " | fields city, account | head 1",
            "source=" + DATASET.indexName + " | fields city.location | head 1",
            row(  
        assertRowsEqual(
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    }
    public void testFilterOnDeeplyNestedObjectField() throws IOException {
 * the purpose is to surface exact failure modes for follow-up debugging, not to
    // Support requires query-then-fetch (QTF): coordinator returns docIds post-filter,  
            row("Portland"),
    }
            "source=" + DATASET.indexName + " | fields city.name | head 3",  
            row("Austin", 30.2672)  
            row(Map.of("latitude", 47.6062, "longitude", -122.3321))
        assertRowsEqual(
        );
        assertRowsEqual(
    // reconstructed from _source or from parquet rows. QTF is tracked separately.
        );
            DatasetProvisioner.provision(client(), DATASET);
/**  
                Map.of("name", "Seattle", "population", 750000, "location", Map.of("latitude", 47.6062, "longitude", -122.3321)),
    @AwaitsFix(bugUrl = "Object parent projection requires query-then-fetch (QTF) for source-based materialization")
import java.util.Arrays;
    }  
import java.io.IOException;
    // ── helpers (mirrored from FieldsCommandIT) ────────────────────────────────  
public class ObjectFieldIT extends AnalyticsRestTestCase {
            "source=" + DATASET.indexName + " | stats sum(city.population)",
    }
import org.opensearch.client.Response;
    @SafeVarargs  
    //
    private static final Dataset DATASET = new Dataset("object_fields", "object_fields");
    // ── Object-parent projection (gated on query-then-fetch) ──────────────────
 * {@code ObjectFieldOperateIT}. Every test here is expected to fail initially —
 * via dotted-path notation ({@code city.name}, {@code city.location.latitude}) on the
        assertRowsEqual(
        );  
    public void testSelectSingleObjectField() throws IOException {
    public void testSelectDeeplyNestedObjectField() throws IOException {
        }
    public void testSelectTopLevelObjectField() throws IOException {
 * Diagnostic integration tests for PPL access to OpenSearch {@code object} fields
        @SuppressWarnings("unchecked")
 * The OpenSearch Contributors require contributions made to  
            row("Seattle", Map.of("latitude", 47.6062, "longitude", -122.3321))
        );  
    @SuppressWarnings("varargs")
            row("Seattle", "alice"),
            List<Object> want = expected[i];  
/*  
    }
        assertRowsEqual(
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
            "source=" + DATASET.indexName + " | fields city.name, city.location | head 1",
            "source=" + DATASET.indexName + " | where city.location.latitude > 40 | fields city.name",
            row("Seattle"),  
    // only flat leaves into the Calcite row type today, so parent references fall  
    private static List<Object> row(Object... values) {
    public void testSelectTopLevelObjectFieldWithSiblings() throws IOException {  
}
    // returns a nested JSON value reconstructed from _source. Analytics-engine emits
        );
        );
            row(300.25)
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
            row("Portland", 45.5152),
    public void testSelectIntermediateObjectField() throws IOException {
            }
        return Arrays.asList(values);  
        );  
package org.opensearch.analytics.qa;
        );
 *
    }
        );
        assertRowsEqual(  
            row(47.6062)
            "source=" + DATASET.indexName + " | fields city | head 1",  
    }
        for (int i = 0; i < expected.length; i++) {
 */  
 * SPDX-License-Identifier: Apache-2.0
            "source=" + DATASET.indexName + " | fields city.name, account.owner | head 3",  
            "source=" + DATASET.indexName + " | fields city.name, city.location.latitude | head 3",  
 * exercise a working implementation.  
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());
 * analytics-engine route. Mirrors the shape of the sql repo's  
        // This test treats latitude as a double, not geo point.  
        assertRowsEqual(  
            row("Austin", "carol")  
                assertEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, want.get(j), got.get(j));
    //  
 * this file be licensed under the Apache-2.0 license or a
        assertRowsEqual(
            row("Austin")  
    public void testSelectMultipleObjectFields() throws IOException {
    }  
    @AwaitsFix(bugUrl = "Object parent projection requires query-then-fetch (QTF) for source-based materialization")  
import org.opensearch.client.Request;
    }
        Map<String, Object> response = executePpl(ppl);  
 */
    private static boolean dataProvisioned = false;  
    // Projecting an object parent (top-level "city" or intermediate "city.location")
        assertRowsEqual(  
        assertRowsEqual(
    public void testFilterOnObjectField() throws IOException {
    public void testSumOnObjectField() throws IOException {  
        assertRowsEqual(
    }
    }
            row("alice")
    @Override
            dataProvisioned = true;  
            for (int j = 0; j < want.size(); j++) {  
            )  
        );
 * compatible open source license.
                Map.of("owner", "alice", "balance", 1000.50)
        if (dataProvisioned == false) {
    public void testSelectParentAndLeafMixed() throws IOException {
    @AwaitsFix(bugUrl = "Object parent projection requires query-then-fetch (QTF) for source-based materialization")
            "source=" + DATASET.indexName + " | stats min(account.balance)",  
    protected void onBeforeQuery() throws IOException {  
        );
    @AwaitsFix(bugUrl = "Object parent projection requires query-then-fetch (QTF) for source-based materialization")
    }  
