import java.util.concurrent.atomic.AtomicBoolean;
    }
        verify(eventHandler).handleActive(serverChannelContext);
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
        selector.preSelect();
            @Override
    public void testNioDelayedTasksAreExecuted() throws IOException {
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
        verify(eventHandler).connectException(channelContext, ioException);
        when(context.getSelector()).thenReturn(selector);
    }
    @SuppressWarnings("unchecked")
    public void testRegisterChannel() throws Exception {
    public void testSuccessfullyRegisterChannelWillAttemptConnect() throws Exception {
import java.nio.channels.Selector;
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
        verify(eventHandler).handleWrite(channelContext);
    public void testSuccessfulReadEvent() throws Exception {
import java.nio.channels.SelectionKey;
import org.mockito.ArgumentCaptor;
 *    http://www.apache.org/licenses/LICENSE-2.0
        verify(eventHandler).postHandling(channelContext);
        verify(rawSelector).select(300);
    public void testSuccessfulWriteEvent() throws Exception {
        testSelectionKey.attach(channelContext);
        selector.preSelect();
        selector.preSelect();
            selector.scheduleForRegistration(channel);
 */
import java.nio.channels.ClosedChannelException;
 * KIND, either express or implied.  See the License for the
        eventHandler = mock(EventHandler.class);
 * GitHub history for details.
        doThrow(ioException).when(eventHandler).handleClose(context);
            doThrow(closedChannelException).when(eventHandler).handleRegistration(channelContext);
        selectionKey.attach(channelContext);
        executeOnNewThread(() -> selector.close());
        selector.preSelect();
        selectionKey.attach(channelContext);
 * not use this file except in compliance with the License.
        thread.start();
        verify(eventHandler).handleClose(context);
    public void testSelectorTimeoutWillBeReducedIfTaskSooner() throws Exception {
        doThrow(ioException).when(eventHandler).handleWrite(channelContext);
    }
        when(rawSelector.isOpen()).thenReturn(true);
        selector.preSelect();
        });
        selector.processKey(selectionKey);
        selectionKey.attach(channelContext);
        verify(eventHandler).handleRegistration(serverChannelContext);
        selectionKey.attach(channelContext);
 * this file be licensed under the Apache-2.0 license or a
        selector.singleLoop();
            @Override
/*
    private static void executeOnNewThread(CheckedRunnable<Exception> runnable) throws InterruptedException {
        verify(eventHandler).registrationException(same(channelContext), any(ClosedChannelException.class));
        thread.join();
        verify(eventHandler, times(0)).handleWrite(channelContext);
import java.util.Collections;
    public void testRegisterServerChannelFailsDueToException() throws Exception {
 * under the License.
    public void testQueueWriteSuccessful() throws Exception {
        selector.singleLoop();
        when(serverChannel.getContext()).thenReturn(serverChannelContext);
        executeOnNewThread(() -> selector.scheduleForRegistration(channel));
        when(rawSelector.keys()).thenReturn(new HashSet<>(Collections.singletonList(testSelectionKey)));
    }
    public void testWriteEventWithException() throws Exception {
        verify(eventHandler).postHandling(channelContext);
        final Thread thread = new Thread(new AbstractRunnable() {
        when(channelContext.readyForFlush()).thenReturn(false);
        NioChannel channel = mock(NioChannel.class);
    public void setUp() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
            public void onFailure(Exception e) {
    }
    public void testShouldFlushIfNoPendingFlushes() throws Exception {
        long nanoTime = System.nanoTime() - 1;
    }
package org.opensearch.nio;
        }).when(eventHandler).handleTask(same(task));
        doThrow(ioException).when(eventHandler).handleConnect(channelContext);
        ChannelContext context = mock(ChannelContext.class);
        verify(eventHandler).closeException(context, ioException);
        selector.processKey(selectionKey);
    public void testConnectEvent() throws Exception {
import static org.mockito.Mockito.any;
        verify(eventHandler).handleWrite(channelContext);
    }
        verify(eventHandler).registrationException(serverChannelContext, closedChannelException);
    }
    public void testQueueDirectlyInChannelBufferSuccessful() throws Exception {
    }
        doAnswer((a) -> {
        verify(channelContext).queueWriteOperation(writeOperation);
        long delay = new TimeValue(15, TimeUnit.MINUTES).nanos();
import static org.mockito.Mockito.when;
    }
        selectionKey.attach(channelContext);
        selector.processKey(selectionKey);
        selector.processKey(selectionKey);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.unit.TimeValue;
import java.nio.channels.ClosedSelectorException;
            }
        Runnable task = () -> { throw taskException; };
 * the Apache License, Version 2.0 (the "License"); you may
            selector.close();
        verify(eventHandler, times(0)).handleWrite(channelContext);
        verify(eventHandler, times(0)).handleWrite(channelContext);
        assertFalse(isRun.get());
    }
            selector.scheduleForRegistration(unregisteredChannel);
        verify(eventHandler).handleClose(unregisteredContext);
        selectionKey.attach(serverChannelContext);
        selectionKey.setReadyOps(SelectionKey.OP_READ);
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
        selector.processKey(selectionKey);
        verify(eventHandler).activeException(serverChannelContext, ioException);
        verify(listener).accept(isNull(), any(IllegalStateException.class));
    private NioSocketChannel channel;
import org.junit.Before;
        verify(eventHandler).acceptChannel(serverChannelContext);
/*
        verify(eventHandler).writeException(channelContext, ioException);
            long delay = new TimeValue(50, TimeUnit.MILLISECONDS).nanos();
            verify(eventHandler, times(0)).handleActive(serverChannelContext);
 * SPDX-License-Identifier: Apache-2.0
        selector.processKey(selectionKey);
        rawSelector = mock(Selector.class);
public class NioSelectorTests extends OpenSearchTestCase {
 * software distributed under the License is distributed on an
        verify(eventHandler).registrationException(same(serverChannelContext), any(ClosedChannelException.class));
            selector.getTaskScheduler().scheduleAtRelativeTime(() -> {}, System.nanoTime() + delay);
        serverChannel = mock(NioServerSocketChannel.class);
    public void testQueueWriteChannelIsUnregistered() throws Exception {
    }
    }
    }
        selector.processKey(selectionKey);
        IOException ioException = new IOException();
 */
        verify(eventHandler).acceptException(serverChannelContext, ioException);
        IOException ioException = new IOException();
import static org.mockito.Mockito.same;
        selectionKey = new TestSelectionKey(0);
    }
 * ownership. Elasticsearch licenses this file to you under
            verify(eventHandler).registrationException(channelContext, closedChannelException);
        when(channelContext.readyForFlush()).thenReturn(true);
        when(rawSelector.select(anyLong())).thenThrow(new ClosedSelectorException());
        IOException ioException = new IOException();
        selectionKey.attach(channelContext);
        });
        when(context.getSelector()).thenReturn(selector);
        when(serverChannelContext.getSelectionKey()).thenReturn(selectionKey);
import java.util.concurrent.TimeUnit;
        when(channelContext.isOpen()).thenReturn(false);
    public void testSelectorClosedExceptionIsNotCaughtWhileRunning() throws IOException {
        selector.scheduleForRegistration(channel);
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
        selectionKey.attach(serverChannelContext);
        doAnswer(invocationOnMock -> {
    }
        executeOnNewThread(() -> selector.scheduleForRegistration(serverChannel));
        verify(channelContext, times(0)).queueWriteOperation(writeOperation);
                throw new AssertionError(e);
        verify(eventHandler).handleClose(serverChannelContext);
        when(channel.getContext()).thenReturn(context);
        verify(eventHandler, times(0)).handleRead(channelContext);
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
        when(channelContext.isOpen()).thenReturn(false);
        doThrow(ioException).when(eventHandler).handleRead(channelContext);
        selectionKey.attach(channelContext);
        listener = mock(BiConsumer.class);
            this.selector.singleLoop();
        verify(channelContext, times(0)).queueWriteOperation(writeOperation);
    public void testQueueWriteWhenNotRunning() throws Exception {
        selectionKey.attach(channelContext);
        executeOnNewThread(() -> selector.queueWrite(writeOperation));
import static org.mockito.Mockito.doThrow;
        selectionKey.setReadyOps(SelectionKey.OP_READ);
        assertBusy(() -> {
        when(channel.getContext()).thenReturn(context);
        verify(channelContext).queueWriteOperation(writeOperation);
import java.util.HashSet;
            verify(eventHandler).handleClose(channelContext);
        IOException ioException = new IOException();
    public void testAcceptException() throws IOException {
        // As this is a timing based test, we must assertBusy in the very small chance that the loop is
import static org.mockito.Mockito.times;
    }
        assertTrue(closedSelectorExceptionCaught);
import org.opensearch.common.CheckedRunnable;
        selector.queueChannelClose(channel);
            assertTrue(captor.getValue() < 300);
        verify(eventHandler).handleClose(channelContext);
    }
    private ByteBuffer[] buffers = { ByteBuffer.allocate(1) };
    public void testAcceptEvent() throws IOException {
        executeOnNewThread(() -> selector.scheduleForRegistration(serverChannel));
        channel = mock(NioSocketChannel.class);
        doThrow(ioException).when(eventHandler).acceptChannel(serverChannelContext);
        verify(eventHandler, times(0)).postHandling(channelContext);
        verify(eventHandler).readException(channelContext, ioException);
        selector.scheduleForRegistration(channel);
    public void testConnectEventFinishThrowException() throws Exception {
        });
 * You may obtain a copy of the License at
        selector.singleLoop();
 *
    public void testCleanup() throws Exception {
        when(channelContext.isOpen()).thenReturn(true);
}
        }).when(eventHandler).handleTask(any());
        IOException ioException = new IOException();
import static org.mockito.Mockito.mock;
    }
    public void testRegisteredChannel() throws IOException {
import static org.mockito.Mockito.verify;
        verify(eventHandler).handleWrite(channelContext);
    public void testWillNotConsiderWriteOrReadUntilConnectionComplete() throws Exception {
        when(channel.getContext()).thenReturn(channelContext);
        selector.processKey(selectionKey);
    public void testShouldNotFlushIfChannelNotConnectedPendingFlushes() throws Exception {
        selector.getTaskScheduler().scheduleAtRelativeTime(() -> {}, System.nanoTime() + delay);
        selector.queueWrite(writeOperation);
        verify(listener).accept(isNull(), any(ClosedSelectorException.class));
        RuntimeException taskException = new RuntimeException();
                runnable.run();
        selector.preSelect();
        when(channelContext.getSelector()).thenReturn(selector);
        doThrow(ioException).when(eventHandler).handleWrite(channelContext);
        TestSelectionKey testSelectionKey = new TestSelectionKey(0);
    @Before
 * The OpenSearch Contributors require contributions made to
        verify(eventHandler).handleClose(channelContext);
        verify(listener).accept(isNull(), any(ClosedSelectorException.class));
        selector.preSelect();
            selector.preSelect();
        when(channelContext.readyForFlush()).thenReturn(false);
        selectionKey.setReadyOps(SelectionKey.OP_CONNECT);
        });
        assertTrue(isRun.get());
        doThrow(closedChannelException).when(eventHandler).handleRegistration(serverChannelContext);
 * compatible open source license.
 * this work for additional information regarding copyright
        selector.processKey(selectionKey);
        selector.singleLoop();
        when(unregisteredChannel.getContext()).thenReturn(unregisteredContext);
        when(rawSelector.select(anyLong())).thenThrow(ioException);
        selectionKey.setReadyOps(SelectionKey.OP_ACCEPT);
    }
        NioSocketChannel unregisteredChannel = mock(NioSocketChannel.class);
            task.run();
        verify(channelContext).queueWriteOperation(writeOperation);
    }
        executeOnNewThread(() -> selector.queueChannelClose(channel));
        channelContext = mock(SocketChannelContext.class);
            protected void doRun() throws Exception {
    }
    }
        // delayed for 50 milliseconds (causing a selectNow())
        });
        boolean closedSelectorExceptionCaught = false;
        IOException ioException = new IOException();
    public void testClosedSocketChannelWillNotBeRegistered() throws Exception {
    public void testIOExceptionWhileSelect() throws IOException {
    private NioSelector selector;
        IOException ioException = new IOException();
    }
        when(channelContext.isConnectComplete()).thenReturn(false);
        selectionKey.setReadyOps(SelectionKey.OP_WRITE);
        selector.scheduleForRegistration(channel);
        selector.getTaskScheduler().scheduleAtRelativeTime(task, nanoTime);
    private TestSelectionKey selectionKey;
    }
            ((Runnable) invocationOnMock.getArguments()[0]).run();
            return null;
            selector.singleLoop();
            verify(rawSelector).select(captor.capture());
        } catch (ClosedSelectorException e) {
        long nanoTime = System.nanoTime() - 1;
    private EventHandler eventHandler;
    }
        super.setUp();
        selectionKey.setReadyOps(SelectionKey.OP_WRITE | SelectionKey.OP_READ);
        when(channelContext.isConnectComplete()).thenReturn(false);
    private Selector rawSelector;
    }
        IOException ioException = new IOException();
    public void testDefaultSelectorTimeoutIsUsedIfNoTaskSooner() throws IOException {
    public void testQueueChannelForClosed() throws IOException {
        selectionKey.setReadyOps(SelectionKey.OP_CONNECT);
    public void testCloseException() throws IOException, InterruptedException {
import java.nio.ByteBuffer;
    public void testQueueWriteChannelIsClosed() throws Exception {
            closedSelectorExceptionCaught = true;
        verify(listener).accept(isNull(), any(ClosedChannelException.class));
        NioChannel channel = mock(NioChannel.class);
            ClosedChannelException closedChannelException = new ClosedChannelException();
        selector.queueWrite(writeOperation);
        when(channelContext.getSelectionKey()).thenReturn(selectionKey);
import static org.mockito.Mockito.anyLong;
    private BiConsumer<Void, Exception> listener;
        SocketChannelContext unregisteredContext = mock(SocketChannelContext.class);
        selector.singleLoop();
        selector.preSelect();
    }
        verify(eventHandler).selectorException(ioException);
        verify(rawSelector).selectNow();
    public void testChannelActiveException() throws Exception {
 */
    private NioServerSocketChannel serverChannel;
        executeOnNewThread(() -> selector.queueWrite(writeOperation));
            }
 *
    }
        verify(eventHandler).handleActive(serverChannelContext);
        when(channelContext.getSelectionKey()).thenReturn(null);
            assertTrue(captor.getValue() > 0);
        when(serverChannelContext.getSelector()).thenReturn(selector);
            return null;
        verify(rawSelector).close();
        verify(eventHandler).handleRead(channelContext);
    public void testTaskExceptionsAreHandled() {
        AtomicBoolean isRun = new AtomicBoolean(false);
        selector.preSelect();
        verify(eventHandler).handleConnect(channelContext);
    }
        verify(channelContext).queueWriteOperation(writeOperation);
/*
import static org.mockito.Mockito.doAnswer;
        selector.queueWrite(writeOperation);
        ClosedChannelException closedChannelException = new ClosedChannelException();
        selector.scheduleForRegistration(serverChannel);
import org.opensearch.test.OpenSearchTestCase;
    public void testWillCallPostHandleAfterChannelHandling() throws Exception {
            selector.queueWrite(new FlushReadyWrite(channelContext, buffers, listener));
import java.io.IOException;
    private ServerChannelContext serverChannelContext;
        verify(eventHandler).handleRead(channelContext);
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        selector.getTaskScheduler().scheduleAtRelativeTime(() -> isRun.set(true), nanoTime);
        selectionKey.attach(channelContext);
    }
        assertTrue((selectionKey.interestOps() & SelectionKey.OP_WRITE) == 0);
        selector.preSelect();
        }
    }
        verify(eventHandler, times(0)).handleActive(serverChannelContext);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        try {
    public void testSelectorClosedIfOpenAndEventLoopNotRunning() throws Exception {
        verify(eventHandler).handleRegistration(channelContext);
        when(serverChannelContext.isOpen()).thenReturn(false);
        this.selector.setThread();
            verify(eventHandler, times(0)).handleConnect(channelContext);
        this.selector.singleLoop();
    public void testClosedServerChannelWillNotBeRegistered() {
        selector.preSelect();
        when(unregisteredContext.getSelector()).thenReturn(selector);
        selector.processKey(selectionKey);
        ChannelContext context = mock(ChannelContext.class);
        when(channelContext.isConnectComplete()).thenReturn(true);
        serverChannelContext = mock(ServerChannelContext.class);
 * specific language governing permissions and limitations
import static org.mockito.Mockito.isNull;
        verify(eventHandler).handleConnect(channelContext);
        selector.cleanupAndCloseChannels();
 *
        executeOnNewThread(() -> selector.queueWrite(writeOperation));
        verify(eventHandler).postHandling(channelContext);
    }
    }
    private SocketChannelContext channelContext;
        WriteOperation writeOperation = new FlushReadyWrite(channelContext, buffers, listener);
        selector.scheduleForRegistration(serverChannel);
        verify(eventHandler).taskException(taskException);
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testRegisterSocketChannelFailsDueToException() throws InterruptedException {
        when(serverChannelContext.isOpen()).thenReturn(true);
        selectionKey.setReadyOps(SelectionKey.OP_WRITE);
        executeOnNewThread(() -> {
        verify(eventHandler, times(0)).handleConnect(channelContext);
        this.selector = new NioSelector(eventHandler, rawSelector);
        selectionKey.setReadyOps(SelectionKey.OP_WRITE | SelectionKey.OP_READ);
    public void testReadEventWithException() throws Exception {
            ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        selectionKey.setReadyOps(SelectionKey.OP_ACCEPT);
        executeOnNewThread(() -> {
    }
            selector.queueWrite(new FlushReadyWrite(channelContext, buffers, listener));
import org.opensearch.common.util.concurrent.AbstractRunnable;
    }
import java.util.function.BiConsumer;
        doThrow(ioException).when(eventHandler).handleActive(serverChannelContext);
        executeOnNewThread(() -> {
