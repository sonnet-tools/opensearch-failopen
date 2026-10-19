            String svc = (String) r.get(1);  
import java.util.List;
            assertTrue("pattern_count > 0 at row " + i, ((Number) r.get(1)).longValue() > 0);  
        for (int i = 0; i < rows.size(); i++) {
                    || svc.equals("db-service") || svc.equals("web-service"));  
    private static boolean dataProvisioned = false;
                svc.equals("api-service") || svc.equals("auth-service")
    }
        ensureDataProvisioned();  
    private static boolean multiProvisioned = false;
        return String.valueOf(indexSettings.get("number_of_shards"));  
        Map<String, Object> response = executePplViaShim(
    }
        }  
            "pattern_count totals must equal the dataset document count (200 docs distributed"
        ensureMultiShardProvisioned();
        }  
        if (multiProvisioned == false) {
                + " | fields patterns_field, service_name, c, sample_logs"
            multiProvisioned = true;  
                + " | patterns message method=simple_pattern mode=aggregation"
    private static String extractShardCount(Map<String, Object> settings, String indexName) {
            Map<String, Object> settings = assertOkAndParse(settingsResponse, "settings: " + DATASET_MULTI.indexName);  
/*  
        Map<String, Object> indexSection = (Map<String, Object>) settings.get(indexName);
 *
                + " | patterns message method=simple_pattern mode=label"
    @AwaitsFix(bugUrl = "patterns mode=aggregation auto-generates take(message, 10) but the literal 10 resolves to UNDEFINED in the PPL type checker: 'Aggregation function TAKE expects {[ANY]|[ANY,INTEGER]}, but got [STRING,UNDEFINED]'. Frontend type-resolution bug in the patterns-aggregation lowering (unified-query / CalciteRelNodeVisitor.visitPatterns), surfaced by the upstream BRAIN/SIMPLE patterns merge. Explicit take(message,1) works (see sibling testSimplePatternAggregationGroupByServiceMultiShard); only the auto-generated N is mistyped. Needs an opensearch-sql fix, out of scope for analytics-engine.")  
            assertTrue("Unexpected service at row " + i + ": " + svc,
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            List<Object> sample = (List<Object>) r.get(3);
            Response settingsResponse = client().performRequest(settingsRequest);
        Map<String, Object> response = executePplViaShim(  
            assertEquals("Row " + i + " has 4 columns", 4, r.size());
    }
            assertTrue("patterns_field at row " + i + " contains <*>", r.get(0).toString().contains("<*>"));
    public void testSimplePatternLabelMode() throws IOException {  
        assertEquals("label mode preserves row count", 200, rows.size());  
public class PatternsCommandIT extends AnalyticsRestTestCase {
            "source=" + DATASET_MULTI.indexName  
    public void testSimplePatternAggregationModeMultiShard() throws IOException {
        }  
            @SuppressWarnings("unchecked")  
                + "     by patterns_field, service_name"  
                + " | patterns message method=simple_pattern mode=label"  
        assertNotNull("Response missing 'rows'", rows);
            @SuppressWarnings("unchecked")  
        assertNotNull("Response missing 'rows'", rows);
}
        for (int i = 0; i < rows.size(); i++) {
        );  
            String shardCount = extractShardCount(settings, DATASET_MULTI.indexName);
            total += ((Number) r.get(2)).longValue();
        assertTrue("Expected at least one (pattern, service) group", rows.size() >= 1);  
            total
            assertEquals("Row " + i + " has 3 columns", 3, r.size());  
 * SPDX-License-Identifier: Apache-2.0
        List<List<Object>> rows = (List<List<Object>>) response.get("rows");
    private static final Dataset DATASET = new Dataset("app_logs", "app_logs");
                v.toString().contains("<*>"));
        for (int i = 0; i < rows.size(); i++) {
            assertFalse("sample_logs non-empty at row " + i, samples.isEmpty());
            assertTrue("group count > 0 at row " + i, ((Number) r.get(2)).longValue() > 0);
    public void testSimplePatternAggregationGroupByServiceMultiShard() throws IOException {  
            "source=" + DATASET_MULTI.indexName
    }  
            List<Object> r = rows.get(i);
                + " | fields patterns_field"
        }
import org.opensearch.client.Response;
 */  
    }  
        );
        assertNotNull("Settings response missing index entry", indexSection);  
            dataProvisioned = true;
        @SuppressWarnings("unchecked")  
                + " | fields patterns_field, pattern_count, sample_logs"  
            List<Object> samples = (List<Object>) r.get(2);
            List<Object> r = rows.get(i);  
    private void ensureMultiShardProvisioned() throws IOException {  
        Map<String, Object> response = executePplViaShim(
/** Integration tests for PPL {@code patterns} on the analytics-engine route. */
                + " across 3 shards)",  
        assertEquals(
        }  
            Request settingsRequest = new Request("GET", "/" + DATASET_MULTI.indexName + "/_settings");
    /** Provision a 3-shard {@code app_logs} index to drive the SINGLE-on-SINGLETON fallback. */
        Map<String, Object> indexSettings = (Map<String, Object>) settingsSection.get("index");
    }
    private static final Dataset DATASET_MULTI = new Dataset("app_logs", "app_logs_patterns_multi");
        long total = 0;  
        assertNotNull("Response missing 'rows'", rows);
        @SuppressWarnings("unchecked")  
            "source=" + DATASET.indexName
        Map<String, Object> settingsSection = (Map<String, Object>) indexSection.get("settings");
                + " | stats count() as c, take(message, 1) as sample_logs"
    @SuppressWarnings("unchecked")  
        long total = 0;
            assertTrue("patterns_field at row " + i + " contains <*>", r.get(0).toString().contains("<*>"));
        if (dataProvisioned == false) {
            assertTrue("sample_logs is a List at row " + i, r.get(2) instanceof List);
            total
        List<List<Object>> rows = (List<List<Object>>) response.get("rows");
            DatasetProvisioner.provision(client(), DATASET);  
        assertEquals(
            "group counts must sum to the dataset total (200 docs distributed across 3 shards)",
 * this file be licensed under the Apache-2.0 license or a
    @Override
            Object v = rows.get(i).get(0);
import java.io.IOException;  
        );
            assertTrue("patterns_field at row " + i + " should contain '<*>': " + v,
 * compatible open source license.
    // ── helpers ─────────────────────────────────────────────────────────────────
        );
    }
        ensureMultiShardProvisioned();
import org.opensearch.client.Request;  
            total += ((Number) r.get(1)).longValue();
        );
        assertTrue("Expected at least one cluster", rows.size() >= 1);
package org.opensearch.analytics.qa;
        @SuppressWarnings("unchecked")
            assertEquals("take(message, 1) returns exactly 1 sample", 1, sample.size());
            DatasetProvisioner.provision(client(), DATASET_MULTI, 3);
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
            assertNotNull("patterns_field at row " + i, r.get(0));
            assertNotNull("patterns_field at row " + i + " should not be null", v);  
    protected void onBeforeQuery() throws IOException {
            200L,  
            200L,
            assertEquals("Multi-shard index must report number_of_shards=3", "3", shardCount);
    private void ensureDataProvisioned() throws IOException {
        List<List<Object>> rows = (List<List<Object>>) response.get("rows");  
