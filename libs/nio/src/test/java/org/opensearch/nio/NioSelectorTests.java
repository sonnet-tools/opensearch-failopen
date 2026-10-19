    }
        when(rawSelector.isOpen()).thenReturn(true);
import java.nio.channels.ClosedChannelException;  
    public void testClosedSocketChannelWillNotBeRegistered() throws Exception {
        when(serverChannelContext.getSelector()).thenReturn(selector);  
        selector.singleLoop();
            verify(rawSelector).select(captor.capture());  
import org.opensearch.common.unit.TimeValue;
/*  
        when(serverChannelContext.isOpen()).thenReturn(true);
    }  
/*  
import static org.mockito.Mockito.any;  
        } catch (ClosedSelectorException e) {
        verify(eventHandler, times(0)).handleWrite(channelContext);
        serverChannelContext = mock(ServerChannelContext.class);  
        verify(eventHandler, times(0)).postHandling(channelContext);  
        selectionKey.attach(channelContext);
        IOException ioException = new IOException();  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        verify(eventHandler).handleRead(channelContext);
        verify(eventHandler).handleConnect(channelContext);
        when(channelContext.isConnectComplete()).thenReturn(true);
        assertTrue(closedSelectorExceptionCaught);  
        selector.preSelect();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        when(serverChannelContext.getSelectionKey()).thenReturn(selectionKey);
    private BiConsumer<Void, Exception> listener;
        channelContext = mock(SocketChannelContext.class);
public class NioSelectorTests extends OpenSearchTestCase {
import static org.mockito.Mockito.times;
    public void testReadEventWithException() throws Exception {
        assertTrue(isRun.get());
        executeOnNewThread(() -> selector.scheduleForRegistration(serverChannel));  
        selectionKey.setReadyOps(SelectionKey.OP_CONNECT);  
            this.selector.singleLoop();
    }  
        try {  
            @Override
        when(context.getSelector()).thenReturn(selector);
        NioSocketChannel unregisteredChannel = mock(NioSocketChannel.class);
    public void testShouldFlushIfNoPendingFlushes() throws Exception {  
    public void testAcceptException() throws IOException {
    }  
import static org.mockito.Mockito.mock;
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            selector.singleLoop();
 * Modifications Copyright OpenSearch Contributors. See
    public void testQueueWriteChannelIsClosed() throws Exception {
    }
        testSelectionKey.attach(channelContext);
    private TestSelectionKey selectionKey;
 * Unless required by applicable law or agreed to in writing,
            selector.preSelect();
        verify(channelContext, times(0)).queueWriteOperation(writeOperation);
        verify(eventHandler).handleRegistration(serverChannelContext);
import java.util.concurrent.TimeUnit;  
import java.io.IOException;
        selectionKey.setReadyOps(SelectionKey.OP_READ);
        executeOnNewThread(() -> selector.queueWrite(writeOperation));  
import static org.mockito.Mockito.doAnswer;
        selector.preSelect();
        when(channelContext.readyForFlush()).thenReturn(false);  
        ClosedChannelException closedChannelException = new ClosedChannelException();
        verify(eventHandler).postHandling(channelContext);
        when(channelContext.isOpen()).thenReturn(false);
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testSelectorTimeoutWillBeReducedIfTaskSooner() throws Exception {
        verify(eventHandler).registrationException(same(serverChannelContext), any(ClosedChannelException.class));
        Runnable task = () -> { throw taskException; };
        selectionKey.setReadyOps(SelectionKey.OP_READ);
        when(channelContext.isOpen()).thenReturn(true);
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
            closedSelectorExceptionCaught = true;  
    public void testConnectEventFinishThrowException() throws Exception {
 * You may obtain a copy of the License at  
        selector.scheduleForRegistration(channel);
        verify(eventHandler).handleClose(channelContext);
    @Before  
        verify(channelContext, times(0)).queueWriteOperation(writeOperation);
import static org.mockito.Mockito.doThrow;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.mockito.Mockito.when;  
        when(channelContext.readyForFlush()).thenReturn(false);
    public void testSuccessfulWriteEvent() throws Exception {
        doThrow(ioException).when(eventHandler).acceptChannel(serverChannelContext);
import java.nio.ByteBuffer;
        IOException ioException = new IOException();
    public void testWillCallPostHandleAfterChannelHandling() throws Exception {
    public void testSuccessfulReadEvent() throws Exception {
 */  
        selector.processKey(selectionKey);  
    public void testQueueChannelForClosed() throws IOException {  
                runnable.run();
        verify(listener).accept(isNull(), any(ClosedChannelException.class));  
        selector.queueWrite(writeOperation);
 * the Apache License, Version 2.0 (the "License"); you may
        verify(channelContext).queueWriteOperation(writeOperation);  
    private Selector rawSelector;
        eventHandler = mock(EventHandler.class);
            @Override
        verify(eventHandler).acceptException(serverChannelContext, ioException);
/*
        selector.singleLoop();  
        });  
        verify(eventHandler).handleWrite(channelContext);
    public void testNioDelayedTasksAreExecuted() throws IOException {  
    public void testChannelActiveException() throws Exception {
        assertBusy(() -> {
    }
 * GitHub history for details.
    private NioServerSocketChannel serverChannel;
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
    }
        verify(eventHandler).postHandling(channelContext);
    public void testQueueDirectlyInChannelBufferSuccessful() throws Exception {
        verify(eventHandler).connectException(channelContext, ioException);
        executeOnNewThread(() -> selector.scheduleForRegistration(channel));
 * Licensed to Elasticsearch under one or more contributor  
            task.run();  
import org.mockito.ArgumentCaptor;
 *
    public void testConnectEvent() throws Exception {
        IOException ioException = new IOException();  
    }  
import static org.mockito.Mockito.anyLong;
        selector.singleLoop();
        when(context.getSelector()).thenReturn(selector);
    public void testSuccessfullyRegisterChannelWillAttemptConnect() throws Exception {  
        selectionKey.attach(channelContext);
        doThrow(ioException).when(eventHandler).handleRead(channelContext);  
    }
        selector.preSelect();  
        TestSelectionKey testSelectionKey = new TestSelectionKey(0);
        selectionKey.attach(serverChannelContext);
        AtomicBoolean isRun = new AtomicBoolean(false);
    }  
        ChannelContext context = mock(ChannelContext.class);
        executeOnNewThread(() -> {
        verify(eventHandler).handleRead(channelContext);  
        verify(eventHandler).handleActive(serverChannelContext);
import java.util.HashSet;
        verify(eventHandler).handleActive(serverChannelContext);  
            return null;
    private NioSelector selector;
            selector.scheduleForRegistration(channel);
        when(channelContext.getSelectionKey()).thenReturn(null);
        doThrow(closedChannelException).when(eventHandler).handleRegistration(serverChannelContext);
    }  
        });  
        executeOnNewThread(() -> selector.queueWrite(writeOperation));
            public void onFailure(Exception e) {
        when(channelContext.isConnectComplete()).thenReturn(false);  
    }  
import static org.mockito.Mockito.verify;
        selectionKey.setReadyOps(SelectionKey.OP_WRITE | SelectionKey.OP_READ);
        IOException ioException = new IOException();  
        this.selector = new NioSelector(eventHandler, rawSelector);
            selector.queueWrite(new FlushReadyWrite(channelContext, buffers, listener));  
        });
import java.util.concurrent.atomic.AtomicBoolean;
        selector.preSelect();
    }
 *
        RuntimeException taskException = new RuntimeException();  
        executeOnNewThread(() -> selector.queueWrite(writeOperation));
        selector.scheduleForRegistration(serverChannel);  
        verify(channelContext).queueWriteOperation(writeOperation);
import java.nio.channels.Selector;  
        selector.preSelect();  
        selector.singleLoop();
            selector.close();
        listener = mock(BiConsumer.class);
    public void testRegisterChannel() throws Exception {
        long nanoTime = System.nanoTime() - 1;
        verify(eventHandler).handleRegistration(channelContext);  
    private static void executeOnNewThread(CheckedRunnable<Exception> runnable) throws InterruptedException {  
    }
        selector.preSelect();
        selectionKey.setReadyOps(SelectionKey.OP_WRITE | SelectionKey.OP_READ);  
        verify(eventHandler).handleClose(serverChannelContext);
import org.junit.Before;
        rawSelector = mock(Selector.class);
        channel = mock(NioSocketChannel.class);  
    public void testQueueWriteWhenNotRunning() throws Exception {
        selector.preSelect();  
            long delay = new TimeValue(50, TimeUnit.MILLISECONDS).nanos();  
 *  
            doThrow(closedChannelException).when(eventHandler).handleRegistration(channelContext);
        verify(rawSelector).selectNow();
        selectionKey.attach(channelContext);
    }
    }
        executeOnNewThread(() -> selector.scheduleForRegistration(serverChannel));  
        });
        selectionKey.attach(channelContext);
        doThrow(ioException).when(eventHandler).handleActive(serverChannelContext);
        selector.processKey(selectionKey);  
    }  
    }
        // As this is a timing based test, we must assertBusy in the very small chance that the loop is
            verify(eventHandler, times(0)).handleConnect(channelContext);
    public void testCloseException() throws IOException, InterruptedException {
    }
        verify(rawSelector).close();
        when(unregisteredChannel.getContext()).thenReturn(unregisteredContext);
 * this work for additional information regarding copyright
        selectionKey.attach(channelContext);
        verify(eventHandler, times(0)).handleWrite(channelContext);
            verify(eventHandler).handleClose(channelContext);  
        when(channelContext.isConnectComplete()).thenReturn(false);  
        verify(eventHandler).closeException(context, ioException);  
        super.setUp();  
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);  
        verify(eventHandler).handleClose(context);
    }
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
        selector.queueWrite(writeOperation);
    @SuppressWarnings({ "unchecked", "rawtypes" })
        selector.processKey(selectionKey);  
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);  
import static org.mockito.Mockito.same;  
        }).when(eventHandler).handleTask(same(task));
            ((Runnable) invocationOnMock.getArguments()[0]).run();  
        verify(eventHandler).selectorException(ioException);
import java.util.Collections;
        selector.getTaskScheduler().scheduleAtRelativeTime(task, nanoTime);  
        thread.start();  
        selectionKey.setReadyOps(SelectionKey.OP_ACCEPT);
import org.opensearch.common.CheckedRunnable;
        verify(eventHandler).handleConnect(channelContext);
}  
        verify(listener).accept(isNull(), any(IllegalStateException.class));
        selectionKey = new TestSelectionKey(0);
import java.util.function.BiConsumer;
import java.nio.channels.SelectionKey;
        executeOnNewThread(() -> selector.close());  
    public void testSelectorClosedIfOpenAndEventLoopNotRunning() throws Exception {
 * software distributed under the License is distributed on an
            protected void doRun() throws Exception {  
        verify(eventHandler).handleWrite(channelContext);
        assertTrue((selectionKey.interestOps() & SelectionKey.OP_WRITE) == 0);  
 * compatible open source license.
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
        selectionKey.attach(channelContext);
        doAnswer(invocationOnMock -> {
            selector.queueWrite(new FlushReadyWrite(channelContext, buffers, listener));
        final Thread thread = new Thread(new AbstractRunnable() {
    public void testWriteEventWithException() throws Exception {
        selector.processKey(selectionKey);  
        }).when(eventHandler).handleTask(any());
    public void testCleanup() throws Exception {
        verify(eventHandler, times(0)).handleActive(serverChannelContext);  
        when(rawSelector.select(anyLong())).thenThrow(new ClosedSelectorException());
        selector.processKey(selectionKey);
 */  
    }
        verify(channelContext).queueWriteOperation(writeOperation);
 * under the License.  
        ChannelContext context = mock(ChannelContext.class);
            verify(eventHandler, times(0)).handleActive(serverChannelContext);
    public void testTaskExceptionsAreHandled() {
    public void setUp() throws Exception {
    public void testIOExceptionWhileSelect() throws IOException {  
    public void testQueueWriteChannelIsUnregistered() throws Exception {  
        long delay = new TimeValue(15, TimeUnit.MINUTES).nanos();  
        selectionKey.setReadyOps(SelectionKey.OP_CONNECT);
        selector.queueChannelClose(channel);  
        selector.scheduleForRegistration(channel);  
    }  
        when(channel.getContext()).thenReturn(channelContext);
import java.nio.channels.ClosedSelectorException;
        selector.preSelect();  
        selector.singleLoop();  
        verify(eventHandler).handleClose(channelContext);  
    }  
            ClosedChannelException closedChannelException = new ClosedChannelException();
        long nanoTime = System.nanoTime() - 1;
            selector.getTaskScheduler().scheduleAtRelativeTime(() -> {}, System.nanoTime() + delay);
        verify(eventHandler).writeException(channelContext, ioException);
    public void testRegisterSocketChannelFailsDueToException() throws InterruptedException {  
            return null;
        NioChannel channel = mock(NioChannel.class);
    @SuppressWarnings("unchecked")
    public void testDefaultSelectorTimeoutIsUsedIfNoTaskSooner() throws IOException {
        doThrow(ioException).when(eventHandler).handleWrite(channelContext);
        verify(eventHandler, times(0)).handleConnect(channelContext);
        boolean closedSelectorExceptionCaught = false;
        IOException ioException = new IOException();  
        selector.queueWrite(writeOperation);
        verify(eventHandler).handleClose(unregisteredContext);  
            assertTrue(captor.getValue() < 300);
    }
    }  
    }  
        when(channel.getContext()).thenReturn(context);  
        selector.preSelect();
        selector.processKey(selectionKey);
        verify(rawSelector).select(300);
    }
    }
        selector.getTaskScheduler().scheduleAtRelativeTime(() -> isRun.set(true), nanoTime);  
        verify(channelContext).queueWriteOperation(writeOperation);  
        serverChannel = mock(NioServerSocketChannel.class);
        assertFalse(isRun.get());
    public void testSelectorClosedExceptionIsNotCaughtWhileRunning() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        when(serverChannel.getContext()).thenReturn(serverChannelContext);
                throw new AssertionError(e);  
package org.opensearch.nio;
 * The OpenSearch Contributors require contributions made to  
        selectionKey.attach(channelContext);
        IOException ioException = new IOException();
        when(rawSelector.keys()).thenReturn(new HashSet<>(Collections.singletonList(testSelectionKey)));  
        this.selector.setThread();
        selector.processKey(selectionKey);  
        selectionKey.setReadyOps(SelectionKey.OP_WRITE);  
        selectionKey.setReadyOps(SelectionKey.OP_ACCEPT);
        selector.processKey(selectionKey);
    private EventHandler eventHandler;
        verify(eventHandler, times(0)).handleRead(channelContext);
    private SocketChannelContext channelContext;  
        selector.processKey(selectionKey);
            verify(eventHandler).registrationException(channelContext, closedChannelException);  
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
        selectionKey.attach(serverChannelContext);
        verify(eventHandler).acceptChannel(serverChannelContext);
        selector.scheduleForRegistration(channel);
        when(channelContext.getSelector()).thenReturn(selector);  
        selector.preSelect();
        when(channelContext.getSelectionKey()).thenReturn(selectionKey);
        executeOnNewThread(() -> selector.queueChannelClose(channel));  
            ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        });
        verify(eventHandler).registrationException(serverChannelContext, closedChannelException);
        executeOnNewThread(() -> {
    public void testShouldNotFlushIfChannelNotConnectedPendingFlushes() throws Exception {
        selector.preSelect();
        // delayed for 50 milliseconds (causing a selectNow())  
        this.selector.singleLoop();
    }  
    }
        IOException ioException = new IOException();  
    private ByteBuffer[] buffers = { ByteBuffer.allocate(1) };  
            assertTrue(captor.getValue() > 0);
    public void testWillNotConsiderWriteOrReadUntilConnectionComplete() throws Exception {
        SocketChannelContext unregisteredContext = mock(SocketChannelContext.class);  
        when(serverChannelContext.isOpen()).thenReturn(false);  
        doThrow(ioException).when(eventHandler).handleWrite(channelContext);
 * specific language governing permissions and limitations
import static org.mockito.Mockito.isNull;
        }
    }
        IOException ioException = new IOException();
    private NioSocketChannel channel;  
        when(channelContext.readyForFlush()).thenReturn(true);
        verify(eventHandler).handleWrite(channelContext);
            }
 * KIND, either express or implied.  See the License for the
        thread.join();
    }  
    public void testRegisterServerChannelFailsDueToException() throws Exception {
    public void testQueueWriteSuccessful() throws Exception {
        doThrow(ioException).when(eventHandler).handleClose(context);
        when(channel.getContext()).thenReturn(context);  
        selector.scheduleForRegistration(serverChannel);
        NioChannel channel = mock(NioChannel.class);
    }  
        selector.cleanupAndCloseChannels();
        when(unregisteredContext.getSelector()).thenReturn(selector);
        verify(eventHandler).activeException(serverChannelContext, ioException);
        selectionKey.attach(channelContext);
    private ServerChannelContext serverChannelContext;
 * not use this file except in compliance with the License.
        when(channelContext.isOpen()).thenReturn(false);
        verify(eventHandler).readException(channelContext, ioException);
        selector.processKey(selectionKey);
        doAnswer((a) -> {
import org.opensearch.test.OpenSearchTestCase;
        verify(listener).accept(isNull(), any(ClosedSelectorException.class));
            selector.scheduleForRegistration(unregisteredChannel);
            }
        verify(eventHandler, times(0)).handleWrite(channelContext);
        verify(eventHandler).registrationException(same(channelContext), any(ClosedChannelException.class));
        selector.getTaskScheduler().scheduleAtRelativeTime(() -> {}, System.nanoTime() + delay);
    }
        selectionKey.attach(channelContext);
 */
    public void testClosedServerChannelWillNotBeRegistered() {
    }
        verify(eventHandler).taskException(taskException);
        verify(eventHandler).postHandling(channelContext);
    public void testAcceptEvent() throws IOException {
    public void testRegisteredChannel() throws IOException {
        doThrow(ioException).when(eventHandler).handleConnect(channelContext);
        executeOnNewThread(() -> {  
        selectionKey.setReadyOps(SelectionKey.OP_WRITE);  
        verify(listener).accept(isNull(), any(ClosedSelectorException.class));
    }
        when(rawSelector.select(anyLong())).thenThrow(ioException);  
