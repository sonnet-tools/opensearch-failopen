     * @param transportService - a {@link TransportService} object
/**
/*  
        ActionListener<UpdateWorkloadGroupResponse> listener
        }
    protected String executor() {
    protected void clusterManagerOperation(
            UpdateWorkloadGroupRequest::new,
     */
    public TransportUpdateWorkloadGroupAction(
    UpdateWorkloadGroupRequest,
import org.opensearch.cluster.block.ClusterBlockException;
     * @param task task associated with the request  
    @Override
package org.opensearch.plugin.wlm.action;
 */  
 * SPDX-License-Identifier: Apache-2.0
            listener.onFailure(e);  
            listener.onFailure(e);  
            UpdateWorkloadGroupAction.NAME,  
    private final WorkloadGroupPersistenceService workloadGroupPersistenceService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
     *
            transportService,
            WorkloadGroupPersistenceService.validateUpdateThrottlingIsEnforceable(request, clusterState);
import java.io.IOException;  
        IndexNameExpressionResolver indexNameExpressionResolver,
     * Constructor for TransportUpdateWorkloadGroupAction
import org.opensearch.cluster.ClusterState;  
    ) {
            return;
import org.opensearch.transport.TransportService;
import org.opensearch.core.common.io.stream.StreamInput;  
     * @param workloadGroupPersistenceService - a {@link WorkloadGroupPersistenceService} object
            indexNameExpressionResolver  
    @Override
    }  
public class TransportUpdateWorkloadGroupAction extends TransportClusterManagerNodeAction<  
        try {  
    }
import org.opensearch.action.support.ActionFilters;
     * Validates principal-scoped throttling on the node that accepted the request before forwarding; the manager-side  
    protected UpdateWorkloadGroupResponse read(StreamInput in) throws IOException {  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
 *
        super(
import static org.opensearch.threadpool.ThreadPool.Names.SAME;
    protected void doExecute(Task task, UpdateWorkloadGroupRequest request, ActionListener<UpdateWorkloadGroupResponse> listener) {
 *  
     * @param listener listener notified with the response or failure
 * Transport action to update WorkloadGroup
     * check remains authoritative.
     */  
    ) {
        ActionFilters actionFilters,
    @Inject  
            workloadGroupPersistenceService.getClusterService(),
     * @param indexNameExpressionResolver - {@link IndexNameExpressionResolver} object  
        ThreadPool threadPool,
    /**
        return SAME;
    @Override  
     * @param threadPool - {@link ThreadPool} object  
        WorkloadGroupPersistenceService workloadGroupPersistenceService  
    }  
    @Override  
            actionFilters,
        TransportService transportService,  
        } catch (Exception e) {
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
import org.opensearch.cluster.block.ClusterBlockLevel;
 * this file be licensed under the Apache-2.0 license or a
}
        try {  
    }
 * compatible open source license.
     * @param request update workload group request
import org.opensearch.core.action.ActionListener;
     *
     * @param actionFilters - a {@link ActionFilters} object
 * @opensearch.experimental
    protected ClusterBlockException checkBlock(UpdateWorkloadGroupRequest request, ClusterState state) {
        } catch (Exception e) {
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    /**  
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.tasks.Task;
        ClusterState clusterState,  
        UpdateWorkloadGroupRequest request,
    @Override
            WorkloadGroupPersistenceService.validateUpdateThrottlingIsEnforceable(request, clusterService.state());
            threadPool,  
        }
import org.opensearch.common.inject.Inject;
        workloadGroupPersistenceService.updateInClusterStateMetadata(request, listener);  
        this.workloadGroupPersistenceService = workloadGroupPersistenceService;
        return new UpdateWorkloadGroupResponse(in);
 * The OpenSearch Contributors require contributions made to  
    }
            return;
        super.doExecute(task, request, listener);  
 */
        );
    UpdateWorkloadGroupResponse> {
    }
