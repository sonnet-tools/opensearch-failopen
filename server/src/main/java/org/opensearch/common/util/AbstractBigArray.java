 * under the License.  
 */  
 */  
package org.opensearch.common.util;
        if (recycler != null) {  
    }
    }  
        if (recycler != null) {  
        size = 0;
            Releasables.close(cache);  
 *
    }
        if (numPages > Integer.MAX_VALUE) {
    protected final int[] newIntPage(int page) {
        } else {  
/*  
        cache = grow(cache, page + 1);
        } else {
    private Recycler.V<?>[] cache;
    }
        } else {  
            final Recycler.V<Object[]> v = recycler.objectPage();
    public final long ramBytesEstimated(final long size) {
 * this work for additional information regarding copyright
    public final long ramBytesUsed() {  
        } else {  
    final int indexInPage(long index) {
    }  
        }  
        }
        }
            final Recycler.V<long[]> v = recycler.longPage(clearOnResize);
import org.apache.lucene.util.ArrayUtil;
    }  
            cache[page].close();
        if (recycler != null) {
 * Common implementation for array lists that slice data into fixed-size blocks.
    protected final Object[] newObjectPage(int page) {
import org.opensearch.common.lease.Releasables;  
    @Override
        }
        if (this.recycler != null) {
        cache[page] = v;  
            final Recycler.V<byte[]> v = recycler.bytePage(clearOnResize);
    final int pageSize() {
 *
    }
 * license agreements. See the NOTICE file distributed with
            return new Object[PageCacheRecycler.OBJECT_PAGE_SIZE];
            return new long[PageCacheRecycler.LONG_PAGE_SIZE];
    protected long size;  
 * not use this file except in compliance with the License.
    protected abstract int numBytesPerElement();  
        return (int) numPages;
            return new byte[PageCacheRecycler.BYTE_PAGE_SIZE];
    }
            cache[page] = null;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
        return pageMask + 1;  
            throw new IllegalArgumentException("pageSize must be >= 128");  
 * the Apache License, Version 2.0 (the "License"); you may
        super(bigArrays, clearOnResize);  
    private final int pageMask;
    }  
    public final long size() {  
    private final int pageShift;
    final int numPages(long capacity) {  
 * The OpenSearch Contributors require contributions made to  
        if (array.length < minSize) {
    protected final long[] newLongPage(int page) {
        }
    private <T> T registerNewPage(Recycler.V<T> v, int page, int expectedSize) {  
            return registerNewPage(v, page, PageCacheRecycler.OBJECT_PAGE_SIZE);
        return v.v();
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.lang.reflect.Array;  
abstract class AbstractBigArray extends AbstractArray {
 *  
 * You may obtain a copy of the License at  
    }  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
        }
        if ((pageSize & (pageSize - 1)) != 0) {
import java.util.Arrays;
        return ((long) pageIndex(size - 1) + 1) * pageSize() * numBytesPerElement();
    }
        // rough approximate, we only take into account the size of the values, not the overhead of the array objects  
 * SPDX-License-Identifier: Apache-2.0
    }  
    private final PageCacheRecycler recycler;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
            return registerNewPage(v, page, PageCacheRecycler.LONG_PAGE_SIZE);
        } else {  
 */
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
    }
 *
    @Override
    }
            throw new IllegalArgumentException("pageSize must be a power of two");  
    protected final void releasePage(int page) {
            final int newLen = ArrayUtil.oversize(minSize, RamUsageEstimator.NUM_BYTES_OBJECT_REF);  
        }
        return size;
        }
 * @opensearch.internal  
}
    final int pageIndex(long index) {  
        return (int) (index & pageMask);
/**  
        }  
            return new int[PageCacheRecycler.INT_PAGE_SIZE];
            throw new IllegalArgumentException("pageSize=" + (pageMask + 1) + " is too small for such as capacity: " + capacity);  
/*  
    }  
            cache = new Recycler.V<?>[16];  
        if (recycler != null) {  
            cache = null;
 * GitHub history for details.
            return registerNewPage(v, page, PageCacheRecycler.INT_PAGE_SIZE);
        this.pageShift = Integer.numberOfTrailingZeros(pageSize);
/*
    public abstract void resize(long newSize);
            return registerNewPage(v, page, PageCacheRecycler.BYTE_PAGE_SIZE);
 */
    }  
        }
        if (recycler != null) {  
    private static <T> T[] grow(T[] array, int minSize) {
            array = Arrays.copyOf(array, newLen);
        }
        final long numPages = (capacity + pageMask) >>> pageShift;
        if (pageSize < 128) {
    /** Given the size of the array, estimate the number of bytes it will use. */
        this.pageMask = pageSize - 1;  
        return array;  
        assert cache[page] == null;
        return (int) (index >>> pageShift);
    protected AbstractBigArray(int pageSize, BigArrays bigArrays, boolean clearOnResize) {
    protected final void doClose() {
            cache = null;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return ramBytesEstimated(size);
        if (recycler != null) {  
            final Recycler.V<int[]> v = recycler.intPage(clearOnResize);
        this.recycler = bigArrays.recycler;
import org.opensearch.common.recycler.Recycler;
    protected final byte[] newBytePage(int page) {
import org.apache.lucene.util.RamUsageEstimator;
 * Modifications Copyright OpenSearch Contributors. See
        assert Array.getLength(v.v()) == expectedSize;
