import org.opensearch.common.settings.Settings;
        for (String node : internalCluster().getDataNodeNames()) {
 * <pre>
            CreateIndexResponse response = client().admin()
            .put("index.pluggable.dataformat.enabled", true)
        }
            int baseline = dispatches.getAndSet(0);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            return line;
        return rendered;
 *
            }
    private void clearTransportRules() {
import java.util.ArrayList;
    @Override
import org.opensearch.plugins.Plugin;
            "classpath plugin",
        for (int i = 0; i < shards; i++) {
        AtomicInteger dispatches = countFragmentDispatches();
    private static List<String> renderRows(PPLResponse response) {
            .put("index.composite.primary_data_format", "parquet")
            int gated = dispatches.getAndSet(0);
            client().admin().indices().prepareFlush(index).get();
            .putList("index.composite.secondary_data_formats")
import org.opensearch.plugins.PluginInfo;
                .prepareCreate(index)
        for (String line : report) {
     * Runs one grid point against a wait-for-all baseline and returns its report line.
            logger.info("MEASURE {}", line);
    public void testAvoidedSendsSweep() throws Exception {
            }
            );
    }
            .prepareUpdateSettings()
        int nodes = internalCluster().getDataNodeNames().size();
            logger.info("MEASURE {}", line);
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
            new int[] { 200, 100, 1 },
import java.util.HashMap;
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
 *     -Dsandbox.enabled=true -PrustDebug
            String line = String.format(
 * <p>Asserts only that the measurement is trustworthy: gated dispatches ≤ baseline, and the gated run
    private void setWindow(int window) throws Exception {
import org.opensearch.Version;
 * compatible open source license.
package org.opensearch.analytics.canmatch;
 *
            .build();
        );
    /** Index sets by shard count, built on first use and shared — see {@link #measure}. */
 *
@OpenSearchIntegTestCase.ClusterScope(
     * so these numbers are a ceiling.
            if (i > 0) {
        return List.of(
)
        logger.info("MEASURE ===== summary =====");
            pluginClass.getName(),
                .setSettings(settings)
import org.opensearch.analytics.exec.DefaultPlanExecutor;
    }
     * Creates {@code shards} single-shard indices with descending, non-overlapping key ranges — index
 *     --tests "org.opensearch.analytics.canmatch.SortEarlyTerminationMeasurementIT" \
        List<String> report = new ArrayList<>();
    }
            });
        return counter;
    private void clearOverride(String key) {
    @Override
import org.opensearch.transport.TransportService;
     * fixture's total row count — the heap never fills, so it never arms and every shard is dispatched.
        }
    protected Settings nodeSettings(int nodeOrdinal) {
    }
     */
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            .cluster()
 * </pre>
                baselineRows.subList(0, Math.min(head, baselineRows.size())),
            // { shards, head, window (-1 = leave at the 5 default) }
            long base = (long) (shards - 1 - i) * DOCS_PER_SHARD;
                .cluster()
        String baselinePpl = "source = " + indices + " | sort - ts | head " + (shards * DOCS_PER_SHARD + 1) + " | fields ts";
    scope = OpenSearchIntegTestCase.Scope.SUITE,
     * cluster's open-shard cap and so both runs of a point see identical data.
 * @opensearch.internal
        List<int[]> grid = List.of(
            null,
            assertTrue("index creation must be acknowledged", response.isAcknowledged());
            new int[] { 50, 100, 1 },
     */
     */
            assertFalse("bulk seeding must not fail", bulk.get().hasFailures());
            String index = prefix + i;
    @Override
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
import org.opensearch.composite.CompositeDataFormatPlugin;
            dispatches.set(0);
/*
    private PPLResponse executePPL(String ppl) {
import org.opensearch.test.transport.MockTransportService;
            "1.8",
import java.util.Map;
        return indicesByShardCount.computeIfAbsent(shards, n -> createDisjointIndices("m" + n + "_", n));
    private String indicesFor(int shards) {
            false
            ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();
            new int[] { 50, 10, 1 },
import org.opensearch.ppl.TestPPLPlugin;
import org.opensearch.ppl.action.PPLRequest;
        return commaList.toString();
            new int[] { 200, 10, 1 },
    private AtomicInteger countFragmentDispatches() {
        } finally {
     * Walks the grid and logs a row per point. Data is disjoint and descending — the gate's best case,
            extendedPlugins,
    numDataNodes = 1,
        AtomicInteger counter = new AtomicInteger();
                avoided,
        assertTrue(
                "%7d %5d %7s %9d %6d %8d %8.1f %5d",
import org.opensearch.cluster.metadata.IndexMetadata;
        return Settings.builder()
    private static final int DOCS_PER_SHARD = 20;
    }
            new int[] { 50, 100, -1 },
    /**
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
    }
 *
        );
                gated,
        client().admin()
            client().admin().indices().prepareRefresh(index).get();
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            List<String> baselineRows = renderRows(executePPL(baselinePpl));
        return internalCluster().getInstance(DefaultPlanExecutor.class, internalCluster().getNodeNames()[0]);
            var bulk = client().prepareBulk();
            clearTransportRules();
/**
            .get();
                .isAcknowledged()
        if (window < 0) {
        return List.of(
                .setTransientSettings(
 * ./gradlew :sandbox:qa:analytics-engine-coordinator:internalClusterTest \
        );
        return new PluginInfo(
        }
 * <p>Node count is a class annotation, not a grid axis — the recorded 3-node numbers came from editing
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
    }
        for (int[] row : grid) {
 */
     * <p>The gate has no off switch, so the baseline is the same query with {@code head} set past the
import java.util.Collections;
                .get();
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            pluginClass.getName(),
 * avoids across a grid of shard count × {@code head} size × per-node dispatch window. Each row is
 * <p>Run it explicitly; it's slower than its assertions justify in CI:
            assertTrue("gated dispatches must never exceed baseline", gated <= baseline);
            "NA",
                gatedRows.size()
            rendered.add(java.util.Arrays.deepToString(row));
        );
    /**
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * The OpenSearch Contributors require contributions made to
            assertEquals("the baseline must be the full fan-out", shards, baseline);
}
            new int[] { 200, 10000, 1 }
 *
                )
                pct,
    supportsDedicatedMasters = false
                head,
                window < 0 ? "5(def)" : String.valueOf(window),
        ensureGreen();
            int avoided = baseline - gated;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
import org.opensearch.ppl.action.PPLResponse;
                gatedRows
                Locale.ROOT,
            report.add(measure(row[0], row[1], row[2]));
        );
import org.opensearch.test.OpenSearchIntegTestCase;
    }
    }
    }
                handler.messageReceived(request, channel, task);
            Version.CURRENT,
 */
                .indices()
            double pct = baseline == 0 ? 0.0 : (100.0 * avoided / baseline);
    /**
import java.util.List;
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
    numClientNodes = 0,
                .get()
                .setMapping("ts", "type=long", "host", "type=keyword,index=false")
            ArrowBasePlugin.class,
        logger.info("MEASURE  shards  head  window  baseline  gated  avoided  avoided%  rows");
            .build();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
            client().admin()
            TestPPLPlugin.class,
            return;   // leave the node-settings default in place
            new int[] { 10, 10, -1 },
                shards,
 * this file be licensed under the Apache-2.0 license or a
            .setTransientSettings(Settings.builder().putNull(key).build())
        Settings settings = Settings.builder()
            .put(super.nodeSettings(nodeOrdinal))
        List<String> rendered = new ArrayList<>(response.getRows().size());
            CompositeDataFormatPlugin.class,
        DefaultPlanExecutor executor = executor();
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
    }
import org.opensearch.common.util.FeatureFlags;
    private String createDisjointIndices(String prefix, int shards) {
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        }
        }
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            new int[] { 10, 100, 1 },
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
    // ── fixture ──────────────────────────────────────────────────────────
    // ── settings plumbing ────────────────────────────────────────────────
            List<String> gatedRows = renderRows(executePPL(ppl));
        String indices = indicesFor(shards);
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
    private String measure(int shards, int head, int window) throws Exception {
                "the gated run must return the same rows as the baseline",
        for (String node : internalCluster().getDataNodeNames()) {
    }
        StringBuilder commaList = new StringBuilder();
        logger.info("MEASURE header: nodes={} docsPerShard={}", nodes, DOCS_PER_SHARD);
    private final Map<Integer, String> indicesByShardCount = new HashMap<>();
public class SortEarlyTerminationMeasurementIT extends OpenSearchIntegTestCase {
import java.util.Locale;
        String ppl = "source = " + indices + " | sort - ts | head " + head + " | fields ts";
            );
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            MockTransportService.TestPlugin.class,
            new int[] { 200, 10, -1 },
import org.opensearch.analytics.AnalyticsPlugin;
    private DefaultPlanExecutor executor() {
 * {@code numDataNodes} and re-running.
        try {
            new int[] { 50, 10, -1 },
 * logged as a {@code MEASURE} line and transcribed to {@code debug/can-match/sort-et-observations.md}.
     * {@code 0} owns the highest block. Returns them as a comma-separated list for the PPL source.
                baseline,
    protected Collection<PluginInfo> additionalNodePlugins() {
            new int[] { 10, 10, 1 },
     * <p>Indices are shared across grid points with the same shard count, both to stay under the test
        assertBusy(() -> assertEquals("executor must observe the window update", window, executor.maxConcurrentShardRequestsPerNode()));
                commaList.append(',');
                bulk.add(client().prepareIndex(index).setSource("ts", base + doc, "host", "h-" + i + "-" + doc));
    }
        }
 * Measurement harness, not a correctness test: counts how many fragment dispatches the sort gate
import org.opensearch.be.datafusion.DataFusionPlugin;
                .prepareUpdateSettings()
        setWindow(window);
                    Settings.builder().put(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey(), window).build()
 * returns the same rows as the wait-for-all baseline.
    }
            assertEquals(
            commaList.append(index);
            for (int doc = 0; doc < DOCS_PER_SHARD; doc++) {
        }
     *
        for (Object[] row : response.getRows()) {
            .put("index.pluggable.dataformat", "composite")
                counter.incrementAndGet();
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;
            clearOverride(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey());
     *
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            MockCommitterEnginePlugin.class
