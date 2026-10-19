        if (queryContainer == null || queryContainer.getQueryContainerCase() != QueryContainer.QueryContainerCase.BOOL) {
}
     * Default constructor for BoolQueryBuilderProtoConverter.
    @Override
        return BoolQueryBuilderProtoUtils.fromProto(queryContainer.getBool(), registry);
public class BoolQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
        return QueryContainer.QueryContainerCase.BOOL;
import org.opensearch.protobufs.QueryContainer;
 * for the gRPC transport module.
 * The OpenSearch Contributors require contributions made to  
     */
    }  
    public BoolQueryBuilderProtoConverter() {}  
    @Override
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
        }  
    }
 */  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
    private QueryBuilderProtoConverterRegistry registry;
    /**  
 * this file be licensed under the Apache-2.0 license or a
 * This class implements the QueryBuilderProtoConverter interface to provide Bool query support
 * compatible open source license.
 * Converter for Bool queries.  
 *
/*  
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
            throw new IllegalArgumentException("QueryContainer does not contain a Bool query");
 */  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.QueryBuilder;  
        this.registry = registry;  
package org.opensearch.transport.grpc.proto.request.search.query;
    }  
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
/**
