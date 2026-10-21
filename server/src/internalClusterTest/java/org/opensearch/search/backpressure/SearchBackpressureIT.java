            super(in);
            switch (request.getType()) {
    public static Collection<Object[]> parameters() {
    enum RequestType {
        Exception caughtException = listener.getException();
                        j += i;
            client().admin()
import org.junit.Before;
import org.opensearch.action.ActionType;
        }
                .setTransientSettings(Settings.builder().putNull("*"))
                (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(
import org.opensearch.common.settings.Settings;
import java.util.Collection;
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
        Settings request = Settings.builder()
        }
            listener
                        doWork(request);
        assertNotNull("SearchShardTask should have been cancelled with TaskCancelledException", caughtException);
import org.junit.After;
public class SearchBackpressureIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        @Override
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
                        listener.onResponse(new TestResponse());
        Settings request = Settings.builder().put(SearchTaskSettings.SETTING_CANCELLATION_RATE.getKey(), "0.05").build();
        @SuppressForbidden(reason = "Simulating a slow task by sleeping")
import org.opensearch.action.ActionRequestValidationException;
    public void testCancellationSettingsChanged() {
                        headers
    public void testSearchTaskCancellationWithHighHeapUsage() throws InterruptedException {
            .put(SearchShardTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD.getKey(), 1000)
    public void testSearchTaskCancellationWithHighElapsedTime() throws InterruptedException {
import org.opensearch.plugins.Plugin;
                    id,
        Exception caughtException = listener.getException();
        return () -> description;
        }
            new TestRequest<>(
                RequestType.HIGHER_HEAP,
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("cpu usage exceeded"));
        Exception caughtException = listener.getException();
import org.opensearch.action.support.HandledTransportAction;
                    long i = 0, j = 1, k = 1, iterations = 1000;
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
                case HIGH_HEAP:
    public void testSearchShardTaskCancellationWithHighCpu() throws InterruptedException {
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
                }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
            this.exception = e;
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import org.opensearch.action.ActionRequest;
        public ActionRequestValidationException validate() {
                    }
    public void testSearchCancellationWithBackpressureDisabled() throws InterruptedException {
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
        );
        for (int i = 0; i < MOVING_AVERAGE_WINDOW_SIZE; i++) {
        }
            TestTransportAction.ACTION,
import org.opensearch.search.backpressure.settings.NodeDuressSettings;
        client().execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGH_CPU, SearchShardTask::new), listener);
    @Override
            TestTransportAction.ACTION,
    }
import org.opensearch.common.unit.TimeValue;
        @Override
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
                    headers
import java.util.List;
        private final RequestType type;
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
        }
                RequestType.HIGH_ELAPSED_TIME,
            out.writeEnum(type);
            .build();
        }
            super(ACTION.name(), transportService, actionFilters, TestRequest::new);
            .put(NodeDuressSettings.SETTING_NUM_SUCCESSIVE_BREACHES.getKey(), 1)
        }
        // To build up the heap moving average, we need to hit the same node with multiple requests and then hit the same node with a
            .put(SearchShardTaskSettings.SETTING_TOTAL_HEAP_PERCENT_THRESHOLD.getKey(), 0.0)
            this.type = in.readEnum(RequestType.class);
                        type,
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
        }
                listener
import org.opensearch.tasks.CancellableTask;
package org.opensearch.search.backpressure;
        public TestTransportAction(TransportService transportService, ThreadPool threadPool, ActionFilters actionFilters) {
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
            TestTransportAction.ACTION,
import org.opensearch.test.OpenSearchIntegTestCase;
        client(node).execute(
    public final void setupNodeSettings() {
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
                    parentTaskId,
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        HIGH_ELAPSED_TIME;
        }
            .put(SearchTaskSettings.SETTING_HEAP_PERCENT_THRESHOLD.getKey(), 0.0)
                )
                    Byte[] more_bytes = new Byte[1000000];
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        // request having higher heap usage
            this.taskFactory = taskFactory;
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("cpu usage exceeded"));
            this.threadPool = threadPool;
        assertNotNull("SearchShardTask should have been cancelled with TaskCancelledException", caughtException);
import org.opensearch.core.tasks.TaskId;
            .build();
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
            new TestRequest<>(
        @Inject
            return exception;
import org.opensearch.wlm.WorkloadGroupTask;
        public TestRequest(RequestType type, TaskFactory<T> taskFactory) {
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
                        throw new TaskCancelledException(cancellableTask.getReasonCancelled());
    public SearchBackpressureIT(Settings staticSettings) {
        );
                ),
import org.opensearch.action.search.SearchTask;
        Exception caughtException = listener.getException();
import org.opensearch.common.inject.Inject;
                    descriptionSupplier(description),
import org.opensearch.action.search.SearchShardTask;
        client().execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGH_ELAPSED_TIME, SearchShardTask::new), listener);
        // waiting for the TIMEOUT * 3 time for the request to complete and the latch to countdown.
                    // We are running HIGH_HEAP requests to build up heap moving average and not expect it to get cancelled.
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("elapsed time exceeded"));
            client(node).execute(
                    do {
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
                        descriptionSupplier(description),
import org.opensearch.plugins.ActionPlugin;
import java.util.Map;
            .build();
    }
        Settings request = Settings.builder().put(SearchBackpressureSettings.SETTING_MODE.getKey(), "monitor_only").build();
            .put(NodeDuressSettings.SETTING_HEAP_THRESHOLD.getKey(), 0.0)
        response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get();
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
    }
                    type,
        HIGH_CPU,
        }
        public TestResponse() {}
            .put(SearchTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD.getKey(), 1.0)
    public static class TestResponse extends ActionResponse {
        listener = new ExceptionCatchingListener();
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        assertTrue(
                        action,
        assertNotNull("SearchShardTask should have been cancelled with TaskCancelledException", caughtException);
        );
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
                    (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(
    public static class TestTransportAction extends HandledTransportAction<TestRequest, TestResponse> {
        public RequestType getType() {
import java.util.concurrent.TimeUnit;
        public List<ActionType<? extends ActionResponse>> getClientActions() {
import java.util.Arrays;
    @ParametersFactory
                new TestRequest<>(
                    } while (i < iterations);
            listener
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
                    type,
    public void testSearchShardTaskCancellationWithHighElapsedTime() throws InterruptedException {
import org.opensearch.core.action.ActionResponse;
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        assertEquals(response.getPersistentSettings().get(SearchTaskSettings.SETTING_CANCELLATION_RATE.getKey()), "0.05");
                    break;
                    listener.onFailure(e);
    public interface TaskFactory<T extends Task> {
        @Override
        public CountDownLatch getLatch() {
        public void writeTo(StreamOutput out) throws IOException {
        // Before SearchBackpressureService cancels a task based on its heap usage, we need to build up the heap moving average
import static org.hamcrest.Matchers.instanceOf;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        client().execute(
            this.latch = new CountDownLatch(1);
        @Override
                    type,
import org.opensearch.common.SuppressForbidden;
                        && cancellableTask.isCancelled() == false
    }
                    Byte[] bytes = new Byte[100000];
        );
    @Before
 *
            latch.countDown();
        assertNull("SearchShardTask shouldn't have cancelled for monitor_only mode", caughtException);
        );
import java.util.ArrayList;
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
                try {
            return Collections.singletonList(TestTransportAction.ACTION);
import org.opensearch.action.support.ActionFilters;
        T createTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers);
                    ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());
                    // Doing a busy-wait until task cancellation or timeout.
        assertAcked(
                .cluster()
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
                    int[] ints = new int[1000];
                case HIGHER_HEAP:
                        i++;
        client(node).execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGHER_HEAP, SearchShardTask::new), listener);
            ),
            .put(SearchTaskSettings.SETTING_TOTAL_HEAP_PERCENT_THRESHOLD.getKey(), 0.0)
        // Before SearchBackpressureService cancels a task based on its heap usage, we need to build up the heap moving average
        public TestRequest(StreamInput in) throws IOException {
            ),
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
                        parentTaskId,
        Settings request = Settings.builder()
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.core.common.io.stream.StreamInput;
                    descriptionSupplier(description),
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        Settings request = Settings.builder()
        }
                    } while (request.type != RequestType.HIGH_HEAP
            .build();
                case HIGH_ELAPSED_TIME:
        }
        }
            .build();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    action,
        return Arrays.asList(
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
                    id,
        // request having higher heap usage
                    headers
        );
            .put(NodeDuressSettings.SETTING_CPU_THRESHOLD.getKey(), 0.0)
                RequestType.HIGH_CPU,
            client(node).execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGH_HEAP, SearchShardTask::new), listener);
                    action,
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
        Exception caughtException = listener.getException();
        @Override
        private final CountDownLatch latch;
    }
                    do {
    public static class TestRequest<T extends Task> extends ActionRequest {
        }
 */
        ClusterUpdateSettingsResponse response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get();
            .put(SearchTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD.getKey(), 1000)
        client().execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGH_ELAPSED_TIME, SearchShardTask::new), listener);
        Settings request = Settings.builder()
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
        }
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        String node = randomFrom(internalCluster().getNodeNames());
    }
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("heap usage exceeded"));
        @Override
 * The OpenSearch Contributors require contributions made to
                case HIGH_CPU:
        }
    }
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
        super(staticSettings);
            listener
import java.io.IOException;
                    descriptionSupplier(description),
        // To build up the heap moving average, we need to hit the same node with multiple requests and then hit the same node with a
            this.type = type;
                .prepareUpdateSettings()
            return this.type;
                    break;
    @After
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
        String node = randomFrom(internalCluster().getNodeNames());
            ),
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("elapsed time exceeded"));
 * SPDX-License-Identifier: Apache-2.0
/*
            .put(SearchShardTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD.getKey(), 1000)
            listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS)
            });
    private Supplier<String> descriptionSupplier(String description) {
    }
        Exception caughtException = listener.getException();
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
}
    public final void cleanupNodeSettings() {
            .build();
        return plugins;
                    long startTime = System.nanoTime();
        Settings request = Settings.builder()
    }
                (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(
        private void doWork(TestRequest<Task> request) throws InterruptedException {
        request = Settings.builder().put(SearchShardTaskSettings.SETTING_CANCELLATION_RATIO.getKey(), "0.7").build();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        @Override
import java.util.function.Supplier;
                        k *= j;
        Settings request = Settings.builder()
            new TestRequest<>(
        for (int i = 0; i < MOVING_AVERAGE_WINDOW_SIZE; i++) {
        @Override
                    break;
import org.opensearch.search.backpressure.settings.SearchTaskSettings;
            .put(SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), MOVING_AVERAGE_WINDOW_SIZE)
    }
    }
 * compatible open source license.
        private final ThreadPool threadPool;
            .put(SearchShardTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD.getKey(), 1.0)
    public static class ExceptionCatchingListener implements ActionListener<TestResponse> {
                        && (System.nanoTime() - startTime) < TIMEOUT.getNanos());
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
    }
        }
import org.opensearch.core.tasks.TaskCancelledException;
                } catch (Exception e) {
        protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {
                    if (cancellableTask.isCancelled()) {
                    headers
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
                    int[] more_ints = new int[10000];
                )
                    RequestType.HIGH_HEAP,
    public void testSearchTaskCancellationWithHighCpu() throws InterruptedException {
        client().execute(
import org.opensearch.tasks.Task;
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
                    parentTaskId,
            super.writeTo(out);
import org.opensearch.threadpool.ThreadPool;
    private static final int MOVING_AVERAGE_WINDOW_SIZE = 10;
        plugins.add(TestPlugin.class);
        public Exception getException() {
    public static class TestPlugin extends Plugin implements ActionPlugin {
                    Thread.sleep(100);
            return latch;
    }
import org.hamcrest.MatcherAssert;
import org.opensearch.transport.TransportService;
    }
        public ExceptionCatchingListener() {
            return Collections.singletonList(new ActionHandler<>(TestTransportAction.ACTION, TestTransportAction.class));
                TestTransportAction.ACTION,
            threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
    }
                )
        public static final ActionType<TestResponse> ACTION = new ActionType<>("internal::test_action", TestResponse::new);
        HIGH_HEAP,
                    break;
        assertEquals(response.getPersistentSettings().get(SearchShardTaskSettings.SETTING_CANCELLATION_RATIO.getKey()), "0.7");
            );
            return taskFactory.createTask(id, type, action, "", parentTaskId, headers);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.concurrent.CountDownLatch;
            latch.countDown();
    }
import static org.hamcrest.Matchers.containsString;
    public void testSearchShardTaskCancellationWithHighHeapUsage() throws InterruptedException {
        private TaskFactory<T> taskFactory;
        listener = new ExceptionCatchingListener();
        HIGHER_HEAP,
        private Exception exception = null;
        public TestResponse(StreamInput in) {}
        Exception caughtException = listener.getException();
                    )
        Settings request = Settings.builder()
                        id,
    }
                    CancellableTask cancellableTask = (CancellableTask) task;
                    } else {
                (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(
                    id,
            return null;
            .put(SearchTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD.getKey(), 1000)
            .put(SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), MOVING_AVERAGE_WINDOW_SIZE)
                    action,
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
        public void onResponse(TestResponse r) {
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
        @Override
            "SearchShardTask should have been completed by now and countdown the latch",
            .put(SearchShardTaskSettings.SETTING_HEAP_PERCENT_THRESHOLD.getKey(), 0.0)
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
    private static final TimeValue TIMEOUT = new TimeValue(10, TimeUnit.SECONDS);
        public void onFailure(Exception e) {
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("heap usage exceeded"));
        }
    }
    }
            }
    }
            .build();
                .setPersistentSettings(Settings.builder().putNull("*"))
                    parentTaskId,
        public void writeTo(StreamOutput out) throws IOException {}
