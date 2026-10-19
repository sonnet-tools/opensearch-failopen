        bulk.setJsonEntity(
            int status = e.getResponse().getStatusLine().getStatusCode();
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(  
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
        }
                body.contains("too deeply nested") || body.contains("nesting depth")
        indexData();
        flush.addParameter("force", "true");
 * Substrait plan has 31+ nested ScalarFunction calls (each adds ~3 protobuf nesting levels).
        health.addParameter("wait_for_status", "yellow");
                status == 400
                + "{\"index\":{}}\n{\"value\":8.2}\n"
        // 50 nested calls should fail with 400 (not 500)  
            + "  }"
                + "{\"index\":{}}\n{\"value\":1.5}\n"
            assertTrue(
 * Integration test verifying that deeply nested PPL expressions return a 400 error  
 * <p>Reproduces: https://github.com/opensearch-project/OpenSearch/issues/XXXXX  
            + "},"
    private void indexData() throws Exception {
        Request flush = new Request("POST", "/" + INDEX + "/_flush");  
        try {
    public void testDeeplyNestedQueryReturns400() throws Exception {
 * The OpenSearch Contributors require contributions made to  
            String body = new String(e.getResponse().getEntity().getContent().readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
        createIndex();  
            + "  \"properties\": {"  
        client().performRequest(bulk);
import org.opensearch.client.Request;
        } catch (ResponseException e) {  
        );  
}  
        sb.append("value");
        Request create = new Request("PUT", "/" + INDEX);
        } catch (Exception ignored) {}
 *
 * compatible open source license.
            fail("Expected 400 error for deeply nested query");  
            );  
            sb.append(i % 2 == 0 ? "ceil(" : "floor(");  
    }
import org.opensearch.client.ResponseException;  
            + "\"mappings\": {"
            + "  \"index.pluggable.dataformat.enabled\": true,"  
        try {
        return sb.toString();  
public class NestedQueryRecursionLimitIT extends AnalyticsRestTestCase {
            + "  \"index.number_of_replicas\": 0,"
/**
        }  
        } catch (ResponseException e) {
    private String buildNestedExpr(int depth) {  
    private void createIndex() throws Exception {  
 *
        for (int i = 0; i < depth; i++) {
            + "  \"index.pluggable.dataformat\": \"composite\","
                "Expected 400 but got " + status + ": " + e.getMessage(),
            client().performRequest(badRequest);
    }
        bulk.addParameter("refresh", "true");
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
            sb.append(")");
package org.opensearch.analytics.qa;
        Request bulk = new Request("POST", "/" + INDEX + "/_bulk");  
    }
            + "    \"value\": {\"type\": \"double\"}"
        create.setJsonEntity("{"
 * Root cause: prost protobuf decoder recursion limit (default 100) is exceeded when
 * with a meaningful message instead of a 500 internal server error.
        Request badRequest = new Request("POST", "/_analytics/ppl");
            client().performRequest(new Request("DELETE", "/" + INDEX));
        for (int i = 0; i < depth; i++) {  
        String deep = buildNestedExpr(50);
                "Error should mention nesting depth, got: " + body,  
            + "\"settings\": {"  
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"  
            "{\"index\":{}}\n{\"value\":3.7}\n"  
    }  
            );
        health.addParameter("timeout", "30s");  
        client().performRequest(health);
            + "  \"index.number_of_shards\": 1,"
    private static final String INDEX = "nested_recursion_test";  
        client().performRequest(create);
            + "}"  
            if (e.getResponse().getStatusLine().getStatusCode() != 404) throw e;
 */  
        }
        badRequest.setJsonEntity("{\"query\": \"source=" + INDEX + " | eval result = " + deep + "\"}");  
        StringBuilder sb = new StringBuilder();
        client().performRequest(flush);
            + "  \"index.composite.primary_data_format\": \"parquet\","
            + "}");
import org.opensearch.client.Response;
