import java.util.stream.Collectors;
        switch (randomShapeType) {
import org.junit.Assert;  
import java.util.Random;  
import org.opensearch.geometry.GeometryCollection;  
        int multiplePolygons = OpenSearchTestCase.randomIntBetween(1, MAX_MULTIPLE_GEOMETRIES);
     *
        final double centreY = centre[1];
     */
     */
     * @param r {@link Random}
     */  
    }
     * Generate a random point on the Earth Surface.
        .collect(Collectors.toList());
        final List<double[]> pointsList = PolygonGenerator.generatePolygon(xPool, yPool, r);
    private static final int MAX_VERTEXES = 10;
    }
     * @param r {@link Random}
        int multiplePoints = OpenSearchTestCase.randomIntBetween(1, MAX_MULTIPLE_GEOMETRIES);  
            default:  
        final List<Geometry> geometries = new ArrayList<>();
        geometries.addAll(randomMultiPoint(r).getAll());  
     */  
     * Returns a random Geometry. It makes sure that only that geometry is returned which is supported by OpenSearch
     * Generate a random line on the earth Surface.
        geometries.addAll(randomMultiLine(r).getAll());
        IntStream.range(0, multiplePoints).forEach(i -> pointsList.add(randomPoint(r)));
        return randomPolygonWithFixedVertexCount(r, vertexCount);
    }
import java.util.List;
     *  
                Assert.fail(String.format(Locale.ROOT, "Cannot create a geometry of type %s ", randomShapeType));
     * @return {@link MultiPoint}  
    /**  
     * @param r {@link Random}
        x[vertexCount] = x[0];
                return randomMultiLine(r);  
        );
import org.opensearch.geometry.Polygon;
     * @param r {@link Random}  
    }
        geometries.add(randomLine(r));
     * @return {@link MultiLine}
        final ShapeType randomShapeType = SUPPORTED_SHAPE_TYPES.get(
     */  
        final int vertexCount = OpenSearchTestCase.randomIntBetween(3, MAX_VERTEXES);  
     */
     * @param r {@link Random}  
        final double[] y = new double[vertexCount + 1];
        final double centreX = centre[0];
     *
    /**  
        });
        return new Polygon(linearRing);
        final List<Polygon> polygonList = new ArrayList<>();
     * @return {@link Line}
     *
     * Creating list of only supported geometries defined here: {@link GeoShapeIndexer#prepareForIndexing(Geometry)}  
import org.opensearch.geometry.Geometry;
            OpenSearchTestCase.randomIntBetween(0, SUPPORTED_SHAPE_TYPES.size() - 1)
import org.opensearch.geometry.Line;
 * The OpenSearch Contributors require contributions made to  
            case POLYGON:  
        final double[] pt2 = getLonAndLatitude(r);  
            case GEOMETRYCOLLECTION:  
/**
     * @param radius double
            double[] pt = getLonAndLatitude(r);  
        );  
     * @param r {@link Random}  
        final double[] centre = new double[2];
    /**
     * @param r {@link Random}
    private static final Predicate<ShapeType> NOT_SUPPORTED_SHAPES = shapeType -> shapeType != ShapeType.CIRCLE
    public static MultiLine randomMultiLine(Random r) {
        geometries.add(randomPoint(r));  
                return randomMultiPoint(r);
 * Random geo generation utilities for randomized geo_shape type testing.  
package org.opensearch.geo.tests.common;
    /**
        final List<Double> yPool = new ArrayList<>(vertexCount);
     * Returns a random {@link Rectangle} created on earth surface.  
        }
    private static Polygon randomPolygonWithFixedVertexCount(final Random r, final int vertexCount) {
        }
            RandomGeoGenerator.normalizeLongitude(centreX - radius),
        return new GeometryCollection<>(geometries);
    /**  
    public static Line randomLine(final Random r) {
        final double[] x = new double[vertexCount + 1];  
     * @param r {@link Random}
     * @return double[]  
import java.util.ArrayList;
        final List<Double> xPool = new ArrayList<>(vertexCount);  
                return randomRectangle(r);
        return new Point(pt[0], pt[1]);
     * @param r {@link Random}
     * Generate a random polygon on earth surface.  
        final double[] y = { pt1[1], pt2[1] };
    public static Rectangle randomRectangle(final Random r) {
    public static Rectangle randomRectangle(final Random r, double radius) {
     * @return {@link Geometry}
            case MULTIPOINT:
    public static MultiPolygon randomMultiPolygon(final Random r) {  
import org.opensearch.geometry.MultiLine;  
        geometries.addAll(randomMultiPolygon(r).getAll());
        return new MultiPolygon(polygonList);
            centreY + radius,  
            minY = Math.min(minY, y);
    private static final int MAX_MULTIPLE_GEOMETRIES = 10;  
        return new Line(x, y);  
    /**  
    /**
    public static Polygon randomPolygon(final Random r) {
     *
        double[] pt = new double[2];  
        IntStream.range(0, multiLines).forEach(i -> linesList.add(randomLine(r)));
        IntStream.range(0, vertexCount).forEach(iterator -> {
import org.opensearch.index.mapper.GeoShapeIndexer;
            case LINESTRING:
    }
            maxY = Math.max(maxY, y);
        RandomGeoGenerator.randomPointIn(r, -180, -(90 - radius), 180, 90 - radius, centre);  
        .filter(NOT_SUPPORTED_SHAPES)  
    public static GeometryCollection<?> randomGeometryCollection(final Random r) {
            case ENVELOPE:
    }  
     *  
            double x = polygon.getPolygon().getX()[i];
        IntStream.range(0, vertexCount).forEach(iterator -> {
        geometries.add(randomPolygon(r));
     */
            yPool.add(pt[1]);
    /**
     *
    /**  
        assert vertexCount == pointsList.get(1).length;
     * Returns an object of {@link GeometryCollection} having various shapes on earth surface.
        return null;  
    // Just picking a number 10 to be the max edges of a polygon. Don't want to make too large which can impact  
            case MULTILINESTRING:
        int multiLines = OpenSearchTestCase.randomIntBetween(1, MAX_MULTIPLE_GEOMETRIES);
    public static MultiPoint randomMultiPoint(final Random r) {
 * SPDX-License-Identifier: Apache-2.0
        final Polygon polygon = randomPolygonWithFixedVertexCount(r, 4);  
    }
     *
     * @return {@link Rectangle}  
import org.opensearch.test.OpenSearchTestCase;
        double minX = Double.POSITIVE_INFINITY, maxX = Double.NEGATIVE_INFINITY, maxY = Double.NEGATIVE_INFINITY, minY =
     * Returns an object of {@link MultiPolygon} denoting various polygons on earth surface.
 */
            case MULTIPOLYGON:
import java.util.stream.IntStream;  
                return randomPolygon(r);
    /**
        final double[] x = { pt1[0], pt2[0] };
        // Checking the list
     */
 * this file be licensed under the Apache-2.0 license or a
            Double.POSITIVE_INFINITY;
        // Create the linearRing, as we need to close the polygon hence increasing vertexes count by 1
        y[vertexCount] = y[0];
        return new MultiPoint(pointsList);  
                return randomGeometryCollection(r);
    public static Point randomPoint(final Random r) {  
     */
            case POINT:
            centreY - radius
        return new Rectangle(minX, maxX, maxY, minY);  
import org.opensearch.geometry.ShapeType;  
     * @return {@link GeometryCollection}
        for (int i = 0; i < polygon.getPolygon().length(); i++) {  
            double y = polygon.getPolygon().getY()[i];
        // making sure to close the polygon  
    }
            x[iterator] = pointsList.get(0)[iterator];  
import java.util.Locale;
import org.opensearch.geometry.LinearRing;
        });  
     * Returns a {@link MultiLine} object containing multiple lines on earth surface.
            xPool.add(pt[0]);
 * compatible open source license.
import java.util.function.Predicate;
        final LinearRing linearRing = new LinearRing(x, y);  
        assert vertexCount == pointsList.get(0).length;  
    }  
/*  
import org.opensearch.geometry.MultiPoint;
public class RandomGeoGeometryGenerator {
     * Returns an object of {@link MultiPoint} denoting a list of points on earth surface.
    public static Geometry randomGeometry(final Random r) {  
    }
    /**
            RandomGeoGenerator.normalizeLongitude(centreX + radius),
     * while indexing. Check {@link GeoShapeIndexer#prepareForIndexing(Geometry)}
}
        return pt;
import java.util.Arrays;  
     * @return {@link Point}
 */  
        final List<Line> linesList = new ArrayList<>();  
     */  
     * @return {@link MultiPolygon}
import org.opensearch.geometry.Rectangle;
     *  
        return new Rectangle(  
     * Generates a {@link Rectangle} of a specific radius. The generated rectangle can cross the international date line.
import org.opensearch.geometry.MultiPolygon;
        return new MultiLine(linesList);
import org.opensearch.geometry.Point;  
            maxX = Math.max(maxX, x);  
    }  
        final double[] pt1 = getLonAndLatitude(r);
        geometries.add(randomRectangle(r));  
    private static final List<ShapeType> SUPPORTED_SHAPE_TYPES = Arrays.stream(ShapeType.values())
    }  
        double[] pt = getLonAndLatitude(r);
     */
    /**
        && shapeType != ShapeType.LINEARRING;  
        final List<Point> pointsList = new ArrayList<>();
        IntStream.range(0, multiplePolygons).forEach(i -> polygonList.add(randomPolygon(r)));  
    private static double[] getLonAndLatitude(final Random r) {
 *
     * @return {@link Polygon}  
    // debugging.
                return randomPoint(r);  
            minX = Math.min(minX, x);
                return randomLine(r);  
     */
     * @param r {@link Random}
     *  
        RandomGeoGenerator.randomPoint(r, pt);
import org.opensearch.geo.algorithm.PolygonGenerator;
                return randomMultiPolygon(r);
     * @return {@link Rectangle}
     * Returns a double array where pt[0] : longitude and pt[1] : latitude  
            y[iterator] = pointsList.get(1)[iterator];
