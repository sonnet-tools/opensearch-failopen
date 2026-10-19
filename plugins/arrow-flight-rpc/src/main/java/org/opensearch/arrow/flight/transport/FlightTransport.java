                }
import java.util.concurrent.atomic.AtomicInteger;
                boundAddress,
        if (publishAddress == null) {
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        this.portRange = SETTING_FLIGHT_PORTS.get(settings);
                DEFAULT_PROFILE,  
            //
        int publishPort = Transport.resolveTransportPublishPort(
    }  
import java.util.function.Consumer;  
            for (ExecutorService executor : flightEventLoopGroup) {  
import io.netty.channel.nio.NioIoHandler;  
                try {
            );
                // Server-side gRPC keepalive (see ServerConfig.FLIGHT_KEEPALIVE_TIME). NOTE: only the
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;  
        int flightPort = publishAddress.address().getPort();
        }  
            // resizes of parquet.native.pool.flight.max take effect immediately via Arrow's
            } catch (Exception ce) {
    private final ThreadPool threadPool;
                    boundAddresses.add(socketAddress);  
        safeStop("boss event loop group", () -> gracefullyShutdownELG(bossEventLoopGroup, "os-grpc-boss-ELG"));  
        TransportAddress publishAddress = new TransportAddress(new InetSocketAddress(publishInetAddress, publishPort));
import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_BIND_HOST;
                statsCollector,
        for (int i = 0; i < eventLoopCount; i++) {
                getResponseHandlers(),
import org.opensearch.core.action.ActionListener;  
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.transport.TcpServerChannel;
import org.opensearch.threadpool.ThreadPool;  
            version,
        // skip the remaining teardown — most importantly the event-loop-group shutdowns, whose  
import org.apache.arrow.flight.Location;
    @Override  
        safeStop("flight event loops", () -> {
                    .middleware(SERVER_HEADER_KEY, factory);  
 * The OpenSearch Contributors require contributions made to  
    private final FlightTransportConfig config = new FlightTransportConfig();  
                builder.location(locations.get(0));
        // threads would otherwise leak.
    }
 *
    private final ExecutorService[] flightEventLoopGroup;
    }
        } catch (Exception e) {
    @Override
        RequestHandlers requestHandlers,
import org.opensearch.transport.InboundHandler;
                        : Location.forGrpcInsecure(NetworkAddress.format(hostAddress), portNumber);
            ? Location.forGrpcTls(address, flightPort)
                }  
        ResponseHandlers responseHandlers,
            .intercept(factory)
    public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Transport.Connection> listener) {
import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_PUBLISH_PORT;
                threadPool,
    public void setSlowLogThreshold(TimeValue slowLogThreshold) {
import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_PORTS;  
import org.opensearch.transport.ConnectTransportException;
import java.util.ArrayList;
                    .workerEventLoopGroup(workerEventLoopGroup)  
    private final SslContextProvider sslContextProvider;
            }
    @Override
import org.apache.arrow.flight.OSFlightServer;
        } catch (IOException e) {  
import org.opensearch.cluster.node.DiscoveryNode;  
        String address = publishAddress.getAddress();
        return new FlightInboundHandler(
        FlightStatsCollector statsCollector,
                });
            }  
                for (int i = 1; i < locations.size(); i++) {
        boolean success = false;
                    .executor(serverExecutor)
                } catch (InterruptedException e) {  
        InetAddress publishInetAddress;
    private EventLoopGroup createEventLoopGroup(String name, int threads) {
        List<InetSocketAddress> boundAddresses = bindToPort(hostAddresses);
        }
            .eventLoopGroup(workerEventLoopGroup)
        }
            if (statsCollector != null) {  
            listener.onResponse(nodeChannels);
        this.serverExecutor = threadPool.executor(ServerConfig.GRPC_EXECUTOR_THREAD_POOL_NAME);
                // server pings today; adding a client keepalive also requires  
        AtomicInteger threadCounter = new AtomicInteger(0);
    protected TcpChannel initiateChannel(DiscoveryNode node) throws IOException {  
        this.boundAddress = new BoundTransportAddress(transportAddresses.toArray(new TransportAddress[0]), publishAddress);  
                    }
            tracer  
                FlightServer server = builder.build();  
            serverAllocator = flightPool.newChildAllocator("server", 0, Long.MAX_VALUE);
    private volatile FlightServer flightServer;
import org.opensearch.common.util.PageCacheRecycler;
        return boundAddress;  
                }  
            listener.onFailure(new ConnectTransportException(node, "Failed to open Flight connection", e));  
import org.apache.arrow.flight.OSFlightClient;  
                return true;
        String[] features,
    public ExecutorService getNextFlightExecutor() {
        TransportHandshaker handshaker,
                logger.info("Arrow Flight server started. Listening at {}", locations);  
        try {
        }  
        List<TransportAddress> transportAddresses = boundAddresses.stream().map(TransportAddress::new).collect(Collectors.toList());
            ensureOpen();  
    /** Returns the next executor from the pool using round-robin assignment. */
                e.addSuppressed(ce);  
import org.opensearch.transport.TransportHandshaker;
            );
import org.opensearch.common.CheckedRunnable;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    private FlightProducer flightProducer;  
            .sslContext(sslContextProvider != null ? sslContextProvider.getClientSslContext() : null)
    final FlightServerMiddleware.Key<ServerHeaderMiddleware> SERVER_HEADER_KEY = FlightServerMiddleware.Key.of(
            if (statsCollector != null) {
        try {
        super(settings, version, threadPool, pageCacheRecycler, circuitBreakerService, namedWriteableRegistry, networkService, tracer);
import org.opensearch.common.network.NetworkService;  
                location,
    }
                return false;
    @Override
        } catch (IOException e) {
                statsCollector,
            flightEventLoopGroup[i] = Executors.newSingleThreadExecutor(r -> new Thread(r, "flight-eventloop-" + finalI));
    protected InboundHandler createInboundHandler(
 */  
            try {  
            .channelType(ServerConfig.clientChannelType())  
            );
    private BufferAllocator serverAllocator;  
        }  
            TcpChannel channel = initiateChannel(node);
    private final EventLoopGroup workerEventLoopGroup;
import org.apache.arrow.memory.BufferAllocator;
    protected TcpServerChannel bind(String name, InetSocketAddress address) {
                lastException.set(e);  
                    Thread.currentThread().interrupt();
            features,
import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_PUBLISH_HOST;
                    + transportAddresses
            // Use the unified native allocator's flight pool directly as the parent for  
    @Override  
                // permitKeepAliveTime/permitKeepAliveWithoutCalls here, else the server GOAWAYs the
import org.apache.arrow.flight.FlightServerMiddleware;
            int finalI = i;  
        final List<InetSocketAddress> boundAddresses = new ArrayList<>();
                final long keepAliveTimeoutMs = ServerConfig.getGrpcKeepAliveTimeout().millis();
                ServerConfig.FLIGHT_READY_TIMEOUT.get(settings).millis()  
                SERVER_HEADER_KEY,
        return new ArrayList<>(boundAddresses);  
import org.opensearch.transport.TcpChannel;
        TransportAddress publishAddress = node.getStreamAddress();
        );
        this.threadPool = threadPool;  
import org.apache.logging.log4j.Logger;
                client,
            // same-root invariant for cross-plugin Arrow handoff.
    }
                    + publishInetAddress  
    @Override  
        safeStop("client allocator", () -> clientAllocator.close());
import org.opensearch.core.common.transport.BoundTransportAddress;
            clientAllocator = flightPool.newChildAllocator("client", 0, Long.MAX_VALUE);
            // plugin is missing — silently falling back to a separate root would break the  
 * this file be licensed under the Apache-2.0 license or a
        ArrowNativeAllocator nativeAllocator
        return new MultiThreadIoEventLoopGroup(threads, threadFactory, NioIoHandler.newFactory());
        Location location = sslContextProvider != null  
import org.opensearch.telemetry.tracing.Tracer;
            }  
        StatsTracker statsTracker,  
            } catch (Exception e) {
    private volatile BoundTransportAddress boundAddress;  
        this.workerEventLoopGroup = createEventLoopGroup("os-grpc-worker-ELG", Runtime.getRuntime().availableProcessors());  
        int eventLoopCount = ServerConfig.getEventLoopThreads();  
        safeStop("server allocator", () -> serverAllocator.close());
        try {
            transportAddresses,
    }
            throw new ConnectTransportException(node, "node does not publish a stream (Flight) address");
            .build();  
        } finally {
        InetAddress[] hostAddresses;  
                        executor.shutdownNow();
                this,
            .executor(clientExecutor)  
import org.opensearch.arrow.flight.bootstrap.ServerConfig;
        PageCacheRecycler pageCacheRecycler,
    private static final String DEFAULT_PROFILE = "stream_profile";
import org.opensearch.transport.Transport;
        } catch (Exception e) {
                    if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {  
                flightPool,  
                statsCollector.incrementServerChannelsActive();
package org.opensearch.arrow.flight.transport;
}
                    locations.add(location);
            action.run();
            List<TcpChannel> channels = Collections.singletonList(channel);
                flightServer.close();  
                    + " with distinct ports and none matched the publish address ("
            success = true;  
        config.setSlowLogThreshold(slowLogThreshold);  
        try {  
            nodeName,  
            throw e;
        boolean success = portRange.iterate(portNumber -> {
    ) {
    }
import org.opensearch.arrow.flight.stats.FlightStatsCollector;
        final List<Location> locations = new ArrayList<>();  
    private static final Logger logger = LogManager.getLogger(FlightTransport.class);  
                flightServer.awaitTermination();
import org.opensearch.core.common.transport.TransportAddress;  
            responseHandlers,
        TransportKeepAlive keepAlive,  
        Tracer tracer  
        if (group != null) {
    }
        this.publishHosts = SETTING_FLIGHT_PUBLISH_HOST.get(settings).toArray(new String[0]);
        BigArrays bigArrays,
                ServerHeaderMiddleware.Factory factory = new ServerHeaderMiddleware.Factory();
import org.apache.arrow.flight.FlightClient;
import org.opensearch.transport.StatsTracker;  
            throw new BindTransportException("Failed to bind to " + Arrays.toString(hostAddresses) + ":" + portRange, lastException.get());  
                    executor.shutdownNow();
    public BoundTransportAddress boundAddress() {
        }
            // Server/client are children of the pool with Long.MAX_VALUE limits so dynamic  
                    .allocator(serverAllocator)
            namedWriteableRegistry,
        );  
                executor.shutdown();
import org.opensearch.transport.ConnectionProfile;  
    private final AtomicInteger nextExecutorIndex = new AtomicInteger(0);  
import io.grpc.netty.NettyServerBuilder;  
        });
                builder.transportHint("grpc.builderConsumer", (Consumer<NettyServerBuilder>) b -> {
        return flightEventLoopGroup[nextExecutorIndex.getAndIncrement() % flightEventLoopGroup.length];  
    private void bindServer() {
        this.statsCollector = statsCollector;  
        }
        this.sslContextProvider = sslContextProvider;
            return new FlightClientChannel(  
                OSFlightServer.Builder builder = OSFlightServer.builder()  
                context,
    }
                    b.keepAliveTimeout(keepAliveTimeoutMs, TimeUnit.MILLISECONDS);
                doStop();  
            SETTING_FLIGHT_PUBLISH_PORT.get(settings),  
import java.util.Collections;
            throw new BindTransportException("Failed to resolve publish address", e);
                    .producer(flightProducer)
                statsCollector.setBufferAllocator(flightPool);
    }  
        String nodeName,  
import org.apache.arrow.flight.FlightProducer;
    );
            safeStop("server channel stats", () -> statsCollector.decrementServerChannelsActive());
    @Override  
import org.opensearch.common.network.NetworkAddress;
    private final EventLoopGroup bossEventLoopGroup;
                for (InetAddress hostAddress : hostAddresses) {
    @Override
    private final NamedWriteableRegistry namedWriteableRegistry;  
 * compatible open source license.
            hostAddresses = networkService.resolveBindHostAddresses(bindHosts);
import org.opensearch.transport.BindTransportException;
    private final PortsRange portRange;  
        HeaderContext context = new HeaderContext();
    private final ArrowNativeAllocator nativeAllocator;
        Tracer tracer,
    private final FlightStatsCollector statsCollector;
            flightProducer = new ArrowFlightProducer(
import org.opensearch.transport.TransportKeepAlive;  
                "Failed to auto-resolve flight publish port, multiple bound addresses "  
    protected void stopInternal() {
                final long keepAliveTimeMs = ServerConfig.getGrpcKeepAliveTime().millis();  
                client.close();
            handshaker,
            // framework alongside ingest, query, and datafusion. Hard-fail if the framework
        try {
import java.util.concurrent.atomic.AtomicReference;
        });  
        }
                    InetSocketAddress socketAddress = new InetSocketAddress(hostAddress, portNumber);
@SuppressWarnings("removal")
            if (!success) {
        CircuitBreakerService circuitBreakerService,
import java.io.IOException;
        if (publishPort < 0) {
import org.opensearch.common.util.BigArrays;
                    Location location = sslContextProvider != null
        // Fail cleanly instead of NPEing on the address below.  
    }
            : Location.forGrpcInsecure(address, flightPort);
        this.clientExecutor = threadPool.executor(ServerConfig.FLIGHT_CLIENT_THREAD_POOL_NAME);
            // server/client child allocators. Allocations are tracked and capped by the
            statsTracker,  
        }
        ThreadPool threadPool,
import org.opensearch.common.settings.Settings;
        }
            throw new BindTransportException(
        NetworkService networkService,
                namedWriteableRegistry,
            keepAlive,  
        "flight-server-header-middleware"  
import org.opensearch.common.transport.PortsRange;
                    + ")."
        });  
    }
import java.util.concurrent.Executors;
    private final ExecutorService clientExecutor;
        FlightClient client = OSFlightClient.builder()  
        safeStop("worker event loop group", () -> gracefullyShutdownELG(workerEventLoopGroup, "os-grpc-worker-ELG"));
import org.opensearch.common.unit.TimeValue;  
        if (!success) {
                    .sslContext(sslContextProvider != null ? sslContextProvider.getServerSslContext() : null)  
        ThreadFactory threadFactory = r -> new Thread(r, name + "-" + threadCounter.incrementAndGet());  
        try {
                    .bossEventLoopGroup(bossEventLoopGroup)
            NodeChannels nodeChannels = new NodeChannels(node, channels, profile, getVersion());  
/*  
        return null;
        NamedWriteableRegistry namedWriteableRegistry,
    private final ExecutorService serverExecutor;  
import org.opensearch.arrow.flight.bootstrap.tls.SslContextProvider;  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        this.nativeAllocator = nativeAllocator;
            // parent-cap check at allocateBytes — no listener needed.
import org.opensearch.transport.TcpTransport;  
                flightServer = null;
        NamedWriteableRegistry namedWriteableRegistry,  
        super.setSlowLogThreshold(slowLogThreshold);
                statsCollector.setThreadPool(threadPool);
            publishInetAddress = networkService.resolvePublishHostAddresses(publishHosts);  
        this.namedWriteableRegistry = namedWriteableRegistry;
                this.flightServer = server;
            bindServer();
        Settings settings,
                locations.clear();
                this.inboundHandler.getMessageListener(),  
        this.bindHosts = SETTING_FLIGHT_BIND_HOST.get(settings).toArray(new String[0]);  
    public FlightTransport(  
class FlightTransport extends TcpTransport {
import org.opensearch.transport.OutboundHandler;
import java.util.stream.Collectors;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * SPDX-License-Identifier: Apache-2.0
        final AtomicReference<Exception> lastException = new AtomicReference<>();
import org.apache.arrow.flight.FlightServer;  
            throw new BindTransportException("Failed to resolve host [" + Arrays.toString(bindHosts) + "]", e);
        Version version,
        if (statsCollector != null) {  
                boundAddresses.clear();
        // A node that predates the stream transport, or has it disabled, publishes no stream address.
        ClientHeaderMiddleware.Factory factory = new ClientHeaderMiddleware.Factory(context, getVersion());
            }
    private final String[] publishHosts;
    private void gracefullyShutdownELG(EventLoopGroup group, String name) {
import io.netty.channel.EventLoopGroup;
        // Each step is isolated so a failure (e.g. an allocator reporting leaked buffers) cannot
        this.bossEventLoopGroup = createEventLoopGroup("os-grpc-boss-ELG", 1);
                        ? Location.forGrpcTls(NetworkAddress.format(hostAddress), portNumber)  
                    builder.addListenAddress(locations.get(i));  
import org.opensearch.Version;  
                flightServer.shutdown();
        }
            }
        SslContextProvider sslContextProvider,  
        Version version,
                config  
                // client with "too_many_pings".
                node,  
            }
            outboundHandler,  
import java.util.concurrent.ThreadFactory;
            publishInetAddress
    }  
import java.util.List;
            try {  
                server.start();
    protected void doStart() {  
        OutboundHandler outboundHandler,  
            bigArrays,
    }  
import java.net.InetAddress;  
        this.flightEventLoopGroup = new ExecutorService[eventLoopCount];
            }
                    .channelType(ServerConfig.serverChannelType())
        ThreadPool threadPool,  
            .grpcIntercept(new BufferReleasingClientInterceptor())
        safeStop("flight server", () -> {
                    .backpressureThreshold((int) ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(settings).getBytes())
            BufferAllocator flightPool = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT);  
    private List<InetSocketAddress> bindToPort(InetAddress[] hostAddresses) {  
            .allocator(clientAllocator)
import io.netty.channel.MultiThreadIoEventLoopGroup;
    private final String[] bindHosts;
            requestHandlers,
import java.util.Arrays;  
            group.shutdownGracefully(0, 5, TimeUnit.SECONDS).awaitUninterruptibly();  
    private BufferAllocator clientAllocator;
    private void safeStop(String what, CheckedRunnable<Exception> action) {
                    b.keepAliveTime(keepAliveTimeMs, TimeUnit.MILLISECONDS);  
            .location(location)
import org.apache.logging.log4j.LogManager;  
import java.util.concurrent.TimeUnit;  
            threadPool,
    ) {  
    }
        } catch (Exception e) {
            logger.error(() -> new ParameterizedMessage("Error stopping FlightTransport: failed to stop {}", what), e);  
        }  
            if (flightServer != null) {  
