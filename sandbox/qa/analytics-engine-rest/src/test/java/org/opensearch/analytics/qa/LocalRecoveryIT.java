        bulkRequest.setOptions(
        try {
        // Query after restart — must return identical results  
        List<List<Object>> afterRows = executePplRows(ppl);
            bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build()
        } catch (Exception e) {
        indexProvisioned = true;  
public class LocalRecoveryIT extends AnalyticsRestTestCase {  
        int docId = 1;  
        Response closeResponse = client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_close"));
                docId++;
        // Query before restart
        int numBatches = 5;
package org.opensearch.analytics.qa;
            + "  \"index.composite.primary_data_format\": \"parquet\","  
import java.io.IOException;
 */
    private static final String INDEX_NAME = "local_recovery_test";
                afterRows.get(i).size()
                beforeRows.get(i).size(),  
            for (int j = 0; j < beforeRows.get(i).size(); j++) {  
                "Row " + i + " must be identical after restart: before=" + beforeRows.get(i) + " after=" + afterRows.get(i),
        healthRequest.addParameter("timeout", "30s");
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
        String body = "{"  
            if (Double.compare(e, a) != 0) {
        healthRequest.addParameter("wait_for_status", "green");
        // Close the index — engine shuts down
        assertEquals("Row count must match after restart", beforeRows.size(), afterRows.size());
        Request bulkRequest = new Request("POST", "/" + INDEX_NAME + "/_bulk");
            assertEquals(
            }  
            + "  \"index.pluggable.dataformat\": \"composite\","
            + "}";
        assertEquals(message, expected, actual);  
        Map<String, Object> bulkResponse = assertOkAndParse(client().performRequest(bulkRequest), "Bulk index");
        for (int batch = 0; batch < numBatches; batch++) {  
        for (int i = 0; i < beforeRows.size(); i++) {  
 *
        // Ingest documents in multiple batches with flush between each to create multiple segments
            for (int j = 0; j < beforeRows.get(i).size(); j++) {  
    }  
        assertEquals("Index creation must be acknowledged", true, createResponse.get("acknowledged"));  
        assertEquals("Row count must match after restart", beforeRows.size(), afterRows.size());
 * after a restart without requiring a translog replay or explicit refresh.
                    .append(docId)
        assertEquals("Should have 5 rows before restart", 5, beforeRows.size());
     * and asserts the results are identical. This is the core validation that committed
        List<List<Object>> afterRows = executePplRows(ppl);
        StringBuilder bulk = new StringBuilder();  
        healthRequest.addParameter("timeout", "60s");  
     */
/*  
        }  
            client().performRequest(new Request("DELETE", "/" + INDEX_NAME));  
        );  
        client().performRequest(healthRequest);
            + "\"mappings\": {"  
            // Flush after each batch to create separate segments
        } catch (Exception e) {
        Request createIndex = new Request("PUT", "/" + INDEX_NAME);  
            client().performRequest(new Request("DELETE", "/" + indexName));  
        Request flushRequest = new Request("POST", "/" + INDEX_NAME + "/_flush");
        bulk.append("{\"index\": {}}\n{\"name\": \"eve\", \"age\": 32, \"score\": 91.0}\n");
        flushRequest.addParameter("force", "true");  
            );
            + "  }"
 *
        Map<String, Object> parsed = assertOkAndParse(response, "PPL: " + ppl);
        // Wait for recovery  
            + "}"  
                );
        createIndex.setJsonEntity(body);
        if (expected instanceof Number && actual instanceof Number) {
        assertNotNull("Response missing 'rows' for: " + ppl, rows);
    public void testQueryResultsIdenticalAfterForceMergeAndRestart() throws IOException {
            assertEquals(message, expected, actual);
        assertEquals(200, openResponse.getStatusLine().getStatusCode());
            StringBuilder bulk = new StringBuilder();
        }  
                assertCellEquals(
        Response closeResponse = client().performRequest(new Request("POST", "/" + indexName + "/_close"));
            for (int i = 0; i < docsPerBatch; i++) {
                afterRows.get(i).size()
        bulk.append("{\"index\": {}}\n{\"name\": \"bob\", \"age\": 25, \"score\": 88.0}\n");
            + "    \"score\": { \"type\": \"double\" }"
                    "Mismatch at row " + i + " col " + j,
                bulk.append("{\"name\": \"user_")
     * catalog snapshots are correctly restored on engine startup.  
    private static void assertCellEquals(String message, Object expected, Object actual) {
        String ppl = "source=" + INDEX_NAME + " | sort age | fields name, age, score";  
                assertCellEquals(
            + "    \"age\": { \"type\": \"integer\" },"  
        healthRequest.addParameter("timeout", "30s");
        client().performRequest(healthRequest);
        assertEquals(200, closeResponse.getStatusLine().getStatusCode());  
import java.util.Map;  
        client().performRequest(healthRequest);  
                    .append("}\n");
        healthRequest = new Request("GET", "/_cluster/health/" + indexName);
        Request healthRequest = new Request("GET", "/_cluster/health/" + indexName);  
            + "  \"index.pluggable.dataformat.enabled\": true,"
 *
    }
 * this file be licensed under the Apache-2.0 license or a
    private List<List<Object>> executePplRows(String ppl) throws IOException {  
        int totalDocs = numBatches * docsPerBatch;
            assertEquals("Bulk batch " + batch + " must have no errors", false, bulkResponse.get("errors"));  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.Response;
        // Delete if exists from a previous run
        healthRequest.addParameter("wait_for_status", "green");
        flushRequest.addParameter("force", "true");
            return;
        // Delete if exists from a previous run
        // Reopen the index — engine starts up with local recovery from committed data
        Request forceMergeRequest = new Request("POST", "/" + indexName + "/_forcemerge");
            // index may not exist
            + "    \"age\": { \"type\": \"integer\" },"  
            }  
                );
        Map<String, Object> createResponse = assertOkAndParse(client().performRequest(createIndex), "Create index");
            + "}";
 * compatible open source license.
            + "  \"number_of_shards\": 1,"
            + "    \"score\": { \"type\": \"double\" }"
        }
            Request flushRequest = new Request("POST", "/" + indexName + "/_flush");  
        bulk.append("{\"index\": {}}\n{\"name\": \"alice\", \"age\": 30, \"score\": 95.5}\n");
            bulkRequest.setOptions(
 */  
            return;
            + "\"settings\": {"
                    .append("\", \"age\": ")  
                    afterRows.get(i).get(j)
        // Query after restart — must return identical results  
        // Create index with parquet primary + lucene secondary
        client().performRequest(healthRequest);  
        assertEquals(200, closeResponse.getStatusLine().getStatusCode());  
    }
    // ── helpers ─────────────────────────────────────────────────────────────────
            flushRequest.addParameter("force", "true");
            }  
 * <p>Uses a composite index with parquet primary + lucene secondary to validate  
    }
            + "  \"index.composite.primary_data_format\": \"parquet\","  
            Map<String, Object> bulkResponse = assertOkAndParse(client().performRequest(bulkRequest), "Bulk batch " + batch);
                    beforeRows.get(i).get(j),  
        client().performRequest(flushRequest);
        String indexName = "local_recovery_forcemerge_test";
        }
        Request healthRequest = new Request("GET", "/_cluster/health/" + INDEX_NAME);  
            double e = ((Number) expected).doubleValue();
        bulkRequest.setJsonEntity(bulk.toString());
        assertEquals("Should have " + totalDocs + " rows before restart", totalDocs, beforeRows.size());
            );
                "Row " + i + " must be identical after restart: before=" + beforeRows.get(i) + " after=" + afterRows.get(i),
                bulk.append("{\"index\": {}}\n");  
            + "}"  
        List<List<Object>> beforeRows = executePplRows(ppl);
            bulkRequest.setJsonEntity(bulk.toString());  
        createIndex.setJsonEntity(body);
        assertEquals("Index creation must be acknowledged", true, createResponse.get("acknowledged"));  
 * recovery across both format engines.
        Request request = new Request("POST", "/_plugins/_ppl");
                    "Mismatch at row " + i + " col " + j,
    public void testQueryResultsIdenticalAfterEngineRestart() throws IOException {
    private static boolean indexProvisioned = false;  
        // Query before restart: sort by age ascending
        }
            );
        Request healthRequest = new Request("GET", "/_cluster/health/" + INDEX_NAME);
        // Bulk index documents
 * Integration test for local recovery of the DataFormatAwareEngine via index close/reopen.  
        client().performRequest(forceMergeRequest);
            + "  \"number_of_replicas\": 0,"  
            + "  \"index.pluggable.dataformat.enabled\": true,"
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
            + "\"settings\": {"
        // Wait for green
    }
            assertEquals(
            + "  \"number_of_shards\": 1,"
        Response openResponse = client().performRequest(new Request("POST", "/" + indexName + "/_open"));  
        for (int i = 0; i < beforeRows.size(); i++) {  
        List<List<Object>> rows = (List<List<Object>>) parsed.get("datarows");  
            + "},"
        assertEquals(200, openResponse.getStatusLine().getStatusCode());
            + "  \"index.pluggable.dataformat\": \"composite\","
    private void ensureIndexProvisioned() throws IOException {
            + "  }"
                    beforeRows.get(i).get(j),  
}
        healthRequest.addParameter("timeout", "60s");  
            + "    \"name\": { \"type\": \"keyword\" },"
        try {
        }  
        }
                    afterRows.get(i).get(j)
            return;
        forceMergeRequest.addParameter("max_num_segments", "1");  
        bulkRequest.addParameter("refresh", "true");  
        ensureIndexProvisioned();  
            + "\"mappings\": {"  
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
            client().performRequest(flushRequest);
        Request createIndex = new Request("PUT", "/" + indexName);  
                    .append(50.0 + (docId % 50))  
                beforeRows.get(i).size(),  
        }  
                    .append(20 + (docId % 40))
        int docsPerBatch = 10;
        Response openResponse = client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_open"));  
        List<List<Object>> beforeRows = executePplRows(ppl);
        // Wait for recovery  
        String ppl = "source=" + indexName + " | sort age, name | fields name, age, score";  
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
        // Reopen the index — engine starts up with local recovery from committed data
            }  
            + "},"
        healthRequest.addParameter("wait_for_status", "green");
        // Create index with parquet primary + lucene secondary
                    .append(", \"score\": ")
import org.opensearch.client.Request;
            + "    \"name\": { \"type\": \"keyword\" },"
        Request flushRequest = new Request("POST", "/" + indexName + "/_flush");
            + "  \"properties\": {"
        Map<String, Object> createResponse = assertOkAndParse(client().performRequest(createIndex), "Create index");
        return rows;
        if (expected == null || actual == null) {  
            + "  \"number_of_replicas\": 0,"  
        assertEquals("Bulk must have no errors", false, bulkResponse.get("errors"));
        // Force merge to a single segment
                bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build()  
        String body = "{"  
            + "  \"properties\": {"
    /**  
        client().performRequest(flushRequest);  
 * committed snapshots on engine startup, ensuring search queries work immediately  
        // Wait for green
            // index may not exist
        healthRequest.addParameter("wait_for_status", "green");
     * Provisions data, queries it, restarts the engine (close/reopen), then re-queries
        bulk.append("{\"index\": {}}\n{\"name\": \"dave\", \"age\": 28, \"score\": 76.8}\n");
        @SuppressWarnings("unchecked")
 * The OpenSearch Contributors require contributions made to  
/**
        Response response = client().performRequest(request);  
        // Flush to commit data to disk
        bulk.append("{\"index\": {}}\n{\"name\": \"carol\", \"age\": 35, \"score\": 92.3}\n");  
        // Flush after force merge to persist the merged state  
 * <p>Exercises the CatalogSnapshotManager fix that notifies reader managers about
            double a = ((Number) actual).doubleValue();  
        // Close the index — engine shuts down
            Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
            bulkRequest.addParameter("refresh", "true");
import java.util.List;
        if (indexProvisioned) {  
