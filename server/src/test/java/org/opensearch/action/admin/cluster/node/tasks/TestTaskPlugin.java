            return shouldStoreResult;
                } catch (InterruptedException ex) {  
            out.writeVInt(tasks.size());
            this.threadContext = threadContext;
        @Inject
import org.opensearch.transport.TransportRequest;  
            }
                    });
     * Intercept transport requests to verify that all of the ones that should
        }
    public static class UnblockTestTasksResponse extends BaseTasksResponse {  
            for (UnblockTestTaskResponse task : tasks) {  
    private static class OriginAssertingInterceptor implements TransportInterceptor {
        }
import org.opensearch.action.support.nodes.BaseNodeResponse;
        }
import org.opensearch.transport.TransportInterceptor;
import org.opensearch.action.TaskOperationFailure;  
                NodeResponse.class
        }
        }
        UnblockTestTaskResponse(StreamInput in) {}
            return blocked;
        }  
            return new NodesResponse(clusterService.getClusterName(), responses, failures);
        public String getDescription() {  
        @Override  
        @Override  
import org.opensearch.transport.TransportRequestOptions;
        public NodeRequest(StreamInput in) throws IOException {
                                + "]"
import org.opensearch.cluster.node.DiscoveryNode;
                public <T extends TransportResponse> void sendRequest(  
        }  
            super.writeTo(out);
        @Override
            UnblockTestTasksRequest request,
                }
            super.doExecute(task, request, listener);
        public boolean getShouldFail() {
                                + "]["  
    }  
                    String action,
        }
                         * We can't reason about these requests because  
public class TestTaskPlugin extends Plugin implements ActionPlugin, NetworkPlugin {
                UnblockTestTaskResponse::new,  
                         * running on the node that stores the task. But
import org.opensearch.core.action.ActionListener;
            return new NodeResponse(clusterService.localNode());
            return shouldFail;
            super(taskFailures, nodeFailures);  
            shouldStoreResult = in.readBoolean();  
                public boolean shouldCancelChildrenOnCancellation() {
        }
import org.opensearch.action.support.nodes.BaseNodesRequest;  
    }
                        sender.sendRequest(connection, action, request, options, handler);  
/*  
            logger.info("Test task started on the node {}", clusterService.localNode());  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                        }  
 * license agreements. See the NOTICE file distributed with
            return new AsyncSender() {
        }
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamOutput;  
        @Override
                UnblockTestTasksAction.NAME,  
import org.opensearch.action.IndicesRequest;
                UnblockTestTasksRequest::new,
                    TransportResponseHandler<T> handler
                clusterService,
    }
import org.opensearch.plugins.ActionPlugin;  
                    return true;  
                            "should have origin of ["  
        public NodeRequest(NodesRequest request, boolean shouldBlock) {
            super(
    public static class TestTaskAction extends ActionType<NodesResponse> {  
import org.opensearch.action.ActionRequest;
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
    public static class NodesRequest extends BaseNodesRequest<NodesRequest> {  
            this.requestName = requestName;
 * KIND, either express or implied.  See the License for the
        @Inject  
            List<FailedNodeException> failedNodeExceptions
            return shouldBlock;  
 * Licensed to Elasticsearch under one or more contributor  
        private List<UnblockTestTaskResponse> tasks;
 * SPDX-License-Identifier: Apache-2.0
            return false;  
            super(node);
        }  
            List<? extends FailedNodeException> nodeFailures
            this.shouldBlock = shouldBlock;
                }
                    }
        }  
                                + request
        }
        private boolean isSearchOrRefresh(String action) {  
            return "NodeRequest[" + requestName + "]";  
 * this file be licensed under the Apache-2.0 license or a
        public static final String NAME = "cluster:admin/tasks/testunblock";
     * that should not have the origin set <strong>do not</strong> have it set.
        private final ThreadContext threadContext;
 *
            this.shouldFail = shouldFail;
            this.shouldBlock = shouldBlock;  
        @Override  
import org.opensearch.common.inject.Inject;  
        @Override  
        public String getDescription() {
                         * Tests search and refresh the task index directly without an origin. The delete task API also performs  
            builder.field("failure_count", getFailureCount());
        }  
        @Override
        }
 *  
                @Override
package org.opensearch.action.admin.cluster.node.tasks;
        }
 * Modifications Copyright OpenSearch Contributors. See
        }
        protected void taskOperation(UnblockTestTasksRequest request, Task task, ActionListener<UnblockTestTaskResponse> listener) {
            blocked = false;
                        sender.sendRequest(connection, action, request, options, handler);
            if (false == action.startsWith("indices:")) {
        UnblockTestTasksRequest() {}  
    public List<TransportInterceptor> getTransportInterceptors(NamedWriteableRegistry namedWriteableRegistry, ThreadContext threadContext) {
        }
        }
/*  
        }  
import java.util.Collections;
                }
        public NodeResponse(DiscoveryNode node) {  
            return "NodesRequest[" + requestName + "]";
        @Override
    }
        }  
                        )  
                         * these actions, in which case shouldHaveOrigin verifies that the tasks origin is used.
                ) {  
        public void writeTo(StreamOutput out) throws IOException {
                         * *sometimes* they should have the origin, if they are
 * Unless required by applicable law or agreed to in writing,
        ) {
import org.opensearch.plugins.Plugin;
        public boolean match(Task task) {
            super.writeTo(out);
        }  
    }  
        }
    public static class NodesResponse extends BaseNodesResponse<NodeResponse> implements ToXContentFragment {
                        return;
        public AsyncSender interceptSender(AsyncSender sender) {  
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
             * When the API Tasks API makes an indices request it only every  
            return new NodeResponse(in);
                         */
import java.util.HashSet;
                TestTaskAction.NAME,
                 */
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.XContentBuilder;
            super(in);
 */  
        private UnblockTestTasksAction() {
        public boolean shouldCancelChildrenOnCancellation() {
        @Override
            logger.info("Test task finished on the node {}", clusterService.localNode());
            int taskCount = in.readVInt();  
        UnblockTestTaskResponse> {
                try {
    public static class NodeRequest extends TransportRequest {  
        }  
import org.opensearch.action.FailedNodeException;
        public NodeResponse(StreamInput in) throws IOException {
                NodesRequest::new,
import org.opensearch.transport.TransportException;
        private String requestName;
        UnblockTestTasksResponse,  
            shouldBlock = in.readBoolean();
            super(id, type, action, description, parentTaskId, headers);
import org.opensearch.plugins.NetworkPlugin;
            if (request.shouldBlock) {
    static class TestTask extends CancellableTask {
            requestName = request.requestName;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import java.util.Objects;
        NodesRequest(String requestName, String... nodesIds) {
                        new TransportException(
                        return ((TestTask) task).isBlocked() == false;
    public static class UnblockTestTasksAction extends ActionType<UnblockTestTasksResponse> {
                ThreadPool.Names.GENERIC,  
        @Override
            List<UnblockTestTaskResponse> tasks,
        }
import java.util.ArrayList;
    public static class TransportUnblockTestTasksAction extends TransportTasksAction<  
 * this work for additional information regarding copyright
            return new TestTask(id, type, action, this.getDescription(), parentTaskId, headers);
import org.opensearch.threadpool.ThreadPool;
                @Override
        }  
        @Override  
                                + "] action was ["
import org.opensearch.action.support.ActionFilters;
                                + action
        protected NodeRequest newNodeRequest(NodesRequest request) {
            return failures().size();
        protected final String requestName;
                         * (without the [s] part) has the origin.  
    }
                                + expectedOrigin
import org.opensearch.tasks.CancellableTask;  
            super(NAME, NodesResponse::new);  
        protected NodeResponse nodeOperation(NodeRequest request) {  
            List<TaskOperationFailure> taskFailures,  
            requestName = in.readString();  
            super(in);  
 */
import org.opensearch.action.support.nodes.BaseNodesResponse;
        }  
                        return;
            IndicesRequest ir = (IndicesRequest) request;
        UnblockTestTasksResponse(StreamInput in) throws IOException {
        private boolean shouldStoreResult = false;
        public static final TestTaskAction INSTANCE = new TestTaskAction();
import java.util.Collection;  
    @Override
                         */
        }
        }
        public void setShouldStoreResult(boolean shouldStoreResult) {
        private boolean shouldHaveOrigin(String action, TransportRequest request) {  
        }  
        public int getFailureCount() {
        }  
        public void setShouldFail(boolean shouldFail) {  
                    TransportRequestOptions options,
                        sender.sendRequest(connection, action, request, options, handler);
            );
        @Override
        protected void writeNodesTo(StreamOutput out, List<NodeResponse> nodes) throws IOException {  
                                + actualOrigin  
                        /*
            out.writeBoolean(shouldFail);
        }  
    }
        protected UnblockTestTasksResponse newResponse(  
import org.opensearch.transport.TransportService;  
import org.opensearch.common.util.concurrent.ThreadContext;
        }
                new ActionFilters(new HashSet<>()),  
            for (int i = 0; i < taskCount; i++) {
import org.opensearch.action.ActionType;  
        NodesRequest(StreamInput in) throws IOException {  
        }  
        @Override  
        }  
    public Collection<String> getTaskHeaders() {  
    }
        private volatile boolean blocked = true;
            out.writeString(requestName);
 */  
        }
        }
                transportService,
                 * The Tasks API never uses origin with non-indices actions.  
        public static final UnblockTestTasksAction INSTANCE = new UnblockTestTasksAction();
                UnblockTestTasksResponse::new,
        public boolean isBlocked() {  
        }
                            throw new RuntimeException("Cancelled!");
                NodeRequest::new,
     */
                transportService,
    }
            }  
        @Override
        public void unblock() {
import org.opensearch.core.action.ActionResponse;  
                    );
        }
        UnblockTestTaskResponse() {  
        protected void doExecute(Task task, NodesRequest request, ActionListener<NodesResponse> listener) {  
            ((TestTask) task).unblock();
    }
            if (false == (request instanceof IndicesRequest)) {
    public static class NodeResponse extends BaseNodeResponse {  
    }
        public static final String NAME = "cluster:admin/tasks/test";  
            List<UnblockTestTaskResponse> tasks,
 *    http://www.apache.org/licenses/LICENSE-2.0
        public TransportTestTaskAction(ThreadPool threadPool, ClusterService clusterService, TransportService transportService) {  
            throw new UnsupportedOperationException("the task parameter is required");
    }
            );
            requestName = in.readString();
import org.opensearch.core.transport.TransportResponse;  
    public static class UnblockTestTaskResponse implements Writeable {
    public static class UnblockTestTasksRequestBuilder extends ActionRequestBuilder<UnblockTestTasksRequest, UnblockTestTasksResponse> {  
                         * sometimes they won't be and in that case they don't  
        }  
        public boolean getShouldStoreResult() {  
        @Override
            return new NodeRequest(request, request.getShouldBlock());  
            }  
        private boolean shouldFail = false;
import org.opensearch.action.support.nodes.TransportNodesAction;
import org.opensearch.transport.TransportResponseHandler;
                    Thread.currentThread().interrupt();
                throw new IllegalStateException("Simulating operation failure");
        public void writeTo(StreamOutput out) throws IOException {  
                    if (Objects.equals(expectedOrigin, actualOrigin)) {  
 * specific language governing permissions and limitations
                new ActionFilters(new HashSet<>()),  
            super(in);
        }
            return new UnblockTestTasksResponse(tasks, taskOperationFailures, failedNodeExceptions);  
import org.opensearch.core.common.io.stream.Writeable;
                         * need the origin. Either way, the interesting work is
    }
            listener.onResponse(new UnblockTestTaskResponse());  
import org.opensearch.action.ActionRequestBuilder;
        return Arrays.asList(
                threadPool,  
            shouldFail = in.readBoolean();
            super(in);  
            new ActionHandler<>(UnblockTestTasksAction.INSTANCE, TransportUnblockTestTasksAction.class)
            out.writeBoolean(shouldBlock);
        public boolean getShouldBlock() {
        }  
import org.opensearch.cluster.ClusterName;  
                ThreadPool.Names.MANAGEMENT
        ) {
            /*
import java.io.IOException;  
            return builder;
                builder.add(new UnblockTestTaskResponse(in));  
            return in.readList(NodeResponse::new);
import java.util.List;  
        Task,
                    String expectedOrigin = shouldHaveOrigin(action, request) ? TASKS_ORIGIN : null;
        protected UnblockTestTasksRequestBuilder(OpenSearchClient client, ActionType<UnblockTestTasksResponse> action) {
            out.writeList(nodes);
        return Collections.singletonList(new OriginAssertingInterceptor(threadContext));
    /**
        public void setShouldBlock(boolean shouldBlock) {
        @Override
        public void writeTo(StreamOutput out) throws IOException {}
            super(nodesIds);  
        @Override
        @Override
        }
        @Override
        }  
                    String actualOrigin = threadContext.getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME);  
        public void writeTo(StreamOutput out) throws IOException {  
 * A plugin that adds a cancellable blocking test task of integration testing of the task manager.
        UnblockTestTasksResponse(
import org.opensearch.transport.Transport;  
                        if (((CancellableTask) task).isCancelled()) {
     * Test class for testing task operations
import org.opensearch.transport.client.OpenSearchClient;
            out.writeString(requestName);  
            List<TaskOperationFailure> taskOperationFailures,  
            new ActionHandler<>(TestTaskAction.INSTANCE, TransportTestTaskAction.class),  
        );
        }
             * targets the .tasks index. Other requests come from the tests.
/*
import org.opensearch.action.support.tasks.TransportTasksAction;
        }  
        }
                    waitUntil(() -> {  
            if (request.getShouldFail()) {
        protected List<NodeResponse> readNodesFrom(StreamInput in) throws IOException {
        return Collections.singleton("Custom-Task-Header");
            List<UnblockTestTaskResponse> builder = new ArrayList<>();
import java.util.Map;
import org.opensearch.core.common.io.stream.StreamInput;
     * have the origin set <strong>do</strong> have the origin set and the ones  
        protected NodesResponse newResponse(NodesRequest request, List<NodeResponse> responses, List<FailedNodeException> failures) {  
            }  
 * GitHub history for details.
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
             */
import org.opensearch.action.support.tasks.BaseTasksRequest;  
            out.writeBoolean(shouldStoreResult);  
    @Override  
                task.writeTo(out);
            }  
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;
            super(in);
        }
 * compatible open source license.
            this.tasks = tasks == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(tasks));
            super(client, action, new UnblockTestTasksRequest());  
import org.opensearch.action.support.tasks.BaseTasksResponse;
        @Override  
 */  
            super.writeTo(out);
            super(clusterName, nodes, failures);  
                    if (isSearchOrRefresh(action) && actualOrigin == null) {
            return task instanceof TestTask && super.match(task);
        private OriginAssertingInterceptor(ThreadContext threadContext) {
 * The OpenSearch Contributors require contributions made to  
            super(
            out.writeBoolean(shouldBlock);
                return false;
            }
            };  
                    Transport.Connection connection,
    public static class UnblockTestTasksRequest extends BaseTasksRequest<UnblockTestTasksRequest> {
        UnblockTestTasksRequest,
        public TransportUnblockTestTasksAction(ClusterService clusterService, TransportService transportService) {
 * ownership. Elasticsearch licenses this file to you under  
        @Override
                        return;  
                    }
        }
 * under the License.  
                    if (action.startsWith("indices:data/write/bulk[s]")) {
    }  
                clusterService,
                    }  
        private boolean shouldBlock = true;  
 * the Apache License, Version 2.0 (the "License"); you may
        private TestTaskAction() {
        }
/**
            super(in);
        NodesResponse(StreamInput in) throws IOException {
        protected NodeResponse nodeOperation(NodeRequest request, Task task) {
 * You may obtain a copy of the License at  
    }  
    @Override  
import java.util.Arrays;
        UnblockTestTasksRequest(StreamInput in) throws IOException {
                /*
        }  
                        /*
 *
}
            shouldBlock = in.readBoolean();
import org.opensearch.cluster.service.ClusterService;
        protected final boolean shouldBlock;
            this.shouldStoreResult = shouldStoreResult;
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {  
    }
     */
 * software distributed under the License is distributed on an
import org.opensearch.core.tasks.TaskId;
            return action.startsWith("indices:admin/refresh") || action.startsWith("indices:data/read/search");
                    TransportRequest request,  
            };
    }  
                    handler.handleException(
        protected NodeResponse newNodeResponse(StreamInput in) throws IOException {
            return Arrays.equals(new String[] { ".tasks" }, ir.indices());  
import org.opensearch.tasks.Task;
        TestTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {  
import org.opensearch.core.xcontent.ToXContentFragment;
                                + "] but was ["
            tasks = Collections.unmodifiableList(builder);
            super(NAME, UnblockTestTasksResponse::new);
        @Override
import static org.opensearch.test.OpenSearchTestCase.waitUntil;
        @Override
                         * done by checking that the main bulk request
                return false;
        NodesResponse(ClusterName clusterName, List<NodeResponse> nodes, List<FailedNodeException> failures) {
    public static class TransportTestTaskAction extends TransportNodesAction<NodesRequest, NodesResponse, NodeRequest, NodeResponse> {  
