    /** Full-text filter (MATCH, MATCH_PHRASE, FUZZY, etc.) with supported query parameters. */
 * to distinguish backends that can use index structures (terms index, BKD tree, bloom filter)
    /** Standard comparison filter (EQUALS, GT, IN, LIKE, etc.) on field types in given formats. */
import java.util.Set;
    }  
}
 *  
    record FullText(ScalarFunction function, FieldType fieldType, Set<String> formats, Set<String> supportedParams)  
 * pruning alternatives based on query accuracy requirements.
 * Two variants for the two categories of filter operations.
 * The OpenSearch Contributors require contributions made to  
/**  
 * <p>TODO: add index-backed filter capability variants (ExactIndex, ApproximateIndex)
 * for predicate evaluation. Exact vs approximate distinction matters for PlanForker when  
 */  
    }  
 * @opensearch.internal  
/*  
 * compatible open source license.
    ScalarFunction function();
 * this file be licensed under the Apache-2.0 license or a
    /** The scalar function this capability covers. */
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.analytics.spi;
public sealed interface FilterCapability {
 */
        implements
            FilterCapability {
 *
 *
    record Standard(ScalarFunction function, Set<FieldType> fieldTypes, Set<String> formats) implements FilterCapability {
 * Declares a backend's ability to evaluate filter predicates, scoped to data formats.
