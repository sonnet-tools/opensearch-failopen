    // ── helpers ──────────────────────────────────────────────────────────  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
     * runs. Guards against the extractor over-reaching and pruning when there is no window.  
import org.opensearch.plugins.Plugin;  
import java.util.concurrent.TimeUnit;
 * <p>Indices are addressed as a PPL comma-list ({@code source = a,b,c}), a native multi-index union
                "source = " + indices + " | where `@timestamp` >= '2026-07-01 00:00:00' and `@timestamp` <= '2026-07-31 23:59:59' | fields host"
        } finally {  
 * @opensearch.internal  
        for (int day = FIRST_DAY; day <= LAST_DAY; day++) {
 *   <li><b>No filter / covering window</b> — nothing disjoint → every day runs. Guards over-pruning.</li>
            String index = String.format(Locale.ROOT, "%s%02d", DAY_INDEX_PREFIX, day);  
    private static final int LAST_DAY = FIRST_DAY + TOTAL_DAYS - 1; // 2026-07-14  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
 *       prune; only days inside survive.</li>  
        AtomicInteger dispatches = countFragmentDispatches();  
    }  
                "source = " + indices + " | where `@timestamp` >= '2026-07-13 00:00:00' | fields host"
    @Override
            assertEquals("all days pruned; one kept for a valid empty result", 1, dispatches.get());
    }  
            clearTransportRules();
            }, 30, TimeUnit.SECONDS);
            ArrowBasePlugin.class,  
                .get();  
     * drop is the proof pruning happened; a broken build dispatches to every day.
            PPLResponse response = executePPL(
import java.util.concurrent.atomic.AtomicInteger;  
            );  
 *   <li><b>Window beyond all data</b> — every day disjoint → all pruned, but can-match force-keeps  
            });
                counter.incrementAndGet();
                    .get();
    }
 * Integration test for the can-match pre-filter phase, modelling the flagship time-series / log  
    private static final int TOTAL_DAYS = 7;
 *
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }  
            String index = String.format(Locale.ROOT, "%s%02d", DAY_INDEX_PREFIX, day);  
            );
    /**
            .put("index.pluggable.dataformat", "composite")
                "source = " + indices + " | where `@timestamp` >= '2026-08-01 00:00:00' | fields host"  
 * Pruning is therefore deterministic: a day is kept iff its date range overlaps the query window,
            clearTransportRules();
import org.opensearch.be.datafusion.DataFusionPlugin;
            assertEquals("all docs returned", TOTAL_DAYS * DOCS_PER_DAY, response.getRows().size());  
    // A week of daily rollover: logs-parquet-2026-07-08 .. logs-parquet-2026-07-14, one shard each.
    }
            if (day > FIRST_DAY) {
    }
        try {
            for (int i = 0; i < DOCS_PER_DAY; i++) {  
 *       one shard so the query still yields a valid empty result (mirrors vanilla's all-pruned
        String indices = createDailyIndices();  
                        "host",
 * dashboard issues a {@code range(@timestamp)} query — "last N days", "since T", "before T", or a
            assertTrue("no rows should match a window past all data", response.getRows().isEmpty());  
        for (String node : internalCluster().getDataNodeNames()) {
        );  
 * <p>The fixture is a week of daily indices ({@value #DAY_INDEX_PREFIX}{@code 08 .. 14}), each with
        }
     * where days on <em>both</em> sides of the window must prune. Days 08–09 (below) and 12–14
            .build();
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);  
            clearTransportRules();
    }
 * <ul>
                        "@timestamp",  
            assertBusy(() -> {
 * can-match, so the count equals the surviving-shard (= surviving-day) count.
        } finally {
import org.opensearch.Version;
 * compatible open source license.
    private static final int FIRST_DAY = 8;   // 2026-07-08
        return List.of(
            PPLResponse response = executePPL(
    }
 *   <li><b>Upper-bound window</b> ("before T") — newer days prune, older survive.</li>
                handler.messageReceived(request, channel, task);  
     * {@code @timestamp} falls entirely within that day. Returns the comma-separated index list for  
    private AtomicInteger countFragmentDispatches() {  
            clearTransportRules();
        for (String node : internalCluster().getDataNodeNames()) {
        }  
import java.util.List;  
 *       special case). The drop from {@value #TOTAL_DAYS} to 1 is direct proof pruning happened.</li>
            CompositeDataFormatPlugin.class,
    public void testUpperBoundWindowKeepsOlderDays() throws Exception {  
 *
 * The OpenSearch Contributors require contributions made to  
        try {
            .putList("index.composite.secondary_data_formats")
            assertTrue("index creation must be acknowledged", response.isAcknowledged());
                    .setSource(
            assertEquals("only days 10–11 fall inside the bounded window", 2, dispatches.get());
import org.opensearch.ppl.action.PPLResponse;
        }
            .build();
     * A window entirely after all data ({@code @timestamp >= '2026-08-01'}) — every day is provably  
    @Override  
        ensureGreen();  
    /**  
import org.opensearch.transport.TransportService;
import java.util.Locale;
            // CanMatchTriggerTests.
     */
 *
            "1.8",  
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
import org.opensearch.analytics.AnalyticsPlugin;  
import org.opensearch.common.util.FeatureFlags;
        for (int day = FIRST_DAY; day <= LAST_DAY; day++) {
                "source = " + indices + " | where `@timestamp` >= '2026-07-10 00:00:00' and `@timestamp` <= '2026-07-11 23:59:59' | fields host"  
            }  
    public void testTrailingWindowKeepsRecentDays() throws Exception {
}  
        return Settings.builder()
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
    /**  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
        AtomicInteger dispatches = countFragmentDispatches();
        return commaList.toString();  
            assertEquals("all docs returned", TOTAL_DAYS * DOCS_PER_DAY, response.getRows().size());
 * a single shard so day ↔ shard is 1:1 and every doc in an index falls entirely within that day.  
import java.util.Collections;
 *  
            Version.CURRENT,
            MockTransportService.TestPlugin.class,  
    private static final String DAY_INDEX_PREFIX = "logs-parquet-2026-07-";  
import org.opensearch.composite.CompositeDataFormatPlugin;  
 * this file be licensed under the Apache-2.0 license or a
    /** Installs a counting behavior for {@link FragmentExecutionAction} on every data node. */
            pluginClass.getName(),
    public void testNoDateFilterScansEveryDay() throws Exception {
 * bounded window — sorted by time. Can-match inspects each shard's parquet row-group min/max for  
                commaList.append(',');
            );
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
/**
    /**  
        }  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
import org.opensearch.test.transport.MockTransportService;
        } finally {
        AtomicInteger dispatches = countFragmentDispatches();
    private String createDailyIndices() throws Exception {  
    private static final int DOCS_PER_DAY = 5;
    public void testWindowBeyondAllDaysPrunesToSingleShard() throws Exception {  
     * overlaps, so none is pruned and all run. Brackets the prune-everything case: can-match prunes
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
        try {  
     * Creates {@link #TOTAL_DAYS} single-shard parquet indices, one per day
 *
            client().admin().indices().prepareFlush(index).get();
            extendedPlugins,  
        StringBuilder commaList = new StringBuilder();
 * the returned row count (= surviving days × {@value #DOCS_PER_DAY}). The cases span the matrix:  
        }
        try {  
     */
                "source = " + indices + " | where `@timestamp` <= '2026-07-09 23:59:59' | fields host"  
    /**
     * exactly when a day is disjoint from the window, never otherwise.  
    protected Collection<PluginInfo> additionalNodePlugins() {  
 */  
            pluginClass.getName(),
            PPLResponse response = executePPL(
        String indices = createDailyIndices();  
 * wildcard would instead take the legacy push-down path and bypass can-match, and SQL {@code FROM  
            // not the fan-out heuristic that decides when to pay for it — that lives in
 * hundreds of cold daily shards and touching only the handful the window overlaps.  
        } finally {
import org.opensearch.cluster.metadata.IndexMetadata;  
            "classpath plugin",  
 * <p>Fragment dispatches are counted by intercepting {@link FragmentExecutionAction} on each data  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        );
 * node with a {@link MockTransportService} — fragment execution runs only on shards that survived
                // secondary format — parquet columnar storage covers it on its own.
            null,
     * a multi-index PPL {@code source =} clause.
            // production trigger, so force the phase on. What is under test is the pruning itself,  
     * lower-bound query. Days 08–12 lie below the cutoff and prune; days 13 and 14 survive. Exactly
public class CanMatchPruningIT extends OpenSearchIntegTestCase {  
        try {  
        } finally {  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
            );
        return counter;  
                // host is index=false so a keyword field doesn't require the FULL_TEXT_SEARCH (lucene)  
    }
     * exactly 1 fragment dispatches (down from {@link #TOTAL_DAYS}) and the result is empty — the  
     * A bounded window ({@code 2026-07-10 .. 2026-07-11}) — the flagship "last 24h" dashboard shape,
 *   <li><b>Bounded window</b> (the dashboard "last 24h" shape) — days on both sides of the window
            }  
 * those shards never run a fragment. On a real deployment this is the difference between waking
     * A bounded window that spans the whole week ({@code 2026-07-01 .. 2026-07-31}) — every day
     */
    }
    }
            PPLResponse response = executePPL("source = " + indices + " | fields host");
            assertEquals("no window → every day runs", TOTAL_DAYS, dispatches.get());
    /**
        }  
            assertEquals("only the two surviving days' docs return", 2 * DOCS_PER_DAY, response.getRows().size());
     */
                    )
        String indices = createDailyIndices();
            assertEquals("only the two surviving days' docs return", 2 * DOCS_PER_DAY, response.getRows().size());  
    }  
    @Override
            .put(FeatureFlags.STREAM_TRANSPORT, true)
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            assertEquals("only the two surviving days' docs return", 2 * DOCS_PER_DAY, response.getRows().size());  
        }
    public void testWindowCoveringEveryDayScansEveryDay() throws Exception {
                .prepareCreate(index)
 * {@code @timestamp} and prunes the days whose range is provably disjoint from the query window, so
import org.opensearch.common.settings.Settings;
            false
     * just a one-sided cutoff.
            clearTransportRules();
        AtomicInteger dispatches = countFragmentDispatches();
package org.opensearch.analytics.canmatch;
import org.opensearch.plugins.PluginInfo;
                .indices()  
        } finally {
     * A trailing "last 2 days" window ({@code @timestamp >= '2026-07-13'}) — the classic dashboard
                        "host-" + day + "-" + i  
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
     * 2 fragments dispatch and only those two days' docs come back.  
            "NA",
            .put(super.nodeSettings(nodeOrdinal))
        String indices = createDailyIndices();
        AtomicInteger dispatches = countFragmentDispatches();  
import org.opensearch.ppl.TestPPLPlugin;
    }
 * </ul>
            assertEquals("window covers every day → nothing pruned", TOTAL_DAYS, dispatches.get());
                .setSettings(settings)
                PPLResponse response = executePPL("source = " + index + " | fields host");
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
    private PPLResponse executePPL(String ppl) {  
            .put("index.composite.primary_data_format", "parquet")  
     * An upper-bound "before" window ({@code @timestamp <= '2026-07-09 23:59:59'}) — days 10–14 lie  
            clearTransportRules();
    public void testBoundedWindowKeepsOnlyDaysInRange() throws Exception {  
 * a,b,c} is a cross-join — so the PPL comma-list is the faithful way to drive this path.
     */
        String indices = createDailyIndices();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * (above) prune; only days 10 and 11 survive. Proves can-match applies both bounds at once, not  
            CreateIndexResponse response = client().admin()
        }  
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
     */
            );  
            .put(AnalyticsQuerySettings.PRE_FILTER_SHARD_SIZE.getKey(), 1)  
    }
        try {
     * above the cutoff and prune; days 08 and 09 survive. Mirror image of the trailing window.
        AtomicInteger counter = new AtomicInteger();
 */
    private void clearTransportRules() {  
            client().admin().indices().prepareRefresh(index).get();
 * independent of routing. Each test asserts both the fragment-dispatch count (= surviving days) and
            commaList.append(index);
            // These cases prune on filters alone, and a week of daily indices is far below the
     * produces a valid (empty) result envelope, mirroring vanilla's all-pruned special case. So
            assertEquals("only days 08–09 survive the upper-bound window", 2, dispatches.get());
            ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();
import org.opensearch.test.OpenSearchIntegTestCase;  
        Settings settings = Settings.builder()
import org.opensearch.ppl.action.PPLRequest;  
        String indices = createDailyIndices();
        // Wait until every shard has its documents committed and visible before querying.
            TestPPLPlugin.class,
            MockCommitterEnginePlugin.class
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
                        String.format(Locale.ROOT, "2026-07-%02dT%02d:00:00Z", day, i),
     * No range predicate → nothing is extractable, so can-match is skipped and every day's shard
        return new PluginInfo(
     * ({@value #DAY_INDEX_PREFIX}{@code 08 .. 14}), each seeded with {@link #DOCS_PER_DAY} docs whose
            .put("index.pluggable.dataformat.enabled", true)
 * analytics scenario: a {@code logs} stream rolls over into one dated index per day, and a
        );
        return List.of(
        AtomicInteger dispatches = countFragmentDispatches();  
    protected Settings nodeSettings(int nodeOrdinal) {  
        }
     */
 *   <li><b>Trailing / lower-bound window</b> ("last N days") — older days prune, recent survive.</li>  
            PPLResponse response = executePPL(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
 * SPDX-License-Identifier: Apache-2.0
        }  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
                .setMapping("@timestamp", "type=date", "host", "type=keyword,index=false")
/*  
import java.util.Collection;
            PPLResponse response = executePPL(
                assertEquals("index " + index + " must have " + DOCS_PER_DAY + " visible docs", DOCS_PER_DAY, response.getRows().size());  
            assertEquals("only days 13–14 survive the trailing window", 2, dispatches.get());
                client().prepareIndex(index)
    /**  
 * scan that routes through the distributed analytics engine where can-match runs. A {@code logs-*}
     * disjoint. Can-match prunes all but one: it force-keeps a single shard so the query still
