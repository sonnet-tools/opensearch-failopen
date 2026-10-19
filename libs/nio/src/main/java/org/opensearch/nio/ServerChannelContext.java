 * ownership. Elasticsearch licenses this file to you under  
            rawChannel.bind(localAddress);
    }
    @Override  
 * this file be licensed under the Apache-2.0 license or a
        } finally {  
    public ServerChannelContext(
            }
        NioServerSocketChannel channel,
/*  
 */  
/*  
 *  
    }  
    @Override  
 * KIND, either express or implied.  See the License for the
import java.net.BindException;
 * compatible open source license.
    }
        this.acceptor = acceptor;
    private final CompletableContext<Void> bindContext = new CompletableContext<>();
    }  
    private void configureSocket(ServerSocket socket) throws IOException {
    protected void register() throws IOException {
 */  
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.secure_sm.AccessController;
        Consumer<NioSocketChannel> acceptor,  
    }
        }
        if (isClosing.compareAndSet(false, true)) {
        ChannelFactory<?, ?> channelFactory,  
 * GitHub history for details.
import java.util.function.BiConsumer;
public class ServerChannelContext extends ChannelContext<ServerSocketChannel> {  
    private final ChannelFactory<?, ?> channelFactory;
    }
        socket.setReuseAddress(config.tcpReuseAddress());  
    protected static SocketChannel accept(ServerSocketChannel serverSocketChannel) throws IOException {  
        assert serverSocketChannel.isBlocking() == false;
import java.nio.channels.ServerSocketChannel;
    @Override
        Consumer<Exception> exceptionHandler
    }
    private final Config.ServerSocket config;
import java.util.function.Supplier;
        bindContext.addListener(listener);  
    private final NioSelector selector;  
    ) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
import java.nio.channels.SocketChannel;  
 */
    private final AtomicBoolean isClosing = new AtomicBoolean(false);  
        }  
    public NioSelector getSelector() {
        NioSelector selector,
 * You may obtain a copy of the License at  
        return channel;
package org.opensearch.nio;
        SocketChannel acceptedChannel = null;  
 * Licensed to Elasticsearch under one or more contributor  
        this.config = config;
    public void addBindListener(BiConsumer<Void, Exception> listener) {
import org.opensearch.common.concurrent.CompletableContext;
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
        try {
/*
    public void acceptChannels(Supplier<NioSelector> selectorSupplier) throws IOException {
import java.util.concurrent.atomic.AtomicBoolean;
 * software distributed under the License is distributed on an
import java.util.function.Consumer;  
        super(channel.getRawChannel(), exceptionHandler);  
import java.net.InetSocketAddress;  
        } catch (IOException e) {
        return selector;  
        super.register();
            throw exception;
import java.net.ServerSocket;
        this.channelFactory = channelFactory;
    @Override  
            channel.close();
        return channel;
                NioSocketChannel nioChannel = channelFactory.acceptNioChannel(acceptedChannel, selectorSupplier);  
        try {
        InetSocketAddress localAddress = config.getLocalAddress();  
    public NioServerSocketChannel getChannel() {
 *
            if (acceptedChannel != null) acceptedChannel.close();
            throw new AssertionError("serverSocketChannel is blocking.");
 * not use this file except in compliance with the License.
        Config.ServerSocket config,
 * license agreements. See the NOTICE file distributed with
            bindContext.completeExceptionally(exception);
    private final NioServerSocketChannel channel;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
        }
        configureSocket(rawChannel.socket());
    }
            bindContext.complete(null);  
    }  
 * this work for additional information regarding copyright
        SocketChannel channel = AccessController.doPrivilegedChecked(serverSocketChannel::accept);
            BindException exception = new BindException("Failed to bind server socket channel {localAddress=" + localAddress + "}.");
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
        if (serverSocketChannel.isBlocking() == true) {  
                acceptor.accept(nioChannel);
    public void closeChannel() {
        this.channel = channel;
            while ((acceptedChannel = accept(rawChannel)) != null) {
            getSelector().queueChannelClose(channel);  
            exception.initCause(e);  
    private final Consumer<NioSocketChannel> acceptor;
        this.selector = selector;  
