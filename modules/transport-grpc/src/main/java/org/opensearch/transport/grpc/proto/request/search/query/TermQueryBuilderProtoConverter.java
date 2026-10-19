     * Constructs a new TermQueryBuilderProtoConverter.  
    /**
 */
     */
        return QueryContainer.QueryContainerCase.TERM;
/*  
package org.opensearch.transport.grpc.proto.request.search.query;
    }  
        }  
    @Override
import org.opensearch.protobufs.QueryContainer;
 * compatible open source license.
    }  
        // Default constructor  
 */  
        if (queryContainer == null || queryContainer.getQueryContainerCase() != QueryContainer.QueryContainerCase.TERM) {
import org.opensearch.index.query.QueryBuilder;  
    @Override  
/**
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
    public TermQueryBuilderProtoConverter() {
 * This class implements the QueryBuilderProtoConverter interface to provide Term query support  
 *
public class TermQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * for the gRPC transport module.
}
        return TermQueryBuilderProtoUtils.fromProto(queryContainer.getTerm());
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
    }
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException("QueryContainer does not contain a Term query");
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
 * Converter for Term queries.
