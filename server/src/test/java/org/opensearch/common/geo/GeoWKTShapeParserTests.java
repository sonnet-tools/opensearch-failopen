        assertExpected(jtsGeom(expected), polygonWithHole, true);  
        List<Coordinate> coordinates = new ArrayList<>(numPoints);  
import org.opensearch.geometry.Geometry;
            builder.linestring(new LineStringBuilder(lsc));  
            shapes[i] = SPATIAL_CONTEXT.makePoint(c.x, c.y);
import org.apache.lucene.tests.geo.GeoTestUtil;  
        // malformed points in a polygon is a common typo
        List<Coordinate> shellCoordinates = new ArrayList<>();  
        final LegacyGeoShapeFieldMapper coercingMapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")  
            shapes[i] = GEOMETRY_FACTORY.createPolygon(shell, null);
        shellCoordinates.add(new Coordinate(100, 1));
        PolygonBuilder builder = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));  
        shellCoordinates.add(new Coordinate(101, 0));
        shellCoordinates.add(new Coordinate(100, 1));
        holeCoordinates.add(new Coordinate(100.2, 0.2));  
        holeCoordinates.add(new Coordinate(100.8, 0.8));
        int numLineStrings = randomIntBetween(0, 8);
        assertMalformed(actual);
        assertExpected(new org.opensearch.geometry.Point(p.lon(), p.lat()), new PointBuilder().coordinate(c), false);
    public void testMalformedWKT() throws IOException {  
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());  
        holeCoordinates.add(new Coordinate(100.2, 0.2, 15.0));  
            // malformed - extra paren
        assertExpected(jtsGeom(expected), new LineStringBuilder(coordinates), true);
        for (int j = 0; j < lineStrings.size(); ++j) {
        // add 3d point to test ISSUE #10501
        final LegacyGeoShapeFieldMapper defaultMapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")  
import org.opensearch.common.geo.builders.PolygonBuilder;
            .build(mockBuilderContext));
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        XContentBuilder builder = XContentFactory.jsonBuilder().value(poly.toWKT());
        Point expected = GEOMETRY_FACTORY.createPoint(c);  
        // add 3d point to test ISSUE #10501
            lats[i] = coordinates.get(i).y;  
    }  
 * license agreements. See the NOTICE file distributed with
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final GeoShapeFieldMapper mapperBuilder = (GeoShapeFieldMapper) (new GeoShapeFieldMapper.Builder("test").ignoreZValue(false)  
                assertEquals(shapeCollection(expected).isEmpty(), builder.buildGeometry().size() == 0);
            OpenSearchParseException.class,
        shellCoordinates.add(new Coordinate(101, 1, 0));
            .ignoreZValue(true)
    }
import org.opensearch.OpenSearchParseException;
        holeCoordinates.add(new Coordinate(100.2, 0.8, 10.0));  
            coordinates = pb.coordinates()[0][0];  
import java.util.ArrayList;  
    @Override
        GeoPoint p;
        assertNotNull(shapeBuilder);
        EnvelopeBuilder builder = new EnvelopeBuilder(new Coordinate(r.minLon, r.maxLat), new Coordinate(r.maxLon, r.minLat));
        }
        shellCoordinates.add(new Coordinate(100, 0));
import org.opensearch.common.geo.parsers.ShapeParser;
import static org.opensearch.common.geo.builders.ShapeBuilder.SPATIAL_CONTEXT;
        PolygonBuilder builder = PolygonBuilder.class.cast(
            .build();  
                assertEquals(shapeCollection(expected).isEmpty(), builder.buildS4J().isEmpty());  
        holeCoordinates.add(new Coordinate(100.2, 0.2));
            expectedGeom = new Line(lines.get(0).getX(), lines.get(0).getY());  
import org.locationtech.jts.geom.Point;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.geo.builders.EnvelopeBuilder;
        Coordinate c = new Coordinate(p.lon(), p.lat());
        List<Coordinate> holeCoordinates = new ArrayList<>();
        assertExpected(p, polygonWithHole, false);
 * Licensed to Elasticsearch under one or more contributor  
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().value(builder.toWKT());  
            .build(mockBuilderContext));
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, holes);
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        shellCoordinates.add(new Coordinate(101, 0));
        holeCoordinates.add(new Coordinate(100.8, 0.8));
 */
        );
            assertExpected(gcb.buildS4J(), gcb, true);  
            coordinates.add(new Coordinate(GeoTestUtil.nextLongitude(), GeoTestUtil.nextLatitude()));
            // TODO generate more malformed WKT  
    }
import org.opensearch.geometry.MultiPoint;
            expectedGeom = new MultiLine(lines);
    }  
            wkt = "# " + wkt + "\n" + wkt;
        assertThat(e, hasToString(containsString("unable to add coordinate to CoordinateBuilder: coordinate dimensions do not match")));  
        LineString expected = GEOMETRY_FACTORY.createLineString(coordinates.toArray(new Coordinate[0]));  
        shellCoordinates.add(new Coordinate(176, 15));
            new org.opensearch.geometry.LinearRing(new double[] { 101d, 101d, 100d, 100d, 101d }, new double[] { 0d, 1d, 1d, 0d, 0d }),
import org.opensearch.index.mapper.GeoShapeIndexer;
import static org.hamcrest.Matchers.hasToString;
            .build();  
        Settings indexSettings = Settings.builder()
    public void testParseMultiPoint() throws IOException, ParseException {
import static org.hamcrest.Matchers.containsString;  
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
 */
        List<LineString> lineStrings = new ArrayList<>(numLineStrings);  
            new double[] { 0.8d, 0.8d, 0.2d, 0.2d, 0.8d }
    }
        assertEquals("polygon ((100.0 5.0, 100.0 10.0, 90.0 10.0, 90.0 5.0, 100.0 5.0))", shapeBuilder.toWKT());
        Polygon[] shapes = new Polygon[numPolys];
import org.opensearch.test.geo.RandomShapeGenerator;
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> ShapeParser.parse(parser, mapperBuilder));
            shell = GEOMETRY_FACTORY.createLinearRing(coordinates);
        Shape expected = shapeCollection(shapes);
 * this work for additional information regarding copyright
public class GeoWKTShapeParserTests extends BaseGeoParsingTestCase {  
import org.opensearch.geometry.MultiLine;
        PolygonBuilder pb;
        }  
    }  
        XContentBuilder xContentBuilder = toWKTContent(builder, true);
        for (int i = 0; i < numPoints; ++i) {
        parser.nextToken();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.common.geo.builders.MultiPointBuilder;
        return XContentFactory.jsonBuilder().value(wkt);
        for (int i = 0; i < numPolys; ++i) {  
import org.opensearch.common.geo.parsers.GeoWKTParser;
        } else if (lines.size() == 1) {
    }  
    }  
        Coordinate[] coords = builder.coordinates()[0][0];
        builder.hole(new LineStringBuilder(holeCoordinates));
        assertExpected(new org.opensearch.geometry.Rectangle(r.minLon, r.maxLon, r.maxLat, r.minLat), builder, false);
    }
    @Override  
import org.opensearch.common.xcontent.XContentFactory;
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        shellCoordinates.add(new Coordinate(100, 0, 5));  
 * Unless required by applicable law or agreed to in writing,
            new double[] { 100.2d, 100.8d, 100.8d, 100.2d, 100.2d },  
        Geometry expectedGeom;
        }
        shellCoordinates.add(new Coordinate(100, 0));
            .coerce(false)
 * the Apache License, Version 2.0 (the "License"); you may
        } else if (numPoints == 1) {
 *
        final LegacyGeoShapeFieldMapper mapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")  
        parser.nextToken();  
        assertMalformed(builder);  
        assertExpected(expected, builder, true);
 * not use this file except in compliance with the License.
            .build();
import java.util.List;  
        assertValidException(xContentBuilder, OpenSearchParseException.class);
            GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());
        PolygonBuilder polygonWithHole = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));
        }  
import java.util.Collections;
    }  
    }
        MultiPolygonBuilder builder = new MultiPolygonBuilder();
import org.opensearch.common.geo.builders.ShapeBuilder;  
        for (int i = 0; i < lats.length; ++i) {
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> ShapeParser.parse(parser, mapperBuilder));
        for (int i = 0; i < numPoints; ++i) {
        shellCoordinates.add(new Coordinate(101, 1));  
        for (int j = 0; j < numLineStrings; ++j) {
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
        shellCoordinates.add(new Coordinate(100, 0, 0));
            builder.polygon(pb);
        assertMalformed(new PointBuilder().coordinate(c));  
        }  
        if (rarely()) {
        XContentParser parser = createParser(xContentBuilder);
            actual = new MultiPointBuilder();  
        final LegacyGeoShapeFieldMapper mapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")
        String openPolygon = "POLYGON ((100 5, 100 10, 90 10, 90 5))";
 * GitHub history for details.
import org.opensearch.common.UUIDs;
        shellCoordinates.add(new Coordinate(100, 0));
        assertExpected(jtsGeom(expected), builder, true);  
import org.opensearch.index.mapper.ContentPath;  
        org.apache.lucene.geo.Rectangle r = GeoTestUtil.nextBox();  
        }
import org.opensearch.core.xcontent.XContentParser;  
    }
import org.opensearch.OpenSearchException;
        shellCoordinates.add(new Coordinate(101, 1));  
        XContentParser parser = createParser(xContentBuilder);
            lineStrings.add(GEOMETRY_FACTORY.createLineString(coords));
import org.locationtech.jts.geom.MultiLineString;
    public void testParseMixedDimensionPolyWithHoleStoredZ() throws IOException {
        shellCoordinates.add(new Coordinate(176, -15));
        shellCoordinates.add(new Coordinate(100, 1));
            lines.add(new Line(Arrays.stream(c).mapToDouble(i -> i.x).toArray(), Arrays.stream(c).mapToDouble(i -> i.y).toArray()));  
        assumeTrue("JTS test path cannot handle empty multilinestrings", numLineStrings > 1);
/*
        List<Coordinate> coordinates = new ArrayList<>(numPoints);  
    public void testParseOpenPolygon() throws IOException {  
        } else {
import org.opensearch.core.xcontent.XContentBuilder;
            coordinates.add(new Coordinate(p.lon(), p.lat()));
        int numPoints = randomIntBetween(2, 100);
            expectedGeom = GeometryCollection.EMPTY;
import org.locationtech.spatial4j.shape.jts.JtsPoint;  
    }
        MultiLineStringBuilder builder = new MultiLineStringBuilder();
package org.opensearch.common.geo;
        assertMalformed(builder);
        Settings indexSettings = Settings.builder()
        assumeTrue("JTS test path cannot handle empty multipolygon", numPolys > 1);
 * compatible open source license.
        }  
        shellCoordinates.add(new Coordinate(176, 15));
import org.opensearch.index.mapper.GeoShapeFieldMapper;
    private void assertExpected(Object expected, ShapeBuilder<?, ?, ?> builder, boolean useJTS) throws IOException, ParseException {
        int numPoints = randomIntBetween(0, 100);
        PolygonBuilder poly = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));
 * You may obtain a copy of the License at  
 */  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        ShapeCollection<?> expected = shapeCollection(shapes);  
        holeCoordinates.add(new Coordinate(100.8, 0.2));  
 * The OpenSearch Contributors require contributions made to  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import org.opensearch.common.geo.builders.MultiLineStringBuilder;
            points.add(new org.opensearch.geometry.Point(c.x, c.y));
        shellCoordinates.add(new Coordinate(-177, -10));
        Geometry expectedGeom;
            // assert empty shape collection
            GeometryCollectionBuilder builder = new GeometryCollectionBuilder();  
        assertExpected(expectedGeom, actual, false);  
        assertValidException(builder, OpenSearchParseException.class);
        assertValidException(builder, IllegalArgumentException.class);
        LinearRing shell;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());
 * Tests for {@code GeoWKTShapeParser}
            Coordinate[] coords = lsc.toArray(new Coordinate[0]);
        List<Coordinate> holeCoordinates = new ArrayList<>();
    }
            .build();  
        shellCoordinates.add(new Coordinate(101, 0));
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(coords);
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());
import org.locationtech.spatial4j.shape.Shape;
        );  
        holeCoordinates.add(new Coordinate(100.2, 0.8));
        XContentBuilder builder = XContentFactory.jsonBuilder().value("UnknownType (-1 -2)");
import org.opensearch.common.geo.builders.MultiPolygonBuilder;  
        MultiLineString expected = GEOMETRY_FACTORY.createMultiLineString(lineStrings.toArray(new LineString[0]));
            assertExpected(new GeoShapeIndexer(true, "name").prepareForIndexing(gcb.buildGeometry()), gcb, false);
    public void testParsePolyWithStoredZ() throws IOException {  
            .build(mockBuilderContext));  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.locationtech.jts.geom.Polygon;
        MultiPointBuilder actual;  
/*
        );  
        XContentBuilder builder = XContentFactory.jsonBuilder().value(malformedWKT);  
import org.opensearch.common.geo.builders.LineStringBuilder;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        assertGeometryEquals(expected, xContentBuilder, useJTS);  
        // test store z disabled  
 */
    public void testParseMixedDimensionPolyWithHole() throws IOException, ParseException {
        for (int i = 0; i < numPoints; ++i) {
    @Override  
            .build(mockBuilderContext));
        shellCoordinates.add(new Coordinate(101, 0, 0));  
        List<Coordinate> coordinates = randomLineStringCoords();
        OpenSearchParseException e = expectThrows(  
        shellCoordinates.add(new Coordinate(172, 0));
            List<Coordinate> lsc = randomLineStringCoords();  
        shellCoordinates.add(new Coordinate(-177, 15));  
        XContentParser parser = createParser(builder);
        List<Coordinate> holeCoordinates = new ArrayList<>();
            () -> GeoWKTParser.parseExpectedType(parser, GeoShapeType.POLYGON)
        assertExpected(jtsGeom(expected), builder, true);  
            wkt += GeoWKTParser.RPAREN;
            RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.POLYGON)  
 * this file be licensed under the Apache-2.0 license or a
        assertValidException(builder, InvalidShapeException.class);  
        XContentParser parser = createParser(xContentBuilder);
    }
        PolygonBuilder builder = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));
        double[] lons = new double[lats.length];
    public void testInvalidGeometryType() throws IOException {  
        if (randomBoolean()) {  
        String wkt = builder.toWKT();  
            .build(mockBuilderContext));
        assertExpected(expected, builder, true);  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        // test store z disabled
        assertEquals(shapeBuilder.numDimensions(), 3);  
 *
    @Override
        parser.nextToken();
    private void assertMalformed(ShapeBuilder<?, ?, ?> builder) throws IOException {  
 * specific language governing permissions and limitations
            // test comments
            Coordinate c = coordinates.get(i);  
import org.opensearch.Version;  
            lons[i] = coordinates.get(i).x;
        XContentBuilder builder = toWKTContent(new PointBuilder(-1, 2), false);  
        ShapeBuilder<?, ?, ?> shapeBuilder = ShapeParser.parse(parser, coercingMapperBuilder);  
    }
 *  
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().value(openPolygon);  
    }
        assertMalformed(builder);
            actual = new MultiPointBuilder(coordinates);  
        if (lines.isEmpty()) {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * Modifications Copyright OpenSearch Contributors. See  
        if (numPoints == 0) {
        Coordinate[] coordinates;  
        );  
            Shape[] expected = new Shape[0];
import org.locationtech.spatial4j.exception.InvalidShapeException;
        List<Line> lines = new ArrayList<>(lineStrings.size());  
 * under the License.  
        shellCoordinates.add(new Coordinate(100, 0));
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
        XContentBuilder xContentBuilder = toWKTContent(builder, false);
        }  
        holeCoordinates.add(new Coordinate(100.2, 0.8, 10.0));  
        Settings indexSettings = Settings.builder()
import org.locationtech.spatial4j.shape.Rectangle;  
        polygonWithHole.hole(new LineStringBuilder(holeCoordinates));  
        }
        GeoPoint p = RandomShapeGenerator.randomPoint(random());
        List<Coordinate> shellCoordinates = new ArrayList<>();  
        PolygonBuilder builder = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));  
import org.opensearch.geometry.Line;  
 * software distributed under the License is distributed on an
    }
        XContentParser parser = createParser(xContentBuilder);
        for (int i = 0; i < numPoints; ++i) {  
            Collections.singletonList(hole)
            .coerce(true)
    @Override
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;  
        Shape[] shapes = new Shape[numPoints];
/*  
        builder.hole(new LineStringBuilder(holeCoordinates));
            } else {
        assertExpected(expected, new MultiPointBuilder(coordinates), true);
        org.opensearch.geometry.Polygon p = new org.opensearch.geometry.Polygon(  
        assertMalformed(builder);
        assertExpected(expectedGeom, builder, false);
            OpenSearchParseException.class,
            if (randomBoolean()) {
        shellCoordinates.add(new Coordinate(-177, 10));  
    public void testParseMultiPolygon() throws IOException, ParseException {
import org.opensearch.geometry.GeometryCollection;
        assertThat(e, hasToString(containsString("but [ignore_z_value] parameter is [false]")));
    private List<Coordinate> randomLineStringCoords() {
        holes[0] = GEOMETRY_FACTORY.createLinearRing(holeCoordinates.toArray(new Coordinate[0]));
    public void testParsePolygonWithHole() throws IOException, ParseException {
        // add 3d point to test ISSUE #10501
    @Override  
            p = RandomShapeGenerator.randomPointIn(random(), -90d, -90d, 90d, 90d);  
    private static XContentBuilder toWKTContent(ShapeBuilder<?, ?, ?> builder, boolean generateMalformed) throws IOException {
        List<Coordinate> shellCoordinates = new ArrayList<>();
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, null);
        assertExpected(new JtsPoint(expected, SPATIAL_CONTEXT), new PointBuilder().coordinate(c), true);
import org.opensearch.index.mapper.Mapper;
        }
            }  
        assertEquals("invalid LinearRing found (coordinates are not closed)", exception.getMessage());
        int numPolys = randomIntBetween(0, 8);  
    public void testParseSelfCrossingPolygon() throws IOException {
        Rectangle expected = SPATIAL_CONTEXT.makeRectangle(r.minLon, r.maxLon, r.minLat, r.maxLat);  
        double[] lats = new double[coordinates.size()];  
    public void testParsePoint() throws IOException, ParseException {  
        LinearRing[] holes = new LinearRing[1];  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.common.geo.builders.CoordinatesBuilder;  
        parser.nextToken();
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().value(builder.toWKT());
        // test self crossing ccw poly not crossing dateline  
        assertMalformed(polygonWithHole);
        List<Coordinate> shellCoordinates = new ArrayList<>();  
        ShapeBuilder<?, ?, ?> shapeBuilder = ShapeParser.parse(parser, mapperBuilder);
    public void testUnexpectedShapeException() throws IOException {
        if (generateMalformed) {
    @Override
        holeCoordinates.add(new Coordinate(100.2, 0.2));
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        OpenSearchParseException exception = expectThrows(  
    public void testParseGeometryCollection() throws IOException, ParseException {  
        holeCoordinates.add(new Coordinate(100.8, 0.8));
        shellCoordinates.add(new Coordinate(100, 0));
}  
        Settings indexSettings = Settings.builder()
        holeCoordinates.add(new Coordinate(100.8, 0.2));
import org.opensearch.common.settings.Settings;  
            () -> ShapeParser.parse(parser, defaultMapperBuilder)
import org.opensearch.common.geo.builders.PointBuilder;
        }
        assumeTrue("JTS test path cannot handle empty multipoints", numPoints > 1);  
            expectedGeom = points.get(0);
        } else {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }
        assertExpected(new Line(lons, lats), new LineStringBuilder(coordinates), false);  
    public void testParsePolygon() throws IOException, ParseException {
    @Override  
import java.text.ParseException;
            expectedGeom = new MultiPoint(points);
        List<org.opensearch.geometry.Point> points = new ArrayList<>(numPoints);
        org.opensearch.geometry.LinearRing hole = new org.opensearch.geometry.LinearRing(
        shellCoordinates.add(new Coordinate(101, 1));  
            Coordinate[] c = lineStrings.get(j).getCoordinates();
    public void testParseMultiLineString() throws IOException, ParseException {
import org.locationtech.jts.geom.Coordinate;
 * KIND, either express or implied.  See the License for the
        return coordinates;  
        holeCoordinates.add(new Coordinate(100.2, 0.2, 15.0));  
        );
import org.locationtech.spatial4j.shape.ShapeCollection;
            Coordinate c = coordinates.get(i);
import org.locationtech.jts.geom.LineString;  
            expectedGeom = MultiPoint.EMPTY;
        } else {
        shellCoordinates.add(new Coordinate(100, 1, 5));
import org.locationtech.jts.geom.LinearRing;
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().value(builder.toWKT());  
        parser.nextToken();
        assertThat(e, hasToString(containsString("Expected geometry type [polygon] but found [point]")));
            .ignoreZValue(true)
        String malformedWKT = "POLYGON ((100, 5) (100, 10) (90, 10), (90, 5), (100, 5)";
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());
/**  
        }
            pb = PolygonBuilder.class.cast(RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.POLYGON));
            actual = new MultiPointBuilder(coordinates);  
    }
    public void testParseLineString() throws IOException, ParseException {
        holeCoordinates.add(new Coordinate(100.2, 0.2));
        shellCoordinates.add(new Coordinate(100, 0));
    public void testParseEnvelope() throws IOException, ParseException {
import java.util.Arrays;
        List<Coordinate> shellCoordinates = new ArrayList<>();
    }
        holeCoordinates.add(new Coordinate(100.8, 0.2));
