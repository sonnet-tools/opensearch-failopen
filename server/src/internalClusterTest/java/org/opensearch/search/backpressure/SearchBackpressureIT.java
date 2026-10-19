                case HIGH_ELAPSED_TIME:
            .put(NodeDuressSettings.SETTING_NUM_SUCCESSIVE_BREACHES.getKey(), 1)  
            out.writeEnum(type);  
        client().execute(  
    }
        }
            new TestRequest<>(
        // To build up the heap moving average, we need to hit the same node with multiple requests and then hit the same node with a  
        // To build up the heap moving average, we need to hit the same node with multiple requests and then hit the same node with a
        assertTrue(
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")  
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
        plugins.add(TestPlugin.class);  
    }
                    ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());
        assertNotNull("SearchShardTask should have been cancelled with TaskCancelledException", caughtException);
            this.latch = new CountDownLatch(1);
        public TestRequest(RequestType type, TaskFactory<T> taskFactory) {
        );  
            super(in);
                    do {
                        parentTaskId,
        assertEquals(response.getPersistentSettings().get(SearchTaskSettings.SETTING_CANCELLATION_RATE.getKey()), "0.05");  
        );  
        }
    }
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        @Override
        Exception caughtException = listener.getException();
                    } else {  
    }  
        @SuppressForbidden(reason = "Simulating a slow task by sleeping")  
public class SearchBackpressureIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    public void testCancellationSettingsChanged() {  
import org.opensearch.common.unit.TimeValue;
                    long i = 0, j = 1, k = 1, iterations = 1000;
 */  
                .cluster()
            }
        listener = new ExceptionCatchingListener();  
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
                    CancellableTask cancellableTask = (CancellableTask) task;
                    descriptionSupplier(description),
        public ActionRequestValidationException validate() {  
                .setTransientSettings(Settings.builder().putNull("*"))
import static org.hamcrest.Matchers.containsString;  
                    headers
            super.writeTo(out);
                    type,  
    public final void setupNodeSettings() {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        return Arrays.asList(  
        }
        T createTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers);  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
            this.type = type;
import org.opensearch.action.support.ActionFilters;  
    }
    public void testSearchShardTaskCancellationWithHighElapsedTime() throws InterruptedException {
            return latch;
        public RequestType getType() {  
            .put(SearchShardTaskSettings.SETTING_HEAP_PERCENT_THRESHOLD.getKey(), 0.0)
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));  
            .put(SearchTaskSettings.SETTING_TOTAL_HEAP_PERCENT_THRESHOLD.getKey(), 0.0)
                    id,  
                        j += i;  
        HIGH_CPU,
            client(node).execute(
            .put(SearchShardTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD.getKey(), 1000)
import org.opensearch.core.common.io.stream.StreamOutput;  
        ExceptionCatchingListener listener = new ExceptionCatchingListener();  
            .build();
import org.opensearch.tasks.Task;
        public TestTransportAction(TransportService transportService, ThreadPool threadPool, ActionFilters actionFilters) {
import org.opensearch.core.common.io.stream.StreamInput;
        super(staticSettings);
        public void writeTo(StreamOutput out) throws IOException {}
        private final RequestType type;
    }
                    parentTaskId,
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));  
            .build();  
        Settings request = Settings.builder().put(SearchBackpressureSettings.SETTING_MODE.getKey(), "monitor_only").build();
    @ParametersFactory
        // Before SearchBackpressureService cancels a task based on its heap usage, we need to build up the heap moving average
import org.junit.After;
import org.opensearch.action.ActionRequest;  
        public TestResponse(StreamInput in) {}
            return Collections.singletonList(TestTransportAction.ACTION);
        }
    public void testSearchTaskCancellationWithHighCpu() throws InterruptedException {
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("heap usage exceeded"));  
        public List<ActionType<? extends ActionResponse>> getClientActions() {  
        }
import org.opensearch.common.SuppressForbidden;
import static org.hamcrest.Matchers.instanceOf;
                    int[] ints = new int[1000];
    }  
                listener
            latch.countDown();  
                    action,
                    id,
    private static final TimeValue TIMEOUT = new TimeValue(10, TimeUnit.SECONDS);  
                    descriptionSupplier(description),
        private final ThreadPool threadPool;
                    do {
import org.opensearch.plugins.Plugin;
    public static class TestPlugin extends Plugin implements ActionPlugin {
            "SearchShardTask should have been completed by now and countdown the latch",  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        @Override  
import java.util.List;
            ),  
import org.opensearch.action.search.SearchTask;
        listener = new ExceptionCatchingListener();  
        public TestResponse() {}  
        @Override
                    )  
        String node = randomFrom(internalCluster().getNodeNames());
    public void testSearchCancellationWithBackpressureDisabled() throws InterruptedException {
                    if (cancellableTask.isCancelled()) {
    public static Collection<Object[]> parameters() {
        public void onResponse(TestResponse r) {
        // Before SearchBackpressureService cancels a task based on its heap usage, we need to build up the heap moving average
        @Override  
 * compatible open source license.
import java.io.IOException;
            this.threadPool = threadPool;  
        Settings request = Settings.builder()
                    } while (request.type != RequestType.HIGH_HEAP  
import org.opensearch.threadpool.ThreadPool;
    }
import org.opensearch.core.tasks.TaskCancelledException;
                        k *= j;
    }  
            this.exception = e;
                    id,
            .build();
        }
    @Override  
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("elapsed time exceeded"));
                    } while (i < iterations);  
import org.opensearch.core.action.ActionListener;  
            .put(SearchTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD.getKey(), 1000)
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
        private Exception exception = null;
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
            super(ACTION.name(), transportService, actionFilters, TestRequest::new);
                    Byte[] bytes = new Byte[100000];  
        // request having higher heap usage  
            this.taskFactory = taskFactory;  
                    listener.onFailure(e);
    }
        assertAcked(  
 * this file be licensed under the Apache-2.0 license or a
                )
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));  
    private static final int MOVING_AVERAGE_WINDOW_SIZE = 10;
                    Thread.sleep(100);
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);  
            .build();  
    public final void cleanupNodeSettings() {
                new TestRequest<>(  
import java.util.function.Supplier;
        client().execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGH_CPU, SearchShardTask::new), listener);
    }  
    public interface TaskFactory<T extends Task> {
            .put(SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), MOVING_AVERAGE_WINDOW_SIZE)  
        Settings request = Settings.builder()  
    public void testSearchTaskCancellationWithHighHeapUsage() throws InterruptedException {
            latch.countDown();  
    }
                        descriptionSupplier(description),  
                    Byte[] more_bytes = new Byte[1000000];
            switch (request.getType()) {
                    descriptionSupplier(description),  
            });  
        Exception caughtException = listener.getException();  
                case HIGHER_HEAP:  
                    (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(
                    // We are running HIGH_HEAP requests to build up heap moving average and not expect it to get cancelled.  
            .build();
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("cpu usage exceeded"));
import org.opensearch.tasks.CancellableTask;  
                    int[] more_ints = new int[10000];
        client().execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGH_ELAPSED_TIME, SearchShardTask::new), listener);
import java.util.concurrent.TimeUnit;
        @Override
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
        ClusterUpdateSettingsResponse response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get();
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("elapsed time exceeded"));
        Settings request = Settings.builder()
import java.util.concurrent.CountDownLatch;  
import org.hamcrest.MatcherAssert;
    @Before
    }
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);  
            .put(SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), MOVING_AVERAGE_WINDOW_SIZE)
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());  
            .put(NodeDuressSettings.SETTING_HEAP_THRESHOLD.getKey(), 0.0)
            return this.type;
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
import org.opensearch.plugins.ActionPlugin;  
                .prepareUpdateSettings()  
        Settings request = Settings.builder()  
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
        }
            TestTransportAction.ACTION,
                (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(
    }
            TestTransportAction.ACTION,
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
                        throw new TaskCancelledException(cancellableTask.getReasonCancelled());
                )  
        Exception caughtException = listener.getException();
                        && cancellableTask.isCancelled() == false
    }  
        public void writeTo(StreamOutput out) throws IOException {
                        type,
    public static class TestRequest<T extends Task> extends ActionRequest {  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
    public static class TestResponse extends ActionResponse {
                ),
                    action,
import org.opensearch.common.inject.Inject;  
        assertNotNull("SearchShardTask should have been cancelled with TaskCancelledException", caughtException);
            .put(NodeDuressSettings.SETTING_CPU_THRESHOLD.getKey(), 0.0)
        ExceptionCatchingListener listener = new ExceptionCatchingListener();  
import org.opensearch.transport.TransportService;
            return taskFactory.createTask(id, type, action, "", parentTaskId, headers);  
        );
                    action,
                )
                    type,  
    }
        @Override  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());  
    public void testSearchShardTaskCancellationWithHighCpu() throws InterruptedException {
        @Inject  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import java.util.Arrays;
                (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(
                        listener.onResponse(new TestResponse());
            return Collections.singletonList(new ActionHandler<>(TestTransportAction.ACTION, TestTransportAction.class));
        assertEquals(response.getPersistentSettings().get(SearchShardTaskSettings.SETTING_CANCELLATION_RATIO.getKey()), "0.7");
            .build();  
                    break;
        }  
        @Override  
        );
                RequestType.HIGH_ELAPSED_TIME,  
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
            TestTransportAction.ACTION,
        return () -> description;
        }
    }  
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));  
                        id,  
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
        assertNull("SearchShardTask shouldn't have cancelled for monitor_only mode", caughtException);
        String node = randomFrom(internalCluster().getNodeNames());
        }
    }  
import org.opensearch.action.support.HandledTransportAction;
        request = Settings.builder().put(SearchShardTaskSettings.SETTING_CANCELLATION_RATIO.getKey(), "0.7").build();
        for (int i = 0; i < MOVING_AVERAGE_WINDOW_SIZE; i++) {  
    @After
import org.opensearch.wlm.WorkloadGroupTask;  
package org.opensearch.search.backpressure;
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
import org.opensearch.action.ActionType;
            .build();
import org.opensearch.search.backpressure.settings.NodeDuressSettings;
        private void doWork(TestRequest<Task> request) throws InterruptedException {
        public Exception getException() {
            ),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        HIGHER_HEAP,  
                } catch (Exception e) {  
            return exception;
                        action,
    public SearchBackpressureIT(Settings staticSettings) {  
    public static class ExceptionCatchingListener implements ActionListener<TestResponse> {
 * The OpenSearch Contributors require contributions made to  
                        doWork(request);
                        && (System.nanoTime() - startTime) < TIMEOUT.getNanos());
                    RequestType.HIGH_HEAP,
            this.type = in.readEnum(RequestType.class);
                TestTransportAction.ACTION,
        }  
                RequestType.HIGHER_HEAP,
                    break;
                    type,
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;  
                    long startTime = System.nanoTime();  
                (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(
        return plugins;
    public static class TestTransportAction extends HandledTransportAction<TestRequest, TestResponse> {
        response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get();  
                case HIGH_HEAP:
        Settings request = Settings.builder()  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());  
            new TestRequest<>(
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));  
        }
                }
import org.opensearch.action.ActionRequestValidationException;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)  
                    }
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.Map;
                        i++;
            new TestRequest<>(  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
        private final CountDownLatch latch;  
        }
        public ExceptionCatchingListener() {  
            listener.latch.await(TIMEOUT.getSeconds() * 3, TimeUnit.SECONDS)
                    break;  
import org.opensearch.search.backpressure.settings.SearchTaskSettings;
import java.util.ArrayList;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        }
        HIGH_ELAPSED_TIME;
        public void onFailure(Exception e) {
        public static final ActionType<TestResponse> ACTION = new ActionType<>("internal::test_action", TestResponse::new);  
        Settings request = Settings.builder().put(SearchTaskSettings.SETTING_CANCELLATION_RATE.getKey(), "0.05").build();
        Exception caughtException = listener.getException();
import org.opensearch.common.settings.Settings;
        }
            .put(SearchTaskSettings.SETTING_HEAP_PERCENT_THRESHOLD.getKey(), 0.0)
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {
            .put(SearchTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD.getKey(), 1.0)  
        Exception caughtException = listener.getException();
        Settings request = Settings.builder()  
        client(node).execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGHER_HEAP, SearchShardTask::new), listener);
            client().admin()
            .put(SearchTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD.getKey(), 1000)
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("cpu usage exceeded"));
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
        );  
            threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {
        }
                case HIGH_CPU:  
                .setPersistentSettings(Settings.builder().putNull("*"))
                        headers
            return null;
        HIGH_HEAP,
                    // Doing a busy-wait until task cancellation or timeout.
                    headers
        }  
import org.opensearch.core.action.ActionResponse;
        client().execute(  
        for (int i = 0; i < MOVING_AVERAGE_WINDOW_SIZE; i++) {
            listener
        Exception caughtException = listener.getException();
    }  
        MatcherAssert.assertThat(caughtException.getMessage(), containsString("heap usage exceeded"));
        client(node).execute(
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
    }
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());  
                RequestType.HIGH_CPU,  
        @Override
        client().execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGH_ELAPSED_TIME, SearchShardTask::new), listener);  
            .put(SearchShardTaskSettings.SETTING_TOTAL_HEAP_PERCENT_THRESHOLD.getKey(), 0.0)
        // request having higher heap usage
            listener
        }
    public void testSearchShardTaskCancellationWithHighHeapUsage() throws InterruptedException {  
        @Override
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")  
            ),  
        assertNotNull("SearchShardTask should have been cancelled with TaskCancelledException", caughtException);
                    break;  
    public void testSearchTaskCancellationWithHighElapsedTime() throws InterruptedException {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.tasks.TaskId;
            .put(SearchShardTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD.getKey(), 1000)
}
        Settings request = Settings.builder()
    private Supplier<String> descriptionSupplier(String description) {
        private TaskFactory<T> taskFactory;
import java.util.Collections;  
            .put(SearchShardTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD.getKey(), 1.0)
        Exception caughtException = listener.getException();
                    headers
/*  
            );  
        public CountDownLatch getLatch() {  
import org.junit.Before;  
 *
        public TestRequest(StreamInput in) throws IOException {  
        assertTrue(listener.latch.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
import org.opensearch.action.search.SearchShardTask;
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
                    parentTaskId,  
        // waiting for the TIMEOUT * 3 time for the request to complete and the latch to countdown.
    enum RequestType {  
                    parentTaskId,  
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                try {  
        );
            client(node).execute(TestTransportAction.ACTION, new TestRequest<>(RequestType.HIGH_HEAP, SearchShardTask::new), listener);  
    }
            listener
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import java.util.Collection;
            .put(SearchBackpressureSettings.SETTING_MODE.getKey(), "enforced")  
