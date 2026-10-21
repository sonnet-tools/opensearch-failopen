        assertTrue("Longitude should be reasonable", result.getLon() > -75.0 && result.getLon() < -73.0);
        assertEquals("Longitude should match", -73.9851, result.getLon(), 0.0001);
        );
        // We'll just check that the values are reasonable
    }
 * SPDX-License-Identifier: Apache-2.0
        DoubleArray doubleArray = DoubleArray.newBuilder()
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation, point, false, GeoUtils.EffectivePoint.BOTTOM_LEFT)
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation)
            .addDoubleArray(-73.9851)   // lon
    }
    public void testParseGeoPointWithDoubleArrayTwoDimensions() {
        );
        assertNotNull("GeoPoint should not be null", result);
            "Exception message should mention z value",
        );
        assertNotNull("GeoPoint should not be null", result);
 */
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
        assertEquals("Latitude should match", 37.7749, result.getLat(), 0.0001);
        // Create a DoubleArray GeoLocation with [lon, lat, z] with z=0 and ignoreZValue = false
import org.opensearch.protobufs.LatLonGeoLocation;
            .addDoubleArray(-73.9851)   // lon
        GeoLocation geoLocation = GeoLocation.newBuilder().setGeohash(geohashLocation).build();
    public void testParseGeoPointWithWKTPoint() {
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);
        GeoPoint point = new GeoPoint();
        IllegalArgumentException exception = expectThrows(
        // Geohash dr5regy corresponds approximately to the NYC area
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(37.7749).setLon(-122.4194).build();
            IllegalArgumentException.class,
        IllegalArgumentException exception = expectThrows(
    public void testParseGeoPointWithLatLonInPlace() {
            exception.getMessage().contains("found Z value [0.0] but [ignore_z_value] parameter is [false]")
import org.opensearch.common.geo.GeoUtils;
        // Test with ignoreZValue = true
            .setGeohash("dr5regy")  // Approximate geohash for NYC area
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation)
    }
        // According to OpenSearch, even z=0.0 throws an exception when ignoreZValue is false
import org.opensearch.protobufs.GeoLocation;
            .addDoubleArray(40.7589)    // lat
            exception.getMessage().contains("does not accept more than 3 values")
 * The OpenSearch Contributors require contributions made to
        // Create an empty GeoLocation (no location type set)
            org.opensearch.OpenSearchParseException.class,
            "Exception message should mention 'at least two dimensions'",
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
            exception.getMessage().contains("but [ignore_z_value] parameter is [false]")
    }
            .addDoubleArray(40.7589)    // lat
        DoubleArray doubleArray = DoubleArray.newBuilder()
        DoubleArray doubleArray = DoubleArray.newBuilder()
    }
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);
        // Create a DoubleArray GeoLocation with [lon, lat, z] with non-zero z and ignoreZValue = false
        // Create a text-based GeoLocation
        assertEquals("Latitude should match", 37.7749, result.getLat(), 0.0001);
        // Test with ignoreZValue = false and non-zero z (should throw OpenSearchParseException)
        // Create a LatLon GeoLocation
        assertTrue(
        GeoLocation geoLocation = GeoLocation.newBuilder().build();
    public void testParseGeoPointWithDoubleArrayTooFewDimensions() {
        );
 * compatible open source license.
            "Exception message should mention 'does not accept more than 3 values'",
            .addDoubleArray(-73.9851)   // lon
    public void testParseGeoPointWithGeohash() {
            .build();
        );
 *
        assertTrue(
        // Create a LatLon GeoLocation
            .build();
import org.opensearch.protobufs.GeoHashLocation;
        assertNotNull("GeoPoint should not be null", result);
        assertTrue(
        assertTrue("Exception message should mention 'geo_point expected'", exception.getMessage().contains("geo_point expected"));
        assertEquals("Latitude should match", 40.7589, result.getLat(), 0.0001);
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation, point, true, GeoUtils.EffectivePoint.BOTTOM_LEFT);
        GeoPoint point = new GeoPoint();
            org.opensearch.OpenSearchParseException.class,
        assertNotNull("GeoPoint should not be null", result);
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
        assertEquals("Longitude should match", -73.9851, result.getLon(), 0.0001);
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.geo.GeoPoint;
        assertNotNull("GeoPoint should not be null", result);
    public void testParseGeoPointWithLatLon() {
        GeoLocation geoLocation = GeoLocation.newBuilder().setText("POINT(-73.9851 40.7589)").build();
        IllegalArgumentException exception = expectThrows(
    }
    }
        DoubleArray doubleArray = DoubleArray.newBuilder()
        assertTrue("Latitude should be reasonable", result.getLat() > 40.0 && result.getLat() < 41.0);
        DoubleArray doubleArray = DoubleArray.newBuilder()
            .addDoubleArray(100.0)      // z
    public void testParseGeoPointWithEmptyGeoLocation() {
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation)
    }
            .addDoubleArray(-122.4194)  // lon
/*
            .build();
        GeoPoint point = new GeoPoint();
            exception.getMessage().contains("at least two dimensions")
        assertEquals("Longitude should match", -73.9851, result.getLon(), 0.0001);
    public void testParseGeoPointWithDoubleArrayTooManyDimensions() {
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation, point, false, GeoUtils.EffectivePoint.BOTTOM_LEFT)
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        // Create a WKT POINT GeoLocation
        // Create a DoubleArray GeoLocation with only one dimension
import org.opensearch.protobufs.DoubleArray;
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);
            .addDoubleArray(37.7749)    // lat
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);
        org.opensearch.OpenSearchParseException exception = expectThrows(
        );
    public void testParseGeoPointWithText() {
            .addDoubleArray(40.7589)    // lat
            IllegalArgumentException.class,
    }
        );
            .build();
            IllegalArgumentException.class,
        // Create a DoubleArray GeoLocation with [lon, lat, z]
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
    public void testParseGeoPointWithDoubleArrayThreeDimensionsWithNonZeroZ() {
    public void testParseGeoPointWithDoubleArrayThreeDimensionsNoIgnore() {
        assertEquals("Longitude should match", -122.4194, result.getLon(), 0.0001);
}
        assertEquals("Longitude should match", -73.9851, result.getLon(), 0.0001);
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation, point, false, GeoUtils.EffectivePoint.BOTTOM_LEFT);
        // Create a DoubleArray GeoLocation with [lon, lat]
            .build();
        assertEquals("Latitude should match", 40.7589, result.getLat(), 0.0001);
            .addDoubleArray(100.0)      // z (elevation)
            .build();
        );
        org.opensearch.OpenSearchParseException exception = expectThrows(
    }
        // Test with ignoreZValue = false and z = 0.0 (should throw OpenSearchParseException)
            .addDoubleArray(-122.4194)  // Only lon, missing lat
        assertSame("Should return the same instance", point, result);
            .addDoubleArray(-122.4194)  // lon
            .addDoubleArray(100.0)      // non-zero z (elevation)
        DoubleArray doubleArray = DoubleArray.newBuilder()
        // Test the simple parseGeoPoint method
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
            .addDoubleArray(200.0)      // extra dimension
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
public class GeoPointProtoUtilsTests extends OpenSearchTestCase {
        // Create a DoubleArray GeoLocation with four dimensions
            .build();
        assertEquals("Latitude should match", 40.7589, result.getLat(), 0.0001);
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.transport.grpc.proto.request.common;
        assertEquals("Longitude should match", -122.4194, result.getLon(), 0.0001);
    }
        // Test the in-place parseGeoPoint method
        GeoLocation geoLocation = GeoLocation.newBuilder().setText("40.7589,-73.9851").build();
    public void testParseGeoPointWithDoubleArrayThreeDimensions() {
        assertEquals("Latitude should match", 40.7589, result.getLat(), 0.0001);
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7589).setLon(-73.9851).build();
        assertNotNull("GeoPoint should not be null", result);
        // Create a geohash GeoLocation
    }
        assertTrue(
            "Exception message should mention z value",
            .addDoubleArray(37.7749)    // lat
        GeoHashLocation geohashLocation = GeoHashLocation.newBuilder()
        GeoPoint point = new GeoPoint();
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);
        );
            .addDoubleArray(0.0)        // z (elevation)
