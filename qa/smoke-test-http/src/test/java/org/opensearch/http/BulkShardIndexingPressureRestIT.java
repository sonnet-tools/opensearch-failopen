        assertEquals(Boolean.TRUE, storedBody.get("found"));  
            final Map<String, Object> item = (Map<String, Object>) rejectedItems.get(i).get("index");
        final Response response = exception.getResponse();
        final Request createIndex = new Request("PUT", "/" + index);  
    private void assertDocumentMissing(String index, String id) throws IOException {
        final String successfulSource = "{\"message\":\"small request on a healthy shard\",\"sequence\":42}";
            assertEquals(TOO_MANY_REQUESTS.getStatus(), item.get("status"));
    }  
    private void createSingleShardIndex(String index) throws IOException {
        assertEquals(TOO_MANY_REQUESTS.getStatus(), rejectedItem.get("status"));
    @SuppressWarnings("unchecked")  
        final Request request = new Request("PUT", "/_cluster/settings");
        assertEquals(OK.getStatus(), storedResponse.getStatusLine().getStatusCode());
import org.opensearch.common.settings.Settings;
                + "\",\"_id\":\"rejected\"}}\n"
    @Override
                + OVERSIZED_SOURCE
        assertEquals(Boolean.FALSE, entityAsMap(response).get("found"));  
        createSingleShardIndex(index);  
        final String rejectedIndex = "bulk-pressure-rejected";
        final List<Map<String, Object>> successfulItems = (List<Map<String, Object>>) successfulBody.get("items");
        createSingleShardIndex(index);  
        final Map<String, Object> storedBody = entityAsMap(storedResponse);  
        assertEquals(Boolean.TRUE, entityAsMap(rejectedResponse).get("errors"));  
import java.util.Map;  
            .put(super.nodeSettings(nodeOrdinal))
        successfulBulk.setJsonEntity(
        rejectedSingle.setJsonEntity(OVERSIZED_SOURCE);
        final Request bulk = new Request("POST", "/_bulk");
        assertEquals(NOT_FOUND.getStatus(), response.getStatusLine().getStatusCode());
        // The single-document API must still unwrap its one failed bulk item into an HTTP-level rejection.  
        assertEquals(Boolean.TRUE, entityAsMap(response).get("acknowledged"));
                + "\n{\"index\":{\"_index\":\""
            // With shard pressure disabled, whole-request coordinating admission must still return HTTP 429.
                + "\n"  
        request.setJsonEntity(
            assertRequestRejected(rejectedNodeBulk);
            setShardPressureEnabled(null);
    }
        assertEquals(Boolean.TRUE, rejectedBody.get("errors"));
        final Request rejectedSingle = new Request("PUT", "/" + index + "/_doc/rejected-single");
        final Request successfulBulk = new Request("POST", "/" + index + "/_bulk");  
        assertEquals(rejectedIndex, rejectedItem.get("_index"));  
        rejectedBulk.setJsonEntity("{\"index\":{\"_id\":\"rejected\"}}\n" + OVERSIZED_SOURCE + "\n");  
        final List<Map<String, Object>> items = (List<Map<String, Object>>) body.get("items");
import org.opensearch.client.Response;
        assertEquals("accepted", successfulItem.get("_id"));  
    }  
        assertEquals(TOO_MANY_REQUESTS.getStatus(), body.get("status"));
        try {
    protected Settings nodeSettings(int nodeOrdinal) {  
            "{\"index\":{\"_index\":\""
            assertEquals("rejected_execution_exception", error.get("type"));
    public void testBulkSucceedsAfterShardPressureRejection() throws Exception {
        assertEquals(CREATED.getStatus(), successfulItem.get("status"));
        }
        createIndex.setJsonEntity("{\"settings\":{\"number_of_shards\":1,\"number_of_replicas\":0}}");
        assertEquals(Boolean.TRUE, body.get("errors"));  
        assertEquals(Map.of("message", "small request on a healthy shard", "sequence", 42), storedBody.get("_source"));
        rejectedBulk.setJsonEntity(  
        final Map<String, Object> successfulBody = entityAsMap(successfulResponse);  
            assertEquals("rejected-" + (i + 1), item.get("_id"));
    }
            .build();  
import java.io.IOException;
    }
        assertEquals(OK.getStatus(), rejectedResponse.getStatusLine().getStatusCode());
        assertEquals(Boolean.FALSE, successfulBody.get("errors"));
        );  
        final Response rejectedResponse = getRestClient().performRequest(rejectedBulk);
    public void testNodePressureRejectionReturnsTooManyRequestsWhenShardPressureDisabled() throws Exception {
                + OVERSIZED_SOURCE
        final Response response = getRestClient().performRequest(bulk);  
    }  
        final Request rejectedBulk = new Request("POST", "/" + index + "/_bulk");
        assertEquals("accepted", successfulItem.get("_id"));  
        final Map<String, Object> error = (Map<String, Object>) rejectedItem.get("error");  
        final Response createResponse = getRestClient().performRequest(createIndex);
        createSingleShardIndex(index);  
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "16KB")  
    // A single document exceeds the node limit, so rejection does not depend on concurrent indexing or timing.
        } finally {  
import static org.opensearch.core.rest.RestStatus.TOO_MANY_REQUESTS;
                + "\n"
        assertEquals(OK.getStatus(), storedResponse.getStatusLine().getStatusCode());
 * SPDX-License-Identifier: Apache-2.0
 *
            rejectedNodeBulk.setJsonEntity("{\"index\":{\"_id\":\"rejected-node\"}}\n" + OVERSIZED_SOURCE + "\n");  
    @SuppressWarnings("unchecked")
            "{\"transient\":{\"" + ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey() + "\":" + enabled + "}}"  
            final Map<String, Object> error = (Map<String, Object>) item.get("error");  
        final ResponseException exception = expectThrows(ResponseException.class, () -> getRestClient().performRequest(request));
        assertEquals(CREATED.getStatus(), successfulItem.get("status"));
        }  
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;  
        assertEquals(OK.getStatus(), createResponse.getStatusLine().getStatusCode());  
            setShardPressureEnabled(false);  
            assertDocumentMissing(index, "rejected-node");
        assertEquals(1, successfulItems.size());  
        assertEquals(Boolean.TRUE, entityAsMap(createResponse).get("acknowledged"));
        );
        final List<Map<String, Object>> rejectedItems = (List<Map<String, Object>>) rejectedBody.get("items");
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
 * this file be licensed under the Apache-2.0 license or a
    private static final String OVERSIZED_SOURCE = "{\"message\":\"" + "x".repeat(64 * 1024) + "\"}";  
        createSingleShardIndex(rejectedIndex);
        assertEquals(TOO_MANY_REQUESTS.getStatus(), response.getStatusLine().getStatusCode());  
import org.opensearch.client.Request;
        final Request request = new Request("GET", "/" + index + "/_doc/" + id);
        bulk.setJsonEntity(  
        final String index = "bulk-pressure";  
        final Response successfulResponse = getRestClient().performRequest(successfulBulk);
    @SuppressWarnings("unchecked")  
        assertEquals(Map.of("message", "small bulk request after rejection", "sequence", 42), storedBody.get("_source"));
 */  
        final Map<String, Object> storedBody = entityAsMap(storedResponse);
        final String index = "bulk-pressure";
        assertEquals(2, items.size());
        final String successfulIndex = "bulk-pressure-success";
    private void assertRequestRejected(Request request) throws IOException {  
    }
        );
        assertEquals(OK.getStatus(), response.getStatusLine().getStatusCode());
package org.opensearch.http;
        createSingleShardIndex(successfulIndex);
        assertEquals(2, rejectedItems.size());  
        final Response storedResponse = getRestClient().performRequest(new Request("GET", "/" + successfulIndex + "/_doc/accepted"));  
            assertEquals(index, item.get("_index"));  
        final Map<String, Object> rejectedItem = (Map<String, Object>) items.get(1).get("index");
            assertDocumentMissing(index, "rejected-" + (i + 1));
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
 * compatible open source license.
import static org.opensearch.core.rest.RestStatus.CREATED;
        );  
        assertEquals(Boolean.TRUE, storedBody.get("found"));
        assertEquals("created", successfulItem.get("result"));
    }
        final Request rejectedBulk = new Request("POST", "/" + index + "/_bulk");
        assertEquals(successfulIndex, successfulItem.get("_index"));
        final Map<String, Object> successfulItem = (Map<String, Object>) items.get(0).get("index");
        assertDocumentMissing(index, "rejected-single");
}  
        final Response storedResponse = getRestClient().performRequest(new Request("GET", "/" + index + "/_doc/accepted"));
            "{\"index\":{\"_id\":\"accepted\"}}\n{\"message\":\"small bulk request after rejection\",\"sequence\":42}\n"
        ensureGreen(index);
    public void testSingleDocumentShardPressureRejectionReturnsTooManyRequests() throws Exception {
            "{\"index\":{\"_id\":\"rejected-1\"}}\n"
        assertEquals(OK.getStatus(), successfulResponse.getStatusLine().getStatusCode());
    public void testBulkReturnsSuccessAndShardPressureFailure() throws Exception {  
        final Response response = exception.getResponse();
                + rejectedIndex  
import org.opensearch.client.ResponseException;  
        // Separate one-shard indices guarantee distinct shard groups without relying on document routing.  
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1, numClientNodes = 0)
        final String index = "bulk-pressure";
            final Request rejectedNodeBulk = new Request("POST", "/" + index + "/_bulk");
                + "\",\"_id\":\"accepted\"}}\n"  
        assertEquals("rejected", rejectedItem.get("_id"));
        final Map<String, Object> error = (Map<String, Object>) body.get("error");  
        assertEquals("rejected_execution_exception", error.get("type"));
        final Map<String, Object> rejectedBody = entityAsMap(rejectedResponse);  
    @SuppressWarnings("unchecked")
        final Map<String, Object> body = entityAsMap(response);
    }  
/*  
        assertRequestRejected(rejectedSingle);  
        assertEquals("rejected_execution_exception", error.get("type"));
                + successfulSource
import org.opensearch.index.IndexingPressure;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
public class BulkShardIndexingPressureRestIT extends HttpSmokeTestCase {  
import org.opensearch.index.ShardIndexingPressureSettings;  
        for (int i = 0; i < rejectedItems.size(); i++) {
        assertFalse(successfulItem.containsKey("error"));  
        final Response rejectedResponse = getRestClient().performRequest(rejectedBulk);
        createSingleShardIndex(index);
                + successfulIndex
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        assertEquals(OK.getStatus(), response.getStatusLine().getStatusCode());  
                + OVERSIZED_SOURCE
    private void setShardPressureEnabled(Boolean enabled) throws IOException {  
    public void testShardPressureRejectionReturnsBulkItemErrors() throws Exception {
        final String index = "bulk-pressure";
 * The OpenSearch Contributors require contributions made to  
        final Response response = getRestClient().performRequest(request);
        final ResponseException exception = expectThrows(ResponseException.class, () -> getRestClient().performRequest(request));  
        return Settings.builder()
        assertDocumentMissing(rejectedIndex, "rejected");
import static org.opensearch.test.rest.OpenSearchRestTestCase.entityAsMap;  
        // The rejection must release its accounting so a later request on the same shard is admitted.
import java.util.List;
        assertEquals(OK.getStatus(), rejectedResponse.getStatusLine().getStatusCode());
        final Map<String, Object> successfulItem = (Map<String, Object>) successfulItems.get(0).get("index");
    }
        final Map<String, Object> body = entityAsMap(response);
import static org.opensearch.core.rest.RestStatus.OK;
                + "\n{\"index\":{\"_id\":\"rejected-2\"}}\n"  
