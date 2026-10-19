import org.apache.logging.log4j.message.ParameterizedMessage;
 * The OpenSearch Contributors require contributions made to
}
        HotToWarmTieringService hotToWarmTieringService,
    }
    private static final Logger logger = LogManager.getLogger(TransportCancelTierAction.class);
        ClusterService clusterService,
import org.opensearch.threadpool.ThreadPool;
            CancelTieringRequest::new,
            listener.onFailure(
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
     * based on the current state of the index.
     */
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        this.warmToHotTieringService = warmToHotTieringService;
        }
                if (IndexModule.TieringState.WARM_TO_HOT.name().equals(tieringState)) {
                    return hotToWarmTieringService;
        return ThreadPool.Names.SAME;
            }
    }
 */
    @Override
public class TransportCancelTierAction extends TransportClusterManagerNodeAction<CancelTieringRequest, AcknowledgedResponse> {
            blockException = state.blocks().globalBlockedException(ClusterBlockLevel.CREATE_INDEX);
            return null;
        ThreadPool threadPool,
            transportService,
            // selecting the service from the persisted INDEX_TIERING_STATE lets cancel reach an index that
    ) {
    @Override
            @Override
import org.opensearch.cluster.metadata.IndexMetadata;
     * @param warmToHotTieringService the warm to hot tiering service
    private final IndexNameExpressionResolver indexNameExpressionResolver;
        tieringService.cancelTiering(request, clusterStateUpdateListener, state);
/*
                return warmToHotTieringService;
        this.indexNameExpressionResolver = indexNameExpressionResolver;
            }
            // Check if index is being tracked by any tiering service
            final IndexMetadata indexMetadata = state.metadata().index(index);
        TieringService tieringService = getTieringServiceForIndex(request.getIndex(), state);
    @Override
package org.opensearch.storage.action.tiering;
     *
import java.io.IOException;
            }
            }
                    return warmToHotTieringService;
    protected String executor() {
        this.hotToWarmTieringService = hotToWarmTieringService;
     * @param state current cluster state
    /**
        }
 * Transport handler for cancelling ongoing tiering operations.
import static org.opensearch.storage.common.tiering.TieringUtils.resolveRequestIndex;
 * compatible open source license.
                listener.onResponse(new AcknowledgedResponse(clusterStateUpdateResponse.isAcknowledged()));
                new IllegalArgumentException("Index [" + request.getIndex() + "] is not currently undergoing tiering operation")
     * @param actionFilters the action filters
import org.opensearch.cluster.service.ClusterService;
import org.apache.logging.log4j.Logger;
    }
        ActionFilters actionFilters,
            @Override
 * This handler can cancel both hot-to-warm and warm-to-hot tiering operations
 * SPDX-License-Identifier: Apache-2.0
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
                listener.onFailure(e);
    private TieringService getTieringServiceForIndex(String indexName, ClusterState state) {
                }
            );
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.cluster.block.ClusterBlockException;
     * @param transportService the transport service
                return hotToWarmTieringService;
            if (warmToHotTieringService.isIndexBeingTiered(index)) {
     * @param hotToWarmTieringService the hot to warm tiering service
                    .get(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());
            if (indexMetadata != null) {
                logger.debug(() -> new ParameterizedMessage("failed to cancel tiering for index [{}]", request.getIndex()), e);
import org.opensearch.cluster.block.ClusterBlockLevel;
 *
import org.opensearch.core.action.ActionListener;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
     * @param indexNameExpressionResolver the index name expression resolver
import org.opensearch.action.support.ActionFilters;
    /**
                final String tieringState = indexMetadata.getSettings()
        throws Exception {
    private final WarmToHotTieringService warmToHotTieringService;
        ActionListener<ClusterStateUpdateResponse> clusterStateUpdateListener = new ActionListener<>() {
     * @param clusterService the cluster service
        if (blockException == null) {
        TransportService transportService,
    protected void clusterManagerOperation(CancelTieringRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener)
                if (IndexModule.TieringState.HOT_TO_WARM.name().equals(tieringState)) {
        }
        ClusterBlockException blockException = state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            }
        super(
    }
    }
            // Fallback to the persisted tiering state. The in-memory tiering set is per-cluster-manager
            public void onFailure(Exception e) {
/**
     * @param indexName the name of the index
import org.opensearch.transport.TransportService;
        );
     */
        WarmToHotTieringService warmToHotTieringService
                }
import org.opensearch.storage.tiering.WarmToHotTieringService;
        try {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.Index;
        };
        // Determine which tiering service to use based on the current migration state
            // and starts empty on a newly elected cluster-manager; until it is rebuilt from cluster state,
            final Index index = resolveRequestIndex(indexNameExpressionResolver, indexName, state);
    public TransportCancelTierAction(
        return new AcknowledgedResponse(in);
     * @return the appropriate TieringService or null if index is not being tiered
        return blockException != null ? blockException : state.blocks().globalBlockedException(ClusterBlockLevel.WRITE);
import org.opensearch.cluster.ClusterState;
            threadPool,
            return null;
        } catch (Exception e) {
 */
    }
import org.opensearch.storage.tiering.HotToWarmTieringService;
    protected ClusterBlockException checkBlock(CancelTieringRequest request, ClusterState state) {
    private final HotToWarmTieringService hotToWarmTieringService;
            clusterService,
            logger.error(() -> new ParameterizedMessage("Error determining tiering service for index [{}]", indexName), e);
            indexNameExpressionResolver
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            if (hotToWarmTieringService.isIndexBeingTiered(index)) {
import org.opensearch.common.inject.Inject;
        if (tieringService == null) {
     * Constructs a TransportCancelTierAction.
    @Inject
import org.apache.logging.log4j.LogManager;
     *
     * @param threadPool the thread pool
            // is mid-migration. (The cluster state itself is durable and not lost across failover.)
    @Override
            actionFilters,
            CancelTieringAction.NAME,
 * by delegating to the appropriate tiering service.
     * Determines the appropriate tiering service for cancelling the migration
            return;
import org.opensearch.index.IndexModule;
import org.opensearch.storage.tiering.TieringService;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
