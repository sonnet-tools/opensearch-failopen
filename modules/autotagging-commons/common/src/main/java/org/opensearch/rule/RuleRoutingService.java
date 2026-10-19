 */
     * @param listener listener to handle the final response
    void handleCreateRuleRequest(CreateRuleRequest request, ActionListener<CreateRuleResponse> listener);  
import org.opensearch.rule.action.UpdateRuleRequest;
     */  
 * this file be licensed under the Apache-2.0 license or a
/**
public interface RuleRoutingService {
     * Handles a create rule request by routing it to the appropriate node.
    /**
 *
package org.opensearch.rule;
 * @opensearch.experimental  
 */  
/*  
    /**
import org.opensearch.rule.action.CreateRuleResponse;  
import org.opensearch.rule.action.UpdateRuleResponse;
     */
    void handleUpdateRuleRequest(UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener);
 * compatible open source license.
     * Handles a update rule request by routing it to the appropriate node.  
 * Interface that handles rule routing logic
 * The OpenSearch Contributors require contributions made to  
}
     * @param listener listener to handle the final response
import org.opensearch.rule.action.CreateRuleRequest;
     * @param request the create rule request  
import org.opensearch.core.action.ActionListener;
 * SPDX-License-Identifier: Apache-2.0
     * @param request the update rule request
