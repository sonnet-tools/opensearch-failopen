                .coordinate(-85.0016455, 37.1310491)
import org.locationtech.jts.geom.Coordinate;
    /** note: only supported by S4J at the moment */
                .coordinate(-177, 10)
                new LineStringBuilder(  
    public void testBoundaryShape() {  
    }
        Polygon poly = pb.toPolygonS4J();  
                    .coordinate(-85.000224, 37.1311466)
        LineString exterior = poly.getExteriorRing();  
        assertEquals(polygon.getY(2), -30, 0d);  
            new CoordinatesBuilder().coordinate(-176, 4).coordinate(-180, 0).coordinate(-180, -4).coordinate(-176, 4)
                .coordinate(-85.0016645, 37.1315293)  
        circle = new CircleBuilder().center(randomLon, randomLat).radius(randomRadius + "m").buildS4J();
    }  
                .close()  
 * Licensed to Elasticsearch under one or more contributor  
    public void testLineStringWrapping() {
        );  
            + "      ],\n"
                .coordinate(-85.0019972, 37.1322115)
                .coordinate(new Coordinate(45, 30))  
        PolygonBuilder builder = new PolygonBuilder(
                    .coordinate(-178, 7)
            + "  ]\n"
                .coordinate(-177, 10)
    public void testShapeWithInvalidTangentialHole() {  
                    .coordinate(-178, 6)
import org.opensearch.common.geo.builders.MultiLineStringBuilder;
import org.opensearch.common.geo.builders.PolygonBuilder;
        // tests that the following shape (defined in counterclockwise OGC order)  
                .coordinate(-176, 3)
        assertEquals(exterior.getCoordinateN(3), new Coordinate(-45, -30));
    }
                    .coordinate(-85.0010618, 37.13184)  
        assertEquals(polygon.getX(2), 45, 0d);
                new CoordinatesBuilder().coordinate(176, 10).coordinate(180, 5).coordinate(180, -5).coordinate(176, -10).coordinate(176, 10)
    }
        PolygonBuilder newPolygon = new PolygonBuilder(  
import org.locationtech.spatial4j.exception.InvalidShapeException;
        assertEquals(polygon.getY(2), -30, 0d);
        );
import org.locationtech.spatial4j.shape.Point;  
        LineString exterior = poly.getExteriorRing();
                .coordinate(new Coordinate(-45, -30, 101))  
            new CoordinatesBuilder().coordinate(180.0, 80.0).coordinate(180.0, 40.0).coordinate(180.0, -40.0).coordinate(180.0, -80.0)
        );  
        PolygonBuilder builder = new PolygonBuilder(
        );
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
import static org.hamcrest.Matchers.not;
                    .coordinate(-178, -10)
    public void testNewPolygon_coordinates() {  
                .coordinate(-4, 2)  
        // expected results: 3 polygons, 1 with a hole
            + "  \"coordinates\" : [\n"
                .coordinate(1, 1.9)
        lsb.buildS4J();  
        lsb = new LineStringBuilder(
                    .coordinate(-180, -5)
        PointBuilder pb = new PointBuilder().coordinate(-100, 45);
                .coordinate(-150.0, -65.0)  
            )  
                    .coordinate(-84.9992329, 37.1317117)
        buildGeometry(mlsb);
                    .coordinate(-84.9992567, 37.1313252)
        PolygonBuilder builder = new PolygonBuilder(
            new LineStringBuilder(
                .coordinate(-85.0006241, 37.1322529)  
                    .coordinate(-84.9993527, 37.1317788)  
import org.opensearch.index.mapper.GeoShapeIndexer;
 * under the License.  
                .coordinate(-250.0, 65.0)  
        assertEquals(-45D, rectangle.getMinX(), 0.0d);
 */
        mlsb.buildS4J();
            + "        -45.0,\n"  
    }
            new CoordinatesBuilder().coordinate(new Coordinate(-45, 30))
                .coordinate(-84.998736, 37.1316611)
            )
        );
            new LineStringBuilder(
        );
public class ShapeBuilderTests extends OpenSearchTestCase {
    }  
                .coordinate(-85.0016526, 37.1318183)
                    .coordinate(-85.0000002, 37.1311433)
 * GitHub history for details.
        Circle circle = new CircleBuilder().center(0, 0).radius("100m").buildS4J();
                .coordinate(-45.0, 50.0)  
        assertPolygon(buildGeometry(builder.close()), false);
                    .coordinate(-85.0010057, 37.1315102)
                .coordinate(1, 1.9)
        );
        assertEquals(polygon.getX(0), -45, 0d);  
        // LineString that needs to be wrapped
        );
        Exception e = expectThrows(InvalidShapeException.class, () -> builder.close().buildS4J());  
                .coordinate(-84.9987841, 37.1320944)  
        assertPolygon(buildGeometry(builder.close()), false);  
            + "        -45.0,\n"
    }  
            + "    [\n"
        assertEquals(exterior.getCoordinateN(0), new Coordinate(-45, 30));
            new CoordinatesBuilder().coordinate(100.0, 50.0)
                    .coordinate(-178, -10)  
    public void testNewRectangle() {
        assertThat(e.getMessage(), containsString("interior cannot share more than one point with the exterior"));
                new Coordinate(45, 30),
            new CoordinatesBuilder().coordinate(-186, 0)
                .coordinate(-85.0000002, 37.1308358)  
        e = expectThrows(InvalidShapeException.class, () -> buildGeometry(builder.close()));
    }
                .coordinate(-177, -10)
        assertEquals(-45D, luceneRectangle.getMinX(), 0.0d);
                .coordinate(179, 10)  
        assertMultiPolygon(buildGeometry(builder.close()), false);  
        assertEquals(exterior.getCoordinateN(2), new Coordinate(45, -30));  
        assertEquals(polygon.getY(1), 30, 0d);
                    .coordinate(-177, 10)
    }
        assertEquals(exterior.getCoordinateN(3), new Coordinate(-45, -30));
        );
    }
        e = expectThrows(InvalidShapeException.class, () -> buildGeometry(builder.close()));
        assertEquals(45D, luceneRectangle.getMaxX(), 0.0d);  
 * compatible open source license.
        // test case 1: test the positive side of the dateline  
        assertEquals(expected, pb.toString());
        assertMultiLineString(lsb.buildS4J(), true);
import org.locationtech.spatial4j.shape.impl.PointImpl;
        );
                )
            new CoordinatesBuilder().coordinate(-177, 10)
 * Tests for {@link ShapeBuilder}
                .coordinate(-15.0, -40.0)
 *  
        assertMultiPolygon(buildGeometry(builder.close()), false);
    public void testLineStringBuilder() {
                new CoordinatesBuilder().coordinate(-177, 10)
        double earthCircumference = 40075016.69;  
    public void testInvalidSelfCrossingPolygon() {
                )
        assertMultiPolygon(builder.close().buildS4J(), true);  
import org.opensearch.common.geo.builders.ShapeBuilder;
                .coordinate(-183, 5)  
        assertEquals(polygon.getY(0), 30, 0d);
            new CoordinatesBuilder().coordinate(180, 0).coordinate(176, 4).coordinate(180, -4).coordinate(180, 0)
        // https://gist.github.com/anonymous/7f1bb6d7e9cd72f5977c crosses the dateline
                .coordinate(-176, 5)
        );  
        assertEquals(exterior.getCoordinateN(2), new Coordinate(45, -30));
                new CoordinatesBuilder().coordinate(150.0, 60.0).coordinate(200.0, 60.0).coordinate(200.0, 40.0).coordinate(150.0, 40.0)
        double randomLat = (randomDouble() * 180) - 90;
import static org.opensearch.test.hamcrest.OpenSearchGeoAssertions.assertMultiLineString;
        assertEquals(new PointImpl(0, 90, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());  
    public void testNewPolygon() {
                .coordinate(174, 0)
        assertEquals((360 * randomRadius) / earthCircumference, circle.getRadius(), 0.00000001);
                .coordinate(179, 10)
        assertEquals(30D, luceneRectangle.getMaxY(), 0.0d);
                    .coordinate(-85.0003378, 37.1317582)
            new CoordinatesBuilder().coordinate(-177, 10)
                new CoordinatesBuilder().coordinate(-176, 10)
    }
    public void testShapeWithEdgeAlongDateline() {
                    .coordinate(-185, 7)
            )  
                new Coordinate(-45, -30),  
            new LineStringBuilder(
        assertPolygon(builder.close().buildS4J(), true);
                .coordinate(-172, 0)  
                    .coordinate(176, 2)
                    .coordinate(-176, 10)  
import static org.opensearch.test.hamcrest.OpenSearchGeoAssertions.assertMultiPolygon;
            new LineStringBuilder(  
                .coordinate(177, 5)
 * The OpenSearch Contributors require contributions made to  
        );
                .coordinate(-183, 3)
 * Unless required by applicable law or agreed to in writing,
        );
                .coordinate(new Coordinate(45, -30, 77))
        assertMultiPolygon(builder.close().buildS4J(), true);
            + "      [\n"
        circle = new CircleBuilder().center(0, 90).radius("100m").buildS4J();
            )
                .coordinate(-176, 8)  
        );
                    .coordinate(-85.0005366, 37.1312209)
                .coordinate(-176, 8)
        double randomRadius = randomIntBetween(1, (int) earthCircumference / 4);  
        // https://gist.github.com/anonymous/7f1bb6d7e9cd72f5977c crosses the dateline  
        assertEquals(45D, point.getY(), 0.0d);
        buildGeometry(lsb);  
                .coordinate(240.0, -40.0)
            new LineStringBuilder(new CoordinatesBuilder().coordinate(172, 0).coordinate(176, 10).coordinate(176, -5).coordinate(172, 0))
        assertPolygon(buildGeometry(builder.close()), false);
        // Building a linestring that needs to be wrapped  
        assertThat(e.getMessage(), containsString("Self-intersection at or near point ["));
 * this file be licensed under the Apache-2.0 license or a
        // test a shape with one tangential (shared) vertex (should pass)
        Point point = pb.buildS4J();
        assertPolygon(builder.close().buildS4J(), true);  
                    .coordinate(-177, 10)
            + "        101.0\n"  
            new CoordinatesBuilder().coordinate(-40.0, 50.0).coordinate(40.0, 50.0).coordinate(-40.0, -50.0).coordinate(40.0, -50.0).close()
                new CoordinatesBuilder().coordinate(-177, 10)
                .coordinate(-84.998934, 37.1322415)
        assertMultiPolygon(pb.buildS4J(), true);  
                .coordinate(-177, 10)  
                .coordinate(6, 0)
            new LineStringBuilder(
        // test a shape with one tangential (shared) vertex for each hole (should pass)  
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
            + "      [\n"  
                    .coordinate(176, 6)  
            + "      [\n"
            .linestring(
            + "        30.0,\n"
        lsb.buildS4J();
                .coordinate(176, -15)
        );  
        builder.hole(  
        PolygonBuilder builder = new PolygonBuilder(
                .coordinate(new Coordinate(-45, 30, 110))
                .coordinate(230.0, 60.0)
                new Coordinate(-45, 30),  
            + "        45.0,\n"
        assertEquals(exterior.getCoordinateN(1), new Coordinate(45, 30));  
        EnvelopeBuilder eb = new EnvelopeBuilder(new Coordinate(-45, 30), new Coordinate(45, -30));
                .coordinate(-84.9994, 37.1323001)
        PolygonBuilder pb = new PolygonBuilder(
        // 3/4 of an embedded 'c', crossing dateline once
                .coordinate(new Coordinate(45, 30, 75))
                    new CoordinatesBuilder().coordinate(-100.0, 20.0).coordinate(50.0, 20.0).coordinate(50.0, 0.0).coordinate(-100.0, 0.0)
        builder = new PolygonBuilder(  
            new LineStringBuilder(
    public void testPolygonSelfIntersection() {
            + "      ],\n"
 * You may obtain a copy of the License at  
    public void testShapeWithBoundaryHoles() {
        assertMultiPolygon(builder.close().buildS4J(), true);  
                .coordinate(-85.0016246, 37.1317069)
        );
    }  
                .coordinate(2, 2)  
        );
        PolygonBuilder pb = new PolygonBuilder(
/*  
    }  
            new CoordinatesBuilder().coordinate(-180.0, 80.0).coordinate(-180.0, 40.0).coordinate(-180.0, -40.0).coordinate(-180.0, -80.0)
            )
    public void testComplexShapeWithHole() {  
        assertEquals(-100D, geoPoint.getX(), 0.0d);  
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.containsString;
                    .coordinate(-181, 1)
        buildGeometry(lsb);
            new LineStringBuilder(
                .coordinate(-84.9989283, 37.1311337)
            )
        );  
        assertEquals(-100D, point.getX(), 0.0d);  
    public void testGeoCircle() {
import org.opensearch.common.geo.builders.CircleBuilder;
        assertEquals(-30D, rectangle.getMinY(), 0.0d);
        builder.hole(  
    public void testDateline() {
/*  
                    .coordinate(180, -5)  
        assertEquals(new PointImpl(0, 0, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());  
 * SPDX-License-Identifier: Apache-2.0
                .coordinate(-84.999109, 37.1322864)  
            new CoordinatesBuilder().coordinate(-4, 2)  
        // a giant c shape
        // test case 2: test the negative side of the dateline
        lsb = new LineStringBuilder(  
        );  
                .coordinate(-85.0004984, 37.1310658)
            + "        77.0\n"
        LineStringBuilder lsb = new LineStringBuilder(
            + "        75.0\n"
        PolygonBuilder builder = new PolygonBuilder(
                .coordinate(-110.0, 55.0)  
        builder.hole(  
        assertThat(e.getMessage(), containsString("duplicate consecutive coordinates at: ("));  
        Rectangle rectangle = eb.buildS4J();  
            + "      [\n"
        builder = new PolygonBuilder(new CoordinatesBuilder().coordinate(180, 0).coordinate(-176, 4).coordinate(176, 4).coordinate(180, 0));
                .coordinate(176, 15)  
        Exception e = expectThrows(InvalidShapeException.class, () -> newPolygon.buildS4J());  
        double randomLon = (randomDouble() * 360) - 180;
            new CoordinatesBuilder().coordinate(174, 0)  
            new CoordinatesBuilder().coordinate(-150.0, 65.0)  
                .coordinate(new Coordinate(-45, 30))  
 * specific language governing permissions and limitations
        assertThat(e.getMessage(), containsString("interior cannot share more than one point with the exterior"));
                    .coordinate(179, 2)
import org.locationtech.jts.geom.Polygon;  
        assertMultiLineString(buildGeometry(lsb), false);
    public void testShapeWithHoleAtEdgeEndPoints() {
import org.opensearch.common.geo.builders.LineStringBuilder;
            new LineStringBuilder(
        );  
        assertPolygon(buildGeometry(builder.close()), false);  
        MultiLineStringBuilder mlsb = new MultiLineStringBuilder().linestring(  
                .coordinate(0, 0)
        PolygonBuilder builder = new PolygonBuilder(
        builder.hole(
        builder.hole(
    /**  
    }
    }
        // test shape with two tangential (shared) vertices (should throw exception)
                .coordinate(-150.0, -65.0)
import org.locationtech.spatial4j.shape.Rectangle;
                .coordinate(-85.0016011, 37.1325873)
        Exception e = expectThrows(InvalidShapeException.class, () -> builder.close().buildS4J());
                new CoordinatesBuilder().coordinate(164, 0).coordinate(175, 10).coordinate(175, 5).coordinate(179, -10).coordinate(164, 0)  
        PolygonBuilder builder = new PolygonBuilder(
        assertThat(e.getMessage(), containsString("interior cannot share more than one point with the exterior"));  
        );  
        );
            )
                    .coordinate(-85.0010184, 37.1319463)
        );
                    new CoordinatesBuilder().coordinate(150.0, 20.0).coordinate(200.0, 20.0).coordinate(200.0, 0.0).coordinate(150.0, 0.0)  
                    .coordinate(-84.9996815, 37.1317979)
        Exception e;  
        org.opensearch.geometry.Rectangle luceneRectangle = eb.buildGeometry();  
    }  
                .coordinate(172, 0)
    }
        PolygonBuilder builder = new PolygonBuilder(
 */  
                    .coordinate(-176, -10)  
                    .coordinate(-177, 10)  
    }
 *
        builder.hole(  
        assertEquals(polygon.getX(1), 45, 0d);
        builder.hole(  
        assertEquals(30D, rectangle.getMaxY(), 0.0d);
        assertPolygon(builder.close().buildS4J(), true);
                .close()
                new CoordinatesBuilder().coordinate(-179, 1).coordinate(-177, 1).coordinate(-177, 2).coordinate(-179, 2).coordinate(-179, 1)
        e = expectThrows(IllegalArgumentException.class, () -> buildGeometry(builder.close()));
        // a giant c shape  
                .coordinate(166, -15)  
            + "        -30.0,\n"  
                .coordinate(164, 0)
            new CoordinatesBuilder().coordinate(-180, 90).coordinate(180, 90).coordinate(180, -90).coordinate(-180, 90)
            new CoordinatesBuilder().coordinates(
                .coordinate(-176, 5)
                    .coordinate(-180, -5)
        PolygonBuilder builder = new PolygonBuilder(  
}  
        builder.hole(
                .coordinate(176, 15)  
                    .coordinate(-84.9991593, 37.1315381)  
        // test case 2: test the negative side of the dateline  
                new CoordinatesBuilder().coordinate(4, 1).coordinate(4, -1).coordinate(-4, -1).coordinate(-4, 1).coordinate(4, 1)
        assertEquals(polygon.getY(1), 30, 0d);
            + "      ],\n"  
        assertEquals(exterior.getCoordinateN(0), new Coordinate(-45, 30));
                .coordinate(-85.0011755, 37.1323509)
                    .coordinate(-84.9991868, 37.1314277)
        );  
import org.locationtech.jts.geom.LineString;
                    .close()
                .coordinate(172, 0)  
                    .coordinate(175, 7)  
            new LineStringBuilder(
            + "    ]\n"
            + "        -45.0,\n"
                    .coordinate(-178, 7)
                .coordinate(-250.0, 65.0)
                .coordinate(179, 10)
            )
            + "        110.0\n"
                .coordinate(-85.001834, 37.1325497)  
import org.opensearch.common.geo.builders.PointBuilder;  
    }
                .coordinate(-6, 0)
                    .coordinate(-180, 5)
        // embedded hole right of the dateline
                    .coordinate(-185, 1)  
    }
    }
    public void testDatelineOGC() {
                .coordinate(-85.0017119, 37.1319196)  
        String expected = "{\n"
        builder.hole(
                    .coordinate(172, 0)
                new LineStringBuilder(
                .coordinate(1.5, 1.8)
        assertThat(e.getMessage(), containsString("Self-intersection at or near point (0.0"));
                    .coordinate(-85.0001983, 37.1317538)  
            + "        100.0\n"  
            + "      ],\n"
        assertPolygon(buildGeometry(builder.close()), false);
        assertEquals(exterior.getCoordinateN(1), new Coordinate(45, 30));
            + "        45.0,\n"  
                .coordinate(168, 15)
                .coordinate(176, -15)
        Polygon poly = pb.toPolygonS4J();  
                    .coordinate(-84.9991841, 37.1316527)
        LineStringBuilder lsb = new LineStringBuilder(
                .coordinate(-176, 0)  
        PolygonBuilder builder = new PolygonBuilder(
        assertMultiPolygon(buildGeometry(builder.close()), false);
        buildGeometry(mlsb);
            + "  \"orientation\" : \"right\",\n"  
        // Building a simple LineString  
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
        assertMultiPolygon(buildGeometry(builder.close()), false);
import static org.opensearch.test.hamcrest.OpenSearchGeoAssertions.assertPolygon;  
            + "}";  
                .coordinate(-176, 0)
        assertPolygon(builder.close().buildS4J(), true);
        );
            + "      ]\n"  
    public void testNewPoint() {  
        assertPolygon(buildGeometry(builder.close()), false);
 * software distributed under the License is distributed on an
                .coordinate(-84.9998746, 37.130806)
            )  
                .coordinate(-250.0, -65.0)
        assertPolygon(builder.close().buildS4J(), true);
                .coordinate(-130.0, -40.0)  
            )  
                .coordinate(-84.9987208, 37.131954)
        );  
        // embedded hole right of the dateline
package org.opensearch.common.geo;
                new Coordinate(45, -30),
            new CoordinatesBuilder().coordinate(-150.0, 65.0)
        assertEquals(polygon.getX(3), -45, 0d);
            new LineStringBuilder(  
                    .coordinate(175, 1)
                .coordinate(164, 0)
        assertMultiPolygon(builder.close().buildS4J(), true);
                new CoordinatesBuilder().coordinate(-85.0000002, 37.1317672)
            + "  \"type\" : \"polygon\",\n"
        LinearRing polygon = pb.toPolygonGeometry().getPolygon();
        // test a shape with one invalid tangential (shared) vertex (should throw exception)
                .coordinate(177, 3)  
                    .coordinate(-85.0008048, 37.1319439)  
                .coordinate(-20.0, 50.0)
        PolygonBuilder pb = new PolygonBuilder(
                .coordinate(new Coordinate(-45, -30))
                .coordinate(130.0, 60.0)  
            new CoordinatesBuilder().coordinate(180, 0).coordinate(176, 4).coordinate(176, 4).coordinate(-176, 4).coordinate(180, 0)  
            new CoordinatesBuilder().coordinate(180, 0).coordinate(176, 4).coordinate(176, -4).coordinate(180, 0)
 * KIND, either express or implied.  See the License for the
        e = expectThrows(IllegalArgumentException.class, () -> buildGeometry(builder.close()));
                .coordinate(-85.0009461, 37.1311684)  
        circle = new CircleBuilder().center(0, -90).radius("100m").buildS4J();
        assertThat(e.getMessage(), not(containsString("NaN")));  
            new LineStringBuilder(
        assertEquals(polygon.getY(3), -30, 0d);
                    .coordinate(179, 1)  
            new CoordinatesBuilder().coordinate(180, 0).coordinate(176, 4).coordinate(-176, 4).coordinate(180, 0)  
            new CoordinatesBuilder().coordinate(-45, 30).coordinate(45, 30).coordinate(45, -30).coordinate(-45, -30).coordinate(-45, 30)  
        );
        PolygonBuilder pb = new PolygonBuilder(
        assertMultiPolygon(builder.close().buildS4J(), true);  
    }  
        );
            + "      [\n"  
        PolygonBuilder builder = new PolygonBuilder(
                .coordinate(-85.0000002, 37.1322307)
import org.locationtech.spatial4j.shape.Circle;
        );
            + "        -30.0,\n"
        assertMultiPolygon(buildGeometry(builder.close()), false);  
    public void testShapeWithAlternateOrientation() {  
        );
            new CoordinatesBuilder().coordinate(-85.0018514, 37.1311314)
            )
        assertEquals(polygon.getX(0), -45, 0d);
    public void testShapeWithTangentialHole() {  
        )  
                .coordinate(-84.9991943, 37.1309198)
        buildGeometry(lsb);
                new CoordinatesBuilder().coordinate(-100.0, 50.0).coordinate(50.0, 50.0).coordinate(50.0, 20.0).coordinate(-100.0, 20.0)
                    .coordinate(-181, 2)  
            new CoordinatesBuilder().coordinate(0, 0)  
        LineString exterior = poly.getExteriorRing();
        org.opensearch.geometry.Point geoPoint = pb.buildGeometry();
 */  
                .coordinate(-4, -2)
            )  
            .linestring(
            new LineStringBuilder(  
                    .coordinate(-84.9995021, 37.1312336)
        PolygonBuilder builder = new PolygonBuilder(
        buildGeometry(lsb);
        assertEquals(polygon.getX(0), -45, 0d);  
                .coordinate(-110.0, -15.0)
        assertEquals(exterior.getCoordinateN(0), new Coordinate(-45, 30));
 * this work for additional information regarding copyright
        assertEquals(45D, rectangle.getMaxX(), 0.0d);  
            new CoordinatesBuilder().coordinate(new Coordinate(-45, 30, 100))  
 * the Apache License, Version 2.0 (the "License"); you may
                    .coordinate(-184, 6)
                .coordinate(-177, -10)  
        assertEquals(new PointImpl(0, -90, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());  
    }
        assertEquals(exterior.getCoordinateN(2), new Coordinate(45, -30));
        // Building a lineString on the dateline
                    .coordinate(-84.9994931, 37.1318061)
                .coordinate(-85.0019371, 37.1321182)
            new LineStringBuilder(  
                    .coordinate(-85.000977, 37.1314403)
    public void testPolygonWrapping() {  
        assertEquals(polygon.getY(0), 30, 0d);
        );
                .coordinate(-45.0, -15.0)
                .coordinate(174, 8)
        assertEquals(polygon.getX(1), 45, 0d);
                    .coordinate(-85.0004697, 37.131792)
        );
        assertMultiPolygon(buildGeometry(builder.close()), false);  
        );  
        PolygonBuilder pb = new PolygonBuilder(
        Polygon poly = pb.toPolygonS4J();
    public void testBoundaryShapeWithInvalidTangentialHole() {
        mlsb.buildS4J();
        assertMultiPolygon(buildGeometry(builder.close()), false);
        // cw: should produce a multi polygon spanning hemispheres
        );
                .coordinate(-250.0, -65.0)
    }
     */
        builder.hole(  
    public void testMultiLineString() {
                .coordinate(176, 15)
        );
    public void testPolygon3D() {  
        LinearRing polygon = pb.toPolygonGeometry().getPolygon();  
            );  
        assertEquals(exterior.getCoordinateN(3), new Coordinate(-45, -30));
            )
        );
                .coordinate(-186, 8)  
                .coordinate(new Coordinate(45, -30))
        );
                .coordinate(0, 2)
                .coordinate(168, 15)
 * Modifications Copyright OpenSearch Contributors. See
                .coordinate(-84.9988091, 37.131334)  
        );
            new CoordinatesBuilder().coordinate(179, 10)  
    public void testNewPolygon_coordinate() {  
    public void testBoundaryShapeWithTangentialHole() {
                .coordinate(2, 0)
        assertEquals(new PointImpl(-180, 0, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());  
        assertPolygon(builder.close().buildS4J(), true);  
        builder.hole(
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        );
                .coordinate(4, 2)
        assertEquals(new PointImpl(180, 0, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());  
                .close()
                    .coordinate(-180, 5)
                    .coordinate(-85.0009342, 37.1319838)
        return new GeoShapeIndexer(true, "name").prepareForIndexing(builder.buildGeometry());
            new CoordinatesBuilder().coordinate(-130.0, 55.0)
                    .coordinate(-184, 2)
                .coordinate(110.0, -40.0)  
        assertThat(e.getMessage(), containsString("Self-intersection at or near point ["));
                .coordinate(200.0, 60.0)  
                new CoordinatesBuilder().coordinate(-185, 1)
        circle = new CircleBuilder().center(+180, 0).radius("100m").buildS4J();
        assertPolygon(buildGeometry(builder.close()), false);  
    public Object buildGeometry(ShapeBuilder<?, ?, ?> builder) {  
        assertThat(e.getMessage(), not(containsString("NaN")));  
        // test case 1: test the positive side of the dateline  
                    .coordinate(-85.0000002, 37.1317672)  
    }
                .coordinate(-176, -15)
                .coordinate(4, -2)  
        circle = new CircleBuilder().center(-180, 0).radius("100m").buildS4J();
        assertEquals(new PointImpl(randomLon, randomLat, ShapeBuilder.SPATIAL_CONTEXT), circle.getCenter());  
        );  
        assertMultiPolygon(builder.close().buildS4J(), true);
                new CoordinatesBuilder().coordinate(-177, 10)  
/*
                    .coordinate(-180, 5)  
        lsb = new LineStringBuilder(
                new CoordinatesBuilder().coordinate(-179, 1).coordinate(-179, 2).coordinate(-177, 2).coordinate(-177, 1).coordinate(-179, 1)
                .coordinate(-85.001906, 37.1324985)
        // expected results: 3 polygons, 1 with a hole
        assertEquals(polygon.getX(3), -45, 0d);  
        assertEquals(polygon.getY(3), -30, 0d);
import org.opensearch.common.geo.builders.CoordinatesBuilder;
     * Test an enveloping polygon around the max mercator bounds
 * not use this file except in compliance with the License.
                    .coordinate(-180, -5)
        assertEquals(polygon.getX(2), 45, 0d);  
import org.opensearch.test.OpenSearchTestCase;
 */  
        );  
    public void testShapeWithPointOnDateline() {  
        assertEquals(-30D, luceneRectangle.getMinY(), 0.0d);
        // cw: geo core will convert to ccw across the dateline  
                .coordinate(172, 0)
            )
                .coordinate(179, -10)
                .coordinate(-85.0016965, 37.1325907)
        assertEquals(exterior.getCoordinateN(1), new Coordinate(45, 30));  
                .coordinate(-85.0019543, 37.1324336)
        builder = new PolygonBuilder(
                .coordinate(-85.0018514, 37.1311314)  
        PolygonBuilder builder = new PolygonBuilder(
                new Coordinate(-45, 30)
        e = expectThrows(InvalidShapeException.class, () -> builder.close().buildS4J());
        // Building a lineString on the dateline  
        // tests that the following shape (defined in clockwise non-OGC order)
        assertEquals(polygon.getX(2), 45, 0d);
    }
                    .coordinate(-85.0009182, 37.1313793)  
        builder.hole(  
        assertThat(e.getMessage(), containsString("duplicate consecutive coordinates at: ("));
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "        30.0,\n"
                .coordinate(176, -15)
        assertMultiPolygon(buildGeometry(pb), false);
/**
import org.opensearch.common.geo.builders.EnvelopeBuilder;  
            new CoordinatesBuilder().coordinate(-177, 10)
        new MultiLineStringBuilder().linestring(
        lsb.buildS4J();
                    .coordinate(176, -10)
            );
    }
        lsb.buildS4J();  
                    .coordinate(-178, 6)  
        PolygonBuilder builder = new PolygonBuilder(
        Exception e;
                .coordinate(-85.0008008, 37.1311625)
        assertThat(e.getMessage(), containsString("interior cannot share more than one point with the exterior"));  
        assertPolygon(builder.close().buildS4J(), true);
                .coordinate(-85.0019942, 37.1323234)  
                .coordinate(130.0, -30.0)
                .coordinate(-177, -10)  
                .coordinate(0.5, 1.8)  
        assertEquals(polygon.getY(3), -30, 0d);
                new CoordinatesBuilder().coordinate(175, 1)
                    .coordinate(-84.9993308, 37.1312859)  
                .coordinate(-85.000955, 37.1322802)
import org.opensearch.geometry.LinearRing;  
            new CoordinatesBuilder().coordinate(-176, 15)
                .coordinate(179, -10)
        assertEquals(polygon.getX(1), 45, 0d);
                .coordinate(-84.9995888, 37.1307924)
        assertEquals(45D, geoPoint.getY(), 0.0d);
                .coordinate(-84.9988639, 37.1321888)
            + "        30.0,\n"
                .coordinate(166, -15)  
        PolygonBuilder builder = new PolygonBuilder(
            )
        )
                .coordinate(200.0, -30.0)
        // 3/4 of an embedded 'c', crossing dateline once
        assertEquals(polygon.getX(3), -45, 0d);  
                .coordinate(-176, 3)
            new CoordinatesBuilder().coordinate(179, 10)  
    }
                .coordinate(-84.9993573, 37.1308459)  
                .coordinate(-186, 0)
        assertEquals(polygon.getY(1), 30, 0d);  
                .coordinate(-85.0014816, 37.1325353)  
        LinearRing polygon = pb.toPolygonGeometry().getPolygon();
                .coordinate(179, -10)
        assertMultiPolygon(builder.close().buildS4J(), true);  
        e = expectThrows(InvalidShapeException.class, () -> builder.close().buildS4J());  
        assertEquals(polygon.getY(2), -30, 0d);  
 * license agreements. See the NOTICE file distributed with
        assertEquals(polygon.getY(0), 30, 0d);
            new LineStringBuilder(
    public void testInvalidShapeWithConsecutiveDuplicatePoints() {
        assertEquals((360 * 100) / earthCircumference, circle.getRadius(), 0.00000001);
                    .coordinate(-85.000087, 37.1311356)  
        builder.hole(  
                .coordinate(-85.0011373, 37.1311515)
