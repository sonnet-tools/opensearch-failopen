        final Map<String, Object> storedBody = entityAsMap(storedResponse);
        final String index = "bulk-pressure";
        assertEquals(Boolean.TRUE, entityAsMap(createResponse).get("acknowledged"));
import static org.opensearch.core.rest.RestStatus.OK;
    public void testSingleDocumentShardPressureRejectionReturnsTooManyRequests() throws Exception {
    }
    private void setShardPressureEnabled(Boolean enabled) throws IOException {
                + successfulSource
        assertEquals(Boolean.TRUE, storedBody.get("found"));
            assertEquals(TOO_MANY_REQUESTS.getStatus(), item.get("status"));
        assertEquals(OK.getStatus(), storedResponse.getStatusLine().getStatusCode());
        ensureGreen(index);
        assertDocumentMissing(index, "rejected-single");
            final Map<String, Object> item = (Map<String, Object>) rejectedItems.get(i).get("index");
        final Request createIndex = new Request("PUT", "/" + index);
                + "\n"
        assertEquals("accepted", successfulItem.get("_id"));
        assertEquals("rejected", rejectedItem.get("_id"));
        final Map<String, Object> body = entityAsMap(response);
            rejectedNodeBulk.setJsonEntity("{\"index\":{\"_id\":\"rejected-node\"}}\n" + OVERSIZED_SOURCE + "\n");
                + OVERSIZED_SOURCE
        // The rejection must release its accounting so a later request on the same shard is admitted.
import org.opensearch.client.Request;
        final String rejectedIndex = "bulk-pressure-rejected";
                + "\n{\"index\":{\"_id\":\"rejected-2\"}}\n"
    }
    }
            assertEquals("rejected_execution_exception", error.get("type"));
        final List<Map<String, Object>> successfulItems = (List<Map<String, Object>>) successfulBody.get("items");
    private void assertDocumentMissing(String index, String id) throws IOException {
    // A single document exceeds the node limit, so rejection does not depend on concurrent indexing or timing.
        assertEquals(Boolean.TRUE, storedBody.get("found"));
import org.opensearch.index.ShardIndexingPressureSettings;
        final Request request = new Request("PUT", "/_cluster/settings");
        final Request successfulBulk = new Request("POST", "/" + index + "/_bulk");
        final Request request = new Request("GET", "/" + index + "/_doc/" + id);
        final List<Map<String, Object>> items = (List<Map<String, Object>>) body.get("items");
    @SuppressWarnings("unchecked")
}
        final Map<String, Object> body = entityAsMap(response);
            .put(super.nodeSettings(nodeOrdinal))
        createSingleShardIndex(index);
        final Map<String, Object> storedBody = entityAsMap(storedResponse);
        final ResponseException exception = expectThrows(ResponseException.class, () -> getRestClient().performRequest(request));
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;
        final Response rejectedResponse = getRestClient().performRequest(rejectedBulk);
        assertEquals(Boolean.TRUE, body.get("errors"));
            "{\"index\":{\"_id\":\"accepted\"}}\n{\"message\":\"small bulk request after rejection\",\"sequence\":42}\n"
            setShardPressureEnabled(null);
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        final String index = "bulk-pressure";
    }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
    }
import org.opensearch.common.settings.Settings;
            setShardPressureEnabled(false);
            "{\"index\":{\"_index\":\""
    private void assertRequestRejected(Request request) throws IOException {
        assertEquals(Map.of("message", "small bulk request after rejection", "sequence", 42), storedBody.get("_source"));
        assertEquals(NOT_FOUND.getStatus(), response.getStatusLine().getStatusCode());
        final Response rejectedResponse = getRestClient().performRequest(rejectedBulk);
    public void testNodePressureRejectionReturnsTooManyRequestsWhenShardPressureDisabled() throws Exception {
        // The single-document API must still unwrap its one failed bulk item into an HTTP-level rejection.
            final Map<String, Object> error = (Map<String, Object>) item.get("error");
        final Response response = exception.getResponse();
        final Request rejectedBulk = new Request("POST", "/" + index + "/_bulk");
        assertEquals("rejected_execution_exception", error.get("type"));
        final Response response = exception.getResponse();
                + "\n"
    @Override
        createSingleShardIndex(index);
            assertEquals("rejected-" + (i + 1), item.get("_id"));
                + "\",\"_id\":\"accepted\"}}\n"
package org.opensearch.http;
/*
    }
        );
        final List<Map<String, Object>> rejectedItems = (List<Map<String, Object>>) rejectedBody.get("items");
        assertFalse(successfulItem.containsKey("error"));
        assertEquals(OK.getStatus(), storedResponse.getStatusLine().getStatusCode());
                + OVERSIZED_SOURCE
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        );
import java.util.List;
public class BulkShardIndexingPressureRestIT extends HttpSmokeTestCase {
    }
                + OVERSIZED_SOURCE
    public void testShardPressureRejectionReturnsBulkItemErrors() throws Exception {
        assertEquals(2, items.size());
        assertEquals(Map.of("message", "small request on a healthy shard", "sequence", 42), storedBody.get("_source"));
            "{\"transient\":{\"" + ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey() + "\":" + enabled + "}}"
            // With shard pressure disabled, whole-request coordinating admission must still return HTTP 429.
            assertDocumentMissing(index, "rejected-" + (i + 1));
        assertEquals(OK.getStatus(), createResponse.getStatusLine().getStatusCode());
 * SPDX-License-Identifier: Apache-2.0
        final Map<String, Object> error = (Map<String, Object>) body.get("error");
        final String successfulIndex = "bulk-pressure-success";
        assertEquals(TOO_MANY_REQUESTS.getStatus(), rejectedItem.get("status"));
        assertEquals(Boolean.FALSE, successfulBody.get("errors"));
                + "\",\"_id\":\"rejected\"}}\n"
        assertEquals(Boolean.TRUE, entityAsMap(rejectedResponse).get("errors"));
import java.util.Map;
        assertEquals(CREATED.getStatus(), successfulItem.get("status"));
            assertDocumentMissing(index, "rejected-node");
 */
import java.io.IOException;
        assertEquals(OK.getStatus(), rejectedResponse.getStatusLine().getStatusCode());
        final Map<String, Object> successfulItem = (Map<String, Object>) items.get(0).get("index");
        assertEquals("created", successfulItem.get("result"));
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1, numClientNodes = 0)
        final Response successfulResponse = getRestClient().performRequest(successfulBulk);
            final Request rejectedNodeBulk = new Request("POST", "/" + index + "/_bulk");
        createSingleShardIndex(rejectedIndex);
        request.setJsonEntity(
        assertEquals(TOO_MANY_REQUESTS.getStatus(), body.get("status"));
        final Response response = getRestClient().performRequest(request);
        assertEquals("accepted", successfulItem.get("_id"));
        } finally {
        rejectedBulk.setJsonEntity(
    }
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(TOO_MANY_REQUESTS.getStatus(), response.getStatusLine().getStatusCode());
        assertEquals(rejectedIndex, rejectedItem.get("_index"));
        final Response storedResponse = getRestClient().performRequest(new Request("GET", "/" + index + "/_doc/accepted"));
import static org.opensearch.core.rest.RestStatus.TOO_MANY_REQUESTS;
                + "\n{\"index\":{\"_index\":\""
        createSingleShardIndex(successfulIndex);
        try {
                + rejectedIndex
        assertEquals(OK.getStatus(), response.getStatusLine().getStatusCode());
import org.opensearch.index.IndexingPressure;
        final Map<String, Object> rejectedItem = (Map<String, Object>) items.get(1).get("index");
import static org.opensearch.core.rest.RestStatus.CREATED;
            assertEquals(index, item.get("_index"));
    public void testBulkSucceedsAfterShardPressureRejection() throws Exception {
import org.opensearch.client.Response;
    @SuppressWarnings("unchecked")
        assertEquals(2, rejectedItems.size());
        assertEquals(1, successfulItems.size());
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "16KB")
 *
import org.opensearch.client.ResponseException;
        final Request rejectedSingle = new Request("PUT", "/" + index + "/_doc/rejected-single");
    @SuppressWarnings("unchecked")
        assertEquals(OK.getStatus(), response.getStatusLine().getStatusCode());
        );
    private void createSingleShardIndex(String index) throws IOException {
        assertEquals(Boolean.TRUE, rejectedBody.get("errors"));
        final Response storedResponse = getRestClient().performRequest(new Request("GET", "/" + successfulIndex + "/_doc/accepted"));
        rejectedSingle.setJsonEntity(OVERSIZED_SOURCE);
 * compatible open source license.
    private static final String OVERSIZED_SOURCE = "{\"message\":\"" + "x".repeat(64 * 1024) + "\"}";
        for (int i = 0; i < rejectedItems.size(); i++) {
        final String successfulSource = "{\"message\":\"small request on a healthy shard\",\"sequence\":42}";
        createIndex.setJsonEntity("{\"settings\":{\"number_of_shards\":1,\"number_of_replicas\":0}}");
            assertRequestRejected(rejectedNodeBulk);
        assertEquals(successfulIndex, successfulItem.get("_index"));
        assertRequestRejected(rejectedSingle);
        // Separate one-shard indices guarantee distinct shard groups without relying on document routing.
        final Map<String, Object> successfulBody = entityAsMap(successfulResponse);
        createSingleShardIndex(index);
        final Request bulk = new Request("POST", "/_bulk");
        createSingleShardIndex(index);
        assertEquals(OK.getStatus(), successfulResponse.getStatusLine().getStatusCode());
        );
        assertEquals("rejected_execution_exception", error.get("type"));
        final Map<String, Object> error = (Map<String, Object>) rejectedItem.get("error");
        successfulBulk.setJsonEntity(
    public void testBulkReturnsSuccessAndShardPressureFailure() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        final Map<String, Object> rejectedBody = entityAsMap(rejectedResponse);
            "{\"index\":{\"_id\":\"rejected-1\"}}\n"
        assertEquals(OK.getStatus(), rejectedResponse.getStatusLine().getStatusCode());
        final String index = "bulk-pressure";
        bulk.setJsonEntity(
        final ResponseException exception = expectThrows(ResponseException.class, () -> getRestClient().performRequest(request));
        return Settings.builder()
    }
    protected Settings nodeSettings(int nodeOrdinal) {
        final Response createResponse = getRestClient().performRequest(createIndex);
        assertEquals(Boolean.TRUE, entityAsMap(response).get("acknowledged"));
        assertEquals(CREATED.getStatus(), successfulItem.get("status"));
        }
        final Request rejectedBulk = new Request("POST", "/" + index + "/_bulk");
        rejectedBulk.setJsonEntity("{\"index\":{\"_id\":\"rejected\"}}\n" + OVERSIZED_SOURCE + "\n");
        final Response response = getRestClient().performRequest(bulk);
    @SuppressWarnings("unchecked")
            .build();
import static org.opensearch.test.rest.OpenSearchRestTestCase.entityAsMap;
                + successfulIndex
        }
        assertDocumentMissing(rejectedIndex, "rejected");
        assertEquals(Boolean.FALSE, entityAsMap(response).get("found"));
 * The OpenSearch Contributors require contributions made to
        final String index = "bulk-pressure";
    }
        final Map<String, Object> successfulItem = (Map<String, Object>) successfulItems.get(0).get("index");
