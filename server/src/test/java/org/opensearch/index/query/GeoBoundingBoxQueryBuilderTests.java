 * SPDX-License-Identifier: Apache-2.0
    }
            + "      \"bottom_right\" : [ -71.12, 40.01 ]\n"
            expectThrows(IllegalArgumentException.class, () -> tester.invalidateCoordinate(builder, true));
import static org.hamcrest.CoreMatchers.notNullValue;
                    );
}
            + "    },\n"
            + "    \"validation_method\" : \"STRICT\",\n"
        assertEquals(expectedJson, 1.0, parsed.boost(), delta);
import org.opensearch.index.mapper.MappedFieldType;
            + GEO_POINT_FIELD_NAME
            + "    \"geo_bounding_box\":{\n"
        final MappedFieldType fieldType = context.fieldMapper(queryBuilder.fieldName());
            + "            \"top_right\":\"40, -80\",\n"
                    queryBuilder.topLeft().lon(),
            + "  \"geo_bounding_box\": {\n"
    public void testFromJson() throws IOException {
            + "            \"bottom_right\":[-80, 30]\n"
            + "\":{\n"
                    + tester.getClass().getName()
        String query = "{\n"
            + "    \"type\" : \"MEMORY\",\n"
import org.locationtech.spatial4j.shape.Rectangle;
            + "            \"right\": -80,\n"
 */
        builder.setValidationMethod(GeoValidationMethod.STRICT).setCorners(top, right, bottom, left);
            + "    \"boost\" : 1.0\n"
    }
 * KIND, either express or implied.  See the License for the
    }
            + "        \"lat\": -15.5,\n"
        String expectedJson = "{\n"
            + "    \"pin.location\" : {\n"
    }
            + "}";
            int path = randomIntBetween(0, 2);
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "  }\n"
                builder.setCornersOGC(
import org.locationtech.spatial4j.io.GeohashUtils;
        // toXContent generates the query in geojson only; for now we need to test against the expected
 * the Apache License, Version 2.0 (the "License"); you may
            except = builder.checkLatLon();
    public void testParsingAndToQuery3() throws IOException {
 * The OpenSearch Contributors require contributions made to
        @Override
        for (PointTester tester : testers) {
            + "    \"geo_bounding_box\":{\n"
            + "    \"geo_bounding_box\":{\n"
    public void testLeftRightCanBeFlipped() {
/*
        double top = builder.topLeft().getLat();
        checkGeneratedJson(expectedJson, parsed);
            super(randomDoubleBetween(-Double.MAX_VALUE, GeoUtils.MIN_LON, true));
        final GeoBoundingBoxQueryBuilder failingQueryBuilder = new GeoBoundingBoxQueryBuilder("unmapped").setCorners(1.0, 0.0, 0.0, 1.0);
            assertEquals(
    public void testParsingAndToQuery5() throws IOException {
    public void testParsingAndToQuery1() throws IOException {
            "Someone changed the default for coordinate validation - were the docs changed as well?",
    public class LeftTester extends PointTester {
                    GeohashUtils.encodeLatLon(box.getMinY(), box.getMinX()),
            + "            \"bottom_right\":\"30, -80\"\n"
        }
        public void fillIn(double coordinate, GeoBoundingBoxQueryBuilder qb) {
            + "        }\n"
            + "    \"ignore_unmapped\" : false,\n"
            + "            \"bottom_right\":\"30, -80\"\n"
        if (randomBoolean()) {
            + "        }\n"
            + "    },\n"
        assertEquals(json, -78.75, parsed.topLeft().getLon(), 0.0001);
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(shardContext));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "}";
        QueryShardException e = expectThrows(QueryShardException.class, () -> qb.toQuery(context));
            + "            \"top_left\":\"40, -70\",\n"
        queryBuilder.ignoreUnmapped(true);
                    queryBuilder.topLeft().lon(),
            + "    \"validation_method\" : \"STRICT\",\n"
            + "        \""
        GeoBoundingBoxQueryBuilder qb = new GeoBoundingBoxQueryBuilder("teststring");
    }
            GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
        assertGeoBoundingBoxQuery(query);
    public class RightTester extends PointTester {
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
        OpenSearchParseException e1 = expectThrows(OpenSearchParseException.class, () -> parseQuery(jsonGeohashAndWkt));
        checkGeneratedJson(expectedJson, parsed);
            + "        }\n"
        }
            + "    \"ignore_unmapped\" : false,\n"
            + "    \"pin.location\" : {\n"
        double bottom = builder.bottomRight().getLat();
    public void testHonorsCoercion() throws IOException {
            } else {
        assertThat(e1.getMessage(), containsString("Conflicting definition found using well-known text and explicit corners."));
package org.opensearch.index.query;
 * under the License.
            + "            }\n"
        double left = builder.topLeft().getLon();
            + "    \"pin.location\" : {\n"
            + "}";
            + "            \"bottom_left\":\"30, -70\"\n"
    /** Randomly generate either NaN or one of the two infinity values. */
        String query = "{\n"
        }
 * specific language governing permissions and limitations
        parseQuery(query).toQuery(shardContext);
    }
    }
            + "        \""
        assertFalse(
        QueryShardContext shardContext = createShardContext();
import org.opensearch.test.AbstractQueryTestCase;
            + "            \"top_left\":\"drn5x1g8cu2y\",\n"
            super(randomDoubleBetween(GeoUtils.MAX_LON, Double.MAX_VALUE, true));
            + "  \"geo_bounding_box\" : {\n"
            + "            \"top_left\":{\n"
            + "    },\n"
            // check the bottom-left/ top-right combination of setters
import org.opensearch.OpenSearchParseException;
            + "            \"bottom_right\":{\n"
            + "    \"geo_bounding_box\":{\n"
        assertGeoBoundingBoxQuery(query);
            + "    \"pin.location\" : {\n"
            + GEO_POINT_FIELD_NAME
import java.io.IOException;
            + "}\n";
        assertEquals(json, 1.0, parsed.boost(), 0.0001);
        logger.info("top: {} bottom: {}", top, bottom);
import org.opensearch.test.geo.RandomShapeGenerator;
        // parse with wkt
        super.testMustRewrite();
            + "    \"geo_bounding_box\":{\n"
            + "}";
        QueryShardContext shardContext = createShardContext();
                    + " coordinate: "
            + "            \"bottom\": 30\n"
                    queryBuilder.bottomRight().lat(),
            + "    }\n"
    }
            );
            + "        \""
            + "    }\n"
            + "    },\n"
        assertGeoBoundingBoxQuery(query);
            builder.setValidationMethod(randomFrom(GeoValidationMethod.values()));
        }
            + "}\n";
        if (fieldType == null) {
        }
            + "      \"wkt\" : \"BBOX (-74.1, -71.12, 40.73, 40.01)\"\n"
                case 1:
        assertThat(e.getMessage(), containsString("failed to find geo field [unmapped]"));
                case 0:
            + "    \"pin.location\" : {\n"
public class GeoBoundingBoxQueryBuilderTests extends AbstractQueryTestCase<GeoBoundingBoxQueryBuilder> {
        assertEquals(json, -74.1, parsed.topLeft().getLon(), 0.0001);
            super(randomDoubleBetween(-Double.MAX_VALUE, GeoUtils.MIN_LAT, false));
    }
        assertGeoBoundingBoxQuery(query);
        assertEquals("Type is not allowed to be null.", e.getMessage());
    protected void doAssertLuceneQuery(GeoBoundingBoxQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        PointTester[] testers = { new TopTester(), new LeftTester(), new BottomTester(), new RightTester() };
            + "    \"type\" : \"MEMORY\",\n"
                    + tester.getClass().getName()
    public void testValidationNullType() {
    }
        private double invalidCoordinate;
            + "    \"validation_method\" : \"STRICT\",\n"
import org.apache.lucene.search.Query;
        }
            + "    \"boost\" : 1.0\n"
            + "  \"geo_bounding_box\" : {\n"
            tester.invalidateCoordinate(builder.setValidationMethod(GeoValidationMethod.STRICT), false);
        // check the builder's generated geojson content against the expected json output
            );
    }
import org.opensearch.common.geo.GeoPoint;
            + "}\n";
        } else if (fieldType.unwrap() instanceof GeoPointFieldMapper.GeoPointFieldType) {
            + "  \"geo_bounding_box\" : {\n"
        PointTester[] testers = { new TopTester(), new LeftTester(), new BottomTester(), new RightTester() };
        assertEquals(json, 40.73, parsed.topLeft().getLat(), 0.0001);
                LatLonDocValuesField.newSlowBoxQuery(
        String query = "{\n"
            Query dvQuery = ((IndexOrDocValuesQuery) query).getRandomAccessQuery();
            GeoValidationMethod.DEFAULT_LENIENT_PARSING
        assertEquals("Field name must not be empty.", e.getMessage());
            except = builder.checkLatLon();
        public void invalidateCoordinate(GeoBoundingBoxQueryBuilder qb, boolean useBrokenDouble) {
            + GEO_POINT_FIELD_NAME
        String wkt = "{\n"
    public void testStrictnessDefault() {
            + "  }\n"
        String json = "{\n"
        assertEquals(expectedJson, -71.12, parsed.bottomRight().getLon(), delta);
 */
                    expectedFieldName,
 * compatible open source license.
            + GEO_POINT_FIELD_NAME
            + "    \"boost\" : 1.0\n"
        double bottom = builder.bottomRight().getLat();
                    + tester.invalidCoordinate,
        assertEquals(json, -67.5, parsed.bottomRight().getLon(), 0.0001);
    }
        assertEquals(expectedJson, "pin.location", parsed.fieldName());
            qb.setCorners(coordinate, qb.topLeft().getLon(), qb.bottomRight().getLat(), qb.bottomRight().getLon());
            + "  }\n"
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.document.LatLonPoint;
        String query = "{\n"
    }
                "validation w/ coerce should ignore invalid "
    public abstract class PointTester {
            + "\":{\n"
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
        String fieldName = randomFrom(GEO_POINT_FIELD_NAME, GEO_POINT_ALIAS_FIELD_NAME, GEO_SHAPE_FIELD_NAME);
            + "\":{\n"
        assertThat(e.getMessage(), containsString("top is below bottom corner:"));
        double right = builder.bottomRight().getLon();
        protected abstract void fillIn(double fillIn, GeoBoundingBoxQueryBuilder qb);
        }
        @Override
        for (PointTester tester : testers) {
    private static Double[] brokenDoubles = { Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };
            + "      \"top_left\" : [ -78.75, 45.0 ],\n"
            + "  \"geo_bounding_box\" : {\n"
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
                indexQuery
            + "        \""
            + "                \"lat\":30,\n"
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
        GeoBoundingBoxQueryBuilder builder = new GeoBoundingBoxQueryBuilder(fieldName);
    }
    private void assertGeoBoundingBoxQuery(String query) throws IOException {
        Rectangle box = RandomShapeGenerator.xRandomRectangle(random(), RandomShapeGenerator.xRandomPoint(random()));
        builder.type(randomFrom(GeoExecType.values()));
            + "    \"validation_method\" : \"STRICT\",\n"
            + "        }\n"
 * this work for additional information regarding copyright
            + "    }\n"
                ),
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
    protected GeoBoundingBoxQueryBuilder doCreateTestQueryBuilder() {
    }
            QueryValidationException except = null;
            + "    }\n"
        double left = builder.topLeft().getLon();
    }
    }
import org.opensearch.common.geo.GeoUtils;
    public void testBrokenCoordinateCanBeSetWithIgnoreMalformed() {
 * GitHub history for details.
            + GEO_POINT_FIELD_NAME
            + "}";
                    builder.setCorners(new GeoPoint(box.getMaxY(), box.getMinX()), new GeoPoint(box.getMinY(), box.getMaxX()));
    }
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
            + "        \"lon\": 181\n"
            + "      \"wkt\" : \"BBOX (-74.1, -71.12, 40.73, 40.01)\"\n"
        assertEquals(expectedJson, 40.01, parsed.bottomRight().getLat(), delta);
    }
            + "      }\n"
        builder.setValidationMethod(GeoValidationMethod.STRICT);
    public class TopTester extends PointTester {
    }
/*
    @Override
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoBoundingBoxQueryBuilder((String) null));
        String query = "{\n"
    public void testBrokenCoordinateCannotBeSet() {
        assertEquals("cannot parse type from null string", e.getMessage());
        @Override
        assertEquals(json, 1.0, parsed.boost(), 0.0001);
        assertGeoBoundingBoxQuery(query);
        double top = builder.topLeft().getLat();
        double top = builder.topLeft().getLat();
    public void testMustRewrite() throws IOException {
        qb.ignoreUnmapped(false);
import static org.hamcrest.CoreMatchers.instanceOf;
 * ownership. Elasticsearch licenses this file to you under
            qb.setCorners(qb.topLeft().getLat(), qb.topLeft().getLon(), qb.bottomRight().getLat(), coordinate);
    }
        assertEquals("failed to find geo field [" + qb.fieldName() + "]", e.getMessage());
    }
                    expectedFieldName,
        GeoBoundingBoxQueryBuilder parsed = (GeoBoundingBoxQueryBuilder) parseQuery(json);
            + "\":{\n"
        String jsonGeohashAndWkt = "{\n"
            if (useBrokenDouble) {
            + "  \"geo_bounding_box\" : {\n"
            assertTrue("Found no indexed geo query.", query instanceof MatchNoDocsQuery);
            + "        }\n"
    }
        builder.setValidationMethod(GeoValidationMethod.IGNORE_MALFORMED).setCorners(top, right, bottom, left);
    public void testFromWKT() throws IOException {
            } else {
        }
        double left = builder.topLeft().getLon();
    public void testParsingAndToQuery6() throws IOException {
            super(randomDoubleBetween(GeoUtils.MAX_LAT, Double.MAX_VALUE, false));
            tester.invalidateCoordinate(builder, true);
                except
            + "            \"top_left\":[-70, 40],\n"
        assertEquals(expectedJson, -74.1, parsed.topLeft().getLon(), delta);
 * You may obtain a copy of the License at
    }
    public void testExceptionOnMissingTypes() {
            tester.invalidateCoordinate(builder.setValidationMethod(GeoValidationMethod.COERCE), false);
 * license agreements. See the NOTICE file distributed with
                    queryBuilder.bottomRight().lon()
        } else {
            + "    \"geo_bounding_box\":{\n"
            + "    \"ignore_unmapped\" : false,\n"
                    break;
        final GeoBoundingBoxQueryBuilder queryBuilder = new GeoBoundingBoxQueryBuilder("unmapped").setCorners(1.0, 0.0, 0.0, 1.0);
            + "      \"top_left\" : \"dr\",\n"
        public BottomTester() {
    public void testValidation() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder.setCorners(bottom, left, top, right));
        for (PointTester tester : testers) {
                dvQuery
        public PointTester(double invalidCoodinate) {
        }
        PointTester[] testers = { new TopTester(), new LeftTester(), new BottomTester(), new RightTester() };
        double bottom = builder.bottomRight().getLat();
            + "        \""
            + "      \"bottom_right\" : [ -67.5, 33.75 ]\n"
        String query = "{\n"
        GeoBoundingBoxQueryBuilder parsed = (GeoBoundingBoxQueryBuilder) parseQuery(json);
            + "        }\n"
    }
            + "    \"ignore_unmapped\" : false,\n"
            + "}\n";
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.type((String) null));
        Query query = queryBuilder.toQuery(shardContext);
            // check the top-left/bottom-right combination of setters
    }
                    + tester.invalidCoordinate
 *
            + "  }\n"
        assertEquals(expectedJson, 40.73, parsed.topLeft().getLat(), delta);
            + "      \"bottom_right\": {\n"
import org.opensearch.index.mapper.GeoPointFieldMapper;
                fillIn(invalidCoordinate, qb);
            switch (path) {
                    + " coordinate: "
        public void fillIn(double coordinate, GeoBoundingBoxQueryBuilder qb) {
    public void testMalformedGeohashes() {
            + "  }\n"
            + "    \"ignore_unmapped\" : false,\n"
    public void testValidationNullTypeString() {
            assertNull(
            if (randomBoolean()) {
    }
        assertEquals(json, 40.01, parsed.bottomRight().getLat(), 0.0001);
            + "    \"type\" : \"MEMORY\",\n"
        );
            + "    \"boost\" : 1.0\n"
    public void testFromGeohash() throws IOException {
        double right = builder.bottomRight().getLon();
        } else {
        }
        String query = "{\n"
        @Override
                "validation w/o coerce should detect invalid coordinate: "
        assertEquals(json, "pin.location", parsed.fieldName());
            + GEO_POINT_FIELD_NAME
 */
            + "                \"lon\":-80\n"
            + "      \"top_left\" : [ -74.1, 40.73 ],\n"
        assertEquals(expectedJson, GeoExecType.MEMORY, parsed.type());
                        GeohashUtils.encodeLatLon(box.getMaxY(), box.getMinX()),
            + "    }\n"
            assertEquals(IndexOrDocValuesQuery.class, query.getClass());
    }
                    queryBuilder.topLeft().lat(),
        public TopTester() {
            + "    \"validation_method\" : \"STRICT\",\n"
        return builder;
            Query indexQuery = ((IndexOrDocValuesQuery) query).getIndexQuery();
            + "    \""
import org.apache.lucene.search.MatchNoDocsQuery;
    @Override
            + "        \"lon\": 176.5\n"
            + "}\n";
            + "            \"left\": -70,\n"
 * software distributed under the License is distributed on an
            + "    \"boost\" : 1.0\n"
    public void testValidationNullFieldname() {
        assertEquals(json, GeoExecType.MEMORY, parsed.type());
        double right = builder.bottomRight().getLon();
/*
                builder.setCornersOGC(new GeoPoint(box.getMinY(), box.getMinX()), new GeoPoint(box.getMaxY(), box.getMaxX()));
import org.apache.lucene.document.LatLonDocValuesField;
                        GeohashUtils.encodeLatLon(box.getMinY(), box.getMaxX())
        builder.setValidationMethod(GeoValidationMethod.IGNORE_MALFORMED);
        }
    public class BottomTester extends PointTester {
                fillIn(brokenCoordinate, qb);
import org.opensearch.index.mapper.GeoShapeFieldMapper;
            + "      \"bottom_right\" : \"dq\"\n"
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> qb.type((GeoExecType) null));
            + GEO_POINT_FIELD_NAME
        assumeTrue("top should not be equal to bottom for flip check", top != bottom);
        public RightTester() {
                    queryBuilder.topLeft().lat(),
        failingQueryBuilder.ignoreUnmapped(false);
            + "            },\n"
            + "    \"type\" : \"MEMORY\",\n"
        }
            + "        \""
                    builder.setCorners(box.getMaxY(), box.getMinX(), box.getMinY(), box.getMaxX());
        assertThat(query, notNullValue());
        String expectedJson = "{\n"
        assertEquals(json, -71.12, parsed.bottomRight().getLon(), 0.0001);
            + "    }\n"
    }
            + "    \"pin.location\" : {\n"
                except
        builder.setValidationMethod(GeoValidationMethod.IGNORE_MALFORMED).setCorners(bottom, left, top, right);
            + "    \"type\" : \"MEMORY\",\n"
            qb.setCorners(qb.topLeft().getLat(), qb.topLeft().getLon(), coordinate, qb.bottomRight().getLon());
        }
                    queryBuilder.bottomRight().lat(),
            + "    \"validation_method\": \"COERCE\",\n"
        }
        assertEquals(json, "pin.location", parsed.fieldName());
            }
            + "        \"lat\": -19.6,\n"
        if (randomBoolean()) {
            + "    },\n"
        QueryShardContext context = createShardContextWithNoType();
        GeoBoundingBoxQueryBuilder qb = new GeoBoundingBoxQueryBuilder("teststring");
 * Unless required by applicable law or agreed to in writing,
            + "\":{\n"
        assumeTrue("top should not be equal to bottom for flip check", top != bottom);
    public void testParsingAndToQuery4() throws IOException {
            + "  \"geo_bounding_box\" : {\n"
        // geojson generated content
            assertEquals(
 * Licensed to Elasticsearch under one or more contributor
 *
        if (randomBoolean()) {
            }
            + "\": {\n"
            + "            \"top\": 40,\n"
            + "    \"boost\" : 1.0\n"
import org.apache.lucene.search.IndexOrDocValuesQuery;
            + "}";
            + "}\n";
                ),
        assertEquals(json, GeoExecType.MEMORY, parsed.type());
            );
 * not use this file except in compliance with the License.
        }
        private double brokenCoordinate = randomFrom(brokenDoubles);
        assertGeoBoundingBoxQuery(query);
    @Override
            + "      },\n"
        String json = "{\n"
            + "    }\n"
                LatLonPoint.newBoxQuery(
        assertGeoBoundingBoxQuery(query);
            + "      \"top_left\" : [ -74.1, 40.73 ],\n"
            + "    },\n"
                    + " ",
                    queryBuilder.bottomRight().lon()
import static org.hamcrest.CoreMatchers.containsString;
            assertNotNull(
        GeoBoundingBoxQueryBuilder qb = createTestQueryBuilder();
    public void testTopBottomCanBeFlippedOnIgnoreMalformed() {
        checkGeneratedJson(json, parsed);
        assertEquals(json, 45.0, parsed.topLeft().getLat(), 0.0001);
                    break;
    public void testTopBottomCannotBeFlipped() {
            + "\":{\n"
                default:
                    builder.setCorners(
        }
            this.invalidCoordinate = invalidCoodinate;
        public void fillIn(double coordinate, GeoBoundingBoxQueryBuilder qb) {
 *
    }
            }
        // just check if we can parse the query
            + "  }\n"
    }
    public void testParsingAndToQuery2() throws IOException {
            + "  }\n"
            + "    \"ignore_unmapped\" : false,\n"
            );
        double delta = 0d;
            builder.ignoreUnmapped(randomBoolean());
                );
    }
        GeoBoundingBoxQueryBuilder parsed = (GeoBoundingBoxQueryBuilder) parseQuery(wkt);
        builder.setValidationMethod(GeoValidationMethod.STRICT);
        public void fillIn(double coordinate, GeoBoundingBoxQueryBuilder qb) {
        GeoBoundingBoxQueryBuilder builder = createTestQueryBuilder();
                    GeohashUtils.encodeLatLon(box.getMaxY(), box.getMaxX())
            + "    \"type\" : \"MEMORY\",\n"
            + "                \"lon\":-70\n"
            + "                \"lat\":40,\n"
            qb.setCorners(qb.topLeft().getLat(), coordinate, qb.bottomRight().getLat(), qb.bottomRight().getLon());
        }
        assertEquals(json, 33.75, parsed.bottomRight().getLat(), 0.0001);
            + "      \"bottom_right\" : [ -71.12, 40.01 ]\n"
    public void testIgnoreUnmapped() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            + "}\n";
            + "      \"top_left\": {\n"
            assertEquals(GeoShapeFieldMapper.GeoShapeFieldType.class, fieldType.getClass());
            + "      \"top_left\" : [ -78.75, 45.0 ],\n"
            + "    \"validation_method\" : \"STRICT\",\n"
        public LeftTester() {
