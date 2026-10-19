            WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(  
import org.opensearch.core.common.io.stream.StreamInput;  
    ) {
            workloadGroupPersistenceService.getClusterService(),
     * @param workloadGroupPersistenceService - a {@link WorkloadGroupPersistenceService} object
        );
        IndexNameExpressionResolver indexNameExpressionResolver,
    protected void clusterManagerOperation(  
    protected String executor() {
    protected CreateWorkloadGroupResponse read(StreamInput in) throws IOException {
    }
        this.workloadGroupPersistenceService = workloadGroupPersistenceService;
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
import org.opensearch.action.support.ActionFilters;
     * @param actionFilters - a {@link ActionFilters} object
            indexNameExpressionResolver  
 * compatible open source license.
package org.opensearch.plugin.wlm.action;
        WorkloadGroupPersistenceService workloadGroupPersistenceService  
/**
    ) {
    @Override
}
    @Override
        TransportService transportService,  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
     */
import static org.opensearch.threadpool.ThreadPool.Names.SAME;
            );  
     * @param threadPool - {@link ThreadPool} object  
        ThreadPool threadPool,
        return new CreateWorkloadGroupResponse(in);
     * @param indexNameExpressionResolver - {@link IndexNameExpressionResolver} object  
     */  
    protected ClusterBlockException checkBlock(CreateWorkloadGroupRequest request, ClusterState state) {  
            CreateWorkloadGroupAction.NAME,  
     *
import org.opensearch.tasks.Task;
    }  
    CreateWorkloadGroupRequest,
                request.getWorkloadGroup().getMutableWorkloadGroupFragment().getThrottling()
    /**  
        ClusterState clusterState,
    }  
    @Override
        CreateWorkloadGroupRequest request,
import org.opensearch.common.inject.Inject;
            actionFilters,
     *
    }
            );
        }
import org.opensearch.transport.TransportService;
            transportService,
            threadPool,  
     * @param request create workload group request
            return;
     * check remains authoritative.
     * Constructor for TransportCreateWorkloadGroupAction
        } catch (Exception e) {
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        super(
        try {  
     * @param task task associated with the request  
        } catch (Exception e) {  
    @Override
            WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(
 * SPDX-License-Identifier: Apache-2.0
    private final WorkloadGroupPersistenceService workloadGroupPersistenceService;
 */  
        }  
        try {
public class TransportCreateWorkloadGroupAction extends TransportClusterManagerNodeAction<  
        ActionListener<CreateWorkloadGroupResponse> listener  
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.threadpool.ThreadPool;  
 * Transport action to create WorkloadGroup
        workloadGroupPersistenceService.persistInClusterStateMetadata(request.getWorkloadGroup(), listener);
            listener.onFailure(e);
 * @opensearch.experimental
            listener.onFailure(e);
    @Override  
    public TransportCreateWorkloadGroupAction(
     * Validates principal-scoped throttling on the node that accepted the request before forwarding; the manager-side  
    CreateWorkloadGroupResponse> {
 */
import org.opensearch.cluster.ClusterState;  
import org.opensearch.core.action.ActionListener;
            return;  
/*  
 * The OpenSearch Contributors require contributions made to  
    }
    /**
            CreateWorkloadGroupRequest::new,
 *  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
    @Inject  
                request.getWorkloadGroup().getMutableWorkloadGroupFragment().getThrottling()
     * @param listener listener notified with the response or failure
import org.opensearch.cluster.block.ClusterBlockLevel;
import java.io.IOException;  
        return SAME;  
        ActionFilters actionFilters,
    }  
    protected void doExecute(Task task, CreateWorkloadGroupRequest request, ActionListener<CreateWorkloadGroupResponse> listener) {
        super.doExecute(task, request, listener);
     * @param transportService - a {@link TransportService} object
