            Request flushRequest = new Request("POST", "/" + indexName + "/_flush");
                    .append(20 + (docId % 40))
        assertEquals("Index creation must be acknowledged", true, createResponse.get("acknowledged"));
        client().performRequest(forceMergeRequest);
 */
        // Create index with parquet primary + lucene secondary
        StringBuilder bulk = new StringBuilder();
        assertEquals(200, closeResponse.getStatusLine().getStatusCode());
            + "    \"age\": { \"type\": \"integer\" },"
        }
            client().performRequest(new Request("DELETE", "/" + INDEX_NAME));
        createIndex.setJsonEntity(body);
            assertEquals(
    private static final String INDEX_NAME = "local_recovery_test";
            );
            + "  }"
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        bulk.append("{\"index\": {}}\n{\"name\": \"carol\", \"age\": 35, \"score\": 92.3}\n");
    private static boolean indexProvisioned = false;
        Map<String, Object> createResponse = assertOkAndParse(client().performRequest(createIndex), "Create index");
            + "  \"number_of_shards\": 1,"
 */
        // Flush after force merge to persist the merged state
            + "\"settings\": {"
 * <p>Uses a composite index with parquet primary + lucene secondary to validate
        // Wait for recovery
        for (int i = 0; i < beforeRows.size(); i++) {
        // Bulk index documents
        healthRequest.addParameter("timeout", "60s");
                "Row " + i + " must be identical after restart: before=" + beforeRows.get(i) + " after=" + afterRows.get(i),
                assertCellEquals(
package org.opensearch.analytics.qa;
        bulk.append("{\"index\": {}}\n{\"name\": \"dave\", \"age\": 28, \"score\": 76.8}\n");
            }
     * catalog snapshots are correctly restored on engine startup.
public class LocalRecoveryIT extends AnalyticsRestTestCase {
        indexProvisioned = true;
        int totalDocs = numBatches * docsPerBatch;
        try {
}
        assertEquals("Row count must match after restart", beforeRows.size(), afterRows.size());
            // index may not exist
            for (int j = 0; j < beforeRows.get(i).size(); j++) {
        // Wait for green
    /**
        // Query after restart — must return identical results
                    afterRows.get(i).get(j)
                    beforeRows.get(i).get(j),
        Response response = client().performRequest(request);
            );
            // index may not exist
/*
            StringBuilder bulk = new StringBuilder();
                );
                    "Mismatch at row " + i + " col " + j,
            client().performRequest(flushRequest);
            + "}"
        }
            if (Double.compare(e, a) != 0) {
        } catch (Exception e) {
    public void testQueryResultsIdenticalAfterForceMergeAndRestart() throws IOException {
        // Close the index — engine shuts down
        } catch (Exception e) {
        }
        assertEquals(message, expected, actual);
            + "    \"age\": { \"type\": \"integer\" },"
import java.io.IOException;
        Map<String, Object> createResponse = assertOkAndParse(client().performRequest(createIndex), "Create index");
                "Row " + i + " must be identical after restart: before=" + beforeRows.get(i) + " after=" + afterRows.get(i),
        healthRequest.addParameter("wait_for_status", "green");
        // Wait for recovery
        assertEquals(200, openResponse.getStatusLine().getStatusCode());
            + "    \"score\": { \"type\": \"double\" }"
            }
        client().performRequest(healthRequest);
        bulk.append("{\"index\": {}}\n{\"name\": \"alice\", \"age\": 30, \"score\": 95.5}\n");
            + "    \"name\": { \"type\": \"keyword\" },"
    // ── helpers ─────────────────────────────────────────────────────────────────
            );
        if (expected == null || actual == null) {
            bulkRequest.setOptions(
        assertEquals("Should have 5 rows before restart", 5, beforeRows.size());
        Request createIndex = new Request("PUT", "/" + INDEX_NAME);
                docId++;
        String body = "{"
            + "\"mappings\": {"
    }
    private void ensureIndexProvisioned() throws IOException {
        flushRequest.addParameter("force", "true");
        // Close the index — engine shuts down
                afterRows.get(i).size()
 * SPDX-License-Identifier: Apache-2.0
                assertCellEquals(
        List<List<Object>> rows = (List<List<Object>>) parsed.get("datarows");
            + "  \"index.pluggable.dataformat\": \"composite\","
        // Create index with parquet primary + lucene secondary
            + "}"
            + "},"
            + "  \"index.pluggable.dataformat\": \"composite\","
        }
                    .append("\", \"age\": ")
        Response closeResponse = client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_close"));
        if (indexProvisioned) {
 * after a restart without requiring a translog replay or explicit refresh.
        healthRequest.addParameter("wait_for_status", "green");
            Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
                    "Mismatch at row " + i + " col " + j,
        assertEquals("Index creation must be acknowledged", true, createResponse.get("acknowledged"));
            double a = ((Number) actual).doubleValue();
        int docsPerBatch = 10;
            + "\"settings\": {"
    private static void assertCellEquals(String message, Object expected, Object actual) {
        Response closeResponse = client().performRequest(new Request("POST", "/" + indexName + "/_close"));
 * compatible open source license.
        // Reopen the index — engine starts up with local recovery from committed data
        List<List<Object>> beforeRows = executePplRows(ppl);
        bulkRequest.addParameter("refresh", "true");
        Request createIndex = new Request("PUT", "/" + indexName);
        assertEquals("Bulk must have no errors", false, bulkResponse.get("errors"));
            + "  \"index.pluggable.dataformat.enabled\": true,"
        }
        healthRequest.addParameter("wait_for_status", "green");
        // Wait for green
            + "\"mappings\": {"
            assertEquals(
        // Query after restart — must return identical results
 *
            + "  \"index.composite.primary_data_format\": \"parquet\","
        Map<String, Object> bulkResponse = assertOkAndParse(client().performRequest(bulkRequest), "Bulk index");
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
        healthRequest.addParameter("wait_for_status", "green");
        String body = "{"
        try {
            client().performRequest(new Request("DELETE", "/" + indexName));
        Request healthRequest = new Request("GET", "/_cluster/health/" + INDEX_NAME);
        client().performRequest(healthRequest);
        client().performRequest(flushRequest);
        String indexName = "local_recovery_forcemerge_test";
        return rows;
            Map<String, Object> bulkResponse = assertOkAndParse(client().performRequest(bulkRequest), "Bulk batch " + batch);
    }
        bulkRequest.setJsonEntity(bulk.toString());
            bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build()
        Request flushRequest = new Request("POST", "/" + INDEX_NAME + "/_flush");
    public void testQueryResultsIdenticalAfterEngineRestart() throws IOException {
 * <p>Exercises the CatalogSnapshotManager fix that notifies reader managers about
            + "  \"number_of_replicas\": 0,"
        String ppl = "source=" + indexName + " | sort age, name | fields name, age, score";
            double e = ((Number) expected).doubleValue();
        assertEquals(200, openResponse.getStatusLine().getStatusCode());
            for (int j = 0; j < beforeRows.get(i).size(); j++) {
                bulk.append("{\"index\": {}}\n");
        Request healthRequest = new Request("GET", "/_cluster/health/" + INDEX_NAME);
        // Ingest documents in multiple batches with flush between each to create multiple segments
        assertEquals(200, closeResponse.getStatusLine().getStatusCode());
                    .append(", \"score\": ")
        healthRequest.addParameter("timeout", "30s");
        healthRequest = new Request("GET", "/_cluster/health/" + indexName);
            for (int i = 0; i < docsPerBatch; i++) {
    }
        // Delete if exists from a previous run
    }
 * recovery across both format engines.
        // Reopen the index — engine starts up with local recovery from committed data
            }
            flushRequest.addParameter("force", "true");
            bulkRequest.addParameter("refresh", "true");
            + "  }"
                    beforeRows.get(i).get(j),
    private List<List<Object>> executePplRows(String ppl) throws IOException {
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
                    .append(docId)
        bulk.append("{\"index\": {}}\n{\"name\": \"eve\", \"age\": 32, \"score\": 91.0}\n");
        Request healthRequest = new Request("GET", "/_cluster/health/" + indexName);
    }
            + "  \"number_of_replicas\": 0,"
            bulkRequest.setJsonEntity(bulk.toString());
        }
     */
        Map<String, Object> parsed = assertOkAndParse(response, "PPL: " + ppl);
            + "}";
 *
                bulk.append("{\"name\": \"user_")
            return;
                beforeRows.get(i).size(),
        healthRequest.addParameter("timeout", "60s");
 *
import org.opensearch.client.Request;
 * committed snapshots on engine startup, ensuring search queries work immediately
 * The OpenSearch Contributors require contributions made to
     * and asserts the results are identical. This is the core validation that committed
        forceMergeRequest.addParameter("max_num_segments", "1");
import java.util.Map;
            + "    \"score\": { \"type\": \"double\" }"
        assertEquals("Row count must match after restart", beforeRows.size(), afterRows.size());
            + "  \"properties\": {"
        String ppl = "source=" + INDEX_NAME + " | sort age | fields name, age, score";
        for (int batch = 0; batch < numBatches; batch++) {
        assertNotNull("Response missing 'rows' for: " + ppl, rows);
        ensureIndexProvisioned();
        List<List<Object>> afterRows = executePplRows(ppl);
 * Integration test for local recovery of the DataFormatAwareEngine via index close/reopen.
        for (int i = 0; i < beforeRows.size(); i++) {
                    .append(50.0 + (docId % 50))
            assertEquals(message, expected, actual);
        createIndex.setJsonEntity(body);
                );
        Response openResponse = client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_open"));
        int numBatches = 5;
            assertEquals("Bulk batch " + batch + " must have no errors", false, bulkResponse.get("errors"));
        client().performRequest(healthRequest);
import java.util.List;
        // Delete if exists from a previous run
        Request flushRequest = new Request("POST", "/" + indexName + "/_flush");
            + "  \"index.composite.primary_data_format\": \"parquet\","
import org.opensearch.client.Response;
/**
        assertEquals("Should have " + totalDocs + " rows before restart", totalDocs, beforeRows.size());
        bulk.append("{\"index\": {}}\n{\"name\": \"bob\", \"age\": 25, \"score\": 88.0}\n");
            // Flush after each batch to create separate segments
        List<List<Object>> afterRows = executePplRows(ppl);
 * this file be licensed under the Apache-2.0 license or a
            + "  \"number_of_shards\": 1,"
        }
        client().performRequest(healthRequest);
        bulkRequest.setOptions(
        client().performRequest(flushRequest);
        Request request = new Request("POST", "/_plugins/_ppl");
        Request bulkRequest = new Request("POST", "/" + INDEX_NAME + "/_bulk");
     * Provisions data, queries it, restarts the engine (close/reopen), then re-queries
                bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build()
        Request forceMergeRequest = new Request("POST", "/" + indexName + "/_forcemerge");
        // Query before restart
                beforeRows.get(i).size(),
            + "},"
            + "  \"properties\": {"
        if (expected instanceof Number && actual instanceof Number) {
                    .append("}\n");
            + "  \"index.pluggable.dataformat.enabled\": true,"
                afterRows.get(i).size()
        // Query before restart: sort by age ascending
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
        // Force merge to a single segment
        flushRequest.addParameter("force", "true");
        int docId = 1;
                    afterRows.get(i).get(j)
        // Flush to commit data to disk
            + "    \"name\": { \"type\": \"keyword\" },"
            return;
        healthRequest.addParameter("timeout", "30s");
        );
        }
        Response openResponse = client().performRequest(new Request("POST", "/" + indexName + "/_open"));
            + "}";
            return;
            }
        List<List<Object>> beforeRows = executePplRows(ppl);
        @SuppressWarnings("unchecked")
