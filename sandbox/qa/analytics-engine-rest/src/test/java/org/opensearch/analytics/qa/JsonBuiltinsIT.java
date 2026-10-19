    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {  
import java.util.List;  
                + " b = json('{\"invalid\": \"json\"') | fields a, b | head 1",
 */  
    @Override
public class JsonBuiltinsIT extends AnalyticsRestTestCase {
            List<Object> got = actualRows.get(i);
/**  
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());  
            "source=" + DATASET.indexName
    private static boolean dataProvisioned = false;  
    }
            dataProvisioned = true;  
    public void testJsonArrayHeterogeneousScalars() throws IOException {  
        );
    }
 * {@code json_array}) over the shared `calcs` dataset. DataFusion's stdlib does not ship
            "source=" + DATASET.indexName  
            "source=" + DATASET.indexName + " | eval r = json_array('Tom', 'Walt') | fields r | head 1",
        );  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
            row("{\"outer\":\"{\\\"inner\\\":123.45}\"}")
        assertRowsEqual(
    public void testJsonObjectNestedValueQuotedAsString() throws IOException {
import java.util.Map;
        Map<String, Object> response = executePpl(ppl);
    }
 * compatible open source license.
 * {@code json} round-trips valid input and returns NULL on malformed; {@code json_object}
import java.util.Arrays;
            row("[1,2,3,{\"f1\":1,\"f2\":[5,6]},4]", null)  
            row("[1,2,0,-1,1.1,-0.11]")
    public void testJsonArrayStringValues() throws IOException {
        for (int i = 0; i < expected.length; i++) {  
        assertRowsEqual(
 * this file be licensed under the Apache-2.0 license or a
            row("[\"Tom\",\"Walt\"]")
    }
            }  
 * The OpenSearch Contributors require contributions made to  
    }
        );
        assertRowsEqual(
        assertRowsEqual(
 * these primitives, so each is backed by a custom Rust UDF in  
 */
    }  
            DatasetProvisioner.provision(client(), DATASET);
        }
        @SuppressWarnings("unchecked")
                + " | eval r = json_object('outer', json_object('inner', 123.45)) | fields r | head 1",
        assertNotNull("Response missing 'datarows' for query: " + ppl, actualRows);
    private static List<Object> row(Object... values) {  
 *
            List<Object> want = expected[i];
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
/*  
            "source=" + DATASET.indexName + " | eval r = json_object('key', 123.45) | fields r | head 1",  
    public void testJsonObjectStringKeyNumericValue() throws IOException {
    }  
        );  
        }
 * End-to-end coverage for the PPL JSON builtins ({@code json}, {@code json_object},
        // quoted-and-escaped (legacy `gson.toJson(String)` parity).
        // The inner json_object result is a JSON string — outer json_object emits it  
import java.io.IOException;
            for (int j = 0; j < want.size(); j++) {
 * and {@code json_array} preserve numeric / boolean / nested-JSON tagging.  
    public void testJsonValidRoundTripsAndInvalidReturnsNull() throws IOException {
                + " | eval a = json('[1,2,3,{\"f1\":1,\"f2\":[5,6]},4]'),"
    @SuppressWarnings("varargs")
                assertEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, want.get(j), got.get(j));
        );
        assertRowsEqual(  
}  
    @SafeVarargs
 * `analytics-backend-datafusion/rust/src/udf/`. These tests cover the legacy contracts:
    protected void onBeforeQuery() throws IOException {  
package org.opensearch.analytics.qa;
            "source=" + DATASET.indexName  
            row("{\"key\":123.45}")
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        return Arrays.asList(values);
 * SPDX-License-Identifier: Apache-2.0
    }
        if (dataProvisioned == false) {
                + " | eval r = json_array(1, 2, 0, -1, 1.1, -0.11) | fields r | head 1",  
