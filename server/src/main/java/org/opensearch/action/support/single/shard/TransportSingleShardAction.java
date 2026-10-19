    }
     */
                            onFailure(finalShardRouting, exp);
        threadPool.executor(getExecutor(request, shardId)).execute(ActionRunnable.supply(listener, () -> shardOperation(request, shardId)));
            return request;
            this.concreteIndex = concreteIndex;
        this.clusterService = clusterService;
                logger.trace("executing [{}] on shard [{}]", request, request.internalShardId);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.transport.TransportResponseHandler;
            String concreteSingleIndex = resolveToConcreteSingleIndex(request, clusterState);
            ShardRouting shardRouting = FailAwareWeightedRouting.getInstance()
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
                        @Override
package org.opensearch.action.support.single.shard;
            return ResolvedIndices.of(indexNameExpressionResolver.concreteResolvedIndices(clusterService.state(), request));
            // resolveToConcreteSingleIndex(), but this is only a hypothetical state. In practise, we should
        private final InternalRequest internalRequest;
 * of candidate shards to try the read operation on.
                        }
    @Override
import org.opensearch.action.support.ChannelActionListener;
import org.opensearch.action.support.TransportIndicesResolvingAction;
import static org.opensearch.action.support.TransportActions.isShardNotAvailableException;
            // validation error when executing the action.
import java.io.IOException;
     * the operation locally (the node that received the request)
 * The OpenSearch Contributors require contributions made to
     * Internal request class that gets built on each node. Holds the original request plus additional info.
        public void messageReceived(final Request request, final TransportChannel channel, Task task) throws Exception {
        return state.blocks().globalBlockedException(ClusterBlockLevel.READ);
        }
            this.internalRequest = new InternalRequest(request, concreteSingleIndex);
            // Instead, we use indexNameExpressionResolver.concreteResolvedIndices(), which allows us to retrieve
                        LoggerMessageFormat.format("No shard available for [{}]", internalRequest.request()),
    }
     *
 * You may obtain a copy of the License at
                if (logger.isTraceEnabled()) {
                        }
                        @Override
        }
            if (shardRouting == null) {
            return concreteIndex;
     * will be called locally to its parent action.
            // We do not use resolveToConcreteSingleIndex() here because it might throw exceptions for validation errors.
import org.opensearch.cluster.node.DiscoveryNode;
        }
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.threadpool.ThreadPool;
            if (blockException != null) {
     * Returns the candidate shards to execute the operation on or <code>null</code> the execute
        }
        private volatile Exception lastFailure;
                    transportShardAction,
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.cluster.routing.ShardsIterator;
            resolveRequest(clusterState, internalRequest);
    private String resolveToConcreteSingleIndex(Request request, ClusterState clusterState) {
                    new TransportResponseHandler<Response>() {
    /**
            this.request = request;
                perform(null);
                }
            this.listener = listener;
import org.opensearch.transport.TransportService;
        if (resolveIndex(request)) {
            return ResolvedIndices.of(request.index());
     */
        }
     * @opensearch.internal
     * Shard level transport handler
                        public void handleResponse(final Response response) {
                return;
        final Request request;
/*
    private final String transportShardAction;
                        "sending request [{}] to shard [{}] on node [{}]",
        private void onFailure(ShardRouting shardRouting, Exception e) {
import org.opensearch.common.Nullable;
                    internalRequest.request(),
    protected void resolveRequest(ClusterState state, InternalRequest request) {
 * GitHub history for details.
                            return ThreadPool.Names.SAME;
                        internalRequest.request(),
            this.shardIt = shards(clusterState, internalRequest);
    protected abstract boolean resolveIndex(Request request);
    protected TransportSingleShardAction(
        private final DiscoveryNodes nodes;
 * not use this file except in compliance with the License.
            if (blockException != null) {
     * Internal transport handler
    /**
        @Override
 */
    }
     *
                ShardRouting finalShardRouting = shardRouting;
import org.opensearch.transport.TransportChannel;
        IndexNameExpressionResolver indexNameExpressionResolver,
 *
        public void messageReceived(Request request, final TransportChannel channel, Task task) throws Exception {
 * @opensearch.internal
                        }
    }
            ClusterBlockException blockException = checkGlobalBlock(clusterState);
                // just execute it on the local node
import org.opensearch.action.NoShardAvailableActionException;
            } else {
                        public void handleException(TransportException exp) {
                        public String executor() {
            }
    protected void asyncShardOperation(Request request, ShardId shardId, ActionListener<Response> listener) throws IOException {
    /**
import org.opensearch.cluster.block.ClusterBlockLevel;
    private class TransportHandler implements TransportRequestHandler<Request> {
    protected boolean isSubAction() {
import org.opensearch.cluster.ClusterState;
                    failure = new NoShardAvailableActionException(
                transportService.sendRequest(
    protected final IndexNameExpressionResolver indexNameExpressionResolver;
import org.opensearch.cluster.metadata.ResolvedIndices;
        }
        new AsyncSingleAction(request, listener).start();
            }
    protected final TransportService transportService;
}
        return state.blocks().indexBlockedException(ClusterBlockLevel.READ, request.concreteIndex());
                } else {
                    clusterService.localNode(),
                            listener.onResponse(response);
 * ownership. Elasticsearch licenses this file to you under
        this.transportShardAction = actionName + "[s]";
import org.opensearch.transport.TransportRequestHandler;
    protected abstract ShardsIterator shards(ClusterState state, InternalRequest request);
    /**
    public ResolvedIndices resolveIndices(Request request) {
import org.opensearch.core.action.ActionResponse;
    protected String getExecutor(Request request, ShardId shardId) {
                        @Override
        }
 */
    }
 * the read operation can be performed on other shard copies. Concrete implementations can provide their own list
                    new TransportResponseHandler<Response>() {
        }
     */
    implements
                    logger.debug(() -> new ParameterizedMessage("{}: failed to execute [{}]", null, internalRequest.request()), failure);
 * specific language governing permissions and limitations
        InternalRequest(Request request, String concreteIndex) {
    @Override
                        @Override
import org.opensearch.cluster.service.ClusterService;
            if (shardIt == null) {
    protected ClusterBlockException checkGlobalBlock(ClusterState state) {
                if (failure == null || isShardNotAvailableException(failure)) {
    private final String executor;
        String executor
                );
 * Licensed to Elasticsearch under one or more contributor
        public Request request() {
                throw blockException;
 * compatible open source license.
     * @opensearch.internal
        ActionFilters actionFilters,
    }
    }
        Writeable.Reader<Request> request,
        if (!isSubAction()) {
import org.opensearch.tasks.Task;
                    );
        transportService.registerRequestHandler(transportShardAction, ThreadPool.Names.SAME, request, new ShardTransportHandler());
     * the main transport handler. In fact if the action is a subaction, its execute method
                    node,
        return executor;
            if (e != null) {
                        node
                logger.trace(() -> new ParameterizedMessage("{}: failed to execute [{}]", shardRouting, internalRequest.request()), e);
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
                        }
    }
 *
                    transportShardAction,
        if (resolveIndex(request)) {
                        public void handleResponse(final Response response) {
            } else {
     * Tells whether the action is a main one or a subaction. Used to decide whether we need to register
    }
        } else {
                            listener.onResponse(response);
                        }
        TransportIndicesResolvingAction<Request> {
     */
        }
        }
 * Modifications Copyright OpenSearch Contributors. See
            DiscoveryNode node = nodes.get(shardRouting.currentNodeId());
     *
/*
        TransportService transportService,
    }
        private AsyncSingleAction(Request request, ActionListener<Response> listener) {
            return request.index();
        private final ActionListener<Response> listener;
                            return reader.read(in);
        return false;
    }
                        }
                Exception failure = lastFailure;
        String actionName,
    }
 * KIND, either express or implied.  See the License for the
        } else {
                onFailure(shardRouting, new NoShardAvailableActionException(shardRouting.shardId()));
                        @Override
        super(actionName, actionFilters, transportService.getTaskManager());
            execute(request, new ChannelActionListener<>(channel, actionName, request));
            blockException = checkRequestBlock(clusterState, internalRequest);
import org.opensearch.action.support.TransportActions;
                        public Response read(StreamInput in) throws IOException {
import org.opensearch.cluster.routing.FailAwareWeightedRouting;
            }
            transportService.registerRequestHandler(actionName, ThreadPool.Names.SAME, request, new TransportHandler());
        ThreadPool threadPool,
        @Override
    @Nullable
        public String concreteIndex() {
                logger.trace("executing [{}] based on cluster state version [{}]", request, clusterState.version());
import org.opensearch.transport.TransportException;
                        null,
                            listener.onFailure(exp);
import org.opensearch.action.ActionRunnable;
 * A base class for operations that need to perform a read operation on a single shard copy. If the operation fails,
    protected abstract Writeable.Reader<Response> getResponseReader();
        this.threadPool = threadPool;
                        @Override
    TransportAction<Request, Response>
 *
    protected class InternalRequest {
            // also always get one element here. If for some reason that's not the case, the code will hit the
     * @opensearch.internal
        public void start() {
                        public void handleException(TransportException exp) {
            return indexNameExpressionResolver.concreteSingleIndex(clusterState, request).getName();
                this.lastFailure = currentFailure;
            if (logger.isTraceEnabled()) {
        }
    protected final ThreadPool threadPool;
            ClusterState clusterState = clusterService.state();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.shard.ShardId;
                    );
import org.opensearch.core.common.logging.LoggerMessageFormat;
public abstract class TransportSingleShardAction<Request extends SingleShardRequest<Request>, Response extends ActionResponse> extends
    ) {
 * this file be licensed under the Apache-2.0 license or a
                        internalRequest.request().internalShardId,
        final String concreteIndex;
                        failure
import org.opensearch.core.common.io.stream.StreamInput;
            if (node == null) {
 * under the License.
                }
            }
            // if we have a local operation, execute it on a thread since we don't spawn
                        public Response read(StreamInput in) throws IOException {
import org.apache.logging.log4j.message.ParameterizedMessage;
 * this work for additional information regarding copyright
    protected final ClusterService clusterService;
                    internalRequest.request(),
            nodes = clusterState.nodes();
import org.opensearch.cluster.routing.ShardRouting;
                lastFailure = currentFailure;
                listener.onFailure(failure);
    class AsyncSingleAction {
            Exception lastFailure = this.lastFailure;
            perform(e);
    /**
                        @Override
 * the Apache License, Version 2.0 (the "License"); you may
            // index names without validation errors. This is potentially a super-set of the indices resolved in
    protected ClusterBlockException checkRequestBlock(ClusterState state, InternalRequest request) {
    private class ShardTransportHandler implements TransportRequestHandler<Request> {
     *
        this.transportService = transportService;
import org.opensearch.action.support.ActionFilters;
                            return ThreadPool.Names.SAME;
        private void perform(@Nullable final Exception currentFailure) {
        this.indexNameExpressionResolver = indexNameExpressionResolver;
                        }
import org.opensearch.core.action.ActionListener;
 * license agreements. See the NOTICE file distributed with
        this.executor = executor;
import org.opensearch.cluster.node.DiscoveryNodes;
            }
    /**
                    logger.trace(
 */
        ClusterService clusterService,
            }
                        @Override
 *
            if (lastFailure == null || TransportActions.isReadOverrideException(currentFailure)) {
 */
     * @opensearch.internal
        }
                        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                internalRequest.request().internalShardId = shardRouting.shardId();
        private final ShardsIterator shardIt;
     * Asynchronous single action
                final Writeable.Reader<Response> reader = getResponseReader();
                        public String executor() {
/**
    }
    protected abstract Response shardOperation(Request request, ShardId shardId) throws IOException;
                    }
                    }
                );
                throw blockException;
     */
                            return reader.read(in);
            if (logger.isTraceEnabled()) {
            asyncShardOperation(request, request.internalShardId, new ChannelActionListener<>(channel, transportShardAction, request));
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
                transportService.sendRequest(
            }
                final Writeable.Reader<Response> reader = getResponseReader();
            }
/*
                .findNext(shardIt, clusterService.state(), currentFailure, () -> {});
    }
     */
import org.opensearch.action.support.TransportAction;
