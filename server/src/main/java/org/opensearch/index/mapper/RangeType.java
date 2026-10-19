        @Override  
        }
import java.util.List;
    },
                return new MatchNoDocsQuery("float range didn't intersect anything");
            return LONG.encodeRanges(ranges);
            String field,
    };
        public Float minValue() {
        }
        }  
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
 */  
            boolean includeTo
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
        }  
                if (value instanceof BytesRef bytesRef) {  
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {  
            @Override
        @Override
        @Override
 * specific language governing permissions and limitations
                includeFrom,
            return Math.nextDown(((Number) value).doubleValue());  
            indexQuery = withinQuery(field, lower, upper, includeFrom, includeTo);
        public Double doubleValue(Object endpointValue) {
        public InetAddress minValue() {
        T correctedFrom = includeFrom ? from : (T) rangeType.nextUp(from);  
        @Nullable ZoneId timeZone,  
            boolean includeLower,
            @Nullable ZoneId timeZone,  
        @Override
            return LONG.containsQuery(field, from, to, includeLower, includeUpper);  
        String name,
            throws IOException {
    /**  
            return Double.NEGATIVE_INFINITY;  
                (Long) from,
            Object lower,
        FIXED_4 {  
                RangeType.INTEGER  
        }
                (Double) to,  
            }
        public Long nextDown(Object value) {
        @Override
        public Query rangeQuery(
    FLOAT("float_range", LengthType.FIXED_4, NumberFieldMapper.NumberType.FLOAT) {  
        @Override
        boolean docValued,
                RangeType.FLOAT
        @Override
            Object to,  
        @Override
                to
        public Double nextUp(Object value) {  
            );  
        }
    public final Mapper.TypeParser parser() {
import org.opensearch.common.geo.ShapeRelation;  
            }
        this.lengthType = lengthType;  
            return createQuery(
    },  
                    length = 0x0f - length;
            return InetAddressPoint.MIN_VALUE;
            byte[] lowerBytes = InetAddressPoint.encode((InetAddress) lower);
            return Integer.MIN_VALUE;  
            BinaryDocValuesRangeQuery.QueryType queryType,  
    LONG("long_range", LengthType.VARIABLE, NumberFieldMapper.NumberType.LONG) {
        }  
        @Override  
 * not use this file except in compliance with the License.
                field,
            if (field == null) {  
        @Nullable DateMathParser dateMathParser,
        public InetAddress parseTo(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
            return Float.NEGATIVE_INFINITY;  
            throw new IllegalArgumentException("Range query `from` value (" + from + ") is greater than `to` value (" + to + ")");
     * This helper handles all {@link Number} cases and dates, the IP range type uses its own logic.
                includeFrom,  
                (f, t) -> IntRange.newContainsQuery(field, new int[] { f }, new int[] { t }),
                includeFrom,  
        @Override
                queryType,  
        }
        @Override  
        }
                return 16;  
 */  
            }  
        }  
    ) {
 *
    DATE("date_range", LengthType.VARIABLE, NumberFieldMapper.NumberType.LONG) {
            return new BinaryDocValuesRangeQuery(
            @Nullable DateMathParser parser,
            return createRangeQuery(field, hasDocValues, low, high, includeLower, includeUpper, relation);
            boolean includeTo
 * software distributed under the License is distributed on an
import org.opensearch.common.time.DateMathParser;  
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
        },
            return new InetAddressRange(name, (InetAddress) r.from, (InetAddress) r.to);
        public Query dvRangeQuery(
        }
    },
    ) {  
    }  
            BinaryDocValuesRangeQuery.QueryType queryType,
            public int readLength(byte[] bytes, int offset) {
import java.time.Instant;
    }  
        T correctedTo = includeTo ? to : (T) rangeType.nextDown(to);
            return Math.nextUp(((Number) value).floatValue());
    // todo add SHORT support
        ) {
                new BytesRef(encodedFrom),
            assert dateMathParser != null;
            if (relation == ShapeRelation.WITHIN) {
                int token = Byte.toUnsignedInt(bytes[offset]);
            String field,
            } else {  
 */  
        @Override
        @Override
                (Integer) from,
                () -> { throw new IllegalArgumentException("now is not used at indexing time"); }
            String field,  
 * KIND, either express or implied.  See the License for the
     * @param endpointValue Object value for Range.to or Range.from
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
        public Double doubleValue(Object endpointValue) {
                includeTo,  
            InetAddress address = InetAddresses.forString(parser.text());  
        }
            return Float.POSITIVE_INFINITY;
            BiFunction<InetAddress, InetAddress, Query> querySupplier  
        };  
        ) {  
        public Long nextUp(Object value) {
        @Override
        }
        }
        @Override
    }
        @Override  
                context.doc().addWithKey(name, field);
            return Math.nextDown(((Number) value).floatValue());  
            InetAddress address = InetAddresses.forString(parser.text());
        Object upper,
        }  
    // rounded up via parseFrom and parseTo methods.
                (Double) from,
        }
            return createQuery(  
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
        }
        }
        @Override  
                from,
                if ((token & 0x80) == 0) {
            @Override
            ZoneId zone = (timeZone == null) ? ZoneOffset.UTC : timeZone;
            return Double.POSITIVE_INFINITY;
            return createQuery(
            return createQuery(
        return new ParametrizedFieldMapper.TypeParser((n, c) -> new RangeFieldMapper.Builder(n, this, c.getSettings()));
        }
        VARIABLE {  
        boolean hasDocValues,  
        public Query withinQuery(String field, Object from, Object to, boolean includeLower, boolean includeUpper) {  
            return BinaryRangeUtil.decodeFloatRanges(bytes);
            );
                (Double) from,
                (Float) to,  
        },
            return indexQuery;
            );
    public abstract Object maxValue();
                includeTo,  
                queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
            InetAddress correctedTo = includeUpper ? (InetAddress) upper : nextDown(upper);
    RangeType(String name, LengthType lengthType, NumberFieldMapper.NumberType type) {  
    public Object parseValue(Object value, boolean coerce, @Nullable DateMathParser dateMathParser) {
        ) {
                LengthType.FIXED_16,
            return ((Number) value).intValue() - 1;  
        @Override
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;  
                (Integer) from,  
        @Override
        this.numberType = null;
            return new IndexOrDocValuesQuery(indexQuery, dvQuery);  
            BinaryDocValuesRangeQuery.QueryType queryType,  
                : dateMathParser.parse(
                field,
                includeTo,
                return querySupplier.apply(correctedFrom, correctedTo);  
        }
    public abstract Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo);
        @Override  
public enum RangeType {
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {  
            return new BinaryDocValuesRangeQuery(
            return createQuery(
/**
                (f, t) -> IntRange.newIntersectsQuery(field, new int[] { f }, new int[] { t }),  
            return BinaryRangeUtil.encodeDoubleRanges(ranges);
    INTEGER("integer_range", LengthType.VARIABLE, NumberFieldMapper.NumberType.INTEGER) {  
            Object upperTerm,
            fields.add(getRangeField(name, range));
                field,  
    }
    // todo add BYTE support
            if (includeTo == false) {
    DOUBLE("double_range", LengthType.FIXED_8, NumberFieldMapper.NumberType.DOUBLE) {  
import java.util.ArrayList;
        }  
        throws IOException {  
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
            return dateMathParser.parse(  
        }
import java.time.ZonedDateTime;
                    context::nowInMillis,  
        }
        }
        public Long nextDown(Object value) {
        String field,
        public Query dvRangeQuery(
     * the intervals min &gt; max, in which case an {@link IllegalArgumentException} is raised. The method adapts the interval bounds
                includeTo,  
                    zone
        }
                RangeType.FLOAT
    public abstract Field getRangeField(String name, RangeFieldMapper.Range range);
        @Override
        }
        Object upper = to == null ? maxValue() : parseValue(to, false, dateMathParser);
            boolean includeTo
        }  
        Object to,
            }
 * GitHub history for details.
                dateStr.toString(),
        Query indexQuery;  
            }  
 * @opensearch.internal
    }
                (f, t) -> FloatRange.newContainsQuery(field, new float[] { f }, new float[] { t }),  
            return LONG.decodeRanges(bytes);
                new BytesRef(encodedFrom),  
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
        @Override
            boolean includeTo
        @Override
    }
            boolean roundUp = includeLower == false; // using "gt" should round lower bound up
            Object from,
                field = new RangeFieldMapper.BinaryRangesDocValuesField(name, range, this);
            return BinaryRangeUtil.encodeLongRanges(ranges);
        @Override  
/*  
                (f, t) -> LongRange.newWithinQuery(field, new long[] { f }, new long[] { t }),
            String field,  
            return Integer.MAX_VALUE;
 *    http://www.apache.org/licenses/LICENSE-2.0
                field,
        }
        FIXED_8 {  
            }
        ) {
        private Query createQuery(  
     */
            assert endpointValue instanceof Double;  
            return createQuery(
        @Override
        boolean includeTo
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
            }  
                new BytesRef(encodedTo),  
            return BinaryRangeUtil.decodeDoubleRanges(bytes);
        public Double nextDown(Object value) {
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {  
                return 4;  
                (Float) from,  
            fields.add(new StoredField(name, range.toString()));
import org.apache.lucene.document.IntRange;  
        this.lengthType = lengthType;  
            boolean includeFrom,
import org.opensearch.lucene.queries.BinaryDocValuesRangeQuery;  
    public Object parseFrom(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
                new BytesRef(encodedFrom),
        public Double doubleValue(Object endpointValue) {
        }  
        }
        }
            }
        boolean includeFrom,
        public Float nextUp(Object value) {  
            Object from,
    // No need to take into account Range#includeFrom or Range#includeTo, because from and to have already been  
        ) {  
        public Double minValue() {
    public abstract BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException;
                return inetAddress;
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
                (Integer) to,  
        return name;
        public Long minValue() {
         * Return the length of the value that starts at {@code offset} in {@code bytes}.  
    public Object parseTo(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
        public InetAddress nextDown(Object value) {
import java.util.Set;
        @Override
            Object to,
        }
        return numberType != null;
    }
 * Unless required by applicable law or agreed to in writing,
                (Long) from,  
            return new IntRange(name, new int[] { ((Number) r.from).intValue() }, new int[] { ((Number) r.to).intValue() });
        @Override
    IP("ip_range", LengthType.FIXED_16) {
        }
                from = nextUp(from);
        }  
            return BinaryRangeUtil.encodeIPRanges(ranges);
            boolean includeFrom,
                includeFrom,
            );  
                    upperTerm instanceof BytesRef bytesRef2 ? bytesRef2.utf8ToString() : upperTerm.toString(),
            Object to,  
        }
        @Override  
            InetAddress correctedFrom = includeLower ? (InetAddress) lower : nextUp(lower);
        @Override  
        public InetAddress nextUp(Object value) {
    }
        BiFunction<T, T, Query> querySupplier,  
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
                includeTo,
            Object to,
 */
            }  
            return (Double) endpointValue;
        @Override
import org.apache.lucene.document.Field;
    ) {
    public final String typeName() {
import java.util.function.BiFunction;  
        public Query dvRangeQuery(
                includeFrom,
                from,
        }  
            );  
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) {
    public enum LengthType {
                (Integer) to,
                to  
        }
            Long low = lowerTerm == null
            Object upper,  
                includeFrom,
import org.opensearch.common.network.InetAddresses;
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
        public Query containsQuery(String field, Object from, Object to, boolean includeLower, boolean includeUpper) {
                field,  
            @Override
            Object from,
                to  
    public final LengthType lengthType;
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
        Object lower,  
        /**
        @Override  
                // of additional bytes
            if (includeFrom == false) {
        }
                }  
                (f, t) -> LongRange.newContainsQuery(field, new long[] { f }, new long[] { t }),
        }  
                return 8;  
import org.apache.lucene.index.IndexableField;  
        public Long parseValue(Object dateStr, boolean coerce, @Nullable DateMathParser dateMathParser) {
                includeFrom,
            return included ? value : nextUp(value);
            throw new UnsupportedOperationException("IP ranges cannot be safely converted to doubles");  
            // TODO: Implement this.  
        }
        this.name = name;
        if (stored) {
                RangeType.DOUBLE
    public abstract Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo);
        @Override
        if (relation == ShapeRelation.WITHIN) {
        }
        assert range != null : "range cannot be null when creating fields";
        }  
            byte[] encodedFrom = BinaryRangeUtil.encodeLong(((Number) from).longValue());
            return dateFormatter.format(dateTime);
                to
                (Double) to,
        @Override  
        ) {  
            String field,
        @Override  
        @Override
        ParseContext context,
        boolean includeTo,
package org.opensearch.index.mapper;
            return (long) LONG.nextUp(value);
            );  
        @Override
                includeTo,  
        @Override  
            if (value instanceof InetAddress inetAddress) {  
                includeTo,
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
                LengthType.FIXED_4,
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {  
            return LONG.intersectsQuery(field, from, to, includeLower, includeUpper);
            Number value = parseValue(parser.text(), coerce, fieldType.dateMathParser);
                includeFrom,
            return included ? address : nextDown(address);
        public Long minValue() {
            Number value = parseValue(parser.text(), coerce, fieldType.dateMathParser);
            Object to,
            QueryShardContext context
            throws IOException {  
            ;  
    public abstract Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo);  
        }
import org.apache.lucene.document.LongRange;
     */
        }
        }  
            throws IOException {
import org.apache.lucene.document.InetAddressRange;
            final BinaryDocValuesRangeQuery.QueryType queryType;  
            String field,
    }  
        @Override
import org.apache.lucene.document.DoubleRange;
            } else {
            // wrong argument order, this is an error the user should fix
        Number value = numberType.parse(parser, coerce);
                to = nextDown(to);  
            }
         */
            boolean includeUpper,
 * The OpenSearch Contributors require contributions made to  
        } else {
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {  
                queryType,  
                from,
                return InetAddresses.forString(value.toString());  
        }
            long timestamp = (long) value;
                field,
import org.opensearch.common.Nullable;
        BinaryDocValuesRangeQuery.QueryType queryType,  
                (Integer) from,
        @Override
                ? maxValue()  
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {  
        this.numberType = type;
 * the Apache License, Version 2.0 (the "License"); you may
                from = nextUp(from);
            if (includeFrom == false) {
        @Override  
            assert endpointValue instanceof Long;
            }
        public Query dvRangeQuery(
                from = nextUp(from);
        Object from,
import java.io.IOException;
/*  
            return included ? address : nextUp(address);  
        }
            }  
    protected final Query createRangeQuery(  
            if (includeTo == false) {
        boolean includeFrom,  
        }
        boolean includeFrom,  
            return LONG.dvRangeQuery(field, queryType, from, to, includeFrom, includeTo);  
        @Override
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
                int length = (token >>> 3) & 0x0f;  
                field,  
            String field,
            return createQuery(
        @Override
            );  
            indexQuery = containsQuery(field, lower, upper, includeFrom, includeTo);
        }  
        }  
        }  
        @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANYDa  
 *
    private static <T extends Comparable<T>> Query createQuery(  
                (Double) to,
        @Override
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
                    context::nowInMillis,  
        }
            return InetAddressPoint.nextUp((InetAddress) value);  
        public Long maxValue() {  
import org.opensearch.core.xcontent.XContentParser;
            }
            return (long) LONG.nextDown(value);  
        @Override  
            byte[] encodedTo = InetAddressPoint.encode((InetAddress) to);  
        @Override
        @Override  
        @Override  
                // the first bit encodes the sign and the next 4 bits encode the number  
                queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
                includeFrom,
            Long high = upperTerm == null
        ) {
import org.apache.lucene.document.InetAddressPoint;
            return createQuery(  
        @Override
        @SuppressWarnings("unchecked")
        this.name = name;
            roundUp = includeUpper; // using "lte" should round upper bound up
        public InetAddress maxValue() {  
                throw new IllegalArgumentException("Range query `from` value (" + lower + ") is greater than `to` value (" + upper + ")");
 * this work for additional information regarding copyright
                RangeType.LONG  
            if (includeTo == false) {
        @Override
            } else if (relation == ShapeRelation.CONTAINS) {  
        public Float maxValue() {
     *
    public final String name;
        boolean stored  
            BinaryDocValuesRangeQuery.QueryType queryType,  
                field,
        }
            return ((Long) endpointValue).doubleValue();  
        }
            return createQuery(
    public abstract Object nextUp(Object value);  
            boolean includeTo
                new BytesRef(encodedTo),
            if (Arrays.compareUnsigned(lowerBytes, 0, lowerBytes.length, upperBytes, 0, upperBytes.length) > 0) {  
            Object to,
            );
        return createRangeQuery(field, hasDocValues, lower, upper, includeFrom, includeTo, relation);  
        Object from,
        Object lower = from == null ? minValue() : parseValue(from, false, dateMathParser);
                (Float) to,
            boolean includeUpper,
            return LONG.doubleValue(endpointValue);  
        }
                RangeType.FLOAT  
            );  
        public Double doubleValue(Object endpointValue) {
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
                RangeType.INTEGER
            return createQuery(  
            return LONG.withinQuery(field, from, to, includeLower, includeUpper);
        @Override  
/*
                (Float) from,
        ) {
            if (includeFrom == false) {  
            boolean includeTo
                (f, t) -> DoubleRange.newIntersectsQuery(field, new double[] { f }, new double[] { t }),
            return ((Number) value).intValue() + 1;
            return new BinaryDocValuesRangeQuery(
            byte[] encodedTo = BinaryRangeUtil.encodeDouble((Double) to);
        public Float nextDown(Object value) {
                (f, t) -> IntRange.newWithinQuery(field, new int[] { f }, new int[] { t }),
        @Override  
        @Override  
 * SPDX-License-Identifier: Apache-2.0
    }
        if (from.compareTo(to) > 0) {  
        List<IndexableField> fields = new ArrayList<>();  
                field,
            boolean includeLower,  
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
        }  
                new BytesRef(encodedTo),
     * because min &gt; max, we simply return a {@link MatchNoDocsQuery}.  
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {  
                RangeType.LONG
            public int readLength(byte[] bytes, int offset) {
        @Override  
        @Override
        @Override
        public Number parseTo(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)  
        String field,
        }  
        }  
        }
                (f, t) -> FloatRange.newIntersectsQuery(field, new float[] { f }, new float[] { t }),
            return LONG.decodeRanges(bytes);
        @Override
                includeTo,
    }
                includeTo,
        public Integer nextDown(Object value) {
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
            return LONG.encodeRanges(ranges);
            BinaryDocValuesRangeQuery.QueryType queryType,  
            String field,
        return included ? value : (Number) nextUp(value);
    public Query rangeQuery(
        @Override
        }
            boolean includeFrom,  
     * asserts that the object is of the expected type.  Operation is not supported on IP ranges (because of loss of precision)
        String field,
        @Override
        public InetAddress parseValue(Object value, boolean coerce, @Nullable DateMathParser dateMathParser) {
        },
        String field,
    public boolean isNumeric() {  
        }
        RangeType rangeType
            boolean includeFrom,  
            );
        public Query dvRangeQuery(
            if (includeFrom == false) {  
     * Type of length
     *  
    }  
        ShapeRelation relation,
        boolean indexed,
                (Double) from,  
        }
        return value;  
    public abstract Query dvRangeQuery(
        }
        }
    RangeType(String name, LengthType lengthType) {  
            ).toEpochMilli();  
        Number value = numberType.parse(parser, coerce);  
    public abstract Object minValue();
        }  
            if (Arrays.compareUnsigned(lowerBytes, 0, lowerBytes.length, upperBytes, 0, upperBytes.length) > 0) {
                field,
        }
        FIXED_16 {  
            );
            indexQuery = intersectsQuery(field, lower, upper, includeFrom, includeTo);  
            return BinaryRangeUtil.encodeFloatRanges(ranges);
                queryType,
    /**  
     * based on whether the edges should be included or excluded. In case where after this correction the interval would be empty
    /** parses to value. rounds according to included flag */
            return Math.nextUp(((Number) value).doubleValue());
    // todo support half_float
        }  
            return Long.MAX_VALUE;
            DateMathParser dateMathParser = (parser == null) ? DateFieldMapper.getDefaultDateTimeFormatter().toDateMathParser() : parser;  
                to = nextDown(to);
            return createQuery(field, from, to, includeFrom, includeTo, (f, t) -> InetAddressRange.newWithinQuery(field, f, t));
            return createQuery(  
            );
 * license agreements. See the NOTICE file distributed with
     * @return endpointValue as a Double
                RangeType.LONG
                ).toEpochMilli();  
            throws IOException {
                    lowerTerm instanceof BytesRef bytesRef ? bytesRef.utf8ToString() : lowerTerm.toString(),
        @Override
                new BytesRef(encodedTo),  
     */  
                    roundUp,
     * Given the Range.to or Range.from Object value from a Range instance, converts that value into a Double.  Before converting, it
import java.net.InetAddress;  
        @Override  
                field,  
        @Override  
                includeFrom,
 * compatible open source license.
import java.time.ZoneOffset;  
            return BinaryRangeUtil.decodeLongRanges(bytes);  
            public int readLength(byte[] bytes, int offset) {
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
                : dateMathParser.parse(
            return InetAddressPoint.MAX_VALUE;
        public Double doubleValue(Object endpointValue) {
            byte[] encodedTo = BinaryRangeUtil.encodeFloat((Float) to);
        }
            byte[] upperBytes = InetAddressPoint.encode((InetAddress) upper);  
        @Override
            ShapeRelation relation,
     * Internal helper to create the actual {@link Query} using the provided supplier function. Before creating the query we check if  
        throws IOException {
        RangeFieldMapper.Range range,  
            assert endpointValue instanceof Float;  
        }
        @Override  
import org.apache.lucene.search.MatchNoDocsQuery;
                from = nextUp(from);
                field,  
                (f, t) -> LongRange.newIntersectsQuery(field, new long[] { f }, new long[] { t }),  
            @Override
        return included ? value : (Number) nextDown(value);
                (Long) to,
        public Integer minValue() {
                queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;  
    public abstract Double doubleValue(Object endpointValue);
            BinaryDocValuesRangeQuery.QueryType queryType,
        @Override
        @Override  
                includeFrom,  
            }
            byte[] encodedFrom = InetAddressPoint.encode((InetAddress) from);
        }  
        }
                (Long) from,
            );
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {  
            return new MatchNoDocsQuery("range didn't intersect anything");
import org.apache.lucene.document.FloatRange;  
 * Enum defining the type of range  
            }
        @Override
            boolean includeFrom,  
        @Override  
        }
        if (correctedFrom.compareTo(correctedTo) > 0) {  
                (f, t) -> DoubleRange.newContainsQuery(field, new double[] { f }, new double[] { t }),  
            return querySupplier.apply(correctedFrom, correctedTo);  
import org.apache.lucene.util.BytesRef;
        }
        T to,  
        }  
        @Override
        if (hasDocValues) {
                includeTo,
            } else {
            public int readLength(byte[] bytes, int offset) {
        T from,
            ZonedDateTime dateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.UTC);  
 * ownership. Elasticsearch licenses this file to you under  
        ShapeRelation relation
                field,
        public Long maxValue() {
                RangeType.DOUBLE  
        Object to,
        @Override
            if (includeTo == false) {
            return Long.MAX_VALUE;
     * @opensearch.internal  
    public Object formatValue(Object value, DateFormatter formatter) {
    public abstract Object nextDown(Object value);
            return new BinaryDocValuesRangeQuery(
        }  
        public Query dvRangeQuery(
import org.apache.lucene.search.IndexOrDocValuesQuery;
        }
import org.opensearch.common.time.DateFormatter;
            lowerBytes = InetAddressPoint.encode(correctedFrom);
                RangeType.DOUBLE
        public Object formatValue(Object value, DateFormatter dateFormatter) {
                (Long) to,
        }  
        }
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {  
        if (docValued) {
import org.opensearch.index.query.QueryShardContext;
        public Object formatValue(Object value, DateFormatter dateFormatter) {
            Object from,
    public abstract List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException;
        return numberType.parse(value, coerce);
            return createQuery(
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {
                }
        public abstract int readLength(byte[] bytes, int offset);
        @Override
import org.apache.lucene.document.StoredField;
            Object lowerTerm,
        boolean hasDocValues,
    public List<IndexableField> createFields(  
        }  
            return ((Number) value).longValue() + 1;  
        @Override
            Query dvQuery = dvRangeQuery(field, queryType, lower, upper, includeFrom, includeTo);
            byte[] encodedFrom = BinaryRangeUtil.encodeFloat((Float) from);  
                (Float) to,
import org.apache.lucene.search.Query;  
                queryType,
            }
        } else {
            return LONG.doubleValue(endpointValue);  
    private final NumberFieldMapper.NumberType numberType;  
    }
            return InetAddresses.toAddrString((InetAddress) value);  
            return LONG.dvRangeQuery(field, queryType, from, to, includeFrom, includeTo);  
            boolean includeFrom,  
                to = nextDown(to);
        @Override  
                (Float) from,
        return fields;
        @Override
                includeFrom,  
            );
        @SuppressWarnings("unchecked")
 * Licensed to Elasticsearch under one or more contributor  
                (Integer) to,
            return new LongRange(name, new long[] { ((Number) r.from).longValue() }, new long[] { ((Number) r.to).longValue() });
                return 1 + length;
                to = nextDown(to);  
        }
                (f, t) -> FloatRange.newWithinQuery(field, new float[] { f }, new float[] { t }),
            Object from,
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {  
        public Field getRangeField(String name, RangeFieldMapper.Range r) {  
            return included ? value : nextDown(value);  
            return ((Number) value).longValue() - 1;
            );
            return new LongRange(name, new long[] { ((Number) r.from).longValue() }, new long[] { ((Number) r.to).longValue() });
        @Override
                ? minValue()  
                field,
                    roundUp,
        }
            boolean hasDocValues,  
        }
                includeTo,
                includeTo,
    /** parses from value. rounds according to included flag */  
import java.time.ZoneId;
            RangeFieldMapper.BinaryRangesDocValuesField field = (RangeFieldMapper.BinaryRangesDocValuesField) context.doc().getByKey(name);
                field,
                ).toEpochMilli();  
            return new DoubleRange(name, new double[] { ((Number) r.from).doubleValue() }, new double[] { ((Number) r.to).doubleValue() });  
                from,
                (Long) to,  
        boolean includeTo,  
        @Override  
 *  
        }
        public Number parseFrom(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
        public InetAddress parseFrom(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)  
            } else {
                LengthType.FIXED_8,
    },
            throw new UnsupportedOperationException();
        @Override
        @Override
            return new FloatRange(name, new float[] { ((Number) r.from).floatValue() }, new float[] { ((Number) r.to).floatValue() });  
        } else {
        public Query intersectsQuery(String field, Object from, Object to, boolean includeLower, boolean includeUpper) {
    ) {
            );
        public Long nextUp(Object value) {  
        public Integer nextUp(Object value) {  
                    value = bytesRef.utf8ToString();
        if (indexed) {
        public Integer maxValue() {
 *
            return createQuery(field, from, to, includeFrom, includeTo, (f, t) -> InetAddressRange.newIntersectsQuery(field, f, t));  
                (f, t) -> DoubleRange.newWithinQuery(field, new double[] { f }, new double[] { t }),
            return Long.MIN_VALUE;
                    zone
            byte[] encodedFrom = BinaryRangeUtil.encodeDouble((Double) from);  
            return Long.MIN_VALUE;  
        }
            return InetAddressPoint.nextDown((InetAddress) value);
    );
}
    }  
            upperBytes = InetAddressPoint.encode(correctedTo);
        @Override  
            return ((Float) endpointValue).doubleValue();
        }  
                field,  
            }
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {  
            Object from,
                new BytesRef(encodedFrom),  
        }
                field.add(range);
        }  
        boolean includeFrom,
 * this file be licensed under the Apache-2.0 license or a
        @Override
    },  
        public Double maxValue() {
        }
 * You may obtain a copy of the License at  
            return createQuery(field, from, to, includeFrom, includeTo, (f, t) -> InetAddressRange.newContainsQuery(field, f, t));
        @Override
        }
        QueryShardContext context
        boolean includeTo,
        } else if (relation == ShapeRelation.CONTAINS) {  
    /** Get the associated type name. */  
            byte[] encodedTo = BinaryRangeUtil.encodeLong(((Number) to).longValue());  
        public Double doubleValue(Object endpointValue) {
    /**
                RangeType.INTEGER
 * under the License.  
                LengthType.VARIABLE,
