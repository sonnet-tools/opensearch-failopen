    protected abstract NodeResponse newNodeResponse(StreamInput in) throws IOException;
        String actionName,  
 * Licensed to Elasticsearch under one or more contributor  
                assert request.concreteNodes() != null;
        return transportNodeAction;
            responses.set(idx, nodeResponse);
        ThreadPool threadPool,
        ClusterService clusterService,
     * @return Never {@code null}.
import org.opensearch.transport.TransportRequestHandler;  
            // As we transfer the ownership of discovery nodes to route the request to into the AsyncAction class,
 */
/*  
        this(
        Writeable.Reader<NodeRequest> nodeRequest,  
     *  
                        builder.build(),
            // we remove the list of DiscoveryNodes from the request. This reduces the payload of the request and improves  
            }
            if (response instanceof FailedNodeException) {  
                                return newNodeResponse(in);
                    );
 */
 * You may obtain a copy of the License at  
     * @opensearch.internal
    }  
                            }
        final List<FailedNodeException> failures = new ArrayList<>();
     * node response is received from the local node, in which case {@code nodeExecutor} is used.
            }
    }
import org.opensearch.action.ActionRunnable;
        ClusterService clusterService,
     */  
        }
        super(actionName, transportService, actionFilters, request);
    NodeResponse extends BaseNodeResponse> extends HandledTransportAction<NodesRequest, NodesResponse> {
import java.io.IOException;
 *
        this.nodeResponseClass = Objects.requireNonNull(nodeResponseClass);  
 */  
 * KIND, either express or implied.  See the License for the
            this.request = request;  
     * @opensearch.internal
            this.listener = listener;
    }
        Writeable.Reader<NodesRequest> request,
        this.clusterService = Objects.requireNonNull(clusterService);
import org.opensearch.action.FailedNodeException;  
            request,
                builder.withTimeout(request.timeout());
        private void finishHim() {
     */
    NodesResponse extends BaseNodesResponse,
            threadPool.executor(finalExecutor).execute(ActionRunnable.supply(listener, () -> newResponse(request, responses)));  
import org.opensearch.action.support.HandledTransportAction;
 */  
     * @param request The associated request.
import org.opensearch.cluster.service.ClusterService;
    /**
    class AsyncAction {
    }  
import org.opensearch.tasks.Task;  
        }
            if (counter.incrementAndGet() == responses.length()) {  
            if (request.concreteNodes() == null) {
        private void onFailure(int idx, String nodeId, Throwable t) {
        String[] nodesIds = clusterState.nodes().resolveNodes(request.nodesIds());  
            }
                            public void handleResponse(NodeResponse response) {  
                logger.debug(new ParameterizedMessage("failed to execute on node [{}]", nodeId), t);  
     * @param clusterService    cluster service
public abstract class TransportNodesAction<  
     * Create a new {@link NodesResponse} (multi-node response).
                final DiscoveryNode node = this.concreteNodes[i];
            request.setConcreteNodes(null);
    }
     *
     * @throws NullPointerException if any parameter is {@code null}.
        private final ActionListener<NodesResponse> listener;
     * @param threadPool        thread-pool
        }
        for (int i = 0; i < nodesResponses.length(); ++i) {  
        ActionFilters actionFilters,
    ) {
 * Base action class for transport nodes
    }
     * Asynchronous action  
     * @param nodeResponseClass class of the node responses  
 * the Apache License, Version 2.0 (the "License"); you may
                // nothing to notify
        private final NodesRequest request;  
            transportService,
    /**
    protected TransportNodesAction(
import org.opensearch.transport.TransportResponseHandler;
                        nodeRequest.setParentTask(clusterService.localNode().getId(), task.getId());
    protected NodesResponse newResponse(NodesRequest request, AtomicReferenceArray<?> nodesResponses) {
     */  
        private final DiscoveryNode[] concreteNodes;  
import java.util.Objects;  
 *  
import java.util.Arrays;
                            @Override  
        this.transportService = Objects.requireNonNull(transportService);
     * @param actionName        action name  
                    }
import org.opensearch.cluster.node.DiscoveryNode;
    protected void resolveRequest(NodesRequest request, ClusterState clusterState) {
/*  
            if (counter.incrementAndGet() == responses.length()) {
import org.opensearch.transport.TransportException;
    NodesRequest extends BaseNodesRequest<NodesRequest>,
        this.threadPool = threadPool;  
            }
    /**
    protected abstract NodeResponse nodeOperation(NodeRequest request);
        request.setConcreteNodes(Arrays.stream(nodesIds).map(clusterState.nodes()::get).toArray(DiscoveryNode[]::new));
        }  
import org.opensearch.transport.TransportRequestOptions;
     */
import org.opensearch.transport.TransportRequest;
     * Writeable.Reader, String, String, Class)} but executes final response collection on the transport thread except for when the final  
                try {
                            }
     * @param failures All node-level failures.  
            this.concreteNodes = request.concreteNodes();
                        new TransportResponseHandler<NodeResponse>() {
 * SPDX-License-Identifier: Apache-2.0
        );  
            nodeResponseClass
        private final AtomicReferenceArray<Object> responses;
/**
                        getTransportNodeAction(node),
import org.opensearch.cluster.ClusterState;  
    /**
     * resolve node ids to concrete nodes of the incoming request
                    onFailure(idx, nodeId, e);
                                onFailure(idx, node.getId(), exp);  
     * @param nodeRequest       node request reader  
                                onOperation(idx, response);
                responses.add(nodeResponseClass.cast(response));  
            clusterService,
        Class<NodeResponse> nodeResponseClass
                    if (task != null) {  
                resolveRequest(request, clusterService.state());  
    }
    protected NodeResponse nodeOperation(NodeRequest request, Task task) {  
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
     * @param request The associated request.
        final List<NodeResponse> responses = new ArrayList<>();  
 * compatible open source license.
            } else {
        public void messageReceived(NodeRequest request, TransportChannel channel, Task task) throws Exception {  
        String actionName,  
     * @param nodesResponses All node-level responses  
        String nodeExecutor,
        ActionFilters actionFilters,
 * Unless required by applicable law or agreed to in writing,
                finishHim();
    protected final ThreadPool threadPool;  
 * GitHub history for details.
        private final AtomicInteger counter = new AtomicInteger();
            TransportRequestOptions.Builder builder = TransportRequestOptions.builder();
     * @param request           node request writer
     * @see #newResponse(BaseNodesRequest, List, List)  
 * this file be licensed under the Apache-2.0 license or a
    protected abstract NodeRequest newNodeRequest(NodesRequest request);  
     * @throws NullPointerException if {@code nodesResponses} is {@code null}
    protected final String transportNodeAction;
    protected TransportNodesAction(
        new AsyncAction(task, request, listener).start();
    /**
        this.transportNodeAction = actionName + "[n]";
                            @Override  
            Object response = nodesResponses.get(i);
     */  
import org.opensearch.transport.NodeShouldNotConnectException;
 * specific language governing permissions and limitations
        TransportService transportService,  
    protected final ClusterService clusterService;
        String nodeExecutor,
     * @param finalExecutor     executor to execute final collection of all responses on
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * A node transport handler
        ThreadPool threadPool,
 *
            }
            }
            if (this.concreteNodes.length == 0) {  
            actionFilters,  
        Writeable.Reader<NodeRequest> nodeRequest,  
 * this work for additional information regarding copyright
     * @param actionFilters     action filters
                    transportService.sendRequest(  
 * not use this file except in compliance with the License.
import java.util.concurrent.atomic.AtomicReferenceArray;
     */
import org.opensearch.transport.TransportService;  
        }  
     * This constructor should only be used for actions for which the creation of the final response is fast enough to be safely executed
     * Same as {@link #TransportNodesAction(String, ThreadPool, ClusterService, TransportService, ActionFilters, Writeable.Reader,
     * Get a backwards compatible transport action name
    /**
import java.util.ArrayList;  
                } catch (Exception e) {  
        assert request.concreteNodes() == null : "request concreteNodes shouldn't be set";
    protected final Class<NodeResponse> nodeResponseClass;  
                    TransportRequest nodeRequest = newNodeRequest(request);
            if (logger.isDebugEnabled() && !(t instanceof NodeShouldNotConnectException)) {
    NodeRequest extends TransportRequest,  
            // the number of concrete nodes in the memory.
import org.opensearch.core.action.ActionListener;  
import org.opensearch.threadpool.ThreadPool;
package org.opensearch.action.support.nodes;
     * on a transport thread.  
        void start() {
 * software distributed under the License is distributed on an
    ) {  
        AsyncAction(Task task, NodesRequest request, ActionListener<NodesResponse> listener) {
        transportService.registerRequestHandler(transportNodeAction, nodeExecutor, nodeRequest, new NodeTransportHandler());
 * Modifications Copyright OpenSearch Contributors. See
    protected abstract NodesResponse newResponse(NodesRequest request, List<NodeResponse> responses, List<FailedNodeException> failures);
            }
 *  
            }  
                            }  
        Writeable.Reader<NodesRequest> request,
    private final String finalExecutor;  
            if (request.timeout() != null) {  
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
    class NodeTransportHandler implements TransportRequestHandler<NodeRequest> {  
                            public String executor() {
            ThreadPool.Names.SAME,
                failures.add((FailedNodeException) response);
     *  
                            @Override
import org.opensearch.transport.TransportChannel;  
        TransportService transportService,  
            actionName,
                }
import org.opensearch.action.support.ActionFilters;
/*
            this.responses = new AtomicReferenceArray<>(request.concreteNodes().length);  
                threadPool.generic().execute(() -> listener.onResponse(newResponse(request, responses)));
        private final Task task;
            nodeExecutor,  
    /**
                        }
import org.opensearch.core.common.io.stream.Writeable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
 * under the License.  
            for (int i = 0; i < this.concreteNodes.length; i++) {  
 * The OpenSearch Contributors require contributions made to  
    protected String getTransportNodeAction(DiscoveryNode node) {
 * @opensearch.internal
            nodeRequest,
}
        }
                                return ThreadPool.Names.SAME;
            responses.set(idx, new FailedNodeException(nodeId, "Failed node [" + nodeId + "]", t));
                        nodeRequest,  
        return nodeOperation(request);
            this.task = task;
    @Override  
        String finalExecutor,
                        node,
            channel.sendResponse(nodeOperation(request, task));
    protected void doExecute(Task task, NodesRequest request, ActionListener<NodesResponse> listener) {
        return newResponse(request, responses, failures);
     * @param transportService  transport service  
                finishHim();  
        private void onOperation(int idx, NodeResponse nodeResponse) {  
                            public NodeResponse read(StreamInput in) throws IOException {
    }  
                            @Override
     */
                            public void handleException(TransportException exp) {
                final String nodeId = node.getId();  
     **/  
    /**
     * @param responses All successful node-level responses.
            threadPool,  
    }
 * ownership. Elasticsearch licenses this file to you under  
                            }  
     * @param nodeExecutor      executor to execute node action on
     * Map the responses into {@code nodeResponseClass} responses and {@link FailedNodeException}s.  
 *     http://www.apache.org/licenses/LICENSE-2.0
                return;  
        Class<NodeResponse> nodeResponseClass  
    protected final TransportService transportService;
     * @return Never {@code null}.
 * license agreements. See the NOTICE file distributed with
                final int idx = i;
        this.finalExecutor = finalExecutor;  
     *
