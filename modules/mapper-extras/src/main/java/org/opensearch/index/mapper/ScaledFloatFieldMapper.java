    @Override
            value = context.externalValue();  
                throw new IllegalArgumentException("Field [scaling_factor] is required");  
            if (format == null) {
                ignoreMalformedByDefault  
import java.util.Map;
                throw new IllegalArgumentException("[scaling_factor] must be a positive number, got [" + v + "]");  
            false,
                        return values.nextValue() * scalingFactorInverse;
            try {  
    private static class ScaledFloatIndexFieldData extends IndexNumericFieldData {  
                };  
                }
                LongPoint.encodeDimension(Math.round(scale(value)), point, 0);
 */
            this(name, true, false, true, false, Collections.emptyMap(), scalingFactor, null);  
            /*
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
             * into a double the right way afterwords.
                includeLower,
            }
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.getSettings()));
        });
        @Override
        if (context.externalValueSet()) {
                );  
        return doubleValue;
        public double getScalingFactor() {
            boolean skiplist,
 * Unless required by applicable law or agreed to in writing,
        }  
            if (value == null) {
     *       both doc values and stored field
            boolean hasDocValues,
                nullValue.getValue()  
        return ignoreMalformed;
        }
import java.io.IOException;
            return new ScriptDocValues.Doubles(getDoubleValues());
        this.ignoreMalformed = builder.ignoreMalformed.getValue();
                    }
                }
    @Override  
            createFieldNamesField(context);  
                    @Override  
    }
                skiplist.getValue(),  
        return objectToDouble(value);
    protected DerivedFieldGenerator derivedFieldGenerator() {
        this.stored = builder.stored.getValue();  
            scaledValue,  
    private final boolean skiplist;
    @Override
import org.opensearch.index.fielddata.ScriptDocValues;  
            byte[] point = new byte[Long.BYTES];
     * 2. If doc_values is disabled in field mapping, then build source using stored field
        }
                    throw e;  
            }
        }  
             */
        Number numericValue = null;
            Map<String, String> meta,  
                    public double doubleValue() throws IOException {  
    static Double parse(Object value) {  
    }
                return new SortedNumericDoubleValues() {
 * You may obtain a copy of the License at  
        @Override  
            indexed,
        }
    @Override
            value = null;
        this.skiplist = builder.skiplist.getValue();
            };
    }
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.index.fielddata.IndexNumericFieldData;  
/*  
                return null;
        @Override
                isSearchable(),
                    public boolean advanceExact(int target) throws IOException {
    protected String contentType() {
            }
        private final Parameter<Double> nullValue = new Parameter<>(  
                buildFullName(context),
            List<Long> scaledValues = new ArrayList<>(values.size());  
                ).build(cache, breakerService);  
 * GitHub history for details.
        }  
                    @Override
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
import org.apache.lucene.index.LeafReaderContext;
            stored
            this.scalingFactorInverse = 1d / scalingFactor;
            this.skiplist = skiplist;
 * this work for additional information regarding copyright
        private final double scalingFactor;  
        @Override
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
                query = new BoostQuery(query, boost());  
        );  
     * 1. If it has doc values, build source using doc values
                scaledValues.add(scaledValue);  
        protected List<Parameter<?>> getParameters() {
            return this;  
    }
import org.apache.lucene.util.BytesRef;  
        @Override  
    /**
             * comparator wouldn't properly decode the long bits into the
            () -> null,  
    private static class ScaledFloatLeafFieldData implements LeafNumericFieldData {
                name(),
            return new ScaledFloatLeafFieldData(scaledFieldData.loadDirect(context), scalingFactor);  
        context.doc().addAll(fields);  
        private final boolean skiplist;
                lo,  
        public byte[] encodePoint(Object value, boolean roundUp) {
            return this;
             * We need to use a custom comparator because the non-custom  
    @Override  
import java.util.List;  
package org.opensearch.index.mapper;
            fieldType().name(),
                return DocValueFormat.RAW;  
        ScaledFloatLeafFieldData(LeafNumericFieldData scaledFieldData, double scalingFactor) {  
        );
        return parser.doubleValue(coerce);
        }
            hasDocValues,
        public ScaledFloatFieldType(String name, double scalingFactor) {
            super(name);
    private final Double nullValue;  
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());
        }
        }  
            return FieldData.toString(getDoubleValues());  
            (n, c, o) -> XContentMapValues.nodeBooleanValue(o),
     *    1. When using doc values, for multi value field, result would be in sorted order
                    @Override  
import java.util.Optional;
            return Optional.of(DimensionType.NUMERIC);
        public long ramBytesUsed() {
            doubleValue = number.doubleValue();  
    private static ScaledFloatFieldMapper toType(FieldMapper in) {  
        return (ScaledFloatFieldMapper) super.clone();  
        this.coerceByDefault = builder.coerce.getDefaultValue().value();
        return new DerivedFieldGenerator(
                query = new BoostQuery(query, boost());  
                query = new BoostQuery(query, boost());
            }
            super(name, indexed, stored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
                    double scalingFactor = getScalingFactor();
import org.opensearch.index.fielddata.FieldData;
        public void close() {  
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);
                LongPoint.encodeDimension(Long.MAX_VALUE, point, 0);  
        }
            }
import org.apache.lucene.index.SortedNumericDocValues;  
        }
            if (timeZone != null) {  
            doubleValue = Double.parseDouble(value.toString());
            return true;  
            skiplist,  
            boolean indexed,
        }
        private double scale(Object input) {
            if (doubleValue == Double.POSITIVE_INFINITY) {
                hasDocValues.getValue(),
    private final boolean coerceByDefault;  
            this.coerce = Parameter.explicitBoolParam("coerce", true, m -> toType(m).coerce, coerceByDefault);
                hasDocValues(),
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {  
        public LeafNumericFieldData load(LeafReaderContext context) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public ScriptDocValues.Doubles getScriptValues() {  
import org.opensearch.search.aggregations.support.ValuesSourceType;  
            }  
                return null;  
        return CONTENT_TYPE;
                numericValue = parse(parser, coerce.value());
         * floating-point imprecision (e.g., 79.99 * 100 = 7998.999...),
        public ScaledFloatFieldType(  
import org.opensearch.index.compositeindex.datacube.DimensionType;
     */
            );
            failIfNotIndexedAndNoDocValues();  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.NumericDocValues;
                @Override
     *    2. There might be precision loss as values are stored as long after multiplying it with "scaling_factor" for  
                    scaledValue = scaledValue - 1;  
            /*
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());  
 * SPDX-License-Identifier: Apache-2.0
            } else {
        }
            if (roundUp) {  
    private final boolean stored;
        public LeafNumericFieldData loadDirect(LeafReaderContext context) throws Exception {
            final SortedNumericDocValues values = scaledFieldData.getLongValues();
            value = numericValue;  
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
        public Object valueForDisplay(Object value) {  
                indexed.getValue(),  
        this.scalingFactor = builder.scalingFactor.getValue();
    }
        }
        }
        } else {  
        }
        protected FieldTypeCapabilities.Capability searchCapability() {  
            assert value instanceof Double;
                    double doubleValue;
                    @Override
                includeUpper,  
                m -> toType(m).ignoreMalformed,
            }
        public ValuesSourceType getValuesSourceType() {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
            } else {
    private Long parseScaledValue(ParseContext context) throws IOException {
                if (scaledValue < Long.MAX_VALUE) {
                hi = Math.round(scale(upperTerm));
            if (singleValues != null) {
                isSearchable()  
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
        public DocValueFetcher.Leaf getLeafValueFetcher(DocValueFormat format) {
            scaledFieldData.close();
        private final double scalingFactor;
        }  
import org.opensearch.core.xcontent.XContentParser;
            }
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
        }
    private final double scalingFactor;
            if (format != null) {
            ScaledFloatFieldType type = new ScaledFloatFieldType(
 */
            if (boost() != 1f) {
            false,  
 * the Apache License, Version 2.0 (the "License"); you may
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
    boolean coerce() {
    }
                    public boolean advanceExact(int doc) throws IOException {
        }
 * not use this file except in compliance with the License.
                return FieldData.singleton(new NumericDoubleValues() {
            return FieldTypeCapabilities.Capability.POINT_RANGE;
            }
                if (ignoreMalformed.value()) {  
import org.opensearch.index.fielddata.NumericDoubleValues;
 * compatible open source license.
            failIfNotIndexedAndNoDocValues();
            long scaledValue = Math.round(scale(value));
 * The OpenSearch Contributors require contributions made to  
        public Builder(String name, boolean ignoreMalformedByDefault, boolean coerceByDefault) {  
        }
        if (scaledValue == null) {
            Long hi = null;  
        return Math.round(doubleValue * scalingFactor);  
                    }  
            Query query = NumberFieldMapper.NumberType.LONG.termQuery(name(), scaledValue, hasDocValues(), isSearchable());
     * Converts an Object to a double by checking it against known types first  
            false,  
    }
    }
        }  
 * this file be licensed under the Apache-2.0 license or a
            return;
     */
            new StoredFieldFetcher(mappedFieldType, simpleName())
            if (boost() != 1f) {  
                    } else {
            String name,
        this.nullValue = builder.nullValue.getValue();  
    ) {
        private final Parameter<Double> scalingFactor = new Parameter<>(
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()),
             * double. Sorting on the long representation *would* put the
                LongPoint.encodeDimension(Long.MIN_VALUE, point, 0);
            final NumericDocValues singleValues = DocValues.unwrapSingleton(values);  
                throw new IllegalArgumentException("[scaled_float] only supports finite values, but got [" + doubleValue + "]");  
    private static double objectToDouble(Object value) {
        private final Double nullValue;  
            }
            (n, c, o) -> o == null ? null : XContentMapValues.nodeDoubleValue(o),
 * KIND, either express or implied.  See the License for the
    }  
    // use the same default as numbers  
        }
            value = null;
            return (cache, breakerService) -> {
                        }
    public static final String CONTENT_TYPE = "scaled_float";
            return scaledFieldData.getFieldName();  
        public String getFieldName() {
            return query;
import org.opensearch.core.xcontent.XContentParser.Token;  
        if (hasDocValues == false && (indexed || stored)) {
            return FieldData.castToLong(getDoubleValues());  
            this.nullValue = nullValue;
    }  
         * the consistent behavior ensures search queries work correctly.
                        return singleValues.advanceExact(doc);
                long scaledValue = Math.round(scale(value));
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"
        MultiFields multiFields,
        Builder nullValue(double nullValue) {
    protected void canDeriveSourceInternal() {
        }
                hi,
        }  
import java.util.Collections;
                    public int docValueCount() {  
        private final double scalingFactorInverse;
            }  
            return new SourceValueFetcher(name(), context) {
        ScaledFloatIndexFieldData(IndexNumericFieldData scaledFieldData, double scalingFactor) {
            double inverseScalingFactor = 1d / scalingFactor;
        @Override
        }  
    @Override  
        }
    private final boolean ignoreMalformedByDefault;
        private final LeafNumericFieldData scaledFieldData;  
        }
         * Note: Uses direct floating-point multiplication for consistency
 */  
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {  
                lo = Math.round(scale(lowerTerm));
         * @param input Input value to parse floating point num from
    @Override
            this.scaledFieldData = scaledFieldData;  
            mappedFieldType,  
            return scaledFieldData.getValuesSourceType();
    private ScaledFloatFieldMapper(
                        doubleValue = objectToDouble(value);
        public Query termsQuery(List<?> values, QueryShardContext context) {
            return new ScaledFloatLeafFieldData(scaledFieldData.load(context), scalingFactor);
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
                    name(),
        ).setValidator(v -> {
            "null_value",
        this.hasDocValues = builder.hasDocValues.getValue();
 * Modifications Copyright OpenSearch Contributors. See
                    return values.docValueCount();  
                        return singleValues.longValue() * scalingFactorInverse;
 *
 * license agreements. See the NOTICE file distributed with
/*
import org.apache.lucene.document.Field;
    protected void parseCreateField(ParseContext context) throws IOException {
                    IndexNumericFieldData.NumericType.LONG
    }
                        doubleValue = nullValue;  
            m -> toType(m).scalingFactor  
        Builder builder
 * by a scaling factor and rounded to the closest long.  
            return point;  
        if (value == null) {  
            return query;
    private static Double parse(XContentParser parser, boolean coerce) throws IOException {
/** A {@link FieldMapper} for scaled floats. Values are internally multiplied
    private final Explicit<Boolean> coerce;
        public Query termQuery(Object value, QueryShardContext context) {
        @Override  
    @Override
import org.opensearch.search.lookup.SearchLookup;
            this.scalingFactor = scalingFactor;
        }
    }
            Long lo = null;
                scalingFactor.getValue(),
        } else {
        }  
            }  
            };
            "skip_list",
    }
            double scalingFactor,
import org.apache.lucene.document.LongPoint;
            m -> toType(m).skiplist  
                throw new IllegalArgumentException(
            );
        private final Parameter<Explicit<Boolean>> coerce;
 * specific language governing permissions and limitations
            byte[] point = new byte[Long.BYTES];  
        }
            if (v == null) {
            () -> false,
     * <p>  
        public double toDoubleValue(long value) {  
public class ScaledFloatFieldMapper extends ParametrizedFieldMapper {
            this.scaledFieldData = scaledFieldData;
            failIfNotIndexedAndNoDocValues();
        if (Double.isFinite(doubleValue) == false) {
        public SortedBinaryDocValues getBytesValues() {
            }
        Object value;  
                @Override
            Query query = NumberFieldMapper.NumberType.LONG.termsQuery(
import java.util.function.Supplier;  
                    return format.format(values.nextValue());
        }
        @Override
            long scaledValue = Math.round(scale(value));
        @Override
            failIfNoDocValues();
            this.ignoreMalformed = Parameter.explicitBoolParam(
            numericValue = parse(value);  
        if (value instanceof Number number) {
    public ScaledFloatFieldType fieldType() {
        @Override
            } else if (doubleValue == Double.NEGATIVE_INFINITY) {
            return ((Number) value).longValue() / scalingFactor;
 *
import org.opensearch.index.fielddata.IndexFieldData;
                @Override
                hasDocValues(),
        @Override
            } else {
        if (numericValue == null) {
        @Override  
        }
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);  
         * Parses input value and multiplies it with the scaling factor.
        @Override  
                        return values.advanceExact(target);  
        @Override
        @Override
            return;
            this.scalingFactor = scalingFactor;  
        }
        @Override
 */  
                stored.getValue(),
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {  
        }
    /**  
        Builder scalingFactor(double scalingFactor) {
                public boolean advanceExact(int docId) throws IOException {  
                            return null;
                Collections.unmodifiableList(scaledValues),
        public SortedNumericDocValues getLongValues() {
        @Override
                protected Double parseSourceValue(Object value) {  
import org.opensearch.index.fielddata.LeafNumericFieldData;
 * ownership. Elasticsearch licenses this file to you under  
    private final Explicit<Boolean> ignoreMalformed;  
            return CONTENT_TYPE;
        }  
                if (scaledValue > Long.MIN_VALUE) {
            return point;
        public SortedNumericDoubleValues getDoubleValues() {
                        if (nullValue == null) {  
            for (Object value : values) {
        this.ignoreMalformedByDefault = builder.ignoreMalformed.getDefaultValue().value();  
            } else {
        }
        ScaledFloatFieldType mappedFieldType,
            return true;  
            LongPoint.encodeDimension(scaledValue, point, 0);
                name(),  
                    if (value.equals("")) {
    }
                meta.getValue(),
                return new ScaledFloatIndexFieldData(scaledValues, scalingFactor);
import org.opensearch.common.xcontent.support.XContentMapValues;
        XContentParser parser = context.parser();
                }
            this.nullValue.setValue(nullValue);
        }  
    }  
        if (scaledValue == null) {  
        public byte[] encodePoint(Number value) {
        @Override
    protected ScaledFloatFieldMapper clone() {
                }
            return null;
        Long scaledValue = parseScaledValue(context);
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
        private final Parameter<Boolean> skiplist = new Parameter<>(
        ).acceptsNull();  
    }
    public static class Builder extends ParametrizedFieldMapper.Builder {
import org.opensearch.common.Explicit;
        /** Still searchable from doc values when the index uses a pluggable data format. */
        @Override  
                        return values.docValueCount();
        public String typeName() {
        @Override
            // TODO: enable skiplist by default
            if (boost() != 1f) {
            this.scalingFactor.setValue(scalingFactor);  
            return scalingFactor;  
            doubleValue = Double.parseDouble(bytesRef.utf8ToString());
            }
            if (ignoreMalformed.value()) {
            return NumericType.DOUBLE;
        return (ScaledFloatFieldType) super.fieldType();  
             */
         * between indexing and querying. While this may result in  
                    }
        } else if (coerce.value() && parser.currentToken() == Token.VALUE_STRING && parser.textLength() == 0) {  
 * software distributed under the License is distributed on an
            };
             * docs in order. We just don't have a way to convert the long  
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;  
                    return values.advanceExact(docId);
                true,
            (n, c, o) -> XContentMapValues.nodeDoubleValue(o),
    private final boolean hasDocValues;  
                    }  
                @Override  
        }
                }  
import org.opensearch.common.settings.Setting;
            if (lowerTerm != null) {  
            return query;  
    }
                }
            return Arrays.asList(indexed, hasDocValues, stored, ignoreMalformed, meta, scalingFactor, coerce, nullValue, skiplist);
        private final Parameter<Explicit<Boolean>> ignoreMalformed;
        return (ScaledFloatFieldMapper) in;
            double doubleValue = (Double) value;  
        @Override  
         * @return Scaled value
/*  
        String simpleName,  
            return value * inverseScalingFactor;
        }
        Long scaledValue = parseScaledValue(context);  
        }
import org.opensearch.tools.jackson.core.JsonParseException;
     * Considerations:
        @Override  
                    return Math.round(doubleValue * scalingFactor) / scalingFactor;  
        double doubleValue = numericValue.doubleValue();  
        /**  
        @Override
        public NumericType getNumericType() {
        }  
                public Object nextValue() throws IOException {
import java.util.Arrays;
import org.apache.lucene.search.BoostQuery;
                "ignore_malformed",  
            return scaledFieldData.ramBytesUsed();
            boolean stored,  
        } else if (value instanceof BytesRef bytesRef) {
        private final IndexNumericFieldData scaledFieldData;
import java.time.ZoneId;
        }  
                public int docValueCount() throws IOException {
        @Override
        ) {  
                context  
            );
            );
import org.apache.lucene.index.DocValues;  
                // since we encode to a long, we have no way to carry NaNs and infinities
}
            }
            if (Double.isFinite(v) == false || v <= 0) {
    }
    public static final class ScaledFloatFieldType extends SimpleMappedFieldType implements NumericPointEncoder, FieldValueConverter {  
                    }  
        @Override
        this.coerce = builder.coerce.getValue();
            () -> null,
        }  
            "scaling_factor",
         */  
 *  
        this.indexed = builder.indexed.getValue();
        @Override  
            if (upperTerm != null) {
                }  
                return new DocValueFormat.Decimal(format);
            Query query = NumberFieldMapper.NumberType.LONG.rangeQuery(
        public ScaledFloatFieldMapper build(BuilderContext context) {  
        protected boolean sortRequiresCustomComparator() {
        }
        return new Builder(simpleName(), ignoreMalformedByDefault, coerceByDefault).init(this);
        }  
        }
            } else {  
    public ParametrizedFieldMapper.Builder getMergeBuilder() {  
import org.opensearch.common.settings.Settings;  
        public Builder(String name, Settings settings) {
        );
    }  
            }  
        }  
    }
            SortedNumericDoubleValues values = getDoubleValues();  
            return new DocValueFetcher.Leaf() {
            return parse(input) * scalingFactor;
import org.opensearch.index.IndexSettings;
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);  
                } else {
        List<Field> fields = NumberFieldMapper.NumberType.LONG.createFields(
            } catch (IllegalArgumentException | JsonParseException e) {
                final IndexNumericFieldData scaledValues = new SortedNumericIndexFieldData.Builder(  
        return coerce.value();
    private static final Setting<Boolean> COERCE_SETTING = NumberFieldMapper.COERCE_SETTING;
                    public double nextValue() throws IOException {
    protected Explicit<Boolean> ignoreMalformed() {  
            this(name, IGNORE_MALFORMED_SETTING.get(settings), COERCE_SETTING.get(settings));
                    @Override
        }
    @Override
        checkStoredAndDocValuesForDerivedSource();  
                    return null;
    private final boolean indexed;
import java.util.ArrayList;  
            return new ScaledFloatFieldMapper(name, type, multiFieldsBuilder.build(this, context), copyTo.build(), this);
         *  
        context.documentInput().addField(fieldType(), scaledValue);
        } else if (parser.currentToken() == Token.VALUE_NULL) {
        if (value == null) {
            Double nullValue
             * {@link ScaledFloatLeafFieldData#getDoubleValues()} transforms the raw long values in `scaled` floats.  
        @Override
            m -> toType(m).nullValue
                    }
        public boolean isDataCubeMetricSupported() {
import org.opensearch.search.DocValueFormat;
import org.apache.lucene.search.Query;
                    scaledValue = scaledValue + 1;
 * under the License.  
            }
                });  
            value = nullValue;
        @Override  
        CopyTo copyTo,  
        @Override
        }  
        double doubleValue;  
