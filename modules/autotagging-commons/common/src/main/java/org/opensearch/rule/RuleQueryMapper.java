     */  
 * this file be licensed under the Apache-2.0 license or a
    T from(GetRuleRequest request);
    /**
 * SPDX-License-Identifier: Apache-2.0
     * This method returns the cardinality query for the rule, this query should
}  
 *
/*  
     */
 * to query the backend  
     * @return  
 * compatible open source license.
/**
     * be constructed in such a way that it can be used to calculate the cardinality of the rules
    /**  
 */  
package org.opensearch.rule;
    T getCardinalityQuery();
@ExperimentalApi  
     * @return
     * This method translates the {@link GetRuleRequest} to a storage engine specific  query object  
public interface RuleQueryMapper<T> {
import org.opensearch.rule.action.GetRuleRequest;
 */
import org.opensearch.common.annotation.ExperimentalApi;
 * This interface is responsible for creating query objects which storage layer can use
     * @param request
 * @param <T>
 * The OpenSearch Contributors require contributions made to  
