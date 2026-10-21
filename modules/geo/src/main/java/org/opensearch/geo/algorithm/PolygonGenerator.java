import java.util.Collections;
         * @param xPool a {@link List} of {@link Double}
        return pointsList;
            }
    public static List<double[]> generatePolygon(final List<Double> xPool, final List<Double> yPool, final Random random) {
        private static List<Point2D.Double> generateRandomConvexPolygon(
                vec.add(new Point2D.Double(xVec.get(i), yVec.get(i)));
                double y = yPool.get(i);
            // Divide the interior points into two chains & Extract the vector components
/**
            // Sort them
                double x = xPool.get(i);
                    lastLeft = y;
            for (int i = 0; i < n; i++) {
     * MIT License
                minPolygonX = Math.min(minPolygonX, x);
     * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
            for (int i = 0; i < n; i++) {
            double yShift = minY - minPolygonY;
         */
import java.util.List;
                points.add(new Point2D.Double(x, y));
     * in the Software without restriction, including without limitation the rights
            Collections.sort(vec, Comparator.comparingDouble(v -> Math.atan2(v.getY(), v.getX())));
    /**
            return points;
         * Generates a convex polygon using the points provided as a {@link List} of {@link Double} for both X and Y axis.
     *
    }
     *
     * <a href="https://observablehq.com/@tarte0/generate-random-simple-polygon">Visual Link</a>
import org.opensearch.core.common.util.CollectionUtils;
            // Sort the vectors by angle
     * copies of the Software, and to permit persons to whom the Software is
        pointsList.add(x);
            double lastTop = minX, lastBot = minX;
     * Provides a helper function to create a Polygon with a list of points. This source code is used to create the
     * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
     *
        }
            xVec.add(maxX - lastTop);
            }
            x[iterator] = generatedPolygonPointsList.get(iterator).getX();
            return Collections.emptyList();
     * Copyright (c) 2017 Sander Verdonschot
            java.util.List<Double> xVec = new ArrayList<>(n);
        if (CollectionUtils.isEmpty(xPool) || CollectionUtils.isEmpty(yPool)) {
            Collections.sort(xPool);
 *
         * @return a {@link List} of {@link Point2D.Double}
import java.util.stream.IntStream;
                    lastBot = x;
            yVec.add(lastRight - maxY);
            double x = 0, y = 0;
            }
     * @return a {@link List} of double array.
                if (random.nextBoolean()) {
            double xShift = minX - minPolygonX;
     */
import java.util.Random;
            double minPolygonX = 0;
     * @param yPool a {@link java.util.List} of {@link Double}
     * A helper function to create the Polygons for testing. The returned list of double array where first element
            // Combine the paired up components into vectors
                } else {
 * The OpenSearch Contributors require contributions made to
    /*
            for (int i = 0; i < n; i++) {
                }
        IntStream.range(0, generatedPolygonPointsList.size()).forEach(iterator -> {
            xVec.add(lastBot - maxX);
                    yVec.add(lastRight - y);
            List<Point2D.Double> vec = new ArrayList<>(n);
            List<Point2D.Double> points = new ArrayList<>(n);
        final List<Point2D.Double> generatedPolygonPointsList = ValtrAlgorithm.generateRandomConvexPolygon(xPool, yPool, random);
 * this helper to create the Polygons, rather than hardcoding the values.
            final Double maxX = xPool.get(n - 1);
     * contains all the X points and second contains all the Y points.
            final Double minX = xPool.get(0);
                    lastTop = x;
        pointsList.add(y);
     * polygons in the test cases.
            yVec.add(maxY - lastLeft);
 */
 */
package org.opensearch.geo.algorithm;
            LOG.debug("One of the X or Y list is empty or null. X.size : {} Y.size : {}", xPool, yPool);
                }
     */
        });
            for (int i = 1; i < n - 1; i++) {
 * Helper class to generate a polygon. Keeping this in the src folder so that GeoSpatial plugin can take advantage of
            java.util.List<Double> yVec = new ArrayList<>(n);
 * this file be licensed under the Apache-2.0 license or a
     * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
import java.util.Comparator;
            final List<Double> xPool,
            Collections.sort(yPool);
import java.awt.geom.Point2D;
                } else {
                x += vec.get(i).getX();
            }
                    lastRight = y;
     *
            for (int i = 1; i < n - 1; i++) {
     * of this software and associated documentation files (the "Software"), to deal
        final double[] y = new double[generatedPolygonPointsList.size()];
     * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
            final int n = xPool.size();
                    xVec.add(x - lastTop);
     * <a href="https://cglab.ca/~sander/misc/ConvexGeneration/ValtrAlgorithm.java">Reference Link</a>
            final List<Double> yPool,
 * compatible open source license.
            Collections.shuffle(yVec, random);
                    xVec.add(lastBot - x);
            double lastLeft = minY, lastRight = minY;
            // Randomly pair up the X- and Y-components
            // Isolate the extreme points
        /**
     *
        final List<double[]> pointsList = new ArrayList<>();
import org.apache.logging.log4j.LogManager;
            final Random random
     * @param xPool a {@link java.util.List} of {@link Double}
         * @param yPool a {@link List} of {@link Double}
                    yVec.add(y - lastLeft);
}
     * The above copyright notice and this permission notice shall be included in all
            y[iterator] = generatedPolygonPointsList.get(iterator).getY();
    private static final Logger LOG = LogManager.getLogger(PolygonGenerator.class);
                if (random.nextBoolean()) {
            // Lay them end-to-end
        final double[] x = new double[generatedPolygonPointsList.size()];
     * copies or substantial portions of the Software.
                points.set(i, new Point2D.Double(p.x + xShift, p.y + yShift));
import java.util.ArrayList;
     * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
                y += vec.get(i).getY();
        ) {
import org.apache.logging.log4j.Logger;
     * furnished to do so, subject to the following conditions:
     * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    private static class ValtrAlgorithm {
            double minPolygonY = 0;
        }
 * SPDX-License-Identifier: Apache-2.0
     * Permission is hereby granted, free of charge, to any person obtaining a copy
                Point2D.Double p = points.get(i);
                minPolygonY = Math.min(minPolygonY, y);
         *
/*
     */
            // Move the polygon to the original min and max coordinates
            final Double minY = yPool.get(0);
    /**
     * SOFTWARE.
            }
     * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    }
public class PolygonGenerator {
            final Double maxY = yPool.get(n - 1);
