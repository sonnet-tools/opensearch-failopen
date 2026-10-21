                lat = -180 - lat;
import org.opensearch.common.unit.DistanceUnit;
     * <p>
        return rtn;
        final GeoUtils.EffectivePoint effectivePoint
                try {
            }
        double x = Math.toRadians(lon2 - lon1) * Math.cos(Math.toRadians((lat2 + lat1) / 2.0d));
     * is outside the range.
     * @return levels need to achieve precision
    }
    public static double maxRadialDistanceMeters(final double centerLat, final double centerLon) {
     */
     * <p>
            final int bits = (int) Math.round(Math.ceil(Math.log(part) / Math.log(2)));
    }
                case VALUE_NUMBER:
            if (shift) {
        assert level >= 0;
package org.opensearch.common.geo;
        final boolean ignoreZValue,
    public static boolean isValidLatitude(double latitude) {
    }
        }
    /** Earth ellipsoid major axis defined by WGS 84 in meters */
                parser.nextToken();
            throw new IllegalArgumentException("Invalid geohash aggregation precision of " + precision + ". Must be between 1 and 12.");
 *
        final double h = geoHashCellHeight(level);
            if (subParser.nextToken() != XContentParser.Token.END_OBJECT) {
                lonLat[1] = -180 - lonLat[1];
        return lon + 0d;
        normalizePoint(point, true, true);
    /**
 * GitHub history for details.
    private static GeoPoint parseGeoHashFields(
    /** Earth mean radius defined by WGS 84 in meters */
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    public static GeoPoint parseGeoPoint(XContentParser parser, GeoPoint point) throws IOException, OpenSearchParseException {
     * For this purpose, you should call the
    }
     *     <li>Geohash form:: <pre>&quot;<i>&lt;geohash&gt;</i>&quot;</pre></li>
     * and k is meaningful to the application.
     * @return the size of cells at level in meters
    /**
        if (GEOHASH.equals(parser.currentName()) == false) {
     * @opensearch.internal
                parseGeoPointObject(parser, point, ignoreZValue, effectivePoint);
                if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) {
     * Parse a geopoint represented as an object, string or an array. If the geopoint is represented as a geohash,
                parseGeoPointArray(parser, point, ignoreZValue);
                final int parsedPrecision = GeoUtils.geoHashLevelsForPrecision(precision);
        return SloppyMath.haversinMeters(lat1, lon1, lat2, lon2);
                public double doubleValue() throws IOException {
        return quadTreeLevelsForPrecision(DistanceUnit.METERS.parse(distance, DistanceUnit.DEFAULT));
     * <p>
    }
    public static double geoHashCellHeight(int level) {
     * Parse a {@link GeoPoint} with a {@link XContentParser}:
                    lonLat[0] += normalizeLon(lonLat[0]) > 0 ? -180 : 180;
     * <ul>
     * @return The normalized longitude.
     * <p>
        if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
            )
        }
            parser.nextToken(); // start object
            }
 * specific language governing permissions and limitations
     * @param meters Maximum size of cells in meters (must greater or equal to zero)
     * @return the width of cells at level in meters
     * cells will not exceed the specified size (diagonal) of the precision.
     */
 * Useful geo utilities
        return point;
        assert meters >= 0;
    public static GeoPoint parseGeoPoint(Object value, final boolean ignoreZValue) throws OpenSearchParseException {
                hasCoordinates = true;
    /**
        return Math.sqrt(EARTH_POLAR_DISTANCE * EARTH_POLAR_DISTANCE + EARTH_EQUATOR * EARTH_EQUATOR) / (1L << level);
     * Calculate the height (in meters) of quadtree cells at a specific level
                @Override
     * in order to normalize properly the latitude.
     * <p>
     * add a shift of 180&deg; in the longitude.
            final double part = Math.ceil(EARTH_EQUATOR / width);
                    y = parser.doubleValue();
 * You may obtain a copy of the License at
            } else if (GEOJSON_COORDS.equals(parser.currentName())) {
     */
        }
            } else if (lat > 90) {
     * @param effectivePoint tells which point to use for GeoHash form
        try (XContentSubParser subParser = new XContentSubParser(parser)) {
        final double w = geoHashCellWidth(level);
    /**
     * Calculate the number of levels needed for a specific precision. Quadtree
     */
     * @return The normalized latitude.
            throw new OpenSearchParseException("error parsing geopoint", ex);
            case VALUE_STRING:
    public static final String WKT_BOUNDING_BOX_TYPE_ERROR = "failed to parse WKT bounding box. [%s] found. expected [%s]";
        return true;
            try {
    }
     *     <li>Latitude, Longitude form: <pre>&quot;<i>&lt;latitude&gt;</i>,<i>&lt;longitude&gt;</i>&quot;</pre></li>
     */
    /**
     *     <li>Object: <pre>{@code {"lat": <latitude>, "lon": <longitude}}</pre></li>
            case START_ARRAY:
}
    private static GeoPoint parseGeoPointObjectBasicFields(final XContentParser parser, final GeoPoint point) throws IOException {
     */
            return new SortingNumericDoubleValues() {
     * @param normLon Whether to normalize longitude.
     * @param parser {@link XContentParser} to parse the value from
            lat = centeredModulus(lat, 360);
    }
    /** Returns true if latitude is actually a valid latitude value.*/
                    if (geoPointValues.advanceExact(target)) {
            } else if (lonLat[1] > 90) {
     * @return new {@link GeoPoint} parsed from the parse
     * Calculate the number of levels needed for a specific precision. GeoHash
     *     <li>String: <pre>{@code "<latitude>,<longitude>"}</pre></li>
import org.opensearch.common.xcontent.support.XContentMapValues;
                public boolean advanceExact(int doc) throws IOException {
                    // Longitude won't be normalized,
            if (element < 2) {
            }
        return point;
    }
     */
                throw new OpenSearchParseException(ERR_MSG_INVALID_TOKEN, subParser.currentToken());
     * respective normalized ranges.
    public static final double EARTH_POLAR_DISTANCE = Math.PI * EARTH_SEMI_MINOR_AXIS;
    /** Returns the maximum distance/radius (in meters) from the point 'center' before overlapping */
    /** Earth ellipsoid equator length in meters */
                break;
     * for each document.
     */
    public static double geoHashCellSize(int level) {
        return point.parseGeoHash(parser.text(), effectivePoint);
     * Parses the value as a geopoint. The following types of values are supported:
                        throw new OpenSearchParseException("[{}] and [{}] must be valid double values", e, LONGITUDE, LATITUDE);
                parseGeoPointObjectBasicFields(subParser, point);
        for (int i = 0; i < 2; i++) {
                @Override
        if (Double.isNaN(longitude) || Double.isInfinite(longitude) || longitude < GeoUtils.MIN_LON || longitude > GeoUtils.MAX_LON) {
                String val = parser.text();
                if (hasTypePoint == false) {
            }
 * Licensed to Elasticsearch under one or more contributor
        final XContentParser parser,
    public static int quadTreeLevelsForPrecision(String distance) {
    }
        }
                if (element == 1) {
            if (subParser.nextToken() != XContentParser.Token.FIELD_NAME) {
            String field = subParser.currentName();
     * Therefore x will be adjusted while keeping k preserved.
     *
        boolean hasCoordinates = false;
    public static double quadTreeCellWidth(int level) {
     * @param level quadtree level must be greater or equal to zero
        TOP_LEFT,
     * <p>
            return false;
     * You can control which coordinate gets normalized with the two flags.
    public static int geoHashLevelsForPrecision(double meters) {
        } catch (IOException ex) {
    public static final String GEOHASH = "geohash";
                lat = 180 - lat;
 * ownership. Elasticsearch licenses this file to you under
    public static void normalizePoint(GeoPoint point) {
        }
    public static double planeDistance(double lat1, double lon1, double lat2, double lon2) {
    }
     * Parses the value as a geopoint. The following types of values are supported:
     * @return the size of cells at level in meters
     * Normalize the geo {@code Point} for its coordinates to lie within their
     * Note: You should not normalize longitude and latitude separately,
    /**
     */
            lonLat[0] = centeredModulus(lonLat[0], 360);
        return point.reset(data.get(LATITUDE), data.get(LONGITUDE));
     * Note: A shift of 180&deg; is applied in the longitude if necessary,
    public static final double EARTH_AXIS_RATIO = EARTH_SEMI_MINOR_AXIS / EARTH_SEMI_MAJOR_AXIS;
                    // by only changing x, assuming k is meaningful for the user application.
    /** Minimum valid longitude in degrees. */
    public enum EffectivePoint {
    public static final double MAX_LON = 180.0;
            final int level = Long.SIZE - Long.numberOfLeadingZeros(part) - 1; // (log_2)
                            final GeoPoint point = geoPointValues.nextValue();
        normLat = normLat && (lonLat[1] > 90 || lonLat[1] < -90);
     */
        if (data.get(LONGITUDE) == null) {
    }
    }
        final GeoDistance distance,
            } else if (GEOHASH.equals(field)) {
    ) throws IOException, OpenSearchParseException {
    public static double quadTreeCellSize(int level) {
    }
                parseGeoPointArray(parser, point, ignoreZValue);
        return geoHashLevelsForPrecision(DistanceUnit.METERS.parse(distance, DistanceUnit.DEFAULT));
     * @param distance Maximum size of cells as unit string (must greater or equal to zero)
    }
    }
     * Parse a precision that can be expressed as an integer or a distance measure like "1km", "10m".
                throw new OpenSearchParseException("geo_point expected");
                throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
            parser.nextToken(); // field value
                throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
            final int full = bits / 5;                // number of 5 bit subdivisions
        }
        }
        if (data.get(LATITUDE) == null) {
        switch (parser.currentToken()) {
import org.apache.lucene.spatial.prefix.tree.QuadPrefixTree;
import org.opensearch.index.fielddata.GeoPointValues;
            return XContentMapValues.nodeIntegerValue(parser.intValue());
     * cells will not exceed the specified size (diagonal) of the precision.
        try (
    public static double quadTreeCellHeight(int level) {
    private static GeoPoint parseGeoJsonFields(final XContentParser parser, final GeoPoint point, final boolean ignoreZValue)
 *
import org.opensearch.core.xcontent.NamedXContentRegistry;
     */
                break;
    public static int quadTreeLevelsForPrecision(double meters) {
    /**
     * {@link #normalizePoint(GeoPoint)} function.
     * @return levels need to achieve precision
                    throw new OpenSearchParseException("field [{}] missing", GEOJSON_COORDS);
        }
        return EARTH_POLAR_DISTANCE / (1L << level);
        }
            XContentParser parser = new MapXContentParser(
    /**
        normalizePoint(lonLat, true, true);
            }
     * @param level geohash level must be greater or equal to zero
                    return distance.calculate(from.lat(), from.lon(), to.lat(), to.lon(), unit);
            lon = centeredModulus(lon, 360);
            final double width = Math.sqrt((meters * meters) / (ratio * ratio)); // convert to cell width
     * Calculate the height (in meters) of geohash cells at a specific level
                        return true;
    public static SortedNumericDoubleValues distanceValues(
     * @param val a String to parse the value from
     * because when normalizing latitude it may be necessary to
        } else {
    /**
    private static final String ERR_MSG_INVALID_TOKEN = "token [{}] not allowed";
                    throw new OpenSearchParseException("{} must be a string", GEOJSON_TYPE);
        if (normLon) {
        } else {
    /**
     * <p>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    } catch (NumberFormatException e) {
    public static void normalizePoint(double[] lonLat, boolean normLon, boolean normLat) {
                        data.put(field, parser.doubleValue(true));
            final double ratio = 1 + (EARTH_POLAR_DISTANCE / EARTH_EQUATOR); // cell ratio
    }
    }
                    throw new OpenSearchParseException("numeric value expected");
        throws IOException {
        }
     * their respective normalized ranges.
    }
     * @see #normalizePoint(GeoPoint)
     */
     * <p>
                throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
     * Calculate the number of levels needed for a specific precision. GeoHash
    ) throws IOException {
     * Parse a {@link GeoPoint} from a string. The string must have one of the following forms:
    public static boolean isValidLongitude(double longitude) {
                        int v = 0;
/*
        TOP_RIGHT,
            throw new OpenSearchParseException("field [{}] missing", LATITUDE);
                LoggingDeprecationHandler.INSTANCE,
    public static GeoPoint parseGeoPoint(XContentParser parser) throws IOException, OpenSearchParseException {
    /**
                }
            }
                break;
        if (lat > 90d || lat < -90d) {
                if (hasCoordinates == false) {
            return FieldData.singleton(new NumericDoubleValues() {
            } else {
        }
     *
                    lonLat[0] += 180;
     *
    }
    }
     * in order to normalize properly the latitude.
                }
        assert level >= 0;
            throw new OpenSearchParseException("field [{}] missing", LONGITUDE);
     * @param lon Longitude to normalize
            int element = 0;
            });
    public static GeoPoint parseGeoPoint(XContentParser parser, GeoPoint point, final boolean ignoreZValue) throws IOException,
    public static double arcDistance(double lat1, double lon1, double lat2, double lon2) {
        }
            if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
     */
import org.opensearch.index.fielddata.MultiGeoPointValues;
        OpenSearchParseException {
    }
        if (Math.abs(centerLat) == MAX_LAT) {
        boolean hasTypePoint = false;
                shift = false;
        return EARTH_EQUATOR / (1L << level);
                            for (GeoPoint from : fromPoints) {
    public static double geoHashCellWidth(int level) {
     * String: expected to be in "latitude, longitude" format or a geohash
                } else {
     */
        }
     * @return levels need to achieve precision
     * @param point A {@link GeoPoint} that will be reset by the values parsed
    public static GeoPoint parseGeoPoint(
                                values[v] = distance.calculate(from.lat(), from.lon(), point.lat(), point.lon(), unit);
 * Unless required by applicable law or agreed to in writing,
    }
        return precision;
 */
                    x = parser.doubleValue();
    }
        if (parser.nextToken() != XContentParser.Token.VALUE_STRING) {
import org.opensearch.core.xcontent.XContentSubParser;
     * @param ignoreZValue tells to ignore z value or throw exception when there is a z value
            if (LONGITUDE.equals(field) || LATITUDE.equals(field)) {
                        }
     * @param parser {@link XContentParser} to parse the value from
     * <p>
import org.opensearch.OpenSearchParseException;
                // we want to treat simple integer strings as precision levels, not distances
            switch (parser.nextToken()) {
import org.opensearch.core.xcontent.XContentParser;
    }
    public static final double TOLERANCE = 1E-6;
     */
     * <ul>
        }
     * @param lat Latitude to normalize
                } else if (element == 3) {
     */
    /** Minimum valid latitude in degrees. */
    public static final double EARTH_MEAN_RADIUS = 6371008.7714D;      // meters (WGS 84)
     *
        return parseGeoPoint(value, new GeoPoint(), ignoreZValue);
    /**
                }
        }
            case START_OBJECT:
     * </ul>
     *
            }
    }
    public static final double EARTH_SEMI_MAJOR_AXIS = 6378137.0;      // meters (WGS 84)
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;
 * license agreements. See the NOTICE file distributed with
        }
    /**
 */
    public static void normalizePoint(double[] lonLat) {
        assert level >= 0;
    public static final double MAX_LAT = 90.0;
     *     <li>WKT: <pre>{@code "POINT (<longitude> <latitude>)"}</pre></li>
            while (subParser.nextToken() != XContentParser.Token.END_ARRAY) {
                    }
    ) {
            }
    public static int geoHashLevelsForPrecision(String distance) {
                parseGeoJsonFields(subParser, point, ignoreZValue);
     * If normalizing latitude but not longitude, it is assumed that
     * @return new {@link GeoPoint} parsed from the parse
    }
 *
        if (token.equals(XContentParser.Token.VALUE_NUMBER)) {
            return point;
    }
    /** Maximum valid longitude in degrees. */
    /** Returns true if longitude is actually a valid longitude value. */
    /** rounding error for quantized latitude and longitude values */
     * Array: two or more elements, the first element is longitude, the second is latitude, the rest is ignored if ignoreZValue is true
        }
        ) {
        }
        if (Double.isNaN(latitude) || Double.isInfinite(latitude) || latitude < GeoUtils.MIN_LAT || latitude > GeoUtils.MAX_LAT) {
            if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
    }
                    throw new OpenSearchParseException("{} must be a number", field);
    public static final String WKT_BOUNDING_BOX_PARSE_ERROR = "failed to parse WKT bounding box";
                throw new OpenSearchParseException("[geo_point] field type should have at least two dimensions");
            }
        if ((precision < 1) || (precision > 12)) {
                    // keep it in the form x+k*360 (with x in ]-180;180])
     * @param normLat Whether to normalize latitude or leave it as is.
            parser.nextToken(); // field name
import org.opensearch.index.fielddata.FieldData;
    /**
            if (lonLat[1] < -90) {
        final GeoPoint point,
import java.util.Collections;
    public static GeoPoint parseGeoPoint(Object value, GeoPoint point, final boolean ignoreZValue) throws OpenSearchParseException {
        if (rtn <= 0) {
                        resize(geoPointValues.docValueCount() * fromPoints.length);
        final EffectivePoint effectivePoint
                    throw new IllegalArgumentException("precision too high [" + precision + "]", e2);
                null
     * Object: has to contain either lat and lon or geohash fields
                    final GeoPoint to = singleValues.geoPointValue();
    /** Return the distance (in meters) between 2 lat,lon geo points using the haversine method implemented by lucene */
            return QuadPrefixTree.MAX_LEVELS_POSSIBLE;
     * Checks that the precision is within range supported by opensearch - between 1 and 12
    private GeoUtils() {}
    public static final String LONGITUDE = "lon";
            throw new OpenSearchParseException("{} must be a string", GEOHASH);
     * Parse a {@link GeoPoint} with a {@link XContentParser}. A geopoint has one of the following forms:
            final int even = full + (left > 0 ? 1 : 0);     // number of even levels
    public static final String GEOJSON_TYPE = "type";
                return XContentMapValues.nodeIntegerValue(precision);
     * Calculate the size (in meters) of geohash cells at a specific level
     * </ul>
    }
        return parseGeoPoint(parser, point, ignoreZValue, EffectivePoint.BOTTOM_LEFT);
        return point.resetFromString(val, false, EffectivePoint.BOTTOM_LEFT);
    /**
        return parseGeoPoint(parser, new GeoPoint());
 * this file be licensed under the Apache-2.0 license or a
                if (parser.nextToken() != XContentParser.Token.VALUE_STRING) {
                }
                public boolean advanceExact(int target) throws IOException {
import org.opensearch.geometry.ShapeType;
            }
            return parseGeoPoint(parser, point, ignoreZValue);
                    GeoPoint.assertZValue(ignoreZValue, parser.doubleValue());
        HashMap<String, Double> data = new HashMap<>();
     * cells will not exceed the specified size (diagonal) of the precision.
 * Modifications Copyright OpenSearch Contributors. See
     */
     * @param point The point to normalize in-place.
     * Normalize latitude to lie within the -90 to 90 (both inclusive) range.
        BOTTOM_RIGHT
            double y = Double.NaN;
        return Math.sqrt(w * w + h * h);
        if (lon > 180d || lon <= -180d) {
     * @return the width of cells at level in meters
        if (singleValues != null && fromPoints.length == 1) {
 * the Apache License, Version 2.0 (the "License"); you may
     * @param level geohash level must be greater or equal to zero
            if (i != 0) {
                throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
 * software distributed under the License is distributed on an
        GeoPoint point = new GeoPoint();
     * <p>
            return point.reset(y, x);
    /** Earth ellipsoid minor axis defined by WGS 84 in meters */
        assert level >= 0;
            rtn += divisor;
                }
     * The precision is expressed as a number between 1 and 12 and indicates the length of geohash
        double y = Math.toRadians(lat2 - lat1);
    /** Earth ellipsoid polar distance in meters */
        final XContentParser parser,
    /**
                } else {
     * Return a {@link SortedNumericDoubleValues} instance that returns the distances to a list of geo-points
            } else if (GEOJSON_TYPE.equals(field) || GEOJSON_COORDS.equals(field)) {
    /**
 * under the License.
        }
     */
        try (XContentSubParser subParser = new XContentSubParser(parser)) {
            String precision = parser.text();
        final DistanceUnit unit,
     * Object: has to contain either lat and lon or geohash fields
                }
        double[] pt = { point.lon(), point.lat() };
                // To be consistent with geo_shape parsing, ignore case here as well.
    public static final double MIN_LON = -180.0;
            }
            };
     *
                        return false;
            throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
        return SloppyMath.haversinMeters(centerLat, centerLon, centerLat, (MAX_LON + centerLon) % 360);
        XContentParser.Token token = parser.currentToken();
import org.opensearch.index.fielddata.NumericDoubleValues;
import java.io.IOException;
        } else {
                element++;
                if (ShapeType.POINT.name().equalsIgnoreCase(parser.text()) == false) {
        // Geohash cells are split into 32 cells at each level. the grid
            default:
        } else {
            } else {
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
     * @return new parsed {@link GeoPoint}
    /** Earth axis ratio defined by WGS 84 (0.996647189335) */
            return even + odd;
        if (rtn > divisor / 2) {
            String field = parser.currentName();
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
            return GeohashPrefixTree.getMaxLevelsPossible();
            return SloppyMath.haversinMeters(centerLat, centerLon, 0, centerLon);
     */
            }
                }
                // try to parse as a distance value
     */
                parser.nextToken();
            return false;
        }
        assert meters >= 0;
            }
        final GeoPoint... fromPoints
        for (int i = 0; i < 2; i++) {
        // Geohash cells are split into 32 cells at each level. the grid
                parseGeoHashFields(subParser, point, effectivePoint);
                hasTypePoint = true;
    public static final double MIN_LAT = -90.0;
     * @param point   The point to normalize in-place.
     *
        final GeoPoint point,
 * not use this file except in compliance with the License.
    /**
    /**
        if (normLat) {
                    throw new OpenSearchParseException("{} must be Point", GEOJSON_TYPE);
 *
/*
     *     <li>GeoJson: <pre>{@code {"type": "Point", "coordinates": [<longitude>, <latitude>]}}</pre><li>
     *
                                v++;
        normalizePoint(pt, normLon, normLat);
 * SPDX-License-Identifier: Apache-2.0
    /**
    /**
     * <p>
            rtn -= divisor;
/**
        final boolean ignoreZValue,
        throws IOException {
                } else if (element == 2) {
     * @return int representing precision
     * @param parser {@link XContentParser} to parse the value from
    public static final double EARTH_EQUATOR = 2 * Math.PI * EARTH_SEMI_MAJOR_AXIS;
     * @param distance Maximum size of cells as unit string (must greater or equal to zero)
import org.opensearch.index.fielddata.SortingNumericDoubleValues;
    public static double normalizeLat(double lat) {
    /**
     * @return the height of cells at level in meters
 * The OpenSearch Contributors require contributions made to
        // avoid -0.0
 */
     */
                    return singleValues.advanceExact(doc);
                    break;
                if (parser.nextToken() != XContentParser.Token.START_ARRAY) {
                break;
     * Calculate the width (in meters) of geohash cells at a specific level
     * String: expected to be in "latitude, longitude" format or a geohash
     *
     * the left bottom corner of the geohash cell is used as the geopoint coordinates.GeoBoundingBoxQueryBuilder.java
        final GeoUtils.EffectivePoint effectivePoint
     * @return levels need to achieve precision
    }
    public static GeoPoint parseFromString(String val) {
    }
        assert lonLat != null && lonLat.length == 2;
                }
    ) throws IOException {
        }
    }
    /**  Error messages for WKT parsing */
    public static int checkPrecisionRange(int precision) {
     * Normalize longitude to lie within the -180 (exclusive) to 180 (inclusive) range.
 * @opensearch.internal
    private static GeoPoint parseGeoPointObject(
     * Represents the point of the geohash cell that should be used as the value of geohash
            }
                    throw new OpenSearchParseException("{} must be an array", GEOJSON_COORDS);
        BOTTOM_LEFT,
        return true;
                default:
     * the longitude is in the form x+k*360, with x in ]-180;180],
    /**
        assert level >= 0;
            final int left = bits - full * 5;           // bit representing the last level
            lonLat[1] = centeredModulus(lonLat[1], 360);
     */
    public static void normalizePoint(GeoPoint point, boolean normLat, boolean normLon) {
            final int odd = full + (left > 3 ? 1 : 0);      // number of odd levels
        if (meters == 0) {
        final XContentParser parser,
        normLon = normLon && (lonLat[0] > 180 || lonLat[0] < -180 || normLat);
     * Returns the precision value if it is in the range and throws an IllegalArgumentException if it
            } catch (NumberFormatException e) {
import org.apache.lucene.util.SloppyMath;
            final double ratio = 1 + (EARTH_POLAR_DISTANCE / EARTH_EQUATOR); // cell ratio
                    throw new OpenSearchParseException("field [{}] missing", GEOJSON_TYPE);
                        for (int i = 0; i < geoPointValues.docValueCount(); ++i) {
    public static double normalizeLon(double lon) {
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
     */
        final MultiGeoPointValues geoPointValues,
import java.util.HashMap;
                }
     * @param level quadtree level must be greater or equal to zero
     *
    }
     * Calculate the size (in meters) of quadtree cells at a specific level
                point.resetFromString(val, ignoreZValue, effectivePoint);
                    // this happens when distance too small, so precision > 12. We'd like to see the original string
                    try {
    }
            final double width = Math.sqrt((meters * meters) / (ratio * ratio)); // convert to cell width
                        sort();
        point.reset(pt[1], pt[0]);
    public static final double EARTH_SEMI_MINOR_AXIS = 6356752.314245; // meters (WGS 84)
        }
                    } else {
                    throw new OpenSearchParseException("[geo_point] field type does not accept more than 3 values");
     * 4 decimal degrees
    }
                    }
                @Override
    }
    private static final String ERR_MSG_INVALID_FIELDS = "field must be either [lon|lat], [type|coordinates], or [geohash]";
     * @param meters Maximum size of cells in meters (must greater than zero)
            throw new OpenSearchParseException(ERR_MSG_INVALID_TOKEN, parser.currentToken());
            if (GEOJSON_TYPE.equals(parser.currentName())) {
     * @return the height of cells at level in meters
                case VALUE_STRING:
 * this work for additional information regarding copyright
     *
            if (i != 0) {
    public static final String GEOJSON_COORDS = "coordinates";
        }
        // alternates at each level between a 8x4 and a 4x8 grid
                } catch (IllegalArgumentException e2) {
        // alternates at each level between a 8x4 and a 4x8 grid
                Collections.singletonMap("null_value", value),
    /**
    }
                            }
            if (LONGITUDE.equals(field) == false && LATITUDE.equals(field) == false) {
     * Normalize the geo {@code Point} for the given coordinates to lie within
     *
                if (normLon) {
            final long part = Math.round(Math.ceil(EARTH_EQUATOR / width));
            double x = Double.NaN;
        final GeoPoint point,
            return (part <= (1L << level)) ? level : (level + 1); // adjust level
                lonLat[1] = 180 - lonLat[1];
    public static int parsePrecision(XContentParser parser) throws IOException, OpenSearchParseException {
/*
     */
     * @param level quadtree level must be greater or equal to zero
public class GeoUtils {
     *     <li>Array: <pre>{@code [<longitude>, <latitude>]}</pre></li>
        assert level >= 0;
     * Return the distance (in meters) between 2 lat,lon geo points using a simple tangential plane
     */
        if (meters == 0) {
     * used to represent geo points.
                NamedXContentRegistry.EMPTY,
     * <p>
     * Array: two or more elements, the first element is longitude, the second is latitude, the rest is ignored if ignoreZValue is true
            if (part == 1) return 1;
 */
    public static double centeredModulus(double dividend, double divisor) {
        return Math.sqrt(x * x + y * y) * EARTH_MEAN_RADIUS;
            boolean shift = true;
        }
                }
     * @param level geohash level must be greater or equal to zero
     * Note: A shift of 180&deg; is applied in the longitude if necessary,
    /**
            }
                }
        return EARTH_POLAR_DISTANCE / (1L << ((((level + 1) / 2) * 2) + ((level / 2) * 3)));
     * Calculate the width (in meters) of quadtree cells at a specific level
        return parseGeoPoint(parser, point, false);
            if (lat < -90) {
     * this provides a faster alternative to {@link GeoUtils#arcDistance} but is inaccurate for distances greater than
        final GeoPointValues singleValues = FieldData.unwrapSingleton(geoPointValues);
    public static final String LATITUDE = "lat";
    /** Maximum valid latitude in degrees. */
        double rtn = dividend % divisor;
        // avoid -0.0
        }
                    return checkPrecisionRange(parsedPrecision);
        return lat + 0d;
        return EARTH_EQUATOR / (1L << ((((level + 1) / 2) * 3) + ((level / 2) * 2)));
     *     <li>GeoHash: <pre>{@code "<geohash>"}</pre></li>
            } else {
    private static GeoPoint parseGeoPointArray(final XContentParser parser, final GeoPoint point, final boolean ignoreZValue)
                    final GeoPoint from = fromPoints[0];
            }
     * cells will not exceed the specified size (diagonal) of the precision.
                // No need to shift the longitude, and the latitude is normalized
     * Calculate the number of levels needed for a specific precision. QuadTree
import org.opensearch.core.xcontent.MapXContentParser;
    }
