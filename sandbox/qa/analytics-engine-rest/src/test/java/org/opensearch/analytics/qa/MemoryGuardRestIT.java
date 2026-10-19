                .append(", \"count\": ").append(i % 50)
            ndjson.append("{\"index\": {}}\n");
            resetPoolLimit();
 *
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats count() by url");
        req.setJsonEntity("{\"transient\":{\"datafusion.memory_pool_limit_bytes\": null}}");
        try {  
 *
            int statusCode = ex.getResponse().getStatusLine().getStatusCode();
            resetPoolLimit();  
        client().performRequest(req);  
            + "  \"index.pluggable.dataformat\": \"composite\","
        ingestData();
                "Expected HTTP 429 for pool-limit exhaustion, got " + statusCode + ": " + ex.getMessage(),
            client().performRequest(new Request("DELETE", "/" + INDEX));  
        }
    }
}
/*  
 * SPDX-License-Identifier: Apache-2.0
                () -> executePpl("source = " + INDEX + " | stats count() by url")
        createIndex(1);
        } finally {
        Request req = new Request("PUT", "/" + INDEX);  
            + "  \"number_of_replicas\": 0,"  
        try {
            + "\"settings\": {"
        req.setJsonEntity(body);
    private void setPoolLimit(long bytes) throws IOException {
/**
        health.addParameter("wait_for_status", "green");  
    }
            expectThrows(  
                () -> executePpl("source = " + INDEX + " | stats count() by url")  
    }
    }  
        client().performRequest(health);
 * {@code ./gradlew :sandbox:qa:analytics-engine-rest:integTest --tests "*.MemoryGuardRestIT" -Dsandbox.enabled=true}
        Request req = new Request("PUT", "/_cluster/settings");  
        ingestData();  
            assertTrue(  
    }
 * this file be licensed under the Apache-2.0 license or a
            ResponseException ex = expectThrows(
    public void testPoolLimitExhausted_responseContainsCircuitBreakingException() throws Exception {
 * rather than HTTP 500. Exercises the full path: Rust error → FFM boundary → NativeErrorConverter  
 * <p>Run with:  
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Create index");
    }
            + "    \"user_id\": { \"type\": \"long\" },"
    private void createIndex() throws Exception {  
package org.opensearch.analytics.qa;
                "Response body should mention CircuitBreakingException, got: " + body,
        Response response = client().performRequest(req);
        } finally {
            );  
            String body = entityAsString(ex.getResponse());
            + "  \"properties\": {"
        }
            resetPoolLimit();
        Request req = new Request("POST", "/" + INDEX + "/_bulk");  
            ResponseException ex = expectThrows(
    private static final String INDEX = "mem_guard_rest_it";
            int statusCode = ex.getResponse().getStatusLine().getStatusCode();
    }
    }
            ResponseException ex = expectThrows(  
 * → Flight transport → coordinator reconstruction → REST response.
 * compatible open source license.
        } finally {
        try {
        ingestData();
            + "  }"
    private void createIndex(int numberOfShards) throws Exception {
        req.setJsonEntity("{\"transient\":{\"datafusion.memory_pool_limit_bytes\": " + bytes + "}}");
    // ── Cluster settings helpers ───────────────────────────────────────────  
        } finally {
            + "}"  
        setPoolLimit(1L);
        try {
            );
 * REST integration test verifying that native memory errors return HTTP 429 (Too Many Requests)
        assertEquals(200, response.getStatusLine().getStatusCode());  
        createIndex();
        createIndex();
            + "  \"index.composite.primary_data_format\": \"parquet\","  
import java.io.IOException;
        }  
                statusCode
                () -> executePpl("source = " + INDEX + " | stats count() by url")  
            assertEquals(  
            );  
        setPoolLimit(1L);
        assertNotNull("Query should succeed after pool limit reset", result.get("datarows"));  
public class MemoryGuardRestIT extends AnalyticsRestTestCase {  
 */  
            + "\"mappings\": {"  
    private void ingestData() throws Exception {
        Request req = new Request("PUT", "/_cluster/settings");
    private void resetPoolLimit() throws IOException {  
import org.opensearch.client.Request;
        String body = "{"  
                ResponseException.class,
    public void testNormalQuery_succeedsAfterPoolReset() throws Exception {  
            + "    \"url\": { \"type\": \"keyword\" },"  
        for (int i = 0; i < 100; i++) {
                429,
        setPoolLimit(1L);
 */
                statusCode  
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
                ResponseException.class,
            assertEquals(
                body.contains("CircuitBreakingException")
        } catch (Exception ignored) {}
import java.util.Map;
                ResponseException.class,
    }  
import org.opensearch.client.ResponseException;  
        assertEquals(true, response.get("acknowledged"));  
                () -> executePpl("source = " + INDEX + " | stats count() by url")
        createIndex(3);
            );
        setPoolLimit(1L);
            );
    }
    // ── Index setup ────────────────────────────────────────────────────────
        try {  
            + "  \"number_of_shards\": " + numberOfShards + ","
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
import org.apache.hc.core5.http.ParseException;
        assertEquals("Bulk indexing should have no errors", false, response.get("errors"));
        }  
        }  
            + "    \"count\": { \"type\": \"integer\" }"
                .append("}\n");  
        health.addParameter("timeout", "30s");
    private static String entityAsString(Response response) throws IOException, ParseException {  
            + "}";
        StringBuilder ndjson = new StringBuilder();  
import org.opensearch.client.Response;
        createIndex();
    public void testPoolLimitExhausted_returns429() throws Exception {
                429,
            + "},"
            );  
    public void testPoolLimitExhausted_multiShard_returns429() throws Exception {  
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk index");
            ndjson.append("{\"user_id\": ").append(i)  
        ingestData();  
            + "  \"index.pluggable.dataformat.enabled\": true,"
        req.addParameter("refresh", "true");
                ResponseException.class,
                .append(", \"url\": \"https://example.com/page-").append(i % 20).append("\"")
            resetPoolLimit();
            );  
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());  
        req.setJsonEntity(ndjson.toString());
        return org.apache.hc.core5.http.io.entity.EntityUtils.toString(response.getEntity());
                "Expected HTTP 429 for multi-shard pool-limit exhaustion, got " + statusCode + ": " + ex.getMessage(),  
