    }  
            executeFailedListener(writeOperation.getListener(), new ClosedChannelException());
    private void attemptConnect(SocketChannelContext context, boolean connectEvent) {
import java.util.concurrent.CountDownLatch;
public class NioSelector implements Closeable {
        }  
        if (isOnCurrentThread() == false) {
import java.nio.channels.Selector;
    private void handleRead(SocketChannelContext context) {  
            + "} to perform this operation. "  
 * KIND, either express or implied.  See the License for the
    /**
 * SPDX-License-Identifier: Apache-2.0
        if (wokenUp.compareAndSet(false, true)) {
        }  
            if (wokenUp.getAndSet(false) || nanosUntilNextTask == 0) {  
 * specific language governing permissions and limitations
    }
    }  
     *
    }  
        } else {
import java.nio.channels.CancelledKeyException;
        } catch (IOException e) {  
                }
        }
    public void scheduleForRegistration(NioChannel channel) {
import java.util.concurrent.CompletableFuture;  
            }  
/*  
import java.nio.channels.ClosedChannelException;
    }
import java.nio.channels.SelectionKey;
            ServerChannelContext serverChannelContext = (ServerChannelContext) context;  
import java.nio.ByteBuffer;  
            + "].";  
        return ioBuffer;
    }  
                    attemptConnect(socketChannelContext, false);  
            eventHandler.taskException(e);
            registerChannel(newChannel);
}  
 * GitHub history for details.
                executeFailedListener(writeOperation.getListener(), e);  
                    if (channelContext.selectorShouldClose() == false && (ops & SelectionKey.OP_READ) != 0) {
    private final ReentrantLock runLock = new ReentrantLock();  
import java.util.concurrent.ConcurrentLinkedQueue;
import java.io.IOException;
    private void registerChannel(ChannelContext<?> newChannel) {
    /**  
            }  
        } catch (Exception e) {  
                    } else {
    private final ByteBuffer ioBuffer;  
        }  
import java.util.concurrent.Future;  
    public Selector rawSelector() {
                channelActive(newChannel);
                shouldFlushAfterQueuing = false;
        if (context.isOpen() == false) {
            // If the channel does not currently have anything that is ready to flush, we should flush after
                    } finally {
            closeChannel(context);
            eventHandler.handleWrite(context);  
 * not use this file except in compliance with the License.
    public NioSelector(EventHandler eventHandler, Selector selector) {
 */  
                            eventHandler.genericChannelException((ChannelContext<?>) sk.attachment(), cke);  
        }
        ChannelContext<?> newChannel;
        } catch (ClosedSelectorException e) {  
    }
            executeFailedListener(op.getListener(), new ClosedSelectorException());
    }  
                        try {  
        } else {
     */  
 * {@link #runLoop()}, the selector will run until {@link #close()} is called. This instance handles closing
 * You may obtain a copy of the License at  
        handleQueuedWrites();  
    private final CountDownLatch exitedLoop = new CountDownLatch(1);
     */
                eventHandler.connectException(context, new IOException("Received OP_CONNECT but connect failed"));  
                }
    }  
            eventHandler.selectorException(e);
        if (isOnCurrentThread() == false) {
        channelsToClose.addAll(channelsToRegister);
        } else {  
            // but might not registered is through the exception handler and channel accepted callbacks.
    }  
    }
            preSelect();  
    }
                // Only select until the next task needs to be run. Do not select with a value of 0 because
     * @param exception to provide to listener
    private void wakeup() {  
        } catch (Exception e) {  
    private void writeToChannel(WriteOperation writeOperation) {  
            if (isOpen() == false) {  
                        selector.close();
            handleScheduledTasks(System.nanoTime());
     * proceed.  
            selector.wakeup();  
     * selector thread can manipulate its queues internally even if it is no longer open.
        while ((channelContext = channelsToClose.poll()) != null) {
                    SelectionKey sk = keyIterator.next();  
    }
                    cleanupAndCloseChannels();
                        }
                    keyIterator.remove();
     * @param value    to provide to listener
                throw new IllegalStateException("selector is already closed");
 * Licensed to Elasticsearch under one or more contributor  
    void processKey(SelectionKey selectionKey) {
    }
        ChannelContext<?> context = (ChannelContext<?>) selectionKey.attachment();  
     * <p>
 *  
        }
     *
            eventHandler.readException(context, e);
                        } catch (CancelledKeyException cke) {
            if (connectEvent && context.isConnectComplete() == false) {
            eventHandler.handleRead(context);
        assert isOnCurrentThread() : "Must be on selector thread ["
    }
            ensureSelectorOpenForEnqueuing(channelsToClose, context);
        } catch (Exception e) {  
    }  
                        handleWrite(channelContext);
 * Unless required by applicable law or agreed to in writing,
    private void cleanupPendingWrites() {
    }  
 */
     * selector thread.
        cleanupPendingWrites();  
                eventHandler.acceptException(serverChannelContext, e);
            assert context instanceof ServerChannelContext : "Only server channels can receive accept events";
            if (newChannel.isOpen()) {
     * the object cannot be removed from the queue, then the object has already been handled by the selector
        }
    public ByteBuffer getIoBuffer() {
        channelsToRegister.clear();
            }
        this.selector = selector;  
        assertOnSelectorThread();
                attemptConnect(channelContext, true);
            selector.keys().stream().map(sk -> (ChannelContext<?>) sk.attachment()).filter(Objects::nonNull).collect(Collectors.toList())
                        handleRead(channelContext);
            throw new IllegalStateException("selector is already running");
    void preSelect() {
        assertOnSelectorThread();
     */
    private void handleScheduledTasks(long nanoTime) {  
    }
            closePendingChannels();
     * succeeds then we throw an {@link IllegalStateException} indicating that normal operation failed. If  
        }  
            ensureSelectorOpenForEnqueuing(channelsToRegister, context);  
            if (isOpen()) {
    private final AtomicReference<Thread> thread = new AtomicReference<>(null);
     *
                }
            closeChannel(newChannel);
                try {  
            // the write operation is queued.  
                    Thread.currentThread().interrupt();
            if (isRunning()) {
 *
     * @param writeOperation to be queued
    }  
            }
     * @param writeOperation to be queued in a channel's buffer
    }  
        }
    private final AtomicBoolean wokenUp = new AtomicBoolean(false);
                    } catch (IOException e) {
        if (isOnCurrentThread()) {
    }
            long nanosUntilNextTask = taskScheduler.nanosUntilNextTask(System.nanoTime());
    /**
                // We only attempt the write if the connect process is complete and the context is not
            + Thread.currentThread().getName()
                    exitedLoop.await();  
     * @param listener to be executed  
    /**
                        eventHandler.genericChannelException((ChannelContext<?>) sk.attachment(), new CancelledKeyException());  
    }
        } catch (Exception e) {
        return Thread.currentThread() == thread.get();  
                if (wasRemoved) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();  
            int ops = selectionKey.readyOps();  
                }
                }
                    }  
    /**  
                boolean wasRemoved = queuedWrites.remove(writeOperation);
    private void channelActive(ChannelContext<?> newChannel) {  
     * If this method is called from the selector thread, we will not allow the queuing to occur as the
                Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
                eventHandler.registrationException(newChannel, new ClosedChannelException());  
                if (newChannel instanceof SocketChannelContext socketChannelContext) {
    public NioSelector(EventHandler eventHandler) throws IOException {
        ChannelContext<?> channelContext;  
        );
    public void queueChannelClose(NioChannel channel) {
        assert wasSet : "Failed to set thread as it was already set. Should only set once.";
    private void closePendingChannels() {
            int ready;
        assert context.getSelector() == this : "Must schedule a channel for closure with its selector";
        try {  
 * license agreements. See the NOTICE file distributed with
     * @param <O> the object type  
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
            eventHandler.activeException(newChannel, e);
     */  
        while ((task = taskScheduler.pollTask(nanoTime)) != null) {
    public boolean isOpen() {  
        } catch (Exception e) {
            eventHandler.registrationException(newChannel, e);
     */  
            }
     *
    }  
            channelsToClose.offer(context);  
            }
    }  
     * @param listener  to be executed  
     * already, the channel will be flushed. Channel buffers are only safe to be accessed by the selector  
        }  
            registerChannel(context);  
                    throw new IllegalStateException("Thread was interrupted while waiting for selector to close", e);  
 * compatible open source license.
            }
     * <p>  
            } else {
     * channel registration, handling queued writes, and other work that is not specifically processing
    }
            eventHandler.connectException(context, e);  
                if (context.isConnectComplete() && context.selectorShouldClose() == false) {  
        } else if (context.getSelectionKey() == null) {  
 * software distributed under the License is distributed on an
    private final TaskScheduler taskScheduler = new TaskScheduler();
                context.queueWriteOperation(writeOperation);  
     * not have pending writes already, the channel will be flushed.
                    }
        closePendingChannels();  
     * Schedules a NioChannel to be registered with this selector. The channel will by queued and  
        assertOnSelectorThread();
                closeChannel(newChannel);
        }
     *  
            wakeup();
 *
import java.util.Iterator;  
    public void runLoop() {  
            isRunningFuture.complete(null);
        if (isClosed.compareAndSet(false, true)) {
                } finally {
        WriteOperation op;  
     * If the selector is closed, then we attempt to remove the object from the queue. If the removal
    }
import java.util.concurrent.atomic.AtomicReference;  
        return selector;  
            + "Currently on thread ["
        }
                } catch (InterruptedException e) {
        assert isOnCurrentThread() == false;
        } else {  
     * Called immediately prior to a raw {@link Selector#select()} call. Should be used to implement  
                // signalling that it should be closed.
            }  
     */
     * api available for non-selector threads to schedule writes. When invoked from the selector thread the write will be executed
            }
    }
            }
        try {
    void singleLoop() {  
        ChannelContext<?> context = channel.getContext();  
        return runLock.isLocked();
/*
                            processKey(sk);
                while (keyIterator.hasNext()) {
            SocketChannelContext channelContext = (SocketChannelContext) context;
            if (queue.remove(objectAdded)) {
            boolean shouldFlushAfterQueuing = context.readyForFlush() == false;
        } else {
            }  
    public void queueWrite(WriteOperation writeOperation) {
            wakeup();
     * Starts this selector. The selector will run until {@link #close()} is called.
    }  
        } catch (Exception e) {  
 * under the License.  
    private void closeChannel(final ChannelContext<?> channelContext) {  
        try {
        try {
            writeToChannel(writeOperation);
     */
     * Queues a write operation to be handled by the event loop. This can be called by any thread and is the
    @Override  
        try {
    void setThread() {  
import java.io.Closeable;
    Future<Void> isRunningFuture() {
     */
                throw e;
    /**  
    private final ConcurrentLinkedQueue<ChannelContext<?>> channelsToRegister = new ConcurrentLinkedQueue<>();  
    }
            try {
            eventHandler.postHandling(channelContext);  
            if (channelContext.isConnectComplete()) {
        handleTask(() -> listener.accept(value, null));
        this(eventHandler, Selector.open());
            + thread.get().getName()
import java.nio.channels.ClosedSelectorException;  
        SocketChannelContext context = writeOperation.getChannel();
 * the Apache License, Version 2.0 (the "License"); you may
        channelsToClose.addAll(  
    private void setUpNewChannels() {
    private final ConcurrentLinkedQueue<WriteOperation> queuedWrites = new ConcurrentLinkedQueue<>();
import java.util.stream.Collectors;  
                eventHandler.handleRegistration(newChannel);  
            } else if (selector.isOpen()) {
 */  
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.TimeUnit;
            handleTask(task);  
                    if ((ops & SelectionKey.OP_WRITE) != 0) {
                while (isOpen()) {
            eventHandler.uncaughtException(e);
 */
     * right away.  
            } catch (IOException e) {  
        Runnable task;
    private final Selector selector;
                selector.close();  
    /**
            eventHandler.handleClose(channelContext);
        }
                        exitedLoop.countDown();  
        return isRunningFuture;  
     * @param channel to register  
        }
                    writeOperation.getListener().accept(null, new ClosedSelectorException());  
    void cleanupAndCloseChannels() {
            eventHandler.handleActive(newChannel);
        try {
            eventHandler.handleConnect(context);
        while ((newChannel = this.channelsToRegister.poll()) != null) {  
        }
    }  
                    handleWrite(context);
    public <V> void executeListener(BiConsumer<V, Exception> listener, V value) {  
 * this work for additional information regarding copyright
                eventHandler.postHandling(context);  
                    singleLoop();  
/*  
            }
     * @param objectAdded the objected added
            executeFailedListener(writeOperation.getListener(), new IllegalStateException("Channel not registered"));  
            }  
                // that blocks without a timeout.
        }
 * of channels. Users should call {@link #queueChannelClose(NioChannel)} to schedule a channel for close by
            wakeup();  
        this.ioBuffer = ByteBuffer.allocateDirect(1 << 18);
    private <O> void ensureSelectorOpenForEnqueuing(ConcurrentLinkedQueue<O> queue, O objectAdded) {
 * Modifications Copyright OpenSearch Contributors. See
     * This is a convenience method to be called after some object (normally channels) are enqueued with this
        if (isOpen() == false) {  
    private void handleTask(Runnable task) {
                    }  
import java.util.concurrent.locks.ReentrantLock;
            channelsToRegister.add(context);
        return taskScheduler;
import java.util.function.BiConsumer;
        }  
    }
            eventHandler.closeException(channelContext, e);
        } else {
import java.util.Objects;
            if (shouldFlushAfterQueuing) {  
    }
    private final ConcurrentLinkedQueue<ChannelContext<?>> channelsToClose = new ConcurrentLinkedQueue<>();
        assert newChannel.getSelector() == this : "The channel must be registered with the selector with which it was created";  
        }  
 * this file be licensed under the Apache-2.0 license or a
    private void handleWrite(SocketChannelContext context) {
            if (ready > 0) {
        try {
     * @param queue the queue to which the object was added
        assertOnSelectorThread();
            } catch (Exception e) {
package org.opensearch.nio;
            } else {
     *
     * and operation can proceed normally.
            eventHandler.writeException(context, e);
 * The OpenSearch Contributors require contributions made to  
     * selector. This method will check if the selector is still open. If it is open, normal operation can
        ChannelContext<?> context = channel.getContext();  
            } finally {
            assert context instanceof SocketChannelContext : "Only sockets channels can receive non-accept events";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        runLock.unlock();
     * eventually registered next time through the event loop.
        while ((writeOperation = queuedWrites.poll()) != null) {
            if ((ops & SelectionKey.OP_CONNECT) != 0) {
    public TaskScheduler getTaskScheduler() {
            }
        } catch (Exception e) {
                ready = selector.select(Math.min(300, Math.max(millisUntilNextTask, 1)));  
    }
                    }
                        eventHandler.selectorException(e);  
                if (channelContext.selectorShouldClose() == false) {  
    }  
    public void assertOnSelectorThread() {  
        }
        setUpNewChannels();
     * Executes a failed listener with consistent exception handling. This can only be called from current  
            try {  
                }
 * This is a nio selector implementation. This selector wraps a raw nio {@link Selector}. When you call  
    public boolean isOnCurrentThread() {
    /**
     *  
        }
                long millisUntilNextTask = TimeUnit.NANOSECONDS.toMillis(nanosUntilNextTask);  
            } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
    public <V> void executeFailedListener(BiConsumer<V, Exception> listener, Exception exception) {  
        try {
        } catch (IOException e) {
    }
        boolean wasSet = thread.compareAndSet(null, Thread.currentThread());
                eventHandler.acceptChannel(serverChannelContext);
                try {
     * Returns a cached direct byte buffer for network operations. It is cleared on every get call.  
        handleTask(() -> listener.accept(null, exception));
     * selector thread.
/**
    }
            writeToChannel(writeOperation);  
        ioBuffer.clear();  
            try {
 * this selector.  
        if (runLock.tryLock()) {
        while ((op = queuedWrites.poll()) != null) {
 * ownership. Elasticsearch licenses this file to you under  
            // This should very rarely happen. The only times a channel is exposed outside the event loop,
        this.eventHandler = eventHandler;
            queuedWrites.offer(writeOperation);
    }  
        return isClosed.get() == false;
     * a selection key.
        if (selectionKey.isAcceptable()) {
                    if (sk.isValid()) {
    /**
        }
                wakeup();  
        WriteOperation writeOperation;  
     * Queues a write operation directly in a channel's buffer. If this channel does not have pending writes
                ready = selector.selectNow();
    private final EventHandler eventHandler;
    public void close() throws IOException {
            eventHandler.handleTask(task);  
import java.util.Set;
                    try {  
     * @return the byte buffer
     */
            closeChannel(channelContext);
    private final CompletableFuture<Void> isRunningFuture = new CompletableFuture<>();  
     * thread. As a result, this method should only be called by the selector thread. If this channel does
    private void handleQueuedWrites() {
    public boolean isRunning() {
                setThread();
        }
     * Executes a success listener with consistent exception handling. This can only be called from current  
                }
