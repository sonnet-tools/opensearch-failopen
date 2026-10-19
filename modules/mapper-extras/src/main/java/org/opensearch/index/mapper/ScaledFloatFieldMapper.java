            }
import org.opensearch.common.xcontent.support.XContentMapValues;
            return FieldData.castToLong(getDoubleValues());
    }
            } else {
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            }
                        return values.advanceExact(target);
            boolean hasDocValues,
         * Parses input value and multiplies it with the scaling factor.
            Map<String, String> meta,
            ScaledFloatFieldType type = new ScaledFloatFieldType(
            this(name, true, false, true, false, Collections.emptyMap(), scalingFactor, null);
     * 1. If it has doc values, build source using doc values
                    @Override
                meta.getValue(),
            /*
    }
        if (value instanceof Number number) {
    private Long parseScaledValue(ParseContext context) throws IOException {
            "scaling_factor",
        private final IndexNumericFieldData scaledFieldData;
        }
            return new DocValueFetcher.Leaf() {
        return (ScaledFloatFieldMapper) in;
     *       both doc values and stored field
            false,
            double doubleValue = (Double) value;
                context
            return point;
import org.opensearch.index.fielddata.ScriptDocValues;
        ).acceptsNull();
    private static Double parse(XContentParser parser, boolean coerce) throws IOException {
 * software distributed under the License is distributed on an
        }
            (n, c, o) -> XContentMapValues.nodeBooleanValue(o),
    protected void parseCreateField(ParseContext context) throws IOException {
            }
        }
import org.apache.lucene.index.DocValues;
        @Override
 * by a scaling factor and rounded to the closest long.
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
        public double getScalingFactor() {
            numericValue = parse(value);
        private final LeafNumericFieldData scaledFieldData;
         * floating-point imprecision (e.g., 79.99 * 100 = 7998.999...),
        public ScaledFloatFieldType(String name, double scalingFactor) {
            List<Long> scaledValues = new ArrayList<>(values.size());
            return Optional.of(DimensionType.NUMERIC);
                query = new BoostQuery(query, boost());
package org.opensearch.index.mapper;
        String simpleName,
            if (singleValues != null) {
        public NumericType getNumericType() {
            if (boost() != 1f) {
    }
        return new Builder(simpleName(), ignoreMalformedByDefault, coerceByDefault).init(this);
            value = numericValue;
 * license agreements. See the NOTICE file distributed with
        }
                includeUpper,
        public Builder(String name, Settings settings) {
    @Override
import org.opensearch.index.fielddata.IndexNumericFieldData;
        this.hasDocValues = builder.hasDocValues.getValue();
                        return values.nextValue() * scalingFactorInverse;
        context.documentInput().addField(fieldType(), scaledValue);
    }
import org.apache.lucene.index.NumericDocValues;
    }
            (n, c, o) -> XContentMapValues.nodeDoubleValue(o),
     *    2. There might be precision loss as values are stored as long after multiplying it with "scaling_factor" for
            stored
        public Object valueForDisplay(Object value) {
            () -> null,
                }
            } else if (doubleValue == Double.NEGATIVE_INFINITY) {
            if (v == null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        Builder builder
        @Override
                    scaledValue = scaledValue + 1;
                    double doubleValue;
                    }
     * <p>
            createFieldNamesField(context);
            if (timeZone != null) {
                    if (value.equals("")) {
            double scalingFactor,
        }
 * KIND, either express or implied.  See the License for the
            } else {
    }
                    return values.advanceExact(docId);
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                final IndexNumericFieldData scaledValues = new SortedNumericIndexFieldData.Builder(
            byte[] point = new byte[Long.BYTES];
        }
    @Override
            hasDocValues,
            this.nullValue.setValue(nullValue);
 */
                        doubleValue = objectToDouble(value);
            }
                @Override
            return this;
        public LeafNumericFieldData load(LeafReaderContext context) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
        ) {
        public SortedNumericDoubleValues getDoubleValues() {
            m -> toType(m).nullValue
 * The OpenSearch Contributors require contributions made to
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
            this.coerce = Parameter.explicitBoolParam("coerce", true, m -> toType(m).coerce, coerceByDefault);
        public double toDoubleValue(long value) {
        if (hasDocValues == false && (indexed || stored)) {
                LongPoint.encodeDimension(Long.MAX_VALUE, point, 0);
            this.nullValue = nullValue;
        @Override
            String name,
        @Override
        private double scale(Object input) {
        XContentParser parser = context.parser();
                    } else {
            }
        } else {
            return FieldTypeCapabilities.Capability.POINT_RANGE;
                hasDocValues(),
        );
        }
import org.apache.lucene.index.LeafReaderContext;
            fieldType().name(),
        public long ramBytesUsed() {
        private final boolean skiplist;
 * compatible open source license.
            return parse(input) * scalingFactor;
    protected void canDeriveSourceInternal() {
    }
        return Math.round(doubleValue * scalingFactor);
                return DocValueFormat.RAW;
 * this work for additional information regarding copyright
        @Override
        return (ScaledFloatFieldMapper) super.clone();
                        if (nullValue == null) {
        private final Parameter<Boolean> skiplist = new Parameter<>(
                        return values.docValueCount();
                        doubleValue = nullValue;
            return new ScaledFloatLeafFieldData(scaledFieldData.loadDirect(context), scalingFactor);
import org.apache.lucene.search.BoostQuery;
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
            m -> toType(m).scalingFactor
                    public boolean advanceExact(int target) throws IOException {
        }
        if (numericValue == null) {
            mappedFieldType,
import java.io.IOException;
            }
            if (value == null) {
                @Override
        }
        @Override
        @Override
        ScaledFloatLeafFieldData(LeafNumericFieldData scaledFieldData, double scalingFactor) {
                    double scalingFactor = getScalingFactor();
        }
    boolean coerce() {
import org.opensearch.common.Explicit;
                LongPoint.encodeDimension(Math.round(scale(value)), point, 0);
            }
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());
             * We need to use a custom comparator because the non-custom
            long scaledValue = Math.round(scale(value));
                return null;
        }
            return new ScaledFloatLeafFieldData(scaledFieldData.load(context), scalingFactor);
    }
            return query;
                );
            };
    }
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
    private final Double nullValue;
            boolean stored,
            return scaledFieldData.getValuesSourceType();
            }
    }
        }
        }
        private final Parameter<Double> nullValue = new Parameter<>(
         * @return Scaled value
    private ScaledFloatFieldMapper(
        public SortedNumericDocValues getLongValues() {
            () -> false,
            );
                if (scaledValue < Long.MAX_VALUE) {
                @Override
                }
            this.scaledFieldData = scaledFieldData;
            super(name);
                    @Override
        }
                hi = Math.round(scale(upperTerm));
        }
import org.opensearch.index.fielddata.IndexFieldData;
                isSearchable(),
    /**
                    public boolean advanceExact(int doc) throws IOException {
            false,
            /*
    @Override
        }
    @Override
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);
        MultiFields multiFields,
        @Override
            // TODO: enable skiplist by default
        private final double scalingFactor;
            return (cache, breakerService) -> {
            () -> null,
    private static ScaledFloatFieldMapper toType(FieldMapper in) {
                            return null;
                    throw e;
        @Override
            }
        private final Parameter<Double> scalingFactor = new Parameter<>(
                public Object nextValue() throws IOException {
    private final Explicit<Boolean> ignoreMalformed;
        /** Still searchable from doc values when the index uses a pluggable data format. */
            return;
        }
             * comparator wouldn't properly decode the long bits into the
    protected DerivedFieldGenerator derivedFieldGenerator() {
import org.opensearch.search.lookup.SearchLookup;
             * docs in order. We just don't have a way to convert the long
        public byte[] encodePoint(Object value, boolean roundUp) {
        }
        public void close() {
            return;
    protected String contentType() {
        this.scalingFactor = builder.scalingFactor.getValue();
            "null_value",
    }
            } else {
                return null;
            this.scalingFactor = scalingFactor;
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());
import org.opensearch.index.query.QueryShardContext;
     * Considerations:
        @Override
        }
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"
                    }
         * the consistent behavior ensures search queries work correctly.
             * {@link ScaledFloatLeafFieldData#getDoubleValues()} transforms the raw long values in `scaled` floats.
        @Override
                isSearchable()
        }
            this.scalingFactor.setValue(scalingFactor);
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.getSettings()));
                lo,
        }
             */
                query = new BoostQuery(query, boost());
            this(name, IGNORE_MALFORMED_SETTING.get(settings), COERCE_SETTING.get(settings));
import org.opensearch.core.xcontent.XContentParser;
    private final boolean ignoreMalformedByDefault;
        @Override
                throw new IllegalArgumentException("[scaled_float] only supports finite values, but got [" + doubleValue + "]");
import org.apache.lucene.document.Field;
        @Override
        Builder nullValue(double nullValue) {
        );
import org.apache.lucene.document.LongPoint;
            failIfNotIndexedAndNoDocValues();
            );
        );
                    }
import org.opensearch.index.compositeindex.datacube.DimensionType;
        protected List<Parameter<?>> getParameters() {
 * not use this file except in compliance with the License.
 *
                lo = Math.round(scale(lowerTerm));
        return doubleValue;
 * GitHub history for details.
    @Override
 */
        } else if (value instanceof BytesRef bytesRef) {
                true,
        @Override
            }
        }
        }
            if (doubleValue == Double.POSITIVE_INFINITY) {
        }
    }
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
        private final Double nullValue;
    private static final Setting<Boolean> COERCE_SETTING = NumberFieldMapper.COERCE_SETTING;
     */
         *
    }
import org.opensearch.index.IndexSettings;
            if (boost() != 1f) {
import org.apache.lucene.search.Query;
            return null;
                });
    @Override
        }
            if (format == null) {
        return parser.doubleValue(coerce);
        Long scaledValue = parseScaledValue(context);
            long scaledValue = Math.round(scale(value));
                };
        }
import org.opensearch.search.DocValueFormat;
        public ScaledFloatFieldType(
            if (boost() != 1f) {
import java.util.List;
        public Query termQuery(Object value, QueryShardContext context) {
            doubleValue = Double.parseDouble(value.toString());
    private final boolean indexed;
                hasDocValues.getValue(),
 * Licensed to Elasticsearch under one or more contributor
            final SortedNumericDocValues values = scaledFieldData.getLongValues();
            failIfNotIndexedAndNoDocValues();
        private final double scalingFactorInverse;
            return Arrays.asList(indexed, hasDocValues, stored, ignoreMalformed, meta, scalingFactor, coerce, nullValue, skiplist);
                        }
                    }
            Query query = NumberFieldMapper.NumberType.LONG.rangeQuery(
            byte[] point = new byte[Long.BYTES];
            Long lo = null;
import java.util.function.Supplier;
        }
            super(name, indexed, stored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
            };
            }
/** A {@link FieldMapper} for scaled floats. Values are internally multiplied
        }
            double inverseScalingFactor = 1d / scalingFactor;
    ) {
        }
        if (scaledValue == null) {
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
            return ((Number) value).longValue() / scalingFactor;
        private final Parameter<Explicit<Boolean>> ignoreMalformed;
                } else {
        @Override
        }
            return FieldData.toString(getDoubleValues());
        CopyTo copyTo,
                name(),
            if (format != null) {
        this.coerceByDefault = builder.coerce.getDefaultValue().value();
        this.skiplist = builder.skiplist.getValue();
        @Override
    @Override
        public LeafNumericFieldData loadDirect(LeafReaderContext context) throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            this.scalingFactorInverse = 1d / scalingFactor;
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            assert value instanceof Double;
        this.stored = builder.stored.getValue();
        @Override
            (n, c, o) -> o == null ? null : XContentMapValues.nodeDoubleValue(o),
        ).setValidator(v -> {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            return new SourceValueFetcher(name(), context) {
        }
     *    1. When using doc values, for multi value field, result would be in sorted order
import java.util.Collections;
 * specific language governing permissions and limitations
        public ScriptDocValues.Doubles getScriptValues() {
    public static final class ScaledFloatFieldType extends SimpleMappedFieldType implements NumericPointEncoder, FieldValueConverter {
            m -> toType(m).skiplist
        }
    private static class ScaledFloatIndexFieldData extends IndexNumericFieldData {
                public boolean advanceExact(int docId) throws IOException {
            }
        }
        ScaledFloatFieldType mappedFieldType,
        public ValuesSourceType getValuesSourceType() {
        this.indexed = builder.indexed.getValue();
        if (context.externalValueSet()) {
                    return format.format(values.nextValue());
    /**
        }
        checkStoredAndDocValuesForDerivedSource();
        return (ScaledFloatFieldType) super.fieldType();
         * @param input Input value to parse floating point num from
            indexed,
                throw new IllegalArgumentException(
        }
     */
                m -> toType(m).ignoreMalformed,
     * 2. If doc_values is disabled in field mapping, then build source using stored field
        } else {
            Query query = NumberFieldMapper.NumberType.LONG.termsQuery(
/*
        if (Double.isFinite(doubleValue) == false) {
                includeLower,
        }
            final NumericDocValues singleValues = DocValues.unwrapSingleton(values);
            scaledValue,
        @Override
    private final Explicit<Boolean> coerce;
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                // since we encode to a long, we have no way to carry NaNs and infinities
    private final boolean stored;
        public DocValueFetcher.Leaf getLeafValueFetcher(DocValueFormat format) {
                numericValue = parse(parser, coerce.value());
                public int docValueCount() throws IOException {
        }
 * Unless required by applicable law or agreed to in writing,
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
public class ScaledFloatFieldMapper extends ParametrizedFieldMapper {
        }
            try {
            boolean indexed,
                    @Override
import org.opensearch.common.settings.Settings;
                }
            this.scalingFactor = scalingFactor;
         * Note: Uses direct floating-point multiplication for consistency
        @Override
 * under the License.
    private final boolean coerceByDefault;
                Collections.unmodifiableList(scaledValues),
        return objectToDouble(value);
import org.opensearch.index.fielddata.NumericDoubleValues;
        public Query termsQuery(List<?> values, QueryShardContext context) {
                if (ignoreMalformed.value()) {
            return scaledFieldData.ramBytesUsed();
                    public double nextValue() throws IOException {
            return new ScaledFloatFieldMapper(name, type, multiFieldsBuilder.build(this, context), copyTo.build(), this);
            failIfNotIndexedAndNoDocValues();
            Double nullValue
         * between indexing and querying. While this may result in
                hasDocValues(),
             * double. Sorting on the long representation *would* put the
        } else if (parser.currentToken() == Token.VALUE_NULL) {
            if (Double.isFinite(v) == false || v <= 0) {
        }
    }
            new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()),
        @Override
        @Override
                    }
                scaledValues.add(scaledValue);
    }
                hi,
import org.apache.lucene.util.BytesRef;
            if (ignoreMalformed.value()) {
            boolean skiplist,
 * this file be licensed under the Apache-2.0 license or a
    private final boolean hasDocValues;
        }
        public String typeName() {
/*
            this.scaledFieldData = scaledFieldData;
        return new DerivedFieldGenerator(
                "ignore_malformed",
            } else {
            this.ignoreMalformed = Parameter.explicitBoolParam(
                return new SortedNumericDoubleValues() {
            failIfNoDocValues();
            Long hi = null;
            value = null;
        context.doc().addAll(fields);
     * Converts an Object to a double by checking it against known types first
            doubleValue = Double.parseDouble(bytesRef.utf8ToString());
        private final double scalingFactor;
             */
                name(),
                throw new IllegalArgumentException("[scaling_factor] must be a positive number, got [" + v + "]");
import java.util.Arrays;
                    }
            return new ScriptDocValues.Doubles(getDoubleValues());
            SortedNumericDoubleValues values = getDoubleValues();
    }
            }
                    public double doubleValue() throws IOException {
            }
                }
            return NumericType.DOUBLE;
                        return singleValues.longValue() * scalingFactorInverse;
                return FieldData.singleton(new NumericDoubleValues() {
import org.opensearch.core.xcontent.XContentParser.Token;
            false,
            return this;
                scalingFactor.getValue(),
                    public int docValueCount() {
    // use the same default as numbers
        /**
            return true;
            return scalingFactor;
        }
        List<Field> fields = NumberFieldMapper.NumberType.LONG.createFields(
                throw new IllegalArgumentException("Field [scaling_factor] is required");
                stored.getValue(),
                ignoreMalformedByDefault
                LongPoint.encodeDimension(Long.MIN_VALUE, point, 0);
            return point;
    private final double scalingFactor;
        if (value == null) {
            }
                }
        @Override
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        this.ignoreMalformed = builder.ignoreMalformed.getValue();
        }
        this.nullValue = builder.nullValue.getValue();
 *
 * You may obtain a copy of the License at
        }
            LongPoint.encodeDimension(scaledValue, point, 0);
        double doubleValue;
import java.util.Optional;
        }
            } catch (IllegalArgumentException | JsonParseException e) {
        return ignoreMalformed;
    private final boolean skiplist;
            value = context.externalValue();
    public static class Builder extends ParametrizedFieldMapper.Builder {
import org.opensearch.index.fielddata.FieldData;
                    scaledValue = scaledValue - 1;
        Object value;
    }
import java.util.Map;
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);
            if (lowerTerm != null) {
                return new DocValueFormat.Decimal(format);
        if (scaledValue == null) {
                if (scaledValue > Long.MIN_VALUE) {
                query = new BoostQuery(query, boost());
                long scaledValue = Math.round(scale(value));
            return query;
             * into a double the right way afterwords.
    }
            return value * inverseScalingFactor;
import org.opensearch.index.fielddata.LeafNumericFieldData;
        public String getFieldName() {
        double doubleValue = numericValue.doubleValue();
    protected Explicit<Boolean> ignoreMalformed() {
        public SortedBinaryDocValues getBytesValues() {
                    name(),
                    IndexNumericFieldData.NumericType.LONG
                return new ScaledFloatIndexFieldData(scaledValues, scalingFactor);
            this.skiplist = skiplist;
 */
 */
        return coerce.value();
        protected FieldTypeCapabilities.Capability searchCapability() {
            Query query = NumberFieldMapper.NumberType.LONG.termQuery(name(), scaledValue, hasDocValues(), isSearchable());
        }
        }
            doubleValue = number.doubleValue();
                    return null;
            }
        }
        ScaledFloatIndexFieldData(IndexNumericFieldData scaledFieldData, double scalingFactor) {
        @Override
    protected ScaledFloatFieldMapper clone() {
    }
                    return values.docValueCount();
        @Override
import java.util.ArrayList;
        Long scaledValue = parseScaledValue(context);
        private final Parameter<Explicit<Boolean>> coerce;
        @Override
         */
        @Override
    }
            );
 *
    private static double objectToDouble(Object value) {
        @Override
                @Override
            for (Object value : values) {
        } else if (coerce.value() && parser.currentToken() == Token.VALUE_STRING && parser.textLength() == 0) {
                nullValue.getValue()
    public ScaledFloatFieldType fieldType() {
    @Override
            value = null;
        @Override
    public static final String CONTENT_TYPE = "scaled_float";
        }
        return CONTENT_TYPE;
            return query;
 * Modifications Copyright OpenSearch Contributors. See
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);
            value = nullValue;
import org.opensearch.tools.jackson.core.JsonParseException;
        Builder scalingFactor(double scalingFactor) {
            new StoredFieldFetcher(mappedFieldType, simpleName())
        this.ignoreMalformedByDefault = builder.ignoreMalformed.getDefaultValue().value();
        @Override
                }
            };
import org.opensearch.common.settings.Setting;
                protected Double parseSourceValue(Object value) {
                }
        });
import org.opensearch.search.aggregations.support.ValuesSourceType;
        public Builder(String name, boolean ignoreMalformedByDefault, boolean coerceByDefault) {
                        return singleValues.advanceExact(doc);
            return true;
            return scaledFieldData.getFieldName();
        protected boolean sortRequiresCustomComparator() {
                indexed.getValue(),
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
            scaledFieldData.close();
            skiplist,
            if (upperTerm != null) {
            if (roundUp) {
}
        public boolean isDataCubeMetricSupported() {
import java.time.ZoneId;
        @Override
    private static class ScaledFloatLeafFieldData implements LeafNumericFieldData {
        public ScaledFloatFieldMapper build(BuilderContext context) {
        public byte[] encodePoint(Number value) {
                    @Override
            }
            } else {
        if (value == null) {
        }
                    return Math.round(doubleValue * scalingFactor) / scalingFactor;
                skiplist.getValue(),
    @Override
                    @Override
            return CONTENT_TYPE;
                ).build(cache, breakerService);
    static Double parse(Object value) {
import org.apache.lucene.index.SortedNumericDocValues;
                buildFullName(context),
            );
        Number numericValue = null;
            "skip_list",
        this.coerce = builder.coerce.getValue();
