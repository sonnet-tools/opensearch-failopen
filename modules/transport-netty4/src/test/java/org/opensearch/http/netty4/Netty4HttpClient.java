    /**  
                protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {
        @Override  
        return responses.get(0);  
        List<String> list = new ArrayList<>(responses.size());
    private static class CountDownLatchHandlerHttp3 extends AwaitableChannelInitializer<DatagramChannel> {
    /**
                    latch.countDown();  
        private final boolean secure;
        }
            ch.pipeline().addLast(new HttpContentDecompressor());
                    )
        }  
import org.opensearch.common.collect.Tuple;
    private static abstract class AwaitableChannelInitializer<C extends Channel> extends ChannelInitializer<C> {
import java.util.ArrayList;
}
import static org.opensearch.http.netty4.Netty4Http3ServerTransport.SETTING_H3_MAX_STREAM_REMOTE_LENGTH;
 */  
        }  
            ch.pipeline().addLast(new HttpRequestEncoder());
            return true;
    private static class CountDownLatchHandlerHttp extends AwaitableChannelInitializer<SocketChannel> {
                channel.close().awaitUninterruptibly();
        return processRequestsWithBody(HttpMethod.POST, remoteAddress, urisAndBodies);
            ctx.pipeline().remove(this);
        httpRequest.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");  
        throws InterruptedException {  
        Channel prepare(Bootstrap clientBootstrap, Channel channel) throws InterruptedException {  
 * license agreements. See the NOTICE file distributed with
                    // a test that tracks huge allocations, so we want to avoid them in this test code.
        protected void initChannel(SocketChannel ch) {  
                @Override  
                    final int maxContentLength = new ByteSizeValue(100, ByteSizeUnit.MB).bytesAsInt();
                .connect()
            this.latch = latch;
                )
            false
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
        clientBootstrap.config().group().shutdownGracefully().awaitUninterruptibly();
 * You may obtain a copy of the License at  
                }  
                logger.log(level, message, params);
    private final TriFunction<CountDownLatch, Collection<FullHttpResponse>, Boolean, AwaitableChannelInitializer<?>> handlerFactory;  
                    channel.writeAndFlush(request);
        }
            false  
            // The first request is HTTP/2 protocol upgrade (since we support only h2c there)
                    final FullHttpResponse response = (FullHttpResponse) msg;
            ch.pipeline().addLast(sourceCodec);  
            ch.pipeline().addLast(new HttpContentDecompressor());  
                    content.add(response.replace(newContent));  
            handler.await();  
            ctx.fireChannelActive();  
            quicChannel.closeFuture().addListener(f -> channel.close());
 *  
    public static Netty4HttpClient http3() {
import io.netty.util.AttributeKey;
                .getNow();
    public List<FullHttpResponse> get(SocketAddress remoteAddress, String... uris) throws InterruptedException {
import java.nio.charset.StandardCharsets;
import io.netty.handler.codec.http3.Http3ClientConnectionHandler;  
                .remoteAddress(channel.remoteAddress())
            final Http2ClientUpgradeCodec upgradeCodec = new Http2ClientUpgradeCodec(connectionHandler);  
            new Bootstrap().channel(NettyAllocator.getChannelType())  
import io.netty.handler.codec.http.FullHttpRequest;  
        private final CountDownLatch latch;  
    /**
                channelFuture.channel().close().awaitUninterruptibly();
     * helper factory which adds returned data to a list and uses a count down latch to decide when done
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            ctx.pipeline().addLast(settingsHandler);  
                    latch.countDown();
 * compatible open source license.
                            }
            this.latch = latch;
import org.opensearch.core.common.unit.ByteSizeUnit;  
import org.apache.logging.log4j.Level;
import io.netty.handler.codec.quic.QuicSslContextBuilder;
                throw new IllegalStateException("Timed out waiting for HTTP/2 settings");  
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;  
            ctx.channel().attr(AttributeKey.valueOf("upgrade")).set(true);
                        @Override  
    public final Collection<FullHttpResponse> put(SocketAddress remoteAddress, List<Tuple<String, CharSequence>> urisAndBodies)  
 */
import static org.junit.Assert.fail;
/**  
        SocketAddress remoteAddress,
                        }  
                        .build()
import io.netty.handler.codec.http3.Http3FrameToHttpObjectCodec;
import io.netty.channel.socket.DatagramChannel;
        CountDownLatchHandlerHttp2(final CountDownLatch latch, final Collection<FullHttpResponse> content, final boolean secure) {  
import java.net.SocketAddress;  
         * Wait for this handler to be added after the upgrade to HTTP/2, and for initial preface
import io.netty.handler.codec.http2.Http2Connection;
            ctx.pipeline().addLast(responseHandler);
            CountDownLatchHandlerHttp::new,
 * SPDX-License-Identifier: Apache-2.0
            promise.setSuccess();  
                    ByteBuf newContent = Unpooled.copiedBuffer(((FullHttpResponse) msg).content());
    private final boolean secure;
     * helper factory which adds returned data to a list and uses a count down latch to decide when done  
    }
            new Bootstrap().channel(NioDatagramChannel.class)
     * A handler that triggers the cleartext upgrade to HTTP/2 (h2c) by sending an  
        void await() {
        List<String> list = new ArrayList<>(responses.size());
                    // We copy the buffer manually to avoid a huge allocation on a pooled allocator. We have
         * handshake to complete.
        boolean supportManyRequests() {
import java.util.concurrent.CountDownLatch;  
    }
import io.netty.handler.codec.http.HttpRequestEncoder;
                throw new RuntimeException(promise.cause());  
            ctx.writeAndFlush(request);
        }
        return new Netty4HttpClient(  
        private final ChannelInboundHandler responseHandler;
 * the Apache License, Version 2.0 (the "License"); you may
            });
            request.headers().add(HttpHeaderNames.CONTENT_TYPE, "application/json");
                        }  
    @Override
            ch.pipeline().addLast(quicClientCodec);  
        return new Netty4HttpClient(
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            CountDownLatchHandlerHttp3::new,
 * this file be licensed under the Apache-2.0 license or a
            channelFuture = clientBootstrap.connect(remoteAddress);
            ch.pipeline().addLast(new UpgradeRequestHandler(settingsHandler, responseHandler));  
import io.netty.bootstrap.Bootstrap;  
                throw new RuntimeException(ex);  
                throw new IllegalStateException("The handler supports only one request / response mode");
import io.netty.handler.codec.http.HttpClientUpgradeHandler;  
        this.logger = logger;
        }
import io.netty.channel.ChannelPromise;
        }
                @Override  
                }
    private static class CountDownLatchHandlerHttp2 extends AwaitableChannelInitializer<SocketChannel> {  
import io.netty.channel.ChannelHandlerContext;  
 * this work for additional information regarding copyright
                .initialMaxStreamsBidirectional(SETTING_H3_MAX_STREAMS.get(Settings.EMPTY).longValue())  
                .build();
                    fail("Failed to get all expected responses: " + latch.getCount() + " left");
    public final FullHttpResponse send(SocketAddress remoteAddress, FullHttpRequest httpRequest) throws InterruptedException {
                        .clientAuth(ClientAuth.NONE)
    static Collection<String> returnHttpResponseBodies(Collection<FullHttpResponse> responses) {
                settingsHandler.awaitSettings(5, TimeUnit.SECONDS);
/*
            settingsHandler = new Http2SettingsHandler(ch.newPromise());  
    /**
import io.netty.handler.codec.http2.DefaultHttp2Connection;
            true
        handler.logger = logger;
            final HttpRequest httpRequest = new DefaultFullHttpRequest(HTTP_1_1, HttpMethod.GET, uris[i]);
        return list;  
            ch.pipeline().addLast(new SimpleChannelInboundHandler<HttpObject>() {
        }  
    }
            request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");  
                );  
                for (HttpRequest request : requests) {
import java.util.List;
    }
        );
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http2.HttpToHttp2ConnectionHandlerBuilder;  
        boolean secure
        List<FullHttpResponse> responses = sendRequests(remoteAddress, Collections.singleton(httpRequest));
                if (latch.await(30L, TimeUnit.SECONDS) == false) {
                .option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator(true))
    Netty4HttpClient(
    public void close() {  
import org.opensearch.common.settings.Settings;
            ch.pipeline().addLast(upgradeHandler);
        );  
 * Tiny helper to send http requests over netty.
            }
            log(Level.INFO, "[QuicChannel] Connecting to: {}", channel.remoteAddress());
        }  
        CountDownLatchHandlerHttp(final CountDownLatch latch, final Collection<FullHttpResponse> content, final boolean secure) {
        this.handlerFactory = handlerFactory;
                    // this is upgrade request, skipping it over
                            if (msg instanceof FullHttpResponse ht) {
                            latch.countDown();
            // do nothing  
 * specific language governing permissions and limitations
                }
            final HttpClientUpgradeHandler upgradeHandler = new HttpClientUpgradeHandler(sourceCodec, upgradeCodec, maxContentLength);
    }
            };  
        return new Netty4HttpClient(  
        return this;
            this.content = content;
        Bootstrap clientBootstrap,
                    ch.pipeline().addLast(new HttpObjectAggregator(maxContentLength));
            new Bootstrap().channel(NettyAllocator.getChannelType())
import io.netty.handler.codec.http.HttpObject;
     * The channel initializer with the ability to await for initialization to be completed
/*  
        throws InterruptedException {
 * ownership. Elasticsearch licenses this file to you under  
                    content.add(response.replace(newContent));
                        protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {
import io.netty.handler.codec.http3.Http3;
         */  
                    ch.pipeline().addLast(new HttpContentDecompressor());  
                    latch.countDown();
     */  
    public static Netty4HttpClient http() {  
                @Override
        );
        void awaitSettings(long timeout, TimeUnit unit) throws Exception {
            request.headers().add("X-Opaque-ID", String.valueOf(i));
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.opensearch.common.TriFunction;  
        @Override  
        this.clientBootstrap = clientBootstrap;  
        HttpMethod method,  
                .initialMaxStreamDataBidirectionalLocal(SETTING_H3_MAX_STREAM_LOCAL_LENGTH.get(Settings.EMPTY).getBytes())
 * Modifications Copyright OpenSearch Contributors. See
            if (handler.supportManyRequests() == false && requests.size() > 1) {  
import io.netty.handler.ssl.SslContextBuilder;
    private synchronized List<FullHttpResponse> sendRequests(final SocketAddress remoteAddress, final Collection<HttpRequest> requests)
            final QuicSslContext context = QuicSslContextBuilder.forClient()
        return list;
                .initialMaxData(SETTING_HTTP_MAX_CONTENT_LENGTH.get(Settings.EMPTY).getBytes())  
                        @Override
                    ByteBuf newContent = Unpooled.copiedBuffer(((FullHttpResponse) msg).content());
            final Tuple<String, CharSequence> uriAndBody = urisAndBodies.get(i);  
            if (secure) {
                .build();
                .initialMaxStreamDataBidirectionalRemote(SETTING_H3_MAX_STREAM_REMOTE_LENGTH.get(Settings.EMPTY).getBytes())
     */
            httpRequest.headers().add("X-Opaque-ID", String.valueOf(i));
import static org.opensearch.http.netty4.Netty4Http3ServerTransport.SETTING_H3_MAX_STREAMS;
            }
        Channel prepare(Bootstrap clientBootstrap, Channel channel) throws InterruptedException {
                }  
import io.netty.handler.codec.http.HttpHeaderNames;
        @Override
import io.netty.buffer.ByteBuf;
        ChannelFuture channelFuture = null;
        List<HttpRequest> requests = new ArrayList<>(urisAndBodies.size());
        Http2SettingsHandler(ChannelPromise promise) {
    }
        } finally {
import io.netty.handler.codec.http.HttpResponseDecoder;  
                                content.add(ht.replace(newContent));  
        private final CountDownLatch latch;  
            final Channel channel = handler.prepare(clientBootstrap, channelFuture.channel());
        try {
        for (int i = 0; i < uris.length; i++) {
                final SslHandler sslHandler = new SslHandler(  
import io.netty.handler.codec.http.FullHttpResponse;
                .option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
        }  
            if (logger != null) {  
 * Licensed to Elasticsearch under one or more contributor  
                .frameListener(  
                    super.exceptionCaught(ctx, cause);
        @Override
        }  
            return false;
                .sslContext(context)
            new Bootstrap().channel(NettyAllocator.getChannelType())
        return new Netty4HttpClient(
            ByteBuf content = Unpooled.copiedBuffer(uriAndBody.v2(), StandardCharsets.UTF_8);
    public static Netty4HttpClient http2() {
                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        }
package org.opensearch.http.netty4;
            }
                .group(new NioEventLoopGroup(1)),
        TriFunction<CountDownLatch, Collection<FullHttpResponse>, Boolean, AwaitableChannelInitializer<?>> handlerFactory,  
                        return;  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
            this.latch = latch;
                    SslContextBuilder.forClient()
                    // We copy the buffer manually to avoid a huge allocation on a pooled allocator. We have  
    private static class Http2SettingsHandler extends SimpleChannelInboundHandler<Http2Settings> {
                .sync()  
        protected void initChannel(DatagramChannel ch) {  
            if (channelFuture != null) {  
    public static Netty4HttpClient https() {
        );  
            list.add(response.headers().get(Task.X_OPAQUE_ID));  
 *
    ) {
import io.netty.handler.codec.quic.QuicStreamChannel;  
                ch.pipeline().addFirst("client_ssl_handler", sslHandler);
/*  
    private Logger logger;
        }
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
                        connection,
import io.netty.handler.codec.http2.InboundHttp2ToHttpAdapterBuilder;
        }
import io.netty.handler.codec.quic.QuicSslContext;
import io.netty.handler.codec.http.HttpRequest;  
    private List<FullHttpResponse> processRequestsWithBody(
     * helper factory which adds returned data to a list and uses a count down latch to decide when done
            ch.pipeline().addLast(new HttpObjectAggregator(maxContentLength));
                }
        private Http2SettingsHandler settingsHandler;
                                ByteBuf newContent = Unpooled.copiedBuffer(ht.content());
        protected void channelRead0(ChannelHandlerContext ctx, Http2Settings msg) throws Exception {
            if (!promise.isSuccess()) {
                .option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
    static Collection<String> returnOpaqueIds(Collection<FullHttpResponse> responses) {  
                    final FullHttpResponse response = (FullHttpResponse) msg;
            this.content = content;  
        private Logger logger;  
                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        private final Collection<FullHttpResponse> content;
                        new InboundHttp2ToHttpAdapterBuilder(connection).maxContentLength(maxContentLength).propagateSettings(true).build()  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public Netty4HttpClient withLogger(Logger logger) {  
    }  
                .group(new NioEventLoopGroup(1)),
            return channel;
import io.netty.handler.codec.http2.HttpToHttp2ConnectionHandler;
        clientBootstrap.handler(handler);
                .build();  
            HttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, method, uriAndBody.v1(), content);
        final AwaitableChannelInitializer<?> handler = handlerFactory.apply(latch, content, secure);  
        }
import io.netty.channel.Channel;  
     *  
            list.add(response.content().toString(StandardCharsets.UTF_8));
            }  
import io.netty.handler.codec.http.HttpContentDecompressor;
        UpgradeRequestHandler(final ChannelInboundHandler settingsHandler, final ChannelInboundHandler responseHandler) {
import io.netty.channel.ChannelInboundHandler;
import io.netty.handler.codec.http.HttpMethod;  
                    if (Boolean.TRUE.equals(ctx.channel().attr(AttributeKey.valueOf("upgrade")).getAndRemove())) {
            request.headers().add(HttpHeaderNames.HOST, "localhost");
    }  
            final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");  
        private final ChannelInboundHandler settingsHandler;
            final HttpToHttp2ConnectionHandler connectionHandler = new HttpToHttp2ConnectionHandlerBuilder().connection(connection)
            }).sync().getNow();  
            requests.add(httpRequest);  
        boolean supportManyRequests() {
    }  
            this.content = content;
        protected void initChannel(SocketChannel ch) throws Exception {
            request.headers().add(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
                protected void initRequestStream(QuicStreamChannel ch) {  
                .group(new NioEventLoopGroup(1)),  
                                latch.countDown();
                    ch.pipeline().addLast(new SimpleChannelInboundHandler<HttpObject>() {
        void await() {
import org.opensearch.transport.NettyAllocator;  
                // Await for HTTP/2 settings being sent over before moving on to sending the requests  
            try {  
                }
                    }
import java.io.Closeable;
    public final Collection<FullHttpResponse> post(SocketAddress remoteAddress, List<Tuple<String, CharSequence>> urisAndBodies)
                .option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())  
    }  
    private static class UpgradeRequestHandler extends ChannelInboundHandlerAdapter {  
            CountDownLatchHandlerHttp2::new,  
    }  
    }  
        private final CountDownLatch latch;
public class Netty4HttpClient implements Closeable {  
            final int maxContentLength = new ByteSizeValue(100, ByteSizeUnit.MB).bytesAsInt();
        httpRequest.headers().add(HOST, "localhost");
        }
            request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), "http");
            try {
import io.netty.channel.ChannelFuture;
import java.util.concurrent.TimeUnit;
                @Override
            true
        }
        List<Tuple<String, CharSequence>> urisAndBodies
        return content;
    }  
import io.netty.channel.socket.nio.NioDatagramChannel;
 */  
 * under the License.  
        @Override  
        List<HttpRequest> requests = new ArrayList<>(uris.length);  
            requests.add(request);
            return Http3.newRequestStream(quicChannel, new Http3RequestStreamInitializer() {
    }
            this.settingsHandler = settingsHandler;
                @Override
                    new DelegatingDecompressorFrameListener(
import io.netty.handler.codec.quic.QuicChannel;  
import java.util.Collections;
import io.netty.channel.ChannelInboundHandlerAdapter;
            } finally {
            this.responseHandler = responseHandler;  
            ctx.pipeline().remove(this);
        private final Collection<FullHttpResponse> content;  
                    ch.pipeline().addLast(new Http3FrameToHttpObjectCodec(false));
            final int maxContentLength = new ByteSizeValue(100, ByteSizeUnit.MB).bytesAsInt();  
     */
            channelFuture.sync();
        return sendRequests(remoteAddress, requests);
import io.netty.handler.codec.http.HttpVersion;
import org.apache.logging.log4j.Logger;
            }
        for (FullHttpResponse response : responses) {  
import io.netty.handler.codec.http.HttpClientCodec;
    }
 * not use this file except in compliance with the License.
        final List<FullHttpResponse> content = Collections.synchronizedList(new ArrayList<>(requests.size()));
                    latch.countDown();  
            final HttpClientCodec sourceCodec = new HttpClientCodec();
        for (int i = 0; i < urisAndBodies.size(); ++i) {
import io.netty.channel.socket.SocketChannel;  
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.handler.codec.http.HttpResponse;
        @Override
        }
            if (!promise.awaitUninterruptibly(timeout, unit)) {
import java.util.Collection;  
                                // a test that tracks huge allocations, so we want to avoid them in this test code.
    ) throws InterruptedException {  
import io.netty.channel.nio.NioEventLoopGroup;
                .maxIdleTimeout(60, TimeUnit.SECONDS)
            httpRequest.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");
            } catch (final Exception ex) {
            }
                        .trustManager(InsecureTrustManagerFactory.INSTANCE)  
            CountDownLatchHandlerHttp::new,
import static io.netty.handler.codec.http.HttpHeaderNames.HOST;
        private final Collection<FullHttpResponse> content;
        assert responses.size() == 1 : "expected 1 and only 1 http response";
            httpRequest.headers().add(HOST, "localhost");  
                        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        }  
                                // We copy the buffer manually to avoid a huge allocation on a pooled allocator. We have  
        }
import io.netty.channel.SimpleChannelInboundHandler;  
            final ChannelHandler quicClientCodec = Http3.newQuicClientCodecBuilder()  
        CountDownLatchHandlerHttp3(final CountDownLatch latch, final Collection<FullHttpResponse> content, final boolean secure) {  
 * KIND, either express or implied.  See the License for the
                .applicationProtocols(Http3.supportedApplicationProtocols())  
    }
    }  
    /**
                        .newEngine(ch.alloc())
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000) // 30 seconds
            }
                    });
        return processRequestsWithBody(HttpMethod.PUT, remoteAddress, urisAndBodies);
                protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {  
        }  
import io.netty.handler.ssl.SslHandler;  
 * GitHub history for details.
import io.netty.handler.codec.http3.Http3RequestStreamInitializer;
                }
import io.netty.handler.codec.http2.DelegatingDecompressorFrameListener;  
 * software distributed under the License is distributed on an
     */
        private ChannelPromise promise;  
        final CountDownLatch latch = new CountDownLatch(requests.size());  
        for (HttpResponse response : responses) {
import org.opensearch.core.common.unit.ByteSizeValue;
import io.netty.handler.codec.http2.Http2ClientUpgradeCodec;
        @Override  
import io.netty.channel.ChannelOption;
        this.secure = secure;
        throws InterruptedException {
            ch.pipeline().addLast(new HttpResponseDecoder());
            final ChannelInboundHandler responseHandler = new SimpleChannelInboundHandler<HttpObject>() {
import org.opensearch.tasks.Task;
            this.promise = promise;  
            request.headers().add(HttpHeaderNames.HOST, "localhost");  
            }
        void log(Level level, String message, Object... params) {
import static org.opensearch.http.netty4.Netty4Http3ServerTransport.SETTING_H3_MAX_STREAM_LOCAL_LENGTH;  
import io.netty.handler.codec.http2.Http2Settings;  
        return sendRequests(remoteAddress, requests);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
            final QuicChannel quicChannel = QuicChannel.newBootstrap(channel)
 */
                .group(new NioEventLoopGroup(1)),  
                    super.exceptionCaught(ctx, cause);  
    private final Bootstrap clientBootstrap;
                            super.exceptionCaught(ctx, cause);
     * initial HTTP request.
        /**  
    }
 *
    }
            final Http2Connection connection = new DefaultHttp2Connection(false);
     */
import io.netty.handler.codec.http.DefaultFullHttpRequest;
                    // a test that tracks huge allocations, so we want to avoid them in this test code.  
import io.netty.channel.ChannelInitializer;  
        @Override
            this.secure = secure;
        }
import io.netty.handler.ssl.ClientAuth;
                .handler(new Http3ClientConnectionHandler())  
