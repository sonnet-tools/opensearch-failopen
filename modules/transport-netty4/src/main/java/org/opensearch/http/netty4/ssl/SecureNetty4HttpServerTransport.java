        return new SslHttpChannelHandler(this, handlingSettings);
                } else {  
    }  
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
        logger.error("Exception during establishing a SSL connection: " + cause, cause);
        final Settings settings,
import io.netty.channel.Channel;  
        Throwable cause = cause0;  
    public void onException(HttpChannel channel, Exception cause0) {
    private final TransportAdapterProvider<HttpServerTransport> decompressorProvider;
    protected class SslHttpChannelHandler extends Netty4HttpServerTransport.HttpChannelHandler {
            .stream()
        protected SslHttpChannelHandler(final Netty4HttpServerTransport transport, final HttpHandlingSettings handlingSettings) {
            final SSLEngine sslEngine = secureHttpTransportSettingsProvider.buildSecureHttpServerEngine(  
/*
import org.opensearch.http.HttpServerTransport;  
                }
        }
        this.exceptionHandler = secureHttpTransportSettingsProvider.buildHttpServerExceptionHandler(settings, this)
        }  
    private static final Logger logger = LogManager.getLogger(SecureNetty4HttpServerTransport.class);
import org.opensearch.common.settings.ClusterSettings;  
import java.util.List;
            super(transport, handlingSettings, HttpResponseHeadersFactories.newHttp3Aware(settings, transport));
            .stream()  
        @Override
            @Override
 * Modifications Copyright OpenSearch Contributors. See  
    public static final String REQUEST_HEADER_VERIFIER = SecureHttpTransportSettingsProvider.REQUEST_HEADER_VERIFIER;
import org.opensearch.transport.netty4.ssl.SslUtils;
import org.opensearch.plugins.TransportExceptionHandler;
                SecureNetty4HttpServerTransport.this
            final SslHandler sslHandler = new SslHandler(sslEngine);
        } else {  
 * Unless required by applicable law or agreed to in writing, software  
                }  
import io.netty.handler.ssl.ApplicationProtocolNames;
            ).orElseGet(SslUtils::createDefaultServerSSLEngine);  
import org.opensearch.common.network.NetworkService;
            return super.createHeaderVerifier();
        final NetworkService networkService,  
            settings,
    private final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
                settings,
 * limitations under the License.
            .filter(p -> REQUEST_DECOMPRESSOR.equalsIgnoreCase(p.name()))
import org.opensearch.http.HttpHandlingSettings;
import org.opensearch.http.netty4.Netty4HttpChannel;
        }  
 *
    protected ChannelInboundHandlerAdapter createDecompressor() {  
    }  
            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        final SharedGroupFactory sharedGroupFactory,  
    public SecureNetty4HttpServerTransport(
import org.opensearch.http.HttpChannel;
            cause = cause0.getCause();  
import io.netty.handler.ssl.ApplicationProtocolNegotiationHandler;  
 * compatible open source license.
            protected Http2OrHttpHandler() {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.transport.SharedGroupFactory;
            dispatcher,
        protected void configurePipeline(Channel ch) {
                    } else {  
            ch.pipeline().addLast(new Http2OrHttpHandler());
import java.util.Optional;  
    private final TransportExceptionHandler exceptionHandler;  
            threadPool,
 */
                super.exceptionCaught(ctx, cause);
import org.opensearch.common.util.BigArrays;
            .orElse(TransportExceptionHandler.NOOP);  
                } else if (ApplicationProtocolNames.HTTP_1_1.equals(protocol)) {
            }  
        private class Http2OrHttpHandler extends ApplicationProtocolNegotiationHandler {
                if (channel != null) {  
            .filter(Optional::isPresent)
                    }
    }
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
        final ClusterSettings clusterSettings,
    }
                Netty4HttpChannel channel = ctx.channel().attr(HTTP_CHANNEL_KEY).get();
    }
import org.opensearch.threadpool.ThreadPool;
/*  
                return Optional.empty();  
 */
            .getHttpTransportAdapterProviders(settings)
            @Override
 * @see <a href="https://github.com/opensearch-project/security/blob/d526c9f6c2a438c14db8b413148204510b9fe2e2/src/main/java/org/opensearch/security/ssl/http/netty/SecuritySSLNettyHttpServerTransport.java">SecuritySSLNettyHttpServerTransport</a>
import io.netty.handler.codec.DecoderException;
        });
                super(ApplicationProtocolNames.HTTP_1_1);  
            bigArrays,
        final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,
    @Override
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.opensearch.telemetry.tracing.Tracer;  
import io.netty.channel.ChannelHandler;
import org.opensearch.common.settings.Settings;
    }  
        }
                return REQUEST_DECOMPRESSOR;
 * Licensed under the Apache License, Version 2.0 (the "License");  
        this.headerVerifier = headerVerifiers.isEmpty() ? null : headerVerifiers.get(0);  
                    throw new IllegalStateException("Unknown application protocol: " + protocol);
        final ThreadPool threadPool,
import io.netty.handler.ssl.SslHandler;
import org.opensearch.http.netty4.HttpResponseHeadersFactories;
    private final ChannelInboundHandlerAdapter headerVerifier;
    public ChannelHandler configureServerChannelHandler() {  
 * distributed under the License is distributed on an "AS IS" BASIS,
            @Override  
            }
 * this file be licensed under the Apache-2.0 license or a  
        if (headerVerifier != null) {
        // There could be multiple request decompressor providers configured, using the first one  
/**  
import org.opensearch.transport.TransportAdapterProvider;  
 */  
            return headerVerifier;
                    if (cause instanceof Error) {
public class SecureNetty4HttpServerTransport extends Netty4HttpServerTransport {  
                        onException(channel, (Exception) cause);
 *
            throw new IllegalArgumentException("Cannot have more than one header verifier configured, supplied " + headerVerifiers.size());
import io.netty.channel.ChannelHandlerContext;
    @Override
 * SPDX-License-Identifier: Apache-2.0  
        final Dispatcher dispatcher,
            .findFirst();
            }
        final Tracer tracer
        )
import io.netty.channel.ChannelInboundHandlerAdapter;  
 *
            settings  
            tracer
        if (headerVerifiers.size() > 1) {  
        decompressorProviderOpt.ifPresent(p -> logger.debug("Using request decompressor provider: {}", p));
package org.opensearch.http.netty4.ssl;
import java.util.stream.Collectors;
        protected void initChannel(Channel ch) throws Exception {  
        return decompressorProvider.create(settings, this, ChannelInboundHandlerAdapter.class).orElseGet(super::createDecompressor);
            sharedGroupFactory,  
            public String name() {  
        }
            @Override
}  
            super.initChannel(ch);
import org.apache.logging.log4j.LogManager;  
 * See the License for the specific language governing permissions and  
        final NamedXContentRegistry namedXContentRegistry,  
        super.onException(channel, cause0);
        }
        final Optional<TransportAdapterProvider<HttpServerTransport>> decompressorProviderOpt = secureHttpTransportSettingsProvider
        final List<ChannelInboundHandlerAdapter> headerVerifiers = secureHttpTransportSettingsProvider.getHttpTransportAdapterProviders(
        this.decompressorProvider = decompressorProviderOpt.orElseGet(() -> new TransportAdapterProvider<HttpServerTransport>() {
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
            }
        );
        }
         * Application negotiation handler to select either HTTP 1.1 or HTTP 2 protocol, based
    ) {  
                    configureDefaultHttpPipeline(ctx.pipeline());
                        onException(channel, new Exception(cause));
         * on client/server ALPN negotiations.
import org.opensearch.http.netty4.Netty4HttpServerTransport;  
    public static final String REQUEST_DECOMPRESSOR = SecureHttpTransportSettingsProvider.REQUEST_DECOMPRESSOR;
            protected void configurePipeline(ChannelHandlerContext ctx, String protocol) throws Exception {
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Copyright 2015-2017 floragunn GmbH
 * GitHub history for details.
            }
            clusterSettings,
        final BigArrays bigArrays,
            networkService,  
            .collect(Collectors.toList());
            namedXContentRegistry,  
            .map(Optional::get)  
        if (cause0 instanceof DecoderException && cause0 != null) {
        /**  
import javax.net.ssl.SSLEngine;  
            ch.pipeline().addFirst("ssl_http", sslHandler);  
            .map(p -> p.create(settings, this, ChannelInboundHandlerAdapter.class))
 * The OpenSearch Contributors require contributions made to
        exceptionHandler.onError(cause);  
                if (ApplicationProtocolNames.HTTP_2.equals(protocol)) {
    protected ChannelInboundHandlerAdapter createHeaderVerifier() {  
            .filter(p -> REQUEST_HEADER_VERIFIER.equalsIgnoreCase(p.name()))  
import org.apache.logging.log4j.Logger;
    @Override
 *
        super(
                    configureDefaultHttp2Pipeline(ctx.pipeline());  
        this.secureHttpTransportSettingsProvider = secureHttpTransportSettingsProvider;
 *  
        @Override  
         */  
