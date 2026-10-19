 * under the License.
            + "\":{\n"
            + "    \"geo_polygon\":{\n"
            + "            ]\n"
            + "\":{\n"
            + "                    \"lat\":20,\n"
        String fieldName = randomFrom(GEO_POINT_FIELD_NAME, GEO_POINT_ALIAS_FIELD_NAME);
    public void testParsingAndToQuery4() throws IOException {
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
            () -> new GeoPolygonQueryBuilder(GEO_POINT_FIELD_NAME, points)
        } else { // TODO: Test case when there are no docValues
    public void testNullFieldName() {
        QueryShardContext context = createShardContext();
/*
            + "  }\n"
    }
            + "        \""
            shapeBuilder = RandomShapeGenerator.createShapeWithin(random(), null, ShapeType.POLYGON);
        return polygonPoints;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "            \"points\":[\n"
            String query = copyToStringFromClasspath(brokenFile);
import org.apache.lucene.document.LatLonPoint;
            + "                {\n"
        assertEquals("too few points defined for geo_polygon query", e.getMessage());
            + "    \"geo_polygon\":{\n"
        MappedFieldType fieldType = context.fieldMapper(queryBuilder.fieldName());
 *
            List<GeoPoint> points = queryBuilder.points();
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
            + "                    \"lon\":-90\n"
            assertEquals(LatLonPoint.newPolygonQuery(expectedFieldName, polygon), indexQuery);
        }
            + "                [-70, 40],\n"
        final GeoPolygonQueryBuilder queryBuilder = new GeoPolygonQueryBuilder("unmapped", polygon);
        List<GeoPoint> polygon = randomPolygon();
 * this work for additional information regarding copyright
            + "                [-70, 140],\n"
            + "                    \"lon\":-80\n"
            + "            \"points\":[\n"
            Query dvQuery = ((IndexOrDocValuesQuery) query).getRandomAccessQuery();
            + "        }\n"
                lons[i] = points.get(i).getLon();
 * this file be licensed under the Apache-2.0 license or a
            + "\":{\n"
        GeoPolygonQueryBuilder parsed = (GeoPolygonQueryBuilder) parseQuery(json);
            + "                \"20, -90\"\n"
    public void testParsingAndToQueryParsingExceptions() throws IOException {
            + "    \"validation_method\" : \"STRICT\",\n"
import java.util.Collections;
            + GEO_POINT_FIELD_NAME
            + "  \"geo_polygon\" : {\n"
        assertGeoPolygonQuery(query);
            + "            ]\n"
        // This is a temporary fix because sometimes the RandomShapeGenerator
            builder.setValidationMethod(randomFrom(GeoValidationMethod.values()));
 */
            + "}\n";
        }
            org.apache.lucene.geo.Polygon polygon = new org.apache.lucene.geo.Polygon(lats, lons);
        GeoPolygonQueryBuilder queryBuilder = (GeoPolygonQueryBuilder) parseQuery(query);
 * Modifications Copyright OpenSearch Contributors. See
            + "}\n";
        }
        // in this case keep trying until we successfully generate one
    }
 *
        ShapeBuilder<?, ?, ?> shapeBuilder = null;
        return builder;
 */
        while (shapeBuilder == null) {
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
        GeoPolygonQueryBuilder builder = new GeoPolygonQueryBuilder(fieldName, polygon);
            + "    }\n"
            + "        }\n"
import org.apache.lucene.search.Query;
            + "    \"geo_polygon\":{\n"
        List<GeoPoint> polygon = randomPolygon();
        String queryInvalidLat = "{\n"
            + "        }\n"
/*
        if (randomBoolean()) {
    }
    public void testParsingAndToQuery1() throws IOException {
            + "    \"ignore_unmapped\" : false,\n"
            + "    }\n"
        String query = "{\n"
            + "            ]\n"
            () -> new GeoPolygonQueryBuilder(GEO_POINT_FIELD_NAME, points)
    }
    }
            + "                {\n"
            + "        \""
        ArrayList<GeoPoint> polygonPoints = new ArrayList<>();
            + "                [-80, 30],\n"
            + "                \"30, -80\",\n"
        assertEquals("fieldName must not be null", e.getMessage());
        QueryShardException e1 = expectThrows(QueryShardException.class, () -> parseQuery(queryInvalidLat).toQuery(context));
            + "    }\n"
            + GEO_POINT_FIELD_NAME
 * KIND, either express or implied.  See the License for the
        points.add(new GeoPoint(0, 90));
            + "            \"points\":[\n"
            + "                },\n"
            + "    \"boost\" : 1.0\n"
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;
import org.apache.lucene.document.LatLonDocValuesField;
            + "                [-90, 20]\n"
    private static List<GeoPoint> randomPolygon() {
            Query indexQuery = ((IndexOrDocValuesQuery) query).getIndexQuery();
        queryBuilder.ignoreUnmapped(true);
        assertGeoPolygonQuery(query);
import static org.hamcrest.CoreMatchers.instanceOf;
}
    public void testIgnoreUnmapped() throws IOException {
            + "                \"20, -90\"\n"
            + "    \"geo_polygon\":{\n"
        assertGeoPolygonQuery(query);
    protected GeoPolygonQueryBuilder doCreateTestQueryBuilder() {
    }
        assertEquals(json, 4, parsed.points().size());
            + "                [-80, 30],\n"
            + "}\n";
        IllegalArgumentException e = expectThrows(
            "/org/opensearch/index/query/geo_polygon_exception_1.json",
            IllegalArgumentException.class,
import org.opensearch.core.common.ParsingException;
    public void testInvalidClosedPolygon() {
            + "    },\n"
    public void testParsingAndToQuery2() throws IOException {
        Coordinate[] coordinates = shape.getGeom().getCoordinates();
        e = expectThrows(IllegalArgumentException.class, () -> new GeoPolygonQueryBuilder(GEO_POINT_FIELD_NAME, null));
        // returns null. This is if there is an error generating the polygon. So
            + "                \"drn5x1g8cu2y\",\n"
            + "      \"points\" : [ [ -70.0, 40.0 ], [ -80.0, 30.0 ], [ -90.0, 20.0 ], [ -70.0, 40.0 ] ]\n"
            + "            ]\n"
            double[] lats = new double[points.size()];
            + "        }\n"
    }
        assertThat(e.getMessage(), containsString("failed to find geo_point field [unmapped]"));
        String[] brokenFiles = new String[] {
            + "\":{\n"
        points.add(new GeoPoint(0, 90));
            + "        }\n"
            "/org/opensearch/index/query/geo_polygon_exception_5.json" };
/*
        doAssertLuceneQuery(queryBuilder, queryBuilder.toQuery(context), context);
        assertEquals("polygon must not be null or empty", e.getMessage());
            + "                    \"lat\":40,\n"
import org.apache.lucene.search.MatchNoDocsQuery;
        }
            + "                [-70, 40],\n"
            expectThrows(ParsingException.class, () -> parseQuery(query));
            + "                [-90, 20]\n"
 * compatible open source license.
    }
            "/org/opensearch/index/query/geo_polygon_exception_4.json",
 * not use this file except in compliance with the License.
import org.locationtech.jts.geom.Coordinate;
    }
 * GitHub history for details.
            + "            ]\n"
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
        String queryInvalidLon = "{\n"
 * You may obtain a copy of the License at
        String query = "{\n"
            }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoPolygonQueryBuilder(null, randomPolygon()));
import java.io.IOException;
            + "    }\n"
 * The OpenSearch Contributors require contributions made to
            () -> new GeoPolygonQueryBuilder(GEO_POINT_FIELD_NAME, Collections.emptyList())
 * Licensed to Elasticsearch under one or more contributor
import static org.hamcrest.CoreMatchers.containsString;
import org.opensearch.test.AbstractQueryTestCase;
    protected void doAssertLuceneQuery(GeoPolygonQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        IllegalArgumentException e = expectThrows(
            + "                \"30, -80\",\n"
    }
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
import org.opensearch.test.geo.RandomShapeGenerator;
        assertThat(query, notNullValue());
        final GeoPolygonQueryBuilder failingQueryBuilder = new GeoPolygonQueryBuilder("unmapped", polygon);
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
import static org.hamcrest.CoreMatchers.notNullValue;
            + "        \""
            + "        \""
        );
        String query = "{\n"
            + "                    \"lat\":30,\n"
    public void testFromJson() throws IOException {
        JtsGeometry shape = (JtsGeometry) shapeBuilder.buildS4J();
            + "            \"points\":[\n"
            + "                [-80, 30],\n"
            "/org/opensearch/index/query/geo_polygon_exception_2.json",
    @Override
            + "}\n";
    }
        List<GeoPoint> points = new ArrayList<>();
    }
        IllegalArgumentException e = expectThrows(
            + "}\n";
        points.add(new GeoPoint(90, 90));
        );
    }
import org.opensearch.common.geo.builders.ShapeBuilder;
            "/org/opensearch/index/query/geo_polygon_exception_3.json",
            + GEO_POINT_FIELD_NAME
            polygonPoints.add(new GeoPoint(coord.y, coord.x));
            + "                [-190, 20]\n"
        assertEquals("too few points defined for geo_polygon query", e.getMessage());
            assertTrue("Found no indexed geo query.", query instanceof MatchNoDocsQuery);
            + "    }\n"
            + "    \"geo_polygon\":{\n"
import org.opensearch.common.geo.GeoPoint;
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
            builder.ignoreUnmapped(randomBoolean());
    }
        String json = "{\n"
        List<GeoPoint> points = new ArrayList<>();
import org.apache.lucene.search.IndexOrDocValuesQuery;
        }
            assertEquals(LatLonDocValuesField.newSlowPolygonQuery(expectedFieldName, polygon), dvQuery);
        );
        if (randomBoolean()) {
 * ownership. Elasticsearch licenses this file to you under
            + "                }\n"
            + "            \"points\":[\n"
        points.add(new GeoPoint(0, 90));
        for (Coordinate coord : coordinates) {
            + GEO_POINT_FIELD_NAME
            IllegalArgumentException.class,
            + "                \"40, -70\",\n"
            + "\":{\n"
    public void testPointValidation() throws IOException {
    @Override
        assertThat(e1.getMessage(), containsString("illegal latitude value [140.0] for [geo_polygon]"));
            + "}\n";
            + "            ]\n"
 * SPDX-License-Identifier: Apache-2.0
            double[] lons = new double[points.size()];
        points.add(new GeoPoint(90, 90));
 * Unless required by applicable law or agreed to in writing,
        String query = "{\n"
            + "}";
package org.opensearch.index.query;
 *
            + "    \"person.location\" : {\n"
        assertGeoPolygonQuery(query);
    public void testEmptyPolygon() {
            + "    }\n"
import java.util.List;
        for (String brokenFile : brokenFiles) {
            + "\":{\n"
        Query query = queryBuilder.toQuery(createShardContext());
public class GeoPolygonQueryBuilderTests extends AbstractQueryTestCase<GeoPolygonQueryBuilder> {
    public void testInvalidOpenPolygon() {
            + GEO_POINT_FIELD_NAME
 * license agreements. See the NOTICE file distributed with
        assertEquals("polygon must not be null or empty", e.getMessage());
            + GEO_POINT_FIELD_NAME
            + "                    \"lon\":-70\n"
            IllegalArgumentException.class,
                lats[i] = points.get(i).getLat();
        assertThat(e2.getMessage(), containsString("illegal longitude value [-190.0] for [geo_polygon]"));
import org.opensearch.index.mapper.MappedFieldType;
        QueryShardException e2 = expectThrows(QueryShardException.class, () -> parseQuery(queryInvalidLon).toQuery(context));
            + "        }\n"
    }
            + "            \"points\":[\n"
        QueryShardContext context = createShardContext();
            + "                {\n"
 */
            for (int i = 0; i < points.size(); i++) {
            + "        \""
    public void testParsingAndToQuery3() throws IOException {
    }
    private void assertGeoPolygonQuery(String query) throws IOException {
        if (fieldType == null) {
        failingQueryBuilder.ignoreUnmapped(false);
            + "        \""
import java.util.ArrayList;
            + "    \"geo_polygon\":{\n"
 * software distributed under the License is distributed on an
            + "                },\n"
        checkGeneratedJson(json, parsed);
