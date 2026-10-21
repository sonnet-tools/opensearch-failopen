        return new Polygon(linearRing);
     *
     * @param r {@link Random}
     */
import org.opensearch.geometry.ShapeType;
        double[] pt = getLonAndLatitude(r);
    /**
     * @param r {@link Random}
            RandomGeoGenerator.normalizeLongitude(centreX + radius),
            case MULTILINESTRING:
    /**
 *
        geometries.addAll(randomMultiLine(r).getAll());
        );
     * Returns an object of {@link MultiPoint} denoting a list of points on earth surface.
    public static MultiPoint randomMultiPoint(final Random r) {
        int multiLines = OpenSearchTestCase.randomIntBetween(1, MAX_MULTIPLE_GEOMETRIES);
import java.util.Arrays;
     */
        final LinearRing linearRing = new LinearRing(x, y);
        geometries.add(randomPoint(r));
        final double centreY = centre[1];
     * Returns a random Geometry. It makes sure that only that geometry is returned which is supported by OpenSearch
            case MULTIPOINT:
        .filter(NOT_SUPPORTED_SHAPES)
     * @return {@link Rectangle}
                return randomMultiPolygon(r);
     *
        x[vertexCount] = x[0];
        final double[] pt2 = getLonAndLatitude(r);
        final double[] pt1 = getLonAndLatitude(r);
     * Returns an object of {@link GeometryCollection} having various shapes on earth surface.
            maxX = Math.max(maxX, x);
     *
import java.util.stream.Collectors;
    public static Point randomPoint(final Random r) {
import org.opensearch.geometry.Polygon;
     * @return {@link Rectangle}
            centreY + radius,
    /**
            double y = polygon.getPolygon().getY()[i];
    /**
        RandomGeoGenerator.randomPoint(r, pt);
        IntStream.range(0, multiplePoints).forEach(i -> pointsList.add(randomPoint(r)));
            x[iterator] = pointsList.get(0)[iterator];
import org.opensearch.geometry.MultiPoint;
     * @param r {@link Random}
            case LINESTRING:
     * Generate a random point on the Earth Surface.
/**
                return randomLine(r);
     */
        IntStream.range(0, multiplePolygons).forEach(i -> polygonList.add(randomPolygon(r)));
     */
     * @return {@link Point}
    }
    // debugging.
            OpenSearchTestCase.randomIntBetween(0, SUPPORTED_SHAPE_TYPES.size() - 1)
    public static Rectangle randomRectangle(final Random r) {
     * @return double[]
        });
            RandomGeoGenerator.normalizeLongitude(centreX - radius),
        final List<Line> linesList = new ArrayList<>();
     *
                return randomPolygon(r);
 */
import java.util.ArrayList;
        y[vertexCount] = y[0];
    /**
import org.opensearch.geo.algorithm.PolygonGenerator;
 * compatible open source license.
     *
            case MULTIPOLYGON:
    public static MultiLine randomMultiLine(Random r) {
 * SPDX-License-Identifier: Apache-2.0
import java.util.Random;
    // Just picking a number 10 to be the max edges of a polygon. Don't want to make too large which can impact
        // Checking the list
        return new GeometryCollection<>(geometries);
        final double[] y = new double[vertexCount + 1];
    }
import java.util.stream.IntStream;
        return pt;
    private static final int MAX_MULTIPLE_GEOMETRIES = 10;
        return new MultiLine(linesList);
        }
import org.opensearch.geometry.Geometry;
        final double centreX = centre[0];
            case POLYGON:
    /**
import org.opensearch.geometry.Point;
import java.util.List;
        IntStream.range(0, vertexCount).forEach(iterator -> {
        for (int i = 0; i < polygon.getPolygon().length(); i++) {
    }
            minX = Math.min(minX, x);
     */
                return randomGeometryCollection(r);
        final int vertexCount = OpenSearchTestCase.randomIntBetween(3, MAX_VERTEXES);
    /**
            case ENVELOPE:
    private static final int MAX_VERTEXES = 10;
     */
    }
                Assert.fail(String.format(Locale.ROOT, "Cannot create a geometry of type %s ", randomShapeType));
 * this file be licensed under the Apache-2.0 license or a
                return randomMultiLine(r);
 */
        final List<Polygon> polygonList = new ArrayList<>();
        assert vertexCount == pointsList.get(1).length;
     * @return {@link MultiLine}
            case GEOMETRYCOLLECTION:
        return new MultiPolygon(polygonList);
            case POINT:
        final double[] centre = new double[2];
     *
    }
import org.opensearch.geometry.LinearRing;
     * @param r {@link Random}
     * Generate a random polygon on earth surface.
     */
    private static Polygon randomPolygonWithFixedVertexCount(final Random r, final int vertexCount) {
        final double[] x = { pt1[0], pt2[0] };
    public static Rectangle randomRectangle(final Random r, double radius) {
            maxY = Math.max(maxY, y);
import org.junit.Assert;
            minY = Math.min(minY, y);
        return new Rectangle(minX, maxX, maxY, minY);
     * @param r {@link Random}
        double minX = Double.POSITIVE_INFINITY, maxX = Double.NEGATIVE_INFINITY, maxY = Double.NEGATIVE_INFINITY, minY =
import java.util.Locale;
     * Returns a {@link MultiLine} object containing multiple lines on earth surface.
            default:
     *
    public static Line randomLine(final Random r) {
    }
    public static GeometryCollection<?> randomGeometryCollection(final Random r) {
        // making sure to close the polygon
     * @param r {@link Random}
     *
     * @param r {@link Random}
        // Create the linearRing, as we need to close the polygon hence increasing vertexes count by 1
 * Random geo generation utilities for randomized geo_shape type testing.
        return randomPolygonWithFixedVertexCount(r, vertexCount);
     * @param r {@link Random}
    /**
        assert vertexCount == pointsList.get(0).length;
        final List<Point> pointsList = new ArrayList<>();
            xPool.add(pt[0]);
     *
    public static MultiPolygon randomMultiPolygon(final Random r) {
     */
     * Generates a {@link Rectangle} of a specific radius. The generated rectangle can cross the international date line.
        final List<Double> yPool = new ArrayList<>(vertexCount);
        return new Rectangle(
        final List<Double> xPool = new ArrayList<>(vertexCount);
    private static final List<ShapeType> SUPPORTED_SHAPE_TYPES = Arrays.stream(ShapeType.values())
import org.opensearch.geometry.Rectangle;
        final ShapeType randomShapeType = SUPPORTED_SHAPE_TYPES.get(
        .collect(Collectors.toList());
            double[] pt = getLonAndLatitude(r);
import org.opensearch.geometry.MultiPolygon;
        final Polygon polygon = randomPolygonWithFixedVertexCount(r, 4);
                return randomMultiPoint(r);
    /**
     * Returns a random {@link Rectangle} created on earth surface.
    }
        && shapeType != ShapeType.LINEARRING;
            double x = polygon.getPolygon().getX()[i];
import java.util.function.Predicate;
    private static final Predicate<ShapeType> NOT_SUPPORTED_SHAPES = shapeType -> shapeType != ShapeType.CIRCLE
     * @return {@link MultiPolygon}
        switch (randomShapeType) {
        );
        int multiplePoints = OpenSearchTestCase.randomIntBetween(1, MAX_MULTIPLE_GEOMETRIES);
import org.opensearch.index.mapper.GeoShapeIndexer;
     * @return {@link GeometryCollection}
 * The OpenSearch Contributors require contributions made to
        });
        IntStream.range(0, vertexCount).forEach(iterator -> {
        return new MultiPoint(pointsList);
                return randomPoint(r);
     *
package org.opensearch.geo.tests.common;
    /**
        geometries.add(randomLine(r));
        return null;
            Double.POSITIVE_INFINITY;
        IntStream.range(0, multiLines).forEach(i -> linesList.add(randomLine(r)));
    }
     */
        final double[] x = new double[vertexCount + 1];
    /**
     * @return {@link Polygon}
        geometries.addAll(randomMultiPolygon(r).getAll());
     */
            centreY - radius
                return randomRectangle(r);
    private static double[] getLonAndLatitude(final Random r) {
    }
        }
        double[] pt = new double[2];
        final List<Geometry> geometries = new ArrayList<>();
        return new Point(pt[0], pt[1]);
import org.opensearch.geometry.MultiLine;
     * Creating list of only supported geometries defined here: {@link GeoShapeIndexer#prepareForIndexing(Geometry)}
        geometries.add(randomPolygon(r));
     * Returns an object of {@link MultiPolygon} denoting various polygons on earth surface.
     */
        geometries.addAll(randomMultiPoint(r).getAll());
     * @return {@link Geometry}
     * @param radius double
     * @param r {@link Random}
import org.opensearch.geometry.Line;
public class RandomGeoGeometryGenerator {
        final List<double[]> pointsList = PolygonGenerator.generatePolygon(xPool, yPool, r);
     * while indexing. Check {@link GeoShapeIndexer#prepareForIndexing(Geometry)}
        RandomGeoGenerator.randomPointIn(r, -180, -(90 - radius), 180, 90 - radius, centre);
     * Returns a double array where pt[0] : longitude and pt[1] : latitude
     * @return {@link Line}
    public static Geometry randomGeometry(final Random r) {
}
import org.opensearch.test.OpenSearchTestCase;
    }
            yPool.add(pt[1]);
    public static Polygon randomPolygon(final Random r) {
    }
import org.opensearch.geometry.GeometryCollection;
        return new Line(x, y);
            y[iterator] = pointsList.get(1)[iterator];
     * @param r {@link Random}
    /**
     * @return {@link MultiPoint}
        int multiplePolygons = OpenSearchTestCase.randomIntBetween(1, MAX_MULTIPLE_GEOMETRIES);
        geometries.add(randomRectangle(r));
     */
     * Generate a random line on the earth Surface.
        final double[] y = { pt1[1], pt2[1] };
    }
/*
