        }
            return Collections.singletonList(TestTransportAction.ACTION);
     * before busy-waiting for cancellation. The hook receives the task id assigned by
    }
 * <p>Native-memory tracking depends on three things being true at SBP-construction time:
        @Override
     * {@code search_backpressure.mode = disabled} short-circuits the entire {@code doRun} loop
        BUDGET_BYTES.set(DEFAULT_BUDGET_BYTES);
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
import java.util.HashMap;
 * SPDX-License-Identifier: Apache-2.0
        public void onFailure(Exception e) {
     * Native-memory threshold setting explicitly set to {@code 0.0} (the rollout-gate inert state).
import java.util.Collections;
     * A request whose handler-side hook lets each test publish a per-task snapshot entry
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.5)
    public final void setupNodeSettings() {
 * {@code DataFusionPlugin} uses. The first and third are checked via {@code assumeTrue} so the
     */
    /**
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
     * The shard task's reported native bytes exceed {@code budget * fraction}; SBP must cancel
        );
        }
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
import org.opensearch.test.OpenSearchIntegTestCase;
     */
import org.opensearch.common.settings.Settings;
        @Override
import java.util.concurrent.CountDownLatch;
     * must NOT cancel even though native-memory duress is active. This pins the contract that
     * Per-task threshold is set, but the published bytes are below the evaluator's cutoff. SBP
        Settings request = Settings.builder()
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        @Override
import static org.hamcrest.Matchers.containsString;
                        listener.onResponse(new TestResponse());
        public void writeTo(StreamOutput out) throws IOException {
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
    public static class TestTransportAction extends HandledTransportAction<TestRequest, TestResponse> {
     * duress alone doesn't kill tasks — the evaluator decides per task.
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
                    // (default 1s); the loop must outlive at least two ticks for the duress
    }
            threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {
     * In {@code monitor_only} mode, SBP must log breaches but never invoke
        assumeTrue("native-memory backpressure path is Linux-only (OsProbe.getProcessNativeMemoryBytes)", Constants.LINUX);
     * with a "native memory usage exceeded" reason when running in {@code enforced} mode.
            Environment environment,
            this.threadPool = threadPool;
        assertAcked(
import org.opensearch.action.ActionRequest;
import org.opensearch.tasks.Task;
    private static final TimeValue TIMEOUT = new TimeValue(10, TimeUnit.SECONDS);
public class NativeMemorySearchBackpressureIT extends OpenSearchIntegTestCase {
import org.opensearch.core.tasks.TaskCancelledException;
            SearchShardTask task = new SearchShardTask(id, type, action, "native-memory-it", parentTaskId, headers);
     */
        @Override
import org.hamcrest.MatcherAssert;
/*
        client().execute(TestTransportAction.ACTION, new TestRequest(taskId -> SNAPSHOT.put(taskId, 999L * 1024L * 1024L)), listener);
            latch.countDown();
        assertTrue(
            org.opensearch.core.common.io.stream.NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
            return exception;
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "1b")
        }
        }
 * compatible open source license.
            this.publisher = publisher;
        }
import static org.hamcrest.Matchers.instanceOf;
        assertTrue("task should have been cancelled within " + TIMEOUT, listener.latch.await(TIMEOUT.getSeconds() * 2, TimeUnit.SECONDS));
    }
            NativeMemoryUsageTracker.setSnapshotSupplier(() -> new HashMap<>(SNAPSHOT));
            super.writeTo(out);
        @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            listener
            // strictly above, so the evaluator must produce a cancellation reason.
 * The OpenSearch Contributors require contributions made to
            .put(NodeDuressSettings.SETTING_NUM_SUCCESSIVE_BREACHES.getKey(), 1)
 * <ol>
     * {@code createComponents} — same boot-time hook the production DataFusion plugin uses.
     * suppliers are visible when {@code isNativeTrackingSupported()} is evaluated.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    // Busy-wait for cancellation or timeout. SBP runs every interval_millis
        public TestRequest(SnapshotPublisher publisher) {
 *
            .build();
    /** Side-channel for tests to inject the per-task snapshot reading at task-creation time. */
        public TestResponse(StreamInput in) {}
 * Integration tests for the native-memory path of {@link SearchBackpressureService}.
            NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(BUDGET_BYTES::get);
    /**
        assertNull("disabled mode must not cancel", listener.getException());
            Client client,
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public void testSearchShardTaskCancellationWithHighNativeMemory() throws InterruptedException {
import org.opensearch.common.inject.Inject;
        );
import org.opensearch.search.backpressure.settings.NodeDuressSettings;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.unit.TimeValue;
        }
                    // streak to trip and the cancel decision to fire.
     * {@code TaskManager.register}, which is the same id SBP looks up in the snapshot.
        assertNull("Per-task fraction explicitly set to 0 — the tracker must not cancel", listener.getException());
    /**
        public static final ActionType<TestResponse> ACTION = new ActionType<>("internal::native_memory_bp_test_action", TestResponse::new);
        private final ThreadPool threadPool;
     * Per-task-id native bytes published into {@link NativeMemoryUsageTracker}'s snapshot
import java.util.concurrent.ConcurrentHashMap;
     */
import org.opensearch.plugins.Plugin;
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
 *   <li>The host is Linux (so {@code OsProbe.getProcessNativeMemoryBytes()} is non-negative).</li>
                } catch (Exception e) {
            ResourceWatcherService resourceWatcherService,
        );
            return task;
import org.opensearch.script.ScriptService;
            listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS)
import org.opensearch.repositories.RepositoriesService;
            IndexNameExpressionResolver indexNameExpressionResolver,
    }
 *   <li>{@code OsProbe.getInstance().getTotalPhysicalMemorySize() &gt; 0}.</li>
            // Threshold = 0.9 of 1 GiB ≈ 922 MiB. Snapshot publishes 100 MiB — well under.
            Supplier<RepositoriesService> repositoriesServiceSupplier
    private static final AtomicLong BUDGET_BYTES = new AtomicLong(DEFAULT_BUDGET_BYTES);
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "monitor_only")
        assertTrue("task should have completed without cancellation", listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS));
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
            super(in);
            latch.countDown();
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
    public void testDisabledModeShortCircuits() throws InterruptedException {
        SNAPSHOT.clear();
import org.opensearch.transport.client.Client;
                .setPersistentSettings(Settings.builder().putNull("*"))
import org.opensearch.action.support.ActionFilters;
    }
import org.opensearch.transport.TransportService;
import org.opensearch.core.tasks.TaskId;
        return plugins;
        assertNull("SearchShardTask under threshold must not be cancelled by the native-memory tracker", listener.getException());
        SNAPSHOT.clear();
                    if (cancellableTask.isCancelled()) {
                    long startTime = System.nanoTime();
 */
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
            .put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), 0.0)
 * this file be licensed under the Apache-2.0 license or a
                try {
        ) {
        // to 0.0 — any usedFraction above zero counts as a breach. Combined with a tiny
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
     * supplier. Tests mutate this map between requests; the supplier installed by
 *
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
        assertNotNull("SearchShardTask should have been cancelled with TaskCancelledException", caughtException);
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
        private final transient SnapshotPublisher publisher;
                    do {
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
package org.opensearch.search.backpressure;
     * SBP is constructed in {@code Node} <em>after</em> {@code createComponents} runs, so the
import org.opensearch.env.NodeEnvironment;
import org.opensearch.core.common.io.stream.StreamInput;
            publisher.publish(id);
}
        @SuppressForbidden(reason = "Simulating a busy task by sleeping")
/**
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "disabled")
        Settings request = Settings.builder()
    private static final long DEFAULT_BUDGET_BYTES = 1024L * 1024L * 1024L; // 1 GiB
    public final void cleanupNodeSettings() {
            NodeEnvironment nodeEnvironment,
    /**
import java.util.function.Supplier;
        public TestRequest(StreamInput in) throws IOException {
import org.opensearch.watcher.ResourceWatcherService;
import org.opensearch.action.search.SearchShardTask;
        @Override
     * {@code TaskManager.cancelTaskAndDescendants}. The task therefore self-completes.
                        Thread.sleep(50);
            .build();
        }
import java.util.Collection;
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("native memory usage exceeded"));
            return null;
            return Collections.emptyList();
        private volatile Exception exception = null;
            .build();
    public interface SnapshotPublisher {
        private final CountDownLatch latch = new CountDownLatch(1);
            ScriptService scriptService,
import org.junit.Before;
        public void writeTo(StreamOutput out) throws IOException {}
    // -----------------------------------------------------------------------
 *       {@link org.opensearch.search.backpressure.NativeMemoryUsageService} before SBP is built.</li>
        BUDGET_BYTES.set(DEFAULT_BUDGET_BYTES);
import org.opensearch.common.SuppressForbidden;
            // Explicitly set to 0.0 to override the production default and force the inert path.
import org.opensearch.plugins.ActionPlugin;
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
        public List<ActionType<? extends ActionResponse>> getClientActions() {
            // ("totalNative is zero"). 1 byte is enough — the probe reports a non-zero RssAnon.
            NamedXContentRegistry xContentRegistry,
     */
    public static class ExceptionCatchingListener implements ActionListener<TestResponse> {
import org.opensearch.env.Environment;
        public void onResponse(TestResponse r) {
     * Even with heavy reported bytes the tracker must stay silent, because {@code fraction == 0}
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
import org.apache.lucene.util.Constants;
                    } while (cancellableTask.isCancelled() == false && (System.nanoTime() - startTime) < TIMEOUT.getNanos());
import java.util.concurrent.TimeUnit;
    public static class NativeMemoryTestPlugin extends Plugin implements ActionPlugin {
    @FunctionalInterface
    public static class TestResponse extends ActionResponse {
    @Before
            "task should have completed without cancellation in disabled mode",
    }
                .prepareUpdateSettings()
        client().execute(TestTransportAction.ACTION, new TestRequest(taskId -> SNAPSHOT.put(taskId, 768L * 1024L * 1024L)), listener);
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
    public static class TestRequest extends ActionRequest {
        public Exception getException() {
            // Threshold = 0.5 of 1 GiB = 512 MiB. Snapshot publishes 768 MiB for the task —
     * disables evaluation. Pins the spec's "operator can opt out" contract.
            ThreadPool threadPool,
import java.util.List;
            listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS)
import org.opensearch.action.support.HandledTransportAction;
     */
import java.util.ArrayList;
    public void testSearchShardTaskNotCancelledBelowThreshold() throws InterruptedException {
        // Native-memory duress + tracking only engages on Linux; skip otherwise.
        Settings request = Settings.builder()
            TestTransportAction.ACTION,
        @Override
    }
    public void testMonitorOnlyModeDoesNotCancel() throws InterruptedException {
        protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {
 */
                .setTransientSettings(Settings.builder().putNull("*"))
            .put(NodeDuressSettings.SETTING_HEAP_THRESHOLD.getKey(), 1.0) // disable heap duress
import org.opensearch.tasks.CancellableTask;
        public ActionRequestValidationException validate() {
    // -----------------------------------------------------------------------
 *
            .build();
    /**
import static org.junit.Assume.assumeTrue;
            // Use SearchShardTask so SBP picks it up via getTaskByType(SearchShardTask.class).
        assertNull("monitor_only must not cancel", listener.getException());
            ClusterService clusterService,
        Exception caughtException = listener.getException();
        // Force native-memory duress to trip after a single observation by setting the threshold
            this.exception = e;
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            super(ACTION.name(), transportService, actionFilters, TestRequest::new);
        @Override
        Settings request = Settings.builder()
    /**
import org.opensearch.action.ActionRequestValidationException;
        Settings request = Settings.builder()
    public void testTrackerInertWhenPerTaskFractionIsZero() throws InterruptedException {
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.0)
            // node.native_memory.limit must be > 0 or the duress lambda short-circuits
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        assertTrue(
            .put(NodeDuressSettings.SETTING_CPU_THRESHOLD.getKey(), 1.0) // disable CPU duress
     * Installs the snapshot + budget suppliers on {@link NativeMemoryUsageTracker} during
        }
            new TestRequest(taskId -> SNAPSHOT.put(taskId, 4L * 1024L * 1024L * 1024L)), // 4 GiB
    }
            listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS)
import org.opensearch.action.ActionType;
                .cluster()
        plugins.add(NativeMemoryTestPlugin.class);
                    } else {
    private static final Map<Long, Long> SNAPSHOT = new ConcurrentHashMap<>();
    @After
 *   <li>A backend has installed a snapshot supplier on
        public TestTransportAction(TransportService transportService, ThreadPool threadPool, ActionFilters actionFilters) {
    }
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.9)
        public Collection<Object> createComponents(
import java.util.Map;
    /**
                        throw new TaskCancelledException(cancellableTask.getReasonCancelled());
        public TestResponse() {}
            client().admin()
    /**
            .build();
        assertTrue(
import org.opensearch.wlm.WorkloadGroupTask;
import java.io.IOException;
                    CancellableTask cancellableTask = (CancellableTask) task;
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
     * {@link NativeMemoryTestPlugin} reads the live reference on every refresh.
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            "task should have completed without cancellation in monitor_only",
 * and budget suppliers from {@code createComponents}, mirroring the production wiring path
            this.publisher = id -> {};
    }
import org.junit.After;
        );
     */
            });
                    listener.onFailure(e);
    }
        client().execute(TestTransportAction.ACTION, new TestRequest(taskId -> SNAPSHOT.put(taskId, 768L * 1024L * 1024L)), listener);
                }
    /** Reused in-suite instead of importing from {@link SearchBackpressureIT}. */
import org.opensearch.cluster.service.ClusterService;
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.5)
 * suite is skipped on macOS/Windows CI rather than failing.
            return Collections.singletonList(new ActionHandler<>(TestTransportAction.ACTION, TestTransportAction.class));
import org.opensearch.core.action.ActionListener;
    }
     */
        @Override
     * snapshot reading.
            .build();
import org.opensearch.core.action.ActionResponse;
import java.util.concurrent.atomic.AtomicLong;
        // Task self-completes after TIMEOUT; allow extra room.
        Settings request = Settings.builder()
            // Live-reading the static maps so test methods can mutate them between requests.
        void publish(long taskId);
        client().execute(
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.5)
        // numSuccessiveBreaches the duress flips on the next tick deterministically.
        @Inject
        }
 * <p>{@link NativeMemoryTestPlugin} satisfies the second condition by installing fake snapshot
        }
            "task should have completed within " + (TIMEOUT.getSeconds() * 3) + "s",
     * before any tracker is consulted. The task must complete normally even with a heavy
        }
        }
        );
    }
                    }
 * </ol>
                    ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());
    // Test plugin + transport action
        }
    }
    @Override
        client().execute(TestTransportAction.ACTION, new TestRequest(taskId -> SNAPSHOT.put(taskId, 100L * 1024L * 1024L)), listener);
