                    result = number.floatValue();
                }
                "ignore_malformed",
                    }
            Map<String, String> meta  
            }
                int[] v = new int[values.size()];
                        }  
        /**
                                field,
                        if (dvQuery != null) {
                    } else {
            NumberType type,
                boolean isSearchable,  
                    result = Float.parseFloat(value.toString());
            return value;
                boolean upperTermHasDecimalPart = hasDecimalPart(upperTerm);  
import org.opensearch.common.lucene.Lucene;
                        HalfFloatPoint.halfFloatToSortableShort(u),
        public String typeName() {
                return INTEGER.rangeQuery(field, lowerTerm, upperTerm, includeLower, includeUpper, hasDocValues, isSearchable, context);
            }
                return encodePoint(numericValue);  
            public Query rangeQuery(
                        NumericUtils.floatToSortableInt(l),
        public static long objectToLong(Object value, boolean coerce) {
            @Override  
                false,
                boolean hasDocValues,
            }
                        dvQuery
         */
        public byte[] encodePoint(Object value, boolean roundUp) {
                boolean docValued,  
            return Numbers.toUnsignedLong(stringValue, coerce);
            }
                }
        }  
                        )
                    return new IndexOrDocValuesQuery(query, dvQuery);
 * compatible open source license.
                // Always apply exclusivity
                    return new IndexOrDocValuesQuery(query, dvQuery);
                    }  
            BiFunction<BigInteger, BigInteger, Query> builder  
         * Converts and Object to a {@code long} by checking it against known
            }  
            } else if (value instanceof BytesRef bytesRef) {
                List<Field> fields = new ArrayList<>();
    @Override
                if (roundUp) {
            failIfNotIndexedAndNoDocValues();
            if (lowerTerm != null) {
                return objectToDouble(value);
            }
                return doubleRangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, (l, u) -> {
                    Query pointRangeQuery = IntPoint.newRangeQuery(field, l, u);
            return type.encodePoint(value, roundUp);  
                value = bytesRef.utf8ToString();  
                    if (skiplist) {  
                if (indexed) {  
                    }
                    fields.add(new LongPoint(name, value.longValue()));
        }
                }  
/*  
            }
import org.apache.lucene.search.IndexOrDocValuesQuery;
                        );
                    fields.add(new StoredField(name, value.floatValue()));
                    }
        public Builder docValues(boolean hasDocValues) {
                Number value,
                // Extract bytes safely
            public byte[] encodePoint(Number value) {
                byte[] point = new byte[Integer.BYTES];
 * KIND, either express or implied.  See the License for the
        public static double signum(Object value) {  
                float u = Float.POSITIVE_INFINITY;
        }
        XContentParser parser = context.parser();
            }  
                    Query dvQuery = hasDocValues ? SortedNumericDocValuesField.newSlowRangeQuery(field, l, u) : null;
                            if (context.indexSortedOnField(field)) {  
                Object lowerTerm,  
            this.numericType = numericType;
            public byte[] encodePoint(Object value, boolean roundUp) {
                }
                    // ASC: exclusive lower bound
            if (upperTerm != null) {
        public NumericType numericType() {  
                Object lowerTerm,
                    result = number.floatValue();  
    }  
                                HalfFloatPoint.halfFloatToSortableShort(u),  
                return INTEGER.rangeQuery(field, lowerTerm, upperTerm, includeLower, includeUpper, hasDocValues, isSearchable, context);
        this.ignoreMalformedByDefault = builder.ignoreMalformed.getDefaultValue().value();  
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
            }  
            @Override
            if (lenientBound) {
            @Override
                }
            }  
            if (!coerce && doubleValue % 1 != 0) {
                if (value instanceof Number number) {
                }
                List<Field> fields = new ArrayList<>();
                DoublePoint.encodeDimension(value.doubleValue(), point, 0);  
                            );
                    }
            @Override  
import org.opensearch.index.document.SortedUnsignedLongDocValuesRangeQuery;
                if (stored) {
        @Override  
            }
                BigInteger numericValue = parse(value, true);
                }
    private final boolean indexed;  
            builder.indexed.setValue(false);  
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for a byte");
                // if lowerTerm=-1.5 then the (inclusive) bound becomes -1 due to the call to longValue
 *
                if ((lowerTermHasDecimalPart == false && includeLower == false) || (lowerTermHasDecimalPart && signum(lowerTerm) > 0)) {
        public Function<byte[], Number> pointReaderIfPossible() {
import org.apache.lucene.document.LongPoint;
import java.util.function.Function;
            @Override  
            return Numbers.toLong(stringValue, coerce);
                int upTo = 0;
                }  
import org.apache.lucene.util.BytesRef;  
                return INTEGER.createFields(name, value, indexed, docValued, skiplist, stored);
                if (ignoreMalformed.value() && parser.currentToken().isValue()) {
            public Query rangeQuery(
                    if (includeUpper) {
                for (int i = 0; i < values.size(); i++) {
            MappedFieldType ft = new NumberFieldType(buildFullName(context), this);
                Object lowerTerm,
                        field,
import org.roaringbitmap.RoaringBitmap;
                }
        @Override  
                l = objectToLong(lowerTerm, true);  
                }  
                                APPROX_QUERY_NUMERIC_DIMS,
            @Override  
     * Field type for numeric fields
                    }
        public final String typeName() {  
                    if ((upperTermHasDecimalPart == false && includeUpper == false) || (upperTermHasDecimalPart && signum(upperTerm) < 0)) {
    }
import org.opensearch.search.query.Bitmap64IndexQuery;
import java.nio.ByteBuffer;
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
            }
                validateParsed(parsed);  
                if (!Double.isFinite(value)) {  
                validateParsed(parsed);
    public static class NumberFieldType extends SimpleMappedFieldType implements NumericPointEncoder, FieldValueConverter {
        public Number parsePoint(byte[] value) {
        @Override
                            field,  
                hasDocValues(),
                    l = HalfFloatPoint.nextUp(l);
                boolean upperTermHasDecimalPart = hasDecimalPart(upperTerm);
            public byte[] encodePoint(Number value) {
                float parsed = parser.floatValue(coerce);
                            )
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);
                // if lowerTerm=-1.5 then the (inclusive) bound becomes -1 due to the call to longValue
import java.util.function.Supplier;  
            public Query rangeQuery(
                return dvQuery;
        } else if (parser.currentToken() == Token.VALUE_NULL) {  
            @Override
                boolean stored  
                if (hasDocValues) {
                boolean includeLower,
                    return SortedNumericDocValuesField.newSlowExactQuery(field, v);  
            return this;  
                boolean hasDocValues,
                if (indexed) {
            return type.name;  
                if (upTo == 0) {
                            query = pointRangeQuery;  
            Object lowerTerm,
                long points[] = new long[v.length];  
                String field,
            );  
        return fieldType().type.typeName();
        abstract Number valueForSearch(String value);
                }
                    }  
        ) {
    boolean coerce() {
         *
    /**  
                    return SortedNumericDocValuesField.newSlowExactQuery(field, NumericUtils.floatToSortableInt(v));  
            if (timeZone != null) {  
                for (int i = 0; i < values.size(); ++i) {
                        query,  
import org.opensearch.tools.jackson.core.JsonParseException;
            public Short parse(XContentParser parser, boolean coerce) throws IOException {
                Object upperTerm,
                    Query dvQuery = SortedNumericDocValuesField.newSlowSetQuery(field, points);  
                }  
                double parsed = parser.doubleValue(coerce);
                return point;
                    case DOUBLE -> NumericUtils.sortableLongToDouble(val);  
            @Override  
            return new NumberFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), this);
                } else {
                        }  
            this.name = name;
                    if (hasDocValues) {  
 * this work for additional information regarding copyright
     * @opensearch.internal  
                    return Queries.newMatchNoDocsQuery("Value [" + value + "] has a decimal part");
                Number value,
                    builder.array(simpleName, displayValues);
                includeLower,  
                    }
                    }  
                }  
import org.opensearch.search.query.BitmapIndexQuery;  
        SHORT("short", NumericType.SHORT) {
                    Query pointRangeQuery = HalfFloatPoint.newRangeQuery(field, l, u);
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for a short");
                return (double) value;  
            public Query termsQuery(String field, List<Object> values, boolean hasDocvalues, boolean isSearchable) {
                true,  
                    Query query;
                            if (context.indexSortedOnField(field)) {
    protected String contentType() {
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());
                if (hasDocvalues) {
                }
            }  
                    return new IndexOrDocValuesQuery(query, dvQuery);  
                boolean stored
                            IntPoint.pack(u).bytes,
                boolean docValued,  
                    return;  
                        fields.add(SortedNumericDocValuesField.indexedField(name, v.longValue()));
                        HalfFloatPoint.halfFloatToSortableShort(u)  
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
                    fields.add(new IntPoint(name, value.intValue()));  
                    v[i] = parse(values.get(i), false);
                Object lowerTerm,  
import org.opensearch.common.xcontent.support.XContentMapValues;  
                    }
        public static double objectToDouble(Object value) {
import org.opensearch.common.settings.Setting;  
            }
    }
        public byte[] encodePoint(Number value) {  
            return nullValue;  
                            ApproximatePointRangeQuery.INT_FORMAT  
                boolean hasDocValues,
            public Query bitmapQuery(String field, BytesArray bitmapArray, boolean isSearchable, boolean hasDocValues) {  
                if (value instanceof Number number) {
                    : null;
                query = new BoostQuery(query, boost());
            @Override  
            }  
     */
        }  
        }  
            }
        public static BigInteger objectToUnsignedLong(Object value, boolean coerce) {
                }
            ) {  
                return value.byteValue();  
            }
                boolean skiplist,
                    );
            public byte[] encodePoint(Number value) {  
                        } else {
                    }
            // longs need special handling so we don't lose precision while parsing
                if (docValued) {
        /**  
            return;
                }  
                IntPoint.encodeDimension(value.intValue(), point, 0);
                    if (includeLower == false) {  
                Object lowerTerm,  
                );  
                if (context.indexSortedOnField(field)) {
                        numericValue = (byte) (numericValue - 1);
                    if (context.indexSortedOnField(field)) {
                return HalfFloatPoint.decodeDimension(value, 0);
                return parsed;  
            }
            Number nullValue,
                return this::parsePoint;  
        public abstract List<Field> createFields(
                    Query query = BigIntegerPoint.newSetQuery(field, v);  
            this.nullValue = nullValue;  
                    l = parse(lowerTerm, true);
                return result;
                byte[] point = new byte[HalfFloatPoint.BYTES];  
            }
                }  
                boolean indexed,
     *
        private final Parameter<Boolean> skiplist = new Parameter<>(  
            Query query = type.rangeQuery(
                        SortedNumericDocValuesField.newSlowSetQuery(field, points)  
                double parsed = objectToDouble(value);
            return type.encodePoint(value);
        }  
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {  
        ) {
            return builder.apply(l, u);
                    throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
                            ApproximatePointRangeQuery.HALF_FLOAT_FORMAT
         * provided {@code builder} to build a range query.
    @Override  
            @Override
            return type.toDoubleValue(value);
                Double numericValue = parse(value, true);  
            }  
 */  
        public Builder(String name, NumberType type, Settings settings) {
                            return new MatchNoDocsQuery();  
            failIfNotIndexedAndNoDocValues();
                    l = l.add(BigInteger.ONE);
                        if (context.indexSortedOnField(field)) {  
            }
                    if (u.compareTo(Numbers.MAX_UNSIGNED_LONG_VALUE) == 0) {
    private static NumberFieldMapper toType(FieldMapper in) {
                return INTEGER.parsePoint(value).shortValue();
                    } else {
                boolean indexed,
                @Override  
            ) {
                }
            public Double parse(Object value, boolean coerce) {
        },
                    return dvQuery;  
                if (type == NumberType.UNSIGNED_LONG) {  
                }  
                }  
                                DoublePoint.pack(l).bytes,  
            }  
            ) {  
                            query = new IndexSortSortedNumericDocValuesRangeQuery(  
                }
        },
                return new BigInteger(value);
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
        public Object valueForDisplay(Object value) {  
                        Query pointRangeQuery = DoublePoint.newRangeQuery(field, l, u);
                    // ASC: exclusive lower bound  
            }
            "skip_list",
                            IntPoint.pack(l).bytes,  
                return result;
                }
                return Byte.parseByte(value);
            public Number parsePoint(byte[] value) {
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
            return new SourceValueFetcher(name(), context, nullValue) {
            @Override  
                float l = Float.NEGATIVE_INFINITY;  
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"
            Object lowerTerm,  
            }
                boolean docValued,
                if (docValued) {  
     *    1. When using doc values, for multi value field, result would be in sorted order
                if (upTo != v.length) {
                return INTEGER.termQuery(field, value, hasDocValues, isSearchable);
            }  
                        query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
            @Override
    private final boolean stored;
                if (isSearchable) {  
    private NumberFieldMapper(String simpleName, MappedFieldType mappedFieldType, MultiFields multiFields, CopyTo copyTo, Builder builder) {
                        return new MatchNoDocsQuery();  
            public List<Field> createFields(
                }
                            Query dvQuery = SortedUnsignedLongDocValuesRangeQuery.newSlowRangeQuery(field, l, u);
            }
                    l = DoublePoint.nextUp(l);
        checkStoredAndDocValuesForDerivedSource();  
        if (value == null) {
                    throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
                boolean skiplist,
                String name,  
                List<Field> fields = new ArrayList<>();
                long points[] = new long[v.length];  
                }
            return query;  
                if (stored) {  
                                NumericUtils.floatToSortableInt(l),  
                        return new ApproximateScoreQuery(
                    u = parse(upperTerm, false);
                boolean isSearchable,
                return INTEGER.createFields(name, value, indexed, docValued, skiplist, stored);
            if (number instanceof Number numberValue) {
                    }
                                APPROX_QUERY_NUMERIC_DIMS,
                    : null;
import org.opensearch.search.query.Bitmap64DocValuesQuery;  
                    return SortedNumericDocValuesField.newSlowSetQuery(field, points);
                                ApproximatePointRangeQuery.UNSIGNED_LONG_FORMAT
            BigInteger u = Numbers.MAX_UNSIGNED_LONG_VALUE;  
            return Math.signum(Double.parseDouble(value.toString()));
                    if (includeUpper == false) {  
            public Number parsePoint(byte[] value) {
    @Override
                return BigIntegerPoint.decodeDimension(value, 0);
                return parsed;
                return fields;  
                    fields.add(new FloatPoint(name, value.floatValue()));  
                        if (l == Integer.MAX_VALUE) {
                            }
                }
            @Override  
                        DoublePoint.newSetQuery(field, v),
                if ((upperTermHasDecimalPart == false && includeUpper == false) || (upperTermHasDecimalPart && signum(upperTerm) < 0)) {
                        points[i] = HalfFloatPoint.halfFloatToSortableShort(v[i]);
 *  
                    --u;  
                if (isSearchable && hasDocValues) {  
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, NumericUtils.doubleToSortableLong(v));
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
            return query;
                String name,
            boolean indexed,
            QueryShardContext context
import java.util.Optional;  
                boolean hasDocValues,
                    Object value = values.get(i);
        public static boolean hasDecimalPart(Object number) {
                }
            Number value,  
                    return new IndexOrDocValuesQuery(query, dvQuery);
            public byte[] encodePoint(Number value) {
     * 2. If doc_values is disabled in field mapping, then build source using stored field
                String name,  
                Object upperTerm,
                return parser.intValue(coerce);
                Number value,
                boolean isSearchable,
        }
        @Override  
            return Arrays.asList(indexed, hasDocValues, stored, skiplist, ignoreMalformed, coerce, nullValue, meta);
    }
        return new Builder(simpleName(), type, ignoreMalformedByDefault, coerceByDefault).init(this);
                    return new IndexOrDocValuesQuery(query, dvQuery);  
            @Override  
                        field,
                }
        public static Query longRangeQuery(
            }
            }  
                    }
         */
                        numericValue = numericValue + 1;
                        IntPoint.newSetQuery(field, v),
                float l = Float.NEGATIVE_INFINITY;
import java.util.Collections;
            public List<Field> createFields(
                return parsed;  
                boolean hasDocValues,
    public static final Setting<Boolean> COERCE_SETTING = Setting.boolSetting("index.mapping.coerce", true, Property.IndexScope);  
                boolean includeUpper,
                } else {
                }  
                                field,
                return unsignedLongRangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, (l, u) -> {  
            }  
                }
                if (!Float.isFinite(value)) {  
            this(
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {  
                return point;  
        public double toDoubleValue(long value) {
            ) {  
                }
                // if lowerTerm=1.5 then the (inclusive) bound becomes 2
    }  
                        return nullValue;  
                    bitmap64.deserializePortable(new DataInputStream(new ByteArrayInputStream(bytes)));
            }
                String name,  
                FloatPoint.encodeDimension(value.floatValue(), point, 0);  
            boolean hasDocValues,
            }
 * Unless required by applicable law or agreed to in writing,
                            APPROX_QUERY_NUMERIC_DIMS,
                    return new ApproximateScoreQuery(
                if (upTo == 0) {
            String stringValue = (value instanceof BytesRef bytesRef) ? bytesRef.utf8ToString() : value.toString();  
        @Override
                return value.shortValue();
            if (doubleValue < Long.MIN_VALUE || doubleValue > Long.MAX_VALUE) {
        @Override
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
            boolean includeLower,
                ignoreMalformedByDefault
            ) {
            boolean includeUpper,
                    );
            @Override
            public List<Field> createFields(
                boolean includeUpper,
                // - if the bound is negative then we leave it as is:
import java.io.DataInputStream;
    public enum NumberType implements NumericPointEncoder, FieldValueConverter {
    }
                int u = Integer.MAX_VALUE;  
            public Number parsePoint(byte[] value) {
import org.opensearch.core.xcontent.XContentParser;  
                            query = new IndexSortSortedNumericDocValuesRangeQuery(
                validateParsed(parsed);  
        };  
                        dvQuery
        protected FieldTypeCapabilities.Capability searchCapability() {
                if (roundUp) {
                        fields.add(SortedNumericDocValuesField.indexedField(name, NumericUtils.floatToSortableInt(value.floatValue())));
import org.opensearch.core.xcontent.XContentParser.Token;
                    numericValue = FloatPoint.nextUp(numericValue);
 * GitHub history for details.
            boolean skiplist,  
                        SortedNumericDocValuesField.newSlowSetQuery(field, points)  
            boolean includeUpper,  
                    return new IndexOrDocValuesQuery(new Bitmap64IndexQuery(field, bitmap64), new Bitmap64DocValuesQuery(field, bitmap64));
            public Query rangeQuery(  
                    if (hasDocValues) {  
                    }  
                    );
                if (context.indexSortedOnField(field)) {
                    if (numericValue < Short.MAX_VALUE) {
                if (isSearchable) {  
                BytesRef ref = bitmapArray.toBytesRef();
                    }
            failIfNotIndexedAndNoDocValues();  
            @Override  
                    fields.add(new BigIntegerPoint(name, v));
        }  
                    }
                for (int i = 0; i < values.size(); i++) {  
        ) {
            Number valueForSearch(String value) {
            }  
        private final String name;
            boolean includeLower,
                    if (numericValue > Integer.MIN_VALUE) {
import org.opensearch.common.settings.Settings;
                    Query query = FloatPoint.newExactQuery(field, v);
        /**  
                }
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
            @Override
                        dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(
                || doubleValue > Numbers.MAX_UNSIGNED_LONG_VALUE.doubleValue()) {
            String name,
            @Override  
 * A {@link FieldMapper} for numeric types: byte, short, int, long, float, double and unsigned long.  
            this.skiplist = skiplist;  
                Float numericValue = parse(value, true);  
            public Query rangeQuery(
public class NumberFieldMapper extends ParametrizedFieldMapper {
        public static Query unsignedLongRangeQuery(
            public Long parse(XContentParser parser, boolean coerce) throws IOException {
                // Note: bitmap64 instance is safely shared between queries as both perform read-only operations  
        /**
        @Override  
            if (lowerTerm != null) {
import org.opensearch.common.lucene.search.Queries;
                }
        public abstract Number parse(Object value, boolean coerce);  
                if (doubleValue < Numbers.MIN_UNSIGNED_LONG_VALUE.doubleValue()) {  
                double doubleValue = numberValue.doubleValue();  
        }
                boolean includeUpper,
                return (double) value;
        }
        }
                if (docValued) {  
                }
        public NumberFieldType(String name, NumberType type) {  
                    fields.add(new HalfFloatPoint(name, value.floatValue()));
         * Returns -1, 0, or 1 if the value is lower than, equal to, or greater than 0
            return name;
                try {  
                }  
            return type.numericType.equals(NumericType.UNSIGNED_LONG)
            boolean isSearchable,  
            @Override  
                }  
        /**
                if (hasDecimalPart(value)) {  
            return;
                return Numbers.unsignedLongToDouble(value);  
                return IntPoint.newExactQuery(field, v);  
                return (byte) doubleValue;  
                return doubleValue % 1 != 0;
        }
            public Number parsePoint(byte[] value) {  
                    if (numericValue.compareTo(Numbers.MIN_UNSIGNED_LONG_VALUE) > 0) {  
                    numericValue = DoublePoint.nextUp(numericValue);
            @Override
                                field,
                String name,
                    }
                return encodePoint(numericValue);
                }
                return (int) doubleValue;
import java.util.Map;
                    return new IndexOrDocValuesQuery(
                }  
                    Query query;  
    }  
                    }
                Number value,
                            NumericUtils.doubleToSortableLong(u),
     * @opensearch.internal  
import org.apache.lucene.search.Query;
                Number value,
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                }  
    }
            public BigInteger parse(Object value, boolean coerce) {
                }
                String field,
                return Numbers.toUnsignedBigInteger(longValue);
                }  
                RoaringBitmap bitmap = new RoaringBitmap();
            this.setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);     // allows number fields in significant text aggs - do we need this?
                }  
                    if (hasDocValues) {
                }
            public Float parse(XContentParser parser, boolean coerce) throws IOException {  
    private final boolean skiplist;  
            // Unsigned long is sorted according to it's long value, as it is getting ingested as long, so we need to  
                        }
                }
                }
                    if (!hasDecimalPart(value)) {
            @Override
            @Override
                final float result;
                    if (numericValue < Integer.MAX_VALUE) {  
                if (upTo != v.length) {
            );  
            createFieldNamesField(context);
                } else {
                    v = Arrays.copyOf(v, upTo);
    @Override  
                                query
                name(),  
                }
                return encodePoint(numericValue);  
            Query query = type.termsQuery(name(), values, hasDocValues(), isSearchable());
import org.apache.lucene.document.SortedNumericDocValuesField;  
import org.opensearch.common.Explicit;
                }
                }
            public Query rangeQuery(
            @Override  
                boolean hasDocValues,  
            if (boost() != 1f) {  
            }  
                byte[] point = new byte[Float.BYTES];
        this.coerce = builder.coerce.getValue();
            boolean coerce,
                    }
                                );  
                return dvQuery;
import java.util.ArrayList;  
        return new DerivedFieldGenerator(mappedFieldType, new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()) {
                }
import org.opensearch.common.Numbers;  
            }
                    if (numericValue > Short.MIN_VALUE) {  
        HALF_FLOAT("half_float", NumericType.HALF_FLOAT) {  
                long points[] = new long[v.length];
            public Float parse(Object value, boolean coerce) {
                if (hasDocValues) {  
        public NumberFieldType(  
                        new ApproximatePointRangeQuery(
        },
                    case BYTE, SHORT, INTEGER, LONG -> val;
                }  
                }
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, v);  
                boolean includeUpper,  
                boolean isSearchable,  
            @Override
            Number valueForSearch(String value) {
                    // - if the bound is negative then we leave it as is:  
                } catch (IOException e) {
                    return Queries.newMatchNoDocsQuery("Value [" + value + "] has a decimal part");
                String name,  
                    return;  
        return coerce.value();
                long[] v = new long[values.size()];
    }
            failIfNoDocValues();
                        Query query;  
        @Override
                    Query query = HalfFloatPoint.newExactQuery(field, v);
                return point;
            public Float parse(Object value, boolean coerce) {
         * types and checking its range.  
                    if (numericValue.compareTo(Numbers.MAX_UNSIGNED_LONG_VALUE) < 0) {
                if (type != NumberType.UNSIGNED_LONG) {
                    }
                }
        protected List<Parameter<?>> getParameters() {
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
                boolean skiplist,
            ) {
            if (value instanceof String stringValue) {
        }
            if (format != null) {
            }
            private void validateParsed(double value) {
            @Override
import java.util.Objects;
                        fields.add(SortedNumericDocValuesField.indexedField(name, value.longValue()));
                    return new IndexOrDocValuesQuery(new BitmapIndexQuery(field, bitmap), new BitmapDocValuesQuery(field, bitmap));
                return new Bitmap64DocValuesQuery(field, bitmap64);
                IntPoint.encodeDimension(value.intValue(), point, 0);  
            Number valueForSearch(String value) {
                        NumericUtils.floatToSortableInt(l),
                return objectToUnsignedLong(value, coerce);  
                        return SortedUnsignedLongDocValuesRangeQuery.newSlowRangeQuery(field, l, u);
            @Override  
                return LongPoint.newSetQuery(field, v);
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
                return LongPoint.newExactQuery(field, v);  
                        return new ApproximateScoreQuery(
            }
import org.apache.lucene.search.BoostQuery;
                validateParsed(result);
                        fields.add(new SortedNumericDocValuesField(name, HalfFloatPoint.halfFloatToSortableShort(value.floatValue())));  
                    throw new IllegalArgumentException("Failed to deserialize the 64-bit bitmap.", e);  
                String field,
                    return SortedNumericDocValuesField.newSlowExactQuery(field, v);
                                LongPoint.pack(l).bytes,
            public BigInteger parse(XContentParser parser, boolean coerce) throws IOException {
    }
        @Override
            }
            BiFunction<Double, Double, Query> builder  
                                query
                if (lowerTerm != null) {
                if (context.indexSortedOnField(field)) {  
                            NumericUtils.doubleToSortableLong(l),  
                            APPROX_QUERY_NUMERIC_DIMS,
        INTEGER("integer", NumericType.INT) {  
                    }
                byte[] point = new byte[Integer.BYTES];
        context.doc().addAll(fieldType().type.createFields(fieldType().name(), numericValue, indexed, hasDocValues, skiplist, stored));
            @Override  
            public Query rangeQuery(
                    case HALF_FLOAT -> HalfFloatPoint.sortableShortToHalfFloat(val.shortValue());
            }  
            boolean includeUpper,
        private final NumberType type;  
                if (stored) {
                if (hasDocValues) {
                }
                                BigIntegerPoint.pack(u).bytes,  
                float parsed = parser.floatValue(coerce);
                            FloatPoint.pack(l).bytes,  
    @Override  
            Object upperTerm,
                    }
                if (roundUp) {  
            long l = Long.MIN_VALUE;  
                boolean includeLower,  
                    // if lowerTerm=-1.5 then the (inclusive) bound becomes -1 due to the call to longValue
     * <p>  
                    return SortedUnsignedLongDocValuesSetQuery.newSlowSetQuery(field, v);
                if (doubleValue > Numbers.MAX_UNSIGNED_LONG_VALUE.doubleValue()) {  
            public byte[] encodePoint(Number value) {
import org.apache.lucene.sandbox.document.HalfFloatPoint;  
            private void validateParsed(float value) {
            @Override
        );
/*
                        LongPoint.newSetQuery(field, v),  
import org.opensearch.search.query.BitmapDocValuesQuery;
            public byte[] encodePoint(Number value) {  
                            HalfFloatPoint.pack(u).bytes,  
        Builder nullValue(Number number) {
                        return new MatchNoDocsQuery();
            public Integer parse(Object value, boolean coerce) {
                if (values.size() == 1) {
                }  
                    bitmap.deserialize(ByteBuffer.wrap(bitmapArray.array()));
                m -> toType(m).ignoreMalformed,
                return Float.parseFloat(value);
        public abstract Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable);
                }  
                return (short) doubleValue;  
                Query dvQuery = hasDocValues ? SortedNumericDocValuesField.newSlowRangeQuery(field, l, u) : null;
            }
                Query dvQuery = hasDocValues
    private final boolean ignoreMalformedByDefault;
                return fields;  
        public final NumericType numericType() {
                        Query query;
                    );
                });
                        fields.add(
                return fields;
            public double toDoubleValue(long value) {
            }  
                boolean skiplist,
                    } else {
                }
                } else {
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {  
                        points[i] = NumericUtils.doubleToSortableLong(v[i]);  
                            new ApproximatePointRangeQuery(
                return INTEGER.termsQuery(field, values, hasDocValues, isSearchable);
                    }
            double u = Double.POSITIVE_INFINITY;  
            }
        }
                }
                int v = parse(value, true);  
                            NumericUtils.doubleToSortableLong(l),
                        SortedNumericDocValuesField.newSlowSetQuery(field, points)  
                }
                    fields.add(new StoredField(name, v.toString()));
                } catch (Exception e) {
                return (short) value;
                }
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.StoredField;
            return builder;
                return BigIntegerPoint.newSetQuery(field, v);
                        )  
                if (upperTerm != null) {
            boolean skiplist,  
                return type.valueForSearch(stringValue);
            public byte[] encodePoint(Number value) {
                    }  
                    } else {
                Object upperTerm,
     *       compared to stored field(stored as float)
 * this file be licensed under the Apache-2.0 license or a
            return FieldTypeCapabilities.Capability.POINT_RANGE;
                Float numericValue = parse(value, true);
                IntPoint.encodeDimension(value.intValue(), point, 0);
        }  
                protected Object parseSourceValue(Object value) {
                Query dvQuery = hasDocValues
                    fields.add(new StoredField(name, value.intValue()));
                    if (hasDocValues) {
import org.opensearch.index.compositeindex.datacube.DimensionType;  
            ) {
                if (isSearchable && hasDocValues) {  
            @Override  
                    return number.byteValue();  
            }
            public Float parse(XContentParser parser, boolean coerce) throws IOException {
                }  
                return parser.bigIntegerValue(coerce);
            @Override
            }  
                return HalfFloatPoint.newSetQuery(field, v);  
                    u = parse(upperTerm, false);
            public Object convert(Object value) {
                if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                    }
            return fieldType().type.parse(context.externalValue(), coerce.value());
            }
            }
            @Override
                            field,
                    } else {  
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {  
            // sort it again as per its unsigned long value to keep the behavior consistent
                u = objectToLong(upperTerm, true);  
            public byte[] encodePoint(Object value, boolean roundUp) {
            }
            }
                if (value instanceof Number number) {
                if (indexed) {
            @Override
                if (hasDecimalPart(value)) {
            public Number parsePoint(byte[] value) {
                    v[i] = parse(values.get(i), false);
            ) {
                                    query
            if (boost() != 1f) {
                    u = parse(upperTerm, true);
        this.type = builder.type;
            public Double parse(XContentParser parser, boolean coerce) throws IOException {  
            @Override
                if (includeLower == false) {  
                    u = DoublePoint.nextDown(u);
        /**
            long u = Long.MAX_VALUE;
                List<Field> fields = new ArrayList<>();
            @Override
                    return Queries.newMatchNoDocsQuery("All values have a decimal part");
                }  
                        fields.add(new SortedNumericDocValuesField(name, value.intValue()));  
                    }
            @Override
                        v[upTo++] = parse(value, true);
            @Override
import org.apache.lucene.search.MatchNoDocsQuery;
                builder.nullValue.getValue(),
                    if (skiplist) {  
         * Converts an Object to a {@code BigInteger} by checking it against known  
                Long numericValue = parse(value, true);
                        return new MatchNoDocsQuery();
            public Number parsePoint(byte[] value) {
            }
            }
                if (hasDocValues) {  
                BigInteger[] v = new BigInteger[values.size()];  
                    boolean lowerTermHasDecimalPart = hasDecimalPart(lowerTerm);
            public double toDoubleValue(long value) {
            if (number instanceof BytesRef bytesRef) {  
                }  
                    if (numericValue > Byte.MIN_VALUE) {
            Object upperTerm,  
                        v[upTo++] = parse(value, true);  
        context.documentInput().addField(fieldType(), numericValue);  
                    if (skiplist) {  
                        numericValue = (short) (numericValue + 1);  
                if ((upperTermHasDecimalPart == false && includeUpper == false) || (upperTermHasDecimalPart && signum(upperTerm) < 0)) {
            }  
            @Override
                if (hasDocValues) {  
                    }
                if (!coerce && doubleValue % 1 != 0) {
                }
            public Query rangeQuery(
                Number value,
            if (doubleValue < Numbers.MIN_UNSIGNED_LONG_VALUE.doubleValue()
                    } else {
                        );
                            new ApproximatePointRangeQuery(  
                    return Numbers.MAX_UNSIGNED_LONG_VALUE;
        if (hasDocValues == false && (stored || indexed)) {
                : Optional.of(DimensionType.NUMERIC);  
                    );  
                if (stored) {  
                    // DESC: exclusive upper bound
        public Query termQuery(Object value, QueryShardContext context) {
                if (hasDocValues) {
                    Query pointRangeQuery = FloatPoint.newRangeQuery(field, l, u);
import org.opensearch.index.IndexSettings;
 */  
                int l = Integer.MIN_VALUE;
                }
        public static BigInteger objectToUnsignedLong(Object value, boolean coerce, boolean lenientBound) {
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;  
                }
                    return SortedNumericDocValuesField.newSlowSetQuery(field, points);
                    } else {
                if (stored) {  
            return null;
                    return new ApproximateScoreQuery(
                        FloatPoint.newSetQuery(field, v),
                boolean hasDocValues,
                        displayValues[i] = (BigInteger) convert(values.get(i));
            public Short parse(Object value, boolean coerce) {
            @Override  
            return type;  
        public abstract Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable);  
         * Get the associated numeric type
     */
                        HalfFloatPoint.halfFloatToSortableShort(l),  
                    boolean upperTermHasDecimalPart = hasDecimalPart(upperTerm);  
                            FloatPoint.pack(u).bytes,
            if (lowerTerm != null) {
 * SPDX-License-Identifier: Apache-2.0
    }
                u = objectToUnsignedLong(upperTerm, true);
                    throw e;  
import org.opensearch.index.query.QueryShardContext;
                    );
            double doubleValue = objectToDouble(value);
                boolean isSearchable,
            ) {
            }  
                        v[upTo++] = parse(value, true);  
                return type.valueForSearch((Number) value);
                boolean docValued,  
                throw new IllegalArgumentException("Value [" + value + "] has a decimal part");  
        },
                } else {  
            public double toDoubleValue(long value) {
                if (values.isEmpty()) {
                if (isSearchable && hasDocValues) {
        this.coerceByDefault = builder.coerce.getDefaultValue().value();
        }
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for a byte");
            }
                if (roundUp) {
                return longRangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, (l, u) -> {  
                }  
                int value = parser.intValue(coerce);  
                Object lowerTerm,  
                });
                    )
                    }
            Number valueForSearch(String value) {
                boolean lowerTermHasDecimalPart = hasDecimalPart(lowerTerm);  
                    }  
 * license agreements. See the NOTICE file distributed with
                builder.meta.getValue()
                QueryShardContext context
                    );
                // if lowerTerm=1.5 then the (inclusive) bound becomes 2  
            this.coerce = coerce;
            }
            }
            this.parser = new TypeParser((n, c) -> new Builder(n, this, c.getSettings()));  
                return NumericUtils.sortableLongToDouble(value);
                } else {  
            @Override
                if (hasDocValues) {  
            }
                upperTerm,
            public Query bitmapQuery(String field, BytesArray bitmapArray, boolean isSearchable, boolean hasDocValues) {
                    // ASC: exclusive lower bound
        }
                }
import java.util.List;  
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
        @Override
    public static class Builder extends ParametrizedFieldMapper.Builder {
                boolean docValued,
        private final NumericType numericType;  
            }  
                return switch (type) {  
        FLOAT("float", NumericType.FLOAT) {
        }
                    );
import java.io.IOException;
                    if ((lowerTermHasDecimalPart == false && includeLower == false) || (lowerTermHasDecimalPart && signum(lowerTerm) > 0)) {  
            public Query termsQuery(String field, List<Object> values, boolean hasDocValues, boolean isSearchable) {
            };
import org.roaringbitmap.longlong.Roaring64NavigableMap;  
                    builder.field(simpleName, convert(values.getFirst()));  
                // - if the bound is positive then we increment it:
                    if (!hasDecimalPart(value)) {
                if (isSearchable && hasDocValues) {  
    @Override  
            }  
            }  
                            }  
                number = bytesRef.utf8ToString();
                        Query pointRangeQuery = LongPoint.newRangeQuery(field, l, u);  
        this.ignoreMalformed = builder.ignoreMalformed.getValue();  
            @Override  
                    }
                    }
                    Query query = LongPoint.newExactQuery(field, v);  
                throw new IllegalArgumentException("Value [" + value + "] is out of range for an unsigned long");  
                boolean indexed,  
                        fields.add(new SortedNumericDocValuesField(name, NumericUtils.floatToSortableInt(value.floatValue())));  
                        if (u == Integer.MIN_VALUE) {
                // - if the bound is positive then we increment it:
                    fields.add(new StoredField(name, value.longValue()));
                    return new Bitmap64IndexQuery(field, bitmap64);
            Number valueForSearch(String value) {
                boolean includeUpper,  
                    if (skiplist) {
            @Override  
                boolean stored
                    super.write(builder, values);
            }  
                    }  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
                        if (dvQuery != null) {
            public Number parsePoint(byte[] value) {  
            return new SortedNumericIndexFieldData.Builder(name(), type.numericType());
        this.skiplist = builder.skiplist.getValue();
            }  
/*  
                throw new IllegalArgumentException("Value [" + value + "] is out of range for a long");
                builder.indexed.getValue(),
                byte[] bytes = Arrays.copyOfRange(ref.bytes, ref.offset, ref.offset + ref.length);  
                    return null;
                if (indexed) {  
            @Override
        }  
                name,  
                            field,
        this.indexed = builder.indexed.getValue();
            public double toDoubleValue(long value) {
                long points[] = new long[v.length];
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {  
                    throw new IllegalArgumentException("[half_float] supports only finite values, but got [" + value + "]");
            }
                boolean isSearchable,
                        new ApproximatePointRangeQuery(
                    v = Arrays.copyOf(v, upTo);
        }  
                Object lowerTerm,
                    Query dvQuery = SortedUnsignedLongDocValuesSetQuery.newSlowSetQuery(field, v);
                query = new BoostQuery(query, boost());  
            }
                }  
 * Licensed to Elasticsearch under one or more contributor  
                }
        },
                    Query query = BigIntegerPoint.newExactQuery(field, v);  
                    return number.intValue();
                long v = parse(value, true);
                        u = FloatPoint.nextDown(u);
            public Integer parse(XContentParser parser, boolean coerce) throws IOException {  
                        )
            @Override  
                            return new MatchNoDocsQuery();
        );  
            if (isSearchable()) {
        }
                QueryShardContext context
                                NumericUtils.floatToSortableInt(u),
            @Override
import org.apache.lucene.document.FloatPoint;  
                        query,  
                    }  
                    throw new IllegalArgumentException("Failed to deserialize the bitmap.", e);  
                        query = pointRangeQuery;  
                }
                    }  
        }
                return Double.parseDouble(value);
        }  
                if (isSearchable) {
            }
import org.apache.lucene.document.Field;
                        NumericUtils.floatToSortableInt(u)  
                boolean includeLower,
        }  
            public void write(XContentBuilder builder, List<Object> values) throws IOException {  
                Long val = (Long) value;
                    // if lowerTerm=1.5 then the (inclusive) bound becomes 2
            }
                }
            this(name, type, IGNORE_MALFORMED_SETTING.get(settings), COERCE_SETTING.get(settings));  
         */
                                ApproximatePointRangeQuery.DOUBLE_FORMAT  
                if (isSearchable) {
        }  
                    u = HalfFloatPoint.nextDown(u);
            this.type = Objects.requireNonNull(type);
            @Override  
            }  
        @Override
            @Override
            ) {
         * Converts an Object to a double by checking it against known types first  
                    return SortedUnsignedLongDocValuesSetQuery.newSlowExactQuery(field, v);
                Object lowerTerm,
                        return new ApproximateScoreQuery(
        }
    }
            @Override
            @Override
                }
                            ApproximatePointRangeQuery.FLOAT_FORMAT  
                Object upperTerm,
            }
                builder.skiplist.getValue(),
                            query = new IndexOrDocValuesQuery(query, dvQuery);
                    return type.parse(value, coerce);
                }
                (n, c, o) -> o == null ? null : type.parse(o, false),  
            }
                    if (numericValue > Long.MIN_VALUE) {  
        }  
            this.type = type;  
                                DoublePoint.pack(u).bytes,
                if (hasDocValues) {
            return type.parsePoint(value);
                byte[] point = new byte[Double.BYTES];
    @Override  
                if (isSearchable && hasDocValues) {
            @Override
                    }
                return Double.parseDouble(stringValue) % 1 != 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    Query query = IntPoint.newExactQuery(field, v);
        @Override
                        numericValue = numericValue + 1;
                Object upperTerm,
                }
            if (value instanceof BytesRef bytesRef) {
    @Override
            }
            // be equal to Long.MAX_VALUE after conversion to double. More checks ahead.  
                for (int i = 0; i < values.size(); ++i) {  
            }
                if (value instanceof Number number) {  
            ) {
                    if (value instanceof BytesRef bytesRef) {
     * 1. If it has doc values, build source using doc values
            }  
            this.coerce = Parameter.explicitBoolParam("coerce", true, m -> toType(m).coerce, coerceByDefault);
                    return Queries.newMatchNoDocsQuery("All values have a decimal part");
                return dvQuery;
            String stringValue = (value instanceof BytesRef bytesRef) ? bytesRef.utf8ToString() : value.toString();  
            // this check does not guarantee that value is inside MIN_VALUE/MAX_VALUE because values up to 9223372036854776832 will
                boolean stored
                String field,
        return (NumberFieldMapper) super.clone();
            } else {  
            if (format == null) {
            }  
            @Override
     * @opensearch.internal
                return DoublePoint.decodeDimension(value, 0);  
                m -> toType(m).nullValue
                    return DocValueFormat.RAW;  
            boolean isSearchable,  
        /**  
            if (value instanceof Long longValue) {  
                double doubleValue = objectToDouble(value);
                List<Field> fields = new ArrayList<>();
                if (hasDocValues) {
        }
                boolean stored  
                boolean indexed,
                            query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);  
            }  
                byte[] point = new byte[Long.BYTES];  
                context
            }
                return DoublePoint.newSetQuery(field, v);  
         */  
                    return new IndexOrDocValuesQuery(
            @Override  
            if (value instanceof Long longValue) {  
        NumberFieldType(String name, Builder builder) {
                }  
                }  
            }
            double doubleValue;  
                if (upperTerm != null) {  
                QueryShardContext context  
         */
         * Processes query bounds into {@code long}s and delegates the
                if (stored) {  
/**
            @Override
                            query = new IndexSortSortedNumericDocValuesRangeQuery(field, l, u, query);  
                return point;
 * software distributed under the License is distributed on an
                            query,  
        }, new StoredFieldFetcher(mappedFieldType, simpleName()));
                    Object value = values.get(i);  
            }  
                    return SortedNumericDocValuesField.newSlowSetQuery(field, points);
                    // DESC: exclusive upper bound
                    }
        public abstract Query rangeQuery(
        this.nullValue = builder.nullValue.getValue();
                return longValue;
    /**
                    Query query = DoublePoint.newExactQuery(field, v);
                boolean includeUpper,  
                return parsed;
                if (lowerTerm != null) {
                if (includeUpper == false) {  
                boolean stored
import org.opensearch.search.DocValueFormat;
                    if (dvQuery != null) {  
                for (int i = 0; i < values.size(); ++i) {  
            Number valueForSearch(String value) {
                ? Optional.of(DimensionType.UNSIGNED_LONG)
        private final boolean skiplist;
         * types and checking its range.
                        query = pointRangeQuery;
                HalfFloatPoint.encodeDimension(value.floatValue(), point, 0);
        Number valueForSearch(Number value) {  
                } else {
            return numericType;
                    return null;
                BigIntegerPoint.encodeDimension(objectToUnsignedLong(value, false, true), point, 0);
        }
        private final TypeParser parser;
            return builder.apply(l, u);
                if (isSearchable && hasDocValues) {  
                    }
 * Modifications Copyright OpenSearch Contributors. See
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for an integer");  
                return encodePoint(numericValue);  
                // if the lower bound is decimal:
                }  
            @Override  
                }
                float v = parse(value, false);  
                boolean stored
                }  
                QueryShardContext context  
                    return Numbers.MIN_UNSIGNED_LONG_VALUE;
                }
                }
import org.opensearch.core.xcontent.XContentBuilder;
                    l = parse(lowerTerm, false);  
        }
                            )  
        }
                    dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(
            }  
            super(name);
                if (isSearchable && hasDocValues) {  
            m -> toType(m).skiplist
                        numericValue = numericValue - 1;
                    throw new IllegalArgumentException("[double] supports only finite values, but got [" + value + "]");
                    }  
            }
        }
            @Override
                    return Queries.newMatchNoDocsQuery("Value [" + value + "] has a decimal part");
        }  
            }  
                // - if the bound is negative then we leave it as is:  
            return objectToUnsignedLong(value, coerce, false);
            Number valueForSearch(Number value) {
import org.apache.lucene.document.DoublePoint;
                        Query query = BigIntegerPoint.newRangeQuery(field, l, u);
                        query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
            (n, c, o) -> XContentMapValues.nodeBooleanValue(o),
    protected Explicit<Boolean> ignoreMalformed() {  
            @Override
            BigInteger l = Numbers.MIN_UNSIGNED_LONG_VALUE;
                return fields;
                        points[i] = v[i];  
    /**  
import org.opensearch.index.fielddata.IndexFieldData;
                int upTo = 0;  
                return parser.longValue(coerce);
            if (boost() != 1f) {  
                boolean includeLower,
            public Long parse(Object value, boolean coerce) {
            @Override
                    return SortedNumericDocValuesField.newSlowExactQuery(field, NumericUtils.doubleToSortableLong(v));  
            throw new IllegalArgumentException("Field [" + name + "] of type [" + typeName() + "] does not support bitmap queries");
        }
                        if (context.indexSortedOnField(field)) {
                }  
                doubleValue = Double.parseDouble(bytesRef.utf8ToString());
            @Override
                boolean includeUpper,
            } else {  
        public Number parse(Object value) {
import org.apache.lucene.util.NumericUtils;
                        numericValue = (byte) (numericValue + 1);  
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
                }  
        private final NumberType type;
        ) {
            }
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
        );
                return null;
                        fields.add(new SortedNumericDocValuesField(name, value.longValue()));
                    );
                            query,
            if (upperTerm != null) {
                return INTEGER.termsQuery(field, values, hasDocValues, isSearchable);  
            }
                    if (isSearchable) {
            }
            @Override
        UNSIGNED_LONG("unsigned_long", NumericType.UNSIGNED_LONG) {  
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {  
                if (docValued) {
                        field,
            public Short parse(XContentParser parser, boolean coerce) throws IOException {
        NumberType(String name, NumericType numericType) {  
                if (upTo != v.length) {  
                        fields.add(new SortedNumericDocValuesField(name, v.longValue()));  
                    if (numericValue < Long.MAX_VALUE) {
                boolean skiplist,
                    for (int i = 0; i < v.length; i++) {
            @Override
                boolean skiplist,
                    return SortedNumericDocValuesField.newSlowSetQuery(field, v);
         * provided {@code builder} to build a range query.  
            double doubleValue = objectToDouble(value);
            return doubleValue;
            boolean stored
            public byte[] encodePoint(Object value, boolean roundUp) {
                if (hasDocValues) {  
            }
                            new ApproximatePointRangeQuery(  
            public byte[] encodePoint(Number value) {  
            @Override
                        NumericUtils.floatToSortableInt(u),  
            public byte[] encodePoint(Object value, boolean roundUp) {
            @Override  
    @Override
                boolean isSearchable,  
                    if (value instanceof BytesRef bytesRef) {
    private final NumberType type;
                BigInteger v = parse(value, true);
import java.math.BigInteger;  
        @Override  
            @Override  
            return type.parse(value, coerce);  
            }
                    return new IndexOrDocValuesQuery(query, dvQuery);
                    v[i] = parse(values.get(i), false);
                    } else {
        }  
                QueryShardContext context  
                        );
                            APPROX_QUERY_NUMERIC_DIMS,
                    fields.add(new DoublePoint(name, value.doubleValue()));  
                return DoublePoint.newExactQuery(field, v);
                        } else {
                    final BigInteger[] displayValues = new BigInteger[values.size()];
                    if (includeLower) {
                doubleValue = Double.parseDouble(value.toString());
         * Returns true if the object is a number and has a decimal part
            }  
                String field,
            @Override
            public double toDoubleValue(long value) {
                if (isSearchable && hasDocValues) {
            }
                }
                boolean isSearchable,
                l = objectToDouble(lowerTerm);
            }
        @Override
                return new BitmapDocValuesQuery(field, bitmap);  
                return IntPoint.newSetQuery(field, v);  
     * Type of number
                builder.type,
            }
            @Override
                if (!coerce && doubleValue % 1 != 0) {
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());  
                            NumericUtils.doubleToSortableLong(u)
                float[] v = new float[values.size()];
            @Override  
                boolean skiplist,
            return this;
            }
                        query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
        @Override
                }
                return encodePoint(numericValue);
        }
            this.ignoreMalformed = Parameter.explicitBoolParam(
                }
                        fields.add(SortedNumericDocValuesField.indexedField(name, NumericUtils.doubleToSortableLong(value.doubleValue())));
                boolean hasDocValues,
        private final Number nullValue;  
            @Override  
        private final Parameter<Explicit<Boolean>> ignoreMalformed;
            public List<Field> createFields(  
            public List<Field> createFields(
        }  
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {  
 * not use this file except in compliance with the License.
            return type.numericType();
                throw new IllegalArgumentException(
                                field,
            @Override
        public Query bitmapQuery(String field, BytesArray bitmap, boolean isSearchable, boolean hasDocValues) {
                String field,  
            }
import org.opensearch.core.common.bytes.BytesArray;
        } else if (coerce.value() && parser.currentToken() == Token.VALUE_STRING && parser.textLength() == 0) {
        return ignoreMalformed;
                return FloatPoint.newExactQuery(field, v);
        @Override
                    context.addIgnoredField(mappedFieldType.name());  
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, NumericUtils.floatToSortableInt(v));
                } else {
        public static Builder docValuesOnly(String name, NumberType type) {
        @Override
                lowerTerm,
                        query = pointRangeQuery;  
                    return BigIntegerPoint.newRangeQuery(field, l, u);  
            }
                    result = Float.parseFloat(value.toString());
        LONG("long", NumericType.LONG) {
import org.opensearch.search.approximate.ApproximatePointRangeQuery;  
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
            if (number instanceof String stringValue) {  
                if (indexed) {
        BYTE("byte", NumericType.BYTE) {
                    return DocValueFormat.UNSIGNED_LONG;
                if (roundUp) {
 * under the License.  
            @Override  
            }  
                }  
                }
                if (hasDocValues) {
            () -> false,  
                        )
                    numericValue = HalfFloatPoint.nextDown(numericValue);
                final BigInteger v = Numbers.toUnsignedLongExact(value);
            }
        public boolean isDataCubeMetricSupported() {
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);
            }
            }  
                    ? SortedNumericDocValuesField.newSlowRangeQuery(  
                    l = parse(lowerTerm, false);
        return (NumberFieldMapper) in;
                if (upTo == 0) {  
                    dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(field, l, u, dvQuery);
        public abstract Number parsePoint(byte[] value);
        }  
            String name,
        Number value;  
        },
        @Override  
                return new DocValueFormat.Decimal(format);  
            } catch (JsonParseException | IllegalArgumentException e) {
                    Query dvQuery = hasDocValues  
            @Override
    private final boolean hasDocValues;
 * specific language governing permissions and limitations
                float u = Float.POSITIVE_INFINITY;  
                                field,
     */
                } else {
                Integer numericValue = parse(value, true);  
            }
                return Short.parseShort(value);  
            }
                };  
                Byte numericValue = parse(value, true);
            } else {
                                    NumericUtils.doubleToSortableLong(l),  
 *
                Object upperTerm,
                    ? SortedNumericDocValuesField.newSlowRangeQuery(  
        }
                boolean lowerTermHasDecimalPart = hasDecimalPart(lowerTerm);
 * ownership. Elasticsearch licenses this file to you under  
            @Override
            }
                if (indexed) {
            return true;
                    return new IndexOrDocValuesQuery(query, dvQuery);
            ).acceptsNull();
                    return new IndexOrDocValuesQuery(query, dvQuery);
        }
                                ApproximatePointRangeQuery.LONG_FORMAT
                    v = Arrays.copyOf(v, upTo);
                    Object value = values.get(i);
            @Override
            @Override
        public NumberType numberType() {
                String name,
                }
                }  
                    if (l == Long.MAX_VALUE) {
            Query query = type.termQuery(name(), value, hasDocValues(), isSearchable());
         */
            }
                    return new ApproximateScoreQuery(
            if (!coerce && doubleValue % 1 != 0) {
                                LongPoint.pack(u).bytes,  
                }
            boolean hasDocValues,
    @Override
            }
    public NumberFieldType fieldType() {
         */  
                if (lowerTerm != null) {
         * @param lenientBound if true, use MIN or MAX if the value is out of bound  
                boolean indexed,  
import org.opensearch.search.lookup.SearchLookup;
     *    2. For "half_float", there might be precision loss, when using doc values(stored as HalfFloatPoint) as  
            public byte[] encodePoint(Object value, boolean roundUp) {
 * @opensearch.internal
            if (value instanceof Number number) {
            }  
                    return new IndexOrDocValuesQuery(
            boolean includeUpper,
            public double toDoubleValue(long value) {
                l = objectToUnsignedLong(lowerTerm, true);
                        fields.add(new SortedNumericDocValuesField(name, NumericUtils.doubleToSortableLong(value.doubleValue())));  
                boolean includeLower,  
            return false;  
            }
            public Number parsePoint(byte[] value) {
                    if (skiplist) {  
            @Override
                return LongPoint.decodeDimension(value, 0);
                return parser.shortValue(coerce);
                if (hasDecimalPart(value)) {
            public byte[] encodePoint(Object value, boolean roundUp) {  
                        );
                        --u;
                return encodePoint(numericValue);
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
            @Override  
         * Get the associated type name.
                    throw new IllegalArgumentException("Value [" + value + "] has a decimal part");  
                value = fieldType().type.parse(parser, coerce.value());  
import org.opensearch.search.approximate.ApproximateScoreQuery;
            Number valueForSearch(String value) {
                    }
                u = objectToDouble(upperTerm);
import org.opensearch.index.document.SortedUnsignedLongDocValuesSetQuery;
import java.io.ByteArrayInputStream;  
                    }
                    Query query = HalfFloatPoint.newSetQuery(field, v);
                    numericValue = DoublePoint.nextDown(numericValue);
                            SortedNumericDocValuesField.indexedField(name, HalfFloatPoint.halfFloatToSortableShort(value.floatValue()))  
            }
        }
        } else {
                boolean skiplist,
                    for (int i = 0; i < values.size(); i++) {  
                                    NumericUtils.doubleToSortableLong(u),
            );
        private final Parameter<Number> nullValue;
            }  
                Short numericValue = parse(value, true);
            public double toDoubleValue(long value) {
            }
            }
            ) {
                        return new MatchNoDocsQuery();  
            }  
            @Override
        }  
                }
        if (numericValue == null) {  
            false,
                } else {
        public static Query doubleRangeQuery(
                boolean includeUpper,  
            }
                if (upperTerm != null) {
            @Override  
                boolean includeLower,  
        Number numericValue = getFieldValue(context);
                return point;  
                return encodePoint(numericValue);
                }  
                    ++l;
        }  
                return INTEGER.termQuery(field, value, hasDocValues, isSearchable);  
                    return Queries.newMatchNoDocsQuery("All values have a decimal part");
                return point;
                            query = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);  
            @Override  
        },
            ) {  
                    if (isSearchable) {
        if (numericValue == null) {
                }
                }
                        );
            @Override  
            Number valueForSearch(String value) {  
            @Override
                    }
        }
package org.opensearch.index.mapper;
                Object upperTerm,
            }
                return objectToLong(value, coerce);
                    return number.shortValue();  
            @Override  
                }
                            dvQuery  
                final float result;  
                        SortedNumericDocValuesField.newSlowSetQuery(field, v)
                if (isSearchable && hasDocvalues) {
        }
            @Override
            }
        public abstract Number parse(XContentParser parser, boolean coerce) throws IOException;
                                APPROX_QUERY_NUMERIC_DIMS,
                });
            Object upperTerm,
         */
                                query = new IndexSortSortedNumericDocValuesRangeQuery(field, l, u, query);
                if (isSearchable) {  
            public Byte parse(Object value, boolean coerce) {
            BiFunction<Long, Long, Query> builder
            @Override  
                Object upperTerm,  
                if (hasDocValues) {  
            ) {
            }
     * Builder for the number field mappers  
            }
                }
                if (!coerce && doubleValue % 1 != 0) {
            }
                        }
import java.util.function.BiFunction;
        DOUBLE("double", NumericType.DOUBLE) {
            private void validateParsed(float value) {
            @Override
                        HalfFloatPoint.halfFloatToSortableShort(l),
                    case FLOAT -> NumericUtils.sortableIntToFloat(val.intValue());
                validateParsed(parsed);
                if (doubleValue < Short.MIN_VALUE || doubleValue > Short.MAX_VALUE) {
                if (doubleValue < Integer.MIN_VALUE || doubleValue > Integer.MAX_VALUE) {
                }
                Roaring64NavigableMap bitmap64 = new Roaring64NavigableMap();
                }
                }  
                        }  
            boolean includeLower,  
                for (int i = 0; i < values.size(); i++) {  
     *
                double doubleValue = objectToDouble(value);  
                return HalfFloatPoint.sortableShortToHalfFloat((short) value);  
                    // DESC: exclusive upper bound  
                    throw new IllegalArgumentException("[float] supports only finite values, but got [" + value + "]");
                    if (context.indexSortedOnField(field)) {  
                    if (dvQuery != null) {  
 * the Apache License, Version 2.0 (the "License"); you may
                query = new BoostQuery(query, boost());
    private final Explicit<Boolean> ignoreMalformed;
            boolean isStored,
            public List<Field> createFields(  
                    }
            if (value instanceof Number number) {
                isSearchable(),  
            }  
                builder.stored.getValue(),  
import java.util.Arrays;
                if (isSearchable && hasDocValues) {
                double v = parse(value, false);
            }
                    // if the lower bound is decimal:  
        Number numericValue = getFieldValue(context);  
            @Override
        public NumberFieldMapper build(BuilderContext context) {  
                try {  
                boolean indexed,  
                    dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(  
                    }
                        new ApproximatePointRangeQuery(  
        }  
    protected void canDeriveSourceInternal() {
                        ? SortedNumericDocValuesField.newSlowRangeQuery(
                boolean docValued,
         */  
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
                                BigIntegerPoint.pack(l).bytes,
                builder.coerce.getValue().value(),  
                    if (skiplist) {
                double[] v = new double[values.size()];
            return type.bitmapQuery(name(), bitmap, isSearchable(), hasDocValues());
                    return new BitmapIndexQuery(field, bitmap);
            @Override  
        public Query bitmapQuery(BytesArray bitmap) {  
            }  
            @Override
            Number valueForSearch(Number value) {  
            public Query termQuery(String field, Object value, boolean hasDocValues, boolean isSearchable) {
                    case UNSIGNED_LONG -> Numbers.toUnsignedBigInteger(val);
                }
    private static final int APPROX_QUERY_NUMERIC_DIMS = 1;
                return NumericUtils.sortableIntToFloat((int) value);
                if (docValued) {
            @Override  
            this.nullValue = new Parameter<>(
            value = nullValue;
                    if (isSearchable) {
                    }
                        value = bytesRef.utf8ToString();  
                    )
                if (isSearchable && hasDocValues) {
                }  
                if (docValued) {
                () -> null,
            @Override
 * You may obtain a copy of the License at  
                            HalfFloatPoint.pack(l).bytes,
            String field,  
                        l = HalfFloatPoint.nextDown(l);
    /**  
                return HalfFloatPoint.newExactQuery(field, v);  
                        points[i] = NumericUtils.floatToSortableInt(v[i]);  
                QueryShardContext context
        if (context.externalValueSet()) {
                }
                            field,
            this(name, type, true, false, true, false, true, null, Collections.emptyMap());
                byte[] point = new byte[BigIntegerPoint.BYTES];
                            query = pointRangeQuery;
                // if the lower bound is decimal:  
        }  
 */
                return encodePoint(numericValue);
                throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
                    numericValue = HalfFloatPoint.nextUp(numericValue);  
            @Override
            Object lowerTerm,
                float v = parse(value, false);
            }
            }
        private final Parameter<Explicit<Boolean>> coerce;  
                    return new IndexOrDocValuesQuery(
    }  
                    return SortedNumericDocValuesField.newSlowExactQuery(field, HalfFloatPoint.halfFloatToSortableShort(v));
                                    field,
                return BigIntegerPoint.newExactQuery(field, v);
                String field,  
                "null_value",  
                if ((lowerTermHasDecimalPart == false && includeLower == false) || (lowerTermHasDecimalPart && signum(lowerTerm) > 0)) {  
            Builder builder = new Builder(name, type, false, false);
                            )  
                            field,
                    u = u.subtract(BigInteger.ONE);
                return FloatPoint.decodeDimension(value, 0);  
        /** Still searchable from doc values when the index uses a pluggable data format. */
                }
        return (NumberFieldType) super.fieldType();  
                if (isSearchable && hasDocValues) {
                }
            public byte[] encodePoint(Object value, boolean roundUp) {
                        value = bytesRef.utf8ToString();
                    Arrays.sort(displayValues);  
                boolean includeLower,
            ) {  
            }  
    private final Explicit<Boolean> coerce;
    private final Number nullValue;  
        /**
                validateParsed(result);  
        public final TypeParser parser() {
                        field,
 * The OpenSearch Contributors require contributions made to  
        }
                return Long.parseLong(value);  
            return query;  
        /**
                if (isSearchable && hasDocValues) {  
            if (l.compareTo(u) > 0) {
                    return dvQuery;  
import org.apache.lucene.search.IndexSortSortedNumericDocValuesRangeQuery;  
        }  
                return fields;  
        public Query termsQuery(List values, QueryShardContext context) {  
     */  
                        }
                    fields.add(new StoredField(name, value.floatValue()));
                double doubleValue = objectToDouble(value);
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
                        query,
                        numericValue = (short) (numericValue - 1);
    private final boolean coerceByDefault;  
                boolean docValued,  
     *
                boolean includeLower,
        private final boolean coerce;
                        }
                } else {  
            if (upperTerm != null) {
            Object upperTerm,  
            this.nullValue.setValue(number);  
                        : null;  
                    if (l.compareTo(Numbers.MAX_UNSIGNED_LONG_VALUE) == 0) {
                String name,  
                return point;
                }  
                        u = HalfFloatPoint.nextUp(u);  
     * Considerations:
                return new MatchNoDocsQuery();  
                                HalfFloatPoint.halfFloatToSortableShort(l),
                    // - if the bound is positive then we increment it:
                builder.hasDocValues.getValue(),
                boolean stored  
            @Override
                }  
                } else {
    protected Number getFieldValue(ParseContext context) throws IOException {
                                query = new IndexSortSortedNumericDocValuesRangeQuery(
                if (roundUp) {  
            @Override  
                    if (!hasDecimalPart(value)) {
                        l = FloatPoint.nextUp(l);
            }
            }
                Number value,
                }
                includeUpper,
import org.opensearch.common.settings.Setting.Property;
                return Math.signum(doubleValue);  
                    if (numericValue < Byte.MAX_VALUE) {
                List<Field> fields = new ArrayList<>();
                    }  
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, HalfFloatPoint.halfFloatToSortableShort(v));  
            this.hasDocValues.setValue(hasDocValues);
            if (value == null) {
                        if (context.indexSortedOnField(field)) {
            }
                    } else {
            try {
                if (value instanceof Number number) {
         * Processes query bounds into {@code long}s and delegates the
                return fields;  
                double doubleValue = number.doubleValue();
    }
                }
            ) {  
                return (double) value;  
            value = nullValue;  
                return Integer.parseInt(value);
import org.apache.lucene.sandbox.document.BigIntegerPoint;
        }
                        numericValue = numericValue - 1;
                        }  
                        ++l;
                if (val == null) {  
                } else {  
            boolean includeLower,
    protected void parseCreateField(ParseContext context) throws IOException {
    protected DerivedFieldGenerator derivedFieldGenerator() {
                }  
}
                }
                        numericValue = numericValue.subtract(BigInteger.ONE);
                    fields.add(new StoredField(name, value.doubleValue()));
            return parser;  
            Object lowerTerm,
                if (isSearchable && hasDocValues) {
                boolean indexed,
            }
            public List<Field> createFields(  
                    return SortedNumericDocValuesField.newSlowSetQuery(field, points);
            }
                boolean indexed,
                    if (dvQuery != null) {
                if (roundUp) {  
                float[] v = new float[values.size()];
    }
                            );  
                int upTo = 0;
                LongPoint.encodeDimension(value.longValue(), point, 0);
                        numericValue = numericValue.add(BigInteger.ONE);
                if (roundUp) {
                    Query query;
                doubleValue = number.doubleValue();  
        }
                return FloatPoint.newSetQuery(field, v);  
            public double toDoubleValue(long value) {  
                if (!Float.isFinite(HalfFloatPoint.sortableShortToHalfFloat(HalfFloatPoint.halfFloatToSortableShort(value)))) {  
                        if (hasDocValues) {  
                        fields.add(SortedNumericDocValuesField.indexedField(name, value.intValue()));
                    Query dvQuery = SortedUnsignedLongDocValuesSetQuery.newSlowExactQuery(field, v);
    }
        return value;  
import java.time.ZoneId;
                            query,
                return point;  
    protected NumberFieldMapper clone() {  
                }
                return Float.parseFloat(value);
            }
            public List<Field> createFields(
                }  
        this.hasDocValues = builder.hasDocValues.getValue();  
                    if (value.equals("")) {
                return INTEGER.parsePoint(value).byteValue();
                    }
                boolean docValued,  
                }
 *
                byte[] point = new byte[Integer.BYTES];
                    if (u == Long.MIN_VALUE) {  
                    Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery(field, v);
            @Override  
        this.stored = builder.stored.getValue();
            public byte[] encodePoint(Object value, boolean roundUp) {  
                if (doubleValue < Byte.MIN_VALUE || doubleValue > Byte.MAX_VALUE) {
            }
                QueryShardContext context  
                return IntPoint.decodeDimension(value, 0);  
            @Override
            boolean docValued,
            double l = Double.NEGATIVE_INFINITY;
            }  
            }
                        dvQuery = new IndexSortSortedNumericDocValuesRangeQuery(field, l, u, dvQuery);
        public Builder(String name, NumberType type, boolean ignoreMalformedByDefault, boolean coerceByDefault) {
            return builder.apply(l, u);  
 */  
            @Override
            failIfNotIndexedAndNoDocValues();
                    numericValue = FloatPoint.nextDown(numericValue);
                String field,  
                QueryShardContext context
                Number value,
