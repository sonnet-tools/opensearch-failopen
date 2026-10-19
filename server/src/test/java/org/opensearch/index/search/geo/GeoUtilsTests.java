        assertNormalizedPoint(new GeoPoint(-0.0, -0.0), new GeoPoint(0.0, 0.0));
            GeoUtils.quadTreeCellSize(10),  
        assertThat(GeoUtils.normalizeLon(+36000000000002.0), equalTo(GeoUtils.normalizeLon(+002.0)));
                while (parser.currentToken() != Token.VALUE_STRING) {  
        'd',
        assertThat(GeoUtils.geoHashCellHeight(1), equalTo(polarDistance / 4));
        assertThat(GeoUtils.normalizeLon(-36000000000001.0), equalTo(GeoUtils.normalizeLon(-001.0)));
            int level = GeoUtils.geoHashLevelsForPrecision(precisionString);
        assertNormalizedPoint(new GeoPoint(-18000000000089.0, -36000000000179.0), new GeoPoint(-089.0, -179.0));
            parser.nextToken();
        double polarDistance = Math.PI * 6356752.314245;  
        assertThat(GeoUtils.geoHashCellHeight(5), equalTo(polarDistance / 4096));  
    public void testNormalizePointInNormalRange() {
    }  
            parser.nextToken();
            while (parser.currentToken() != Token.START_ARRAY) {
            assertNull(parser.nextToken());
        }  
            while (parser.currentToken() != Token.VALUE_NUMBER) {
        double alt = randomDouble() * 1000;
        assertThat(GeoUtils.quadTreeCellWidth(7), equalTo(equatorialDistance / 128));  
        double polarDistance = Math.PI * 6356752.314245;  
        assertThat(GeoUtils.quadTreeCellHeight(2), equalTo(polarDistance / 4));  
        assertThat(GeoUtils.geoHashCellWidth(12), equalTo(equatorialDistance / 1073741824));
            boolean normalize = randomBoolean();
                assertThat(point.lat(), allOf(lessThanOrEqualTo(90.0), greaterThanOrEqualTo(-90.0)));
            assertThat(  
        XContentBuilder json = jsonBuilder().startObject().startArray("foo").value(lon).value(lat).value(elev).endArray().endObject();
        }
 * software distributed under the License is distributed on an
        }
        XContentBuilder invalidGeoJsonType = jsonBuilder().startObject()
                parser.nextToken();
            json = jsonBuilder().startObject().startArray("foo").value(lon).value(lat).endArray().endObject();
            double testValue = normalisedValue + (180.0 * shift);
        assertNormalizedPoint(new GeoPoint(-18000000000088.0, -36000000000178.0), new GeoPoint(-088.0, -178.0));
        try (XContentParser parser = createParser(json)) {
        String geohash = "abcd";
            GeoUtils.geoHashCellSize(10),  
        assertThat(GeoUtils.quadTreeCellHeight(10), equalTo(polarDistance / 1024));
            assertThat(e.getMessage(), is("geo_point expected"));  
        );
            assertThat(e.getMessage(), containsString("but [ignore_z_value] parameter is [false]"));  
        );
                expectedLat = testLat;
                assertNull(parser.nextToken());
        assertThat(
        'v',
                }  
    public void testNormalizePointEdgeCases() {
            double lat = randomDouble() * 180 - 90 + randomIntBetween(-1000, 1000) * 180;  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
            GeoUtils.quadTreeCellSize(12),
 * Modifications Copyright OpenSearch Contributors. See
        );
            assertNull(parser.nextToken());
        assertNormalizedPoint(new GeoPoint(-18000000000090.0, -36000000000180.0), new GeoPoint(-090.0, +180.0));  
            }
        assertThat(GeoUtils.quadTreeCellHeight(5), equalTo(polarDistance / 32));  
        assertThat(  
        try (XContentParser parser = createParser(json)) {
 * ownership. Elasticsearch licenses this file to you under  
        expectParseException(invalideCoordinatesType, "numeric value expected");  
            equalTo(Math.sqrt(Math.pow(polarDistance / 2048, 2) + Math.pow(equatorialDistance / 2048, 2)))
            parser.nextToken();
        assertThat(GeoUtils.quadTreeCellWidth(0), lessThanOrEqualTo(GeoUtils.EARTH_EQUATOR));
            int shift = (randomBoolean() ? 1 : -1) * randomIntBetween(1, 10000);
            parser.nextToken();
            parser.nextToken();
            assertNormalizedPoint(testPoint, expectedPoint);
        assertThat(  
        assertThat(
            }  
        try (XContentParser parser = createParser(json)) {  
    public void testParserGeoPointGeoJsonInvalidValue() throws IOException {
            assertThat(GeoUtils.quadTreeCellSize(level), lessThanOrEqualTo(precision));
        assertThat(GeoUtils.quadTreeCellHeight(0), equalTo(polarDistance));
    public void testParserGeoPointGeoJsonMissingField() throws IOException {
                parser.nextToken();
            double expectedValue = normalisedValue * (shift % 2 == 0 ? 1 : -1);  
            assertThat("Unexpected Longitude", input.lon(), closeTo(expected.lon(), MAX_ACCEPTABLE_ERROR));  
            }
        assertThat(GeoUtils.quadTreeCellWidth(11), equalTo(equatorialDistance / 2048));
        } else {  
    }
        assertThat(GeoUtils.normalizeLat(+18000000000089.0), equalTo(GeoUtils.normalizeLat(+089.0)));  
        assertThat(GeoUtils.quadTreeCellHeight(12), equalTo(polarDistance / 4096));
        assertThat(GeoUtils.geoHashCellWidth(11), equalTo(equatorialDistance / 268435456));
        );  
            equalTo(Math.sqrt(Math.pow(polarDistance / 256, 2) + Math.pow(equatorialDistance / 256, 2)))
            return GeoUtils.parseGeoPoint(parser, new GeoPoint(), randomBoolean(), effectivePoint);
            XContentBuilder json = jsonBuilder().startObject().field("geohash", geohashBuilder.toString()).endObject();
        }  
    public void testQuadTreeLevelsForPrecision() {
        XContentBuilder invalideCoordinatesType = jsonBuilder().startObject()
                    expectedLon -= 360;
        double lat = 0.0;  
        for (int i = 0; i < 100; i++) {
        }
            equalTo(Math.sqrt(Math.pow(polarDistance / 1024, 2) + Math.pow(equatorialDistance / 1024, 2)))
            .array("coordinates", coordinates)
        assertNormalizedPoint(parseGeohash("drt5", GeoUtils.EffectivePoint.TOP_LEFT), new GeoPoint(42.890625, -71.71875));  
        assertThat(GeoUtils.quadTreeCellWidth(6), equalTo(equatorialDistance / 64));
            GeoPoint testPoint = new GeoPoint(testLat, testLon);
        XContentBuilder unknownField = jsonBuilder().startObject()
            double normalisedLat = (randomDouble() * 180.0) - 90.0;  
    private static final char[] BASE_32 = {
        double lon = randomDouble() * 360 - 180 + randomIntBetween(-1000, 1000) * 360;
        assertThat(GeoUtils.normalizeLat(-18000000000091.0), equalTo(GeoUtils.normalizeLat(-091.0)));  
        assertThat(GeoUtils.geoHashCellWidth(1), equalTo(equatorialDistance / 8));  
        boolean lon = false;  
        assertThat(GeoUtils.normalizeLat(+18000000000088.0), equalTo(GeoUtils.normalizeLat(+088.0)));
            GeoPoint point = GeoUtils.parseGeoPoint(parser, new GeoPoint(), true);
        expectParseException(missingCoordinates, "field [coordinates] missing");
            GeoUtils.geoHashCellSize(11),
        assertThat(GeoUtils.geoHashCellHeight(12), equalTo(polarDistance / 1073741824));
    }
import org.opensearch.OpenSearchParseException;
        assertNormalizedPoint(parseGeohash("drt5", GeoUtils.EffectivePoint.BOTTOM_RIGHT), new GeoPoint(42.71484375, -71.3671875));  
        'g',
            int level = GeoUtils.quadTreeLevelsForPrecision(size);
                "height at level " + i,
        double lon = 0.0;
            );
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(GeoUtils.geoHashCellWidth(6), equalTo(equatorialDistance / 32768));
 * GitHub history for details.
    public void testParserGeoPointGeoJsonUnknownField() throws IOException {
            String precisionString = precision + "m";  
            parser.nextToken();
import org.opensearch.test.OpenSearchTestCase;
        '6',
        try (XContentParser parser = createParser(jsonBuilder().startObject().field("geohash", geohash).endObject())) {
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
        assertThat(GeoUtils.normalizeLat(Double.POSITIVE_INFINITY), equalTo(Double.NaN));  
        assertThat(  
        assertThat(GeoUtils.normalizeLat(-18000000000001.0), equalTo(GeoUtils.normalizeLat(-001.0)));
            assertEquals(errMsg, ex.getMessage());
        assertThat(GeoUtils.geoHashCellWidth(7), equalTo(equatorialDistance / 262144));  
import org.opensearch.common.geo.GeoUtils;  
import org.opensearch.test.geo.RandomGeoGenerator;  
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        Cell qNode = quadPrefixTree.getWorldCell();
            int shiftLon = (randomBoolean() ? 1 : -1) * randomIntBetween(1, 10000);  
        expectParseException(missingType, "field [type] missing");
            double testValue = (randomDouble() * 180.0) - 90.0;
                assertNull(parser.nextToken());
        for (int i = 0; i < 100; i++) {
        assertThat(GeoUtils.geoHashCellWidth(10), equalTo(equatorialDistance / 33554432));  
        assertThat(GeoUtils.normalizeLon(+36000000000000.0), equalTo(GeoUtils.normalizeLon(+000.0)));  
    private GeoPoint parseGeohash(String geohash, GeoUtils.EffectivePoint effectivePoint) throws IOException {
        double polarDistance = Math.PI * 6356752.314245;  
    public void testNormalizeLonHuge() {  
        XContentBuilder json = jsonBuilder().startObject().field("lat", lat).field("lon", lon).field("foo", true).endObject();  
    public void testParseGeoPointLatNoLon() throws IOException {  
            int level = GeoUtils.quadTreeLevelsForPrecision(precision);
        'n',
import static org.hamcrest.Matchers.not;  
        assertNormalizedPoint(new GeoPoint(-180.0, -360.0), new GeoPoint(0.0, 180.0));  
        assertThat(GeoUtils.quadTreeCellWidth(2), equalTo(equatorialDistance / 4));
    public void testParseGeoPointArrayTooManyValues() throws IOException {
        assertThat(
import org.opensearch.core.xcontent.XContentParser.Token;  
            assertThat(e.getMessage(), containsString("but [ignore_z_value] parameter is [false]"));  
        'z' };  
        XContentBuilder json = jsonBuilder().startObject().field("geohash", 1.0).endObject();
            GeoUtils.quadTreeCellSize(11),
            double width = GeoUtils.quadTreeCellWidth(i);
            equalTo(Math.sqrt(Math.pow(polarDistance / 134217728, 2) + Math.pow(equatorialDistance / 268435456, 2)))
        assertThat(GeoUtils.geoHashCellHeight(9), equalTo(polarDistance / 4194304));
            equalTo(Math.sqrt(Math.pow(polarDistance / 128, 2) + Math.pow(equatorialDistance / 256, 2)))  
            GeoUtils.geoHashCellSize(7),  
        for (int i = 0; i < 100; i++) {
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
            equalTo(Math.sqrt(Math.pow(polarDistance / 128, 2) + Math.pow(equatorialDistance / 128, 2)))
                "width at level " + i,
 */  
            GeoUtils.geoHashCellSize(6),
        );  
                GeoPoint point = GeoUtils.parseGeoPoint(parser);  
        double lon = 0.0;
import org.opensearch.geometry.utils.Geohash;
import org.apache.lucene.spatial.prefix.tree.Cell;
        'r',
        assertThat(GeoUtils.quadTreeCellHeight(3), equalTo(polarDistance / 8));
        assertThat(0.0, not(equalTo(-0.0)));
            }
import static org.hamcrest.Matchers.equalTo;
            equalTo(Math.sqrt(Math.pow(polarDistance / 512, 2) + Math.pow(equatorialDistance / 512, 2)))  
            assertNull(parser.nextToken());
            while (parser.currentToken() != Token.START_ARRAY) {
        XContentBuilder json = jsonBuilder().startArray().value(lat).value(lon).value(alt).endArray();
        assertNormalizedPoint(parseGeohash("drtk", GeoUtils.EffectivePoint.BOTTOM_LEFT), new GeoPoint(42.890625, -71.3671875));
        try (XContentParser parser = createParser(json2)) {  
        XContentBuilder json = jsonBuilder().startObject().field("lat", lat).field("lon", false).endObject();
        assertThat(GeoUtils.quadTreeCellWidth(5), equalTo(equatorialDistance / 32));
        assertThat(GeoUtils.normalizeLon(-36000000000181.0), equalTo(GeoUtils.normalizeLon(-181.0)));
    private static final String ERR_MSG_INVALID_FIELDS = "field must be either [lon|lat], [type|coordinates], or [geohash]";  
        XContentBuilder json = jsonBuilder().startObject().field("lon", lon).endObject();
        }
        assertNormalizedPoint(new GeoPoint(-100.0, 180.0), new GeoPoint(-80.0, 0.0));  
        assertNormalizedPoint(new GeoPoint(-18000000000001.0, -36000000000001.0), new GeoPoint(-001.0, -001.0));  
}  
        double elev = 0.0;
        assertThat(GeoUtils.geoHashCellWidth(4), equalTo(equatorialDistance / 1024));  
                }
        assertThat(GeoUtils.geoHashCellWidth(0), equalTo(equatorialDistance));
        }
        double equatorialDistance = 2 * Math.PI * 6378137.0;
                    parser.nextToken();  
        assertThat(GeoUtils.quadTreeCellWidth(3), equalTo(equatorialDistance / 8));
        assertNormalizedPoint(new GeoPoint(-90.0, -180.0), new GeoPoint(-90.0, -180.0));
        assertThat(GeoUtils.normalizeLat(180.0), equalTo(0.0));
    public void testNormalizePointOutsideNormalRange_withOptions() {
    public void testQuadTreeCellSize() {
 */
        's',
        expectParseException(unknownField, "field must be either [lon|lat], [type|coordinates], or [geohash]");
        'u',
            qNode = qNode.getNextLevelCells(null).next();
            double size = GeoUtils.geoHashCellSize(i);
            .endObject();
        );
        assertThat(GeoUtils.quadTreeCellWidth(12), equalTo(equatorialDistance / 4096));
 */  
        for (int i = 0; i < 100; i++) {
        );
    }  
                while (parser.currentToken() != Token.START_ARRAY) {  
            GeoUtils.quadTreeCellSize(8),
        assertThat(0.0, not(equalTo(-0.0)));  
                expectedLon = normalisedLon + ((shift % 2 == 1) ? 180 : 0);  
    }
            }
        assertThat(GeoUtils.normalizeLat(0.0), equalTo(0.0));
import org.opensearch.common.geo.GeoPoint;
            int shiftLat = (randomBoolean() ? 1 : -1) * randomIntBetween(1, 10000);
        assertNormalizedPoint(new GeoPoint(+18000000000089.0, +36000000000179.0), new GeoPoint(+089.0, +179.0));
            assertThat("Unexpected Latitude", input.lat(), equalTo(expected.lat()));
        assertThat(GeoUtils.geoHashCellSize(0), equalTo(Math.sqrt(Math.pow(polarDistance, 2) + Math.pow(equatorialDistance, 2))));
        XContentBuilder json = jsonBuilder().startObject().field("lat", false).field("lon", lon).endObject();
        assertThat(
        '3',
            try (XContentParser parser = createParser(json)) {
            try (XContentParser parser = createParser(json)) {
        'p',
            equalTo(Math.sqrt(Math.pow(polarDistance / 131072, 2) + Math.pow(equatorialDistance / 262144, 2)))
        assertThat(GeoUtils.normalizeLon(+36000000000178.0), equalTo(GeoUtils.normalizeLon(+178.0)));  
 *
        try (XContentParser parser = createParser(json)) {
        );
            assertThat(GeoUtils.quadTreeCellWidth(level), lessThanOrEqualTo(width));
            double precision = randomDouble() * 100;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                equalTo(180.d * height / GeoUtils.EARTH_POLAR_DISTANCE)  
            GeoUtils.geoHashCellSize(12),
        }  
        for (int i = 0; i < 100; i++) {
            double normalisedValue = (randomDouble() * 360.0) - 180.0;  
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        assertThat(GeoUtils.geoHashCellHeight(4), equalTo(polarDistance / 1024));
    }
        assertThat(GeoUtils.quadTreeCellSize(0), equalTo(Math.sqrt(Math.pow(polarDistance, 2) + Math.pow(equatorialDistance, 2))));
        double lon = -180.0;  
            equalTo(Math.sqrt(Math.pow(polarDistance / 32768, 2) + Math.pow(equatorialDistance / 32768, 2)))  
        assertThat(GeoUtils.quadTreeCellWidth(0), equalTo(equatorialDistance));
        assertThat(GeoUtils.normalizeLat(+18000000000002.0), equalTo(GeoUtils.normalizeLat(+002.0)));
        double equatorialDistance = 2 * Math.PI * 6378137.0;
            GeoPoint testPoint = new GeoPoint(testLat, testLon);
            GeoUtils.quadTreeCellSize(5),
        assertThat(GeoUtils.normalizeLat(-18000000000088.0), equalTo(GeoUtils.normalizeLat(-088.0)));  
            }
 * specific language governing permissions and limitations
                parser.nextToken();  
        }  
            double expectedLon;  
        '5',
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
import java.io.IOException;
        double lat = 0.0;
    }
            if (normalize) {
public class GeoUtilsTests extends OpenSearchTestCase {
                equalTo(360.d * width / GeoUtils.EARTH_EQUATOR)
    }  
        try (XContentParser parser = createParser(content)) {
    public void testQuadTreeLevelsForPrecisionString() {  
            StringBuilder geohashBuilder = new StringBuilder(geoHashLength);  
    public void testParseGeoPointExtraField() throws IOException {  
        );  
        assertThat(GeoUtils.quadTreeCellHeight(9), equalTo(polarDistance / 512));
        assertThat(GeoUtils.quadTreeCellHeight(8), equalTo(polarDistance / 256));  
            GeoUtils.geoHashCellSize(3),
            GeoPoint expectedPoint = new GeoPoint(expectedLat, expectedLon);  
        'b',  
            double normalisedLon = (randomDouble() * 360.0) - 180.0;  
            }  
        double lat = 0.0;  
        String[] coordinatesInString = { String.valueOf(geoPoint.getLon()), String.valueOf(geoPoint.getLat()) };
            OpenSearchParseException ex = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));  
        assertThat(GeoUtils.normalizeLat(+18000000000000.0), equalTo(GeoUtils.normalizeLat(+000.0)));
        double[] coordinates = { geoPoint.getLon(), geoPoint.getLat() };
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
            assertThat(GeoUtils.geoHashLevelsForPrecision(size), equalTo(geohashPrefixTree.getLevelForDistance(degrees)));
        XContentBuilder json = jsonBuilder().startObject().field("foo", lat + "," + lon + "," + alt).endObject();  
            double testLon = normalisedLon + (360.0 * shift);  
    }
    public void testGeohashCellSize() {
        assertThat(GeoUtils.quadTreeCellSize(1), equalTo(Math.sqrt(Math.pow(polarDistance / 2, 2) + Math.pow(equatorialDistance / 2, 2))));
            GeoPoint testPoint = new GeoPoint(testLat, testLon);
    public void testNormalizeLatEdgeCases() {
        }
    }
                parser.nextToken();
 *
        assertThat(GeoUtils.normalizeLat(-0.0), equalTo(0.0));
        assertThat(GeoUtils.normalizeLat(90.0), equalTo(90.0));  
        for (int i = 0; i < geohashPrefixTree.getMaxLevels(); i++) {
        double lat = 0.0;
        assertThat(GeoUtils.normalizeLat(-18000000000090.0), equalTo(GeoUtils.normalizeLat(-090.0)));
            equalTo(Math.sqrt(Math.pow(polarDistance / 32, 2) + Math.pow(equatorialDistance / 32, 2)))
        }
                }
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
            } else {
        assertThat(
            assertThat(parser.currentToken(), is(Token.END_ARRAY));
            }  
            int level = GeoUtils.geoHashLevelsForPrecision(precision);
    public void testGeoHashLevelsForPrecision() {
                assertThat(point.lon(), allOf(lessThanOrEqualTo(180.0), greaterThanOrEqualTo(-180.0)));
    public void testParseGeoPointGeohash() throws IOException {  
                assertThat(parser.currentToken(), is(Token.END_OBJECT));
        for (int i = 0; i < quadPrefixTree.getMaxLevels(); i++) {
            double height = GeoUtils.geoHashCellHeight(i);
        'x',
        }
import static org.hamcrest.Matchers.is;
        }
        double equatorialDistance = 2 * Math.PI * 6378137.0;
            double degrees = 360.0 / (1L << i);
        assertThat(GeoUtils.normalizeLon(Double.NaN), equalTo(Double.NaN));  
        double lon = 0.0;
        assertNormalizedPoint(new GeoPoint(90.0, 180.0), new GeoPoint(90.0, 180.0));  
        assertThat(GeoUtils.geoHashCellWidth(2), equalTo(equatorialDistance / 32));
                parser.nextToken();  
        assertThat(GeoUtils.quadTreeCellWidth(9), equalTo(equatorialDistance / 512));
        assertThat(GeoUtils.normalizeLon(-36000000000178.0), equalTo(GeoUtils.normalizeLon(-178.0)));
    }
        for (int i = 0; i < 100; i++) {
        double lat = 90.0;
            for (int j = 0; j < geoHashLength; j++) {
        try (XContentParser parser = createParser(json)) {  
            .endObject();
    public void testParseGeoPoint() throws IOException {
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
                "height at level " + i,
        XContentBuilder json = jsonBuilder().startObject().startArray("foo").value(lon).value(lat).value(elev).endArray().endObject();  
            assertThat(GeoUtils.normalizeLon(testValue), closeTo(normalisedValue, MAX_ACCEPTABLE_ERROR));
        assertThat(GeoUtils.geoHashCellHeight(8), equalTo(polarDistance / 1048576));  
            assertThat(point.lon(), equalTo(lon));  
            assertThat(GeoUtils.normalizeLon(testValue), closeTo(testValue, MAX_ACCEPTABLE_ERROR));  
    public void testNormalizeLonOutsideNormalRange() {
            );
import static org.hamcrest.Matchers.closeTo;  
        assertNormalizedPoint(new GeoPoint(+18000000000000.0, +18000000000000.0), new GeoPoint(+000.0, +000.0));
                    parser.nextToken();
        double equatorialDistance = 2 * Math.PI * 6378137.0;
            GeoPoint paredPoint = GeoUtils.parseGeoPoint(parser);
            .array("coordinates", coordinatesInString)
        assertThat(GeoUtils.geoHashCellSize(2), equalTo(Math.sqrt(Math.pow(polarDistance / 32, 2) + Math.pow(equatorialDistance / 32, 2))));  
        assertThat(GeoUtils.quadTreeCellSize(3), equalTo(Math.sqrt(Math.pow(polarDistance / 8, 2) + Math.pow(equatorialDistance / 8, 2))));
            }
        assertThat(GeoUtils.geoHashCellHeight(7), equalTo(polarDistance / 131072));
            double expectedLon = normalisedLon + (shiftLat % 2 == 0 ? 0 : 180);
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));  
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
    }  
        }  
        assertThat(GeoUtils.normalizeLon(-36000000000179.0), equalTo(GeoUtils.normalizeLon(-179.0)));  
    public void testParseGeoPointArrayWrongType() throws IOException {
        assertThat(
            double testLon = (randomDouble() * 360.0) - 180.0;
    }
            assertNull(parser.nextToken());
            .field("type", "Point")  
        assertThat(GeoUtils.normalizeLon(180.0), equalTo(180.0));
        assertNormalizedPoint(new GeoPoint(-100.0, -180.0), new GeoPoint(-80.0, 0.0));
        double lon = 0.0;
            double normalisedValue = (randomDouble() * 180.0) - 90.0;  
        }  
        assertThat(
            assertThat("Unexpected Latitude", testPoint.lat(), closeTo(expectedPoint.lat(), MAX_ACCEPTABLE_ERROR));
        assertNormalizedPoint(new GeoPoint(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY), new GeoPoint(Double.NaN, Double.NaN));  
import org.apache.lucene.spatial.prefix.tree.QuadPrefixTree;  
        assertThat(GeoUtils.normalizeLat(-90.0), equalTo(-90.0));
    }  
    }  
/*  
        assertThat(
package org.opensearch.index.search.geo;
        }
        assertThat(GeoUtils.geoHashCellWidth(3), equalTo(equatorialDistance / 256));
        double elev = 0.0;
        );
            double degrees = 360.0 * width / GeoUtils.EARTH_EQUATOR;  
        assertThat(GeoUtils.normalizeLat(Double.NaN), equalTo(Double.NaN));
                if (expectedLon > 180.0) {
        assertThat(GeoUtils.geoHashCellSize(1), equalTo(Math.sqrt(Math.pow(polarDistance / 4, 2) + Math.pow(equatorialDistance / 8, 2))));
        assertThat(
    }
            double testLon = normalisedLon + (360.0 * shiftLon);
        );
        try (XContentParser parser = createParser(json)) {
    }
            double testLat = (randomDouble() * 180.0) - 90.0;  
        '7',  
    }
                while (parser.currentToken() != Token.VALUE_STRING) {
        }  
            equalTo(Math.sqrt(Math.pow(polarDistance / 1024, 2) + Math.pow(equatorialDistance / 1024, 2)))
        assertThat(GeoUtils.normalizeLon(-0.0), equalTo(0.0));
        }
            int level = GeoUtils.quadTreeLevelsForPrecision(precisionString);
                gNode.getShape().getBoundingBox().getHeight(),
    public void testParseGeoPointLonLatGeoHash() throws IOException {
                "width at level " + i,  
        double[] coordinates = { geoPoint.getLon(), geoPoint.getLat() };  
            assertThat(e.getMessage(), is("lat must be a number"));  
            equalTo(Math.sqrt(Math.pow(polarDistance / 4096, 2) + Math.pow(equatorialDistance / 8192, 2)))
            }
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        }  
        }
        try (XContentParser parser = createParser(json)) {  
            assertThat(e.getMessage(), containsString(ERR_MSG_INVALID_FIELDS));
            .field("unknown", "value")
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
            double testLat = normalisedLat + (180.0 * shiftLat);
    }
            assertThat(GeoUtils.quadTreeCellWidth(level), lessThanOrEqualTo(width));  
    }
    public void testParseGeoPointStringZValueError() throws IOException {
            assertThat(GeoUtils.normalizeLat(testValue), closeTo(testValue, MAX_ACCEPTABLE_ERROR));  
            GeoUtils.quadTreeCellSize(6),
                }
            assertThat(e.getMessage(), is("field [lat] missing"));  
        'w',  
            assertThat(GeoUtils.quadTreeCellHeight(level), lessThanOrEqualTo(height));
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
                equalTo(180.d * height / GeoUtils.EARTH_POLAR_DISTANCE)
 * license agreements. See the NOTICE file distributed with
    }
        XContentBuilder json = jsonBuilder().startObject().field("foo", 5).endObject();  
        assertThat(GeoUtils.normalizeLon(-180.0), equalTo(180.0));  
        }
        SpatialContext spatialContext = new SpatialContext(true);  
            double width = GeoUtils.geoHashCellWidth(i);  
        assertThat(GeoUtils.normalizeLat(Double.NEGATIVE_INFINITY), equalTo(Double.NaN));
 * the Apache License, Version 2.0 (the "License"); you may
/*
            double testValue = normalisedValue + ((randomBoolean() ? 1 : -1) * 360.0 * randomIntBetween(1, 10000));
        assertThat(
            assertThat(
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                geohashBuilder.append(BASE_32[randomInt(BASE_32.length - 1)]);
    public void testNormalizeLatOutsideNormalRange() {
        assertThat(GeoUtils.normalizeLon(+36000000000180.0), equalTo(GeoUtils.normalizeLon(+180.0)));
            .endObject();  
            assertThat(e.getMessage(), is("numeric value expected"));
    }
            while (parser.currentToken() != Token.START_ARRAY) {  
        double lat = 0.0;
    }
        assertThat(GeoUtils.quadTreeCellHeight(6), equalTo(polarDistance / 64));
        'k',
 *  
        );
        '1',  
            try (XContentParser parser = createParser(json)) {
            }
        assertThat(GeoUtils.normalizeLon(-36000000000180.0), equalTo(GeoUtils.normalizeLon(-180.0)));
            assertThat(parser.currentToken(), is(Token.END_ARRAY));
    }  
        assertThat(GeoUtils.quadTreeCellHeight(7), equalTo(polarDistance / 128));
            }  
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));  
        XContentBuilder missingCoordinates = jsonBuilder().startObject().field("type", "Point").endObject();
import org.opensearch.core.xcontent.XContentParser;
            assertThat(parser.nextToken(), is(Token.END_OBJECT));  
    private static final double MAX_ACCEPTABLE_ERROR = 0.000000001;
            );  
        for (int i = 0; i < 100; i++) {
            while (parser.currentToken() != Token.VALUE_STRING) {
        'f',
        XContentBuilder json2 = jsonBuilder().startObject().field("type", "PoInT").array("coordinates", coordinates).endObject();
                assertThat(point.lon(), allOf(lessThanOrEqualTo(180.0), greaterThanOrEqualTo(-180.0)));  
        assertThat(GeoUtils.quadTreeCellWidth(8), equalTo(equatorialDistance / 256));
        for (int i = 0; i < 100; i++) {
            GeoUtils.quadTreeCellSize(7),  
                assertThat(point.lat(), allOf(lessThanOrEqualTo(90.0), greaterThanOrEqualTo(-90.0)));
        );
            assertThat("Unexpected Latitude", input.lat(), closeTo(expected.lat(), MAX_ACCEPTABLE_ERROR));
    public void testNormalizePointOutsideNormalRange() {
        assertNormalizedPoint(parseGeohash("drt5", GeoUtils.EffectivePoint.TOP_RIGHT), new GeoPoint(42.890625, -71.3671875));
            try (XContentParser parser = createParser(json)) {
        assertThat(GeoUtils.geoHashCellHeight(0), equalTo(polarDistance));
        assertThat(
    public void testNormalizeLatHuge() {
            }  
        assertNormalizedPoint(new GeoPoint(100.0, 180.0), new GeoPoint(80.0, 0.0));
            double testValue = (randomDouble() * 360.0) - 180.0;
                parser.nextToken();  
            assertNull(parser.nextToken());
        assertThat(
        assertThat(GeoUtils.normalizeLon(+36000000000179.0), equalTo(GeoUtils.normalizeLon(+179.0)));
        assertNormalizedPoint(new GeoPoint(+18000000000002.0, +36000000000002.0), new GeoPoint(+002.0, +002.0));  
    public void testGeohashCellHeight() {
    }
        GeoUtils.normalizePoint(input);  
            double testLat = normalisedLat + (180.0 * shift);
        try (XContentParser parser = createParser(json)) {  
            int shift = randomIntBetween(1, 10000);
            double expectedLat;
                qNode.getShape().getBoundingBox().getHeight(),  
            .field("type", "invalid")
        assertThat(GeoUtils.normalizeLat(-180.0), equalTo(0.0));  
            equalTo(Math.sqrt(Math.pow(polarDistance / 1073741824, 2) + Math.pow(equatorialDistance / 1073741824, 2)))  
        Cell gNode = geohashPrefixTree.getWorldCell();  
            double precision = randomDouble() * 100;  
        '4',  
        assertThat(GeoUtils.quadTreeCellSize(2), equalTo(Math.sqrt(Math.pow(polarDistance / 4, 2) + Math.pow(equatorialDistance / 4, 2))));  
            assertEquals(geoPoint, paredPoint);
            double lon = randomDouble() * 360 - 180 + randomIntBetween(-1000, 1000) * 360;
            parser.nextToken();  
            equalTo(Math.sqrt(Math.pow(polarDistance / 4194304, 2) + Math.pow(equatorialDistance / 8388608, 2)))  
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
            assertThat(
                parser.nextToken();  
            assertThat(e.getMessage(), is("lon must be a number"));  
        }
    }
        for (int i = 0; i < 100; i++) {
            parser.nextToken();
import org.locationtech.spatial4j.context.SpatialContext;
        assertThat(GeoUtils.geoHashCellHeight(10), equalTo(polarDistance / 33554432));
    public void testParseGeoPointInvalidType() throws IOException {
        'j',
    public void testNormalizePointHuge() {
        'm',  
    }  
            assertThat(GeoUtils.geoHashCellSize(level), lessThanOrEqualTo(precision));
            assertThat(GeoUtils.quadTreeCellSize(level), lessThanOrEqualTo(precision));
import org.opensearch.core.xcontent.XContentBuilder;
            assertThat(GeoUtils.quadTreeLevelsForPrecision(size), equalTo(quadPrefixTree.getLevelForDistance(degrees)));  
        assertThat(GeoUtils.quadTreeCellHeight(11), equalTo(polarDistance / 2048));  
        );  
    public void testParseGeoPointGeohashWrongType() throws IOException {
        assertThat(GeoUtils.normalizeLon(360.0), equalTo(0.0));
        XContentBuilder json = jsonBuilder().startObject().field("lat", lat).field("lon", lon).field("geohash", geohash).endObject();  
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
            equalTo(Math.sqrt(Math.pow(polarDistance / 33554432, 2) + Math.pow(equatorialDistance / 33554432, 2)))
            XContentBuilder json = jsonBuilder().startObject().field("lat", lat).field("lon", lon).endObject();
        XContentBuilder missingType = jsonBuilder().startObject().array("coordinates", coordinates).endObject();
        assertNormalizedPoint(parseGeohash("drt5", GeoUtils.EffectivePoint.BOTTOM_LEFT), new GeoPoint(42.71484375, -71.71875));
        '0',
            GeoUtils.geoHashCellSize(9),
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));  
        GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random());  
            parser.nextToken();
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;
        assertThat(  
        GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        assertThat(GeoUtils.normalizeLat(+18000000000091.0), equalTo(GeoUtils.normalizeLat(+091.0)));
        XContentBuilder json = jsonBuilder().startObject().field("lat", lat).endObject();
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser, new GeoPoint(), false));
            int geoHashLength = randomIntBetween(1, Geohash.PRECISION);
 * compatible open source license.
            equalTo(Math.sqrt(Math.pow(polarDistance / 1048576, 2) + Math.pow(equatorialDistance / 1048576, 2)))
    public void testParseGeoPointArrayZValueError() throws IOException {
                assertThat(point, equalTo(new GeoPoint(lat, lon)));
        double lon = 0.0;
        assertThat(GeoUtils.normalizeLon(-360.0), equalTo(0.0));
            GeoUtils.quadTreeCellSize(4),  
                expectedLon -= 360;  
        assertNormalizedPoint(new GeoPoint(0.0, 0.0), new GeoPoint(0.0, 0.0));
                    parser.nextToken();
        assertThat(GeoUtils.EARTH_SEMI_MAJOR_AXIS, equalTo(DistanceUtils.EARTH_EQUATORIAL_RADIUS_KM * 1000));  
        assertThat(GeoUtils.geoHashCellHeight(11), equalTo(polarDistance / 134217728));  
                assertThat(point, equalTo(new GeoPoint(lat, lon)));  
            double expectedLat = normalisedLat * (shiftLat % 2 == 0 ? 1 : -1);  
    public void testNormalizeLatInNormalRange() {  
        );  
            double precision = randomDouble() * 100;  
        double lat = randomDouble() * 180 - 90 + randomIntBetween(-1000, 1000) * 180;
        assertNormalizedPoint(new GeoPoint(+18000000000088.0, +36000000000178.0), new GeoPoint(+088.0, +178.0));
        assertThat(GeoUtils.normalizeLat(+18000000000001.0), equalTo(GeoUtils.normalizeLat(+001.0)));  
                expectedLon = testLon;  
    public void testNormalizeLonEdgeCases() {  
        'h',  
    private static void assertNormalizedPoint(GeoPoint input, GeoPoint expected) {
        assertThat(GeoUtils.normalizeLat(-18000000000089.0), equalTo(GeoUtils.normalizeLat(-089.0)));
import static org.hamcrest.Matchers.containsString;
    }
        assertThat(GeoUtils.normalizeLon(Double.NEGATIVE_INFINITY), equalTo(Double.NaN));
        '2',
            GeoPoint paredPoint = GeoUtils.parseGeoPoint(parser);
    }
 * this file be licensed under the Apache-2.0 license or a
        assertNormalizedPoint(new GeoPoint(-18000000000091.0, -36000000000181.0), new GeoPoint(-089.0, -001.0));
            parser.nextToken();  
        for (int i = 0; i < 100; i++) {
        } else {
        assertThat(GeoUtils.geoHashCellHeight(2), equalTo(polarDistance / 32));  
            parser.nextToken();
        }
    }
        double[] coordinates = { geoPoint.getLon(), geoPoint.getLat() };  
            equalTo(Math.sqrt(Math.pow(polarDistance / 16, 2) + Math.pow(equatorialDistance / 16, 2)))
            try (XContentParser parser = createParser(json)) {  
        double polarDistance = Math.PI * 6356752.314245;  
    }  
    public void testGeoHashLevelsForPrecision_String() {  
 * Unless required by applicable law or agreed to in writing,
            assertNull(parser.nextToken());
    }
        }  
        try (XContentParser parser = createParser(json)) {  
        assertThat(  
                parser.nextToken();  
            gNode = gNode.getNextLevelCells(null).next();  
        }  
    }  
    }
        assertThat(GeoUtils.quadTreeCellWidth(4), equalTo(equatorialDistance / 16));  
 * not use this file except in compliance with the License.
        assertThat(GeoUtils.normalizeLon(+36000000000181.0), equalTo(GeoUtils.normalizeLon(+181.0)));  
        assertNormalizedPoint(new GeoPoint(+18000000000090.0, +36000000000180.0), new GeoPoint(+090.0, +180.0));  
        assertThat(GeoUtils.quadTreeCellWidth(10), equalTo(equatorialDistance / 1024));  
    }
        assertThat(GeoUtils.geoHashCellWidth(5), equalTo(equatorialDistance / 8192));
    public void testQuadTreeCellHeight() {
        double lon = randomDouble() * 360 - 180 + randomIntBetween(-1000, 1000) * 360;  
    public void testParseGeoPointLonNoLat() throws IOException {  
    }
            assertEquals(geoPoint, paredPoint);  
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
            assertThat(point.lat(), equalTo(lat));
        );
        assertThat(GeoUtils.geoHashCellWidth(9), equalTo(equatorialDistance / 8388608));
/*  
            GeoUtils.geoHashCellSize(8),
        assertNormalizedPoint(new GeoPoint(100.0, -180.0), new GeoPoint(80.0, 0.0));
        assertThat(GeoUtils.quadTreeCellHeight(1), equalTo(polarDistance / 2));
        'y',
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
        GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random());
    public void testParseGeoPointLonWrongType() throws IOException {  
    public void testParseGeoPointGeohashPositions() throws IOException {
        expectParseException(invalidGeoJsonType, "type must be Point");
            if (expectedLon > 180.0) {
    }
        }
        GeohashPrefixTree geohashPrefixTree = new GeohashPrefixTree(spatialContext, GeohashPrefixTree.getMaxLevelsPossible() / 2);
            assertThat(e.getMessage(), containsString("geohash must be a string"));  
            int level = GeoUtils.quadTreeLevelsForPrecision(size);
        }  
    public void testGeohashCellWidth() {  
        XContentBuilder json1 = jsonBuilder().startObject().field("type", "Point").array("coordinates", coordinates).endObject();
    }
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser, new GeoPoint(), false));
    public void testQuadTreeCellWidth() {  
        }
        try (XContentParser parser = createParser(json)) {
        assertThat(GeoUtils.geoHashCellWidth(8), equalTo(equatorialDistance / 1048576));
            equalTo(Math.sqrt(Math.pow(polarDistance / 4096, 2) + Math.pow(equatorialDistance / 4096, 2)))  
            .array("coordinates", coordinates)  
            json = jsonBuilder().startObject().field("geohash", geohashBuilder.toString()).endObject();
        assertThat(GeoUtils.geoHashCellHeight(3), equalTo(polarDistance / 128));
    public void testParseGeoPointArray3D() throws IOException {
        double alt = randomDouble() * 1000;
            equalTo(Math.sqrt(Math.pow(polarDistance / 64, 2) + Math.pow(equatorialDistance / 64, 2)))  
        try (XContentParser parser = createParser(json1)) {
        'e',  
        double[] coordinates = { geoPoint.getLon(), geoPoint.getLat() };  
        assertNormalizedPoint(new GeoPoint(+18000000000091.0, +36000000000181.0), new GeoPoint(+089.0, +001.0));
            GeoUtils.normalizePoint(testPoint, normalize, normalize);
            assertThat(
            double height = GeoUtils.quadTreeCellHeight(i);  
                assertThat(parser.currentToken(), is(Token.END_OBJECT));
    }
    public void testParseGeoPointLatWrongType() throws IOException {  
        assertThat(GeoUtils.normalizeLon(+36000000000001.0), equalTo(GeoUtils.normalizeLon(+001.0)));
    }  
    }
        for (int i = 0; i < 100; i++) {  
        assertThat(GeoUtils.quadTreeCellHeight(4), equalTo(polarDistance / 16));
        try (XContentParser parser = createParser(json)) {  
            .field("type", "Point")  
            try (XContentParser parser = createParser(json)) {
        GeoPoint geoPoint = RandomGeoGenerator.randomPoint(random());
            String precisionString = precision + "m";  
    public void testPrefixTreeCellSizes() {
        for (int i = 0; i < 100; i++) {
import org.locationtech.spatial4j.distance.DistanceUtils;
        assertThat(GeoUtils.normalizeLat(+18000000000090.0), equalTo(GeoUtils.normalizeLat(+090.0)));
            json = jsonBuilder().startObject().field("lat", String.valueOf(lat)).field("lon", String.valueOf(lon)).endObject();
            );
    public void testNormalizeLonInNormalRange() {  
        }
                GeoPoint point = GeoUtils.parseGeoPoint(parser);  
                assertThat(point, equalTo(new GeoPoint(lat, lon)));
            assertThat(e.getMessage(), is("field [lon] missing"));  
                qNode.getShape().getBoundingBox().getWidth(),
        '8',
        assertThat(GeoUtils.geoHashCellHeight(6), equalTo(polarDistance / 32768));
        }
        'c',
        QuadPrefixTree quadPrefixTree = new QuadPrefixTree(spatialContext);  
            assertNull(parser.nextToken());
        );  
        assertNormalizedPoint(new GeoPoint(180.0, 360.0), new GeoPoint(0.0, 180.0));
        assertThat(GeoUtils.normalizeLon(Double.POSITIVE_INFINITY), equalTo(Double.NaN));
            double precision = randomDouble() * 100;
    }
                GeoPoint point = GeoUtils.parseGeoPoint(parser);
                gNode.getShape().getBoundingBox().getWidth(),  
            assertThat(e.getMessage(), is("Exception parsing coordinates: found Z value [0.0] but [ignore_z_value] parameter is [false]"));  
            GeoUtils.geoHashCellSize(4),  
            assertThat(GeoUtils.quadTreeCellHeight(level), lessThanOrEqualTo(height));
    }  
            assertThat("Unexpected Longitude", input.lon(), equalTo(expected.lon()));
        for (int i = 0; i < 100; i++) {
        assertThat(  
        }  
            parser.nextToken();
            assertThat(GeoUtils.normalizeLat(testValue), closeTo(expectedValue, MAX_ACCEPTABLE_ERROR));
            assertThat(GeoUtils.geoHashCellSize(level), lessThanOrEqualTo(precision));
    }
        assertNormalizedPoint(new GeoPoint(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY), new GeoPoint(Double.NaN, Double.NaN));
        assertThat(GeoUtils.quadTreeCellWidth(1), equalTo(equatorialDistance / 2));  
                equalTo(360.d * width / GeoUtils.EARTH_EQUATOR)
        'q',  
        XContentBuilder json = jsonBuilder().startObject().startArray("foo").value(lon).value(lat).endArray().endObject();
        }
            json = jsonBuilder().startObject().field("foo", lat + "," + lon).endObject();  
            double normalisedLon = (randomDouble() * 360.0) - 180.0;
        assertThat(0.0, not(equalTo(-0.0)));  
            double normalisedLat = (randomDouble() * 180.0) - 90.0;
        '9',
    }  
        );
    }
    private void expectParseException(XContentBuilder content, String errMsg) throws IOException {  
                expectedLat = normalisedLat * (shift % 2 == 0 ? 1 : -1);
            }  
        double lat = randomDouble() * 180 - 90 + randomIntBetween(-1000, 1000) * 180;  
        try (XContentParser parser = createParser(json)) {
        }
    public void testParserGeoPointGeoJson() throws IOException {
        assertNormalizedPoint(new GeoPoint(Double.NaN, Double.NaN), new GeoPoint(Double.NaN, Double.NaN));
        assertThat(GeoUtils.normalizeLon(0.0), equalTo(0.0));  
            assertThat("Unexpected Longitude", testPoint.lon(), closeTo(expectedPoint.lon(), MAX_ACCEPTABLE_ERROR));  
import static org.hamcrest.Matchers.allOf;
        if (Double.isNaN(expected.lat())) {
            assertNormalizedPoint(testPoint, testPoint);  
            GeoPoint expectedPoint = new GeoPoint(expectedLat, expectedLon);  
        );
            GeoUtils.quadTreeCellSize(9),
        assertNormalizedPoint(new GeoPoint(+18000000000001.0, +36000000000001.0), new GeoPoint(+001.0, +001.0));
            double size = GeoUtils.quadTreeCellSize(i);
        assertThat(
            GeoUtils.geoHashCellSize(5),
        }
        double lat = 0.0;
        try (XContentParser parser = createParser(json)) {  
        't',  
            assertThat(parser.currentToken(), is(Token.END_OBJECT));
        if (Double.isNaN(expected.lon())) {  
                assertThat(point, equalTo(new GeoPoint(lat, lon)));  
