            return Collections.emptyList();
                vec.add(new Point2D.Double(xVec.get(i), yVec.get(i)));
        final List<double[]> pointsList = new ArrayList<>();
                    yVec.add(lastRight - y);
    }  
     * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
                double x = xPool.get(i);
         * @param xPool a {@link List} of {@link Double}
            }  
            // Sort the vectors by angle
                minPolygonX = Math.min(minPolygonX, x);
        }  
        pointsList.add(y);
            List<Point2D.Double> vec = new ArrayList<>(n);
            java.util.List<Double> xVec = new ArrayList<>(n);
    /*
            LOG.debug("One of the X or Y list is empty or null. X.size : {} Y.size : {}", xPool, yPool);
public class PolygonGenerator {
     * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
            for (int i = 1; i < n - 1; i++) {
     * @param xPool a {@link java.util.List} of {@link Double}
                y += vec.get(i).getY();
     * Permission is hereby granted, free of charge, to any person obtaining a copy
                if (random.nextBoolean()) {
            y[iterator] = generatedPolygonPointsList.get(iterator).getY();  
        final List<Point2D.Double> generatedPolygonPointsList = ValtrAlgorithm.generateRandomConvexPolygon(xPool, yPool, random);
            final List<Double> xPool,
 */
                    lastRight = y;
            final Double maxY = yPool.get(n - 1);
/*  
        IntStream.range(0, generatedPolygonPointsList.size()).forEach(iterator -> {
                double y = yPool.get(i);
     * in the Software without restriction, including without limitation the rights  
     * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  
    }
            for (int i = 0; i < n; i++) {  
     *
     * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
     * SOFTWARE.
                } else {
            xVec.add(maxX - lastTop);
            double xShift = minX - minPolygonX;  
         */
/**
     * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
import org.apache.logging.log4j.LogManager;
         * @return a {@link List} of {@link Point2D.Double}
            final Random random  
                points.add(new Point2D.Double(x, y));
     * of this software and associated documentation files (the "Software"), to deal
                    lastTop = x;  
            double yShift = minY - minPolygonY;
 * The OpenSearch Contributors require contributions made to  
                }
     */  
    private static final Logger LOG = LogManager.getLogger(PolygonGenerator.class);
            double lastTop = minX, lastBot = minX;
            double x = 0, y = 0;
        pointsList.add(x);  
     * copies or substantial portions of the Software.  
     * polygons in the test cases.  
            final int n = xPool.size();
            xVec.add(lastBot - maxX);
            }  
        final double[] x = new double[generatedPolygonPointsList.size()];
                    lastBot = x;  
     * @return a {@link List} of double array.  
            double lastLeft = minY, lastRight = minY;
 * this file be licensed under the Apache-2.0 license or a
                minPolygonY = Math.min(minPolygonY, y);
     * Provides a helper function to create a Polygon with a list of points. This source code is used to create the
                } else {  
import java.util.Random;
            List<Point2D.Double> points = new ArrayList<>(n);
     * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
import java.util.List;  
    /**  
            Collections.shuffle(yVec, random);
import org.opensearch.core.common.util.CollectionUtils;  
                }  
            }
            x[iterator] = generatedPolygonPointsList.get(iterator).getX();
import java.util.Comparator;
        });
            // Lay them end-to-end
            java.util.List<Double> yVec = new ArrayList<>(n);  
            double minPolygonY = 0;
            final Double minY = yPool.get(0);
            // Divide the interior points into two chains & Extract the vector components
     * @param yPool a {@link java.util.List} of {@link Double}
import java.awt.geom.Point2D;
}  
        return pointsList;
     *  
     * A helper function to create the Polygons for testing. The returned list of double array where first element
                    xVec.add(x - lastTop);
            for (int i = 0; i < n; i++) {
         *
     *
            double minPolygonX = 0;  
 * this helper to create the Polygons, rather than hardcoding the values.  
            Collections.sort(xPool);
                if (random.nextBoolean()) {  
                    lastLeft = y;
import org.apache.logging.log4j.Logger;
            final Double minX = xPool.get(0);
     * MIT License  
         * @param yPool a {@link List} of {@link Double}  
        final double[] y = new double[generatedPolygonPointsList.size()];  
import java.util.stream.IntStream;
     * The above copyright notice and this permission notice shall be included in all
     *  
            yVec.add(lastRight - maxY);
 *
        }  
 * compatible open source license.
        if (CollectionUtils.isEmpty(xPool) || CollectionUtils.isEmpty(yPool)) {  
            }
     * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 */  
            // Randomly pair up the X- and Y-components  
 * Helper class to generate a polygon. Keeping this in the src folder so that GeoSpatial plugin can take advantage of
            final List<Double> yPool,
     */
            for (int i = 1; i < n - 1; i++) {  
import java.util.Collections;
     */  
     * copies of the Software, and to permit persons to whom the Software is
            final Double maxX = xPool.get(n - 1);  
            yVec.add(maxY - lastLeft);  
            // Move the polygon to the original min and max coordinates
    private static class ValtrAlgorithm {
    /**
package org.opensearch.geo.algorithm;
 * SPDX-License-Identifier: Apache-2.0
            // Sort them  
            return points;
            // Isolate the extreme points
     * Copyright (c) 2017 Sander Verdonschot
            }
            Collections.sort(yPool);
                    yVec.add(y - lastLeft);
            Collections.sort(vec, Comparator.comparingDouble(v -> Math.atan2(v.getY(), v.getX())));
        private static List<Point2D.Double> generateRandomConvexPolygon(  
     * <a href="https://cglab.ca/~sander/misc/ConvexGeneration/ValtrAlgorithm.java">Reference Link</a>
         * Generates a convex polygon using the points provided as a {@link List} of {@link Double} for both X and Y axis.  
                    xVec.add(lastBot - x);
        ) {
     *
     * contains all the X points and second contains all the Y points.
            for (int i = 0; i < n; i++) {  
    public static List<double[]> generatePolygon(final List<Double> xPool, final List<Double> yPool, final Random random) {
import java.util.ArrayList;  
        /**
     * <a href="https://observablehq.com/@tarte0/generate-random-simple-polygon">Visual Link</a>
            // Combine the paired up components into vectors  
                x += vec.get(i).getX();
                Point2D.Double p = points.get(i);
                points.set(i, new Point2D.Double(p.x + xShift, p.y + yShift));
     * furnished to do so, subject to the following conditions:  
