        assertThat(gp.lon(), closeTo(longitude, GEOTILE_TOLERANCE));
        assertStrCodec(0x77FFFF4580000000L, "29/536869420/0", 29);
        assertEquals(0x71127D27C8ACA67AL, longEncode(13, -15, 28));
        assertStrCodec(0x6411BD6BA0A98359L, "25/9300829/11109209", 25);
        assertStrCodec(0x7624FA4FA0000000L, "29/287822461/0", 29);
        assertEquals(0x0800000040000001L, longEncode(stringEncode(longEncode(1, 1, 2))));
        double lon = randomIntBetween(-180, 180);
     * Mercator projection does not show anything above 85 or below -85,
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.longEncode;
     * A few hardcoded lat/lng/zoom hashing expectations
     */
                    assertEquals(expectedTileIndex, actualTileIndex);
    }
        // check point inside
        expectThrows(IllegalArgumentException.class, () -> longEncode("12/asdf/1"));
    }
import org.opensearch.common.geo.GeoPoint;
    private void assertGeoPointEquals(GeoPoint gp, final double longitude, final double latitude) {
        final GeoPoint gp = keyToGeoPoint(key);
 * this work for additional information regarding copyright
 *
                    // Same point should be generated from the string key
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.checkPrecisionRange;
        assertThat(ex.getMessage(), containsString("Invalid geotile_grid precision of 30. Must be between 0 and 29."));
    public void testHashToGeoPoint() {
 * compatible open source license.
 * not use this file except in compliance with the License.
                    String actualTileIndex = stringEncode(longEncode(point.lon(), point.lat(), zoom));
                    }
    }
     */
    private static final double GEOTILE_TOLERANCE = 1E-5D;
 *
            }
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/0"));
    private void assertStrCodec(long hash, String key, int zoom) {
        int zoom = randomIntBetween(0, MAX_ZOOM);
/*
        assertEquals(0x71127D27C8ACA67AL, longEncode(stringEncode(longEncode(13, -15, 28))));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(0x140000024000000EL, longEncode(stringEncode(longEncode(-328.231870, 16.064082, 5))));
        String clippedTileIndex = stringEncode(longEncode(lon, clippedLat, zoom));
        assertStrCodec(0x0000000000000000L, "0/0/0", 0);
 * the Apache License, Version 2.0 (the "License"); you may
    /**
    }
        assertEquals(0x0400000020000001L, longEncode(stringEncode(longEncode(13, -89, 1))));
                    assertEquals(hash, hashAsLong2);
import static org.hamcrest.Matchers.containsString;
 * ownership. Elasticsearch licenses this file to you under
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.keyToGeoPoint;
                    GeoPoint point = hashToGeoPoint(hash);
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint((MAX_ZOOM + 1) + "/0/0"));
        assertEquals(0x7624FA4FA0000000L, longEncode(13, 88, 29));
     */
        assertEquals(0x6436F96B60000000L, longEncode(stringEncode(longEncode(-590.769588, 89.549167, 25))));
            final int max_index = (int) Math.pow(2, zoom);
            }
 * The OpenSearch Contributors require contributions made to
        assertEquals(0x7624FA4FA0000000L, longEncode(stringEncode(longEncode(13, 88, 29))));
        double lat = randomBoolean() ? randomDoubleBetween(-90, minLat, true) : randomDoubleBetween(maxLat, 90, true);
    }
 * You may obtain a copy of the License at
    public void testPointToTile() {
        Rectangle rectangle = GeoTileUtils.toBoundingBox(xTile, yTile, zoom);
     * is compatible with its String based counterpart
            expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint(zoom + "/" + max_index + "/0"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.hashToGeoPoint;
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/-1/-1"));
        assertEquals(0x6411BD6BA0A98359L, longEncode(999.787079, 51.830093, 25));
 *
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0"));
    /**
        assertEquals(0x6411BD6BA0A98359L, longEncode(stringEncode(longEncode(999.787079, 51.830093, 25))));
 * Licensed to Elasticsearch under one or more contributor
            int maxTile = 1 << zoom;
        assertEquals(0x0400000020000001L, longEncode(13, -89, 1));
        expectThrows(IllegalArgumentException.class, () -> stringEncode(0x0000000020000000L)); // z=0,x=1,y=0
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.stringEncode;
            for (int x = 0; x < maxTile; x++) {
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("a/0/0"));
 * specific language governing permissions and limitations
}
        assertEquals(0x0400000020000000L, longEncode(stringEncode(longEncode(13, 95, 1))));
        assertStrCodec(0x0800000040000001L, "2/2/1", 2);
        double y = randomDoubleBetween(rectangle.getMinY(), rectangle.getMaxY(), false);
        assertEquals(tileIndex, clippedTileIndex);
        double minLat = -GeoTileUtils.LATITUDE_MASK;
 * Unless required by applicable law or agreed to in writing,
                    String expectedTileIndex = zoom + "/" + x + "/" + y;
        assertThat(GeoTileUtils.getXTile(rectangle.getMinX(), tiles), equalTo(xTile));
 * GitHub history for details.
import static org.hamcrest.Matchers.anyOf;
                }
     * Ensure that for all points at all supported precision levels that the long encoding of a geotile
        assertGeoPointEquals(keyToGeoPoint("29/536870000/10"), 179.99938879162073, 85.05112817241982);
import org.opensearch.geometry.Rectangle;
        assertEquals(0x0400000020000000L, longEncode(13, 89, 1));
        assertStrCodec(0x751BD6BBCA983596L, "29/148813278/177747350", 29);
import static org.hamcrest.Matchers.equalTo;
        assertStrCodec(0x0400000020000001L, "1/1/1", 1);
        assertEquals(0x7624FA4FBFFFFFFFL, longEncode(stringEncode(longEncode(13, -88, 29))));
        assertStrCodec(0x7624FA4FBFFFFFFFL, "29/287822461/536870911", 29);
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/0/0/0"));
        assertEquals(0x751BD6BBCA983596L, longEncode(999.787079, 51.830093, 29));
            assertEquals(i, checkPrecisionRange(i));
        for (int i = 0; i <= 29; i++) {
        expectThrows(IllegalArgumentException.class, () -> longEncode("foo"));
        assertEquals(hash, longEncode(gp.lon(), gp.lat(), zoom));
    }
                    long hash = longEncode(lng, lat, p);
        assertEquals(0x0C00000060000000L, longEncode(stringEncode(longEncode(-20, 100, 3))));
     * Precision validation should throw an error if its outside of the valid range.
        int zoom = randomIntBetween(0, MAX_ZOOM);
        assertStrCodec(0x3C00095540001CA5L, "15/19114/7333", 15);
 * license agreements. See the NOTICE file distributed with
        assertEquals(0x3C00095540001CA5L, longEncode(stringEncode(longEncode(30, 70, 15))));
        expectThrows(IllegalArgumentException.class, () -> stringEncode(0x7800000000000000L)); // z=30
        }
        assertThat(ex.getMessage(), containsString("Invalid geotile_grid precision of -1. Must be between 0 and 29."));
                }
        assertEquals(0x0400000020000000L, longEncode(13, 95, 1));
        expectThrows(IllegalArgumentException.class, () -> stringEncode(0x0000000000000001L)); // z=0,x=0,y=1
        assertStrCodec(0x0400000020000000L, "1/1/0", 1);
 * under the License.
        }
        assertEquals(0x7624FA4FBFFFFFFFL, longEncode(13, -88, 29));
        assertEquals(0x6436F96B60000000L, longEncode(-590.769588, 89.549167, 25));
        // check corners
        int xTile = randomIntBetween(0, zoom);
        assertEquals(0x740000BA7FFFFFFFL, longEncode(-179.999, -89.999, 29));
    /**
     * so ensure they are clipped correctly.
        String tileIndex = stringEncode(longEncode(lon, lat, zoom));
        for (int zoom = 0; zoom < 5; zoom++) {
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint(""));
        expectThrows(IllegalArgumentException.class, () -> stringEncode(-1L));
    /**
        assertEquals(0x3C00095540001CA5L, longEncode(30, 70, 15));
     */
    public void testStringEncode() {
        assertThat(GeoTileUtils.getYTile(rectangle.getMaxY(), tiles), anyOf(equalTo(yTile - 1), equalTo(yTile)));
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/0/a"));
        assertStrCodec(0x4C0077776003A9ACL, "19/244667/240044", 19);
        expectThrows(IllegalArgumentException.class, () -> longEncode(0, 0, -1));
        assertEquals(0x0000000000000000L, longEncode(0, 0, 0));
                for (int y = 0; y < maxTile; y++) {
        assertEquals(0x0C00000060000000L, longEncode(-20, 100, 3));
        int yTile = randomIntBetween(0, zoom);
                    assertEquals(point, keyToGeoPoint(stringEncode(hash)));
import static org.hamcrest.Matchers.closeTo;
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> checkPrecisionRange(-1));
        assertThat(GeoTileUtils.getYTile(y, tiles), equalTo(yTile));
package org.opensearch.search.aggregations.bucket.geogrid;
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/-1/0"));
        assertEquals(0x740000BA7FFFFFFFL, longEncode(stringEncode(longEncode(-179.999, -89.999, 29))));
     */
public class GeoTileUtilsTests extends OpenSearchTestCase {
        assertEquals(0x0800000040000001L, longEncode(1, 1, 2));
/*
    public void testGeoTileAsLongRoutines() {
    public void testCheckPrecisionRange() {
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/a/0"));
        assertEquals(0x77FFFF4580000000L, longEncode(179.999, 89.999, 29));
        assertStrCodec(0x140000024000000EL, "5/18/14", 5);
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(0x77FFFF4580000000L, longEncode(stringEncode(longEncode(179.999, 89.999, 29))));
                    if (p > 0) {
        ex = expectThrows(IllegalArgumentException.class, () -> checkPrecisionRange(30));
        assertEquals(0x4C0077776003A9ACL, longEncode(-12, 15, 19));
        int tiles = 1 << zoom;
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(0x77CF880A20000000L, longEncode(-557.039740, -632.103969, 29));
        assertThat(GeoTileUtils.getYTile(rectangle.getMinY(), tiles), anyOf(equalTo(yTile + 1), equalTo(yTile)));
                for (int p = 0; p <= 29; p++) {
        assertGeoPointEquals(keyToGeoPoint("1/0/0"), -90.0, 66.51326044311186);
     * Make sure that hash produces the expected key, and that the key could be converted to hash via a GeoPoint
        assertThat(GeoTileUtils.getXTile(rectangle.getMaxX(), tiles), equalTo(Math.min(tiles - 1, xTile + 1)));
                        assertNotEquals(0, hash);
 * KIND, either express or implied.  See the License for the
        expectThrows(NullPointerException.class, () -> keyToGeoPoint(null));
        assertGeoPointEquals(keyToGeoPoint("1/1/0"), 90.0, 66.51326044311186);
        assertEquals(0x0000000000000000L, longEncode(stringEncode(longEncode(0, 0, 0))));
        assertStrCodec(0x0C00000060000000L, "3/3/0", 3);
        assertGeoPointEquals(keyToGeoPoint("29/10/536870000"), -179.99999295920134, -85.0510760525731);
                    GeoPoint point = keyToGeoPoint(expectedTileIndex);
        assertStrCodec(0x77CF880A20000000L, "29/511459409/0", 29);
     */
     * A few hardcoded lat/lng/zoom hashing expectations
        assertThat(GeoTileUtils.getXTile(x, tiles), equalTo(xTile));
    public void testLongEncodeFromString() {
        }
        assertEquals(0x0400000020000001L, longEncode(stringEncode(longEncode(13, -95, 1))));
    public void testSingularityAtPoles() {
            expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint(zoom + "/0/" + max_index));
                    long hashAsLong2 = longEncode(point.lon(), point.lat(), p);
        assertStrCodec(0x740000BA7FFFFFFFL, "29/1491/536870911", 29);
        double clippedLat = Math.min(Math.max(lat, minLat), maxLat);
        assertEquals(0x0400000020000000L, longEncode(stringEncode(longEncode(13, 89, 1))));
        assertGeoPointEquals(keyToGeoPoint("0/0/0"), 0.0, 0.0);
    public void testLongEncode() {
/*
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
        expectThrows(IllegalArgumentException.class, () -> longEncode(-1, 0, MAX_ZOOM + 1));
    }
        // noinspection ConstantConditions
        double maxLat = GeoTileUtils.LATITUDE_MASK;
        assertEquals(0x4C0077776003A9ACL, longEncode(stringEncode(longEncode(-12, 15, 19))));
        assertThat(gp.lat(), closeTo(latitude, GEOTILE_TOLERANCE));
    /**
        assertEquals(key, stringEncode(hash));
        for (int z = 0; z <= MAX_ZOOM; z++) {
        assertGeoPointEquals(keyToGeoPoint("1/0/1"), -90.0, -66.51326044311186);
 * software distributed under the License is distributed on an
        assertEquals(0x77CF880A20000000L, longEncode(stringEncode(longEncode(-557.039740, -632.103969, 29))));
            final int zoom = z;
        assertStrCodec(0x6436F96B60000000L, "25/28822363/0", 25);
    /**
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("a"));
    }
        assertEquals(0x0400000020000001L, longEncode(13, -95, 1));
        assertEquals(0x140000024000000EL, longEncode(-328.231870, 16.064082, 5));
 */
                    // GeoPoint would be in the center of the bucket, thus must produce the same hash
    }
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/0/-1"));
        assertEquals(0x751BD6BBCA983596L, longEncode(stringEncode(longEncode(999.787079, 51.830093, 29))));
        }
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("-1/0/0"));
        assertGeoPointEquals(keyToGeoPoint("1/1/1"), 90.0, -66.51326044311186);
        double x = randomDoubleBetween(rectangle.getMinX(), rectangle.getMaxX(), false);
        assertStrCodec(0x71127D27C8ACA67AL, "28/143911230/145532538", 28);
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.MAX_ZOOM;
     * Make sure the polar regions are handled properly.
        for (double lat = -90; lat <= 90; lat++) {
 */
            for (double lng = -180; lng <= 180; lng++) {
 */
