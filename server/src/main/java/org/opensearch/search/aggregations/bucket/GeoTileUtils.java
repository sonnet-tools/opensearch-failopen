    /**
 */
     * @param precision int
    private static final double PI_DIV_2 = Math.PI / 2;  
 * Licensed to Elasticsearch under one or more contributor  
    /**
        final double maxY = Math.toDegrees(OpenSearchSloppyMath.atan(OpenSearchSloppyMath.sinh(maxN)));  
     * Decode a string bucket key in "zoom/x/y" format to a bounding box of the tile corners
 * The hash value (long) contains all three of those values compacted into a single 64bit value:
            );
    public static long longEncode(double longitude, double latitude, int precision) {
            );  
     * The geo-tile map is clipped at 85.05112878 to 90 and -85.05112878 to -90
        if (xTile < 0) {
            return 0;
import java.io.IOException;
        long xTile = getXTile(longitude, tiles);
        return encodedValues;  
     *
        final int tiles = validateZXY(zoom, xTile, yTile);
            throw new IllegalArgumentException(
 * The OpenSearch Contributors require contributions made to  
        int minXTile = getXTile(boundingRectangle.getMinX(), totalTilesAtPrecision);  
        }  
        int xTile = (int) Math.floor((normalizeLon(longitude) + 180) / 360 * tiles);  
        // Mathematics for this code was adapted from https://wiki.openstreetmap.org/wiki/Slippy_map_tilenames#Java
    /**  
                // check to see if the GeoShape is intersecting with the rectangle.  
        return "" + res[0] + "/" + res[1] + "/" + res[2];
 * Implements geotile key hashing, same as used by many map tile implementations.
     * Largest number of tiles (precision) to use.  
    }
 * this work for additional information regarding copyright
 *  
        // normalizeLon treats this as 180, which is not friendly for tile mapping
 * Unless required by applicable law or agreed to in writing,
     * @param geoShapeDocValue {@link GeoShapeDocValue}  
     * This value cannot be more than (64-5)/2 = 29, because 5 bits are used for zoom level itself (0-31)
    public static long longEncode(String hashAsString) {
        final long totalTilesAtPrecision = 1L << checkPrecisionRange(precision);
        // leaving 5 bits unused for zoom. See MAX_ZOOM comment above.  
     * Validates Zoom, X, and Y values, and returns the total number of allowed tiles along the x/y axis.
    /**
    }
    /**  
        // e.g. when max zoom is 29, the largest index would use 58 bits (57th..0th),
            yTile = 0;
    }
 *   bits 29..57 -- X tile index (0..2^zoom)  
     */  
        final double minX = ((xTile) / tiles * 360.0) - 180;
    );
 */  
 *
     * Converts zoom/x/y integers into a GeoPoint.
    public static GeoPoint keyToGeoPoint(String hashAsString) {
    }
 * under the License.  
 * GitHub history for details.
import org.opensearch.common.xcontent.support.XContentMapValues;  
 * specific language governing permissions and limitations
    }
        return longEncode((long) parsed[0], (long) parsed[1], (long) parsed[2]);  
    }  
     */
 * compatible open source license.
        return zxyToGeoPoint(res[0], res[1], res[2]);
            throw new IllegalArgumentException(  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
                final Rectangle tileRectangle = toBoundingBox(encodedValue);
     */
            return 0;  
            : parser.text();
        double latSin = SloppyMath.cos(PI_DIV_2 - Math.toRadians(normalizeLat(latitude)));
    private GeoTileUtils() {}
     * Parse geotile hash as zoom, x, y integers.
import org.apache.lucene.geo.GeoEncodingUtils;  
     * (representing the GeoTiles) which are intersecting with the shapes at a given precision.
        // Number of tiles for the current zoom level along the X and Y axis  
                if (geoShapeDocValue.isIntersectingRectangle(tileRectangle)) {
     * E.g. hash lng=140.74779717298918D lat=45.61884022447444D == "18/233561/93659", but shown as "18/233561/93658"
import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
 */
    }
        // take maxY and for maxYTile we need to take minY.
     * Parse an integer precision (zoom level). The {@link ValueType#INT} allows it to be a number or a string.  
    /**
     * @param tiles     the number of tiles per column for a pre-determined zoom-level
     * Decode long hash as a GeoPoint (center of the tile)
                "Invalid geotile_grid precision of " + precision + ". Must be between 0 and " + MAX_ZOOM + "."
        int maxYTile = getYTile(boundingRectangle.getMinY(), totalTilesAtPrecision);
    private static int[] parseHash(long hash) {
            return new int[] { Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]) };
     * <p>
     * Bit position of the zoom value within hash - zoom is stored in the most significant 6 bits of a long number.
     * The resulting hash contains interleaved tile X and Y coordinates.
    /**  
        long yTile = getYTile(latitude, tiles);  
        return yTile;
    private static long longEncode(long precision, long xTile, long yTile) {
     * Assert the precision value is within the allowed range, and return it if ok, or throw.  
     * Encode lon/lat to the geotile based string format which is "zoom/x/y"  
        return new Rectangle(minX, maxX, maxY, minY);  
    }
}
import org.opensearch.common.geo.GeoShapeDocValue;
     * Calculates the x-coordinate in the tile grid for the specified longitude given  
        final double lat = Math.toDegrees(OpenSearchSloppyMath.atan(OpenSearchSloppyMath.sinh(n)));
     */  
 * @opensearch.internal  
     */
        final int yTile = (int) (hash & X_Y_VALUE_MASK);
        final String[] parts = hashAsString.split("/", 4);
/*
    }
    public static final double NORMALIZED_LATITUDE_MASK = GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(LATITUDE_MASK));
/*  
     * @param tiles     the number of tiles per row for a pre-determined zoom-level
        }
        }  
    }  
     * If zoom is not stored inside hash, it would be possible to use up to 32.
        // as tuples in tiles are x,y and y(lat) increases from north to south in tiles, so for minYTile we need to
        if (xTile < 0 || yTile < 0 || xTile >= tiles || yTile >= tiles) {
     * Decode a string bucket key in "zoom/x/y" format to a GeoPoint (center of the tile)  
                    encodedValues.add(encodedValue);
    public static GeoPoint hashToGeoPoint(long hash) {  
    }
     * The precision is expressed as a zoom level between 0 and {@link #MAX_ZOOM} (inclusive).
    public static long longEncodeTiles(int precision, long xTile, long yTile) {  
    public static Rectangle toBoundingBox(long hash) {
        int[] parsed = parseHash(hashAsString);
    public static Rectangle toBoundingBox(int xTile, int yTile, int precision) {  
    /**
        return xTile;
     * @param parser {@link XContentParser} to parse the value from
     * @return int representing precision
    /**
     */  
        final Object node = parser.currentToken().equals(XContentParser.Token.VALUE_NUMBER)
        // Zoom value is placed in front of all the bits used for the geotile  
     * @return {@link List} of {@link Long}
    public static final double LATITUDE_MASK = 85.0511287798066;  
    }  
    public static final int MAX_ZOOM = 29;
 *
     */
        if (longitude == -180) {
        }
        final int xTile = (int) ((hash >>> MAX_ZOOM) & X_Y_VALUE_MASK);  
        if (parts.length != 3) {
import org.apache.lucene.util.SloppyMath;
    /**  
    }  
     *
    }
        int[] hashAsInts = parseHash(hashAsString);  
    /**
import java.util.List;
import org.opensearch.geometry.Rectangle;  
import static org.opensearch.common.geo.GeoUtils.normalizeLon;
    }
import static org.opensearch.common.geo.GeoUtils.normalizeLat;
        final int zoom = (int) (hash >>> ZOOM_SHIFT);
     * Encode to a geotile string from the geotile based long format  
     */
            throw new IllegalArgumentException(  
        // For example, polar regions (above/below lat 85.05112878) get normalized.  
        // Edge values may generate invalid values, and need to be clipped.
            for (int y = minYTile; y <= maxYTile; y++) {
        return zxyToGeoPoint(hashAsInts[0], hashAsInts[1], hashAsInts[2]);
        }
    /**  
     * @param longitude the longitude to use when determining the tile x-coordinate  
     * Bit mask to extract just the lowest 29 bits of a long
    /**
        for (int x = minXTile; x <= maxXTile; x++) {  
                }  
        final double minY = Math.toDegrees(OpenSearchSloppyMath.atan(OpenSearchSloppyMath.sinh(minN)));
    /**
        final GeoShapeDocValue.BoundingRectangle boundingRectangle = geoShapeDocValue.getBoundingRectangle();
        }
        }  
        int minYTile = getYTile(boundingRectangle.getMaxY(), totalTilesAtPrecision);  
import java.util.Locale;
                e  
     * The function encodes the shape provided as {@link GeoShapeDocValue} to a {@link List} of {@link Long} values  
        final List<Long> encodedValues = new ArrayList<>();
    }  
        return (precision << ZOOM_SHIFT) | (xTile << MAX_ZOOM) | yTile;  
    /**
        return toBoundingBox(hashAsInts[1], hashAsInts[2], hashAsInts[0]);  
public final class GeoTileUtils {
 * license agreements. See the NOTICE file distributed with
     * @return long encoded value of the given string hash
import org.opensearch.common.util.OpenSearchSloppyMath;
        return XContentMapValues.nodeIntegerValue(node);
        return precision;
     */  
        int[] res = parseHash(hash);
     * @param latitude  the latitude to use when determining the tile y-coordinate  
import org.opensearch.core.xcontent.ObjectParser.ValueType;
        final double minN = Math.PI - (2.0 * Math.PI * (yTile + 1)) / tiles;
    }  
        int[] hashAsInts = parseHash(hash);
     */  
    public static int getXTile(double longitude, long tiles) {  
     */  
     */
            );
        final long tiles = 1 << checkPrecisionRange(precision);
    public static List<Long> encodeShape(final GeoShapeDocValue geoShapeDocValue, final int precision) {
        return longEncodeTiles(precision, xTile, yTile);
    private static int[] parseHash(String hashAsString) {  
     */
        final double maxX = ((xTile + 1) / tiles * 360.0) - 180;
        try {
        GeoEncodingUtils.encodeLatitude(-LATITUDE_MASK)
     *
    }  
        int[] res = parseHash(hash);  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
            ? Integer.valueOf(parser.intValue())  
     */  
     */
        int maxXTile = getXTile(boundingRectangle.getMaxX(), totalTilesAtPrecision);
     */
    public static int getYTile(double latitude, long tiles) {  
        final double maxN = Math.PI - (2.0 * Math.PI * (yTile)) / tiles;  
     */
    }  
     */
     * @param hashAsString String in format "zoom/x/y"
    /**  
import org.opensearch.common.geo.GeoPoint;  
                // Convert encoded value to rectangle
     */  
     * the number of tile rows for pre-determined zoom-level.
package org.opensearch.search.aggregations.bucket;
     *  
     * Another consideration is that index optimizes lat/lng storage, loosing some precision.
    /**
    /**
        if (xTile >= tiles) {
 *   bits 58..63 -- zoom (0..29)
        return ((long) precision << ZOOM_SHIFT) | (xTile << MAX_ZOOM) | yTile;
                // Convert the precision, x , y to encoded value.
        if (precision < 0 || precision > MAX_ZOOM) {  
                "Invalid geotile_grid hash string of " + hashAsString + ". Must be three integers in a form \"zoom/x/y\".",
/**
                "Invalid geotile_grid hash string of " + hashAsString + ". Must be three integers in a form \"zoom/x/y\"."
        return toBoundingBox(hashAsInts[1], hashAsInts[2], hashAsInts[0]);
            return (int) tiles - 1;
        if (yTile < 0) {
            return (int) tiles - 1;
        return tiles;
    public static final double NORMALIZED_NEGATIVE_LATITUDE_MASK = GeoEncodingUtils.decodeLatitude(  
        } catch (NumberFormatException e) {  
        // e.g. when max zoom is 29, the largest index would use 58 bits (57th..0th),
    /**
import org.opensearch.OpenSearchParseException;
    public static String stringEncode(long hash) {
    private static GeoPoint zxyToGeoPoint(int zoom, int xTile, int yTile) {
    public static Rectangle toBoundingBox(String hash) {  
    private static final long X_Y_VALUE_MASK = (1L << MAX_ZOOM) - 1;  
     * Parse geotile String hash format in "zoom/x/y" into an array of integers
     * Calculates the y-coordinate in the tile grid for the specified longitude given  
 */
 * not use this file except in compliance with the License.
        return new int[] { zoom, xTile, yTile };
/*
        final double n = Math.PI - (2.0 * Math.PI * (yTile + 0.5)) / tiles;  
     */
    /**
    }  
 *
        final int tiles = 1 << checkPrecisionRange(zoom);
 *   bits  0..28 -- Y tile index (0..2^zoom)
        // Zoom value is placed in front of all the bits used for the geotile
     * The precision itself is also encoded as a few high bits.
    public static int checkPrecisionRange(int precision) {
        int[] hashAsInts = parseHash(hash);
import java.util.ArrayList;  
            }
        }  
        final double lon = ((xTile + 0.5) / tiles * 360.0) - 180;
 * ownership. Elasticsearch licenses this file to you under  
        validateZXY(res[0], res[1], res[2]);
            );
     * Encode a geotile hash style string to a long.
    public static String stringEncode(double longitude, double latitude, int precision) {
        int yTile = (int) Math.floor((0.5 - (Math.log((1 + latSin) / (1 - latSin)) / (4 * Math.PI))) * tiles);
            throw new IllegalArgumentException(
        // generate all the grid long values that this shape intersects.  
        return stringEncode(longEncode(longitude, latitude, precision));  
     * the number of tile columns for a pre-determined zoom-level.
     * Encode lon/lat to the geotile based long format.  
    private static int validateZXY(int zoom, int xTile, int yTile) {  
        final double tiles = validateZXY(precision, xTile, yTile);
        }  
     * Note that changing this value will make serialization binary-incompatible between versions.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The string key is formatted as  "zoom/x/y"  
    public static int parsePrecision(XContentParser parser) throws IOException, OpenSearchParseException {
 * SPDX-License-Identifier: Apache-2.0
                String.format(Locale.ROOT, "Zoom/X/Y combination is not valid: %d/%d/%d", zoom, xTile, yTile)
        }  
 * this file be licensed under the Apache-2.0 license or a
    private static final int ZOOM_SHIFT = MAX_ZOOM * 2;
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
     *  
     * Since shapes are encoded, their boundaries are to be compared to against the encoded/decoded values of <code>LATITUDE_MASK</code>  
 * You may obtain a copy of the License at  
        if (yTile >= tiles) {
        // leaving 5 bits unused for zoom. See MAX_ZOOM comment above.
                long encodedValue = longEncodeTiles(precision, x, y);  
        return new GeoPoint(lat, lon);  
