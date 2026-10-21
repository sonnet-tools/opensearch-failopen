            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        CountDownLatch released = new CountDownLatch(1);
        }
        ListTasksResponse pplTasks = client().admin().cluster().prepareListTasks().setActions(UnifiedPPLExecuteAction.NAME).get();
    @Override
            CancelTasksResponse cancel = client().admin()
        }, 10, TimeUnit.SECONDS);
        ensureGreen(INDEX);
        }, 10, TimeUnit.SECONDS);
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        }
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
        assertBusy(() -> {
 * <p>Exercises the full cancellation path: task cancel at the coordinator cascades to
    }
            Thread.sleep(500);
                .get();
        assertBusy(() -> {
                .cluster()
            released.countDown();
            released.countDown();
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            } catch (InterruptedException ie) {
                cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty()
            exec.shutdownNow();
     */
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
        try {
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
     * Cancel the shard-level fragment task while it is blocked. Verifies that
            handler.messageReceived(request, channel, task);
        try {
            TestPPLPlugin.class,
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        return List.of(
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
                logger.info("Query terminated as expected after coordinator cancel: {}", e.getMessage());
            try {
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
                "Native memory grew after cancel: baseline=" + memBaseline + " after=" + memAfter,
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
import java.util.Collections;
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);
    }
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
        } finally {
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
    }
            pluginClass.getName(),
            released.countDown();
    private PPLResponse executePPL(String ppl) {
            mts.clearAllRules();
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
    public void testCancelCoordinatorTaskCascadesToShards() throws Exception {
            );
            assertTrue(tasks.getTasks().isEmpty());
    protected Settings nodeSettings(int nodeOrdinal) {
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
     */
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
import org.opensearch.plugins.PluginInfo;
            exec.shutdownNow();
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
        });
    public void testCancelShardFragmentTaskTerminatesQuery() throws Exception {
package org.opensearch.analytics.cancellation;
                logger.info("Query terminated as expected after shard cancel: {}", e.getMessage());
            throw new AssertionError("timed out waiting for seed visibility", e);
    private static final Logger logger = LogManager.getLogger(SearchCancellationIT.class);
            } catch (ExecutionException | TimeoutException ignore) {}
            .indices()
            try {
    /**
            }
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
            released.countDown();
            "1.8",
            Thread.sleep(500);
        });
        assertBusy(() -> {
import java.util.concurrent.Future;
            handler.messageReceived(request, channel, task);
            handler.messageReceived(request, channel, task);
import java.util.concurrent.TimeoutException;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)
            }
 * <p>Also verifies that after cancellation completes, no native resources leak (memory
import org.opensearch.composite.CompositeDataFormatPlugin;
import org.opensearch.common.unit.TimeValue;
    private static final int VALUE = 42;
            ListTasksResponse fragmentTasks = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
        // Warm-up so baselines reflect steady state.
        String victim = randomFrom(internalCluster().getDataNodeNames());
            ArrowBasePlugin.class,
        // No zombie fragment tasks.
            .put(super.nodeSettings(nodeOrdinal))
 */
            .prepareCreate(INDEX)
        }, 30, TimeUnit.SECONDS);
            exec.awaitTermination(5, TimeUnit.SECONDS);
public class SearchCancellationIT extends OpenSearchIntegTestCase {
        try {
    }
            System.gc();
import org.opensearch.be.datafusion.DataFusionService;
    private static final String INDEX = "cancel_test_idx";
     * Verifies that a successful query still works after a previous query was
import org.apache.logging.log4j.LogManager;
        CountDownLatch released = new CountDownLatch(1);
        // Block one data node's shard handler so we can cancel mid-flight.
     * native DataFusion memory pool returns to baseline after cancellation.
            } catch (InterruptedException ie) {
    private PPLResponse executePPL(String ppl, TimeValue timeout) {
 * task's cancellation listener fires {@code NativeBridge.cancelQuery(contextId)}, and
        try {
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            .put("index.composite.primary_data_format", "parquet")
            .put("index.pluggable.dataformat", "composite")
import java.util.concurrent.TimeUnit;
        }, 10, TimeUnit.SECONDS);
            MockTransportService.TestPlugin.class,
        Thread.sleep(50);
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
import org.opensearch.analytics.AnalyticsPlugin;
                .prepareCancelTasks()
            pluginClass.getName(),
            );
            try {
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        } catch (Exception e) {
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        String victim = randomFrom(internalCluster().getDataNodeNames());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        System.gc();
/*
            // Allow time for dispatch + shard handler entry.
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            assertTrue(
 *
        // Native resource cleanup.
import org.opensearch.plugins.Plugin;
            false
            int handleAfter = NativeHandle.liveHandleCount();
            exec.awaitTermination(5, TimeUnit.SECONDS);
            } catch (ExecutionException | TimeoutException e) {
            .put("arrow.memory.debug.allocator", true)
        }
import java.util.concurrent.CountDownLatch;
            null,
 * pool returns to baseline, NativeHandle live count doesn't grow).
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            }
 * The OpenSearch Contributors require contributions made to
        DataFusionService dfs = internalCluster().getDataNodeInstances(DataFusionService.class).iterator().next();
import org.opensearch.ppl.TestPPLPlugin;
            client().admin().cluster().prepareCancelTasks().setActions(FragmentExecutionAction.NAME).get();
    protected Collection<PluginInfo> additionalNodePlugins() {
        // Block one shard so cancellation lands while work is in-flight.
        } finally {
            Thread.sleep(500);
 *
            assertTrue(
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
     * the coordinator query terminates with a failure (not a hang) and that the
     * - Query terminates (no hang).
                assertEquals("seed not yet visible", EXPECTED_SUM, actual);
        client().admin().indices().prepareFlush(INDEX).get();
            exec.awaitTermination(5, TimeUnit.SECONDS);
            mts.clearAllRules();
        CreateIndexResponse response = client().admin()
        }, 30, TimeUnit.SECONDS);
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
        // Wait until the analytics path can see all data (parquet commits may lag).
        assertEquals("Post-cancellation query must return correct sum", EXPECTED_SUM, actual);
            Version.CURRENT,
            );
                Thread.currentThread().interrupt();
     */
import org.opensearch.transport.TransportService;
            assertFalse("cancel must not report node failures", cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty());
        long memBaseline = dfs.getMemoryPoolUsage();
                handleAfter <= handleBaseline
            assertTrue("No residual fragment tasks: " + tasks.getTasks(), tasks.getTasks().isEmpty());
            assertTrue("No residual fragment tasks: " + fragmentTasks.getTasks(), fragmentTasks.getTasks().isEmpty());
        });
        createAndSeedIndex();
            } catch (InterruptedException ie) {
        for (int i = 0; i < TOTAL_DOCS; i++) {
     * - NativeHandle live count doesn't grow.
    /**
    }
            "NA",
import org.apache.logging.log4j.Logger;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        assertTrue("No residual PPL tasks: " + pplTasks.getTasks(), pplTasks.getTasks().isEmpty());
    }
     * cancelled — cancellation state doesn't poison subsequent queries.
            .putList("index.composite.secondary_data_formats")
        createAndSeedIndex();
import java.util.concurrent.ExecutorService;
                memAfter <= memBaseline + 1024 * 1024
                Thread.currentThread().interrupt();
        }
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            }
        // Now run a fresh query — it should succeed with full results.
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);
            .build();
            // Cancel the fragment tasks.
            try {
        // Wait for cleanup.
                "cancel must not report node failures",
        client().admin().indices().prepareRefresh(INDEX).get();
            } catch (ExecutionException | TimeoutException e) {
            extendedPlugins,
import org.opensearch.ppl.action.PPLRequest;
    private static final int DOCS_PER_SHARD = 50;
import java.util.List;
        );
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;
import org.opensearch.test.transport.MockTransportService;
        );
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
            mts.clearAllRules();
    }
import java.util.Collection;
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    @Override
    // ---------------------------------------------------------------- tests
import java.util.concurrent.Executors;
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            assertFalse(
        CountDownLatch released = new CountDownLatch(1);
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
            }, 30, TimeUnit.SECONDS);
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
            try {
                // Expected: query failed due to cancellation.
import org.apache.lucene.tests.util.LuceneTestCase;
import org.opensearch.test.OpenSearchIntegTestCase;
    @Override
        createAndSeedIndex();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
        executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        return new PluginInfo(
            released.countDown();
@LuceneTestCase.AwaitsFix(bugUrl = "Flaky: Arrow allocator reports 138-byte residual on cancellation path (~1.5% rate)")
    private void createAndSeedIndex() {
            try {
    // ---------------------------------------------------------------- fixture
            .put("index.pluggable.dataformat.enabled", true)
            MockCommitterEnginePlugin.class
            .setMapping("value", "type=integer")
}
import org.opensearch.common.util.FeatureFlags;
     * Cancel the coordinator-level PPL task. The parent cancel cascades to child
                .setActions(UnifiedPPLExecuteAction.NAME)
import org.opensearch.analytics.backend.jni.NativeHandle;
    /**
        return List.of(
                .setActions(FragmentExecutionAction.NAME)
import org.opensearch.common.settings.Settings;
                Thread.currentThread().interrupt();
        }
 * the Rust CancellationToken + AbortHandle terminate the DataFusion computation.
 *
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD;
            .setSettings(indexSettings)
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
                .prepareCancelTasks()
            CancelTasksResponse cancel = client().admin()
        int handleBaseline = NativeHandle.liveHandleCount();
                .get();
            exec.shutdownNow();
     * - No residual coordinator or shard tasks remain.
            }
        assertBusy(() -> {
            "classpath plugin",
        return Settings.builder()
        String victim = randomFrom(internalCluster().getDataNodeNames());
        ExecutorService exec = Executors.newSingleThreadExecutor();
            // Cancel the coordinator (parent) task — cascades to shard children.
                .cluster()
 * data-node shard tasks via {@code shouldCancelChildrenOnCancellation()}, the shard
     * - Native memory pool returns to baseline.
 * compatible open source license.
        assertBusy(() -> {
import org.opensearch.Version;
 */
        Settings indexSettings = Settings.builder()
    }
            CompositeDataFormatPlugin.class,
    private static final int NUM_SHARDS = 2;
 * Integration tests for DataFusion query cancellation.
            released.countDown();
/**
        // No residual tasks.
     * shard tasks via {@code shouldCancelChildrenOnCancellation() = true}. Verifies:
                "NativeHandle live count grew: baseline=" + handleBaseline + " after=" + handleAfter,
    }
    public void testQuerySucceedsAfterPreviousCancellation() throws Exception {
        } finally {
    }
            long memAfter = dfs.getMemoryPoolUsage();
        ExecutorService exec = Executors.newSingleThreadExecutor();
 * this file be licensed under the Apache-2.0 license or a
            assertBusy(() -> {
        );
import java.util.concurrent.ExecutionException;
import org.opensearch.ppl.action.PPLResponse;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = org.opensearch.analytics.resilience.FlightTransportThreadLeakFilter.class)
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
import org.opensearch.be.datafusion.DataFusionPlugin;
        long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();
        // First, cancel a query mid-flight.
            .get();
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();
        ExecutorService exec = Executors.newSingleThreadExecutor();
 * SPDX-License-Identifier: Apache-2.0
