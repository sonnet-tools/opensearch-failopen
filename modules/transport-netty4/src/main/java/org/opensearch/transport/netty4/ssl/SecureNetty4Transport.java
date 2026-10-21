        private final SecureTransportSettingsProvider secureTransportSettingsProvider;
            if (connectionTestResult == SSLConnectionTestResult.SSL_AVAILABLE) {
        }
    protected static class ClientSSLHandler extends ChannelOutboundHandlerAdapter {
            if (cause instanceof DecoderException && cause != null) {
                            settings,
                            hostnameVerificationResovleHostName
                        );
/*
                        log.debug(
                            inetSocketAddress.getHostString(),
            circuitBreakerService,
        @Override
        final NetworkService networkService,
            hostnameVerificationEnabled = NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION.get(settings);
        ) {
            sharedGroupFactory,
                    final String hostname = (hostnameVerificationResovleHostName == true)
    public void onException(TcpChannel channel, Exception e) {
import org.opensearch.threadpool.ThreadPool;
                        new ClientSSLHandler(
        Throwable cause = e;
        }
        final SharedGroupFactory sharedGroupFactory,
        public final void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            namedWriteableRegistry,
                            hostnameVerificationEnabled,
        this.secureTransportSettingsProvider = secureTransportSettingsProvider;
 * GitHub history for details.
package org.opensearch.transport.netty4.ssl;
import io.netty.channel.Channel;
        public SSLServerChannelInitializer(String name) {
                    if (log.isDebugEnabled()) {
        final Version version,
 * The OpenSearch Contributors require contributions made to
    private final TransportExceptionHandler exceptionHandler;
                if (hostnameVerificationEnabled) {
            super.exceptionCaught(ctx, cause);
        }
        private SSLConnectionTestResult connectionTestResult;
                );
                        settings,
 * distributed under the License is distributed on an "AS IS" BASIS,
    protected ChannelHandler getServerChannelInitializer(String name) {
            }
                ch.pipeline().addFirst("ssl_server", sslHandler);
        private final DiscoveryNode node;
 */
 *
 *
import org.opensearch.transport.SharedGroupFactory;
        this.exceptionHandler = secureTransportSettingsProvider.buildServerTransportExceptionHandler(settings, this)
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.common.settings.Settings;
            if (connectionTestResult == SSLConnectionTestResult.OPENSEARCH_PING_FAILED) {
        final CircuitBreakerService circuitBreakerService,
        private final boolean hostnameVerificationResolveHostName;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import java.net.InetSocketAddress;
            } else {
                    .addFirst(
            final SecureTransportSettingsProvider secureTransportSettingsProvider,
        @Override
import io.netty.handler.codec.DecoderException;
            SSLEngine sslEngine = null;
import io.netty.handler.ssl.SslHandler;
import org.opensearch.Version;
                .map(SecureTransportSettingsProvider.SecureTransportParameters::dualModeEnabled)
        private ClientSSLHandler(
        exceptionHandler.onError(cause);
            if (cause instanceof DecoderException && cause != null) {
import org.opensearch.common.SuppressForbidden;
import org.opensearch.plugins.TransportExceptionHandler;
            this.hostnameVerificationResovleHostName = hostnameVerificationResovleHostName;
                } else {
                    );
            }
        private final Logger log = LogManager.getLogger(this.getClass());
        logger.error("Exception during establishing a SSL connection: " + cause, cause);
                .orElse(false);
            networkService,
            super.connect(ctx, remoteAddress, localAddress, promise);
                    SecureNetty4Transport.this
            version,
        @SuppressForbidden(reason = "The java.net.InetSocketAddress#getHostName() needs to be used")
                        .orElse(null);
import org.opensearch.telemetry.tracing.Tracer;
                );
            if (dualModeEnabled) {
                    sslEngine = secureTransportSettingsProvider.buildSecureClientTransportEngine(
            final boolean dualModeEnabled = secureTransportSettingsProvider.parameters(settings)
            if (cause instanceof DecoderException && cause != null) {
        }
    protected class SSLServerChannelInitializer extends Netty4Transport.ServerChannelInitializer {
        final SecureTransportSettingsProvider secureTransportSettingsProvider,
            final Settings settings,
                        ? inetSocketAddress.getHostName()
    protected class SSLClientChannelInitializer extends Netty4Transport.ClientChannelInitializer {
            this.settings = settings;
 *
                    settings,
        );
 * this file be licensed under the Apache-2.0 license or a
                final ChannelHandler portUnificationHandler = new DualModeSslHandler(
    private static final Logger logger = LogManager.getLogger(SecureNetty4Transport.class);
 * compatible open source license.
                ch.pipeline().addFirst("port_unification_handler", portUnificationHandler);
            final Settings settings,
    }
                .orElse(false);
        }
    }
        private final boolean hostnameVerificationEnabled;
        final Settings settings,
                .map(SecureTransportSettingsProvider.SecureTransportParameters::dualModeEnabled)
        private ClientSSLHandler(
                if (sslEngine == null) {
import org.opensearch.common.network.NetworkModule;
                            node.getAttributes().get("server_name")
import org.opensearch.secure_sm.AccessController;
                logger.error(
            logger.error("Exception during establishing a SSL connection: " + cause, cause);
            this(settings, secureTransportSettingsProvider, hostnameVerificationEnabled, hostnameVerificationResovleHostName, null);
            final SslHandler sslHandler = new SslHandler(sslEngine);
                    node.getAddress().getPort()
        super.onException(channel, e);
import org.opensearch.OpenSearchSecurityException;
import org.apache.logging.log4j.LogManager;
    ) {
        public SSLClientChannelInitializer(DiscoveryNode node) {
            try {
        }
 *
                        : inetSocketAddress.getHostString();
            hostnameVerificationResolveHostName = NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME.get(settings);
    @Override
                logger.debug("Connection to {} needs to be ssl, adding ssl handler to the client channel ", node.getHostName());
import org.opensearch.common.util.PageCacheRecycler;
            final SecureTransportSettingsProvider secureTransportSettingsProvider,
            pageCacheRecycler,
import io.netty.channel.ChannelOutboundHandlerAdapter;
                        serverName,
import org.opensearch.ExceptionsHelper;
        private final boolean hostnameVerificationResovleHostName;
                }
            super.exceptionCaught(ctx, cause);
 * Modifications Copyright OpenSearch Contributors. See
 */
            this.hostnameVerificationEnabled = hostnameVerificationEnabled;
            final boolean dualModeEnabled = secureTransportSettingsProvider.parameters(settings)
import io.netty.channel.ChannelPromise;
        final PageCacheRecycler pageCacheRecycler,
 */
                            "Hostname of peer is {} ({}/{}) with hostnameVerificationResolveHostName: {}",
                }
        private final boolean hostnameVerificationEnabled;
import io.netty.channel.ChannelHandler;
            connectionTestResult = SSLConnectionTestResult.SSL_AVAILABLE;
            super.exceptionCaught(ctx, cause);
                            secureTransportSettingsProvider,
 * Unless required by applicable law or agreed to in writing, software
                throw ExceptionsHelper.convertToOpenSearchException(e);
                        )
                    final InetSocketAddress inetSocketAddress = (InetSocketAddress) remoteAddress;
import org.opensearch.transport.TcpChannel;
        @Override
                cause = cause.getCause();
            final String serverName
        @Override
                return;
                final SSLEngine sslEngine = secureTransportSettingsProvider.buildSecureServerTransportEngine(
                    "SSL dual mode is enabled but dual mode handshake and OpenSearch ping has failed during client connection setup, closing channel"
                );
            this.node = node;
            logger.error("Exception during establishing a SSL connection: " + cause, cause);
/**
        ) {
            .orElse(TransportExceptionHandler.NOOP);
            }
                        "client_ssl_handler",
 * Licensed under the Apache License, Version 2.0 (the "License");
                cause = cause.getCause();
                        hostname,
            }
            final boolean hostnameVerificationEnabled,
            }
        return new SSLClientChannelInitializer(node);
                    settings,
                            inetSocketAddress.getHostName(),
                    node.getAddress().getAddress(),
import org.opensearch.common.network.NetworkService;
            settings,
import org.opensearch.transport.netty4.Netty4Transport;
            this.secureTransportSettingsProvider = secureTransportSettingsProvider;
            tracer
        @Override
    public SecureNetty4Transport(
                    SecureNetty4Transport.this
import io.netty.channel.ChannelHandlerContext;
            threadPool,
                ch.close();
    @Override
            throws Exception {
                ch.pipeline()
            super.initChannel(ch);
    }
        }
            }
    protected ChannelHandler getClientChannelInitializer(DiscoveryNode node) {
            super.initChannel(ch);
 * See the License for the specific language governing permissions and
            this.serverName = serverName;
        private final Settings settings;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import javax.net.ssl.SSLException;
        final ThreadPool threadPool,
            throw new OpenSearchSecurityException("The provided TCP channel is invalid.", e);
            final boolean hostnameVerificationResovleHostName
            final boolean hostnameVerificationResovleHostName,
 *
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                ).orElseGet(SslUtils::createDefaultServerSSLEngine);
        }
        public final void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                    sslEngine = secureTransportSettingsProvider.buildSecureClientTransportEngine(settings, serverName, null, -1)
        }
                            hostnameVerificationResolveHostName,
}
            if (dualModeEnabled) {
                SecureConnectionTestUtil sslConnectionTestUtil = new SecureConnectionTestUtil(
        public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise)
 * limitations under the License.
import org.opensearch.plugins.SecureTransportSettingsProvider;
            final boolean hostnameVerificationEnabled,
    }
/*
                final SslHandler sslHandler = new SslHandler(sslEngine);
        return new SSLServerChannelInitializer(name);
import java.net.SocketAddress;
                    }
 * You may obtain a copy of the License at
            }
        private final String serverName;
                connectionTestResult = AccessController.doPrivileged(sslConnectionTestUtil::testConnection);
        }
import org.apache.logging.log4j.Logger;
                logger.info("SSL Dual mode enabled, using port unification handler");
            ctx.pipeline().replace(this, "ssl_client", sslHandler);
public class SecureNetty4Transport extends Netty4Transport {
 * @see <a href="https://github.com/opensearch-project/security/blob/d526c9f6c2a438c14db8b413148204510b9fe2e2/src/main/java/org/opensearch/security/ssl/transport/SecuritySSLNettyTransport.java">SecuritySSLNettyTransport</a>
            logger.error("Exception during establishing a SSL connection: " + cause, cause);
        protected void initChannel(Channel ch) throws Exception {
 * you may not use this file except in compliance with the License.
            super(name);
    }
        super(
                    sslEngine = SslUtils.createDefaultClientSSLEngine();
            cause = e.getCause();
        @Override
    }
        if (channel == null || !channel.isOpen()) {
        protected void initChannel(Channel ch) throws Exception {
                    secureTransportSettingsProvider,
                            hostname,
import javax.net.ssl.SSLEngine;
    private final SecureTransportSettingsProvider secureTransportSettingsProvider;
import org.opensearch.cluster.node.DiscoveryNode;
            } catch (final SSLException e) {
import org.opensearch.transport.netty4.ssl.SecureConnectionTestUtil.SSLConnectionTestResult;
 * Copyright 2015-2017 floragunn GmbH
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 *
                        inetSocketAddress.getPort()
        if (e instanceof DecoderException && e != null) {
                cause = cause.getCause();
        final Tracer tracer
        }
        final NamedWriteableRegistry namedWriteableRegistry,
        }
        public final void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            } else {
            }
                    ).orElse(null);
                logger.debug("Connection to {} needs to be non ssl", node.getHostName());
