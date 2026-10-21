                true,
        }
/*
    @Override
import org.opensearch.common.time.DateUtils;
        DocValueFormat docValueFormat = bottomSortValues.getSortValueFormats()[0];
        }
            builder.field(NUMERIC_TYPE.getPreferredName(), numericType);
            case INT:
    private Object missing;
import org.apache.lucene.index.IndexReader;
        this.numericType = template.numericType;
        sortMode = in.readOptionalWriteable(SortMode::readFromStream);
            && Objects.equals(this.missing, builder.missing)
        }
                if (fieldType.unwrap() instanceof KeywordFieldMapper.KeywordFieldType) {
    private SortMode sortMode;
        out.writeOptionalString(unmappedType);
        if (template.sortMode != null) {
                    return terms.getMin() != null ? new MinAndMax<>(terms.getMin(), terms.getMax()) : null;
                    "[numeric_type] option cannot be set on a non-numeric field, got " + fieldType.typeName()
    /**
        String numericTypeStr = sortBuilder.getNumericType();
    public String getNumericType() {
        }
            builder.field(NESTED_FILTER_FIELD.getPreferredName(), nestedFilter, params);
            format = DocValueFormat.withNanosecondResolution(format);
        }
 * Licensed to Elasticsearch under one or more contributor
        out.writeOptionalString(nestedPath);
     * is set on a field that is not mapped as a numeric in some indices.
                e
            builder.field(SORT_MODE.getPreferredName(), sortMode);
 * this file be licensed under the Apache-2.0 license or a
        }
        return this.fieldName;
        this.order(template.order());
     * Read from a stream.
    public FieldSortBuilder setNestedSort(final NestedSortBuilder nestedSort) {
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            case "double":
        return this;
import org.opensearch.index.query.QueryBuilder;
        validateMaxChildrenExistOnlyInTopLevelNestedSort(context, nestedSort);
        switch (value) {
import org.opensearch.core.xcontent.XContent;
            builder.field(NESTED_PATH_FIELD.getPreferredName(), nestedPath);
                minValue,
 *
        if (this == other) {
public class FieldSortBuilder extends SortBuilder<FieldSortBuilder> implements WithFieldName {
     */
        return missing;
import org.opensearch.core.xcontent.XContentBuilder;
    ) throws IOException {
 * KIND, either express or implied.  See the License for the
        if (fieldType.unwrap() instanceof NumberFieldType numberFieldType) {
        }
            return false;
            default:
     * Returns the type to use in case the current field is not mapped in an
import org.opensearch.core.xcontent.ObjectParser;
            Long max = dateConverter.apply(PointValues.getMaxPackedValue(reader, fieldName));
        }
        }
     * Throws an exception if max children is not located at top level nested sort.
    }
                        return new MinAndMax<>((BigInteger) minPoint, (BigInteger) maxPoint);
            return new FieldSortBuilder(this).setNestedSort(rewrite);
    public static final ParseField NUMERIC_TYPE = new ParseField("numeric_type");
        this(template.fieldName);
        if (bottomSortValues == null || bottomSortValues.getRawSortValues().length == 0) {
            switch (IndexSortConfig.getSortFieldType(sortField)) {
     *            The field name.
        }
            if (child.getMaxChildren() != Integer.MAX_VALUE) {
        if (isNanosecond) {
        }
    public FieldSortBuilder rewrite(QueryRewriteContext ctx) throws IOException {
        return NAME;
     */
        nestedPath = in.readOptionalString();
    @Override
     * @param parser the input parser. The state on the parser contained in this context will be changed as a side effect of this
        return v -> LongPoint.decodeDimension(v, 0);
     * is an instance of this class, null otherwise.
    /**
        }
        }
                missing,
                    context,
        return null;
    }
    public int hashCode() {
            && Objects.equals(this.nestedFilter, builder.nestedFilter)
 * ownership. Elasticsearch licenses this file to you under
            );
    }
        if (numericType != null) {
        SortAndFormats sort
import org.opensearch.core.ParseField;
        if (fieldData instanceof IndexNumericFieldData == false
        QueryShardContext context,
            if (dateFieldType.resolution() == MILLISECONDS && numericType == NumericType.DATE_NANOSECONDS) {
    public FieldSortBuilder setNumericType(String numericType) {
        return getMinMaxOrNullInternal(ctx.reader(), context, sortBuilder, sort);
     */
        if (PointValues.size(reader, fieldName) == 0) {
                    "invalid value for [numeric_type], " + "must be [long, double, date, date_nanos], got " + lowerCase
    }
            deprecationLogger.deprecate(
        PARSER.declareString(FieldSortBuilder::unmappedType, UNMAPPED_TYPE);
                maxValue,
import org.apache.lucene.index.Terms;
        switch (lowerCase) {
     */
            return SortBuilder.parseNestedFilter(p);
    }
    public SortFieldAndFormat build(QueryShardContext context) throws IOException {
 */
                    + "]: "
        final SortField field;
            this.numericType
    public boolean equals(Object other) {
    }
     * index.
        PARSER.declareObject(FieldSortBuilder::setNestedFilter, (p, c) -> {
                return v -> DateUtils.toNanoSeconds(LongPoint.decodeDimension(v, 0));
                order,
}
                    + "] of type ["
import org.opensearch.index.query.WithFieldName;
    public static FieldSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {
        }
                return v -> DateUtils.toMilliSeconds(LongPoint.decodeDimension(v, 0));
    /**
        }
import java.util.Objects;
     *
        if (numericType != null) {
        }
import static org.opensearch.index.mapper.DateFieldMapper.Resolution.MILLISECONDS;
            && Objects.equals(this.order, builder.order)
            Function<byte[], Long> dateConverter = createDateConverter(sortBuilder, dateFieldType);
        out.writeOptionalNamedWriteable(nestedFilter);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return this.nestedPath;
    /**
    @Deprecated
    private static Function<byte[], Long> createDateConverter(FieldSortBuilder sortBuilder, DateFieldType dateFieldType) {
    @Override
    public String fieldName() {
import java.io.IOException;
        if (nestedFilter == null && nestedSort == null) {
    /** Returns the document field this sort should be based on. */
import org.apache.lucene.search.SortField;
        QueryShardContext context,
        }
            case "unsigned_long":
        if (template.getNestedSort() != null) {
    public boolean isBottomSortShardDisjoint(QueryShardContext context, SearchSortValuesAndFormats bottomSortValues) throws IOException {
                localSortMode(),
    private String numericType;
        MappedFieldType fieldType = context.fieldMapper(fieldName);
        out.writeString(fieldName);
        return resolveNested(context, nestedSort);
        if (nestedFilter != null) {
            case STRING:
    @Override
            return false;
 * GitHub history for details.
                    return new MinAndMax<>(minPoint.intValue(), maxPoint.intValue());
        }
    public static boolean hasPrimaryFieldSort(SearchSourceBuilder source) {
import org.opensearch.index.mapper.MappedFieldType;
            this.nestedSort,
 * specific language governing permissions and limitations
    public static MinAndMax<?> getMinMaxOrNull(QueryShardContext context, FieldSortBuilder sortBuilder) throws IOException {
        }
 * compatible open source license.
        return source.sorts().get(0) instanceof FieldSortBuilder fieldSortBuilder ? fieldSortBuilder : null;
        }
    }
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
import java.util.function.Function;
            throw new IllegalArgumentException("sorting by _doc is not supported");
    /**
                    }
        this.setNestedFilter(template.getNestedFilter());
    private static MinAndMax<?> extractNumericMinAndMax(
            return MultiValueMode.fromString(sortMode.toString());
import java.util.Locale;
        switch (IndexSortConfig.getSortFieldType(sortField)) {
                nested,
            isNanosecond = resolvedType == NumericType.DATE_NANOSECONDS;
        new SortField(null, SortField.Type.DOC, true),
    }
                    + fieldType.typeName()
                throw new QueryShardException(
        return PARSER.parse(parser, new FieldSortBuilder(fieldName), null);
 * Modifications Copyright OpenSearch Contributors. See
    }
        } catch (IllegalArgumentException e) {
     *
    }
            && (sortMode == SortMode.SUM || sortMode == SortMode.AVG || sortMode == SortMode.MEDIAN)) {
            NestedSortBuilder rewrite = nestedSort.rewrite(ctx);
    public boolean canRewriteToMatchNone() {
        }
 * @opensearch.internal
    }
        missing = in.readGenericValue();
     */
            return false;
     * Return true if the primary sort in the provided <code>source</code>
        numericType = in.readOptionalString();
        out.writeGenericValue(missing);
    @Override
            throw new ParsingException(parser.getTokenLocation(), "Invalid " + NAME);
    }
        return this;
     */
import org.apache.lucene.index.PointValues;
        DocValueFormat format = fieldType.docValueFormat(null, null);
            && Objects.equals(this.nestedPath, builder.nestedPath)
        boolean isNanosecond = false;
                        // The min and max are expected to be BigInteger numbers
        builder.endObject();
     * <p>
import org.opensearch.search.SearchSortValuesAndFormats;
        final DateMathParser dateMathParser;
     * The value can be extracted on non-nested indexed mapped fields of type keyword, numeric or date, other fields
     * order to be taken into account for sorting.
     * Returns the nested path if sorting occurs in a field that is inside a
    /**
                }
 * SPDX-License-Identifier: Apache-2.0
                case DOUBLE:
     * values for the targeted sort field.
    public FieldSortBuilder setNestedPath(String nestedPath) {
            fieldSortBuilder.setNestedPath(nestedPath);
        if (DOC_FIELD_NAME.equals(fieldName)) {
                    return new MinAndMax<>(minPoint.doubleValue(), maxPoint.doubleValue());
import org.opensearch.index.query.QueryShardException;
    public BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra) throws IOException {
    /**
        return this.unmappedType;
            case "long":
        }
        }
        IndexReader reader,
        out.writeOptionalWriteable(nestedSort);
        if (docValueFormat instanceof DocValueFormat.DateTime dateTime) {
        SortField sortField = sort.sort.getSort()[0];
     */
import org.apache.lucene.index.LeafReaderContext;
 *
                    context,
            }
    }
    }
    }
        return Objects.hash(
        if (nestedSort != null) {
    public String getFieldName() {
        if (this.nestedFilter != null || this.nestedPath != null) {
        return numericType;
    }
        return this;
     *        in '{ "foo": { "order" : "asc"} }'. When parsing the inner object, the field name can be passed in via this argument
            && (sortMode == SortMode.SUM || sortMode == SortMode.AVG || sortMode == SortMode.MEDIAN)) {
    /**
            NumericType resolvedType = resolveNumericType(numericType);
    @Override
        Nested nested = nested(context, fieldType);
        return this.sortMode;
        return getPrimaryFieldSortOrNull(source) != null;
        FieldSortBuilder sortBuilder
     */
        return builder;
                    } else {
                return this;
        }, NESTED_FILTER_FIELD);
        unmappedType = in.readOptionalString();
            this.setNestedSort(template.getNestedSort());
import org.opensearch.index.query.QueryRewriteContext;
        }
            this.nestedPath,
        }
            );
        } else {
    }
                fieldType.docValueFormat(null, null),
     * and configurations return <code>null</code>.
    @Deprecated
     * Returns whether some values of the given {@link QueryShardContext#getIndexReader()} are within the
    private NestedSortBuilder nestedSort;
        if (nestedFilter != null) {
 * the Apache License, Version 2.0 (the "License"); you may
            this.unmappedType,
 * license agreements. See the NOTICE file distributed with
/*
        }
import org.opensearch.index.fielddata.IndexNumericFieldData;
     * Returns what values to pick in the case a document contains multiple
                    return new MinAndMax<>(minPoint.floatValue(), maxPoint.floatValue());
        this.missing = missing;
                        return null;
        Object bottomSortValue = bottomSortValues.getFormattedSortValues()[0];
        return this;
            case "date":
            return true;
 */
                isNanosecond = numericFieldData.getNumericType() == NumericType.DATE_NANOSECONDS;
            && Objects.equals(this.nestedSort, builder.nestedSort)) && Objects.equals(this.numericType, builder.numericType);
 * software distributed under the License is distributed on an
    /** Returns the value used when a field is missing in a doc. */
            if (fieldData instanceof IndexNumericFieldData numericFieldData) {
        if (fieldType == null) {
     */
     * Sets the nested filter that the nested objects should match with in order
 * You may obtain a copy of the License at
import org.opensearch.OpenSearchParseException;
    ) throws IOException {
    public String getNestedPath() {
            return null;
import org.opensearch.search.builder.SearchSourceBuilder;
    }
    private Nested nested(QueryShardContext context, MappedFieldType fieldType) throws IOException {
        Object minValue = order() == SortOrder.DESC ? bottomSortValue : null;
        }
    public static FieldSortBuilder getPrimaryFieldSortOrNull(SearchSourceBuilder source) {
    }
            return false;
    }
            );
            default:
                case INT:
        return this;
    public static final String NAME = "field_sort";
            return null;
     * Sets the value when a field is missing in a doc. Can also be set to {@code _last} or
     */
     */
                    + context.index().getName()
 * Unless required by applicable law or agreed to in writing,
        DocValueFormat.RAW
            return numericFieldData.newBucketedSort(
    }
     * is an instance of {@link FieldSortBuilder}.
                true,
                return NumericType.LONG;
    public FieldSortBuilder setNestedFilter(QueryBuilder nestedFilter) {
package org.opensearch.search.sort;
        IndexFieldData<?> fieldData = context.getForField(fieldType);
        if (builder == null) {
            QueryBuilder rewrite = nestedFilter.rewrite(ctx);
        if (fieldData instanceof IndexNumericFieldData == false
        if (DOC_FIELD_NAME.equals(fieldName)) {
        this.fieldName = fieldName;
        // If we have a nestedSort we'll use that. Otherwise, use old style.
            if (nestedSort == rewrite) {
        return getFieldName();
     * to be taken into account for sorting.
        this.nestedFilter = nestedFilter;
        }
                return NumericType.DOUBLE;
            field = fieldData.sortField(missing, localSortMode(), nested, reverse);
            return false;
    }
                bucketSize,
            return relation == MappedFieldType.Relation.DISJOINT;
            } else {
                    return null;
        XContentParser.Token token;
import org.opensearch.core.xcontent.XContentParser;
                    Terms terms = MultiTerms.getTerms(reader, fieldType.name());
            this.sortMode(template.sortMode());
            builder.field(MISSING.getPreferredName(), missing);
    }
            // unmapped
    public static final ParseField SORT_MODE = new ParseField("mode");
        return (Objects.equals(this.fieldName, builder.fieldName)
    }
            return null;
                "[nested_filter] has been deprecated in favour for the [nested] parameter"
 * A sort builder to sort based on a document field.
import java.util.Collections;
                break;
        }
import static org.opensearch.index.mapper.DateFieldMapper.Resolution.NANOSECONDS;
        builder.startObject();
        if (sortMode != null) {
            case "date_nanos":
        } else if (fieldType.unwrap() instanceof DateFieldType dateFieldType) {
        return this;
    @Override
            return new FieldSortBuilder(this).setNestedFilter(rewrite);
    private String unmappedType;
    static {
                return extractNumericMinAndMax(reader, sortField, fieldType, sortBuilder);
    static void validateMaxChildrenExistOnlyInTopLevelNestedSort(QueryShardContext context, NestedSortBuilder nestedSort) {
    public static final ParseField MISSING = new ParseField("missing");
            return null;
            }
                    if (terms == null) {
import org.opensearch.search.MultiValueMode;
     * the same type on all indices.
import org.opensearch.search.DocValueFormat;
            }
            Number minPoint = numberFieldType.parsePoint(PointValues.getMinPackedValue(reader, fieldName));
            case STRING_VAL:
            return order == SortOrder.DESC ? SORT_DOC_REVERSE : SORT_DOC;
    /**
        MappedFieldType fieldType = context.fieldMapper(fieldName);
     * nested object.
import org.opensearch.core.common.io.stream.StreamInput;
        if (canRewriteToMatchNone() == false) {
                    "invalid value for [numeric_type], " + "must be [long, double, date, date_nanos], got " + value
                    + "] in index ["
import static org.opensearch.search.sort.NestedSortBuilder.NESTED_FIELD;
    /**
        builder.endObject();
        if (numericTypeStr != null) {
            if (!(fieldData instanceof IndexNumericFieldData numericFieldData)) {
 */
            dateMathParser = null;
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
                context.bigArrays(),
        if (nestedSort == null) {
    private MultiValueMode localSortMode() {
            if (nestedFilter == rewrite) {
     * Specifying a type tells OpenSearch what type the sort values should
        SortField sortField,
    private static final ObjectParser<FieldSortBuilder, Void> PARSER = new ObjectParser<>(NAME);
            }
        String currentFieldName = null;
        nestedFilter = in.readOptionalNamedWriteable(QueryBuilder.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.index.MultiTerms;
     */
        IndexReader reader,
            return new MinAndMax<>(min, max);
    public static MinAndMax<?> getMinMaxOrNullForSegment(
        if (sortMode != null) {
 * The OpenSearch Contributors require contributions made to
            }
        }
/*
            case "long":
        out.writeOptionalString(numericType);
     */
import org.opensearch.core.xcontent.ObjectParser.ValueType;
     * Returns the {@link NestedSortBuilder}
        nestedSort = in.readOptionalWriteable(NestedSortBuilder::new);
        MappedFieldType fieldType,
                extra
    public void writeTo(StreamOutput out) throws IOException {
        if (fieldName == null) {
     * Return the {@link MinAndMax} indexed value for shard from the provided {@link FieldSortBuilder} or <code>null</code> if unknown.
        out.writeOptionalWriteable(order);
            );
            field = numericFieldData.sortField(resolvedType, missing, localSortMode(), nested, reverse);
    }
                currentFieldName = parser.currentName();
     * Sets the {@link NestedSortBuilder} to be used for fields that are inside a nested
        PARSER.declareField(FieldSortBuilder::missing, XContentParser::objectText, MISSING, ValueType.VALUE);
        );
import org.opensearch.common.time.DateMathParser;
        }
        FieldSortBuilder sortBuilder,
    /**
 * not use this file except in compliance with the License.
        if (reader == null || (fieldType == null || fieldType.isSearchable() == false)) {
                order,
        }
        PARSER.declareString((b, v) -> b.sortMode(SortMode.fromString(v)), SORT_MODE);
    }
        return nestedSort == null && (missing == null || "_last".equals(missing));
    public QueryBuilder getNestedFilter() {
                context.bigArrays(),
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
            case "date":
        if (other == null || getClass() != other.getClass()) {
    private static final SortFieldAndFormat SORT_DOC = new SortFieldAndFormat(new SortField(null, SortField.Type.DOC), DocValueFormat.RAW);
     */
        this.numericType = lowerCase;
            MappedFieldType.Relation relation = fieldType.isFieldWithinQuery(
import org.opensearch.core.common.io.stream.StreamOutput;
                    "[numeric_type] option cannot be set on a non-numeric field, got " + fieldType.typeName()
            this.nestedFilter,
                );
/**
        }
     *
import java.math.BigInteger;
            throw new IllegalArgumentException("fieldName must not be null");
                    }
    public String getWriteableName() {
        if (numericType != null) {
     * Specifying a numeric type tells OpenSearch what type the sort values should
            builder.field(UNMAPPED_TYPE.getPreferredName(), unmappedType);
        return order == SortOrder.DESC ? MultiValueMode.MAX : MultiValueMode.MIN;
    public SortMode sortMode() {
import org.opensearch.index.IndexSortConfig;
            this.order,
     */
            case "double":
    public Object missing() {
        if (fieldType == null) {
    }
    }
            && Objects.equals(this.sortMode, builder.sortMode)
 * this work for additional information regarding copyright
        return getMinMaxOrNullInternal(context.getIndexReader(), context, sortBuilder, sort);
                throw new IllegalArgumentException(
     * Defines what values to pick in the case a document contains multiple
    public static final ParseField UNMAPPED_TYPE = new ParseField("unmapped_type");
        }
    }
    private static final SortFieldAndFormat SORT_DOC_REVERSE = new SortFieldAndFormat(
    /**
     * have, which is important for cross-index search, if there are sort fields
    }
 *
                context.getIndexReader(),
    }
            Long min = dateConverter.apply(PointValues.getMinPackedValue(reader, fieldName));
        Nested nested = nested(context, fieldType);
            deprecationLogger.deprecate("field_sort_nested_path", "[nested_path] has been deprecated in favor of the [nested] parameter");
                );
            case LONG:
            }
    public FieldSortBuilder(String fieldName) {
    public static FieldSortBuilder fromXContentObject(XContentParser parser, String fieldName) throws IOException {
        if (missing != null) {
        if (unmappedType != null) {
        return new SortFieldAndFormat(field, format);
        }
        if (unmappedType == null) {
        if (sortField.getField() == null) {
                throw new QueryShardException(
    /**
        return null;
     * order to be taken into account for sorting.
        FieldSortBuilder builder = null;
            if (!(fieldData instanceof IndexNumericFieldData numericFieldData)) {
     * object. By default when sorting on a field inside a nested object, the
        LeafReaderContext ctx,
    private String nestedPath;
    );
            throw new QueryShardException(context, "we only support AVG, MEDIAN and SUM on number based fields");
    @Override
     * nearest upper nested object is selected as nested path.
                null,
    private QueryBuilder nestedFilter;
                throw new IllegalArgumentException(
        builder.field(ORDER_FIELD.getPreferredName(), order);
        String fieldName = fieldType.name();
import org.opensearch.common.logging.DeprecationLogger;
    /**
                context
        }
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
    public String unmappedType() {
import org.opensearch.core.common.ParsingException;
        }
import org.opensearch.index.query.QueryShardContext;
     * mapping for the current field.
            } else if (token == XContentParser.Token.START_OBJECT) {
        fieldName = in.readString();
            NumericType resolvedType = resolveNumericType(numericType);
    public FieldSortBuilder(FieldSortBuilder template) {
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
        try {
        try {
            } else if (dateFieldType.resolution() == NANOSECONDS && numericType == NumericType.DATE) {
     */
        }, NESTED_PATH_FIELD);
    /**
        if (fieldType.isSearchable() == false) {
            );
        if (this.nestedSort != null) {
        }
        }
                return NumericType.DATE_NANOSECONDS;
        }
            return false;
                    + e.getMessage(),
    ) throws IOException {
     * avg
                missing,
     * The value can be extracted on non-nested indexed mapped fields of type keyword, numeric or date, other fields
    /**
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
        }
    }
                );
        }
     *
                return this;
    }
                return NumericType.DATE;
        this.nestedPath = nestedPath;
        order = in.readOptionalWriteable(SortOrder::readFromStream);
            this.sortMode,
            return null;
        builder.startObject(fieldName);
            }
        } catch (OpenSearchParseException exc) {
        }
            this.fieldName,
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
        return this.nestedFilter;
    public static final String DOC_FIELD_NAME = "_doc";
                    if (numberFieldType.numericType() == NumericType.UNSIGNED_LONG) {
        PARSER.declareObject(FieldSortBuilder::setNestedSort, (p, c) -> NestedSortBuilder.fromXContent(p), NESTED_FIELD);
            && Objects.equals(this.unmappedType, builder.unmappedType)
            fieldType = resolveUnmappedType(context);
     * Set the type to use in case the current field is not mapped in an index.
     * Returns the nested filter that the nested objects should match with in
            throw new QueryShardException(context, "No mapping found for [" + fieldName + "] in order to sort on");
    public NestedSortBuilder getNestedSort() {
    @Deprecated
     * special field name to sort by index order
     *
     * nested filter that the nested objects should match with in
        this.unmappedType(template.unmappedType());
        PARSER.declareString(FieldSortBuilder::setNumericType, NUMERIC_TYPE);
    /**
        } else {
                        return new MinAndMax<>(minPoint.longValue(), maxPoint.longValue());
        } else {
    }
        MappedFieldType fieldType = context.fieldMapper(fieldName);
            this.missing,
     * Forces the numeric type to use for the field. The query will fail if this option
     * Allowed values are <code>long</code>, <code>double</code>, <code>date</code> and <code>date_nanos</code>.
        if (source == null || source.sorts() == null || source.sorts().isEmpty()) {
        Objects.requireNonNull(sortMode, "sort mode cannot be null");
            }
 *
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(FieldSortBuilder.class);
    private static NumericType resolveNumericType(String value) {
     */
            return this;
            return fieldData.newBucketedSort(
        return this.nestedSort;
                "error building sort for field ["
    /**
     * primary sort value provided in the <code>bottomSortValues</code>.
                throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] does not support [" + currentFieldName + "]");
            case "date_nanos":
        return builder;
                );
        if (this.nestedSort != null) {
            throw new QueryShardException(context, "we only support AVG, MEDIAN and SUM on number based fields");
     * if the original numeric type should be preserved.
                "field_sort_nested_filter",
 *    http://www.apache.org/licenses/LICENSE-2.0
        boolean reverse = order == SortOrder.DESC;
     * have, which is important for cross-index search, if a field does not have
        FieldSortBuilder builder = (FieldSortBuilder) other;
        }
     */
    }
    public FieldSortBuilder sortMode(SortMode sortMode) {
            fieldType = resolveUnmappedType(context);
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
     * Return the {@link MinAndMax} indexed value for segment from the provided {@link FieldSortBuilder} or <code>null</code> if unknown.
            Number maxPoint = numberFieldType.parsePoint(PointValues.getMaxPackedValue(reader, fieldName));
        MappedFieldType fieldType = context.fieldMapper(sortField.getField());
     * {@link XContent} format.
                bucketSize,
    /**
    }
    private static MinAndMax<?> getMinMaxOrNullInternal(
     * {@code _first} to sort missing last or first respectively.
            }
    }
    }
                return NumericType.UNSIGNED_LONG;
import org.apache.lucene.document.LongPoint;
     * values for the targeted sort field. Possible values: min, max, sum and
    public static final String ID_FIELD_NAME = "_id";
        }
     * Returns the numeric type that values should translated to or null
                case LONG:
    @Override
        this.setNestedPath(template.getNestedPath());
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
        String lowerCase = numericType.toLowerCase(Locale.ENGLISH);
    }
     */
        return this;
    }
    /**
            dateMathParser = dateTime.getDateMathParser();
                extra
        if (fieldType == null) {
        }
    private final String fieldName;
     * and configurations return <code>null</code>.
     * Constructs a new sort based on a document field.
                break;
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
        }
     * Return the {@link FieldSortBuilder} if the primary sort in the provided <code>source</code>
        this.nestedSort = nestedSort;
        IndexFieldData<?> fieldData = context.getForField(fieldType);
        FieldSortBuilder sortBuilder,
            throw new IllegalArgumentException(
    }
     *
            NumericType numericType = resolveNumericType(numericTypeStr);
     * The last two values are only applicable for number based fields.
                dateMathParser,
    /** Copy constructor. */
        out.writeOptionalWriteable(sortMode);
    /**
        SortAndFormats sort
                localSortMode(),
import org.opensearch.index.fielddata.IndexFieldData;
     *        method call
        Object maxValue = order() == SortOrder.DESC ? null : bottomSortValue;
                default:
     * object. The {@link NestedSortBuilder} takes a `path` argument and an optional
        this.unmappedType = type;
        if (nestedPath != null) {
 */
        return context.getMapperService().unmappedFieldType(unmappedType);
        }
     * @param fieldName in some sort syntax variations the field name precedes the xContent object that specifies further parameters, e.g.
                nested,
 * under the License.
    }
    /**
        this.sortMode = sortMode;
                case FLOAT:
            return resolveNested(context, nestedPath, nestedFilter);
            case DOUBLE:
     * that exist on some indices only. If the unmapped type is {@code null}
    public FieldSortBuilder unmappedType(String type) {
     * Sets the nested path if sorting occurs on a field that is inside a nested
    }
                    + fieldName
import org.opensearch.index.mapper.KeywordFieldMapper;
        final SortAndFormats sort = SortBuilder.buildSort(Collections.singletonList(sortBuilder), context).get();
     * then query execution will fail if one or more indices don't have a
    @Deprecated
            builder.field(NESTED_FIELD.getPreferredName(), nestedSort);
        if (fieldType == null) {
                builder = fromXContent(parser, currentFieldName);
            case FLOAT:
    public FieldSortBuilder(StreamInput in) throws IOException {
            // can happen if the sort field is mapped differently in another search index
    /**
                fieldType.docValueFormat(null, null),
    }
        for (NestedSortBuilder child = nestedSort.getNestedSort(); child != null; child = child.getNestedSort()) {
     */
     */
    private MappedFieldType resolveUnmappedType(QueryShardContext context) {
        this.missing(template.missing());
    public FieldSortBuilder missing(Object missing) {
        PARSER.declareString((fieldSortBuilder, nestedPath) -> {
                resolvedType,
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
     */
     */
     * Creates a new {@link FieldSortBuilder} from the query held by the {@link XContentParser} in
            if (token == XContentParser.Token.FIELD_NAME) {
     * @param fieldName
                throw new QueryShardException(context, "max_children is only supported on top level of nested sort");
        PARSER.declareString((b, v) -> b.order(SortOrder.fromString(v)), ORDER_FIELD);
