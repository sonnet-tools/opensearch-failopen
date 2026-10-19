            this.authHandler = authHandler;  
        return new Builder();  
            // not close  
            }
            this.key = key;
            closeCertChain();  
                });
                        throw new UnsupportedOperationException(
            builderOptions.put(key, option);  
    private static final MethodHandle FLIGHT_SERVER_CTOR_MH;
                .maxInboundMessageSize(maxInboundMessageSize)
        @SuppressWarnings("unchecked")  
            mTlsCACert = null;
            // user-supplied executors.
        public FlightServer build() {
                    return null;
        public Builder useMTlsClientVerification(final File mTlsCACert) throws IOException {
                    builder.addListenAddress(listenAddress.toSocketAddress());  
        private CallHeaderAuthenticator headerAuthenticator = CallHeaderAuthenticator.NO_OP;  
         * @param key The private key to use.  
                            builder.channelType(
                    closeKey();
        public Builder location(Location location) {
                                Class.forName("io.netty.channel.epoll.EpollEventLoopGroup")
                        "Scheme is not supported: " + primaryLocation.getUri().getScheme());  
                        try {
        /**
                (key, builderConsumer) -> {  
        /**
import java.lang.invoke.MethodType;
                        new ServerAuthInterceptor(authHandler)));
            this.location = Preconditions.checkNotNull(location);  
            return this;  
         */
                if (!listenAddress.equals(primaryLocation)) {
            builderOptions = new HashMap<>();
        /**  
         * Set the maximum size of a message. Defaults to "unlimited", depending on the underlying
        Builder(BufferAllocator allocator, Location location, FlightProducer producer) {
                case LocationSchemes.GRPC:
        public Builder transportHint(final String key, Object option) {
                    // stream closes gracefully, doesn't expect an exception.  
package org.apache.arrow.flight;
         *
            Preconditions.checkArgument(backpressureThreshold > 0);
        }}  
         *
        private BufferAllocator allocator;  
            builder.intercept(new ServerInterceptorAdapter(interceptors));
        private InputStream key;  
                    builder = NettyServerBuilder.forAddress(primaryLocation.toSocketAddress());
            // versions or
                throw new IllegalStateException("GRPC executor must be passed to start Flight server.");
                    throw new RuntimeException(e);  
         * @param mTlsCACert The CA certificate to use for verifying clients.  
            closeMTlsCACert();  
                    if (certChain == null && sslContext == null) {  
            builderOptions.computeIfPresent(
        }  
        /**
import java.io.FileInputStream;
                case LocationSchemes.GRPC_INSECURE:
                            // Linux
            this.location = Preconditions.checkNotNull(location);
        }
                {
                throw new IllegalStateException("Unable to instantiate FlightServer", ex);  
                            final EventLoopGroup elg =
                }  
         */
import io.grpc.netty.GrpcSslContexts;  
        public Builder setMaxHeaderListSize(int maxHeaderListSize) {
/**
                new FlightBindingService(allocator, producer, authHandler, exec);
            return this;
        /**
                        flightService,  
                                    .asSubclass(ServerChannel.class));
                exec = executor;
            }
            }
                    final Consumer<NettyServerBuilder> consumer =
            }
            this.maxHeaderListSize = maxHeaderListSize;
            closeCertChain();  
                    builder.channelType((Class<? extends ServerChannel>) channelType);
         * Add a Flight middleware component to inspect and modify requests to this service.
import org.opensearch.secure_sm.AccessController;
import org.apache.arrow.flight.grpc.ServerInterceptorAdapter;
/*  
        private FlightProducer producer;  
import io.netty.handler.ssl.SslContext;
            return this;  
                {  
         * @param certChain The certificate chain to use.
 */  
import io.grpc.netty.NettyServerBuilder;
            this.key = new FileInputStream(key);
            return this;
         *     the middleware instance for the current call using {@link
         * @param stream The InputStream to close (if it is not null).
                    builder = NettyServerBuilder.forAddress(primaryLocation.toSocketAddress());
                }
import io.grpc.Server;
         * @param key An identifier for this middleware component. Service implementations can retrieve
        }
            final FlightServerMiddleware.Key<T> key, final FlightServerMiddleware.Factory<T> factory) {  
            interceptors.add(new KeyFactory<>(key, factory));
            // Add the auth middleware if applicable.
        public Builder addListenAddress(Location location) {
            // Allow hooking into the gRPC builder. This is not guaranteed to be available on all Arrow
            interceptorKeys = new HashSet<>();
        private void closeMTlsCACert() {  
import io.netty.handler.ssl.ClientAuth;
                            "Could not find suitable Netty native transport implementation for domain socket address.");  
            return this;
         */
                                Class.forName("io.netty.channel.kqueue.KQueueServerDomainSocketChannel")  
        }
                    consumer.accept(builder);  
import java.util.Set;
         */  
         * @param key The private key to use.  
            // Flight implementations.  
                        } catch (ClassNotFoundException e) {  
         *
import org.apache.arrow.memory.BufferAllocator;  
         * A small utility function to ensure that the mTlsCACert attribute is closed if it is not null.  
                (key, elg) -> {
            try {  
import io.netty.handler.ssl.SslContextBuilder;  
import java.io.File;
            // Allow explicitly setting some Netty-specific options
import java.util.concurrent.ExecutorService;  
        private InputStream certChain;
                                    .getConstructor()  
            interceptors = new ArrayList<>();  
            for (Location listenAddress : listenAddresses) {
            closeInputStreamIfNotNull(mTlsCACert);
    public static Builder builder() {
import org.apache.arrow.util.Preconditions;
         * null  
         */  
                            // BSD
                    }
                    builder.bossEventLoopGroup((EventLoopGroup) elg);
        public Builder backpressureThreshold(int backpressureThreshold) {
                    return null;  
                try {  
        /** Create the server for this builder. */
                    new ServerCallHeaderAuthMiddleware.Factory(headerAuthenticator));  
        private Location location;
import java.util.HashMap;
            this.allocator = Preconditions.checkNotNull(allocator);
        }
            final ExecutorService exec;
        private ExecutorService executor = null;
            builderOptions.put("netty.workerEventLoopGroup", workerELG);
        }
        private ServerAuthHandler authHandler = ServerAuthHandler.NO_OP;
        /** Set the header-based authentication mechanism. */
                return MethodHandles
        private void closeInputStreamIfNotNull(InputStream stream) {
                } finally {
            return this;  
        public Builder useMTlsClientVerification(final InputStream mTlsCACert) throws IOException {
                    sslContext = sslContextBuilder.build();
         * Set the number of bytes that may be queued on a server output stream before writes are
            this.executor = executor;  
        private int backpressureThreshold = DEFAULT_BACKPRESSURE_THRESHOLD;
                                    .getConstructor()
         * then sets the attribute to null.
    static final int DEFAULT_BACKPRESSURE_THRESHOLD = 64 * 1024 * 1024; // 64MB  
        public Builder executor(ExecutorService executor) {
            if (certChain != null && sslContext == null) {  
            if (stream != null) {
    }  
         *
         * provided. (If not provided, Flight will use a default executor which it will clean up.)  
        );
                "netty.channelType",  
        private final List<Location> listenAddresses = new ArrayList<>();
        private final List<KeyFactory<?>> interceptors;  
         * It then sets the attribute to null.
        public Builder maxInboundMessageSize(int maxMessageSize) {
        public <T extends FlightServerMiddleware> Builder middleware(
            return this;
                } catch (SSLException e) {
import io.netty.channel.ServerChannel;  
            final NettyServerBuilder builder;
        /**
        }
                }
                            builder.bossEventLoopGroup(elg).workerEventLoopGroup(elg);
                if (mTlsCACert != null) {  
            } catch (final Throwable ex) {
         * A small utility function to ensure that the certChain attribute is closed if it is not null.  
                (key, elg) -> {
                    closeMTlsCACert();
            closeInputStreamIfNotNull(key);
import io.netty.channel.EventLoopGroup;
                             | NoSuchMethodException  
         * Enable TLS on the server.  
         * transport.
                    try {  
                    ServerInterceptors.intercept(
import java.util.List;  
         * A small utility function to ensure that InputStream attributes. are closed if they are not
            key = null;
        } catch (final NoSuchMethodException | IllegalAccessException ex) {
                {  
                .executor(exec)
            return this;
            switch (primaryLocation.getUri().getScheme()) {
                }
            FLIGHT_SERVER_CTOR_MH = AccessController.doPrivileged(() -> {
            this.allocator = Preconditions.checkNotNull(allocator);  
         *     org.apache.arrow.flight.FlightProducer.CallContext}.  
                throw new IllegalArgumentException("Key already exists: " + key.key);
                             | InvocationTargetException e) {
                "grpc.builderConsumer",
                }
            certChain = null;
import java.io.IOException;  
import java.util.function.Consumer;
                        throw new IllegalArgumentException(
         */
                .maxInboundMetadataSize(maxHeaderListSize)  
                SslContextBuilder sslContextBuilder = GrpcSslContexts.forServer(certChain, key);
         * It then sets the attribute to null.
 */
                            builder.channelType(  
                                    .asSubclass(EventLoopGroup.class)
import io.grpc.ServerInterceptors;
        private void closeCertChain() {  
        private int maxHeaderListSize = MAX_GRPC_MESSAGE_SIZE;  
        }  
        }  
            this.producer = Preconditions.checkNotNull(producer);
            this.sslContext = sslContext;  
        }  
                                    .asSubclass(EventLoopGroup.class)
                try {  
            builderOptions.computeIfPresent(
            this.middleware(FlightConstants.HEADER_KEY, new ServerHeaderMiddleware.Factory());  
        private final Set<String> interceptorKeys;
                             | InstantiationException
            this.mTlsCACert = mTlsCACert;
                        new ServerBackpressureThresholdInterceptor(backpressureThreshold),
         */
                this.middleware(
            return this;  
                                    .newInstance();  
        public Builder channelType(Class<? extends io.netty.channel.Channel> channelType) {
            builderOptions.computeIfPresent(
            this.producer = Preconditions.checkNotNull(producer);
        }
    /** Default per-stream outbound buffered-bytes threshold; can be overridden via  
 * <p>  
                });
            builderOptions.computeIfPresent(
         *
        /**  
                    FlightServerMiddleware.Key.of(Auth2Constants.AUTHORIZATION_HEADER),
import java.lang.reflect.InvocationTargetException;
                "netty.workerEventLoopGroup",  
import java.lang.invoke.MethodHandles;  
 * Clone of {@link org.apache.arrow.flight.FlightServer} to support setting SslContext. It can be discarded once FlightServer.Builder supports setting SslContext directly.
                    } catch (ClassNotFoundException  
                    try {  
            }
            return this;  
         * @param mTlsCACert The CA certificate to use for verifying clients.  
                builder.sslContext(sslContext);  
                    // The implementation is platform-specific, so we have to find the classes at runtime
         * blocked.
            this.headerAuthenticator = headerAuthenticator;  
            this.backpressureThreshold = backpressureThreshold;  
                .addService(
        Builder() {
                case LocationSchemes.GRPC_TLS:
            return this;
                    break;
                builder.sslContext(sslContext);
            this.certChain = new FileInputStream(certChain);
    static final int MAX_GRPC_MESSAGE_SIZE = Integer.MAX_VALUE;
import org.apache.arrow.flight.grpc.ServerInterceptorAdapter.KeyFactory;
         * @param certChain The certificate chain to use.
        public Builder headerAuthenticator(CallHeaderAuthenticator headerAuthenticator) {
            return this;
                    }  
}
import org.apache.arrow.flight.auth.ServerAuthInterceptor;
                                    .newInstance();
        }  
         */
import java.io.InputStream;
         * Set the executor used by the server.  
                    return null;  
                                Class.forName("io.netty.channel.epoll.EpollServerDomainSocketChannel")
         * @param <T> The middleware type.
                grpcExecutor = null;
            closeKey();  
                });
                    builder.workerEventLoopGroup((EventLoopGroup) elg);
         *  
        public Builder workerEventLoopGroup(EventLoopGroup workerELG) {  
            // Share one executor between the gRPC service, DoPut, and Handshake  
            }  
                                    .asSubclass(ServerChannel.class));
        }
     *  {@code arrow.flight.channel.outbound_buffer_threshold}. See
        private SslContext sslContext;
        }
            return this;
                    stream.close();
         * Enable TLS on the server.  
         * <p>Flight will NOT take ownership of the executor. The application must clean it up if one is
            return this;
                    break;
            }
import java.lang.invoke.MethodHandle;
        public Builder useTls(final InputStream certChain, final InputStream key) throws IOException {
        }
            if (headerAuthenticator != CallHeaderAuthenticator.NO_OP) {  
            Location primaryLocation = location != null ? location : listenAddresses.get(0);
                        (Consumer<NettyServerBuilder>) builderConsumer;
         * @throws IllegalArgumentException if the key already exists  
        /**
         */
        private void closeKey() {  
import org.apache.arrow.flight.grpc.ServerBackpressureThresholdInterceptor;  
            interceptorKeys.add(key.key);
            // Add additional listen addresses  
                .privateLookupIn(FlightServer.class, MethodHandles.lookup())
            // Use primary location for initial setup
        private final Map<String, Object> builderOptions;
                    break;
        }
                }  
    }
import org.apache.arrow.flight.auth2.ServerCallHeaderAuthMiddleware;
         * A small utility function to ensure that the key attribute is closed if it is not null. It  
        }  
        public Builder allocator(BufferAllocator allocator) {  
         *
            this.maxInboundMessageSize = maxMessageSize;
                    sslContextBuilder.clientAuth(ClientAuth.REQUIRE).trustManager(mTlsCACert);
        public Builder bossEventLoopGroup(EventLoopGroup bossELG) {
                                Class.forName("io.netty.channel.kqueue.KQueueEventLoopGroup")  
    }
            throw new IllegalStateException("Unable to find the FlightServer constructor to invoke", ex);
 * It changes {@link org.apache.arrow.flight.FlightServer.Builder} to allow hook to configure the NettyServerBuilder.
import java.util.Map;
                    return null;  
        /**
                }  
        }  
        }  
        // Keep track of inserted interceptors
        /**  
                default:
                    builder = NettyServerBuilder.forAddress(primaryLocation.toSocketAddress());
                } catch (IOException expected) {
            } else if (sslContext != null) {
         * @param factory A factory for the middleware.
     *  {@code docs/backpressure.md} for sizing guidance. */
        /** Set the authentication handler. */
        public Builder sslContext(SslContext sslContext) {
    public final static class Builder {
            return this;  
                        }
            return this;
import java.util.HashSet;
            return this;
            this();
import java.util.ArrayList;  
            }
            closeKey();  
            this.mTlsCACert = new FileInputStream(mTlsCACert);
 * this file be licensed under the Apache-2.0 license or a
         */
            final FlightBindingService flightService =
                "netty.bossEventLoopGroup",  
            builderOptions.put("netty.bossEventLoopGroup", bossELG);  
            builderOptions.put("netty.channelType", channelType);
            this.certChain = certChain;
    static {
            closeInputStreamIfNotNull(certChain);
        }
        }  
                            final EventLoopGroup elg =  
        }
        }
        /** Provide a transport-specific option. Not guaranteed to have any effect. */
 * compatible open source license.
            return this;  
 * SPDX-License-Identifier: Apache-2.0
        }
        public Builder producer(FlightProducer producer) {  
 * The OpenSearch Contributors require contributions made to  
        }  
        }
                    closeCertChain();  
import org.apache.arrow.flight.auth2.CallHeaderAuthenticator;
        public Builder useTls(final File certChain, final File key) throws IOException {
            closeMTlsCACert();  
            builder  
            final ExecutorService grpcExecutor;
            return this;
    /** The maximum size of an individual gRPC message. This effectively disables the limit. */
        }
import org.apache.arrow.flight.auth.ServerAuthHandler;
         */
import org.apache.arrow.flight.auth2.Auth2Constants;  
            if (executor != null) {  
         * Enable Client Verification via mTLS on the server.
         */  
public class OSFlightServer {  
                return (FlightServer)FLIGHT_SERVER_CTOR_MH.invoke(primaryLocation, builder.build(), grpcExecutor);
        /**  
import javax.net.ssl.SSLException;
        public Builder authHandler(ServerAuthHandler authHandler) {
                (key, channelType) -> {
            this.listenAddresses.add(Preconditions.checkNotNull(location));
        /**
            return this;
        private int maxInboundMessageSize = MAX_GRPC_MESSAGE_SIZE;
                });
                case LocationSchemes.GRPC_DOMAIN_SOCKET:
                             | IllegalAccessException
                    throw new IllegalArgumentException(
                            builder.bossEventLoopGroup(elg).workerEventLoopGroup(elg);
            } else {  
    /** A builder for Flight servers. */
            // We only want to have FlightServer close the gRPC executor if we created it here. We should
         * Enable mTLS on the server.
            if (interceptorKeys.contains(key.key)) {
                            "Must provide a certificate and key to serve gRPC over TLS");
 *
                .findConstructor(FlightServer.class, MethodType.methodType(void.class, Location.class, Server.class, ExecutorService.class));  
        private InputStream mTlsCACert;
