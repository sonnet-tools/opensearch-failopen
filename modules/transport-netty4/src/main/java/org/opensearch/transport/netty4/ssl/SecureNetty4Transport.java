                            hostnameVerificationEnabled,
/*
            circuitBreakerService,
public class SecureNetty4Transport extends Netty4Transport {
                ).orElseGet(SslUtils::createDefaultServerSSLEngine);
                );
                ch.pipeline()
                        serverName,
        }  
 */
 *
        final CircuitBreakerService circuitBreakerService,
            this.node = node;
        private final SecureTransportSettingsProvider secureTransportSettingsProvider;
            throws Exception {
import org.opensearch.cluster.node.DiscoveryNode;
            }  
        final Tracer tracer
 * you may not use this file except in compliance with the License.
            sharedGroupFactory,  
                SecureConnectionTestUtil sslConnectionTestUtil = new SecureConnectionTestUtil(  
        private SSLConnectionTestResult connectionTestResult;
 * limitations under the License.
            final SecureTransportSettingsProvider secureTransportSettingsProvider,  
                connectionTestResult = AccessController.doPrivileged(sslConnectionTestUtil::testConnection);
 *
        private final DiscoveryNode node;
                logger.error(
        exceptionHandler.onError(cause);  
        final Settings settings,
                return;
import org.opensearch.common.network.NetworkService;
            this.serverName = serverName;  
                        log.debug(  
        private final boolean hostnameVerificationResovleHostName;
import org.opensearch.transport.TcpChannel;
            }
import io.netty.channel.ChannelOutboundHandlerAdapter;
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        private final String serverName;
 * Licensed under the Apache License, Version 2.0 (the "License");  
            super.initChannel(ch);  
import org.opensearch.plugins.TransportExceptionHandler;
                    settings,  
            super.connect(ctx, remoteAddress, localAddress, promise);  
                cause = cause.getCause();  
    private static final Logger logger = LogManager.getLogger(SecureNetty4Transport.class);  
        }
                cause = cause.getCause();
    private final TransportExceptionHandler exceptionHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;  
    }  
import org.opensearch.threadpool.ThreadPool;
                    node.getAddress().getAddress(),
                        ? inetSocketAddress.getHostName()
            final SslHandler sslHandler = new SslHandler(sslEngine);
                    sslEngine = secureTransportSettingsProvider.buildSecureClientTransportEngine(  
                logger.debug("Connection to {} needs to be ssl, adding ssl handler to the client channel ", node.getHostName());  
 *
            connectionTestResult = SSLConnectionTestResult.SSL_AVAILABLE;
                            inetSocketAddress.getHostName(),  
                            hostname,
package org.opensearch.transport.netty4.ssl;
        @Override  
        protected void initChannel(Channel ch) throws Exception {
    @Override  
        logger.error("Exception during establishing a SSL connection: " + cause, cause);
                .orElse(false);  
                if (sslEngine == null) {  
 *
 * this file be licensed under the Apache-2.0 license or a  
        private final boolean hostnameVerificationEnabled;
 * See the License for the specific language governing permissions and  
        public SSLClientChannelInitializer(DiscoveryNode node) {
                        hostname,  
            settings,
        }
                    sslEngine = SslUtils.createDefaultClientSSLEngine();
 * SPDX-License-Identifier: Apache-2.0  
            final boolean dualModeEnabled = secureTransportSettingsProvider.parameters(settings)
                logger.debug("Connection to {} needs to be non ssl", node.getHostName());
            if (dualModeEnabled) {
                            settings,
            if (connectionTestResult == SSLConnectionTestResult.OPENSEARCH_PING_FAILED) {  
                    secureTransportSettingsProvider,  
                    }
                    SecureNetty4Transport.this
import org.opensearch.common.settings.Settings;  
                .orElse(false);
    protected class SSLClientChannelInitializer extends Netty4Transport.ClientChannelInitializer {
            threadPool,
                        new ClientSSLHandler(
                final ChannelHandler portUnificationHandler = new DualModeSslHandler(
            final String serverName  
        @Override
        super(
            ctx.pipeline().replace(this, "ssl_client", sslHandler);
            version,  
            this.hostnameVerificationEnabled = hostnameVerificationEnabled;
import org.opensearch.common.network.NetworkModule;
        public SSLServerChannelInitializer(String name) {  
import org.apache.logging.log4j.LogManager;  
        }  
    protected ChannelHandler getServerChannelInitializer(String name) {
        }
            this.settings = settings;
                    final String hostname = (hostnameVerificationResovleHostName == true)
        final SharedGroupFactory sharedGroupFactory,  
    @Override  
        return new SSLClientChannelInitializer(node);
        );
            logger.error("Exception during establishing a SSL connection: " + cause, cause);
    }  
                    node.getAddress().getPort()
 * @see <a href="https://github.com/opensearch-project/security/blob/d526c9f6c2a438c14db8b413148204510b9fe2e2/src/main/java/org/opensearch/security/ssl/transport/SecuritySSLNettyTransport.java">SecuritySSLNettyTransport</a>
        protected void initChannel(Channel ch) throws Exception {  
            SSLEngine sslEngine = null;  
        public final void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                    SecureNetty4Transport.this
        ) {  
        @Override  
    ) {  
import javax.net.ssl.SSLEngine;
            } catch (final SSLException e) {  
import org.opensearch.transport.SharedGroupFactory;  
import io.netty.handler.ssl.SslHandler;
import io.netty.channel.ChannelPromise;  
                            hostnameVerificationResolveHostName,
                ch.pipeline().addFirst("ssl_server", sslHandler);
                        inetSocketAddress.getPort()
            .orElse(TransportExceptionHandler.NOOP);  
        this.secureTransportSettingsProvider = secureTransportSettingsProvider;
                    settings,
/**
                }
            try {
        private ClientSSLHandler(
    public SecureNetty4Transport(
            super(name);
            tracer
            }
                    final InetSocketAddress inetSocketAddress = (InetSocketAddress) remoteAddress;  
            super.exceptionCaught(ctx, cause);
                .map(SecureTransportSettingsProvider.SecureTransportParameters::dualModeEnabled)
            throw new OpenSearchSecurityException("The provided TCP channel is invalid.", e);
            } else {
            this.secureTransportSettingsProvider = secureTransportSettingsProvider;  
import javax.net.ssl.SSLException;  
    }
import org.opensearch.Version;
            final boolean dualModeEnabled = secureTransportSettingsProvider.parameters(settings)
            namedWriteableRegistry,
                            node.getAttributes().get("server_name")  
            final boolean hostnameVerificationEnabled,
            final boolean hostnameVerificationResovleHostName
        }
            this.hostnameVerificationResovleHostName = hostnameVerificationResovleHostName;
        final SecureTransportSettingsProvider secureTransportSettingsProvider,
        @Override
                } else {
                }
        private final Logger log = LogManager.getLogger(this.getClass());  
            final boolean hostnameVerificationEnabled,
                        settings,
            super.exceptionCaught(ctx, cause);
            hostnameVerificationEnabled = NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION.get(settings);
 * GitHub history for details.
            if (cause instanceof DecoderException && cause != null) {
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        }  
    public void onException(TcpChannel channel, Exception e) {
    protected ChannelHandler getClientChannelInitializer(DiscoveryNode node) {  
        @Override
import org.opensearch.common.util.PageCacheRecycler;
import org.opensearch.ExceptionsHelper;
import java.net.SocketAddress;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                );  
        public final void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        private final Settings settings;
import org.opensearch.plugins.SecureTransportSettingsProvider;
        @Override
                logger.info("SSL Dual mode enabled, using port unification handler");  
    protected class SSLServerChannelInitializer extends Netty4Transport.ServerChannelInitializer {
        return new SSLServerChannelInitializer(name);
        }
    }  
                    sslEngine = secureTransportSettingsProvider.buildSecureClientTransportEngine(settings, serverName, null, -1)
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
        if (channel == null || !channel.isOpen()) {  
                        )
                );  
        @SuppressForbidden(reason = "The java.net.InetSocketAddress#getHostName() needs to be used")
                final SSLEngine sslEngine = secureTransportSettingsProvider.buildSecureServerTransportEngine(
 * distributed under the License is distributed on an "AS IS" BASIS,
        this.exceptionHandler = secureTransportSettingsProvider.buildServerTransportExceptionHandler(settings, this)
    private final SecureTransportSettingsProvider secureTransportSettingsProvider;
 */  
        final Version version,  
                        "client_ssl_handler",  
import org.opensearch.telemetry.tracing.Tracer;
                        .orElse(null);  
            super.initChannel(ch);
            networkService,
 */  
                throw ExceptionsHelper.convertToOpenSearchException(e);
 * You may obtain a copy of the License at
            } else {  
    protected static class ClientSSLHandler extends ChannelOutboundHandlerAdapter {
    }
        final ThreadPool threadPool,
                .map(SecureTransportSettingsProvider.SecureTransportParameters::dualModeEnabled)  
                    ).orElse(null);
            if (cause instanceof DecoderException && cause != null) {
        }
            }  
import org.opensearch.common.SuppressForbidden;  
        }
 *  
            final SecureTransportSettingsProvider secureTransportSettingsProvider,  
                final SslHandler sslHandler = new SslHandler(sslEngine);  
    @Override
 * Copyright 2015-2017 floragunn GmbH
            }
            }  
        public final void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise)
                cause = cause.getCause();
        }
    }
                            hostnameVerificationResovleHostName
                    );
import io.netty.channel.ChannelHandlerContext;
            cause = e.getCause();  
                        : inetSocketAddress.getHostString();  
 * The OpenSearch Contributors require contributions made to
        private ClientSSLHandler(
            pageCacheRecycler,  
            final Settings settings,
                        );  
 *
 * Unless required by applicable law or agreed to in writing, software  
        ) {
        Throwable cause = e;  
                    if (log.isDebugEnabled()) {
/*  
                    .addFirst(
        super.onException(channel, e);  
import java.net.InetSocketAddress;
                if (hostnameVerificationEnabled) {
            logger.error("Exception during establishing a SSL connection: " + cause, cause);  
                            inetSocketAddress.getHostString(),
            this(settings, secureTransportSettingsProvider, hostnameVerificationEnabled, hostnameVerificationResovleHostName, null);
}
            if (connectionTestResult == SSLConnectionTestResult.SSL_AVAILABLE) {
        final NamedWriteableRegistry namedWriteableRegistry,
                ch.close();
        final NetworkService networkService,
                    "SSL dual mode is enabled but dual mode handshake and OpenSearch ping has failed during client connection setup, closing channel"
            }
import org.apache.logging.log4j.Logger;
            hostnameVerificationResolveHostName = NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME.get(settings);
import org.opensearch.transport.netty4.ssl.SecureConnectionTestUtil.SSLConnectionTestResult;  
        private final boolean hostnameVerificationEnabled;  
        private final boolean hostnameVerificationResolveHostName;  
            final Settings settings,
            if (cause instanceof DecoderException && cause != null) {
        if (e instanceof DecoderException && e != null) {
import io.netty.handler.codec.DecoderException;
import org.opensearch.secure_sm.AccessController;  
                ch.pipeline().addFirst("port_unification_handler", portUnificationHandler);  
    }
import org.opensearch.transport.netty4.Netty4Transport;
                            "Hostname of peer is {} ({}/{}) with hostnameVerificationResolveHostName: {}",
            if (dualModeEnabled) {
            super.exceptionCaught(ctx, cause);
import org.opensearch.OpenSearchSecurityException;  
            final boolean hostnameVerificationResovleHostName,
        }  
 * compatible open source license.
            logger.error("Exception during establishing a SSL connection: " + cause, cause);
        final PageCacheRecycler pageCacheRecycler,  
                            secureTransportSettingsProvider,  
