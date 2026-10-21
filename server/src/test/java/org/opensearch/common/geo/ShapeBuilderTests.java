                .coordinate(-85.0004984, 37.1310658)
    }
            + "    [\n"
            );
        // https://gist.github.com/anonymous/7f1bb6d7e9cd72f5977c crosses the dateline
        builder.hole(
import static org.opensearch.test.hamcrest.OpenSearchGeoAssertions.assertMultiLineString;
                    .coordinate(-180, 5)
        assertEquals(exterior.getCoordinateN(3), new Coordinate(-45, -30));
import org.opensearch.test.OpenSearchTestCase;
                .coordinate(-177, 10)
            + "      ],\n"
        LineString exterior = poly.getExteriorRing();
        );
        builder.hole(
                    .coordinate(172, 0)
        );
                .coordinate(6, 0)
 */
import org.opensearch.common.geo.builders.PointBuilder;
                .coordinate(new Coordinate(-45, -30, 101))
        Exception e = expectThrows(InvalidShapeException.class, () -> builder.close().buildS4J());
        assertPolygon(builder.close().buildS4J(), true);
        );
        lsb.buildS4J();
                .coordinate(-176, 3)
            )
import org.locationtech.spatial4j.shape.Point;
        PolygonBuilder newPolygon = new PolygonBuilder(
        // LineString that needs to be wrapped
            .linestring(
            + "        -45.0,\n"
                .coordinate(new Coordinate(45, 30))
        // test a shape with one invalid tangential (shared) vertex (should throw exception)
 * specific language governing permissions and limitations
        assertMultiPolygon(builder.close().buildS4J(), true);
                .coordinate(-150.0, -65.0)
                    .coordinate(-85.0010057, 37.1315102)
                .coordinate(-176, 0)
 * not use this file except in compliance with the License.
            new CoordinatesBuilder().coordinate(new Coordinate(-45, 30, 100))
                    .coordinate(-85.0008048, 37.1319439)
        LineString exterior = poly.getExteriorRing();
        assertThat(e.getMessage(), not(containsString("NaN")));
        Polygon poly = pb.toPolygonS4J();
        assertMultiPolygon(buildGeometry(builder.close()), false);
            new CoordinatesBuilder().coordinate(180, 0).coordinate(176, 4).coordinate(-176, 4).coordinate(180, 0)
    }
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
    }
                .coordinate(172, 0)
    public Object buildGeometry(ShapeBuilder<?, ?, ?> builder) {
                .coordinate(-85.001834, 37.1325497)
        // test a shape with one tangential (shared) vertex for each hole (should pass)
            new LineStringBuilder(
                .coordinate(-250.0, 65.0)
                new CoordinatesBuilder().coordinate(-185, 1)
        assertEquals(polygon.getY(2), -30, 0d);
                .coordinate(-85.000955, 37.1322802)
                .coordinate(200.0, 60.0)
/**
                .coordinate(176, 15)
        );
        );
                new CoordinatesBuilder().coordinate(-177, 10)
        assertMultiPolygon(builder.close().buildS4J(), true);
        );
        e = expectThrows(InvalidShapeException.class, () -> builder.close().buildS4J());
        // 3/4 of an embedded 'c', crossing dateline once
                .coordinate(176, -15)
        // tests that the following shape (defined in counterclockwise OGC order)
                .coordinate(-177, -10)
        assertEquals(new PointImpl(0, 90, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());
        assertPolygon(buildGeometry(builder.close()), false);
                    .coordinate(-177, 10)
            new CoordinatesBuilder().coordinate(-150.0, 65.0)
                .coordinate(172, 0)
        assertThat(e.getMessage(), not(containsString("NaN")));
                    .coordinate(-84.9996815, 37.1317979)
                    .coordinate(-181, 2)
        buildGeometry(lsb);
                    .coordinate(-177, 10)
        assertEquals(-100D, point.getX(), 0.0d);
                new CoordinatesBuilder().coordinate(176, 10).coordinate(180, 5).coordinate(180, -5).coordinate(176, -10).coordinate(176, 10)
                .coordinate(-172, 0)
import static org.hamcrest.Matchers.not;
                    .coordinate(-85.000087, 37.1311356)
        );
        // https://gist.github.com/anonymous/7f1bb6d7e9cd72f5977c crosses the dateline
        LineStringBuilder lsb = new LineStringBuilder(
 *
            + "        45.0,\n"
        assertEquals(-30D, rectangle.getMinY(), 0.0d);
                    .coordinate(-85.0009182, 37.1313793)
        assertMultiPolygon(buildGeometry(builder.close()), false);
        buildGeometry(lsb);
                new CoordinatesBuilder().coordinate(150.0, 60.0).coordinate(200.0, 60.0).coordinate(200.0, 40.0).coordinate(150.0, 40.0)
        builder.hole(
                    .coordinate(179, 1)
                .coordinate(-250.0, -65.0)
        lsb.buildS4J();
        e = expectThrows(InvalidShapeException.class, () -> builder.close().buildS4J());
        );
    }
        // embedded hole right of the dateline
        );
                    .coordinate(180, -5)
        assertPolygon(builder.close().buildS4J(), true);
            new CoordinatesBuilder().coordinate(-176, 4).coordinate(-180, 0).coordinate(-180, -4).coordinate(-176, 4)
        assertEquals(45D, luceneRectangle.getMaxX(), 0.0d);
        assertThat(e.getMessage(), containsString("Self-intersection at or near point ["));
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                .coordinate(179, -10)
                .coordinate(-85.0019543, 37.1324336)
            + "        -45.0,\n"
                .coordinate(179, -10)
        // cw: geo core will convert to ccw across the dateline
            + "      ],\n"
        );
            new LineStringBuilder(
        assertPolygon(builder.close().buildS4J(), true);
            )
        circle = new CircleBuilder().center(-180, 0).radius("100m").buildS4J();
    }
        org.opensearch.geometry.Point geoPoint = pb.buildGeometry();
            new LineStringBuilder(
        );
        // Building a lineString on the dateline
        PolygonBuilder builder = new PolygonBuilder(
    public void testDatelineOGC() {
                .coordinate(164, 0)
                .close()
/*
        builder.hole(
                    .coordinate(-181, 1)
                    .coordinate(176, 2)
                    .coordinate(-84.9992567, 37.1313252)
        Rectangle rectangle = eb.buildS4J();
                .coordinate(-177, 10)
        builder.hole(
                    .coordinate(-85.0005366, 37.1312209)
        Exception e;
            new CoordinatesBuilder().coordinates(
        assertEquals(expected, pb.toString());
            new CoordinatesBuilder().coordinate(-177, 10)
                    .coordinate(-84.9993527, 37.1317788)
        );
        assertEquals(polygon.getY(3), -30, 0d);
        builder = new PolygonBuilder(
 * Unless required by applicable law or agreed to in writing,
                new CoordinatesBuilder().coordinate(-179, 1).coordinate(-179, 2).coordinate(-177, 2).coordinate(-177, 1).coordinate(-179, 1)
            new CoordinatesBuilder().coordinate(new Coordinate(-45, 30))
        )
                .coordinate(-85.0019371, 37.1321182)
        assertEquals(exterior.getCoordinateN(2), new Coordinate(45, -30));
        assertPolygon(buildGeometry(builder.close()), false);
        PolygonBuilder builder = new PolygonBuilder(
        );
        assertEquals(exterior.getCoordinateN(3), new Coordinate(-45, -30));
        circle = new CircleBuilder().center(0, -90).radius("100m").buildS4J();
import org.locationtech.jts.geom.Coordinate;
        );
                .coordinate(-20.0, 50.0)
                .coordinate(-110.0, -15.0)
        assertPolygon(builder.close().buildS4J(), true);
            + "      [\n"
    /**
                .coordinate(-250.0, -65.0)
                    .close()
                .coordinate(-85.0017119, 37.1319196)
            new CoordinatesBuilder().coordinate(-40.0, 50.0).coordinate(40.0, 50.0).coordinate(-40.0, -50.0).coordinate(40.0, -50.0).close()
                .coordinate(-176, 5)
        );
                    .coordinate(-180, -5)
        assertPolygon(buildGeometry(builder.close()), false);
        assertMultiPolygon(builder.close().buildS4J(), true);
    }
                    new CoordinatesBuilder().coordinate(-100.0, 20.0).coordinate(50.0, 20.0).coordinate(50.0, 0.0).coordinate(-100.0, 0.0)
        assertEquals(new PointImpl(-180, 0, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());
 * The OpenSearch Contributors require contributions made to
            + "}";
            new CoordinatesBuilder().coordinate(-186, 0)
        PolygonBuilder builder = new PolygonBuilder(
            .linestring(
        assertThat(e.getMessage(), containsString("Self-intersection at or near point ["));
    }
import org.locationtech.jts.geom.Polygon;
 * this work for additional information regarding copyright
                .coordinate(-85.0016645, 37.1315293)
            )
                .coordinate(-84.9993573, 37.1308459)
                .coordinate(-84.9989283, 37.1311337)
            + "  ]\n"
        );
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
            )
                .coordinate(-85.0000002, 37.1322307)
        builder.hole(
                .coordinate(1, 1.9)
        assertEquals(new PointImpl(0, -90, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());
import org.opensearch.index.mapper.GeoShapeIndexer;
        assertEquals(exterior.getCoordinateN(3), new Coordinate(-45, -30));
    public void testShapeWithHoleAtEdgeEndPoints() {
            new CoordinatesBuilder().coordinate(-130.0, 55.0)
    }
            new CoordinatesBuilder().coordinate(-177, 10)
                    .coordinate(-180, -5)
        assertEquals(polygon.getX(0), -45, 0d);
                new CoordinatesBuilder().coordinate(-177, 10)
            + "      ],\n"
        );
                    .coordinate(-178, 6)
        double randomLat = (randomDouble() * 180) - 90;
                .coordinate(168, 15)
                    .coordinate(-178, -10)
        assertMultiPolygon(buildGeometry(builder.close()), false);
                .coordinate(1.5, 1.8)
    }
        assertMultiPolygon(buildGeometry(builder.close()), false);
            new CoordinatesBuilder().coordinate(-150.0, 65.0)
        builder.hole(
 * Tests for {@link ShapeBuilder}
     * Test an enveloping polygon around the max mercator bounds
                    .coordinate(175, 1)
            new CoordinatesBuilder().coordinate(-4, 2)
        assertMultiPolygon(builder.close().buildS4J(), true);
        assertEquals(polygon.getY(0), 30, 0d);
            new CoordinatesBuilder().coordinate(179, 10)
        assertMultiPolygon(buildGeometry(builder.close()), false);
            new LineStringBuilder(new CoordinatesBuilder().coordinate(172, 0).coordinate(176, 10).coordinate(176, -5).coordinate(172, 0))
    public void testNewRectangle() {
                .coordinate(-176, 5)
                new Coordinate(-45, -30),
        );
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
                .coordinate(130.0, 60.0)
                    .coordinate(-185, 1)
        );
                .close()
            new CoordinatesBuilder().coordinate(-176, 15)
                .coordinate(168, 15)
    }
        // Building a linestring that needs to be wrapped
                .coordinate(-186, 0)
 * KIND, either express or implied.  See the License for the
                .coordinate(-85.0019972, 37.1322115)
        // embedded hole right of the dateline
                new CoordinatesBuilder().coordinate(-100.0, 50.0).coordinate(50.0, 50.0).coordinate(50.0, 20.0).coordinate(-100.0, 20.0)
    public void testShapeWithBoundaryHoles() {
}
        PolygonBuilder builder = new PolygonBuilder(
            + "        100.0\n"
    }
        builder.hole(
        Polygon poly = pb.toPolygonS4J();
            )
        PolygonBuilder pb = new PolygonBuilder(
                new CoordinatesBuilder().coordinate(-85.0000002, 37.1317672)
    public void testPolygon3D() {
        Point point = pb.buildS4J();
 * SPDX-License-Identifier: Apache-2.0
                .coordinate(-45.0, -15.0)
        assertEquals(exterior.getCoordinateN(0), new Coordinate(-45, 30));
                .coordinate(-84.998934, 37.1322415)
        LinearRing polygon = pb.toPolygonGeometry().getPolygon();
                    .coordinate(-176, 10)
        PolygonBuilder pb = new PolygonBuilder(
        assertEquals(polygon.getX(3), -45, 0d);
        assertPolygon(buildGeometry(builder.close()), false);
        // test case 2: test the negative side of the dateline
                .coordinate(4, -2)
        assertEquals(polygon.getY(2), -30, 0d);
                    .coordinate(-85.000977, 37.1314403)
            + "        -30.0,\n"
                    .coordinate(-84.9991841, 37.1316527)
                    .coordinate(-184, 6)
            new CoordinatesBuilder().coordinate(-180.0, 80.0).coordinate(-180.0, 40.0).coordinate(-180.0, -40.0).coordinate(-180.0, -80.0)
                    .coordinate(-177, 10)
                .coordinate(-250.0, 65.0)
                .coordinate(-85.0011755, 37.1323509)
        // 3/4 of an embedded 'c', crossing dateline once
        assertPolygon(builder.close().buildS4J(), true);
                )
        Exception e = expectThrows(InvalidShapeException.class, () -> builder.close().buildS4J());
                .coordinate(new Coordinate(-45, 30))
        );
        );
        assertEquals(polygon.getX(1), 45, 0d);
        // Building a lineString on the dateline
            )
        // expected results: 3 polygons, 1 with a hole
                .coordinate(-85.001906, 37.1324985)
                    .coordinate(-185, 7)
        assertEquals(polygon.getX(1), 45, 0d);
                .coordinate(176, -15)
                .coordinate(-85.0016455, 37.1310491)
            + "        75.0\n"
                .coordinate(-183, 3)
        // test case 1: test the positive side of the dateline
        PolygonBuilder builder = new PolygonBuilder(
                    .coordinate(-184, 2)
    }
    }
        );
                .coordinate(0, 0)
                .coordinate(240.0, -40.0)
 * under the License.
    }
                    .coordinate(-85.0010184, 37.1319463)
            + "        -45.0,\n"
        );
        assertEquals(new PointImpl(randomLon, randomLat, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());
    public void testGeoCircle() {
            )
    public void testComplexShapeWithHole() {
        PolygonBuilder builder = new PolygonBuilder(
    public void testBoundaryShape() {
 * You may obtain a copy of the License at
                    .coordinate(-85.0009342, 37.1319838)
                .coordinate(200.0, -30.0)
                .coordinate(new Coordinate(45, -30, 77))
            + "      [\n"
        // a giant c shape
    public void testNewPolygon() {
            new LineStringBuilder(
        )
                .coordinate(-130.0, -40.0)
                new Coordinate(-45, 30)
    }
    public void testNewPolygon_coordinates() {
                .coordinate(-45.0, 50.0)
        lsb = new LineStringBuilder(
    public void testShapeWithInvalidTangentialHole() {
                .coordinate(-177, 10)
        e = expectThrows(InvalidShapeException.class, () -> buildGeometry(builder.close()));
            new LineStringBuilder(
        buildGeometry(lsb);
        new MultiLineStringBuilder().linestring(
                    .coordinate(-84.9993308, 37.1312859)
                .close()
        LineStringBuilder lsb = new LineStringBuilder(
        circle = new CircleBuilder().center(0, 90).radius("100m").buildS4J();
            + "        101.0\n"
        assertEquals(exterior.getCoordinateN(2), new Coordinate(45, -30));
                .coordinate(-84.9995888, 37.1307924)
            + "        30.0,\n"
import org.locationtech.spatial4j.shape.Rectangle;
        assertThat(e.getMessage(), containsString("interior cannot share more than one point with the exterior"));
            new CoordinatesBuilder().coordinate(180, 0).coordinate(176, 4).coordinate(176, -4).coordinate(180, 0)
        );
import org.opensearch.common.geo.builders.ShapeBuilder;
            + "        45.0,\n"
            + "  \"type\" : \"polygon\",\n"
                .coordinate(-110.0, 55.0)
        );
                .coordinate(-84.9994, 37.1323001)
            + "      ],\n"
            new CoordinatesBuilder().coordinate(180.0, 80.0).coordinate(180.0, 40.0).coordinate(180.0, -40.0).coordinate(180.0, -80.0)
            new LineStringBuilder(
            + "  \"orientation\" : \"right\",\n"
                .coordinate(-85.0016965, 37.1325907)
            )
        assertEquals(polygon.getX(0), -45, 0d);
                .coordinate(2, 2)
        builder = new PolygonBuilder(
                .coordinate(166, -15)
    public void testInvalidSelfCrossingPolygon() {
        assertEquals(polygon.getX(2), 45, 0d);
        );
                    .coordinate(-84.9991868, 37.1314277)
    public void testShapeWithAlternateOrientation() {
        assertEquals(polygon.getY(0), 30, 0d);
 * license agreements. See the NOTICE file distributed with
                    .coordinate(-178, -10)
        PolygonBuilder builder = new PolygonBuilder(
 * Licensed to Elasticsearch under one or more contributor
        assertPolygon(builder.close().buildS4J(), true);
                    .coordinate(176, 6)
            + "      [\n"
        assertEquals(polygon.getX(1), 45, 0d);
    public void testLineStringWrapping() {
            );
        PolygonBuilder builder = new PolygonBuilder(
            + "        110.0\n"
                .coordinate(-85.0009461, 37.1311684)
                .coordinate(-186, 8)
        assertEquals(polygon.getY(3), -30, 0d);
        assertThat(e.getMessage(), containsString("duplicate consecutive coordinates at: ("));
                .coordinate(-85.0016246, 37.1317069)
    }
        Circle circle = new CircleBuilder().center(0, 0).radius("100m").buildS4J();
        // tests that the following shape (defined in clockwise non-OGC order)
    public void testShapeWithEdgeAlongDateline() {
                new CoordinatesBuilder().coordinate(-176, 10)
import org.locationtech.jts.geom.LineString;
        org.opensearch.geometry.Rectangle luceneRectangle = eb.buildGeometry();
                new LineStringBuilder(
                new Coordinate(45, 30),
        assertEquals(exterior.getCoordinateN(1), new Coordinate(45, 30));
                    .coordinate(-85.0000002, 37.1311433)
                    .coordinate(-84.9995021, 37.1312336)
/*
/*
        assertEquals(polygon.getX(2), 45, 0d);
    }
                .coordinate(-150.0, -65.0)
        assertEquals(45D, rectangle.getMaxX(), 0.0d);
        // a giant c shape
            new CoordinatesBuilder().coordinate(100.0, 50.0)
            )
            )
        assertMultiPolygon(builder.close().buildS4J(), true);
            new CoordinatesBuilder().coordinate(174, 0)
 * ownership. Elasticsearch licenses this file to you under
        );
        assertEquals(-45D, rectangle.getMinX(), 0.0d);
        assertEquals(30D, luceneRectangle.getMaxY(), 0.0d);
import org.opensearch.common.geo.builders.CircleBuilder;
                .coordinate(new Coordinate(45, -30))
        assertMultiPolygon(builder.close().buildS4J(), true);
            + "        30.0,\n"
    }
        );
        mlsb.buildS4J();
            new LineStringBuilder(
                .coordinate(176, 15)
        assertEquals(exterior.getCoordinateN(0), new Coordinate(-45, 30));
        assertMultiPolygon(builder.close().buildS4J(), true);
    public void testPolygonWrapping() {
                .coordinate(230.0, 60.0)
        assertEquals(-30D, luceneRectangle.getMinY(), 0.0d);
import org.locationtech.spatial4j.shape.impl.PointImpl;
    }
    }
                .coordinate(110.0, -40.0)
        PolygonBuilder pb = new PolygonBuilder(
        assertThat(e.getMessage(), containsString("interior cannot share more than one point with the exterior"));
                .coordinate(176, -15)
                .coordinate(179, 10)
                .coordinate(-85.0014816, 37.1325353)
        assertEquals(polygon.getY(3), -30, 0d);
        // test shape with two tangential (shared) vertices (should throw exception)
                new CoordinatesBuilder().coordinate(-177, 10)
            + "        30.0,\n"
        PolygonBuilder builder = new PolygonBuilder(
        assertEquals(polygon.getX(2), 45, 0d);
                .coordinate(177, 5)
            new CoordinatesBuilder().coordinate(179, 10)
                    .coordinate(-180, 5)
        PolygonBuilder builder = new PolygonBuilder(
 */
        builder.hole(
        );
        assertMultiPolygon(buildGeometry(builder.close()), false);
        assertEquals(polygon.getX(3), -45, 0d);
        String expected = "{\n"
        // Building a simple LineString
    }
                new Coordinate(45, -30),
                .coordinate(-84.9988639, 37.1321888)
        assertEquals(45D, geoPoint.getY(), 0.0d);
            new CoordinatesBuilder().coordinate(180, 0).coordinate(176, 4).coordinate(176, 4).coordinate(-176, 4).coordinate(180, 0)
        // test case 1: test the positive side of the dateline
            new LineStringBuilder(
                .coordinate(-6, 0)
 * Modifications Copyright OpenSearch Contributors. See
        // cw: should produce a multi polygon spanning hemispheres
                new CoordinatesBuilder().coordinate(175, 1)
                    .coordinate(179, 2)
        assertEquals(polygon.getX(0), -45, 0d);
        builder = new PolygonBuilder(new CoordinatesBuilder().coordinate(180, 0).coordinate(-176, 4).coordinate(176, 4).coordinate(180, 0));
            new CoordinatesBuilder().coordinate(-177, 10)
                .coordinate(2, 0)
        circle = new CircleBuilder().center(randomLon, randomLat).radius(randomRadius + "m").buildS4J();
                .coordinate(-84.999109, 37.1322864)
        assertMultiPolygon(buildGeometry(pb), false);
        double randomRadius = randomIntBetween(1, (int) earthCircumference / 4);
        PolygonBuilder builder = new PolygonBuilder(
        );
        Exception e;
                .coordinate(-84.9998746, 37.130806)
 *
import static org.opensearch.test.hamcrest.OpenSearchGeoAssertions.assertMultiPolygon;
                .coordinate(-176, 8)
            new CoordinatesBuilder().coordinate(180, 0).coordinate(176, 4).coordinate(180, -4).coordinate(180, 0)
        e = expectThrows(InvalidShapeException.class, () -> buildGeometry(builder.close()));
        assertMultiPolygon(buildGeometry(builder.close()), false);
                .coordinate(-85.0008008, 37.1311625)
    public void testBoundaryShapeWithTangentialHole() {
        assertEquals(polygon.getY(1), 30, 0d);
                .coordinate(4, 2)
            new LineStringBuilder(
                    .coordinate(-178, 6)
        PointBuilder pb = new PointBuilder().coordinate(-100, 45);
                .coordinate(1, 1.9)
                    .coordinate(-85.0004697, 37.131792)
public class ShapeBuilderTests extends OpenSearchTestCase {
        assertEquals(new PointImpl(0, 0, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());
import org.opensearch.common.geo.builders.EnvelopeBuilder;
                new Coordinate(-45, 30),
                .coordinate(-176, 0)
        builder.hole(
                .coordinate(-85.0000002, 37.1308358)
        assertEquals(exterior.getCoordinateN(2), new Coordinate(45, -30));
 * compatible open source license.
    }
        LinearRing polygon = pb.toPolygonGeometry().getPolygon();
                .coordinate(176, 15)
            + "        77.0\n"
    public void testShapeWithTangentialHole() {
                    .coordinate(-180, -5)
        assertThat(e.getMessage(), containsString("duplicate consecutive coordinates at: ("));
        assertEquals(new PointImpl(180, 0, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());
                .coordinate(-4, -2)
        // expected results: 3 polygons, 1 with a hole
        builder.hole(
                    .coordinate(-178, 7)
 * this file be licensed under the Apache-2.0 license or a
        assertPolygon(builder.close().buildS4J(), true);
        lsb = new LineStringBuilder(
        );
                .coordinate(174, 0)
        PolygonBuilder builder = new PolygonBuilder(
        assertEquals(exterior.getCoordinateN(0), new Coordinate(-45, 30));
        double earthCircumference = 40075016.69;
        assertEquals(-45D, luceneRectangle.getMinX(), 0.0d);
                    .coordinate(-84.9992329, 37.1317117)
                .coordinate(-84.9988091, 37.131334)
                .coordinate(-176, -15)
        PolygonBuilder pb = new PolygonBuilder(
                    .coordinate(-84.9991593, 37.1315381)
                    .coordinate(-178, 7)
        );
    }
                .coordinate(-84.9991943, 37.1309198)
        PolygonBuilder builder = new PolygonBuilder(
                .coordinate(-15.0, -40.0)
    }
                new CoordinatesBuilder().coordinate(-179, 1).coordinate(-177, 1).coordinate(-177, 2).coordinate(-179, 2).coordinate(-179, 1)
                new CoordinatesBuilder().coordinate(164, 0).coordinate(175, 10).coordinate(175, 5).coordinate(179, -10).coordinate(164, 0)
                .coordinate(179, -10)
            )
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
 *
                    .coordinate(176, -10)
    public void testLineStringBuilder() {
    public void testNewPoint() {
            new CoordinatesBuilder().coordinate(-45, 30).coordinate(45, 30).coordinate(45, -30).coordinate(-45, -30).coordinate(-45, 30)
import static org.opensearch.test.hamcrest.OpenSearchGeoAssertions.assertPolygon;
            new LineStringBuilder(
                .coordinate(-84.9987841, 37.1320944)
    }
            + "      [\n"
        );
        assertEquals(polygon.getY(0), 30, 0d);
import org.opensearch.common.geo.builders.MultiLineStringBuilder;
                )
    public void testPolygonSelfIntersection() {
        builder.hole(
        );
            new CoordinatesBuilder().coordinate(0, 0)
        assertThat(e.getMessage(), containsString("interior cannot share more than one point with the exterior"));
        return new GeoShapeIndexer(true, "name").prepareForIndexing(builder.buildGeometry());
        );
        assertPolygon(buildGeometry(builder.close()), false);
                    new CoordinatesBuilder().coordinate(150.0, 20.0).coordinate(200.0, 20.0).coordinate(200.0, 0.0).coordinate(150.0, 0.0)
        );
                    .coordinate(-85.000224, 37.1311466)
                .coordinate(174, 8)
        LineString exterior = poly.getExteriorRing();
                .coordinate(179, 10)
        assertPolygon(buildGeometry(builder.close()), false);
                    .coordinate(-85.0001983, 37.1317538)
                .coordinate(-176, 8)
        );
    public void testBoundaryShapeWithInvalidTangentialHole() {
 */
 * the Apache License, Version 2.0 (the "License"); you may
        double randomLon = (randomDouble() * 360) - 180;
                .coordinate(-85.0016011, 37.1325873)
                .coordinate(0, 2)
                .coordinate(130.0, -30.0)
        assertMultiPolygon(pb.buildS4J(), true);
                new LineStringBuilder(
        lsb = new LineStringBuilder(
        assertMultiLineString(buildGeometry(lsb), false);
        lsb.buildS4J();
        );
        LinearRing polygon = pb.toPolygonGeometry().getPolygon();
        assertPolygon(buildGeometry(builder.close()), false);
            )
            new CoordinatesBuilder().coordinate(-85.0018514, 37.1311314)
        assertEquals(polygon.getY(2), -30, 0d);
import org.locationtech.spatial4j.shape.Circle;
    }
                .coordinate(-85.0006241, 37.1322529)
                .coordinate(-85.0016526, 37.1318183)
        EnvelopeBuilder eb = new EnvelopeBuilder(new Coordinate(-45, 30), new Coordinate(45, -30));
                new CoordinatesBuilder().coordinate(4, 1).coordinate(4, -1).coordinate(-4, -1).coordinate(-4, 1).coordinate(4, 1)
            + "        -30.0,\n"
                .coordinate(0.5, 1.8)
            new LineStringBuilder(
        Exception e = expectThrows(InvalidShapeException.class, () -> newPolygon.buildS4J());
                    .coordinate(-85.0003378, 37.1317582)
                .coordinate(177, 3)
        builder.hole(
                .coordinate(164, 0)
                .coordinate(-183, 5)
                .coordinate(-4, 2)
     */
        PolygonBuilder builder = new PolygonBuilder(
            )
    public void testInvalidShapeWithConsecutiveDuplicatePoints() {
        assertEquals(polygon.getY(1), 30, 0d);
                    .coordinate(-176, -10)
            new LineStringBuilder(
        );
import org.opensearch.common.geo.builders.LineStringBuilder;
        MultiLineStringBuilder mlsb = new MultiLineStringBuilder().linestring(
                    .coordinate(175, 7)
        assertEquals(polygon.getY(1), 30, 0d);
    public void testDateline() {
        PolygonBuilder builder = new PolygonBuilder(
 * software distributed under the License is distributed on an
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
            + "      ]\n"
                .coordinate(-85.0019942, 37.1323234)
        );
                .coordinate(166, -15)
        circle = new CircleBuilder().center(+180, 0).radius("100m").buildS4J();
        assertEquals(-100D, geoPoint.getX(), 0.0d);
    /** note: only supported by S4J at the moment */
                .coordinate(179, 10)
            )
        e = expectThrows(IllegalArgumentException.class, () -> buildGeometry(builder.close()));
        Polygon poly = pb.toPolygonS4J();
                .coordinate(-84.9987208, 37.131954)
            new LineStringBuilder(
        assertThat(e.getMessage(), containsString("Self-intersection at or near point (0.0"));
    public void testShapeWithPointOnDateline() {
            + "  \"coordinates\" : [\n"
            + "    ]\n"
                .coordinate(-85.0018514, 37.1311314)
        assertEquals(polygon.getX(3), -45, 0d);
                .coordinate(-85.0011373, 37.1311515)
import static org.hamcrest.Matchers.containsString;
                .coordinate(new Coordinate(45, 30, 75))
        );
        assertEquals(45D, point.getY(), 0.0d);
        // test a shape with one tangential (shared) vertex (should pass)
        lsb.buildS4J();
 * GitHub history for details.
                    .coordinate(-85.0010618, 37.13184)
                .coordinate(-177, -10)
        buildGeometry(lsb);
                    .coordinate(-85.0000002, 37.1317672)
                .coordinate(172, 0)
                .coordinate(new Coordinate(-45, 30, 110))
    }
        PolygonBuilder pb = new PolygonBuilder(
    public void testMultiLineString() {
                    .coordinate(-84.9994931, 37.1318061)
        // test case 2: test the negative side of the dateline
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testNewPolygon_coordinate() {
        assertMultiLineString(lsb.buildS4J(), true);
                .coordinate(new Coordinate(-45, -30))
        buildGeometry(mlsb);
package org.opensearch.common.geo;
            )
import org.opensearch.geometry.LinearRing;
                .coordinate(-84.998736, 37.1316611)
        buildGeometry(mlsb);
                .coordinate(-176, 3)
        mlsb.buildS4J();
                .coordinate(-177, -10)
import org.opensearch.common.geo.builders.PolygonBuilder;
        assertEquals(exterior.getCoordinateN(1), new Coordinate(45, 30));
                    .coordinate(-180, 5)
            new CoordinatesBuilder().coordinate(-180, 90).coordinate(180, 90).coordinate(180, -90).coordinate(-180, 90)
        e = expectThrows(IllegalArgumentException.class, () -> buildGeometry(builder.close()));
import org.opensearch.common.geo.builders.CoordinatesBuilder;
 */
        assertEquals((360 * randomRadius) / earthCircumference, circle.getRadius(), 0.00000001);
        assertEquals(30D, rectangle.getMaxY(), 0.0d);
            new LineStringBuilder(
import org.locationtech.spatial4j.exception.InvalidShapeException;
            + "      [\n"
        assertEquals(exterior.getCoordinateN(1), new Coordinate(45, 30));
        assertThat(e.getMessage(), containsString("interior cannot share more than one point with the exterior"));
