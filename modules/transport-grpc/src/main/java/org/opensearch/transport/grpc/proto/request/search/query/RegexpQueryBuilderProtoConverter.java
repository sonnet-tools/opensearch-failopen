            throw new IllegalArgumentException("QueryContainer does not contain a Regexp query");
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
    }  
    }
 */
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
 * for the gRPC transport module.
import org.opensearch.protobufs.QueryContainer;
}
        return RegexpQueryBuilderProtoUtils.fromProto(queryContainer.getRegexp());
 * compatible open source license.
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
 *
     * Constructs a new RegexpQueryBuilderProtoConverter.  
/**
import org.opensearch.index.query.QueryBuilder;  
        }  
    @Override  
        if (queryContainer == null || !queryContainer.hasRegexp()) {
 * The OpenSearch Contributors require contributions made to  
 * Converter for Regexp queries.
    public RegexpQueryBuilderProtoConverter() {
    @Override
public class RegexpQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
 * This class implements the QueryBuilderProtoConverter interface to provide Regexp query support  
     */
 * SPDX-License-Identifier: Apache-2.0
 */  
        return QueryContainer.QueryContainerCase.REGEXP;
/*  
        // Default constructor  
 * this file be licensed under the Apache-2.0 license or a
    /**
package org.opensearch.transport.grpc.proto.request.search.query;
    }  
