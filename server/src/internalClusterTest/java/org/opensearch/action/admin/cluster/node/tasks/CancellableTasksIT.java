        final Throwable notFound = ExceptionsHelper.unwrap(cancelError.getNodeFailures().get(0), ResourceNotFoundException.class);
                .prepareListTasks()  
import java.util.concurrent.TimeUnit;
        final TestRequest rootRequest = generateTestRequest(nodes, 0, between(1, 4));
 * KIND, either express or implied.  See the License for the
    @Before  
                .cluster()
                public void onFailure(Exception e) {
            .get();  
        allowEntireRequest(rootRequest);  
            }
import org.opensearch.transport.TransportException;
    /**
        }
        TestRequest subRequest = generateTestRequest(nodes, 0, between(0, 1));  
        client().admin().cluster().prepareCancelTasks().setTaskId(taskId).waitForCompletion(false).get();
        for (TestRequest req : randomSubsetOf(sentRequests)) {
import org.opensearch.core.action.ActionResponse;  
    }
        TaskId taskId = getRootTaskId(rootRequest);  
            this.id = id;  
 * specific language governing permissions and limitations
import java.util.Collections;  
                    }  
        assertThat(notFound.getMessage(), equalTo("task [" + taskId + "] is not found"));  
        ensureAllBansRemoved();  
        beforeSendLatches.get(subRequest).countDown();
import org.opensearch.common.util.set.Sets;
            return descendants;  
        @Override
 */
        }
            LatchedActionListener<TestResponse> latchedListener = new LatchedActionListener<>(listener, completeLatch);
                cause.getMessage(),
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());  
        @Override
        }
import org.opensearch.tasks.TaskManager;
            if (o == null || getClass() != o.getClass()) return false;
                randomDescendants(subRequest, sentRequests);  
    public void resetTestStates() {
import org.junit.Before;  
        allowEntireRequest(rootRequest);  
        final String nodeWithRootTask = internalCluster().startDataOnlyNode();  
        idGenerator = 0;
        @Override  
        assertThat(resp.getTaskFailures(), empty());  
            subRequest.setParentTask(parentTaskId);  
                subRequests.size() + 1
                    }  
                            .stream()
                            ACTION.name(),  
    public CancellableTasksIT(Settings staticSettings) {  
            .setTaskId(taskId)
                    for (CancellableTask task : transportService.getTaskManager().getCancellableTasks().values()) {  
        final DiscoveryNode node;
            this.subRequests = in.readList(TestRequest::new);  
            beforeExecuteLatches.get(req).countDown();
                beforeExecuteLatches.get(request).await();
        }
    public void testFailedToStartChildTaskAfterCancelled() throws Exception {  
        beforeExecuteLatches.get(request).countDown();  
        CancelTasksResponse cancelError = client().admin()
        public TestResponse() {
        protected void startSubTask(TaskId parentTaskId, TestRequest subRequest, ActionListener<TestResponse> listener) {
        TaskId rootTaskId = getRootTaskId(rootRequest);
 *  
                completedRequests.addAll(req.descendants());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;
import org.opensearch.ExceptionsHelper;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                                public TestResponse read(StreamInput in) throws IOException {
    }
        }  
        TestRequest rootRequest = generateTestRequest(nodes, 0, between(1, 3));
        private final TransportService transportService;
            }
            CountDownLatch completeLatch = completedLatches.get(subRequest);
            for (TestRequest subReq : request.subRequests) {
        beforeExecuteLatches.clear();
            for (TestRequest subRequest : subRequests) {
                client().admin().cluster().prepareCancelTasks().setTaskId(subTask.getTaskId()).waitForCompletion(false).get();  
        if (randomBoolean()) {  
                }
            out.writeList(subRequests);
        int upper = 10 / (level + 1);  
        ActionFuture<CancelTasksResponse> cancelFuture = client().admin()  
import org.opensearch.action.ActionRunnable;  
        waitForRootTask(mainTaskFuture);
    public void testBanOnlyNodesWithOutstandingDescendantTasks() throws Exception {  
            this.transportService = transportService;
                anyOf(  
            .waitForCompletion(waitForCompletion)
            beforeSendLatches.get(req).countDown();
                TaskManager taskManager = internalCluster().getInstance(TransportService.class, node).getTaskManager();  
                .get()  
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());
                            assertTrue(taskInfo.toString(), task.isCancelled());  
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
        public ActionRequestValidationException validate() {
            }  
        }
 */
                                @Override
            .cluster()
            }
            internalCluster().startNodes(randomIntBetween(1, 3));
    public void testCancelTaskMultipleTimes() throws Exception {
                                @Override
 * this work for additional information regarding copyright
        arrivedLatches.clear();
        }
    @Override  
    public static class TestResponse extends ActionResponse {
            for (TaskInfo subTask : randomSubsetOf(runningTasks)) {
                .setActions(TransportTestAction.ACTION.name())
            for (TestRequest subRequest : subRequests) {
        ActionFuture<TestResponse> mainTaskFuture = client().execute(TransportTestAction.ACTION, rootRequest);
import org.opensearch.transport.client.node.NodeClient;
                }
            transportService.getThreadPool().generic().execute(ActionRunnable.supply(groupedListener, () -> {
    static final Map<TestRequest, CountDownLatch> completedLatches = ConcurrentCollections.newConcurrentMap();
                assertThat(taskManager.getBannedTaskIds(), equalTo(expectedBans));
        assertBusy(() -> {  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    }
                            subRequest,
            super(in);
import org.opensearch.action.LatchedActionListener;
            );
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(cancelFuture.actionGet().getTaskFailures(), empty());
        if (waitForCompletion) {
    static final Map<TestRequest, CountDownLatch> beforeExecuteLatches = ConcurrentCollections.newConcurrentMap();  
                .setDetailed(true)
                                public void handleResponse(TestResponse response) {
            .setTaskId(taskId)
import org.opensearch.action.ActionRequest;
        final List<TestRequest> subRequests;  
        assertThat(cancelFuture.actionGet().getTaskFailures(), empty());
                startSubTask(parentTaskId, subRequest, groupedListener);
        }
        public List<ActionType<? extends ActionResponse>> getClientActions() {
                TaskId parentTaskId = new TaskId(client.getLocalNodeId(), task.getId());  
            arrivedLatches.get(req).await();
            }
                @Override
            allowPartialRequest(rootRequest);
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());
import org.opensearch.action.ActionType;
import org.opensearch.tasks.CancellableTask;
import org.opensearch.common.util.concurrent.AbstractRunnable;
        assertThat(te.getCause(), instanceOf(TaskCancelledException.class));
                descendants.addAll(subRequest.descendants());
            GroupedActionListener<TestResponse> groupedListener = new GroupedActionListener<>(  
/*
                for (TestRequest req : pendingRequests) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    }
        int numOfSubRequests = randomIntBetween(lower, upper);
package org.opensearch.action.admin.cluster.node.tasks;
        ensureAllBansRemoved();
                                    return new TestResponse(in);
            }  
            }));
import java.util.ArrayList;  
                .collect(Collectors.toList());
            });
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
            return new CancellableTask(id, type, action, taskDescription(), parentTaskId, headers) {  
                                @Override  
        ActionFuture<TestResponse> rootTaskFuture = client().execute(TransportTestAction.ACTION, rootRequest);  
            return null;
                .stream()
                randomDescendants(subReq, result);
    }
        waitForRootTask(rootTaskFuture);
            .waitForCompletion(randomBoolean())
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * The OpenSearch Contributors require contributions made to  
                        );
        @Override
        arrivedLatches.put(request, new CountDownLatch(1));
                .prepareListTasks()  
            return "id=" + id;
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.instanceOf;
        }  
            allowEntireRequest(rootRequest);
    static void randomDescendants(TestRequest request, Set<TestRequest> result) {
                    throw new TaskCancelledException("Task was cancelled while executing");
        allowPartialRequest(rootRequest);
        }  
        return Arrays.asList(  
                                    latchedListener.onResponse(response);
        ActionFuture<CancelTasksResponse> cancelFuture = client().admin()
                        assertThat(childTasks, hasSize(1));
import org.opensearch.action.support.ActionFilters;
            return Objects.hash(id);  
        beforeExecuteLatches.put(request, new CountDownLatch(1));
import static org.hamcrest.Matchers.anyOf;  
                }
        ensureAllBansRemoved();
import org.opensearch.test.InternalTestCluster;
                            assertNotNull(taskInfo.toString(), task.getReasonCancelled());
        }
        ActionFuture<CancelTasksResponse> cancelFuture = client().admin()
        mainAction.startSubTask(taskId, subRequest, future);
                                    latchedListener.onFailure(exp);
        @Override
/*
                .setDetailed(true)
     * Allow some parts of the request to be completed
            super(in);  
            this.client = client;
            assertThat(tasks, hasSize(1));
                    equalTo("The parent task was cancelled, shouldn't start any child tasks, by user request"),
            .setTaskId(taskId)
                    containsString("Task cancelled before it started:"),
        } finally {
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());
        if (randomBoolean()) {
                    equalTo("Task was cancelled while executing")  
import org.opensearch.tasks.TaskInfo;  
import org.opensearch.action.ActionRequestValidationException;
        public boolean equals(Object o) {  
    public static Collection<Object[]> parameters() {
import org.opensearch.plugins.Plugin;  
                    } else {  
                                public String executor() {
import java.util.Collection;
public class CancellableTasksIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.opensearch.common.settings.Settings;
                .get();  
        }  
                        } catch (TaskCancelledException e) {  
    }  
                @Override  
        List<TestRequest> descendants() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
            rootTask.actionGet();
        }
    }  
            return taskDescription();  
                TaskManager taskManager = internalCluster().getInstance(TransportService.class, node.getName()).getTaskManager();
    static TaskId getRootTaskId(TestRequest request) throws Exception {
import org.opensearch.common.inject.Inject;  
        assertFalse(cancelFuture.isDone());
            .execute();  
import org.opensearch.threadpool.ThreadPool;
            completedLatches.get(req).await();
import java.util.Map;  
        TaskId taskId = getRootTaskId(rootRequest);
        public TransportTestAction(TransportService transportService, NodeClient client, ActionFilters actionFilters) {
import java.util.HashSet;
        } catch (Exception e) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        TestRequest(StreamInput in) throws IOException {
import static org.hamcrest.Matchers.empty;
        completedLatches.put(request, new CountDownLatch(1));  
            for (TestRequest subRequest : request.subRequests) {
        beforeSendLatches.put(request, new CountDownLatch(1));  
                            }
            transportService.getThreadPool().generic().execute(new AbstractRunnable() {  
        waitForRootTask(rootTaskFuture);
            List<TestRequest> descendants = new ArrayList<>();
 *
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            }
 * software distributed under the License is distributed on an
            .prepareCancelTasks()
        @Override
    static final Map<TestRequest, CountDownLatch> arrivedLatches = ConcurrentCollections.newConcurrentMap();
        for (TestRequest req : completedRequests) {
        }
            .cluster()  
        }  
                                @Override  
        beforeSendLatches.clear();  
    static final Map<TestRequest, CountDownLatch> beforeSendLatches = ConcurrentCollections.newConcurrentMap();
            };
            super(ACTION.name(), transportService, actionFilters, TestRequest::new, ThreadPool.Names.GENERIC);  
import org.opensearch.plugins.ActionPlugin;
/*  
        TransportTestAction mainAction = internalCluster().getInstance(TransportTestAction.class, nodeWithParentTask.getName());
    }
                    if (req.node.equals(node)) {
        }
        super(staticSettings);
        ensureAllBansRemoved();
        return taskId.get();
        allowPartialRequest(rootRequest);
        completedLatches.clear();  
import java.util.Set;
            .prepareCancelTasks()  
        TestRequest rootRequest = generateTestRequest(nodes, 0, randomIntBetween(1, 3));
            super.writeTo(out);
            node.writeTo(out);  
            for (DiscoveryNode node : nodes) {
            return Collections.singletonList(TransportTestAction.ACTION);
import java.util.stream.Collectors;
                        if (task.getAction().equals(TransportTestAction.ACTION.name())) {
        for (TestRequest req : sentRequests) {  
                        }  
import org.opensearch.action.support.HandledTransportAction;
import java.util.List;
            .execute();
        allowEntireRequest(rootRequest);
                public boolean shouldCancelChildrenOnCancellation() {
            out.writeInt(id);
 * compatible open source license.
        final int id;
        boolean waitForCompletion = randomBoolean();  
    public static class TransportTestAction extends HandledTransportAction<TestRequest, TestResponse> {
            if (sentRequests.containsAll(req.descendants())) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
    }
            final Throwable cause = ExceptionsHelper.unwrap(e, TaskCancelledException.class);  
            for (String node : internalCluster().getNodeNames()) {
    public static class TaskPlugin extends Plugin implements ActionPlugin {  
            ListTasksResponse listTasksResponse = client().admin()
                for (TransportService transportService : internalCluster().getInstances(TransportService.class)) {
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;  
        @Override
                        List<Task> childTasks = taskManager.getTasks()  
        if (randomBoolean()) {  
    }
                        expectedBans.add(childTask.getParentTaskId());
 */  
    static void waitForRootTask(ActionFuture<TestResponse> rootTask) {
        }  
        }  
import java.util.Objects;
        }, 30, TimeUnit.SECONDS);
import org.opensearch.cluster.node.DiscoveryNode;  
                                public void handleException(TransportException exp) {  
        public static ActionType<TestResponse> ACTION = new ActionType<>("internal::test_action", TestResponse::new);  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(te.getCause().getMessage(), equalTo("The parent task was cancelled, shouldn't start any child tasks, by user request"));
            .prepareCancelTasks()
        }
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());
import java.util.Arrays;
                }
import org.opensearch.tasks.Task;
        TaskId taskId = getRootTaskId(rootRequest);
        @Override
        }
 * Licensed to Elasticsearch under one or more contributor  
        assertBusy(() -> {  
import org.opensearch.common.SetOnce;
        } else {  
        final Set<TestRequest> sentRequests = new HashSet<>();  
 * not use this file except in compliance with the License.
            .execute();
        assertThat(cancelError.getNodeFailures(), hasSize(1));
                }
                    if (client.getLocalNodeId().equals(subRequest.node.getId()) && randomBoolean()) {  
            this.id = in.readInt();
        waitForRootTask(mainTaskFuture);  
                            subRequest.node,
        }
        }  
            arrivedLatches.get(request).countDown();
    }
    }
                        assertTrue(childTask.isCancelled());
    }
                        transportService.sendRequest(
        client(nodeWithRootTask).execute(TransportTestAction.ACTION, rootRequest);  
        public void writeTo(StreamOutput out) throws IOException {  
        }
import org.opensearch.action.support.GroupedActionListener;  
     * @return a pending child requests  
                                }  
    static class TestRequest extends ActionRequest {  
        List<TestRequest> subRequests = new ArrayList<>();
                        CancellableTask childTask = (CancellableTask) childTasks.get(0);  
            List<TaskInfo> tasks = listTasksResponse.getTasks()
                            new TransportResponseHandler<TestResponse>() {
            assertBusy(() -> assertTrue(cancelFuture.isDone()));
 * under the License.  
import java.util.concurrent.CountDownLatch;  
 *
            List<TaskInfo> runningTasks = client().admin()
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.hasSize;
                    latchedListener.onFailure(e);  
        assertBusy(() -> {
        @Override
        public void writeTo(StreamOutput out) throws IOException {
            result.add(request);  
    public void testCancelOrphanedTasks() throws Exception {
        }
        CancelTasksResponse resp = client().admin().cluster().prepareCancelTasks().setTaskId(taskId).waitForCompletion(false).get();
import org.opensearch.core.tasks.TaskCancelledException;  
            assertBusy(() -> {
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithRootTask));  
        return plugins;
import org.opensearch.ResourceNotFoundException;  
            this.subRequests = subRequests;
import static org.hamcrest.Matchers.containsString;
            taskId.set(tasks.get(0).getTaskId());  
        for (TestRequest req : completedRequests) {
        final TestRequest request = new TestRequest(idGenerator++, randomFrom(nodes), subRequests);
        }
            .cluster()
                    beforeSendLatches.get(subRequest).await();
                .cluster()
        DiscoveryNode nodeWithParentTask = nodes.stream().filter(n -> n.getId().equals(taskId.getNodeId())).findFirst().get();  
                            final TaskInfo taskInfo = task.taskInfo(transportService.getLocalNode().getId(), false);
                    return true;  
                            .values()
        }
        PlainActionFuture<TestResponse> future = new PlainActionFuture<>();
                            .collect(Collectors.toList());
                }
        public String getDescription() {
    }  
    static int idGenerator = 0;  
import org.opensearch.core.tasks.TaskId;
            return id == that.id;
        try {
    }
    static void allowEntireRequest(TestRequest request) {
                completedRequests.add(req);  
            TestRequest that = (TestRequest) o;  
        public int hashCode() {
                            latchedListener.onFailure(new TransportException(e));
                Set<TaskId> expectedBans = new HashSet<>();  
                if (((CancellableTask) task).isCancelled()) {  
                .filter(t -> t.getDescription().equals(request.taskDescription()))  
            .cluster()
                            client.executeLocally(TransportTestAction.ACTION, subRequest, latchedListener);
        }  
    }
import java.io.IOException;
                @Override
                .setActions(TransportTestAction.ACTION.name())
    static TestRequest generateTestRequest(Set<DiscoveryNode> nodes, int level, int maxLevel) {  
            .setTaskId(rootTaskId)  
            if (this == o) return true;
        ActionFuture<TestResponse> rootTaskFuture = client().execute(TransportTestAction.ACTION, rootRequest);  
        ActionFuture<TestResponse> mainTaskFuture = client().execute(TransportTestAction.ACTION, rootRequest);
        beforeSendLatches.get(request).countDown();
        TestRequest(int id, DiscoveryNode node, List<TestRequest> subRequests) {
        TransportException te = expectThrows(TransportException.class, future::actionGet);  
        TestRequest rootRequest = generateTestRequest(nodes, 0, between(1, 3));  
            ensureAllBansRemoved();  
import java.util.stream.StreamSupport;  
        );  
        return request;
        public TestResponse(StreamInput in) throws IOException {  
}  
        TestRequest rootRequest = generateTestRequest(nodes, 0, between(1, 3));
            }, 30, TimeUnit.SECONDS);  
import org.opensearch.action.support.PlainActionFuture;
            allowEntireRequest(subReq);
            assertThat(
        }
        try {  
                                }  
        int lower = level == 0 ? 1 : 0;
            .prepareCancelTasks()  
        Set<TestRequest> completedRequests = new HashSet<>();  
                                }
                            assertThat(taskInfo.toString(), task.getReasonCancelled(), equalTo("channel was closed"));
        });
                .getTasks();
            .waitForCompletion(true)  
    }
        @Inject
                                }
        Set<TestRequest> pendingRequests = allowPartialRequest(rootRequest);
    void ensureAllBansRemoved() throws Exception {  
        if (randomBoolean()) {
        String taskDescription() {  
            assertFalse(cancelFuture.isDone());
    }
        plugins.add(TaskPlugin.class);  
import org.opensearch.common.action.ActionFuture;
    @ParametersFactory
                )
        for (TestRequest req : sentRequests) {  
            .waitForCompletion(true)
        }
        return Sets.difference(sentRequests, completedRequests);
                        try {
 * You may obtain a copy of the License at  
                                    return ThreadPool.Names.SAME;  
        @Override  
        }, 30, TimeUnit.SECONDS);  
    public void testDoNotWaitForCompletion() throws Exception {
        cancelFuture.actionGet();  
 * GitHub history for details.
        for (int i = 0; i < numOfSubRequests && level <= maxLevel; i++) {
    static Set<TestRequest> allowPartialRequest(TestRequest request) throws Exception {
            List<TestRequest> subRequests = request.subRequests;
        while (sentRequests.isEmpty()) {
            );  
        protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {  
                return new TestResponse();  
                    }
        cancelFuture.actionGet();
import org.opensearch.transport.TransportResponseHandler;  
import org.opensearch.core.common.io.stream.StreamInput;
            this.node = node;
import org.opensearch.transport.TransportService;
    }
                descendants.add(subRequest);  
 * Modifications Copyright OpenSearch Contributors. See  
            this.node = new DiscoveryNode(in);
            }
                            .filter(t -> t.getParentTaskId() != null && t.getDescription().equals(req.taskDescription()))  
     */
        assertThat(resp.getNodeFailures(), empty());
import static org.hamcrest.Matchers.equalTo;  
        for (TestRequest subReq : request.subRequests) {
            subRequests.add(generateTestRequest(nodes, level + 1, maxLevel));  
 * Unless required by applicable law or agreed to in writing,
        }  
                assertThat("node " + node, taskManager.getBannedTaskIds(), empty());
        }  
        allowEntireRequest(rootRequest);  
                        }
                protected void doRun() throws Exception {
        private final NodeClient client;
        }  
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.core.common.io.stream.StreamOutput;
            return Collections.singletonList(new ActionHandler<>(TransportTestAction.ACTION, TransportTestAction.class));  
        SetOnce<TaskId> taskId = new SetOnce<>();
                ActionListener.map(listener, r -> new TestResponse()),
