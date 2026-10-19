        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        createIndex.setJsonEntity(body);  
            + "}"
        client().performRequest(health);
        }
     *
        } catch (Exception ignored) {}
            bulk.append("{\"value\": ").append(valueFn.applyAsInt(i)).append("}\n");
        bulkRequest.addParameter("refresh", "true");  
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
        }
        assertNotNull("schema must not be null", columns);
    }
        int total = NUM_SHARDS * DOCS_PER_SHARD;
 *
        int total = NUM_SHARDS * DOCS_PER_SHARD;
        StringBuilder bulk = new StringBuilder();
        }
        int total = NUM_SHARDS * DOCS_PER_SHARD;  
            + "  \"index.composite.primary_data_format\": \"parquet\","
        for (int i = 0; i < total; i++) {
        Request createIndex = new Request("PUT", "/" + INDEX);
        return rows;
 * SPDX-License-Identifier: Apache-2.0
        double mean = (total - 1) / 2.0;  
        List<List<Object>> rows = scalarRows(result, "dc");  
            + "  \"properties\": {"
            sumSquares += (i - mean) * (i - mean);
            + "\"settings\": {"
     * {@code stats dc(value) as dc} — engine-native HLL merge. PARTIAL emits a single Binary
     * <p>Expected: sample stddev of (0..19) = sqrt(sum((i - mean)^2) / (N - 1)) = sqrt(35) ≈ 5.916.
            + "  \"number_of_shards\": " + NUM_SHARDS + ","  
 * multi-shard queries.
    }  
    }  
     * SUM, SUM-of-squares, and COUNT primitives at HEP-marking time, then finalised with  
import java.util.List;
        createParquetBackedIndex();
     * {@code stats var_samp(value) as v} — sample variance. Reduced to
        double mean = (total - 1) / 2.0;
    public void testDistinctCountAcrossShards() throws Exception {  
        assertNotNull("schema must not be null", columns);
 * deterministic dataset, but with Arrow Flight RPC streaming enabled. Exercises the
     * <p>Uses varied per-doc values (value = doc index) so the AVG is non-trivial — a
        double sumSquares = 0;
        double expected = sumSquares / (total - 1);
        int idx = columns.indexOf("value");
     */
     * coordinator reduce sink's cross-plugin VectorSchemaRoot handoff.  
        health.addParameter("wait_for_status", "green");
 * shard-fragment → Flight → DatafusionReduceSink.feed handoff that previously failed with
        @SuppressWarnings("unchecked")
    }
        long actual = ((Number) rows.get(0).get(0)).longValue();
public class StreamingCoordinatorReduceIT extends AnalyticsRestTestCase {  
            + "\"mappings\": {"
     */
        indexValuedDocs(i -> i);
        createParquetBackedIndex();  
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats var_pop(value) as v");
 * this file be licensed under the Apache-2.0 license or a
        indexValuedDocs(i -> i);
import org.opensearch.client.Response;
    public void testBaselineScanAcrossShards() throws Exception {
 * <p>Requires a dedicated cluster configuration with the stream transport feature flag enabled  
    }
            + "},"  
            + "  \"number_of_replicas\": 0,"
        indexValuedDocs(i -> i);
    /** Local copy of {@code CoordinatorReduceIT.scalarRows} (the original is package-private). */  
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
     * <p>Expected: sample variance of (0..19) = 35.0.
        bulkRequest.setJsonEntity(bulk.toString());
        assertEquals("VAR_POP(value) across shards should be " + expected, expected, actual, 0.001);  
        indexDeterministicDocs();
    private void indexValuedDocs(IntUnaryOperator valueFn) throws Exception {
    /**  
     * {@code stats avg(value) as a} — primitive decomposition. PARTIAL emits
 * "A buffer can only be associated between two allocators that share the same root" on  
            + "}";  
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");  
            actual >= (long) (total * 0.9) && actual <= (long) (total * 1.1)
     *  
            "dc(value) should be approximately " + total + " (±10%), got " + actual,
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats var_samp(value) as v");  
        // Expected: AVG(0, 1, ..., total-1) = (total - 1) / 2.0
            + "  }"
        double expected = Math.sqrt(sumSquares / (total - 1));
 * compatible open source license.
     * sketch column per shard; FINAL invokes DataFusion's {@code approx_distinct} merge
    private static final int NUM_SHARDS = 2;  
     * <p>Tolerance is 10% — HLL is approximate; with 20 distinct values the error margin  
            sumSquares += (i - mean) * (i - mean);  
        @SuppressWarnings("unchecked")
/**
            + "  \"index.pluggable.dataformat.enabled\": true,"
        assertEquals("all docs across shards must be returned", expectedRows, rows.size());  
        assertEquals("AVG(value) across shards should be " + expected, expected, actual, 0.001);  
        assertTrue(  
        client().performRequest(bulkRequest);
     * {@code source = T} on a 2-shard parquet-backed index with streaming enabled exercises the
            bulk.append("{\"value\": ").append(VALUE).append("}\n");  
     * {@code SUM((x - mean)^2) / (N - 1)}.
        List<List<Object>> rows = scalarRows(result, "v");
        for (int i = 0; i < total; i++) {
        for (int i = 0; i < total; i++) {  
        StringBuilder bulk = new StringBuilder();  
        int total = NUM_SHARDS * DOCS_PER_SHARD;
            sumSquares += (i - mean) * (i - mean);
            bulk.append("{\"index\": {}}\n");
        double actual = ((Number) rows.get(0).get(0)).doubleValue();  
        double expected = Math.sqrt(sumSquares / total);  
        indexValuedDocs(i -> i); // all distinct  
    /**
        assertNotNull("rows must not be null", rows);  
        for (int i = 0; i < total; i++) {
        for (int i = 0; i < total; i++) {
        @SuppressWarnings("unchecked")
    }
 * Streaming variant of {@link CoordinatorReduceIT}: same 2-shard parquet-backed index and  
        int total = NUM_SHARDS * DOCS_PER_SHARD;
     * answer than the correct cross-shard merge.
     * {@code stats stddev_samp(value) as s} — sample standard deviation. Reduced to
        List<List<Object>> rows = scalarRows(result, "a");  
 *
        double sumSquares = 0;  
     */  
        double expected = sumSquares / total;  
import java.util.function.IntUnaryOperator;  
        for (List<Object> row : rows) {  
        client().performRequest(bulkRequest);  
    }  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    /**
    private void createParquetBackedIndex() throws Exception {
        for (int i = 0; i < total; i++) {  
     * coordinator merges them, then divides.  
    public void testVarSampAcrossShards() throws Exception {  
        int total = NUM_SHARDS * DOCS_PER_SHARD;  
    }
            client().performRequest(new Request("DELETE", "/" + INDEX));
        List<List<Object>> rows = scalarRows(result, "s");
            bulk.append("{\"index\": {}}\n");  
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats stddev_samp(value) as s");
            sumSquares += (i - mean) * (i - mean);
        health.addParameter("timeout", "30s");  
        List<List<Object>> rows = scalarRows(result, "s");  
        createParquetBackedIndex();  
        int expectedRows = NUM_SHARDS * DOCS_PER_SHARD;
     *
    }
     * POWER(variance, 0.5).
        @SuppressWarnings("unchecked")
     * {@code SUM((x - mean)^2) / N}, the same primitives as STDDEV_POP minus the final sqrt.
     * which combines sketches across shards. Exercises the engine-native (reducer == self)  
            assertEquals("every doc has value=" + VALUE, (long) VALUE, ((Number) cell).longValue());  
        String body = "{"
        assertEquals("STDDEV_SAMP(value) across shards should be " + expected, expected, actual, 0.001);
        bulkRequest.setJsonEntity(bulk.toString());
     * the streaming reduce-sink: each shard ships sum + count intermediates via Flight, the
     * per-shard pass-through (e.g. concatenating partial AVGs) would yield a different  
    public void testVarPopAcrossShards() throws Exception {
        double sumSquares = 0;
     * {@code sqrt(SUM((x - mean)^2) / (N - 1))}. Same reduction path as STDDEV_POP but
import org.opensearch.client.Request;
        assertTrue("columns must contain '" + columnName + "', got " + columns, columns.contains(columnName));
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
 * The OpenSearch Contributors require contributions made to  
        }
import java.util.Map;
 * (configured via the {@code integTestStreaming} task in build.gradle).
package org.opensearch.analytics.qa;
        double mean = (total - 1) / 2.0;
}
        List<String> columns = extractColumnNames(result);  
     * {@code finalExpression = sum/count}. Exercises the multi-field intermediate path over
     * single-field intermediate path over streaming.
        indexValuedDocs(i -> i);  
        try {  
     * easily covers the variance.
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        indexValuedDocs(i -> i);  
    /**  
/*  
        assertNotNull("cell for '" + columnName + "' must not be null — coordinator-reduce returned no value", cell);
    /**  
        Object cell = rows.get(0).get(columns.indexOf(columnName));  
    private static List<List<Object>> scalarRows(Map<String, Object> result, String columnName) {
        assertNotNull("rows must not be null", rows);  
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats stddev_pop(value) as s");
     */
    private static final int VALUE = 7;
     */
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));  
     * with Bessel's correction in the denominator.  
            + "  \"index.pluggable.dataformat\": \"composite\","  
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
     * {@code stats stddev_pop(value) as s} — multi-field statistical aggregate. Reduced by
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats avg(value) as a");
        assertTrue("columns must contain 'value', got " + columns, columns.contains("value"));
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
 */  
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");
        createParquetBackedIndex();
        );  
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
    }
    public void testStddevSampAcrossShards() throws Exception {
    /**  
    /**
        List<List<Object>> rows = scalarRows(result, "v");  
 */
        createParquetBackedIndex();  
        createParquetBackedIndex();
     * <p>Expected: population variance of (0..19) = 33.25.  
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index");
        bulkRequest.addParameter("refresh", "true");
     * {@code [count:Int64, sum:Float64]}; FINAL reduces each with SUM and a Project wraps  
            + "    \"value\": { \"type\": \"integer\" }"  
        assertEquals("VAR_SAMP(value) across shards should be " + expected, expected, actual, 0.001);
        double mean = (total - 1) / 2.0;
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
        double expected = (total - 1) / 2.0;  
        double sumSquares = 0;
        }
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats dc(value) as dc");
    private static final String INDEX = "coord_reduce_streaming_e2e";
        List<String> columns = extractColumnNames(result);  
        int total = NUM_SHARDS * DOCS_PER_SHARD;
        assertEquals("STDDEV_POP(value) across shards should be " + expected, expected, actual, 0.001);  
        createParquetBackedIndex();
    public void testStddevPopAcrossShards() throws Exception {
     * {@code stats var_pop(value) as v} — population variance. Reduced to  
     */
        }
    public void testAvgAcrossShards() throws Exception {  
            Object cell = row.get(idx);
        }  
    private static final int DOCS_PER_SHARD = 10;
     * <p>Expected: population stddev of (0..19) = sqrt(33.25) ≈ 5.766.  
    private void indexDeterministicDocs() throws Exception {
        Map<String, Object> result = executePpl("source = " + INDEX);  
     */
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        int total = NUM_SHARDS * DOCS_PER_SHARD;
    }
     *
     *
     * {@link org.opensearch.analytics.planner.rules.OpenSearchAggregateReduceRule} into
    /** Indexes {@code NUM_SHARDS * DOCS_PER_SHARD} docs with values produced by {@code valueFn}. */
            assertNotNull("value cell must not be null", cell);
     *
