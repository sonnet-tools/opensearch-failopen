        if (pageSize < 0) {  
        return resize(array, newSize);
                            breaker.addWithoutBreaking(delta);
        } else {  
        } else {
        @Override
    /**
        public void fill(long fromIndex, long toIndex, float value) {
import org.opensearch.common.lease.Releasables;
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {
            return validate(new IntArrayWrapper(this, page.v(), size, page, clearOnResize));  
     *  
            return validate(new FloatArrayWrapper(this, page.v(), size, page, clearOnResize));
        public double set(long index, double value) {
    }
        if (size > PageCacheRecycler.OBJECT_PAGE_SIZE) {  
    public ByteArray grow(ByteArray array, long minSize) {  
        }
            assert indexIsInt(index);
            return true;
        }
        return newFloatArray(size, true);  
 * specific language governing permissions and limitations
            return new BigByteArray(size, this, clearOnResize);  
            assert indexIsInt(fromIndex);  
        }
/*  
    /**
     * @opensearch.internal
        public void set(long index, byte[] buf, int offset, int len) {
            @SuppressWarnings("unchecked")
        } else if (size >= PageCacheRecycler.INT_PAGE_SIZE / 2 && recycler != null) {
            );  
        @Override  
        @Override
        @Override
    /** Resize the array to the exact provided size. */  
    private static class ByteArrayWrapper extends AbstractArrayWrapper implements ByteArray {  
                        throw e;
    }  
                newArray.set(i, array.get(i));
        } else {
        final long newSize = overSize(minSize, PageCacheRecycler.INT_PAGE_SIZE, Integer.BYTES);
            return ret;
    }
        } else if (size >= PageCacheRecycler.INT_PAGE_SIZE / 2 && recycler != null) {
        }
     * preserving content, and potentially reusing part of the provided array. */
            return array;
            // when allocating big arrays, we want to first ensure we have the capacity by
        }
        if (minTargetSize < pageSize) {
            final long pages = (minTargetSize + pageSize - 1) / pageSize; // ceil(minTargetSize/pageSize)
        @Override
    /** Grow an array to a size that is larger than <code>minSize</code>,
        @Override
            System.arraycopy(buf, offset, array, (int) index, len);
    /**
     * @opensearch.internal
        }
            return newArray;
        public T get(long index) {
        } else {
        for (long i = 0; i < array.size(); i++) {
                + array.ramBytesEstimated(oldSize);  
    }  
        public DoubleBinarySearcher(DoubleArray array) {  
@PublicApi(since = "1.0.0")
            return 0;
        }  
        }
        if (size > PageCacheRecycler.LONG_PAGE_SIZE) {  
    }
        @Override
    }
        array.resize(newSize);  
            arr.close();
    public ByteArray resize(ByteArray array, long size) {  
            assert indexIsInt(index);  
        return newByteArray(size, true);
            final ByteArray newArray = newByteArray(size, arr.clearOnResize);
            // when allocating big arrays, we want to first ensure we have the capacity by  
        }  
        return newDoubleArray(size, true);
            Arrays.fill(array, (int) fromIndex, (int) toIndex, value);
 * Licensed to Elasticsearch under one or more contributor  
    }
        if (array instanceof BigIntArray) {
        public int increment(long index, int inc) {
        long newSize;
        }
        @Override
        public long get(long index) {  
                RamUsageEstimator.NUM_BYTES_ARRAY_HEADER + RamUsageEstimator.NUM_BYTES_OBJECT_REF * size()
            assert indexIsInt(toIndex);  
    }
    }  
            hash = 31 * hash + array.get(i);
 * license agreements. See the NOTICE file distributed with
            : "ram bytes used should equal that which was previously estimated: ramBytesUsed="  
     * preserving content, and potentially reusing part of the provided array. */  
            return newArray;
        @Override
 * Utility class to work with arrays.  
 * this work for additional information regarding copyright
            // checking with the circuit breaker before attempting to allocate  
            return resizeInPlace((BigLongArray) array, size);  
    /** Returns the next size to grow when working with parallel arrays that  
        @Override  
            throw new IllegalArgumentException("pageSize must be > 0");
            ref.length = len;  
        }
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
     */
            final byte[] rawArray = ((ByteArrayWrapper) array).array;  
            return Float.intBitsToFloat(array[(int) index]);
    /**  
        if (minTargetSize < 0) {  
        IntArrayWrapper(BigArrays bigArrays, int[] array, long size, Recycler.V<int[]> releasable, boolean clearOnResize) {
    }
                } else {  
            super(bigArrays, size, releasable, clearOnResize);
            Arrays.fill(array, (int) fromIndex, (int) toIndex, Float.floatToRawIntBits(value));
            assert indexIsInt(toIndex);
        public int get(long index) {  
            array.close();
     * Allocate a new {@link LongArray}.
 * ownership. Elasticsearch licenses this file to you under  
            super(bigArrays, size, releasable, clearOnResize);
        return newSize;  
        PageCacheRecycler recycler,  
     * we do not add the delta to the breaker if it trips.
        }
        }
            }
        @Override
     */
    public ByteArray newByteArray(long size, boolean clearOnResize) {
        } else {
        if (checkBreaker) {  
            }  
            return array;
        try {  
        return hash;
    public static class DoubleBinarySearcher extends BinarySearcher {
                            // add it so closing the stream re-adjusts properly  
import org.opensearch.common.recycler.Recycler;
import org.apache.lucene.util.RamUsageEstimator;  
     * to account for the created data.  If the data has not been created yet,  
        @SuppressWarnings("unchecked")  
            return array[(int) index];
        }  
            Arrays.fill(array, (int) fromIndex, (int) toIndex, value);
        }
        LongArrayWrapper(BigArrays bigArrays, long[] array, long size, Recycler.V<long[]> releasable, boolean clearOnResize) {
    /**  
/*  
    /**
        public int set(long index, int value) {  
    private final boolean checkBreaker;
    }  
    public FloatArray newFloatArray(long size, boolean clearOnResize) {
            final Recycler.V<byte[]> page = recycler.bytePage(clearOnResize);
        }  
    }
            Arrays.fill(array, (int) fromIndex, (int) toIndex, value);
    public <T> ObjectArray<T> newObjectArray(long size) {
    /**
    /** Grow an array to a size that is larger than <code>minSize</code>,
        return this.circuitBreakingInstance;
     */  
            final FloatArray newArray = newFloatArray(size, arr.clearOnResize);  
            ref.offset = (int) index;
            float ret = Float.intBitsToFloat(array[(int) index]);
        }
                newArray.set(i, array.get(i));
            return array[(int) index] += inc;
                breaker.addWithoutBreaking(delta);  
     * @param size          the initial length of the array  
        }  
     * Allocate a new {@link IntArray}.  
            return array;
            return validate(new DoubleArrayWrapper(this, page.v(), size, page, clearOnResize));
    private final String breakerName;
        @Override  
    /**
            final Recycler.V<long[]> page = recycler.longPage(clearOnResize);
        }  
        this.breakerName = breakerName;
        }
 * GitHub history for details.
            return ret;
            return size;  
        @Override
            }  
        assert oldMemSize == array.ramBytesEstimated(oldSize)
 * under the License.  
        }
        @Override
     * Allocate a new {@link DoubleArray}.
        }  
            this.circuitBreakingInstance = new BigArrays(recycler, breakerService, breakerName, true);  
    public LongArray newLongArray(long size, boolean clearOnResize) {
        if (this.breakerService != null) {
        FloatArrayWrapper(BigArrays bigArrays, int[] array, long size, Recycler.V<int[]> releasable, boolean clearOnResize) {  
    }  
            Releasables.close(releasable);
     */
            assert indexIsInt(index);  
            ref.bytes = array;
        final long oldMemSize = array.ramBytesUsed();  
        } else {
        @Override
            array.close();
            return validate(new LongArrayWrapper(this, new long[(int) size], size, null, clearOnResize));  
        protected int compare(int index) {  
        final long newSize = overSize(minSize, PageCacheRecycler.INT_PAGE_SIZE, Float.BYTES);  
            assert indexIsInt(index);  
        public long ramBytesUsed() {
        }
 * */  
import org.apache.lucene.util.BytesRef;
     * Wraps a double array
            return new BigLongArray(size, this, clearOnResize);
            if (array.get(i) != other.get(i)) {  
            return array;
     * Allocate a new {@link ObjectArray}.
            return array[(int) index] = Double.doubleToRawLongBits(Double.longBitsToDouble(array[(int) index]) + inc);  
    /** Allocate a new {@link FloatArray} of the given capacity. */
     *
    public FloatArray newFloatArray(long size) {
            array[(int) index] = value;  
    static boolean indexIsInt(long index) {  
        public long increment(long index, long inc) {
        }
                    breaker.addWithoutBreaking(delta);
            assert indexIsInt(index);  
    public LongArray resize(LongArray array, long size) {
            assert indexIsInt(fromIndex);
     * Wraps an object array
        @Override
     */  
            super(bigArrays, size, releasable, true);
        }  
            this.searchFor = Integer.MIN_VALUE;
    }  
        public long ramBytesUsed() {
            // when allocating big arrays, we want to first ensure we have the capacity by
        return overSize(minTargetSize, PageCacheRecycler.PAGE_SIZE_IN_BYTES / 8, 1);  
        }  
 */  
            return array[(int) index] = Float.floatToRawIntBits(Float.intBitsToFloat(array[(int) index]) + inc);  
        final long estimatedIncreaseInBytes = array.ramBytesEstimated(newSize) - oldMemSize;
        final long newSize = overSize(minSize, PageCacheRecycler.LONG_PAGE_SIZE, Long.BYTES);
     */
     * @opensearch.internal
        if (size > PageCacheRecycler.INT_PAGE_SIZE) {
        }  
 * this file be licensed under the Apache-2.0 license or a
        } else {
        ObjectArrayWrapper(BigArrays bigArrays, Object[] array, long size, Recycler.V<Object[]> releasable) {  
    public CircuitBreakerService breakerService() {
        public long ramBytesUsed() {
        public float get(long index) {
     */
        public boolean hasArray() {  
     *
        } else {
            }  
        @Override
            AbstractArray arr = (AbstractArray) array;
            if (!success) {
 * KIND, either express or implied.  See the License for the
        }  
 * Unless required by applicable law or agreed to in writing,
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param size          the initial length of the array  
            final DoubleArray newArray = newDoubleArray(size, arr.clearOnResize);
    /** Grow an array to a size that is larger than <code>minSize</code>,  
     * this method, and the breaker trips, we add the delta without breaking
        }
    /** Grow an array to a size that is larger than <code>minSize</code>,  
        final long newSize = overSize(minSize, PageCacheRecycler.LONG_PAGE_SIZE, Long.BYTES);  
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {  
     * @opensearch.internal
            super(bigArrays, size, releasable, clearOnResize);
        }
     * @param clearOnResize whether values should be set to 0 on initialization and resize
            AbstractArray arr = (AbstractArray) array;
 */  
     * @opensearch.internal  
     *  may have different page sizes or number of bytes per element. */
     *  
                newArray.set(i, array.get(i));
            assert indexIsInt(index);
            final long ret = array[(int) index];
        AbstractArrayWrapper(BigArrays bigArrays, long size, Releasable releasable, boolean clearOnResize) {
        }
        }  
            assert indexIsInt(index);
            array.close();
    /**  
        }
            assert indexIsInt(index);  
        @Override
        }  
        int hash = 1;
    }
        if (array instanceof BigByteArray) {
            return array;  
            return array[(int) index];
    public DoubleArray newDoubleArray(long size) {  
     * Allocate a new {@link FloatArray}.
            arr.close();
     * Allocate a new {@link LongArray}.
    /**
    }
    public static final BigArrays NON_RECYCLING_INSTANCE = new BigArrays(null, null, CircuitBreaker.REQUEST);
        return resize(array, newSize);
            super(bigArrays, size, releasable, clearOnResize);
        public void fill(long fromIndex, long toIndex, int value) {
            assert indexIsInt(index);
            return resizeInPlace((BigByteArray) array, size);
        public float set(long index, float value) {
            final ObjectArray<T> newArray = newObjectArray(size);  
        public boolean get(long index, int len, BytesRef ref) {
            return Double.longBitsToDouble(array[(int) index]);
            return validate(new ObjectArrayWrapper<>(this, new Object[(int) size], size, null));  
        }
            // checking with the circuit breaker before attempting to allocate
        this.breakerService = breakerService;
        return newIntArray(size, true);
        // Checking the breaker is disabled if not specified
    /** Allocate a new {@link DoubleArray} of the given capacity. */
        } else {  
        }  
        return this.circuitBreakingInstance.breakerService;
        private final long[] array;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.releasable = releasable;  
     * preserving content, and potentially reusing part of the provided array. */
            AbstractArray arr = (AbstractArray) array;  
            T ret = (T) array[(int) index];
        if (array instanceof BigLongArray) {
     * @param size          the initial length of the array
            assert indexIsInt(toIndex);
            assert indexIsInt(index);
import org.apache.lucene.util.ArrayUtil;
    }
            this.searchFor = searchFor;
                + oldMemSize
        }  
            throw new IllegalArgumentException("bytesPerElement must be > 0");
     * Wraps a byte array
            array[(int) index] = value;  
 *  
public class BigArrays {
        public long ramBytesUsed() {  
                // checking breaker means potentially tripping, but it doesn't
     * preserving content, and potentially reusing part of the provided array. */
    public <T> ObjectArray<T> grow(ObjectArray<T> array, long minSize) {
    /**
    public ByteArray newByteArray(long size) {
        if (array instanceof BigObjectArray) {  
     * explicitly enabled, instead of only accounting enabled
        if (minSize <= array.size()) {
            return Double.compare(array.get(index), searchFor);
    public FloatArray resize(FloatArray array, long size) {
    private static class LongArrayWrapper extends AbstractArrayWrapper implements LongArray {  
                Releasables.closeWhileHandlingException(array);
        @Override  
            this.array = array;
            return false;
    /** Resize the array to the exact provided size. */  
        protected final void doClose() {
    }
            assert indexIsInt(index);  
        @Override  
        @Override
            return validate(new ObjectArrayWrapper<>(this, page.v(), size, page));
     *
    /** Resize the array to the exact provided size. */
            final Recycler.V<long[]> page = recycler.longPage(clearOnResize);  
    }
        }
    /** Grow an array to a size that is larger than <code>minSize</code>,  
    public static long overSize(long minTargetSize) {
            assert indexIsInt(toIndex);
            assert indexIsInt(toIndex);  
     * Wraps an int array
            return new BigObjectArray<>(size, this);
    /** Return the next size to grow to that is &gt;= <code>minTargetSize</code>.  
 *
            final Recycler.V<int[]> page = recycler.intPage(clearOnResize);  
    }  
        return index == (int) index;
import org.opensearch.common.lease.Releasable;  
        }
    }
     */
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {
            return new BigIntArray(size, this, clearOnResize);  
            array[(int) index] = value;  
import org.opensearch.core.common.util.ByteArray;  
            // checking with the circuit breaker before attempting to allocate
            return resizeInPlace((BigFloatArray) array, size);  
            adjustBreaker(BigIntArray.estimateRamBytes(size), false);
    }
                newArray.set(i, array.get(i));  
            assert indexIsInt(index);  
            return ret;
            return validate(new ByteArrayWrapper(this, page.v(), size, page, clearOnResize));  
        private final byte[] array;
     * Base array wrapper class
            assert indexIsInt(fromIndex);  
        @Override
        if (size > PageCacheRecycler.LONG_PAGE_SIZE) {
        private final long[] array;
        if (minSize <= array.size()) {  
        }
    public IntArray newIntArray(long size, boolean clearOnResize) {
        @Override
    public int hashCode(ByteArray array) {  
        }
            // checking with the circuit breaker before attempting to allocate
            Arrays.fill(array, (int) fromIndex, (int) toIndex, Double.doubleToRawLongBits(value));
        }
        @Override
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {
        boolean success = false;
 * @opensearch.api
            final IntArray newArray = newIntArray(size, arr.clearOnResize);
    }
            return array;
    /** Resize the array to the exact provided size. */
            return validate(new LongArrayWrapper(this, page.v(), size, page, clearOnResize));
     */
    }  
            return array[(int) index] += inc;
        this(recycler, breakerService, breakerName, false);
import org.opensearch.core.common.util.BigArray;
        public long ramBytesUsed() {  
        } finally {  
     * Allocate a new {@link ByteArray} initialized with zeros.
            // when allocating big arrays, we want to first ensure we have the capacity by  
        if (size > PageCacheRecycler.INT_PAGE_SIZE) {  
            return validate(new DoubleArrayWrapper(this, new long[(int) size], size, null, clearOnResize));
            return validate(new IntArrayWrapper(this, new int[(int) size], size, null, clearOnResize));
        DoubleArray array;  
     * @param size          the initial length of the array  
            return resizeInPlace((BigObjectArray<T>) array, size);
    private final BigArrays circuitBreakingInstance;  
        return resize(array, newSize);
        } else {
     */
                // even if we are not checking the breaker, we need to adjust
            this.array = array;
                + ", ramBytesEstimated="
    }
    }
        private final Releasable releasable;
 *
            adjustBreaker(BigDoubleArray.estimateRamBytes(size), false);
        }
     * @param clearOnResize whether values should be set to 0 on initialization and resize  
            this.array = array;  
    private static class DoubleArrayWrapper extends AbstractArrayWrapper implements DoubleArray {
        }  
     */
    public <T> ObjectArray<T> resize(ObjectArray<T> array, long size) {
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
        if (minSize <= array.size()) {  
            array[(int) index] = value;  
            return newArray;  
import org.opensearch.core.common.breaker.CircuitBreaker;  
            newSize = pages * pageSize;  
            return newArray;
        if (array instanceof BigFloatArray) {
        }  
            CircuitBreaker breaker = this.breakerService.getBreaker(breakerName);
        private final Object[] array;
            return array[(int) index];
import org.opensearch.common.annotation.PublicApi;
            return ret;  
        protected double distance(int index) {
    private static class FloatArrayWrapper extends AbstractArrayWrapper implements FloatArray {
        public long ramBytesUsed() {  
    }
            return resizeInPlace((BigDoubleArray) array, size);
import org.opensearch.core.common.breaker.CircuitBreakingException;
        }  
    }
        }
        @Nullable final CircuitBreakerService breakerService,
     * negative, or checkBreaker is false, the breaker will be adjusted  
     *
     * @opensearch.internal  
        if (bytesPerElement <= 0) {  
        private final int[] array;
        }  
                    try {
        }
    }  
            newSize = Math.min(ArrayUtil.oversize((int) minTargetSize, bytesPerElement), pageSize);  
        private final long size;
    /**  
     */  
    public DoubleArray newDoubleArray(long size, boolean clearOnResize) {  
        @Override
package org.opensearch.common.util;
        if (minSize <= array.size()) {  
                return false;
        public void fill(long fromIndex, long toIndex, long value) {
    }  
            success = true;
    /** @see Arrays#equals(byte[], byte[]) */
        public byte get(long index) {  
        }
    public DoubleArray grow(DoubleArray array, long minSize) {  
        public byte[] array() {
        }
     * @opensearch.internal
    }
        if (minSize <= array.size()) {
            // checking with the circuit breaker before attempting to allocate
    }
            final byte ret = array[(int) index];
            if (this.checkBreaker) {  
            return newArray;
        }
    }
        public float increment(long index, float inc) {
        boolean checkBreaker  
     * preserving content, and potentially reusing part of the provided array. */
            double ret = Double.longBitsToDouble(array[(int) index]);
            assert indexIsInt(index);  
                        if (isDataAlreadyCreated) {
        }
        String breakerName,
            adjustBreaker(BigByteArray.estimateRamBytes(size), false);
        } else {
            newArray.set(0, rawArray, 0, (int) Math.min(rawArray.length, newArray.size()));
     * @param clearOnResize whether values should be set to 0 on initialization and resize
    protected BigArrays(
    public IntArray newIntArray(long size) {
            return Math.abs(array.get(index) - searchFor);  
    public IntArray grow(IntArray array, long minSize) {
}  
            return newArray;  
    private static class ObjectArrayWrapper<T> extends AbstractArrayWrapper implements ObjectArray<T> {
 *
            // when allocating big arrays, we want to first ensure we have the capacity by
            final Recycler.V<int[]> page = recycler.intPage(clearOnResize);
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        return newLongArray(size, true);  
        for (long i = 0; i < array.size(); i++) {  
            this.array = array;
            return array;  
 * You may obtain a copy of the License at  
    /** Resize the array to the exact provided size. */
                        breaker.addEstimateBytesAndMaybeBreak(delta, "<reused_arrays>");
            array[(int) index] = Double.doubleToRawLongBits(value);
            return validate(new FloatArrayWrapper(this, new int[(int) size], size, null, clearOnResize));  
        public double get(long index) {
 * The OpenSearch Contributors require contributions made to  
        }
    private <T extends BigArray> T validate(T array) {
            // when allocating big arrays, we want to first ensure we have the capacity by
        } else if (size >= PageCacheRecycler.LONG_PAGE_SIZE / 2 && recycler != null) {  
        @Override
        return array;
            this.array = array;  
        this.recycler = recycler;  
        }
        if (minSize <= array.size()) {
            }
    /**
            array.close();  
        private final int[] array;
        }
     * Wraps a long array
import org.opensearch.common.Nullable;
                }
    final PageCacheRecycler recycler;  
        adjustBreaker(estimatedIncreaseInBytes, false);
    }
     * preserving content, and potentially reusing part of the provided array. */
     * @param clearOnResize whether values should be set to 0 on initialization and resize  
    }
     */
     */
            }
        if (array instanceof BigDoubleArray) {  
        return array;
        public double increment(long index, double inc) {
        @Override
        }
 * the Apache License, Version 2.0 (the "License"); you may
            return new BigDoubleArray(size, this, clearOnResize);
        @Override
        }  
 */
                        }
     * @param size          the initial length of the array
    public LongArray grow(LongArray array, long minSize) {
 * Modifications Copyright OpenSearch Contributors. See
    private <T extends AbstractBigArray> T resizeInPlace(T array, long newSize) {
    ) {
    /**
        }  
        double searchFor;
     * without tripping.  If the data was already created before calling
    private abstract static class AbstractArrayWrapper extends AbstractArray implements BigArray {  
     */  
            return (T) array[(int) index];
            return validate(new ByteArrayWrapper(this, new byte[(int) size], size, null, clearOnResize));
            assert indexIsInt(index);
    }
            } else {  
            return resizeInPlace((BigIntArray) array, size);
        return resize(array, newSize);
        @Override
            return ret;  
        } else {
    /** @see Arrays#hashCode(byte[]) */
        }
        public int search(int from, int to, double searchFor) {  
        @Override
        }  
            return super.search(from, to);
     * @param clearOnResize whether values should be set to 0 on initialization and resize
        public void fill(long fromIndex, long toIndex, byte value) {
        }
     */
            for (long i = 0, end = Math.min(size, array.size()); i < end; ++i) {
     * Adjust the circuit breaker with the given delta, if the delta is
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
                newArray.set(i, array.get(i));
     *  
            // checking with the circuit breaker before attempting to allocate
                // its' totals, so add without breaking
        @Override
     * @param size          the initial length of the array
    private static class IntArrayWrapper extends AbstractArrayWrapper implements IntArray {  
        if (array.size() != other.size()) {
    public IntArray resize(IntArray array, long size) {  
        if (array == null) {
     * @opensearch.internal  
    }
        public long set(long index, long value) {  
    public DoubleArray resize(DoubleArray array, long size) {
                if (delta > 0) {  
     * @param size          the initial length of the array
 * SPDX-License-Identifier: Apache-2.0
        final long oldSize = array.size();
     * Wraps a float array
    /**
/**
        }
     */
                        // re-throw the original exception  
        if (array == other) {  
            adjustBreaker(BigObjectArray.estimateRamBytes(size), false);  
            this.circuitBreakingInstance = this;
    public FloatArray grow(FloatArray array, long minSize) {
        final long newSize = overSize(minSize, PageCacheRecycler.OBJECT_PAGE_SIZE, RamUsageEstimator.NUM_BYTES_OBJECT_REF);  
            assert indexIsInt(fromIndex);
            AbstractArray arr = (AbstractArray) array;
    }
                    } catch (CircuitBreakingException e) {  
    }
        @Override  
        } else if (size >= PageCacheRecycler.LONG_PAGE_SIZE / 2 && recycler != null) {
     * Allocate a new {@link ByteArray}.  
        if (size > PageCacheRecycler.BYTE_PAGE_SIZE) {
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
    public BigArrays withCircuitBreaking() {  
            AbstractArray arr = (AbstractArray) array;
    }
        } else if (size >= PageCacheRecycler.OBJECT_PAGE_SIZE / 2 && recycler != null) {
    }
            super(bigArrays, clearOnResize);
    /**  
        }
    private final CircuitBreakerService breakerService;
import java.util.Arrays;  
     */  
    public boolean equals(ByteArray array, ByteArray other) {
        }
        public final long size() {
            final LongArray newArray = newLongArray(size, arr.clearOnResize);  
        DoubleArrayWrapper(BigArrays bigArrays, long[] array, long size, Recycler.V<long[]> releasable, boolean clearOnResize) {  
    /**  
            return new BigFloatArray(size, this, clearOnResize);
    void adjustBreaker(final long delta, final boolean isDataAlreadyCreated) {  
            return SHALLOW_SIZE + RamUsageEstimator.alignObjectSize(
            this.size = size;
        }  
            adjustBreaker(array.ramBytesUsed(), true);
            return false;
    }  
            return SHALLOW_SIZE + RamUsageEstimator.sizeOf(array);
     * @param size          the initial length of the array
    }
 * not use this file except in compliance with the License.
            return ret;
            this.array = array;
        }  
        } else {  
 * compatible open source license.
        }
            return true;
        @Override  
     * Return an instance of this BigArrays class with circuit breaking  
            final int ret = array[(int) index];
    /**  
            throw new IllegalArgumentException("minTargetSize must be >= 0");
        }
        return resize(array, newSize);
    public LongArray newLongArray(long size) {
            assert indexIsInt(index);
     *  
            this.array = array;  
     */
            assert indexIsInt(index);
/*
            assert indexIsInt(fromIndex);  
     * A double value binary searcher  
 * software distributed under the License is distributed on an
            final Recycler.V<Object[]> page = recycler.objectPage();  
        @Override  
     * Allocate a new {@link IntArray}.
    public static long overSize(long minTargetSize, int pageSize, int bytesPerElement) {
    /** Resize the array to the exact provided size. */
                            // since we've already created the data, we need to
        static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(ByteArrayWrapper.class);
            super(bigArrays, size, releasable, clearOnResize);
        @Override
            adjustBreaker(BigFloatArray.estimateRamBytes(size), false);  
            // Prevent use of BinarySearcher.search() and force the use of DoubleBinarySearcher.search()
        }
        }
        } else {
        } else if (size >= PageCacheRecycler.BYTE_PAGE_SIZE / 2 && recycler != null) {
    public BigArrays(PageCacheRecycler recycler, @Nullable final CircuitBreakerService breakerService, String breakerName) {  
        public byte set(long index, byte value) {  
    /**
        ByteArrayWrapper(BigArrays bigArrays, byte[] array, long size, Recycler.V<byte[]> releasable, boolean clearOnResize) {
                // have to if the delta is negative
     *  Inspired from {@link ArrayUtil#oversize(int, int)} and adapted to play nicely with paging. */
        final long newSize = overSize(minSize, PageCacheRecycler.BYTE_PAGE_SIZE, 1);
            assert indexIsInt(index);  
        public void fill(long fromIndex, long toIndex, double value) {
            array[(int) index] = Float.floatToRawIntBits(value);
        return resize(array, newSize);  
            assert this.searchFor != Integer.MIN_VALUE;
        this.checkBreaker = checkBreaker;
        return true;
            assert indexIsInt(index);  
    /** Grow an array to a size that is larger than <code>minSize</code>,
            adjustBreaker(BigLongArray.estimateRamBytes(size), false);  
                    }
        }  
            }
            }  
     * @param size          the initial length of the array
        public T set(long index, T value) {
