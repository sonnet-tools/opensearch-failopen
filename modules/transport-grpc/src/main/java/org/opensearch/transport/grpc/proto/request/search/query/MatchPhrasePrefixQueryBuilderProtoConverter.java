    /**
        return MatchPhrasePrefixQueryBuilderProtoUtils.fromProto(queryContainer.getMatchPhrasePrefix());
}  
package org.opensearch.transport.grpc.proto.request.search.query;
/*  
import org.opensearch.index.query.QueryBuilder;  
import org.opensearch.protobufs.QueryContainer;
    public QueryBuilder fromProto(QueryContainer queryContainer) {
    public MatchPhrasePrefixQueryBuilderProtoConverter() {
 * into an OpenSearch QueryBuilder object for search operations.
        if (queryContainer == null || !queryContainer.hasMatchPhrasePrefix()) {  
 *
     * Constructs a new MatchPhrasePrefixQueryBuilderProtoConverter.
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * Converter for handling MatchPhrasePrefixQuery Protocol Buffer messages.
    }
        }
    }
    @Override
 */
     */  
 */  
        // Default constructor
 * compatible open source license.
    @Override
    }  
/**
public class MatchPhrasePrefixQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
        return QueryContainer.QueryContainerCase.MATCH_PHRASE_PREFIX;
            throw new IllegalArgumentException("QueryContainer does not contain a MatchPhrasePrefix query");
 * This class converts a QueryContainer containing a match_phrase_prefix query from Protocol Buffer format  
    public QueryContainer.QueryContainerCase getHandledQueryCase() {  
