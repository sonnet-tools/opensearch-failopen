    /** {@code list(scalar) by <int key>} over 2 shards → one row per group. */  
        client().performRequest(health);
    public void testListByIntGroupTwoShards() throws Exception {
            + "},"
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
            + "  \"index.composite.primary_data_format\": \"parquet\","  
            + "    \"grp\":       { \"type\": \"integer\" },"  
        List<String> cols = extractColumnNames(result);
    }
            + "}";
            + "  \"properties\": {"
import java.util.Map;
 * STATE_EXPANDING, so they skip the partial/final split and run as a SINGLE aggregate gathered to  
            + "{\"index\":{}}\n"  
 * reduce-stage stitch).  
    public void testListByStringGroupTwoShards() throws Exception {
import java.util.List;  
 * The OpenSearch Contributors require contributions made to  
/**  
    @SuppressWarnings("unchecked")
        Request create = new Request("PUT", "/" + INDEX);  
public class GroupedListAggregateMultiShardIT extends AnalyticsRestTestCase {
 * Grouped {@code list(<scalar>) by <key>} across two shards — the grouped sibling of the no-group
 * compatible open source license.
        Request bulkRequest = new Request("POST", "/" + INDEX + "/_bulk");
        provision();  
            + "{\"index\":{}}\n"
import org.opensearch.client.Request;
        List<String> cols = extractColumnNames(result);
            + "{\"num_value\":30,\"grp\":1,\"str_value\":\"x\"}\n"
            client().performRequest(new Request("DELETE", "/" + INDEX));  
            + "{\"num_value\":10,\"grp\":1,\"str_value\":\"x\"}\n"  
    }
        String bulk = "{\"index\":{}}\n"
/*  
        assertEquals("two groups (str_value ∈ {x,y}) → two rows", 2, rows.size());
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
        try {
        assertTrue("columns must contain 'l' and 'str_value', got " + cols, cols.contains("l") && cols.contains("str_value"));
 * <p>Data is distributed across both shards by default {@code _id} hash so the reduce stage merges
    private static final String INDEX = "grouped_list_multi_shard";
        } catch (Exception ignored) {}
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));  
 */  
        create.setJsonEntity(mapping);
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats list(num_value) as l by str_value");  
    private void provision() throws Exception {
            + "    \"str_value\": { \"type\": \"keyword\" }"
            + "  \"index.pluggable.dataformat\": \"composite\","
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "create " + INDEX);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
            + "{\"num_value\":40,\"grp\":2,\"str_value\":\"y\"}\n";  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
    /** {@code list(scalar) by <string key>} over 2 shards → one row per group. */
        // 4 docs distributed across the 2 shards by _id hash. grp ∈ {1,2}, str_value ∈ {x,y}.
        String mapping = "{"  
        bulkRequest.addParameter("refresh", "true");
            + "\"settings\": {"
 * scalar→VARCHAR cast rides the Substrait measure arg (so no lifted Project can be dropped by the
package org.opensearch.analytics.qa;
        assertTrue("columns must contain 'l' and 'grp', got " + cols, cols.contains("l") && cols.contains("grp"));  
    @SuppressWarnings("unchecked")  
        health.addParameter("timeout", "30s");
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
        Map<String, Object> bulkResp = assertOkAndParse(client().performRequest(bulkRequest), "_bulk " + INDEX);
 *
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats list(num_value) as l by grp");
        provision();
            + "{\"index\":{}}\n"
        health.addParameter("wait_for_status", "green");  
 *
 * the coordinator reduce stage; adding a group key keeps that shape. These pass once the
        assertEquals("two groups (grp ∈ {1,2}) → two rows", 2, rows.size());
            + "{\"num_value\":20,\"grp\":2,\"str_value\":\"y\"}\n"
 * this file be licensed under the Apache-2.0 license or a
}  
            + "  \"number_of_replicas\": 0,"  
            + "  \"number_of_shards\": 2,"
 * SPDX-License-Identifier: Apache-2.0
 * scalar list/values reduce panic covered by {@link ListAggregateMultiShardIT}. list/values are
        assertEquals("bulk ingest must report no item errors", Boolean.FALSE, bulkResp.get("errors"));  
 * two partitions. (The composite parquet+lucene dataformat rejects explicit {@code _routing}.)  
            + "\"mappings\": {"  
            + "  }"
    }  
        bulkRequest.setJsonEntity(bulk);  
 */
            + "    \"num_value\": { \"type\": \"integer\" },"
            + "  \"index.pluggable.dataformat.enabled\": true,"
            + "}"  
