import org.opensearch.protobufs.QueryContainer;
    }
 * compatible open source license.
    @Override  
    /**  
/*  
        if (queryContainer == null || queryContainer.getQueryContainerCase() != QueryContainer.QueryContainerCase.GEO_BOUNDING_BOX) {
    public GeoBoundingBoxQueryBuilderProtoConverter() {  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
        return QueryContainer.QueryContainerCase.GEO_BOUNDING_BOX;  
 * SPDX-License-Identifier: Apache-2.0
    }
    public GeoBoundingBoxQueryBuilder fromProto(QueryContainer queryContainer) {
 */  
package org.opensearch.transport.grpc.proto.request.search.query;
     */
        return GeoBoundingBoxQueryBuilderProtoUtils.fromProto(queryContainer.getGeoBoundingBox());  
            throw new IllegalArgumentException("QueryContainer must contain a GeoBoundingBoxQuery");  
}
import org.opensearch.index.query.GeoBoundingBoxQueryBuilder;  
 * The OpenSearch Contributors require contributions made to  
        }
 * Protocol Buffer converter for GeoBoundingBoxQuery.
     * Default constructor for GeoBoundingBoxQueryBuilderProtoConverter.
/**
    @Override
    }
public class GeoBoundingBoxQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
 */  
 * into OpenSearch GeoBoundingBoxQueryBuilder instances for geo bounding box search operations.
        // Default constructor
 *
 *
 * this file be licensed under the Apache-2.0 license or a
 * This converter handles the transformation of Protocol Buffer GeoBoundingBoxQuery objects  
