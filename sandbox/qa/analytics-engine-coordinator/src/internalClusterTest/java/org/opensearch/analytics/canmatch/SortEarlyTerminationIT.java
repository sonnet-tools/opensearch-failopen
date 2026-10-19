        } finally {
            MockCommitterEnginePlugin.class
import org.opensearch.plugins.Plugin;
    @Override
            assertEquals("an unfilled heap has no bar — every shard is still needed", TOTAL_DAYS, outcome.gatedDispatches());
    private static final int DOCS_PER_DAY = 5;
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort + ts | head %d | fields ts", 3, dispatches);
import org.opensearch.ppl.TestPPLPlugin;
@OpenSearchIntegTestCase.ClusterScope(
        return new Outcome(gatedRows, baselineDispatches, gatedDispatches);
            "1.8",
        logger.info("sort-et: [{}] dispatches baseline={} gated={}", gatedPpl, baselineDispatches, gatedDispatches);
    }
        String indices = createIndices("sort_et_qtf_", dailyTimestamps());
        for (String node : internalCluster().getDataNodeNames()) {
        String indices = createIndices("sort_et_desc_", dailyTimestamps());
    private static final int FIRST_DAY = 8;
    /** What the gated run returned, next to what the wait-for-all run cost in dispatches. */
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
    }
            assertEquals("only the newest day can contribute the top 3", 1, outcome.gatedDispatches());
            )
        List<String> rendered = new ArrayList<>(response.getRows().size());
            assertTrue("index creation must be acknowledged", response.isAcknowledged());
            assertEquals("the wait-for-all baseline must open all three shards", 3, outcome.baselineDispatches());
    /**
        } finally {
     * The same elimination on the other merge path: projecting {@code host} while sorting on {@code ts}
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 3, dispatches);
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        try {
        AtomicInteger dispatches = countFragmentDispatches();
        String indices = createIndices("sort_et_unbounded_", dailyTimestamps());
     */
        return new Outcome(rows, sent, sent);
     * {@code DESC} maps to {@code NULLS FIRST}, so that null is the top row of the answer.
        }
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            CompositeDataFormatPlugin.class,
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 3, dispatches);
            MockTransportService.TestPlugin.class,
        String indices = createIndices("sort_et_asc_", dailyTimestamps());
 *
        String indices = createIndices(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * this file be licensed under the Apache-2.0 license or a
        return new PluginInfo(
 * wildcard bypasses can-match. Queries project {@code | fields ts} so rows can't tie ambiguously;
    }
    }
 * {@link #runAgainstWaitForAll}), and the expected number of shards was dispatched.
     */
        for (String node : internalCluster().getDataNodeNames()) {
    /** One string per row, so row sets compare by value regardless of column types. */
                } else {
                counter.incrementAndGet();
            .put("index.pluggable.dataformat", "composite")
            clearTransportRules();
            perIndex.add(docs);
            assertEquals("no shard's range is disjoint from the top 3 — none may be skipped", 3, outcome.gatedDispatches());
import java.util.Locale;
                List.of(day(10, 3), day(10, 2)),                            // max ties the bar exactly
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
    private record Outcome(List<String> rows, int baselineDispatches, int gatedDispatches) {}
                .get();
            assertEquals(
            .put(FeatureFlags.STREAM_TRANSPORT, true)
    private static List<String> renderRows(PPLResponse response) {
            baselineRows.subList(0, Math.min(limit, baselineRows.size())),
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());
    // ── the two-run harness ──────────────────────────────────────────────
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
     * A shard whose non-null range sits below the bar but which holds a null must still be dispatched:
    @Override
        }
        for (Object[] row : response.getRows()) {
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        } finally {
     */
    }
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 100, dispatches);
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            "classpath plugin",
        int sent = dispatches.getAndSet(0);
 * The OpenSearch Contributors require contributions made to
                Arrays.asList(day(10, 5), day(10, 4), day(10, 3)),   // fills the heap; bar = 03:00
        }
import org.opensearch.test.transport.MockTransportService;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * Three indices whose key ranges interleave. No shard's range is disjoint from the top 3, so every
import org.opensearch.ppl.action.PPLResponse;
        );
     * {@code <prefix><ordinal>}, and returns them as a comma-separated PPL {@code source =} list. A
    supportsDedicatedMasters = false
        String gatedPpl = String.format(Locale.ROOT, pplTemplate, limit);
            "sort_et_overlap_",
    }
}
 *
            .build();
    }
                }
                .setMapping("ts", "type=date", "host", "type=keyword,index=false")
 * and refuses to open a stream to a shard whose whole reported range is strictly worse than the worst
    }
 *
                2,
        logger.info("sort-et: [{}] dispatches={}", ppl, sent);
    public void testAggregateTopKIsNotGated() throws Exception {
            ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();
            List.of(
 * acts on shards still queued, and at the default window of 5 the whole fan-out is on the wire first.
        );
            client().admin().indices().prepareRefresh(index).get();
     * only the shard strictly below it is skipped.
        }
     * A week of disjoint daily indices, {@code sort - ts | head 3}. The newest day is dispatched first
            });
        AtomicInteger dispatches = countFragmentDispatches();
        try {
            "sort_et_nulls_",
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
    }
            .build();
    }
    // A week of daily rollover, one shard each: 2026-07-08 .. 2026-07-14.
     * counts. The gate has no off switch, so the oversized {@code head} is what makes the second run a
        for (int d = FIRST_DAY; d < FIRST_DAY + TOTAL_DAYS; d++) {
            commaList.append(index);
    /**
            Arrays.asList(
            .put(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey(), 1)
            // Sort on the group key, not the count, so the top-3 is deterministic.
    }
        }
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
import org.opensearch.be.datafusion.DataFusionPlugin;
     * and fills the heap, so the six older days are skipped.
                3,
        } finally {
                .setSettings(settings)
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());
        String baselinePpl = String.format(Locale.ROOT, pplTemplate, BASELINE_LIMIT);
 */
            for (int hour = 0; hour < DOCS_PER_DAY; hour++) {
 */
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import java.util.ArrayList;
    public void testDisjointDaysDescendingSkipsAllButTheNewestDay() throws Exception {
import org.opensearch.Version;
        dispatches.set(0);
            "NA",
    /** Counts {@link FragmentExecutionAction} requests handled on every data node. */
        return rendered;
                List.of(day(10, 2))                                         // max strictly below the bar
        try {
            assertEquals("the wait-for-all baseline must open all three shards", 3, outcome.baselineDispatches());
        int baselineDispatches = dispatches.getAndSet(0);
        List<String> baselineRows = renderRows(executePPL(baselinePpl));
            .put(super.nodeSettings(nodeOrdinal))
        dispatches.set(0);
        );
     */
        AtomicInteger dispatches = countFragmentDispatches();
    numClientNodes = 0,
        List<String> gatedRows = renderRows(executePPL(gatedPpl));
            clearTransportRules();
            assertEquals("only the newest day can contribute the top 3", 1, outcome.gatedDispatches());
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            );
            clearTransportRules();
        for (int i = 0; i < perIndexTimestamps.size(); i++) {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    /**
            List<String> timestamps = perIndexTimestamps.get(i);
            "sort_et_tie_",
    private String createIndices(String prefix, List<List<String>> perIndexTimestamps) {
     * {@link Arrays#asList}. The cluster is SUITE-scoped, so each test needs its own prefix.
            )
        AtomicInteger dispatches = countFragmentDispatches();
        String indices = createIndices(
    /** {@code head 100} against 35 docs: the heap never fills, so there is no bar and no shard is skipped. */
            // One in-flight shard request per node — see the class javadoc.
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());
    }
        return List.of(
     * The bar is {@code 03:00}. A shard whose max ties it may hold a tying row and must be dispatched;
    /** {@code 2026-07-<day>T<hour>:00:00Z}, the only timestamp shape this fixture uses. */
        List<String> rows = renderRows(executePPL(ppl));
        return Settings.builder()
     */
        }
    }
     * {@code null} timestamp indexes a doc with no {@code ts} field, so those lists must be
        AtomicInteger counter = new AtomicInteger();
 * compatible open source license.
                List.of(day(10, 5), day(10, 4), day(10, 3), day(10, 3)),   // fills the heap; bar = 03:00
    public void testShardTyingTheBarIsStillDispatched() throws Exception {
        );
import org.opensearch.common.settings.Settings;
    private static String day(int day, int hour) {
    }
import java.util.Arrays;
        }
            .put("index.composite.primary_data_format", "parquet")
            String index = prefix + i;
                    client().prepareIndex(index).setSource("ts", ts, "host", host).get();
    }
                "source = " + indices + " | stats count() as c by host | sort - host | head %d",
    protected Collection<PluginInfo> additionalNodePlugins() {
        }
        try {
 * of them. Each test asserts both halves: the gated answer equals the wait-for-all answer (via
/*
     */
                String ts = timestamps.get(doc);
        Settings settings = Settings.builder()
        );
        AtomicInteger dispatches = countFragmentDispatches();
            clearTransportRules();
    public void testLateMaterializationPathMatchesBaseline() throws Exception {
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
import org.opensearch.analytics.AnalyticsPlugin;
        try {
import org.opensearch.plugins.PluginInfo;
        }
    }
    private void clearTransportRules() {
import org.opensearch.ppl.action.PPLRequest;
    public void testLimitLargerThanTheDataDispatchesEveryShard() throws Exception {
                if (ts == null) {
            List.of(
    }
            clearTransportRules();
    public void testUnboundedSortDispatchesEveryShard() throws Exception {
import java.util.List;
            .put("index.pluggable.dataformat.enabled", true)
            null,
                handler.messageReceived(request, channel, task);
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
import java.util.Collection;
 * SPDX-License-Identifier: Apache-2.0
    }
 * <p>Fixture notes: the per-node window is pinned to 1 so elimination is deterministic — the veto only
     * asserts the gated rows equal the baseline's leading {@code limit} rows, then returns both dispatch
    private static final int TOTAL_DAYS = 7;
        try {
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());
    /** An un-limited {@code sort} yields no {@code SortSpec}, so there is no gate and every shard runs. */
            assertEquals("a shard that may hold a null can never be eliminated", 2, outcome.gatedDispatches());
            pluginClass.getName(),
    /**
        return commaList.toString();
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            false
            extendedPlugins,
        int gatedDispatches = dispatches.getAndSet(0);
    private Outcome runAgainstWaitForAll(String pplTemplate, int limit, AtomicInteger dispatches) {
            }
    /**
        } finally {
        return perIndex;
        return String.format(Locale.ROOT, "2026-07-%02dT%02d:00:00Z", day, hour);
            assertEquals("the wait-for-all baseline must open both shards", 2, outcome.baselineDispatches());
    // ── fixture ──────────────────────────────────────────────────────────
    /** A week of daily indices: day {@code d} holds {@link #DOCS_PER_DAY} docs inside day {@code d}. */
    /**
        return counter;
 * ({@code sort <field> | head N}) the coordinator keeps a heap of the best {@code N} keys seen so far
        }
            assertEquals("an un-limited sort is not gateable", TOTAL_DAYS, outcome.gatedDispatches());
            assertEquals("only the oldest day can contribute the bottom 3", 1, outcome.gatedDispatches());
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 3, dispatches);
        }
    scope = OpenSearchIntegTestCase.Scope.SUITE,
        } finally {
     * {@code min} rather than {@code max}.
    @Override
            }
            TestPPLPlugin.class,
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
     * every shard runs — despite sharing the same {@code sort | head} syntax.
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
                    client().prepareIndex(index).setSource("host", host).get();
            for (int doc = 0; doc < timestamps.size(); doc++) {
    }
    private static final int BASELINE_LIMIT = 1000;
     * Runs {@code pplTemplate} twice — once with {@code limit}, once with {@link #BASELINE_LIMIT} — and
        ensureGreen();
/**
        AtomicInteger dispatches = countFragmentDispatches();
import org.opensearch.test.OpenSearchIntegTestCase;
        String indices = createIndices("sort_et_agg_", dailyTimestamps());
            assertEquals("no limit — every doc comes back", TOTAL_DAYS * DOCS_PER_DAY, outcome.rows().size());
    private static List<List<String>> dailyTimestamps() {
     * takes the QTF / late-materialization rewrite, under which the gate must behave identically.
            }
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
            )
                docs.add(day(d, hour));
            if (i > 0) {
    /** One run, for shapes with no {@code head} and so no gated/baseline pair to compare. */
                outcome.gatedDispatches()
        return List.of(
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());
        String indices = createIndices("sort_et_wide_", dailyTimestamps());
            pluginClass.getName(),
            clearTransportRules();
    numDataNodes = 1,
        StringBuilder commaList = new StringBuilder();
                List.of(day(10, 1), day(10, 6), day(10, 11), day(10, 16), day(10, 21)),
     */
            "the gate must never change the answer",
public class SortEarlyTerminationIT extends OpenSearchIntegTestCase {
        }
     */
        List<List<String>> perIndex = new ArrayList<>(TOTAL_DAYS);
    }
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
     */
     * Creates one single-shard parquet index per entry in {@code perIndexTimestamps}, named
    }
import org.opensearch.common.util.FeatureFlags;
                .indices()
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
import org.opensearch.cluster.metadata.IndexMetadata;
                // index=false keeps host off the lucene secondary format; parquet covers it.
        } finally {
package org.opensearch.analytics.canmatch;
    /**
 * End-to-end tests for dispatch-gated sort early termination: for a bounded sort
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 3, dispatches);
                List.of(day(10, 0), day(10, 5), day(10, 10), day(10, 15), day(10, 20)),
        }
     * Same fixture ascending: {@code sort + ts | head 3} keeps only the oldest day, eliminating on
            clearTransportRules();
                "the shard tying the bar must still be dispatched; only the strictly-worse one is skipped",
            gatedRows
        try {
            rendered.add(Arrays.deepToString(row));
    public void testNullBearingShardIsNeverEliminated() throws Exception {
            clearTransportRules();
    private AtomicInteger countFragmentDispatches() {
     * Aggregate top-K sorts a computed value with no shard statistic behind it, so no gate is built and
            Outcome outcome = runOnce("source = " + indices + " | sort - ts | fields ts", dispatches);
import org.opensearch.composite.CompositeDataFormatPlugin;
    /**
            List<String> docs = new ArrayList<>(DOCS_PER_DAY);
                String host = "host-" + i + "-" + doc;
     * wait-for-all reference.
        );
 * @opensearch.internal
            clearTransportRules();
)
 * {@link #testLateMaterializationPathMatchesBaseline} projects an extra column to take the QTF path.
        AtomicInteger dispatches = countFragmentDispatches();
        } finally {
            Outcome outcome = runAgainstWaitForAll(
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts, host", 3, dispatches);
            .putList("index.composite.secondary_data_formats")
            Version.CURRENT,
    public void testOverlappingRangesDispatchEveryShard() throws Exception {
import java.util.Collections;
        try {
            client().admin().indices().prepareFlush(index).get();
 * One single-shard parquet index per day, addressed as a PPL comma-list, because a {@code logs-*}
    public void testDisjointDaysAscendingSkipsAllButTheOldestDay() throws Exception {
    /**
                dispatches
            CreateIndexResponse response = client().admin()
    private Outcome runOnce(String ppl, AtomicInteger dispatches) {
    /** The baseline {@code head} — past every fixture's row count, so the gate can never arm. */
        } finally {
    }
import org.opensearch.transport.TransportService;
            assertEquals("aggregate top-K is not gateable", TOTAL_DAYS, outcome.gatedDispatches());
            ArrowBasePlugin.class,
     * shard must be dispatched.
    private PPLResponse executePPL(String ppl) {
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
        }
        assertEquals(
        try {
                List.of(day(10, 2), day(10, 7), day(10, 12), day(10, 17), day(10, 22))
            );
                commaList.append(',');
        );
                .prepareCreate(index)
                Arrays.asList(null, day(10, 1))                        // range below the bar, but null-bearing
        AtomicInteger dispatches = countFragmentDispatches();
        AtomicInteger dispatches = countFragmentDispatches();
            assertEquals("every doc is inside the window", TOTAL_DAYS * DOCS_PER_DAY, outcome.rows().size());
        String indices = createIndices(
