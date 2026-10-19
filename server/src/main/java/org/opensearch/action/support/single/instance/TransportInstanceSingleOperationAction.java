import org.opensearch.transport.ConnectTransportException;
                public void onClusterServiceClose() {
package org.opensearch.action.support.single.instance;
import org.opensearch.transport.TransportRequestHandler;
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
    }  
    }
                public void onNewClusterState(ClusterState state) {  
                    } else {
            }
                if (listenFailure == null) {
                }  
                @Override
                    if (cause instanceof ConnectTransportException || cause instanceof NodeClosedException || retryOnFailure(exp)) {  
import org.opensearch.threadpool.ThreadPool;
 * KIND, either express or implied.  See the License for the
                        logger.warn("failed to send response for " + shardActionName, inner);
                }
                        );  
                listener.onFailure(listenFailure);  
            if (observer.isTimedOut()) {
 * SPDX-License-Identifier: Apache-2.0
            }
    protected final ClusterService clusterService;
            ShardRouting shard = shardIt.nextOrNull();
    public ResolvedIndices resolveIndices(Request request) {
                if (blockException != null) {
                @Override
     * @opensearch.internal  
                // We just return the original unresolved expression. The error we encountered here will  
            request.shardId = shardIt.shardId();
        public void start() {
            }  
    protected final IndexNameExpressionResolver indexNameExpressionResolver;
        return state.blocks().indexBlockedException(ClusterBlockLevel.WRITE, request.concreteIndex());  
                return;
        }
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {  
import org.opensearch.cluster.service.ClusterService;
 */
import org.opensearch.common.Nullable;  
            assert shard != null;  
import org.opensearch.core.common.io.stream.StreamInput;
            transportService.sendRequest(node, shardActionName, request, transportOptions(), new TransportResponseHandler<Response>() {  
                            "[{}] shardIt, [{}] active : Timeout waiting for [{}], request: {}",
     *
                            actionName
 * compatible open source license.
                }
                @Override
     * Transport handler per shard
        }
                }
                    // if we got disconnected from the node, or the node / shard is not in the right state (being closed)
import org.opensearch.cluster.ClusterState;
                            -1,
        void retry(@Nullable final Exception failure) {  
                resolveRequest(clusterState, request);
                try {
            try {  
    protected TransportInstanceSingleOperationAction(
                    }
    Response extends ActionResponse> extends HandledTransportAction<Request, Response> implements TransportIndicesResolvingAction<Request> {
                    listener.onResponse(response);
import org.opensearch.core.action.ActionResponse;
                @Override
            if (!shard.active()) {
        return state.blocks().globalBlockedException(ClusterBlockLevel.WRITE);
        public void messageReceived(final Request request, final TransportChannel channel, Task task) throws Exception {
                // we running as a last attempt after a timeout has happened. don't retry
        @Override
    class AsyncSingleAction {
import org.opensearch.threadpool.ThreadPool.Names;  
                return;
                public void onFailure(Exception e) {
                            shardIt.sizeActive(),  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.block.ClusterBlockException;
                            request.timeout(),
        protected void doStart(ClusterState clusterState) {
            if (shardIt.size() == 0) {  
            }  
import org.opensearch.action.UnavailableShardsException;
import org.opensearch.action.support.ActionFilters;
                            "Timeout waiting for [{}], request: {}",  
    protected abstract String executor(ShardId shardId);
import org.opensearch.common.util.concurrent.AbstractRunnable;
                    return newResponse(in);
 * @opensearch.internal
import org.opensearch.transport.TransportException;  
    /**
    /**  
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.action.support.TransportIndicesResolvingAction;
                    } else {
                return;
import org.opensearch.tasks.Task;
            }  
        TransportService transportService,  
     */
import static org.opensearch.cluster.metadata.IndexNameExpressionResolver.EXCLUDED_DATA_STREAMS_KEY;
        ThreadPool threadPool,
                }
        this.shardActionName = actionName + "[s]";
    protected abstract Response newResponse(StreamInput in) throws IOException;
                }  
import org.opensearch.cluster.ClusterStateObserver;  
 * Licensed to Elasticsearch under one or more contributor  
 *
                @Override
 * You may obtain a copy of the License at  
            threadPool.executor(executor(request.shardId)).execute(new AbstractRunnable() {  
                @Override  
}  
        ActionFilters actionFilters,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    }
    }
     */
                return;
            } catch (Exception e) {  
                public String executor() {
        this.threadPool = threadPool;  
                listener.onFailure(e);
                } catch (IndexNotFoundException e) {  
 * under the License.  
                    try {  
    Request extends InstanceShardOperationRequest<Request>,
        transportService.registerRequestHandler(shardActionName, Names.SAME, request, new ShardTransportHandler());
                return ResolvedIndices.of(indexNameExpressionResolver.concreteWriteIndex(clusterService.state(), request).getName());
    @Override
public abstract class TransportInstanceSingleOperationAction<  
    ) {
     *
            try {  
import org.opensearch.transport.TransportRequestOptions;
        super(actionName, transportService, actionFilters, request);
                            shardIt.size(),
                // be encountered again in the doStart() method
        private final ActionListener<Response> listener;
    }
                }  
                }
            this.listener = listener;
            doStart(state);
    protected abstract void shardOperation(Request request, ActionListener<Response> listener);  
                blockException = checkRequestBlock(clusterState, request);
 * specific language governing permissions and limitations
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
    protected abstract ShardIterator shards(ClusterState clusterState, Request request);
     * Resolves the request. Throws an exception if the request cannot be resolved.
                    shardOperation(request, ActionListener.wrap(channel::sendResponse, this::onFailure));
                if (blockException != null) {  
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));  
import org.opensearch.core.common.io.stream.Writeable;  
                            actionName
 * ownership. Elasticsearch licenses this file to you under  
                    }
                            request.timeout(),
            DiscoveryNode node = clusterState.nodes().get(shard.currentNodeId());
            ClusterState state = clusterService.state();  
                        return;  
                        return;
                        throw new IllegalArgumentException("only write ops with an op_type of create are allowed in data streams");
                        listenFailure = new UnavailableShardsException(  
                    doStart(observer.setAndGetObservedState());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }  
        IndexNameExpressionResolver indexNameExpressionResolver,
            });  
import org.opensearch.cluster.metadata.ResolvedIndices;
                public void handleResponse(Response response) {
    }  
            } catch (IndexNotFoundException e) {
import org.opensearch.core.index.shard.ShardId;
    /**  
            assert shardIt.size() == 1;  
            });  
                @Override
    protected final ThreadPool threadPool;
    }
                    }
import org.opensearch.index.IndexNotFoundException;
                retry(null);  
import org.opensearch.core.action.ActionListener;  
            this.observer = new ClusterStateObserver(state, clusterService, request.timeout(), logger, threadPool.getThreadContext());
     * Asynchronous single action
                        channel.sendResponse(e);
        ClusterService clusterService,
        String actionName,  
 */
                        throw blockException;
        private final Request request;
                    }
                        retry(blockException);
                            shardIt.shardId(),  
                            request.concreteIndex(),
 *
 * software distributed under the License is distributed on an
                    final Throwable cause = exp.unwrapCause();
                        listener.onFailure(exp);  
                    }
                public void handleException(TransportException exp) {  
            return ResolvedIndices.of(request.concreteIndex());
    private class ShardTransportHandler implements TransportRequestHandler<Request> {
                @Override
                Exception listenFailure = failure;  
        this.clusterService = clusterService;
                    request.concreteIndex(indexNameExpressionResolver.concreteWriteIndex(clusterState, request).getName());
        if (request.concreteIndex() != null) {  
        Writeable.Reader<Request> request  
 * Modifications Copyright OpenSearch Contributors. See
    }
                        );  
                    } else {  
 * Unless required by applicable law or agreed to in writing,
    protected TransportRequestOptions transportOptions() {  
                @Override  
    /**  
                        throw e;
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected ClusterBlockException checkGlobalBlock(ClusterState state) {
import org.opensearch.common.unit.TimeValue;
        this.transportService = transportService;
                        retry(blockException);
 * The OpenSearch Contributors require contributions made to  
                    doStart(state);
import org.opensearch.transport.TransportService;
     */
                        listenFailure = new UnavailableShardsException(
     * @opensearch.internal  
                    } else {  
                    if (shardIt == null) {
import org.opensearch.node.NodeClosedException;  
                retry(null);
        return false;  
                return ResolvedIndices.of(request.index());
            this.request = request;
     */  
 *  
    protected final TransportService transportService;  
                protected void doRun() {  
import org.opensearch.cluster.routing.ShardIterator;  
    protected abstract void resolveRequest(ClusterState state, Request request);  
 *  
/*  
        return TransportRequestOptions.EMPTY;
/**
/*  
import org.opensearch.cluster.routing.ShardRouting;
                    if (blockException.retryable()) {  
        private ShardIterator shardIt;
                    if (request.includeDataStreams() == false && e.getMetadataKeys().contains(EXCLUDED_DATA_STREAMS_KEY)) {
 */  
import org.opensearch.cluster.node.DiscoveryNode;
 * license agreements. See the NOTICE file distributed with
                        throw blockException;
                }
        AsyncSingleAction(Request request, ActionListener<Response> listener) {  
            // no shardIt, might be in the case between index gateway recovery and shardIt initialization
    final String shardActionName;  
                shardIt = shards(clusterState, request);
        private volatile ClusterStateObserver observer;  
/*
 * this work for additional information regarding copyright
            // this transport only make sense with an iterator that returns a single shard routing (like primary)
                public void onTimeout(TimeValue timeout) {
                ClusterBlockException blockException = checkGlobalBlock(clusterState);
                    // just to be on the safe side, see if we can start it now?
import org.opensearch.transport.TransportResponseHandler;  
import org.opensearch.action.support.HandledTransportAction;  
     * Should return an iterator with a single shard!
    }
                    return ThreadPool.Names.SAME;  
        } else {
                    if (blockException.retryable()) {
    protected boolean retryOnFailure(Exception e) {
                    } catch (Exception inner) {
        }  
    @Override
        }  
        }  
            }, request.timeout());
        }
 * Base class for a single operation action
                }
                        retry((Exception) cause);
                        inner.addSuppressed(e);  
                }
        new AsyncSingleAction(request, listener).start();
                    } else {
 */  
 * not use this file except in compliance with the License.
import org.opensearch.transport.TransportChannel;
import java.io.IOException;  
                }  
                }
    protected ClusterBlockException checkRequestBlock(ClusterState state, Request request) {
                public Response read(StreamInput in) throws IOException {  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
