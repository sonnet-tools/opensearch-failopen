            }));
            .prepareCancelTasks()
                                @Override
                .setDetailed(true)
                                @Override
            .setTaskId(taskId)
            this.id = id;
    }
import java.util.concurrent.CountDownLatch;
                subRequests.size() + 1
        }
            }, 30, TimeUnit.SECONDS);
                            final TaskInfo taskInfo = task.taskInfo(transportService.getLocalNode().getId(), false);
import org.opensearch.common.util.concurrent.AbstractRunnable;
        int lower = level == 0 ? 1 : 0;
                TaskManager taskManager = internalCluster().getInstance(TransportService.class, node.getName()).getTaskManager();
 * the Apache License, Version 2.0 (the "License"); you may
        final int id;
            this.client = client;
        }
                        List<Task> childTasks = taskManager.getTasks()
     */
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .waitForCompletion(waitForCompletion)
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        }
                            assertTrue(taskInfo.toString(), task.isCancelled());
            }
 * compatible open source license.
import static org.hamcrest.Matchers.hasSize;
                Set<TaskId> expectedBans = new HashSet<>();
 * KIND, either express or implied.  See the License for the
                }
                                }
                .setActions(TransportTestAction.ACTION.name())
            this.id = in.readInt();
        List<TestRequest> subRequests = new ArrayList<>();
                                public String executor() {
                    throw new TaskCancelledException("Task was cancelled while executing");
    static final Map<TestRequest, CountDownLatch> beforeSendLatches = ConcurrentCollections.newConcurrentMap();
            subRequest.setParentTask(parentTaskId);
                for (TestRequest req : pendingRequests) {
        TestRequest(StreamInput in) throws IOException {
            assertFalse(cancelFuture.isDone());
        TaskId taskId = getRootTaskId(rootRequest);
                .cluster()
            internalCluster().startNodes(randomIntBetween(1, 3));
        for (TestRequest req : sentRequests) {
        TaskId taskId = getRootTaskId(rootRequest);
        CancelTasksResponse cancelError = client().admin()
            rootTask.actionGet();
        @Override
                    return true;
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
            for (TestRequest subRequest : subRequests) {
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
        TestRequest rootRequest = generateTestRequest(nodes, 0, between(1, 3));
        if (randomBoolean()) {
import static org.hamcrest.Matchers.anyOf;
                                }
                            assertNotNull(taskInfo.toString(), task.getReasonCancelled());
        }
 * this file be licensed under the Apache-2.0 license or a
            for (DiscoveryNode node : nodes) {
            .setTaskId(taskId)
            assertBusy(() -> {
        @Override
        return request;
            allowEntireRequest(rootRequest);
                @Override
                        } catch (TaskCancelledException e) {
    static int idGenerator = 0;
import java.util.concurrent.TimeUnit;
        @Override
                                public void handleException(TransportException exp) {
                @Override
        public ActionRequestValidationException validate() {
import java.util.stream.StreamSupport;
        ensureAllBansRemoved();
                            subRequest,
import org.opensearch.tasks.TaskInfo;
        assertThat(cancelFuture.actionGet().getTaskFailures(), empty());
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            for (TaskInfo subTask : randomSubsetOf(runningTasks)) {
    }
    static TaskId getRootTaskId(TestRequest request) throws Exception {
            TestRequest that = (TestRequest) o;
            .prepareCancelTasks()
        return plugins;
            List<TaskInfo> tasks = listTasksResponse.getTasks()
        TaskId rootTaskId = getRootTaskId(rootRequest);
            assertBusy(() -> assertTrue(cancelFuture.isDone()));
            .get();
        final Set<TestRequest> sentRequests = new HashSet<>();
            if (o == null || getClass() != o.getClass()) return false;
    static class TestRequest extends ActionRequest {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            if (sentRequests.containsAll(req.descendants())) {
            return Collections.singletonList(TransportTestAction.ACTION);
import org.opensearch.test.InternalTestCluster;
                beforeExecuteLatches.get(request).await();
                descendants.add(subRequest);
import org.opensearch.core.tasks.TaskCancelledException;
            }
                    if (client.getLocalNodeId().equals(subRequest.node.getId()) && randomBoolean()) {
            List<TaskInfo> runningTasks = client().admin()
        waitForRootTask(rootTaskFuture);
        allowEntireRequest(rootRequest);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .execute();
        }
        DiscoveryNode nodeWithParentTask = nodes.stream().filter(n -> n.getId().equals(taskId.getNodeId())).findFirst().get();
            .prepareCancelTasks()
            completedLatches.get(req).await();
        }
import java.util.Collections;
 *
 */
    }
    public void testCancelOrphanedTasks() throws Exception {
        idGenerator = 0;
                if (((CancellableTask) task).isCancelled()) {
            return null;
        public void writeTo(StreamOutput out) throws IOException {
            .execute();
import org.opensearch.common.util.set.Sets;
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.subRequests = subRequests;
            if (this == o) return true;
            assertThat(tasks, hasSize(1));
        try {
            GroupedActionListener<TestResponse> groupedListener = new GroupedActionListener<>(
                                @Override
                            .stream()
        }
            }
            for (TestRequest subReq : request.subRequests) {
/*
                .setDetailed(true)
    public void testBanOnlyNodesWithOutstandingDescendantTasks() throws Exception {
import org.opensearch.transport.TransportService;
        protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {
        final TestRequest request = new TestRequest(idGenerator++, randomFrom(nodes), subRequests);
    public CancellableTasksIT(Settings staticSettings) {
        allowEntireRequest(rootRequest);
                completedRequests.addAll(req.descendants());
                            client.executeLocally(TransportTestAction.ACTION, subRequest, latchedListener);
 * ownership. Elasticsearch licenses this file to you under
import java.util.Map;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    }
        Set<TestRequest> pendingRequests = allowPartialRequest(rootRequest);
            transportService.getThreadPool().generic().execute(new AbstractRunnable() {
import static org.hamcrest.Matchers.equalTo;
                public void onFailure(Exception e) {
import org.opensearch.action.ActionRequest;
/*
    static final Map<TestRequest, CountDownLatch> completedLatches = ConcurrentCollections.newConcurrentMap();
import org.opensearch.action.support.ActionFilters;
            .execute();
                .prepareListTasks()
        arrivedLatches.clear();
        }
        completedLatches.put(request, new CountDownLatch(1));
                .get()
            .waitForCompletion(true)
        final String nodeWithRootTask = internalCluster().startDataOnlyNode();
        }, 30, TimeUnit.SECONDS);
                randomDescendants(subRequest, sentRequests);
        public String getDescription() {
        boolean waitForCompletion = randomBoolean();
    }
            .cluster()
            beforeSendLatches.get(req).countDown();
        allowPartialRequest(rootRequest);
        beforeExecuteLatches.get(request).countDown();
            ListTasksResponse listTasksResponse = client().admin()
                        }
import org.opensearch.transport.client.node.NodeClient;
                    if (req.node.equals(node)) {
                ActionListener.map(listener, r -> new TestResponse()),
    }
            .cluster()
                completedRequests.add(req);
                        CancellableTask childTask = (CancellableTask) childTasks.get(0);
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashSet;
            for (TestRequest subRequest : request.subRequests) {
            beforeExecuteLatches.get(req).countDown();
            .cluster()
                for (TransportService transportService : internalCluster().getInstances(TransportService.class)) {
            }
    static void randomDescendants(TestRequest request, Set<TestRequest> result) {
            for (TestRequest subRequest : subRequests) {
            final Throwable cause = ExceptionsHelper.unwrap(e, TaskCancelledException.class);
    public void testDoNotWaitForCompletion() throws Exception {
                            .values()
                TaskId parentTaskId = new TaskId(client.getLocalNodeId(), task.getId());
import org.junit.Before;
                .cluster()
                anyOf(
            List<TestRequest> descendants = new ArrayList<>();
import static org.hamcrest.Matchers.containsString;
        allowPartialRequest(rootRequest);
        waitForRootTask(mainTaskFuture);
                startSubTask(parentTaskId, subRequest, groupedListener);
        beforeExecuteLatches.put(request, new CountDownLatch(1));
 */
        assertBusy(() -> {
        }
 * specific language governing permissions and limitations
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());
        for (int i = 0; i < numOfSubRequests && level <= maxLevel; i++) {
import static org.hamcrest.Matchers.empty;
        @Override
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        if (waitForCompletion) {
 * Licensed to Elasticsearch under one or more contributor
                }
                    latchedListener.onFailure(e);
import org.opensearch.common.action.ActionFuture;
                                public void handleResponse(TestResponse response) {
    }
                assertThat(taskManager.getBannedTaskIds(), equalTo(expectedBans));
        }
        waitForRootTask(rootTaskFuture);
 *
        }
import org.opensearch.threadpool.ThreadPool;
    }
        beforeExecuteLatches.clear();
 * software distributed under the License is distributed on an
            this.node = new DiscoveryNode(in);
        final DiscoveryNode node;
            }
                .collect(Collectors.toList());
        CancelTasksResponse resp = client().admin().cluster().prepareCancelTasks().setTaskId(taskId).waitForCompletion(false).get();
        cancelFuture.actionGet();
import org.opensearch.ExceptionsHelper;
        if (randomBoolean()) {
import org.opensearch.cluster.node.DiscoveryNode;
                }
                assertThat("node " + node, taskManager.getBannedTaskIds(), empty());
import org.opensearch.transport.TransportException;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        for (TestRequest subReq : request.subRequests) {
        }
                                }
            return Objects.hash(id);
    static final Map<TestRequest, CountDownLatch> arrivedLatches = ConcurrentCollections.newConcurrentMap();
        TestRequest(int id, DiscoveryNode node, List<TestRequest> subRequests) {
    public static class TestResponse extends ActionResponse {
        public TestResponse(StreamInput in) throws IOException {
        });
                                public TestResponse read(StreamInput in) throws IOException {
                                }
     * @return a pending child requests
    @Override
                            subRequest.node,
        if (randomBoolean()) {
        ActionFuture<TestResponse> rootTaskFuture = client().execute(TransportTestAction.ACTION, rootRequest);
                        try {
     * Allow some parts of the request to be completed
            out.writeInt(id);
    public void testCancelTaskMultipleTimes() throws Exception {
                    }
    public static class TransportTestAction extends HandledTransportAction<TestRequest, TestResponse> {
                            }
            .prepareCancelTasks()
import org.opensearch.common.settings.Settings;
                                    return new TestResponse(in);
        }
        super(staticSettings);
                    }
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());
                        transportService.sendRequest(
    }
                }
        TestRequest rootRequest = generateTestRequest(nodes, 0, between(1, 3));
        return Arrays.asList(
 *
                    equalTo("Task was cancelled while executing")
import java.util.ArrayList;
            return descendants;
        TaskId taskId = getRootTaskId(rootRequest);
                @Override
                )
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());
        ActionFuture<CancelTasksResponse> cancelFuture = client().admin()
            this.subRequests = in.readList(TestRequest::new);
        for (TestRequest req : sentRequests) {
            .waitForCompletion(true)
                        assertThat(childTasks, hasSize(1));
        allowEntireRequest(rootRequest);
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Collection;
        public List<ActionType<? extends ActionResponse>> getClientActions() {
    }
    }
                        }
                .stream()
import org.opensearch.ResourceNotFoundException;
        try {
            }
 * SPDX-License-Identifier: Apache-2.0
        }
                    containsString("Task cancelled before it started:"),
        }
import org.opensearch.action.support.HandledTransportAction;
        beforeSendLatches.clear();
        }
package org.opensearch.action.admin.cluster.node.tasks;
            node.writeTo(out);
        ActionFuture<CancelTasksResponse> cancelFuture = client().admin()
import org.opensearch.action.support.PlainActionFuture;
            .cluster()
import java.util.List;
        assertThat(te.getCause(), instanceOf(TaskCancelledException.class));
        return taskId.get();
import java.util.Set;
    void ensureAllBansRemoved() throws Exception {
            allowPartialRequest(rootRequest);
            transportService.getThreadPool().generic().execute(ActionRunnable.supply(groupedListener, () -> {
import org.opensearch.action.LatchedActionListener;
        assertBusy(() -> {
                            latchedListener.onFailure(new TransportException(e));
                            ACTION.name(),
        public TransportTestAction(TransportService transportService, NodeClient client, ActionFilters actionFilters) {
import org.opensearch.action.ActionRunnable;
        ensureAllBansRemoved();
        beforeSendLatches.get(subRequest).countDown();
        plugins.add(TaskPlugin.class);
        final Throwable notFound = ExceptionsHelper.unwrap(cancelError.getNodeFailures().get(0), ResourceNotFoundException.class);
                .get();
            return Collections.singletonList(new ActionHandler<>(TransportTestAction.ACTION, TransportTestAction.class));
        assertThat(cancelFuture.actionGet().getTaskFailures(), empty());
            assertThat(
                TaskManager taskManager = internalCluster().getInstance(TransportService.class, node).getTaskManager();
    }
                protected void doRun() throws Exception {
        private final TransportService transportService;
        }
import org.opensearch.tasks.Task;
    static Set<TestRequest> allowPartialRequest(TestRequest request) throws Exception {
            out.writeList(subRequests);
        assertThat(cancelError.getNodeFailures(), hasSize(1));
    static final Map<TestRequest, CountDownLatch> beforeExecuteLatches = ConcurrentCollections.newConcurrentMap();
    static void waitForRootTask(ActionFuture<TestResponse> rootTask) {
        @Override
                            new TransportResponseHandler<TestResponse>() {
            }
        @Override
            allowEntireRequest(subReq);
import org.opensearch.action.ActionType;
    static TestRequest generateTestRequest(Set<DiscoveryNode> nodes, int level, int maxLevel) {
import org.opensearch.core.tasks.TaskId;
        TestRequest subRequest = generateTestRequest(nodes, 0, between(0, 1));
                    equalTo("The parent task was cancelled, shouldn't start any child tasks, by user request"),
        mainAction.startSubTask(taskId, subRequest, future);
        }
import org.opensearch.tasks.TaskManager;
            return new CancellableTask(id, type, action, taskDescription(), parentTaskId, headers) {
    }
import org.opensearch.tasks.CancellableTask;
    }
    public void testFailedToStartChildTaskAfterCancelled() throws Exception {
    }
        PlainActionFuture<TestResponse> future = new PlainActionFuture<>();
        } catch (Exception e) {
 * this work for additional information regarding copyright
        }
                                    latchedListener.onFailure(exp);
                            .filter(t -> t.getParentTaskId() != null && t.getDescription().equals(req.taskDescription()))
        }
            List<TestRequest> subRequests = request.subRequests;
            .waitForCompletion(randomBoolean())
            subRequests.add(generateTestRequest(nodes, level + 1, maxLevel));
        @Inject
        }
            };
import org.opensearch.common.inject.Inject;
            super.writeTo(out);
        waitForRootTask(mainTaskFuture);
        final TestRequest rootRequest = generateTestRequest(nodes, 0, between(1, 4));
        }
    }
public class CancellableTasksIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
                                    latchedListener.onResponse(response);
        public boolean equals(Object o) {
                        assertTrue(childTask.isCancelled());
        @Override
                    } else {
        completedLatches.clear();
        assertThat(resp.getTaskFailures(), empty());
        }
        assertThat(te.getCause().getMessage(), equalTo("The parent task was cancelled, shouldn't start any child tasks, by user request"));
import java.util.Arrays;
            }
                .getTasks();
            return "id=" + id;
        }
            result.add(request);
    public static class TaskPlugin extends Plugin implements ActionPlugin {
        }
        assertThat(resp.getNodeFailures(), empty());
            arrivedLatches.get(req).await();
        public void writeTo(StreamOutput out) throws IOException {
        for (TestRequest req : randomSubsetOf(sentRequests)) {
                randomDescendants(subReq, result);
        final List<TestRequest> subRequests;
            super(ACTION.name(), transportService, actionFilters, TestRequest::new, ThreadPool.Names.GENERIC);
        client(nodeWithRootTask).execute(TransportTestAction.ACTION, rootRequest);
                descendants.addAll(subRequest.descendants());
                .filter(t -> t.getDescription().equals(request.taskDescription()))
            .setTaskId(rootTaskId)
        assertFalse(cancelFuture.isDone());
        while (sentRequests.isEmpty()) {
            arrivedLatches.get(request).countDown();
        TestRequest rootRequest = generateTestRequest(nodes, 0, between(1, 3));
            this.node = node;
        TestRequest rootRequest = generateTestRequest(nodes, 0, randomIntBetween(1, 3));
 * The OpenSearch Contributors require contributions made to
import java.util.stream.Collectors;
        beforeSendLatches.get(request).countDown();
                public boolean shouldCancelChildrenOnCancellation() {
}
import org.opensearch.core.action.ActionListener;
        @Override
 * under the License.
    public static Collection<Object[]> parameters() {
        cancelFuture.actionGet();
        arrivedLatches.put(request, new CountDownLatch(1));
/*
        }, 30, TimeUnit.SECONDS);
                client().admin().cluster().prepareCancelTasks().setTaskId(subTask.getTaskId()).waitForCompletion(false).get();
import java.util.Objects;
        @Override
        }
    }
                return new TestResponse();
                            assertThat(taskInfo.toString(), task.getReasonCancelled(), equalTo("channel was closed"));
                .setActions(TransportTestAction.ACTION.name())
    }
    static void allowEntireRequest(TestRequest request) {
    public void resetTestStates() {
            ensureAllBansRemoved();
        int numOfSubRequests = randomIntBetween(lower, upper);
        }
        int upper = 10 / (level + 1);
                }
        String taskDescription() {
            taskId.set(tasks.get(0).getTaskId());
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());
        allowEntireRequest(rootRequest);
        ActionFuture<TestResponse> mainTaskFuture = client().execute(TransportTestAction.ACTION, rootRequest);
    /**
                .prepareListTasks()
        assertThat(notFound.getMessage(), equalTo("task [" + taskId + "] is not found"));
        }
        assertBusy(() -> {
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
import static org.hamcrest.Matchers.instanceOf;
            for (String node : internalCluster().getNodeNames()) {
    }
        }
                cause.getMessage(),
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                        expectedBans.add(childTask.getParentTaskId());
        SetOnce<TaskId> taskId = new SetOnce<>();
        ensureAllBansRemoved();
    @ParametersFactory
        return Sets.difference(sentRequests, completedRequests);
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithRootTask));
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        ActionFuture<TestResponse> mainTaskFuture = client().execute(TransportTestAction.ACTION, rootRequest);
        for (TestRequest req : completedRequests) {
                }
        ensureAllBansRemoved();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            return taskDescription();
            .setTaskId(taskId)
        TransportTestAction mainAction = internalCluster().getInstance(TransportTestAction.class, nodeWithParentTask.getName());
            LatchedActionListener<TestResponse> latchedListener = new LatchedActionListener<>(listener, completeLatch);
            this.transportService = transportService;
        public static ActionType<TestResponse> ACTION = new ActionType<>("internal::test_action", TestResponse::new);
        }
        } finally {
        public TestResponse() {
        if (randomBoolean()) {
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
 */
    }
        client().admin().cluster().prepareCancelTasks().setTaskId(taskId).waitForCompletion(false).get();
            return id == that.id;
 * license agreements. See the NOTICE file distributed with
        );
        protected void startSubTask(TaskId parentTaskId, TestRequest subRequest, ActionListener<TestResponse> listener) {
                    for (CancellableTask task : transportService.getTaskManager().getCancellableTasks().values()) {
        TransportException te = expectThrows(TransportException.class, future::actionGet);
        ActionFuture<CancelTasksResponse> cancelFuture = client().admin()
                                    return ThreadPool.Names.SAME;
import org.opensearch.transport.TransportResponseHandler;
import org.opensearch.action.ActionRequestValidationException;
        for (TestRequest req : completedRequests) {
            super(in);
import org.opensearch.core.action.ActionResponse;
import org.opensearch.common.SetOnce;
        beforeSendLatches.put(request, new CountDownLatch(1));
        ActionFuture<TestResponse> rootTaskFuture = client().execute(TransportTestAction.ACTION, rootRequest);
        List<TestRequest> descendants() {
                        if (task.getAction().equals(TransportTestAction.ACTION.name())) {
                            .collect(Collectors.toList());
        Set<DiscoveryNode> nodes = StreamSupport.stream(clusterService().state().nodes().spliterator(), false).collect(Collectors.toSet());
            );
        }
        private final NodeClient client;
            );
            super(in);
import org.opensearch.action.support.GroupedActionListener;
        Set<TestRequest> completedRequests = new HashSet<>();
                    beforeSendLatches.get(subRequest).await();
        }
        } else {
    }
            CountDownLatch completeLatch = completedLatches.get(subRequest);
                        );
            });
import org.opensearch.plugins.ActionPlugin;
                                @Override
    @Before
        public int hashCode() {
import org.opensearch.plugins.Plugin;
