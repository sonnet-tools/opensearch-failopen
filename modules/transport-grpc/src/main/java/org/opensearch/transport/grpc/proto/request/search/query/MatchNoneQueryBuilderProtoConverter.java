/*  
     */
 * for the gRPC transport module.
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
 * SPDX-License-Identifier: Apache-2.0
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.QueryContainer;
package org.opensearch.transport.grpc.proto.request.search.query;
 * this file be licensed under the Apache-2.0 license or a
}
 */  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
     * Constructs a new MatchNoneQueryBuilderProtoConverter.  
public class MatchNoneQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
import org.opensearch.index.query.QueryBuilder;  
 * compatible open source license.
 * This class implements the QueryBuilderProtoConverter interface to provide MatchNone query support  
/**
        return MatchNoneQueryBuilderProtoUtils.fromProto(queryContainer.getMatchNone());
    @Override  
    /**
        if (queryContainer == null || !queryContainer.hasMatchNone()) {
    @Override
    }  
    }
    public MatchNoneQueryBuilderProtoConverter() {
        }  
            throw new IllegalArgumentException("QueryContainer does not contain a MatchNone query");
 * Converter for MatchNone queries.
 */
    }  
 *
        return QueryContainer.QueryContainerCase.MATCH_NONE;
        // Default constructor  
