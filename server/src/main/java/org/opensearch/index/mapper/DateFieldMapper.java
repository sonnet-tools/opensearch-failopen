                        }
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(DateFieldMapper.class);  
                this.locale.setValue(dateFormatter.locale());
                buildFormatter(),
            timestamp = nullValue;  
                if (indexSortConfig.hasPrimarySortOnField(fieldName)) {
        public String type() {  
         * Return the instant that this range can represent that is closest to
            return builder.apply(l, u, nowUsed);
            ZoneId timeZone,  
    private DateFieldMapper(
                context.doc().add(new SortedNumericDocValuesField(fieldType().name(), timestamp));
 */
        }  
                }  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;  
    public static final String CONTENT_TYPE = "date";
            }
        protected final DateMathParser dateMathParser;
    }
            QueryRewriteContext context
            if (nullValue.getValue() == null) {
        private final Parameter<Boolean> docValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
    private final String format;  
            @Override  
            }
            );  
     *        derived source will contain date in first date format from "||" separated list of format defined in  
 *  
        MappedFieldType mappedFieldType,  
import org.opensearch.common.time.DateFormatters;  
        NANOSECONDS(DATE_NANOS_CONTENT_TYPE, NumericType.DATE_NANOSECONDS) {
            TimeValue pivotTime = TimeValue.parseTimeValue(pivot, "distance_feature.pivot");
         */  
            Object value,
import org.opensearch.common.lucene.BytesRefs;  
    }  
                return DateFormatter.forPattern(format.getValue(), printFormat.getValue(), !format.isConfigured())  
                    return formatter.format(dateTime);
        private final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);  
        }
        @Override
        }
            @Nullable DateMathParser forcedDateParser,
        checkStoredAndDocValuesForDerivedSource();
                u = Long.MAX_VALUE;
            ignoreMalformedByDefault,  
                }
            Version indexCreatedVersion,
    );  
            boolean includeUpper,  
        return (DateFieldMapper) in;  
        public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {  
                }  
                return fieldType.parse(nullValue.getValue());
            boolean ignoreMalformedByDefault,  
        Long timestamp = parseTimestamp(context);
    }
import org.opensearch.common.util.LocaleUtils;
        public static Query dateRangeQuery(
        }
            if (minValue >= fromInclusive && maxValue <= toInclusive) {  
            }
        );  
            m -> toType(m).locale
        }
    protected void parseCreateField(ParseContext context) throws IOException {  
import org.apache.lucene.index.IndexReader;
                this.printFormat.setValue(dateFormatter.printPattern());
    private final String nullValueAsString;
            }
import org.opensearch.common.time.DateMathParser;
    public static class Builder extends ParametrizedFieldMapper.Builder {
        MultiFields multiFields,
                        pack(new long[] { u }).bytes,
    }
        @Override  
            @Override
                }
        ) {
    }  
                u = parseToLong(upperTerm, includeUpper, timeZone, parser, nowSupplier, resolution);  
                upperTerm,  
        }
        } else {  
        public long parseToLong(Object value, boolean roundUp, @Nullable ZoneId zone, DateMathParser dateParser, LongSupplier now) {
            Resolution resolution,
    protected DerivedFieldGenerator derivedFieldGenerator() {
            return dateTimeFormatter().format(resolution.toInstant(val).atZone(ZoneOffset.UTC));
 * Licensed to Elasticsearch under one or more contributor  
            try {
        public long convertNanosToMillis(long nanoSecondsSinceEpoch) {
            long originLong = parseToLong(origin, true, null, null, context::nowInMillis);  
        this.resolution = resolution;
            String name,  
                nullValue.getValue(),
                    return null;
                }  
        }
            Object to,  
            }
        this.nullValueAsString = builder.nullValue.getValue();
                timestamp = fieldType().parse(dateAsString);  
                includeLower,
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {  
/*  
 *
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                dateParser = this.dateMathParser;  
        Long nullValue,  
                lowerTerm,
        public Object valueForDisplay(Object value) {  
        this.store = builder.store.getValue();
    /**
        public Resolution resolution() {
            this.ignoreMalformed = Parameter.explicitBoolParam(
        Resolution resolution,
        }  
            // milliseconds. The only special case here is docvalue fields, which are handled somewhere else  
        this.isSkiplistConfigured = builder.skiplist.isConfigured();  
import java.io.IOException;
            DateFormatter dateTimeFormatter,
            DateFormatter formatter = format != null  
            return dateTimeFormatter;
            long maxValue = LongPoint.decodeDimension(PointValues.getMaxPackedValue(reader, name()), 0);
    }
            return FieldTypeCapabilities.Capability.POINT_RANGE;  
        "strict_date_optional_time||epoch_millis"
        public byte[] encodePoint(Object value, boolean roundUp) {
 * this work for additional information regarding copyright
        MILLISECONDS(CONTENT_TYPE, NumericType.DATE) {
            IndexReader reader,
        }  
            if (resolution.numericType.equals(NumericType.DATE_NANOSECONDS)) return DateUtils.toMilliSeconds(nanoSecondsSinceEpoch);  
import org.apache.lucene.search.BoostQuery;
    }  
            if (format != null) {
     */
            boolean includeUpper,
            this(name, true, false, true, dateFormatter, Resolution.MILLISECONDS, null, Collections.emptyMap());  
    public static final TypeParser NANOS_PARSER = new TypeParser((n, c) -> {  
            boolean isSearchable,
        public long parse(String value) {
                if (includeLower == false) {
            this(name, true, false, true, dateFormatter, resolution, null, Collections.emptyMap());
import java.util.Arrays;
        Resolution(String type, NumericType numericType) {
     * @opensearch.internal
        @Override
            return Arrays.asList(index, docValues, store, skiplist, format, printFormat, locale, nullValue, ignoreMalformed, boost, meta);  
            }
 * the Apache License, Version 2.0 (the "License"); you may
            }
            }
        public DateFormatter dateTimeFormatter() {  
            (n, c, o) -> LocaleUtils.parse(o.toString()),  
                context.doc().add(SortedNumericDocValuesField.indexedField(fieldType().name(), timestamp));
                        }
            Long val = (Long) value;
        ).acceptsNull();
            c.indexVersionCreated(),
                    Query dvQuery = hasDocValues() ? SortedNumericDocValuesField.newSlowRangeQuery(name(), l, u) : null;
                if (val == null) {  
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
        "strict_date_time_no_millis||strict_date_optional_time||epoch_millis",
import org.opensearch.common.geo.ShapeRelation;
import org.apache.lucene.document.SortedNumericDocValuesField;  
import org.opensearch.search.DocValueFormat;
     * Considerations:  
    }  
            @Nullable ZoneId timeZone,
 * software distributed under the License is distributed on an
        }  
                docValues.getValue(),
                return null;  
                return DateUtils.toInstant(value);  
            return milliSecondsSinceEpoch;  
            QueryShardContext context  
            public long parsePointAsMillis(byte[] value) {  
 * not use this file except in compliance with the License.
        /**  
                    }
            context.doc().add(new StoredField(fieldType().name(), timestamp));
import org.opensearch.search.lookup.SearchLookup;
import java.time.ZonedDateTime;  
            c.indexVersionCreated(),
            if (timeZone == null) {
            } else {
    @Override  
                buildFullName(context),
        if (hasDocValues) {  
                    --u;
                    --toInclusive;  
        } else if (store || indexed) {  
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {
        protected abstract Query distanceFeatureQuery(String field, float boost, long origin, TimeValue pivot);
    @Override  
import org.opensearch.common.Nullable;
            () -> Locale.ROOT,
            } else {
        if (indexed) {  
            try {
            failIfNotIndexedAndNoDocValues();
                timeZone,  
import org.opensearch.OpenSearchParseException;
                    "date_mapper_null_field",
            false,
            DateMathParser parser,
        /** Still searchable from doc values when the index uses a pluggable data format. */  
            failIfNotIndexedAndNoDocValues();
                    }  
            }
        this.locale = builder.locale.getValue();
            DateFieldType ft = new DateFieldType(  
        }
     *     2. If multiple date formats are specified in field mapping and "print_format" is not specified then
import org.opensearch.index.fielddata.IndexFieldData;
            boolean hasDocValues,  
     * 1. If it has doc values, build source using doc values  
            long fromInclusive = Long.MIN_VALUE;  
            dateParser = dateParser == null ? dateMathParser() : dateParser;  
                return DateUtils.clampToMillisRange(instant);  
            } catch (IllegalArgumentException | OpenSearchParseException | DateTimeException | ArithmeticException e) {
        @Override  
import org.opensearch.common.time.DateUtils;
                toInclusive = parseToLong(to, includeUpper, timeZone, dateParser, context::nowInMillis, resolution);
        public DateFieldType(String name) {
                return toLong(instant);
            return new DateFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), nullTimestamp, resolution, this);  
import org.apache.lucene.index.PointValues;  
    /**  
            public Instant clampToValidRange(Instant instant) {
        }
                return resolution()::parsePointAsMillis;  
        context.documentInput().addField(fieldType(), timestamp);
    protected DateFieldMapper clone() {
            this.indexCreatedVersion = indexCreatedVersion;
    @Override
        protected final DateFormatter dateTimeFormatter;  
import org.opensearch.index.IndexSettings;
     */  
        private final Resolution resolution;
    @Override  
            DateMathParser dateParser,
                }
    public enum Resolution {
        @Override
        }
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.logging.DeprecationLogger;
                return LongPoint.decodeDimension(value, 0);
            m -> toType(m).printFormat,
        @Override
 * A {@link FieldMapper} for dates.  
    }
            getDefaultDateTimeFormatter().printPattern()  
        ) {
            .acceptsNull();
        @Override
    }  
            m -> toType(m).format,
        }
    @Override  
import org.apache.lucene.search.Query;
import org.opensearch.index.IndexSortConfig;
 * this file be licensed under the Apache-2.0 license or a
            @Nullable ZoneId zone,
import java.util.function.Function;
            byte[] point = new byte[Long.BYTES];
            }
        }  
import org.opensearch.common.Explicit;
            public long convert(Instant instant) {  
    ) {  
                public String parseSourceValue(Object value) {  
        // TODO remove in 3.0 after backporting  
         * the provided instant.
            Object dateAsObject = context.externalValue();  
            if (dateAsObject == null) {
                "ignore_malformed",  
            }
            // the resolution here is always set to milliseconds, as aggregations use this formatter mainly and those are always in
            }
                    if (fromInclusive == Long.MAX_VALUE) {
            (n, c, o) -> XContentMapValues.nodeBooleanValue(o),
                        pack(new long[] { l }).bytes,  
            QueryShardContext context,  
        if (store) {  
        }
import java.util.Collections;
    @Deprecated
                return Instant.ofEpochMilli(value);
import java.time.ZoneId;
        }  
            // Always parse with roundUp=false to get consistent date math  
                : defaultFormatter;
 * under the License.  
        @Override  
                return DateUtils.clampToNanosRange(instant);
        );  
            }
            } else {  
                    return nowUsed[0]  
                return LongField.newDistanceFeatureQuery(field, boost, origin, pivot.getNanos());  
        return (DateFieldMapper) super.clone();
            public Instant toInstant(long value) {  
        }
                        if (context.indexSortedOnField(name())) {  
                }
    @Override
            };  
            public Instant clampToValidRange(Instant instant) {
            return point;
    private final Version indexCreatedVersion;
            return Optional.of(DimensionType.DATE);
        if (context.externalValueSet()) {
                        query = pointRangeQuery;
    private final boolean hasDocValues;
                    );
    private static DateFieldMapper toType(FieldMapper in) {
            Object lowerTerm,  
                if (timestamp > Long.MIN_VALUE) {
                return null;
        public Builder(
        @Override  
                        return Relation.DISJOINT;
            Resolution resolution,
    protected String getFieldValue(ParseContext context) throws IOException {
                    ApproximatePointRangeQuery approxQuery = new ApproximatePointRangeQuery(
        public static long parseToLong(
    public static DateFormatter getDefaultDateTimeFormatter() {
            DateMathParser dateParser,
        };
     * Builder for the date field mapper  
        private final Parameter<String> nullValue = Parameter.stringParam("null_value", false, m -> toType(m).nullValueAsString, null)
        }
                if (ignoreMalformed().value()) {
        }  
            }
        private final Parameter<Float> boost = Parameter.boostParam();
            }
import java.time.Instant;  
     *
    /**
        if (timestamp == null) {
                return dateAsObject.toString();
 */  
    }  
                    }
import java.time.DateTimeException;
 * ownership. Elasticsearch licenses this file to you under  
            Long nullTimestamp = parseNullValue(ft);
            Object from,
        }
            return;  
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());  
        public Query rangeQuery(
                }  
    }
import org.opensearch.common.util.FeatureFlags;
        public String typeName() {  
import java.util.List;  
                }
 * Modifications Copyright OpenSearch Contributors. See
        }
            protected Query distanceFeatureQuery(String field, float boost, long origin, TimeValue pivot) {  
            Version indexCreatedVersion
    public DateFieldType fieldType() {  
            TriFunction<Long, Long, boolean[], Query> builder
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());
                return Relation.INTERSECTS;
        return new Builder(
            public long convert(Instant instant) {
            return null;
            if (relation == ShapeRelation.DISJOINT) {  
    }  
        if (this.indexCreatedVersion.onOrAfter(Version.V_3_3_0)) {
        boolean ignoreMalformedByDefault = IGNORE_MALFORMED_SETTING.get(c.getSettings());
                }  
            long timestamp = parseToLong(value, false, null, null, null);
        this.ignoreMalformedByDefault = builder.ignoreMalformed.getDefaultValue().value();
                    return DateFormatter.forPattern(format.getValue(), null, !format.isConfigured()).withLocale(locale.getValue());
                    return true;
            long l, u;  
        return fieldType().resolution.type();  
            if (isSearchable()) {
                return context.nowInMillis();
 *
                        query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
import java.time.ZoneOffset;
 */  
        private final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).store, false);
/**
            } else {  
            false,
        Builder builder
        @Override
        private final Parameter<String> printFormat = Parameter.stringParam(
     * @opensearch.internal  
            c.getDateFormatter(),
            if (roundUp) {  
            String name,  
            return nanoSecondsSinceEpoch;
            return resolution.type();
 *
            return resolution.distanceFeatureQuery(name(), boost, originLong, pivotTime);
import org.opensearch.search.approximate.ApproximatePointRangeQuery;  
            return new DocValueFormat.DateTime(dateTimeFormatter, timeZone, Resolution.MILLISECONDS);
        public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {
    public static final String DATE_NANOS_CONTENT_TYPE = "date_nanos";  
                    context.addIgnoredField(mappedFieldType.name());  
        this.skiplist = builder.skiplist.getValue();
                if (DataStreamFieldMapper.Defaults.TIMESTAMP_FIELD.getName().equals(fieldName)) {
                index.getValue(),
     * Resolution of the date time  
        },  
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();  
    public static final class DateFieldType extends MappedFieldType implements NumericPointEncoder {
                    }
                return Relation.DISJOINT;  
import org.opensearch.index.compositeindex.datacube.DimensionType;  
        }
import org.opensearch.Version;  
import org.opensearch.common.TriFunction;  
            failIfNoDocValues();
                        + "] as date in [null_value] on field ["
                return Relation.WITHIN;
import org.apache.lucene.document.LongField;
            this(name, true, false, true, getDefaultDateTimeFormatter(), Resolution.MILLISECONDS, null, Collections.emptyMap());
            protected Query distanceFeatureQuery(String field, float boost, long origin, TimeValue pivot) {
        @Override  
            return parseToLong(value, roundUp, zone, dateParser, now, resolution);
                true,
 * Unless required by applicable law or agreed to in writing,
            boolean isStored,
            LongSupplier nowSupplier = () -> {
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support DISJOINT ranges");
        return new Builder(
                this.format.setValue(dateFormatter.pattern());  
                nowUsed[0] = true;  
        protected FieldTypeCapabilities.Capability searchCapability() {
         */
                ? DateFormatter.forPattern(format).withLocale(defaultFormatter.locale())
 * compatible open source license.
        private final Parameter<Locale> locale = new Parameter<>(
        public Function<byte[], Number> pointReaderIfPossible() {
            @Override
            context.doc().add(new LongPoint(fieldType().name(), timestamp));
        this.printFormat = builder.printFormat.getValue();  
        protected List<Parameter<?>> getParameters() {
public final class DateFieldMapper extends ParametrizedFieldMapper {
            Resolution resolution,
            DateFormatter dateFormatter,  
import java.util.Map;
            "skip_list",
import org.opensearch.common.unit.TimeValue;  
        this.indexCreatedVersion = builder.indexCreatedVersion;  
/*  
                timeZone = ZoneOffset.UTC;  
                        if (context.indexSortedOnField(name())) {  
                    timestamp = timestamp - 1;  
        }, new StoredFieldFetcher(mappedFieldType, simpleName()));
            @Override  
        }
         * Convert a long value in this resolution into an instant.
        String simpleName,
                return null;
            throw new IllegalArgumentException("unknown resolution ordinal [" + ord + "]");
import org.opensearch.index.query.QueryShardContext;
            }
                return null;  
            if (boost() != 1f) {  
            if (from != null) {
    private final boolean ignoreMalformedByDefault;
        return new Builder(simpleName(), resolution, null, ignoreMalformedByDefault, indexCreatedVersion).init(this);
    }
            }
            return dateRangeQuery(
                        name(),
        public DateFieldType(String name, DateFormatter dateFormatter) {
                    return resolution;
}
            @Override  
            if (dateFormatter != null) {
    @Override
            DateFormatter defaultFormatter = dateTimeFormatter();
 * You may obtain a copy of the License at  
            super(name);
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                    "Error parsing ["  
                            query = new IndexSortSortedNumericDocValuesRangeQuery(name(), l, u, query);
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
        @Override
        public Builder(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
    private Long parseTimestamp(ParseContext context) throws IOException {
            }
                l = Long.MIN_VALUE;
            Resolution.NANOSECONDS,
            }
        public DateFieldType(String name, Resolution resolution, DateFormatter dateFormatter) {
        } else {
            );
            this.dateTimeFormatter = dateTimeFormatter;
        return FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING_SETTING)  
     *     1. If "print_format" specified in field mapping, then derived source will have date in this format
            () -> false,  
package org.opensearch.index.mapper;
            }  
                    long timestamp = parse(date);
            String nullValue,  
            this.dateMathParser = dateTimeFormatter.toDateMathParser();
                    // Not searchable. Must have doc values.
        private final String type;
                if (includeUpper == false) {
                ignoreMalformedByDefault  
            DateMathParser parser = forcedDateParser == null ? dateMathParser : forcedDateParser;  
            @Override
    private final Locale locale;
                }
        }
        );
            this(name, resolution, dateFormatter, ignoreMalformedByDefault, indexCreatedVersion, Settings.EMPTY);  
import static org.opensearch.common.time.DateUtils.toLong;
            }
            return context.parser().textOrNull();
        }
         * Convert an {@linkplain Instant} into a long value in this resolution.  
            if (resolution.numericType.equals(NumericType.DATE_NANOSECONDS)) return DateUtils.toNanoSeconds(milliSecondsSinceEpoch);
                        + nullValue.getValue()
            return resolution.convert(DateFormatters.from(dateTimeFormatter().parse(value), dateTimeFormatter().locale()).toInstant());
            n,  
        private Long parseNullValue(DateFieldType fieldType) {  
        protected final Resolution resolution;
            }
                dateTimeFormatter = DateFormatter.forPattern(format).withLocale(dateTimeFormatter.locale());  
            n,  
                return null;
import org.opensearch.common.time.DateFormatter;
                    String date = value.toString();
 * The OpenSearch Contributors require contributions made to  
        }
    private final boolean skiplist;  
            if (val == null) {
        Long timestamp = parseTimestamp(context);
        protected DateMathParser dateMathParser() {
            @Override
                fromInclusive = parseToLong(from, !includeLower, timeZone, dateParser, context::nowInMillis, resolution);
                    return true;
        public static Resolution ofOrdinal(int ord) {
            createFieldNamesField(context);
     *
import org.opensearch.common.settings.Settings;
            }  
     * <p>
    @Override
            Object lowerTerm,
import java.util.Optional;  
            if (to != null) {  
        ) {
    @Override
        public DateFieldType(String name, Resolution resolution) {  
            @Override
        private DateFormatter buildFormatter() {
                    if (!isSearchable()) {
    public Long getNullValue() {
     */
            if (PointValues.size(reader, name()) == 0) {
            boolean includeLower,
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);  
 * license agreements. See the NOTICE file distributed with
        public Relation isFieldWithinQuery(  
            Resolution resolution
    @Override  
            public Object convert(Object value) {
     * @opensearch.internal
            if (!isSkiplistConfigured) {  
            : LEGACY_DEFAULT_DATE_TIME_FORMATTER;
            ? DEFAULT_DATE_TIME_FORMATTER
        }  
        }  
                (l, u, nowUsed) -> {
            long toInclusive = Long.MAX_VALUE;
            Settings settings  
            boolean includeUpper,
            this.nullValue = nullValue;
        );  
    public static final TypeParser MILLIS_PARSER = new TypeParser((n, c) -> {  
 */  
        }  
    }  
            this.resolution = resolution;  
                    if (toInclusive == Long.MIN_VALUE) {  
        // Visible for testing.  
        }
            DateFormatter dateTimeFormatter = this.dateTimeFormatter;
            return query;  
        return false;  
        private final Parameter<Boolean> skiplist = new Parameter<>(  
        private final Parameter<Explicit<Boolean>> ignoreMalformed;  
        private final Parameter<String> format = Parameter.stringParam(
    private final Explicit<Boolean> ignoreMalformed;
            public Instant toInstant(long value) {
    }
    /**
        public Query termQuery(Object value, @Nullable QueryShardContext context) {
            @Override
    private final boolean store;  
            if (skiplist || isSkiplistDefaultEnabled(context.indexSettings().getIndexSortConfig(), fieldType().name())) {
    }
                meta.getValue()
        }
import org.apache.lucene.document.StoredField;
    private final boolean indexed;
                return fieldType().dateTimeFormatter().format(resolution.toInstant(val).atZone(ZoneOffset.UTC));  
        String dateAsString = getFieldValue(context);  
            );
            }
        @Override  
        this.hasDocValues = builder.docValues.getValue();
        }
            } else {
        @Override
                includeUpper,
    private final String printFormat;
        @Override
            if (upperTerm == null) {  
/*
         */  
        }
            }
        }
                return Relation.DISJOINT;  
                    .withLocale(locale.getValue());
        }
            "locale",  
        @Override
        return ignoreMalformed;  
        public abstract long convert(Instant instant);
            false,
            }
            }  
    private final boolean isSkiplistConfigured;
                resolution,  
import java.util.Locale;
        "strict_date_optional_time"
     * Field type for date field mapper
    public static final DateFormatter LEGACY_DEFAULT_DATE_TIME_FORMATTER = DateFormatter.forPattern(
            return;  
        return timestamp;
     * Date format:  
        public byte[] encodePoint(Number value) {
            return new SortedNumericIndexFieldData.Builder(name(), resolution.numericType());
            c.getDateFormatter(),
import org.opensearch.common.xcontent.support.XContentMapValues;  
        if (dateAsString == null) {
 * specific language governing permissions and limitations
                        new long[] { l }.length,
    });
import java.util.function.Supplier;  
        ) throws IOException {  
        NumericType numericType() {
            ignoreMalformedByDefault,  
            boolean includeLower,
                    ZonedDateTime dateTime = resolution().toInstant(timestamp).atZone(ZoneOffset.UTC);  
 * GitHub history for details.
        public DateFieldType(
                query = new BoostQuery(query, boost());
                return DateUtils.toMilliSeconds(LongPoint.decodeDimension(value, 0));
            boolean roundUp,  
    boolean isSkiplistDefaultEnabled(IndexSortConfig indexSortConfig, String fieldName) {
                context,
        ) {
    private final Resolution resolution;
                );
            public long parsePointAsMillis(byte[] value) {
        return new DerivedFieldGenerator(mappedFieldType, new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()) {
                        return nowUsed[0] ? new DateRangeIncludingNowQuery(dvQuery) : dvQuery;  
            DateFormatter dateFormatter,
    public static final DateFormatter DEFAULT_DATE_TIME_FORMATTER = DateFormatter.forPattern(  
        ) {  
            } else {  
                m -> toType(m).ignoreMalformed,
            return resolution;
        public DateFieldMapper build(BuilderContext context) {
            Resolution.MILLISECONDS,
        @Override  
        }
        }
         * Decode the points representation of this field as milliseconds.
    });
    protected void canDeriveSourceInternal() {
                if (includeLower == false) {  
        if (timestamp == null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    );
    public boolean skiplist() {  
        }
        /**
        public abstract Instant toInstant(long value);
    }
        CopyTo copyTo,
            // In this method the parseToLong is only used for date math rounding operations
            try {
            boolean ignoreMalformedByDefault,
                if (ord == resolution.ordinal()) {
        protected final String nullValue;  
            c.getSettings()
                parser,
                            dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(name(), l, u, dvQuery);
                        : new ApproximateScoreQuery(query, approxQuery);
        );
        }
            return type;
            }  
            ft.setBoost(boost.getValue());
                    } else {  
            }
                    throw e;  
    }
import org.apache.lucene.search.IndexSortSortedNumericDocValuesRangeQuery;  
            }
                return clampToValidRange(instant).toEpochMilli();
        this.nullValue = nullValue;  
            if (isSearchable() == false && hasDocValues()) {
     */  
                // no points, so nothing matches
        public long convertRoundedMillisToNanos(long milliSecondsSinceEpoch) {
            getDefaultDateTimeFormatter().pattern()  
        this.format = builder.format.getValue();
                store.getValue(),  
        }
        return (DateFieldType) super.fieldType();
import org.apache.lucene.search.IndexOrDocValuesQuery;
            if (nullValue == null) {  
import java.util.function.LongSupplier;
                resolution,  
     *        "format"
                if (includeUpper == false) {
            Map<String, String> meta
                        ? new ApproximateScoreQuery(new DateRangeIncludingNowQuery(query), approxQuery)
                        + name()  
                l = parseToLong(lowerTerm, !includeLower, timeZone, parser, nowSupplier, resolution);
                        ApproximatePointRangeQuery.LONG_FORMAT  
                if (format.isConfigured() && !printFormat.isConfigured()) {  
                    Query query;
        private final NumericType numericType;
            "format",  
            return resolution.convert(dateParser.parse(BytesRefs.toString(value), now, roundUp, zone));  
                }
                    timestamp = timestamp + 1;
import org.opensearch.index.query.QueryRewriteContext;  
            this(name, true, false, true, getDefaultDateTimeFormatter(), resolution, null, Collections.emptyMap());
            Resolution resolution,
        boolean ignoreMalformedByDefault = IGNORE_MALFORMED_SETTING.get(c.getSettings());
        }  
     * 2. If doc_values is disabled in field mapping, then build source using stored field
import static org.apache.lucene.document.LongPoint.pack;  
        public abstract Instant clampToValidRange(Instant instant);
            m -> toType(m).skiplist
            }  
            }
import org.opensearch.search.approximate.ApproximateScoreQuery;
            if (lowerTerm == null) {
    private final Long nullValue;  
            for (Resolution resolution : values()) {  
            Object upperTerm,  
        return skiplist;
                    ++l;  
            };
                    Query pointRangeQuery = LongPoint.newRangeQuery(name(), l, u);
            String name,
 * @opensearch.internal
            false,
import org.opensearch.index.query.DateRangeIncludingNowQuery;
            "print_format",  
        /**  
    protected String contentType() {
            @Nullable ZoneId timeZone,
                        + "]); [null_value] will be ignored"
        this.ignoreMalformed = builder.ignoreMalformed.getValue();
            }
                return Relation.INTERSECTS;  
            ShapeRelation relation,  
                throw new IllegalArgumentException("Error parsing [format] on field [" + name() + "]: " + e.getMessage(), e);  
                        return Relation.DISJOINT;
                if (timestamp < Long.MAX_VALUE) {
        return nullValue;  
        }
     * <p>
            boolean[] nowUsed = new boolean[1];
                    // Field is searchable  
            return numericType;
import org.apache.lucene.document.LongPoint;
            return dateMathParser;  
            return encodePoint(timestamp);  
            }  
            this.type = type;
            @Override
         */
            if (dateParser == null) {
        }  
        long timestamp;
            long minValue = LongPoint.decodeDimension(PointValues.getMinPackedValue(reader, name()), 0);  
        private final Version indexCreatedVersion;  
            // if we have only doc_values enabled we do not look at the BKD so we return an INTERSECTS by default
            LongSupplier now,  
        }  
        this.indexed = builder.index.getValue();  
        ) {
            Object upperTerm,
                @Override
            @Override  
            } else if (maxValue < fromInclusive || minValue > toInclusive) {
            }
    protected Explicit<Boolean> ignoreMalformed() {
            }  
            boolean includeLower,
    }  
        }  
            Query query = rangeQuery(value, value, true, true, ShapeRelation.INTERSECTS, null, null, context);
            // TODO maybe aggs should force millis because lots so of other places want nanos?
     *
                    if (dvQuery != null) {
 * SPDX-License-Identifier: Apache-2.0
            LongPoint.encodeDimension(value.longValue(), point, 0);  
            c.getSettings()
                    ++fromInclusive;
        public abstract long parsePointAsMillis(byte[] value);  
            this.resolution = resolution;  
                return LongField.newDistanceFeatureQuery(field, boost, origin, pivot.getMillis());
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);
            } catch (Exception e) {  
        /**
        }  
            return new SourceValueFetcher(name(), context, nullValue) {
     *     1. When building source using doc_values, for multi-value field, it will result values in sorted order
                } else {
            this.numericType = numericType;  
            } catch (IllegalArgumentException e) {
                }
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
                Long val = (Long) value;
                DEPRECATION_LOGGER.deprecate(
                    return null;
