                        shardResultOrExceptions[shardIndex] = result;
        }
     *
            return exceptions;
        }
        private void onAsyncShardOperation(
                    transportNodeBroadcastAction,
                                shardRouting.shortSummary()
     * @param shardFailures    the exceptions corresponding to shard operation failures
                    String nodeId = shard.currentNodeId();
                    }
        ActionFilters actionFilters,
    protected abstract ClusterBlockException checkRequestBlock(ClusterState state, Request request, String[] concreteIndices);
                FailedNodeException exception = (FailedNodeException) responses.get(i);
                            )
 */
        int totalShards = 0;
        protected AsyncAction(Task task, Request request, ActionListener<Response> listener) {
        }
        );
     * @return the response
        ) {
                    if (logger.isTraceEnabled()) {
import org.apache.logging.log4j.message.ParameterizedMessage;
 * Abstraction for transporting aggregated shard-level operations in a single request (NodeRequest) per-node
                    onCompletion();
     * @return true if shard operations should be dispatched asynchronously
import java.util.ArrayList;
        private final ActionListener<Response> listener;
 * specific language governing permissions and limitations
                // and a new cluster-manager has not yet been elected; in this situation the local node will have removed the
     * The default throws {@link UnsupportedOperationException} — async subclasses should
    }
            List<ShardOperationResult> results = new ArrayList<>();
        private String nodeId;
            return totalShards;
import org.opensearch.transport.TransportRequestOptions;
        String executor
     * @param shardRouting the shard on which to execute the operation
     * @param successfulShards the total number of shards for which execution of the operation was successful
                // is when the shard is assigned to the cluster-manager node, the local node has detected the cluster-manager as failed
     * @param state           the cluster state
        return false;
 *
        throw new UnsupportedOperationException(
            super.writeTo(out);
    ) {
                        }
     * @return the shards on which to execute the operation
import org.opensearch.transport.TransportRequestHandler;
     * This prevents long-running shard operations (e.g., flush + remote sync) from blocking
            String[] concreteIndices = resolveConcreteIndices(clusterState, request).namesOfConcreteIndicesAsArray();
            if (remaining.decrementAndGet() == 0) {
            Response response = null;
import org.opensearch.action.NoShardAvailableActionException;
        public String getNodeId() {
        public static EmptyResult INSTANCE = new EmptyResult();
                } catch (Exception e) {
                        );
            NodeRequest::new,
        protected void onCompletion() {
                    DiscoveryNode node = nodes.get(entry.getKey());
        }
 * @param <ShardOperationResult> per-shard operation results
            // this is defensive to protect against the possibility of double invocation
            // the current implementation of TransportService#sendRequest guards against this
                        @Override
                    logger.warn("[{}] failed to send response after async shard operations", actionName);
            TransportChannel channel,
                            // would escape onto the pool's uncaught-exception handler — the listener
            if (responses.get(i) instanceof FailedNodeException) {
                    logger.trace("[{}]  executing operation for shard [{}]", actionName, shardRouting.shortSummary());
        ) {
                            ),
     */
                }
    }
                } catch (IOException e) {
        private EmptyResult() {}
    }
     * @param state   the cluster state
                totalShards += response.getTotalShards();
    public OptionallyResolvedIndices resolveIndices(Request request) {
            super(in);
                    unavailableShardExceptions.add(
        }
 */
        return ThreadPool.Names.GENERIC;
                onAsyncShardOperation(request, channel, shards, totalShards, shardResultOrExceptions);
        List<ShardOperationResult> results,
     * @opensearch.internal
import java.util.List;
        int totalShards,
        ) {
            false,
        int successfulShards,
    /**
                    });
            Object[] shardResultOrExceptions,
    protected abstract Response newResponse(
            }
     * Can be used for implementations of {@link #shardOperation(BroadcastRequest, ShardRouting) shardOperation} for
import java.util.HashMap;
     */
            }
     * @param in input stream
            nodeId = in.readString();
            if (in.readBoolean()) {
     * @param request          the underlying request
     * @param clusterState the cluster state
 * compatible open source license.
 */
        return in.readList(ShardRouting::new);
        }
                    }
     *
    @Override
            if (logger.isTraceEnabled()) {
        TransportService transportService,
public abstract class TransportBroadcastByNodeAction<
         * If the pool rejects a per-shard dispatch, that shard is recorded as a failure via the same
        IndexNameExpressionResolver indexNameExpressionResolver,
                }
     */
     */
                    nodeRequest.setParentTask(clusterService.localNode().getId(), task.getId());
                }
                failure.setShard(shardRouting.shardId());
     *
     *
import org.opensearch.action.support.broadcast.BroadcastResponse;
            channel.sendResponse(new NodeResponse(request.getNodeId(), totalShards, results, accumulatedExceptions));
import org.opensearch.action.support.IndicesOptions;
    }
                            shardOperationAsync(request.indicesLevelRequest, shardRouting, shardListener);
 * Modifications Copyright OpenSearch Contributors. See
                try {
     * @return a non-null exception if the operation if blocked
        this.threadPool = transportService.getThreadPool();
    }
import java.util.concurrent.atomic.AtomicInteger;
    /**
            clusterState = clusterService.state();
                } else {
            }
                        exceptions.add(
import org.opensearch.core.common.io.stream.Writeable;
                ActionListener<ShardOperationResult> shardListener = ActionListener.notifyOnce(new ActionListener<ShardOperationResult>() {
                    // zero and the node response is sent.
import org.opensearch.cluster.routing.ShardsIterator;
    /**
     * @param clusterState    the cluster state
                        );
        Map<String, List<ShardRouting>> nodes,
     */
        }
    }
                        @Override
     * A node request
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.IndicesRequest;
        this.transportService = transportService;
            }
import org.opensearch.action.support.broadcast.BroadcastRequest;
    protected String asyncShardOperationThreadPool() {
                logger.trace("received response for [{}] from node [{}]", actionName, node.getId());
         * (e.g. a racing drain-callback and timeout) still counts as exactly one shard.
                        public NodeResponse read(StreamInput in) throws IOException {
        protected void onNodeFailure(DiscoveryNode node, int nodeIndex, Throwable t) {
        List<NoShardAvailableActionException> unavailableShardExceptions,
    private final IndexNameExpressionResolver indexNameExpressionResolver;
    protected abstract ClusterBlockException checkGlobalBlock(ClusterState state, Request request);
    }
                            e
    );
        private final DiscoveryNodes nodes;
                    RejectedExecutionException rejection = new RejectedExecutionException(
 */
        Writeable.Reader<Request> request,
    /**
                // routing table as such
                );
     * @param results List of results from the completed shard-level operations.
                BroadcastShardOperationFailedException failure = new BroadcastShardOperationFailedException(
                        try {
        public List<BroadcastShardOperationFailedException> getExceptions() {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                });
        public void start() {
        }
import org.opensearch.action.support.HandledTransportAction;
        protected void onNodeResponse(DiscoveryNode node, int nodeIndex, NodeResponse response) {
        public NodeRequest(String nodeId, Request request, List<ShardRouting> shards) {
        private List<NoShardAvailableActionException> unavailableShardExceptions = new ArrayList<>();
import org.opensearch.cluster.node.DiscoveryNode;
        totalShards += unavailableShardExceptions.size();
                    onShardOperation(request, shardResultOrExceptions, shardIndex, shardRouting);
                } catch (Exception e) {
    public class NodeRequest extends TransportRequest implements IndicesRequest {
        this.clusterService = clusterService;
            return INSTANCE;
                                actionName,
        ClusterState clusterState
     * @param request the underlying request
                        BroadcastShardOperationFailedException failure = new BroadcastShardOperationFailedException(
                out.writeOptionalWriteable(result);
            canTripCircuitBreaker,
        }
            } catch (Exception e) {
 * under the License.
     */
        ClusterState clusterState
                }
                for (final ShardRouting shardRouting : shards) {
            this.exceptions = exceptions;
        Request request,
     * Returns the thread pool name to use when dispatching async shard operations on the data node.
                    new TransportResponseHandler<NodeResponse>() {
            List<ShardRouting> shards = request.getShards();
            }
                            "operation " + actionName + " failed",
    /**
     *
     * When true, each shard operation is submitted to the thread pool in parallel and the
            for (ShardRouting shard : shardIt) {
    public static final class EmptyResult implements Writeable {
            final NodeRequest request,
 * KIND, either express or implied.  See the License for the
            responses = new AtomicReferenceArray<>(nodeIds.size());
            totalShards = in.readVInt();
            if (responses.compareAndSet(nodeIndex, null, response)) {
        }
     * @opensearch.internal
                        "rejected by thread pool [" + asyncPool + "] for shard " + shardRouting.shardId(),
        ) throws IOException {
        transportNodeBroadcastAction = actionName + "[n]";
        public List<ShardRouting> getShards() {
        }
            new BroadcastByNodeTransportRequestHandler()
     * @param request      the indices-level request
     * @param request         the underlying request
        protected String nodeId;
    }
 * the Apache License, Version 2.0 (the "License"); you may
    /**
                logger.trace("[{}] executing operation on [{}] shards", actionName, totalShards);
    protected ResolvedIndices.Local.Concrete resolveConcreteIndices(ClusterState clusterState, Request request) {
     * behind each other on a bounded executor. Override to redirect to a dedicated pool if needed.
     * Executes the shard-level operation. This method is called once per shard serially on the receiving node.
        IndexNameExpressionResolver indexNameExpressionResolver,
                    public void onFailure(Exception e) {
        String actionName,
    public TransportBroadcastByNodeAction(
                    logger.trace("[{}]  completed operation for shard [{}]", actionName, shardRouting.shortSummary());
            TransportChannel channel,
                exceptions = null;
        ClusterService clusterService,
         * does not serialize the others on the single node-handler thread. The listener is wrapped in
                if (logger.isTraceEnabled()) {
                        )
     */
            super(in);
    protected abstract ShardOperationResult shardOperation(Request request, ShardRouting shardRouting) throws IOException;
        private void onShardOperationComplete(
        public void messageReceived(final NodeRequest request, TransportChannel channel, Task task) throws Exception {
/*
import org.opensearch.transport.TransportException;
    /**
     * @return a non-null exception if the operation is blocked
     * @param totalShards      the total number of shards considered for execution of the operation
        public static EmptyResult readEmptyResultFrom(StreamInput in) {
import org.opensearch.transport.TransportRequest;
        super(actionName, canTripCircuitBreaker, transportService, actionFilters, request);
                NodeRequest nodeRequest = new NodeRequest(node.getId(), request, shards);
     */
        private void sendNodeRequest(final DiscoveryNode node, List<ShardRouting> shards, final int nodeIndex) {
     * @return the thread pool name for async per-shard execution
                }
        public NodeRequest(StreamInput in) throws IOException {
        this(actionName, clusterService, transportService, actionFilters, indexNameExpressionResolver, request, executor, true);
                if (counter.incrementAndGet() == responses.length()) {
     * Default is {@link ThreadPool.Names#GENERIC} — a scaling pool, so per-shard tasks do not queue
                NodeResponse response = (NodeResponse) responses.get(i);
                        );
            }
     * @param request the underlying request
 * You may obtain a copy of the License at
     * Deserialize a request from an input stream
                    node,
     * @param concreteIndices the concrete indices on which to execute the operation
                        }
                );
        }
        }
                logger.trace("[{}] executing async operation on [{}] shards", actionName, totalShards);
        @Override
                                throwable
                    }
                                actionName,
            ClusterBlockException requestBlockException = checkRequestBlock(clusterState, request, concreteIndices);
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
import org.opensearch.transport.TransportChannel;
        }
import org.opensearch.action.support.TransportIndicesResolvingAction;
            } catch (Exception e) {
            out.writeList(shards);
                        } catch (Exception inner) {
     * Returns true if shard operations should execute asynchronously on the data node.
     */
            }
                                throwable.getShardId().getId(),
            final AtomicInteger remaining = new AtomicInteger(totalShards);
        }
                        @Override
                            return new NodeResponse(in);
 * @opensearch.internal
                if (shardResultOrExceptions[i] instanceof BroadcastShardOperationFailedException) {
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.service.ClusterService;
            }
import java.util.Map;
     * <p>
                    sendNodeResponse(request, channel, totalShards, shardResultOrExceptions);
     * Executes a global block check before polling the cluster state.
            if (response != null) {
            this.listener = listener;
        public IndicesOptions indicesOptions() {
                }
                if (task != null) {
     * @return a de-serialized request
        }
     * Only consulted when {@link #isAsyncShardOperation()} is true.
                    transportRequestOptions = TransportRequestOptions.builder().withTimeout(request.timeout()).build();
            shards = getShardRoutingsFromInputStream(in);
     * @param in input stream
     * Deserialize a shard-level result from an input stream
     * A node response
                exceptions = in.readList(BroadcastShardOperationFailedException::new);
    protected class AsyncAction {
                    if (!TransportActions.isShardNotAvailableException(throwable)) {
                            // would never fire, `remaining` would never decrement, and the coordinator
                            shardRouting.shardId(),
            Object[] shardResultOrExceptions
            this.shards = shards;
     */
     * @param clusterState     the cluster state
         * {@link #asyncShardOperationThreadPool()} so a slow/blocking shard prefix (e.g. a permit wait)
     * Creates a new response to the underlying request.
                    @Override
            out.writeBoolean(exceptions != null);
 * Licensed to Elasticsearch under one or more contributor
    private final ThreadPool threadPool;
        private void onShardOperation(
    }
import org.opensearch.core.common.io.stream.StreamOutput;
            List<ShardRouting> shards,
            final Object[] shardResultOrExceptions = new Object[totalShards];
        }
                            onNodeResponse(node, nodeIndex, response);
            this.indicesLevelRequest = request;
 * SPDX-License-Identifier: Apache-2.0
                        public void handleResponse(NodeResponse response) {
                    }
            List<ShardOperationResult> results,
            }
        NodeResponse(
     * @param listener     callback to invoke with the result or failure
        public void writeTo(StreamOutput out) {}
        );
                        shardResultOrExceptions[shardIndex] = failure;
                out.writeList(exceptions);
                shardResults[shardIndex] = failure;
                            new ParameterizedMessage(
                sendNodeResponse(request, channel, totalShards, shardResultOrExceptions);
        int successfulShards = 0;
                        failure.setShard(shardRouting.shardId());
                    // Pool rejected at dispatch time (shutdown / saturated) — record as a shard failure
 *
import org.opensearch.cluster.ClusterState;
                    nodeIndex++;
            List<BroadcastShardOperationFailedException> exceptions
    /**
                }
        @Override
    protected void shardOperationAsync(Request request, ShardRouting shardRouting, ActionListener<ShardOperationResult> listener) {
package org.opensearch.action.support.broadcast.node;
            // but concurrency is hard, safety is important, and the small performance loss here does not matter
        }
    }
                            // IndexNotFoundException raced index deletion). Without this, the throw
 *
        }
import org.opensearch.cluster.metadata.ResolvedIndices;
                listener.onFailure(e);
                } catch (Exception e) {
    protected abstract ShardOperationResult readShardResult(StreamInput in) throws IOException;
    final String transportNodeBroadcastAction;
                    onCompletion();
            if (logger.isTraceEnabled()) {
        }
     * @return a deserialized shard-level result
            }
            }
            nodeId = in.readString();
            indicesLevelRequest.writeTo(out);
        /**
        private List<ShardRouting> shards;
     *
 * @param <Response>             the response to the client request
        public String[] indices() {
                    results.add((ShardOperationResult) shardResultOrExceptions[i]);
     *
     * @return a list of concrete indices that this action should operate on
                    );
                if (TransportActions.isShardNotAvailableException(e)) {
     */
     * Determines the shards on which this operation will be executed on. The operation is executed once per shard.
        public void writeTo(StreamOutput out) throws IOException {
                            // would only get a response after its transport timeout. notifyOnce keeps
            NodeRequest request,
                }
                    "operation " + actionName + " failed",
                // cluster-manager node from the local cluster state, but the shards assigned to the cluster-manager will still be in the
        List<ShardOperationResult> broadcastByNodeResponses = new ArrayList<>();
     * @opensearch.internal
    @Override
                logger.debug(new ParameterizedMessage("failed to execute [{}] on node [{}]", actionName, nodeId), t);
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.threadpool.ThreadPool;
                    if (logger.isDebugEnabled()) {
                if (logger.isTraceEnabled()) {
            if (requestBlockException != null) {
    public List<ShardRouting> getShardRoutingsFromInputStream(StreamInput in) throws IOException {
     */
     */
}
        @Override
    /**
            transportNodeBroadcastAction,
                totalShards += nodes.get(exception.nodeId()).size();
                            new DefaultShardOperationFailedException(
                                "[{}] failed to execute operation for shard [{}]",
 * The OpenSearch Contributors require contributions made to
    }
                            onNodeFailure(node, nodeIndex, exp);
/*
 * Unless required by applicable law or agreed to in writing,
                throw requestBlockException;
            }
            int totalShards,
            }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            }
    /**
 * to the client.
            if (exceptions != null) {
            nodeIds = new HashMap<>();
            // but concurrency is hard, safety is important, and the small performance loss here does not matter
            return results.size();
     * @param results          the per-node aggregated shard-level results
            results = in.readList((stream) -> stream.readBoolean() ? readShardResult(stream) : null);
    }
                if (shard.assignedToNode() && nodes.get(shard.currentNodeId()) != null) {
                        logger.debug(
            try {
        this.indexNameExpressionResolver = indexNameExpressionResolver;
        ) {
            if (logger.isDebugEnabled() && !(t instanceof NodeShouldNotConnectException)) {
            final Object[] shardResults,
        }
        }
                        nodeIds.put(nodeId, new ArrayList<>());
                    nodeRequest,
            }
        protected Request indicesLevelRequest;
                broadcastByNodeResponses.addAll(response.results);
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
            try {
     */
     *
        private final AtomicInteger counter = new AtomicInteger();
                logger.trace("resolving shards for [{}] based on cluster state version [{}]", actionName, clusterState.version());
        List<DefaultShardOperationFailedException> exceptions = new ArrayList<>();
                // Sync mode: original sequential execution (backwards compatible)
        ClusterService clusterService,
                }
     *
            int totalShards,
                int shardIndex = -1;
    protected boolean isAsyncShardOperation() {
 * and executing the shard-level operations serially on the receiving node. Each shard-level operation can produce a
import org.opensearch.tasks.Task;
    }
        transportService.registerRequestHandler(
        return newResponse(request, totalShards, successfulShards, failedShards, broadcastByNodeResponses, exceptions, clusterState);
    /**
                    exceptions.add(new DefaultShardOperationFailedException(shard.getIndexName(), shard.getId(), exception));
            }
            this.request = request;
    implements
    ) {
            for (ShardOperationResult result : results) {
         * listener so {@code remaining} still reaches zero and the node response is sent.
            out.writeString(nodeId);
                for (ShardRouting shard : nodes.get(exception.nodeId())) {
        boolean canTripCircuitBreaker
                    threadPool.executor(asyncPool).execute(() -> {
                transportService.sendRequest(
                        );
        new AsyncAction(task, request, listener).start();
            return indicesLevelRequest.indicesOptions();
                    // on the same (notifyOnce-wrapped) listener so the remaining counter still reaches
            } catch (Exception e) {
    public TransportBroadcastByNodeAction(
            nodeOperation(results, accumulatedExceptions);
import org.opensearch.action.FailedNodeException;
                }
 * software distributed under the License is distributed on an
                            new ParameterizedMessage(
 *
                final int shardIndex = idx++;
            executor,
            }
import org.opensearch.cluster.node.DiscoveryNodes;
     * @param shardRouting the shard on which to execute the operation
        public void writeTo(StreamOutput out) throws IOException {
                    public void onResponse(ShardOperationResult result) {
     */
        String actionName,
            final ShardRouting shardRouting
                                throwable.getShardId().getIndexName(),
    /**
                throw globalBlockException;
            return nodeId;
    protected abstract ShardsIterator shards(ClusterState clusterState, Request request, String[] concreteIndices);
            }
            for (final ShardRouting shardRouting : shards) {
     * @param failedShards     the total number of shards for which execution of the operation failed
    private final ClusterService clusterService;
            indicesLevelRequest = readRequestFrom(in);
        }
import org.opensearch.transport.TransportResponseHandler;
                try {
            final int totalShards = shards.size();
                shardResults[shardIndex] = result;
     * @param request         the underlying request
     *
import java.util.concurrent.atomic.AtomicReferenceArray;
 * GitHub history for details.
     * Async shard operation with ActionListener callback.
                                shardRouting.shortSummary()
    Response extends BroadcastResponse,
            out.writeString(nodeId);
 * this work for additional information regarding copyright
 * @param <Request>              the underlying client request
                if (counter.incrementAndGet() == responses.length()) {
        protected List<ShardOperationResult> results;
            return nodeId;
import java.util.concurrent.RejectedExecutionException;
                int nodeIndex = -1;
                        public String executor() {
        private void sendNodeResponse(
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    ShardOperationResult extends Writeable> extends HandledTransportAction<Request, Response>
            final NodeRequest request,
        public String getNodeId() {
     */
                    transportRequestOptions,
                    );
    /**
        NodeResponse(StreamInput in) throws IOException {
 * (BroadcastByNodeResponse) to the coordinating node. These per-node results are aggregated into a single result (Result)
     * never fall through to the sync path.
            int idx = 0;
                    listener.onResponse(response);
        return ResolvedIndices.of(resolveConcreteIndices(clusterService.state(), request));
                        @Override
            }
                            shardListener.onFailure(inner);
            int totalShards,
                                "[{}] failed to execute operation for shard [{}]",
    /**
     */
                            shard.shardId(),
     * transport response is sent only after all shards complete (via CountDownLatch).
                            return ThreadPool.Names.SAME;
                            e
                // send a request to the shard only if it is assigned to a node that is in the local node's cluster state
 * result (ShardOperationResult), these per-node shard-level results are aggregated into a single result
                }
        private final Request request;
            this.nodeId = nodeId;
     *
                        new NoShardAvailableActionException(
                        }
     *
            out.writeVInt(results.size());
            } else {
                try {
        private final AtomicReferenceArray<Object> responses;
     * Resolves a list of concrete index names. Override this if index names should be resolved differently than normal.
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (logger.isTraceEnabled()) {
            final String asyncPool = asyncShardOperationThreadPool();
     * override this method with their non-blocking implementation.
        int failedShards,
                    shardListener.onFailure(rejection);
                }
import org.opensearch.action.support.TransportActions;
         * {@link ActionListener#notifyOnce} so a shard implementation that completes more than once
     * @param accumulatedExceptions List of any exceptions thrown by the shard-level operations.
                    }
    ) {
/**
                        }
            AtomicInteger remaining
        @Override
        protected List<BroadcastShardOperationFailedException> exceptions;
                    onCompletion();
     * the thread pool thread that received the transport request.
            out.writeVInt(totalShards);
                }
    protected abstract Request readRequestFrom(StreamInput in) throws IOException;
    protected void nodeOperation(List<ShardOperationResult> results, List<BroadcastShardOperationFailedException> accumulatedExceptions) {}
    }
        for (int i = 0; i < responses.length(); i++) {
            String nodeId,
/*
            this.results = results;
            ClusterBlockException globalBlockException = checkGlobalBlock(clusterState, request);
                } else {
        private final Map<String, List<ShardRouting>> nodeIds;
            }
            } else {
                    @Override
import org.opensearch.cluster.block.ClusterBlockException;
            int totalShards,
            return indicesLevelRequest.indices();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.ShardRouting;
                            ),
                        logger.trace(
     * Broadcast by a node's transport request handler
                            " no shards available for shard " + shard.toString() + " while executing " + actionName
            this.task = task;
        Writeable.Reader<Request> request,
     * This method reads ShardRouting from input stream
                } else {
     *
            final int shardIndex,
     */
                }
    /**
            if (isAsyncShardOperation()) {
import org.opensearch.core.transport.TransportResponse;
                    listener.onFailure(e);
 * not use this file except in compliance with the License.
        ActionFilters actionFilters,
     * @param request      the node-level request
        List<DefaultShardOperationFailedException> shardFailures,
        protected int totalShards;
                        onShardOperationComplete(request, channel, totalShards, shardResultOrExceptions, remaining);
import org.opensearch.transport.NodeShouldNotConnectException;
                }
import org.opensearch.action.support.ActionFilters;
    /**
     * which there is no shard-level return value.
 * this file be licensed under the Apache-2.0 license or a
        private EmptyResult(StreamInput in) {}
            List<BroadcastShardOperationFailedException> accumulatedExceptions = new ArrayList<>();
        }
        private final ClusterState clusterState;
        int failedShards = exceptions.size();
            // this is defensive to protect against the possibility of double invocation
                for (BroadcastShardOperationFailedException throwable : response.getExceptions()) {
    private final TransportService transportService;
import java.io.IOException;
        String executor,
                response = newResponse(request, responses, unavailableShardExceptions, nodeIds, clusterState);
    Request extends BroadcastRequest<Request>,
        }
                    if (!nodeIds.containsKey(nodeId)) {
                        public void handleException(TransportException exp) {
    /**
                            // this safe even if the impl partially completed the listener before throwing.
     * @return the result of the shard-level operation for the shard
                try {
         */
            this.nodeId = nodeId;
            } else {
     * @opensearch.internal
                    shardRouting.shardId(),
            return shards;
                        e
            "shardOperationAsync must be overridden by subclasses that return isAsyncShardOperation()=true"
            for (int i = 0; i < totalShards; i++) {
            } else {
                        onShardOperationComplete(request, channel, totalShards, shardResultOrExceptions, remaining);
    private Response newResponse(
            // the current implementation of TransportService#sendRequest guards against this
    class BroadcastByNodeTransportRequestHandler implements TransportRequestHandler<NodeRequest> {
         * Dispatches each shard's {@link #shardOperationAsync} as its own task on
            if (nodeIds.size() == 0) {
 *
            try {
                    sendNodeRequest(node, entry.getValue(), nodeIndex);
                    shardIndex++;
            Object[] shardResultOrExceptions
     * Executes a global request-level check before polling the cluster state.
        public int getSuccessfulShards() {
        public int getTotalShards() {
                // a scenario in which a shard can be assigned but to a node that is not in the local node's cluster state
                logger.debug("failed to combine responses from nodes", e);
                if (request != null && request.timeout() != null) {
                    e
     *
        AtomicReferenceArray responses,
            final NodeRequest request,
                            // shardOperationAsync threw synchronously on the pool worker (e.g. an
            TransportChannel channel,
        Request request,
                onNodeFailure(node, nodeIndex, e);
     * @param concreteIndices the concrete indices on which to execute the operation
    class NodeResponse extends TransportResponse {
            }
                TransportRequestOptions transportRequestOptions = TransportRequestOptions.EMPTY;
    }
import org.opensearch.core.action.ActionListener;
        }
                    listener.onFailure(e);
                successfulShards += response.getSuccessfulShards();
            nodes = clusterState.nodes();
                            e
        private final Task task;
            this.totalShards = totalShards;
     * Subclasses that opt into async execution (via {@link #isAsyncShardOperation()}) MUST
            ShardsIterator shardIt = shards(clusterState, request, concreteIndices);
                }
     * Executes a node-level operation. This method is called one time per node, after all shard-level operations have completed.
        TransportIndicesResolvingAction<Request> {
            if (globalBlockException != null) {
                    }
        }
     * Default is false (synchronous, sequential execution) for backwards compatibility.
     * Asynchronous action
            String nodeId = node.getId();
        @Override
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
     *
                    accumulatedExceptions.add((BroadcastShardOperationFailedException) shardResultOrExceptions[i]);
                    nodeIds.get(nodeId).add(shard);
     * @opensearch.internal
            if (responses.compareAndSet(nodeIndex, null, new FailedNodeException(nodeId, "Failed node [" + nodeId + "]", t))) {
                        }
    /**
     *
        TransportService transportService,
                for (Map.Entry<String, List<ShardRouting>> entry : nodeIds.entrySet()) {
                    }
                ShardOperationResult result = shardOperation(request.indicesLevelRequest, shardRouting);
            }
