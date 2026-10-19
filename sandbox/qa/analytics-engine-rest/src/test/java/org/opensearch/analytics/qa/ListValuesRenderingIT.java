    /** {@code values} on booleans: distinct, lowercase, sorted. */
    public void testValuesDropsNullsTwoShards() throws Exception {  
        } catch (Exception ignored) {}
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.Request;
            + "{\"num\":2,\"flag\":true}\n"  
        try {  
    /** Single shard: same lexicographic order, exercising the non-reduce path. */
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
 * this file be licensed under the Apache-2.0 license or a
            + "  \"number_of_shards\": " + shards + ","  
 * shards so the behaviour is verified on both the single-pass and coordinator-reduce paths.
    /** {@code list} renders booleans lowercase (String.valueOf), unlike cast/tostring's {@code TRUE}. */
    }  
    }  
        List<String> actual = runScalarAgg(fn, field);
            + "{\"num\":2,\"flag\":true}\n"
            + "{}\n";  
            + "  \"index.pluggable.dataformat\": \"composite\","  
            expectedSorted.stream().sorted().toList(),
 * <p>Distribution is by {@code _id} hash (the composite parquet+lucene dataformat rejects explicit
public class ListValuesRenderingIT extends AnalyticsRestTestCase {
        assertElements("list", "flag", List.of("false", "true", "true"));
        bulkRequest.addParameter("refresh", "true");  
        Request create = new Request("PUT", "/" + INDEX);
        provision(2);
 * {@code ListAggFunction}/{@code ValuesAggFunction} reference: null elements are dropped, booleans
        provision(1);
    }
    /** Asserts the elements in the exact emitted order (for sort verification). */
        assertOrderedElements("values", "num", List.of("10", "2"));
        String bulk = "{\"index\":{}}\n"
 * Element-rendering contract for PPL {@code list}/{@code values}, matching the opensearch-sql
            actual.stream().sorted().toList()  
        assertEquals(  
    }
        assertElements("list", "num", List.of("10", "2", "2"));
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));  
        Object cell = rows.get(0).get(columns.indexOf("l"));  
 * The OpenSearch Contributors require contributions made to  
/*  
            + "},"  
        assertOrderedElements("values", "num", List.of("10", "2"));
    public void testListDropsNullsTwoShards() throws Exception {  
            + "  \"num\":  { \"type\": \"integer\" },"
    private void assertOrderedElements(String fn, String field, List<String> expectedInOrder) throws Exception {
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    /** {@code values} returns distinct elements in lexicographic order ("10" &lt; "2"), not numeric. */
/**  
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
    }
    public void testValuesLexicographicSortTwoShards() throws Exception {  
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "create " + INDEX);
        provision(2);
        provision(2);
        assertEquals("bulk ingest must report no item errors", Boolean.FALSE, bulkResp.get("errors"));
            + "{\"index\":{}}\n"
            + "  \"index.composite.primary_data_format\": \"parquet\","
        bulkRequest.setJsonEntity(bulk);
    /** Asserts the merged element multiset (order-independent). */
        // num: 2, 10, 2, null   → list drops null (10,2,2); values distinct+sorted ("10","2")  
        client().performRequest(health);
            + "\"settings\": {"
 * {@code _routing}); a multi-digit numeric column makes lexicographic vs numeric ordering distinguishable.
            + "\"mappings\": { \"properties\": {"
        provision(2);
        // flag: true, false, true, (absent) → list (true,false,true); values ("false","true")
            client().performRequest(new Request("DELETE", "/" + INDEX));
    /** {@code values} drops null elements. */
        assertTrue(fn + "() must return a List, got " + (cell == null ? "null" : cell.getClass()), cell instanceof List);
    private List<String> runScalarAgg(String fn, String field) throws Exception {
    private void provision(int shards) throws Exception {
            + "{\"index\":{}}\n"
    public void testValuesLexicographicSortSingleShard() throws Exception {  
        health.addParameter("timeout", "30s");  
}
        assertOrderedElements("values", "flag", List.of("false", "true"));
 *  
            fn + "(" + field + ") elements (as multiset)",
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats " + fn + "(" + field + ") as l");
        Map<String, Object> bulkResp = assertOkAndParse(client().performRequest(bulkRequest), "_bulk " + INDEX);
    public void testValuesBooleanLowercaseTwoShards() throws Exception {  
import java.util.Map;
import java.util.List;  
            + "{\"num\":10,\"flag\":false}\n"
            + "{\"index\":{}}\n"  
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");
    }  
        health.addParameter("wait_for_status", "green");
    }  
 */  
        );
            + "  \"index.pluggable.dataformat.enabled\": true,"
    @SuppressWarnings("unchecked")  
    private void assertElements(String fn, String field, List<String> expectedSorted) throws Exception {
 * compatible open source license.
    private static final String INDEX = "list_values_rendering";  
 * and {@code values} returns distinct elements in lexicographic (string) order. Run at 1 and 2
        List<String> columns = extractColumnNames(result);  
    /** {@code list} drops null elements (no empty-string placeholders). */
            + "  \"flag\": { \"type\": \"boolean\" }"  
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        provision(2);
package org.opensearch.analytics.qa;
        assertElements("values", "num", List.of("10", "2"));
        create.setJsonEntity(mapping);  
        String mapping = "{"
    }  
    @SuppressWarnings("unchecked")  
 *
    public void testListBooleanLowercaseTwoShards() throws Exception {  
            + "  \"number_of_replicas\": 0,"
    }  
        assertEquals(fn + "(" + field + ") elements (ordered)", expectedInOrder, runScalarAgg(fn, field));  
        return ((List<Object>) cell).stream().map(String::valueOf).toList();
 */  
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
    }  
            + "} } }";
 * render lowercase ({@code true}/{@code false}, unlike {@code cast}/{@code tostring}'s {@code TRUE}),  
