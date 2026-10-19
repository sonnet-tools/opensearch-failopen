    public QueryContainer.QueryContainerCase getHandledQueryCase() {
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 * This class implements the QueryBuilderProtoConverter interface to provide Prefix query support  
            throw new IllegalArgumentException("QueryContainer does not contain a Prefix query");
        }  
 */
    @Override
/**
 * for the gRPC transport module.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.protobufs.QueryContainer;
        // Default constructor  
    }  
        if (queryContainer == null || !queryContainer.hasPrefix()) {
public class PrefixQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
}
    }
 * Converter for Prefix queries.
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
    public PrefixQueryBuilderProtoConverter() {
    @Override  
    }  
    /**
package org.opensearch.transport.grpc.proto.request.search.query;
 * The OpenSearch Contributors require contributions made to  
 */  
        return QueryContainer.QueryContainerCase.PREFIX;
        return PrefixQueryBuilderProtoUtils.fromProto(queryContainer.getPrefix());
 * this file be licensed under the Apache-2.0 license or a
     */
 *
     * Constructs a new PrefixQueryBuilderProtoConverter.  
/*  
import org.opensearch.index.query.QueryBuilder;  
 * compatible open source license.
