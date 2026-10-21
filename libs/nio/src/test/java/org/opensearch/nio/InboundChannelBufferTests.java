        assertEquals(8, channelBuffer.getIndex());
 * under the License.
        assertEquals(0, channelBuffer.getRemaining());
        };
 * not use this file except in compliance with the License.
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(defaultPageAllocator);
            assertEquals(indexIncremented - bytesReleased, channelBuffer.getIndex());
 * the Apache License, Version 2.0 (the "License"); you may
        int indexIncremented = 0;
        };
    }
            if (i < 1) {
        assertEquals(InboundChannelBuffer.PAGE_SIZE - offset, channelBuffer.getRemaining());
 */
        IntFunction<Page> allocator = (n) -> {
            ++i;
        assertEquals(InboundChannelBuffer.PAGE_SIZE, channelBuffer.getRemaining());
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
        assertEquals(InboundChannelBuffer.PAGE_SIZE - offset, channelBuffer.getCapacity());
 * software distributed under the License is distributed on an
 */
    public void testClose() {
        for (AtomicBoolean closedRef : queue) {
        assertEquals(InboundChannelBuffer.PAGE_SIZE, channelBuffer.getRemaining());
import java.util.concurrent.ConcurrentLinkedQueue;
        channelBuffer.release(2);
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(defaultPageAllocator);
                buffer.put((byte) (i++ % 127));
            assertTrue(closedRef.get());
            assertFalse(closedRef.get());
 * license agreements. See the NOTICE file distributed with
        }
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE * 4);
    public void testAccessByteBuffers() {
    @Override
    public void testNewBufferNoPages() {
            assertFalse(closedRef.get());
            if (randomBoolean()) {
            ByteBuffer[] postIndexBuffers2 = channelBuffer.sliceBuffersFrom(channelBuffer.getIndex());
            while (buffer.hasRemaining()) {
                bytesReleased += (int) bytesToRelease;
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(defaultPageAllocator);
        assertEquals(0, channelBuffer.getIndex());
        channelBuffer.release(10);
    }
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE + ((multiple * InboundChannelBuffer.PAGE_SIZE) - randomInt(500)));
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0, channelBuffer.getCapacity());
    public void testExpandCapacity() {
 * The OpenSearch Contributors require contributions made to
        channelBuffer.close();
                channelBuffer.release(bytesToRelease);
        assertEquals(4, queue.size());
 *
                assertEquals((byte) ((channelBuffer.getIndex() + bytesReleased - 1) % 127), preIndexBuffer.get(preIndexBuffer.limit() - 1));
    public void testReleaseClosesPages() {
        assertEquals(0, channelBuffer.getIndex());
        int pages = randomInt(50) + 5;
            }
        IntFunction<Page> allocator = (n) -> {
        assertEquals(InboundChannelBuffer.PAGE_SIZE * (multiple + 1), channelBuffer.getRemaining());
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE);
    }
    public void testIncrementIndexWithOffset() {
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(0, channelBuffer.sliceBuffersFrom(channelBuffer.getIndex()).length);
        for (AtomicBoolean closedRef : queue) {
            assertFalse(closedRef.get());
        expectThrows(IllegalStateException.class, () -> channelBuffer.ensureCapacity(1));
        channelBuffer.release(2 * InboundChannelBuffer.PAGE_SIZE);
 */
        assertEquals(InboundChannelBuffer.PAGE_SIZE, channelBuffer.getCapacity());
    public void testCloseRetainedPages() {
        long capacity = channelBuffer.getCapacity();
        ConcurrentLinkedQueue<AtomicBoolean> queue = new ConcurrentLinkedQueue<>();
            assertTrue(closedRef.get());
        while (indexIncremented < capacity) {
        int i = 0;
        pages[1].close();
            return new Page(ByteBuffer.allocate(n), () -> atomicBoolean.set(true));
            } else {
/*
    }
}
        assertEquals(InboundChannelBuffer.PAGE_SIZE - 10, channelBuffer.getRemaining());
        ByteBuffer[] postIndexBuffers = channelBuffer.sliceBuffersFrom(channelBuffer.getIndex());
 * this file be licensed under the Apache-2.0 license or a
        }
        channelBuffer.incrementIndex(10);
            return new Page(ByteBuffer.allocate(n), () -> atomicBoolean.set(true));
        assertEquals(10, channelBuffer.getIndex());
        pages[0].close();
 * Unless required by applicable law or agreed to in writing,
            }
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE);
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(defaultPageAllocator);
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE * 4);
        IntFunction<Page> allocator = (n) -> {
            indexIncremented += (int) amountToInc;
            return new Page(ByteBuffer.allocate(n), () -> atomicBoolean.set(true));
        assertEquals(InboundChannelBuffer.PAGE_SIZE * 2 - offset, channelBuffer.getRemaining());
 * KIND, either express or implied.  See the License for the
    }
        assertEquals(InboundChannelBuffer.PAGE_SIZE, channelBuffer.getCapacity());
        int i = 0;
        assertEquals(InboundChannelBuffer.PAGE_SIZE * (multiple + 1), channelBuffer.getCapacity());
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(queue.poll().get());
        channelBuffer.close();
        }
        for (AtomicBoolean closedRef : queue) {
            if (preIndexBuffers.length > 0) {
        }
            assertFalse(closedRef.get());
/*
        assertEquals(InboundChannelBuffer.PAGE_SIZE, channelBuffer.getRemaining());
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean();
        }
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE + 1);
    public void testIncrementIndex() {
        assertEquals(InboundChannelBuffer.PAGE_SIZE - 10, channelBuffer.getRemaining());
        assertFalse(queue.poll().get());
        assertEquals(0, channelBuffer.getCapacity());
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(allocator);
 *
        }
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(defaultPageAllocator);
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(defaultPageAllocator);
        assertEquals(InboundChannelBuffer.PAGE_SIZE, channelBuffer.getRemaining());
        channelBuffer.incrementIndex(10);
        assertEquals(InboundChannelBuffer.PAGE_SIZE - 20, channelBuffer.getRemaining());
        defaultPageAllocator = (n) -> new Page(ByteBuffer.allocate(n), () -> {});
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE);
                ByteBuffer preIndexBuffer = preIndexBuffers[preIndexBuffers.length - 1];
            assertEquals((byte) ((channelBuffer.getIndex() + bytesReleased) % 127), postIndexBuffers2[0].get());
/*
        assertEquals(0, channelBuffer.getRemaining());
    }
    public void testExpandCapacityRespectsOffset() {
        for (ByteBuffer buffer : postIndexBuffers) {
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(allocator);
    }
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE);
    }
    }
 *
            AtomicBoolean atomicBoolean = new AtomicBoolean();
        assertEquals(InboundChannelBuffer.PAGE_SIZE * 2, channelBuffer.getCapacity());
 * You may obtain a copy of the License at
            long amountToInc = Math.min(randomInt(2000), channelBuffer.getRemaining());
        ConcurrentLinkedQueue<AtomicBoolean> queue = new ConcurrentLinkedQueue<>();
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE);
        for (AtomicBoolean closedRef : queue) {
            }
        assertEquals(InboundChannelBuffer.PAGE_SIZE * 4, channelBuffer.getCapacity());
        };
        for (AtomicBoolean closedRef : queue) {
        channelBuffer.ensureCapacity(pages * InboundChannelBuffer.PAGE_SIZE);
        assertEquals(4, queue.size());
        ConcurrentLinkedQueue<AtomicBoolean> queue = new ConcurrentLinkedQueue<>();
    public void testExpandCapacityMultiplePages() {
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(defaultPageAllocator);
 * SPDX-License-Identifier: Apache-2.0
public class InboundChannelBufferTests extends OpenSearchTestCase {
    private IntFunction<Page> defaultPageAllocator;
 * Licensed to Elasticsearch under one or more contributor
        InboundChannelBuffer channelBuffer = new InboundChannelBuffer(allocator);
        super.setUp();
                assertTrue(closedRef.get());
        assertTrue(queue.poll().get());
        assertTrue(queue.poll().get());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            queue.add(atomicBoolean);
        Page[] pages = channelBuffer.sliceAndRetainPagesTo(InboundChannelBuffer.PAGE_SIZE * 2);
        }
            channelBuffer.incrementIndex(amountToInc);
        int bytesReleased = 0;
            queue.add(atomicBoolean);
    }
                assertFalse(closedRef.get());
    public void setUp() throws Exception {
        assertEquals(0, channelBuffer.getIndex());
        channelBuffer.release(offset);
        assertEquals(InboundChannelBuffer.PAGE_SIZE - 20, channelBuffer.getRemaining());
        assertEquals(10, channelBuffer.getIndex());
 * specific language governing permissions and limitations
            queue.add(atomicBoolean);
        }
        assertEquals(InboundChannelBuffer.PAGE_SIZE * 2 - offset, channelBuffer.getCapacity());
import java.util.concurrent.atomic.AtomicBoolean;
                long bytesToRelease = Math.min(randomInt(50), channelBuffer.getIndex());
 * compatible open source license.
        assertEquals(4, queue.size());
            AtomicBoolean atomicBoolean = new AtomicBoolean();
 * GitHub history for details.
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE * 4);
        channelBuffer.ensureCapacity(InboundChannelBuffer.PAGE_SIZE + 1);
package org.opensearch.nio;
        int offset = randomInt(300);
        }
        int multiple = randomInt(80);
        assertEquals(InboundChannelBuffer.PAGE_SIZE * 2, channelBuffer.getCapacity());
    }
            ByteBuffer[] preIndexBuffers = channelBuffer.sliceBuffersTo(channelBuffer.getIndex());
import java.nio.ByteBuffer;
import java.util.function.IntFunction;
        for (AtomicBoolean closedRef : queue) {
        assertEquals(InboundChannelBuffer.PAGE_SIZE, channelBuffer.getCapacity());
        for (AtomicBoolean closedRef : queue) {
        assertEquals(InboundChannelBuffer.PAGE_SIZE * 2, channelBuffer.getRemaining());
