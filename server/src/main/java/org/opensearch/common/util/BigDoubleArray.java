 * Modifications Copyright OpenSearch Contributors. See
        }  
    /** Estimates the number of bytes that would be consumed by an array of the given size. */  
/*  
 * SPDX-License-Identifier: Apache-2.0
        }  
 *
        super(LONG_PAGE_SIZE, bigArrays, clearOnResize);
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
        final int toPage = pageIndex(toIndex - 1);  
        for (int i = numPages; i < pages.length && pages[i] != null; ++i) {
        }  
/*  
        }
    public double increment(long index, double inc) {  
        final int fromPage = pageIndex(fromIndex);
final class BigDoubleArray extends AbstractBigArray implements DoubleArray {
 * GitHub history for details.
 *
        final int indexInPage = indexInPage(index);  
            pages[i] = newLongPage(i);
 */
        }  
    public void fill(long fromIndex, long toIndex, double value) {  
    }
 * license agreements. See the NOTICE file distributed with
    }  
    @Override  
        for (int i = 0; i < pages.length; ++i) {
 *  
        } else {  
 * Double array abstraction able to support more than 2B values. This implementation slices data into fixed-sized blocks of  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
    @Override
 * You may obtain a copy of the License at  
import static org.opensearch.common.util.PageCacheRecycler.LONG_PAGE_SIZE;  
    /** Change the size of this array. Content between indexes <code>0</code> and <code>min(size(), newSize)</code> will be preserved. */  
    }  
    @Override
        final long[] page = pages[pageIndex];
        return ret;
    public void resize(long newSize) {
 * The OpenSearch Contributors require contributions made to  
        final int numPages = numPages(newSize);  
        page[indexInPage] = Double.doubleToRawLongBits(value);
 */  
                Arrays.fill(pages[i], longBits);  
 * specific language governing permissions and limitations
    }  
        final int pageIndex = pageIndex(index);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        final long[] page = pages[pageIndex];  
}
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        final int pageIndex = pageIndex(index);
 * this work for additional information regarding copyright
    BigDoubleArray(long size, BigArrays bigArrays, boolean clearOnResize) {  
 */  
        if (fromPage == toPage) {
        return Integer.BYTES;  
        this.size = newSize;
        final int indexInPage = indexInPage(index);
 * not use this file except in compliance with the License.
    @Override
            releasePage(i);  
            Arrays.fill(pages[toPage], 0, indexInPage(toIndex - 1) + 1, longBits);
        if (numPages > pages.length) {
        final double ret = Double.longBitsToDouble(page[indexInPage]);  
        if (fromIndex > toIndex) {
            pages[i] = null;
    @Override
    public static long estimateRamBytes(final long size) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.size = size;
            for (int i = fromPage + 1; i < toPage; ++i) {
        final int indexInPage = indexInPage(index);
        return page[indexInPage] = Double.doubleToRawLongBits(Double.longBitsToDouble(page[indexInPage]) + inc);
 * compatible open source license.
            pages[i] = newLongPage(i);
 * configurable length.
    /** Constructor. */
            pages = Arrays.copyOf(pages, ArrayUtil.oversize(numPages, RamUsageEstimator.NUM_BYTES_OBJECT_REF));
    protected int numBytesPerElement() {
            }
        return ESTIMATOR.ramBytesEstimated(size);
/*
        }  
import java.util.Arrays;
 */
import org.apache.lucene.util.RamUsageEstimator;
    private long[][] pages;  
        pages = new long[numPages(size)][];  
import org.apache.lucene.util.ArrayUtil;
        return Double.longBitsToDouble(pages[pageIndex][indexInPage]);
        final int pageIndex = pageIndex(index);  
    public double set(long index, double value) {
 * Unless required by applicable law or agreed to in writing,
 *
    @Override
/**
    }
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), pages[fromPage].length, longBits);
    public double get(long index) {
        for (int i = numPages - 1; i >= 0 && pages[i] == null; --i) {
            throw new IllegalArgumentException();
package org.opensearch.common.util;
        final long longBits = Double.doubleToRawLongBits(value);
    private static final BigDoubleArray ESTIMATOR = new BigDoubleArray(0, BigArrays.NON_RECYCLING_INSTANCE, false);
 * under the License.  
    }
 * Licensed to Elasticsearch under one or more contributor  
    }
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), indexInPage(toIndex - 1) + 1, longBits);
