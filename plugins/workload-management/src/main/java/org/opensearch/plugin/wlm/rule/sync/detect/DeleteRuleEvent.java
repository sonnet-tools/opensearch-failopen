 * compatible open source license.
    private Rule deletedRule;
import org.opensearch.rule.InMemoryRuleProcessingService;
    /**
    private final InMemoryRuleProcessingService ruleProcessingService;  
        this.ruleProcessingService = ruleProcessingService;  
     * Constructor  
 * This class represents a delete rule event which can be consumed by {@link org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism}
    }  
public class DeleteRuleEvent implements RuleEvent {
     */  
 * SPDX-License-Identifier: Apache-2.0
 */  
     * @param ruleProcessingService
        ruleProcessingService.remove(deletedRule);
    @Override  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rule.autotagging.Rule;
    public DeleteRuleEvent(Rule deletedRule, InMemoryRuleProcessingService ruleProcessingService) {
     * @param deletedRule
        this.deletedRule = deletedRule;
/*  
    }
    public void process() {
/**
 */  
}
 *
package org.opensearch.plugin.wlm.rule.sync.detect;
 * The OpenSearch Contributors require contributions made to  
