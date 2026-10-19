     * Default constructor for NestedQueryBuilderProtoConverter.
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;  
        this.registry = registry;  
        return NestedQueryBuilderProtoUtils.fromProto(queryContainer.getNested(), registry);
    @Override  
/**  
/*  
    @Override
import org.opensearch.protobufs.QueryContainer;
 * compatible open source license.
    public NestedQueryBuilderProtoConverter() {}  
    }
    @Override
    private QueryBuilderProtoConverterRegistry registry;
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
 * The OpenSearch Contributors require contributions made to  
}
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
    }
 * SPDX-License-Identifier: Apache-2.0
 * Converter for NestedQuery protobuf messages to OpenSearch QueryBuilder objects.
    }  
        if (queryContainer == null || queryContainer.getQueryContainerCase() != QueryContainer.QueryContainerCase.NESTED) {
     */
    /**  
 * this file be licensed under the Apache-2.0 license or a
        // The utility class no longer stores the registry statically, it's passed directly to fromProto
            throw new IllegalArgumentException("QueryContainer must contain a NestedQuery");  
import org.opensearch.index.query.QueryBuilder;
 * Handles the conversion of nested query protobuf messages to OpenSearch NestedQueryBuilder.
 */  
    public QueryBuilder fromProto(QueryContainer queryContainer) {
package org.opensearch.transport.grpc.proto.request.search.query;
        }
public class NestedQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
        return QueryContainer.QueryContainerCase.NESTED;  
 *
 */  
