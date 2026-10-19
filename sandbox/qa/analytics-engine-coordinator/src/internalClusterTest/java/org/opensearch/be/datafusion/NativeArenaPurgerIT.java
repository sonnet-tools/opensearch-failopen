            var bulkRequest = client().prepareBulk();
        flush(indexName);
        return new PluginInfo(
package org.opensearch.be.datafusion;
        long purgesBefore = NativeArenaPurger.getPurgeCount();
        String indexName = "purge_test";
    }
 * SPDX-License-Identifier: Apache-2.0
/*  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    protected Settings nodeSettings(int nodeOrdinal) {  
 * compatible open source license.
import org.opensearch.test.OpenSearchIntegTestCase;
        PPLResponse response = client().execute(
            extendedPlugins,  
            ).setMapping("group_id", "type=integer", "user_id", "type=long", "region", "type=integer")
 */  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 *
    @Override
            assertFalse("Bulk indexing should not have failures", bulkResponse.hasFailures());
            for (int i = batch; i < end; i++) {  
        long purgesAfter = NativeArenaPurger.getPurgeCount();
/**
        int numDocs = 50_000;
        );  
        }  
            .build();
        for (int batch = 0; batch < numDocs; batch += batchSize) {  
        return List.of(  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
        ).actionGet();
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
    @Override  
        );
    }
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            purgesAfter, baselineResident / (1024 * 1024)
        super.setUp();
                bulkRequest.add(client().prepareIndex(indexName)
        );  
        ensureGreen(indexName);
import org.opensearch.nativebridge.spi.NativeMemoryFetcher;
        );
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;  
        assertBusy(() -> {
            MockCommitterEnginePlugin.class
    @Override
        return Settings.builder()
    public void testPurgeReclaimsMemoryAfterQuery() throws Exception {  
import org.opensearch.composite.CompositeDataFormatPlugin;
)
}  
            }  
    @Override
 * after query execution completes.  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;  
            false
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
        logger.info(  
                Settings.builder()  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
import org.opensearch.ppl.TestPPLPlugin;  
import java.util.Collections;
                    .put("index.number_of_replicas", 0)
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        NativeArenaPurger.setCheckIntervalMs(0);
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
 * <p>Ingests high-cardinality data, runs an aggregation that forces multi-MB native
import java.util.concurrent.TimeUnit;  
import org.opensearch.Version;  
        assertNotNull(response);  
    }  
        // Run a high-cardinality aggregation via PPL to force large native allocations
            null,
        AnalyticsBackendNativeMemoryStats baseline = NativeMemoryFetcher.fetch();
            Version.CURRENT,
public class NativeArenaPurgerIT extends OpenSearchIntegTestCase {  
import org.opensearch.nativebridge.spi.NativeArenaPurger;  
import org.opensearch.action.index.IndexRequestBuilder;
            "1.8",  
import org.opensearch.ppl.action.PPLRequest;
        assertAcked(
            pluginClass.getName(),
            int end = Math.min(batch + batchSize, numDocs);
import org.opensearch.plugins.Plugin;
    private static final Logger logger = LogManager.getLogger(NativeArenaPurgerIT.class);
        NativeArenaPurger.init(0, 2000);  
            "classpath plugin",  
        }, 10, TimeUnit.SECONDS);  
import org.opensearch.analytics.AnalyticsPlugin;
        );  
            assertTrue("Purge should have fired", NativeArenaPurger.getPurgeCount() > purgesBefore);
    public void setUp() throws Exception {  
 *
import org.opensearch.plugins.PluginInfo;
import org.opensearch.ppl.action.PPLResponse;
        // Threshold=0 means always purge when check runs; interval=2s for fast test feedback.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
            new PPLRequest("source = " + indexName + " | stats dc(user_id) as u by group_id | sort - u | head 10")
    }  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
                    .setSource("group_id", i % 10000, "user_id", (long) (i % 20000), "region", i % 500));
        assertTrue("At least one purge should have executed", purgesAfter > purgesBefore);
import org.apache.logging.log4j.LogManager;
                    .put("index.pluggable.dataformat.enabled", true)  
        return List.of(
            .put(super.nodeSettings(nodeOrdinal))
            "Purge mechanism verified: purges={}, baseline_resident={} MB",
            TestPPLPlugin.class,
            prepareCreate(indexName).setSettings(
    }  
            var bulkResponse = bulkRequest.get();
            UnifiedPPLExecuteAction.INSTANCE,  
    }
            CompositeDataFormatPlugin.class,  
        super.tearDown();  
import org.apache.logging.log4j.Logger;
 * Integration test verifying that the jemalloc arena purger reclaims native memory
            ArrowBasePlugin.class,
    com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.NONE
        // Wait for purge to fire — threshold=0 means it fires on every check interval.
    protected Collection<PluginInfo> additionalNodePlugins() {  
        assertTrue("Native library must be loaded for this test", baseline.getResidentBytes() > 0);
import java.util.Collection;  
            pluginClass.getName(),
            "NA",
    @Override
        // This verifies the full end-to-end mechanism: periodic timer → resident check → mallctl purge.  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put(FeatureFlags.STREAM_TRANSPORT, true)
                    .put("index.number_of_shards", 1)
    public void tearDown() throws Exception {
import org.opensearch.common.settings.Settings;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(  
 */
        int batchSize = 5000;
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
import org.opensearch.common.util.FeatureFlags;  
 * allocations, then asserts that resident memory drops after the debounced purge fires.  
    }
                    .put("index.pluggable.dataformat", "parquet")
        long baselineResident = baseline.getResidentBytes();  
