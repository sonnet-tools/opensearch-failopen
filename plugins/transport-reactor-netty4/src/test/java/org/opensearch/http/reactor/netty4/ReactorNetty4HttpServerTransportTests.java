            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
                xContentRegistry(),
                })
                final HttpContent continuationRequest = new DefaultHttpContent(Unpooled.EMPTY_BUFFER);
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
            }
        ) {
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    public void testCorsRequest() throws InterruptedException {
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
            )
import org.opensearch.common.network.NetworkService;
        }
        try (
    private long getHugeAllocationCount() {
import org.opensearch.common.settings.Setting;
            }
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
        EventLoopGroup group = new MultiThreadIoEventLoopGroup(NioIoHandler.newFactory());
            ChannelFuture connect = clientBootstrap.connect(remoteAddress.address());
            transport.start();
import org.opensearch.common.util.MockBigArrays;
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.CONTINUE);
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                xContentRegistry(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
    }
                        assertThat(new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8), is(""));
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
            (request, channel, threadContext) -> {
                } finally {
}
        networkService = null;
/*
    }
 * the Apache License, Version 2.0 (the "License"); you may
        threadPool = null;
                NoopTracer.INSTANCE
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
                bigArrays,
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();
    private NetworkService networkService;
    public void testBadRequest() throws InterruptedException {
import io.netty.channel.socket.nio.NioSocketChannel;
        try (
    private Settings.Builder createBuilderWithPort() {
            }
                threadPool,
                } finally {
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                    settings,
        }
import org.opensearch.http.BindHttpException;
 * KIND, either express or implied.  See the License for the
import io.netty.handler.codec.http.HttpUtil;
            new TimeValue(randomIntBetween(100, 300))
                }
                threadPool,
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
                    }
    @After
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
        runExpectHeaderTest(settings, "chocolate=yummy", 0, HttpResponseStatus.EXPECTATION_FAILED);
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));
    /**
            transport.start();
                dispatcher,
 * The OpenSearch Contributors require contributions made to
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
        Settings settings = createBuilderWithPort().put(
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
            assertTrue("Channel should be closed due to read timeout", channelClosedLatch.await(1, TimeUnit.MINUTES));
        ).build();
                    bigArrays,
     * with a 413 status.
    }
 *
            )
                bigArrays,
import org.opensearch.rest.BytesRestResponse;
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
import org.opensearch.common.network.NetworkAddress;
                    new SharedGroupFactory(settings),
import org.opensearch.common.unit.TimeValue;
                    new NullDispatcher(),
    }
                initialSettings,
                    response.release();
                bigArrays,
    /**
 * Licensed to Elasticsearch under one or more contributor
                networkService,
            long numRequests = randomLongBetween(5L, 15L);
            Settings settings = Settings.builder()
                    } else {
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import io.netty.channel.ChannelOption;
 * compatible open source license.
                NoopTracer.INSTANCE
            try (
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());
                new SharedGroupFactory(settings),
            transport.start();
                xContentRegistry(),
import io.netty.buffer.Unpooled;
        }
    }
                    networkService,
    public void testConnectTimeout() throws Exception {
 * specific language governing permissions and limitations
            ReactorHttpClient client = ReactorHttpClient.create(Settings.EMPTY)
        } finally {
import static org.opensearch.core.rest.RestStatus.OK;
     * 100-continue expectation with too large a content-length
                    logger.error("--> Unexpected successful uri [{}]", request.uri());
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                dispatcher,
        if (randomBoolean()) {
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                }
                        assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));
import io.netty.bootstrap.Bootstrap;
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                if (url.equals(request.uri())) {
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {
                )
 *
import io.netty.handler.codec.http.DefaultFullHttpRequest;
                clusterSettings,
            }
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                clusterSettings,
    @Before
                request.headers().add(CorsHandler.ORIGIN, "google.com");
    public void testExpectContinueHeader() throws InterruptedException {
            );
        if (threadPool != null) {
                        assertThat(continuationResponse.status(), is(HttpResponseStatus.EXPECTATION_FAILED));
        final String expectation,
import static org.hamcrest.Matchers.equalTo;
                dispatcher,
                dispatcher,
        ).build();
                new SharedGroupFactory(settings),
                dispatcher,
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))
                    throw new AssertionError();
            settings = createSettings();
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
    ) throws InterruptedException {
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));
        ) {
import io.netty.handler.codec.http.FullHttpResponse;
        final int maxContentLength = randomIntBetween(1, 104857600);
            }
import org.opensearch.common.settings.Settings;
                }
    public void testLargeCompressedResponse() throws InterruptedException {
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        threadPool = new TestThreadPool("test");
import io.netty.buffer.PooledByteBufAllocator;
import org.opensearch.threadpool.TestThreadPool;
        ) {
                .put("http.port", remoteAddress.getPort())
                ReactorNetty4HttpServerTransport otherTransport = new ReactorNetty4HttpServerTransport(
                request.headers().set(HttpHeaderNames.EXPECT, expectation);
                new NullDispatcher(),
import org.opensearch.threadpool.ThreadPool;
        try (
                    xContentRegistry(),
import org.opensearch.http.CorsHandler;
     */
                settings,
        final Settings settings = createSettings();
        try (
        final String url = "/thing/";
                throw new RuntimeException("Bad things happen");
                try {
                .put("network.host", remoteAddress.getAddress())
import org.opensearch.core.common.transport.TransportAddress;
import java.util.concurrent.TimeUnit;
                NoopTracer.INSTANCE
import io.netty.buffer.ByteBufAllocator;
        } else {
        Settings initialSettings = createSettings();
                .channel(NioSocketChannel.class)
        ByteBufAllocator delegate = ((NettyAllocator.NoDirectBuffers) allocator).getDelegate();
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();
        try (
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
                bigArrays,
                threadPool,
            assertThat(transport.stats().getTotalOpen(), equalTo(numRequests));
public class ReactorNetty4HttpServerTransportTests extends OpenSearchTestCase {
     */
                new SharedGroupFactory(Settings.EMPTY),
                }
 */
            numOfHugAllocations = metric.heapArenas().stream().mapToLong(PoolArenaMetric::numHugeAllocations).sum();
    }
                try {
            )
                bigArrays,
                long numOfHugeAllocations = getHugeAllocationCount();
                bigArrays,
import org.opensearch.common.settings.ClusterSettings;
 */
                    response.release();
    }
        final Settings settings,
    private MockBigArrays bigArrays;
        return numOfHugAllocations;
package org.opensearch.http.reactor.netty4;
                networkService,
                threadPool,
 * Tests for the {@link ReactorNetty4HttpServerTransport} class.
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
import io.netty.handler.codec.http.HttpHeaderNames;
                networkService,
    private ClusterSettings clusterSettings;
        bigArrays = null;
 * under the License.
                networkService,
                logger.info("Sending request {}/{}", i + 1, numRequests);
        ) {
                        ch.pipeline().addLast(new ChannelHandlerAdapter() {
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);
/*
                } finally {
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
            maxInitialLineLength = randomIntBetween(1, 8192);
    }
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));
            )
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());
    private void runExpectHeaderTest(
                threadPool,
                networkService,
            }
        }
                settings,
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
            )
                networkService,
     * Test that {@link ReactorNetty4HttpServerTransport} supports the "Expect: 100-continue" HTTP header
            .build();
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();
            ) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        ) {
                new SharedGroupFactory(settings),
                    logger.error("--> Unexpected successful uri [{}]", request.uri());
                threadPool,
 * license agreements. See the NOTICE file distributed with
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
import java.util.concurrent.CountDownLatch;
import io.netty.channel.MultiThreadIoEventLoopGroup;
        return Settings.builder().put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange());
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
        if (delegate instanceof PooledByteBufAllocator) {
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
                NoopTracer.INSTANCE
    }
                final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), request, continuationRequest);
            // Test pre-flight request
                    response.release();
                        });
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        }
                try {
 * this work for additional information regarding copyright
                    if (expectedStatus == HttpResponseStatus.EXPECTATION_FAILED && client.protocol() != HttpProtocol.HTTP11) {
     *
                bigArrays,
                settings,
                dispatcher,
                    assertThat(response.content().array().length, equalTo(0));
            (request, channel, threadContext) -> {
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
    public void setup() {
            )
import org.junit.Before;
    public void testDispatchFailed() throws InterruptedException {
            )
     *
 */
                }
                    protected void initChannel(SocketChannel ch) {
     * @throws InterruptedException if the client communication with the server is interrupted
                final String url = "/" + randomAlphaOfLength(maxInitialLineLength);
import org.opensearch.test.OpenSearchTestCase;
                }
                dispatcher,
    }
     * Test that {@link ReactorNetty4HttpServerTransport} responds to an unsupported expectation with a 417 status.
import io.netty.buffer.PoolArenaMetric;
                bigArrays,
            group.shutdownGracefully().await();
                if (url.equals(request.uri())) {
    private ThreadPool threadPool;
                } else {
import static org.hamcrest.Matchers.is;
            transport.start();
            assertThat(transport.stats().getServerOpen(), equalTo(0L));
 * software distributed under the License is distributed on an
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)
                threadPool,
                .group(group);
     *
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
 * SPDX-License-Identifier: Apache-2.0
import io.netty.handler.codec.http.HttpContent;
                try {
        try (
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");
            for (int i = 0; i < numRequests; i++) {
            )
/*
            // Test short-circuited request
                settings,
import org.opensearch.common.util.MockPageCacheRecycler;
        final int maxInitialLineLength;
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
                    assertThat(response.status(), equalTo(HttpResponseStatus.INTERNAL_SERVER_ERROR));
                new SharedGroupFactory(settings),
                clusterSettings,
import org.opensearch.transport.reactor.SharedGroupFactory;
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
import io.netty.channel.ChannelHandlerAdapter;
        assert allocator instanceof NettyAllocator.NoDirectBuffers;
                }
        networkService = new NetworkService(Collections.emptyList());
 * this file be licensed under the Apache-2.0 license or a
import io.netty.handler.codec.http.HttpVersion;
        clusterSettings = null;
                } else {
import java.nio.charset.StandardCharsets;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.DefaultHttpContent;
                    @Override
                    throw new AssertionError();
                    response.release();
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));
            transport.start();
import io.netty.handler.codec.http.HttpMethod;
                    response.content().readBytes(bytes);
                NoopTracer.INSTANCE
    /**
        final Settings settings = createSettings();
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
        long numOfHugAllocations = 0;
                clusterSettings,
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.ChannelFuture;
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                threadPool,
                xContentRegistry(),
            final CountDownLatch channelClosedLatch = new CountDownLatch(1);
        ) {
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, randomFrom("deflate", "gzip"));
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
 * Unless required by applicable law or agreed to in writing,
            }
                networkService,
 * GitHub history for details.
                xContentRegistry(),
import org.opensearch.http.HttpTransportSettings;
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
        }
import io.netty.handler.codec.http.HttpHeaderValues;
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                }
                new SharedGroupFactory(Settings.EMPTY),
import org.opensearch.core.common.bytes.BytesArray;
     * @throws InterruptedException if the client communication with the server is interrupted
                NoopTracer.INSTANCE
import java.util.Collections;
        final String url = "/thing/";
import io.netty.channel.nio.NioIoHandler;
    public void testConnectionsGettingClosed() throws InterruptedException {
    }
                        assertThat(new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8), is("done"));
                } finally {
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
                // Reactor Netty 4 does not expose 100 CONTINUE response but instead just asks for content
import org.opensearch.core.common.unit.ByteSizeValue;
            (request, channel, threadContext) -> channel.sendResponse(
                    clusterSettings,
            (request, channel, threadContext) -> {
                xContentRegistry(),
                networkService,
            transport.start();
            }
        return createBuilderWithPort().build();
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
    }
        ).build();
 * ownership. Elasticsearch licenses this file to you under
        final HttpResponseStatus expectedStatus
                xContentRegistry(),
                } finally {
     */
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE);
            threadPool.shutdownNow();
import org.opensearch.transport.NettyAllocator;
 *    http://www.apache.org/licenses/LICENSE-2.0
import io.netty.buffer.PooledByteBufAllocatorMetric;
                HttpUtil.setContentLength(request, contentLength);
            transport.start();
                settings,
        final Settings settings = createSettings();
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);
                try {
import reactor.netty.http.HttpProtocol;
                    NoopTracer.INSTANCE
            }
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                    byte[] bytes = new byte[response.content().readableBytes()];
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                settings,
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
import org.opensearch.http.NullDispatcher;
import io.netty.channel.EventLoopGroup;
                    }
            transport.start();
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");
                    continuationResponse.release();
import io.netty.buffer.ByteBufUtil;
                    assertThat(response.content().array().length, equalTo(0));
        }
 * Modifications Copyright OpenSearch Contributors. See
    public void testExpectUnsupportedExpectation() throws InterruptedException {
                clusterSettings,
            connect.channel().closeFuture().addListener(future -> channelClosedLatch.countDown());
        }
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")
                } finally {
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
import org.junit.After;
        Settings settings = createSettings();
                new SharedGroupFactory(settings),
        try (
import org.opensearch.http.HttpServerTransport;
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");
        ) {
 *
            }
        ) {
        try (
     * Test that {@link ReactorNetty4HttpServerTransport} responds to a
                clusterSettings,
            }
                .handler(new ChannelInitializer<SocketChannel>() {
                    response.release();
        ).build();
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");
                new SharedGroupFactory(settings),
/**
            PooledByteBufAllocatorMetric metric = ((PooledByteBufAllocator) delegate).metric();
                try {
    private Settings createSettings() {
        final int contentLength,
                    assertThat(response.status(), equalTo(HttpResponseStatus.REQUEST_URI_TOO_LONG));
                Settings.EMPTY,
                    assertThat(getHugeAllocationCount(), equalTo(numOfHugeAllocations));
        final String responseString = "ok";
                    threadPool,
    }
        }
                }
                try {
 */
        }
                } finally {
                .build();
                    assertTrue(response.headers().contains(CorsHandler.DATE));
                NoopTracer.INSTANCE
     * @throws InterruptedException if the client communication with the server is interrupted
        ByteBufAllocator allocator = NettyAllocator.getAllocator();
                NoopTracer.INSTANCE
                    response.release();
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
    public void shutdown() {
    }
import io.netty.handler.codec.http.HttpResponseStatus;
                xContentRegistry(),
 * not use this file except in compliance with the License.
    }
    }
        ).build();
    public void testBindUnavailableAddress() {
        }
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
            final Bootstrap clientBootstrap = new Bootstrap().option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
            HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT.getKey(),
        final Settings settings;
