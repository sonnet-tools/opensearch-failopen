                .append("}\n");
                .append(", \"count\": ").append(i % 50)
        ingestData();
import java.io.IOException;
            assertEquals(
    public void testPoolLimitExhausted_multiShard_returns429() throws Exception {
        ingestData();
            + "  \"index.composite.primary_data_format\": \"parquet\","
        }
                "Response body should mention CircuitBreakingException, got: " + body,
                () -> executePpl("source = " + INDEX + " | stats count() by url")
    private void createIndex() throws Exception {
            + "}"
            resetPoolLimit();
                ResponseException.class,
        assertEquals(200, response.getStatusLine().getStatusCode());
    // ── Index setup ────────────────────────────────────────────────────────
        Response response = client().performRequest(req);
 * this file be licensed under the Apache-2.0 license or a
        createIndex();
            );
                ResponseException.class,
    public void testPoolLimitExhausted_returns429() throws Exception {
 * The OpenSearch Contributors require contributions made to
        try {
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats count() by url");
    private static final String INDEX = "mem_guard_rest_it";
 *
        }
            );
        req.setJsonEntity(ndjson.toString());
        setPoolLimit(1L);
    private void createIndex(int numberOfShards) throws Exception {
 * → Flight transport → coordinator reconstruction → REST response.
        try {
 * <p>Run with:
                statusCode
                statusCode
        req.setJsonEntity("{\"transient\":{\"datafusion.memory_pool_limit_bytes\": " + bytes + "}}");
    public void testPoolLimitExhausted_responseContainsCircuitBreakingException() throws Exception {
                "Expected HTTP 429 for multi-shard pool-limit exhaustion, got " + statusCode + ": " + ex.getMessage(),
import org.apache.hc.core5.http.ParseException;
        } finally {
                "Expected HTTP 429 for pool-limit exhaustion, got " + statusCode + ": " + ex.getMessage(),
import java.util.Map;
        Request req = new Request("PUT", "/_cluster/settings");
    }
                429,
 *
package org.opensearch.analytics.qa;
    }
        } finally {
        } finally {
            ResponseException ex = expectThrows(
        } finally {
            );
            ndjson.append("{\"user_id\": ").append(i)
                429,
                () -> executePpl("source = " + INDEX + " | stats count() by url")
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Create index");
    // ── Cluster settings helpers ───────────────────────────────────────────
            resetPoolLimit();
 * REST integration test verifying that native memory errors return HTTP 429 (Too Many Requests)
        req.setJsonEntity("{\"transient\":{\"datafusion.memory_pool_limit_bytes\": null}}");
            + "},"
        health.addParameter("wait_for_status", "green");
                body.contains("CircuitBreakingException")
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
            assertEquals(
        client().performRequest(health);
            String body = entityAsString(ex.getResponse());
    }
 * SPDX-License-Identifier: Apache-2.0
                ResponseException.class,
            ResponseException ex = expectThrows(
    private void setPoolLimit(long bytes) throws IOException {
        client().performRequest(req);
            + "\"settings\": {"
            );
        assertNotNull("Query should succeed after pool limit reset", result.get("datarows"));
        for (int i = 0; i < 100; i++) {
        createIndex();
        try {
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
        return org.apache.hc.core5.http.io.entity.EntityUtils.toString(response.getEntity());
            + "  \"number_of_shards\": " + numberOfShards + ","
        createIndex();
            resetPoolLimit();
        assertEquals("Bulk indexing should have no errors", false, response.get("errors"));
        }
        createIndex(1);
        req.setJsonEntity(body);
        setPoolLimit(1L);
public class MemoryGuardRestIT extends AnalyticsRestTestCase {
        Request req = new Request("POST", "/" + INDEX + "/_bulk");
            assertTrue(
    public void testNormalQuery_succeedsAfterPoolReset() throws Exception {
            + "  \"number_of_replicas\": 0,"
    }
            int statusCode = ex.getResponse().getStatusLine().getStatusCode();
        try {
                () -> executePpl("source = " + INDEX + " | stats count() by url")
import org.opensearch.client.Request;
            + "    \"count\": { \"type\": \"integer\" }"
            + "  }"
            + "  \"properties\": {"
        Request req = new Request("PUT", "/" + INDEX);
            int statusCode = ex.getResponse().getStatusLine().getStatusCode();
        try {
 * compatible open source license.
        setPoolLimit(1L);
            + "    \"user_id\": { \"type\": \"long\" },"
    }
            );
    private static String entityAsString(Response response) throws IOException, ParseException {
        } catch (Exception ignored) {}
    }
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
 * {@code ./gradlew :sandbox:qa:analytics-engine-rest:integTest --tests "*.MemoryGuardRestIT" -Dsandbox.enabled=true}
/*
            expectThrows(
            + "    \"url\": { \"type\": \"keyword\" },"
 */
                () -> executePpl("source = " + INDEX + " | stats count() by url")
            resetPoolLimit();
        assertEquals(true, response.get("acknowledged"));
            + "  \"index.pluggable.dataformat\": \"composite\","
        ingestData();
    }
            ResponseException ex = expectThrows(
        }
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk index");
        req.addParameter("refresh", "true");
                ResponseException.class,
    }
        health.addParameter("timeout", "30s");
import org.opensearch.client.Response;
            + "  \"index.pluggable.dataformat.enabled\": true,"
            + "}";
        setPoolLimit(1L);
 */
    private void resetPoolLimit() throws IOException {
        createIndex(3);
            );
            client().performRequest(new Request("DELETE", "/" + INDEX));
}
import org.opensearch.client.ResponseException;
        }
            ndjson.append("{\"index\": {}}\n");
    }
                .append(", \"url\": \"https://example.com/page-").append(i % 20).append("\"")
    private void ingestData() throws Exception {
/**
        Request req = new Request("PUT", "/_cluster/settings");
    }
        ingestData();
            + "\"mappings\": {"
        String body = "{"
 * rather than HTTP 500. Exercises the full path: Rust error → FFM boundary → NativeErrorConverter
            );
        StringBuilder ndjson = new StringBuilder();
