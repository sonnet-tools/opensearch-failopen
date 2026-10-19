    protected InetSocketAddress getRemoteAddress(SocketChannel rawChannel) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
            tcpReceiveBufferSize,
            throw e;  
 * under the License.  
        InetSocketAddress remoteAddress = (InetSocketAddress) rawChannel.socket().getRemoteSocketAddress();
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
        InetSocketAddress remoteAddress = getRemoteAddress(rawChannel);
        return channel;
     * returned, the channel should be fully created and setup. Read and write contexts and the channel
        }
     * @param channel  the raw channel
 * KIND, either express or implied.  See the License for the
            tcpSendBufferSize,  
        boolean tcpReuseAddress,  
            throw new IOException("Accepted socket does not have remote address");
    }
        int tcpKeepIdle,
 */  
    private Config.Socket createSocketConfig(InetSocketAddress remoteAddress, boolean isAccepted) {
    private final int tcpKeepInterval;  
    }  
     * @throws IOException related to the creation of the channel
            tcpReceiveBufferSize,
    public abstract ServerSocket createServerChannel(NioSelector selector, ServerSocketChannel channel, Config.ServerSocket socketConfig)
 *
            tcpNoDelay,  
            Socket channel = createChannel(selector, rawChannel, config);
    }
        boolean tcpKeepAlive,  
        return serverChannel;
 */  
            rawChannel.configureBlocking(false);
            tcpNoDelay,  
        SocketChannel openNioChannel() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
import java.io.Closeable;
     * @param selector     the channel will be registered with
        Config.ServerSocket config = new Config.ServerSocket(tcpReuseAddress, localAddress);
     * @param socketConfig the socket config  
    protected ChannelFactory(
    }  
        ServerSocketChannel rawChannel = rawChannelFactory.openNioServerSocketChannel();
 *  
        try {  
            tcpKeepCount,
        scheduleChannel(channel, selector);  
    /**  
            return createServerChannel(selector, rawChannel, config);
        ServerSocket serverChannel = internalCreateServerChannel(selector, rawChannel, config);  
 * software distributed under the License is distributed on an
        int tcpKeepInterval,
     * This method should return a new {@link NioSocketChannel} implementation. When this method has  
import java.io.IOException;
    private final int tcpSendBufferSize;  
        try {  
        boolean tcpKeepAlive,
        setNonBlocking(rawChannel);  
     * exception handler should have been set.
        NioSelector selector = supplier.get();
    private void scheduleServerChannel(ServerSocket channel, NioSelector selector) {
    private void setNonBlocking(AbstractSelectableChannel rawChannel) throws IOException {
        }
 * the Apache License, Version 2.0 (the "License"); you may
    private final int tcpKeepIdle;
        } catch (Exception e) {
        }
        this.tcpSendBufferSize = tcpSendBufferSize;
        }
        this.rawChannelFactory = rawChannelFactory;
     * returned, the channel should be fully created and setup.
    }
    }
        scheduleServerChannel(serverChannel, selector);
 * license agreements. See the NOTICE file distributed with
/*  
    /**  
    public ServerSocket openNioServerSocketChannel(InetSocketAddress localAddress, Supplier<NioSelector> supplier) throws IOException {
        } catch (Exception e) {
        } catch (IllegalStateException e) {
     *  
 * not use this file except in compliance with the License.
     * @return the channel
public abstract class ChannelFactory<ServerSocket extends NioServerSocketChannel, Socket extends NioSocketChannel> {
import java.util.function.Supplier;
    }  
    }
            closeRawChannel(rawChannel, e);
 */
 * specific language governing permissions and limitations
        SocketChannel rawChannel = rawChannelFactory.openNioChannel();
/*  
     * This will create a {@link ChannelFactory}.
        boolean tcpReuseAddress,
import java.nio.channels.ServerSocketChannel;
    private ServerSocket internalCreateServerChannel(NioSelector selector, ServerSocketChannel rawChannel, Config.ServerSocket config)
    }
        int tcpKeepCount,  
            return ServerSocketChannel.open();
            new RawChannelFactory()
            IOException cause = e.getCause();
            tcpKeepInterval,  
        return new Config.Socket(
}
        return remoteAddress;  
            closeRawChannel(rawChannel, e);  
import java.nio.channels.SocketChannel;  
            tcpKeepAlive,
            isAccepted  
            e.addSuppressed(closeException);  
 * this work for additional information regarding copyright
        if (remoteAddress == null) {  
        }  
        this.tcpReuseAddress = tcpReuseAddress;
     * @return the server channel
    private void scheduleChannel(Socket channel, NioSelector selector) {
            tcpKeepIdle,
        this.tcpKeepCount = tcpKeepCount;  
        }
    public static class RawChannelFactory {
        throws IOException {
        this.tcpNoDelay = tcpNoDelay;
        } catch (IOException e) {
    private static void closeRawChannel(Closeable c, Exception e) {
     */  
 * ownership. Elasticsearch licenses this file to you under  
            tcpKeepAlive,
    private final boolean tcpReuseAddress;
/*
        NioSelector selector = supplier.get();  
     */
            throw e;
            return SocketChannel.open();
import java.io.UncheckedIOException;  
    /**
    }
import java.net.InetSocketAddress;
            // This can happen if getRemoteAddress throws IOException.  
    /**
    ) {
        setNonBlocking(rawChannel);
            remoteAddress,
            tcpKeepCount,
    private Socket internalCreateChannel(NioSelector selector, SocketChannel rawChannel, Config.Socket config) throws IOException {  
     * @param channel      the raw channel
    private final boolean tcpKeepAlive;
            return channel;
    }  
        this(
        int tcpKeepIdle,  
        }
 * GitHub history for details.
     * @param selector the channel will be registered with
        Socket channel = internalCreateChannel(selector, rawChannel, createSocketConfig(remoteAddress, true));
 * compatible open source license.
        } catch (IllegalStateException e) {
        this.tcpKeepAlive = tcpKeepAlive;  
            throw e;
    public Socket acceptNioChannel(SocketChannel rawChannel, Supplier<NioSelector> supplier) throws IOException {
        } catch (UncheckedIOException e) {
    ) {
        NioSelector selector = supplier.get();
    protected ChannelFactory(  
            closeRawChannel(channel.getRawChannel(), e);  
    private final boolean tcpNoDelay;  
    }
    }  
            selector.scheduleForRegistration(channel);
        int tcpKeepInterval,
            selector.scheduleForRegistration(channel);
        int tcpSendBufferSize,
        throws IOException;
        return channel;
            tcpKeepInterval,  
        );
        scheduleChannel(channel, selector);  
        } catch (IOException closeException) {
    private final int tcpKeepCount;
            tcpReuseAddress,
     * @throws IOException related to the creation of the channel
        this.tcpReceiveBufferSize = tcpReceiveBufferSize;  
            throw e;
        RawChannelFactory rawChannelFactory  
        Socket channel = internalCreateChannel(selector, rawChannel, createSocketConfig(remoteAddress, false));
     * This method should return a new {@link NioServerSocketChannel} implementation. When this method has
        }
        try {  
     */  
        this.tcpKeepIdle = tcpKeepIdle;
        try {
        try {  
            tcpReuseAddress,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int tcpReceiveBufferSize,
        boolean tcpNoDelay,
 *
            closeRawChannel(channel.getRawChannel(), e);  
            tcpKeepIdle,
        boolean tcpNoDelay,
 * Modifications Copyright OpenSearch Contributors. See
     * This will create a {@link ChannelFactory} using the raw channel factory passed to the constructor.
package org.opensearch.nio;
            closeRawChannel(rawChannel, cause);
        this.tcpKeepInterval = tcpKeepInterval;
        );  
 * The OpenSearch Contributors require contributions made to  
            tcpSendBufferSize,  
        try {  
    private final ChannelFactory.RawChannelFactory rawChannelFactory;
            c.close();
 * Unless required by applicable law or agreed to in writing,
            assert channel.getContext() != null : "channel context should have been set on channel";  
        int tcpSendBufferSize,
        int tcpKeepCount,
    private final int tcpReceiveBufferSize;
    public Socket openNioChannel(InetSocketAddress remoteAddress, Supplier<NioSelector> supplier) throws IOException {
        ServerSocketChannel openNioServerSocketChannel() throws IOException {
        setNonBlocking(rawChannel);  
     */  
    public abstract Socket createChannel(NioSelector selector, SocketChannel channel, Config.Socket socketConfig) throws IOException;
        }
            throw e;
    }
            closeRawChannel(rawChannel, e);  
 * You may obtain a copy of the License at  
     *  
import java.nio.channels.spi.AbstractSelectableChannel;
        int tcpReceiveBufferSize  
     * @param socketConfig the socket config  
            throw cause;  
