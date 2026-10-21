    private static final int NUM_DOCS = 4000;
    /**
            elapsedMs < 30_000L
    public void testSimpleAggregateSucceedsWithSpillDisabled() throws Exception {
    }
        for (int i = 0; i < NUM_DOCS; i++) {
            "Query took " + elapsedMs + "ms — exceeds 30s loose bound; investigate whether "
 * this file be licensed under the Apache-2.0 license or a
    protected Settings nodeSettings(int nodeOrdinal) {
        assertEquals(
            client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).setMapping("g", "type=integer").get().isAcknowledged()
     * A simple aggregate (no GROUP BY) must also succeed with spill disabled. This exercises
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("g", i % NUM_GROUPS));
 * reduce yields the same result), so the test additionally records query latency and asserts
import org.opensearch.common.util.FeatureFlags;
import java.util.List;
        );
        PPLResponse response = executePPL("source = " + INDEX_NAME + " | stats count()");
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
import org.opensearch.plugins.PluginInfo;
 *
        assertTrue(
        assertTrue(
     */
     * Note the deliberate omission of {@code datafusion.spill_directory} — that's the whole
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
     *       on the disabled path, the query still returns correct results — but the latency
            extendedPlugins,
    }
    @Override
 * unrelated work, raise the bound rather than skipping the assertion — the latency floor IS
import org.opensearch.test.OpenSearchIntegTestCase;
 * succeed and produce the correct number of groups. A regression that re-introduces the
        // well under a second. 30s gives ample headroom for slow CI yet still flags a true
            .put("index.pluggable.dataformat.enabled", true)
            .put("index.composite.primary_data_format", "parquet")
    /**
        long startNanos = System.nanoTime();
            .build();
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
    private PPLResponse executePPL(String query) {
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
    /**
 * check {@code memory_guard::per_query_spill_budget} must return {@code SpillBudget::Disabled}
            .build();
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        );
    private static final int NUM_GROUPS = 100;
import java.util.Collection;
public class SpillDisabledParallelismIT extends OpenSearchIntegTestCase {
            NUM_GROUPS,
            "1.8",
 * GROUP BY whose memory footprint fits comfortably under the default pool. The query MUST
import org.opensearch.analytics.AnalyticsPlugin;
     * <ol>
            "classpath plugin",
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * successfully when spill is disabled, with the correct number of groups. This guards
 * The OpenSearch Contributors require contributions made to
package org.opensearch.analytics.resilience;
        assertEquals("count() must return exactly one row", 1, response.getRows().size());
    public void testNonSpillingGroupByCompletesWithSpillDisabled() throws Exception {
        ensureGreen(INDEX_NAME);
     * setting) drives DataFusion into {@code DiskManagerMode::Disabled}.
        // multi-partition execution as shard count grows).
            .put(super.nodeSettings(nodeOrdinal))
    }
 * the entire pipeline.
     *   <li>If {@code per_query_spill_budget} ever drifts back to clamping parallelism to 1
 * <p>Latency-based assertion is intentionally loose: the bound is wide enough that healthy
        assertNotNull(response);
 * the regression signal.
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
import org.opensearch.composite.CompositeDataFormatPlugin;
/*
     *
import org.opensearch.Version;
     * </ol>
            .put("index.pluggable.dataformat", "composite")
     *   <li>If the disabled-spill path is broken at runtime construction (e.g. a panic from
import org.opensearch.ppl.TestPPLPlugin;
     *       bound below catches the throughput cliff.</li>
    @Override
import org.opensearch.ppl.action.PPLResponse;
 * hosts always pass, while a true regression to {@code target_partitions=1} on a multi-shard
/**
            .putList("index.composite.secondary_data_formats")
        // Loose throughput bound: a 4-shard, 4000-row GROUP BY on a healthy CI host completes
        createIndexAndIngest();
 * Integration test for the spill-disabled query path.
 * compatible open source license.
 */
 * unconditional 1-partition clamp would still pass the correctness assertion (single-threaded
        Settings indexSettings = Settings.builder()
    private static final String INDEX_NAME = "spill_disabled_test";
 * <p>When {@code datafusion.spill_directory} is unset, the DataFusion runtime is built with
 * — NOT a phantom "disk dying" signal that would clamp every query to one partition.
        PPLResponse response = executePPL("source = " + INDEX_NAME + " | stats count() by g");
    @Override
     */
import org.opensearch.be.datafusion.DataFusionPlugin;
 * {@code DiskManagerMode::Disabled}. In that configuration, the per-query disk-pressure
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
     * point of this test. The empty default (the new contract introduced alongside the
        refresh(INDEX_NAME);
        return List.of(ArrowBasePlugin.class, TestPPLPlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
        assertFalse("Bulk ingest should not have errors", bulkResponse.hasFailures());
            null,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 4)
import org.opensearch.ppl.action.PPLRequest;
 * <p>This test boots a cluster with no spill_directory configured and runs a coordinator-reduce
 */
        return new PluginInfo(
     * the simpler non-reduce path and ensures the disabled DiskManager doesn't break plain
    }
            .put(FeatureFlags.STREAM_TRANSPORT, true)
import org.opensearch.action.bulk.BulkResponse;
                + "per_query_spill_budget is incorrectly clamping target_partitions when spill is disabled",
}
    }
 * GROUP BY shows up consistently. If you see this test fail with a near-bound timing on
     * A GROUP BY query whose working set fits under the default memory pool MUST complete
     */
 *
     * against two regressions at once:
    private void createIndexAndIngest() throws Exception {
 *
import org.opensearch.action.bulk.BulkRequestBuilder;
            // datafusion.spill_directory is intentionally NOT set — empty default = spill disabled.
            pluginClass.getName(),
import org.opensearch.cluster.metadata.IndexMetadata;
            Version.CURRENT,
        createIndexAndIngest();
 * SPDX-License-Identifier: Apache-2.0
 * it stays under a generous bound — proving the query was not silently single-threaded for
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        BulkResponse bulkResponse = bulk.get();
import org.opensearch.plugins.Plugin;
            response.getRows().size()
            "NA",
    }
        BulkRequestBuilder bulk = client().prepareBulk();
import java.util.Collections;
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(query)).actionGet();
 *
        long elapsedMs = (System.nanoTime() - startNanos) / 1_000_000L;
    }
    }
            "GROUP BY g must yield " + NUM_GROUPS + " groups even with spill disabled",
            false
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
            pluginClass.getName(),
        );
        );
    protected Collection<PluginInfo> additionalNodePlugins() {
     * memory-only queries.
        }
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        return List.of(
import org.opensearch.common.settings.Settings;
        // single-threaded regression (which on the same workload trends 5–10× slower than
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        );
        return Settings.builder()
     *       a missing spill dir during DiskManager build), the query never even starts.</li>
        assertNotNull("Query response must not be null when spill is disabled", response);
