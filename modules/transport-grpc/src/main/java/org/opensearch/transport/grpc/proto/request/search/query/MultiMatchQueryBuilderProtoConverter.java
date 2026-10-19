package org.opensearch.transport.grpc.proto.request.search.query;
 * SPDX-License-Identifier: Apache-2.0
 */  
    }  
        return MultiMatchQueryBuilderProtoUtils.fromProto(queryContainer.getMultiMatch());
    @Override  
}
public class MultiMatchQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
        if (queryContainer == null || !queryContainer.hasMultiMatch()) {
    }
    @Override
 * compatible open source license.
 */
            throw new IllegalArgumentException("QueryContainer does not contain a MultiMatch query");
 *
/**
 * this file be licensed under the Apache-2.0 license or a
    public MultiMatchQueryBuilderProtoConverter() {
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
import org.opensearch.index.query.QueryBuilder;  
    /**
 * This class implements the QueryBuilderProtoConverter interface to provide MultiMatch query support  
    }  
import org.opensearch.protobufs.QueryContainer;
     * Constructs a new MultiMatchQueryBuilderProtoConverter.  
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
/*  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
     */
        return QueryContainer.QueryContainerCase.MULTI_MATCH;
 * The OpenSearch Contributors require contributions made to  
        }  
 * for the gRPC transport module.
 * Converter for MultiMatch queries.
        // Default constructor  
