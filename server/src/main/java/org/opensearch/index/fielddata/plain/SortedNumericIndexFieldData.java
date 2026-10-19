import org.apache.lucene.util.Accountable;
    /**
        }
            return in.advanceExact(doc);
 * You may obtain a copy of the License at  
            case DATE_NANOSECONDS:
                SortedNumericDocValues raw = DocValues.getSortedNumeric(reader, field);
        @Override  
     * for the case where documents have at most one value. In this case
     */  
            this.name = name;
import org.apache.lucene.index.DocValues;
import java.util.Collection;
    static final class SortedNumericDoubleFieldData extends LeafDoubleFieldData {
                throw new IllegalStateException("Cannot load doc values", e);
                }  
            return NumericUtils.sortableIntToFloat((int) in.longValue());
import org.opensearch.index.fielddata.LeafNumericFieldData;  
     * for the case where documents have at most one value. In this case
            } catch (IOException e) {
            // converts date values to nanosecond resolution
        return new LongValuesComparatorSource(this, missingValue, sortMode, nested);
        return valuesSourceType;
                return DocValues.getSortedNumeric(reader, fieldName);  
/*
                this,  
        final SortedNumericDocValues in;
            return HalfFloatPoint.sortableShortToHalfFloat((short) in.longValue());
            this.fieldName = fieldName;
    }
    /**  
import java.util.Objects;  
import org.apache.lucene.sandbox.document.HalfFloatPoint;
     * Order of values within a document is consistent with
    }  
        }
import org.opensearch.search.MultiValueMode;
        final String field;
     * values or in millisecond resolution converting the nanosecond values to milliseconds
            super(0L);  
        }  
                } else {
        public int advance(int target) throws IOException {
 * @opensearch.internal  
            }  
        public int advance(int target) throws IOException {
            DocValueFormat nanosFormat = DocValueFormat.withNanosecondResolution(format);
 * ownership. Elasticsearch licenses this file to you under  
            super(0L, numericType);
            return new SortedNumericIndexFieldData(name, numericType);
 *
                return new SortedNumericUnsignedLongFieldData(reader, field);
     * Wraps a SortedNumericDocValues and exposes multiple 32-bit floats per document.
 * The OpenSearch Contributors require contributions made to  
        @Override
        public Collection<Accountable> getChildResources() {
            this.in = in;  
     * Builder for sorted numeric index field data
            return Collections.emptyList();  
                public boolean advanceExact(int docId) throws IOException {
        SortedNumericHalfFloatFieldData(LeafReader reader, String field) {
     * {@link FieldData#unwrapSingleton(SortedNumericDoubleValues)} will return
        }  
     * Wraps a NumericDocValues and exposes a single 32-bit float per document.
        @Override  
        @Override
        final String field;
            return in.advance(target);  
    public SortedNumericIndexFieldData(String fieldName, NumericType numericType) {
        SingleHalfFloatValues(NumericDocValues in) {
                }  
     * @opensearch.internal
import org.apache.lucene.index.LeafReader;  
        @Override
import org.opensearch.search.DocValueFormat;
                missingValue,
        public Collection<Accountable> getChildResources() {
                throw new IllegalStateException("Cannot load doc values", e);
 * @see DocValuesType#SORTED_NUMERIC
import java.util.Collections;
        @Override
     * transformation is applied at both index and search:  
            return in.advance(target);  
     * {@link Long#compareTo(Long)}.  
        SortedNumericDoubleFieldData(LeafReader reader, String field) {
            return HalfFloatPoint.sortableShortToHalfFloat((short) in.nextValue());
            return in.advanceExact(target);  
            this.reader = reader;
                public Object nextValue() throws IOException {
     * {@link FieldData#unwrapSingleton(SortedNumericDoubleValues)} will return
        @Override
     * <p>
     * @opensearch.internal
            SortedNumericDocValues values = getLongValues();
    }
            case DOUBLE:  
     * {@link FieldData#unwrapSingleton(SortedNumericDoubleValues)} will return
/**
        @Override  
                    return FieldData.singleton(new SingleFloatValues(single));  
import org.opensearch.index.fielddata.fieldcomparator.LongValuesComparatorSource;
        this.numericType = Objects.requireNonNull(numericType);  
            try {
        public SortedNumericDoubleValues getDoubleValues() {  
     *
            case FLOAT:
                SortedNumericDocValues raw = DocValues.getSortedNumeric(reader, field);
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
import org.apache.lucene.index.NumericDocValues;
 * FieldData backed by {@link LeafReader#getSortedNumericDocValues(String)}  
            try {
        @Override
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
        }  
        SingleFloatValues(NumericDocValues in) {
            return new DocValueFetcher.Leaf() {
        public boolean advanceExact(int doc) throws IOException {  
     * {@code bits ^ (bits >> 31) & 0x7fffffff}
        @Override  
        }
            this.in = in;
            case HALF_FLOAT:
                this,  
                sortMode,
    /**
        @Override
            return 0L;  
                public int docValueCount() throws IOException {
        public Builder(String name, NumericType numericType) {
        }  
        @Override
     * FieldData implementation for 16-bit float values.
                throw new IllegalStateException("Cannot load doc values", e);  
     * @opensearch.internal  
        public double doubleValue() throws IOException {
 *  
}  
            }
        final String field;  
        }  
                @Override
        public Collection<Accountable> getChildResources() {
     * <p>
        }
                    return nanosFormat.format(values.nextValue());
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
            this.in = in;  
    public final String getFieldName() {
            this.field = field;
                throw new IllegalStateException("Cannot load doc values", e);
        this.fieldName = fieldName;
            return NumericUtils.sortableIntToFloat((int) in.nextValue());
            };
     * FieldData implementation for integral types.  
        public SortedNumericIndexFieldData build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
/*  
                @Override
    /**  
        MultiHalfFloatValues(SortedNumericDocValues in) {  
     * {@link Double#compareTo(Double)}, hence the following reversible
 * software distributed under the License is distributed on an
     */
        }
        public final ScriptDocValues<BigInteger> getScriptValues() {  
     * for the case where documents have at most one value. In this case
                @Override
        }  
     * @opensearch.internal
    /**
            return new LongValuesComparatorSource(
        public Collection<Accountable> getChildResources() {
        return fieldName;  
        }  
        SortedNumericFloatFieldData(LeafReader reader, String field) {
                return new SortedNumericLongFieldData(reader, field, numericType);
        return load(context);
    }
        final LeafReader reader = context.reader();
     *
 * Licensed to Elasticsearch under one or more contributor  
     * Order of values within a document is consistent with
     * Wraps a NumericDocValues and exposes a single 16-bit float per document.
        public final SortedBinaryDocValues getBytesValues() {
            this.field = field;
     * @opensearch.internal
        }
        public int docValueCount() {  
     *
     */  
            super(0L, numericType);  
        public boolean advanceExact(int target) throws IOException {
        @Override
        NanoSecondFieldData(LeafReader reader, String fieldName, NumericType numericType) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                NumericDocValues single = DocValues.unwrapSingleton(raw);
    @Override
                return DocValues.getSortedNumeric(reader, field);
        }
import org.opensearch.index.fielddata.FieldData;
     * @opensearch.internal  
        @Override
 * KIND, either express or implied.  See the License for the
     * Although the API is multi-valued, most codecs in Lucene specialize  
 * SPDX-License-Identifier: Apache-2.0
            this.reader = reader;
        public double nextValue() throws IOException {
        final String field;  
            case UNSIGNED_LONG:
        @Override
        final LeafReader reader;
        }  
    public LeafNumericFieldData loadDirect(LeafReaderContext context) throws Exception {
                throw new IllegalStateException("Cannot load doc values", e);
                    return new MultiHalfFloatValues(raw);
        }
        }  
        public Collection<Accountable> getChildResources() {
            this.in = in;
        public SortedNumericDocValues getLongValues() {  
    }  
        SortedNumericUnsignedLongFieldData(LeafReader reader, String field) {  
     * the underlying single-valued NumericDoubleValues representation.  
     */
        public SortedNumericDoubleValues getDoubleValues() {  
                }
    }
        return numericType;  
            return new ScriptDocValues.UnsignedLongs(getLongValues());
        @Override
     * FieldData implementation for 64-bit double values.
    public final class NanoSecondFieldData extends LeafLongFieldData {  
        }
        final SortedNumericDocValues in;
     */
import org.opensearch.index.fielddata.IndexFieldDataCache;
        if (numericType == NumericType.DATE_NANOSECONDS) {  
        public boolean advanceExact(int target) throws IOException {
                }  
        }
 * this work for additional information regarding copyright
        }
        @Override
    }
 */  
import org.apache.lucene.util.NumericUtils;  
        @Override
import java.math.BigInteger;  
                return new NanoSecondFieldData(reader, field, numericType);  
 */  
import java.io.IOException;
    @Override
            this.reader = reader;
        public double nextValue() throws IOException {
    @Override  
        if (numericType == NumericType.DATE) {  
                dvs -> convertNumeric(dvs, DateUtils::toMilliSeconds)
                if (single != null) {
    static final class SortedNumericUnsignedLongFieldData implements LeafNumericFieldData {
        public int advance(int target) throws IOException {
     * Order of values within a document is consistent with
        }  
                return new SortedNumericHalfFloatFieldData(reader, field);  
        @Override  
        MultiFloatValues(SortedNumericDocValues in) {  
            }  
            }  
                    return values.advanceExact(docId);  
        }  
        final LeafReader reader;
    }
        }  
        }
    @Override
        }
    static final class SingleFloatValues extends NumericDoubleValues {
        }
 * specific language governing permissions and limitations
     * transformation is applied at both index and search:  
                return DocValues.getSortedNumeric(reader, field);
        }
     *  
            return Collections.emptyList();
     */
        private final NumericType numericType;
     * {@link DocValues#unwrapSingleton(SortedNumericDocValues)} will return
                    return values.advanceExact(docId);
 * not use this file except in compliance with the License.
/*  
     */  
     * Wraps a NumericDocValues and exposes a single 64-bit double per document.
     * @opensearch.internal
        }
                if (single != null) {
        @Override
        @Override
        }
        }
            }
    }
        }  
     * transformation is applied at both index and search:  
    protected final String fieldName;
                sortMode,
                @Override
 */
        this.valuesSourceType = numericType.getValuesSourceType();
            } catch (IOException e) {
import org.apache.lucene.index.DocValuesType;
     * A small helper class that can be configured to load nanosecond field data either in nanosecond resolution retaining the original  
     *  
    }  
                return new SortedNumericDoubleFieldData(reader, field);
                    return new MultiFloatValues(raw);
                public boolean advanceExact(int docId) throws IOException {  
    }
                return FieldData.sortableLongBitsToDoubles(raw);  
        public int advance(int target) throws IOException {
                @Override  
            return Collections.emptyList();
        final LeafReader reader;  
            };
        }
import org.opensearch.search.aggregations.support.ValuesSourceType;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.mapper.DocValueFetcher;  
 * this file be licensed under the Apache-2.0 license or a
            this.field = field;
        @Override  
    @Override
 */
            return Collections.emptyList();
            try {
        public int docValueCount() {  
     * <p>
        @Override
    }
            this.numericType = numericType;  
            this.field = field;
        public DocValueFetcher.Leaf getLeafValueFetcher(DocValueFormat format) {
        public DocValueFetcher.Leaf getLeafValueFetcher(DocValueFormat format) {
    static final class SortedNumericLongFieldData extends LeafLongFieldData {  
            this.reader = reader;  
        public double doubleValue() throws IOException {
        public boolean advanceExact(int doc) throws IOException {  
            } catch (IOException e) {
        }  
     * <p>  
            } catch (IOException e) {
public class SortedNumericIndexFieldData extends IndexNumericFieldData {
                nested,  
        return numericType == NumericType.HALF_FLOAT || numericType == NumericType.UNSIGNED_LONG;
    /**
import org.opensearch.common.time.DateUtils;
        return new LongValuesComparatorSource(this, missingValue, sortMode, nested);
            return in.advance(target);  
        public SortedNumericDoubleValues getDoubleValues() {  
            );
    protected XFieldComparatorSource dateNanosComparatorSource(Object missingValue, MultiValueMode sortMode, Nested nested) {
     */
        @Override  
            return in.advanceExact(target);  
                public int docValueCount() {
            this.reader = reader;
    public NumericType getNumericType() {
     * the underlying single-valued NumericDoubleValues representation.  
        }
import org.opensearch.index.fielddata.IndexFieldData;
        @Override
        final NumericDocValues in;  
        private final LeafReader reader;
        }  
     * the underlying single-valued NumericDoubleValues representation.  
     * for the case where documents have at most one value. In this case  
            }  
     * @opensearch.internal
        }
            default:  
        @Override
        SortedNumericLongFieldData(LeafReader reader, String field, NumericType numericType) {
        }
            }  
     * <p>  
                }
    public ValuesSourceType getValuesSourceType() {
     * @opensearch.internal
                return FieldData.unsignedLongToDoubles(raw);  
 * Unless required by applicable law or agreed to in writing,
        final String field = fieldName;
                SortedNumericDocValues raw = DocValues.getSortedNumeric(reader, field);
        @Override
import org.apache.lucene.index.SortedNumericDocValues;  
 * compatible open source license.
    protected XFieldComparatorSource dateComparatorSource(Object missingValue, MultiValueMode sortMode, Nested nested) {
        @Override
     * {@code bits ^ (bits >> 63) & 0x7fffffffffffffffL}
                    final BigInteger value = Numbers.toUnsignedBigInteger(values.nextValue());
 * the Apache License, Version 2.0 (the "License"); you may
            super(0L);  
        }
                NumericDocValues single = DocValues.unwrapSingleton(raw);
        }
            return new LongValuesComparatorSource(
        }
            try {  
            return in.docValueCount();
import org.opensearch.index.fielddata.ScriptDocValues;
        public long ramBytesUsed() {
    static final class SortedNumericFloatFieldData extends LeafDoubleFieldData {
                throw new IllegalStateException("Cannot load doc values", e);
        }
        final LeafReader reader;
 * under the License.  
     * <p>  
            return in.advance(target);  
    @Override
                    return values.docValueCount();  
        @Override  
     * Although the API is multi-valued, most codecs in Lucene specialize  
            this.field = field;
            super(0L);  
     */
    static final class MultiFloatValues extends SortedNumericDoubleValues {  
                @Override  
        public SortedNumericDocValues getLongValues() {  
            try {
            return in.docValueCount();
                dvs -> convertNumeric(dvs, DateUtils::toNanoSeconds)
 * GitHub history for details.
                missingValue,
        public void close() {}
        }  
     */
 *
            return in.advanceExact(doc);
    }
     *  
            this.reader = reader;
     * {@code bits ^ (bits >> 15) & 0x7fff}
    /**
import org.opensearch.index.fielddata.NumericDoubleValues;
     * @opensearch.internal  
            SortedNumericDocValues values = getLongValuesAsNanos();  
    /**
                nested,  
    }
        @Override  
        @Override  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
    @Override  
        }  
            return Collections.emptyList();
            );
    /**
     * {@link Float#compareTo(Float)}, hence the following reversible
    protected final ValuesSourceType valuesSourceType;
     *
    protected boolean sortRequiresCustomComparator() {  
                }  
 * Modifications Copyright OpenSearch Contributors. See
     * FieldData implementation for 32-bit float values.
            } catch (IOException e) {
        switch (numericType) {
     *
     *
    }
     * Wraps a SortedNumericDocValues and exposes multiple 16-bit floats per document.
        }
    @Override
     * <p>
    public static class Builder implements IndexFieldData.Builder {  
                    return values.docValueCount();
            try {
        public SortedNumericDocValues getLongValuesAsNanos() {
    public LeafNumericFieldData load(LeafReaderContext context) {  
        @Override  
     * {@link Float#compareTo(Float)}, hence the following reversible
            return new DocValueFetcher.Leaf() {  
        private final String name;
     * the underlying single-valued NumericDocValues representation.
     * Although the API is multi-valued, most codecs in Lucene specialize  
    }
     */
        final LeafReader reader;
            } catch (IOException e) {  
import org.apache.lucene.index.LeafReaderContext;
        final NumericDocValues in;  
        }
        public SortedNumericDocValues getLongValues() {
                throw new IllegalStateException("Cannot load doc values", e);
            return convertNumeric(getLongValuesAsNanos(), DateUtils::toMilliSeconds);
        public SortedNumericDoubleValues getDoubleValues() {  
                SortedNumericDocValues raw = DocValues.getSortedNumeric(reader, field);
            // converts date_nanos values to millisecond resolution
 *
    static final class MultiHalfFloatValues extends SortedNumericDoubleValues {  
import org.opensearch.common.Numbers;
    }
                }
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return new SortedNumericFloatFieldData(reader, field);
    private final NumericType numericType;  
    }
     * Order of values within a document is consistent with
                    return FieldData.singleton(new SingleHalfFloatValues(single));  
    static final class SortedNumericHalfFloatFieldData extends LeafDoubleFieldData {
package org.opensearch.index.fielddata.plain;
        }
    /**
     *  
     * <p>
            } catch (IOException e) {
            return FieldData.toUnsignedString(getLongValues());  
        private final String fieldName;  
                public Object nextValue() throws IOException {  
                    return format.format(value);
        final String field;  
            try {
    /**  
     * Although the API is multi-valued, most codecs in Lucene specialize
import org.opensearch.index.fielddata.IndexNumericFieldData;
        }
    }  
                } else {
    static final class SingleHalfFloatValues extends NumericDoubleValues {
    }
        @Override  
