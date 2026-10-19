    public static long estimateRamBytes(final long size) {
 * KIND, either express or implied.  See the License for the
            }
    }
    public long set(long index, long value) {
        super(LONG_PAGE_SIZE, bigArrays, clearOnResize);
 */
 */  
    }
            for (int i = fromPage + 1; i < toPage; ++i) {  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * The OpenSearch Contributors require contributions made to  
 *  
        this.size = newSize;
 * license agreements. See the NOTICE file distributed with
        final long[] page = pages[pageIndex];
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new IllegalArgumentException();
        return ret;
        }
        if (fromPage == toPage) {
 * this file be licensed under the Apache-2.0 license or a
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), indexInPage(toIndex - 1) + 1, value);  
    @Override
        }
        for (int i = numPages; i < pages.length && pages[i] != null; ++i) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.ArrayUtil;
 */  
 * configurable length.
/*
    protected int numBytesPerElement() {
 * ownership. Elasticsearch licenses this file to you under  
        if (fromIndex == toIndex) {  
        }  
    }  
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), pages[fromPage].length, value);
        if (numPages > pages.length) {  
    }  
        page[indexInPage] = value;
        return pages[pageIndex][indexInPage];
    }
 * Unless required by applicable law or agreed to in writing,
        pages = new long[numPages(size)][];  
 */
import static org.opensearch.common.util.PageCacheRecycler.LONG_PAGE_SIZE;  
            pages[i] = null;
            pages[i] = newLongPage(i);
import org.apache.lucene.util.RamUsageEstimator;
 * GitHub history for details.
/**
        final int pageIndex = pageIndex(index);
            pages = Arrays.copyOf(pages, ArrayUtil.oversize(numPages, RamUsageEstimator.NUM_BYTES_OBJECT_REF));
    @Override  
 * You may obtain a copy of the License at  
        return pages[pageIndex][indexInPage] += inc;  
    /** Constructor. */
    @Override
        final int indexInPage = indexInPage(index);
        final int pageIndex = pageIndex(index);
        for (int i = numPages - 1; i >= 0 && pages[i] == null; --i) {  
    private static final BigLongArray ESTIMATOR = new BigLongArray(0, BigArrays.NON_RECYCLING_INSTANCE, false);
 * this work for additional information regarding copyright
 *
 * Long array abstraction able to support more than 2B values. This implementation slices data into fixed-sized blocks of  
    /** Change the size of this array. Content between indexes <code>0</code> and <code>min(size(), newSize)</code> will be preserved. */
/*  
package org.opensearch.common.util;
    private long[][] pages;  
 * compatible open source license.
        final int indexInPage = indexInPage(index);
    public void resize(long newSize) {
        } else {
        final int indexInPage = indexInPage(index);  
import java.util.Arrays;
        }
            releasePage(i);
 * Modifications Copyright OpenSearch Contributors. See
    public long get(long index) {
    BigLongArray(long size, BigArrays bigArrays, boolean clearOnResize) {  
        return ESTIMATOR.ramBytesEstimated(size);  
    public void fill(long fromIndex, long toIndex, long value) {
        final int pageIndex = pageIndex(index);  
 *
        }  
 * not use this file except in compliance with the License.
        }
            return; // empty range
final class BigLongArray extends AbstractBigArray implements LongArray {
    }
        }
    /** Estimates the number of bytes that would be consumed by an array of the given size. */
 * specific language governing permissions and limitations
    public long increment(long index, long inc) {  
    @Override  
        if (fromIndex > toIndex) {  
            pages[i] = newLongPage(i);
 *
        for (int i = 0; i < pages.length; ++i) {
 * under the License.  
                Arrays.fill(pages[i], value);
        this.size = size;
    @Override
        final int numPages = numPages(newSize);
 * SPDX-License-Identifier: Apache-2.0
            Arrays.fill(pages[toPage], 0, indexInPage(toIndex - 1) + 1, value);  
    }
        final long ret = page[indexInPage];  
        final int toPage = pageIndex(toIndex - 1);
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        final int fromPage = pageIndex(fromIndex);  
}  
/*  
    }
 * @opensearch.internal  
        return Long.BYTES;
