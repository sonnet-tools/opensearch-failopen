import org.opensearch.protobufs.QueryContainer;
public class MatchBoolPrefixQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
    public MatchBoolPrefixQueryBuilderProtoConverter() {
            throw new IllegalArgumentException("QueryContainer does not contain a MatchBoolPrefix query");
 * This class implements the QueryBuilderProtoConverter interface to provide MatchBoolPrefix query support  
    @Override
 * The OpenSearch Contributors require contributions made to  
    /**
import org.opensearch.index.query.QueryBuilder;  
        return QueryContainer.QueryContainerCase.MATCH_BOOL_PREFIX;
    @Override  
 */
 * for the gRPC transport module.
    }
/*  
        return MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryContainer.getMatchBoolPrefix());
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 * compatible open source license.
 * Converter for MatchBoolPrefix queries.
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
 * this file be licensed under the Apache-2.0 license or a
 *
     */
 */  
}
 * SPDX-License-Identifier: Apache-2.0
    }  
        }  
    }  
        if (queryContainer == null || !queryContainer.hasMatchBoolPrefix()) {
     * Constructs a new MatchBoolPrefixQueryBuilderProtoConverter.  
        // Default constructor  
/**
package org.opensearch.transport.grpc.proto.request.search.query;
