                        .stream()
     * @param transportService - a {@link TransportService} object
import java.util.List;
    }  
                        .filter(rule -> rule.getFeatureValue().equals(workloadGroup.get_id()))
import org.opensearch.cluster.service.ClusterService;
                }  
 * this file be licensed under the Apache-2.0 license or a
    }
                                    + " ."
    AcknowledgedResponse> {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 *
 * compatible open source license.
        this.workloadGroupPersistenceService = workloadGroupPersistenceService;  
     *  
        this.rulePersistenceService = persistenceService;
import java.io.IOException;
        if (workloadGroups.isEmpty()) {
    private final RulePersistenceService rulePersistenceService;
    private final WorkloadGroupPersistenceService workloadGroupPersistenceService;  
    public TransportDeleteWorkloadGroupAction(
        ActionListener<AcknowledgedResponse> listener,
        }
                @Override
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        return ThreadPool.Names.GET;
 */  
import org.opensearch.rule.action.GetRuleResponse;  
 */
import org.opensearch.cluster.metadata.WorkloadGroup;  
    }  
            try {  
                @Override
/*  
        DeleteWorkloadGroupRequest request,  
            clusterService,  
        );
        super(  
        IndexStoredRulePersistenceService persistenceService,  
    @Override  
    }
            }  
            }
     * @param threadPool - a {@link ThreadPool} object
            throw new ResourceNotFoundException("No WorkloadGroup exists with the provided name: " + request.getName());  
        ThreadPool threadPool,  
            threadPool,
 * The OpenSearch Contributors require contributions made to  
                                workloadGroup.getName()
        ActionFilters actionFilters,
                        listener.onFailure(  
import java.util.Collection;
            transportService,
                                    + " workload group has rules with ids: "  
            DeleteWorkloadGroupAction.NAME,
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;  
        TransportService transportService,
     * @param clusterService - a {@link ClusterService} object
     * @param featureType - workloadManagement feature type
    }  
            new GetRuleRequest(null, Collections.emptyMap(), null, featureType),
import org.opensearch.rule.action.GetRuleRequest;
                            )
import org.opensearch.rule.service.IndexStoredRulePersistenceService;  
 * Transport action for delete WorkloadGroup
import org.opensearch.cluster.block.ClusterBlockLevel;
                    if (!associatedRules.isEmpty()) {
    protected void clusterManagerOperation(  
    /**
                        return;  
                    listener.onFailure(e);
        ActionListener<AcknowledgedResponse> listener  
                    workloadGroupPersistenceService.deleteInClusterStateMetadata(request, listener);
                    }
import java.util.Collections;  
            indexNameExpressionResolver
            DeleteWorkloadGroupRequest::new,  
        WorkloadGroupFeatureType featureType
                            new IllegalStateException(
import org.opensearch.transport.TransportService;
    ) {
        WorkloadGroup workloadGroup = workloadGroups.iterator().next();  
import org.opensearch.ResourceNotFoundException;
        ClusterService clusterService,  
                listener.onFailure(e);  
                }
    @Override
        ClusterState state
 * SPDX-License-Identifier: Apache-2.0
                                    + "Please delete them first otherwise system will be an inconsistent state."  
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
                                    + associatedRules
     * @param workloadGroupPersistenceService - a {@link WorkloadGroupPersistenceService} object  
    @Inject
import org.opensearch.common.inject.Inject;
 *
    ) {  
import org.opensearch.rule.RulePersistenceService;
            new ActionListener<GetRuleResponse>() {  
    DeleteWorkloadGroupRequest,  
import org.opensearch.action.support.ActionFilters;
                public void onFailure(Exception e) {  
        threadPool.executor(executor()).submit(() -> {
        ClusterState state,
        IndexNameExpressionResolver indexNameExpressionResolver,
                        );
import org.opensearch.cluster.block.ClusterBlockException;  
    ) throws Exception {
    private void checkNoAssociatedRulesExist(
/**  
                    List<Rule> associatedRules = getRuleResponse.getRules()  
        });
     * @param indexNameExpressionResolver - a {@link IndexNameExpressionResolver} object
    }
    protected ClusterBlockException checkBlock(DeleteWorkloadGroupRequest request, ClusterState state) {
import org.opensearch.rule.autotagging.FeatureType;
 * @opensearch.experimental  
    @Override
import org.opensearch.cluster.ClusterState;
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;
     * @param actionFilters - a {@link ActionFilters} object  
    @Override
        WorkloadGroupPersistenceService workloadGroupPersistenceService,
            actionFilters,
            } catch (Exception e) {
import org.opensearch.core.common.io.stream.StreamInput;
    private final FeatureType featureType;
    protected String executor() {  
        this.featureType = featureType;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
public class TransportDeleteWorkloadGroupAction extends TransportClusterManagerNodeAction<
                public void onResponse(GetRuleResponse getRuleResponse) {
import org.opensearch.core.action.ActionListener;  
import org.opensearch.rule.autotagging.Rule;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
        Collection<WorkloadGroup> workloadGroups = WorkloadGroupPersistenceService.getFromClusterStateMetadata(request.getName(), state);
package org.opensearch.plugin.wlm.action;
}  
     */  
        );
     * Constructor for TransportDeleteWorkloadGroupAction
                checkNoAssociatedRulesExist(request, listener, state);
     * @param persistenceService - a {@link IndexStoredRulePersistenceService} instance
        rulePersistenceService.getRule(
import org.opensearch.threadpool.ThreadPool;
                        .toList();  
        return new AcknowledgedResponse(in);  
        DeleteWorkloadGroupRequest request,
