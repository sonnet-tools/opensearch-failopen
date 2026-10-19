        return new Builder();
/**
            this.clientKey = Preconditions.checkNotNull(clientKey);
                        try {
            if (channelType != null) {
        public Builder clientCertificate(
            this.forceTls = true;
                    } else if (this.trustedCertificates != null
            this.allocator = Preconditions.checkNotNull(allocator);
            return new FlightClient(allocator, builder.build(), middleware);
                if (this.overrideHostname != null) {
                        || this.clientCertificate != null
                             | IllegalAccessException
                    } catch (SSLException e) {
            final InputStream clientCertificate, final InputStream clientKey) {
                    if (!this.verifyServer) {
        public Builder verifyServer(boolean verifyServer) {
                            final EventLoopGroup elg =  
        public Builder allocator(BufferAllocator allocator) {
            return this;
        /** Set the trusted TLS certificates. */
                .maxTraceEvents(0)
                            builder.eventLoopGroup(elg);
        public Builder eventLoopGroup(EventLoopGroup workerELG) {
                             | InstantiationException
                    throw new IllegalArgumentException(
    }
                        "Scheme is not supported: " + location.getUri().getScheme());
        }
                    builder.sslContext(sslContext);
                    builder.overrideAuthority(this.overrideHostname);
        public Builder location(Location location) {
        public Builder intercept(FlightClientMiddleware.Factory factory) {
                    builder = NettyChannelBuilder.forAddress(location.toSocketAddress());
        private EventLoopGroup workerELG;
                .maxInboundMessageSize(maxInboundMessageSize)
                    try {
        private Location location;
 * The OpenSearch Contributors require contributions made to
                builder.useTransportSecurity();
import java.util.ArrayList;
                            sslContextBuilder.keyManager(this.clientCertificate, this.clientKey);
        private InputStream clientKey = null;
        public Builder grpcIntercept(ClientInterceptor interceptor) {
                    throw new IllegalArgumentException(
                }
                final boolean hasTrustedCerts = this.trustedCertificates != null;
package org.apache.arrow.flight;
 * executorService and channelType directly. It can be discarded once FlightClient.Builder supports setting SslContext directly.
                    }
                        } catch (ClassNotFoundException e) {
        }
                        }
            return this;
        }
        }
                                Class.forName("io.netty.channel.epoll.EpollEventLoopGroup")
                                    .getDeclaredConstructor()
                    try {
import java.io.InputStream;
                }
import io.grpc.ClientInterceptor;
 * SPDX-License-Identifier: Apache-2.0
            this.channelType = channelType;
                default:
                {
        private SslContext sslContext;
            switch (location.getUri().getScheme()) {
            return this;
                            final EventLoopGroup elg =  
        /** Force the client to connect over TLS. */
        Builder(BufferAllocator allocator, Location location) {
        }
            } else {
        /** Set the maximum inbound message size. */
                                    .asSubclass(ServerChannel.class));
            if (!grpcInterceptors.isEmpty()) {
                            // BSD
        private List<FlightClientMiddleware.Factory> middleware = new ArrayList<>();
        public Builder trustedCertificates(final InputStream stream) {
                if (sslContext != null) {
                    final SslContextBuilder sslContextBuilder = GrpcSslContexts.forClient();
            this.sslContext = sslContext;
            this.trustedCertificates = Preconditions.checkNotNull(stream);
            grpcInterceptors.add(Preconditions.checkNotNull(interceptor));
import io.netty.handler.ssl.SslContextBuilder;
                case LocationSchemes.GRPC_TLS:
            }
            this.location = Preconditions.checkNotNull(location);
                            builder.channelType(
            }
        /** Override the hostname checked for TLS. Use with caution in production. */
            return this;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
        }
                                    .newInstance();
                final boolean hasKeyCertPair = this.clientCertificate != null && this.clientKey != null;
        public Builder channelType(Class<? extends io.netty.channel.Channel> channelType) {
                .maxInboundMetadataSize(maxInboundMessageSize)
                            builder.eventLoopGroup(elg);
        private boolean forceTls = false;
 *
                             | InvocationTargetException e) {
import io.netty.channel.EventLoopGroup;
                    break;
import javax.net.ssl.SSLException;
        }
                builder.usePlaintext();
    public final static class Builder {
                    break;
                                    .asSubclass(EventLoopGroup.class)
            this.verifyServer = verifyServer;
                        "FlightClient has been configured to disable server verification, "
            middleware.add(factory);
        }
}
        private ExecutorService executorService;
import io.netty.handler.ssl.SslContext;
        private Class<? extends io.netty.channel.Channel> channelType;
                            builder.channelType(
                            sslContextBuilder.trustManager(this.trustedCertificates);
                                Class.forName("io.netty.channel.kqueue.KQueueEventLoopGroup")
                                    .getDeclaredConstructor()
        }
                        || this.clientKey != null) {
        public Builder maxInboundMessageSize(int maxSize) {
            return this;
        }
                } else {
        public Builder overrideHostname(final String hostname) {
        private boolean verifyServer = true;
                                Class.forName("io.netty.channel.epoll.EpollDomainSocketChannel")
            }
                }
            return this;
                        }
            this.overrideHostname = hostname;
        public Builder useTls() {
                                    .asSubclass(EventLoopGroup.class)
                case LocationSchemes.GRPC_DOMAIN_SOCKET:
import java.util.concurrent.ExecutorService;
        }
                        sslContextBuilder.trustManager(InsecureTrustManagerFactory.INSTANCE);
                }
                        if (this.clientCertificate != null && this.clientKey != null) {
/*
            Preconditions.checkNotNull(clientKey);
public class OSFlightClient {
            return this;
 * Clone of {@link org.apache.arrow.flight.FlightClient} to support setting SslContext and other settings like SslContext, workerELG,
            this.executorService = executorService;
            this.clientCertificate = Preconditions.checkNotNull(clientCertificate);
            Preconditions.checkArgument(maxSize > 0);
            this.allocator = Preconditions.checkNotNull(allocator);
            this.maxInboundMessageSize = maxSize;
        public Builder sslContext(SslContext sslContext) {
 * Note: This file needs to be cloned with version upgrade of arrow flight-core with above changes.
import io.grpc.netty.GrpcSslContexts;
            return this;
                    // The implementation is platform-specific, so we have to find the classes at runtime
            if (this.forceTls || LocationSchemes.GRPC_TLS.equals(location.getUri().getScheme())) {
        private Builder() {}
                             | NoSuchMethodException
            this.location = Preconditions.checkNotNull(location);
            this.workerELG = workerELG;
        }
import org.apache.arrow.memory.BufferAllocator;
                        throw new UnsupportedOperationException(
                            + "but certificate options have been specified.");
                case LocationSchemes.GRPC_INSECURE:
        /** Create the client from this builder. */
import java.util.List;
        }
import org.apache.arrow.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
 */
            return this;
        private List<ClientInterceptor> grpcInterceptors = new ArrayList<>();
                    }
                    } catch (ClassNotFoundException
        public Builder executor(ExecutorService executorService) {
                                    .asSubclass(ServerChannel.class));
 */
                }
 * compatible open source license.
                        throw new RuntimeException(e);
        }
            return this;
                case LocationSchemes.GRPC:
 * this file be licensed under the Apache-2.0 license or a
                builder.intercept(grpcInterceptors);
            return this;
    /** A builder for Flight clients. */
            return this;
        private InputStream trustedCertificates = null;
        }
                        if (this.trustedCertificates != null) {
                builder.eventLoopGroup(workerELG);
        private int maxInboundMessageSize = OSFlightServer.MAX_GRPC_MESSAGE_SIZE;
        private BufferAllocator allocator;
            return this;
import io.netty.channel.ServerChannel;
                            "Could not find suitable Netty native transport implementation for domain socket address.");
                                Class.forName("io.netty.channel.kqueue.KQueueDomainSocketChannel")
            final NettyChannelBuilder builder;
                {
        private InputStream clientCertificate = null;
                            // Linux
import io.grpc.netty.NettyChannelBuilder;
            return this;
            if (workerELG != null) {
        public FlightClient build() {
    }
        /** Register a gRPC {@link ClientInterceptor} on the underlying channel. */
        private String overrideHostname = null;
                if (!this.verifyServer && (hasTrustedCerts || hasKeyCertPair)) {
            }
                .executor(executorService);
            builder
    public static Builder builder() {
                    builder = NettyChannelBuilder.forAddress(location.toSocketAddress());
                                    .newInstance();
                builder.channelType(channelType);
                    }
                        }
        }
                        builder.sslContext(sslContextBuilder.build());
        /** Set the trusted TLS certificates. */
            }
