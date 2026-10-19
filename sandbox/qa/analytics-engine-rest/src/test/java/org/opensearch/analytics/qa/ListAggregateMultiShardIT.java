 * this file be licensed under the Apache-2.0 license or a
            + "\"mappings\": {"
            + "}\n";  
        assertEquals("bulk ingest must report no item errors", Boolean.FALSE, bulkResp.get("errors"));  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
        health.addParameter("wait_for_status", "green");  
        List<String> actualSorted = actual.stream().map(String::valueOf).sorted().toList();  
        provision();
    }
            + "  \"index.pluggable.dataformat\": \"composite\","  
            expectedSorted.stream().sorted().toList(),  
            + "\"date_value\":\"2021-11-14 14:00:00\",\"ip_value\":\"127.0.0.2\""
/*  
    }
        // Two docs distributed across the 2 shards by _id hash. (The composite parquet+lucene
 */  
 * to the coordinator REDUCE stage. A regression (offset-1 field reference in the reduce-stage
        // dataformat rejects explicit _routing — "Field: _routing requests capability
    public void testListDoubleTwoShards() throws Exception {
        // exercised because the SINGLE list/values aggregate is gathered from all shards; the
            + "    \"keyword_value\":     { \"type\": \"keyword\" },"  
        assertMergedList("list", "long_value", List.of("1", "10"));
        provision();
            + "}"  
            + "    \"float_value\":       { \"type\": \"float\" },"
import java.util.Map;
    public void testListBinaryTwoShards() throws Exception {
    }  
 * SPDX-License-Identifier: Apache-2.0
        assertMergedList("list", "ip_value", List.of("127.0.0.1", "127.0.0.2"));  
        // assertions sort the merged list so they hold regardless of the exact 1/1 vs 2/0 split.
import java.util.List;  
        create.setJsonEntity(mapping);
            + "    \"date_value\":        { \"type\": \"date\", \"format\": \"yyyy-MM-dd HH:mm:ss\" },"  
        Map<String, Object> bulkResp = assertOkAndParse(client().performRequest(bulkRequest), "_bulk " + INDEX);
    }  
 * compatible open source license.
            + "  \"number_of_shards\": 2,"  
            + "  }"
    public void testListByteTwoShards() throws Exception {  
import org.opensearch.client.Request;
            + "{\"index\":{}}\n"
 * {@code execute_local_plan: CPU spawn failed: Panic { index out of bounds: the len is 1 but the
 *
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
    public void testListIntegerTwoShards() throws Exception {  
        provision();
            + "\"float_value\":60.2,\"double_value\":50.1,"
    public void testValuesKeywordTwoShards() throws Exception {  
}  
        provision();  
        assertMergedList("list", "binary_value", List.of("YWFh", "YmJi"));
        assertMergedList("list", "date_value", List.of("2020-10-13 13:00:00", "2021-11-14 14:00:00"));
            + "\"settings\": {"
            actualSorted
        provision();  
            + "}\n"
    public void testListLongTwoShards() throws Exception {
            + "\"keyword_value\":\"kw1\",\"text_value\":\"text1\","
        provision();  
            + "\"date_value\":\"2020-10-13 13:00:00\",\"ip_value\":\"127.0.0.1\""  
            + "    \"text_value\":        { \"type\": \"text\" },"
        Request create = new Request("PUT", "/" + INDEX);  
        bulkRequest.addParameter("refresh", "true");
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats " + fn + "(" + field + ") as l");
        Object cell = rows.get(0).get(columns.indexOf("l"));  
        assertMergedList("list", "float_value", List.of("6.2", "60.2"));  
    }  
    }
 *
    public void testListTextTwoShards() throws Exception {
        List<Object> actual = (List<Object>) cell;
            + "\"binary_value\":\"YWFh\","
    public void testListDateTwoShards() throws Exception {  
 * deterministic after sorting.  
        // FULL_TEXT_SEARCH" — so we rely on default _id routing.) The cross-shard reduce path is  
        client().performRequest(health);
    private void provision() throws Exception {
        assertMergedList("list", "keyword_value", List.of("kw1", "kw2"));
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
        assertEquals(
        health.addParameter("timeout", "30s");
    public void testListFloatTwoShards() throws Exception {
            + "},"  
            + "\"byte_value\":40,\"short_value\":30,\"integer_value\":20,\"long_value\":10,"
        String mapping = "{"
            + "\"float_value\":6.2,\"double_value\":5.1,"  
    }  
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");
            + "\"byte_value\":4,\"short_value\":3,\"integer_value\":2,\"long_value\":1,"
            + "\"binary_value\":\"YmJi\","
    public void testListIpTwoShards() throws Exception {
            + "  \"index.pluggable.dataformat.enabled\": true,"
            + "    \"byte_value\":        { \"type\": \"byte\" },"  
            + "    \"short_value\":       { \"type\": \"short\" },"
            + "  \"number_of_replicas\": 0,"
        provision();
        assertMergedList("list", "short_value", List.of("3", "30"));  
            + "    \"long_value\":        { \"type\": \"long\" },"  
    private static final String INDEX = "list_agg_multi_shard";
            + "    \"integer_value\":     { \"type\": \"integer\" },"
 * 2-shard {@code stats list(<field>)} / {@code values(<field>)} per element type.
        bulkRequest.setJsonEntity(bulk);  
    public void testListKeywordTwoShards() throws Exception {  
        provision();
        provision();
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));  
 */
            + "    \"ip_value\":          { \"type\": \"ip\" }"
        assertMergedList("values", "keyword_value", List.of("kw1", "kw2"));
package org.opensearch.analytics.qa;
    private void assertMergedList(String fn, String field, List<String> expectedSorted) throws Exception {
        provision();
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
 * index is 1 }}. Each shard contributes one element so the merged list is order-independent and
            + "{"  
            + "  \"index.composite.primary_data_format\": \"parquet\","
            + "    \"binary_value\":      { \"type\": \"binary\", \"store\": \"true\" },"
 * substrait against a single-column reduce input) panicked the native DataFusion lib with  
            + "  \"properties\": {"
            + "}";
        provision();
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "create " + INDEX);
            + "    \"double_value\":      { \"type\": \"double\" },"
        );
        List<String> columns = extractColumnNames(result);
            + "\"keyword_value\":\"kw2\",\"text_value\":\"text2\","  
        assertMergedList("list", "text_value", List.of("text1", "text2"));
            fn + "(" + field + ") merged across 2 shards (sorted)",
    }
        try {  
public class ListAggregateMultiShardIT extends AnalyticsRestTestCase {
        String bulk = "{\"index\":{}}\n"  
 * <p>Reproduces the cross-shard reduce path: {@code list}/{@code values} are STATE_EXPANDING, so  
        assertMergedList("list", "byte_value", List.of("4", "40"));
    }
        assertTrue(fn + "() must return a List, got " + (cell == null ? "null" : cell.getClass()), cell instanceof List);
 * The OpenSearch Contributors require contributions made to  
    }
        assertMergedList("list", "integer_value", List.of("2", "20"));
    }
        provision();
    }
    }  
    /** Runs {@code stats <fn>(<field>)} (no group-by) and asserts the merged, sorted list. */
    @SuppressWarnings("unchecked")  
            + "{"
        provision();  
 * {@code OpenSearchAggregateSplitRule} keeps them as a SINGLE aggregate and gathers both shards
    public void testValuesIntegerTwoShards() throws Exception {
            client().performRequest(new Request("DELETE", "/" + INDEX));
        assertTrue("columns must contain 'l', got " + columns, columns.contains("l"));
/**  
    public void testListShortTwoShards() throws Exception {
        assertMergedList("values", "integer_value", List.of("2", "20"));  
    }
        } catch (Exception ignored) {}
    }  
        assertMergedList("list", "double_value", List.of("5.1", "50.1"));
