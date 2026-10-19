        private final boolean floatingPoint;
        switch (targetNumericType) {
            || targetNumericType != getNumericType()) {
            case DOUBLE:  
 *  
    @Override
     * The type of number.
        NumericType targetNumericType,
            this.valuesSourceType = valuesSourceType;
        DOUBLE(true, SortField.Type.DOUBLE, CoreValuesSourceType.NUMERIC),
     */
        BYTE(false, SortField.Type.INT, CoreValuesSourceType.NUMERIC),
            @Override
        BucketedSort.ExtraData extra  
    public final SortField sortField(Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {  
        int bucketSize,
        // Now from OpenSearch 2.7, the minimum number of bytes for sort field is 8 bytes, so if it comes as SortField INT,
 * license agreements. See the NOTICE file distributed with
    /**  
     */
                break;
        return new AbstractSortedNumericDocValues() {
            public long nextValue() throws IOException {  
                break;
    }
            sortOrder,
        DocValueFormat format,  
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal
        // i.e all sort fields were upcasted to Long/Double with 16 bytes.
        SHORT(false, SortField.Type.INT, CoreValuesSourceType.NUMERIC),  
        return new LongValuesComparatorSource(this, missingValue, sortMode, nested, dvs -> convertNumeric(dvs, DateUtils::toNanoSeconds));  
    }
     * Does {@link #sortField} require a custom comparator because of the way
            bigArrays,  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.sort.BucketedSort;
        MultiValueMode sortMode,
     * the data is stored in doc values ({@code true}) or are the docs values  
            case DATE_NANOSECONDS:  
         * 4. We have to cast the results to another type.
            XFieldComparatorSource source = comparatorSource(NumericType.LONG, missingValue, sortMode, nested);
 * the Apache License, Version 2.0 (the "License"); you may
                source = new LongValuesComparatorSource(this, missingValue, sortMode, nested);
package org.opensearch.index.fielddata;
        }  
        );
            SortField sortField = new SortedNumericSortField(getFieldName(), SortField.Type.LONG, reverse, selectorType);  
    }
        MultiValueMode sortMode,
    ) {  
import java.io.IOException;
    @Override
import org.opensearch.common.Nullable;
 * software distributed under the License is distributed on an
            }
            return sortField;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ) {  
 * GitHub history for details.
     * stored such that they can be sorted without decoding ({@code false}).
import org.apache.lucene.search.SortField;
        NumericType targetNumericType,
 */
            case HALF_FLOAT:  
     */  
        final XFieldComparatorSource source;
import org.opensearch.index.fielddata.fieldcomparator.FloatValuesComparatorSource;
    }  
            extra
                return values.nextDoc();
        INT(false, SortField.Type.INT, CoreValuesSourceType.NUMERIC),
            case FLOAT:  
                break;
            SortedNumericSelector.Type selectorType = sortMode == MultiValueMode.MAX  
                source = dateNanosComparatorSource(missingValue, sortMode, nested);
    }  
    /**
    /**
    /**
        NumericType(boolean floatingPoint, SortField.Type sortFieldType, ValuesSourceType valuesSourceType) {
 * Base class for numeric field data.
        public final ValuesSourceType getValuesSourceType() {  
        return comparatorSource(targetNumericType, missingValue, sortMode, nested).newBucketedSort(
     * The numeric type of this number.  
/*  
/**
    @Override
     */
            }
        // This is to support backward compatibility, the minimum number of bytes prior to OpenSearch 2.7 were 16 bytes,  
        }  
            return floatingPoint;  
                return converter.applyAsLong(values.nextValue());
    protected XFieldComparatorSource dateNanosComparatorSource(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested) {
        if (getNumericType().sortFieldType == SortField.Type.INT) {
                source = new HalfFloatValuesComparatorSource(this, missingValue, sortMode, nested);
            this.sortFieldType = sortFieldType;
        SortOrder sortOrder,
            @Override  
        MultiValueMode sortMode,  
                source = new DoubleValuesComparatorSource(this, missingValue, sortMode, nested);
        SortedNumericSelector.Type selectorType = sortMode == MultiValueMode.MAX
 * Modifications Copyright OpenSearch Contributors. See
            ? SortedNumericSelector.Type.MAX  
        Nested nested,
        }  
import org.opensearch.search.sort.SortOrder;
    public final BucketedSort newBucketedSort(  
import org.opensearch.index.fielddata.fieldcomparator.IntValuesComparatorSource;  
 * this work for additional information regarding copyright
     * Convert the values in <code>dvs</code> using the provided <code>converter</code>.
            source.disableSkipping(); // disable skipping logic for cast of sort field
    /**
    }
        Nested nested,
            public boolean advanceExact(int target) throws IOException {
        Nested nested,
     * Returns the {@link SortField} to used for sorting.
                source = new IntValuesComparatorSource(this, missingValue, sortMode, nested);
            public int nextDoc() throws IOException {
        // If already more than INT, up cast not needed.
        DATE_NANOSECONDS(false, SortField.Type.LONG, CoreValuesSourceType.DATE),
    ) {  
import org.opensearch.search.aggregations.support.ValuesSourceType;  
            public int docValueCount() {
        return new LongValuesComparatorSource(this, missingValue, sortMode, nested);
        XFieldComparatorSource source = comparatorSource(targetNumericType, missingValue, sortMode, nested);
import org.opensearch.index.fielddata.fieldcomparator.UnsignedLongValuesComparatorSource;
        return source;
                source = dateComparatorSource(missingValue, sortMode, nested);
 *
         * Use a SortField with the custom comparator logic if required because
/*
        @Nullable Object missingValue,  
 * specific language governing permissions and limitations
            }  
 *
         * 3. We Aren't using max or min to resolve the duplicates.
        sortField.setMissingValue(source.missingObject(missingValue, reverse));  
        if (targetNumericType != getNumericType()) {
    }
        }
    public abstract NumericType getNumericType();
    public final SortField sortField(  
     * Values are casted to the provided <code>targetNumericType</code> type if it doesn't  
            return valuesSourceType;
    private XFieldComparatorSource comparatorSource(
                assert !targetNumericType.isFloatingPoint();
        }  
        BigArrays bigArrays,
 * KIND, either express or implied.  See the License for the
    /**
/*  
import org.opensearch.index.fielddata.fieldcomparator.HalfFloatValuesComparatorSource;
                ? SortedNumericSelector.Type.MAX
        return sortField;
                break;
        private final ValuesSourceType valuesSourceType;
                break;
     * casting the values if their native type doesn't match.
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
    public enum NumericType {  
        return sortField(getNumericType(), missingValue, sortMode, nested, reverse);
            || nested != null
         */  
 * @opensearch.internal
    }
                source = new UnsignedLongValuesComparatorSource(this, missingValue, sortMode, nested);
     */
 * Unless required by applicable law or agreed to in writing,
            return new SortField(getFieldName(), source, reverse);
            : SortedNumericSelector.Type.MIN;
 * You may obtain a copy of the License at  
        NumericType targetNumericType,
        };
import org.apache.lucene.search.SortedNumericSelector;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override  
        }  
        FLOAT(true, SortField.Type.FLOAT, CoreValuesSourceType.NUMERIC),  
        int bucketSize,
     */
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        DocValueFormat format,
        SortField sortField = new SortedNumericSortField(getFieldName(), getNumericType().sortFieldType, reverse, selectorType);
     */
 * ownership. Elasticsearch licenses this file to you under  
        BOOLEAN(false, SortField.Type.INT, CoreValuesSourceType.BOOLEAN),
    }  
            || (sortMode != MultiValueMode.MAX && sortMode != MultiValueMode.MIN)  
         * 2. We need to read the value from a nested field.  
import org.opensearch.common.util.BigArrays;
            default:  
         * 1. The underlying data source needs it.
        BucketedSort.ExtraData extra
        boolean reverse
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
}  
        DATE(false, SortField.Type.LONG, CoreValuesSourceType.DATE),  
        }
                return values.advanceExact(target);
        MultiValueMode sortMode,  
            sortField.setMissingValue(source.missingObject(missingValue, reverse));
    ) {
    public final BucketedSort newBucketedSort(  
import org.opensearch.common.time.DateUtils;  
import org.opensearch.index.fielddata.fieldcomparator.LongValuesComparatorSource;
        // we need to up cast it to LONG to support backward compatibility info stored in segment info  
            format,
 * compatible open source license.
import org.opensearch.search.MultiValueMode;
    protected static SortedNumericDocValues convertNumeric(SortedNumericDocValues values, LongUnaryOperator converter) {  
    protected abstract boolean sortRequiresCustomComparator();  
public abstract class IndexNumericFieldData implements IndexFieldData<LeafNumericFieldData> {  
        return sortField(getNumericType(), missingValue, sortMode, nested, reverse);
    /**
 */  
        SortOrder sortOrder,  
                break;
                source = new FloatValuesComparatorSource(this, missingValue, sortMode, nested);
                : SortedNumericSelector.Type.MIN;
        BigArrays bigArrays,
            bucketSize,  
 * not use this file except in compliance with the License.
 */
        private final SortField.Type sortFieldType;  
import org.opensearch.search.DocValueFormat;  
import org.apache.lucene.index.SortedNumericDocValues;
     * Builds a {@linkplain BucketedSort} for the {@code targetNumericType},  
        UNSIGNED_LONG(false, SortField.Type.LONG, CoreValuesSourceType.NUMERIC);
            @Override
        LONG(false, SortField.Type.LONG, CoreValuesSourceType.NUMERIC),
        return newBucketedSort(getNumericType(), bigArrays, missingValue, sortMode, nested, sortOrder, format, bucketSize, extra);
                break;
     * Build a {@link XFieldComparatorSource} matching the parameters.
 *  
            case DATE:  
                return values.docValueCount();  
import org.opensearch.index.fielddata.fieldcomparator.DoubleValuesComparatorSource;  
        @Nullable Object missingValue,
        Nested nested
        /*  
        Object missingValue,
            }  
    }  
 * under the License.  
        HALF_FLOAT(true, SortField.Type.LONG, CoreValuesSourceType.NUMERIC),
     *  
     * match the field's <code>numericType</code>.
import java.util.function.LongUnaryOperator;
        if (sortRequiresCustomComparator()
            this.floatingPoint = floatingPoint;  
            case LONG:  
    public final SortField wideSortField(Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
    protected XFieldComparatorSource dateComparatorSource(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested) {
            case UNSIGNED_LONG:  
 */  
        public final boolean isFloatingPoint() {
import org.apache.lucene.search.SortedNumericSortField;
        @Nullable Object missingValue,  
