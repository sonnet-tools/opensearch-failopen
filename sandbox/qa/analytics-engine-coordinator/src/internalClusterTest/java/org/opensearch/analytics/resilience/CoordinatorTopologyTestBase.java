        return List.of(
    /**
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            extendedPlugins,  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
import org.opensearch.test.OpenSearchIntegTestCase;
 */  
                    UnifiedPPLExecuteAction.INSTANCE,
    protected static final int VALUE = 7;  
    protected Collection<PluginInfo> additionalNodePlugins() {  
    }
            TestPPLPlugin.class,
            pluginClass.getName(),
     * rows of {@code value=VALUE}, then runs {@code stats sum(value)} via PPL and asserts
import org.opensearch.plugins.Plugin;
        client().admin().indices().prepareRefresh(index).get();
public abstract class CoordinatorTopologyTestBase extends OpenSearchIntegTestCase {
import org.opensearch.ppl.action.PPLResponse;
    @Override
            "1.8",  
        try {
import java.util.Collections;
import org.opensearch.common.settings.Settings;  
            .setSettings(indexSettings)
import org.apache.lucene.tests.util.LuceneTestCase;
        );
    }  
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;  
            CompositeDataFormatPlugin.class,
            pluginClass.getName(),
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
            MockTransportService.TestPlugin.class,  
            .put("index.pluggable.dataformat.enabled", true)
    @Override  
import java.util.concurrent.TimeUnit;
    }
        for (int i = 0; i < docs; i++) {
}
import org.opensearch.be.datafusion.DataFusionPlugin;
            }, 30, TimeUnit.SECONDS);  
import java.util.Collection;
import org.opensearch.ppl.action.PPLRequest;
import org.opensearch.plugins.PluginInfo;
            "classpath plugin",  
 * with {@code CoordinatorResilienceIT}.
        }  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
                ).actionGet(QUERY_TIMEOUT);
import static org.hamcrest.Matchers.equalTo;  
        assertTrue(cr.isAcknowledged());
        CreateIndexResponse cr = client().admin()
        client().admin().indices().prepareFlush(index).get();
            .build();
import org.opensearch.composite.CompositeDataFormatPlugin;  
    @Override
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
            .indices()
            MockCommitterEnginePlugin.class, MockDataFormatPlugin.class
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.AnalyticsPlugin;
 */
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        ensureGreen(index);
            .setMapping("value", "type=integer")
                assertEquals(1, r.getRows().size());  
            assertBusy(() -> {  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        );
 * would shut it down for the whole JVM, so topology variants cannot share a class  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
        Settings indexSettings = Settings.builder()
        return Settings.builder()
            .build();  
        );  
    protected void runSumOverSeededIndex(String index, int numShards, int docs) throws Exception {
 *
            client().prepareIndex(index).setSource("value", VALUE).get();
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
            .put(super.nodeSettings(nodeOrdinal))
        return new PluginInfo(
                long actual = ((Number) r.getRows().get(0)[idx]).longValue();
 * Shared plugin / settings boilerplate for topology-only coordinator ITs. Each subclass  
            .prepareCreate(index)  
    protected static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
import org.opensearch.Version;
 * and the Tokio runtime manager is JVM-global — mid-test {@code stopRandomNode}
                int idx = r.getColumns().indexOf("total");
    }  
import org.opensearch.cluster.metadata.IndexMetadata;
            Version.CURRENT,
    protected Settings nodeSettings(int nodeOrdinal) {  
/*  
            ArrowBasePlugin.class,  
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
        }  
        return List.of(
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        } catch (Exception e) {
@LuceneTestCase.AwaitsFix(bugUrl = "broken")  
            "NA",
            .get();  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
     */  
package org.opensearch.analytics.resilience;
                assertThat(actual, equalTo(expected));
            null,
     * the SUM equals {@code docs * VALUE}.
/**
        long expected = (long) docs * VALUE;
     * Creates a composite-parquet index with {@code numShards} primaries, seeds {@code docs}  
 * compatible open source license.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put("index.composite.primary_data_format", "parquet")
    }  
            .put("index.pluggable.dataformat", "composite")  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.transport.MockTransportService;
 * lives in its own file because {@code @ClusterScope(numDataNodes = N)} is class-level
            throw new AssertionError("topology SUM query failed for index=" + index + " shards=" + numShards + " docs=" + docs, e);
            .putList("index.composite.secondary_data_formats")
                    new PPLRequest("source = " + index + " | stats sum(value) as total")  
import org.opensearch.common.unit.TimeValue;
import java.util.List;  
                PPLResponse r = client().execute(
import org.opensearch.common.util.FeatureFlags;
 * The OpenSearch Contributors require contributions made to  
            false
import org.opensearch.ppl.TestPPLPlugin;  
