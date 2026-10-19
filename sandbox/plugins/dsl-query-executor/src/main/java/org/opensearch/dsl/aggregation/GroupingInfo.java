import java.util.Map;
/*  
     * Documents with a null value for a listed field join the substitute value's group; fields
    /** Returns the logical field names this grouping contributes. */
 * compatible open source license.
 * expression-based grouping (histogram, range) without modifying this interface.
 * SPDX-License-Identifier: Apache-2.0
    /**
     */
 * this file be licensed under the Apache-2.0 license or a
     * from grouping entirely, matching classic search. Empty when no field has a  
 * Implementations provide field-based grouping (terms) or  
 */
     * {@code missing} value.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.dsl.aggregation;
     * absent from the map keep the default semantics — their null-valued documents are excluded
 *
/**
public interface GroupingInfo {  
import java.util.List;
    Map<String, Object> getMissingByField();  
     * Returns the null-substitution value per field (the {@code missing} request parameter).  
    List<String> getFieldNames();  
 * Represents a grouping contribution from a bucket aggregation.
 */  
}
