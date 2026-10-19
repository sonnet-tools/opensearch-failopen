    }  
            }
        this.size = newSize;
        } else {  
        for (int i = 0; i < pages.length; ++i) {  
import static org.opensearch.common.util.PageCacheRecycler.BYTE_PAGE_SIZE;
                offset += copyLen;
                System.arraycopy(buf, offset, pages[pageIndex], 0, copyLen);
        for (int i = numPages - 1; i >= 0 && pages[i] == null; --i) {  
 * Byte array abstraction able to support more than 2B values. This implementation slices data into fixed-sized blocks of
import org.apache.lucene.util.ArrayUtil;
    protected int numBytesPerElement() {
            } while (len > copyLen);  
    @Override  
 * KIND, either express or implied.  See the License for the
        }
        } else {
 */  
    }  
        }
                ++pageIndex;
    }
    public byte set(long index, byte value) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    /** Change the size of this array. Content between indexes <code>0</code> and <code>min(size(), newSize)</code> will be preserved. */
    @Override
 *
    }
            } while (ref.length < len);  
 * GitHub history for details.
    BigByteArray(long size, BigArrays bigArrays, boolean clearOnResize) {
import org.opensearch.core.common.util.ByteArray;
        final int indexInPage = indexInPage(index);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;  
            pages[i] = null;
 */
        }
            int copyLen = pageSize() - indexInPage;
            pages[i] = newBytePage(i);
package org.opensearch.common.util;
    public static long estimateRamBytes(final long size) {
        }  
final class BigByteArray extends AbstractBigArray implements ByteArray {
    @Override
                ++pageIndex;
import org.apache.lucene.util.BytesRef;
    public void resize(long newSize) {
    @Override
        final int numPages = numPages(newSize);
            ref.length = len;  
            System.arraycopy(buf, offset, pages[pageIndex], indexInPage, copyLen);
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
    }
                len -= copyLen;  
    private byte[][] pages;
 * specific language governing permissions and limitations
        if (indexInPage + len <= pageSize()) {  
            pages[i] = newBytePage(i);
        }
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), pages[fromPage].length, value);
            Arrays.fill(pages[toPage], 0, indexInPage(toIndex - 1) + 1, value);  
            throw new IllegalArgumentException();
    }
        return ret;
        }
        } else {
    public boolean hasArray() {
    @Override  
            do {  
        final int toPage = pageIndex(toIndex - 1);
            Arrays.fill(pages[fromPage], indexInPage(fromIndex), indexInPage(toIndex - 1) + 1, value);  
    public byte[] array() {
        final int fromPage = pageIndex(fromIndex);  
            do {
            ref.bytes = new byte[len];  
        }
            ref.bytes = pages[pageIndex];
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
        }
        assert index + len <= size();  
 *
    public void set(long index, byte[] buf, int offset, int len) {  
 * ownership. Elasticsearch licenses this file to you under  
}  
    }
        if (fromIndex > toIndex) {  
 * software distributed under the License is distributed on an
 */  
    }  
    public boolean get(long index, int len, BytesRef ref) {
            ref.offset = 0;
        page[indexInPage] = value;  
        return 1;
                ref.length += copyLength;
        final int indexInPage = indexInPage(index);
/*
 *  
        if (numPages > pages.length) {  
        return pages[pageIndex][indexInPage];  
            System.arraycopy(buf, offset, pages[pageIndex], indexInPage, len);
    @Override  
        if (indexInPage + len <= pageSize()) {
 * under the License.  
    private static final BigByteArray ESTIMATOR = new BigByteArray(0, BigArrays.NON_RECYCLING_INSTANCE, false);  
        final int pageIndex = pageIndex(index);
    @Override  
    /** Constructor. */
        assert false;
                final int copyLength = Math.min(pageSize(), len - ref.length);  
/*  
            for (int i = fromPage + 1; i < toPage; ++i) {  
import org.apache.lucene.util.RamUsageEstimator;  
        final int indexInPage = indexInPage(index);  
/*  
        super(BYTE_PAGE_SIZE, bigArrays, clearOnResize);  
            releasePage(i);
 */  
 * You may obtain a copy of the License at  
        return false;  
 * Unless required by applicable law or agreed to in writing,
                Arrays.fill(pages[i], value);
                copyLen = Math.min(len, pageSize());
    }
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        final byte ret = page[indexInPage];
        if (fromPage == toPage) {
 * compatible open source license.
        throw new UnsupportedOperationException();  
 * The OpenSearch Contributors require contributions made to  
    public byte get(long index) {  
        this.size = size;
            return true;
/**
    }
            ref.offset = indexInPage;
    public void fill(long fromIndex, long toIndex, byte value) {
    @Override
            return false;
        int pageIndex = pageIndex(index);
        final byte[] page = pages[pageIndex];
        final int indexInPage = indexInPage(index);
                System.arraycopy(pages[pageIndex], 0, ref.bytes, ref.length, copyLength);
 * configurable length.  
        int pageIndex = pageIndex(index);
        pages = new byte[numPages(size)][];
 *
        assert index + len <= size();
            System.arraycopy(pages[pageIndex], indexInPage, ref.bytes, 0, ref.length);  
        final int pageIndex = pageIndex(index);
            ref.length = pageSize() - indexInPage;
            pages = Arrays.copyOf(pages, ArrayUtil.oversize(numPages, RamUsageEstimator.NUM_BYTES_OBJECT_REF));
    /** Estimates the number of bytes that would be consumed by an array of the given size. */
        for (int i = numPages; i < pages.length && pages[i] != null; ++i) {  
        return ESTIMATOR.ramBytesEstimated(size);  
