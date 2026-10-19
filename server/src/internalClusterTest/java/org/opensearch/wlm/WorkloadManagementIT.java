                    } else { // delete  
import java.util.Arrays;
        );
            .put(WorkloadManagementSettings.NODE_LEVEL_MEMORY_REJECTION_THRESHOLD.getKey(), 0.8)
            new TestWorkloadGroupTaskRequest(  
        public static final ActionType<TestResponse> ACTION = new ActionType<>("internal::test_cluster_update_action", TestResponse::new);
    public Exception executeWorkloadGroupTask(String resourceType, String workloadGroupId) throws InterruptedException {
    }
            )
    final static String ENABLED = "enabled";  
import org.opensearch.cluster.metadata.WorkloadGroup;
    }
                    listener.onResponse(new TestResponse());
            }
            this.workloadGroup = workloadGroup;
            return type;  
        protected TestResponse read(StreamInput in) throws IOException {
        @Override
        }
import org.opensearch.core.action.ActionResponse;
    final static String DELETE = "DELETE";
        }
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
    }
import org.opensearch.cluster.ClusterStateUpdateTask;  
    public void testHighMemoryInEnforcedMode() throws InterruptedException {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                @Override  
        Settings request = Settings.builder().put(WorkloadManagementSettings.WLM_MODE_SETTING.getKey(), ENABLED).build();
                .cluster()
            "name",  
    }
            TestWorkloadGroupTaskTransportAction.ACTION,
                            break;  
        super(nodeSettings);
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);  
            return Arrays.asList(  
                .setPersistentSettings(Settings.builder().putNull("*"))
            super.writeTo(out);  
                new ActionHandler<>(TestClusterUpdateTransportAction.ACTION, TestClusterUpdateTransportAction.class),
        protected void clusterManagerOperation(  
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);  
            super(in);
            ClusterState clusterState,
import org.junit.Before;
                    break;
        );
import org.opensearch.threadpool.ThreadPool;  
                    } while (i < iterations);
                new ActionHandler<>(TestWorkloadGroupTaskTransportAction.ACTION, TestWorkloadGroupTaskTransportAction.class)
import org.opensearch.core.common.io.stream.StreamInput;  
    public static class TestClusterUpdatePlugin extends Plugin implements ActionPlugin {  
    }
        client().execute(
    public void testHighCPUInEnforcedMode() throws InterruptedException {
        WorkloadGroup workloadGroup = new WorkloadGroup(
        @Override  
    final static String PUT = "PUT";  
                (TaskFactory<Task>) (id, type, action, description, parentTaskId, headers) -> new SearchTask(  
import org.opensearch.common.inject.Inject;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    while (System.nanoTime() - startTime < TIMEOUT.getNanos()) {  
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);  
import org.opensearch.action.ActionRequest;  
            workloadGroup.writeTo(out);
        public void writeTo(StreamOutput out) throws IOException {
            return Arrays.asList(TestClusterUpdateTransportAction.ACTION, TestWorkloadGroupTaskTransportAction.ACTION);
            switch (request.getType()) {  
            });  
        );
            "name",
        }
            this.type = type;
            threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {  
    }
                        i++;  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17154")  
import org.opensearch.cluster.block.ClusterBlockLevel;
                }
            return null;
                    }
 * The OpenSearch Contributors require contributions made to  
            ClusterService clusterService
        return plugins;
    public static Collection<Object[]> parameters() {  
        }
                    Metadata metadata;  
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());  
        public TestClusterUpdateRequest(StreamInput in) throws IOException {
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
                .setTransientSettings(Settings.builder().putNull("*"))
    @Before
    public void updateWorkloadGroupInClusterState(String method, WorkloadGroup workloadGroup) throws InterruptedException {  
        );
 * SPDX-License-Identifier: Apache-2.0
                try {
        }
    }
        @Override  
        }
        WorkloadGroup workloadGroup = new WorkloadGroup(
            this.taskFactory = taskFactory;  
        final private WorkloadGroup workloadGroup;  
        @Inject
import org.opensearch.action.support.ActionFilters;
        public WorkloadGroup getWorkloadGroup() {
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());  
        assertNull(caughtException);
        Settings request = Settings.builder()
                )
            this.method = method;  
    }  
                    String id = workloadGroup.get_id();
                Map.of(ResourceType.CPU, 0.8, ResourceType.MEMORY, 0.8)
        protected void doExecute(Task task, TestWorkloadGroupTaskRequest request, ActionListener<TestResponse> listener) {
    }  
    public static class TestClusterUpdateRequest extends ClusterManagerNodeRequest<TestClusterUpdateRequest> {
        Exception caughtException = executeWorkloadGroupTask(MEMORY, workloadGroup.get_id());  
 * this file be licensed under the Apache-2.0 license or a
                        listener.onResponse(new TestResponse());  
        );
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            this.method = in.readString();  
    @After
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
        }
        private void doWork(TestWorkloadGroupTaskRequest request) throws InterruptedException {
    public final void cleanupNodeSettings() {
                    if (method.equals(PUT)) { // create
        public TestClusterUpdateRequest(WorkloadGroup workloadGroup, String method) {
            return workloadGroupId;
        }
    public static class TestWorkloadGroupTaskTransportAction extends HandledTransportAction<TestWorkloadGroupTaskRequest, TestResponse> {
        public String getType() {
    public WorkloadManagementIT(Settings nodeSettings) {
            IndexNameExpressionResolver indexNameExpressionResolver,  
        Exception caughtException = executeWorkloadGroupTask(CPU, workloadGroup.get_id());  
            return new TestResponse(in);  
                    } else {
            "name",  
                indexNameExpressionResolver
        @Override
                        k *= j;
                    Map<String, WorkloadGroup> currentGroups = currentState.metadata().workloadGroups();
import java.util.Collection;  
                    parentTaskId,
        public TestWorkloadGroupTaskRequest(StreamInput in) throws IOException {  
            )  
                    if (cancellableTask.isCancelled()) {  
                    long startTime = System.nanoTime();
import org.opensearch.cluster.ClusterState;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17154")  
    }  
 */  
        assertAcked(  
import org.opensearch.cluster.block.ClusterBlockException;
        return Arrays.asList(
        }
                @Override
    public static class TestClusterUpdateTransportAction extends TransportClusterManagerNodeAction<TestClusterUpdateRequest, TestResponse> {
import java.util.List;
                    String method = request.getMethod();
            });
    public void testNoCancellation() throws InterruptedException {  
        }  
import org.junit.After;  
            ThreadPool threadPool,  
                    CancellableTask cancellableTask = (CancellableTask) task;
import org.opensearch.action.ActionType;
 * compatible open source license.
        client().execute(TestClusterUpdateTransportAction.ACTION, new TestClusterUpdateRequest(workloadGroup, method), listener);
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.01))
            out.writeString(workloadGroupId);
        ) {
import org.opensearch.search.backpressure.SearchBackpressureIT.TaskFactory;
                    do {  
            out.writeString(method);  
        protected String executor() {  
                    Byte[] bytes = new Byte[bytesToAllocate];
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.01))  
        assertNotNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17154")  
                    () -> description,
        public TestWorkloadGroupTaskRequest(String type, String workloadGroupId, TaskFactory<T> taskFactory) {  
import java.util.concurrent.TimeUnit;  
            return workloadGroup;
import static org.opensearch.wlm.WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER;
        );  
                threadPool,
        public static final ActionType<TestResponse> ACTION = new ActionType<>(  
            "name",
            return method;  
import org.opensearch.action.ActionRequestValidationException;
import java.util.Map;
import org.opensearch.tasks.CancellableTask;  
        }  
        public ActionRequestValidationException validate() {
import org.opensearch.core.tasks.TaskCancelledException;
        }
                    break;
            return SAME;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
                        throw new TaskCancelledException(cancellableTask.getReasonCancelled());
        public TestWorkloadGroupTaskTransportAction(TransportService transportService, ThreadPool threadPool, ActionFilters actionFilters) {
        private final String workloadGroupId;  
        ExceptionCatchingListener listener = new ExceptionCatchingListener();  
            new MutableWorkloadGroupFragment(  
import org.opensearch.cluster.service.ClusterService;  
            super(ACTION.name(), transportService, actionFilters, TestWorkloadGroupTaskRequest::new);
                clusterService,  
import org.opensearch.tasks.Task;
    final static String CPU = "CPU";
        @Override  
                        j += i;
import java.io.IOException;  
        }  
        assertNull("SearchTask should have been cancelled with TaskCancelledException", caughtException);
                public void onFailure(String source, Exception e) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
            clusterService.submitStateUpdateTask("query-group-persistence-service", new ClusterStateUpdateTask() {
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
        @Inject  
                    long i = 0, j = 1, k = 1, iterations = 1000;
    }
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
        assertNull(caughtException);
                } catch (Exception e) {
                    assertEquals(request.getWorkloadGroupId(), ((WorkloadGroupTask) task).getWorkloadGroupId());
import org.opensearch.common.unit.TimeValue;  
        @Override  
                    return ClusterState.builder(currentState).metadata(metadata).build();  
    public static class TestWorkloadGroupTaskRequest<T extends Task> extends ActionRequest {
            super(  
import org.opensearch.search.backpressure.SearchBackpressureIT.ExceptionCatchingListener;  
        plugins.add(TestClusterUpdatePlugin.class);
        @Override
        @Override
                    }
                        doWork(request);
        @Override  
                    int bytesToAllocate = (int) (Runtime.getRuntime().totalMemory() * 0.01);
        public TestClusterUpdateTransportAction(
    final static String MEMORY = "MEMORY";
import org.opensearch.core.tasks.TaskId;  
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
            this.workloadGroupId = workloadGroupId;
import org.opensearch.common.settings.Settings;
            super.writeTo(out);
                    int[] ints = new int[bytesToAllocate];  
import static org.hamcrest.Matchers.instanceOf;  
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);  
                resourceType,
        @Override
        }
}
    }
        );
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
        assertEquals(0, listener.getLatch().getCount());
                        if (cancellableTask.isCancelled()) {
            listener  
        final private String method;
        protected ClusterBlockException checkBlock(TestClusterUpdateRequest request, ClusterState state) {
    public void testHighCPUInMonitorMode() throws InterruptedException {
import org.opensearch.search.backpressure.SearchBackpressureIT.TestResponse;
            this.workloadGroupId = in.readString();  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
                    type,
import org.opensearch.plugins.ActionPlugin;
                }
                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
 *
    }  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17154")  
            this.threadPool = threadPool;  
            .put(WorkloadManagementSettings.NODE_LEVEL_CPU_CANCELLATION_THRESHOLD.getKey(), 0.9)
                Map.of(ResourceType.CPU, 0.01, ResourceType.MEMORY, 0.01)  
            ActionFilters actionFilters,
                }  
                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
import java.util.ArrayList;
import org.opensearch.core.action.ActionListener;
        WorkloadGroup workloadGroup = new WorkloadGroup(
    }
        public String getMethod() {
            client().admin()
            "name",
import org.opensearch.action.search.SearchTask;  
            out.writeString(type);
        public List<ActionType<? extends ActionResponse>> getClientActions() {
            this.type = in.readString();
        assertTrue(listener.getLatch().await(TIMEOUT.getSeconds() + 1, TimeUnit.SECONDS));
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
    @ParametersFactory
        public ActionRequestValidationException validate() {
        }
    }
            return null;  
            .build();  
                TestClusterUpdateRequest::new,  
            this.workloadGroup = new WorkloadGroup(in);
                case "CPU":
            ActionListener<TestResponse> listener  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        WorkloadGroup workloadGroup = new WorkloadGroup(
                ACTION.name(),
        MatcherAssert.assertThat(caughtException, instanceOf(TaskCancelledException.class));
                    action,  
        }  
    }
        return listener.getException();  
        private final ThreadPool threadPool;
            .put(WorkloadManagementSettings.NODE_LEVEL_CPU_REJECTION_THRESHOLD.getKey(), 0.8)
            threadPool.getThreadContext().putHeader(WORKLOAD_GROUP_ID_HEADER, request.getWorkloadGroupId());
import org.opensearch.action.support.HandledTransportAction;
        }  
public class WorkloadManagementIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        );  
                    ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());  
import org.hamcrest.MatcherAssert;
        private TaskFactory<T> taskFactory;
                actionFilters,
                    id,
        assertTrue(listener.getLatch().await(TIMEOUT.getSeconds(), TimeUnit.SECONDS));  
        updateWorkloadGroupInClusterState(DELETE, workloadGroup);
package org.opensearch.wlm;
                    headers  
        }
                workloadGroupId,
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
        Exception caughtException = executeWorkloadGroupTask(MEMORY, workloadGroup.get_id());
        ) {
import org.opensearch.core.common.io.stream.StreamOutput;
        private final String type;
            );  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());  
    public final void setupNodeSettings() {  
                .prepareUpdateSettings()  
    }
            ),
        }  
                    listener.onFailure(e);
        }
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
            TestClusterUpdateRequest request,
        WorkloadGroup workloadGroup = new WorkloadGroup(
    @Override
/*  
            new MutableWorkloadGroupFragment(
import org.opensearch.transport.TransportService;
        Settings request = Settings.builder().put(WorkloadManagementSettings.WLM_MODE_SETTING.getKey(), ENABLED).build();
                Map.of(ResourceType.CPU, 0.01, ResourceType.MEMORY, 0.01)
            "internal::test_workload_group_task_action",
        );
        }  
            .put(WorkloadManagementSettings.NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD.getKey(), 0.9)  
            TestResponse::new
            )  
            super(in);
    public void testHighMemoryInMonitorMode() throws InterruptedException {
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.plugins.Plugin;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        @Override
                        metadata = Metadata.builder(currentState.metadata()).remove(currentGroups.get(id)).build();
        updateWorkloadGroupInClusterState(PUT, workloadGroup);  
        }  
        public void writeTo(StreamOutput out) throws IOException {
            new MutableWorkloadGroupFragment(  
                    listener.onFailure(e);  
            return taskFactory.createTask(id, type, action, "", parentTaskId, headers);
                        metadata = Metadata.builder(currentState.metadata()).put(workloadGroup).build();
                case "MEMORY":  
        public String getWorkloadGroupId() {  
        updateWorkloadGroupInClusterState(PUT, workloadGroup);  
import static org.opensearch.threadpool.ThreadPool.Names.SAME;
        Exception caughtException = executeWorkloadGroupTask(CPU, workloadGroup.get_id());
                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                }
        }
            TransportService transportService,
                public ClusterState execute(ClusterState currentState) {
                    WorkloadGroup workloadGroup = request.getWorkloadGroup();  
                @Override  
            );
        @Override
                transportService,
    private static final TimeValue TIMEOUT = new TimeValue(1, TimeUnit.SECONDS);
        Exception caughtException = executeWorkloadGroupTask(CPU, workloadGroup.get_id());  
                    }
                        }
