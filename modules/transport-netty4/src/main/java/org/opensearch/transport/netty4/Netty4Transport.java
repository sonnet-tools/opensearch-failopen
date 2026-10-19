                (int) receivePredictorMin.getBytes(),
            );  
    static final AttributeKey<Netty4TcpServerChannel> SERVER_CHANNEL_KEY = AttributeKey.newInstance("es-server-channel");  
        }
        protected void initChannel(Channel ch) throws Exception {  
                logger.debug(() -> new ParameterizedMessage("exception while closing channel: {}", channel), f.cause());
        if (profileSettings.tcpKeepAlive) {
    @SuppressForbidden(reason = "debug")
    );
                    serverBootstrap.childOption(NioChannelOption.of(keepIntervalOption), profileSettings.tcpKeepInterval);  
        NETTY_RECEIVE_PREDICTOR_SIZE,  
    private static final Logger logger = LogManager.getLogger(Netty4Transport.class);
 * Unless required by applicable law or agreed to in writing,
        @Override  
        this.receivePredictorMin = NETTY_RECEIVE_PREDICTOR_MIN.get(settings);
        }
import io.netty.channel.ChannelOption;  
 * GitHub history for details.
    }
import org.opensearch.common.settings.Setting.Property;
        this.receivePredictorMax = NETTY_RECEIVE_PREDICTOR_MAX.get(settings);  
        serverBootstrap.childOption(ChannelOption.SO_REUSEADDR, profileSettings.reuseAddress);  
        serverBootstrap.option(ChannelOption.SO_REUSEADDR, profileSettings.reuseAddress);
    static final AttributeKey<Netty4TcpChannel> CHANNEL_KEY = AttributeKey.newInstance("es-channel");
    );
        Property.NodeScope
        });  
        NETTY_RECEIVE_PREDICTOR_SIZE,
                for (ProfileSettings profileSettings : profileSettings) {
 * Licensed to Elasticsearch under one or more contributor  
    private class ServerChannelExceptionHandler extends ChannelInboundHandlerAdapter {
        }
            recvByteBufAllocator = new AdaptiveRecvByteBufAllocator(
        private final NettyByteBufSizer sizer = new NettyByteBufSizer();
        Channel channel = serverBootstraps.get(name).bind(address).syncUninterruptibly().channel();  
            addClosedExceptionLogger(ch);
import io.netty.bootstrap.ServerBootstrap;
    private final ByteSizeValue receivePredictorMin;  
    }
        serverBootstrap.channel(NettyAllocator.getServerChannelType());
import org.opensearch.common.util.net.NetUtils;
            } else {  
                (int) receivePredictorMax.getBytes()
                if (keepIdleOption != null) {  
            clientBootstrap = createClientBootstrap(sharedGroup);
        final boolean reuseAddress = TransportSettings.TCP_REUSE_ADDRESS.get(settings);  
        if (receivePredictorMax.getBytes() == receivePredictorMin.getBytes()) {
import io.netty.channel.RecvByteBufAllocator;
import org.apache.logging.log4j.message.ParameterizedMessage;
                final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();
import org.opensearch.transport.TcpTransport;
import static org.opensearch.common.settings.Setting.byteSizeSetting;  
        NamedWriteableRegistry namedWriteableRegistry,  
    );  
        @Override  
        Netty4TcpChannel nettyChannel = new Netty4TcpChannel(channel, false, "default", connectFuture);
import static org.opensearch.common.settings.Setting.intSetting;
            super.doStart();  
import io.netty.channel.ChannelInboundHandlerAdapter;
    }
 * batch) with high payload that will cause regular request. (like search or single index) to take  
import org.opensearch.ExceptionsHelper;  
            if (cause instanceof Error) {
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        }  
        serverBootstrap.option(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        if (tcpSendBufferSize.getBytes() > 0) {
                profileSettings.portOrRange,
import io.netty.channel.AdaptiveRecvByteBufAllocator;
            }  
            assert ch instanceof Netty4NioSocketChannel;  
        if (channel == null) {
    public static final Setting<ByteSizeValue> NETTY_RECEIVE_PREDICTOR_MAX = byteSizeSetting(  
}
        // NettyAllocator will return the channel type designed to work with the configured allocator
            ExceptionsHelper.maybeDieOnAnotherThread(cause);
        super(settings, version, threadPool, pageCacheRecycler, circuitBreakerService, namedWriteableRegistry, networkService, tracer);
    private final ByteSizeValue receivePredictorMax;
                profileSettings.publishHosts,  
    }
        assert Netty4NioSocketChannel.class.isAssignableFrom(NettyAllocator.getChannelType());
        Channel channel = connectFuture.channel();
 * The OpenSearch Contributors require contributions made to  
                }
            super.exceptionCaught(ctx, cause);
    protected class ServerChannelInitializer extends ChannelInitializer<Channel> {
                    createServerBootstrap(profileSettings, sharedGroup);
 * You may obtain a copy of the License at  
    }
 * software distributed under the License is distributed on an
import org.opensearch.common.network.NetworkService;
        Netty4TcpServerChannel esChannel = new Netty4TcpServerChannel(channel);
import io.netty.channel.socket.nio.NioChannelOption;  
    private void addClosedExceptionLogger(Channel channel) {
        String name = profileSettings.profileName;
            addClosedExceptionLogger(ch);
        } else {  
            ExceptionsHelper.maybeDieOnAnotherThread(cause);  
 * this file be licensed under the Apache-2.0 license or a
        if (TransportSettings.TCP_KEEP_ALIVE.get(settings)) {
            ch.attr(CHANNEL_KEY).set(nettyTcpChannel);
        bootstrap.option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());
            if (success == false) {  
            }
public class Netty4Transport extends TcpTransport {
        return new ClientChannelInitializer();
 */
        return bootstrap;  
import io.netty.channel.Channel;  
            // using a dot as a prefix means this cannot come from any settings parsed  
            }
        serverBootstrap.childOption(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);  
            ch.pipeline().addLast("logging", new OpenSearchLoggingHandler());
            }  
 * KIND, either express or implied.  See the License for the
    private volatile Bootstrap clientBootstrap;  
                    serverBootstrap.childOption(NioChannelOption.of(keepCountOption), profileSettings.tcpKeepCount);
                final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();
        Property.NodeScope
    public Netty4Transport(  
        "transport.netty.receive_predictor_max",
 *
            if (f.isSuccess() == false) {  
            serverBootstrap.childOption(ChannelOption.SO_RCVBUF, Math.toIntExact(profileSettings.receiveBufferSize.bytesAsInt()));
        }
        if (tcpReceiveBufferSize.getBytes() > 0) {  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        try {  
        return esChannel;  
import io.netty.channel.ChannelHandlerContext;  
    @Override  
            super.exceptionCaught(ctx, cause);  
        this.sharedGroupFactory = sharedGroupFactory;
import io.netty.bootstrap.Bootstrap;  
import io.netty.channel.FixedRecvByteBufAllocator;
        channel.attr(SERVER_CHANNEL_KEY).set(esChannel);
    protected ChannelHandler getClientChannelInitializer(DiscoveryNode node) {
import java.net.SocketOption;  
    }
 *
        @Override  
            Netty4TcpServerChannel serverChannel = ctx.channel().attr(SERVER_CHANNEL_KEY).get();  
            if (TransportSettings.TCP_KEEP_COUNT.get(settings) >= 0) {
        bootstrapWithHandler.handler(getClientChannelInitializer(node));  
        }
            logger.debug(  
        }  
 * under the License.  
            assert ch instanceof Netty4NioSocketChannel;
    }  
    }
    protected class ClientChannelInitializer extends ChannelInitializer<Channel> {
        PageCacheRecycler pageCacheRecycler,
            );
        serverBootstraps.put(name, serverBootstrap);  
/**
            serverAcceptedChannel(nettyTcpChannel);  
        serverBootstrap.option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());
            if (profileSettings.tcpKeepIdle >= 0) {  
import org.apache.logging.log4j.LogManager;  
    protected void stopInternal() {
        // See AdaptiveReceiveBufferSizePredictor#DEFAULT_XXX for default values in netty..., we can use higher ones for us, even fixed one
        }  
        bootstrap.option(ChannelOption.SO_REUSEADDR, reuseAddress);
        // NettyAllocator will return the channel type designed to work with the configuredAllocator
        Property.NodeScope
            ch.pipeline().addLast("dispatcher", new Netty4MessageChannelHandler(pageCacheRecycler, Netty4Transport.this));
                    bootstrap.option(NioChannelOption.of(keepIntervalOption), TransportSettings.TCP_KEEP_INTERVAL.get(settings));
        }
                }
            success = true;
        bootstrap.option(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    private final SharedGroupFactory sharedGroupFactory;
            ch.pipeline().addLast("byte_buf_sizer", sizer);  
import io.netty.channel.ChannelInitializer;
                    bootstrap.option(NioChannelOption.of(keepCountOption), TransportSettings.TCP_KEEP_COUNT.get(settings));
            sharedGroup = sharedGroupFactory.getTransportGroup();
        bootstrapWithHandler.remoteAddress(address);
    public static final Setting<Integer> NETTY_BOSS_COUNT = intSetting("transport.netty.boss_count", 1, 1, Property.NodeScope);
            this.name = name;
        Settings settings,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
                }
        final Bootstrap bootstrap = new Bootstrap();
import io.netty.util.AttributeKey;
            NetUtils.tryEnsureReasonableKeepAliveConfig(((Netty4NioSocketChannel) ch).javaChannel());  
/*  
                "using profile[{}], worker_count[{}], port[{}], bind_host[{}], publish_host[{}], receive_predictor[{}->{}]",
import org.opensearch.threadpool.ThreadPool;
        bootstrap.option(ChannelOption.SO_KEEPALIVE, TransportSettings.TCP_KEEP_ALIVE.get(settings));
        boolean success = false;
import org.opensearch.common.util.PageCacheRecycler;  
    @Override
        bootstrap.channel(NettyAllocator.getChannelType());  
package org.opensearch.transport.netty4;
    protected ChannelHandler getServerChannelInitializer(String name) {  
import org.opensearch.Version;
            }  
        }
import io.netty.channel.ChannelFuture;
    private void createServerBootstrap(ProfileSettings profileSettings, SharedGroupFactory.SharedGroup sharedGroup) {  
            }  
        bootstrap.option(ChannelOption.TCP_NODELAY, TransportSettings.TCP_NO_DELAY.get(settings));  
        }
                (int) receivePredictorMin.getBytes(),  
 */  
            // Note that Netty logs a warning if it can't set the option  
    );  
    private Bootstrap createClientBootstrap(SharedGroupFactory.SharedGroup sharedGroup) {  
    @ChannelHandler.Sharable  
        return nettyChannel;
 * There are 4 types of connections per node, low/med/high/ping. Low if for batch oriented APIs (like recovery or
            }
        protected void initChannel(Channel ch) throws Exception {
                final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();
                    serverBootstrap.childOption(NioChannelOption.of(keepIdleOption), profileSettings.tcpKeepIdle);  
import org.opensearch.common.settings.Settings;
import org.opensearch.transport.Netty4NioSocketChannel;  
                if (keepCountOption != null) {  
        Property.NodeScope  
 */
        protected final String name;
        final ByteSizeValue tcpReceiveBufferSize = TransportSettings.TCP_RECEIVE_BUFFER_SIZE.get(settings);
                if (keepCountOption != null) {  
        @Override
 * ownership. Elasticsearch licenses this file to you under  
                onServerException(serverChannel, (Exception) cause);
        Version version,
            if (profileSettings.tcpKeepInterval >= 0) {  
 * the Apache License, Version 2.0 (the "License"); you may
                receivePredictorMin,
 * compatible open source license.
        serverBootstrap.childOption(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());  
        Releasables.close(() -> {  
                    bootstrap.option(NioChannelOption.of(keepIdleOption), TransportSettings.TCP_KEEP_IDLE.get(settings));
    }
        serverBootstrap.group(sharedGroup.getLowLevelGroup());
            if (TransportSettings.TCP_KEEP_IDLE.get(settings) >= 0) {
        // Set the allocators for both the server channel and the child channels created
            bootstrap.option(ChannelOption.SO_RCVBUF, Math.toIntExact(tcpReceiveBufferSize.getBytes()));
    public static final Setting<ByteSizeValue> NETTY_RECEIVE_PREDICTOR_SIZE = Setting.byteSizeSetting(
import org.opensearch.cluster.node.DiscoveryNode;
            bootstrap.option(ChannelOption.SO_SNDBUF, Math.toIntExact(tcpSendBufferSize.getBytes()));
    protected Netty4TcpChannel initiateChannel(DiscoveryNode node) throws IOException {  
        @Override
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
import org.opensearch.transport.NettyAllocator;
        }  
        if (logger.isDebugEnabled()) {
            if (NetworkService.NETWORK_SERVER.get(settings)) {  
                if (keepIntervalOption != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.logging.log4j.Logger;
                final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();
import io.netty.channel.ChannelHandler;
        }, serverBootstraps::clear, () -> clientBootstrap = null);
/*
 * sending out ping requests to other nodes.
    private volatile SharedGroupFactory.SharedGroup sharedGroup;
    private final RecvByteBufAllocator recvByteBufAllocator;
                if (keepIdleOption != null) {
        InetSocketAddress address = node.getAddress().address();
            Netty4TcpChannel nettyTcpChannel = new Netty4TcpChannel(ch, true, name, ch.newSucceededFuture());
import org.opensearch.transport.NettyByteBufSizer;
    protected Netty4TcpServerChannel bind(String name, InetSocketAddress address) {
    }
 *  
        final ServerBootstrap serverBootstrap = new ServerBootstrap();  
    }
import org.opensearch.transport.SharedGroupFactory;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                name,
import org.opensearch.common.settings.Setting;  
                onServerException(serverChannel, new Exception(cause));
        channel.attr(CHANNEL_KEY).set(nettyChannel);
        }
                doStop();
                }
                final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();
            NetUtils.tryEnsureReasonableKeepAliveConfig(((Netty4NioSocketChannel) ch).javaChannel());
    public static final Setting<ByteSizeValue> NETTY_RECEIVE_PREDICTOR_MIN = byteSizeSetting(
/*
                    bindServer(profileSettings);  
            throw new IOException(connectFuture.cause());
                final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();
        return new ServerChannelInitializer(name);
        (s) -> Setting.parseInt(s, 1, "transport.netty.worker_count"),
                if (keepIntervalOption != null) {  
        serverBootstrap.childHandler(getServerChannelInitializer(name));
                }
    @Override
        if (profileSettings.sendBufferSize.getBytes() != -1) {  
        serverBootstrap.childOption(ChannelOption.TCP_NODELAY, profileSettings.tcpNoDelay);
 * SPDX-License-Identifier: Apache-2.0
        NettyAllocator.logAllocatorDescriptionIfNeeded();
            }  
        "transport.netty.worker_count",
        (s) -> Integer.toString(OpenSearchExecutors.allocatedProcessors(s)),  
        Bootstrap bootstrapWithHandler = clientBootstrap.clone();
            ExceptionsHelper.maybeDieOnAnotherThread(cause);
                receivePredictorMax
            ch.pipeline().addLast("dispatcher", new Netty4MessageChannelHandler(pageCacheRecycler, Netty4Transport.this));
 * this work for additional information regarding copyright
                }
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            }
import org.opensearch.common.SuppressForbidden;  
    @Override  
        SharedGroupFactory sharedGroupFactory,
            if (profileSettings.tcpKeepCount >= 0) {
 * longer. Med is for the typical search / single doc index. And High for things like cluster state. Ping is reserved for
import java.io.IOException;
            }  
        Tracer tracer  
 */  
            ch.pipeline().addLast("logging", new OpenSearchLoggingHandler());
                sharedGroupFactory.getTransportWorkerCount(),  
import java.util.Map;
        CircuitBreakerService circuitBreakerService,
            if (sharedGroup != null) {
        ThreadPool threadPool,  
 * license agreements. See the NOTICE file distributed with
                sharedGroup.shutdown();
        }  
        serverBootstrap.validate();
        final ByteSizeValue tcpSendBufferSize = TransportSettings.TCP_SEND_BUFFER_SIZE.get(settings);  
        NetworkService networkService,
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, profileSettings.tcpKeepAlive);  
                profileSettings.bindHosts,
    ) {
        "transport.netty.receive_predictor_min",
            // Note that Netty logs a warning if it can't set the option
            serverBootstrap.childOption(ChannelOption.SO_SNDBUF, Math.toIntExact(profileSettings.sendBufferSize.getBytes()));
            ExceptionsHelper.maybeDieOnAnotherThread(connectFuture.cause());  
            }
        ChannelFuture connectFuture = bootstrapWithHandler.connect();
import org.opensearch.transport.TransportSettings;
import java.net.InetSocketAddress;
        }
                }
        "transport.netty.receive_predictor_size",  
 * not use this file except in compliance with the License.
import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.common.lease.Releasables;
        new ByteSizeValue(64, ByteSizeUnit.KB),
        serverBootstrap.handler(new ServerChannelExceptionHandler());  
            recvByteBufAllocator = new FixedRecvByteBufAllocator((int) receivePredictorMax.getBytes());
        Netty4Utils.setAvailableProcessors(OpenSearchExecutors.NODE_PROCESSORS_SETTING.get(settings));  
            if (TransportSettings.TCP_KEEP_INTERVAL.get(settings) >= 0) {
        } finally {
        protected ServerChannelInitializer(String name) {
    public static final Setting<Integer> WORKER_COUNT = new Setting<>(
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
        bootstrap.group(sharedGroup.getLowLevelGroup());
    private final Map<String, ServerBootstrap> serverBootstraps = newConcurrentMap();
        channel.closeFuture().addListener(f -> {
    }
import org.opensearch.telemetry.tracing.Tracer;
    protected void doStart() {
    }  
        if (profileSettings.receiveBufferSize.getBytes() != -1) {
import org.opensearch.core.common.unit.ByteSizeValue;
        }  
