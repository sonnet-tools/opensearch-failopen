    private PPLResponse executePPL(String ppl) {
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            probe("2. sort + head (gate, no pruning)", "source = " + idx + " | sort - ts | head 5 | fields ts", dispatches);
        logger.info("PROBE   {}", ppl);
        }
    public void testPrintQueryShapes() {
        try {
                .indices()
import org.opensearch.ppl.action.PPLRequest;
                "source = " + idx + " | where `ts` >= '2026-07-12 00:00:00' | sort - ts | head 5 | fields ts, host",
import java.util.Arrays;
                .get();
    }
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.common.util.FeatureFlags;
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            probe(
import org.opensearch.common.settings.Settings;
import org.opensearch.analytics.AnalyticsPlugin;
    private static List<String> renderRows(PPLResponse response) {
 */
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            extendedPlugins,
    }
                    )
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        AtomicInteger dispatches = countFragmentDispatches();
 *
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
import java.util.ArrayList;
            probe("1. filter only (pruning, no gate)", "source = " + idx + " | where `ts` >= '2026-07-13 00:00:00' | fields ts, host", dispatches);
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
        logger.info("PROBE {}", label);
    protected Settings nodeSettings(int nodeOrdinal) {
                commaList.append(',');
            CreateIndexResponse response = client().admin()
import java.util.List;
                "3. filter + sort + head (both)",
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
    }
    private String createDailyIndices() {
            "classpath plugin",
            });
                handler.messageReceived(request, channel, task);
        StringBuilder commaList = new StringBuilder();
            pluginClass.getName(),
            logger.info("PROBE     {}", row);
import org.opensearch.ppl.TestPPLPlugin;
import org.opensearch.composite.CompositeDataFormatPlugin;
    @Override
            null,
            for (int i = 0; i < DOCS_PER_DAY; i++) {
                .setMapping("ts", "type=date", "host", "type=keyword,index=false")
    private void probe(String label, String ppl, AtomicInteger dispatches) {
        logger.info("PROBE   rows ({}):", rows.size());
    private static final int DOCS_PER_DAY = 4;
                dispatches
        Settings settings = Settings.builder()
            if (d > FIRST_DAY) {
                "source = " + idx + " | where `ts` >= '2026-07-12 00:00:00' | sort - ts | head 5 | fields ts",
        for (Object[] row : response.getRows()) {
    }
    }
        }
 * this file be licensed under the Apache-2.0 license or a
/*
 *
            Version.CURRENT,
                client().prepareIndex(index)
            client().admin().indices().prepareRefresh(index).get();
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
    numDataNodes = 1,
        logger.info("PROBE   dispatches: {} (of {} shards)", sent, DAYS);
        for (String row : rows) {
        return commaList.toString();
                "6. filter + sort + head, fetch-only column (QTF/LM path)",
    private void clearTransportRules() {
        for (int d = FIRST_DAY; d < FIRST_DAY + DAYS; d++) {
    }
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
    protected Collection<PluginInfo> additionalNodePlugins() {
import java.util.concurrent.atomic.AtomicInteger;
        }
            );
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        logger.info("PROBE ================================================================");
 */
}
            .put("index.pluggable.dataformat.enabled", true)
        return rendered;
        for (String node : internalCluster().getDataNodeNames()) {
            "NA",
    private AtomicInteger countFragmentDispatches() {
    }
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        return Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugins.PluginInfo;
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
import org.opensearch.test.OpenSearchIntegTestCase;
                dispatches
        return new PluginInfo(
            String index = String.format(Locale.ROOT, "probe-2026-07-%02d", d);
        return counter;
 * Correctness lives in {@link SortEarlyTerminationIT}; this exists to show output.
            }
            MockTransportService.TestPlugin.class,
    /** Runs one PPL and logs the rows it returned plus how many shards it opened. */
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import java.util.Locale;
            pluginClass.getName(),
import org.opensearch.transport.TransportService;
            .build();
        );
import org.opensearch.test.transport.MockTransportService;
            .build();
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        List<String> rows = renderRows(executePPL(ppl));
            probe("4. head only (no sort, nothing gateable)", "source = " + idx + " | head 5 | fields ts", dispatches);
            assertTrue(response.isAcknowledged());
/**
        return List.of(
 * (filter only / sort+head / filter+sort+head / head only) so the behaviour can be eyeballed.
            client().admin().indices().prepareFlush(index).get();
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.be.datafusion.DataFusionPlugin;
            CompositeDataFormatPlugin.class,
import org.opensearch.Version;
package org.opensearch.analytics.canmatch;
            .put("index.composite.primary_data_format", "parquet")
        }
                        "ts",
            }
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            clearTransportRules();
        }
import org.opensearch.plugins.Plugin;
import java.util.Collections;
    }
        );
                        String.format(Locale.ROOT, "host-%02d-%d", d, i)
        for (String node : internalCluster().getDataNodeNames()) {
                counter.incrementAndGet();
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
    supportsDedicatedMasters = false
 * Scratch probe — prints actual rows and dispatch counts for the four can-match query shapes
                        "host",
        AtomicInteger counter = new AtomicInteger();
        List<String> rendered = new ArrayList<>(response.getRows().size());
        );
                .setSettings(settings)
    scope = OpenSearchIntegTestCase.Scope.SUITE,
        return List.of(
)
            TestPPLPlugin.class,
import java.util.Collection;
    }
    @Override
    numClientNodes = 0,
        dispatches.set(0);
        int sent = dispatches.getAndSet(0);
                    .setSource(
            rendered.add(Arrays.deepToString(row));
import org.opensearch.ppl.action.PPLResponse;
        } finally {
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            "1.8",
    private static final int DAYS = 5;      // 2026-07-10 .. 2026-07-14
    }
                        String.format(Locale.ROOT, "2026-07-%02dT%02d:00:00Z", d, i * 6),
public class QueryShapeProbeIT extends OpenSearchIntegTestCase {
            );
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            probe("5. sort + head ascending", "source = " + idx + " | sort + ts | head 5 | fields ts", dispatches);
            ArrowBasePlugin.class,
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
 * @opensearch.internal
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
            .put(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey(), 1)
        String idx = createDailyIndices();
        ensureGreen();
            commaList.append(index);
                    .get();
    }
            MockCommitterEnginePlugin.class
        }
    private static final int FIRST_DAY = 10;
    @Override
            probe(
                .prepareCreate(index)
@OpenSearchIntegTestCase.ClusterScope(
            false
            ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();
            .putList("index.composite.secondary_data_formats")
import org.opensearch.cluster.metadata.IndexMetadata;
