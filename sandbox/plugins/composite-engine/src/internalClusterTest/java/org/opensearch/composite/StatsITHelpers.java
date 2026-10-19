        }
            throw new AssertionError("queryParams must be key-value pairs, got odd count: " + queryParams.length);  
        return fetchStats(rest, path, queryParams);  
        long actual = getCounter(response, path);  
    @SuppressWarnings("unchecked")
        String path = nodeIdOrEmpty.isEmpty()  
            if (!(current instanceof Map)) return false;  
 * this file be licensed under the Apache-2.0 license or a
    }
        assertTrue(message + " [path=" + path + ", actual=" + actual + ", min=" + min + "]", actual >= min);
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.composite;
        return XContentHelper.convertToMap(JsonXContent.jsonXContent, response.getEntity().getContent(), true);
    }
    private StatsITHelpers() {}
    }
        assertEquals(message + " [path=" + path + "]", expected, actual);
}
import java.io.IOException;
        String[] segments = dottedPath.split("\\.");  
    }  
    }
        return fetchStats(rest, "/_plugins/composite/" + index + "/_stats", queryParams);
        String path = nodeIdOrEmpty.isEmpty() ? "/_plugins/parquet/_nodes/_stats" : "/_plugins/parquet/_nodes/" + nodeIdOrEmpty + "/_stats";
        }
    // ---- Action helpers ----  
            current = ((Map<String, Object>) current).get(segment);  
    }
        for (String segment : segments) {
 * @opensearch.experimental  
    // ---- Pure parsers ----
        for (int i = 0; i < queryParams.length; i += 2) {  
 *
    // ---- Assertion helpers ----
import static org.junit.Assert.assertTrue;
    static int getStatusCode(Map<String, Object> response) {
    }
import java.util.Map;
    }
        if (current instanceof Number) return ((Number) current).longValue();  
    static Response getRaw(RestClient rest, String path) throws IOException {
    static Map<String, Object> luceneNodeStats(RestClient rest, String nodeIdOrEmpty, String... queryParams) throws IOException {
            : "/_plugins/composite/_nodes/" + nodeIdOrEmpty + "/_stats";
        String path = nodeIdOrEmpty.isEmpty() ? "/_plugins/lucene/_nodes/_stats" : "/_plugins/lucene/_nodes/" + nodeIdOrEmpty + "/_stats";  
    }  
    }
import org.opensearch.client.RestClient;  
        assertTrue(message + " [path=" + path + " must exist, got -1]", actual != -1L);  
    }
        }
    @SuppressWarnings("unchecked")  
    static void forceMerge(org.opensearch.transport.client.Client client, String index, int maxSegments) {
 * {@link BaseStatsIT} so that test classes extending different base hierarchies  
            if (current == null) return -1L;
            ? "/_plugins/composite/_nodes/_stats"
        if (queryParams.length % 2 != 0) {
    static long getCounter(Map<String, Object> response, String dottedPath) {
        return status != null ? status.intValue() : -1;  
 * (e.g. {@link DataFormatAwareReplicationBaseIT}) can reuse the same helpers.
    static void assertCounterAtLeast(String message, Map<String, Object> response, String path, long min) {
        Object current = response;  
        Response response = rest.performRequest(new Request("GET", uri.toString()));  
import org.opensearch.common.xcontent.json.JsonXContent;
            current = ((Map<String, Object>) current).get(segment);
            if (!(current instanceof Map)) return -1L;
        StringBuilder uri = new StringBuilder(path);
    // ---- REST helpers ----  
    static Map<String, Object> compositeNodeStats(RestClient rest, String nodeIdOrEmpty, String... queryParams) throws IOException {
import static org.junit.Assert.assertEquals;
        long actual = getCounter(response, path);
        Object current = response;
    static void assertCounter(String message, Map<String, Object> response, String path, long expected) {  
            if (current == null) return false;
    static boolean hasPath(Map<String, Object> response, String dottedPath) {
    }  
        return fetchStats(rest, "/_plugins/parquet/" + index + "/_stats", queryParams);  
import org.opensearch.common.xcontent.XContentHelper;
            uri.append(i == 0 ? '?' : '&').append(queryParams[i]).append('=').append(queryParams[i + 1]);
 */  
        long actual = getCounter(response, path);
    static Map<String, Object> parquetIndexStats(RestClient rest, String index, String... queryParams) throws IOException {
        return fetchStats(rest, "/_plugins/lucene/" + index + "/_stats", queryParams);
final class StatsITHelpers {
/*  
        Number status = (Number) response.get("status");
    }
        return true;
    static Map<String, Object> parquetNodeStats(RestClient rest, String nodeIdOrEmpty, String... queryParams) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        return fetchStats(rest, path, queryParams);
        return -1L;
 * Static utility methods shared across stats integration tests. Extracted from
 * compatible open source license.
        return rest.performRequest(new Request("GET", path));
        client.admin().indices().prepareForceMerge(index).setMaxNumSegments(maxSegments).get();  
        for (String segment : segments) {
 */
import org.opensearch.client.Request;
    static Map<String, Object> compositeIndexStats(RestClient rest, String index, String... queryParams) throws IOException {
 *
    static Map<String, Object> luceneIndexStats(RestClient rest, String index, String... queryParams) throws IOException {  
        String[] segments = dottedPath.split("\\.");
        }  
/**
        return fetchStats(rest, path, queryParams);
    }
    static void assertCounterPresent(String message, Map<String, Object> response, String path) {
    static Map<String, Object> fetchStats(RestClient rest, String path, String... queryParams) throws IOException {
    }  
import org.opensearch.client.Response;
