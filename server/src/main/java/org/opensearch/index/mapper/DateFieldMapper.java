        return new DerivedFieldGenerator(mappedFieldType, new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()) {
 * ownership. Elasticsearch licenses this file to you under
            Resolution resolution
            }
        }
            } catch (IllegalArgumentException e) {
    private final Long nullValue;
        String simpleName,
            public long parsePointAsMillis(byte[] value) {
            LongPoint.encodeDimension(value.longValue(), point, 0);
        public byte[] encodePoint(Number value) {
            boolean[] nowUsed = new boolean[1];
    private final boolean store;
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                if (ignoreMalformed().value()) {
            DateMathParser dateParser,
        ) throws IOException {
        ) {
        "strict_date_optional_time||epoch_millis"
            if (resolution.numericType.equals(NumericType.DATE_NANOSECONDS)) return DateUtils.toMilliSeconds(nanoSecondsSinceEpoch);
                if (includeUpper == false) {
            context.doc().add(new StoredField(fieldType().name(), timestamp));
        }
                u = parseToLong(upperTerm, includeUpper, timeZone, parser, nowSupplier, resolution);
 * A {@link FieldMapper} for dates.
    protected void parseCreateField(ParseContext context) throws IOException {
            false,
                query = new BoostQuery(query, boost());
                meta.getValue()
                    }
    }
                }
            return context.parser().textOrNull();
        }
import org.opensearch.common.logging.DeprecationLogger;
            Settings settings
            return dateMathParser;
 *
    }
                    return resolution;
         */
            this.resolution = resolution;
     * @opensearch.internal
                dateTimeFormatter = DateFormatter.forPattern(format).withLocale(dateTimeFormatter.locale());
        private final Parameter<Explicit<Boolean>> ignoreMalformed;
            long fromInclusive = Long.MIN_VALUE;
                return DateFormatter.forPattern(format.getValue(), printFormat.getValue(), !format.isConfigured())
import org.opensearch.common.geo.ShapeRelation;
 * this file be licensed under the Apache-2.0 license or a
                return DateUtils.clampToNanosRange(instant);
                return Instant.ofEpochMilli(value);
        public abstract Instant toInstant(long value);
        }
import java.util.function.LongSupplier;
                    .withLocale(locale.getValue());
            byte[] point = new byte[Long.BYTES];
            QueryShardContext context
import java.io.IOException;
        public long parse(String value) {
            @Override
        public Builder(
    boolean isSkiplistDefaultEnabled(IndexSortConfig indexSortConfig, String fieldName) {
            this(name, resolution, dateFormatter, ignoreMalformedByDefault, indexCreatedVersion, Settings.EMPTY);
        public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {
     */
import org.apache.lucene.search.Query;
        private final Version indexCreatedVersion;
                    context.addIgnoredField(mappedFieldType.name());
        return timestamp;
            Version indexCreatedVersion
        @Override
        }
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
                        pack(new long[] { l }).bytes,
                this.printFormat.setValue(dateFormatter.printPattern());
            if (skiplist || isSkiplistDefaultEnabled(context.indexSettings().getIndexSortConfig(), fieldType().name())) {
            }
     * Considerations:
                }
public final class DateFieldMapper extends ParametrizedFieldMapper {
import org.apache.lucene.document.StoredField;
        public DateFormatter dateTimeFormatter() {
        },
        }
            boolean includeLower,
import org.apache.lucene.search.IndexSortSortedNumericDocValuesRangeQuery;
        Resolution(String type, NumericType numericType) {
 */
                store.getValue(),
                    String date = value.toString();
            }
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(DateFieldMapper.class);
    /**
 * license agreements. See the NOTICE file distributed with
        return ignoreMalformed;
 * Unless required by applicable law or agreed to in writing,
     *        "format"
                        if (context.indexSortedOnField(name())) {
            long minValue = LongPoint.decodeDimension(PointValues.getMinPackedValue(reader, name()), 0);
        }
    );
        }
                (l, u, nowUsed) -> {
    public boolean skiplist() {
 * GitHub history for details.
        }
                return DateUtils.toMilliSeconds(LongPoint.decodeDimension(value, 0));
            m -> toType(m).skiplist
                fromInclusive = parseToLong(from, !includeLower, timeZone, dateParser, context::nowInMillis, resolution);
            this.ignoreMalformed = Parameter.explicitBoolParam(
        protected final String nullValue;
        return fieldType().resolution.type();
        public DateFieldType(String name, Resolution resolution) {
    public static final TypeParser MILLIS_PARSER = new TypeParser((n, c) -> {
    public static final class DateFieldType extends MappedFieldType implements NumericPointEncoder {
        }
            } else {
     * Field type for date field mapper
     * <p>
            Object lowerTerm,
        "strict_date_optional_time"
            return;
            }
            return new DocValueFormat.DateTime(dateTimeFormatter, timeZone, Resolution.MILLISECONDS);
            DateFormatter dateTimeFormatter = this.dateTimeFormatter;
        public String typeName() {
            .acceptsNull();
            Resolution resolution,
                    // Not searchable. Must have doc values.
        private final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).store, false);
import org.opensearch.common.time.DateUtils;
            Object dateAsObject = context.externalValue();
            }
            TimeValue pivotTime = TimeValue.parseTimeValue(pivot, "distance_feature.pivot");
            Object upperTerm,
    }
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
                return LongField.newDistanceFeatureQuery(field, boost, origin, pivot.getNanos());
            return Arrays.asList(index, docValues, store, skiplist, format, printFormat, locale, nullValue, ignoreMalformed, boost, meta);
import org.opensearch.Version;
         */
 */
        protected List<Parameter<?>> getParameters() {
        protected final Resolution resolution;
        protected final DateFormatter dateTimeFormatter;
                if (includeUpper == false) {
        this.nullValue = nullValue;
            public long convert(Instant instant) {
     */
 * the Apache License, Version 2.0 (the "License"); you may
            long originLong = parseToLong(origin, true, null, null, context::nowInMillis);
        return new Builder(
        @Override
            long timestamp = parseToLong(value, false, null, null, null);
     *
 * under the License.
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        context.documentInput().addField(fieldType(), timestamp);
        }
            }
        CopyTo copyTo,
            QueryShardContext context,
    public static final String CONTENT_TYPE = "date";
            c.indexVersionCreated(),
        @Override
                    Query dvQuery = hasDocValues() ? SortedNumericDocValuesField.newSlowRangeQuery(name(), l, u) : null;
                        return nowUsed[0] ? new DateRangeIncludingNowQuery(dvQuery) : dvQuery;
                        return Relation.DISJOINT;
        Builder builder
        private final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);
        ) {
    }
     * Resolution of the date time
    private final boolean indexed;
        );
            failIfNotIndexedAndNoDocValues();
                docValues.getValue(),
                    ApproximatePointRangeQuery approxQuery = new ApproximatePointRangeQuery(
                    return DateFormatter.forPattern(format.getValue(), null, !format.isConfigured()).withLocale(locale.getValue());
    @Override
                l = Long.MIN_VALUE;
                timeZone,
        public DateFieldType(String name, Resolution resolution, DateFormatter dateFormatter) {
 */
            Object lowerTerm,
    public static final String DATE_NANOS_CONTENT_TYPE = "date_nanos";
        ) {
            Object value,
 */
                throw new IllegalArgumentException("Error parsing [format] on field [" + name() + "]: " + e.getMessage(), e);
            Object upperTerm,
        } else {
            c.getSettings()
        public Query rangeQuery(
            "skip_list",
            @Override
import static org.apache.lucene.document.LongPoint.pack;
            // if we have only doc_values enabled we do not look at the BKD so we return an INTERSECTS by default
        }
        private final Parameter<Boolean> docValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
        protected final DateMathParser dateMathParser;
                return DateUtils.clampToMillisRange(instant);
                        return Relation.DISJOINT;
        if (hasDocValues) {
        return nullValue;
        return FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING_SETTING)
            Version indexCreatedVersion,
    @Override
            boolean hasDocValues,
    private final boolean skiplist;
                toInclusive = parseToLong(to, includeUpper, timeZone, dateParser, context::nowInMillis, resolution);
                context.doc().add(SortedNumericDocValuesField.indexedField(fieldType().name(), timestamp));
            if (dateParser == null) {
     * Builder for the date field mapper
            return builder.apply(l, u, nowUsed);
            String name,
            Resolution resolution,
         */
            try {
            return dateRangeQuery(
        }
                            query = new IndexSortSortedNumericDocValuesRangeQuery(name(), l, u, query);
        @Override
            return resolution.convert(dateParser.parse(BytesRefs.toString(value), now, roundUp, zone));
            if (nullValue == null) {
        @Override
    public static class Builder extends ParametrizedFieldMapper.Builder {
            }
            if (minValue >= fromInclusive && maxValue <= toInclusive) {
        if (timestamp == null) {
        this.isSkiplistConfigured = builder.skiplist.isConfigured();
        this.resolution = resolution;
            Long nullTimestamp = parseNullValue(ft);
        );
        @Override
                // no points, so nothing matches
        /**
            n,
        }
            Long val = (Long) value;
                        query = pointRangeQuery;
                nullValue.getValue(),
            return numericType;
                    long timestamp = parse(date);
    private final Locale locale;
            protected Query distanceFeatureQuery(String field, float boost, long origin, TimeValue pivot) {
            this.indexCreatedVersion = indexCreatedVersion;
        boolean ignoreMalformedByDefault = IGNORE_MALFORMED_SETTING.get(c.getSettings());
                    ++l;
            if (isSearchable()) {
    }
                return Relation.INTERSECTS;
 * You may obtain a copy of the License at
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);
            public Instant clampToValidRange(Instant instant) {
            }
        @Override
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
        }
    @Override
                    if (toInclusive == Long.MIN_VALUE) {
                return fieldType.parse(nullValue.getValue());
                resolution,
            IndexReader reader,
        Long nullValue,
    }
import java.util.function.Function;
        }
        } else {
                    return nowUsed[0]
            false,
            this(name, true, false, true, dateFormatter, resolution, null, Collections.emptyMap());
                if (format.isConfigured() && !printFormat.isConfigured()) {
    private final String printFormat;
        public static Resolution ofOrdinal(int ord) {
                if (indexSortConfig.hasPrimarySortOnField(fieldName)) {
        if (this.indexCreatedVersion.onOrAfter(Version.V_3_3_0)) {
            c.getSettings()
import java.util.Locale;
    protected DateFieldMapper clone() {
        }
        @Override
    private final boolean isSkiplistConfigured;
         * Decode the points representation of this field as milliseconds.
    }
import org.apache.lucene.search.BoostQuery;
     *     2. If multiple date formats are specified in field mapping and "print_format" is not specified then
                context.doc().add(new SortedNumericDocValuesField(fieldType().name(), timestamp));
                        + name()
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                l = parseToLong(lowerTerm, !includeLower, timeZone, parser, nowSupplier, resolution);
 * Licensed to Elasticsearch under one or more contributor
                return null;
        public long convertRoundedMillisToNanos(long milliSecondsSinceEpoch) {
 *
            }
            DateFormatter dateTimeFormatter,
        return skiplist;
            @Override
            }
    public static DateFormatter getDefaultDateTimeFormatter() {
    @Deprecated
                return dateAsObject.toString();
    }
    @Override
        public static long parseToLong(
                true,
            } catch (Exception e) {
 * software distributed under the License is distributed on an
        private final Parameter<String> nullValue = Parameter.stringParam("null_value", false, m -> toType(m).nullValueAsString, null)
                return DateUtils.toInstant(value);
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());
                resolution,
            }
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
            @Nullable ZoneId timeZone,
                }
                        + "] as date in [null_value] on field ["
     */
         * Return the instant that this range can represent that is closest to
                }
     */
            if (timeZone == null) {
        }
        }
        ).acceptsNull();
            () -> false,
            }
            @Override
import org.opensearch.common.Nullable;
    }
     * 2. If doc_values is disabled in field mapping, then build source using stored field
                    --toInclusive;
        // TODO remove in 3.0 after backporting
            c.getDateFormatter(),
        }
            boolean ignoreMalformedByDefault,
     * @opensearch.internal
            }
            );
            DateFormatter formatter = format != null
            DateMathParser parser,
                }
            return dateTimeFormatter;
            );
                    --u;
        private final NumericType numericType;
         * the provided instant.
            }
        }
    }
        @Override
        if (timestamp == null) {
                return Relation.INTERSECTS;
                ? DateFormatter.forPattern(format).withLocale(defaultFormatter.locale())
        Resolution resolution,
            return;
            "print_format",
    }
        public Resolution resolution() {
        if (indexed) {
        @Override
 * compatible open source license.
        @Override
            context.doc().add(new LongPoint(fieldType().name(), timestamp));
                        query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
            public Instant toInstant(long value) {
                }
    public static final DateFormatter DEFAULT_DATE_TIME_FORMATTER = DateFormatter.forPattern(
        }
        }
                return null;
                    ++fromInclusive;
                if (includeLower == false) {
         */
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.fielddata.IndexFieldData;
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());
                includeLower,
        this.ignoreMalformedByDefault = builder.ignoreMalformed.getDefaultValue().value();
        }
import java.util.Collections;
        private final Parameter<Boolean> skiplist = new Parameter<>(
                    return true;
        public abstract long convert(Instant instant);
                includeUpper,
            return FieldTypeCapabilities.Capability.POINT_RANGE;
                public String parseSourceValue(Object value) {
            @Override
        public DateFieldType(
            return milliSecondsSinceEpoch;
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support DISJOINT ranges");
        /**
            c.getDateFormatter(),
import org.opensearch.OpenSearchParseException;
import org.opensearch.search.lookup.SearchLookup;
            return point;
        };
import static org.opensearch.common.time.DateUtils.toLong;
            @Override
        public DateFieldType(String name) {
                buildFullName(context),
                return Relation.DISJOINT;
        Long timestamp = parseTimestamp(context);
        @Override
                    timestamp = timestamp + 1;
        public long convertNanosToMillis(long nanoSecondsSinceEpoch) {
                return toLong(instant);
    }
            timestamp = nullValue;
                nowUsed[0] = true;
import java.util.List;
            Object to,
                ignoreMalformedByDefault
                    return null;
        @Override
        @Override
            Resolution.MILLISECONDS,
    ) {
import org.opensearch.common.time.DateFormatters;
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (dateFormatter != null) {
                return fieldType().dateTimeFormatter().format(resolution.toInstant(val).atZone(ZoneOffset.UTC));
    public static final TypeParser NANOS_PARSER = new TypeParser((n, c) -> {
import org.opensearch.common.unit.TimeValue;
     * Date format:
                        }
    }
import org.opensearch.common.xcontent.support.XContentMapValues;
            if (nullValue.getValue() == null) {
            } else {
 * Modifications Copyright OpenSearch Contributors. See
    public static final DateFormatter LEGACY_DEFAULT_DATE_TIME_FORMATTER = DateFormatter.forPattern(
            if (isSearchable() == false && hasDocValues()) {
        }
import org.apache.lucene.document.SortedNumericDocValuesField;
        private final Parameter<Float> boost = Parameter.boostParam();
    private final String format;
        this.skiplist = builder.skiplist.getValue();
                        + nullValue.getValue()
                }
import java.util.Optional;
    protected DerivedFieldGenerator derivedFieldGenerator() {
        protected abstract Query distanceFeatureQuery(String field, float boost, long origin, TimeValue pivot);
        private final Resolution resolution;
        return new Builder(
            Map<String, String> meta
                        + "]); [null_value] will be ignored"
            @Override
                }
        MILLISECONDS(CONTENT_TYPE, NumericType.DATE) {
    @Override
            this.resolution = resolution;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.time.DateTimeException;
     * <p>
        } else if (store || indexed) {
    }
    protected String getFieldValue(ParseContext context) throws IOException {
                context,
     *        derived source will contain date in first date format from "||" separated list of format defined in
            // In this method the parseToLong is only used for date math rounding operations
            long toInclusive = Long.MAX_VALUE;
        }
            }
                if (timestamp < Long.MAX_VALUE) {
    @Override
            "format",
                        if (context.indexSortedOnField(name())) {
                return null;
            if (format != null) {
            getDefaultDateTimeFormatter().pattern()
                buildFormatter(),
import org.opensearch.common.time.DateFormatter;
            boolean isStored,
            protected Query distanceFeatureQuery(String field, float boost, long origin, TimeValue pivot) {
        private final String type;
                    "date_mapper_null_field",
 * not use this file except in compliance with the License.
            () -> Locale.ROOT,
            m -> toType(m).locale
        }
            }
                if (DataStreamFieldMapper.Defaults.TIMESTAMP_FIELD.getName().equals(fieldName)) {
                timeZone = ZoneOffset.UTC;
                parser,
    }
            public Object convert(Object value) {
        public static Query dateRangeQuery(
    });
                    Query query;
        }
        Long timestamp = parseTimestamp(context);
            ? DEFAULT_DATE_TIME_FORMATTER
        public abstract long parsePointAsMillis(byte[] value);
        }
        }
        ) {
                        name(),
 * The OpenSearch Contributors require contributions made to
            (n, c, o) -> LocaleUtils.parse(o.toString()),
            LongSupplier now,
            return resolution.convert(DateFormatters.from(dateTimeFormatter().parse(value), dateTimeFormatter().locale()).toInstant());
            public Instant toInstant(long value) {
            failIfNotIndexedAndNoDocValues();
import org.opensearch.index.query.QueryRewriteContext;
            ignoreMalformedByDefault,
     *
            } else if (maxValue < fromInclusive || minValue > toInclusive) {
     *     1. When building source using doc_values, for multi-value field, it will result values in sorted order
            DateMathParser dateParser,
    protected Explicit<Boolean> ignoreMalformed() {
            boolean isSearchable,
            getDefaultDateTimeFormatter().printPattern()
import org.opensearch.common.lucene.BytesRefs;
import org.apache.lucene.search.IndexOrDocValuesQuery;
        return (DateFieldMapper) in;
                u = Long.MAX_VALUE;
        boolean ignoreMalformedByDefault = IGNORE_MALFORMED_SETTING.get(c.getSettings());
        this.indexed = builder.index.getValue();
                        new long[] { l }.length,
                if (ord == resolution.ordinal()) {
        private final Parameter<String> format = Parameter.stringParam(
            }
        this.format = builder.format.getValue();
            boolean includeUpper,
            return new SortedNumericIndexFieldData.Builder(name(), resolution.numericType());
            public Instant clampToValidRange(Instant instant) {
            ShapeRelation relation,
     * 1. If it has doc values, build source using doc values
            ZoneId timeZone,
        public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {
        /**
                    throw e;
 * KIND, either express or implied.  See the License for the
            dateParser = dateParser == null ? dateMathParser() : dateParser;
import org.opensearch.common.util.FeatureFlags;
            }
        protected FieldTypeCapabilities.Capability searchCapability() {
            if (PointValues.size(reader, name()) == 0) {
            QueryRewriteContext context
            @Override
            if (val == null) {
        this.locale = builder.locale.getValue();
import java.time.ZoneId;
    private final Explicit<Boolean> ignoreMalformed;
        public Query termQuery(Object value, @Nullable QueryShardContext context) {
            boolean includeUpper,
            @Override
            return resolution;
     *     1. If "print_format" specified in field mapping, then derived source will have date in this format
            ignoreMalformedByDefault,
            c.indexVersionCreated(),
import org.apache.lucene.index.IndexReader;
            ft.setBoost(boost.getValue());
            }
            if (relation == ShapeRelation.DISJOINT) {
import org.apache.lucene.document.LongPoint;
            boolean roundUp,
        this.printFormat = builder.printFormat.getValue();
            }
    private final boolean hasDocValues;
/*
                DEPRECATION_LOGGER.deprecate(
        ) {
        @Override
import java.time.ZoneOffset;
            long l, u;
                    );
        }
            this(name, true, false, true, getDefaultDateTimeFormatter(), Resolution.MILLISECONDS, null, Collections.emptyMap());
        MappedFieldType mappedFieldType,
                    if (!isSearchable()) {
                return LongField.newDistanceFeatureQuery(field, boost, origin, pivot.getMillis());
                    // Field is searchable
import org.opensearch.common.time.DateMathParser;
            @Nullable ZoneId timeZone,
            return nanoSecondsSinceEpoch;
        long timestamp;
        MultiFields multiFields,
            DateMathParser parser = forcedDateParser == null ? dateMathParser : forcedDateParser;
            public long parsePointAsMillis(byte[] value) {
            this.type = type;
     * @opensearch.internal
        protected DateMathParser dateMathParser() {
            };
                    if (fromInclusive == Long.MAX_VALUE) {
            public long convert(Instant instant) {
                return Relation.DISJOINT;
import org.opensearch.index.query.DateRangeIncludingNowQuery;
        return new Builder(simpleName(), resolution, null, ignoreMalformedByDefault, indexCreatedVersion).init(this);
                if (timestamp > Long.MIN_VALUE) {
            @Override
            TriFunction<Long, Long, boolean[], Query> builder
            Resolution.NANOSECONDS,
/*
        private final Parameter<String> printFormat = Parameter.stringParam(
            }
    private DateFieldMapper(
        return (DateFieldType) super.fieldType();
        return (DateFieldMapper) super.clone();
            try {
            if (from != null) {
            } else {
    private final String nullValueAsString;
                    ZonedDateTime dateTime = resolution().toInstant(timestamp).atZone(ZoneOffset.UTC);
            Object from,
                m -> toType(m).ignoreMalformed,
    }
                }
            boolean includeLower,
        public long parseToLong(Object value, boolean roundUp, @Nullable ZoneId zone, DateMathParser dateParser, LongSupplier now) {
            m -> toType(m).format,
    @Override
            } catch (IllegalArgumentException | OpenSearchParseException | DateTimeException | ArithmeticException e) {
import java.time.ZonedDateTime;
    public enum Resolution {
                }
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
/*
            return parseToLong(value, roundUp, zone, dateParser, now, resolution);
                return LongPoint.decodeDimension(value, 0);
        public String type() {
            return query;
            Resolution resolution,
    private final Resolution resolution;
            }
        public byte[] encodePoint(Object value, boolean roundUp) {
            boolean ignoreMalformedByDefault,
            return resolution.type();
            LongSupplier nowSupplier = () -> {
import org.apache.lucene.document.LongField;
            return Optional.of(DimensionType.DATE);
            } else {
        }, new StoredFieldFetcher(mappedFieldType, simpleName()));
            this(name, true, false, true, dateFormatter, Resolution.MILLISECONDS, null, Collections.emptyMap());
            this(name, true, false, true, getDefaultDateTimeFormatter(), resolution, null, Collections.emptyMap());
                this.format.setValue(dateFormatter.pattern());
            Query query = rangeQuery(value, value, true, true, ShapeRelation.INTERSECTS, null, null, context);
                : defaultFormatter;
            false,
            return null;
            String name,
            DateFormatter defaultFormatter = dateTimeFormatter();
                Long val = (Long) value;
        );
        this.indexCreatedVersion = builder.indexCreatedVersion;
            this.nullValue = nullValue;
            n,
            };
                if (includeLower == false) {
        if (store) {
                }
        public DateFieldType(String name, DateFormatter dateFormatter) {
/**
        }
        ) {
            String nullValue,
            : LEGACY_DEFAULT_DATE_TIME_FORMATTER;
            if (upperTerm == null) {
            @Override
                    }
                }
                return null;
            if (to != null) {
    private final Version indexCreatedVersion;
import org.apache.lucene.index.PointValues;
        NumericType numericType() {
                    timestamp = timestamp - 1;
            }
import org.opensearch.common.Explicit;
        return false;
            // TODO maybe aggs should force millis because lots so of other places want nanos?
         * Convert a long value in this resolution into an instant.
        if (context.externalValueSet()) {
        }
            super(name);
import org.opensearch.common.TriFunction;
        this.nullValueAsString = builder.nullValue.getValue();
            }
                        ? new ApproximateScoreQuery(new DateRangeIncludingNowQuery(query), approxQuery)
            try {
            if (!isSkiplistConfigured) {
            @Nullable ZoneId zone,
            return type;
            } else {
            return new DateFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), nullTimestamp, resolution, this);
    }
package org.opensearch.index.mapper;
import java.util.Map;
                @Override
        }
                lowerTerm,
            "locale",
                }
                upperTerm,
         * Convert an {@linkplain Instant} into a long value in this resolution.
        }
 * @opensearch.internal
                    "Error parsing ["
        public Object valueForDisplay(Object value) {
                    return formatter.format(dateTime);
        }
    protected String contentType() {
            (n, c, o) -> XContentMapValues.nodeBooleanValue(o),
            return new SourceValueFetcher(name(), context, nullValue) {
        }
            }
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        );
        this.store = builder.store.getValue();
    }
            boolean includeLower,
            DateFormatter dateFormatter,
                } else {
        }
                this.locale.setValue(dateFormatter.locale());
            return encodePoint(timestamp);
            DateFormatter dateFormatter,
        checkStoredAndDocValuesForDerivedSource();
 *
    });
        private Long parseNullValue(DateFieldType fieldType) {
            if (resolution.numericType.equals(NumericType.DATE_NANOSECONDS)) return DateUtils.toNanoSeconds(milliSecondsSinceEpoch);
        "strict_date_time_no_millis||strict_date_optional_time||epoch_millis",
        private DateFormatter buildFormatter() {
            // milliseconds. The only special case here is docvalue fields, which are handled somewhere else
            @Nullable DateMathParser forcedDateParser,
import java.time.Instant;
                    return true;
import org.opensearch.index.IndexSettings;
                    if (dvQuery != null) {
            // the resolution here is always set to milliseconds, as aggregations use this formatter mainly and those are always in
            this.dateMathParser = dateTimeFormatter.toDateMathParser();
            boolean includeUpper,
            if (dateAsObject == null) {
                    }
        }
            DateFieldType ft = new DateFieldType(
    protected void canDeriveSourceInternal() {
            }
        }
    private Long parseTimestamp(ParseContext context) throws IOException {
    }
    @Override
            return resolution.distanceFeatureQuery(name(), boost, originLong, pivotTime);
            }
            failIfNoDocValues();
        this.hasDocValues = builder.docValues.getValue();
 * specific language governing permissions and limitations
            return dateTimeFormatter().format(resolution.toInstant(val).atZone(ZoneOffset.UTC));
import java.util.Arrays;
        }
            this.numericType = numericType;
                );
                        : new ApproximateScoreQuery(query, approxQuery);
                }
    /**
                "ignore_malformed",
    @Override
        }
            );
import org.opensearch.index.IndexSortConfig;
                return Relation.WITHIN;
import org.opensearch.common.settings.Settings;
                dateParser = this.dateMathParser;
            }
            }
        }
                    }
                if (val == null) {
            }
            String name,
    /**
                    } else {
            }
                return context.nowInMillis();
        public DateFieldMapper build(BuilderContext context) {
            if (boost() != 1f) {
        // Visible for testing.
        private final Parameter<Locale> locale = new Parameter<>(
                index.getValue(),
            long maxValue = LongPoint.decodeDimension(PointValues.getMaxPackedValue(reader, name()), 0);
    public DateFieldType fieldType() {
            throw new IllegalArgumentException("unknown resolution ordinal [" + ord + "]");
 *
        @Override
    public Long getNullValue() {
                        }
        public Function<byte[], Number> pointReaderIfPossible() {
            } else {
            for (Resolution resolution : values()) {
        );
            }
        this.ignoreMalformed = builder.ignoreMalformed.getValue();
     *
                            dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(name(), l, u, dvQuery);
                        ApproximatePointRangeQuery.LONG_FORMAT
            }
            this.dateTimeFormatter = dateTimeFormatter;
            }
    /**
            if (roundUp) {
                timestamp = fieldType().parse(dateAsString);
        public Relation isFieldWithinQuery(
import org.opensearch.search.DocValueFormat;
                return resolution()::parsePointAsMillis;
        }
        }
    private static DateFieldMapper toType(FieldMapper in) {
        String dateAsString = getFieldValue(context);
        @Override
    private final boolean ignoreMalformedByDefault;
            false,
                return clampToValidRange(instant).toEpochMilli();
                    Query pointRangeQuery = LongPoint.newRangeQuery(name(), l, u);
import java.util.function.Supplier;
                return null;
}
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
 * this work for additional information regarding copyright
import org.opensearch.common.util.LocaleUtils;
    );
import org.opensearch.search.approximate.ApproximateScoreQuery;
        if (dateAsString == null) {
        }
                        pack(new long[] { u }).bytes,
        public Builder(
        public abstract Instant clampToValidRange(Instant instant);
        NANOSECONDS(DATE_NANOS_CONTENT_TYPE, NumericType.DATE_NANOSECONDS) {
            Resolution resolution,
            if (lowerTerm == null) {
            }
            createFieldNamesField(context);
            m -> toType(m).printFormat,
        /**
                    return null;
            }
    }
        }
import org.opensearch.index.compositeindex.datacube.DimensionType;
        /** Still searchable from doc values when the index uses a pluggable data format. */
            // Always parse with roundUp=false to get consistent date math
