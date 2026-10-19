            assertNotNull("Query should not be null for unit " + units[i], query);
        assertEquals("Latitude should match", 40.7589, query.point().getLat(), 0.0001);  
    public void testFromProtoWithGeohash() {  
        // Test ARC distance type
        assertEquals("Distance type should be ARC", org.opensearch.common.geo.GeoDistance.ARC, query.geoDistance());  
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        // Test COERCE validation method
        assertEquals("Latitude should match", 40.7, query.point().getLat(), 0.001);  
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_YD,
        assertEquals("Field name should match", "geo_field", query.fieldName());
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();  
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        // Test with DoubleArray format [lon, lat]
        assertNotNull("Query should not be null", query);
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_STRICT)
        assertNotNull("Query should not be null", query);  
            .setDistance("10km")
            .putLocation("location", geoLocation)
import org.opensearch.protobufs.GeoDistanceQuery;
            GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            .build();  
                .setXName("location")
    public void testFromProtoWithBoost() {  
    public void testFromProtoWithDoubleArrayGeoLocation() {
    public void testFromProtoWithTextGeoLocation() {  
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);  
 *
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()  
        assertNotNull("Query should not be null", query);
        assertEquals("Longitude should match", -74.0, query.point().getLon(), 0.001);  
    }
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        for (int i = 0; i < units.length; i++) {  
        // Test ignoreUnmapped = false
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()  
        geoDistanceQuery = GeoDistanceQuery.newBuilder()
    }
            .setBoost(1.8f)  
        assertFalse("Ignore unmapped should be false", query.ignoreUnmapped());  
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_CM,  
            .putLocation("location", geoLocation)
 * compatible open source license.
        assertEquals("Distance should match", 10000.0, query.distance(), 0.001);  
    }
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .setDistance("5")
        // Test ignoreUnmapped = true  
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()  
package org.opensearch.transport.grpc.proto.request.search.query;
                .setDistance("")  
                .build();
    }
            DistanceUnit.YARD,
    public void testFromProtoWithNullFieldName() {  
    }
            .build();  
            DistanceUnit.NAUTICALMILES,
            .setDistance("10km")
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()  
        query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);  
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();  
            DistanceUnit.MILLIMETERS,  
            .setXName("location")
        assertEquals("Boost should match", 2.5f, query.boost(), 0.001f);
        assertEquals("Boost should match", 1.8f, query.boost(), 0.001f);  
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
                                                                                                                                // location
        });
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_NMI,
            .setDistance("2km")  
        assertNotNull("Query should not be null", query);
        assertNotNull("Query should not be null", query);
        // Test PLANE distance type  
            .setXName("location")
            .setGeohash("drm3btev3e86")
            .addDoubleArray(40.7)  // lat
        assertEquals("Validation method should be IGNORE_MALFORMED", GeoValidationMethod.IGNORE_MALFORMED, query.getValidationMethod());
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .build();
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_ARC)
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        geoDistanceQuery = GeoDistanceQuery.newBuilder()  
    public void testFromProtoWithEmptyFieldName() {  
import org.opensearch.protobufs.GeoDistanceType;
        assertNotNull("Query should not be null", query);
        query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
                .setDistance("10km")
            .setXName("location")
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            .build();  
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_FT,
        assertTrue("Ignore unmapped should be true", query.ignoreUnmapped());
 * this file be licensed under the Apache-2.0 license or a
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_MI,
    public void testFromProtoWithAllParameters() {
    }  
            .putLocation("location", geoLocation)
            .setDistance("10km")  
            DistanceUnit.INCH,
import org.opensearch.index.query.GeoValidationMethod;
        assertNotNull("Query should not be null", query);
            .putLocation("location", geoLocation)
    }  
        assertEquals("Longitude should match", -74.0, query.point().getLon(), 0.001);  
            DistanceUnit.FEET,
        // Test with text format "lat,lon"
    public void testFromProtoWithEmptyLocationMap() {
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            .setDistance("10km")  
        assertEquals("Validation method should be COERCE", GeoValidationMethod.COERCE, query.getValidationMethod());
            GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            .setIgnoreUnmapped(true)
            .putLocation("location", geoLocation)
 * SPDX-License-Identifier: Apache-2.0
            LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();  
                .setXName("location")
    public void testFromProtoWithNumericDistance() {  
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        assertNotNull("Query should not be null", query);  
        expectThrows(IllegalArgumentException.class, () -> {  
    }
            .setXName("location")
        DistanceUnit[] expectedUnits = {
                .putLocation("location", geoLocation)
            .build();  
            GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            .build();
            .putLocation("location", geoLocation)  
            .setXName("location")
}
            LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();  
        // Note: The proto uses string for distance, but internally it may be treated as a Number
        // Test with numeric distance (this tests the Number vs String branch in the code)
            .setXName("location")  
        query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);  
        assertEquals("Latitude should match", 40.7, query.point().getLat(), 0.001);
        assertEquals("Query name should match", "my_geo_distance_query", query.queryName());  
        DoubleArray doubleArray = DoubleArray.newBuilder()  
        expectThrows(IllegalArgumentException.class, () -> {
            .setDistance("10km")  
                                                                                                                                // added  
    }
        // Distance is returned in meters, so 10km = 10000m
        geoDistanceQuery = GeoDistanceQuery.newBuilder()
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();  
            .setXName("location")  
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7589).setLon(-73.9851).build();
        assertEquals("Longitude should match", -73.9851, query.point().getLon(), 0.0001);
        assertEquals("Query name should match", "comprehensive_geo_distance_query", query.queryName());
            .setDistance("10km")
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
                .setUnit(units[i])
        assertEquals("Validation method should be COERCE", GeoValidationMethod.COERCE, query.getValidationMethod());  
        expectThrows(IllegalArgumentException.class, () -> {
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_M)  
            .build();
/*  
            .setDistance("10km")
        });  
        });
        expectThrows(IllegalArgumentException.class, () -> {
        GeoLocation geoLocation = GeoLocation.newBuilder().setGeohash(geohashLocation).build();
        assertNotNull("Query should not be null", query);  
                .putLocation("", geoLocation) // Empty field name  
            .setXName("location")
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
            .setXName("comprehensive_geo_distance_query")  
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_M,
            .putLocation("location", geoLocation)
            .build();
        assertEquals("Field name should match", "location", query.fieldName());
            .putLocation("location", geoLocation)
            DistanceUnit.CENTIMETERS,  
            .putLocation("geo_field", geoLocation)
    }
            .build();
        assertEquals("Field name should match", "location", query.fieldName());
        assertNotNull("Query should not be null", query);  
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_IN,
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_COERCE)
        assertEquals("Distance should match", 8046.72, query.distance(), 0.1);  
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_UNSPECIFIED };  
                .putLocation("location", geoLocation)
            GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();  
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_IGNORE_MALFORMED)  
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_MI)
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();  
                // No distance set - should be null
        assertNotNull("Query should not be null", query);
                .setXName("location")
import org.opensearch.common.unit.DistanceUnit;  
                .setDistance("100")  
                .setDistance("10km")
    public void testFromProtoWithDistanceTypes() {
    }
            GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
    public void testFromProtoWithValidationMethods() {  
        assertNotNull("Query should not be null", query);  
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            .setDistance("5mi")  
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder().setXName("location").setDistance("10km").build(); // No
            .putLocation("location", geoLocation)  
        expectThrows(IllegalArgumentException.class, () -> {
                .build();
        org.opensearch.protobufs.GeoHashLocation geohashLocation = org.opensearch.protobufs.GeoHashLocation.newBuilder()
    }
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
public class GeoDistanceQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            DistanceUnit.METERS // Default  
    public void testFromProtoWithQueryName() {
        assertNotNull("Query should not be null", query);  
import org.opensearch.index.query.GeoDistanceQueryBuilder;
                .build();
                .putLocation("location", geoLocation)  
import org.opensearch.protobufs.DoubleArray;  
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
            .build();
    }  
                .build();  
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);  
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        assertEquals("Distance type should be PLANE", org.opensearch.common.geo.GeoDistance.PLANE, query.geoDistance());  
                .build();
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);  
        assertNotNull("Query should not be null", query);
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);  
            .setIgnoreUnmapped(true)
        // Test different distance units
        }
        assertEquals("Latitude should match", 40.7, query.point().getLat(), 0.001);
        assertEquals("Distance should be 5 miles in meters", 8046.72, query.distance(), 0.1);
 */  
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
                .putLocation("", geoLocation)  
        assertEquals("Longitude should match", -74.0, query.point().getLon(), 0.001);
            .setXName("location")
    }  
    }
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
                .setXName("location")
        query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
    public void testFromProtoWithNullDistance() {
            // This should trigger the null field name check
            .build();  
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_MM,  
            DistanceUnit.MILES,
            .setXName("location")  
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            .setXName("location")
            .setXName("location")  
            .setXName("location")
        // Distance is returned in meters, so 5mi = 8046.72m (approximately)
            .putLocation("location", geoLocation)
    public void testFromProtoWithEmptyDistance() {
import org.opensearch.test.OpenSearchTestCase;
            .setDistance("5mi")  
    public void testFromProtoWithIgnoreUnmapped() {
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
            DistanceUnit.KILOMETERS,  
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            .build();  
    public void testFromProtoWithDistanceUnits() {  
        assertEquals("Field name should match", "location", query.fieldName());
        };
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()  
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_PLANE)
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        assertEquals("Distance should be 1000 meters", 1000.0, query.distance(), 0.001);
import org.opensearch.protobufs.LatLonGeoLocation;
        assertEquals("Field name should match", "location", query.fieldName());
        });
            .build();
            .putLocation("location", geoLocation)
    }
        org.opensearch.protobufs.DistanceUnit[] units = {
            .addDoubleArray(-74.0) // lon
            .setIgnoreUnmapped(false)
            LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        assertEquals("Distance type should be PLANE", org.opensearch.common.geo.GeoDistance.PLANE, query.geoDistance());
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
                .setXName("")
        GeoLocation geoLocation = GeoLocation.newBuilder().setText("40.7,-74.0").build();
            .setDistance("10km")
            .setXName("my_geo_distance_query")
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_PLANE)  
            .setDistance("10km")
        assertNotNull("Query should not be null", query);
            .build();
    public void testFromProtoWithLatLon() {  
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();  
            .build();
        assertTrue("Ignore unmapped should be true", query.ignoreUnmapped());
            .setDistance("1000") // Numeric string
            DistanceUnit.METERS,
            .putLocation("location", geoLocation)  
            .setBoost(2.5f)
        // Test IGNORE_MALFORMED validation method
            .build();
        geoDistanceQuery = GeoDistanceQuery.newBuilder()
        });
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_KM,  
import org.opensearch.protobufs.GeoLocation;  
 * The OpenSearch Contributors require contributions made to  
        // Test STRICT validation method  
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .putLocation("location", geoLocation)
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_COERCE)
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);  
            .build();  
            .setDistance("10km")  
        assertEquals("Validation method should be STRICT", GeoValidationMethod.STRICT, query.getValidationMethod());
            .putLocation("location", geoLocation)  
    }
