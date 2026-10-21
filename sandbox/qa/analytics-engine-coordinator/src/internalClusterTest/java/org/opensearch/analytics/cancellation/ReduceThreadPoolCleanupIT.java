    private void assertReducePoolDrains() throws Exception {
    protected Settings nodeSettings(int nodeOrdinal) {
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            false
    }
            exec.shutdownNow();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                cancel.getNodeFailures() != null && cancel.getNodeFailures().isEmpty() == false
     * from {@code analytics_reduce} must be returned — the pool drains to zero active.
        // (the reduce drain is parked waiting for this shard's input).
        return List.of(
import org.opensearch.threadpool.ThreadPool;
        } finally {
            }, 30, TimeUnit.SECONDS);
            extendedPlugins,
        ensureGreen(INDEX);
        long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();
 */
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            .put("index.pluggable.dataformat", "composite")
            released.countDown();
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
public class ReduceThreadPoolCleanupIT extends OpenSearchIntegTestCase {
import java.util.concurrent.CountDownLatch;
            mts.clearAllRules();
        CountDownLatch released = new CountDownLatch(1);
            handler.messageReceived(request, channel, task);
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
import java.util.concurrent.Future;
import org.opensearch.common.unit.TimeValue;
        CreateIndexResponse response = client().admin()
import org.opensearch.plugins.Plugin;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
import org.opensearch.ppl.TestPPLPlugin;
        }
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        }, 10, TimeUnit.SECONDS);
 */
        try {
 * the drain thread leaks: the pool's {@code active} count stays elevated and eventually the pool
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .build();
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(action).get();
            assertBusy(() -> {
     * and frees the pool thread. Without that, the parked drain leaks the thread permanently.
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(AnalyticsQueryAction.NAME).get();
    }
        for (ThreadPool tp : internalCluster().getInstances(ThreadPool.class)) {
            .get();
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;
import org.opensearch.test.transport.MockTransportService;
 * Verifies the coordinator-reduce thread pool ({@code analytics_reduce}) is released after a query
        });
            try {
            released.countDown();
 * saturates. These tests assert the pool drains back to {@code active=0} after each query, which
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
            "NA",
        int maxActive = 0;
            int active = reducePoolActiveAcrossNodes();
                assertFalse("analytics/query task should be running", live.getTasks().isEmpty());
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        return maxActive;
    private static final int VALUE = 7;
import org.opensearch.analytics.AnalyticsPlugin;
                if (AnalyticsPlugin.REDUCE_THREAD_POOL_NAME.equals(s.getName())) {
                    maxActive = Math.max(maxActive, s.getActive() + s.getQueue());
    }
        assertBusy(() -> {
        createAndSeedIndex();
        return Settings.builder()
import java.util.concurrent.Executors;
        Settings indexSettings = Settings.builder()
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.metadata.IndexMetadata;
        assertReducePoolDrains();
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
import org.opensearch.composite.CompositeDataFormatPlugin;
            pluginClass.getName(),
 * — both on the normal-completion path and the cancellation path.
import org.opensearch.Version;
                logger.info("query terminated as expected after cancel: {}", e.getMessage());
            assertEquals("analytics_reduce pool must drain to 0 active+queued; got " + active, 0, active);
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        assertEquals("query must return the correct sum", EXPECTED_SUM, actual);
     * Cancellation: a query cancelled while a shard handler is blocked must still release its reduce
            .put("index.pluggable.dataformat.enabled", true)
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            );
            "1.8",
            }, 10, TimeUnit.SECONDS);
                Thread.currentThread().interrupt();
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)
            pluginClass.getName(),
    private PPLResponse executePPL(String ppl, TimeValue timeout) {
            ArrowBasePlugin.class,
        return new PluginInfo(
    @Override
        assertNoResidualTasks(FragmentExecutionAction.NAME);
import org.apache.logging.log4j.Logger;
    protected Collection<PluginInfo> additionalNodePlugins() {
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);
            try {
                assertEquals("seed not yet visible", EXPECTED_SUM, actual);
    private int reducePoolActiveAcrossNodes() {
 * The OpenSearch Contributors require contributions made to
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
    }
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.common.util.FeatureFlags;
    }
    private static final Logger logger = LogManager.getLogger(ReduceThreadPoolCleanupIT.class);
    }
 * compatible open source license.
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;
        }, 30, TimeUnit.SECONDS);
 *
    }
        try {
        );
        String victim = randomFrom(internalCluster().getDataNodeNames());
            } catch (ExecutionException | TimeoutException e) {
 *
    private static final int DOCS_PER_SHARD = 50;
            "classpath plugin",
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");
    }
 * SPDX-License-Identifier: Apache-2.0
     */
        return List.of(
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
        ExecutorService exec = Executors.newSingleThreadExecutor();
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                "cancel must not report node failures",
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
 * this file be licensed under the Apache-2.0 license or a
    private PPLResponse executePPL(String ppl) {
    }
}
    public void testReducePoolReleasedAfterCancelledQuery() throws Exception {
    }
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
        assertReducePoolDrains();
    private void createAndSeedIndex() {
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
import java.util.Collection;
    private static final int NUM_SHARDS = 2;
 * stage). If {@code DatafusionReduceSink.reduce} fails to unwind on cancellation (the drain parks
import java.util.concurrent.TimeoutException;
            .prepareCreate(INDEX)
import java.util.Collections;
import org.opensearch.common.settings.Settings;
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            .setSettings(indexSettings)
import java.util.concurrent.ExecutionException;
     */
            MockTransportService.TestPlugin.class,
            throw new AssertionError("timed out waiting for seed visibility", e);
/**
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.apache.logging.log4j.LogManager;
import java.util.List;
                }
    @Override
     * drain thread — the cancel propagates into {@code DatafusionReduceSink.reduce}, which unwinds
        );
            Version.CURRENT,
            CompositeDataFormatPlugin.class,
    /** Max {@code active}/{@code queue} for the {@code analytics_reduce} pool across all nodes. */
        // The cancelled query's reduce drain must have unwound and returned its pool thread.
            null,
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
    }
    /**
            assertFalse(
import org.opensearch.threadpool.ThreadPoolStats;
            .put("index.composite.primary_data_format", "parquet")
            TestPPLPlugin.class,
            assertTrue("residual " + action + " tasks: " + tasks.getTasks(), tasks.getTasks().isEmpty());
     * Normal completion: after a coordinator-reduce query finishes, the drain thread it borrowed
 * <p>The reduce drain runs on a thread from this fixed pool (one task per coordinator-reduce
import org.opensearch.plugins.PluginInfo;
    private static final String INDEX = "reduce_pool_cleanup_idx";
        client().admin().indices().prepareFlush(INDEX).get();
    /**
            }
            .setMapping("value", "type=integer")
    }
        } catch (Exception e) {
    private void assertNoResidualTasks(String action) throws Exception {
        }
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();
import org.opensearch.be.datafusion.DataFusionPlugin;
            MockCommitterEnginePlugin.class
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        client().admin().indices().prepareRefresh(INDEX).get();
    @Override
            assertBusy(() -> {
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = org.opensearch.analytics.resilience.FlightTransportThreadLeakFilter.class)
        for (int i = 0; i < TOTAL_DOCS; i++) {
            for (ThreadPoolStats.Stats s : tp.stats()) {
        // Block one data node's shard handler so cancellation lands while the query is in-flight
            exec.awaitTermination(5, TimeUnit.SECONDS);
import java.util.concurrent.ExecutorService;
            .indices()
            .build();
        createAndSeedIndex();
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
        }
/*
            }
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
 * in {@code stream_next} and is never cancelled, or {@code closeImpl} double-frees / deadlocks),
            } catch (InterruptedException ie) {
 * is what this PR's {@code closeImpl}/cancel teardown guarantees.
package org.opensearch.analytics.cancellation;
        }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
    public void testReducePoolReleasedAfterSuccessfulQuery() throws Exception {
            }
            .putList("index.composite.secondary_data_formats")
import org.opensearch.ppl.action.PPLRequest;
                ListTasksResponse live = client().admin().cluster().prepareListTasks().setActions(AnalyticsQueryAction.NAME).get();
        );
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        assertBusy(() -> {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
import org.opensearch.test.OpenSearchIntegTestCase;
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD;
import java.util.concurrent.TimeUnit;
import org.opensearch.ppl.action.PPLResponse;
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);
