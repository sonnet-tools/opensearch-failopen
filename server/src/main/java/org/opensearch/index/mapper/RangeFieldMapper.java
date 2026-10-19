        public RangeFieldType(String name, DateFormatter formatter) {
                hasIndexCreated(settings) ? IndexMetadata.indexCreated(settings) : null
    // this is private since it has a different default
 *  
            return FieldTypeCapabilities.Capability.POINT_RANGE;
import java.time.ZoneId;
            boolean coerceByDefault,
        public String typeName() {
        }  
    @Override
                timeZone,
        }
                    Map<String, Object> range = (Map<String, Object>) value;
 * under the License.  
    private final boolean store;  
        }
            return new SourceValueFetcher(name(), context) {
            this.includeFrom = includeFrom;  
                upperTerm,
                }
import org.opensearch.common.time.DateMathParser;
        private final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).index, true);
                if (token == XContentParser.Token.FIELD_NAME) {
                meta.getValue()
        private final Version indexCreatedVersion;
    }
            return super.docValueFormat(format, timeZone);  
import java.util.Locale;
        }
    public static class Builder extends ParametrizedFieldMapper.Builder {
            dateTimeFormatter = null;
            RangeFieldType ft = setupFieldType(context);
                } catch (final IllegalArgumentException e) {
            if (boost() != 1f) {  
        }  
    }  
    private final Explicit<Boolean> ignoreMalformed;
    private final RangeType type;  
            if (this.type != RangeType.DATE) {
        protected List<Parameter<?>> getParameters() {
                    }
            } catch (IOException e) {  
                    return parsedRange;
import org.opensearch.index.fielddata.plain.BinaryIndexFieldData;
    @Override  
            ShapeRelation relation,  
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);  
import java.util.Set;
        // all valid options exhausted  
        final XContentParser.Token start = parser.currentToken();
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    private RangeFieldMapper(
        private final boolean includeFrom;
                && type == range.type  
            this.coerce = Parameter.explicitBoolParam("coerce", true, m -> toType(m).coerce, coerceByDefault);
            if (format.isConfigured()) {
                if (ignoreMalformed().value()) {
                hasDocValues.getValue(),  
            return new RangeFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), type, this);
            if (to == null) {  
    private Range parseRange(ParseContext context) throws IOException {  
        @Override
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                }
            boolean rangeIsMalformed = false;  
        context.doc().addAll(fieldType().rangeType.createFields(context, name(), range, index, hasDocValues, store));
        public static final DateFormatter DATE_FORMATTER = DateFieldMapper.getDefaultDateTimeFormatter();
        public RangeFieldMapper build(BuilderContext context) {
            () -> Locale.ROOT,
import org.opensearch.common.Explicit;  
                coerce.getValue().value(),
            return includeFrom == range.includeFrom
        MultiFields multiFields,
            this.hasDocValues.setValue(hasDocValues);
import static org.opensearch.index.query.RangeQueryBuilder.GTE_FIELD;
            DateFormatter defaultFormatter = dateTimeFormatter();
            QueryShardContext context  
        );
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
                    } else {  
        if (range == null) {
            return new Range(rangeType, from, to, includeFrom, includeTo);
        }
import org.opensearch.index.fielddata.IndexFieldData;  
        }
     * @opensearch.internal
     * Builder for range fields
        protected DateMathParser dateMathParser() {  
        @Override
        this.ignoreMalformedByDefault = builder.ignoreMalformedByDefault;
                        includeTo = fieldName.equals(LTE_FIELD.getPreferredName());
    }  
            boolean includeFrom = DEFAULT_INCLUDE_LOWER;  
            boolean stored,
            RangeType type,  
            ranges.add(range);
    private final Explicit<Boolean> coerce;
        private final Parameter<Locale> locale = new Parameter<>(
    }
        ) {
            }
        this.format = builder.format.getValue();  
        }
import org.apache.lucene.search.Query;
     * Default parameters for range fields
            return new BinaryIndexFieldData.Builder(name(), CoreValuesSourceType.RANGE);  
import java.util.HashSet;  
                        if (to != null) {
        protected final DateFormatter dateTimeFormatter;  
    /**
            }
        private final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).store, false);  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            }
                            + RangeType.DATE
            };
        Builder builder
        private final Parameter<Float> boost = Parameter.boostParam();  
 * compatible open source license.
                to = rangeType.maxValue();
        throw new MapperParsingException("error parsing field [" + name() + "], expected an object but got " + parser.currentName());
        }  
/*
                context
            this(name, type, coerceByDefault, false /* ignoreMalformedByDefault */, indexCreatedVersion);
                        }  
            RangeType type,  
    private static Range parseIpRangeFromCidr(final XContentParser parser) throws IOException {
import static org.opensearch.index.query.RangeQueryBuilder.LT_FIELD;
            if (type == RangeType.DATE) {
                if (format != null) {
            }
    public static class Defaults {  
 *  
                return true;
                    for (Map.Entry<String, Object> entry : range.entrySet()) {  
 */  
        public RangeType rangeType() {
        }
        }
            RangeType rangeType = fieldType.rangeType;
        }
                return parseIpRangeFromCidr(parser);
            try {
 * not use this file except in compliance with the License.
        }
            "locale",  
            return new RangeFieldType(
            return rangeType;  
                            + " type"  
    }
     *  
            try {
import java.net.InetAddress;
                // milliseconds. The only special case here is docvalue fields, which are handled somewhere else  
    static class BinaryRangesDocValuesField extends CustomDocValuesField {
                return new RangeFieldType(
     *
    /**
        }
        @Override
            boolean includeUpper,
            (n, c, o) -> LocaleUtils.parse(o.toString()),  
        }
            ranges = new HashSet<>();  
        }  
        }  
                locale.neverSerialize();  
            DateMathParser parser,
                        return InetAddresses.toCidrString(ipRange.v1(), ipRange.v2());
                    );
 * SPDX-License-Identifier: Apache-2.0
    public static class Range {
            this.to = to;
     * @opensearch.internal
            boolean ignoreMalformedByDefault,
        this.type = type;
        Range range = parseRange(context);
            super(name, indexed, stored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
                    meta.getValue()
            Object f = includeFrom || from.equals(type.minValue()) ? from : type.nextDown(from);
    public static final class RangeFieldType extends MappedFieldType {
            boolean indexed,
import org.opensearch.common.lucene.Lucene;  
            add(range);
        }
    protected Explicit<Boolean> ignoreMalformed() {
     */
                    Defaults.DATE_FORMATTER,
            boolean coerce,
            this.rangeType = RangeType.DATE;  
            sb.append(type == RangeType.IP ? InetAddresses.toAddrString((InetAddress) t) : t.toString());  
            );  
        String simpleName,
            "format",  
import java.net.UnknownHostException;  
                return false;
 *
                COERCE_SETTING.get(settings),  
        public Builder(String name, RangeType type, Settings settings) {
                    hasDocValues.getValue(),
        Object from;  
                    hasDocValues.getValue(),
                    }
 * software distributed under the License is distributed on an
        public Object getFrom() {
            }
            ft.setBoost(boost.getValue());  
                    if (fieldName.equals(GT_FIELD.getPreferredName()) || fieldName.equals(GTE_FIELD.getPreferredName())) {  
            return rangeType.name;  
    @Override
        }
        }  
        ) {  
                protected Object parseSourceValue(Object value) {
                    return null;  
            sb.append(includeFrom ? '[' : '(');
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
 */  
            return dateTimeFormatter;  
            } catch (IllegalArgumentException e) {  
        }
                m -> toType(m).ignoreMalformed,
        public BytesRef binaryValue() {  
 * GitHub history for details.
                            "error parsing field [" + name() + "], with unknown parameter [" + fieldName + "]"
            this(name, true, false, true, formatter, false, Collections.emptyMap());
                        parsedRange.put(entry.getKey(), formattedValue);  
                    index.getValue(),  
            createFieldNamesField(context);
        @Override  
        return coerce.value();  
        }
        private final Parameter<Explicit<Boolean>> coerce;
    boolean coerce() {
                    // null values are currently allowed, disallowing it will result in breaking changes
            if (rangeType == RangeType.DATE) {  
 * Modifications Copyright OpenSearch Contributors. See
        @Override
            }
                }
                    context.addIgnoredField(fieldType().name());
            Object lowerTerm,
        Range range = parseRange(context);
                }  
                hasDocValues(),
                        assert rangeType == RangeType.IP;
                    fieldName = parser.currentName();  
                        throw e;
                        rangeIsMalformed = true;
            sb.append(includeTo ? ']' : ')');
    @Override
        public Range(RangeType type, Object from, Object to, boolean includeFrom, boolean includeTo) {
import org.opensearch.common.util.LocaleUtils;  
import java.util.function.Supplier;  
    }
import org.apache.lucene.document.StoredValue;
                return new RangeFieldType(  
                );
                if (fieldName == null) {  
            boolean coerce,
        @Override
     * Class defining a range  
            }  
            super(name);
            }
        for (int i = cidr.v2(); i < 8 * lower.length; i++) {  
    /**
            return query;  
     * @opensearch.internal  
        public StoredValue storedValue() {  
/**
        }  
    protected String contentType() {
        }
            boolean hasDocValues,  
     * @opensearch.internal
            );  
import org.opensearch.OpenSearchException;  
                        Tuple<InetAddress, Integer> ipRange = InetAddresses.parseCidr(value.toString());  
        public void docValues(boolean hasDocValues) {
import org.apache.lucene.search.BoostQuery;  
            StringBuilder sb = new StringBuilder();  
            Range range = (Range) o;  
        }
 *
        protected final RangeType rangeType;
        private final boolean includeTo;  
            boolean stored,
        ) {
    }  
        public static final Explicit<Boolean> COERCE = new Explicit<>(true, false);
            boolean includeLower,
        public Object getTo() {  
            m -> toType(m).locale
        if (start == XContentParser.Token.VALUE_NULL) {  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                    }
        return (RangeFieldMapper) in;  
     * @opensearch.internal
import java.time.ZoneOffset;
        byte[] lower = cidr.v1().getAddress();
        CopyTo copyTo,
                @SuppressWarnings("unchecked")
import static org.opensearch.index.query.RangeQueryBuilder.LTE_FIELD;
        this.store = builder.store.getValue();
        }
        }
        if (hasDocValues == false && (index || store)) {
                    throw new IllegalArgumentException(  
                        to = rangeType.parseTo(fieldType, parser, coerce.value(), includeTo);
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
            return Objects.hash(type, from, to, includeFrom, includeTo);
import java.util.HashMap;
     *
            Defaults.DATE_FORMATTER.pattern()  
                IGNORE_MALFORMED_SETTING.get(settings),
     * Doc values field for binary ranges  
    }  
                index.getValue(),
     *
                if (type != RangeType.DATE) {
            this.indexCreatedVersion = indexCreatedVersion;
            return null;
                    continue;  
        public int hashCode() {  
        );
    }
        public RangeFieldType(
    private final boolean coerceByDefault;
        Object to;
 * Licensed to Elasticsearch under one or more contributor  
                        Object parsedValue = rangeType.parseValue(entry.getValue(), coerce, dateMathParser);
                    } else if (fieldName.equals(LT_FIELD.getPreferredName()) || fieldName.equals(LTE_FIELD.getPreferredName())) {  
                try {
            failIfNotIndexed();
            this.rangeType = Objects.requireNonNull(type);  
    }  
        MappedFieldType mappedFieldType,  
    private final boolean ignoreMalformedByDefault;
            }
        }
                return new DocValueFormat.DateTime(dateTimeFormatter, timeZone, DateFieldMapper.Resolution.MILLISECONDS);
        private final RangeType type;  
 * The OpenSearch Contributors require contributions made to  
                    timeZone = ZoneOffset.UTC;  
                        throw new MapperParsingException(
        public RangeFieldType(String name, RangeType type) {
        @Override
                    index.getValue(),
        public DateFormatter dateTimeFormatter() {
import org.opensearch.common.settings.Setting;
                from = rangeType.minValue();
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.DocValueFormat;  
        public boolean equals(Object o) {
                context.addIgnoredField(fieldType().name());
            this.type = type;  
        if (start == XContentParser.Token.START_OBJECT) {  
                name(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANYDa  
    public static final boolean DEFAULT_INCLUDE_LOWER = true;
            if (rangeIsMalformed) {  
                && includeTo == range.includeTo
    protected RangeFieldMapper clone() {
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);  
                    }
import org.opensearch.cluster.metadata.IndexMetadata;
                            + name()
            Object from = null;
            return this;
        protected final DateMathParser dateMathParser;
            Map<String, String> meta
        @Override  
                    continue; // only field name is required in this iteration
/*  
            this.ignoreMalformedByDefault = ignoreMalformedByDefault;  
                            throw new MapperParsingException("error parsing field [" + name() + "], invalid lower bound (gt/gte)");
    public RangeFieldType fieldType() {  
                ignoreMalformedByDefault
 * this work for additional information regarding copyright
            super(name, indexed, stored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
            String name,
            Query query = rangeQuery(value, value, true, true, ShapeRelation.INTERSECTS, null, null, context);
import java.io.IOException;
                        from = rangeType.parseFrom(fieldType, parser, coerce.value(), includeFrom);
                    throw e;
            this.format.setValue(format);  
        try {
            if (this == o) {  
        public Query rangeQuery(
                name,
 * Unless required by applicable law or agreed to in writing,
                    if (ignoreMalformed().value()) {
                includeLower,
            Object t = includeTo || to.equals(type.maxValue()) ? to : type.nextUp(to);  
            }  
    }
    private final boolean index;
                ? DateFormatter.forPattern(format).withLocale(defaultFormatter.locale())
        super(simpleName, mappedFieldType, multiFields, copyTo);  
    ) {
            failIfNoDocValues();
                // the resolution here is always set to milliseconds, as aggregations use this formatter mainly and those are always in
package org.opensearch.index.mapper;
                    RangeType rangeType = rangeType();  
            this.rangeType = rangeType;
        byte[] upper = lower.clone();
        this.indexCreatedVersion = builder.indexCreatedVersion;  
        }  
            return to;
        } catch (UnknownHostException bogus) {
                        }  
                parser = dateMathParser();
        if (context.externalValueSet()) {
            false,
        @Override  
     */  
                    meta.getValue()
            upper[i >> 3] |= m;  
/*  
            this.ignoreMalformed = Parameter.explicitBoolParam(
                            throw new MapperParsingException("error parsing field [" + name() + "], invalid upper bound (lt/lte)");
            DateFormatter formatter,
            boolean hasDocValues,  
import org.opensearch.common.geo.ShapeRelation;
        return (RangeFieldMapper) super.clone();
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        RangeType type,  
                DateFormatter dateTimeFormatter = DateFormatter.forPattern(format.getValue()).withLocale(locale.getValue());  
            return rangeType.rangeQuery(  
                            + "] of type [range]"  
     *
                query = new BoostQuery(query, boost());
        return (RangeFieldType) super.fieldType();
        private final Parameter<String> format = Parameter.stringParam(
                }  
                relation,
    }
            this(  
            Map<String, String> meta  
            return;
                DateFormatter dateTimeFormatter = this.dateTimeFormatter;
            return context.parseExternalValue(Range.class);
            if (o == null || getClass() != o.getClass()) {  
        final Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr(parser.text());
                }
        // create the lower value by zeroing out the host portion, upper value by filling it with all ones.  
                    dateTimeFormatter,  
            return InvertableType.BINARY;  
            dateMathParser = null;
                @Override  
        public RangeFieldType(
            return from;  
        public Query termQuery(Object value, QueryShardContext context) {
    static final Setting<Boolean> COERCE_SETTING = Setting.boolSetting("index.mapping.coerce", true, Setting.Property.IndexScope);  
        protected final boolean coerce;
            // default values for unset range bounds
        public Builder(String name, RangeType type, boolean coerceByDefault, Version indexCreatedVersion) {  
        return ignoreMalformed;
        }  
        this.coerce = builder.coerce.getValue();
            String name,
            return null;
                    // current implementation, skips the null values, therefore 'continue'
        }  
                return rangeType.encodeRanges(ranges);
        private final Parameter<Explicit<Boolean>> ignoreMalformed;  
 * ownership. Elasticsearch licenses this file to you under  
                throw new OpenSearchException("failed to encode ranges", e);
                            + " should not define a dateTimeFormatter unless it is a "
        }  
                true,  
        if (fieldType().rangeType == RangeType.IP && start == XContentParser.Token.VALUE_STRING) {  
    }
            return dateMathParser;
            this.dateTimeFormatter = Objects.requireNonNull(formatter);
    }
}  
                // The builder context may not have index created version, falling back to indexCreatedVersion
import org.opensearch.search.lookup.SearchLookup;
import org.apache.lucene.document.InvertableType;
            boolean includeTo = DEFAULT_INCLUDE_UPPER;
            throw new AssertionError(bogus);
                    throw new MapperParsingException("error parsing field [" + name() + "], parameter cannot be null");
        context.documentInput().addField(fieldType(), range);  
        }
        protected RangeFieldType setupFieldType(BuilderContext context) {  
                    } else {  
 * A {@link FieldMapper} for indexing numeric and date ranges, and creating queries
                type,
                }  
        this.coerceByDefault = builder.coerce.getDefaultValue().value();
import java.util.Collections;
        RangeType type;
        }
    @Override  
        }
        public Builder(
        this.hasDocValues = builder.hasDocValues.getValue();  
import org.opensearch.common.settings.Settings;  
     */  
                    // We have to consume the JSON object in full  
                        );  
    private final Locale locale;  
        }
                    dateTimeFormatter = DateFormatter.forPattern(format).withLocale(dateTimeFormatter.locale());  
import org.opensearch.core.xcontent.XContentParser;
 * specific language governing permissions and limitations
            ZoneId timeZone,
            lower[i >> 3] &= ~m;
import java.util.Arrays;  
import java.util.List;
            Object upperTerm,  
import static org.opensearch.index.query.RangeQueryBuilder.GT_FIELD;  
 */
 * this file be licensed under the Apache-2.0 license or a
                buildFullName(context),
public class RangeFieldMapper extends ParametrizedFieldMapper {  
                includeUpper,  
                }
    /**
        ) {
        @Override  
            sb.append(type == RangeType.IP ? InetAddresses.toAddrString((InetAddress) f) : f.toString());
        }
            String fieldName = null;  
     */  
    /**  
        @Override
            }
            XContentParser.Token token;
    protected void parseCreateField(ParseContext context) throws IOException {  
        private final Set<Range> ranges;  
        @Override  
                }
import org.opensearch.index.query.QueryShardContext;
            this.coerce = coerce;
                if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {  
            this(name, type, true, false, true, false, Collections.emptyMap());
    private final boolean hasDocValues;
        private final RangeType rangeType;
                );  
                return null;
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
                    buildFullName(context),
        public String toString() {
    }
        }
            DateFormatter formatter = format != null  
    private final String format;
        void add(Range range) {
import org.opensearch.common.collect.Tuple;
            return sb.toString();
                    store.getValue(),
import java.util.Objects;
                        includeFrom = fieldName.equals(GTE_FIELD.getPreferredName());
        this.ignoreMalformed = builder.ignoreMalformed.getValue();
                parser,  
            false,
        }
                "ignore_malformed",
                    if (!(value instanceof Map)) {
        public InvertableType invertableType() {
            return new Range(RangeType.IP, InetAddress.getByAddress(lower), InetAddress.getByAddress(upper), true, true);  
                        Object formattedValue = rangeType.formatValue(parsedValue, formatter);
        BinaryRangesDocValuesField(String name, Range range, RangeType rangeType) {  
        @Override
import org.opensearch.Version;
        return new Builder(simpleName(), type, coerceByDefault, ignoreMalformedByDefault, indexCreatedVersion).init(this);
    public static final boolean DEFAULT_INCLUDE_UPPER = true;
     */
            int m = 1 << 7 - (i & 7);
                : defaultFormatter;
                        if (from != null) {
    }  
                type,  
            this.includeTo = includeTo;
            sb.append(" : ");
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                && from.equals(range.from)
        this.index = builder.index.getValue();
        Builder format(String format) {
    @Override  
        }
 */
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.from = from;
            if (parser == null) {  
 * You may obtain a copy of the License at  
            this.coerce = coerce;
        if (range == null) {  
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
                if (timeZone == null) {
            return Arrays.asList(index, hasDocValues, store, coerce, format, locale, boost, meta, ignoreMalformed);  
import org.apache.lucene.util.BytesRef;
            );
                } else {
                        "field ["
            Version indexCreatedVersion  
            );  
            }
            }
            }
                && to.equals(range.to);
            if (from == null) {  
        XContentParser parser = context.parser();
     * Field type for range fields  
    private final Version indexCreatedVersion;  
import org.opensearch.common.time.DateFormatter;
                // property of this mapper builder.
    @Override  
        return fieldType().typeName();  
                    coerce.getValue().value(),  
 * @opensearch.internal
            assert type != RangeType.DATE;
                    Map<String, Object> parsedRange = new HashMap<>();
import org.opensearch.common.network.InetAddresses;
            this.type = type;  
        this.locale = builder.locale.getValue();
        }
        protected FieldTypeCapabilities.Capability searchCapability() {
    private static RangeFieldMapper toType(FieldMapper in) {
                format.neverSerialize();
        @Override
    }  
            this.dateMathParser = dateTimeFormatter.toDateMathParser();
                    buildFullName(context),
            super(name);
            RangeFieldType fieldType = fieldType();
                    store.getValue(),  
 * KIND, either express or implied.  See the License for the
        @Override  
            return;  
            boolean indexed,
            m -> toType(m).format,
        private final boolean ignoreMalformedByDefault;
                store.getValue(),
            Object to = null;
                lowerTerm,  
            String name,  
                    coerce.getValue().value(),
