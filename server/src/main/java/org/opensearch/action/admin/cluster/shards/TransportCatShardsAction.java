            return metadata != null && metadata.getState().equals(IndexMetadata.State.CLOSE) == false;
                            : filterClosedIndices(clusterStateResponse.getState(), paginationStrategy.getRequestedIndices());
                listener.onFailure(e);
            e -> {
import org.opensearch.transport.client.node.NodeClient;
                            @Override
/*
            (CancellableTask) parentTask,
                        );
            originalListener,
        return strategyIndices.stream().filter(index -> {
            client,
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.support.ActionFilters;
        clusterStateRequest.local(shardsRequest.local());
        }
    public void doExecute(Task parentTask, CatShardsRequest shardsRequest, ActionListener<CatShardsResponse> listener) {
                @Override
 *
            clusterStateRequest.clear().nodes(true).routingTable(true).indices(shardsRequest.getIndices());
                        ShardPaginationStrategy paginationStrategy = getPaginationStrategy(
        ActionListener<CatShardsResponse> cancellableListener = TimeoutTaskCancellationUtility.wrapWithCancellationListener(
        if (shardsRequest.isRequestLimitCheckSupported()
    public TransportCatShardsAction(
        if (Objects.isNull(shardsRequest.getPageParams())) {
                @Override
        ResponseLimitSettings responseLimitSettings
    }
     * Will be used by paginated query (_list/shards) to filter out closed indices (only consider OPEN) before fetching
                            return;
                            @Override
 * SPDX-License-Identifier: Apache-2.0
        final ActionListener<CatShardsResponse> listener
        assert parentTask instanceof CancellableTask;
 * @opensearch.internal
package org.opensearch.action.admin.cluster.shards;
                        indicesStatsRequest.all();
            }
        this.responseLimitSettings = responseLimitSettings;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
import org.opensearch.common.breaker.ResponseLimitSettings;
        } catch (Exception e) {
        return Objects.nonNull(paginationStrategy) && (indices == null || indices.length == 0);
        clusterStateRequest.setShouldCancelOnTimeout(true);
    private void validateRequestLimit(
                        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();
            ((CancellableTask) parentTask).getCancellationTimeout(),
import org.opensearch.common.breaker.ResponseLimitBreachedException;
            int limit = responseLimitSettings.getCatShardsResponseLimit();
                            clusterStateResponse
        }
                            ? shardsRequest.getIndices()
        ActionFilters actionFilters,
                            cancellableListener.onResponse(catShardsResponse);
            }
import org.opensearch.core.action.ActionListener;
            });
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            IndexMetadata metadata = clusterState.metadata().indices().get(index);
        try {
        }
            clusterStateRequest.clear().nodes(true).routingTable(true).indices(shardsRequest.getIndices()).metadata(true);
            }
public class TransportCatShardsAction extends HandledTransportAction<CatShardsRequest, CatShardsResponse> {
 */
                    cancellableListener.onFailure(e);
     * IndicesStats. Since pagination strategy always passes concrete indices to TransportIndicesStatsAction,
                        indicesStatsRequest.setParentTask(client.getLocalNodeId(), parentTask.getId());
import java.util.Objects;
                        indicesStatsRequest.setShouldCancelOnTimeout(true);
}
        }).toArray(String[]::new);
                    validateRequestLimit(shardsRequest, clusterStateResponse, cancellableListener);
                            public void onResponse(IndicesStatsResponse indicesStatsResponse) {
                        client.admin().indices().stats(indicesStatsRequest, new ActionListener<IndicesStatsResponse>() {
import org.opensearch.action.pagination.ShardPaginationStrategy;
        super(CatShardsAction.NAME, transportService, actionFilters, CatShardsRequest::new);
import org.opensearch.tasks.Task;
                            shardsRequest.getPageParams(),
 * The OpenSearch Contributors require contributions made to
import org.opensearch.tasks.CancellableTask;
    ) {
                        catShardsResponse.setNodes(clusterStateResponse.getState().getNodes());
                            public void onFailure(Exception e) {
                    try {
    @Override
    /**
        final CatShardsRequest shardsRequest,
        clusterStateRequest.setParentTask(client.getLocalNodeId(), parentTask.getId());
        this.client = client;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.TimeoutTaskCancellationUtility;
                                cancellableListener.onResponse(catShardsResponse);
                        catShardsResponse.setResponseShards(
                        if (shouldSkipIndicesStatsRequest(paginationStrategy, indices)) {
                    } catch (Exception e) {
    private String[] filterClosedIndices(ClusterState clusterState, List<String> strategyIndices) {
import org.opensearch.core.action.NotifyOnceListener;
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
                            Objects.isNull(paginationStrategy)
import org.opensearch.action.support.HandledTransportAction;
    }
     * the default behaviour of StrictExpandOpenAndForbidClosed leads to errors if closed indices are encountered.
                    }
    private boolean shouldSkipIndicesStatsRequest(ShardPaginationStrategy paginationStrategy, String[] indices) {
            client.admin().cluster().state(clusterStateRequest, new ActionListener<ClusterStateResponse>() {
import org.opensearch.transport.TransportService;
    }
    private final ResponseLimitSettings responseLimitSettings;
            cancellableListener.onFailure(e);
                                cancellableListener.onFailure(e);
                        );
 * compatible open source license.
    }
                listener.onResponse(catShardsResponse);
        ActionListener<CatShardsResponse> originalListener = new NotifyOnceListener<CatShardsResponse>() {
            protected void innerOnResponse(CatShardsResponse catShardsResponse) {
                listener.onFailure(new ResponseLimitBreachedException("Too many shards requested.", limit, SHARDS));
                public void onResponse(ClusterStateResponse clusterStateResponse) {
    }
import java.util.List;
import org.opensearch.cluster.metadata.IndexMetadata;
        } else {
    @Inject
                            }
    private final NodeClient client;
                            }
        TransportService transportService,
            @Override
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        return Objects.isNull(pageParams) ? null : new ShardPaginationStrategy(pageParams, clusterStateResponse.getState());
                        });
 * Perform cat shards action
/**
            && Objects.nonNull(clusterStateResponse.getState())) {
                        // For paginated queries, if strategy outputs no shards to be returned, avoid fetching IndicesStats.
     */
    }
import org.opensearch.common.inject.Inject;
import static org.opensearch.common.breaker.ResponseLimitSettings.LimitEntity.SHARDS;
            && Objects.nonNull(clusterStateResponse)
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
    private ShardPaginationStrategy getPaginationStrategy(PageParams pageParams, ClusterStateResponse clusterStateResponse) {
        clusterStateRequest.clusterManagerNodeTimeout(shardsRequest.clusterManagerNodeTimeout());
                public void onFailure(Exception e) {
                originalListener.onFailure(e);
            if (ResponseLimitSettings.isResponseLimitBreached(clusterStateResponse.getState().getRoutingTable(), SHARDS, limit)) {
                }
        };
                            catShardsResponse.setIndicesStatsResponse(IndicesStatsResponse.getEmptyResponse());
 */
        );
                        indicesStatsRequest.indices(indices);
        CatShardsResponse catShardsResponse = new CatShardsResponse();
                        }
        NodeClient client,
                        catShardsResponse.setPageToken(Objects.isNull(paginationStrategy) ? null : paginationStrategy.getResponseToken());
                                : paginationStrategy.getRequestedEntities()
                        cancellableListener.onFailure(e);
            @Override
import org.opensearch.action.pagination.PageParams;
            }
 *
    ) {
                        String[] indices = Objects.isNull(paginationStrategy)
                }
        final ClusterStateResponse clusterStateResponse,
                                ? clusterStateResponse.getState().routingTable().allShards()
            protected void innerOnFailure(Exception e) {
                                catShardsResponse.setIndicesStatsResponse(indicesStatsResponse);
