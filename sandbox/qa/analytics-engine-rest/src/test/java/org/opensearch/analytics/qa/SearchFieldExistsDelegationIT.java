    @Override
        // counts and — crucially — INFO is absent. Guards against a wrong-rows-same-total pass.  
        for (int i = 0; i < schema.size(); i++) {
            assertNotEquals("INFO must be excluded by !=", "INFO", row.get(0));
        for (List<Object> row : rows) {
    // below as control cases that must pass with the fix on or off.)
     * verifies the actual surviving rows (e.g. that INFO is truly excluded), not just a total.
 *
        if (dataProvisioned == false) {
 *  
        assertTrue("schema missing 'c'/'log_level' columns: " + schema, countCol >= 0 && levelCol >= 0);  
            String name = String.valueOf(schema.get(i).get("name"));
    public void testSearchOrEqualsKeyword() throws IOException {  
import java.util.HashMap;
     * Runs {@code <searchPrefix> | stats count() as c by log_level} and asserts the returned
 * Lucene {@code FieldExistsQuery}, which requires the field to index doc_values / norms / vectors.  
    }
        // fields projection (no stats) → value-returning scan; head bounds the payload.  
                levelCol = i;  
        String src = "search source=" + DATASET.indexName + " log_level!=\"INFO\"";
    /**  
        assertEquals("log_level → count map mismatch", expected, actual);
    private void assertCountsByLogLevel(String searchPrefix, Map<String, Long> expected) throws IOException {  
     * surviving log_level distribution (no INFO) by grouping, proving real rows came back.
    public void testSearchNotEqualsOtherKeyword() throws IOException {
        String src = "search source=" + DATASET.indexName + " service_name!=\"__nope__\"";  
        assertCountsByLogLevel(src, Map.of("ERROR", (long) ERROR, "WARN", (long) WARN));
        @SuppressWarnings("unchecked")
    public void testSearchNotFieldEqualsKeyword() throws IOException {
 *
        );
            if ("c".equals(name)) {  
            dataProvisioned = true;
        // service_name exists on every doc and is never "__nope__" → all 200 match, every level present.
     * REPRODUCER (non-count / value-returning): {@code search field!=v | fields ...} returns actual
            "search source=" + DATASET.indexName + " log_level=\"ERROR\" OR log_level=\"FATAL\" | stats count() as c",
        assertCount("search source=" + DATASET.indexName + " NOT log_level=\"INFO\" | stats count() as c", ERROR + WARN);
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
 * {@code FieldExistsQuery} into a postings-only {@code TermRangeQuery} before execution. These tests  
        }
        assertNotNull("Response missing 'datarows' for query: " + ppl, rows);
 * WARN=38 (200 docs total). All filtering routes through the delegation path.
    }
    }
 * lucene-secondary segment that filter delegation queries — so {@code FieldExistsQuery.rewrite()}
        for (List<Object> row : rows) {  
        Map<String, Object> response = executePpl(src + " | fields log_level | head 5");
        assertCountsByLogLevel(src, Map.of("ERROR", (long) ERROR, "INFO", (long) INFO, "WARN", (long) WARN));  
    public void testSearchEqualsKeywordBaseline() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        // And the full grouped distribution over the value-returning scan excludes INFO entirely.  
        List<Map<String, Object>> schema = (List<Map<String, Object>>) response.get("schema");  
        int countCol = -1;
     * (LuceneSearchExecEngine over the filter query) — a different code path from the stats-count  
 * Integration test for {@code !=} / {@code NOT field=value} predicates on keyword columns that
 * compatible open source license.
        assertCount(
        @SuppressWarnings("unchecked")
import java.util.Map;
    private void assertCount(String ppl, long expected) throws IOException {  
        }
        long actual = ((Number) rows.get(0).get(0)).longValue();  
    }
            }
        Map<String, Object> response = executePpl(searchPrefix + " | stats count() as c by log_level");
/**  
        // Locate the count vs log_level columns by name (column order is not guaranteed).
 */  
    // The bug reproducer is the PPL `search` command's {@code field != value} form. Per the SQL
    private static boolean dataProvisioned = false;
        assertNotNull("Response missing 'datarows'", rows);
            } else if ("log_level".equals(name)) {
    // plugin's own SearchCommandIT: `!=` means "field EXISTS and is not equal", so the frontend  
    }
        Map<String, Object> response = executePpl(ppl);
 * <p>Dataset {@code app_logs_filter_delegation}: keyword {@code log_level} with ERROR=115, INFO=47,  
            DatasetProvisioner.provision(client(), DATASET, 2);  
    }
        @SuppressWarnings("unchecked")
    }  
     * fast-path and from filter-delegation. Without the rewrite this 500s too. We assert the
    public void testSearchNotEqualsKeyword() throws IOException {
    }  
 * assert the queries now return the correct counts.
    /** CONTROL: Boolean OR over keyword equality — two terms, no _exists_. */
    }  
        Map<String, Long> actual = new HashMap<>();
        assertNotNull("Response missing 'datarows'", rows);
        String src = "search source=" + DATASET.indexName + " log_level!=\"INFO\"";
    private static final int ERROR = 115;
     * rows rather than a stats count, so it exercises the Lucene-driver SCAN path
    /** REPRODUCER: {@code !=} on a different keyword column → not field-specific. 500 before fix. */
                countCol = i;
 * <p>The PPL frontend desugars {@code field != "v"} (and {@code NOT field = "v"}) into a
     */  
    private static final int TOTAL = 200;  
     * level→count map equals {@code expected} exactly — same keys, same counts, no extras. This  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
    /** CONTROL: plain equality via search (no _exists_) still matches the known count. */
package org.opensearch.analytics.qa;
            // 2 shards so the predicate is delegated + reduced across shards (the failing topology).
 * The OpenSearch Contributors require contributions made to  
        assertCount("search source=" + DATASET.indexName + " log_level=\"INFO\" | stats count() as c", INFO);  
     */
 * throws ("indexes neither doc values, norms nor vectors") and the whole query 500s.  
        // Value check: the surviving log_levels are exactly {ERROR, WARN} with the right per-bucket
    private static final int WARN = 38;  
        }
    // `NOT field=value` and `OR` do NOT emit `_exists_`, so they don't hit the bug — they're kept  
 * {@code query_string} containing an {@code _exists_:field} clause. {@code _exists_} compiles to a
        assertCount(src + " | stats count() as c", TOTAL);
    // doc-values-less lucene-secondary without rewriteFieldExistsForSecondary. (By contrast
    /** REPRODUCER: {@code search log_level!="INFO"} → exists-and-not-INFO = ERROR + WARN. 500 before fix. */  
        }
    // ── helpers ──────────────────────────────────────────────────────────────────
    /** CONTROL: {@code NOT log_level="INFO"} excludes INFO without an _exists_ clause (no bug path). */  
/*  
        assertEquals("expected 5 rows", 5, rows.size());
    private static final Dataset DATASET = new Dataset("app_logs_filter_delegation", "app_logs_filter_delegation");
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
    /**
import java.io.IOException;
 */
 * are pushed to the lucene-secondary index via filter delegation.
    // emits a query_string with an `_exists_:field` clause → Lucene FieldExistsQuery → 500 on the
    protected void onBeforeQuery() throws IOException {  
            ERROR  
        assertEquals("Expected a single count row for query: " + ppl, 1, rows.size());
        int levelCol = -1;  
        @SuppressWarnings("unchecked")
 *
    private static final int INFO = 47;
 * On a composite parquet-primary index the keyword doc_values live in the parquet primary, NOT the
    public void testSearchNotEqualsReturnsRows() throws IOException {
        assertEquals("Count mismatch for query: " + ppl, expected, actual);
        assertCount(src + " | stats count() as c", ERROR + WARN);
        assertCountsByLogLevel(src, Map.of("ERROR", (long) ERROR, "WARN", (long) WARN));
            actual.put(String.valueOf(row.get(levelCol)), ((Number) row.get(countCol)).longValue());  
}
public class SearchFieldExistsDelegationIT extends AnalyticsRestTestCase {  
 * <p>{@code LuceneQueryConversionUtils.rewriteFieldExistsForSecondary} fixes this by rewriting the
        // Count check.  
