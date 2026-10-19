/**
 *
        this.ruleProcessingService = ruleProcessingService;  
        ruleProcessingService.add(newRule);  
    private final Rule newRule;  
 */  
    private final Rule previousRule;
import org.opensearch.rule.autotagging.Rule;
package org.opensearch.plugin.wlm.rule.sync.detect;
    }
    public void process() {
    /**  
 * SPDX-License-Identifier: Apache-2.0
}
     */
        this.previousRule = previousRule;
    @Override  
 */  
/*  
        this.newRule = newRule;
 * this file be licensed under the Apache-2.0 license or a
     * @param previousRule
 * The OpenSearch Contributors require contributions made to  
 * This class represents an update rule event which can be consumed by {@link org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism}
    }
public class UpdateRuleEvent implements RuleEvent {
    private final InMemoryRuleProcessingService ruleProcessingService;
        ruleProcessingService.remove(previousRule);
     * @param newRule  
 * compatible open source license.
    public UpdateRuleEvent(Rule previousRule, Rule newRule, InMemoryRuleProcessingService ruleProcessingService) {  
     * @param ruleProcessingService
import org.opensearch.rule.InMemoryRuleProcessingService;
     * Constructor
