 * this file be licensed under the Apache-2.0 license or a
public class FunctionScoreQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
 * Converter for FunctionScore queries.  
/*  
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
     * Default constructor for FunctionScoreQueryBuilderProtoConverter.
    @Override
    @Override  
     */
    private QueryBuilderProtoConverterRegistry registry;
/**
    /**  
        this.registry = registry;  
        return QueryContainer.QueryContainerCase.FUNCTION_SCORE;
 * This class implements the QueryBuilderProtoConverter interface to provide FunctionScore query support
 * for the gRPC transport module.
import org.opensearch.protobufs.QueryContainer;
}
    @Override
 */  
            throw new IllegalArgumentException("QueryContainer does not contain a FunctionScore query");
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    }  
    public FunctionScoreQueryBuilderProtoConverter() {}  
 */  
 * compatible open source license.
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        return FunctionScoreQueryBuilderProtoUtils.fromProto(queryContainer.getFunctionScore(), registry);
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 *
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
    }  
    }
import org.opensearch.index.query.QueryBuilder;  
        if (queryContainer == null || !queryContainer.hasFunctionScore()) {
        }  
