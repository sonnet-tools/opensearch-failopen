        registry.registerConverter(new TermQueryBuilderProtoConverter());
        // Return an instance with the configured registry
        // This method is no longer used in the instance-based approach
        return new AbstractQueryBuilderProtoUtils(registry);
     * This method should be called in test methods that need query parsing functionality.
     * @return AbstractQueryBuilderProtoUtils instance configured for testing
package org.opensearch.transport.grpc.proto.request.search.query;
     */
     *  
}
    }
        // Create a new registry
 *
        registry.registerConverter(new MatchAllQueryBuilderProtoConverter());
        // Kept for any remaining legacy test compatibility  
     * Sets up the registry with all built-in converters for testing.  
/*  
    private QueryBuilderProtoTestUtils() {
        QueryBuilderProtoConverterRegistryImpl registry = new QueryBuilderProtoConverterRegistryImpl();
        // Register all built-in converters
 * The OpenSearch Contributors require contributions made to  
     * Creates an AbstractQueryBuilderProtoUtils instance with all built-in converters for testing.
        registry.registerConverter(new MatchNoneQueryBuilderProtoConverter());  
        // Utility class, no instances  
 */  
    }
    }  
 * Utility class for setting up query builder proto converters in tests.
     */
    /**  
     * This method should be called in the setUp method of test classes
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    @Deprecated  
public class QueryBuilderProtoTestUtils {  
    /**
     * @deprecated Use createQueryUtils() for instance-based approach instead
     * that use AbstractQueryBuilderProtoUtils.
    public static void setupRegistry() {
 */
 * SPDX-License-Identifier: Apache-2.0
/**  
    public static AbstractQueryBuilderProtoUtils createQueryUtils() {  
        registry.registerConverter(new TermsQueryBuilderProtoConverter());
     *  
