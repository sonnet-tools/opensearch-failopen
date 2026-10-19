        assertEquals("Longitude should match", -73.9851, result.getLon(), 0.0001);
        );
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(37.7749).setLon(-122.4194).build();
    public void testParseGeoPointWithLatLon() {
    }
            .addDoubleArray(40.7589)    // lat  
    }
        GeoPoint point = new GeoPoint();  
    public void testParseGeoPointWithLatLonInPlace() {  
        GeoPoint point = new GeoPoint();
        // Test with ignoreZValue = true
        assertEquals("Latitude should match", 37.7749, result.getLat(), 0.0001);
        assertEquals("Latitude should match", 40.7589, result.getLat(), 0.0001);
 * this file be licensed under the Apache-2.0 license or a
            exception.getMessage().contains("does not accept more than 3 values")
        assertEquals("Latitude should match", 37.7749, result.getLat(), 0.0001);  
        );  
        );
import org.opensearch.protobufs.GeoHashLocation;  
        );  
            .addDoubleArray(-122.4194)  // Only lon, missing lat  
        // Create a DoubleArray GeoLocation with [lon, lat, z] with non-zero z and ignoreZValue = false  
            exception.getMessage().contains("at least two dimensions")  
 * compatible open source license.
        IllegalArgumentException exception = expectThrows(
        );
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);  
    }  
        assertEquals("Longitude should match", -73.9851, result.getLon(), 0.0001);
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation)
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation)  
 * The OpenSearch Contributors require contributions made to  
        // Create a DoubleArray GeoLocation with [lon, lat, z] with z=0 and ignoreZValue = false  
            .addDoubleArray(37.7749)    // lat
        org.opensearch.OpenSearchParseException exception = expectThrows(  
            .build();
        // Test the simple parseGeoPoint method
            "Exception message should mention z value",
        GeoLocation geoLocation = GeoLocation.newBuilder().setText("POINT(-73.9851 40.7589)").build();
public class GeoPointProtoUtilsTests extends OpenSearchTestCase {
        GeoLocation geoLocation = GeoLocation.newBuilder().build();
        GeoPoint point = new GeoPoint();
            "Exception message should mention z value",  
import org.opensearch.protobufs.GeoLocation;
        GeoLocation geoLocation = GeoLocation.newBuilder().setText("40.7589,-73.9851").build();
        assertNotNull("GeoPoint should not be null", result);  
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();  
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
        // Test the in-place parseGeoPoint method  
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation, point, true, GeoUtils.EffectivePoint.BOTTOM_LEFT);
            .addDoubleArray(0.0)        // z (elevation)
        assertNotNull("GeoPoint should not be null", result);
    }
            .addDoubleArray(-122.4194)  // lon  
        // Test with ignoreZValue = false and z = 0.0 (should throw OpenSearchParseException)
            .build();
        assertTrue(
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation, point, false, GeoUtils.EffectivePoint.BOTTOM_LEFT)  
            .build();
        );
            "Exception message should mention 'does not accept more than 3 values'",  
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation, point, false, GeoUtils.EffectivePoint.BOTTOM_LEFT);
 */  
    public void testParseGeoPointWithDoubleArrayThreeDimensions() {
    }
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
            org.opensearch.OpenSearchParseException.class,
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
        assertNotNull("GeoPoint should not be null", result);  
    public void testParseGeoPointWithDoubleArrayThreeDimensionsNoIgnore() {
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation)
import org.opensearch.protobufs.DoubleArray;
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
        // Test with ignoreZValue = false and non-zero z (should throw OpenSearchParseException)  
    public void testParseGeoPointWithDoubleArrayThreeDimensionsWithNonZeroZ() {
        // We'll just check that the values are reasonable
            .addDoubleArray(37.7749)    // lat
        IllegalArgumentException exception = expectThrows(  
            .addDoubleArray(-122.4194)  // lon
        // Create a geohash GeoLocation
import org.opensearch.common.geo.GeoUtils;
        assertEquals("Longitude should match", -122.4194, result.getLon(), 0.0001);  
    }
 * SPDX-License-Identifier: Apache-2.0
        // Create a LatLon GeoLocation
    public void testParseGeoPointWithEmptyGeoLocation() {  
        DoubleArray doubleArray = DoubleArray.newBuilder()  
    }
        assertTrue("Longitude should be reasonable", result.getLon() > -75.0 && result.getLon() < -73.0);  
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);  
        );
            "Exception message should mention 'at least two dimensions'",
            .addDoubleArray(-73.9851)   // lon  
            .build();  
    }
        assertEquals("Longitude should match", -73.9851, result.getLon(), 0.0001);
            exception.getMessage().contains("found Z value [0.0] but [ignore_z_value] parameter is [false]")
package org.opensearch.transport.grpc.proto.request.common;
        // Create a DoubleArray GeoLocation with [lon, lat]
        GeoPoint point = new GeoPoint();
            () -> GeoPointProtoUtils.parseGeoPoint(geoLocation, point, false, GeoUtils.EffectivePoint.BOTTOM_LEFT)
        GeoHashLocation geohashLocation = GeoHashLocation.newBuilder()  
        // Create a DoubleArray GeoLocation with [lon, lat, z]
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7589).setLon(-73.9851).build();  
        assertEquals("Latitude should match", 40.7589, result.getLat(), 0.0001);
            .addDoubleArray(100.0)      // z (elevation)  
            org.opensearch.OpenSearchParseException.class,
        org.opensearch.OpenSearchParseException exception = expectThrows(
        DoubleArray doubleArray = DoubleArray.newBuilder()  
        // Create a DoubleArray GeoLocation with only one dimension
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);  
        assertNotNull("GeoPoint should not be null", result);
        DoubleArray doubleArray = DoubleArray.newBuilder()
        // Create a WKT POINT GeoLocation  
    }  
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);
        assertNotNull("GeoPoint should not be null", result);
    public void testParseGeoPointWithWKTPoint() {
        // Geohash dr5regy corresponds approximately to the NYC area  
        assertTrue("Exception message should mention 'geo_point expected'", exception.getMessage().contains("geo_point expected"));  
    public void testParseGeoPointWithDoubleArrayTooFewDimensions() {  
            .addDoubleArray(40.7589)    // lat
            IllegalArgumentException.class,
            IllegalArgumentException.class,
            exception.getMessage().contains("but [ignore_z_value] parameter is [false]")
 *
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
        assertTrue("Latitude should be reasonable", result.getLat() > 40.0 && result.getLat() < 41.0);
            IllegalArgumentException.class,  
        assertEquals("Longitude should match", -73.9851, result.getLon(), 0.0001);  
        assertNotNull("GeoPoint should not be null", result);
        GeoPoint result = GeoPointProtoUtils.parseGeoPoint(geoLocation);
            .build();
            .setGeohash("dr5regy")  // Approximate geohash for NYC area
            .addDoubleArray(100.0)      // z  
    public void testParseGeoPointWithDoubleArrayTooManyDimensions() {
        assertEquals("Longitude should match", -122.4194, result.getLon(), 0.0001);
/*  
            .addDoubleArray(200.0)      // extra dimension
            .addDoubleArray(-73.9851)   // lon
import org.opensearch.common.geo.GeoPoint;  
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();  
        assertSame("Should return the same instance", point, result);
            .build();
import org.opensearch.protobufs.LatLonGeoLocation;
        // Create a LatLon GeoLocation
        IllegalArgumentException exception = expectThrows(
        // According to OpenSearch, even z=0.0 throws an exception when ignoreZValue is false
        );
        // Create a text-based GeoLocation
}
            .build();
        assertTrue(  
        assertEquals("Latitude should match", 40.7589, result.getLat(), 0.0001);
        // Create an empty GeoLocation (no location type set)
    }
        DoubleArray doubleArray = DoubleArray.newBuilder()
        assertTrue(
    }  
        );  
    public void testParseGeoPointWithDoubleArrayTwoDimensions() {  
        DoubleArray doubleArray = DoubleArray.newBuilder()
        assertEquals("Latitude should match", 40.7589, result.getLat(), 0.0001);  
        assertTrue(
            .addDoubleArray(-73.9851)   // lon
    public void testParseGeoPointWithText() {  
        // Create a DoubleArray GeoLocation with four dimensions
            .addDoubleArray(40.7589)    // lat
import org.opensearch.test.OpenSearchTestCase;  
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
    }  
            .addDoubleArray(100.0)      // non-zero z (elevation)
        GeoLocation geoLocation = GeoLocation.newBuilder().setGeohash(geohashLocation).build();
        DoubleArray doubleArray = DoubleArray.newBuilder()
    public void testParseGeoPointWithGeohash() {
