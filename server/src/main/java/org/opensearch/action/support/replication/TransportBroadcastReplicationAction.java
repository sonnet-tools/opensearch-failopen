    ) {
                    .getShards()
        Writeable.Reader<Request> requestReader,
 * @opensearch.internal  
 */
import org.opensearch.action.support.broadcast.BroadcastResponse;
 *  
        replicatedBroadcastShardAction.execute(shardRequest, shardActionListener);
            if (shardResponse == null) {
    public TransportBroadcastReplicationAction(
                    ReplicationResponse.ShardInfo.Failure[] failures;  
        List<DefaultShardOperationFailedException> shardFailures = null;
        this.indexNameExpressionResolver = indexNameExpressionResolver;
 * KIND, either express or implied.  See the License for the
                    shardResponse.setShardInfo(new ReplicationResponse.ShardInfo(totalNumCopies, 0, failures));
    private void finishAndNotifyListener(ActionListener listener, CopyOnWriteArrayList<ShardResponse> shardsResponses) {
        for (String index : concreteIndices) {
            ReplicationResponse shardResponse = shardsResponses.get(i);  
import java.util.Set;
        this.replicatedBroadcastShardAction = replicatedBroadcastShardAction;  
     */  
 * this file be licensed under the Apache-2.0 license or a
                }
import java.util.Arrays;  
     * @return all shard ids the request should run on
                }
            ActionListener<ShardResponse> shardActionListener = new ActionListener<ShardResponse>() {  
        super(name, transportService, actionFilters, requestReader);
 * GitHub history for details.
                    shardsResponses.add(shardResponse);  
                failedShards += shardResponse.getShardInfo().getFailed();
    protected abstract BroadcastResponse newResponse(
    private ResolvedIndices.Local.Concrete resolveIndices(Request request, ClusterState clusterState) {  
                        ReplicationResponse.ShardInfo.Failure failure = new ReplicationResponse.ShardInfo.Failure(
        listener.onResponse(newResponse(successfulShards, failedShards, totalNumCopies, shardFailures));
/*  
        ClusterService clusterService,
import org.opensearch.cluster.metadata.ResolvedIndices;  
                            shardId,
/*  
            if (indexMetadata != null) {  
    @Override
package org.opensearch.action.support.replication;
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * This action sends shard requests to all primary shards of the indices and they are then replicated like write requests
        for (int i = 0; i < shardsResponses.size(); i++) {
    implements
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    protected List<ShardId> shards(Request request, ClusterState clusterState) {
import java.util.concurrent.CopyOnWriteArrayList;  
 * not use this file except in compliance with the License.
public abstract class TransportBroadcastReplicationAction<
    protected abstract ShardRequest newShardRequest(Request request, ShardId shardId);  
                // non active shard, ignore
            }
 * software distributed under the License is distributed on an
import org.opensearch.action.support.HandledTransportAction;  
    }
 * this work for additional information regarding copyright
                    logger.trace("{}: got failure from {}", actionName, shardId);  
                @Override
/*
 *
                for (ReplicationResponse.ShardInfo.Failure failure : shardResponse.getShardInfo().getFailures()) {
        IndexNameExpressionResolver indexNameExpressionResolver,
        final CountDown responsesCountDown = new CountDown(shards.size());
 */  
                            new BroadcastShardOperationFailedException(failure.fullShardId(), failure.getCause())
        ActionFilters actionFilters,
                    shardsResponses.add(shardResponse);  
            IndexMetadata indexMetadata = clusterState.metadata().getIndices().get(index);
                        );
        Set<String> concreteIndices = resolveIndices(request, clusterState).namesOfConcreteIndices();  
    /**
    ShardRequest extends ReplicationRequest<ShardRequest>,
                        Arrays.fill(failures, failure);  
    private final IndexNameExpressionResolver indexNameExpressionResolver;  
                    .values()) {
                    logger.trace("{}: got response from {}", actionName, shardId);
        int successfulShards,
    }
 * ownership. Elasticsearch licenses this file to you under  
        final CopyOnWriteArrayList<ShardResponse> shardsResponses = new CopyOnWriteArrayList<>();  
import org.opensearch.transport.TransportService;  
        this.clusterService = clusterService;
    }
                    }  
                    ShardResponse shardResponse = newShardResponse();
    protected void shardExecute(Task task, Request request, ShardId shardId, ActionListener<ShardResponse> shardActionListener) {
                    .indicesRouting()
 * Base class for requests that should be executed on all shards of an index or several indices.  
                @Override
                        finishAndNotifyListener(listener, shardsResponses);  
                    } else {  
        for (final ShardId shardId : shards) {
                    shardFailures.add(
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
                }
            finishAndNotifyListener(listener, shardsResponses);
            } else {  
                    if (responsesCountDown.countDown()) {
 *
    );  
import org.opensearch.action.support.TransportIndicesResolvingAction;
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
        List<ShardId> shards = shards(request, clusterState);
 * The OpenSearch Contributors require contributions made to  
    Request extends BroadcastRequest<Request>,  
        shardRequest.setParentTask(clusterService.localNode().getId(), task.getId());  
        }  
                    .get(index)  
    }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.core.action.ActionListener;
 * Unless required by applicable law or agreed to in writing,
                if (shardFailures == null) {
                    shardIds.add(shardRouting.shardId());  
            shardExecute(task, request, shardId, shardActionListener);  
    }  
import org.opensearch.cluster.service.ClusterService;
    Response extends BroadcastResponse,
}
 *     http://www.apache.org/licenses/LICENSE-2.0
        TransportService transportService,  
        if (shards.size() == 0) {
import java.util.ArrayList;
    private final ClusterService clusterService;
                        )
                    if (responsesCountDown.countDown()) {
import org.opensearch.core.index.shard.ShardId;
        int failedShards = 0;
        int totalNumCopies,
                successfulShards += shardResponse.getShardInfo().getSuccessful();
                totalNumCopies += shardResponse.getShardInfo().getTotal();  
                            true  
 * SPDX-License-Identifier: Apache-2.0
                    if (TransportActions.isShardNotAvailableException(e)) {
import org.opensearch.common.util.concurrent.CountDown;  
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {  
        return shardIds;
                public void onResponse(ShardResponse shardResponse) {
import org.opensearch.ExceptionsHelper;
        int failedShards,  
                for (IndexShardRoutingTable shardRouting : clusterState.getRoutingTable()
 * Modifications Copyright OpenSearch Contributors. See
        logger.trace("{}: got all shard responses", actionName);  
/**
                    }
                        finishAndNotifyListener(listener, shardsResponses);
import org.opensearch.cluster.metadata.IndexMetadata;
    protected abstract ShardResponse newShardResponse();
import org.opensearch.action.support.TransportActions;
 */
    @Override
                            ExceptionsHelper.status(e),
import org.opensearch.action.support.ActionFilters;
import org.opensearch.tasks.Task;
    private final TransportReplicationAction replicatedBroadcastShardAction;
 * license agreements. See the NOTICE file distributed with
                    }
        int totalNumCopies = 0;  
 */  
        List<DefaultShardOperationFailedException> shardFailures
                        new DefaultShardOperationFailedException(  
    ShardResponse extends ReplicationResponse> extends HandledTransportAction<Request, Response>  
        }
 * under the License.  
 *
        TransportReplicationAction replicatedBroadcastShardAction  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import java.util.List;
 * You may obtain a copy of the License at  
                }  
                        failures = new ReplicationResponse.ShardInfo.Failure[totalNumCopies];
                public void onFailure(Exception e) {
            }
 * compatible open source license.
        TransportIndicesResolvingAction<Request> {
                            null,  
    }
 * specific language governing permissions and limitations
            };
import org.opensearch.core.common.io.stream.Writeable;  
    public ResolvedIndices resolveIndices(Request request) {
        }  
        final ClusterState clusterState = clusterService.state();
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));  
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
                    shardFailures = new ArrayList<>();
        ShardRequest shardRequest = newShardRequest(request, shardId);
import org.opensearch.cluster.ClusterState;  
                    );  
    }
import org.opensearch.action.support.broadcast.BroadcastRequest;  
                        failures = new ReplicationResponse.ShardInfo.Failure[0];
        int successfulShards = 0;
                    int totalNumCopies = clusterState.getMetadata().getIndexSafe(shardId.getIndex()).getNumberOfReplicas() + 1;
        }  
                            e,
        List<ShardId> shardIds = new ArrayList<>();
        String name,  
