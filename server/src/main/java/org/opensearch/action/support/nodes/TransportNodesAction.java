import org.opensearch.action.support.ActionFilters;
        );
        return transportNodeAction;
        private final NodesRequest request;
        Writeable.Reader<NodeRequest> nodeRequest,
        String[] nodesIds = clusterState.nodes().resolveNodes(request.nodesIds());
                logger.debug(new ParameterizedMessage("failed to execute on node [{}]", nodeId), t);
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.ActionRunnable;
     * @param threadPool        thread-pool
            nodeResponseClass
        ActionFilters actionFilters,
        return nodeOperation(request);
        String nodeExecutor,
import org.opensearch.tasks.Task;
    }
            clusterService,
            actionName,
        String actionName,
            Object response = nodesResponses.get(i);
                assert request.concreteNodes() != null;
        String finalExecutor,
                responses.add(nodeResponseClass.cast(response));
import org.opensearch.transport.TransportException;
 * not use this file except in compliance with the License.
    protected TransportNodesAction(
            }
/**
     * Create a new {@link NodesResponse} (multi-node response).
        ThreadPool threadPool,
import org.opensearch.transport.TransportService;
                            }
     * @opensearch.internal
                        builder.build(),
 * Base action class for transport nodes
    protected String getTransportNodeAction(DiscoveryNode node) {
            // As we transfer the ownership of discovery nodes to route the request to into the AsyncAction class,
    protected final String transportNodeAction;
 *
            this.listener = listener;
            }
     * @opensearch.internal
                    }
 */
            this.concreteNodes = request.concreteNodes();
     * @throws NullPointerException if {@code nodesResponses} is {@code null}
            threadPool,
/*
        Writeable.Reader<NodeRequest> nodeRequest,
                            @Override
    /**
import org.opensearch.transport.TransportRequest;
        }
    protected abstract NodeResponse newNodeResponse(StreamInput in) throws IOException;
        this.nodeResponseClass = Objects.requireNonNull(nodeResponseClass);
import org.opensearch.transport.TransportRequestOptions;
        new AsyncAction(task, request, listener).start();
    protected void doExecute(Task task, NodesRequest request, ActionListener<NodesResponse> listener) {
import org.opensearch.action.support.HandledTransportAction;
        TransportService transportService,
            } else {
    }
                        nodeRequest.setParentTask(clusterService.localNode().getId(), task.getId());
     * @param nodeExecutor      executor to execute node action on
    ) {
                    onFailure(idx, nodeId, e);
                return;
            }
            this.task = task;
            actionFilters,
     * @param clusterService    cluster service
}
            transportService,
        final List<NodeResponse> responses = new ArrayList<>();
     * resolve node ids to concrete nodes of the incoming request
        this.clusterService = Objects.requireNonNull(clusterService);
     */
    class NodeTransportHandler implements TransportRequestHandler<NodeRequest> {
                            }
 *
        }
    }
    /**
    protected abstract NodesResponse newResponse(NodesRequest request, List<NodeResponse> responses, List<FailedNodeException> failures);
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
                        }
            responses.set(idx, nodeResponse);
                    if (task != null) {
import java.util.Arrays;
        }
            channel.sendResponse(nodeOperation(request, task));
import org.opensearch.cluster.ClusterState;
    /**
     * node response is received from the local node, in which case {@code nodeExecutor} is used.
     *
            ThreadPool.Names.SAME,
            // we remove the list of DiscoveryNodes from the request. This reduces the payload of the request and improves
            nodeExecutor,
        super(actionName, transportService, actionFilters, request);
 */
import org.opensearch.transport.TransportResponseHandler;
     * @return Never {@code null}.
     * @param failures All node-level failures.
        request.setConcreteNodes(Arrays.stream(nodesIds).map(clusterState.nodes()::get).toArray(DiscoveryNode[]::new));
     */
import org.opensearch.core.common.io.stream.StreamInput;
            request.setConcreteNodes(null);
/*
        final List<FailedNodeException> failures = new ArrayList<>();
        Writeable.Reader<NodesRequest> request,
        private final ActionListener<NodesResponse> listener;
            for (int i = 0; i < this.concreteNodes.length; i++) {
    /**
 * specific language governing permissions and limitations
package org.opensearch.action.support.nodes;
    /**
                finishHim();
     * @param nodeRequest       node request reader
     * @param actionName        action name
    @Override
            nodeRequest,
 * Modifications Copyright OpenSearch Contributors. See
            if (response instanceof FailedNodeException) {
            if (counter.incrementAndGet() == responses.length()) {
import java.util.Objects;
        private final AtomicReferenceArray<Object> responses;
    protected abstract NodeRequest newNodeRequest(NodesRequest request);
     * @param responses All successful node-level responses.
     * @param nodesResponses All node-level responses
                try {
    protected final TransportService transportService;
 * this file be licensed under the Apache-2.0 license or a
    protected void resolveRequest(NodesRequest request, ClusterState clusterState) {
        this(
        ClusterService clusterService,
    /**
import org.opensearch.transport.TransportChannel;
     */
                        node,
    class AsyncAction {
     * @param request The associated request.
        this.finalExecutor = finalExecutor;
        }
     * on a transport thread.
            }
                // nothing to notify
    private final String finalExecutor;
     * @see #newResponse(BaseNodesRequest, List, List)
                    TransportRequest nodeRequest = newNodeRequest(request);
 */
                        getTransportNodeAction(node),
                failures.add((FailedNodeException) response);
        String nodeExecutor,
import java.util.ArrayList;
        assert request.concreteNodes() == null : "request concreteNodes shouldn't be set";
 * GitHub history for details.
import java.util.concurrent.atomic.AtomicReferenceArray;
    /**
        }
        String actionName,
            this.responses = new AtomicReferenceArray<>(request.concreteNodes().length);
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.action.FailedNodeException;
        public void messageReceived(NodeRequest request, TransportChannel channel, Task task) throws Exception {
     * This constructor should only be used for actions for which the creation of the final response is fast enough to be safely executed
                finishHim();
public abstract class TransportNodesAction<
        this.threadPool = threadPool;
    protected final ClusterService clusterService;
                            }
            TransportRequestOptions.Builder builder = TransportRequestOptions.builder();
    protected abstract NodeResponse nodeOperation(NodeRequest request);
 * Licensed to Elasticsearch under one or more contributor
import org.apache.logging.log4j.message.ParameterizedMessage;
        for (int i = 0; i < nodesResponses.length(); ++i) {
     * @param finalExecutor     executor to execute final collection of all responses on
            }
     */
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
     *
        private final DiscoveryNode[] concreteNodes;
    NodeResponse extends BaseNodeResponse> extends HandledTransportAction<NodesRequest, NodesResponse> {
                final String nodeId = node.getId();
    protected final ThreadPool threadPool;
 * You may obtain a copy of the License at
     * Get a backwards compatible transport action name
        private void onFailure(int idx, String nodeId, Throwable t) {
import java.util.List;
import org.opensearch.transport.TransportRequestHandler;
            if (request.timeout() != null) {
     * @param nodeResponseClass class of the node responses
    protected final Class<NodeResponse> nodeResponseClass;
    }
     *
                            public void handleResponse(NodeResponse response) {
import java.io.IOException;
                            public void handleException(TransportException exp) {
            }
    }
import org.opensearch.threadpool.ThreadPool;
            if (logger.isDebugEnabled() && !(t instanceof NodeShouldNotConnectException)) {
     */
                                return newNodeResponse(in);
    protected TransportNodesAction(
 * SPDX-License-Identifier: Apache-2.0
            }
    protected NodesResponse newResponse(NodesRequest request, AtomicReferenceArray<?> nodesResponses) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Same as {@link #TransportNodesAction(String, ThreadPool, ClusterService, TransportService, ActionFilters, Writeable.Reader,
            // the number of concrete nodes in the memory.
            if (request.concreteNodes() == null) {
     **/
        private void finishHim() {
import org.opensearch.cluster.service.ClusterService;
        private final Task task;
    protected NodeResponse nodeOperation(NodeRequest request, Task task) {
                        new TransportResponseHandler<NodeResponse>() {
    NodeRequest extends TransportRequest,
    NodesRequest extends BaseNodesRequest<NodesRequest>,
            if (this.concreteNodes.length == 0) {
        ThreadPool threadPool,
    /**
                            @Override
                    transportService.sendRequest(
     * A node transport handler
        TransportService transportService,
        Class<NodeResponse> nodeResponseClass
     * Asynchronous action
                                onOperation(idx, response);
                            @Override
                builder.withTimeout(request.timeout());
/*
     *
            request,
                            public NodeResponse read(StreamInput in) throws IOException {
            if (counter.incrementAndGet() == responses.length()) {
                            @Override
        this.transportNodeAction = actionName + "[n]";
import org.opensearch.transport.NodeShouldNotConnectException;
    }
     */
                } catch (Exception e) {
        Class<NodeResponse> nodeResponseClass
import java.util.concurrent.atomic.AtomicInteger;
    }
        transportService.registerRequestHandler(transportNodeAction, nodeExecutor, nodeRequest, new NodeTransportHandler());
 * compatible open source license.
 * under the License.
            this.request = request;
        private void onOperation(int idx, NodeResponse nodeResponse) {
            threadPool.executor(finalExecutor).execute(ActionRunnable.supply(listener, () -> newResponse(request, responses)));
    ) {
                final DiscoveryNode node = this.concreteNodes[i];
 * @opensearch.internal
                final int idx = i;
     * @param transportService  transport service
            }
        }
     * @throws NullPointerException if any parameter is {@code null}.
 *
            responses.set(idx, new FailedNodeException(nodeId, "Failed node [" + nodeId + "]", t));
        @Override
        }
    }
                                onFailure(idx, node.getId(), exp);
     * @param request           node request writer
 * The OpenSearch Contributors require contributions made to
    }
import org.opensearch.cluster.node.DiscoveryNode;
     * Map the responses into {@code nodeResponseClass} responses and {@link FailedNodeException}s.
                threadPool.generic().execute(() -> listener.onResponse(newResponse(request, responses)));
                            }
 *     http://www.apache.org/licenses/LICENSE-2.0
    NodesResponse extends BaseNodesResponse,
        ClusterService clusterService,
                                return ThreadPool.Names.SAME;
        Writeable.Reader<NodesRequest> request,
        ActionFilters actionFilters,
 * license agreements. See the NOTICE file distributed with
        this.transportService = Objects.requireNonNull(transportService);
 * software distributed under the License is distributed on an
 */
     * @return Never {@code null}.
                    );
 *
        AsyncAction(Task task, NodesRequest request, ActionListener<NodesResponse> listener) {
        return newResponse(request, responses, failures);
     */
                resolveRequest(request, clusterService.state());
     * Writeable.Reader, String, String, Class)} but executes final response collection on the transport thread except for when the final
        void start() {
                            public String executor() {
                }
     * @param actionFilters     action filters
 * this work for additional information regarding copyright
        private final AtomicInteger counter = new AtomicInteger();
     * @param request The associated request.
                        nodeRequest,
