        if (nearP == null) nearP = xRandomPointIn(r, bounds);  
                if (shellCoords.length < 3) {
                // if this number gets out of hand, the number of self intersections for a linestring can become
    public static ShapeBuilder createShapeWithin(Random r, Rectangle bbox) throws InvalidShapeException {  
                return shape;
                return mlsb;  
            if (builder != null) {
            minY = DistanceUtils.normLatDEG(minY);
public class RandomShapeGenerator extends RandomGeoGenerator {  
    }  
 * Random geoshape generation utilities for randomized {@code geo_shape} type testing  
        return xMakeNormRect(
 *  
    public static ShapeBuilder createShapeWithin(Random r, Rectangle bbox, ShapeType st) throws InvalidShapeException {
 * KIND, either express or implied.  See the License for the
        Range yRange = xRandomRange(r, rarely(r) ? 0 : nearP.getY(), Range.yRange(bounds, ctx));  
            // between 3 and 6 degrees  
import java.util.Random;  
    public static GeometryCollectionBuilder createGeometryCollection(Random r) throws InvalidShapeException {
        }
        );
        return ctx.makeRectangle(minX, maxX, minY, maxY);  
        return xDivisible(v, xDIVISIBLE);
        private static final ShapeType[] types = values();
    public static GeometryCollectionBuilder createGeometryCollectionNear(Random r, Point nearPoint) throws InvalidShapeException {  
        double mid = near + r.nextGaussian() * bounds.getWidth() / 6;  
    }  
                    // auto-correlation) As a result of the semi-random nature of the geometry, one can not predict the orientation  
    }
                        pgb.buildS4J();
                PolygonBuilder pgb = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoords).close());  
            // due to world wrapping, and the possibility for ambiguous polygons, the random shape generation could bail with
        double width = Math.abs(r.nextGaussian()) * bounds.getWidth() / 6;// 1/3rd
        return xRandomPointIn(r, ctx.getWorldBounds());  
            double minX = nearP.getX();
        if (maxY < minY) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        public static ShapeType randomType(Random r) {  
            if (maxY > 90) {  
        } while (++i != 100);  
                    }  
        return gcb;
            double maxY = nearP.getY() + latRange;
        double[] pt = new double[2];
                    mlsb.linestring((LineStringBuilder) createShape(r, nearPoint, within, ShapeType.LINESTRING, false));
/**
        if (maxY < minWorldY || maxY > maxWorldY) {
    }
        if (within == null) {
}
    }  
    }
 *
        }  
    protected static Point xRandomPointIn(Random rand, Rectangle r) {  
 * depends on jts and spatial4j
        }
    protected static boolean ST_VALIDATE = true;
                    : new LineStringBuilder(coordinatesBuilder);
 * ownership. Elasticsearch licenses this file to you under  
    }
        }  
import org.opensearch.common.geo.builders.CoordinatesBuilder;
        return r.nextInt(100) >= 90;
import org.locationtech.spatial4j.shape.Rectangle;  
    }
        }  
        do {
                gcb.shape(builder);  
                return pb;  
    }
                return pgb;
        return createShape(r, null, bbox, st);
                for (int i = 0; i < numPoints; ++i) {
        // inside non overlapping bounding rectangles
/*  
        return new Range(mid - width / 2, mid + width / 2);
                    shellCoords[3] = new Coordinate(within.getMaxX(), within.getMinY());
                minX -= lonRange;
        for (int i = 0; i < numGeometries;) {  
import org.opensearch.common.geo.builders.ShapeBuilder;
    }
import org.opensearch.common.geo.builders.PolygonBuilder;
import org.locationtech.spatial4j.shape.impl.Range;
            xDivisible(xRange.getMax() * 10e3) / 10e3,
            xDivisible(yRange.getMax() * 10e3) / 10e3  
                if (validate) {
    public static GeometryCollectionBuilder createGeometryCollectionWithin(Random r, Rectangle within, int size)  
/*
    /** creates a small random rectangle by default to keep shape test performance at bay */
    }
 * this work for additional information regarding copyright
    private static double xDivisible(double v, double divisible) {
                maxX = minX;
                    p = xRandomPointIn(r, within);  
            // cap geometry collection at 4 shapes (to save test time)
        }
                    shellCoords = new Coordinate[4];  
 * SPDX-License-Identifier: Apache-2.0
        return createShape(r, nearPoint, null, null);
                    coordinates[i] = new Coordinate(p.getX(), p.getY());  
        return xRandomRectangle(r, nearP, ctx.getWorldBounds(), true);  
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case POINT:  
        throws InvalidShapeException {
        MULTIPOINT,
                }
 * this file be licensed under the Apache-2.0 license or a
    public static ShapeBuilder createShapeNear(Random r, Point nearPoint) throws InvalidShapeException {
        if (maxX < minX) {
 * under the License.  
import org.locationtech.spatial4j.exception.InvalidShapeException;
        ShapeBuilder shape;
        }
 */
                }
        POLYGON;
     * The following options are included  
import org.opensearch.search.geo.GeoShapeQueryTests;  
            if (shape != null) {  
            shape = createShape(r, nearPoint, within, st, ST_VALIDATE);
    /**
        }
import org.locationtech.spatial4j.distance.DistanceUtils;  
                        // jts bug may occasionally misinterpret coordinate order causing an unhelpful ('geom' assertion)  
import org.opensearch.common.geo.builders.MultiPointBuilder;
                    ? new MultiPointBuilder(coordinatesBuilder.build())
    public static ShapeBuilder createShapeNear(Random r, Point nearPoint, ShapeType st) throws InvalidShapeException {
            final double latRange = 3 * r.nextDouble() + 3;
                        // or InvalidShapeException
            }  
        if (minY < minWorldY || minY > maxWorldY) {
            }  
            st = ShapeType.randomType(r);
    }
    public static Point xRandomPoint(Random r) {
                    shellCoords[0] = new Coordinate(within.getMinX(), within.getMinY());
    protected static JtsSpatialContext ctx = ShapeBuilder.SPATIAL_CONTEXT;
        Point p = ctx.makePoint(pt[0], pt[1]);  
        if (nearPoint == null) {  
        Assert.assertEquals(CONTAINS, r.relate(p));
import org.opensearch.common.geo.builders.MultiLineStringBuilder;
        Range xRange = xRandomRange(r, rarely(r) ? 0 : nearP.getX(), Range.xRange(bounds, ctx));
                }
    public static Rectangle xRandomRectangle(Random r, Point nearP) {
        switch (st) {
import org.opensearch.OpenSearchException;  
    public static GeometryCollectionBuilder createGeometryCollectionNear(Random r, Point nearPoint, int size) throws InvalidShapeException {
                for (int i = 0; i < numPoints; ++i) {
                Coordinate[] coordinates = new Coordinate[numPoints];  
        return xRandomRectangle(r, nearP, ctx.getWorldBounds(), small);
import org.locationtech.jts.geom.Coordinate;  
        }  
    public static ShapeBuilder createShape(Random r) throws InvalidShapeException {
     * @param within Create a shape within the provided rectangle (note: if not null this will override the provided point)
                Point p = xRandomPointIn(r, within);
                Geometry shell = new ConvexHull(coordinates, ctx.getGeometryFactory()).getConvexHull();
    public static ShapeBuilder createShape(Random r, ShapeType st) {  
package org.opensearch.test.geo;
 * Licensed to Elasticsearch under one or more contributor  
        GeometryCollectionBuilder gcb = new GeometryCollectionBuilder();
 * Unless required by applicable law or agreed to in writing,
        return createGeometryCollection(r, null, within, 0);  
            ShapeBuilder builder = createShapeWithin(r, bounds);
    }
            within = xRandomRectangle(r, nearPoint);
                // random point order or random linestrings can lead to invalid self-crossing polygons,
                ShapeBuilder pcb = (st == ShapeType.MULTIPOINT)  
                ++i;
 * The OpenSearch Contributors require contributions made to  
        randomPointIn(rand, r.getMinX(), r.getMinY(), r.getMaxX(), r.getMaxY(), pt);
                    // This test framework builds semi-random geometry (in the sense that points are not truly random due to spatial
        }
    protected static Rectangle xMakeNormRect(double minX, double maxX, double minY, double maxY) {
        LINESTRING,  
                // compute the convex hull for a set of points to ensure polygon does not self cross  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    }
                }
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
        return p;
        return createGeometryCollection(r, null, within, size);
 * specific language governing permissions and limitations
            minY = maxY;  
    public enum ShapeType {  
 */  
                numPoints = RandomNumbers.randomIntBetween(r, 5, 25);
    public static Rectangle xRandomRectangle(Random r, Point nearP, boolean small) {  
                throw new OpenSearchException("Unable to create shape of type [" + st + "]");
        minX = DistanceUtils.normLonDEG(minX);
 * You may obtain a copy of the License at  
 */
            }
    }
                return pcb;  
                    } catch (AssertionError | InvalidShapeException e) {
 * GitHub history for details.
                // (n^2-n)/2 and computing the relation intersection matrix will become NP-Hard
    private static ShapeBuilder createShape(Random r, Point nearPoint, Rectangle within, ShapeType st) throws InvalidShapeException {
            xDivisible(xRange.getMin() * 10e3) / 10e3,  
                Coordinate[] shellCoords = shell.getCoordinates();
            maxX = t;
        throws InvalidShapeException {  
        // NOTE: multipolygon not yet supported. Overlapping polygons are invalid so randomization
        throw new InvalidShapeException("Unable to create a valid random shape with provided seed");
        POINT,
    }  
            if (maxX > 180) {  
            case POLYGON:
            double t = minX;  
 * license agreements. See the NOTICE file distributed with
     * see: {@link GeoShapeQueryTests#testQueryRandomGeoCollection()}
     * Creates a random shape useful for randomized testing, NOTE: exercise caution when using this to build random GeometryCollections
    private static ShapeBuilder createShape(Random r, Point nearPoint, Rectangle within, ShapeType st, boolean validate)  
 * not use this file except in compliance with the License.
        if (small) {
     * as creating a large random number of random shapes can result in massive resource consumption  
        return (int) (Math.round(v / divisible) * divisible);  
        return createGeometryCollection(r, nearPoint, null, size);
            minX = maxX;
    private static double xDivisible(double v) {  
     */
    }
                        return null;
     * @param nearPoint Create a shape near a provided point
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
        maxX = DistanceUtils.normLonDEG(maxX);  
    }  
            case MULTIPOINT:
    public static GeometryCollectionBuilder createGeometryCollectionWithin(Random r, Rectangle within) throws InvalidShapeException {
        double maxWorldY = ctx.getWorldBounds().getMaxY();  
        }  
            default:  
    }  
            numGeometries = RandomNumbers.randomIntBetween(r, 2, 4);  
            xDivisible(yRange.getMin() * 10e3) / 10e3,
 */  
                    coordinatesBuilder.coordinate(p.getX(), p.getY());
                MultiLineStringBuilder mlsb = new MultiLineStringBuilder();
 * software distributed under the License is distributed on an
    }
    }  
                CoordinatesBuilder coordinatesBuilder = new CoordinatesBuilder();
    }
        if (bounds == null) {
     *
import org.locationtech.jts.algorithm.ConvexHull;
        double minWorldY = ctx.getWorldBounds().getMinY();
        return createGeometryCollection(r, nearPoint, null, 0);
                    try {  
                // when all else fails, use the bounding box as the polygon
            double maxX = minX + lonRange;
import org.opensearch.common.geo.builders.LineStringBuilder;  
                    p = (Point) createShape(r, nearPoint, within, ShapeType.POINT, false).buildS4J();
        return createShapeNear(r, null);  
        if (st == null) {  
            final double lonRange = 3 * r.nextDouble() + 3;
            bounds = xRandomRectangle(r, nearPoint);
                for (int i = 0; i < RandomNumbers.randomIntBetween(r, 1, 10); ++i) {  
        return createGeometryCollection(r, null, null, 0);  
        return createShape(r, null, bbox, null);
            case LINESTRING:
        throws InvalidShapeException {
                // for random testing having a maximum number of 10 points for a line string is more than sufficient  
import org.locationtech.jts.geom.Geometry;
                PointBuilder pb = new PointBuilder().coordinate(new Coordinate(p.getX(), p.getY(), Double.NaN));
/*  
    private static Rectangle xRandomRectangle(Random r, Point nearP, Rectangle bounds, boolean small) {
            double t = minY;
            maxY = t;
        if (numGeometries <= 0) {
 * compatible open source license.
        MULTILINESTRING,
                    // The validate flag will check for these possibilities and bail if an incorrect geometry is created
import org.locationtech.spatial4j.shape.Point;
            // a null shape. We catch that situation here, and only increment the counter when a valid shape is returned.  
    private static Range xRandomRange(Random r, double near, Range bounds) {
                maxY = minY;
                    shellCoords[2] = new Coordinate(within.getMaxX(), within.getMaxY());  
                    shellCoords[1] = new Coordinate(within.getMinX(), within.getMaxY());
import org.opensearch.common.geo.builders.PointBuilder;  
     * @return the ShapeBuilder for a random shape
import static org.locationtech.spatial4j.shape.SpatialRelation.CONTAINS;  
                int numPoints = RandomNumbers.randomIntBetween(r, 3, 10);  
        }  
        }  
    }
            }
            nearPoint = xRandomPoint(r);
 * Modifications Copyright OpenSearch Contributors. See
    protected static final double xDIVISIBLE = 2;  
            double minY = nearP.getY();
            return ctx.makeRectangle(minX, maxX, minY, maxY);
                    // intent for ambiguous polygons. Therefore, an invalid oriented dateline crossing polygon could be built.
            return types[RandomNumbers.randomIntBetween(r, 0, types.length - 1)];
                minY -= latRange;
            case MULTILINESTRING:
     * @param st Create a random shape of the provided type  
    protected static GeometryCollectionBuilder createGeometryCollection(Random r, Point nearPoint, Rectangle bounds, int numGeometries)
        // requires an approach to avoid overlaps. This could be approached by creating polygons  
        short i = 0;  
    private static boolean rarely(Random r) {
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
    }  
        return createShape(r, nearPoint, null, st);  
        return createShapeNear(r, null, st);
                // if points are in a line the convex hull will be 2 points which will also lead to an invalid polygon  
            maxY = DistanceUtils.normLatDEG(maxY);
            // Not the most efficient but its the lesser of the evil alternatives
import org.junit.Assert;
 *
