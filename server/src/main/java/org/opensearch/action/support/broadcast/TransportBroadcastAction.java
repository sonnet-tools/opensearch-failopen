    protected abstract ShardResponse shardOperation(ShardRequest request, Task task) throws IOException;
            if (!(response instanceof Throwable)) {  
                } catch (Exception e) {
            this.request = request;  
                                public void handleException(TransportException e) {
                                }  
                    onOperation(shard, shardIt, shardIndex, e);
                return;
            }  
import java.util.concurrent.atomic.AtomicInteger;
    }
 */  
            } else {
                }
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
                } else {
                    channel.sendResponse(e);  
 * not use this file except in compliance with the License.
    public ResolvedIndices resolveIndices(Request request) {  
    protected abstract GroupShardsIterator<ShardIterator> shards(ClusterState clusterState, Request request, String[] concreteIndices);
            this.task = task;
/**
    private void asyncShardOperation(ShardRequest request, Task task, ActionListener<ShardResponse> listener) {  
                throw blockException;
                            node,
        void setFailure(ShardIterator shardIt, int shardIndex, Exception e) {
import org.opensearch.tasks.Task;
            shardsResponses.set(shardIndex, response);
                final ShardRouting shard = shardIt.nextOrNull();
    Response extends BroadcastResponse,  
    @Override  
                    final ShardRequest shardRequest = newShardRequest(shardIt.size(), shard, request);  
                                @Override
        protected void performOperation(final ShardIterator shardIt, final ShardRouting shard, final int shardIndex) {  
import org.opensearch.cluster.service.ClusterService;  
                        );
    protected abstract Response newResponse(Request request, AtomicReferenceArray shardsResponses, ClusterState clusterState);
                            actionName,
    }
        protected AsyncBroadcastAction(Task task, Request request, ActionListener<Response> listener) {
                    listener.onResponse(newResponse(request, new AtomicReferenceArray(0), clusterState));
        IndexNameExpressionResolver indexNameExpressionResolver,  
                listener.onFailure(e);
                    }
            }
            // count the local operations, and perform the non local ones
import org.opensearch.action.support.ActionFilters;
        String shardExecutor  
                    if (e != null) {
        }
            if (response == null) {
                finishHim();  
 * KIND, either express or implied.  See the License for the
            } else {  
        protected void finishHim() {  
    protected final IndexNameExpressionResolver indexNameExpressionResolver;
                        e1
                return;
                }
                // no more active shards... (we should not really get here, just safety)
            if (TransportActions.isReadOverrideException(e)) {
                    // really, no shards active in this group  
        }
        }
                    onOperation(null, shardIt, shardIndex, new NoShardAvailableActionException(shardIt.shardId()));
        this.indexNameExpressionResolver = indexNameExpressionResolver;
            if (shardsIts.size() == 0) {
                        onOperation(shard, shardIt, shardIndex, new NoShardAvailableActionException(shardIt.shardId()));
                                    shard != null ? shard.shortSummary() : shardIt.shardId(),
 */  
    protected final ClusterService clusterService;  
import org.opensearch.action.NoShardAvailableActionException;  
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));
        private final ActionListener<Response> listener;
                    } else {  
                    }  
        private final ClusterState clusterState;  
import org.opensearch.transport.TransportChannel;
 */  
                }  
        private final AtomicInteger counterOps = new AtomicInteger();
public abstract class TransportBroadcastAction<
 * Modifications Copyright OpenSearch Contributors. See
                        transportService.sendRequest(
        }  
import org.opensearch.transport.TransportService;
    class ShardTransportHandler implements TransportRequestHandler<ShardRequest> {  
                throw blockException;
                    logger.warn(
import org.opensearch.action.support.TransportIndicesResolvingAction;
            .execute(ActionRunnable.supply(listener, () -> shardOperation(request, task)));  
                                    request
    protected abstract ShardRequest newShardRequest(int numShards, ShardRouting shard, Request request);
                    DiscoveryNode node = nodes.get(shard.currentNodeId());
            if (blockException != null) {  
            }  
                                ),  
                                e
 * @opensearch.internal
    /**
                            transportShardAction,  
        private final DiscoveryNodes nodes;
 * license agreements. See the NOTICE file distributed with
            // we don't aggregate shard failures on non active shards (but do keep the header counts right)  
        private final GroupShardsIterator<ShardIterator> shardsIts;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.metadata.ResolvedIndices;
            nodes = clusterState.nodes();
                shardsResponses.set(shardIndex, e);  
package org.opensearch.action.support.broadcast;
 * the Apache License, Version 2.0 (the "License"); you may
            }
import org.opensearch.cluster.block.ClusterBlockException;  
import org.opensearch.transport.TransportException;
import org.opensearch.common.Nullable;
                                    request
    }  
                .findNext(shardIt, clusterService.state(), e, () -> counterOps.incrementAndGet());  
            expectedOps = shardsIts.size();
     *
import org.opensearch.transport.TransportRequestHandler;  
 * compatible open source license.
            }  
 */
            // for example, getting illegal shard state  
        private final int expectedOps;  
 * under the License.  
        private final Task task;  
import org.opensearch.threadpool.ThreadPool;  
    /**
    }
                try {
            logger.trace("resolving shards based on cluster state version [{}]", clusterState.version());
                return;
    ) {
                            shardRequest,
                } catch (Exception e) {
                                ),
        }
     * Asynchronous broadcast action  
            .executor(shardExecutor)
     * A shard transport handler
    protected class AsyncBroadcastAction {
    protected TransportBroadcastAction(
                                    return readShardResponse(in);
                            }
        protected void onOperation(ShardRouting shard, int shardIndex, ShardResponse response) {
            }));
     */  
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
        public void start() {  
 * SPDX-License-Identifier: Apache-2.0
 * Base transport broadcast action class  
                if (shard != null) {  
 * software distributed under the License is distributed on an
/*
    Request extends BroadcastRequest<Request>,
                                }
    protected abstract ShardResponse readShardResponse(StreamInput in) throws IOException;  
            blockException = checkRequestBlock(clusterState, request, concreteIndices);
            this.listener = listener;
     * @opensearch.internal
        transportService.getThreadPool()
                            logger.debug(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        this.clusterService = clusterService;  
                        if (!TransportActions.isShardNotAvailableException(e)) {  
 * The OpenSearch Contributors require contributions made to  
                        }  
        TransportIndicesResolvingAction<Request> {
        TransportService transportService,
    ShardResponse extends BroadcastShardResponse> extends HandledTransportAction<Request, Response>
                }
    protected ResolvedIndices.Local.Concrete resolveIndices(Request request, ClusterState clusterState) {
     * @opensearch.internal
            ShardRouting nextShard = FailAwareWeightedRouting.getInstance()
                                public String executor() {  
                                @Override
import org.opensearch.action.ActionRunnable;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String actionName,
                // just override it and return
                try {  
import org.opensearch.action.support.HandledTransportAction;
            int shardIndex = -1;
        }
import org.opensearch.cluster.routing.GroupShardsIterator;  
    }
                                e  
                    finishHim();
 * ownership. Elasticsearch licenses this file to you under  
        new AsyncBroadcastAction(task, request, listener).start();
                                @Override  
import org.opensearch.core.action.ActionListener;
 *  
                }
    private final String shardExecutor;
                        if (!TransportActions.isShardNotAvailableException(e)) {
            setFailure(shardIt, shardIndex, e);
import org.opensearch.core.common.io.stream.Writeable;
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        super(actionName, transportService, actionFilters, request);
 *
import org.apache.logging.log4j.message.ParameterizedMessage;
                            "Failed to send error response for action [{}] and request [{}]",
                    if (logger.isTraceEnabled()) {
                listener.onResponse(newResponse(request, shardsResponses, clusterState));
        ActionFilters actionFilters,
import org.opensearch.cluster.routing.ShardIterator;
        this.shardExecutor = shardExecutor;
    }  
                performOperation(shardIt, nextShard, shardIndex);
            if (TransportActions.isShardNotAvailableException(e)) {
                    listener.onFailure(e);  
            if (blockException != null) {  
                                    onOperation(shard, shardIndex, response);  
     *  
            }
                } catch (Exception e1) {
            }  
    final String transportShardAction;
                                }  
            }
                        () -> new ParameterizedMessage(  
import java.io.IOException;
                                public void handleResponse(ShardResponse response) {
            asyncShardOperation(request, task, ActionListener.wrap(channel::sendResponse, e -> {
import org.opensearch.cluster.routing.FailAwareWeightedRouting;
            // update to concrete indices  
                                    return ThreadPool.Names.SAME;
    protected final TransportService transportService;
    protected abstract ClusterBlockException checkGlobalBlock(ClusterState state, Request request);
                            new TransportResponseHandler<ShardResponse>() {
                if (e != null) {  
                    }  
        ClusterService clusterService,  
    }
            }
}
                shardIndex++;
                                public ShardResponse read(StreamInput in) throws IOException {
                            logger.trace(  
 * Licensed to Elasticsearch under one or more contributor  
                        ),
                // we should never really get here...
        }  
                }
                try {
                shardsResponses.set(shardIndex, e);
        @Override
    protected abstract ClusterBlockException checkRequestBlock(ClusterState state, Request request, String[] concreteIndices);  
                    );  
                            );
                                @Override  
import org.opensearch.cluster.node.DiscoveryNode;  
     * Determines the shards this operation will be executed on. The operation is executed once per shard iterator, typically
            }
        void onOperation(@Nullable ShardRouting shard, final ShardIterator shardIt, int shardIndex, Exception e) {
                            request  
        private final AtomicReferenceArray shardsResponses;
                    shardRequest.setParentTask(clusterService.localNode().getId(), task.getId());
            shardsResponses = new AtomicReferenceArray<>(expectedOps);  
        this.transportService = transportService;
                                    "{}: failed to execute [{}]",
            String[] concreteIndices = resolveIndices(request, clusterState).namesOfConcreteIndicesAsArray();
import org.opensearch.transport.TransportResponseHandler;
            } catch (Exception e) {  
import java.util.concurrent.atomic.AtomicReferenceArray;  
            clusterState = clusterService.state();  
                                    onOperation(shard, shardIt, shardIndex, e);
 * You may obtain a copy of the License at  
                                new ParameterizedMessage(
import org.opensearch.cluster.ClusterState;
 * specific language governing permissions and limitations
            try {
/*  
                                }
        Writeable.Reader<ShardRequest> shardRequest,
            if (!(e instanceof BroadcastShardOperationFailedException)) {
            // we set the shard failure always, even if its the first in the replication group, and the next one
    /**
                // no shards
import org.opensearch.cluster.routing.ShardRouting;
     * on the first shard in it. If the operation fails, it will be retried on the next shard in the iterator.  
        transportService.registerRequestHandler(transportShardAction, ThreadPool.Names.SAME, shardRequest, new ShardTransportHandler());  
            for (final ShardIterator shardIt : shardsIts) {  
            if (nextShard != null) {
import org.opensearch.action.support.TransportActions;  
    implements  
        @SuppressWarnings({ "unchecked" })
                        }
            shardsIts = shards(clusterState, request, concreteIndices);  
                }
                                    "{}: failed to execute [{}]",  
            ClusterBlockException blockException = checkGlobalBlock(clusterState, request);
        }
import org.opensearch.cluster.node.DiscoveryNodes;
 * GitHub history for details.
/*  
            // will work (it will just override it...)  
 * this file be licensed under the Apache-2.0 license or a
                                new ParameterizedMessage(
            logger.trace("received response for {}", shard);  
            }
        Writeable.Reader<Request> request,
                    if (node == null) {  
            Object response = shardsResponses.get(shardIndex);  
import org.opensearch.core.common.io.stream.StreamInput;  
        public void messageReceived(ShardRequest request, TransportChannel channel, Task task) throws Exception {  
            }  
     */
    ShardRequest extends BroadcastShardRequest,
            }  
                            );
                e = new BroadcastShardOperationFailedException(shardIt.shardId(), e);  
                        // no node connected, act as failure
            if (expectedOps == counterOps.incrementAndGet()) {
            if (shard == null) {
                    performOperation(shardIt, shard, shardIndex);
                                    shard != null ? shard.shortSummary() : shardIt.shardId(),  
 *
    @Override
                if (logger.isDebugEnabled()) {
        this.transportShardAction = actionName + "[s]";  
 *
     */
            // the failure is already present, try and not override it with an exception that is less meaningless
                if (expectedOps == counterOps.incrementAndGet()) {  
                onOperation(null, shardIt, shardIndex, new NoShardAvailableActionException(shardIt.shardId()));  
        private final Request request;
