            new int[] { 10, 10, 1 },  
        return List.of(
    private static List<String> renderRows(PPLResponse response) {
        if (window < 0) {  
    }
    private String measure(int shards, int head, int window) throws Exception {  
        client().admin()  
     * {@code 0} owns the highest block. Returns them as a comma-separated list for the PPL source.
        for (String node : internalCluster().getDataNodeNames()) {
    scope = OpenSearchIntegTestCase.Scope.SUITE,
 * </pre>  
        String ppl = "source = " + indices + " | sort - ts | head " + head + " | fields ts";
                .prepareCreate(index)  
            client().admin()
        }
 * avoids across a grid of shard count × {@code head} size × per-node dispatch window. Each row is
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                .indices()
        }  
     */
import org.opensearch.ppl.action.PPLResponse;
 *     -Dsandbox.enabled=true -PrustDebug
        List<String> report = new ArrayList<>();
     * cluster's open-shard cap and so both runs of a point see identical data.
        List<String> rendered = new ArrayList<>(response.getRows().size());
 * <p>Asserts only that the measurement is trustworthy: gated dispatches ≤ baseline, and the gated run
        logger.info("MEASURE  shards  head  window  baseline  gated  avoided  avoided%  rows");
                "%7d %5d %7s %9d %6d %8d %8.1f %5d",  
public class SortEarlyTerminationMeasurementIT extends OpenSearchIntegTestCase {
    }
                .setSettings(settings)
     * Runs one grid point against a wait-for-all baseline and returns its report line.
                .setMapping("ts", "type=long", "host", "type=keyword,index=false")
    private void clearTransportRules() {
            .put("index.pluggable.dataformat", "composite")
import java.util.Map;
 *
 * returns the same rows as the wait-for-all baseline.
            .build();
import org.opensearch.analytics.settings.AnalyticsQuerySettings;  
            .put("index.composite.primary_data_format", "parquet")  
            }  
            int baseline = dispatches.getAndSet(0);
     */
import org.opensearch.common.settings.Settings;
 * <pre>
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        ensureGreen();  
                gatedRows  
/*  
        }
                bulk.add(client().prepareIndex(index).setSource("ts", base + doc, "host", "h-" + i + "-" + doc));  
    @Override
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .prepareUpdateSettings()
            Version.CURRENT,
        try {
                avoided,  
 *     --tests "org.opensearch.analytics.canmatch.SortEarlyTerminationMeasurementIT" \
            "classpath plugin",
 */  
import java.util.Collections;
import java.util.HashMap;
            rendered.add(java.util.Arrays.deepToString(row));
    // ── fixture ──────────────────────────────────────────────────────────
    }
            List<String> baselineRows = renderRows(executePPL(baselinePpl));  
    /**
            // { shards, head, window (-1 = leave at the 5 default) }
        AtomicInteger dispatches = countFragmentDispatches();  
        }
        for (Object[] row : response.getRows()) {  
}  
                pct,
            .build();
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;  
        return indicesByShardCount.computeIfAbsent(shards, n -> createDisjointIndices("m" + n + "_", n));
    }
            assertFalse("bulk seeding must not fail", bulk.get().hasFailures());
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            report.add(measure(row[0], row[1], row[2]));  
        int nodes = internalCluster().getDataNodeNames().size();  
    }  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
    }
            long base = (long) (shards - 1 - i) * DOCS_PER_SHARD;  
     * so these numbers are a ceiling.  
            ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();  
    private static final int DOCS_PER_SHARD = 20;  
import org.opensearch.cluster.metadata.IndexMetadata;
     * fixture's total row count — the heap never fills, so it never arms and every shard is dispatched.
import org.opensearch.plugins.PluginInfo;
            assertEquals(  
 * <p>Node count is a class annotation, not a grid axis — the recorded 3-node numbers came from editing
            CompositeDataFormatPlugin.class,
        return counter;
        String indices = indicesFor(shards);
        List<int[]> grid = List.of(  
            new int[] { 50, 100, 1 },
            commaList.append(index);
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        } finally {  
            );
 * @opensearch.internal
            assertTrue("gated dispatches must never exceed baseline", gated <= baseline);  
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
    supportsDedicatedMasters = false
    }
                .isAcknowledged()
        DefaultPlanExecutor executor = executor();
        );
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),  
 * logged as a {@code MEASURE} line and transcribed to {@code debug/can-match/sort-et-observations.md}.
    /**
                "the gated run must return the same rows as the baseline",
    @Override
    // ── settings plumbing ────────────────────────────────────────────────  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;  
package org.opensearch.analytics.canmatch;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            .put(super.nodeSettings(nodeOrdinal))
                commaList.append(',');
 * <p>Run it explicitly; it's slower than its assertions justify in CI:
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            extendedPlugins,
    }  
            .put("index.pluggable.dataformat.enabled", true)
            new int[] { 200, 10, -1 },  
import org.opensearch.common.util.FeatureFlags;  
import java.util.List;  
 *
                gatedRows.size()
 *
                handler.messageReceived(request, channel, task);
import org.opensearch.ppl.TestPPLPlugin;  
            logger.info("MEASURE {}", line);
            clearOverride(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey());
                .setTransientSettings(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        }
                    Settings.builder().put(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey(), window).build()
 *  
import java.util.Locale;
        setWindow(window);
    public void testAvoidedSendsSweep() throws Exception {
            .setTransientSettings(Settings.builder().putNull(key).build())  
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            logger.info("MEASURE {}", line);
    protected Collection<PluginInfo> additionalNodePlugins() {
            int avoided = baseline - gated;
        for (String node : internalCluster().getDataNodeNames()) {  
        );
    /**  
            .get();
import org.opensearch.Version;
            assertTrue("index creation must be acknowledged", response.isAcknowledged());
            TestPPLPlugin.class,  
     * <p>Indices are shared across grid points with the same shard count, both to stay under the test  
        logger.info("MEASURE header: nodes={} docsPerShard={}", nodes, DOCS_PER_SHARD);
        for (String line : report) {
import org.opensearch.analytics.exec.DefaultPlanExecutor;
            String index = prefix + i;  
@OpenSearchIntegTestCase.ClusterScope(
            ArrowBasePlugin.class,
    /** Index sets by shard count, built on first use and shared — see {@link #measure}. */
 * this file be licensed under the Apache-2.0 license or a
            new int[] { 200, 10000, 1 }  
        }
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            if (i > 0) {
            "1.8",
        return internalCluster().getInstance(DefaultPlanExecutor.class, internalCluster().getNodeNames()[0]);
            new int[] { 10, 100, 1 },
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.concurrent.atomic.AtomicInteger;  
import org.opensearch.composite.CompositeDataFormatPlugin;
    }
        return Settings.builder()  
                .get()
                counter.incrementAndGet();  
    private String createDisjointIndices(String prefix, int shards) {  
            client().admin().indices().prepareRefresh(index).get();
            null,
        }  
            clearTransportRules();
    numDataNodes = 1,  
        String baselinePpl = "source = " + indices + " | sort - ts | head " + (shards * DOCS_PER_SHARD + 1) + " | fields ts";  
 * {@code numDataNodes} and re-running.  
            .putList("index.composite.secondary_data_formats")
        }  
            }
            MockTransportService.TestPlugin.class,
 *  
                .get();  
            new int[] { 50, 10, -1 },
            new int[] { 50, 100, -1 },
    private void setWindow(int window) throws Exception {
                .prepareUpdateSettings()  
            assertEquals("the baseline must be the full fan-out", shards, baseline);
            int gated = dispatches.getAndSet(0);
import org.opensearch.plugins.Plugin;
import org.opensearch.analytics.AnalyticsPlugin;  
 * compatible open source license.
        );
            new int[] { 200, 10, 1 },
    private String indicesFor(int shards) {
import org.opensearch.transport.TransportService;  
            return;   // leave the node-settings default in place
            "NA",  
 * Measurement harness, not a correctness test: counts how many fragment dispatches the sort gate  
                shards,
            pluginClass.getName(),  
                Locale.ROOT,
    }
            String line = String.format(
    private AtomicInteger countFragmentDispatches() {
            var bulk = client().prepareBulk();
        );
    private final Map<Integer, String> indicesByShardCount = new HashMap<>();
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
 */  
     * Creates {@code shards} single-shard indices with descending, non-overlapping key ranges — index  
import org.opensearch.be.datafusion.DataFusionPlugin;  
                head,
            dispatches.set(0);
            new int[] { 10, 10, -1 },
    }
            .put(FeatureFlags.STREAM_TRANSPORT, true)  
import org.opensearch.ppl.action.PPLRequest;
            pluginClass.getName(),
    @Override
        assertTrue(  
                )  
    }  
            MockCommitterEnginePlugin.class  
        StringBuilder commaList = new StringBuilder();
        return List.of(  
)  
     *
            });
    private void clearOverride(String key) {
    protected Settings nodeSettings(int nodeOrdinal) {
    private DefaultPlanExecutor executor() {
import java.util.ArrayList;
/**
    }
            false  
        for (int[] row : grid) {
    }  
        return commaList.toString();
            new int[] { 200, 100, 1 },
                .cluster()
     *
            .cluster()
        assertBusy(() -> assertEquals("executor must observe the window update", window, executor.maxConcurrentShardRequestsPerNode()));
        Settings settings = Settings.builder()
            List<String> gatedRows = renderRows(executePPL(ppl));  
     * Walks the grid and logs a row per point. Data is disjoint and descending — the gate's best case,
        logger.info("MEASURE ===== summary =====");  
import java.util.Collection;  
            new int[] { 50, 10, 1 },  
 * SPDX-License-Identifier: Apache-2.0
     * <p>The gate has no off switch, so the baseline is the same query with {@code head} set past the  
     */
    private PPLResponse executePPL(String ppl) {  
        return rendered;  
    }
        AtomicInteger counter = new AtomicInteger();
            client().admin().indices().prepareFlush(index).get();
            double pct = baseline == 0 ? 0.0 : (100.0 * avoided / baseline);  
        );  
            for (int doc = 0; doc < DOCS_PER_SHARD; doc++) {
            return line;
                baselineRows.subList(0, Math.min(head, baselineRows.size())),
    numClientNodes = 0,
        for (int i = 0; i < shards; i++) {
            CreateIndexResponse response = client().admin()
                baseline,
 * ./gradlew :sandbox:qa:analytics-engine-coordinator:internalClusterTest \  
                window < 0 ? "5(def)" : String.valueOf(window),  
            );  
                gated,
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
        return new PluginInfo(  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
