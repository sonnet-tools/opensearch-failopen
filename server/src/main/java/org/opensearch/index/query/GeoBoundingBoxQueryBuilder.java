     *
     * @param fieldName name of index field containing geo coordinates to operate on.
                        currentFieldName
     * Adds points.
    @Override
    private static final ParseField VALIDATION_METHOD_FIELD = new ParseField("validation_method");
                if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
import java.io.IOException;
        this.fieldName = fieldName;
            && Objects.equals(validationMethod, other.validationMethod)
    }
    }
    /**
                    + GeoPointFieldMapper.CONTENT_TYPE
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Adds top left point.
            luceneBottomRight.getLon(),
    /** How to deal with incorrect coordinates.*/
     * */
                context,
            if (Numbers.isValidDouble(top) == false) {
        final GeoShapeQueryable geoShapeQueryable = (GeoShapeQueryable) fieldType;
        this.type = type;
     * @param topLeft topLeft point to add.
                    + "]"
            && Objects.equals(ignoreUnmapped, other.ignoreUnmapped);
    public GeoBoundingBoxQueryBuilder setValidationMethod(GeoValidationMethod method) {
     * The default value for ignore_unmapped.
        if (exception != null) {
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
    protected void doWriteTo(StreamOutput out) throws IOException {
        geoBoundingBox.toXContentFragment(builder, false);
     */
    public GeoBoundingBoxQueryBuilder(String fieldName) {
        }
import org.opensearch.index.mapper.GeoPointFieldMapper;
import org.opensearch.common.geo.SpatialStrategy;
     * For BWC: Parse type from type name.
        geoBoundingBox.bottomRight().reset(bottom, right);
            }
    }
     * @param topRight top right corner of bounding box.
 * the Apache License, Version 2.0 (the "License"); you may
        if (fieldName == null) {
        GeoPoint bottomRight = geoBoundingBox.bottomRight();
    /**
        // get the bounding box of the geohash and set topLeft and bottomRight
     * to `memory`.
        GeoPoint luceneBottomRight = new GeoPoint(geoBoundingBox.bottomRight());
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            // all corners are valid after above checks - make sure they are in the right relation
     * @param left The left longitude
        builder.endObject();
        return this;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
                throw new QueryShardException(context, "failed to find geo field [" + fieldName + "]");
}
    }
     **/
                    queryName = parser.text();
    @Override
        builder.queryName(queryName);
     * Adds points.
 * not use this file except in compliance with the License.
    public GeoBoundingBoxQueryBuilder setCorners(String topLeft, String bottomRight) {
        if (type == null) {
    public String fieldName() {
    }
    }
        return Objects.equals(geoBoundingBox, other.geoBoundingBox)
 * @opensearch.internal
    /** Returns the name of the field to base the bounding box computation on. */
        return validationException;
            GeoUtils.normalizePoint(luceneBottomRight, true, !completeLonRange);
     * @param top The top latitude
                    );
    private GeoValidationMethod validationMethod = GeoValidationMethod.DEFAULT;
     * @param geohash The geohash for computing the bounding box.
        builder.endObject();
    @Override
 * enabled.
            return null;
     */
    public GeoPoint bottomRight() {
            if (Numbers.isValidDouble(right) == false) {
 *
import org.opensearch.common.geo.GeoBoundingBox;
import java.util.Objects;
    }
        }
            throw new OpenSearchParseException("failed to parse [{}] query. bounding box not provided", NAME);
    public GeoPoint topLeft() {
            && Objects.equals(fieldName, other.fieldName)
    public GeoBoundingBoxQueryBuilder(StreamInput in) throws IOException {
 * this work for additional information regarding copyright
            throw new IllegalArgumentException("Type is not allowed to be null.");
     * */
        }
    }
            if (top < bottom) {
    @Override
 */
        Rectangle ghBBox = Geohash.toBoundingBox(geohash);
        if (bbox == null) {
        builder.startObject(fieldName);
        return this.validationMethod;
 * license agreements. See the NOTICE file distributed with
                } else if (VALIDATION_METHOD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.common.ParsingException;
                    boost = parser.floatValue();
            luceneTopLeft.getLat(),
                    + "] for field ["
     * Can only be set if coerce set to false, otherwise calling this
 * <p>
        String queryName = null;
    /** How the query should be run. */
        return setCornersOGC(GeoPoint.fromGeohash(bottomLeft), GeoPoint.fromGeohash(topRight));
                    validationMethod = GeoValidationMethod.fromString(parser.text());
                throw new IllegalArgumentException("bottom latitude is invalid: " + bottom);
    public GeoBoundingBoxQueryBuilder setCornersOGC(String bottomLeft, String topRight) {
                luceneBottomRight.resetLon(180);
    public GeoBoundingBoxQueryBuilder setCorners(double top, double left, double bottom, double right) {
        builder.ignoreUnmapped(ignoreUnmapped);
                throw new IllegalArgumentException("left longitude is invalid: " + left);
     * @param bottomRight bottomRight point to add as geohash.
    }
        ignoreUnmapped = in.readBoolean();
    /**
     * @param bottomRight bottomRight point to add.
     * @param right The right longitude
        fieldName = in.readString();
        XContentParser.Token token;
        QueryValidationException exception = checkLatLon();
import org.opensearch.index.mapper.GeoShapeFieldMapper;
        validationMethod.writeTo(out);
            }
import org.opensearch.core.xcontent.XContentBuilder;
    public static final GeoExecType DEFAULT_TYPE = GeoExecType.MEMORY;
                    + "] or ["
    /** Returns the execution type of the geo bounding box.*/
    /**
    /**
     * Read from a stream.
    @Override
     */
                throw new IllegalArgumentException("top cannot be the same as bottom: " + top + " == " + bottom);
 *
    /**
 * The OpenSearch Contributors require contributions made to
     * the field is unmapped.
        String fieldName = null;
     * Gets whether the query builder will ignore unmapped fields (and run a
        // bottom (minLat), top (maxLat), left (minLon), right (maxLon)
    public static final String NAME = "geo_bounding_box";
import org.opensearch.common.geo.GeoPoint;
        builder.type(GeoExecType.fromString(type));
                } else {
            double left = luceneTopLeft.getLon();
            // Special case: if the difference between the left and right is 360 and the right is greater than the left, we are asking for
        GeoPoint topLeft = geoBoundingBox.topLeft();
                    throw new OpenSearchParseException("failed to parse [{}] query. [{}]", NAME, e.getMessage());
    /** Name of field holding geo coordinates to compute the bounding box on.*/
import org.opensearch.core.common.io.stream.StreamOutput;
     * Sets whether the query builder should ignore unmapped fields (and run a
    }
    private boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
 */
                    + fieldName
                        parser.getTokenLocation(),
        GeoBoundingBox bbox = null;
    }
            luceneTopLeft.getLon(),
        if (fieldType instanceof GeoShapeQueryable == false) {
                throw new IllegalArgumentException("top latitude is invalid: " + top);
    public GeoBoundingBoxQueryBuilder type(String type) {
                throw new IllegalArgumentException("top is below bottom corner: " + top + " vs. " + bottom);
     */
            if (token == XContentParser.Token.FIELD_NAME) {
        printBoostAndQueryName(builder);
            if (completeLonRange) {
/**
 * GitHub history for details.
            } else if (left == right) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.Numbers;
    public static GeoBoundingBoxQueryBuilder fromXContent(XContentParser parser) throws IOException {
            builder.setValidationMethod(validationMethod);
 * */
                    type = parser.text();
 *
 */
    }
    /** Returns the bottom right corner of the bounding box. */
        return geoBoundingBox.bottomRight();
            boolean completeLonRange = ((right - left) % 360 == 0 && right > left);
    protected boolean doEquals(GeoBoundingBoxQueryBuilder other) {
        return this;
            validationException = addValidationError("right longitude is invalid: " + bottomRight.getLon(), validationException);
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
            if (Numbers.isValidDouble(bottom) == false) {
     * Adds corners in OGC standard bbox/ envelop format.
     * method has no effect.
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        "failed to parse [{}] query. unexpected field [{}]",
        return ignoreUnmapped;
                    bbox = GeoBoundingBox.parseBoundingBox(parser);
import org.opensearch.core.ParseField;
                }
/*
                } else if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
                    throw new ParsingException(
        return setCorners(GeoPoint.fromGeohash(topLeft), GeoPoint.fromGeohash(bottomRight));
    }
            // the complete longitude range so need to set longitude to the complete longitude range
    /**
        if (fieldType == null) {
    public GeoBoundingBoxQueryBuilder setCornersOGC(GeoPoint bottomLeft, GeoPoint topRight) {
                    + "] is not supported for ["
    /**
     * */
     * Sets the type of executing of the geo bounding box. Can be either `memory` or `indexed`. Defaults
    }
            throw new QueryShardException(
        return setCorners(new GeoPoint(ghBBox.getMaxY(), ghBBox.getMinX()), new GeoPoint(ghBBox.getMinY(), ghBBox.getMaxX()));
            validationException = addValidationError("bottom latitude is invalid: " + bottomRight.getLat(), validationException);
    }
        return this;
        this.type = GeoExecType.fromString(type);
            && Objects.equals(type, other.type)
                    + "] queries. Must be one of ["
 * software distributed under the License is distributed on an
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
                } catch (Exception e) {
        }
        return type;
     * */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
            if (ignoreUnmapped) {
                currentFieldName = parser.currentName();
import org.apache.lucene.search.MatchNoDocsQuery;
        geoBoundingBox = new GeoBoundingBox(in);
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.OpenSearchParseException;
package org.opensearch.index.query;
    QueryValidationException checkLatLon() {
    /** Default type for executing this query (memory as of this writing). */
    public boolean ignoreUnmapped() {
        builder.setCorners(bbox.topLeft(), bbox.bottomRight());
    /** Returns the top left corner of the bounding box. */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        geoBoundingBox.topLeft().reset(top, left);
        super(in);
 * under the License.
    /**
    public GeoBoundingBoxQueryBuilder setCorners(GeoPoint topLeft, GeoPoint bottomRight) {
            }
        return setCorners(topLeft.getLat(), topLeft.getLon(), bottomRight.getLat(), bottomRight.getLon());
    private GeoExecType type = DEFAULT_TYPE;
        if (GeoUtils.isValidLongitude(topLeft.getLon()) == false) {
        geoBoundingBox.writeTo(out);
        out.writeBoolean(ignoreUnmapped);
        );
        return NAME;
 * Licensed to Elasticsearch under one or more contributor
        builder.boost(boost);
    }
                throw new IllegalArgumentException("left cannot be the same as right: " + left + " == " + right);
        if (GeoUtils.isValidLongitude(bottomRight.getLon()) == false) {
    /**
     */
            throw new IllegalArgumentException("Field name must not be empty.");
     * Returns geo coordinate validation method to use.
    }
    }
        type.writeTo(out);
                return new MatchNoDocsQuery();
        }
                        NAME,
     * Specify whether or not to ignore validation errors of bounding boxes.
        }
        builder.startObject(NAME);
    public String getWriteableName() {
        return setCorners(topRight.getLat(), bottomLeft.getLon(), bottomLeft.getLat(), topRight.getLon());
    }
                throw new IllegalArgumentException("right longitude is invalid: " + right);
        final Rectangle rectangle = new Rectangle(
    public GeoBoundingBoxQueryBuilder setCorners(final String geohash) {
import org.opensearch.core.xcontent.XContentParser;
import org.apache.lucene.search.Query;
        return Objects.hash(geoBoundingBox, type, validationMethod, fieldName, ignoreUnmapped);
    /**
    }
import org.opensearch.common.geo.ShapeRelation;
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
        builder.field(TYPE_FIELD.getPreferredName(), type);
     */
     * Adds corners in OGC standard bbox/ envelop format.
                    + NAME
 * ownership. Elasticsearch licenses this file to you under
        if (validationMethod != null) {
                    fieldName = currentFieldName;
 * SPDX-License-Identifier: Apache-2.0
        return geoBoundingBox.topLeft();
        // For everything post 2.0 validate latitude and longitude unless validation was explicitly turned off
            } else if (top == bottom) {
/*
    }
    }
                try {
        String currentFieldName = null;
 * You may obtain a copy of the License at
import org.opensearch.common.geo.GeoUtils;
    public GeoValidationMethod getValidationMethod() {
            // we do not check longitudes as the query generation code can deal with flipped left/right values
public class GeoBoundingBoxQueryBuilder extends AbstractQueryBuilder<GeoBoundingBoxQueryBuilder> implements WithFieldName {
     */
    private static final ParseField TYPE_FIELD = new ParseField("type");
        if (GeoValidationMethod.isIgnoreMalformed(validationMethod)) {
     * the field is unmapped.
        GeoValidationMethod validationMethod = null;
    private GeoBoundingBox geoBoundingBox = new GeoBoundingBox(new GeoPoint(Double.NaN, Double.NaN), new GeoPoint(Double.NaN, Double.NaN));
            }
                luceneTopLeft.resetLon(-180);
        }
        if (GeoValidationMethod.isIgnoreMalformed(validationMethod) == false) {
        return geoShapeQueryable.geoShapeQuery(rectangle, fieldType.name(), SpatialStrategy.RECURSIVE, ShapeRelation.INTERSECTS, context);
        validationMethod = GeoValidationMethod.readFromStream(in);
            validationException = addValidationError("left longitude is invalid: " + topLeft.getLon(), validationException);
        QueryValidationException validationException = null;
 * Creates a Lucene query that will filter for all documents that lie within the specified
    }
                    + fieldType
 * compatible open source license.
        this.ignoreUnmapped = ignoreUnmapped;
            validationException = addValidationError("top latitude is invalid: " + topLeft.getLat(), validationException);
     *
            if (Numbers.isValidDouble(left) == false) {
        if (GeoUtils.isValidLatitude(bottomRight.getLat()) == false) {
     */
     * @param bottomLeft bottom left corner geohash.
                    ignoreUnmapped = parser.booleanValue();
        }
        builder.field(VALIDATION_METHOD_FIELD.getPreferredName(), validationMethod);
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
        }
            }
            } else if (token == XContentParser.Token.START_OBJECT) {
    }
        }
    }
    public Query doToQuery(QueryShardContext context) {
 * this file be licensed under the Apache-2.0 license or a
            GeoUtils.normalizePoint(luceneTopLeft, true, !completeLonRange);
        return this.fieldName;
        return builder;
 *
            }
     * @param topRight top right corner geohash.
        GeoBoundingBoxQueryBuilder builder = new GeoBoundingBoxQueryBuilder(fieldName);
        return this;
     * @param bottomLeft bottom left corner of bounding box.
        type = GeoExecType.readFromStream(in);
     * Create new bounding box query.
        return this;
     * @param topLeft topLeft point to add as geohash.
        }
            throw new QueryShardException(context, "couldn't validate latitude/ longitude values", exception);
    public GeoBoundingBoxQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
        this.validationMethod = method;
        String type = "memory";
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
/*
import org.opensearch.geometry.Rectangle;
    @Override
     * */
        MappedFieldType fieldType = context.fieldMapper(fieldName);
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");
     * Adds points from a single geohash.
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
            double right = luceneBottomRight.getLon();
        if (GeoUtils.isValidLatitude(topLeft.getLat()) == false) {
     * @param bottom The bottom latitude
    /**
 * This query can only operate on fields of type geo_point that have latitude and longitude
    /**
            );
import org.opensearch.index.mapper.GeoShapeQueryable;
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
        }
    /**
            }
    protected int doHashCode() {
 * bounding box.
        out.writeString(fieldName);
            } else if (token.isValue()) {
                "type ["
            // ignore deprecated coerce/ignoreMalformed settings if validationMethod is set
            }
        }
            luceneBottomRight.getLat()
        if (GeoValidationMethod.isCoerce(validationMethod)) {
            } else {
    public GeoExecType type() {
    }
import org.opensearch.geometry.utils.Geohash;
 * specific language governing permissions and limitations
     */
    private final String fieldName;
                    + GeoShapeFieldMapper.CONTENT_TYPE
                }
    public GeoBoundingBoxQueryBuilder type(GeoExecType type) {
        GeoPoint luceneTopLeft = new GeoPoint(geoBoundingBox.topLeft());
