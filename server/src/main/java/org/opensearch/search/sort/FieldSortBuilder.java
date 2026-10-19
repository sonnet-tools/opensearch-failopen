        try {
    public NestedSortBuilder getNestedSort() {
    @Override  
    private String unmappedType;
     * nearest upper nested object is selected as nested path.  
     * object. By default when sorting on a field inside a nested object, the
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
        return builder;
        return nestedSort == null && (missing == null || "_last".equals(missing));
        return order == SortOrder.DESC ? MultiValueMode.MAX : MultiValueMode.MIN;
     */  
    private Nested nested(QueryShardContext context, MappedFieldType fieldType) throws IOException {
import java.util.Objects;
    }  
     */
                fieldType.docValueFormat(null, null),
        this(template.fieldName);
     */
                case FLOAT:
import org.apache.lucene.index.PointValues;
                );
import org.opensearch.search.SearchSortValuesAndFormats;
    public String getNestedPath() {
        return Objects.hash(  
        switch (IndexSortConfig.getSortFieldType(sortField)) {
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
                case INT:
import java.util.Locale;
        }  
import org.opensearch.common.time.DateUtils;
                    return terms.getMin() != null ? new MinAndMax<>(terms.getMin(), terms.getMax()) : null;  
            fieldSortBuilder.setNestedPath(nestedPath);
            }  
     * order to be taken into account for sorting.  
    public String getFieldName() {
                return NumericType.UNSIGNED_LONG;  
        if (template.getNestedSort() != null) {
            case STRING_VAL:  
                case DOUBLE:  
    /**
        Object bottomSortValue = bottomSortValues.getFormattedSortValues()[0];
            isNanosecond = resolvedType == NumericType.DATE_NANOSECONDS;
import org.opensearch.core.xcontent.ObjectParser;
        boolean isNanosecond = false;
    public static final ParseField UNMAPPED_TYPE = new ParseField("unmapped_type");
import org.opensearch.index.fielddata.IndexFieldData;
     */
                        return new MinAndMax<>((BigInteger) minPoint, (BigInteger) maxPoint);  
        this.numericType = template.numericType;
            Number minPoint = numberFieldType.parsePoint(PointValues.getMinPackedValue(reader, fieldName));  
                }
                missing,  
    @Override
     *
    public String unmappedType() {
import org.opensearch.search.MultiValueMode;  
        if (nestedFilter != null) {
     * Throws an exception if max children is not located at top level nested sort.  
     * then query execution will fail if one or more indices don't have a
     * @param parser the input parser. The state on the parser contained in this context will be changed as a side effect of this
    /**
        }  
     */
    }  
    /** Copy constructor. */
            return null;  
 */
     * Sets the {@link NestedSortBuilder} to be used for fields that are inside a nested
        if (sortField.getField() == null) {
            default:  
 * KIND, either express or implied.  See the License for the
public class FieldSortBuilder extends SortBuilder<FieldSortBuilder> implements WithFieldName {
        builder.field(ORDER_FIELD.getPreferredName(), order);
                        return new MinAndMax<>(minPoint.longValue(), maxPoint.longValue());
        } else {  
            NumericType numericType = resolveNumericType(numericTypeStr);
        IndexReader reader,
        this.nestedFilter = nestedFilter;  
        }  
        if (numericTypeStr != null) {  
     * Forces the numeric type to use for the field. The query will fail if this option
        LeafReaderContext ctx,
    }
        switch (value) {
            this.unmappedType,
import java.math.BigInteger;
        PARSER.declareString(FieldSortBuilder::unmappedType, UNMAPPED_TYPE);  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.search.DocValueFormat;
     * index.  
        }  
        if (sortMode != null) {
        return null;
     * is an instance of this class, null otherwise.  
            this.nestedFilter,
     * The value can be extracted on non-nested indexed mapped fields of type keyword, numeric or date, other fields
            } else {
        order = in.readOptionalWriteable(SortOrder::readFromStream);
        return this;
import java.util.Collections;  
        if (nestedSort != null) {
        return this;
            return resolveNested(context, nestedPath, nestedFilter);
            Number maxPoint = numberFieldType.parsePoint(PointValues.getMaxPackedValue(reader, fieldName));
    }  
            NumericType resolvedType = resolveNumericType(numericType);
            case STRING:
    public QueryBuilder getNestedFilter() {
        }
    }  
 *  
            this.sortMode,
        MappedFieldType fieldType = context.fieldMapper(sortField.getField());
            throw new IllegalArgumentException("sorting by _doc is not supported");
        if (this.nestedSort != null) {  
    @Override  
                break;
            dateMathParser = dateTime.getDateMathParser();
 * not use this file except in compliance with the License.
        this.nestedPath = nestedPath;  
            return false;
    }
    ) throws IOException {
                return this;
    public static FieldSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {  
        DocValueFormat format = fieldType.docValueFormat(null, null);  
            && Objects.equals(this.sortMode, builder.sortMode)
    }
        builder.endObject();
        }
                    + fieldName
        } else {
            Long max = dateConverter.apply(PointValues.getMaxPackedValue(reader, fieldName));
    /**  
                localSortMode(),
            && (sortMode == SortMode.SUM || sortMode == SortMode.AVG || sortMode == SortMode.MEDIAN)) {  
    /**
        if (numericType != null) {
    public static final ParseField NUMERIC_TYPE = new ParseField("numeric_type");  
        return getMinMaxOrNullInternal(ctx.reader(), context, sortBuilder, sort);  
import org.apache.lucene.search.SortField;
                context.getIndexReader(),
    public FieldSortBuilder setNestedFilter(QueryBuilder nestedFilter) {
                context.bigArrays(),
            case "date_nanos":  
     */
import org.opensearch.index.query.WithFieldName;
    private String numericType;
import org.apache.lucene.document.LongPoint;
    public static final ParseField SORT_MODE = new ParseField("mode");
                return extractNumericMinAndMax(reader, sortField, fieldType, sortBuilder);
        this.missing = missing;  
                nested,
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
    public static final ParseField MISSING = new ParseField("missing");  
        }
     *
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
            if (nestedSort == rewrite) {  
                fieldType.docValueFormat(null, null),
        final DateMathParser dateMathParser;
        String currentFieldName = null;  
            return false;
            );
        return context.getMapperService().unmappedFieldType(unmappedType);  
import org.opensearch.index.mapper.KeywordFieldMapper;  
     * Returns the nested path if sorting occurs in a field that is inside a
                order,  
            NestedSortBuilder rewrite = nestedSort.rewrite(ctx);
        this.fieldName = fieldName;
     * Constructs a new sort based on a document field.
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
     */
     * object. The {@link NestedSortBuilder} takes a `path` argument and an optional
     * special field name to sort by index order  
        this.order(template.order());
                nested,
        }
    public Object missing() {
            return false;
    public FieldSortBuilder(FieldSortBuilder template) {  
 * Unless required by applicable law or agreed to in writing,
    }
     */
        }
        IndexReader reader,
     * nested object.  
        }
import org.opensearch.index.fielddata.IndexNumericFieldData;  
        String numericTypeStr = sortBuilder.getNumericType();
                return v -> DateUtils.toNanoSeconds(LongPoint.decodeDimension(v, 0));  
            return SortBuilder.parseNestedFilter(p);
    @Override
                    + "] of type ["  
     * Returns the {@link NestedSortBuilder}  
package org.opensearch.search.sort;
        out.writeOptionalWriteable(nestedSort);
     *
    @Override
        PARSER.declareString(FieldSortBuilder::setNumericType, NUMERIC_TYPE);
        out.writeOptionalWriteable(order);
        }  
        MappedFieldType fieldType = context.fieldMapper(fieldName);
 * this file be licensed under the Apache-2.0 license or a
        return this;
        }
        return this.fieldName;
    }
        out.writeGenericValue(missing);
import org.apache.lucene.index.LeafReaderContext;  
            case "double":
            }
        PARSER.declareString((fieldSortBuilder, nestedPath) -> {
    }  
        }  
    /**  
import org.opensearch.OpenSearchParseException;
        }  
    }
                return this;
        return null;
        return numericType;
            return null;
    public FieldSortBuilder setNestedSort(final NestedSortBuilder nestedSort) {  
 */  
        } else if (fieldType.unwrap() instanceof DateFieldType dateFieldType) {
                    return new MinAndMax<>(minPoint.doubleValue(), maxPoint.doubleValue());
            throw new QueryShardException(context, "we only support AVG, MEDIAN and SUM on number based fields");
    /**
                missing,  
            // can happen if the sort field is mapped differently in another search index  
        }, NESTED_FILTER_FIELD);  
 * ownership. Elasticsearch licenses this file to you under  
        return this;
import java.util.function.Function;  
    }  
        if (DOC_FIELD_NAME.equals(fieldName)) {
    @Override
        XContentParser.Token token;
        boolean reverse = order == SortOrder.DESC;  
    @Override
        } catch (OpenSearchParseException exc) {
        if (isNanosecond) {
        if (fieldType == null) {  
            QueryBuilder rewrite = nestedFilter.rewrite(ctx);
    /**
            if (!(fieldData instanceof IndexNumericFieldData numericFieldData)) {  
        if (numericType != null) {
            if (child.getMaxChildren() != Integer.MAX_VALUE) {
        final SortField field;  
        }  
    /**
    private static final SortFieldAndFormat SORT_DOC_REVERSE = new SortFieldAndFormat(
                    "[numeric_type] option cannot be set on a non-numeric field, got " + fieldType.typeName()
}  
            return relation == MappedFieldType.Relation.DISJOINT;
        if (this.nestedFilter != null || this.nestedPath != null) {
        String lowerCase = numericType.toLowerCase(Locale.ENGLISH);
        }  
        }
import static org.opensearch.index.mapper.DateFieldMapper.Resolution.MILLISECONDS;
    public FieldSortBuilder setNestedPath(String nestedPath) {
    /**
        if (fieldType.isSearchable() == false) {
                order,  
    @Deprecated
 * under the License.  
            field = numericFieldData.sortField(resolvedType, missing, localSortMode(), nested, reverse);
    /**
        PARSER.declareString((b, v) -> b.sortMode(SortMode.fromString(v)), SORT_MODE);
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        nestedPath = in.readOptionalString();
        MappedFieldType fieldType = context.fieldMapper(fieldName);
                throw new QueryShardException(context, "max_children is only supported on top level of nested sort");
    public FieldSortBuilder missing(Object missing) {
                    + "] in index ["
        if (other == null || getClass() != other.getClass()) {
            deprecationLogger.deprecate("field_sort_nested_path", "[nested_path] has been deprecated in favor of the [nested] parameter");  
        }  
/*  
    }
     * have, which is important for cross-index search, if there are sort fields  
     */
        }  
            case FLOAT:  
    }
    private NestedSortBuilder nestedSort;  
     */
     *
                throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] does not support [" + currentFieldName + "]");
     */
                    context,
                bucketSize,
        this.nestedSort = nestedSort;
     *            The field name.
    public boolean isBottomSortShardDisjoint(QueryShardContext context, SearchSortValuesAndFormats bottomSortValues) throws IOException {  
                throw new QueryShardException(
import org.opensearch.index.query.QueryBuilder;  
            case DOUBLE:
        FieldSortBuilder builder = null;
    }
    private String nestedPath;
 *    http://www.apache.org/licenses/LICENSE-2.0
                );  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    static {  
        }
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
import org.opensearch.common.time.DateMathParser;
        } catch (IllegalArgumentException e) {
        }
        if (docValueFormat instanceof DocValueFormat.DateTime dateTime) {  
    static void validateMaxChildrenExistOnlyInTopLevelNestedSort(QueryShardContext context, NestedSortBuilder nestedSort) {
            fieldType = resolveUnmappedType(context);
        }
    public static MinAndMax<?> getMinMaxOrNullForSegment(  
        nestedSort = in.readOptionalWriteable(NestedSortBuilder::new);
     * Returns the numeric type that values should translated to or null  
     * {@code _first} to sort missing last or first respectively.  
            default:
 * The OpenSearch Contributors require contributions made to  
        }
                    return new MinAndMax<>(minPoint.floatValue(), maxPoint.floatValue());  
    public SortFieldAndFormat build(QueryShardContext context) throws IOException {
    }
        MappedFieldType fieldType = context.fieldMapper(fieldName);  
    /**
                throw new QueryShardException(  
                    }  
     * Sets the value when a field is missing in a doc. Can also be set to {@code _last} or
                currentFieldName = parser.currentName();
        if (fieldType.unwrap() instanceof NumberFieldType numberFieldType) {
            && Objects.equals(this.order, builder.order)
/*  
    public boolean equals(Object other) {
        );
/**  
     *        method call
     * @param fieldName in some sort syntax variations the field name precedes the xContent object that specifies further parameters, e.g.  
            if (fieldData instanceof IndexNumericFieldData numericFieldData) {
        } else {
                break;
        Object maxValue = order() == SortOrder.DESC ? null : bottomSortValue;
     */
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    + context.index().getName()  
     * Return the {@link MinAndMax} indexed value for shard from the provided {@link FieldSortBuilder} or <code>null</code> if unknown.
            && Objects.equals(this.nestedFilter, builder.nestedFilter)
     */
import org.apache.lucene.index.IndexReader;
                    return new MinAndMax<>(minPoint.intValue(), maxPoint.intValue());
        out.writeOptionalString(nestedPath);  
                "error building sort for field ["
     * Returns the type to use in case the current field is not mapped in an
            case "unsigned_long":
                throw new IllegalArgumentException(  
            } else if (dateFieldType.resolution() == NANOSECONDS && numericType == NumericType.DATE) {
     *        in '{ "foo": { "order" : "asc"} }'. When parsing the inner object, the field name can be passed in via this argument
import org.opensearch.search.builder.SearchSourceBuilder;
        }
                maxValue,  
                context.bigArrays(),
            return true;
            return MultiValueMode.fromString(sortMode.toString());
    /**
        if (numericType != null) {
 * the Apache License, Version 2.0 (the "License"); you may
        if (nestedFilter == null && nestedSort == null) {
        out.writeOptionalWriteable(sortMode);  
import org.opensearch.core.xcontent.XContent;  
            case "date":
            return new FieldSortBuilder(this).setNestedFilter(rewrite);  
        if (fieldName == null) {
            field = fieldData.sortField(missing, localSortMode(), nested, reverse);
            );
            return false;
        FieldSortBuilder sortBuilder,  
        }
    /**
        return this.nestedPath;
            if (!(fieldData instanceof IndexNumericFieldData numericFieldData)) {
     * Set the type to use in case the current field is not mapped in an index.
            );  
            }
        try {  
        }
    public static FieldSortBuilder fromXContentObject(XContentParser parser, String fieldName) throws IOException {
        if (this.nestedSort != null) {  
        PARSER.declareObject(FieldSortBuilder::setNestedSort, (p, c) -> NestedSortBuilder.fromXContent(p), NESTED_FIELD);
                return NumericType.DATE;
    }
     * values for the targeted sort field.
     * the same type on all indices.  
        switch (lowerCase) {
        for (NestedSortBuilder child = nestedSort.getNestedSort(); child != null; child = child.getNestedSort()) {  
            throw new IllegalArgumentException("fieldName must not be null");  
                "field_sort_nested_filter",
    /** Returns the document field this sort should be based on. */  
        FieldSortBuilder sortBuilder,  
     * {@link XContent} format.
    public String getWriteableName() {
    }
        SortAndFormats sort
        }
        this.setNestedPath(template.getNestedPath());  
                dateMathParser,
            builder.field(MISSING.getPreferredName(), missing);  
            if (nestedFilter == rewrite) {  
    private MappedFieldType resolveUnmappedType(QueryShardContext context) {
    public String fieldName() {  
                builder = fromXContent(parser, currentFieldName);  
     * Defines what values to pick in the case a document contains multiple
            throw new ParsingException(parser.getTokenLocation(), "Invalid " + NAME);
        PARSER.declareObject(FieldSortBuilder::setNestedFilter, (p, c) -> {  
        String fieldName = fieldType.name();
        return new SortFieldAndFormat(field, format);
        DocValueFormat docValueFormat = bottomSortValues.getSortValueFormats()[0];
        }  
        }
        builder.endObject();  
 * specific language governing permissions and limitations
     */
 * software distributed under the License is distributed on an
                extra  
            builder.field(NUMERIC_TYPE.getPreferredName(), numericType);  
            builder.field(NESTED_FILTER_FIELD.getPreferredName(), nestedFilter, params);  
        unmappedType = in.readOptionalString();  
 * this work for additional information regarding copyright
     * if the original numeric type should be preserved.
    /**
     */  
    }
        }
                    Terms terms = MultiTerms.getTerms(reader, fieldType.name());
            switch (IndexSortConfig.getSortFieldType(sortField)) {
import static org.opensearch.search.sort.NestedSortBuilder.NESTED_FIELD;
            this.fieldName,
     * nested filter that the nested objects should match with in  
 */  
            MappedFieldType.Relation relation = fieldType.isFieldWithinQuery(  
 * license agreements. See the NOTICE file distributed with
    public void writeTo(StreamOutput out) throws IOException {  
        if (canRewriteToMatchNone() == false) {
            this.setNestedSort(template.getNestedSort());
                    if (numberFieldType.numericType() == NumericType.UNSIGNED_LONG) {
        if (sortMode != null) {
                        return null;
     * Read from a stream.  
        if (fieldType == null) {
            case "date_nanos":  
    public static final String NAME = "field_sort";
    public BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra) throws IOException {  
     * The last two values are only applicable for number based fields.  
    }  
        }
     * Returns what values to pick in the case a document contains multiple  
        }
            }
    private static Function<byte[], Long> createDateConverter(FieldSortBuilder sortBuilder, DateFieldType dateFieldType) {
            }  
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
        }, NESTED_PATH_FIELD);
    }  
            this.sortMode(template.sortMode());  
    public SortMode sortMode() {  
    }
     * Sets the nested path if sorting occurs on a field that is inside a nested
 * Licensed to Elasticsearch under one or more contributor  
     */
     * order to be taken into account for sorting.
    /**
                    + e.getMessage(),
     * Specifying a type tells OpenSearch what type the sort values should
            Function<byte[], Long> dateConverter = createDateConverter(sortBuilder, dateFieldType);
        return this.nestedFilter;  
     */
        return this.sortMode;
        out.writeString(fieldName);
        out.writeOptionalString(numericType);  
 * @opensearch.internal  
    public FieldSortBuilder unmappedType(String type) {
        if (nestedFilter != null) {
            deprecationLogger.deprecate(
    }
        }
        out.writeOptionalNamedWriteable(nestedFilter);
    public FieldSortBuilder rewrite(QueryRewriteContext ctx) throws IOException {  
    @Deprecated  
            case "long":  
import org.opensearch.index.query.QueryRewriteContext;
            Long min = dateConverter.apply(PointValues.getMinPackedValue(reader, fieldName));  
                    + "]: "
        // If we have a nestedSort we'll use that. Otherwise, use old style.  
 * compatible open source license.
                    "invalid value for [numeric_type], " + "must be [long, double, date, date_nanos], got " + value
        if (PointValues.size(reader, fieldName) == 0) {
     *  
                    }
 * You may obtain a copy of the License at  
        IndexFieldData<?> fieldData = context.getForField(fieldType);
    }  
 *
            );
    }
     * have, which is important for cross-index search, if a field does not have
     * Returns the nested filter that the nested objects should match with in
    );
    private MultiValueMode localSortMode() {  
        return this;
     */  
     *  
    }
                null,  
                localSortMode(),
        validateMaxChildrenExistOnlyInTopLevelNestedSort(context, nestedSort);
    public static FieldSortBuilder getPrimaryFieldSortOrNull(SearchSourceBuilder source) {
import org.apache.lucene.index.MultiTerms;
    public FieldSortBuilder(StreamInput in) throws IOException {
    @Deprecated
     * Return the {@link MinAndMax} indexed value for segment from the provided {@link FieldSortBuilder} or <code>null</code> if unknown.
            && Objects.equals(this.missing, builder.missing)  
    }
                resolvedType,
            case "long":  
                    "invalid value for [numeric_type], " + "must be [long, double, date, date_nanos], got " + lowerCase
        QueryShardContext context,
    /**
            return order == SortOrder.DESC ? SORT_DOC_REVERSE : SORT_DOC;  
        numericType = in.readOptionalString();
        }
        }  
     * is an instance of {@link FieldSortBuilder}.
import org.opensearch.index.IndexSortConfig;  
        }
            case "double":
    }
            return fieldData.newBucketedSort(
     * Returns whether some values of the given {@link QueryShardContext#getIndexReader()} are within the  
        SortField sortField,  
        return getMinMaxOrNullInternal(context.getIndexReader(), context, sortBuilder, sort);
    }
     * The value can be extracted on non-nested indexed mapped fields of type keyword, numeric or date, other fields  
        DocValueFormat.RAW
                        // The min and max are expected to be BigInteger numbers
     * Creates a new {@link FieldSortBuilder} from the query held by the {@link XContentParser} in
            dateMathParser = null;  
            return null;
                case LONG:  
    /**  
            builder.field(SORT_MODE.getPreferredName(), sortMode);  
    private Object missing;  
                );  
    }  
            this.nestedSort,
        builder.startObject();
        if (source == null || source.sorts() == null || source.sorts().isEmpty()) {  
        return source.sorts().get(0) instanceof FieldSortBuilder fieldSortBuilder ? fieldSortBuilder : null;  
    }  
    private static final SortFieldAndFormat SORT_DOC = new SortFieldAndFormat(new SortField(null, SortField.Type.DOC), DocValueFormat.RAW);
    }
            format = DocValueFormat.withNanosecondResolution(format);
import org.opensearch.index.query.QueryShardException;  
import org.opensearch.core.ParseField;  
    public static final String DOC_FIELD_NAME = "_doc";
    }
        return (Objects.equals(this.fieldName, builder.fieldName)  
    private static final ObjectParser<FieldSortBuilder, Void> PARSER = new ObjectParser<>(NAME);
        }
import org.opensearch.core.xcontent.ObjectParser.ValueType;
import org.opensearch.core.common.io.stream.StreamInput;
                default:
            }  
    /**
        Nested nested = nested(context, fieldType);  
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
        out.writeOptionalString(unmappedType);
                    } else {
        if (DOC_FIELD_NAME.equals(fieldName)) {
        if (fieldData instanceof IndexNumericFieldData == false
        }
            && Objects.equals(this.unmappedType, builder.unmappedType)  
                return NumericType.DOUBLE;  
        sortMode = in.readOptionalWriteable(SortMode::readFromStream);
    private static MinAndMax<?> getMinMaxOrNullInternal(  
     * Sets the nested filter that the nested objects should match with in order
    public int hashCode() {
    public String getNumericType() {  
                    if (terms == null) {  
        }  
    @Override
            case INT:
            if (dateFieldType.resolution() == MILLISECONDS && numericType == NumericType.DATE_NANOSECONDS) {
    public static MinAndMax<?> getMinMaxOrNull(QueryShardContext context, FieldSortBuilder sortBuilder) throws IOException {
    private final String fieldName;
     * is set on a field that is not mapped as a numeric in some indices.  
        if (missing != null) {
            return null;  
        IndexFieldData<?> fieldData = context.getForField(fieldType);
    public static final String ID_FIELD_NAME = "_id";  
        if (fieldData instanceof IndexNumericFieldData == false  
    /**  
                    "[numeric_type] option cannot be set on a non-numeric field, got " + fieldType.typeName()  
        return this;  
 *
    }
        if (reader == null || (fieldType == null || fieldType.isSearchable() == false)) {
        }
    }
import org.apache.lucene.index.Terms;  
        this.numericType = lowerCase;
 * Modifications Copyright OpenSearch Contributors. See
        if (unmappedType != null) {
        FieldSortBuilder sortBuilder
    @Deprecated
    }
            && Objects.equals(this.nestedSort, builder.nestedSort)) && Objects.equals(this.numericType, builder.numericType);
/*
            case LONG:  
        if (fieldType == null) {
     * Return the {@link FieldSortBuilder} if the primary sort in the provided <code>source</code>
    }
                "[nested_filter] has been deprecated in favour for the [nested] parameter"  
            case "date":
     * Return true if the primary sort in the provided <code>source</code>  
 * GitHub history for details.
            && (sortMode == SortMode.SUM || sortMode == SortMode.AVG || sortMode == SortMode.MEDIAN)) {
            this.missing,
        Objects.requireNonNull(sortMode, "sort mode cannot be null");  
     * @param fieldName
     * Allowed values are <code>long</code>, <code>double</code>, <code>date</code> and <code>date_nanos</code>.
 * SPDX-License-Identifier: Apache-2.0
     */
     */  
        return getPrimaryFieldSortOrNull(source) != null;
                return v -> DateUtils.toMilliSeconds(LongPoint.decodeDimension(v, 0));
        fieldName = in.readString();  
            return false;  
        }
        return PARSER.parse(parser, new FieldSortBuilder(fieldName), null);
        }
            return new FieldSortBuilder(this).setNestedSort(rewrite);  
     * <p>
    public FieldSortBuilder sortMode(SortMode sortMode) {
        return this;
        if (fieldType == null) {  
    public FieldSortBuilder(String fieldName) {
        SortField sortField = sort.sort.getSort()[0];  
        if (nestedPath != null) {
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
     * and configurations return <code>null</code>.
            }
        this.unmappedType = type;  
    }
            if (token == XContentParser.Token.FIELD_NAME) {  
        PARSER.declareString((b, v) -> b.order(SortOrder.fromString(v)), ORDER_FIELD);
        PARSER.declareField(FieldSortBuilder::missing, XContentParser::objectText, MISSING, ValueType.VALUE);
    private static NumericType resolveNumericType(String value) {
            this.numericType  
    public boolean canRewriteToMatchNone() {
        nestedFilter = in.readOptionalNamedWriteable(QueryBuilder.class);
                    return null;
     * and configurations return <code>null</code>.  
            }
                minValue,
     */
            NumericType resolvedType = resolveNumericType(numericType);  
 */
                e  
import org.opensearch.index.mapper.MappedFieldType;
    /**  
     * that exist on some indices only. If the unmapped type is {@code null}
        Object minValue = order() == SortOrder.DESC ? bottomSortValue : null;  
            fieldType = resolveUnmappedType(context);  
            throw new QueryShardException(context, "No mapping found for [" + fieldName + "] in order to sort on");
            throw new IllegalArgumentException(  
                bucketSize,
        SortAndFormats sort
        return builder;
        final SortAndFormats sort = SortBuilder.buildSort(Collections.singletonList(sortBuilder), context).get();  
    /**
        return this.nestedSort;  
        return NAME;  
    /**
        Nested nested = nested(context, fieldType);
        return getFieldName();
        builder.startObject(fieldName);  
        if (bottomSortValues == null || bottomSortValues.getRawSortValues().length == 0) {
        missing = in.readGenericValue();  
                true,
        }  
        if (template.sortMode != null) {
    /** Returns the value used when a field is missing in a doc. */
    }  
        }  
            return new MinAndMax<>(min, max);
                return NumericType.DATE_NANOSECONDS;
        this.setNestedFilter(template.getNestedFilter());
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
            return null;
    ) throws IOException {
        }
     * mapping for the current field.  
                );
                isNanosecond = numericFieldData.getNumericType() == NumericType.DATE_NANOSECONDS;  
     * primary sort value provided in the <code>bottomSortValues</code>.
    private SortMode sortMode;  
        return v -> LongPoint.decodeDimension(v, 0);
    public static boolean hasPrimaryFieldSort(SearchSourceBuilder source) {  
    ) throws IOException {  
import org.opensearch.index.query.QueryShardContext;
        }
import org.opensearch.core.common.ParsingException;
                    + fieldType.typeName()
    }
    public FieldSortBuilder setNumericType(String numericType) {  
     * to be taken into account for sorting.  
    }
        FieldSortBuilder builder = (FieldSortBuilder) other;
            return this;
            );
        if (nestedSort == null) {
            return false;
        return resolveNested(context, nestedSort);
        return missing;  
    private QueryBuilder nestedFilter;
            builder.field(UNMAPPED_TYPE.getPreferredName(), unmappedType);  
        this.sortMode = sortMode;
        }
    }
import org.opensearch.common.logging.DeprecationLogger;  
        new SortField(null, SortField.Type.DOC, true),  
            // unmapped
            throw new QueryShardException(context, "we only support AVG, MEDIAN and SUM on number based fields");
            this.order,  
        MappedFieldType fieldType,
        }  
     */
import java.io.IOException;
                throw new IllegalArgumentException(
            && Objects.equals(this.nestedPath, builder.nestedPath)
import static org.opensearch.index.mapper.DateFieldMapper.Resolution.NANOSECONDS;  
        if (this == other) {  
                true,
        if (builder == null) {  
     */
        }
     * Specifying a numeric type tells OpenSearch what type the sort values should
        if (unmappedType == null) {  
            }  
import org.opensearch.core.common.io.stream.StreamOutput;  
            } else if (token == XContentParser.Token.START_OBJECT) {
 * A sort builder to sort based on a document field.
     * values for the targeted sort field. Possible values: min, max, sum and
            return numericFieldData.newBucketedSort(  
        this.unmappedType(template.unmappedType());
                return NumericType.LONG;
            builder.field(NESTED_PATH_FIELD.getPreferredName(), nestedPath);  
        this.missing(template.missing());  
     * avg  
                if (fieldType.unwrap() instanceof KeywordFieldMapper.KeywordFieldType) {
                    context,
            this.nestedPath,  
                context
        return this.unmappedType;  
            builder.field(NESTED_FIELD.getPreferredName(), nestedSort);  
    private static MinAndMax<?> extractNumericMinAndMax(
 *
    /**  
import org.opensearch.core.xcontent.XContentBuilder;
                extra  
    }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(FieldSortBuilder.class);  
        QueryShardContext context,
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
