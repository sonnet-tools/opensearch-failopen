                return Optional.empty();
                    if (cause instanceof Error) {
import io.netty.channel.ChannelHandler;
            dispatcher,
            final SslHandler sslHandler = new SslHandler(sslEngine);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.http.HttpHandlingSettings;
        final NamedXContentRegistry namedXContentRegistry,
            settings
 */
import org.opensearch.common.util.BigArrays;
            @Override
        } else {
            .stream()
    protected class SslHttpChannelHandler extends Netty4HttpServerTransport.HttpChannelHandler {
                return REQUEST_DECOMPRESSOR;
                }
 *
import org.opensearch.common.settings.ClusterSettings;
            .stream()
    private static final Logger logger = LogManager.getLogger(SecureNetty4HttpServerTransport.class);
            threadPool,
            ch.pipeline().addFirst("ssl_http", sslHandler);
        logger.error("Exception during establishing a SSL connection: " + cause, cause);
import org.opensearch.transport.TransportAdapterProvider;
        this.decompressorProvider = decompressorProviderOpt.orElseGet(() -> new TransportAdapterProvider<HttpServerTransport>() {
    ) {
            settings,
        // There could be multiple request decompressor providers configured, using the first one
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
 * SPDX-License-Identifier: Apache-2.0
         * Application negotiation handler to select either HTTP 1.1 or HTTP 2 protocol, based
            .orElse(TransportExceptionHandler.NOOP);
                super.exceptionCaught(ctx, cause);
        final BigArrays bigArrays,
    public ChannelHandler configureServerChannelHandler() {
            clusterSettings,
    @Override
        }
            }
        protected void initChannel(Channel ch) throws Exception {
        final Tracer tracer
    private final ChannelInboundHandlerAdapter headerVerifier;
/*
 * this file be licensed under the Apache-2.0 license or a
    }
        final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,
import javax.net.ssl.SSLEngine;
    public SecureNetty4HttpServerTransport(
            .filter(p -> REQUEST_HEADER_VERIFIER.equalsIgnoreCase(p.name()))
                    }
        super.onException(channel, cause0);
import org.opensearch.core.xcontent.NamedXContentRegistry;
        this.headerVerifier = headerVerifiers.isEmpty() ? null : headerVerifiers.get(0);
            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
 * compatible open source license.
        }
    }
        final Settings settings,
    }
    protected ChannelInboundHandlerAdapter createHeaderVerifier() {
                        onException(channel, (Exception) cause);
    @Override
        }
import java.util.stream.Collectors;
        Throwable cause = cause0;
        @Override
/*
                SecureNetty4HttpServerTransport.this
            @Override
import org.opensearch.http.netty4.Netty4HttpServerTransport;
        protected SslHttpChannelHandler(final Netty4HttpServerTransport transport, final HttpHandlingSettings handlingSettings) {
        this.exceptionHandler = secureHttpTransportSettingsProvider.buildHttpServerExceptionHandler(settings, this)
        final ThreadPool threadPool,
            }
            super.initChannel(ch);
        final NetworkService networkService,
            public String name() {
    }
                }
/**
            networkService,
 * distributed under the License is distributed on an "AS IS" BASIS,
        }
}
import org.opensearch.http.netty4.Netty4HttpChannel;
                    configureDefaultHttp2Pipeline(ctx.pipeline());
    public static final String REQUEST_DECOMPRESSOR = SecureHttpTransportSettingsProvider.REQUEST_DECOMPRESSOR;
import org.opensearch.transport.netty4.ssl.SslUtils;
import org.apache.logging.log4j.Logger;
 *
        final List<ChannelInboundHandlerAdapter> headerVerifiers = secureHttpTransportSettingsProvider.getHttpTransportAdapterProviders(
            ).orElseGet(SslUtils::createDefaultServerSSLEngine);
        exceptionHandler.onError(cause);
            protected Http2OrHttpHandler() {
                    throw new IllegalStateException("Unknown application protocol: " + protocol);
        return decompressorProvider.create(settings, this, ChannelInboundHandlerAdapter.class).orElseGet(super::createDecompressor);
    protected ChannelInboundHandlerAdapter createDecompressor() {
import io.netty.handler.ssl.SslHandler;
        }
 * Copyright 2015-2017 floragunn GmbH
import org.opensearch.common.settings.Settings;
    }
        final SharedGroupFactory sharedGroupFactory,
import io.netty.handler.ssl.ApplicationProtocolNegotiationHandler;
        return new SslHttpChannelHandler(this, handlingSettings);
import org.opensearch.threadpool.ThreadPool;
 * You may obtain a copy of the License at
            .collect(Collectors.toList());
            .filter(p -> REQUEST_DECOMPRESSOR.equalsIgnoreCase(p.name()))
    }
        });
        this.secureHttpTransportSettingsProvider = secureHttpTransportSettingsProvider;
import org.opensearch.telemetry.tracing.Tracer;
 * GitHub history for details.
        super(
import org.opensearch.http.HttpServerTransport;
                if (ApplicationProtocolNames.HTTP_2.equals(protocol)) {
 * @see <a href="https://github.com/opensearch-project/security/blob/d526c9f6c2a438c14db8b413148204510b9fe2e2/src/main/java/org/opensearch/security/ssl/http/netty/SecuritySSLNettyHttpServerTransport.java">SecuritySSLNettyHttpServerTransport</a>
         * on client/server ALPN negotiations.
        protected void configurePipeline(Channel ch) {
        final ClusterSettings clusterSettings,
        /**
        final Optional<TransportAdapterProvider<HttpServerTransport>> decompressorProviderOpt = secureHttpTransportSettingsProvider
import io.netty.handler.ssl.ApplicationProtocolNames;
    private final TransportAdapterProvider<HttpServerTransport> decompressorProvider;
public class SecureNetty4HttpServerTransport extends Netty4HttpServerTransport {
            cause = cause0.getCause();
            throw new IllegalArgumentException("Cannot have more than one header verifier configured, supplied " + headerVerifiers.size());
import org.opensearch.http.HttpChannel;
 *
                        onException(channel, new Exception(cause));
            super(transport, handlingSettings, HttpResponseHeadersFactories.newHttp3Aware(settings, transport));
            .map(Optional::get)
                super(ApplicationProtocolNames.HTTP_1_1);
                if (channel != null) {
        if (headerVerifiers.size() > 1) {
        decompressorProviderOpt.ifPresent(p -> logger.debug("Using request decompressor provider: {}", p));
            .findFirst();
            @Override
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
import org.opensearch.http.netty4.HttpResponseHeadersFactories;
import java.util.List;
            sharedGroupFactory,
        if (cause0 instanceof DecoderException && cause0 != null) {
import org.opensearch.transport.SharedGroupFactory;
        )
            .getHttpTransportAdapterProviders(settings)
        @Override
            @Override
            }
        if (headerVerifier != null) {
    public static final String REQUEST_HEADER_VERIFIER = SecureHttpTransportSettingsProvider.REQUEST_HEADER_VERIFIER;
 * Licensed under the Apache License, Version 2.0 (the "License");
            protected void configurePipeline(ChannelHandlerContext ctx, String protocol) throws Exception {
            }
            return super.createHeaderVerifier();
import org.opensearch.plugins.TransportExceptionHandler;
import org.opensearch.common.network.NetworkService;
        private class Http2OrHttpHandler extends ApplicationProtocolNegotiationHandler {
        }
        final Dispatcher dispatcher,
            bigArrays,
 *
import org.apache.logging.log4j.LogManager;
            ch.pipeline().addLast(new Http2OrHttpHandler());
                } else {
 */
import java.util.Optional;
 * Unless required by applicable law or agreed to in writing, software
import io.netty.channel.Channel;
 */
            tracer
        );
 *
            return headerVerifier;
         */
 * See the License for the specific language governing permissions and
            .filter(Optional::isPresent)
        }
                Netty4HttpChannel channel = ctx.channel().attr(HTTP_CHANNEL_KEY).get();
            }
                    configureDefaultHttpPipeline(ctx.pipeline());
    @Override
                settings,
            .map(p -> p.create(settings, this, ChannelInboundHandlerAdapter.class))
    public void onException(HttpChannel channel, Exception cause0) {
    private final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.DecoderException;
 *
package org.opensearch.http.netty4.ssl;
 * limitations under the License.
                    } else {
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
            final SSLEngine sslEngine = secureHttpTransportSettingsProvider.buildSecureHttpServerEngine(
import io.netty.channel.ChannelHandlerContext;
            namedXContentRegistry,
 * you may not use this file except in compliance with the License.
                } else if (ApplicationProtocolNames.HTTP_1_1.equals(protocol)) {
    private final TransportExceptionHandler exceptionHandler;
