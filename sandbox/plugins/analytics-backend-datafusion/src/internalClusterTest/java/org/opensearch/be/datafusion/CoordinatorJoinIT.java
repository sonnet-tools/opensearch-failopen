    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        Settings indexSettings = Settings.builder()
 */
            client().prepareIndex(indexName).setSource("k", key, payloadField, payload).get();
            .setSettings(indexSettings)
            null,
    private static final String T1 = "join_e2e_t1";
    }
    }
 * End-to-end smoke test for the coordinator-side hash join path:
import org.opensearch.ppl.TestPPLPlugin;
        // Both sides have keys 1..NUM_KEYS, so the inner equi-join yields exactly NUM_KEYS rows.
public class CoordinatorJoinIT extends OpenSearchIntegTestCase {
            assertTrue("each key appears at most once (no duplicates in source data)", seenKeys.add(key));
            .get();
        for (Object[] row : response.getRows()) {
        Set<Integer> seenKeys = new HashSet<>();
     * Inner equi-join across two 2-shard indices. Each index has the same set of keys
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
    @Override
        createParquetBackedIndex(T1, "v");
    /** Number of overlapping keys (also rows per index) — keep small to keep the IT fast. */
 */
import java.util.HashSet;
            assertEquals("w payload follows the per-key formula", expectedW(key), wCell);
            .put("index.pluggable.dataformat", "composite")
    public void testInnerEquiJoinAcrossShards() throws Exception {
        return new PluginInfo(
        assertTrue("response columns must include 'v', got " + response.getColumns(), response.getColumns().contains("v"));
        int wIdx = response.getColumns().indexOf("w");
    }
     * 1..NUM_KEYS, so an INNER JOIN ON {@code k} returns NUM_KEYS rows.
        assertEquals("every key in [1, NUM_KEYS] appears exactly once", NUM_KEYS, seenKeys.size());
        return List.of(
            "1.8",
        // Each row must have the same key referenced from both sides; the v / w payloads
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            classpathPlugin(ParquetDataFormatPlugin.class, Collections.emptyList()),
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
import org.opensearch.common.util.FeatureFlags;
    /**
        );
        assertTrue("response columns must include 'w', got " + response.getColumns(), response.getColumns().contains("w"));
            pluginClass.getName(),
            // STREAM_TRANSPORT intentionally OFF — see CoordinatorReduceIT for the rationale.
    private static int expectedV(int key) {
        indexKeyedDocs(T1, "v");
    private void indexKeyedDocs(String indexName, String payloadField) {
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
 *
    }
        ensureGreen(indexName);
 * SPDX-License-Identifier: Apache-2.0
        }
            .setMapping("k", "type=integer", payloadField, "type=integer")
        for (int key = 1; key <= NUM_KEYS; key++) {
 * <pre>
import org.opensearch.common.settings.Settings;
    private static final String T2 = "join_e2e_t2";
    private static int expectedW(int key) {
    /** Per-key formula for {@code t1.v}; arbitrary but deterministic so we can assert exact values. */
import java.util.Collection;
package org.opensearch.be.datafusion;
            .prepareCreate(indexName)
            .indices()
 *
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        String ppl = "source=" + T1 + " | join on " + T1 + ".k = " + T2 + ".k " + T2;
            "classpath plugin",
}
        client().admin().indices().prepareFlush(indexName).get();
import org.opensearch.composite.CompositeDataFormatPlugin;
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
 *       → drain → downstream → assembled PPLResponse
            "NA",
    private void createParquetBackedIndex(String indexName, String payloadField) {
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        int vIdx = response.getColumns().indexOf("v");
            false
        createParquetBackedIndex(T2, "w");
    /** Per-key formula for {@code t2.w}; distinct from v so column order matters in the assertion. */
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
import org.opensearch.parquet.ParquetDataFormatPlugin;
        // LogicalProject(LogicalJoin(scan(t1), scan(t2))) which our HEP marker
        PPLResponse response = executePPL(ppl);
 *   PPL `join` → planner → 2 SHARD_FRAGMENT child stages (one per table)
        // converts to OpenSearchJoin (under the LogicalProject), and Volcano's
            int vCell = ((Number) row[vIdx]).intValue();
 * rows materialize.
        }
        assertEquals("inner equi-join row count", NUM_KEYS, response.getRows().size());
    @Override
        assertNotNull("PPLResponse must not be null", response);
 * and overlapping join keys, runs a PPL inner equi-join, and asserts that joined
            assertEquals("v payload follows the per-key formula", expectedV(key), vCell);
 *         partition streams ("input-0", "input-1") against one LocalSession
import org.opensearch.plugins.Plugin;
    protected Collection<PluginInfo> additionalNodePlugins() {
        int kIdx = response.getColumns().indexOf("k");
            .build();
        assertTrue("response columns must include 'k', got " + response.getColumns(), response.getColumns().contains("k"));
            int key = ((Number) row[kIdx]).intValue();
 * The OpenSearch Contributors require contributions made to
    }
        // are deterministic functions of the key.
import org.opensearch.Version;
/*
        // trait enforcer wraps each input in an OpenSearchExchangeReducer.
import org.opensearch.be.lucene.LucenePlugin;
            .put(super.nodeSettings(nodeOrdinal))
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            extendedPlugins,
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
 * compatible open source license.
        // PPL inner join on equality of `k`. The frontend lowers this to
import org.opensearch.ppl.action.PPLResponse;
    protected Settings nodeSettings(int nodeOrdinal) {
    private PPLResponse executePPL(String ppl) {
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        client().admin().indices().prepareRefresh(indexName).get();
 *       → DataFusion executes JoinRel as HashJoinExec
        return List.of(TestPPLPlugin.class, FlightStreamPlugin.class, CompositeDataFormatPlugin.class, LucenePlugin.class);
    private static final int NUM_KEYS = 6;
    @Override
 *
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    private static final int NUM_SHARDS = 2;
/**
        CreateIndexResponse response = client().admin()
            pluginClass.getName(),
            Version.CURRENT,
 * </pre>
        );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2)
    }
            .build();
 * <p>Builds two parquet-backed indices ({@code t1}, {@code t2}) each with two shards
import org.opensearch.ppl.action.PPLRequest;
        return Settings.builder()
        return key * 10;
 * this file be licensed under the Apache-2.0 license or a
            .put("index.composite.primary_data_format", "parquet")
import org.opensearch.analytics.AnalyticsPlugin;
     */
            int wCell = ((Number) row[wIdx]).intValue();
        return key * 100;
import java.util.Collections;
            assertTrue("key in expected range, got " + key, key >= 1 && key <= NUM_KEYS);
            int payload = payloadField.equals("v") ? expectedV(key) : expectedW(key);
import org.opensearch.test.OpenSearchIntegTestCase;
        indexKeyedDocs(T2, "w");
 *       → ExchangeSink.feed(inputIndex, batch) → DatafusionReduceSink registers 2
    }
import java.util.Set;
            .put("index.pluggable.dataformat.enabled", true)
import java.util.List;
import org.opensearch.plugins.PluginInfo;
