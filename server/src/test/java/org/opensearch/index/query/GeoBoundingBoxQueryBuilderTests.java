            + "      \"bottom_right\" : \"dq\"\n"
 * Unless required by applicable law or agreed to in writing,
    public void testExceptionOnMissingTypes() {
        assertEquals(json, 1.0, parsed.boost(), 0.0001);
            if (useBrokenDouble) {  
        String query = "{\n"
            + "    \"pin.location\" : {\n"
                    + tester.getClass().getName()
    public void testFromWKT() throws IOException {
            + GEO_POINT_FIELD_NAME
 * not use this file except in compliance with the License.
            + "\":{\n"  
            + "            }\n"  
        double left = builder.topLeft().getLon();
        qb.ignoreUnmapped(false);
            + "    \"ignore_unmapped\" : false,\n"
                LatLonPoint.newBoxQuery(
            + "}\n";
 * KIND, either express or implied.  See the License for the
            + "    \"boost\" : 1.0\n"  
                except
                );
            GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();  
            // check the bottom-left/ top-right combination of setters  
            assertEquals(  
        }  
        assertGeoBoundingBoxQuery(query);
        assertEquals(json, 40.73, parsed.topLeft().getLat(), 0.0001);
            + "}\n";
        GeoBoundingBoxQueryBuilder parsed = (GeoBoundingBoxQueryBuilder) parseQuery(wkt);
        builder.type(randomFrom(GeoExecType.values()));
            switch (path) {
            + GEO_POINT_FIELD_NAME  
        public void fillIn(double coordinate, GeoBoundingBoxQueryBuilder qb) {
            + "            \"right\": -80,\n"
            + "    \""
            + "    \"boost\" : 1.0\n"  
 * license agreements. See the NOTICE file distributed with
        assertGeoBoundingBoxQuery(query);  
        assumeTrue("top should not be equal to bottom for flip check", top != bottom);  
    }
            + "      \"top_left\" : [ -78.75, 45.0 ],\n"
    }
            assertNull(  
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();  
        @Override  
    public abstract class PointTester {  
            + "    }\n"
        QueryShardException e = expectThrows(QueryShardException.class, () -> qb.toQuery(context));
        }
 * You may obtain a copy of the License at  
            + "  \"geo_bounding_box\" : {\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
        public void invalidateCoordinate(GeoBoundingBoxQueryBuilder qb, boolean useBrokenDouble) {
        }
            if (randomBoolean()) {
                    GeohashUtils.encodeLatLon(box.getMaxY(), box.getMaxX())  
 * under the License.  
        OpenSearchParseException e1 = expectThrows(OpenSearchParseException.class, () -> parseQuery(jsonGeohashAndWkt));
                builder.setCornersOGC(
                    + tester.invalidCoordinate,  
            + "    \"validation_method\": \"COERCE\",\n"  
        PointTester[] testers = { new TopTester(), new LeftTester(), new BottomTester(), new RightTester() };
                    break;
        // just check if we can parse the query
        public void fillIn(double coordinate, GeoBoundingBoxQueryBuilder qb) {  
            + "    }\n"  
    }
            + GEO_POINT_FIELD_NAME
            + "    \"boost\" : 1.0\n"
            tester.invalidateCoordinate(builder.setValidationMethod(GeoValidationMethod.COERCE), false);
                default:
        assertThat(e.getMessage(), containsString("top is below bottom corner:"));
            + "        \"lon\": 181\n"
            + "  }\n"
        checkGeneratedJson(expectedJson, parsed);  
 * Licensed to Elasticsearch under one or more contributor  
            + "    },\n"  
            + "    },\n"  
            + "    \"type\" : \"MEMORY\",\n"
import org.locationtech.spatial4j.io.GeohashUtils;
            + "    \"geo_bounding_box\":{\n"
    }
            + "    \"pin.location\" : {\n"  
        assertThat(e1.getMessage(), containsString("Conflicting definition found using well-known text and explicit corners."));  
        public void fillIn(double coordinate, GeoBoundingBoxQueryBuilder qb) {
package org.opensearch.index.query;
            + "        \""
                    break;
            + "    \"pin.location\" : {\n"
            + "    \"geo_bounding_box\":{\n"
import java.io.IOException;  
                    + tester.invalidCoordinate
        assertEquals(expectedJson, "pin.location", parsed.fieldName());
 * the Apache License, Version 2.0 (the "License"); you may
            + "      \"bottom_right\" : [ -71.12, 40.01 ]\n"
    public void testParsingAndToQuery2() throws IOException {
    }
        if (randomBoolean()) {
        assertEquals(expectedJson, -71.12, parsed.bottomRight().getLon(), delta);
                    builder.setCorners(box.getMaxY(), box.getMinX(), box.getMinY(), box.getMaxX());  
            assertNotNull(
        builder.setValidationMethod(GeoValidationMethod.STRICT);  
            + "}";
        public LeftTester() {
    }  
            );  
            assertEquals(
        QueryShardContext shardContext = createShardContext();
    }
import org.opensearch.common.geo.GeoUtils;
            + "    \"validation_method\" : \"STRICT\",\n"
            + "    \"type\" : \"MEMORY\",\n"  
        assertEquals(json, -67.5, parsed.bottomRight().getLon(), 0.0001);  
            super(randomDoubleBetween(GeoUtils.MAX_LON, Double.MAX_VALUE, true));  
import org.apache.lucene.document.LatLonPoint;
        assertEquals(expectedJson, -74.1, parsed.topLeft().getLon(), delta);  
            + "    }\n"
        double left = builder.topLeft().getLon();  
        public RightTester() {
        if (randomBoolean()) {
                    );  
            + "    \"ignore_unmapped\" : false,\n"  
            + "    \"ignore_unmapped\" : false,\n"
    }  
import org.opensearch.index.mapper.MappedFieldType;
        if (randomBoolean()) {  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(json, 40.01, parsed.bottomRight().getLat(), 0.0001);  
                ),
        double left = builder.topLeft().getLon();
                "validation w/ coerce should ignore invalid "
            builder.ignoreUnmapped(randomBoolean());
import org.opensearch.OpenSearchParseException;  
        GeoBoundingBoxQueryBuilder qb = createTestQueryBuilder();  
/*  
        double top = builder.topLeft().getLat();
            + "  }\n"
            + "                \"lat\":40,\n"  
                case 1:
            + "            \"bottom\": 30\n"
 */  
            + "}\n";
                "validation w/o coerce should detect invalid coordinate: "  
import org.apache.lucene.search.IndexOrDocValuesQuery;  
        String expectedJson = "{\n"
    public class LeftTester extends PointTester {  
        }  
            + "                \"lon\":-70\n"
    }
            + "            \"top_right\":\"40, -80\",\n"
        }  
                        GeohashUtils.encodeLatLon(box.getMaxY(), box.getMinX()),
        PointTester[] testers = { new TopTester(), new LeftTester(), new BottomTester(), new RightTester() };
        assertGeoBoundingBoxQuery(query);  
            super(randomDoubleBetween(-Double.MAX_VALUE, GeoUtils.MIN_LAT, false));
            assertTrue("Found no indexed geo query.", query instanceof MatchNoDocsQuery);
                    queryBuilder.topLeft().lon(),
    public void testHonorsCoercion() throws IOException {  
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());  
            + "        \""  
            + GEO_POINT_FIELD_NAME  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.type((String) null));  
        @Override
        logger.info("top: {} bottom: {}", top, bottom);
                fillIn(invalidCoordinate, qb);  
    public void testBrokenCoordinateCannotBeSet() {  
        String query = "{\n"
        String fieldName = randomFrom(GEO_POINT_FIELD_NAME, GEO_POINT_ALIAS_FIELD_NAME, GEO_SHAPE_FIELD_NAME);  
    }
            + "            \"bottom_right\":{\n"  
                indexQuery  
    public void testParsingAndToQuery4() throws IOException {  
        for (PointTester tester : testers) {
        return builder;
            + GEO_POINT_FIELD_NAME
 * ownership. Elasticsearch licenses this file to you under  
        }  
        failingQueryBuilder.ignoreUnmapped(false);
        }
        }
        builder.setValidationMethod(GeoValidationMethod.STRICT);  
    }
            + "        }\n"  
            + "            },\n"
            + "    },\n"
            + "    \"validation_method\" : \"STRICT\",\n"  
import org.apache.lucene.document.LatLonDocValuesField;
        for (PointTester tester : testers) {
            + "            \"bottom_right\":\"30, -80\"\n"
        builder.setValidationMethod(GeoValidationMethod.IGNORE_MALFORMED).setCorners(top, right, bottom, left);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder.setCorners(bottom, left, top, right));
        // geojson generated content
            + "            \"bottom_left\":\"30, -70\"\n"  
            int path = randomIntBetween(0, 2);  
            + "}";  
    }  
            + "  }\n"
            + "        \""
    public void testTopBottomCanBeFlippedOnIgnoreMalformed() {
import org.locationtech.spatial4j.shape.Rectangle;  
        GeoBoundingBoxQueryBuilder qb = new GeoBoundingBoxQueryBuilder("teststring");
        public TopTester() {
                    + " ",
        }  
 *  
        builder.setValidationMethod(GeoValidationMethod.IGNORE_MALFORMED).setCorners(bottom, left, top, right);
        assertEquals(json, -71.12, parsed.bottomRight().getLon(), 0.0001);
        if (fieldType == null) {
    }
            } else {  
            + "    \"validation_method\" : \"STRICT\",\n"
            );
                    + tester.getClass().getName()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.type((GeoExecType) null));  
                    queryBuilder.topLeft().lat(),
            + "    \"type\" : \"MEMORY\",\n"
            + "  }\n"
    }
import org.opensearch.index.mapper.GeoShapeFieldMapper;
                    queryBuilder.bottomRight().lon()
            + "    \"pin.location\" : {\n"
            + "        \""  
            + "  }\n"
            expectThrows(IllegalArgumentException.class, () -> tester.invalidateCoordinate(builder, true));  
        assertGeoBoundingBoxQuery(query);
 * this work for additional information regarding copyright
                    queryBuilder.bottomRight().lat(),  
        double bottom = builder.bottomRight().getLat();  
                    queryBuilder.topLeft().lat(),
 *
}  
    }
            + "}";
            + "    \"validation_method\" : \"STRICT\",\n"
            + "    \"type\" : \"MEMORY\",\n"
 * SPDX-License-Identifier: Apache-2.0
    public void testValidation() {  
        }
            qb.setCorners(qb.topLeft().getLat(), qb.topLeft().getLon(), qb.bottomRight().getLat(), coordinate);
                    expectedFieldName,  
            tester.invalidateCoordinate(builder.setValidationMethod(GeoValidationMethod.STRICT), false);  
    private static Double[] brokenDoubles = { Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };
    @Override
    public void testValidationNullFieldname() {
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(json, GeoExecType.MEMORY, parsed.type());
                    + " coordinate: "  
                dvQuery
                ),
            + "    },\n"
    }
    public void testFromJson() throws IOException {
            + "  \"geo_bounding_box\" : {\n"
            + "            \"top_left\":[-70, 40],\n"  
            + "      \"top_left\" : [ -74.1, 40.73 ],\n"  
        }  
        assertEquals(expectedJson, 40.73, parsed.topLeft().getLat(), delta);
            + "      \"top_left\": {\n"
    }  
    public void testParsingAndToQuery6() throws IOException {
    protected GeoBoundingBoxQueryBuilder doCreateTestQueryBuilder() {
        builder.setValidationMethod(GeoValidationMethod.IGNORE_MALFORMED);
            + "\":{\n"
    public void testStrictnessDefault() {  
            + "            \"top_left\":\"40, -70\",\n"
        String jsonGeohashAndWkt = "{\n"
            + "    }\n"  
            + "    \"geo_bounding_box\":{\n"  
            + "  \"geo_bounding_box\" : {\n"
    protected void doAssertLuceneQuery(GeoBoundingBoxQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
 * software distributed under the License is distributed on an
    public void testMustRewrite() throws IOException {
            + "        \"lon\": 176.5\n"  
            + "      }\n"
            + "                \"lat\":30,\n"
            + "    \"validation_method\" : \"STRICT\",\n"
            + "            \"bottom_right\":\"30, -80\"\n"
                    queryBuilder.topLeft().lon(),  
            + "    }\n"
            + "    \"ignore_unmapped\" : false,\n"  
        assertEquals(expectedJson, 40.01, parsed.bottomRight().getLat(), delta);  
            }
        parseQuery(query).toQuery(shardContext);
        queryBuilder.ignoreUnmapped(true);
        Rectangle box = RandomShapeGenerator.xRandomRectangle(random(), RandomShapeGenerator.xRandomPoint(random()));
    public void testLeftRightCanBeFlipped() {
        String expectedJson = "{\n"
                except  
/*  
            } else {
            except = builder.checkLatLon();
    public void testParsingAndToQuery3() throws IOException {
 */
            "Someone changed the default for coordinate validation - were the docs changed as well?",
 * Modifications Copyright OpenSearch Contributors. See
            + "      \"top_left\" : [ -78.75, 45.0 ],\n"
        String wkt = "{\n"  
            + "            \"top_left\":\"drn5x1g8cu2y\",\n"  
        QueryShardContext context = createShardContextWithNoType();
import static org.hamcrest.CoreMatchers.notNullValue;
    }
            + "        }\n"
        assumeTrue("top should not be equal to bottom for flip check", top != bottom);
        String query = "{\n"
            + "    \"ignore_unmapped\" : false,\n"
        assertFalse(
            + "            \"top\": 40,\n"
        } else if (fieldType.unwrap() instanceof GeoPointFieldMapper.GeoPointFieldType) {  
            Query dvQuery = ((IndexOrDocValuesQuery) query).getRandomAccessQuery();
        }
            assertEquals(GeoShapeFieldMapper.GeoShapeFieldType.class, fieldType.getClass());
            + "  }\n"  
                    builder.setCorners(new GeoPoint(box.getMaxY(), box.getMinX()), new GeoPoint(box.getMinY(), box.getMaxX()));  
                    expectedFieldName,
        assertEquals(json, 45.0, parsed.topLeft().getLat(), 0.0001);
            + "        \""
            + "            \"left\": -70,\n"  
            + "  \"geo_bounding_box\" : {\n"  
        private double brokenCoordinate = randomFrom(brokenDoubles);
        // check the builder's generated geojson content against the expected json output
        Query query = queryBuilder.toQuery(shardContext);  
            + "\":{\n"
import org.apache.lucene.search.Query;
    }
        @Override  
    public void testMalformedGeohashes() {  
                    queryBuilder.bottomRight().lat(),
    public void testValidationNullType() {
            + "      \"wkt\" : \"BBOX (-74.1, -71.12, 40.73, 40.01)\"\n"
            + "\":{\n"
import org.opensearch.index.mapper.GeoPointFieldMapper;  
        assertEquals("Field name must not be empty.", e.getMessage());
            // check the top-left/bottom-right combination of setters
        double right = builder.bottomRight().getLon();
    }
import static org.hamcrest.CoreMatchers.instanceOf;  
            + "    \"type\" : \"MEMORY\",\n"  
import org.opensearch.test.geo.RandomShapeGenerator;
 */  
        String query = "{\n"
        String query = "{\n"
        final GeoBoundingBoxQueryBuilder queryBuilder = new GeoBoundingBoxQueryBuilder("unmapped").setCorners(1.0, 0.0, 0.0, 1.0);  
        // toXContent generates the query in geojson only; for now we need to test against the expected  
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
            + "            \"bottom_right\":[-80, 30]\n"
        assertEquals(json, -78.75, parsed.topLeft().getLon(), 0.0001);
    public class BottomTester extends PointTester {
            + "    \"pin.location\" : {\n"  
        @Override
            + "        }\n"
            this.invalidCoordinate = invalidCoodinate;
            + "    }\n"  
            + "      },\n"
        assertEquals(json, 1.0, parsed.boost(), 0.0001);
        assertEquals(json, 33.75, parsed.bottomRight().getLat(), 0.0001);
            + "}\n";
            + "  \"geo_bounding_box\" : {\n"
                    builder.setCorners(  
        assertThat(e.getMessage(), containsString("failed to find geo field [unmapped]"));
        public BottomTester() {  
        PointTester[] testers = { new TopTester(), new LeftTester(), new BottomTester(), new RightTester() };
 * GitHub history for details.
            + "  }\n"  
import org.opensearch.common.geo.GeoPoint;
            super(randomDoubleBetween(-Double.MAX_VALUE, GeoUtils.MIN_LON, true));
        String json = "{\n"  
            + "}";
    }  
        double right = builder.bottomRight().getLon();
        for (PointTester tester : testers) {  
    public void testParsingAndToQuery5() throws IOException {
        assertEquals(json, GeoExecType.MEMORY, parsed.type());  
            + "\":{\n"  
    public void testBrokenCoordinateCanBeSetWithIgnoreMalformed() {
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
    /** Randomly generate either NaN or one of the two infinity values. */
        GeoBoundingBoxQueryBuilder parsed = (GeoBoundingBoxQueryBuilder) parseQuery(json);  
    }
        }
            + "}\n";  
        } else {
        assertEquals("cannot parse type from null string", e.getMessage());
        QueryShardContext shardContext = createShardContext();  
            + "    \"geo_bounding_box\":{\n"  
            + "        \"lat\": -19.6,\n"  
            GeoValidationMethod.DEFAULT_LENIENT_PARSING  
        assertThat(query, notNullValue());
        checkGeneratedJson(expectedJson, parsed);
        assertEquals(json, -74.1, parsed.topLeft().getLon(), 0.0001);  
 * specific language governing permissions and limitations
            + "    }\n"  
    @Override  
            + "        }\n"
                fillIn(brokenCoordinate, qb);
        GeoBoundingBoxQueryBuilder builder = new GeoBoundingBoxQueryBuilder(fieldName);
        String json = "{\n"  
            + "}\n";
        private double invalidCoordinate;
            + "      \"wkt\" : \"BBOX (-74.1, -71.12, 40.73, 40.01)\"\n"  
            builder.setValidationMethod(randomFrom(GeoValidationMethod.values()));  
        }  
                LatLonDocValuesField.newSlowBoxQuery(
            }
        GeoBoundingBoxQueryBuilder parsed = (GeoBoundingBoxQueryBuilder) parseQuery(json);
        double top = builder.topLeft().getLat();
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "      \"bottom_right\" : [ -71.12, 40.01 ]\n"  
            }
    }
        final GeoBoundingBoxQueryBuilder failingQueryBuilder = new GeoBoundingBoxQueryBuilder("unmapped").setCorners(1.0, 0.0, 0.0, 1.0);
        protected abstract void fillIn(double fillIn, GeoBoundingBoxQueryBuilder qb);
        assertEquals(json, "pin.location", parsed.fieldName());  
            + "      \"top_left\" : \"dr\",\n"  
        );
        GeoBoundingBoxQueryBuilder qb = new GeoBoundingBoxQueryBuilder("teststring");
        assertEquals("failed to find geo field [" + qb.fieldName() + "]", e.getMessage());  
        assertGeoBoundingBoxQuery(query);
    }
            + "    \"boost\" : 1.0\n"
    public class TopTester extends PointTester {
    }  
    public void testIgnoreUnmapped() throws IOException {
    }  
        // parse with wkt  
    public void testValidationNullTypeString() {
        public PointTester(double invalidCoodinate) {
            qb.setCorners(qb.topLeft().getLat(), coordinate, qb.bottomRight().getLat(), qb.bottomRight().getLon());
            );
            + "        }\n"
        }
            + GEO_POINT_FIELD_NAME
            + "  \"geo_bounding_box\": {\n"
            + "    \"pin.location\" : {\n"
            + "      \"top_left\" : [ -74.1, 40.73 ],\n"
            + "    \"ignore_unmapped\" : false,\n"
    }
        assertEquals(json, "pin.location", parsed.fieldName());
 *
public class GeoBoundingBoxQueryBuilderTests extends AbstractQueryTestCase<GeoBoundingBoxQueryBuilder> {  
        assertEquals("Type is not allowed to be null.", e.getMessage());
            + "}";
            + "    },\n"
        super.testMustRewrite();
    private void assertGeoBoundingBoxQuery(String query) throws IOException {
/*
        } else {
    }  
    }  
                    + " coordinate: "
        double bottom = builder.bottomRight().getLat();
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(shardContext));  
import org.opensearch.test.AbstractQueryTestCase;  
            assertEquals(IndexOrDocValuesQuery.class, query.getClass());
        double delta = 0d;
            super(randomDoubleBetween(GeoUtils.MAX_LAT, Double.MAX_VALUE, false));  
        double top = builder.topLeft().getLat();  
                    queryBuilder.bottomRight().lon()  
            + "      \"bottom_right\" : [ -67.5, 33.75 ]\n"
        checkGeneratedJson(json, parsed);
            tester.invalidateCoordinate(builder, true);
        final MappedFieldType fieldType = context.fieldMapper(queryBuilder.fieldName());  
    }  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoBoundingBoxQueryBuilder((String) null));  
        String query = "{\n"  
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
import org.apache.lucene.search.MatchNoDocsQuery;
        }
    public void testTopBottomCannotBeFlipped() {  
    @Override
            + "  \"geo_bounding_box\" : {\n"
        double bottom = builder.bottomRight().getLat();
            + "    \"geo_bounding_box\":{\n"
                builder.setCornersOGC(new GeoPoint(box.getMinY(), box.getMinX()), new GeoPoint(box.getMaxY(), box.getMaxX()));
            + "    \"boost\" : 1.0\n"
            qb.setCorners(coordinate, qb.topLeft().getLon(), qb.bottomRight().getLat(), qb.bottomRight().getLon());
        builder.setValidationMethod(GeoValidationMethod.STRICT).setCorners(top, right, bottom, left);  
            + "    \"boost\" : 1.0\n"
        String query = "{\n"  
            + "}";  
    public class RightTester extends PointTester {
        }  
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
        double right = builder.bottomRight().getLon();  
            + "      \"bottom_right\": {\n"
        assertEquals(expectedJson, GeoExecType.MEMORY, parsed.type());
            + "        }\n"
        public void fillIn(double coordinate, GeoBoundingBoxQueryBuilder qb) {
            Query indexQuery = ((IndexOrDocValuesQuery) query).getIndexQuery();
            + "                \"lon\":-80\n"
            + "\": {\n"  
                    GeohashUtils.encodeLatLon(box.getMinY(), box.getMinX()),
    }
    }
    public void testFromGeohash() throws IOException {
import static org.hamcrest.CoreMatchers.containsString;
    public void testParsingAndToQuery1() throws IOException {  
 * compatible open source license.
            qb.setCorners(qb.topLeft().getLat(), qb.topLeft().getLon(), coordinate, qb.bottomRight().getLon());  
            + "        \"lat\": -15.5,\n"
            );
            QueryValidationException except = null;
                        GeohashUtils.encodeLatLon(box.getMinY(), box.getMaxX())
            except = builder.checkLatLon();
        assertGeoBoundingBoxQuery(query);
            + "    \"geo_bounding_box\":{\n"
            + "        \""
            + "\":{\n"
            + GEO_POINT_FIELD_NAME
                case 0:
            + "}\n";  
            + "    \"type\" : \"MEMORY\",\n"
            + "    \"validation_method\" : \"STRICT\",\n"  
        assertGeoBoundingBoxQuery(query);
            + "            \"top_left\":{\n"
        assertEquals(expectedJson, 1.0, parsed.boost(), delta);
            + "    },\n"
