                + "\",\""
            1,
        assertAbsentCell(byId.get(5));
import java.util.Set;  
                + "{\"index\":{}}\n"
        Map.of(
        return copy;  
                out.put(key, value.longValue());
            }
 *   6 | [ünï-cødé, 日本語]        | ap     | 60      (non-ASCII elements)  
/**  
 *   2 | [red, green]             | eu     | 20
                + UNICODE_A
        }
                if (i > 0) {
        groups.forEach((key, value) -> {  
                + UNICODE_B  
                + "{\"index\":{}}\n"  
        int[] keyIndexes = new int[keyColumns.length];
            bulkRequest.setJsonEntity(bulk);
                + "}}"  
        int tagsColumn = column(result, "tags");
                    key.append('|');
        Map<Integer, Object> byId = new HashMap<>();
    protected static void assertAbsentCell(Object cell) {
            Number previous = out.put(key.toString(), (Number) row.get(valueIndex));  
            6,
        copy.sort(String::compareTo);
            List.of("red", "green"),
    @Override
 * Shared fixture for end-to-end {@code multi_value: true} keyword coverage.
    }  
            for (String part : key.split("\\|", -1)) {
        return (List<List<Object>>) datarows;
        assertEquals("row count", 6, byId.size());  
        }
        provision(TWO_SHARD_INDEX, 2);
            Request create = new Request("PUT", "/" + index);  
                + "  \"number_of_replicas\": 0,"
            List.of(UNICODE_A, UNICODE_B)
    }  
import java.util.HashSet;  
    }
                key.append(String.valueOf(row.get(keyIndexes[i])));
        for (List<Object> row : rows(result)) {
        assertNotNull("response has no datarows: " + result, datarows);
        assertTrue("expected column '" + name + "' in " + columns, index >= 0);
            assertNull("duplicate group key '" + key + "' in " + rows(result), previous);
    /** Expected {@code tags} cell per document id; {@code null} marks the absent-field document. */
            String bulk = "{\"index\":{}}\n"
        }
            List.of(),  
 * </pre>
                + "{\"id\":2,\"tags\":[\"red\",\"green\"],\"region\":\"eu\",\"latency\":20}\n"
 *  ---+--------------------------+--------+--------  
    @SuppressWarnings("unchecked")
        for (List<Object> row : rows(result)) {  
    /** The absent-field document must render as SQL NULL or an empty LIST, never as a synthetic element. */
    // ---- response helpers -------------------------------------------------------------------
    protected static List<String> strings(Object cell) {
        List<String> columns = extractColumnNames(result);  
        return byId;
    }
        if (cell != null) {  
 *   3 | [blue]                   | us     | 30      (single element)  
                + "}";
    }
            client().performRequest(health);
                client().performRequest(new Request("DELETE", "/" + index));
            flush.addParameter("force", "true");
 * assert parity between the two execution shapes.
import org.opensearch.client.Request;
    }  
        Map<String, Long> out = new TreeMap<>();
                + "{\"id\":4,\"tags\":[],\"region\":\"eu\",\"latency\":40}\n"
    /** Coerce a LIST cell to strings, preserving element order and duplicates. */  
            List.of("blue"),
            Map<String, Object> response = assertOkAndParse(client().performRequest(create), "create " + index);
    }
    protected static final String ONE_SHARD_INDEX = "mv_e2e_one_shard";  
                + "  \"index.pluggable.dataformat.enabled\": true,"
        return out;
            Map<String, Object> bulkResponse = assertOkAndParse(client().performRequest(bulkRequest), "_bulk " + index);  
            3,  
            }  
 */  
 * <pre>
        List<String> copy = new ArrayList<>(values);
package org.opensearch.analytics.qa;
        }
                + "\"mappings\": {\"properties\": {"
                + "  \"tags\": {\"type\": \"keyword\", \"multi_value\": true},"  
    protected static Map<String, Number> groups(Map<String, Object> result, String valueColumn, String... keyColumns) {  
        provision(ONE_SHARD_INDEX, 1);
    protected static Map<String, Long> nonNullCounts(Map<String, Number> groups) {
    }
/*  
            Object previous = byId.put(((Number) row.get(idColumn)).intValue(), row.get(tagsColumn));
    /** Map each row's {@code id} to its raw {@code tags} cell (LIST, or null for the absent document). */
        Object datarows = result.get("datarows");  
                + "{\"id\":5,\"region\":\"us\",\"latency\":50}\n"
                + "{\"id\":6,\"tags\":[\""  
 * compatible open source license.
    }  
        return out;  
        synchronized (PROVISIONED) {  
                + "{\"index\":{}}\n"
    /** Sorted multiset view of a LIST cell, for assertions that do not depend on element order. */
    }
        for (Map.Entry<Integer, List<String>> expected : EXPECTED_TAGS.entrySet()) {
 *
    /** Collect {@code (key columns..., value)} rows into a map keyed by the joined string of the group keys. */
            assertNull("duplicate id in projection: " + row, previous);
                }
        return index;  
        }  
    protected static void assertFixtureTags(Map<Integer, Object> byId) {
                if ("null".equals(part)) {  
            if (PROVISIONED.contains(index)) {
    private static final Set<String> PROVISIONED = new HashSet<>();  
 *   1 | [blue, blue, red]        | us     | 10      (in-document duplicate)
 *
                + "{\"id\":1,\"tags\":[\"blue\",\"blue\",\"red\"],\"region\":\"us\",\"latency\":10}\n"
}
            } catch (Exception ignored) {}  
 *  id | tags                     | region | latency
            assertEquals("tags for id=" + expected.getKey(), expected.getValue(), strings(byId.get(expected.getKey())));
 *   5 | (absent)                 | us     | 50      (field missing from _source)
            keyIndexes[i] = column(result, keyColumns[i]);
    );
 * <p>Provisions the same six documents into a two-shard index (distributed: shard fragments,  
                + shards
            assertEquals("index creation must be acknowledged", Boolean.TRUE, response.get("acknowledged"));  
            for (int i = 0; i < keyIndexes.length; i++) {  
 *   4 | []                       | eu     | 40      (empty array)
 * this file be licensed under the Apache-2.0 license or a
            Request flush = new Request("POST", "/" + index + "/_flush");  
            }  
    protected static final String TWO_SHARD_INDEX = "mv_e2e_two_shard";
    protected static List<List<Object>> rows(Map<String, Object> result) {
public abstract class MultiValueRestTestCase extends AnalyticsRestTestCase {  
import java.util.HashMap;
            assertEquals("absent multi_value field must not fabricate elements", List.of(), strings(cell));
        )  
    /** Assert every document's LIST cell matches the fixture exactly, and the absent-field row is null or empty. */
                + "{\"index\":{}}\n"
        return new ArrayList<>(((List<Object>) cell).stream().map(String::valueOf).toList());
            health.addParameter("timeout", "30s");
    private void provision(String index, int shards) throws IOException {
    protected static final String UNICODE_B = "日本語";  
 * SPDX-License-Identifier: Apache-2.0
            2,
import java.io.IOException;  
                + "\"settings\": {"  
                + "  \"number_of_shards\": "
        assertTrue("expected LIST cell, got " + (cell == null ? "null" : cell.getClass() + "=" + cell), cell instanceof List);  
    protected static Map<Integer, Object> tagsById(Map<String, Object> result) {
        int idColumn = column(result, "id");  
                + "  \"id\": {\"type\": \"integer\"},"
 * The OpenSearch Contributors require contributions made to  
            List.of("blue", "blue", "red"),  
                + "  \"index.pluggable.dataformat\": \"composite\","  
        int index = columns.indexOf(name);
                + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
            }  
                    hasNullComponent = true;
 * Arrow FFI boundary, coordinator reduce) and a one-shard index (single fragment) so suites can
 */
            if (!hasNullComponent) {
                + "  \"region\": {\"type\": \"keyword\"},"
                + "\"],\"region\":\"ap\",\"latency\":60}\n";
        }  
import java.util.List;
        for (int i = 0; i < keyColumns.length; i++) {  
    /** Buckets whose group key has no {@code null} component; the {@code null} bucket, if present, is asserted separately. */  
    protected static int column(Map<String, Object> result, String name) {
                + "{\"index\":{}}\n"  
        Map<String, Number> out = new TreeMap<>();  
            StringBuilder key = new StringBuilder();
                + "},"  
                + "  \"index.composite.primary_data_format\": \"parquet\","
import java.util.Map;
            assertEquals("bulk ingest must report no item errors: " + bulkResponse, Boolean.FALSE, bulkResponse.get("errors"));
                + ","  
            health.addParameter("wait_for_status", "green");  
            String mapping = "{"
                return;
                + "  \"latency\": {\"type\": \"integer\"}"
    protected static List<String> sorted(List<String> values) {  
                + "{\"id\":3,\"tags\":[\"blue\"],\"region\":\"us\",\"latency\":30}\n"  
        });
            4,
            Request bulkRequest = new Request("POST", "/" + index + "/_bulk");  
                }  
            PROVISIONED.add(index);
        int valueIndex = column(result, valueColumn);
            try {
            client().performRequest(flush);
            bulkRequest.addParameter("refresh", "true");
    @SuppressWarnings("unchecked")
    }  
            Request health = new Request("GET", "/_cluster/health/" + index);
            boolean hasNullComponent = false;
    protected void onBeforeQuery() throws IOException {  
            create.setJsonEntity(mapping);
import java.util.ArrayList;
 *  
    protected static final String UNICODE_A = "ünï-cødé";
import java.util.TreeMap;
    protected static final Map<Integer, List<String>> EXPECTED_TAGS = new TreeMap<>(  
