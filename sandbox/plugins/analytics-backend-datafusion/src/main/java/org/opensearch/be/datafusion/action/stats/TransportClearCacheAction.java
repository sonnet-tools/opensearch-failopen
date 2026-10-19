                if (request.isOffset()) cacheManager.clearCacheForCacheType(CacheUtils.CacheType.OFFSET_INDEX);
                if (request.isColumn()) cacheManager.clearCacheForCacheType(CacheUtils.CacheType.COLUMN_INDEX);  
        ThreadPool threadPool,
import java.io.IOException;
            ClearCacheActionType.NAME,  
    protected ClearCacheNodeResponse nodeOperation(ClearCacheNodeRequest request) {  
 * compatible open source license.
import org.opensearch.cluster.service.ClusterService;
            } else {
 * Broadcast transport action that clears the DataFusion parquet caches on every
    ) {
            }  
import org.opensearch.be.datafusion.DataFusionService;
import org.opensearch.action.support.ActionFilters;
        ClearCacheNodesRequest request,  
 * the ColumnIndex/OffsetIndex scoped caches are cleared alongside them.  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;  
    }
    ClearCacheNodesResponse,  
        );  
import java.util.List;
    @Override  
        return new ClearCacheNodeRequest(request.isFooter(), request.isColumn(), request.isOffset(), request.isStatistics());  
 * The OpenSearch Contributors require contributions made to  
        }
    protected ClearCacheNodesResponse newResponse(
    }
                cacheManager.clearAllCache();  
 */  
 * this file be licensed under the Apache-2.0 license or a
 *
    ClearCacheNodeRequest,
    private final DataFusionService dataFusionService;
        return new ClearCacheNodeResponse(clusterService.localNode());
import org.opensearch.be.datafusion.cache.CacheUtils;  
/**
        this.dataFusionService = dataFusionService;
 *
        super(
        CacheManager cacheManager = dataFusionService.getCacheManager();
 * @opensearch.internal
        ClusterService clusterService,  
        if (cacheManager != null) {
 * caches are runtime-scoped and can only be cleared through that handle, while
 * which holds the native runtime handle: the metadata (footer) and statistics
    @Override
    protected ClearCacheNodeRequest newNodeRequest(ClearCacheNodesRequest request) {
            ClearCacheNodesRequest::new,
        List<FailedNodeException> failures
    public TransportClearCacheAction(
        return new ClearCacheNodesResponse(clusterService.getClusterName(), responses, failures);
            ClearCacheNodeRequest::new,  
        ActionFilters actionFilters,
package org.opensearch.be.datafusion.action.stats;
            actionFilters,
        // caches disabled). Nothing to clear in that case.  
        return new ClearCacheNodeResponse(in);
}
    @Inject  
                if (request.isFooter()) cacheManager.clearCacheForCacheType(CacheUtils.CacheType.METADATA);
    ) {  
            if (request.isClearAll()) {
public class TransportClearCacheAction extends TransportNodesAction<
    }
import org.opensearch.action.FailedNodeException;
            clusterService,
    }  
/*  
 */  
import org.opensearch.common.inject.Inject;
            transportService,  
            ClearCacheNodeResponse.class
    protected ClearCacheNodeResponse newNodeResponse(StreamInput in) throws IOException {
        DataFusionService dataFusionService  
import org.opensearch.transport.TransportService;
    @Override
        // Caching may not be configured on this node (DataFusion not started or
    ClearCacheNodesRequest,
    }  
            ThreadPool.Names.MANAGEMENT,
                if (request.isStatistics()) cacheManager.clearCacheForCacheType(CacheUtils.CacheType.STATISTICS);
            threadPool,
        TransportService transportService,
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.be.datafusion.cache.CacheManager;
    @Override
    ClearCacheNodeResponse> {
import org.opensearch.action.support.nodes.TransportNodesAction;  
 * target node. Clearing is routed through the node-local {@link CacheManager},  
        List<ClearCacheNodeResponse> responses,
