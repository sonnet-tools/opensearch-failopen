                    .put("datafusion.indexed.min_skip_run_default", 2048)
    }
import org.opensearch.plugins.PluginInfo;
import org.opensearch.analytics.AnalyticsPlugin;  
            .prepareUpdateSettings()  
            IllegalArgumentException.class,  
            pluginClass.getName(),
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertEquals("0.5", transientSettings.get("datafusion.indexed.min_skip_run_selectivity_threshold"));
                    .put("datafusion.batch_size", 16384)  
public class DatafusionDynamicSettingsIT extends OpenSearchIntegTestCase {
import org.opensearch.Version;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    @Override  
        );
import org.opensearch.composite.CompositeDataFormatPlugin;
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            "1.8",
import java.util.List;
        return Settings.builder()  
        return List.of(
            pluginClass.getName(),  
import org.opensearch.parquet.ParquetDataFormatPlugin;  
                .prepareUpdateSettings()  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            IllegalArgumentException.class,  
                Settings.builder()
            Version.CURRENT,
package org.opensearch.be.datafusion;
 */  
                .get()
    }  
    public void testAllIndexedSettingsCanBeUpdatedDynamically() {  
                .cluster()
        assertEquals("2048", transientSettings.get("datafusion.indexed.min_skip_run_default"));  
        );  
                    .put("datafusion.indexed.min_skip_run_selectivity_threshold", 0.5)  
 * SPDX-License-Identifier: Apache-2.0
                .setTransientSettings(Settings.builder().put("datafusion.indexed.min_skip_run_selectivity_threshold", 1.5).build())
            .cluster()
    }
import java.util.Collections;  
            "NA",  
            .put(super.nodeSettings(nodeOrdinal))
    @Override
 * The OpenSearch Contributors require contributions made to  
        assertEquals("true", transientSettings.get("datafusion.listing_table.pushdown_filters"));
            "classpath plugin",
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            null,
        expectThrows(
        );  
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
            extendedPlugins,
import org.opensearch.plugins.Plugin;
    protected Settings nodeSettings(int nodeOrdinal) {
    @Override
            () -> client().admin()
}
    }  
            false  
 *
import org.opensearch.be.lucene.LucenePlugin;
        assertEquals("16384", transientSettings.get("datafusion.batch_size"));
                .cluster()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
        return List.of(FlightStreamPlugin.class, CompositeDataFormatPlugin.class, LucenePlugin.class);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .prepareUpdateSettings()  
        );
        expectThrows(
        assertTrue(response.isAcknowledged());
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
 * compatible open source license.
            .build();  
                .setTransientSettings(Settings.builder().put("datafusion.batch_size", 0).build())
import org.opensearch.common.util.FeatureFlags;
    public void testInvalidValuesAreRejected() {
import org.opensearch.common.settings.Settings;  
            .get();  
                    .put("datafusion.listing_table.pushdown_filters", true)
                    .build()
        Settings transientSettings = response.getTransientSettings();  
            () -> client().admin()
/*  
        return new PluginInfo(  
            )
                .get()
    protected Collection<PluginInfo> additionalNodePlugins() {  
    }
            classpathPlugin(ParquetDataFormatPlugin.class, Collections.emptyList()),  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        ClusterUpdateSettingsResponse response = client().admin()
    }
            .setTransientSettings(
