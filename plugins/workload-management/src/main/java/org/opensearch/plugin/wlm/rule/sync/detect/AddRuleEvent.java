     */  
 * SPDX-License-Identifier: Apache-2.0
     * @param newRule
        this.newRule = newRule;
 */  
/*  
     * Constructor  
    public AddRuleEvent(Rule newRule, InMemoryRuleProcessingService ruleProcessingService) {
 * The OpenSearch Contributors require contributions made to  
    private final InMemoryRuleProcessingService ruleProcessingService;  
    }
        ruleProcessingService.add(newRule);
    @Override  
}
 * This class represents an add rule event which can be consumed by {@link org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism}
/**
 *
package org.opensearch.plugin.wlm.rule.sync.detect;
public class AddRuleEvent implements RuleEvent {
import org.opensearch.rule.InMemoryRuleProcessingService;
        this.ruleProcessingService = ruleProcessingService;  
     * @param ruleProcessingService
    /**
 * this file be licensed under the Apache-2.0 license or a
    public void process() {
 * compatible open source license.
 */  
    }  
    private final Rule newRule;
import org.opensearch.rule.autotagging.Rule;
