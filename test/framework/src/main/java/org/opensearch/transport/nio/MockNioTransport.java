                socketConfig,
        }
 * not use this file except in compliance with the License.
                profileSettings.tcpNoDelay,
import org.opensearch.nio.InboundChannelBuffer;  
import org.opensearch.nio.ChannelFactory;
            return previousValue == null;
import java.nio.ByteBuffer;  
            try (ReleasableBytesReference reference = new ReleasableBytesReference(CompositeBytesReference.of(references), releasable)) {
                allTypesWithConnection.add(type);  
 * You may obtain a copy of the License at  
 * compatible open source license.
        private volatile boolean stopped;  
        public void stop() {
                        acceptChannel(nioChannel);  
            return profile;  
        private MockTcpReadWriteHandler(MockSocketChannel channel, PageCacheRecycler recycler, TcpTransport transport) {  
                        "Slow execution on network thread [{} milliseconds]",  
        profileToChannelFactory.clear();
            if (success == false) {
        public void addCloseListener(ActionListener<Void> listener) {  
        Tracer tracer  
import java.util.Set;  
                e -> onServerException(nioServerChannel, e)
            }
        }
                2,
        CircuitBreakerService circuitBreakerService,
    }
        InetSocketAddress address = node.getAddress().address();  
                Math.toIntExact(profileSettings.sendBufferSize.getBytes()),
        }  
 * Modifications Copyright OpenSearch Contributors. See
            exception  
import org.opensearch.core.common.bytes.CompositeBytesReference;
 * Licensed to Elasticsearch under one or more contributor  
                    while ((acceptedChannel = accept(rawChannel)) != null) {
            final RequestHandlers requestHandlers = transport.getRequestHandlers();
            });  
        return builder.build();  
    protected volatile NioSelectorGroup nioGroup;
            Long previousValue = registry.put(Thread.currentThread(), threadPool.relativeTimeInNanos());  
        builder.setHandshakeTimeout(connectionProfile.getHandshakeTimeout());
        private static final TimeValue CHECK_INTERVAL = TimeValue.timeValueSeconds(2);  
    @Override
            }
            MockTcpReadWriteHandler readWriteHandler = new MockTcpReadWriteHandler(nioChannel, pageCacheRecycler, MockNioTransport.this);
                        try {
                    new ParameterizedMessage(
        boolean success = false;  
                    final String stackTrace = Arrays.stream(thread.getStackTrace()).map(Object::toString).collect(Collectors.joining("\n"));
        ThreadPool threadPool,
 * SPDX-License-Identifier: Apache-2.0
            getContext().closeChannel();
        try {
        super(settings, version, threadPool, pageCacheRecycler, circuitBreakerService, namedWriteableRegistry, networkService, tracer);
import org.opensearch.nio.ServerChannelContext;  
 * software distributed under the License is distributed on an
            nioGroup.close();  
        @Override  
            super(  
        private final boolean isClient;
        NamedWriteableRegistry namedWriteableRegistry,
 * Unless required by applicable law or agreed to in writing,
        }  
 */
        }  
                allTypesWithoutConnection.add(type);
            return nioChannel;
            getContext().closeChannel();
import org.opensearch.core.indices.breaker.CircuitBreakerService;
public class MockNioTransport extends TcpTransport {
        public void addCloseListener(ActionListener<Void> listener) {  
import org.opensearch.common.bytes.ReleasableBytesReference;
        private final String profileName;  
                    if (channel.isConnected()) {
                } else {
        public void unregister() {
        PageCacheRecycler pageCacheRecycler,  
    protected MockServerChannel bind(String name, InetSocketAddress address) throws IOException {
import org.opensearch.common.util.io.IOUtils;
 * specific language governing permissions and limitations
        @Override  
import org.opensearch.nio.NioSelector;
        onException((TcpChannel) channel, exception);
        future.actionGet();  
        public void sendMessage(BytesReference reference, ActionListener<Void> listener) {  
        // less than 2s eventually.
        private final ThreadPool threadPool;  
            stopped = true;  
        Set<TransportRequestOptions.Type> allTypesWithConnection = new HashSet<>();
                        if (acceptCount % 100 == 0) {
                    return new Page(ByteBuffer.allocate(length), () -> {});
 * this work for additional information regarding copyright
                pipeline.handleBytes(channel, reference);  
        private final InboundPipeline pipeline;
        }
import java.io.IOException;
    protected static class MockSocketChannel extends NioSocketChannel implements TcpChannel {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.Version;
                            stackTrace
            super(channel);  
            ) {
        }  
            return stats;
        } catch (Exception e) {
import org.opensearch.action.support.PlainActionFuture;  
                    final Thread.State threadState = thread.getState();  
            );  
import org.opensearch.nio.Page;
        private final String profile;
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        }  
import java.nio.channels.SocketChannel;
    }
        private void logLongRunningExecutions() {
            addCloseListener(ActionListener.toBiConsumer(listener));
            this.pipeline = new InboundPipeline(
            return isServer;
            if (NetworkService.NETWORK_SERVER.get(settings)) {
            Long previousValue = registry.remove(Thread.currentThread());
            BytesChannelContext context = new BytesChannelContext(
    public MockNioTransport(
    private final TransportThreadWatchdog transportThreadWatchdog;  
        private final MockSocketChannel channel;  
import org.opensearch.nio.BytesWriteHandler;  
import org.opensearch.nio.BytesChannelContext;
            new ParameterizedMessage("exception caught on transport layer [thread={}]", Thread.currentThread().getName()),
            BytesReference[] references = new BytesReference[pages.length];  
/*
        // make sure we maintain at least the types that are supported by this profile even if we only use a single channel for them.  
            }  
        }
        @Override
            getContext().sendMessage(BytesReference.toByteBuffers(reference), ActionListener.toBiConsumer(listener));
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();  
                    new RuntimeException("Slow exception on network thread")  
                    bindServer(profileSettings);
        builder.setCompressionEnabled(connectionProfile.getCompressionEnabled());
    private static final Logger logger = LogManager.getLogger(MockNioTransport.class);  
                if (e == null) {  
import org.opensearch.core.common.breaker.CircuitBreaker;  
import java.util.HashSet;
        private final long warnThreshold;
            threadPool.schedule(this::logLongRunningExecutions, CHECK_INTERVAL, ThreadPool.Names.GENERIC);
            final Supplier<CircuitBreaker> breaker = transport.getInflightBreaker();  
                nioServerChannel,
                    if (blockedSinceInNanos.equals(registry.get(thread))) {
 * under the License.  
    protected volatile MockTcpChannelFactory clientChannelFactory;
            this.profile = profile;
                profileSettings.reuseAddress,  
 */  
                doStop();  
    }  
    protected void stopInternal() {  
import java.util.function.Supplier;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.nio.NioServerSocketChannel;  
    }
        }
            MockServerChannel nioServerChannel = new MockServerChannel(channel);  
        @Override  
            int numConnections = connectionProfile.getNumConnectionsPerType(type);
            this.channel = channel;
    private static class MockServerChannel extends NioServerSocketChannel implements TcpServerChannel {  
        serverChannel.addBindListener(ActionListener.toBiConsumer(future));
                references[i] = BytesReference.fromByteBuffer(pages[i].byteBuffer());
        @Override  
            );  
                        logger.warn(
                statsTracker,  
            clientChannelFactory = new MockTcpChannelFactory(true, clientProfileSettings, "client");  
            if (stopped == false) {  
        MockServerChannel serverChannel = nioGroup.bindServerChannel(address, channelFactory);  
        private final ConcurrentHashMap<Thread, Long> registry = new ConcurrentHashMap<>();
import java.nio.channels.ServerSocketChannel;
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.opensearch.nio.NioSocketChannel;
        public int consumeReads(InboundChannelBuffer channelBuffer) throws IOException {
                        }
                );
    private void acceptChannel(NioSocketChannel channel) {
            success = true;
import java.net.StandardSocketOptions;
/*  
                    }
                            "Potentially blocked execution on network thread [{}] [{}] [{} milliseconds]: \n{}",  
            nioChannel.addConnectListener((v, e) -> {
import org.opensearch.transport.StatsTracker;
package org.opensearch.transport.nio;
        public MockServerChannel createServerChannel(NioSelector selector, ServerSocketChannel channel, Config.ServerSocket socketConfig) {
            final Version version = transport.getVersion();
            for (Map.Entry<Thread, Long> entry : registry.entrySet()) {  
                    Recycler.V<byte[]> bytes = pageCacheRecycler.bytePage(false);  
    }
import org.opensearch.nio.NioSelectorGroup;
            super.doStart();  
    }
import java.io.UncheckedIOException;  
        }  
            transportThreadWatchdog.stop();
                profileSettings.tcpKeepInterval,
        private void maybeLogElapsedTime(long startTime) {
        Version version,  
        TransportThreadWatchdog(ThreadPool threadPool, Settings settings) {
                            channel.setOption(StandardSocketOptions.SO_LINGER, 0);  
        private MockTcpChannelFactory(boolean isClient, ProfileSettings profileSettings, String profileName) {
                }
            } else {
import java.util.stream.Collectors;  
        }  
import org.opensearch.core.action.ActionListener;
                threadPool.scheduleUnlessShuttingDown(CHECK_INTERVAL, ThreadPool.Names.GENERIC, this::logLongRunningExecutions);
                    MockTcpChannelFactory factory = new MockTcpChannelFactory(false, profileSettings, profileName);  
import java.util.concurrent.ConcurrentMap;
                }
        }
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;  
        }  
    }
    }
}  
                    int acceptCount = 0;
                    return new Page(ByteBuffer.wrap(bytes.v(), 0, length), bytes::close);
        }
            maybeLogElapsedTime(previousValue);
                profileSettings.tcpKeepAlive,
    }  
                requestHandlers::getHandler,
        @Override
            builder.addConnections(0, allTypesWithoutConnection.toArray(new TransportRequestOptions.Type[0]));  
        if (allTypesWithoutConnection.isEmpty() == false) {
import org.opensearch.transport.TcpServerChannel;
import java.util.Arrays;  
import java.util.function.IntFunction;
        PlainActionFuture<Void> future = PlainActionFuture.newFuture();
import org.opensearch.transport.InboundPipeline;
                daemonThreadFactory(this.settings, TcpTransport.TRANSPORT_WORKER_THREAD_NAME_PREFIX),  
            ProfileSettings clientProfileSettings = new ProfileSettings(settings, "default");
        @Override
    private static class MockTcpReadWriteHandler extends BytesWriteHandler {
                        TimeUnit.NANOSECONDS.toMillis(elapsedTime)
                breaker,  
        builder.setConnectTimeout(connectionProfile.getConnectTimeout());  
        @Override
                @Override  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            long elapsedTime = threadPool.relativeTimeInNanos() - startTime;
                    final Thread thread = entry.getKey();
/*  
    }
                            TimeUnit.NANOSECONDS.toMillis(elapsedTimeInNanos),  
                version,
        public ChannelStats getChannelStats() {
                transport::inboundMessage
                for (ProfileSettings profileSettings : profileSettings) {
                        NioSocketChannel nioChannel = MockTcpChannelFactory.this.acceptNioChannel(acceptedChannel, selectorSupplier);
 * this file be licensed under the Apache-2.0 license or a
            ServerChannelContext context = new ServerChannelContext(
 *  
import org.opensearch.common.recycler.Recycler;  
import org.opensearch.common.unit.TimeValue;
                if (length > PageCacheRecycler.BYTE_PAGE_SIZE) {  
            warnThreshold = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(settings).nanos() + TimeValue.timeValueMillis(100L).nanos();
        NetworkService networkService,
                final Long blockedSinceInNanos = entry.getValue();
        // We mostly care about long blocks and not random slowness anyway and in tests would randomly catch slow operations that block for
    protected ConnectionProfile maybeOverrideConnectionProfile(ConnectionProfile connectionProfile) {
        public String getProfile() {
    protected void doStart() {
        MockServerChannel(ServerSocketChannel channel) {
                e -> exceptionCaught(nioChannel, e),  
import org.opensearch.common.network.NetworkService;
        public void close() {
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.node.DiscoveryNode;
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
            for (int i = 0; i < pages.length; ++i) {
 * GitHub history for details.
            super(socketChannel);  
        public boolean isServerChannel() {
 *
        Set<TransportRequestOptions.Type> allTypesWithoutConnection = new HashSet<>();
            addConnectListener(ActionListener.toBiConsumer(listener));  
import org.opensearch.transport.TcpTransport;
import org.apache.logging.log4j.Logger;
            final StatsTracker statsTracker = transport.getStatsTracker();  
        return nioGroup.openChannel(address, clientChannelFactory);
    }
    }  
    private final ConcurrentMap<String, MockTcpChannelFactory> profileToChannelFactory = newConcurrentMap();
        for (TransportRequestOptions.Type type : TransportRequestOptions.Type.values()) {  
                            logger.warn("Accepted [{}] connections in a single select loop iteration on [{}]", acceptCount, channel);  
    static final class TransportThreadWatchdog {
                    ),
            };
        }
                nioChannel,  
        }
        private final boolean isServer;
                public void acceptChannels(Supplier<NioSelector> selectorSupplier) throws IOException {
import org.opensearch.telemetry.tracing.Tracer;
            throw new OpenSearchException(e);  
                            throw new UncheckedIOException(new IOException());
                selector,
                    String profileName = profileSettings.profileName;
                selector,
            Page[] pages = channelBuffer.sliceAndRetainPagesTo(channelBuffer.getIndex());
                            thread.getName(),
                        ++acceptCount;
                recycler,
            addCloseListener(ActionListener.toBiConsumer(listener));
import org.opensearch.common.util.PageCacheRecycler;  
 */  
        } catch (IOException e) {
            return connectionProfile;
                // loop through all profiles and start them up, special handling for default one  
        }
                    SocketChannel acceptedChannel;  
                            threadState,
        builder.addConnections(3, allTypesWithConnection.toArray(new TransportRequestOptions.Type[0]));
        // Only check every 2s to not flood the logs on a blocked thread.  
                        } catch (IOException ex) {
        }  
                if (elapsedTimeInNanos > warnThreshold) {  
            this.isServer = isServer;
        public boolean register() {
    }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.transport.ConnectionProfile;  
                        );
 *
        }
        }
import org.opensearch.core.common.bytes.BytesReference;
        @Override
            return nioServerChannel;  
        public void close() {  
            final ThreadPool threadPool = transport.getThreadPool();
            Releasable releasable = () -> IOUtils.closeWhileHandlingException(pages);
import org.apache.logging.log4j.message.ParameterizedMessage;  
                final long elapsedTimeInNanos = threadPool.relativeTimeInNanos() - blockedSinceInNanos;
 * license agreements. See the NOTICE file distributed with
                }  
                }
            nioServerChannel.setContext(context);
        }  
 * The OpenSearch Contributors require contributions made to  
    }
        }  
                profileSettings.tcpKeepIdle,  
        @Override
        public void addConnectListener(ActionListener<Void> listener) {
    @Override  
        @Override
    @Override
        }
 * KIND, either express or implied.  See the License for the
                Math.toIntExact(profileSettings.receiveBufferSize.getBytes())
        private MockSocketChannel(boolean isServer, String profile, SocketChannel socketChannel) {
            if (numConnections > 0) {
        this.transportThreadWatchdog = new TransportThreadWatchdog(threadPool, settings);  
        serverAcceptedChannel((TcpChannel) channel);  
    private void exceptionCaught(NioSocketChannel channel, Exception exception) {
import org.opensearch.transport.TcpChannel;  
        } finally {
        Settings settings,
            }
    @Override
        @Override
                new InboundChannelBuffer(pageSupplier)
            this.profileName = profileName;
                profileSettings.tcpKeepCount,
            this.isClient = isClient;
                return reference.length();
            );  
import java.net.InetSocketAddress;
        private final ChannelStats stats = new ChannelStats();  
            MockSocketChannel nioChannel = new MockSocketChannel(isClient == false, profileName, channel);
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.lease.Releasables;
import org.opensearch.OpenSearchException;
import java.util.concurrent.TimeUnit;  
import org.opensearch.transport.TransportRequestOptions;  
                socketConfig,
                threadPool::relativeTimeInMillis,
            nioChannel.setContext(context);
            };  
                logger.warn(
import java.util.concurrent.ConcurrentHashMap;
                MockNioTransport.this::acceptChannel,  
            }
        }
            super.close();
            this.threadPool = threadPool;  
        }
    private void onNonChannelException(Exception exception) {  
import java.util.Map;
        logger.warn(
        try {
            IntFunction<Page> pageSupplier = (length) -> {
                    }  
import org.opensearch.common.lease.Releasable;  
            logger.warn("unexpected exception while stopping nio group", e);
                this,  
            }  
                }  
        );
            }
                readWriteHandler,
            );  
        @Override
            Releasables.closeWhileHandlingException(pipeline);
import org.opensearch.nio.Config;
    protected MockSocketChannel initiateChannel(DiscoveryNode node) throws IOException {
        return serverChannel;
            assert previousValue != null;  
        if (connectionProfile.getNumConnections() <= 3) {  
    ) {
    private class MockTcpChannelFactory extends ChannelFactory<MockServerChannel, MockSocketChannel> {  
        public void close() {  
            nioGroup = new NioSelectorGroup(
            if (elapsedTime > warnThreshold) {  
        MockTcpChannelFactory channelFactory = this.profileToChannelFactory.get(name);
        }
        }  
                    profileToChannelFactory.putIfAbsent(profileName, factory);
        builder.setPingInterval(connectionProfile.getPingInterval());
                    }
    @Override
        public MockSocketChannel createChannel(NioSelector selector, SocketChannel channel, Config.Socket socketConfig) {  
                (s) -> new TestEventHandler(this::onNonChannelException, s, transportThreadWatchdog)
