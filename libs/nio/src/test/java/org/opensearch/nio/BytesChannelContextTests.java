        private TestReadWriteHandler(CheckedFunction<InboundChannelBuffer, Integer, IOException> fn) {
    public void testSuccessfulRead() throws IOException {
    }
            return bytes.length;
        verify(readConsumer, times(2)).apply(channelBuffer);
        when(flushOperation2.getBuffersToWrite(anyInt())).thenReturn(new ByteBuffer[] { ByteBuffer.allocate(3) });
    }
/*
        context.queueWriteOperation(flushOperation2);
        assertEquals(bytes.length, channelBuffer.getIndex());
        });
    @SuppressWarnings("unchecked")
        assertEquals(0, channelBuffer.getIndex());
        context.queueWriteOperation(flushOperation);
            bytes[i] = randomByte();
        @Override
    }
 * this file be licensed under the Apache-2.0 license or a
        messageLength = randomInt(96) + 20;
        context.flushChannel();
 * You may obtain a copy of the License at
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            buffer.clear();
import static org.mockito.Mockito.times;
 *
            buffer.put(bytes);
 * KIND, either express or implied.  See the License for the
        when(rawChannel.read(any(ByteBuffer.class))).thenThrow(ioException);
        when(rawChannel.write(any(ByteBuffer.class))).thenThrow(exception);
        expectThrows(IOException.class, () -> context.read());
        FlushReadyWrite flushOperation = mock(FlushReadyWrite.class);
        verify(listener2, times(0)).accept(null, null);
    public void testPartialFlush() throws IOException {
import java.util.function.Consumer;
import java.nio.channels.SocketChannel;
    public void testMultipleWritesPartialFlushes() throws IOException {
        assertEquals(messageLength, context.read());
        when(flushOperation.getBuffersToWrite(anyInt())).thenReturn(buffers);
        when(readConsumer.apply(channelBuffer)).thenReturn(messageLength * 2, 0);
public class BytesChannelContextTests extends OpenSearchTestCase {
    }
 * specific language governing permissions and limitations
        verify(listener, times(0)).accept(null, null);
            ByteBuffer buffer = (ByteBuffer) invocationOnMock.getArguments()[0];
    public void testInitiateCloseSchedulesCloseWithSelector() {
        context.closeChannel();
 *
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
    }
        assertTrue(context.readyForFlush());
        byte[] bytes = createMessage(messageLength);
        channel = mock(NioSocketChannel.class);
        });
        assertFalse(context.selectorShouldClose());
/*
        TestReadWriteHandler handler = new TestReadWriteHandler(readConsumer);
        assertEquals(PageCacheRecycler.BYTE_PAGE_SIZE - bytes.length, channelBuffer.getCapacity());
        when(flushOperation.getBuffersToWrite(anyInt())).thenReturn(buffers);
import static org.mockito.Mockito.any;
        when(rawChannel.write(any(ByteBuffer.class))).thenThrow(exception);
        byte[] bytes = createMessage(messageLength);
        assertEquals(messageLength, context.read());
        assertFalse(context.readyForFlush());
        IOException exception = new IOException();
    }
 * software distributed under the License is distributed on an
import static org.mockito.Mockito.anyInt;
    public void testQueuedWriteIsFlushedInFlushCall() throws Exception {
 */
        assertFalse(context.readyForFlush());
        assertEquals(0, context.read());
        FlushReadyWrite flushOperation = mock(FlushReadyWrite.class);
        when(rawChannel.read(any(ByteBuffer.class))).thenReturn(-1);
        assertEquals(0, channelBuffer.getIndex());
        context.queueWriteOperation(flushOperation1);
import org.opensearch.common.util.PageCacheRecycler;
        when(selector.isOnCurrentThread()).thenReturn(true);
        assertFalse(context.readyForFlush());
        context.flushChannel();
        verify(selector).executeListener(listener2, null);
            this.fn = fn;
        }
        assertFalse(context.selectorShouldClose());
 * Modifications Copyright OpenSearch Contributors. See
        }
        context.flushChannel();
        verify(readConsumer, times(1)).apply(channelBuffer);
        when(flushOperation.isFullyFlushed()).thenReturn(false, true);
        assertTrue(context.readyForFlush());
            ByteBuffer buffer = (ByteBuffer) invocationOnMock.getArguments()[0];
        byte[] bytes = new byte[length];
import static org.mockito.Mockito.when;
            buffer.put(bytes);
    private InboundChannelBuffer channelBuffer;
        when(rawChannel.read(any(ByteBuffer.class))).thenThrow(new IOException());
    }
        context.flushChannel();
        FlushReadyWrite flushOperation = mock(FlushReadyWrite.class);
 * Licensed to Elasticsearch under one or more contributor
    }
        ByteBuffer[] buffers = { ByteBuffer.allocate(10) };
 * not use this file except in compliance with the License.
        readConsumer = mock(CheckedFunction.class);
    private static class TestReadWriteHandler extends BytesWriteHandler {
    }
        when(flushOperation1.getListener()).thenReturn(listener);
    public void testReadThrowsIOExceptionMeansReadyForClose() throws IOException {
        verify(selector).queueChannelClose(channel);
        assertTrue(context.selectorShouldClose());
        when(readConsumer.apply(channelBuffer)).thenReturn(messageLength, 0);
        FlushReadyWrite flushOperation1 = mock(FlushReadyWrite.class);
        IOException ex = expectThrows(IOException.class, () -> context.read());
        });
        when(flushOperation.isFullyFlushed()).thenReturn(false);
import java.io.IOException;
        context = new BytesChannelContext(channel, selector, mock(Config.Socket.class), mock(Consumer.class), handler, channelBuffer);
        private final CheckedFunction<InboundChannelBuffer, Integer, IOException> fn;
        buffer.flip();
        ByteBuffer buffer = ByteBuffer.allocate(1 << 14);
        assertFalse(context.readyForFlush());
        when(flushOperation2.isFullyFlushed()).thenReturn(false, true);
        assertTrue(context.readyForFlush());
import static org.mockito.Mockito.mock;
        when(readConsumer.apply(channelBuffer)).thenReturn(messageLength, messageLength, 0);
        when(rawChannel.read(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {
    @SuppressWarnings("varargs")
        }
        BiConsumer<Void, Exception> listener2 = mock(BiConsumer.class);
        when(rawChannel.read(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {
 * Unless required by applicable law or agreed to in writing,
        IOException exception = new IOException();
package org.opensearch.nio;
    private static byte[] createMessage(int length) {
        when(rawChannel.read(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {
            return buffer;
        verify(readConsumer, times(1)).apply(channelBuffer);
    public void init() {
        ByteBuffer[] buffers = { ByteBuffer.allocate(10) };
        context.queueWriteOperation(flushOperation);
            ByteBuffer buffer = (ByteBuffer) invocationOnMock.getArguments()[0];
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.junit.Before;
    private BiConsumer<Void, Exception> listener;
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(context.readyForFlush());
    }
        when(flushOperation.getListener()).thenReturn(listener);
    }
 * under the License.
/*
import org.opensearch.common.CheckedFunction;
import static org.mockito.Mockito.verify;
    private SocketChannel rawChannel;
        assertFalse(context.readyForFlush());
 * license agreements. See the NOTICE file distributed with
        verify(readConsumer, times(2)).apply(channelBuffer);
        public int consumeReads(InboundChannelBuffer channelBuffer) throws IOException {
        rawChannel = mock(SocketChannel.class);
    public void testWriteIOExceptionMeansChannelReadyToClose() throws IOException {
        ByteBuffer buffer = buffers[0].duplicate();
    private int messageLength;
 * The OpenSearch Contributors require contributions made to
        context.queueWriteOperation(flushOperation);
    }
        when(channel.getRawChannel()).thenReturn(rawChannel);
        });
    private CheckedFunction<InboundChannelBuffer, Integer, IOException> readConsumer;
        IOException ioException = new IOException();
        expectThrows(IOException.class, () -> context.flushChannel());
        assertTrue(context.readyForFlush());
        verify(selector).executeListener(listener, null);
        when(flushOperation.getBuffersToWrite(anyInt())).thenReturn(buffers);
        assertFalse(context.readyForFlush());
        selector = mock(NioSelector.class);
        when(flushOperation2.isFullyFlushed()).thenReturn(false);
import java.util.function.BiConsumer;
        byte[] bytes = createMessage(messageLength * 2);
        assertEquals(PageCacheRecycler.BYTE_PAGE_SIZE - bytes.length, channelBuffer.getCapacity());
            return bytes.length;
        context.queueWriteOperation(flushOperation);
    @Before
        assertEquals(messageLength, context.read());
        assertEquals(0, channelBuffer.getIndex());
 */
    private NioSocketChannel channel;
        assertSame(ioException, ex);
    }
        assertEquals(bytes.length, context.read());
        ByteBuffer[] buffers = { ByteBuffer.allocate(10) };
    private NioSelector selector;
    public void testPartialRead() throws IOException {
        assertTrue(context.selectorShouldClose());
        when(flushOperation.getListener()).thenReturn(listener);
import static org.mockito.Mockito.eq;
    public void testReadLessThanZeroMeansReadyForClose() throws IOException {
 */
}
        assertEquals(PageCacheRecycler.BYTE_PAGE_SIZE - (bytes.length * 2), channelBuffer.getCapacity());
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
        verify(selector).executeListener(listener, null);
        when(flushOperation2.getListener()).thenReturn(listener2);
        assertFalse(context.readyForFlush());
        FlushReadyWrite flushOperation = mock(FlushReadyWrite.class);
        expectThrows(IOException.class, () -> context.flushChannel());
        channelBuffer = InboundChannelBuffer.allocatingInstance();
    public void testReadThrowsIOException() throws IOException {
        listener = mock(BiConsumer.class);
        assertTrue(context.selectorShouldClose());
        for (int i = 0; i < length; ++i) {
        verify(selector).executeFailedListener(listener, exception);
 *
        when(flushOperation1.getBuffersToWrite(anyInt())).thenReturn(new ByteBuffer[] { ByteBuffer.allocate(3) });
    public void testMultipleReadsConsumed() throws IOException {
        when(flushOperation1.isFullyFlushed()).thenReturn(false, true);
        when(flushOperation.getBuffersToWrite(anyInt())).thenReturn(new ByteBuffer[] { ByteBuffer.allocate(3) });
            buffer.put(bytes);
import java.nio.ByteBuffer;
        FlushReadyWrite flushOperation2 = mock(FlushReadyWrite.class);
            return bytes.length;
 * this work for additional information regarding copyright
            return fn.apply(channelBuffer);
        return bytes;
    }
    @SuppressWarnings("unchecked")
    private BytesChannelContext context;
        assertTrue(context.readyForFlush());
        when(selector.getIoBuffer()).thenAnswer(invocationOnMock -> {
        verify(rawChannel).write(eq(buffer));
    public void testWhenIOExceptionThrownListenerIsCalled() throws IOException {
        when(readConsumer.apply(channelBuffer)).thenReturn(0);
    }
 * GitHub history for details.
