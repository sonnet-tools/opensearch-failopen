        assertEquals("[geo_distance] query doesn't support multiple fields, found [point1] and [point2]", e.getMessage());
     * explicitly mapped  
        }
    public void testParsingAndToQuery2() throws IOException {
import org.apache.lucene.document.LatLonDocValuesField;
        qb.point(new GeoPoint(p.getY(), p.getX()));
        GeoDistanceQueryBuilder qb = new GeoDistanceQueryBuilder(fieldName);
    public void testFromJson() throws IOException {  
    public void testParsingAndToQuery8() throws IOException {
            + "            \"lon\":-70\n"  
import org.opensearch.core.common.ParsingException;  
            + "        \"distance\":\"12mi\",\n"
    }  
            + GEO_POINT_FIELD_NAME  
        String query = "{\n"
                    expectedFieldName,  
 */  
        assertThat(query, instanceOf(MatchNoDocsQuery.class));  
        String fieldName = randomFrom(GEO_POINT_FIELD_NAME, GEO_POINT_ALIAS_FIELD_NAME, GEO_SHAPE_FIELD_NAME);
 * specific language governing permissions and limitations
            + "\":{\n"
 * Licensed to Elasticsearch under one or more contributor  
            + "}\n";  
 * not use this file except in compliance with the License.
                    queryBuilder.point().lat(),
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.KILOMETERS);  
        e = expectThrows(IllegalArgumentException.class, () -> query.distance("", DistanceUnit.DEFAULT));
        String query = "{\n"
    protected GeoDistanceQueryBuilder doCreateTestQueryBuilder() {  
            DistanceUnit unit = randomFrom(DistanceUnit.values());
 */
            + "        \"distance\":\"12\",\n"  
            + GEO_POINT_FIELD_NAME
            + "            \"lat\":40,\n"
            qb.ignoreUnmapped(randomBoolean());  
            + GEO_POINT_FIELD_NAME  
            + "    }\n"
                    queryBuilder.point().lon(),  
            + "      \""
            + "        }\n"  
            + "            \"lon\":-70\n"  
    public void testParsingAndToQuery1() throws IOException {
            + "    \"ignore_unmapped\" : false,\n"
            qb.setValidationMethod(randomFrom(GeoValidationMethod.values()));
    }
        String json = "{\n"  
            + "            \"lat\":40,\n"
        }  
            + "    \"geo_distance\":{\n"  
import org.opensearch.index.mapper.GeoPointFieldMapper;
 * SPDX-License-Identifier: Apache-2.0
     * Overridden here to ensure the test is only run if at least one type is
            + "    },\n"
import org.opensearch.test.geo.RandomShapeGenerator;
        e = expectThrows(IllegalArgumentException.class, () -> query.geoDistance(null));
    }
            + "            \"lon\":-70\n"
            + "}\n";
 * ownership. Elasticsearch licenses this file to you under  
        failingQueryBuilder.ignoreUnmapped(false);  
    public void testParsingAndToQuery4() throws IOException {
        QueryShardContext shardContext = createShardContext();  
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
 * the Apache License, Version 2.0 (the "License"); you may
            case 1:
        if (randomBoolean()) {
        GeoDistanceQueryBuilder parsed = (GeoDistanceQueryBuilder) parseQuery(json);
            + "    \"geo_distance\":{\n"
        assertEquals("geohash must not be null or empty", e.getMessage());
            + "            \"lat\":40,\n"
    public void testParsingAndToQuery9() throws IOException {
            + "}\n";  
 */  
    public void testParsingAndToQuery12() throws IOException {  
                dvQuery  
            + "  }\n"
 * software distributed under the License is distributed on an
            + "\":{\n"  
        assertThat(e.getMessage(), containsString("failed to find geo field [unmapped]"));
    public void testIgnoreUnmapped() throws IOException {  
    }
                ),
            + "    \"point2\" : {\n"
 * Unless required by applicable law or agreed to in writing,
        assertEquals(  
        assertEquals("distance unit must not be null", e.getMessage());
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
/*  
 *
    @Override
            () -> query.distance(randomIntBetween(Integer.MIN_VALUE, 0), DistanceUnit.DEFAULT)
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.KILOMETERS);
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
            + "}\n";  
            + "        \"unit\":\"km\",\n"  
            + GEO_POINT_FIELD_NAME  
            assertEquals(GeoShapeFieldMapper.GeoShapeFieldType.class, fieldType.getClass());  
            + "    \"geo_distance\":{\n"  
            + "\":{\n"
            + "        \""
    }
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());  
 *
    }
import static org.hamcrest.CoreMatchers.containsString;
        assertEquals("distance must not be null or empty", e.getMessage());
            + "    \"boost\" : 1.0\n"
            + "        \"distance\":\"19.312128\",\n"
        String query = "{\n"
            + "        \""
        );  
            );
            + "  \"geo_distance\" : {\n"
        GeoPoint geoPoint = GeoPoint.fromGeohash("drn5x1g8cu2y");
import org.locationtech.spatial4j.shape.Point;  
            + "\":{\n"
    /**  
    }
            + "        \""
            + "\":\"40, -70\"\n"
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());  
    }
            + "    \"validation_method\" : \"STRICT\",\n"  
            assertTrue("Found no indexed geo query.", query instanceof MatchNoDocsQuery);
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(shardContext));
        }
import java.io.IOException;
        assertEquals("distance must be greater than zero", e.getMessage());
            + "            \"lon\":-70\n"  
        String query = "{\n"
    @Override
            + "          \"lat\":40,\n"
        String query = "{\n"  
    @Override
            + "\":\"drn5x1g8cu2y\"\n"
            "mapped_geo_point:" + lat + "," + lon + " +/- " + distanceUnit.toMeters(distance) + " meters"
            ((IndexOrDocValuesQuery) parsedQuery).getIndexQuery().toString(),
            + "            \"lon\":-70\n"  
                LatLonPoint.newDistanceQuery(
        checkGeneratedJson(json, parsed);  
    private void assertGeoDistanceRangeQuery(String query, double lat, double lon, double distance, DistanceUnit distanceUnit)
                break;  
            qb.geoDistance(randomFrom(GeoDistance.values()));
        assertEquals("geoDistance must not be null", e.getMessage());  
        String distance = "" + randomDouble();  
            + "            \"lon\":-70\n"
import static org.hamcrest.CoreMatchers.notNullValue;
    public void testParsingAndToQuery3() throws IOException {
import org.opensearch.test.AbstractQueryTestCase;
        String json = "{\n"
    }
            + "    }\n"
        e = expectThrows(  
        assertThat(query, notNullValue());
            + "}\n";
            + GEO_POINT_FIELD_NAME
            + GEO_POINT_FIELD_NAME  
        assertEquals("distance must not be null or empty", e.getMessage());  
        if (randomBoolean()) {  
            );  
        GeoDistanceQueryBuilder query = new GeoDistanceQueryBuilder("fieldName");  
     * present in the mappings. Geo queries do not execute if the field is not
            + "        }\n"
        e = expectThrows(IllegalArgumentException.class, () -> query.distance("1", null));
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.KILOMETERS);  
            + "    }\n"
import org.opensearch.common.geo.GeoDistance;  
    public void testParsingAndToQuery6() throws IOException {  
    }
            + "}\n";  
            IllegalArgumentException.class,
            + "    }\n"
/*
            + "}\n";  
        String query = "{\n"
            + "            \"lat\":40,\n"
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.DEFAULT);
            + "\":{\n"  
            + "        }\n"
            + "        \"distance\":19.312128,\n"
                    queryBuilder.distance()
 * GitHub history for details.
/*  
        assertEquals("distance must not be null or empty", e.getMessage());
 * license agreements. See the NOTICE file distributed with
        } else {
            + "    \"geo_distance\":{\n"  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoDistanceQueryBuilder(""));  
        assertGeoDistanceRangeQuery(query, 40, -70, 19.312128, DistanceUnit.DEFAULT);
            + "      }\n"
        assertEquals("distance must not be null or empty", e.getMessage());
    protected void doAssertLuceneQuery(GeoDistanceQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        assertEquals("distance unit must not be null", e.getMessage());
    public void testParsingAndToQuery5() throws IOException {
            + "    }\n"
        String query = "{\n"
            + GEO_POINT_FIELD_NAME  
            + "        \"distance\":\"12mi\",\n"
            + "        }\n"
            + "            \"lat\":40,\n"
 * Modifications Copyright OpenSearch Contributors. See
            + "\":{\n"
            + "        \"unit\":\"mi\",\n"
        Query query = queryBuilder.toQuery(shardContext);
            + "        \""
            + "        \"distance\":\"12mi\",\n"
            + "    }\n"
            + GEO_POINT_FIELD_NAME  
            + "            \"lat\":40,\n"
            + "        \""
                qb.distance(randomDouble(), randomFrom(DistanceUnit.values()));
import org.opensearch.common.unit.DistanceUnit;
 * The OpenSearch Contributors require contributions made to  
            + "    }\n"
    }  
        assertGeoDistanceRangeQuery(query, geoPoint.getLat(), geoPoint.getLon(), 12, DistanceUnit.MILES);
        final GeoDistanceQueryBuilder queryBuilder = new GeoDistanceQueryBuilder("unmapped").point(0.0, 0.0).distance("20m");
            + "            \"lat\":40,\n"  
            Query indexQuery = ((IndexOrDocValuesQuery) query).getIndexQuery();
        );  
            + "    \"pin.location\" : [ -70.0, 40.0 ],\n"  
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
            + "}\n";  
        assertEquals(json, -70.0, parsed.point().getLon(), 0.0001);
            + GEO_POINT_FIELD_NAME  
        String query = "{\n"
            + "        }\n"  
        if (fieldType == null) {
            + "}";  
    }
            + "        \"distance\":\"12mi\",\n"
        assertEquals(json, 12000.0, parsed.distance(), 0.0001);  
            case 2:
    }  
            + "    }\n"
        e = expectThrows(IllegalArgumentException.class, () -> new GeoDistanceQueryBuilder((String) null));  
            + "            \"lon\":-70\n"
            case 0:
            + GEO_POINT_FIELD_NAME
            + "    \"geo_distance\":{\n"  
            + "}\n";
            + "      \"lat\" : 30, \"lon\" : 12\n"  
}
        String query = "{\n"
            + "    \"geo_distance\":{\n"
                qb.distance(distance, randomFrom(DistanceUnit.values()));
        int selector = randomIntBetween(0, 2);
            + "    }\n"
            + "        \""
    }
 * this file be licensed under the Apache-2.0 license or a
        switch (selector) {  
        // The parsedQuery contains IndexOrDocValuesQuery, which wraps LatLonPointDistanceQuery which in turn has default visibility,
        if (randomBoolean()) {
            + "        \""
    }
            + "        \""
 * KIND, either express or implied.  See the License for the
        e = expectThrows(IllegalArgumentException.class, () -> query.geohash(null));  
            + "        \"unit\":\"km\",\n"
import org.opensearch.index.mapper.GeoShapeFieldMapper;
            + "    }\n"
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);  
    public void testParsingAndToQuery11() throws IOException {  
    }
            + "    \"point1\" : {\n"
import org.apache.lucene.document.LatLonPoint;
            + "\":{\n"
            distance = distance + unit.toString();  
            + "        \""  
        }
            + "    \"geo_distance\":{\n"  
            + "        \"distance\":12,\n"
            + "        \""
                break;  
        e = expectThrows(IllegalArgumentException.class, () -> query.distance(""));
            + "    \"geo_distance\":{\n"
            + "\":{\n"
        Point p = RandomShapeGenerator.xRandomPoint(random());  
            + "        }\n"
import org.apache.lucene.search.Query;
import org.apache.lucene.search.MatchNoDocsQuery;
            + "          \"lon\":-70\n"  
            + "}\n";  
            Query dvQuery = ((IndexOrDocValuesQuery) query).getRandomAccessQuery();
    public void testParsingAndToQuery10() throws IOException {
        String query = "{\n"
        }
            + "        }\n"  
        throws IOException {
        assertEquals(json, 40.0, parsed.point().getLat(), 0.0001);
     */
        e = expectThrows(IllegalArgumentException.class, () -> query.distance(1, null));  
            + "    \"geo_distance\":{\n"
            + "}\n";  
    }  
package org.opensearch.index.query;
            + "}";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals("fieldName must not be null or empty", e.getMessage());
        }
    }  
            + "      \"lat\" : 30, \"lon\" : 12\n"  
            + "  \"geo_distance\" : {\n"
            + "    \"distance\" : 12000.0,\n"
        super.testToQuery();
    }
        // so we cannot access its fields directly to check and have to use toString() here instead.
            + GEO_POINT_FIELD_NAME  
import static org.hamcrest.CoreMatchers.instanceOf;  
            + "    \"geo_distance\":{\n"  
            + "    \"geo_distance\":{\n"
    public void testIllegalValues() {
        } else if (fieldType.unwrap() instanceof GeoPointFieldMapper.GeoPointFieldType) {  
 * this work for additional information regarding copyright
import org.opensearch.common.geo.GeoPoint;
            + "  }\n"  
        if (randomBoolean()) {
    }
                    queryBuilder.point().lat(),
 *  
            + "  \"geo_distance\":{\n"  
import org.opensearch.index.mapper.MappedFieldType;  
                    queryBuilder.point().lon(),
 *     http://www.apache.org/licenses/LICENSE-2.0
            + GEO_POINT_FIELD_NAME
            + "        \"unit\":\"km\",\n"
        final MappedFieldType fieldType = context.getFieldType(queryBuilder.fieldName());  
            + "      \"distance\":\"19.312128\",\n"
        e = expectThrows(IllegalArgumentException.class, () -> query.distance(null, DistanceUnit.DEFAULT));
                break;  
            + "        \"distance\":\"19.312128km\",\n"  
            + "    \"distance_type\" : \"arc\",\n"
        final GeoDistanceQueryBuilder failingQueryBuilder = new GeoDistanceQueryBuilder("unmapped").point(0.0, 0.0).distance("20m");
            + "        \"unit\":\"mi\",\n"  
            + "    }\n"
                indexQuery
        assertGeoDistanceRangeQuery(query, 40, -70, 12, DistanceUnit.MILES);
 * under the License.  
            + "            \"lat\":40,\n"
            + "        \"distance\":\"12mi\",\n"  
    public void testParseFailsWithMultipleFields() throws IOException {
            + "\":[-70, 40]\n"
        String query = "{\n"
public class GeoDistanceQueryBuilderTests extends AbstractQueryTestCase<GeoDistanceQueryBuilder> {  
            + "        \""
            + "        \"distance\":19.312128,\n"
        return qb;
            + "        }\n"
        String query = "{\n"  
                LatLonDocValuesField.newSlowDistanceQuery(  
        e = expectThrows(IllegalArgumentException.class, () -> query.geohash(""));
            + "            \"lon\":-70\n"
            + "  }\n"
    public void testToQuery() throws IOException {  
                    queryBuilder.distance()  
            assertEquals(
 * compatible open source license.
    public void testParsingAndToQuery7() throws IOException {
            + "}\n";
 * You may obtain a copy of the License at  
        assertEquals("fieldName must not be null or empty", e.getMessage());
        queryBuilder.ignoreUnmapped(true);
                qb.distance(distance);
            + "    }\n"  
            + "\":{\n"  
        e = expectThrows(IllegalArgumentException.class, () -> query.distance(null));  
import org.apache.lucene.search.IndexOrDocValuesQuery;  
                    expectedFieldName,
            assertEquals(
                ),
        assertEquals("geohash must not be null or empty", e.getMessage());  
