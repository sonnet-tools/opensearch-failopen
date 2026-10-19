            eventHandler.uncaughtException(e);
     */
     */
    /**
    }
 * ownership. Elasticsearch licenses this file to you under
            channelsToClose.offer(context);
    private void registerChannel(ChannelContext<?> newChannel) {
    private void handleScheduledTasks(long nanoTime) {
        try {
    /**
 * The OpenSearch Contributors require contributions made to
        Runnable task;
        while ((channelContext = channelsToClose.poll()) != null) {
            eventHandler.activeException(newChannel, e);
     * If the selector is closed, then we attempt to remove the object from the queue. If the removal
        assertOnSelectorThread();
    public NioSelector(EventHandler eventHandler) throws IOException {
                closeChannel(newChannel);
        return runLock.isLocked();
    }
        } catch (Exception e) {
    }
            ServerChannelContext serverChannelContext = (ServerChannelContext) context;
                Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
        try {
     * right away.
                    singleLoop();
import java.io.IOException;
                }
     *
        closePendingChannels();
import java.nio.channels.ClosedChannelException;
    private void channelActive(ChannelContext<?> newChannel) {
    }
                // Only select until the next task needs to be run. Do not select with a value of 0 because
                        eventHandler.genericChannelException((ChannelContext<?>) sk.attachment(), new CancelledKeyException());
            try {
            // This should very rarely happen. The only times a channel is exposed outside the event loop,
                    try {
        }
            registerChannel(context);
        }
                setThread();
                if (wasRemoved) {
import java.util.stream.Collectors;
            closeChannel(newChannel);
    void setThread() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        return taskScheduler;
                }
     * selector thread.
            }
    private void wakeup() {
    private void setUpNewChannels() {
            }
            }
            + "].";
    }
        assert isOnCurrentThread() : "Must be on selector thread ["
                    if ((ops & SelectionKey.OP_WRITE) != 0) {
            }
    private final TaskScheduler taskScheduler = new TaskScheduler();
        }
        }
        } catch (Exception e) {
        ChannelContext<?> context = channel.getContext();
            wakeup();
            channelsToRegister.add(context);
 * software distributed under the License is distributed on an
        } else {
            try {
                            eventHandler.genericChannelException((ChannelContext<?>) sk.attachment(), cke);
        }
    }
        } catch (Exception e) {
            if (isOpen() == false) {
                while (keyIterator.hasNext()) {
                    }
            long nanosUntilNextTask = taskScheduler.nanosUntilNextTask(System.nanoTime());
            throw new IllegalStateException("selector is already running");
        boolean wasSet = thread.compareAndSet(null, Thread.currentThread());
     * Queues a write operation directly in a channel's buffer. If this channel does not have pending writes
                    } finally {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Iterator;
            eventHandler.postHandling(channelContext);
            }
    void cleanupAndCloseChannels() {
                }
     * succeeds then we throw an {@link IllegalStateException} indicating that normal operation failed. If
    public boolean isOnCurrentThread() {
        }
        this.eventHandler = eventHandler;
    public <V> void executeListener(BiConsumer<V, Exception> listener, V value) {
            executeFailedListener(op.getListener(), new ClosedSelectorException());
    void preSelect() {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
package org.opensearch.nio;
            if (queue.remove(objectAdded)) {
            ensureSelectorOpenForEnqueuing(channelsToRegister, context);
    private void closePendingChannels() {
        } else {
     * Schedules a NioChannel to be registered with this selector. The channel will by queued and
                            processKey(sk);
                selector.close();
     * @param queue the queue to which the object was added
    private final ByteBuffer ioBuffer;
                }
    }
        );
        while ((task = taskScheduler.pollTask(nanoTime)) != null) {
     * @param value    to provide to listener
 * Licensed to Elasticsearch under one or more contributor
     * If this method is called from the selector thread, we will not allow the queuing to occur as the
                context.queueWriteOperation(writeOperation);
        while ((newChannel = this.channelsToRegister.poll()) != null) {
        }
 * Modifications Copyright OpenSearch Contributors. See
            + "} to perform this operation. "
        SocketChannelContext context = writeOperation.getChannel();
}
        }
        }
            eventHandler.taskException(e);
 */
     * and operation can proceed normally.
     * selector thread.
    void singleLoop() {
        return isClosed.get() == false;
            eventHandler.connectException(context, e);
                    } else {
     * already, the channel will be flushed. Channel buffers are only safe to be accessed by the selector
    private void handleWrite(SocketChannelContext context) {
                    attemptConnect(socketChannelContext, false);
    private void cleanupPendingWrites() {
    public <V> void executeFailedListener(BiConsumer<V, Exception> listener, Exception exception) {
        setUpNewChannels();
            + "Currently on thread ["
 * compatible open source license.
            eventHandler.selectorException(e);
     * This is a convenience method to be called after some object (normally channels) are enqueued with this
        channelsToClose.addAll(
 * SPDX-License-Identifier: Apache-2.0
        if (isOnCurrentThread() == false) {
/**
    /**
        try {
        }
            }
                    if (channelContext.selectorShouldClose() == false && (ops & SelectionKey.OP_READ) != 0) {
     */
    private final AtomicBoolean wokenUp = new AtomicBoolean(false);
            eventHandler.registrationException(newChannel, e);
        } else if (context.getSelectionKey() == null) {
     * @param writeOperation to be queued in a channel's buffer
        } else {
import java.nio.channels.ClosedSelectorException;
 * this file be licensed under the Apache-2.0 license or a
            } finally {
    /**
        assertOnSelectorThread();
            eventHandler.closeException(channelContext, e);
        if (isClosed.compareAndSet(false, true)) {
    private final CompletableFuture<Void> isRunningFuture = new CompletableFuture<>();
    }
            eventHandler.handleActive(newChannel);
                    Thread.currentThread().interrupt();
        while ((writeOperation = queuedWrites.poll()) != null) {
     * a selection key.
     * @param listener  to be executed
        } else {
        } catch (ClosedSelectorException e) {
            eventHandler.handleRead(context);
     * Executes a success listener with consistent exception handling. This can only be called from current
        } catch (Exception e) {
        assert newChannel.getSelector() == this : "The channel must be registered with the selector with which it was created";
                while (isOpen()) {
            eventHandler.readException(context, e);
                long millisUntilNextTask = TimeUnit.NANOSECONDS.toMillis(nanosUntilNextTask);
    public boolean isRunning() {
            selector.keys().stream().map(sk -> (ChannelContext<?>) sk.attachment()).filter(Objects::nonNull).collect(Collectors.toList())
     * @return the byte buffer
        ChannelContext<?> channelContext;
     * api available for non-selector threads to schedule writes. When invoked from the selector thread the write will be executed
     * @param channel to register
                    if (sk.isValid()) {
import java.util.concurrent.atomic.AtomicBoolean;
        }
    private final ConcurrentLinkedQueue<ChannelContext<?>> channelsToClose = new ConcurrentLinkedQueue<>();
            handleTask(task);
                attemptConnect(channelContext, true);
        } catch (Exception e) {
            boolean shouldFlushAfterQueuing = context.readyForFlush() == false;
                } catch (InterruptedException e) {
                eventHandler.postHandling(context);
        this.selector = selector;
    }
            + thread.get().getName()
    }
            if (isOpen()) {
 * KIND, either express or implied.  See the License for the
    }
            + Thread.currentThread().getName()
            } catch (Exception e) {
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
     * not have pending writes already, the channel will be flushed.
        handleTask(() -> listener.accept(value, null));
     * thread. As a result, this method should only be called by the selector thread. If this channel does
     * Called immediately prior to a raw {@link Selector#select()} call. Should be used to implement
                eventHandler.connectException(context, new IOException("Received OP_CONNECT but connect failed"));
     * Returns a cached direct byte buffer for network operations. It is cleared on every get call.
     * @param listener to be executed
 * specific language governing permissions and limitations
                eventHandler.registrationException(newChannel, new ClosedChannelException());
                    exitedLoop.await();
 * license agreements. See the NOTICE file distributed with
    @Override
    public void assertOnSelectorThread() {
            }
import java.nio.channels.Selector;
 */
     */
    }
    }
            if (isRunning()) {
 *
                    cleanupAndCloseChannels();
     *
            if (ready > 0) {
    public void runLoop() {
                ready = selector.select(Math.min(300, Math.max(millisUntilNextTask, 1)));
     * @param objectAdded the objected added
            try {
     * the object cannot be removed from the queue, then the object has already been handled by the selector
                    }
/*
import java.nio.channels.CancelledKeyException;
        WriteOperation op;
    }
import java.util.concurrent.CompletableFuture;
     */
        this.ioBuffer = ByteBuffer.allocateDirect(1 << 18);
        if (wokenUp.compareAndSet(false, true)) {
                eventHandler.acceptChannel(serverChannelContext);
 * Unless required by applicable law or agreed to in writing,
                channelActive(newChannel);
 * {@link #runLoop()}, the selector will run until {@link #close()} is called. This instance handles closing
     *
            closeChannel(channelContext);
    private final EventHandler eventHandler;
    /**
import java.util.concurrent.CountDownLatch;
            closePendingChannels();
 * this selector.
                }
                shouldFlushAfterQueuing = false;
                try {
        if (context.isOpen() == false) {
                        handleWrite(channelContext);
            queuedWrites.offer(writeOperation);
    }
        cleanupPendingWrites();
            eventHandler.writeException(context, e);
            }
        }
 * GitHub history for details.
            if (channelContext.isConnectComplete()) {
        }
    public void queueChannelClose(NioChannel channel) {
                        } catch (CancelledKeyException cke) {
    Future<Void> isRunningFuture() {
        } catch (IOException e) {
                }
        ioBuffer.clear();
                    } catch (IOException e) {
     * proceed.
    }
    }
 * under the License.
            } else {
            SocketChannelContext channelContext = (SocketChannelContext) context;
        } else {
import java.util.concurrent.Future;
     * <p>
    private final CountDownLatch exitedLoop = new CountDownLatch(1);
    private void attemptConnect(SocketChannelContext context, boolean connectEvent) {
    private final Selector selector;
     * <p>
        channelsToRegister.clear();
        ChannelContext<?> context = (ChannelContext<?>) selectionKey.attachment();
     *
                ready = selector.selectNow();
            assert context instanceof ServerChannelContext : "Only server channels can receive accept events";
     * eventually registered next time through the event loop.
            eventHandler.handleClose(channelContext);
    }
        assert isOnCurrentThread() == false;
        assert context.getSelector() == this : "Must schedule a channel for closure with its selector";
        assertOnSelectorThread();
    }
    }
                    handleWrite(context);
                if (newChannel instanceof SocketChannelContext socketChannelContext) {
    /**
            } else {
    private void closeChannel(final ChannelContext<?> channelContext) {
        try {
                        exitedLoop.countDown();
    }
        handleTask(() -> listener.accept(null, exception));
        while ((op = queuedWrites.poll()) != null) {
     * @param exception to provide to listener
     * Executes a failed listener with consistent exception handling. This can only be called from current
                        selector.close();
 *
     * @param writeOperation to be queued
     *
    }
    private void handleTask(Runnable task) {
     * channel registration, handling queued writes, and other work that is not specifically processing
                        }
    }
        }
    private final AtomicReference<Thread> thread = new AtomicReference<>(null);
        ChannelContext<?> newChannel;
            } else if (selector.isOpen()) {
            assert context instanceof SocketChannelContext : "Only sockets channels can receive non-accept events";
            // the write operation is queued.
        handleQueuedWrites();
     */
import java.nio.ByteBuffer;
    }
     *
            } else {
        try {
     * Starts this selector. The selector will run until {@link #close()} is called.
        } catch (Exception e) {
        channelsToClose.addAll(channelsToRegister);
                boolean wasRemoved = queuedWrites.remove(writeOperation);
            executeFailedListener(writeOperation.getListener(), new IllegalStateException("Channel not registered"));
 * this work for additional information regarding copyright
    }
        return Thread.currentThread() == thread.get();
        }
            handleScheduledTasks(System.nanoTime());
                // signalling that it should be closed.
            eventHandler.handleConnect(context);
    }
    public Selector rawSelector() {
        assert wasSet : "Failed to set thread as it was already set. Should only set once.";
        ChannelContext<?> context = channel.getContext();
    private void handleRead(SocketChannelContext context) {
 * of channels. Users should call {@link #queueChannelClose(NioChannel)} to schedule a channel for close by
                eventHandler.acceptException(serverChannelContext, e);
        }
    }
import java.nio.channels.SelectionKey;
    /**
     *
                try {
        }
                    throw new IllegalStateException("Thread was interrupted while waiting for selector to close", e);
        if (isOnCurrentThread() == false) {
import java.util.concurrent.ConcurrentLinkedQueue;
        if (runLock.tryLock()) {
import java.io.Closeable;
            preSelect();
    }
     * selector thread can manipulate its queues internally even if it is no longer open.
            } catch (IOException e) {
    public void scheduleForRegistration(NioChannel channel) {
    }
/*
            writeToChannel(writeOperation);
     */
                throw new IllegalStateException("selector is already closed");
                throw e;
        }
    private void writeToChannel(WriteOperation writeOperation) {
import java.util.concurrent.TimeUnit;
                executeFailedListener(writeOperation.getListener(), e);
        if (isOpen() == false) {
        } catch (Exception e) {
 * not use this file except in compliance with the License.
            wakeup();
    }
     */
 * You may obtain a copy of the License at
                // that blocks without a timeout.
        }
import java.util.Objects;
        try {
            if (newChannel.isOpen()) {
                if (context.isConnectComplete() && context.selectorShouldClose() == false) {
    private final ConcurrentLinkedQueue<WriteOperation> queuedWrites = new ConcurrentLinkedQueue<>();
        if (selectionKey.isAcceptable()) {
     * Queues a write operation to be handled by the event loop. This can be called by any thread and is the
 */
        } else {
    public ByteBuffer getIoBuffer() {
            if (wokenUp.getAndSet(false) || nanosUntilNextTask == 0) {
            isRunningFuture.complete(null);
        this(eventHandler, Selector.open());
    }
                eventHandler.handleRegistration(newChannel);
        }
                    SelectionKey sk = keyIterator.next();
/*
            wakeup();
 * This is a nio selector implementation. This selector wraps a raw nio {@link Selector}. When you call
            executeFailedListener(writeOperation.getListener(), new ClosedChannelException());
    private final ConcurrentLinkedQueue<ChannelContext<?>> channelsToRegister = new ConcurrentLinkedQueue<>();
            closeChannel(context);
        if (isOnCurrentThread()) {
                }
        } catch (IOException e) {
    public void close() throws IOException {
        assertOnSelectorThread();
import java.util.function.BiConsumer;
 */
    }
                    }
     * selector. This method will check if the selector is still open. If it is open, normal operation can
            int ready;
            }
            }
            selector.wakeup();
            registerChannel(newChannel);
        }
     */
            writeToChannel(writeOperation);
    public TaskScheduler getTaskScheduler() {
 *
    }
            }
            }
        try {
    private <O> void ensureSelectorOpenForEnqueuing(ConcurrentLinkedQueue<O> queue, O objectAdded) {
                } finally {
        WriteOperation writeOperation;
            int ops = selectionKey.readyOps();
            // If the channel does not currently have anything that is ready to flush, we should flush after
    private final ReentrantLock runLock = new ReentrantLock();
    }
            }
        return isRunningFuture;
            if ((ops & SelectionKey.OP_CONNECT) != 0) {
        return selector;
                        handleRead(channelContext);
    }
                        runLock.unlock();
    public boolean isOpen() {
                        eventHandler.selectorException(e);
                    writeOperation.getListener().accept(null, new ClosedSelectorException());
            }
    void processKey(SelectionKey selectionKey) {
                    keyIterator.remove();
            eventHandler.handleWrite(context);
    }
            ensureSelectorOpenForEnqueuing(channelsToClose, context);
    }
        return ioBuffer;
    public void queueWrite(WriteOperation writeOperation) {
import java.util.Set;
    /**
public class NioSelector implements Closeable {
            // but might not registered is through the exception handler and channel accepted callbacks.
            if (shouldFlushAfterQueuing) {
        }
    private void handleQueuedWrites() {
                }
        try {
            if (connectEvent && context.isConnectComplete() == false) {
                        try {
                if (channelContext.selectorShouldClose() == false) {
                wakeup();
                // We only attempt the write if the connect process is complete and the context is not
 * the Apache License, Version 2.0 (the "License"); you may
            eventHandler.handleTask(task);
                    }
import java.util.concurrent.locks.ReentrantLock;
     * @param <O> the object type
    public NioSelector(EventHandler eventHandler, Selector selector) {
import java.util.concurrent.atomic.AtomicReference;
