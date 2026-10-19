        }
    }
        return QueryContainer.QueryContainerCase.TERMS;
}  
    /**
     */
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
 */  
    }
    public QueryBuilder fromProto(QueryContainer queryContainer) {
        // Default constructor  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Converter for Terms queries.  
        if (queryContainer == null || !queryContainer.hasTerms()) {  
public class TermsQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
     * Constructs a new TermsQueryBuilderProtoConverter.  
 * The OpenSearch Contributors require contributions made to  
        this.registry = registry;
 * compatible open source license.
        return TermsQueryBuilderProtoUtils.fromProto(queryContainer.getTerms(), registry);
    private QueryBuilderProtoConverterRegistry registry;  
 * for the gRPC transport module.
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
/**
    public QueryContainer.QueryContainerCase getHandledQueryCase() {  
/*  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
            throw new IllegalArgumentException("QueryContainer does not contain a Terms query");
package org.opensearch.transport.grpc.proto.request.search.query;
import org.opensearch.protobufs.QueryContainer;
    @Override  
    @Override
    }
import org.opensearch.index.query.QueryBuilder;  
 * This class implements the QueryBuilderProtoConverter interface to provide Terms query support
 *
    public TermsQueryBuilderProtoConverter() {
    }  
