                LoggingDeprecationHandler.INSTANCE,
        }
     * For this purpose, you should call the
            if (i != 0) {  
                }
            parser.nextToken(); // field name
            throw new OpenSearchParseException("error parsing geopoint", ex);
     * @return levels need to achieve precision  
            rtn += divisor;
            }  
                    throw new OpenSearchParseException("field [{}] missing", GEOJSON_TYPE);
     *
import org.opensearch.geometry.ShapeType;  
 * this work for additional information regarding copyright
    }
    }
        switch (parser.currentToken()) {
        assert level >= 0;  
            }
 * KIND, either express or implied.  See the License for the
     * @param lon Longitude to normalize
    /**  
                            for (GeoPoint from : fromPoints) {
                        return false;
        return EARTH_POLAR_DISTANCE / (1L << level);  
     * @param point The point to normalize in-place.
    /**
            return SloppyMath.haversinMeters(centerLat, centerLon, 0, centerLon);
                @Override
     * @return the height of cells at level in meters
import java.util.HashMap;
            return (part <= (1L << level)) ? level : (level + 1); // adjust level
        final GeoPoint point,  
     * @param level geohash level must be greater or equal to zero  
            rtn -= divisor;
                    return checkPrecisionRange(parsedPrecision);
    public static final String LONGITUDE = "lon";  
        if (singleValues != null && fromPoints.length == 1) {
import org.opensearch.OpenSearchParseException;
        if (meters == 0) {  
 *
     *
     * Array: two or more elements, the first element is longitude, the second is latitude, the rest is ignored if ignoreZValue is true  
                if (normLon) {
    private static GeoPoint parseGeoJsonFields(final XContentParser parser, final GeoPoint point, final boolean ignoreZValue)
     * @return the size of cells at level in meters  
        normalizePoint(point, true, true);
                    throw new OpenSearchParseException("[geo_point] field type does not accept more than 3 values");  
     * this provides a faster alternative to {@link GeoUtils#arcDistance} but is inaccurate for distances greater than
        return true;
    public static void normalizePoint(GeoPoint point, boolean normLat, boolean normLon) {  
    }  
        normalizePoint(lonLat, true, true);
            }  
     * Object: has to contain either lat and lon or geohash fields  
    public static boolean isValidLatitude(double latitude) {
            lat = centeredModulus(lat, 360);
     * @return levels need to achieve precision
    /**  
    /** Returns true if latitude is actually a valid latitude value.*/  
                lat = 180 - lat;
                element++;
            return point.reset(y, x);
            return GeohashPrefixTree.getMaxLevelsPossible();
     */
     * Therefore x will be adjusted while keeping k preserved.  
        if (meters == 0) {  
     *  
     * <p>
     * <p>
import org.opensearch.core.xcontent.XContentParser;
     * @param effectivePoint tells which point to use for GeoHash form
    }
            if (lat < -90) {
                try {  
                    // this happens when distance too small, so precision > 12. We'd like to see the original string  
            return QuadPrefixTree.MAX_LEVELS_POSSIBLE;
import org.apache.lucene.spatial.prefix.tree.QuadPrefixTree;
            });
import java.util.Collections;  
                } else if (element == 3) {  
    public static final String GEOJSON_TYPE = "type";  
    public static final double MAX_LAT = 90.0;  
                }
     */
     *     <li>GeoHash: <pre>{@code "<geohash>"}</pre></li>  
            if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
     */  
     * Represents the point of the geohash cell that should be used as the value of geohash
        }
    /** Earth ellipsoid polar distance in meters */  
    /**
    public static double quadTreeCellSize(int level) {
/**  
import org.opensearch.common.xcontent.support.XContentMapValues;
    /**
    public static final String LATITUDE = "lat";
     * for each document.
    }
    /**
            boolean shift = true;  
    public static double arcDistance(double lat1, double lon1, double lat2, double lon2) {
     * Normalize the geo {@code Point} for its coordinates to lie within their
    public static double planeDistance(double lat1, double lon1, double lat2, double lon2) {
     * Parses the value as a geopoint. The following types of values are supported:
     *
                    // keep it in the form x+k*360 (with x in ]-180;180])
    }
     * in order to normalize properly the latitude.
        normalizePoint(pt, normLon, normLat);
            )
import org.opensearch.index.fielddata.SortingNumericDoubleValues;  
            throw new OpenSearchParseException("field [{}] missing", LONGITUDE);  
            try {  
     */  
        }
                case VALUE_NUMBER:
 * Useful geo utilities
     * because when normalizing latitude it may be necessary to
            String field = subParser.currentName();
        double[] pt = { point.lon(), point.lat() };
        return point.parseGeoHash(parser.text(), effectivePoint);
     * @return The normalized latitude.
                // we want to treat simple integer strings as precision levels, not distances
 * @opensearch.internal  
                    throw new OpenSearchParseException("{} must be Point", GEOJSON_TYPE);  
        if (data.get(LATITUDE) == null) {
    /**
    /**  
    }
        throws IOException {  
    }
        return Math.sqrt(x * x + y * y) * EARTH_MEAN_RADIUS;
                        int v = 0;
     *
    }  
 * SPDX-License-Identifier: Apache-2.0
     *     <li>GeoJson: <pre>{@code {"type": "Point", "coordinates": [<longitude>, <latitude>]}}</pre><li>  
     * @param parser {@link XContentParser} to parse the value from  
            }
     * Calculate the size (in meters) of geohash cells at a specific level
    }
        final MultiGeoPointValues geoPointValues,  
     */
     * @param meters Maximum size of cells in meters (must greater or equal to zero)  
            }  
                null  
    public static final double EARTH_POLAR_DISTANCE = Math.PI * EARTH_SEMI_MINOR_AXIS;
            lonLat[0] = centeredModulus(lonLat[0], 360);  
            } else {
    public static final double MAX_LON = 180.0;
    public static int quadTreeLevelsForPrecision(String distance) {
    public static SortedNumericDoubleValues distanceValues(  
                break;
    public static void normalizePoint(double[] lonLat, boolean normLon, boolean normLat) {
    }  
     * Calculate the width (in meters) of geohash cells at a specific level
        if (GEOHASH.equals(parser.currentName()) == false) {  
        final EffectivePoint effectivePoint
        if ((precision < 1) || (precision > 12)) {
                lonLat[1] = -180 - lonLat[1];
    public static GeoPoint parseGeoPoint(Object value, GeoPoint point, final boolean ignoreZValue) throws OpenSearchParseException {  
        return EARTH_POLAR_DISTANCE / (1L << ((((level + 1) / 2) * 2) + ((level / 2) * 3)));
     * cells will not exceed the specified size (diagonal) of the precision.
            }
        final XContentParser parser,
        }
     */
    public static GeoPoint parseGeoPoint(
                return XContentMapValues.nodeIntegerValue(precision);
        } else {
        assert meters >= 0;
    /**
    }
        } else {
        // Geohash cells are split into 32 cells at each level. the grid  
        try (XContentSubParser subParser = new XContentSubParser(parser)) {  
     * @param ignoreZValue tells to ignore z value or throw exception when there is a z value  
            return FieldData.singleton(new NumericDoubleValues() {
     * @param level geohash level must be greater or equal to zero
     * in order to normalize properly the latitude.
 */  
            switch (parser.nextToken()) {  
        }
        boolean hasTypePoint = false;
    /**
            lonLat[1] = centeredModulus(lonLat[1], 360);
import org.apache.lucene.util.SloppyMath;  
        BOTTOM_LEFT,
        final boolean ignoreZValue,
     * <p>  
        return EARTH_EQUATOR / (1L << level);
        for (int i = 0; i < 2; i++) {  
     * {@link #normalizePoint(GeoPoint)} function.
                    final GeoPoint from = fromPoints[0];
    /**
    public static double normalizeLon(double lon) {
        } else {
                        resize(geoPointValues.docValueCount() * fromPoints.length);
            }
            } else {  
     * Calculate the size (in meters) of quadtree cells at a specific level
                break;
    /** Earth ellipsoid minor axis defined by WGS 84 in meters */  
    public static double geoHashCellWidth(int level) {  
        return EARTH_EQUATOR / (1L << ((((level + 1) / 2) * 3) + ((level / 2) * 2)));
     * Normalize longitude to lie within the -180 (exclusive) to 180 (inclusive) range.  
    public static final String WKT_BOUNDING_BOX_PARSE_ERROR = "failed to parse WKT bounding box";
     */
    public static int geoHashLevelsForPrecision(double meters) {  
     * used to represent geo points.
        HashMap<String, Double> data = new HashMap<>();
     * @return the size of cells at level in meters  
                } catch (IllegalArgumentException e2) {
                public boolean advanceExact(int doc) throws IOException {
     * Return a {@link SortedNumericDoubleValues} instance that returns the distances to a list of geo-points  
    public static double quadTreeCellWidth(int level) {  
     * Parse a precision that can be expressed as an integer or a distance measure like "1km", "10m".
        final XContentParser parser,
                    break;
                final int parsedPrecision = GeoUtils.geoHashLevelsForPrecision(precision);
    }
                } else {  
        if (parser.nextToken() != XContentParser.Token.VALUE_STRING) {
                    try {  
 *
            lon = centeredModulus(lon, 360);
                    } catch (NumberFormatException e) {
        assert lonLat != null && lonLat.length == 2;
     * @return the height of cells at level in meters
                            final GeoPoint point = geoPointValues.nextValue();
        if (token.equals(XContentParser.Token.VALUE_NUMBER)) {
            } else if (lonLat[1] > 90) {  
            } else if (lat > 90) {
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /** Minimum valid latitude in degrees. */
                        for (int i = 0; i < geoPointValues.docValueCount(); ++i) {  
 */  
    /**  
        throws IOException {  
 * Unless required by applicable law or agreed to in writing,
     * If normalizing latitude but not longitude, it is assumed that  
    private static GeoPoint parseGeoPointArray(final XContentParser parser, final GeoPoint point, final boolean ignoreZValue)
     * <p>
        }
                throw new OpenSearchParseException("[geo_point] field type should have at least two dimensions");
                throw new OpenSearchParseException("geo_point expected");
import org.opensearch.index.fielddata.MultiGeoPointValues;  
            final double ratio = 1 + (EARTH_POLAR_DISTANCE / EARTH_EQUATOR); // cell ratio  
     * the longitude is in the form x+k*360, with x in ]-180;180],
                    if (geoPointValues.advanceExact(target)) {  
    public static final double MIN_LAT = -90.0;
            if (part == 1) return 1;  
                if (element == 1) {
     * @param level quadtree level must be greater or equal to zero
                throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
            while (subParser.nextToken() != XContentParser.Token.END_ARRAY) {  
     * Calculate the height (in meters) of geohash cells at a specific level  
                @Override
     * @param level quadtree level must be greater or equal to zero
                // try to parse as a distance value
     * @param point   The point to normalize in-place.
     * <p>  
                throw new OpenSearchParseException(ERR_MSG_INVALID_TOKEN, subParser.currentToken());
                // No need to shift the longitude, and the latitude is normalized  
        final double w = geoHashCellWidth(level);
     */
    /**  
                @Override  
        return rtn;  
            if (lonLat[1] < -90) {
        final GeoPointValues singleValues = FieldData.unwrapSingleton(geoPointValues);  
    public static GeoPoint parseFromString(String val) {
     * @return levels need to achieve precision
        if (normLat) {
        return precision;
                }
        final GeoPoint point,
     *
     */
            } else {  
            String precision = parser.text();
            final int left = bits - full * 5;           // bit representing the last level  
     * Normalize the geo {@code Point} for the given coordinates to lie within
    public static void normalizePoint(GeoPoint point) {  
                shift = false;
        }
    }  
    }  
        assert level >= 0;
 * compatible open source license.
            return false;  
     * The precision is expressed as a number between 1 and 12 and indicates the length of geohash  
     * their respective normalized ranges.  
                }  
            final int level = Long.SIZE - Long.numberOfLeadingZeros(part) - 1; // (log_2)  
                    throw new OpenSearchParseException("{} must be a string", GEOJSON_TYPE);
    ) throws IOException, OpenSearchParseException {  
            if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
     * @param distance Maximum size of cells as unit string (must greater or equal to zero)
    private static GeoPoint parseGeoPointObjectBasicFields(final XContentParser parser, final GeoPoint point) throws IOException {  
                point.resetFromString(val, ignoreZValue, effectivePoint);
                throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
     *  
    /** Earth mean radius defined by WGS 84 in meters */  
    private GeoUtils() {}
    /**
                    // Longitude won't be normalized,
     * @return new {@link GeoPoint} parsed from the parse
        // Geohash cells are split into 32 cells at each level. the grid
    }  
     */
                }
    public static GeoPoint parseGeoPoint(Object value, final boolean ignoreZValue) throws OpenSearchParseException {
                    // by only changing x, assuming k is meaningful for the user application.  
        // alternates at each level between a 8x4 and a 4x8 grid
                parseGeoPointObject(parser, point, ignoreZValue, effectivePoint);  
     * <p>
            int element = 0;
}  
    public static final double EARTH_EQUATOR = 2 * Math.PI * EARTH_SEMI_MAJOR_AXIS;
                    return singleValues.advanceExact(doc);  
     * and k is meaningful to the application.
    private static final String ERR_MSG_INVALID_FIELDS = "field must be either [lon|lat], [type|coordinates], or [geohash]";
/*
        if (lon > 180d || lon <= -180d) {  
     * @param normLat Whether to normalize latitude or leave it as is.  
     * add a shift of 180&deg; in the longitude.  
public class GeoUtils {
        double x = Math.toRadians(lon2 - lon1) * Math.cos(Math.toRadians((lat2 + lat1) / 2.0d));  
     * Parse a {@link GeoPoint} with a {@link XContentParser}. A geopoint has one of the following forms:
                String val = parser.text();  
        if (rtn > divisor / 2) {  
 * license agreements. See the NOTICE file distributed with
     * @param level geohash level must be greater or equal to zero
                }
        }
        if (normLon) {
                parseGeoHashFields(subParser, point, effectivePoint);  
     */
                if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) {
     * <p>
     *     <li>WKT: <pre>{@code "POINT (<longitude> <latitude>)"}</pre></li>
     * </ul>
                            }
     * @param lat Latitude to normalize
        boolean hasCoordinates = false;
                    throw new OpenSearchParseException("numeric value expected");
     * Parse a geopoint represented as an object, string or an array. If the geopoint is represented as a geohash,
        }
                break;
    public static final String WKT_BOUNDING_BOX_TYPE_ERROR = "failed to parse WKT bounding box. [%s] found. expected [%s]";
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
                throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
        }
        final GeoUtils.EffectivePoint effectivePoint  
     * 4 decimal degrees  
        if (rtn <= 0) {  
        assert level >= 0;
     */
            double y = Double.NaN;  
                        sort();
                }
        }  
        assert level >= 0;  
            } else if (GEOHASH.equals(field)) {
            throw new OpenSearchParseException("{} must be a string", GEOHASH);
     *     <li>Object: <pre>{@code {"lat": <latitude>, "lon": <longitude}}</pre></li>
                }  
        GeoPoint point = new GeoPoint();
                default:  
                parseGeoPointArray(parser, point, ignoreZValue);
    /** Returns the maximum distance/radius (in meters) from the point 'center' before overlapping */
     * Calculate the number of levels needed for a specific precision. GeoHash
                }
            }  
     * Calculate the number of levels needed for a specific precision. Quadtree
    public static int parsePrecision(XContentParser parser) throws IOException, OpenSearchParseException {  
     * Parse a {@link GeoPoint} with a {@link XContentParser}:
     * Checks that the precision is within range supported by opensearch - between 1 and 12
     */
     *     <li>Array: <pre>{@code [<longitude>, <latitude>]}</pre></li>
            }  
     * @param point A {@link GeoPoint} that will be reset by the values parsed
    }  
    }
        if (Math.abs(centerLat) == MAX_LAT) {
            final double part = Math.ceil(EARTH_EQUATOR / width);
        final GeoPoint... fromPoints
 * specific language governing permissions and limitations
     * Note: You should not normalize longitude and latitude separately,
    /**  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }  
     * @param meters Maximum size of cells in meters (must greater than zero)
     * @return the width of cells at level in meters
            parser.nextToken(); // start object  
            if (subParser.nextToken() != XContentParser.Token.FIELD_NAME) {
        return point;
        BOTTOM_RIGHT  
    public static int quadTreeLevelsForPrecision(double meters) {
            throw new OpenSearchParseException("field [{}] missing", LATITUDE);  
     * Parse a {@link GeoPoint} from a string. The string must have one of the following forms:  
        } else {
                throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
    ) {
import org.opensearch.index.fielddata.NumericDoubleValues;
import java.io.IOException;
            return false;
     *  
     *     <li>String: <pre>{@code "<latitude>,<longitude>"}</pre></li>
    }
    /**
        // avoid -0.0  
    /** Return the distance (in meters) between 2 lat,lon geo points using the haversine method implemented by lucene */
        ) {
            final int bits = (int) Math.round(Math.ceil(Math.log(part) / Math.log(2)));
     * Parses the value as a geopoint. The following types of values are supported:  
     * Array: two or more elements, the first element is longitude, the second is latitude, the rest is ignored if ignoreZValue is true
    }  
            }  
        return Math.sqrt(w * w + h * h);  
        }
        XContentParser.Token token = parser.currentToken();
            } else if (GEOJSON_TYPE.equals(field) || GEOJSON_COORDS.equals(field)) {
    /**
     * Return the distance (in meters) between 2 lat,lon geo points using a simple tangential plane
     */  
    }
     * String: expected to be in "latitude, longitude" format or a geohash
import org.opensearch.common.unit.DistanceUnit;
     * <p>  
    /** Maximum valid longitude in degrees. */  
                                v++;
    }  
    private static GeoPoint parseGeoPointObject(  
 *
    }  
        }  
                        data.put(field, parser.doubleValue(true));
    public static GeoPoint parseGeoPoint(XContentParser parser) throws IOException, OpenSearchParseException {  
     */
        }  
 * You may obtain a copy of the License at  
     * @see #normalizePoint(GeoPoint)  
        final DistanceUnit unit,
    /**  
    public static final double TOLERANCE = 1E-6;
                lat = -180 - lat;  
            }
     * @param distance Maximum size of cells as unit string (must greater or equal to zero)
        }
                    }
        }
     * @return the width of cells at level in meters
package org.opensearch.common.geo;
            if (element < 2) {
     *  
        final XContentParser parser,
import org.opensearch.core.xcontent.XContentSubParser;
            if (shift) {  
            final int odd = full + (left > 3 ? 1 : 0);      // number of odd levels
    public static double maxRadialDistanceMeters(final double centerLat, final double centerLon) {  
    public static final double EARTH_MEAN_RADIUS = 6371008.7714D;      // meters (WGS 84)
     * <p>  
 * under the License.  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
     * @param val a String to parse the value from
            return even + odd;  
        return lat + 0d;  
            final int even = full + (left > 0 ? 1 : 0);     // number of even levels
                }
 *     http://www.apache.org/licenses/LICENSE-2.0
                    final GeoPoint to = singleValues.geoPointValue();  
            final double width = Math.sqrt((meters * meters) / (ratio * ratio)); // convert to cell width
                case VALUE_STRING:
     * <p>
     *
    /** Earth ellipsoid equator length in meters */  
        return point;  
                    throw new OpenSearchParseException("{} must be an array", GEOJSON_COORDS);
    private static final String ERR_MSG_INVALID_TOKEN = "token [{}] not allowed";  
     */  
        return quadTreeLevelsForPrecision(DistanceUnit.METERS.parse(distance, DistanceUnit.DEFAULT));  
    }
    /**
        assert meters >= 0;
     * @param level quadtree level must be greater or equal to zero  
        final GeoDistance distance,
            if (LONGITUDE.equals(field) == false && LATITUDE.equals(field) == false) {  
    /** Minimum valid longitude in degrees. */
        for (int i = 0; i < 2; i++) {
     * @param normLon Whether to normalize longitude.
            if (GEOJSON_TYPE.equals(parser.currentName())) {
 * GitHub history for details.
        }
    public static double normalizeLat(double lat) {
        final GeoUtils.EffectivePoint effectivePoint
     * Calculate the height (in meters) of quadtree cells at a specific level  
        point.reset(pt[1], pt[0]);  
     * @param parser {@link XContentParser} to parse the value from  
    }
    }
        try (
    }
                parser.nextToken();
 * this file be licensed under the Apache-2.0 license or a
            return new SortingNumericDoubleValues() {  
        if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
    }
            }  
            }
            throw new IllegalArgumentException("Invalid geohash aggregation precision of " + precision + ". Must be between 1 and 12.");  
                parseGeoPointArray(parser, point, ignoreZValue);  
                    lonLat[0] += normalizeLon(lonLat[0]) > 0 ? -180 : 180;
                        return true;
    /**  Error messages for WKT parsing */  
import org.opensearch.core.xcontent.MapXContentParser;
     *
    }
    public static int geoHashLevelsForPrecision(String distance) {
        return parseGeoPoint(parser, point, ignoreZValue, EffectivePoint.BOTTOM_LEFT);  
                break;
                if (ShapeType.POINT.name().equalsIgnoreCase(parser.text()) == false) {
    /** Returns true if longitude is actually a valid longitude value. */
                if (hasCoordinates == false) {  
        double y = Math.toRadians(lat2 - lat1);
    /**
    ) throws IOException {
     * Note: A shift of 180&deg; is applied in the longitude if necessary,
        if (data.get(LONGITUDE) == null) {
                public boolean advanceExact(int target) throws IOException {
    /** Maximum valid latitude in degrees. */
            final double width = Math.sqrt((meters * meters) / (ratio * ratio)); // convert to cell width
     */
        return point.reset(data.get(LATITUDE), data.get(LONGITUDE));  
            }
    public static final double EARTH_AXIS_RATIO = EARTH_SEMI_MINOR_AXIS / EARTH_SEMI_MAJOR_AXIS;
        normLat = normLat && (lonLat[1] > 90 || lonLat[1] < -90);
            case START_OBJECT:
        }  
     * is outside the range.
                if (hasTypePoint == false) {  
    public static final double MIN_LON = -180.0;  
     * @return The normalized longitude.  
                hasCoordinates = true;
                        }  
     */
 * Licensed to Elasticsearch under one or more contributor  
        return parseGeoPoint(value, new GeoPoint(), ignoreZValue);  
        try (XContentSubParser subParser = new XContentSubParser(parser)) {
        // avoid -0.0
     * </ul>
 * not use this file except in compliance with the License.
            XContentParser parser = new MapXContentParser(
     */  
        }  
    public static double centeredModulus(double dividend, double divisor) {
    }
                parseGeoPointObjectBasicFields(subParser, point);
                public double doubleValue() throws IOException {
        } catch (IOException ex) {
            if (i != 0) {
     * @return levels need to achieve precision
     */
     * String: expected to be in "latitude, longitude" format or a geohash
     * cells will not exceed the specified size (diagonal) of the precision.  
     * <p>  
            }  
     * respective normalized ranges.
     * @param parser {@link XContentParser} to parse the value from
            } else if (GEOJSON_COORDS.equals(parser.currentName())) {  
    private static GeoPoint parseGeoHashFields(  
    /**  
                parser.nextToken();
        return lon + 0d;
                                values[v] = distance.calculate(from.lat(), from.lon(), point.lat(), point.lon(), unit);  
    /** Earth axis ratio defined by WGS 84 (0.996647189335) */  
            case VALUE_STRING:
            }  
    public static GeoPoint parseGeoPoint(XContentParser parser, GeoPoint point, final boolean ignoreZValue) throws IOException,
                parseGeoJsonFields(subParser, point, ignoreZValue);
     */  
                } else {
     * cells will not exceed the specified size (diagonal) of the precision.
     *     <li>Latitude, Longitude form: <pre>&quot;<i>&lt;latitude&gt;</i>,<i>&lt;longitude&gt;</i>&quot;</pre></li>  
     * the left bottom corner of the geohash cell is used as the geopoint coordinates.GeoBoundingBoxQueryBuilder.java
     * @opensearch.internal  
    /** Earth ellipsoid major axis defined by WGS 84 in meters */  
    }
     * @return new parsed {@link GeoPoint}
        }  
        if (Double.isNaN(longitude) || Double.isInfinite(longitude) || longitude < GeoUtils.MIN_LON || longitude > GeoUtils.MAX_LON) {
     * <ul>
            case START_ARRAY:
        final GeoPoint point,
            double x = Double.NaN;
     *
    public static int checkPrecisionRange(int precision) {
                }  
    public enum EffectivePoint {
    }  
                    y = parser.doubleValue();
    public static double geoHashCellHeight(int level) {
        OpenSearchParseException {
        return true;
 * ownership. Elasticsearch licenses this file to you under  
            final double ratio = 1 + (EARTH_POLAR_DISTANCE / EARTH_EQUATOR); // cell ratio  
        }
    public static final double EARTH_SEMI_MINOR_AXIS = 6356752.314245; // meters (WGS 84)
                    lonLat[0] += 180;
            return parseGeoPoint(parser, point, ignoreZValue);  
     * Note: A shift of 180&deg; is applied in the longitude if necessary,
        return geoHashLevelsForPrecision(DistanceUnit.METERS.parse(distance, DistanceUnit.DEFAULT));
     * @return new {@link GeoPoint} parsed from the parse
    }
        // alternates at each level between a 8x4 and a 4x8 grid  
        return parseGeoPoint(parser, point, false);
    /**
            return point;
        final double h = geoHashCellHeight(level);
            throw new OpenSearchParseException(ERR_MSG_INVALID_FIELDS);
                if (parser.nextToken() != XContentParser.Token.START_ARRAY) {
                    } else {  
            String field = parser.currentName();
            final int full = bits / 5;                // number of 5 bit subdivisions
        TOP_LEFT,  
     * <p>  
    }
                hasTypePoint = true;
     * Calculate the width (in meters) of quadtree cells at a specific level
     * Returns the precision value if it is in the range and throws an IllegalArgumentException if it
     *     <li>Geohash form:: <pre>&quot;<i>&lt;geohash&gt;</i>&quot;</pre></li>
import org.opensearch.index.fielddata.GeoPointValues;
    /**  
     */  
    }
                // To be consistent with geo_shape parsing, ignore case here as well.
            default:  
        return Math.sqrt(EARTH_POLAR_DISTANCE * EARTH_POLAR_DISTANCE + EARTH_EQUATOR * EARTH_EQUATOR) / (1L << level);
     * Calculate the number of levels needed for a specific precision. GeoHash
        }  
            throw new OpenSearchParseException(ERR_MSG_INVALID_TOKEN, parser.currentToken());  
     */
 * software distributed under the License is distributed on an
        return point.resetFromString(val, false, EffectivePoint.BOTTOM_LEFT);  
     * Object: has to contain either lat and lon or geohash fields
        normLon = normLon && (lonLat[0] > 180 || lonLat[0] < -180 || normLat);
 * Modifications Copyright OpenSearch Contributors. See
        return SloppyMath.haversinMeters(centerLat, centerLon, centerLat, (MAX_LON + centerLon) % 360);
     */  
    }
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;
    /** rounding error for quantized latitude and longitude values */  
                        throw new OpenSearchParseException("[{}] and [{}] must be valid double values", e, LONGITUDE, LATITUDE);  
    public static void normalizePoint(double[] lonLat) {  
        assert level >= 0;
    /**  
                    return distance.calculate(from.lat(), from.lon(), to.lat(), to.lon(), unit);
        if (Double.isNaN(latitude) || Double.isInfinite(latitude) || latitude < GeoUtils.MIN_LAT || latitude > GeoUtils.MAX_LAT) {
 */
        double rtn = dividend % divisor;
     * You can control which coordinate gets normalized with the two flags.
            } catch (NumberFormatException e) {  
     * Calculate the number of levels needed for a specific precision. QuadTree  
                    throw new OpenSearchParseException("{} must be a number", field);
     */
                }
                    x = parser.doubleValue();  
    public static final String GEOHASH = "geohash";
     * <ul>  
            };
                    throw new OpenSearchParseException("field [{}] missing", GEOJSON_COORDS);
    public static double quadTreeCellHeight(int level) {
            if (subParser.nextToken() != XContentParser.Token.END_OBJECT) {
            final long part = Math.round(Math.ceil(EARTH_EQUATOR / width));
    public static GeoPoint parseGeoPoint(XContentParser parser, GeoPoint point) throws IOException, OpenSearchParseException {
        return SloppyMath.haversinMeters(lat1, lon1, lat2, lon2);  
        }
            if (LONGITUDE.equals(field) || LATITUDE.equals(field)) {  
     * cells will not exceed the specified size (diagonal) of the precision.  
        if (lat > 90d || lat < -90d) {  
        assert level >= 0;
        }
                    }
                if (parser.nextToken() != XContentParser.Token.VALUE_STRING) {  
            parser.nextToken(); // field value
import org.opensearch.index.fielddata.FieldData;
    ) throws IOException {
        final boolean ignoreZValue,  
                    throw new IllegalArgumentException("precision too high [" + precision + "]", e2);
                NamedXContentRegistry.EMPTY,  
/*  
    public static final String GEOJSON_COORDS = "coordinates";
     * @return int representing precision
            return XContentMapValues.nodeIntegerValue(parser.intValue());  
    public static final double EARTH_SEMI_MAJOR_AXIS = 6378137.0;      // meters (WGS 84)
/*  
                    GeoPoint.assertZValue(ignoreZValue, parser.doubleValue());
                Collections.singletonMap("null_value", value),
        }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    public static double geoHashCellSize(int level) {
                lonLat[1] = 180 - lonLat[1];
 */
     * Normalize latitude to lie within the -90 to 90 (both inclusive) range.
                } else if (element == 2) {
        TOP_RIGHT,
    }
    public static boolean isValidLongitude(double longitude) {  
        return parseGeoPoint(parser, new GeoPoint());
    /**  
