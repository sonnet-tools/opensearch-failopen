    }
 *
        return ESTIMATOR.ramBytesEstimated(size);
 * Int array abstraction able to support more than 2B values. This implementation slices data into fixed-sized blocks of  
    private static final BigObjectArray<Long> ESTIMATOR = new BigObjectArray<Long>(0, BigArrays.NON_RECYCLING_INSTANCE);
/**
 * compatible open source license.
        @SuppressWarnings("unchecked")
    protected int numBytesPerElement() {
    /** Constructor. */
        if (numPages > pages.length) {
        final int indexInPage = indexInPage(index);
    public static long estimateRamBytes(final long size) {  
 * configurable length.
        }  
    @Override
        }  
 * this work for additional information regarding copyright
        pages = new Object[numPages(size)][];  
    }  
        this.size = newSize;
 */  
            releasePage(i);  
    }
import java.util.Arrays;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
import static org.opensearch.common.util.PageCacheRecycler.OBJECT_PAGE_SIZE;  
        }
        final int pageIndex = pageIndex(index);
            pages[i] = newObjectPage(i);
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.RamUsageEstimator;
 */  
            pages[i] = null;
        this.size = size;
        final int indexInPage = indexInPage(index);
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        return Integer.BYTES;  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < pages.length; ++i) {
    }
 * The OpenSearch Contributors require contributions made to  
}
        super(OBJECT_PAGE_SIZE, bigArrays, true);
 * KIND, either express or implied.  See the License for the
 */
        page[indexInPage] = value;  
/*  
 * software distributed under the License is distributed on an
    }
        return (T) pages[pageIndex][indexInPage];
 *
        }  
 *  
        for (int i = numPages; i < pages.length && pages[i] != null; ++i) {
 * You may obtain a copy of the License at  
final class BigObjectArray<T> extends AbstractBigArray implements ObjectArray<T> {
    public T set(long index, T value) {  
    @Override
        for (int i = numPages - 1; i >= 0 && pages[i] == null; --i) {
        final int pageIndex = pageIndex(index);  
    BigObjectArray(long size, BigArrays bigArrays) {  
/*
            pages = Arrays.copyOf(pages, ArrayUtil.oversize(numPages, RamUsageEstimator.NUM_BYTES_OBJECT_REF));
    public T get(long index) {
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void resize(long newSize) {
        final int numPages = numPages(newSize);  
            pages[i] = newObjectPage(i);
    /** Estimates the number of bytes that would be consumed by an array of the given size. */
package org.opensearch.common.util;
 * not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    @Override
    }  
    /** Change the size of this array. Content between indexes <code>0</code> and <code>min(size(), newSize)</code> will be preserved. */  
        final T ret = (T) page[indexInPage];
    @SuppressWarnings("unchecked")  
 */
        final Object[] page = pages[pageIndex];  
 * GitHub history for details.
        return ret;
    private Object[][] pages;  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.util.ArrayUtil;
