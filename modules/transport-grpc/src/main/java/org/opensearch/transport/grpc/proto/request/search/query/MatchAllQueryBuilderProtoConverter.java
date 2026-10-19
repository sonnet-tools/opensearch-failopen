    }
package org.opensearch.transport.grpc.proto.request.search.query;
        return QueryContainer.QueryContainerCase.MATCH_ALL;
    }  
 */
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
        // Default constructor  
 * for the gRPC transport module.
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
        return MatchAllQueryBuilderProtoUtils.fromProto(queryContainer.getMatchAll());
 * compatible open source license.
     * Constructs a new MatchAllQueryBuilderProtoConverter.  
    @Override
    }  
    /**
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        if (queryContainer == null || !queryContainer.hasMatchAll()) {
 * Converter for MatchAll queries.
    public MatchAllQueryBuilderProtoConverter() {
public class MatchAllQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
 *
        }  
import org.opensearch.protobufs.QueryContainer;
    @Override  
 */  
/*  
            throw new IllegalArgumentException("QueryContainer does not contain a MatchAll query");
import org.opensearch.index.query.QueryBuilder;  
 * This class implements the QueryBuilderProtoConverter interface to provide MatchAll query support  
/**
     */
}
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
