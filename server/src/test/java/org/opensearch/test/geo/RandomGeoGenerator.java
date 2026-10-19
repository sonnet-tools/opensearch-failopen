    }
        Random r,
    private static double normalizeLongitude(double longitude) {
    }
        final double[] max = { 180, 90 };
 */
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public static GeoPoint randomPointIn(Random r, final double minLon, final double minLat, final double maxLon, final double maxLat) {
    private static double normalizeLatitude(double latitude) {
        double[] max = { normalizeLongitude(maxLon), normalizeLatitude(maxLat) };  
        randomPointIn(r, min[0], min[1], max[0], max[1], pt);  
        tMax[1] = Math.max(min[1], max[1]);  
        double off = Math.abs((latitude + 90) % 360);  
    /** Puts longitude in range of -180 to +180. */
 * does not depend on jts or spatial4j. Use {@link org.opensearch.test.geo.RandomShapeGenerator}
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (longitude >= -180 && longitude <= 180) {  
        final double minLon,
    }
 */  
    }
        }
        double[] pt  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    /** Puts latitude in range of -90 to 90. */
 * Licensed to Elasticsearch under one or more contributor  
        assert pt != null && pt.length == 2;
    }
        }
        final double[] min = { -180, -90 };
        }
        if (off < 0) {
 * the Apache License, Version 2.0 (the "License"); you may
        return randomPointIn(r, -180, -90, 180, 90);
 * The OpenSearch Contributors require contributions made to  
/*  
package org.opensearch.test.geo;
import java.util.Random;  
        return new GeoPoint(pt[1], pt[0]);
        final double minLat,  
 * to create random OGC compliant shapes.
        double[] min = { normalizeLongitude(minLon), normalizeLatitude(minLat) };
import org.opensearch.common.geo.GeoPoint;
 */  
 *
 *
    ) {
 *  
        double off = (longitude + 180) % 360;  
        return (off <= 180 ? off : 360 - off) - 90;
 * this work for additional information regarding copyright
    public static GeoPoint randomPoint(Random r) {  
/*  
 * software distributed under the License is distributed on an
 */  
/**
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * Random geo generation utilities for randomized {@code geo_point} type testing  
        final double[] tMin = new double[2];
            return 180 + off;
        tMax[0] = Math.max(min[0], max[0]);
    }
        final double[] tMax = new double[2];
            return latitude; // common case, and avoids slight double precision shifting
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        tMin[0] = Math.min(min[0], max[0]);  
        pt[1] = tMin[1] + r.nextDouble() * (tMax[1] - tMin[1]);  
 * KIND, either express or implied.  See the License for the
        double[] pt = new double[2];
    public static void randomPointIn(  
        final double maxLat,
        tMin[1] = Math.min(min[1], max[1]);
        } else {
}  
    public static void randomPoint(Random r, double[] pt) {  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        randomPointIn(r, minLon, minLat, maxLon, maxLat, pt);  
        if (latitude >= -90 && latitude <= 90) {  
/*
        // normalize min and max
            return 180;
public class RandomGeoGenerator {
        final double maxLon,
        } else if (off == 0 && longitude > 0) {  
            return -180 + off;  
            return longitude; // common case, and avoids slight double precision shifting
        pt[0] = tMin[0] + r.nextDouble() * (tMax[0] - tMin[0]);
