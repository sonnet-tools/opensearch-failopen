    }
        context.queueWriteOperation(flushReadyWrite);
        when(serverContext.getSelectionKey()).thenReturn(new TestSelectionKey(0));
        when(context.getSelectionKey()).thenReturn(new TestSelectionKey(0));
        readWriteHandler = mock(NioChannelHandler.class);
    public void testConnectDoesNotRemoveOP_CONNECTInterestIfIncomplete() throws IOException {
            -1,
        }
        verify(channelExceptionHandler).accept(exception);
 * under the License.
}
        verify(context).closeFromSelector();
        handler = new EventHandler(genericExceptionHandler, selectorSupplier);
        when(context.getSelectionKey()).thenReturn(key);
        NioSocketChannel channel = mock(NioSocketChannel.class);
        assertTrue(isRun.get());
        SocketChannelContext context = mock(SocketChannelContext.class);
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.nio;
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
import java.io.IOException;
        }
        ) {
import static org.mockito.Mockito.times;
            NioSelector selector,
        NioSelector selector = mock(NioSelector.class);
        handler.handleRead(context);
        NioServerSocketChannel serverChannel = new NioServerSocketChannel(serverSocketChannel);
            -1,
    public void testRegisterCallsContext() throws IOException {
        when(context.readyForFlush()).thenReturn(true);
        handler.acceptChannel(serverChannelContext);
    }
        SocketChannelContext context = mock(SocketChannelContext.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public void register() {
        when(context.getSelectionKey()).thenReturn(new TestSelectionKey(SelectionKey.OP_READ | SelectionKey.OP_WRITE));
        assertEquals(SelectionKey.OP_READ, context.getSelectionKey().interestOps());
            NioSocketChannel channel,
        assertEquals(SelectionKey.OP_READ, key.interestOps());
        assertEquals(SelectionKey.OP_READ | SelectionKey.OP_WRITE, selectionKey.interestOps());
        verify(channelExceptionHandler).accept(exception);
    public void testReadExceptionCallsExceptionHandler() {
        verify(channelExceptionHandler).accept(exception);
            NioChannelHandler handler
    }
        handler.handleRegistration(channelContext);
        CancelledKeyException exception = new CancelledKeyException();
        AtomicBoolean isRun = new AtomicBoolean(false);
 * Modifications Copyright OpenSearch Contributors. See
import java.nio.channels.CancelledKeyException;
public class EventHandlerTests extends OpenSearchTestCase {
        @SuppressWarnings("unchecked")
        SocketChannelContext context = mock(SocketChannelContext.class);
        verify(context, times(0)).closeFromSelector();
        when(channel.getContext()).thenReturn(context);
        handler.handleConnect(context);
        when(channel.getContext()).thenReturn(context);
            super(channel, channelFactory, selector, getServerSocketConfig(), acceptor, mock(Consumer.class));
    }
        SelectionKeyUtils.setConnectAndReadInterested(context.getSelectionKey());
        SocketChannelContext context = mock(SocketChannelContext.class);
        Socket socket = mock(Socket.class);
 * The OpenSearch Contributors require contributions made to
        TestSelectionKey key = new TestSelectionKey(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        assertEquals(SelectionKey.OP_READ | SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE, context.getSelectionKey().interestOps());
 * Unless required by applicable law or agreed to in writing,
    public void testPostHandlingWillAddWriteIfNecessary() throws IOException {
        when(context.selectorShouldClose()).thenReturn(true);
    }
    public void testHandleReadDelegatesToContext() throws IOException {
 */
    }
 *
import java.util.ArrayList;
import java.net.InetSocketAddress;
    @Before
        ArrayList<NioSelector> selectors = new ArrayList<>();
 * GitHub history for details.
        when(readWriteHandler.writeToBytes(flushReadyWrite)).thenReturn(Collections.singletonList(flushReadyWrite));
        genericExceptionHandler = mock(Consumer.class);
            -1,
        SocketChannelContext context = mock(SocketChannelContext.class);
    public void testPostHandlingCallWillCloseTheChannelIfReady() throws IOException {
    }
        NioSocketChannel channel = mock(NioSocketChannel.class);
import static org.mockito.Mockito.verify;
        assertEquals(SelectionKey.OP_READ, selectionKey.interestOps());
            TestSelectionKey selectionKey = new TestSelectionKey(0);
 * You may obtain a copy of the License at
    public void testHandleTaskWillRunTask() throws Exception {
        assertEquals(SelectionKey.OP_READ, context.getSelectionKey().interestOps());
    }
    public void testConnectExceptionCallsExceptionHandler() throws IOException {
        when(channel.getContext()).thenReturn(context);
 *
        when(channelContext.getSelectionKey()).thenReturn(attachment);
 * software distributed under the License is distributed on an
        handler.handleActive(context);
        IOException exception = new IOException();
    }
        ServerSocketChannel serverSocketChannel = mock(ServerSocketChannel.class);
    }
        ChannelContext<?> channelContext = randomBoolean() ? mock(SocketChannelContext.class) : mock(ServerChannelContext.class);
        handler.handleTask(() -> isRun.set(true));
        handler.connectException(context, exception);
    }
        TestSelectionKey attachment = new TestSelectionKey(0);
        when(serverSocketChannel.socket()).thenReturn(mock(ServerSocket.class));
        when(context.getSelectionKey()).thenReturn(selectionKey);
    private ChannelFactory<NioServerSocketChannel, NioSocketChannel> channelFactory;
        handler.handleRegistration(context);
import java.nio.channels.SelectionKey;
        when(channel.getContext()).thenReturn(context);
            selectionKey.attach(this);
        verify(genericExceptionHandler).accept(exception);
    private Consumer<Exception> channelExceptionHandler;
import java.util.function.Consumer;
    public void testWriteExceptionCallsExceptionHandler() {
    public void testAcceptExceptionCallsExceptionHandler() throws IOException {
            setSelectionKey(selectionKey);
    public void testRegistrationExceptionCallsExceptionHandler() throws IOException {
        verify(serverChannelContext).acceptChannels(selectorSupplier);
        handler.handleActive(context);
        FlushReadyWrite flushReadyWrite = mock(FlushReadyWrite.class);
    @SuppressWarnings("unchecked")
        handler.postHandling(context);
    public void testHandleServerActiveSetsOP_ACCEPTInterest() throws IOException {
    public void testHandleAcceptAccept() throws IOException {
        handler.taskException(exception);
        when(socket.getChannel()).thenReturn(rawChannel);
        context = new DoNotRegisterSocketContext(channel, selector, channelExceptionHandler, readWriteHandler);
    }
        selectors.add(selector);
        ServerChannelContext serverChannelContext = mock(ServerChannelContext.class);
    private static Config.ServerSocket getServerSocketConfig() {
    private static Config.Socket getSocketConfig() {
    public void testActiveNonServerAddsOP_CONNECTAndOP_READInterest() throws IOException {
import java.util.concurrent.atomic.AtomicBoolean;
    private RoundRobinSupplier<NioSelector> selectorSupplier;
        verify(serverChannelContext).handleException(exception);
    }
        assertEquals(SelectionKey.OP_READ | SelectionKey.OP_CONNECT, context.getSelectionKey().interestOps());
        handler.postHandling(context);
    }
            selectionKey.attach(this);
    public void testPostHandlingCallWillNotCloseTheChannelIfNotReady() throws IOException {
import java.net.ServerSocket;
            TestSelectionKey selectionKey = new TestSelectionKey(0);
    public void setUpHandler() throws IOException {
/*
        when(selector.isOnCurrentThread()).thenReturn(true);
        verify(channelContext).register();
        @Override
            -1,
        attachment.attach(channelContext);
        DoNotRegisterServerContext(NioServerSocketChannel channel, NioSelector selector, Consumer<NioSocketChannel> acceptor) {
import static org.mockito.Mockito.when;
        IOException exception = new IOException();
    }
        verify(context).read();
 * ownership. Elasticsearch licenses this file to you under
        serverChannel.setContext(serverContext);
 * license agreements. See the NOTICE file distributed with
    public void testTaskExceptionWillCallExceptionHandler() throws Exception {
    }
import org.junit.Before;
    }
        assertEquals(SelectionKey.OP_ACCEPT, serverContext.getSelectionKey().interestOps());
        handler.acceptException(serverChannelContext, exception);
        verify(channelExceptionHandler).accept(exception);
        channelFactory = mock(ChannelFactory.class);
        public void register() {
            randomBoolean(),
import java.util.Collections;
        ServerChannelContext serverContext = mock(ServerChannelContext.class);
    }
        channelExceptionHandler = mock(Consumer.class);
 * not use this file except in compliance with the License.
    public void testConnectRemovesOP_CONNECTInterestIfComplete() throws IOException {
        SocketChannelContext context = mock(SocketChannelContext.class);
        IOException exception = new IOException();
        }
        NioSocketChannel channel = new NioSocketChannel(rawChannel);
            randomBoolean()
        handler.writeException(context, exception);
            randomBoolean(),
import java.nio.channels.SocketChannel;
/*
    }
 * compatible open source license.
    public void testPostHandlingWillRemoveWriteIfNecessary() throws IOException {
        serverContext = new DoNotRegisterServerContext(serverChannel, mock(NioSelector.class), mock(Consumer.class));
        return new Config.ServerSocket(randomBoolean(), mock(InetSocketAddress.class));
        DoNotRegisterSocketContext(
    private DoNotRegisterSocketContext context;
        NioSocketChannel channel = mock(NioSocketChannel.class);
        ServerChannelContext serverChannelContext = mock(ServerChannelContext.class);
        SelectionKeyUtils.setConnectAndReadInterested(context.getSelectionKey());
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.test.OpenSearchTestCase;
        handler.postHandling(context);
        handler.registrationException(context, exception);
            -1,
        );
        RuntimeException exception = new RuntimeException();
    public void testActiveWithPendingWritesAddsOP_CONNECTAndOP_READAndOP_WRITEInterest() throws IOException {
    }
import static org.mockito.Mockito.mock;
        when(context.selectorShouldClose()).thenReturn(false);
    }
    }
 *
    private Consumer<Exception> genericExceptionHandler;
            setSelectionKey(new TestSelectionKey(0));
        handler.readException(context, exception);
        SocketChannel rawChannel = mock(SocketChannel.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new Config.Socket(
        }
            Consumer<Exception> exceptionHandler,
 * the Apache License, Version 2.0 (the "License"); you may
        IOException exception = new IOException();
    private EventHandler handler;
        @Override
            randomBoolean(),
        when(rawChannel.finishConnect()).thenReturn(true);
    private class DoNotRegisterServerContext extends ServerChannelContext {
 * this file be licensed under the Apache-2.0 license or a
    private NioChannelHandler readWriteHandler;
        selectorSupplier = new RoundRobinSupplier<>(selectors.toArray(new NioSelector[0]));
    }
import java.net.Socket;
        NioSocketChannel channel = mock(NioSocketChannel.class);
        handler.handleConnect(context);
        handler.postHandling(context);
    private class DoNotRegisterSocketContext extends BytesChannelContext {
    }
            mock(InetSocketAddress.class),
    private DoNotRegisterServerContext serverContext;
 */
        when(rawChannel.socket()).thenReturn(socket);
 */
        assertEquals(SelectionKey.OP_READ | SelectionKey.OP_WRITE, key.interestOps());
        TestSelectionKey selectionKey = new TestSelectionKey(SelectionKey.OP_READ);
/*
            super(channel, selector, getSocketConfig(), exceptionHandler, handler, InboundChannelBuffer.allocatingInstance());
import java.nio.channels.ServerSocketChannel;
        handler.handleActive(serverContext);
        channel.setContext(context);
        when(context.readyForFlush()).thenReturn(false);
 * KIND, either express or implied.  See the License for the
