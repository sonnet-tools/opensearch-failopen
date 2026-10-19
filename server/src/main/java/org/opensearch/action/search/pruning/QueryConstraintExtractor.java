 * this file be licensed under the Apache-2.0 license or a
}  
 */  
     * Extracts constraints that every matching document must satisfy.
     *  
     * @return mandatory constraints for configured fields  
    List<QueryConstraint> extractMandatoryConstraints(SearchSourceBuilder source, Set<String> fields);
/**  
/*  
package org.opensearch.action.search.pruning;
 * Extracts mandatory query constraints that are safe to use for index pruning.
     * @param fields configured pruning fields
public interface QueryConstraintExtractor {  
     * @param source search source containing the query tree
 *
     */
 */
import java.util.Set;
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.opensearch.search.builder.SearchSourceBuilder;
    /**
 * The OpenSearch Contributors require contributions made to  
