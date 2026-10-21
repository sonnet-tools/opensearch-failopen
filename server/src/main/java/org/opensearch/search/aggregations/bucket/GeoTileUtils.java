        int xTile = (int) Math.floor((normalizeLon(longitude) + 180) / 360 * tiles);
        final double n = Math.PI - (2.0 * Math.PI * (yTile + 0.5)) / tiles;
            return (int) tiles - 1;
     */
    }
 * Licensed to Elasticsearch under one or more contributor
        int minYTile = getYTile(boundingRectangle.getMaxY(), totalTilesAtPrecision);
 * Modifications Copyright OpenSearch Contributors. See
        if (yTile >= tiles) {
        int[] res = parseHash(hash);
import org.opensearch.common.util.OpenSearchSloppyMath;
import org.apache.lucene.geo.GeoEncodingUtils;
        for (int x = minXTile; x <= maxXTile; x++) {
                "Invalid geotile_grid hash string of " + hashAsString + ". Must be three integers in a form \"zoom/x/y\"."
     * Since shapes are encoded, their boundaries are to be compared to against the encoded/decoded values of <code>LATITUDE_MASK</code>
        int[] parsed = parseHash(hashAsString);
        if (xTile >= tiles) {
        }
        }
     *
     * @return long encoded value of the given string hash
     */
        // as tuples in tiles are x,y and y(lat) increases from north to south in tiles, so for minYTile we need to
 * @opensearch.internal
}
        // Zoom value is placed in front of all the bits used for the geotile
     * E.g. hash lng=140.74779717298918D lat=45.61884022447444D == "18/233561/93659", but shown as "18/233561/93658"
        return stringEncode(longEncode(longitude, latitude, precision));
     *
    }
        // Mathematics for this code was adapted from https://wiki.openstreetmap.org/wiki/Slippy_map_tilenames#Java
        }
                "Invalid geotile_grid precision of " + precision + ". Must be between 0 and " + MAX_ZOOM + "."
        if (xTile < 0 || yTile < 0 || xTile >= tiles || yTile >= tiles) {
        // For example, polar regions (above/below lat 85.05112878) get normalized.
    public static String stringEncode(double longitude, double latitude, int precision) {
     */
     * the number of tile rows for pre-determined zoom-level.
     * Note that changing this value will make serialization binary-incompatible between versions.
            return (int) tiles - 1;
    /**
    private static int[] parseHash(String hashAsString) {
        int minXTile = getXTile(boundingRectangle.getMinX(), totalTilesAtPrecision);
     */
import org.apache.lucene.util.SloppyMath;
     * Parse an integer precision (zoom level). The {@link ValueType#INT} allows it to be a number or a string.
        final double minY = Math.toDegrees(OpenSearchSloppyMath.atan(OpenSearchSloppyMath.sinh(minN)));
    /**
     * Encode to a geotile string from the geotile based long format
public final class GeoTileUtils {
 * KIND, either express or implied.  See the License for the
        final long tiles = 1 << checkPrecisionRange(precision);
        long xTile = getXTile(longitude, tiles);
        final long totalTilesAtPrecision = 1L << checkPrecisionRange(precision);
        // leaving 5 bits unused for zoom. See MAX_ZOOM comment above.
        return (precision << ZOOM_SHIFT) | (xTile << MAX_ZOOM) | yTile;
    public static int checkPrecisionRange(int precision) {
            }
        // leaving 5 bits unused for zoom. See MAX_ZOOM comment above.
    public static String stringEncode(long hash) {
 * specific language governing permissions and limitations
     * Validates Zoom, X, and Y values, and returns the total number of allowed tiles along the x/y axis.
        final double minN = Math.PI - (2.0 * Math.PI * (yTile + 1)) / tiles;
        int[] hashAsInts = parseHash(hash);
        final int tiles = validateZXY(zoom, xTile, yTile);
        int[] hashAsInts = parseHash(hashAsString);
        }
    /**
        }
     * Parse geotile String hash format in "zoom/x/y" into an array of integers
     * @return int representing precision
        return encodedValues;
        int[] res = parseHash(hash);
     * the number of tile columns for a pre-determined zoom-level.
                    encodedValues.add(encodedValue);
     * If zoom is not stored inside hash, it would be possible to use up to 32.
    /**
        long yTile = getYTile(latitude, tiles);
    public static Rectangle toBoundingBox(int xTile, int yTile, int precision) {
     * The function encodes the shape provided as {@link GeoShapeDocValue} to a {@link List} of {@link Long} values
     * @param tiles     the number of tiles per column for a pre-determined zoom-level
    }
            return new int[] { Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]) };
        final List<Long> encodedValues = new ArrayList<>();
                }
            throw new IllegalArgumentException(
     */
     * Encode lon/lat to the geotile based long format.
        final int xTile = (int) ((hash >>> MAX_ZOOM) & X_Y_VALUE_MASK);
        if (precision < 0 || precision > MAX_ZOOM) {
 * Implements geotile key hashing, same as used by many map tile implementations.
    /**
        double latSin = SloppyMath.cos(PI_DIV_2 - Math.toRadians(normalizeLat(latitude)));
            );
 * under the License.
     *
        int maxXTile = getXTile(boundingRectangle.getMaxX(), totalTilesAtPrecision);
     */
     * Calculates the y-coordinate in the tile grid for the specified longitude given
 */
import static org.opensearch.common.geo.GeoUtils.normalizeLat;
    /**
    public static final double LATITUDE_MASK = 85.0511287798066;
     * Bit position of the zoom value within hash - zoom is stored in the most significant 6 bits of a long number.
        final double maxX = ((xTile + 1) / tiles * 360.0) - 180;
                // Convert encoded value to rectangle
     * Largest number of tiles (precision) to use.
    }
 * not use this file except in compliance with the License.
 * The string key is formatted as  "zoom/x/y"
 */
     * @return {@link List} of {@link Long}
/*
    }
    /**
    public static int getYTile(double latitude, long tiles) {
                if (geoShapeDocValue.isIntersectingRectangle(tileRectangle)) {
        validateZXY(res[0], res[1], res[2]);
    public static Rectangle toBoundingBox(long hash) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.search.aggregations.bucket;
            throw new IllegalArgumentException(
        final double lon = ((xTile + 0.5) / tiles * 360.0) - 180;
        return yTile;
        return zxyToGeoPoint(hashAsInts[0], hashAsInts[1], hashAsInts[2]);
    }
import org.opensearch.common.geo.GeoShapeDocValue;
    }
        }
     * This value cannot be more than (64-5)/2 = 29, because 5 bits are used for zoom level itself (0-31)
     *
        // Zoom value is placed in front of all the bits used for the geotile
        if (yTile < 0) {
                // Convert the precision, x , y to encoded value.
    }
        final double maxY = Math.toDegrees(OpenSearchSloppyMath.atan(OpenSearchSloppyMath.sinh(maxN)));
     */
 * The hash value (long) contains all three of those values compacted into a single 64bit value:
    private static final int ZOOM_SHIFT = MAX_ZOOM * 2;
        return precision;
                long encodedValue = longEncodeTiles(precision, x, y);
            : parser.text();
 *   bits  0..28 -- Y tile index (0..2^zoom)
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
     * @param precision int
        return longEncodeTiles(precision, xTile, yTile);
    public static GeoPoint hashToGeoPoint(long hash) {
    }
        final int yTile = (int) (hash & X_Y_VALUE_MASK);
    }
import org.opensearch.OpenSearchParseException;
import java.util.ArrayList;
        return zxyToGeoPoint(res[0], res[1], res[2]);
    }
        final int tiles = 1 << checkPrecisionRange(zoom);
    private static final double PI_DIV_2 = Math.PI / 2;
    }
    /**
     * Decode a string bucket key in "zoom/x/y" format to a GeoPoint (center of the tile)
        return tiles;
            );
     */
            return 0;
                String.format(Locale.ROOT, "Zoom/X/Y combination is not valid: %d/%d/%d", zoom, xTile, yTile)
 *   bits 58..63 -- zoom (0..29)
     */
        return new GeoPoint(lat, lon);
    public static long longEncode(double longitude, double latitude, int precision) {
        try {
        if (parts.length != 3) {
    /**
        return longEncode((long) parsed[0], (long) parsed[1], (long) parsed[2]);
    /**
     * Encode lon/lat to the geotile based string format which is "zoom/x/y"
        final String[] parts = hashAsString.split("/", 4);
        GeoEncodingUtils.encodeLatitude(-LATITUDE_MASK)
 *
import org.opensearch.common.geo.GeoPoint;
     * (representing the GeoTiles) which are intersecting with the shapes at a given precision.
        // Number of tiles for the current zoom level along the X and Y axis
        return ((long) precision << ZOOM_SHIFT) | (xTile << MAX_ZOOM) | yTile;
     */
    private static int[] parseHash(long hash) {
    /**
    /**
     */
        return XContentMapValues.nodeIntegerValue(node);
    }
        }
            ? Integer.valueOf(parser.intValue())
    }
            throw new IllegalArgumentException(
 *   bits 29..57 -- X tile index (0..2^zoom)
import org.opensearch.core.xcontent.ObjectParser.ValueType;
 * You may obtain a copy of the License at
    public static final int MAX_ZOOM = 29;
        final Object node = parser.currentToken().equals(XContentParser.Token.VALUE_NUMBER)
        final GeoShapeDocValue.BoundingRectangle boundingRectangle = geoShapeDocValue.getBoundingRectangle();
     * Encode a geotile hash style string to a long.
     * The geo-tile map is clipped at 85.05112878 to 90 and -85.05112878 to -90
     * The precision is expressed as a zoom level between 0 and {@link #MAX_ZOOM} (inclusive).
     * Decode a string bucket key in "zoom/x/y" format to a bounding box of the tile corners
    public static GeoPoint keyToGeoPoint(String hashAsString) {
     * <p>
    /**
        }
    /**
        // normalizeLon treats this as 180, which is not friendly for tile mapping
     * @param latitude  the latitude to use when determining the tile y-coordinate
     * The precision itself is also encoded as a few high bits.
        return xTile;
    }
     * The resulting hash contains interleaved tile X and Y coordinates.
import java.io.IOException;
    private static long longEncode(long precision, long xTile, long yTile) {
import java.util.List;
import java.util.Locale;
     */
    }
    private static final long X_Y_VALUE_MASK = (1L << MAX_ZOOM) - 1;
     * Another consideration is that index optimizes lat/lng storage, loosing some precision.
                // check to see if the GeoShape is intersecting with the rectangle.
        if (longitude == -180) {
 * ownership. Elasticsearch licenses this file to you under
     */
        final double lat = Math.toDegrees(OpenSearchSloppyMath.atan(OpenSearchSloppyMath.sinh(n)));
        final double tiles = validateZXY(precision, xTile, yTile);
     *
 * The OpenSearch Contributors require contributions made to
    );
        // e.g. when max zoom is 29, the largest index would use 58 bits (57th..0th),
    public static long longEncode(String hashAsString) {
 * software distributed under the License is distributed on an
    public static Rectangle toBoundingBox(String hash) {
import static org.opensearch.common.geo.GeoUtils.normalizeLon;
        final int zoom = (int) (hash >>> ZOOM_SHIFT);
    /**
 * this work for additional information regarding copyright
        // Edge values may generate invalid values, and need to be clipped.
 * compatible open source license.
    private GeoTileUtils() {}
 *
        }
            yTile = 0;
     * Parse geotile hash as zoom, x, y integers.
        if (xTile < 0) {
                e
/*
     */
    public static final double NORMALIZED_NEGATIVE_LATITUDE_MASK = GeoEncodingUtils.decodeLatitude(
     */
 *
    /**
     * @param longitude the longitude to use when determining the tile x-coordinate
        int maxYTile = getYTile(boundingRectangle.getMinY(), totalTilesAtPrecision);
     * @param hashAsString String in format "zoom/x/y"
        // generate all the grid long values that this shape intersects.
        return toBoundingBox(hashAsInts[1], hashAsInts[2], hashAsInts[0]);
     * Converts zoom/x/y integers into a GeoPoint.
    /**
                final Rectangle tileRectangle = toBoundingBox(encodedValue);
     * @param geoShapeDocValue {@link GeoShapeDocValue}
    private static GeoPoint zxyToGeoPoint(int zoom, int xTile, int yTile) {
        // e.g. when max zoom is 29, the largest index would use 58 bits (57th..0th),
/**
    public static int getXTile(double longitude, long tiles) {
        int[] hashAsInts = parseHash(hash);
        }
        final double minX = ((xTile) / tiles * 360.0) - 180;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentParser;
        // take maxY and for maxYTile we need to take minY.
     * Assert the precision value is within the allowed range, and return it if ok, or throw.
    public static List<Long> encodeShape(final GeoShapeDocValue geoShapeDocValue, final int precision) {
 */
            throw new IllegalArgumentException(
     */
import org.opensearch.geometry.Rectangle;
                "Invalid geotile_grid hash string of " + hashAsString + ". Must be three integers in a form \"zoom/x/y\".",
     */
    public static int parsePrecision(XContentParser parser) throws IOException, OpenSearchParseException {
    }
     * Decode long hash as a GeoPoint (center of the tile)
            );
     * Calculates the x-coordinate in the tile grid for the specified longitude given
    }
 */
     */
 * SPDX-License-Identifier: Apache-2.0
        return toBoundingBox(hashAsInts[1], hashAsInts[2], hashAsInts[0]);
        return new int[] { zoom, xTile, yTile };
    private static int validateZXY(int zoom, int xTile, int yTile) {
        final double maxN = Math.PI - (2.0 * Math.PI * (yTile)) / tiles;
     * @param parser {@link XContentParser} to parse the value from
        return "" + res[0] + "/" + res[1] + "/" + res[2];
     */
            return 0;
        return new Rectangle(minX, maxX, maxY, minY);
     */
 *
     * @param tiles     the number of tiles per row for a pre-determined zoom-level
 * this file be licensed under the Apache-2.0 license or a
    }
        } catch (NumberFormatException e) {
/*
    /**
            for (int y = minYTile; y <= maxYTile; y++) {
     * Bit mask to extract just the lowest 29 bits of a long
    public static final double NORMALIZED_LATITUDE_MASK = GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(LATITUDE_MASK));
    /**
     */
            );
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.xcontent.support.XContentMapValues;
    /**
    public static long longEncodeTiles(int precision, long xTile, long yTile) {
        int yTile = (int) Math.floor((0.5 - (Math.log((1 + latSin) / (1 - latSin)) / (4 * Math.PI))) * tiles);
    /**
