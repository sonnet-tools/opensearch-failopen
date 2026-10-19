 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> response = executePpl(
                + " | rename str2 as label, num0 as value | fields label, value | head 5"
        List<String> columns = extractColumnNames(response);
 *
            "source=" + DATASET.indexName + " | rename str2 as label | fields str2",
                + DATASET.indexName  
 * is a smoke test for the full pipeline: PPL parse → AstBuilder → CalciteRelNodeVisitor  
/**
            }
    }  
            assertTrue(  
 * compatible open source license.
    public void testRenameMultipleFields() throws IOException {
        }  
        @SuppressWarnings("unchecked")  
    }
/*  
 * SPDX-License-Identifier: Apache-2.0
        List<String> columns = extractColumnNames(response);
    private void assertSingletonColumn(Map<String, Object> response, String expectedName) {
        // CalcitePPLRenameIT.testRefRenamedField — analytics path should surface
        } catch (IOException e) {
            "source=" + DATASET.indexName + " | rename str2 as label | fields label | head 3"
            try {
            } catch (Exception ioe) {  
 * Self-contained integration test for PPL {@code rename} on the analytics-engine route.  
    public void testRenameSingleField() throws IOException {
public class RenameCommandIT extends AnalyticsRestTestCase {  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 *
        // The output column name must be the rename target ("label"), not "str2".  
    protected void onBeforeQuery() throws IOException {
            );  
        assertEquals("First renamed column", "label", columns.get(0));
        assertEquals("Row count", 3, rows.size());
    public void testRenameThenReferenceOriginalFails() {
        assertNotNull("Response missing 'schema'", columns);
        assertSingletonColumn(response, "label");
package org.opensearch.analytics.qa;
        // the same "Field [...] not found" error from the analyzer.
        );
import java.util.List;
    public void testRenameWithBackticks() throws IOException {  
        } catch (org.opensearch.client.ResponseException e) {
    }
        @SuppressWarnings("unchecked")  
        assertSingletonColumn(response, "renamed_label");  
}  
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
        assertErrorContains(  
    @Override  
        }
            String body;  
                + DATASET.indexName  
        if (dataProvisioned == false) {
 * The OpenSearch Contributors require contributions made to  
    // ── helpers ─────────────────────────────────────────────────────────────────  
        );
        try {
            Map<String, Object> response = executePpl(ppl);  
import org.opensearch.client.Response;
        // Two renames in one command, then explicit projection in the renamed names.  
                body.contains(expectedSubstring)
 * repository so the analytics-engine path can be verified inside core. The {@code rename}  
    }  
                body = e.getMessage();
            "source="
                + " | rename str2 as `renamed_label` | fields `renamed_label` | head 1"
        );  
        @SuppressWarnings("unchecked")  
    private void assertErrorContains(String ppl, String expectedSubstring) {
        // After renaming, the original name is no longer addressable. Mirrors  
import org.opensearch.client.Request;
 * command lowers to a Calcite {@code LogicalProject} with renamed output column names —
        Map<String, Object> response = executePpl(
        Map<String, Object> response = executePpl(
        assertEquals("Second renamed column", "value", columns.get(1));
        assertEquals("Column name", expectedName, columns.get(0));
 * pure projection, no scalar functions, no capability-registry dependencies. The IT here
import java.io.IOException;
    private static boolean dataProvisioned = false;
            dataProvisioned = true;
            fail("Unexpected IOException: " + e);
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
        );  
        assertEquals("Column count", 1, columns.size());  
 */  
    }
import java.util.Map;  
        assertNotNull("Response missing 'schema'", columns);
 */
 * <p>Mirrors {@code CalciteRenameCommandIT} from the {@code opensearch-project/sql}
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 * → analytics-engine planner → DataFusion execution → JSON response.
        assertEquals("Column count", 2, columns.size());  
    }  
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    }
            "source="
            "not found"
            DatasetProvisioner.provision(client(), DATASET);  
