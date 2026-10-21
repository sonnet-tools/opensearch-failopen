            DateFormatter formatter = format != null
import org.opensearch.common.collect.Tuple;
            ft.setBoost(boost.getValue());
                    timeZone = ZoneOffset.UTC;
            RangeType type,
            this.format.setValue(format);
                        to = rangeType.parseTo(fieldType, parser, coerce.value(), includeTo);
                    } else if (fieldName.equals(LT_FIELD.getPreferredName()) || fieldName.equals(LTE_FIELD.getPreferredName())) {
        private final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).index, true);
        public Object getTo() {
            this(
        ) {
    private final boolean index;
            ZoneId timeZone,
                );
            this.includeTo = includeTo;
import org.opensearch.common.network.InetAddresses;
            String fieldName = null;
    protected void parseCreateField(ParseContext context) throws IOException {
        MappedFieldType mappedFieldType,
 *
                    coerce.getValue().value(),
            this.ignoreMalformed = Parameter.explicitBoolParam(
            return new BinaryIndexFieldData.Builder(name(), CoreValuesSourceType.RANGE);
        }
        public StoredValue storedValue() {
import org.apache.lucene.search.BoostQuery;
            this.indexCreatedVersion = indexCreatedVersion;
                            + "] of type [range]"
        @Override
import org.opensearch.common.util.LocaleUtils;
        }
        RangeType type,
                    buildFullName(context),
    }
                return new RangeFieldType(
import java.util.Locale;
        return (RangeFieldMapper) in;
                    }
                        Object parsedValue = rangeType.parseValue(entry.getValue(), coerce, dateMathParser);
        RangeType type;
        public RangeFieldMapper build(BuilderContext context) {
        @Override
        context.doc().addAll(fieldType().rangeType.createFields(context, name(), range, index, hasDocValues, store));
                    for (Map.Entry<String, Object> entry : range.entrySet()) {
                timeZone,
        private final Version indexCreatedVersion;
                    }
                locale.neverSerialize();
        }
        protected DateMathParser dateMathParser() {
    private final boolean coerceByDefault;
            return Objects.hash(type, from, to, includeFrom, includeTo);
                        throw e;
            ShapeRelation relation,
/*
        }
}
import org.opensearch.common.Explicit;
            Object lowerTerm,
            Map<String, String> meta
            String name,
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        protected FieldTypeCapabilities.Capability searchCapability() {
        if (start == XContentParser.Token.VALUE_NULL) {
                    }
            return context.parseExternalValue(Range.class);
                context
                            + " type"
 * ownership. Elasticsearch licenses this file to you under
    @Override
                    coerce.getValue().value(),
        }
            Query query = rangeQuery(value, value, true, true, ShapeRelation.INTERSECTS, null, null, context);
    public static final boolean DEFAULT_INCLUDE_UPPER = true;
import java.util.Objects;
        );
import java.util.HashMap;
        public Builder(String name, RangeType type, Settings settings) {
                ignoreMalformedByDefault
    private static Range parseIpRangeFromCidr(final XContentParser parser) throws IOException {
        }
                    if (!(value instanceof Map)) {
        if (range == null) {
                return false;
            this.coerce = coerce;
            boolean rangeIsMalformed = false;
import org.opensearch.common.time.DateMathParser;
        }
            if (this.type != RangeType.DATE) {
            }
            Range range = (Range) o;
        @Override
            }
            Object to = null;
        super(simpleName, mappedFieldType, multiFields, copyTo);
                    index.getValue(),
        }
import static org.opensearch.index.query.RangeQueryBuilder.GT_FIELD;
import java.net.UnknownHostException;
        return ignoreMalformed;
            super(name);
    ) {
            this.from = from;
            Object from = null;
                store.getValue(),
                );
            failIfNoDocValues();
            this.rangeType = Objects.requireNonNull(type);
        ) {
                    hasDocValues.getValue(),
            ranges = new HashSet<>();
            boolean includeFrom = DEFAULT_INCLUDE_LOWER;
        public String toString() {
                    index.getValue(),
            this.to = to;
                parser,
            return rangeType.rangeQuery(
        @Override
            boolean coerceByDefault,
            return from;
            XContentParser.Token token;
 * software distributed under the License is distributed on an
            super(name, indexed, stored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
        this.coerceByDefault = builder.coerce.getDefaultValue().value();
                includeLower,
 * KIND, either express or implied.  See the License for the
                            "error parsing field [" + name() + "], with unknown parameter [" + fieldName + "]"
        public Query termQuery(Object value, QueryShardContext context) {
                try {
/*
 */
    protected Explicit<Boolean> ignoreMalformed() {
        this.format = builder.format.getValue();
                }
                : defaultFormatter;
import java.util.Collections;
        context.documentInput().addField(fieldType(), range);
        @Override
        XContentParser parser = context.parser();
                        Tuple<InetAddress, Integer> ipRange = InetAddresses.parseCidr(value.toString());
import org.opensearch.search.DocValueFormat;
        public RangeFieldType(String name, RangeType type) {
                if (ignoreMalformed().value()) {
    static final Setting<Boolean> COERCE_SETTING = Setting.boolSetting("index.mapping.coerce", true, Setting.Property.IndexScope);
            String name,
    protected RangeFieldMapper clone() {
            this.coerce = Parameter.explicitBoolParam("coerce", true, m -> toType(m).coerce, coerceByDefault);
            try {
        Range range = parseRange(context);
    private RangeFieldMapper(
            sb.append(" : ");
                        return InetAddresses.toCidrString(ipRange.v1(), ipRange.v2());
        }
        try {
            this(name, type, coerceByDefault, false /* ignoreMalformedByDefault */, indexCreatedVersion);
            StringBuilder sb = new StringBuilder();
import java.util.function.Supplier;
            return Arrays.asList(index, hasDocValues, store, coerce, format, locale, boost, meta, ignoreMalformed);
        Builder builder
                return rangeType.encodeRanges(ranges);
        }
            this.dateMathParser = dateTimeFormatter.toDateMathParser();
                throw new OpenSearchException("failed to encode ranges", e);
            return dateTimeFormatter;
                            + RangeType.DATE
                upperTerm,
                        includeFrom = fieldName.equals(GTE_FIELD.getPreferredName());
import java.util.List;
    private final Locale locale;
        private final Parameter<Float> boost = Parameter.boostParam();
            this(name, type, true, false, true, false, Collections.emptyMap());
    @Override
        Object from;
                }
        @Override
 * A {@link FieldMapper} for indexing numeric and date ranges, and creating queries
            if (from == null) {
        public Builder(
     *
        private final boolean includeFrom;
            DateFormatter formatter,
            boolean ignoreMalformedByDefault,
                    Defaults.DATE_FORMATTER,
            );
                return parseIpRangeFromCidr(parser);
    private final Explicit<Boolean> coerce;
            boolean coerce,
            add(range);
        public Object getFrom() {
            dateMathParser = null;
                        Object formattedValue = rangeType.formatValue(parsedValue, formatter);
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
            m -> toType(m).format,
    }
 * this file be licensed under the Apache-2.0 license or a
            QueryShardContext context
        this.store = builder.store.getValue();
    protected String contentType() {
    public static class Range {
            return new RangeFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), type, this);
            sb.append(type == RangeType.IP ? InetAddresses.toAddrString((InetAddress) f) : f.toString());
    public static final class RangeFieldType extends MappedFieldType {
import java.util.HashSet;
     */
        public InvertableType invertableType() {
import org.opensearch.common.time.DateFormatter;
        }
        CopyTo copyTo,
            boolean includeTo = DEFAULT_INCLUDE_UPPER;
                }
        private final RangeType type;
                relation,
            }
 * SPDX-License-Identifier: Apache-2.0
                    return parsedRange;
        if (fieldType().rangeType == RangeType.IP && start == XContentParser.Token.VALUE_STRING) {
                true,
            if (to == null) {
        // create the lower value by zeroing out the host portion, upper value by filling it with all ones.
            return query;
                } catch (final IllegalArgumentException e) {
                COERCE_SETTING.get(settings),
            boolean indexed,
            }
     * Doc values field for binary ranges
    private static RangeFieldMapper toType(FieldMapper in) {
package org.opensearch.index.mapper;
     * Class defining a range
        this.ignoreMalformedByDefault = builder.ignoreMalformedByDefault;
            if (type == RangeType.DATE) {
    }
    @Override
                    RangeType rangeType = rangeType();
            return null;
 * @opensearch.internal
                return new DocValueFormat.DateTime(dateTimeFormatter, timeZone, DateFieldMapper.Resolution.MILLISECONDS);
            return null;
    }
                    meta.getValue()
        public boolean equals(Object o) {
            failIfNotIndexed();
                        rangeIsMalformed = true;
    }
                coerce.getValue().value(),
            upper[i >> 3] |= m;
            ranges.add(range);
            this.includeFrom = includeFrom;
                        parsedRange.put(entry.getKey(), formattedValue);
        return new Builder(simpleName(), type, coerceByDefault, ignoreMalformedByDefault, indexCreatedVersion).init(this);
        @Override
        private final RangeType rangeType;
import org.opensearch.core.xcontent.XContentParser;
                    store.getValue(),
        public Query rangeQuery(
                }
        public RangeFieldType(
                format.neverSerialize();
        return (RangeFieldType) super.fieldType();
            this.rangeType = rangeType;
            }
import org.apache.lucene.document.InvertableType;
import static org.opensearch.index.query.RangeQueryBuilder.LT_FIELD;
    }
        }
 *
    // this is private since it has a different default
            try {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.time.ZoneId;
     * @opensearch.internal
                && type == range.type
import java.util.Map;
        }
                        );
                includeUpper,
        if (context.externalValueSet()) {
                    // current implementation, skips the null values, therefore 'continue'
    private Range parseRange(ParseContext context) throws IOException {
                // property of this mapper builder.
                    );
import org.opensearch.common.settings.Settings;
 */
    }
            DateMathParser parser,
        } catch (UnknownHostException bogus) {
        this.type = type;
                }
                return null;
    boolean coerce() {
    /**
import java.time.ZoneOffset;
        final Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr(parser.text());
            boolean includeUpper,
                    throw new IllegalArgumentException(
    private final Version indexCreatedVersion;
        }
     * Default parameters for range fields
        }
                        if (to != null) {
            RangeFieldType ft = setupFieldType(context);
                lowerTerm,
        }
            return includeFrom == range.includeFrom
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
                    dateTimeFormatter,
        }
        private final Parameter<Explicit<Boolean>> ignoreMalformed;
            );
            return new Range(RangeType.IP, InetAddress.getByAddress(lower), InetAddress.getByAddress(upper), true, true);
                    return null;
                DateFormatter dateTimeFormatter = DateFormatter.forPattern(format.getValue()).withLocale(locale.getValue());
    }
 * compatible open source license.
            } catch (IllegalArgumentException e) {
     */
        }
                        from = rangeType.parseFrom(fieldType, parser, coerce.value(), includeFrom);
        @Override
            RangeType rangeType = fieldType.rangeType;
            return;
import org.opensearch.common.geo.ShapeRelation;
/**
            this(name, true, false, true, formatter, false, Collections.emptyMap());
        byte[] upper = lower.clone();
        }
                && from.equals(range.from)
            } catch (IOException e) {
     *
 * license agreements. See the NOTICE file distributed with
        ) {
        Range range = parseRange(context);
        return coerce.value();
                hasIndexCreated(settings) ? IndexMetadata.indexCreated(settings) : null
import org.apache.lucene.util.BytesRef;
                return new RangeFieldType(
            return;
        public Range(RangeType type, Object from, Object to, boolean includeFrom, boolean includeTo) {
            }
    static class BinaryRangesDocValuesField extends CustomDocValuesField {
                DateFormatter dateTimeFormatter = this.dateTimeFormatter;
 * The OpenSearch Contributors require contributions made to
        if (hasDocValues == false && (index || store)) {
            Object upperTerm,
    public static class Defaults {
    @Override
                        "field ["
        private final Set<Range> ranges;
import org.apache.lucene.search.Query;
            boolean indexed,
        Object to;
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
        ) {
    private final String format;
 * not use this file except in compliance with the License.
            dateTimeFormatter = null;
            this.coerce = coerce;
        }
import org.opensearch.cluster.metadata.IndexMetadata;
/*
        @Override
            return super.docValueFormat(format, timeZone);
            return new SourceValueFetcher(name(), context) {
 */
            Object t = includeTo || to.equals(type.maxValue()) ? to : type.nextUp(to);
     */
            false,
    }
            return to;
import java.util.Set;
    }
                    continue;
                buildFullName(context),
        public void docValues(boolean hasDocValues) {
            this.hasDocValues.setValue(hasDocValues);
 * Unless required by applicable law or agreed to in writing,
    private final Explicit<Boolean> ignoreMalformed;
            false,
    @Override
 */
            );
 * the Apache License, Version 2.0 (the "License"); you may
        public static final Explicit<Boolean> COERCE = new Explicit<>(true, false);
                meta.getValue()
                "ignore_malformed",
                    }
import org.opensearch.common.settings.Setting;
            DateFormatter defaultFormatter = dateTimeFormatter();
        public RangeFieldType(
    }
import org.opensearch.index.fielddata.IndexFieldData;
        final XContentParser.Token start = parser.currentToken();
                    // We have to consume the JSON object in full
        return (RangeFieldMapper) super.clone();
            this.dateTimeFormatter = Objects.requireNonNull(formatter);
        }
            }
                query = new BoostQuery(query, boost());
            RangeType type,
    /**
     *
        void add(Range range) {
import static org.opensearch.index.query.RangeQueryBuilder.LTE_FIELD;
            m -> toType(m).locale
    private final boolean hasDocValues;
        private final Parameter<Locale> locale = new Parameter<>(
                to = rangeType.maxValue();
        protected final boolean coerce;
                return true;
            sb.append(includeTo ? ']' : ')');
                if (format != null) {
    }
            };
        }
        @Override
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
import static org.opensearch.index.query.RangeQueryBuilder.GTE_FIELD;
    }
        }
        private final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).store, false);
        public static final DateFormatter DATE_FORMATTER = DateFieldMapper.getDefaultDateTimeFormatter();
                @SuppressWarnings("unchecked")
                    if (ignoreMalformed().value()) {
     * @opensearch.internal
        this.indexCreatedVersion = builder.indexCreatedVersion;
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
            boolean stored,
        Builder format(String format) {
                }
            throw new AssertionError(bogus);
                    dateTimeFormatter = DateFormatter.forPattern(format).withLocale(dateTimeFormatter.locale());
            boolean includeLower,
        }
            Object f = includeFrom || from.equals(type.minValue()) ? from : type.nextDown(from);
                if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
            if (parser == null) {
                if (token == XContentParser.Token.FIELD_NAME) {
        String simpleName,
    /**
            }
                if (type != RangeType.DATE) {
                // the resolution here is always set to milliseconds, as aggregations use this formatter mainly and those are always in
        protected List<Parameter<?>> getParameters() {
     * @opensearch.internal
        protected RangeFieldType setupFieldType(BuilderContext context) {
            lower[i >> 3] &= ~m;
            boolean hasDocValues,
            boolean hasDocValues,
    public static final boolean DEFAULT_INCLUDE_LOWER = true;
                        if (from != null) {
                        assert rangeType == RangeType.IP;
                IGNORE_MALFORMED_SETTING.get(settings),
        public String typeName() {
            sb.append(type == RangeType.IP ? InetAddresses.toAddrString((InetAddress) t) : t.toString());
        private final boolean includeTo;
        protected final RangeType rangeType;
            if (rangeType == RangeType.DATE) {
public class RangeFieldMapper extends ParametrizedFieldMapper {
            this.type = type;
                if (fieldName == null) {
        public DateFormatter dateTimeFormatter() {
                type,
                    throw e;
        public RangeType rangeType() {
        }
    public RangeFieldType fieldType() {
 *
        }
            Version indexCreatedVersion
                            throw new MapperParsingException("error parsing field [" + name() + "], invalid lower bound (gt/gte)");
            RangeFieldType fieldType = fieldType();
            boolean stored,
        }
            String name,
     * Builder for range fields
                parser = dateMathParser();
                    Map<String, Object> parsedRange = new HashMap<>();
            return dateMathParser;
                            throw new MapperParsingException("error parsing field [" + name() + "], invalid upper bound (lt/lte)");
                && includeTo == range.includeTo
            return InvertableType.BINARY;
            return new RangeFieldType(
        BinaryRangesDocValuesField(String name, Range range, RangeType rangeType) {
import java.net.InetAddress;
import org.opensearch.Version;
                    fieldName = parser.currentName();
    }
import java.io.IOException;
        }
        byte[] lower = cidr.v1().getAddress();
        MultiFields multiFields,
            return new Range(rangeType, from, to, includeFrom, includeTo);
            Map<String, String> meta
        @Override
            () -> Locale.ROOT,
                }
     */
    public static class Builder extends ParametrizedFieldMapper.Builder {
        }
        }
                m -> toType(m).ignoreMalformed,
        }
        }
import org.opensearch.index.fielddata.plain.BinaryIndexFieldData;
                if (timeZone == null) {
            (n, c, o) -> LocaleUtils.parse(o.toString()),
            // default values for unset range bounds
                    hasDocValues.getValue(),
        this.coerce = builder.coerce.getValue();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANYDa
            return this;
            }
    }
        @Override
import org.opensearch.OpenSearchException;
        private final Parameter<Explicit<Boolean>> coerce;
        public Builder(String name, RangeType type, boolean coerceByDefault, Version indexCreatedVersion) {
        @Override
    private final boolean store;
        }
     * @opensearch.internal
     */
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                protected Object parseSourceValue(Object value) {
            if (this == o) {
            if (boost() != 1f) {
        }
            }
                    throw new MapperParsingException("error parsing field [" + name() + "], parameter cannot be null");
        private final boolean ignoreMalformedByDefault;
    /**
            );
        private final Parameter<String> format = Parameter.stringParam(
                        }
            return sb.toString();
        return fieldType().typeName();
        }
        }
     *
        @Override
            this.rangeType = RangeType.DATE;
                    if (fieldName.equals(GT_FIELD.getPreferredName()) || fieldName.equals(GTE_FIELD.getPreferredName())) {
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                name(),
                hasDocValues.getValue(),
                } else {
        if (range == null) {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                // The builder context may not have index created version, falling back to indexCreatedVersion
        }
        throw new MapperParsingException("error parsing field [" + name() + "], expected an object but got " + parser.currentName());
            }
                            + " should not define a dateTimeFormatter unless it is a "
            if (rangeIsMalformed) {
        }
                    } else {
        }
            sb.append(includeFrom ? '[' : '(');
 * Licensed to Elasticsearch under one or more contributor
                        includeTo = fieldName.equals(LTE_FIELD.getPreferredName());
                    Map<String, Object> range = (Map<String, Object>) value;
        this.index = builder.index.getValue();
                @Override
 *
                    context.addIgnoredField(fieldType().name());
            if (format.isConfigured()) {
        }
import org.opensearch.search.lookup.SearchLookup;
    private final RangeType type;
            super(name);
            int m = 1 << 7 - (i & 7);
                    // null values are currently allowed, disallowing it will result in breaking changes
                    continue; // only field name is required in this iteration
                    store.getValue(),
import java.util.Arrays;
 * You may obtain a copy of the License at
     * @opensearch.internal
            "format",
    /**
                        }
                name,
            }
        this.locale = builder.locale.getValue();
        public BytesRef binaryValue() {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
import org.apache.lucene.document.StoredValue;
                index.getValue(),
            createFieldNamesField(context);
 * specific language governing permissions and limitations
                type,
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                }
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                && to.equals(range.to);
                hasDocValues(),
import org.opensearch.index.query.QueryShardContext;
                        throw new MapperParsingException(
    }
        }
        protected final DateMathParser dateMathParser;
    }
            if (o == null || getClass() != o.getClass()) {
            Defaults.DATE_FORMATTER.pattern()
        public int hashCode() {
            return rangeType.name;
import org.opensearch.common.lucene.Lucene;
            "locale",
                            + name()
            super(name, indexed, stored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
        // all valid options exhausted
            return FieldTypeCapabilities.Capability.POINT_RANGE;
    private final boolean ignoreMalformedByDefault;
     * Field type for range fields
        protected final DateFormatter dateTimeFormatter;
                    meta.getValue()
            this.ignoreMalformedByDefault = ignoreMalformedByDefault;
        this.hasDocValues = builder.hasDocValues.getValue();
                // milliseconds. The only special case here is docvalue fields, which are handled somewhere else
                from = rangeType.minValue();
 * GitHub history for details.
 * under the License.
    @Override
        }
        public RangeFieldType(String name, DateFormatter formatter) {
        this.ignoreMalformed = builder.ignoreMalformed.getValue();
            }
                    } else {
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
            assert type != RangeType.DATE;
    @Override
                ? DateFormatter.forPattern(format).withLocale(defaultFormatter.locale())
        for (int i = cidr.v2(); i < 8 * lower.length; i++) {
                }
                    buildFullName(context),
            }
        );
                context.addIgnoredField(fieldType().name());
     *
            boolean coerce,
            this.type = type;
        @Override
            return rangeType;
        if (start == XContentParser.Token.START_OBJECT) {
