            + "  \"index.pluggable.dataformat\": \"composite\","  
        }
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
    private static final String INDEX = "coord_reduce_memtable_e2e";  
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
 * wiring and the buffered memtable handoff against a real multi-shard scan.
        bulkRequest.addParameter("refresh", "true");
        long actual = ((Number) cell).longValue();  
 */  
        createParquetBackedIndex();  
        client().performRequest(bulkRequest);  
}
        Object cell = rows.get(0).get(idx);
        assertTrue("columns must contain 'total', got " + columns, columns.contains("total"));
            + "\"settings\": {"
        assertNotNull("rows must not be null", rows);  
    public void testScalarSumAcrossShardsViaMemtable() throws Exception {
    private static final int NUM_SHARDS = 2;
        } catch (Exception ignored) {}
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
        indexDeterministicDocs();
            bulk.append("{\"index\": {}}\n");
            + "  \"number_of_replicas\": 0,"
    private void indexDeterministicDocs() throws Exception {
    private static final int DOCS_PER_SHARD = 10;
/*  
 * (configured via the {@code integTestMemtable} task in build.gradle).
        assertNotNull("SUM(value) cell must not be null — memtable coordinator-reduce returned no value", cell);
        @SuppressWarnings("unchecked")
            + "    \"value\": { \"type\": \"integer\" }"  
 * starts with {@code datafusion.reduce.input_mode=memtable} so the coordinator-reduce path uses  
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");  
            + "  }"
 *  
            bulk.append("{\"value\": ").append(VALUE).append("}\n");  
/**
            + "},"  
        health.addParameter("timeout", "30s");  
        List<String> columns = extractColumnNames(result);  
            + "}"
        assertNotNull("schema must not be null", columns);
import java.util.Map;
import java.util.List;
        bulkRequest.setJsonEntity(bulk.toString());
            + "  \"index.composite.primary_data_format\": \"parquet\","
        @SuppressWarnings("unchecked")
        try {  
            + "  \"number_of_shards\": " + NUM_SHARDS + ","  
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index");
            + "}";  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("SUM(value) memtable path must match streaming path", expected, actual);
public class CoordinatorReduceMemtableIT extends AnalyticsRestTestCase {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.client.Response;
            + "  \"index.pluggable.dataformat.enabled\": true,"
 * <p>Requires a dedicated cluster configuration with {@code datafusion.reduce.input_mode=memtable}
        createIndex.setJsonEntity(body);  
            + "  \"properties\": {"
 * compatible open source license.
        health.addParameter("wait_for_status", "green");
    }  
 */  
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        long expected = (long) VALUE * NUM_SHARDS * DOCS_PER_SHARD;
    }
            client().performRequest(new Request("DELETE", "/" + INDEX));
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats sum(value) as total");  
        Request createIndex = new Request("PUT", "/" + INDEX);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    private void createParquetBackedIndex() throws Exception {
 * Memtable variant of {@link CoordinatorReduceIT}. Identical query and assertion, but the cluster
 * DatafusionMemtableReduceSink instead of the streaming sink. Verifies the sink dispatch
import org.opensearch.client.Request;
            + "\"mappings\": {"
 *
        StringBuilder bulk = new StringBuilder();  
    private static final int VALUE = 7;  
    }  
        int idx = columns.indexOf("total");  
        client().performRequest(health);
        String body = "{"
        for (int i = 0; i < total; i++) {
        int total = NUM_SHARDS * DOCS_PER_SHARD;
package org.opensearch.analytics.qa;
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
 * SPDX-License-Identifier: Apache-2.0
