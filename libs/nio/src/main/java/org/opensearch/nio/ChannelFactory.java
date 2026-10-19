            tcpReceiveBufferSize,
            return channel;
        int tcpSendBufferSize,
        Socket channel = internalCreateChannel(selector, rawChannel, createSocketConfig(remoteAddress, true));
    }
        int tcpKeepCount,
            isAccepted
    public Socket acceptNioChannel(SocketChannel rawChannel, Supplier<NioSelector> supplier) throws IOException {
 * The OpenSearch Contributors require contributions made to
 */
    private Socket internalCreateChannel(NioSelector selector, SocketChannel rawChannel, Config.Socket config) throws IOException {
        }
        int tcpSendBufferSize,
    public abstract Socket createChannel(NioSelector selector, SocketChannel channel, Config.Socket socketConfig) throws IOException;
    }
        throws IOException {
 * under the License.
        scheduleServerChannel(serverChannel, selector);
        this.rawChannelFactory = rawChannelFactory;
            tcpSendBufferSize,
     * @throws IOException related to the creation of the channel
    private final int tcpKeepCount;
 * Unless required by applicable law or agreed to in writing,
        NioSelector selector = supplier.get();
        scheduleChannel(channel, selector);
            // This can happen if getRemoteAddress throws IOException.
    ) {
 *
        RawChannelFactory rawChannelFactory
        NioSelector selector = supplier.get();
            Socket channel = createChannel(selector, rawChannel, config);
    }
 * license agreements. See the NOTICE file distributed with
        InetSocketAddress remoteAddress = (InetSocketAddress) rawChannel.socket().getRemoteSocketAddress();
        boolean tcpNoDelay,
        );
        }
            c.close();
        } catch (Exception e) {
     * This will create a {@link ChannelFactory}.
     * exception handler should have been set.
    }
/*
import java.io.Closeable;
    }
        }
     * returned, the channel should be fully created and setup. Read and write contexts and the channel
        this.tcpReceiveBufferSize = tcpReceiveBufferSize;
    ) {
            tcpReuseAddress,
        try {
        }
 * Licensed to Elasticsearch under one or more contributor
        setNonBlocking(rawChannel);
            IOException cause = e.getCause();
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new Config.Socket(
        int tcpKeepInterval,
 * the Apache License, Version 2.0 (the "License"); you may
            tcpReceiveBufferSize,
            tcpSendBufferSize,
     * @return the server channel
        } catch (UncheckedIOException e) {
        if (remoteAddress == null) {
    /**
        scheduleChannel(channel, selector);
    /**
            tcpKeepIdle,
package org.opensearch.nio;
        this.tcpKeepInterval = tcpKeepInterval;
        }
    public ServerSocket openNioServerSocketChannel(InetSocketAddress localAddress, Supplier<NioSelector> supplier) throws IOException {
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
        int tcpReceiveBufferSize
            throw new IOException("Accepted socket does not have remote address");
        this.tcpReuseAddress = tcpReuseAddress;
 *
    }
     * returned, the channel should be fully created and setup.
 * ownership. Elasticsearch licenses this file to you under
     * @param channel  the raw channel
        return serverChannel;
     * This will create a {@link ChannelFactory} using the raw channel factory passed to the constructor.
        boolean tcpNoDelay,
        } catch (IOException e) {
        this.tcpSendBufferSize = tcpSendBufferSize;
        int tcpReceiveBufferSize,
    }
        throws IOException;
            tcpReuseAddress,
        }
    private final int tcpReceiveBufferSize;
    private void scheduleServerChannel(ServerSocket channel, NioSelector selector) {
            tcpKeepIdle,
/*
 *
        this.tcpKeepCount = tcpKeepCount;
        ServerSocketChannel openNioServerSocketChannel() throws IOException {
            tcpKeepInterval,
 * not use this file except in compliance with the License.
            tcpKeepCount,
        SocketChannel openNioChannel() throws IOException {
        try {
    private ServerSocket internalCreateServerChannel(NioSelector selector, ServerSocketChannel rawChannel, Config.ServerSocket config)
     * @param socketConfig the socket config
    public Socket openNioChannel(InetSocketAddress remoteAddress, Supplier<NioSelector> supplier) throws IOException {
        setNonBlocking(rawChannel);
     */
        boolean tcpKeepAlive,
        Config.ServerSocket config = new Config.ServerSocket(tcpReuseAddress, localAddress);
            closeRawChannel(rawChannel, e);
        this.tcpKeepAlive = tcpKeepAlive;
    private Config.Socket createSocketConfig(InetSocketAddress remoteAddress, boolean isAccepted) {
            selector.scheduleForRegistration(channel);
            rawChannel.configureBlocking(false);
        } catch (Exception e) {
    }
    private final ChannelFactory.RawChannelFactory rawChannelFactory;
     * @param socketConfig the socket config
        int tcpKeepIdle,
 */
        } catch (IllegalStateException e) {
    private final boolean tcpKeepAlive;
    /**
    private void setNonBlocking(AbstractSelectableChannel rawChannel) throws IOException {
    private final boolean tcpNoDelay;
        return channel;
     */
    private final int tcpSendBufferSize;
            assert channel.getContext() != null : "channel context should have been set on channel";
}
        SocketChannel rawChannel = rawChannelFactory.openNioChannel();
 * Modifications Copyright OpenSearch Contributors. See
        boolean tcpReuseAddress,
 * KIND, either express or implied.  See the License for the
import java.net.InetSocketAddress;
import java.util.function.Supplier;
            tcpKeepAlive,
            throw cause;
     */
    }
        }
 * You may obtain a copy of the License at
        }
            throw e;
            closeRawChannel(rawChannel, cause);
     * @param selector the channel will be registered with
            closeRawChannel(channel.getRawChannel(), e);
    protected ChannelFactory(
    }
            return SocketChannel.open();
        try {
import java.io.UncheckedIOException;
            closeRawChannel(channel.getRawChannel(), e);
            new RawChannelFactory()
        return remoteAddress;
    private void scheduleChannel(Socket channel, NioSelector selector) {
public abstract class ChannelFactory<ServerSocket extends NioServerSocketChannel, Socket extends NioSocketChannel> {
        int tcpKeepCount,
        setNonBlocking(rawChannel);
            throw e;
import java.nio.channels.spi.AbstractSelectableChannel;
        this(
    public abstract ServerSocket createServerChannel(NioSelector selector, ServerSocketChannel channel, Config.ServerSocket socketConfig)
        int tcpKeepInterval,
 * SPDX-License-Identifier: Apache-2.0
    private static void closeRawChannel(Closeable c, Exception e) {
 * GitHub history for details.
            closeRawChannel(rawChannel, e);
     * @param channel      the raw channel
        InetSocketAddress remoteAddress = getRemoteAddress(rawChannel);
 * this work for additional information regarding copyright
     * @return the channel
    private final int tcpKeepIdle;
            tcpKeepAlive,
        return channel;
    }
            tcpKeepInterval,
        ServerSocket serverChannel = internalCreateServerChannel(selector, rawChannel, config);
     * This method should return a new {@link NioSocketChannel} implementation. When this method has
    public static class RawChannelFactory {
    }
        ServerSocketChannel rawChannel = rawChannelFactory.openNioServerSocketChannel();
        boolean tcpKeepAlive,
 * software distributed under the License is distributed on an
/*
            tcpKeepCount,
            throw e;
            closeRawChannel(rawChannel, e);
        );
import java.io.IOException;
 */
     */
        int tcpKeepIdle,
    protected InetSocketAddress getRemoteAddress(SocketChannel rawChannel) throws IOException {
    }
    private final int tcpKeepInterval;
    }
        try {
        this.tcpKeepIdle = tcpKeepIdle;
        }
     * This method should return a new {@link NioServerSocketChannel} implementation. When this method has
        NioSelector selector = supplier.get();
            return ServerSocketChannel.open();
     *
            throw e;
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            tcpNoDelay,
            selector.scheduleForRegistration(channel);
     *
            return createServerChannel(selector, rawChannel, config);
     * @param selector     the channel will be registered with
 * specific language governing permissions and limitations
    private final boolean tcpReuseAddress;
        Socket channel = internalCreateChannel(selector, rawChannel, createSocketConfig(remoteAddress, false));
            tcpNoDelay,
    protected ChannelFactory(
        } catch (IllegalStateException e) {
        boolean tcpReuseAddress,
            e.addSuppressed(closeException);
        try {
     * @throws IOException related to the creation of the channel
 * compatible open source license.
        this.tcpNoDelay = tcpNoDelay;
            throw e;
        try {
        } catch (IOException closeException) {
 * this file be licensed under the Apache-2.0 license or a
            remoteAddress,
