import org.opensearch.cluster.ClusterStateObserver;
import org.opensearch.core.common.io.stream.StreamInput;
                return;
import org.opensearch.core.index.shard.ShardId;
            try {
                    } else {
                }
                            shardIt.size(),
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (blockException != null) {
                        listenFailure = new UnavailableShardsException(
            threadPool.executor(executor(request.shardId)).execute(new AbstractRunnable() {
    }
                protected void doRun() {
                    // if we got disconnected from the node, or the node / shard is not in the right state (being closed)
                    } else {
import org.opensearch.action.support.HandledTransportAction;
                            actionName
                            "[{}] shardIt, [{}] active : Timeout waiting for [{}], request: {}",
    public ResolvedIndices resolveIndices(Request request) {
    @Override
    ) {
    }
                    } catch (Exception inner) {
        this.shardActionName = actionName + "[s]";
        new AsyncSingleAction(request, listener).start();
                    return ThreadPool.Names.SAME;
import org.opensearch.index.IndexNotFoundException;
                }
        @Override
                }
            ShardRouting shard = shardIt.nextOrNull();
                return;
            } catch (Exception e) {
                @Override
    protected final ClusterService clusterService;
            assert shardIt.size() == 1;
import org.opensearch.action.UnavailableShardsException;
                return ResolvedIndices.of(indexNameExpressionResolver.concreteWriteIndex(clusterService.state(), request).getName());
        }
    @Override
                @Override
     *
        super(actionName, transportService, actionFilters, request);
     */
                            "Timeout waiting for [{}], request: {}",
 * The OpenSearch Contributors require contributions made to
                            shardIt.sizeActive(),
        public void start() {
                        throw blockException;
        protected void doStart(ClusterState clusterState) {
                    // just to be on the safe side, see if we can start it now?
                ClusterBlockException blockException = checkGlobalBlock(clusterState);
                        retry(blockException);
import org.opensearch.transport.TransportRequestHandler;
                    doStart(observer.setAndGetObservedState());
                        channel.sendResponse(e);
                    }
                }
    protected abstract void resolveRequest(ClusterState state, Request request);
import org.opensearch.core.action.ActionResponse;
    /**
                    doStart(state);
        IndexNameExpressionResolver indexNameExpressionResolver,
 *
        private final Request request;
    private class ShardTransportHandler implements TransportRequestHandler<Request> {
import org.opensearch.core.common.io.stream.Writeable;
                    if (cause instanceof ConnectTransportException || cause instanceof NodeClosedException || retryOnFailure(exp)) {
import org.opensearch.transport.TransportChannel;
                        inner.addSuppressed(e);
                        );
            transportService.sendRequest(node, shardActionName, request, transportOptions(), new TransportResponseHandler<Response>() {
    protected ClusterBlockException checkRequestBlock(ClusterState state, Request request) {
import org.opensearch.common.Nullable;
                public String executor() {
                return ResolvedIndices.of(request.index());
    /**
            try {
                            actionName
            doStart(state);
 *
import org.opensearch.tasks.Task;
                }
        AsyncSingleAction(Request request, ActionListener<Response> listener) {
            if (!shard.active()) {
                return;
package org.opensearch.action.support.single.instance;
            this.listener = listener;
                    } else {
import org.opensearch.transport.ConnectTransportException;
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));
import static org.opensearch.cluster.metadata.IndexNameExpressionResolver.EXCLUDED_DATA_STREAMS_KEY;
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import java.io.IOException;
    Request extends InstanceShardOperationRequest<Request>,
    protected final IndexNameExpressionResolver indexNameExpressionResolver;
 * software distributed under the License is distributed on an
                @Override
                    try {
            assert shard != null;
                Exception listenFailure = failure;
 *
    final String shardActionName;
                    }
import org.opensearch.cluster.routing.ShardRouting;
 */
                }
                public Response read(StreamInput in) throws IOException {
                        listenFailure = new UnavailableShardsException(
 * Unless required by applicable law or agreed to in writing,
                            -1,
 * the Apache License, Version 2.0 (the "License"); you may
    protected boolean retryOnFailure(Exception e) {
    protected ClusterBlockException checkGlobalBlock(ClusterState state) {
                    }
    }
    protected TransportRequestOptions transportOptions() {
                // We just return the original unresolved expression. The error we encountered here will
            } catch (IndexNotFoundException e) {
                        retry(blockException);
            if (shardIt.size() == 0) {
        this.transportService = transportService;
     * Asynchronous single action
                @Override
                    if (blockException.retryable()) {
                    shardOperation(request, ActionListener.wrap(channel::sendResponse, this::onFailure));
                }
     */
    protected TransportInstanceSingleOperationAction(
                    } else {
                @Override
    protected abstract void shardOperation(Request request, ActionListener<Response> listener);
        } else {
        return false;
                resolveRequest(clusterState, request);
                }
        void retry(@Nullable final Exception failure) {
                            request.timeout(),
 * specific language governing permissions and limitations
        private volatile ClusterStateObserver observer;
    protected final TransportService transportService;
/*
                @Override
 *
            // no shardIt, might be in the case between index gateway recovery and shardIt initialization
import org.opensearch.action.support.TransportIndicesResolvingAction;
                }
                listener.onFailure(e);
import org.opensearch.transport.TransportResponseHandler;
        this.indexNameExpressionResolver = indexNameExpressionResolver;
            }
            this.observer = new ClusterStateObserver(state, clusterService, request.timeout(), logger, threadPool.getThreadContext());
            });
        }
                blockException = checkRequestBlock(clusterState, request);
}
                } catch (IndexNotFoundException e) {
                // we running as a last attempt after a timeout has happened. don't retry
        this.clusterService = clusterService;
    protected final ThreadPool threadPool;
            request.shardId = shardIt.shardId();
                @Override
        }
import org.opensearch.threadpool.ThreadPool;
        ThreadPool threadPool,
import org.opensearch.transport.TransportException;
import org.opensearch.cluster.block.ClusterBlockLevel;
        }
                }
     */
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
                    listener.onResponse(response);
                shardIt = shards(clusterState, request);
                    }
import org.opensearch.core.action.ActionListener;
                return;
            return ResolvedIndices.of(request.concreteIndex());
import org.opensearch.common.util.concurrent.AbstractRunnable;
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Transport handler per shard
    }
        Writeable.Reader<Request> request
                    final Throwable cause = exp.unwrapCause();
     * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
    protected abstract String executor(ShardId shardId);
            if (observer.isTimedOut()) {
/**
        ActionFilters actionFilters,
                    return newResponse(in);
                        throw new IllegalArgumentException("only write ops with an op_type of create are allowed in data streams");
                    }
                        );
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
                try {
import org.opensearch.action.support.ActionFilters;
                    if (request.includeDataStreams() == false && e.getMetadataKeys().contains(EXCLUDED_DATA_STREAMS_KEY)) {
                if (listenFailure == null) {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.metadata.ResolvedIndices;
        public void messageReceived(final Request request, final TransportChannel channel, Task task) throws Exception {
            }
                        return;
                    }
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor
    /**
                listener.onFailure(listenFailure);
        String actionName,
                public void handleResponse(Response response) {
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
                            request.timeout(),
 * not use this file except in compliance with the License.
import org.opensearch.cluster.ClusterState;
    }
        if (request.concreteIndex() != null) {
import org.opensearch.cluster.node.DiscoveryNode;
 */
                if (blockException != null) {
 */
 * under the License.
            ClusterState state = clusterService.state();
                public void onClusterServiceClose() {
    class AsyncSingleAction {
import org.opensearch.cluster.block.ClusterBlockException;
            }
        private final ActionListener<Response> listener;
                public void onFailure(Exception e) {
                        return;
/*
                        logger.warn("failed to send response for " + shardActionName, inner);
            this.request = request;
                    if (blockException.retryable()) {
                        throw e;
                    } else {
            }, request.timeout());
 * @opensearch.internal
    }
                @Override
                        retry((Exception) cause);
import org.opensearch.node.NodeClosedException;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.service.ClusterService;
        }
                public void onNewClusterState(ClusterState state) {
 * Base class for a single operation action
    }
            });
                        throw blockException;
 * You may obtain a copy of the License at
    protected abstract Response newResponse(StreamInput in) throws IOException;
    protected abstract ShardIterator shards(ClusterState clusterState, Request request);
 * compatible open source license.
        TransportService transportService,
import org.opensearch.transport.TransportRequestOptions;
            // this transport only make sense with an iterator that returns a single shard routing (like primary)
        private ShardIterator shardIt;
                        listener.onFailure(exp);
     * @opensearch.internal
        return TransportRequestOptions.EMPTY;
                // be encountered again in the doStart() method
                            request.concreteIndex(),
                public void handleException(TransportException exp) {
                }
     * Should return an iterator with a single shard!
        this.threadPool = threadPool;
public abstract class TransportInstanceSingleOperationAction<
import org.opensearch.threadpool.ThreadPool.Names;
            }
            }
                    request.concreteIndex(indexNameExpressionResolver.concreteWriteIndex(clusterState, request).getName());
                retry(null);
        transportService.registerRequestHandler(shardActionName, Names.SAME, request, new ShardTransportHandler());
    }
        return state.blocks().indexBlockedException(ClusterBlockLevel.WRITE, request.concreteIndex());
                }
    /**
     * Resolves the request. Throws an exception if the request cannot be resolved.
 * GitHub history for details.
                    if (shardIt == null) {
        ClusterService clusterService,
                retry(null);
                            shardIt.shardId(),
                public void onTimeout(TimeValue timeout) {
 */
                @Override
                }
import org.opensearch.common.unit.TimeValue;
     */
        return state.blocks().globalBlockedException(ClusterBlockLevel.WRITE);
    }
            DiscoveryNode node = clusterState.nodes().get(shard.currentNodeId());
import org.opensearch.cluster.routing.ShardIterator;
import org.opensearch.transport.TransportService;
    Response extends ActionResponse> extends HandledTransportAction<Request, Response> implements TransportIndicesResolvingAction<Request> {
/*
