            return new TestResponse(in);
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
                    int bytesToAllocate = (int) (Runtime.getRuntime().totalMemory() * 0.01);
    public static class TestClusterUpdateRequest extends ClusterManagerNodeRequest<TestClusterUpdateRequest> {
            );
        @Override
    public void testHighCPUInMonitorMode() throws InterruptedException {
                    }
                        doWork(request);
        plugins.add(TestClusterUpdatePlugin.class);
        Exception caughtException = executeWorkloadGroupTask(CPU, workloadGroup.get_id());
        @Override
        }
            )
            return type;
                    CancellableTask cancellableTask = (CancellableTask) task;
import org.opensearch.common.unit.TimeValue;
        );
        return listener.getException();
        assertTrue(listener.getLatch().await(TIMEOUT.getSeconds() + 1, TimeUnit.SECONDS));
        }
        private final String workloadGroupId;
                    if (cancellableTask.isCancelled()) {
        }
            out.writeString(method);
            this.method = in.readString();
                    return ClusterState.builder(currentState).metadata(metadata).build();
import org.opensearch.action.ActionType;
            this.threadPool = threadPool;
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
        protected TestResponse read(StreamInput in) throws IOException {
            super(
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);
        );
    }
                    listener.onResponse(new TestResponse());
        client().execute(TestClusterUpdateTransportAction.ACTION, new TestClusterUpdateRequest(workloadGroup, method), listener);
    public WorkloadManagementIT(Settings nodeSettings) {
        }
                    Map<String, WorkloadGroup> currentGroups = currentState.metadata().workloadGroups();
import org.opensearch.cluster.metadata.WorkloadGroup;
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);
import org.junit.Before;
            listener
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
                    long i = 0, j = 1, k = 1, iterations = 1000;
        }
        public String getMethod() {
        assertNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
import org.opensearch.search.backpressure.SearchBackpressureIT.TaskFactory;
            }
import java.util.ArrayList;
                Map.of(ResourceType.CPU, 0.01, ResourceType.MEMORY, 0.01)
        }
import static org.opensearch.threadpool.ThreadPool.Names.SAME;
import org.opensearch.transport.TransportService;
                        k *= j;
        WorkloadGroup workloadGroup = new WorkloadGroup(
            "name",
                    headers
import org.opensearch.plugins.Plugin;
        }
        @Override
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertTrue(listener.getLatch().await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));
                    } while (i < iterations);
            TestWorkloadGroupTaskTransportAction.ACTION,
                        listener.onResponse(new TestResponse());
    public Exception executeWorkloadGroupTask(String resourceType, String workloadGroupId) throws InterruptedException {
                        throw new TaskCancelledException(cancellableTask.getReasonCancelled());
import org.opensearch.action.support.HandledTransportAction;
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
                public ClusterState execute(ClusterState currentState) {
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            });
        @Override
            )
    }
            .put(WorkloadManagementSettings.NODE_LEVEL_MEMORY_REJECTION_THRESHOLD.getKey(), 0.8)
            this.taskFactory = taskFactory;
            TestResponse::new
            this.workloadGroupId = in.readString();
            this.workloadGroup = new WorkloadGroup(in);
        @Inject
 */
                    do {
        public ActionRequestValidationException validate() {
import java.io.IOException;
                    listener.onFailure(e);
    @Override
            new MutableWorkloadGroupFragment(
                    int[] ints = new int[bytesToAllocate];
import org.opensearch.tasks.CancellableTask;
import java.util.concurrent.TimeUnit;
        }
        @Inject
        @Override
            "name",
            workloadGroup.writeTo(out);
    }
                    Metadata metadata;
import org.opensearch.search.backpressure.SearchBackpressureIT.ExceptionCatchingListener;
    final static String PUT = "PUT";
            out.writeString(workloadGroupId);
import java.util.Map;
import org.opensearch.plugins.ActionPlugin;
        Exception caughtException = executeWorkloadGroupTask(CPU, workloadGroup.get_id());
        }
import org.opensearch.core.tasks.TaskCancelledException;
        WorkloadGroup workloadGroup = new WorkloadGroup(
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.01))
            return Arrays.asList(
            ),
import org.opensearch.threadpool.ThreadPool;
                (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    public static Collection<Object[]> parameters() {
            return Arrays.asList(TestClusterUpdateTransportAction.ACTION, TestWorkloadGroupTaskTransportAction.ACTION);
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
            super(ACTION.name(), transportService, actionFilters, TestWorkloadGroupTaskRequest::new);
                resourceType,
            return workloadGroup;
                        metadata = Metadata.builder(currentState.metadata()).remove(currentGroups.get(id)).build();
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);
                case "CPU":
        public void writeTo(StreamOutput out) throws IOException {
        );
                    long startTime = System.nanoTime();
                .setTransientSettings(Settings.builder().putNull("*"))
        assertNull(caughtException);
            this.workloadGroup = workloadGroup;
        Settings request = Settings.builder()
        }
                    listener.onFailure(e);
                Map.of(ResourceType.CPU, 0.01, ResourceType.MEMORY, 0.01)
    final static String ENABLED = "enabled";
        private final String type;
        protected void doExecute(Task task, TestWorkloadGroupTaskRequest request, ActionListener<TestResponse> listener) {
                } catch (Exception e) {
    }
        Settings request = Settings.builder().put(WorkloadManagementSettings.WLM_MODE_SETTING.getKey(), ENABLED).build();
            super.writeTo(out);
        private TaskFactory<T> taskFactory;
        final private String method;
    }
                    parentTaskId,
import static org.opensearch.wlm.WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER;
import org.opensearch.cluster.block.ClusterBlockException;
        }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import org.opensearch.core.action.ActionListener;
                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
                        }
    }
                workloadGroupId,
                new ActionHandler<>(TestWorkloadGroupTaskTransportAction.ACTION, TestWorkloadGroupTaskTransportAction.class)
        public TestWorkloadGroupTaskRequest(StreamInput in) throws IOException {
    public void updateWorkloadGroupInClusterState(String method, WorkloadGroup workloadGroup) throws InterruptedException {
import org.opensearch.core.common.io.stream.StreamOutput;
        public TestWorkloadGroupTaskTransportAction(TransportService transportService, ThreadPool threadPool, ActionFilters actionFilters) {
        private final ThreadPool threadPool;
        assertNull(caughtException);
                    action,
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17154")
    public void testHighCPUInEnforcedMode() throws InterruptedException {
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
        assertAcked(
            client().admin()
        @Override
        @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        public String getType() {
        Settings request = Settings.builder().put(WorkloadManagementSettings.WLM_MODE_SETTING.getKey(), ENABLED).build();
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
        public WorkloadGroup getWorkloadGroup() {
/*
                    Byte[] bytes = new Byte[bytesToAllocate];
            super.writeTo(out);
    }
 *
                .setPersistentSettings(Settings.builder().putNull("*"))
import org.opensearch.core.action.ActionResponse;
        public TestClusterUpdateRequest(WorkloadGroup workloadGroup, String method) {
import java.util.Arrays;
    public static class TestClusterUpdatePlugin extends Plugin implements ActionPlugin {
 * this file be licensed under the Apache-2.0 license or a
            .build();
                }
            return method;
    public static class TestWorkloadGroupTaskRequest<T extends Task> extends ActionRequest {
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
                public void onFailure(String source, Exception e) {
                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
                            break;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    public void testHighMemoryInMonitorMode() throws InterruptedException {
    final static String DELETE = "DELETE";
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
        protected void clusterManagerOperation(
            .put(WorkloadManagementSettings.NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD.getKey(), 0.9)
import static org.hamcrest.Matchers.instanceOf;
                    String method = request.getMethod();
        @Override
            super(in);
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
        private void doWork(TestWorkloadGroupTaskRequest request) throws InterruptedException {
    }
                    () -> description,
        }
                        i++;
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
                    } else {
                new ActionHandler<>(TestClusterUpdateTransportAction.ACTION, TestClusterUpdateTransportAction.class),
        }
import org.opensearch.common.inject.Inject;
            .put(WorkloadManagementSettings.NODE_LEVEL_CPU_CANCELLATION_THRESHOLD.getKey(), 0.9)
        }
        client().execute(
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        @Override
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
                    while (System.nanoTime() - startTime < TIMEOUT.getNanos()) {
        ) {
            threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {
import java.util.Collection;
                        j += i;
            "name",
        WorkloadGroup workloadGroup = new WorkloadGroup(
    }
        @Override
                indexNameExpressionResolver
    public static class TestWorkloadGroupTaskTransportAction extends HandledTransportAction<TestWorkloadGroupTaskRequest, TestResponse> {
import org.opensearch.search.backpressure.SearchBackpressureIT.TestResponse;
        }
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    WorkloadGroup workloadGroup = request.getWorkloadGroup();
        final private WorkloadGroup workloadGroup;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .put(WorkloadManagementSettings.NODE_LEVEL_CPU_REJECTION_THRESHOLD.getKey(), 0.8)
                case "MEMORY":
    }
                .cluster()
                    }
    public void testHighMemoryInEnforcedMode() throws InterruptedException {
    }
import org.junit.After;
        }
                        metadata = Metadata.builder(currentState.metadata()).put(workloadGroup).build();
    }
        }
                Map.of(ResourceType.CPU, 0.8, ResourceType.MEMORY, 0.8)
                }
            clusterService.submitStateUpdateTask("query-group-persistence-service", new ClusterStateUpdateTask() {
        public static final ActionType<TestResponse> ACTION = new ActionType<>(
            IndexNameExpressionResolver indexNameExpressionResolver,
    }
            )
            ClusterState clusterState,
            this.method = method;
                @Override
import org.opensearch.tasks.Task;
                    ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());
    public static class TestClusterUpdateTransportAction extends TransportClusterManagerNodeAction<TestClusterUpdateRequest, TestResponse> {
        public ActionRequestValidationException validate() {
                    type,
            TestClusterUpdateRequest request,
import org.opensearch.action.support.ActionFilters;
        public void writeTo(StreamOutput out) throws IOException {
        return plugins;
import org.opensearch.action.ActionRequestValidationException;
            });
                TestClusterUpdateRequest::new,
    private static final TimeValue TIMEOUT = new TimeValue(1, TimeUnit.SECONDS);
        public TestClusterUpdateRequest(StreamInput in) throws IOException {
        super(nodeSettings);
            return workloadGroupId;
import org.opensearch.common.settings.Settings;
            super(in);
                    id,
        }
    }
        public static final ActionType<TestResponse> ACTION = new ActionType<>("internal::test_cluster_update_action", TestResponse::new);
                    break;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17154")
                try {
        @Override
        }
        Exception caughtException = executeWorkloadGroupTask(CPU, workloadGroup.get_id());
package org.opensearch.wlm;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17154")
        protected String executor() {
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);
    final static String CPU = "CPU";
        );
    public final void setupNodeSettings() {
            ThreadPool threadPool,
import org.opensearch.cluster.service.ClusterService;
        );
            out.writeString(type);
            new MutableWorkloadGroupFragment(
        public TestClusterUpdateTransportAction(
    final static String MEMORY = "MEMORY";
        @Override
        protected ClusterBlockException checkBlock(TestClusterUpdateRequest request, ClusterState state) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            switch (request.getType()) {
            ClusterService clusterService
        public TestWorkloadGroupTaskRequest(String type, String workloadGroupId, TaskFactory<T> taskFactory) {
        );
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
            this.workloadGroupId = workloadGroupId;
                threadPool,
            return null;
                }
                    } else { // delete
        }
                    if (method.equals(PUT)) { // create
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
        }
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
            return null;
        assertEquals(0, listener.getLatch().getCount());
        WorkloadGroup workloadGroup = new WorkloadGroup(
        }
        ) {
                transportService,
                    }
                    assertEquals(request.getWorkloadGroupId(), ((WorkloadGroupTask) task).getWorkloadGroupId());
        public String getWorkloadGroupId() {
                @Override
 * compatible open source license.
                    String id = workloadGroup.get_id();
                clusterService,
        public List<ActionType<? extends ActionResponse>> getClientActions() {
            "name",
    }
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);
        );
        Exception caughtException = executeWorkloadGroupTask(MEMORY, workloadGroup.get_id());
}
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17154")
    public final void cleanupNodeSettings() {
            new MutableWorkloadGroupFragment(
                    break;
            );
                )
import org.opensearch.cluster.block.ClusterBlockLevel;
        WorkloadGroup workloadGroup = new WorkloadGroup(
    public void testNoCancellation() throws InterruptedException {
public class WorkloadManagementIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    @After
import org.opensearch.core.common.io.stream.StreamInput;
            threadPool.getThreadContext().putHeader(WORKLOAD_GROUP_ID_HEADER, request.getWorkloadGroupId());
            new TestWorkloadGroupTaskRequest(
    }
            this.type = in.readString();
    @ParametersFactory
    @Before
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.01))
import org.opensearch.action.ActionRequest;
    }
            "internal::test_workload_group_task_action",
            return SAME;
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.core.tasks.TaskId;
import org.opensearch.cluster.ClusterStateUpdateTask;
                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
                actionFilters,
        return Arrays.asList(
                }
            TransportService transportService,
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
import org.hamcrest.MatcherAssert;
                .prepareUpdateSettings()
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
import org.opensearch.action.search.SearchTask;
        );
                        if (cancellableTask.isCancelled()) {
import org.opensearch.cluster.ClusterState;
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
            return taskFactory.createTask(id, type, action, "", parentTaskId, headers);
import java.util.List;
            ActionFilters actionFilters,
        }
        );
            "name",
            ActionListener<TestResponse> listener
        Exception caughtException = executeWorkloadGroupTask(MEMORY, workloadGroup.get_id());
                @Override
            this.type = type;
                ACTION.name(),
