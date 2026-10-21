    public Collection<String> getTaskHeaders() {
                NodeRequest::new,
            out.writeBoolean(shouldStoreResult);
        UnblockTestTasksResponse(StreamInput in) throws IOException {
                        return;
}
        public void unblock() {
            return new NodeResponse(in);
 *    http://www.apache.org/licenses/LICENSE-2.0
                                + actualOrigin
                    String action,
        public NodeRequest(NodesRequest request, boolean shouldBlock) {
     */
            );
        }
            IndicesRequest ir = (IndicesRequest) request;
        }
        public boolean getShouldBlock() {
        }
                         * (without the [s] part) has the origin.
import org.opensearch.transport.TransportRequest;
        }
        }
import org.opensearch.core.tasks.TaskId;
     * Intercept transport requests to verify that all of the ones that should
import org.opensearch.transport.TransportService;
        }
     */
                    String actualOrigin = threadContext.getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME);
        return Collections.singletonList(new OriginAssertingInterceptor(threadContext));
        }
                        /*
        protected void writeNodesTo(StreamOutput out, List<NodeResponse> nodes) throws IOException {
                return false;
        protected final String requestName;
        }
                    if (Objects.equals(expectedOrigin, actualOrigin)) {
            List<UnblockTestTaskResponse> tasks,
import org.opensearch.transport.TransportInterceptor;
            }
             * When the API Tasks API makes an indices request it only every
        protected NodeRequest newNodeRequest(NodesRequest request) {
            super(in);
        @Override
        public static final String NAME = "cluster:admin/tasks/testunblock";
        }
        }
    }
            this.shouldFail = shouldFail;
                }
                         * done by checking that the main bulk request
        public String getDescription() {
import org.opensearch.transport.Transport;
        }
                return false;
            return new NodesResponse(clusterService.getClusterName(), responses, failures);
        }
        }
            return "NodesRequest[" + requestName + "]";
            return Arrays.equals(new String[] { ".tasks" }, ir.indices());
        @Override
import java.util.Collection;
    /**
        }
                 */
        }
 * the Apache License, Version 2.0 (the "License"); you may
        protected UnblockTestTasksResponse newResponse(
        }
        }
            return new NodeResponse(clusterService.localNode());
        public static final String NAME = "cluster:admin/tasks/test";
 * The OpenSearch Contributors require contributions made to
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
    }
                throw new IllegalStateException("Simulating operation failure");
        }
import org.opensearch.plugins.NetworkPlugin;
            return task instanceof TestTask && super.match(task);
        public NodeResponse(DiscoveryNode node) {
        @Override
        @Override
/*
        NodesResponse(StreamInput in) throws IOException {
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;
            if (request.getShouldFail()) {
            return shouldBlock;
        }
    public static class UnblockTestTasksAction extends ActionType<UnblockTestTasksResponse> {
            }
import java.util.Arrays;
        UnblockTestTaskResponse() {
                        return ((TestTask) task).isBlocked() == false;
        @Override
        return Collections.singleton("Custom-Task-Header");
        UnblockTestTasksRequest() {}
 * specific language governing permissions and limitations
            return in.readList(NodeResponse::new);
    public static class TransportUnblockTestTasksAction extends TransportTasksAction<
            return action.startsWith("indices:admin/refresh") || action.startsWith("indices:data/read/search");
        @Override
                         * Tests search and refresh the task index directly without an origin. The delete task API also performs
        public int getFailureCount() {
import org.opensearch.transport.TransportException;
            );
    /**
    }
            super.writeTo(out);
    }
import org.opensearch.core.common.io.stream.StreamOutput;
                clusterService,
import org.opensearch.core.xcontent.XContentBuilder;
            blocked = false;
        public NodeRequest(StreamInput in) throws IOException {
        private boolean shouldStoreResult = false;
        }
import java.util.Objects;
        public TransportUnblockTestTasksAction(ClusterService clusterService, TransportService transportService) {
    }
        }
                transportService,
        protected UnblockTestTasksRequestBuilder(OpenSearchClient client, ActionType<UnblockTestTasksResponse> action) {
        private boolean shouldFail = false;
        private UnblockTestTasksAction() {
        }
                public <T extends TransportResponse> void sendRequest(
 * software distributed under the License is distributed on an
import org.opensearch.action.ActionRequest;
            if (request.shouldBlock) {
            super.writeTo(out);
    public static class TransportTestTaskAction extends TransportNodesAction<NodesRequest, NodesResponse, NodeRequest, NodeResponse> {
        protected List<NodeResponse> readNodesFrom(StreamInput in) throws IOException {
    }
                         * We can't reason about these requests because
                            "should have origin of ["
        }
        @Override
                         * these actions, in which case shouldHaveOrigin verifies that the tasks origin is used.
 * under the License.
package org.opensearch.action.admin.cluster.node.tasks;
import org.opensearch.common.util.concurrent.ThreadContext;
                                + request
import org.opensearch.common.inject.Inject;
    public static class UnblockTestTasksRequestBuilder extends ActionRequestBuilder<UnblockTestTasksRequest, UnblockTestTasksResponse> {
            this.shouldBlock = shouldBlock;
        @Override
 *
                    Thread.currentThread().interrupt();
                ThreadPool.Names.GENERIC,
            this.requestName = requestName;
                         */
                                + action
    public static class NodeRequest extends TransportRequest {
            List<TaskOperationFailure> taskFailures,
public class TestTaskPlugin extends Plugin implements ActionPlugin, NetworkPlugin {
            requestName = in.readString();
            super(NAME, UnblockTestTasksResponse::new);
        }
    }
        private TestTaskAction() {
                         */
import org.opensearch.core.action.ActionListener;
                        sender.sendRequest(connection, action, request, options, handler);
                    if (isSearchOrRefresh(action) && actualOrigin == null) {
    public static class UnblockTestTaskResponse implements Writeable {
        @Override
            super(nodesIds);
        }
                                + "] but was ["
        }
    public static class NodeResponse extends BaseNodeResponse {
                @Override
                new ActionFilters(new HashSet<>()),
        @Override
            this.tasks = tasks == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(tasks));
        public TransportTestTaskAction(ThreadPool threadPool, ClusterService clusterService, TransportService transportService) {
import org.opensearch.action.support.tasks.BaseTasksResponse;
            for (int i = 0; i < taskCount; i++) {
 *
            UnblockTestTasksRequest request,
            out.writeBoolean(shouldFail);
        public void writeTo(StreamOutput out) throws IOException {}
    static class TestTask extends CancellableTask {
            requestName = request.requestName;
            List<FailedNodeException> failedNodeExceptions
                    }
 */
 */
                    Transport.Connection connection,
import static org.opensearch.test.OpenSearchTestCase.waitUntil;
                    }
import org.opensearch.cluster.ClusterName;
        protected NodesResponse newResponse(NodesRequest request, List<NodeResponse> responses, List<FailedNodeException> failures) {
        protected NodeResponse newNodeResponse(StreamInput in) throws IOException {
        private String requestName;
                new ActionFilters(new HashSet<>()),
import org.opensearch.threadpool.ThreadPool;
        protected NodeResponse nodeOperation(NodeRequest request, Task task) {
            List<TaskOperationFailure> taskOperationFailures,
    @Override
                UnblockTestTasksRequest::new,
            throw new UnsupportedOperationException("the task parameter is required");
                try {
        @Override
                        sender.sendRequest(connection, action, request, options, handler);
            this.threadContext = threadContext;
 * A plugin that adds a cancellable blocking test task of integration testing of the task manager.
        UnblockTestTasksResponse,
            out.writeBoolean(shouldBlock);
                    String expectedOrigin = shouldHaveOrigin(action, request) ? TASKS_ORIGIN : null;
 *
 * this work for additional information regarding copyright
import java.io.IOException;
        }
                                + expectedOrigin
                                + "]["
    public static class NodesResponse extends BaseNodesResponse<NodeResponse> implements ToXContentFragment {
            /*
import org.opensearch.core.action.ActionResponse;
        return Arrays.asList(
        }
                }
import java.util.HashSet;
        protected NodeResponse nodeOperation(NodeRequest request) {
        }
        }
            List<UnblockTestTaskResponse> tasks,
             */
    private static class OriginAssertingInterceptor implements TransportInterceptor {
        Task,
import java.util.ArrayList;
                public boolean shouldCancelChildrenOnCancellation() {
        public boolean getShouldFail() {
import org.opensearch.core.xcontent.ToXContentFragment;
import org.opensearch.action.TaskOperationFailure;
 * Licensed to Elasticsearch under one or more contributor
        private volatile boolean blocked = true;
                        return;
                }
 */
            super(node);
            return shouldStoreResult;
/*
            logger.info("Test task finished on the node {}", clusterService.localNode());
import org.opensearch.action.support.tasks.TransportTasksAction;
        public void setShouldFail(boolean shouldFail) {
            super(clusterName, nodes, failures);
                TestTaskAction.NAME,
        public void setShouldBlock(boolean shouldBlock) {
        private boolean shouldBlock = true;
                    handler.handleException(
    }
        @Override
            super(id, type, action, description, parentTaskId, headers);
import org.opensearch.action.support.nodes.BaseNodesRequest;
            super(client, action, new UnblockTestTasksRequest());
            return new NodeRequest(request, request.getShouldBlock());
        }
import java.util.List;
    }
        public AsyncSender interceptSender(AsyncSender sender) {
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            out.writeVInt(tasks.size());
        public void writeTo(StreamOutput out) throws IOException {
                UnblockTestTasksResponse::new,
            }
        protected final boolean shouldBlock;
        }
            out.writeBoolean(shouldBlock);
        }
                    );
    }
        }
     * that should not have the origin set <strong>do not</strong> have it set.
                        }
            tasks = Collections.unmodifiableList(builder);
                @Override
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.nodes.TransportNodesAction;
            super(in);
        public static final UnblockTestTasksAction INSTANCE = new UnblockTestTasksAction();
    }
                builder.add(new UnblockTestTaskResponse(in));
                         * *sometimes* they should have the origin, if they are
                threadPool,
import org.opensearch.action.FailedNodeException;
            super.writeTo(out);
        @Override
            return blocked;
        }
            listener.onResponse(new UnblockTestTaskResponse());
                NodesRequest::new,
        protected void taskOperation(UnblockTestTasksRequest request, Task task, ActionListener<UnblockTestTaskResponse> listener) {
import org.opensearch.core.common.io.stream.StreamInput;
            int taskCount = in.readVInt();
        @Override
 */
import org.opensearch.tasks.Task;
        @Override
        }
        protected void doExecute(Task task, NodesRequest request, ActionListener<NodesResponse> listener) {
        private final ThreadContext threadContext;
    }
     * Test class for testing task operations
            super(in);
        NodesRequest(StreamInput in) throws IOException {
                         * running on the node that stores the task. But
        public boolean shouldCancelChildrenOnCancellation() {
            List<? extends FailedNodeException> nodeFailures
    }
import org.opensearch.action.support.tasks.BaseTasksRequest;
                UnblockTestTaskResponse::new,
                        new TransportException(
        private boolean shouldHaveOrigin(String action, TransportRequest request) {
import org.opensearch.transport.client.OpenSearchClient;
        @Override
        }
        @Override
            for (UnblockTestTaskResponse task : tasks) {
    @Override
                UnblockTestTasksAction.NAME,
            new ActionHandler<>(TestTaskAction.INSTANCE, TransportTestTaskAction.class),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            throw new RuntimeException("Cancelled!");
            new ActionHandler<>(UnblockTestTasksAction.INSTANCE, TransportUnblockTestTasksAction.class)
    public static class UnblockTestTasksRequest extends BaseTasksRequest<UnblockTestTasksRequest> {
 * GitHub history for details.
        UnblockTestTaskResponse(StreamInput in) {}
                clusterService,
            return "NodeRequest[" + requestName + "]";
        @Override
        public boolean isBlocked() {
                    if (action.startsWith("indices:data/write/bulk[s]")) {
        ) {
        }
            this.shouldBlock = shouldBlock;
import org.opensearch.cluster.service.ClusterService;
                    });
            super(NAME, NodesResponse::new);
import org.opensearch.plugins.Plugin;
/**
        }
        @Override
    }
            List<UnblockTestTaskResponse> builder = new ArrayList<>();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Inject
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {
                    return true;
     * have the origin set <strong>do</strong> have the origin set and the ones
                 * The Tasks API never uses origin with non-indices actions.
            shouldFail = in.readBoolean();
                                + "] action was ["
            return failures().size();
        NodesResponse(ClusterName clusterName, List<NodeResponse> nodes, List<FailedNodeException> failures) {
 * SPDX-License-Identifier: Apache-2.0
        public static final TestTaskAction INSTANCE = new TestTaskAction();
        private boolean isSearchOrRefresh(String action) {
                    TransportRequestOptions options,
        }
import org.opensearch.action.support.nodes.BaseNodeResponse;
    public static class NodesRequest extends BaseNodesRequest<NodesRequest> {
                ThreadPool.Names.MANAGEMENT
            requestName = in.readString();
            super(
            super(in);
        private List<UnblockTestTaskResponse> tasks;
        @Override
        }
        UnblockTestTaskResponse> {
            if (false == (request instanceof IndicesRequest)) {
        public void setShouldStoreResult(boolean shouldStoreResult) {
import org.opensearch.action.IndicesRequest;
    public List<TransportInterceptor> getTransportInterceptors(NamedWriteableRegistry namedWriteableRegistry, ThreadContext threadContext) {
            return new TestTask(id, type, action, this.getDescription(), parentTaskId, headers);
            return false;
        private OriginAssertingInterceptor(ThreadContext threadContext) {
        }
            builder.field("failure_count", getFailureCount());
        }
        UnblockTestTasksResponse(
import org.opensearch.tasks.CancellableTask;
            return new AsyncSender() {
            super.doExecute(task, request, listener);
        UnblockTestTasksRequest,
                task.writeTo(out);
            shouldBlock = in.readBoolean();
        }
        );
import org.opensearch.action.support.nodes.BaseNodesResponse;
            };
                         * sometimes they won't be and in that case they don't
    public static class TestTaskAction extends ActionType<NodesResponse> {
 * ownership. Elasticsearch licenses this file to you under
    }
        public NodeResponse(StreamInput in) throws IOException {
        ) {
        public boolean match(Task task) {
            super(in);
        public boolean getShouldStoreResult() {
                        if (((CancellableTask) task).isCancelled()) {
            out.writeString(requestName);
 * compatible open source license.
                ) {
            }
import java.util.Map;
import org.opensearch.plugins.ActionPlugin;
             * targets the .tasks index. Other requests come from the tests.
            return shouldFail;
            return builder;
            super(in);
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                                + "]"
 * not use this file except in compliance with the License.
        }
 * this file be licensed under the Apache-2.0 license or a
        NodesRequest(String requestName, String... nodesIds) {
import org.opensearch.cluster.node.DiscoveryNode;
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
                    TransportRequest request,
            shouldBlock = in.readBoolean();
            this.shouldStoreResult = shouldStoreResult;
    @Override
                } catch (InterruptedException ex) {
        }
        }
        @Override
            out.writeString(requestName);
            }
            super(
            };
import org.opensearch.core.transport.TransportResponse;
                         * need the origin. Either way, the interesting work is
import org.opensearch.transport.TransportRequestOptions;
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            return new UnblockTestTasksResponse(tasks, taskOperationFailures, failedNodeExceptions);
        UnblockTestTasksRequest(StreamInput in) throws IOException {
            ((TestTask) task).unblock();
        }
                        return;
                    }
import org.opensearch.transport.TransportResponseHandler;
        }
            logger.info("Test task started on the node {}", clusterService.localNode());
        @Override
    }
import org.opensearch.action.ActionType;
                        )
    public static class UnblockTestTasksResponse extends BaseTasksResponse {
        public String getDescription() {
        public void writeTo(StreamOutput out) throws IOException {
/*
import org.opensearch.core.common.io.stream.Writeable;
                NodeResponse.class
 * KIND, either express or implied.  See the License for the
    }
        @Override
                        sender.sendRequest(connection, action, request, options, handler);
                transportService,
        @Inject
        }
        TestTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {
            shouldStoreResult = in.readBoolean();
 * You may obtain a copy of the License at
            }
import org.opensearch.action.ActionRequestBuilder;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.ActionFilters;
                    waitUntil(() -> {
                /*
                    TransportResponseHandler<T> handler
            super(taskFailures, nodeFailures);
            if (false == action.startsWith("indices:")) {
        public void writeTo(StreamOutput out) throws IOException {
                        /*
            out.writeList(nodes);
