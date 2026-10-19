import org.opensearch.core.common.transport.TransportAddress;
     */
    private void bindServer() {
        Setting.Property.NodeScope
     * Port settings are set using the transport type, in this case GRPC_TRANSPORT_SETTING_KEY.
     * Creates a new Netty4GrpcServerTransport instance.
    private static final Logger logger = LogManager.getLogger(Netty4GrpcServerTransport.class);
    @Override
    /**
                }
        this.bindHosts = (grpcBindHost.isEmpty() ? NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING.get(settings) : grpcBindHost).toArray(
        this.portSettingKey = SETTING_GRPC_PORT.getKey();
        AtomicReference<Exception> lastException = new AtomicReference<>();
        (s) -> Integer.toString(OpenSearchExecutors.allocatedProcessors(s) * 2),
                    .bossEventLoopGroup(bossEventLoopGroup)
     * Initializes the event loop group and binds the server to the configured addresses.
            bossEventLoopGroup.close();
        1,
        }
        "grpc.publish_host",
        });
        boolean success = false;
                logger.warn("Failed to shut down worker event loop group");
    );
    protected void doClose() {
import java.util.function.UnaryOperator;
        return addr.get();
        new TimeValue(Long.MAX_VALUE),
     * Timeout for keepalive ping requests of an established connection.
        if (!success) {
        Setting.Property.NodeScope
    private final TimeValue maxConnectionIdle;
    );
        new TimeValue(0),
                Thread.currentThread().interrupt();
        new ByteSizeValue(0, ByteSizeUnit.MB),
        this.maxConnectionAge = SETTING_GRPC_MAX_CONNECTION_AGE.get(settings);
import java.net.InetAddress;
            }
        }
     * Returns the bound transport addresses for this gRPC server.
                logger.debug("Bound gRPC to address {{}}", address);
     * Settings.
    /**
                return false;
        final List<String> grpcPublishHost = SETTING_GRPC_PUBLISH_HOST.get(settings);
            throw new RuntimeException("Failed to bind to " + hostAddress + " on ports " + portRange, lastException.get());
        100,
     * Configure size of thread pool backing this transport server.
     * Connections lasting longer than configured age will be gracefully terminated.
import io.grpc.BindableService;
            this.grpcExecutor = threadPool.executor(GRPC_THREAD_POOL_NAME);
     * Performs any necessary cleanup after stopping the transport.
                    + " or "
        Setting.Property.NodeScope
            try {
        TransportAddress publishAddress = new TransportAddress(new InetSocketAddress(publishInetAddress, publishPort));
import static org.opensearch.transport.Transport.resolveTransportPublishPort;
        serverBuilderConfigs.add(configModifier);
    }
                    .maxConnectionIdle(maxConnectionIdle.duration(), maxConnectionIdle.timeUnit())
                    + "Please specify a unique port by setting "
    protected void addServerConfig(UnaryOperator<NettyServerBuilder> configModifier) {
    );
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    /**
    }
        this.boundAddress = new BoundTransportAddress(boundAddresses.toArray(new TransportAddress[0]), publishAddress);
        }
        return bossEventLoopGroup;
        Integer.MAX_VALUE,
     * No max idle time by default.
        }
        (s) -> Setting.parseInt(s, 1, "grpc.netty.worker_count"),
    }
    private final int nettyEventLoopThreads;
    /**
 * compatible open source license.
     */
                final NettyServerBuilder serverBuilder = NettyServerBuilder.forAddress(address)
                    .keepAliveTimeout(keepAliveTimeout.duration(), keepAliveTimeout.timeUnit())
        if (workerEventLoopGroup != null) {
import java.util.concurrent.CopyOnWriteArrayList;
        InetAddress[] hostAddresses;
     */
import static org.opensearch.transport.grpc.GrpcPlugin.GRPC_THREAD_POOL_NAME;
        }
import org.opensearch.common.unit.TimeValue;
        SETTING_GRPC_HOST,
import org.opensearch.core.common.Strings;
            try {
                    Thread.currentThread().interrupt();
    );
     */
            throw new BindTransportException("Failed to resolve publish address", e);
        Function.identity(),
            } catch (InterruptedException e) {
     * Child classes have distinct transport type keys and need to override these settings.
        Settings settings,
import org.opensearch.common.network.NetworkService;
    protected PortsRange port;
        "grpc.netty.executor_count",
import java.util.concurrent.TimeUnit;
import java.net.InetSocketAddress;
     */
 * Services injected through BindableService list.
     * @param networkService the bind/publish addresses.
        try {
    /**
        GRPC_TRANSPORT_SETTING_KEY
     */
                    .intercept(serverInterceptor);
        try {
                try {
     * Note this setting is configured through AffixSetting AUX_TRANSPORT_PORT where the aux transport type matches the GRPC_TRANSPORT_SETTING_KEY.
     */
        Setting.Property.NodeScope
     * This method is public for testing purposes.
        this.serverInterceptor = Objects.requireNonNull(serverInterceptor);
        this(settings, services, networkService, threadPool, new GrpcInterceptorChain(threadPool.getThreadContext()));
    EventLoopGroup getBossEventLoopGroupForTesting() {
}
        "grpc.netty.worker_count",
    @Override
    public static final Setting<TimeValue> SETTING_GRPC_MAX_CONNECTION_AGE = Setting.timeSetting(
    }
        (s) -> Setting.parseInt(s, 1, "grpc.netty.executor_count"),
            }
import io.grpc.ServerInterceptor;
                lastException.set(e);
import org.opensearch.transport.BindTransportException;
                servers.add(srv);
            // Create separate boss and worker event loop groups for better isolation
            } catch (InterruptedException e) {
        AtomicReference<TransportAddress> addr = new AtomicReference<>();
            throw new BindTransportException(
     */
        }
                    .maxConnectionAge(maxConnectionAge.duration(), maxConnectionAge.timeUnit())
        this.maxConcurrentConnectionCalls = SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS.get(settings);
        Setting.Property.NodeScope
 * SPDX-License-Identifier: Apache-2.0
    @Override
        return grpcExecutor;
     */
                doStop();
import static java.util.Collections.emptyList;
        Function.identity(),
        logger.info("{}", boundAddress);
    /**
                    .maxInboundMessageSize((int) maxInboundMessageSize)
        "grpc.netty.max_msg_size",
            publishInetAddress = networkService.resolvePublishHostAddresses(publishHosts);
    /**
                return true;
            try {
        new TimeValue(Long.MAX_VALUE),
                services.forEach(serverBuilder::addService);
    private volatile EventLoopGroup bossEventLoopGroup;
    public static final Setting<Integer> SETTING_GRPC_EXECUTOR_COUNT = new Setting<>(
    );
        if (bossEventLoopGroup != null) {
import org.opensearch.common.transport.PortsRange;
        ThreadPool threadPool,
        this.publishHosts = (grpcPublishHost.isEmpty() ? NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings) : grpcPublishHost)
        "grpc.netty.max_connection_idle",
        NetworkService networkService,
     * Host list to bind.
 * this file be licensed under the Apache-2.0 license or a
import io.grpc.netty.shaded.io.netty.channel.socket.nio.NioServerSocketChannel;
        emptyList(),
        final List<String> grpcBindHost = SETTING_GRPC_BIND_HOST.get(settings);
public class Netty4GrpcServerTransport extends AuxTransport {
        } finally {
                logger.warn("Failed to shut down boss event loop group");
import org.opensearch.core.common.transport.BoundTransportAddress;
                addr.set(new TransportAddress(hostAddress, portNumber));
    public static final Setting<Integer> SETTING_GRPC_PUBLISH_PORT = intSetting("grpc.publish_port", -1, -1, Setting.Property.NodeScope);
import java.io.IOException;
     * Host list to bind and publish.
import org.opensearch.transport.grpc.interceptor.GrpcInterceptorChain;
    EventLoopGroup getWorkerEventLoopGroupForTesting() {
            throw new BindTransportException("Failed to resolve host [" + Arrays.toString(bindHosts) + "]", e);
        Setting.Property.NodeScope
    public static final Setting<PortsRange> SETTING_GRPC_PORT = AUX_TRANSPORT_PORT.getConcreteSettingForNamespace(
    protected void doStop() {
    private final List<UnaryOperator<NettyServerBuilder>> serverBuilderConfigs = new ArrayList<>();
     * No max connection age by default.
        }
        NetworkService networkService,
     */
import org.opensearch.transport.AuxTransport;
 */
        this.maxInboundMessageSize = SETTING_GRPC_MAX_MSG_SIZE.get(settings).getBytes();
import io.grpc.Server;
    private final TimeValue keepAliveTimeout;
    /**
    );
                    .workerEventLoopGroup(workerEventLoopGroup)
    }
    }
            Strings.EMPTY_ARRAY
        // Shutdown event loop groups
     */
            }
     */
        "grpc.bind_host",
     * Inject a NettyServerBuilder configuration to be applied at server bind and start.
        }
     * Returns the setting key used to identify this transport type.
     */
                    op.apply(serverBuilder);
    /**
package org.opensearch.transport.grpc;
            // Use OpenSearch's managed thread pool for gRPC request processing
                    + " with distinct ports and none of them matched the publish address ("
            }
    private final String[] publishHosts;
                    .channelType(NioServerSocketChannel.class)
            if (server != null) {
                } finally {
     */
import java.util.ArrayList;
        Setting.Property.NodeScope
        final int publishPort = resolveTransportPublishPort(SETTING_GRPC_PUBLISH_PORT.get(settings), boundAddresses, publishInetAddress);
                    server.awaitTermination(30, TimeUnit.SECONDS);
    /**
        } catch (Exception e) {
        }
    @Override
    }
        Settings settings,
        for (InetAddress address : hostAddresses) {
     *
        ThreadPool threadPool
        Setting.Property.NodeScope
                    logger.warn("Interrupted while shutting down gRPC server");
        this.settings = Objects.requireNonNull(settings);
    private final long maxInboundMessageSize;
    /**
    /**
import io.grpc.protobuf.services.ProtoReflectionService;
        this.services = Objects.requireNonNull(services);
    public Netty4GrpcServerTransport(
            workerEventLoopGroup.close();
    public static final Setting<List<String>> SETTING_GRPC_PUBLISH_HOST = listSetting(
import java.util.concurrent.atomic.AtomicReference;
                    + portSettingKey
     * Type key for configuring settings of this auxiliary transport.
     * For distinct bind/publish hosts configure SETTING_GRPC_BIND_HOST + SETTING_GRPC_PUBLISH_HOST separately.
import io.grpc.netty.shaded.io.netty.channel.nio.NioEventLoopGroup;
    ) {
    private final CopyOnWriteArrayList<Server> servers = new CopyOnWriteArrayList<>();
import static org.opensearch.common.settings.Setting.intSetting;
                "Failed to auto-resolve grpc publish port, multiple bound addresses "
    }
        // Note: grpcExecutor is managed by OpenSearch's ThreadPool, so we don't shut it down here
     */
                    + boundAddresses
    protected void doStart() {
     */
     * @param serverInterceptor the gRPC server interceptor to be applied.
    public Netty4GrpcServerTransport(
     * Configure maximum inbound message size in bytes.
     */
     * Idle connections lasting longer than configured value will be gracefully terminated.
     * Shuts down all running servers and the event loop group.
     * Creates a new Netty4GrpcServerTransport instance.
                for (UnaryOperator<NettyServerBuilder> op : serverBuilderConfigs) {
        ServerInterceptor serverInterceptor
        boolean success = portRange.iterate(portNumber -> {
        }
    public static final Setting<ByteSizeValue> SETTING_GRPC_MAX_MSG_SIZE = Setting.byteSizeSetting(
    );
    private final List<BindableService> services;
        this.networkService = Objects.requireNonNull(networkService);
    /**
     * Port range on which servers bind.
 * Netty4 gRPC server implemented as a LifecycleComponent.
     * @param services the gRPC compatible services to be registered with the server.
import org.opensearch.core.common.unit.ByteSizeUnit;
        List<BindableService> services,
import org.apache.logging.log4j.LogManager;
import io.grpc.netty.shaded.io.netty.channel.EventLoopGroup;
    public static final Setting<List<String>> SETTING_GRPC_HOST = listSetting(
                server.shutdown();
    public static final Setting<TimeValue> SETTING_GRPC_KEEPALIVE_TIMEOUT = Setting.timeSetting(
    private volatile EventLoopGroup workerEventLoopGroup;
    // Package-private methods for testing
 *
        new TimeValue(0),
            boundAddresses.add(bindAddress(address, port));
import org.opensearch.common.settings.Setting;
    }
    /**
     * Port published to peers for this server.
    ) {
     */
        new TimeValue(0),
    );
    public BoundTransportAddress getBoundAddress() {
    public static final Setting<Integer> SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS = Setting.intSetting(
        logger.debug("Initializing Netty4GrpcServerTransport with settings = {}", settings);
     * @param settings the configured settings.
        this.threadPool = Objects.requireNonNull(threadPool);
    /**
    public static final Setting<Integer> SETTING_GRPC_WORKER_COUNT = new Setting<>(
                    + publishInetAddress
        new ByteSizeValue(Integer.MAX_VALUE, ByteSizeUnit.BYTES),
    private final TimeValue maxConnectionAge;
    /**
 * The OpenSearch Contributors require contributions made to
            } catch (Exception e) {
    private volatile BoundTransportAddress boundAddress;
            logger.info("Started gRPC server on port {} with {} executor threads", port, executorThreads);
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
                    server.shutdownNow();
    );
        if (bossEventLoopGroup != null) {
     */
     * Stops the gRPC server transport.
    public static final String GRPC_TRANSPORT_SETTING_KEY = "transport-grpc";
        Function.identity(),
import java.util.function.Function;
     * @param threadPool the thread pool for gRPC request processing.
            if (!success) {
            bindServer();
        "grpc.netty.max_connection_age",
     * Host list published to peers.
            }
        List<TransportAddress> boundAddresses = new ArrayList<>(hostAddresses.length);
    }
    private final String[] bindHosts;
     * Closes the gRPC server transport.
     */
            .toArray(Strings.EMPTY_ARRAY);
            success = true;
    }
    @Override
        this.nettyEventLoopThreads = SETTING_GRPC_WORKER_COUNT.get(settings);
                    + SETTING_GRPC_PUBLISH_PORT.getKey()
    );
                final InetSocketAddress address = new InetSocketAddress(hostAddress, portNumber);
import org.opensearch.core.common.unit.ByteSizeValue;
    protected final Settings settings;
        return GRPC_TRANSPORT_SETTING_KEY;
        return workerEventLoopGroup;
    public String settingKey() {
     * Controls the number of allowed simultaneous in flight requests a single client connection may send.
    public static final Setting<TimeValue> SETTING_GRPC_MAX_CONNECTION_IDLE = Setting.timeSetting(
import java.util.Objects;
     * @param threadPool the thread pool for gRPC request processing.
     * @param services the gRPC compatible services to be registered with the server.
        if (workerEventLoopGroup != null) {
     */
    private final ServerInterceptor serverInterceptor;
                    + "). "
     * @param networkService the bind/publish addresses.
     * Starts the gRPC server transport.
import org.opensearch.common.settings.Settings;
     * Configure size of executor thread pool for handling gRPC calls.
     *
        for (Server server : servers) {
/*
                }
    /**
        new TimeValue(Long.MAX_VALUE),
/**
                    .executor(grpcExecutor)
    private final ThreadPool threadPool;
            this.bossEventLoopGroup = new NioEventLoopGroup(1, daemonThreadFactory(settings, "grpc_boss"));
                    .addService(ProtoReflectionService.newInstance())
            hostAddresses = networkService.resolveBindHostAddresses(bindHosts);
                Server srv = serverBuilder.build().start();
import io.grpc.protobuf.services.HealthStatusManager;
    /**
    ExecutorService getGrpcExecutorForTesting() {
        this.port = SETTING_GRPC_PORT.get(settings);
import java.util.concurrent.ExecutorService;
        final InetAddress publishInetAddress;
        this.keepAliveTimeout = SETTING_GRPC_KEEPALIVE_TIMEOUT.get(settings);
    private volatile ExecutorService grpcExecutor;
                Thread.currentThread().interrupt();
    }
        "grpc.netty.max_concurrent_connection_calls",
    /**
    }
        } catch (IOException e) {
     * @param settings the configured settings.
                bossEventLoopGroup.shutdownGracefully(0, 10, TimeUnit.SECONDS).await();
    private final long maxConcurrentConnectionCalls;
                workerEventLoopGroup.shutdownGracefully(0, 10, TimeUnit.SECONDS).await();
        new ByteSizeValue(10, ByteSizeUnit.MB),
     * Port range on which to bind.
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
        SETTING_GRPC_HOST,
 */
                    .addService(new HealthStatusManager().getHealthService())
        "grpc.host",
                } catch (InterruptedException e) {
        Setting.Property.NodeScope
                    .maxConcurrentCallsPerConnection((int) maxConcurrentConnectionCalls)
        (s) -> Integer.toString(OpenSearchExecutors.allocatedProcessors(s)),
    private TransportAddress bindAddress(InetAddress hostAddress, PortsRange portRange) {
            this.workerEventLoopGroup = new NioEventLoopGroup(nettyEventLoopThreads, daemonThreadFactory(settings, "grpc_worker"));
    /**
        List<BindableService> services,
        "grpc.netty.keepalive_timeout",
            );
     */
        try {
        this.maxConnectionIdle = SETTING_GRPC_MAX_CONNECTION_IDLE.get(settings);
    private final NetworkService networkService;
        if (publishPort < 0) {
     */
    public static final Setting<List<String>> SETTING_GRPC_BIND_HOST = listSetting(
import static org.opensearch.common.settings.Setting.listSetting;
import java.util.List;
     */
    /**
    /**
     * @return the gRPC transport setting key
        return this.boundAddress;
     * @param configModifier builder configuration to set.
    /**
    /**
import org.apache.logging.log4j.Logger;
    protected String portSettingKey;
        );
        }
    private final int executorThreads;
        Setting.Property.NodeScope
import java.util.Arrays;
        this.executorThreads = SETTING_GRPC_EXECUTOR_COUNT.get(settings);
    );
import org.opensearch.threadpool.ThreadPool;
     * @return the bound transport address containing all bound addresses and publish address
