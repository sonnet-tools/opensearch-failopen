        }
         * @throws IllegalArgumentException if the key already exists
        public FlightServer build() {
                    break;
                        }
         * @param key An identifier for this middleware component. Service implementations can retrieve
                    try {
                        (Consumer<NettyServerBuilder>) builderConsumer;
            final FlightBindingService flightService =
                            final EventLoopGroup elg =
         *
                {
         */
            return this;
                    ServerInterceptors.intercept(
            builderOptions.put("netty.bossEventLoopGroup", bossELG);
                                Class.forName("io.netty.channel.kqueue.KQueueServerDomainSocketChannel")
         */
         * Set the executor used by the server.
            return this;
    /** Default per-stream outbound buffered-bytes threshold; can be overridden via
/*
        private void closeMTlsCACert() {
                             | NoSuchMethodException
    /** The maximum size of an individual gRPC message. This effectively disables the limit. */
        }
                                    .asSubclass(EventLoopGroup.class)
                grpcExecutor = null;
        private int backpressureThreshold = DEFAULT_BACKPRESSURE_THRESHOLD;
            builderOptions.put("netty.workerEventLoopGroup", workerELG);
        private FlightProducer producer;
                    builder.workerEventLoopGroup((EventLoopGroup) elg);
        /**
        private ExecutorService executor = null;
 * <p>
         *
            }
                             | InstantiationException
        /**
        public Builder sslContext(SslContext sslContext) {
         *     org.apache.arrow.flight.FlightProducer.CallContext}.
        public Builder useTls(final InputStream certChain, final InputStream key) throws IOException {
                throw new IllegalArgumentException("Key already exists: " + key.key);
                    return null;
        /** Create the server for this builder. */
                                Class.forName("io.netty.channel.epoll.EpollEventLoopGroup")
import org.apache.arrow.flight.auth.ServerAuthHandler;
        public Builder addListenAddress(Location location) {
         *
import io.netty.channel.EventLoopGroup;
         * blocked.
                                    .newInstance();
                case LocationSchemes.GRPC_TLS:
            // Add the auth middleware if applicable.
        }
        }
            return this;
            return this;
import org.apache.arrow.flight.grpc.ServerBackpressureThresholdInterceptor;
         * <p>Flight will NOT take ownership of the executor. The application must clean it up if one is
                            builder.channelType(
            interceptorKeys = new HashSet<>();
         * It then sets the attribute to null.
            builderOptions.computeIfPresent(
                        new ServerBackpressureThresholdInterceptor(backpressureThreshold),
        @SuppressWarnings("unchecked")
            builderOptions.computeIfPresent(
                        throw new IllegalArgumentException(
 */
import javax.net.ssl.SSLException;
                throw new IllegalStateException("GRPC executor must be passed to start Flight server.");
        public Builder setMaxHeaderListSize(int maxHeaderListSize) {
         * @param mTlsCACert The CA certificate to use for verifying clients.
                            "Could not find suitable Netty native transport implementation for domain socket address.");
        public Builder workerEventLoopGroup(EventLoopGroup workerELG) {
            // We only want to have FlightServer close the gRPC executor if we created it here. We should
        }}
                .maxInboundMessageSize(maxInboundMessageSize)
            return this;
    /** A builder for Flight servers. */
import org.apache.arrow.flight.auth2.ServerCallHeaderAuthMiddleware;
        }
        /**
import java.lang.invoke.MethodType;
            Preconditions.checkArgument(backpressureThreshold > 0);
                }
                builder.sslContext(sslContext);
public class OSFlightServer {
                    break;
                .addService(
                    if (certChain == null && sslContext == null) {
        private InputStream mTlsCACert;
import io.grpc.Server;
         * @param certChain The certificate chain to use.
import java.util.HashSet;
            this();
        Builder() {
        }
                    builder = NettyServerBuilder.forAddress(primaryLocation.toSocketAddress());
            return this;
        }
                new FlightBindingService(allocator, producer, authHandler, exec);
            Location primaryLocation = location != null ? location : listenAddresses.get(0);
            switch (primaryLocation.getUri().getScheme()) {
 * Clone of {@link org.apache.arrow.flight.FlightServer} to support setting SslContext. It can be discarded once FlightServer.Builder supports setting SslContext directly.
        public <T extends FlightServerMiddleware> Builder middleware(
                } catch (SSLException e) {
            builderOptions.put(key, option);
        public Builder useTls(final File certChain, final File key) throws IOException {
    }
         *
    public static Builder builder() {
                    closeMTlsCACert();
                throw new IllegalStateException("Unable to instantiate FlightServer", ex);
            FLIGHT_SERVER_CTOR_MH = AccessController.doPrivileged(() -> {
                        new ServerAuthInterceptor(authHandler)));
                try {
 */
         * @param stream The InputStream to close (if it is not null).
            closeInputStreamIfNotNull(key);
                                    .asSubclass(ServerChannel.class));
         *
import java.util.concurrent.ExecutorService;
        /**
            builderOptions.put("netty.channelType", channelType);
            closeCertChain();
        public Builder executor(ExecutorService executor) {
                case LocationSchemes.GRPC_INSECURE:
        /** Set the header-based authentication mechanism. */
        /**
            closeInputStreamIfNotNull(mTlsCACert);
         */
                            "Must provide a certificate and key to serve gRPC over TLS");
            final ExecutorService exec;
         * then sets the attribute to null.
            }
         * A small utility function to ensure that the key attribute is closed if it is not null. It
                this.middleware(
import org.opensearch.secure_sm.AccessController;
            final NettyServerBuilder builder;
         */
import java.io.FileInputStream;
            this.sslContext = sslContext;
import org.apache.arrow.memory.BufferAllocator;
            if (executor != null) {
        private BufferAllocator allocator;
            closeMTlsCACert();
            this.location = Preconditions.checkNotNull(location);
import org.apache.arrow.util.Preconditions;
                (key, elg) -> {
            // versions or
        /**
                    closeKey();
                }
                    throw new IllegalArgumentException(
            this.maxHeaderListSize = maxHeaderListSize;
            this.key = key;
            this.certChain = certChain;
                    sslContext = sslContextBuilder.build();
                            builder.bossEventLoopGroup(elg).workerEventLoopGroup(elg);
        private void closeCertChain() {
                if (mTlsCACert != null) {
            return this;
 * SPDX-License-Identifier: Apache-2.0
                    builder.addListenAddress(listenAddress.toSocketAddress());
        public Builder transportHint(final String key, Object option) {
         * A small utility function to ensure that InputStream attributes. are closed if they are not
            if (certChain != null && sslContext == null) {
                try {
        /** Provide a transport-specific option. Not guaranteed to have any effect. */
        private void closeInputStreamIfNotNull(InputStream stream) {
    public final static class Builder {
import java.util.List;
        }
            builder.intercept(new ServerInterceptorAdapter(interceptors));
                            final EventLoopGroup elg =
         * Enable TLS on the server.
         *
import org.apache.arrow.flight.auth.ServerAuthInterceptor;
            // Allow explicitly setting some Netty-specific options
                case LocationSchemes.GRPC_DOMAIN_SOCKET:
 * compatible open source license.
            return this;
                    stream.close();
            }
            }
        public Builder headerAuthenticator(CallHeaderAuthenticator headerAuthenticator) {
                SslContextBuilder sslContextBuilder = GrpcSslContexts.forServer(certChain, key);
        }
            if (headerAuthenticator != CallHeaderAuthenticator.NO_OP) {
import org.apache.arrow.flight.grpc.ServerInterceptorAdapter.KeyFactory;
                (key, channelType) -> {
            // not close
import java.util.HashMap;
         * Set the maximum size of a message. Defaults to "unlimited", depending on the underlying
import io.grpc.netty.GrpcSslContexts;
import java.io.File;
         *
            closeKey();
    static {
                        throw new UnsupportedOperationException(
                }
            certChain = null;
            // Add additional listen addresses
    }
                "netty.workerEventLoopGroup",
            interceptors.add(new KeyFactory<>(key, factory));
            // Use primary location for initial setup
                });
                        flightService,
                    builder = NettyServerBuilder.forAddress(primaryLocation.toSocketAddress());
        private int maxInboundMessageSize = MAX_GRPC_MESSAGE_SIZE;
         */
        return new Builder();
        }
                             | InvocationTargetException e) {
                                Class.forName("io.netty.channel.epoll.EpollServerDomainSocketChannel")
        public Builder authHandler(ServerAuthHandler authHandler) {
import io.grpc.ServerInterceptors;
        /**
        private int maxHeaderListSize = MAX_GRPC_MESSAGE_SIZE;
         * A small utility function to ensure that the certChain attribute is closed if it is not null.
        public Builder location(Location location) {
         */
                {
import io.netty.handler.ssl.ClientAuth;
                                    .getConstructor()
import java.util.Set;
            return this;
        private InputStream certChain;
            return this;
            this.producer = Preconditions.checkNotNull(producer);
            builder
                "netty.bossEventLoopGroup",
         *     the middleware instance for the current call using {@link
        private Location location;
        private ServerAuthHandler authHandler = ServerAuthHandler.NO_OP;
            interceptors = new ArrayList<>();
     *  {@code docs/backpressure.md} for sizing guidance. */
                default:
                    consumer.accept(builder);
        private final List<KeyFactory<?>> interceptors;
 * It changes {@link org.apache.arrow.flight.FlightServer.Builder} to allow hook to configure the NettyServerBuilder.
            for (Location listenAddress : listenAddresses) {
        }
                    return null;
         * Add a Flight middleware component to inspect and modify requests to this service.
            return this;
                    builder = NettyServerBuilder.forAddress(primaryLocation.toSocketAddress());
            return this;
            return this;
        }
                } finally {
import io.netty.handler.ssl.SslContext;
        /** Set the authentication handler. */
         */
        public Builder allocator(BufferAllocator allocator) {
            try {
                }
        }
         * @param factory A factory for the middleware.
        private final Map<String, Object> builderOptions;
                });
         * transport.
            closeMTlsCACert();
                    sslContextBuilder.clientAuth(ClientAuth.REQUIRE).trustManager(mTlsCACert);
            interceptorKeys.add(key.key);
            } catch (final Throwable ex) {
                            // Linux
                }
        }
                    // The implementation is platform-specific, so we have to find the classes at runtime
         * It then sets the attribute to null.
                });
}
        }
import org.apache.arrow.flight.grpc.ServerInterceptorAdapter;
                        try {
                return MethodHandles
                    try {
            this.producer = Preconditions.checkNotNull(producer);
import java.io.InputStream;
        }
        private final Set<String> interceptorKeys;
            if (interceptorKeys.contains(key.key)) {
        private void closeKey() {
                });
            this.key = new FileInputStream(key);
            }
        /**
                case LocationSchemes.GRPC:
            return this;
            this.backpressureThreshold = backpressureThreshold;
            return this;
                    throw new RuntimeException(e);
import java.util.function.Consumer;
        );
        /**
                return (FlightServer)FLIGHT_SERVER_CTOR_MH.invoke(primaryLocation, builder.build(), grpcExecutor);
            return this;
            this.mTlsCACert = new FileInputStream(mTlsCACert);
            closeInputStreamIfNotNull(certChain);
package org.apache.arrow.flight;
                (key, elg) -> {
            }
            final FlightServerMiddleware.Key<T> key, final FlightServerMiddleware.Factory<T> factory) {
         * @param key The private key to use.
    static final int MAX_GRPC_MESSAGE_SIZE = Integer.MAX_VALUE;
            this.authHandler = authHandler;
            builderOptions.computeIfPresent(
        }
        Builder(BufferAllocator allocator, Location location, FlightProducer producer) {
        }
            this.headerAuthenticator = headerAuthenticator;
                "grpc.builderConsumer",
        }
            key = null;
                        } catch (ClassNotFoundException e) {
                    closeCertChain();
        }
    }
import java.lang.invoke.MethodHandles;
            closeCertChain();
                            // BSD
                .maxInboundMetadataSize(maxHeaderListSize)
        // Keep track of inserted interceptors
         * @param certChain The certificate chain to use.
/**
                                    .asSubclass(ServerChannel.class));
 *
                             | IllegalAccessException
        /**
            this.executor = executor;
                builder.sslContext(sslContext);
import org.apache.arrow.flight.auth2.Auth2Constants;
            final ExecutorService grpcExecutor;
            // Share one executor between the gRPC service, DoPut, and Handshake
                                    .getConstructor()
        public Builder useMTlsClientVerification(final File mTlsCACert) throws IOException {
                    final Consumer<NettyServerBuilder> consumer =
            this.maxInboundMessageSize = maxMessageSize;
                {
            }
            return this;
                if (!listenAddress.equals(primaryLocation)) {
         * A small utility function to ensure that the mTlsCACert attribute is closed if it is not null.
                    builder.channelType((Class<? extends ServerChannel>) channelType);
         */
            this.location = Preconditions.checkNotNull(location);
                "netty.channelType",
         */
 * The OpenSearch Contributors require contributions made to
            } else {
        }
            return this;
        public Builder maxInboundMessageSize(int maxMessageSize) {
            this.mTlsCACert = mTlsCACert;
         * Enable TLS on the server.
                exec = executor;
        }
import java.io.IOException;
        /**
        public Builder channelType(Class<? extends io.netty.channel.Channel> channelType) {
            mTlsCACert = null;
        }
    static final int DEFAULT_BACKPRESSURE_THRESHOLD = 64 * 1024 * 1024; // 64MB
                    // stream closes gracefully, doesn't expect an exception.
                            builder.bossEventLoopGroup(elg).workerEventLoopGroup(elg);
                    new ServerCallHeaderAuthMiddleware.Factory(headerAuthenticator));
                        "Scheme is not supported: " + primaryLocation.getUri().getScheme());
import io.netty.handler.ssl.SslContextBuilder;
         */
                                Class.forName("io.netty.channel.kqueue.KQueueEventLoopGroup")
                    builder.bossEventLoopGroup((EventLoopGroup) elg);
        public Builder producer(FlightProducer producer) {
            // user-supplied executors.
                    } catch (ClassNotFoundException
            builderOptions = new HashMap<>();
                } catch (IOException expected) {
import io.grpc.netty.NettyServerBuilder;
import java.util.ArrayList;
         * @param mTlsCACert The CA certificate to use for verifying clients.
        public Builder useMTlsClientVerification(final InputStream mTlsCACert) throws IOException {
                    break;
         * null
                    return null;
         */
            return this;
                    }
        private InputStream key;
import org.apache.arrow.flight.auth2.CallHeaderAuthenticator;
            if (stream != null) {
         * Enable Client Verification via mTLS on the server.
            this.allocator = Preconditions.checkNotNull(allocator);
         * @param key The private key to use.
                }
            throw new IllegalStateException("Unable to find the FlightServer constructor to invoke", ex);
        }
            }
                .findConstructor(FlightServer.class, MethodType.methodType(void.class, Location.class, Server.class, ExecutorService.class));
    private static final MethodHandle FLIGHT_SERVER_CTOR_MH;
                            builder.channelType(
         * Enable mTLS on the server.
            this.middleware(FlightConstants.HEADER_KEY, new ServerHeaderMiddleware.Factory());
         * provided. (If not provided, Flight will use a default executor which it will clean up.)
                                    .asSubclass(EventLoopGroup.class)
            // Allow hooking into the gRPC builder. This is not guaranteed to be available on all Arrow
     *  {@code arrow.flight.channel.outbound_buffer_threshold}. See
        private CallHeaderAuthenticator headerAuthenticator = CallHeaderAuthenticator.NO_OP;
                .privateLookupIn(FlightServer.class, MethodHandles.lookup())
                    }
         */
        }
 * this file be licensed under the Apache-2.0 license or a
            } else if (sslContext != null) {
        /**
        private SslContext sslContext;
        public Builder backpressureThreshold(int backpressureThreshold) {
                .executor(exec)
            return this;
import java.lang.reflect.InvocationTargetException;
import io.netty.channel.ServerChannel;
            this.certChain = new FileInputStream(certChain);
                }
                (key, builderConsumer) -> {
        }
        }
import java.util.Map;
import java.lang.invoke.MethodHandle;
                    FlightServerMiddleware.Key.of(Auth2Constants.AUTHORIZATION_HEADER),
            this.listenAddresses.add(Preconditions.checkNotNull(location));
                                    .newInstance();
        public Builder bossEventLoopGroup(EventLoopGroup bossELG) {
                    return null;
            builderOptions.computeIfPresent(
            closeKey();
         * @param <T> The middleware type.
        } catch (final NoSuchMethodException | IllegalAccessException ex) {
        private final List<Location> listenAddresses = new ArrayList<>();
         * Set the number of bytes that may be queued on a server output stream before writes are
            // Flight implementations.
            this.allocator = Preconditions.checkNotNull(allocator);
