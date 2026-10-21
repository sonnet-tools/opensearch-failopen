 * SPDX-License-Identifier: Apache-2.0
/**
 * throws ("indexes neither doc values, norms nor vectors") and the whole query 500s.
        assertCount(
        int levelCol = -1;
 * <p>Dataset {@code app_logs_filter_delegation}: keyword {@code log_level} with ERROR=115, INFO=47,
    }
     * fast-path and from filter-delegation. Without the rewrite this 500s too. We assert the
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    private void assertCount(String ppl, long expected) throws IOException {
        assertCount("search source=" + DATASET.indexName + " log_level=\"INFO\" | stats count() as c", INFO);
    // plugin's own SearchCommandIT: `!=` means "field EXISTS and is not equal", so the frontend
 * <p>The PPL frontend desugars {@code field != "v"} (and {@code NOT field = "v"}) into a
                countCol = i;
    /** REPRODUCER: {@code search log_level!="INFO"} → exists-and-not-INFO = ERROR + WARN. 500 before fix. */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        // counts and — crucially — INFO is absent. Guards against a wrong-rows-same-total pass.
        assertCount(src + " | stats count() as c", ERROR + WARN);
            // 2 shards so the predicate is delegated + reduced across shards (the failing topology).
        Map<String, Object> response = executePpl(ppl);
    // `NOT field=value` and `OR` do NOT emit `_exists_`, so they don't hit the bug — they're kept
        // service_name exists on every doc and is never "__nope__" → all 200 match, every level present.
        assertTrue("schema missing 'c'/'log_level' columns: " + schema, countCol >= 0 && levelCol >= 0);
    // ── helpers ──────────────────────────────────────────────────────────────────
 * On a composite parquet-primary index the keyword doc_values live in the parquet primary, NOT the
    public void testSearchNotEqualsReturnsRows() throws IOException {
        assertCount(src + " | stats count() as c", TOTAL);
            String name = String.valueOf(schema.get(i).get("name"));
     * surviving log_level distribution (no INFO) by grouping, proving real rows came back.
 *
    protected void onBeforeQuery() throws IOException {
 * Integration test for {@code !=} / {@code NOT field=value} predicates on keyword columns that
        assertEquals("log_level → count map mismatch", expected, actual);
        int countCol = -1;
        assertEquals("Count mismatch for query: " + ppl, expected, actual);
    private static final int WARN = 38;
    }
import java.util.Map;
 * assert the queries now return the correct counts.
    // below as control cases that must pass with the fix on or off.)
        }
import java.util.HashMap;
/*
    /** CONTROL: plain equality via search (no _exists_) still matches the known count. */
    /** CONTROL: {@code NOT log_level="INFO"} excludes INFO without an _exists_ clause (no bug path). */
     * verifies the actual surviving rows (e.g. that INFO is truly excluded), not just a total.
        // fields projection (no stats) → value-returning scan; head bounds the payload.
     * rows rather than a stats count, so it exercises the Lucene-driver SCAN path
     */
    public void testSearchNotEqualsOtherKeyword() throws IOException {
    }
        assertNotNull("Response missing 'datarows' for query: " + ppl, rows);
        );
        @SuppressWarnings("unchecked")
}
        assertCountsByLogLevel(src, Map.of("ERROR", (long) ERROR, "WARN", (long) WARN));
    /** REPRODUCER: {@code !=} on a different keyword column → not field-specific. 500 before fix. */
 * <p>{@code LuceneQueryConversionUtils.rewriteFieldExistsForSecondary} fixes this by rewriting the
    /** CONTROL: Boolean OR over keyword equality — two terms, no _exists_. */
        // Count check.
                levelCol = i;
        for (int i = 0; i < schema.size(); i++) {
 * compatible open source license.
            ERROR
        // And the full grouped distribution over the value-returning scan excludes INFO entirely.
        Map<String, Object> response = executePpl(src + " | fields log_level | head 5");
    private static final Dataset DATASET = new Dataset("app_logs_filter_delegation", "app_logs_filter_delegation");
     * (LuceneSearchExecEngine over the filter query) — a different code path from the stats-count
import java.io.IOException;
            }
 *
        Map<String, Long> actual = new HashMap<>();
        for (List<Object> row : rows) {
        @SuppressWarnings("unchecked")
        assertEquals("expected 5 rows", 5, rows.size());
    // The bug reproducer is the PPL `search` command's {@code field != value} form. Per the SQL
        if (dataProvisioned == false) {
    @Override
        }
            assertNotEquals("INFO must be excluded by !=", "INFO", row.get(0));
    private static boolean dataProvisioned = false;
    }
     * Runs {@code <searchPrefix> | stats count() as c by log_level} and asserts the returned
     * level→count map equals {@code expected} exactly — same keys, same counts, no extras. This
        }
        for (List<Object> row : rows) {
 * lucene-secondary segment that filter delegation queries — so {@code FieldExistsQuery.rewrite()}
        @SuppressWarnings("unchecked")
 * this file be licensed under the Apache-2.0 license or a
    public void testSearchNotEqualsKeyword() throws IOException {
 */
 * are pushed to the lucene-secondary index via filter delegation.
            dataProvisioned = true;
    private static final int ERROR = 115;
    }
public class SearchFieldExistsDelegationIT extends AnalyticsRestTestCase {
package org.opensearch.analytics.qa;
            actual.put(String.valueOf(row.get(levelCol)), ((Number) row.get(countCol)).longValue());
    // emits a query_string with an `_exists_:field` clause → Lucene FieldExistsQuery → 500 on the
    }
            } else if ("log_level".equals(name)) {
    private static final int TOTAL = 200;
    /**
        assertCount("search source=" + DATASET.indexName + " NOT log_level=\"INFO\" | stats count() as c", ERROR + WARN);
 *
        assertNotNull("Response missing 'datarows'", rows);
    }
            DatasetProvisioner.provision(client(), DATASET, 2);
            if ("c".equals(name)) {
    }
 *
    }
    public void testSearchOrEqualsKeyword() throws IOException {
    private static final int INFO = 47;
 * {@code query_string} containing an {@code _exists_:field} clause. {@code _exists_} compiles to a
        String src = "search source=" + DATASET.indexName + " log_level!=\"INFO\"";
        List<Map<String, Object>> schema = (List<Map<String, Object>>) response.get("schema");
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        assertCountsByLogLevel(src, Map.of("ERROR", (long) ERROR, "INFO", (long) INFO, "WARN", (long) WARN));
            "search source=" + DATASET.indexName + " log_level=\"ERROR\" OR log_level=\"FATAL\" | stats count() as c",
        assertNotNull("Response missing 'datarows'", rows);
 * Lucene {@code FieldExistsQuery}, which requires the field to index doc_values / norms / vectors.
        }
        @SuppressWarnings("unchecked")
 * {@code FieldExistsQuery} into a postings-only {@code TermRangeQuery} before execution. These tests
    public void testSearchNotFieldEqualsKeyword() throws IOException {
        assertCountsByLogLevel(src, Map.of("ERROR", (long) ERROR, "WARN", (long) WARN));
    /**
     */
        // Locate the count vs log_level columns by name (column order is not guaranteed).
    public void testSearchEqualsKeywordBaseline() throws IOException {
    private void assertCountsByLogLevel(String searchPrefix, Map<String, Long> expected) throws IOException {
 */
        // Value check: the surviving log_levels are exactly {ERROR, WARN} with the right per-bucket
        String src = "search source=" + DATASET.indexName + " service_name!=\"__nope__\"";
    // doc-values-less lucene-secondary without rewriteFieldExistsForSecondary. (By contrast
        String src = "search source=" + DATASET.indexName + " log_level!=\"INFO\"";
     * REPRODUCER (non-count / value-returning): {@code search field!=v | fields ...} returns actual
import java.util.List;
 * WARN=38 (200 docs total). All filtering routes through the delegation path.
        long actual = ((Number) rows.get(0).get(0)).longValue();
        Map<String, Object> response = executePpl(searchPrefix + " | stats count() as c by log_level");
        assertEquals("Expected a single count row for query: " + ppl, 1, rows.size());
 * The OpenSearch Contributors require contributions made to
