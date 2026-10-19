        Map<String, Object> result = executePpl(
            + "  \"properties\": {"
            + "\"settings\": {"
        String firstTs = String.valueOf(rows.get(0).get(tsIdx));
        try {
    }
                + "{\"ts\":\"2025-09-23T00:01:01.123456Z\",\"service\":\"checkout\",\"severity\":\"ERROR\",\"body\":\"failed order: payment declined\"}\n"
            + "    \"body\":     { \"type\": \"text\", \"store\": true }"
package org.opensearch.analytics.qa;
        assertEquals("4 matching docs across 2 shards", 4, rows.size());
                + "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"  
        String bulk =
        String body = "{"  
            + "  \"number_of_replicas\": 0,"  
import java.util.Map;
import org.opensearch.client.Response;
    private static final String INDEX = "late_mat_date_nanos_e2e";
    private void createParquetBackedIndex() throws Exception {
                + " | fields ts, severity, body"
            "source = " + INDEX
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull("Stitcher copyFromSafe trip returns no payload", rows);
        String lastTs = String.valueOf(rows.get(rows.size() - 1).get(tsIdx));  
            + "    \"severity\": { \"type\": \"keyword\"   },"
            + "    \"service\":  { \"type\": \"keyword\"   },"  
        assertTrue("expected >3 fractional digits in " + firstTs, firstTs.matches(".*\\.\\d{4,}.*"));
    private void indexDocs() throws Exception {
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
            + "    \"ts\":       { \"type\": \"date_nanos\" },"
        Response response = client().performRequest(createIndex);  
            + "}";
        bulkReq.addParameter("refresh", "true");
import org.opensearch.client.Request;
        @SuppressWarnings("unchecked")
            + "}"
        bulkReq.setJsonEntity(bulk);
import java.util.List;
        Request createIndex = new Request("PUT", "/" + INDEX);
                + "{\"ts\":\"2025-09-23T00:06:00.000000Z\",\"service\":\"checkout\",\"severity\":\"INFO\",\"body\":\"successful\"}\n";
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
                + "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"
    public void testMultiShardLateMatSortFetchOnDateNanos() throws Exception {
        indexDocs();  
        // `severity` is fetch-only (projected, not in filter/sort) — required for the LM rewriter
 *
                + "{\"ts\":\"2025-09-23T00:02:01.234567Z\",\"service\":\"checkout\",\"severity\":\"ERROR\",\"body\":\"failed order due to expired session\"}\n"  
 * compatible open source license.
                + "{\"ts\":\"2025-09-23T00:04:01.456789Z\",\"service\":\"checkout\",\"severity\":\"ERROR\",\"body\":\"failed gateway\"}\n"
            + "  \"index.pluggable.dataformat\": \"composite\","
                + "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"
        createIndex.setJsonEntity(body);
 * this file be licensed under the Apache-2.0 license or a
                + "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"
        assertTrue("DESC: first " + firstTs + " >= last " + lastTs, firstTs.compareTo(lastTs) >= 0);
        // sub-ms precision survives — pre-fix Stitcher silently coerces to ms (3 digits).  
public class LateMaterializationDateNanosIT extends AnalyticsRestTestCase {
        assertTrue("schema must contain 'body', got " + columns, columns.contains("body"));  
            + "  \"index.pluggable.dataformat.enabled\": true,"
 */  
        assertOkAndParse(client().performRequest(bulkReq), "Bulk index " + INDEX);  
            "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"  
        );
        int tsIdx = columns.indexOf("ts");
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
    }  
        // to fire; otherwise above ⊆ below and it skips, masking the bug.  
            client().performRequest(new Request("DELETE", "/" + INDEX));  
            + "},"
                + " | head 4"  
                + "{\"ts\":\"2025-09-23T00:03:01.345678Z\",\"service\":\"checkout\",\"severity\":\"WARN\",\"body\":\"failed order: inventory check\"}\n"
                + " | where match(body, 'failed') and service = 'checkout'"  
 * The OpenSearch Contributors require contributions made to  
    }
                + " | sort - ts"
            + "  \"number_of_shards\": " + NUM_SHARDS + ","
        createParquetBackedIndex();
        assertTrue("schema must contain 'severity', got " + columns, columns.contains("severity"));
}
    private static final int NUM_SHARDS = 2;
            + "  }"  
/** End-to-end test for late-materialization queries against a {@code date_nanos} timestamp on a multi-shard parquet index. */
/*  
        } catch (Exception ignored) {}
                + "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"
            + "  \"index.composite.primary_data_format\": \"parquet\","  
        List<String> columns = extractColumnNames(result);  
        Request bulkReq = new Request("POST", "/_bulk");  
        assertOkAndParse(response, "Create index " + INDEX);
        assertTrue("schema must contain 'ts', got " + columns, columns.contains("ts"));
                + "{\"ts\":\"2025-09-23T00:05:00.000000Z\",\"service\":\"frontend\",\"severity\":\"INFO\",\"body\":\"ok\"}\n"  
            + "\"mappings\": {"  
