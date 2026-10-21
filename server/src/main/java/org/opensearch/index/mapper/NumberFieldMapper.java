            public BigInteger parse(XContentParser parser, boolean coerce) throws IOException {
                Query dvQuery = hasDocValues ? SortedNumericDocValuesField.newSlowRangeQuery(field, l, u) : null;
                List<Field> fields = new ArrayList<>();
                    );
                                query
                        query,
                        }
                    throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
                hasDocValues(),
                    }
import org.roaringbitmap.RoaringBitmap;
                                HalfFloatPoint.halfFloatToSortableShort(l),
            }
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
                    Query query = HalfFloatPoint.newSetQuery(field, v);
                    if (context.indexSortedOnField(field)) {
                            }
                    }
            @Override
 * A {@link FieldMapper} for numeric types: byte, short, int, long, float, double and unsigned long.
                }
                    } else {
                    }
            @Override
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
        public abstract Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable);
                boolean includeUpper,
        public Number parse(Object value) {
        return new Builder(simpleName(), type, ignoreMalformedByDefault, coerceByDefault).init(this);
                                query
                if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                        )
        }
            Query query = type.termQuery(name(), value, hasDocValues(), isSearchable());
                boolean hasDocValues,
                        points[i] = HalfFloatPoint.halfFloatToSortableShort(v[i]);
        XContentParser parser = context.parser();
import org.opensearch.search.query.BitmapIndexQuery;
        public final String typeName() {
                return DoublePoint.newExactQuery(field, v);
                validateParsed(parsed);
                double doubleValue = number.doubleValue();
                () -> null,
                    u = parse(upperTerm, false);
            // sort it again as per its unsigned long value to keep the behavior consistent
        }
import java.util.Arrays;
     * @opensearch.internal
                query = new BoostQuery(query, boost());
            }
            }
                        dvQuery
                return dvQuery;
         */
                        }
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {
                return (short) doubleValue;
    private final boolean stored;
                boolean hasDocValues,
import org.opensearch.search.approximate.ApproximateScoreQuery;
            return true;
            Object upperTerm,
                final float result;
        ) {
                                field,
                if (isSearchable && hasDocValues) {
                byte[] bytes = Arrays.copyOfRange(ref.bytes, ref.offset, ref.offset + ref.length);
                        if (context.indexSortedOnField(field)) {
                    if (l.compareTo(Numbers.MAX_UNSIGNED_LONG_VALUE) == 0) {
        @Override
                return encodePoint(numericValue);
                            new ApproximatePointRangeQuery(
        }
            };
                        fields.add(SortedNumericDocValuesField.indexedField(name, NumericUtils.floatToSortableInt(value.floatValue())));
                if ((upperTermHasDecimalPart == false && includeUpper == false) || (upperTermHasDecimalPart && signum(upperTerm) < 0)) {
            public double toDoubleValue(long value) {
                    return Queries.newMatchNoDocsQuery("All values have a decimal part");
            }
                }
                boolean stored
                        NumericUtils.floatToSortableInt(u)
            m -> toType(m).skiplist
    @Override
            if (doubleValue < Numbers.MIN_UNSIGNED_LONG_VALUE.doubleValue()
            }
                BigInteger numericValue = parse(value, true);
            @Override
            }
                if (hasDecimalPart(value)) {
                    throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
                            IntPoint.pack(l).bytes,
                            APPROX_QUERY_NUMERIC_DIMS,
     * 1. If it has doc values, build source using doc values
                if (upTo != v.length) {
                    Query query;
            boolean stored
        this.coerce = builder.coerce.getValue();
            }
                if (type != NumberType.UNSIGNED_LONG) {
    }
    }
        }
            }
                            NumericUtils.doubleToSortableLong(u)
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());
            public Short parse(XContentParser parser, boolean coerce) throws IOException {
                if (hasDocValues) {
                IntPoint.encodeDimension(value.intValue(), point, 0);
                Integer numericValue = parse(value, true);
                }
            }
                // - if the bound is positive then we increment it:
                                query = new IndexSortSortedNumericDocValuesRangeQuery(field, l, u, query);
                    ++l;
    private final boolean coerceByDefault;
        @Override
        } else {
    }
                return encodePoint(numericValue);
            }
                boolean isSearchable,
            @Override
            }
            @Override
            return Math.signum(Double.parseDouble(value.toString()));
                if (roundUp) {
         */
                    Query query;
            }
            @Override
                // - if the bound is negative then we leave it as is:
        private final Parameter<Number> nullValue;
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
            boolean docValued,
            @Override
        /** Still searchable from doc values when the index uses a pluggable data format. */
            @Override
                        displayValues[i] = (BigInteger) convert(values.get(i));
        }
                        );
        },
            // be equal to Long.MAX_VALUE after conversion to double. More checks ahead.
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);
                }
                return parsed;
                        )
            @Override
                return fields;
                return Numbers.toUnsignedBigInteger(longValue);
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
                } else {
                if (val == null) {
                }
        checkStoredAndDocValuesForDerivedSource();
            @Override
            public Query termsQuery(String field, List<Object> values, boolean hasDocvalues, boolean isSearchable) {
                    Query query = LongPoint.newExactQuery(field, v);
                }
            public Double parse(Object value, boolean coerce) {
                    if (isSearchable) {
                List<Field> fields = new ArrayList<>();
            @Override
                        NumericUtils.floatToSortableInt(u),
 * license agreements. See the NOTICE file distributed with
         */
                if (hasDocValues) {
                return objectToUnsignedLong(value, coerce);
            @Override
                        : null;
import org.opensearch.search.query.Bitmap64IndexQuery;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                BigIntegerPoint.encodeDimension(objectToUnsignedLong(value, false, true), point, 0);
            }
                        dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(field, l, u, dvQuery);
            Number valueForSearch(String value) {
            @Override
                            if (context.indexSortedOnField(field)) {
 */
                if (indexed) {
            }
                    case HALF_FLOAT -> HalfFloatPoint.sortableShortToHalfFloat(val.shortValue());
                m -> toType(m).ignoreMalformed,
                    fields.add(new StoredField(name, value.floatValue()));
                if (isSearchable && hasDocValues) {
        public boolean isDataCubeMetricSupported() {
        return (NumberFieldMapper) in;
                return Integer.parseInt(value);
                Query dvQuery = hasDocValues
                } else {
                for (int i = 0; i < values.size(); i++) {
                } catch (IOException e) {
                boolean skiplist,
                            )
        }
        this.type = builder.type;
                boolean includeLower,
                                    NumericUtils.doubleToSortableLong(l),
                }
                u = objectToLong(upperTerm, true);
                        fields.add(new SortedNumericDocValuesField(name, value.longValue()));
                    if (hasDocValues) {
    @Override
                        fields.add(new SortedNumericDocValuesField(name, HalfFloatPoint.halfFloatToSortableShort(value.floatValue())));
                boolean isSearchable,
                    }
            @Override
                    return new ApproximateScoreQuery(
                }
        UNSIGNED_LONG("unsigned_long", NumericType.UNSIGNED_LONG) {
            @Override
            @Override
                    if (dvQuery != null) {
        } else if (coerce.value() && parser.currentToken() == Token.VALUE_STRING && parser.textLength() == 0) {
            public List<Field> createFields(
                }
                        numericValue = numericValue - 1;
     *
        }
                        LongPoint.newSetQuery(field, v),
                return new BigInteger(value);
    public static class NumberFieldType extends SimpleMappedFieldType implements NumericPointEncoder, FieldValueConverter {
                return new BitmapDocValuesQuery(field, bitmap);
                }
                float l = Float.NEGATIVE_INFINITY;
                l = objectToUnsignedLong(lowerTerm, true);
         * Get the associated type name.
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for an integer");
                value = fieldType().type.parse(parser, coerce.value());
            }
                List<Field> fields = new ArrayList<>();
        }
            return numericType;
            }
                        fields.add(
                    }
            if (value instanceof Long longValue) {
                if (docValued) {
                    boolean upperTermHasDecimalPart = hasDecimalPart(upperTerm);
                    }
            @Override
         */
                long points[] = new long[v.length];
    private NumberFieldMapper(String simpleName, MappedFieldType mappedFieldType, MultiFields multiFields, CopyTo copyTo, Builder builder) {
                return Math.signum(doubleValue);
            public Query rangeQuery(
            @Override
                if (indexed) {
    protected DerivedFieldGenerator derivedFieldGenerator() {
                    // DESC: exclusive upper bound
            @Override
        }
                float v = parse(value, false);
            }
                    Query dvQuery = hasDocValues ? SortedNumericDocValuesField.newSlowRangeQuery(field, l, u) : null;
            public double toDoubleValue(long value) {
                }
        public String typeName() {
                    }
                            return new MatchNoDocsQuery();
                String name,
                return parsed;
        },
                }
            failIfNotIndexedAndNoDocValues();
 * Licensed to Elasticsearch under one or more contributor
                }
            @Override
            BigInteger u = Numbers.MAX_UNSIGNED_LONG_VALUE;
                        HalfFloatPoint.halfFloatToSortableShort(u),
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);
                if (!Double.isFinite(value)) {
            ) {
import org.apache.lucene.document.DoublePoint;
                        points[i] = NumericUtils.floatToSortableInt(v[i]);
                boolean stored
            this.parser = new TypeParser((n, c) -> new Builder(n, this, c.getSettings()));
                Object upperTerm,
                return objectToDouble(value);
            }
                }
                    fields.add(new DoublePoint(name, value.doubleValue()));
                }
                            field,
                return IntPoint.decodeDimension(value, 0);
                    return SortedNumericDocValuesField.newSlowSetQuery(field, points);
                }
                boolean docValued,
            this(name, type, IGNORE_MALFORMED_SETTING.get(settings), COERCE_SETTING.get(settings));
                        )
                boolean skiplist,
            public Long parse(XContentParser parser, boolean coerce) throws IOException {
            Number valueForSearch(String value) {
                }
                }
                } else {
            Object upperTerm,
import java.util.Optional;
            public List<Field> createFields(
                if (upperTerm != null) {
            }
                String field,
        SHORT("short", NumericType.SHORT) {
                if (lowerTerm != null) {
                    Query query = HalfFloatPoint.newExactQuery(field, v);
            BigInteger l = Numbers.MIN_UNSIGNED_LONG_VALUE;
                    context.addIgnoredField(mappedFieldType.name());
            failIfNotIndexedAndNoDocValues();
            return Arrays.asList(indexed, hasDocValues, stored, skiplist, ignoreMalformed, coerce, nullValue, meta);
            return FieldTypeCapabilities.Capability.POINT_RANGE;
                    u = parse(upperTerm, false);
                    if (dvQuery != null) {
            boolean isSearchable,
            double l = Double.NEGATIVE_INFINITY;
                throw new IllegalArgumentException("Value [" + value + "] is out of range for a long");
            @Override
            }
                            }
                    return SortedUnsignedLongDocValuesSetQuery.newSlowExactQuery(field, v);
                }
                    result = Float.parseFloat(value.toString());
            @Override
                );
                }
                        fields.add(SortedNumericDocValuesField.indexedField(name, value.longValue()));
            ) {
            @Override
            return builder.apply(l, u);
                    return Queries.newMatchNoDocsQuery("Value [" + value + "] has a decimal part");
                    // ASC: exclusive lower bound
                        return new ApproximateScoreQuery(
        /**
                if (hasDocValues) {
                }
            return type.toDoubleValue(value);
            }
    @Override
     * Considerations:
                }
                        numericValue = numericValue.subtract(BigInteger.ONE);
                // Always apply exclusivity
            ) {
                if (upTo != v.length) {
            ) {
        public Function<byte[], Number> pointReaderIfPossible() {
            ) {
                return point;
                                LongPoint.pack(l).bytes,
                float[] v = new float[values.size()];
                boolean isSearchable,
    /**
                    }
                String name,
            String name,
        this.stored = builder.stored.getValue();
import java.time.ZoneId;
            public List<Field> createFields(
import org.opensearch.common.settings.Settings;
                boolean docValued,
        Builder nullValue(Number number) {
                });
                        u = FloatPoint.nextDown(u);
                    throw new IllegalArgumentException("Failed to deserialize the bitmap.", e);
                if (values.size() == 1) {
                    : null;
                    return new ApproximateScoreQuery(
                protected Object parseSourceValue(Object value) {
         * Converts an Object to a {@code BigInteger} by checking it against known
                    if (numericValue.compareTo(Numbers.MAX_UNSIGNED_LONG_VALUE) < 0) {
            }
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
     * Field type for numeric fields
            }
                if (type == NumberType.UNSIGNED_LONG) {
                    if (numericValue < Integer.MAX_VALUE) {
     */
        public double toDoubleValue(long value) {
        private final TypeParser parser;
                if (stored) {
        }
                            query,
                if (context.indexSortedOnField(field)) {
                return unsignedLongRangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, (l, u) -> {
                for (int i = 0; i < values.size(); ++i) {
        public Query termsQuery(List values, QueryShardContext context) {
import org.opensearch.search.lookup.SearchLookup;
            if (value instanceof String stringValue) {
        FLOAT("float", NumericType.FLOAT) {
    protected NumberFieldMapper clone() {
            this.coerce = Parameter.explicitBoolParam("coerce", true, m -> toType(m).coerce, coerceByDefault);
                Float numericValue = parse(value, true);
            }
    private final Number nullValue;
                            ApproximatePointRangeQuery.INT_FORMAT
        ) {
                    if (skiplist) {
            }
         * types and checking its range.
            return parser;
         * Returns -1, 0, or 1 if the value is lower than, equal to, or greater than 0
                };
                }
    protected void canDeriveSourceInternal() {
                    return SortedNumericDocValuesField.newSlowExactQuery(field, v);
        if (numericValue == null) {
import java.util.Collections;
     */
                        return nullValue;
        }
                        fields.add(new SortedNumericDocValuesField(name, value.intValue()));
                if (doubleValue < Byte.MIN_VALUE || doubleValue > Byte.MAX_VALUE) {
                    fields.add(new StoredField(name, v.toString()));
    public enum NumberType implements NumericPointEncoder, FieldValueConverter {
            String stringValue = (value instanceof BytesRef bytesRef) ? bytesRef.utf8ToString() : value.toString();
        public static Query longRangeQuery(
                    }
                        HalfFloatPoint.halfFloatToSortableShort(l),
                }
                    if (value instanceof BytesRef bytesRef) {
import org.opensearch.common.settings.Setting;
                if (includeLower == false) {
                builder.stored.getValue(),
                            return new MatchNoDocsQuery();
                    // if lowerTerm=-1.5 then the (inclusive) bound becomes -1 due to the call to longValue
                    return Queries.newMatchNoDocsQuery("All values have a decimal part");
                byte[] point = new byte[Double.BYTES];
                boolean isSearchable,
                boolean upperTermHasDecimalPart = hasDecimalPart(upperTerm);
                Roaring64NavigableMap bitmap64 = new Roaring64NavigableMap();
                    )
            BiFunction<BigInteger, BigInteger, Query> builder
            this.coerce = coerce;
    private final NumberType type;
            boolean includeUpper,
            }
            ) {
                if (hasDocvalues) {
            public Number parsePoint(byte[] value) {
            boolean includeLower,
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
            @Override
        public static Query doubleRangeQuery(
                            query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
                return fields;
import org.opensearch.search.query.BitmapDocValuesQuery;
            }
                    super.write(builder, values);
                    return SortedNumericDocValuesField.newSlowSetQuery(field, points);
                    // - if the bound is negative then we leave it as is:
                    return new IndexOrDocValuesQuery(query, dvQuery);
                if (context.indexSortedOnField(field)) {
                    Arrays.sort(displayValues);
    @Override
            double u = Double.POSITIVE_INFINITY;
import org.apache.lucene.document.Field;
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
        this.ignoreMalformedByDefault = builder.ignoreMalformed.getDefaultValue().value();
        protected List<Parameter<?>> getParameters() {
            }
            public Number parsePoint(byte[] value) {
            @Override
        LONG("long", NumericType.LONG) {
                        if (dvQuery != null) {
                            query = new IndexSortSortedNumericDocValuesRangeQuery(
            @Override
                if (docValued) {
            ) {
                return encodePoint(numericValue);
                    }
                    return new IndexOrDocValuesQuery(query, dvQuery);
         */
            @Override
            public byte[] encodePoint(Object value, boolean roundUp) {
                return point;
                return this::parsePoint;
     * @opensearch.internal
        @Override
                long[] v = new long[values.size()];
                        if (hasDocValues) {
                    l = parse(lowerTerm, false);
                if (upperTerm != null) {
        public static long objectToLong(Object value, boolean coerce) {
                if (isSearchable) {
                Number value,
                    }
                } else {
            builder.indexed.setValue(false);
                return objectToLong(value, coerce);
                : Optional.of(DimensionType.NUMERIC);
            public Number parsePoint(byte[] value) {
                        query = pointRangeQuery;
                        if (u == Integer.MIN_VALUE) {
 */
        },
            }
                if (hasDocValues) {
        if (numericValue == null) {
                if (upTo == 0) {
        }
                return FloatPoint.decodeDimension(value, 0);
                // if the lower bound is decimal:
                    return new IndexOrDocValuesQuery(new Bitmap64IndexQuery(field, bitmap64), new Bitmap64DocValuesQuery(field, bitmap64));
                if (hasDocValues) {
            }
     * 2. If doc_values is disabled in field mapping, then build source using stored field
                        numericValue = (byte) (numericValue + 1);
                if (isSearchable && hasDocValues) {
                }
                            query,
                    : null;
                }
                boolean includeUpper,
                } catch (Exception e) {
            }
            this(
            }
            @Override
            ) {
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
                }
                    return new IndexOrDocValuesQuery(
                        FloatPoint.newSetQuery(field, v),
            if (number instanceof BytesRef bytesRef) {
import java.nio.ByteBuffer;
                validateParsed(parsed);
    }
import org.opensearch.common.settings.Setting.Property;
            @Override
            if (doubleValue < Long.MIN_VALUE || doubleValue > Long.MAX_VALUE) {
                return new DocValueFormat.Decimal(format);
            this.nullValue = nullValue;
                List<Field> fields = new ArrayList<>();
            createFieldNamesField(context);
            public byte[] encodePoint(Number value) {
 * Modifications Copyright OpenSearch Contributors. See
            return type;
        @Override
        }
            public Number parsePoint(byte[] value) {
                if (roundUp) {
        );
                return parsed;
            public byte[] encodePoint(Object value, boolean roundUp) {
                    case BYTE, SHORT, INTEGER, LONG -> val;
            }
                byte[] point = new byte[Integer.BYTES];
                    if (skiplist) {
                    Query query = BigIntegerPoint.newSetQuery(field, v);
    }
                float parsed = parser.floatValue(coerce);
                if (stored) {
            }
                    }
        Number numericValue = getFieldValue(context);
                        SortedNumericDocValuesField.newSlowSetQuery(field, points)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
            public Query rangeQuery(
            return type.numericType.equals(NumericType.UNSIGNED_LONG)
                boolean stored
                            query = new IndexSortSortedNumericDocValuesRangeQuery(
                Object upperTerm,
            return query;
                        field,
                }
import java.io.IOException;
    private final Explicit<Boolean> ignoreMalformed;
        /**
                    }
            @Override
        public Object valueForDisplay(Object value) {
                String name,
                l = objectToDouble(lowerTerm);
            this.name = name;
                        query = pointRangeQuery;
            }
        NumberFieldType(String name, Builder builder) {
            return type.bitmapQuery(name(), bitmap, isSearchable(), hasDocValues());
                }
                        v[upTo++] = parse(value, true);
                    ? SortedNumericDocValuesField.newSlowRangeQuery(
                }
                // - if the bound is negative then we leave it as is:
            }
}
            } else {
                        );
                return INTEGER.termsQuery(field, values, hasDocValues, isSearchable);
                upperTerm,
            @Override
import org.opensearch.common.Numbers;
                return doubleValue % 1 != 0;
                    }
        } else if (parser.currentToken() == Token.VALUE_NULL) {
    }
            @Override
            @Override
            @Override
     *       compared to stored field(stored as float)
                    if (numericValue < Long.MAX_VALUE) {
                if (context.indexSortedOnField(field)) {
import java.io.ByteArrayInputStream;
                "null_value",
                return Double.parseDouble(stringValue) % 1 != 0;
                        numericValue = numericValue.add(BigInteger.ONE);
                        return new MatchNoDocsQuery();
        protected FieldTypeCapabilities.Capability searchCapability() {
            }
            }
                Object lowerTerm,
                    numericValue = HalfFloatPoint.nextDown(numericValue);
                Object lowerTerm,
                if (hasDecimalPart(value)) {
            }
        }
            }
                boolean hasDocValues,
                return BigIntegerPoint.newSetQuery(field, v);
                ? Optional.of(DimensionType.UNSIGNED_LONG)
        private final Number nullValue;
    }
                        points[i] = v[i];
                    return new Bitmap64IndexQuery(field, bitmap64);
 * The OpenSearch Contributors require contributions made to
            }
                int u = Integer.MAX_VALUE;
                return NumericUtils.sortableLongToDouble(value);
                if (indexed) {
     *    2. For "half_float", there might be precision loss, when using doc values(stored as HalfFloatPoint) as
                builder.hasDocValues.getValue(),
                        SortedNumericDocValuesField.newSlowSetQuery(field, v)
            boolean isStored,
            return builder.apply(l, u);
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
            public Integer parse(Object value, boolean coerce) {
        Number valueForSearch(Number value) {
                    } else {
                    if (isSearchable) {
            @Override
            public void write(XContentBuilder builder, List<Object> values) throws IOException {
            if (isSearchable()) {
            }
import org.opensearch.core.xcontent.XContentParser;
                String field,
                    u = u.subtract(BigInteger.ONE);
                IntPoint.encodeDimension(value.intValue(), point, 0);
                return point;
                    return dvQuery;
                    if ((upperTermHasDecimalPart == false && includeUpper == false) || (upperTermHasDecimalPart && signum(upperTerm) < 0)) {
            }
         */
                    return SortedNumericDocValuesField.newSlowExactQuery(field, NumericUtils.doubleToSortableLong(v));
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);
            public Float parse(Object value, boolean coerce) {
            public Number parsePoint(byte[] value) {
        context.documentInput().addField(fieldType(), numericValue);
                return encodePoint(numericValue);
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for a byte");
                boolean stored
                    // if the lower bound is decimal:
                    }
                return point;
            public byte[] encodePoint(Object value, boolean roundUp) {
                        field,
                LongPoint.encodeDimension(value.longValue(), point, 0);
        this.coerceByDefault = builder.coerce.getDefaultValue().value();
            }
                byte[] point = new byte[Integer.BYTES];
                }
import java.util.List;
            boolean skiplist,
 * @opensearch.internal
                true,
                    return Queries.newMatchNoDocsQuery("All values have a decimal part");
                        query = pointRangeQuery;
            @Override
                    // ASC: exclusive lower bound
                return (double) value;
            @Override
                }
            @Override
                    return null;
 *
     *    1. When using doc values, for multi value field, result would be in sorted order
                return encodePoint(numericValue);
                    )
                        Query pointRangeQuery = DoublePoint.newRangeQuery(field, l, u);
                if (doubleValue < Short.MIN_VALUE || doubleValue > Short.MAX_VALUE) {
                                NumericUtils.floatToSortableInt(l),
                return encodePoint(numericValue);
                return HalfFloatPoint.newSetQuery(field, v);
                boolean stored
                }
            if (lowerTerm != null) {
            this.nullValue.setValue(number);
                }
                }
                    v[i] = parse(values.get(i), false);
                    }
                return fields;
                        l = FloatPoint.nextUp(l);
                    }
                } else {
                        Query pointRangeQuery = LongPoint.newRangeQuery(field, l, u);
            return builder;
            return objectToUnsignedLong(value, coerce, false);
    /**
                builder.nullValue.getValue(),
                    // - if the bound is positive then we increment it:
                String field,
                if (docValued) {
        return (NumberFieldMapper) super.clone();
        public byte[] encodePoint(Object value, boolean roundUp) {
            Number valueForSearch(String value) {
                    } else {
                            )
                            NumericUtils.doubleToSortableLong(u),
        }
                    u = parse(upperTerm, true);
        @Override
        }
                                DoublePoint.pack(u).bytes,
                } else {
 * this file be licensed under the Apache-2.0 license or a
                    }
                        HalfFloatPoint.halfFloatToSortableShort(u)
            this.hasDocValues.setValue(hasDocValues);
            }
            ) {
            return fieldType().type.parse(context.externalValue(), coerce.value());
                boolean includeLower,
                        fields.add(SortedNumericDocValuesField.indexedField(name, v.longValue()));
                return Float.parseFloat(value);
        public static boolean hasDecimalPart(Object number) {
         * Processes query bounds into {@code long}s and delegates the
                return parser.bigIntegerValue(coerce);
        private final NumberType type;
                    if (numericValue > Short.MIN_VALUE) {
                    return Numbers.MAX_UNSIGNED_LONG_VALUE;
    @Override
                BytesRef ref = bitmapArray.toBytesRef();
                    }
            @Override
                                APPROX_QUERY_NUMERIC_DIMS,
    public static class Builder extends ParametrizedFieldMapper.Builder {
         * provided {@code builder} to build a range query.
                    fields.add(new StoredField(name, value.intValue()));
        },
                boolean skiplist,
                                BigIntegerPoint.pack(u).bytes,
            public Float parse(XContentParser parser, boolean coerce) throws IOException {
                }
                return INTEGER.parsePoint(value).byteValue();
            }
import org.apache.lucene.util.NumericUtils;
                int upTo = 0;
                if (hasDocValues) {
                    return DocValueFormat.RAW;
                QueryShardContext context
                if (docValued) {
            }
        public abstract Query rangeQuery(
            }
                boolean indexed,
            public List<Field> createFields(
                }
                    if (numericValue > Long.MIN_VALUE) {
                        fields.add(SortedNumericDocValuesField.indexedField(name, NumericUtils.doubleToSortableLong(value.doubleValue())));
                }
 * the Apache License, Version 2.0 (the "License"); you may
                long points[] = new long[v.length];
            Object lowerTerm,
                                DoublePoint.pack(l).bytes,
                if (ignoreMalformed.value() && parser.currentToken().isValue()) {
                            APPROX_QUERY_NUMERIC_DIMS,
                        fields.add(new SortedNumericDocValuesField(name, NumericUtils.doubleToSortableLong(value.doubleValue())));
                if (stored) {
            () -> false,
                doubleValue = Double.parseDouble(value.toString());
        }
            return type.parse(value, coerce);
 * this work for additional information regarding copyright
                }
     */
                        numericValue = numericValue + 1;
            Number nullValue,
            public List<Field> createFields(
            }
            }
                } else {
                return dvQuery;
                }
                boolean isSearchable,
            public Integer parse(XContentParser parser, boolean coerce) throws IOException {
                Number value,
    private final boolean skiplist;
                    return number.byteValue();
            return this;
        }
                                HalfFloatPoint.halfFloatToSortableShort(u),
/*
 *
        }
                        HalfFloatPoint.halfFloatToSortableShort(l),
            if (boost() != 1f) {
                            SortedNumericDocValuesField.indexedField(name, HalfFloatPoint.halfFloatToSortableShort(value.floatValue()))
            @Override
                    }
        /**
 * under the License.
                return LongPoint.newSetQuery(field, v);
                return INTEGER.termQuery(field, value, hasDocValues, isSearchable);
        );
        /**
                final BigInteger v = Numbers.toUnsignedLongExact(value);
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
                builder.type,
                l = objectToLong(lowerTerm, true);
        @Override
                if (isSearchable) {
            return new NumberFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), this);
                return value.shortValue();
                    Query pointRangeQuery = HalfFloatPoint.newRangeQuery(field, l, u);
        public static double signum(Object value) {
                }
                if ((lowerTermHasDecimalPart == false && includeLower == false) || (lowerTermHasDecimalPart && signum(lowerTerm) > 0)) {
                return INTEGER.rangeQuery(field, lowerTerm, upperTerm, includeLower, includeUpper, hasDocValues, isSearchable, context);
            // longs need special handling so we don't lose precision while parsing
                if (isSearchable) {
            public double toDoubleValue(long value) {
                            FloatPoint.pack(u).bytes,
                    Object value = values.get(i);
            long l = Long.MIN_VALUE;
                    return SortedNumericDocValuesField.newSlowExactQuery(field, v);
                }
                    return new ApproximateScoreQuery(
                // Extract bytes safely
                    fields.add(new LongPoint(name, value.longValue()));
                return new Bitmap64DocValuesQuery(field, bitmap64);
                boolean stored
                boolean hasDocValues,
                        fields.add(new SortedNumericDocValuesField(name, NumericUtils.floatToSortableInt(value.floatValue())));
                        return new ApproximateScoreQuery(
            @Override
                    }
                    );
                    if ((lowerTermHasDecimalPart == false && includeLower == false) || (lowerTermHasDecimalPart && signum(lowerTerm) > 0)) {
                }
                boolean includeUpper,
            Object lowerTerm,
            public Byte parse(Object value, boolean coerce) {
            boolean includeLower,
            if (!coerce && doubleValue % 1 != 0) {
                if (isSearchable && hasDocvalues) {
                validateParsed(result);
                    if (skiplist) {
            }
                        query,
import java.util.Objects;
                return (byte) doubleValue;
                boolean includeUpper,
                    }
            @Override
        public abstract Number parse(Object value, boolean coerce);
                if (roundUp) {
            @Override
            if (value instanceof Long longValue) {
                return FloatPoint.newSetQuery(field, v);
            }
            }
    private final boolean indexed;
            public Long parse(Object value, boolean coerce) {
                    throw new IllegalArgumentException("[float] supports only finite values, but got [" + value + "]");
        }
            }
                return Float.parseFloat(value);
                                    field,
                query = new BoostQuery(query, boost());
                boolean indexed,
import org.apache.lucene.search.Query;
                            );
                return (double) value;
                                );
            }
                    if (includeUpper == false) {
                return INTEGER.rangeQuery(field, lowerTerm, upperTerm, includeLower, includeUpper, hasDocValues, isSearchable, context);
                        );
                    if (skiplist) {
            NumberType type,
                "ignore_malformed",
            return query;
                    builder.field(simpleName, convert(values.getFirst()));
            }
            }
                    );
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
                        numericValue = (byte) (numericValue - 1);
            }
                if (isSearchable && hasDocValues) {
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, HalfFloatPoint.halfFloatToSortableShort(v));
                            query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
            public double toDoubleValue(long value) {
                return point;
                name,
            public byte[] encodePoint(Number value) {
                boolean docValued,
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, v);
                IntPoint.encodeDimension(value.intValue(), point, 0);
            boolean hasDocValues,
import org.opensearch.index.document.SortedUnsignedLongDocValuesRangeQuery;
                boolean indexed,
                    }
        public Number parsePoint(byte[] value) {
                }
                Number value,
                boolean includeLower,
    }
            return builder.apply(l, u);
            }
            }
        /**
            public Double parse(XContentParser parser, boolean coerce) throws IOException {
        /**
                    }
                    if (isSearchable) {
                boolean skiplist,
                int upTo = 0;
        public NumberFieldType(
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
            }
     */
            }
                return point;
                        SortedNumericDocValuesField.newSlowSetQuery(field, points)
                }
import java.util.ArrayList;
                    if (includeLower == false) {
                            NumericUtils.doubleToSortableLong(l),
            }
            this.type = type;
                    return new IndexOrDocValuesQuery(query, dvQuery);
            Object upperTerm,
                }
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for a short");
        public Builder(String name, NumberType type, Settings settings) {
                builder.skiplist.getValue(),
            if (lenientBound) {
            @Override
                        fields.add(new SortedNumericDocValuesField(name, v.longValue()));
                    }
            this.setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);     // allows number fields in significant text aggs - do we need this?
            public double toDoubleValue(long value) {
        if (hasDocValues == false && (stored || indexed)) {
                } else {
                boolean hasDocValues,
                boolean indexed,
                boolean includeUpper,
        }
                if (!coerce && doubleValue % 1 != 0) {
                    Query dvQuery = SortedUnsignedLongDocValuesSetQuery.newSlowSetQuery(field, v);
    private static final int APPROX_QUERY_NUMERIC_DIMS = 1;
            public Query rangeQuery(
                if (isSearchable && hasDocValues) {
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, NumericUtils.doubleToSortableLong(v));
        public abstract Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable);
                    } else {
                                APPROX_QUERY_NUMERIC_DIMS,
            return Numbers.toUnsignedLong(stringValue, coerce);
                int value = parser.intValue(coerce);
                }
        }
        private final boolean coerce;
                                    NumericUtils.doubleToSortableLong(u),
                    Object value = values.get(i);
            if (value instanceof BytesRef bytesRef) {
            }
                        value = bytesRef.utf8ToString();
                        if (dvQuery != null) {
                            query = new IndexSortSortedNumericDocValuesRangeQuery(field, l, u, query);
                RoaringBitmap bitmap = new RoaringBitmap();
                        Query query;
                }
                if (roundUp) {
            return type.encodePoint(value, roundUp);
            }
                return result;
            return doubleValue;
import org.opensearch.core.xcontent.XContentParser.Token;
            ) {
                    if (numericValue.compareTo(Numbers.MIN_UNSIGNED_LONG_VALUE) > 0) {
                boolean lowerTermHasDecimalPart = hasDecimalPart(lowerTerm);
                    }
                        new ApproximatePointRangeQuery(
                }
 * not use this file except in compliance with the License.
                return (short) value;
            public Number parsePoint(byte[] value) {
                    }
                @Override
            public double toDoubleValue(long value) {
                return INTEGER.termsQuery(field, values, hasDocValues, isSearchable);
                if (doubleValue < Integer.MIN_VALUE || doubleValue > Integer.MAX_VALUE) {
                    }
        this.hasDocValues = builder.hasDocValues.getValue();
                }
                    numericValue = HalfFloatPoint.nextUp(numericValue);
                Object lowerTerm,
            @Override
                if (value instanceof Number number) {
            }
        public abstract List<Field> createFields(
                }
                }
                    }
                for (int i = 0; i < values.size(); ++i) {
        }
                boolean isSearchable,
            @Override
                double doubleValue = objectToDouble(value);
                if (isSearchable) {
            } else if (value instanceof BytesRef bytesRef) {
 *
                    throw new IllegalArgumentException("[double] supports only finite values, but got [" + value + "]");
    protected Number getFieldValue(ParseContext context) throws IOException {
                if (doubleValue > Numbers.MAX_UNSIGNED_LONG_VALUE.doubleValue()) {
            @Override
            if (boost() != 1f) {
                if (docValued) {
            @Override
                if (indexed) {
                boolean skiplist,
                Object upperTerm,
            @Override
                    return new IndexOrDocValuesQuery(
                        new ApproximatePointRangeQuery(
            Query query = type.termsQuery(name(), values, hasDocValues(), isSearchable());
                        u = HalfFloatPoint.nextUp(u);
                boolean isSearchable,
                        new ApproximatePointRangeQuery(
                    if (numericValue < Short.MAX_VALUE) {
                    if (hasDocValues) {
        public byte[] encodePoint(Number value) {
                return LongPoint.newExactQuery(field, v);
                if (!Float.isFinite(HalfFloatPoint.sortableShortToHalfFloat(HalfFloatPoint.halfFloatToSortableShort(value)))) {
                if (stored) {
                return result;
                boolean isSearchable,
import org.apache.lucene.search.BoostQuery;
                return HalfFloatPoint.newExactQuery(field, v);
                return parser.shortValue(coerce);
            @Override
     *
            @Override
            }
                validateParsed(result);
        }
                    Query dvQuery = hasDocValues
                    }
        @Override
                    }
        };
                boolean stored
                }
                lowerTerm,
                return point;
        private final NumberType type;
 * Unless required by applicable law or agreed to in writing,
            }
                }
                if (upTo != v.length) {
                boolean indexed,
                if (indexed) {
                if (isSearchable && hasDocValues) {
                    numericValue = DoublePoint.nextUp(numericValue);
        }
                String name,
                int l = Integer.MIN_VALUE;
import org.opensearch.index.compositeindex.datacube.DimensionType;
                int[] v = new int[values.size()];
        @Override
                    final BigInteger[] displayValues = new BigInteger[values.size()];
            }
            failIfNotIndexedAndNoDocValues();
            }
        private final Parameter<Explicit<Boolean>> ignoreMalformed;
            }
                    return;
                    Query query;
            );
                Number value,
                    return DocValueFormat.UNSIGNED_LONG;
                // if lowerTerm=-1.5 then the (inclusive) bound becomes -1 due to the call to longValue
    /**
                Long val = (Long) value;
                }
        private final Parameter<Boolean> skiplist = new Parameter<>(
                        dvQuery
            @Override
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, v);
                            NumericUtils.doubleToSortableLong(l),
                boolean includeUpper,
    }
            }
                }
                    );
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
                if (roundUp) {
                double parsed = objectToDouble(value);
import org.apache.lucene.util.BytesRef;
                    Query query = IntPoint.newExactQuery(field, v);
            }
        INTEGER("integer", NumericType.INT) {
                boolean docValued,
                boolean docValued,
            long u = Long.MAX_VALUE;
            false,
                    return new IndexOrDocValuesQuery(
            Number valueForSearch(String value) {
                });
                builder.coerce.getValue().value(),
                if (hasDocValues) {
            @Override
                }
                }
                    v = Arrays.copyOf(v, upTo);
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());
                    Query query = BigIntegerPoint.newExactQuery(field, v);
import org.opensearch.search.DocValueFormat;
            } catch (JsonParseException | IllegalArgumentException e) {
            ) {
 */
                    fields.add(new StoredField(name, value.doubleValue()));
                return Double.parseDouble(value);
            if (number instanceof String stringValue) {
            public byte[] encodePoint(Number value) {
            this.nullValue = new Parameter<>(
        public static double objectToDouble(Object value) {
                double doubleValue = numberValue.doubleValue();
        private final boolean skiplist;
                byte[] point = new byte[BigIntegerPoint.BYTES];
            }
                m -> toType(m).nullValue
                    } else {
                }
            boolean indexed,
                }
                return BigIntegerPoint.newExactQuery(field, v);
        /**
                return DoublePoint.decodeDimension(value, 0);
                } else {
                // - if the bound is positive then we increment it:
                        l = HalfFloatPoint.nextDown(l);
         * Converts and Object to a {@code long} by checking it against known
                }
            }
                final float result;
     * <p>
            } else {
                if ((upperTermHasDecimalPart == false && includeUpper == false) || (upperTermHasDecimalPart && signum(upperTerm) < 0)) {
        }
            MappedFieldType ft = new NumberFieldType(buildFullName(context), this);
                }
                    );
            private void validateParsed(double value) {
                doubleValue = Double.parseDouble(bytesRef.utf8ToString());
 * You may obtain a copy of the License at
            @Override
                        v[upTo++] = parse(value, true);
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
            @Override
                                NumericUtils.floatToSortableInt(u),
            this.ignoreMalformed = Parameter.explicitBoolParam(
            double doubleValue;
        public NumberType numberType() {
        }
            }
                boolean skiplist,
                    return new IndexOrDocValuesQuery(query, dvQuery);
                        v[upTo++] = parse(value, true);
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
                return switch (type) {
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
        private final NumericType numericType;
        DOUBLE("double", NumericType.DOUBLE) {
 * SPDX-License-Identifier: Apache-2.0
            public byte[] encodePoint(Object value, boolean roundUp) {
            @Override
                }
            );
            public BigInteger parse(Object value, boolean coerce) {
        public Query termQuery(Object value, QueryShardContext context) {
            @Override
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
                            );
 */
                        }
import org.apache.lucene.sandbox.document.HalfFloatPoint;
                if (upTo == 0) {
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
            private void validateParsed(float value) {
        }
            return type.parsePoint(value);
            double doubleValue = objectToDouble(value);
         */
                if (docValued) {
                float[] v = new float[values.size()];
                            query = pointRangeQuery;
            }
        this.nullValue = builder.nullValue.getValue();
                    if (u.compareTo(Numbers.MAX_UNSIGNED_LONG_VALUE) == 0) {
 * specific language governing permissions and limitations
                false,
            Query query = type.rangeQuery(
                        ? SortedNumericDocValuesField.newSlowRangeQuery(
        }
                if (isSearchable && hasDocValues) {
        @Override
                }
                }
    @Override
                return (double) value;
                if (!coerce && doubleValue % 1 != 0) {
            Object lowerTerm,
                    return Queries.newMatchNoDocsQuery("Value [" + value + "] has a decimal part");
                if (stored) {
            }
     * Builder for the number field mappers
    protected String contentType() {
        private final Parameter<Explicit<Boolean>> coerce;
        return coerce.value();
                }
                for (int i = 0; i < values.size(); ++i) {
                    );
                return parsed;
            if (lowerTerm != null) {
            public Query rangeQuery(
     * Type of number
            public byte[] encodePoint(Number value) {
            if (l.compareTo(u) > 0) {
                QueryShardContext context
                    dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(field, l, u, dvQuery);
                    }
                        return SortedUnsignedLongDocValuesRangeQuery.newSlowRangeQuery(field, l, u);
                    Query query = FloatPoint.newExactQuery(field, v);
                doubleValue = number.doubleValue();
            }
            @Override
        if (value == null) {
        },
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
                if (value instanceof Number number) {
        ) {
                if (hasDocValues) {
                    ? SortedNumericDocValuesField.newSlowRangeQuery(
         */
        }
                return type.valueForSearch(stringValue);
                        DoublePoint.newSetQuery(field, v),
                            field,
                context
                if (hasDocValues) {
                return encodePoint(numericValue);
                boolean indexed,
            return new SortedNumericIndexFieldData.Builder(name(), type.numericType());
import org.opensearch.common.lucene.Lucene;
                double doubleValue = objectToDouble(value);
                value = bytesRef.utf8ToString();
                }
            @Override
                    return new IndexOrDocValuesQuery(query, dvQuery);
                return (int) doubleValue;
            }
                List<Field> fields = new ArrayList<>();
        return (NumberFieldType) super.fieldType();
                if (lowerTerm != null) {
                FloatPoint.encodeDimension(value.floatValue(), point, 0);
                int upTo = 0;
                boolean includeLower,
                boolean docValued,
            }
                try {
            if (upperTerm != null) {
                return Short.parseShort(value);
                String field,
            }
                name(),
                        return new MatchNoDocsQuery();
            }
            ) {
            return this;
    public static final Setting<Boolean> COERCE_SETTING = Setting.boolSetting("index.mapping.coerce", true, Property.IndexScope);
    @Override
            Number valueForSearch(String value) {
                    );
                boolean indexed,
                    v[i] = parse(values.get(i), false);
    @Override
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
                return type.valueForSearch((Number) value);
        public static Builder docValuesOnly(String name, NumberType type) {
                        NumericUtils.floatToSortableInt(l),
                return INTEGER.termQuery(field, value, hasDocValues, isSearchable);
         * types and checking its range.
            ) {
        this.skiplist = builder.skiplist.getValue();
            public Query rangeQuery(
        Number value;
                }
                return BigIntegerPoint.decodeDimension(value, 0);
                    return number.shortValue();
                return INTEGER.createFields(name, value, indexed, docValued, skiplist, stored);
                return value.byteValue();
                QueryShardContext context
                        }
                boolean docValued,
                if (isSearchable && hasDocValues) {
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
                if (hasDocValues) {
                throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
            @Override
            throw new IllegalArgumentException("Field [" + name + "] of type [" + typeName() + "] does not support bitmap queries");
 * GitHub history for details.
                            new ApproximatePointRangeQuery(
                    return new IndexOrDocValuesQuery(query, dvQuery);
            if (format == null) {
                }
                return INTEGER.createFields(name, value, indexed, docValued, skiplist, stored);
                // if lowerTerm=-1.5 then the (inclusive) bound becomes -1 due to the call to longValue
                builder.indexed.getValue(),
                    v = Arrays.copyOf(v, upTo);
                    return Queries.newMatchNoDocsQuery("Value [" + value + "] has a decimal part");
            }
    }
            return;
            Object upperTerm,
                            new ApproximatePointRangeQuery(
                boolean hasDocValues,
            }
                Object upperTerm,
                    } else {
                return parser.intValue(coerce);
            }
                }
                            query = pointRangeQuery;
            }
                        fields.add(SortedNumericDocValuesField.indexedField(name, value.intValue()));
                    return new IndexOrDocValuesQuery(
         */
                        }
                }
                boolean indexed,
            boolean skiplist,
            @Override
            @Override
                }
                    Object value = values.get(i);
            @Override
                        ++l;
                }
        }
            }
            @Override
                });
                    }
import org.opensearch.index.fielddata.IndexFieldData;
                            query,
            BiFunction<Long, Long, Query> builder
                u = objectToUnsignedLong(upperTerm, true);
    protected void parseCreateField(ParseContext context) throws IOException {
                    // ASC: exclusive lower bound
                String field,
        public static BigInteger objectToUnsignedLong(Object value, boolean coerce, boolean lenientBound) {
                    return BigIntegerPoint.newRangeQuery(field, l, u);
                            field,
                    if (numericValue > Byte.MIN_VALUE) {
                    } else {
            @Override
                    }
            ).acceptsNull();
        if (context.externalValueSet()) {
            public byte[] encodePoint(Number value) {
                    fields.add(new IntPoint(name, value.intValue()));
                    case FLOAT -> NumericUtils.sortableIntToFloat(val.intValue());
                    throw e;
                        numericValue = numericValue - 1;
                boolean includeUpper,
        return new DerivedFieldGenerator(mappedFieldType, new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()) {
            public List<Field> createFields(
                }
                    }
import org.opensearch.index.query.QueryShardContext;
    private final boolean hasDocValues;
                }
            }
public class NumberFieldMapper extends ParametrizedFieldMapper {
                        query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
                Short numericValue = parse(value, true);
            public Query rangeQuery(
            @Override
                        }
                boolean hasDocValues,
        }
                                APPROX_QUERY_NUMERIC_DIMS,
                ignoreMalformedByDefault
                }
            }
        @Override
            }
    }
    }
        }
        private final String name;
                }
                    return type.parse(value, coerce);
                    l = DoublePoint.nextUp(l);
            try {
                if (includeUpper == false) {
                String name,
        @Override
                String field,
                Query dvQuery = hasDocValues
            return query;
            }
        this.ignoreMalformed = builder.ignoreMalformed.getValue();
                    Query pointRangeQuery = IntPoint.newRangeQuery(field, l, u);
            }
         *
            }
                    l = parse(lowerTerm, false);
                }
            @Override
            return nullValue;
                isSearchable(),
        public static BigInteger objectToUnsignedLong(Object value, boolean coerce) {
        return ignoreMalformed;
            }
                        --u;
            @Override
                }
                    }
        }
                return longRangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, (l, u) -> {
         * Processes query bounds into {@code long}s and delegates the
 *
                String name,
                }
                    return SortedNumericDocValuesField.newSlowExactQuery(field, HalfFloatPoint.halfFloatToSortableShort(v));
            if (format != null) {
                    // DESC: exclusive upper bound
                Long numericValue = parse(value, true);
            }
                number = bytesRef.utf8ToString();
                if (value instanceof Number number) {
        }
    }
                float parsed = parser.floatValue(coerce);
                }
            public Short parse(XContentParser parser, boolean coerce) throws IOException {
            public byte[] encodePoint(Number value) {
                boolean lowerTermHasDecimalPart = hasDecimalPart(lowerTerm);
                        SortedNumericDocValuesField.newSlowSetQuery(field, points)
            if (value instanceof Number number) {
                    Query pointRangeQuery = FloatPoint.newRangeQuery(field, l, u);
            Number valueForSearch(Number value) {
                    if (skiplist) {
        }
    private static NumberFieldMapper toType(FieldMapper in) {
        @Override
                Float numericValue = parse(value, true);
            return false;
            @Override
                }
            value = nullValue;
            this.skiplist = skiplist;
                if (stored) {
import java.util.function.BiFunction;
        }
            public byte[] encodePoint(Object value, boolean roundUp) {
    private final boolean ignoreMalformedByDefault;
                    v = Arrays.copyOf(v, upTo);
            public List<Field> createFields(
            }
                }
                        query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
                                query = new IndexSortSortedNumericDocValuesRangeQuery(
package org.opensearch.index.mapper;
    @Override
                    throw new IllegalArgumentException("Failed to deserialize the 64-bit bitmap.", e);
            public Query rangeQuery(
import org.apache.lucene.search.IndexSortSortedNumericDocValuesRangeQuery;
                    numericValue = FloatPoint.nextUp(numericValue);
            super(name);
                return longValue;
                validateParsed(parsed);
                if (lowerTerm != null) {
                        );
                boolean includeLower,
                if (hasDecimalPart(value)) {
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                    return new IndexOrDocValuesQuery(query, dvQuery);
        }
                    boolean lowerTermHasDecimalPart = hasDecimalPart(lowerTerm);
                                ApproximatePointRangeQuery.UNSIGNED_LONG_FORMAT
                if (value instanceof Number number) {
                    if (hasDocValues) {
                }
                    return;
    /**
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"
                    return SortedUnsignedLongDocValuesSetQuery.newSlowSetQuery(field, v);
                builder.meta.getValue()
                validateParsed(parsed);
                BigInteger v = parse(value, true);
                    return SortedNumericDocValuesField.newSlowExactQuery(field, NumericUtils.floatToSortableInt(v));
                Object upperTerm,
    private final Explicit<Boolean> coerce;
                } else {
                if (isSearchable && hasDocValues) {
        }
                    }
                    if (context.indexSortedOnField(field)) {
                includeLower,
                    }
                        query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
            }
                    return new BitmapIndexQuery(field, bitmap);
            return type.numericType();
            }
                return Numbers.unsignedLongToDouble(value);
        @Override
                QueryShardContext context
        }
            BiFunction<Double, Double, Query> builder
                            )
        NumberType(String name, NumericType numericType) {
        }
                String field,
                double parsed = parser.doubleValue(coerce);
        public abstract Number parsePoint(byte[] value);
                boolean includeLower,
                for (int i = 0; i < values.size(); i++) {
                    return SortedNumericDocValuesField.newSlowSetQuery(field, v);
        },
import org.opensearch.index.document.SortedUnsignedLongDocValuesSetQuery;
            @Override
                return doubleRangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, (l, u) -> {
                    return null;
                Object upperTerm,
import java.math.BigInteger;
                    if (skiplist) {
                }
            (n, c, o) -> XContentMapValues.nodeBooleanValue(o),
                            FloatPoint.pack(l).bytes,
                    if (!hasDecimalPart(value)) {
                if (!coerce && doubleValue % 1 != 0) {
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
                    if (value instanceof BytesRef bytesRef) {
                        NumericUtils.floatToSortableInt(l),
                includeUpper,
            return Numbers.toLong(stringValue, coerce);
                byte[] point = new byte[HalfFloatPoint.BYTES];
                Object lowerTerm,
            }
                            HalfFloatPoint.pack(u).bytes,
                BigInteger[] v = new BigInteger[values.size()];
 * software distributed under the License is distributed on an
            }
            boolean includeLower,
            }
                }
                    return dvQuery;
                if (hasDocValues) {
                boolean includeUpper,
                                LongPoint.pack(u).bytes,
                QueryShardContext context
import org.opensearch.common.Explicit;
            private void validateParsed(float value) {
            @Override
                HalfFloatPoint.encodeDimension(value.floatValue(), point, 0);
                    }
        @Override
                if (doubleValue < Numbers.MIN_UNSIGNED_LONG_VALUE.doubleValue()) {
                byte[] point = new byte[Long.BYTES];
            if (timeZone != null) {
         * Converts an Object to a double by checking it against known types first
            this.type = Objects.requireNonNull(type);
     *
                throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
            }
                }
                            HalfFloatPoint.pack(l).bytes,
                    return new IndexOrDocValuesQuery(query, dvQuery);
        public Builder(String name, NumberType type, boolean ignoreMalformedByDefault, boolean coerceByDefault) {
                    u = DoublePoint.nextDown(u);
                    if (dvQuery != null) {
                if (!Float.isFinite(value)) {
        public Query bitmapQuery(BytesArray bitmap) {
            return;
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
import org.opensearch.tools.jackson.core.JsonParseException;
                            IntPoint.pack(u).bytes,
                        }
                }
                if (isSearchable && hasDocValues) {
import org.apache.lucene.document.LongPoint;
        }
            }
            @Override
import java.io.DataInputStream;
                    bitmap.deserialize(ByteBuffer.wrap(bitmapArray.array()));
            }
                DoublePoint.encodeDimension(value.doubleValue(), point, 0);
            @Override
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
         * @param lenientBound if true, use MIN or MAX if the value is out of bound
import org.roaringbitmap.longlong.Roaring64NavigableMap;
                }
            @Override
                String field,
            }
                    );
            return value;
            @Override
        @Override
        this.indexed = builder.indexed.getValue();
            }
                if (isSearchable && hasDocValues) {
    protected Explicit<Boolean> ignoreMalformed() {
            QueryShardContext context
            Number valueForSearch(String value) {
        );
                    for (int i = 0; i < v.length; i++) {
                    numericValue = DoublePoint.nextDown(numericValue);
        }
            public byte[] encodePoint(Number value) {
                query = new BoostQuery(query, boost());
            return type.name;
            }
                return fields;
                Number value,
                        if (l == Integer.MAX_VALUE) {
                        points[i] = NumericUtils.doubleToSortableLong(v[i]);
                } else {
            public Query bitmapQuery(String field, BytesArray bitmapArray, boolean isSearchable, boolean hasDocValues) {
/*
import java.util.function.Function;
                boolean docValued,
                    if (!hasDecimalPart(value)) {
            "skip_list",
            @Override
                    v[i] = parse(values.get(i), false);
                if (isSearchable && hasDocValues) {
        }
            }
            if (number instanceof Number numberValue) {
                                field,
                        numericValue = numericValue + 1;
                    // DESC: exclusive upper bound
            }
                }
                (n, c, o) -> o == null ? null : type.parse(o, false),
                    result = number.floatValue();
            Map<String, String> meta
                if (roundUp) {
                    Query query = DoublePoint.newExactQuery(field, v);
        }
            if (upperTerm != null) {
                boolean upperTermHasDecimalPart = hasDecimalPart(upperTerm);
                        } else {
                    return number.intValue();
                float u = Float.POSITIVE_INFINITY;
import java.util.function.Supplier;
                if ((lowerTermHasDecimalPart == false && includeLower == false) || (lowerTermHasDecimalPart && signum(lowerTerm) > 0)) {
                }
                byte[] point = new byte[Float.BYTES];
            public byte[] encodePoint(Object value, boolean roundUp) {
            Number value,
        public Builder docValues(boolean hasDocValues) {
            }
            if (upperTerm != null) {
        public final TypeParser parser() {
                }
                    } else {
            @Override
                    u = HalfFloatPoint.nextDown(u);
                    Query dvQuery = SortedUnsignedLongDocValuesSetQuery.newSlowExactQuery(field, v);
                        IntPoint.newSetQuery(field, v),
                if (upperTerm != null) {
                }
                || doubleValue > Numbers.MAX_UNSIGNED_LONG_VALUE.doubleValue()) {
import java.util.Map;
                            APPROX_QUERY_NUMERIC_DIMS,
 * compatible open source license.
        @Override
            public List<Field> createFields(
                }
                        }
                            field,
                return INTEGER.parsePoint(value).shortValue();
            }
                if (roundUp) {
            public Object convert(Object value) {
                        return new MatchNoDocsQuery();
import org.opensearch.common.lucene.search.Queries;
                }
                                ApproximatePointRangeQuery.DOUBLE_FORMAT
        abstract Number valueForSearch(String value);
            }
            @Override
                }
            public double toDoubleValue(long value) {
            @Override
            ) {
                        );
         * Returns true if the object is a number and has a decimal part
                    return new IndexOrDocValuesQuery(new BitmapIndexQuery(field, bitmap), new BitmapDocValuesQuery(field, bitmap));
                                field,
                    dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(
            @Override
                        )
                }
            }
            return type.encodePoint(value);
                    return SortedNumericDocValuesField.newSlowSetQuery(field, points);
                        if (context.indexSortedOnField(field)) {
                    if (hasDocValues) {
            @Override
                return encodePoint(numericValue);
                }
/*
        /**
                    bitmap64.deserializePortable(new DataInputStream(new ByteArrayInputStream(bytes)));
import org.apache.lucene.search.IndexOrDocValuesQuery;
            return new SourceValueFetcher(name(), context, nullValue) {
         * Get the associated numeric type
                            dvQuery
                    fields.add(new HalfFloatPoint(name, value.floatValue()));
                if (upTo == 0) {
                                field,
            }
                        return new ApproximateScoreQuery(
                    return SortedNumericDocValuesField.newSlowSetQuery(field, points);
        },
        public NumberFieldType(String name, NumberType type) {
                Double numericValue = parse(value, true);
                String name,
         * provided {@code builder} to build a range query.
                Number value,
        @Override
            boolean isSearchable,
                List<Field> fields = new ArrayList<>();
                }
                        } else {
                    --u;
            failIfNoDocValues();
                                field,
            }
            if (value == null) {
                return parser.longValue(coerce);
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
import org.opensearch.core.common.bytes.BytesArray;
                }
                boolean stored
                    if (includeLower) {
                Object upperTerm,
            @Override
                            Query dvQuery = SortedUnsignedLongDocValuesRangeQuery.newSlowRangeQuery(field, l, u);
                }
                                    query
import org.apache.lucene.document.IntPoint;
                double[] v = new double[values.size()];
                    dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(
        }
                    if (u == Long.MIN_VALUE) {
            }
    }
/**
                return Byte.parseByte(value);
                QueryShardContext context
            ) {
                    Query dvQuery = SortedNumericDocValuesField.newSlowSetQuery(field, points);
            public Float parse(Object value, boolean coerce) {
                Object upperTerm,
        }
import org.apache.lucene.sandbox.document.BigIntegerPoint;
            if (!coerce && doubleValue % 1 != 0) {
                return Long.parseLong(value);
                        field,
                throw new IllegalArgumentException(
                    } else {
                    numericValue = FloatPoint.nextDown(numericValue);
            @Override
            @Override
                    }
                                BigIntegerPoint.pack(l).bytes,
                return HalfFloatPoint.decodeDimension(value, 0);
        }
            } else {
                        return new MatchNoDocsQuery();
                Object lowerTerm,
                    l = parse(lowerTerm, true);
                if (value instanceof Number number) {
            public byte[] encodePoint(Number value) {
                long points[] = new long[v.length];
                Number value,
                }
            this.numericType = numericType;
            @Override
                    if (value.equals("")) {
                // if the lower bound is decimal:
                        query,
                Number value,
                    return Numbers.MIN_UNSIGNED_LONG_VALUE;
                }
        }
            boolean includeUpper,
                }
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
    }
                }
                }
            }
                    fields.add(new FloatPoint(name, value.floatValue()));
        return fieldType().type.typeName();
                if (isSearchable) {
                return null;
                    l = HalfFloatPoint.nextUp(l);
                    if (numericValue < Byte.MAX_VALUE) {
            ) {
            public byte[] encodePoint(Object value, boolean roundUp) {
            double doubleValue = objectToDouble(value);
                try {
            public double toDoubleValue(long value) {
            String name,
                        dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(
        public final NumericType numericType() {
                if (roundUp) {
import org.apache.lucene.document.StoredField;
                return fields;
                    }
        public abstract Number parse(XContentParser parser, boolean coerce) throws IOException;
                boolean skiplist,
                return point;
            @Override
                    result = Float.parseFloat(value.toString());
                boolean skiplist,
                } else {
    public NumberFieldType fieldType() {
                return LongPoint.decodeDimension(value, 0);
                return IntPoint.newExactQuery(field, v);
                    if (includeUpper) {
            public Short parse(Object value, boolean coerce) {
            @Override
                    }
            }
            public Query rangeQuery(
            }
            boolean coerce,
            @Override
                    if (l == Long.MAX_VALUE) {
            this(name, type, true, false, true, false, true, null, Collections.emptyMap());
                String name,
                double doubleValue = objectToDouble(value);
    @Override
        HALF_FLOAT("half_float", NumericType.HALF_FLOAT) {
                if (indexed) {
                double v = parse(value, false);
        @Override
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
            // this check does not guarantee that value is inside MIN_VALUE/MAX_VALUE because values up to 9223372036854776832 will
                Object lowerTerm,
            Object lowerTerm,
            public Float parse(XContentParser parser, boolean coerce) throws IOException {
            public Number parsePoint(byte[] value) {
                return HalfFloatPoint.sortableShortToHalfFloat((short) value);
            );
            return null;
                    );
                    case UNSIGNED_LONG -> Numbers.toUnsignedBigInteger(val);
                            if (context.indexSortedOnField(field)) {
        context.doc().addAll(fieldType().type.createFields(fieldType().name(), numericValue, indexed, hasDocValues, skiplist, stored));
                Byte numericValue = parse(value, true);
                        Query query;
            if (lowerTerm != null) {
            }
                    // if lowerTerm=1.5 then the (inclusive) bound becomes 2
                        field,
                            field,
                    throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
                }
        return value;
                boolean hasDocValues,
                                ApproximatePointRangeQuery.LONG_FORMAT
                Object lowerTerm,
 *    http://www.apache.org/licenses/LICENSE-2.0
                            query = new IndexOrDocValuesQuery(query, dvQuery);
 * ownership. Elasticsearch licenses this file to you under
            if (boost() != 1f) {
                        numericValue = (short) (numericValue + 1);
                if (hasDocValues) {
                    fields.add(new StoredField(name, value.longValue()));
            Number valueForSearch(String value) {
                }
                            ApproximatePointRangeQuery.HALF_FLOAT_FORMAT
                for (int i = 0; i < values.size(); i++) {
                    if (!hasDecimalPart(value)) {
            boolean hasDocValues,
                return NumericUtils.sortableIntToFloat((int) value);
                }
import org.opensearch.search.query.Bitmap64DocValuesQuery;
import org.apache.lucene.document.FloatPoint;
        }, new StoredFieldFetcher(mappedFieldType, simpleName()));
                int v = parse(value, true);
            public byte[] encodePoint(Object value, boolean roundUp) {
            Number valueForSearch(Number value) {
    boolean coerce() {
                return DoublePoint.newSetQuery(field, v);
        ) {
                boolean includeLower,
                return fields;
                if (isSearchable && hasDocValues) {
        public Query bitmapQuery(String field, BytesArray bitmap, boolean isSearchable, boolean hasDocValues) {
                QueryShardContext context
        /**
            @Override
                }
                }
                byte[] point = new byte[Integer.BYTES];
            String stringValue = (value instanceof BytesRef bytesRef) ? bytesRef.utf8ToString() : value.toString();
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for a byte");
            if (value instanceof Number number) {
                    }
                float l = Float.NEGATIVE_INFINITY;
        Number numericValue = getFieldValue(context);
            boolean includeLower,
                    builder.array(simpleName, displayValues);
import org.opensearch.core.xcontent.XContentBuilder;
            @Override
                    }
                long v = parse(value, true);
                    for (int i = 0; i < values.size(); i++) {
        BYTE("byte", NumericType.BYTE) {
            @Override
            @Override
                    throw new IllegalArgumentException("[half_float] supports only finite values, but got [" + value + "]");
            // Unsigned long is sorted according to it's long value, as it is getting ingested as long, so we need to
            }
import org.opensearch.index.IndexSettings;
                        value = bytesRef.utf8ToString();
            Number valueForSearch(String value) {
            }
            failIfNotIndexedAndNoDocValues();
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, NumericUtils.floatToSortableInt(v));
                    if (numericValue > Integer.MIN_VALUE) {
                    case DOUBLE -> NumericUtils.sortableLongToDouble(val);
                }
    }
                boolean includeLower,
                        Query query = BigIntegerPoint.newRangeQuery(field, l, u);
        public NumberFieldMapper build(BuilderContext context) {
import org.apache.lucene.search.MatchNoDocsQuery;
            String field,
        }
        public NumericType numericType() {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                }
            return name;
            public Number parsePoint(byte[] value) {
            @Override
            }
                // if lowerTerm=1.5 then the (inclusive) bound becomes 2
            }
            @Override
                return IntPoint.newSetQuery(field, v);
                    fields.add(new BigIntegerPoint(name, v));
                        numericValue = (short) (numericValue - 1);
                QueryShardContext context
                } else {
            boolean includeUpper,
                    l = l.add(BigInteger.ONE);
                // if lowerTerm=1.5 then the (inclusive) bound becomes 2
                    result = number.floatValue();
        public static Query unsignedLongRangeQuery(
            public Query bitmapQuery(String field, BytesArray bitmapArray, boolean isSearchable, boolean hasDocValues) {
                // Note: bitmap64 instance is safely shared between queries as both perform read-only operations
            Builder builder = new Builder(name, type, false, false);
                    fields.add(new StoredField(name, value.floatValue()));
import org.apache.lucene.document.SortedNumericDocValuesField;
            }
                }
import org.opensearch.common.xcontent.support.XContentMapValues;
     * @opensearch.internal
                    }
                float u = Float.POSITIVE_INFINITY;
                        if (context.indexSortedOnField(field)) {
                return new MatchNoDocsQuery();
            boolean includeUpper,
 * KIND, either express or implied.  See the License for the
                return dvQuery;
                u = objectToDouble(upperTerm);
        }
                long points[] = new long[v.length];
                return FloatPoint.newExactQuery(field, v);
                if (values.isEmpty()) {
            value = nullValue;
                float v = parse(value, false);
                Object lowerTerm,
                            ApproximatePointRangeQuery.FLOAT_FORMAT
                    }
                throw new IllegalArgumentException("Value [" + value + "] is out of range for an unsigned long");
