            final double latRange = 3 * r.nextDouble() + 3;
    }
        if (nearPoint == null) {
                return mlsb;
    }
        ShapeBuilder shape;
        double width = Math.abs(r.nextGaussian()) * bounds.getWidth() / 6;// 1/3rd
                    mlsb.linestring((LineStringBuilder) createShape(r, nearPoint, within, ShapeType.LINESTRING, false));
            double t = minY;
    private static Rectangle xRandomRectangle(Random r, Point nearP, Rectangle bounds, boolean small) {
            }
    /** creates a small random rectangle by default to keep shape test performance at bay */
                    shellCoords[1] = new Coordinate(within.getMinX(), within.getMaxY());
                    shellCoords[2] = new Coordinate(within.getMaxX(), within.getMaxY());
    }
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor
    public static GeometryCollectionBuilder createGeometryCollection(Random r) throws InvalidShapeException {
        return createGeometryCollection(r, null, within, 0);
            double maxY = nearP.getY() + latRange;
public class RandomShapeGenerator extends RandomGeoGenerator {
     * as creating a large random number of random shapes can result in massive resource consumption
        return createShape(r, nearPoint, null, st);
                        // jts bug may occasionally misinterpret coordinate order causing an unhelpful ('geom' assertion)
        return createShapeNear(r, null);
    }
import org.opensearch.common.geo.builders.PointBuilder;
 * license agreements. See the NOTICE file distributed with
        MULTIPOINT,
            maxX = t;
            st = ShapeType.randomType(r);
     * The following options are included
import org.locationtech.jts.geom.Geometry;
                minX -= lonRange;
                    try {
     * @return the ShapeBuilder for a random shape
import org.locationtech.spatial4j.shape.Point;
        }
            nearPoint = xRandomPoint(r);
    }
                // (n^2-n)/2 and computing the relation intersection matrix will become NP-Hard
                return pgb;
        }
        minX = DistanceUtils.normLonDEG(minX);
    private static double xDivisible(double v) {
                    p = xRandomPointIn(r, within);
        } while (++i != 100);
                }
        }
        return r.nextInt(100) >= 90;
                return shape;
import org.opensearch.common.geo.builders.MultiPointBuilder;
        }
            case POINT:
                    }
            ShapeBuilder builder = createShapeWithin(r, bounds);
    protected static JtsSpatialContext ctx = ShapeBuilder.SPATIAL_CONTEXT;
            // a null shape. We catch that situation here, and only increment the counter when a valid shape is returned.
    }
        POLYGON;
        );
        }
        if (st == null) {
            if (shape != null) {
    public static ShapeBuilder createShape(Random r, ShapeType st) {
        throws InvalidShapeException {
        return xRandomRectangle(r, nearP, ctx.getWorldBounds(), small);
        LINESTRING,
        double[] pt = new double[2];
                    // This test framework builds semi-random geometry (in the sense that points are not truly random due to spatial
    public static Point xRandomPoint(Random r) {
        if (small) {
            maxY = DistanceUtils.normLatDEG(maxY);
     * Creates a random shape useful for randomized testing, NOTE: exercise caution when using this to build random GeometryCollections
import org.locationtech.jts.algorithm.ConvexHull;
                    : new LineStringBuilder(coordinatesBuilder);
        }
        if (nearP == null) nearP = xRandomPointIn(r, bounds);
                }
                // random point order or random linestrings can lead to invalid self-crossing polygons,
                    shellCoords[0] = new Coordinate(within.getMinX(), within.getMinY());
/*
                PolygonBuilder pgb = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoords).close());
            // due to world wrapping, and the possibility for ambiguous polygons, the random shape generation could bail with
        throws InvalidShapeException {
                throw new OpenSearchException("Unable to create shape of type [" + st + "]");
            final double lonRange = 3 * r.nextDouble() + 3;
 *
                    p = (Point) createShape(r, nearPoint, within, ShapeType.POINT, false).buildS4J();
        Point p = ctx.makePoint(pt[0], pt[1]);
    }
            maxY = t;
    }
        GeometryCollectionBuilder gcb = new GeometryCollectionBuilder();
    }
 * KIND, either express or implied.  See the License for the
        return createShapeNear(r, null, st);
        switch (st) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.junit.Assert;
 *
 * ownership. Elasticsearch licenses this file to you under
        short i = 0;
        randomPointIn(rand, r.getMinX(), r.getMinY(), r.getMaxX(), r.getMaxY(), pt);
                    shellCoords[3] = new Coordinate(within.getMaxX(), within.getMinY());
                return pb;
    }
 * under the License.
                if (validate) {
    private static Range xRandomRange(Random r, double near, Range bounds) {
 */
    public static ShapeBuilder createShapeWithin(Random r, Rectangle bbox, ShapeType st) throws InvalidShapeException {
    }
            minY = DistanceUtils.normLatDEG(minY);
    protected static boolean ST_VALIDATE = true;
/*
                }
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
            case MULTIPOINT:
 *
                        pgb.buildS4J();
                    // The validate flag will check for these possibilities and bail if an incorrect geometry is created
import java.util.Random;
            return ctx.makeRectangle(minX, maxX, minY, maxY);
import org.opensearch.common.geo.builders.MultiLineStringBuilder;
                // if this number gets out of hand, the number of self intersections for a linestring can become
/**
 */
            if (builder != null) {
    }
 * Unless required by applicable law or agreed to in writing,
 */
            if (maxX > 180) {
                        return null;
                for (int i = 0; i < numPoints; ++i) {
        maxX = DistanceUtils.normLonDEG(maxX);
        MULTILINESTRING,
        return createGeometryCollection(r, nearPoint, null, size);
     */
        return gcb;
 * Random geoshape generation utilities for randomized {@code geo_shape} type testing
                        // or InvalidShapeException
        Assert.assertEquals(CONTAINS, r.relate(p));
    public static GeometryCollectionBuilder createGeometryCollectionWithin(Random r, Rectangle within, int size)
 * the Apache License, Version 2.0 (the "License"); you may
        }
            bounds = xRandomRectangle(r, nearPoint);
                    } catch (AssertionError | InvalidShapeException e) {
    private static double xDivisible(double v, double divisible) {
import org.locationtech.spatial4j.distance.DistanceUtils;
                return pcb;
     * @param within Create a shape within the provided rectangle (note: if not null this will override the provided point)
        return (int) (Math.round(v / divisible) * divisible);
 * software distributed under the License is distributed on an
    protected static final double xDIVISIBLE = 2;
        if (bounds == null) {
        return xMakeNormRect(
        // inside non overlapping bounding rectangles
                }
                    ? new MultiPointBuilder(coordinatesBuilder.build())
        Range xRange = xRandomRange(r, rarely(r) ? 0 : nearP.getX(), Range.xRange(bounds, ctx));
    public enum ShapeType {
        if (maxY < minWorldY || maxY > maxWorldY) {
        }
    }
            }
        return new Range(mid - width / 2, mid + width / 2);
 * this work for additional information regarding copyright
    protected static Point xRandomPointIn(Random rand, Rectangle r) {
        }
}
            // between 3 and 6 degrees
            double minX = nearP.getX();
                // if points are in a line the convex hull will be 2 points which will also lead to an invalid polygon
        if (maxX < minX) {
package org.opensearch.test.geo;
            xDivisible(xRange.getMin() * 10e3) / 10e3,
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
                PointBuilder pb = new PointBuilder().coordinate(new Coordinate(p.getX(), p.getY(), Double.NaN));
import org.opensearch.common.geo.builders.LineStringBuilder;
        if (maxY < minY) {
                Coordinate[] coordinates = new Coordinate[numPoints];
    public static ShapeBuilder createShapeNear(Random r, Point nearPoint) throws InvalidShapeException {
                maxY = minY;
        return xRandomPointIn(r, ctx.getWorldBounds());
            if (maxY > 90) {
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
                maxX = minX;
    public static ShapeBuilder createShapeNear(Random r, Point nearPoint, ShapeType st) throws InvalidShapeException {
                if (shellCoords.length < 3) {
                ++i;
 * depends on jts and spatial4j
        public static ShapeType randomType(Random r) {
                gcb.shape(builder);
    }
            }
            xDivisible(yRange.getMin() * 10e3) / 10e3,
    }
        return createShape(r, null, bbox, st);
                    // intent for ambiguous polygons. Therefore, an invalid oriented dateline crossing polygon could be built.
                for (int i = 0; i < numPoints; ++i) {
        for (int i = 0; i < numGeometries;) {
        }
        return createGeometryCollection(r, null, within, size);
    }
import org.locationtech.spatial4j.shape.impl.Range;
        POINT,
    public static Rectangle xRandomRectangle(Random r, Point nearP) {
import org.opensearch.search.geo.GeoShapeQueryTests;
import static org.locationtech.spatial4j.shape.SpatialRelation.CONTAINS;
     * @param st Create a random shape of the provided type
        // NOTE: multipolygon not yet supported. Overlapping polygons are invalid so randomization
                    coordinatesBuilder.coordinate(p.getX(), p.getY());
    }
    private static ShapeBuilder createShape(Random r, Point nearPoint, Rectangle within, ShapeType st, boolean validate)
 * this file be licensed under the Apache-2.0 license or a
    }
                for (int i = 0; i < RandomNumbers.randomIntBetween(r, 1, 10); ++i) {
            minY = maxY;
    private static boolean rarely(Random r) {
    }
import org.locationtech.spatial4j.exception.InvalidShapeException;
        }
        throws InvalidShapeException {
                Coordinate[] shellCoords = shell.getCoordinates();
    public static ShapeBuilder createShapeWithin(Random r, Rectangle bbox) throws InvalidShapeException {
import org.opensearch.OpenSearchException;
            double maxX = minX + lonRange;
                CoordinatesBuilder coordinatesBuilder = new CoordinatesBuilder();
    public static GeometryCollectionBuilder createGeometryCollectionNear(Random r, Point nearPoint) throws InvalidShapeException {
    protected static GeometryCollectionBuilder createGeometryCollection(Random r, Point nearPoint, Rectangle bounds, int numGeometries)
/*
        if (numGeometries <= 0) {
        // requires an approach to avoid overlaps. This could be approached by creating polygons
        if (within == null) {
        }
            // cap geometry collection at 4 shapes (to save test time)
    public static GeometryCollectionBuilder createGeometryCollectionNear(Random r, Point nearPoint, int size) throws InvalidShapeException {
            xDivisible(yRange.getMax() * 10e3) / 10e3
 * The OpenSearch Contributors require contributions made to
        Range yRange = xRandomRange(r, rarely(r) ? 0 : nearP.getY(), Range.yRange(bounds, ctx));
                minY -= latRange;
import org.opensearch.common.geo.builders.PolygonBuilder;
            case MULTILINESTRING:
                numPoints = RandomNumbers.randomIntBetween(r, 5, 25);
            minX = maxX;
        private static final ShapeType[] types = values();
    }
        return createShape(r, nearPoint, null, null);
import org.opensearch.common.geo.builders.CoordinatesBuilder;
                MultiLineStringBuilder mlsb = new MultiLineStringBuilder();
                Geometry shell = new ConvexHull(coordinates, ctx.getGeometryFactory()).getConvexHull();
import org.locationtech.jts.geom.Coordinate;
                Point p = xRandomPointIn(r, within);
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                // when all else fails, use the bounding box as the polygon
                ShapeBuilder pcb = (st == ShapeType.MULTIPOINT)
        if (minY < minWorldY || minY > maxWorldY) {
            // Not the most efficient but its the lesser of the evil alternatives
            numGeometries = RandomNumbers.randomIntBetween(r, 2, 4);
                }
 * You may obtain a copy of the License at
            default:
 * GitHub history for details.
    public static GeometryCollectionBuilder createGeometryCollectionWithin(Random r, Rectangle within) throws InvalidShapeException {
    public static Rectangle xRandomRectangle(Random r, Point nearP, boolean small) {
                int numPoints = RandomNumbers.randomIntBetween(r, 3, 10);
     *
        return xRandomRectangle(r, nearP, ctx.getWorldBounds(), true);
    }
     * @param nearPoint Create a shape near a provided point
            return types[RandomNumbers.randomIntBetween(r, 0, types.length - 1)];
            xDivisible(xRange.getMax() * 10e3) / 10e3,
 * Modifications Copyright OpenSearch Contributors. See
        double maxWorldY = ctx.getWorldBounds().getMaxY();
            }
            case POLYGON:
     * see: {@link GeoShapeQueryTests#testQueryRandomGeoCollection()}
 */
        return createShape(r, null, bbox, null);
    }
                    // auto-correlation) As a result of the semi-random nature of the geometry, one can not predict the orientation
            double t = minX;
            case LINESTRING:
        return createGeometryCollection(r, nearPoint, null, 0);
    }
                    coordinates[i] = new Coordinate(p.getX(), p.getY());
        return p;
                // compute the convex hull for a set of points to ensure polygon does not self cross
        return xDivisible(v, xDIVISIBLE);
    protected static Rectangle xMakeNormRect(double minX, double maxX, double minY, double maxY) {
import org.opensearch.common.geo.builders.ShapeBuilder;
                    shellCoords = new Coordinate[4];
 * specific language governing permissions and limitations
        double mid = near + r.nextGaussian() * bounds.getWidth() / 6;
import org.locationtech.spatial4j.shape.Rectangle;
        return createGeometryCollection(r, null, null, 0);
            within = xRandomRectangle(r, nearPoint);
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    public static ShapeBuilder createShape(Random r) throws InvalidShapeException {
        throw new InvalidShapeException("Unable to create a valid random shape with provided seed");
                // for random testing having a maximum number of 10 points for a line string is more than sufficient
            shape = createShape(r, nearPoint, within, st, ST_VALIDATE);
    private static ShapeBuilder createShape(Random r, Point nearPoint, Rectangle within, ShapeType st) throws InvalidShapeException {
        do {
            double minY = nearP.getY();
        double minWorldY = ctx.getWorldBounds().getMinY();
    }
        return ctx.makeRectangle(minX, maxX, minY, maxY);
    /**
