    private static final String BASE_32_STRING = new String(BASE_32);
 * This differs from a morton encoded value which interleaves lat/lon (y/x).
            latitude = Math.nextDown(latitude);
    public static double latHeightInDegrees(int precision) {
    /** approximate height of geohash tile for a specific precision in degrees */
        if (level == 1) {
    /**
    private static long encodeLatLon(final double lat, final double lon) {
    // Below code is adapted from the spatial4j library (GeohashUtils.java) Apache 2.0 Licensed
            Point topRight = new Point(decodeLongitude(mortonHash), decodeLatitude(mortonHash));
            // in north/south direction
        int level = (int) geoHashLong & 15;
 * GitHub history for details.
            neighbors.add(getNeighbor(north, level, +1, 0));
 * <p>
        precisionToLonWidth[0] = 180 * 2;
        'u',
    }
        'v',
        'h',
     * @param dx      delta of the first grid coordinate (must be -1, 0 or +1)
            if (level < 0) {
        return addNeighborsAtLevel(geohash, geohash.length(), new ArrayList<CharSequence>(8));
        final long geohash = (interleaved << 4) | level;
    /**
    /** returns the latitude value from the string based geohash */
/**
     * @return GeoRect rectangle defining the bounding box
     * Encode to a geohash string from the geohash based long format
            return new Rectangle(bottomLeft.getX(), topRight.getX(), topRight.getY(), bottomLeft.getY());
            final int nx = ((level % 2) == 1) ? (x + dx) : (x + dy);
        return longEncode(hash, hash.length());
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Encode from geohash string to the geohash based long format (lon/lat interleaved, 4 least significant bits = level)
            b = (long) (BASE_32_STRING.indexOf(c));
        // Decoding the Geohash bit pattern to determine grid coordinates
        'd',
        for (int i = 1; i <= PRECISION; i++) {
            // it can be encoded here.
        String[] hashes = new String[BASE_32.length];
        final int lonEnc = encodeLongitude(lon) ^ 0x80000000;
 * Unless required by applicable law or agreed to in writing,
        precisionToLatHeight[0] = 90 * 2;
     * @return the given list
        neighbors.add(getNeighbor(geohash, level, -1, 0));
 */
 * this work for additional information regarding copyright
                throw new IllegalArgumentException("unsupported symbol [" + c + "] in geohash [" + hash + "]");
     * Computes the bounding box coordinates from a given geohash
    }
        }
        // convert to geohashlong
    /**
        return precisionToLonWidth[precision];
        } else {
        'k',
    private static final double LON_DECODE = 360.0D / (0x1L << BITS);
        String north = getNeighbor(geohash, level, 0, +1);
     */
    public static double decodeLatitude(final long hash) {
    private static final double[] precisionToLatHeight, precisionToLonWidth;
        'z' };
            // xLimit and YLimit must always be respectively 7 and 3
 * The geohash long format is represented as lon/lat (x/y) interleaved with the 4 least significant bits
 * license agreements. See the NOTICE file distributed with
    }
 */
    public static int encodeLatitude(double latitude) {
    }
            // define grid coordinates for next level
        return hashes;
    }
        } else {
     */
    /** Returns a {@link Point} instance from a geohash string */
            neighbors.add(south);
        for (int i = 0; i < BASE_32.length; i++) {// note: already sorted
            }
        int level = 11;
        for (char c : hash.toCharArray()) {
     */
    /** encode latitude to integer */
        'j',
    private static double unscaleLon(final long val) {
    public static double decodeLongitude(final long hash) {
        if (north != null) {
        return BitUtil.interleave(latEnc, lonEnc) >>> 2;
        long b;
     */
        return BASE_32[((x & 1) + ((y & 1) * 2) + ((x & 2) * 2) + ((y & 2) * 4) + ((x & 4) * 4)) % 32];
     * Calculate all neighbors of a given geohash cell.
    public static final <E extends Collection<? super String>> E addNeighbors(String geohash, E neighbors) {
    private static final double LAT_SCALE = (0x1L << (BITS - 1)) / 180.0D;
        for (char c : hash.toCharArray()) {
    public static final String stringEncode(long geoHashLong) {
     *
            char c = BASE_32[i];
            neighbors.add(getNeighbor(south, level, +1, 0));
        long interleaved = encodeLatLon(lat, lon);
            // if the defined neighbor has the same parent a the current cell
        '4',
        int x2 = cell & 16; // third bit of x
    private static char encodeBase32(int x, int y) {
            // cell recursively. Since encoding wraps around within a cell
 * The OpenSearch Contributors require contributions made to
    /**
        if (latitude == 90.0D) {
     * @param level    level of the given geohash
    }
    /**
        return ((encodeLatLon(lat, lon) >>> msf) << 4) | level;
        '0',
        'x',
                // We cannot handle more than 12 levels
        return (int) Math.floor(latitude / LAT_DECODE);
        if (lat < MAX_LAT_BITS) {
 * Modifications Copyright OpenSearch Contributors. See
        int x1 = cell & 4;  // second bit of x
        'p',
        '6',
        '5',
import java.util.Collection;
    }
        }
    }
     */
    public static Collection<? extends CharSequence> getNeighbors(String geohash) {
     *
 */
 * representing the level (1-12) [xyxy...xyxyllll]
    }
        return new String(chars);
            // add 1 to lon to get lon of topRight, we are going to use 90 for lat
            }
            final long mortonHash = BitUtil.flipFlop((ghLong >>> 4) << shift);
            b = (long) (BASE_32_STRING.indexOf(c));
public class Geohash {
    }
        return (val / LON_SCALE) - 180;
    /** Bit encoded representation of the latitude of north pole */
    }
            // encode the cell directly. Otherwise find the cell next to this
 * the Apache License, Version 2.0 (the "License"); you may
    }
/*
    /**
 * compatible open source license.
    /** returns the latitude value from the string based geohash */
        Point bottomLeft = toPoint(geohash);
        '7',
     * @return geohash of the defined cell
                break;
 * <p>
        'r',
        return new Point(decodeLongitude(hash), decodeLatitude(hash));
    public static final String getNeighbor(String geohash, int level, int dx, int dy) {
    }
 * this file be licensed under the Apache-2.0 license or a
        if (longitude == 180.0D) {
     * @param geohash   Geohash of a specified cell
     * Encode to a geohash string from full resolution longitude, latitude)
     *
            final int ny = ((level % 2) == 1) ? (y + dy) : (y + dx);
    }
    public static int encodeLongitude(double longitude) {
            neighbors.add(north);
            if ((dy < 0 && y == 0) || (dy > 0 && y == 3)) {
        return stringEncode(geohash);
        precisionToLonWidth = new double[PRECISION + 1];
import org.opensearch.geometry.Rectangle;
 * Licensed to Elasticsearch under one or more contributor
            hashes[i] = baseGeohash + c;
        long lat = BitUtil.deinterleave(ghLong);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    }
            // south (namely "0145hjnp") do not have neighbors
        final int latEnc = encodeLatitude(lat) ^ 0x80000000;
 * under the License.
 * software distributed under the License is distributed on an
    /**
    /** base32 encode at the given grid coordinate */
            ghLong = BitUtil.interleave((int) (lat + 1), (int) (lon + 1)) << 4 | len;
        '1',
    /**
     * @param geohash the geohash of a cell
            } else {
     * Encode a string geohash to the geohash based long format (lon/lat interleaved, 4 least significant bits = level)
    /**
     * Calculate the geohash of a neighbor of a geohash
        'q',
            return new Rectangle(bottomLeft.getX(), topRight.getX(), 90D, bottomLeft.getY());
     * @param geohash Geohash of the defined cell
    public static final <E extends Collection<? super String>> E addNeighborsAtLevel(String geohash, int level, E neighbors) {
    public static Point toPoint(final String geohash) throws IllegalArgumentException {
            longitude = Math.nextDown(longitude);
            l |= (b << (level-- * 5));
            even = !even;
    public static final int PRECISION = 12;
            l |= (b << ((level-- * 5) + (MORTON_OFFSET - 2)));
     * @param level   level of the geohash
        long b;
        long ghLong = longEncode(geohash, len);
        precisionToLatHeight = new double[PRECISION + 1];
    }
    public static final double decodeLatitude(final String geohash) {
    /** encode longitude to integer */
        return (l << 4) | length;
    private static final char[] BASE_32 = {
        'n',
    // no instance:
 * Utilities for converting to/from the GeoHash standard
            chars[--level] = BASE_32[(int) (geoHashLong & 31L)];
    public static double lonWidthInDegrees(int precision) {
        // encode lat/lon flipping the sign bit so negative ints sort before positive ints
     * @param geohash   Geohash of a specified cell
    }
        return stringEncode(lon, lat, 12);
    public static long mortonEncode(final String hash) {
 * ownership. Elasticsearch licenses this file to you under
        interleaved >>>= (((PRECISION - level) * 5) + (MORTON_OFFSET - 2));
        int x = x0 + (x1 / 2) + (x2 / 4);
 *
    public static final String stringEncode(final double lon, final double lat) {
    }
        }
    public static final double decodeLongitude(final String geohash) {
    /** approximate width of geohash tile for a specific precision in degrees */
     */
        't',
            if (b < 0) {
            if (nx >= 0 && nx <= 7 && ny >= 0 && ny <= 3) {
    /**
        ghLong >>>= 4;
        // shift away the level
        final int shift = (12 - len) * 5 + 2;
                return null;
        }
import org.opensearch.geometry.Point;
    static {
        int y0 = cell & 2;  // first bit of y
        return neighbors;
     * @param dy      delta of the second grid coordinate (must be -1, 0 or +1)
        }
                return (neighbor != null) ? neighbor + encodeBase32(nx, ny) : neighbor;
            }
    public static Rectangle toBoundingBox(final String geohash) {
     * Add all geohashes of the cells next to a given geohash to a list.
        'y',
                return Character.toString(encodeBase32(x + dx, y + dy));
/*
            }
    /** maximum precision for geohash strings */
        'e',
        'c',
        's',
        return addNeighborsAtLevel(geohash, geohash.length(), neighbors);
        return (int) Math.floor(longitude / LON_DECODE);
    /**
    public static final String stringEncode(final double lon, final double lat, final int level) {
            }
package org.opensearch.geometry.utils;
        '8',
            } else {
    }
 *
        final long hash = mortonEncode(geohash);
    }
        final short msf = (short) (((12 - level) * 5) + (MORTON_OFFSET - 2));
}
     */
            // since x and y semantics are swapping on each level.
            precisionToLatHeight[i] = precisionToLatHeight[i - 1] / (even ? 8 : 4);
                String neighbor = getNeighbor(geohash, level - 1, dx, dy);
    private Geohash() {}
    }
    private static final double LON_SCALE = (0x1L << (BITS - 1)) / 360.0D;
        'm',
            neighbors.add(getNeighbor(north, level, -1, 0));
     * @param neighbors list to add the neighbors to
            ghLong = BitUtil.interleave((int) lat, (int) (lon + 1)) << 4 | len;
        '2',
        // the maximum possible value cannot be encoded without overflow
        int y = (y0 / 2) + (y1 / 4);
 */
        return unscaleLat(BitUtil.deinterleave(hash >>> 1));
        'w',
        return unscaleLon(BitUtil.deinterleave(hash));
        // the maximum possible value cannot be encoded without overflow
     */
            // add 1 to lat and lon to get topRight
        int len = Math.min(12, geohash.length());
    /** Array of geohashes one level below the baseGeohash. Sorted. */
        } while (level > 0);
     */
 *
        return BitUtil.flipFlop(l);
        int y1 = cell & 8;  // second bit of y
    }
        'g',
        int cell = BASE_32_STRING.indexOf(geohash.charAt(level - 1));
     * Encode to a morton long value from a given geohash string
    private static final long MAX_LAT_BITS = (0x1L << (PRECISION * 5 / 2)) - 1;
        do {
    /** decode longitude value from morton encoded geo point */
     * Add all geohashes of the cells next to a given geohash to a list.
    }
 * KIND, either express or implied.  See the License for the
        // bottom left is the coordinate
    /**
     *
 * You may obtain a copy of the License at
            if (level < 0) {
        long l = 0L;
     */
    }
    }
        return precisionToLatHeight[precision];
        // on each level
        // note that the semantics of x and y are swapping
    public static final long longEncode(final double lon, final double lat, final int level) {
            geoHashLong >>>= 5;
     * @return the given list
        neighbors.add(getNeighbor(geohash, level, +1, 0));
     *
/*
    private static double unscaleLat(final long val) {
    private static final short MORTON_OFFSET = (BITS << 1) - (PRECISION * 5);
        }
        int x0 = cell & 1;  // first bit of x
    private static final short BITS = 32;
     * Encode to a level specific geohash string from full resolution longitude, latitude
 * SPDX-License-Identifier: Apache-2.0
    private static final double LAT_DECODE = 180.0D / (0x1L << BITS);
 * NOTE: this will replace {@code org.opensearch.common.geo.GeoHashUtils}
     * @param neighbors list to add the neighbors to
        int level = length - 1;
                return geohash.substring(0, level - 1) + encodeBase32(nx, ny);
        if (hash.isEmpty()) {
    public static final long longEncode(String hash) {
            Point topRight = new Point(decodeLongitude(mortonHash), decodeLatitude(mortonHash));
        String south = getNeighbor(geohash, level, 0, -1);
import java.util.ArrayList;
        }
        '3',
        // combine the bitpattern to grid coordinates.
        'b',
    /** decode latitude value from morton encoded geo point */
            // We cannot go north of north pole, so just using 90 degrees instead of calculating it using
        long l = 0L;
    }
        }
        }
        boolean even = false;
                break;
    /** number of bits used for quantizing latitude and longitude values */
     * @param geohash Geohash of the defined cell
        'f',
        // shift to appropriate level
 * specific language governing permissions and limitations
     */
        '9',
     * Encode lon/lat to the geohash based long format (lon/lat interleaved, 4 least significant bits = level)
        // deinterleave
            final long mortonHash = BitUtil.flipFlop((ghLong >>> 4) << shift);
        }
        long lon = BitUtil.deinterleave(ghLong >>> 1);
        return (val / LAT_SCALE) - 90;
     */
 * <p>
            // Root cells at north (namely "bcfguvyz") or at
            throw new IllegalArgumentException("empty geohash");
        geoHashLong >>>= 4;
        return decodeLatitude(Geohash.mortonEncode(geohash));
     * @return geohashes of all neighbor cells
    public static String[] getSubGeohashes(String baseGeohash) {
 * not use this file except in compliance with the License.
            neighbors.add(getNeighbor(south, level, -1, 0));
        }
            precisionToLonWidth[i] = precisionToLonWidth[i - 1] / (even ? 4 : 8);
        if (south != null) {
    private static long longEncode(final String hash, int length) {
        return decodeLongitude(Geohash.mortonEncode(geohash));
                // We cannot handle more than 12 levels
        char[] chars = new char[level];
