 *       delaying one shard far longer than the query is allowed to take and asserting the query
 * scanned to exhaustion.
        createAndSeedIndex();
            .put("index.pluggable.dataformat.enabled", true)
            BulkResponse r = bulk.get();
import java.util.concurrent.TimeUnit;  
        return new PluginInfo(
     * only learns the LIMIT is satisfied on its next feed — so equally-fast shards finish before
        });
import org.opensearch.ppl.TestPPLPlugin;  
    // Number of distinct groups; group k gets (k+1) docs so counts are all distinct and the  
        int cIdx = response.getColumns().indexOf("c");
                    + SLOW_SHARD_DELAY.millis()  
import org.opensearch.action.bulk.BulkRequestBuilder;
        for (int i = 0; i < LARGE_TOTAL_DOCS; i++) {
            bulk.add(client().prepareIndex(LARGE_INDEX).setSource("category", "c" + (i % 100), "value", i));  
import org.opensearch.common.unit.TimeValue;
                .setSettings(indexSettings)  
     */
            for (int d = 0; d <= g; d++) {
import java.util.Collection;  
                bulk = client().prepareBulk();
        client().admin().indices().prepareRefresh(LARGE_INDEX).get();  
        assertTrue(
 * coordinator's LIMIT is satisfied, the upstream shard streams are cancelled rather than
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;  
            false
 * The OpenSearch Contributors require contributions made to  
    }  
import java.util.List;
        // Delay one shard far past the assertion window — if the query blocks on it, it can't  
    }
        ensureGreen(INDEX);
/**
                    bulk = client().prepareBulk();
            ArrowBasePlugin.class,
import org.opensearch.composite.CompositeDataFormatPlugin;
        }
        assertEquals("top group must be g11 with count 12", 12L, ((Number) response.getRows().get(0)[cIdx]).longValue());
            // for the delayed shard. (We don't assert the [early-term] cancel log: that line only
            "source = " + INDEX + " | stats count() as c by category | sort - c | head " + n
                .get()
import org.opensearch.plugins.PluginInfo;
 * feed, so with equally fast shards both finish before the LIMIT is hit and there is nothing to
/*  
            try {
     * reduce-input early termination (the {@code LimitExec} satisfies its fetch and drops the input  
                elapsedMs < SLOW_SHARD_DELAY.millis()
        final int n = 5;  
            client().admin()  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)  
            String cat = String.valueOf(row[catIdx]);  
        Settings indexSettings = Settings.builder()
    @Override
        }  
        int pending = 0;
                .indices()
import org.opensearch.ppl.action.PPLResponse;
            }  
            // fires when the limit is satisfied mid-stream with a batch still pending, which depends
            pluginClass.getName(),  
            // the fast shard and the reduce stopped pulling, so the query returned without waiting  
                .indices()
            .build();  
import org.opensearch.transport.TransportService;
 * observe. The skew in the second test is what makes it observable.
            "1.8",
     * fast shard to satisfy the LIMIT first, dropping the receiver. Asserts: {@code head 5}  
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(query)).actionGet();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    + "ms, slow-shard delay="
        );  
import org.opensearch.plugins.Plugin;
            // Liveness IS the proof of reduce-input early termination: the LIMIT was satisfied from
        Settings indexSettings = Settings.builder()
            logger.info("[early-term] head 5 under shard skew returned in {}ms (slow-shard delay={}ms)", elapsedMs, SLOW_SHARD_DELAY.millis());
            assertEquals("group " + cat + " must have count " + (g + 1), (long) (g + 1), c);  
            String cat = String.format(java.util.Locale.ROOT, "g%02d", g);
import org.opensearch.test.transport.MockTransportService;  
import org.opensearch.test.MockLogAppender;
    private static final TimeValue SLOW_SHARD_DELAY = TimeValue.timeValueSeconds(10);
 */  
            "NA",
            .put("index.composite.primary_data_format", "parquet")
        if (pending > 0) {
            Version.CURRENT,  
        );  
            } catch (InterruptedException ie) {
            extendedPlugins,
    private static final int NUM_GROUPS = 12;
                .setSettings(indexSettings)  
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);  
            .put("index.pluggable.dataformat.enabled", true)
        int pending = 0;
            long c = ((Number) row[cIdx]).longValue();
}  
            .build();  
        long prev = Long.MAX_VALUE;  
                .isAcknowledged()  
 * Reduce-input early termination on a real multi-shard {@code head N} query: once the  
    @AwaitsFix(bugUrl = "thread leak")
 *
        }
    public void testStatsSortHeadAcrossShardsReturnsCorrectTopN() throws Exception {  
     */
    }
        ensureGreen(LARGE_INDEX);
            assertFalse("bulk ingest must not error", r.hasFailures());
                pending = 0;
public class ReduceEarlyTerminationIT extends OpenSearchIntegTestCase {
        BulkRequestBuilder bulk = client().prepareBulk();  
            assertTrue(
     * places a LIMIT above a coordinator DataFusion reduce, i.e. the query that SHOULD trigger
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
            null,  
    @Override  
        assertEquals("top-" + n + " must return exactly " + n + " rows", n, response.getRows().size());
    protected Collection<PluginInfo> additionalNodePlugins() {
    }
import org.opensearch.be.datafusion.DataFusionPlugin;
            .put("index.composite.primary_data_format", "parquet")
        }
     * Reduce-input early termination under shard skew. Early termination is reactive — a shard  
        createAndSeedLargeIndex();
    }
     * the stream — which only happens once {@code df_sender_send} surfaces {@code RECEIVER_DROPPED}).  
 *   <li>{@link #testHeadLimitTerminatesEarlyUnderShardSkew} — early termination itself, proven by
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)  
            );  
     * groups. It does NOT yet assert that early termination fired (no {@code [early-term]} log
        assertTrue(
 * this file be licensed under the Apache-2.0 license or a
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        );
 * <p>Early termination is <b>reactive</b>: a shard only learns the receiver was dropped on its next  
 * <p>Two tests cover the two halves:
    }
     * expectation): the planner currently does not produce a plan that lets the LIMIT terminate the
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            int g = Integer.parseInt(cat.substring(1));
    }
        for (int i = 0; i < n; i++) {
            "classpath plugin",
 *  
    public void testHeadLimitTerminatesEarlyUnderShardSkew() throws Exception {  
                .setMapping("category", "type=keyword,index=false", "value", "type=integer")
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
 */  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
        return List.of(  
    // top-N ordering is deterministic regardless of shard placement.
            MockCommitterEnginePlugin.class
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),  
            PPLResponse response = executePPL("source = " + LARGE_INDEX + " | head 5");  
        }  
                .get()
            .put("index.pluggable.dataformat", "composite")  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;  
        } finally {
 * compatible open source license.
        // Groups g11..g07 have the 5 largest counts (12,11,10,9,8). sort - c → descending by count.
import org.opensearch.test.OpenSearchIntegTestCase;
 *   <li>{@link #testStatsSortHeadAcrossShardsReturnsCorrectTopN} — correctness of the top-N shape.</li>  
import org.opensearch.analytics.AnalyticsPlugin;
    private static final int NUM_SHARDS = 2;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            handler.messageReceived(request, channel, task);
import org.opensearch.cluster.metadata.IndexMetadata;  
                Thread.sleep(SLOW_SHARD_DELAY.millis());  
            mts.clearAllRules();
            }  
        int catIdx = response.getColumns().indexOf("category");
            long startNanos = System.nanoTime();
            CompositeDataFormatPlugin.class,  
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
     * A {@code stats count() by category | sort - c | head N} query across 2 shards — the shape that
            if (++pending == 2000) {
            TestPPLPlugin.class,
                    + elapsedMs
            .putList("index.composite.secondary_data_formats")
     * returns exactly 5 rows; the query returns well under the slow-shard delay (didn't block on
package org.opensearch.analytics.resilience;
            .build();  
    private static final String LARGE_INDEX = "early_term_large_idx";  
 *       still returns the right rows, fast, without blocking on the slow shard.</li>  
    }
        if (pending > 0) {  
        PPLResponse response = executePPL(
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                "query must return without waiting for the slow shard (early-term); elapsed="  
import org.opensearch.ppl.action.PPLRequest;
            .put("index.pluggable.dataformat", "composite")  
import org.opensearch.action.bulk.BulkResponse;  
            Object[] row = response.getRows().get(i);
    /**
        return List.of(
            assertTrue("counts must be in descending order (early-term-eligible top-N)", c <= prev);
        );
import org.opensearch.common.util.FeatureFlags;  
            pluginClass.getName(),
            // check below is the robust, routing-independent signal.)
                .prepareCreate(LARGE_INDEX)
                    BulkResponse r = bulk.get();
                .prepareCreate(INDEX)
    protected Settings nodeSettings(int nodeOrdinal) {
        );  
            // on shard routing / batch count for a given seed and is therefore flaky. The latency  
                }  
            }
                if (++pending == 1000) {
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
     * reduce input early (tracked separately). When that lands, add a {@link MockLogAppender}  
 * <ul>
import java.util.Collections;
 * </ul>
    private PPLResponse executePPL(String query) {
            .putList("index.composite.secondary_data_formats")
            assertFalse("bulk ingest must not error", r.hasFailures());
                assertFalse("bulk ingest must not error", r.hasFailures());  
    private void createAndSeedIndex() throws Exception {
    private static final int LARGE_TOTAL_DOCS = 20_000;
        // finish in time.
            prev = c;
                bulk.add(client().prepareIndex(INDEX).setSource("category", cat, "value", g));  
import org.opensearch.Version;
            assertEquals("head 5 must return exactly 5 rows even with one shard delayed", 5, response.getRows().size());  
 * SPDX-License-Identifier: Apache-2.0
                    pending = 0;
                BulkResponse r = bulk.get();
                    assertFalse("bulk ingest must not error", r.hasFailures());  
     * there's anything to observe. Delaying one shard far past the assertion window forces the
     *
        return Settings.builder()
    /**  
        assertTrue("response must carry 'category' and 'c' columns: " + response.getColumns(), catIdx >= 0 && cIdx >= 0);  
     * <p>For now this asserts only correctness — the query succeeds and returns the right top-N  
        try {
        String victim = randomFrom(internalCluster().getDataNodeNames());
import org.opensearch.common.settings.Settings;
     * it); and the {@code [early-term] cancelling shard stream} log fired (the engine cancelled
        executePPL("source = " + LARGE_INDEX + " | stats count() as c");
                .isAcknowledged()  
                Thread.currentThread().interrupt();
                .setMapping("category", "type=keyword,index=false", "value", "type=integer")
        // The largest group (g11=12) must be first.
            MockTransportService.TestPlugin.class,
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))  
    @Override  
            BulkResponse r = bulk.get();  
            long elapsedMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        // group g ("g00".."g11") gets (g+1) docs.
 *
            client().admin()  
    }  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
     * expectation on {@code [early-term] consumer satisfied} from {@code AnalyticsSearchTransportService}.
            .put(super.nodeSettings(nodeOrdinal))  
        }  
        client().admin().indices().prepareRefresh(INDEX).get();
     * receiver) once the planner sort/limit wiring supports it.
    private void createAndSeedLargeIndex() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    private static final String INDEX = "early_term_idx";
        // Force the parquet commit to be visible to the analytics path before measuring.  
                    + "ms",
        for (int g = 0; g < NUM_GROUPS; g++) {  
        );
        BulkRequestBuilder bulk = client().prepareBulk();  
