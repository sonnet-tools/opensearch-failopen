     * Delete a rule based on the provided request.
 */  
     */
     * Update rule based on the provided request.  
import org.opensearch.rule.action.CreateRuleRequest;  
import org.opensearch.rule.action.DeleteRuleRequest;
     */  
import org.opensearch.core.action.ActionListener;
     * @param listener The listener that will handle the response or failure.  
}
     * Create rules based on the provided request.  
     * @param request The request containing the details for creating the rule.
     * @param request The request containing the details for updating the rule.
import org.opensearch.rule.action.UpdateRuleResponse;  
 */
/**
    void deleteRule(DeleteRuleRequest request, ActionListener<AcknowledgedResponse> listener);  
    /**  
 * SPDX-License-Identifier: Apache-2.0
public interface RulePersistenceService {  
     * @param listener The listener that will handle the response or failure.
import org.opensearch.rule.action.GetRuleRequest;  
 * Interface for a service that handles rule persistence CRUD operations.  
 * The OpenSearch Contributors require contributions made to  
     * @param listener The listener that will handle the response or failure.
import org.opensearch.rule.action.UpdateRuleRequest;
     * Get rules based on the provided request.
    void getRule(GetRuleRequest request, ActionListener<GetRuleResponse> listener);
     * @param request The request containing the details for retrieving the rule.
     */
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
package org.opensearch.rule;
     */  
 * this file be licensed under the Apache-2.0 license or a
    /**
 * compatible open source license.
    /**
/*  
 *
    void createRule(CreateRuleRequest request, ActionListener<CreateRuleResponse> listener);
import org.opensearch.rule.action.CreateRuleResponse;
     * @param listener The listener that will handle the response or failure.
    void updateRule(UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener);
 * @opensearch.experimental
    /**
import org.opensearch.rule.action.GetRuleResponse;
     * @param request The request containing the ID of the rule to delete.  
