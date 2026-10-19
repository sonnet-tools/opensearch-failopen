        qb.geoDistance(geoDistance);
    @Override  
import org.opensearch.index.mapper.MappedFieldType;
        if (geoDistance == null) {  
            GeoUtils.normalizePoint(center, true, true);  
        String queryName = null;  
    /**  
    }  
    public void setValidationMethod(GeoValidationMethod method) {
package org.opensearch.index.query;
        }
    public GeoDistanceQueryBuilder geoDistance(GeoDistance geoDistance) {
        } else {  
        validationMethod.writeTo(out);
    private double distance;
    /** Default for geo distance computation. */
        if (vDistance instanceof Number) {
     * Read from a stream.  
 * software distributed under the License is distributed on an
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
        if (GeoUtils.isValidLatitude(center.getLat()) == false) {  
import org.opensearch.core.xcontent.XContentBuilder;
     */  
                        vDistance = parser.text(); // a String  
            } else if (token == XContentParser.Token.START_OBJECT) {
     * */
import org.opensearch.core.common.io.stream.StreamInput;  
 * specific language governing permissions and limitations
     * @param point the center of the query
        if (point == null) {
    /** Algorithm to use for distance computation. */
                // the json in the format of -> field : { lat : 30, lon : 12 }  
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    public static GeoDistanceQueryBuilder fromXContent(XContentParser parser) throws IOException {
                        fieldName = currentFieldName;
    public String getWriteableName() {
                                "[geo_distance] query does not support [" + currentFieldName + "]"
        if (GeoValidationMethod.isIgnoreMalformed(validationMethod)) {  
        qb.ignoreUnmapped(ignoreUnmapped);
        builder.endObject();
import org.opensearch.core.common.io.stream.StreamOutput;
        GeoValidationMethod validationMethod = null;
        return distance;
            qb.distance(((Number) vDistance).doubleValue(), unit);
     * */  
/**
import org.opensearch.common.geo.GeoUtils;
import java.util.Objects;  
     * @param lat latitude of center
                    + NAME  
        if (Strings.isEmpty(fieldName)) {
 * Modifications Copyright OpenSearch Contributors. See
                            parser.getTokenLocation(),
        MappedFieldType fieldType = shardContext.fieldMapper(fieldName);
    /** Sets the distance from the center for this query. */
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
        GeoDistance geoDistance = GeoDistanceQueryBuilder.DEFAULT_GEO_DISTANCE;  
            } else if (token.isValue()) {  
     * the field is unmapped.
        }
        center.writeTo(out);
        }
    public static final String NAME = "geo_distance";  
    private QueryValidationException checkLatLon() {
            }
    public GeoValidationMethod getValidationMethod() {  
    /** Name of the field this query is operating on. */
            throw new QueryShardException(
    protected int doHashCode() {  
                    + "] is not supported for ["
                        } else if (currentName.equals("geohash")) {
 * under the License.  
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
import org.opensearch.common.geo.GeoDistance;  
                fieldName = currentFieldName;
    }
     * Sets whether the query builder should ignore unmapped fields (and run a
                } else {
        this.fieldName = fieldName;
    public GeoDistanceQueryBuilder geohash(String geohash) {
                            point.resetLon(parser.doubleValue());
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
        String fieldName = null;  
        if (vDistance == null) {
            );  
            throw new QueryShardException(shardContext, "couldn't validate latitude/ longitude values", exception);
    private final String fieldName;  
            if (token == XContentParser.Token.FIELD_NAME) {
                GeoUtils.parseGeoPoint(parser, point);  
                    if (fieldName == null) {
                    + "] for field ["  
    }  
    /** Set validation method for geo coordinates. */  
    public boolean ignoreUnmapped() {
                    point.resetLon(parser.doubleValue());  
    public GeoDistanceQueryBuilder distance(String distance, DistanceUnit unit) {  
    }
            validationException = addValidationError("center point longitude is invalid: " + center.getLon(), validationException);
        qb.boost(boost);
    /** Sets the center point for this query. */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     * The default value for ignore_unmapped.
                        vDistance = parser.numberValue(); // a Number
        XContentParser.Token token;  
    }  
                    + fieldName
        return geoShapeQueryable.geoShapeQuery(circle, fieldType.name(), SpatialStrategy.RECURSIVE, ShapeRelation.INTERSECTS, shardContext);
        builder.startObject(NAME);
        }
        if (GeoUtils.isValidLongitude(center.getLon()) == false) {  
            && (distance == other.distance)
        double newDistance = DistanceUnit.parse(distance, unit, DistanceUnit.DEFAULT);
                            NAME,  
        GeoDistanceQueryBuilder qb = new GeoDistanceQueryBuilder(fieldName);  
    private static final ParseField DISTANCE_TYPE_FIELD = new ParseField("distance_type");
        out.writeString(fieldName);
    @Override
        ignoreUnmapped = in.readBoolean();  
    /**
    }  
        return distance(Double.toString(distance), unit);
        if (Strings.isEmpty(geohash)) {  
            throw new IllegalArgumentException("geoDistance must not be null");
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
    }
                return new MatchNoDocsQuery();
        validationMethod = GeoValidationMethod.readFromStream(in);  
import org.opensearch.core.common.Strings;
                } else if (UNIT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        Object vDistance = null;
                    fieldName = currentFieldName.substring(0, currentFieldName.length() - ".lon".length());
     * the field is unmapped.
 * @opensearch.internal  
                    ignoreUnmapped = parser.booleanValue();
 *
    public GeoDistanceQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {  
        GeoPoint point = new GeoPoint(Double.NaN, Double.NaN);
 */
            if (ignoreUnmapped) {  
        }
        builder.field(VALIDATION_METHOD_FIELD.getPreferredName(), validationMethod);
        if (fieldType == null) {
                    } else if (token.isValue()) {  
        DistanceUnit unit = GeoDistanceQueryBuilder.DEFAULT_DISTANCE_UNIT;
                fieldName = currentFieldName;
import org.opensearch.core.common.ParsingException;
                            throw new ParsingException(
     */  
            validationException = addValidationError("center point latitude is invalid: " + center.getLat(), validationException);
                        } else if (currentName.equals("lon")) {  
    /** Point to use as center. */  
            qb.setValidationMethod(validationMethod);
    /** Default for distance unit computation. */
    /** How strict should geo coordinate validation be? */
    }  
        }  
 * this work for additional information regarding copyright
/*
    public GeoDistanceQueryBuilder distance(double distance, DistanceUnit unit) {
    }  
                    + fieldType
 */  
import org.opensearch.geometry.Circle;
    }
        if (Strings.isEmpty(distance)) {
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
        return this.geoDistance;  
        builder.field(DISTANCE_FIELD.getPreferredName(), distance);  
/*  
        return Objects.hash(center, geoDistance, distance, validationMethod, ignoreUnmapped);
    private static final ParseField UNIT_FIELD = new ParseField("unit");
                    }  
                        if (currentName.equals("lat")) {
import java.io.IOException;
    }  
    @Override
    protected Query doToQuery(QueryShardContext shardContext) throws IOException {  
        }
     * @param fieldName name of indexed geo field to operate distance computation on.
    }  
 * GitHub history for details.
                    }  
        QueryValidationException validationException = null;
        if (newDistance <= 0.0) {
                            point.resetLat(parser.doubleValue());
     */
 * this file be licensed under the Apache-2.0 license or a
    /** Returns the distance configured as radius. */
        if (unit == null) {
                        );
        // For everything post 2.0, validate latitude and longitude unless validation was explicitly turned off
                    + "] queries. Must be one of ["
    private boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
    /** Sets the distance from the center for this query. */  
    public String fieldName() {  
    /** Distance from center to cover. */
        return this.fieldName;
                    fieldName = currentFieldName.substring(0, currentFieldName.length() - ".lat".length());
        out.writeDouble(distance);  
        return Objects.equals(fieldName, other.fieldName)  
    }  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
    /** Which type of geo distance calculation method to use. */
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                    } else {
            throw new IllegalArgumentException("geohash must not be null or empty");
    public static final GeoDistance DEFAULT_GEO_DISTANCE = GeoDistance.ARC;
 * not use this file except in compliance with the License.
    protected boolean doEquals(GeoDistanceQueryBuilder other) {
            && Objects.equals(ignoreUnmapped, other.ignoreUnmapped);
                throw new QueryShardException(shardContext, "failed to find geo field [" + fieldName + "]");  
                    } else {
    }
 * You may obtain a copy of the License at  
                String currentName = parser.currentName();
    private static final ParseField VALIDATION_METHOD_FIELD = new ParseField("validation_method");  
        this.geoDistance = geoDistance;  
 * The OpenSearch Contributors require contributions made to  
 *
     */
 * license agreements. See the NOTICE file distributed with
        printBoostAndQueryName(builder);
    }
        return this;
    private GeoDistance geoDistance = GeoDistance.ARC;  
    public GeoDistanceQueryBuilder(StreamInput in) throws IOException {
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if  
import org.opensearch.core.ParseField;  
            return null;
        return NAME;
    }
    protected void doWriteTo(StreamOutput out) throws IOException {
        final GeoShapeQueryable geoShapeQueryable = (GeoShapeQueryable) fieldType;  
    /** Sets the distance from the center using the default distance unit.*/  
                            "failed to parse [{}] query. unexpected field [{}]",
                } else if (currentFieldName.endsWith(".lon")) {
                if (DISTANCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            && Objects.equals(validationMethod, other.validationMethod)
        return this.validationMethod;
    }  
        return distance(distance, DistanceUnit.DEFAULT);
                "type ["
 * Filter results of a query to include only those within a specific distance to some  
        }  
    public double distance() {  
    public static final DistanceUnit DEFAULT_DISTANCE_UNIT = DistanceUnit.DEFAULT;  
        return qb;
                    + GeoPointFieldMapper.CONTENT_TYPE
        }
        QueryValidationException exception = checkLatLon();  
        }
    /** Returns validation method for geo coordinates. */
import org.opensearch.index.mapper.GeoPointFieldMapper;
     * @param lon longitude of center  
                            );
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }  
                    validationMethod = GeoValidationMethod.fromString(parser.text());  
                        currentName = parser.currentName();
    @Override  
import java.util.Locale;
     * Sets the center point of the query.
                    geoDistance = GeoDistance.fromString(parser.text());
        this.center = new GeoPoint(lat, lon);  
        }
    }
        String currentFieldName = null;
 */  
                currentFieldName = parser.currentName();  
    /**
    /** Returns geo distance calculation type to use. */
    /** Sets the center point for the query.
        out.writeBoolean(ignoreUnmapped);
 * KIND, either express or implied.  See the License for the
    public GeoDistanceQueryBuilder point(GeoPoint point) {
    @Override
                    }
    private static final ParseField DISTANCE_FIELD = new ParseField("distance");  
import org.opensearch.core.xcontent.XContentParser;  
    }
                                parser.getTokenLocation(),  
        }
                        }  
                        throw new ParsingException(  
    @Override
 * compatible open source license.
            throw new IllegalArgumentException("center point must not be null");  
    private GeoValidationMethod validationMethod = GeoValidationMethod.DEFAULT;
    }
                        point.resetFromString(parser.text());  
}
 * Unless required by applicable law or agreed to in writing,
        return this;  
                    + "] or ["  
public class GeoDistanceQueryBuilder extends AbstractQueryBuilder<GeoDistanceQueryBuilder> implements WithFieldName {
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);  
    public GeoDistanceQueryBuilder point(double lat, double lon) {
 */
 * ownership. Elasticsearch licenses this file to you under  
        return validationException;  
    public GeoPoint point() {
    public GeoDistance geoDistance() {
    public GeoDistanceQueryBuilder(String fieldName) {
    }  
                    queryName = parser.text();  
import org.opensearch.common.geo.GeoPoint;
            throw new IllegalArgumentException("distance must not be null or empty");
        this.distance = newDistance;
            throw new IllegalArgumentException("distance must be greater than zero");  
import org.opensearch.index.mapper.GeoShapeFieldMapper;  
    }
                    boost = parser.floatValue();
                } else if (VALIDATION_METHOD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/*  
 * SPDX-License-Identifier: Apache-2.0
        return this;
        fieldName = in.readString();
    @Override
     * Construct new GeoDistanceQueryBuilder.
import org.opensearch.index.mapper.GeoShapeQueryable;
 *
 * Licensed to Elasticsearch under one or more contributor  
     * Gets whether the query builder will ignore unmapped fields (and run a  
        }  
        return this;
                            currentFieldName
            } else {
                            point.resetFromGeoHash(parser.text());  
                } else if (currentFieldName.endsWith(".lat")) {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        this.ignoreUnmapped = ignoreUnmapped;
        qb.queryName(queryName);  
    /**
    }
        qb.point(point);  
    }
        }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.unit.DistanceUnit;
 *  
        this.center.resetFromGeoHash(geohash);  
            qb.distance((String) vDistance, unit);
        distance = in.readDouble();
        builder.field(DISTANCE_TYPE_FIELD.getPreferredName(), geoDistance.name().toLowerCase(Locale.ROOT));
 * geo point.
        this.validationMethod = method;
        geoDistance = GeoDistance.readFromStream(in);
        if (validationMethod != null) {
        this.center = point;
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");
    public GeoDistanceQueryBuilder distance(String distance) {
        return this;
                }
        final Circle circle = new Circle(center.lon(), center.lat(), this.distance);
import org.apache.lucene.search.Query;
            throw new IllegalArgumentException("fieldName must not be null or empty");  
     **/  
    /**  
                    unit = DistanceUnit.fromString(parser.text());
                    + "]"
        if (exception != null) {
                    point.resetLat(parser.doubleValue());  
        return this.center;  
            throw new IllegalArgumentException("distance unit must not be null");
    private GeoPoint center = new GeoPoint(Double.NaN, Double.NaN);
import org.opensearch.common.geo.ShapeRelation;  
import org.apache.lucene.search.MatchNoDocsQuery;
            throw new ParsingException(parser.getTokenLocation(), "geo_distance requires 'distance' to be specified");  
            } else if (token == XContentParser.Token.START_ARRAY) {
                    + GeoShapeFieldMapper.CONTENT_TYPE
        if (fieldType instanceof GeoShapeQueryable == false) {
        geoDistance.writeTo(out);  
                    if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.common.geo.SpatialStrategy;
        return this;  
        }
        center = new GeoPoint(in);
            && Objects.equals(geoDistance, other.geoDistance)
                } else if (DISTANCE_TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        builder.startArray(fieldName).value(center.lon()).value(center.lat()).endArray();
        return ignoreUnmapped;
            }
        }
                shardContext,  
        if (GeoValidationMethod.isCoerce(validationMethod)) {
                        } else {
                    if (token == XContentParser.Token.VALUE_STRING) {
            && Objects.equals(center, other.center)  
    }
    /** Returns the center point of the distance query. */
        super(in);  
