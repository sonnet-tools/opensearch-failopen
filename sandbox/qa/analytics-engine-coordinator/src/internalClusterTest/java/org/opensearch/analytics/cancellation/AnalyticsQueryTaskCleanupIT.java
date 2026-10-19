            PPLResponse response = executePPL(qtfQuery(), QUERY_TIMEOUT);  
     */
        }
        } finally {
            }  
    }
        assertQtfInjectedFailureSurfacesAndCleansUp(  
            } catch (Throwable t) {  
     * A shard fragment returning a {@link TaskCancelledException} over stream transport — exactly what
import org.opensearch.OpenSearchException;
        }  
 * ({@link AnalyticsQueryAction}, {@code indices:data/read/analytics/query}).  
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
            .put("datafusion.spill_directory", createTempDir().toString())
        return Settings.builder()
            boolean isTaskCancelled = ExceptionsHelper.unwrap(failure, TaskCancelledException.class) != null;
 * and runs it under the framework-provided, cancellable {@code AnalyticsQueryTask} — instead of a  
import org.opensearch.ppl.action.PPLResponse;
            .put("index.pluggable.dataformat", "composite")
        assertNoResidualTasks(FragmentExecutionAction.NAME);
                channel.sendResponse(
import java.util.Collection;
        }
            // Reset so other tests / teardown aren't starved.  
     * data-node conversion the raw native error crosses as a typeless INTERNAL error and surfaces as HTTP 500
import java.util.List;  
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));  
    private void createAndSeedIndex() {
     * QTF sanity + cleanup. Confirms the late-materialization rewriter actually fires on this index +
        assertNoResidualTasks(AnalyticsQueryAction.NAME);  
            // timeout, and the surfaced error must reflect cancellation, not a generic 500/hang.
        // Squeeze the native pool so any aggregation allocation trips it.
     * rebuilt into a breaker at the coordinator ({@code AnalyticsTransportErrors.fromWireError}). Without the
                .get()
    private static final String QTF_INDEX = "analytics_qtf_cleanup_idx";
            client().admin()  
    // residual tasks of any of the three actions.
    /** The QTF query: sort by sortkey, head N, project the fetch-only payload column → fires late materialization. */
 * register/unregister: (1) a successful query leaves no residual analytics/query task (the framework
            );  
            try {
/**
                response = executePPL(qtfQuery(), QUERY_TIMEOUT);  
    // A QTF query has THREE stage levels (shard fragment → late-materialization → reduce) and a second
        assertBusy(() -> {
            //   2. with multiple shards, the failure cascade cancels a sibling's gRPC stream before its  
    // rewriter fire: the query phase emits row-ids, the fetch phase (FetchByRowIdsAction) materializes
     * the query now runs under the framework-provided task; pre-PR-9 the query ran under a detached
    // the query phase (FragmentExecutionAction) and the fetch phase (FetchByRowIdsAction), and assert no  
    @FunctionalInterface  
     * Cancelling the framework {@code AnalyticsQueryAction} task terminates the in-flight query  
        }
            } catch (ExecutionException | TimeoutException e) {  
            assertNotNull("injected failure on " + action + " must fail the QTF query, not return (response=" + response + ")", failure);
import java.util.concurrent.Future;
            // Either it surfaces as a failure (expected) or returns — but it must NOT hang past the  
    }  
        createAndSeedIndex();  
        return sb.toString();
            PPLResponse response = null;
    private PPLResponse executePPL(String ppl) {
            TestPPLPlugin.class,
            .build();  
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;  
import java.util.Collections;
    /** Injects {@code injector} on {@code action} of a QTF query, asserts it fails, and verifies no residual tasks. */  
        assertEquals("query must return the correct sum", EXPECTED_SUM, actual);
    /**
        List<MockTransportService> mtsList = new java.util.ArrayList<>();
            .put("index.pluggable.dataformat.enabled", true)  
 * detached task self-registered inside {@code DefaultPlanExecutor.executeInternal}. Because the task
        );  
        try {
                .setMapping("sortkey", "type=integer", "payload", "type=keyword,index=false")  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
    }
            assertFalse(  
                status
                    Thread.currentThread().interrupt();  
    /** SBP stand-in on the QTF QUERY phase: a cancelled shard fragment must tear down the whole 3-level QTF tree. */  
                // Replacing the handler bypasses the production classify seam (channelResponseHandler.onFailure  
                .get();
            assertTrue(
                handler.messageReceived(request, channel, task);
            //      typed CANCELLED error is flushed (sendError no-ops on an already-cancelled channel), so
        try {
            RestStatus status = firstStatus(failure, RestStatus.TOO_MANY_REQUESTS);  
                .prepareCancelTasks()  
        assertBusy(() -> {
        CreateIndexResponse response = client().admin()  
            .setMapping("value", "type=integer")
        } finally {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)  
        return new PluginInfo(
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
                // → AnalyticsTransportErrors.toWireError), so we inject the post-classification wire form: a
/*  
                .get();
        Settings indexSettings = Settings.builder()
        );
import org.apache.logging.log4j.LogManager;
        // residual fragment tasks, after a bottom-up shard cancel.  
            "1.8",  
        }
 */
                .cluster()
                );  
import org.opensearch.cluster.metadata.IndexMetadata;
 * is now framework-owned, {@code HandledTransportAction} registers it before {@code doExecute} and
                .prepareUpdateSettings()  
                .prepareUpdateSettings()  
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
            mtsList.forEach(MockTransportService::clearAllRules);  
     * 429 and clean teardown.
        assertNoResidualTasks(FragmentExecutionAction.NAME);
            // The contract is the STATUS (429), not a specific class: a native pool/admission trip is
        // shards on one node, so a single-victim injection can miss the fragment and the query succeeds (flake).
                assertEquals("seed not yet visible", EXPECTED_SUM, actual);
            .indices()
 *
            mtsList.forEach(MockTransportService::clearAllRules);  
import org.opensearch.analytics.exec.action.FragmentExecutionAction;  
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD;
    }
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
     * self-registered task, so cancelling the framework action had no effect on it.  
        );  
            PPLResponse r = executePPL("source = " + QTF_INDEX + " | stats count() as c");  
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)  
 * SPDX-License-Identifier: Apache-2.0
                .prepareUpdateSettings()
            //      that stream surfaces gRPC's generic cancellation teardown ("Internal error [task_id=N]").
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(action).get();  
import java.util.concurrent.Executors;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = org.opensearch.analytics.resilience.FlightTransportThreadLeakFilter.class)
                    .getMessage() + ")",  
        ensureGreen(INDEX);
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            mts.addRequestHandlingBehavior(FetchByRowIdsAction.NAME, (handler, request, channel, task) -> {
        createAndSeedIndex();
                }
        List<MockTransportService> mtsList = new java.util.ArrayList<>();
            Throwable failure = null;  
        // regardless of which node(s) the 2 shards were allocated to.  
                "[sbp-cancel] shard TaskCancelledException -> coordinator surfaced: response={}, failure={}",  
    }
                failure == null ? "none" : failure.getClass().getName() + ": " + failure.getMessage()
    }  
        StringBuilder sb = new StringBuilder();  
            pluginClass.getName(),
import org.opensearch.plugins.Plugin;
    @Override
     */
            mtsList.add(mts);  
     */
    /** Asserts no raw native allocator internals leak into the rendered exception chain shown to the user. */
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            "classpath plugin",  
    /**
    public void testRealNativePoolExhaustionSurfacesAs429AndCleansUp() throws Exception {  
            mtsList.forEach(MockTransportService::clearAllRules);  
    }
     * that does NOT touch the coordinator action) — must tear down the whole query cleanly: the  
            assertNoNativeLeak(failure);
    }
        assertNoResidualTasks(AnalyticsQueryAction.NAME);  
     * leak (we kept manual unregister AND framework unregister → double-free) nor a dangling task
import org.opensearch.core.tasks.TaskCancelledException;
            "GroupedHashAggregateStream",
            .put(FeatureFlags.STREAM_TRANSPORT, true)
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            extendedPlugins,  
        assertNoResidualTasks(FragmentExecutionAction.NAME);
            Version.CURRENT,
 */  
                response,
     * or fetch tasks.
            assertFalse("QTF query must return rows", response.getRows().isEmpty());
            client().admin()  
        }  
        }, 30, TimeUnit.SECONDS);
     * below are testing the wrong thing). A successful QTF query must leave no residual query, fragment,
    public void testSuccessfulQueryLeavesNoResidualAnalyticsTask() throws Exception {
    /**  
        // Force the parquet commit visible before measuring.
import org.opensearch.be.datafusion.DataFusionPlugin;  
            .putList("index.composite.secondary_data_formats")  
        }
                .setActions(AnalyticsQueryAction.NAME)
    private static final Logger logger = LogManager.getLogger(AnalyticsQueryTaskCleanupIT.class);
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;
        } finally {
            null,
            pluginClass.getName(),
     * transport path and the cause sanitization.
            "query_untracked",
        void inject(org.opensearch.transport.TransportChannel channel, String victim) throws Exception;
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;  
        }
        ExecutorService exec = Executors.newSingleThreadExecutor();
                .isAcknowledged()  
                response = executePPL("source = " + INDEX + " | sort value | head 50", QUERY_TIMEOUT);
                response = executePPL("source = " + INDEX + " | stats count() by value", QUERY_TIMEOUT);  
        // (the query then succeeds and the test flakes). Injecting everywhere fails the fragment wherever it runs.
        } finally {
import org.opensearch.arrow.allocator.ArrowBasePlugin;
     * query shape (we flip a flag from a pass-through {@code FetchByRowIdsAction} behavior — if the
    /** Sends an injected error on a transport channel for the named victim node. */
                .setTransientSettings(Settings.builder().putNull("datafusion.memory_pool_limit_bytes"))  
            assertBusy(() -> {
        String rendered = sb.toString();
                    new StreamException(StreamErrorCode.CANCELLED, "task cancelled by search backpressure on " + node)
            client().prepareIndex(QTF_INDEX).setSource("sortkey", i, "payload", "row-" + i).get();  
        } finally {
import org.apache.logging.log4j.Logger;
 * unregistered it), and (2) cancelling the analytics/query task terminates the query and leaves no
        );  
import org.opensearch.test.transport.MockTransportService;
            try {
                assertFalse("analytics/query task should be running", live.getTasks().isEmpty());
    // `payload`. Multi-shard so the rewriter engages.  
                fetchDispatched.set(true);  
import java.util.concurrent.atomic.AtomicBoolean;
        // The phantom-task contract: no stranded coordinator query task, no residual fragment/fetch tasks.
 * this file be licensed under the Apache-2.0 license or a
        createAndSeedQtfIndex();
                ListTasksResponse live = client().admin().cluster().prepareListTasks().setActions(AnalyticsQueryAction.NAME).get();  
            CancelTasksResponse cancel = client().admin()
            Throwable failure = null;  
import java.util.concurrent.ExecutorService;  
            );  
        for (int i = 0; i < TOTAL_DOCS; i++) {  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        createAndSeedIndex();
            PPLResponse response = null;  
            );  
            mtsList.add(mts);
package org.opensearch.analytics.cancellation;
        assertNoResidualTasks(FragmentExecutionAction.NAME);
    private static final int VALUE = 7;
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();  
    private static void assertNoNativeLeak(Throwable t) {
                .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", 1L))  
    /**
        }  
        return List.of(
            .get();
    private void createAndSeedQtfIndex() throws Exception {
                cancel.getNodeFailures() != null && cancel.getNodeFailures().isEmpty() == false
            (channel, victim) -> channel.sendResponse(new TaskCancelledException("sbp cancel (qtf query phase) on " + victim))
        } catch (Exception e) {  
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
            assertNotNull("a cancelled shard must fail the query, not silently return a result (response=" + response + ")", failure);
    // `source = QTF_INDEX | sort sortkey | head N | fields payload` makes the LateMaterialization
 * compatible open source license.
    }
            client().admin()
            // Contract: the shard cancellation must reach the coordinator as a recognizable cancellation,
        }  
        for (String node : internalCluster().getDataNodeNames()) {  
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;  
        assertTrue(  
            assertEquals(
     */
        );
            PPLResponse response = null;  
     */
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            logger.info(
        try {
                return ose.status();
    private static String qtfQuery() {  
                handler.messageReceived(request, channel, task);
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
    @Override  
            mtsList.add(mts);  
        }  
        try {
            }
            "already reserved",  
            assertBusy(() -> {
                "a native memory-pool trip must surface as HTTP 429 (got " + failure.getClass().getName() + ": " + failure
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
                firstStatus(failure, RestStatus.TOO_MANY_REQUESTS)
            assertTrue("residual " + action + " tasks: " + tasks.getTasks(), tasks.getTasks().isEmpty());
import java.util.concurrent.CountDownLatch;
    private PPLResponse executePPL(String ppl, TimeValue timeout) {
        // Block every data node's shard handler so cancellation lands while the query is in-flight,
        createAndSeedIndex();
            try {
            "top memory consumers",  
import org.opensearch.common.util.FeatureFlags;
            assertFalse("native detail '" + leak + "' must not leak to the user, got: " + rendered, rendered.contains(leak));
    protected Collection<PluginInfo> additionalNodePlugins() {  
            // anywhere in the surfaced cause chain.
            });
            Throwable failure = null;
    /** Flattens an exception's cause chain to a single string (class:message per level) for substring checks. */
                "[qtf-inject] action={} -> response={}, failure={}",
            });
        ensureGreen(QTF_INDEX);
import org.opensearch.analytics.AnalyticsPlugin;  
     * Search BackPressure does when it cancels a leaf {@code AnalyticsShardTask} (the bottom-up cancel
import org.opensearch.transport.TransportService;  
                .get();
            try {
                logger.info("query terminated as expected after analytics/query cancel: {}", e.getMessage());
import org.opensearch.analytics.exec.action.FetchByRowIdsAction;
    }  
            }, 30, TimeUnit.SECONDS);
            client().admin()
    // ---------------------------------------------------------------- QTF (query-then-fetch) tests  
    }  
    // ---- QTF (query-then-fetch / late-materialization) index ----
        CountDownLatch released = new CountDownLatch(1);
import org.opensearch.composite.CompositeDataFormatPlugin;
    private static final int QTF_DOCS = 200;
    }
                RestStatus.TOO_MANY_REQUESTS,
        for (String node : internalCluster().getDataNodeNames()) {  
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
            } catch (Throwable t) {
            }  
            exec.awaitTermination(5, TimeUnit.SECONDS);
            "avg_row_bytes" }) {
                // StreamException(CANCELLED). This exercises the half that crosses the wire + the coordinator's
     * StageExecution attachChildren CANCELLED-propagation fix, a cancelled shard stage strands its
 * propagates into the running query.
        Settings indexSettings = Settings.builder()  
    }  
                } catch (InterruptedException ie) {
            false
            assertNoNativeLeak(failure);
        }
public class AnalyticsQueryTaskCleanupIT extends OpenSearchIntegTestCase {  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
     * staging shape (high-q07..q10). The shard fragment trips the pool, the breaker crosses stream
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);  
import org.opensearch.test.OpenSearchIntegTestCase;
            sb.append(c.getClass().getName()).append(':').append(c.getMessage()).append('\n');
     * coordinator query task AND the fragment tasks must both unregister. Without the
     * transport, and must surface to the user as HTTP 429 with NO leaked native allocator dump
     * The REAL native pool-exhaustion path (no injection): squeeze {@code datafusion.memory_pool_limit_bytes}
    public void testQtfQueryFiresFetchPhaseAndLeavesNoResidualTasks() throws Exception {
            .build();
                .setTransientSettings(Settings.builder().putNull("datafusion.memory_pool_limit_bytes"))
    public void testQtfFragmentCancelTearsDownAndCleansUp() throws Exception {
    }
        assertNoResidualTasks(FragmentExecutionAction.NAME);
        );  
     * the data node by the backend's {@code convertException} SPI ({@code NativeErrorConverter}) before it
            "can spill",
    private static RestStatus firstStatus(Throwable t, RestStatus target) {
        );  
 * <p>PR 9 routes every analytics query through {@code client.execute(AnalyticsQueryAction, ...)}
        assertNoResidualTasks(FragmentExecutionAction.NAME);  
import org.opensearch.core.rest.RestStatus;  
                response,
                    + "'Stage N failed' ISE (got chain: " + renderedChain(failure) + ")",
        assertTrue(
            } catch (Throwable t) {
     * ("top memory consumers / query_untracked(...) consumed N MB"). Exercises BOTH the shard→coordinator  
            // NOT the old bare RuntimeException("Stage N failed") ISE a client would retry. There are two  
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
            CompositeDataFormatPlugin.class,
        StringBuilder sb = new StringBuilder();  
    protected Settings nodeSettings(int nodeOrdinal) {  
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            boolean isGrpcCancelTeardown = renderedChain(failure).contains("Internal error [task_id=");
        List<MockTransportService> mtsList = new java.util.ArrayList<>();
        AtomicBoolean fetchDispatched = new AtomicBoolean(false);
    @Override
        for (String node : internalCluster().getDataNodeNames()) {  
import org.opensearch.ppl.TestPPLPlugin;  
        }
     * unregisters the task it created for {@code doExecute} once the listener settles, so neither a
     * rewriter didn't engage, no fetch is dispatched and the assertion fails, telling us the QTF tests  
            );
     * (no hang) and leaves no residual analytics/query or fragment tasks. This only works because
    }  
        } finally {
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
        assertTrue(
            if (c instanceof OpenSearchException ose && ose.status() == target) {  
    /** SBP stand-in on the QTF FETCH phase: a cancelled fetch must tear down the whole 3-level QTF tree. */  
            .put("index.pluggable.dataformat", "composite")  
                "late-materialization rewriter must fire (FetchByRowIdsAction dispatched) — otherwise the QTF "  
    }  
        createAndSeedQtfIndex();
            }  
    // ---------------------------------------------------------------- fixture  
            ArrowBasePlugin.class,  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            // (admission-rejected), both of which report TOO_MANY_REQUESTS. Find the 429-bearing exception
            Throwable failure = null;
import org.opensearch.Version;
            .build();  
    private static String renderedChain(Throwable t) {
            );  
    public void testQtfFetchCancelTearsDownAndCleansUp() throws Exception {
            try {
            .put(super.nodeSettings(nodeOrdinal))
    // stage (SBP) or a breaker mid-fetch leaves the LateMaterialization stage draining with a cancelled
            exec.shutdownNow();
            MockCommitterEnginePlugin.class
                    .getMessage() + ")",  
        }  
            assertNotNull("shard sort pool exhaustion must fail the query (response=" + response + ")", failure);  
        assertNoResidualTasks(AnalyticsQueryAction.NAME);  
        for (String node : internalCluster().getDataNodeNames()) {  
        // allocation may place both shards on one node, so a single-victim injection can miss every fragment  
                failure == null ? "none" : failure.getClass().getName() + ": " + failure.getMessage()
 * The OpenSearch Contributors require contributions made to  
                "cancel must not report node failures",
        try {  
import java.util.concurrent.ExecutionException;
                "a shard-side native pool trip must surface as HTTP 429 (got " + failure.getClass().getName() + ": " + failure
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        );
                failure = t;
        for (int i = 0; i < QTF_DOCS; i++) {
    private static final int DOCS_PER_SHARD = 50;  
            released.countDown();
            // Allow dispatch + shard handler entry so the analytics/query task is live.
                .isAcknowledged()
            PPLResponse response = null;
            MockTransportService.TestPlugin.class,  
        // The contract that matters for the stuck-task issue: NO phantom coordinator query task, no
        }  
import org.opensearch.transport.stream.StreamException;
        return "source = " + QTF_INDEX + " | sort sortkey | head 20 | fields payload";
 * unregisters it when the listener settles, and a client disconnect / explicit cancel of that task  
        return List.of(
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
            assertTrue(  
        assertNoResidualTasks(FetchByRowIdsAction.NAME);  
 *
    /**
            .put("index.pluggable.dataformat.enabled", true)
    }
    private void assertNoResidualTasks(String action) throws Exception {
                .cluster()
    }  
import org.opensearch.transport.stream.StreamErrorCode;
     * regression guard for dropping the manual {@code taskManager.unregister}: the framework  
        createAndSeedIndex();  
            .put("index.composite.primary_data_format", "parquet")
        // Inject on every data node: with 2 shards / 0 replicas across 2 nodes, allocation may place both  
        }  
     * parent and the coordinator task leaks (phantom). This is the closest IT analogue of the  
                failure = t;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
        }, 10, TimeUnit.SECONDS);
            released.countDown();
                .prepareUpdateSettings()
    public void testCancelAnalyticsQueryTaskTerminatesQueryAndCleansUp() throws Exception {
                action,  
                "shard cancellation must surface as TaskCancelledException or a gRPC cancellation teardown, not a generic "
            "NA",
            );  
                try {  
            throw new AssertionError("timed out waiting for seed visibility", e);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
            FragmentExecutionAction.NAME,
        // Inject on EVERY data node, not a single random victim: with 2 shards / 0 replicas across 2 nodes,
                .get()
            mtsList.add(mts);
    // round of shard work: the fetch phase ({@link FetchByRowIdsAction}). The phantom-task strand the
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            mts.addRequestHandlingBehavior(action, (handler, request, channel, task) -> injector.inject(channel, node));
                .cluster()
            (channel, victim) -> channel.sendResponse(new TaskCancelledException("sbp cancel (qtf fetch phase) on " + victim))
    }
            // converted on the data node to either a CircuitBreakingException or an OpenSearchStatusException  
            } catch (Throwable t) {  
    /** Returns {@code target} if any OpenSearchException in {@code t}'s cause chain reports it, else null. */  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;  
            assertEquals(
        assertNoResidualTasks(FetchByRowIdsAction.NAME);
                .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", 1L))
        return null;
    // StageExecution attachChildren fix addresses is reachable here in production: a cancelled shard  
            client().admin()
            }
                .cluster()
                .isAcknowledged()
            }, 10, TimeUnit.SECONDS);
     * Real native pool exhaustion through a SORT/LIMIT (TopK) query on a MULTI-SHARD index — the exact  
            .putList("index.composite.secondary_data_formats")
                    released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
                failure = t;
    // A `sortkey` to order by + a fetch-only `payload` (index=false) projected ABOVE the sort anchor.  
                fetchDispatched.get()
 * <p>These tests assert the two cleanup guarantees that depend on dropping the old manual  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .get()
            sb.append(c.getClass().getName()).append(':').append(c.getMessage()).append('\n');
                RestStatus.TOO_MANY_REQUESTS,
    // ---------------------------------------------------------------- tests
                // Expected: the query terminated due to cancellation rather than completing.
            FetchByRowIdsAction.NAME,
            assertEquals("QTF seed not yet visible", (long) QTF_DOCS, ((Number) r.getRows().get(0)[r.getColumns().indexOf("c")]).longValue());
        long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();  
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.plugins.PluginInfo;
 *
            //   1. the cancel propagates as a TaskCancelledException (fromWireError rebuilds it), or
        client().admin().indices().prepareFlush(QTF_INDEX).get();  
     * production SBP-cancel path.
     */  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        client().admin().indices().prepareFlush(INDEX).get();
    private static final int NUM_SHARDS = 2;
import org.opensearch.common.settings.Settings;
 * Verifies the framework-task lifecycle for the analytics query action
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
    private static final String INDEX = "analytics_task_cleanup_idx";
        client().admin().indices().prepareRefresh(INDEX).get();  
    }
    /**  
            assertNotNull("native pool exhaustion must fail the query, not return (response=" + response + ")", failure);
            .setSettings(indexSettings)  
}
                .indices()  
            "batch_size",  
            mtsList.forEach(MockTransportService::clearAllRules);
    public void testShardSortPoolExhaustionSurfacesAs429WithoutLeak() throws Exception {  
            );  
        List<MockTransportService> mtsList = new java.util.ArrayList<>();
                // fromWireError, mirroring what production produces when SBP cancels a shard fragment.  
                .prepareCreate(QTF_INDEX)
import org.opensearch.ExceptionsHelper;  
        }
     * to 1 so a GROUP BY aggregation trips the native memory pool on the shard. The native error  
                response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
     * crosses transport, then tagged RESOURCE_EXHAUSTED ({@code AnalyticsTransportErrors.toWireError}) and  
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);
    }
            });  
        try {
        for (String leak : new String[] {
            logger.info(
    public void testShardTaskCancelledExceptionTearsDownQueryAndCleansUp() throws Exception {  
        assertNoResidualTasks(FragmentExecutionAction.NAME);
            .put("index.composite.primary_data_format", "parquet")
import java.util.concurrent.TimeoutException;
        try {
     * (we dropped unregister but the framework doesn't own it) is acceptable.  
                    + "cancel/breaker tests below exercise a non-QTF plan",
    private interface FailureInjector {
 * residual analytics/query or fragment tasks.  
                isTaskCancelled || isGrpcCancelTeardown  
            .prepareCreate(INDEX)
        client().admin().indices().prepareRefresh(QTF_INDEX).get();
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
                .setSettings(indexSettings)
import org.opensearch.ppl.action.PPLRequest;
    private void assertQtfInjectedFailureSurfacesAndCleansUp(String action, FailureInjector injector) throws Exception {
        createAndSeedQtfIndex();
    }  
            }
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");
            "RepartitionExec",
                .cluster()
     * ("Stage 0 failed"). This is the path {@code MemoryGuardIT} exercises; here we assert the unwrapped  
     * A successful query must leave NO residual {@code AnalyticsQueryAction} task. This is the
     * ("Failed to allocate …") is NOT a {@code CircuitBreakingException} object — it is converted to one on
        assertTrue("index creation must be acknowledged", response.isAcknowledged());  
                failure = t;
    // child, stranding the parent unless CANCELLED is propagated. These tests inject failures on BOTH
            // Both are acceptable; a plain "Stage N failed" with no cancellation signal is the bug.  
    }  
            // valid race outcomes depending on which shard's failure wins:
import java.util.concurrent.TimeUnit;  
        assertQtfInjectedFailureSurfacesAndCleansUp(  
