            bucketSize,
package org.opensearch.index.fielddata;
    public final SortField sortField(
import org.opensearch.index.fielddata.fieldcomparator.DoubleValuesComparatorSource;
     */
         * 4. We have to cast the results to another type.
     * casting the values if their native type doesn't match.
}
                source = new HalfFloatValuesComparatorSource(this, missingValue, sortMode, nested);
                source = new UnsignedLongValuesComparatorSource(this, missingValue, sortMode, nested);
        private final ValuesSourceType valuesSourceType;
            }
    private XFieldComparatorSource comparatorSource(
                source = new LongValuesComparatorSource(this, missingValue, sortMode, nested);
import org.apache.lucene.search.SortedNumericSortField;
        LONG(false, SortField.Type.LONG, CoreValuesSourceType.NUMERIC),
                ? SortedNumericSelector.Type.MAX
    public final BucketedSort newBucketedSort(
        return sortField;
public abstract class IndexNumericFieldData implements IndexFieldData<LeafNumericFieldData> {
        DocValueFormat format,
 * not use this file except in compliance with the License.
    /**
        if (sortRequiresCustomComparator()
            @Override
     * Values are casted to the provided <code>targetNumericType</code> type if it doesn't
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.MultiValueMode;
    }
import org.apache.lucene.search.SortedNumericSelector;
import java.util.function.LongUnaryOperator;
        @Nullable Object missingValue,
        SortField sortField = new SortedNumericSortField(getFieldName(), getNumericType().sortFieldType, reverse, selectorType);
            return new SortField(getFieldName(), source, reverse);
        }
import java.io.IOException;
        Nested nested,
     */
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.index.SortedNumericDocValues;
        BYTE(false, SortField.Type.INT, CoreValuesSourceType.NUMERIC),
    }
        XFieldComparatorSource source = comparatorSource(targetNumericType, missingValue, sortMode, nested);
 * Unless required by applicable law or agreed to in writing,
                source = dateNanosComparatorSource(missingValue, sortMode, nested);
            || targetNumericType != getNumericType()) {
    public final SortField sortField(Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
import org.opensearch.index.fielddata.fieldcomparator.IntValuesComparatorSource;
        SortOrder sortOrder,
        BigArrays bigArrays,
     * Returns the {@link SortField} to used for sorting.
                source = new IntValuesComparatorSource(this, missingValue, sortMode, nested);
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
 */
    /**
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
         * 2. We need to read the value from a nested field.
        int bucketSize,
    ) {
        }
 * this work for additional information regarding copyright
            @Override
 * specific language governing permissions and limitations
                return converter.applyAsLong(values.nextValue());
 *
    @Override
                return values.advanceExact(target);
    }
                break;
 *
            this.floatingPoint = floatingPoint;
        return new LongValuesComparatorSource(this, missingValue, sortMode, nested);
        Object missingValue,
 * The OpenSearch Contributors require contributions made to
        return sortField(getNumericType(), missingValue, sortMode, nested, reverse);
            case DATE:
         * 1. The underlying data source needs it.
 * GitHub history for details.
    public abstract NumericType getNumericType();
        SHORT(false, SortField.Type.INT, CoreValuesSourceType.NUMERIC),
import org.opensearch.index.fielddata.fieldcomparator.LongValuesComparatorSource;
     * The type of number.
        NumericType targetNumericType,
     * stored such that they can be sorted without decoding ({@code false}).
        }
    /**
 * under the License.
        Nested nested
                break;
        public final ValuesSourceType getValuesSourceType() {
    }
        HALF_FLOAT(true, SortField.Type.LONG, CoreValuesSourceType.NUMERIC),
        return new LongValuesComparatorSource(this, missingValue, sortMode, nested, dvs -> convertNumeric(dvs, DateUtils::toNanoSeconds));
    /**
import org.opensearch.index.fielddata.fieldcomparator.FloatValuesComparatorSource;
 */
    protected XFieldComparatorSource dateComparatorSource(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested) {
        MultiValueMode sortMode,
            case HALF_FLOAT:
 * compatible open source license.
        }
            SortField sortField = new SortedNumericSortField(getFieldName(), SortField.Type.LONG, reverse, selectorType);
                break;
        INT(false, SortField.Type.INT, CoreValuesSourceType.NUMERIC),
        MultiValueMode sortMode,
        int bucketSize,
 * You may obtain a copy of the License at
            source.disableSkipping(); // disable skipping logic for cast of sort field
        };
                assert !targetNumericType.isFloatingPoint();
import org.opensearch.search.aggregations.support.ValuesSourceType;
                return values.nextDoc();
     * @opensearch.internal
        private final boolean floatingPoint;
            default:
        DOUBLE(true, SortField.Type.DOUBLE, CoreValuesSourceType.NUMERIC),
            return sortField;
        if (getNumericType().sortFieldType == SortField.Type.INT) {
                source = new DoubleValuesComparatorSource(this, missingValue, sortMode, nested);
        /*
 * Base class for numeric field data.
            public int nextDoc() throws IOException {
                break;
        return comparatorSource(targetNumericType, missingValue, sortMode, nested).newBucketedSort(
        if (targetNumericType != getNumericType()) {
        return source;
    public enum NumericType {
        // Now from OpenSearch 2.7, the minimum number of bytes for sort field is 8 bytes, so if it comes as SortField INT,
 * KIND, either express or implied.  See the License for the
     * match the field's <code>numericType</code>.
        Nested nested,
    }
            this.valuesSourceType = valuesSourceType;
            @Override
                source = new FloatValuesComparatorSource(this, missingValue, sortMode, nested);
        NumericType targetNumericType,
    }
import org.opensearch.search.sort.BucketedSort;
            @Override
            case LONG:
        SortOrder sortOrder,
            XFieldComparatorSource source = comparatorSource(NumericType.LONG, missingValue, sortMode, nested);
    }
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.sort.SortOrder;
        }
    ) {
        // i.e all sort fields were upcasted to Long/Double with 16 bytes.
        BigArrays bigArrays,
    public final SortField wideSortField(Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
import org.opensearch.index.fielddata.fieldcomparator.HalfFloatValuesComparatorSource;
    @Override
            }
    protected static SortedNumericDocValues convertNumeric(SortedNumericDocValues values, LongUnaryOperator converter) {
     *
        Nested nested,
        @Nullable Object missingValue,
        }
/**
        sortField.setMissingValue(source.missingObject(missingValue, reverse));
    public final BucketedSort newBucketedSort(
        return newBucketedSort(getNumericType(), bigArrays, missingValue, sortMode, nested, sortOrder, format, bucketSize, extra);
                break;
     * Convert the values in <code>dvs</code> using the provided <code>converter</code>.
        MultiValueMode sortMode,
                return values.docValueCount();
            return floatingPoint;
            case FLOAT:
        private final SortField.Type sortFieldType;
    }
 */
            format,
        // This is to support backward compatibility, the minimum number of bytes prior to OpenSearch 2.7 were 16 bytes,
import org.apache.lucene.search.SortField;
/*
         */
    ) {
        switch (targetNumericType) {
     * Build a {@link XFieldComparatorSource} matching the parameters.
 * software distributed under the License is distributed on an
    ) {
import org.opensearch.common.util.BigArrays;
            case DOUBLE:
            || (sortMode != MultiValueMode.MAX && sortMode != MultiValueMode.MIN)
        final XFieldComparatorSource source;
        // If already more than INT, up cast not needed.
     * The numeric type of this number.
import org.opensearch.search.DocValueFormat;
            || nested != null
 * Modifications Copyright OpenSearch Contributors. See
     * Does {@link #sortField} require a custom comparator because of the way
    @Override
 *
            sortField.setMissingValue(source.missingObject(missingValue, reverse));
        FLOAT(true, SortField.Type.FLOAT, CoreValuesSourceType.NUMERIC),
     */
     */
            ? SortedNumericSelector.Type.MAX
                break;
     * the data is stored in doc values ({@code true}) or are the docs values
        DocValueFormat format,
    /**
     */
        NumericType(boolean floatingPoint, SortField.Type sortFieldType, ValuesSourceType valuesSourceType) {
        DATE(false, SortField.Type.LONG, CoreValuesSourceType.DATE),
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
            SortedNumericSelector.Type selectorType = sortMode == MultiValueMode.MAX
        MultiValueMode sortMode,
        // we need to up cast it to LONG to support backward compatibility info stored in segment info
        BOOLEAN(false, SortField.Type.INT, CoreValuesSourceType.BOOLEAN),
        }
 *
        NumericType targetNumericType,
        boolean reverse
/*
    protected XFieldComparatorSource dateNanosComparatorSource(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested) {
    protected abstract boolean sortRequiresCustomComparator();
                break;
 */
            return valuesSourceType;
         * 3. We Aren't using max or min to resolve the duplicates.
import org.opensearch.common.Nullable;
            public int docValueCount() {
            case DATE_NANOSECONDS:
     */
/*
    }
            : SortedNumericSelector.Type.MIN;
    /**
                : SortedNumericSelector.Type.MIN;
            }
        DATE_NANOSECONDS(false, SortField.Type.LONG, CoreValuesSourceType.DATE),
            extra
        BucketedSort.ExtraData extra
            public long nextValue() throws IOException {
            sortOrder,
 * SPDX-License-Identifier: Apache-2.0
                source = dateComparatorSource(missingValue, sortMode, nested);
            public boolean advanceExact(int target) throws IOException {
    /**
        SortedNumericSelector.Type selectorType = sortMode == MultiValueMode.MAX
import org.opensearch.index.fielddata.fieldcomparator.UnsignedLongValuesComparatorSource;
 * the Apache License, Version 2.0 (the "License"); you may
     */
            }
        return new AbstractSortedNumericDocValues() {
        return sortField(getNumericType(), missingValue, sortMode, nested, reverse);
            this.sortFieldType = sortFieldType;
            case UNSIGNED_LONG:
        @Nullable Object missingValue,
        UNSIGNED_LONG(false, SortField.Type.LONG, CoreValuesSourceType.NUMERIC);
import org.opensearch.common.time.DateUtils;
     * Builds a {@linkplain BucketedSort} for the {@code targetNumericType},
        );
        public final boolean isFloatingPoint() {
            bigArrays,
         * Use a SortField with the custom comparator logic if required because
        BucketedSort.ExtraData extra
 * this file be licensed under the Apache-2.0 license or a
