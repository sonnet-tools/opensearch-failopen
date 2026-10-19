        void doSelectorRegister() {
        ByteBuffer[] buffers = { ByteBuffer.allocate(1023), ByteBuffer.allocate(1023) };  
        });
                return consumeBufferAnswer(3).answer(invocationOnMock);  
        InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
            -1,
            } else {
            }
            this(channel, selector, exceptionHandler, readWriteHandler, channelBuffer, getSocketConfig());  
        ArgumentCaptor<WriteOperation> writeOpCaptor = ArgumentCaptor.forClass(WriteOperation.class);
        context.flushToChannel(flushOperation);  
            when(channel.getRawChannel()).thenReturn(realChannel);
                throw new AssertionError("Connection should not fail");  
            ByteBuffer b = (ByteBuffer) invocationOnMock.getArguments()[0];  
import static org.mockito.Mockito.doThrow;
    public void testFlushOpsClearedOnClose() throws Exception {
        int tcpReceiveBufferSize = randomIntBetween(1000, 2000);
        assertTrue(context.readyForFlush());  
        ByteBuffer[] buffer = { ByteBuffer.allocate(10) };  
    }
            verify(handler).close();
    }
/*
            verify(selector, times(1)).executeFailedListener(same(listener2), any(ClosedChannelException.class));  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    public void testSendMessageFromDifferentThreadIsQueuedWithSelector() throws Exception {  
                return consumeBufferAnswer(1024).answer(invocationOnMock);  
    }
        FlushOperation flushOperation = new FlushOperation(buffers, listener);  
            );  
            tcpKeepCount,  
    public void testWillPollForFlushOpsToClose() throws Exception {
        assertFalse(context.readyForFlush());
            verify(rawChannel, times(0)).connect(any(InetSocketAddress.class));
        WriteOperation writeOp = writeOpCaptor.getValue();
    }
        ) {
        }  
        context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, channelBuffer);
    }
import static org.mockito.Mockito.when;
            InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
                context.flushChannel();  
            when(channel.isOpen()).thenReturn(true);  
            ByteBuffer[] buffer = { ByteBuffer.allocate(10) };
    public void testReadToChannelBufferHandlesIOException() throws IOException {
        listener = mock(BiConsumer.class);
        AtomicBoolean first = new AtomicBoolean(true);
        ByteBuffer[] buffers = { ByteBuffer.allocate(1023), ByteBuffer.allocate(1023) };
    @SuppressWarnings({ "unchecked", "varargs" })  
            tcpKeepAlive,  
    }
            false  
            }
import org.mockito.ArgumentCaptor;
    }
            return readFromChannel(channelBuffer);
import java.nio.channels.ClosedChannelException;
 * Licensed to Elasticsearch under one or more contributor  
                context.read();
            randomBoolean()
 * not use this file except in compliance with the License.
            tcpKeepAlive,
        context.register();  
    public void testCloseClosesWriteProducer() throws IOException {  
        boolean tcpReuseAddress = randomBoolean();
 * software distributed under the License is distributed on an
            context.queueWriteOperation(writeOperation);
        }  
            isAccepted
        }  
        });
        when(rawChannel.write(any(ByteBuffer.class))).thenAnswer(consumeBufferAnswer(0));  
    public void testIOExceptionSetIfEncountered() throws IOException {
        verify(rawSocket).setReuseAddress(tcpReuseAddress);
        verify(rawSocket).setSendBufferSize(tcpSendBufferSize);  
        for (int i = 0; i < length; ++i) {
 */
    }
    public void testFlushBuffersHandlesIOException() throws IOException {  
            tcpNoDelay,
        AtomicBoolean first = new AtomicBoolean(true);
        });
    }
        }  
        assertTrue(context.isConnectComplete());
        Config.Socket config;
        } else {  
    }  
    }  
            assertTrue(context.readyForFlush());  
            address,
            tcpSendBufferSize,  
                buffer
                throw new AssertionError("Connection should not succeed");
 * ownership. Elasticsearch licenses this file to you under  
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean tcpKeepAlive = randomBoolean();
        }
        verify(rawSocket).setKeepAlive(tcpKeepAlive);
            } else {
        int tcpKeepCount = randomIntBetween(1, 1000);  
        boolean tcpReuseAddress = randomBoolean();
            BiConsumer<Void, Exception> listener2 = mock(BiConsumer.class);  
        assertFalse(context.closeNow());
                Arrays.asList(new FlushOperation(buffer, listener), new FlushOperation(buffer, listener2))
        int tcpKeepIdle = randomIntBetween(1, 1000);
        context.read();  
    }
        try (SocketChannel realChannel = SocketChannel.open()) {  
    }  
import java.net.Socket;
        when(rawChannel.write(any(ByteBuffer[].class), anyInt(), anyInt())).thenThrow(new IOException());  
        });
        when(channel.getRawChannel()).thenReturn(rawChannel);  
        assertSame(ioException, exception.get());  
        }
        }  
        verify(selector).queueWrite(writeOpCaptor.capture());
 * this file be licensed under the Apache-2.0 license or a
    public void testWriteFailsIfClosing() {  
                throw new IOException();  
        when(rawChannel.write(any(ByteBuffer.class))).thenThrow(new IOException());
            NioSelector selector,
        assertTrue(context.connect());
        assertEquals(1, flushOperation.getBuffersToWrite()[0].position());  
            super(channel, selector, config, exceptionHandler, readWriteHandler, channelBuffer);
        context.readFromChannel(channelBuffer);  
        when(rawChannel.finishConnect()).thenReturn(false, true);  
    }
import java.io.IOException;
        };
        when(rawChannel.write(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {
    }
        assertTrue(context.closeNow());
    }
        when(rawChannel.finishConnect()).thenReturn(false).thenThrow(ioException);  
        public boolean selectorShouldClose() {  
        context.sendMessage(buffers, listener);
    }
        assertEquals(0, channelBuffer.getIndex());
            randomBoolean(),  
        @Override
 * KIND, either express or implied.  See the License for the
        expectThrows(IOException.class, () -> {
        assertTrue(context.closeNow());
        verify(listener).accept(isNull(), any(ClosedChannelException.class));  
import java.util.function.BiConsumer;
        config = new Config.Socket(
        }
/*  
        boolean tcpNoDelay = randomBoolean();
        when(rawChannel.read(any(ByteBuffer[].class), anyInt(), anyInt())).thenThrow(new IOException());
        when(selector.isOnCurrentThread()).thenReturn(false);  
        );  
        WriteOperation writeOperation = mock(WriteOperation.class);
 * the Apache License, Version 2.0 (the "License"); you may
    private static Config.Socket getSocketConfig() {  
        verify(rawSocket).setSendBufferSize(tcpSendBufferSize);  
    public void testFlushBuffersHandlesIOExceptionSecondTimeThroughLoop() throws IOException {  
            }
        when(handler.createWriteOperation(context, buffers, listener)).thenReturn(writeOperation);  
        InetSocketAddress address = mock(InetSocketAddress.class);
        return bytes;
        FlushReadyWrite writeOperation = new FlushReadyWrite(context, buffer, listener);
        context.register();
        try (SocketChannel realChannel = SocketChannel.open()) {
    private Socket rawSocket;
        when(rawChannel.read(any(ByteBuffer.class))).thenReturn(-1);  
        context.addConnectListener((v, t) -> {
    private Consumer<Exception> exceptionHandler;
        when(handler.pollFlushOperations()).thenReturn(Collections.singletonList(mock(FlushOperation.class)));
        assertFalse(context.readyForFlush());
import java.util.concurrent.atomic.AtomicBoolean;
        InboundChannelBuffer buffer = InboundChannelBuffer.allocatingInstance();
        try (SocketChannel realChannel = SocketChannel.open()) {
            verify(closer).run();
        int tcpReceiveBufferSize = randomIntBetween(1000, 2000);  
    private TestSocketChannelContext context;
        verify(rawSocket).setTcpNoDelay(tcpNoDelay);
                return consumeBufferAnswer(1022).answer(invocationOnMock);
        assertTrue(context.closeNow());
        @Override
            TestSocketChannelContext context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, buffer);
            return bytesRead;  
 *  
        assertFalse(context.isConnectComplete());
        WriteOperation writeOp = writeOpCaptor.getValue();
            verify(selector, times(1)).executeFailedListener(same(listener2), any(ClosedChannelException.class));  
            ByteBuffer b = (ByteBuffer) invocationOnMock.getArguments()[0];
        when(rawChannel.finishConnect()).thenReturn(true);  
            WriteOperation writeOperation = mock(WriteOperation.class);
        }
            tcpNoDelay,  
import static org.mockito.Mockito.times;
 * compatible open source license.
        AtomicReference<Exception> exception = new AtomicReference<>();
        assertEquals(0, flushOperation.getBuffersToWrite()[0].position());  
        expectThrows(IOException.class, () -> context.flushToChannel(flushOperation));
            ByteBuffer[] buffer = { ByteBuffer.allocate(10) };
            // We do not want to call the actual register with selector method as it will throw a NPE
                b.put((byte) 1);
        FlushOperation flushOperation = new FlushOperation(buffers, listener);
            when(channel.isOpen()).thenReturn(true);
    }
        @Override  
        try (SocketChannel realChannel = SocketChannel.open()) {
            BytesChannelContext context = new BytesChannelContext(
        when(rawChannel.read(any(ByteBuffer.class))).thenAnswer(completelyFillBufferAnswer());  
        }
        int tcpSendBufferSize = randomIntBetween(1000, 2000);
import org.opensearch.test.OpenSearchTestCase;
        when(rawChannel.write(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {
            when(channel.isOpen()).thenReturn(true);  
        ByteBuffer[] buffers = { ByteBuffer.wrap(createMessage(10)) };  
            randomBoolean(),
import org.junit.Before;  
        assertEquals(ioBuffer.capacity(), bytesRead);
            Config.Socket config  
        when(rawChannel.read(any(ByteBuffer.class))).thenThrow(new IOException());  
            tcpSendBufferSize,
                exception.set(t);  
            verify(selector, times(1)).executeFailedListener(same(listener), any(ClosedChannelException.class));
        assertFalse(context.connect());
        context.connect();
        verify(rawSocket).setReceiveBufferSize(tcpReceiveBufferSize);
    @SuppressWarnings("unchecked")
            address,
            tcpKeepInterval,  
}
    }  
        int tcpKeepCount = randomIntBetween(1, 1000);
            -1,  
            Consumer<Exception> exceptionHandler,
            ByteBuffer[] byteBuffers = { ByteBuffer.allocate(10) };
    public void testSignalWhenPeerClosed() throws IOException {  
            assertFalse(context.readyForFlush());
        WriteOperation writeOperation = mock(WriteOperation.class);  
        when(selector.getIoBuffer()).thenAnswer(invocationOnMock -> {
        context.flushToChannel(flushOperation);
        private TestSocketChannelContext(  
    public void testFlushBuffersHandlesZeroFlush() throws IOException {
        ByteBuffer[] buffers = { ByteBuffer.wrap(createMessage(10)) };
                channel,  
        ByteBuffer[] buffers = { ByteBuffer.allocate(1023), ByteBuffer.allocate(1023) };
        assertEquals(1, flushOperation.getBuffersToWrite().length);
            InboundChannelBuffer channelBuffer
        });
            when(channel.isOpen()).thenReturn(true);
        when(rawChannel.read(any(ByteBuffer.class))).thenThrow(new IOException());  
        when(handler.writeToBytes(writeOperation)).thenReturn(Collections.singletonList(writeOperation));
            verify(rawChannel).connect(same(address));
 *
            -1,  
            assertFalse(context.readyForFlush());
        assertEquals(4, flushOperation.getBuffersToWrite()[0].position());
    public void testReadToChannelBufferHandlesEOF() throws IOException {
            assertFalse(context.readyForFlush());
        InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
            NioSelector selector,
        return new Config.Socket(
        context.channelActive();
public class SocketChannelContextTests extends OpenSearchTestCase {
        assertFalse(context.closeNow());
        assertTrue(context.closeNow());  
        context.flushToChannel(flushOperation);
        doThrow(new SocketException()).doNothing().when(rawSocket).setReuseAddress(tcpReuseAddress);
        context.queueWriteOperation(writeOperation);  
            -1,
        assertTrue(flushOperation.isFullyFlushed());  
        });
        context.sendMessage(buffers, listener);
            ioBuffer.clear();  
        public void closeChannel() {
        rawChannel = mock(SocketChannel.class);  
    private NioSelector selector;
    }
        if (isAccepted) {
        FlushOperation flushOperation = new FlushOperation(buffers, listener);
 *    http://www.apache.org/licenses/LICENSE-2.0
        TestSocketChannelContext context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, buffer, config);
        assertSame(writeOperation, writeOp);  
            tcpKeepIdle,
            Consumer<Exception> exceptionHandler,  
        handler = mock(NioChannelHandler.class);  
            if (t == null) {  
            flushToChannel(new FlushOperation(byteBuffers, (v, e) -> {}));
        verify(handler).writeToBytes(writeOperation);
            Runnable closer = mock(Runnable.class);
import static org.mockito.Mockito.verify;  
    }
 * license agreements. See the NOTICE file distributed with
        InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
    }
        int tcpSendBufferSize = randomIntBetween(1000, 2000);  
    private SocketChannel rawChannel;  
        rawSocket = mock(Socket.class);  
import org.mockito.stubbing.Answer;  
        private TestSocketChannelContext(
import java.nio.ByteBuffer;  
            when(channel.getRawChannel()).thenReturn(realChannel);  
        when(rawChannel.write(any(ByteBuffer.class))).thenThrow(new IOException());
            }
        boolean tcpKeepAlive = randomBoolean();  
        assertFalse(context.isConnectComplete());
    public void testHandleReadBytesWillCheckForNewFlushOperations() throws IOException {  
        int tcpKeepInterval = randomIntBetween(1, 1000);  
        verify(rawSocket, times(2)).setReuseAddress(tcpReuseAddress);  
        FlushOperation flushOperation = new FlushOperation(buffers, listener);
            InboundChannelBuffer buffer = InboundChannelBuffer.allocatingInstance();
                mock(Config.Socket.class),
        verify(rawSocket).setReceiveBufferSize(tcpReceiveBufferSize);
        context.closeChannel();
            return bytesToConsume;
            verify(selector, times(1)).executeFailedListener(same(listener), any(ClosedChannelException.class));
        expectThrows(IOException.class, () -> context.flushToChannel(flushOperation));  
            return isClosing.get();
            int bytesRead = b.remaining();
    private static class TestSocketChannelContext extends SocketChannelContext {  
                Arrays.asList(new FlushOperation(buffer, listener), new FlushOperation(buffer, listener2))
        assertFalse(listenerCalled.get());  
            }
import org.opensearch.common.SuppressForbidden;
        assertNull(exception.get());  
        byte[] bytes = new byte[length];
        assertFalse(context.isConnectComplete());
        verify(rawSocket).setTcpNoDelay(tcpNoDelay);  
        when(rawChannel.socket()).thenReturn(rawSocket);
        assertEquals(0, channelBuffer.getIndex());
        when(handler.createWriteOperation(context, buffers, listener)).thenReturn(writeOperation);
    @SuppressWarnings({ "unchecked", "varargs" })
            } else {
    private NioSocketChannel channel;  
        TestSocketChannelContext context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, buffer, config);  
        verify(handler).channelActive();  
    public void testRegisterInitiatesConnect() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        public int read() throws IOException {  
            tcpReceiveBufferSize,
        int tcpKeepIdle = randomIntBetween(1, 1000);
        exceptionHandler = mock(Consumer.class);
        when(rawSocket.getChannel()).thenReturn(rawChannel);
            tcpKeepCount,
            InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
        assertFalse(context.connect());
            NioChannelHandler readWriteHandler,
        @Override
            if (first.compareAndSet(true, false)) {  
            NioChannelHandler readWriteHandler,  
    public void testSendMessageFromSameThreadIsQueuedInChannel() {
import java.net.SocketException;
        assertTrue(context.closeNow());  
        assertTrue(context.closeNow());
                return consumeBufferAnswer(1024).answer(invocationOnMock);
import java.util.Arrays;  
            tcpReuseAddress,
 * Modifications Copyright OpenSearch Contributors. See
    private Answer<Integer> completelyFillBufferAnswer() {
    private ByteBuffer ioBuffer = ByteBuffer.allocate(1024);
        selector = mock(NioSelector.class);
                handler,
            when(channel.getRawChannel()).thenReturn(realChannel);
            if (first.compareAndSet(true, false)) {
        when(selector.isOnCurrentThread()).thenReturn(true);
import java.util.function.IntFunction;  
import static org.mockito.Mockito.mock;  
 */  
    public void testFlushBuffersHandlesFullFlush() throws IOException {
            } else {
            context.closeFromSelector();
                listenerCalled.compareAndSet(false, true);
        int tcpKeepInterval = randomIntBetween(1, 1000);
    }
            when(handler.pollFlushOperations()).thenReturn(  
            InboundChannelBuffer buffer = new InboundChannelBuffer(pageAllocator);  
            mock(InetSocketAddress.class),
            buffer.ensureCapacity(1);
        return invocationOnMock -> {
        return invocationOnMock -> {  
        ) {
            InboundChannelBuffer channelBuffer,
            context.closeFromSelector();  
            isClosing.set(true);  
            if (first.compareAndSet(true, false)) {  
    public void testChannelActiveCallsHandler() throws IOException {
 *
    }
        IOException ioException = new IOException("boom");
            );  
        super.setUp();
                exceptionHandler,  
            when(channel.getRawChannel()).thenReturn(realChannel);
    public void testFlushBuffersHandlesPartialFlush() throws IOException {  
        ByteBuffer[] buffers = { ByteBuffer.wrap(createMessage(10)) };
        expectThrows(IOException.class, () -> context.readFromChannel(channelBuffer));  
    private NioChannelHandler handler;  
                return consumeBufferAnswer(1024).answer(invocationOnMock);
        assertEquals(ioBuffer.capacity(), channelBuffer.getIndex());
        }  
        verify(rawSocket).setKeepAlive(tcpKeepAlive);
            when(handler.writeToBytes(writeOperation)).thenReturn(
            } else {
            if (randomBoolean()) {  
            tcpReuseAddress,
    private Answer<Object> consumeBufferAnswer(int bytesToConsume) {
 */  
import static org.mockito.Mockito.isNull;
        );  
        channel = mock(NioSocketChannel.class);
        assertEquals(2, flushOperation.getBuffersToWrite().length);
        );
    }  
        ByteBuffer[] buffers = { ByteBuffer.allocate(10), ByteBuffer.allocate(10) };  
        context.handleReadBytes();  
            b.position(b.position() + bytesToConsume);
            NioSocketChannel channel,
        InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
        config = new Config.Socket(
        verify(selector).queueWrite(writeOpCaptor.capture());  
            context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, channelBuffer);  
    }  
            while (b.hasRemaining()) {  
        }  
import static org.mockito.Mockito.same;
        });
        assertSame(writeOperation, writeOp);
        boolean tcpNoDelay = randomBoolean();  
import java.util.concurrent.atomic.AtomicReference;  
import static org.mockito.Mockito.any;
            IntFunction<Page> pageAllocator = (n) -> new Page(ByteBuffer.allocate(n), closer);
            tcpKeepIdle,
            assertFalse(context.readyForFlush());
            return ioBuffer;
        Config.Socket config;
    public void testReadToChannelBufferWillReadAsMuchAsIOBufferAllows() throws IOException {
@SuppressForbidden(reason = "allow call to socket connect")  
        context.addConnectListener((v, t) -> {
            tcpKeepInterval,
 * You may obtain a copy of the License at  
        }
        assertEquals(1, flushOperation.getBuffersToWrite().length);
        AtomicBoolean first = new AtomicBoolean(true);  
            BiConsumer<Void, Exception> listener2 = mock(BiConsumer.class);
    public void testConnectSucceeds() throws IOException {
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
    }
        public void flushChannel() throws IOException {  
                selector,
 * this work for additional information regarding copyright
    }
        InboundChannelBuffer buffer = InboundChannelBuffer.allocatingInstance();
        ByteBuffer[] buffers = { ByteBuffer.allocate(1023), ByteBuffer.allocate(1023) };
            context.closeFromSelector();  
            InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
import java.net.InetSocketAddress;  
    public void testWriteIsQueuedInChannel() {  
        FlushOperation flushOperation = new FlushOperation(buffers, listener);
 * GitHub history for details.
            bytes[i] = randomByte();  
        expectThrows(IOException.class, context::connect);
    public void testConnectFails() throws IOException {  
            }
import static org.mockito.Mockito.anyInt;  
            NioSocketChannel channel,  
            context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, channelBuffer);
        };  
            context.closeFromSelector();  
        assertTrue(context.readyForFlush());
        context.sendMessage(buffers, listener);
    @Before
        ArgumentCaptor<WriteOperation> writeOpCaptor = ArgumentCaptor.forClass(WriteOperation.class);
    private static byte[] createMessage(int length) {  
import java.util.Collections;
    public void testConnectCanSetSocketOptions() throws IOException {  
        int bytesRead = context.readFromChannel(channelBuffer);  
        when(rawChannel.read(any(ByteBuffer.class))).thenReturn(-1);
import java.nio.channels.SocketChannel;
            tcpReceiveBufferSize,  
        assertTrue(listenerCalled.get());  
 * under the License.  
            }  
package org.opensearch.nio;
/*  
 * The OpenSearch Contributors require contributions made to  
    public void testCloseClosesChannelBuffer() throws IOException {  
    public void setup() throws Exception {  
            -1,
        boolean isAccepted = randomBoolean();  
        InetSocketAddress address = mock(InetSocketAddress.class);
            randomBoolean(),
import java.util.function.Consumer;
        @Override
            if (t == null) {  
        when(rawChannel.write(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {
    }
            } else {
    }  
    private BiConsumer<Void, Exception> listener;
