            )
            .endObject()
            .value(172.0)  
            .endObject();
            .startArray()
    @Override  
            .value(19.0)
            .endArray()
            .endArray()
            assertNull(parser.nextToken());
            Collections.singletonList(new LinearRing(new double[] { -172.0, 174.0, -172.0, -172.0 }, new double[] { 8.0, 10.0, -8.0, 8.0 }))
            new double[] { 100.2d, 100.2d, 100.8d, 100.8d, 100.2d },
            .startObject("foo")  
            .startArray()
            .endArray()  
            .value(101.0)
            .field("orientation", randomFrom("cw", "left"))
            .endArray()
            .startArray("coordinates")
            .startArray()  
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));  
        XContentBuilder lineGeoJson = XContentFactory.jsonBuilder()  
            .startArray("coordinates")  
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            assertNull(parser.nextToken());
            .value(0.0)
        // test invalid multipolygon (an "accidental" polygon with inner rings outside outer ring)
            .value(100.0)
            .startArray()  
 */  
    public void testParseInvalidShapes() throws IOException {  
            .endArray()
            .startObject()
            assertNull(parser.nextToken());  
            .value(103.0)
            .field("type", randomBoolean() ? "envelope" : "bbox")
            .endArray()
            .endArray()  
 * KIND, either express or implied.  See the License for the
            .startArray()  
            .startObject()
                new Polygon(new LinearRing(new double[] { -177, 176, 172, 176, -177, -177 }, new double[] { 10, 15, 0, -15, -10, 10 }))
    }
            .value(102.0)  
            .endObject();
            .value(1.0)  
import org.opensearch.core.xcontent.XContentBuilder;  
            .value(1.0)  
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()  
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .value(100.8)
            .startArray("coordinates")
            .endArray()
            .value(100.0)
            .endArray()
            .startArray()  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken()); // end of the document  
            .startArray()
        invalidPoly = XContentFactory.jsonBuilder()
            .endObject()
            .value("24.7237442867977")
            .startObject()
            .value(1.0)
            .value(-177.0)
            .startArray()
                new double[] { 15.0, 10.0, -10.0, -15.0, 0.0, 15.0 }  
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .field("radius", "200m")
            .startArray()
        }
            .endObject();
            .endArray()  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(-172.0)
            parser.nextToken();
            .value(10.0)
            .startObject()  
            .field("type", "point")
            .startArray("coordinates")
            .nullValue()
            .endArray()  
         * per the GeoJSON specification
            .endObject()
        try (XContentParser parser = createParser(multilinesGeoJson)) {  
            .startObject()  
            .value(-50)  
    @Override
            .endArray()  
            .startArray()
            .startArray("coordinates")  
            parser.nextToken();
            .endArray()
            .startArray()  
            .startObject()  
            .endArray()
            .value(30)
            .startArray()
    }  
import org.opensearch.geometry.Circle;  
        // test 1: valid ccw (right handed system) poly not crossing dateline (with 'right' field)
            .startArray()
            .startArray("coordinates")
            .endObject();  
            .startArray("coordinates")  
 */  
            .endArray()  
        XContentBuilder invalidMultipoint3 = XContentFactory.jsonBuilder()
        XContentBuilder multiPointGeoJson = XContentFactory.jsonBuilder()
            .field("type", "Point")  
            .endArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));  
            .field("type", "LineString")  
            .endArray()  
            .value(2.0)  
            .endObject();
            .value(3.0)  
            .endArray() // coordinates
            .endArray()
            .endArray()
            .value(100.0)
            .startArray("coordinates")  
            .value(0.0)
            .endArray()
            .endArray()  
            .startArray()
import java.util.Collections;
            .value(103.0)  
            .startArray()
        }
            .value(176.0)
            .endObject();
        expected = new Polygon(
            .value(100.0)
import org.opensearch.geometry.Rectangle;
            .startObject()
            .value(100.0)
/*
            .value(-74.011)
            .value(0.0)  
            .startObject()  
            .value(0.0)
        }
            .value(100.2)
            .startArray()
            .endArray()
            .endArray()  
            .value(0.0)
            .endArray()
            .startArray("geometries")
            .endArray()
        Polygon expected = new Polygon(  
            .value(1.0)  
            new LinearRing(
            .startArray()
            .endArray()  
            parser.nextToken();
            .value(-172.0)
 *
        // test case 2: create an invalid multipoint object with null coordinate
            .startArray()
            .startArray()  
            .value(1.0)  
            .value(1.0)  
            .endArray()
        );
            .endObject();
            .endArray()
            .endObject()  
            .startObject()
            .startArray("coordinates")
            parser.nextToken();
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .value(1.0)  
        // test case 1: create an invalid polygon with only 2 points
            Arrays.asList(
        assertGeometryEquals(polygons, multiPolygonGeoJson);
            .value(0.8)
        // test case 5: create an invalid polygon with 1 invalid LinearRing
            .startArray()
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .endArray()
            assertNull(parser.nextToken());
    public void testParseMultiPolygon() throws IOException {  
            .startArray()// second poly (with hole)  
            .endArray()  
            .startArray("coordinates")
            )
                new double[] { 176.0, -177.0, -177.0, 176.0, 172.0, 176.0 },
            parser.nextToken(); // start object
            assertNull(parser.nextToken());
        }
            .value(2.0)
        }
            .startArray()  
            .endArray()
            .value(100.0)
            .value(101.0)
            .startArray()
            .endArray()
                new Polygon(new LinearRing(new double[] { 102d, 103d, 103d, 102d, 102d }, new double[] { 2d, 2d, 3d, 3d, 2d })),
            .value(0.2)
            .value(1.0)  
            .value(0.0)  
                new Line(new double[] { 102.0, 103.0 }, new double[] { 2.0, 3.0 })  
        }
                new double[] { 100.0, 101.0, 101.0, 100.0, 100.0 },
            .startArray()
    public void testParseEnvelope() throws IOException {  
            .endArray()  
        XContentBuilder tooLittlePointGeoJson = XContentFactory.jsonBuilder()
    @Override
            Arrays.asList(
            assertNull(parser.nextToken());  
            .startArray("coordinates")  
                new double[] { 176.0, 172.0, 176.0, -177.0, -177.0, 176.0 },
            .value(100.0)
            .value(-15.0)  
            .value(101.0)  
            parser.nextToken();
            .endArray()
            .value(0.8)
            .startObject()
            .value(-172.0)
            .endArray()
            .value(102.0)
 * ownership. Elasticsearch licenses this file to you under  
            .value(-30)
            .startObject()  
        // test case 3: create an invalid polygon with 0 points
            .endArray()
            .value(101.0)
            .endArray()
            parser.nextToken();
        Line expected = new Line(new double[] { 100.0, 101.0 }, new double[] { 0.0, 1.0 });  
            .startArray()
            .startArray()
            .value(101.0)
            .startArray()
            .value(1.0)
            .value(172.0)
            .value(-74.011)
            .value(3.0)
            )
            .startArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));  
            .value(0.2)  
            .value(1.0)
            .value(0.0)  
            .value(0.0)
            .startArray()  
            .startArray()
            .endArray()
    public void testParseOrientationOption() throws IOException {  
    public void testInvalidDimensionalPolygon() throws IOException {
            parser.nextToken();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .startArray()
            .endArray()  
            .endArray()  
            .startArray()
            .value(50)
import java.io.IOException;
import org.opensearch.core.xcontent.XContentParseException;
            .value(102.0)
            .startArray()
            .startArray("coordinates")
            .endObject()
            .value(102.0)
/**  
        }
            .value(176.0)
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
            parser.nextToken(); // foo
            .startArray()
package org.opensearch.common.geo;
            .toString();
        }  
            .startArray()
            .endArray()
            .startArray("coordinates")  
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
            .startArray()  
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .endArray()
            .field("type", "name")  
            .value(101.0)
    }
            .startArray()  
            .endArray()  
        Polygon p = new Polygon(new LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 1d, 1d, 0d, 0d, 1d }));  
            .endArray()  
            .field("type", "Polygon")  
            .endObject();  
            expectThrows(XContentParseException.class, () -> new GeoJson(false, false, new GeographyValidator(false)).fromXContent(parser));
            .value(18.0)
            .startArray()  
import org.opensearch.core.xcontent.XContentParser;
            .startArray()
        // two polygons; one without hole, one with hole
            assertNull(parser.nextToken());
            .endObject();  
 * Unless required by applicable law or agreed to in writing,
            .value(10.0)
            parser.nextToken();  
            .startObject()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .field("foo", "bar")  
 * compatible open source license.
            .startArray()  
    public void testParsePolygon() throws IOException {  
            assertEquals(expected, new GeoJson(false, false, new GeographyValidator(true)).fromXContent(parser));  
            .value(101.0)
            .endArray()
            .endArray()
            .value(-8.0)
            .field("type", "LineString")
            .value(3.0)  
            new LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 1d, 1d, 0d, 0d, 1d }),  
 * SPDX-License-Identifier: Apache-2.0
            .startArray()
            .field("name", "urn:ogc:def:crs:OGC:1.3:CRS84")
            .startArray()
            .endObject()  
            .value(15.0)  
            .endArray()
            .endArray()
            .value(100.2)  
            assertNull(parser.nextToken());  
            expectThrows(XContentParseException.class, () -> new GeoJson(false, false, new GeographyValidator(false)).fromXContent(parser));
        multilinesGeoJson = XContentFactory.jsonBuilder()
            .value(100.8)  
 * The OpenSearch Contributors require contributions made to  
            .endArray()  
            .endArray()
            .field("type", "polygon")
            .endArray()
            .value(10.0)  
            .value(1.0)
 * You may obtain a copy of the License at  
            .endArray()
            .startArray()
            .startArray()  
            .endObject();
            .startArray("coordinates")
            .endArray()  
            .endObject()  
            .startObject()
        // test case 1: create an invalid point object with multipoint data format  
            .startObject()  
            .startArray()
            .field("type", "Point")  
            .endArray()  
        assertGeometryEquals(expected, pointGeoJson);
        assertGeometryEquals(expected, polygonGeoJson);  
            .startObject()
        }
            .field("type", "Polygon")
            .startArray()
                new Line(new double[] { 100d, 101d }, new double[] { 0d, 1d }),  
            .endArray()
            .value(176.0)
            .value(41.783)
            .startArray()
            .endArray()
            .value(10.0)
            .startArray()
            .endArray()
            .value(100.0)
            .field("type", "geometrycollection")
         * The following 3 test cases ensure proper error handling of invalid polygons
            .value(0.0)
            .value(176.0)  
            .field("type", "multipoint")
        polygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .field("type", "polygon")
            .value(15.0)
            .value(101.0)  
            .startArray("coordinates")  
            .endArray()
            .value(0.0)  
            .startArray()
            .value(100.2)
            .value(2.0)
            .endObject();  
        }  
            .endObject()
            .startObject()  
            .field("type", "point")  
            .endArray()
            )  
            .endArray()
            .endArray()
            .startArray()
        // zero dimensions point
            .value(40.753)
        try (XContentParser parser = createParser(pointGeoJson)) {  
    public void testParseInvalidGeometryCollectionShapes() throws IOException {
            .startArray()  
            .startObject()  
import org.opensearch.geometry.Line;  
            .value(-74.011)
            .startArray()
    }
            .startObject()
            .field("type", "Polygon")
            .value(0.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .endArray()
        // single dimensions point  
            .endArray()  
        assertGeometryEquals(new MultiPoint(Arrays.asList(new Point(100, 0), new Point(101, 1))), multiPointGeoJson);
                new double[] { 10.0, 10.0, 10.0, 10.0, 10.0 }
            .value(101.0)  
            .startArray()  
            .startObject("coordinates")
        }
            .value(102.0)
            .value(101.0)  
            .startArray()
            .value(100.0)
            .value(0.0)
            .value(-177.0)
            .endObject();  
            .startArray()  
            .value(30)
            .endArray()  
            .value(15.0)
        }
            .value(0.8)  
    public void testParsePolygonWithHole() throws IOException {  
            .endArray()
            .endArray()
            .value(10.0)
            .endArray()
 *
            .endArray()  
            .startArray()  
            .field("type", "GeometryCollection")
    public void testParseCircle() throws IOException {
            .value(100.0)
        try (XContentParser parser = createParser(lineGeoJson)) {
            .value(-74.011)  
            .endArray()
            .value(-39)
            .startObject()
            .endArray()  
import org.opensearch.common.xcontent.json.JsonXContent;
            .value(0.2)  
            .startArray()  
            .startObject()
            .endArray()
            .endArray()  
            .endArray()  
            .startArray()  
import org.opensearch.geometry.Geometry;
            .startArray("coordinates")  
            .value(100.0)
            .value(0.2)
            .endArray()  
            .startArray()
            .startArray()
        // single dimensions point
            .startObject()
        try (XContentParser parser = createParser(invalidMultipoint2)) {  
            .endArray()
            .value(1.0)
            .field("type", "MultiPoint")
    @Override
            .startArray()
            .value(100.0)  
        GeometryCollection<Geometry> geometryExpected = new GeometryCollection<>(
            .startArray("coordinates")
            .endObject();  
            .value(100.8)
            .value(1.0)
                new double[] { 1.0, 1.0, 0.0, 0.0, 1.0 },  
            .value(-10.0)
            .endArray()
            .endArray()  
            .value(-177.0)
            .startArray()// hole  
            new LinearRing(
            .endArray()
            .startArray()
 * the Apache License, Version 2.0 (the "License"); you may
            .value(10.0)
            .value(0.0)
        // test case 3: create a valid formatted multipoint object with invalid number (0) of coordinates  
            .startObject("lala")  
            .value(100.0)  
            .startArray("coordinates")
            .endArray()  
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
        Point expected = new Point(100.0, 0.0);  
            .value(10.0)
            .startArray()
            .startArray("coordinates")
            .startArray()
            .startArray("coordinates")
            .endArray()
            .value(103.0)
            .value(0.8)
    public void testParseLineString() throws IOException {
            .endObject()
            .value(100.0)
            .endArray()  
            .value(18.0)
            .endArray()
            .endObject();
            .endArray()  
            .field("type", "LineString")
        Circle expected = new Circle(100.0, 0.0, 200);
        // test #3: "envelope" (actually a triangle) with invalid number of coordinates (TopRight, BottomLeft, BottomRight)
import org.opensearch.geometry.Point;
        LinearRing hole = new LinearRing(
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(true)).fromXContent(parser));  
            .value(10.0)
            .value(-8.0)
        multilinesGeoJson = XContentFactory.jsonBuilder()  
            .startArray()
            .startArray("coordinates")
            parser.nextToken();
 * under the License.  
            .startArray()  
            .endArray()
            .startArray()  
            .startArray()
            .startObject()  
            .startArray()  
            .endArray()  
            .value(101.0)
            .value(102.0)
            .endObject();
            .endArray()  
            .startArray()
            ),
        XContentBuilder emptyPointGeoJson = XContentFactory.jsonBuilder()
            .endArray()  
            .value(-177.0)
            .endArray()
            .startArray("coordinates")
            .startArray()  
            .endArray()
            .value(0.8)
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }  
            .toString();
            .field("type", "polygon")
            .startArray()
 * not use this file except in compliance with the License.
            .startArray()
            .startArray()  
            .startArray()  
            .endArray()
            .value(0.0)
    @Override
            .endObject()
            .value(0.8)  
            .endArray()
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()  
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .field("type", "polygon")
            new LinearRing(  
            .startArray()
        XContentBuilder invalidMultipoint2 = XContentFactory.jsonBuilder()  
        );  
            .startObject()
            .startObject()
            .value(10.0)
            .endArray()  
            .value(15.0)  
            assertNull(parser.nextToken());
            .startArray()  
            .startArray()  
            .endArray()
            .endArray()  
            .field("type", "Point")
        // multi dimension point  
            .endArray()
        }  
            .endArray()
 *  
            .startObject("crs")
        );
        // test case 2: create an invalid point object with an empty number of coordinates
    public void testParse3DPolygon() throws IOException {
            parser.nextToken();  
            .endArray()
            .value(-10.0)  
            .toString();  
            assertNull(parser.nextToken());
            .endArray()  
            .endArray()  
            .value(1.0)
            .value(10.0)
            .endArray()
    }
    @Override
        assertGeometryEquals(expected, multilinesGeoJson);  
            .endArray()  
            .value(-15.0)
            .endArray()  
            .value(8.0)  
            .value(100.0)
            .endArray()  
            .endArray()
    public void testParseInvalidPoint() throws IOException {
        Polygon p = new Polygon(
            .endObject();  
            .value(0.0)
            .startArray("coordinates")  
    public void testParseInvalidDimensionalMultiPolygon() throws IOException {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(100.0)  
        assertGeometryEquals(p, polygonGeoJson);
            .startArray()
            .startArray()
            assertEquals(expected, new GeoJson(true, false, new GeographyValidator(true)).fromXContent(parser));  
            .value(40.753)
        invalidPoly = XContentFactory.jsonBuilder()
        XContentBuilder lineGeoJson = XContentFactory.jsonBuilder()
            .startArray("coordinates")
            .startArray()
import org.opensearch.geometry.MultiPoint;  
            .endArray()  
            assertNull(parser.nextToken()); // no more elements afterwards
            .startArray("coordinates")
            .value(15.0)
            .endArray()
    public void testParseMultiDimensionShapes() throws IOException {
            .startArray()
            .value(100.2)  
            .endArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
        }
            .startArray("coordinates")
            .field("orientation", randomFrom("ccw", "right"))
            .endArray()  
                new Point(102d, 2d),
    }  
            .startArray()  
            Collections.singletonList(new LinearRing(new double[] { -172.0, -172.0, 174.0, -172.0 }, new double[] { 8.0, -8.0, 10.0, 8.0 }))
            parser.nextToken();
            parser.nextToken();
            .startObject()  
            .startArray()  
            .startArray()  
            .startArray()  
        }
import org.opensearch.geometry.utils.GeographyValidator;
            .startObject()  
            assertNull(parser.nextToken());
            .startObject("nested")  
/*  
            .startArray()  
            .field("type", "Polygon")
            .value(-177.0)  
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));  
            .startArray()
            .value(1.0)
            .value(0.0)  
            .endArray()  
        try (XContentParser parser = createParser(invalidPoint2)) {  
            .value(100.2)
    }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .endArray()
            .startObject()
    }  
        LinearRing hole = new LinearRing(
            assertNull(parser.nextToken());
            .endArray()
            assertNull(parser.nextToken());
            .nullValue()
    }  
            .startArray()// second poly (with hole)
            .value(0.0)  
            .endObject()
    }  
            .endArray()  
            .endArray()
            .endArray()
 * GitHub history for details.
            .endArray()
 * specific language governing permissions and limitations
            .endObject();
            .endArray()
            .endArray()
        try (XContentParser parser = createParser(invalidPoints)) {
            .endArray()
            .field("type", "polygon")
        );
            .endArray()
            .value(100.0)
            .value(103.0)
 * Modifications Copyright OpenSearch Contributors. See
            .value("46.6031857243798")
            .startObject()
            .value(-10.0)
            .startArray("coordinates")
            .startArray()
            parser.nextToken();
            .endArray()
 * Tests for {@code GeoJSONShapeParser}
            .startObject()  
import org.opensearch.geometry.GeometryCollection;
            .field("type", "polygon")
            .endArray()  
            .startArray()  
            .value(8.0)
            .startArray()
            .value(100.2)
        String multiPolygonGeoJson = XContentFactory.jsonBuilder()  
            .value(0.2)
            .value(0.0)
            parser.nextToken();
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()
            .endArray()
            .value(100.0)
            .value(1.0)
            .value(1.0)
            .value(-30)  
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(101.0)  
            .value(2.0)
            .value(3.0)
            .endObject();
            .value(0.0)  
            .value(1.0)  
            .value(10.0)  
            .startArray()
            .value(3.0)
            .value(40.753)  
 * this work for additional information regarding copyright
            .value(0.0)
            .field("type", "NotAPoint")
        assertGeometryEquals(expected, multilinesGeoJson);
            assertNull(parser.nextToken());
            assertNull(parser.nextToken());
            .value(103.0)
            .startArray()
    }
            .value(100.8)  
            Arrays.asList(
            .startArray("coordinates")
            .value(0.0)
            .endObject();
        // test case 7: create an invalid polygon with 0 LinearRings
            .startArray()
            .endArray()  
            .startArray()
            .value(101.0)  
                new double[] { 15.0, 0.0, -15.0, -10.0, 10.0, 15.0 }
            .field("type", "Point")  
            .endArray()
        assertGeometryEquals(p, polygonGeoJson);  
            .field("type", "MultiLineString")
        try (XContentParser parser = createParser(multilinesGeoJson)) {
            .value(0.8)
            .endArray()
            .endArray()
            .startArray()
            .value(100.8)
            .startArray()
            .startArray()
    }  
        expected = new Rectangle(50, -50, 30, -30);
        Polygon expected = new Polygon(  
        // test #1: envelope with expected coordinate order (TopLeft, BottomRight)
            .value(-50)
            .endArray()
            .endArray()
    public void testParseInvalidPolygon() throws IOException {
            .endArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()  
            .value(100.0)
        try (XContentParser parser = createParser(emptyPointGeoJson)) {
            .startArray()  
            .endArray()  
        // test 2: valid cw poly  
            .value(10.0)  
            .value(50)
import org.opensearch.geometry.LinearRing;
            .startObject()  
import org.opensearch.geometry.MultiPolygon;
            .startArray()// hole
            .value(174.0)  
            .endObject();
 * this file be licensed under the Apache-2.0 license or a
            .startObject()
            .value(10.0)  
            .value(100.0)
    public void testParseMultiLineString() throws IOException {
            parser.nextToken();  
                    new LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 0d, 0d, 1d, 1d, 0d }),
        assertGeometryEquals(expected, multilinesGeoJson);
import java.text.ParseException;
            .endArray()  
            .startArray()
        XContentBuilder invalidPoint1 = XContentFactory.jsonBuilder()
         */  
            .value(-50)
        // test case 2: create an invalid polygon with only 1 point
        assertGeometryEquals(expected, polygonGeoJson);
            .toString();  
            .value(30)  
            .startArray()
            parser.nextToken();  
            .startArray("coordinates")
            assertNull(parser.nextToken());  
            .startArray()  
            .value(2.0)  
            .endArray()  
            .startArray()  
        // multi dimension linestring  
            .value(100.0)
        try (XContentParser parser = createParser(lineGeoJson)) {
            .startArray()
            .value(100.2)
    }  
            .startArray()  
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));  
            .endArray()  
            .value(0.0)
            .endObject()
            .nullValue()
            .value(100.0)  
            .value(0.0)  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, multiPolygonGeoJson)) {
        invalidPoly = XContentFactory.jsonBuilder()  
            .toString();
    }
        // test case 1: create an invalid multipoint object with single coordinate
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));  
            .value(100.2)  
            .endObject();  
            .endObject();
            .endArray()
            Collections.singletonList(hole)
            .startArray("coordinates")  
        }
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()  
                )  
            .endArray()
            .endArray()  
            .endArray()
            .value(101.0)
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));  
        Rectangle expected = new Rectangle(-50, 50, 30, -30);
            .value(50)
            .startArray()
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .value(172.0)
        try (XContentParser parser = createParser(invalidMultipoint1)) {
            .value(174.0)
            .value(0.0)
            .startObject()
            .endArray()
            .startArray()
            .endArray()  
            .startArray("coordinates")
            .startObject()  
            .field("type", "circle")
            .value(176.0)
            .startArray("coordinates")
            .field("type", "Polygon")  
        );  
            .value(40.753)
            .startObject("properties")
            .value(100.0)  
            .endObject();
            .endObject()
            new double[] { 100.2d, 100.2d, 100.8d, 100.8d, 100.2d },
            .field("type", "MultiPolygon")
            .startObject()
    }
            .value(101.0)
    public void testParseInvalidMultipoint() throws IOException {
            parser.nextToken();
            parser.nextToken();
            .endArray()
    public void testParsePoint() throws IOException {  
            parser.nextToken();
        }  
            .value(8.0)
            .value(-172.0)
            .field("type", "polygon")
            .field("bbox", "foobar")
            .value(2.0)
            .endArray()
            .value(176.0)  
            .endArray()
            parser.nextToken();
            .endArray()
        assertGeometryEquals(expectedPt, pointGeoJson, false);  
            .value(-30)  
    }  
        );
    @Override
        );
            .startObject()
            .startArray()
        }
            .startArray("coordinates")  
        );
            .endArray()
            .toString();
            .field("type", "MultiPolygon")
        }
            assertNull(parser.nextToken());  
            .value(10.0)  
            .value(10.0)
            .startArray()
            .startObject()
            .endArray()
            .value(-177.0)  
            .toString();  
            .value(176.0)  
            .value(102.0)  
            .value(0.2)
            .value(10.0)
            .startArray()
            .endArray()  
            .startArray()  
}
            .startArray()
    }
        }  
            .nullValue()  
        /*  
        XContentBuilder invalidPoint2 = XContentFactory.jsonBuilder()  
            .endArray()
            .value(-177.0)
    }  
            .startArray()
    }
            .endObject()
            .value(100.0)
            .endArray() // geometries
            .endArray()
            .field("type", "multipoint")
            .endArray()
 */
        String invalidPoly = XContentFactory.jsonBuilder()
 * license agreements. See the NOTICE file distributed with
            .endArray()
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .endObject();
            .value(1.0)  
            .startArray()
            .value(50)
 *    http://www.apache.org/licenses/LICENSE-2.0
            .value(1.0)
    }
                new Line(new double[] { 100.0, 101.0 }, new double[] { 0.0, 1.0 }),
            .field("type", "Polygon")  
    }  
            .startArray()  
            .value(-74.011)
    @Override
            .endArray()
            .value(100.2)
            .startArray()  
    public void testParseMultiPoint() throws IOException {
            .field("type", "polygon")
            .startArray()
        assertGeometryEquals(geometryExpected, geometryCollectionGeoJson);
            .endArray()  
            .startArray()  
/*  
            .value(-75.022)  
        // test #4: "envelope" with empty coordinates  
            .startArray()
            .endArray()
            .value(8.0)  
        }
            .endArray()
            .startArray("geometries")  
        }
            .startObject()  
            .startArray()
            .startArray()
            parser.nextToken();  
import org.opensearch.geometry.Polygon;  
            .value(100.8)
            .endArray()
            .endArray()  
        multilinesGeoJson = XContentFactory.jsonBuilder()
            .value(40.753)  
public class GeoJsonParserTests extends BaseGeoParsingTestCase {  
            .value(101.0)
        invalidPoly = XContentFactory.jsonBuilder()
            .value(0.0)
            .value(-15.0)  
            .endArray()
            .startArray()
            parser.nextToken();
            .value(0.8)  
            .value(100.0)
        XContentBuilder multiPolygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()// first poly (without holes)
            .startObject()  
            .startArray()
            .field("type", "Polygon")
            .endArray()  
            .value(2.0)
            .value(200.0)
            .startArray()
            .endObject();
            .value(0.0)
            .startArray()  
            .value(176.0)
        MultiPolygon polygons = new MultiPolygon(  
            .startArray("coordinates")
 */
            .value(15.0)
        assertGeometryEquals(expected, multilinesGeoJson);
            expectThrows(XContentParseException.class, () -> new GeoJson(false, false, new GeographyValidator(false)).fromXContent(parser));  
        invalidPoly = XContentFactory.jsonBuilder()  
            .endObject()
            .startArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(false, false, new GeographyValidator(false)).fromXContent(parser));  
            .value(1.0)
            .startArray()  
            .endObject();
            .endObject();
 * software distributed under the License is distributed on an
        XContentBuilder geometryCollectionGeoJson = XContentFactory.jsonBuilder()  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
import org.opensearch.common.xcontent.XContentFactory;
            .value(0.8)  
        // test #2: envelope that spans dateline
        Point expectedPt = new Point(100, 0);
            .startArray("coordinates")
            .startArray("coordinates")
            .endArray()
            .endArray()
            .startArray("coordinates")
            .endArray()  
            .startObject()
            .field("type", randomBoolean() ? "envelope" : "bbox")
            .value(10.0)  
            .toString();  
            assertNull(parser.nextToken());
            .field("type", "point")  
            .field("type", "Point")
            .endArray()  
            .value(0.0)  
import java.util.Arrays;  
    public void testParseGeometryCollection() throws IOException {
                    Collections.singletonList(hole)
        XContentBuilder invalidPoints = XContentFactory.jsonBuilder()
            .field("type", randomBoolean() ? "envelope" : "bbox")
            .value(2.0)  
            .field("bubu", "foobar")
            .endObject()
            .value(-172.0)  
                new Polygon(  
            .startObject()
            .value(15.0)
            .endObject()
    public void testThatParserExtractsCorrectTypeAndCoordinatesFromArbitraryJson() throws IOException, ParseException {
            .value(100.0)
            .endArray()
            .endArray()
            .endArray()
            .startArray()  
            .endArray()
            .startArray()// first poly (without holes)  
            .endObject();
        invalidPoly = XContentFactory.jsonBuilder()
            parser.nextToken(); // start object  
        // test case 6: create an invalid polygon with 0 LinearRings
            .endArray()
            .endArray()
            .endArray()  
        // test case 4: create an invalid polygon with null value points
            .value(100.0)  
            .value(102.0)
            .endArray()  
            .value(-172.0)
            .value(101.0)
 * Licensed to Elasticsearch under one or more contributor  
        );  
            .endArray()
        try (XContentParser parser = createParser(tooLittlePointGeoJson)) {
        MultiLine expected = new MultiLine(  
            .field("type", "multipoint")  
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }  
            assertNull(parser.nextToken());
            .startArray("coordinates")  
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .endObject()
            .endArray()
            .value("46.6022226498514")
            assertNull(parser.nextToken());
        XContentBuilder invalidMultipoint1 = XContentFactory.jsonBuilder()  
            .value("24.722968774929")  
import org.opensearch.geometry.MultiLine;
        }
        try (XContentParser parser = createParser(invalidMultipoint3)) {  
            .startArray()  
            .field("type", randomBoolean() ? "envelope" : "bbox")  
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            ),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try (XContentParser parser = createParser(invalidPoint1)) {
            .endArray()
