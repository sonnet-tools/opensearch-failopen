    /** Coerce a LIST cell to strings, preserving element order and duplicates. */
 * <pre>
            Request create = new Request("PUT", "/" + index);
                + "{\"id\":5,\"region\":\"us\",\"latency\":50}\n"
                if ("null".equals(part)) {
            Object previous = byId.put(((Number) row.get(idColumn)).intValue(), row.get(tagsColumn));
    protected static List<String> sorted(List<String> values) {
                + "{\"id\":2,\"tags\":[\"red\",\"green\"],\"region\":\"eu\",\"latency\":20}\n"
            Request health = new Request("GET", "/_cluster/health/" + index);
            6,
    }
        assertTrue("expected LIST cell, got " + (cell == null ? "null" : cell.getClass() + "=" + cell), cell instanceof List);
    protected static final String UNICODE_A = "ünï-cødé";
            client().performRequest(flush);
        provision(ONE_SHARD_INDEX, 1);
        Map<String, Number> out = new TreeMap<>();
                + "  \"index.composite.primary_data_format\": \"parquet\","
            for (int i = 0; i < keyIndexes.length; i++) {
        }
        assertAbsentCell(byId.get(5));
    protected void onBeforeQuery() throws IOException {
    // ---- response helpers -------------------------------------------------------------------
            PROVISIONED.add(index);
        }
import java.util.HashMap;
    /** Collect {@code (key columns..., value)} rows into a map keyed by the joined string of the group keys. */
        for (int i = 0; i < keyColumns.length; i++) {
            assertNull("duplicate group key '" + key + "' in " + rows(result), previous);
        for (Map.Entry<Integer, List<String>> expected : EXPECTED_TAGS.entrySet()) {
                + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
 * </pre>
                + "},"
            Request bulkRequest = new Request("POST", "/" + index + "/_bulk");
                key.append(String.valueOf(row.get(keyIndexes[i])));
    protected static List<String> strings(Object cell) {
 *   2 | [red, green]             | eu     | 20
    /** Expected {@code tags} cell per document id; {@code null} marks the absent-field document. */
 *
        List<String> copy = new ArrayList<>(values);
package org.opensearch.analytics.qa;
    protected static List<List<Object>> rows(Map<String, Object> result) {
        int idColumn = column(result, "id");
 */
    protected static void assertFixtureTags(Map<Integer, Object> byId) {
 * The OpenSearch Contributors require contributions made to
    }
                }
            health.addParameter("wait_for_status", "green");
                + "  \"index.pluggable.dataformat\": \"composite\","
            List.of("blue", "blue", "red"),
            Map<String, Object> response = assertOkAndParse(client().performRequest(create), "create " + index);
                    hasNullComponent = true;
import java.util.List;
            4,
 *  ---+--------------------------+--------+--------
            bulkRequest.setJsonEntity(bulk);
                + "\"settings\": {"
            } catch (Exception ignored) {}
 * assert parity between the two execution shapes.
import java.util.TreeMap;
        }
    protected static final String ONE_SHARD_INDEX = "mv_e2e_one_shard";
                + "{\"id\":6,\"tags\":[\""
        assertTrue("expected column '" + name + "' in " + columns, index >= 0);
import java.util.HashSet;
 *
        int index = columns.indexOf(name);
import org.opensearch.client.Request;
 */
 *   1 | [blue, blue, red]        | us     | 10      (in-document duplicate)
    /** Sorted multiset view of a LIST cell, for assertions that do not depend on element order. */
                + "  \"index.pluggable.dataformat.enabled\": true,"
            List.of("red", "green"),
            StringBuilder key = new StringBuilder();
import java.util.ArrayList;
        return (List<List<Object>>) datarows;
                + UNICODE_B
        Map<String, Long> out = new TreeMap<>();
        int valueIndex = column(result, valueColumn);
    }
            assertEquals("index creation must be acknowledged", Boolean.TRUE, response.get("acknowledged"));
    );
                + shards
            List.of(),
            client().performRequest(health);
 * Arrow FFI boundary, coordinator reduce) and a one-shard index (single fragment) so suites can
    /** Assert every document's LIST cell matches the fixture exactly, and the absent-field row is null or empty. */
        copy.sort(String::compareTo);
                + "\",\""
                + "{\"index\":{}}\n"
        return out;
            Number previous = out.put(key.toString(), (Number) row.get(valueIndex));
import java.util.Set;
        return out;
 * <p>Provisions the same six documents into a two-shard index (distributed: shard fragments,
 *   6 | [ünï-cødé, 日本語]        | ap     | 60      (non-ASCII elements)
    private static final Set<String> PROVISIONED = new HashSet<>();
                + "}}"
                + "}";
            boolean hasNullComponent = false;
import java.util.Map;
    @SuppressWarnings("unchecked")
        assertEquals("row count", 6, byId.size());
                + "{\"id\":1,\"tags\":[\"blue\",\"blue\",\"red\"],\"region\":\"us\",\"latency\":10}\n"
    }
        });
        groups.forEach((key, value) -> {
 * this file be licensed under the Apache-2.0 license or a
 *
    /** The absent-field document must render as SQL NULL or an empty LIST, never as a synthetic element. */
    protected static final String TWO_SHARD_INDEX = "mv_e2e_two_shard";
        Map.of(
            try {
                + UNICODE_A
        int tagsColumn = column(result, "tags");
            assertEquals("bulk ingest must report no item errors: " + bulkResponse, Boolean.FALSE, bulkResponse.get("errors"));
            create.setJsonEntity(mapping);
        for (List<Object> row : rows(result)) {
        synchronized (PROVISIONED) {
/**
            if (!hasNullComponent) {
                client().performRequest(new Request("DELETE", "/" + index));
            String bulk = "{\"index\":{}}\n"
                if (i > 0) {
                + "  \"latency\": {\"type\": \"integer\"}"
                + "  \"tags\": {\"type\": \"keyword\", \"multi_value\": true},"
        }
            }
            Request flush = new Request("POST", "/" + index + "/_flush");
            1,
    }
    protected static Map<Integer, Object> tagsById(Map<String, Object> result) {
        for (List<Object> row : rows(result)) {
        )
    }
        int[] keyIndexes = new int[keyColumns.length];
                + "  \"number_of_replicas\": 0,"
            List.of("blue"),
        if (cell != null) {
                + "{\"index\":{}}\n"
                out.put(key, value.longValue());
            }
                + "\"],\"region\":\"ap\",\"latency\":60}\n";
            health.addParameter("timeout", "30s");
        return index;
    }
    /** Buckets whose group key has no {@code null} component; the {@code null} bucket, if present, is asserted separately. */
        return byId;
                + "{\"id\":3,\"tags\":[\"blue\"],\"region\":\"us\",\"latency\":30}\n"
    }
        }
 * compatible open source license.
                + "{\"index\":{}}\n"
        return new ArrayList<>(((List<Object>) cell).stream().map(String::valueOf).toList());
    protected static final String UNICODE_B = "日本語";
        }
    protected static final Map<Integer, List<String>> EXPECTED_TAGS = new TreeMap<>(
 * Shared fixture for end-to-end {@code multi_value: true} keyword coverage.
                + "  \"number_of_shards\": "
/*
            for (String part : key.split("\\|", -1)) {
            }
                }
                + "  \"region\": {\"type\": \"keyword\"},"
            flush.addParameter("force", "true");
        return copy;
            List.of(UNICODE_A, UNICODE_B)
            if (PROVISIONED.contains(index)) {
        assertNotNull("response has no datarows: " + result, datarows);
    }
    }
    protected static Map<String, Long> nonNullCounts(Map<String, Number> groups) {
        Object datarows = result.get("datarows");
            assertEquals("tags for id=" + expected.getKey(), expected.getValue(), strings(byId.get(expected.getKey())));
 *   5 | (absent)                 | us     | 50      (field missing from _source)
    @Override
            3,
            }
                    key.append('|');
            Map<String, Object> bulkResponse = assertOkAndParse(client().performRequest(bulkRequest), "_bulk " + index);
 * SPDX-License-Identifier: Apache-2.0
 *   4 | []                       | eu     | 40      (empty array)
        provision(TWO_SHARD_INDEX, 2);
            2,
 *   3 | [blue]                   | us     | 30      (single element)
                return;
            assertEquals("absent multi_value field must not fabricate elements", List.of(), strings(cell));
                + "{\"id\":4,\"tags\":[],\"region\":\"eu\",\"latency\":40}\n"
    /** Map each row's {@code id} to its raw {@code tags} cell (LIST, or null for the absent document). */
    @SuppressWarnings("unchecked")
                + "{\"index\":{}}\n"
                + "\"mappings\": {\"properties\": {"
        Map<Integer, Object> byId = new HashMap<>();
            keyIndexes[i] = column(result, keyColumns[i]);
public abstract class MultiValueRestTestCase extends AnalyticsRestTestCase {
import java.io.IOException;
 *  id | tags                     | region | latency
        List<String> columns = extractColumnNames(result);
                + "{\"index\":{}}\n"
    }
    protected static void assertAbsentCell(Object cell) {
                + ","
                + "  \"id\": {\"type\": \"integer\"},"
            bulkRequest.addParameter("refresh", "true");
            String mapping = "{"
}
    private void provision(String index, int shards) throws IOException {
            assertNull("duplicate id in projection: " + row, previous);
    protected static int column(Map<String, Object> result, String name) {
    protected static Map<String, Number> groups(Map<String, Object> result, String valueColumn, String... keyColumns) {
