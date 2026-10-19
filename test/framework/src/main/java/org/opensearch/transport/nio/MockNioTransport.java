            getContext().closeChannel();
        public void stop() {
                e -> exceptionCaught(nioChannel, e),
            );
import org.opensearch.transport.TcpChannel;
            long elapsedTime = threadPool.relativeTimeInNanos() - startTime;
            nioChannel.setContext(context);
            );
        private volatile boolean stopped;
            final StatsTracker statsTracker = transport.getStatsTracker();
import org.opensearch.nio.NioServerSocketChannel;
            return connectionProfile;
 */
        return serverChannel;
                profileSettings.tcpKeepInterval,
        public MockSocketChannel createChannel(NioSelector selector, SocketChannel channel, Config.Socket socketConfig) {
import org.opensearch.common.bytes.ReleasableBytesReference;
                        } catch (IOException ex) {
            super(channel);
                    ),
            getContext().sendMessage(BytesReference.toByteBuffers(reference), ActionListener.toBiConsumer(listener));
 * license agreements. See the NOTICE file distributed with
        }
    }
import org.apache.logging.log4j.Logger;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                        if (acceptCount % 100 == 0) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.nio.Config;
            new ParameterizedMessage("exception caught on transport layer [thread={}]", Thread.currentThread().getName()),
        private final boolean isServer;
        public boolean register() {
    }
    private final TransportThreadWatchdog transportThreadWatchdog;
                }
}
                    profileToChannelFactory.putIfAbsent(profileName, factory);
    }
                profileSettings.tcpNoDelay,
import java.net.StandardSocketOptions;
            return nioChannel;
        @Override
    @Override
            transportThreadWatchdog.stop();
import org.apache.logging.log4j.message.ParameterizedMessage;
            return stats;
            this.isServer = isServer;
    }
    protected static class MockSocketChannel extends NioSocketChannel implements TcpChannel {
        }
        onException((TcpChannel) channel, exception);
import org.opensearch.common.lease.Releasable;
        @Override
import org.opensearch.core.common.bytes.CompositeBytesReference;
        super(settings, version, threadPool, pageCacheRecycler, circuitBreakerService, namedWriteableRegistry, networkService, tracer);
            logger.warn("unexpected exception while stopping nio group", e);
                if (elapsedTimeInNanos > warnThreshold) {
            if (elapsedTime > warnThreshold) {
    @Override
                daemonThreadFactory(this.settings, TcpTransport.TRANSPORT_WORKER_THREAD_NAME_PREFIX),
            Long previousValue = registry.put(Thread.currentThread(), threadPool.relativeTimeInNanos());
            final Supplier<CircuitBreaker> breaker = transport.getInflightBreaker();
import org.opensearch.nio.NioSelectorGroup;
            nioGroup.close();
                            stackTrace
        Set<TransportRequestOptions.Type> allTypesWithoutConnection = new HashSet<>();
            this.profile = profile;
            nioChannel.addConnectListener((v, e) -> {
            }
 * SPDX-License-Identifier: Apache-2.0
            }
        }
        }
            } else {
                        "Slow execution on network thread [{} milliseconds]",
                    bindServer(profileSettings);
                    if (channel.isConnected()) {
            super.doStart();
import org.opensearch.transport.ConnectionProfile;
            }
                final long elapsedTimeInNanos = threadPool.relativeTimeInNanos() - blockedSinceInNanos;
    private void exceptionCaught(NioSocketChannel channel, Exception exception) {
        }
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.nio.BytesWriteHandler;
import java.util.concurrent.ConcurrentMap;
 * You may obtain a copy of the License at
        public void unregister() {
        // Only check every 2s to not flood the logs on a blocked thread.
        private final long warnThreshold;
        }
            };
import org.opensearch.threadpool.ThreadPool;
                final Long blockedSinceInNanos = entry.getValue();
    }
    }
import org.opensearch.nio.ChannelFactory;
 * under the License.
                allTypesWithConnection.add(type);
    private final ConcurrentMap<String, MockTcpChannelFactory> profileToChannelFactory = newConcurrentMap();
        public MockServerChannel createServerChannel(NioSelector selector, ServerSocketChannel channel, Config.ServerSocket socketConfig) {
import org.opensearch.cluster.node.DiscoveryNode;
                }
 * Unless required by applicable law or agreed to in writing,
                allTypesWithoutConnection.add(type);
    @Override
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.action.ActionListener;
        public void addCloseListener(ActionListener<Void> listener) {
            final Version version = transport.getVersion();
import java.util.stream.Collectors;
        }
        }
            addCloseListener(ActionListener.toBiConsumer(listener));
/*
import org.opensearch.nio.NioSocketChannel;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.OpenSearchException;
        @Override
import org.opensearch.transport.TransportRequestOptions;
                    }
        }
        public int consumeReads(InboundChannelBuffer channelBuffer) throws IOException {
            Long previousValue = registry.remove(Thread.currentThread());
        profileToChannelFactory.clear();
        public void addCloseListener(ActionListener<Void> listener) {
                        logger.warn(
                }
    }
 * specific language governing permissions and limitations
        private final InboundPipeline pipeline;
        future.actionGet();
 *
        serverChannel.addBindListener(ActionListener.toBiConsumer(future));
                readWriteHandler,
/*
            final ThreadPool threadPool = transport.getThreadPool();
            super(socketChannel);
                }
        @Override
import org.opensearch.nio.ServerChannelContext;
                pipeline.handleBytes(channel, reference);
    }
                nioServerChannel,
                    return new Page(ByteBuffer.allocate(length), () -> {});
        logger.warn(
            try (ReleasableBytesReference reference = new ReleasableBytesReference(CompositeBytesReference.of(references), releasable)) {
        }
        // We mostly care about long blocks and not random slowness anyway and in tests would randomly catch slow operations that block for
                Math.toIntExact(profileSettings.receiveBufferSize.getBytes())
        }
 * software distributed under the License is distributed on an
public class MockNioTransport extends TcpTransport {
        } finally {
                profileSettings.reuseAddress,
        private void maybeLogElapsedTime(long startTime) {
                        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                for (ProfileSettings profileSettings : profileSettings) {
        @Override
import java.nio.channels.SocketChannel;
        for (TransportRequestOptions.Type type : TransportRequestOptions.Type.values()) {
        }
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
        private final String profile;
        public void close() {
        NetworkService networkService,
                nioChannel,
            assert previousValue != null;
            for (Map.Entry<Thread, Long> entry : registry.entrySet()) {
import org.opensearch.transport.InboundPipeline;
    private void onNonChannelException(Exception exception) {
import java.util.HashSet;
            if (stopped == false) {
import org.opensearch.nio.InboundChannelBuffer;
        }
    private static final Logger logger = LogManager.getLogger(MockNioTransport.class);
                            throw new UncheckedIOException(new IOException());
                e -> onServerException(nioServerChannel, e)
        @Override
                breaker,
import java.net.InetSocketAddress;
import org.opensearch.nio.BytesChannelContext;
    }
                version,
        private MockSocketChannel(boolean isServer, String profile, SocketChannel socketChannel) {
    private void acceptChannel(NioSocketChannel channel) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        builder.addConnections(3, allTypesWithConnection.toArray(new TransportRequestOptions.Type[0]));
            return nioServerChannel;
        public ChannelStats getChannelStats() {
        }
        Tracer tracer
                if (length > PageCacheRecycler.BYTE_PAGE_SIZE) {
        }
 * Modifications Copyright OpenSearch Contributors. See
                            logger.warn("Accepted [{}] connections in a single select loop iteration on [{}]", acceptCount, channel);
        Settings settings,
                MockNioTransport.this::acceptChannel,
                requestHandlers::getHandler,
    }
        }
            }
                        TimeUnit.NANOSECONDS.toMillis(elapsedTime)
package org.opensearch.transport.nio;
                logger.warn(
        if (allTypesWithoutConnection.isEmpty() == false) {
import org.apache.logging.log4j.LogManager;
        private final boolean isClient;
        public void addConnectListener(ActionListener<Void> listener) {
    protected void stopInternal() {
        public void sendMessage(BytesReference reference, ActionListener<Void> listener) {
        }
            this.pipeline = new InboundPipeline(
    ) {
    public MockNioTransport(
                    String profileName = profileSettings.profileName;
 * Licensed to Elasticsearch under one or more contributor
                            "Potentially blocked execution on network thread [{}] [{}] [{} milliseconds]: \n{}",
            ) {
import org.opensearch.common.util.PageCacheRecycler;
    protected void doStart() {
        ThreadPool threadPool,
            clientChannelFactory = new MockTcpChannelFactory(true, clientProfileSettings, "client");
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
        // make sure we maintain at least the types that are supported by this profile even if we only use a single channel for them.
        return nioGroup.openChannel(address, clientChannelFactory);
                        );
        private final ThreadPool threadPool;
import org.opensearch.core.common.breaker.CircuitBreaker;
                recycler,
        boolean success = false;
            }
                    Recycler.V<byte[]> bytes = pageCacheRecycler.bytePage(false);
import org.opensearch.common.settings.Settings;
    }
                selector,
                selector,
        PlainActionFuture<Void> future = PlainActionFuture.newFuture();
                        NioSocketChannel nioChannel = MockTcpChannelFactory.this.acceptNioChannel(acceptedChannel, selectorSupplier);
            super(
            nioServerChannel.setContext(context);
                new InboundChannelBuffer(pageSupplier)
            Releasable releasable = () -> IOUtils.closeWhileHandlingException(pages);
import java.util.function.Supplier;
            success = true;
                (s) -> new TestEventHandler(this::onNonChannelException, s, transportThreadWatchdog)
            }
        @Override
        }
                    final Thread.State threadState = thread.getState();
import org.opensearch.telemetry.tracing.Tracer;
        MockTcpChannelFactory channelFactory = this.profileToChannelFactory.get(name);
        }
                Math.toIntExact(profileSettings.sendBufferSize.getBytes()),
                statsTracker,
                } else {
        @Override
import java.util.concurrent.TimeUnit;
                    return new Page(ByteBuffer.wrap(bytes.v(), 0, length), bytes::close);
        private static final TimeValue CHECK_INTERVAL = TimeValue.timeValueSeconds(2);
                socketConfig,
        builder.setHandshakeTimeout(connectionProfile.getHandshakeTimeout());
import java.util.Arrays;
                return reference.length();
        CircuitBreakerService circuitBreakerService,
                threadPool::relativeTimeInMillis,
                    final Thread thread = entry.getKey();
import org.opensearch.Version;
        @Override
    protected MockServerChannel bind(String name, InetSocketAddress address) throws IOException {
            BytesReference[] references = new BytesReference[pages.length];
            addCloseListener(ActionListener.toBiConsumer(listener));
        }
            this.threadPool = threadPool;
            return isServer;
                    new ParameterizedMessage(
        private MockTcpReadWriteHandler(MockSocketChannel channel, PageCacheRecycler recycler, TcpTransport transport) {
                        try {
                        }
        InetSocketAddress address = node.getAddress().address();
            final RequestHandlers requestHandlers = transport.getRequestHandlers();
            for (int i = 0; i < pages.length; ++i) {
        public boolean isServerChannel() {
    }
        builder.setConnectTimeout(connectionProfile.getConnectTimeout());
            MockSocketChannel nioChannel = new MockSocketChannel(isClient == false, profileName, channel);
    @Override
                2,
            stopped = true;
        public void close() {
                transport::inboundMessage
        private final String profileName;
            warnThreshold = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(settings).nanos() + TimeValue.timeValueMillis(100L).nanos();
import java.util.Map;
import org.opensearch.action.support.PlainActionFuture;
            this.isClient = isClient;
        public String getProfile() {
        @Override
        public void close() {
        private MockTcpChannelFactory(boolean isClient, ProfileSettings profileSettings, String profileName) {
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
            this.profileName = profileName;
 *
        @Override
    }
        } catch (IOException e) {
                    SocketChannel acceptedChannel;
                references[i] = BytesReference.fromByteBuffer(pages[i].byteBuffer());
    protected volatile NioSelectorGroup nioGroup;
        }
                public void acceptChannels(Supplier<NioSelector> selectorSupplier) throws IOException {
        }
        @Override
            getContext().closeChannel();
            int numConnections = connectionProfile.getNumConnectionsPerType(type);
            });
            super.close();
            if (success == false) {
                threadPool.scheduleUnlessShuttingDown(CHECK_INTERVAL, ThreadPool.Names.GENERIC, this::logLongRunningExecutions);
    protected MockSocketChannel initiateChannel(DiscoveryNode node) throws IOException {
 */
 * compatible open source license.
            throw new OpenSearchException(e);
import org.opensearch.transport.TcpTransport;
            addConnectListener(ActionListener.toBiConsumer(listener));
        this.transportThreadWatchdog = new TransportThreadWatchdog(threadPool, settings);
            }
import org.opensearch.common.util.io.IOUtils;
                            TimeUnit.NANOSECONDS.toMillis(elapsedTimeInNanos),
        }
 *
                    }
        NamedWriteableRegistry namedWriteableRegistry,
            MockServerChannel nioServerChannel = new MockServerChannel(channel);
            Page[] pages = channelBuffer.sliceAndRetainPagesTo(channelBuffer.getIndex());
                    while ((acceptedChannel = accept(rawChannel)) != null) {
            nioGroup = new NioSelectorGroup(
            if (numConnections > 0) {
        builder.setPingInterval(connectionProfile.getPingInterval());
        return builder.build();
                this,
                if (e == null) {
/*
                @Override
import org.opensearch.common.recycler.Recycler;
    @Override
            builder.addConnections(0, allTypesWithoutConnection.toArray(new TransportRequestOptions.Type[0]));
            Releasables.closeWhileHandlingException(pipeline);
            if (NetworkService.NETWORK_SERVER.get(settings)) {
                );
        Version version,
        } catch (Exception e) {
                    }
        builder.setCompressionEnabled(connectionProfile.getCompressionEnabled());
            };
    static final class TransportThreadWatchdog {
                        ++acceptCount;
    protected ConnectionProfile maybeOverrideConnectionProfile(ConnectionProfile connectionProfile) {
                            thread.getName(),
                        acceptChannel(nioChannel);
                socketConfig,
 * GitHub history for details.
import org.opensearch.common.network.NetworkService;
import org.opensearch.transport.TcpServerChannel;
import java.util.concurrent.ConcurrentHashMap;
        Set<TransportRequestOptions.Type> allTypesWithConnection = new HashSet<>();
                            threadState,
                doStop();
            maybeLogElapsedTime(previousValue);
        private void logLongRunningExecutions() {
        @Override
            return profile;
 */
            }
            );
        private final ConcurrentHashMap<Thread, Long> registry = new ConcurrentHashMap<>();
        // less than 2s eventually.
import org.opensearch.nio.NioSelector;
        try {
        }
            threadPool.schedule(this::logLongRunningExecutions, CHECK_INTERVAL, ThreadPool.Names.GENERIC);
        private final MockSocketChannel channel;
                    int acceptCount = 0;
                profileSettings.tcpKeepIdle,
import java.nio.channels.ServerSocketChannel;
        serverAcceptedChannel((TcpChannel) channel);
        TransportThreadWatchdog(ThreadPool threadPool, Settings settings) {
    }
        MockServerChannel(ServerSocketChannel channel) {
import org.opensearch.nio.Page;
        MockServerChannel serverChannel = nioGroup.bindServerChannel(address, channelFactory);
import java.util.Set;
            MockTcpReadWriteHandler readWriteHandler = new MockTcpReadWriteHandler(nioChannel, pageCacheRecycler, MockNioTransport.this);
        );
            );
        }
        }
                profileSettings.tcpKeepAlive,
    protected volatile MockTcpChannelFactory clientChannelFactory;
            BytesChannelContext context = new BytesChannelContext(
import java.io.IOException;
 * this work for additional information regarding copyright
        private final ChannelStats stats = new ChannelStats();
import java.io.UncheckedIOException;
import org.opensearch.transport.StatsTracker;
            this.channel = channel;
import org.opensearch.common.lease.Releasables;
        if (connectionProfile.getNumConnections() <= 3) {
                    final String stackTrace = Arrays.stream(thread.getStackTrace()).map(Object::toString).collect(Collectors.joining("\n"));
 * this file be licensed under the Apache-2.0 license or a
    private class MockTcpChannelFactory extends ChannelFactory<MockServerChannel, MockSocketChannel> {
                profileSettings.tcpKeepCount,
            return previousValue == null;
 * not use this file except in compliance with the License.
            exception
import java.util.function.IntFunction;
import java.nio.ByteBuffer;
            ProfileSettings clientProfileSettings = new ProfileSettings(settings, "default");
                // loop through all profiles and start them up, special handling for default one
                    new RuntimeException("Slow exception on network thread")
                }
    private static class MockServerChannel extends NioServerSocketChannel implements TcpServerChannel {
            IntFunction<Page> pageSupplier = (length) -> {
        }
 * the Apache License, Version 2.0 (the "License"); you may
                            channel.setOption(StandardSocketOptions.SO_LINGER, 0);
import org.opensearch.core.common.bytes.BytesReference;
            ServerChannelContext context = new ServerChannelContext(
    private static class MockTcpReadWriteHandler extends BytesWriteHandler {
        PageCacheRecycler pageCacheRecycler,
        try {
                    MockTcpChannelFactory factory = new MockTcpChannelFactory(false, profileSettings, profileName);
                    if (blockedSinceInNanos.equals(registry.get(thread))) {
