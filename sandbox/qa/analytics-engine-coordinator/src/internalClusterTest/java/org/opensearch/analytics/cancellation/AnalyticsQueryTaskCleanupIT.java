                .prepareUpdateSettings()
import org.opensearch.common.util.FeatureFlags;
        assertNoResidualTasks(FragmentExecutionAction.NAME);
     * A successful query must leave NO residual {@code AnalyticsQueryAction} task. This is the
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        assertNoResidualTasks(FragmentExecutionAction.NAME);
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                .setMapping("sortkey", "type=integer", "payload", "type=keyword,index=false")
            client().prepareIndex(QTF_INDEX).setSource("sortkey", i, "payload", "row-" + i).get();
        for (int i = 0; i < QTF_DOCS; i++) {
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
                .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", 1L))
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.be.datafusion.DataFusionPlugin;
            mtsList.add(mts);
import org.opensearch.OpenSearchException;
            FragmentExecutionAction.NAME,
            "GroupedHashAggregateStream",
            MockTransportService.TestPlugin.class,
}
import java.util.Collections;
                .prepareCancelTasks()
        }
     * A shard fragment returning a {@link TaskCancelledException} over stream transport — exactly what
                failure == null ? "none" : failure.getClass().getName() + ": " + failure.getMessage()
    public void testShardSortPoolExhaustionSurfacesAs429WithoutLeak() throws Exception {
            // (admission-rejected), both of which report TOO_MANY_REQUESTS. Find the 429-bearing exception
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
        createAndSeedIndex();
     * QTF sanity + cleanup. Confirms the late-materialization rewriter actually fires on this index +
            .put(super.nodeSettings(nodeOrdinal))
                failure = t;
                cancel.getNodeFailures() != null && cancel.getNodeFailures().isEmpty() == false
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
                .cluster()
 * and runs it under the framework-provided, cancellable {@code AnalyticsQueryTask} — instead of a
import java.util.concurrent.CountDownLatch;
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
import org.opensearch.composite.CompositeDataFormatPlugin;
    // ---------------------------------------------------------------- tests
import org.opensearch.test.transport.MockTransportService;
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            (channel, victim) -> channel.sendResponse(new TaskCancelledException("sbp cancel (qtf query phase) on " + victim))
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);
import org.opensearch.test.OpenSearchIntegTestCase;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)
            try {
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
import org.opensearch.analytics.exec.action.FetchByRowIdsAction;
        List<MockTransportService> mtsList = new java.util.ArrayList<>();
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            mts.addRequestHandlingBehavior(FetchByRowIdsAction.NAME, (handler, request, channel, task) -> {
                "cancel must not report node failures",
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
        client().admin().indices().prepareFlush(QTF_INDEX).get();
        for (String node : internalCluster().getDataNodeNames()) {
    }
        return List.of(
                "a native memory-pool trip must surface as HTTP 429 (got " + failure.getClass().getName() + ": " + failure
                try {
        }
            ArrowBasePlugin.class,
            } catch (Throwable t) {
                response = executePPL(qtfQuery(), QUERY_TIMEOUT);
        } finally {
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
    private PPLResponse executePPL(String ppl, TimeValue timeout) {
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
            );
            .putList("index.composite.secondary_data_formats")
                    .getMessage() + ")",
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
    public void testQtfQueryFiresFetchPhaseAndLeavesNoResidualTasks() throws Exception {
                .cluster()
        client().admin().indices().prepareRefresh(INDEX).get();
     */
            assertTrue("residual " + action + " tasks: " + tasks.getTasks(), tasks.getTasks().isEmpty());
            "top memory consumers",
     * transport path and the cause sanitization.
                    Thread.currentThread().interrupt();
            .put("index.composite.primary_data_format", "parquet")
        ExecutorService exec = Executors.newSingleThreadExecutor();
 * this file be licensed under the Apache-2.0 license or a
        try {
     * the query now runs under the framework-provided task; pre-PR-9 the query ran under a detached
            exec.awaitTermination(5, TimeUnit.SECONDS);
        // Squeeze the native pool so any aggregation allocation trips it.
            null,
            .putList("index.composite.secondary_data_formats")
     * coordinator query task AND the fragment tasks must both unregister. Without the
        } finally {
        // The contract that matters for the stuck-task issue: NO phantom coordinator query task, no
    // the query phase (FragmentExecutionAction) and the fetch phase (FetchByRowIdsAction), and assert no
            .build();
        } catch (Exception e) {
     * self-registered task, so cancelling the framework action had no effect on it.
                response,
        try {
                response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
 *
            //   2. with multiple shards, the failure cascade cancels a sibling's gRPC stream before its
                ListTasksResponse live = client().admin().cluster().prepareListTasks().setActions(AnalyticsQueryAction.NAME).get();
    }
                .prepareUpdateSettings()
     * ("Stage 0 failed"). This is the path {@code MemoryGuardIT} exercises; here we assert the unwrapped
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
                // fromWireError, mirroring what production produces when SBP cancels a shard fragment.
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
                RestStatus.TOO_MANY_REQUESTS,
            //      typed CANCELLED error is flushed (sendError no-ops on an already-cancelled channel), so
        );
            Throwable failure = null;
        AtomicBoolean fetchDispatched = new AtomicBoolean(false);
            }, 30, TimeUnit.SECONDS);
    private static void assertNoNativeLeak(Throwable t) {
        ensureGreen(INDEX);
    }
        return List.of(
        for (String node : internalCluster().getDataNodeNames()) {
                    + "cancel/breaker tests below exercise a non-QTF plan",
            );
    }
            });
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    @Override
import org.opensearch.Version;
                response = executePPL("source = " + INDEX + " | stats count() by value", QUERY_TIMEOUT);
        }
        // shards on one node, so a single-victim injection can miss the fragment and the query succeeds (flake).
            .build();
            RestStatus status = firstStatus(failure, RestStatus.TOO_MANY_REQUESTS);
            client().admin()
        ensureGreen(QTF_INDEX);
        createAndSeedQtfIndex();
import org.opensearch.ppl.TestPPLPlugin;
     * Search BackPressure does when it cancels a leaf {@code AnalyticsShardTask} (the bottom-up cancel
            .prepareCreate(INDEX)
        );
            .get();
        try {
        }
            }
        assertNoResidualTasks(FragmentExecutionAction.NAME);
            assertNoNativeLeak(failure);
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
     * rewriter didn't engage, no fetch is dispatched and the assertion fails, telling us the QTF tests
                "[sbp-cancel] shard TaskCancelledException -> coordinator surfaced: response={}, failure={}",
            Throwable failure = null;
import java.util.concurrent.atomic.AtomicBoolean;
            sb.append(c.getClass().getName()).append(':').append(c.getMessage()).append('\n');
                isTaskCancelled || isGrpcCancelTeardown
    /**
                assertFalse("analytics/query task should be running", live.getTasks().isEmpty());
            try {
                );
                return ose.status();
    // A QTF query has THREE stage levels (shard fragment → late-materialization → reduce) and a second
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
    }
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            client().admin()
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
 * unregistered it), and (2) cancelling the analytics/query task terminates the query and leaves no
import java.util.concurrent.TimeUnit;
        );
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
        );
        try {
            CancelTasksResponse cancel = client().admin()
     * that does NOT touch the coordinator action) — must tear down the whole query cleanly: the
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
        return new PluginInfo(
                channel.sendResponse(
    }
            .put("datafusion.spill_directory", createTempDir().toString())
            pluginClass.getName(),
                fetchDispatched.set(true);
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();
    /** SBP stand-in on the QTF QUERY phase: a cancelled shard fragment must tear down the whole 3-level QTF tree. */
            assertNotNull("a cancelled shard must fail the query, not silently return a result (response=" + response + ")", failure);
            try {
        }, 10, TimeUnit.SECONDS);
        }
        try {
     * rebuilt into a breaker at the coordinator ({@code AnalyticsTransportErrors.fromWireError}). Without the
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
        List<MockTransportService> mtsList = new java.util.ArrayList<>();
            mtsList.forEach(MockTransportService::clearAllRules);
            PPLResponse r = executePPL("source = " + QTF_INDEX + " | stats count() as c");
        return null;
    // `source = QTF_INDEX | sort sortkey | head N | fields payload` makes the LateMaterialization
        long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();
            } catch (Throwable t) {
     * or fetch tasks.
            assertEquals(
            mtsList.add(mts);
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
import java.util.concurrent.ExecutorService;
     * below are testing the wrong thing). A successful QTF query must leave no residual query, fragment,
        Settings indexSettings = Settings.builder()
                .prepareCreate(QTF_INDEX)
        // (the query then succeeds and the test flakes). Injecting everywhere fails the fragment wherever it runs.
                // → AnalyticsTransportErrors.toWireError), so we inject the post-classification wire form: a
            logger.info(
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD;
            assertNotNull("injected failure on " + action + " must fail the QTF query, not return (response=" + response + ")", failure);
        // The phantom-task contract: no stranded coordinator query task, no residual fragment/fetch tasks.
    /**
        StringBuilder sb = new StringBuilder();
import org.opensearch.transport.stream.StreamException;
    }
                // Replacing the handler bypasses the production classify seam (channelResponseHandler.onFailure
import org.opensearch.core.tasks.TaskCancelledException;
     * staging shape (high-q07..q10). The shard fragment trips the pool, the breaker crosses stream
    // ---------------------------------------------------------------- QTF (query-then-fetch) tests
 * unregisters it when the listener settles, and a client disconnect / explicit cancel of that task
                failure = t;
     * 429 and clean teardown.
            mtsList.add(mts);
            released.countDown();
            mtsList.add(mts);
            assertFalse("native detail '" + leak + "' must not leak to the user, got: " + rendered, rendered.contains(leak));
            client().admin()
        }
                .setTransientSettings(Settings.builder().putNull("datafusion.memory_pool_limit_bytes"))
            assertNotNull("native pool exhaustion must fail the query, not return (response=" + response + ")", failure);
    private static final int QTF_DOCS = 200;
     */
     * transport, and must surface to the user as HTTP 429 with NO leaked native allocator dump
    @FunctionalInterface
        client().admin().indices().prepareRefresh(QTF_INDEX).get();
            assertFalse("QTF query must return rows", response.getRows().isEmpty());
            mtsList.forEach(MockTransportService::clearAllRules);
        // Force the parquet commit visible before measuring.
    // round of shard work: the fetch phase ({@link FetchByRowIdsAction}). The phantom-task strand the
            .put("index.composite.primary_data_format", "parquet")
            assertBusy(() -> {
        for (String node : internalCluster().getDataNodeNames()) {
        assertEquals("query must return the correct sum", EXPECTED_SUM, actual);
        createAndSeedIndex();
import java.util.concurrent.TimeoutException;
                } catch (InterruptedException ie) {
            );
        StringBuilder sb = new StringBuilder();
        );
            assertEquals(
            assertTrue(
            FetchByRowIdsAction.NAME,
        List<MockTransportService> mtsList = new java.util.ArrayList<>();
     * (no hang) and leaves no residual analytics/query or fragment tasks. This only works because
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
    private PPLResponse executePPL(String ppl) {
     * unregisters the task it created for {@code doExecute} once the listener settles, so neither a
                fetchDispatched.get()
    // ---------------------------------------------------------------- fixture
            PPLResponse response = null;
                .setTransientSettings(Settings.builder().putNull("datafusion.memory_pool_limit_bytes"))
            exec.shutdownNow();
            PPLResponse response = null;
    private void assertNoResidualTasks(String action) throws Exception {
            TestPPLPlugin.class,
    /**
            Throwable failure = null;
            assertNotNull("shard sort pool exhaustion must fail the query (response=" + response + ")", failure);
                RestStatus.TOO_MANY_REQUESTS,
                failure = t;
 * compatible open source license.
                "late-materialization rewriter must fire (FetchByRowIdsAction dispatched) — otherwise the QTF "
            .setMapping("value", "type=integer")
/*
 * detached task self-registered inside {@code DefaultPlanExecutor.executeInternal}. Because the task
            );
        }
     * Real native pool exhaustion through a SORT/LIMIT (TopK) query on a MULTI-SHARD index — the exact
            mtsList.forEach(MockTransportService::clearAllRules);
            );
            client().admin()
        } finally {
        assertNoResidualTasks(FragmentExecutionAction.NAME);
            (channel, victim) -> channel.sendResponse(new TaskCancelledException("sbp cancel (qtf fetch phase) on " + victim))
 */
import org.apache.logging.log4j.Logger;
            "avg_row_bytes" }) {
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            mtsList.forEach(MockTransportService::clearAllRules);
            }, 10, TimeUnit.SECONDS);
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = org.opensearch.analytics.resilience.FlightTransportThreadLeakFilter.class)
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            released.countDown();
                handler.messageReceived(request, channel, task);
            //   1. the cancel propagates as a TaskCancelledException (fromWireError rebuilds it), or
        // residual fragment tasks, after a bottom-up shard cancel.
        assertNoResidualTasks(FragmentExecutionAction.NAME);
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
     */
        } finally {
            boolean isTaskCancelled = ExceptionsHelper.unwrap(failure, TaskCancelledException.class) != null;
    }
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
    private void createAndSeedIndex() {
        createAndSeedIndex();
    /** SBP stand-in on the QTF FETCH phase: a cancelled fetch must tear down the whole 3-level QTF tree. */
        assertTrue(
            "classpath plugin",
                action,
    }
import java.util.concurrent.Executors;
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(action).get();
    }
        }
import org.opensearch.core.rest.RestStatus;
    // rewriter fire: the query phase emits row-ids, the fetch phase (FetchByRowIdsAction) materializes
            assertBusy(() -> {
import org.opensearch.cluster.metadata.IndexMetadata;
        } finally {
        assertBusy(() -> {
            pluginClass.getName(),
                .get();
        void inject(org.opensearch.transport.TransportChannel channel, String victim) throws Exception;
    }
            extendedPlugins,
            try {
            try {
                .indices()
            Throwable failure = null;
            throw new AssertionError("timed out waiting for seed visibility", e);
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            } catch (ExecutionException | TimeoutException e) {
import org.apache.logging.log4j.LogManager;
            MockCommitterEnginePlugin.class
            "query_untracked",
            // Allow dispatch + shard handler entry so the analytics/query task is live.
            false
                "[qtf-inject] action={} -> response={}, failure={}",
 * residual analytics/query or fragment tasks.
import org.opensearch.ppl.action.PPLRequest;
    }
     * StageExecution attachChildren CANCELLED-propagation fix, a cancelled shard stage strands its
        client().admin().indices().prepareFlush(INDEX).get();
                .setActions(AnalyticsQueryAction.NAME)
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
                .get();
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;
        );
                .get()
            if (c instanceof OpenSearchException ose && ose.status() == target) {
                .get()
    public void testSuccessfulQueryLeavesNoResidualAnalyticsTask() throws Exception {
 * is now framework-owned, {@code HandledTransportAction} registers it before {@code doExecute} and
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
                }
 * propagates into the running query.
            );
        }
                .setSettings(indexSettings)
     * ("Failed to allocate …") is NOT a {@code CircuitBreakingException} object — it is converted to one on
    }
            });
    // StageExecution attachChildren fix addresses is reachable here in production: a cancelled shard
    }
 * register/unregister: (1) a successful query leaves no residual analytics/query task (the framework
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.transport.TransportService;
    private void assertQtfInjectedFailureSurfacesAndCleansUp(String action, FailureInjector injector) throws Exception {
     */
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
     * (we dropped unregister but the framework doesn't own it) is acceptable.
        assertBusy(() -> {
    }
            sb.append(c.getClass().getName()).append(':').append(c.getMessage()).append('\n');
                .isAcknowledged()
    }
    // residual tasks of any of the three actions.
     * to 1 so a GROUP BY aggregation trips the native memory pool on the shard. The native error
import org.opensearch.analytics.AnalyticsPlugin;
                "shard cancellation must surface as TaskCancelledException or a gRPC cancellation teardown, not a generic "
package org.opensearch.analytics.cancellation;
        assertNoResidualTasks(FragmentExecutionAction.NAME);
        }
                .isAcknowledged()
            .put("index.pluggable.dataformat.enabled", true)
                "a shard-side native pool trip must surface as HTTP 429 (got " + failure.getClass().getName() + ": " + failure
            mts.addRequestHandlingBehavior(action, (handler, request, channel, task) -> injector.inject(channel, node));
        CountDownLatch released = new CountDownLatch(1);
    }
            }
            Version.CURRENT,
    public void testShardTaskCancelledExceptionTearsDownQueryAndCleansUp() throws Exception {
                .isAcknowledged()
        assertQtfInjectedFailureSurfacesAndCleansUp(
    private interface FailureInjector {
     * leak (we kept manual unregister AND framework unregister → double-free) nor a dangling task
    private static RestStatus firstStatus(Throwable t, RestStatus target) {
                logger.info("query terminated as expected after analytics/query cancel: {}", e.getMessage());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);
                    + "'Stage N failed' ISE (got chain: " + renderedChain(failure) + ")",
            PPLResponse response = null;
    /** Returns {@code target} if any OpenSearchException in {@code t}'s cause chain reports it, else null. */
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        return Settings.builder()
    private static final int VALUE = 7;
    /** Sends an injected error on a transport channel for the named victim node. */
     * The REAL native pool-exhaustion path (no injection): squeeze {@code datafusion.memory_pool_limit_bytes}
    public void testCancelAnalyticsQueryTaskTerminatesQueryAndCleansUp() throws Exception {
                .get()
    private void createAndSeedQtfIndex() throws Exception {
            assertTrue(
     * regression guard for dropping the manual {@code taskManager.unregister}: the framework
     * Cancelling the framework {@code AnalyticsQueryAction} task terminates the in-flight query
        CreateIndexResponse response = client().admin()
 *
            // Contract: the shard cancellation must reach the coordinator as a recognizable cancellation,
                assertEquals("seed not yet visible", EXPECTED_SUM, actual);
        Settings indexSettings = Settings.builder()
        try {
        return "source = " + QTF_INDEX + " | sort sortkey | head 20 | fields payload";
 * <p>PR 9 routes every analytics query through {@code client.execute(AnalyticsQueryAction, ...)}
        assertNoResidualTasks(FetchByRowIdsAction.NAME);
 * SPDX-License-Identifier: Apache-2.0
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
    private static final Logger logger = LogManager.getLogger(AnalyticsQueryTaskCleanupIT.class);
        );
                status
        String rendered = sb.toString();
            } catch (Throwable t) {
    /** Injects {@code injector} on {@code action} of a QTF query, asserts it fails, and verifies no residual tasks. */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    private static final String INDEX = "analytics_task_cleanup_idx";
     * the data node by the backend's {@code convertException} SPI ({@code NativeErrorConverter}) before it
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            PPLResponse response = executePPL(qtfQuery(), QUERY_TIMEOUT);
        }
                response = executePPL("source = " + INDEX + " | sort value | head 50", QUERY_TIMEOUT);
import org.opensearch.common.settings.Settings;
import org.opensearch.plugins.Plugin;
            .put("index.pluggable.dataformat", "composite")
            // Both are acceptable; a plain "Stage N failed" with no cancellation signal is the bug.
                .cluster()
    // stage (SBP) or a breaker mid-fetch leaves the LateMaterialization stage draining with a cancelled
     * crosses transport, then tagged RESOURCE_EXHAUSTED ({@code AnalyticsTransportErrors.toWireError}) and
        // regardless of which node(s) the 2 shards were allocated to.
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;
import java.util.Collection;
 *
        } finally {
     * ("top memory consumers / query_untracked(...) consumed N MB"). Exercises BOTH the shard→coordinator
    // ---- QTF (query-then-fetch / late-materialization) index ----
    }
    private static final String QTF_INDEX = "analytics_qtf_cleanup_idx";
public class AnalyticsQueryTaskCleanupIT extends OpenSearchIntegTestCase {
        );
            // The contract is the STATUS (429), not a specific class: a native pool/admission trip is
    /** Asserts no raw native allocator internals leak into the rendered exception chain shown to the user. */
            // valid race outcomes depending on which shard's failure wins:
        }
        for (String node : internalCluster().getDataNodeNames()) {
 * The OpenSearch Contributors require contributions made to
        }
     * production SBP-cancel path.
            // anywhere in the surfaced cause chain.
     * data-node conversion the raw native error crosses as a typeless INTERNAL error and surfaces as HTTP 500
            // timeout, and the surfaced error must reflect cancellation, not a generic 500/hang.
            "can spill",
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
        return sb.toString();
        // allocation may place both shards on one node, so a single-victim injection can miss every fragment
            });
        try {
                .prepareUpdateSettings()
            } catch (Throwable t) {
    public void testQtfFragmentCancelTearsDownAndCleansUp() throws Exception {
    /**
                // StreamException(CANCELLED). This exercises the half that crosses the wire + the coordinator's
    @Override
import org.opensearch.common.unit.TimeValue;
    public void testQtfFetchCancelTearsDownAndCleansUp() throws Exception {
 * Verifies the framework-task lifecycle for the analytics query action
            }
        }
        }, 30, TimeUnit.SECONDS);
            "1.8",
    // `payload`. Multi-shard so the rewriter engages.
        for (String leak : new String[] {
            "NA",
    private static String renderedChain(Throwable t) {
            // Either it surfaces as a failure (expected) or returns — but it must NOT hang past the
     */
            .setSettings(indexSettings)
                firstStatus(failure, RestStatus.TOO_MANY_REQUESTS)
                    new StreamException(StreamErrorCode.CANCELLED, "task cancelled by search backpressure on " + node)
        createAndSeedQtfIndex();
            logger.info(
            assertFalse(
            client().admin()
            .put("index.pluggable.dataformat.enabled", true)
import java.util.List;
            //      that stream surfaces gRPC's generic cancellation teardown ("Internal error [task_id=N]").
            CompositeDataFormatPlugin.class,
            "already reserved",
                // Expected: the query terminated due to cancellation rather than completing.
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");
        assertTrue(
     */
            // Reset so other tests / teardown aren't starved.
    }
    /** Flattens an exception's cause chain to a single string (class:message per level) for substring checks. */
        createAndSeedIndex();
    }
        assertQtfInjectedFailureSurfacesAndCleansUp(
            }
import java.util.concurrent.Future;
     * parent and the coordinator task leaks (phantom). This is the closest IT analogue of the
                .cluster()
            // converted on the data node to either a CircuitBreakingException or an OpenSearchStatusException
    private static final int DOCS_PER_SHARD = 50;
        }
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            "RepartitionExec",
            .build();
        // Inject on every data node: with 2 shards / 0 replicas across 2 nodes, allocation may place both
    /** The QTF query: sort by sortkey, head N, project the fetch-only payload column → fires late materialization. */
    protected Collection<PluginInfo> additionalNodePlugins() {
        assertTrue(
    private static final int NUM_SHARDS = 2;
import org.opensearch.ExceptionsHelper;
                .cluster()
    }
    public void testRealNativePoolExhaustionSurfacesAs429AndCleansUp() throws Exception {
            "batch_size",
                response,
        List<MockTransportService> mtsList = new java.util.ArrayList<>();
        // Block every data node's shard handler so cancellation lands while the query is in-flight,
        assertNoResidualTasks(FetchByRowIdsAction.NAME);
                .prepareUpdateSettings()
 * ({@link AnalyticsQueryAction}, {@code indices:data/read/analytics/query}).
            assertNoNativeLeak(failure);
 */
        for (int i = 0; i < TOTAL_DOCS; i++) {
            .put("index.pluggable.dataformat", "composite")
/**
        createAndSeedQtfIndex();
        assertNoResidualTasks(FragmentExecutionAction.NAME);
                .get();
            assertEquals("QTF seed not yet visible", (long) QTF_DOCS, ((Number) r.getRows().get(0)[r.getColumns().indexOf("c")]).longValue());
    // A `sortkey` to order by + a fetch-only `payload` (index=false) projected ABOVE the sort anchor.
            boolean isGrpcCancelTeardown = renderedChain(failure).contains("Internal error [task_id=");
                handler.messageReceived(request, channel, task);
            // NOT the old bare RuntimeException("Stage N failed") ISE a client would retry. There are two
            );
     * query shape (we flip a flag from a pass-through {@code FetchByRowIdsAction} behavior — if the
    }
    /**
import org.opensearch.transport.stream.StreamErrorCode;
        createAndSeedIndex();
                .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", 1L))
        }
    private static String qtfQuery() {
        // Inject on EVERY data node, not a single random victim: with 2 shards / 0 replicas across 2 nodes,
            PPLResponse response = null;
                    .getMessage() + ")",
    /**
                failure = t;
    // child, stranding the parent unless CANCELLED is propagated. These tests inject failures on BOTH
import java.util.concurrent.ExecutionException;
            }
 * <p>These tests assert the two cleanup guarantees that depend on dropping the old manual
import org.opensearch.ppl.action.PPLResponse;
            .indices()
                    released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
import org.opensearch.plugins.PluginInfo;
                failure == null ? "none" : failure.getClass().getName() + ": " + failure.getMessage()
        }
