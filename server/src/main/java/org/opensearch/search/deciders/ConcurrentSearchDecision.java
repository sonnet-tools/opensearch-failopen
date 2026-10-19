                    return new ConcurrentSearchDecision(  
 *
    final private String decisionReason;
/*  
        return "ConcurrentSearchDecision{" + "decisionStatus=" + decisionStatus + ", decisionReason='" + decisionReason + '\'' + '}';
        DecisionStatus(int id) {  
     * NO_OP AND YES results in YES
 * this file be licensed under the Apache-2.0 license or a
    public enum DecisionStatus {
            switch (decision.decisionStatus) {  
package org.opensearch.search.deciders;
    }
                case NO_OP:
                    finalDecisionStatus = DecisionStatus.YES;
 */  
                        "composite decision evaluated to false due to " + decision.decisionReason
     * The decisions are combined as:  
                case NO:
    public String getDecisionReason() {  
            this.id = id;
        YES(0), // use concurrent search  
    }  
     * This enum contains the decision status for concurrent search.
        this.decisionReason = decisionReason;
        return decisionReason;
        }
    public DecisionStatus getDecisionStatus() {
                    );  
                    finalDecisionStatus = DecisionStatus.NO;
    final private DecisionStatus decisionStatus;  
    @ExperimentalApi
                    break;  
     * NO_OP AND NO results in NO  
    public ConcurrentSearchDecision(DecisionStatus decisionStatus, String decisionReason) {  
        for (ConcurrentSearchDecision decision : allDecisions) {
                case YES:
@ExperimentalApi  
        return decisionStatus;  
        private final int id;
import java.util.Collection;  
    /**
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * This Class defines the decisions that a {@link ConcurrentSearchRequestDecider#getConcurrentSearchDecision} can return.  
                    // NOOP doesn't change the final decision
        this.decisionStatus = decisionStatus;
     */
    public String toString() {  
        return new ConcurrentSearchDecision(finalDecisionStatus, "composite decision result");  
    public static ConcurrentSearchDecision getCompositeDecision(Collection<ConcurrentSearchDecision> allDecisions) {
    /**
        NO(1),  // don't use concurrent search
        DecisionStatus finalDecisionStatus = DecisionStatus.NO_OP;
    }
    }  
                    break;  
 *
/**
    }
            }
        }
    @Override
 */
}  
 * SPDX-License-Identifier: Apache-2.0
     */  
        NO_OP(2); // no preference
public class ConcurrentSearchDecision {
    }
import org.opensearch.common.annotation.ExperimentalApi;
     * Combine a collection of {@link ConcurrentSearchDecision} to return final {@link ConcurrentSearchDecision}
     * NO_OP AND NO_OP results in NO_OP
                        finalDecisionStatus,
