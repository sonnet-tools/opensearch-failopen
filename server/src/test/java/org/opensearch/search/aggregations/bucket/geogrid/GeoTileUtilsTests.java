    private void assertStrCodec(long hash, String key, int zoom) {
        assertStrCodec(0x0C00000060000000L, "3/3/0", 3);
        assertStrCodec(0x140000024000000EL, "5/18/14", 5);
    public void testSingularityAtPoles() {  
        String tileIndex = stringEncode(longEncode(lon, lat, zoom));
    }
                    assertEquals(expectedTileIndex, actualTileIndex);  
import org.opensearch.common.geo.GeoPoint;
        expectThrows(IllegalArgumentException.class, () -> stringEncode(0x0000000000000001L)); // z=0,x=0,y=1
public class GeoTileUtilsTests extends OpenSearchTestCase {
            for (int x = 0; x < maxTile; x++) {
        double lon = randomIntBetween(-180, 180);  
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint(""));
        assertThat(gp.lat(), closeTo(latitude, GEOTILE_TOLERANCE));
        assertStrCodec(0x751BD6BBCA983596L, "29/148813278/177747350", 29);
        assertEquals(0x7624FA4FA0000000L, longEncode(stringEncode(longEncode(13, 88, 29))));
                    long hash = longEncode(lng, lat, p);
     * is compatible with its String based counterpart
        assertThat(GeoTileUtils.getXTile(rectangle.getMaxX(), tiles), equalTo(Math.min(tiles - 1, xTile + 1)));
        assertEquals(0x0000000000000000L, longEncode(0, 0, 0));
        assertGeoPointEquals(keyToGeoPoint("1/0/1"), -90.0, -66.51326044311186);  
        assertEquals(0x740000BA7FFFFFFFL, longEncode(stringEncode(longEncode(-179.999, -89.999, 29))));  
        assertStrCodec(0x7624FA4FBFFFFFFFL, "29/287822461/536870911", 29);
 * KIND, either express or implied.  See the License for the
        assertGeoPointEquals(keyToGeoPoint("29/10/536870000"), -179.99999295920134, -85.0510760525731);  
        int xTile = randomIntBetween(0, zoom);  
 * GitHub history for details.
        assertEquals(0x0400000020000000L, longEncode(13, 95, 1));
        assertStrCodec(0x3C00095540001CA5L, "15/19114/7333", 15);
        for (double lat = -90; lat <= 90; lat++) {
     * A few hardcoded lat/lng/zoom hashing expectations
        double x = randomDoubleBetween(rectangle.getMinX(), rectangle.getMaxX(), false);  
        for (int zoom = 0; zoom < 5; zoom++) {
        assertEquals(0x6411BD6BA0A98359L, longEncode(stringEncode(longEncode(999.787079, 51.830093, 25))));
        expectThrows(IllegalArgumentException.class, () -> stringEncode(-1L));  
                    }
        assertStrCodec(0x6411BD6BA0A98359L, "25/9300829/11109209", 25);
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/-1/-1"));  
        assertGeoPointEquals(keyToGeoPoint("0/0/0"), 0.0, 0.0);  
        assertEquals(0x7624FA4FA0000000L, longEncode(13, 88, 29));  
        assertEquals(0x71127D27C8ACA67AL, longEncode(13, -15, 28));
                    String actualTileIndex = stringEncode(longEncode(point.lon(), point.lat(), zoom));
                for (int p = 0; p <= 29; p++) {
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(key, stringEncode(hash));  
                    if (p > 0) {  
}  
        assertEquals(0x7624FA4FBFFFFFFFL, longEncode(13, -88, 29));
        expectThrows(IllegalArgumentException.class, () -> stringEncode(0x7800000000000000L)); // z=30
        assertStrCodec(0x0800000040000001L, "2/2/1", 2);
     * Make sure that hash produces the expected key, and that the key could be converted to hash via a GeoPoint  
        assertGeoPointEquals(keyToGeoPoint("29/536870000/10"), 179.99938879162073, 85.05112817241982);
        expectThrows(NullPointerException.class, () -> keyToGeoPoint(null));  
package org.opensearch.search.aggregations.bucket.geogrid;
        double minLat = -GeoTileUtils.LATITUDE_MASK;
        assertEquals(0x4C0077776003A9ACL, longEncode(stringEncode(longEncode(-12, 15, 19))));
        assertStrCodec(0x71127D27C8ACA67AL, "28/143911230/145532538", 28);  
        assertEquals(0x751BD6BBCA983596L, longEncode(999.787079, 51.830093, 29));
    public void testStringEncode() {
            final int max_index = (int) Math.pow(2, zoom);
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.keyToGeoPoint;  
        assertThat(ex.getMessage(), containsString("Invalid geotile_grid precision of 30. Must be between 0 and 29."));
     */  
        assertThat(gp.lon(), closeTo(longitude, GEOTILE_TOLERANCE));
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("-1/0/0"));  
import static org.hamcrest.Matchers.equalTo;  
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/a/0"));
        assertGeoPointEquals(keyToGeoPoint("1/1/0"), 90.0, 66.51326044311186);
        expectThrows(IllegalArgumentException.class, () -> longEncode("12/asdf/1"));
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/0/0/0"));
        assertEquals(tileIndex, clippedTileIndex);  
        expectThrows(IllegalArgumentException.class, () -> longEncode(0, 0, -1));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.bucket.GeoTileUtils;  
        double lat = randomBoolean() ? randomDoubleBetween(-90, minLat, true) : randomDoubleBetween(maxLat, 90, true);
        assertEquals(0x6411BD6BA0A98359L, longEncode(999.787079, 51.830093, 25));  
        assertEquals(hash, longEncode(gp.lon(), gp.lat(), zoom));
        assertStrCodec(0x77CF880A20000000L, "29/511459409/0", 29);  
        double maxLat = GeoTileUtils.LATITUDE_MASK;
        // check point inside
        expectThrows(IllegalArgumentException.class, () -> longEncode("foo"));  
        assertGeoPointEquals(keyToGeoPoint("1/0/0"), -90.0, 66.51326044311186);
/*
     * so ensure they are clipped correctly.
        assertEquals(0x751BD6BBCA983596L, longEncode(stringEncode(longEncode(999.787079, 51.830093, 29))));
 */  
                        assertNotEquals(0, hash);
    /**  
 *
                    String expectedTileIndex = zoom + "/" + x + "/" + y;  
        assertEquals(0x0400000020000001L, longEncode(stringEncode(longEncode(13, -95, 1))));  
        // check corners  
     */
        }  
 * not use this file except in compliance with the License.
        assertEquals(0x3C00095540001CA5L, longEncode(stringEncode(longEncode(30, 70, 15))));
            expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint(zoom + "/" + max_index + "/0"));
 * You may obtain a copy of the License at  
     */
     * A few hardcoded lat/lng/zoom hashing expectations  
        assertThat(GeoTileUtils.getXTile(x, tiles), equalTo(xTile));
            expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint(zoom + "/0/" + max_index));  
        assertEquals(0x6436F96B60000000L, longEncode(stringEncode(longEncode(-590.769588, 89.549167, 25))));  
        Rectangle rectangle = GeoTileUtils.toBoundingBox(xTile, yTile, zoom);
    private void assertGeoPointEquals(GeoPoint gp, final double longitude, final double latitude) {  
    }
                    assertEquals(hash, hashAsLong2);
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0"));  
        assertEquals(0x7624FA4FBFFFFFFFL, longEncode(stringEncode(longEncode(13, -88, 29))));
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> checkPrecisionRange(-1));
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.MAX_ZOOM;  
    /**
        assertStrCodec(0x6436F96B60000000L, "25/28822363/0", 25);  
        for (int i = 0; i <= 29; i++) {
        assertEquals(0x77FFFF4580000000L, longEncode(stringEncode(longEncode(179.999, 89.999, 29))));
import static org.hamcrest.Matchers.containsString;
        String clippedTileIndex = stringEncode(longEncode(lon, clippedLat, zoom));
                    assertEquals(point, keyToGeoPoint(stringEncode(hash)));
 * license agreements. See the NOTICE file distributed with
     */  
     * Precision validation should throw an error if its outside of the valid range.
    public void testLongEncode() {
 * The OpenSearch Contributors require contributions made to  
 */  
        assertEquals(0x77CF880A20000000L, longEncode(stringEncode(longEncode(-557.039740, -632.103969, 29))));  
        assertEquals(0x0C00000060000000L, longEncode(-20, 100, 3));
        assertEquals(0x140000024000000EL, longEncode(-328.231870, 16.064082, 5));
            int maxTile = 1 << zoom;  
    public void testLongEncodeFromString() {
    public void testCheckPrecisionRange() {  
        assertEquals(0x0400000020000000L, longEncode(stringEncode(longEncode(13, 89, 1))));  
            }  
        assertStrCodec(0x7624FA4FA0000000L, "29/287822461/0", 29);
    /**  
                for (int y = 0; y < maxTile; y++) {
        assertThat(GeoTileUtils.getYTile(rectangle.getMaxY(), tiles), anyOf(equalTo(yTile - 1), equalTo(yTile)));  
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/0"));
        for (int z = 0; z <= MAX_ZOOM; z++) {  
        assertEquals(0x0400000020000001L, longEncode(stringEncode(longEncode(13, -89, 1))));
        assertStrCodec(0x0400000020000000L, "1/1/0", 1);  
/*  
                    long hashAsLong2 = longEncode(point.lon(), point.lat(), p);  
        assertStrCodec(0x0400000020000001L, "1/1/1", 1);
        assertEquals(0x0400000020000001L, longEncode(13, -95, 1));
 * this file be licensed under the Apache-2.0 license or a
    }  
 * SPDX-License-Identifier: Apache-2.0
        assertStrCodec(0x740000BA7FFFFFFFL, "29/1491/536870911", 29);  
        expectThrows(IllegalArgumentException.class, () -> longEncode(-1, 0, MAX_ZOOM + 1));
    /**
        int yTile = randomIntBetween(0, zoom);
/*  
 * Licensed to Elasticsearch under one or more contributor  
    private static final double GEOTILE_TOLERANCE = 1E-5D;
            final int zoom = z;
        }
        int zoom = randomIntBetween(0, MAX_ZOOM);
        assertEquals(0x0800000040000001L, longEncode(stringEncode(longEncode(1, 1, 2))));
        }
                }
 * this work for additional information regarding copyright
    /**
import static org.hamcrest.Matchers.closeTo;
                }
        assertEquals(0x3C00095540001CA5L, longEncode(30, 70, 15));  
        assertEquals(0x140000024000000EL, longEncode(stringEncode(longEncode(-328.231870, 16.064082, 5))));
        // noinspection ConstantConditions
        }  
     * Mercator projection does not show anything above 85 or below -85,  
    }  
        expectThrows(IllegalArgumentException.class, () -> stringEncode(0x0000000020000000L)); // z=0,x=1,y=0  
                    GeoPoint point = keyToGeoPoint(expectedTileIndex);
                    GeoPoint point = hashToGeoPoint(hash);
    public void testGeoTileAsLongRoutines() {
        double clippedLat = Math.min(Math.max(lat, minLat), maxLat);
        assertEquals(0x0C00000060000000L, longEncode(stringEncode(longEncode(-20, 100, 3))));
        assertThat(GeoTileUtils.getYTile(rectangle.getMinY(), tiles), anyOf(equalTo(yTile + 1), equalTo(yTile)));
     */
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint((MAX_ZOOM + 1) + "/0/0"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("a"));
        assertEquals(0x77FFFF4580000000L, longEncode(179.999, 89.999, 29));
        int zoom = randomIntBetween(0, MAX_ZOOM);  
        assertEquals(0x0400000020000001L, longEncode(13, -89, 1));  
        assertThat(ex.getMessage(), containsString("Invalid geotile_grid precision of -1. Must be between 0 and 29."));
        ex = expectThrows(IllegalArgumentException.class, () -> checkPrecisionRange(30));  
        assertStrCodec(0x77FFFF4580000000L, "29/536869420/0", 29);
                    // Same point should be generated from the string key  
 * software distributed under the License is distributed on an
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.stringEncode;
        assertEquals(0x4C0077776003A9ACL, longEncode(-12, 15, 19));  
    }
 * ownership. Elasticsearch licenses this file to you under  
    public void testPointToTile() {  
        assertEquals(0x77CF880A20000000L, longEncode(-557.039740, -632.103969, 29));
        assertStrCodec(0x0000000000000000L, "0/0/0", 0);  
            assertEquals(i, checkPrecisionRange(i));
        final GeoPoint gp = keyToGeoPoint(key);
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.checkPrecisionRange;
    }
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/0/a"));
 *
     * Make sure the polar regions are handled properly.
 * under the License.  
     */
import org.opensearch.geometry.Rectangle;
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/-1/0"));
    }  
        int tiles = 1 << zoom;
        assertEquals(0x71127D27C8ACA67AL, longEncode(stringEncode(longEncode(13, -15, 28))));  
        assertEquals(0x0400000020000000L, longEncode(13, 89, 1));
            }
    }
     * Ensure that for all points at all supported precision levels that the long encoding of a geotile
                    // GeoPoint would be in the center of the bucket, thus must produce the same hash
        assertEquals(0x0800000040000001L, longEncode(1, 1, 2));  
 */
        assertEquals(0x6436F96B60000000L, longEncode(-590.769588, 89.549167, 25));
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("0/0/-1"));
        assertEquals(0x0000000000000000L, longEncode(stringEncode(longEncode(0, 0, 0))));  
        assertThat(GeoTileUtils.getYTile(y, tiles), equalTo(yTile));  
    public void testHashToGeoPoint() {
        assertGeoPointEquals(keyToGeoPoint("1/1/1"), 90.0, -66.51326044311186);
 *  
 * compatible open source license.
    }
        assertThat(GeoTileUtils.getXTile(rectangle.getMinX(), tiles), equalTo(xTile));
 * Unless required by applicable law or agreed to in writing,
    }  
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.hashToGeoPoint;
    /**
        double y = randomDoubleBetween(rectangle.getMinY(), rectangle.getMaxY(), false);
            for (double lng = -180; lng <= 180; lng++) {  
import static org.hamcrest.Matchers.anyOf;  
        assertEquals(0x740000BA7FFFFFFFL, longEncode(-179.999, -89.999, 29));
        assertStrCodec(0x4C0077776003A9ACL, "19/244667/240044", 19);
 *    http://www.apache.org/licenses/LICENSE-2.0
        expectThrows(IllegalArgumentException.class, () -> keyToGeoPoint("a/0/0"));  
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.longEncode;
        assertEquals(0x0400000020000000L, longEncode(stringEncode(longEncode(13, 95, 1))));
