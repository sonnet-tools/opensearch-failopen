import org.opensearch.action.support.TransportIndicesResolvingAction;
    @Override
     * Asynchronous broadcast action
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.service.ClusterService;
                }
                listener.onFailure(e);
                    }
                                new ParameterizedMessage(
 *
        private final AtomicReferenceArray shardsResponses;
 * Unless required by applicable law or agreed to in writing,
                // no more active shards... (we should not really get here, just safety)
     */
        String actionName,
    }
            shardsResponses = new AtomicReferenceArray<>(expectedOps);
import org.opensearch.common.Nullable;
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
            if (!(response instanceof Throwable)) {
    final String transportShardAction;
    }
            if (shard == null) {
import org.opensearch.action.ActionRunnable;
                } catch (Exception e) {
import org.opensearch.core.common.io.stream.StreamInput;
            shardsResponses.set(shardIndex, response);
                                @Override
 *
    }
                    logger.warn(
    Response extends BroadcastResponse,
    public ResolvedIndices resolveIndices(Request request) {
                } else {
            try {
     */
 * GitHub history for details.
                        e1
        }
                                }
        private final DiscoveryNodes nodes;
                    finishHim();
import org.opensearch.threadpool.ThreadPool;
                final ShardRouting shard = shardIt.nextOrNull();
        ClusterService clusterService,
            if (!(e instanceof BroadcastShardOperationFailedException)) {
     * on the first shard in it. If the operation fails, it will be retried on the next shard in the iterator.
                        onOperation(shard, shardIt, shardIndex, new NoShardAvailableActionException(shardIt.shardId()));
                listener.onResponse(newResponse(request, shardsResponses, clusterState));
            blockException = checkRequestBlock(clusterState, request, concreteIndices);
                    DiscoveryNode node = nodes.get(shard.currentNodeId());
                shardIndex++;
            if (blockException != null) {
import org.opensearch.transport.TransportResponseHandler;
                                e
                                    onOperation(shard, shardIndex, response);
 * KIND, either express or implied.  See the License for the
                                @Override
        super(actionName, transportService, actionFilters, request);
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                            }
        private final AtomicInteger counterOps = new AtomicInteger();
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));
        protected void finishHim() {
                    channel.sendResponse(e);
                        () -> new ParameterizedMessage(
import org.opensearch.core.common.io.stream.Writeable;
    ShardRequest extends BroadcastShardRequest,
            }
            for (final ShardIterator shardIt : shardsIts) {
                                public void handleException(TransportException e) {
                        }
                                }
                            transportShardAction,
            ClusterBlockException blockException = checkGlobalBlock(clusterState, request);
                                ),
        this.shardExecutor = shardExecutor;
 * software distributed under the License is distributed on an
            }
     * Determines the shards this operation will be executed on. The operation is executed once per shard iterator, typically
        }
                        ),
            nodes = clusterState.nodes();
                throw blockException;
                            logger.trace(
                    final ShardRequest shardRequest = newShardRequest(shardIt.size(), shard, request);
package org.opensearch.action.support.broadcast;
                return;
    protected abstract ShardResponse readShardResponse(StreamInput in) throws IOException;
        protected void onOperation(ShardRouting shard, int shardIndex, ShardResponse response) {
import org.opensearch.cluster.node.DiscoveryNodes;
        private final GroupShardsIterator<ShardIterator> shardsIts;
            // update to concrete indices
            .executor(shardExecutor)
                onOperation(null, shardIt, shardIndex, new NoShardAvailableActionException(shardIt.shardId()));
 *
                            );
                            "Failed to send error response for action [{}] and request [{}]",
    /**
 * ownership. Elasticsearch licenses this file to you under
                if (shard != null) {
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.action.NoShardAvailableActionException;
                                ),
import org.opensearch.cluster.node.DiscoveryNode;
}
            expectedOps = shardsIts.size();
            logger.trace("resolving shards based on cluster state version [{}]", clusterState.version());
            this.task = task;
    protected abstract ShardResponse shardOperation(ShardRequest request, Task task) throws IOException;
import org.opensearch.transport.TransportChannel;
import org.opensearch.cluster.routing.GroupShardsIterator;
            if (response == null) {
    protected TransportBroadcastAction(
/**
    ShardResponse extends BroadcastShardResponse> extends HandledTransportAction<Request, Response>
        this.transportShardAction = actionName + "[s]";
            }));
                } catch (Exception e) {
    implements
                    }
    protected class AsyncBroadcastAction {
            String[] concreteIndices = resolveIndices(request, clusterState).namesOfConcreteIndicesAsArray();
            this.listener = listener;
    protected final ClusterService clusterService;
                                    "{}: failed to execute [{}]",
        }
                                e
 */
            // for example, getting illegal shard state
                shardsResponses.set(shardIndex, e);
                if (expectedOps == counterOps.incrementAndGet()) {
                            shardRequest,
        this.transportService = transportService;
                    listener.onResponse(newResponse(request, new AtomicReferenceArray(0), clusterState));
                                    return ThreadPool.Names.SAME;
        }
import java.io.IOException;
                // just override it and return
                    if (node == null) {
 * not use this file except in compliance with the License.
 * Base transport broadcast action class
                        if (!TransportActions.isShardNotAvailableException(e)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ActionFilters actionFilters,
    @Override
import org.opensearch.cluster.metadata.ResolvedIndices;
    protected abstract ClusterBlockException checkRequestBlock(ClusterState state, Request request, String[] concreteIndices);
        IndexNameExpressionResolver indexNameExpressionResolver,
        transportService.getThreadPool()
                                    "{}: failed to execute [{}]",
        }
        this.clusterService = clusterService;
    ) {
        TransportIndicesResolvingAction<Request> {
                e = new BroadcastShardOperationFailedException(shardIt.shardId(), e);
    private final String shardExecutor;
            }
    class ShardTransportHandler implements TransportRequestHandler<ShardRequest> {
     *
            if (TransportActions.isShardNotAvailableException(e)) {
        void setFailure(ShardIterator shardIt, int shardIndex, Exception e) {
                    } else {
                finishHim();
                                    request
                                    return readShardResponse(in);
            Object response = shardsResponses.get(shardIndex);
                    onOperation(null, shardIt, shardIndex, new NoShardAvailableActionException(shardIt.shardId()));
                try {
                                public ShardResponse read(StreamInput in) throws IOException {
                performOperation(shardIt, nextShard, shardIndex);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            }
                                    request
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
            int shardIndex = -1;
                                @Override
    protected final IndexNameExpressionResolver indexNameExpressionResolver;
import org.opensearch.transport.TransportService;
                    shardRequest.setParentTask(clusterService.localNode().getId(), task.getId());
                                }
     * @opensearch.internal
                }
        public void start() {
                .findNext(shardIt, clusterService.state(), e, () -> counterOps.incrementAndGet());
        Writeable.Reader<ShardRequest> shardRequest,
        private final Request request;
        private final ActionListener<Response> listener;
/*
public abstract class TransportBroadcastAction<
    protected abstract ClusterBlockException checkGlobalBlock(ClusterState state, Request request);
                            actionName,
                                }
            // will work (it will just override it...)
     * A shard transport handler
            setFailure(shardIt, shardIndex, e);
            }
        this.indexNameExpressionResolver = indexNameExpressionResolver;
                                new ParameterizedMessage(
                    performOperation(shardIt, shard, shardIndex);
            shardsIts = shards(clusterState, request, concreteIndices);
import org.opensearch.transport.TransportRequestHandler;
 *
            // the failure is already present, try and not override it with an exception that is less meaningless
                            );
            // we set the shard failure always, even if its the first in the replication group, and the next one
                } catch (Exception e1) {
                                public void handleResponse(ShardResponse response) {
                                    shard != null ? shard.shortSummary() : shardIt.shardId(),
            } catch (Exception e) {
import org.opensearch.action.support.ActionFilters;
        private final Task task;
        transportService.registerRequestHandler(transportShardAction, ThreadPool.Names.SAME, shardRequest, new ShardTransportHandler());
    protected final TransportService transportService;
    }
                    // really, no shards active in this group
                throw blockException;
 */
            logger.trace("received response for {}", shard);
                            request
        Writeable.Reader<Request> request,
        void onOperation(@Nullable ShardRouting shard, final ShardIterator shardIt, int shardIndex, Exception e) {
            .execute(ActionRunnable.supply(listener, () -> shardOperation(request, task)));
 */
import org.opensearch.cluster.routing.ShardIterator;
                        // no node connected, act as failure
            // we don't aggregate shard failures on non active shards (but do keep the header counts right)
 * under the License.
/*
                                    shard != null ? shard.shortSummary() : shardIt.shardId(),
            }
        new AsyncBroadcastAction(task, request, listener).start();
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.cluster.ClusterState;
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
/*
                                    onOperation(shard, shardIt, shardIndex, e);
    /**
        }
            this.request = request;
                }
            if (TransportActions.isReadOverrideException(e)) {
                }
            ShardRouting nextShard = FailAwareWeightedRouting.getInstance()
    private void asyncShardOperation(ShardRequest request, Task task, ActionListener<ShardResponse> listener) {
 * the Apache License, Version 2.0 (the "License"); you may
                // we should never really get here...
            }
            } else {
                                @Override
        }
                if (logger.isDebugEnabled()) {
            }
 * @opensearch.internal
    }
                        );
        @Override
    /**
                if (e != null) {
    }
                try {
        public void messageReceived(ShardRequest request, TransportChannel channel, Task task) throws Exception {
            }
                    onOperation(shard, shardIt, shardIndex, e);
        private final ClusterState clusterState;
            }
            } else {
            }
        protected void performOperation(final ShardIterator shardIt, final ShardRouting shard, final int shardIndex) {
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at
                        if (!TransportActions.isShardNotAvailableException(e)) {
                        }
import org.opensearch.cluster.routing.FailAwareWeightedRouting;
                }
 * Modifications Copyright OpenSearch Contributors. See
                                public String executor() {
import org.opensearch.action.support.TransportActions;
                    }
            // count the local operations, and perform the non local ones
            if (shardsIts.size() == 0) {
                shardsResponses.set(shardIndex, e);
                // no shards
                    listener.onFailure(e);
        }
import java.util.concurrent.atomic.AtomicInteger;
            if (expectedOps == counterOps.incrementAndGet()) {
     * @opensearch.internal
                        transportService.sendRequest(
            }
            if (blockException != null) {
            }
        private final int expectedOps;
     */
                }
                return;
    }
                try {
            if (nextShard != null) {
                    );
import org.opensearch.transport.TransportException;
                            new TransportResponseHandler<ShardResponse>() {
 * compatible open source license.
        protected AsyncBroadcastAction(Task task, Request request, ActionListener<Response> listener) {
import org.opensearch.cluster.routing.ShardRouting;
    Request extends BroadcastRequest<Request>,
            asyncShardOperation(request, task, ActionListener.wrap(channel::sendResponse, e -> {
    protected abstract ShardRequest newShardRequest(int numShards, ShardRouting shard, Request request);
        @SuppressWarnings({ "unchecked" })
                            node,
 * The OpenSearch Contributors require contributions made to
            clusterState = clusterService.state();
                            logger.debug(
    protected abstract GroupShardsIterator<ShardIterator> shards(ClusterState clusterState, Request request, String[] concreteIndices);
import java.util.concurrent.atomic.AtomicReferenceArray;
    protected ResolvedIndices.Local.Concrete resolveIndices(Request request, ClusterState clusterState) {
                    if (logger.isTraceEnabled()) {
 */
        TransportService transportService,
                }
                    if (e != null) {
    protected abstract Response newResponse(Request request, AtomicReferenceArray shardsResponses, ClusterState clusterState);
import org.opensearch.action.support.HandledTransportAction;
     *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.tasks.Task;
                return;
        String shardExecutor
