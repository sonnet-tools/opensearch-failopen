    private GeoPointProtoUtils() {
/**
     *   <li>Double arrays: {@code [lon, lat]} or {@code [lon, lat, z]}</li>
                    GeoPoint.assertZValue(ignoreZValue, doubleArray.getDoubleArray(2));
     * @param geoLocation the protobuf GeoLocation to parse
 * into their corresponding OpenSearch GeoPoint implementations.
            org.opensearch.protobufs.GeoHashLocation geohashLocation = geoLocation.getGeohash();
        } else {
     */
    ) {
        } else if (geoLocation.hasGeohash()) {
     * @param point the GeoPoint to modify in-place
        }
     * @throws IllegalArgumentException if the geo location format is invalid or unsupported
 */  
 * this file be licensed under the Apache-2.0 license or a
                    // Z value is ignored as GeoPoint doesn't support elevation  
        GeoLocation geoLocation,  
 *
package org.opensearch.transport.grpc.proto.request.common;
import org.opensearch.common.geo.GeoPoint;  
}
     * @return A GeoPoint object representing the parsed location
import org.opensearch.common.geo.GeoUtils;
     * Supports multiple geo location formats:
    public static GeoPoint parseGeoPoint(GeoLocation geoLocation) {
     *   <li>Lat/Lon objects: {@code {lat: 37.7749, lon: -122.4194}}</li>  
            if (count < 2) {
                point.resetLat(lat);  
     * <ul>
    }
                if (count == 3 && !ignoreZValue) {
        if (geoLocation.hasLatlon()) {  
        return parseGeoPoint(geoLocation, point, false, GeoUtils.EffectivePoint.BOTTOM_LEFT);  
     *   <li>Geohash: {@code "9q8yyk0"}</li>
                double lon = doubleArray.getDoubleArray(0);
            throw new IllegalArgumentException("geo_point expected");  
    }
     * @param ignoreZValue whether to ignore Z values (elevation)  
        GeoPoint point,
        GeoPoint point = new GeoPoint();
/*  
     *  
import org.opensearch.protobufs.GeoLocation;
                }
 */
            org.opensearch.protobufs.DoubleArray doubleArray = geoLocation.getCoords();  
     * This method modifies the provided GeoPoint in-place and returns it.
                double lat = doubleArray.getDoubleArray(1);
public class GeoPointProtoUtils {
            } else {  
        // Utility class, no instances
     * @param geoLocation The Protocol Buffer GeoLocation to parse  
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
            } else if (count > 3) {
     */  
        } else if (geoLocation.hasText()) {
     * @param effectivePoint the effective point interpretation for coordinate ordering
            // String format: "lat,lon", WKT, or geohash  
 * This class provides shared functionality for converting protobuf geo location representations  
            org.opensearch.protobufs.LatLonGeoLocation latLon = geoLocation.getLatlon();
     *   <li>Text formats: {@code "37.7749, -122.4194"} or {@code "POINT(-122.4194 37.7749)"}</li>  
        boolean ignoreZValue,
                point.resetLon(lon);
    }  
                throw new IllegalArgumentException("[geo_point] field type should have at least two dimensions");  
            int count = doubleArray.getDoubleArrayCount();
 *
    public static GeoPoint parseGeoPoint(
            }  
 * Utility class for parsing Protocol Buffer GeoLocation objects into OpenSearch GeoPoint objects.
     *
        } else if (geoLocation.hasCoords()) {
            point.resetLat(latLon.getLat());
 * SPDX-License-Identifier: Apache-2.0
    /**  
    /**
        GeoUtils.EffectivePoint effectivePoint  
            String val = geoLocation.getText();
            point.resetLon(latLon.getLon());  
        return point;  
     * Parses a GeoLocation protobuf into a GeoPoint, following the same pattern as GeoUtils.parseGeoPoint().
                throw new IllegalArgumentException("[geo_point] field type does not accept more than 3 values");
            point.resetFromGeoHash(geohashLocation.getGeohash());  
     * @throws IllegalArgumentException if the GeoLocation format is invalid  
     * </ul>
            point.resetFromString(val, ignoreZValue, effectivePoint);
     * @return the same GeoPoint instance that was passed in (modified)
 * compatible open source license.
     * Parses a Protocol Buffer GeoLocation into an OpenSearch GeoPoint.  
