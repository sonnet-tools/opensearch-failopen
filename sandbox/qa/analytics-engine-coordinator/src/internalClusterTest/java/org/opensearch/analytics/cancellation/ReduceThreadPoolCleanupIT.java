            ArrowBasePlugin.class,
        }
import org.opensearch.be.datafusion.DataFusionPlugin;  
            MockTransportService.TestPlugin.class,
        CreateIndexResponse response = client().admin()
 * in {@code stream_next} and is never cancelled, or {@code closeImpl} double-frees / deadlocks),
            .put("index.composite.primary_data_format", "parquet")  
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);  
import java.util.concurrent.CountDownLatch;
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
        CountDownLatch released = new CountDownLatch(1);
import java.util.concurrent.Executors;
package org.opensearch.analytics.cancellation;
    }  
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;
            assertBusy(() -> {  
 *
    @Override
     * from {@code analytics_reduce} must be returned — the pool drains to zero active.
        for (int i = 0; i < TOTAL_DOCS; i++) {
     * Normal completion: after a coordinator-reduce query finishes, the drain thread it borrowed  
        createAndSeedIndex();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        );  
            }
        assertNoResidualTasks(FragmentExecutionAction.NAME);  
            assertFalse(  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        assertEquals("query must return the correct sum", EXPECTED_SUM, actual);
import org.opensearch.common.util.FeatureFlags;
 *
import java.util.concurrent.ExecutorService;
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            released.countDown();
import org.opensearch.threadpool.ThreadPool;
            .get();  
    private static final int NUM_SHARDS = 2;  
}
 * saturates. These tests assert the pool drains back to {@code active=0} after each query, which  
            pluginClass.getName(),
    }
import org.opensearch.analytics.exec.action.FragmentExecutionAction;  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
            Version.CURRENT,  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
        client().admin().indices().prepareFlush(INDEX).get();
    }
            "classpath plugin",
    private static final Logger logger = LogManager.getLogger(ReduceThreadPoolCleanupIT.class);  
        // The cancelled query's reduce drain must have unwound and returned its pool thread.  
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(action).get();  
    private static final String INDEX = "reduce_pool_cleanup_idx";
import org.opensearch.threadpool.ThreadPoolStats;
            exec.awaitTermination(5, TimeUnit.SECONDS);  
        long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();
            }, 10, TimeUnit.SECONDS);  
 */  
    private static final int DOCS_PER_SHARD = 50;
import org.opensearch.test.transport.MockTransportService;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)  
            .setMapping("value", "type=integer")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                Thread.currentThread().interrupt();
        }, 30, TimeUnit.SECONDS);
import org.apache.logging.log4j.Logger;
            mts.clearAllRules();
 * The OpenSearch Contributors require contributions made to  
import java.util.concurrent.ExecutionException;  
        return Settings.builder()
     * Cancellation: a query cancelled while a shard handler is blocked must still release its reduce  
        }
 * — both on the normal-completion path and the cancellation path.  
            throw new AssertionError("timed out waiting for seed visibility", e);
        return new PluginInfo(
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD;
     */
    }
            "NA",
        for (ThreadPool tp : internalCluster().getInstances(ThreadPool.class)) {
    /**
        return List.of(  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
import org.opensearch.transport.TransportService;  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            int active = reducePoolActiveAcrossNodes();
                logger.info("query terminated as expected after cancel: {}", e.getMessage());  
    private static final int VALUE = 7;  
 * Verifies the coordinator-reduce thread pool ({@code analytics_reduce}) is released after a query
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
        }  
 * SPDX-License-Identifier: Apache-2.0
public class ReduceThreadPoolCleanupIT extends OpenSearchIntegTestCase {
import java.util.concurrent.Future;  
                assertFalse("analytics/query task should be running", live.getTasks().isEmpty());
            } catch (InterruptedException ie) {  
            pluginClass.getName(),  
        try {
import org.opensearch.ppl.action.PPLResponse;  
    private PPLResponse executePPL(String ppl) {  
        try {
                }  
            .build();
                if (AnalyticsPlugin.REDUCE_THREAD_POOL_NAME.equals(s.getName())) {
            TestPPLPlugin.class,
            .put("index.pluggable.dataformat", "composite")
/**
     * and frees the pool thread. Without that, the parked drain leaks the thread permanently.
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
    public void testReducePoolReleasedAfterCancelledQuery() throws Exception {
        } catch (Exception e) {
            .put(super.nodeSettings(nodeOrdinal))  
     */  
    private int reducePoolActiveAcrossNodes() {  
import org.opensearch.common.unit.TimeValue;  
    public void testReducePoolReleasedAfterSuccessfulQuery() throws Exception {  
        ensureGreen(INDEX);
 */
        }  
            null,  
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(AnalyticsQueryAction.NAME).get();
    private PPLResponse executePPL(String ppl, TimeValue timeout) {
        return maxActive;  
    @Override  
    }
import org.opensearch.composite.CompositeDataFormatPlugin;
            handler.messageReceived(request, channel, task);  
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
import java.util.concurrent.TimeoutException;
    protected Settings nodeSettings(int nodeOrdinal) {
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
            .putList("index.composite.secondary_data_formats")
            .put(FeatureFlags.STREAM_TRANSPORT, true)
    }  
        assertBusy(() -> {
import org.apache.logging.log4j.LogManager;
        );
    private void assertNoResidualTasks(String action) throws Exception {
            released.countDown();  
import java.util.List;
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
/*  
            .build();  
            assertTrue("residual " + action + " tasks: " + tasks.getTasks(), tasks.getTasks().isEmpty());
    }
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
import org.opensearch.plugins.Plugin;
    }  
                    maxActive = Math.max(maxActive, s.getActive() + s.getQueue());
import org.opensearch.analytics.AnalyticsPlugin;
            extendedPlugins,
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");  
            } catch (ExecutionException | TimeoutException e) {
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
    private void assertReducePoolDrains() throws Exception {  
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);
                ListTasksResponse live = client().admin().cluster().prepareListTasks().setActions(AnalyticsQueryAction.NAME).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
 * compatible open source license.
            assertEquals("analytics_reduce pool must drain to 0 active+queued; got " + active, 0, active);  
            try {  
        int maxActive = 0;
        // (the reduce drain is parked waiting for this shard's input).
    protected Collection<PluginInfo> additionalNodePlugins() {
            for (ThreadPoolStats.Stats s : tp.stats()) {  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;
            }
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))  
            .put("index.pluggable.dataformat.enabled", true)
import java.util.concurrent.TimeUnit;
 * is what this PR's {@code closeImpl}/cancel teardown guarantees.
        ExecutorService exec = Executors.newSingleThreadExecutor();  
        });
    }
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        assertReducePoolDrains();
     * drain thread — the cancel propagates into {@code DatafusionReduceSink.reduce}, which unwinds
        // Block one data node's shard handler so cancellation lands while the query is in-flight
import org.opensearch.ppl.TestPPLPlugin;
import org.opensearch.common.settings.Settings;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = org.opensearch.analytics.resilience.FlightTransportThreadLeakFilter.class)  
import org.opensearch.plugins.PluginInfo;  
        assertBusy(() -> {
            }, 30, TimeUnit.SECONDS);  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    @Override  
    }
            try {
    }
    /**
            assertBusy(() -> {
            .setSettings(indexSettings)
        }, 10, TimeUnit.SECONDS);
        Settings indexSettings = Settings.builder()
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),  
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
 * stage). If {@code DatafusionReduceSink.reduce} fails to unwind on cancellation (the drain parks  
    private void createAndSeedIndex() {  
import org.opensearch.ppl.action.PPLRequest;
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();
                "cancel must not report node failures",
        String victim = randomFrom(internalCluster().getDataNodeNames());  
import org.opensearch.test.OpenSearchIntegTestCase;
 * <p>The reduce drain runs on a thread from this fixed pool (one task per coordinator-reduce
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;  
        createAndSeedIndex();
            }
        assertReducePoolDrains();
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);
            );  
            .indices()
import org.opensearch.Version;  
        client().admin().indices().prepareRefresh(INDEX).get();
            .prepareCreate(INDEX)  
            CompositeDataFormatPlugin.class,  
                cancel.getNodeFailures() != null && cancel.getNodeFailures().isEmpty() == false
            exec.shutdownNow();
 * the drain thread leaks: the pool's {@code active} count stays elevated and eventually the pool
            false
import java.util.Collections;  
        );  
        } finally {
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
    /** Max {@code active}/{@code queue} for the {@code analytics_reduce} pool across all nodes. */
            "1.8",
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)
            MockCommitterEnginePlugin.class
                assertEquals("seed not yet visible", EXPECTED_SUM, actual);
        return List.of(
