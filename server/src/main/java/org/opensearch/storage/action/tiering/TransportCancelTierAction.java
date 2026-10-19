    protected String executor() {  
import org.opensearch.transport.TransportService;
import org.opensearch.storage.tiering.TieringService;
    private final IndexNameExpressionResolver indexNameExpressionResolver;
            return null;
        };
            actionFilters,
import org.opensearch.cluster.metadata.IndexMetadata;
        ClusterBlockException blockException = state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
 */  
        );
    @Override
        this.hotToWarmTieringService = hotToWarmTieringService;
            public void onResponse(ClusterStateUpdateResponse clusterStateUpdateResponse) {
import org.opensearch.core.action.ActionListener;  
    }
     * Determines the appropriate tiering service for cancelling the migration
            if (warmToHotTieringService.isIndexBeingTiered(index)) {
 * Transport handler for cancelling ongoing tiering operations.  
        }
     *
            listener.onFailure(
        IndexNameExpressionResolver indexNameExpressionResolver,
 * This handler can cancel both hot-to-warm and warm-to-hot tiering operations
import org.opensearch.storage.tiering.WarmToHotTieringService;  
        // Determine which tiering service to use based on the current migration state
        TieringService tieringService = getTieringServiceForIndex(request.getIndex(), state);
 */  
                }
            }  
            if (indexMetadata != null) {  
import org.opensearch.index.IndexModule;  
            @Override  
                    .get(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());
                logger.debug(() -> new ParameterizedMessage("failed to cancel tiering for index [{}]", request.getIndex()), e);
            @Override
        HotToWarmTieringService hotToWarmTieringService,  
 * by delegating to the appropriate tiering service.
        tieringService.cancelTiering(request, clusterStateUpdateListener, state);
}
/**
     * @param indexNameExpressionResolver the index name expression resolver
import org.opensearch.threadpool.ThreadPool;
    protected void clusterManagerOperation(CancelTieringRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener)
            final Index index = resolveRequestIndex(indexNameExpressionResolver, indexName, state);
    @Override  
import org.apache.logging.log4j.Logger;
        }
        super(  
        WarmToHotTieringService warmToHotTieringService
 * SPDX-License-Identifier: Apache-2.0
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
                    return warmToHotTieringService;
                if (IndexModule.TieringState.HOT_TO_WARM.name().equals(tieringState)) {  
            // and starts empty on a newly elected cluster-manager; until it is rebuilt from cluster state,
    ) {
            return null;
     * @param indexName the name of the index
            CancelTieringRequest::new,  
     * @param actionFilters the action filters  
            // Fallback to the persisted tiering state. The in-memory tiering set is per-cluster-manager
            blockException = state.blocks().globalBlockedException(ClusterBlockLevel.CREATE_INDEX);
    }  
    /**  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
            }  
        TransportService transportService,
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.storage.common.tiering.TieringUtils.resolveRequestIndex;  
package org.opensearch.storage.action.tiering;
    }  
import org.opensearch.core.common.io.stream.StreamInput;
    private final WarmToHotTieringService warmToHotTieringService;  
                return warmToHotTieringService;
     */
    public TransportCancelTierAction(  
        } catch (Exception e) {
            );  
     * @return the appropriate TieringService or null if index is not being tiered
     * @param clusterService the cluster service
     * @param transportService the transport service  
import org.opensearch.storage.tiering.HotToWarmTieringService;
    protected ClusterBlockException checkBlock(CancelTieringRequest request, ClusterState state) {
            final IndexMetadata indexMetadata = state.metadata().index(index);
    }
            }
 * compatible open source license.
import org.apache.logging.log4j.LogManager;
import org.opensearch.core.index.Index;
import java.io.IOException;
    @Inject
                }
            }  
public class TransportCancelTierAction extends TransportClusterManagerNodeAction<CancelTieringRequest, AcknowledgedResponse> {
                return hotToWarmTieringService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        if (tieringService == null) {  
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
     *
    }
        if (blockException == null) {  
        try {
import org.opensearch.action.support.ActionFilters;
        ClusterService clusterService,
        return new AcknowledgedResponse(in);  
     * based on the current state of the index.  
    private TieringService getTieringServiceForIndex(String indexName, ClusterState state) {  
/*  
        }
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.cluster.block.ClusterBlockException;  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.inject.Inject;
            public void onFailure(Exception e) {
                final String tieringState = indexMetadata.getSettings()
    }
        return blockException != null ? blockException : state.blocks().globalBlockedException(ClusterBlockLevel.WRITE);  
                listener.onResponse(new AcknowledgedResponse(clusterStateUpdateResponse.isAcknowledged()));  
                    return hotToWarmTieringService;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
                if (IndexModule.TieringState.WARM_TO_HOT.name().equals(tieringState)) {  
    private final HotToWarmTieringService hotToWarmTieringService;
        ThreadPool threadPool,  
                listener.onFailure(e);  
     * @param hotToWarmTieringService the hot to warm tiering service
    /**
        this.warmToHotTieringService = warmToHotTieringService;
            return;
            // is mid-migration. (The cluster state itself is durable and not lost across failover.)
            transportService,
                new IllegalArgumentException("Index [" + request.getIndex() + "] is not currently undergoing tiering operation")
            if (hotToWarmTieringService.isIndexBeingTiered(index)) {
     * @param threadPool the thread pool
    private static final Logger logger = LogManager.getLogger(TransportCancelTierAction.class);  
        return ThreadPool.Names.SAME;
            }
            CancelTieringAction.NAME,
import org.apache.logging.log4j.message.ParameterizedMessage;  
 *
            // Check if index is being tracked by any tiering service  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     * @param warmToHotTieringService the warm to hot tiering service  
        ActionListener<ClusterStateUpdateResponse> clusterStateUpdateListener = new ActionListener<>() {  
        ActionFilters actionFilters,
 * this file be licensed under the Apache-2.0 license or a
     */
            // selecting the service from the persisted INDEX_TIERING_STATE lets cancel reach an index that  
            logger.error(() -> new ParameterizedMessage("Error determining tiering service for index [{}]", indexName), e);  
    @Override
    @Override  
     * Constructs a TransportCancelTierAction.
        throws Exception {
import org.opensearch.cluster.ClusterState;
     * @param state current cluster state  
            indexNameExpressionResolver
            threadPool,
            clusterService,  
