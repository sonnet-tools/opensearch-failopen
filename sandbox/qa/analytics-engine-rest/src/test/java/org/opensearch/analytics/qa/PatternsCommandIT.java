            List<Object> r = rows.get(i);
        Map<String, Object> response = executePplViaShim(
        Map<String, Object> response = executePplViaShim(
            200L,
        }
    }
            assertNotNull("patterns_field at row " + i, r.get(0));
            Request settingsRequest = new Request("GET", "/" + DATASET_MULTI.indexName + "/_settings");
/** Integration tests for PPL {@code patterns} on the analytics-engine route. */
        );
    public void testSimplePatternAggregationModeMultiShard() throws IOException {
                + " | fields patterns_field, pattern_count, sample_logs"
            List<Object> samples = (List<Object>) r.get(2);
            assertTrue("Unexpected service at row " + i + ": " + svc,
    private static String extractShardCount(Map<String, Object> settings, String indexName) {
        ensureMultiShardProvisioned();
        );
        ensureMultiShardProvisioned();
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
    @Override
        assertEquals(
            assertEquals("Multi-shard index must report number_of_shards=3", "3", shardCount);
        Map<String, Object> settingsSection = (Map<String, Object>) indexSection.get("settings");
                + " | fields patterns_field, service_name, c, sample_logs"
            assertTrue("group count > 0 at row " + i, ((Number) r.get(2)).longValue() > 0);
import org.opensearch.client.Response;
        Map<String, Object> response = executePplViaShim(
    public void testSimplePatternLabelMode() throws IOException {
import org.opensearch.client.Request;
    protected void onBeforeQuery() throws IOException {
        }
            assertNotNull("patterns_field at row " + i + " should not be null", v);
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            assertEquals("Row " + i + " has 3 columns", 3, r.size());
        List<List<Object>> rows = (List<List<Object>>) response.get("rows");
        ensureDataProvisioned();
import java.util.List;
        for (int i = 0; i < rows.size(); i++) {
        assertTrue("Expected at least one (pattern, service) group", rows.size() >= 1);
            assertEquals("take(message, 1) returns exactly 1 sample", 1, sample.size());
                + " | patterns message method=simple_pattern mode=label"
            Response settingsResponse = client().performRequest(settingsRequest);
            List<Object> sample = (List<Object>) r.get(3);
        }
    // ── helpers ─────────────────────────────────────────────────────────────────
}
        assertNotNull("Response missing 'rows'", rows);
            "source=" + DATASET_MULTI.indexName
    /** Provision a 3-shard {@code app_logs} index to drive the SINGLE-on-SINGLETON fallback. */
        Map<String, Object> indexSection = (Map<String, Object>) settings.get(indexName);
    }
    private static final Dataset DATASET_MULTI = new Dataset("app_logs", "app_logs_patterns_multi");
            assertTrue("patterns_field at row " + i + " contains <*>", r.get(0).toString().contains("<*>"));
 */
                v.toString().contains("<*>"));
        if (dataProvisioned == false) {
    private static final Dataset DATASET = new Dataset("app_logs", "app_logs");
            Object v = rows.get(i).get(0);
            @SuppressWarnings("unchecked")
    public void testSimplePatternAggregationGroupByServiceMultiShard() throws IOException {
            assertTrue("pattern_count > 0 at row " + i, ((Number) r.get(1)).longValue() > 0);
            200L,
    }
            List<Object> r = rows.get(i);
import java.util.Map;
        for (int i = 0; i < rows.size(); i++) {
            total
        );
            String svc = (String) r.get(1);
        for (int i = 0; i < rows.size(); i++) {
            "source=" + DATASET_MULTI.indexName
        @SuppressWarnings("unchecked")
            @SuppressWarnings("unchecked")
            "pattern_count totals must equal the dataset document count (200 docs distributed"
            assertTrue("patterns_field at row " + i + " contains <*>", r.get(0).toString().contains("<*>"));
 *
    @SuppressWarnings("unchecked")
    }
        Map<String, Object> indexSettings = (Map<String, Object>) settingsSection.get("index");
            total
        assertNotNull("Response missing 'rows'", rows);
            multiProvisioned = true;
    }
            assertEquals("Row " + i + " has 4 columns", 4, r.size());
                svc.equals("api-service") || svc.equals("auth-service")
public class PatternsCommandIT extends AnalyticsRestTestCase {
            DatasetProvisioner.provision(client(), DATASET_MULTI, 3);
    @AwaitsFix(bugUrl = "patterns mode=aggregation auto-generates take(message, 10) but the literal 10 resolves to UNDEFINED in the PPL type checker: 'Aggregation function TAKE expects {[ANY]|[ANY,INTEGER]}, but got [STRING,UNDEFINED]'. Frontend type-resolution bug in the patterns-aggregation lowering (unified-query / CalciteRelNodeVisitor.visitPatterns), surfaced by the upstream BRAIN/SIMPLE patterns merge. Explicit take(message,1) works (see sibling testSimplePatternAggregationGroupByServiceMultiShard); only the auto-generated N is mistyped. Needs an opensearch-sql fix, out of scope for analytics-engine.")
                + " | stats count() as c, take(message, 1) as sample_logs"
            DatasetProvisioner.provision(client(), DATASET);
        @SuppressWarnings("unchecked")
            total += ((Number) r.get(2)).longValue();
    }
            assertTrue("patterns_field at row " + i + " should contain '<*>': " + v,
/*
        );
            "group counts must sum to the dataset total (200 docs distributed across 3 shards)",
        }
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(
        List<List<Object>> rows = (List<List<Object>>) response.get("rows");
            Map<String, Object> settings = assertOkAndParse(settingsResponse, "settings: " + DATASET_MULTI.indexName);
        long total = 0;
                + " across 3 shards)",
 * SPDX-License-Identifier: Apache-2.0
            assertTrue("sample_logs is a List at row " + i, r.get(2) instanceof List);
        assertEquals("label mode preserves row count", 200, rows.size());
                    || svc.equals("db-service") || svc.equals("web-service"));
                + " | fields patterns_field"
        assertNotNull("Response missing 'rows'", rows);
package org.opensearch.analytics.qa;
        @SuppressWarnings("unchecked")
import java.io.IOException;
            total += ((Number) r.get(1)).longValue();
        List<List<Object>> rows = (List<List<Object>>) response.get("rows");
        );
    private static boolean dataProvisioned = false;
    private void ensureDataProvisioned() throws IOException {
            String shardCount = extractShardCount(settings, DATASET_MULTI.indexName);
                + " | patterns message method=simple_pattern mode=label"
            dataProvisioned = true;
        assertNotNull("Settings response missing index entry", indexSection);
                + " | patterns message method=simple_pattern mode=aggregation"
    private static boolean multiProvisioned = false;
    }
        }
    private void ensureMultiShardProvisioned() throws IOException {
                + "     by patterns_field, service_name"
        if (multiProvisioned == false) {
            assertFalse("sample_logs non-empty at row " + i, samples.isEmpty());
        long total = 0;
        return String.valueOf(indexSettings.get("number_of_shards"));
        assertTrue("Expected at least one cluster", rows.size() >= 1);
            "source=" + DATASET.indexName
