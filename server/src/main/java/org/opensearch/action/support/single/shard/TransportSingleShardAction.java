                    clusterService.localNode(),
    /**  
                onFailure(shardRouting, new NoShardAvailableActionException(shardRouting.shardId()));  
    protected String getExecutor(Request request, ShardId shardId) {
                    node,
import org.opensearch.action.ActionRunnable;
                listener.onFailure(failure);
    }
        super(actionName, actionFilters, transportService.getTaskManager());  
 * Unless required by applicable law or agreed to in writing,
    protected abstract Response shardOperation(Request request, ShardId shardId) throws IOException;
    private class TransportHandler implements TransportRequestHandler<Request> {
            }  
                        public void handleException(TransportException exp) {  
/**  
            asyncShardOperation(request, request.internalShardId, new ChannelActionListener<>(channel, transportShardAction, request));
                        public String executor() {
     * Asynchronous single action
    }  
    /**  
                        public void handleResponse(final Response response) {  
        }
                            listener.onResponse(response);
                lastFailure = currentFailure;
                    logger.trace(
                            return ThreadPool.Names.SAME;  
                throw blockException;
 *
        }  
            this.request = request;  
            // index names without validation errors. This is potentially a super-set of the indices resolved in  
            return request;
     */  
import org.opensearch.cluster.block.ClusterBlockException;
     */  
            ClusterBlockException blockException = checkGlobalBlock(clusterState);  
    protected abstract boolean resolveIndex(Request request);
import org.opensearch.action.support.TransportAction;  
        if (resolveIndex(request)) {  
        public void start() {
        } else {
import static org.opensearch.action.support.TransportActions.isShardNotAvailableException;
    protected void asyncShardOperation(Request request, ShardId shardId, ActionListener<Response> listener) throws IOException {
                    transportShardAction,  
                        @Override
                    internalRequest.request(),
     * Internal transport handler  
import org.opensearch.threadpool.ThreadPool;
 */
            // Instead, we use indexNameExpressionResolver.concreteResolvedIndices(), which allows us to retrieve
        private final ShardsIterator shardIt;
            if (node == null) {
            }
                        @Override
            return concreteIndex;  
     * will be called locally to its parent action.  
                            return reader.read(in);
            } else {
        InternalRequest(Request request, String concreteIndex) {
            this.shardIt = shards(clusterState, internalRequest);
     * the operation locally (the node that received the request)
            // We do not use resolveToConcreteSingleIndex() here because it might throw exceptions for validation errors.
            nodes = clusterState.nodes();
     * Internal request class that gets built on each node. Holds the original request plus additional info.  
        }  
            }
                if (logger.isTraceEnabled()) {  
    private class ShardTransportHandler implements TransportRequestHandler<Request> {  
            // if we have a local operation, execute it on a thread since we don't spawn
                        public void handleException(TransportException exp) {
                        public String executor() {
                        @Override  
        }
    protected boolean isSubAction() {
            if (blockException != null) {
        final Request request;
            return ResolvedIndices.of(indexNameExpressionResolver.concreteResolvedIndices(clusterService.state(), request));
     */
import org.opensearch.transport.TransportService;  
                        }
 * license agreements. See the NOTICE file distributed with
                );
                } else {
                transportService.sendRequest(
        ClusterService clusterService,
        public Request request() {
 *
                    );  
    protected final ThreadPool threadPool;  
 * specific language governing permissions and limitations
    private String resolveToConcreteSingleIndex(Request request, ClusterState clusterState) {
                        node
 * A base class for operations that need to perform a read operation on a single shard copy. If the operation fails,
            DiscoveryNode node = nodes.get(shardRouting.currentNodeId());
        @Override
     * Returns the candidate shards to execute the operation on or <code>null</code> the execute
                        }  
        transportService.registerRequestHandler(transportShardAction, ThreadPool.Names.SAME, request, new ShardTransportHandler());  
        return state.blocks().indexBlockedException(ClusterBlockLevel.READ, request.concreteIndex());
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.action.support.TransportActions;
import org.opensearch.transport.TransportResponseHandler;
                        public Response read(StreamInput in) throws IOException {  
     *
 * this work for additional information regarding copyright
    ) {
            return request.index();
                            return reader.read(in);  
                        internalRequest.request().internalShardId,
        ActionFilters actionFilters,
import org.opensearch.cluster.service.ClusterService;
     */
import org.opensearch.action.support.TransportIndicesResolvingAction;
                }  
    private final String executor;  
                    new TransportResponseHandler<Response>() {
            ClusterState clusterState = clusterService.state();
import org.opensearch.action.NoShardAvailableActionException;  
    /**
        private final ActionListener<Response> listener;
            }
            // validation error when executing the action.  
import org.opensearch.cluster.node.DiscoveryNodes;  
            this.concreteIndex = concreteIndex;
    protected abstract ShardsIterator shards(ClusterState state, InternalRequest request);
            resolveRequest(clusterState, internalRequest);
    }  
     *
import org.apache.logging.log4j.message.ParameterizedMessage;
     * Tells whether the action is a main one or a subaction. Used to decide whether we need to register
                        }
    TransportAction<Request, Response>
        this.indexNameExpressionResolver = indexNameExpressionResolver;
 * Modifications Copyright OpenSearch Contributors. See
                    logger.debug(() -> new ParameterizedMessage("{}: failed to execute [{}]", null, internalRequest.request()), failure);
 * Licensed to Elasticsearch under one or more contributor  
    @Override
            }  
import org.opensearch.common.Nullable;
            } else {
import org.opensearch.cluster.metadata.ResolvedIndices;
    public ResolvedIndices resolveIndices(Request request) {
                        }
 * GitHub history for details.
    protected abstract Writeable.Reader<Response> getResponseReader();
import org.opensearch.transport.TransportChannel;
import org.opensearch.cluster.node.DiscoveryNode;
 * of candidate shards to try the read operation on.  
import org.opensearch.core.common.logging.LoggerMessageFormat;
                        public Response read(StreamInput in) throws IOException {
                // just execute it on the local node
        public String concreteIndex() {
            Exception lastFailure = this.lastFailure;  
    }
                );  
        public void messageReceived(final Request request, final TransportChannel channel, Task task) throws Exception {  
 * You may obtain a copy of the License at  
     * Shard level transport handler
            }  
        private final DiscoveryNodes nodes;
            ShardRouting shardRouting = FailAwareWeightedRouting.getInstance()
                        internalRequest.request(),  
 */  
        this.threadPool = threadPool;
import org.opensearch.core.action.ActionListener;  
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.block.ClusterBlockLevel;
     *
    implements  
    class AsyncSingleAction {
    }
        Writeable.Reader<Request> request,  
                logger.trace("executing [{}] based on cluster state version [{}]", request, clusterState.version());  
    protected final IndexNameExpressionResolver indexNameExpressionResolver;  
    protected ClusterBlockException checkGlobalBlock(ClusterState state) {  
            blockException = checkRequestBlock(clusterState, internalRequest);  
        String executor
                if (failure == null || isShardNotAvailableException(failure)) {
/*
     */
 */  
        }
    protected class InternalRequest {
        private final InternalRequest internalRequest;  
        }
                }
 * ownership. Elasticsearch licenses this file to you under  
                    );  
                        }  
 *
                perform(null);  
    }  
        }
import org.opensearch.cluster.routing.FailAwareWeightedRouting;
        String actionName,  
        this.executor = executor;
                    failure = new NoShardAvailableActionException(
            perform(e);
    protected ClusterBlockException checkRequestBlock(ClusterState state, InternalRequest request) {
            if (shardRouting == null) {
        }
    @Nullable
            }
        return state.blocks().globalBlockedException(ClusterBlockLevel.READ);
                final Writeable.Reader<Response> reader = getResponseReader();
    /**
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    }  
package org.opensearch.action.support.single.shard;
    }  
 * software distributed under the License is distributed on an
        new AsyncSingleAction(request, listener).start();
     */  
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
 *  
                    new TransportResponseHandler<Response>() {
                        "sending request [{}] to shard [{}] on node [{}]",
                            onFailure(finalShardRouting, exp);  
    }
                logger.trace(() -> new ParameterizedMessage("{}: failed to execute [{}]", shardRouting, internalRequest.request()), e);  
                        }
                    }
    }
                            return ThreadPool.Names.SAME;
 * KIND, either express or implied.  See the License for the
            // resolveToConcreteSingleIndex(), but this is only a hypothetical state. In practise, we should
                        @Override
                            listener.onResponse(response);
            String concreteSingleIndex = resolveToConcreteSingleIndex(request, clusterState);
                        public void handleResponse(final Response response) {
/*  
                Exception failure = lastFailure;  
 * the Apache License, Version 2.0 (the "License"); you may
            return ResolvedIndices.of(request.index());  
            this.internalRequest = new InternalRequest(request, concreteSingleIndex);  
        return false;  
                logger.trace("executing [{}] on shard [{}]", request, request.internalShardId);
 * under the License.  
        public void messageReceived(Request request, final TransportChannel channel, Task task) throws Exception {
                        null,  
        final String concreteIndex;  
    protected final ClusterService clusterService;
import org.opensearch.cluster.routing.ShardRouting;
        ThreadPool threadPool,
    /**
        @Override  
import org.opensearch.core.action.ActionResponse;
    protected final TransportService transportService;
    }
     * @opensearch.internal
            if (shardIt == null) {  
                            listener.onFailure(exp);
     * @opensearch.internal  
/*  
    }
        this.transportShardAction = actionName + "[s]";  
        this.clusterService = clusterService;
                final Writeable.Reader<Response> reader = getResponseReader();
                        }
            // also always get one element here. If for some reason that's not the case, the code will hit the
        } else {
     * @opensearch.internal
            if (blockException != null) {
    }  
 * the read operation can be performed on other shard copies. Concrete implementations can provide their own list
     *  
                transportService.sendRequest(  
        private AsyncSingleAction(Request request, ActionListener<Response> listener) {
                .findNext(shardIt, clusterService.state(), currentFailure, () -> {});  
        if (resolveIndex(request)) {
                        failure
        TransportService transportService,  
import org.opensearch.cluster.routing.ShardsIterator;  
}
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (lastFailure == null || TransportActions.isReadOverrideException(currentFailure)) {
        if (!isSubAction()) {  
                        @Override  
import org.opensearch.core.common.io.stream.StreamInput;
    }
    protected TransportSingleShardAction(
import java.io.IOException;
import org.opensearch.tasks.Task;  
    private final String transportShardAction;
import org.opensearch.action.support.ActionFilters;
        }
import org.opensearch.action.support.ChannelActionListener;
                    }  
        private void onFailure(ShardRouting shardRouting, Exception e) {
 * SPDX-License-Identifier: Apache-2.0
            return indexNameExpressionResolver.concreteSingleIndex(clusterState, request).getName();  
        private volatile Exception lastFailure;
import org.opensearch.cluster.ClusterState;  
                throw blockException;
        }  
    @Override  
public abstract class TransportSingleShardAction<Request extends SingleShardRequest<Request>, Response extends ActionResponse> extends
                        }
        private void perform(@Nullable final Exception currentFailure) {
            if (logger.isTraceEnabled()) {
import org.opensearch.core.common.io.stream.Writeable;  
            this.listener = listener;
     * the main transport handler. In fact if the action is a subaction, its execute method
                        LoggerMessageFormat.format("No shard available for [{}]", internalRequest.request()),
        this.transportService = transportService;  
        }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
                    transportShardAction,
    /**  
                        @Override
 */  
                    internalRequest.request(),  
import org.opensearch.transport.TransportRequestHandler;
        threadPool.executor(getExecutor(request, shardId)).execute(ActionRunnable.supply(listener, () -> shardOperation(request, shardId)));
        TransportIndicesResolvingAction<Request> {
            if (logger.isTraceEnabled()) {
                this.lastFailure = currentFailure;  
 * @opensearch.internal
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return;
 * compatible open source license.
            if (e != null) {
    protected void resolveRequest(ClusterState state, InternalRequest request) {
 * The OpenSearch Contributors require contributions made to  
                internalRequest.request().internalShardId = shardRouting.shardId();
        }
                        @Override
            }  
import org.opensearch.transport.TransportException;  
                ShardRouting finalShardRouting = shardRouting;  
                        @Override
            execute(request, new ChannelActionListener<>(channel, actionName, request));  
            transportService.registerRequestHandler(actionName, ThreadPool.Names.SAME, request, new TransportHandler());
        return executor;
            }
