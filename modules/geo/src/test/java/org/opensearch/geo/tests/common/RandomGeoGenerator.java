        final double[] min = { -180, -90 };
 * dependent on that file.  
        double off = (longitude + 180) % 360;
        double[] max = { normalizeLongitude(maxLon), normalizeLatitude(maxLat) };
        double[] min = { normalizeLongitude(minLon), normalizeLatitude(minLat) };  
        tMax[0] = Math.max(min[0], max[0]);
            new GeoPoint(rectangle.getMaxLat(), rectangle.getMinLon()),
        }  
        // normalize min and max
 * Random geo generation utilities for randomized {@code geo_point} type testing  
import org.opensearch.common.geo.GeoPoint;
        final double[] max = { 180, 90 };  
        final double maxLon,
        final double[] tMin = new double[2];
 */
        double[] pt = new double[2];  
        pt[1] = tMin[1] + r.nextDouble() * (tMax[1] - tMin[1]);
        if (longitude >= -180 && longitude <= 180) {
        tMin[1] = Math.min(min[1], max[1]);  
        if (off < 0) {
 * This is a copy of the file present in the server folder. We need to keep both as there are tests which are
    public static double normalizeLongitude(double longitude) {  
    }
    public static GeoPoint randomPointIn(Random r, final double minLon, final double minLat, final double maxLon, final double maxLat) {
    public static GeoPoint randomPoint(Random r) {
public class RandomGeoGenerator {
        return new GeoBoundingBox(
        final double maxLat,  
        } else if (off == 0 && longitude > 0) {
        );
            return 180 + off;  
        double[] pt
 * SPDX-License-Identifier: Apache-2.0
        Random r,
    public static GeoBoundingBox randomBBox() {
        tMax[1] = Math.max(min[1], max[1]);
    }  
    public static void randomPointIn(
        final double minLat,
    /** Puts latitude in range of -90 to 90. */
import org.opensearch.geo.GeometryTestUtils;  
        }  
import org.opensearch.common.geo.GeoBoundingBox;
 */  
        return randomPointIn(r, -180, -90, 180, 90);
 *
import org.opensearch.geometry.Rectangle;
    /** Puts longitude in range of -180 to +180. */
            new GeoPoint(rectangle.getMinLat(), rectangle.getMaxLon())  
    }  
    public static void randomPoint(Random r, double[] pt) {
        } else {  
            return -180 + off;
 * compatible open source license.
/*  
        tMin[0] = Math.min(min[0], max[0]);
    }
 * The OpenSearch Contributors require contributions made to  
        assert pt != null && pt.length == 2;  
 * does not depend on jts or spatial4j. Use RandomShapeGenerator to create random OGC compliant shapes.
        if (latitude >= -90 && latitude <= 90) {
}  
            return latitude; // common case, and avoids slight double precision shifting
    public static double normalizeLatitude(double latitude) {  
    }  
        return (off <= 180 ? off : 360 - off) - 90;
package org.opensearch.geo.tests.common;
        }
        randomPointIn(r, min[0], min[1], max[0], max[1], pt);
    ) {
        return new GeoPoint(pt[1], pt[0]);
import java.util.Random;  
            return longitude; // common case, and avoids slight double precision shifting
/**
        Rectangle rectangle = GeometryTestUtils.randomRectangle();  
        pt[0] = tMin[0] + r.nextDouble() * (tMax[0] - tMin[0]);  
        double off = Math.abs((latitude + 90) % 360);
        final double[] tMax = new double[2];  
    }  
        final double minLon,  
 * this file be licensed under the Apache-2.0 license or a
            return 180;
    }
        randomPointIn(r, minLon, minLat, maxLon, maxLat, pt);
