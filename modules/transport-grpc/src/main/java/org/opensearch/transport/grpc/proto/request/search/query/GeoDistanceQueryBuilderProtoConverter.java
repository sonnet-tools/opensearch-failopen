 * The OpenSearch Contributors require contributions made to  
    }
}  
     * Constructs a new GeoDistanceQueryBuilderProtoConverter.  
    @Override  
    }  
     */
            throw new IllegalArgumentException("QueryContainer does not contain a GeoDistance query");
public class GeoDistanceQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
    @Override
import org.opensearch.protobufs.QueryContainer;
 * compatible open source license.
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
        // Default constructor  
/**
 * SPDX-License-Identifier: Apache-2.0
    public GeoDistanceQueryBuilderProtoConverter() {
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
import org.opensearch.index.query.QueryBuilder;  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
 *
 * Converter for GeoDistance queries.
    /**
 */
        if (queryContainer == null || queryContainer.getQueryContainerCase() != QueryContainer.QueryContainerCase.GEO_DISTANCE) {
 * this file be licensed under the Apache-2.0 license or a
    }
package org.opensearch.transport.grpc.proto.request.search.query;
/*  
        return QueryContainer.QueryContainerCase.GEO_DISTANCE;
        }  
 */  
        return GeoDistanceQueryBuilderProtoUtils.fromProto(queryContainer.getGeoDistance());
 * for the gRPC transport module.
 * This class implements the QueryBuilderProtoConverter interface to provide GeoDistance query support  
