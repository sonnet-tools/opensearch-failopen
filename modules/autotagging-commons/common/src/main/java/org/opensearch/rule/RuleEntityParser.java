 * this file be licensed under the Apache-2.0 license or a
     * @return Rule
 * clients can use/implement as per their choice of storage for the Rule  
/*  
 * SPDX-License-Identifier: Apache-2.0
     *           where and how it is stored
 * compatible open source license.
@ExperimentalApi
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rule.autotagging.Rule;
 *
 * Interface to parse various string representation of Rule entity
     * @param src String representation of Rule, it could be a XContentObject or something else based on  
 */  
    /**
/**
 */
    Rule parse(String src);
package org.opensearch.rule;
     * Parses the src string into {@link Rule} object
}
import org.opensearch.common.annotation.ExperimentalApi;
     */  
public interface RuleEntityParser {  
