        assertEquals("Query name should match", "comprehensive_geo_distance_query", query.queryName());
            .putLocation("location", geoLocation)
    public void testFromProtoWithQueryName() {
    }
            GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            .setGeohash("drm3btev3e86")
                .setDistance("")
        assertEquals("Distance type should be PLANE", org.opensearch.common.geo.GeoDistance.PLANE, query.geoDistance());
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .build();
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_MI,
        assertNotNull("Query should not be null", query);
import org.opensearch.protobufs.LatLonGeoLocation;
        assertNotNull("Query should not be null", query);
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_M)
        assertNotNull("Query should not be null", query);
            .setDistance("10km")
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
    }
            .setXName("location")
        expectThrows(IllegalArgumentException.class, () -> {
            .setXName("location")
            .build();
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        // Test ignoreUnmapped = true
        DistanceUnit[] expectedUnits = {
package org.opensearch.transport.grpc.proto.request.search.query;
                .build();
    public void testFromProtoWithTextGeoLocation() {
            DistanceUnit.MILES,
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            .setDistance("10km")
                .build();
                .setXName("")
        assertEquals("Longitude should match", -74.0, query.point().getLon(), 0.001);
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
        });
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_STRICT)
import org.opensearch.index.query.GeoDistanceQueryBuilder;
            .setIgnoreUnmapped(true)
                .build();
        assertEquals("Field name should match", "geo_field", query.fieldName());
        // Distance is returned in meters, so 5mi = 8046.72m (approximately)
            .setDistance("1000") // Numeric string
    }
import org.opensearch.protobufs.DoubleArray;
            .build();
        assertNotNull("Query should not be null", query);
        // Test PLANE distance type
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
        org.opensearch.protobufs.DistanceUnit[] units = {
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
 * The OpenSearch Contributors require contributions made to
            .setIgnoreUnmapped(false)
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
import org.opensearch.index.query.GeoValidationMethod;
                .setUnit(units[i])
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_MM,
        assertEquals("Validation method should be STRICT", GeoValidationMethod.STRICT, query.getValidationMethod());
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        });
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
    }
            .setXName("comprehensive_geo_distance_query")
    }
            .setXName("location")
            .addDoubleArray(40.7)  // lat
        });
        assertNotNull("Query should not be null", query);
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            .addDoubleArray(-74.0) // lon
                .putLocation("", geoLocation)
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_M,
        assertNotNull("Query should not be null", query);
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_CM,
            DistanceUnit.METERS,
            GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
import org.opensearch.protobufs.GeoDistanceQuery;
import org.opensearch.common.unit.DistanceUnit;
    public void testFromProtoWithNumericDistance() {
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_NMI,
    public void testFromProtoWithDistanceUnits() {
        assertEquals("Distance should be 1000 meters", 1000.0, query.distance(), 0.001);
            .setXName("location")
            .build();
                .setXName("location")
 * this file be licensed under the Apache-2.0 license or a
                .build();
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .setXName("location")
            .build();
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        assertFalse("Ignore unmapped should be false", query.ignoreUnmapped());
        assertEquals("Validation method should be COERCE", GeoValidationMethod.COERCE, query.getValidationMethod());
                                                                                                                                // location
        assertEquals("Distance should match", 8046.72, query.distance(), 0.1);
        assertEquals("Latitude should match", 40.7, query.point().getLat(), 0.001);
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
import org.opensearch.protobufs.GeoDistanceType;
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        assertEquals("Latitude should match", 40.7, query.point().getLat(), 0.001);
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
    public void testFromProtoWithDistanceTypes() {
            .putLocation("location", geoLocation)
            .putLocation("location", geoLocation)
        query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            .setBoost(1.8f)
    public void testFromProtoWithNullFieldName() {
        // Test different distance units
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        expectThrows(IllegalArgumentException.class, () -> {
            .setDistance("10km")
        assertNotNull("Query should not be null", query);
                .setDistance("10km")
                .putLocation("location", geoLocation)
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
        }
        // Test STRICT validation method
    public void testFromProtoWithIgnoreUnmapped() {
            .build();
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
            DistanceUnit.INCH,
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_FT,
            DistanceUnit.KILOMETERS,
            .setXName("location")
    }
}
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
        assertEquals("Distance type should be ARC", org.opensearch.common.geo.GeoDistance.ARC, query.geoDistance());
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        GeoLocation geoLocation = GeoLocation.newBuilder().setGeohash(geohashLocation).build();
    public void testFromProtoWithEmptyDistance() {
            .setUnit(org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_MI)
        assertEquals("Validation method should be IGNORE_MALFORMED", GeoValidationMethod.IGNORE_MALFORMED, query.getValidationMethod());
                .build();
                .setDistance("10km")
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_COERCE)
        assertNotNull("Query should not be null", query);
        assertEquals("Field name should match", "location", query.fieldName());
            .setDistance("10km")
            .build();
        // Test COERCE validation method
    public void testFromProtoWithAllParameters() {
            .putLocation("geo_field", geoLocation)
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_KM,
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7589).setLon(-73.9851).build();
            .setDistance("5")
        };
            .build();
        DoubleArray doubleArray = DoubleArray.newBuilder()
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            .putLocation("location", geoLocation)
            .setIgnoreUnmapped(true)
    public void testFromProtoWithLatLon() {
        geoDistanceQuery = GeoDistanceQuery.newBuilder()
 * compatible open source license.
        assertEquals("Longitude should match", -74.0, query.point().getLon(), 0.001);
 */
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .setXName("location")
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
            .putLocation("location", geoLocation)
            .setXName("my_geo_distance_query")
    }
    public void testFromProtoWithValidationMethods() {
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
                                                                                                                                // added
                // No distance set - should be null
    }
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
        // Distance is returned in meters, so 10km = 10000m
            .build();
                .setXName("location")
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            DistanceUnit.YARD,
            // This should trigger the null field name check
    public void testFromProtoWithEmptyFieldName() {
            .putLocation("location", geoLocation)
            .setBoost(2.5f)
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_PLANE)
            .setDistance("10km")
            .build();
    public void testFromProtoWithBoost() {
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder().setXName("location").setDistance("10km").build(); // No
        // Test ignoreUnmapped = false
            .setDistance("10km")
    }
        // Note: The proto uses string for distance, but internally it may be treated as a Number
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
        assertEquals("Field name should match", "location", query.fieldName());
        expectThrows(IllegalArgumentException.class, () -> {
            .setXName("location")
        // Test ARC distance type
        });
        query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
                .setXName("location")
        assertEquals("Field name should match", "location", query.fieldName());
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        assertEquals("Longitude should match", -74.0, query.point().getLon(), 0.001);
            assertNotNull("Query should not be null for unit " + units[i], query);
        expectThrows(IllegalArgumentException.class, () -> {
        // Test IGNORE_MALFORMED validation method
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .setDistance("10km")
        assertEquals("Boost should match", 2.5f, query.boost(), 0.001f);
            DistanceUnit.METERS // Default
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_IN,
            .build();
            .setXName("location")
            .putLocation("location", geoLocation)
        assertNotNull("Query should not be null", query);
        assertTrue("Ignore unmapped should be true", query.ignoreUnmapped());
        assertNotNull("Query should not be null", query);
            .build();
        assertNotNull("Query should not be null", query);
            GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            .putLocation("location", geoLocation)
            .setDistance("10km")
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Field name should match", "location", query.fieldName());
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
    }
        assertEquals("Distance should be 5 miles in meters", 8046.72, query.distance(), 0.1);
        for (int i = 0; i < units.length; i++) {
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            .putLocation("location", geoLocation)
        assertEquals("Validation method should be COERCE", GeoValidationMethod.COERCE, query.getValidationMethod());
/*
            .putLocation("location", geoLocation)
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
        // Test with numeric distance (this tests the Number vs String branch in the code)
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
            GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .setDistance("10km")
        assertNotNull("Query should not be null", query);
                .putLocation("location", geoLocation)
            LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
            .putLocation("location", geoLocation)
            GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        assertEquals("Distance type should be PLANE", org.opensearch.common.geo.GeoDistance.PLANE, query.geoDistance());
            .build();
            .setXName("location")
            .build();
            .putLocation("location", geoLocation)
    }
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_COERCE)
public class GeoDistanceQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_PLANE)
    }
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
        query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
                .setXName("location")
        assertEquals("Latitude should match", 40.7589, query.point().getLat(), 0.0001);
            .setXName("location")
            .setValidationMethod(org.opensearch.protobufs.GeoValidationMethod.GEO_VALIDATION_METHOD_IGNORE_MALFORMED)
            .build();
            DistanceUnit.FEET,
    }
import org.opensearch.protobufs.GeoLocation;
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_YD,
            DistanceUnit.CENTIMETERS,
        assertNotNull("Query should not be null", query);
        assertEquals("Longitude should match", -73.9851, query.point().getLon(), 0.0001);
        query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        geoDistanceQuery = GeoDistanceQuery.newBuilder()
            .setDistance("2km")
    }
        geoDistanceQuery = GeoDistanceQuery.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
            .setXName("location")
                .putLocation("", geoLocation) // Empty field name
        expectThrows(IllegalArgumentException.class, () -> {
        assertEquals("Distance should match", 10000.0, query.distance(), 0.001);
        assertEquals("Latitude should match", 40.7, query.point().getLat(), 0.001);
            .build();
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
    }
            DistanceUnit.MILLIMETERS,
        assertEquals("Query name should match", "my_geo_distance_query", query.queryName());
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
            .putLocation("location", geoLocation)
        assertNotNull("Query should not be null", query);
    }
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
    }
                .putLocation("location", geoLocation)
        assertTrue("Ignore unmapped should be true", query.ignoreUnmapped());
        GeoDistanceQueryBuilder query = GeoDistanceQueryBuilderProtoUtils.fromProto(geoDistanceQuery);
        geoDistanceQuery = GeoDistanceQuery.newBuilder()
        GeoLocation geoLocation = GeoLocation.newBuilder().setText("40.7,-74.0").build();
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
    public void testFromProtoWithEmptyLocationMap() {
 *
        });
            .setDistance("10km")
    public void testFromProtoWithDoubleArrayGeoLocation() {
            LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
            .build();
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        assertEquals("Boost should match", 1.8f, query.boost(), 0.001f);
    public void testFromProtoWithGeohash() {
    public void testFromProtoWithNullDistance() {
            org.opensearch.protobufs.DistanceUnit.DISTANCE_UNIT_UNSPECIFIED };
        // Test with text format "lat,lon"
        org.opensearch.protobufs.GeoHashLocation geohashLocation = org.opensearch.protobufs.GeoHashLocation.newBuilder()
            .setXName("location")
            GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
            DistanceUnit.NAUTICALMILES,
            .setDistance("5mi")
            .putLocation("location", geoLocation)
            .setDistanceType(GeoDistanceType.GEO_DISTANCE_TYPE_ARC)
            .setDistance("5mi")
        // Test with DoubleArray format [lon, lat]
        assertNotNull("Query should not be null", query);
                .setDistance("100")
            LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7).setLon(-74.0).build();
