        health.addParameter("wait_for_status", "green");
        String mapping = "{"  
 * The OpenSearch Contributors require contributions made to  
            + "}\n";
        assertSingleElement("boolean_value", "true");
package org.opensearch.analytics.qa;
        Request create = new Request("PUT", "/" + INDEX);
import java.util.Map;
        assertSingleElement("byte_value", "4");
 * this file be licensed under the Apache-2.0 license or a
        provision();  
            + "    \"byte_value\":        { \"type\": \"byte\" },"  
            + "    \"date_value\":        { \"type\": \"date\", \"format\": \"yyyy-MM-dd HH:mm:ss\" },"  
        assertSingleElement("date_nanos_value", "2019-03-24 01:34:46.123456789");
            + "\"text_value\":\"text\","  
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
            + "    \"float_value\":       { \"type\": \"float\" },"
            client().performRequest(new Request("DELETE", "/" + INDEX));  
 */  
    }
        provision();  
    public void testListBoolean() throws Exception {
        provision();
    }
            + "\"integer_value\":2,"
            + "  \"properties\": {"
    public void testListByte() throws Exception {
            + "    \"date_nanos_value\":  { \"type\": \"date_nanos\" },"
            + "    \"double_value\":      { \"type\": \"double\" },"
    }  
import java.util.List;  
        assertSingleElement("float_value", "6.2");  
        create.setJsonEntity(mapping);
    }
/*  
        assertEquals("list(" + field + ")[0]", expected, listed.get(0));
    public void testListDate() throws Exception {
            + "\"short_value\":3,"  
            + "    \"boolean_value\":     { \"type\": \"boolean\" },"
            + "  \"index.pluggable.dataformat\": \"composite\","
            + "\"double_value\":5.1,"
            + "\"date_value\":\"2020-10-13 13:00:00\","
public class ListAggregateMultiTypeIT extends AnalyticsRestTestCase {
            + "    \"text_value\":        { \"type\": \"text\" },"
        Request health = new Request("GET", "/_cluster/health/" + INDEX);  
        List<Object> listed = runListQuery(field);
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "create " + INDEX);  
        provision();  
    public void testListInteger() throws Exception {  
        assertSingleElement("binary_value", "U29tZSBiaW5hcnkgYmxvYg==");
        String bulk = "{\"index\":{}}\n"
    public void testListText() throws Exception {
    }  
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
            + "\"settings\": {"
        bulkRequest.setJsonEntity(bulk);
        try {
            + "  \"number_of_shards\": 1,"
        assertSingleElement("integer_value", "2");
    }
    @SuppressWarnings("unchecked")
            + "\"mappings\": {"  
            + "}";
        assertSingleElement("long_value", "1");
            + "\"float_value\":6.2,"  
    public void testListDateNanos() throws Exception {
            + "\"byte_value\":4,"
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
            + "    \"integer_value\":     { \"type\": \"integer\" },"
        // nanosecond precision preserved  
        provision();
    }
        provision();
    public void testListBinary() throws Exception {
        provision();
        provision();
        bulkRequest.addParameter("refresh", "true");  
        assertTrue("list() must return a List, got " + cell.getClass(), cell instanceof List);  
        assertTrue("columns must contain 'l', got " + columns, columns.contains("l"));
    public void testListLong() throws Exception {
            + "  }"  
        provision();
        provision();  
    private static final String INDEX = "list_agg_multi_type";  
    private void assertSingleElement(String field, Object expected) throws Exception {
        assertNotNull("schema must not be null", columns);  
    private void provision() throws Exception {
        assertSingleElement("short_value", "3");  
    }
            + "    \"ip_value\":          { \"type\": \"ip\" }"
    public void testListIp() throws Exception {  
    public void testListKeyword() throws Exception {
}
        assertSingleElement("keyword_value", "keyword");
        provision();
        List<String> columns = extractColumnNames(result);
        client().performRequest(bulkRequest);
        // temporal list element renders with space separator (not ISO 'T')  
        assertNotNull("cell for 'l' must not be null", cell);
    }
        return (List<Object>) cell;
            + "\"long_value\":1,"
        assertSingleElement("date_value", "2020-10-13 13:00:00");
        provision();  
    }
            + "{"  
    private List<Object> runListQuery(String field) throws Exception {
    public void testListDouble() throws Exception {  
        // list/values render booleans lowercase (String.valueOf), unlike cast/tostring's TRUE.
        Object cell = rows.get(0).get(columns.indexOf("l"));
            + "\"keyword_value\":\"keyword\","
            + "\"ip_value\":\"127.0.0.1\""
 * SPDX-License-Identifier: Apache-2.0
            + "}"
    }
        assertNotNull("rows must not be null", rows);
    public void testListShort() throws Exception {
    public void testListFloat() throws Exception {
            + "    \"keyword_value\":     { \"type\": \"keyword\" },"  
            + "\"boolean_value\":true,"
            + "    \"binary_value\":      { \"type\": \"binary\", \"store\": \"true\" },"
            + "    \"short_value\":       { \"type\": \"short\" },"
        } catch (Exception ignored) {}
        assertSingleElement("text_value", "text");  
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats list(" + field + ") as l");  
import org.opensearch.client.Request;
            + "  \"number_of_replicas\": 0,"  
    }  
            + "\"date_nanos_value\":\"2019-03-23T21:34:46.123456789-04:00\","  
            + "\"binary_value\":\"U29tZSBiaW5hcnkgYmxvYg==\","
            + "},"
 *
        client().performRequest(health);  
 * compatible open source license.
        assertSingleElement("double_value", "5.1");
    }
    }  
        assertEquals("list(" + field + ") must return exactly 1 element", 1, listed.size());  
    }
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
            + "    \"long_value\":        { \"type\": \"long\" },"  
            + "  \"index.composite.primary_data_format\": \"parquet\","  
        health.addParameter("timeout", "30s");
            + "  \"index.pluggable.dataformat.enabled\": true,"
    }  
        provision();
/** {@code stats list(<field>)} per element type — canonical forms (IP dotted-quad, binary base64, dates as configured). */  
        assertSingleElement("ip_value", "127.0.0.1");
