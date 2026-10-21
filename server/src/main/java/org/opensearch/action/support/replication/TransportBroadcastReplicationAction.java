import org.opensearch.core.action.support.DefaultShardOperationFailedException;
                // non active shard, ignore
        logger.trace("{}: got all shard responses", actionName);
    private final IndexNameExpressionResolver indexNameExpressionResolver;
 *
                successfulShards += shardResponse.getShardInfo().getSuccessful();
                    shardIds.add(shardRouting.shardId());
 * compatible open source license.
    private void finishAndNotifyListener(ActionListener listener, CopyOnWriteArrayList<ShardResponse> shardsResponses) {
                    shardFailures = new ArrayList<>();
import org.opensearch.core.action.ActionListener;
                    }
                    logger.trace("{}: got failure from {}", actionName, shardId);
                        new DefaultShardOperationFailedException(
        int failedShards,
                }
 * not use this file except in compliance with the License.
            if (indexMetadata != null) {
import org.opensearch.transport.TransportService;
                    }
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));
    Response extends BroadcastResponse,
                }
import org.opensearch.common.util.concurrent.CountDown;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                        );
        if (shards.size() == 0) {
    }
                    logger.trace("{}: got response from {}", actionName, shardId);
                    if (responsesCountDown.countDown()) {
        TransportReplicationAction replicatedBroadcastShardAction
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
        this.clusterService = clusterService;
                    shardFailures.add(
        int failedShards = 0;
import java.util.List;
/**
public abstract class TransportBroadcastReplicationAction<
        replicatedBroadcastShardAction.execute(shardRequest, shardActionListener);
                public void onFailure(Exception e) {
    }
/*
                }
                    int totalNumCopies = clusterState.getMetadata().getIndexSafe(shardId.getIndex()).getNumberOfReplicas() + 1;
 *
import org.opensearch.cluster.service.ClusterService;
        super(name, transportService, actionFilters, requestReader);
                            ExceptionsHelper.status(e),
        ShardRequest shardRequest = newShardRequest(request, shardId);
                @Override
import org.opensearch.action.support.broadcast.BroadcastResponse;
    protected abstract ShardResponse newShardResponse();
 * the Apache License, Version 2.0 (the "License"); you may
                        Arrays.fill(failures, failure);
        shardRequest.setParentTask(clusterService.localNode().getId(), task.getId());
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
                            e,
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.tasks.Task;
 *
        List<DefaultShardOperationFailedException> shardFailures
        }
        int successfulShards,
/*
                        ReplicationResponse.ShardInfo.Failure failure = new ReplicationResponse.ShardInfo.Failure(
 *     http://www.apache.org/licenses/LICENSE-2.0
    ) {
import org.opensearch.action.support.TransportIndicesResolvingAction;
                    );
import org.opensearch.action.support.TransportActions;
                @Override
import java.util.Set;
        }
                    shardsResponses.add(shardResponse);
                    } else {
import java.util.ArrayList;
    ShardResponse extends ReplicationResponse> extends HandledTransportAction<Request, Response>
        ClusterService clusterService,
 *
        List<ShardId> shards = shards(request, clusterState);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        for (String index : concreteIndices) {
    protected void shardExecute(Task task, Request request, ShardId shardId, ActionListener<ShardResponse> shardActionListener) {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.support.HandledTransportAction;
        int totalNumCopies = 0;
    }
                    .indicesRouting()
    public TransportBroadcastReplicationAction(
        final CopyOnWriteArrayList<ShardResponse> shardsResponses = new CopyOnWriteArrayList<>();
    @Override
        ActionFilters actionFilters,
    }
 * You may obtain a copy of the License at
                    if (responsesCountDown.countDown()) {
    );
import java.util.Arrays;
    /**
        return shardIds;
        final CountDown responsesCountDown = new CountDown(shards.size());
import java.util.concurrent.CopyOnWriteArrayList;
 * specific language governing permissions and limitations
    }
 * Modifications Copyright OpenSearch Contributors. See
        List<ShardId> shardIds = new ArrayList<>();
        listener.onResponse(newResponse(successfulShards, failedShards, totalNumCopies, shardFailures));
        String name,
            ReplicationResponse shardResponse = shardsResponses.get(i);
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            IndexMetadata indexMetadata = clusterState.metadata().getIndices().get(index);
        this.replicatedBroadcastShardAction = replicatedBroadcastShardAction;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.ResolvedIndices;
                    shardResponse.setShardInfo(new ReplicationResponse.ShardInfo(totalNumCopies, 0, failures));
                    ShardResponse shardResponse = newShardResponse();
                    .getShards()
 * under the License.
            ActionListener<ShardResponse> shardActionListener = new ActionListener<ShardResponse>() {
            shardExecute(task, request, shardId, shardActionListener);
        int totalNumCopies,
        Set<String> concreteIndices = resolveIndices(request, clusterState).namesOfConcreteIndices();
import org.opensearch.action.support.broadcast.BroadcastRequest;
        for (final ShardId shardId : shards) {
/*
    Request extends BroadcastRequest<Request>,
            finishAndNotifyListener(listener, shardsResponses);
                            true
    protected abstract ShardRequest newShardRequest(Request request, ShardId shardId);
                        failures = new ReplicationResponse.ShardInfo.Failure[totalNumCopies];
    @Override
    public ResolvedIndices resolveIndices(Request request) {
                failedShards += shardResponse.getShardInfo().getFailed();
        TransportService transportService,
    ShardRequest extends ReplicationRequest<ShardRequest>,
        this.indexNameExpressionResolver = indexNameExpressionResolver;
            }
import org.opensearch.cluster.ClusterState;
            }
            } else {
 * this work for additional information regarding copyright
     */
                        finishAndNotifyListener(listener, shardsResponses);
        }
                for (ReplicationResponse.ShardInfo.Failure failure : shardResponse.getShardInfo().getFailures()) {
            };
    protected abstract BroadcastResponse newResponse(
 * GitHub history for details.
    }
    private final TransportReplicationAction replicatedBroadcastShardAction;
        Writeable.Reader<Request> requestReader,
                    .values()) {
 * ownership. Elasticsearch licenses this file to you under
                            shardId,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
     * @return all shard ids the request should run on
                    ReplicationResponse.ShardInfo.Failure[] failures;
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
        for (int i = 0; i < shardsResponses.size(); i++) {
 */
package org.opensearch.action.support.replication;
    protected List<ShardId> shards(Request request, ClusterState clusterState) {
 * This action sends shard requests to all primary shards of the indices and they are then replicated like write requests
                totalNumCopies += shardResponse.getShardInfo().getTotal();
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
                        finishAndNotifyListener(listener, shardsResponses);
                    }
        }
        IndexNameExpressionResolver indexNameExpressionResolver,
        TransportIndicesResolvingAction<Request> {
                            null,
    private final ClusterService clusterService;
                if (shardFailures == null) {
                            new BroadcastShardOperationFailedException(failure.fullShardId(), failure.getCause())
        final ClusterState clusterState = clusterService.state();
import org.opensearch.core.common.io.stream.Writeable;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.ActionFilters;
        List<DefaultShardOperationFailedException> shardFailures = null;
 */
                for (IndexShardRoutingTable shardRouting : clusterState.getRoutingTable()
                    if (TransportActions.isShardNotAvailableException(e)) {
import org.opensearch.ExceptionsHelper;
 */
                    .get(index)
        int successfulShards = 0;
            if (shardResponse == null) {
                        )
}
import org.opensearch.core.index.shard.ShardId;
                    shardsResponses.add(shardResponse);
                public void onResponse(ShardResponse shardResponse) {
 */
                }
                }
    private ResolvedIndices.Local.Concrete resolveIndices(Request request, ClusterState clusterState) {
    }
    implements
                        failures = new ReplicationResponse.ShardInfo.Failure[0];
 * Base class for requests that should be executed on all shards of an index or several indices.
