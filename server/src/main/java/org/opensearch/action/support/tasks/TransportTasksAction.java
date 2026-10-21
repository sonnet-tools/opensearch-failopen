                            assert response.v2() != null;
            }
            }
        private final AtomicReferenceArray<Object> responses;
            if (nodesIds.length == 0) {
                                }
                for (int i = 0; i < nodesIds.length; i++) {
                                    @Override
                }
                        }
        }
            out.writeVInt(results.size());
                taskListener.onFailure(e);
                }
    }
        public void writeTo(StreamOutput out) throws IOException {
            if (response instanceof FailedNodeException) {
                if (tasksResponse.exceptions != null) {
        for (int i = 0; i < responses.length(); i++) {
            String[] nodesIds = resolveNodes(request, clusterState);
        }
            this.results = results;
    class NodeTransportHandler implements TransportRequestHandler<NodeTaskRequest> {
 * GitHub history for details.
import java.util.concurrent.atomic.AtomicInteger;
        private final DiscoveryNode[] nodes;
 */
    TasksResponse extends BaseTasksResponse,
import org.opensearch.transport.TransportRequestHandler;
                                    @Override
                TransportRequestOptions.Builder builder = TransportRequestOptions.builder();
import org.opensearch.action.TaskOperationFailure;
            if (in.readBoolean()) {
                    List<TaskResponse> results = new ArrayList<>();
    /**
     *
                this.nodes[i] = nodes.get(this.nodesIds[i]);
            int resultsSize = in.readVInt();
                } catch (Exception e) {
    /**
                @Override
            }
            }
    protected String[] filterNodeIds(DiscoveryNodes nodes, String[] nodesIds) {
        protected NodeTaskRequest(TasksRequest tasksRequest) {
                                    }
            super();
    ) {
    protected final String transportNodeAction;
                public void onFailure(Exception e) {
                    }
        }
                                nodeRequest,
        }
                finishHim();
    private void nodeOperation(NodeTaskRequest nodeTaskRequest, ActionListener<NodeTasksResponse> listener) {
                int taskFailures = in.readVInt();
     */
        Writeable.Reader<TasksResponse> responsesReader,
        new AsyncAction(task, request, listener).start();
        TasksRequest request = nodeTaskRequest.tasksRequest;
    }
        List<OperationTask> tasks = new ArrayList<>();
                    out.writeBoolean(true);
     *
        }
    protected final ClusterService clusterService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                for (int i = 0; i < taskFailures; i++) {
                if (tasksResponse.results != null) {
            return exceptions;
        }
        List<TaskResponse> tasks,
 */
    protected abstract TasksResponse newResponse(
                final TaskResponse result = in.readBoolean() ? responseReader.read(in) : null;
            out.writeBoolean(exceptions != null);
import org.opensearch.common.util.concurrent.AtomicArray;
        private void onOperation(int idx, NodeTasksResponse nodeResponse) {
    );
            responses.set(idx, new FailedNodeException(nodeId, "Failed node [" + nodeId + "]", t));
            tasksRequest.writeTo(out);
        TasksRequest request,
            results = new ArrayList<>(resultsSize);
            }
                if (request.match(task)) {
        public List<TaskOperationFailure> getExceptions() {
 * under the License.
            this.request = request;
        ActionFilters actionFilters,
import org.opensearch.core.common.io.stream.StreamOutput;
                if (result != null) {
                            exceptions.add(
     * Asynchronous single action
        List<TaskOperationFailure> taskOperationFailures,
 *
            try {
            ClusterState clusterState = clusterService.state();
    protected final Writeable.Reader<TasksRequest> requestReader;
import org.apache.logging.log4j.message.ParameterizedMessage;
import java.util.Map;
            listener.onResponse(new NodeTasksResponse(clusterService.localNode().getId(), emptyList(), emptyList()));
 * The base class for transport actions that are interacting with currently running tasks.
import org.opensearch.transport.TransportResponseHandler;
    TaskResponse extends Writeable> extends HandledTransportAction<TasksRequest, TasksResponse> {
            TasksResponse finalResponse;
                try {
            }
                    operation.accept((OperationTask) task);
            }
                }
        } else {
                for (TaskOperationFailure exception : exceptions) {
                                    }
        AtomicArray<Tuple<TaskResponse, Exception>> responses = new AtomicArray<>(tasks.size());
    protected final Writeable.Reader<TasksResponse> responsesReader;
                            results.add(response.v1());
        private final Task task;
            } else {
                results.add(result);
            this.task = task;
import java.io.IOException;
            }
import java.util.function.Consumer;
    }
 */
                                transportNodeAction,
                    if (counter.decrementAndGet() != 0) {
     */
            }
        Writeable.Reader<TasksRequest> requestReader,
            this.nodesIds = filterNodeIds(clusterState.nodes(), nodesIds);
            };
        private void start() {
        }
}
    OperationTask extends Task,
            this.tasksRequest = requestReader.read(in);
            }
 * software distributed under the License is distributed on an
        if (tasks.isEmpty()) {
            this.nodeId = nodeId;
            if (counter.incrementAndGet() == responses.length()) {
                    for (Tuple<TaskResponse, Exception> response : responses.asList()) {
                    e1.addSuppressed(e);
                        } else {
            if (exceptions != null) {
        }
        }
                    tasks.addAll(tasksResponse.results);
                taskOperation(request, tasks.get(taskIndex), taskListener);
            return;
        private final ActionListener<TasksResponse> listener;
import org.opensearch.cluster.service.ClusterService;
public abstract class TransportTasksAction<
 *
        NodeTasksResponse(String nodeId, List<TaskResponse> results, List<TaskOperationFailure> exceptions) {
                    }
import org.opensearch.core.common.io.stream.Writeable;
                                    public NodeTasksResponse read(StreamInput in) throws IOException {
    @Override
        }
     */
import org.opensearch.ResourceNotFoundException;
 * the Apache License, Version 2.0 (the "License"); you may
        protected String nodeId;
        protected List<TaskResponse> results;
    protected TransportTasksAction(
                private void respondIfFinished() {
                    builder.withTimeout(request.getTimeout());
    protected final Writeable.Reader<TaskResponse> responseReader;
        this.transportNodeAction = actionName + "[n]";
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.transport.TransportRequest;
            }));
                public void onResponse(TaskResponse response) {
        List<TaskOperationFailure> taskOperationFailures = new ArrayList<>();
            responses.set(idx, nodeResponse);
                @Override
        }
            } catch (Exception e) {
                NodeTasksResponse tasksResponse = (NodeTasksResponse) response;
                                    }
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.node.DiscoveryNode;
        this.responseReader = responseReader;
        private final TasksRequest request;
            for (; resultsSize > 0; resultsSize--) {
 * You may obtain a copy of the License at
        private void onFailure(int idx, String nodeId, Throwable t) {
        protected List<TaskOperationFailure> exceptions;
        Writeable.Reader<TaskResponse> responseReader,
                        } else {
 * Unless required by applicable law or agreed to in writing,
                        }
    protected void doExecute(Task task, TasksRequest request, ActionListener<TasksResponse> listener) {
        }
     * @opensearch.internal
     */
    /**
        }
        TransportService transportService,
        String actionName,
        this.transportService = transportService;
                                node,
                    try {
 * Licensed to Elasticsearch under one or more contributor
    protected final TransportService transportService;
        List<TaskResponse> tasks = new ArrayList<>();
            for (int i = 0; i < this.nodesIds.length; i++) {
    }
                throw new ResourceNotFoundException("task [{}] is missing", request.getTaskId());
                out.writeVInt(taskFailures);
                }
 * Modifications Copyright OpenSearch Contributors. See
                    operation.accept((OperationTask) task);
            return nodeId;
    protected void processTasks(TasksRequest request, Consumer<OperationTask> operation) {
 * this work for additional information regarding copyright
        }
        @Override
            if (task != null) {
        List<FailedNodeException> failedNodeExceptions
            for (TaskResponse result : results) {
import org.opensearch.core.common.io.stream.StreamInput;
                }
                finalResponse = newResponse(request, responses);
import static java.util.Collections.emptyList;
                    exception.writeTo(out);
                listener.onFailure(e);
                }
/*
/**
/*
                exceptions = null;
            for (Task task : taskManager.getTasks().values()) {
     * @opensearch.internal
                logger.debug(new ParameterizedMessage("failed to execute on node [{}]", nodeId), t);
                int taskFailures = exceptions.size();
                // nothing to do
                    throw new ResourceNotFoundException("task [{}] doesn't support this operation", request.getTaskId());
import org.opensearch.core.action.ActionListener;
 * not use this file except in compliance with the License.
                } else {
                } else {
                    listener.onFailure(e);
                try {
import org.opensearch.threadpool.ThreadPool;
        private final AtomicInteger counter = new AtomicInteger();
import org.opensearch.transport.TransportException;
            nodeId = in.readString();
    private class NodeTasksResponse extends TransportResponse {
                                    public void handleException(TransportException exp) {
                } catch (IOException e1) {
            this.tasksRequest = tasksRequest;
                                        return ThreadPool.Names.SAME;
        for (int i = 0; i < tasks.size(); i++) {
    protected String[] resolveNodes(TasksRequest request, ClusterState clusterState) {
                    channel.sendResponse(e);
        this.clusterService = clusterService;
        return nodesIds;
import org.opensearch.transport.NodeShouldNotConnectException;
    /**
        this.responsesReader = responsesReader;
     *
                    final DiscoveryNode node = nodes[i];
     */
            this.listener = listener;
            nodeOperation(request, ActionListener.wrap(channel::sendResponse, e -> {
                }
                            );
                                    }
        } else {
        ClusterService clusterService,
 * SPDX-License-Identifier: Apache-2.0
                if (request.match(task)) {
 *
        if (request.getTaskId().isSet()) {
    }
                    respondIfFinished();
                        onFailure(idx, nodeId, e);
            if (counter.incrementAndGet() == responses.length()) {
                exceptions = new ArrayList<>(taskFailures);
        }
import org.opensearch.core.transport.TransportResponse;
                }
            Task task = taskManager.getTask(request.getTaskId().getId());
                    final String nodeId = nodesIds[i];
            return new String[] { request.getTaskId().getNodeId() };
            if (logger.isDebugEnabled() && !(t instanceof NodeShouldNotConnectException)) {
                        return;
        List<FailedNodeException> failedNodeExceptions = new ArrayList<>();
            } catch (Exception e) {
                                    @Override
                    responses.setOnce(taskIndex, response == null ? null : new Tuple<>(response, null));
                                    public String executor() {
        final AtomicInteger counter = new AtomicInteger(tasks.size());
import org.opensearch.cluster.node.DiscoveryNodes;
            }
    private class NodeTaskRequest extends TransportRequest {
 * compatible open source license.
    private class AsyncAction {
        private void finishHim() {
                            transportService.sendRequest(
                }
 * The OpenSearch Contributors require contributions made to
    }
    /**
                            nodeRequest.setParentTask(clusterService.localNode().getId(), task.getId());
        @Override
import org.opensearch.cluster.ClusterState;
 * specific language governing permissions and limitations
                finishHim();
    @SuppressWarnings("unchecked")
            } else {
        protected NodeTaskRequest(StreamInput in) throws IOException {
            // we are only checking one task, we can optimize it
        processTasks(request, tasks::add);
                    result.writeTo(out);
 */
                    } catch (Exception e) {
        }
                                builder.build(),
        NodeTasksResponse(StreamInput in) throws IOException {
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.opensearch.transport.TransportChannel;
                logger.debug("failed to combine responses from nodes", e);
                }
import org.opensearch.action.support.ActionFilters;
                            );
                                        return new NodeTasksResponse(in);
     * Node level transport handler
    }
package org.opensearch.action.support.tasks;
            ActionListener<TaskResponse> taskListener = new ActionListener<TaskResponse>() {
                    List<TaskOperationFailure> exceptions = new ArrayList<>();
                    exceptions.add(new TaskOperationFailure(in));
        return newResponse(request, tasks, taskOperationFailures, failedNodeExceptions);
        super(actionName, transportService, actionFilters, requestReader);
            final Map<String, DiscoveryNode> nodes = clusterState.nodes().getNodes();
                return;
                    taskOperationFailures.addAll(tasksResponse.exceptions);
                }
                    final int idx = i;
import org.opensearch.transport.TransportRequestOptions;
                }
            try {
                    listener.onResponse(new NodeTasksResponse(clusterService.localNode().getId(), results, exceptions));
        public void writeTo(StreamOutput out) throws IOException {
                                new TaskOperationFailure(clusterService.localNode().getId(), tasks.get(taskIndex).getId(), response.v2())
                            onFailure(idx, nodeId, new NoSuchNodeException(nodeId));
     * Node level task request
 * @opensearch.internal
                    responses.setOnce(taskIndex, new Tuple<>(null, e));
                if (request.getTimeout() != null) {
     *
    TasksRequest extends BaseTasksRequest<TasksRequest>,
            listener.onResponse(finalResponse);
                    logger.warn("Failed to send failure", e1);
            } else {
            super.writeTo(out);
            this.exceptions = exceptions;
     * @opensearch.internal
        }
                }
        public void messageReceived(final NodeTaskRequest request, final TransportChannel channel, Task task) throws Exception {
        if (request.getTaskId().isSet()) {
                                new TransportResponseHandler<NodeTasksResponse>() {
            } else {
            final int taskIndex = i;
import java.util.List;
            super(in);
import org.opensearch.action.NoSuchNodeException;
        private TasksRequest tasksRequest;
                    listener.onResponse(newResponse(request, responses));
 * this file be licensed under the Apache-2.0 license or a
     * Perform the required operation on the task. It is OK start an asynchronous operation or to throw an exception but not both.
        }
 *
import org.opensearch.action.FailedNodeException;
import org.opensearch.common.collect.Tuple;
        transportService.registerRequestHandler(transportNodeAction, nodeExecutor, NodeTaskRequest::new, new NodeTransportHandler());
                        if (response.v1() == null) {
     * @opensearch.internal
                            NodeTaskRequest nodeRequest = new NodeTaskRequest(request);
    }
    }
            super(in);
                }
import java.util.ArrayList;
                            assert response.v2() == null;
        public String getNodeId() {
                    out.writeBoolean(false);
                    respondIfFinished();
        private final String[] nodesIds;
                                    public void handleResponse(NodeTasksResponse response) {
import org.opensearch.tasks.Task;
            return clusterState.nodes().resolveNodes(request.getNodes());
                                    @Override
 * license agreements. See the NOTICE file distributed with
        private AsyncAction(Task task, TasksRequest request, ActionListener<TasksResponse> listener) {
     * Node level task response
 * KIND, either express or implied.  See the License for the
                                        onFailure(idx, node.getId(), exp);
import org.opensearch.transport.TransportService;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.responses = new AtomicReferenceArray<>(this.nodesIds.length);
            }
            }
                failedNodeExceptions.add((FailedNodeException) response);
                        if (node == null) {
            out.writeString(nodeId);
                                        onOperation(idx, response);
/*
    protected TasksResponse newResponse(TasksRequest request, AtomicReferenceArray responses) {
        this.requestReader = requestReader;
    }
            this.nodes = new DiscoveryNode[nodesIds.length];
    protected abstract void taskOperation(TasksRequest request, OperationTask task, ActionListener<TaskResponse> listener);
        @Override
            }
        String nodeExecutor
                    logger.debug("failed to generate empty response", e);
            Object response = responses.get(i);
        }
                    }
