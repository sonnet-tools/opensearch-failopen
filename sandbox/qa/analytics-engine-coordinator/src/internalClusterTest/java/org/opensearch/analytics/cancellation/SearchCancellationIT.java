            assertFalse(
    }  
/*  
 * data-node shard tasks via {@code shouldCancelChildrenOnCancellation()}, the shard  
            } catch (ExecutionException | TimeoutException e) {
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD;
import org.opensearch.analytics.backend.jni.NativeHandle;  
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        // Block one shard so cancellation lands while work is in-flight.
            Thread.sleep(500);  
            TestPPLPlugin.class,
     */
import org.opensearch.analytics.AnalyticsPlugin;
            exec.shutdownNow();
        assertTrue("index creation must be acknowledged", response.isAcknowledged());  
 *
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            assertTrue("No residual fragment tasks: " + tasks.getTasks(), tasks.getTasks().isEmpty());  
        return List.of(
import org.opensearch.be.datafusion.DataFusionService;
    }
import java.util.concurrent.Future;  
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);  
            released.countDown();  
import org.opensearch.ppl.action.PPLRequest;  
            released.countDown();
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
            exec.awaitTermination(5, TimeUnit.SECONDS);  
            .setSettings(indexSettings)  
            .get();
    private PPLResponse executePPL(String ppl, TimeValue timeout) {
            } catch (ExecutionException | TimeoutException ignore) {}
            System.gc();
            .build();  
        );
        // Now run a fresh query — it should succeed with full results.
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        // Block one data node's shard handler so we can cancel mid-flight.  
        return new PluginInfo(
 * compatible open source license.
            }
                "cancel must not report node failures",
            assertBusy(() -> {
     * Cancel the coordinator-level PPL task. The parent cancel cascades to child
            released.countDown();
        CountDownLatch released = new CountDownLatch(1);
     * native DataFusion memory pool returns to baseline after cancellation.
public class SearchCancellationIT extends OpenSearchIntegTestCase {  
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;  
 * task's cancellation listener fires {@code NativeBridge.cancelQuery(contextId)}, and
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        assertBusy(() -> {
import org.opensearch.transport.TransportService;  
            try {
import java.util.List;
 * Integration tests for DataFusion query cancellation.  
                .setActions(UnifiedPPLExecuteAction.NAME)  
        String victim = randomFrom(internalCluster().getDataNodeNames());
import org.apache.logging.log4j.Logger;
        // Warm-up so baselines reflect steady state.  
        try {
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);  
    protected Collection<PluginInfo> additionalNodePlugins() {  
        } catch (Exception e) {
     * - No residual coordinator or shard tasks remain.
            try {
            MockTransportService.TestPlugin.class,  
        }
                Thread.currentThread().interrupt();
            CancelTasksResponse cancel = client().admin()  
        // No zombie fragment tasks.  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
            pluginClass.getName(),
            mts.clearAllRules();
            } catch (InterruptedException ie) {  
                .setActions(FragmentExecutionAction.NAME)
    }
            assertTrue("No residual fragment tasks: " + fragmentTasks.getTasks(), fragmentTasks.getTasks().isEmpty());  
            // Cancel the coordinator (parent) task — cascades to shard children.
            Version.CURRENT,
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
        String victim = randomFrom(internalCluster().getDataNodeNames());  
            }  
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        try {
import org.apache.logging.log4j.LogManager;
        long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();  
package org.opensearch.analytics.cancellation;
        int handleBaseline = NativeHandle.liveHandleCount();  
            assertTrue(tasks.getTasks().isEmpty());
        createAndSeedIndex();
    private static final String INDEX = "cancel_test_idx";
            "1.8",  
import org.opensearch.ppl.action.PPLResponse;
        System.gc();
        });
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            released.countDown();
import java.util.concurrent.Executors;
            pluginClass.getName(),
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            released.countDown();  
 *  
     * - Native memory pool returns to baseline.  
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        assertBusy(() -> {
        // No residual tasks.  
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
        client().admin().indices().prepareRefresh(INDEX).get();  
            .put("arrow.memory.debug.allocator", true)
            try {
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);
 *
        try {
@LuceneTestCase.AwaitsFix(bugUrl = "Flaky: Arrow allocator reports 138-byte residual on cancellation path (~1.5% rate)")
            mts.clearAllRules();
    protected Settings nodeSettings(int nodeOrdinal) {  
            handler.messageReceived(request, channel, task);  
                handleAfter <= handleBaseline
            "NA",
 * <p>Exercises the full cancellation path: task cancel at the coordinator cascades to
 * the Rust CancellationToken + AbortHandle terminate the DataFusion computation.
            .putList("index.composite.secondary_data_formats")  
                .prepareCancelTasks()
 * pool returns to baseline, NativeHandle live count doesn't grow).
            try {  
        return Settings.builder()
    public void testQuerySucceedsAfterPreviousCancellation() throws Exception {
import org.opensearch.plugins.Plugin;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
    }
            throw new AssertionError("timed out waiting for seed visibility", e);
            .put("index.composite.primary_data_format", "parquet")
        ExecutorService exec = Executors.newSingleThreadExecutor();
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
            }
import org.opensearch.ppl.TestPPLPlugin;
import java.util.concurrent.CountDownLatch;
    }  
            }, 30, TimeUnit.SECONDS);  
        createAndSeedIndex();
                logger.info("Query terminated as expected after shard cancel: {}", e.getMessage());  
    }
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        // Native resource cleanup.  
        long memBaseline = dfs.getMemoryPoolUsage();
            CancelTasksResponse cancel = client().admin()
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
    private PPLResponse executePPL(String ppl) {  
 */  
            int handleAfter = NativeHandle.liveHandleCount();
            // Allow time for dispatch + shard handler entry.
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
            "classpath plugin",  
            CompositeDataFormatPlugin.class,
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);
        }
     */
            .prepareCreate(INDEX)
                .prepareCancelTasks()
    @Override
            );
            handler.messageReceived(request, channel, task);  
        DataFusionService dfs = internalCluster().getDataNodeInstances(DataFusionService.class).iterator().next();
        Settings indexSettings = Settings.builder()  
            } catch (InterruptedException ie) {  
    // ---------------------------------------------------------------- tests
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
import org.apache.lucene.tests.util.LuceneTestCase;  
import org.opensearch.plugins.PluginInfo;
            .put("index.pluggable.dataformat.enabled", true)  
import org.opensearch.common.settings.Settings;
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
     * shard tasks via {@code shouldCancelChildrenOnCancellation() = true}. Verifies:  
                "NativeHandle live count grew: baseline=" + handleBaseline + " after=" + handleAfter,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();  
        });
            try {  
        String victim = randomFrom(internalCluster().getDataNodeNames());  
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
        }, 10, TimeUnit.SECONDS);
                logger.info("Query terminated as expected after coordinator cancel: {}", e.getMessage());  
            .build();
        Thread.sleep(50);  
            } catch (InterruptedException ie) {
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
                // Expected: query failed due to cancellation.
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)  
import org.opensearch.common.util.FeatureFlags;
    /**
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        CountDownLatch released = new CountDownLatch(1);
        try {
    private static final Logger logger = LogManager.getLogger(SearchCancellationIT.class);
        }, 30, TimeUnit.SECONDS);
        ExecutorService exec = Executors.newSingleThreadExecutor();  
                cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty()  
import org.opensearch.Version;
        }, 10, TimeUnit.SECONDS);
        CountDownLatch released = new CountDownLatch(1);  
import org.opensearch.be.datafusion.DataFusionPlugin;
import java.util.concurrent.ExecutionException;  
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
    }  
        ListTasksResponse pplTasks = client().admin().cluster().prepareListTasks().setActions(UnifiedPPLExecuteAction.NAME).get();  
}  
                assertEquals("seed not yet visible", EXPECTED_SUM, actual);
        return List.of(
        } finally {
        }, 10, TimeUnit.SECONDS);
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;  
            extendedPlugins,  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * cancelled — cancellation state doesn't poison subsequent queries.  
                .get();
            null,
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
    /**
            }
        }
            ArrowBasePlugin.class,  
        );
    }
            client().admin().cluster().prepareCancelTasks().setActions(FragmentExecutionAction.NAME).get();
 */  
            assertTrue(  
import org.opensearch.test.transport.MockTransportService;
                memAfter <= memBaseline + 1024 * 1024
        // Wait for cleanup.
        });
    private void createAndSeedIndex() {
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
     * - Query terminates (no hang).
        }  
                .cluster()
            assertFalse("cancel must not report node failures", cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty());
            .setMapping("value", "type=integer")
     */
            MockCommitterEnginePlugin.class
        for (int i = 0; i < TOTAL_DOCS; i++) {  
    private static final int VALUE = 42;
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override  
            );  
 * SPDX-License-Identifier: Apache-2.0
    public void testCancelCoordinatorTaskCascadesToShards() throws Exception {  
            false
    }
/**
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
            .indices()
        }, 30, TimeUnit.SECONDS);
    }
        );  
     * the coordinator query terminates with a failure (not a hang) and that the  
        CreateIndexResponse response = client().admin()  
import org.opensearch.composite.CompositeDataFormatPlugin;
            released.countDown();  
import org.opensearch.common.unit.TimeValue;  
        ExecutorService exec = Executors.newSingleThreadExecutor();  
     * Cancel the shard-level fragment task while it is blocked. Verifies that
    private static final int DOCS_PER_SHARD = 50;  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");  
        assertBusy(() -> {
        } finally {
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
                .cluster()  
            exec.shutdownNow();
            exec.awaitTermination(5, TimeUnit.SECONDS);
    private static final int NUM_SHARDS = 2;
                Thread.currentThread().interrupt();
        ensureGreen(INDEX);
            try {
                Thread.currentThread().interrupt();
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = org.opensearch.analytics.resilience.FlightTransportThreadLeakFilter.class)
import java.util.Collection;
            ListTasksResponse fragmentTasks = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
        createAndSeedIndex();  
     * Verifies that a successful query still works after a previous query was
                "Native memory grew after cancel: baseline=" + memBaseline + " after=" + memAfter,
        }
            mts.clearAllRules();
    @Override
            exec.awaitTermination(5, TimeUnit.SECONDS);  
            } catch (ExecutionException | TimeoutException e) {
            assertTrue(  
        // First, cancel a query mid-flight.
            // Cancel the fragment tasks.
    public void testCancelShardFragmentTaskTerminatesQuery() throws Exception {  
            Thread.sleep(500);  
import java.util.Collections;  
        assertBusy(() -> {
            exec.shutdownNow();  
            .put("index.pluggable.dataformat", "composite")
            );  
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertEquals("Post-cancellation query must return correct sum", EXPECTED_SUM, actual);
import java.util.concurrent.TimeoutException;
        client().admin().indices().prepareFlush(INDEX).get();
                .get();  
        // Wait until the analytics path can see all data (parquet commits may lag).  
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
        assertBusy(() -> {  
import java.util.concurrent.TimeUnit;
 * The OpenSearch Contributors require contributions made to  
        assertTrue("No residual PPL tasks: " + pplTasks.getTasks(), pplTasks.getTasks().isEmpty());
            long memAfter = dfs.getMemoryPoolUsage();
            Thread.sleep(500);
 * <p>Also verifies that after cancellation completes, no native resources leak (memory
    // ---------------------------------------------------------------- fixture  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
    /**
        executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        } finally {  
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;  
     * - NativeHandle live count doesn't grow.
import java.util.concurrent.ExecutorService;
            handler.messageReceived(request, channel, task);
 * this file be licensed under the Apache-2.0 license or a
