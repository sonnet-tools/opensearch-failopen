 */
        }
            OpenSearchParseException ex = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        assertNormalizedPoint(parseGeohash("drt5", GeoUtils.EffectivePoint.BOTTOM_RIGHT), new GeoPoint(42.71484375, -71.3671875));
        assertThat(GeoUtils.quadTreeCellHeight(5), equalTo(polarDistance / 32));
        double[] coordinates = { geoPoint.getLon(), geoPoint.getLat() };
        double lon = randomDouble() * 360 - 180 + randomIntBetween(-1000, 1000) * 360;
        double lon = 0.0;
    public void testGeohashCellSize() {
        assertThat(GeoUtils.geoHashCellSize(2), equalTo(Math.sqrt(Math.pow(polarDistance / 32, 2) + Math.pow(equatorialDistance / 32, 2))));
            assertThat(GeoUtils.quadTreeCellHeight(level), lessThanOrEqualTo(height));
            int shift = randomIntBetween(1, 10000);
            GeoUtils.geoHashCellSize(7),
        for (int i = 0; i < 100; i++) {
 * specific language governing permissions and limitations
            .array("coordinates", coordinatesInString)
/*
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        double lat = randomDouble() * 180 - 90 + randomIntBetween(-1000, 1000) * 180;
            double testLon = normalisedLon + (360.0 * shift);
            assertThat(parser.nextToken(), is(Token.END_OBJECT));
            GeoUtils.quadTreeCellSize(9),
            }
        assertThat(GeoUtils.geoHashCellWidth(5), equalTo(equatorialDistance / 8192));
            try (XContentParser parser = createParser(json)) {
    public void testGeohashCellHeight() {
        assertThat(GeoUtils.geoHashCellHeight(12), equalTo(polarDistance / 1073741824));
        GeohashPrefixTree geohashPrefixTree = new GeohashPrefixTree(spatialContext, GeohashPrefixTree.getMaxLevelsPossible() / 2);
    }
        try (XContentParser parser = createParser(json1)) {
        double polarDistance = Math.PI * 6356752.314245;
        try (XContentParser parser = createParser(json)) {
            int level = GeoUtils.quadTreeLevelsForPrecision(precision);
        double lat = randomDouble() * 180 - 90 + randomIntBetween(-1000, 1000) * 180;
    }
            int shift = (randomBoolean() ? 1 : -1) * randomIntBetween(1, 10000);
        }
    public void testNormalizeLonEdgeCases() {
 * license agreements. See the NOTICE file distributed with
    public void testParseGeoPointStringZValueError() throws IOException {
        assertThat(GeoUtils.geoHashCellWidth(0), equalTo(equatorialDistance));
    public void testParseGeoPointLatNoLon() throws IOException {
        assertThat(GeoUtils.geoHashCellWidth(1), equalTo(equatorialDistance / 8));
        XContentBuilder missingType = jsonBuilder().startObject().array("coordinates", coordinates).endObject();
    public void testNormalizePointOutsideNormalRange_withOptions() {
            equalTo(Math.sqrt(Math.pow(polarDistance / 128, 2) + Math.pow(equatorialDistance / 256, 2)))
        assertThat(GeoUtils.normalizeLat(-0.0), equalTo(0.0));
                assertThat(point.lat(), allOf(lessThanOrEqualTo(90.0), greaterThanOrEqualTo(-90.0)));
            double expectedLon = normalisedLon + (shiftLat % 2 == 0 ? 0 : 180);
            int level = GeoUtils.geoHashLevelsForPrecision(precisionString);
    public void testParseGeoPointArray3D() throws IOException {
            }
        double polarDistance = Math.PI * 6356752.314245;
        try (XContentParser parser = createParser(content)) {
            String precisionString = precision + "m";
 *
    }
            double degrees = 360.0 / (1L << i);
            }
        assertThat(
        assertNormalizedPoint(new GeoPoint(100.0, 180.0), new GeoPoint(80.0, 0.0));
    public void testParserGeoPointGeoJsonMissingField() throws IOException {
                equalTo(180.d * height / GeoUtils.EARTH_POLAR_DISTANCE)
        try (XContentParser parser = createParser(json)) {
        assertNormalizedPoint(parseGeohash("drt5", GeoUtils.EffectivePoint.TOP_LEFT), new GeoPoint(42.890625, -71.71875));
            .endObject();
            .field("type", "Point")
        'k',
            equalTo(Math.sqrt(Math.pow(polarDistance / 4096, 2) + Math.pow(equatorialDistance / 8192, 2)))
        'u',
import org.opensearch.test.geo.RandomGeoGenerator;
        assertThat(GeoUtils.normalizeLon(180.0), equalTo(180.0));
            double height = GeoUtils.geoHashCellHeight(i);
        }
        assertNormalizedPoint(new GeoPoint(-18000000000090.0, -36000000000180.0), new GeoPoint(-090.0, +180.0));
        assertThat(GeoUtils.normalizeLon(+36000000000180.0), equalTo(GeoUtils.normalizeLon(+180.0)));
            double expectedLat = normalisedLat * (shiftLat % 2 == 0 ? 1 : -1);
    public void testParseGeoPointExtraField() throws IOException {
        double lon = 0.0;
        expectParseException(invalidGeoJsonType, "type must be Point");
            GeoUtils.geoHashCellSize(12),
            int shiftLon = (randomBoolean() ? 1 : -1) * randomIntBetween(1, 10000);
        assertThat(GeoUtils.geoHashCellHeight(0), equalTo(polarDistance));
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
        assertNormalizedPoint(new GeoPoint(90.0, 180.0), new GeoPoint(90.0, 180.0));
        assertThat(GeoUtils.quadTreeCellSize(0), equalTo(Math.sqrt(Math.pow(polarDistance, 2) + Math.pow(equatorialDistance, 2))));
        assertThat(GeoUtils.normalizeLon(Double.NEGATIVE_INFINITY), equalTo(Double.NaN));
            boolean normalize = randomBoolean();
        assertThat(
import org.opensearch.core.xcontent.XContentBuilder;
            GeoPoint testPoint = new GeoPoint(testLat, testLon);
        assertThat(GeoUtils.geoHashCellWidth(9), equalTo(equatorialDistance / 8388608));
import static org.hamcrest.Matchers.allOf;
        try (XContentParser parser = createParser(json)) {
                parser.nextToken();
            .array("coordinates", coordinates)
                parser.nextToken();
        );
            json = jsonBuilder().startObject().field("lat", String.valueOf(lat)).field("lon", String.valueOf(lon)).endObject();
            equalTo(Math.sqrt(Math.pow(polarDistance / 64, 2) + Math.pow(equatorialDistance / 64, 2)))
        }
            equalTo(Math.sqrt(Math.pow(polarDistance / 131072, 2) + Math.pow(equatorialDistance / 262144, 2)))
        assertThat(GeoUtils.normalizeLat(90.0), equalTo(90.0));
            assertThat("Unexpected Longitude", input.lon(), equalTo(expected.lon()));
    }
        assertThat(GeoUtils.quadTreeCellHeight(6), equalTo(polarDistance / 64));
        try (XContentParser parser = createParser(json)) {
        assertThat(GeoUtils.quadTreeCellHeight(12), equalTo(polarDistance / 4096));
                }
    private static void assertNormalizedPoint(GeoPoint input, GeoPoint expected) {
        assertThat(GeoUtils.normalizeLat(-18000000000088.0), equalTo(GeoUtils.normalizeLat(-088.0)));
    public void testParseGeoPointArrayZValueError() throws IOException {
            double lon = randomDouble() * 360 - 180 + randomIntBetween(-1000, 1000) * 360;
        }
        double lon = 0.0;
        }
            int geoHashLength = randomIntBetween(1, Geohash.PRECISION);
        assertThat(GeoUtils.quadTreeCellWidth(3), equalTo(equatorialDistance / 8));
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
    public void testParseGeoPointLonWrongType() throws IOException {
    }
            int level = GeoUtils.geoHashLevelsForPrecision(precision);
        }
            assertThat(GeoUtils.quadTreeLevelsForPrecision(size), equalTo(quadPrefixTree.getLevelForDistance(degrees)));
import java.io.IOException;
    }
        assertThat(GeoUtils.normalizeLon(-0.0), equalTo(0.0));
        assertThat(0.0, not(equalTo(-0.0)));
        assertThat(GeoUtils.geoHashCellHeight(1), equalTo(polarDistance / 4));
        for (int i = 0; i < 100; i++) {
        assertThat(
        assertThat(GeoUtils.quadTreeCellWidth(10), equalTo(equatorialDistance / 1024));
            assertThat(
        assertThat(GeoUtils.quadTreeCellHeight(3), equalTo(polarDistance / 8));
        assertThat(GeoUtils.geoHashCellWidth(11), equalTo(equatorialDistance / 268435456));
        assertThat(GeoUtils.normalizeLat(+18000000000002.0), equalTo(GeoUtils.normalizeLat(+002.0)));
        assertThat(GeoUtils.normalizeLon(-360.0), equalTo(0.0));
        try (XContentParser parser = createParser(json)) {
            assertThat(e.getMessage(), containsString("geohash must be a string"));
        assertThat(
        GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random());
        );
        assertThat(GeoUtils.quadTreeCellHeight(2), equalTo(polarDistance / 4));
            int shiftLat = (randomBoolean() ? 1 : -1) * randomIntBetween(1, 10000);
    public void testNormalizeLonInNormalRange() {
    }
 * compatible open source license.
        assertThat(GeoUtils.quadTreeCellWidth(0), lessThanOrEqualTo(GeoUtils.EARTH_EQUATOR));
            GeoPoint expectedPoint = new GeoPoint(expectedLat, expectedLon);
    }
    }
    public void testParseGeoPoint() throws IOException {
            assertNull(parser.nextToken());
        assertThat(GeoUtils.quadTreeCellWidth(5), equalTo(equatorialDistance / 32));
        XContentBuilder json = jsonBuilder().startObject().field("lat", false).field("lon", lon).endObject();
 * software distributed under the License is distributed on an
            }
        assertThat(GeoUtils.quadTreeCellWidth(6), equalTo(equatorialDistance / 64));
    }
            parser.nextToken();
            return GeoUtils.parseGeoPoint(parser, new GeoPoint(), randomBoolean(), effectivePoint);
            GeoUtils.geoHashCellSize(8),
            double normalisedLon = (randomDouble() * 360.0) - 180.0;
                "height at level " + i,
                while (parser.currentToken() != Token.VALUE_STRING) {
    }
        }
            GeoPoint testPoint = new GeoPoint(testLat, testLon);
        for (int i = 0; i < 100; i++) {
        'c',
            equalTo(Math.sqrt(Math.pow(polarDistance / 33554432, 2) + Math.pow(equatorialDistance / 33554432, 2)))
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(GeoUtils.normalizeLon(+36000000000179.0), equalTo(GeoUtils.normalizeLon(+179.0)));
                expectedLon = testLon;
            try (XContentParser parser = createParser(json)) {
        assertThat(GeoUtils.normalizeLon(360.0), equalTo(0.0));
            GeoUtils.geoHashCellSize(6),
            try (XContentParser parser = createParser(json)) {
                equalTo(180.d * height / GeoUtils.EARTH_POLAR_DISTANCE)
            GeoUtils.geoHashCellSize(4),
        assertThat(GeoUtils.normalizeLon(Double.POSITIVE_INFINITY), equalTo(Double.NaN));
                assertNull(parser.nextToken());
        '2',
        assertThat(GeoUtils.quadTreeCellSize(1), equalTo(Math.sqrt(Math.pow(polarDistance / 2, 2) + Math.pow(equatorialDistance / 2, 2))));
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser, new GeoPoint(), false));
    }
        expectParseException(missingType, "field [type] missing");
        XContentBuilder json = jsonBuilder().startObject().startArray("foo").value(lon).value(lat).value(elev).endArray().endObject();
            assertThat(GeoUtils.normalizeLon(testValue), closeTo(normalisedValue, MAX_ACCEPTABLE_ERROR));
            double width = GeoUtils.geoHashCellWidth(i);
    }
        '4',
 * the Apache License, Version 2.0 (the "License"); you may
        '6',
        assertThat(GeoUtils.quadTreeCellWidth(12), equalTo(equatorialDistance / 4096));
 * under the License.
    public void testParserGeoPointGeoJsonUnknownField() throws IOException {
        assertThat(GeoUtils.geoHashCellWidth(10), equalTo(equatorialDistance / 33554432));
import org.apache.lucene.spatial.prefix.tree.QuadPrefixTree;
import org.opensearch.test.OpenSearchTestCase;
        '3',
        if (Double.isNaN(expected.lon())) {
        assertThat(GeoUtils.normalizeLon(-36000000000180.0), equalTo(GeoUtils.normalizeLon(-180.0)));
            GeoUtils.quadTreeCellSize(5),
        't',
        assertThat(
        assertThat(GeoUtils.normalizeLon(-36000000000181.0), equalTo(GeoUtils.normalizeLon(-181.0)));
            XContentBuilder json = jsonBuilder().startObject().field("lat", lat).field("lon", lon).endObject();
        assertNormalizedPoint(new GeoPoint(+18000000000001.0, +36000000000001.0), new GeoPoint(+001.0, +001.0));
    }
            String precisionString = precision + "m";
            equalTo(Math.sqrt(Math.pow(polarDistance / 1024, 2) + Math.pow(equatorialDistance / 1024, 2)))
    public void testQuadTreeLevelsForPrecision() {
        );
            .field("type", "Point")
    public void testNormalizePointHuge() {
            equalTo(Math.sqrt(Math.pow(polarDistance / 16, 2) + Math.pow(equatorialDistance / 16, 2)))
        assertThat(GeoUtils.geoHashCellHeight(6), equalTo(polarDistance / 32768));
        double equatorialDistance = 2 * Math.PI * 6378137.0;
        assertNormalizedPoint(parseGeohash("drtk", GeoUtils.EffectivePoint.BOTTOM_LEFT), new GeoPoint(42.890625, -71.3671875));
                assertThat(point.lat(), allOf(lessThanOrEqualTo(90.0), greaterThanOrEqualTo(-90.0)));
        if (Double.isNaN(expected.lat())) {
        boolean lon = false;
            GeoPoint point = GeoUtils.parseGeoPoint(parser, new GeoPoint(), true);
        assertThat(
        for (int i = 0; i < 100; i++) {
            assertNormalizedPoint(testPoint, testPoint);
        double alt = randomDouble() * 1000;
            assertNull(parser.nextToken());
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
            equalTo(Math.sqrt(Math.pow(polarDistance / 256, 2) + Math.pow(equatorialDistance / 256, 2)))
                parser.nextToken();
        QuadPrefixTree quadPrefixTree = new QuadPrefixTree(spatialContext);
        expectParseException(invalideCoordinatesType, "numeric value expected");
        assertThat(GeoUtils.normalizeLat(+18000000000091.0), equalTo(GeoUtils.normalizeLat(+091.0)));
import static org.hamcrest.Matchers.closeTo;
    public void testQuadTreeCellWidth() {
        try (XContentParser parser = createParser(json)) {
        assertThat(GeoUtils.geoHashCellWidth(12), equalTo(equatorialDistance / 1073741824));
            assertThat(GeoUtils.normalizeLat(testValue), closeTo(testValue, MAX_ACCEPTABLE_ERROR));
        double lat = 0.0;
        expectParseException(unknownField, "field must be either [lon|lat], [type|coordinates], or [geohash]");
        for (int i = 0; i < 100; i++) {
            assertEquals(geoPoint, paredPoint);
        for (int i = 0; i < 100; i++) {
        assertThat(GeoUtils.geoHashCellHeight(8), equalTo(polarDistance / 1048576));
    }
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        }
    public void testParseGeoPointGeohash() throws IOException {
        assertThat(GeoUtils.geoHashCellWidth(8), equalTo(equatorialDistance / 1048576));
            assertThat(point.lon(), equalTo(lon));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            double size = GeoUtils.geoHashCellSize(i);
        assertNormalizedPoint(new GeoPoint(-100.0, -180.0), new GeoPoint(-80.0, 0.0));
import org.opensearch.common.geo.GeoUtils;
            GeoPoint paredPoint = GeoUtils.parseGeoPoint(parser);
    public void testNormalizePointOutsideNormalRange() {
        assertThat(GeoUtils.normalizeLat(Double.NEGATIVE_INFINITY), equalTo(Double.NaN));
        XContentBuilder json = jsonBuilder().startObject().startArray("foo").value(lon).value(lat).endArray().endObject();
        assertNormalizedPoint(new GeoPoint(100.0, -180.0), new GeoPoint(80.0, 0.0));
            assertThat(GeoUtils.quadTreeCellHeight(level), lessThanOrEqualTo(height));
    }
        assertNormalizedPoint(new GeoPoint(-18000000000001.0, -36000000000001.0), new GeoPoint(-001.0, -001.0));
        try (XContentParser parser = createParser(json)) {
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
        for (int i = 0; i < 100; i++) {
        try (XContentParser parser = createParser(json)) {
            GeoUtils.quadTreeCellSize(10),
            assertThat("Unexpected Longitude", input.lon(), closeTo(expected.lon(), MAX_ACCEPTABLE_ERROR));
        try (XContentParser parser = createParser(jsonBuilder().startObject().field("geohash", geohash).endObject())) {
            assertThat(e.getMessage(), containsString(ERR_MSG_INVALID_FIELDS));
                assertThat(point, equalTo(new GeoPoint(lat, lon)));
        );
        );
        assertThat(0.0, not(equalTo(-0.0)));
        );
                parser.nextToken();
    public void testGeoHashLevelsForPrecision() {
        assertNormalizedPoint(new GeoPoint(-18000000000088.0, -36000000000178.0), new GeoPoint(-088.0, -178.0));
        assertThat(GeoUtils.quadTreeCellSize(3), equalTo(Math.sqrt(Math.pow(polarDistance / 8, 2) + Math.pow(equatorialDistance / 8, 2))));
        try (XContentParser parser = createParser(json)) {
                qNode.getShape().getBoundingBox().getHeight(),
            json = jsonBuilder().startObject().startArray("foo").value(lon).value(lat).endArray().endObject();
            GeoUtils.quadTreeCellSize(8),
                    parser.nextToken();
        assertThat(GeoUtils.quadTreeCellHeight(10), equalTo(polarDistance / 1024));
        SpatialContext spatialContext = new SpatialContext(true);
            assertThat("Unexpected Latitude", input.lat(), equalTo(expected.lat()));
            double testLat = normalisedLat + (180.0 * shift);
        double lat = 0.0;
    private GeoPoint parseGeohash(String geohash, GeoUtils.EffectivePoint effectivePoint) throws IOException {
            equalTo(Math.sqrt(Math.pow(polarDistance / 2048, 2) + Math.pow(equatorialDistance / 2048, 2)))
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
        XContentBuilder json = jsonBuilder().startArray().value(lat).value(lon).value(alt).endArray();
        for (int i = 0; i < 100; i++) {
 * this file be licensed under the Apache-2.0 license or a
        }
    public void testNormalizeLatHuge() {
    }
        );
    public void testNormalizeLatOutsideNormalRange() {
        expectParseException(missingCoordinates, "field [coordinates] missing");
                assertThat(parser.currentToken(), is(Token.END_OBJECT));
        }
 * The OpenSearch Contributors require contributions made to
import org.locationtech.spatial4j.distance.DistanceUtils;
        assertNormalizedPoint(new GeoPoint(+18000000000089.0, +36000000000179.0), new GeoPoint(+089.0, +179.0));
                if (expectedLon > 180.0) {
        assertNormalizedPoint(new GeoPoint(-18000000000089.0, -36000000000179.0), new GeoPoint(-089.0, -179.0));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    private void expectParseException(XContentBuilder content, String errMsg) throws IOException {
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        );
        assertThat(GeoUtils.normalizeLat(-90.0), equalTo(-90.0));
    }
import org.opensearch.core.xcontent.XContentParser;
    public void testNormalizeLonOutsideNormalRange() {
import static org.hamcrest.Matchers.containsString;
    }
        'r',
            try (XContentParser parser = createParser(json)) {
            int level = GeoUtils.quadTreeLevelsForPrecision(size);
            GeoUtils.quadTreeCellSize(6),
            while (parser.currentToken() != Token.START_ARRAY) {
    public void testQuadTreeCellHeight() {
            if (normalize) {
        );
            assertThat(e.getMessage(), is("numeric value expected"));
    }
            assertThat("Unexpected Longitude", testPoint.lon(), closeTo(expectedPoint.lon(), MAX_ACCEPTABLE_ERROR));
        assertThat(GeoUtils.quadTreeCellWidth(8), equalTo(equatorialDistance / 256));
 *
 * Licensed to Elasticsearch under one or more contributor
    public void testParseGeoPointLonNoLat() throws IOException {
                assertThat(point, equalTo(new GeoPoint(lat, lon)));
            double normalisedLon = (randomDouble() * 360.0) - 180.0;
        assertThat(
        }
        'e',
        assertThat(
        }
            }
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
        }
        XContentBuilder json = jsonBuilder().startObject().startArray("foo").value(lon).value(lat).value(elev).endArray().endObject();
            assertThat(GeoUtils.quadTreeCellWidth(level), lessThanOrEqualTo(width));
        }
                expectedLat = normalisedLat * (shift % 2 == 0 ? 1 : -1);
        for (int i = 0; i < 100; i++) {
            assertThat(e.getMessage(), is("lon must be a number"));
            parser.nextToken();
            .endObject();
            double width = GeoUtils.quadTreeCellWidth(i);
        assertThat(GeoUtils.normalizeLat(-180.0), equalTo(0.0));
            int level = GeoUtils.quadTreeLevelsForPrecision(size);
        Cell gNode = geohashPrefixTree.getWorldCell();
        assertThat(
            equalTo(Math.sqrt(Math.pow(polarDistance / 4096, 2) + Math.pow(equatorialDistance / 4096, 2)))
            equalTo(Math.sqrt(Math.pow(polarDistance / 32768, 2) + Math.pow(equatorialDistance / 32768, 2)))
            parser.nextToken();
        double equatorialDistance = 2 * Math.PI * 6378137.0;
        'b',
        assertNormalizedPoint(new GeoPoint(+18000000000090.0, +36000000000180.0), new GeoPoint(+090.0, +180.0));
                parser.nextToken();
            assertNull(parser.nextToken());
                expectedLon = normalisedLon + ((shift % 2 == 1) ? 180 : 0);
package org.opensearch.index.search.geo;
        '8',
        assertThat(GeoUtils.normalizeLat(Double.POSITIVE_INFINITY), equalTo(Double.NaN));
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        assertThat(GeoUtils.geoHashCellWidth(3), equalTo(equatorialDistance / 256));
            assertEquals(geoPoint, paredPoint);
    }
        for (int i = 0; i < quadPrefixTree.getMaxLevels(); i++) {
            .field("type", "invalid")
            parser.nextToken();
            parser.nextToken();
            assertThat(
        double equatorialDistance = 2 * Math.PI * 6378137.0;
        assertNormalizedPoint(new GeoPoint(+18000000000091.0, +36000000000181.0), new GeoPoint(+089.0, +001.0));
        XContentBuilder json = jsonBuilder().startObject().field("foo", 5).endObject();
        assertThat(GeoUtils.normalizeLon(+36000000000178.0), equalTo(GeoUtils.normalizeLon(+178.0)));
        }
        );
            double testValue = (randomDouble() * 180.0) - 90.0;
        XContentBuilder unknownField = jsonBuilder().startObject()
            GeoPoint expectedPoint = new GeoPoint(expectedLat, expectedLon);
        assertThat(GeoUtils.geoHashCellHeight(5), equalTo(polarDistance / 4096));
        assertNormalizedPoint(new GeoPoint(-0.0, -0.0), new GeoPoint(0.0, 0.0));
        }
        assertThat(GeoUtils.quadTreeCellWidth(7), equalTo(equatorialDistance / 128));
                assertThat(point.lon(), allOf(lessThanOrEqualTo(180.0), greaterThanOrEqualTo(-180.0)));
        'j',
        XContentBuilder json = jsonBuilder().startObject().field("lat", lat).endObject();
        assertThat(GeoUtils.normalizeLat(Double.NaN), equalTo(Double.NaN));
            equalTo(Math.sqrt(Math.pow(polarDistance / 128, 2) + Math.pow(equatorialDistance / 128, 2)))
            parser.nextToken();
import static org.hamcrest.Matchers.not;
        XContentBuilder invalideCoordinatesType = jsonBuilder().startObject()
                while (parser.currentToken() != Token.START_ARRAY) {
            parser.nextToken();
    }
        assertNormalizedPoint(new GeoPoint(-100.0, 180.0), new GeoPoint(-80.0, 0.0));
        double equatorialDistance = 2 * Math.PI * 6378137.0;
        for (int i = 0; i < geohashPrefixTree.getMaxLevels(); i++) {
            }
            try (XContentParser parser = createParser(json)) {
                "height at level " + i,
        }
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
        } else {
        assertNormalizedPoint(new GeoPoint(+18000000000000.0, +18000000000000.0), new GeoPoint(+000.0, +000.0));
        }
            }
            StringBuilder geohashBuilder = new StringBuilder(geoHashLength);
    }
            equalTo(Math.sqrt(Math.pow(polarDistance / 4194304, 2) + Math.pow(equatorialDistance / 8388608, 2)))
            assertThat("Unexpected Latitude", testPoint.lat(), closeTo(expectedPoint.lat(), MAX_ACCEPTABLE_ERROR));
    }
    public void testParserGeoPointGeoJson() throws IOException {
        double lon = 0.0;
        assertNormalizedPoint(new GeoPoint(Double.NaN, Double.NaN), new GeoPoint(Double.NaN, Double.NaN));
        double[] coordinates = { geoPoint.getLon(), geoPoint.getLat() };
            parser.nextToken();
        assertThat(GeoUtils.normalizeLon(+36000000000000.0), equalTo(GeoUtils.normalizeLon(+000.0)));
            double lat = randomDouble() * 180 - 90 + randomIntBetween(-1000, 1000) * 180;
            );
        assertThat(GeoUtils.geoHashCellHeight(2), equalTo(polarDistance / 32));
        assertThat(
import org.locationtech.spatial4j.context.SpatialContext;
    public void testNormalizeLatEdgeCases() {
        '1',
        XContentBuilder json = jsonBuilder().startObject().field("lat", lat).field("lon", lon).field("geohash", geohash).endObject();
        GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random());
        assertThat(GeoUtils.geoHashCellHeight(9), equalTo(polarDistance / 4194304));
        assertThat(GeoUtils.normalizeLon(0.0), equalTo(0.0));
            assertEquals(errMsg, ex.getMessage());
        '0',
        double lon = 0.0;
            double height = GeoUtils.quadTreeCellHeight(i);
        assertThat(GeoUtils.quadTreeCellWidth(9), equalTo(equatorialDistance / 512));
            GeoUtils.normalizePoint(testPoint, normalize, normalize);
            double testLat = (randomDouble() * 180.0) - 90.0;
                }
        assertThat(
        assertThat(GeoUtils.quadTreeCellWidth(0), equalTo(equatorialDistance));
                parser.nextToken();
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
                assertThat(point, equalTo(new GeoPoint(lat, lon)));
        for (int i = 0; i < 100; i++) {
    }
    public void testParserGeoPointGeoJsonInvalidValue() throws IOException {
            GeoPoint testPoint = new GeoPoint(testLat, testLon);
        assertThat(GeoUtils.quadTreeCellHeight(1), equalTo(polarDistance / 2));
            }
        }
            double testValue = normalisedValue + (180.0 * shift);
        double polarDistance = Math.PI * 6356752.314245;
        'h',
        assertThat(GeoUtils.quadTreeCellHeight(0), equalTo(polarDistance));
        double alt = randomDouble() * 1000;
        double[] coordinates = { geoPoint.getLon(), geoPoint.getLat() };
        assertThat(GeoUtils.normalizeLon(-36000000000178.0), equalTo(GeoUtils.normalizeLon(-178.0)));
        assertThat(GeoUtils.normalizeLat(+18000000000090.0), equalTo(GeoUtils.normalizeLat(+090.0)));
 * this work for additional information regarding copyright
            assertThat(e.getMessage(), is("lat must be a number"));
        assertThat(GeoUtils.normalizeLat(+18000000000000.0), equalTo(GeoUtils.normalizeLat(+000.0)));
import org.opensearch.common.geo.GeoPoint;
    }
                gNode.getShape().getBoundingBox().getWidth(),
        assertThat(GeoUtils.normalizeLat(0.0), equalTo(0.0));
        }
        XContentBuilder json = jsonBuilder().startObject().field("geohash", 1.0).endObject();
        } else {
    }
        Cell qNode = quadPrefixTree.getWorldCell();
            double normalisedValue = (randomDouble() * 180.0) - 90.0;
            parser.nextToken();
        try (XContentParser parser = createParser(json)) {
            }
        assertThat(GeoUtils.quadTreeCellHeight(11), equalTo(polarDistance / 2048));
            assertThat(GeoUtils.normalizeLon(testValue), closeTo(testValue, MAX_ACCEPTABLE_ERROR));
    public void testNormalizeLatInNormalRange() {
        assertThat(GeoUtils.normalizeLat(+18000000000088.0), equalTo(GeoUtils.normalizeLat(+088.0)));
            gNode = gNode.getNextLevelCells(null).next();
            assertThat(GeoUtils.geoHashLevelsForPrecision(size), equalTo(geohashPrefixTree.getLevelForDistance(degrees)));
            }
        assertThat(GeoUtils.quadTreeCellWidth(11), equalTo(equatorialDistance / 2048));
    public void testParseGeoPointLonLatGeoHash() throws IOException {
            double precision = randomDouble() * 100;
        GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random());
            assertThat(
            }
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        assertNormalizedPoint(new GeoPoint(180.0, 360.0), new GeoPoint(0.0, 180.0));
        }
        double lon = -180.0;
        assertThat(
        assertThat(GeoUtils.geoHashCellHeight(10), equalTo(polarDistance / 33554432));
        GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random());
        assertNormalizedPoint(new GeoPoint(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY), new GeoPoint(Double.NaN, Double.NaN));
    public void testPrefixTreeCellSizes() {
            assertThat(e.getMessage(), containsString("but [ignore_z_value] parameter is [false]"));
            assertNull(parser.nextToken());
                "width at level " + i,
        assertNormalizedPoint(new GeoPoint(0.0, 0.0), new GeoPoint(0.0, 0.0));
        assertThat(
        double lat = 0.0;
            while (parser.currentToken() != Token.START_ARRAY) {
            if (expectedLon > 180.0) {
            assertThat(e.getMessage(), is("geo_point expected"));
            assertThat(parser.currentToken(), is(Token.END_ARRAY));
        );
        double lon = randomDouble() * 360 - 180 + randomIntBetween(-1000, 1000) * 360;
        'g',
        for (int i = 0; i < 100; i++) {
                "width at level " + i,
        assertThat(
        'f',
    public void testParseGeoPointLatWrongType() throws IOException {
import org.opensearch.core.xcontent.XContentParser.Token;
        double lat = 0.0;
        assertThat(
            assertNull(parser.nextToken());
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
        assertThat(GeoUtils.quadTreeCellHeight(4), equalTo(polarDistance / 16));
        assertThat(GeoUtils.normalizeLon(-36000000000001.0), equalTo(GeoUtils.normalizeLon(-001.0)));
        'z' };
                    expectedLon -= 360;
        }
        'm',
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
        assertThat(GeoUtils.quadTreeCellWidth(2), equalTo(equatorialDistance / 4));
            GeoUtils.geoHashCellSize(11),
        double[] coordinates = { geoPoint.getLon(), geoPoint.getLat() };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testParseGeoPointGeohashPositions() throws IOException {
        try (XContentParser parser = createParser(json)) {
        }
    public void testParseGeoPointArrayWrongType() throws IOException {
        String[] coordinatesInString = { String.valueOf(geoPoint.getLon()), String.valueOf(geoPoint.getLat()) };
import org.opensearch.OpenSearchParseException;
        assertThat(GeoUtils.geoHashCellSize(0), equalTo(Math.sqrt(Math.pow(polarDistance, 2) + Math.pow(equatorialDistance, 2))));
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;
        'd',
        double elev = 0.0;
        assertNormalizedPoint(new GeoPoint(+18000000000088.0, +36000000000178.0), new GeoPoint(+088.0, +178.0));
            equalTo(Math.sqrt(Math.pow(polarDistance / 32, 2) + Math.pow(equatorialDistance / 32, 2)))
            double size = GeoUtils.quadTreeCellSize(i);
            while (parser.currentToken() != Token.VALUE_STRING) {
        assertThat(GeoUtils.normalizeLon(+36000000000002.0), equalTo(GeoUtils.normalizeLon(+002.0)));
            assertThat(GeoUtils.geoHashCellSize(level), lessThanOrEqualTo(precision));
        try (XContentParser parser = createParser(json2)) {
                parser.nextToken();
            assertThat(GeoUtils.quadTreeCellSize(level), lessThanOrEqualTo(precision));
        assertThat(GeoUtils.EARTH_SEMI_MAJOR_AXIS, equalTo(DistanceUtils.EARTH_EQUATORIAL_RADIUS_KM * 1000));
        );
 *
            assertThat(e.getMessage(), is("field [lat] missing"));
            json = jsonBuilder().startObject().field("geohash", geohashBuilder.toString()).endObject();
            double testLon = (randomDouble() * 360.0) - 180.0;
            assertThat("Unexpected Latitude", input.lat(), closeTo(expected.lat(), MAX_ACCEPTABLE_ERROR));
        'x',
            double testLon = normalisedLon + (360.0 * shiftLon);
            assertNormalizedPoint(testPoint, expectedPoint);
        double lat = 0.0;
    }
            GeoPoint paredPoint = GeoUtils.parseGeoPoint(parser);
    }
            double testValue = normalisedValue + ((randomBoolean() ? 1 : -1) * 360.0 * randomIntBetween(1, 10000));
        assertNormalizedPoint(parseGeohash("drt5", GeoUtils.EffectivePoint.TOP_RIGHT), new GeoPoint(42.890625, -71.3671875));
                assertThat(point.lon(), allOf(lessThanOrEqualTo(180.0), greaterThanOrEqualTo(-180.0)));
            double precision = randomDouble() * 100;
        assertThat(GeoUtils.geoHashCellHeight(11), equalTo(polarDistance / 134217728));
            double expectedLon;
            assertThat(e.getMessage(), is("Exception parsing coordinates: found Z value [0.0] but [ignore_z_value] parameter is [false]"));
    public void testQuadTreeCellSize() {
        assertThat(GeoUtils.quadTreeCellHeight(7), equalTo(polarDistance / 128));
            GeoUtils.geoHashCellSize(9),
 * not use this file except in compliance with the License.
            equalTo(Math.sqrt(Math.pow(polarDistance / 1048576, 2) + Math.pow(equatorialDistance / 1048576, 2)))
    public void testParseGeoPointArrayTooManyValues() throws IOException {
                assertThat(point, equalTo(new GeoPoint(lat, lon)));
        assertNormalizedPoint(parseGeohash("drt5", GeoUtils.EffectivePoint.BOTTOM_LEFT), new GeoPoint(42.71484375, -71.71875));
 * ownership. Elasticsearch licenses this file to you under
            assertThat(GeoUtils.quadTreeCellWidth(level), lessThanOrEqualTo(width));
 */
        );
 */
            equalTo(Math.sqrt(Math.pow(polarDistance / 1024, 2) + Math.pow(equatorialDistance / 1024, 2)))
            GeoUtils.geoHashCellSize(3),
        assertThat(GeoUtils.quadTreeCellSize(2), equalTo(Math.sqrt(Math.pow(polarDistance / 4, 2) + Math.pow(equatorialDistance / 4, 2))));
    public void testGeoHashLevelsForPrecision_String() {
        GeoUtils.normalizePoint(input);
        assertThat(GeoUtils.normalizeLat(-18000000000090.0), equalTo(GeoUtils.normalizeLat(-090.0)));
import org.apache.lucene.spatial.prefix.tree.Cell;
    }
            .field("unknown", "value")
        assertThat(GeoUtils.normalizeLat(+18000000000089.0), equalTo(GeoUtils.normalizeLat(+089.0)));
    private static final double MAX_ACCEPTABLE_ERROR = 0.000000001;
/*
        assertNormalizedPoint(new GeoPoint(-180.0, -360.0), new GeoPoint(0.0, 180.0));
        assertThat(
            assertNull(parser.nextToken());
            parser.nextToken();
            GeoUtils.quadTreeCellSize(7),
        double elev = 0.0;
        assertThat(GeoUtils.geoHashCellHeight(4), equalTo(polarDistance / 1024));
        for (int i = 0; i < 100; i++) {
        assertThat(GeoUtils.normalizeLon(-180.0), equalTo(180.0));
            double degrees = 360.0 * width / GeoUtils.EARTH_EQUATOR;
        double polarDistance = Math.PI * 6356752.314245;
    }
            assertNull(parser.nextToken());
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        for (int i = 0; i < 100; i++) {
            );
            );
        assertThat(GeoUtils.geoHashCellWidth(7), equalTo(equatorialDistance / 262144));
        '5',
import static org.hamcrest.Matchers.is;
    }
            assertThat(GeoUtils.geoHashCellSize(level), lessThanOrEqualTo(precision));
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
    }
            }
            equalTo(Math.sqrt(Math.pow(polarDistance / 1073741824, 2) + Math.pow(equatorialDistance / 1073741824, 2)))
        assertThat(GeoUtils.normalizeLon(Double.NaN), equalTo(Double.NaN));
                }
            double testValue = (randomDouble() * 360.0) - 180.0;
    private static final char[] BASE_32 = {
            while (parser.currentToken() != Token.VALUE_NUMBER) {
        assertThat(0.0, not(equalTo(-0.0)));
        assertThat(GeoUtils.normalizeLat(-18000000000001.0), equalTo(GeoUtils.normalizeLat(-001.0)));
        assertThat(GeoUtils.geoHashCellWidth(6), equalTo(equatorialDistance / 32768));
        }
        assertNormalizedPoint(new GeoPoint(+18000000000002.0, +36000000000002.0), new GeoPoint(+002.0, +002.0));
    }
            XContentBuilder json = jsonBuilder().startObject().field("geohash", geohashBuilder.toString()).endObject();
            double testLat = normalisedLat + (180.0 * shiftLat);
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        XContentBuilder missingCoordinates = jsonBuilder().startObject().field("type", "Point").endObject();
        try (XContentParser parser = createParser(json)) {
    }
            .array("coordinates", coordinates)
        );
            }
    }
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
            GeoUtils.quadTreeCellSize(11),
                assertNull(parser.nextToken());
    public void testNormalizePointEdgeCases() {
        assertThat(GeoUtils.geoHashCellHeight(3), equalTo(polarDistance / 128));
        String geohash = "abcd";
        assertThat(GeoUtils.quadTreeCellWidth(4), equalTo(equatorialDistance / 16));
        assertThat(GeoUtils.geoHashCellSize(1), equalTo(Math.sqrt(Math.pow(polarDistance / 4, 2) + Math.pow(equatorialDistance / 8, 2))));
        double lat = 90.0;
        );
                }
                    parser.nextToken();
    }
        assertThat(
    public void testParseGeoPointInvalidType() throws IOException {
        }
        assertThat(GeoUtils.geoHashCellHeight(7), equalTo(polarDistance / 131072));
    }
    private static final String ERR_MSG_INVALID_FIELDS = "field must be either [lon|lat], [type|coordinates], or [geohash]";
        XContentBuilder json2 = jsonBuilder().startObject().field("type", "PoInT").array("coordinates", coordinates).endObject();
        try (XContentParser parser = createParser(json)) {
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
import org.opensearch.geometry.utils.Geohash;
    public void testGeohashCellWidth() {
        'q',
        XContentBuilder json = jsonBuilder().startObject().field("lon", lon).endObject();
    }
 * SPDX-License-Identifier: Apache-2.0
                parser.nextToken();
        'w',
            parser.nextToken();
            assertThat(e.getMessage(), is("field [lon] missing"));
                gNode.getShape().getBoundingBox().getHeight(),
        'v',
    }
            GeoUtils.quadTreeCellSize(12),
        'n',
            double precision = randomDouble() * 100;
        XContentBuilder json = jsonBuilder().startObject().field("lat", lat).field("lon", false).endObject();
            int level = GeoUtils.quadTreeLevelsForPrecision(precisionString);
            }
                qNode.getShape().getBoundingBox().getWidth(),
                geohashBuilder.append(BASE_32[randomInt(BASE_32.length - 1)]);
    public void testParseGeoPointGeohashWrongType() throws IOException {
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        }
    }
            double normalisedValue = (randomDouble() * 360.0) - 180.0;
 * Modifications Copyright OpenSearch Contributors. See
    }
                assertThat(parser.currentToken(), is(Token.END_OBJECT));
            assertThat(parser.currentToken(), is(Token.END_ARRAY));
        assertThat(GeoUtils.normalizeLat(+18000000000001.0), equalTo(GeoUtils.normalizeLat(+001.0)));
        assertThat(GeoUtils.normalizeLon(+36000000000001.0), equalTo(GeoUtils.normalizeLon(+001.0)));
        }
            assertThat(GeoUtils.quadTreeCellSize(level), lessThanOrEqualTo(precision));
        XContentBuilder json = jsonBuilder().startObject().field("foo", lat + "," + lon + "," + alt).endObject();
            parser.nextToken();
            double expectedLat;
        'p',
            } else {
            double normalisedLat = (randomDouble() * 180.0) - 90.0;
        assertThat(GeoUtils.normalizeLat(-18000000000089.0), equalTo(GeoUtils.normalizeLat(-089.0)));
                expectedLon -= 360;
        assertThat(GeoUtils.quadTreeCellHeight(9), equalTo(polarDistance / 512));
        assertThat(GeoUtils.normalizeLat(180.0), equalTo(0.0));
        }
        assertThat(GeoUtils.quadTreeCellWidth(1), equalTo(equatorialDistance / 2));
        }
            json = jsonBuilder().startObject().field("foo", lat + "," + lon).endObject();
            );
            assertThat(GeoUtils.normalizeLat(testValue), closeTo(expectedValue, MAX_ACCEPTABLE_ERROR));
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
    }
            equalTo(Math.sqrt(Math.pow(polarDistance / 134217728, 2) + Math.pow(equatorialDistance / 268435456, 2)))
 * Unless required by applicable law or agreed to in writing,
                expectedLat = testLat;
        assertThat(
 * GitHub history for details.
        double lat = 0.0;
                while (parser.currentToken() != Token.VALUE_STRING) {
            assertThat(point.lat(), equalTo(lat));
    }
                equalTo(360.d * width / GeoUtils.EARTH_EQUATOR)
        XContentBuilder json = jsonBuilder().startObject().field("lat", lat).field("lon", lon).field("foo", true).endObject();
/*
    public void testNormalizePointInNormalRange() {
        assertThat(GeoUtils.geoHashCellWidth(2), equalTo(equatorialDistance / 32));
        assertNormalizedPoint(new GeoPoint(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY), new GeoPoint(Double.NaN, Double.NaN));
    public void testNormalizeLonHuge() {
}
        }
        );
    }
            equalTo(Math.sqrt(Math.pow(polarDistance / 512, 2) + Math.pow(equatorialDistance / 512, 2)))
        assertThat(GeoUtils.normalizeLat(-18000000000091.0), equalTo(GeoUtils.normalizeLat(-091.0)));
        assertThat(
        );
            double precision = randomDouble() * 100;
            double expectedValue = normalisedValue * (shift % 2 == 0 ? 1 : -1);
            .endObject();
public class GeoUtilsTests extends OpenSearchTestCase {
            assertThat(e.getMessage(), containsString("but [ignore_z_value] parameter is [false]"));
            qNode = qNode.getNextLevelCells(null).next();
        '7',
            GeoUtils.quadTreeCellSize(4),
        assertThat(GeoUtils.quadTreeCellHeight(8), equalTo(polarDistance / 256));
        assertNormalizedPoint(new GeoPoint(-90.0, -180.0), new GeoPoint(-90.0, -180.0));
        assertThat(GeoUtils.normalizeLon(+36000000000181.0), equalTo(GeoUtils.normalizeLon(+181.0)));
        assertNormalizedPoint(new GeoPoint(-18000000000091.0, -36000000000181.0), new GeoPoint(-089.0, -001.0));
        'y',
        assertThat(GeoUtils.geoHashCellWidth(4), equalTo(equatorialDistance / 1024));
            assertThat(
 * KIND, either express or implied.  See the License for the
    }
        assertThat(GeoUtils.normalizeLon(-36000000000179.0), equalTo(GeoUtils.normalizeLon(-179.0)));
        }
    public void testQuadTreeLevelsForPrecisionString() {
            while (parser.currentToken() != Token.START_ARRAY) {
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser, new GeoPoint(), false));
        XContentBuilder invalidGeoJsonType = jsonBuilder().startObject()
import static org.hamcrest.Matchers.equalTo;
        );
            double normalisedLat = (randomDouble() * 180.0) - 90.0;
            GeoUtils.geoHashCellSize(5),
        );
        }
 * You may obtain a copy of the License at
                    parser.nextToken();
        's',
        '9',
    }
            try (XContentParser parser = createParser(json)) {
                equalTo(360.d * width / GeoUtils.EARTH_EQUATOR)
            GeoUtils.geoHashCellSize(10),
        }
            for (int j = 0; j < geoHashLength; j++) {
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        XContentBuilder json1 = jsonBuilder().startObject().field("type", "Point").array("coordinates", coordinates).endObject();
