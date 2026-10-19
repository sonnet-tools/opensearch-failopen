     * Similar to {@link AbstractQueryBuilder#parseInnerQueryBuilder(XContentParser)}, this method
            throw new IllegalArgumentException("Registry cannot be null");
/*  
    public QueryBuilderProtoConverterRegistryImpl getRegistry() {
    /**
     */
 * SPDX-License-Identifier: Apache-2.0
/**
 * This class provides methods to parse different types of query containers and transform them
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.AbstractQueryBuilder;
     *
package org.opensearch.transport.grpc.proto.request.search.query;
     * Creates a new instance with the specified registry.  
    public AbstractQueryBuilderProtoUtils(QueryBuilderProtoConverterRegistryImpl registry) {
import org.opensearch.index.query.QueryBuilder;
    }
     * @throws UnsupportedOperationException if the query type is not supported
        // Validate input
    public QueryBuilder parseInnerQueryBuilderProto(QueryContainer queryContainer) throws UnsupportedOperationException {
 * Utility class for converting Protocol Buffer query representations to OpenSearch QueryBuilder objects.  
     * @param registry The registry to use for query conversion
    /**  
     */  
     */
public class AbstractQueryBuilderProtoUtils {
     * @return The query builder proto converter registry  
    private final QueryBuilderProtoConverterRegistryImpl registry;  
     *
        }
     * Parse a query from its Protocol Buffer representation.
    }
        return registry;  
     * @param queryContainer The Protocol Buffer query container that holds various query type options  
     * Gets the registry used for query conversion.
        if (registry == null) {  
 * into their corresponding OpenSearch QueryBuilder implementations for search operations.
     * determines the query type from the Protocol Buffer container and delegates to the appropriate  
        this.registry = registry;  
 *
 */  
 * compatible open source license.
        if (queryContainer == null) {  
     * @return A QueryBuilder instance configured according to the input query parameters
            throw new IllegalArgumentException("Query container cannot be null");
     * @throws IllegalArgumentException if registry is null  
    /**  
     *
 */  
        return registry.fromProto(queryContainer);
        }
}  
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.QueryContainer;  
import org.opensearch.core.xcontent.XContentParser;  
     * specialized parser.
