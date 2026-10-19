    GetWorkloadGroupResponse> {
            transportService,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
import org.apache.logging.log4j.LogManager;
import org.opensearch.core.rest.RestStatus;  
package org.opensearch.plugin.wlm.action;
import org.opensearch.cluster.block.ClusterBlockLevel;
    }
 * Transport action to get WorkloadGroup
import org.opensearch.cluster.ClusterState;  
 * @opensearch.experimental  
        }  
 */
     * @param threadPool - a {@link ThreadPool} object
            GetWorkloadGroupRequest::new,  
            actionFilters,
            true
import org.apache.logging.log4j.Logger;
    protected GetWorkloadGroupResponse read(StreamInput in) throws IOException {  
    }
    }
        IndexNameExpressionResolver indexNameExpressionResolver
import org.opensearch.common.inject.Inject;  
     * @param clusterService - a {@link ClusterService} object
            throw new ResourceNotFoundException("No WorkloadGroup exists with the provided name: " + name);
    @Override  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
import org.opensearch.core.action.ActionListener;
import org.opensearch.core.common.io.stream.StreamInput;
        ThreadPool threadPool,  
        super(  
    @Inject
    }
import org.opensearch.ResourceNotFoundException;  
    @Override  
/**  
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
        TransportService transportService,
            logger.warn("No WorkloadGroup exists with the provided name: {}", name);
        ActionFilters actionFilters,
public class TransportGetWorkloadGroupAction extends TransportClusterManagerNodeReadAction<
    }  
     * Constructor for TransportGetWorkloadGroupAction
    protected ClusterBlockException checkBlock(GetWorkloadGroupRequest request, ClusterState state) {
        );  
import java.util.Collection;
    private static final Logger logger = LogManager.getLogger(SearchPipelineService.class);
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        ActionListener<GetWorkloadGroupResponse> listener
    GetWorkloadGroupRequest,  
    @Override
    ) throws Exception {
        return ThreadPool.Names.SAME;
            clusterService,  
        final String name = request.getName();  
            threadPool,
import java.io.IOException;  
 *
        return new GetWorkloadGroupResponse(in);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
     *  
import org.opensearch.cluster.block.ClusterBlockException;
     */  
            GetWorkloadGroupAction.NAME,
        GetWorkloadGroupRequest request,
     * @param indexNameExpressionResolver - a {@link IndexNameExpressionResolver} object
import org.opensearch.transport.TransportService;
        ClusterService clusterService,  
    @Override
    ) {
 */  
 * The OpenSearch Contributors require contributions made to  
}  
    protected String executor() {
import org.opensearch.cluster.metadata.WorkloadGroup;
     * @param actionFilters - a {@link ActionFilters} object  
import org.opensearch.cluster.service.ClusterService;
    /**
import org.opensearch.threadpool.ThreadPool;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.ActionFilters;
    public TransportGetWorkloadGroupAction(
            indexNameExpressionResolver,
 *
        if (resultGroups.isEmpty() && name != null && !name.isEmpty()) {  
        ClusterState state,  
        listener.onResponse(new GetWorkloadGroupResponse(resultGroups, RestStatus.OK));
/*  
    protected void clusterManagerOperation(
     * @param transportService - a {@link TransportService} object
import org.opensearch.search.pipeline.SearchPipelineService;
        final Collection<WorkloadGroup> resultGroups = WorkloadGroupPersistenceService.getFromClusterStateMetadata(name, state);
