        return FuzzyQueryBuilderProtoUtils.fromProto(queryContainer.getFuzzy());
 * This class implements the QueryBuilderProtoConverter interface to provide Fuzzy query support  
        if (queryContainer == null || !queryContainer.hasFuzzy()) {
        return QueryContainer.QueryContainerCase.FUZZY;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
import org.opensearch.index.query.QueryBuilder;  
/**
 * SPDX-License-Identifier: Apache-2.0
public class FuzzyQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
     */
     * Constructs a new FuzzyQueryBuilderProtoConverter.  
        }  
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 */
    /**
 *
            throw new IllegalArgumentException("QueryContainer does not contain a Fuzzy query");
 * The OpenSearch Contributors require contributions made to  
 * for the gRPC transport module.
 * compatible open source license.
}
import org.opensearch.protobufs.QueryContainer;
 * this file be licensed under the Apache-2.0 license or a
    }  
    public FuzzyQueryBuilderProtoConverter() {
    }
    @Override
package org.opensearch.transport.grpc.proto.request.search.query;
        // Default constructor  
/*  
 */  
 * Converter for Fuzzy queries.
    @Override  
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
    }  
