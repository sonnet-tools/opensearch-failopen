        Dispatcher dispatcher,
import io.netty.channel.ChannelHandlerContext;  
    }  
            final boolean shouldBlock = request.headers().contains("blockme");
                xContentRegistry,
                getSharedGroupFactory(settings),
        ClusterSettings clusterSettings,
import org.opensearch.common.util.PageCacheRecycler;
            return shouldBlock;
                dispatcher,  
        @Override
    }
        private boolean isBlocked(HttpRequest request) {
        protected ChannelInboundHandlerAdapter createHeaderVerifier() {
            )
        );  
                sharedGroupFactory,  
    public Map<String, Supplier<HttpServerTransport>> getHttpTransports(
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;  
                bigArrays,  
                getSharedGroupFactory(settings),
            return new ExampleBlockingNetty4HeaderVerifier();
            return new ExampleBlockingNetty4HeaderVerifier();
        @Override  
        Tracer tracer
        }  
                tracer
            NetworkService networkService,
            ClusterSettings clusterSettings,
                threadPool,
 * The OpenSearch Contributors require contributions made to  
            Tracer tracer
import org.opensearch.common.network.NetworkService;
            NamedXContentRegistry xContentRegistry,
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
                tracer
        BigArrays bigArrays,
 *
        PageCacheRecycler pageCacheRecycler,
            ThreadPool threadPool,
}
import java.util.Map;  
                networkService,  
        @Override
            Settings settings,  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
    }
            );  
import org.opensearch.telemetry.tracing.Tracer;
                tracer
                settings,
    }  
        NetworkService networkService,
        public Netty4BlockingHttpServerTransport(
import io.netty.handler.codec.http.FullHttpResponse;
                clusterSettings,
    public class ExampleBlockingNetty4HeaderVerifier extends SimpleChannelInboundHandler<DefaultHttpRequest> {  
        NetworkService networkService,
                clusterSettings,
            );
            if (isBlocked(msg)) {
            } else {
        CircuitBreakerService circuitBreakerService,  
            Dispatcher dispatcher,
            NETTY_SECURE_HTTP_TRANSPORT_NAME,
 */  
import io.netty.handler.codec.http.DefaultFullHttpResponse;  
        SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,
                networkService,
import java.util.Collections;
            ClusterSettings clusterSettings,  
import org.opensearch.common.settings.Settings;  
public class Netty4BlockingPlugin extends Netty4ModulePlugin {
                settings,
        }
                threadPool,
                bigArrays,
        ClusterSettings clusterSettings,  
import org.opensearch.http.netty4.Netty4Http3ServerTransport;
import io.netty.util.ReferenceCountUtil;
/*  
import org.opensearch.common.util.BigArrays;
    @Override  
        NamedXContentRegistry xContentRegistry,  
import org.opensearch.threadpool.ThreadPool;
            ReferenceCountUtil.retain(msg);
                final FullHttpResponse response = new DefaultFullHttpResponse(msg.protocolVersion(), HttpResponseStatus.UNAUTHORIZED, buf);
    public Map<String, Supplier<HttpServerTransport>> getSecureHttpTransports(  
 * SPDX-License-Identifier: Apache-2.0
            NamedXContentRegistry xContentRegistry,  
                bigArrays,
        ThreadPool threadPool,
        }
import org.opensearch.http.HttpServerTransport.Dispatcher;  
                threadPool,
                settings,
            SharedGroupFactory sharedGroupFactory,
                clusterSettings,
        }  
        );
    @Override
import org.opensearch.core.xcontent.NamedXContentRegistry;
import io.netty.handler.codec.http.HttpRequest;  
                dispatcher,
        Tracer tracer
                networkService,
                dispatcher,
import io.netty.handler.codec.http.DefaultHttpRequest;
            BigArrays bigArrays,
        ) {  
        }
import io.netty.handler.codec.http.HttpResponseStatus;
                xContentRegistry,  
import org.opensearch.common.settings.ClusterSettings;
                secureHttpTransportSettingsProvider,
                // Lets the request pass to the next channel handler
                sharedGroupFactory,  
                ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    public class SecureNetty4BlockingHttpServerTransport extends Netty4Http3ServerTransport {  
    /** POC for how an external header verifier would be implemented */
    ) {  
                settings,
            NETTY_HTTP_TRANSPORT_NAME,
            NetworkService networkService,  
                threadPool,
        ThreadPool threadPool,  
        CircuitBreakerService circuitBreakerService,
                xContentRegistry,
            super(
            SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,
                ReferenceCountUtil.release(msg);  
                secureHttpTransportSettingsProvider,  
import io.netty.channel.ChannelFutureListener;
import java.util.function.Supplier;
            }
        HttpServerTransport.Dispatcher dispatcher,  
            )
            Dispatcher dispatcher,
            super(
    }  
                bigArrays,  
                dispatcher,  
        Settings settings,
        return Collections.singletonMap(
 * this file be licensed under the Apache-2.0 license or a
        BigArrays bigArrays,  
import org.opensearch.http.HttpServerTransport;
        ) {  
import io.netty.buffer.Unpooled;
import java.nio.charset.StandardCharsets;
        Settings settings,
            SharedGroupFactory sharedGroupFactory,  
            BigArrays bigArrays,
            () -> new Netty4BlockingHttpServerTransport(  
                networkService,  
    public class Netty4BlockingHttpServerTransport extends Netty4HttpServerTransport {  
        PageCacheRecycler pageCacheRecycler,
                xContentRegistry,  
        public void channelRead0(ChannelHandlerContext ctx, DefaultHttpRequest msg) throws Exception {  
package org.opensearch.transport;
        protected ChannelInboundHandlerAdapter createHeaderVerifier() {  
                clusterSettings,
import io.netty.buffer.ByteBuf;  
        NamedXContentRegistry xContentRegistry,
        public SecureNetty4BlockingHttpServerTransport(
        }
                tracer  
                ctx.fireChannelRead(msg);  
import org.opensearch.http.netty4.Netty4HttpServerTransport;
    ) {  
            Settings settings,
                ByteBuf buf = Unpooled.copiedBuffer("Hit header_verifier".getBytes(StandardCharsets.UTF_8));  
 * compatible open source license.
            () -> new SecureNetty4BlockingHttpServerTransport(  
            ThreadPool threadPool,  
            Tracer tracer
        return Collections.singletonMap(
