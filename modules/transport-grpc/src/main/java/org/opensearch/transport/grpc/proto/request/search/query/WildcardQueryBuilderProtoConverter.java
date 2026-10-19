 * for the gRPC transport module.
     */
     * Constructs a new WildcardQueryBuilderProtoConverter.  
    /**
    }  
 * this file be licensed under the Apache-2.0 license or a
    }
 * The OpenSearch Contributors require contributions made to  
    public WildcardQueryBuilderProtoConverter() {
/*  
 */  
}
import org.opensearch.index.query.QueryBuilder;  
 */
 * Converter for Wildcard queries.
/**
        return WildcardQueryBuilderProtoUtils.fromProto(queryContainer.getWildcard());
import org.opensearch.protobufs.QueryContainer;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
        return QueryContainer.QueryContainerCase.WILDCARD;
 *
 * SPDX-License-Identifier: Apache-2.0
    }  
public class WildcardQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
        }  
        // Default constructor  
package org.opensearch.transport.grpc.proto.request.search.query;
 * compatible open source license.
            throw new IllegalArgumentException("QueryContainer does not contain a Wildcard query");
    @Override  
        if (queryContainer == null || !queryContainer.hasWildcard()) {
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
    @Override
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 * This class implements the QueryBuilderProtoConverter interface to provide Wildcard query support  
