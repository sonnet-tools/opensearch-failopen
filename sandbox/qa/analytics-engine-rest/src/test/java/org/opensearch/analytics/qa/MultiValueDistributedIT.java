    private static final int SHARDS = 2;
        }
        Map<String, Object> result = executePpl("source = " + INDEX + " | fields tags");
            + "\"settings\": {"
        health.addParameter("timeout", "30s");
        int idColumn = columns.indexOf("id");
        bulkRequest.addParameter("refresh", "true");
        }
            + "}";
            + "  \"index.composite.primary_data_format\": \"parquet\","  
        String mapping = "{"
            + SHARDS
 */  
            + "  \"index.pluggable.dataformat.enabled\": true,"
        assertTrue("expected tags column, got " + columns, tagsColumn >= 0);
        Map<String, Object> bulkResponse = assertOkAndParse(client().performRequest(bulkRequest), "_bulk " + INDEX);
 * The OpenSearch Contributors require contributions made to  
        } catch (Exception ignored) {}
 * compatible open source license.
            client().performRequest(new Request("DELETE", "/" + INDEX));
    public void testStoredListProjectionAcrossTwoShards() throws Exception {  
    }  
            + "  \"number_of_shards\": "  
        try {  
            + "{\"index\":{}}\n"  
 */  
            actual
        assertEquals(  
        int tagsColumn = columns.indexOf("tags");
 *
            + "{\"id\":3,\"tags\":[\"blue\"]}\n";  
        assertEquals(  
    private static List<List<Object>> rows(Map<String, Object> result) {
            + "{\"id\":1,\"tags\":[\"blue\",\"blue\",\"red\"]}\n"
            actual.put(((Number) row.get(idColumn)).intValue(), strings(row.get(tagsColumn)));
    public void testSimpleStoredListProjection() throws Exception {  
        for (List<Object> row : rows(result)) {  
            + "}}"  
        String bulk = "{\"index\":{}}\n"
/*  
        client().performRequest(health);
        );
    private static List<String> strings(Object value) {  
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
        );  
            + "  \"index.pluggable.dataformat\": \"composite\","
        Request flush = new Request("POST", "/" + INDEX + "/_flush");  
public class MultiValueDistributedIT extends AnalyticsRestTestCase {
        Request create = new Request("PUT", "/" + INDEX);  
            + "},"
        int tagsColumn = columns.indexOf("tags");
}
            Map.of(1, List.of("blue", "blue", "red"), 2, List.of("red", "green"), 3, List.of("blue")),
        create.setJsonEntity(mapping);
        Map<String, Object> result = executePpl("source = " + INDEX + " | fields id, tags | sort id");
    private static final String INDEX = "multi_value_distributed";  
 *
    }
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "create " + INDEX);
import java.util.List;
        List<String> columns = extractColumnNames(result);  
    }
    }  
import java.util.HashMap;
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;  
        flush.addParameter("force", "true");
 * End-to-end coverage for projecting stored multi-value keyword fields across two shards.  
    @SuppressWarnings("unchecked")
        assertEquals("index creation must be acknowledged", Boolean.TRUE, response.get("acknowledged"));  
        assertTrue("expected LIST cell, got " + (value == null ? "null" : value.getClass()), value instanceof List);
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");
            + "  \"number_of_replicas\": 0,"  
        client().performRequest(flush);
        actual.sort(String::compareTo);
        List<String> actual = new ArrayList<>();
        health.addParameter("wait_for_status", "green");  
    private void provision() throws Exception {
        provision();
import org.opensearch.client.Request;
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
            + "  \"id\": {\"type\": \"integer\"},"
            + "  \"tags\": {\"type\": \"keyword\", \"multi_value\": true}"
        return (List<List<Object>>) result.get("datarows");
        assertTrue("expected id and tags columns, got " + columns, idColumn >= 0 && tagsColumn >= 0);  
        bulkRequest.setJsonEntity(bulk);  
package org.opensearch.analytics.qa;
        List<String> columns = extractColumnNames(result);  
            actual.add(String.join(",", strings(row.get(tagsColumn))));  
            + "\"mappings\": {\"properties\": {"  
        for (List<Object> row : rows(result)) {
            Boolean.FALSE,
        provision();
        return new ArrayList<>(((List<Object>) value).stream().map(String::valueOf).toList());
    }  
            bulkResponse.get("errors")  
            + "{\"index\":{}}\n"
            + ","
 * <p>Exercises the Arrow schema boundary in both directions with direct LIST projections.
        Map<Integer, List<String>> actual = new HashMap<>();
import java.util.Map;  
            "bulk ingest must report no item errors: " + bulkResponse,
 * SPDX-License-Identifier: Apache-2.0
    @SuppressWarnings("unchecked")  
            + "{\"id\":2,\"tags\":[\"red\",\"green\"]}\n"
/**
        assertEquals(List.of("blue", "blue,blue,red", "red,green"), actual);  
