 *
        return QueryContainer.QueryContainerCase.MATCH;
 * compatible open source license.
package org.opensearch.transport.grpc.proto.request.search.query;
}
        }  
 */  
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
    @Override  
    }  
    }  
    }
public class MatchQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
import org.opensearch.index.query.QueryBuilder;  
     * Constructs a new MatchQueryBuilderProtoConverter.  
 * Converter for Match queries.
    public MatchQueryBuilderProtoConverter() {
    @Override
        return MatchQueryBuilderProtoUtils.fromProto(queryContainer.getMatch());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
 * for the gRPC transport module.
            throw new IllegalArgumentException("QueryContainer does not contain a Match query");
    /**
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
        // Default constructor  
     */
import org.opensearch.protobufs.QueryContainer;
 */
/**
/*  
 * The OpenSearch Contributors require contributions made to  
 * This class implements the QueryBuilderProtoConverter interface to provide Match query support  
 * SPDX-License-Identifier: Apache-2.0
        if (queryContainer == null || !queryContainer.hasMatch()) {
