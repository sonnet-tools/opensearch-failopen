            threadPool,  
package org.opensearch.storage.action.tiering;
    /**
public class TransportWarmToHotTierAction extends TransportTierAction {  
     */
import org.opensearch.cluster.service.ClusterService;  
            warmToHotTieringService
     * @param threadPool the thread pool
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
/*  
    public TransportWarmToHotTierAction(
import org.opensearch.transport.TransportService;
            indexNameExpressionResolver,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.threadpool.ThreadPool;  
            WarmToHotTierAction.NAME,  
     * @param warmToHotTieringService the warm to hot tiering service
     * @param clusterService the cluster service  
    ) {
        TransportService transportService,
 */
    }  
}
            transportService,
     * @param actionFilters the action filters
 */  
 * compatible open source license.
    @Inject  
        ClusterService clusterService,  
 *
     * @param transportService the transport service
        IndexNameExpressionResolver indexNameExpressionResolver,  
        ThreadPool threadPool,
        super(  
 * SPDX-License-Identifier: Apache-2.0
        WarmToHotTieringService warmToHotTieringService
        ActionFilters actionFilters,
/**  
     *
     * @param indexNameExpressionResolver the index name expression resolver  
        );
            actionFilters,
 * The OpenSearch Contributors require contributions made to  
 * Transport Tiering action to move indices from warm to hot.
import org.opensearch.common.inject.Inject;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.storage.tiering.WarmToHotTieringService;
     * Constructs a TransportWarmToHotTierAction.  
            clusterService,
