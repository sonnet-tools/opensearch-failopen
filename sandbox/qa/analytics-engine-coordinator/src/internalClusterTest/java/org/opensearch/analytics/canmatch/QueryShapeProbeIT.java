            pluginClass.getName(),  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
 * SPDX-License-Identifier: Apache-2.0
        );  
                handler.messageReceived(request, channel, task);
            .put(super.nodeSettings(nodeOrdinal))  
        dispatches.set(0);
        logger.info("PROBE   dispatches: {} (of {} shards)", sent, DAYS);  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
            TestPPLPlugin.class,
    supportsDedicatedMasters = false
                .indices()
            "1.8",
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
import org.opensearch.cluster.metadata.IndexMetadata;  
        String idx = createDailyIndices();
        );
                        String.format(Locale.ROOT, "2026-07-%02dT%02d:00:00Z", d, i * 6),
            ArrowBasePlugin.class,
            probe("2. sort + head (gate, no pruning)", "source = " + idx + " | sort - ts | head 5 | fields ts", dispatches);
                "3. filter + sort + head (both)",
        AtomicInteger counter = new AtomicInteger();
                dispatches
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
    }
    }
            String index = String.format(Locale.ROOT, "probe-2026-07-%02d", d);  
 * The OpenSearch Contributors require contributions made to  
    protected Collection<PluginInfo> additionalNodePlugins() {
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        List<String> rows = renderRows(executePPL(ppl));  
        AtomicInteger dispatches = countFragmentDispatches();  
        }  
                counter.incrementAndGet();  
            false
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
                "source = " + idx + " | where `ts` >= '2026-07-12 00:00:00' | sort - ts | head 5 | fields ts",
        logger.info("PROBE {}", label);
import org.opensearch.common.util.FeatureFlags;
/**  
            commaList.append(index);
            client().admin().indices().prepareFlush(index).get();
/*  
            .put("index.pluggable.dataformat", "composite")
import java.util.Locale;  
import org.opensearch.analytics.AnalyticsPlugin;  
 *
        }
}
    private PPLResponse executePPL(String ppl) {
    }
                "6. filter + sort + head, fetch-only column (QTF/LM path)",
        for (Object[] row : response.getRows()) {  
    }
        logger.info("PROBE   rows ({}):", rows.size());
                    .get();
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
    }
    }
            .build();
        for (String node : internalCluster().getDataNodeNames()) {  
    protected Settings nodeSettings(int nodeOrdinal) {
            CompositeDataFormatPlugin.class,  
    }
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
import org.opensearch.composite.CompositeDataFormatPlugin;  
            "classpath plugin",
        }
            .put("index.pluggable.dataformat.enabled", true)
        return Settings.builder()
    private String createDailyIndices() {  
        return counter;
    private AtomicInteger countFragmentDispatches() {
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        ensureGreen();  
    /** Runs one PPL and logs the rows it returned plus how many shards it opened. */
            .putList("index.composite.secondary_data_formats")
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
    }  
        StringBuilder commaList = new StringBuilder();
 * this file be licensed under the Apache-2.0 license or a
    numDataNodes = 1,  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();  
            clearTransportRules();
        try {
    private static final int FIRST_DAY = 10;
    @Override  
    private void probe(String label, String ppl, AtomicInteger dispatches) {  
import org.opensearch.ppl.action.PPLRequest;  
                        String.format(Locale.ROOT, "host-%02d-%d", d, i)  
import java.util.concurrent.atomic.AtomicInteger;
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            pluginClass.getName(),
 * Correctness lives in {@link SortEarlyTerminationIT}; this exists to show output.  
            probe(
            probe("1. filter only (pruning, no gate)", "source = " + idx + " | where `ts` >= '2026-07-13 00:00:00' | fields ts, host", dispatches);
        logger.info("PROBE ================================================================");
    }
        for (int d = FIRST_DAY; d < FIRST_DAY + DAYS; d++) {
        return commaList.toString();
                .get();  
    }  
    @Override
import org.opensearch.common.settings.Settings;
    private void clearTransportRules() {
        }
                client().prepareIndex(index)
import org.opensearch.transport.TransportService;
                    )
                        "ts",  
import org.opensearch.plugins.Plugin;  
        );  
    public void testPrintQueryShapes() {
            probe(  
        int sent = dispatches.getAndSet(0);
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            }  
 * compatible open source license.
            CreateIndexResponse response = client().admin()
                .prepareCreate(index)  
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
        logger.info("PROBE   {}", ppl);  
                commaList.append(',');
            assertTrue(response.isAcknowledged());
            "NA",
        List<String> rendered = new ArrayList<>(response.getRows().size());
 */  
                dispatches  
    @Override  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    numClientNodes = 0,
            );
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
import org.opensearch.ppl.action.PPLResponse;
            MockTransportService.TestPlugin.class,
import java.util.ArrayList;
        Settings settings = Settings.builder()
    private static List<String> renderRows(PPLResponse response) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            for (int i = 0; i < DOCS_PER_DAY; i++) {  
import org.opensearch.test.OpenSearchIntegTestCase;  
            });
 * Scratch probe — prints actual rows and dispatch counts for the four can-match query shapes
        return rendered;  
import org.opensearch.test.transport.MockTransportService;
)  
 */  
        return new PluginInfo(
import java.util.List;
        return List.of(
                "source = " + idx + " | where `ts` >= '2026-07-12 00:00:00' | sort - ts | head 5 | fields ts, host",  
            extendedPlugins,
                        "host",
    scope = OpenSearchIntegTestCase.Scope.SUITE,
import org.opensearch.plugins.PluginInfo;
            }  
            .put("index.composite.primary_data_format", "parquet")  
            rendered.add(Arrays.deepToString(row));
import java.util.Arrays;
        for (String row : rows) {
public class QueryShapeProbeIT extends OpenSearchIntegTestCase {
            logger.info("PROBE     {}", row);  
        for (String node : internalCluster().getDataNodeNames()) {
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
 *
import org.opensearch.ppl.TestPPLPlugin;
        return List.of(  
            client().admin().indices().prepareRefresh(index).get();
            probe("4. head only (no sort, nothing gateable)", "source = " + idx + " | head 5 | fields ts", dispatches);  
        } finally {  
        }
    private static final int DOCS_PER_DAY = 4;
import org.opensearch.be.datafusion.DataFusionPlugin;
            if (d > FIRST_DAY) {
        }
            probe("5. sort + head ascending", "source = " + idx + " | sort + ts | head 5 | fields ts", dispatches);
                .setSettings(settings)
    private static final int DAYS = 5;      // 2026-07-10 .. 2026-07-14  
package org.opensearch.analytics.canmatch;
 * @opensearch.internal
import org.opensearch.Version;
            MockCommitterEnginePlugin.class
@OpenSearchIntegTestCase.ClusterScope(
import java.util.Collections;
                    .setSource(
                .setMapping("ts", "type=date", "host", "type=keyword,index=false")
            .put(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey(), 1)  
            );
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
import java.util.Collection;  
            .build();
            null,  
            Version.CURRENT,  
 * (filter only / sort+head / filter+sort+head / head only) so the behaviour can be eyeballed.
