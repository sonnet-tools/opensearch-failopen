            final Index index = TieringUtils.resolveRequestIndex(indexNameExpressionResolver, request.getIndex(), clusterService.state());
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.index.IndexModule;  
 * TieringService dependencies (HotToWarmTieringService, WarmToHotTieringService)
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
        );  
    GetTieringStatusResponse> {
import org.opensearch.cluster.block.ClusterBlockLevel;
     * @param indexNameExpressionResolver the index name expression resolver
            GetTieringStatusRequest::new,
        ActionFilters actionFilters,
import org.opensearch.transport.TransportService;  
 */  
     */
import org.opensearch.storage.action.tiering.status.GetTieringStatusAction;
        try {  
        IndexNameExpressionResolver indexNameExpressionResolver
/**  
 * this file be licensed under the Apache-2.0 license or a
    public void clusterManagerOperation(
            clusterService,
        }
import java.util.Map;
import org.opensearch.core.common.io.stream.StreamInput;
        ThreadPool threadPool,  
    private final Map<IndexModule.TieringState, TieringService> migrationServiceMap = new HashMap<>();
    @Override
 *
        ActionListener<GetTieringStatusResponse> listener
import org.opensearch.storage.common.tiering.TieringUtils;
                )
    @Inject  
    }
    /**  
    public ClusterBlockException checkBlock(GetTieringStatusRequest request, ClusterState state) {  
    @Override
import org.opensearch.storage.tiering.WarmToHotTieringService;
    }
     * @param actionFilters the action filters  
            );
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
 * SPDX-License-Identifier: Apache-2.0
    }  
     *
            indexNameExpressionResolver
    ) {  
            listener.onFailure(ex);
        ClusterService clusterService,  
     * Constructs a TransportGetTieringStatusAction.
            final IndexMetadata indexMeta = clusterState.getMetadata().index(index);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import java.util.HashMap;  
import org.opensearch.cluster.block.ClusterBlockException;  
    private static final Logger logger = LogManager.getLogger(TransportGetTieringStatusAction.class);  
import org.opensearch.core.index.Index;
import org.opensearch.cluster.metadata.IndexMetadata;
 * will be added in the implementation PR.  
        return new GetTieringStatusResponse(streamInput);  
     * @param transportService the transport service  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusResponse;  
    public String executor() {  
            final IndexModule.TieringState tieringState = TieringUtils.getTieringStatefromIndexSettings(indexMeta.getSettings());  
    @Override
 */
            actionFilters,  
        super(
 * compatible open source license.
/*  
        migrationServiceMap.put(IndexModule.TieringState.HOT_TO_WARM, hotToWarmTieringService);
    ) {
import org.apache.logging.log4j.Logger;
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusRequest;
            listener.onResponse(
            threadPool,
import org.opensearch.storage.tiering.TieringService;  
import java.io.IOException;
import org.opensearch.action.support.ActionFilters;  
import org.opensearch.core.action.ActionListener;  
        return ThreadPool.Names.SAME;
            GetTieringStatusAction.NAME,
     * @param threadPool the thread pool
public class TransportGetTieringStatusAction extends TransportClusterManagerNodeReadAction<
            transportService,  
        TransportService transportService,
import org.apache.logging.log4j.LogManager;
    GetTieringStatusRequest,  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.storage.tiering.HotToWarmTieringService;
package org.opensearch.storage.action.tiering.status.transport;
        HotToWarmTieringService hotToWarmTieringService,
        WarmToHotTieringService warmToHotTieringService,
                new GetTieringStatusResponse(
 * Transport handler for getting tiering status of a single index.
    public TransportGetTieringStatusAction(
    }
    @Override  
        ClusterState clusterState,  
     * @param clusterService the cluster service
    protected GetTieringStatusResponse read(StreamInput streamInput) throws IOException {
}  
        migrationServiceMap.put(IndexModule.TieringState.WARM_TO_HOT, warmToHotTieringService);
        } catch (Exception ex) {  
import org.opensearch.common.inject.Inject;
        GetTieringStatusRequest request,
                    migrationServiceMap.get(tieringState).getTieringStatus(request.getIndex(), request.getDetailedFlag())  
