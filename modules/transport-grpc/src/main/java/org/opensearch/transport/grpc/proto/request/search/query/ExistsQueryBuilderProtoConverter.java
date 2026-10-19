 */  
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
    }  
        return QueryContainer.QueryContainerCase.EXISTS;
     * Constructs a new ExistsQueryBuilderProtoConverter.  
 * for the gRPC transport module.
        return ExistsQueryBuilderProtoUtils.fromProto(queryContainer.getExists());
/**
     */
    @Override  
 * Converter for Exists queries.
    }
    }  
    public ExistsQueryBuilderProtoConverter() {
/*  
 * compatible open source license.
package org.opensearch.transport.grpc.proto.request.search.query;
}
 * this file be licensed under the Apache-2.0 license or a
        }  
import org.opensearch.index.query.QueryBuilder;  
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
import org.opensearch.protobufs.QueryContainer;
        if (queryContainer == null || !queryContainer.hasExists()) {
        // Default constructor  
    @Override
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
 */
 * SPDX-License-Identifier: Apache-2.0
 * This class implements the QueryBuilderProtoConverter interface to provide Exists query support  
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException("QueryContainer does not contain an Exists query");
public class ExistsQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
    /**
 *
