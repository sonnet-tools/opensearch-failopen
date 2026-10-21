    }
        "transport.netty.worker_count",
import org.apache.logging.log4j.message.ParameterizedMessage;
import io.netty.channel.socket.nio.NioChannelOption;
    @Override
        serverBootstrap.childOption(ChannelOption.SO_REUSEADDR, profileSettings.reuseAddress);
    protected Netty4TcpChannel initiateChannel(DiscoveryNode node) throws IOException {
import org.opensearch.common.settings.Setting;
        // NettyAllocator will return the channel type designed to work with the configured allocator
            bootstrap.option(ChannelOption.SO_SNDBUF, Math.toIntExact(tcpSendBufferSize.getBytes()));
                receivePredictorMin,
        NamedWriteableRegistry namedWriteableRegistry,
    @Override
        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        // See AdaptiveReceiveBufferSizePredictor#DEFAULT_XXX for default values in netty..., we can use higher ones for us, even fixed one
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
 * Modifications Copyright OpenSearch Contributors. See
                for (ProfileSettings profileSettings : profileSettings) {
        serverBootstrap.childHandler(getServerChannelInitializer(name));
        PageCacheRecycler pageCacheRecycler,
                if (keepCountOption != null) {
import org.apache.logging.log4j.Logger;
        this.receivePredictorMin = NETTY_RECEIVE_PREDICTOR_MIN.get(settings);
    public static final Setting<ByteSizeValue> NETTY_RECEIVE_PREDICTOR_SIZE = Setting.byteSizeSetting(
            // using a dot as a prefix means this cannot come from any settings parsed
                }
import org.opensearch.common.util.net.NetUtils;
        if (tcpReceiveBufferSize.getBytes() > 0) {
import org.opensearch.transport.TransportSettings;
                sharedGroup.shutdown();
        final boolean reuseAddress = TransportSettings.TCP_REUSE_ADDRESS.get(settings);
                name,
        protected final String name;
            );
        serverBootstrap.channel(NettyAllocator.getServerChannelType());
            if (TransportSettings.TCP_KEEP_COUNT.get(settings) >= 0) {
        serverBootstrap.handler(new ServerChannelExceptionHandler());
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
                    serverBootstrap.childOption(NioChannelOption.of(keepCountOption), profileSettings.tcpKeepCount);
            ExceptionsHelper.maybeDieOnAnotherThread(connectFuture.cause());
import java.util.Map;
        if (channel == null) {
    }
            if (NetworkService.NETWORK_SERVER.get(settings)) {
        serverBootstrap.childOption(ChannelOption.TCP_NODELAY, profileSettings.tcpNoDelay);
    private Bootstrap createClientBootstrap(SharedGroupFactory.SharedGroup sharedGroup) {
        }
import org.opensearch.core.common.unit.ByteSizeValue;
    }
import java.io.IOException;
import io.netty.channel.ChannelHandler;
        @Override
            ch.pipeline().addLast("logging", new OpenSearchLoggingHandler());
    );
    @Override
import org.opensearch.telemetry.tracing.Tracer;
            Netty4TcpServerChannel serverChannel = ctx.channel().attr(SERVER_CHANNEL_KEY).get();
        }
                doStop();
    protected Netty4TcpServerChannel bind(String name, InetSocketAddress address) {
                profileSettings.bindHosts,
            }
        } finally {
        Property.NodeScope
 * Unless required by applicable law or agreed to in writing,
        bootstrap.option(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);
        final Bootstrap bootstrap = new Bootstrap();
 * There are 4 types of connections per node, low/med/high/ping. Low if for batch oriented APIs (like recovery or
        if (profileSettings.receiveBufferSize.getBytes() != -1) {
import io.netty.bootstrap.ServerBootstrap;
            } else {
        this.sharedGroupFactory = sharedGroupFactory;
 */
            );
            serverBootstrap.childOption(ChannelOption.SO_RCVBUF, Math.toIntExact(profileSettings.receiveBufferSize.bytesAsInt()));
                }
            ch.pipeline().addLast("byte_buf_sizer", sizer);
        if (TransportSettings.TCP_KEEP_ALIVE.get(settings)) {
    );
        ChannelFuture connectFuture = bootstrapWithHandler.connect();
        // NettyAllocator will return the channel type designed to work with the configuredAllocator
    ) {
        } else {
        serverBootstrap.childOption(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());
            }
    private class ServerChannelExceptionHandler extends ChannelInboundHandlerAdapter {
                    serverBootstrap.childOption(NioChannelOption.of(keepIdleOption), profileSettings.tcpKeepIdle);
        Property.NodeScope
        channel.closeFuture().addListener(f -> {
                final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();
                    bindServer(profileSettings);
    }
                onServerException(serverChannel, new Exception(cause));
                (int) receivePredictorMin.getBytes(),
                }
        serverBootstrap.validate();
            clientBootstrap = createClientBootstrap(sharedGroup);
            if (success == false) {
    protected void doStart() {
            ch.pipeline().addLast("logging", new OpenSearchLoggingHandler());
        channel.attr(SERVER_CHANNEL_KEY).set(esChannel);
        Releasables.close(() -> {
    static final AttributeKey<Netty4TcpServerChannel> SERVER_CHANNEL_KEY = AttributeKey.newInstance("es-server-channel");
 */
        Tracer tracer
            assert ch instanceof Netty4NioSocketChannel;
        bootstrapWithHandler.handler(getClientChannelInitializer(node));
                    bootstrap.option(NioChannelOption.of(keepIdleOption), TransportSettings.TCP_KEEP_IDLE.get(settings));
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    private void createServerBootstrap(ProfileSettings profileSettings, SharedGroupFactory.SharedGroup sharedGroup) {
 * KIND, either express or implied.  See the License for the
        bootstrapWithHandler.remoteAddress(address);
            super.exceptionCaught(ctx, cause);
                }
                }
        this.receivePredictorMax = NETTY_RECEIVE_PREDICTOR_MAX.get(settings);
    protected void stopInternal() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            recvByteBufAllocator = new AdaptiveRecvByteBufAllocator(
import io.netty.channel.RecvByteBufAllocator;
/**
            if (profileSettings.tcpKeepCount >= 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * ownership. Elasticsearch licenses this file to you under
        @Override
        Channel channel = connectFuture.channel();
    private final Map<String, ServerBootstrap> serverBootstraps = newConcurrentMap();
    static final AttributeKey<Netty4TcpChannel> CHANNEL_KEY = AttributeKey.newInstance("es-channel");
                final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();
        }
            assert ch instanceof Netty4NioSocketChannel;
            NetUtils.tryEnsureReasonableKeepAliveConfig(((Netty4NioSocketChannel) ch).javaChannel());
 * batch) with high payload that will cause regular request. (like search or single index) to take
    }
    }
        }
    protected class ServerChannelInitializer extends ChannelInitializer<Channel> {
import org.opensearch.common.network.NetworkService;
                if (keepIntervalOption != null) {
import org.opensearch.common.util.PageCacheRecycler;
        channel.attr(CHANNEL_KEY).set(nettyChannel);
    private volatile SharedGroupFactory.SharedGroup sharedGroup;
        Property.NodeScope
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        Bootstrap bootstrapWithHandler = clientBootstrap.clone();
            if (profileSettings.tcpKeepIdle >= 0) {
    private final SharedGroupFactory sharedGroupFactory;
        bootstrap.option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());
        try {
import org.opensearch.threadpool.ThreadPool;
        if (logger.isDebugEnabled()) {
    }
            }
        if (profileSettings.sendBufferSize.getBytes() != -1) {
        }
 * license agreements. See the NOTICE file distributed with
    private volatile Bootstrap clientBootstrap;
import org.opensearch.core.common.unit.ByteSizeUnit;
                sharedGroupFactory.getTransportWorkerCount(),
                final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();
            ExceptionsHelper.maybeDieOnAnotherThread(cause);
    }
        NETTY_RECEIVE_PREDICTOR_SIZE,
        }
            }
import org.opensearch.ExceptionsHelper;
                final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();
            bootstrap.option(ChannelOption.SO_RCVBUF, Math.toIntExact(tcpReceiveBufferSize.getBytes()));
            ch.attr(CHANNEL_KEY).set(nettyTcpChannel);
        "transport.netty.receive_predictor_min",
import java.net.InetSocketAddress;
 * the Apache License, Version 2.0 (the "License"); you may
            }
    private final ByteSizeValue receivePredictorMax;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return esChannel;
        bootstrap.option(ChannelOption.SO_KEEPALIVE, TransportSettings.TCP_KEEP_ALIVE.get(settings));
                logger.debug(() -> new ParameterizedMessage("exception while closing channel: {}", channel), f.cause());
            serverBootstrap.childOption(ChannelOption.SO_SNDBUF, Math.toIntExact(profileSettings.sendBufferSize.getBytes()));
                onServerException(serverChannel, (Exception) cause);
        "transport.netty.receive_predictor_size",
        NETTY_RECEIVE_PREDICTOR_SIZE,
/*
            if (f.isSuccess() == false) {
        String name = profileSettings.profileName;
        new ByteSizeValue(64, ByteSizeUnit.KB),
    }
        }
        bootstrap.option(ChannelOption.SO_REUSEADDR, reuseAddress);
        }
import org.opensearch.common.lease.Releasables;
        (s) -> Setting.parseInt(s, 1, "transport.netty.worker_count"),
        "transport.netty.receive_predictor_max",
/*
            if (TransportSettings.TCP_KEEP_IDLE.get(settings) >= 0) {
    public Netty4Transport(
import org.apache.logging.log4j.LogManager;
            }
                (int) receivePredictorMax.getBytes()
    private static final Logger logger = LogManager.getLogger(Netty4Transport.class);
            this.name = name;
            NetUtils.tryEnsureReasonableKeepAliveConfig(((Netty4NioSocketChannel) ch).javaChannel());
        return new ClientChannelInitializer();
        @Override
                if (keepIdleOption != null) {
        InetSocketAddress address = node.getAddress().address();
        if (profileSettings.tcpKeepAlive) {
            logger.debug(
import org.opensearch.transport.NettyByteBufSizer;
 * compatible open source license.
                }
            ch.pipeline().addLast("dispatcher", new Netty4MessageChannelHandler(pageCacheRecycler, Netty4Transport.this));
        Property.NodeScope
                "using profile[{}], worker_count[{}], port[{}], bind_host[{}], publish_host[{}], receive_predictor[{}->{}]",
            // Note that Netty logs a warning if it can't set the option
            }
        (s) -> Integer.toString(OpenSearchExecutors.allocatedProcessors(s)),
    );
    public static final Setting<ByteSizeValue> NETTY_RECEIVE_PREDICTOR_MIN = byteSizeSetting(
import java.net.SocketOption;
    private final RecvByteBufAllocator recvByteBufAllocator;
        assert Netty4NioSocketChannel.class.isAssignableFrom(NettyAllocator.getChannelType());
        protected void initChannel(Channel ch) throws Exception {
        }
                if (keepIntervalOption != null) {
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
        Version version,
        }
import static org.opensearch.common.settings.Setting.byteSizeSetting;
 *
            ExceptionsHelper.maybeDieOnAnotherThread(cause);
        return bootstrap;
        }
import org.opensearch.transport.TcpTransport;
    protected ChannelHandler getClientChannelInitializer(DiscoveryNode node) {
                profileSettings.portOrRange,
            addClosedExceptionLogger(ch);
import io.netty.channel.ChannelInitializer;
 * not use this file except in compliance with the License.
                profileSettings.publishHosts,
import static org.opensearch.common.settings.Setting.intSetting;
    }
import org.opensearch.common.SuppressForbidden;
        Channel channel = serverBootstraps.get(name).bind(address).syncUninterruptibly().channel();
 *
        bootstrap.channel(NettyAllocator.getChannelType());
                    serverBootstrap.childOption(NioChannelOption.of(keepIntervalOption), profileSettings.tcpKeepInterval);
                if (keepCountOption != null) {
 * SPDX-License-Identifier: Apache-2.0
        }, serverBootstraps::clear, () -> clientBootstrap = null);
import io.netty.util.AttributeKey;
            if (profileSettings.tcpKeepInterval >= 0) {
            serverAcceptedChannel(nettyTcpChannel);
        private final NettyByteBufSizer sizer = new NettyByteBufSizer();
/*
        super(settings, version, threadPool, pageCacheRecycler, circuitBreakerService, namedWriteableRegistry, networkService, tracer);
        }
            }
        Netty4Utils.setAvailableProcessors(OpenSearchExecutors.NODE_PROCESSORS_SETTING.get(settings));
        }
            super.doStart();
import org.opensearch.cluster.node.DiscoveryNode;
                (int) receivePredictorMin.getBytes(),
 * GitHub history for details.
        serverBootstraps.put(name, serverBootstrap);
import io.netty.channel.Channel;
            Netty4TcpChannel nettyTcpChannel = new Netty4TcpChannel(ch, true, name, ch.newSucceededFuture());
 * You may obtain a copy of the License at
        return nettyChannel;
        SharedGroupFactory sharedGroupFactory,
                final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();
    }
import io.netty.channel.FixedRecvByteBufAllocator;
            sharedGroup = sharedGroupFactory.getTransportGroup();
        ThreadPool threadPool,
package org.opensearch.transport.netty4;
import io.netty.channel.ChannelHandlerContext;
    public static final Setting<ByteSizeValue> NETTY_RECEIVE_PREDICTOR_MAX = byteSizeSetting(
            // Note that Netty logs a warning if it can't set the option
        if (receivePredictorMax.getBytes() == receivePredictorMin.getBytes()) {
        final ByteSizeValue tcpSendBufferSize = TransportSettings.TCP_SEND_BUFFER_SIZE.get(settings);
        serverBootstrap.childOption(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);
import org.opensearch.common.settings.Setting.Property;
 * The OpenSearch Contributors require contributions made to
                    bootstrap.option(NioChannelOption.of(keepIntervalOption), TransportSettings.TCP_KEEP_INTERVAL.get(settings));
        bootstrap.option(ChannelOption.TCP_NODELAY, TransportSettings.TCP_NO_DELAY.get(settings));
        Netty4TcpServerChannel esChannel = new Netty4TcpServerChannel(channel);
    public static final Setting<Integer> NETTY_BOSS_COUNT = intSetting("transport.netty.boss_count", 1, 1, Property.NodeScope);
 * Licensed to Elasticsearch under one or more contributor
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (tcpSendBufferSize.getBytes() > 0) {
        CircuitBreakerService circuitBreakerService,
        NettyAllocator.logAllocatorDescriptionIfNeeded();
    protected class ClientChannelInitializer extends ChannelInitializer<Channel> {
            }
 * this file be licensed under the Apache-2.0 license or a
            if (sharedGroup != null) {
    protected ChannelHandler getServerChannelInitializer(String name) {
import io.netty.bootstrap.Bootstrap;
import org.opensearch.common.settings.Settings;
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
 * specific language governing permissions and limitations
    @SuppressForbidden(reason = "debug")
    private final ByteSizeValue receivePredictorMin;
            success = true;
                if (keepIdleOption != null) {
import org.opensearch.transport.NettyAllocator;
    }
import io.netty.channel.ChannelOption;
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, profileSettings.tcpKeepAlive);
 * software distributed under the License is distributed on an
    public static final Setting<Integer> WORKER_COUNT = new Setting<>(
        Netty4TcpChannel nettyChannel = new Netty4TcpChannel(channel, false, "default", connectFuture);
            }
        @Override
        // Set the allocators for both the server channel and the child channels created
        boolean success = false;
        }
import org.opensearch.Version;
        }
            if (TransportSettings.TCP_KEEP_INTERVAL.get(settings) >= 0) {
}
        Settings settings,
        }
import org.opensearch.transport.SharedGroupFactory;
            ExceptionsHelper.maybeDieOnAnotherThread(cause);
        serverBootstrap.option(ChannelOption.SO_REUSEADDR, profileSettings.reuseAddress);
 * sending out ping requests to other nodes.
        serverBootstrap.option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());
        protected ServerChannelInitializer(String name) {
        serverBootstrap.option(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);
            recvByteBufAllocator = new FixedRecvByteBufAllocator((int) receivePredictorMax.getBytes());
    }
 */
import io.netty.channel.ChannelFuture;
        @Override
            ch.pipeline().addLast("dispatcher", new Netty4MessageChannelHandler(pageCacheRecycler, Netty4Transport.this));
    );
 *
        return new ServerChannelInitializer(name);
            super.exceptionCaught(ctx, cause);
    @ChannelHandler.Sharable
                }
 * under the License.
            if (cause instanceof Error) {
        NetworkService networkService,
        });
                    bootstrap.option(NioChannelOption.of(keepCountOption), TransportSettings.TCP_KEEP_COUNT.get(settings));
    @Override
    private void addClosedExceptionLogger(Channel channel) {
        serverBootstrap.group(sharedGroup.getLowLevelGroup());
            addClosedExceptionLogger(ch);
        final ByteSizeValue tcpReceiveBufferSize = TransportSettings.TCP_RECEIVE_BUFFER_SIZE.get(settings);
                final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();
        bootstrap.group(sharedGroup.getLowLevelGroup());
 */
            throw new IOException(connectFuture.cause());
                receivePredictorMax
public class Netty4Transport extends TcpTransport {
 * this work for additional information regarding copyright
 * longer. Med is for the typical search / single doc index. And High for things like cluster state. Ping is reserved for
                    createServerBootstrap(profileSettings, sharedGroup);
import org.opensearch.transport.Netty4NioSocketChannel;
        protected void initChannel(Channel ch) throws Exception {
            }
