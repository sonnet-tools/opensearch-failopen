    private static double intersection(double p1x, double p2x) {
                shift = newShift;
 *
    }
/*
        }  
            lats[i] = lonLat[1];  
                performShift(shift, partLons);
        }
 */
 *
            decomposeLine(line, collector);  
            int direction = Double.compare(lons[i], lons[i - 1]);  
/**  
            normalizePoint(lonLat, false, true);
            collector.add(new Line(partLons, partLats));
     * p1x must be with in -180 +180 range
 * @opensearch.internal  
        if (shift != 0) {
import static org.opensearch.common.geo.GeoUtils.normalizePoint;
 *  
            } else {
 * compatible open source license.
                // Check if new point intersects with anti-meridian  
 * Unless required by applicable law or agreed to in writing,
        if (!include180 && normalized == 180.0) {  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    collector.add(new Line(partLons, partLats));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    i++;
     * if include180 is true.
            double[] partLats = Arrays.copyOfRange(lats, offset, lats.length);  
        }
        }
        double[] lats = new double[lons.length];  
     */
 * software distributed under the License is distributed on an
import java.util.List;
 * not use this file except in compliance with the License.
    }  
            double newShift = calculateShift(lons[i - 1], direction < 0);
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 *
                double t = intersection(lons[i - 1] + shift, lons[i] + shift);
    }
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
                shift = newShift;
            performShift(shift, lons);
    private static void decompose(double[] lons, double[] lats, List<Line> collector) {
 * Licensed to Elasticsearch under one or more contributor  
                    // Found intersection, all previous segments are now part of the linestring
    /**
    }
    /**
                // Jumping over anti-meridian - we need to start a new segment
                    // Didn't find intersection - just continue checking
     * Checks it the segment from p1x to p2x intersects with anti-meridian
        } else {
                } else {  
        double[] lons = new double[line.length()];
    }
     */
        while (i < lons.length) {
    private static void performShift(double shift, double[] lons) {  
    private static double calculateShift(double lon, boolean include180) {  
        for (Line line : multiLine) {
 * Modifications Copyright OpenSearch Contributors. See
            }
    public static void decomposeLine(Line line, List<Line> collector) {
                if (Double.isNaN(t) == false) {  
 * under the License.  
    /**  
        if (t >= 1 || t <= 0) {  
                double[] partLons = Arrays.copyOfRange(lons, offset, i);
        } else if (offset < lons.length - 1) {
                offset = i - 1;  
            double[] lonLat = new double[] { line.getX(i), line.getY(i) };  
 * this file be licensed under the Apache-2.0 license or a
    /**  
            double[] partLons = Arrays.copyOfRange(lons, offset, lons.length);
 */  
package org.opensearch.common.geo;
        double normalized = GeoUtils.centeredModulus(lon, 360);
     */  
                    lats[i - 1] = partLats[partLats.length - 1] = lats[i - 1] + (lats[i] - lats[i - 1]) * t;
                collector.add(new Line(partLons, partLats));
            return Double.NaN;  
    /**
                }  
}  
 * Splits lines by datelines.
 * GitHub history for details.
            return Double.NaN;
import java.util.Arrays;
            // first point lon + shift is always between -180.0 and +180.0
     * Calculates how many degres the given longitude needs to be moved east in order to be in -180 - +180. +180 is inclusive only  
        for (int i = 0; i < lons.length; i++) {
        int offset = 0;  
     * Decompose a linestring given as array of coordinates by anti-meridian.  
     */
        int i = 1;  
import org.opensearch.geometry.MultiLine;
public class GeoLineDecomposer {
            for (int j = 0; j < lons.length; j++) {
 * SPDX-License-Identifier: Apache-2.0
    public static void decomposeMultiLine(MultiLine multiLine, List<Line> collector) {
        // no instances
 * the Apache License, Version 2.0 (the "License"); you may
                    offset = i - 1;
            return;  
 * specific language governing permissions and limitations
        double shift = Math.round(normalized - lon);
        decompose(lons, lats, collector);
            performShift(shift, partLons);
        if (offset == 0) {
    private GeoLineDecomposer() {  
        }
        }
    private static final double DATELINE = 180;
        if (p1x == p2x) {
        }
 */
        return shift;  
                    double[] partLons = Arrays.copyOfRange(lons, offset, i + 1);
/*  
                lons[j] = lons[j] + shift;  
            shift = shift - 360;
            return t;  
 * this work for additional information regarding copyright
            if (i - offset > 1 && newShift != shift) {  
     * Splits the specified line by datelines and adds them to the supplied lines array
     */  
        }
 * ownership. Elasticsearch licenses this file to you under  
            collector.add(new Line(lons, lats));  
        if (line.isEmpty()) {
                    lons[i - 1] = partLons[partLons.length - 1] = (direction > 0 ? DATELINE : -DATELINE) - shift;
     * shifts all coordinates by shift
 */  
/*  
                    performShift(shift, partLons);  
            }
                    double[] partLats = Arrays.copyOfRange(lats, offset, i + 1);  
        final double t = ((p1x < p2x ? DATELINE : -DATELINE) - p1x) / (p2x - p1x);
        double shift = 0;
    }
            // Check where the line is going east (+1), west (-1) or directly north/south (0)
                double[] partLats = Arrays.copyOfRange(lats, offset, i);  
import org.opensearch.geometry.Line;
            lons[i] = lonLat[0];
        }
