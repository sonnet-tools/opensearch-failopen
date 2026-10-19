    }
        assertClearedNodes(body);
        Response response = client().performRequest(request);
        Map<String, Object> nodesHeader = (Map<String, Object>) body.get("_nodes");
    public void testClearAllCachesReturns200WithAcknowledged() throws IOException {
    private Map<String, Object> clearCache(String queryParams) throws IOException {
 */
}
    // ── selective: single param ───────────────────────────────────────────────
 * Integration tests for {@code POST /_plugins/_analytics_backend_datafusion/cache/_clear}.  
        Map<String, Object> body = clearCache("?footer=true&column=true&offset=true");
 *  
    public void testClearFooterCacheOnly() throws IOException {
    // ── response shape ────────────────────────────────────────────────────────
    public void testClearOffsetIndexCacheOnly() throws IOException {
    }
    // ── clear all ────────────────────────────────────────────────────────────  
        Map<String, Object> body = clearCache("?column=true");
        Map<String, Object> body = clearCache("");
import java.util.List;
        assertFalse("at least one node cleared", clearedNodes.isEmpty());
        int successful = ((Number) nodesHeader.get("successful")).intValue();  
        Request request = new Request("POST", CLEAR_ENDPOINT);
import java.util.Map;  
    }  
 * this file be licensed under the Apache-2.0 license or a
    public void testResponseIncludesNodesAndClusterName() throws IOException {
        Map<String, Object> body = assertOkAndParse(response, "cache/_clear");
        assertEquals(true, body.get("acknowledged"));
        assertClearedNodes(body);
    }  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.analytics.qa;
        assertClearedNodes(body);  
 * <p>Tests verify:
 * </ul>
        assertTrue("at least one node total", total >= 1);
        assertEquals(true, body.get("acknowledged"));  
    }
        assertClearedNodes(body);
        clearCache("");
        Response response = client().performRequest(request);  
 *
 *   <li>Clear all: no params — returns 200, {@code acknowledged=true}, non-empty {@code cleared_nodes}</li>
    }  
        assertTrue("all nodes successful", successful == total);
    }
    public void testClearColumnAndOffsetTogether() throws IOException {  
 * <ul>  
 *   <li>Unknown param: ignored (backward compat) — still returns 200</li>
 * SPDX-License-Identifier: Apache-2.0
    // ── idempotency ───────────────────────────────────────────────────────────  
 * <p>The cache contents themselves are not observable via REST (stats endpoint is PR 1),
        assertNotNull("cleared_nodes present", clearedNodes);
    public void testClearIsIdempotent() throws IOException {
    // ── selective: combined params ────────────────────────────────────────────
        // Second clear of an already-empty cache must still return 200.  
        int total = ((Number) nodesHeader.get("total")).intValue();
 *   <li>Selective clear: {@code ?footer=true}, {@code ?column=true}, {@code ?offset=true} — each returns 200</li>
        assertEquals(true, body.get("acknowledged"));  
 * compatible open source license.
        assertNotNull("cluster_name present", body.get("cluster_name"));
        assertEquals(true, body.get("acknowledged"));  
import org.opensearch.client.Request;
        assertEquals(true, body.get("acknowledged"));
        Map<String, Object> body = clearCache("?footer=true");
/*  
        assertClearedNodes(body);  
    }
 * so these tests verify only that the action completes successfully and returns a
        Map<String, Object> body = clearCache("?column=true&offset=true");
        // NodesResponseRestListener wraps with _nodes + cluster_name  
        assertEquals(true, body.get("acknowledged"));  
/**
        Request request = new Request("POST", CLEAR_ENDPOINT + queryParams);  
 * well-formed response.  
    }  
    @SuppressWarnings("unchecked")  
 */  
    private static final String CLEAR_ENDPOINT = "/_plugins/_analytics_backend_datafusion/cache/_clear";
        Map<String, Object> body = clearCache("?offset=true");
    }
        return assertOkAndParse(response, "cache/_clear" + queryParams);
import java.io.IOException;
        assertEquals(true, body.get("acknowledged"));
        assertClearedNodes(body);
    // ── helpers ───────────────────────────────────────────────────────────────
import org.opensearch.client.Response;
    @SuppressWarnings("unchecked")
        assertClearedNodes(body);
        Map<String, Object> body = clearCache("");  
 *
        assertNotNull("_nodes header present", body.get("_nodes"));
 *   <li>Combined params: {@code ?column=true&offset=true} — returns 200</li>  
    public void testClearColumnIndexCacheOnly() throws IOException {
    public void testClearAllThreeExplicitly() throws IOException {  
    private void assertClearedNodes(Map<String, Object> body) {
        List<Object> clearedNodes = (List<Object>) body.get("cleared_nodes");  
public class DataFusionCacheClearIT extends AnalyticsRestTestCase {
