        Request bulkReq = new Request("POST", "/_bulk");
            + "  \"index.composite.primary_data_format\": \"parquet\","
        indexDocs();  
import java.util.List;
        Object first = rows.get(0).get(idx);
import org.opensearch.client.Request;
    public void testMultiShardSortOnDateNanosWithDateOnlyFormat() throws Exception {
            + "  \"index.composite.secondary_data_formats\": \"lucene\""  
        String bulk = "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"
 */  
 *
public class DateNanosUDTPrecisionIT extends AnalyticsRestTestCase {
        Map<String, Object> result = executePpl("source = " + INDEX + " | sort d | fields d");
 * The OpenSearch Contributors require contributions made to  
    private static final int NUM_SHARDS = 2;
        // Force parquet flush so the multi-shard read path is exercised on Timestamp(Nanosecond).  
    }
        );  
            + "  \"index.pluggable.dataformat\": \"composite\","
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
            + "}"  
        Response response = client().performRequest(createIndex);
            + "  \"number_of_replicas\": 0,"
            client().performRequest(new Request("DELETE", "/" + INDEX));
            + "  }"
 *
            first.toString().compareTo(last.toString()) <= 0
            + "{\"d\":\"20240103\"}\n"
        try {
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
        String body = "{"
}  
        assertOkAndParse(response, "Create index " + INDEX);  
            + "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"
 * this file be licensed under the Apache-2.0 license or a
            + "},"
 *
        Object last = rows.get(rows.size() - 1).get(idx);  
import org.opensearch.client.Response;
            + "  \"properties\": {"  
        createIndex.setJsonEntity(body);
/**
            + "  \"index.pluggable.dataformat.enabled\": true,"  
        assertTrue("schema must contain 'd' column, got " + columns, columns.contains("d"));
 * SPDX-License-Identifier: Apache-2.0
        List<String> columns = extractColumnNames(result);
            + "\"settings\": {"  
            + "{\"d\":\"20240101\"}\n"  
        Request createIndex = new Request("PUT", "/" + INDEX);  
            + "{\"d\":\"20240102\"}\n"
 * <p>This IT runs a multi-shard sort against such an index. Pre-fix it returns HTTP 500 with
            + "\"mappings\": {"
package org.opensearch.analytics.qa;
            + "    \"d\": { \"type\": \"date_nanos\", \"format\": \"basic_date\" }"
        assertNotNull("last row 'd' must not be null", last);
 * <p>The bug: a {@code date_nanos} field with a date-only or time-only mapping format takes the
            + "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"  
/*  
        @SuppressWarnings("unchecked")
 * parquet reads {@code Timestamp(Nanosecond)} from disk, so the coordinator-reduce RowConverter
    private void createParquetBackedIndex() throws Exception {  
            + "{\"d\":\"20240104\"}\n";  
    private static final String INDEX = "date_nanos_udt_precision_e2e";
        assertNotNull("first row 'd' must not be null", first);
            + "}";
 * switch added by #22049. The schema reports the column as {@code TIMESTAMP(0)} (millis) while
        // 4 docs, two distinct dates, spread across shards by id parity. basic_date is yyyymmdd.
        createParquetBackedIndex();
 * UDT branch in {@code OpenSearchSchemaBuilder.buildLeafType}, bypassing the precision-3/9  
    }
import java.util.Map;
 * when the underlying field is {@code date_nanos}.  
    private void indexDocs() throws Exception {  
 */
 * fails on a multi-shard sort with {@code Timestamp(ms) got Timestamp(ns)}.  
        assertEquals("All 4 docs must surface across the 2 shards", 4, rows.size());
        // Verify ascending order by date — the actual sort the bug breaks.  
 * the RowConverter mismatch; post-fix the sort completes and the rows come back in order.  
 * compatible open source license.
            "Sort must order 'd' ascending; first=" + first + " last=" + last,
        assertNotNull("rows must not be null — RowConverter mismatch returns no payload", rows);  
        bulkReq.setJsonEntity(bulk);  
        bulkReq.addParameter("refresh", "true");
        } catch (Exception ignored) {}  
        int idx = columns.indexOf("d");
        assertOkAndParse(client().performRequest(bulkReq), "Bulk index " + INDEX);
            + "{\"index\":{\"_index\":\"" + INDEX + "\"}}\n"
    }
            + "  \"number_of_shards\": " + NUM_SHARDS + ","
        assertTrue(  
 * Regression gate for {@code DateOnlyType} / {@code TimeOnlyType} carrying sub-second precision
