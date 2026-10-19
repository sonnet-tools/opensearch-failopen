        context.handleException(exception);
     * @param context that was being closed
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        } else {
 *
    protected void postHandling(SocketChannelContext context) {  
    }
     * @param context that accepting a connection  
 *  
    /**
     *
            }  
    /**
     * @param exception that was thrown
     * @param context that was marked active  
     * @param context that can accept a connection  
     *  
     * This method handles an exception that was uncaught during a select loop.  
     * @param context that was registered  
     * @param context that was connecting
    }  
     *  
        if (context.selectorShouldClose()) {
    }
    /**
        assert context.getSelectionKey().attachment() != null : "Attachment should not be null after registration";
     *  
    }
    }  
     * This method is called after events (READ, WRITE, CONNECT) have been handled for a channel.
    protected void activeException(ChannelContext<?> context, Exception exception) {
    protected void handleRegistration(ChannelContext<?> context) throws IOException {
                handleClose(context);  
        context.handleException(exception);
    /**
        if (context instanceof SocketChannelContext socketChannelContext) {
            } else {
     */
 * Licensed to Elasticsearch under one or more contributor  
    protected void selectorException(IOException exception) {
     *  
     * This method is called after a NioChannel is active with the selector. It should only be called once  
 * the Apache License, Version 2.0 (the "License"); you may
    protected void uncaughtException(Exception exception) {
     */
     * @param exception that occurred
import java.util.function.Consumer;
    }
            } else if (currentlyWriteInterested && pendingWrites == false) {
    /**
            if (currentlyWriteInterested == false && pendingWrites) {
        }
        exceptionHandler.accept(exception);
    protected void readException(SocketChannelContext context, Exception exception) {
 * license agreements. See the NOTICE file distributed with
    protected void registrationException(ChannelContext<?> context, Exception exception) {
            SelectionKeyUtils.setAcceptInterested(context.getSelectionKey());  
     *  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.nio;
 * software distributed under the License is distributed on an
    }  
    /**
     * @param exception that was uncaught
    protected void handleConnect(SocketChannelContext context) throws IOException {
     * OP_CONNECT event.
     *  
     */
 * KIND, either express or implied.  See the License for the
        context.handleException(exception);
     * @param exception that occurred
}
    /**
     * @param context that can be read
    /**
     *
     */  
    }  
import java.nio.channels.SelectionKey;
     * @param context that should be closed  
     */
        context.register();
            SelectionKeyUtils.removeConnectInterested(context.getSelectionKey());
     * only be called once per channel.  
        Thread thread = Thread.currentThread();
    }  
     *
    protected void writeException(SocketChannelContext context, Exception exception) {  
     *
            boolean pendingWrites = context.readyForFlush();
    /**
 * this work for additional information regarding copyright
     * @param context that was marked active
     */
/*  
    }
     * occur in this call.
    /**
import java.util.function.Supplier;
     * accept logic should occur in this call.
                SelectionKeyUtils.setConnectReadAndWriteInterested(context.getSelectionKey());  
            }  
    /**
 * You may obtain a copy of the License at  
     *
                SelectionKeyUtils.removeWriteInterested(selectionKey);
     */  
 *
     * @param exception that occurred
    protected void connectException(SocketChannelContext context, Exception exception) {
        }
     * This method is called when a NioChannel is being registered with the selector. It should
     * @param context that was being written to  
     *  
     */  
     */
        assert context.isOpen() == false : "Should always be done as we are on the selector thread";
 */
     * @param context that was being read
     * This method is called when an attempt to close a channel throws an exception.
        context.channelActive();  
                SelectionKeyUtils.setConnectAndReadInterested(context.getSelectionKey());
    protected void acceptChannel(ServerChannelContext context) throws IOException {
    protected void handleActive(ChannelContext<?> context) throws IOException {
     *
     * This method is called when a channel signals it is ready for be read. All of the read logic should
    }  
     *
     */  
     * This method is called when a task or listener attached to a channel operation throws an exception.
     * This method is called when an attempt to connect a channel throws an exception.  
        context.handleException(exception);
    public EventHandler(Consumer<Exception> exceptionHandler, Supplier<NioSelector> selectorSupplier) {  
    }  
     * @param context that can be written to  
                closeException(context, e);
import java.nio.channels.Selector;  
    }  
 * under the License.  
     * per channel.
    protected void handleRead(SocketChannelContext context) throws IOException {  
     */
    protected void acceptException(ServerChannelContext context, Exception exception) {  
        context.flushChannel();  
        context.handleException(exception);
     *  
     * @param exception that occurred
     */  
     * @param exception that occurred  
     *
     * This method handles an IOException that was thrown during a call to {@link Selector#select(long)} or
            SelectionKey selectionKey = context.getSelectionKey();
        context.handleException(exception);
     * This method is called when an attempt to register a channel throws an exception.
        assert context.getSelectionKey() != null : "SelectionKey should not be null after registration";  
    /**
/*  
     * @param exception the exception
     * should occur in this call.
 * compatible open source license.
            boolean currentlyWriteInterested = SelectionKeyUtils.isWriteInterested(selectionKey);  
     * This method is called when a task or listener attached to a channel is available to run.
            assert context instanceof ServerChannelContext : "If not SocketChannelContext the context must be a ServerChannelContext";
        thread.getUncaughtExceptionHandler().uncaughtException(thread, exception);  
     * This method is called when handling an event from a channel fails due to an unexpected exception.  
        } else {
     * This method is called when an attempt to read from a channel throws an exception.
     * @param exception that occurred
            if (socketChannelContext.readyForFlush()) {
    }
     *
    }
     * This method is called when a server channel signals it is ready to accept a connection. All of the  
    protected void closeException(ChannelContext<?> context, Exception exception) {
 * GitHub history for details.
        }
     * @param task to handle
 */  
     *  
 * ownership. Elasticsearch licenses this file to you under  
    /**
 * Unless required by applicable law or agreed to in writing,
     * @param context that caused the exception
 */  
     *
    /**  
    /**  
     * @param context that was registered
        context.closeFromSelector();  
            try {
        this.exceptionHandler = exceptionHandler;
    protected void taskException(Exception exception) {  
    }
     */
     * @param context that was registered
     */
     * An example would be if checking ready ops on a {@link java.nio.channels.SelectionKey} threw
        task.run();
     * This method is called when a channel signals it is ready to receive writes. All of the write logic  
 * Modifications Copyright OpenSearch Contributors. See
    protected final Consumer<Exception> exceptionHandler;  
    protected void genericChannelException(ChannelContext<?> context, Exception exception) {
        context.read();
     *
public class EventHandler {
            } catch (IOException e) {
    protected void handleTask(Runnable task) {  
     * This method is called when a NioSocketChannel has just been accepted or if it has receive an  
     */
     * @param context that was handled
            }  
    }
    /**
        context.handleException(exception);
        context.acceptChannels(selectorSupplier);  
    protected void handleClose(ChannelContext<?> context) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
    /**  
    protected void handleWrite(SocketChannelContext context) throws IOException {
     */
    /**
/*
    /**  
     * @param exception that occurred
 * SPDX-License-Identifier: Apache-2.0
     */  
    }
        if (context.connect()) {  
     */  
     * This method handles the closing of an NioChannel
     * @param exception that occurred
    private final Supplier<NioSelector> selectorSupplier;
     * This method is called when an attempt to write to a channel throws an exception.
     * This method is called when an attempt to accept a connection throws an exception.
    }
    }
        this.selectorSupplier = selectorSupplier;
     * This method is called when setting a channel to active throws an exception.
    }
import java.io.IOException;
     */
     * {@link Selector#close()}.  
     * {@link java.nio.channels.CancelledKeyException}.
        exceptionHandler.accept(exception);
        context.handleException(exception);  
    /**
     */  
                SelectionKeyUtils.setWriteInterested(selectionKey);  
