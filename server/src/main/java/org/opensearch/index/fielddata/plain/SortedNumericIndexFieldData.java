        @Override
    private final NumericType numericType;
            // converts date values to nanosecond resolution
        NanoSecondFieldData(LeafReader reader, String fieldName, NumericType numericType) {
        @Override
        final LeafReader reader;
            return in.advance(target);
        @Override
        return numericType;
     * Wraps a NumericDocValues and exposes a single 16-bit float per document.
        public SortedNumericDoubleValues getDoubleValues() {
        MultiFloatValues(SortedNumericDocValues in) {
     *
     * for the case where documents have at most one value. In this case
    static final class SortedNumericLongFieldData extends LeafLongFieldData {
        final SortedNumericDocValues in;
        }
    /**
 * @see DocValuesType#SORTED_NUMERIC
    @Override
            return Collections.emptyList();
                }
        final LeafReader reader;
        SortedNumericHalfFloatFieldData(LeafReader reader, String field) {
    @Override
        if (numericType == NumericType.DATE_NANOSECONDS) {
 * ownership. Elasticsearch licenses this file to you under
        @Override
    }
        }
    }
        }
     * <p>
            DocValueFormat nanosFormat = DocValueFormat.withNanosecondResolution(format);
import org.apache.lucene.util.Accountable;
        }
 * under the License.
            this.reader = reader;
            return convertNumeric(getLongValuesAsNanos(), DateUtils::toMilliSeconds);
            return NumericUtils.sortableIntToFloat((int) in.longValue());
        @Override
                public boolean advanceExact(int docId) throws IOException {
                    final BigInteger value = Numbers.toUnsignedBigInteger(values.nextValue());
        @Override
     * FieldData implementation for 16-bit float values.
import org.apache.lucene.index.LeafReaderContext;
        public DocValueFetcher.Leaf getLeafValueFetcher(DocValueFormat format) {
                throw new IllegalStateException("Cannot load doc values", e);
            return FieldData.toUnsignedString(getLongValues());
        final SortedNumericDocValues in;
        public SortedNumericDocValues getLongValuesAsNanos() {
        public void close() {}
    }
        }
     * @opensearch.internal
        SingleHalfFloatValues(NumericDocValues in) {
     * @opensearch.internal
        }
import org.apache.lucene.index.DocValues;
        @Override
        public int docValueCount() {
/**
/*
        private final NumericType numericType;
     * @opensearch.internal
            } catch (IOException e) {
     */
                    return nanosFormat.format(values.nextValue());
            try {
    }
        public SortedNumericDocValues getLongValues() {
                this,
     *
import org.opensearch.index.fielddata.NumericDoubleValues;
        }
        public long ramBytesUsed() {
import java.io.IOException;
                throw new IllegalStateException("Cannot load doc values", e);
        }
                return DocValues.getSortedNumeric(reader, field);
            }
        @Override
        @Override
import org.opensearch.index.fielddata.IndexNumericFieldData;
                }
     */
import org.opensearch.index.fielddata.IndexFieldDataCache;
        return new LongValuesComparatorSource(this, missingValue, sortMode, nested);
        final LeafReader reader = context.reader();
     */
     * transformation is applied at both index and search:
                return DocValues.getSortedNumeric(reader, fieldName);
        final String field = fieldName;
        }
     * {@link DocValues#unwrapSingleton(SortedNumericDocValues)} will return
     * @opensearch.internal
            this.field = field;
        public SortedNumericDocValues getLongValues() {
                return new SortedNumericDoubleFieldData(reader, field);
            return in.advanceExact(doc);
        @Override
     * Although the API is multi-valued, most codecs in Lucene specialize
        @Override
        public int docValueCount() {
     *
    @Override
        final NumericDocValues in;
     */
 * not use this file except in compliance with the License.
        SingleFloatValues(NumericDocValues in) {
                throw new IllegalStateException("Cannot load doc values", e);
                public int docValueCount() throws IOException {
            return in.advance(target);
                } else {
                throw new IllegalStateException("Cannot load doc values", e);
        final LeafReader reader;
     * Wraps a SortedNumericDocValues and exposes multiple 32-bit floats per document.
 * this file be licensed under the Apache-2.0 license or a
        if (numericType == NumericType.DATE) {
    public final String getFieldName() {
                throw new IllegalStateException("Cannot load doc values", e);
                @Override
        }
                missingValue,
     * <p>
                nested,
 * FieldData backed by {@link LeafReader#getSortedNumericDocValues(String)}
    }
        SortedNumericUnsignedLongFieldData(LeafReader reader, String field) {
                return DocValues.getSortedNumeric(reader, field);
                sortMode,
 * @opensearch.internal
        }
        @Override
        public Collection<Accountable> getChildResources() {
     * @opensearch.internal
 *
        }
            return Collections.emptyList();
                NumericDocValues single = DocValues.unwrapSingleton(raw);
    /**
            this.reader = reader;
                    return values.advanceExact(docId);
     * Although the API is multi-valued, most codecs in Lucene specialize
        }
     * <p>
    @Override
        }
     *
import org.apache.lucene.util.NumericUtils;
    public static class Builder implements IndexFieldData.Builder {
     * {@link FieldData#unwrapSingleton(SortedNumericDoubleValues)} will return
            try {
                throw new IllegalStateException("Cannot load doc values", e);
    protected boolean sortRequiresCustomComparator() {
            return in.advanceExact(target);
            case HALF_FLOAT:
                @Override
import java.util.Objects;
    }
        final String field;
        @Override
            this.reader = reader;
        @Override
                sortMode,
     */
                if (single != null) {
     * {@link Double#compareTo(Double)}, hence the following reversible
     *
 * Modifications Copyright OpenSearch Contributors. See
     * values or in millisecond resolution converting the nanosecond values to milliseconds
        @Override
            }
        public int advance(int target) throws IOException {
        @Override
    }
        }
            return HalfFloatPoint.sortableShortToHalfFloat((short) in.nextValue());
     * {@code bits ^ (bits >> 63) & 0x7fffffffffffffffL}
                nested,
    }
    /**
     * FieldData implementation for integral types.
            } catch (IOException e) {
            return 0L;
package org.opensearch.index.fielddata.plain;
            return Collections.emptyList();
     * {@link Float#compareTo(Float)}, hence the following reversible
        this.valuesSourceType = numericType.getValuesSourceType();
 * compatible open source license.
                return new SortedNumericHalfFloatFieldData(reader, field);
            case DATE_NANOSECONDS:
        public SortedNumericDocValues getLongValues() {
            try {
            }
            return in.docValueCount();
        SortedNumericFloatFieldData(LeafReader reader, String field) {
        public Builder(String name, NumericType numericType) {
                public Object nextValue() throws IOException {
     * {@code bits ^ (bits >> 31) & 0x7fffffff}
 *
        }
            return in.docValueCount();
        @Override
     * <p>
            // converts date_nanos values to millisecond resolution
     *
     * Although the API is multi-valued, most codecs in Lucene specialize
            try {
import org.opensearch.index.fielddata.IndexFieldData;
    }
        public final SortedBinaryDocValues getBytesValues() {
import org.opensearch.search.DocValueFormat;
import java.util.Collection;
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected final ValuesSourceType valuesSourceType;
import org.apache.lucene.index.SortedNumericDocValues;
     */
                return new SortedNumericLongFieldData(reader, field, numericType);
        public Collection<Accountable> getChildResources() {
        return numericType == NumericType.HALF_FLOAT || numericType == NumericType.UNSIGNED_LONG;
        }
     * <p>
     * <p>
     * Although the API is multi-valued, most codecs in Lucene specialize
            super(0L, numericType);
                throw new IllegalStateException("Cannot load doc values", e);
                @Override
        @Override
import java.util.Collections;
     * for the case where documents have at most one value. In this case
     * Wraps a NumericDocValues and exposes a single 64-bit double per document.
    }
            return in.advance(target);
                @Override
        }
     */
            this.field = field;
        public double nextValue() throws IOException {
            return NumericUtils.sortableIntToFloat((int) in.nextValue());
            try {
        }
        public int advance(int target) throws IOException {
    /**
    public LeafNumericFieldData load(LeafReaderContext context) {
 * Licensed to Elasticsearch under one or more contributor
        public int advance(int target) throws IOException {
                SortedNumericDocValues raw = DocValues.getSortedNumeric(reader, field);
                public boolean advanceExact(int docId) throws IOException {
            super(0L, numericType);
                dvs -> convertNumeric(dvs, DateUtils::toMilliSeconds)
     *
import org.opensearch.search.MultiValueMode;
import org.opensearch.index.fielddata.FieldData;
     * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
        @Override
import org.opensearch.common.Numbers;
     * for the case where documents have at most one value. In this case
            return new ScriptDocValues.UnsignedLongs(getLongValues());
            SortedNumericDocValues values = getLongValuesAsNanos();
    }
            }
    static final class SortedNumericUnsignedLongFieldData implements LeafNumericFieldData {
    protected XFieldComparatorSource dateNanosComparatorSource(Object missingValue, MultiValueMode sortMode, Nested nested) {
        @Override
        }
     */
        }
     * A small helper class that can be configured to load nanosecond field data either in nanosecond resolution retaining the original
    }
                    return values.advanceExact(docId);
 */
        }
            return in.advanceExact(target);
 *
    }
            this.in = in;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
import org.opensearch.search.aggregations.support.ValuesSourceType;
        final LeafReader reader;
        public SortedNumericIndexFieldData build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
     * FieldData implementation for 32-bit float values.
        public Collection<Accountable> getChildResources() {
                @Override
import org.apache.lucene.index.NumericDocValues;
        public boolean advanceExact(int target) throws IOException {
            return Collections.emptyList();
        switch (numericType) {
    /**
        SortedNumericDoubleFieldData(LeafReader reader, String field) {
import java.math.BigInteger;
                }
        return valuesSourceType;
        }
    }
     * {@link FieldData#unwrapSingleton(SortedNumericDoubleValues)} will return
                }
            this.field = field;
                    return FieldData.singleton(new SingleFloatValues(single));
/*
        }
        }
        final NumericDocValues in;
import org.opensearch.index.fielddata.LeafNumericFieldData;
            }
    protected XFieldComparatorSource dateComparatorSource(Object missingValue, MultiValueMode sortMode, Nested nested) {
        public SortedNumericDoubleValues getDoubleValues() {
        public final ScriptDocValues<BigInteger> getScriptValues() {
                }
    }
    static final class SortedNumericHalfFloatFieldData extends LeafDoubleFieldData {
            try {
                } else {
    static final class SingleHalfFloatValues extends NumericDoubleValues {
    public SortedNumericIndexFieldData(String fieldName, NumericType numericType) {
            default:
 */
        @Override
            this.field = field;
 */
                    return format.format(value);
public class SortedNumericIndexFieldData extends IndexNumericFieldData {
                    return values.docValueCount();
            return new DocValueFetcher.Leaf() {
 *
     * @opensearch.internal
    /**
        public boolean advanceExact(int target) throws IOException {
    protected final String fieldName;
    static final class MultiHalfFloatValues extends SortedNumericDoubleValues {
            super(0L);
            this.reader = reader;
    }
    static final class SortedNumericDoubleFieldData extends LeafDoubleFieldData {
        return fieldName;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
     */
        return new LongValuesComparatorSource(this, missingValue, sortMode, nested);
        }
        return load(context);
            );
                NumericDocValues single = DocValues.unwrapSingleton(raw);
        @Override
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    /**
 * specific language governing permissions and limitations
        }
        final String field;
    /**
     * {@link Float#compareTo(Float)}, hence the following reversible
        private final String fieldName;
            return new DocValueFetcher.Leaf() {
                if (single != null) {
    }
     * Wraps a SortedNumericDocValues and exposes multiple 16-bit floats per document.
        MultiHalfFloatValues(SortedNumericDocValues in) {
        }
            } catch (IOException e) {
        SortedNumericLongFieldData(LeafReader reader, String field, NumericType numericType) {
 * You may obtain a copy of the License at
        }
                dvs -> convertNumeric(dvs, DateUtils::toNanoSeconds)
                SortedNumericDocValues raw = DocValues.getSortedNumeric(reader, field);
            };
        @Override
        }
            this.fieldName = fieldName;
    public final class NanoSecondFieldData extends LeafLongFieldData {
                public Object nextValue() throws IOException {
        }
     */
            this.in = in;
import org.apache.lucene.index.LeafReader;
        public Collection<Accountable> getChildResources() {
    }
                }
     *
        }
            } catch (IOException e) {
        }
        @Override
            super(0L);
            this.reader = reader;
    }
     *
import org.opensearch.index.fielddata.fieldcomparator.LongValuesComparatorSource;
        @Override
            case UNSIGNED_LONG:
     * {@link FieldData#unwrapSingleton(SortedNumericDoubleValues)} will return
        @Override
        }
        public DocValueFetcher.Leaf getLeafValueFetcher(DocValueFormat format) {
    @Override
        final LeafReader reader;
            } catch (IOException e) {
     * <p>
        }
        }
            super(0L);
     * @opensearch.internal
        @Override
            return new LongValuesComparatorSource(
import org.opensearch.index.fielddata.ScriptDocValues;
        public SortedNumericDoubleValues getDoubleValues() {
                SortedNumericDocValues raw = DocValues.getSortedNumeric(reader, field);
 * this work for additional information regarding copyright
}
 * SPDX-License-Identifier: Apache-2.0
                SortedNumericDocValues raw = DocValues.getSortedNumeric(reader, field);
    public LeafNumericFieldData loadDirect(LeafReaderContext context) throws Exception {
    }
     * Order of values within a document is consistent with
                    return FieldData.singleton(new SingleHalfFloatValues(single));
     */
    public NumericType getNumericType() {
     * Order of values within a document is consistent with
        public boolean advanceExact(int doc) throws IOException {
            this.reader = reader;
        this.numericType = Objects.requireNonNull(numericType);
                missingValue,
        }
                return FieldData.unsignedLongToDoubles(raw);
 */
            case DOUBLE:
            } catch (IOException e) {
                    return values.docValueCount();
    /**
                @Override
                return new NanoSecondFieldData(reader, field, numericType);
 * The OpenSearch Contributors require contributions made to
     * {@code bits ^ (bits >> 15) & 0x7fff}
     * transformation is applied at both index and search:
        }
            case FLOAT:
            return in.advanceExact(doc);
    @Override
                }
            }
                return new SortedNumericFloatFieldData(reader, field);
        @Override
        public double doubleValue() throws IOException {
        public double doubleValue() throws IOException {
            this.in = in;
    static final class SortedNumericFloatFieldData extends LeafDoubleFieldData {
        public double nextValue() throws IOException {
     * the underlying single-valued NumericDoubleValues representation.
            );
            return in.advance(target);
        public Collection<Accountable> getChildResources() {
     * Builder for sorted numeric index field data
import org.opensearch.index.mapper.DocValueFetcher;
        }
    /**
        }
     * FieldData implementation for 64-bit double values.
    @Override
 * KIND, either express or implied.  See the License for the
        this.fieldName = fieldName;
/*
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
            return HalfFloatPoint.sortableShortToHalfFloat((short) in.longValue());
        public boolean advanceExact(int doc) throws IOException {
        @Override
    /**
            this.in = in;
    static final class SingleFloatValues extends NumericDoubleValues {
import org.apache.lucene.sandbox.document.HalfFloatPoint;
                this,
                    return new MultiFloatValues(raw);
     * the underlying single-valued NumericDoubleValues representation.
        }
     * the underlying single-valued NumericDoubleValues representation.
     * transformation is applied at both index and search:
     * {@link Long#compareTo(Long)}.
     * Order of values within a document is consistent with
import org.opensearch.common.time.DateUtils;
            return Collections.emptyList();
     *
            this.field = field;
                public int docValueCount() {
        final String field;
        }
            return new LongValuesComparatorSource(
            this.numericType = numericType;
     * <p>
                }
        }
            } catch (IOException e) {
 * license agreements. See the NOTICE file distributed with
        final String field;
     * @opensearch.internal
            return new SortedNumericIndexFieldData(name, numericType);
                return FieldData.sortableLongBitsToDoubles(raw);
                return new SortedNumericUnsignedLongFieldData(reader, field);
        @Override
        public int advance(int target) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private final LeafReader reader;
        public SortedNumericDoubleValues getDoubleValues() {
        }
        }
     * Order of values within a document is consistent with
     * Wraps a NumericDocValues and exposes a single 32-bit float per document.
            this.name = name;
        private final String name;
    public ValuesSourceType getValuesSourceType() {
 * software distributed under the License is distributed on an
        @Override
            SortedNumericDocValues values = getLongValues();
     * the underlying single-valued NumericDocValues representation.
        final String field;
            }
        @Override
                    return new MultiHalfFloatValues(raw);
        }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
     * for the case where documents have at most one value. In this case
            try {
import org.apache.lucene.index.DocValuesType;
    static final class MultiFloatValues extends SortedNumericDoubleValues {
    @Override
        }
     * @opensearch.internal
        @Override
            };
