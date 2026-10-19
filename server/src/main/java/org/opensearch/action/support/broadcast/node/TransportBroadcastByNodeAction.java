     */  
        List<DefaultShardOperationFailedException> exceptions = new ArrayList<>();
     * This method reads ShardRouting from input stream
            new BroadcastByNodeTransportRequestHandler()
         * does not serialize the others on the single node-handler thread. The listener is wrapped in  
        }
                    onCompletion();
                    }
     * Determines the shards on which this operation will be executed on. The operation is executed once per shard.
     * Returns the thread pool name to use when dispatching async shard operations on the data node.  
/*  
            nodeId = in.readString();  
            } catch (Exception e) {
            out.writeVInt(totalShards);  
 * GitHub history for details.
        String actionName,
                }  
            TransportChannel channel,  
     *
        super(actionName, canTripCircuitBreaker, transportService, actionFilters, request);
        public NodeRequest(StreamInput in) throws IOException {
        /**  
        String actionName,
                }  
 * The OpenSearch Contributors require contributions made to  
                            // would only get a response after its transport timeout. notifyOnce keeps
                            e
        public void start() {
                    }
    @Override
        }
     * Returns true if shard operations should execute asynchronously on the data node.  
                    );  
/**
                            onNodeFailure(node, nodeIndex, exp);
        private final DiscoveryNodes nodes;
import org.opensearch.cluster.service.ClusterService;
     *
        return ResolvedIndices.of(resolveConcreteIndices(clusterService.state(), request));  
import java.util.concurrent.atomic.AtomicReferenceArray;
     * Executes a global block check before polling the cluster state.  
    class BroadcastByNodeTransportRequestHandler implements TransportRequestHandler<NodeRequest> {  
    private final TransportService transportService;
                    nodeIds.get(nodeId).add(shard);
                    if (!nodeIds.containsKey(nodeId)) {
                    DiscoveryNode node = nodes.get(entry.getKey());  
            } else {  
            if (nodeIds.size() == 0) {
     */
import org.opensearch.transport.TransportResponseHandler;
import org.opensearch.cluster.metadata.ResolvedIndices;
        protected AsyncAction(Task task, Request request, ActionListener<Response> listener) {
            NodeRequest request,
            for (int i = 0; i < totalShards; i++) {
        IndexNameExpressionResolver indexNameExpressionResolver,  
            try {
import org.opensearch.action.FailedNodeException;
        private final AtomicInteger counter = new AtomicInteger();
        protected int totalShards;
        protected String nodeId;  
        private String nodeId;
            // this is defensive to protect against the possibility of double invocation  
                TransportRequestOptions transportRequestOptions = TransportRequestOptions.EMPTY;  
                        e  
                                actionName,
                            )  
                }  
                    shardRouting.shardId(),
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param concreteIndices the concrete indices on which to execute the operation
                        public void handleResponse(NodeResponse response) {
}
            canTripCircuitBreaker,  
import org.opensearch.action.IndicesRequest;  
    }
                }
        }  
                BroadcastShardOperationFailedException failure = new BroadcastShardOperationFailedException(  
import org.apache.logging.log4j.message.ParameterizedMessage;
                totalShards += response.getTotalShards();  
    }  
            out.writeString(nodeId);
            this.shards = shards;
        private final ClusterState clusterState;  
                broadcastByNodeResponses.addAll(response.results);
        ) throws IOException {
                // send a request to the shard only if it is assigned to a node that is in the local node's cluster state  
                for (final ShardRouting shardRouting : shards) {
        }  
                sendNodeResponse(request, channel, totalShards, shardResultOrExceptions);
        ) {  
        new AsyncAction(task, request, listener).start();
        @Override
    }
            ShardsIterator shardIt = shards(clusterState, request, concreteIndices);
 * Licensed to Elasticsearch under one or more contributor  
            if (responses.compareAndSet(nodeIndex, null, new FailedNodeException(nodeId, "Failed node [" + nodeId + "]", t))) {  
     * When true, each shard operation is submitted to the thread pool in parallel and the
                    shardListener.onFailure(rejection);
        }  
                for (BroadcastShardOperationFailedException throwable : response.getExceptions()) {
                        public void handleException(TransportException exp) {  
 * and executing the shard-level operations serially on the receiving node. Each shard-level operation can produce a  
            String nodeId = node.getId();
            String[] concreteIndices = resolveConcreteIndices(clusterState, request).namesOfConcreteIndicesAsArray();
     * <p>
     * @param state   the cluster state
     * transport response is sent only after all shards complete (via CountDownLatch).
import org.opensearch.tasks.Task;
     * A node request  
            return totalShards;
 * (BroadcastByNodeResponse) to the coordinating node. These per-node results are aggregated into a single result (Result)
         * listener so {@code remaining} still reaches zero and the node response is sent.
            if (logger.isTraceEnabled()) {
                );
            this.indicesLevelRequest = request;
        public int getSuccessfulShards() {
     * @param clusterState the cluster state  
                            // shardOperationAsync threw synchronously on the pool worker (e.g. an  
                        failure.setShard(shardRouting.shardId());
 *
import org.opensearch.core.action.ActionListener;
            }
     * @param clusterState     the cluster state
     * @return a de-serialized request  
        private void onAsyncShardOperation(  
        Map<String, List<ShardRouting>> nodes,
                if (TransportActions.isShardNotAvailableException(e)) {
                    if (logger.isDebugEnabled()) {
        List<ShardOperationResult> broadcastByNodeResponses = new ArrayList<>();  
                    });
 * license agreements. See the NOTICE file distributed with
     */
            }
            final String asyncPool = asyncShardOperationThreadPool();
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
     */
    protected boolean isAsyncShardOperation() {
import java.util.concurrent.RejectedExecutionException;  
        String executor
                        @Override
        String executor,
        }
        public List<ShardRouting> getShards() {  
                                "[{}] failed to execute operation for shard [{}]",
                onAsyncShardOperation(request, channel, shards, totalShards, shardResultOrExceptions);  
        Request request,
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
import java.util.ArrayList;
            NodeRequest::new,
            false,
     * @opensearch.internal  
import org.opensearch.cluster.routing.ShardRouting;
                final int shardIndex = idx++;
            out.writeList(shards);
 *
            }
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
import org.opensearch.transport.TransportService;
        public String getNodeId() {
import org.opensearch.cluster.ClusterState;
                    transportNodeBroadcastAction,  
import org.opensearch.core.transport.TransportResponse;
import org.opensearch.core.common.io.stream.StreamInput;
                totalShards += nodes.get(exception.nodeId()).size();
    protected String asyncShardOperationThreadPool() {
 * You may obtain a copy of the License at  
            "shardOperationAsync must be overridden by subclasses that return isAsyncShardOperation()=true"
                } else {  
                }
 * not use this file except in compliance with the License.
                FailedNodeException exception = (FailedNodeException) responses.get(i);
            if (logger.isTraceEnabled()) {
        ClusterService clusterService,  
        }
            int totalShards,
                    exceptions.add(new DefaultShardOperationFailedException(shard.getIndexName(), shard.getId(), exception));
     * Default is false (synchronous, sequential execution) for backwards compatibility.  
            } catch (Exception e) {
 * software distributed under the License is distributed on an
        TransportService transportService,
                if (shard.assignedToNode() && nodes.get(shard.currentNodeId()) != null) {  
        }
                                "[{}] failed to execute operation for shard [{}]",
                        exceptions.add(
     */  
import org.opensearch.action.NoShardAvailableActionException;
            out.writeBoolean(exceptions != null);
                NodeRequest nodeRequest = new NodeRequest(node.getId(), request, shards);
    public class NodeRequest extends TransportRequest implements IndicesRequest {
     * @param shardRouting the shard on which to execute the operation  
        AtomicReferenceArray responses,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    protected abstract Request readRequestFrom(StreamInput in) throws IOException;
                if (counter.incrementAndGet() == responses.length()) {
        List<DefaultShardOperationFailedException> shardFailures,
     */
    ) {  
public abstract class TransportBroadcastByNodeAction<
        public void messageReceived(final NodeRequest request, TransportChannel channel, Task task) throws Exception {
 * this work for additional information regarding copyright
            if (isAsyncShardOperation()) {
                if (counter.incrementAndGet() == responses.length()) {  
        private EmptyResult() {}  
            nodeId = in.readString();
        List<NoShardAvailableActionException> unavailableShardExceptions,  
            final int shardIndex,
        ) {
            try {  
         * {@link #asyncShardOperationThreadPool()} so a slow/blocking shard prefix (e.g. a permit wait)
        public IndicesOptions indicesOptions() {
            AtomicInteger remaining  
     * Creates a new response to the underlying request.
        }
import java.io.IOException;
     *
            nodeIds = new HashMap<>();  
            return exceptions;  
        }  
        int successfulShards,
                    String nodeId = shard.currentNodeId();
            TransportChannel channel,
     */  
        ClusterState clusterState
 */
        Request request,
 * @param <ShardOperationResult> per-shard operation results
     * Subclasses that opt into async execution (via {@link #isAsyncShardOperation()}) MUST  
                logger.debug("failed to combine responses from nodes", e);  
    protected abstract ShardsIterator shards(ClusterState clusterState, Request request, String[] concreteIndices);
                        }
        }
    public OptionallyResolvedIndices resolveIndices(Request request) {
    }  
import org.opensearch.cluster.node.DiscoveryNode;  
        public void writeTo(StreamOutput out) throws IOException {
                        @Override
                listener.onFailure(e);
    /**
    /**
     * @param successfulShards the total number of shards for which execution of the operation was successful  
        TransportIndicesResolvingAction<Request> {
    private final IndexNameExpressionResolver indexNameExpressionResolver;
    }
                if (logger.isTraceEnabled()) {  
                    transportRequestOptions,
        public void writeTo(StreamOutput out) {}
 * @param <Request>              the underlying client request
        }
                        shardResultOrExceptions[shardIndex] = failure;  
     *
        this(actionName, clusterService, transportService, actionFilters, indexNameExpressionResolver, request, executor, true);
            Object[] shardResultOrExceptions  
import org.opensearch.action.support.TransportIndicesResolvingAction;  
            }
            final ShardRouting shardRouting  
                ShardOperationResult result = shardOperation(request.indicesLevelRequest, shardRouting);  
        private final AtomicReferenceArray<Object> responses;  
import java.util.List;
        );  
     * Deserialize a request from an input stream  
                            return new NodeResponse(in);  
                    }
                    accumulatedExceptions.add((BroadcastShardOperationFailedException) shardResultOrExceptions[i]);  
     * @return a list of concrete indices that this action should operate on
                logger.debug(new ParameterizedMessage("failed to execute [{}] on node [{}]", actionName, nodeId), t);  
                            e  
            List<ShardRouting> shards,  
                        "rejected by thread pool [" + asyncPool + "] for shard " + shardRouting.shardId(),
            if (in.readBoolean()) {
                int shardIndex = -1;  
                        @Override  
     * @param request the underlying request  
    /**
                    node,
                    e  
            return shards;
                        new NoShardAvailableActionException(
        return false;
        }  
     * @return the thread pool name for async per-shard execution
         */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else {  
     * @opensearch.internal  
            out.writeVInt(results.size());
                        public NodeResponse read(StreamInput in) throws IOException {
        NodeResponse(
            }  
     * Asynchronous action
                // routing table as such
                logger.trace("resolving shards for [{}] based on cluster state version [{}]", actionName, clusterState.version());  
 */  
            if (responses.compareAndSet(nodeIndex, null, response)) {
                        onShardOperationComplete(request, channel, totalShards, shardResultOrExceptions, remaining);
        protected void onNodeResponse(DiscoveryNode node, int nodeIndex, NodeResponse response) {  
        private final ActionListener<Response> listener;
            this.nodeId = nodeId;  
                int nodeIndex = -1;  
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
     * @param shardRouting the shard on which to execute the operation
        );  
/*  
    /**  
import org.opensearch.action.support.broadcast.BroadcastRequest;
                            e  
import org.opensearch.transport.TransportRequestHandler;
import org.opensearch.action.support.IndicesOptions;
     *  
 * the Apache License, Version 2.0 (the "License"); you may
 * @param <Response>             the response to the client request  
        @Override  
        private List<NoShardAvailableActionException> unavailableShardExceptions = new ArrayList<>();
    protected abstract ClusterBlockException checkRequestBlock(ClusterState state, Request request, String[] concreteIndices);
     * @param in input stream
                    );
            TransportChannel channel,
                        @Override
 */  
import org.opensearch.action.support.ActionFilters;
                logger.trace("[{}] executing operation on [{}] shards", actionName, totalShards);  
    @Override
     * @param in input stream
         * {@link ActionListener#notifyOnce} so a shard implementation that completes more than once
            }
import org.opensearch.cluster.block.ClusterBlockException;
                } catch (IOException e) {
                                throwable.getShardId().getId(),
                            // this safe even if the impl partially completed the listener before throwing.
            return nodeId;  
import org.opensearch.transport.TransportRequestOptions;  
            List<ShardOperationResult> results = new ArrayList<>();  
                        logger.debug(
                            shard.shardId(),  
            String nodeId,  
    public static final class EmptyResult implements Writeable {  
                    onCompletion();
                transportService.sendRequest(
                if (task != null) {  
            }
    /**
        return in.readList(ShardRouting::new);
     * @param concreteIndices the concrete indices on which to execute the operation
        public static EmptyResult readEmptyResultFrom(StreamInput in) {
                    listener.onFailure(e);
     * Executes the shard-level operation. This method is called once per shard serially on the receiving node.
            Response response = null;
     *
     *
        private final Request request;
     */
                    transportRequestOptions = TransportRequestOptions.builder().withTimeout(request.timeout()).build();
                }
                    }
                exceptions = in.readList(BroadcastShardOperationFailedException::new);
     * Async shard operation with ActionListener callback.
        private List<ShardRouting> shards;
            ClusterBlockException requestBlockException = checkRequestBlock(clusterState, request, concreteIndices);  
                        );  
            } else {
                logger.trace("[{}] executing async operation on [{}] shards", actionName, totalShards);
        return newResponse(request, totalShards, successfulShards, failedShards, broadcastByNodeResponses, exceptions, clusterState);
                }
            out.writeString(nodeId);
import java.util.concurrent.atomic.AtomicInteger;
     * Resolves a list of concrete index names. Override this if index names should be resolved differently than normal.
    /**
     * @param request          the underlying request
                    onShardOperation(request, shardResultOrExceptions, shardIndex, shardRouting);  
                }
            // but concurrency is hard, safety is important, and the small performance loss here does not matter
     * which there is no shard-level return value.
     * @return the response
            final NodeRequest request,  
                    public void onResponse(ShardOperationResult result) {
    /**
     * @return the result of the shard-level operation for the shard  
        this.transportService = transportService;
                    nodeIndex++;
            indicesLevelRequest.writeTo(out);  
                            shardListener.onFailure(inner);  
                if (request != null && request.timeout() != null) {
            }  
import org.opensearch.transport.TransportException;  
                // is when the shard is assigned to the cluster-manager node, the local node has detected the cluster-manager as failed
        ) {
    /**
package org.opensearch.action.support.broadcast.node;
        public String[] indices() {  
            results = in.readList((stream) -> stream.readBoolean() ? readShardResult(stream) : null);  
    /**
        ) {
                                throwable
                        BroadcastShardOperationFailedException failure = new BroadcastShardOperationFailedException(  
            if (requestBlockException != null) {
    ) {  
        ClusterState clusterState
                );  
     * @opensearch.internal
        ActionFilters actionFilters,
        this.clusterService = clusterService;
    public TransportBroadcastByNodeAction(
            if (logger.isTraceEnabled()) {
/*
 * KIND, either express or implied.  See the License for the
                failure.setShard(shardRouting.shardId());
            if (response != null) {  
     *
            this.request = request;  
        protected List<BroadcastShardOperationFailedException> exceptions;
            }  
     * @param listener     callback to invoke with the result or failure
import org.opensearch.transport.TransportChannel;
            if (responses.get(i) instanceof FailedNodeException) {  
            List<ShardOperationResult> results,
                    nodeRequest,
            super(in);  
    }
        int totalShards,  
     *
import org.opensearch.action.support.TransportActions;
            }
import org.opensearch.action.support.broadcast.BroadcastResponse;
            nodeOperation(results, accumulatedExceptions);  
     */  
                            new DefaultShardOperationFailedException(
        protected void onCompletion() {
     */  
            final NodeRequest request,
        int failedShards = exceptions.size();
                        shardResultOrExceptions[shardIndex] = result;  
    public TransportBroadcastByNodeAction(
        private final Map<String, List<ShardRouting>> nodeIds;
     * Executes a global request-level check before polling the cluster state.  
            final Object[] shardResults,
                try {  
    /**  
                ActionListener<ShardOperationResult> shardListener = ActionListener.notifyOnce(new ActionListener<ShardOperationResult>() {  
        public String getNodeId() {
     * Deserialize a shard-level result from an input stream  
                    RejectedExecutionException rejection = new RejectedExecutionException(
     * the thread pool thread that received the transport request.
                for (ShardRouting shard : nodes.get(exception.nodeId())) {  
     * Broadcast by a node's transport request handler
 * Modifications Copyright OpenSearch Contributors. See
     * @param results          the per-node aggregated shard-level results
                }
        public void writeTo(StreamOutput out) throws IOException {
    /**  
     * @param results List of results from the completed shard-level operations.  
            clusterState = clusterService.state();  
 */
        @Override  
            if (globalBlockException != null) {
            final AtomicInteger remaining = new AtomicInteger(totalShards);
            }
        }  
    }
            return INSTANCE;
     * @opensearch.internal
     * A node response
                        try {  
     *
            int totalShards,
     * override this method with their non-blocking implementation.
            }  
                                shardRouting.shortSummary()  
                }
                if (shardResultOrExceptions[i] instanceof BroadcastShardOperationFailedException) {
     *  
        }
            super(in);  
                onNodeFailure(node, nodeIndex, e);
     * @return a deserialized shard-level result  
 * ownership. Elasticsearch licenses this file to you under  
     */
                    @Override
            }
                            // would never fire, `remaining` would never decrement, and the coordinator  
                            ),
     * never fall through to the sync path.  
            for (ShardOperationResult result : results) {
        List<ShardOperationResult> results,  
     * @param state           the cluster state
    protected abstract ShardOperationResult shardOperation(Request request, ShardRouting shardRouting) throws IOException;
    /**  
                    "operation " + actionName + " failed",
                }
                } else {  
     */  
        }
     * The default throws {@link UnsupportedOperationException} — async subclasses should
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;  
                exceptions = null;
                shardResults[shardIndex] = result;
                                shardRouting.shortSummary()
            } catch (Exception e) {
            this.nodeId = nodeId;
 * @opensearch.internal  
    }
                            "operation " + actionName + " failed",
                    @Override
            super.writeTo(out);
    private final ThreadPool threadPool;  
     * @return a non-null exception if the operation if blocked
    /**
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
 *
    }
                }
    protected void nodeOperation(List<ShardOperationResult> results, List<BroadcastShardOperationFailedException> accumulatedExceptions) {}  
                    }
                    sendNodeRequest(node, entry.getValue(), nodeIndex);
 *
                // a scenario in which a shard can be assigned but to a node that is not in the local node's cluster state
                out.writeOptionalWriteable(result);  
     * @param request         the underlying request
            this.exceptions = exceptions;
            }
        }
            }
            if (logger.isDebugEnabled() && !(t instanceof NodeShouldNotConnectException)) {
                    new TransportResponseHandler<NodeResponse>() {  
     * Can be used for implementations of {@link #shardOperation(BroadcastRequest, ShardRouting) shardOperation} for
     * @return a non-null exception if the operation is blocked
        public NodeRequest(String nodeId, Request request, List<ShardRouting> shards) {  
         * Dispatches each shard's {@link #shardOperationAsync} as its own task on
        }
                }  
            return indicesLevelRequest.indicesOptions();  
        public int getTotalShards() {  
         * If the pool rejects a per-shard dispatch, that shard is recorded as a failure via the same  
                    onCompletion();
        protected Request indicesLevelRequest;  
     * @param request      the node-level request
                }  
                    results.add((ShardOperationResult) shardResultOrExceptions[i]);
    /**  
        public List<BroadcastShardOperationFailedException> getExceptions() {
     */
import org.opensearch.core.common.io.stream.Writeable;  
        TransportService transportService,
                    logger.warn("[{}] failed to send response after async shard operations", actionName);  
import java.util.Map;
     * @opensearch.internal
    );  
            this.listener = listener;
            nodes = clusterState.nodes();
            shards = getShardRoutingsFromInputStream(in);
        private void onShardOperationComplete(
            totalShards = in.readVInt();
    /**
                    public void onFailure(Exception e) {
            // the current implementation of TransportService#sendRequest guards against this
        boolean canTripCircuitBreaker  
import org.opensearch.cluster.node.DiscoveryNodes;
            executor,
    Response extends BroadcastResponse,
    class NodeResponse extends TransportResponse {
 * this file be licensed under the Apache-2.0 license or a
                NodeResponse response = (NodeResponse) responses.get(i);
                shardResults[shardIndex] = failure;  
            channel.sendResponse(new NodeResponse(request.getNodeId(), totalShards, results, accumulatedExceptions));
                throw requestBlockException;
        this.threadPool = transportService.getThreadPool();
 * specific language governing permissions and limitations
     * @param request         the underlying request  
    }  
                }
 * to the client.  
            if (remaining.decrementAndGet() == 0) {
import java.util.HashMap;  
                        );
            ClusterBlockException globalBlockException = checkGlobalBlock(clusterState, request);  
                    threadPool.executor(asyncPool).execute(() -> {
            this.task = task;
    implements  
    ShardOperationResult extends Writeable> extends HandledTransportAction<Request, Response>
import org.opensearch.transport.NodeShouldNotConnectException;
     * @param totalShards      the total number of shards considered for execution of the operation
                        logger.trace(  
    private Response newResponse(  
     *  
    final String transportNodeBroadcastAction;
            List<BroadcastShardOperationFailedException> accumulatedExceptions = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
                        }
                    if (!TransportActions.isShardNotAvailableException(throwable)) {  
                // cluster-manager node from the local cluster state, but the shards assigned to the cluster-manager will still be in the
        ActionFilters actionFilters,
            this.results = results;
    protected abstract Response newResponse(
import org.opensearch.transport.TransportRequest;
            for (ShardRouting shard : shardIt) {
     */
        }
    /**
        @Override
    protected void shardOperationAsync(Request request, ShardRouting shardRouting, ActionListener<ShardOperationResult> listener) {  
        NodeResponse(StreamInput in) throws IOException {
        }  
     *
                throw globalBlockException;
                    shardIndex++;
                    }
                        );
                        public String executor() {
                        )
                            // IndexNotFoundException raced index deletion). Without this, the throw
     * This prevents long-running shard operations (e.g., flush + remote sync) from blocking  
                        }
                } else {
            }  
                    listener.onFailure(e);  
            final Object[] shardResultOrExceptions = new Object[totalShards];
    public List<ShardRouting> getShardRoutingsFromInputStream(StreamInput in) throws IOException {
            List<BroadcastShardOperationFailedException> exceptions  
 * compatible open source license.
 * result (ShardOperationResult), these per-node shard-level results are aggregated into a single result
        transportNodeBroadcastAction = actionName + "[n]";  
                } catch (Exception e) {  
                try {  
     * behind each other on a bounded executor. Override to redirect to a dedicated pool if needed.  
            return results.size();
            } else {
 *  
                            return ThreadPool.Names.SAME;  
                }
            try {
import org.opensearch.action.support.HandledTransportAction;  
     * @param request      the indices-level request
        }
            return indicesLevelRequest.indices();
     * @param failedShards     the total number of shards for which execution of the operation failed
                    logger.trace("[{}]  completed operation for shard [{}]", actionName, shardRouting.shortSummary());  
    }
                    nodeRequest.setParentTask(clusterService.localNode().getId(), task.getId());
        private void sendNodeResponse(
                        );
     * Only consulted when {@link #isAsyncShardOperation()} is true.
import org.opensearch.cluster.routing.ShardsIterator;  
                }
    protected abstract ClusterBlockException checkGlobalBlock(ClusterState state, Request request);  
        int successfulShards = 0;
        transportService.registerRequestHandler(
     * Default is {@link ThreadPool.Names#GENERIC} — a scaling pool, so per-shard tasks do not queue
     */
            final int totalShards = shards.size();
     * @return true if shard operations should be dispatched asynchronously
     * @param accumulatedExceptions List of any exceptions thrown by the shard-level operations.
        private EmptyResult(StreamInput in) {}
        private void sendNodeRequest(final DiscoveryNode node, List<ShardRouting> shards, final int nodeIndex) {  
    }  
    }
            for (final ShardRouting shardRouting : shards) {
                out.writeList(exceptions);
                } catch (Exception e) {
        totalShards += unavailableShardExceptions.size();  
     * Executes a node-level operation. This method is called one time per node, after all shard-level operations have completed.
            transportNodeBroadcastAction,  
            }  
     */
        throw new UnsupportedOperationException(
        }
        @Override
                try {
                            ),
            final NodeRequest request,  
     */  
        }  
            List<ShardRouting> shards = request.getShards();  
 * Abstraction for transporting aggregated shard-level operations in a single request (NodeRequest) per-node
 * SPDX-License-Identifier: Apache-2.0
            indicesLevelRequest = readRequestFrom(in);
            // the current implementation of TransportService#sendRequest guards against this  
            }
            Object[] shardResultOrExceptions,
     *
            }  
                // Sync mode: original sequential execution (backwards compatible)
                                throwable.getShardId().getIndexName(),  
    protected ResolvedIndices.Local.Concrete resolveConcreteIndices(ClusterState clusterState, Request request) {
            int totalShards,
                for (Map.Entry<String, List<ShardRouting>> entry : nodeIds.entrySet()) {
        int failedShards,
        int totalShards = 0;
     * @return the shards on which to execute the operation  
        }
            Object[] shardResultOrExceptions
                    }
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {  
                        }
            }  
                            // would escape onto the pool's uncaught-exception handler — the listener
                });  
         * (e.g. a racing drain-callback and timeout) still counts as exactly one shard.
    protected abstract ShardOperationResult readShardResult(StreamInput in) throws IOException;
     * @param clusterState    the cluster state  
                successfulShards += response.getSuccessfulShards();
        Writeable.Reader<Request> request,
                // and a new cluster-manager has not yet been elected; in this situation the local node will have removed the  
            }  
        @Override
        return ThreadPool.Names.GENERIC;
        public static EmptyResult INSTANCE = new EmptyResult();
                    // zero and the node response is sent.  
                    // Pool rejected at dispatch time (shutdown / saturated) — record as a shard failure
     */
 * under the License.  
        for (int i = 0; i < responses.length(); i++) {
                            " no shards available for shard " + shard.toString() + " while executing " + actionName
        private void onShardOperation(
                        onShardOperationComplete(request, channel, totalShards, shardResultOrExceptions, remaining);
     * @param shardFailures    the exceptions corresponding to shard operation failures  
    ) {
     *
                                actionName,  
                try {
    }
        }
            int idx = 0;  
            // this is defensive to protect against the possibility of double invocation
                    listener.onResponse(response);
            // but concurrency is hard, safety is important, and the small performance loss here does not matter
        Writeable.Reader<Request> request,
    private final ClusterService clusterService;  
        protected void onNodeFailure(DiscoveryNode node, int nodeIndex, Throwable t) {  
                            new ParameterizedMessage(
        }
                    if (logger.isTraceEnabled()) {
    Request extends BroadcastRequest<Request>,  
                if (logger.isTraceEnabled()) {
            }
                            shardRouting.shardId(),
            responses = new AtomicReferenceArray<>(nodeIds.size());
                        nodeIds.put(nodeId, new ArrayList<>());  
            if (exceptions != null) {  
    }  
                response = newResponse(request, responses, unavailableShardExceptions, nodeIds, clusterState);
                } catch (Exception e) {  
        private final Task task;  
            this.totalShards = totalShards;  
                    logger.trace("[{}]  executing operation for shard [{}]", actionName, shardRouting.shortSummary());
        ClusterService clusterService,  
                            shardOperationAsync(request.indicesLevelRequest, shardRouting, shardListener);
    /**
                        } catch (Exception inner) {
        }  
                        }  
                    sendNodeResponse(request, channel, totalShards, shardResultOrExceptions);
     *  
                    // on the same (notifyOnce-wrapped) listener so the remaining counter still reaches
        protected List<ShardOperationResult> results;  
    protected class AsyncAction {
            int totalShards,
import org.opensearch.threadpool.ThreadPool;  
                            onNodeResponse(node, nodeIndex, response);
                logger.trace("received response for [{}] from node [{}]", actionName, node.getId());
     * @param request the underlying request
                            new ParameterizedMessage(  
            return nodeId;
        IndexNameExpressionResolver indexNameExpressionResolver,  
                    unavailableShardExceptions.add(
