    }
     * Returns the setting key used to identify this transport type.  
                    server.shutdownNow();
     * Performs any necessary cleanup after stopping the transport.
import org.opensearch.common.unit.TimeValue;
 */
        new ByteSizeValue(Integer.MAX_VALUE, ByteSizeUnit.BYTES),  
     */
                addr.set(new TransportAddress(hostAddress, portNumber));
            this.grpcExecutor = threadPool.executor(GRPC_THREAD_POOL_NAME);
import java.util.ArrayList;
import io.grpc.netty.shaded.io.netty.channel.nio.NioEventLoopGroup;
    protected final Settings settings;
        new ByteSizeValue(10, ByteSizeUnit.MB),
            }
                    + " with distinct ports and none of them matched the publish address ("
        if (workerEventLoopGroup != null) {
    /**
        if (workerEventLoopGroup != null) {
    }  
import java.util.Objects;
        }
        this.settings = Objects.requireNonNull(settings);
        NetworkService networkService,
    /**
    /**  
        Setting.Property.NodeScope  
                final InetSocketAddress address = new InetSocketAddress(hostAddress, portNumber);
            logger.info("Started gRPC server on port {} with {} executor threads", port, executorThreads);  
    /**  
        Integer.MAX_VALUE,
        try {
        Setting.Property.NodeScope
    );
                logger.warn("Failed to shut down boss event loop group");  
        (s) -> Integer.toString(OpenSearchExecutors.allocatedProcessors(s) * 2),
     * Creates a new Netty4GrpcServerTransport instance.
        this.boundAddress = new BoundTransportAddress(boundAddresses.toArray(new TransportAddress[0]), publishAddress);
    );  
        }
    public static final Setting<PortsRange> SETTING_GRPC_PORT = AUX_TRANSPORT_PORT.getConcreteSettingForNamespace(  
        for (Server server : servers) {
            bossEventLoopGroup.close();  
        new TimeValue(Long.MAX_VALUE),  
            bindServer();
                } finally {
     */
     */
        Setting.Property.NodeScope
        this.maxConcurrentConnectionCalls = SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS.get(settings);  
        "grpc.publish_host",
        boolean success = portRange.iterate(portNumber -> {  
        (s) -> Setting.parseInt(s, 1, "grpc.netty.worker_count"),
        "grpc.netty.keepalive_timeout",  
     */
            Strings.EMPTY_ARRAY  
    public static final Setting<List<String>> SETTING_GRPC_HOST = listSetting(
     */
        new TimeValue(0),
     * This method is public for testing purposes.
    private final ServerInterceptor serverInterceptor;
        this.executorThreads = SETTING_GRPC_EXECUTOR_COUNT.get(settings);
    public Netty4GrpcServerTransport(  
                try {
                    .executor(grpcExecutor)
import static org.opensearch.common.settings.Setting.intSetting;
import org.opensearch.transport.BindTransportException;
        emptyList(),  
        this.networkService = Objects.requireNonNull(networkService);
    }  
                workerEventLoopGroup.shutdownGracefully(0, 10, TimeUnit.SECONDS).await();  
     * Closes the gRPC server transport.  
        List<TransportAddress> boundAddresses = new ArrayList<>(hostAddresses.length);  
        new TimeValue(Long.MAX_VALUE),
        "grpc.netty.max_msg_size",  
        "grpc.netty.executor_count",  
                    + portSettingKey  
    @Override  
        boolean success = false;
    /**
     * @param threadPool the thread pool for gRPC request processing.  
     * Returns the bound transport addresses for this gRPC server.
    );
    public static final Setting<Integer> SETTING_GRPC_EXECUTOR_COUNT = new Setting<>(
    private void bindServer() {
                    + "Please specify a unique port by setting "
        Function.identity(),
    private final int nettyEventLoopThreads;  
        ThreadPool threadPool  
        Setting.Property.NodeScope
        }
import io.grpc.protobuf.services.HealthStatusManager;
     * Initializes the event loop group and binds the server to the configured addresses.  
        "grpc.netty.worker_count",
                    .intercept(serverInterceptor);  
    /**
     * Port range on which to bind.  
    public static final Setting<ByteSizeValue> SETTING_GRPC_MAX_MSG_SIZE = Setting.byteSizeSetting(
     * No max idle time by default.
import java.util.concurrent.TimeUnit;
    private final CopyOnWriteArrayList<Server> servers = new CopyOnWriteArrayList<>();
        SETTING_GRPC_HOST,
    protected void doStop() {
     * Host list to bind and publish.
    /**  
        // Shutdown event loop groups  
import org.opensearch.core.common.transport.BoundTransportAddress;
     * Child classes have distinct transport type keys and need to override these settings.
    );
                server.shutdown();
        "grpc.netty.max_connection_idle",
                    + publishInetAddress  
        if (publishPort < 0) {
                    .addService(new HealthStatusManager().getHealthService())
    @Override
     */
    private final ThreadPool threadPool;
    EventLoopGroup getWorkerEventLoopGroupForTesting() {
                }  
        return workerEventLoopGroup;  
        this.bindHosts = (grpcBindHost.isEmpty() ? NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING.get(settings) : grpcBindHost).toArray(
    }  
     * @param services the gRPC compatible services to be registered with the server.
    /**
    private volatile BoundTransportAddress boundAddress;
        (s) -> Setting.parseInt(s, 1, "grpc.netty.executor_count"),
        this.maxConnectionIdle = SETTING_GRPC_MAX_CONNECTION_IDLE.get(settings);
            throw new BindTransportException(
            if (!success) {
    /**
    /**  
    public static final String GRPC_TRANSPORT_SETTING_KEY = "transport-grpc";  
        Setting.Property.NodeScope
        SETTING_GRPC_HOST,
            throw new BindTransportException("Failed to resolve publish address", e);  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
     *  
     * Type key for configuring settings of this auxiliary transport.
            .toArray(Strings.EMPTY_ARRAY);
    /**  
                }
                    .bossEventLoopGroup(bossEventLoopGroup)
        this.keepAliveTimeout = SETTING_GRPC_KEEPALIVE_TIMEOUT.get(settings);  
        });
     */
import org.opensearch.transport.grpc.interceptor.GrpcInterceptorChain;
     */
    }  
            }
     */
        return GRPC_TRANSPORT_SETTING_KEY;  
    /**
        TransportAddress publishAddress = new TransportAddress(new InetSocketAddress(publishInetAddress, publishPort));  
        Settings settings,
                    .maxConcurrentCallsPerConnection((int) maxConcurrentConnectionCalls)
import static java.util.Collections.emptyList;
     */
     * Port settings are set using the transport type, in this case GRPC_TRANSPORT_SETTING_KEY.  
import org.opensearch.core.common.unit.ByteSizeUnit;  
        logger.info("{}", boundAddress);
    ) {
        "grpc.bind_host",  
        Setting.Property.NodeScope  
        Setting.Property.NodeScope
import java.util.List;  
                    + " or "
import static org.opensearch.transport.Transport.resolveTransportPublishPort;
     * Starts the gRPC server transport.
     */  
    private final List<UnaryOperator<NettyServerBuilder>> serverBuilderConfigs = new ArrayList<>();  
    private final NetworkService networkService;
    public static final Setting<TimeValue> SETTING_GRPC_KEEPALIVE_TIMEOUT = Setting.timeSetting(
import java.net.InetSocketAddress;  
    }  
     * Inject a NettyServerBuilder configuration to be applied at server bind and start.  
     * Configure maximum inbound message size in bytes.  
        Setting.Property.NodeScope
        1,  
        new TimeValue(0),
    /**
     * Configure size of executor thread pool for handling gRPC calls.  
 * Services injected through BindableService list.
            publishInetAddress = networkService.resolvePublishHostAddresses(publishHosts);
     * @param configModifier builder configuration to set.
    /**
        return this.boundAddress;
    public static final Setting<TimeValue> SETTING_GRPC_MAX_CONNECTION_IDLE = Setting.timeSetting(
    private final List<BindableService> services;  
/*  
        ServerInterceptor serverInterceptor
    );
                Server srv = serverBuilder.build().start();
                    + SETTING_GRPC_PUBLISH_PORT.getKey()
                    op.apply(serverBuilder);  
import org.apache.logging.log4j.LogManager;
                    .workerEventLoopGroup(workerEventLoopGroup)  
                    .maxInboundMessageSize((int) maxInboundMessageSize)
    public static final Setting<List<String>> SETTING_GRPC_PUBLISH_HOST = listSetting(  
        this.maxInboundMessageSize = SETTING_GRPC_MAX_MSG_SIZE.get(settings).getBytes();
     */
            );  
     */
    private final TimeValue keepAliveTimeout;
     * Port range on which servers bind.
        } finally {
    private final long maxConcurrentConnectionCalls;  
import java.util.function.UnaryOperator;
        new ByteSizeValue(0, ByteSizeUnit.MB),
import io.grpc.netty.shaded.io.netty.channel.socket.nio.NioServerSocketChannel;  
                    Thread.currentThread().interrupt();
    private TransportAddress bindAddress(InetAddress hostAddress, PortsRange portRange) {
    @Override  
     * Port published to peers for this server.
     * @param settings the configured settings.  
                return false;  
    private final TimeValue maxConnectionAge;
     */
    private final int executorThreads;
        return bossEventLoopGroup;
            this.bossEventLoopGroup = new NioEventLoopGroup(1, daemonThreadFactory(settings, "grpc_boss"));
            }
                    logger.warn("Interrupted while shutting down gRPC server");  
    public static final Setting<Integer> SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS = Setting.intSetting(  
                final NettyServerBuilder serverBuilder = NettyServerBuilder.forAddress(address)  
            }
import org.opensearch.core.common.Strings;  
                    server.awaitTermination(30, TimeUnit.SECONDS);  
            try {
     * @return the bound transport address containing all bound addresses and publish address
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;  
        ThreadPool threadPool,
        "grpc.netty.max_connection_age",  
                    .channelType(NioServerSocketChannel.class)  
            throw new RuntimeException("Failed to bind to " + hostAddress + " on ports " + portRange, lastException.get());
        NetworkService networkService,  
                doStop();  
    private volatile EventLoopGroup bossEventLoopGroup;  
            if (server != null) {  
        "grpc.host",
            } catch (InterruptedException e) {
    ExecutorService getGrpcExecutorForTesting() {  
                    + "). "
        Setting.Property.NodeScope  
        this.port = SETTING_GRPC_PORT.get(settings);
     * Note this setting is configured through AffixSetting AUX_TRANSPORT_PORT where the aux transport type matches the GRPC_TRANSPORT_SETTING_KEY.
    }
import io.grpc.ServerInterceptor;
        final List<String> grpcPublishHost = SETTING_GRPC_PUBLISH_HOST.get(settings);
            }
     */
            try {
package org.opensearch.transport.grpc;
     */  
    public static final Setting<TimeValue> SETTING_GRPC_MAX_CONNECTION_AGE = Setting.timeSetting(
    /**  
        } catch (IOException e) {
    public String settingKey() {
        if (bossEventLoopGroup != null) {
        Settings settings,  
        new TimeValue(0),
     */  
        InetAddress[] hostAddresses;
        if (bossEventLoopGroup != null) {
     * Creates a new Netty4GrpcServerTransport instance.
    );
    protected void doClose() {
import org.opensearch.common.network.NetworkService;  
        Function.identity(),
    protected void doStart() {  
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
     * @param services the gRPC compatible services to be registered with the server.
    private final long maxInboundMessageSize;
    private static final Logger logger = LogManager.getLogger(Netty4GrpcServerTransport.class);
        100,
        for (InetAddress address : hostAddresses) {
    }
            try {
        } catch (Exception e) {
        logger.debug("Initializing Netty4GrpcServerTransport with settings = {}", settings);
    private volatile ExecutorService grpcExecutor;
                    .keepAliveTimeout(keepAliveTimeout.duration(), keepAliveTimeout.timeUnit())
        final InetAddress publishInetAddress;
        );
    /**
import org.opensearch.core.common.transport.TransportAddress;
        }  
     * Host list to bind.  
                bossEventLoopGroup.shutdownGracefully(0, 10, TimeUnit.SECONDS).await();  
    /**
        this.maxConnectionAge = SETTING_GRPC_MAX_CONNECTION_AGE.get(settings);
    /**
        return grpcExecutor;
import io.grpc.protobuf.services.ProtoReflectionService;
            } catch (Exception e) {
        }
     */  
/**
    }  
 * The OpenSearch Contributors require contributions made to  
            // Use OpenSearch's managed thread pool for gRPC request processing
     * Idle connections lasting longer than configured value will be gracefully terminated.
                    .addService(ProtoReflectionService.newInstance())
public class Netty4GrpcServerTransport extends AuxTransport {  
        AtomicReference<TransportAddress> addr = new AtomicReference<>();
        final int publishPort = resolveTransportPublishPort(SETTING_GRPC_PUBLISH_PORT.get(settings), boundAddresses, publishInetAddress);  
                lastException.set(e);
        Function.identity(),  
    );  
        this.portSettingKey = SETTING_GRPC_PORT.getKey();
        // Note: grpcExecutor is managed by OpenSearch's ThreadPool, so we don't shut it down here
     * Settings.  
            // Create separate boss and worker event loop groups for better isolation  
        }
     */  
     * @param serverInterceptor the gRPC server interceptor to be applied.
                Thread.currentThread().interrupt();
     * For distinct bind/publish hosts configure SETTING_GRPC_BIND_HOST + SETTING_GRPC_PUBLISH_HOST separately.
import static org.opensearch.common.settings.Setting.listSetting;  
        this.publishHosts = (grpcPublishHost.isEmpty() ? NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings) : grpcPublishHost)  
     */
        List<BindableService> services,
        try {  
        this(settings, services, networkService, threadPool, new GrpcInterceptorChain(threadPool.getThreadContext()));
    // Package-private methods for testing
    /**
        final List<String> grpcBindHost = SETTING_GRPC_BIND_HOST.get(settings);
import java.util.concurrent.CopyOnWriteArrayList;
                    + boundAddresses
import java.util.concurrent.ExecutorService;  
     * Connections lasting longer than configured age will be gracefully terminated.
    }
    /**
     * @return the gRPC transport setting key
    }
        new TimeValue(Long.MAX_VALUE),
 * this file be licensed under the Apache-2.0 license or a
        this.nettyEventLoopThreads = SETTING_GRPC_WORKER_COUNT.get(settings);  
import io.grpc.BindableService;  
import org.opensearch.common.transport.PortsRange;  
import org.opensearch.common.settings.Settings;
    /**
    /**  
    public static final Setting<Integer> SETTING_GRPC_PUBLISH_PORT = intSetting("grpc.publish_port", -1, -1, Setting.Property.NodeScope);
     *
    }
        try {  
     * Shuts down all running servers and the event loop group.
     * Host list published to peers.
import io.grpc.netty.shaded.io.netty.channel.EventLoopGroup;
        }
                } catch (InterruptedException e) {
     * Timeout for keepalive ping requests of an established connection.  
                logger.warn("Failed to shut down worker event loop group");  
     */
    protected String portSettingKey;  
        if (!success) {
 *
                Thread.currentThread().interrupt();
    public BoundTransportAddress getBoundAddress() {
    private final String[] publishHosts;
    );  
            success = true;
            boundAddresses.add(bindAddress(address, port));
        }
        }
    private final TimeValue maxConnectionIdle;  
        this.services = Objects.requireNonNull(services);  
            workerEventLoopGroup.close();  
import java.io.IOException;
        this.serverInterceptor = Objects.requireNonNull(serverInterceptor);
    @Override
                    .maxConnectionAge(maxConnectionAge.duration(), maxConnectionAge.timeUnit())  
     * @param settings the configured settings.  
 * Netty4 gRPC server implemented as a LifecycleComponent.  
                for (UnaryOperator<NettyServerBuilder> op : serverBuilderConfigs) {
        AtomicReference<Exception> lastException = new AtomicReference<>();  
        }  
     * Stops the gRPC server transport.  
                servers.add(srv);  
        }
                "Failed to auto-resolve grpc publish port, multiple bound addresses "  
    private volatile EventLoopGroup workerEventLoopGroup;
     */
import java.util.Arrays;
        this.threadPool = Objects.requireNonNull(threadPool);  
    /**
    public Netty4GrpcServerTransport(
    public static final Setting<Integer> SETTING_GRPC_WORKER_COUNT = new Setting<>(
 * compatible open source license.
    );
                return true;  
     */
        Setting.Property.NodeScope  
    @Override  
     * @param networkService the bind/publish addresses.
     */
import org.apache.logging.log4j.Logger;
 * SPDX-License-Identifier: Apache-2.0
    EventLoopGroup getBossEventLoopGroupForTesting() {
                services.forEach(serverBuilder::addService);  
     * @param threadPool the thread pool for gRPC request processing.  
        (s) -> Integer.toString(OpenSearchExecutors.allocatedProcessors(s)),  
                    .maxConnectionIdle(maxConnectionIdle.duration(), maxConnectionIdle.timeUnit())
import org.opensearch.common.settings.Setting;
    public static final Setting<List<String>> SETTING_GRPC_BIND_HOST = listSetting(
            this.workerEventLoopGroup = new NioEventLoopGroup(nettyEventLoopThreads, daemonThreadFactory(settings, "grpc_worker"));
    /**
    private final String[] bindHosts;
import java.util.concurrent.atomic.AtomicReference;
        return addr.get();
    }  
    );  
        serverBuilderConfigs.add(configModifier);
     * Configure size of thread pool backing this transport server.
     * @param networkService the bind/publish addresses.
     * No max connection age by default.  
import static org.opensearch.transport.grpc.GrpcPlugin.GRPC_THREAD_POOL_NAME;  
        "grpc.netty.max_concurrent_connection_calls",
import org.opensearch.threadpool.ThreadPool;
    protected void addServerConfig(UnaryOperator<NettyServerBuilder> configModifier) {  
                logger.debug("Bound gRPC to address {{}}", address);
import java.net.InetAddress;
import org.opensearch.transport.AuxTransport;  
    ) {  
        List<BindableService> services,
            } catch (InterruptedException e) {
    );
    protected PortsRange port;  
import io.grpc.Server;
}
import org.opensearch.core.common.unit.ByteSizeValue;
            throw new BindTransportException("Failed to resolve host [" + Arrays.toString(bindHosts) + "]", e);  
     * Controls the number of allowed simultaneous in flight requests a single client connection may send.
            hostAddresses = networkService.resolveBindHostAddresses(bindHosts);
        GRPC_TRANSPORT_SETTING_KEY
import java.util.function.Function;  
 */  
