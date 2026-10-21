            }
                config
        if (publishAddress == null) {
                SERVER_HEADER_KEY,
                flightServer.close();
        CircuitBreakerService circuitBreakerService,
        // Fail cleanly instead of NPEing on the address below.
                    Location location = sslContextProvider != null
import org.apache.arrow.flight.FlightServerMiddleware;
import org.apache.arrow.flight.FlightServer;
import org.opensearch.cluster.node.DiscoveryNode;
        String[] features,
        this.portRange = SETTING_FLIGHT_PORTS.get(settings);
            .build();
    }
    @Override
    }
        String nodeName,
        InetAddress[] hostAddresses;
                flightServer = null;
                // permitKeepAliveTime/permitKeepAliveWithoutCalls here, else the server GOAWAYs the
        });
        }
 * this file be licensed under the Apache-2.0 license or a
            }
    private void gracefullyShutdownELG(EventLoopGroup group, String name) {
                    .workerEventLoopGroup(workerEventLoopGroup)
            // Server/client are children of the pool with Long.MAX_VALUE limits so dynamic
import org.opensearch.core.action.ActionListener;
 */
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import java.util.function.Consumer;
class FlightTransport extends TcpTransport {
        if (!success) {
                }
        Location location = sslContextProvider != null
    private final AtomicInteger nextExecutorIndex = new AtomicInteger(0);
import io.netty.channel.EventLoopGroup;
        } catch (IOException e) {
        } catch (Exception e) {
            transportAddresses,
            throw new BindTransportException("Failed to resolve publish address", e);
    private FlightProducer flightProducer;
    private BufferAllocator clientAllocator;
    @Override
                this.inboundHandler.getMessageListener(),
        try {
        boolean success = portRange.iterate(portNumber -> {
        this.clientExecutor = threadPool.executor(ServerConfig.FLIGHT_CLIENT_THREAD_POOL_NAME);
        return flightEventLoopGroup[nextExecutorIndex.getAndIncrement() % flightEventLoopGroup.length];
        FlightClient client = OSFlightClient.builder()
        // threads would otherwise leak.
    private final ExecutorService serverExecutor;
        for (int i = 0; i < eventLoopCount; i++) {
        List<InetSocketAddress> boundAddresses = bindToPort(hostAddresses);
    private static final String DEFAULT_PROFILE = "stream_profile";
        return new FlightInboundHandler(
    private void bindServer() {
import org.opensearch.common.transport.PortsRange;
            } catch (Exception e) {
    ) {
    public ExecutorService getNextFlightExecutor() {
        boolean success = false;
            namedWriteableRegistry,
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
                return false;
                server.start();
        }
        }
 * compatible open source license.
                for (int i = 1; i < locations.size(); i++) {
        } catch (Exception e) {
import org.opensearch.transport.InboundHandler;
                context,
                flightPool,
                threadPool,
import java.util.concurrent.ExecutorService;
import org.opensearch.transport.TcpServerChannel;
    public FlightTransport(
            // same-root invariant for cross-plugin Arrow handoff.
                // Server-side gRPC keepalive (see ServerConfig.FLIGHT_KEEPALIVE_TIME). NOTE: only the
                return true;
            handshaker,
        this.statsCollector = statsCollector;
    private List<InetSocketAddress> bindToPort(InetAddress[] hostAddresses) {
            : Location.forGrpcInsecure(address, flightPort);
        this.nativeAllocator = nativeAllocator;
    public BoundTransportAddress boundAddress() {
        Settings settings,
                    if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
    }
    protected void doStart() {
    protected TcpServerChannel bind(String name, InetSocketAddress address) {
                ServerHeaderMiddleware.Factory factory = new ServerHeaderMiddleware.Factory();
            if (flightServer != null) {
    protected void stopInternal() {
        int flightPort = publishAddress.address().getPort();
    final FlightServerMiddleware.Key<ServerHeaderMiddleware> SERVER_HEADER_KEY = FlightServerMiddleware.Key.of(
            serverAllocator = flightPool.newChildAllocator("server", 0, Long.MAX_VALUE);
            hostAddresses = networkService.resolveBindHostAddresses(bindHosts);
        TransportKeepAlive keepAlive,
    private BufferAllocator serverAllocator;
                flightServer.awaitTermination();
    public void setSlowLogThreshold(TimeValue slowLogThreshold) {
            // server/client child allocators. Allocations are tracked and capped by the
import org.opensearch.common.network.NetworkAddress;
import org.opensearch.arrow.flight.bootstrap.ServerConfig;
    public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Transport.Connection> listener) {
        if (group != null) {
package org.opensearch.arrow.flight.transport;
    @Override
    private final FlightStatsCollector statsCollector;
            if (statsCollector != null) {
                    boundAddresses.add(socketAddress);
            logger.error(() -> new ParameterizedMessage("Error stopping FlightTransport: failed to stop {}", what), e);
        this.bindHosts = SETTING_FLIGHT_BIND_HOST.get(settings).toArray(new String[0]);
        }
import org.opensearch.transport.TransportKeepAlive;
        }
import org.opensearch.common.util.PageCacheRecycler;
    }
        FlightStatsCollector statsCollector,
    private EventLoopGroup createEventLoopGroup(String name, int threads) {
                    .backpressureThreshold((int) ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(settings).getBytes())
            }
            } catch (Exception ce) {
        this.boundAddress = new BoundTransportAddress(transportAddresses.toArray(new TransportAddress[0]), publishAddress);
        int eventLoopCount = ServerConfig.getEventLoopThreads();
            }
import org.opensearch.transport.StatsTracker;
        return null;
        this.publishHosts = SETTING_FLIGHT_PUBLISH_HOST.get(settings).toArray(new String[0]);
            }
        try {
        try {
        Version version,
        // A node that predates the stream transport, or has it disabled, publishes no stream address.
                    executor.shutdownNow();
            listener.onResponse(nodeChannels);
        config.setSlowLogThreshold(slowLogThreshold);
    }
            features,
                this.flightServer = server;
        safeStop("flight server", () -> {
                namedWriteableRegistry,
                    + " with distinct ports and none matched the publish address ("
            // framework alongside ingest, query, and datafusion. Hard-fail if the framework
        super.setSlowLogThreshold(slowLogThreshold);
        Version version,
        BigArrays bigArrays,
            .allocator(clientAllocator)
        NamedWriteableRegistry namedWriteableRegistry,
                OSFlightServer.Builder builder = OSFlightServer.builder()
                location,
            }
        safeStop("boss event loop group", () -> gracefullyShutdownELG(bossEventLoopGroup, "os-grpc-boss-ELG"));
 *
    protected TcpChannel initiateChannel(DiscoveryNode node) throws IOException {
    private volatile FlightServer flightServer;
            keepAlive,
            try {
        HeaderContext context = new HeaderContext();
            if (!success) {
                doStop();
        ThreadPool threadPool,
                builder.location(locations.get(0));
import java.util.concurrent.Executors;
                for (InetAddress hostAddress : hostAddresses) {
        NetworkService networkService,
        this.serverExecutor = threadPool.executor(ServerConfig.GRPC_EXECUTOR_THREAD_POOL_NAME);
            ensureOpen();
            statsTracker,
        safeStop("flight event loops", () -> {
                statsCollector,
        RequestHandlers requestHandlers,
import org.opensearch.core.common.transport.BoundTransportAddress;
        this.workerEventLoopGroup = createEventLoopGroup("os-grpc-worker-ELG", Runtime.getRuntime().availableProcessors());
import org.apache.logging.log4j.Logger;
            threadPool,
import io.grpc.netty.NettyServerBuilder;
    private void safeStop(String what, CheckedRunnable<Exception> action) {
import java.util.stream.Collectors;
import org.opensearch.telemetry.tracing.Tracer;
            );
import org.opensearch.transport.OutboundHandler;
            bigArrays,
    }
            throw new BindTransportException("Failed to resolve host [" + Arrays.toString(bindHosts) + "]", e);
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.transport.TransportHandshaker;
                // server pings today; adding a client keepalive also requires
    private volatile BoundTransportAddress boundAddress;
                DEFAULT_PROFILE,
            requestHandlers,
            // parent-cap check at allocateBytes — no listener needed.
import java.util.Collections;
import org.opensearch.transport.Transport;
            listener.onFailure(new ConnectTransportException(node, "Failed to open Flight connection", e));
        TransportHandshaker handshaker,
            // Use the unified native allocator's flight pool directly as the parent for
                    Thread.currentThread().interrupt();
        }
        ClientHeaderMiddleware.Factory factory = new ClientHeaderMiddleware.Factory(context, getVersion());
    );
            );
                e.addSuppressed(ce);
                boundAddress,
                    }
import org.apache.arrow.flight.FlightClient;
        this.bossEventLoopGroup = createEventLoopGroup("os-grpc-boss-ELG", 1);
        return new ArrayList<>(boundAddresses);
    }
import java.io.IOException;
                        executor.shutdownNow();
    }
        "flight-server-header-middleware"
    }
import org.opensearch.transport.TcpChannel;
                node,
                    .bossEventLoopGroup(bossEventLoopGroup)
    @Override
            //
    private final String[] bindHosts;
import org.opensearch.transport.TcpTransport;
        String address = publishAddress.getAddress();
            SETTING_FLIGHT_PUBLISH_PORT.get(settings),
        Tracer tracer
            throw new BindTransportException(
            // resizes of parquet.native.pool.flight.max take effect immediately via Arrow's
                // client with "too_many_pings".
                } catch (InterruptedException e) {
                builder.transportHint("grpc.builderConsumer", (Consumer<NettyServerBuilder>) b -> {
            flightProducer = new ArrowFlightProducer(
    private final ExecutorService clientExecutor;
            clientAllocator = flightPool.newChildAllocator("client", 0, Long.MAX_VALUE);
}
import org.opensearch.common.CheckedRunnable;
import org.opensearch.arrow.flight.stats.FlightStatsCollector;
            throw new ConnectTransportException(node, "node does not publish a stream (Flight) address");
            );
            nodeName,
import org.apache.arrow.flight.FlightProducer;
                statsCollector.incrementServerChannelsActive();
    private final ThreadPool threadPool;
            BufferAllocator flightPool = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT);
        );
            try {
    @Override
            throw new BindTransportException("Failed to bind to " + Arrays.toString(hostAddresses) + ":" + portRange, lastException.get());
        final AtomicReference<Exception> lastException = new AtomicReference<>();
        TransportAddress publishAddress = node.getStreamAddress();
                    + ")."
        NamedWriteableRegistry namedWriteableRegistry,
                executor.shutdown();
    private final SslContextProvider sslContextProvider;
import java.util.concurrent.ThreadFactory;
                lastException.set(e);
            .channelType(ServerConfig.clientChannelType())
import java.util.List;
import java.util.concurrent.TimeUnit;
        });
                }
import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_PUBLISH_PORT;
            NodeChannels nodeChannels = new NodeChannels(node, channels, profile, getVersion());
                ServerConfig.FLIGHT_READY_TIMEOUT.get(settings).millis()
                    locations.add(location);
        });
                FlightServer server = builder.build();
    private final ExecutorService[] flightEventLoopGroup;
    private final NamedWriteableRegistry namedWriteableRegistry;
                    b.keepAliveTime(keepAliveTimeMs, TimeUnit.MILLISECONDS);
                    InetSocketAddress socketAddress = new InetSocketAddress(hostAddress, portNumber);
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
            .eventLoopGroup(workerEventLoopGroup)
                getResponseHandlers(),
                    + publishInetAddress
                    builder.addListenAddress(locations.get(i));
                final long keepAliveTimeMs = ServerConfig.getGrpcKeepAliveTime().millis();
        this.flightEventLoopGroup = new ExecutorService[eventLoopCount];
        if (publishPort < 0) {
        AtomicInteger threadCounter = new AtomicInteger(0);
        } finally {
import org.opensearch.common.network.NetworkService;
            .grpcIntercept(new BufferReleasingClientInterceptor())
import org.opensearch.common.settings.Settings;
import io.netty.channel.MultiThreadIoEventLoopGroup;
        // Each step is isolated so a failure (e.g. an allocator reporting leaked buffers) cannot
        safeStop("worker event loop group", () -> gracefullyShutdownELG(workerEventLoopGroup, "os-grpc-worker-ELG"));
    /** Returns the next executor from the pool using round-robin assignment. */
            throw e;
import org.apache.logging.log4j.LogManager;
import org.opensearch.arrow.flight.bootstrap.tls.SslContextProvider;
                    .middleware(SERVER_HEADER_KEY, factory);
import org.opensearch.threadpool.ThreadPool;
            .sslContext(sslContextProvider != null ? sslContextProvider.getClientSslContext() : null)
        ThreadFactory threadFactory = r -> new Thread(r, name + "-" + threadCounter.incrementAndGet());
            outboundHandler,
            .location(location)
                flightServer.shutdown();
        } catch (IOException e) {
import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_BIND_HOST;
                    .executor(serverExecutor)
                client.close();
        List<TransportAddress> transportAddresses = boundAddresses.stream().map(TransportAddress::new).collect(Collectors.toList());
    }
import java.util.Arrays;
            flightEventLoopGroup[i] = Executors.newSingleThreadExecutor(r -> new Thread(r, "flight-eventloop-" + finalI));
            .intercept(factory)
    private final PortsRange portRange;
            success = true;
import org.opensearch.Version;
        int publishPort = Transport.resolveTransportPublishPort(
@SuppressWarnings("removal")
        InetAddress publishInetAddress;
                try {
import org.opensearch.transport.BindTransportException;
import org.opensearch.common.unit.TimeValue;
            publishInetAddress
            publishInetAddress = networkService.resolvePublishHostAddresses(publishHosts);
                final long keepAliveTimeoutMs = ServerConfig.getGrpcKeepAliveTimeout().millis();
        safeStop("server allocator", () -> serverAllocator.close());
        StatsTracker statsTracker,
        final List<InetSocketAddress> boundAddresses = new ArrayList<>();
            safeStop("server channel stats", () -> statsCollector.decrementServerChannelsActive());
            tracer
        ThreadPool threadPool,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        Tracer tracer,
        PageCacheRecycler pageCacheRecycler,
        this.threadPool = threadPool;
                    .producer(flightProducer)
    protected InboundHandler createInboundHandler(
    private static final Logger logger = LogManager.getLogger(FlightTransport.class);
    private final ArrowNativeAllocator nativeAllocator;
import org.apache.arrow.memory.BufferAllocator;
    @Override
        this.sslContextProvider = sslContextProvider;
        } catch (Exception e) {
                locations.clear();
    private final EventLoopGroup bossEventLoopGroup;
            }
import java.net.InetSocketAddress;
        super(settings, version, threadPool, pageCacheRecycler, circuitBreakerService, namedWriteableRegistry, networkService, tracer);
    private final FlightTransportConfig config = new FlightTransportConfig();
    }
                statsCollector.setThreadPool(threadPool);
                statsCollector.setBufferAllocator(flightPool);
/*
import io.netty.channel.nio.NioIoHandler;
import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_PORTS;
import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_PUBLISH_HOST;
            bindServer();
            int finalI = i;
                        : Location.forGrpcInsecure(NetworkAddress.format(hostAddress), portNumber);
        if (statsCollector != null) {
                }
    }
import org.apache.arrow.flight.Location;
            group.shutdownGracefully(0, 5, TimeUnit.SECONDS).awaitUninterruptibly();
            // plugin is missing — silently falling back to a separate root would break the
    }
                boundAddresses.clear();
            .executor(clientExecutor)
        }
            ? Location.forGrpcTls(address, flightPort)
                client,
        );
import org.opensearch.transport.ConnectTransportException;
import org.apache.arrow.flight.OSFlightServer;
    }
        final List<Location> locations = new ArrayList<>();
                this,
            for (ExecutorService executor : flightEventLoopGroup) {
        return new MultiThreadIoEventLoopGroup(threads, threadFactory, NioIoHandler.newFactory());
        try {
                    b.keepAliveTimeout(keepAliveTimeoutMs, TimeUnit.MILLISECONDS);
import org.apache.arrow.flight.OSFlightClient;
import java.net.InetAddress;
        try {
                    .sslContext(sslContextProvider != null ? sslContextProvider.getServerSslContext() : null)
import org.opensearch.transport.ConnectionProfile;
import java.util.ArrayList;
                    .allocator(serverAllocator)
    private final EventLoopGroup workerEventLoopGroup;
        this.namedWriteableRegistry = namedWriteableRegistry;
import org.apache.logging.log4j.message.ParameterizedMessage;
        TransportAddress publishAddress = new TransportAddress(new InetSocketAddress(publishInetAddress, publishPort));
                    .channelType(ServerConfig.serverChannelType())
        safeStop("client allocator", () -> clientAllocator.close());
            responseHandlers,
                logger.info("Arrow Flight server started. Listening at {}", locations);
        // skip the remaining teardown — most importantly the event-loop-group shutdowns, whose
        ArrowNativeAllocator nativeAllocator
        }
    @Override
        try {
import org.opensearch.core.common.transport.TransportAddress;
                "Failed to auto-resolve flight publish port, multiple bound addresses "
            action.run();
    ) {
                    + transportAddresses
        ResponseHandlers responseHandlers,
        }
        return boundAddress;
    @Override
import java.util.concurrent.atomic.AtomicReference;
            if (statsCollector != null) {
            return new FlightClientChannel(
        SslContextProvider sslContextProvider,
        OutboundHandler outboundHandler,
    private final String[] publishHosts;
                });
            TcpChannel channel = initiateChannel(node);
            List<TcpChannel> channels = Collections.singletonList(channel);
        }
                        ? Location.forGrpcTls(NetworkAddress.format(hostAddress), portNumber)
import org.opensearch.common.util.BigArrays;
            version,
        }
        }
    }
                statsCollector,
