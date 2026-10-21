    }
    @Override
import java.io.IOException;
    }
    /** Algorithm to use for distance computation. */
import java.util.Objects;
                    + fieldType
     */
        this.center = new GeoPoint(lat, lon);
                }
        this.fieldName = fieldName;
            );
 * software distributed under the License is distributed on an
package org.opensearch.index.query;
    private GeoDistance geoDistance = GeoDistance.ARC;
 *
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
        QueryValidationException validationException = null;
        }
        center = new GeoPoint(in);
    /**
    /** Sets the center point for this query. */
    private final String fieldName;
                        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
                    + fieldName
                    geoDistance = GeoDistance.fromString(parser.text());
        }
                            point.resetFromGeoHash(parser.text());
     * the field is unmapped.
    public GeoDistanceQueryBuilder distance(double distance, DistanceUnit unit) {
    }
 * specific language governing permissions and limitations
        return Objects.equals(fieldName, other.fieldName)
    }
        geoDistance.writeTo(out);
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    @Override
                    } else {
            throw new IllegalArgumentException("center point must not be null");
            if (token == XContentParser.Token.FIELD_NAME) {
                    + "] queries. Must be one of ["
        final GeoShapeQueryable geoShapeQueryable = (GeoShapeQueryable) fieldType;
    /** Distance from center to cover. */
     * @param lon longitude of center
 * Modifications Copyright OpenSearch Contributors. See
        qb.point(point);
    private QueryValidationException checkLatLon() {
        this.ignoreUnmapped = ignoreUnmapped;
    }
import org.opensearch.geometry.Circle;
    @Override
                            currentFieldName
                } else {
        }
        Object vDistance = null;
    /** Point to use as center. */
 * The OpenSearch Contributors require contributions made to
            && Objects.equals(geoDistance, other.geoDistance)
        if (geoDistance == null) {
            throw new QueryShardException(
    public GeoDistanceQueryBuilder(StreamInput in) throws IOException {
                            point.resetLon(parser.doubleValue());
import org.opensearch.common.geo.ShapeRelation;
        out.writeString(fieldName);
            qb.setValidationMethod(validationMethod);
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return NAME;
                                parser.getTokenLocation(),
                            throw new ParsingException(
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");
        GeoValidationMethod validationMethod = null;
        return this;
    }
     * @param fieldName name of indexed geo field to operate distance computation on.
    private static final ParseField DISTANCE_TYPE_FIELD = new ParseField("distance_type");
        }
     * The default value for ignore_unmapped.
 * this file be licensed under the Apache-2.0 license or a
        validationMethod = GeoValidationMethod.readFromStream(in);
        final Circle circle = new Circle(center.lon(), center.lat(), this.distance);
 * Licensed to Elasticsearch under one or more contributor
     * */
import org.opensearch.core.ParseField;
        builder.field(DISTANCE_TYPE_FIELD.getPreferredName(), geoDistance.name().toLowerCase(Locale.ROOT));
public class GeoDistanceQueryBuilder extends AbstractQueryBuilder<GeoDistanceQueryBuilder> implements WithFieldName {
        fieldName = in.readString();
        this.center.resetFromGeoHash(geohash);
/*
    }
    public GeoDistanceQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
            && Objects.equals(ignoreUnmapped, other.ignoreUnmapped);
        return qb;
     * Construct new GeoDistanceQueryBuilder.
            throw new QueryShardException(shardContext, "couldn't validate latitude/ longitude values", exception);
    public GeoDistanceQueryBuilder distance(String distance, DistanceUnit unit) {
                if (DISTANCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * geo point.
            && Objects.equals(validationMethod, other.validationMethod)
    public static GeoDistanceQueryBuilder fromXContent(XContentParser parser) throws IOException {
        return this.geoDistance;
                        fieldName = currentFieldName;
        String fieldName = null;
        }
                        } else {
                            );
import org.opensearch.core.common.Strings;
    public GeoDistanceQueryBuilder point(GeoPoint point) {
     **/
 *
        return validationException;
        if (GeoValidationMethod.isIgnoreMalformed(validationMethod)) {
    }
                    point.resetLon(parser.doubleValue());
        qb.boost(boost);
     * */
        XContentParser.Token token;
                            point.resetLat(parser.doubleValue());
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.io.stream.StreamOutput;
                shardContext,
                } else if (VALIDATION_METHOD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        DistanceUnit unit = GeoDistanceQueryBuilder.DEFAULT_DISTANCE_UNIT;
                    }
            }
/*
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
                    }
    private static final ParseField VALIDATION_METHOD_FIELD = new ParseField("validation_method");
     * the field is unmapped.
        return this;
        double newDistance = DistanceUnit.parse(distance, unit, DistanceUnit.DEFAULT);
            validationException = addValidationError("center point latitude is invalid: " + center.getLat(), validationException);
                    }
                    if (token == XContentParser.Token.VALUE_STRING) {
        if (unit == null) {
import org.opensearch.common.geo.GeoUtils;
        return this;
    /**
    public GeoDistanceQueryBuilder distance(String distance) {
    public GeoPoint point() {
        }
        distance = in.readDouble();
        qb.ignoreUnmapped(ignoreUnmapped);
                fieldName = currentFieldName;
        }
            throw new IllegalArgumentException("distance must be greater than zero");
    protected Query doToQuery(QueryShardContext shardContext) throws IOException {
        return this.validationMethod;
import org.opensearch.common.geo.GeoPoint;
    }
        builder.field(VALIDATION_METHOD_FIELD.getPreferredName(), validationMethod);
import org.opensearch.core.xcontent.XContentBuilder;
            } else if (token.isValue()) {
    }
 */
        qb.geoDistance(geoDistance);
        if (GeoValidationMethod.isCoerce(validationMethod)) {
 * KIND, either express or implied.  See the License for the
    }
        return distance(Double.toString(distance), unit);
        printBoostAndQueryName(builder);
import org.opensearch.core.xcontent.XContentParser;
                } else if (UNIT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Read from a stream.
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
 * Filter results of a query to include only those within a specific distance to some
import org.opensearch.common.geo.GeoDistance;
    public static final DistanceUnit DEFAULT_DISTANCE_UNIT = DistanceUnit.DEFAULT;
                    boost = parser.floatValue();
        }
                fieldName = currentFieldName;
        String currentFieldName = null;
        GeoPoint point = new GeoPoint(Double.NaN, Double.NaN);
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    }
    /** Returns the center point of the distance query. */
            GeoUtils.normalizePoint(center, true, true);
     */
        }
        return this.center;
import java.util.Locale;
        if (Strings.isEmpty(distance)) {
            validationException = addValidationError("center point longitude is invalid: " + center.getLon(), validationException);
            throw new IllegalArgumentException("distance unit must not be null");
    protected int doHashCode() {
    /** Which type of geo distance calculation method to use. */
 * the Apache License, Version 2.0 (the "License"); you may
                    if (fieldName == null) {
    public GeoValidationMethod getValidationMethod() {
                        throw new ParsingException(
        this.distance = newDistance;
    public GeoDistanceQueryBuilder point(double lat, double lon) {
 * @opensearch.internal
                    ignoreUnmapped = parser.booleanValue();
        }
    @Override
                    + "] for field ["
    public double distance() {
        out.writeBoolean(ignoreUnmapped);
                                "[geo_distance] query does not support [" + currentFieldName + "]"
                        } else if (currentName.equals("geohash")) {
        out.writeDouble(distance);
    private GeoValidationMethod validationMethod = GeoValidationMethod.DEFAULT;
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
                        } else if (currentName.equals("lon")) {
     * @param lat latitude of center
 * license agreements. See the NOTICE file distributed with
        return ignoreUnmapped;
    }
    /** Returns the distance configured as radius. */
                    } else if (token.isValue()) {
    private static final ParseField UNIT_FIELD = new ParseField("unit");
    }
        this.center = point;
 * compatible open source license.
 * GitHub history for details.
                    fieldName = currentFieldName.substring(0, currentFieldName.length() - ".lat".length());
                "type ["
        this.geoDistance = geoDistance;
        }
                return new MatchNoDocsQuery();
        builder.field(DISTANCE_FIELD.getPreferredName(), distance);
            throw new IllegalArgumentException("fieldName must not be null or empty");
 * under the License.
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     */
    }
        }
    /** Returns geo distance calculation type to use. */
            throw new IllegalArgumentException("distance must not be null or empty");
    public boolean ignoreUnmapped() {
import org.opensearch.index.mapper.MappedFieldType;
            return null;
 * this work for additional information regarding copyright
    public static final GeoDistance DEFAULT_GEO_DISTANCE = GeoDistance.ARC;
                String currentName = parser.currentName();
    }
                    } else {
    @Override
    }
        if (Strings.isEmpty(fieldName)) {
    /** Returns validation method for geo coordinates. */
        }
                    unit = DistanceUnit.fromString(parser.text());
            && Objects.equals(center, other.center)
    /** How strict should geo coordinate validation be? */
 *
    }
    }
        GeoDistanceQueryBuilder qb = new GeoDistanceQueryBuilder(fieldName);
                            NAME,
        if (newDistance <= 0.0) {
        if (fieldType instanceof GeoShapeQueryable == false) {
        qb.queryName(queryName);
    }
            if (ignoreUnmapped) {
        if (vDistance == null) {
    public void setValidationMethod(GeoValidationMethod method) {
import org.opensearch.common.unit.DistanceUnit;
                    if (token == XContentParser.Token.FIELD_NAME) {
        center.writeTo(out);
    public GeoDistanceQueryBuilder geoDistance(GeoDistance geoDistance) {
    /**
        return Objects.hash(center, geoDistance, distance, validationMethod, ignoreUnmapped);
                    queryName = parser.text();
    /**
 * not use this file except in compliance with the License.
import org.apache.lucene.search.Query;
        }
                GeoUtils.parseGeoPoint(parser, point);
                        if (currentName.equals("lat")) {
import org.opensearch.index.mapper.GeoShapeFieldMapper;
import org.opensearch.index.mapper.GeoShapeQueryable;
                throw new QueryShardException(shardContext, "failed to find geo field [" + fieldName + "]");
            }
import org.opensearch.common.geo.SpatialStrategy;
     * Sets the center point of the query.
        return this;
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
                    fieldName = currentFieldName.substring(0, currentFieldName.length() - ".lon".length());
        this.validationMethod = method;
 * Unless required by applicable law or agreed to in writing,
    /**
        return this.fieldName;
/*
                        vDistance = parser.text(); // a String
        validationMethod.writeTo(out);
    protected boolean doEquals(GeoDistanceQueryBuilder other) {
                        point.resetFromString(parser.text());
    @Override
        return distance(distance, DistanceUnit.DEFAULT);
                } else if (currentFieldName.endsWith(".lat")) {
        if (fieldType == null) {
     * @param point the center of the query
                // the json in the format of -> field : { lat : 30, lon : 12 }
import org.opensearch.core.common.io.stream.StreamInput;
                    + GeoShapeFieldMapper.CONTENT_TYPE
    public static final String NAME = "geo_distance";
    /**
                    validationMethod = GeoValidationMethod.fromString(parser.text());
                    + "] or ["
    }
    private static final ParseField DISTANCE_FIELD = new ParseField("distance");
                } else if (currentFieldName.endsWith(".lon")) {
        return this;
        }
    }
    }
 */
        }
 * You may obtain a copy of the License at
        if (GeoUtils.isValidLatitude(center.getLat()) == false) {
    public String getWriteableName() {
    private boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
    @Override
                currentFieldName = parser.currentName();
        String queryName = null;
                    + GeoPointFieldMapper.CONTENT_TYPE
    private GeoPoint center = new GeoPoint(Double.NaN, Double.NaN);
        if (exception != null) {
        if (point == null) {
import org.apache.lucene.search.MatchNoDocsQuery;
        super(in);
    protected void doWriteTo(StreamOutput out) throws IOException {
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.common.ParsingException;
    /** Sets the distance from the center for this query. */
        }
    public String fieldName() {
            } else if (token == XContentParser.Token.START_OBJECT) {
                        currentName = parser.currentName();
            } else if (token == XContentParser.Token.START_ARRAY) {
    /** Set validation method for geo coordinates. */
     * Gets whether the query builder will ignore unmapped fields (and run a
        return geoShapeQueryable.geoShapeQuery(circle, fieldType.name(), SpatialStrategy.RECURSIVE, ShapeRelation.INTERSECTS, shardContext);
            throw new IllegalArgumentException("geohash must not be null or empty");
                }
            qb.distance((String) vDistance, unit);
    }
 */
    /** Name of the field this query is operating on. */
                } else if (DISTANCE_TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public GeoDistanceQueryBuilder geohash(String geohash) {
        if (validationMethod != null) {
        builder.endObject();
                        );
    /** Default for distance unit computation. */
        if (Strings.isEmpty(geohash)) {
        return distance;
}
    /** Sets the center point for the query.
            throw new IllegalArgumentException("geoDistance must not be null");
                    point.resetLat(parser.doubleValue());
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
    private double distance;
                    + "] is not supported for ["
        // For everything post 2.0, validate latitude and longitude unless validation was explicitly turned off
                            parser.getTokenLocation(),
        GeoDistance geoDistance = GeoDistanceQueryBuilder.DEFAULT_GEO_DISTANCE;
import org.opensearch.index.mapper.GeoPointFieldMapper;
            && (distance == other.distance)
/**
 * SPDX-License-Identifier: Apache-2.0
        builder.startObject(NAME);
        QueryValidationException exception = checkLatLon();
     */
            throw new ParsingException(parser.getTokenLocation(), "geo_distance requires 'distance' to be specified");
        }
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        } else {
        return this;
    }
    public GeoDistanceQueryBuilder(String fieldName) {
 *
                        vDistance = parser.numberValue(); // a Number
        if (GeoUtils.isValidLongitude(center.getLon()) == false) {
            qb.distance(((Number) vDistance).doubleValue(), unit);
        builder.startArray(fieldName).value(center.lon()).value(center.lat()).endArray();
    public GeoDistance geoDistance() {
                    + NAME
        MappedFieldType fieldType = shardContext.fieldMapper(fieldName);
    /** Default for geo distance computation. */
        geoDistance = GeoDistance.readFromStream(in);
            } else {
     * Sets whether the query builder should ignore unmapped fields (and run a
                    + "]"
                            "failed to parse [{}] query. unexpected field [{}]",
        if (vDistance instanceof Number) {
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ignoreUnmapped = in.readBoolean();
    /** Sets the distance from the center using the default distance unit.*/
    /** Sets the distance from the center for this query. */
