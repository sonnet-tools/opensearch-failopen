        // Expected: AVG(0, 1, ..., total-1) = (total - 1) / 2.0
public class StreamingCoordinatorReduceIT extends AnalyticsRestTestCase {
 * deterministic dataset, but with Arrow Flight RPC streaming enabled. Exercises the
    public void testDistinctCountAcrossShards() throws Exception {
        indexValuedDocs(i -> i);
        String body = "{"
            bulk.append("{\"value\": ").append(VALUE).append("}\n");
    /**
     * answer than the correct cross-shard merge.
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
        int total = NUM_SHARDS * DOCS_PER_SHARD;
     * {@link org.opensearch.analytics.planner.rules.OpenSearchAggregateReduceRule} into
     * single-field intermediate path over streaming.
        int total = NUM_SHARDS * DOCS_PER_SHARD;
        createParquetBackedIndex();
    }
     */
    /**
        double sumSquares = 0;
        assertNotNull("schema must not be null", columns);
        createParquetBackedIndex();
        double mean = (total - 1) / 2.0;
     * {@code stats dc(value) as dc} — engine-native HLL merge. PARTIAL emits a single Binary
     * easily covers the variance.
        int total = NUM_SHARDS * DOCS_PER_SHARD;
        assertEquals("all docs across shards must be returned", expectedRows, rows.size());
     *
    /** Indexes {@code NUM_SHARDS * DOCS_PER_SHARD} docs with values produced by {@code valueFn}. */
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");
     * <p>Expected: population variance of (0..19) = 33.25.
     * {@code stats avg(value) as a} — primitive decomposition. PARTIAL emits
     */
import java.util.List;
            + "  \"number_of_replicas\": 0,"
        createParquetBackedIndex();
    public void testVarPopAcrossShards() throws Exception {
package org.opensearch.analytics.qa;
    private static List<List<Object>> scalarRows(Map<String, Object> result, String columnName) {
        double sumSquares = 0;
        int total = NUM_SHARDS * DOCS_PER_SHARD;
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
import java.util.function.IntUnaryOperator;
        @SuppressWarnings("unchecked")
     * POWER(variance, 0.5).
     * SUM, SUM-of-squares, and COUNT primitives at HEP-marking time, then finalised with
        double expected = Math.sqrt(sumSquares / (total - 1));
            + "  \"index.pluggable.dataformat.enabled\": true,"
    private static final int VALUE = 7;
    }
    }
/*
     *
        createIndex.setJsonEntity(body);
     * {@code SUM((x - mean)^2) / N}, the same primitives as STDDEV_POP minus the final sqrt.
 * this file be licensed under the Apache-2.0 license or a
    public void testStddevSampAcrossShards() throws Exception {
            sumSquares += (i - mean) * (i - mean);
        double expected = sumSquares / total;
        Object cell = rows.get(0).get(columns.indexOf(columnName));
        createParquetBackedIndex();
        double expected = (total - 1) / 2.0;
        indexValuedDocs(i -> i);
import java.util.Map;
        client().performRequest(bulkRequest);
        assertEquals("AVG(value) across shards should be " + expected, expected, actual, 0.001);
            + "  \"index.pluggable.dataformat\": \"composite\","
        bulkRequest.addParameter("refresh", "true");
        }
     * <p>Expected: sample variance of (0..19) = 35.0.
     *
        assertNotNull("cell for '" + columnName + "' must not be null — coordinator-reduce returned no value", cell);
     */
    }
        assertEquals("STDDEV_POP(value) across shards should be " + expected, expected, actual, 0.001);
     * <p>Tolerance is 10% — HLL is approximate; with 20 distinct values the error margin
        Map<String, Object> result = executePpl("source = " + INDEX);
            sumSquares += (i - mean) * (i - mean);
        assertTrue("columns must contain '" + columnName + "', got " + columns, columns.contains(columnName));
    }
 * shard-fragment → Flight → DatafusionReduceSink.feed handoff that previously failed with
        int total = NUM_SHARDS * DOCS_PER_SHARD;
        }
            + "  }"
        for (int i = 0; i < total; i++) {
     *
        int total = NUM_SHARDS * DOCS_PER_SHARD;
            + "}"
            sumSquares += (i - mean) * (i - mean);
        double mean = (total - 1) / 2.0;
 *
        for (int i = 0; i < total; i++) {
        double mean = (total - 1) / 2.0;
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats stddev_pop(value) as s");
        Request createIndex = new Request("PUT", "/" + INDEX);
     * sketch column per shard; FINAL invokes DataFusion's {@code approx_distinct} merge
 * Streaming variant of {@link CoordinatorReduceIT}: same 2-shard parquet-backed index and
     */
        int total = NUM_SHARDS * DOCS_PER_SHARD;
    private void createParquetBackedIndex() throws Exception {
    public void testBaselineScanAcrossShards() throws Exception {
            bulk.append("{\"index\": {}}\n");
        @SuppressWarnings("unchecked")
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index");
        client().performRequest(bulkRequest);
     * {@code finalExpression = sum/count}. Exercises the multi-field intermediate path over
        indexValuedDocs(i -> i);
     * {@code stats var_samp(value) as v} — sample variance. Reduced to
        @SuppressWarnings("unchecked")
 *
     * coordinator merges them, then divides.
     * {@code source = T} on a 2-shard parquet-backed index with streaming enabled exercises the
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
 * (configured via the {@code integTestStreaming} task in build.gradle).
 * The OpenSearch Contributors require contributions made to
     * <p>Expected: population stddev of (0..19) = sqrt(33.25) ≈ 5.766.
     * per-shard pass-through (e.g. concatenating partial AVGs) would yield a different
 */
            client().performRequest(new Request("DELETE", "/" + INDEX));
            assertNotNull("value cell must not be null", cell);
}
 * multi-shard queries.
 * SPDX-License-Identifier: Apache-2.0
        }
        int total = NUM_SHARDS * DOCS_PER_SHARD;
    /**
        double expected = Math.sqrt(sumSquares / total);
     * {@code [count:Int64, sum:Float64]}; FINAL reduces each with SUM and a Project wraps
    private void indexValuedDocs(IntUnaryOperator valueFn) throws Exception {
    private static final String INDEX = "coord_reduce_streaming_e2e";
            bulk.append("{\"value\": ").append(valueFn.applyAsInt(i)).append("}\n");
     * <p>Uses varied per-doc values (value = doc index) so the AVG is non-trivial — a
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats var_pop(value) as v");
     */
    public void testAvgAcrossShards() throws Exception {
        List<List<Object>> rows = scalarRows(result, "dc");
        createParquetBackedIndex();
            + "  \"index.composite.primary_data_format\": \"parquet\","
        double sumSquares = 0;
        for (int i = 0; i < total; i++) {
    private void indexDeterministicDocs() throws Exception {
        assertEquals("STDDEV_SAMP(value) across shards should be " + expected, expected, actual, 0.001);
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats avg(value) as a");
        for (int i = 0; i < total; i++) {
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");
     * which combines sketches across shards. Exercises the engine-native (reducer == self)
    public void testVarSampAcrossShards() throws Exception {
        client().performRequest(health);
        assertEquals("VAR_POP(value) across shards should be " + expected, expected, actual, 0.001);
     * {@code stats stddev_pop(value) as s} — multi-field statistical aggregate. Reduced by
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        double sumSquares = 0;
        List<List<Object>> rows = scalarRows(result, "a");
     * {@code SUM((x - mean)^2) / (N - 1)}.
        assertEquals("VAR_SAMP(value) across shards should be " + expected, expected, actual, 0.001);
    /**
        assertNotNull("schema must not be null", columns);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        int expectedRows = NUM_SHARDS * DOCS_PER_SHARD;
        indexDeterministicDocs();
        health.addParameter("timeout", "30s");
        for (int i = 0; i < total; i++) {
        }
        assertTrue(
        );
        for (int i = 0; i < total; i++) {
        List<String> columns = extractColumnNames(result);
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
        }
            + "},"
        List<List<Object>> rows = scalarRows(result, "v");
     * {@code sqrt(SUM((x - mean)^2) / (N - 1))}. Same reduction path as STDDEV_POP but
     */
     * {@code stats var_pop(value) as v} — population variance. Reduced to
        double mean = (total - 1) / 2.0;
        indexValuedDocs(i -> i);
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats stddev_samp(value) as s");
        try {
            + "}";
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
    }
/**
        }
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats var_samp(value) as v");
            actual >= (long) (total * 0.9) && actual <= (long) (total * 1.1)
 */
            Object cell = row.get(idx);
        assertNotNull("rows must not be null", rows);
        indexValuedDocs(i -> i); // all distinct
        assertTrue("columns must contain 'value', got " + columns, columns.contains("value"));
    private static final int DOCS_PER_SHARD = 10;
    /**
            + "\"settings\": {"
     * {@code stats stddev_samp(value) as s} — sample standard deviation. Reduced to
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats dc(value) as dc");
    private static final int NUM_SHARDS = 2;
    }
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
    public void testStddevPopAcrossShards() throws Exception {
        List<List<Object>> rows = scalarRows(result, "s");
        int idx = columns.indexOf("value");
     * <p>Expected: sample stddev of (0..19) = sqrt(sum((i - mean)^2) / (N - 1)) = sqrt(35) ≈ 5.916.
    /**
    /** Local copy of {@code CoordinatorReduceIT.scalarRows} (the original is package-private). */
 * "A buffer can only be associated between two allocators that share the same root" on
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
        createParquetBackedIndex();
 * compatible open source license.
        bulkRequest.setJsonEntity(bulk.toString());
        createParquetBackedIndex();
            assertEquals("every doc has value=" + VALUE, (long) VALUE, ((Number) cell).longValue());
        assertNotNull("rows must not be null", rows);
            sumSquares += (i - mean) * (i - mean);
            + "    \"value\": { \"type\": \"integer\" }"
        }
        @SuppressWarnings("unchecked")
        List<List<Object>> rows = scalarRows(result, "v");
            "dc(value) should be approximately " + total + " (±10%), got " + actual,
        bulkRequest.addParameter("refresh", "true");
    }
        List<List<Object>> rows = scalarRows(result, "s");
        indexValuedDocs(i -> i);
            bulk.append("{\"index\": {}}\n");
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
    /**
        for (List<Object> row : rows) {
        return rows;
 * <p>Requires a dedicated cluster configuration with the stream transport feature flag enabled
    }
        List<String> columns = extractColumnNames(result);
        bulkRequest.setJsonEntity(bulk.toString());
        health.addParameter("wait_for_status", "green");
    }
            + "\"mappings\": {"
            + "  \"number_of_shards\": " + NUM_SHARDS + ","
        } catch (Exception ignored) {}
     * the streaming reduce-sink: each shard ships sum + count intermediates via Flight, the
        long actual = ((Number) rows.get(0).get(0)).longValue();
        StringBuilder bulk = new StringBuilder();
     */
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
     * coordinator reduce sink's cross-plugin VectorSchemaRoot handoff.
     * with Bessel's correction in the denominator.
    }
import org.opensearch.client.Response;
     *
            + "  \"properties\": {"
        double expected = sumSquares / (total - 1);
        StringBuilder bulk = new StringBuilder();
     *
import org.opensearch.client.Request;
