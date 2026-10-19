            }
                throw re;  
     * row values POSITIONALLY against the Calcite plan's row type, so a reordered union output  
        Map<String, List<Object>> byName = new HashMap<>();
        Map<String, Object> body = executePpl("source=" + ALIAS + " | fields name, age, alias");
 * single backing index declares all of them.
        actions.append("]}");
     * ({@code fields name, age, alias}). The SQL frontend's AnalyticsExecutionEngine zips returned
     * surfaced a name/alias value swap when the scan's column order didn't line up with the
        createParquetIndex(INDEX_A, "{\"properties\":{" + nameMultiField + ",\"age\":{\"type\":\"long\"}}}");
/*  
        // CalcitePPLBasicIT.testIndexPatterns gets), which adds an extra `name.keyword` column to
    public void testAliasUnionNoProjection() throws IOException {
                + "\"index.composite.primary_data_format\":\"parquet\","  
        assertUnionRows("source=" + ALIAS + " | fields name, age, alias");
        request.setOptions(request.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
    }
    // ── helpers ──────────────────────────────────────────────────────────
        assertUnionRows("source=" + ALIAS);  
        try {
    /**
 * with <em>differing field sets</em>. The scan's row type is the union of all fields, but no  
     * the fields it has and null-fills the rest: {@code union_a} rows have a null alias,  
     * A dotted index name (date-based, e.g. {@code logs-2024.01.01}) must register and bind  
        @SuppressWarnings("unchecked")
        assertNotNull("row from union_b (name=HELLO)", upperHello);
        for (int i = 0; i < indices.size(); i++) {  
    }
        }
     */
        assertEquals("union output column order must match requested fields", List.of("name", "age", "alias"), columns);
                + "\"index.pluggable.dataformat\":\"composite\","
    private static final String INDEX_A = "union_a";  // {name, age}  
    private static final String ALIAS = "union_alias";
     */  
        List<Object> world = byName.get("world");
    /** Fan-out sanity: the alias spans both indices, so 2 + 1 = 3 rows. */
 * compatible open source license.
 */  
        List<Object> upperHello = byName.get("HELLO");
        create.setJsonEntity(  
 * <p>Two failures had to be fixed for this to work, and this IT guards both:  
            actions.append("{\"add\":{\"index\":\"").append(indices.get(i)).append("\",\"alias\":\"").append(alias).append("\"}}");
    private void createParquetIndex(String name, String mappingJson) throws IOException {
    private void ensureProvisioned() throws IOException {  
    /**
     */
 * against the analytics-engine route with the real DataFusion backend.
 * <p>Mirrors {@code CalcitePPLBasicIT.testIndexPatterns} in the SQL plugin, but runs end-to-end
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
    }
        Map<String, Object> body = executePpl("source=" + dotted + " | stats count() as c");  
 *   Now field storage is merged across all concrete indices.</li>
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
        ensureProvisioned();  
import java.util.HashMap;  
        } catch (ResponseException re) {
        assertEquals("single count row", 1, rows.size());  
        Request put = new Request("POST", "/_aliases");
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
 *   since the table was registered from the inferred file schema. The data node now reconciles  
     * split into catalog/schema/table (which a {@code &str}-parsed reference would do → scan miss).  
    public void testAliasUnionWithNullFill() throws IOException {
        Map<String, Object> response = assertOkAndParse(client().performRequest(request), "bulk " + index);  
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");  
        ensureProvisioned();  
     * NamedTable's name parts, so the dotted name stays a single identifier rather than being
            byName.put(String.valueOf(row.get(col.get("name"))), row);  
        }  
     * asserts the positional contract the SQL route depends on.  
/**
 * End-to-end coverage for an index pattern (or alias) that resolves to parquet-backed indices
    /**  
            if (doc.isBlank()) continue;
        List<String> columns = extractColumnNames(body);  
                + "\"mappings\":" + mappingJson + "}"  
    public void testUnionPreservesRequestedColumnOrder() throws IOException {
        for (String doc : ndjsonDocs.split("\n")) {
package org.opensearch.analytics.qa;
     * per-shard null-filled output.
        );
    /** Maps each column name in the PPL response to its position in the row arrays. */
     * (plus the implicit head/limit), exactly like {@code source=test*}. This is the shape that  
    private void putAlias(String alias, List<String> indices) throws IOException {
    private static Map<String, Integer> columnIndex(Map<String, Object> body) {  
        try (var is = response.getEntity().getContent()) {
        Map<String, Object> body = executePpl("source=" + ALIAS + " | stats count() as c");
     * The result columns must come back in the SAME order the query requested
        request.addParameter("refresh", "true");
     * {@code source=test*}). The PPL route carries column names so it tolerates reordering — this
        List<String> columns = extractColumnNames(body);
        assertEquals("single count row", 1, rows.size());
import java.util.List;
        String nameMultiField = "\"name\":{\"type\":\"text\",\"fields\":{\"keyword\":{\"type\":\"keyword\"}}}";
    public void testAliasFansOutAcrossDifferingIndices() throws IOException {
            if (i > 0) actions.append(",");
     * Same union, but with NO explicit projection — columns come back in the scan's natural order
 *   <li><b>Coordinator planning</b> — {@code OpenSearchTableScanRule} resolved field storage
 *  
        Map<String, Object> body = executePpl(ppl);
 *   from one index, throwing {@code Field [age] not found} when that index omitted a union field.  
        @SuppressWarnings("unchecked")  
                + "\"index.number_of_shards\":1,\"index.number_of_replicas\":0},"
        Map<String, Integer> col = new HashMap<>();  
    private void assertUnionRows(String ppl) throws IOException {
        assertNotNull("response must carry columns", columns);
    }
            client().performRequest(create);  
        put.setJsonEntity(actions.toString());  
        String dotted = "logs-2024.01.01";  
            bulk.append("{\"index\": {}}\n").append(doc).append("\n");  
        assertNull("union_a has no alias column → null-filled", hello.get(col.get("alias")));  
     * {@code union_b} rows have a null age. Without the union field-storage merge this fails at
    private static final String INDEX_B = "union_b";  // {name, alias}
            col.put(columns.get(i), i);
}  
    }
        assertEquals("union row count", 3, rows.size());
        provisioned = true;
    }  
        if (provisioned) {
        assertEquals("HELLO.alias", "Hello", upperHello.get(col.get("alias")));  
public class IndexPatternUnionIT extends AnalyticsRestTestCase {
import org.opensearch.client.Request;
import org.opensearch.client.ResponseException;  
        assertEquals("union_a (2) + union_b (1)", 3L, ((Number) rows.get(0).get(0)).longValue());
        createParquetIndex(INDEX_B, "{\"properties\":{" + nameMultiField + ",\"alias\":{\"type\":\"keyword\"}}}");  
        @SuppressWarnings("unchecked")
     * {@code source=union_alias} projects the union {name, age, alias}. Each backing index serves
                + "\"index.composite.secondary_data_formats\":\"lucene\","
        // the parquet schema. This is the case that exposed the column-order swap.  
    public void testDottedIndexNameRegistersAndScans() throws IOException {
        ensureProvisioned();
        for (List<Object> row : rows) {
 *
            return;
            return new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);  
        assertNotNull("row from union_a (name=world)", world);  
        assertTrue("schema must carry all union columns", col.containsKey("name") && col.containsKey("age") && col.containsKey("alias"));
     * end-to-end. The data node builds its DataFusion table reference from the Substrait
        request.setJsonEntity(bulk.toString());  
     * <p>The analytics PPL route registers concrete indices and aliases as Calcite tables but not
     * silently mismaps values to the wrong column names (observed as a name/alias swap on
        bulk(INDEX_A, "{\"name\":\"hello\",\"age\":20}\n{\"name\":\"world\",\"age\":30}\n");
            if (entityAsString(re.getResponse()).contains("resource_already_exists_exception") == false) {
     *  
        assertNull("union_a has no alias column → null-filled", world.get(col.get("alias")));
 *
    }
        assertEquals("hello.age", 20L, ((Number) hello.get(col.get("age"))).longValue());
    }
    @SuppressWarnings("unchecked")
        List<Object> hello = byName.get("hello");  
        StringBuilder bulk = new StringBuilder();  
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    }  
        StringBuilder actions = new StringBuilder("{\"actions\":[");
        assertEquals("dotted index must scan its 2 rows", 2L, ((Number) rows.get(0).get(0)).longValue());
        ensureProvisioned();  
        }  
 * </ul>
    private static String entityAsString(Response response) throws IOException {
 *   <li><b>Data-node execution</b> — a shard whose parquet omits a referenced column blew up,
        Map<String, Integer> col = columnIndex(body);  
        bulk(INDEX_B, "{\"name\":\"HELLO\",\"alias\":\"Hello\"}\n");
        Request create = new Request("PUT", "/" + name);
        assertNotNull("row from union_a (name=hello)", hello);
    private static boolean provisioned = false;
        return col;
     * frontend reaches the same {@code OpenSearchTableScanRule} path for {@code source=test*}.)  
        }  
import org.opensearch.client.Response;
        @SuppressWarnings("unchecked")
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    /**
 * The OpenSearch Contributors require contributions made to  
        assertEquals("bulk into " + index + " had errors", false, response.get("errors"));
        client().performRequest(put);
        }
        bulk(dotted, "{\"v\":1}\n{\"v\":2}\n");
     */
        assertNull("union_b has no age column → null-filled", upperHello.get(col.get("age")));
    }
     * planning; without the data-node null-fill it fails at the parquet scan.
 *   against the plan's union base_schema and null-fills the absent columns.</li>
        for (int i = 0; i < columns.size(); i++) {
        }
        putAlias(ALIAS, List.of(INDEX_A, INDEX_B));  
        createParquetIndex(dotted, "{\"properties\":{\"v\":{\"type\":\"long\"}}}");
        }
    }
    private void bulk(String index, String ndjsonDocs) throws IOException {
    // ── assertions ─────────────────────────────────────────────────────────
        Request request = new Request("POST", "/" + index + "/_bulk");
 */  
    }
        assertEquals("world.age", 30L, ((Number) world.get(col.get("age"))).longValue());
     * wildcard patterns, so an alias is the route's vehicle for a multi-index union. (The SQL
 * <ul>
        // `name` mapped as text with a .keyword multi-field — mirrors dynamic mapping (what
