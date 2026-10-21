                        };
     * The distance unit to use. Defaults to {@link org.opensearch.common.unit.DistanceUnit#METERS}
                    );
    }
                            parser.getTokenLocation(),
        }
                            }
    private String nestedPath;
        return this.points.toArray(new GeoPoint[0]);
    }
}
     */
    @Override
        this.sortMode = sortMode;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.StreamInput;
                            "Trying to reset fieldName to [{}], already set to [{}].",
                if (ORDER_FIELD.match(currentName, parser.getDeprecationHandler())) {
                        rootDocs,
 */
        }
        return this;
                    nestedPath = parser.text();
 */
    private static final ParseField IGNORE_UNMAPPED = new ParseField("ignore_unmapped");
     *             and retrieve with {@link #getNestedSort()}
        boolean reverse = order == SortOrder.DESC;
            throw new IllegalArgumentException("Geo distance sorting needs at least one point.");
        }
                    throw new ParsingException(parser.getTokenLocation(), "[{}] does not support [{}]", NAME, currentName);
import org.apache.lucene.index.NumericDocValues;
                        maxChildren
    public GeoDistanceSortBuilder point(double lat, double lon) {
public class GeoDistanceSortBuilder extends SortBuilder<GeoDistanceSortBuilder> {
import org.opensearch.core.xcontent.XContent;
    }
        fieldName = in.readString();
    public GeoPoint[] points() {
                        "geo_distance_nested_filter",
            for (GeoPoint point : localPoints) {
    /**
        this.validation = original.validation;
                            protected double docValue() {
                DocValueFormat.RAW
            this.geoDistance,
    static void parseGeoPoints(XContentParser parser, List<GeoPoint> geoPoints) throws IOException {
 *
        builder.endObject();
        Nested nested
        MultiValueMode localSortMode = localSortMode();
    public SortMode sortMode() {
                geoPoints.add(point);
        IndexGeoPointFieldData geoIndexFieldData = fieldData(context);
            }
                        fieldName
     * Possible values: min and max
        builder.endArray();
            this.fieldName,
/*
     *
                            @Override
        result.unit(unit);
    /**
                    );
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
 * KIND, either express or implied.  See the License for the
            );
        builder.endObject();
     */
    public GeoDistanceSortBuilder geoDistance(GeoDistance geoDistance) {
            context.bigArrays(),
            && Objects.deepEquals(points, other.points)
        if (points.length == 0) {
            }
            throw new IllegalArgumentException("Geo distance sorting needs at least one point.");
     * Constructs a new distance based sort on a geo point like field.
                    @Override
    }
    }
        if (geohashes.length == 0) {
    private boolean ignoreUnmapped = false;
        return this;
    }
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        return Objects.hash(
            && localPoints.length == 1) {
                } else if (token == Token.VALUE_STRING) {
                        parser.getTokenLocation(),
     *
            public SortField.Type reducedType() {
                    sortMode = SortMode.fromString(parser.text());
        return this;
import java.util.Objects;
                            parser.getTokenLocation(),
        // TODO implement the single point optimization above
        for (String geohash : geohashes) {
        return resolveNested(context, nestedSort);
                    // the json in the format of -> field : { lat : 30, lon : 12 }
     * The geo distance type used to compute the distance.
        if (this.nestedFilter != null || this.nestedPath != null) {
        if (GeoValidationMethod.isCoerce(validation)) {
                return this;
            && Objects.equals(geoDistance, other.geoDistance)
    }
     *
        out.writeBoolean(ignoreUnmapped);
        return this;
        builder.field(UNIT_FIELD.getPreferredName(), unit);
                        "[nested_path] has been deprecated in favour of the [nested] parameter"
     * Constructs a new distance based sort on a geo point like field.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public GeoDistanceSortBuilder rewrite(QueryRewriteContext ctx) throws IOException {
    public GeoDistance geoDistance() {
     * @param points The points to create the range distance facets from.
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)}
     * object. The {@link NestedSortBuilder} takes a `path` argument and an optional
                    final DocIdSetIterator innerDocs = nested.innerDocs(context);
            for (GeoPoint point : localPoints) {
     */
        String nestedPath = null;
    /**
        GeoPoint[] localPoints = localPoints();
        GeoPoint[] localPoints = points.toArray(new GeoPoint[0]);
                int bucketSize,
     * @param lat Latitude of the point to create the range distance facets from.
        this.unit = unit;
    /**
        validation.writeTo(out);
            && Objects.equals(order, other.order)
                    geoPoints.add(point);
 *
     * Returns the geo distance type used to compute the distance.
        this.ignoreUnmapped = ignoreUnmapped;
            }
        }
     * @param lon longitude.
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        }
        this.nestedPath = nestedPath;
    /**
    }
 * under the License.
/*
            this.points,
        builder.field(VALIDATION_METHOD_FIELD.getPreferredName(), validation);
    private static final ParseField SORTMODE_FIELD = new ParseField("mode", "sort_mode");
        out.writeString(fieldName);
    public void writeTo(StreamOutput out) throws IOException {
 *
                    }
                fieldType = context.getMapperService().unmappedFieldType("geo_point");
            return false;
                            fieldName
                }
    }
        nestedSort = in.readOptionalWriteable(NestedSortBuilder::new);
                }
import org.opensearch.search.MultiValueMode;
    }
        this.fieldName = fieldName;
    private QueryBuilder nestedFilter;
 * compatible open source license.
     * Returns the nested path if sorting occurs on a field that is inside a nested object. By default when sorting on a
        GeoDistanceSortBuilder other = (GeoDistanceSortBuilder) object;
            ) {
    }
                            protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field) throws IOException {
     * order to be taken into account for sorting.
        this.points.addAll(original.points);
    /**
        return this.nestedFilter;
            && localSortMode == MultiValueMode.MIN // LatLonDocValuesField internally picks the closest point
            }
        } else {
            result.setNestedFilter(nestedFilter);
        };
     *             and retrieve with {@link #getNestedSort()}
    }
        );
     *                    the field name can be passed in via this argument
                return SortField.Type.DOUBLE;
    public GeoDistanceSortBuilder(String fieldName, GeoPoint... points) {
    @Override
    /**
                } else if (NESTED_FIELD.match(currentName, parser.getDeprecationHandler())) {
                GeoPoint point = new GeoPoint();
     **/
            if (ignoreUnmapped) {
    private final String fieldName;
        out.writeOptionalNamedWriteable(nestedFilter);
        }
        if (nestedFilter == null && nestedSort == null) {
                            fieldName
            } else if (token == XContentParser.Token.START_OBJECT) {
        return localPoints;
        }
        }
        if (geoIndexFieldData.getClass() == LatLonPointIndexFieldData.class // only works with 5.x geo_point
    }
                    );
        nestedPath = in.readOptionalString();
        this.ignoreUnmapped = original.ignoreUnmapped;
     * Returns the distance unit to use. Defaults to {@link org.opensearch.common.unit.DistanceUnit#METERS}
    private static final ParseField UNIT_FIELD = new ParseField("unit");
        return this.nestedSort;
    public GeoDistanceSortBuilder(StreamInput in) throws IOException {
    @Deprecated
     *                side effect of this method call
        this.sortMode = original.sortMode;
 */
        if (nestedFilter != null) {
    private static final ParseField VALIDATION_METHOD_FIELD = new ParseField("validation_method");
        validation = GeoValidationMethod.readFromStream(in);
import org.opensearch.index.fielddata.plain.AbstractLatLonPointIndexFieldData.LatLonPointIndexFieldData;
            }
        }
            @Override
                        point.lat(),
    @Override
     * Copy constructor.
        return comparatorSource(localPoints, localSortMode, geoIndexFieldData, nested).newBucketedSort(
                            currentName,
    }
                if (NESTED_FILTER_FIELD.match(currentName, parser.getDeprecationHandler())) {
        this.validation = method;
     * Returns the validation method to use for this sort builder.
                    throw new OpenSearchParseException(
        }
    public GeoDistanceSortBuilder(String fieldName, String... geohashes) {
    }
import org.opensearch.index.fielddata.FieldData;
            builder.field(SORTMODE_FIELD.getPreferredName(), sortMode);
        return this.geoDistance;
    }
                } else {
                    GeoUtils.parseGeoPoint(parser, point);
                }
     *
            }
                    throw new OpenSearchParseException(
    @Override
 * this work for additional information regarding copyright
            } else if (token == XContentParser.Token.START_ARRAY) {
        this(fieldName, new GeoPoint(lat, lon));
import org.apache.lucene.search.LeafFieldComparator;
        if (GeoValidationMethod.isIgnoreMalformed(validation) == false) {
                    if (fieldName != null && fieldName.equals(currentName) == false) {
     * Constructs a new distance based sort on a geo point like field.
    public GeoValidationMethod validation() {
        if (nestedFilter != null) {
                            protected boolean advanceExact(int doc) throws IOException {
        return this;
     * {@link XContent} format.
    private NestedSortBuilder nestedSort;
                        throw new ParsingException(
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
     *             and retrieve with {@link #getNestedSort()}
                            currentName,
        if (nestedFilter != null) {
import org.apache.lucene.search.Pruning;
        geoDistance = GeoDistance.readFromStream(in);
     *             and retrieve with {@link #getNestedSort()}
     */
                // bracket
        }
     */
        GeoValidationMethod validation = null;
            }
     * @param geohashes The points to create the range distance facets from.
                }
        if (sortMode != null) {
     * Sets the nested filter that the nested objects should match with in order to
        points.add(new GeoPoint(lat, lon));
        if (nestedPath != null) {
                point.reset(lat, lon);
     * @param fieldName The geo point like field name.
    /** Returns which distance to use for sorting in the case a document contains multiple geo points. */
        this.nestedPath = original.nestedPath;
     * The point to create the range distance facets from.
        if (nestedSort == null) {
                                return value;
        builder.startArray(fieldName);
     * Sets the nested path if sorting occurs on a field that is inside a nested object. By default when sorting on a
                BigArrays bigArrays,
                GeoUtils.normalizePoint(point, true, true);
     **/
     */
        return this;
                    final BitSet rootDocs = nested.rootDocs(context);
        return this;
    private final List<GeoPoint> points = new ArrayList<>();
            result.setNestedSort(nestedSort);
        result.ignoreUnmapped(ignoreUnmapped);
        if (sortMode == SortMode.SUM) {
    public boolean ignoreUnmapped() {
            extra
        GeoDistanceSortBuilder result = new GeoDistanceSortBuilder(fieldName, geoPoints.toArray(new GeoPoint[0]));
            && Objects.equals(unit, other.unit)
                double lat = parser.doubleValue();
import java.io.IOException;
            this.nestedFilter,
     **/
                return new DoubleComparator(numHits, null, null, reversed, filterPruning(pruning)) {
                    validation = GeoValidationMethod.fromString(parser.text());
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
        }
            builder.field(NESTED_FILTER_FIELD.getPreferredName(), nestedFilter, params);
     * */
     * @param lat latitude.
import org.apache.lucene.search.SortField;
                    unit = DistanceUnit.fromString(parser.text());
        sortMode = in.readOptionalWriteable(SortMode::readFromStream);
    GeoDistanceSortBuilder(GeoDistanceSortBuilder original) {
import org.opensearch.core.xcontent.XContentParser;
    public static final GeoValidationMethod DEFAULT_VALIDATION = GeoValidationMethod.DEFAULT;
                        fieldName
        return this;
        GeoPoint[] localPoints,
                    if (fieldName != null && fieldName.equals(currentName) == false) {
    private GeoValidationMethod validation = DEFAULT_VALIDATION;
                double lon = parser.doubleValue();
        Nested nested = nested(context);
import java.util.Arrays;
        SortOrder order = SortOrder.ASC;
        }
        }
                    @Override
    private SortMode sortMode = null;
     * field inside a nested object, the nearest upper nested object is selected as nested path.
import static org.opensearch.search.sort.FieldSortBuilder.validateMaxChildrenExistOnlyInTopLevelNestedSort;
        }
    public GeoDistanceSortBuilder setNestedFilter(QueryBuilder nestedFilter) {
    /**
    public String getNestedPath() {
                        throw new ParsingException(
/**
    /**
     * Sets the {@link NestedSortBuilder} to be used for fields that are inside a nested
                } else if (IGNORE_UNMAPPED.match(currentName, parser.getDeprecationHandler())) {
 * GitHub history for details.
        builder.field(IGNORE_UNMAPPED.getPreferredName(), ignoreUnmapped);
        boolean ignoreUnmapped = false;
     * field inside a nested object, the nearest upper nested object is selected as nested path.
            QueryBuilder rewrite = nestedFilter.rewrite(ctx);
        validateMaxChildrenExistOnlyInTopLevelNestedSort(context, nestedSort);
        return this;
            this.points.add(GeoPoint.fromGeohash(geohash));
    @Deprecated
    private static final ParseField DISTANCE_TYPE_FIELD = new ParseField("distance_type");
        }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.document.LatLonDocValuesField;
        order.writeTo(out);
    public int hashCode() {
            return MultiValueMode.fromString(sortMode.toString());
    @Deprecated
    }
    /**
            DocValueFormat.RAW,
        // validation was not available prior to 2.x, so to support bwc percolation queries we only ignore_malformed
                if (!parser.currentToken().equals(XContentParser.Token.VALUE_NUMBER)) {
            return resolveNested(context, nestedPath, nestedFilter);
                currentName = parser.currentName();
    }
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
    public GeoDistanceSortBuilder sortMode(SortMode sortMode) {
/*
                    public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {
                } else if (NESTED_PATH_FIELD.match(currentName, parser.getDeprecationHandler())) {
        unit = DistanceUnit.readFromStream(in);
            return this;
     * Defines which distance to use for sorting in the case a document contains multiple geo points.
        this.fieldName = fieldName;
        out.writeOptionalString(nestedPath);
    }
        this.unit = original.unit;
     */
    @Deprecated
    /**
        }
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)}
                        "illegal longitude value [{}] for [GeoDistanceSort] for field [{}].",
        builder.field(ORDER_FIELD.getPreferredName(), order);
    @Override
                    );
    private GeoPoint[] localPoints() {
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)}
        out.writeGenericValue(points);
        builder.startObject(NAME);
                } else if (VALIDATION_METHOD_FIELD.match(currentName, parser.getDeprecationHandler())) {
        this.points.addAll(Arrays.asList(points));
    private DistanceUnit unit = DistanceUnit.DEFAULT;
 * Modifications Copyright OpenSearch Contributors. See
     * Read from a stream.
        points.addAll((List<GeoPoint>) in.readGenericValue());
        return context.getForField(fieldType);
                }
            this.nestedSort,
                        Double.POSITIVE_INFINITY,
            return new GeoDistanceSortBuilder(this).setNestedSort(rewrite);
        NestedSortBuilder nestedSort = null;
            order,
     * be taken into account for sorting.
                } else if (UNIT_FIELD.match(currentName, parser.getDeprecationHandler())) {
                                return false;
            this.unit,
    /**
                    throw new ParsingException(
    }
    private IndexFieldData.XFieldComparatorSource comparatorSource(
    /**
                if (GeoUtils.isValidLatitude(point.lat()) == false) {
                    }
                            @Override
        List<GeoPoint> geoPoints = new ArrayList<>();
        GeoDistance geoDistance = GeoDistance.ARC;
                final MultiGeoPointValues geoPointValues = geoIndexFieldData.load(context).getGeoPointValues();
    }
        result.order(order);
    }
            private NumericDoubleValues getNumericDoubleValues(LeafReaderContext context) throws IOException {
    public GeoDistanceSortBuilder setNestedSort(final NestedSortBuilder nestedSort) {
    private Nested nested(QueryShardContext context) throws IOException {
import java.util.ArrayList;
                        "[nested_filter] has been deprecated in favour of the [nested] parameter"
import org.opensearch.index.fielddata.MultiGeoPointValues;
    @Override
            }
import org.opensearch.core.ParseField;
    ) {
     *                    further parameters, e.g. in '{ "foo": { "order" : "asc"} }'. When parsing the inner object,
        return this.sortMode;
                            }
                    GeoPoint point = new GeoPoint();
                        "geo point parsing: expected second number but got [{}] instead",
                throw new IllegalArgumentException("failed to find mapper for [" + fieldName + "] for geo distance based sort");
     */
                } else {
    }
        GeoPoint[] localPoints = localPoints();
        for (GeoPoint point : points) {
        builder.field(DISTANCE_TYPE_FIELD.getPreferredName(), geoDistance.name().toLowerCase(Locale.ROOT));
    /**
            return new SortFieldAndFormat(
                        point.lon(),
                        parser.currentToken()
    public GeoDistanceSortBuilder(String fieldName, double lat, double lon) {
                            @Override
                        return new Leaf(ctx) {
    public GeoDistanceSortBuilder ignoreUnmapped(boolean ignoreUnmapped) {
                    deprecationLogger.deprecate(
            this.nestedPath,
     *
    }
    @Override
 * Unless required by applicable law or agreed to in writing,
     * Creates a new {@link GeoDistanceSortBuilder} from the query held by the {@link XContentParser} in
        this.nestedSort = original.nestedSort;
        unit.writeTo(out);
                };
            public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
        return builder;
                    fieldName = currentName;
            && Objects.equals(nestedFilter, other.nestedFilter)
     * @param elementName in some sort syntax variations the field name precedes the xContent object that specifies
                }
                                return getNumericDoubleValues(context).getRawDoubleValues();
import org.opensearch.index.query.GeoValidationMethod;
        IndexGeoPointFieldData geoIndexFieldData = fieldData(context);
        }
        this.nestedSort = nestedSort;
    @SuppressWarnings("unchecked")
                    point.resetFromString(parser.text());
        QueryBuilder nestedFilter = null;
     * Returns the geo point like field the distance based sort operates on.
                        innerDocs,
    /**
    public GeoDistanceSortBuilder setNestedPath(String nestedPath) {
     */
        geoDistance.writeTo(out);
            return true;
        if (sortMode != null) {
     */
                return this;
    }
 * specific language governing permissions and limitations
        nestedFilter = in.readOptionalNamedWriteable(QueryBuilder.class);
import org.opensearch.common.logging.DeprecationLogger;
     * Returns the nested filter that the nested objects should match with in order to be taken into account
                // opening bracket in this case we cannot use GeoUtils.parseGeoPoint(..) because this expects an opening
        }
        if (nestedSort != null) {
            NestedSortBuilder rewrite = nestedSort.rewrite(ctx);
        if (this.nestedSort != null) {
            } else {
                } else {
                        );
                            }
    public QueryBuilder getNestedFilter() {
import org.opensearch.common.unit.DistanceUnit;
 * You may obtain a copy of the License at
    private MultiValueMode localSortMode() {
import org.opensearch.index.fielddata.IndexGeoPointFieldData;
        }
            this.ignoreUnmapped
                if (GeoUtils.isValidLongitude(point.lon()) == false) {
                SortOrder sortOrder,
    private GeoDistance geoDistance = GeoDistance.ARC;
     * Sets validation method for this sort builder.
                    public Leaf forLeaf(LeafReaderContext ctx) throws IOException {
            new SortField(fieldName, comparatorSource(localPoints, localSortMode, geoIndexFieldData, nested), reverse),
     * @param lon Longitude of the point to create the range distance facets from.
     */
            && reverse == false
     * for sorting.
                LatLonDocValuesField.newDistanceSort(fieldName, localPoints[0].lat(), localPoints[0].lon()),
        );
    }
                        distanceValues,
            if (nestedFilter == rewrite) {
        }
import org.opensearch.OpenSearchParseException;
            @Override
     * @param parser the input parser. The state on the parser contained in this context will be changed as a
package org.opensearch.search.sort;
        builder.startObject();
                } else if (fieldName.equals(currentName)) {
     */
     */
            && Objects.equals(validation, other.validation)
import org.opensearch.index.query.QueryRewriteContext;
            result.validation(validation);
                        currentName
     */
import org.opensearch.common.util.BigArrays;
        return Objects.equals(fieldName, other.fieldName)
import org.apache.lucene.search.comparators.DoubleComparator;
        this.points.addAll(Arrays.asList(points));
            if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
        MappedFieldType fieldType = context.fieldMapper(fieldName);
        if (object == null || getClass() != object.getClass()) {
    public DistanceUnit unit() {
    public GeoDistanceSortBuilder points(GeoPoint... points) {
        this.nestedFilter = nestedFilter;
 * license agreements. See the NOTICE file distributed with
        String currentName = parser.currentName();
     */
                DocValueFormat format,
import org.apache.lucene.util.BitSet;
 */
    public NestedSortBuilder getNestedSort() {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.DocIdSetIterator;
import org.opensearch.search.DocValueFormat;
        out.writeOptionalWriteable(nestedSort);
        return new SortFieldAndFormat(
        if (this == object) {
    /**
    }
    }
            builder.field(NESTED_PATH_FIELD.getPreferredName(), nestedPath);
    public static GeoDistanceSortBuilder fromXContent(XContentParser parser, String elementName) throws IOException {
            throw new IllegalArgumentException("sort_mode [sum] isn't supported for sorting by geo distance");
                // we might get here if the geo point is " number, number] " and the parser already moved over the
import org.opensearch.index.query.QueryBuilder;
 * The OpenSearch Contributors require contributions made to
            && Objects.equals(nestedPath, other.nestedPath)
        if (nestedSort != null) {
     *
import java.util.List;
     * Returns the {@link NestedSortBuilder}
                    GeoPoint point = new GeoPoint();
        return result;
                            "Trying to reset fieldName to [{}], already set to [{}].",
        return new IndexFieldData.XFieldComparatorSource(null, localSortMode, nested) {
    }
                    throw new OpenSearchParseException(
                parseGeoPoints(parser, geoPoints);
        }
                final SortedNumericDoubleValues distanceValues = GeoUtils.distanceValues(geoDistance, unit, geoPointValues, localPoints);
    /**
     * @param fieldName The geo point like field name.
    }
                    nestedSort = NestedSortBuilder.fromXContent(parser);
                            private final NumericDoubleValues values = getNumericDoubleValues(ctx);
        this.geoDistance = geoDistance;
        this.geoDistance = original.geoDistance;
     * @param points reference points.
            && Objects.equals(nestedSort, other.nestedSort)
            bucketSize,
        return NAME;
import org.apache.lucene.search.FieldComparator;
                                if (values.advanceExact(doc)) {
        // on 2.x created indexes
     *
                        "geo_distance_nested_path",
                                    value = values.doubleValue();
        SortMode sortMode = null;
        if (this.nestedSort != null) {
        IndexGeoPointFieldData geoIndexFieldData,
                        "Only geohashes of type string supported for field [{}]",
                    );
        this.fieldName = original.fieldName();
        }
import org.opensearch.core.xcontent.XContentParser.Token;
 *
        result.setNestedPath(nestedPath);
        return order == SortOrder.DESC ? MultiValueMode.MAX : MultiValueMode.MIN;
import org.opensearch.common.geo.GeoDistance;
    }
        Nested nested = nested(context);
     * nested filter that the nested objects should match with in
            result.sortMode(sortMode);
        Objects.requireNonNull(sortMode, "sort mode cannot be null");
     **/
import static org.opensearch.search.sort.NestedSortBuilder.NESTED_FIELD;
    public SortFieldAndFormat build(QueryShardContext context) throws IOException {
                    );
        DistanceUnit unit = DistanceUnit.DEFAULT;
     */
    public String getWriteableName() {
                geoPoints.add(point);
                    deprecationLogger.deprecate(
        MultiValueMode localSortMode,
 * software distributed under the License is distributed on an
        // TODO this lines up with FieldSortBuilder. Share?
            this.order,
 * not use this file except in compliance with the License.
            if (token == XContentParser.Token.FIELD_NAME) {
     */
    /**
    }
     * Returns the points to create the range distance facets from.
            && unit == DistanceUnit.METERS
 * Licensed to Elasticsearch under one or more contributor
        return this.fieldName;
    }
        ignoreUnmapped = in.readBoolean();
    public boolean equals(Object object) {
import org.opensearch.core.common.ParsingException;
                    }
        XContentParser.Token token;
        out.writeOptionalWriteable(sortMode);
        }
            builder.value(point);
    /**
 * ownership. Elasticsearch licenses this file to you under
    }
     * Returns true if unmapped geo fields should be treated as located at an infinite distance
    public static final String NAME = "_geo_distance";
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)}
        );
                        };
import org.opensearch.common.geo.GeoPoint;
    public BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra) throws IOException {
                        "illegal latitude value [{}] for [GeoDistanceSort] for field [{}].",
                } else if (DISTANCE_TYPE_FIELD.match(currentName, parser.getDeprecationHandler())) {
                };
            && nested == null
                    geoDistance = GeoDistance.fromString(parser.text());
            this.sortMode,
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(GeoDistanceSortBuilder.class);
            }
 * A geo distance based sorting on a geo point like field.
    }
                    geoPoints.add(point);
                        );
            @Override
                                    return true;
            builder.field(NESTED_FIELD.getPreferredName(), nestedSort);
        return this;
        result.geoDistance(geoDistance);
    /**
                BucketedSort.ExtraData extra
    }
                        return new DoubleLeafComparator(context) {
    /**
        }
                    fieldName = currentName;
    private IndexGeoPointFieldData fieldData(QueryShardContext context) {
import org.opensearch.index.fielddata.IndexFieldData;
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
            public BucketedSort newBucketedSort(
                parser.nextToken();
            }
        this.order = original.order;
                    nestedFilter = parseInnerQueryBuilder(parser);
    /**
                                }
                    ignoreUnmapped = parser.booleanValue();
            if (nestedSort == rewrite) {
        String fieldName = null;
    public static final String ALTERNATIVE_NAME = "_geoDistance";
            && Objects.equals(sortMode, other.sortMode)
            } else if (token.isValue()) {
                fieldName = currentName;
import org.opensearch.index.query.QueryShardContext;
            return new GeoDistanceSortBuilder(this).setNestedFilter(rewrite);
        if (sortMode != null) {
                if (nested == null) {
                } else if (SORTMODE_FIELD.match(currentName, parser.getDeprecationHandler())) {
import org.opensearch.index.fielddata.NumericDoubleValues;
        if (validation != null) {
     * The point to create the range distance facets from.
    /**
    /**
    public String fieldName() {
     */
                            private double value;
     * */
    }
        return this.unit;
    public GeoDistanceSortBuilder validation(GeoValidationMethod method) {
        this.nestedFilter = original.nestedFilter;
        return this.nestedPath;
import java.util.Locale;
                    final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;
        return ignoreUnmapped;
    }
                    );
     * @param fieldName The geo point like field name.
            && ignoreUnmapped == other.ignoreUnmapped;
        order = SortOrder.readFromStream(in);
import org.apache.lucene.index.LeafReaderContext;
        }
                        context.reader().maxDoc(),
                    return FieldData.replaceMissing(sortMode.select(distanceValues), Double.POSITIVE_INFINITY);
 * the Apache License, Version 2.0 (the "License"); you may
            DocValueFormat.RAW
            this.validation,
            }
                GeoPoint point = new GeoPoint();
        if (fieldType == null) {
            } else {
        }
import org.opensearch.core.common.io.stream.StreamOutput;
                GeoUtils.parseGeoPoint(parser, point);
import org.opensearch.index.mapper.MappedFieldType;
        while (!parser.nextToken().equals(XContentParser.Token.END_ARRAY)) {
    public GeoDistanceSortBuilder unit(DistanceUnit unit) {
        // If we have a nestedSort we'll use that. Otherwise, use old style.
        return validation;
        MultiValueMode localSortMode = localSortMode();
                return new BucketedSort.ForDoubles(bigArrays, sortOrder, format, bucketSize, extra) {
import org.opensearch.common.geo.GeoUtils;
        }
    @Override
                    return localSortMode.select(
                    }
                    order = SortOrder.fromString(parser.text());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
