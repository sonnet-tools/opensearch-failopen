        double windingSum = 0;
import java.util.List;
            lines.add(randomLine(hasAlt));
import java.util.Collections;
    }
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
    public static double randomAlt() {
    public static LinearRing linearRing(double[] lons, double[] lats, boolean generateAlts) {
import org.opensearch.geometry.Polygon;
    public static Point randomPoint(boolean hasAlt) {
        return new MultiPoint(points);
 */
        List<Line> lines = new ArrayList<>();
        if (lucenePolygon.numHoles() > 0) {
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < size; i++) {
            public MultiPoint visit(Rectangle rectangle) throws RuntimeException {
                for (int i = 0; i < line.length(); i++) {
            @Override
        double[] lons = new double[size];
        return OpenSearchTestCase.randomDouble();
    }
import org.opensearch.test.OpenSearchTestCase;
 * not use this file except in compliance with the License.
    public static MultiPoint randomMultiPoint(boolean hasAlt) {
            polygons.add(randomPolygon(hasAlt));
            }
        if (generateAlts) {
        return new Polygon(linearRing(lucenePolygon.getPolyLons(), lucenePolygon.getPolyLats(), hasAlt));
        return randomGeometry(0, hasAlt);
        if (hasAlts) {
import org.opensearch.geometry.GeometryVisitor;
            GeometryTestUtils::randomPoint,
            @Override
            public MultiPoint visit(MultiPoint multiPoint) throws RuntimeException {
            }
    }
            hasAlt ? GeometryTestUtils::randomPoint : (b) -> randomRectangle(),
                return visit((GeometryCollection<?>) multiPolygon);
        int size = OpenSearchTestCase.randomIntBetween(3, 10);
import java.util.Arrays;
import org.opensearch.geometry.GeometryCollection;
 * specific language governing permissions and limitations
            level < 3 ? (b) -> randomGeometryCollection(level + 1, b) : GeometryTestUtils::randomPoint // don't build too deep
import org.opensearch.geometry.Line;
/*
    public static GeometryCollection<Geometry> randomGeometryCollection(boolean hasAlt) {
            }
        } else {
    public static MultiPoint toMultiPoint(Geometry geometry) {
    public static double randomLon() {
                return multiPoint;
                throw new UnsupportedOperationException("not supporting circles yet");
            shapes.add(randomGeometry(level, hasAlt));
    }
            GeometryTestUtils::randomCircle,
            }
                collection.forEach(geometry -> toMultiPoint(geometry).forEach(points::add));
        for (int i = 0; i < size; i++) {
 * Licensed to Elasticsearch under one or more contributor
            }
            public MultiPoint visit(Line line) throws RuntimeException {
                    Arrays.asList(
                List<Geometry> multiPoints = new ArrayList<>();
    }
                }
import org.opensearch.geometry.Geometry;
 *
            @Override
        return randomPoint(OpenSearchTestCase.randomBoolean());
public class GeometryTestUtils {
    }
                List<Point> points = new ArrayList<>();
        );
            @Override
    public static MultiLine randomMultiLine(boolean hasAlt) {
    }
            @Override
                );
            GeometryTestUtils::randomMultiLine,
        return geometry.apply(hasAlt);
        final int numPts = lucenePolygon.numPoints() - 1;
            }
    }
    public static MultiPolygon randomMultiPolygon(boolean hasAlt) {
package org.opensearch.geo;
        }
     */
        return new MultiPolygon(polygons);
/*
        double[] lats = new double[size];
            return new Circle(randomLon(), randomLat(), OpenSearchTestCase.randomDoubleBetween(0, 100, false));
 *
            GeometryTestUtils::randomMultiPolygon,
            public MultiPoint visit(Circle circle) throws RuntimeException {
                    multiPoints.add(toMultiPoint(polygon.getHole(i)));
                randomLat(),
        }
            @Override
                return visit((Line) ring);
            // compute signed area
        org.apache.lucene.geo.Polygon lucenePolygon = GeoTestUtil.nextPolygon();
        }
            return new Point(randomLon(), randomLat());
        }
    /**
 * compatible open source license.
        Function<Boolean, Geometry> geometry = OpenSearchTestCase.randomFrom(
        return alts;
 *
 */
        for (int i = 0; i < size; i++) {
        List<Geometry> shapes = new ArrayList<>();
            for (int i = 0; i < lucenePolygon.numHoles(); i++) {
        org.apache.lucene.geo.Polygon lucenePolygon = randomValueOtherThanMany(p -> area(p) == 0, GeoTestUtil::nextPolygon);
import java.util.function.Function;
            return new Polygon(linearRing(lucenePolygon.getPolyLons(), lucenePolygon.getPolyLats(), hasAlt), holes);
 * The OpenSearch Contributors require contributions made to
 * ownership. Elasticsearch licenses this file to you under
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
    }
                .getPolyLon(i + 1);
    }
        return new Line(lons, lats);
}
        for (int i = 0; i < size; i++) {
                        new Point(rectangle.getMinX(), rectangle.getMinY(), rectangle.getMinZ()),
        }
            if (hasAlts) {
                OpenSearchTestCase.randomDouble(),
                OpenSearchTestCase.randomDoubleBetween(0, 100, false)
    }
        return geometry.visit(new GeometryVisitor<MultiPoint, RuntimeException>() {
                    )
                return new MultiPoint(points);
            List<LinearRing> holes = new ArrayList<>();
                org.apache.lucene.geo.Polygon poly = luceneHoles[i];
            }
            @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (int i = 0; i < size - 1; i++) {
            points.add(randomPoint(hasAlt));
    public static Point randomPoint() {
        } else {
import org.apache.lucene.tests.geo.GeoTestUtil;
        return GeoTestUtil.nextLongitude();
        }
            return new Line(lons, lats, alts);
            public MultiPoint visit(Point point) throws RuntimeException {
                holes.add(linearRing(poly.getPolyLons(), poly.getPolyLats(), hasAlt));
        return new MultiLine(lines);
                return toMultiPoint(new GeometryCollection<>(multiPoints));
    }
                return new MultiPoint(
            public MultiPoint visit(Polygon polygon) throws RuntimeException {
        int size = OpenSearchTestCase.randomIntBetween(1, 10);
        return new GeometryCollection<>(shapes);
            }
        });
    }
            lons[i] = lucenePolygon.getPolyLon(i);
                return visit((GeometryCollection<?>) multiLine);
            }
            lats[i] = lucenePolygon.getPolyLat(i);
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        double[] alts = new double[size];
import org.opensearch.geometry.MultiLine;
            public MultiPoint visit(GeometryCollection<?> collection) throws RuntimeException {
        List<Polygon> polygons = new ArrayList<>();
        }
        for (int i = 0; i < numPts; i++) {
                multiPoints.add(toMultiPoint(polygon.getPolygon()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import org.opensearch.geometry.Point;
import org.opensearch.geometry.Rectangle;
import java.util.ArrayList;
                }
        return Math.abs(windingSum / 2);
    }
    }
 * under the License.
 * KIND, either express or implied.  See the License for the
            public MultiPoint visit(LinearRing ring) throws RuntimeException {
        List<Point> points = new ArrayList<>();
            org.apache.lucene.geo.Polygon[] luceneHoles = lucenePolygon.getHoles();
        int size = OpenSearchTestCase.randomIntBetween(3, 10);
 * software distributed under the License is distributed on an
    protected static Geometry randomGeometry(int level, boolean hasAlt) {
            windingSum += lucenePolygon.getPolyLon(i) * lucenePolygon.getPolyLat(i + 1) - lucenePolygon.getPolyLat(i) * lucenePolygon
    }
            GeometryTestUtils::randomPolygon,
        return randomGeometryCollection(0, hasAlt);
            public MultiPoint visit(MultiPolygon multiPolygon) throws RuntimeException {
import org.opensearch.geometry.MultiPoint;
import org.opensearch.geometry.Circle;
/*
                List<Point> points = new ArrayList<>();
            }
            GeometryTestUtils::randomLine,
                randomLon(),
        }
import static org.opensearch.test.OpenSearchTestCase.randomValueOtherThanMany;
        }
            GeometryTestUtils::randomMultiPoint,
            return new Point(randomLon(), randomLat(), randomAlt());
    }
        double[] alts = hasAlts ? new double[size] : null;
 * You may obtain a copy of the License at
import org.opensearch.geometry.LinearRing;
 */
 * the Apache License, Version 2.0 (the "License"); you may
    }
                return new MultiPoint(points);
            public MultiPoint visit(MultiLine multiLine) throws RuntimeException {
        @SuppressWarnings("unchecked")
        }
        }
        return new Rectangle(rectangle.minLon, rectangle.maxLon, rectangle.maxLat, rectangle.minLat);
        return new LinearRing(lons, lats);
    public static Rectangle randomRectangle() {
            }
    public static Line randomLine(boolean hasAlts) {
        for (int i = 0; i < size; i++) {
     * Extracts all vertices of the supplied geometry
            @Override
    private static double area(org.apache.lucene.geo.Polygon lucenePolygon) {
    public static double randomLat() {
                    points.add(new Point(line.getX(i), line.getY(i), line.getZ(i)));
    public static Geometry randomGeometry(boolean hasAlt) {
            @Override
        int size = OpenSearchTestCase.randomIntBetween(3, 10);
            alts[i] = randomAlt();
 * Unless required by applicable law or agreed to in writing,
    private static GeometryCollection<Geometry> randomGeometryCollection(int level, boolean hasAlt) {
 * Modifications Copyright OpenSearch Contributors. See
    public static Polygon randomPolygon(boolean hasAlt) {
        return GeoTestUtil.nextLatitude();
        if (hasAlt) {
            return new Circle(
            );
    private static double[] randomAltRing(int size) {
        org.apache.lucene.geo.Rectangle rectangle = GeoTestUtil.nextBox();
        int size = lucenePolygon.numPoints() - 1;
        alts[size - 1] = alts[0];
        }
    }
            @Override
            }
    public static Circle randomCircle(boolean hasAlt) {
            return new LinearRing(lons, lats, randomAltRing(lats.length));
import org.opensearch.geometry.MultiPolygon;
                        new Point(rectangle.getMaxX(), rectangle.getMaxY(), rectangle.getMaxZ())
                return new MultiPoint(Collections.singletonList(point));
        // we use nextPolygon because it guarantees no duplicate points
                alts[i] = randomAlt();
        if (hasAlt) {
