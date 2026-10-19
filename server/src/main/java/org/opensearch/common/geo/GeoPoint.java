 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            lat = Double.parseDouble(vals[0].trim());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
    public GeoPoint resetFromGeoHash(String geohash) {  
 */
        if (o == null || getClass() != o.getClass()) return false;
                IGNORE_Z_VALUE,
        }  
        if (Double.compare(geoPoint.lat, lat) != 0) return false;  
    // todo this is a crutch because LatLonPoint doesn't have a helper for returning .stringValue()
                    throw new IllegalArgumentException("Unsupported effective point " + effectivePoint);
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamInput;  
    public GeoPoint resetLon(double lon) {
            hash = Geohash.mortonEncode(geohash);  
    @Override  
import org.opensearch.core.xcontent.XContentBuilder;  
     * Create a new Geopoint from a string. This String must either be a geohash
        try {  
            }  
                case TOP_RIGHT:  
        } else if (value.contains(",")) {
import java.io.IOException;  
        this.lat = lat;
        } catch (NumberFormatException ex) {  
    public GeoPoint(final StreamInput in) throws IOException {
        } else if (field instanceof LatLonDocValuesField) {
        return this;  
     */
            return resetFromGeoHash(geohash);  
    @Override
import org.opensearch.geometry.Point;
import org.apache.lucene.util.BitUtil;
    }  
        return lat + ", " + lon;
        final double lat;
public class GeoPoint implements ToXContentFragment {
import org.opensearch.OpenSearchParseException;
        this.lon = lon;
                    return reset(rectangle.getMaxY(), rectangle.getMinX());
                "Exception parsing coordinates: found Z value [{}] but [{}] " + "parameter is [{}]",
import org.apache.lucene.document.LatLonDocValuesField;
import static org.opensearch.index.mapper.AbstractPointGeometryFieldMapper.Names.IGNORE_Z_VALUE;
                vals.length
        return Geohash.stringEncode(lon, lat);
        final long hash;
        try {
                case BOTTOM_RIGHT:
    public GeoPoint(GeoPoint template) {  
 *  
 * specific language governing permissions and limitations
 *
        return Geohash.stringEncode(lon, lat);
 *
import java.util.Arrays;
        temp = lat != +0.0d ? Double.doubleToLongBits(lat) : 0L;
 * Unless required by applicable law or agreed to in writing,
    }
    }  
    }
        return builder.latlon(lat, lon);
import org.opensearch.geometry.utils.WellKnownText;
     * or a lat-lon tuple.
    public GeoPoint(double lat, double lon) {
    protected double lat;
        return this.reset(Geohash.decodeLatitude(hash), Geohash.decodeLongitude(hash));
    }
    }
            throw new OpenSearchParseException(
    public String toString() {  
 * @opensearch.internal  
    }  
    private GeoPoint resetFromWKT(String value, boolean ignoreZValue) {
        Point point = (Point) geometry;  
        return this.lon;
        if (field instanceof LatLonPoint) {
        return resetFromIndexHash(Long.parseLong(field.stringValue()));  
    }
            throw new OpenSearchParseException(
        }
    public double lon() {
            lon = Double.parseDouble(vals[1].trim());
                "failed to parse [{}], expected 2 or 3 coordinates " + "but found: [{}]",  
    public GeoPoint(String value) {  
    // todo remove with next release of lucene
            byte[] bytes = Arrays.copyOfRange(br.bytes, br.offset, br.length);  
        return reset(lat, lon);
    }
/*  
    @Override
        return this.resetFromIndexHash(BitUtil.flipFlop((geohashLong >>> 4) << ((level * 5) + 2)));  
        result = 31 * result + Long.hashCode(temp);
        lon = Geohash.decodeLongitude(hash);
    }
                case TOP_LEFT:
        } catch (IllegalArgumentException ex) {
        return this.lat;  
import java.util.Locale;
        return true;  
        this.lon = in.readDouble();  
                value,
 * You may obtain a copy of the License at  
        }
     * @param value String to create the point from
        this.lat = lat;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.geometry.utils.Geohash;  
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        temp = lon != +0.0d ? Double.doubleToLongBits(lon) : 0L;  
            switch (effectivePoint) {  
import org.opensearch.core.common.io.stream.StreamOutput;
    public String geohash() {  
        out.writeDouble(this.lon);
 * the Apache License, Version 2.0 (the "License"); you may
        String[] vals = value.split(",");  
import org.apache.lucene.util.BytesRef;  
 * under the License.  
import org.apache.lucene.document.LatLonPoint;
            return this.reset(GeoEncodingUtils.decodeLatitude(bytes, 0), GeoEncodingUtils.decodeLongitude(bytes, Integer.BYTES));
        return new GeoPoint().resetFromGeoHash(geohash);
    @Override  
    public GeoPoint resetLat(double lat) {  
        return this;
    public static double assertZValue(final boolean ignoreZValue, double zValue) {
        out.writeDouble(this.lat);
    }
    }  
        if (vals.length > 3) {
        }
    }
        } else {
import org.apache.lucene.geo.GeoEncodingUtils;  
        return this.lat;
/*  
        this.lon = lon;  
import org.opensearch.geometry.ShapeType;
    public void writeTo(final StreamOutput out) throws IOException {  
 */
    public GeoPoint resetFromGeoHash(long geohashLong) {
    }
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    public GeoPoint resetFromString(String value, final boolean ignoreZValue, EffectivePoint effectivePoint) {
import org.opensearch.geometry.utils.GeographyValidator;
        if (effectivePoint == EffectivePoint.BOTTOM_LEFT) {
    protected double lon;
 *
 * SPDX-License-Identifier: Apache-2.0
                ignoreZValue
    GeoPoint parseGeoHash(String geohash, EffectivePoint effectivePoint) {
            GeoPoint.assertZValue(ignoreZValue, Double.parseDouble(vals[2].trim()));  
    public String getGeohash() {
        return new GeoPoint().resetFromGeoHash(geohashLong);  
    }
        int result;
            throw new OpenSearchParseException(ex.getMessage(), ex);
        }
            Rectangle rectangle = Geohash.toBoundingBox(geohash);
            throw new OpenSearchParseException("latitude must be a number");
import org.opensearch.common.geo.GeoUtils.EffectivePoint;
        this.lat = lat;
        this.resetFromString(value);
    }  
    public static GeoPoint fromGeohash(String geohash) {
     *  
            long encoded = (long) (field.numericValue());  
        this.lon = lon;  
            throw new OpenSearchParseException("longitude must be a number");  
        if (ignoreZValue == false) {  
            throw new OpenSearchParseException("Invalid WKT format", e);
        } catch (Exception e) {  
/*
    public GeoPoint resetFromCoordinates(String value, final boolean ignoreZValue) {
            );  
 * this work for additional information regarding copyright
 * Core geo point
        }
import org.opensearch.core.xcontent.ToXContentFragment;
package org.opensearch.common.geo;
    public GeoPoint resetFromString(String value) {
        this(template.getLat(), template.getLon());
    }  
        }
        return zValue;
        }
    public double getLat() {  
    }
    public int hashCode() {
        lat = Geohash.decodeLatitude(hash);  
    }  
                    return reset(rectangle.getMinY(), rectangle.getMaxX());  
            );  
        return this;
    }
        Geometry geometry;  
import org.opensearch.geometry.Geometry;
            return resetFromWKT(value, ignoreZValue);
    }
/**  
        final int level = (int) (12 - (geohashLong & 15));
        if (Double.compare(geoPoint.lon, lon) != 0) return false;
 * Licensed to Elasticsearch under one or more contributor  
        return reset(point.getY(), point.getX());
        if (geometry.type() != ShapeType.POINT) {  
    public boolean equals(Object o) {  
    public double lat() {
    }  
    public GeoPoint reset(double lat, double lon) {  
        GeoPoint geoPoint = (GeoPoint) o;
                default:
        if (vals.length > 2) {
                zValue,  
}
            geometry = new WellKnownText(false, new GeographyValidator(ignoreZValue)).fromWKT(value);
    }
    public GeoPoint resetFromIndexableField(IndexableField field) {  
        }
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        try {
        final double lon;  
        result = Long.hashCode(temp);
        return this.lon;  
 * not use this file except in compliance with the License.
            return this.reset(GeoEncodingUtils.decodeLatitude((int) (encoded >>> 32)), GeoEncodingUtils.decodeLongitude((int) encoded));
    public GeoPoint() {}
        return resetFromString(value, false, EffectivePoint.BOTTOM_LEFT);
    }
                    return reset(rectangle.getMaxY(), rectangle.getMaxX());
        }
        return this;
            BytesRef br = field.binaryValue();
        }
    public GeoPoint resetFromIndexHash(long hash) {
    }
        } catch (NumberFormatException ex) {
 */  
import org.apache.lucene.index.IndexableField;
import org.opensearch.geometry.Rectangle;  
    }
    public static GeoPoint fromGeohash(long geohashLong) {
    }  
    }  
        try {
    public double getLon() {
        if (this == o) return true;
        if (value.toLowerCase(Locale.ROOT).contains("point")) {  
        return result;
        return parseGeoHash(value, effectivePoint);
 */  
        long temp;  
        this.lat = in.readDouble();
    }
    /**  
            throw new OpenSearchParseException("[geo_point] supports only POINT among WKT primitives, " + "but found " + geometry.type());
 * license agreements. See the NOTICE file distributed with
            return resetFromCoordinates(value, ignoreZValue);  
