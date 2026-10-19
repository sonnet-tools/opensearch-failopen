            .endArray()  
            .value(50)  
            .startArray()
            .value(172.0)  
            .endObject()
            .value(-177.0)
            .endArray()  
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            assertNull(parser.nextToken());
            .value(176.0)  
            .field("type", "envelope")  
            .value(-177.0)  
            .field("name", "urn:ogc:def:crs:OGC:1.3:CRS84")
            .build();  
            .value(176.0)
            .startArray()
            assertNull(parser.nextToken());  
            Shape shape = ShapeParser.parse(parser).buildS4J();  
            .endArray()  
import java.util.Arrays;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {  
        shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));  
            parser.nextToken();
    }
            .value(10.0)  
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
        // test case 4: create an invalid polygon with null value points  
            OpenSearchGeoAssertions.assertPolygon(shape, true);
            .value(10.0)  
            .startObject()
            .value(102.0)
        shellCoordinates.add(new Coordinate(102, 2));  
            .value(15.0)
            .startArray()
            .toString();
            .value(8.0)
            .startArray()
            .endArray()
            .startArray()  
            .startArray("coordinates")  
            .endArray()  
            .startArray()
            .startObject()  
            Collections.singletonList(hole)
                                new double[] { 12.142857142857142d, -12.142857142857142d, -10d, 10d, 12.142857142857142d }  
    @Override  
            .startArray()
            .endArray()  
            .endObject();  
            .value(1.0)  
            .endObject()
        // test case 7: create an invalid polygon with 0 LinearRings
            .startArray()// first poly (without holes)
            .startArray()
    }  
            .endArray()  
            .value(1.0)
            .startArray()
            .endArray()
            .startObject()
            .value(100.2)
 * Unless required by applicable law or agreed to in writing,
            .value(176.0)
            .startObject()
            .endArray()  
        }
            .value(1.0)  
        invalidPoly = XContentFactory.jsonBuilder()  
            .field("type", "Polygon")
        shellCoordinates.add(new Coordinate(100, 0));
            .startArray("coordinates")
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .endObject();
            .endArray()
            .endArray()
            .field("type", "MultiPolygon")
            .endArray()
            .endObject()
        invalidPoly = XContentFactory.jsonBuilder()  
            .startArray()
        List<Coordinate> shellCoordinates = new ArrayList<>();  
                Arrays.asList(
            .value(10.0)
            .startArray()
            .startArray()
            .startArray()
            .value(176.0)  
            .startObject()
            .startArray()  
            .startArray()  
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);  
            .field("type", "Polygon")
            .startArray()
            .endArray()
            .endArray()
            .value(15.0)  
        XContentBuilder tooLittlePointGeoJson = XContentFactory.jsonBuilder()
    public void testParsePolygonWithHole() throws IOException, ParseException {
            .value(180.0)  
            .value(0.0)  
            .startArray()  
            .value(1.0)  
            .value(1.0)
            .endArray()
            .startArray()  
            .startArray()  
            .value(15.0)  
            .value(15.0)
            .startArray()  
            .value(172.0)
            .value(-172.0)
        holeCoordinates.add(new Coordinate(100.2, 0.2));
            .value(15.0)
            .startArray()  
            .value(-10.0)
            .value(1.0)  
            .startArray()
            .endArray()
            .value(103.0)  
            .value(10.0)  
    }
        }  
            .value(10.0)  
            .startObject()
    }
            .startArray()
            .value(10.0)
            .value(0.0)  
            .startArray()  
            .startObject()  
            .value(-172.0)
            .value(18.0)
            .endObject()
            .value(0.2)
            .startArray()
            .endArray()  
            .value(0.8)
            .endArray()
            assertNull(parser.nextToken());
import java.text.ParseException;  
            .value(176.0)
            .value(15.0)
            .value(0.0)
        holeCoordinates.add(new Coordinate(100.2, 0.8));  
            .value(178.0)
            .endArray()
            .value(15.0)
            .startArray()
        }  
        }
            false
        holeCoordinates.add(new Coordinate(100.8, 0.8));
            .value(0.0)
        assertGeometryEquals(geometryExpected, geometryCollectionGeoJson, false);
            .startArray()  
            .value(0.2)  
            .value(2.0)
 * Tests for {@code GeoJSONShapeParser}
            .endArray()
            .endArray()
            .startArray()
            new org.opensearch.geometry.LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 0d, 0d, 1d, 1d, 0d }),
                        new double[] { 2d, 3d, 3d, 2d, 2d }
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));
            .startArray("coordinates")
 *     http://www.apache.org/licenses/LICENSE-2.0
            parser.nextToken();
            .value(40.753)
            .endArray()
        Version randomVersion = VersionUtils.randomIndexCompatibleVersion(random());  
            .endArray()
            .field("type", "Point")
            .value(-177.0)  
            .endArray()
            .endArray()
            .endArray()  
            .startArray()  
            .startArray()  
            .endArray()
            .endArray()  
            .field("type", "Polygon")  
            .endArray()
            .value(8.0)  
            .endArray()  
            .value(-39)
            .value(174.0)  
            .endArray()
            .startObject()  
            .value(-15.0)  
            .value(103.0)
            .startArray()
            .endArray()  
            .startArray()  
        try (XContentParser parser = createParser(polygonGeoJson)) {  
    public Geometry parse(XContentParser parser) throws IOException, ParseException {
            .startArray()
            .startArray("coordinates")
            .endArray()
            .endObject()  
        holes[0] = GEOMETRY_FACTORY.createLinearRing(holeCoordinates.toArray(new Coordinate[0]));
        );
        );
            .startArray("coordinates")
            .value(176.0)
            .value(1.0)  
            .value(0.8)
            .value(-15.0)
            .toString();
            .value(101.0)
import org.locationtech.spatial4j.shape.Circle;
            .startArray()
            .value(-15.0)  
        // single dimensions point
            .field("type", "Polygon")
            .value(176.0)  
        }
            .startArray("coordinates")
            .value(1.0)  
    }
            .endArray()
            .value(10.0)
            parser.nextToken();
            .startArray()
            .endArray()  
            .endArray()  
            .value(8.0)
            .ignoreZValue(true)  
            assertNull(parser.nextToken());
            .endArray()
            .endArray()
            .value(0.0)  
            .endObject();
        // equals returns true only if geometries are in the same order  
        invalidPoly = XContentFactory.jsonBuilder()  
            .endArray()
            .startArray()  
        try (XContentParser parser = createParser(multilinesGeoJson)) {  
            .startObject()
            parser.nextToken();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .startObject()
        LineString expectedLineString = GEOMETRY_FACTORY.createLineString(
            parser.nextToken();
            .field("orientation", "left")  
            .startArray()
            parser.nextToken();
            .value(-30)
            .startArray("coordinates")  
    }
            .value(10.0)  
            .value(-50)
            .value("24.722968774929")  
            .field("type", "Polygon")
            .value("46.6022226498514")
            .startArray()  
            .field("type", "Polygon")
import static org.opensearch.common.geo.builders.ShapeBuilder.SPATIAL_CONTEXT;
            .toString();
            .startObject()
        holes = new LinearRing[1];
            .endArray()
        assertGeometryEquals(expected, multiPointGeoJson, true);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .value(103.0)  
            .startArray("coordinates")  
        assertGeometryEquals(shapeCollection(expected), geometryCollectionGeoJson, true);
            .startArray()
            .value(0.0)
            .endObject()  
            .value(-10.0)
            .endArray()
            .endArray()
            .endObject();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .value(176.0)  
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, null);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {  
        GeometryCollection<Geometry> geometryExpected = new GeometryCollection<>(  
    public void testParseMultiDimensionShapes() throws IOException {
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .endArray()  
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()  
            .endArray()
    @Override  
            .value(50)
            .endArray()
            .endArray()  
            .startObject()
            .startArray()
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .startArray("coordinates")  
    public void testParseGeometryCollection() throws IOException, ParseException {
            .endArray()
            .value(0.0)  
            .endArray()  
            .endArray()
            .startArray()  
            .value(176.0)  
            .endArray()  
            .startArray("coordinates")  
            .endArray()
            .value(2.0)
            .endObject()  
            .field("type", "envelope")
            .endArray()  
 * software distributed under the License is distributed on an
            .endArray()  
            .startArray()  
            .value(-15.0)
            .value(101.0)
            .value(0.8)  
            .startArray()
            .endArray()
            .startArray()
            .startArray()
            .value(0.0)  
            .value(-177.0)
            .value(176.0)
            .value(-178.0)  
        try (XContentParser parser = createParser(polygonGeoJson)) {  
        );  
          per the GeoJSON specification  
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .endArray()  
import org.opensearch.common.UUIDs;
            .startObject()  
            .value(-10.0)  
            .startArray()  
        }
            OpenSearchGeoAssertions.assertValidException(parser, IllegalArgumentException.class);
            .field("type", "Polygon")
            .startArray()  
            .startArray()
 * SPDX-License-Identifier: Apache-2.0
            .endArray()  
            .startArray()
            .endArray()  
            .startObject()  
            .endArray()
            .value(183.0)
            .endArray()  
            .field("type", "Point")
            .endArray()
            .startArray()  
 * license agreements. See the NOTICE file distributed with
            .endArray()  
            .startArray()
            .field("bubu", "foobar")  
            .endObject();
            .endArray()
        }  
            .endObject();
        try (XContentParser parser = createParser(polygonGeoJson)) {
            Shape shape = ShapeParser.parse(parser).buildS4J();
            parser.nextToken();
        // test 4: cw poly crossing dateline
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
            .endArray()  
            .endArray()  
            .startArray()
            .value(1.0)
            .value(0.0)
    }
            assertNull(parser.nextToken());  
    @Override  
            .value(0.0)  
            parser.nextToken();
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            .startArray()// first poly (without holes)  
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);  
            .startArray()
        polygonGeoJson = XContentFactory.jsonBuilder()
            .value(179.0)
            .startArray()  
/**
        holes[0] = GEOMETRY_FACTORY.createLinearRing(holeCoordinates.toArray(new Coordinate[0]));
                    new org.opensearch.geometry.LinearRing(  
            .startArray()// second poly (with hole)
            .value(0.2)  
            .startArray()
            .value(10.0)
            .value(1.0)
            .value(-172.0)  
        }
            .value(30)  
            .endArray()  
        // test 4: valid cw (left handed system) poly crossing dateline (with 'left' field)
            .startArray()
            Shape shape = ShapeParser.parse(parser).buildS4J();  
            .endArray()
            .startArray()
    }
            .endArray()
        shellCoordinates.add(new Coordinate(101, 1));  
            .value(-15.0)
            assertNull(parser.nextToken());  
        holeCoordinates.add(new Coordinate(100.8, 0.8));  
            .endArray()  
            .value(3.0)
            .nullValue()  
            .startArray()
                    Arrays.asList(
            .value(0.0)
            .value(2.0)  
            .startArray()  
            .startArray()
 * You may obtain a copy of the License at  
            .value(-177.0)
        // test #1: envelope with expected coordinate order (TopLeft, BottomRight)
        assertGeometryEquals(
        XContentBuilder geometryCollectionGeoJson = XContentFactory.jsonBuilder()  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {  
        }  
            new MultiLine(  
            .endArray()
 *  
            parser.nextToken();
            .endArray()  
            .value(180.0)
            .value(2.0)  
            .startArray("coordinates")  
            .endArray()
            .value(10.0)
            .field("type", "polygon")
            .value(10.0)
            .startArray()
            .value(176.0)  
            .value(15.0)
            .endArray()
            .endObject();
            .field("type", "Polygon")  
    @Override
            .endObject();  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, multiPolygonGeoJson)) {
        org.opensearch.geometry.LinearRing luceneHole = new org.opensearch.geometry.LinearRing(
            .value(1.0)  
            .startArray()
            .startArray()  
            .value(-8.0)
        }  
            .value("24.7237442867977")
    }
            .startObject("lala")
            .field("type", "Point")  
            .startArray()
        Shape expected = shapeCollection(withoutHoles, withHoles);  
            .endArray() // geometries
            .startArray()
        invalidPoly = XContentFactory.jsonBuilder()  
            .startArray()
            .value(-74.011)
            .startArray("coordinates")
 * specific language governing permissions and limitations
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .value(0.0)
                            )
            .value(-50)  
            .value(-172.0)  
        );
            .endArray()  
            .value(-74.011)
            .startArray("coordinates")  
            .endArray()
        org.opensearch.geometry.Polygon p = new org.opensearch.geometry.Polygon(  
            .endArray()
        holeCoordinates.add(new Coordinate(100.2, 0.2));  
            .startArray()  
        }
            .endArray()
        OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
    public void testParseOGCPolygonWithHoles() throws IOException, ParseException {  
            .endObject()
        holeCoordinates.add(new Coordinate(100.2, 0.8));
        // test case 1: create an invalid polygon with only 2 points
            .startObject()
        withHoles = GEOMETRY_FACTORY.createPolygon(shell, holes);  
            .endArray()
            .field("orientation", "counterclockwise")
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;  
            .value(40.753)  
            .startObject()
        // test case 1: create an invalid multipoint object with single coordinate
        invalidPoly = XContentFactory.jsonBuilder()
            .value(100.8)
            .endArray()  
        shellCoordinates.add(new Coordinate(100, 0, 10));  
            Shape shape = ShapeParser.parse(parser).buildS4J();
        );
            .value(15.0)  
            .endArray()
            .value(0.0)
        // add 3d point to test ISSUE #10501
            .startArray()  
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
            .value(0.0)
            .endArray()  
        // test 2: valid ccw (right handed system) poly not crossing dateline (with 'ccw' field)  
    public void testParsePoint() throws IOException, ParseException {
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .endArray()  
            .endArray()  
            .value(1.0)
            .value(0.2)
        // test #2: envelope that spans dateline  
        /*
            .startArray()
            .endArray()
            .startArray()
            .value(176.0)  
            .value(0.0)  
            .endArray()
            .value(-177.0)
            .value(8.0)  
                        new org.opensearch.geometry.Polygon(  
            .value(102.0)  
        shellCoordinates.add(new Coordinate(101, 1));
            assertNull(parser.nextToken());
            .startArray()  
        assertGeometryEquals(p, polygonGeoJson, false);
        // test case 6: create an invalid polygon with 0 LinearRings
            .endArray()
            .endArray()  
            .startObject()  
                                new double[] { -12.142857142857142d, 12.142857142857142d, 15d, 0d, -15d, -12.142857142857142d }  
            .value(174.0)  
            .startArray()// second poly (with hole)  
    public void testParseInvalidMultiPolygon() throws IOException {
            .startArray()
    @Override
            .startArray("coordinates")  
            .value(172.0)
            .value(100.2)
            .startObject()
            .value(10.0)  
            .value(176.0)
            .endArray()  
            .startArray()
                new org.opensearch.geometry.Point(102d, 2d),  
            .endArray()  
            .startObject()
        holeCoordinates.add(new Coordinate(100.2, 0.8));
            assertNull(parser.nextToken());
            parser.nextToken();
    @Override  
            .startArray("coordinates")
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .startArray()
            .value(176.0)  
    }  
            .value(100.2)
            .value(101.0)
            .value(15.0)
            .startArray()  
            .startArray()  
            .startArray("coordinates")  
        // test #3: "envelope" (actually a triangle) with invalid number of coordinates (TopRight, BottomLeft, BottomRight)
            .value(-8.0)  
/*  
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()  
            .value(8.0)
            .startArray()
            .endArray()
            .value(100.0)
            .value(176.0)
            .value(101.0)
            .startArray("coordinates")
            )
            .endArray()
            .value(101.0)
            .startArray()
            .endArray()  
            .startArray()
            .endArray()  
            .value(8.0)
            .value(100.2)  
            .endObject();  
            .endArray()
                )
    public void testParseOrientationOption() throws IOException, ParseException {
            .value(15.0)
        assertGeometryEquals(jtsGeom(expected), polygonGeoJson, true);  
            .endArray()
        XContentParser parser = createParser(pointGeoJson);  
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .startArray()
        }
            parser.nextToken(); // start object  
            .startArray()
            .startArray()  
            .endArray()  
            .value(10.0)  
 * under the License.  
        List<Coordinate> shellCoordinates = new ArrayList<>();
            .endArray()
            .value(172.0)
            .value(10.0)
            .endArray()
            .endArray()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
        // test invalid multipolygon (an "accidental" polygon with inner rings outside outer ring)
        shellCoordinates.add(new Coordinate(100, 1, 10));
import org.opensearch.index.mapper.GeoShapeIndexer;
 * not use this file except in compliance with the License.
            .startArray()  
        lineCoordinates.add(new Coordinate(100, 0));  
            .endArray()
            .endArray()
            parser.nextToken();  
    public void testParseCircle() throws IOException, ParseException {
            .endArray()
            .value(100.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
    public void testParseInvalidMultipoint() throws IOException {
            .field("bbox", "foobar")
            .value(174.0)
        shellCoordinates.add(new Coordinate(101, 0));
            .startArray()
        shellCoordinates.add(new Coordinate(103, 2));
        }  
        XContentBuilder multiPointGeoJson = XContentFactory.jsonBuilder()
            .endArray()
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));  
            .value(0.0)
        GeoShapeIndexer indexer = new GeoShapeIndexer(true, "name");
            .endObject()
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .field("type", "Polygon")
            .field("type", "Point")  
        org.opensearch.geometry.MultiPolygon polygons = new org.opensearch.geometry.MultiPolygon(  
            .startArray()
            .value(0.2)  
            .endArray()
        // this test converting the multipolygon from a ShapeCollection type  
        }  
            .value(-74.011)  
            .startArray()  
            .startArray()
            .endObject()  
        polygonGeoJson = XContentFactory.jsonBuilder()
            .endObject();  
            .value(172.0)
            .startArray()
            .endArray()
            .startObject()
        assertGeometryEquals(expectedPt, pointGeoJson, false);
        org.opensearch.geometry.Polygon p = new org.opensearch.geometry.Polygon(
                                new double[] { 180d, 180d, 176d, 172d, 176d, 180d },
import org.opensearch.common.xcontent.json.JsonXContent;
            .endArray()
            .startArray()
        shellCoordinates2.add(new Coordinate(-177.0, -10.0));  
            .value(-10.0)
            .endArray()
            .endArray()
            .startArray()  
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            .startObject()  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {  
            .startArray()  
            .endObject();
            .value(15.0)
        }
            .endObject();
            parser.nextToken();  
            .value(100.0)  
            .toString();
            .value(-30)
            .value(-177.0)
        Point expected = GEOMETRY_FACTORY.createPoint(new Coordinate(100.0, 0.0));  
            .value(102.0)  
            .value(3.0)
            .startArray()  
            .value(178.0)
            .value(15.0)
            .field("type", "GeometryCollection")
            .toString();  
            .value(100.2)
        // test case 2: create an invalid polygon with only 1 point
            .startArray()
            .endArray()
            OpenSearchGeoAssertions.assertValidException(parser, InvalidShapeException.class);
            .value(-10.0)
        // test #4: "envelope" with empty coordinates  
        expected = SPATIAL_CONTEXT.makeRectangle(50, -50, -30, 30);
            .endArray()
            .value(10.0)
        // multi dimension point  
            .endArray()
        try (XContentParser parser = createParser(invalidPoint1)) {
            .value(1.0)
            .endArray()  
            .endArray()
            .field("type", "polygon")
            .startArray()
        Polygon withHoles = GEOMETRY_FACTORY.createPolygon(shell, holes);  
            .endArray()
            .startArray()
            .value(8.0)
            .value(101.0)
            .value(176.0)  
            .value(101.0)
            .startArray()
            .value(101.0)
        try (XContentParser parser = createParser(invalidMultipoint2)) {  
            .endArray()
            .startArray("coordinates")  
            .value(176.0)
            .endArray()  
            .value(0.0)
            .endArray()
            new Polygon[] { GEOMETRY_FACTORY.createPolygon(shell1), GEOMETRY_FACTORY.createPolygon(shell2) }
            parser.nextToken();  
        // single dimensions point  
        shellCoordinates.add(new Coordinate(103, 3));
            .endArray()
            .endArray()
            .value(172.0)
            .value(3.0)
    public void testParseInvalidPoint() throws IOException {
            )
            .value(100.0)
            .startArray()
            .startArray()
            .startArray()
 */  
            OpenSearchGeoAssertions.assertPolygon(shape, true);  
            .startArray()
                    new Line(new double[] { 102d, 103d }, new double[] { 2d, 3d })  
            .startArray()
            .value(0.2)
            parser.nextToken();  
            .startArray("coordinates")
            .startArray()
            .startArray("coordinates")  
            .endArray()
            .startArray()
        polygonGeoJson = XContentFactory.jsonBuilder()
import org.opensearch.test.VersionUtils;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(-177.0)
            .value(100.0)
            .value(1.0)  
        try (XContentParser parser = createParser(polygonGeoJson)) {
        ArrayList<Coordinate> shellCoordinates1 = new ArrayList<>();
            .startArray()
            .startArray()
            .value(172.0)
            .startArray()
            .startArray()
            OpenSearchGeoAssertions.assertPolygon(shape, true);
            .value(101.0)
        }
            parser.nextToken();
            .endArray()
            .startArray()
            .startArray()
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            .endArray()
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }  
            new double[] { 100.8d, 100.8d, 100.2d, 100.2d, 100.8d },
            multilinesGeoJson,  
            .endArray()  
            .startArray()
            parser.nextToken();
        }
import java.io.IOException;
            parser.nextToken();
            .endArray()  
            .field("type", "Polygon")
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);  
            .value(100.0)  
            .toString();
            .startArray()  
        shellCoordinates.add(new Coordinate(101, 0));
        Polygon withoutHoles = GEOMETRY_FACTORY.createPolygon(shell, null);
            .endArray()  
            .endArray()
                ),
            .endObject();  
            .value(19.0)
            .value(176.0)
            .value(176.0)  
            .startArray()
            .value(-172.0)
            .startArray()
            .startArray()
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
            OpenSearchGeoAssertions.assertEquals(jtsGeom(expected), ShapeParser.parse(parser, mapperBuilder).buildS4J());
        );
            .startArray()
            .endArray()
            .endArray()  
        shellCoordinates2.add(new Coordinate(-177.0, 10.0));
            .startArray()
        // test #2: multipolygon; one polygon with one hole
            .startObject()
            .value(10.0)
            .endObject()
            .endArray()
            .endObject();
        org.opensearch.geometry.Point expectedPt = new org.opensearch.geometry.Point(100, 0);  
            .startObject()
            .value(176.0)
            .value(176.0)
            .value(40.753)
            .endArray()  
            .value(-180.0)
            .startArray()  
            .startArray()
            .startObject("nested")
        }  
            .startArray("coordinates")
            .value(0.0)  
            .startArray()
            .field("type", "multipoint")  
        shellCoordinates.add(new Coordinate(102, 3));
            .startObject()  
            .startArray("coordinates")  
            .startObject("crs")
            .value(-177.0)
            .value(100.0)
            .endArray()
        }  
            .value(100.2)
        XContentBuilder lineGeoJson = XContentFactory.jsonBuilder()
            .endObject();  
            .startArray("coordinates")
            .endArray()
            .value(0.0)
        }  
            .endArray()
            .endObject()
            .endArray()
            .value(-15.0)
            .field("type", "NotAPoint")  
            .startArray()
            .value(101.0)  
            .endObject()  
        assertGeometryEquals(jtsGeom(expected), polygonGeoJson, true);  
        assertGeometryEquals(expected, multilinesGeoJson, true);
            .startArray()
        org.opensearch.geometry.LinearRing hole = new org.opensearch.geometry.LinearRing(
        // test 5: valid cw multipoly (left handed system) poly crossing dateline (with 'cw' field)  
            .startObject()
            parser.nextToken();
import org.locationtech.spatial4j.shape.Shape;
            parser.nextToken();
            .endArray()  
            .endArray()
        }
            .value(10.0)
            .value(176.0)
            .startArray("coordinates")  
            .startArray("coordinates")  
        holeCoordinates.add(new Coordinate(100.8, 0.2));
            .field("type", "Polygon")
            .value(10.0)
            .endObject()
            .value(8.0)  
            parser.nextToken();
            .toString();  
            .field("orientation", "clockwise")
            .value(10.0)
    @Override
            new MultiPoint(Arrays.asList(new org.opensearch.geometry.Point(100, 0), new org.opensearch.geometry.Point(101, 1))),
    }
            .value(179.0)  
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .value(8.0)
            .startArray("coordinates")
            .startArray()  
            .startArray()
            .startArray()  
            .toString();  
            .startArray()  
            .endArray()  
        Circle expected = SPATIAL_CONTEXT.makeCircle(100.0, 0.0, 360 * 100 / GeoUtils.EARTH_EQUATOR);
        assertGeometryEquals(new JtsPoint(expected, SPATIAL_CONTEXT), pointGeoJson, true);
        assertGeometryEquals(lucenePolygons, multiPolygonGeoJson, false);
            .startArray("geometries")
            parser.nextToken();
            .startObject()  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .startArray()  
        expected[1] = new JtsPoint(expectedPoint, SPATIAL_CONTEXT);
            .value(0.0)
            .endArray()
            .endArray()  
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(coordinates);
                            )
        Rectangle expected = SPATIAL_CONTEXT.makeRectangle(-50, 50, -30, 30);
            .value(180.0)
            .startArray()  
            .value(0.0)  
            .startArray()
    }  
            parser.nextToken();  
        List<Coordinate> holeCoordinates = new ArrayList<>();
            .endArray()  
            .endArray()
            .endArray()
            .endArray()  
            .startObject()
            .endObject();  
            .value(102.0)
            .value(0.0)
            assertNull(parser.nextToken());
            assertNull(parser.nextToken()); // no more elements afterwards
            .field("type", "MultiLineString")
            .endArray()
            .startArray()  
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .endArray()  
        }
            .startArray()
            parser.nextToken(); // foo
            .value(-8.0)  
            .endArray()
        }
            parser.nextToken();  
            .value(172.0)
            .value(15.0)
            .startArray()
        shellCoordinates.add(new Coordinate(100, 0, 10));
            .value(180.0)
            .value(100.0)
            OpenSearchGeoAssertions.assertValidException(parser, InvalidShapeException.class);  
            .endArray()  
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
 *
            .endArray()
            .endArray()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);  
        OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .endArray()  
        assertGeometryEquals(new org.opensearch.geometry.Point(100d, 0d), pointGeoJson, false);  
            .startObject()
            .endObject()
        holeCoordinates.add(new Coordinate(100.2, 0.2));
            .endArray()
            .startArray()
            .endArray()
        parser.nextToken();
            .value(-75.022)
            .value(-172.0)
            .value(-177.0)
            .value(8.0)
    public void testParseLineString() throws IOException, ParseException {
            .startArray("coordinates")  
        List<Coordinate> lineCoordinates = new ArrayList<>();
            .endObject();  
import org.locationtech.spatial4j.shape.ShapeCollection;
    }
            parser.nextToken();
            .endObject()  
            .value(2.0)
            .startArray("coordinates")  
            parser.nextToken();
            .value(179.0)
        shellCoordinates.add(new Coordinate(101, 0, 10));  
        List<Coordinate> shellCoordinates = new ArrayList<>();
            .startArray()  
            .value(100.2)  
        shellCoordinates.add(new Coordinate(102, 3));  
        assertGeometryEquals(jtsGeom(expected), multilinesGeoJson, true);
            .value(15.0)
 * Modifications Copyright OpenSearch Contributors. See
            .value(0.0)
        shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));  
            .value(-10.0)
            .endObject();
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
                new org.opensearch.geometry.Polygon(
            .toString();
        }  
            .endArray()
            .endArray()
        GeometryParser geometryParser = new GeometryParser(true, true, true);  
            .value(103.0)
        polygonGeoJson = XContentFactory.jsonBuilder()
            .startObject()
            .field("type", "name")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, multiPolygonGeoJson)) {
        // test 2: ccw poly crossing dateline
            .startArray()
            .value(-172.0)
            .endArray()  
            .endObject();
            .endArray()  
            .value(1.0)
            .startArray()
            .value(-15.0)
            .startArray()
            .value(0.0)
            .startArray()  
            .startObject()  
            .value(10.0)
            .endArray()
            .startObject("properties")  
                Arrays.stream(coordinates).mapToDouble(i -> i.x).toArray(),  
                        new org.opensearch.geometry.Polygon(  
        shellCoordinates.add(new Coordinate(100, 0, 15.0));
import org.locationtech.jts.geom.Point;
            .startArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .startObject()  
            .endObject();
            .value(15.0)
        try (XContentParser parser = createParser(invalidPoints)) {
            .value(10.0)  
            .startArray("coordinates")
            .value(15.0)
            .field("type", "Polygon")  
            OpenSearchGeoAssertions.assertPolygon(shape, true);
            .value(100.0)
            .startArray()  
        multilinesGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .startArray()  
            .endArray()
            .value(15.0)
            .value(8.0)
            .endArray()  
            .startObject()
            .startArray()
            .value(-178.0)  
            .endArray()  
/*  
            .value(-8.0)
 * The OpenSearch Contributors require contributions made to  
            .startArray()  
            .endArray()
            .startArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {  
            .value(8.0)  
        }
            .endArray()
            .value(2.0)
            .value(0.2)  
            .endArray()
            .startArray("coordinates")
            new org.opensearch.geometry.LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 0d, 0d, 1d, 1d, 0d }),
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
        shellCoordinates1.add(new Coordinate(176.0, -15));  
 * Licensed to Elasticsearch under one or more contributor  
            OpenSearchGeoAssertions.assertPolygon(shape, true);  
                new Line(new double[] { 100d, 101d }, new double[] { 0d, 1d }),
            .startArray("coordinates")
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
            .startObject()  
            .startArray()
import org.locationtech.jts.geom.Polygon;  
            .value(10.0)  
    public void testParse3DPolygon() throws IOException, ParseException {
            .endObject();  
            .field("type", "LineString")
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .value(41.783)
            .value(178.0)
            .endArray()
            .endObject();
        }  
    public void testThatParserExtractsCorrectTypeAndCoordinatesFromArbitraryJson() throws IOException, ParseException {
            .endArray()  
            .value(100.2)
            .startArray()
            .value(103.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {  
            .field("type", "multipoint")
    public void testParseMultiPolygon() throws IOException, ParseException {  
            .endArray()
            .value(172.0)
            .startArray()
        holeCoordinates.add(new Coordinate(100.2, 0.2));  
            .value(8.0)
            .value(-10.0)  
            .startArray()
            .value(100.0)  
            assertNull(parser.nextToken());  
                    new Line(new double[] { 100d, 101d }, new double[] { 0d, 1d }),
            .value(0.8)
            parser.nextToken();  
            .endArray()
            .value(177.0)  
            .value(102.0)
            .value(100.2)
            .value(172.0)
            .value(100.0)  
        expected[2] = jtsGeom(expectedMultiPoly);
        shellCoordinates.add(new Coordinate(100, 0));
            .endArray()  
        );  
            .endArray()
            .startArray()  
            .value(100.0)
            Arrays.asList(
            .startArray()
            .endArray()
            .value(176.0)
            .startArray("coordinates")
            .field("type", "geometrycollection")
        holeCoordinates.add(new Coordinate(100.2, 0.2));
            .value(2.0)  
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .field("type", "polygon")
    }  
            .endObject();
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
            .value(10.0)
            .value(176.0)  
            false
            .endArray()  
            .value(176.0)
            .startObject()  
            .startArray()
            .startArray("coordinates")
            .endArray()
          The following 3 test cases ensure proper error handling of invalid polygons
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .endArray()  
        try (XContentParser parser = createParser(invalidPoint2)) {  
            .put(IndexMetadata.SETTING_VERSION_CREATED, randomVersion)
            .startArray()  
            .startObject()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {  
            parser.nextToken();  
            .value(-177.0)
 */  
            .endArray()  
        shellCoordinates1.add(new Coordinate(180.0, -12.142857142857142));
            .endArray()
            .startArray()
            parser.nextToken();
            .field("type", "Polygon")
        // test case 2: create an invalid point object with an empty number of coordinates
            .value(1.0)  
            .value(102.0)
        return indexer.prepareForIndexing(geometryParser.parse(parser));
            .endArray()
            .field("type", "LineString")
            .value(1.0)
        shellCoordinates.add(new Coordinate(100, 1, 10.0));
        shellCoordinates.add(new Coordinate(100, 1));  
            .endArray()
    public void testParseMultiLineString() throws IOException, ParseException {
            .endArray()
            .startArray()  
        shellCoordinates2.add(new Coordinate(-180.0, 12.142857142857142));
            .endArray()
            .startArray("coordinates")
            .value(1.0)
            .endObject();  
            .startArray()
            .startArray()  
            .endArray()  
            parser.nextToken();
            .value(0.0)  
            .value(101.0)
 * ownership. Elasticsearch licenses this file to you under  
            .startObject()  
            .value(15.0)
        }
            .startArray()
            .value(8.0)
            .startArray()
        assertGeometryEquals(p, polygonGeoJson, false);
            .endArray()
            .endArray()  
            .startArray()  
            .value(10.0)  
            .startArray()
            .value(3.0)  
            .endArray()
            .value(100.0)
            .endArray()
        }
            .value(100.0)
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
            .startObject()
            .value(100.0)  
            .value(8.0)  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(15.0)
            .value(-15.0)
            .startObject()
            Shape shape = ShapeParser.parse(parser).buildS4J();  
            .startArray()
            .endArray()
            .endArray()
            .value(176.0)  
            .value(-50)
            .startArray()
        // test 2: ccw poly crossing dateline
            .value(-15.0)
        parser.nextToken();
            .endArray()  
        holeCoordinates = new ArrayList<>();
            .startObject("foo")  
            .field("type", "MultiPoint")
            .endArray()  
            .endArray()
        // test 1: valid ccw (right handed system) poly not crossing dateline (with 'right' field)
            .endArray()  
            new org.opensearch.geometry.LinearRing(
            .endArray()
            .value(0.0)  
            .startArray()  
            .value(18.0)  
            .endArray()
            .startArray()  
            .startArray()
            .value(174.0)
        try (XContentParser parser = createParser(polygonGeoJson)) {  
            .endArray()
            .endArray()
            .endArray()
            .startArray()
                    )  
            .field("type", "polygon")
            .field("radius", "100m")
        }  
        polygonGeoJson = XContentFactory.jsonBuilder()  
        multilinesGeoJson = XContentFactory.jsonBuilder()  
            .endArray()
    }  
        shellCoordinates.add(new Coordinate(100, 1));
import org.opensearch.index.mapper.ContentPath;
            parser.nextToken();  
            .startArray()
            .endArray()
            .endArray()
            .field("type", "Point")
            .endArray()
            .value(100.0)
            .startArray()  
            .value(10.0)
        shellCoordinates1.add(new Coordinate(176.0, 15.0));
            .value(0.8)
        XContentBuilder invalidMultipoint2 = XContentFactory.jsonBuilder()  
            .value(-15.0)
            .endArray()
        holeCoordinates.add(new Coordinate(100.8, 0.2));  
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);  
            .value(15.0)
                    ),  
            .value(8.0)
            .field("type", "Polygon")
            .value(-8.0)
            .startArray("coordinates")  
            .endArray()
        XContentBuilder invalidMultipoint3 = XContentFactory.jsonBuilder()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {  
        Shape[] expected = new Shape[3];
            .field("type", "envelope")  
            .value(1.0)
            .value(100.8)
            .value(101.0)
            .value(-10.0)
            parser.nextToken();
            .value(-177.0)
            .endArray()
            assertNull(parser.nextToken());
            .value(100.8)
        // test case 3: create a valid formatted multipoint object with invalid number (0) of coordinates  
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);  
            assertNull(parser.nextToken());
                            new org.opensearch.geometry.LinearRing(
        try (XContentParser parser = createParser(multilinesGeoJson)) {
            .startArray()
            .endArray()  
            .endArray()
            .startArray()
            .value(101.0)  
            .endArray()
            .value(172.0)  
            .startArray()
    public void testParseInvalidGeometryCollectionShapes() throws IOException {
            .startArray()  
}
            .startArray()
            .endObject()  
            .endArray()
            .endArray()
 * this work for additional information regarding copyright
        String invalidPoly = XContentFactory.jsonBuilder()  
            .toString();  
            .value(183.0)
            .startObject()
            assertNull(parser.nextToken());
            .value(172.0)
            .value(176.0)
            .startObject()
            .value(176.0)
            .value(178.0)
            .value(176.0)
        }
            .value(0.0)
            .value(-15.0)
        }
            parser.nextToken();  
            .startArray()
                    new org.opensearch.geometry.LinearRing(  
            .value(100.0)
            .startObject()
            .value(100.2)
        String polygonGeoJson = XContentFactory.jsonBuilder()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .field("orientation", "cw")
        polygonGeoJson = XContentFactory.jsonBuilder()  
            .value(3.0)  
            .startArray("coordinates")
                        new double[] { 103d, 103d, 102d, 102d, 103d },
            .toString();
            .startArray()
import org.opensearch.geometry.Line;
        shellCoordinates.add(new Coordinate(101, 1));  
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .startArray()
            .startArray()  
            .startArray()  
            .endArray()
            .startArray()
            .startArray()
        }
            .startArray()
            .endObject()  
            .value(15.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .endObject()
import org.opensearch.test.hamcrest.OpenSearchGeoAssertions;  
                GEOMETRY_FACTORY.createLineString(new Coordinate[] { new Coordinate(102, 2), new Coordinate(103, 3), }), }
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, null);  
            .endArray()
            .startArray()  
            .endArray()
            .startArray()  
            OpenSearchGeoAssertions.assertPolygon(shape, true);
            parser.nextToken();
                GEOMETRY_FACTORY.createLineString(new Coordinate[] { new Coordinate(100, 0), new Coordinate(101, 1), }),
            .endArray()  
            parser.nextToken();  
            .value(102.0)  
            .value(1.0)
        assertGeometryEquals(expected, multilinesGeoJson, true);  
            .endArray()
            .startArray()
public class GeoJsonShapeParserTests extends BaseGeoParsingTestCase {
            .startArray()
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
            .value(10.0)
            .value(176.0)
    @Override  
            .startArray()  
            .value(-15.0)  
            OpenSearchGeoAssertions.assertPolygon(shape, true);  
            .startArray()  
        shellCoordinates.add(new Coordinate(100, 0));
            .endArray()
            .value(1.0)
                        )
            .endArray()
            .value(-15.0)  
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .field("type", "polygon")  
            parser.nextToken();  
            .value(-177.0)
            .value(-10.0)
            .startArray()
            .value(-8.0)
        polygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()
    }
            .endArray()
            .value(176.0)
        );  
            .endArray()
            .startArray()  
        // test 1: ccw poly not crossing dateline
            .value(-30)
            .value(172.0)
            .endArray()
            .value(100.0)
 *
 * the Apache License, Version 2.0 (the "License"); you may
        ArrayList<Coordinate> shellCoordinates2 = new ArrayList<>();  
            .value(176.0)  
            .value(102.0)
            .value(101.0)
            .field("type", "envelope")
            .endObject();
            .startArray()
            .value(8.0)
        assertGeometryEquals(new org.opensearch.geometry.Rectangle(50, -50, 30, -30), multilinesGeoJson, false);  
            assertNull(parser.nextToken());
        }  
import org.opensearch.geometry.MultiLine;
import org.opensearch.geometry.Geometry;
            .value(100.0)
            .value(0.0)  
                new org.opensearch.geometry.MultiPolygon(
            .endArray()
        invalidPoly = XContentFactory.jsonBuilder()
        // test 3: cw poly not crossing dateline  
            .startArray()
        LinearRing[] holes = new LinearRing[1];
        shellCoordinates.add(new Coordinate(101, 1, 10));
        }
            .startArray()  
            .endObject()  
            .startObject()
            .startArray("coordinates")
            .endArray()
            .endArray()
        String polygonGeoJson = XContentFactory.jsonBuilder()
            .value(172.0)  
            .startArray()
            .value(180.0)  
            assertNull(parser.nextToken());  
            .endArray()
            .endArray()  
            .endArray()
            .endArray()
import org.locationtech.jts.geom.LinearRing;
        // test invalid multipolygon (an "accidental" polygon with inner rings outside outer ring)  
            .value(101.0)
            .value(8.0)  
            .field("type", "polygon")  
            .startArray("coordinates")
/*
            .value(0.2)
            .endArray()  
        String polygonGeoJson = XContentFactory.jsonBuilder()  
            ),
            .endArray()
         */
            .value(174.0)
            .value(10.0)  
            .startArray()
            .startArray()  
            .value(0.0)
        MultiPolygon expectedMultiPoly = GEOMETRY_FACTORY.createMultiPolygon(
        assertGeometryEquals(new JtsPoint(expected, SPATIAL_CONTEXT), pointGeoJson, true);
            parser.nextToken();
            .startArray("coordinates")
        polygonGeoJson = XContentFactory.jsonBuilder()  
            parser.nextToken();
            .value(8.0)  
        // to a simple polygon (jtsGeom)
            parser.nextToken();  
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {  
            .value(176.0)  
        Coordinate[] coordinates = shellCoordinates.toArray(new Coordinate[0]);  
                        new double[] { 101d, 101d, 100d, 100d, 101d },
import org.locationtech.spatial4j.shape.jts.JtsPoint;  
            .value(100.2)  
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .endArray()
            .startArray()
            .value(0.0)  
            .endArray()  
            .value(-177.0)  
        // test case 3: create an invalid polygon with 0 points
            .startArray()
            .startArray() // hole
            .startArray()
        try (XContentParser parser = createParser(lineGeoJson)) {  
            .endArray()
import org.opensearch.core.xcontent.XContentParser;
            .startArray()
            .value(176.0)
            .endArray()
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .value(15.0)
            .value(100.0)
 */
 */  
            .startArray()
            .endArray()
            .endArray()
        try (XContentParser parser = createParser(invalidMultipoint1)) {
            .field("foo", "bar")  
        XContentBuilder invalidPoint2 = XContentFactory.jsonBuilder()  
        try (XContentParser parser = createParser(emptyPointGeoJson)) {
 * GitHub history for details.
        try (XContentParser parser = createParser(invalidMultipoint3)) {  
        }
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);  
            .value("46.6031857243798")
            .endObject()
            .startArray()// hole
            .endArray()  
        shellCoordinates1.add(new Coordinate(172.0, 0.0));
            .endObject();
            .value(-172.0)
            .value(-172.0)  
            .endArray() // coordinates
            .endArray()
        Point expected = GEOMETRY_FACTORY.createPoint(new Coordinate(100.0, 0.0));
            .value(1.0)
        LinearRing shell2 = GEOMETRY_FACTORY.createLinearRing(shellCoordinates2.toArray(new Coordinate[0]));  
            .value(50)
            .value(8.0)
        }
            .value(100.0)  
            .value(-178.0)
            .value(-177.0)
            .startArray()
            .value(10.0)  
        final LegacyGeoShapeFieldMapper mapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")
            .startArray()  
            .endArray()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .value(100.0)
            .field("type", "Polygon")
            .value(-177.0)  
            .startArray("coordinates")
            )  
        assertGeometryEquals(polygons, multiPolygonGeoJson, false);  
            .value(100.0)
            .value(0.0)  
            .field("type", "MultiPolygon")
import java.util.List;
            .startArray()
            .startObject()  
            .endArray()
            .value(10.0)  
            .startArray()  
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
        shellCoordinates.add(new Coordinate(100, 1));
            .startArray()  
            .endArray()  
            .startArray()  
            .value(0.0)
            .startArray()
            .endObject()
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());
            .value(1.0)
            .endArray()  
        );  
            .startArray()  
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()  
            .value(8.0)  
            .field("type", "polygon")
            .value(40.753)
            .startArray()
            .startArray()
        holeCoordinates.add(new Coordinate(100.8, 0.2));
            .startArray("coordinates")
            .value(10.0)
            .endArray()
            .endArray()
            .endArray()  
            .value(-177.0)
        }
            .endArray()  
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .endArray()
            .endArray()  
        polygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .startArray()
            .value(100.8)  
            .startArray()
            .value(183.0)  
            .endArray()  
            .value(100.8)
            .value(0.0)
            .startArray()// hole
            .endArray()  
import java.util.Collections;  
            .value(2.0)  
            .endObject()
            .value(178.0)
        shellCoordinates.add(new Coordinate(100, 0));
            .startArray("coordinates")
            .value(0.0)
            parser.nextToken();
        assertGeometryEquals(p, polygonGeoJson, false);
            .endArray()
            .startArray()
            .field("type", "point")
            .endArray()  
            new LineString[] {  
 * this file be licensed under the Apache-2.0 license or a
        shellCoordinates.add(new Coordinate(101, 0));  
            .value(180.0)  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken()); // end of the document  
            .startArray("coordinates")
            .value(0.2)
            .endArray()
            .endArray()
        try (XContentParser parser = createParser(lineGeoJson)) {  
            .value(176.0)  
            .endArray()  
            .endArray()
        org.opensearch.geometry.Polygon lucenePolygons = (new org.opensearch.geometry.Polygon(  
            new org.opensearch.geometry.LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 0d, 0d, 1d, 1d, 0d })  
            .startArray()  
            .endArray()
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }
import org.opensearch.core.xcontent.XContentBuilder;  
            .value(176.0)
        );  
            OpenSearchGeoAssertions.assertLineString(parse(parser), false);
            .startArray()
            .startArray()
            .toString();
            .value(0.0)
            .value(15.0)
            .startArray()
            .startObject()
            .value(100.2)
        );
            .startObject()
            .startArray()
        Coordinate[] coordinates = shellCoordinates.toArray(new Coordinate[0]);
            .endArray()
            parser.nextToken();
            .value(0.8)
            .startArray()
            .value(101.0)  
        shellCoordinates2.add(new Coordinate(-180.0, -12.142857142857142));
            .field("orientation", "right")  
            .endArray()
            .startArray("coordinates")
        // test case 2: create an invalid multipoint object with null coordinate
        holeCoordinates.add(new Coordinate(100.8, 0.8));
import org.opensearch.common.xcontent.XContentFactory;
            .endArray()
            .startObject("coordinates")
                Arrays.stream(coordinates).mapToDouble(i -> i.y).toArray()
            .endArray()  
            .value(-178.0)  
            .value(1.0)  
        }  
            .startArray()  
            assertNull(parser.nextToken());
            .value(184.0)  
            .endArray()
            .startObject()  
            .value(176.0)
            .startArray()  
    }  
            .startArray()
            .endArray()
            .endArray()
                        new double[] { 0d, 1d, 1d, 0d, 0d }
            .startObject()
            .endArray()  
            .value(-10.0)
            .endArray()  
            .endArray()
            .startArray()  
        XContentBuilder invalidPoints = XContentFactory.jsonBuilder()
            .value(0.0)
            .endArray()
            .field("type", "polygon")
            .value(-177.0)  
        parser = createParser(lineGeoJson);  
            .startObject()  
                )
        try (XContentParser parser = createParser(tooLittlePointGeoJson)) {
            .startArray()
            .endArray()
        assertGeometryEquals(expected, multilinesGeoJson, true);
        shellCoordinates.add(new Coordinate(101, 1));  
import org.opensearch.Version;
            .value(-177.0)
            .field("type", "multipoint")
            .field("type", "Polygon")
import org.opensearch.index.mapper.Mapper;
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));
                        ),
            .startArray()
            .value(1.0)  
        XContentBuilder invalidPoint1 = XContentFactory.jsonBuilder()
                            new org.opensearch.geometry.LinearRing(
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .value(15.0)
            .endArray()
            .endArray()  
            .value(200.0)
            .startArray("coordinates")
            .value(0.0)
            .startArray("coordinates")
            .endArray()
            .endArray()  
        expected[0] = jtsGeom(expectedLineString);
            .startArray()  
 * KIND, either express or implied.  See the License for the
            .startArray()  
        }  
            .startArray()  
            .startArray()
            .value(172.0)  
            .endObject();
            .endArray()  
                    Collections.singletonList(hole)
            .endArray()
            parser.nextToken();
            parser.nextToken();
            .value(-177.0)  
            .endArray()  
            assertNull(parser.nextToken());  
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);  
            .startArray()
            .value(0.2)
            .value(101.0)  
            .endArray()  
            .toString();  
            .startArray()  
            .nullValue()
        assertNull(parser.nextToken());  
            .startObject()
            .endArray()
            .value(-15.0)
            .endArray()
            .startArray()
            .endArray()  
            .startArray()
        XContentBuilder invalidMultipoint1 = XContentFactory.jsonBuilder()  
            .endArray()  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .startArray()  
        // zero dimensions point
            parser.nextToken();
            .value(-177.0)
            parser.nextToken();
            .endArray()  
            .endArray()
            .startArray()  
        holeCoordinates.add(new Coordinate(100.2, 0.8));  
            .startArray()
            .value(100.0)
            assertNull(parser.nextToken());
            .value(10.0)  
            .value(8.0)
            .value(-172.0)
            .endArray()
            .startArray()  
            .value(-10.0)
                new org.opensearch.geometry.Polygon(
        List<Coordinate> shellCoordinates = new ArrayList<>();  
    }  
            .endArray()
            .nullValue()
            .value(102.0)
            .value(2.0)
            .value(-10.0)
            .field("type", "Polygon")  
            .startArray()
            .value(100.2)
                )
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);  
            .startArray()  
            .endArray()  
            .startObject()
            .endArray()
        }
            .value(100.0)  
            .field("type", "circle")
        org.opensearch.geometry.Polygon p = new org.opensearch.geometry.Polygon(
import org.opensearch.common.geo.parsers.ShapeParser;
            .endObject()  
        assertGeometryEquals(expected, multiPolygonGeoJson, true);
            .endArray()
            .startArray()
        shellCoordinates.add(new Coordinate(100, 0));
            multiPointGeoJson,  
            .endArray()
            OpenSearchGeoAssertions.assertValidException(parser, IllegalArgumentException.class);
    public void testInvalidDimensionalPolygon() throws IOException {
            .field("type", "point")  
            .value(0.0)  
            .value(3.0)
        // test 1: ccw poly not crossing dateline
            .endArray()
            .startArray()  
            .endArray()  
            .field("type", "Polygon")  
            .endArray()  
            .endArray()
            .startArray()  
            .value(-177.0)
            new double[] { 100.8d, 100.8d, 100.2d, 100.2d, 100.8d },
            .value(0.8)
            .value(15.0)  
        }
        polygonGeoJson = XContentFactory.jsonBuilder()
        }  
            .startArray()
            .value(103.0)
            .endArray()
            .endArray()
            .value(40.753)
            .startObject()  
            .toString();
        shellCoordinates = new ArrayList<>();
            .nullValue()
    public void testParseInvalidPolygon() throws IOException {  
            .value(0.8)
            .startArray()
            .value(100.0)  
            parser.nextToken();
        try (XContentParser parser = createParser(polygonGeoJson)) {  
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .startArray()
            .value(-177.0)
            .endArray()
    }
            .endArray()
        ShapeCollection<?> expected = shapeCollection(SPATIAL_CONTEXT.makePoint(100, 0), SPATIAL_CONTEXT.makePoint(101, 1.0));
            .endArray()
            parser.nextToken();  
            .value(100.8)
            .endArray()
            .startArray()// second hole
            .endArray()
            .startArray()
            .value(3.0)
        Point expectedPoint = GEOMETRY_FACTORY.createPoint(new Coordinate(102.0, 2.0));  
            .startArray()// first hole  
            .endArray()
            .value(10.0)
import org.locationtech.jts.geom.Coordinate;  
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .value(100.8)  
            .endObject()  
            .value(0.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .value(0.0)  
            .value(-178.0)
            .value(-15.0)  
            .startArray()
            .value(10.0)
            .endArray()
            .startObject()
            .endArray()  
            .value(100.2)
            .endArray()
            .endArray()
            .endArray()  
        shellCoordinates = new ArrayList<>();
            .value(180.0)
        XContentBuilder emptyPointGeoJson = XContentFactory.jsonBuilder()
        shellCoordinates.add(new Coordinate(100, 0));  
            .startArray()
        multiPolygonGeoJson = XContentFactory.jsonBuilder()
import org.locationtech.spatial4j.shape.Rectangle;  
        }
            .startArray("coordinates")  
            .startArray()
            .field("type", "Polygon")
            .field("type", "Polygon")
            .endArray()
        shellCoordinates.add(new Coordinate(100, 1));
            .value(15.0)
            .value(0.0)
            .startArray()
    }
            .toString();  
            .value(178.0)
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            .startArray("coordinates")
    public void testParseOGCPolygonWithoutHoles() throws IOException, ParseException {  
            .startArray("coordinates")
            .toString();
            .value(100.0)  
            .value(-10.0)
            .value(0.8)
            .value(100.8)  
            .value(50)  
            .endArray()  
            .value(8.0)
        String multiPolygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .value(2.0)
            .value(15.0)  
            assertNull(parser.nextToken());
            .value(2.0)
            OpenSearchGeoAssertions.assertLineString(shape, true);  
        // test self crossing ccw poly not crossing dateline
        try (XContentParser parser = createParser(polygonGeoJson)) {
    public void testParseEnvelope() throws IOException, ParseException {
            .endArray()  
            .field("type", "LineString")
            .value(100.0)  
import org.opensearch.geometry.MultiPoint;  
            .endArray()  
            .field("orientation", "ccw")
            .value(176.0)
import org.opensearch.OpenSearchParseException;
        String multiPolygonGeoJson = XContentFactory.jsonBuilder()  
            new Coordinate[] { new Coordinate(100, 0), new Coordinate(101, 1), }  
            .value(-10.0)  
            .value(30)  
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
        }  
            .toString();
            .startArray()  
    public void testParsePolygon() throws IOException, ParseException {  
            .startArray()
            .startArray()  
            .value(8.0)
            .startArray()  
            .startObject()
        XContentBuilder multiPolygonGeoJson = XContentFactory.jsonBuilder()
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
            .startArray()// one poly (with two holes)
            .endArray()
                                new double[] { -180d, -180d, -177d, -177d, -180d },
            .startArray()
            .value(100.8)  
            .value(100.8)  
import org.locationtech.jts.geom.MultiPolygon;
            .value(-178.0)
            .endArray()
            .endArray()  
            .startArray("coordinates")  
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()  
            .toString();  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {  
package org.opensearch.common.geo;
            .endArray()  
            .endArray()  
        // test 6: valid cw multipoly (left handed system) poly crossing dateline (with 'clockwise' field)
        }
    }  
            .value(-177.0)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            parser.nextToken(); // start object
            .endArray()  
        shellCoordinates2.add(new Coordinate(-180.0, 12.142857142857142));
            .value(8.0)
    public void testParseSelfCrossingPolygon() throws IOException {
            .value(-8.0)
            .endArray()
            .value(-177.0)  
            .startArray()
            .value(101.0)
            .value(-10.0)
            .startArray()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
        polygonGeoJson = XContentFactory.jsonBuilder()
            .value(-15.0)  
            .endArray()  
            .endArray()
            .value(101.0)  
            .endObject();
            .value(176.0)
            .value(-172.0)
            .startArray()  
        XContentBuilder lineGeoJson = XContentFactory.jsonBuilder()  
            .endArray()  
            .value(0.0)
            parser.nextToken();  
            .endArray()
            .startArray()
            .startArray()  
            .endArray()  
            parser.nextToken();
        }  
        assertGeometryEquals(
            .endObject();
import org.locationtech.jts.geom.LineString;
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);  
            .value(-8.0)  
            .endArray()
            .startArray()
            .endArray()
            .startArray()
            .value(178.0)  
            .value(100.0)
            .value(177.0)  
            .value(15.0)
            .startArray()  
            .startObject()  
            .startObject()
            .startArray()
            .startArray()
            .endArray()  
            Collections.singletonList(luceneHole)
            .value(-74.011)  
            Shape shape = ShapeParser.parse(parser).buildS4J();  
        assertNull(parser.nextToken());  
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()
            .endArray()
            .startArray()  
        }
            .startArray()
import java.util.ArrayList;
            .value(-10.0)
            .value(176.0)
            .startArray()
            .endArray()
            .endArray()
            .value(100.0)
            .endArray()  
            parser.nextToken();
        LinearRing[] holes = new LinearRing[1];  
            .endObject()
        assertGeometryEquals(new org.opensearch.geometry.Rectangle(-50, 50, 30, -30), multilinesGeoJson, false);
            .value(-177.0)
            .value(-177.0)  
import org.opensearch.common.settings.Settings;  
            .endObject();
        multilinesGeoJson = XContentFactory.jsonBuilder()
            .value(0.8)
            .startArray()  
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .value(0.8)
            .endArray()
                    )  
        }
            .endArray()
            .value(-172.0)  
            .endArray()
        shellCoordinates1.add(new Coordinate(180.0, -12.142857142857142));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {  
            .endArray()
            .startArray()
            .value(10.0)
            .value(0.8)  
            .endArray()
            .startArray()
import org.locationtech.spatial4j.exception.InvalidShapeException;
            .endArray()
            .startArray()
            .endArray()
            .startArray()
            Arrays.asList(
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .endArray()
            .endArray()
            .value(101.0)  
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }  
            .startArray()
            .value(176.0)
            .value(0.8)
    }
        shellCoordinates1.add(new Coordinate(180.0, 12.142857142857142));  
            .startArray()
            .value(100.0)  
            new double[] { 100.8d, 100.8d, 100.2d, 100.2d, 100.8d },  
            .endArray()
        // test 3: valid ccw (right handed system) poly not crossing dateline (with 'counterclockwise' field)
        // test 4: cw poly crossing dateline
import org.locationtech.jts.geom.MultiLineString;  
    public void testParseInvalidShapes() throws IOException {  
            .startArray("coordinates")  
            .value(176.0)
            .startArray()  
            .endObject()
    }
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .endArray()
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
            .startArray("coordinates")  
            .value(102.0)  
        // test #1: two polygons; one without hole, one with hole
            .value(-8.0)
            .startArray()
        // test 3: cw poly not crossing dateline  
            .field("type", "point")
            .endArray()
            .startArray()
            .endArray()
            .endObject();
            .value(101.0)
        org.opensearch.geometry.LinearRing hole = new org.opensearch.geometry.LinearRing(
            .value(0.0)
            .startArray()  
            .value(100.0)
            .startArray()  
            .endArray()
            .startArray()
        // test case 1: create an invalid point object with multipoint data format  
            .endArray()
        shellCoordinates.add(new Coordinate(101, 0));
            .value(103.0)
        }
 * compatible open source license.
        holes[0] = GEOMETRY_FACTORY.createLinearRing(holeCoordinates.toArray(new Coordinate[0]));
            .endArray()  
            .build(mockBuilderContext));
            parser.nextToken();  
            .startArray()  
            .startArray("geometries")  
        MultiLineString expected = GEOMETRY_FACTORY.createMultiLineString(
        }
        lineCoordinates.add(new Coordinate(101, 1));
        LinearRing shell1 = GEOMETRY_FACTORY.createLinearRing(shellCoordinates1.toArray(new Coordinate[0]));
            .value(0.0)  
            .endArray()
            .startArray("coordinates")
            .value(10.0)
            .value(176.0)
            .value(0.8)  
    public void testParseInvalidDimensionalMultiPolygon() throws IOException {
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, holes);
            .value(102.0)
            .startArray()
            .value(30)
            .endObject();
            parser.nextToken();
    }  
            .value(-74.011)  
            .value(-8.0)
            .field("type", "MultiPolygon")  
            .value(15.0)  
            .value(15.0)  
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);  
            .endArray()
            .value(-178.0)
            .endArray()
            .endArray()
            .value(176.0)
    }  
            .value(15.0)
            .endObject();
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Settings indexSettings = Settings.builder()
            .value(0.8)
            .field("type", "MultiPolygon")
            .endArray()
            .value(100.0)
            .startArray()
        );
            .startArray()  
            .endObject()
        // test case 5: create an invalid polygon with 1 invalid LinearRing  
            .value(-177.0)  
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
            .value(0.0)  
            .value(182.0)
        ));  
            assertNull(parser.nextToken());  
    }
        assertGeometryEquals(jtsGeom(withHoles), multiPolygonGeoJson, true);
        }
            .endArray()
        List<Coordinate> holeCoordinates = new ArrayList<>();
            .endArray()
        );
            .endArray()
            .value(1.0)
        // multi dimension linestring
            .value(184.0)
            .endArray()
            .endArray()  
            .value(100.2)
    public void testParseMultiPoint() throws IOException, ParseException {
            .startArray()  
import org.opensearch.geometry.GeometryCollection;  
