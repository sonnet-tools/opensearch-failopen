        return TermsSetQueryBuilderProtoUtils.fromProto(queryContainer.getTermsSet());
     */
    /**
 * The OpenSearch Contributors require contributions made to  
}
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 *
 */  
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 * for the gRPC transport module.
 */
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
            throw new IllegalArgumentException("QueryContainer does not contain a TermsSet query");
package org.opensearch.transport.grpc.proto.request.search.query;
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.opensearch.protobufs.QueryContainer;
    @Override
public class TermsSetQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
    public TermsSetQueryBuilderProtoConverter() {
    }  
/*  
        return QueryContainer.QueryContainerCase.TERMS_SET;
        }  
        if (queryContainer == null || !queryContainer.hasTermsSet()) {
     * Constructs a new TermsSetQueryBuilderProtoConverter.  
        // Default constructor  
 * Converter for TermsSet queries.
/**
 * This class implements the QueryBuilderProtoConverter interface to provide TermsSet query support  
    }
import org.opensearch.index.query.QueryBuilder;  
