            + "\":{\n"
            + "}";
            + "  \"geo_distance\":{\n"
            + "        \"unit\":\"mi\",\n"
            + "            \"lon\":-70\n"
            assertEquals(GeoShapeFieldMapper.GeoShapeFieldType.class, fieldType.getClass());
import org.opensearch.test.geo.RandomShapeGenerator;
    }
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.KILOMETERS);
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.KILOMETERS);
            + "            \"lon\":-70\n"
        GeoDistanceQueryBuilder qb = new GeoDistanceQueryBuilder(fieldName);
        checkGeneratedJson(json, parsed);
        QueryShardContext shardContext = createShardContext();
            + "    \"point2\" : {\n"
            + "        }\n"
            + "        \"distance\":19.312128,\n"
        if (randomBoolean()) {
                    expectedFieldName,
import java.io.IOException;
            + "    \"geo_distance\":{\n"
                break;
    public void testParsingAndToQuery1() throws IOException {
        }
            + "}\n";
            + GEO_POINT_FIELD_NAME
        assertEquals("distance unit must not be null", e.getMessage());
/*
            + GEO_POINT_FIELD_NAME
            + "  \"geo_distance\" : {\n"
        } else {
            + "        \""
            + "}\n";
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
                ),
        assertEquals("distance must not be null or empty", e.getMessage());
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.KILOMETERS);
        assertEquals("fieldName must not be null or empty", e.getMessage());
    }
        assertEquals(json, -70.0, parsed.point().getLon(), 0.0001);
            + "}\n";
        int selector = randomIntBetween(0, 2);
import org.apache.lucene.search.IndexOrDocValuesQuery;
    public void testToQuery() throws IOException {
            + "        \"distance\":12,\n"
    public void testParsingAndToQuery11() throws IOException {
        // The parsedQuery contains IndexOrDocValuesQuery, which wraps LatLonPointDistanceQuery which in turn has default visibility,
    public void testParsingAndToQuery6() throws IOException {
                LatLonPoint.newDistanceQuery(
            + "}";
    public void testParsingAndToQuery8() throws IOException {
 * Licensed to Elasticsearch under one or more contributor
            + "        \"distance\":\"12\",\n"
        String query = "{\n"
import org.opensearch.index.mapper.GeoPointFieldMapper;
 * ownership. Elasticsearch licenses this file to you under
     * explicitly mapped
            + "    }\n"
        assertEquals("geohash must not be null or empty", e.getMessage());
        }
            + "\":{\n"
            + "    \"ignore_unmapped\" : false,\n"
            + "        \""
                qb.distance(distance);
            + "}\n";
            + "}\n";
    public void testParsingAndToQuery9() throws IOException {
 * compatible open source license.
    }
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.DEFAULT);
    public void testParsingAndToQuery7() throws IOException {
                    queryBuilder.point().lat(),
            + "            \"lat\":40,\n"
        assertThat(query, notNullValue());
    }
            + "        \"unit\":\"km\",\n"
     */
import org.apache.lucene.search.Query;
            + "    \"geo_distance\":{\n"
        String query = "{\n"
        final MappedFieldType fieldType = context.getFieldType(queryBuilder.fieldName());
        String query = "{\n"
            + "    \"geo_distance\":{\n"
        assertEquals("distance must not be null or empty", e.getMessage());
        String json = "{\n"
 * Unless required by applicable law or agreed to in writing,
        if (fieldType == null) {
 *
            assertEquals(
            + "        \""
        String query = "{\n"
 *
    private void assertGeoDistanceRangeQuery(String query, double lat, double lon, double distance, DistanceUnit distanceUnit)
    public void testFromJson() throws IOException {
            + "\":\"40, -70\"\n"
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.DEFAULT);
            + "    \"pin.location\" : [ -70.0, 40.0 ],\n"
            "mapped_geo_point:" + lat + "," + lon + " +/- " + distanceUnit.toMeters(distance) + " meters"
    }
            + "        \""
import org.opensearch.common.unit.DistanceUnit;
            + "        }\n"
import static org.hamcrest.CoreMatchers.notNullValue;
            + "        \"distance\":\"12mi\",\n"
 */
        queryBuilder.ignoreUnmapped(true);
    public void testParsingAndToQuery2() throws IOException {
            + "        \"distance\":\"12mi\",\n"
    }
 * The OpenSearch Contributors require contributions made to
 */
            Query dvQuery = ((IndexOrDocValuesQuery) query).getRandomAccessQuery();
            + "        \""
    }
            + "        }\n"
    protected void doAssertLuceneQuery(GeoDistanceQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        e = expectThrows(IllegalArgumentException.class, () -> query.distance(1, null));
    }
        String query = "{\n"
        String distance = "" + randomDouble();
        );
            + "            \"lat\":40,\n"
        final GeoDistanceQueryBuilder queryBuilder = new GeoDistanceQueryBuilder("unmapped").point(0.0, 0.0).distance("20m");
        String query = "{\n"
        final GeoDistanceQueryBuilder failingQueryBuilder = new GeoDistanceQueryBuilder("unmapped").point(0.0, 0.0).distance("20m");
 * the Apache License, Version 2.0 (the "License"); you may
                    queryBuilder.point().lon(),
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
            + "    \"point1\" : {\n"
            + "    }\n"
        e = expectThrows(IllegalArgumentException.class, () -> query.geoDistance(null));
        e = expectThrows(
            + "}\n";
            + "    }\n"
            distance = distance + unit.toString();
        assertEquals("distance must not be null or empty", e.getMessage());
    public void testParseFailsWithMultipleFields() throws IOException {
                    queryBuilder.point().lon(),
    }
                    expectedFieldName,
package org.opensearch.index.query;
            + "    \"validation_method\" : \"STRICT\",\n"
            + GEO_POINT_FIELD_NAME
                ),
        assertGeoDistanceRangeQuery(query, geoPoint.getLat(), geoPoint.getLon(), 12, DistanceUnit.MILES);
            + "            \"lat\":40,\n"
            + "      \"lat\" : 30, \"lon\" : 12\n"
            + "        \"unit\":\"km\",\n"
            + "      }\n"
        String query = "{\n"
    public void testIllegalValues() {
/*
            + "        \""
            + "\":{\n"
            + "    \"distance\" : 12000.0,\n"
        e = expectThrows(IllegalArgumentException.class, () -> query.distance("1", null));
    public void testParsingAndToQuery3() throws IOException {
import org.opensearch.common.geo.GeoDistance;
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
        Query query = queryBuilder.toQuery(shardContext);
        throws IOException {
                dvQuery
        String json = "{\n"
            IllegalArgumentException.class,
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.document.LatLonPoint;
            qb.setValidationMethod(randomFrom(GeoValidationMethod.values()));
import org.apache.lucene.document.LatLonDocValuesField;
        if (randomBoolean()) {
            + "}\n";
            + "            \"lon\":-70\n"
            case 0:
import org.apache.lucene.search.MatchNoDocsQuery;
import org.opensearch.index.mapper.MappedFieldType;
     * present in the mappings. Geo queries do not execute if the field is not
    }
    }
            + "            \"lat\":40,\n"
            + "        \"distance\":\"12mi\",\n"
        assertEquals("distance must not be null or empty", e.getMessage());
            + "        \"distance\":19.312128,\n"
        e = expectThrows(IllegalArgumentException.class, () -> new GeoDistanceQueryBuilder((String) null));
        }
            + "        \"distance\":\"19.312128\",\n"
            Query indexQuery = ((IndexOrDocValuesQuery) query).getIndexQuery();
            + "          \"lon\":-70\n"
    @Override
            + "}\n";
            + "        \""
            + "    },\n"
            + "    }\n"
            + "    }\n"
            + "        \"distance\":\"12mi\",\n"
        assertEquals("distance must be greater than zero", e.getMessage());
            + "    }\n"
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
        e = expectThrows(IllegalArgumentException.class, () -> query.geohash(null));
        // so we cannot access its fields directly to check and have to use toString() here instead.
        }
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
            + "        }\n"
            + "\":{\n"
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
            + "            \"lon\":-70\n"
            + GEO_POINT_FIELD_NAME
    public void testParsingAndToQuery10() throws IOException {
            + "        \"unit\":\"km\",\n"
        String query = "{\n"
            + "            \"lon\":-70\n"
            case 1:
            assertTrue("Found no indexed geo query.", query instanceof MatchNoDocsQuery);
        e = expectThrows(IllegalArgumentException.class, () -> query.distance("", DistanceUnit.DEFAULT));
            + GEO_POINT_FIELD_NAME
        String fieldName = randomFrom(GEO_POINT_FIELD_NAME, GEO_POINT_ALIAS_FIELD_NAME, GEO_SHAPE_FIELD_NAME);
        assertEquals(
public class GeoDistanceQueryBuilderTests extends AbstractQueryTestCase<GeoDistanceQueryBuilder> {
            + "    }\n"
            + "    }\n"
            + "    \"geo_distance\":{\n"
        if (randomBoolean()) {
import org.locationtech.spatial4j.shape.Point;
            + "        }\n"
                    queryBuilder.point().lat(),
    }
 * not use this file except in compliance with the License.
            + "\":{\n"
            + "}\n";
     * Overridden here to ensure the test is only run if at least one type is
            + "        }\n"
    public void testParsingAndToQuery12() throws IOException {
            + GEO_POINT_FIELD_NAME
import org.opensearch.test.AbstractQueryTestCase;
            () -> query.distance(randomIntBetween(Integer.MIN_VALUE, 0), DistanceUnit.DEFAULT)
        if (randomBoolean()) {
            + "          \"lat\":40,\n"
    public void testIgnoreUnmapped() throws IOException {
            + "        }\n"
    public void testParsingAndToQuery4() throws IOException {
 * software distributed under the License is distributed on an
            + "\":{\n"
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
import org.opensearch.index.mapper.GeoShapeFieldMapper;
    @Override
    public void testParsingAndToQuery5() throws IOException {
            + "        \"unit\":\"mi\",\n"
            + "    \"boost\" : 1.0\n"
                indexQuery
            + "    }\n"
                    queryBuilder.distance()
 * KIND, either express or implied.  See the License for the
        GeoDistanceQueryBuilder query = new GeoDistanceQueryBuilder("fieldName");
        assertEquals("geohash must not be null or empty", e.getMessage());
            + "\":{\n"
        assertEquals(json, 12000.0, parsed.distance(), 0.0001);
            + "\":{\n"
            + "    }\n"
            + "      \"distance\":\"19.312128\",\n"
        String query = "{\n"
            + GEO_POINT_FIELD_NAME
 * specific language governing permissions and limitations
 *
        String query = "{\n"
        assertEquals("distance unit must not be null", e.getMessage());
            + "\":{\n"
            + "            \"lat\":40,\n"
 * under the License.
        GeoDistanceQueryBuilder parsed = (GeoDistanceQueryBuilder) parseQuery(json);
            + "    \"geo_distance\":{\n"
/*
    }
            + "    \"geo_distance\":{\n"
            + "        \"distance\":\"19.312128km\",\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            + "}\n";
            + GEO_POINT_FIELD_NAME
            + "        \""
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
            + "  }\n"
            + "    \"geo_distance\":{\n"
            + "    \"geo_distance\":{\n"
            + "            \"lon\":-70\n"
                    queryBuilder.distance()
import org.opensearch.common.geo.GeoPoint;
            + "  \"geo_distance\" : {\n"
            + "\":[-70, 40]\n"
            + "        \""
            + "    }\n"
            + "    }\n"
        assertEquals(json, 40.0, parsed.point().getLat(), 0.0001);
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(shardContext));
            );
        String query = "{\n"
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
 * Modifications Copyright OpenSearch Contributors. See
            ((IndexOrDocValuesQuery) parsedQuery).getIndexQuery().toString(),
    }
            + "  }\n"
        }
        assertThat(e.getMessage(), containsString("failed to find geo field [unmapped]"));
            + "    \"geo_distance\":{\n"
        switch (selector) {
            + "            \"lat\":40,\n"
        String query = "{\n"
        assertEquals("[geo_distance] query doesn't support multiple fields, found [point1] and [point2]", e.getMessage());
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.CoreMatchers.instanceOf;
        );
            + "      \"lat\" : 30, \"lon\" : 12\n"
        e = expectThrows(IllegalArgumentException.class, () -> query.distance(""));
            + "}\n";
        e = expectThrows(IllegalArgumentException.class, () -> query.geohash(""));
    }
 */
            + "            \"lon\":-70\n"
            + "            \"lat\":40,\n"
            + "        \""
        assertEquals("fieldName must not be null or empty", e.getMessage());
        return qb;
            + GEO_POINT_FIELD_NAME
 * SPDX-License-Identifier: Apache-2.0
            + "  }\n"
            + "      \""
}
            + "        \""
            + "    \"geo_distance\":{\n"
            + GEO_POINT_FIELD_NAME
                break;
    }
            + GEO_POINT_FIELD_NAME
            qb.geoDistance(randomFrom(GeoDistance.values()));
            assertEquals(
        e = expectThrows(IllegalArgumentException.class, () -> query.distance(null, DistanceUnit.DEFAULT));
            + GEO_POINT_FIELD_NAME
 * GitHub history for details.
            + "    \"geo_distance\":{\n"
    }
    }
    @Override
    }
        failingQueryBuilder.ignoreUnmapped(false);
 * You may obtain a copy of the License at
            + "\":\"drn5x1g8cu2y\"\n"
                LatLonDocValuesField.newSlowDistanceQuery(
    }
import static org.hamcrest.CoreMatchers.containsString;
        } else if (fieldType.unwrap() instanceof GeoPointFieldMapper.GeoPointFieldType) {
    protected GeoDistanceQueryBuilder doCreateTestQueryBuilder() {
        qb.point(new GeoPoint(p.getY(), p.getX()));
 * license agreements. See the NOTICE file distributed with
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
        Point p = RandomShapeGenerator.xRandomPoint(random());
 * this work for additional information regarding copyright
                qb.distance(distance, randomFrom(DistanceUnit.values()));
            + "}\n";
            );
        e = expectThrows(IllegalArgumentException.class, () -> query.distance(null));
            DistanceUnit unit = randomFrom(DistanceUnit.values());
            + "        }\n"
import org.opensearch.core.common.ParsingException;
                qb.distance(randomDouble(), randomFrom(DistanceUnit.values()));
                break;
        GeoPoint geoPoint = GeoPoint.fromGeohash("drn5x1g8cu2y");
            case 2:
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoDistanceQueryBuilder(""));
    /**
            + "        \"distance\":\"12mi\",\n"
            + "    \"distance_type\" : \"arc\",\n"
        assertEquals("geoDistance must not be null", e.getMessage());
            + "            \"lon\":-70\n"
            + "            \"lat\":40,\n"
            qb.ignoreUnmapped(randomBoolean());
        super.testToQuery();
