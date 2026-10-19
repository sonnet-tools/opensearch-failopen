     *       a missing spill dir during DiskManager build), the query never even starts.</li>  
            "NA",
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 4)
        assertTrue(
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
 * GROUP BY shows up consistently. If you see this test fail with a near-bound timing on
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(query)).actionGet();
 * <p>Latency-based assertion is intentionally loose: the bound is wide enough that healthy  
        assertEquals(
        );  
     * memory-only queries.
import org.opensearch.action.bulk.BulkResponse;  
import org.opensearch.plugins.Plugin;
        );  
import org.opensearch.analytics.AnalyticsPlugin;
     */
    private void createIndexAndIngest() throws Exception {  
/**
            extendedPlugins,
import org.opensearch.ppl.action.PPLRequest;
        createIndexAndIngest();
     * point of this test. The empty default (the new contract introduced alongside the
}  
            .put(super.nodeSettings(nodeOrdinal))
 * <p>When {@code datafusion.spill_directory} is unset, the DataFusion runtime is built with
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
            NUM_GROUPS,
            .put("index.pluggable.dataformat.enabled", true)
     * the simpler non-reduce path and ensures the disabled DiskManager doesn't break plain  
     *   <li>If the disabled-spill path is broken at runtime construction (e.g. a panic from
        );
        return new PluginInfo(
            .put(FeatureFlags.STREAM_TRANSPORT, true)
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;  
    private static final String INDEX_NAME = "spill_disabled_test";  
        PPLResponse response = executePPL("source = " + INDEX_NAME + " | stats count()");
    /**
            .put("index.composite.primary_data_format", "parquet")  
            client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).setMapping("g", "type=integer").get().isAcknowledged()
    public void testSimpleAggregateSucceedsWithSpillDisabled() throws Exception {  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
import org.opensearch.composite.CompositeDataFormatPlugin;
import org.opensearch.action.bulk.BulkRequestBuilder;
import org.opensearch.be.datafusion.DataFusionPlugin;
 * check {@code memory_guard::per_query_spill_budget} must return {@code SpillBudget::Disabled}
            pluginClass.getName(),  
    }
 * unconditional 1-partition clamp would still pass the correctness assertion (single-threaded
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
import org.opensearch.ppl.action.PPLResponse;  
            "classpath plugin",
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        assertNotNull("Query response must not be null when spill is disabled", response);
            elapsedMs < 30_000L  
     *       on the disabled path, the query still returns correct results — but the latency
 * {@code DiskManagerMode::Disabled}. In that configuration, the per-query disk-pressure  
 * the regression signal.
        assertTrue(  
    }
    protected Collection<PluginInfo> additionalNodePlugins() {
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;  
    }  
    }
    }
import org.opensearch.common.util.FeatureFlags;
    }
 * unrelated work, raise the bound rather than skipping the assertion — the latency floor IS  
        assertEquals("count() must return exactly one row", 1, response.getRows().size());
            "GROUP BY g must yield " + NUM_GROUPS + " groups even with spill disabled",  
        // well under a second. 30s gives ample headroom for slow CI yet still flags a true  
import java.util.Collections;
        BulkResponse bulkResponse = bulk.get();  
 * hosts always pass, while a true regression to {@code target_partitions=1} on a multi-shard
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * succeed and produce the correct number of groups. A regression that re-introduces the  
/*  
 * it stays under a generous bound — proving the query was not silently single-threaded for  
        assertNotNull(response);  
    /**
    @Override  
     */
    @Override
    public void testNonSpillingGroupByCompletesWithSpillDisabled() throws Exception {  
        );  
        assertFalse("Bulk ingest should not have errors", bulkResponse.hasFailures());
package org.opensearch.analytics.resilience;
import org.opensearch.Version;
            "Query took " + elapsedMs + "ms — exceeds 30s loose bound; investigate whether "
        // single-threaded regression (which on the same workload trends 5–10× slower than
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))  
            null,  
        return List.of(ArrowBasePlugin.class, TestPPLPlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);  
 *
import org.opensearch.cluster.metadata.IndexMetadata;
 */
            .build();  
        long startNanos = System.nanoTime();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)  
     * </ol>
            "1.8",
     * <ol>
 *  
    private PPLResponse executePPL(String query) {
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),  
        return Settings.builder()
        Settings indexSettings = Settings.builder()
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
     * A GROUP BY query whose working set fits under the default memory pool MUST complete  
        }
    @Override
        long elapsedMs = (System.nanoTime() - startNanos) / 1_000_000L;
     *   <li>If {@code per_query_spill_budget} ever drifts back to clamping parallelism to 1
import org.opensearch.common.settings.Settings;  
    private static final int NUM_GROUPS = 100;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            pluginClass.getName(),
import org.opensearch.ppl.TestPPLPlugin;
 * compatible open source license.
     */
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("g", i % NUM_GROUPS));
        refresh(INDEX_NAME);  
            .build();
        createIndexAndIngest();
        );
            response.getRows().size()
 */  
                + "per_query_spill_budget is incorrectly clamping target_partitions when spill is disabled",
        PPLResponse response = executePPL("source = " + INDEX_NAME + " | stats count() by g");
 * — NOT a phantom "disk dying" signal that would clamp every query to one partition.
 * Integration test for the spill-disabled query path.  
     * setting) drives DataFusion into {@code DiskManagerMode::Disabled}.  
 * GROUP BY whose memory footprint fits comfortably under the default pool. The query MUST
 * reduce yields the same result), so the test additionally records query latency and asserts
            Version.CURRENT,  
 * the entire pipeline.
public class SpillDisabledParallelismIT extends OpenSearchIntegTestCase {
     *       bound below catches the throughput cliff.</li>  
        BulkRequestBuilder bulk = client().prepareBulk();
        // multi-partition execution as shard count grows).
            .putList("index.composite.secondary_data_formats")
     * against two regressions at once:
        ensureGreen(INDEX_NAME);
     * Note the deliberate omission of {@code datafusion.spill_directory} — that's the whole
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.plugins.PluginInfo;  
 * this file be licensed under the Apache-2.0 license or a
            false
    protected Settings nodeSettings(int nodeOrdinal) {  
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchIntegTestCase;
        return List.of(
 * <p>This test boots a cluster with no spill_directory configured and runs a coordinator-reduce
    private static final int NUM_DOCS = 4000;
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
import java.util.Collection;
     * A simple aggregate (no GROUP BY) must also succeed with spill disabled. This exercises
        // Loose throughput bound: a 4-shard, 4000-row GROUP BY on a healthy CI host completes
 *
     * successfully when spill is disabled, with the correct number of groups. This guards
        for (int i = 0; i < NUM_DOCS; i++) {  
    }
    /**  
            // datafusion.spill_directory is intentionally NOT set — empty default = spill disabled.
    }
     *  
