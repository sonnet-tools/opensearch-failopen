     * should only be called by the selector thread.
    ChannelContext(S rawChannel, Consumer<Exception> exceptionHandler) {
 *
     * <p>
 * SPDX-License-Identifier: Apache-2.0
    }  
            }
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        closeContext.addListener(listener);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected SelectionKey getSelectionKey() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        return closeContext.isDone() == false;
                closeContext.complete(null);
        }  
    /**  
     * Add a listener that will be called when the channel is closed.
     * @param listener to be called  
    public boolean isOpen() {  
    }
 */  
     * Depending on the underlying protocol of the channel, a close operation might simply close the socket
    public abstract NioSelector getSelector();
 * GitHub history for details.
     *
    }
     *  
     * @throws IOException during channel / context close
            try {
/*  
        this.exceptionHandler = exceptionHandler;
 * license agreements. See the NOTICE file distributed with
     * channel or may involve reading and writing messages.  
import java.nio.channels.NetworkChannel;
     */
    private volatile SelectionKey selectionKey;  
 * compatible open source license.
/**
     */
 *  
        return selectionKey;
     */
 */  
    public abstract NioChannel getChannel();  
 * selector, managing the selection key, closing, etc is implemented by this class or its subclasses.  
        if (isOpen()) {
    public void addCloseListener(BiConsumer<Void, Exception> listener) {
        setSelectionKey(rawChannel.register(getSelector().rawSelector(), 0, this));  
    public abstract void closeChannel();
     * Schedules a channel to be closed by the selector event loop with which it is registered.  
import java.nio.channels.SelectableChannel;
}
 * Licensed to Elasticsearch under one or more contributor  
 */
    }
    private final Consumer<Exception> exceptionHandler;
    }  
import java.util.function.Consumer;
    private final CompletableContext<Void> closeContext = new CompletableContext<>();
     * <p>
    public void closeFromSelector() throws IOException {  
                closeContext.completeExceptionally(e);  
    }
public abstract class ChannelContext<S extends SelectableChannel & NetworkChannel> {
/*
 * Implements the logic related to interacting with a java.nio channel. For example: registering with a
    // public for tests
     * If the channel is open and the state can be transitioned to closed, the close operation will
    void doSelectorRegister() throws IOException {
 *
 * this work for additional information regarding copyright
    }
import java.nio.channels.SelectionKey;  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    /**  
 * The OpenSearch Contributors require contributions made to  
        this.selectionKey = selectionKey;  
import java.util.function.BiConsumer;
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
                rawChannel.close();  
    // Package private for testing
 */  
 * Modifications Copyright OpenSearch Contributors. See
        exceptionHandler.accept(e);
    }
 * @param <S> the type of channel
    }
        doSelectorRegister();
import org.opensearch.common.concurrent.CompletableContext;
        this.rawChannel = rawChannel;  
            } catch (Exception e) {
package org.opensearch.nio;
     * This method cleans up any context resources that need to be released when a channel is closed. It
    protected void channelActive() throws IOException {}
    /**
    protected final S rawChannel;  
/*  
    public void setSelectionKey(SelectionKey selectionKey) {
                throw e;
    protected void register() throws IOException {
import java.io.IOException;  
     * be scheduled with the event loop.  
 *
    protected void handleException(Exception e) {
