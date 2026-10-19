                    client().prepareIndex(index).setSource("ts", ts, "host", host).get();
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
    private static final int TOTAL_DAYS = 7;  
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
import org.opensearch.test.OpenSearchIntegTestCase;  
    /** One run, for shapes with no {@code head} and so no gated/baseline pair to compare. */
     * only the shard strictly below it is skipped.  
    }
     */
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            )  
import org.opensearch.common.util.FeatureFlags;
    private PPLResponse executePPL(String ppl) {
    }
 * The OpenSearch Contributors require contributions made to  
     */
            clearTransportRules();
            .put("index.composite.primary_data_format", "parquet")
import java.util.Collections;
            "NA",
        AtomicInteger dispatches = countFragmentDispatches();
    /**
    }  
        assertEquals(
        String indices = createIndices(  
        } finally {
            Arrays.asList(
            assertEquals("no limit — every doc comes back", TOTAL_DAYS * DOCS_PER_DAY, outcome.rows().size());
     * {@code null} timestamp indexes a doc with no {@code ts} field, so those lists must be
        }  
        }
 * End-to-end tests for dispatch-gated sort early termination: for a bounded sort
                // index=false keeps host off the lucene secondary format; parquet covers it.
    }
     * Three indices whose key ranges interleave. No shard's range is disjoint from the top 3, so every
    // ── fixture ──────────────────────────────────────────────────────────
     * Aggregate top-K sorts a computed value with no shard statistic behind it, so no gate is built and  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
            client().admin().indices().prepareFlush(index).get();
            assertEquals("aggregate top-K is not gateable", TOTAL_DAYS, outcome.gatedDispatches());
            assertEquals("the wait-for-all baseline must open both shards", 2, outcome.baselineDispatches());
        AtomicInteger dispatches = countFragmentDispatches();  
                Arrays.asList(null, day(10, 1))                        // range below the bar, but null-bearing
        try {
        List<String> rendered = new ArrayList<>(response.getRows().size());  
            assertEquals("an unfilled heap has no bar — every shard is still needed", TOTAL_DAYS, outcome.gatedDispatches());
        String indices = createIndices("sort_et_asc_", dailyTimestamps());
    /** {@code 2026-07-<day>T<hour>:00:00Z}, the only timestamp shape this fixture uses. */
                .prepareCreate(index)
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());
    public void testUnboundedSortDispatchesEveryShard() throws Exception {  
 * {@link #runAgainstWaitForAll}), and the expected number of shards was dispatched.
import java.util.ArrayList;
        try {
        }  
        List<String> gatedRows = renderRows(executePPL(gatedPpl));
    private static final int BASELINE_LIMIT = 1000;
            assertEquals("a shard that may hold a null can never be eliminated", 2, outcome.gatedDispatches());
 * this file be licensed under the Apache-2.0 license or a
    }
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 3, dispatches);
    numClientNodes = 0,  
    /**
            Outcome outcome = runOnce("source = " + indices + " | sort - ts | fields ts", dispatches);
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                }
        logger.info("sort-et: [{}] dispatches={}", ppl, sent);  
        } finally {  
     */  
    }
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());  
    /** One string per row, so row sets compare by value regardless of column types. */
    public void testLimitLargerThanTheDataDispatchesEveryShard() throws Exception {
import java.util.List;
    private static final int DOCS_PER_DAY = 5;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
    public void testShardTyingTheBarIsStillDispatched() throws Exception {
                List.of(day(10, 0), day(10, 5), day(10, 10), day(10, 15), day(10, 20)),  
import org.opensearch.Version;
    }
        }  
            assertEquals("the wait-for-all baseline must open all three shards", 3, outcome.baselineDispatches());
     */
    /** The baseline {@code head} — past every fixture's row count, so the gate can never arm. */
        );  
    // ── the two-run harness ──────────────────────────────────────────────  
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
                "the shard tying the bar must still be dispatched; only the strictly-worse one is skipped",
                counter.incrementAndGet();  
        String indices = createIndices("sort_et_desc_", dailyTimestamps());
    private static List<List<String>> dailyTimestamps() {
 * ({@code sort <field> | head N}) the coordinator keeps a heap of the best {@code N} keys seen so far
    private static List<String> renderRows(PPLResponse response) {
        try {
        String baselinePpl = String.format(Locale.ROOT, pplTemplate, BASELINE_LIMIT);  
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
import java.util.Collection;  
     * The same elimination on the other merge path: projecting {@code host} while sorting on {@code ts}  
     */
            perIndex.add(docs);
        try {
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());  
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
        for (int i = 0; i < perIndexTimestamps.size(); i++) {  
     * Creates one single-shard parquet index per entry in {@code perIndexTimestamps}, named
        String gatedPpl = String.format(Locale.ROOT, pplTemplate, limit);
    /**
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort + ts | head %d | fields ts", 3, dispatches);  
        String indices = createIndices("sort_et_unbounded_", dailyTimestamps());
        );
                .setMapping("ts", "type=date", "host", "type=keyword,index=false")
        }  
public class SortEarlyTerminationIT extends OpenSearchIntegTestCase {  
            assertEquals(  
                Arrays.asList(day(10, 5), day(10, 4), day(10, 3)),   // fills the heap; bar = 03:00  
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());  
        return new PluginInfo(
        );
        int gatedDispatches = dispatches.getAndSet(0);
    scope = OpenSearchIntegTestCase.Scope.SUITE,
     * Same fixture ascending: {@code sort + ts | head 3} keeps only the oldest day, eliminating on
        List<List<String>> perIndex = new ArrayList<>(TOTAL_DAYS);
            )
                String host = "host-" + i + "-" + doc;
    /**
                List.of(day(10, 3), day(10, 2)),                            // max ties the bar exactly
            )  
            clearTransportRules();  
    public void testDisjointDaysDescendingSkipsAllButTheNewestDay() throws Exception {  
            .build();
        } finally {
        List<String> rows = renderRows(executePPL(ppl));
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());  
            List<String> docs = new ArrayList<>(DOCS_PER_DAY);
            rendered.add(Arrays.deepToString(row));
        return Settings.builder()
        for (int d = FIRST_DAY; d < FIRST_DAY + TOTAL_DAYS; d++) {  
            .build();  
            List.of(
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 3, dispatches);
    }
     * Runs {@code pplTemplate} twice — once with {@code limit}, once with {@link #BASELINE_LIMIT} — and  
import org.opensearch.plugins.Plugin;  
        try {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                docs.add(day(d, hour));  
        } finally {  
        dispatches.set(0);  
        }
    private Outcome runOnce(String ppl, AtomicInteger dispatches) {
                String ts = timestamps.get(doc);  
     */  
     */
            ArrowBasePlugin.class,
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))  
        );  
        logger.info("sort-et: [{}] dispatches baseline={} gated={}", gatedPpl, baselineDispatches, gatedDispatches);
                .indices()
    public void testNullBearingShardIsNeverEliminated() throws Exception {
        } finally {  
import org.opensearch.common.settings.Settings;
        try {
            client().admin().indices().prepareRefresh(index).get();
     * The bar is {@code 03:00}. A shard whose max ties it may hold a tying row and must be dispatched;
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),  
            );
        String indices = createIndices("sort_et_qtf_", dailyTimestamps());
    private Outcome runAgainstWaitForAll(String pplTemplate, int limit, AtomicInteger dispatches) {
     * takes the QTF / late-materialization rewrite, under which the gate must behave identically.
 */  
        );  
            pluginClass.getName(),
        return counter;
    }
        );
            extendedPlugins,
        return String.format(Locale.ROOT, "2026-07-%02dT%02d:00:00Z", day, hour);  
            // Sort on the group key, not the count, so the top-3 is deterministic.
 *  
        AtomicInteger dispatches = countFragmentDispatches();  
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
            assertEquals("only the oldest day can contribute the bottom 3", 1, outcome.gatedDispatches());
        }
/**  
     * and fills the heap, so the six older days are skipped.
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts, host", 3, dispatches);
        }
            ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();  
            assertEquals("every doc is inside the window", TOTAL_DAYS * DOCS_PER_DAY, outcome.rows().size());
                List.of(day(10, 1), day(10, 6), day(10, 11), day(10, 16), day(10, 21)),
        int baselineDispatches = dispatches.getAndSet(0);
            MockTransportService.TestPlugin.class,
        AtomicInteger dispatches = countFragmentDispatches();  
            for (int hour = 0; hour < DOCS_PER_DAY; hour++) {
     * shard must be dispatched.  
            clearTransportRules();
            clearTransportRules();  
    }
        try {
            false
        return perIndex;
 * One single-shard parquet index per day, addressed as a PPL comma-list, because a {@code logs-*}  
    private record Outcome(List<String> rows, int baselineDispatches, int gatedDispatches) {}  
    }  
 * @opensearch.internal
            "sort_et_tie_",
 * and refuses to open a stream to a shard whose whole reported range is strictly worse than the worst  
     */
    private void clearTransportRules() {
 */
     * asserts the gated rows equal the baseline's leading {@code limit} rows, then returns both dispatch
 *
import org.opensearch.test.transport.MockTransportService;
 * <p>Fixture notes: the per-node window is pinned to 1 so elimination is deterministic — the veto only
        return commaList.toString();
    }
            // One in-flight shard request per node — see the class javadoc.  
            MockCommitterEnginePlugin.class
import org.opensearch.analytics.AnalyticsPlugin;  
import org.opensearch.plugins.PluginInfo;
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
import java.util.Arrays;
    }
    private String createIndices(String prefix, List<List<String>> perIndexTimestamps) {
     */
        String indices = createIndices("sort_et_agg_", dailyTimestamps());
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.transport.TransportService;
        dispatches.set(0);  
            assertEquals("only the newest day can contribute the top 3", 1, outcome.gatedDispatches());  
import org.opensearch.ppl.action.PPLRequest;  
    protected Settings nodeSettings(int nodeOrdinal) {
            baselineRows.subList(0, Math.min(limit, baselineRows.size())),
    }  
     * {@code DESC} maps to {@code NULLS FIRST}, so that null is the top row of the answer.  
            .putList("index.composite.secondary_data_formats")
}
                commaList.append(',');
    /** What the gated run returned, next to what the wait-for-all run cost in dispatches. */
 * {@link #testLateMaterializationPathMatchesBaseline} projects an extra column to take the QTF path.
        return new Outcome(gatedRows, baselineDispatches, gatedDispatches);
        AtomicInteger counter = new AtomicInteger();
            null,  
    }
    /** A week of daily indices: day {@code d} holds {@link #DOCS_PER_DAY} docs inside day {@code d}. */  
    }
    }
import org.opensearch.ppl.TestPPLPlugin;
            assertEquals("an un-limited sort is not gateable", TOTAL_DAYS, outcome.gatedDispatches());
            .put("index.pluggable.dataformat.enabled", true)
            }  
            gatedRows
    }
        AtomicInteger dispatches = countFragmentDispatches();  
        AtomicInteger dispatches = countFragmentDispatches();  
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
import org.opensearch.be.datafusion.DataFusionPlugin;
     * {@code <prefix><ordinal>}, and returns them as a comma-separated PPL {@code source =} list. A  
        Settings settings = Settings.builder()
/*  
 * of them. Each test asserts both halves: the gated answer equals the wait-for-all answer (via
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 3, dispatches);
     * every shard runs — despite sharing the same {@code sort | head} syntax.
            Version.CURRENT,  
import org.opensearch.ppl.action.PPLResponse;
    public void testOverlappingRangesDispatchEveryShard() throws Exception {
                handler.messageReceived(request, channel, task);
        );  
        AtomicInteger dispatches = countFragmentDispatches();
     * wait-for-all reference.  
            clearTransportRules();
    /**  
            CompositeDataFormatPlugin.class,  
     * A week of disjoint daily indices, {@code sort - ts | head 3}. The newest day is dispatched first  
            Outcome outcome = runAgainstWaitForAll(  
            List.of(
 *  
            commaList.append(index);
        }
    @Override
    supportsDedicatedMasters = false
        }
            .put(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey(), 1)
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    /** An un-limited {@code sort} yields no {@code SortSpec}, so there is no gate and every shard runs. */
            );
            });
        } finally {
                "source = " + indices + " | stats count() as c by host | sort - host | head %d",
            "the gate must never change the answer",  
        String indices = createIndices("sort_et_wide_", dailyTimestamps());
    public void testDisjointDaysAscendingSkipsAllButTheOldestDay() throws Exception {
)
 * acts on shards still queued, and at the default window of 5 the whole fan-out is on the wire first.
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 3, dispatches);
        StringBuilder commaList = new StringBuilder();
@OpenSearchIntegTestCase.ClusterScope(  
    protected Collection<PluginInfo> additionalNodePlugins() {
                } else {  
                .get();  
            assertEquals("the wait-for-all baseline must open all three shards", 3, outcome.baselineDispatches());
    /**
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
    private AtomicInteger countFragmentDispatches() {
package org.opensearch.analytics.canmatch;
        String indices = createIndices(  
    public void testLateMaterializationPathMatchesBaseline() throws Exception {  
            clearTransportRules();
            assertEquals("no shard's range is disjoint from the top 3 — none may be skipped", 3, outcome.gatedDispatches());  
            clearTransportRules();
     * counts. The gate has no off switch, so the oversized {@code head} is what makes the second run a
    private static final int FIRST_DAY = 8;
            Outcome outcome = runAgainstWaitForAll("source = " + indices + " | sort - ts | head %d | fields ts", 100, dispatches);  
            assertEquals("only the newest day can contribute the top 3", 1, outcome.gatedDispatches());  
            CreateIndexResponse response = client().admin()  
        } finally {
     * A shard whose non-null range sits below the bar but which holds a null must still be dispatched:
    }
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
    /**
     * {@code min} rather than {@code max}.
 * SPDX-License-Identifier: Apache-2.0
                List.of(day(10, 2))                                         // max strictly below the bar
        }  
        ensureGreen();  
    /**
        return List.of(
            TestPPLPlugin.class,
        } finally {
    numDataNodes = 1,
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
    private static String day(int day, int hour) {
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());
            "sort_et_overlap_",
        int sent = dispatches.getAndSet(0);
        return new Outcome(rows, sent, sent);
                2,
        try {  
    }  
            "classpath plugin",
        try {
    /** Counts {@link FragmentExecutionAction} requests handled on every data node. */  
 * wildcard bypasses can-match. Queries project {@code | fields ts} so rows can't tie ambiguously;
            .put(super.nodeSettings(nodeOrdinal))  
            pluginClass.getName(),  
        for (String node : internalCluster().getDataNodeNames()) {
                .setSettings(settings)  
                    client().prepareIndex(index).setSource("host", host).get();
            assertTrue("index creation must be acknowledged", response.isAcknowledged());
import java.util.Locale;  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        List<String> baselineRows = renderRows(executePPL(baselinePpl));
    }
            assertEquals("head 3 must return 3 rows", 3, outcome.rows().size());
                if (ts == null) {
                List.of(day(10, 5), day(10, 4), day(10, 3), day(10, 3)),   // fills the heap; bar = 03:00  
    @Override  
        String indices = createIndices(  
import org.opensearch.composite.CompositeDataFormatPlugin;  
        for (Object[] row : response.getRows()) {
            }  
    /** {@code head 100} against 35 docs: the heap never fills, so there is no bar and no shard is skipped. */  
                3,
                outcome.gatedDispatches()  
        }
            "1.8",
                dispatches  
            for (int doc = 0; doc < timestamps.size(); doc++) {
            String index = prefix + i;
            "sort_et_nulls_",
        AtomicInteger dispatches = countFragmentDispatches();
            .put("index.pluggable.dataformat", "composite")  
     * {@link Arrays#asList}. The cluster is SUITE-scoped, so each test needs its own prefix.
    }  
            clearTransportRules();
        } finally {
    /**
    public void testAggregateTopKIsNotGated() throws Exception {  
            clearTransportRules();  
            assertEquals("the wait-for-all baseline must open every day's shard", TOTAL_DAYS, outcome.baselineDispatches());
    @Override  
        }  
        AtomicInteger dispatches = countFragmentDispatches();  
                List.of(day(10, 2), day(10, 7), day(10, 12), day(10, 17), day(10, 22))
    // A week of daily rollover, one shard each: 2026-07-08 .. 2026-07-14.
            if (i > 0) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            }
import org.opensearch.cluster.metadata.IndexMetadata;  
        return rendered;
            List<String> timestamps = perIndexTimestamps.get(i);  
        }
 * compatible open source license.
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
        for (String node : internalCluster().getDataNodeNames()) {  
        return List.of(  
