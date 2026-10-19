    private CheckedFunction<InboundChannelBuffer, Integer, IOException> readConsumer;
    private NioSocketChannel channel;
        assertFalse(context.readyForFlush());
    }  
        }  
        byte[] bytes = createMessage(messageLength);
 */  
        FlushReadyWrite flushOperation = mock(FlushReadyWrite.class);
 * under the License.  
        assertTrue(context.readyForFlush());
    @SuppressWarnings("unchecked")
        IOException exception = new IOException();
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
        ByteBuffer[] buffers = { ByteBuffer.allocate(10) };
        when(flushOperation.getListener()).thenReturn(listener);
import static org.mockito.Mockito.eq;
/*  
        when(flushOperation1.getListener()).thenReturn(listener);
 * GitHub history for details.
        return bytes;  
 * Unless required by applicable law or agreed to in writing,
        IOException exception = new IOException();
        when(flushOperation2.getListener()).thenReturn(listener2);  
        when(flushOperation.getBuffersToWrite(anyInt())).thenReturn(buffers);  
        context.flushChannel();
        listener = mock(BiConsumer.class);
        assertEquals(0, context.read());
        channelBuffer = InboundChannelBuffer.allocatingInstance();
        when(readConsumer.apply(channelBuffer)).thenReturn(messageLength * 2, 0);
import static org.mockito.Mockito.verify;
        context.queueWriteOperation(flushOperation);
        when(flushOperation.getBuffersToWrite(anyInt())).thenReturn(buffers);  
 * not use this file except in compliance with the License.
    }
        BiConsumer<Void, Exception> listener2 = mock(BiConsumer.class);  
    }  
    public void testWriteIOExceptionMeansChannelReadyToClose() throws IOException {  
            buffer.put(bytes);
        context.queueWriteOperation(flushOperation);  
        assertTrue(context.readyForFlush());  
        expectThrows(IOException.class, () -> context.read());
        ByteBuffer[] buffers = { ByteBuffer.allocate(10) };
 * the Apache License, Version 2.0 (the "License"); you may
/*
    }  
    public void testReadLessThanZeroMeansReadyForClose() throws IOException {
 * this work for additional information regarding copyright
    private BytesChannelContext context;
        assertTrue(context.selectorShouldClose());
    }
        verify(selector).executeListener(listener2, null);
        when(flushOperation1.getBuffersToWrite(anyInt())).thenReturn(new ByteBuffer[] { ByteBuffer.allocate(3) });  
import org.opensearch.common.util.PageCacheRecycler;
    }  
        IOException ioException = new IOException();
import java.util.function.Consumer;
        context.queueWriteOperation(flushOperation);
        when(flushOperation2.isFullyFlushed()).thenReturn(false, true);  
        when(rawChannel.read(any(ByteBuffer.class))).thenThrow(new IOException());
        assertEquals(messageLength, context.read());  
    private BiConsumer<Void, Exception> listener;
import static org.mockito.Mockito.when;  
import java.nio.channels.SocketChannel;
        when(flushOperation1.isFullyFlushed()).thenReturn(false, true);
        context.flushChannel();  
import static org.mockito.Mockito.times;
            bytes[i] = randomByte();
 * Licensed to Elasticsearch under one or more contributor  
        FlushReadyWrite flushOperation1 = mock(FlushReadyWrite.class);
            return bytes.length;  
        verify(rawChannel).write(eq(buffer));
        ByteBuffer buffer = ByteBuffer.allocate(1 << 14);
            ByteBuffer buffer = (ByteBuffer) invocationOnMock.getArguments()[0];
        FlushReadyWrite flushOperation = mock(FlushReadyWrite.class);
    public void testReadThrowsIOExceptionMeansReadyForClose() throws IOException {  
        assertFalse(context.selectorShouldClose());  
        when(flushOperation.getBuffersToWrite(anyInt())).thenReturn(buffers);  
        when(selector.isOnCurrentThread()).thenReturn(true);
        when(flushOperation2.getBuffersToWrite(anyInt())).thenReturn(new ByteBuffer[] { ByteBuffer.allocate(3) });
        FlushReadyWrite flushOperation2 = mock(FlushReadyWrite.class);
    public void init() {  
        assertEquals(PageCacheRecycler.BYTE_PAGE_SIZE - (bytes.length * 2), channelBuffer.getCapacity());  
}
        verify(readConsumer, times(2)).apply(channelBuffer);
        assertTrue(context.readyForFlush());
        });
    }  
        context.flushChannel();
        readConsumer = mock(CheckedFunction.class);
        assertFalse(context.readyForFlush());  
        assertSame(ioException, ex);  
        channel = mock(NioSocketChannel.class);  
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(messageLength, context.read());
        }
 * SPDX-License-Identifier: Apache-2.0
    public void testReadThrowsIOException() throws IOException {
        assertFalse(context.readyForFlush());
 *
    public void testPartialFlush() throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(messageLength, context.read());
 * KIND, either express or implied.  See the License for the
        ByteBuffer buffer = buffers[0].duplicate();
        rawChannel = mock(SocketChannel.class);
 *  
            buffer.put(bytes);
        assertFalse(context.readyForFlush());  
import org.junit.Before;
/*  
        verify(readConsumer, times(1)).apply(channelBuffer);  
    private InboundChannelBuffer channelBuffer;
import static org.mockito.Mockito.anyInt;
        assertTrue(context.readyForFlush());
        verify(selector).queueChannelClose(channel);
        buffer.flip();  
        byte[] bytes = createMessage(messageLength * 2);
    }
import static org.mockito.Mockito.any;  
        verify(readConsumer, times(1)).apply(channelBuffer);
 * this file be licensed under the Apache-2.0 license or a
            ByteBuffer buffer = (ByteBuffer) invocationOnMock.getArguments()[0];
    private int messageLength;
        when(channel.getRawChannel()).thenReturn(rawChannel);
        verify(selector).executeListener(listener, null);
    private static class TestReadWriteHandler extends BytesWriteHandler {  
        context.flushChannel();  
        context.queueWriteOperation(flushOperation);  
        assertFalse(context.readyForFlush());  
        assertEquals(0, channelBuffer.getIndex());
        assertEquals(PageCacheRecycler.BYTE_PAGE_SIZE - bytes.length, channelBuffer.getCapacity());
 * compatible open source license.
        assertFalse(context.readyForFlush());  
        });
        TestReadWriteHandler handler = new TestReadWriteHandler(readConsumer);  
        verify(readConsumer, times(2)).apply(channelBuffer);  
        when(flushOperation.isFullyFlushed()).thenReturn(false, true);
package org.opensearch.nio;
        when(flushOperation.getBuffersToWrite(anyInt())).thenReturn(new ByteBuffer[] { ByteBuffer.allocate(3) });
        when(flushOperation.getListener()).thenReturn(listener);
        byte[] bytes = createMessage(messageLength);
import java.io.IOException;  
        when(readConsumer.apply(channelBuffer)).thenReturn(messageLength, 0);  
        context = new BytesChannelContext(channel, selector, mock(Config.Socket.class), mock(Consumer.class), handler, channelBuffer);
 * ownership. Elasticsearch licenses this file to you under  
            return bytes.length;  
    }
 * You may obtain a copy of the License at  
    }
        when(flushOperation2.isFullyFlushed()).thenReturn(false);
            buffer.put(bytes);
 *    http://www.apache.org/licenses/LICENSE-2.0
            buffer.clear();
    public void testQueuedWriteIsFlushedInFlushCall() throws Exception {
public class BytesChannelContextTests extends OpenSearchTestCase {
    }
        assertEquals(bytes.length, context.read());
        when(readConsumer.apply(channelBuffer)).thenReturn(0);  
        selector = mock(NioSelector.class);
import java.nio.ByteBuffer;
        assertFalse(context.selectorShouldClose());  
 * software distributed under the License is distributed on an
        verify(listener2, times(0)).accept(null, null);  
        private TestReadWriteHandler(CheckedFunction<InboundChannelBuffer, Integer, IOException> fn) {
        context.queueWriteOperation(flushOperation1);
        ByteBuffer[] buffers = { ByteBuffer.allocate(10) };
            this.fn = fn;
 */  
    public void testPartialRead() throws IOException {  
    }
import java.util.function.BiConsumer;  
import org.opensearch.common.CheckedFunction;
        verify(selector).executeFailedListener(listener, exception);
        when(rawChannel.read(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {  
        verify(listener, times(0)).accept(null, null);
        when(readConsumer.apply(channelBuffer)).thenReturn(messageLength, messageLength, 0);  
        context.queueWriteOperation(flushOperation2);  
            return bytes.length;  
        });  
        private final CheckedFunction<InboundChannelBuffer, Integer, IOException> fn;
        assertFalse(context.readyForFlush());
    public void testSuccessfulRead() throws IOException {  
        assertEquals(PageCacheRecycler.BYTE_PAGE_SIZE - bytes.length, channelBuffer.getCapacity());
        when(rawChannel.read(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {  
        messageLength = randomInt(96) + 20;  
        when(rawChannel.read(any(ByteBuffer.class))).thenThrow(ioException);  
        verify(selector).executeListener(listener, null);
        assertTrue(context.selectorShouldClose());
        for (int i = 0; i < length; ++i) {  
 * Modifications Copyright OpenSearch Contributors. See
    }
        assertEquals(0, channelBuffer.getIndex());
        assertEquals(bytes.length, channelBuffer.getIndex());
        FlushReadyWrite flushOperation = mock(FlushReadyWrite.class);
        when(rawChannel.read(any(ByteBuffer.class))).thenReturn(-1);  
        assertTrue(context.selectorShouldClose());
        when(rawChannel.read(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {  
    public void testWhenIOExceptionThrownListenerIsCalled() throws IOException {
    @Before
        when(flushOperation.isFullyFlushed()).thenReturn(false);  
    public void testMultipleWritesPartialFlushes() throws IOException {  
    @SuppressWarnings("varargs")
        when(selector.getIoBuffer()).thenAnswer(invocationOnMock -> {  
        public int consumeReads(InboundChannelBuffer channelBuffer) throws IOException {  
 */
            return buffer;
    @SuppressWarnings("unchecked")
        when(rawChannel.write(any(ByteBuffer.class))).thenThrow(exception);
        }
        assertEquals(0, channelBuffer.getIndex());
    }
    public void testInitiateCloseSchedulesCloseWithSelector() {
        IOException ex = expectThrows(IOException.class, () -> context.read());
 * license agreements. See the NOTICE file distributed with
        FlushReadyWrite flushOperation = mock(FlushReadyWrite.class);  
        assertTrue(context.readyForFlush());
        context.closeChannel();  
        when(rawChannel.write(any(ByteBuffer.class))).thenThrow(exception);
    private static byte[] createMessage(int length) {
    private NioSelector selector;  
    private SocketChannel rawChannel;  
            return fn.apply(channelBuffer);
        byte[] bytes = new byte[length];
 *
import static org.mockito.Mockito.mock;  
        expectThrows(IOException.class, () -> context.flushChannel());
    public void testMultipleReadsConsumed() throws IOException {  
    }
        expectThrows(IOException.class, () -> context.flushChannel());  
            ByteBuffer buffer = (ByteBuffer) invocationOnMock.getArguments()[0];
        });
        assertTrue(context.readyForFlush());
        @Override
