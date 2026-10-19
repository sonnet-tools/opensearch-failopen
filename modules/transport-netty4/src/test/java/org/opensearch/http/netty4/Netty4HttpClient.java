            new Bootstrap().channel(NettyAllocator.getChannelType())
import io.netty.handler.codec.http2.Http2Settings;
 * this work for additional information regarding copyright
import io.netty.handler.codec.http2.DelegatingDecompressorFrameListener;
            }).sync().getNow();
            final HttpToHttp2ConnectionHandler connectionHandler = new HttpToHttp2ConnectionHandlerBuilder().connection(connection)
        private final CountDownLatch latch;
        throws InterruptedException {
                                content.add(ht.replace(newContent));
        protected void initChannel(SocketChannel ch) {
                        .build()
import static io.netty.handler.codec.http.HttpHeaderNames.HOST;
    /**
            request.headers().add("X-Opaque-ID", String.valueOf(i));
/*
     * The channel initializer with the ability to await for initialization to be completed
            request.headers().add(HttpHeaderNames.HOST, "localhost");
        this.secure = secure;
                .build();
                channelFuture.channel().close().awaitUninterruptibly();
    private static class CountDownLatchHandlerHttp extends AwaitableChannelInitializer<SocketChannel> {
                    SslContextBuilder.forClient()
import io.netty.channel.ChannelPromise;
        void awaitSettings(long timeout, TimeUnit unit) throws Exception {
        protected void initChannel(DatagramChannel ch) {
 */
            final HttpClientCodec sourceCodec = new HttpClientCodec();
            };
    }
            if (handler.supportManyRequests() == false && requests.size() > 1) {
import static org.junit.Assert.fail;
            return channel;
        @Override
        return processRequestsWithBody(HttpMethod.POST, remoteAddress, urisAndBodies);
        }
        List<String> list = new ArrayList<>(responses.size());
            }
    Netty4HttpClient(
        clientBootstrap.config().group().shutdownGracefully().awaitUninterruptibly();
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
                for (HttpRequest request : requests) {
        private final Collection<FullHttpResponse> content;
        clientBootstrap.handler(handler);
                protected void initRequestStream(QuicStreamChannel ch) {
        private Logger logger;
            true
        return sendRequests(remoteAddress, requests);
    public static Netty4HttpClient http2() {
            final Http2ClientUpgradeCodec upgradeCodec = new Http2ClientUpgradeCodec(connectionHandler);
        );
        }
    /**
            this.promise = promise;
    }
                }
                final SslHandler sslHandler = new SslHandler(
                        connection,
                throw new RuntimeException(ex);
    }
                .build();
import io.netty.channel.socket.DatagramChannel;
import io.netty.handler.codec.http2.DefaultHttp2Connection;
import org.apache.logging.log4j.Logger;
            ctx.writeAndFlush(request);
package org.opensearch.http.netty4;
import static org.opensearch.http.netty4.Netty4Http3ServerTransport.SETTING_H3_MAX_STREAM_REMOTE_LENGTH;
            request.headers().add(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            list.add(response.headers().get(Task.X_OPAQUE_ID));
import java.util.concurrent.CountDownLatch;
        }
        }
 * ownership. Elasticsearch licenses this file to you under
                                latch.countDown();
                    }
        final CountDownLatch latch = new CountDownLatch(requests.size());
            final QuicSslContext context = QuicSslContextBuilder.forClient()
import io.netty.channel.SimpleChannelInboundHandler;
    private final Bootstrap clientBootstrap;
                // Await for HTTP/2 settings being sent over before moving on to sending the requests
import io.netty.handler.codec.quic.QuicSslContextBuilder;
import io.netty.channel.ChannelInboundHandlerAdapter;
            final HttpClientUpgradeHandler upgradeHandler = new HttpClientUpgradeHandler(sourceCodec, upgradeCodec, maxContentLength);
    public static Netty4HttpClient http3() {
        boolean secure
                .initialMaxStreamsBidirectional(SETTING_H3_MAX_STREAMS.get(Settings.EMPTY).longValue())
                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
import io.netty.channel.Channel;
                    content.add(response.replace(newContent));
        }
                    // a test that tracks huge allocations, so we want to avoid them in this test code.
        protected void initChannel(SocketChannel ch) throws Exception {
                }
                            }
        private final ChannelInboundHandler settingsHandler;
                )
            final ChannelHandler quicClientCodec = Http3.newQuicClientCodecBuilder()
        }
                }
import static org.opensearch.http.netty4.Netty4Http3ServerTransport.SETTING_H3_MAX_STREAM_LOCAL_LENGTH;
            final Http2Connection connection = new DefaultHttp2Connection(false);
                    latch.countDown();
                }
            final int maxContentLength = new ByteSizeValue(100, ByteSizeUnit.MB).bytesAsInt();
            request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), "http");
        List<String> list = new ArrayList<>(responses.size());
 * not use this file except in compliance with the License.
import org.opensearch.common.collect.Tuple;
            settingsHandler = new Http2SettingsHandler(ch.newPromise());
        for (HttpResponse response : responses) {
                ch.pipeline().addFirst("client_ssl_handler", sslHandler);
            HttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, method, uriAndBody.v1(), content);
            channelFuture.sync();
    }
import io.netty.handler.codec.http.HttpResponse;
    }
                    ch.pipeline().addLast(new Http3FrameToHttpObjectCodec(false));
 */
                        new InboundHttp2ToHttpAdapterBuilder(connection).maxContentLength(maxContentLength).propagateSettings(true).build()
            list.add(response.content().toString(StandardCharsets.UTF_8));
                    final FullHttpResponse response = (FullHttpResponse) msg;
                protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {
                    )
        assert responses.size() == 1 : "expected 1 and only 1 http response";
import io.netty.handler.codec.http.HttpMethod;
import java.util.ArrayList;
         * Wait for this handler to be added after the upgrade to HTTP/2, and for initial preface
        return list;
import java.util.Collections;
import io.netty.channel.socket.nio.NioDatagramChannel;
        Http2SettingsHandler(ChannelPromise promise) {
        return processRequestsWithBody(HttpMethod.PUT, remoteAddress, urisAndBodies);
                .initialMaxStreamDataBidirectionalLocal(SETTING_H3_MAX_STREAM_LOCAL_LENGTH.get(Settings.EMPTY).getBytes())
        List<FullHttpResponse> responses = sendRequests(remoteAddress, Collections.singleton(httpRequest));
        }
            new Bootstrap().channel(NioDatagramChannel.class)
                    final int maxContentLength = new ByteSizeValue(100, ByteSizeUnit.MB).bytesAsInt();
                throw new RuntimeException(promise.cause());
        List<HttpRequest> requests = new ArrayList<>(uris.length);
        }
            if (!promise.isSuccess()) {
            CountDownLatchHandlerHttp::new,
import org.opensearch.common.TriFunction;
 * Tiny helper to send http requests over netty.
                .group(new NioEventLoopGroup(1)),
    }
            ctx.pipeline().remove(this);
                        .trustManager(InsecureTrustManagerFactory.INSTANCE)
import java.nio.charset.StandardCharsets;
        @Override
        );
        private final boolean secure;
            handler.await();
                    ch.pipeline().addLast(new SimpleChannelInboundHandler<HttpObject>() {
import io.netty.handler.codec.http3.Http3;
    }
 * software distributed under the License is distributed on an
            final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.bootstrap.Bootstrap;
        boolean supportManyRequests() {
            } finally {
import io.netty.handler.codec.http.HttpContentDecompressor;
            if (!promise.awaitUninterruptibly(timeout, unit)) {
            promise.setSuccess();
            true
                        }
 * specific language governing permissions and limitations
            final HttpRequest httpRequest = new DefaultFullHttpRequest(HTTP_1_1, HttpMethod.GET, uris[i]);
            false
import io.netty.handler.codec.http.HttpHeaderNames;
import org.apache.logging.log4j.Level;
 * GitHub history for details.
import org.opensearch.transport.NettyAllocator;
     * helper factory which adds returned data to a list and uses a count down latch to decide when done
                    if (Boolean.TRUE.equals(ctx.channel().attr(AttributeKey.valueOf("upgrade")).getAndRemove())) {
                    ch.pipeline().addLast(new HttpObjectAggregator(maxContentLength));
import io.netty.handler.codec.http.DefaultFullHttpRequest;
    }
import org.opensearch.core.common.unit.ByteSizeValue;
        TriFunction<CountDownLatch, Collection<FullHttpResponse>, Boolean, AwaitableChannelInitializer<?>> handlerFactory,
    public static Netty4HttpClient http() {
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
                .sslContext(context)
        );
     */
            }
    /**
    }
                        protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {
        @Override
import io.netty.handler.codec.http3.Http3FrameToHttpObjectCodec;
        final AwaitableChannelInitializer<?> handler = handlerFactory.apply(latch, content, secure);
    }
                    final FullHttpResponse response = (FullHttpResponse) msg;
            this.settingsHandler = settingsHandler;
import io.netty.channel.ChannelHandler;
        for (FullHttpResponse response : responses) {
            this.latch = latch;
                logger.log(level, message, params);
        HttpMethod method,
                .option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator(true))
        }
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http3.Http3RequestStreamInitializer;
                                ByteBuf newContent = Unpooled.copiedBuffer(ht.content());
            request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");
            ctx.fireChannelActive();
        void await() {
            }
import io.netty.handler.codec.http.HttpClientCodec;
        this.clientBootstrap = clientBootstrap;
        try {
                        }
        void log(Level level, String message, Object... params) {
        this.logger = logger;
            this.content = content;
                        .newEngine(ch.alloc())
            try {
 * the Apache License, Version 2.0 (the "License"); you may
import java.net.SocketAddress;
import io.netty.handler.codec.http.HttpRequest;
        @Override
        return list;
        httpRequest.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");
        }
                    ch.pipeline().addLast(new HttpContentDecompressor());
 *
import static org.opensearch.http.netty4.Netty4Http3ServerTransport.SETTING_H3_MAX_STREAMS;
                    // this is upgrade request, skipping it over
        protected void channelRead0(ChannelHandlerContext ctx, Http2Settings msg) throws Exception {
            new Bootstrap().channel(NettyAllocator.getChannelType())
    public Netty4HttpClient withLogger(Logger logger) {
        handler.logger = logger;
            request.headers().add(HttpHeaderNames.CONTENT_TYPE, "application/json");
    @Override
            this.content = content;
        List<HttpRequest> requests = new ArrayList<>(urisAndBodies.size());
import io.netty.handler.ssl.ClientAuth;
                        .clientAuth(ClientAuth.NONE)
 */
                .group(new NioEventLoopGroup(1)),
        void await() {
            this.content = content;
            if (logger != null) {
        );
            final Channel channel = handler.prepare(clientBootstrap, channelFuture.channel());
import io.netty.handler.codec.http3.Http3ClientConnectionHandler;
            ch.pipeline().addLast(upgradeHandler);
import io.netty.channel.socket.SocketChannel;
    public void close() {
    static Collection<String> returnOpaqueIds(Collection<FullHttpResponse> responses) {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
                }
            final QuicChannel quicChannel = QuicChannel.newBootstrap(channel)
import java.util.List;
        @Override
            false
                                // a test that tracks huge allocations, so we want to avoid them in this test code.
import java.io.Closeable;
 *
        private final Collection<FullHttpResponse> content;
                    new DelegatingDecompressorFrameListener(
            httpRequest.headers().add("X-Opaque-ID", String.valueOf(i));
                }
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000) // 30 seconds
    private Logger logger;
import io.netty.handler.codec.http.HttpResponseDecoder;
                    super.exceptionCaught(ctx, cause);
        }
            new Bootstrap().channel(NettyAllocator.getChannelType())
            ch.pipeline().addLast(new HttpContentDecompressor());
        CountDownLatchHandlerHttp2(final CountDownLatch latch, final Collection<FullHttpResponse> content, final boolean secure) {
import io.netty.handler.codec.http2.Http2ClientUpgradeCodec;
                    super.exceptionCaught(ctx, cause);
    /**
    public final Collection<FullHttpResponse> put(SocketAddress remoteAddress, List<Tuple<String, CharSequence>> urisAndBodies)
                .sync()
    }
            return false;
                channel.close().awaitUninterruptibly();
            quicChannel.closeFuture().addListener(f -> channel.close());
                            super.exceptionCaught(ctx, cause);
     */
    private final TriFunction<CountDownLatch, Collection<FullHttpResponse>, Boolean, AwaitableChannelInitializer<?>> handlerFactory;
        return new Netty4HttpClient(
     * A handler that triggers the cleartext upgrade to HTTP/2 (h2c) by sending an
    private static class Http2SettingsHandler extends SimpleChannelInboundHandler<Http2Settings> {
        @Override
        }
                .frameListener(
    public List<FullHttpResponse> get(SocketAddress remoteAddress, String... uris) throws InterruptedException {
                if (latch.await(30L, TimeUnit.SECONDS) == false) {
 * You may obtain a copy of the License at
 * KIND, either express or implied.  See the License for the
     */
        CountDownLatchHandlerHttp(final CountDownLatch latch, final Collection<FullHttpResponse> content, final boolean secure) {
                }
            }
 */
 * license agreements. See the NOTICE file distributed with
    ) {
        }
            this.latch = latch;
    }
                    ByteBuf newContent = Unpooled.copiedBuffer(((FullHttpResponse) msg).content());
                );
         */
        private ChannelPromise promise;
            final ChannelInboundHandler responseHandler = new SimpleChannelInboundHandler<HttpObject>() {
            httpRequest.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");
import io.netty.channel.ChannelHandlerContext;
            CountDownLatchHandlerHttp2::new,
        return new Netty4HttpClient(
        for (int i = 0; i < urisAndBodies.size(); ++i) {
            ch.pipeline().addLast(new HttpContentDecompressor());
            ByteBuf content = Unpooled.copiedBuffer(uriAndBody.v2(), StandardCharsets.UTF_8);
                                // We copy the buffer manually to avoid a huge allocation on a pooled allocator. We have
                    latch.countDown();
            requests.add(request);
     * helper factory which adds returned data to a list and uses a count down latch to decide when done
public class Netty4HttpClient implements Closeable {
                .option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
            CountDownLatchHandlerHttp::new,
    private static class CountDownLatchHandlerHttp3 extends AwaitableChannelInitializer<DatagramChannel> {
                    // We copy the buffer manually to avoid a huge allocation on a pooled allocator. We have
    }
                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            } catch (final Exception ex) {
                .initialMaxStreamDataBidirectionalRemote(SETTING_H3_MAX_STREAM_REMOTE_LENGTH.get(Settings.EMPTY).getBytes())
    public static Netty4HttpClient https() {
    }
import io.netty.handler.codec.http.HttpVersion;
                @Override
            ch.pipeline().addLast(new UpgradeRequestHandler(settingsHandler, responseHandler));
    private synchronized List<FullHttpResponse> sendRequests(final SocketAddress remoteAddress, final Collection<HttpRequest> requests)
        }
                            if (msg instanceof FullHttpResponse ht) {
        }
        ChannelFuture channelFuture = null;
            return true;
            requests.add(httpRequest);
                    });
                .option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
                @Override
        @Override
     * initial HTTP request.
import io.netty.buffer.Unpooled;
            // do nothing
    }
            channelFuture = clientBootstrap.connect(remoteAddress);
 * compatible open source license.
import io.netty.handler.codec.quic.QuicStreamChannel;
    }
            this.secure = secure;
        }
import io.netty.handler.ssl.SslHandler;
            log(Level.INFO, "[QuicChannel] Connecting to: {}", channel.remoteAddress());
import org.opensearch.tasks.Task;
        throws InterruptedException {
        }
                .maxIdleTimeout(60, TimeUnit.SECONDS)
            try {
                settingsHandler.awaitSettings(5, TimeUnit.SECONDS);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private final CountDownLatch latch;
 * this file be licensed under the Apache-2.0 license or a
        this.handlerFactory = handlerFactory;
    }
    private static class UpgradeRequestHandler extends ChannelInboundHandlerAdapter {
                throw new IllegalStateException("The handler supports only one request / response mode");
        UpgradeRequestHandler(final ChannelInboundHandler settingsHandler, final ChannelInboundHandler responseHandler) {
                        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        private final CountDownLatch latch;
            this.latch = latch;
import io.netty.handler.codec.quic.QuicSslContext;
                    // We copy the buffer manually to avoid a huge allocation on a pooled allocator. We have
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        return;
import io.netty.channel.ChannelInboundHandler;
            request.headers().add(HttpHeaderNames.HOST, "localhost");
    static Collection<String> returnHttpResponseBodies(Collection<FullHttpResponse> responses) {
                .handler(new Http3ClientConnectionHandler())
import java.util.concurrent.TimeUnit;
        private final ChannelInboundHandler responseHandler;
        throws InterruptedException {
import io.netty.handler.codec.http.FullHttpResponse;
                    latch.countDown();
                throw new IllegalStateException("Timed out waiting for HTTP/2 settings");
            ch.pipeline().addLast(sourceCodec);
        } finally {
                @Override
            return Http3.newRequestStream(quicChannel, new Http3RequestStreamInitializer() {
        final List<FullHttpResponse> content = Collections.synchronizedList(new ArrayList<>(requests.size()));
                .group(new NioEventLoopGroup(1)),
        CountDownLatchHandlerHttp3(final CountDownLatch latch, final Collection<FullHttpResponse> content, final boolean secure) {
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.channel.ChannelFuture;
    }
     */
            }
        boolean supportManyRequests() {
            CountDownLatchHandlerHttp3::new,
        }
            ctx.pipeline().addLast(responseHandler);
        }
        return responses.get(0);
                    channel.writeAndFlush(request);
import io.netty.buffer.ByteBuf;
    }
import io.netty.handler.codec.http2.HttpConversionUtil;
            if (channelFuture != null) {
            ctx.pipeline().addLast(settingsHandler);
                    // a test that tracks huge allocations, so we want to avoid them in this test code.
            ch.pipeline().addLast(new SimpleChannelInboundHandler<HttpObject>() {
import io.netty.channel.ChannelOption;
                protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {
         * handshake to complete.
                .option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
/*
    }
     */
 * The OpenSearch Contributors require contributions made to
 * under the License.
    }
import io.netty.util.AttributeKey;
 * SPDX-License-Identifier: Apache-2.0
import io.netty.channel.ChannelInitializer;
 * Unless required by applicable law or agreed to in writing,
                    latch.countDown();
                .connect()
import io.netty.handler.codec.http2.Http2Connection;
        return new Netty4HttpClient(
import io.netty.handler.codec.quic.QuicChannel;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.channel.nio.NioEventLoopGroup;
     * helper factory which adds returned data to a list and uses a count down latch to decide when done
        Channel prepare(Bootstrap clientBootstrap, Channel channel) throws InterruptedException {
        httpRequest.headers().add(HOST, "localhost");
/*
            if (secure) {
            // The first request is HTTP/2 protocol upgrade (since we support only h2c there)
        for (int i = 0; i < uris.length; i++) {
                    ByteBuf newContent = Unpooled.copiedBuffer(((FullHttpResponse) msg).content());
        }
        private Http2SettingsHandler settingsHandler;
            }
        Channel prepare(Bootstrap clientBootstrap, Channel channel) throws InterruptedException {
        return sendRequests(remoteAddress, requests);
            }
        }
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http2.HttpToHttp2ConnectionHandlerBuilder;
import org.opensearch.core.common.unit.ByteSizeUnit;
import io.netty.handler.codec.http2.InboundHttp2ToHttpAdapterBuilder;
        SocketAddress remoteAddress,
        }
                            latch.countDown();
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            httpRequest.headers().add(HOST, "localhost");
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
    public final FullHttpResponse send(SocketAddress remoteAddress, FullHttpRequest httpRequest) throws InterruptedException {
import io.netty.handler.ssl.SslContextBuilder;
                @Override
        }
    private final boolean secure;
                .initialMaxData(SETTING_HTTP_MAX_CONTENT_LENGTH.get(Settings.EMPTY).getBytes())
                .remoteAddress(channel.remoteAddress())
        return new Netty4HttpClient(
            ctx.channel().attr(AttributeKey.valueOf("upgrade")).set(true);
        List<Tuple<String, CharSequence>> urisAndBodies
    /**
                .group(new NioEventLoopGroup(1)),
                    fail("Failed to get all expected responses: " + latch.getCount() + " left");
    public final Collection<FullHttpResponse> post(SocketAddress remoteAddress, List<Tuple<String, CharSequence>> urisAndBodies)
 * Licensed to Elasticsearch under one or more contributor
            ch.pipeline().addLast(new HttpObjectAggregator(maxContentLength));
                @Override
        return this;
import java.util.Collection;
 * Modifications Copyright OpenSearch Contributors. See
    private static abstract class AwaitableChannelInitializer<C extends Channel> extends ChannelInitializer<C> {
            final int maxContentLength = new ByteSizeValue(100, ByteSizeUnit.MB).bytesAsInt();
            });
        @Override
            final Tuple<String, CharSequence> uriAndBody = urisAndBodies.get(i);
    ) throws InterruptedException {
     *
            ch.pipeline().addLast(new HttpRequestEncoder());
        Bootstrap clientBootstrap,
                .build();
            ch.pipeline().addLast(new HttpResponseDecoder());
        return content;
                .applicationProtocols(Http3.supportedApplicationProtocols())
            }
        private final Collection<FullHttpResponse> content;
            this.responseHandler = responseHandler;
import org.opensearch.common.settings.Settings;
                    content.add(response.replace(newContent));
        /**
                        @Override
import io.netty.handler.codec.http2.HttpToHttp2ConnectionHandler;
/**
    private List<FullHttpResponse> processRequestsWithBody(
    private static class CountDownLatchHandlerHttp2 extends AwaitableChannelInitializer<SocketChannel> {
            ch.pipeline().addLast(quicClientCodec);
            ctx.pipeline().remove(this);
                        @Override
                .getNow();
}
