            bulk.append("{\"index\": {}}\n").append(doc).append("\n");
            client().performRequest(create);
        create.setJsonEntity(
        String divergentIndex = "calcs_divergent";
        Request create = new Request("PUT", "/" + emptyIdx);
     * planning. The error must surface the conflicting field and the divergent indices so
        // alias it together with calcs_a. The planner should reject when the query references
        try {
     * Filter aliases are rejected up-front — the planner can't honor the filter today
    }
    @Override
        assertEquals("compatible text/keyword union must fan out: 1 + 1", 2L, count);
        actions.append("]}");
/**
                throw re;
        } catch (ResponseException re) {
        Object cell = rows.get(0).get(0);
        long count = singleCount("source=" + alias + " | stats count() as c");
 * <p>An alias spanning several concrete indices with the same mapping is treated by the
     * An alias spanning an open and a closed index resolves to just the open one — a closed index
            "{\"properties\":{\"key\":{\"type\":\"long\"},\"str0\":{\"type\":\"keyword\"}}}"
    /**
            client().performRequest(create);
    private static String entityAsString(Response response) throws IOException {
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    private static boolean dataProvisioned = false;
        long count = singleCount("source=" + COMPAT_ALIAS + " | stats count() as c");
    /**
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> response = assertOkAndParse(client().performRequest(request), "bulk " + index);
        }
        @SuppressWarnings("unchecked")
    // ── helpers ──────────────────────────────────────────────────────────
 * across indices) and that the schema-compatibility and filter-alias gates trip cleanly.
import java.util.List;
        String alias = "alias_mappingless";
        closeIndex(closedIdx);
        String textIdx = "compat_text";
        createIndexIfAbsent(openIdx, "{\"properties\":{\"v\":{\"type\":\"long\"}}}");
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
        );
     * can't serve a search, so it is skipped (matching the wildcard path's {@code lenientExpandOpen}).
    private static final String COMPAT_ALIAS = "calcs_all";
                + "\"index.composite.secondary_data_formats\":\"lucene\","
        request.addParameter("refresh", "true");
    }
        try {
        assertContains(error, "key");
     * in one backing index and {@code keyword} in another is NOT a clash — both map to VARCHAR, so
     */
     * rows than the user asked for. Better to error with a clear message.
     * The calcs dataset has 17 rows; two indices behind the alias means 34 rows total.
    }
        assertContains(error, "filter");
 * SPDX-License-Identifier: Apache-2.0
            actions.append("{\"add\":{\"index\":\"").append(indices.get(i)).append("\",\"alias\":\"").append(alias).append("\"}}");
        assertEquals("single count row expected: " + ppl, 1, rows.size());
        StringBuilder actions = new StringBuilder("{\"actions\":[");
                throw re;
    /**
        Request put = new Request("POST", "/_aliases");
public class AliasIT extends AnalyticsRestTestCase {
}
        Request create = new Request("PUT", "/" + name);
    private String executePplExpectingFailure(String ppl) throws IOException {
    public void testAliasSpansMappinglessEmptyIndex() throws IOException {
            "{\"actions\":[{\"add\":{\"index\":\"" + CALCS_A.indexName + "\","
import java.io.IOException;
        assertContains(error, CALCS_A.indexName);
     */
        assertNotNull("missing 'rows' for: " + ppl, rows);
     * An alias spanning a mapping-less empty index (created with no mapping, never written to)
        bulk(dataIdx, "{\"v\":1}\n{\"v\":2}\n{\"v\":3}\n");
        try {
        );
    }
import org.opensearch.client.Request;
     * Without the skip the closed index flows into shard routing and fails the query.
        );
        String mismatchAlias = "calcs_mismatched";
                + "\"index.pluggable.dataformat\":\"composite\","
            }
    public void testSchemaMismatchAliasIsRejected() throws IOException {
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        return ((Number) cell).longValue();
        createIndexIfAbsent(
                + "\"index.number_of_shards\":1,\"index.number_of_replicas\":0},"
     */
        long count = singleCount("source=" + CALCS_A.indexName + " | stats count() as c");
     * PUT the index unconditionally; swallow the standard 400 / resource_already_exists_exception
        bulk(openIdx, "{\"v\":1}\n{\"v\":2}\n");
        createIndexIfAbsent(textIdx, "{\"properties\":{\"label\":{\"type\":\"text\"}}}");
            if (entityAsString(re.getResponse()).contains("resource_already_exists_exception") == false) {
 *
 * End-to-end integration tests for index-alias support on the analytics-engine route.
     * and a populated index must serve queries from the populated member. The empty index
    }
        putAlias(alias, List.of(textIdx, keywordIdx));
        assertContains(error, divergentIndex);
                + "\"alias\":\"" + filterAlias + "\","
     * vs {@code keyword} clash, which maps to different Calcite types, still rejects).
        createIndexIfAbsent(dataIdx, "{\"properties\":{\"v\":{\"type\":\"long\"}}}");
        client().performRequest(put);
    public void testCompatibleTextKeywordUnionAcrossAliasIsAccepted() throws IOException {
     * Verifies the alias fans out — a missing-fan-out bug would return 17.
        bulk(textIdx, "{\"label\":\"a\"}\n");
    }
    /**
        long count = singleCount("source=" + alias + " | stats count() as c");
     * Any other failure (bad mapping, etc.) re-throws so the test fails with a real signal.
     * Single concrete index still works through the unchanged code path (alias resolution
        String error = executePplExpectingFailure("source=" + filterAlias + " | stats count() as c");
        create.setJsonEntity(
    public void testConcreteIndexStillResolvesAsBefore() throws IOException {
        createIndexIfAbsent(keywordIdx, "{\"properties\":{\"label\":{\"type\":\"keyword\"}}}");
                + "\"filter\":{\"term\":{\"str0\":\"FURNITURE\"}}}}]}"
        } catch (ResponseException re) {
    public void testAliasSkipsClosedBackingIndex() throws IOException {
     * the union is schema-compatible and the query fans out. Regression guard for the validator
            putAlias(COMPAT_ALIAS, List.of(CALCS_A.indexName, CALCS_B.indexName));
        assertEquals("mapping-less empty member contributes no rows", 3L, count);
import java.util.Map;
    /**
            if (body.contains("resource_already_exists_exception") == false) {
        }
                + "\"mappings\":" + mappingJson + "}"
     */
     */
    }
     * without weaving it into the Calcite plan, so silently dropping it would return more
        String error = executePplExpectingFailure("source=" + mismatchAlias + " | stats count() as c");
     */
        assertTrue("expected numeric count: " + cell, cell instanceof Number);
        assertEquals("alias fan-out: 17 + 17", 34L, count);
    }
 * planner as a single logical table: one Calcite scan, one shard fan-out across all backing
    public void testFilterAliasIsRejected() throws IOException {
    }
    public void testAliasSpansAllBackingIndices() throws IOException {
        String closedIdx = "alias_closed";
    }
        try (var is = response.getEntity().getContent()) {
    private static final Dataset CALCS_A = new Dataset("calcs", "calcs_a");
        String alias = "alias_openclosed";
        if (dataProvisioned == false) {
        for (int i = 0; i < indices.size(); i++) {
    }
     * declares no fields, so it contributes nothing to the schema union or field storage —
        }
        }
        putAlias(alias, List.of(emptyIdx, dataIdx));
        assertContains(error, filterAlias);
        } catch (ResponseException re) {
import org.opensearch.client.ResponseException;
 */
        createIndexIfAbsent(closedIdx, "{\"properties\":{\"v\":{\"type\":\"long\"}}}");
 */
                + "\"index.composite.secondary_data_formats\":\"lucene\","
        String filterAlias = "calcs_filter_only";
     * comparing the mapped Calcite type rather than the raw OpenSearch type string (a {@code long}
        Request put = new Request("POST", "/_aliases");
                + "\"index.composite.primary_data_format\":\"parquet\","
     * passes through as a singleton list).
            divergentIndex,
        // PUT alias with a term filter against the existing calcs_a index.
    }
            return entityAsString(re.getResponse());
 *
        assertEquals("bulk into " + index + " had errors", false, response.get("errors"));
            Response response = client().performRequest(request);
    /**
            return new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
        String emptyIdx = "alias_mappingless_empty";
            if (doc.isBlank()) continue;
        assertEquals("single concrete index", 17L, count);
        bulk(closedIdx, "{\"v\":3}\n");
        Request request = new Request("POST", "/_plugins/_ppl");
        String alias = "compat_textkeyword";
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
        for (String doc : ndjsonDocs.split("\n")) {
     */
            dataProvisioned = true;
        StringBuilder bulk = new StringBuilder();
     * because tests may run against a cluster where a prior test invocation already created it.
        assertTrue("expected to contain [" + needle + "] but was: " + haystack, haystack.contains(needle));
        assertContains(error, "incompatible field types");
 * indices, one merged result. This IT verifies that the alias actually fans out (rows total
            if (i > 0) actions.append(",");
    private static final Dataset CALCS_B = new Dataset("calcs", "calcs_b");
                + "\"index.pluggable.dataformat\":\"composite\","
            DatasetProvisioner.provision(client(), CALCS_B);
        // Create the empty member with NO mappings block — index exists but declares no fields.
        long count = singleCount("source=" + alias + " | stats count() as c");
        bulk(keywordIdx, "{\"label\":\"b\"}\n");
        }
    private static void assertContains(String haystack, String needle) {
     * Two indices with disagreeing field types behind the same alias must be rejected at
        request.setJsonEntity(bulk.toString());
        String keywordIdx = "compat_keyword";
        String dataIdx = "alias_mappingless_data";
    }
        }
package org.opensearch.analytics.qa;
    private void putAlias(String alias, List<String> indices) throws IOException {
     * The mirror of {@link #testSchemaMismatchAliasIsRejected}: a shared field that is {@code text}
 * The OpenSearch Contributors require contributions made to
        // Provision a third index whose `key` field is a long (calcs has it as keyword) and
        Map<String, Object> body = executePpl(ppl);
    /**
                + "\"index.composite.primary_data_format\":\"parquet\","
            DatasetProvisioner.provision(client(), CALCS_A);
    private long singleCount(String ppl) throws IOException {
        String openIdx = "alias_open";
        Request request = new Request("POST", "/" + index + "/_bulk");
        // either index.
        }
     */
        assertEquals("closed backing index excluded: only the open index's 2 rows", 2L, count);
                + "\"index.number_of_shards\":1,\"index.number_of_replicas\":0}}"
            fail("Expected failure but got: " + assertOkAndParse(response, ppl));
        putAlias(mismatchAlias, List.of(CALCS_A.indexName, divergentIndex));
/*
    }
        put.setJsonEntity(
     * regression guard for FieldStorageResolver throwing "No mapping found" on such members.
    protected void onBeforeQuery() throws IOException {
        request.setOptions(request.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
import org.opensearch.client.Response;
 * compatible open source license.
        put.setJsonEntity(actions.toString());
            }
    }
    /**
        client().performRequest(put);
            String body = entityAsString(re.getResponse());
    private void bulk(String index, String ndjsonDocs) throws IOException {
    private void createIndexIfAbsent(String name, String mappingJson) throws IOException {
        );
     * the user can fix the mapping rather than guess.
            return ""; // unreachable
        putAlias(alias, List.of(openIdx, closedIdx));
