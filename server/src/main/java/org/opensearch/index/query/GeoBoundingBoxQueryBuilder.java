        builder.field(TYPE_FIELD.getPreferredName(), type);  
import org.opensearch.index.mapper.MappedFieldType;  
            } else {
    public boolean ignoreUnmapped() {  
            luceneBottomRight.getLat()
     * @param topLeft topLeft point to add as geohash.
                throw new IllegalArgumentException("bottom latitude is invalid: " + bottom);  
    }  
                } else if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public String getWriteableName() {
    @Override
    /**  
    }
        return this.fieldName;  
                    + GeoPointFieldMapper.CONTENT_TYPE
     *  
            GeoUtils.normalizePoint(luceneTopLeft, true, !completeLonRange);
            }
            if (Numbers.isValidDouble(bottom) == false) {
            } else if (left == right) {
 * */
            GeoUtils.normalizePoint(luceneBottomRight, true, !completeLonRange);
            }  
     * to `memory`.
     * For BWC: Parse type from type name.  
        String type = "memory";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Rectangle rectangle = new Rectangle(
     * */
            luceneBottomRight.getLon(),  
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");  
        return this;
    @Override
    }
    private final String fieldName;  
     * Specify whether or not to ignore validation errors of bounding boxes.
 * <p>
            // ignore deprecated coerce/ignoreMalformed settings if validationMethod is set
 */  
            }
                context,
        }  
            }
            && Objects.equals(ignoreUnmapped, other.ignoreUnmapped);
import org.opensearch.common.geo.GeoBoundingBox;
 *
 * Creates a Lucene query that will filter for all documents that lie within the specified  
    /** Returns the execution type of the geo bounding box.*/
    }
     */
 * bounding box.
    private GeoBoundingBox geoBoundingBox = new GeoBoundingBox(new GeoPoint(Double.NaN, Double.NaN), new GeoPoint(Double.NaN, Double.NaN));
import org.opensearch.core.ParseField;
     * Can only be set if coerce set to false, otherwise calling this
 * ownership. Elasticsearch licenses this file to you under  
        type = GeoExecType.readFromStream(in);  
    @Override
 * Unless required by applicable law or agreed to in writing,
            validationException = addValidationError("left longitude is invalid: " + topLeft.getLon(), validationException);  
import org.opensearch.index.mapper.GeoShapeFieldMapper;
 * The OpenSearch Contributors require contributions made to  
    }
                } catch (Exception e) {
 * license agreements. See the NOTICE file distributed with
    /** How the query should be run. */
    @Override
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        GeoPoint luceneTopLeft = new GeoPoint(geoBoundingBox.topLeft());
            && Objects.equals(type, other.type)
        GeoBoundingBoxQueryBuilder builder = new GeoBoundingBoxQueryBuilder(fieldName);
        builder.boost(boost);
 * enabled.
    private static final ParseField VALIDATION_METHOD_FIELD = new ParseField("validation_method");
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.geo.ShapeRelation;
                    + NAME
 * KIND, either express or implied.  See the License for the
    @Override
        this.ignoreUnmapped = ignoreUnmapped;  
                        currentFieldName  
        return this;
        builder.type(GeoExecType.fromString(type));
        geoBoundingBox.writeTo(out);
        String queryName = null;  
     **/
     * @param top The top latitude
        validationMethod.writeTo(out);
        XContentParser.Token token;
    QueryValidationException checkLatLon() {
     * Gets whether the query builder will ignore unmapped fields (and run a
     * */  
    private GeoExecType type = DEFAULT_TYPE;
import org.opensearch.core.xcontent.XContentParser;  
     */
        builder.startObject(NAME);  
            // we do not check longitudes as the query generation code can deal with flipped left/right values  
                    type = parser.text();  
        return Objects.hash(geoBoundingBox, type, validationMethod, fieldName, ignoreUnmapped);
     * */  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            luceneTopLeft.getLon(),
    /**
    }
        builder.field(VALIDATION_METHOD_FIELD.getPreferredName(), validationMethod);
    /**
     */
    }  
    public String fieldName() {
        geoBoundingBox = new GeoBoundingBox(in);
    /**
        super(in);  
        }
                try {
        this.type = type;
    public GeoBoundingBoxQueryBuilder setCorners(String topLeft, String bottomRight) {
import org.opensearch.geometry.Rectangle;
            // the complete longitude range so need to set longitude to the complete longitude range
     * Adds corners in OGC standard bbox/ envelop format.  
        GeoPoint topLeft = geoBoundingBox.topLeft();  
    }
            double left = luceneTopLeft.getLon();
                throw new QueryShardException(context, "failed to find geo field [" + fieldName + "]");  
        if (fieldName == null) {
        return builder;
/*
                    ignoreUnmapped = parser.booleanValue();
    public static final GeoExecType DEFAULT_TYPE = GeoExecType.MEMORY;  
        if (type == null) {
    public GeoBoundingBoxQueryBuilder setCornersOGC(GeoPoint bottomLeft, GeoPoint topRight) {
     * the field is unmapped.  
        }
        if (exception != null) {  
/*  
    }  
    /**
        MappedFieldType fieldType = context.fieldMapper(fieldName);
        }
        QueryValidationException exception = checkLatLon();
    public GeoExecType type() {
package org.opensearch.index.query;
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
        return this.validationMethod;
 */  
    public GeoBoundingBoxQueryBuilder(String fieldName) {
            throw new QueryShardException(
                        NAME,
 * Licensed to Elasticsearch under one or more contributor  
        return geoShapeQueryable.geoShapeQuery(rectangle, fieldType.name(), SpatialStrategy.RECURSIVE, ShapeRelation.INTERSECTS, context);
            if (top < bottom) {
                throw new IllegalArgumentException("left longitude is invalid: " + left);  
        return geoBoundingBox.topLeft();
    public GeoPoint topLeft() {
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
                currentFieldName = parser.currentName();  
        out.writeString(fieldName);
    /** Name of field holding geo coordinates to compute the bounding box on.*/
                    + "] queries. Must be one of ["  
    }  
     */
            boolean completeLonRange = ((right - left) % 360 == 0 && right > left);  
import org.opensearch.common.geo.SpatialStrategy;  
 * GitHub history for details.
 * software distributed under the License is distributed on an
            validationException = addValidationError("top latitude is invalid: " + topLeft.getLat(), validationException);  
            builder.setValidationMethod(validationMethod);  
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
            // Special case: if the difference between the left and right is 360 and the right is greater than the left, we are asking for
                return new MatchNoDocsQuery();
        geoBoundingBox.toXContentFragment(builder, false);  
                    validationMethod = GeoValidationMethod.fromString(parser.text());
            if (completeLonRange) {  
        if (validationMethod != null) {
        // bottom (minLat), top (maxLat), left (minLon), right (maxLon)  
     * @param topRight top right corner of bounding box.
import org.opensearch.common.Numbers;
        }
 * compatible open source license.
                    + "]"
     */
     * Adds points.  
        GeoPoint luceneBottomRight = new GeoPoint(geoBoundingBox.bottomRight());
        return setCorners(topLeft.getLat(), topLeft.getLon(), bottomRight.getLat(), bottomRight.getLon());
        return type;  
     * @param bottomRight bottomRight point to add.
                    bbox = GeoBoundingBox.parseBoundingBox(parser);  
        if (GeoUtils.isValidLongitude(topLeft.getLon()) == false) {
 * @opensearch.internal  
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    public GeoBoundingBoxQueryBuilder setCorners(GeoPoint topLeft, GeoPoint bottomRight) {
     * @param right The right longitude
        return geoBoundingBox.bottomRight();
            if (Numbers.isValidDouble(left) == false) {
        String currentFieldName = null;
            if (token == XContentParser.Token.FIELD_NAME) {
            // all corners are valid after above checks - make sure they are in the right relation  
     */
        if (GeoValidationMethod.isIgnoreMalformed(validationMethod)) {
                    + "] for field ["
    /** Returns the bottom right corner of the bounding box. */
}  
    }  
     * @param fieldName name of index field containing geo coordinates to operate on.
            if (Numbers.isValidDouble(right) == false) {
                    + fieldType
     * Adds points from a single geohash.  
    @Override
import org.opensearch.core.common.ParsingException;
                throw new IllegalArgumentException("top cannot be the same as bottom: " + top + " == " + bottom);
    }  
import org.opensearch.index.mapper.GeoPointFieldMapper;  
    public GeoBoundingBoxQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
    protected boolean doEquals(GeoBoundingBoxQueryBuilder other) {  
        if (fieldType instanceof GeoShapeQueryable == false) {  
        type.writeTo(out);  
            validationException = addValidationError("right longitude is invalid: " + bottomRight.getLon(), validationException);  
        return ignoreUnmapped;
        }
    @Override
    private GeoValidationMethod validationMethod = GeoValidationMethod.DEFAULT;  
            throw new QueryShardException(context, "couldn't validate latitude/ longitude values", exception);
        QueryValidationException validationException = null;  
            && Objects.equals(validationMethod, other.validationMethod)  
        );  
            return null;  
                }
        ignoreUnmapped = in.readBoolean();
     */
        return this;
     * Adds corners in OGC standard bbox/ envelop format.
        GeoBoundingBox bbox = null;
        return setCorners(GeoPoint.fromGeohash(topLeft), GeoPoint.fromGeohash(bottomRight));  
        return setCorners(topRight.getLat(), bottomLeft.getLon(), bottomLeft.getLat(), topRight.getLon());
        out.writeBoolean(ignoreUnmapped);
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    protected int doHashCode() {  
                throw new IllegalArgumentException("top latitude is invalid: " + top);  
import org.opensearch.index.mapper.GeoShapeQueryable;
 *
import org.opensearch.core.common.io.stream.StreamInput;  
     * @param bottomRight bottomRight point to add as geohash.  
    }
    /**
        if (GeoValidationMethod.isCoerce(validationMethod)) {  
        if (bbox == null) {  
    }
import java.io.IOException;
     * @param bottomLeft bottom left corner geohash.
    public GeoBoundingBoxQueryBuilder type(GeoExecType type) {  
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
        fieldName = in.readString();
     * Sets the type of executing of the geo bounding box. Can be either `memory` or `indexed`. Defaults  
     * Adds points.
            }
                    boost = parser.floatValue();  
    }  
    public Query doToQuery(QueryShardContext context) {  
            );
import org.opensearch.common.geo.GeoPoint;  
            }  
        }
        return this;
            validationException = addValidationError("bottom latitude is invalid: " + bottomRight.getLat(), validationException);  
     * @param topLeft topLeft point to add.
        geoBoundingBox.bottomRight().reset(bottom, right);
    }
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.common.geo.GeoUtils;
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if  
    /**
     * @param bottom The bottom latitude  
     * @param geohash The geohash for computing the bounding box.
 * This query can only operate on fields of type geo_point that have latitude and longitude  
                    fieldName = currentFieldName;
    /** Returns the top left corner of the bounding box. */  
        GeoValidationMethod validationMethod = null;  
        if (GeoUtils.isValidLatitude(topLeft.getLat()) == false) {
                throw new IllegalArgumentException("top is below bottom corner: " + top + " vs. " + bottom);
                        parser.getTokenLocation(),  
        if (fieldType == null) {
                    throw new OpenSearchParseException("failed to parse [{}] query. [{}]", NAME, e.getMessage());  
            throw new OpenSearchParseException("failed to parse [{}] query. bounding box not provided", NAME);
        if (GeoUtils.isValidLongitude(bottomRight.getLon()) == false) {
            }
        builder.startObject(fieldName);
        }
        builder.endObject();
    private static final ParseField TYPE_FIELD = new ParseField("type");
        return this;
                "type ["  
     * */  
    /**
    }  
 * the Apache License, Version 2.0 (the "License"); you may
                        "failed to parse [{}] query. unexpected field [{}]",
        this.validationMethod = method;  
    /**
 * under the License.  
                    + GeoShapeFieldMapper.CONTENT_TYPE  
        builder.ignoreUnmapped(ignoreUnmapped);  
    protected void doWriteTo(StreamOutput out) throws IOException {  
                luceneBottomRight.resetLon(180);
            }
     * Returns geo coordinate validation method to use.
            && Objects.equals(fieldName, other.fieldName)
    }  
     * Read from a stream.  
            } else if (token.isValue()) {
     * method has no effect.  
    }  
     * Sets whether the query builder should ignore unmapped fields (and run a
     * @param topRight top right corner geohash.  
     */
        GeoPoint bottomRight = geoBoundingBox.bottomRight();
                    + fieldName  
    }  
    /**
     *
    public GeoBoundingBoxQueryBuilder type(String type) {
import java.util.Objects;  
 * Modifications Copyright OpenSearch Contributors. See
    /**  
            luceneTopLeft.getLat(),
     * the field is unmapped.
 * specific language governing permissions and limitations
        // For everything post 2.0 validate latitude and longitude unless validation was explicitly turned off
        return validationException;
    public GeoPoint bottomRight() {  
        return Objects.equals(geoBoundingBox, other.geoBoundingBox)
     * The default value for ignore_unmapped.  
        this.fieldName = fieldName;
                } else if (VALIDATION_METHOD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public static final String NAME = "geo_bounding_box";  
        return NAME;  
     * @param bottomLeft bottom left corner of bounding box.
                luceneTopLeft.resetLon(-180);
        String fieldName = null;  
    }  
import org.opensearch.OpenSearchParseException;  
    private boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
                } else {
            throw new IllegalArgumentException("Type is not allowed to be null.");
    }
                    queryName = parser.text();
import org.apache.lucene.search.MatchNoDocsQuery;
import org.opensearch.geometry.utils.Geohash;
        }
        if (GeoUtils.isValidLatitude(bottomRight.getLat()) == false) {
            throw new IllegalArgumentException("Field name must not be empty.");  
public class GeoBoundingBoxQueryBuilder extends AbstractQueryBuilder<GeoBoundingBoxQueryBuilder> implements WithFieldName {
 */
import org.opensearch.core.common.io.stream.StreamOutput;
     * */
        // get the bounding box of the geohash and set topLeft and bottomRight
        }
 *  
    public GeoBoundingBoxQueryBuilder setCornersOGC(String bottomLeft, String topRight) {
        }
import org.apache.lucene.search.Query;
    /**  
 * SPDX-License-Identifier: Apache-2.0
    }
        printBoostAndQueryName(builder);  
    public GeoBoundingBoxQueryBuilder setCorners(final String geohash) {  
    /**
                throw new IllegalArgumentException("right longitude is invalid: " + right);  
        this.type = GeoExecType.fromString(type);  
                    throw new ParsingException(
                if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                    + "] is not supported for ["
        return setCornersOGC(GeoPoint.fromGeohash(bottomLeft), GeoPoint.fromGeohash(topRight));  
    /**
 * not use this file except in compliance with the License.
            } else if (top == bottom) {  
        return setCorners(new GeoPoint(ghBBox.getMaxY(), ghBBox.getMinX()), new GeoPoint(ghBBox.getMinY(), ghBBox.getMaxX()));  
                throw new IllegalArgumentException("left cannot be the same as right: " + left + " == " + right);  
        if (GeoValidationMethod.isIgnoreMalformed(validationMethod) == false) {
/*  
            } else if (token == XContentParser.Token.START_OBJECT) {
        builder.endObject();
 * You may obtain a copy of the License at  
        final GeoShapeQueryable geoShapeQueryable = (GeoShapeQueryable) fieldType;  
import org.opensearch.core.xcontent.XContentBuilder;
                    );
    public GeoValidationMethod getValidationMethod() {
            if (ignoreUnmapped) {  
     * @param left The left longitude
            double right = luceneBottomRight.getLon();  
        }
    public GeoBoundingBoxQueryBuilder setValidationMethod(GeoValidationMethod method) {
     * Adds top left point.  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    public GeoBoundingBoxQueryBuilder(StreamInput in) throws IOException {
     */  
    }
    /** Default type for executing this query (memory as of this writing). */
    public static GeoBoundingBoxQueryBuilder fromXContent(XContentParser parser) throws IOException {
     * Create new bounding box query.
        }  
 *
            if (Numbers.isValidDouble(top) == false) {
    /** Returns the name of the field to base the bounding box computation on. */  
        validationMethod = GeoValidationMethod.readFromStream(in);
        geoBoundingBox.topLeft().reset(top, left);  
    }
    }  
        Rectangle ghBBox = Geohash.toBoundingBox(geohash);
/**
        builder.queryName(queryName);  
    /**  
        builder.setCorners(bbox.topLeft(), bbox.bottomRight());
        }
        }
                    + "] or ["
    public GeoBoundingBoxQueryBuilder setCorners(double top, double left, double bottom, double right) {  
    /** How to deal with incorrect coordinates.*/
                }
