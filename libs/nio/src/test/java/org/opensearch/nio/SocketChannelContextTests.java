        verify(selector).queueWrite(writeOpCaptor.capture());
        assertEquals(0, flushOperation.getBuffersToWrite()[0].position());
            NioChannelHandler readWriteHandler,
    private BiConsumer<Void, Exception> listener;
        int tcpReceiveBufferSize = randomIntBetween(1000, 2000);
            InboundChannelBuffer buffer = new InboundChannelBuffer(pageAllocator);
    }
import org.opensearch.common.SuppressForbidden;
    public void testConnectSucceeds() throws IOException {
                buffer
        byte[] bytes = new byte[length];
            InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
            ByteBuffer b = (ByteBuffer) invocationOnMock.getArguments()[0];
 */
            when(channel.getRawChannel()).thenReturn(realChannel);
import java.net.InetSocketAddress;
        void doSelectorRegister() {
    public void testWillPollForFlushOpsToClose() throws Exception {
            Consumer<Exception> exceptionHandler,
        public int read() throws IOException {
        context.handleReadBytes();
            -1,
            }
        when(rawChannel.read(any(ByteBuffer.class))).thenReturn(-1);
            );
        assertFalse(context.readyForFlush());
        expectThrows(IOException.class, () -> context.readFromChannel(channelBuffer));
        context.register();
        when(handler.writeToBytes(writeOperation)).thenReturn(Collections.singletonList(writeOperation));
        int tcpKeepIdle = randomIntBetween(1, 1000);
            this(channel, selector, exceptionHandler, readWriteHandler, channelBuffer, getSocketConfig());
            isAccepted
            verify(selector, times(1)).executeFailedListener(same(listener2), any(ClosedChannelException.class));
        WriteOperation writeOp = writeOpCaptor.getValue();
            BiConsumer<Void, Exception> listener2 = mock(BiConsumer.class);
        FlushOperation flushOperation = new FlushOperation(buffers, listener);
        assertEquals(1, flushOperation.getBuffersToWrite().length);
        InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
import static org.mockito.Mockito.doThrow;
            assertFalse(context.readyForFlush());
        handler = mock(NioChannelHandler.class);
    }
            context.closeFromSelector();
    }
package org.opensearch.nio;
        ByteBuffer[] buffer = { ByteBuffer.allocate(10) };
/*
            context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, channelBuffer);
        verify(handler).writeToBytes(writeOperation);
        assertTrue(context.closeNow());
            tcpReceiveBufferSize,
import org.mockito.stubbing.Answer;
            when(channel.isOpen()).thenReturn(true);
    public void testConnectCanSetSocketOptions() throws IOException {
        public void closeChannel() {
    public void testFlushBuffersHandlesIOException() throws IOException {
@SuppressForbidden(reason = "allow call to socket connect")
    }
            NioSocketChannel channel,
            address,
        assertFalse(listenerCalled.get());
        Config.Socket config;
            isClosing.set(true);
        private TestSocketChannelContext(
        doThrow(new SocketException()).doNothing().when(rawSocket).setReuseAddress(tcpReuseAddress);
        ArgumentCaptor<WriteOperation> writeOpCaptor = ArgumentCaptor.forClass(WriteOperation.class);
    }
                Arrays.asList(new FlushOperation(buffer, listener), new FlushOperation(buffer, listener2))
        });
        ByteBuffer[] buffers = { ByteBuffer.wrap(createMessage(10)) };
        }
        assertFalse(context.closeNow());
        exceptionHandler = mock(Consumer.class);
            when(handler.writeToBytes(writeOperation)).thenReturn(
            InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
    private Answer<Integer> completelyFillBufferAnswer() {
import org.opensearch.test.OpenSearchTestCase;
        AtomicBoolean first = new AtomicBoolean(true);
 * the Apache License, Version 2.0 (the "License"); you may
            tcpReuseAddress,
    private ByteBuffer ioBuffer = ByteBuffer.allocate(1024);
        assertEquals(1, flushOperation.getBuffersToWrite().length);
            if (randomBoolean()) {
        public void flushChannel() throws IOException {
            tcpKeepInterval,
import java.nio.ByteBuffer;
        if (isAccepted) {
        boolean tcpNoDelay = randomBoolean();
        when(rawChannel.read(any(ByteBuffer[].class), anyInt(), anyInt())).thenThrow(new IOException());
    public void testCloseClosesWriteProducer() throws IOException {
        try (SocketChannel realChannel = SocketChannel.open()) {
        context.connect();
        when(rawChannel.read(any(ByteBuffer.class))).thenThrow(new IOException());
        }
        InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
        try (SocketChannel realChannel = SocketChannel.open()) {
            ioBuffer.clear();
                throw new AssertionError("Connection should not succeed");
        int tcpSendBufferSize = randomIntBetween(1000, 2000);
    public void testIOExceptionSetIfEncountered() throws IOException {
        assertFalse(context.isConnectComplete());
        @Override
            BytesChannelContext context = new BytesChannelContext(
        }
 */
                b.put((byte) 1);
            when(channel.isOpen()).thenReturn(true);
        expectThrows(IOException.class, context::connect);
        }
    }
                selector,
            BiConsumer<Void, Exception> listener2 = mock(BiConsumer.class);
        context.sendMessage(buffers, listener);
        assertEquals(0, channelBuffer.getIndex());
        assertSame(writeOperation, writeOp);
            InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
        InetSocketAddress address = mock(InetSocketAddress.class);
        InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
        TestSocketChannelContext context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, buffer, config);
        verify(rawSocket).setReceiveBufferSize(tcpReceiveBufferSize);
    }
            randomBoolean()
        when(rawChannel.write(any(ByteBuffer[].class), anyInt(), anyInt())).thenThrow(new IOException());
        verify(rawSocket).setKeepAlive(tcpKeepAlive);
            } else {
        assertEquals(0, channelBuffer.getIndex());
        assertFalse(context.readyForFlush());
            when(channel.isOpen()).thenReturn(true);
    }
    }
 */
        channel = mock(NioSocketChannel.class);
            assertFalse(context.readyForFlush());
        };
        assertEquals(ioBuffer.capacity(), channelBuffer.getIndex());
 * KIND, either express or implied.  See the License for the
    private Answer<Object> consumeBufferAnswer(int bytesToConsume) {
        AtomicBoolean first = new AtomicBoolean(true);
        boolean isAccepted = randomBoolean();
        boolean tcpReuseAddress = randomBoolean();
        }
            InboundChannelBuffer channelBuffer
        }
            -1,
            when(channel.getRawChannel()).thenReturn(realChannel);
            flushToChannel(new FlushOperation(byteBuffers, (v, e) -> {}));
        assertSame(ioException, exception.get());
            when(channel.isOpen()).thenReturn(true);
import java.net.Socket;
                exception.set(t);
    private Consumer<Exception> exceptionHandler;
        InboundChannelBuffer channelBuffer = InboundChannelBuffer.allocatingInstance();
 *
        context.flushToChannel(flushOperation);
        when(rawChannel.finishConnect()).thenReturn(true);
 * this file be licensed under the Apache-2.0 license or a
                return consumeBufferAnswer(1024).answer(invocationOnMock);
        FlushOperation flushOperation = new FlushOperation(buffers, listener);
            verify(handler).close();
import static org.mockito.Mockito.isNull;
        ) {
            randomBoolean(),
            when(handler.pollFlushOperations()).thenReturn(
import java.io.IOException;
            tcpKeepCount,
        int tcpReceiveBufferSize = randomIntBetween(1000, 2000);
            } else {
            tcpSendBufferSize,
        return invocationOnMock -> {
            b.position(b.position() + bytesToConsume);
            int bytesRead = b.remaining();
        return invocationOnMock -> {
        }
    public void testReadToChannelBufferHandlesIOException() throws IOException {
    public void testSendMessageFromSameThreadIsQueuedInChannel() {
        when(handler.createWriteOperation(context, buffers, listener)).thenReturn(writeOperation);
            if (t == null) {
            NioSocketChannel channel,
        assertTrue(context.closeNow());
        int bytesRead = context.readFromChannel(channelBuffer);
    }
        }
        InboundChannelBuffer buffer = InboundChannelBuffer.allocatingInstance();
    public void testFlushOpsClearedOnClose() throws Exception {
        int tcpKeepIdle = randomIntBetween(1, 1000);
            context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, channelBuffer);
    public void testSendMessageFromDifferentThreadIsQueuedWithSelector() throws Exception {
        expectThrows(IOException.class, () -> context.flushToChannel(flushOperation));
        assertSame(writeOperation, writeOp);
            address,
        config = new Config.Socket(
                listenerCalled.compareAndSet(false, true);
                Arrays.asList(new FlushOperation(buffer, listener), new FlushOperation(buffer, listener2))
 * ownership. Elasticsearch licenses this file to you under
        verify(rawSocket).setReceiveBufferSize(tcpReceiveBufferSize);
                channel,
import java.util.Collections;
        private TestSocketChannelContext(
            when(channel.getRawChannel()).thenReturn(realChannel);
 * not use this file except in compliance with the License.
            context.queueWriteOperation(writeOperation);
            assertFalse(context.readyForFlush());
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.nio.channels.SocketChannel;
    public void testReadToChannelBufferWillReadAsMuchAsIOBufferAllows() throws IOException {
            }
        context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, channelBuffer);
public class SocketChannelContextTests extends OpenSearchTestCase {
    }
            }
 * Unless required by applicable law or agreed to in writing,
        @Override
        @Override
import java.net.SocketException;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.times;
    private NioSocketChannel channel;
import java.util.concurrent.atomic.AtomicReference;
        assertTrue(context.readyForFlush());
        ArgumentCaptor<WriteOperation> writeOpCaptor = ArgumentCaptor.forClass(WriteOperation.class);
        context.flushToChannel(flushOperation);
        AtomicReference<Exception> exception = new AtomicReference<>();
    }
 * Modifications Copyright OpenSearch Contributors. See
            InboundChannelBuffer buffer = InboundChannelBuffer.allocatingInstance();
    }
import java.util.function.BiConsumer;
            ByteBuffer[] byteBuffers = { ByteBuffer.allocate(10) };
            if (first.compareAndSet(true, false)) {
        verify(rawSocket, times(2)).setReuseAddress(tcpReuseAddress);
            if (t == null) {
        IOException ioException = new IOException("boom");
 *
 * SPDX-License-Identifier: Apache-2.0
        try (SocketChannel realChannel = SocketChannel.open()) {
        assertTrue(context.closeNow());
    }
        verify(selector).queueWrite(writeOpCaptor.capture());
        FlushOperation flushOperation = new FlushOperation(buffers, listener);
import org.junit.Before;
        );
            verify(closer).run();
        ByteBuffer[] buffers = { ByteBuffer.wrap(createMessage(10)) };
            return bytesRead;
            randomBoolean(),
        when(channel.getRawChannel()).thenReturn(rawChannel);
        assertTrue(context.isConnectComplete());
        return new Config.Socket(
        assertTrue(listenerCalled.get());
        assertFalse(context.closeNow());
        int tcpKeepInterval = randomIntBetween(1, 1000);
        assertFalse(context.isConnectComplete());
        }
        ByteBuffer[] buffers = { ByteBuffer.allocate(1023), ByteBuffer.allocate(1023) };
        when(rawChannel.read(any(ByteBuffer.class))).thenThrow(new IOException());
            NioSelector selector,
        }
            verify(selector, times(1)).executeFailedListener(same(listener2), any(ClosedChannelException.class));
            ByteBuffer[] buffer = { ByteBuffer.allocate(10) };
        context.readFromChannel(channelBuffer);
        when(handler.pollFlushOperations()).thenReturn(Collections.singletonList(mock(FlushOperation.class)));
    @Before
        assertTrue(context.closeNow());
    private SocketChannel rawChannel;
        WriteOperation writeOp = writeOpCaptor.getValue();
            );
/*
import java.util.function.IntFunction;
            } else {
    }
    }
            -1,
            while (b.hasRemaining()) {
            InboundChannelBuffer channelBuffer,
        assertTrue(context.closeNow());
    public void testFlushBuffersHandlesIOExceptionSecondTimeThroughLoop() throws IOException {
        when(rawChannel.read(any(ByteBuffer.class))).thenAnswer(completelyFillBufferAnswer());
        when(selector.getIoBuffer()).thenAnswer(invocationOnMock -> {
        });
    public void testReadToChannelBufferHandlesEOF() throws IOException {
        int tcpKeepInterval = randomIntBetween(1, 1000);
        when(rawChannel.write(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {
            Config.Socket config
            verify(rawChannel).connect(same(address));
                return consumeBufferAnswer(1024).answer(invocationOnMock);
        context.channelActive();
        assertTrue(context.readyForFlush());
        verify(rawSocket).setSendBufferSize(tcpSendBufferSize);
    public void testCloseClosesChannelBuffer() throws IOException {
        context.sendMessage(buffers, listener);
            tcpKeepAlive,
    }
    }
                return consumeBufferAnswer(1024).answer(invocationOnMock);
        public boolean selectorShouldClose() {
        ByteBuffer[] buffers = { ByteBuffer.wrap(createMessage(10)) };
        ByteBuffer[] buffers = { ByteBuffer.allocate(1023), ByteBuffer.allocate(1023) };
            TestSocketChannelContext context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, buffer);
                exceptionHandler,
        ByteBuffer[] buffers = { ByteBuffer.allocate(1023), ByteBuffer.allocate(1023) };
    public void setup() throws Exception {
            context.closeFromSelector();
        when(rawChannel.socket()).thenReturn(rawSocket);
            tcpKeepInterval,
        });
            return bytesToConsume;
                throw new AssertionError("Connection should not fail");
    public void testWriteIsQueuedInChannel() {
        assertFalse(context.isConnectComplete());
 * this work for additional information regarding copyright
        when(selector.isOnCurrentThread()).thenReturn(true);
 *
        when(rawChannel.write(any(ByteBuffer.class))).thenAnswer(consumeBufferAnswer(0));
            tcpKeepAlive,
            tcpReuseAddress,
            );
import java.util.concurrent.atomic.AtomicBoolean;
        when(rawChannel.finishConnect()).thenReturn(false, true);
            return ioBuffer;
            verify(selector, times(1)).executeFailedListener(same(listener), any(ClosedChannelException.class));
        when(handler.createWriteOperation(context, buffers, listener)).thenReturn(writeOperation);
                handler,
    @SuppressWarnings("unchecked")
    private static Config.Socket getSocketConfig() {
                throw new IOException();
        expectThrows(IOException.class, () -> context.flushToChannel(flushOperation));
            tcpReceiveBufferSize,
        ByteBuffer[] buffers = { ByteBuffer.allocate(1023), ByteBuffer.allocate(1023) };
        context.addConnectListener((v, t) -> {
        verify(rawSocket).setSendBufferSize(tcpSendBufferSize);
        @Override
        WriteOperation writeOperation = mock(WriteOperation.class);
import static org.mockito.Mockito.same;
    private static class TestSocketChannelContext extends SocketChannelContext {
        when(selector.isOnCurrentThread()).thenReturn(false);
 * specific language governing permissions and limitations
    public void testWriteFailsIfClosing() {
        context.addConnectListener((v, t) -> {
        }
            randomBoolean(),
    public void testConnectFails() throws IOException {
        rawSocket = mock(Socket.class);
    }
/*
        config = new Config.Socket(
    }
        );
            -1,
        });
            }
            tcpNoDelay,
        boolean tcpKeepAlive = randomBoolean();
            if (first.compareAndSet(true, false)) {
            return readFromChannel(channelBuffer);
            } else {
            IntFunction<Page> pageAllocator = (n) -> new Page(ByteBuffer.allocate(n), closer);
    private TestSocketChannelContext context;
        );
        InboundChannelBuffer buffer = InboundChannelBuffer.allocatingInstance();
import static org.mockito.Mockito.when;
import java.util.Arrays;
        context.queueWriteOperation(writeOperation);
                context.read();
        int tcpKeepCount = randomIntBetween(1, 1000);
            assertTrue(context.readyForFlush());
            super(channel, selector, config, exceptionHandler, readWriteHandler, channelBuffer);
            ByteBuffer b = (ByteBuffer) invocationOnMock.getArguments()[0];
}
        };
        assertTrue(context.closeNow());
            assertFalse(context.readyForFlush());
                context.flushChannel();
        context.register();
                return consumeBufferAnswer(1022).answer(invocationOnMock);
        FlushReadyWrite writeOperation = new FlushReadyWrite(context, buffer, listener);
        ) {
        verify(handler).channelActive();
import static org.mockito.Mockito.mock;
        assertFalse(context.connect());
            ByteBuffer[] buffer = { ByteBuffer.allocate(10) };
 * The OpenSearch Contributors require contributions made to
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        when(rawSocket.getChannel()).thenReturn(rawChannel);
        assertTrue(flushOperation.isFullyFlushed());
    }
    }
        verify(listener).accept(isNull(), any(ClosedChannelException.class));
        }
        boolean tcpReuseAddress = randomBoolean();
            verify(selector, times(1)).executeFailedListener(same(listener), any(ClosedChannelException.class));
            when(channel.getRawChannel()).thenReturn(realChannel);
        selector = mock(NioSelector.class);
            false
        assertFalse(context.connect());
        context.read();
    private Socket rawSocket;
            verify(rawChannel, times(0)).connect(any(InetSocketAddress.class));
        AtomicBoolean first = new AtomicBoolean(true);
            }
            WriteOperation writeOperation = mock(WriteOperation.class);
    private NioSelector selector;
    public void testFlushBuffersHandlesFullFlush() throws IOException {
                mock(Config.Socket.class),
        boolean tcpKeepAlive = randomBoolean();
        when(rawChannel.finishConnect()).thenReturn(false).thenThrow(ioException);
 * GitHub history for details.
 * compatible open source license.
            tcpKeepIdle,
            -1,
    public void testFlushBuffersHandlesZeroFlush() throws IOException {
                return consumeBufferAnswer(3).answer(invocationOnMock);
            context.closeFromSelector();
            // We do not want to call the actual register with selector method as it will throw a NPE
            Consumer<Exception> exceptionHandler,
        assertEquals(2, flushOperation.getBuffersToWrite().length);
        TestSocketChannelContext context = new TestSocketChannelContext(channel, selector, exceptionHandler, handler, buffer, config);
        verify(rawSocket).setReuseAddress(tcpReuseAddress);
        listener = mock(BiConsumer.class);
    }
    private NioChannelHandler handler;
            } else {
        WriteOperation writeOperation = mock(WriteOperation.class);
 * license agreements. See the NOTICE file distributed with
        context.flushToChannel(flushOperation);
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
        when(rawChannel.write(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {
            bytes[i] = randomByte();
    }
import java.nio.channels.ClosedChannelException;
        context.sendMessage(buffers, listener);
        context.closeChannel();
    @SuppressWarnings({ "unchecked", "varargs" })
 * under the License.
    public void testHandleReadBytesWillCheckForNewFlushOperations() throws IOException {
            return isClosing.get();
        verify(rawSocket).setKeepAlive(tcpKeepAlive);
        when(rawChannel.write(any(ByteBuffer.class))).thenThrow(new IOException());
        expectThrows(IOException.class, () -> {
        when(rawChannel.write(any(ByteBuffer.class))).thenThrow(new IOException());
 * Licensed to Elasticsearch under one or more contributor
    }
    }
            mock(InetSocketAddress.class),
        verify(rawSocket).setTcpNoDelay(tcpNoDelay);
        return bytes;
        });
            NioSelector selector,
            }
        assertNull(exception.get());
    private static byte[] createMessage(int length) {
        assertEquals(4, flushOperation.getBuffersToWrite()[0].position());
    public void testFlushBuffersHandlesPartialFlush() throws IOException {
        });
    }
        assertEquals(1, flushOperation.getBuffersToWrite()[0].position());
        InetSocketAddress address = mock(InetSocketAddress.class);
        assertEquals(ioBuffer.capacity(), bytesRead);
        } else {
 * software distributed under the License is distributed on an
        for (int i = 0; i < length; ++i) {
            if (first.compareAndSet(true, false)) {
            NioChannelHandler readWriteHandler,
            Runnable closer = mock(Runnable.class);
        try (SocketChannel realChannel = SocketChannel.open()) {
        boolean tcpNoDelay = randomBoolean();
            }
        int tcpKeepCount = randomIntBetween(1, 1000);
        verify(rawSocket).setTcpNoDelay(tcpNoDelay);
        @Override
        });
    public void testRegisterInitiatesConnect() throws IOException {
    @SuppressWarnings({ "unchecked", "varargs" })
        FlushOperation flushOperation = new FlushOperation(buffers, listener);
import static org.mockito.Mockito.any;
    }
            buffer.ensureCapacity(1);
        assertTrue(context.connect());
        }
            tcpKeepIdle,
    }
    public void testSignalWhenPeerClosed() throws IOException {
            tcpKeepCount,
        when(rawChannel.read(any(ByteBuffer.class))).thenReturn(-1);
        rawChannel = mock(SocketChannel.class);
        Config.Socket config;
    }
            context.closeFromSelector();
import java.util.function.Consumer;
            } else {
        int tcpSendBufferSize = randomIntBetween(1000, 2000);
        super.setUp();
        when(rawChannel.write(any(ByteBuffer.class))).thenAnswer(invocationOnMock -> {
import static org.mockito.Mockito.verify;
    public void testChannelActiveCallsHandler() throws IOException {
            tcpSendBufferSize,
 * You may obtain a copy of the License at
        ByteBuffer[] buffers = { ByteBuffer.allocate(10), ByteBuffer.allocate(10) };
            tcpNoDelay,
        FlushOperation flushOperation = new FlushOperation(buffers, listener);
