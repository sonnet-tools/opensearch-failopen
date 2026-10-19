            assertFalse("bulk ingest must not error", r.hasFailures());
    private void createAndSeedLargeIndex() throws Exception {
            // for the delayed shard. (We don't assert the [early-term] cancel log: that line only
                .setMapping("category", "type=keyword,index=false", "value", "type=integer")
                Thread.sleep(SLOW_SHARD_DELAY.millis());
            }
            CompositeDataFormatPlugin.class,
        int pending = 0;
    private PPLResponse executePPL(String query) {
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        createAndSeedIndex();
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            "NA",
                    assertFalse("bulk ingest must not error", r.hasFailures());
 * <p>Early termination is <b>reactive</b>: a shard only learns the receiver was dropped on its next
    // top-N ordering is deterministic regardless of shard placement.
            "classpath plugin",
import org.opensearch.be.datafusion.DataFusionPlugin;
        for (int i = 0; i < n; i++) {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
    private void createAndSeedIndex() throws Exception {
     * it); and the {@code [early-term] cancelling shard stream} log fired (the engine cancelled
}
                    + "ms",
package org.opensearch.analytics.resilience;
            // check below is the robust, routing-independent signal.)
        if (pending > 0) {
                .indices()
        );
        }
 *   <li>{@link #testStatsSortHeadAcrossShardsReturnsCorrectTopN} — correctness of the top-N shape.</li>
            .build();
            long startNanos = System.nanoTime();
        // finish in time.
                    + elapsedMs
 *
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        assertTrue(
        int catIdx = response.getColumns().indexOf("category");
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
        int pending = 0;
        // Force the parquet commit to be visible to the analytics path before measuring.
    private static final TimeValue SLOW_SHARD_DELAY = TimeValue.timeValueSeconds(10);
 * SPDX-License-Identifier: Apache-2.0
            .build();
     *
 * </ul>
        Settings indexSettings = Settings.builder()
     * expectation): the planner currently does not produce a plan that lets the LIMIT terminate the
        // The largest group (g11=12) must be first.
            long c = ((Number) row[cIdx]).longValue();
 *   <li>{@link #testHeadLimitTerminatesEarlyUnderShardSkew} — early termination itself, proven by
import org.opensearch.test.MockLogAppender;
     * the stream — which only happens once {@code df_sender_send} surfaces {@code RECEIVER_DROPPED}).
import org.opensearch.Version;
            pluginClass.getName(),
        createAndSeedLargeIndex();
public class ReduceEarlyTerminationIT extends OpenSearchIntegTestCase {
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
            MockTransportService.TestPlugin.class,
                bulk.add(client().prepareIndex(INDEX).setSource("category", cat, "value", g));
                assertFalse("bulk ingest must not error", r.hasFailures());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.common.settings.Settings;
            .put("index.pluggable.dataformat", "composite")
                .get()
import java.util.Collection;
            .put("index.pluggable.dataformat", "composite")
 * Reduce-input early termination on a real multi-shard {@code head N} query: once the
 * coordinator's LIMIT is satisfied, the upstream shard streams are cancelled rather than
        final int n = 5;
import org.opensearch.plugins.PluginInfo;
        BulkRequestBuilder bulk = client().prepareBulk();
 * compatible open source license.
            // Liveness IS the proof of reduce-input early termination: the LIMIT was satisfied from
        for (int g = 0; g < NUM_GROUPS; g++) {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        if (pending > 0) {
 * observe. The skew in the second test is what makes it observable.
 */
        return List.of(
    }
     * Reduce-input early termination under shard skew. Early termination is reactive — a shard
     * receiver) once the planner sort/limit wiring supports it.
    }
                if (++pending == 1000) {
import org.opensearch.plugins.Plugin;
 *       delaying one shard far longer than the query is allowed to take and asserting the query
        client().admin().indices().prepareRefresh(LARGE_INDEX).get();
    @AwaitsFix(bugUrl = "thread leak")
     * places a LIMIT above a coordinator DataFusion reduce, i.e. the query that SHOULD trigger
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            bulk.add(client().prepareIndex(LARGE_INDEX).setSource("category", "c" + (i % 100), "value", i));
        ensureGreen(INDEX);
        long prev = Long.MAX_VALUE;
                "query must return without waiting for the slow shard (early-term); elapsed="
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        });
            for (int d = 0; d <= g; d++) {
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
                .setSettings(indexSettings)
            .put("index.composite.primary_data_format", "parquet")
            "source = " + INDEX + " | stats count() as c by category | sort - c | head " + n
        }
                    + "ms, slow-shard delay="
            } catch (InterruptedException ie) {
    }
    }
 *
    }
import org.opensearch.ppl.TestPPLPlugin;
        assertEquals("top group must be g11 with count 12", 12L, ((Number) response.getRows().get(0)[cIdx]).longValue());
        assertTrue(
    private static final int LARGE_TOTAL_DOCS = 20_000;
            .putList("index.composite.secondary_data_formats")
            extendedPlugins,
import org.opensearch.action.bulk.BulkResponse;
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
     */
            assertEquals("group " + cat + " must have count " + (g + 1), (long) (g + 1), c);
        return List.of(
            .put("index.composite.primary_data_format", "parquet")
import org.opensearch.ppl.action.PPLResponse;
            );
    }
            long elapsedMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(query)).actionGet();
 * this file be licensed under the Apache-2.0 license or a
                .prepareCreate(INDEX)
            Version.CURRENT,
    private static final String INDEX = "early_term_idx";
            logger.info("[early-term] head 5 under shard skew returned in {}ms (slow-shard delay={}ms)", elapsedMs, SLOW_SHARD_DELAY.millis());
                .setSettings(indexSettings)
        ensureGreen(LARGE_INDEX);
 * scanned to exhaustion.
            // the fast shard and the reduce stopped pulling, so the query returned without waiting
        assertTrue("response must carry 'category' and 'c' columns: " + response.getColumns(), catIdx >= 0 && cIdx >= 0);
            ArrowBasePlugin.class,
        client().admin().indices().prepareRefresh(INDEX).get();
            PPLResponse response = executePPL("source = " + LARGE_INDEX + " | head 5");
        }
    @Override
        // Delay one shard far past the assertion window — if the query blocks on it, it can't
            pluginClass.getName(),
                .isAcknowledged()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        assertEquals("top-" + n + " must return exactly " + n + " rows", n, response.getRows().size());
                .setMapping("category", "type=keyword,index=false", "value", "type=integer")
            try {
    /**
            client().admin()
                    + SLOW_SHARD_DELAY.millis()
            handler.messageReceived(request, channel, task);
        );
                    BulkResponse r = bulk.get();
                    bulk = client().prepareBulk();
/**
            mts.clearAllRules();
     * A {@code stats count() by category | sort - c | head N} query across 2 shards — the shape that
 * The OpenSearch Contributors require contributions made to
     * reduce input early (tracked separately). When that lands, add a {@link MockLogAppender}
            BulkResponse r = bulk.get();
import org.opensearch.analytics.AnalyticsPlugin;
import org.opensearch.composite.CompositeDataFormatPlugin;
        PPLResponse response = executePPL(
                bulk = client().prepareBulk();
     * returns exactly 5 rows; the query returns well under the slow-shard delay (didn't block on
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
import org.opensearch.test.OpenSearchIntegTestCase;
 * feed, so with equally fast shards both finish before the LIMIT is hit and there is nothing to
            assertEquals("head 5 must return exactly 5 rows even with one shard delayed", 5, response.getRows().size());
 *
 * <ul>
            false
            .build();
        }
                .indices()
            TestPPLPlugin.class,
    }
        String victim = randomFrom(internalCluster().getDataNodeNames());
    public void testHeadLimitTerminatesEarlyUnderShardSkew() throws Exception {
            "1.8",
            // fires when the limit is satisfied mid-stream with a batch still pending, which depends
        );
            assertTrue("counts must be in descending order (early-term-eligible top-N)", c <= prev);
 *       still returns the right rows, fast, without blocking on the slow shard.</li>
                elapsedMs < SLOW_SHARD_DELAY.millis()
    // Number of distinct groups; group k gets (k+1) docs so counts are all distinct and the
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put(super.nodeSettings(nodeOrdinal))
     */
import java.util.List;
import java.util.concurrent.TimeUnit;
    protected Settings nodeSettings(int nodeOrdinal) {
            }
            .putList("index.composite.secondary_data_formats")
import org.opensearch.cluster.metadata.IndexMetadata;
            null,
    private static final String LARGE_INDEX = "early_term_large_idx";
import java.util.Collections;
     * fast shard to satisfy the LIMIT first, dropping the receiver. Asserts: {@code head 5}
            Object[] row = response.getRows().get(i);
     * expectation on {@code [early-term] consumer satisfied} from {@code AnalyticsSearchTransportService}.
    private static final int NUM_SHARDS = 2;
import org.opensearch.common.util.FeatureFlags;
            String cat = String.valueOf(row[catIdx]);
        // group g ("g00".."g11") gets (g+1) docs.
            assertTrue(
            prev = c;
 * <p>Two tests cover the two halves:
            client().admin()
                }
    }
        return Settings.builder()
                Thread.currentThread().interrupt();
        // Groups g11..g07 have the 5 largest counts (12,11,10,9,8). sort - c → descending by count.
        }
     * groups. It does NOT yet assert that early termination fired (no {@code [early-term]} log
import org.opensearch.common.unit.TimeValue;
                pending = 0;
    @Override
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            BulkResponse r = bulk.get();
            // on shard routing / batch count for a given seed and is therefore flaky. The latency
        } finally {
            MockCommitterEnginePlugin.class
                .get()
        Settings indexSettings = Settings.builder()
 */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            String cat = String.format(java.util.Locale.ROOT, "g%02d", g);
            .put("index.pluggable.dataformat.enabled", true)
            int g = Integer.parseInt(cat.substring(1));
        }
                BulkResponse r = bulk.get();
            }
    /**
        );
/*
        );
                .prepareCreate(LARGE_INDEX)
            .put("index.pluggable.dataformat.enabled", true)
    public void testStatsSortHeadAcrossShardsReturnsCorrectTopN() throws Exception {
    private static final int NUM_GROUPS = 12;
                .isAcknowledged()
                    pending = 0;
    @Override
     * there's anything to observe. Delaying one shard far past the assertion window forces the
    protected Collection<PluginInfo> additionalNodePlugins() {
    }
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
     * reduce-input early termination (the {@code LimitExec} satisfies its fetch and drops the input
        for (int i = 0; i < LARGE_TOTAL_DOCS; i++) {
        executePPL("source = " + LARGE_INDEX + " | stats count() as c");
        BulkRequestBuilder bulk = client().prepareBulk();
     * <p>For now this asserts only correctness — the query succeeds and returns the right top-N
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
        return new PluginInfo(
import org.opensearch.transport.TransportService;
import org.opensearch.test.transport.MockTransportService;
        try {
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            assertFalse("bulk ingest must not error", r.hasFailures());
     * only learns the LIMIT is satisfied on its next feed — so equally-fast shards finish before
import org.opensearch.ppl.action.PPLRequest;
            if (++pending == 2000) {
        int cIdx = response.getColumns().indexOf("c");
import org.opensearch.action.bulk.BulkRequestBuilder;
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
