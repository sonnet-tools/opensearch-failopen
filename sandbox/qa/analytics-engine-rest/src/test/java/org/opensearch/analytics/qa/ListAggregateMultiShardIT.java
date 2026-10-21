        assertMergedList("values", "integer_value", List.of("2", "20"));
    }
        String mapping = "{"
            + "{"
        assertEquals(
    }
        health.addParameter("timeout", "30s");
            + "\"keyword_value\":\"kw1\",\"text_value\":\"text1\","
import org.opensearch.client.Request;
    public void testListLongTwoShards() throws Exception {
            + "\"float_value\":6.2,\"double_value\":5.1,"
        bulkRequest.addParameter("refresh", "true");
        assertTrue("columns must contain 'l', got " + columns, columns.contains("l"));
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
 * substrait against a single-column reduce input) panicked the native DataFusion lib with
        Object cell = rows.get(0).get(columns.indexOf("l"));
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats " + fn + "(" + field + ") as l");
 * deterministic after sorting.
        provision();
 * compatible open source license.
        assertEquals("bulk ingest must report no item errors", Boolean.FALSE, bulkResp.get("errors"));
package org.opensearch.analytics.qa;
            + "\"byte_value\":4,\"short_value\":3,\"integer_value\":2,\"long_value\":1,"
            expectedSorted.stream().sorted().toList(),
}
        assertMergedList("list", "binary_value", List.of("YWFh", "YmJi"));
        provision();
    }
 * {@code execute_local_plan: CPU spawn failed: Panic { index out of bounds: the len is 1 but the
 * 2-shard {@code stats list(<field>)} / {@code values(<field>)} per element type.
            + "  \"index.composite.primary_data_format\": \"parquet\","
        provision();
    public void testListTextTwoShards() throws Exception {
            + "},"
    }
    public void testListIntegerTwoShards() throws Exception {
            + "  \"number_of_shards\": 2,"
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
            + "    \"text_value\":        { \"type\": \"text\" },"
/*
        Map<String, Object> bulkResp = assertOkAndParse(client().performRequest(bulkRequest), "_bulk " + INDEX);
    }
            + "\"binary_value\":\"YWFh\","
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "create " + INDEX);
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
 * <p>Reproduces the cross-shard reduce path: {@code list}/{@code values} are STATE_EXPANDING, so
            + "\"byte_value\":40,\"short_value\":30,\"integer_value\":20,\"long_value\":10,"
public class ListAggregateMultiShardIT extends AnalyticsRestTestCase {
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
            fn + "(" + field + ") merged across 2 shards (sorted)",
            actualSorted
        // exercised because the SINGLE list/values aggregate is gathered from all shards; the
    }
        );
 * index is 1 }}. Each shard contributes one element so the merged list is order-independent and
            + "  }"
        assertMergedList("list", "float_value", List.of("6.2", "60.2"));
        assertMergedList("list", "double_value", List.of("5.1", "50.1"));
        List<String> actualSorted = actual.stream().map(String::valueOf).sorted().toList();
        assertMergedList("list", "keyword_value", List.of("kw1", "kw2"));
            + "}\n";
        provision();
            + "{"
        // Two docs distributed across the 2 shards by _id hash. (The composite parquet+lucene
        provision();
    public void testListFloatTwoShards() throws Exception {
            + "    \"short_value\":       { \"type\": \"short\" },"
            + "  \"properties\": {"
        assertMergedList("list", "byte_value", List.of("4", "40"));
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");
            + "  \"number_of_replicas\": 0,"
        bulkRequest.setJsonEntity(bulk);
            + "{\"index\":{}}\n"
        List<Object> actual = (List<Object>) cell;
            + "    \"double_value\":      { \"type\": \"double\" },"
    @SuppressWarnings("unchecked")
            + "    \"float_value\":       { \"type\": \"float\" },"
        provision();
            + "\"mappings\": {"
    public void testListDoubleTwoShards() throws Exception {
        List<String> columns = extractColumnNames(result);
        assertMergedList("list", "short_value", List.of("3", "30"));
    private void provision() throws Exception {
 * The OpenSearch Contributors require contributions made to
        client().performRequest(health);
    private static final String INDEX = "list_agg_multi_shard";
        assertMergedList("list", "long_value", List.of("1", "10"));
 */
        assertMergedList("values", "keyword_value", List.of("kw1", "kw2"));
 * this file be licensed under the Apache-2.0 license or a
            + "\"float_value\":60.2,\"double_value\":50.1,"
            + "    \"date_value\":        { \"type\": \"date\", \"format\": \"yyyy-MM-dd HH:mm:ss\" },"
    public void testValuesKeywordTwoShards() throws Exception {
        Request create = new Request("PUT", "/" + INDEX);
    public void testListIpTwoShards() throws Exception {
        assertTrue(fn + "() must return a List, got " + (cell == null ? "null" : cell.getClass()), cell instanceof List);
    public void testListByteTwoShards() throws Exception {
import java.util.Map;
            + "  \"index.pluggable.dataformat\": \"composite\","
 * to the coordinator REDUCE stage. A regression (offset-1 field reference in the reduce-stage
 */
    }
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
        provision();
            + "\"settings\": {"
            + "\"date_value\":\"2021-11-14 14:00:00\",\"ip_value\":\"127.0.0.2\""
        provision();
        provision();
            + "    \"binary_value\":      { \"type\": \"binary\", \"store\": \"true\" },"
        // assertions sort the merged list so they hold regardless of the exact 1/1 vs 2/0 split.
        String bulk = "{\"index\":{}}\n"
            + "    \"byte_value\":        { \"type\": \"byte\" },"
            + "}"
    public void testListDateTwoShards() throws Exception {
        try {
 *
        // dataformat rejects explicit _routing — "Field: _routing requests capability
            + "}\n"
    public void testValuesIntegerTwoShards() throws Exception {
            + "    \"keyword_value\":     { \"type\": \"keyword\" },"
            + "    \"ip_value\":          { \"type\": \"ip\" }"
            + "\"keyword_value\":\"kw2\",\"text_value\":\"text2\","
import java.util.List;
    private void assertMergedList(String fn, String field, List<String> expectedSorted) throws Exception {
            + "\"binary_value\":\"YmJi\","
        } catch (Exception ignored) {}
            + "}";
    }
    /** Runs {@code stats <fn>(<field>)} (no group-by) and asserts the merged, sorted list. */
 *
            + "    \"integer_value\":     { \"type\": \"integer\" },"
        health.addParameter("wait_for_status", "green");
    }
        assertMergedList("list", "ip_value", List.of("127.0.0.1", "127.0.0.2"));
    public void testListShortTwoShards() throws Exception {
    }
            client().performRequest(new Request("DELETE", "/" + INDEX));
        assertMergedList("list", "date_value", List.of("2020-10-13 13:00:00", "2021-11-14 14:00:00"));
    }
        provision();
    }
    }
        provision();
        assertMergedList("list", "text_value", List.of("text1", "text2"));
        create.setJsonEntity(mapping);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
 * SPDX-License-Identifier: Apache-2.0
/**
            + "\"date_value\":\"2020-10-13 13:00:00\",\"ip_value\":\"127.0.0.1\""
    public void testListKeywordTwoShards() throws Exception {
    }
        // FULL_TEXT_SEARCH" — so we rely on default _id routing.) The cross-shard reduce path is
        provision();
        provision();
    }
 * {@code OpenSearchAggregateSplitRule} keeps them as a SINGLE aggregate and gathers both shards
            + "    \"long_value\":        { \"type\": \"long\" },"
            + "  \"index.pluggable.dataformat.enabled\": true,"
    public void testListBinaryTwoShards() throws Exception {
        assertMergedList("list", "integer_value", List.of("2", "20"));
