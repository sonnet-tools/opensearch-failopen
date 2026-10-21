        holeCoordinates.add(new Coordinate(100.2, 0.2));
            points.add(new org.opensearch.geometry.Point(c.x, c.y));
    public void testInvalidGeometryType() throws IOException {
            p = RandomShapeGenerator.randomPointIn(random(), -90d, -90d, 90d, 90d);
            wkt = "# " + wkt + "\n" + wkt;
 */
        assertExpected(jtsGeom(expected), builder, true);
import java.text.ParseException;
import org.opensearch.geometry.Geometry;
        List<Coordinate> coordinates = new ArrayList<>(numPoints);
            Collections.singletonList(hole)
        org.opensearch.geometry.Polygon p = new org.opensearch.geometry.Polygon(
            Coordinate c = coordinates.get(i);
    public void testParsePolyWithStoredZ() throws IOException {
        shellCoordinates.add(new Coordinate(176, 15));
        shellCoordinates.add(new Coordinate(-177, 10));
    private void assertMalformed(ShapeBuilder<?, ?, ?> builder) throws IOException {
            expectedGeom = MultiPoint.EMPTY;
        }
import org.opensearch.common.geo.builders.MultiPolygonBuilder;
        double[] lats = new double[coordinates.size()];
        shellCoordinates.add(new Coordinate(100, 0));
        shellCoordinates.add(new Coordinate(-177, 15));
    }
import org.opensearch.common.geo.parsers.GeoWKTParser;
    @Override
            .build();
    }
            .build(mockBuilderContext));
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().value(builder.toWKT());
    public void testParseEnvelope() throws IOException, ParseException {
import org.opensearch.index.mapper.Mapper;
 * software distributed under the License is distributed on an
import org.opensearch.index.mapper.GeoShapeFieldMapper;
import org.opensearch.geometry.MultiPoint;
import org.opensearch.index.mapper.GeoShapeIndexer;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            lines.add(new Line(Arrays.stream(c).mapToDouble(i -> i.x).toArray(), Arrays.stream(c).mapToDouble(i -> i.y).toArray()));
        PolygonBuilder builder = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));
        LineString expected = GEOMETRY_FACTORY.createLineString(coordinates.toArray(new Coordinate[0]));
 * Licensed to Elasticsearch under one or more contributor
        }
        assertExpected(jtsGeom(expected), polygonWithHole, true);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        XContentBuilder builder = XContentFactory.jsonBuilder().value(poly.toWKT());
        shellCoordinates.add(new Coordinate(100, 1));
    public void testMalformedWKT() throws IOException {
        holeCoordinates.add(new Coordinate(100.2, 0.8, 10.0));
import org.opensearch.Version;
        int numPoints = randomIntBetween(0, 100);
import org.opensearch.OpenSearchException;
import static org.hamcrest.Matchers.hasToString;
        shellCoordinates.add(new Coordinate(100, 0));
        shellCoordinates.add(new Coordinate(100, 0));
    }
import org.opensearch.common.geo.builders.EnvelopeBuilder;
        );
            shapes[i] = GEOMETRY_FACTORY.createPolygon(shell, null);
package org.opensearch.common.geo;
        );
 * KIND, either express or implied.  See the License for the
        ShapeCollection<?> expected = shapeCollection(shapes);
        for (int j = 0; j < lineStrings.size(); ++j) {
import org.opensearch.geometry.Line;
    }
    @Override
            .build(mockBuilderContext));
        XContentBuilder xContentBuilder = toWKTContent(builder, false);
            shapes[i] = SPATIAL_CONTEXT.makePoint(c.x, c.y);
        } else {
        GeoPoint p;
        shellCoordinates.add(new Coordinate(101, 0));
        assertMalformed(new PointBuilder().coordinate(c));
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;
        ShapeBuilder<?, ?, ?> shapeBuilder = ShapeParser.parse(parser, mapperBuilder);
 *
            lineStrings.add(GEOMETRY_FACTORY.createLineString(coords));
        // malformed points in a polygon is a common typo
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                assertEquals(shapeCollection(expected).isEmpty(), builder.buildGeometry().size() == 0);
        XContentParser parser = createParser(xContentBuilder);
        List<Coordinate> holeCoordinates = new ArrayList<>();
        parser.nextToken();
        }
        PolygonBuilder poly = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(coords);
    public void testParseMultiLineString() throws IOException, ParseException {
        parser.nextToken();
    }
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> ShapeParser.parse(parser, mapperBuilder));
        int numPolys = randomIntBetween(0, 8);
            assertExpected(gcb.buildS4J(), gcb, true);
    private List<Coordinate> randomLineStringCoords() {
        XContentParser parser = createParser(xContentBuilder);
        assertExpected(jtsGeom(expected), new LineStringBuilder(coordinates), true);
            expectedGeom = GeometryCollection.EMPTY;
        XContentParser parser = createParser(builder);
        assertExpected(expectedGeom, actual, false);
    @Override
        org.opensearch.geometry.LinearRing hole = new org.opensearch.geometry.LinearRing(
        List<Coordinate> holeCoordinates = new ArrayList<>();
        ShapeBuilder<?, ?, ?> shapeBuilder = ShapeParser.parse(parser, coercingMapperBuilder);
        XContentBuilder xContentBuilder = toWKTContent(builder, true);
 * ownership. Elasticsearch licenses this file to you under
        final LegacyGeoShapeFieldMapper coercingMapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")
        }
        builder.hole(new LineStringBuilder(holeCoordinates));
import org.locationtech.spatial4j.shape.ShapeCollection;
        } else {
            expectedGeom = new MultiPoint(points);
import org.locationtech.jts.geom.Point;
    }
                assertEquals(shapeCollection(expected).isEmpty(), builder.buildS4J().isEmpty());
import static org.opensearch.common.geo.builders.ShapeBuilder.SPATIAL_CONTEXT;
import org.opensearch.common.geo.builders.PolygonBuilder;
        assertValidException(xContentBuilder, OpenSearchParseException.class);
        return XContentFactory.jsonBuilder().value(wkt);
    }
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        double[] lons = new double[lats.length];
        parser.nextToken();
            // TODO generate more malformed WKT
            // test comments
    public void testParseMultiPolygon() throws IOException, ParseException {
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().value(openPolygon);
    private void assertExpected(Object expected, ShapeBuilder<?, ?, ?> builder, boolean useJTS) throws IOException, ParseException {
        assertExpected(new org.opensearch.geometry.Point(p.lon(), p.lat()), new PointBuilder().coordinate(c), false);
    public void testParsePoint() throws IOException, ParseException {
        holeCoordinates.add(new Coordinate(100.8, 0.8));
        shellCoordinates.add(new Coordinate(100, 1));
            OpenSearchParseException.class,
public class GeoWKTShapeParserTests extends BaseGeoParsingTestCase {
        String wkt = builder.toWKT();
        for (int i = 0; i < numPoints; ++i) {
            lats[i] = coordinates.get(i).y;
            .ignoreZValue(true)
        }
            builder.linestring(new LineStringBuilder(lsc));
    public void testParseMixedDimensionPolyWithHoleStoredZ() throws IOException {
        shellCoordinates.add(new Coordinate(100, 0));
        }
    public void testParseLineString() throws IOException, ParseException {
        MultiPointBuilder actual;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            Coordinate[] c = lineStrings.get(j).getCoordinates();
import org.opensearch.geometry.GeometryCollection;
    }
 * this file be licensed under the Apache-2.0 license or a
            coordinates = pb.coordinates()[0][0];
        LinearRing[] holes = new LinearRing[1];
 * license agreements. See the NOTICE file distributed with
            .build(mockBuilderContext));
    @Override
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
    }
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());
/*
import java.util.ArrayList;
            assertExpected(new GeoShapeIndexer(true, "name").prepareForIndexing(gcb.buildGeometry()), gcb, false);
    }
        }
/**
 */
            () -> GeoWKTParser.parseExpectedType(parser, GeoShapeType.POLYGON)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(e, hasToString(containsString("but [ignore_z_value] parameter is [false]")));
import java.util.Collections;
        holeCoordinates.add(new Coordinate(100.2, 0.8));
        String openPolygon = "POLYGON ((100 5, 100 10, 90 10, 90 5))";
    @Override
        List<Coordinate> coordinates = randomLineStringCoords();
    }
    public void testParsePolygonWithHole() throws IOException, ParseException {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.geo.builders.CoordinatesBuilder;
        shellCoordinates.add(new Coordinate(101, 0, 0));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * SPDX-License-Identifier: Apache-2.0
        Geometry expectedGeom;
        holeCoordinates.add(new Coordinate(100.8, 0.2));
        holeCoordinates.add(new Coordinate(100.2, 0.2));
        EnvelopeBuilder builder = new EnvelopeBuilder(new Coordinate(r.minLon, r.maxLat), new Coordinate(r.maxLon, r.minLat));
 * not use this file except in compliance with the License.
        List<Coordinate> coordinates = new ArrayList<>(numPoints);
        if (rarely()) {
        final LegacyGeoShapeFieldMapper mapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")
        holeCoordinates.add(new Coordinate(100.8, 0.8));
        holeCoordinates.add(new Coordinate(100.2, 0.8, 10.0));
    }
        }
            coordinates.add(new Coordinate(GeoTestUtil.nextLongitude(), GeoTestUtil.nextLatitude()));
        shellCoordinates.add(new Coordinate(-177, -10));
            expectedGeom = new MultiLine(lines);
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
import org.locationtech.spatial4j.exception.InvalidShapeException;
        shellCoordinates.add(new Coordinate(100, 0));
            expectedGeom = points.get(0);
        assumeTrue("JTS test path cannot handle empty multipoints", numPoints > 1);
    @Override
        assertExpected(expected, builder, true);
        List<Coordinate> shellCoordinates = new ArrayList<>();
        XContentBuilder builder = toWKTContent(new PointBuilder(-1, 2), false);
import org.opensearch.common.geo.builders.LineStringBuilder;
        Settings indexSettings = Settings.builder()
 */
            wkt += GeoWKTParser.RPAREN;
 * specific language governing permissions and limitations
            // malformed - extra paren
        Settings indexSettings = Settings.builder()
        }
        assertMalformed(builder);
        assertExpected(expectedGeom, builder, false);
        assertThat(e, hasToString(containsString("unable to add coordinate to CoordinateBuilder: coordinate dimensions do not match")));
import org.locationtech.spatial4j.shape.Shape;
            pb = PolygonBuilder.class.cast(RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.POLYGON));
        holeCoordinates.add(new Coordinate(100.8, 0.2));
            expectedGeom = new Line(lines.get(0).getX(), lines.get(0).getY());
    public void testParseMixedDimensionPolyWithHole() throws IOException, ParseException {
import java.util.Arrays;
        shellCoordinates.add(new Coordinate(176, -15));
        }
        final LegacyGeoShapeFieldMapper mapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")
import java.util.List;
        for (int i = 0; i < numPolys; ++i) {
        XContentParser parser = createParser(xContentBuilder);
            Coordinate[] coords = lsc.toArray(new Coordinate[0]);
        assertNotNull(shapeBuilder);
        int numPoints = randomIntBetween(2, 100);
        shellCoordinates.add(new Coordinate(100, 1, 5));
            // assert empty shape collection
        assertEquals(shapeBuilder.numDimensions(), 3);
        holeCoordinates.add(new Coordinate(100.2, 0.2));
        OpenSearchParseException exception = expectThrows(
        holeCoordinates.add(new Coordinate(100.8, 0.2));
        builder.hole(new LineStringBuilder(holeCoordinates));
    public void testParseOpenPolygon() throws IOException {
        PolygonBuilder pb;
        List<Line> lines = new ArrayList<>(lineStrings.size());
        // add 3d point to test ISSUE #10501
        assumeTrue("JTS test path cannot handle empty multilinestrings", numLineStrings > 1);
        } else if (numPoints == 1) {
        final GeoShapeFieldMapper mapperBuilder = (GeoShapeFieldMapper) (new GeoShapeFieldMapper.Builder("test").ignoreZValue(false)
import org.locationtech.jts.geom.LinearRing;
        MultiLineString expected = GEOMETRY_FACTORY.createMultiLineString(lineStrings.toArray(new LineString[0]));
        );
        assertThat(e, hasToString(containsString("Expected geometry type [polygon] but found [point]")));
        assertMalformed(actual);
        PolygonBuilder builder = PolygonBuilder.class.cast(
        assertMalformed(builder);
        }
        assertValidException(builder, OpenSearchParseException.class);
        // test store z disabled
            new org.opensearch.geometry.LinearRing(new double[] { 101d, 101d, 100d, 100d, 101d }, new double[] { 0d, 1d, 1d, 0d, 0d }),
            new double[] { 100.2d, 100.8d, 100.8d, 100.2d, 100.2d },
        // test self crossing ccw poly not crossing dateline
        List<Coordinate> shellCoordinates = new ArrayList<>();
        assertExpected(new org.opensearch.geometry.Rectangle(r.minLon, r.maxLon, r.maxLat, r.minLat), builder, false);
 * Tests for {@code GeoWKTShapeParser}
            .ignoreZValue(true)
        XContentBuilder builder = XContentFactory.jsonBuilder().value(malformedWKT);
        // test store z disabled
import org.opensearch.OpenSearchParseException;
        assertMalformed(builder);
        PolygonBuilder builder = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));
        List<LineString> lineStrings = new ArrayList<>(numLineStrings);
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());
        PolygonBuilder polygonWithHole = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));
        holeCoordinates.add(new Coordinate(100.2, 0.2, 15.0));
    public void testParseGeometryCollection() throws IOException, ParseException {
        assumeTrue("JTS test path cannot handle empty multipolygon", numPolys > 1);
import org.opensearch.common.geo.builders.MultiLineStringBuilder;
        MultiPolygonBuilder builder = new MultiPolygonBuilder();
            actual = new MultiPointBuilder(coordinates);
            .build();
        // add 3d point to test ISSUE #10501
        shellCoordinates.add(new Coordinate(176, 15));
            GeometryCollectionBuilder builder = new GeometryCollectionBuilder();
        Coordinate[] coords = builder.coordinates()[0][0];
        GeoPoint p = RandomShapeGenerator.randomPoint(random());
        shellCoordinates.add(new Coordinate(100, 0, 0));
 * this work for additional information regarding copyright
import org.opensearch.common.geo.builders.PointBuilder;
            }
        MultiLineStringBuilder builder = new MultiLineStringBuilder();
        parser.nextToken();
        if (randomBoolean()) {
        for (int i = 0; i < lats.length; ++i) {
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, holes);
        holeCoordinates.add(new Coordinate(100.2, 0.2, 15.0));
            List<Coordinate> lsc = randomLineStringCoords();
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Settings indexSettings = Settings.builder()
        if (generateMalformed) {
        Coordinate[] coordinates;
 * You may obtain a copy of the License at
        holes[0] = GEOMETRY_FACTORY.createLinearRing(holeCoordinates.toArray(new Coordinate[0]));
        } else {
            .build();
            GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());
            actual = new MultiPointBuilder(coordinates);
            shell = GEOMETRY_FACTORY.createLinearRing(coordinates);
            .coerce(true)
 * compatible open source license.
    @Override
        shellCoordinates.add(new Coordinate(100, 1));
        assertValidException(builder, IllegalArgumentException.class);
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("polygon ((100.0 5.0, 100.0 10.0, 90.0 10.0, 90.0 5.0, 100.0 5.0))", shapeBuilder.toWKT());
        return coordinates;
 * The OpenSearch Contributors require contributions made to
}
import org.opensearch.geometry.MultiLine;
        Settings indexSettings = Settings.builder()
import static org.hamcrest.Matchers.containsString;
import org.locationtech.jts.geom.MultiLineString;
import org.opensearch.common.settings.Settings;
        if (numPoints == 0) {
            } else {
 * GitHub history for details.
        XContentBuilder builder = XContentFactory.jsonBuilder().value("UnknownType (-1 -2)");
    }
    }
        assertValidException(builder, InvalidShapeException.class);
            OpenSearchParseException.class,
            .coerce(false)
import org.opensearch.common.geo.builders.MultiPointBuilder;
import org.opensearch.index.mapper.ContentPath;
import org.locationtech.spatial4j.shape.jts.JtsPoint;
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().value(builder.toWKT());
    }
        holeCoordinates.add(new Coordinate(100.8, 0.8));
    }
        parser.nextToken();
            lons[i] = coordinates.get(i).x;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        polygonWithHole.hole(new LineStringBuilder(holeCoordinates));
import org.apache.lucene.tests.geo.GeoTestUtil;
        LinearRing shell;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.POLYGON)
        shellCoordinates.add(new Coordinate(101, 1, 0));
        // add 3d point to test ISSUE #10501
        assertExpected(new JtsPoint(expected, SPATIAL_CONTEXT), new PointBuilder().coordinate(c), true);
        shellCoordinates.add(new Coordinate(101, 1));
        PolygonBuilder builder = new PolygonBuilder(new CoordinatesBuilder().coordinates(shellCoordinates));
        holeCoordinates.add(new Coordinate(100.2, 0.2));
        assertExpected(expected, builder, true);
        Shape expected = shapeCollection(shapes);
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> ShapeParser.parse(parser, mapperBuilder));
 * Modifications Copyright OpenSearch Contributors. See
        Coordinate c = new Coordinate(p.lon(), p.lat());
        assertExpected(expected, new MultiPointBuilder(coordinates), true);
 *
            new double[] { 0.8d, 0.8d, 0.2d, 0.2d, 0.8d }
        assertEquals("invalid LinearRing found (coordinates are not closed)", exception.getMessage());
    }
            Coordinate c = coordinates.get(i);
            () -> ShapeParser.parse(parser, defaultMapperBuilder)
        LinearRing shell = GEOMETRY_FACTORY.createLinearRing(shellCoordinates.toArray(new Coordinate[0]));
        if (lines.isEmpty()) {
    }
        Shape[] shapes = new Shape[numPoints];
            builder.polygon(pb);
        for (int i = 0; i < numPoints; ++i) {
import org.opensearch.common.xcontent.XContentFactory;
        Geometry expectedGeom;
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
        }
    @Override
import org.opensearch.common.UUIDs;
    public void testParseSelfCrossingPolygon() throws IOException {
        for (int i = 0; i < numPoints; ++i) {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.locationtech.jts.geom.Coordinate;
/*
    public void testParsePolygon() throws IOException, ParseException {
        shellCoordinates.add(new Coordinate(172, 0));
import org.opensearch.core.xcontent.XContentParser;
            Shape[] expected = new Shape[0];
        org.apache.lucene.geo.Rectangle r = GeoTestUtil.nextBox();
            .build(mockBuilderContext));
import java.io.IOException;
        assertMalformed(builder);
        for (int j = 0; j < numLineStrings; ++j) {
        shellCoordinates.add(new Coordinate(101, 0));
        OpenSearchParseException e = expectThrows(
        List<Coordinate> shellCoordinates = new ArrayList<>();
import org.locationtech.spatial4j.shape.Rectangle;
    public void testUnexpectedShapeException() throws IOException {
        shellCoordinates.add(new Coordinate(101, 1));
        List<org.opensearch.geometry.Point> points = new ArrayList<>(numPoints);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 */
        Point expected = GEOMETRY_FACTORY.createPoint(c);
/*
        String malformedWKT = "POLYGON ((100, 5) (100, 10) (90, 10), (90, 5), (100, 5)";
    public void testParseMultiPoint() throws IOException, ParseException {
        for (int i = 0; i < numPoints; ++i) {
        shellCoordinates.add(new Coordinate(100, 0, 5));
import org.locationtech.jts.geom.Polygon;
    }
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertGeometryEquals(expected, xContentBuilder, useJTS);
 * under the License.
            .build(mockBuilderContext));
        XContentParser parser = createParser(xContentBuilder);
        Mapper.BuilderContext mockBuilderContext = new Mapper.BuilderContext(indexSettings, new ContentPath());
import org.opensearch.test.geo.RandomShapeGenerator;
        List<Coordinate> holeCoordinates = new ArrayList<>();
        } else if (lines.size() == 1) {
            coordinates.add(new Coordinate(p.lon(), p.lat()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertExpected(new Line(lons, lats), new LineStringBuilder(coordinates), false);
            if (randomBoolean()) {
import org.opensearch.common.geo.parsers.ShapeParser;
        int numLineStrings = randomIntBetween(0, 8);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        shellCoordinates.add(new Coordinate(100, 0));
    private static XContentBuilder toWKTContent(ShapeBuilder<?, ?, ?> builder, boolean generateMalformed) throws IOException {
import org.locationtech.jts.geom.LineString;
import org.opensearch.core.xcontent.XContentBuilder;
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        List<Coordinate> shellCoordinates = new ArrayList<>();
        shellCoordinates.add(new Coordinate(101, 1));
        shellCoordinates.add(new Coordinate(101, 0));
        assertExpected(jtsGeom(expected), builder, true);
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        assertExpected(p, polygonWithHole, false);
            .build();
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().value(builder.toWKT());
        assertMalformed(polygonWithHole);
        Rectangle expected = SPATIAL_CONTEXT.makeRectangle(r.minLon, r.maxLon, r.minLat, r.maxLat);
import org.opensearch.common.geo.builders.ShapeBuilder;
        Polygon expected = GEOMETRY_FACTORY.createPolygon(shell, null);
        }
        Polygon[] shapes = new Polygon[numPolys];
        List<Coordinate> shellCoordinates = new ArrayList<>();
        final LegacyGeoShapeFieldMapper defaultMapperBuilder = (LegacyGeoShapeFieldMapper) (new LegacyGeoShapeFieldMapper.Builder("test")
        );
            actual = new MultiPointBuilder();
