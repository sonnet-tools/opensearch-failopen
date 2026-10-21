import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            PPLResponse response = executePPL("source = " + INDEX_NAME + " | stats count() by g");
        }
            .build();
            Version.CURRENT,
     */
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
    private static final int NUM_DOCS = 2000;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
        for (int partitions : new int[] { 1, 4, 16 }) {
        setReduceTargetPartitions(8);
    }
            setReduceTargetPartitions(partitions);
 * <ul>
            .put("index.pluggable.dataformat", "composite")
                response.getRows().size()
        assertTrue(response.isAcknowledged());
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        assertTrue(
import org.opensearch.ppl.action.PPLResponse;
    public void testReduceTargetPartitionsSettable() {
import org.opensearch.Version;
        return List.of(
            extendedPlugins,
    public void testReduceTargetPartitionsRejectsAboveMax() {
            () -> client().admin()
            false
            "1.8",
    }
        ClusterUpdateSettingsResponse response = client().admin()
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(query)).actionGet();
        assertFalse("Bulk ingest should not have errors", bulkResponse.hasFailures());
            .put("arrow.memory.debug.allocator", true)
                .cluster()
    protected Settings nodeSettings(int nodeOrdinal) {
 *       partition count is changed at runtime — exercising the setting end-to-end through
            IllegalArgumentException.class,
    private static final String INDEX_NAME = "reduce_target_partitions_test";
                .get()
 *       the native bridge into a freshly-created reduce session.</li>
            .put(super.nodeSettings(nodeOrdinal))
        return List.of(ArrowBasePlugin.class, TestPPLPlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
    }
import org.opensearch.common.util.FeatureFlags;
    private PPLResponse executePPL(String query) {
import org.opensearch.ppl.action.PPLRequest;
        createIndexAndIngest();
            client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).setMapping("g", "type=integer").get().isAcknowledged()
            pluginClass.getName(),
                .prepareUpdateSettings()
    }
            .put("index.composite.primary_data_format", "parquet")
    }
            .build();
                .cluster()
        BulkRequestBuilder bulk = client().prepareBulk();
    private static final String SETTING = "datafusion.reduce.target_partitions";
            .setTransientSettings(Settings.builder().put(SETTING, value).build())
     * A coordinator-reduce GROUP BY must produce the correct number of groups regardless of the
    }
    private void setReduceTargetPartitions(int value) {
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("g", i % NUM_GROUPS));
 * The OpenSearch Contributors require contributions made to
            pluginClass.getName(),
        Settings indexSettings = Settings.builder()
    public void testReduceCorrectAcrossPartitionCounts() throws Exception {
        refresh(INDEX_NAME);
    public void testReduceTargetPartitionsRejectsBelowMin() {
            .putList("index.composite.secondary_data_formats")
 */
 * SPDX-License-Identifier: Apache-2.0
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
}
            "NA",
     * configured reduce partition count. Running the same query at two different settings proves
            "classpath plugin",
 *   <li>The setting is dynamically updatable and acknowledged.</li>
            .put("index.pluggable.dataformat.enabled", true)
    /**
/*
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
    @Override
 * compatible open source license.
        for (int i = 0; i < NUM_DOCS; i++) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
    private static final int NUM_GROUPS = 50;
import org.opensearch.analytics.AnalyticsPlugin;
        return Settings.builder()
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
 * </ul>
 * Integration tests for the {@code datafusion.reduce.target_partitions} cluster setting,
 *
            .prepareUpdateSettings()
        ensureGreen(INDEX_NAME);
 *   <li>A coordinator-reduce query (GROUP BY) still produces correct results after the
package org.opensearch.analytics.resilience;
            .cluster()
import org.opensearch.plugins.PluginInfo;
    }
            .get();
                .get()
 * which controls the number of partitions the coordinator-reduce DataFusion session uses.
                .setTransientSettings(Settings.builder().put(SETTING, 33).build())
                NUM_GROUPS,
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
import org.opensearch.composite.CompositeDataFormatPlugin;
            IllegalArgumentException.class,
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
/**
public class ReduceTargetPartitionsIT extends OpenSearchIntegTestCase {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
import org.opensearch.plugins.Plugin;
            assertEquals(
import java.util.List;
        expectThrows(
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
import org.opensearch.ppl.TestPPLPlugin;
        );
    protected Collection<PluginInfo> additionalNodePlugins() {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.bulk.BulkResponse;
        }
        expectThrows(
        );
    @Override
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
        return new PluginInfo(
    private void createIndexAndIngest() throws Exception {
    @Override
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        BulkResponse bulkResponse = bulk.get();
    }
import org.opensearch.be.datafusion.DataFusionPlugin;
import java.util.Collections;
import java.util.Collection;
        assertEquals(String.valueOf(value), response.getTransientSettings().get(SETTING));
            );
    }
    }
        );
 * <p>Verifies:
            .put(FeatureFlags.STREAM_TRANSPORT, true)
     * the value flows through the native bridge into the reduce session without changing results.
        );
 *   <li>Out-of-range values (below 1, above 32) are rejected by validation.</li>
                .prepareUpdateSettings()
                "GROUP BY g must yield " + NUM_GROUPS + " groups at reduce.target_partitions=" + partitions,
            null,
        );
            () -> client().admin()
import org.opensearch.cluster.metadata.IndexMetadata;
 */
                .setTransientSettings(Settings.builder().put(SETTING, 0).build())
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
import org.opensearch.action.bulk.BulkRequestBuilder;
import org.opensearch.common.settings.Settings;
