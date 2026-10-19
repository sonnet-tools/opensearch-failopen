        rulePersistenceService.deleteRule(request, listener);  
public class TransportDeleteRuleAction extends HandledTransportAction<DeleteRuleRequest, AcknowledgedResponse> {  
/*  
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.inject.Inject;
     * @param actionFilters - a {@link ActionFilters} object
        RulePersistenceServiceRegistry rulePersistenceServiceRegistry  
        TransportService transportService,
 * @opensearch.experimental
 * Transport action to delete Rules  
 */
    }
    protected void doExecute(Task task, DeleteRuleRequest request, ActionListener<AcknowledgedResponse> listener) {
    @Override  
        ActionFilters actionFilters,
     */
        this.rulePersistenceServiceRegistry = rulePersistenceServiceRegistry;  
import org.opensearch.action.support.ActionFilters;
     *  
 * this file be licensed under the Apache-2.0 license or a
        RulePersistenceService rulePersistenceService = rulePersistenceServiceRegistry.getRulePersistenceService(request.getFeatureType());
 *
     * @param transportService - a {@link TransportService} object
        super(DeleteRuleAction.NAME, transportService, actionFilters, DeleteRuleRequest::new);
 * compatible open source license.
import org.opensearch.rule.RulePersistenceService;  
import org.opensearch.action.support.HandledTransportAction;
    public TransportDeleteRuleAction(  
}
    /**
import org.opensearch.tasks.Task;
import org.opensearch.rule.RulePersistenceServiceRegistry;
    ) {
    private final RulePersistenceServiceRegistry rulePersistenceServiceRegistry;
import org.opensearch.transport.TransportService;  
import org.opensearch.core.action.ActionListener;
package org.opensearch.rule.action;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
    @Inject
     * @param rulePersistenceServiceRegistry - a {@link RulePersistenceServiceRegistry} object  
    }
 * SPDX-License-Identifier: Apache-2.0
/**
     * Constructor for TransportDeleteRuleAction
