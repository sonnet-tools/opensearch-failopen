                .collect(Collectors.toList());
    private final Map<IndexModule.TieringState, TieringService> migrationServiceMap = new HashMap<>();  
    ) throws IOException {
import org.opensearch.transport.TransportService;
import org.apache.logging.log4j.Logger;
        List<TieringStatus> tieringStatusList = new ArrayList<>();
            ListTieringStatusRequest::new,  
package org.opensearch.storage.action.tiering.status.transport;
 */  
 * compatible open source license.
}
    private static final Logger logger = LogManager.getLogger(TransportListTieringStatusAction.class);
import java.util.List;
     * @param transportService the transport service
import org.opensearch.cluster.service.ClusterService;  
    ListTieringStatusResponse> {  
    }
        IndexNameExpressionResolver indexNameExpressionResolver
     * @param actionFilters the action filters
     * Constructs a TransportListTieringStatusAction.  
import org.opensearch.storage.tiering.TieringService;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
import java.util.ArrayList;
        ActionFilters actionFilters,  
 * Transport handler for listing tiering status of all indices.  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.threadpool.ThreadPool;
    public void clusterManagerOperation(  
        }  
        ListTieringStatusRequest request,
    @Override  
    public ClusterBlockException checkBlock(ListTieringStatusRequest request, ClusterState clusterState) {
import org.opensearch.common.inject.Inject;
/**
 *
    protected ListTieringStatusResponse read(StreamInput in) throws IOException {
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusResponse;
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
import java.util.stream.Collectors;  
import java.util.HashMap;  
        TransportService transportService,
    }
/*  
    @Inject
import java.util.Map;
import org.opensearch.storage.tiering.WarmToHotTieringService;  
        ActionListener<ListTieringStatusResponse> listener  
        return clusterState.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
            ListTieringStatusAction.NAME,
import org.opensearch.cluster.block.ClusterBlockLevel;
    @Override
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
            tieringStatusList = migrationServiceMap.values()
        return ThreadPool.Names.SAME;  
 * The OpenSearch Contributors require contributions made to  
        } else {
            threadPool,
import org.opensearch.storage.common.tiering.TieringUtils;  
import org.opensearch.cluster.ClusterState;
        super(  
        listener.onResponse(new ListTieringStatusResponse(tieringStatusList));
    ) {
            tieringStatusList = migrationServiceMap.get(TieringUtils.getTieringStatefromTargetTier(request.getTargetTier()))
import org.opensearch.index.IndexModule;
     *
    ListTieringStatusRequest,
public class TransportListTieringStatusAction extends TransportClusterManagerNodeReadAction<
        migrationServiceMap.put(IndexModule.TieringState.HOT_TO_WARM, hotToWarmTieringService);  
     * @param indexNameExpressionResolver the index name expression resolver  
    }
    @Override
        ClusterState clusterState,
 * will be added in the implementation PR.
    /**
        HotToWarmTieringService hotToWarmTieringService,
    }  
            transportService,
            clusterService,  
     * @param clusterService the cluster service  
    public TransportListTieringStatusAction(  
import org.opensearch.cluster.block.ClusterBlockException;  
                .flatMap(service -> service.listTieringStatus().stream())
        );
            indexNameExpressionResolver
     * @param threadPool the thread pool
import org.opensearch.action.support.ActionFilters;  
import org.opensearch.storage.action.tiering.status.ListTieringStatusAction;
import org.apache.logging.log4j.LogManager;
        WarmToHotTieringService warmToHotTieringService,
 * this file be licensed under the Apache-2.0 license or a
        migrationServiceMap.put(IndexModule.TieringState.WARM_TO_HOT, warmToHotTieringService);
import org.opensearch.core.action.ActionListener;
        ThreadPool threadPool,  
        if (request.getTargetTier() != null) {
            actionFilters,
import java.io.IOException;
 * TieringService dependencies (HotToWarmTieringService, WarmToHotTieringService)
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusRequest;  
     */
        return new ListTieringStatusResponse(in);
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.storage.tiering.HotToWarmTieringService;
    public String executor() {
                .stream()  
        ClusterService clusterService,
    }
                .listTieringStatus();  
