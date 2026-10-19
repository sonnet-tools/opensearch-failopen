            throw new IndexOutOfBoundsException(
        return capacity;  
    }
        int pageCount = pageIndex(indexWithOffset);  
     * @return the byte buffers
 * This is a channel byte buffer composed internally of 16kb pages. When an entire message has been read  
        return pages;
    @Override  
            buffers[i] = pageIterator.next().byteBuffer().duplicate();  
        }
    public static final int PAGE_SIZE = 1 << 14;
        capacity -= bytesToRelease;
                pages.addLast(page);
                    + "] that will result in a new index ["  
     * retain the underlying pages, so the pages returned by this method must be closed.
    }
 * the pages internally. If more space is needed at the end of the buffer {@link #ensureCapacity(long)} can
 * GitHub history for details.
                    + "]."
        firstBuffer.position(firstBuffer.position() + offset);  
     * index the index is truncated to zero.  
            pages.removeFirst().close();
    }
                "can't slice a channel buffer with capacity [" + capacity + "], with slice parameters to [" + to + "]"
                }
        for (int i = 1; i < buffers.length; i++) {
                    page.close();
        if (isClosed.compareAndSet(false, true)) {
/**
import java.nio.ByteBuffer;  
        }
    public long getCapacity() {
        int finalLimit = indexInPage(indexWithOffset);
        if (isClosed.get()) {
            buffers[i] = pageIterator.next().byteBuffer().duplicate();  
            return EMPTY_BYTE_PAGE_ARRAY;
        pages[0] = firstPage;  
    public ByteBuffer[] sliceBuffersFrom(long from) {
        }  
        if (finalLimit != 0) {
        } else if (to == 0) {
        buffers[0] = firstBuffer;
                    + "] with a delta ["
 * You may obtain a copy of the License at  
    private static final int PAGE_MASK = PAGE_SIZE - 1;
import java.util.Iterator;  
                "can't slice a channel buffer with capacity [" + capacity + "], with slice parameters to [" + to + "]"  
        offset = indexInPage(bytesToRelease + offset);  
        return (int) (index >>> PAGE_SHIFT);  
    public Page[] sliceAndRetainPagesTo(long to) {
            throw new IllegalStateException("Cannot allocate new pages if the buffer is closed.");  
        if (to > capacity) {
        }
    }
    private static final int PAGE_SHIFT = Integer.numberOfTrailingZeros(PAGE_SIZE);  
    private final AtomicBoolean isClosed = new AtomicBoolean(false);  
    public void incrementIndex(long delta) {  
            );
        int pageIndex = pageIndex(indexWithOffset);  
    private final ArrayDeque<Page> pages = new ArrayDeque<>();
 * software distributed under the License is distributed on an
import java.util.List;
/*
    }  
     * @param from the index to slice from
            int numPages = numPages(requiredCapacity + offset);  
     * this buffer up through the index argument that was passed. The buffers will be duplicates of the
     * modify the this class.  
        long remaining = capacity - internalIndex;
 * license agreements. See the NOTICE file distributed with
    /**
 * be called and the buffer will expand using the supplier provided.  
    /**
        internalIndex = Math.max(internalIndex - bytesToRelease, 0);
import java.util.concurrent.atomic.AtomicBoolean;
     * This method will return an array of {@link Page} representing the bytes from the beginning of
        buffers[0] = firstPostIndexBuffer;
                    + delta
    private static final ByteBuffer[] EMPTY_BYTE_BUFFER_ARRAY = new ByteBuffer[0];
 * The OpenSearch Contributors require contributions made to  
    public InboundChannelBuffer(IntFunction<Page> pageAllocator) {
                try {  
import java.util.ArrayDeque;
import org.opensearch.nio.utils.ExceptionsHelper;
            int pagesToAdd = numPages - pages.size();
     */
                    + newIndex
        for (int i = 0; i < pagesToRelease; i++) {
        ByteBuffer firstBuffer = firstPage.byteBuffer();
        for (int i = buffers.length - 1; i > 0; --i) {
        }
    }  
            throw new IllegalArgumentException("Releasing more bytes [" + bytesToRelease + "] than buffer capacity [" + capacity + "].");  
        if (numPages > Integer.MAX_VALUE) {
    public long getIndex() {
     *  
        int finalLimit = indexInPage(indexWithOffset);
 *
     * internal buffers, so any modifications to the markers {@link ByteBuffer#position()},  
        } else if (to == 0) {  
            return EMPTY_BYTE_BUFFER_ARRAY;  
            buffers[buffers.length - 1].limit(finalLimit);  
        final long numPages = (capacity + PAGE_MASK) >>> PAGE_SHIFT;
            );
    /**  
        }
        }
        Page[] pages = new Page[pageCount];
        long newIndex = delta + internalIndex;
        }  
     */  
        if (finalLimit != 0) {
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
        }
        ByteBuffer[] buffers = new ByteBuffer[pages.size() - pageIndex];  
    }
            capacity += pagesToAdd * PAGE_SIZE;  
            );  
/*  
        if (bytesToRelease > capacity) {
 * Unless required by applicable law or agreed to in writing,
            return EMPTY_BYTE_BUFFER_ARRAY;
            throw new IllegalArgumentException("pageSize=" + (PAGE_MASK + 1) + " is too small for such as capacity: " + capacity);  
            }
        if (delta < 0) {
import java.util.ArrayList;
 */
            );
     * this buffer up through the index argument that was passed. The pages and buffers will be duplicates of
 * and consumed, the {@link #release(long)} method releases the bytes from the head of the buffer and closes
     * {@link ByteBuffer#limit()}, etc will not modify the this class.
                "can't slice a channel buffer with capacity [" + capacity + "], with slice parameters from [" + from + "]"
/*  
    }
import java.util.function.IntFunction;  
        }
            }
        this.pageAllocator = pageAllocator;
        }
        return (int) (index & PAGE_MASK);
     * @return the pages
        long indexWithOffset = from + offset;
        firstBuffer.position(firstBuffer.position() + offset);
     * modifications to the markers {@link ByteBuffer#position()}, {@link ByteBuffer#limit()}, etc will not
        assert remaining >= 0 : "The remaining [" + remaining + "] number of bytes should not be less than zero.";
     *
    private int offset = 0;
 */  
    }
        }  
            while ((page = pages.pollFirst()) != null) {
        return buffers;  
    private long capacity = 0;
    }
    private int indexInPage(long index) {  
                    + capacity  
            throw new IndexOutOfBoundsException(  
        }  
            ExceptionsHelper.rethrowAndSuppress(closingExceptions);  
        }
    }  
 * compatible open source license.
     * This method will release bytes from the head of this buffer. If you release bytes past the current
        if (newIndex > capacity) {  
package org.opensearch.nio;
        if (finalLimit != 0) {
        } else if (from == capacity) {
     *
}  
                Page page = pageAllocator.apply(PAGE_SIZE);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return remaining;  
        Iterator<Page> pageIterator = this.pages.iterator();
        firstPostIndexBuffer.position(firstPostIndexBuffer.position() + indexInPage);  
    public long getRemaining() {  
     * through the end of this buffer. The buffers will be duplicates of the internal buffers, so any
     * This method will return an array of {@link ByteBuffer} representing the bytes from the beginning of
            List<RuntimeException> closingExceptions = new ArrayList<>();
    public void release(long bytesToRelease) {
        int indexInPage = indexInPage(indexWithOffset);
 * under the License.  
    private int numPages(long capacity) {  
 * specific language governing permissions and limitations
        return (int) numPages;
            for (int i = 0; i < pagesToAdd; i++) {
     * the internal components, so any modifications to the markers {@link ByteBuffer#position()},  
            pageCount += 1;  
        }  
        if (capacity < requiredCapacity) {
 * this work for additional information regarding copyright
    }  
            throw new IndexOutOfBoundsException(
 * not use this file except in compliance with the License.
        }
        return new InboundChannelBuffer((n) -> new Page(ByteBuffer.allocate(n), () -> {}));  
    public void close() {
        for (int i = 1; i < pages.length; i++) {
        Page firstPage = pageIterator.next().duplicate();  
            pages[pages.length - 1].byteBuffer().limit(finalLimit);
 * KIND, either express or implied.  See the License for the
    }
        if (to > capacity) {
 * SPDX-License-Identifier: Apache-2.0
     *
        Iterator<Page> pageIterator = pages.iterator();
            pages[i] = pageIterator.next().duplicate();
 * ownership. Elasticsearch licenses this file to you under  
            throw new IllegalArgumentException(
        int pagesToRelease = pageIndex(offset + bytesToRelease);  
            Page page;  
        int pageCount = pageIndex(indexWithOffset);
     * @return the byte buffers  
     * @param bytesToRelease number of bytes to drop
    /**  
        long indexWithOffset = to + offset;
    public ByteBuffer[] sliceBuffersTo(long to) {  
 *  
     * @param to the index to slice up to
                    closingExceptions.add(e);  
    }
        long indexWithOffset = to + offset;  
     * This method will return an array of {@link ByteBuffer} representing the bytes from the index passed  
     * {@link ByteBuffer#limit()}, etc will not modify the this class. Additionally, this will internally
        internalIndex = newIndex;
 * the Apache License, Version 2.0 (the "License"); you may
        }  
            throw new IllegalArgumentException("Cannot increment an index with a negative delta [" + delta + "]");
    private long internalIndex = 0;  
        return buffers;  
    private final IntFunction<Page> pageAllocator;
    private int pageIndex(long index) {
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 */
     * @param to the index to slice up to  
    private static final Page[] EMPTY_BYTE_PAGE_ARRAY = new Page[0];
        return internalIndex;
        }
     */
    public static InboundChannelBuffer allocatingInstance() {
                    + internalIndex  
        if (from > capacity) {  
        ByteBuffer[] buffers = new ByteBuffer[pageCount];  
                "Cannot increment an index ["
 * Modifications Copyright OpenSearch Contributors. See
    }
                } catch (RuntimeException e) {
        ByteBuffer firstPostIndexBuffer = pageIterator.next().byteBuffer().duplicate();
    // The offset is an int as it is the offset of where the bytes begin in the first buffer
                    + "] that is greater than the capacity ["
        ByteBuffer firstBuffer = pageIterator.next().byteBuffer().duplicate();
 *
        if (finalLimit != 0) {  
    public void ensureCapacity(long requiredCapacity) {
        Iterator<Page> pageIterator = pages.descendingIterator();
 */  
public final class InboundChannelBuffer implements AutoCloseable {
            pageCount += 1;
