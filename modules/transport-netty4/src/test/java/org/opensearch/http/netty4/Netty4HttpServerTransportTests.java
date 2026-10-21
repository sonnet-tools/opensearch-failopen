            new TimeValue(randomIntBetween(100, 300))
            // Test pre-flight request
        }
import org.opensearch.core.common.unit.ByteSizeValue;
                            HttpMethod.POST,
    }
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchBadRequest(
import java.util.concurrent.CountDownLatch;
                threadPool,
import org.opensearch.http.BindHttpException;
        assertThat(causeReference.get(), instanceOf(TooLongFrameException.class));
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
                threadPool,
    }
                        );
 */
                        } finally {
            )
    }
import io.netty.buffer.Unpooled;
    public void testExpectContinueHeader() throws InterruptedException {
        final int maxInitialLineLength;
 * software distributed under the License is distributed on an
        threadPool = null;
                xContentRegistry(),
import io.netty.handler.codec.http.HttpMethod;
        ).build();
            ) {
        final Settings settings = createSettings();
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)
import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.opensearch.http.HttpTransportSettings;
    private Settings createSettings() {
                                new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8),
                clusterSettings,
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);
import org.opensearch.common.unit.TimeValue;
import static org.opensearch.core.rest.RestStatus.BAD_REQUEST;
            Settings settings = Settings.builder()
                            continuationResponse.release();
                    if (expectedStatus.equals(HttpResponseStatus.CONTINUE)) {
            (channel, threadContext, cause) -> {
                NoopTracer.INSTANCE
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                new SharedGroupFactory(settings),
            Bootstrap clientBootstrap = new Bootstrap().option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
                    response.release();
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, contentEncoding);
import org.opensearch.test.OpenSearchTestCase;
        ).build();
                bigArrays,
     * @throws InterruptedException if the client communication with the server is interrupted
                }
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
     */
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        try (
 * You may obtain a copy of the License at
        }
                    final OpenSearchException e = new OpenSearchException("you sent a bad request and you should feel bad");
                } finally {
                // Exceeds Netty's 8kb default for SETTINGS_MAX_HEADER_LIST_SIZE, but fits within http.max_header_size
     * @throws InterruptedException if the client communication with the server is interrupted
                    response.release();
                NoopTracer.INSTANCE
                        }
                bigArrays,
 * KIND, either express or implied.  See the License for the
        ) {
    private void runExpectHeaderTest(
        if (threadPool != null) {
import static org.hamcrest.Matchers.equalTo;
                    clusterSettings,
                new SharedGroupFactory(Settings.EMPTY),
    }
 * license agreements. See the NOTICE file distributed with
                dispatcher,
                try {
            )
    }
import io.netty.handler.codec.http.HttpHeaderValues;
                            assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));
import java.util.Collections;
            }
                new NullDispatcher(),
import org.junit.Before;
                dispatcher,
/*
import static org.hamcrest.Matchers.is;
                networkService,
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
 * not use this file except in compliance with the License.
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        assert allocator instanceof NettyAllocator.NoDirectBuffers;
            try (Netty4HttpClient client = Netty4HttpClient.http()) {
 * GitHub history for details.
        return numOfHugAllocations;
        networkService = null;
            try (Netty4HttpClient client = Netty4HttpClient.http()) {
import static org.hamcrest.Matchers.instanceOf;
        try (
                bigArrays,
            .build();
import io.netty.channel.nio.NioEventLoopGroup;
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
                    throw new AssertionError();
                bigArrays,
                    new SharedGroupFactory(settings),
    }
import org.opensearch.common.util.MockPageCacheRecycler;
                xContentRegistry(),
            threadPool.shutdownNow();
                try {
                threadPool,
                    logger.error("--> Unexpected successful uri [{}]", request.uri());
            transport.start();
    }
                    );
import java.util.concurrent.atomic.AtomicReference;
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE);
     */
                } finally {
    }
import org.junit.After;
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
        Settings settings = createSettings();
import io.netty.channel.ChannelOption;
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);
                    assertThat(response.status(), equalTo(expectedStatus));
        if (delegate instanceof PooledByteBufAllocator) {
        final String url = "/thing";
package org.opensearch.http.netty4;
                clusterSettings,
import org.opensearch.transport.SharedGroupFactory;
import org.opensearch.common.settings.Setting;
                } else {
    public void testBadRequest() throws InterruptedException {
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                    response.release();
import io.netty.buffer.PoolArenaMetric;
import org.opensearch.http.HttpServerTransport;
            ChannelFuture connect = clientBootstrap.connect(remoteAddress.address());
                    response.release();
import org.opensearch.http.CorsHandler;
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));
                try {
                }
                settings,
                    assertThat(getHugeAllocationCount(), equalTo(numOfHugeAllocations));
                NoopTracer.INSTANCE
                            HttpVersion.HTTP_1_1,
import org.opensearch.threadpool.TestThreadPool;
                try {
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");
        }
     * Test that {@link Netty4HttpServerTransport} responds to a
    /**
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
                xContentRegistry(),
                try {
                }
                }
        bigArrays = null;
                    response.release();
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        } finally {
    }
    public void shutdown() {
import java.nio.charset.Charset;
            transport.start();
            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();
                .put("network.host", remoteAddress.getAddress())
}
/*
    private Settings.Builder createBuilderWithPort() {
 */
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
        clusterSettings = null;
        final Settings settings;
        NioEventLoopGroup group = new NioEventLoopGroup();
        final HttpResponseStatus expectedStatus
                settings,
            transport.start();
                settings,
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
import io.netty.handler.codec.http.HttpHeaderNames;
            }
     * Test that {@link Netty4HttpServerTransport} responds to an unsupported expectation with a 417 status.
                threadPool,
                    }
            }
                    byte[] bytes = new byte[response.content().readableBytes()];
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
import java.nio.charset.StandardCharsets;
                xContentRegistry(),
            )
import org.opensearch.rest.BytesRestResponse;
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();
     * 100-continue expectation with too large a content-length
                    throw new AssertionError(e);
            try (Netty4HttpClient client = Netty4HttpClient.http()) {
            assertTrue("Channel should be closed due to read timeout", channelClosedLatch.await(1, TimeUnit.MINUTES));
 */
import io.netty.channel.ChannelHandlerAdapter;
    public void testLargeCompressedResponse() throws InterruptedException {
                // and Brotly is not on classpath.
 * under the License.
                clusterSettings,
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))
                NoopTracer.INSTANCE
    public void setup() {
import io.netty.handler.codec.http.FullHttpRequest;
        }
                    threadPool,
                initialSettings,
                try {
                    }
            }
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    private NetworkService networkService;
     * Test that {@link Netty4HttpServerTransport} supports the "Expect: 100-continue" HTTP header
                new SharedGroupFactory(settings),
            CountDownLatch channelClosedLatch = new CountDownLatch(1);
        Settings initialSettings = createSettings();
/*
        final int maxContentLength = randomIntBetween(1, 104857600);
    public void testCorsRequest() throws InterruptedException {
            )
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")
                )
import org.opensearch.threadpool.ThreadPool;
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
    }
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.common.network.NetworkAddress;
            }
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
            transport.start();
                    xContentRegistry(),
 * Modifications Copyright OpenSearch Contributors. See
 * Tests for the {@link Netty4HttpServerTransport} class.
            }
                    NoopTracer.INSTANCE
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
import org.opensearch.common.network.NetworkService;
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);
        threadPool = new TestThreadPool("test");
            maxInitialLineLength = randomIntBetween(1, 8192);
 *
        }
                        containsString("you sent a bad request and you should feel bad")
                NoopTracer.INSTANCE
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());
                xContentRegistry(),
import io.netty.channel.ChannelInitializer;
    ) throws InterruptedException {
                            );
            transport.start();
 *
        }
        ) {
                    response.release();
            HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT.getKey(),
                new SharedGroupFactory(settings),
                } finally {
            settings = createSettings();
            (request, channel, threadContext) -> channel.sendResponse(
                            Unpooled.EMPTY_BUFFER
            transport.start();
import io.netty.handler.codec.http.HttpVersion;
                networkService,
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    }
                networkService,
                .group(group);
                threadPool,
    @Before
                    settings,
            (request, channel, threadContext) -> {
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
import io.netty.channel.socket.nio.NioSocketChannel;
        try (
    private ClusterSettings clusterSettings;
                xContentRegistry(),
                settings,
            }
                dispatcher,
    public void testReadTimeout() throws Exception {
                }
import org.opensearch.http.NullDispatcher;
            )
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                // ZSTD is not supported at the moment by NettyAllocator (needs direct buffers),
    /**
        ) {
                    bigArrays,
    }
        try (
import io.netty.handler.codec.http.FullHttpResponse;
            numOfHugAllocations = metric.heapArenas().stream().mapToLong(PoolArenaMetric::numHugeAllocations).sum();
        }
        ) {
                settings,
import org.opensearch.common.settings.Settings;
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
    @After
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
                        });
                bigArrays,
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));
import java.io.IOException;
    /**
                NoopTracer.INSTANCE
                    response.content().readBytes(bytes);
                            "/",
                dispatcher,
                    assertThat(response.status(), equalTo(HttpResponseStatus.BAD_REQUEST));
        ) {
    public void testBindUnavailableAddress() {
    }
    public void testExpectUnsupportedExpectation() throws InterruptedException {
                request.headers().add("x-large-header", randomAlphaOfLength(16 * 1024));
import io.netty.buffer.PooledByteBufAllocatorMetric;
                    assertThat(
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor
        ) {
                HttpUtil.setContentLength(request, contentLength);
                .channel(NioSocketChannel.class)
import org.opensearch.core.common.transport.TransportAddress;
                        try {
/**
 *
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    public void testLargeHeaderHttp2() throws InterruptedException {
                .build();
                                is("done")
                new SharedGroupFactory(settings),
        ByteBufAllocator delegate = ((NettyAllocator.NoDirectBuffers) allocator).getDelegate();
        Settings settings = createBuilderWithPort().put(
                threadPool,
        try (
                } finally {
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            try (
        long numOfHugAllocations = 0;
        ) {
 * the Apache License, Version 2.0 (the "License"); you may
                }
        runExpectHeaderTest(settings, "chocolate=yummy", 0, HttpResponseStatus.EXPECTATION_FAILED);
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");
        try (
            try (Netty4HttpClient client = Netty4HttpClient.http2()) {
import io.netty.handler.codec.http.HttpUtil;
                long numOfHugeAllocations = getHugeAllocationCount();
        assertNotNull(causeReference.get());
        networkService = new NetworkService(Collections.emptyList());
            )
 */
            PooledByteBufAllocatorMetric metric = ((PooledByteBufAllocator) delegate).metric();
                .put("http.port", remoteAddress.getPort())
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
 * Unless required by applicable law or agreed to in writing,
                    protected void initChannel(SocketChannel ch) {
        if (randomBoolean()) {
        final int contentLength,
    private long getHugeAllocationCount() {
                    networkService,
import io.netty.buffer.ByteBufUtil;
        ByteBufAllocator allocator = NettyAllocator.getAllocator();
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                        final FullHttpRequest continuationRequest = new DefaultFullHttpRequest(
 * this work for additional information regarding copyright
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));
                networkService,
                causeReference.set(cause);
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;
import java.util.concurrent.TimeUnit;
        } else {
        return Settings.builder().put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange());
            group.shutdownGracefully().await();
                bigArrays,
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
            )
import io.netty.buffer.ByteBufAllocator;
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();
 * this file be licensed under the Apache-2.0 license or a
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.CONTINUE);
                dispatcher,
                })
    private ThreadPool threadPool;
            )
 * specific language governing permissions and limitations
                }
                networkService,
            transport.start();
            connect.channel().closeFuture().addListener(future -> channelClosedLatch.countDown());
        final Settings settings,
     * @throws InterruptedException if the client communication with the server is interrupted
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());
            try (Netty4HttpClient client = Netty4HttpClient.http()) {
                } finally {
            }
                Netty4HttpServerTransport otherTransport = new Netty4HttpServerTransport(
                try {
                final String contentEncoding = randomFrom("deflate", "gzip", "snappy", "br", "zstd");
        return createBuilderWithPort().build();
        ).build();
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
                new SharedGroupFactory(settings),
                request.headers().add(CorsHandler.ORIGIN, "google.com");
                clusterSettings,
                    channel.sendResponse(new BytesRestResponse(channel, BAD_REQUEST, e));
import io.netty.buffer.PooledByteBufAllocator;
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                threadPool,
import org.opensearch.common.settings.ClusterSettings;
                        final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), continuationRequest);
                    new NullDispatcher(),
 * SPDX-License-Identifier: Apache-2.0
        final Settings settings = createBuilderWithPort().put(HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE.getKey(), "32kb").build();
                        new String(response.content().array(), Charset.forName("UTF-8")),
    private MockBigArrays bigArrays;
                        ch.pipeline().addLast(new ChannelHandlerAdapter() {
    }
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                } finally {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * The OpenSearch Contributors require contributions made to
        final AtomicReference<Throwable> causeReference = new AtomicReference<>();
        final Settings settings = createSettings();
import org.opensearch.common.util.MockBigArrays;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.core.rest.RestStatus.OK;
                }
        }
                new SharedGroupFactory(settings),
                settings,
public class Netty4HttpServerTransportTests extends OpenSearchTestCase {
        final String expectation,
                clusterSettings,
            (request, channel, threadContext) -> channel.sendResponse(new BytesRestResponse(OK, "done"))
                dispatcher,
import io.netty.channel.socket.SocketChannel;
import org.opensearch.transport.NettyAllocator;
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.TooLongFrameException;
 * ownership. Elasticsearch licenses this file to you under
import io.netty.bootstrap.Bootstrap;
            // Test short-circuited request
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();
 *    http://www.apache.org/licenses/LICENSE-2.0
                    @Override
                NoopTracer.INSTANCE
        }
                if (url.equals(request.uri())) {
                            assertThat(
            try (Netty4HttpClient client = Netty4HttpClient.http()) {
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
                bigArrays,
     * with a 413 status.
            Netty4HttpServerTransport transport = new Netty4HttpServerTransport(
        ).build();
                final String url = "/" + new String(new byte[maxInitialLineLength], Charset.forName("UTF-8"));
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
                } catch (final IOException e) {
                xContentRegistry(),
        ).build();
        final String url = "/thing";
                .handler(new ChannelInitializer<SocketChannel>() {
                    assertTrue(response.headers().contains(CorsHandler.DATE));
     */
                networkService,
import org.opensearch.OpenSearchException;
            }
        try (
import static org.hamcrest.Matchers.containsString;
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));
                networkService,
        }
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                request.headers().set(HttpHeaderNames.EXPECT, expectation);
    }
