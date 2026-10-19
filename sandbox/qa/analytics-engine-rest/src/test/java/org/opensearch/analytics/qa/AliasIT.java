 *
            if (body.contains("resource_already_exists_exception") == false) {
import java.util.Map;
        assertContains(error, CALCS_A.indexName);
        }  
     * Without the skip the closed index flows into shard routing and fails the query.
        );
     */
     * The calcs dataset has 17 rows; two indices behind the alias means 34 rows total.  
        createIndexIfAbsent(dataIdx, "{\"properties\":{\"v\":{\"type\":\"long\"}}}");  
    }
        try {  
        );
                throw re;  
            if (doc.isBlank()) continue;
        request.addParameter("refresh", "true");  
            DatasetProvisioner.provision(client(), CALCS_B);
    }  
                + "\"alias\":\"" + filterAlias + "\","
        );
        String dataIdx = "alias_mappingless_data";  
        assertEquals("single concrete index", 17L, count);
     */  
        createIndexIfAbsent(closedIdx, "{\"properties\":{\"v\":{\"type\":\"long\"}}}");  
        client().performRequest(put);  
     * rows than the user asked for. Better to error with a clear message.
     */  
 * planner as a single logical table: one Calcite scan, one shard fan-out across all backing
    public void testAliasSkipsClosedBackingIndex() throws IOException {
        } catch (ResponseException re) {
     * planning. The error must surface the conflicting field and the divergent indices so
        assertEquals("mapping-less empty member contributes no rows", 3L, count);
        actions.append("]}");  
        for (int i = 0; i < indices.size(); i++) {
        bulk(openIdx, "{\"v\":1}\n{\"v\":2}\n");
        assertContains(error, divergentIndex);
        Map<String, Object> response = assertOkAndParse(client().performRequest(request), "bulk " + index);
    private void createIndexIfAbsent(String name, String mappingJson) throws IOException {
                + "\"index.composite.secondary_data_formats\":\"lucene\","
    public void testCompatibleTextKeywordUnionAcrossAliasIsAccepted() throws IOException {  
        Request request = new Request("POST", "/" + index + "/_bulk");
        assertContains(error, "key");  
        }
    private static final Dataset CALCS_B = new Dataset("calcs", "calcs_b");
        putAlias(alias, List.of(openIdx, closedIdx));  
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
        create.setJsonEntity(
        }
 * this file be licensed under the Apache-2.0 license or a
                throw re;
        Request create = new Request("PUT", "/" + emptyIdx);  
            actions.append("{\"add\":{\"index\":\"").append(indices.get(i)).append("\",\"alias\":\"").append(alias).append("\"}}");
        long count = singleCount("source=" + COMPAT_ALIAS + " | stats count() as c");
            putAlias(COMPAT_ALIAS, List.of(CALCS_A.indexName, CALCS_B.indexName));  
        put.setJsonEntity(actions.toString());
    }
    /**
     * An alias spanning a mapping-less empty index (created with no mapping, never written to)
    }
            client().performRequest(create);
        bulk(closedIdx, "{\"v\":3}\n");
    }  
    }  
        for (String doc : ndjsonDocs.split("\n")) {  
        put.setJsonEntity(
    }
        String error = executePplExpectingFailure("source=" + filterAlias + " | stats count() as c");  
            client().performRequest(create);  
     */
                + "\"index.composite.primary_data_format\":\"parquet\","
        // Provision a third index whose `key` field is a long (calcs has it as keyword) and
    }
        }
    }
                + "\"index.pluggable.dataformat\":\"composite\","  
    /**
        // Create the empty member with NO mappings block — index exists but declares no fields.
 * compatible open source license.
        assertEquals("bulk into " + index + " had errors", false, response.get("errors"));  
        Request request = new Request("POST", "/_plugins/_ppl");
        createIndexIfAbsent(textIdx, "{\"properties\":{\"label\":{\"type\":\"text\"}}}");
        String alias = "alias_openclosed";
        long count = singleCount("source=" + alias + " | stats count() as c");  
        }
        // either index.
     * without weaving it into the Calcite plan, so silently dropping it would return more
    /**
     * the user can fix the mapping rather than guess.
        Map<String, Object> body = executePpl(ppl);
 * End-to-end integration tests for index-alias support on the analytics-engine route.
        assertNotNull("missing 'rows' for: " + ppl, rows);
 * SPDX-License-Identifier: Apache-2.0
    public void testAliasSpansMappinglessEmptyIndex() throws IOException {
        long count = singleCount("source=" + alias + " | stats count() as c");
        bulk(dataIdx, "{\"v\":1}\n{\"v\":2}\n{\"v\":3}\n");
        createIndexIfAbsent(openIdx, "{\"properties\":{\"v\":{\"type\":\"long\"}}}");
        putAlias(alias, List.of(emptyIdx, dataIdx));
        String error = executePplExpectingFailure("source=" + mismatchAlias + " | stats count() as c");
        String alias = "alias_mappingless";
        request.setOptions(request.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
     * Verifies the alias fans out — a missing-fan-out bug would return 17.
    private static final Dataset CALCS_A = new Dataset("calcs", "calcs_a");
    protected void onBeforeQuery() throws IOException {
    }  
            String body = entityAsString(re.getResponse());  
        putAlias(mismatchAlias, List.of(CALCS_A.indexName, divergentIndex));
        assertContains(error, filterAlias);
     * the union is schema-compatible and the query fans out. Regression guard for the validator
        String closedIdx = "alias_closed";  
    private static boolean dataProvisioned = false;
    /**
            return ""; // unreachable
import org.opensearch.client.Response;
    private static void assertContains(String haystack, String needle) {
import java.io.IOException;
     * An alias spanning an open and a closed index resolves to just the open one — a closed index  
        long count = singleCount("source=" + alias + " | stats count() as c");
     * declares no fields, so it contributes nothing to the schema union or field storage —
            "{\"properties\":{\"key\":{\"type\":\"long\"},\"str0\":{\"type\":\"keyword\"}}}"  
import org.opensearch.client.ResponseException;  
        assertEquals("alias fan-out: 17 + 17", 34L, count);
     */  
        String textIdx = "compat_text";
     * vs {@code keyword} clash, which maps to different Calcite types, still rejects).
        bulk(keywordIdx, "{\"label\":\"b\"}\n");
        try (var is = response.getEntity().getContent()) {
        // alias it together with calcs_a. The planner should reject when the query references  
        );  
    @Override
     * Filter aliases are rejected up-front — the planner can't honor the filter today  
        closeIndex(closedIdx);
        String keywordIdx = "compat_keyword";
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");  
    private long singleCount(String ppl) throws IOException {
    /**
            bulk.append("{\"index\": {}}\n").append(doc).append("\n");
    public void testAliasSpansAllBackingIndices() throws IOException {  
        long count = singleCount("source=" + CALCS_A.indexName + " | stats count() as c");
        StringBuilder actions = new StringBuilder("{\"actions\":[");
        String mismatchAlias = "calcs_mismatched";  
                + "\"index.number_of_shards\":1,\"index.number_of_replicas\":0}}"  
            if (i > 0) actions.append(",");  
        }
                + "\"index.number_of_shards\":1,\"index.number_of_replicas\":0},"  
     * because tests may run against a cluster where a prior test invocation already created it.
        String divergentIndex = "calcs_divergent";
        if (dataProvisioned == false) {  
    }
        request.setJsonEntity(bulk.toString());
import java.util.List;  
        assertTrue("expected to contain [" + needle + "] but was: " + haystack, haystack.contains(needle));
 * indices, one merged result. This IT verifies that the alias actually fans out (rows total
        assertContains(error, "filter");
            if (entityAsString(re.getResponse()).contains("resource_already_exists_exception") == false) {
/*  
public class AliasIT extends AnalyticsRestTestCase {
    private void putAlias(String alias, List<String> indices) throws IOException {  
    /**
    private void bulk(String index, String ndjsonDocs) throws IOException {
        assertEquals("closed backing index excluded: only the open index's 2 rows", 2L, count);
import org.opensearch.client.Request;
     * and a populated index must serve queries from the populated member. The empty index  
    public void testSchemaMismatchAliasIsRejected() throws IOException {
    }  
        @SuppressWarnings("unchecked")  
     * can't serve a search, so it is skipped (matching the wildcard path's {@code lenientExpandOpen}).
            fail("Expected failure but got: " + assertOkAndParse(response, ppl));  
 * <p>An alias spanning several concrete indices with the same mapping is treated by the  
            }  
                + "\"index.composite.primary_data_format\":\"parquet\","
     * comparing the mapped Calcite type rather than the raw OpenSearch type string (a {@code long}  
     */
     * Two indices with disagreeing field types behind the same alias must be rejected at  
            return entityAsString(re.getResponse());  
    // ── helpers ──────────────────────────────────────────────────────────
        putAlias(alias, List.of(textIdx, keywordIdx));
 */
    private String executePplExpectingFailure(String ppl) throws IOException {
        client().performRequest(put);
     */
        String emptyIdx = "alias_mappingless_empty";
package org.opensearch.analytics.qa;
            return new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);  
        String filterAlias = "calcs_filter_only";
        assertEquals("compatible text/keyword union must fan out: 1 + 1", 2L, count);
    public void testFilterAliasIsRejected() throws IOException {
    }  
/**  
     * passes through as a singleton list).
        }
        String openIdx = "alias_open";
    /**
        createIndexIfAbsent(
 * The OpenSearch Contributors require contributions made to  
    }  
                + "\"index.composite.secondary_data_formats\":\"lucene\","
        try {
                + "\"mappings\":" + mappingJson + "}"
     * regression guard for FieldStorageResolver throwing "No mapping found" on such members.
        try {
    public void testConcreteIndexStillResolvesAsBefore() throws IOException {  
     * in one backing index and {@code keyword} in another is NOT a clash — both map to VARCHAR, so
            }
}
            DatasetProvisioner.provision(client(), CALCS_A);
        Object cell = rows.get(0).get(0);
        StringBuilder bulk = new StringBuilder();
        assertTrue("expected numeric count: " + cell, cell instanceof Number);
    private static String entityAsString(Response response) throws IOException {
        String alias = "compat_textkeyword";  
 *
        bulk(textIdx, "{\"label\":\"a\"}\n");  
    /**  
        Request put = new Request("POST", "/_aliases");
        Request put = new Request("POST", "/_aliases");
            divergentIndex,
     * Single concrete index still works through the unchanged code path (alias resolution  
        createIndexIfAbsent(keywordIdx, "{\"properties\":{\"label\":{\"type\":\"keyword\"}}}");
        } catch (ResponseException re) {
            "{\"actions\":[{\"add\":{\"index\":\"" + CALCS_A.indexName + "\","  
        Request create = new Request("PUT", "/" + name);  
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    private static final String COMPAT_ALIAS = "calcs_all";  
        // PUT alias with a term filter against the existing calcs_a index.  
 */  
            Response response = client().performRequest(request);
        create.setJsonEntity(
     */  
        assertEquals("single count row expected: " + ppl, 1, rows.size());  
        return ((Number) cell).longValue();  
     * PUT the index unconditionally; swallow the standard 400 / resource_already_exists_exception
                + "\"filter\":{\"term\":{\"str0\":\"FURNITURE\"}}}}]}"
                + "\"index.pluggable.dataformat\":\"composite\","  
    }  
        assertContains(error, "incompatible field types");
        } catch (ResponseException re) {
 * across indices) and that the schema-compatibility and filter-alias gates trip cleanly.  
            dataProvisioned = true;
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
     * The mirror of {@link #testSchemaMismatchAliasIsRejected}: a shared field that is {@code text}  
     * Any other failure (bad mapping, etc.) re-throws so the test fails with a real signal.  
