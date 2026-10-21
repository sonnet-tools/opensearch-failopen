            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();
     * (above) prune; only days 10 and 11 survive. Proves can-match applies both bounds at once, not
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import java.util.concurrent.TimeUnit;
        try {
            .build();
    }
                    .get();
            "1.8",
 * <p>Indices are addressed as a PPL comma-list ({@code source = a,b,c}), a native multi-index union
     * 2 fragments dispatch and only those two days' docs come back.
     * A bounded window that spans the whole week ({@code 2026-07-01 .. 2026-07-31}) — every day
     * runs. Guards against the extractor over-reaching and pruning when there is no window.
    private void clearTransportRules() {
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                client().prepareIndex(index)
        // Wait until every shard has its documents committed and visible before querying.
    public void testTrailingWindowKeepsRecentDays() throws Exception {
                handler.messageReceived(request, channel, task);
            .put("index.composite.primary_data_format", "parquet")
    }
            .put("index.pluggable.dataformat", "composite")
            client().admin().indices().prepareFlush(index).get();
            assertTrue("index creation must be acknowledged", response.isAcknowledged());
 *   <li><b>Bounded window</b> (the dashboard "last 24h" shape) — days on both sides of the window
        }
     */
                .prepareCreate(index)
            PPLResponse response = executePPL(
    protected Collection<PluginInfo> additionalNodePlugins() {
    @Override
            // These cases prune on filters alone, and a week of daily indices is far below the
        return List.of(
        AtomicInteger dispatches = countFragmentDispatches();
        String indices = createDailyIndices();
 * independent of routing. Each test asserts both the fragment-dispatch count (= surviving days) and
        }
     * above the cutoff and prune; days 08 and 09 survive. Mirror image of the trailing window.
    }
 * the returned row count (= surviving days × {@value #DOCS_PER_DAY}). The cases span the matrix:
            );
            CompositeDataFormatPlugin.class,
    private static final int TOTAL_DAYS = 7;
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
 * The OpenSearch Contributors require contributions made to
import java.util.Collections;
                "source = " + indices + " | where `@timestamp` >= '2026-08-01 00:00:00' | fields host"
 * dashboard issues a {@code range(@timestamp)} query — "last N days", "since T", "before T", or a
     * produces a valid (empty) result envelope, mirroring vanilla's all-pruned special case. So
    public void testWindowBeyondAllDaysPrunesToSingleShard() throws Exception {
     * a multi-index PPL {@code source =} clause.
            TestPPLPlugin.class,
            // not the fan-out heuristic that decides when to pay for it — that lives in
 * <ul>
        return new PluginInfo(
 * <p>The fixture is a week of daily indices ({@value #DAY_INDEX_PREFIX}{@code 08 .. 14}), each with
 *
    }
    protected Settings nodeSettings(int nodeOrdinal) {
        for (int day = FIRST_DAY; day <= LAST_DAY; day++) {
package org.opensearch.analytics.canmatch;
            // CanMatchTriggerTests.
 *   <li><b>No filter / covering window</b> — nothing disjoint → every day runs. Guards over-pruning.</li>
            .put(FeatureFlags.STREAM_TRANSPORT, true)
    public void testNoDateFilterScansEveryDay() throws Exception {
            assertEquals("only days 08–09 survive the upper-bound window", 2, dispatches.get());
            assertTrue("no rows should match a window past all data", response.getRows().isEmpty());
    private static final String DAY_INDEX_PREFIX = "logs-parquet-2026-07-";
            assertEquals("window covers every day → nothing pruned", TOTAL_DAYS, dispatches.get());
     */
        }
                // secondary format — parquet columnar storage covers it on its own.
    }
     * ({@value #DAY_INDEX_PREFIX}{@code 08 .. 14}), each seeded with {@link #DOCS_PER_DAY} docs whose
import org.opensearch.arrow.allocator.ArrowBasePlugin;
 * bounded window — sorted by time. Can-match inspects each shard's parquet row-group min/max for
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
import java.util.Collection;
            commaList.append(index);
            MockCommitterEnginePlugin.class
 * </ul>
    }
            assertBusy(() -> {
            ArrowBasePlugin.class,
    }
    /**
import java.util.List;
 */
            assertEquals("only days 10–11 fall inside the bounded window", 2, dispatches.get());
                "source = " + indices + " | where `@timestamp` >= '2026-07-10 00:00:00' and `@timestamp` <= '2026-07-11 23:59:59' | fields host"
import org.opensearch.be.datafusion.DataFusionPlugin;
        AtomicInteger dispatches = countFragmentDispatches();
        String indices = createDailyIndices();
            client().admin().indices().prepareRefresh(index).get();
 * wildcard would instead take the legacy push-down path and bypass can-match, and SQL {@code FROM
            extendedPlugins,
import java.util.Locale;
import org.opensearch.plugins.Plugin;
 * hundreds of cold daily shards and touching only the handful the window overlaps.
        );
import org.opensearch.composite.CompositeDataFormatPlugin;
        String indices = createDailyIndices();
                assertEquals("index " + index + " must have " + DOCS_PER_DAY + " visible docs", DOCS_PER_DAY, response.getRows().size());
    }
                "source = " + indices + " | where `@timestamp` >= '2026-07-13 00:00:00' | fields host"
        } finally {
                .indices()
                // host is index=false so a keyword field doesn't require the FULL_TEXT_SEARCH (lucene)
                .setMapping("@timestamp", "type=date", "host", "type=keyword,index=false")
            );
            assertEquals("only the two surviving days' docs return", 2 * DOCS_PER_DAY, response.getRows().size());
            clearTransportRules();
        } finally {
            .putList("index.composite.secondary_data_formats")
            .put(super.nodeSettings(nodeOrdinal))
        AtomicInteger dispatches = countFragmentDispatches();
            // production trigger, so force the phase on. What is under test is the pruning itself,
            pluginClass.getName(),
 * <p>Fragment dispatches are counted by intercepting {@link FragmentExecutionAction} on each data
    /** Installs a counting behavior for {@link FragmentExecutionAction} on every data node. */
            assertEquals("all docs returned", TOTAL_DAYS * DOCS_PER_DAY, response.getRows().size());
import org.opensearch.test.transport.MockTransportService;
        } finally {
 * Integration test for the can-match pre-filter phase, modelling the flagship time-series / log
        return Settings.builder()
import org.opensearch.ppl.TestPPLPlugin;
            false
     * A bounded window ({@code 2026-07-10 .. 2026-07-11}) — the flagship "last 24h" dashboard shape,
 * compatible open source license.
     * exactly when a day is disjoint from the window, never otherwise.
            clearTransportRules();
            "NA",
 *       one shard so the query still yields a valid empty result (mirrors vanilla's all-pruned
            PPLResponse response = executePPL(
    private static final int LAST_DAY = FIRST_DAY + TOTAL_DAYS - 1; // 2026-07-14
            assertEquals("only the two surviving days' docs return", 2 * DOCS_PER_DAY, response.getRows().size());
import org.opensearch.plugins.PluginInfo;
        String indices = createDailyIndices();
            );
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
/**
    // A week of daily rollover: logs-parquet-2026-07-08 .. logs-parquet-2026-07-14, one shard each.
    public void testWindowCoveringEveryDayScansEveryDay() throws Exception {
                counter.incrementAndGet();
}
            .put(AnalyticsQuerySettings.PRE_FILTER_SHARD_SIZE.getKey(), 1)
                        "@timestamp",
            }
            clearTransportRules();
 * SPDX-License-Identifier: Apache-2.0
     */
        } finally {
 * a single shard so day ↔ shard is 1:1 and every doc in an index falls entirely within that day.
 *   <li><b>Upper-bound window</b> ("before T") — newer days prune, older survive.</li>
     * just a one-sided cutoff.
        }
        for (int day = FIRST_DAY; day <= LAST_DAY; day++) {
    // ── helpers ──────────────────────────────────────────────────────────
        } finally {
import org.opensearch.Version;
            assertEquals("no window → every day runs", TOTAL_DAYS, dispatches.get());
    /**
        try {
            PPLResponse response = executePPL(
    /**
            Version.CURRENT,
            });
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            clearTransportRules();
        return List.of(
    }
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
import org.opensearch.ppl.action.PPLRequest;
                PPLResponse response = executePPL("source = " + index + " | fields host");
     * exactly 1 fragment dispatches (down from {@link #TOTAL_DAYS}) and the result is empty — the
     * drop is the proof pruning happened; a broken build dispatches to every day.
            assertEquals("only the two surviving days' docs return", 2 * DOCS_PER_DAY, response.getRows().size());
        AtomicInteger counter = new AtomicInteger();
     */
        AtomicInteger dispatches = countFragmentDispatches();
        }
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
        String indices = createDailyIndices();
                        "host-" + day + "-" + i
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
import org.opensearch.common.util.FeatureFlags;
                        String.format(Locale.ROOT, "2026-07-%02dT%02d:00:00Z", day, i),
    @Override
        StringBuilder commaList = new StringBuilder();
    }
     * disjoint. Can-match prunes all but one: it force-keeps a single shard so the query still
        try {
        return commaList.toString();
            assertEquals("only days 13–14 survive the trailing window", 2, dispatches.get());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .build();
     * where days on <em>both</em> sides of the window must prune. Days 08–09 (below) and 12–14
     */
 * scan that routes through the distributed analytics engine where can-match runs. A {@code logs-*}
    private PPLResponse executePPL(String ppl) {
 *   <li><b>Window beyond all data</b> — every day disjoint → all pruned, but can-match force-keeps
        String indices = createDailyIndices();
     * A trailing "last 2 days" window ({@code @timestamp >= '2026-07-13'}) — the classic dashboard
        );
            CreateIndexResponse response = client().admin()
                .get();
 * analytics scenario: a {@code logs} stream rolls over into one dated index per day, and a
        try {
                    .setSource(
     */
     * No range predicate → nothing is extractable, so can-match is skipped and every day's shard
 * node with a {@link MockTransportService} — fragment execution runs only on shards that survived
import org.opensearch.cluster.metadata.IndexMetadata;
        }
        }
            );
    }
            );
 *       special case). The drop from {@value #TOTAL_DAYS} to 1 is direct proof pruning happened.</li>
 * {@code @timestamp} and prunes the days whose range is provably disjoint from the query window, so
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
    private static final int FIRST_DAY = 8;   // 2026-07-08
 * can-match, so the count equals the surviving-shard (= surviving-day) count.
import org.opensearch.transport.TransportService;
     * {@code @timestamp} falls entirely within that day. Returns the comma-separated index list for
            MockTransportService.TestPlugin.class,
    public void testUpperBoundWindowKeepsOlderDays() throws Exception {
     * lower-bound query. Days 08–12 lie below the cutoff and prune; days 13 and 14 survive. Exactly
        AtomicInteger dispatches = countFragmentDispatches();
            if (day > FIRST_DAY) {
import org.opensearch.analytics.AnalyticsPlugin;
            String index = String.format(Locale.ROOT, "%s%02d", DAY_INDEX_PREFIX, day);
import java.util.concurrent.atomic.AtomicInteger;
            "classpath plugin",
            assertEquals("all docs returned", TOTAL_DAYS * DOCS_PER_DAY, response.getRows().size());
 *
            clearTransportRules();
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen();
                "source = " + indices + " | where `@timestamp` >= '2026-07-01 00:00:00' and `@timestamp` <= '2026-07-31 23:59:59' | fields host"
/*
    }
     */
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        );
            }
import org.opensearch.ppl.action.PPLResponse;
    private static final int DOCS_PER_DAY = 5;
                .setSettings(settings)
            clearTransportRules();
                    )
            pluginClass.getName(),
            null,
            for (int i = 0; i < DOCS_PER_DAY; i++) {
 * a,b,c} is a cross-join — so the PPL comma-list is the faithful way to drive this path.
    /**
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    /**
        }
    public void testBoundedWindowKeepsOnlyDaysInRange() throws Exception {
                        "host",
 * those shards never run a fragment. On a real deployment this is the difference between waking
        return counter;
            PPLResponse response = executePPL(
        AtomicInteger dispatches = countFragmentDispatches();
     * An upper-bound "before" window ({@code @timestamp <= '2026-07-09 23:59:59'}) — days 10–14 lie
public class CanMatchPruningIT extends OpenSearchIntegTestCase {
 *
import org.opensearch.common.settings.Settings;
                "source = " + indices + " | where `@timestamp` <= '2026-07-09 23:59:59' | fields host"
 */
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
     * overlaps, so none is pruned and all run. Brackets the prune-everything case: can-match prunes
            .put("index.pluggable.dataformat.enabled", true)
 * @opensearch.internal
    @Override
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
            PPLResponse response = executePPL("source = " + indices + " | fields host");
        try {
        try {
    }
        for (String node : internalCluster().getDataNodeNames()) {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    /**
            PPLResponse response = executePPL(
        Settings settings = Settings.builder()
 *
 *       prune; only days inside survive.</li>
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
        for (String node : internalCluster().getDataNodeNames()) {
            String index = String.format(Locale.ROOT, "%s%02d", DAY_INDEX_PREFIX, day);
import org.opensearch.test.OpenSearchIntegTestCase;
            }, 30, TimeUnit.SECONDS);
    private AtomicInteger countFragmentDispatches() {
 * Pruning is therefore deterministic: a day is kept iff its date range overlaps the query window,
    }
     * A window entirely after all data ({@code @timestamp >= '2026-08-01'}) — every day is provably
 *
        } finally {
 *   <li><b>Trailing / lower-bound window</b> ("last N days") — older days prune, recent survive.</li>
     * Creates {@link #TOTAL_DAYS} single-shard parquet indices, one per day
        }
                commaList.append(',');
    private String createDailyIndices() throws Exception {
    /**
            assertEquals("all days pruned; one kept for a valid empty result", 1, dispatches.get());
