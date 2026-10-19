        for (int partitions : new int[] { 1, 4, 16 }) {
}
            assertEquals(
    public void testReduceCorrectAcrossPartitionCounts() throws Exception {
        return List.of(
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(query)).actionGet();
import java.util.List;
    private static final int NUM_GROUPS = 50;
        );  
        return Settings.builder()
            () -> client().admin()  
        ClusterUpdateSettingsResponse response = client().admin()  
            pluginClass.getName(),
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
        );
        }
                NUM_GROUPS,  
    @Override
        refresh(INDEX_NAME);  
    protected Settings nodeSettings(int nodeOrdinal) {  
    /**
                response.getRows().size()
            "NA",
                "GROUP BY g must yield " + NUM_GROUPS + " groups at reduce.target_partitions=" + partitions,
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
    public void testReduceTargetPartitionsRejectsBelowMin() {
 * this file be licensed under the Apache-2.0 license or a
    }
 * compatible open source license.
    private void createIndexAndIngest() throws Exception {  
    private static final String INDEX_NAME = "reduce_target_partitions_test";
        );  
            extendedPlugins,  
 *
                .get()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
    }
    }  
        setReduceTargetPartitions(8);
        assertTrue(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            .put(super.nodeSettings(nodeOrdinal))
        expectThrows(
 */  
 * which controls the number of partitions the coordinator-reduce DataFusion session uses.
/**  
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.common.util.FeatureFlags;
    }
     * configured reduce partition count. Running the same query at two different settings proves
    }
            .setTransientSettings(Settings.builder().put(SETTING, value).build())  
            .cluster()
        assertFalse("Bulk ingest should not have errors", bulkResponse.hasFailures());
     * the value flows through the native bridge into the reduce session without changing results.
    }  
import org.opensearch.test.OpenSearchIntegTestCase;  
import java.util.Collections;  
    }  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.common.settings.Settings;
                .cluster()
    protected Collection<PluginInfo> additionalNodePlugins() {  
        );  
    }
    private void setReduceTargetPartitions(int value) {
import org.opensearch.action.bulk.BulkResponse;
 *   <li>Out-of-range values (below 1, above 32) are rejected by validation.</li>
package org.opensearch.analytics.resilience;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
        ensureGreen(INDEX_NAME);
            .build();
        Settings indexSettings = Settings.builder()
            IllegalArgumentException.class,
 * <p>Verifies:
        return List.of(ArrowBasePlugin.class, TestPPLPlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
import org.opensearch.ppl.action.PPLResponse;
import org.opensearch.be.datafusion.DataFusionPlugin;
import org.opensearch.ppl.action.PPLRequest;  
            );
            .prepareUpdateSettings()
        BulkRequestBuilder bulk = client().prepareBulk();
        return new PluginInfo(
 * <ul>
            .build();  
     */  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
 *   <li>The setting is dynamically updatable and acknowledged.</li>  
            "1.8",  
            false
        createIndexAndIngest();
 *       partition count is changed at runtime — exercising the setting end-to-end through  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("g", i % NUM_GROUPS));
        for (int i = 0; i < NUM_DOCS; i++) {  
            .put("index.pluggable.dataformat.enabled", true)
            .get();
                .prepareUpdateSettings()  
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
import org.opensearch.plugins.Plugin;  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
 *       the native bridge into a freshly-created reduce session.</li>
            .put("arrow.memory.debug.allocator", true)
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
            setReduceTargetPartitions(partitions);
            "classpath plugin",  
import org.opensearch.Version;
    public void testReduceTargetPartitionsSettable() {  
    private PPLResponse executePPL(String query) {
        }  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            .put(FeatureFlags.STREAM_TRANSPORT, true)
 *  
    }
                .cluster()
import org.opensearch.analytics.AnalyticsPlugin;
            PPLResponse response = executePPL("source = " + INDEX_NAME + " | stats count() by g");  
import org.opensearch.ppl.TestPPLPlugin;
            pluginClass.getName(),
            null,
            .put("index.composite.primary_data_format", "parquet")  
        expectThrows(
        assertEquals(String.valueOf(value), response.getTransientSettings().get(SETTING));  
        BulkResponse bulkResponse = bulk.get();  
    public void testReduceTargetPartitionsRejectsAboveMax() {  
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
                .prepareUpdateSettings()
 *   <li>A coordinator-reduce query (GROUP BY) still produces correct results after the
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    @Override
    }  
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
    @Override  
            IllegalArgumentException.class,  
    private static final int NUM_DOCS = 2000;  
                .get()
import org.opensearch.plugins.PluginInfo;
        );
        assertTrue(response.isAcknowledged());
            () -> client().admin()
                .setTransientSettings(Settings.builder().put(SETTING, 0).build())
    private static final String SETTING = "datafusion.reduce.target_partitions";
import org.opensearch.composite.CompositeDataFormatPlugin;  
/*  
            Version.CURRENT,
import org.opensearch.action.bulk.BulkRequestBuilder;  
public class ReduceTargetPartitionsIT extends OpenSearchIntegTestCase {
 */  
            client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).setMapping("g", "type=integer").get().isAcknowledged()
 * The OpenSearch Contributors require contributions made to  
            .putList("index.composite.secondary_data_formats")
 * Integration tests for the {@code datafusion.reduce.target_partitions} cluster setting,
 * </ul>
     * A coordinator-reduce GROUP BY must produce the correct number of groups regardless of the  
import java.util.Collection;
 * SPDX-License-Identifier: Apache-2.0
                .setTransientSettings(Settings.builder().put(SETTING, 33).build())  
