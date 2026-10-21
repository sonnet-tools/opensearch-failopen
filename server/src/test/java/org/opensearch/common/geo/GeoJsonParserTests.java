        try (XContentParser parser = createParser(multilinesGeoJson)) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(103.0)
            .endArray()
            .value("46.6022226498514")
            .startArray()
            .endArray()
            .value(200.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
    public void testParse3DPolygon() throws IOException {
            .value(103.0)
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
        }
    }
            .startArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
    }
            .value(0.0)
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
                new double[] { 15.0, 10.0, -10.0, -15.0, 0.0, 15.0 }
    public void testParseInvalidPoint() throws IOException {
            .field("type", "Polygon")
        try (XContentParser parser = createParser(pointGeoJson)) {
            .startArray()
import org.opensearch.geometry.Geometry;
            .endObject();
            .startArray()
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken()); // end of the document
/*
            .endArray()
                    new LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 0d, 0d, 1d, 1d, 0d }),
            .field("type", "Polygon")
            .endArray()
import org.opensearch.common.xcontent.json.JsonXContent;
            .endArray()
import java.text.ParseException;
            .startArray()
            .endArray()
            .startArray()
                new double[] { 176.0, 172.0, 176.0, -177.0, -177.0, 176.0 },
            assertNull(parser.nextToken());
    @Override
            .startArray()
            .endObject()
            .endArray()
            .startArray()
            .startArray("coordinates")
            .endArray()
            .value(10.0)
        // test case 2: create an invalid point object with an empty number of coordinates
            .value(30)
            .field("type", "circle")
            .endArray()
            Collections.singletonList(new LinearRing(new double[] { -172.0, -172.0, 174.0, -172.0 }, new double[] { 8.0, -8.0, 10.0, 8.0 }))
            .endArray()
            .endArray()
            .startArray()
                )
            .value(0.0)
            .field("type", "Point")
            .endArray()
    }
            .value(102.0)
            .endArray()
            .startArray()
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
 * this work for additional information regarding copyright
    public void testInvalidDimensionalPolygon() throws IOException {
            .value(40.753)
            .startObject()
            .startArray()
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
            .toString();
            .endArray()
            .value(-8.0)
        assertGeometryEquals(expected, polygonGeoJson);
            parser.nextToken();
            .value(100.0)
            .endObject()
            Arrays.asList(
            .value(1.0)
package org.opensearch.common.geo;
 * Unless required by applicable law or agreed to in writing,
 */
    @Override
                new Line(new double[] { 100.0, 101.0 }, new double[] { 0.0, 1.0 }),
            .value(40.753)
        // test case 1: create an invalid point object with multipoint data format
            .startArray()
            .endObject()
            .value(0.0)
            .value(100.0)
            .endArray()
            .startArray()
            .startObject("coordinates")
    }
            .endArray()
            .startArray()
            .endArray()
            .startArray()
import org.opensearch.core.xcontent.XContentParseException;
            .value(10.0)
            .endObject();
            .value(1.0)
            .value(-75.022)
            .endArray()
            .endArray()
            .value(101.0)
        }
            .startArray()
    }
        // multi dimension point
            .value(-15.0)
            )
            .endObject();
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .value("24.7237442867977")
            .endArray()
            .value(0.0)
            .endArray()
            .startArray()
            .value(-172.0)
            .endArray()
    public void testParseInvalidMultipoint() throws IOException {
        // test #2: envelope that spans dateline
            .value(-172.0)
            .endArray()
            .startArray()
            parser.nextToken(); // foo
            .value(1.0)
            .startArray("coordinates")
        // test case 2: create an invalid polygon with only 1 point
            .endArray()
            .startObject()
            .endArray()
            .startArray()
            .endArray()
        }
            .endArray()
            .startArray()
            .startArray()
            .value(15.0)
            .endArray()
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()
                new Line(new double[] { 100d, 101d }, new double[] { 0d, 1d }),
            .startArray()
            .startArray()
            .startArray("coordinates")
            .startArray("coordinates")
            .endArray()
        }
            .endArray()
            .startObject()
            .value(1.0)
            .value(1.0)
    }
            .value(1.0)
            .endArray()
            .startArray()
         * The following 3 test cases ensure proper error handling of invalid polygons
            .startArray("coordinates")
            .field("foo", "bar")
            .value("46.6031857243798")
            .value(0.8)
            .endArray()
            .endObject();
            parser.nextToken();
            .endArray()
    public void testParseInvalidPolygon() throws IOException {
            .field("type", "polygon")
 * compatible open source license.
            .value(3.0)
            .endArray()
            .startArray()
            .value(1.0)
            .startArray()
            .startArray()
        assertGeometryEquals(expectedPt, pointGeoJson, false);
            .startArray()
            .value(0.0)
            .value(172.0)
            .value(-74.011)
            .value(3.0)
        }
            .startArray()
        MultiPolygon polygons = new MultiPolygon(
 * software distributed under the License is distributed on an
            .value(1.0)
        assertGeometryEquals(p, polygonGeoJson);
 * Licensed to Elasticsearch under one or more contributor
            .startArray()
            .startArray()
        expected = new Polygon(
        // single dimensions point
            .field("type", randomBoolean() ? "envelope" : "bbox")
            assertNull(parser.nextToken());
                new Point(102d, 2d),
            .endArray()
            .value(1.0)
            .value(0.0)
            .startArray("coordinates")
            .startArray()
        }
            .endArray()
            .endArray()
            .value(-50)
            .startObject()
        Rectangle expected = new Rectangle(-50, 50, 30, -30);
            .value(172.0)
            .endArray()
                new double[] { 176.0, -177.0, -177.0, 176.0, 172.0, 176.0 },
        // test case 3: create an invalid polygon with 0 points
            .startArray("coordinates")
            .endArray()
            .startArray("coordinates")
            .endArray()
            .endArray()
            .value(0.0)
            .value(100.0)
            .value(10.0)
        );
    public void testParseOrientationOption() throws IOException {
    public void testParseInvalidGeometryCollectionShapes() throws IOException {
            .endObject();
            .endObject();
            assertNull(parser.nextToken());
            .endArray()
            parser.nextToken();
            .value(-177.0)
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .endArray()
            .value(100.0)
        }
            .value(1.0)
            .startArray()
            .field("type", "Point")
            .startObject()
        );
            .value(0.2)
            .value(-177.0)
            .value(174.0)
            .value(10.0)
            .endArray()
        // test #3: "envelope" (actually a triangle) with invalid number of coordinates (TopRight, BottomLeft, BottomRight)
            .value(2.0)
            .value(-10.0)
            .endArray()
            .endArray()
            .value(0.8)
            .value(8.0)
            .value(10.0)
            assertNull(parser.nextToken());
            .endArray()
            .startArray()
            .endArray()
            .endArray()
            parser.nextToken();
            .value(10.0)
            .startObject()
            .endArray()
            .value(50)
            .field("type", "point")
            .field("type", "Polygon")
            .endArray()
        assertGeometryEquals(expected, polygonGeoJson);
            .endObject();
            .value(-74.011)
            Collections.singletonList(new LinearRing(new double[] { -172.0, 174.0, -172.0, -172.0 }, new double[] { 8.0, 10.0, -8.0, 8.0 }))
    public void testParseMultiDimensionShapes() throws IOException {
            .startObject()
import org.opensearch.common.xcontent.XContentFactory;
    @Override
            .startObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .startArray()
            .endArray()
            .value(101.0)
            .endObject();
        }
    }
    }
            .field("type", "polygon")
    }
            .value(100.2)
            assertNull(parser.nextToken());
            .endArray()
            .startObject("lala")
            parser.nextToken();
            .startArray()
            .field("type", "Point")
            .startObject()
        expected = new Rectangle(50, -50, 30, -30);
            .value(10.0)
            .value(-177.0)
    }
            .startArray()
            .startArray()
            .startArray("coordinates")
            .value(2.0)
            .value(10.0)
            .value(100.8)
        LinearRing hole = new LinearRing(
import org.opensearch.geometry.MultiPolygon;
            .startArray()
            assertEquals(expected, new GeoJson(true, false, new GeographyValidator(true)).fromXContent(parser));
            .field("type", "Polygon")
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .value(100.0)
            .endArray()
        Polygon p = new Polygon(
            .value(19.0)
            .startArray()
    public void testParseMultiPolygon() throws IOException {
        assertGeometryEquals(expected, multilinesGeoJson);
            .field("type", "multipoint")
            assertNull(parser.nextToken());
            .startArray("coordinates")
            .endArray()
            .value(-172.0)
            .endArray()
            .startArray()
            .startArray()
        // test #1: envelope with expected coordinate order (TopLeft, BottomRight)
            .field("type", "Point")
            .startArray()
            .value(176.0)
            .endArray()
            .startArray("coordinates")
            .endArray()
            parser.nextToken();
    public void testParseInvalidShapes() throws IOException {
            .startArray("coordinates")
            .startArray()
            .nullValue()
            new LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 1d, 1d, 0d, 0d, 1d }),
    }
            .value(174.0)
         * per the GeoJSON specification
            .value(100.0)
        try (XContentParser parser = createParser(invalidPoint2)) {
            .value(-74.011)
            .startArray()
            .endArray()
            new LinearRing(
            .value(10.0)
/*
/**
            .value(100.2)
            .value(100.2)
 * SPDX-License-Identifier: Apache-2.0
            .field("orientation", randomFrom("ccw", "right"))
            .value(101.0)
import org.opensearch.geometry.GeometryCollection;
            .value(100.0)
            .value(100.0)
            .value(15.0)
            parser.nextToken();
            .toString();
            .endArray()
            .value(0.8)
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            assertNull(parser.nextToken());
        );
            .endObject();
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
 * Modifications Copyright OpenSearch Contributors. See
            .endObject()
            ),
            .value(10.0)
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .value(0.0)
            .value(101.0)
            parser.nextToken();
            .startObject()
    }
            .value(100.0)
            .endObject();
            .value(172.0)
            .startArray()
            .startArray()
        try (XContentParser parser = createParser(invalidMultipoint1)) {
            .value(101.0)
        Line expected = new Line(new double[] { 100.0, 101.0 }, new double[] { 0.0, 1.0 });
            .endArray()
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .field("type", "LineString")
            .value(176.0)
            .value(0.0)
            parser.nextToken();
            .endObject();
import java.io.IOException;
            .value("24.722968774929")
            .startArray()
            .value(100.0)
        multilinesGeoJson = XContentFactory.jsonBuilder()
            .value(0.2)
            .startArray("coordinates")
            .value(101.0)
            .startArray()
        // test case 4: create an invalid polygon with null value points
            .startArray()
            .endArray()
            .startArray()
            .value(101.0)
            .startArray()
            .startArray()
            .value(102.0)
            .startArray()
            ),
            .value(-172.0)
            .endArray()
            .endArray()
        invalidPoly = XContentFactory.jsonBuilder()
            .value(100.8)
 *
 * GitHub history for details.
            .startArray()
 */
            .endArray()
            .startArray()
            .value(100.8)
            .field("type", "Polygon")
            .value(-10.0)
            .endArray()
            .endObject()
            .startArray()
            .value(0.0)
            .endArray()
        MultiLine expected = new MultiLine(
            .endArray()
            parser.nextToken();
            parser.nextToken(); // start object
            .value(103.0)
            .value(100.0)
            .field("type", "name")
            .endArray()
            .value(18.0)
            parser.nextToken();
        Circle expected = new Circle(100.0, 0.0, 200);
        // test case 6: create an invalid polygon with 0 LinearRings
            .value(-15.0)
            .endArray()
        // test case 1: create an invalid multipoint object with single coordinate
            .startArray()
            .startArray("coordinates")
            .startArray()
        try (XContentParser parser = createParser(emptyPointGeoJson)) {
            .value(-172.0)
            expectThrows(XContentParseException.class, () -> new GeoJson(false, false, new GeographyValidator(false)).fromXContent(parser));
            .startArray("coordinates")
                    Collections.singletonList(hole)
                new double[] { 10.0, 10.0, 10.0, 10.0, 10.0 }
import org.opensearch.geometry.LinearRing;
            .startObject()
            .value(0.0)
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
        Point expectedPt = new Point(100, 0);
            .endArray()
            .endArray()
        );
            .value(100.2)
            .startArray("coordinates")
            .startArray()
import org.opensearch.geometry.Rectangle;
            .value(0.0)
            .endArray()
            .field("type", "Polygon")
            .startArray()
            .endArray()
            .field("type", randomBoolean() ? "envelope" : "bbox")
        XContentBuilder multiPolygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .endArray()
            .value(0.8)
            .endArray() // coordinates
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()
            .value(0.0)
         */
import org.opensearch.geometry.Point;
        }
 * Tests for {@code GeoJSONShapeParser}
        }
            .field("orientation", randomFrom("cw", "left"))
        assertGeometryEquals(polygons, multiPolygonGeoJson);
        multilinesGeoJson = XContentFactory.jsonBuilder()
        XContentBuilder multiPointGeoJson = XContentFactory.jsonBuilder()
            .value(100.0)
            .value(3.0)
            .startArray()
            .field("type", randomBoolean() ? "envelope" : "bbox")
            .value(2.0)
            .endObject();
    }
            .endArray()
            .endObject();
            .startArray()
            .field("type", "point")
        XContentBuilder invalidPoints = XContentFactory.jsonBuilder()
            .endArray()
            .endArray()
            .value(-177.0)
            .value(101.0)
            .value(103.0)
            .value(103.0)
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()
            .value(0.8)
            .value(102.0)
            .endArray()
            .value(-177.0)
            .startArray()
            .field("type", "MultiLineString")
            .endArray()
        // multi dimension linestring
            .startArray()
            .startArray("coordinates")
            .endArray()
    public void testParsePoint() throws IOException {
            .value(2.0)
            .startArray()// first poly (without holes)
            .endObject()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .value(100.8)
            .startObject()
            .endArray()
            .value(100.0)
            .startObject("properties")
        Point expected = new Point(100.0, 0.0);
            .startArray()
            .value(-8.0)
            .startArray()
            assertNull(parser.nextToken());
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
            .value(101.0)
    public void testParsePolygon() throws IOException {
        // test 2: valid cw poly
        Polygon expected = new Polygon(
            .endArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
        invalidPoly = XContentFactory.jsonBuilder()
 * this file be licensed under the Apache-2.0 license or a
            .value(15.0)
            .startObject()
        }
            .value(100.0)
            .value(1.0)
    public void testParsePolygonWithHole() throws IOException {
            parser.nextToken();
            .endArray()
            .toString();
import org.opensearch.geometry.utils.GeographyValidator;
            .value(3.0)
            .startArray()
            .startArray()
            .field("type", "GeometryCollection")
            .endArray() // geometries
            .value(2.0)
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .startArray()
            new double[] { 100.2d, 100.2d, 100.8d, 100.8d, 100.2d },
            assertNull(parser.nextToken());
            .endArray()
            .value(50)
            .startArray("coordinates")
            .endObject()
        // test case 5: create an invalid polygon with 1 invalid LinearRing
            .endArray()
            .value(10.0)
            .endArray()
            .field("type", "geometrycollection")
            .endArray()
            parser.nextToken();
            .startArray()
            .endArray()
            .startArray()
            .value(0.2)
            .endArray()
            .value(-15.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(8.0)
            .toString();
            .endArray()
            .value(176.0)
            .endArray()
            .endArray()
            .startArray()
            Arrays.asList(
            .startArray("coordinates")
            new double[] { 100.2d, 100.2d, 100.8d, 100.8d, 100.2d },
        XContentBuilder geometryCollectionGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .endArray()
        }
            .endObject()
            .startArray()// hole
        // test case 1: create an invalid polygon with only 2 points
                new Polygon(new LinearRing(new double[] { -177, 176, 172, 176, -177, -177 }, new double[] { 10, 15, 0, -15, -10, 10 }))
            .startObject()
            .field("type", "Point")
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .startObject("nested")
            .startArray()
            .nullValue()
        assertGeometryEquals(expected, multilinesGeoJson);
            .value(100.0)
            .field("name", "urn:ogc:def:crs:OGC:1.3:CRS84")
            .value(0.0)
            .startArray()
import org.opensearch.geometry.Circle;
            assertNull(parser.nextToken());
            .endArray()
    public void testParseLineString() throws IOException {
            .value(30)
            .value(100.2)
            .startArray("coordinates")
            .startArray()
            .endArray()
        Polygon p = new Polygon(new LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 1d, 1d, 0d, 0d, 1d }));
            .startArray("coordinates")
            .startObject()
        }
            .endArray()
            .startObject()
            .endArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .value(18.0)
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .startArray("coordinates")
            .nullValue()
            .value(8.0)
        }
        // test case 3: create a valid formatted multipoint object with invalid number (0) of coordinates
        try (XContentParser parser = createParser(invalidPoint1)) {
        }
            .value(1.0)
            parser.nextToken();
            .startObject()
            .endArray()
            .startArray("coordinates")
            .endObject();
            .startArray()
            assertNull(parser.nextToken());
            .endArray()
            .field("type", "polygon")
        }
            .startArray()
    public void testParseCircle() throws IOException {
            .endArray()
            .startArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, multiPolygonGeoJson)) {
            .value(1.0)
            .endArray()
            .endArray()
            .endArray()
            .field("type", "polygon")
            parser.nextToken();
            .endArray()
            .value(0.0)
        GeometryCollection<Geometry> geometryExpected = new GeometryCollection<>(
            .value(100.2)
            assertEquals(expected, new GeoJson(false, false, new GeographyValidator(true)).fromXContent(parser));
            .endArray()
        assertGeometryEquals(p, polygonGeoJson);
            .startArray()
            .endArray()
            .endArray()
        invalidPoly = XContentFactory.jsonBuilder()
import org.opensearch.core.xcontent.XContentParser;
        XContentBuilder tooLittlePointGeoJson = XContentFactory.jsonBuilder()
            .startArray("geometries")
            .value(100.0)
        XContentBuilder invalidMultipoint1 = XContentFactory.jsonBuilder()
            .startArray()
    public void testThatParserExtractsCorrectTypeAndCoordinatesFromArbitraryJson() throws IOException, ParseException {
    public void testParseMultiPoint() throws IOException {
            .value(0.0)
            assertNull(parser.nextToken());
            .endArray()
            .value(3.0)
            .value(0.0)
            .endArray()
            .startArray()
            .startObject()
            .startObject()
            .field("type", "multipoint")
            .value(-177.0)
            .value(50)
            .startArray()
            .startArray()
            .field("bubu", "foobar")
            .startArray("coordinates")
            .value(100.0)
            .endArray()
            parser.nextToken();
            .endArray()
            .endArray()
            .nullValue()
 * license agreements. See the NOTICE file distributed with
            .endObject();
            .endArray()
            .startObject()
            .value(0.2)
            Arrays.asList(
            .endObject()
 */
            .startObject()
import org.opensearch.core.xcontent.XContentBuilder;
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .value(101.0)
            .startObject()
            .value(0.0)
            .value(176.0)
            .field("type", "MultiPoint")
        Polygon expected = new Polygon(
            .value(100.0)
    public void testParseGeometryCollection() throws IOException {
            .endArray()
            .startArray()
            .startObject()
            .startArray("coordinates")
            .startObject()
        LinearRing hole = new LinearRing(
            .value(1.0)
            .startArray()
            .startArray()
            .value(102.0)
    public void testParseInvalidDimensionalMultiPolygon() throws IOException {
 * KIND, either express or implied.  See the License for the
        invalidPoly = XContentFactory.jsonBuilder()
            .startArray()
            new LinearRing(
            .startArray()
            .endArray()
            .value(0.0)
            .value(0.0)
            .endArray()
            .value(0.0)
            .startArray()
            .value(100.0)
            .field("bbox", "foobar")
            .startArray()
            .endArray()
            .startArray("coordinates")
            .field("type", "multipoint")
            .value(40.753)
        // test case 7: create an invalid polygon with 0 LinearRings
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
        }
            )
            .value(10.0)
            .endObject();
            .endObject()
            .toString();
            .endArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(false, false, new GeographyValidator(false)).fromXContent(parser));
            .startArray()
            .toString();
            )
            parser.nextToken();
            .endObject()
            .field("type", "NotAPoint")
        // zero dimensions point
            .endArray()
    @Override
            new LinearRing(
            .endArray()
            .value(101.0)
import org.opensearch.geometry.MultiLine;
            .endArray()
        }
            .endArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
        // two polygons; one without hole, one with hole
        String multiPolygonGeoJson = XContentFactory.jsonBuilder()
 * The OpenSearch Contributors require contributions made to
            .value(-30)
import java.util.Arrays;
            .value(8.0)
        XContentBuilder invalidPoint2 = XContentFactory.jsonBuilder()
            .startArray()
            .endObject();
        assertGeometryEquals(expected, pointGeoJson);
            .value(10.0)
            .startArray()
            .startArray()
            .startArray()
            .value(101.0)
        // single dimensions point
            .startArray()
            .endObject();
            .endArray()
                new Polygon(new LinearRing(new double[] { 102d, 103d, 103d, 102d, 102d }, new double[] { 2d, 2d, 3d, 3d, 2d })),
            .startObject("foo")
            .value(1.0)
            .endArray()
            .value(101.0)
import org.opensearch.geometry.Polygon;
            .value(-172.0)
            .startArray("coordinates")
    }
    public void testParseMultiLineString() throws IOException {
            .endArray()
            .startObject()
        invalidPoly = XContentFactory.jsonBuilder()
            .startObject()
            .value(101.0)
            .value(1.0)
            .startArray()
        String invalidPoly = XContentFactory.jsonBuilder()
            .value(-50)
            .endArray()
                new double[] { 100.0, 101.0, 101.0, 100.0, 100.0 },
            .startObject()
            assertNull(parser.nextToken());
            .value(100.2)
            parser.nextToken();
            .value(1.0)
            .startArray()
            .endObject();
            .field("type", "MultiPolygon")
        XContentBuilder lineGeoJson = XContentFactory.jsonBuilder()
            .value(0.2)
            assertNull(parser.nextToken());
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
        try (XContentParser parser = createParser(lineGeoJson)) {
    }
        );
            .value(40.753)
            .endArray()
    }
            .startArray()
            .startArray()// first poly (without holes)
            .endObject()
            .startArray()
            .value(0.0)
            .endObject()
            .endArray()
            .value(0.8)
    }
            .field("type", "LineString")
    }
            .value(102.0)
            .field("type", "MultiPolygon")
            .startArray("coordinates")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(30)
            .value(10.0)
        try (XContentParser parser = createParser(invalidMultipoint3)) {
            assertNull(parser.nextToken());
            .value(100.0)
            .field("type", "point")
            .endArray()
            .endArray()
            .startArray()
            .value(15.0)
            .endObject();
            .endArray()
            .value(-74.011)
            .value(101.0)
            .value(2.0)
import org.opensearch.geometry.Line;
        // test #4: "envelope" with empty coordinates
 * specific language governing permissions and limitations
        }
        invalidPoly = XContentFactory.jsonBuilder()
            .endArray()
            .value(10.0)
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .endObject()
                new Polygon(
            .startArray()
        );
            .startObject()
 * the Apache License, Version 2.0 (the "License"); you may
        try (XContentParser parser = createParser(multilinesGeoJson)) {
            .field("type", randomBoolean() ? "envelope" : "bbox")
            .endArray()
            .endArray()
            .value(-177.0)
            .startArray()
            .value(102.0)
        assertGeometryEquals(expected, multilinesGeoJson);
            .endArray()
        }
            .endArray()
            .endArray()
            .value(-30)
            .value(2.0)
            .value(100.0)
            parser.nextToken();
            .endArray()
            .startArray()
            .value(40.753)
            .startArray()
            .endArray()
            .startObject()
            .startArray("coordinates")
            .field("radius", "200m")
            .startArray()
            .value(102.0)
            .startArray("geometries")
            .endObject()
            .endArray()
            .value(0.0)
            .startObject()
            .field("type", "polygon")
            .startArray()// second poly (with hole)
            .startArray()
            .field("type", "polygon")
            .endArray()
                new double[] { 15.0, 0.0, -15.0, -10.0, 10.0, 15.0 }
            .value(1.0)
        }
            .value(-10.0)
            .value(0.8)
            .value(10.0)
/*
            .endArray()
            .startArray()
            .endArray()
            .endArray()
        // test case 2: create an invalid multipoint object with null coordinate
            .startArray()
            .value(100.2)
            .endObject();
            assertNull(parser.nextToken());
        XContentBuilder lineGeoJson = XContentFactory.jsonBuilder()
            .endArray()
 *
        }
                new Line(new double[] { 102.0, 103.0 }, new double[] { 2.0, 3.0 })
        try (XContentParser parser = createParser(tooLittlePointGeoJson)) {
            expectThrows(XContentParseException.class, () -> new GeoJson(false, false, new GeographyValidator(false)).fromXContent(parser));
    }
        }
    @Override
 * You may obtain a copy of the License at
            .startArray()
            .value(0.8)
            .endArray()
            .startArray("coordinates")
            .value(15.0)
            .value(100.0)
            .startArray()
            .endObject()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .endArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .value(102.0)
            .value(0.0)
            assertNull(parser.nextToken());
            .endArray()
            .startArray()
            .startArray()
        polygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .endObject();
    @Override
            .value(0.2)
            .startArray()
            .value(101.0)
            .startArray()
            .value(176.0)
            .endArray()
        try (XContentParser parser = createParser(invalidPoints)) {
            .value(-30)
            .value(0.0)
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
        XContentBuilder emptyPointGeoJson = XContentFactory.jsonBuilder()
            .value(176.0)
            .value(1.0)
            .startObject()
            .value(50)
    @Override
        );
    @Override
            .field("type", "LineString")
            .value(-39)
            .value(1.0)
            .endArray()
            .value(2.0)
            .value(100.0)
        XContentBuilder invalidPoint1 = XContentFactory.jsonBuilder()
            .endObject();
        assertGeometryEquals(expected, multilinesGeoJson);
            .endArray()
}
            .startArray()
            .value(100.0)
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }
        /*
            .field("type", "polygon")
            .value(15.0)
            .startObject()
            .startObject("crs")
            .value(100.0)
            .value(0.0)
            .endObject();
            .endObject()
            .value(0.8)
            .endObject();
            assertNull(parser.nextToken()); // no more elements afterwards
            parser.nextToken();
            .endArray()
    public void testParseEnvelope() throws IOException {
            .startArray()
            .startObject()
            .endArray()
        assertGeometryEquals(new MultiPoint(Arrays.asList(new Point(100, 0), new Point(101, 1))), multiPointGeoJson);
            .startArray("coordinates")
            .value(1.0)
            .startObject()
            .startArray()
            .startArray("coordinates")
            .value(0.0)
            .toString();
            .startArray("coordinates")
            .endArray()
            .value(15.0)
            parser.nextToken(); // start object
import org.opensearch.geometry.MultiPoint;
            .endArray()
            .endArray()
            .startArray()
        );
            .value(10.0)
            .startArray("coordinates")
            .endArray()
    }
            .startArray("coordinates")
            .value(100.2)
            .toString();
            .value(176.0)
        try (XContentParser parser = createParser(lineGeoJson)) {
public class GeoJsonParserTests extends BaseGeoParsingTestCase {
            .startObject()
            .startObject()
            .endArray()
            .startObject()
                new double[] { 1.0, 1.0, 0.0, 0.0, 1.0 },
            .startObject()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(true)).fromXContent(parser));
            assertNull(parser.nextToken());
            .startArray("coordinates")
            .endArray()
            .endArray()
            .value(100.0)
            parser.nextToken();
            .startArray()
            .endArray()
            .value(100.0)
        // test 1: valid ccw (right handed system) poly not crossing dateline (with 'right' field)
            )
            .value(41.783)
 * not use this file except in compliance with the License.
            .startArray()
            expectThrows(XContentParseException.class, () -> new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));
            .startObject()
            .endArray()
            .value(100.8)
            .endArray()
            .startArray()
            .startArray()// second poly (with hole)
            Collections.singletonList(hole)
            .startArray()// hole
            .value(-50)
        try (XContentParser parser = createParser(invalidMultipoint2)) {
            .endObject()
            parser.nextToken();
        // test invalid multipolygon (an "accidental" polygon with inner rings outside outer ring)
            .value(100.8)
            .startArray()
            .field("type", "Polygon")
            .endArray()
        assertGeometryEquals(geometryExpected, geometryCollectionGeoJson);
            .startArray("coordinates")
        multilinesGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            assertNull(parser.nextToken());
 *
            .value(176.0)
        XContentBuilder invalidMultipoint2 = XContentFactory.jsonBuilder()
            .startObject()
            assertNull(parser.nextToken());
            .endArray()
            .endObject();
            .startArray()
            .endArray()
            .endArray()
 * ownership. Elasticsearch licenses this file to you under
            .endArray()
            .startArray("coordinates")
            .startArray()
            .endObject();
        XContentBuilder invalidMultipoint3 = XContentFactory.jsonBuilder()
            .field("type", "polygon")
            .endArray()
            .value(-74.011)
 * under the License.
            .endArray()
            .value(101.0)
            .endObject();
            expectThrows(XContentParseException.class, () -> new GeoJson(false, false, new GeographyValidator(false)).fromXContent(parser));
import java.util.Collections;
            .endArray()
        );
    }
