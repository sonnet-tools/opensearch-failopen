    }  
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
    }  
        return IdsQueryBuilderProtoUtils.fromProto(queryContainer.getIds());
 *
    /**
import org.opensearch.index.query.QueryBuilder;  
    }
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 */
        // Default constructor  
 * this file be licensed under the Apache-2.0 license or a
/**
     */
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
            throw new IllegalArgumentException("QueryContainer does not contain an Ids query");
 * Converter for Ids queries.
    public IdsQueryBuilderProtoConverter() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.QueryContainer;
        if (queryContainer == null || !queryContainer.hasIds()) {
     * Constructs a new IdsQueryBuilderProtoConverter.  
 * SPDX-License-Identifier: Apache-2.0
        return QueryContainer.QueryContainerCase.IDS;
 * This class implements the QueryBuilderProtoConverter interface to provide Ids query support  
 */  
    @Override
}
        }  
    @Override  
 * for the gRPC transport module.
/*  
public class IdsQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
package org.opensearch.transport.grpc.proto.request.search.query;
 * compatible open source license.
