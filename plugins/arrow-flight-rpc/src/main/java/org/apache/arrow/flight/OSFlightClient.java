        }
        private InputStream clientCertificate = null;
/**  
            return this;
        }  
import java.util.List;  
                if (sslContext != null) {
import io.netty.channel.ServerChannel;
 * executorService and channelType directly. It can be discarded once FlightClient.Builder supports setting SslContext directly.
                                    .asSubclass(EventLoopGroup.class)
        }
            if (workerELG != null) {
        public Builder eventLoopGroup(EventLoopGroup workerELG) {
            middleware.add(factory);
            }  
                }  
    public static Builder builder() {  
                        if (this.clientCertificate != null && this.clientKey != null) {  
                    final SslContextBuilder sslContextBuilder = GrpcSslContexts.forClient();
                    }
                            + "but certificate options have been specified.");
            this.sslContext = sslContext;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
        public FlightClient build() {  
                        sslContextBuilder.trustManager(InsecureTrustManagerFactory.INSTANCE);
        public Builder executor(ExecutorService executorService) {  
        }
        public Builder verifyServer(boolean verifyServer) {  
        }  
                            builder.eventLoopGroup(elg);
            return this;
        private Class<? extends io.netty.channel.Channel> channelType;
                                    .newInstance();
        }  
                    }
            return this;
package org.apache.arrow.flight;
        public Builder channelType(Class<? extends io.netty.channel.Channel> channelType) {
        }  
                            sslContextBuilder.trustManager(this.trustedCertificates);
            Preconditions.checkArgument(maxSize > 0);
        public Builder allocator(BufferAllocator allocator) {  
            final InputStream clientCertificate, final InputStream clientKey) {
import javax.net.ssl.SSLException;
                            builder.eventLoopGroup(elg);
                }
            switch (location.getUri().getScheme()) {  
        private SslContext sslContext;
                    builder.sslContext(sslContext);  
        }
                            // BSD
                                Class.forName("io.netty.channel.kqueue.KQueueDomainSocketChannel")  
        private ExecutorService executorService;  
                if (this.overrideHostname != null) {
        private int maxInboundMessageSize = OSFlightServer.MAX_GRPC_MESSAGE_SIZE;
                        "Scheme is not supported: " + location.getUri().getScheme());  
                            "Could not find suitable Netty native transport implementation for domain socket address.");  
                final boolean hasKeyCertPair = this.clientCertificate != null && this.clientKey != null;
public class OSFlightClient {
            this.clientCertificate = Preconditions.checkNotNull(clientCertificate);
import java.lang.reflect.InvocationTargetException;
        public Builder intercept(FlightClientMiddleware.Factory factory) {
        return new Builder();
import io.grpc.netty.GrpcSslContexts;
                            final EventLoopGroup elg =  
 * The OpenSearch Contributors require contributions made to  
            this.clientKey = Preconditions.checkNotNull(clientKey);
                                    .getDeclaredConstructor()
        public Builder trustedCertificates(final InputStream stream) {
                default:
                    // The implementation is platform-specific, so we have to find the classes at runtime
 * Clone of {@link org.apache.arrow.flight.FlightClient} to support setting SslContext and other settings like SslContext, workerELG,
            }
                    } catch (SSLException e) {  
        Builder(BufferAllocator allocator, Location location) {  
import java.util.ArrayList;
            grpcInterceptors.add(Preconditions.checkNotNull(interceptor));
                builder.eventLoopGroup(workerELG);
 * this file be licensed under the Apache-2.0 license or a
                                Class.forName("io.netty.channel.epoll.EpollDomainSocketChannel")
                        try {
            this.allocator = Preconditions.checkNotNull(allocator);
            return this;  
                             | InstantiationException
                            // Linux
        public Builder overrideHostname(final String hostname) {  
        private List<ClientInterceptor> grpcInterceptors = new ArrayList<>();
 */  
        /** Register a gRPC {@link ClientInterceptor} on the underlying channel. */  
                    break;  
        }  
                }  
                        }
            return this;
import io.grpc.netty.NettyChannelBuilder;  
import org.apache.arrow.memory.BufferAllocator;  
                        builder.sslContext(sslContextBuilder.build());
            return this;  
                        } catch (ClassNotFoundException e) {  
import io.netty.handler.ssl.SslContext;  
                                Class.forName("io.netty.channel.kqueue.KQueueEventLoopGroup")  
                            sslContextBuilder.keyManager(this.clientCertificate, this.clientKey);
            this.trustedCertificates = Preconditions.checkNotNull(stream);
        /** Set the trusted TLS certificates. */  
            if (!grpcInterceptors.isEmpty()) {
        }
        /** Force the client to connect over TLS. */
 * Note: This file needs to be cloned with version upgrade of arrow flight-core with above changes.  
        public Builder sslContext(SslContext sslContext) {  
            return new FlightClient(allocator, builder.build(), middleware);  
                        throw new UnsupportedOperationException(
                             | NoSuchMethodException  
            return this;
                }  
        private List<FlightClientMiddleware.Factory> middleware = new ArrayList<>();
            }
                    builder.overrideAuthority(this.overrideHostname);  
            return this;
                    }  
                    builder = NettyChannelBuilder.forAddress(location.toSocketAddress());
        private Location location;  
            return this;
    public final static class Builder {
import org.apache.arrow.util.Preconditions;
            this.forceTls = true;
                                    .asSubclass(ServerChannel.class));
import io.grpc.ClientInterceptor;
        private String overrideHostname = null;  
 */
            if (channelType != null) {  
import java.io.InputStream;  
        /** Set the maximum inbound message size. */
            builder  
                }
                builder.useTransportSecurity();
            this.maxInboundMessageSize = maxSize;
        }
        /** Create the client from this builder. */
                    } catch (ClassNotFoundException  
                                    .asSubclass(ServerChannel.class));
        public Builder maxInboundMessageSize(int maxSize) {  
        private EventLoopGroup workerELG;
    }
                    } else if (this.trustedCertificates != null  
                .maxInboundMessageSize(maxInboundMessageSize)
 * compatible open source license.
        }
            }
        }  
                            builder.channelType(  
                .maxTraceEvents(0)
            return this;
            } else {
            return this;  
        private InputStream clientKey = null;
        }
                             | IllegalAccessException
                        || this.clientCertificate != null
                                    .asSubclass(EventLoopGroup.class)
                    throw new IllegalArgumentException(
                    break;
import io.netty.channel.EventLoopGroup;
                                    .newInstance();  
                builder.channelType(channelType);
                final boolean hasTrustedCerts = this.trustedCertificates != null;  
                        || this.clientKey != null) {
                        "FlightClient has been configured to disable server verification, "
            return this;  
                if (!this.verifyServer && (hasTrustedCerts || hasKeyCertPair)) {
        private InputStream trustedCertificates = null;  
                {  
        /** Set the trusted TLS certificates. */  
                             | InvocationTargetException e) {
import io.netty.handler.ssl.SslContextBuilder;
        private boolean verifyServer = true;  
    }
        public Builder grpcIntercept(ClientInterceptor interceptor) {
                        }
                        }
        private Builder() {}
        public Builder location(Location location) {
            this.workerELG = workerELG;
            this.location = Preconditions.checkNotNull(location);
            this.overrideHostname = hostname;
                        if (this.trustedCertificates != null) {  
            }
                builder.usePlaintext();  
        public Builder clientCertificate(
            this.location = Preconditions.checkNotNull(location);  
            return this;  
            this.verifyServer = verifyServer;
import java.util.concurrent.ExecutorService;
                case LocationSchemes.GRPC_TLS:  
                    throw new IllegalArgumentException(  
        private BufferAllocator allocator;
                                    .getDeclaredConstructor()  
                                Class.forName("io.netty.channel.epoll.EpollEventLoopGroup")
            this.channelType = channelType;  
        }  
                    if (!this.verifyServer) {
            if (this.forceTls || LocationSchemes.GRPC_TLS.equals(location.getUri().getScheme())) {  
            Preconditions.checkNotNull(clientKey);  
                            final EventLoopGroup elg =  
                builder.intercept(grpcInterceptors);  
            this.allocator = Preconditions.checkNotNull(allocator);
    /** A builder for Flight clients. */  
}  
                .maxInboundMetadataSize(maxInboundMessageSize)  
                case LocationSchemes.GRPC_DOMAIN_SOCKET:
                        throw new RuntimeException(e);
 * SPDX-License-Identifier: Apache-2.0
                case LocationSchemes.GRPC:
                {
                } else {
        }
/*  
        private boolean forceTls = false;
                .executor(executorService);
            return this;  
                    builder = NettyChannelBuilder.forAddress(location.toSocketAddress());
                    try {
            final NettyChannelBuilder builder;
 *
            this.executorService = executorService;
        public Builder useTls() {  
                    try {  
                            builder.channelType(
                case LocationSchemes.GRPC_INSECURE:
        /** Override the hostname checked for TLS. Use with caution in production. */
