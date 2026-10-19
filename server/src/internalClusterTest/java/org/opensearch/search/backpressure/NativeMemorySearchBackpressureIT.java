/*  
        assertNull("Per-task fraction explicitly set to 0 — the tracker must not cancel", listener.getException());  
    public static class TestTransportAction extends HandledTransportAction<TestRequest, TestResponse> {
            listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS)  
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
import static org.junit.Assume.assumeTrue;  
            .build();
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            Supplier<RepositoriesService> repositoriesServiceSupplier
            return Collections.singletonList(new ActionHandler<>(TestTransportAction.ACTION, TestTransportAction.class));
    }
    }  
                        Thread.sleep(50);  
            NativeMemoryUsageTracker.setSnapshotSupplier(() -> new HashMap<>(SNAPSHOT));
            .build();
                    long startTime = System.nanoTime();
        assertAcked(  
        public void onFailure(Exception e) {
            new TestRequest(taskId -> SNAPSHOT.put(taskId, 4L * 1024L * 1024L * 1024L)), // 4 GiB
        // Force native-memory duress to trip after a single observation by setting the threshold
        }
    public final void setupNodeSettings() {
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
    private static final Map<Long, Long> SNAPSHOT = new ConcurrentHashMap<>();
            Environment environment,  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());  
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("native memory usage exceeded"));
                } catch (Exception e) {
        assertTrue("task should have been cancelled within " + TIMEOUT, listener.latch.await(TIMEOUT.getSeconds() * 2, TimeUnit.SECONDS));  
import org.opensearch.core.action.ActionResponse;  
        return plugins;  
    @Override
            IndexNameExpressionResolver indexNameExpressionResolver,  
        SNAPSHOT.clear();
        @Override  
            latch.countDown();
        public List<ActionType<? extends ActionResponse>> getClientActions() {  
        public Collection<Object> createComponents(
import java.util.function.Supplier;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
    public static class ExceptionCatchingListener implements ActionListener<TestResponse> {
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")  
        assertTrue(  
 *
     * Per-task threshold is set, but the published bytes are below the evaluator's cutoff. SBP  
     * Per-task-id native bytes published into {@link NativeMemoryUsageTracker}'s snapshot
    @Before  
            listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS)
import org.opensearch.core.action.ActionListener;
            SearchShardTask task = new SearchShardTask(id, type, action, "native-memory-it", parentTaskId, headers);  
            Client client,  
        }  
        assertNotNull("SearchShardTask should have been cancelled with TaskCancelledException", caughtException);  
     * In {@code monitor_only} mode, SBP must log breaches but never invoke
import static org.hamcrest.Matchers.instanceOf;
 *
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "disabled")  
 *   <li>A backend has installed a snapshot supplier on
            return task;
        void publish(long taskId);
    }  
import org.opensearch.transport.client.Client;
                        listener.onResponse(new TestResponse());  
            // Live-reading the static maps so test methods can mutate them between requests.  
import java.util.concurrent.ConcurrentHashMap;  
            // Use SearchShardTask so SBP picks it up via getTaskByType(SearchShardTask.class).
import org.opensearch.common.inject.Inject;
        public ActionRequestValidationException validate() {
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());  
import org.opensearch.action.ActionType;
     */  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
    // -----------------------------------------------------------------------
        private final transient SnapshotPublisher publisher;
        public Exception getException() {
            return exception;
 * and budget suppliers from {@code createComponents}, mirroring the production wiring path
    }  
        SNAPSHOT.clear();
        @Override
    @FunctionalInterface  
import org.opensearch.watcher.ResourceWatcherService;
    }
     * before busy-waiting for cancellation. The hook receives the task id assigned by
            // Explicitly set to 0.0 to override the production default and force the inert path.  
import java.util.concurrent.CountDownLatch;
public class NativeMemorySearchBackpressureIT extends OpenSearchIntegTestCase {
        assumeTrue("native-memory backpressure path is Linux-only (OsProbe.getProcessNativeMemoryBytes)", Constants.LINUX);  
        }
import org.opensearch.action.ActionRequest;
        assertNull("SearchShardTask under threshold must not be cancelled by the native-memory tracker", listener.getException());
import org.opensearch.env.NodeEnvironment;
    }
            listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS)  
     * {@code TaskManager.register}, which is the same id SBP looks up in the snapshot.
        Exception caughtException = listener.getException();
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
            ResourceWatcherService resourceWatcherService,  
        assertTrue("task should have completed without cancellation", listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS));
                    }
                .cluster()
import org.opensearch.common.settings.Settings;  
            return Collections.singletonList(TestTransportAction.ACTION);
     * before any tracker is consulted. The task must complete normally even with a heavy
        @Override
            this.exception = e;  
     * snapshot reading.
import java.util.concurrent.atomic.AtomicLong;  
    public void testSearchShardTaskNotCancelledBelowThreshold() throws InterruptedException {
     * {@link NativeMemoryTestPlugin} reads the live reference on every refresh.  
     * disables evaluation. Pins the spec's "operator can opt out" contract.
     * {@code TaskManager.cancelTaskAndDescendants}. The task therefore self-completes.
     * duress alone doesn't kill tasks — the evaluator decides per task.
            super(in);  
 * {@code DataFusionPlugin} uses. The first and third are checked via {@code assumeTrue} so the  
    private static final AtomicLong BUDGET_BYTES = new AtomicLong(DEFAULT_BUDGET_BYTES);  
                    if (cancellableTask.isCancelled()) {  
            NodeEnvironment nodeEnvironment,
            return null;  
        }
                try {
    public final void cleanupNodeSettings() {  
     * suppliers are visible when {@code isNativeTrackingSupported()} is evaluated.
import java.util.concurrent.TimeUnit;
import org.opensearch.repositories.RepositoriesService;
     * {@code search_backpressure.mode = disabled} short-circuits the entire {@code doRun} loop  
 * <ol>  
    public interface SnapshotPublisher {
    // Test plugin + transport action  
    /**
        Settings request = Settings.builder()
 *  
                .setPersistentSettings(Settings.builder().putNull("*"))
        @Override
        @Override
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
 * <p>{@link NativeMemoryTestPlugin} satisfies the second condition by installing fake snapshot
            this.threadPool = threadPool;  
import org.hamcrest.MatcherAssert;
        ) {
        public TestRequest(SnapshotPublisher publisher) {
    /**
            .put(NodeDuressSettings.SETTING_NUM_SUCCESSIVE_BREACHES.getKey(), 1)  
        // Task self-completes after TIMEOUT; allow extra room.
import java.util.Map;
    /**
                }
                    ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());  
                        throw new TaskCancelledException(cancellableTask.getReasonCancelled());
    }
    /**
    private static final long DEFAULT_BUDGET_BYTES = 1024L * 1024L * 1024L; // 1 GiB
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
 *   <li>{@code OsProbe.getInstance().getTotalPhysicalMemorySize() &gt; 0}.</li>
    }  
        client().execute(TestTransportAction.ACTION, new TestRequest(taskId -> SNAPSHOT.put(taskId, 768L * 1024L * 1024L)), listener);
import org.opensearch.core.xcontent.NamedXContentRegistry;
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
            // Threshold = 0.9 of 1 GiB ≈ 922 MiB. Snapshot publishes 100 MiB — well under.
        Settings request = Settings.builder()
        }  
     */  
            ThreadPool threadPool,
        assertNull("disabled mode must not cancel", listener.getException());
    /** Reused in-suite instead of importing from {@link SearchBackpressureIT}. */  
        @Inject  
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "1b")  
import org.opensearch.test.OpenSearchIntegTestCase;
            // Threshold = 0.5 of 1 GiB = 512 MiB. Snapshot publishes 768 MiB for the task —
        }
    public static class TestRequest extends ActionRequest {
            return Collections.emptyList();  
import org.opensearch.cluster.service.ClusterService;  
 * </ol>
        );
        public TestResponse(StreamInput in) {}
                .setTransientSettings(Settings.builder().putNull("*"))
import org.opensearch.plugins.ActionPlugin;  
import org.opensearch.action.search.SearchShardTask;
            threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {  
import org.junit.Before;  
            .put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), 0.0)
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
import org.opensearch.action.support.HandledTransportAction;
        ExceptionCatchingListener listener = new ExceptionCatchingListener();  
    public static class NativeMemoryTestPlugin extends Plugin implements ActionPlugin {  
import static org.hamcrest.Matchers.containsString;
                    } else {
        }
        @Override
        }  
            this.publisher = id -> {};
     */
        public TestTransportAction(TransportService transportService, ThreadPool threadPool, ActionFilters actionFilters) {
        @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.5)  
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")  
                    do {
import org.opensearch.action.ActionRequestValidationException;  
            publisher.publish(id);
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.5)
            .put(NodeDuressSettings.SETTING_CPU_THRESHOLD.getKey(), 1.0) // disable CPU duress  
        // Native-memory duress + tracking only engages on Linux; skip otherwise.
            super(ACTION.name(), transportService, actionFilters, TestRequest::new);
    }  
import org.opensearch.env.Environment;  
            TestTransportAction.ACTION,
        assertTrue(
     */  
    /**  
        Settings request = Settings.builder()
    public static class TestResponse extends ActionResponse {
    /**  
    public void testSearchShardTaskCancellationWithHighNativeMemory() throws InterruptedException {
     * Even with heavy reported bytes the tracker must stay silent, because {@code fraction == 0}  
import org.opensearch.action.support.ActionFilters;  
            // ("totalNative is zero"). 1 byte is enough — the probe reports a non-zero RssAnon.
    }
        public static final ActionType<TestResponse> ACTION = new ActionType<>("internal::native_memory_bp_test_action", TestResponse::new);  
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
            latch.countDown();
            // strictly above, so the evaluator must produce a cancellation reason.
        }
     * with a "native memory usage exceeded" reason when running in {@code enforced} mode.
     * {@code createComponents} — same boot-time hook the production DataFusion plugin uses.
import java.util.HashMap;  
package org.opensearch.search.backpressure;
import org.opensearch.wlm.WorkloadGroupTask;  
     * must NOT cancel even though native-memory duress is active. This pins the contract that
            .build();
    /**  
        }  
        client().execute(TestTransportAction.ACTION, new TestRequest(taskId -> SNAPSHOT.put(taskId, 100L * 1024L * 1024L)), listener);
import org.opensearch.common.SuppressForbidden;
        @Override  
            // node.native_memory.limit must be > 0 or the duress lambda short-circuits
 * The OpenSearch Contributors require contributions made to  
 *   <li>The host is Linux (so {@code OsProbe.getProcessNativeMemoryBytes()} is non-negative).</li>
import org.opensearch.tasks.CancellableTask;
            ClusterService clusterService,
        BUDGET_BYTES.set(DEFAULT_BUDGET_BYTES);
        assertTrue(
            .build();
    }
import java.util.List;
            NamedXContentRegistry xContentRegistry,
        Settings request = Settings.builder()
        private final ThreadPool threadPool;
 * Integration tests for the native-memory path of {@link SearchBackpressureService}.  
import org.junit.After;
}
        client().execute(TestTransportAction.ACTION, new TestRequest(taskId -> SNAPSHOT.put(taskId, 768L * 1024L * 1024L)), listener);  
        }  
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
                    // Busy-wait for cancellation or timeout. SBP runs every interval_millis
/**
import org.opensearch.core.tasks.TaskId;
        client().execute(  
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.9)
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
                    // (default 1s); the loop must outlive at least two ticks for the duress  
        @SuppressForbidden(reason = "Simulating a busy task by sleeping")
import org.opensearch.plugins.Plugin;
import java.util.Collections;
import org.opensearch.common.unit.TimeValue;
        public void onResponse(TestResponse r) {  
            });
        client().execute(TestTransportAction.ACTION, new TestRequest(taskId -> SNAPSHOT.put(taskId, 999L * 1024L * 1024L)), listener);  
    public void testDisabledModeShortCircuits() throws InterruptedException {
     * Installs the snapshot + budget suppliers on {@link NativeMemoryUsageTracker} during
import org.opensearch.search.backpressure.settings.NodeDuressSettings;
    // -----------------------------------------------------------------------
        Settings request = Settings.builder()
import org.opensearch.core.tasks.TaskCancelledException;  
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.0)
            "task should have completed without cancellation in monitor_only",
    private static final TimeValue TIMEOUT = new TimeValue(10, TimeUnit.SECONDS);  
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.5)
    }  
        @Override  
                    // streak to trip and the cancel decision to fire.
            client().admin()
        public void writeTo(StreamOutput out) throws IOException {}
            .put(NodeDuressSettings.SETTING_HEAP_THRESHOLD.getKey(), 1.0) // disable heap duress
 * suite is skipped on macOS/Windows CI rather than failing.
     */  
     * Native-memory threshold setting explicitly set to {@code 0.0} (the rollout-gate inert state).
    /**  
        }
    public void testTrackerInertWhenPerTaskFractionIsZero() throws InterruptedException {  
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "monitor_only")  
            "task should have completed within " + (TIMEOUT.getSeconds() * 3) + "s",
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;  
        );
import org.apache.lucene.util.Constants;
        plugins.add(NativeMemoryTestPlugin.class);
 */  
import org.opensearch.transport.TransportService;  
     * SBP is constructed in {@code Node} <em>after</em> {@code createComponents} runs, so the  
                .prepareUpdateSettings()  
            this.publisher = publisher;
    /** Side-channel for tests to inject the per-task snapshot reading at task-creation time. */
            listener  
import java.io.IOException;
    }  
        );  
            super.writeTo(out);
import org.opensearch.script.ScriptService;  
        // numSuccessiveBreaches the duress flips on the next tick deterministically.
            ScriptService scriptService,
        protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {
import java.util.Collection;
        private volatile Exception exception = null;  
     */
import org.opensearch.threadpool.ThreadPool;
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());  
            org.opensearch.core.common.io.stream.NamedWriteableRegistry namedWriteableRegistry,
        assertNull("monitor_only must not cancel", listener.getException());
        @Override
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        BUDGET_BYTES.set(DEFAULT_BUDGET_BYTES);
import org.opensearch.tasks.Task;  
 *       {@link org.opensearch.search.backpressure.NativeMemoryUsageService} before SBP is built.</li>  
        public TestRequest(StreamInput in) throws IOException {
    @After
            NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(BUDGET_BYTES::get);
        // to 0.0 — any usedFraction above zero counts as a breach. Combined with a tiny  
            .build();
 * <p>Native-memory tracking depends on three things being true at SBP-construction time:
    }  
                    listener.onFailure(e);  
     */  
                    } while (cancellableTask.isCancelled() == false && (System.nanoTime() - startTime) < TIMEOUT.getNanos());
        public void writeTo(StreamOutput out) throws IOException {  
            "task should have completed without cancellation in disabled mode",
     * The shard task's reported native bytes exceed {@code budget * fraction}; SBP must cancel
     */
 */
import java.util.ArrayList;  
                    CancellableTask cancellableTask = (CancellableTask) task;
        );  
     * supplier. Tests mutate this map between requests; the supplier installed by
     * A request whose handler-side hook lets each test publish a per-task snapshot entry  
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        private final CountDownLatch latch = new CountDownLatch(1);
        Settings request = Settings.builder()
        public TestResponse() {}  
 * this file be licensed under the Apache-2.0 license or a
        );
            .build();  
        }
    public void testMonitorOnlyModeDoesNotCancel() throws InterruptedException {
