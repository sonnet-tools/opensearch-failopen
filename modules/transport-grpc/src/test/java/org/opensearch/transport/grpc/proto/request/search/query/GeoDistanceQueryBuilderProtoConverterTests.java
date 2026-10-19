    public void testGetHandledQueryCase() {  
        assertTrue(
            .setXName("location")
import org.opensearch.protobufs.QueryContainer;
    public void testFromProto() {
        converter = new GeoDistanceQueryBuilderProtoConverter();  
public class GeoDistanceQueryBuilderProtoConverterTests extends OpenSearchTestCase {
            .setXName("test_geo_distance_query")  
        // Distance is returned in meters, so 10km = 10000m
    }
        );
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
import org.opensearch.protobufs.GeoLocation;  
            exception.getMessage().contains("QueryContainer does not contain a GeoDistance query")
        assertEquals("Boost should match", 2.0f, geoDistanceQueryBuilder.boost(), 0.001f);
    public void testFromProtoWithInvalidContainer() {
 * compatible open source license.
            "Exception message should mention 'QueryContainer does not contain a GeoDistance query'",  
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();  
    }  
    public void testFromProtoWithNullContainer() {
 */  
            .setBoost(2.0f)
    private GeoDistanceQueryBuilderProtoConverter converter;
    }  
        assertTrue("QueryBuilder should be a GeoDistanceQueryBuilder", queryBuilder instanceof GeoDistanceQueryBuilder);  
            QueryContainer.QueryContainerCase.GEO_DISTANCE,  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
            .setDistance("10km")  
            "Converter should handle GEO_DISTANCE case",
        GeoDistanceQueryBuilder geoDistanceQueryBuilder = (GeoDistanceQueryBuilder) queryBuilder;
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertEquals("Latitude should match", 40.7, geoDistanceQueryBuilder.point().getLat(), 0.001);  
    @Override  
    public void setUp() throws Exception {
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertTrue(
 * this file be licensed under the Apache-2.0 license or a
        // Verify the result
package org.opensearch.transport.grpc.proto.request.search.query;
        );
import org.opensearch.test.OpenSearchTestCase;  
            exception.getMessage().contains("QueryContainer does not contain a GeoDistance query")  
}  
            converter.getHandledQueryCase()
 *
        assertEquals("Field name should match", "location", geoDistanceQueryBuilder.fieldName());
import org.opensearch.protobufs.LatLonGeoLocation;
        QueryContainer queryContainer = QueryContainer.newBuilder().setGeoDistance(geoDistanceQuery).build();  
 * The OpenSearch Contributors require contributions made to  
/*  
        assertEquals(
        );
        super.setUp();
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();  
            .build();
            .putLocation("location", geoLocation)
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));  
            "Exception message should mention 'QueryContainer does not contain a GeoDistance query'",
    }  
        assertEquals("Longitude should match", -74.0, geoDistanceQueryBuilder.point().getLon(), 0.001);
    }
        assertEquals("Query name should match", "test_geo_distance_query", geoDistanceQueryBuilder.queryName());
import org.opensearch.index.query.GeoDistanceQueryBuilder;  
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        assertEquals("Distance should match", 10000.0, geoDistanceQueryBuilder.distance(), 0.001);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.protobufs.GeoDistanceQuery;
import org.opensearch.index.query.QueryBuilder;
