     * @param pattern regex pattern  
}  
/*  
 * compatible open source license.
     * @return all derived fields matching the pattern
    MappedFieldType resolve(String fieldName);
    /**
     * Resolves the MappedFieldType associated with a derived field  
 * The OpenSearch Contributors require contributions made to  
     */  
     */
import java.util.Set;  
 * SPDX-License-Identifier: Apache-2.0
 * DerivedFieldResolver is used as a lookup to resolve derived fields from their name.  
package org.opensearch.index.mapper;
     * @return mapped field type
 * this file be licensed under the Apache-2.0 license or a
 * for derived fields resolution.
public interface DerivedFieldResolver {
 * It is created per search request and needs to be set at {@link org.opensearch.index.query.QueryShardContext#setDerivedFieldResolver(DerivedFieldResolver)}
     * @param fieldName field name to lookup
 */  
/**
     * and index mapping.
 *
     * Resolves all derived fields matching a given pattern. It includes derived fields defined both in search requests
    Set<String> resolvePattern(String pattern);  
@PublicApi(since = "2.15.0")
import org.opensearch.common.annotation.PublicApi;
    /**  
 */  
