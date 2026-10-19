            Query indexQuery = ((IndexOrDocValuesQuery) query).getIndexQuery();
        assertGeoPolygonQuery(query);
        IllegalArgumentException e = expectThrows(
            + "                \"40, -70\",\n"
            + "        }\n"
        failingQueryBuilder.ignoreUnmapped(false);  
            + "                    \"lat\":40,\n"
        return polygonPoints;
            + "                [-70, 40],\n"  
    public void testParsingAndToQuery4() throws IOException {  
            + "            ]\n"
            List<GeoPoint> points = queryBuilder.points();
            + "    \"geo_polygon\":{\n"  
    protected GeoPolygonQueryBuilder doCreateTestQueryBuilder() {
    }
        List<GeoPoint> points = new ArrayList<>();
            builder.setValidationMethod(randomFrom(GeoValidationMethod.values()));
    public void testParsingAndToQuery2() throws IOException {
            + "}";  
            + "        }\n"
            "/org/opensearch/index/query/geo_polygon_exception_5.json" };
        List<GeoPoint> polygon = randomPolygon();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (randomBoolean()) {
    }  
import org.opensearch.test.geo.RandomShapeGenerator;
    }
            + "}\n";
    }  
            + "                },\n"
 * You may obtain a copy of the License at  
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());  
            assertEquals(LatLonDocValuesField.newSlowPolygonQuery(expectedFieldName, polygon), dvQuery);
 * Licensed to Elasticsearch under one or more contributor  
        );
            + "    }\n"  
    public void testEmptyPolygon() {
import org.opensearch.index.mapper.MappedFieldType;  
            + "        \""  
        if (randomBoolean()) {  
            + "  \"geo_polygon\" : {\n"
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
        GeoPolygonQueryBuilder parsed = (GeoPolygonQueryBuilder) parseQuery(json);
            IllegalArgumentException.class,  
}
import org.apache.lucene.document.LatLonPoint;
            + "            ]\n"
            Query dvQuery = ((IndexOrDocValuesQuery) query).getRandomAccessQuery();
            + "                }\n"
            () -> new GeoPolygonQueryBuilder(GEO_POINT_FIELD_NAME, points)  
            + "            \"points\":[\n"  
        points.add(new GeoPoint(0, 90));
 * Unless required by applicable law or agreed to in writing,
        points.add(new GeoPoint(0, 90));
            + "            ]\n"
            + "        \""
        checkGeneratedJson(json, parsed);
        String query = "{\n"
            for (int i = 0; i < points.size(); i++) {
    }
        ShapeBuilder<?, ?, ?> shapeBuilder = null;
            builder.ignoreUnmapped(randomBoolean());
        // This is a temporary fix because sometimes the RandomShapeGenerator
        assertEquals("polygon must not be null or empty", e.getMessage());  
        ArrayList<GeoPoint> polygonPoints = new ArrayList<>();
public class GeoPolygonQueryBuilderTests extends AbstractQueryTestCase<GeoPolygonQueryBuilder> {  
            + "    \"validation_method\" : \"STRICT\",\n"
            + "                    \"lon\":-80\n"  
            + "        \""
    }
    private void assertGeoPolygonQuery(String query) throws IOException {
            + "                    \"lat\":20,\n"  
            + "\":{\n"
        String queryInvalidLat = "{\n"
            + "                \"30, -80\",\n"
            + "}\n";  
            + "            \"points\":[\n"
    }
        String query = "{\n"
            + GEO_POINT_FIELD_NAME
                lats[i] = points.get(i).getLat();
    }
 * GitHub history for details.
            + "        \""  
        assertGeoPolygonQuery(query);
            + "                \"30, -80\",\n"  
        }
            + "            \"points\":[\n"  
        while (shapeBuilder == null) {
 * ownership. Elasticsearch licenses this file to you under  
    }
            + "    \"boost\" : 1.0\n"
        Query query = queryBuilder.toQuery(createShardContext());
    @Override
            + "}\n";  
            + "                \"20, -90\"\n"
            + "    \"ignore_unmapped\" : false,\n"  
            + "    \"person.location\" : {\n"
        assertGeoPolygonQuery(query);  
import java.util.ArrayList;  
/*
 * specific language governing permissions and limitations
            + "    \"geo_polygon\":{\n"
    }  
        String[] brokenFiles = new String[] {  
            () -> new GeoPolygonQueryBuilder(GEO_POINT_FIELD_NAME, points)
 * license agreements. See the NOTICE file distributed with
            + "    }\n"  
import static org.hamcrest.CoreMatchers.containsString;
        List<GeoPoint> polygon = randomPolygon();
        for (Coordinate coord : coordinates) {
    public void testInvalidClosedPolygon() {  
 * not use this file except in compliance with the License.
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;  
        String json = "{\n"  
        assertEquals("too few points defined for geo_polygon query", e.getMessage());  
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
            + "}\n";
import static org.hamcrest.CoreMatchers.notNullValue;
        JtsGeometry shape = (JtsGeometry) shapeBuilder.buildS4J();
            + "                \"20, -90\"\n"  
            + "        \""
import org.opensearch.core.common.ParsingException;
            + GEO_POINT_FIELD_NAME
import org.opensearch.common.geo.builders.ShapeBuilder;
            + "    }\n"  
        QueryShardContext context = createShardContext();  
    public void testIgnoreUnmapped() throws IOException {  
import org.opensearch.common.geo.GeoPoint;  
    }  
    protected void doAssertLuceneQuery(GeoPolygonQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
            + "        }\n"
            + "  }\n"
import java.util.Collections;
            + "    \"geo_polygon\":{\n"
        queryBuilder.ignoreUnmapped(true);  
            + "            ]\n"
        assertGeoPolygonQuery(query);
            + "        }\n"  
        assertThat(e2.getMessage(), containsString("illegal longitude value [-190.0] for [geo_polygon]"));  
            + "                \"drn5x1g8cu2y\",\n"
 * compatible open source license.
            + "                    \"lon\":-70\n"
            + "}\n";
 * The OpenSearch Contributors require contributions made to  
        if (fieldType == null) {
            + "            \"points\":[\n"  
            + "                    \"lat\":30,\n"
            + "      \"points\" : [ [ -70.0, 40.0 ], [ -80.0, 30.0 ], [ -90.0, 20.0 ], [ -70.0, 40.0 ] ]\n"  
            "/org/opensearch/index/query/geo_polygon_exception_2.json",
    }  
            + "    }\n"
        QueryShardException e1 = expectThrows(QueryShardException.class, () -> parseQuery(queryInvalidLat).toQuery(context));  
            + "            \"points\":[\n"
            org.apache.lucene.geo.Polygon polygon = new org.apache.lucene.geo.Polygon(lats, lons);
            String query = copyToStringFromClasspath(brokenFile);
            IllegalArgumentException.class,
import org.opensearch.test.AbstractQueryTestCase;
    }
    }
            + "                [-70, 140],\n"
import org.apache.lucene.search.IndexOrDocValuesQuery;  
        GeoPolygonQueryBuilder builder = new GeoPolygonQueryBuilder(fieldName, polygon);
            + GEO_POINT_FIELD_NAME
        }  
 * KIND, either express or implied.  See the License for the
            + "    \"geo_polygon\":{\n"
 * software distributed under the License is distributed on an
            expectThrows(ParsingException.class, () -> parseQuery(query));
/*  
            + GEO_POINT_FIELD_NAME  
            + "                [-90, 20]\n"  
            "/org/opensearch/index/query/geo_polygon_exception_4.json",
    }  
        );
 */
            + "            ]\n"  
            + "    },\n"
 */  
            + "                {\n"
    public void testParsingAndToQuery3() throws IOException {
    private static List<GeoPoint> randomPolygon() {  
        assertEquals("fieldName must not be null", e.getMessage());
        final GeoPolygonQueryBuilder failingQueryBuilder = new GeoPolygonQueryBuilder("unmapped", polygon);
        // returns null. This is if there is an error generating the polygon. So  
        assertThat(query, instanceOf(MatchNoDocsQuery.class));  
            + "    \"geo_polygon\":{\n"
import org.apache.lucene.document.LatLonDocValuesField;
            + GEO_POINT_FIELD_NAME  
package org.opensearch.index.query;
import static org.hamcrest.CoreMatchers.instanceOf;  
            + "            ]\n"  
        IllegalArgumentException e = expectThrows(
        IllegalArgumentException e = expectThrows(
        final GeoPolygonQueryBuilder queryBuilder = new GeoPolygonQueryBuilder("unmapped", polygon);
    public void testParsingAndToQueryParsingExceptions() throws IOException {
        points.add(new GeoPoint(90, 90));  
        points.add(new GeoPoint(0, 90));
            + "                [-80, 30],\n"
        assertThat(e.getMessage(), containsString("failed to find geo_point field [unmapped]"));
        doAssertLuceneQuery(queryBuilder, queryBuilder.toQuery(context), context);
            polygonPoints.add(new GeoPoint(coord.y, coord.x));  
    public void testPointValidation() throws IOException {
            + "    }\n"
        // in this case keep trying until we successfully generate one
            + "            \"points\":[\n"
    public void testNullFieldName() {
 * Modifications Copyright OpenSearch Contributors. See
            + "\":{\n"
            + "                },\n"  
        }
import org.apache.lucene.search.Query;
        return builder;
 *
            + "        \""  
        }
        Coordinate[] coordinates = shape.getGeom().getCoordinates();  
 * this file be licensed under the Apache-2.0 license or a
import org.locationtech.jts.geom.Coordinate;
        MappedFieldType fieldType = context.fieldMapper(queryBuilder.fieldName());
            assertTrue("Found no indexed geo query.", query instanceof MatchNoDocsQuery);  
 *     http://www.apache.org/licenses/LICENSE-2.0
            IllegalArgumentException.class,  
            + "                    \"lon\":-90\n"
            + "}\n";
        for (String brokenFile : brokenFiles) {  
        GeoPolygonQueryBuilder queryBuilder = (GeoPolygonQueryBuilder) parseQuery(query);
            }
        String query = "{\n"  
        }  
            + "        }\n"
            + "                {\n"  
        e = expectThrows(IllegalArgumentException.class, () -> new GeoPolygonQueryBuilder(GEO_POINT_FIELD_NAME, null));
        assertEquals(json, 4, parsed.points().size());  
            shapeBuilder = RandomShapeGenerator.createShapeWithin(random(), null, ShapeType.POLYGON);  
import java.util.List;
            "/org/opensearch/index/query/geo_polygon_exception_3.json",  
            + "                [-70, 40],\n"
            assertEquals(LatLonPoint.newPolygonQuery(expectedFieldName, polygon), indexQuery);  
        List<GeoPoint> points = new ArrayList<>();
            + "                {\n"
 * SPDX-License-Identifier: Apache-2.0
    public void testParsingAndToQuery1() throws IOException {  
 * this work for additional information regarding copyright
 *  
    }  
        assertEquals("too few points defined for geo_polygon query", e.getMessage());
    @Override
            + "    }\n"
            double[] lons = new double[points.size()];  
            + "\":{\n"
            + "                [-80, 30],\n"
            () -> new GeoPolygonQueryBuilder(GEO_POINT_FIELD_NAME, Collections.emptyList())
            + "\":{\n"  
            + "                [-80, 30],\n"
import java.io.IOException;
import org.apache.lucene.search.MatchNoDocsQuery;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoPolygonQueryBuilder(null, randomPolygon()));  
        QueryShardException e2 = expectThrows(QueryShardException.class, () -> parseQuery(queryInvalidLon).toQuery(context));
 */  
    public void testFromJson() throws IOException {
        String queryInvalidLon = "{\n"  
        assertThat(e1.getMessage(), containsString("illegal latitude value [140.0] for [geo_polygon]"));
            + "        }\n"
            + "                [-190, 20]\n"
        String fieldName = randomFrom(GEO_POINT_FIELD_NAME, GEO_POINT_ALIAS_FIELD_NAME);  
        assertThat(query, notNullValue());
            + "\":{\n"
        }  
    public void testInvalidOpenPolygon() {  
        QueryShardContext context = createShardContext();  
            double[] lats = new double[points.size()];
 * the Apache License, Version 2.0 (the "License"); you may
        } else { // TODO: Test case when there are no docValues
            + "\":{\n"
 *
        assertEquals("polygon must not be null or empty", e.getMessage());  
            + GEO_POINT_FIELD_NAME
        points.add(new GeoPoint(90, 90));  
                lons[i] = points.get(i).getLon();  
/*  
            + "                [-90, 20]\n"  
            "/org/opensearch/index/query/geo_polygon_exception_1.json",
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
        );
        String query = "{\n"
 * under the License.  
            + "    \"geo_polygon\":{\n"
