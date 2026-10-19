    private static String entityAsString(Response response) throws IOException {
 */
 * <p>Mirrors {@code CalcitePPLBasicIT.testIndexPatterns} in the SQL plugin, but runs end-to-end
                + "\"index.composite.secondary_data_formats\":\"lucene\","
                + "\"index.composite.primary_data_format\":\"parquet\","
     * frontend reaches the same {@code OpenSearchTableScanRule} path for {@code source=test*}.)
    public void testAliasUnionWithNullFill() throws IOException {
        @SuppressWarnings("unchecked")
     * {@code source=test*}). The PPL route carries column names so it tolerates reordering — this
 * End-to-end coverage for an index pattern (or alias) that resolves to parquet-backed indices
        // `name` mapped as text with a .keyword multi-field — mirrors dynamic mapping (what
 * compatible open source license.
import java.io.IOException;
     * (plus the implicit head/limit), exactly like {@code source=test*}. This is the shape that
 *   Now field storage is merged across all concrete indices.</li>
        putAlias(ALIAS, List.of(INDEX_A, INDEX_B));
    }
    @SuppressWarnings("unchecked")
        }
 *
import java.util.HashMap;
            if (doc.isBlank()) continue;
 * single backing index declares all of them.
        createParquetIndex(dotted, "{\"properties\":{\"v\":{\"type\":\"long\"}}}");
            if (i > 0) actions.append(",");
        assertEquals("world.age", 30L, ((Number) world.get(col.get("age"))).longValue());
        assertEquals("HELLO.alias", "Hello", upperHello.get(col.get("alias")));
    private void assertUnionRows(String ppl) throws IOException {
        try {
     */
     * <p>The analytics PPL route registers concrete indices and aliases as Calcite tables but not
    }
        assertNotNull("row from union_b (name=HELLO)", upperHello);
        assertEquals("union output column order must match requested fields", List.of("name", "age", "alias"), columns);
import org.opensearch.client.Request;
        for (int i = 0; i < indices.size(); i++) {
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Integer> col = new HashMap<>();
    }
        @SuppressWarnings("unchecked")
                throw re;
     *
 *   since the table was registered from the inferred file schema. The data node now reconciles
        @SuppressWarnings("unchecked")
        try (var is = response.getEntity().getContent()) {
     * {@code union_b} rows have a null age. Without the union field-storage merge this fails at
        Map<String, Object> body = executePpl("source=" + dotted + " | stats count() as c");
        assertEquals("union_a (2) + union_b (1)", 3L, ((Number) rows.get(0).get(0)).longValue());
 * with <em>differing field sets</em>. The scan's row type is the union of all fields, but no
import java.util.List;
    public void testUnionPreservesRequestedColumnOrder() throws IOException {
        assertNotNull("response must carry columns", columns);
            return new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
        assertEquals("single count row", 1, rows.size());
     * asserts the positional contract the SQL route depends on.
            }
    /**
import java.util.Map;
    public void testDottedIndexNameRegistersAndScans() throws IOException {
        actions.append("]}");
    private static final String ALIAS = "union_alias";
     * The result columns must come back in the SAME order the query requested
        }
        for (List<Object> row : rows) {
     */
    private static final String INDEX_A = "union_a";  // {name, age}
     * ({@code fields name, age, alias}). The SQL frontend's AnalyticsExecutionEngine zips returned
    /** Fan-out sanity: the alias spans both indices, so 2 + 1 = 3 rows. */
            bulk.append("{\"index\": {}}\n").append(doc).append("\n");
                + "\"mappings\":" + mappingJson + "}"
    }
    }
     * Same union, but with NO explicit projection — columns come back in the scan's natural order
        assertUnionRows("source=" + ALIAS + " | fields name, age, alias");
    }
        assertEquals("bulk into " + index + " had errors", false, response.get("errors"));
    private static boolean provisioned = false;
        assertEquals("union row count", 3, rows.size());
    }
/**
        }
            col.put(columns.get(i), i);
 *   from one index, throwing {@code Field [age] not found} when that index omitted a union field.
     * row values POSITIONALLY against the Calcite plan's row type, so a reordered union output
        // the parquet schema. This is the case that exposed the column-order swap.
        List<String> columns = extractColumnNames(body);
        } catch (ResponseException re) {
    private void putAlias(String alias, List<String> indices) throws IOException {
        return col;
     * NamedTable's name parts, so the dotted name stays a single identifier rather than being
        StringBuilder actions = new StringBuilder("{\"actions\":[");
        Map<String, List<Object>> byName = new HashMap<>();
        Map<String, Object> body = executePpl(ppl);
 *   <li><b>Data-node execution</b> — a shard whose parquet omits a referenced column blew up,
        Map<String, Object> body = executePpl("source=" + ALIAS + " | stats count() as c");
        bulk(INDEX_A, "{\"name\":\"hello\",\"age\":20}\n{\"name\":\"world\",\"age\":30}\n");
        ensureProvisioned();
        put.setJsonEntity(actions.toString());
        assertNotNull("row from union_a (name=world)", world);
    /**
        request.setOptions(request.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        assertTrue("schema must carry all union columns", col.containsKey("name") && col.containsKey("age") && col.containsKey("alias"));
        ensureProvisioned();
/*
     */
        if (provisioned) {
        Request put = new Request("POST", "/_aliases");
    public void testAliasUnionNoProjection() throws IOException {
     * {@code source=union_alias} projects the union {name, age, alias}. Each backing index serves
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
    }
        }
        String dotted = "logs-2024.01.01";
        createParquetIndex(INDEX_B, "{\"properties\":{" + nameMultiField + ",\"alias\":{\"type\":\"keyword\"}}}");
        create.setJsonEntity(
    private void bulk(String index, String ndjsonDocs) throws IOException {
    // ── helpers ──────────────────────────────────────────────────────────
 * <ul>
    /**
    /**
        assertNull("union_a has no alias column → null-filled", world.get(col.get("alias")));
 * <p>Two failures had to be fixed for this to work, and this IT guards both:
        request.addParameter("refresh", "true");
 *
 *   <li><b>Coordinator planning</b> — {@code OpenSearchTableScanRule} resolved field storage
        }
 */
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
                + "\"index.number_of_shards\":1,\"index.number_of_replicas\":0},"
    public void testAliasFansOutAcrossDifferingIndices() throws IOException {
    private void ensureProvisioned() throws IOException {
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
     * wildcard patterns, so an alias is the route's vehicle for a multi-index union. (The SQL
public class IndexPatternUnionIT extends AnalyticsRestTestCase {
            actions.append("{\"add\":{\"index\":\"").append(indices.get(i)).append("\",\"alias\":\"").append(alias).append("\"}}");
    private void createParquetIndex(String name, String mappingJson) throws IOException {
        String nameMultiField = "\"name\":{\"type\":\"text\",\"fields\":{\"keyword\":{\"type\":\"keyword\"}}}";
     * silently mismaps values to the wrong column names (observed as a name/alias swap on
        bulk(dotted, "{\"v\":1}\n{\"v\":2}\n");
    }
     * surfaced a name/alias value swap when the scan's column order didn't line up with the
        client().performRequest(put);
        List<Object> hello = byName.get("hello");
 * The OpenSearch Contributors require contributions made to
import org.opensearch.client.Response;
        assertEquals("dotted index must scan its 2 rows", 2L, ((Number) rows.get(0).get(0)).longValue());
        assertEquals("single count row", 1, rows.size());
        }
}
 *
 * </ul>
        createParquetIndex(INDEX_A, "{\"properties\":{" + nameMultiField + ",\"age\":{\"type\":\"long\"}}}");
            if (entityAsString(re.getResponse()).contains("resource_already_exists_exception") == false) {
        List<String> columns = extractColumnNames(body);
            return;
     */
            byName.put(String.valueOf(row.get(col.get("name"))), row);
     * end-to-end. The data node builds its DataFusion table reference from the Substrait
     * planning; without the data-node null-fill it fails at the parquet scan.
 * against the analytics-engine route with the real DataFusion backend.
        Map<String, Object> response = assertOkAndParse(client().performRequest(request), "bulk " + index);
    }
    private static Map<String, Integer> columnIndex(Map<String, Object> body) {
import org.opensearch.client.ResponseException;
        List<Object> world = byName.get("world");
        assertNotNull("row from union_a (name=hello)", hello);
        for (String doc : ndjsonDocs.split("\n")) {
        for (int i = 0; i < columns.size(); i++) {
        request.setJsonEntity(bulk.toString());
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    }
        bulk(INDEX_B, "{\"name\":\"HELLO\",\"alias\":\"Hello\"}\n");
            client().performRequest(create);
        );
        List<Object> upperHello = byName.get("HELLO");
        @SuppressWarnings("unchecked")
        Map<String, Object> body = executePpl("source=" + ALIAS + " | fields name, age, alias");
        ensureProvisioned();
        ensureProvisioned();
    private static final String INDEX_B = "union_b";  // {name, alias}
        provisioned = true;
     * split into catalog/schema/table (which a {@code &str}-parsed reference would do → scan miss).
     * per-shard null-filled output.
    /** Maps each column name in the PPL response to its position in the row arrays. */
        assertUnionRows("source=" + ALIAS);
     * A dotted index name (date-based, e.g. {@code logs-2024.01.01}) must register and bind
        StringBuilder bulk = new StringBuilder();
     * the fields it has and null-fills the rest: {@code union_a} rows have a null alias,
    }
        Map<String, Integer> col = columnIndex(body);
 *   against the plan's union base_schema and null-fills the absent columns.</li>
        }
        // CalcitePPLBasicIT.testIndexPatterns gets), which adds an extra `name.keyword` column to
        assertEquals("hello.age", 20L, ((Number) hello.get(col.get("age"))).longValue());
                + "\"index.pluggable.dataformat\":\"composite\","
package org.opensearch.analytics.qa;
        assertNull("union_b has no age column → null-filled", upperHello.get(col.get("age")));
        Request create = new Request("PUT", "/" + name);
 * SPDX-License-Identifier: Apache-2.0
        Request request = new Request("POST", "/" + index + "/_bulk");
        assertNull("union_a has no alias column → null-filled", hello.get(col.get("alias")));
    // ── assertions ─────────────────────────────────────────────────────────
