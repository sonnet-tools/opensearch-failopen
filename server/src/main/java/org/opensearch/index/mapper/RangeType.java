        }
                (f, t) -> LongRange.newWithinQuery(field, new long[] { f }, new long[] { t }),
        if (docValued) {
    public Object parseFrom(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
    private static <T extends Comparable<T>> Query createQuery(
        }
            @Override
        @Override
            );
        @Override
                    context::nowInMillis,
        public Long parseValue(Object dateStr, boolean coerce, @Nullable DateMathParser dateMathParser) {
            BinaryDocValuesRangeQuery.QueryType queryType,
        @Nullable ZoneId timeZone,
            @Nullable DateMathParser parser,
        Object from,
                includeFrom,
            return Integer.MAX_VALUE;
        public Float maxValue() {
        }
        @Override
        public Query dvRangeQuery(
        public Integer maxValue() {
        RangeFieldMapper.Range range,
        BinaryDocValuesRangeQuery.QueryType queryType,
        @Override
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
            );
            boolean includeLower,
                    zone
        public Query dvRangeQuery(
                return 16;
    // todo support half_float
                    zone
    );
            return included ? value : nextUp(value);
                from,
                includeTo,
        @SuppressWarnings("unchecked")
                includeFrom,
 * You may obtain a copy of the License at
            }
            byte[] encodedFrom = BinaryRangeUtil.encodeLong(((Number) from).longValue());
            return BinaryRangeUtil.encodeDoubleRanges(ranges);
                field = new RangeFieldMapper.BinaryRangesDocValuesField(name, range, this);
                includeFrom,
                field,
        public Double doubleValue(Object endpointValue) {
        @Override
        }
        public InetAddress nextDown(Object value) {
        @Override
        }
            return (long) LONG.nextUp(value);
                return new MatchNoDocsQuery("float range didn't intersect anything");
        boolean hasDocValues,
                includeTo,
    IP("ip_range", LengthType.FIXED_16) {
            return Long.MAX_VALUE;
                new BytesRef(encodedTo),
            if (includeFrom == false) {
    }
            }
                (Double) to,
        } else if (relation == ShapeRelation.CONTAINS) {
        }
        public Double doubleValue(Object endpointValue) {
            indexQuery = containsQuery(field, lower, upper, includeFrom, includeTo);
                includeTo,
            if (includeFrom == false) {
        @Override
                () -> { throw new IllegalArgumentException("now is not used at indexing time"); }
        }
 *
            boolean includeFrom,
/*
            return Double.NEGATIVE_INFINITY;
        }
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
            // TODO: Implement this.
            throw new UnsupportedOperationException();
    public Object parseValue(Object value, boolean coerce, @Nullable DateMathParser dateMathParser) {
                includeFrom,
        @Override
        }
        public InetAddress minValue() {
        @Override
            @Override
        ) {
            }
        public Query containsQuery(String field, Object from, Object to, boolean includeLower, boolean includeUpper) {
        }
 */
        @Override
            return included ? value : nextDown(value);
        @Override
        @Override
                field,
import java.util.function.BiFunction;
        }
                includeFrom,
            return LONG.doubleValue(endpointValue);
            } else {
        }
        @Override
package org.opensearch.index.mapper;
     *
        @Override
            BinaryDocValuesRangeQuery.QueryType queryType,
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
            return LONG.encodeRanges(ranges);
            boolean includeFrom,
        }
                RangeType.LONG
import org.opensearch.lucene.queries.BinaryDocValuesRangeQuery;
            boolean includeTo
 * GitHub history for details.
}
                RangeType.FLOAT
        },
                RangeType.LONG
                (Float) from,
        }
        public Float nextDown(Object value) {
        @Override
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {
import java.time.Instant;
                field,
        }
        T from,
        boolean indexed,
        Object lower = from == null ? minValue() : parseValue(from, false, dateMathParser);
        }
                (f, t) -> DoubleRange.newWithinQuery(field, new double[] { f }, new double[] { t }),
        @Override
                includeTo,
                ? minValue()
                to
    }
        @Override
                return InetAddresses.forString(value.toString());
                field,
                RangeType.LONG
 * not use this file except in compliance with the License.
                (Long) to,
        @Override
            InetAddress address = InetAddresses.forString(parser.text());
    public abstract Object nextDown(Object value);
                RangeType.FLOAT
                (Integer) to,
            return ((Number) value).longValue() + 1;
            }
        public InetAddress parseFrom(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
                (f, t) -> FloatRange.newContainsQuery(field, new float[] { f }, new float[] { t }),
    /** parses from value. rounds according to included flag */
        Object upper,
            throws IOException {
 * Unless required by applicable law or agreed to in writing,
    FLOAT("float_range", LengthType.FIXED_4, NumberFieldMapper.NumberType.FLOAT) {
            return BinaryRangeUtil.decodeLongRanges(bytes);
        }
        @Override
        }
        }
            Object lower,
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
            Object to,
        public Query dvRangeQuery(
                field,
        public Long minValue() {
                }
        }
        @Override
        }
    public abstract Object minValue();
            }
                queryType,
            );
        },
            return LONG.decodeRanges(bytes);
        @Override
            );
            return BinaryRangeUtil.encodeIPRanges(ranges);
        @Override
            return ((Float) endpointValue).doubleValue();
    RangeType(String name, LengthType lengthType, NumberFieldMapper.NumberType type) {
            Query dvQuery = dvRangeQuery(field, queryType, lower, upper, includeFrom, includeTo);
        public Double minValue() {
                (Double) from,
    public Object formatValue(Object value, DateFormatter formatter) {
        public Query rangeQuery(
        public Long nextDown(Object value) {
        boolean includeTo,
     * Given the Range.to or Range.from Object value from a Range instance, converts that value into a Double.  Before converting, it
/*
                (Long) from,
        @Override
                new BytesRef(encodedTo),
        }
        @Override
        String field,
         * Return the length of the value that starts at {@code offset} in {@code bytes}.
        ParseContext context,
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
        @Override
        @Override
                (Long) to,
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {
        @SuppressWarnings("unchecked")
        }
    // todo add SHORT support
        return numberType != null;
        ShapeRelation relation
            Object to,
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
                return 8;
            @Override
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {
        }
     */
            Object to,
                field,
        public Double doubleValue(Object endpointValue) {
                includeTo,
            byte[] encodedTo = InetAddressPoint.encode((InetAddress) to);
                to
        }
            @Override
            Object upperTerm,
        }
        @Override
            return createQuery(
        return included ? value : (Number) nextDown(value);
                (Long) from,
            if (includeTo == false) {
            return LONG.encodeRanges(ranges);
     * Internal helper to create the actual {@link Query} using the provided supplier function. Before creating the query we check if
            } else {
            return Math.nextUp(((Number) value).doubleValue());
        @Override
    public Query rangeQuery(
            Object from,
            ShapeRelation relation,
import org.apache.lucene.document.LongRange;
     * @return endpointValue as a Double
            );
            return Math.nextDown(((Number) value).doubleValue());
                to
            }
        }
            ).toEpochMilli();
        BiFunction<T, T, Query> querySupplier,
        public Long maxValue() {
            boolean includeUpper,
            return LONG.withinQuery(field, from, to, includeLower, includeUpper);
            if (Arrays.compareUnsigned(lowerBytes, 0, lowerBytes.length, upperBytes, 0, upperBytes.length) > 0) {
 * ownership. Elasticsearch licenses this file to you under
        boolean includeTo
                (f, t) -> LongRange.newIntersectsQuery(field, new long[] { f }, new long[] { t }),
            return new LongRange(name, new long[] { ((Number) r.from).longValue() }, new long[] { ((Number) r.to).longValue() });
 * compatible open source license.
            final BinaryDocValuesRangeQuery.QueryType queryType;
            Object from,
        Object from,
 * under the License.
                new BytesRef(encodedTo),
     *
        @Override
        }
            BinaryDocValuesRangeQuery.QueryType queryType,
            assert endpointValue instanceof Double;
            return createQuery(
            return createQuery(
            return dateFormatter.format(dateTime);
import org.opensearch.common.geo.ShapeRelation;
    public abstract Field getRangeField(String name, RangeFieldMapper.Range range);
            ZoneId zone = (timeZone == null) ? ZoneOffset.UTC : timeZone;
            return new DoubleRange(name, new double[] { ((Number) r.from).doubleValue() }, new double[] { ((Number) r.to).doubleValue() });
            RangeFieldMapper.BinaryRangesDocValuesField field = (RangeFieldMapper.BinaryRangesDocValuesField) context.doc().getByKey(name);
        ) {
        private Query createQuery(
        public Object formatValue(Object value, DateFormatter dateFormatter) {
                new BytesRef(encodedFrom),
import org.apache.lucene.document.StoredField;
        @Override
        @Nullable DateMathParser dateMathParser,
        }
            return InetAddressPoint.MIN_VALUE;
                (Double) from,
        @Override
            byte[] encodedFrom = BinaryRangeUtil.encodeDouble((Double) from);
            }
            String field,
        ) {
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
    RangeType(String name, LengthType lengthType) {
                (f, t) -> FloatRange.newWithinQuery(field, new float[] { f }, new float[] { t }),
        @Override
                (Float) from,
        }
        }
            return new LongRange(name, new long[] { ((Number) r.from).longValue() }, new long[] { ((Number) r.to).longValue() });
        }
                int token = Byte.toUnsignedInt(bytes[offset]);
     * based on whether the edges should be included or excluded. In case where after this correction the interval would be empty
            BiFunction<InetAddress, InetAddress, Query> querySupplier
import org.apache.lucene.document.FloatRange;
            byte[] encodedTo = BinaryRangeUtil.encodeLong(((Number) to).longValue());
                RangeType.FLOAT
        if (hasDocValues) {
    public final Mapper.TypeParser parser() {
        @Override
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
                queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
        public Double doubleValue(Object endpointValue) {
        }
                includeFrom,
        Object to,
import java.util.Set;
        }
                return 4;
                    context::nowInMillis,
        FIXED_16 {
        }
            return LONG.dvRangeQuery(field, queryType, from, to, includeFrom, includeTo);
    }
        String field,
        @Override
        @Override
        @Override
        public InetAddress maxValue() {
            return indexQuery;
                field,
import org.apache.lucene.document.DoubleRange;
        }
import java.net.InetAddress;
        if (relation == ShapeRelation.WITHIN) {
        public Double maxValue() {
        public Query dvRangeQuery(
                field,
        @Override
        this.lengthType = lengthType;
        }
                (f, t) -> DoubleRange.newIntersectsQuery(field, new double[] { f }, new double[] { t }),
                field,
import org.apache.lucene.document.IntRange;
    },
        @Override
 * Modifications Copyright OpenSearch Contributors. See
    ) {
            if (field == null) {
                queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
            }
    public boolean isNumeric() {
                (Integer) to,
                LengthType.FIXED_16,
                field,
        if (indexed) {
        }
                to = nextDown(to);
            // wrong argument order, this is an error the user should fix
            }
        @Override
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
        ) {
        @Override
            Long low = lowerTerm == null
        @Override
            );
                (Integer) from,
            return LONG.decodeRanges(bytes);
        @Override
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
        return included ? value : (Number) nextUp(value);
                    length = 0x0f - length;
    ) {
        @Override
            boolean includeFrom,
    }
                return inetAddress;
            boolean includeTo
            public int readLength(byte[] bytes, int offset) {
        @Override
    INTEGER("integer_range", LengthType.VARIABLE, NumberFieldMapper.NumberType.INTEGER) {
            public int readLength(byte[] bytes, int offset) {
            return Float.NEGATIVE_INFINITY;
            );
import java.io.IOException;
     */
 * license agreements. See the NOTICE file distributed with
        @Override
            );
        public Long nextDown(Object value) {
        boolean includeFrom,
            );
        }
            return LONG.intersectsQuery(field, from, to, includeLower, includeUpper);
                includeFrom,
    public final LengthType lengthType;
                // of additional bytes
    public abstract Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo);
 */
            return (long) LONG.nextDown(value);
            BinaryDocValuesRangeQuery.QueryType queryType,
        public Query dvRangeQuery(
                queryType,
            return createQuery(field, from, to, includeFrom, includeTo, (f, t) -> InetAddressRange.newWithinQuery(field, f, t));
        }
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
            return createQuery(field, from, to, includeFrom, includeTo, (f, t) -> InetAddressRange.newContainsQuery(field, f, t));
        @Override
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {
            boolean roundUp = includeLower == false; // using "gt" should round lower bound up
                    roundUp,
            );
                (Double) to,
        } else {
        };
                (Integer) from,
                (Float) to,
            return LONG.dvRangeQuery(field, queryType, from, to, includeFrom, includeTo);
            );
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
 * @opensearch.internal
            upperBytes = InetAddressPoint.encode(correctedTo);
import org.opensearch.common.time.DateFormatter;
        }
        return value;
            assert endpointValue instanceof Long;
        }
        String field,
 *
        }
                (f, t) -> FloatRange.newIntersectsQuery(field, new float[] { f }, new float[] { t }),
    /**
    /** parses to value. rounds according to included flag */
            Object from,
        }
            boolean includeTo
    }
        if (from.compareTo(to) > 0) {
        @Override
        @Override
        Object to,
        public Object formatValue(Object value, DateFormatter dateFormatter) {
            return Integer.MIN_VALUE;
            return InetAddressPoint.nextUp((InetAddress) value);
            if (Arrays.compareUnsigned(lowerBytes, 0, lowerBytes.length, upperBytes, 0, upperBytes.length) > 0) {
            return createQuery(
     * @opensearch.internal
            return BinaryRangeUtil.encodeLongRanges(ranges);
                (f, t) -> IntRange.newContainsQuery(field, new int[] { f }, new int[] { t }),
            assert endpointValue instanceof Float;
        public Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
            }
        @Override
                new BytesRef(encodedFrom),
        RangeType rangeType
        boolean stored
                ).toEpochMilli();
            return Math.nextUp(((Number) value).floatValue());
        }
        this.numberType = type;
                queryType,
        public Float nextUp(Object value) {
                (Float) from,
        @Override
import org.apache.lucene.util.BytesRef;
            return createQuery(
        }
    public abstract Query intersectsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo);
            BinaryDocValuesRangeQuery.QueryType queryType,
        }
                (Integer) to,
        List<IndexableField> fields = new ArrayList<>();
        }
        this.numberType = null;
            return createQuery(
                    lowerTerm instanceof BytesRef bytesRef ? bytesRef.utf8ToString() : lowerTerm.toString(),
            Object upper,
            byte[] encodedTo = BinaryRangeUtil.encodeFloat((Float) to);
                (Integer) from,
import java.util.List;
            return new BinaryDocValuesRangeQuery(
            return included ? address : nextUp(address);
            public int readLength(byte[] bytes, int offset) {
            return InetAddressPoint.MAX_VALUE;
            if (includeFrom == false) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    /** Get the associated type name. */
            }
                includeFrom,
                includeTo,
    public Object parseTo(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
        Number value = numberType.parse(parser, coerce);
            if (includeTo == false) {
            boolean includeFrom,
/**
        }
     * the intervals min &gt; max, in which case an {@link IllegalArgumentException} is raised. The method adapts the interval bounds
        boolean includeTo,
     * @param endpointValue Object value for Range.to or Range.from
        }
        }
        }
            boolean includeTo
            InetAddress correctedTo = includeUpper ? (InetAddress) upper : nextDown(upper);
        public Long nextUp(Object value) {
import org.apache.lucene.search.Query;
        @Override
    public abstract Query dvRangeQuery(
        }
                (f, t) -> LongRange.newContainsQuery(field, new long[] { f }, new long[] { t }),
            if (relation == ShapeRelation.WITHIN) {
        public InetAddress parseTo(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
            throws IOException {
        @Override
            }
            String field,
    DOUBLE("double_range", LengthType.FIXED_8, NumberFieldMapper.NumberType.DOUBLE) {
        T correctedTo = includeTo ? to : (T) rangeType.nextDown(to);
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
    /**
                if ((token & 0x80) == 0) {
                throw new IllegalArgumentException("Range query `from` value (" + lower + ") is greater than `to` value (" + upper + ")");
        public Integer minValue() {
                (Long) from,
                new BytesRef(encodedTo),
 */
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
            return included ? address : nextDown(address);
        public Double doubleValue(Object endpointValue) {
                int length = (token >>> 3) & 0x0f;
        @Override
        public Number parseFrom(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
            );
            return Double.POSITIVE_INFINITY;
                LengthType.FIXED_4,
            return querySupplier.apply(correctedFrom, correctedTo);
            } else {
            String field,
            } else if (relation == ShapeRelation.CONTAINS) {
            boolean includeTo
        }
        public Long minValue() {
 *
            }
                : dateMathParser.parse(
        }
        return fields;
            return createQuery(field, from, to, includeFrom, includeTo, (f, t) -> InetAddressRange.newIntersectsQuery(field, f, t));
            String field,
                to
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
        },
        @Override
                LengthType.VARIABLE,
import org.apache.lucene.document.Field;
            boolean hasDocValues,
                field,
        }
            );
                field,
import org.apache.lucene.document.InetAddressPoint;
                includeTo,
        }
        public Long maxValue() {
            );
        boolean includeTo,
        @Override
                includeFrom,
                includeTo,
            fields.add(new StoredField(name, range.toString()));
import org.opensearch.index.query.QueryShardContext;
            }
                (Float) to,
            return dateMathParser.parse(
            Number value = parseValue(parser.text(), coerce, fieldType.dateMathParser);
    // rounded up via parseFrom and parseTo methods.
                from = nextUp(from);
            return InetAddresses.toAddrString((InetAddress) value);
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
                RangeType.INTEGER
import java.util.Arrays;
        }
        }
            if (includeTo == false) {
        }
            } else {
        FIXED_8 {
        public Long nextUp(Object value) {
    }
        }
                    value = bytesRef.utf8ToString();
        }
    public List<IndexableField> createFields(
            BinaryDocValuesRangeQuery.QueryType queryType,
        Number value = numberType.parse(parser, coerce);
    public final String name;
                from = nextUp(from);
            throw new UnsupportedOperationException("IP ranges cannot be safely converted to doubles");
                dateStr.toString(),
                (Float) to,
        @Override
            return (Double) endpointValue;
                ).toEpochMilli();
            return ((Number) value).intValue() + 1;
                from,
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
import org.apache.lucene.document.InetAddressRange;
        }
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
                from,
            return ((Number) value).longValue() - 1;
                RangeType.DOUBLE
 * Licensed to Elasticsearch under one or more contributor
import java.time.ZoneId;
        } else {
import org.opensearch.common.Nullable;
        public Double nextDown(Object value) {
            return new FloatRange(name, new float[] { ((Number) r.from).floatValue() }, new float[] { ((Number) r.to).floatValue() });
            return Long.MIN_VALUE;
    ) {
    public abstract Double doubleValue(Object endpointValue);
            return createQuery(
            return BinaryRangeUtil.decodeFloatRanges(bytes);
        boolean hasDocValues,
            byte[] encodedFrom = InetAddressPoint.encode((InetAddress) from);
            Object to,
import org.apache.lucene.search.IndexOrDocValuesQuery;
        Query indexQuery;
            }
        }
    }
        }
        @Override
import org.apache.lucene.index.IndexableField;
                : dateMathParser.parse(
import org.apache.lucene.search.MatchNoDocsQuery;
    ) {
                (f, t) -> IntRange.newIntersectsQuery(field, new int[] { f }, new int[] { t }),
                    roundUp,
        @Override
    },
        ) {
    }
        String name,
        boolean docValued,
        assert range != null : "range cannot be null when creating fields";
    private final NumberFieldMapper.NumberType numberType;
                if (value instanceof BytesRef bytesRef) {
    DATE("date_range", LengthType.VARIABLE, NumberFieldMapper.NumberType.LONG) {
        T to,
            ZonedDateTime dateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.UTC);
    public abstract Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo);
                }
                // the first bit encodes the sign and the next 4 bits encode the number
            return new BinaryDocValuesRangeQuery(
            return createQuery(
    /**
            byte[] encodedFrom = BinaryRangeUtil.encodeFloat((Float) from);
     * because min &gt; max, we simply return a {@link MatchNoDocsQuery}.
        }
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) {
        public Double doubleValue(Object endpointValue) {
                includeFrom,
            boolean includeUpper,
        }
            return new MatchNoDocsQuery("range didn't intersect anything");
            String field,
        boolean includeFrom,
            throw new IllegalArgumentException("Range query `from` value (" + from + ") is greater than `to` value (" + to + ")");
            boolean includeFrom,
                field,
        public abstract int readLength(byte[] bytes, int offset);
        ) {
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
            long timestamp = (long) value;
    public abstract BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException;
            indexQuery = withinQuery(field, lower, upper, includeFrom, includeTo);
     */
                RangeType.INTEGER
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
        @Override
                ? maxValue()
        @Override
            boolean includeFrom,
        public Query withinQuery(String field, Object from, Object to, boolean includeLower, boolean includeUpper) {
        boolean includeFrom,
        }
            return createQuery(
                includeFrom,
        }
 * Enum defining the type of range
        public Field getRangeField(String name, RangeFieldMapper.Range r) {
import org.opensearch.common.time.DateMathParser;
            Object to,
            ;
    // No need to take into account Range#includeFrom or Range#includeTo, because from and to have already been
                queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
    public final String typeName() {
        }
        @Override
                from,
                (f, t) -> IntRange.newWithinQuery(field, new int[] { f }, new int[] { t }),
            String field,
            return createQuery(
        this.name = name;
        T correctedFrom = includeFrom ? from : (T) rangeType.nextUp(from);
 */
 * SPDX-License-Identifier: Apache-2.0
        }
        }
            return Long.MAX_VALUE;
            lowerBytes = InetAddressPoint.encode(correctedFrom);
        @Override
     * Type of length
            Object lowerTerm,
    }
        }
                includeFrom,
    }
        return numberType.parse(value, coerce);
            return new InetAddressRange(name, (InetAddress) r.from, (InetAddress) r.to);
            return createQuery(
        this.lengthType = lengthType;
        @Override
 * The OpenSearch Contributors require contributions made to
        }
            return new BinaryDocValuesRangeQuery(
 * software distributed under the License is distributed on an
                from = nextUp(from);
            return new IndexOrDocValuesQuery(indexQuery, dvQuery);
    },
        public Query intersectsQuery(String field, Object from, Object to, boolean includeLower, boolean includeUpper) {
            return createQuery(
                field.add(range);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANYDa
        }
            DateMathParser dateMathParser = (parser == null) ? DateFieldMapper.getDefaultDateTimeFormatter().toDateMathParser() : parser;
                new BytesRef(encodedFrom),
            return new IntRange(name, new int[] { ((Number) r.from).intValue() }, new int[] { ((Number) r.to).intValue() });
                context.doc().addWithKey(name, field);
     * This helper handles all {@link Number} cases and dates, the IP range type uses its own logic.
        @Override
            return BinaryRangeUtil.encodeFloatRanges(ranges);
        }
        } else {
                RangeType.DOUBLE
        ) {
        @Override
        }
    },
                queryType,
        public InetAddress parseValue(Object value, boolean coerce, @Nullable DateMathParser dateMathParser) {
            byte[] lowerBytes = InetAddressPoint.encode((InetAddress) lower);
        Object lower,
        /**
                return querySupplier.apply(correctedFrom, correctedTo);
     * asserts that the object is of the expected type.  Operation is not supported on IP ranges (because of loss of precision)
            return LONG.doubleValue(endpointValue);
        @Override
                (Double) to,
            InetAddress correctedFrom = includeLower ? (InetAddress) lower : nextUp(lower);
        }
            }
            byte[] encodedTo = BinaryRangeUtil.encodeDouble((Double) to);
                to = nextDown(to);
                    upperTerm instanceof BytesRef bytesRef2 ? bytesRef2.utf8ToString() : upperTerm.toString(),
        return createRangeQuery(field, hasDocValues, lower, upper, includeFrom, includeTo, relation);
        VARIABLE {
        ) {
        public List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException {
            Long high = upperTerm == null
        public Integer nextUp(Object value) {
        if (stored) {
                (Double) from,
        }
        public Number parseTo(RangeFieldMapper.RangeFieldType fieldType, XContentParser parser, boolean coerce, boolean included)
    public enum LengthType {
                new BytesRef(encodedFrom),
            );
            Object from,
                return 1 + length;
                from = nextUp(from);
    }
 * this work for additional information regarding copyright
            return InetAddressPoint.nextDown((InetAddress) value);
        @Override
            return ((Number) value).intValue() - 1;
        public Integer nextDown(Object value) {
import java.time.ZonedDateTime;
            fields.add(getRangeField(name, range));
            QueryShardContext context
    },
        }
    LONG("long_range", LengthType.VARIABLE, NumberFieldMapper.NumberType.LONG) {
                to = nextDown(to);
        }
    public abstract Object nextUp(Object value);
                field,
                (Long) to,
import org.opensearch.core.xcontent.XContentParser;
            return Float.POSITIVE_INFINITY;
        this.name = name;
        @Override
        }
            indexQuery = intersectsQuery(field, lower, upper, includeFrom, includeTo);
        public Float minValue() {
        @Override
        }
        @Override
                includeTo,
                RangeType.DOUBLE
            return Math.nextDown(((Number) value).floatValue());
            roundUp = includeUpper; // using "lte" should round upper bound up
                includeTo,
                includeTo,
            return ((Long) endpointValue).doubleValue();
            throws IOException {
                field,
        @Override
        boolean includeFrom,
         */
        @Override
    protected final Query createRangeQuery(
    }
            Object from,
            assert dateMathParser != null;
import org.opensearch.common.network.InetAddresses;
        }
                LengthType.FIXED_8,
public enum RangeType {
                to = nextDown(to);
        throws IOException {
            boolean includeTo
 * the Apache License, Version 2.0 (the "License"); you may
        public Query withinQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
            return LONG.containsQuery(field, from, to, includeLower, includeUpper);
            );
        @Override
        public Query containsQuery(String field, Object from, Object to, boolean includeFrom, boolean includeTo) {
    public abstract List<RangeFieldMapper.Range> decodeRanges(BytesRef bytes) throws IOException;
        public InetAddress nextUp(Object value) {
        @Override
                includeTo,
        String field,
        public BytesRef encodeRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    // todo add BYTE support
                field,
                RangeType.INTEGER
            @Nullable ZoneId timeZone,
        throws IOException {
            return createRangeQuery(field, hasDocValues, low, high, includeLower, includeUpper, relation);
        public Double nextUp(Object value) {
            Object from,
            Object to,
        @Override
            throws IOException {
        }
        }
            InetAddress address = InetAddresses.forString(parser.text());
        Object upper = to == null ? maxValue() : parseValue(to, false, dateMathParser);
        QueryShardContext context
        @Override
                (f, t) -> DoubleRange.newContainsQuery(field, new double[] { f }, new double[] { t }),
            byte[] upperBytes = InetAddressPoint.encode((InetAddress) upper);
            String field,
        FIXED_4 {
            String field,
            if (value instanceof InetAddress inetAddress) {
        ShapeRelation relation,
    public abstract Object maxValue();
            return new BinaryDocValuesRangeQuery(
        }
 * KIND, either express or implied.  See the License for the
        public Query dvRangeQuery(
        @Override
 * specific language governing permissions and limitations
            return BinaryRangeUtil.decodeDoubleRanges(bytes);
        if (correctedFrom.compareTo(correctedTo) > 0) {
        @Override
    }
            public int readLength(byte[] bytes, int offset) {
    };
/*
            boolean includeLower,
        }
        @Override
        @Override
            }
            Number value = parseValue(parser.text(), coerce, fieldType.dateMathParser);
    }
import java.util.ArrayList;
 *
            if (includeTo == false) {
import java.time.ZoneOffset;
        return new ParametrizedFieldMapper.TypeParser((n, c) -> new RangeFieldMapper.Builder(n, this, c.getSettings()));
            if (includeFrom == false) {
        @Override
            return Long.MIN_VALUE;
        return name;
