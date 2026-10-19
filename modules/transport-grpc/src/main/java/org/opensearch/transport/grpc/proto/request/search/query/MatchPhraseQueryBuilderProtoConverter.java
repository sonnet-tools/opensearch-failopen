    public MatchPhraseQueryBuilderProtoConverter() {
 * for the gRPC transport module.
     */
 */  
    /**
import org.opensearch.index.query.QueryBuilder;  
        return QueryContainer.QueryContainerCase.MATCH_PHRASE;
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
 * this file be licensed under the Apache-2.0 license or a
    @Override
 *
        }  
        if (queryContainer == null || !queryContainer.hasMatchPhrase()) {
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 * This class implements the QueryBuilderProtoConverter interface to provide MatchPhrase query support  
}
 * Converter for MatchPhrase queries.
import org.opensearch.protobufs.QueryContainer;
        return MatchPhraseQueryBuilderProtoUtils.fromProto(queryContainer.getMatchPhrase());
    }  
package org.opensearch.transport.grpc.proto.request.search.query;
    }  
    @Override  
/**
            throw new IllegalArgumentException("QueryContainer does not contain a MatchPhrase query");
     * Constructs a new MatchPhraseQueryBuilderProtoConverter.  
public class MatchPhraseQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
        // Default constructor  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
 * SPDX-License-Identifier: Apache-2.0
 */
/*  
    }
