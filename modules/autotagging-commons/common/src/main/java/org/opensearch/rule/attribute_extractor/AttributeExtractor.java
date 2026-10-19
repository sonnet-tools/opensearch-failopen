    Iterable<V> extract();
 */  
     * This method returns the attribute values in context of the current request
         * Logical AND  
    enum LogicalOperator {
 * The OpenSearch Contributors require contributions made to  
     */  
    Attribute getAttribute();
        /**  
    /**  
     * Defines the combination style used when a request contains multiple values
     * for an attribute.
     * @return attribute value
     * This method returns the Attribute which it is responsible for extracting
     * @return attribute
         */
     * for an attribute.
    /**  
import org.opensearch.rule.autotagging.Attribute;
 * SPDX-License-Identifier: Apache-2.0
        /**
    /**  
     */  
         * Logical OR
    LogicalOperator getLogicalOperator();
 * This interface defines the contract for extracting the attributes for Rule based auto-tagging feature
         */
     * Returns the logical operator used when a request contains multiple values
 */  
     */  
/**  
 *
     * @return the logical operator (e.g., AND, OR)
 * this file be licensed under the Apache-2.0 license or a
        AND,
        OR  
     * For example, if the request targets both index A and B, then a rule must  
    /**  
/*  
    }
package org.opensearch.rule.attribute_extractor;
 * @param <V>
}
     * have both index A and B as attributes, requiring an AND operator.
public interface AttributeExtractor<V> {
     */  
 * compatible open source license.
