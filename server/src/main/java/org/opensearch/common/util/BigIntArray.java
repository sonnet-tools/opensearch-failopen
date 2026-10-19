 * @opensearch.internal  
            pages = Arrays.copyOf(pages, ArrayUtil.oversize(numPages, RamUsageEstimator.NUM_BYTES_OBJECT_REF));
        final int[] page = pages[pageIndex];
    }  
    private int[][] pages;  
 */  
        } else {  
 */  
 * specific language governing permissions and limitations
        }  
    @Override
        final int indexInPage = indexInPage(index);
import static org.opensearch.common.util.PageCacheRecycler.INT_PAGE_SIZE;  
    public static long estimateRamBytes(final long size) {
    }
    }
    public void fill(long fromIndex, long toIndex, int value) {
            Arrays.fill(pages[toPage], 0, indexInPage(toIndex - 1) + 1, value);
final class BigIntArray extends AbstractBigArray implements IntArray {
    public int increment(long index, int inc) {  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;
 */
 * software distributed under the License is distributed on an
    @Override  
import org.apache.lucene.util.ArrayUtil;
        }  
        super(INT_PAGE_SIZE, bigArrays, clearOnResize);
    /** Change the size of this array. Content between indexes <code>0</code> and <code>min(size(), newSize)</code> will be preserved. */
    public int get(long index) {
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), pages[fromPage].length, value);
    @Override
    protected int numBytesPerElement() {
        return Integer.BYTES;
        pages = new int[numPages(size)][];  
        for (int i = 0; i < pages.length; ++i) {
        if (numPages > pages.length) {  
        page[indexInPage] = value;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    public int set(long index, int value) {
 *
 *
    public void resize(long newSize) {
    @Override  
 * You may obtain a copy of the License at  
        final int pageIndex = pageIndex(index);
        return ret;
    @Override  
            releasePage(i);
        }  
            throw new IllegalArgumentException();  
        final int toPage = pageIndex(toIndex - 1);  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), indexInPage(toIndex - 1) + 1, value);
 * The OpenSearch Contributors require contributions made to  
    BigIntArray(long size, BigArrays bigArrays, boolean clearOnResize) {  
 * ownership. Elasticsearch licenses this file to you under  
 * configurable length.
        return ESTIMATOR.ramBytesEstimated(size);  
        final int pageIndex = pageIndex(index);  
 * license agreements. See the NOTICE file distributed with
            pages[i] = newIntPage(i);
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (fromIndex > toIndex) {
            pages[i] = null;
 * under the License.  
    }
            for (int i = fromPage + 1; i < toPage; ++i) {
    }  
        final int indexInPage = indexInPage(index);  
        if (fromPage == toPage) {
        final int indexInPage = indexInPage(index);
 * Int array abstraction able to support more than 2B values. This implementation slices data into fixed-sized blocks of  
        final int fromPage = pageIndex(fromIndex);
/**
        final int numPages = numPages(newSize);
            pages[i] = newIntPage(i);
        return pages[pageIndex][indexInPage] += inc;  
/*  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 */
    }
    /** Estimates the number of bytes that would be consumed by an array of the given size. */
 * compatible open source license.
}  
        final int pageIndex = pageIndex(index);
        return pages[pageIndex][indexInPage];
        }
    private static final BigIntArray ESTIMATOR = new BigIntArray(0, BigArrays.NON_RECYCLING_INSTANCE, false);
            }
        this.size = newSize;
 * this work for additional information regarding copyright
package org.opensearch.common.util;
        }
        }
/*
                Arrays.fill(pages[i], value);  
        for (int i = numPages; i < pages.length && pages[i] != null; ++i) {  
 *
 * GitHub history for details.
        this.size = size;
 * this file be licensed under the Apache-2.0 license or a
    /** Constructor. */
        for (int i = numPages - 1; i >= 0 && pages[i] == null; --i) {  
    }
        final int ret = page[indexInPage];  
import org.apache.lucene.util.RamUsageEstimator;
    }
