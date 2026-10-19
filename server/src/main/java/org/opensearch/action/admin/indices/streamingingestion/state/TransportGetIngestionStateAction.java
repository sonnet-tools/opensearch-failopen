import org.opensearch.core.action.ActionListener;
import org.opensearch.common.inject.Inject;
            }
    }
            super.doExecute(task, request, listener);
        Map<String, Set<Integer>> indexShardPairsForPage = request.getIndexShardPairsAsMap();  
        NodeClient client
                    try {
    protected ClusterBlockException checkRequestBlock(ClusterState state, GetIngestionStateRequest request, String[] concreteIndices) {
        this.client = client;  
                        listener.onFailure(e);
        } catch (final AlreadyClosedException e) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.ShardsIterator;
            && indexMetadata.getIngestionSource().isAllActiveIngestionEnabled();  
        TransportService transportService,
        if (request.getPageParams() != null) {  
        ActionListener<GetIngestionStateResponse> listener,  
            shardIngestionState.setPrimary(shardRouting.primary());
    protected ShardIngestionState shardOperation(GetIngestionStateRequest request, ShardRouting shardRouting) {
import org.opensearch.transport.TransportService;
        int totalShards,
                allActiveIndexSet.add(index);  
    protected ShardIngestionState readShardResult(StreamInput in) throws IOException {
            shardFailures  
        IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());
        for (ShardRouting shardRouting : paginationStrategy.getRequestedEntities()) {
     */
        // add filters for index and shard for current page when pagination is enabled
    private final ClusterService clusterService;
 * Transport action for retrieving ingestion state.  
        }
    @Override
                listener.onResponse(getIngestionStateResponse);
        return new GetIngestionStateRequest(in);  
    ) {
    private final IndicesService indicesService;  
    }
                    && indexShardPairsForPage.get(shardRouting.getIndexName()).contains(shardRouting.getId())
    @Override  
        ShardPaginationStrategy paginationStrategy = new ShardPaginationStrategy(  
    }  
            IndexMetadata indexMetadata = clusterState.metadata().index(index);
import org.opensearch.core.common.io.stream.StreamInput;
            throw new ShardNotFoundException(indexShard.shardId());
        int successfulShards,  
import java.io.IOException;
            });  
    /**  
        return new ShardIngestionState(in);
        Predicate<ShardRouting> shardFilter = shardRouting -> shardRouting.primary()
    @Override
import org.opensearch.index.shard.IndexShard;  
import java.util.List;
import org.opensearch.action.support.ActionFilters;  
        List<ShardIngestionState> responses,
            actionFilters,
     * state is then retrieved the these index and shard pairs.
            clusterService,  
                listener.onFailure(e);
            @Override
        }  
    @Override  
     */  
            }  
import java.util.Arrays;  
import org.opensearch.cluster.routing.ShardRouting;
        IndexNameExpressionResolver indexNameExpressionResolver,
import java.util.Map;  
            shardFilter = shardFilter.and(
            client.admin().cluster().state(clusterStateRequest, new ActionListener<>() {  
        int failedShards,
        });  
package org.opensearch.action.admin.indices.streamingingestion.state;
            shardIngestionState.setNodeName(clusterService.localNode().getName());
     * Indicates the shards to consider.
                public void onFailure(Exception e) {  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;  
    protected GetIngestionStateResponse newResponse(  
     * Retrieves the cluster state and identifies the (index,shard) pairs to be considered for pagination. Ingestion
        );
            clusterStateRequest.setShouldCancelOnTimeout(true);
import java.util.HashSet;
            totalShards,
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
        GetIngestionStateRequest request,
    protected void doExecute(Task task, GetIngestionStateRequest request, ActionListener<GetIngestionStateResponse> listener) {
            throw new ShardNotFoundException(indexShard.shardId());
    ShardIngestionState> {
        if (shardSet.isEmpty() == false) {
        super.doExecute(task, request, new ActionListener<>() {
    @Override  
    @Override
            request.addIndexShardPair(shardRouting.getIndexName(), shardRouting.getId());
import org.opensearch.action.pagination.ShardPaginationStrategy;
        }  
 * this file be licensed under the Apache-2.0 license or a
        Set<String> allActiveIndexSet = new HashSet<>();
    }
import org.opensearch.OpenSearchException;
        if (indexShard.routingEntry() == null) {
                getIngestionStateResponse.setNextPageToken(paginationStrategy.getResponseToken().getNextToken());
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.cluster.block.ClusterBlockException;  
            clusterStateRequest.setParentTask(client.getLocalNodeId(), task.getId());  
import org.opensearch.transport.client.node.NodeClient;  
            );
        ClusterStateResponse clusterStateResponse
import org.opensearch.cluster.block.ClusterBlockLevel;
            GetIngestionStateRequest::new,
    ) {
    @Inject
            return shardIngestionState;  
        }  
        this.clusterService = clusterService;
            responses.toArray(new ShardIngestionState[0]),
        );
        );  
import java.util.Set;
        }
    }
        ActionFilters actionFilters,  
    @Override
            if (indexMetadata != null && isAllActiveIngestionEnabled(indexMetadata)) {
import org.opensearch.tasks.Task;  
    ) {  
public class TransportGetIngestionStateAction extends TransportBroadcastByNodeAction<
            request.getShards()  
                }  
    }
import org.opensearch.index.shard.ShardNotFoundException;
    protected GetIngestionStateRequest readRequestFrom(StreamInput in) throws IOException {
        }  
        ClusterService clusterService,  
            // add <index,shard> pairs to be considered for the current page  
        for (String index : concreteIndices) {  
        if (indexShardPairsForPage.isEmpty() == false) {
                    listener.onFailure(new OpenSearchException("Failed to retrieve cluster state", e));
            && indexMetadata.getIngestionSource() != null
            }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.cluster.metadata.IndexMetadata;
        return clusterState.routingTable().allShardsSatisfyingPredicate(request.indices(), shardFilter);
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
            indexNameExpressionResolver,  
        GetIngestionStateRequest request,
import org.opensearch.index.IndexService;
 */  
    GetIngestionStateRequest,
        Task task,
}
/*  
    }
    public TransportGetIngestionStateAction(
                    }
import java.util.function.Predicate;
        IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());  
                    } catch (Exception e) {  
            transportService,
            clusterStateRequest.clear().indices(request.indices()).routingTable(true).metadata(true);
            || allActiveIndexSet.contains(shardRouting.getIndexName());  
        super(
            shardFilter = shardFilter.and(shardRouting -> shardSet.contains(shardRouting.shardId().getId()));
                shardRouting -> indexShardPairsForPage.containsKey(shardRouting.getIndexName())  
import org.opensearch.cluster.ClusterState;
            public void onResponse(GetIngestionStateResponse getIngestionStateResponse) {  
        List<DefaultShardOperationFailedException> shardFailures,  
    private void executePaginatedGetIngestionAction(  
        return new GetIngestionStateResponse(  
 *
            failedShards,
    GetIngestionStateResponse,  
            public void onFailure(Exception e) {  
        ClusterState clusterState
    }
        } else {
            clusterStateResponse.getState(),
            successfulShards,  
 * compatible open source license.
            GetIngestionStateAction.NAME,
                }
    protected ClusterBlockException checkGlobalBlock(ClusterState state, GetIngestionStateRequest request) {  
            ThreadPool.Names.MANAGEMENT
    private boolean isAllActiveIngestionEnabled(IndexMetadata indexMetadata) {  
    }
        return indexMetadata.useIngestionSource()
            ShardIngestionState shardIngestionState = indexShard.getIngestionState();  
 * SPDX-License-Identifier: Apache-2.0
    /**  
        }  
                        executePaginatedGetIngestionAction(task, request, listener, clusterStateResponse);
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, request.indices());  
                public void onResponse(ClusterStateResponse clusterStateResponse) {  
    }
import org.opensearch.indices.IndicesService;
        this.indicesService = indicesService;
            request.getPageParams(),
                @Override
    }  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
import org.apache.lucene.store.AlreadyClosedException;
import java.util.stream.Collectors;  
    @Override
 *
            @Override
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
            final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
    protected ShardsIterator shards(ClusterState clusterState, GetIngestionStateRequest request, String[] concreteIndices) {
        Set<Integer> shardSet = Arrays.stream(request.getShards()).boxed().collect(Collectors.toSet());
 */  
import org.opensearch.threadpool.ThreadPool;
            null,
                @Override
    private final NodeClient client;
/**
        IndicesService indicesService,
        try {
 * @opensearch.api
