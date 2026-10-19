    protected final ClusterService clusterService;  
 * GitHub history for details.
            return clusterState.nodes().resolveNodes(request.getNodes());
import org.opensearch.action.TaskOperationFailure;
                    for (Tuple<TaskResponse, Exception> response : responses.asList()) {
            this.tasksRequest = requestReader.read(in);  
            out.writeBoolean(exceptions != null);  
            return nodeId;
            return new String[] { request.getTaskId().getNodeId() };  
        List<OperationTask> tasks = new ArrayList<>();  
                for (TaskOperationFailure exception : exceptions) {
        private void start() {
            } else {
                }  
            try {
                    logger.warn("Failed to send failure", e1);
            if (task != null) {
        }
            ClusterState clusterState = clusterService.state();  
    protected void processTasks(TasksRequest request, Consumer<OperationTask> operation) {  
    }
        } else {
                                    @Override
            final int taskIndex = i;  
        }
            nodeId = in.readString();
        } else {
            listener.onResponse(finalResponse);
                            );
            this.tasksRequest = tasksRequest;
                }
            responses.set(idx, new FailedNodeException(nodeId, "Failed node [" + nodeId + "]", t));
                failedNodeExceptions.add((FailedNodeException) response);
                try {
            try {
import java.util.function.Consumer;  
                    if (counter.decrementAndGet() != 0) {  
                    }  
        private void finishHim() {
        }
import org.opensearch.core.common.io.stream.StreamOutput;
                                    @Override  
                    responses.setOnce(taskIndex, response == null ? null : new Tuple<>(response, null));
import org.opensearch.action.NoSuchNodeException;
        for (int i = 0; i < responses.length(); i++) {
 * the Apache License, Version 2.0 (the "License"); you may
 */  
                                builder.build(),  
import org.opensearch.cluster.ClusterState;
    protected final String transportNodeAction;  
        public void messageReceived(final NodeTaskRequest request, final TransportChannel channel, Task task) throws Exception {
        }  
        List<FailedNodeException> failedNodeExceptions = new ArrayList<>();
        this.responsesReader = responsesReader;
        private final AtomicReferenceArray<Object> responses;
    private class NodeTaskRequest extends TransportRequest {
        new AsyncAction(task, request, listener).start();
                }  
                        } else {
        List<TaskResponse> tasks = new ArrayList<>();
                exceptions = null;  
            }
            if (response instanceof FailedNodeException) {  
        @Override  
        public void writeTo(StreamOutput out) throws IOException {
        Writeable.Reader<TaskResponse> responseReader,  
            }
                finalResponse = newResponse(request, responses);
        }
    ) {
import org.opensearch.transport.TransportResponseHandler;  
     */  
                                        onOperation(idx, response);  
    protected TasksResponse newResponse(TasksRequest request, AtomicReferenceArray responses) {  
                return;  
 */
        private TasksRequest tasksRequest;
                }
        protected NodeTaskRequest(StreamInput in) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
                }  
    /**  
        String actionName,  
        }
 * license agreements. See the NOTICE file distributed with
            this.nodeId = nodeId;
                logger.debug(new ParameterizedMessage("failed to execute on node [{}]", nodeId), t);
        }
                @Override
                                    }
                            assert response.v2() == null;  
    protected TransportTasksAction(
/*  
                        }
    TasksRequest extends BaseTasksRequest<TasksRequest>,
import org.opensearch.transport.TransportService;
            String[] nodesIds = resolveNodes(request, clusterState);
            if (exceptions != null) {
                TransportRequestOptions.Builder builder = TransportRequestOptions.builder();  
            this.listener = listener;
    }
                throw new ResourceNotFoundException("task [{}] is missing", request.getTaskId());
            return exceptions;  
                                new TaskOperationFailure(clusterService.localNode().getId(), tasks.get(taskIndex).getId(), response.v2())  
    }
        TransportService transportService,
                        return;
            tasksRequest.writeTo(out);  
     * @opensearch.internal  
                if (request.match(task)) {  
        final AtomicInteger counter = new AtomicInteger(tasks.size());
 * @opensearch.internal
        this.responseReader = responseReader;  
        this.requestReader = requestReader;
 * SPDX-License-Identifier: Apache-2.0
        TasksRequest request,
 * specific language governing permissions and limitations
                results.add(result);  
        protected List<TaskResponse> results;  
        }  
            if (in.readBoolean()) {
            int resultsSize = in.readVInt();
        List<FailedNodeException> failedNodeExceptions
                }
    );  
     *
        }  
                        if (node == null) {  
                    }
        }
            }  
 * Unless required by applicable law or agreed to in writing,
            super.writeTo(out);
                for (int i = 0; i < taskFailures; i++) {
                    out.writeBoolean(true);  
            nodeOperation(request, ActionListener.wrap(channel::sendResponse, e -> {  
                } else {
                for (int i = 0; i < nodesIds.length; i++) {
     */
    }
        protected String nodeId;
                if (tasksResponse.results != null) {
            }));
        String nodeExecutor
    protected String[] resolveNodes(TasksRequest request, ClusterState clusterState) {
            Object response = responses.get(i);
            }
                    throw new ResourceNotFoundException("task [{}] doesn't support this operation", request.getTaskId());
                                        onFailure(idx, node.getId(), exp);
            } else {
            return;
                }  
                    listener.onFailure(e);  
                    logger.debug("failed to generate empty response", e);
        this.clusterService = clusterService;
        }  
     * Node level task response
                                transportNodeAction,
        List<TaskOperationFailure> taskOperationFailures,
            this.request = request;
                if (request.getTimeout() != null) {
            }
                                nodeRequest,
            ActionListener<TaskResponse> taskListener = new ActionListener<TaskResponse>() {
import java.util.ArrayList;
    TasksResponse extends BaseTasksResponse,  
    protected final Writeable.Reader<TasksRequest> requestReader;
                        onFailure(idx, nodeId, e);
    OperationTask extends Task,
                    taskOperationFailures.addAll(tasksResponse.exceptions);
        }
/**
                    listener.onResponse(newResponse(request, responses));  
import static java.util.Collections.emptyList;
                    exceptions.add(new TaskOperationFailure(in));  
        private final ActionListener<TasksResponse> listener;  
            // we are only checking one task, we can optimize it
                    final String nodeId = nodesIds[i];
    }
                listener.onFailure(e);
        TasksRequest request = nodeTaskRequest.tasksRequest;
 * this work for additional information regarding copyright
            super(in);
    private void nodeOperation(NodeTaskRequest nodeTaskRequest, ActionListener<NodeTasksResponse> listener) {
            for (; resultsSize > 0; resultsSize--) {
    protected void doExecute(Task task, TasksRequest request, ActionListener<TasksResponse> listener) {  
                                        return new NodeTasksResponse(in);
import java.util.Map;  
     *
 *
                final TaskResponse result = in.readBoolean() ? responseReader.read(in) : null;
    /**  
    protected final Writeable.Reader<TasksResponse> responsesReader;  
public abstract class TransportTasksAction<  
    }  
    }
import org.opensearch.action.support.HandledTransportAction;
            } else {
                    tasks.addAll(tasksResponse.results);
        private final TasksRequest request;  
            };  
        this.transportNodeAction = actionName + "[n]";  
                out.writeVInt(taskFailures);  
                                }  
import java.util.List;
        NodeTasksResponse(String nodeId, List<TaskResponse> results, List<TaskOperationFailure> exceptions) {
     * @opensearch.internal
            Task task = taskManager.getTask(request.getTaskId().getId());  
 * this file be licensed under the Apache-2.0 license or a
                                    public NodeTasksResponse read(StreamInput in) throws IOException {  
                } catch (Exception e) {
                }
import java.util.concurrent.atomic.AtomicInteger;
                    final int idx = i;  
            } catch (Exception e) {  
            }
            }
    /**
import org.opensearch.tasks.Task;
            super();
    }
 * under the License.  
        this.transportService = transportService;
        super(actionName, transportService, actionFilters, requestReader);  
                    respondIfFinished();
            if (counter.incrementAndGet() == responses.length()) {  
        if (request.getTaskId().isSet()) {
        private final Task task;  
import org.opensearch.cluster.node.DiscoveryNode;  
 *  
     * Node level task request  
import org.opensearch.common.util.concurrent.AtomicArray;
    /**
    }  
                                node,  
        @Override
import org.opensearch.transport.TransportException;
            out.writeString(nodeId);
            this.results = results;  
import org.opensearch.core.transport.TransportResponse;  
                            exceptions.add(
                                    }
                // nothing to do
                logger.debug("failed to combine responses from nodes", e);
                if (tasksResponse.exceptions != null) {
     * Perform the required operation on the task. It is OK start an asynchronous operation or to throw an exception but not both.
        processTasks(request, tasks::add);
        @Override  
            if (nodesIds.length == 0) {  
 *  
                    respondIfFinished();
                            onFailure(idx, nodeId, new NoSuchNodeException(nodeId));
 * KIND, either express or implied.  See the License for the
/*  
                    operation.accept((OperationTask) task);  
            }
        }  
                        } else {
import org.opensearch.transport.TransportChannel;
                    result.writeTo(out);
                finishHim();
 * software distributed under the License is distributed on an
        List<TaskResponse> tasks,  
                exceptions = new ArrayList<>(taskFailures);
                    e1.addSuppressed(e);
                taskOperation(request, tasks.get(taskIndex), taskListener);
            this.nodesIds = filterNodeIds(clusterState.nodes(), nodesIds);
import org.opensearch.threadpool.ThreadPool;
        ActionFilters actionFilters,  
                try {
        private AsyncAction(Task task, TasksRequest request, ActionListener<TasksResponse> listener) {
                            assert response.v2() != null;
                    responses.setOnce(taskIndex, new Tuple<>(null, e));
        }  
                    operation.accept((OperationTask) task);
            }
        private final DiscoveryNode[] nodes;
                }  
        for (int i = 0; i < tasks.size(); i++) {
                int taskFailures = exceptions.size();
                    List<TaskResponse> results = new ArrayList<>();  
                NodeTasksResponse tasksResponse = (NodeTasksResponse) response;  
                if (result != null) {
 * compatible open source license.
                private void respondIfFinished() {
        }  
        return nodesIds;
        }
        List<TaskOperationFailure> taskOperationFailures = new ArrayList<>();  
    }
    private class NodeTasksResponse extends TransportResponse {  
        private void onOperation(int idx, NodeTasksResponse nodeResponse) {
        return newResponse(request, tasks, taskOperationFailures, failedNodeExceptions);  
        public String getNodeId() {
        private final AtomicInteger counter = new AtomicInteger();
        }  
                } else {
            }
        private void onFailure(int idx, String nodeId, Throwable t) {
                                    public String executor() {  
            }
            for (TaskResponse result : results) {
                            results.add(response.v1());
            results = new ArrayList<>(resultsSize);  
            TasksResponse finalResponse;  
        public List<TaskOperationFailure> getExceptions() {
     * Node level transport handler
        private final String[] nodesIds;
     *
 *
                }
                        }
                public void onFailure(Exception e) {  
 * Modifications Copyright OpenSearch Contributors. See
                taskListener.onFailure(e);
                }  
            this.exceptions = exceptions;
                                    @Override
import org.opensearch.action.support.ActionFilters;  
                if (request.match(task)) {
        protected NodeTaskRequest(TasksRequest tasksRequest) {  
        Writeable.Reader<TasksResponse> responsesReader,
import org.opensearch.cluster.node.DiscoveryNodes;
import org.apache.logging.log4j.message.ParameterizedMessage;
    }  
                } catch (IOException e1) {  
            super(in);  
import org.opensearch.transport.TransportRequestOptions;
            listener.onResponse(new NodeTasksResponse(clusterService.localNode().getId(), emptyList(), emptyList()));  
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.transport.TransportRequestHandler;
                }  
 * The OpenSearch Contributors require contributions made to  
        transportService.registerRequestHandler(transportNodeAction, nodeExecutor, NodeTaskRequest::new, new NodeTransportHandler());
        }
     */  
        Writeable.Reader<TasksRequest> requestReader,
    protected String[] filterNodeIds(DiscoveryNodes nodes, String[] nodesIds) {  
            }
import org.opensearch.common.collect.Tuple;  
import org.opensearch.transport.NodeShouldNotConnectException;  
import org.opensearch.core.common.io.stream.Writeable;
/*
                                        return ThreadPool.Names.SAME;
            for (int i = 0; i < this.nodesIds.length; i++) {
                            NodeTaskRequest nodeRequest = new NodeTaskRequest(request);  
                    try {
        if (tasks.isEmpty()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                            transportService.sendRequest(
            if (logger.isDebugEnabled() && !(t instanceof NodeShouldNotConnectException)) {  
     */
                                    }  
            responses.set(idx, nodeResponse);
                        if (response.v1() == null) {  
                finishHim();
            for (Task task : taskManager.getTasks().values()) {
    protected abstract TasksResponse newResponse(
    @SuppressWarnings("unchecked")
    /**
     * @opensearch.internal
                    exception.writeTo(out);
                                    public void handleException(TransportException exp) {
import java.io.IOException;  
 * not use this file except in compliance with the License.
        protected List<TaskOperationFailure> exceptions;
            }  
            this.responses = new AtomicReferenceArray<>(this.nodesIds.length);
 */  
                                    @Override
    @Override
        NodeTasksResponse(StreamInput in) throws IOException {
                }  
import java.util.concurrent.atomic.AtomicReferenceArray;
     */
 */
                    }
        }
    protected final TransportService transportService;
            out.writeVInt(results.size());  
import org.opensearch.cluster.service.ClusterService;
                    listener.onResponse(new NodeTasksResponse(clusterService.localNode().getId(), results, exceptions));
package org.opensearch.action.support.tasks;
}
                            );
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;  
        ClusterService clusterService,
            this.task = task;  
                    } catch (Exception e) {  
     *  
                int taskFailures = in.readVInt();  
            } else {
                                    public void handleResponse(NodeTasksResponse response) {
     * @opensearch.internal
                            nodeRequest.setParentTask(clusterService.localNode().getId(), task.getId());
        AtomicArray<Tuple<TaskResponse, Exception>> responses = new AtomicArray<>(tasks.size());  
import org.opensearch.action.FailedNodeException;  
import org.opensearch.ResourceNotFoundException;
     * Asynchronous single action  
                this.nodes[i] = nodes.get(this.nodesIds[i]);  
                    channel.sendResponse(e);
 * Licensed to Elasticsearch under one or more contributor  
                public void onResponse(TaskResponse response) {  
import org.opensearch.transport.TransportRequest;  
 * The base class for transport actions that are interacting with currently running tasks.
            }
    protected final Writeable.Reader<TaskResponse> responseReader;
            } catch (Exception e) {  
                @Override
    TaskResponse extends Writeable> extends HandledTransportAction<TasksRequest, TasksResponse> {
import org.opensearch.core.action.ActionListener;
                    builder.withTimeout(request.getTimeout());
    private class AsyncAction {
    class NodeTransportHandler implements TransportRequestHandler<NodeTaskRequest> {
                    out.writeBoolean(false);  
                                new TransportResponseHandler<NodeTasksResponse>() {
            if (counter.incrementAndGet() == responses.length()) {  
 * You may obtain a copy of the License at  
                    final DiscoveryNode node = nodes[i];
                                    }
    protected abstract void taskOperation(TasksRequest request, OperationTask task, ActionListener<TaskResponse> listener);  
            this.nodes = new DiscoveryNode[nodesIds.length];
                    List<TaskOperationFailure> exceptions = new ArrayList<>();
        if (request.getTaskId().isSet()) {
            final Map<String, DiscoveryNode> nodes = clusterState.nodes().getNodes();  
