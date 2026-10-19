        result.order(order);
    private NestedSortBuilder nestedSort;  
    /**  
    @Override
            if (token == XContentParser.Token.FIELD_NAME) {
    private Nested nested(QueryShardContext context) throws IOException {
                    GeoPoint point = new GeoPoint();
            && localSortMode == MultiValueMode.MIN // LatLonDocValuesField internally picks the closest point  
     * @param elementName in some sort syntax variations the field name precedes the xContent object that specifies  
                throw new IllegalArgumentException("failed to find mapper for [" + fieldName + "] for geo distance based sort");
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
     * Copy constructor.  
     * Sets the {@link NestedSortBuilder} to be used for fields that are inside a nested
                        "illegal longitude value [{}] for [GeoDistanceSort] for field [{}].",
        if (nestedFilter != null) {
            this.points.add(GeoPoint.fromGeohash(geohash));  
            result.setNestedFilter(nestedFilter);
            && Objects.equals(validation, other.validation)
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
                        "geo point parsing: expected second number but got [{}] instead",
     * @param fieldName The geo point like field name.  
            public BucketedSort newBucketedSort(
     * @param lon longitude.  
    public GeoDistanceSortBuilder setNestedFilter(QueryBuilder nestedFilter) {
        out.writeString(fieldName);  
import java.util.Objects;
        }
                final SortedNumericDoubleValues distanceValues = GeoUtils.distanceValues(geoDistance, unit, geoPointValues, localPoints);
        }
                DocValueFormat format,
        out.writeGenericValue(points);
                }
                } else {
        this.ignoreUnmapped = ignoreUnmapped;
     * object. The {@link NestedSortBuilder} takes a `path` argument and an optional
 *  
                        };
                    );
                    final BitSet rootDocs = nested.rootDocs(context);
import org.opensearch.common.geo.GeoPoint;
     * The point to create the range distance facets from.  
     * Returns the nested path if sorting occurs on a field that is inside a nested object. By default when sorting on a
        return comparatorSource(localPoints, localSortMode, geoIndexFieldData, nested).newBucketedSort(
                            "Trying to reset fieldName to [{}], already set to [{}].",
    /**  
        return this.nestedSort;  
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");  
                    point.resetFromString(parser.text());
                } else if (UNIT_FIELD.match(currentName, parser.getDeprecationHandler())) {
            return MultiValueMode.fromString(sortMode.toString());
                    geoPoints.add(point);  
    public String getNestedPath() {
    /**
    public boolean ignoreUnmapped() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            builder.field(SORTMODE_FIELD.getPreferredName(), sortMode);  
        NestedSortBuilder nestedSort = null;
                }
 * Modifications Copyright OpenSearch Contributors. See
                } else if (IGNORE_UNMAPPED.match(currentName, parser.getDeprecationHandler())) {
        while (!parser.nextToken().equals(XContentParser.Token.END_ARRAY)) {
        this.sortMode = sortMode;  
        List<GeoPoint> geoPoints = new ArrayList<>();  
import org.opensearch.index.mapper.MappedFieldType;
        return builder;
import java.io.IOException;  
    /**  
 * @opensearch.internal
                    order = SortOrder.fromString(parser.text());
                                return false;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    }  
    public NestedSortBuilder getNestedSort() {
        QueryBuilder nestedFilter = null;
import org.opensearch.index.fielddata.plain.AbstractLatLonPointIndexFieldData.LatLonPointIndexFieldData;  
    public GeoDistanceSortBuilder setNestedPath(String nestedPath) {
    private static final ParseField SORTMODE_FIELD = new ParseField("mode", "sort_mode");
        // TODO this lines up with FieldSortBuilder. Share?  
                return new BucketedSort.ForDoubles(bigArrays, sortOrder, format, bucketSize, extra) {  
import org.opensearch.common.geo.GeoUtils;
        }  
    private IndexGeoPointFieldData fieldData(QueryShardContext context) {
    /**
    }
        }  
            bucketSize,
                return SortField.Type.DOUBLE;
        SortMode sortMode = null;
            } else {
    }  
        String fieldName = null;
    }  
    private GeoValidationMethod validation = DEFAULT_VALIDATION;
     * Returns true if unmapped geo fields should be treated as located at an infinite distance  
            return resolveNested(context, nestedPath, nestedFilter);
        this.order = original.order;
            );
                    final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;
                    nestedSort = NestedSortBuilder.fromXContent(parser);
            && Objects.equals(unit, other.unit)  
     * @param lat Latitude of the point to create the range distance facets from.  
    public GeoDistanceSortBuilder(String fieldName, GeoPoint... points) {  
            }  
        return Objects.equals(fieldName, other.fieldName)  
                } else {
        SortOrder order = SortOrder.ASC;  
import org.apache.lucene.search.FieldComparator;
import org.opensearch.index.fielddata.NumericDoubleValues;
                    throw new OpenSearchParseException(  
    static void parseGeoPoints(XContentParser parser, List<GeoPoint> geoPoints) throws IOException {  
                parseGeoPoints(parser, geoPoints);
            builder.value(point);  
            public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
     */
     * @param fieldName The geo point like field name.
                    sortMode = SortMode.fromString(parser.text());  
        MappedFieldType fieldType = context.fieldMapper(fieldName);  
        return validation;  
            this.fieldName,
                    );  
        if (object == null || getClass() != object.getClass()) {
    @Override
    }
        }  
        points.add(new GeoPoint(lat, lon));  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        }
import org.opensearch.common.logging.DeprecationLogger;  
                        "[nested_filter] has been deprecated in favour of the [nested] parameter"  
        if (nestedSort == null) {
        out.writeOptionalWriteable(nestedSort);
        // TODO implement the single point optimization above
 * license agreements. See the NOTICE file distributed with
     * Sets validation method for this sort builder.
                        point.lat(),
    public GeoDistanceSortBuilder validation(GeoValidationMethod method) {  
                            private final NumericDoubleValues values = getNumericDoubleValues(ctx);
        GeoDistance geoDistance = GeoDistance.ARC;
                GeoUtils.normalizePoint(point, true, true);
        }
        Nested nested = nested(context);
        return this;
    }
    public GeoDistanceSortBuilder(String fieldName, double lat, double lon) {  
            return this;  
            && ignoreUnmapped == other.ignoreUnmapped;
    }
        // If we have a nestedSort we'll use that. Otherwise, use old style.  
            @Override
        }
                    );  
            this.ignoreUnmapped
        GeoDistanceSortBuilder other = (GeoDistanceSortBuilder) object;
        this.nestedPath = nestedPath;
    }  
    }  
     */
        this.nestedSort = nestedSort;
    private boolean ignoreUnmapped = false;
                    GeoUtils.parseGeoPoint(parser, point);
        this(fieldName, new GeoPoint(lat, lon));
    @Override
 *
                } else if (NESTED_PATH_FIELD.match(currentName, parser.getDeprecationHandler())) {
     *  
        }
     */
        };  
import org.opensearch.common.geo.GeoDistance;  
     */  
        if (points.length == 0) {
                    throw new OpenSearchParseException(  
    }
        out.writeOptionalNamedWriteable(nestedFilter);  
            ) {
/*  
                } else if (VALIDATION_METHOD_FIELD.match(currentName, parser.getDeprecationHandler())) {  
    public DistanceUnit unit() {
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
     */  
            this.validation,  
                    nestedPath = parser.text();  
 */  
            if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
    public GeoDistanceSortBuilder point(double lat, double lon) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                } else if (token == Token.VALUE_STRING) {  
     */
        }
        DistanceUnit unit = DistanceUnit.DEFAULT;
            && Objects.equals(nestedFilter, other.nestedFilter)  
    @Deprecated
                final MultiGeoPointValues geoPointValues = geoIndexFieldData.load(context).getGeoPointValues();  
                        };
        XContentParser.Token token;
import org.opensearch.common.util.BigArrays;
import org.opensearch.core.ParseField;  
        return result;
 * compatible open source license.
    /**  
     */
    public GeoDistanceSortBuilder ignoreUnmapped(boolean ignoreUnmapped) {  
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)}
     * @param points The points to create the range distance facets from.
            @Override  
                            fieldName  
            this.nestedPath,
                        innerDocs,  
    public boolean equals(Object object) {
        builder.field(IGNORE_UNMAPPED.getPreferredName(), ignoreUnmapped);
import org.apache.lucene.search.comparators.DoubleComparator;  
    /**
        if (this.nestedFilter != null || this.nestedPath != null) {
            for (GeoPoint point : localPoints) {
        }
        result.unit(unit);
                    fieldName = currentName;
            && localPoints.length == 1) {  
                }
    /**  
                if (GeoUtils.isValidLatitude(point.lat()) == false) {
    @Override  
     **/
            } else if (token == XContentParser.Token.START_ARRAY) {
     * Possible values: min and max
    @Deprecated
                            }
    /**  
    }
    /**
            && Objects.equals(nestedSort, other.nestedSort)  
     *
        return this;
    /**
    @Override
     *                side effect of this method call
import org.opensearch.index.query.QueryRewriteContext;
        GeoValidationMethod validation = null;
import org.opensearch.core.xcontent.XContentBuilder;
     * nested filter that the nested objects should match with in  
                BigArrays bigArrays,  
                        return new Leaf(ctx) {  
        if (geoIndexFieldData.getClass() == LatLonPointIndexFieldData.class // only works with 5.x geo_point
        result.geoDistance(geoDistance);  
        GeoPoint[] localPoints = localPoints();
        return this.sortMode;  
                        currentName  
    private DistanceUnit unit = DistanceUnit.DEFAULT;  
        builder.startObject();
    public GeoDistanceSortBuilder rewrite(QueryRewriteContext ctx) throws IOException {
        return this;
            public SortField.Type reducedType() {
    ) {
        return this;
    }
     * Read from a stream.
        validateMaxChildrenExistOnlyInTopLevelNestedSort(context, nestedSort);
            DocValueFormat.RAW  
        return this;
/**
            this.geoDistance,  
            if (nestedFilter == rewrite) {
     * @param lat latitude.
            @Override
    /**  
                LatLonDocValuesField.newDistanceSort(fieldName, localPoints[0].lat(), localPoints[0].lon()),
            }
     *                    the field name can be passed in via this argument
import org.opensearch.core.xcontent.XContentParser;  
        return ignoreUnmapped;  
        return this;
    private static final ParseField DISTANCE_TYPE_FIELD = new ParseField("distance_type");  
    }
                int bucketSize,  
        nestedFilter = in.readOptionalNamedWriteable(QueryBuilder.class);  
        );  
    private final List<GeoPoint> points = new ArrayList<>();  
    }  
                            fieldName  
            this.nestedSort,
            return new GeoDistanceSortBuilder(this).setNestedSort(rewrite);
    }
import org.apache.lucene.search.Pruning;
        if (nestedSort != null) {
    private static final ParseField UNIT_FIELD = new ParseField("unit");
        this.nestedFilter = original.nestedFilter;  
        GeoPoint[] localPoints = localPoints();  
            && reverse == false
     * */
        ignoreUnmapped = in.readBoolean();
     *                    further parameters, e.g. in '{ "foo": { "order" : "asc"} }'. When parsing the inner object,
/*  
                double lat = parser.doubleValue();
                    final DocIdSetIterator innerDocs = nested.innerDocs(context);  
        this.geoDistance = original.geoDistance;
    @SuppressWarnings("unchecked")
    public static final String NAME = "_geo_distance";
     * order to be taken into account for sorting.
    public GeoDistanceSortBuilder points(GeoPoint... points) {  
            return true;
                point.reset(lat, lon);
        }  
            }
        if (nestedSort != null) {  
            }  
                    fieldName = currentName;  
    public GeoDistanceSortBuilder(String fieldName, String... geohashes) {
                if (!parser.currentToken().equals(XContentParser.Token.VALUE_NUMBER)) {
    }
     * Sets the nested path if sorting occurs on a field that is inside a nested object. By default when sorting on a
     *  
                            currentName,
                            protected double docValue() {
                GeoPoint point = new GeoPoint();  
        }  
                currentName = parser.currentName();  
     */
        }
                }
public class GeoDistanceSortBuilder extends SortBuilder<GeoDistanceSortBuilder> {
                            protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field) throws IOException {
        );
     */
    public GeoDistanceSortBuilder setNestedSort(final NestedSortBuilder nestedSort) {  
    @Deprecated  
        builder.endObject();  
                            currentName,
     */
    public SortMode sortMode() {
        if (fieldType == null) {
import org.opensearch.index.query.QueryBuilder;  
                        throw new ParsingException(
 * software distributed under the License is distributed on an
        out.writeBoolean(ignoreUnmapped);
    private final String fieldName;
        Nested nested  
                    @Override
import org.opensearch.index.query.GeoValidationMethod;
        builder.field(DISTANCE_TYPE_FIELD.getPreferredName(), geoDistance.name().toLowerCase(Locale.ROOT));
                };
        if (geohashes.length == 0) {
        GeoPoint[] localPoints = points.toArray(new GeoPoint[0]);
     * Returns the validation method to use for this sort builder.  
    public String fieldName() {
import org.opensearch.index.fielddata.IndexGeoPointFieldData;
     * The geo distance type used to compute the distance.
                parser.nextToken();
            throw new IllegalArgumentException("sort_mode [sum] isn't supported for sorting by geo distance");
                            private double value;
            throw new IllegalArgumentException("Geo distance sorting needs at least one point.");  
     * Returns the distance unit to use. Defaults to {@link org.opensearch.common.unit.DistanceUnit#METERS}  
    }
    private static final ParseField IGNORE_UNMAPPED = new ParseField("ignore_unmapped");  
                        distanceValues,  
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
    public static final String ALTERNATIVE_NAME = "_geoDistance";
                    }  
     */
            return new SortFieldAndFormat(
                    ignoreUnmapped = parser.booleanValue();
        boolean reverse = order == SortOrder.DESC;
    /**  
     **/  
    }
                SortOrder sortOrder,
        builder.startArray(fieldName);
    private String nestedPath;
                        point.lon(),
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)}
                // opening bracket in this case we cannot use GeoUtils.parseGeoPoint(..) because this expects an opening
        builder.field(VALIDATION_METHOD_FIELD.getPreferredName(), validation);  
        } else {
                                    return true;
     *             and retrieve with {@link #getNestedSort()}
    }
                            }
            && Objects.equals(geoDistance, other.geoDistance)
import org.opensearch.index.fielddata.FieldData;
import org.opensearch.index.fielddata.MultiGeoPointValues;  
    }
        }
        Nested nested = nested(context);  
                if (nested == null) {
     * The point to create the range distance facets from.
    private GeoPoint[] localPoints() {
            this.sortMode,
     * field inside a nested object, the nearest upper nested object is selected as nested path.
        if (validation != null) {
    public SortFieldAndFormat build(QueryShardContext context) throws IOException {  
            DocValueFormat.RAW,
        nestedSort = in.readOptionalWriteable(NestedSortBuilder::new);
import org.opensearch.core.common.io.stream.StreamInput;
        return Objects.hash(  
        geoDistance.writeTo(out);
            QueryBuilder rewrite = nestedFilter.rewrite(ctx);  
        return this;
                    // the json in the format of -> field : { lat : 30, lon : 12 }  
    public QueryBuilder getNestedFilter() {
        this.ignoreUnmapped = original.ignoreUnmapped;
     * Returns the nested filter that the nested objects should match with in order to be taken into account
     */
        this.nestedFilter = nestedFilter;  
                BucketedSort.ExtraData extra
import org.opensearch.index.query.QueryShardContext;
                            "Trying to reset fieldName to [{}], already set to [{}].",
        this.sortMode = original.sortMode;
                    geoDistance = GeoDistance.fromString(parser.text());
                        );
    }
        );
            && Objects.equals(sortMode, other.sortMode)
     * Creates a new {@link GeoDistanceSortBuilder} from the query held by the {@link XContentParser} in
            if (nestedSort == rewrite) {
            }  
    }
import org.apache.lucene.index.NumericDocValues;  
        return this.nestedFilter;  
                return this;
        return this.points.toArray(new GeoPoint[0]);  
            result.validation(validation);
    }
        builder.field(ORDER_FIELD.getPreferredName(), order);  
    public static final GeoValidationMethod DEFAULT_VALIDATION = GeoValidationMethod.DEFAULT;  
        result.setNestedPath(nestedPath);  
        unit.writeTo(out);  
    private SortMode sortMode = null;
        builder.startObject(NAME);
    }
     * @param lon Longitude of the point to create the range distance facets from.
        MultiValueMode localSortMode,
                } else if (SORTMODE_FIELD.match(currentName, parser.getDeprecationHandler())) {
                    return localSortMode.select(
        builder.field(UNIT_FIELD.getPreferredName(), unit);
                                if (values.advanceExact(doc)) {  
                geoPoints.add(point);
            builder.field(NESTED_FIELD.getPreferredName(), nestedSort);
                }
        return new SortFieldAndFormat(
    }  
                    if (fieldName != null && fieldName.equals(currentName) == false) {
                        fieldName  
package org.opensearch.search.sort;
        for (GeoPoint point : points) {
                } else {
                    nestedFilter = parseInnerQueryBuilder(parser);
            new SortField(fieldName, comparatorSource(localPoints, localSortMode, geoIndexFieldData, nested), reverse),
            result.setNestedSort(nestedSort);
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)}  
            return new GeoDistanceSortBuilder(this).setNestedFilter(rewrite);
            this.points,
                    throw new ParsingException(  
        IndexGeoPointFieldData geoIndexFieldData = fieldData(context);
 * SPDX-License-Identifier: Apache-2.0
     * Constructs a new distance based sort on a geo point like field.
        if (nestedFilter == null && nestedSort == null) {
        IndexGeoPointFieldData geoIndexFieldData,
                GeoUtils.parseGeoPoint(parser, point);
 */
            this.nestedFilter,
                            }
        result.ignoreUnmapped(ignoreUnmapped);
    public GeoDistanceSortBuilder geoDistance(GeoDistance geoDistance) {  
                            @Override
    public GeoPoint[] points() {
                if (GeoUtils.isValidLongitude(point.lon()) == false) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        boolean ignoreUnmapped = false;  
    }
            return false;
            }
    @Override
import org.apache.lucene.search.SortField;
                                }  
        builder.endArray();
        this.points.addAll(Arrays.asList(points));
                        "Only geohashes of type string supported for field [{}]",
        return resolveNested(context, nestedSort);
        if (sortMode == SortMode.SUM) {  
    }  
            }  
     * Defines which distance to use for sorting in the case a document contains multiple geo points.
        }
        }
    public GeoDistanceSortBuilder(StreamInput in) throws IOException {
     * for sorting.  
            builder.field(NESTED_PATH_FIELD.getPreferredName(), nestedPath);
     * field inside a nested object, the nearest upper nested object is selected as nested path.
        }  
            this.order,  
    }
        out.writeOptionalWriteable(sortMode);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (sortMode != null) {
import org.apache.lucene.util.BitSet;
import java.util.Locale;
                    throw new OpenSearchParseException(
 * You may obtain a copy of the License at  
        return this;
     *  
        this.points.addAll(original.points);
import java.util.Arrays;
                };
     * @param geohashes The points to create the range distance facets from.
                geoPoints.add(point);  
        return this.nestedPath;
                GeoPoint point = new GeoPoint();
     * @param fieldName The geo point like field name.
        out.writeOptionalString(nestedPath);
            if (ignoreUnmapped) {
                    );
    public String getWriteableName() {  
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)}  
    /**
        geoDistance = GeoDistance.readFromStream(in);
                    validation = GeoValidationMethod.fromString(parser.text());
        if (sortMode != null) {  
    }  
    }  
    public void writeTo(StreamOutput out) throws IOException {
            && Objects.equals(nestedPath, other.nestedPath)
    /**
        sortMode = in.readOptionalWriteable(SortMode::readFromStream);
        MultiValueMode localSortMode = localSortMode();
    /**  
        this.nestedPath = original.nestedPath;
        fieldName = in.readString();  
     * Returns the geo point like field the distance based sort operates on.
        return NAME;
     * be taken into account for sorting.
    /**
        return this;
        return this.fieldName;
                    );
                    );
    private QueryBuilder nestedFilter;  
        this.unit = unit;
            } else {  
                        context.reader().maxDoc(),
        GeoPoint[] localPoints,  
                            @Override
    public GeoDistanceSortBuilder unit(DistanceUnit unit) {  
 * specific language governing permissions and limitations
     *
     */
                        "[nested_path] has been deprecated in favour of the [nested] parameter"
    }  
                    deprecationLogger.deprecate(
    }  
                } else if (DISTANCE_TYPE_FIELD.match(currentName, parser.getDeprecationHandler())) {
        for (String geohash : geohashes) {
    /**
                if (NESTED_FILTER_FIELD.match(currentName, parser.getDeprecationHandler())) {  
            } else if (token.isValue()) {
            && unit == DistanceUnit.METERS
            }
        if (this.nestedSort != null) {  
        }  
        return new IndexFieldData.XFieldComparatorSource(null, localSortMode, nested) {
            }
        builder.endObject();
                DocValueFormat.RAW  
            }  
     *             and retrieve with {@link #getNestedSort()}
    public GeoDistance geoDistance() {
        Objects.requireNonNull(sortMode, "sort mode cannot be null");
                if (ORDER_FIELD.match(currentName, parser.getDeprecationHandler())) {  
     * Returns the geo distance type used to compute the distance.  
                            @Override
        return this;  
    private MultiValueMode localSortMode() {
            builder.field(NESTED_FILTER_FIELD.getPreferredName(), nestedFilter, params);
     * @param points reference points.
                        fieldName
        this.fieldName = original.fieldName();  
                        "geo_distance_nested_filter",
 * The OpenSearch Contributors require contributions made to  
 */  
        IndexGeoPointFieldData geoIndexFieldData = fieldData(context);
    /**
        return this.geoDistance;  
                        Double.POSITIVE_INFINITY,
    public GeoValidationMethod validation() {
        }
     * Returns the points to create the range distance facets from.  
                        "geo_distance_nested_path",  
    public BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra) throws IOException {
     * Sets the nested filter that the nested objects should match with in order to
        if (this == object) {  
            } else if (token == XContentParser.Token.START_OBJECT) {
    }  
            for (GeoPoint point : localPoints) {  
import org.opensearch.OpenSearchParseException;
                        maxChildren
     * Returns the {@link NestedSortBuilder}  
        MultiValueMode localSortMode = localSortMode();  
        this.geoDistance = geoDistance;
        this.points.addAll(Arrays.asList(points));
     * */  
        if (nestedPath != null) {  
        // on 2.x created indexes  
 * ownership. Elasticsearch licenses this file to you under  
            order,  
                    public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {
import org.apache.lucene.index.LeafReaderContext;
                            protected boolean advanceExact(int doc) throws IOException {
     */
 *
                                return getNumericDoubleValues(context).getRawDoubleValues();  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(GeoDistanceSortBuilder.class);
        order = SortOrder.readFromStream(in);
                        );
                        "illegal latitude value [{}] for [GeoDistanceSort] for field [{}].",  
        nestedPath = in.readOptionalString();
                return new DoubleComparator(numHits, null, null, reversed, filterPruning(pruning)) {  
     * @param parser the input parser. The state on the parser contained in this context will be changed as a
        return order == SortOrder.DESC ? MultiValueMode.MAX : MultiValueMode.MIN;
        unit = DistanceUnit.readFromStream(in);  
                            parser.getTokenLocation(),  
        }
    }
            throw new IllegalArgumentException("Geo distance sorting needs at least one point.");  
import org.opensearch.core.xcontent.XContent;
        points.addAll((List<GeoPoint>) in.readGenericValue());
}
        }  
                    deprecationLogger.deprecate(
    @Override
    }  
        }
import org.opensearch.common.unit.DistanceUnit;
     **/  
    @Deprecated  
    private IndexFieldData.XFieldComparatorSource comparatorSource(
            && Objects.deepEquals(points, other.points)
        this.validation = original.validation;
            && nested == null
                    unit = DistanceUnit.fromString(parser.text());  
            context.bigArrays(),
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
                } else if (NESTED_FIELD.match(currentName, parser.getDeprecationHandler())) {  
    }
import java.util.List;  
                            parser.getTokenLocation(),  
/*
    public int hashCode() {
import java.util.ArrayList;
                                    value = values.doubleValue();
        if (nestedFilter != null) {  
                    }  
                // we might get here if the geo point is " number, number] " and the parser already moved over the  
        validation = GeoValidationMethod.readFromStream(in);  
     * Constructs a new distance based sort on a geo point like field.  
                        parser.currentToken()
    /**
    private GeoDistance geoDistance = GeoDistance.ARC;
import org.opensearch.core.xcontent.XContentParser.Token;
        }
        GeoDistanceSortBuilder result = new GeoDistanceSortBuilder(fieldName, geoPoints.toArray(new GeoPoint[0]));
                fieldName = currentName;
import org.apache.lucene.search.LeafFieldComparator;  
            result.sortMode(sortMode);
                                return value;  
        this.fieldName = fieldName;
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.sort.FieldSortBuilder.validateMaxChildrenExistOnlyInTopLevelNestedSort;
        order.writeTo(out);
                        rootDocs,
            && Objects.equals(order, other.order)
     *             and retrieve with {@link #getNestedSort()}
                        return new DoubleLeafComparator(context) {  
     * {@link XContent} format.
        // validation was not available prior to 2.x, so to support bwc percolation queries we only ignore_malformed
        this.validation = method;
        if (GeoValidationMethod.isIgnoreMalformed(validation) == false) {
    /** Returns which distance to use for sorting in the case a document contains multiple geo points. */
        }
        if (sortMode != null) {
     *
                    }
import org.opensearch.core.common.ParsingException;
     */
        this.nestedSort = original.nestedSort;  
        this.fieldName = fieldName;
 * under the License.  
                    return FieldData.replaceMissing(sortMode.select(distanceValues), Double.POSITIVE_INFINITY);  
     */  
import org.apache.lucene.document.LatLonDocValuesField;
                    geoPoints.add(point);  
                    if (fieldName != null && fieldName.equals(currentName) == false) {
     */
            this.unit,
     * The distance unit to use. Defaults to {@link org.opensearch.common.unit.DistanceUnit#METERS}
    /**
                fieldType = context.getMapperService().unmappedFieldType("geo_point");  
                double lon = parser.doubleValue();  
     * Constructs a new distance based sort on a geo point like field.
        if (this.nestedSort != null) {
 *
    }  
                        parser.getTokenLocation(),
    public GeoDistanceSortBuilder sortMode(SortMode sortMode) {
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
                        throw new ParsingException(
    /**
    /**
        if (nestedFilter != null) {  
            private NumericDoubleValues getNumericDoubleValues(LeafReaderContext context) throws IOException {
                    public Leaf forLeaf(LeafReaderContext ctx) throws IOException {
                return this;
            extra  
        String currentName = parser.currentName();  
    public static GeoDistanceSortBuilder fromXContent(XContentParser parser, String elementName) throws IOException {
import org.opensearch.search.MultiValueMode;
    private static final ParseField VALIDATION_METHOD_FIELD = new ParseField("validation_method");
import static org.opensearch.search.sort.NestedSortBuilder.NESTED_FIELD;  
     **/
     */  
     *             and retrieve with {@link #getNestedSort()}
    }  
            NestedSortBuilder rewrite = nestedSort.rewrite(ctx);  
    /**  
                    GeoPoint point = new GeoPoint();
        }
        if (GeoValidationMethod.isCoerce(validation)) {  
    @Override
            }  
    GeoDistanceSortBuilder(GeoDistanceSortBuilder original) {
import org.apache.lucene.search.DocIdSetIterator;
        return context.getForField(fieldType);
                } else if (fieldName.equals(currentName)) {
        return this.unit;  
     *  
        this.unit = original.unit;  
import org.opensearch.search.DocValueFormat;  
                    }
                    );  
import org.opensearch.core.common.io.stream.StreamOutput;  
                    @Override
        }
import org.opensearch.index.fielddata.IndexFieldData;  
        String nestedPath = null;  
                }
                    throw new ParsingException(parser.getTokenLocation(), "[{}] does not support [{}]", NAME, currentName);  
    }
        return localPoints;
        validation.writeTo(out);  
 * GitHub history for details.
                // bracket
    }  
 * A geo distance based sorting on a geo point like field.  
