        }
    }
        }
            }
        public long ramBytesUsed() {
        public byte get(long index) {
        this.recycler = recycler;
    public static long overSize(long minTargetSize, int pageSize, int bytesPerElement) {
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {
     */
    /**
    }
        }
            return size;
    /** Resize the array to the exact provided size. */
            assert indexIsInt(toIndex);
 * ownership. Elasticsearch licenses this file to you under
            final byte ret = array[(int) index];
        try {
            return array[(int) index];
    /** @see Arrays#hashCode(byte[]) */
        public T get(long index) {
            this.array = array;
            final Recycler.V<long[]> page = recycler.longPage(clearOnResize);
            adjustBreaker(BigIntArray.estimateRamBytes(size), false);
import org.opensearch.common.annotation.PublicApi;
            adjustBreaker(array.ramBytesUsed(), true);
            System.arraycopy(buf, offset, array, (int) index, len);
                Releasables.closeWhileHandlingException(array);
    }
    private abstract static class AbstractArrayWrapper extends AbstractArray implements BigArray {
        public long set(long index, long value) {
            // Prevent use of BinarySearcher.search() and force the use of DoubleBinarySearcher.search()
     */
        final long newSize = overSize(minSize, PageCacheRecycler.INT_PAGE_SIZE, Float.BYTES);
        @Override
    public BigArrays(PageCacheRecycler recycler, @Nullable final CircuitBreakerService breakerService, String breakerName) {
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
     */
        }
    public FloatArray newFloatArray(long size) {
import org.opensearch.common.lease.Releasable;
    public LongArray resize(LongArray array, long size) {
        @Override
        @Override
    private static class IntArrayWrapper extends AbstractArrayWrapper implements IntArray {
                    breaker.addWithoutBreaking(delta);
        public long ramBytesUsed() {
    }
    static boolean indexIsInt(long index) {
        } else {
     */
     */
            this.array = array;
        @Override
            assert indexIsInt(index);
 * */
        if (bytesPerElement <= 0) {
            this.searchFor = Integer.MIN_VALUE;
 * this work for additional information regarding copyright
        }
        LongArrayWrapper(BigArrays bigArrays, long[] array, long size, Recycler.V<long[]> releasable, boolean clearOnResize) {
            assert indexIsInt(toIndex);
        static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(ByteArrayWrapper.class);
            final FloatArray newArray = newFloatArray(size, arr.clearOnResize);
        public void fill(long fromIndex, long toIndex, int value) {
            throw new IllegalArgumentException("pageSize must be > 0");
        }
        boolean success = false;
            return array;
     * Allocate a new {@link ObjectArray}.
            // when allocating big arrays, we want to first ensure we have the capacity by
            return resizeInPlace((BigObjectArray<T>) array, size);
 * license agreements. See the NOTICE file distributed with
                newArray.set(i, array.get(i));
        }
        }
 *
        }
        } else {
        return newDoubleArray(size, true);
            assert indexIsInt(index);
            );
            return false;
    private final String breakerName;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
            return new BigLongArray(size, this, clearOnResize);
        }
        assert oldMemSize == array.ramBytesEstimated(oldSize)
        }
        ObjectArrayWrapper(BigArrays bigArrays, Object[] array, long size, Recycler.V<Object[]> releasable) {
        @Override
package org.opensearch.common.util;
            super(bigArrays, size, releasable, clearOnResize);
    /**
        for (long i = 0; i < array.size(); i++) {
            // checking with the circuit breaker before attempting to allocate
    public DoubleArray newDoubleArray(long size) {
            assert indexIsInt(fromIndex);
/*
            // when allocating big arrays, we want to first ensure we have the capacity by
        final long oldMemSize = array.ramBytesUsed();
        }
            return array;
        this(recycler, breakerService, breakerName, false);
            Arrays.fill(array, (int) fromIndex, (int) toIndex, Double.doubleToRawLongBits(value));
            } else {
     * @param size          the initial length of the array
    }
            final byte[] rawArray = ((ByteArrayWrapper) array).array;
            this.circuitBreakingInstance = this;
        @Override
            return newArray;
            return validate(new ByteArrayWrapper(this, new byte[(int) size], size, null, clearOnResize));
            adjustBreaker(BigByteArray.estimateRamBytes(size), false);
            super(bigArrays, size, releasable, clearOnResize);
        @Override
            arr.close();
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
        if (array == null) {
        public byte[] array() {
        }
            if (array.get(i) != other.get(i)) {
        return array;
     * @param size          the initial length of the array
        return resize(array, newSize);
            // checking with the circuit breaker before attempting to allocate
            return validate(new FloatArrayWrapper(this, page.v(), size, page, clearOnResize));
     */
        if (array.size() != other.size()) {
            final ByteArray newArray = newByteArray(size, arr.clearOnResize);
            this.array = array;
            final Recycler.V<int[]> page = recycler.intPage(clearOnResize);
            super(bigArrays, clearOnResize);
 * not use this file except in compliance with the License.
        } else {
        DoubleArray array;
        @Override
    /** Grow an array to a size that is larger than <code>minSize</code>,
            double ret = Double.longBitsToDouble(array[(int) index]);
        array.resize(newSize);
            assert indexIsInt(toIndex);
     */
            final LongArray newArray = newLongArray(size, arr.clearOnResize);
        public byte set(long index, byte value) {
    /** Allocate a new {@link DoubleArray} of the given capacity. */
            // checking with the circuit breaker before attempting to allocate
    /** Resize the array to the exact provided size. */
        protected int compare(int index) {
        }
        }
            return array;
            array[(int) index] = value;
            assert indexIsInt(fromIndex);
        @Override
        public int get(long index) {
        } else if (size >= PageCacheRecycler.LONG_PAGE_SIZE / 2 && recycler != null) {
            this.releasable = releasable;
            array[(int) index] = value;
 */
        if (minSize <= array.size()) {
        IntArrayWrapper(BigArrays bigArrays, int[] array, long size, Recycler.V<int[]> releasable, boolean clearOnResize) {
    private final CircuitBreakerService breakerService;
        }
/**
            ref.offset = (int) index;
        public double get(long index) {
    /**
            assert indexIsInt(index);
        }
            : "ram bytes used should equal that which was previously estimated: ramBytesUsed="
            assert this.searchFor != Integer.MIN_VALUE;
import org.apache.lucene.util.ArrayUtil;
            return array[(int) index] += inc;
     * @param clearOnResize whether values should be set to 0 on initialization and resize
 * under the License.
        return array;
        public void fill(long fromIndex, long toIndex, double value) {
        }
        }
        } else {
            return array;
    /**
            array[(int) index] = Double.doubleToRawLongBits(value);
        final long estimatedIncreaseInBytes = array.ramBytesEstimated(newSize) - oldMemSize;
            return new BigObjectArray<>(size, this);
public class BigArrays {
            return new BigFloatArray(size, this, clearOnResize);
        if (checkBreaker) {
                newArray.set(i, array.get(i));
     * @param size          the initial length of the array
            assert indexIsInt(toIndex);
        } else {
     *
            final ObjectArray<T> newArray = newObjectArray(size);
    public IntArray newIntArray(long size, boolean clearOnResize) {
    }
    private final boolean checkBreaker;
            return validate(new DoubleArrayWrapper(this, new long[(int) size], size, null, clearOnResize));
     */
            this.searchFor = searchFor;
            return super.search(from, to);
        private final int[] array;
     * Wraps a double array
                        breaker.addEstimateBytesAndMaybeBreak(delta, "<reused_arrays>");
                }
        if (array instanceof BigObjectArray) {
            return resizeInPlace((BigLongArray) array, size);
            return newArray;
     * Allocate a new {@link IntArray}.
    /**
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {
        }
    public <T> ObjectArray<T> resize(ObjectArray<T> array, long size) {
        final long newSize = overSize(minSize, PageCacheRecycler.LONG_PAGE_SIZE, Long.BYTES);
        } else {
            super(bigArrays, size, releasable, clearOnResize);
    /** Resize the array to the exact provided size. */
            assert indexIsInt(toIndex);
     *
            AbstractArray arr = (AbstractArray) array;
        AbstractArrayWrapper(BigArrays bigArrays, long size, Releasable releasable, boolean clearOnResize) {
        } else if (size >= PageCacheRecycler.OBJECT_PAGE_SIZE / 2 && recycler != null) {
            // when allocating big arrays, we want to first ensure we have the capacity by
        boolean checkBreaker
            assert indexIsInt(index);
     * @param clearOnResize whether values should be set to 0 on initialization and resize
 * The OpenSearch Contributors require contributions made to
     * @opensearch.internal
            @SuppressWarnings("unchecked")
        @Override
            assert indexIsInt(index);
        }
                    try {
    /**
     * preserving content, and potentially reusing part of the provided array. */
            hash = 31 * hash + array.get(i);
            T ret = (T) array[(int) index];
 * software distributed under the License is distributed on an
     * @opensearch.internal
     * @param clearOnResize whether values should be set to 0 on initialization and resize
    public IntArray newIntArray(long size) {
 * specific language governing permissions and limitations
            this.array = array;
    private static class ByteArrayWrapper extends AbstractArrayWrapper implements ByteArray {
        if (minSize <= array.size()) {
            return validate(new FloatArrayWrapper(this, new int[(int) size], size, null, clearOnResize));
     * preserving content, and potentially reusing part of the provided array. */
        public long ramBytesUsed() {
}
            array.close();
                // its' totals, so add without breaking
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
    public CircuitBreakerService breakerService() {
                // even if we are not checking the breaker, we need to adjust
    }
            return array;
        @SuppressWarnings("unchecked")
        public int increment(long index, int inc) {
    public FloatArray newFloatArray(long size, boolean clearOnResize) {
    }
            AbstractArray arr = (AbstractArray) array;
        return this.circuitBreakingInstance;
    protected BigArrays(
import org.opensearch.core.common.util.ByteArray;
        ByteArrayWrapper(BigArrays bigArrays, byte[] array, long size, Recycler.V<byte[]> releasable, boolean clearOnResize) {
                + oldMemSize
            assert indexIsInt(index);
     * Allocate a new {@link IntArray}.
    public <T> ObjectArray<T> newObjectArray(long size) {
    /** Grow an array to a size that is larger than <code>minSize</code>,
        }
                            // add it so closing the stream re-adjusts properly
            return validate(new ObjectArrayWrapper<>(this, page.v(), size, page));
     * Allocate a new {@link FloatArray}.
    public LongArray newLongArray(long size, boolean clearOnResize) {
            return new BigIntArray(size, this, clearOnResize);
    public DoubleArray resize(DoubleArray array, long size) {
     * @opensearch.internal
                            // since we've already created the data, we need to
     * preserving content, and potentially reusing part of the provided array. */
            // checking with the circuit breaker before attempting to allocate
     *  may have different page sizes or number of bytes per element. */
        @Override
        }
    /**
        return hash;
import org.opensearch.common.lease.Releasables;
    public static class DoubleBinarySearcher extends BinarySearcher {
                    }
        public boolean hasArray() {
        if (array instanceof BigLongArray) {
        private final long[] array;
                // have to if the delta is negative
            array.close();
            final IntArray newArray = newIntArray(size, arr.clearOnResize);
     * explicitly enabled, instead of only accounting enabled
    }
        }
    }
        return resize(array, newSize);
        private final Releasable releasable;
     */
    }
        } else if (size >= PageCacheRecycler.BYTE_PAGE_SIZE / 2 && recycler != null) {
            assert indexIsInt(index);
    }
            return Math.abs(array.get(index) - searchFor);
        @Override
     * Allocate a new {@link ByteArray}.
        @Override
    }
        public int set(long index, int value) {
            return array;
        @Override
                RamUsageEstimator.NUM_BYTES_ARRAY_HEADER + RamUsageEstimator.NUM_BYTES_OBJECT_REF * size()
            super(bigArrays, size, releasable, clearOnResize);
 * compatible open source license.
        @Override
        final long newSize = overSize(minSize, PageCacheRecycler.OBJECT_PAGE_SIZE, RamUsageEstimator.NUM_BYTES_OBJECT_REF);
     */
            adjustBreaker(BigObjectArray.estimateRamBytes(size), false);
            assert indexIsInt(index);
        if (array instanceof BigIntArray) {
     * @param size          the initial length of the array
     *  Inspired from {@link ArrayUtil#oversize(int, int)} and adapted to play nicely with paging. */
    /**
     * Allocate a new {@link DoubleArray}.
            final long pages = (minTargetSize + pageSize - 1) / pageSize; // ceil(minTargetSize/pageSize)
 * Licensed to Elasticsearch under one or more contributor
            float ret = Float.intBitsToFloat(array[(int) index]);
        }
    }
    /** Grow an array to a size that is larger than <code>minSize</code>,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
        if (this.breakerService != null) {
            return array[(int) index];
            assert indexIsInt(index);
        @Override
     * negative, or checkBreaker is false, the breaker will be adjusted
            assert indexIsInt(fromIndex);
            final Recycler.V<Object[]> page = recycler.objectPage();
            // when allocating big arrays, we want to first ensure we have the capacity by
            return resizeInPlace((BigIntArray) array, size);
     * Wraps an object array
 * GitHub history for details.
            // when allocating big arrays, we want to first ensure we have the capacity by
            assert indexIsInt(index);
        DoubleArrayWrapper(BigArrays bigArrays, long[] array, long size, Recycler.V<long[]> releasable, boolean clearOnResize) {
    public DoubleArray grow(DoubleArray array, long minSize) {
/*
            array[(int) index] = Float.floatToRawIntBits(value);
        @Override
        }
        return index == (int) index;
        return newLongArray(size, true);
        }
     * Adjust the circuit breaker with the given delta, if the delta is
                } else {
     */
    /**
import org.opensearch.common.recycler.Recycler;
     *
            this.array = array;
            return newArray;
            return array;
        final long newSize = overSize(minSize, PageCacheRecycler.INT_PAGE_SIZE, Integer.BYTES);
            return array[(int) index] += inc;
 *
            throw new IllegalArgumentException("bytesPerElement must be > 0");
            return validate(new LongArrayWrapper(this, page.v(), size, page, clearOnResize));
            Arrays.fill(array, (int) fromIndex, (int) toIndex, value);
            newSize = Math.min(ArrayUtil.oversize((int) minTargetSize, bytesPerElement), pageSize);
            assert indexIsInt(index);
 * You may obtain a copy of the License at
            super(bigArrays, size, releasable, true);
     * @opensearch.internal
        }
        }
        if (array instanceof BigByteArray) {
        if (pageSize < 0) {
    /** Grow an array to a size that is larger than <code>minSize</code>,
            return resizeInPlace((BigByteArray) array, size);
    /** Return the next size to grow to that is &gt;= <code>minTargetSize</code>.
    public boolean equals(ByteArray array, ByteArray other) {
     * Allocate a new {@link ByteArray} initialized with zeros.
     *
        return resize(array, newSize);
        }
    private static class FloatArrayWrapper extends AbstractArrayWrapper implements FloatArray {
            AbstractArray arr = (AbstractArray) array;
    ) {
        @Override
    }
     */
        }
        }
            assert indexIsInt(index);
            // checking with the circuit breaker before attempting to allocate
            // checking with the circuit breaker before attempting to allocate
        } else {
    }
        if (minTargetSize < 0) {
        @Override
    }
            this.size = size;
        return newByteArray(size, true);
            Releasables.close(releasable);
     * Wraps a byte array
            return ret;
            return validate(new DoubleArrayWrapper(this, page.v(), size, page, clearOnResize));
            assert indexIsInt(index);
        if (size > PageCacheRecycler.LONG_PAGE_SIZE) {
        @Override
            assert indexIsInt(index);
        }
            Arrays.fill(array, (int) fromIndex, (int) toIndex, value);
        }
        } else if (size >= PageCacheRecycler.LONG_PAGE_SIZE / 2 && recycler != null) {
     * @param size          the initial length of the array
        }
     */
        }
        String breakerName,
            assert indexIsInt(fromIndex);
            return ret;
        public double set(long index, double value) {
     * preserving content, and potentially reusing part of the provided array. */
        }
        private final byte[] array;
    }
     *
    /** Resize the array to the exact provided size. */
        @Nullable final CircuitBreakerService breakerService,
            return false;
        // Checking the breaker is disabled if not specified
    }
            return resizeInPlace((BigFloatArray) array, size);
            assert indexIsInt(index);
import org.opensearch.core.common.breaker.CircuitBreakingException;
        @Override
        }
        } else if (size >= PageCacheRecycler.INT_PAGE_SIZE / 2 && recycler != null) {
    }
            }
                newArray.set(i, array.get(i));
            newSize = pages * pageSize;
    }
        }
     * @param size          the initial length of the array
        double searchFor;
        }
        if (array instanceof BigFloatArray) {
    private static class LongArrayWrapper extends AbstractArrayWrapper implements LongArray {
            return new BigDoubleArray(size, this, clearOnResize);
        if (minTargetSize < pageSize) {
    }
        return this.circuitBreakingInstance.breakerService;
    /**
     */
            }
    public static long overSize(long minTargetSize) {
     * we do not add the delta to the breaker if it trips.
     */
            array[(int) index] = value;
        private final Object[] array;
    /** Resize the array to the exact provided size. */
            if (!success) {
            ref.bytes = array;
            return ret;
        public long get(long index) {
        final long newSize = overSize(minSize, PageCacheRecycler.BYTE_PAGE_SIZE, 1);
        if (size > PageCacheRecycler.OBJECT_PAGE_SIZE) {
        }
    /**
        }
            return validate(new ByteArrayWrapper(this, page.v(), size, page, clearOnResize));
import org.opensearch.core.common.breaker.CircuitBreaker;
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {
    /** Allocate a new {@link FloatArray} of the given capacity. */
            return newArray;
            super(bigArrays, size, releasable, clearOnResize);
     * to account for the created data.  If the data has not been created yet,
            success = true;
    }
    }
        public long ramBytesUsed() {
import java.util.Arrays;
            ref.length = len;
 */
        return resize(array, newSize);
                        throw e;
     *
     * @opensearch.internal
     * @opensearch.internal
     * Wraps a long array
        }
        long newSize;
        @Override
        } else {
            return array[(int) index];
        public void fill(long fromIndex, long toIndex, float value) {
            final Recycler.V<int[]> page = recycler.intPage(clearOnResize);
    /**
            adjustBreaker(BigDoubleArray.estimateRamBytes(size), false);
        }
        }
    }
     * @param size          the initial length of the array
            return true;
        }
        public void fill(long fromIndex, long toIndex, long value) {
     * @param size          the initial length of the array
        public float set(long index, float value) {
    void adjustBreaker(final long delta, final boolean isDataAlreadyCreated) {
        }
        @Override
    public <T> ObjectArray<T> grow(ObjectArray<T> array, long minSize) {
            final DoubleArray newArray = newDoubleArray(size, arr.clearOnResize);
            Arrays.fill(array, (int) fromIndex, (int) toIndex, value);
        public final long size() {
            return validate(new IntArrayWrapper(this, new int[(int) size], size, null, clearOnResize));
        return newIntArray(size, true);
                + ", ramBytesEstimated="
            return 0;
     * preserving content, and potentially reusing part of the provided array. */
    private final BigArrays circuitBreakingInstance;
            assert indexIsInt(index);
        private final long[] array;
                        if (isDataAlreadyCreated) {
@PublicApi(since = "1.0.0")
        }
    private <T extends AbstractBigArray> T resizeInPlace(T array, long newSize) {
                if (delta > 0) {
    private <T extends BigArray> T validate(T array) {
        if (array == other) {
                + array.ramBytesEstimated(oldSize);
    }
     * Base array wrapper class
            final long ret = array[(int) index];
 * Modifications Copyright OpenSearch Contributors. See
        } else {
import org.opensearch.common.Nullable;
            return Double.longBitsToDouble(array[(int) index]);
        public void fill(long fromIndex, long toIndex, byte value) {
        @Override
        }
            }
        @Override
                        // re-throw the original exception
            array.close();
     * @opensearch.internal
        @Override
            return validate(new LongArrayWrapper(this, new long[(int) size], size, null, clearOnResize));
    }
            return ret;
    /**
            array.close();
        @Override
        public double increment(long index, double inc) {
        if (size > PageCacheRecycler.LONG_PAGE_SIZE) {
            return validate(new IntArrayWrapper(this, page.v(), size, page, clearOnResize));
     * this method, and the breaker trips, we add the delta without breaking
    public LongArray newLongArray(long size) {
     * @param clearOnResize whether values should be set to 0 on initialization and resize
            final int ret = array[(int) index];
        if (minSize <= array.size()) {
        }
        @Override
                            breaker.addWithoutBreaking(delta);
     * @opensearch.internal
        } else {
     * Wraps an int array
            assert indexIsInt(fromIndex);
        if (minSize <= array.size()) {
        @Override
    public int hashCode(ByteArray array) {
        protected final void doClose() {
        if (array instanceof BigDoubleArray) {
        }
        }
    public DoubleArray newDoubleArray(long size, boolean clearOnResize) {
 * Unless required by applicable law or agreed to in writing,
        if (size > PageCacheRecycler.INT_PAGE_SIZE) {
    public static final BigArrays NON_RECYCLING_INSTANCE = new BigArrays(null, null, CircuitBreaker.REQUEST);
    private static class DoubleArrayWrapper extends AbstractArrayWrapper implements DoubleArray {
        adjustBreaker(estimatedIncreaseInBytes, false);
            return Float.intBitsToFloat(array[(int) index]);
                // checking breaker means potentially tripping, but it doesn't
    }
     *
        }
     * Wraps a float array
        } finally {
        return resize(array, newSize);
     * preserving content, and potentially reusing part of the provided array. */
        public void set(long index, byte[] buf, int offset, int len) {
 * @opensearch.api
        }
    public ByteArray resize(ByteArray array, long size) {
        if (size > PageCacheRecycler.BYTE_PAGE_SIZE) {
        @Override
        }
    }
     */
    /**
    public ByteArray newByteArray(long size, boolean clearOnResize) {
    /**
     */
        }
     */
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {
        }
     *
    public FloatArray resize(FloatArray array, long size) {
        } else {
        }
                breaker.addWithoutBreaking(delta);
    /** @see Arrays#equals(byte[], byte[]) */
     * Allocate a new {@link LongArray}.
     * @param clearOnResize whether values should be set to 0 on initialization and resize
        protected double distance(int index) {
            }
            return array[(int) index] = Double.doubleToRawLongBits(Double.longBitsToDouble(array[(int) index]) + inc);
        return overSize(minTargetSize, PageCacheRecycler.PAGE_SIZE_IN_BYTES / 8, 1);
    final PageCacheRecycler recycler;
     * @param size          the initial length of the array
/*
                return false;
    }
            return array[(int) index] = Float.floatToRawIntBits(Float.intBitsToFloat(array[(int) index]) + inc);
        public long ramBytesUsed() {
    /**
            adjustBreaker(BigLongArray.estimateRamBytes(size), false);
        }
        @Override
        }
    }
    /**
import org.apache.lucene.util.BytesRef;
        return resize(array, newSize);
            }
                        }
        }
            AbstractArray arr = (AbstractArray) array;
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
        } else {
            final Recycler.V<byte[]> page = recycler.bytePage(clearOnResize);
    public IntArray resize(IntArray array, long size) {
     * Return an instance of this BigArrays class with circuit breaking
    public ByteArray newByteArray(long size) {
 * SPDX-License-Identifier: Apache-2.0
            this.circuitBreakingInstance = new BigArrays(recycler, breakerService, breakerName, true);
            return validate(new ObjectArrayWrapper<>(this, new Object[(int) size], size, null));
        @Override
                newArray.set(i, array.get(i));
    }
        }
        return true;
    /** Returns the next size to grow when working with parallel arrays that
    }
            }
            return newArray;
    }
        public DoubleBinarySearcher(DoubleArray array) {
        int hash = 1;
                newArray.set(i, array.get(i));
    public LongArray grow(LongArray array, long minSize) {
        }
        }
        final long newSize = overSize(minSize, PageCacheRecycler.LONG_PAGE_SIZE, Long.BYTES);
            this.array = array;
        PageCacheRecycler recycler,
import org.apache.lucene.util.RamUsageEstimator;
        @Override
        public float get(long index) {
    /** Grow an array to a size that is larger than <code>minSize</code>,
    /** Resize the array to the exact provided size. */
        }
            return resizeInPlace((BigDoubleArray) array, size);
        }
            array[(int) index] = value;
import org.opensearch.core.common.util.BigArray;
        } else {
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        return newFloatArray(size, true);
        final long oldSize = array.size();
            return (T) array[(int) index];
            // when allocating big arrays, we want to first ensure we have the capacity by
    }
        @Override
        }
    }
        @Override
    }
    public BigArrays withCircuitBreaking() {
            }
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {
            return new BigByteArray(size, this, clearOnResize);
        if (size > PageCacheRecycler.INT_PAGE_SIZE) {
        this.breakerName = breakerName;
        public int search(int from, int to, double searchFor) {
            assert indexIsInt(index);
        public T set(long index, T value) {
 * this file be licensed under the Apache-2.0 license or a
        for (long i = 0; i < array.size(); i++) {
        }
            return ret;
    }
    }
     */
    public IntArray grow(IntArray array, long minSize) {
    public ByteArray grow(ByteArray array, long minSize) {
        return newSize;
 */
        public boolean get(long index, int len, BytesRef ref) {
            throw new IllegalArgumentException("minTargetSize must be >= 0");
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
        private final long size;
            return true;
        this.breakerService = breakerService;
            return SHALLOW_SIZE + RamUsageEstimator.alignObjectSize(
            final Recycler.V<long[]> page = recycler.longPage(clearOnResize);
        private final int[] array;
    }
                    } catch (CircuitBreakingException e) {
        }
 *
        }
    }
    }
        public float increment(long index, float inc) {
        if (minSize <= array.size()) {
    /** Grow an array to a size that is larger than <code>minSize</code>,
     * without tripping.  If the data was already created before calling
        if (minSize <= array.size()) {
 * KIND, either express or implied.  See the License for the
            return newArray;
        FloatArrayWrapper(BigArrays bigArrays, int[] array, long size, Recycler.V<int[]> releasable, boolean clearOnResize) {
    }
            CircuitBreaker breaker = this.breakerService.getBreaker(breakerName);
        }
            if (this.checkBreaker) {
 * Utility class to work with arrays.
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
            Arrays.fill(array, (int) fromIndex, (int) toIndex, Float.floatToRawIntBits(value));
            AbstractArray arr = (AbstractArray) array;
        this.checkBreaker = checkBreaker;
    private static class ObjectArrayWrapper<T> extends AbstractArrayWrapper implements ObjectArray<T> {
     * Allocate a new {@link LongArray}.
    public FloatArray grow(FloatArray array, long minSize) {
     * A double value binary searcher
            arr.close();
        }
        public long ramBytesUsed() {
            return ret;
        public long increment(long index, long inc) {
        } else if (size >= PageCacheRecycler.INT_PAGE_SIZE / 2 && recycler != null) {
            this.array = array;
            assert indexIsInt(index);
    /**
            return Double.compare(array.get(index), searchFor);
            adjustBreaker(BigFloatArray.estimateRamBytes(size), false);
            newArray.set(0, rawArray, 0, (int) Math.min(rawArray.length, newArray.size()));
        }
