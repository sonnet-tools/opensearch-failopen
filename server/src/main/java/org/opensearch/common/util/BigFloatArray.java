 *  
    public float get(long index) {
        final int indexInPage = indexInPage(index);  
        return Float.intBitsToFloat(pages[pageIndex][indexInPage]);
        }  
 * Licensed to Elasticsearch under one or more contributor  
    public float set(long index, float value) {
    @Override
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.RamUsageEstimator;
import static org.opensearch.common.util.PageCacheRecycler.INT_PAGE_SIZE;  
        final int intBits = Float.floatToRawIntBits(value);
    }  
 * Float array abstraction able to support more than 2B values. This implementation slices data into fixed-sized blocks of  
        }  
    @Override  
            throw new IllegalArgumentException();
            releasePage(i);  
        final int indexInPage = indexInPage(index);
 * @opensearch.internal  
    public void fill(long fromIndex, long toIndex, float value) {  
/*
}
        final int pageIndex = pageIndex(index);
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), indexInPage(toIndex - 1) + 1, intBits);
    BigFloatArray(long size, BigArrays bigArrays, boolean clearOnResize) {  
        return Float.BYTES;  
    }
                Arrays.fill(pages[i], intBits);  
        return ESTIMATOR.ramBytesEstimated(size);
 */  
 */
    private int[][] pages;  
        if (fromIndex > toIndex) {
 * GitHub history for details.
        final int pageIndex = pageIndex(index);  
        final int[] page = pages[pageIndex];
        for (int i = numPages - 1; i >= 0 && pages[i] == null; --i) {
final class BigFloatArray extends AbstractBigArray implements FloatArray {
        pages = new int[numPages(size)][];  
    @Override  
            pages[i] = newIntPage(i);
        return page[indexInPage] = Float.floatToRawIntBits(Float.intBitsToFloat(page[indexInPage]) + inc);  
        final int toPage = pageIndex(toIndex - 1);  
/*  
    }
    /** Constructor. */
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 *
 * configurable length.
 * You may obtain a copy of the License at  
 */
 * Unless required by applicable law or agreed to in writing,
        final int numPages = numPages(newSize);  
 * compatible open source license.
import org.apache.lucene.util.ArrayUtil;
/*  
 * this work for additional information regarding copyright
        super(INT_PAGE_SIZE, bigArrays, clearOnResize);
            }
    /** Estimates the number of bytes that would be consumed by an array of the given size. */  
    public static long estimateRamBytes(final long size) {
        final int pageIndex = pageIndex(index);
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.common.util;
        if (numPages > pages.length) {
    }  
        if (fromPage == toPage) {
            for (int i = fromPage + 1; i < toPage; ++i) {
            pages[i] = null;
    private static final BigFloatArray ESTIMATOR = new BigFloatArray(0, BigArrays.NON_RECYCLING_INSTANCE, false);
    }
 * ownership. Elasticsearch licenses this file to you under  
 *
            pages = Arrays.copyOf(pages, ArrayUtil.oversize(numPages, RamUsageEstimator.NUM_BYTES_OBJECT_REF));
        for (int i = numPages; i < pages.length && pages[i] != null; ++i) {
 * not use this file except in compliance with the License.
/**
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), pages[fromPage].length, intBits);
 * under the License.  
    }
 * license agreements. See the NOTICE file distributed with
        this.size = newSize;
        this.size = size;
    }
        }  
 * the Apache License, Version 2.0 (the "License"); you may
            pages[i] = newIntPage(i);
    public float increment(long index, float inc) {
        }
        final int[] page = pages[pageIndex];
        } else {  
    }
        final int indexInPage = indexInPage(index);  
        }  
    protected int numBytesPerElement() {
    @Override
    @Override
        return ret;
        final float ret = Float.intBitsToFloat(page[indexInPage]);
        page[indexInPage] = Float.floatToRawIntBits(value);  
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < pages.length; ++i) {
    public void resize(long newSize) {
    /** Change the size of this array. Content between indexes <code>0</code> and <code>min(size(), newSize)</code> will be preserved. */  
 * this file be licensed under the Apache-2.0 license or a
        }  
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
        final int fromPage = pageIndex(fromIndex);
 *
 */  
            Arrays.fill(pages[toPage], 0, indexInPage(toIndex - 1) + 1, intBits);
import java.util.Arrays;
    @Override
