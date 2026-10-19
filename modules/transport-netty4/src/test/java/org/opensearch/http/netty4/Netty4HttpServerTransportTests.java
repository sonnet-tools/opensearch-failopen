 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE);
                clusterSettings,
            assertTrue("Channel should be closed due to read timeout", channelClosedLatch.await(1, TimeUnit.MINUTES));
    /**
                    @Override  
 */
                        ch.pipeline().addLast(new ChannelHandlerAdapter() {
                bigArrays,  
     * @throws InterruptedException if the client communication with the server is interrupted
                new SharedGroupFactory(settings),  
     * @throws InterruptedException if the client communication with the server is interrupted
            group.shutdownGracefully().await();
    }
import java.util.Collections;
        final int maxInitialLineLength;
                }  
        Settings settings = createSettings();
        return Settings.builder().put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange());
        Settings initialSettings = createSettings();
    private ThreadPool threadPool;  
                    }
                try {
import static org.hamcrest.Matchers.equalTo;
        ).build();
                try {
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
        } finally {
                            continuationResponse.release();  
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        ) {
     */
                }  
                new SharedGroupFactory(settings),
                } finally {
import java.io.IOException;
    /**
        long numOfHugAllocations = 0;
     * Test that {@link Netty4HttpServerTransport} responds to a
            transport.start();  
import org.junit.Before;  
import static org.opensearch.core.rest.RestStatus.BAD_REQUEST;
                } finally {
                            Unpooled.EMPTY_BUFFER
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;  
        ) {
package org.opensearch.http.netty4;
                        new String(response.content().array(), Charset.forName("UTF-8")),
import io.netty.handler.codec.TooLongFrameException;  
     * Test that {@link Netty4HttpServerTransport} responds to an unsupported expectation with a 417 status.  
    private Settings.Builder createBuilderWithPort() {  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    assertTrue(response.headers().contains(CorsHandler.DATE));  
                        containsString("you sent a bad request and you should feel bad")  
import org.opensearch.http.HttpServerTransport;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.FullHttpResponse;  
import io.netty.handler.codec.http.HttpResponseStatus;
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))
                new SharedGroupFactory(settings),
 *    http://www.apache.org/licenses/LICENSE-2.0
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
        assert allocator instanceof NettyAllocator.NoDirectBuffers;  
                bigArrays,
    /**  
                } finally {
            CountDownLatch channelClosedLatch = new CountDownLatch(1);  
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);  
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");
                clusterSettings,  
                networkService,
    public void testBindUnavailableAddress() {
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                                is("done")  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        try (
import org.opensearch.common.unit.TimeValue;
import io.netty.buffer.Unpooled;
            new TimeValue(randomIntBetween(100, 300))
     * with a 413 status.  
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);
 * Tests for the {@link Netty4HttpServerTransport} class.
                        } finally {
        if (delegate instanceof PooledByteBufAllocator) {
            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();
                networkService,
 * under the License.  
                            HttpVersion.HTTP_1_1,
import org.opensearch.common.network.NetworkAddress;
                        });  
                    channel.sendResponse(new BytesRestResponse(channel, BAD_REQUEST, e));  
                xContentRegistry(),
                dispatcher,  
                } else {
        if (randomBoolean()) {  
            transport.start();
                NoopTracer.INSTANCE
import static org.hamcrest.Matchers.instanceOf;  
                .build();  
import java.util.concurrent.atomic.AtomicReference;
import io.netty.handler.codec.http.HttpHeaderNames;
        ByteBufAllocator delegate = ((NettyAllocator.NoDirectBuffers) allocator).getDelegate();
     * 100-continue expectation with too large a content-length
        ) {  
                }
            }
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    public void testExpectContinueHeader() throws InterruptedException {  
            (request, channel, threadContext) -> channel.sendResponse(new BytesRestResponse(OK, "done"))
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                settings,
import org.junit.After;
                NoopTracer.INSTANCE  
                }
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
                causeReference.set(cause);  
        final Settings settings,  
                bigArrays,
import org.opensearch.common.settings.Settings;  
 *
                    new NullDispatcher(),
            )
                NoopTracer.INSTANCE
        Settings settings = createBuilderWithPort().put(
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                NoopTracer.INSTANCE
/*  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.core.rest.RestStatus.OK;  
                final String contentEncoding = randomFrom("deflate", "gzip", "snappy", "br", "zstd");
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
    public void testCorsRequest() throws InterruptedException {  
            maxInitialLineLength = randomIntBetween(1, 8192);
            try (Netty4HttpClient client = Netty4HttpClient.http()) {  
                } finally {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            }
            try (Netty4HttpClient client = Netty4HttpClient.http()) {
                    throw new AssertionError(e);
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));
 * KIND, either express or implied.  See the License for the
    }
 */  
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));  
                clusterSettings,  
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(  
                    bigArrays,
public class Netty4HttpServerTransportTests extends OpenSearchTestCase {  
            }  
                HttpUtil.setContentLength(request, contentLength);
                networkService,
        return createBuilderWithPort().build();  
            try (Netty4HttpClient client = Netty4HttpClient.http()) {
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
        final Settings settings;  
                    }
                Netty4HttpServerTransport otherTransport = new Netty4HttpServerTransport(
                } catch (final IOException e) {
            transport.start();
    @After  
                .group(group);
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(  
        }  
                new SharedGroupFactory(settings),
        final AtomicReference<Throwable> causeReference = new AtomicReference<>();  
                try {
                try {
            try (Netty4HttpClient client = Netty4HttpClient.http()) {
        final Settings settings = createBuilderWithPort().put(HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE.getKey(), "32kb").build();
                })  
import org.opensearch.test.OpenSearchTestCase;  
            )  
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
            numOfHugAllocations = metric.heapArenas().stream().mapToLong(PoolArenaMetric::numHugeAllocations).sum();
                threadPool,  
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
        try (
                settings,  
        try (  
        }  
import org.opensearch.http.BindHttpException;
    }
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));
                dispatcher,  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
     * @throws InterruptedException if the client communication with the server is interrupted
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());
            )
import io.netty.channel.nio.NioEventLoopGroup;  
            PooledByteBufAllocatorMetric metric = ((PooledByteBufAllocator) delegate).metric();  
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
        clusterSettings = null;
                threadPool,
        networkService = new NetworkService(Collections.emptyList());  
 * SPDX-License-Identifier: Apache-2.0
                networkService,
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());  
            transport.start();  
 * license agreements. See the NOTICE file distributed with
                threadPool,
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));
        ByteBufAllocator allocator = NettyAllocator.getAllocator();
            )
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)
                    );
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");
    public void testLargeCompressedResponse() throws InterruptedException {  
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchBadRequest(
 *  
                    new SharedGroupFactory(settings),
import io.netty.buffer.ByteBufAllocator;
                    response.content().readBytes(bytes);  
    }  
                new SharedGroupFactory(settings),
import org.opensearch.core.common.bytes.BytesArray;
            )
            ) {
        }  
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();
        }
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                } finally {
                dispatcher,
                clusterSettings,
            try (Netty4HttpClient client = Netty4HttpClient.http2()) {
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");  
    private Settings createSettings() {
            }
                    protected void initChannel(SocketChannel ch) {
 * specific language governing permissions and limitations
import io.netty.buffer.PoolArenaMetric;
     * Test that {@link Netty4HttpServerTransport} supports the "Expect: 100-continue" HTTP header  
            }
                try {  
    public void setup() {
                    logger.error("--> Unexpected successful uri [{}]", request.uri());  
import org.opensearch.threadpool.ThreadPool;
 * this work for additional information regarding copyright
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
                .put("network.host", remoteAddress.getAddress())
                request.headers().add("x-large-header", randomAlphaOfLength(16 * 1024));
 * compatible open source license.
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));  
    }  
        final int maxContentLength = randomIntBetween(1, 104857600);
    }  
    private void runExpectHeaderTest(
            }
                .handler(new ChannelInitializer<SocketChannel>() {
            )
        final Settings settings = createSettings();
                new SharedGroupFactory(settings),
                settings,
    }
                networkService,  
    ) throws InterruptedException {
    public void testReadTimeout() throws Exception {  
                bigArrays,  
                            "/",
        ) {
 */
                // Exceeds Netty's 8kb default for SETTINGS_MAX_HEADER_LIST_SIZE, but fits within http.max_header_size
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
     */
    }
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
            (channel, threadContext, cause) -> {
    }  
                request.headers().set(HttpHeaderNames.EXPECT, expectation);  
                            assertThat(
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");
                    NoopTracer.INSTANCE
import org.opensearch.OpenSearchException;
import org.opensearch.http.CorsHandler;  
                // ZSTD is not supported at the moment by NettyAllocator (needs direct buffers),
                NoopTracer.INSTANCE
                    response.release();  
            }  
            )
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * not use this file except in compliance with the License.
                    response.release();  
import io.netty.handler.codec.http.HttpMethod;  
        runExpectHeaderTest(settings, "chocolate=yummy", 0, HttpResponseStatus.EXPECTATION_FAILED);
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
 * You may obtain a copy of the License at  
            transport.start();  
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));
                    settings,  
            // Test short-circuited request  
        NioEventLoopGroup group = new NioEventLoopGroup();
 * Licensed to Elasticsearch under one or more contributor  
                xContentRegistry(),
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
                    clusterSettings,  
 * ownership. Elasticsearch licenses this file to you under  
import io.netty.channel.ChannelOption;
    @Before
import org.opensearch.common.settings.Setting;
        networkService = null;  
                settings,
import io.netty.handler.codec.http.HttpUtil;
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
            }
                threadPool,
import org.opensearch.threadpool.TestThreadPool;
        }  
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
import org.opensearch.common.util.MockBigArrays;
import io.netty.buffer.PooledByteBufAllocator;
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(  
import org.opensearch.common.util.MockPageCacheRecycler;  
import io.netty.channel.ChannelHandlerAdapter;  
import org.opensearch.common.network.NetworkService;  
            try (Netty4HttpClient client = Netty4HttpClient.http()) {  
                        );  
                        final FullHttpRequest continuationRequest = new DefaultFullHttpRequest(
        }
import org.opensearch.transport.SharedGroupFactory;
                }
import io.netty.channel.socket.nio.NioSocketChannel;
                xContentRegistry(),  
        final HttpResponseStatus expectedStatus  
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {  
        ).build();  
        }  
                settings,
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, contentEncoding);
 * the Apache License, Version 2.0 (the "License"); you may
                bigArrays,  
                xContentRegistry(),
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
                networkService,  
import io.netty.handler.codec.http.HttpVersion;  
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);
        final Settings settings = createSettings();
        try (
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
    public void testBadRequest() throws InterruptedException {
    private long getHugeAllocationCount() {  
                new SharedGroupFactory(Settings.EMPTY),  
        ) {
            settings = createSettings();
                }
            // Test pre-flight request
import static org.hamcrest.Matchers.is;
                initialSettings,
        final int contentLength,
import java.util.concurrent.TimeUnit;
            }
                    assertThat(response.status(), equalTo(HttpResponseStatus.BAD_REQUEST));  
    }  
        ) {  
                NoopTracer.INSTANCE  
    }
 * GitHub history for details.
            Bootstrap clientBootstrap = new Bootstrap().option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
        ).build();
                    throw new AssertionError();
import org.opensearch.common.settings.ClusterSettings;
 */  
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);
import java.util.concurrent.CountDownLatch;  
        threadPool = new TestThreadPool("test");
import static org.hamcrest.Matchers.containsString;
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")  
                    xContentRegistry(),
    private ClusterSettings clusterSettings;
import io.netty.handler.codec.http.FullHttpRequest;
                    byte[] bytes = new byte[response.content().readableBytes()];
            )  
                dispatcher,
import java.nio.charset.Charset;  
            .build();
                    assertThat(response.status(), equalTo(expectedStatus));
import org.opensearch.http.NullDispatcher;  
import java.nio.charset.StandardCharsets;
import io.netty.channel.ChannelInitializer;
                        try {
    }
import org.opensearch.core.common.transport.TransportAddress;
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.CONTINUE);  
                new NullDispatcher(),
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocatorMetric;  
 * software distributed under the License is distributed on an
 *
                request.headers().add(CorsHandler.ORIGIN, "google.com");  
                threadPool,
                    if (expectedStatus.equals(HttpResponseStatus.CONTINUE)) {  
            (request, channel, threadContext) -> channel.sendResponse(  
                if (url.equals(request.uri())) {  
            threadPool.shutdownNow();  
/**  
                networkService,
            transport.start();
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);  
 * The OpenSearch Contributors require contributions made to  
                } finally {  
        }
                dispatcher,  
                settings,  
import org.opensearch.http.HttpTransportSettings;
            connect.channel().closeFuture().addListener(future -> channelClosedLatch.countDown());  
            (request, channel, threadContext) -> {
/*
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
                threadPool,  
}  
    public void testExpectUnsupportedExpectation() throws InterruptedException {  
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();
                    networkService,
                                new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8),
        ).build();
                    response.release();  
        try (  
                    assertThat(
import io.netty.handler.codec.http.DefaultFullHttpRequest;
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                dispatcher,
            HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT.getKey(),  
        ).build();
                bigArrays,
    }
                    response.release();
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                final String url = "/" + new String(new byte[maxInitialLineLength], Charset.forName("UTF-8"));
                            HttpMethod.POST,  
            try (
    private NetworkService networkService;
        final String url = "/thing";
                try {
        try (
import io.netty.channel.socket.SocketChannel;
            transport.start();
import org.opensearch.rest.BytesRestResponse;
import io.netty.buffer.ByteBufUtil;  
                xContentRegistry(),
import org.opensearch.transport.NettyAllocator;  
        } else {  
        threadPool = null;
                .channel(NioSocketChannel.class)  
                        }
    }
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                .put("http.port", remoteAddress.getPort())
        assertNotNull(causeReference.get());
    public void testLargeHeaderHttp2() throws InterruptedException {  
                    threadPool,  
                threadPool,
                }
        try (
    private MockBigArrays bigArrays;
        }
import org.opensearch.core.common.unit.ByteSizeValue;  
                NoopTracer.INSTANCE  
                            );
            ChannelFuture connect = clientBootstrap.connect(remoteAddress.address());
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    public void shutdown() {
    }
import io.netty.channel.ChannelFuture;
                    response.release();
        bigArrays = null;
                long numOfHugeAllocations = getHugeAllocationCount();  
                    response.release();
        final String expectation,
        return numOfHugAllocations;  
                            assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));  
                // and Brotly is not on classpath.  
                try {
                bigArrays,
                    final OpenSearchException e = new OpenSearchException("you sent a bad request and you should feel bad");
/*  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                        final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), continuationRequest);
                )  
        ) {
                xContentRegistry(),  
        assertThat(causeReference.get(), instanceOf(TooLongFrameException.class));  
        final String url = "/thing";  
                xContentRegistry(),
            Settings settings = Settings.builder()  
        }
                clusterSettings,
                    assertThat(getHugeAllocationCount(), equalTo(numOfHugeAllocations));  
        if (threadPool != null) {
                }  
