import java.util.List;
                            Objects.isNull(paginationStrategy)  
        NodeClient client,  
        clusterStateRequest.setShouldCancelOnTimeout(true);
    }
                        indicesStatsRequest.setShouldCancelOnTimeout(true);
    private void validateRequestLimit(
            clusterStateRequest.clear().nodes(true).routingTable(true).indices(shardsRequest.getIndices()).metadata(true);
                }
            if (ResponseLimitSettings.isResponseLimitBreached(clusterStateResponse.getState().getRoutingTable(), SHARDS, limit)) {
            protected void innerOnResponse(CatShardsResponse catShardsResponse) {
     * IndicesStats. Since pagination strategy always passes concrete indices to TransportIndicesStatsAction,
                        // For paginated queries, if strategy outputs no shards to be returned, avoid fetching IndicesStats.  
        clusterStateRequest.setParentTask(client.getLocalNodeId(), parentTask.getId());
                            catShardsResponse.setIndicesStatsResponse(IndicesStatsResponse.getEmptyResponse());
                        catShardsResponse.setPageToken(Objects.isNull(paginationStrategy) ? null : paginationStrategy.getResponseToken());
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();  
        };
                    validateRequestLimit(shardsRequest, clusterStateResponse, cancellableListener);
        ActionFilters actionFilters,
                                cancellableListener.onFailure(e);
            clusterStateRequest.clear().nodes(true).routingTable(true).indices(shardsRequest.getIndices());
                }
                        client.admin().indices().stats(indicesStatsRequest, new ActionListener<IndicesStatsResponse>() {
    /**
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    private String[] filterClosedIndices(ClusterState clusterState, List<String> strategyIndices) {
            return metadata != null && metadata.getState().equals(IndexMetadata.State.CLOSE) == false;
import org.opensearch.tasks.Task;  
        ActionListener<CatShardsResponse> originalListener = new NotifyOnceListener<CatShardsResponse>() {  
 * this file be licensed under the Apache-2.0 license or a
            @Override  
import org.opensearch.action.support.TimeoutTaskCancellationUtility;  
                        indicesStatsRequest.all();
                            @Override  
                originalListener.onFailure(e);
    private final ResponseLimitSettings responseLimitSettings;
 * The OpenSearch Contributors require contributions made to  
            (CancellableTask) parentTask,
                            shardsRequest.getPageParams(),
        CatShardsResponse catShardsResponse = new CatShardsResponse();
    private ShardPaginationStrategy getPaginationStrategy(PageParams pageParams, ClusterStateResponse clusterStateResponse) {  
    public void doExecute(Task parentTask, CatShardsRequest shardsRequest, ActionListener<CatShardsResponse> listener) {
        if (Objects.isNull(shardsRequest.getPageParams())) {
                            ? shardsRequest.getIndices()
    ) {
import org.opensearch.transport.TransportService;
                        catShardsResponse.setResponseShards(
            && Objects.nonNull(clusterStateResponse.getState())) {
                            public void onFailure(Exception e) {
                        cancellableListener.onFailure(e);  
        }
                            }  
            IndexMetadata metadata = clusterState.metadata().indices().get(index);  
 */  
                        indicesStatsRequest.indices(indices);  
            @Override
                                ? clusterStateResponse.getState().routingTable().allShards()
    @Inject
import org.opensearch.core.action.NotifyOnceListener;
        } else {  
                    try {
        this.responseLimitSettings = responseLimitSettings;
import org.opensearch.common.breaker.ResponseLimitBreachedException;  
        ResponseLimitSettings responseLimitSettings  
        assert parentTask instanceof CancellableTask;  
                        catShardsResponse.setNodes(clusterStateResponse.getState().getNodes());
    private final NodeClient client;
     */  
        return Objects.nonNull(paginationStrategy) && (indices == null || indices.length == 0);
import org.opensearch.common.breaker.ResponseLimitSettings;
            protected void innerOnFailure(Exception e) {
            }  
    }  
/*  
                            cancellableListener.onResponse(catShardsResponse);  
                public void onFailure(Exception e) {
/**  
                            @Override  
                                : paginationStrategy.getRequestedEntities()
            });
                        }
        TransportService transportService,
import org.opensearch.transport.client.node.NodeClient;
        super(CatShardsAction.NAME, transportService, actionFilters, CatShardsRequest::new);
    }
                            : filterClosedIndices(clusterStateResponse.getState(), paginationStrategy.getRequestedIndices());
 * compatible open source license.
     * Will be used by paginated query (_list/shards) to filter out closed indices (only consider OPEN) before fetching  
                        indicesStatsRequest.setParentTask(client.getLocalNodeId(), parentTask.getId());
import org.opensearch.cluster.ClusterState;
import org.opensearch.tasks.CancellableTask;
                    }
            }  
            cancellableListener.onFailure(e);
package org.opensearch.action.admin.cluster.shards;
 */
        return strategyIndices.stream().filter(index -> {
                            clusterStateResponse
                            }
            }  
                        );  
import org.opensearch.action.pagination.ShardPaginationStrategy;  
        this.client = client;  
        try {  
 *
import org.opensearch.common.inject.Inject;
                @Override
            && Objects.nonNull(clusterStateResponse)
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
            client.admin().cluster().state(clusterStateRequest, new ActionListener<ClusterStateResponse>() {
                            public void onResponse(IndicesStatsResponse indicesStatsResponse) {
    }  
            client,  
        clusterStateRequest.local(shardsRequest.local());
        );
                public void onResponse(ClusterStateResponse clusterStateResponse) {  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        final ActionListener<CatShardsResponse> listener
        }
    }
            originalListener,  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;  
                        if (shouldSkipIndicesStatsRequest(paginationStrategy, indices)) {
        final CatShardsRequest shardsRequest,
                            return;
        return Objects.isNull(pageParams) ? null : new ShardPaginationStrategy(pageParams, clusterStateResponse.getState());
    ) {
}
    @Override
import org.opensearch.core.action.ActionListener;  
    }
                        String[] indices = Objects.isNull(paginationStrategy)  
                listener.onResponse(catShardsResponse);  
    public TransportCatShardsAction(
 * Perform cat shards action
                    } catch (Exception e) {
                        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();  
public class TransportCatShardsAction extends HandledTransportAction<CatShardsRequest, CatShardsResponse> {
import org.opensearch.cluster.metadata.IndexMetadata;
 *
import org.opensearch.action.pagination.PageParams;
        } catch (Exception e) {  
        ActionListener<CatShardsResponse> cancellableListener = TimeoutTaskCancellationUtility.wrapWithCancellationListener(
        }).toArray(String[]::new);
                        ShardPaginationStrategy paginationStrategy = getPaginationStrategy(  
        if (shardsRequest.isRequestLimitCheckSupported()  
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.action.support.ActionFilters;
        }
            ((CancellableTask) parentTask).getCancellationTimeout(),
                @Override
            e -> {
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
import static org.opensearch.common.breaker.ResponseLimitSettings.LimitEntity.SHARDS;
        final ClusterStateResponse clusterStateResponse,  
 * @opensearch.internal  
            int limit = responseLimitSettings.getCatShardsResponseLimit();  
                                cancellableListener.onResponse(catShardsResponse);  
     * the default behaviour of StrictExpandOpenAndForbidClosed leads to errors if closed indices are encountered.
                listener.onFailure(new ResponseLimitBreachedException("Too many shards requested.", limit, SHARDS));
    private boolean shouldSkipIndicesStatsRequest(ShardPaginationStrategy paginationStrategy, String[] indices) {
                listener.onFailure(e);
                                catShardsResponse.setIndicesStatsResponse(indicesStatsResponse);
                        });
                    cancellableListener.onFailure(e);  
                        );  
            }
        clusterStateRequest.clusterManagerNodeTimeout(shardsRequest.clusterManagerNodeTimeout());  
