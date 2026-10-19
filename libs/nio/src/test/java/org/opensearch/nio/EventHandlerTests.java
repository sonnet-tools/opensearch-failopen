    }  
    public void testActiveNonServerAddsOP_CONNECTAndOP_READInterest() throws IOException {  
        handler.handleRegistration(channelContext);
        NioSocketChannel channel = new NioSocketChannel(rawChannel);
    private DoNotRegisterSocketContext context;
    }
        SocketChannelContext context = mock(SocketChannelContext.class);
    private NioChannelHandler readWriteHandler;  
    }
        handler.taskException(exception);  
        handler.handleConnect(context);
        SocketChannelContext context = mock(SocketChannelContext.class);
        NioSocketChannel channel = mock(NioSocketChannel.class);  
            -1,  
    public void testWriteExceptionCallsExceptionHandler() {  
        when(rawChannel.finishConnect()).thenReturn(true);  
            -1,
        handler.handleTask(() -> isRun.set(true));  
        AtomicBoolean isRun = new AtomicBoolean(false);
        SocketChannelContext context = mock(SocketChannelContext.class);
    public void setUpHandler() throws IOException {  
        handler.postHandling(context);
        Socket socket = mock(Socket.class);
    }  
        verify(genericExceptionHandler).accept(exception);
        verify(channelExceptionHandler).accept(exception);  
public class EventHandlerTests extends OpenSearchTestCase {
}
        NioSocketChannel channel = mock(NioSocketChannel.class);
            NioChannelHandler handler
            setSelectionKey(selectionKey);  
        assertEquals(SelectionKey.OP_READ | SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE, context.getSelectionKey().interestOps());  
 * not use this file except in compliance with the License.
        TestSelectionKey key = new TestSelectionKey(SelectionKey.OP_READ | SelectionKey.OP_WRITE);  
        verify(channelExceptionHandler).accept(exception);  
    }
 * license agreements. See the NOTICE file distributed with
        IOException exception = new IOException();
        selectorSupplier = new RoundRobinSupplier<>(selectors.toArray(new NioSelector[0]));
        NioSocketChannel channel = mock(NioSocketChannel.class);
        serverContext = new DoNotRegisterServerContext(serverChannel, mock(NioSelector.class), mock(Consumer.class));  
 */  
    }
    }
        assertEquals(SelectionKey.OP_READ, context.getSelectionKey().interestOps());  
            setSelectionKey(new TestSelectionKey(0));  
 * this file be licensed under the Apache-2.0 license or a
        }
        }
 * The OpenSearch Contributors require contributions made to  
        NioSelector selector = mock(NioSelector.class);
    private static Config.Socket getSocketConfig() {  
        when(context.selectorShouldClose()).thenReturn(true);
        selectors.add(selector);
 * specific language governing permissions and limitations
        when(channel.getContext()).thenReturn(context);
        DoNotRegisterSocketContext(  
    }  
    public void testHandleServerActiveSetsOP_ACCEPTInterest() throws IOException {
 * this work for additional information regarding copyright
    private class DoNotRegisterSocketContext extends BytesChannelContext {
import java.util.concurrent.atomic.AtomicBoolean;
        verify(context).read();  
        SelectionKeyUtils.setConnectAndReadInterested(context.getSelectionKey());
        ServerSocketChannel serverSocketChannel = mock(ServerSocketChannel.class);  
        handler.postHandling(context);  
        TestSelectionKey selectionKey = new TestSelectionKey(SelectionKey.OP_READ);
        }
        when(channel.getContext()).thenReturn(context);
        public void register() {
    @SuppressWarnings("unchecked")
            selectionKey.attach(this);
    }
            selectionKey.attach(this);
    public void testRegistrationExceptionCallsExceptionHandler() throws IOException {  
        handler.handleActive(serverContext);
        public void register() {
        when(serverContext.getSelectionKey()).thenReturn(new TestSelectionKey(0));  
        handler.postHandling(context);  
        handler.acceptChannel(serverChannelContext);  
        assertEquals(SelectionKey.OP_READ | SelectionKey.OP_WRITE, selectionKey.interestOps());
    private EventHandler handler;
        handler.handleActive(context);
    private DoNotRegisterServerContext serverContext;  
import java.nio.channels.SelectionKey;  
    public void testReadExceptionCallsExceptionHandler() {  
        assertEquals(SelectionKey.OP_READ, selectionKey.interestOps());  
        handler.handleRead(context);
        when(context.getSelectionKey()).thenReturn(key);
    }
    private Consumer<Exception> channelExceptionHandler;  
        genericExceptionHandler = mock(Consumer.class);
 * the Apache License, Version 2.0 (the "License"); you may
        ServerChannelContext serverContext = mock(ServerChannelContext.class);
        verify(channelExceptionHandler).accept(exception);  
        ChannelContext<?> channelContext = randomBoolean() ? mock(SocketChannelContext.class) : mock(ServerChannelContext.class);
        channelFactory = mock(ChannelFactory.class);
import static org.mockito.Mockito.mock;
        TestSelectionKey attachment = new TestSelectionKey(0);
    public void testConnectExceptionCallsExceptionHandler() throws IOException {  
        handler.handleConnect(context);
 * Unless required by applicable law or agreed to in writing,
    public void testActiveWithPendingWritesAddsOP_CONNECTAndOP_READAndOP_WRITEInterest() throws IOException {
        when(channelContext.getSelectionKey()).thenReturn(attachment);  
import java.io.IOException;
    }  
    public void testRegisterCallsContext() throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
    public void testConnectDoesNotRemoveOP_CONNECTInterestIfIncomplete() throws IOException {  
    public void testPostHandlingCallWillNotCloseTheChannelIfNotReady() throws IOException {
 *
        when(channel.getContext()).thenReturn(context);  
        when(channel.getContext()).thenReturn(context);
    }
            randomBoolean()
        channel.setContext(context);  
    private ChannelFactory<NioServerSocketChannel, NioSocketChannel> channelFactory;
        verify(context, times(0)).closeFromSelector();  
import static org.mockito.Mockito.verify;
    public void testHandleTaskWillRunTask() throws Exception {
    public void testConnectRemovesOP_CONNECTInterestIfComplete() throws IOException {  
    private RoundRobinSupplier<NioSelector> selectorSupplier;
 * SPDX-License-Identifier: Apache-2.0
        handler.handleRegistration(context);
import java.util.Collections;
/*
    public void testAcceptExceptionCallsExceptionHandler() throws IOException {
        when(socket.getChannel()).thenReturn(rawChannel);
        }
        verify(channelContext).register();  
        @Override  
            mock(InetSocketAddress.class),
 * Licensed to Elasticsearch under one or more contributor  
import static org.mockito.Mockito.when;
    }
        attachment.attach(channelContext);
    private static Config.ServerSocket getServerSocketConfig() {
        serverChannel.setContext(serverContext);
    public void testTaskExceptionWillCallExceptionHandler() throws Exception {
        assertTrue(isRun.get());
        ArrayList<NioSelector> selectors = new ArrayList<>();  
        return new Config.Socket(
        SelectionKeyUtils.setConnectAndReadInterested(context.getSelectionKey());
            super(channel, channelFactory, selector, getServerSocketConfig(), acceptor, mock(Consumer.class));  
            NioSelector selector,
        IOException exception = new IOException();
        when(selector.isOnCurrentThread()).thenReturn(true);  
        handler.postHandling(context);
        when(serverSocketChannel.socket()).thenReturn(mock(ServerSocket.class));
        SocketChannelContext context = mock(SocketChannelContext.class);  
        verify(serverChannelContext).acceptChannels(selectorSupplier);
        verify(context).closeFromSelector();
    public void testHandleAcceptAccept() throws IOException {  
        context = new DoNotRegisterSocketContext(channel, selector, channelExceptionHandler, readWriteHandler);
import java.nio.channels.ServerSocketChannel;
    private class DoNotRegisterServerContext extends ServerChannelContext {
 *  
        verify(channelExceptionHandler).accept(exception);  
        when(context.selectorShouldClose()).thenReturn(false);
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        NioServerSocketChannel serverChannel = new NioServerSocketChannel(serverSocketChannel);
    public void testPostHandlingWillAddWriteIfNecessary() throws IOException {  
        assertEquals(SelectionKey.OP_READ, context.getSelectionKey().interestOps());  
        assertEquals(SelectionKey.OP_READ | SelectionKey.OP_CONNECT, context.getSelectionKey().interestOps());
        handler.connectException(context, exception);
            NioSocketChannel channel,
        ServerChannelContext serverChannelContext = mock(ServerChannelContext.class);  
 * You may obtain a copy of the License at  
            -1,
    private Consumer<Exception> genericExceptionHandler;
        handler = new EventHandler(genericExceptionHandler, selectorSupplier);  
        when(readWriteHandler.writeToBytes(flushReadyWrite)).thenReturn(Collections.singletonList(flushReadyWrite));  
    }
import java.net.ServerSocket;  
    }
        handler.handleActive(context);  
import java.util.ArrayList;  
import org.opensearch.test.OpenSearchTestCase;
    }
import static org.mockito.Mockito.times;  
        IOException exception = new IOException();
        when(context.getSelectionKey()).thenReturn(new TestSelectionKey(0));
        DoNotRegisterServerContext(NioServerSocketChannel channel, NioSelector selector, Consumer<NioSocketChannel> acceptor) {
        readWriteHandler = mock(NioChannelHandler.class);  
        when(rawChannel.socket()).thenReturn(socket);  
import java.net.Socket;
    public void testPostHandlingWillRemoveWriteIfNecessary() throws IOException {
    }
 * GitHub history for details.
        IOException exception = new IOException();
            TestSelectionKey selectionKey = new TestSelectionKey(0);
        RuntimeException exception = new RuntimeException();
        );  
    }
        SocketChannel rawChannel = mock(SocketChannel.class);
        FlushReadyWrite flushReadyWrite = mock(FlushReadyWrite.class);
 * under the License.  
    public void testHandleReadDelegatesToContext() throws IOException {  
        channelExceptionHandler = mock(Consumer.class);
        handler.acceptException(serverChannelContext, exception);
/*  
        when(context.readyForFlush()).thenReturn(true);
 */  
            -1,  
        when(context.getSelectionKey()).thenReturn(new TestSelectionKey(SelectionKey.OP_READ | SelectionKey.OP_WRITE));
    }
 */
        verify(serverChannelContext).handleException(exception);
    @Before
        ) {
 *
    }
import org.junit.Before;
        NioSocketChannel channel = mock(NioSocketChannel.class);
    }
 * ownership. Elasticsearch licenses this file to you under  
        SocketChannelContext context = mock(SocketChannelContext.class);
        ServerChannelContext serverChannelContext = mock(ServerChannelContext.class);
            TestSelectionKey selectionKey = new TestSelectionKey(0);
        assertEquals(SelectionKey.OP_READ, key.interestOps());
        @SuppressWarnings("unchecked")
        SocketChannelContext context = mock(SocketChannelContext.class);
            Consumer<Exception> exceptionHandler,  
        when(context.readyForFlush()).thenReturn(false);  
        assertEquals(SelectionKey.OP_ACCEPT, serverContext.getSelectionKey().interestOps());  
    }
    }  
 * software distributed under the License is distributed on an
        handler.readException(context, exception);
        context.queueWriteOperation(flushReadyWrite);
import java.nio.channels.CancelledKeyException;
        return new Config.ServerSocket(randomBoolean(), mock(InetSocketAddress.class));  
            -1,
import java.nio.channels.SocketChannel;
        handler.writeException(context, exception);
/*  
        when(context.getSelectionKey()).thenReturn(selectionKey);  
        CancelledKeyException exception = new CancelledKeyException();
            randomBoolean(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            super(channel, selector, getSocketConfig(), exceptionHandler, handler, InboundChannelBuffer.allocatingInstance());  
import java.util.function.Consumer;  
            randomBoolean(),  
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override  
            randomBoolean(),
    }
package org.opensearch.nio;
    public void testPostHandlingCallWillCloseTheChannelIfReady() throws IOException {  
import java.net.InetSocketAddress;
        assertEquals(SelectionKey.OP_READ | SelectionKey.OP_WRITE, key.interestOps());
        handler.registrationException(context, exception);
