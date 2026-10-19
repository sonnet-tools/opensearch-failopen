    }  
import java.util.List;
            extendedPlugins,  
        client().admin().indices().prepareFlush(indexName).get();
 * </pre>
    }
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        assertEquals("inner equi-join row count", NUM_KEYS, response.getRows().size());
        // trait enforcer wraps each input in an OpenSearchExchangeReducer.  
import org.opensearch.common.util.FeatureFlags;
import java.util.Set;
 * compatible open source license.
            .put("index.composite.primary_data_format", "parquet")
        // are deterministic functions of the key.
/**
    /** Per-key formula for {@code t1.v}; arbitrary but deterministic so we can assert exact values. */
    private static int expectedV(int key) {
        );
import org.opensearch.composite.CompositeDataFormatPlugin;  
import org.opensearch.plugins.Plugin;
            .putList("index.composite.secondary_data_formats", List.of("lucene"))  
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
        // Each row must have the same key referenced from both sides; the v / w payloads
        // converts to OpenSearchJoin (under the LogicalProject), and Volcano's
        for (Object[] row : response.getRows()) {
            classpathPlugin(ParquetDataFormatPlugin.class, Collections.emptyList()),
    /** Number of overlapping keys (also rows per index) — keep small to keep the IT fast. */
import org.opensearch.plugins.PluginInfo;  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
import org.opensearch.ppl.action.PPLRequest;
            int key = ((Number) row[kIdx]).intValue();
 * End-to-end smoke test for the coordinator-side hash join path:
        for (int key = 1; key <= NUM_KEYS; key++) {
            "NA",
            .get();
        createParquetBackedIndex(T1, "v");
 *       → drain → downstream → assembled PPLResponse  
            "1.8",  
        int vIdx = response.getColumns().indexOf("v");
 * <p>Builds two parquet-backed indices ({@code t1}, {@code t2}) each with two shards  
    private void indexKeyedDocs(String indexName, String payloadField) {
     * 1..NUM_KEYS, so an INNER JOIN ON {@code k} returns NUM_KEYS rows.
        Set<Integer> seenKeys = new HashSet<>();  
            .put("index.pluggable.dataformat.enabled", true)  
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
    }
        return List.of(
        String ppl = "source=" + T1 + " | join on " + T1 + ".k = " + T2 + ".k " + T2;
package org.opensearch.be.datafusion;
            pluginClass.getName(),
 * and overlapping join keys, runs a PPL inner equi-join, and asserts that joined
        assertNotNull("PPLResponse must not be null", response);
            "classpath plugin",  
    @Override  
        assertTrue("response columns must include 'k', got " + response.getColumns(), response.getColumns().contains("k"));
import org.opensearch.ppl.TestPPLPlugin;
        createParquetBackedIndex(T2, "w");
import java.util.Collection;
    private static final String T2 = "join_e2e_t2";
import org.opensearch.ppl.action.PPLResponse;  
 *   PPL `join` → planner → 2 SHARD_FRAGMENT child stages (one per table)
            client().prepareIndex(indexName).setSource("k", key, payloadField, payload).get();
    private static final int NUM_KEYS = 6;
            .prepareCreate(indexName)
        CreateIndexResponse response = client().admin()  
public class CoordinatorJoinIT extends OpenSearchIntegTestCase {
            null,
            .put(super.nodeSettings(nodeOrdinal))
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.Version;
import org.opensearch.parquet.ParquetDataFormatPlugin;
    }
            assertEquals("v payload follows the per-key formula", expectedV(key), vCell);  
 */  
        Settings indexSettings = Settings.builder()  
            pluginClass.getName(),
            .indices()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        indexKeyedDocs(T2, "w");
            Version.CURRENT,
    @Override
            // STREAM_TRANSPORT intentionally OFF — see CoordinatorReduceIT for the rationale.
            assertEquals("w payload follows the per-key formula", expectedW(key), wCell);
            .build();
        );  
        // LogicalProject(LogicalJoin(scan(t1), scan(t2))) which our HEP marker
        int kIdx = response.getColumns().indexOf("k");  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
    }
import java.util.HashSet;  
    private PPLResponse executePPL(String ppl) {
}
            int vCell = ((Number) row[vIdx]).intValue();  
import org.opensearch.test.OpenSearchIntegTestCase;
 * <pre>
        }
        ensureGreen(indexName);
 *  
        assertTrue("index creation must be acknowledged", response.isAcknowledged());  
    }  
    }  
            .setMapping("k", "type=integer", payloadField, "type=integer")
    public void testInnerEquiJoinAcrossShards() throws Exception {  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
            .build();
        }  
        return List.of(TestPPLPlugin.class, FlightStreamPlugin.class, CompositeDataFormatPlugin.class, LucenePlugin.class);  
        client().admin().indices().prepareRefresh(indexName).get();  
            .setSettings(indexSettings)  
 *       → DataFusion executes JoinRel as HashJoinExec
    private static final int NUM_SHARDS = 2;  
 * The OpenSearch Contributors require contributions made to  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2)
        int wIdx = response.getColumns().indexOf("w");
            assertTrue("key in expected range, got " + key, key >= 1 && key <= NUM_KEYS);
    }  
    /**
     * Inner equi-join across two 2-shard indices. Each index has the same set of keys  
    private void createParquetBackedIndex(String indexName, String payloadField) {
    private static int expectedW(int key) {
import java.util.Collections;
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        return Settings.builder()
import org.opensearch.cluster.metadata.IndexMetadata;  
            assertTrue("each key appears at most once (no duplicates in source data)", seenKeys.add(key));
 *         partition streams ("input-0", "input-1") against one LocalSession
 *
            .put("index.pluggable.dataformat", "composite")
            false
        // Both sides have keys 1..NUM_KEYS, so the inner equi-join yields exactly NUM_KEYS rows.  
        return key * 10;  
            int wCell = ((Number) row[wIdx]).intValue();
     */
import org.opensearch.be.lucene.LucenePlugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
/*  
    /** Per-key formula for {@code t2.w}; distinct from v so column order matters in the assertion. */  
        assertEquals("every key in [1, NUM_KEYS] appears exactly once", NUM_KEYS, seenKeys.size());
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
        return new PluginInfo(
    }
        // PPL inner join on equality of `k`. The frontend lowers this to  
import org.opensearch.analytics.AnalyticsPlugin;  
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    @Override
    private static final String T1 = "join_e2e_t1";
            int payload = payloadField.equals("v") ? expectedV(key) : expectedW(key);  
        assertTrue("response columns must include 'w', got " + response.getColumns(), response.getColumns().contains("w"));
    protected Settings nodeSettings(int nodeOrdinal) {  
        indexKeyedDocs(T1, "v");  
        assertTrue("response columns must include 'v', got " + response.getColumns(), response.getColumns().contains("v"));  
import org.opensearch.common.settings.Settings;
        PPLResponse response = executePPL(ppl);
        return key * 100;
 * rows materialize.
    protected Collection<PluginInfo> additionalNodePlugins() {
 *       → ExchangeSink.feed(inputIndex, batch) → DatafusionReduceSink registers 2  
