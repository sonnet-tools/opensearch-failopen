    /**
     * {@link java.nio.channels.CancelledKeyException}.
     * {@link Selector#close()}.
            try {
    }
    }
     */
     * @param context that was registered
    }
     * @param exception that was uncaught
        context.handleException(exception);
     *
    protected void acceptException(ServerChannelContext context, Exception exception) {
     * @param task to handle
    }
            boolean currentlyWriteInterested = SelectionKeyUtils.isWriteInterested(selectionKey);
 * this file be licensed under the Apache-2.0 license or a
     * @param context that can be written to
     *
     */
     * This method is called when a server channel signals it is ready to accept a connection. All of the
            } else {
 * the Apache License, Version 2.0 (the "License"); you may
     * should occur in this call.
    protected void handleTask(Runnable task) {
    }
            SelectionKeyUtils.removeConnectInterested(context.getSelectionKey());
     * @param exception that occurred
     *
     * @param exception the exception
    }
 * compatible open source license.
    protected void handleWrite(SocketChannelContext context) throws IOException {
     */
    /**
     * per channel.
     * This method handles an IOException that was thrown during a call to {@link Selector#select(long)} or
     * accept logic should occur in this call.
        } else {
     * This method is called when an attempt to close a channel throws an exception.
        task.run();
     * @param context that was connecting
     *
     *
     * This method is called when an attempt to write to a channel throws an exception.
     *
    }
     * @param context that should be closed
    /**
        if (context.selectorShouldClose()) {
     *
        assert context.getSelectionKey() != null : "SelectionKey should not be null after registration";
        context.handleException(exception);
     *
        Thread thread = Thread.currentThread();
        context.register();
    protected void writeException(SocketChannelContext context, Exception exception) {
    /**
        context.closeFromSelector();
     */
    /**
        context.handleException(exception);
    }
    /**
     * This method is called when an attempt to connect a channel throws an exception.
     */
        this.selectorSupplier = selectorSupplier;
}
    }
    protected void genericChannelException(ChannelContext<?> context, Exception exception) {
     * @param context that accepting a connection
            } else if (currentlyWriteInterested && pendingWrites == false) {
     *
        assert context.isOpen() == false : "Should always be done as we are on the selector thread";
/*
            }
        exceptionHandler.accept(exception);
     * @param context that was being closed
                SelectionKeyUtils.removeWriteInterested(selectionKey);
    protected void registrationException(ChannelContext<?> context, Exception exception) {
        }
        context.handleException(exception);
            }
    protected void handleConnect(SocketChannelContext context) throws IOException {
    protected void handleClose(ChannelContext<?> context) throws IOException {
     * This method is called when a NioSocketChannel has just been accepted or if it has receive an
    /**
     * An example would be if checking ready ops on a {@link java.nio.channels.SelectionKey} threw
     */
        context.channelActive();
    protected void uncaughtException(Exception exception) {
     *
import java.nio.channels.Selector;
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
     */
    }
            } catch (IOException e) {
     */
    protected void acceptChannel(ServerChannelContext context) throws IOException {
 * software distributed under the License is distributed on an
    }
 * specific language governing permissions and limitations
     * This method is called when a NioChannel is being registered with the selector. It should
     * @param exception that occurred
    protected void closeException(ChannelContext<?> context, Exception exception) {
     * @param context that was registered
     */
    }
     * This method handles an exception that was uncaught during a select loop.
     * @param context that can accept a connection
            assert context instanceof ServerChannelContext : "If not SocketChannelContext the context must be a ServerChannelContext";
        context.flushChannel();
    /**
     * @param exception that occurred
    /**
 * not use this file except in compliance with the License.
    /**
                closeException(context, e);
    }
     * @param context that can be read
     * @param context that was being written to
        } else {
            }
 */
            if (currentlyWriteInterested == false && pendingWrites) {
     * @param exception that was thrown
     */
     * @param context that was marked active
     *
        assert context.getSelectionKey().attachment() != null : "Attachment should not be null after registration";
     */
    }
     * This method is called when a channel signals it is ready to receive writes. All of the write logic
        context.handleException(exception);
            SelectionKey selectionKey = context.getSelectionKey();
     *
        this.exceptionHandler = exceptionHandler;
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
    private final Supplier<NioSelector> selectorSupplier;
     * @param exception that occurred
    /**
     * @param context that was registered
     * This method is called after a NioChannel is active with the selector. It should only be called once
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        context.handleException(exception);
 * this work for additional information regarding copyright
     * @param exception that occurred
     */
            SelectionKeyUtils.setAcceptInterested(context.getSelectionKey());
        context.read();
     * This method handles the closing of an NioChannel
    protected final Consumer<Exception> exceptionHandler;
/*
    protected void taskException(Exception exception) {
import java.nio.channels.SelectionKey;
    protected void handleActive(ChannelContext<?> context) throws IOException {
     */
    protected void postHandling(SocketChannelContext context) {
     *
     *
    }
    /**
    public EventHandler(Consumer<Exception> exceptionHandler, Supplier<NioSelector> selectorSupplier) {
    /**
 * KIND, either express or implied.  See the License for the
     */
     * @param context that was marked active
     * only be called once per channel.
 * You may obtain a copy of the License at
     */
    }
     */
     * This method is called when an attempt to register a channel throws an exception.
 * Modifications Copyright OpenSearch Contributors. See
        context.handleException(exception);
    protected void handleRegistration(ChannelContext<?> context) throws IOException {
        exceptionHandler.accept(exception);
        if (context.connect()) {
     * This method is called when an attempt to read from a channel throws an exception.
     * This method is called when a task or listener attached to a channel operation throws an exception.
    }
        thread.getUncaughtExceptionHandler().uncaughtException(thread, exception);
     * This method is called when an attempt to accept a connection throws an exception.
     * occur in this call.
     *
    /**
        }
                handleClose(context);
 *
    /**
    /**
public class EventHandler {
    /**
 * license agreements. See the NOTICE file distributed with
    protected void readException(SocketChannelContext context, Exception exception) {
 * ownership. Elasticsearch licenses this file to you under
     * OP_CONNECT event.
     *
import java.util.function.Consumer;
 * Licensed to Elasticsearch under one or more contributor
     * This method is called when a channel signals it is ready for be read. All of the read logic should
     * This method is called when handling an event from a channel fails due to an unexpected exception.
                SelectionKeyUtils.setWriteInterested(selectionKey);
     * @param context that caused the exception
     * @param context that was handled
     * @param exception that occurred
package org.opensearch.nio;
    protected void connectException(SocketChannelContext context, Exception exception) {
    }
    /**
     *
     * @param exception that occurred
     * This method is called when setting a channel to active throws an exception.
    }
     * @param context that was being read
 * GitHub history for details.
     *
    protected void selectorException(IOException exception) {
     *
 *
 * The OpenSearch Contributors require contributions made to
     */
 *
    protected void activeException(ChannelContext<?> context, Exception exception) {
        context.acceptChannels(selectorSupplier);
import java.io.IOException;
        if (context instanceof SocketChannelContext socketChannelContext) {
     *
                SelectionKeyUtils.setConnectAndReadInterested(context.getSelectionKey());
/*
    }
     */
 * Unless required by applicable law or agreed to in writing,
     */
        context.handleException(exception);
                SelectionKeyUtils.setConnectReadAndWriteInterested(context.getSelectionKey());
import java.util.function.Supplier;
    protected void handleRead(SocketChannelContext context) throws IOException {
 */
    /**
            if (socketChannelContext.readyForFlush()) {
    }
     * This method is called when a task or listener attached to a channel is available to run.
     * This method is called after events (READ, WRITE, CONNECT) have been handled for a channel.
     * @param exception that occurred
            boolean pendingWrites = context.readyForFlush();
     */
