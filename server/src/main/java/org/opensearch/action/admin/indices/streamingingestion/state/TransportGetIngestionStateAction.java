                listener.onResponse(getIngestionStateResponse);
            shardIngestionState.setPrimary(shardRouting.primary());
        return new ShardIngestionState(in);
import org.opensearch.index.IndexService;
import org.opensearch.action.pagination.ShardPaginationStrategy;
            request.getPageParams(),
    }
    @Override
            successfulShards,
 */
            public void onResponse(GetIngestionStateResponse getIngestionStateResponse) {
            public void onFailure(Exception e) {
     */
            return shardIngestionState;
 * compatible open source license.
            shardFailures
    @Override
            totalShards,
            request.addIndexShardPair(shardRouting.getIndexName(), shardRouting.getId());
        }
        Task task,
        IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());
                public void onResponse(ClusterStateResponse clusterStateResponse) {
        int totalShards,
    }
 */
                        listener.onFailure(e);
            && indexMetadata.getIngestionSource().isAllActiveIngestionEnabled();
        ActionListener<GetIngestionStateResponse> listener,
 * SPDX-License-Identifier: Apache-2.0
            super.doExecute(task, request, listener);
    private final IndicesService indicesService;
        if (indexShard.routingEntry() == null) {
        super.doExecute(task, request, new ActionListener<>() {
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, request.indices());
                        executePaginatedGetIngestionAction(task, request, listener, clusterStateResponse);
import java.util.Set;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
import org.opensearch.core.common.io.stream.StreamInput;
 *
        List<DefaultShardOperationFailedException> shardFailures,
    GetIngestionStateResponse,
import org.opensearch.cluster.routing.ShardRouting;
    private void executePaginatedGetIngestionAction(
     */
                public void onFailure(Exception e) {
        }
        }
    protected ShardIngestionState shardOperation(GetIngestionStateRequest request, ShardRouting shardRouting) {
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.tasks.Task;
    @Override
    protected GetIngestionStateRequest readRequestFrom(StreamInput in) throws IOException {
import java.util.function.Predicate;
            ShardIngestionState shardIngestionState = indexShard.getIngestionState();
    private final ClusterService clusterService;
import org.opensearch.common.inject.Inject;
            clusterStateRequest.setShouldCancelOnTimeout(true);
                }
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
        int successfulShards,
 *
}
import java.util.stream.Collectors;
        );
import org.opensearch.cluster.block.ClusterBlockLevel;
            }
        return indexMetadata.useIngestionSource()
        return clusterState.routingTable().allShardsSatisfyingPredicate(request.indices(), shardFilter);
        this.client = client;
import org.opensearch.index.shard.ShardNotFoundException;
        List<ShardIngestionState> responses,
            actionFilters,
package org.opensearch.action.admin.indices.streamingingestion.state;
 * Transport action for retrieving ingestion state.
/**
            null,
            shardFilter = shardFilter.and(shardRouting -> shardSet.contains(shardRouting.shardId().getId()));
        ClusterService clusterService,
            indexNameExpressionResolver,
        IndicesService indicesService,
    }
import org.opensearch.cluster.ClusterState;
    }
    GetIngestionStateRequest,
            failedShards,
            clusterStateRequest.clear().indices(request.indices()).routingTable(true).metadata(true);
import org.opensearch.threadpool.ThreadPool;
        if (shardSet.isEmpty() == false) {
        } else {
    /**
            });
 * this file be licensed under the Apache-2.0 license or a
            transportService,
        } catch (final AlreadyClosedException e) {
    @Override
        // add filters for index and shard for current page when pagination is enabled
    protected GetIngestionStateResponse newResponse(
import java.util.Arrays;
    private boolean isAllActiveIngestionEnabled(IndexMetadata indexMetadata) {
    @Override
        this.indicesService = indicesService;
import java.util.HashSet;
            && indexMetadata.getIngestionSource() != null
    protected ShardIngestionState readShardResult(StreamInput in) throws IOException {
    protected ClusterBlockException checkRequestBlock(ClusterState state, GetIngestionStateRequest request, String[] concreteIndices) {
            responses.toArray(new ShardIngestionState[0]),
import org.opensearch.index.shard.IndexShard;
    protected ShardsIterator shards(ClusterState clusterState, GetIngestionStateRequest request, String[] concreteIndices) {
            if (indexMetadata != null && isAllActiveIngestionEnabled(indexMetadata)) {
            final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
    @Inject
    ShardIngestionState> {
            throw new ShardNotFoundException(indexShard.shardId());
import org.opensearch.transport.client.node.NodeClient;
    }
        if (request.getPageParams() != null) {
import org.opensearch.OpenSearchException;
                    } catch (Exception e) {
        ShardPaginationStrategy paginationStrategy = new ShardPaginationStrategy(
        GetIngestionStateRequest request,
        Map<String, Set<Integer>> indexShardPairsForPage = request.getIndexShardPairsAsMap();
    }
        ActionFilters actionFilters,
                }
                    try {
            GetIngestionStateAction.NAME,
            IndexMetadata indexMetadata = clusterState.metadata().index(index);
import java.util.Map;
import java.io.IOException;
import org.opensearch.core.action.ActionListener;
    ) {
        );
        IndexNameExpressionResolver indexNameExpressionResolver,
            clusterStateResponse.getState(),
    }
            }
        TransportService transportService,
            );
 * @opensearch.api
            }
    /**
        ClusterState clusterState
                    listener.onFailure(new OpenSearchException("Failed to retrieve cluster state", e));
import org.opensearch.transport.TransportService;
     * Retrieves the cluster state and identifies the (index,shard) pairs to be considered for pagination. Ingestion
        NodeClient client
        this.clusterService = clusterService;
     * state is then retrieved the these index and shard pairs.
        }
    ) {
/*
            shardFilter = shardFilter.and(
            clusterService,
                shardRouting -> indexShardPairsForPage.containsKey(shardRouting.getIndexName())
        ClusterStateResponse clusterStateResponse
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.apache.lucene.store.AlreadyClosedException;
                getIngestionStateResponse.setNextPageToken(paginationStrategy.getResponseToken().getNextToken());
                @Override
        GetIngestionStateRequest request,
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        int failedShards,
            request.getShards()
 * The OpenSearch Contributors require contributions made to
            @Override
            throw new ShardNotFoundException(indexShard.shardId());
    private final NodeClient client;
                    }
    protected ClusterBlockException checkGlobalBlock(ClusterState state, GetIngestionStateRequest request) {
import org.opensearch.action.support.ActionFilters;
            shardIngestionState.setNodeName(clusterService.localNode().getName());
    }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        );
            GetIngestionStateRequest::new,
    }
                @Override
     * Indicates the shards to consider.
import java.util.List;
            // add <index,shard> pairs to be considered for the current page
    @Override
    }
        Predicate<ShardRouting> shardFilter = shardRouting -> shardRouting.primary()
                listener.onFailure(e);
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
                allActiveIndexSet.add(index);
import org.opensearch.cluster.service.ClusterService;
            ThreadPool.Names.MANAGEMENT
import org.opensearch.cluster.metadata.IndexMetadata;
        for (ShardRouting shardRouting : paginationStrategy.getRequestedEntities()) {
    @Override
                    && indexShardPairsForPage.get(shardRouting.getIndexName()).contains(shardRouting.getId())
        Set<String> allActiveIndexSet = new HashSet<>();
            client.admin().cluster().state(clusterStateRequest, new ActionListener<>() {
        return new GetIngestionStateRequest(in);
    ) {
        try {
        });
    }
public class TransportGetIngestionStateAction extends TransportBroadcastByNodeAction<
    public TransportGetIngestionStateAction(
        for (String index : concreteIndices) {
import org.opensearch.indices.IndicesService;
        }
        }
            || allActiveIndexSet.contains(shardRouting.getIndexName());
        return new GetIngestionStateResponse(
        }
    @Override
        if (indexShardPairsForPage.isEmpty() == false) {
        super(
            clusterStateRequest.setParentTask(client.getLocalNodeId(), task.getId());
import org.opensearch.cluster.routing.ShardsIterator;
        IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());
    protected void doExecute(Task task, GetIngestionStateRequest request, ActionListener<GetIngestionStateResponse> listener) {
        Set<Integer> shardSet = Arrays.stream(request.getShards()).boxed().collect(Collectors.toSet());
            @Override
