            pages.removeFirst().close();
        firstBuffer.position(firstBuffer.position() + offset);
        long indexWithOffset = to + offset;
        int finalLimit = indexInPage(indexWithOffset);
            while ((page = pages.pollFirst()) != null) {
    }
        return (int) (index >>> PAGE_SHIFT);
                "can't slice a channel buffer with capacity [" + capacity + "], with slice parameters from [" + from + "]"
        ByteBuffer firstBuffer = firstPage.byteBuffer();
        return internalIndex;
        Page firstPage = pageIterator.next().duplicate();
        }
/**
 *
    public void ensureCapacity(long requiredCapacity) {
        Iterator<Page> pageIterator = pages.iterator();
        }
/*
    /**
        int finalLimit = indexInPage(indexWithOffset);
                    + capacity
     */
    /**
        }
    }
 * This is a channel byte buffer composed internally of 16kb pages. When an entire message has been read
 *
import java.util.List;
        }
     * modifications to the markers {@link ByteBuffer#position()}, {@link ByteBuffer#limit()}, etc will not
    private static final int PAGE_SHIFT = Integer.numberOfTrailingZeros(PAGE_SIZE);
                "Cannot increment an index ["
    }
        }
                "can't slice a channel buffer with capacity [" + capacity + "], with slice parameters to [" + to + "]"
     *
        int indexInPage = indexInPage(indexWithOffset);
 * under the License.
            throw new IllegalStateException("Cannot allocate new pages if the buffer is closed.");
    }
        internalIndex = newIndex;
        return pages;
 */
import java.nio.ByteBuffer;
            );
                    + "] that is greater than the capacity ["
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
            buffers[buffers.length - 1].limit(finalLimit);
                    + delta
     * @param bytesToRelease number of bytes to drop
    public long getCapacity() {
            Page page;
    private int offset = 0;
        buffers[0] = firstPostIndexBuffer;
        if (newIndex > capacity) {
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
 * The OpenSearch Contributors require contributions made to
    public Page[] sliceAndRetainPagesTo(long to) {
        int pagesToRelease = pageIndex(offset + bytesToRelease);
        final long numPages = (capacity + PAGE_MASK) >>> PAGE_SHIFT;
            return EMPTY_BYTE_BUFFER_ARRAY;
            throw new IllegalArgumentException(
 * this work for additional information regarding copyright
            throw new IndexOutOfBoundsException(
        capacity -= bytesToRelease;
        ByteBuffer[] buffers = new ByteBuffer[pageCount];
        Iterator<Page> pageIterator = this.pages.iterator();
            pages[pages.length - 1].byteBuffer().limit(finalLimit);
        if (from > capacity) {
 * not use this file except in compliance with the License.
     * @param to the index to slice up to
        }
 */
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
 * ownership. Elasticsearch licenses this file to you under
     * modify the this class.
            );
    @Override
    private static final int PAGE_MASK = PAGE_SIZE - 1;
        offset = indexInPage(bytesToRelease + offset);
            ExceptionsHelper.rethrowAndSuppress(closingExceptions);
    private final ArrayDeque<Page> pages = new ArrayDeque<>();
    // The offset is an int as it is the offset of where the bytes begin in the first buffer
 * the Apache License, Version 2.0 (the "License"); you may
        }
import java.util.function.IntFunction;
    public void release(long bytesToRelease) {
        int pageCount = pageIndex(indexWithOffset);
        return buffers;
    }
    private final IntFunction<Page> pageAllocator;
     * retain the underlying pages, so the pages returned by this method must be closed.
        if (finalLimit != 0) {
 * be called and the buffer will expand using the supplier provided.
     */
            int pagesToAdd = numPages - pages.size();
     * {@link ByteBuffer#limit()}, etc will not modify the this class. Additionally, this will internally
    public void incrementIndex(long delta) {
        Iterator<Page> pageIterator = pages.descendingIterator();
 * SPDX-License-Identifier: Apache-2.0
        int pageCount = pageIndex(indexWithOffset);
import org.opensearch.nio.utils.ExceptionsHelper;
            }
     * This method will return an array of {@link Page} representing the bytes from the beginning of
                    closingExceptions.add(e);
            return EMPTY_BYTE_PAGE_ARRAY;
            throw new IllegalArgumentException("Cannot increment an index with a negative delta [" + delta + "]");
        if (numPages > Integer.MAX_VALUE) {
    private int indexInPage(long index) {
    }
 * license agreements. See the NOTICE file distributed with
            for (int i = 0; i < pagesToAdd; i++) {
            pageCount += 1;
 * You may obtain a copy of the License at
    public long getRemaining() {
    }
    }
        internalIndex = Math.max(internalIndex - bytesToRelease, 0);
        for (int i = buffers.length - 1; i > 0; --i) {
    }
        return (int) (index & PAGE_MASK);
            pageCount += 1;
            buffers[i] = pageIterator.next().byteBuffer().duplicate();
    public InboundChannelBuffer(IntFunction<Page> pageAllocator) {
        if (to > capacity) {
    public long getIndex() {
        for (int i = 1; i < pages.length; i++) {
    }
        }
public final class InboundChannelBuffer implements AutoCloseable {
     * @return the byte buffers
    public static final int PAGE_SIZE = 1 << 14;
    private int pageIndex(long index) {
            return EMPTY_BYTE_BUFFER_ARRAY;
        this.pageAllocator = pageAllocator;
 */
 * Unless required by applicable law or agreed to in writing,
    }
        }
                try {
        }
            throw new IllegalArgumentException("pageSize=" + (PAGE_MASK + 1) + " is too small for such as capacity: " + capacity);
 * specific language governing permissions and limitations
        } else if (from == capacity) {
        ByteBuffer firstPostIndexBuffer = pageIterator.next().byteBuffer().duplicate();
        if (finalLimit != 0) {
        if (isClosed.compareAndSet(false, true)) {
        pages[0] = firstPage;
        if (finalLimit != 0) {
        ByteBuffer[] buffers = new ByteBuffer[pages.size() - pageIndex];
     */
     * this buffer up through the index argument that was passed. The pages and buffers will be duplicates of
        return buffers;
            throw new IllegalArgumentException("Releasing more bytes [" + bytesToRelease + "] than buffer capacity [" + capacity + "].");
            buffers[i] = pageIterator.next().byteBuffer().duplicate();
        long remaining = capacity - internalIndex;
 * KIND, either express or implied.  See the License for the
            );
                pages.addLast(page);
     * @param from the index to slice from
        long indexWithOffset = from + offset;
    }
        int pageIndex = pageIndex(indexWithOffset);
     * the internal components, so any modifications to the markers {@link ByteBuffer#position()},
            int numPages = numPages(requiredCapacity + offset);
 * and consumed, the {@link #release(long)} method releases the bytes from the head of the buffer and closes
     */
    private long capacity = 0;
        if (isClosed.get()) {
import java.util.Iterator;
        if (to > capacity) {
        ByteBuffer firstBuffer = pageIterator.next().byteBuffer().duplicate();
        for (int i = 0; i < pagesToRelease; i++) {
    public static InboundChannelBuffer allocatingInstance() {
            throw new IndexOutOfBoundsException(
        }
import java.util.ArrayList;
     *
        Page[] pages = new Page[pageCount];
            }
/*
        }
                    + "] that will result in a new index ["
        return new InboundChannelBuffer((n) -> new Page(ByteBuffer.allocate(n), () -> {}));
        return capacity;
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param to the index to slice up to
        buffers[0] = firstBuffer;
                    + newIndex
     * @return the byte buffers
                }
    private static final Page[] EMPTY_BYTE_PAGE_ARRAY = new Page[0];
 *
        } else if (to == 0) {
            List<RuntimeException> closingExceptions = new ArrayList<>();
    private static final ByteBuffer[] EMPTY_BYTE_BUFFER_ARRAY = new ByteBuffer[0];
        if (finalLimit != 0) {
        if (capacity < requiredCapacity) {
        long newIndex = delta + internalIndex;
        }
            );
            throw new IndexOutOfBoundsException(
        }
     * index the index is truncated to zero.
     * this buffer up through the index argument that was passed. The buffers will be duplicates of the
 * compatible open source license.
                    + internalIndex
package org.opensearch.nio;
import java.util.ArrayDeque;
     * This method will release bytes from the head of this buffer. If you release bytes past the current
 * software distributed under the License is distributed on an
        return (int) numPages;
     * @return the pages
    private int numPages(long capacity) {
     *
 * this file be licensed under the Apache-2.0 license or a
                    + "]."
        }
        if (delta < 0) {
    public ByteBuffer[] sliceBuffersTo(long to) {
 * the pages internally. If more space is needed at the end of the buffer {@link #ensureCapacity(long)} can
                "can't slice a channel buffer with capacity [" + capacity + "], with slice parameters to [" + to + "]"
    public ByteBuffer[] sliceBuffersFrom(long from) {
        if (bytesToRelease > capacity) {
        firstBuffer.position(firstBuffer.position() + offset);
                    page.close();
 */
import java.util.concurrent.atomic.AtomicBoolean;
    }
        }
        }
     * This method will return an array of {@link ByteBuffer} representing the bytes from the beginning of
    private long internalIndex = 0;
        firstPostIndexBuffer.position(firstPostIndexBuffer.position() + indexInPage);
     * internal buffers, so any modifications to the markers {@link ByteBuffer#position()},
                } catch (RuntimeException e) {
        assert remaining >= 0 : "The remaining [" + remaining + "] number of bytes should not be less than zero.";
        }
     * This method will return an array of {@link ByteBuffer} representing the bytes from the index passed
        return remaining;
    }
     * through the end of this buffer. The buffers will be duplicates of the internal buffers, so any
 * Modifications Copyright OpenSearch Contributors. See
                    + "] with a delta ["
    }
    /**
    public void close() {
        } else if (to == 0) {
     *
            capacity += pagesToAdd * PAGE_SIZE;
     * {@link ByteBuffer#limit()}, etc will not modify the this class.
            pages[i] = pageIterator.next().duplicate();
        long indexWithOffset = to + offset;
        for (int i = 1; i < buffers.length; i++) {
                Page page = pageAllocator.apply(PAGE_SIZE);
/*
