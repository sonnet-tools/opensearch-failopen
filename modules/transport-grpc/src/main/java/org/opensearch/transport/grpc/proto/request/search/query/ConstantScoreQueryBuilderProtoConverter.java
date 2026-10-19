    }  
 * This class implements the QueryBuilderProtoConverter interface to provide ConstantScore query support
    /**  
            throw new IllegalArgumentException("QueryContainer does not contain a ConstantScore query");
import org.opensearch.index.query.QueryBuilder;  
    @Override
/*  
/**
    }  
 * The OpenSearch Contributors require contributions made to  
 */  
 */  
     */
 *
import org.opensearch.protobufs.QueryContainer;
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
        return ConstantScoreQueryBuilderProtoUtils.fromProto(queryContainer.getConstantScore(), registry);
    public ConstantScoreQueryBuilderProtoConverter() {}  
    }
}
        return QueryContainer.QueryContainerCase.CONSTANT_SCORE;
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
 * SPDX-License-Identifier: Apache-2.0
     * Default constructor for ConstantScoreQueryBuilderProtoConverter.
 * compatible open source license.
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        this.registry = registry;  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
        }  
    @Override
    @Override  
 * this file be licensed under the Apache-2.0 license or a
    private QueryBuilderProtoConverterRegistry registry;
package org.opensearch.transport.grpc.proto.request.search.query;
        if (queryContainer == null || queryContainer.getQueryContainerCase() != QueryContainer.QueryContainerCase.CONSTANT_SCORE) {
public class ConstantScoreQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
 * for the gRPC transport module.
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 * Converter for ConstantScore queries.  
