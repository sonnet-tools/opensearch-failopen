 *
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
    public void testGetHandledQueryCase() {  
        // Create a QueryContainer with a different query type  
}  
    @Override  
        // Verify the exception message  
    }
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
        assertEquals("Query name should match", "test_geo_bbox_query", geoBoundingBoxQueryBuilder.queryName());  
    }
        );
    public void setUp() throws Exception {
            .putBoundingBox("location", geoBounds)
    public void testFromProtoWithNullContainer() {  
public class GeoBoundingBoxQueryBuilderProtoConverterTests extends OpenSearchTestCase {
            .setXName("test_geo_bbox_query")  
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
import org.opensearch.index.query.GeoBoundingBoxQueryBuilder;  
        assertEquals("Bottom should match", 40.6, geoBoundingBoxQueryBuilder.bottomRight().getLat(), 0.001);  
    }  
        // Verify the result
        );  
    private GeoBoundingBoxQueryBuilderProtoConverter converter;
        GeoBoundingBoxQueryBuilder geoBoundingBoxQueryBuilder = (GeoBoundingBoxQueryBuilder) queryBuilder;
        assertTrue("QueryBuilder should be a GeoBoundingBoxQueryBuilder", queryBuilder instanceof GeoBoundingBoxQueryBuilder);
        assertEquals("Field name should match", "location", geoBoundingBoxQueryBuilder.fieldName());  
    }
            "Exception message should mention 'QueryContainer must contain a GeoBoundingBoxQuery'",  
import org.opensearch.protobufs.QueryContainer;
        converter = new GeoBoundingBoxQueryBuilderProtoConverter();  
        // Test that the converter throws an exception for null input
        );
        assertEquals("Boost should match", 1.5f, geoBoundingBoxQueryBuilder.boost(), 0.001f);
            exception.getMessage().contains("QueryContainer must contain a GeoBoundingBoxQuery")
            "Exception message should mention 'QueryContainer must contain a GeoBoundingBoxQuery'",
            QueryContainer.QueryContainerCase.GEO_BOUNDING_BOX,
import org.opensearch.index.query.QueryBuilder;
        assertEquals("Top should match", 40.7, geoBoundingBoxQueryBuilder.topLeft().getLat(), 0.001);
    public void testFromProto() {  
 * SPDX-License-Identifier: Apache-2.0
        // Convert the query
        QueryContainer queryContainer = QueryContainer.newBuilder().setGeoBoundingBox(geoBoundingBoxQuery).build();  
            .build();
            "Converter should handle GEO_BOUNDING_BOX case",  
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
    }
            converter.getHandledQueryCase()
            .setBoost(1.5f)
        assertEquals("Right should match", -73.9, geoBoundingBoxQueryBuilder.bottomRight().getLon(), 0.001);
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(
import org.opensearch.protobufs.GeoBoundingBoxQuery;  
 */  
        // Test that the converter returns the correct QueryContainerCase
        // Create a QueryContainer with GeoBoundingBoxQuery
            exception.getMessage().contains("QueryContainer must contain a GeoBoundingBoxQuery")  
        // Verify the exception message
import org.opensearch.test.OpenSearchTestCase;  
    public void testFromProtoWithInvalidContainer() {
import org.opensearch.protobufs.CoordsGeoBounds;
        // Test that the converter throws an exception  
        assertTrue(
        super.setUp();
package org.opensearch.transport.grpc.proto.request.search.query;
        assertEquals(
/*  
        assertEquals("Left should match", -74.0, geoBoundingBoxQueryBuilder.topLeft().getLon(), 0.001);
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder()  
import org.opensearch.protobufs.GeoBounds;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
 * The OpenSearch Contributors require contributions made to  
