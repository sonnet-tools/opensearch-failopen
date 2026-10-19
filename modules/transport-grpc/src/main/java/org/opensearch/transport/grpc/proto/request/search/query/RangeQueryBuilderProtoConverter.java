 * Range queries are handled as a map where the key is the field name and the value is the RangeQuery.  
 * this file be licensed under the Apache-2.0 license or a
 *
 * This converter handles the transformation of Protocol Buffer RangeQuery objects  
public class RangeQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
        if (queryContainer == null || queryContainer.getQueryContainerCase() != QueryContainer.QueryContainerCase.RANGE) {  
 *
    }
package org.opensearch.transport.grpc.proto.request.search.query;
    public QueryContainer.QueryContainerCase getHandledQueryCase() {  
        return QueryContainer.QueryContainerCase.RANGE;
/**
    }
import org.opensearch.index.query.QueryBuilder;  
        // Default constructor
            throw new IllegalArgumentException("QueryContainer must contain a RangeQuery");
    public QueryBuilder fromProto(QueryContainer queryContainer) {
        return RangeQueryBuilderProtoUtils.fromProto(queryContainer.getRange());
    }  
     */  
    public RangeQueryBuilderProtoConverter() {
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
 * Protocol Buffer converter for RangeQuery.
    @Override
 */  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.opensearch.protobufs.QueryContainer;
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * into OpenSearch RangeQueryBuilder instances for range search operations.
 */
}  
/*  
    /**
        }
     * Default constructor for RangeQueryBuilderProtoConverter.
