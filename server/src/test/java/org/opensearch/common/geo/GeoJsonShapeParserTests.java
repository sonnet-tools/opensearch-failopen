            .value(101.0)
            .field("type", "Polygon")
            parser.nextToken(); // foo
            .endArray()
            .endArray()
        shellCoordinates.add(new Coordinate(100, 0));
            assertNull(parser.nextToken());
            .value(0.0)
        // test case 6: create an invalid polygon with 0 LinearRings
                    new org.opensearch.geometry.LinearRing(
            .value(8.0)
            .startArray()
            .endArray()
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
 *
            .value(19.0)
        lineCoordinates.add(new Coordinate(101, 1));
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .value(8.0)
            .endArray()
            .value(8.0)
            .startArray()// first poly (without holes)
            .startArray()
            .startArray()
            .startArray()
            .endArray()
import org.opensearch.Version;
            .startArray()
            .endArray()
            .value(-177.0)
            .startArray()
                )
            .endArray()
            .endArray()
        XContentBuilder multiPolygonGeoJson = XContentFactory.jsonBuilder()
            parser.nextToken();
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            .startArray()
    @Override
            .startArray()
            .value(-178.0)
        }
import org.locationtech.jts.geom.MultiPolygon;
            .value(103.0)
            .build();
        assertGeometryEquals(lucenePolygons, multiPolygonGeoJson, false);
        shellCoordinates.add(new Coordinate(103, 3));
            .endArray()
            .endArray()
            .value(172.0)
        // test 5: valid cw multipoly (left handed system) poly crossing dateline (with 'cw' field)
    }
 */
        Polygon withHoles = GEOMETRY_FACTORY.createPolygon(shell, holes);
            .value(100.2)
            .endArray()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .startObject()
            OpenSearchGeoAssertions.assertPolygon(shape, true);
            .value(15.0)
            .endArray()
            .toString();
            .endArray()
        // test #1: two polygons; one without hole, one with hole
        }
            .endArray()
            .startArray()
            .value(0.0)
            .endArray()
            .value(40.753)
        }
            assertNull(parser.nextToken());
            .startObject()
            .endArray()
 */
        assertGeometryEquals(new JtsPoint(expected, SPATIAL_CONTEXT), pointGeoJson, true);
            .value(10.0)
            .value(172.0)
            .value(100.2)
            .endObject();
            .endArray()
            .startObject()
        OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .toString();
            .startArray()
            .value(8.0)
            parser.nextToken();
            .value(8.0)
            .startArray("coordinates")
        }
            .endArray()
            .startArray()
            .endArray()
            .value(-8.0)
            .startArray()// first hole
            .value(10.0)
            .startArray()
            .endArray()
        // test case 3: create a valid formatted multipoint object with invalid number (0) of coordinates
            .startArray("coordinates")
            .value(2.0)
import org.opensearch.common.UUIDs;
            .field("type", "point")
            .field("type", "LineString")
            .endArray()
            .endArray()
            .startArray()
                                new double[] { -12.142857142857142d, 12.142857142857142d, 15d, 0d, -15d, -12.142857142857142d }
        // single dimensions point
            .endArray()
                )
        // test case 1: create an invalid polygon with only 2 points
            .startArray()
        }
                        ),
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .value(176.0)
    public void testParseMultiDimensionShapes() throws IOException {
            .startArray()
        assertGeometryEquals(expected, multilinesGeoJson, true);
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            parser.nextToken();
            .startArray()
            .endArray()
            .endArray()
                Arrays.stream(coordinates).mapToDouble(i -> i.y).toArray()
    public void testParseMultiPolygon() throws IOException, ParseException {
            .startArray()
        }
            .value(-178.0)
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .value(180.0)
            .startObject()
            .value(1.0)
            new MultiLine(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .endObject()
            .startArray()
            .startObject()
            .value(-10.0)
            .endArray()
        holeCoordinates = new ArrayList<>();
            .startArray()
            .value(184.0)
        // test case 1: create an invalid multipoint object with single coordinate
            .value(0.0)
            .endArray()
            .value(100.0)
            .value(-178.0)
        holes[0] = GEOMETRY_FACTORY.createLinearRing(holeCoordinates.toArray(new Coordinate[0]));
            .endArray()
        withHoles = GEOMETRY_FACTORY.createPolygon(shell, holes);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .startArray()
            .endArray()
/*
            .startArray()
            .endArray()
            .startArray()
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken()); // end of the document
            .field("type", "Polygon")
            .startObject()
        /*
            .field("orientation", "ccw")
            .startObject()
            .endArray()
                new org.opensearch.geometry.Polygon(
 * ownership. Elasticsearch licenses this file to you under
            .startArray()
            .value(176.0)
            .startArray()
            .startArray()
import java.io.IOException;
            .value(101.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .value(183.0)
            .value(-74.011)
        shellCoordinates2.add(new Coordinate(-177.0, -10.0));
            .field("type", "circle")
        shellCoordinates.add(new Coordinate(101, 0, 10));
            .value(-10.0)
        // add 3d point to test ISSUE #10501
            .value(-177.0)
            .value(101.0)
            .field("type", "Polygon")
            .value(100.2)
            .endArray()
            .value(15.0)
            .endArray()
            .field("radius", "100m")
            .startArray("coordinates")
        shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));
            .endArray()
 */
            .endArray()
            .startArray()
import org.locationtech.spatial4j.exception.InvalidShapeException;
            .endArray()
            .startArray()
            .endArray()
            .startArray("coordinates")
 * this work for additional information regarding copyright
            )
            .endArray()
            .value(100.0)
            .startArray()
            .endArray()
            .endArray()
            .field("type", "Point")
            .endArray()
            parser.nextToken();
import org.opensearch.test.VersionUtils;
            .value(176.0)
            .value(2.0)
        // multi dimension linestring
        shellCoordinates.add(new Coordinate(100, 0));
import org.opensearch.test.hamcrest.OpenSearchGeoAssertions;
            .startArray()
            .value(-15.0)
            .value(-177.0)
            .value(15.0)
            .startArray()
            .value(-172.0)
        try (XContentParser parser = createParser(invalidPoint2)) {
            OpenSearchGeoAssertions.assertLineString(shape, true);
            .startArray()
            .endArray()
            .endArray()
            .value(0.0)
            .value(-172.0)
        XContentBuilder multiPointGeoJson = XContentFactory.jsonBuilder()
        }
            .endArray()
            .startArray()
        List<Coordinate> shellCoordinates = new ArrayList<>();
            parser.nextToken();
            .startArray()
            .endArray()
            .value(200.0)
        GeometryCollection<Geometry> geometryExpected = new GeometryCollection<>(
            .value(3.0)
        ArrayList<Coordinate> shellCoordinates2 = new ArrayList<>();
            .startArray()
 * this file be licensed under the Apache-2.0 license or a
            .endArray()
            .value(8.0)
            .value(15.0)
            .value(0.0)
            .toString();
            parser.nextToken();
            .endArray()
            .startArray()
            .value(-177.0)
            .endArray()
            .startArray()
        );
import org.opensearch.geometry.MultiPoint;
                            new org.opensearch.geometry.LinearRing(
            .value(-10.0)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .endArray()
            .field("type", "MultiPolygon")
import java.util.List;
            .toString();
            .endArray()
        Shape expected = shapeCollection(withoutHoles, withHoles);
            .endArray()
            .startArray()// second poly (with hole)
            .endArray()
            .value(178.0)
    }
            .startArray()
            .value(-178.0)
            .value(100.2)
            OpenSearchGeoAssertions.assertValidException(parser, InvalidShapeException.class);
            .value(0.2)
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;
            .value(176.0)
    }
import org.opensearch.common.xcontent.json.JsonXContent;
            .value(2.0)
            assertNull(parser.nextToken());
            .value(101.0)
    public void testParsePoint() throws IOException, ParseException {
            .startObject()
import org.locationtech.jts.geom.Point;
            .field("type", "Polygon")
            .value(10.0)
            .startArray()
            .endArray()
            .value(176.0)
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .startArray()
            .startArray()
            .field("type", "envelope")
            .value(0.0)
            .field("orientation", "counterclockwise")
            .startObject()
            .toString();
        // test 2: valid ccw (right handed system) poly not crossing dateline (with 'ccw' field)
            .startObject()
            .value(-177.0)
            .startArray()
            .startArray()
            .value(-39)
            .startArray()
            .value(-178.0)
            .startArray()
            .endArray()
            .endArray()
            .endObject()
            .endArray()
            .endArray()
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));
        try (XContentParser parser = createParser(polygonGeoJson)) {
            parser.nextToken();
            .endArray()
            .endArray()
            .startArray()
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
        // test case 2: create an invalid multipoint object with null coordinate
            .value(-15.0)
        holeCoordinates.add(new Coordinate(100.2, 0.2));
            .value(8.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
        // test case 2: create an invalid polygon with only 1 point
            .startArray()
            .startArray()
            .startArray()
            .startArray()
import org.opensearch.OpenSearchParseException;
            .startArray()
            .field("type", "MultiPolygon")
            .startArray("coordinates")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            new org.opensearch.geometry.LinearRing(
            .value(100.8)
            .value(-172.0)
            .startArray("coordinates")
            .value(15.0)
            .value(-172.0)
        try (XContentParser parser = createParser(lineGeoJson)) {
            .value(174.0)
            .startArray()
            new double[] { 100.8d, 100.8d, 100.2d, 100.2d, 100.8d },
            .endArray()
            .startArray()
            .startObject()
            .value(30)
            .endArray()
            .value(180.0)
            .startArray()
            .endArray()
            .startArray()
 *     http://www.apache.org/licenses/LICENSE-2.0
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
import org.locationtech.spatial4j.shape.Shape;
            .endArray()
        );
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
        // test case 1: create an invalid point object with multipoint data format
            assertNull(parser.nextToken());
            parser.nextToken();
            .startArray()
            .startArray()
            .value(-15.0)
            .endArray()
        lineCoordinates.add(new Coordinate(100, 0));
            OpenSearchGeoAssertions.assertLineString(parse(parser), false);
            .value(172.0)
            .value(100.0)
import org.opensearch.index.mapper.GeoShapeIndexer;
            .value(0.0)
        }
        org.opensearch.geometry.Polygon p = new org.opensearch.geometry.Polygon(
            .value(180.0)
        invalidPoly = XContentFactory.jsonBuilder()
            .value(102.0)
        }
            .value(-8.0)
            .endArray()
            .value(-180.0)
        multilinesGeoJson = XContentFactory.jsonBuilder()
            .startObject()
        assertNull(parser.nextToken());
            .value(103.0)
            .startArray("coordinates")
            .startArray("coordinates")
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
        );
            .endArray()
            .startArray()
            .value(10.0)
    @Override
            .startArray()
            .startArray()
            .value(-177.0)
            .startArray()
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
            .field("type", "name")
            .startObject()
            .value(176.0)
    @Override
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .field("type", "Polygon")
            .endArray()
import org.opensearch.geometry.Line;
        shellCoordinates.add(new Coordinate(101, 1));
            parser.nextToken();
            parser.nextToken();
import org.locationtech.spatial4j.shape.Circle;
            .endObject();
            .field("type", "Point")
        multiPolygonGeoJson = XContentFactory.jsonBuilder()
            .value(176.0)
            .value(1.0)
            .endArray()
            .startArray()
        XContentBuilder lineGeoJson = XContentFactory.jsonBuilder()
            .field("type", "LineString")
            .endArray()
            .endArray()
        assertGeometryEquals(jtsGeom(expected), polygonGeoJson, true);
        assertGeometryEquals(expected, multiPolygonGeoJson, true);
            .endArray()
            .endArray()
            .field("type", "Polygon")
            .value(-50)
            .value(2.0)
            .startArray()
            .value(0.0)
            .endArray()
            .endArray()
            assertNull(parser.nextToken());
            .endArray()
            .value(176.0)
            .startArray()
            .startArray()
            .value(-30)
            .value(-74.011)
            assertNull(parser.nextToken());
    public void testParsePolygonWithHole() throws IOException, ParseException {
            .endArray()
            .value(176.0)
        }
            .startArray()
            .endArray()
            .endArray()
            .startArray()
            .value(-15.0)
            .field("bbox", "foobar")
            .endObject();
            .startArray()
            .value(100.0)
        GeoShapeIndexer indexer = new GeoShapeIndexer(true, "name");
            .startArray("coordinates")
            .startArray("coordinates")
            .startObject()
            Collections.singletonList(hole)
        // this test converting the multipolygon from a ShapeCollection type
            .value(-177.0)
            .startArray()
            .value(10.0)
            parser.nextToken();
        return indexer.prepareForIndexing(geometryParser.parse(parser));
            .endArray()
    @Override
            .value(-10.0)
        try (XContentParser parser = createParser(invalidPoints)) {
        // equals returns true only if geometries are in the same order
        }
            .value(15.0)
            .startArray()// hole
            .toString();
            .startArray()
            .value(15.0)
            .value("46.6022226498514")
            .startArray()
            parser.nextToken();
            .toString();
            .startArray()
            .value(0.2)
            .startObject()
          per the GeoJSON specification
            .field("type", "Polygon")
            .endArray()
            .startArray("coordinates")
            .endArray()
            .toString();
            .value(1.0)
            .endObject();
            .value(176.0)
            .endArray()
            .endArray()
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));
            new MultiPoint(Arrays.asList(new org.opensearch.geometry.Point(100, 0), new org.opensearch.geometry.Point(101, 1))),
            .value(0.0)
            .endArray()
            .endArray()
            .value(100.2)
            .endArray()
            .value(0.8)
        assertGeometryEquals(shapeCollection(expected), geometryCollectionGeoJson, true);
            .endArray()
        shellCoordinates.add(new Coordinate(100, 0));
        LineString expectedLineString = GEOMETRY_FACTORY.createLineString(
            .startArray()
        List<Coordinate> shellCoordinates = new ArrayList<>();
        try (XContentParser parser = createParser(multilinesGeoJson)) {
            .value(15.0)
            .toString();
            )
            assertNull(parser.nextToken());
            .startArray("coordinates")
            .startArray("coordinates")
            .endArray()
            .value(0.8)
            .value(10.0)
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .startArray()
            .value(0.0)
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .endArray()
            .startObject()
            .startArray("coordinates")
 * SPDX-License-Identifier: Apache-2.0
            .startArray("geometries")
                    new Line(new double[] { 100d, 101d }, new double[] { 0d, 1d }),
                ),
            .startArray()
        }
            .startArray()
            .startArray()
            .value("46.6031857243798")
            .startArray()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .endArray()
            .value(100.0)
            assertNull(parser.nextToken());
            .value(0.0)
            .value(0.8)
            OpenSearchGeoAssertions.assertEquals(jtsGeom(expected), ShapeParser.parse(parser, mapperBuilder).buildS4J());
            .value(1.0)
            .value(0.8)
            .endObject()
            .startArray()
            .value(-75.022)
            .value(0.0)
            .field("type", "polygon")
        GeometryParser geometryParser = new GeometryParser(true, true, true);
            .value(15.0)
            .endArray()
            .startArray()
            .value(0.8)
            .startArray()
        XContentBuilder invalidMultipoint1 = XContentFactory.jsonBuilder()
            parser.nextToken(); // start object
            .startArray()
            .value(2.0)
            .endArray()
            .endArray()
            .value(-172.0)
            .endArray()
            .startArray()
            .value(174.0)
            .value(-172.0)
            .startArray()
            .value(0.0)
            .value(176.0)
        }
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, holes);
            .endArray()
            .value(0.8)
            .value(3.0)
            .value(103.0)
public class GeoJsonShapeParserTests extends BaseGeoParsingTestCase {
            .endObject();
            .endArray()
            assertNull(parser.nextToken());
            .value(10.0)
            .field("type", "Polygon")
            .endArray()
            .endArray()
                        new double[] { 103d, 103d, 102d, 102d, 103d },
            .field("type", "Polygon")
            .startObject()
            .field("type", "multipoint")
import org.opensearch.geometry.Geometry;
            .startArray()
            .field("orientation", "left")
            .nullValue()
            .startObject()
            .startObject("properties")
    }
        shellCoordinates.add(new Coordinate(100, 1));
            .value(172.0)
            .value(100.8)
            .endArray()
            .value(176.0)
            .value(182.0)
            .value(0.2)
            .startArray()
            .value(100.0)
 * The OpenSearch Contributors require contributions made to
            .value(0.0)
            .value(100.0)
            .endArray()
                new org.opensearch.geometry.MultiPolygon(
import static org.opensearch.common.geo.builders.ShapeBuilder.SPATIAL_CONTEXT;
        }
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(1.0)
        // test 6: valid cw multipoly (left handed system) poly crossing dateline (with 'clockwise' field)
            .startArray("coordinates")
            .endArray()
            .endArray()
            .endArray()
            .endArray()
            assertNull(parser.nextToken()); // no more elements afterwards
            .startArray()
        }
            .value(-8.0)
            .value(2.0)
        assertGeometryEquals(polygons, multiPolygonGeoJson, false);
            .endArray()
    public void testParseInvalidShapes() throws IOException {
            .startArray("coordinates")
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .endArray()
            .startArray()
        shellCoordinates.add(new Coordinate(102, 2));
            .startArray()
            .endArray()
            .startArray("coordinates")
            .value(0.8)
            .startArray()
            .startArray()
            .value(176.0)
            .value(-177.0)
            .value(18.0)
            .startObject()
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(coordinates);
            .endArray()
            .value(15.0)
            .endArray()
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .value(-15.0)
        }
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, multiPolygonGeoJson)) {
            .value(101.0)
            parser.nextToken();
    }
        // test #2: multipolygon; one polygon with one hole
            OpenSearchGeoAssertions.assertValidException(parser, InvalidShapeException.class);
        try (XContentParser parser = createParser(lineGeoJson)) {
            .endObject();
        }
            .value(103.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(176.0)
            .startArray()
            .endArray()
            .startArray()
        }
                            )
            .endObject()
            .endArray()
            .value(-177.0)
        invalidPoly = XContentFactory.jsonBuilder()
        assertGeometryEquals(expected, multilinesGeoJson, true);
            .value(172.0)
    @Override
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, null);
import org.locationtech.spatial4j.shape.Rectangle;
        try (XContentParser parser = createParser(invalidMultipoint1)) {
            .endArray()
            .value(176.0)
            .value(10.0)
            .field("type", "GeometryCollection")
            .startArray("coordinates")
        }
 * specific language governing permissions and limitations
            .startArray()
            .startArray()
            .value(2.0)
        shellCoordinates.add(new Coordinate(100, 1, 10.0));
            parser.nextToken();
        holeCoordinates.add(new Coordinate(100.8, 0.2));
            new double[] { 100.8d, 100.8d, 100.2d, 100.2d, 100.8d },
    }
            .value(-177.0)
    public void testInvalidDimensionalPolygon() throws IOException {
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
        // test #4: "envelope" with empty coordinates
            .startArray()
    public void testParseOGCPolygonWithHoles() throws IOException, ParseException {
            .value(-15.0)
            .value(101.0)
            .startArray()
            .value(-15.0)
            .value(30)
            .endArray()
        shellCoordinates.add(new Coordinate(100, 1));
            .value(176.0)
    public void testParseCircle() throws IOException, ParseException {
            .startArray()
            .value(100.0)
            .startArray()
            .endArray()
        ));
            .startObject()
            .startArray()
            .value(15.0)
            .value(101.0)
            .value(-30)
            .value(0.2)
            .startArray()
            .value(40.753)
            .value(8.0)
            .value(3.0)
            assertNull(parser.nextToken());
            .startArray()
            .startArray()
            .endArray()
            parser.nextToken();
        org.opensearch.geometry.LinearRing luceneHole = new org.opensearch.geometry.LinearRing(
            .value(0.0)
            .startObject()
            .put(IndexMetadata.SETTING_VERSION_CREATED, randomVersion)
            .field("type", "envelope")
            .value(15.0)
            .toString();
    }
            .endArray()
            .startArray()
            .value(-50)
            .startObject()
            .endArray()
                                new double[] { -180d, -180d, -177d, -177d, -180d },
            .field("type", "polygon")
    }
            .endArray()
            .value(-178.0)
            .startArray("coordinates")
        assertGeometryEquals(jtsGeom(withHoles), multiPolygonGeoJson, true);
            .startArray()
            .endArray()
            .endArray()
        holes[0] = GEOMETRY_FACTORY.createLinearRing(holeCoordinates.toArray(new Coordinate[0]));
            .value(0.8)
            .field("type", "NotAPoint")
            .startArray()
        shellCoordinates.add(new Coordinate(100, 0, 10));
            .endArray()
        // test #3: "envelope" (actually a triangle) with invalid number of coordinates (TopRight, BottomLeft, BottomRight)
            .endArray()
    }
            .value(0.0)
            .value(176.0)
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .value(101.0)
            .value(0.8)
            .startArray()
    public void testParseOrientationOption() throws IOException, ParseException {
        Polygon withoutHoles = GEOMETRY_FACTORY.createPolygon(shell, null);
            .startArray()
                new Line(new double[] { 100d, 101d }, new double[] { 0d, 1d }),
        assertGeometryEquals(
            .value(-177.0)
            .startArray()
            .value(100.2)
            .startArray()
            .value(172.0)
            .value(-15.0)
        holeCoordinates.add(new Coordinate(100.8, 0.2));
            .endObject()
            .endArray()
import org.locationtech.jts.geom.LineString;
        // test 1: valid ccw (right handed system) poly not crossing dateline (with 'right' field)
        XContentBuilder geometryCollectionGeoJson = XContentFactory.jsonBuilder()
            .value(101.0)
            .endArray()
            .startObject()
            .value(176.0)
            .startArray()
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
            .startArray()
            parser.nextToken();
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
            .endArray()
            .startArray()
            .startArray()
import org.opensearch.core.xcontent.XContentParser;
        assertGeometryEquals(expected, multilinesGeoJson, true);
            .startArray()
            .value(-177.0)
            .endArray()
            .endArray()
            .endArray()
            .endArray()
            .value(-8.0)
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .value(100.0)
            parser.nextToken();
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            .value(-30)
            .value(0.0)
            .value(100.2)
            .endArray()
            .value(8.0)
            .endArray()
            parser.nextToken();
            .endArray()
            .value(50)
            .value(0.0)
        holeCoordinates.add(new Coordinate(100.8, 0.8));
            .endArray()
import java.util.Arrays;
            .endArray()
            .value(0.0)
            .startArray("coordinates")
                        new org.opensearch.geometry.Polygon(
            .value(0.0)
            .endArray()
            .endArray()
            .value(-8.0)
            .endObject();
            .field("name", "urn:ogc:def:crs:OGC:1.3:CRS84")
            .value(176.0)
            .value(-177.0)
            parser.nextToken();
            .value(-10.0)
    public void testParseEnvelope() throws IOException, ParseException {
            .startArray()
            .startArray()
            .startArray()
            .value(1.0)
            .value(15.0)
            .startObject()
        );
            .endArray()
            .value(103.0)
            .field("type", "Polygon")
    public void testParseInvalidGeometryCollectionShapes() throws IOException {
            parser.nextToken();
            .value(15.0)
                    Arrays.asList(
            .startArray()
            .value(8.0)
            .endArray()
            .value(1.0)
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .endArray()
            .value(-177.0)
            .endArray()
            .value(1.0)
            .endArray()
            .endArray()
                    )
            .endArray()
            new org.opensearch.geometry.LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 0d, 0d, 1d, 1d, 0d })
            parser.nextToken();
            .value(176.0)
        holeCoordinates.add(new Coordinate(100.8, 0.8));
 * GitHub history for details.
/**
            .value(10.0)
            .startObject()
            .value(15.0)
            .value(183.0)
            .value(176.0)
            OpenSearchGeoAssertions.assertPolygon(shape, true);
            .field("orientation", "right")
            .endArray()
            .startArray()
            .field("type", "MultiLineString")
            new Coordinate[] { new Coordinate(100, 0), new Coordinate(101, 1), }
            .startArray()
        }
            .startArray()
            .startArray()
            .endArray()
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }
            .value(8.0)
            .field("type", "polygon")
            .endArray()
            .value(176.0)
            parser.nextToken();
            .startArray("coordinates")
            .value(15.0)
                new org.opensearch.geometry.Polygon(
            )
            .endArray()
            .value(100.2)
            .value(-10.0)
        org.opensearch.geometry.Polygon p = new org.opensearch.geometry.Polygon(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .startArray()
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            .value(174.0)
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
            .startArray()
            .endArray()
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
            .value(0.0)
            .value(-15.0)
            .value(100.8)
            Arrays.asList(
            .endObject()
            .value(176.0)
    public void testParseInvalidDimensionalMultiPolygon() throws IOException {
            .value(-8.0)
            .value(1.0)
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .startArray()
            .endArray()
            .value(184.0)
            .endArray()
            .value(100.0)
            .startObject("nested")
            .endArray()
            .endObject();
            parser.nextToken();
            .value(0.0)
            .value(100.0)
            .startArray()
        ShapeCollection<?> expected = shapeCollection(SPATIAL_CONTEXT.makePoint(100, 0), SPATIAL_CONTEXT.makePoint(101, 1.0));
                            new org.opensearch.geometry.LinearRing(
            .startArray()
            .startArray()
            .endArray()
            .endArray()
            .endArray()
        XContentBuilder multilinesGeoJson = XContentFactory.jsonBuilder()
            .value(102.0)
            .value(8.0)
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
            .endObject()
            parser.nextToken();
            .startArray()
            .value(172.0)
            .startArray("coordinates")
            OpenSearchGeoAssertions.assertValidException(parser, IllegalArgumentException.class);
            .value(-15.0)
            .endArray() // geometries
            .startObject()
            .nullValue()
            .value(15.0)
            .value(0.0)
            .endArray()
            .startArray()
            .startArray()
            .endArray()
            .toString();
            .startArray()
            .startArray()
            .endArray()
            .startArray()
            .startArray("coordinates")
        assertGeometryEquals(geometryExpected, geometryCollectionGeoJson, false);
            .endObject();
 * Unless required by applicable law or agreed to in writing,
        Coordinate[] coordinates = shellCoordinates.toArray(new Coordinate[0]);
            .startArray()
            .value(-177.0)
 * You may obtain a copy of the License at
            .endArray()
            parser.nextToken();
            .value(-10.0)
            .value(0.0)
            .startArray()
            OpenSearchGeoAssertions.assertValidException(parser, IllegalArgumentException.class);
        assertGeometryEquals(new org.opensearch.geometry.Point(100d, 0d), pointGeoJson, false);
            .value(0.8)
            .endArray()
    }
            .value(3.0)
            .endArray()
        holeCoordinates.add(new Coordinate(100.2, 0.2));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .value(-177.0)
            .endArray()
            .endArray()
            .value(8.0)
            parser.nextToken();
            .value(100.0)
            .endArray()
            new double[] { 100.8d, 100.8d, 100.2d, 100.2d, 100.8d },
        // test 1: ccw poly not crossing dateline
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .startArray()
            .endArray()
    }
            .endArray()
            .field("type", "Polygon")
            .endArray()
        shellCoordinates.add(new Coordinate(100, 0));
            .endArray()
            .endObject()
            .value(-172.0)
    }
    public void testParsePolygon() throws IOException, ParseException {
            .field("type", "polygon")
    }
            .endArray()
        assertGeometryEquals(expectedPt, pointGeoJson, false);
            .endArray()
            .endArray()
            .endArray()
            .value(0.0)
            .startObject("coordinates")
            .startArray("coordinates")
 * Tests for {@code GeoJSONShapeParser}
        holeCoordinates.add(new Coordinate(100.2, 0.8));
            .startArray()
            .startArray()
        );
            .field("type", "Point")
            .value(0.0)
            .startArray()// second poly (with hole)
            .value(10.0)
            .endArray()
            .startArray()
        }
            .endArray()
            .startArray()
            .endArray()
            .endArray()
            .toString();
            .startArray() // hole
            .startArray()
        }
            parser.nextToken();
    public void testParseMultiLineString() throws IOException, ParseException {
        holes = new LinearRing[1];
            .startArray()
            .startArray()
            .value(-177.0)
        XContentParser parser = createParser(pointGeoJson);
            parser.nextToken();
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .startArray("coordinates")
        }
            .startObject()
            .value(100.0)
            .startArray()
            .endObject()
            .value(15.0)
        invalidPoly = XContentFactory.jsonBuilder()
            parser.nextToken();
            new LineString[] {
    }
            .field("type", "polygon")
    }
        // test 3: cw poly not crossing dateline
            .endArray()
import org.opensearch.geometry.GeometryCollection;
        shellCoordinates1.add(new Coordinate(176.0, 15.0));
            .value("24.722968774929")
            .startArray()
            .startArray()
        // test 2: ccw poly crossing dateline
            .endArray()
            .endObject();
    public void testParseInvalidMultipoint() throws IOException {
            .startArray()
        MultiLineString expected = GEOMETRY_FACTORY.createMultiLineString(
            parser.nextToken();
            .value(100.2)
            assertNull(parser.nextToken());
            .startArray()
            .startArray()
            .value(100.2)
            .value(-177.0)
        multilinesGeoJson = XContentFactory.jsonBuilder()
            .startArray()
        parser.nextToken();
        multilinesGeoJson = XContentFactory.jsonBuilder()
            .value(0.0)
            .value(10.0)
            .value(1.0)
            .startArray()
            .value(100.0)
            .endArray()
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .value(102.0)
            .endArray()
        XContentBuilder invalidPoint2 = XContentFactory.jsonBuilder()
                            )
            .value(176.0)
            .startArray()
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .endObject()
            .value(-177.0)
        );
import org.locationtech.spatial4j.shape.ShapeCollection;
            .value(100.8)
            .value(100.2)
            parser.nextToken();
            .value(1.0)
            .startArray()// one poly (with two holes)
        }
            .startArray()
            .startArray()
            .value(0.0)
            .endObject();
            .startArray()
            .field("type", "Point")
            .value(176.0)
            .startObject()
            .startArray("coordinates")
        // test case 3: create an invalid polygon with 0 points
            .startArray()
        XContentBuilder emptyPointGeoJson = XContentFactory.jsonBuilder()
            .field("type", "point")
        }
            .value(100.0)
            .value(8.0)
            .startArray()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .endObject();
            .startObject()
            .endArray()
            .startArray()
            .startArray("coordinates")
            .value(15.0)
            .startArray()
         */
        }
            .endArray()
        String polygonGeoJson = XContentFactory.jsonBuilder()
            .endArray()
            .endObject();
            .startArray()
            .startArray()
            .startArray("coordinates")
            parser.nextToken(); // start object
            .value(10.0)
        try (XContentParser parser = createParser(invalidMultipoint3)) {
            .endObject()
            .toString();
            .value(100.0)
            .endArray()
            .startArray()
        shellCoordinates1.add(new Coordinate(180.0, -12.142857142857142));
            .endArray()
            parser.nextToken();
            .startArray()
            .endArray()
            .endObject()
            .value(179.0)
        Point expected = GEOMETRY_FACTORY.createPoint(new Coordinate(100.0, 0.0));
            .value(10.0)
            .value(100.0)
            .field("type", "Polygon")
            .startArray()
            .endArray()
            .endArray()
 *
                )
            .startArray()
        org.opensearch.geometry.LinearRing hole = new org.opensearch.geometry.LinearRing(
            .value(102.0)
        shellCoordinates.add(new Coordinate(101, 0));
        List<Coordinate> lineCoordinates = new ArrayList<>();
            .startArray()
            .value(10.0)
            .startArray()
            .endArray()
            .endArray()
            .value(0.0)
        try (XContentParser parser = createParser(polygonGeoJson)) {
    @Override
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .endArray()
        );
            .startArray()
        List<Coordinate> holeCoordinates = new ArrayList<>();
            .value(0.0)
        shellCoordinates.add(new Coordinate(100, 0));
            OpenSearchGeoAssertions.assertPolygon(shape, true);
            .endArray()
            .startArray()
            parser.nextToken();
        shellCoordinates.add(new Coordinate(101, 1));
            .endObject();
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .startArray()
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            .value(15.0)
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));
            .field("type", "geometrycollection")
            .endArray()
            .endArray()
            .value(0.0)
        }
            .value(0.0)
            .value(1.0)
            .value(10.0)
            .value(2.0)
            .startArray()
            .endArray()
            .startArray()
            .startArray()
            .startArray()
            .startArray()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .startArray()
            .endArray()
            .startArray()
 */
/*
        // test self crossing ccw poly not crossing dateline
            .startArray()
            .startObject()
            .endArray()
            .startArray()
            .value(1.0)
            .endArray()
            assertNull(parser.nextToken());
            .value(100.0)
        // test case 5: create an invalid polygon with 1 invalid LinearRing
            .startArray()
            .value(10.0)
            assertNull(parser.nextToken());
            Collections.singletonList(luceneHole)
            .value(1.0)
            .startArray()
            .nullValue()
            .value(102.0)
            .endArray()
            .value(1.0)
    public void testParseOGCPolygonWithoutHoles() throws IOException, ParseException {
            .value(-15.0)
            .value(176.0)
            .value(-178.0)
            .endArray()
        // test 4: cw poly crossing dateline
        );
        shellCoordinates.add(new Coordinate(100, 0, 15.0));
        ArrayList<Coordinate> shellCoordinates1 = new ArrayList<>();
            .endObject();
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }
            .value(100.0)
            parser.nextToken();
            .value(10.0)
}
            .value(1.0)
            parser.nextToken();
        // test 2: ccw poly crossing dateline
        LinearRing[] holes = new LinearRing[1];
            .startArray()
        shellCoordinates.add(new Coordinate(102, 3));
            .endArray()
            .endArray()
            .value(180.0)
            .startArray()
            .value(-8.0)
            .endObject()
            .startArray()
            .startArray()
            .startArray("coordinates")
            .endArray()
            .value(176.0)
            .field("type", "envelope")
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .endArray()
        shellCoordinates1.add(new Coordinate(172.0, 0.0));
            .endArray()
            Shape shape = ShapeParser.parse(parser).buildS4J();
import org.opensearch.common.geo.parsers.ShapeParser;
            .value(180.0)
            .endObject();
            .value(18.0)
            .endArray()
            .value(15.0)
        }
        // test #1: envelope with expected coordinate order (TopLeft, BottomRight)
    }
            .toString();
            .endArray()
            .startArray()
import org.opensearch.index.mapper.Mapper;
            .startObject()
            .startArray()
            .endArray()
            .value(10.0)
        assertGeometryEquals(jtsGeom(expected), multilinesGeoJson, true);
            .endArray()
        }
        );
        holeCoordinates.add(new Coordinate(100.8, 0.8));
            .startObject()
            .startArray()
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .value(100.0)
        polygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .value(0.8)
            .value(174.0)
            .startArray()
            .value(8.0)
                    new Line(new double[] { 102d, 103d }, new double[] { 2d, 3d })
            parser.nextToken();
        polygonGeoJson = XContentFactory.jsonBuilder()
            .value(172.0)
            .startArray()
            .startObject()
 * the Apache License, Version 2.0 (the "License"); you may
        shellCoordinates2.add(new Coordinate(-180.0, -12.142857142857142));
            .startArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, multiPolygonGeoJson)) {
            .endObject();
            .field("type", "envelope")
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
            .value(100.2)
import java.util.Collections;
            .endArray()
            .startArray()
            .endArray()
            .endArray()
            .value(0.0)
                    ),
            .endArray()
            .endArray()
            .value(100.8)
            .endArray()
        // test #2: envelope that spans dateline
        shellCoordinates.add(new Coordinate(101, 1));
 * not use this file except in compliance with the License.
            .endArray()
                GEOMETRY_FACTORY.createLineString(new Coordinate[] { new Coordinate(102, 2), new Coordinate(103, 3), }), }
            Shape shape = ShapeParser.parse(parser).buildS4J();
        shellCoordinates.add(new Coordinate(100, 1));
            .value(10.0)
            .value(100.0)
            .endArray()
            .value(8.0)
            .value(1.0)
import org.opensearch.geometry.MultiLine;
            .endObject();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .value(1.0)
        try (XContentParser parser = createParser(multilinesGeoJson)) {
        parser = createParser(lineGeoJson);
            .value(8.0)
            parser.nextToken();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .startArray("coordinates")
            .startArray("coordinates")
        polygonGeoJson = XContentFactory.jsonBuilder()
        polygonGeoJson = XContentFactory.jsonBuilder()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .value(-74.011)
            .endArray()
            .endArray()
            .endArray()
            .startArray()
            .value(180.0)
        XContentBuilder invalidPoint1 = XContentFactory.jsonBuilder()
            .endArray()
            .startObject()
            new org.opensearch.geometry.LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 0d, 0d, 1d, 1d, 0d }),
            .endArray()
            .value(102.0)
            .endArray()
            .value(179.0)
            parser.nextToken();
            .startObject()
            .startArray("coordinates")
            .value(0.2)
            .value(40.753)
            new double[] { 0.8d, 0.2d, 0.2d, 0.8d, 0.8d }
            .endArray()
        parser.nextToken();
        assertGeometryEquals(p, polygonGeoJson, false);
            .value(-10.0)
            .value(-177.0)
            .value(-177.0)
            .startArray()
            .value(0.0)
        LinearRing shell1 = GEOMETRY_FACTORY.createLinearRing(shellCoordinates1.toArray(new Coordinate[0]));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // single dimensions point
            .value(100.8)
            .endArray()
            .value(10.0)
            .startObject()
            .endObject()
        shellCoordinates.add(new Coordinate(102, 3));
            .value(0.2)
            .endArray()
    public void testParseMultiPoint() throws IOException, ParseException {
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        assertGeometryEquals(jtsGeom(expected), polygonGeoJson, true);
            .startArray("coordinates")
            .startArray()
            .value(15.0)
            .endArray()
            .value(0.2)
            OpenSearchGeoAssertions.assertPolygon(shape, true);
            .endArray()
            .endObject()
        LinearRing shell2 = GEOMETRY_FACTORY.createLinearRing(shellCoordinates2.toArray(new Coordinate[0]));
            .value(-15.0)
/*
            .value(103.0)
    }
            .endArray()
            .value(101.0)
            .endArray()
    }
            .value(15.0)
            .endArray()
            .value(101.0)
    }
import org.locationtech.spatial4j.shape.jts.JtsPoint;
        }
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .endArray()
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .endArray()
        }
            .value(100.0)
        }
            .build(mockBuilderContext));
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
        XContentBuilder invalidMultipoint2 = XContentFactory.jsonBuilder()
            .startArray()
            .startArray("coordinates")
            .startArray()
            parser.nextToken();
            .field("type", "polygon")
        // test invalid multipolygon (an "accidental" polygon with inner rings outside outer ring)
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());
            .endArray()
            .startArray()
            .endObject();
        assertGeometryEquals(new org.opensearch.geometry.Rectangle(50, -50, 30, -30), multilinesGeoJson, false);
            .startArray()
            .endArray()
            .value(8.0)
            .value(2.0)
            .startArray()
        org.opensearch.geometry.Polygon lucenePolygons = (new org.opensearch.geometry.Polygon(
            .value(10.0)
        );
            Shape shape = ShapeParser.parse(parser).buildS4J();
                        new double[] { 2d, 3d, 3d, 2d, 2d }
        try (XContentParser parser = createParser(tooLittlePointGeoJson)) {
            .endArray()
        // test 3: valid ccw (right handed system) poly not crossing dateline (with 'counterclockwise' field)
            .value(102.0)
            .field("type", "Polygon")
        List<Coordinate> holeCoordinates = new ArrayList<>();
            .startArray()
        XContentBuilder polygonGeoJson = XContentFactory.jsonBuilder()
            .value(172.0)
 * compatible open source license.
            .endObject()
            .startArray()
            .field("type", "MultiPolygon")
            .value(-50)
            .endArray()
            .value(178.0)
            .endArray()
            .endArray()
            .value(0.2)
        }
        );
        invalidPoly = XContentFactory.jsonBuilder()
        }
        shellCoordinates2.add(new Coordinate(-177.0, 10.0));
        holeCoordinates.add(new Coordinate(100.2, 0.8));
            .endArray()
            Shape shape = ShapeParser.parse(parser).buildS4J();
        polygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .startArray()
            .startArray("geometries")
            .startObject()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
                GEOMETRY_FACTORY.createLineString(new Coordinate[] { new Coordinate(100, 0), new Coordinate(101, 1), }),
            .value(100.8)
import java.util.ArrayList;
 * under the License.
            .startArray("coordinates")
            .endArray()
        // test case 7: create an invalid polygon with 0 LinearRings
            .endArray()
            .value(-10.0)
            .value(-177.0)
    }
            parser.nextToken();
        shellCoordinates.add(new Coordinate(100, 0));
            .value(50)
            .endObject();
            .value(-10.0)
            .value(100.0)
            .endArray()
            .field("type", "MultiPoint")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidPoly)) {
            .endObject()
            .startArray()
        org.opensearch.geometry.Polygon p = new org.opensearch.geometry.Polygon(
        );
            .endArray()
            .field("type", "Polygon")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .endArray()
            .value(178.0)
        XContentBuilder lineGeoJson = XContentFactory.jsonBuilder()
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
            .value(-172.0)
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, null);
            .endArray()
            .endArray()
        polygonGeoJson = XContentFactory.jsonBuilder()
            .endArray()
            .value(101.0)
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .startObject()
            .value(176.0)
        // test 1: ccw poly not crossing dateline
            .endArray()
            parser.nextToken();
            .endArray()
            .toString();
            .nullValue()
            .value(100.2)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .endArray()
            .endArray()
            .startArray()
            .value(102.0)
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .value(10.0)
            .value(172.0)
            .startObject()
            .startArray()
            .endArray()
            .toString();
            .endObject();
            .field("orientation", "clockwise")
            .startArray()
            .startArray()
            .value(100.0)
            .startArray()
          The following 3 test cases ensure proper error handling of invalid polygons
            OpenSearchGeoAssertions.assertPolygon(shape, true);
            .value(40.753)
            .value(-10.0)
                Arrays.stream(coordinates).mapToDouble(i -> i.x).toArray(),
            .value(15.0)
            assertNull(parser.nextToken());
            .endArray()
            .value(-8.0)
            .field("type", "Polygon")
        }
        }
        shellCoordinates2.add(new Coordinate(-180.0, 12.142857142857142));
            .startArray("coordinates")
            .startArray()
            .startArray("coordinates")
            .value(101.0)
import org.opensearch.common.settings.Settings;
            .value(40.753)
            .value(-15.0)
            .value(3.0)
            .value(176.0)
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
            .value(15.0)
            .endArray()
package org.opensearch.common.geo;
            .startArray()
            .field("type", "multipoint")
                                new double[] { 12.142857142857142d, -12.142857142857142d, -10d, 10d, 12.142857142857142d }
            .value(101.0)
            .endArray()
        String polygonGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .endArray()
            .value(0.0)
            assertNull(parser.nextToken());
            .startArray()
        // zero dimensions point
            .toString();
            .startArray()
            .endObject();
            .endArray()
            ),
            .value(8.0)
            .endObject()
        shellCoordinates = new ArrayList<>();
        // test 4: cw poly crossing dateline
            .endArray()
            parser.nextToken();
        assertGeometryEquals(p, polygonGeoJson, false);
            .startArray()
            .endArray()
            .startArray()
        expected[1] = new JtsPoint(expectedPoint, SPATIAL_CONTEXT);
            .startArray()
        shellCoordinates.add(new Coordinate(100, 1));
            .endArray()
    }
            .value(0.0)
            .value(0.0)
            .startArray("coordinates")
            .endArray()
            .value(100.0)
            .value(177.0)
import org.opensearch.index.mapper.ContentPath;
            .value(8.0)
        shellCoordinates.add(new Coordinate(100, 0, 10));
            .startArray()
            .startArray("coordinates")
    public Geometry parse(XContentParser parser) throws IOException, ParseException {
            .endObject();
            .endArray()
            .endArray()
                    )
        shellCoordinates.add(new Coordinate(100, 1, 10));
            .startArray()
        // test case 2: create an invalid point object with an empty number of coordinates
            .value(41.783)
            .startArray()
            .value(176.0)
            .value(178.0)
            .value(100.0)
            .startArray()
            .value(1.0)
            .startArray()
            .endArray()
            parser.nextToken();
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .field("foo", "bar")
            .endArray()
            .value(10.0)
            .field("type", "Polygon")
            .value(0.2)
            .value(-172.0)
            .value(3.0)
            .endArray()
            .startArray()
 * Modifications Copyright OpenSearch Contributors. See
            .endArray()
            .value(10.0)
        assertNull(parser.nextToken());
            .endArray()
            .endObject();
            .field("type", "LineString")
            .endArray()
        // to a simple polygon (jtsGeom)
            OpenSearchGeoAssertions.assertPolygon(shape, true);
    public void testParseInvalidMultiPolygon() throws IOException {
            .value(101.0)
            .startArray("coordinates")
            .startArray()
            .value(0.0)
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .startArray()
            .endArray()
        // test case 4: create an invalid polygon with null value points
            .endArray()
            .endArray()
        );
            .endObject()
            .startArray("coordinates")
            .value(102.0)
            .startObject()
            assertNull(parser.nextToken());
        holeCoordinates.add(new Coordinate(100.2, 0.8));
            .endArray()
            .startArray("coordinates")
    public void testParseGeometryCollection() throws IOException, ParseException {
        holeCoordinates.add(new Coordinate(100.8, 0.2));
            .endObject()
        Coordinate[] coordinates = shellCoordinates.toArray(new Coordinate[0]);
            .endObject();
            .value(176.0)
        shellCoordinates1.add(new Coordinate(176.0, -15));
            Arrays.asList(
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            assertNull(parser.nextToken());
            parser.nextToken();
        shellCoordinates.add(new Coordinate(103, 2));
        shellCoordinates1.add(new Coordinate(180.0, -12.142857142857142));
            .startArray("coordinates")
        holeCoordinates.add(new Coordinate(100.2, 0.2));
            parser.nextToken();
            .endArray()
            assertNull(parser.nextToken());
            .startArray()
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .startArray()
        }
            .endObject()
            .value(15.0)
            new Polygon[] { GEOMETRY_FACTORY.createPolygon(shell1), GEOMETRY_FACTORY.createPolygon(shell2) }
            .value(8.0)
            .endArray()
            .endArray()
            parser.nextToken();
            .endArray()
            .startObject()
        Point expected = GEOMETRY_FACTORY.createPoint(new Coordinate(100.0, 0.0));
            .value(176.0)
            .value(8.0)
            .value(100.2)
            .startObject()
            .startObject()
            .startArray()
            .endArray()
            .startArray()
            .value(15.0)
                Arrays.asList(
        }
            .endArray()
        assertGeometryEquals(new org.opensearch.geometry.Rectangle(-50, 50, 30, -30), multilinesGeoJson, false);
            .endArray()
        polygonGeoJson = XContentFactory.jsonBuilder()
            .startObject()
            .startObject()
            .startObject("foo")
    public void testParseSelfCrossingPolygon() throws IOException {
            .endArray()
        // test invalid multipolygon (an "accidental" polygon with inner rings outside outer ring)
                new org.opensearch.geometry.Point(102d, 2d),
            .startArray()
            .value(176.0)
            .endArray()
import org.locationtech.jts.geom.MultiLineString;
        XContentBuilder invalidPoints = XContentFactory.jsonBuilder()
            .startArray()
        }
            .endArray()
            .endArray()
    @Override
        }
            .endArray()
            .startObject()
            .startArray()
            .field("type", "polygon")
            .value(15.0)
            .endArray()
            .startArray()
            .endArray()
            .endObject();
            .endArray()
            .endArray()
            .value(172.0)
            .value(8.0)
        }
            .value(0.0)
            .value(178.0)
            .startArray("coordinates")
            .value(10.0)
                        )
            .endArray()
        shellCoordinates.add(new Coordinate(101, 1));
            .startArray()
            .value(101.0)
        }
            .value(-172.0)
            .value(100.0)
            .startArray("coordinates")
            .field("type", "Point")
            .startArray()
            .endArray()
    public void testThatParserExtractsCorrectTypeAndCoordinatesFromArbitraryJson() throws IOException, ParseException {
 * license agreements. See the NOTICE file distributed with
            .endObject()
            .value(0.0)
        Circle expected = SPATIAL_CONTEXT.makeCircle(100.0, 0.0, 360 * 100 / GeoUtils.EARTH_EQUATOR);
        shellCoordinates.add(new Coordinate(101, 1, 10));
            .value(102.0)
            .value(1.0)
            .endArray()
            .value(100.0)
    }
            .startArray()
            .startArray()
            .value(50)
            .endArray()
            .endArray()
            .endObject()
            .value(10.0)
import org.opensearch.common.xcontent.XContentFactory;
            .endObject();
            .startArray()
            .startArray()
            .startArray()
            .startObject()
            .value(183.0)
        holeCoordinates.add(new Coordinate(100.2, 0.2));
            .startArray()
        polygonGeoJson = XContentFactory.jsonBuilder()
        holeCoordinates.add(new Coordinate(100.2, 0.8));
            .value(176.0)
        expected[2] = jtsGeom(expectedMultiPoly);
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .endArray()
            .startArray()
            .startArray()
            .startArray()
            .value(8.0)
            .endArray()
        }
            .value(172.0)
            .startArray()
            .value(-15.0)
            .startArray()
            .startArray()
            .value(1.0)
            .endObject()
            .value(100.0)
        }
    public void testParseInvalidPolygon() throws IOException {
        polygonGeoJson = XContentFactory.jsonBuilder()
    public void testParse3DPolygon() throws IOException, ParseException {
            .value(10.0)
            .value(-10.0)
                        new double[] { 101d, 101d, 100d, 100d, 101d },
            .toString();
            .value(176.0)
            .startArray()// second hole
            .field("bubu", "foobar")
            .startArray()
            OpenSearchGeoAssertions.assertPolygon(shape, true);
                        new org.opensearch.geometry.Polygon(
            .value(0.8)
            parser.nextToken();
            .endArray()
            .value(100.8)
            .value(0.8)
            .startArray("coordinates")
            .value(172.0)
            .endArray()
            .value(15.0)
            .endArray()
            .startObject()
            .endArray()
            .startArray()
            .startObject()
        org.opensearch.geometry.LinearRing hole = new org.opensearch.geometry.LinearRing(
            .endArray()
            .endArray()
            .endArray()
            .value(103.0)
            .value(180.0)
            .value(0.0)
            parser.nextToken();
            .endObject();
        holes[0] = GEOMETRY_FACTORY.createLinearRing(holeCoordinates.toArray(new Coordinate[0]));
            .field("type", "MultiPolygon")
            .endArray()
            .endArray()
            .endArray()
            .value(10.0)
        String polygonGeoJson = XContentFactory.jsonBuilder()
            parser.nextToken();
            .startObject("crs")
            .startArray()
            .field("type", "Polygon")
        polygonGeoJson = XContentFactory.jsonBuilder()
            .value(174.0)
            .value(100.8)
    }
            .value(101.0)
            .startArray()
            .value(0.0)
            .startArray()
            .endArray()
            .startArray()
            .endObject()
            .value(-177.0)
            .endArray()
            .value(2.0)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .endArray()
            .value(-15.0)
            .startArray()
            .value(-10.0)
        assertGeometryEquals(
            .startArray("coordinates")
            .field("type", "Polygon")
            .endArray()
            .value(30)
            .startObject("lala")
        }
            .startArray()// first poly (without holes)
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .endArray()
        shellCoordinates1.add(new Coordinate(180.0, 12.142857142857142));
            .startArray()
        }
            .value(-177.0)
            .value(172.0)
            .value(-74.011)
            parser.nextToken();
            .endArray()
            .value(0.0)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .value(1.0)
            .endArray()
            .value(0.8)
            false
        }
            .endArray()
        // test 4: valid cw (left handed system) poly crossing dateline (with 'left' field)
        // test 3: cw poly not crossing dateline
import org.locationtech.jts.geom.Coordinate;
            .startArray()
                    new org.opensearch.geometry.LinearRing(
            .value(0.0)
        List<Coordinate> shellCoordinates = new ArrayList<>();
            .value(10.0)
            .endArray()
            .endArray()
            .value(1.0)
            .endObject();
        MultiPolygon expectedMultiPoly = GEOMETRY_FACTORY.createMultiPolygon(
            .value(-8.0)
            .value(176.0)
            .value(101.0)
        Settings indexSettings = Settings.builder()
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
 * Licensed to Elasticsearch under one or more contributor
            .field("type", "Polygon")
        }
            .value(15.0)
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .startArray("coordinates")
            false
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
            .value(-10.0)
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .startObject()
            .startArray()
            .value(100.8)
            .value(-177.0)
        Version randomVersion = VersionUtils.randomIndexCompatibleVersion(random());
            .value(172.0)
            .value(-8.0)
        OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
                        new double[] { 0d, 1d, 1d, 0d, 0d }
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
            .value(100.0)
            parser.nextToken();
            .value(178.0)
            .value(101.0)
        try (XContentParser parser = createParser(polygonGeoJson)) {
        assertGeometryEquals(new JtsPoint(expected, SPATIAL_CONTEXT), pointGeoJson, true);
            .startArray()
            assertNull(parser.nextToken());
            .startArray()
            .value(3.0)
            .value(176.0)
    }
            .value(10.0)
            multilinesGeoJson,
        shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));
            .field("type", "point")
        shellCoordinates = new ArrayList<>();
            .startArray()
        expected[0] = jtsGeom(expectedLineString);
            .endArray()
            .value(15.0)
            .value(100.0)
        Rectangle expected = SPATIAL_CONTEXT.makeRectangle(-50, 50, -30, 30);
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .startArray()
            .value(101.0)
            .endArray()
            .endArray()
    public void testParseInvalidPoint() throws IOException {
            .startArray()
            .endArray()
            .endArray()
            .endObject()
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .startArray()
    }
            .endArray()
            .endArray()
            .endArray()
        shellCoordinates.add(new Coordinate(101, 0));
            .value(101.0)
        XContentBuilder invalidMultipoint3 = XContentFactory.jsonBuilder()
        String multiPolygonGeoJson = XContentFactory.jsonBuilder()
            .endArray()
            .value(176.0)
        try (XContentParser parser = createParser(emptyPointGeoJson)) {
                    Collections.singletonList(hole)
            .ignoreZValue(true)
            multiPointGeoJson,
            .endObject()
            .startArray()
        shellCoordinates.add(new Coordinate(101, 0));
            .endArray()
            .endArray()
            .value(8.0)
            .value(15.0)
            .value(100.2)
        invalidPoly = XContentFactory.jsonBuilder()
            .value("24.7237442867977")
            .value(10.0)
            .startObject()
            .endArray()
            .value(-10.0)
            .value(176.0)
            .endArray()
            OpenSearchGeoAssertions.assertValidException(parser, OpenSearchParseException.class);
            .field("type", "polygon")
        holeCoordinates.add(new Coordinate(100.2, 0.2));
import org.opensearch.core.xcontent.XContentBuilder;
import org.locationtech.jts.geom.LinearRing;
            .value(176.0)
            .field("type", "Polygon")
            .value(176.0)
            .startArray()
            .value(178.0)
            .endArray()
            .startArray()
            .value(10.0)
            .startArray()
            .value(176.0)
            .value(177.0)
            .startArray()
            .value(-172.0)
            Shape shape = ShapeParser.parse(parser).buildS4J();
        XContentBuilder tooLittlePointGeoJson = XContentFactory.jsonBuilder()
            .startArray()
            .startObject()
        invalidPoly = XContentFactory.jsonBuilder()
            .endArray()
            .endArray()
            .endArray()
            .startArray("coordinates")
 * KIND, either express or implied.  See the License for the
            .endArray()
            .value(-15.0)
                                new double[] { 180d, 180d, 176d, 172d, 176d, 180d },
        shellCoordinates2.add(new Coordinate(-180.0, 12.142857142857142));
        try (XContentParser parser = createParser(invalidPoint1)) {
        assertGeometryEquals(p, polygonGeoJson, false);
            .startArray()
            .value(100.0)
            .value(176.0)
        }
            .endArray()
            .value(1.0)
            .endArray()
            .endObject();
            .startArray()
        }
            .endArray()
            .endArray()
import org.locationtech.jts.geom.Polygon;
            .startArray()
            .endArray()
            .startArray("coordinates")
        expected = SPATIAL_CONTEXT.makeRectangle(50, -50, -30, 30);
            .startObject()
            .value(179.0)
            .startObject()
            .startArray("coordinates")
            .endObject()
        LinearRing[] holes = new LinearRing[1];
            .startArray()
        polygonGeoJson = XContentFactory.jsonBuilder()
            .value(-177.0)
            .endArray()
            .startArray()
            .startArray()
    public void testParseLineString() throws IOException, ParseException {
            .value(-10.0)
            .endArray() // coordinates
        XContentBuilder pointGeoJson = XContentFactory.jsonBuilder()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, polygonGeoJson)) {
 *
            .startArray()
            .startArray()
            .startArray()// hole
        try (XContentParser parser = createParser(invalidMultipoint2)) {
            OpenSearchGeoAssertions.assertMultiPolygon(parse(parser), false);
            .value(-177.0)
            .value(0.2)
            .value(-74.011)
            .value(0.0)
            .value(176.0)
            .startArray()
            .startArray("coordinates")
        org.opensearch.geometry.Point expectedPt = new org.opensearch.geometry.Point(100, 0);
            .value(-177.0)
        shellCoordinates.add(new Coordinate(101, 0));
            .endArray()
            .startArray()
            new org.opensearch.geometry.LinearRing(new double[] { 100d, 101d, 101d, 100d, 100d }, new double[] { 0d, 0d, 1d, 1d, 0d }),
            .endObject();
            .value(-172.0)
        }
            .value(10.0)
            .endArray()
        String invalidPoly = XContentFactory.jsonBuilder()
            .endArray()
            .startArray()
            .startArray()
            OpenSearchGeoAssertions.assertMultiPolygon(shape, true);
        Shape[] expected = new Shape[3];
        // multi dimension point
            .field("orientation", "cw")
        List<Coordinate> shellCoordinates = new ArrayList<>();
            Shape shape = ShapeParser.parse(parser).buildS4J();
            .startArray()
        assertGeometryEquals(expected, multiPointGeoJson, true);
 * software distributed under the License is distributed on an
            .endObject();
            .value(10.0)
            .endArray()
            .value(102.0)
            .startArray()
            .endArray()
            .value(0.8)
            .value(1.0)
            .value(50)
            .value(1.0)
            .endArray()
            .startArray()
            .startArray()
        org.opensearch.geometry.MultiPolygon polygons = new org.opensearch.geometry.MultiPolygon(
import java.text.ParseException;
            .value(2.0)
        Point expectedPoint = GEOMETRY_FACTORY.createPoint(new Coordinate(102.0, 2.0));
            .startArray("coordinates")
        try (XContentParser parser = createParser(polygonGeoJson)) {
            .endObject();
        final LegacyGeoShapeFieldMapper mapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")
            .startArray()
            .value(10.0)
            assertNull(parser.nextToken());
        String multiPolygonGeoJson = XContentFactory.jsonBuilder()
            .startObject()
            .field("type", "multipoint")
            OpenSearchGeoAssertions.assertPolygon(parse(parser), false);
    @Override
            .value(100.0)
