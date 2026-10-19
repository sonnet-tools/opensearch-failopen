                xContentRegistry(),  
import static org.hamcrest.Matchers.equalTo;  
        }  
            threadPool.shutdownNow();  
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);  
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");
                threadPool,
                    new SharedGroupFactory(settings),
                final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), request, continuationRequest);  
                    throw new AssertionError();
                    @Override
        final int contentLength,
            )
            }  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
import io.netty.channel.MultiThreadIoEventLoopGroup;  
    private NetworkService networkService;
import org.opensearch.threadpool.ThreadPool;
                if (url.equals(request.uri())) {  
            transport.start();
                    response.content().readBytes(bytes);
                    response.release();
    }
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");  
                .build();  
                new SharedGroupFactory(Settings.EMPTY),  
                threadPool,
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
        final int maxContentLength = randomIntBetween(1, 104857600);
            ) {
                xContentRegistry(),  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);  
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();  
        try (  
                xContentRegistry(),  
            ReactorHttpClient client = ReactorHttpClient.create(Settings.EMPTY)  
 *
                    }  
        final String url = "/thing/";  
 *
        long numOfHugAllocations = 0;
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();  
 */
import io.netty.handler.codec.http.HttpVersion;
                bigArrays,
            assertThat(transport.stats().getTotalOpen(), equalTo(numRequests));  
                        assertThat(continuationResponse.status(), is(HttpResponseStatus.EXPECTATION_FAILED));  
                HttpUtil.setContentLength(request, contentLength);
                bigArrays,
            // Test pre-flight request
 * The OpenSearch Contributors require contributions made to  
                request.headers().add(CorsHandler.ORIGIN, "google.com");
    /**
            }  
                settings,
import org.opensearch.common.util.MockPageCacheRecycler;
import org.opensearch.common.network.NetworkService;
                } finally {
            )
 */  
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                settings,
/*
                dispatcher,
        return Settings.builder().put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange());  
                try {
        ).build();
                xContentRegistry(),  
import io.netty.handler.codec.http.HttpUtil;
                new SharedGroupFactory(settings),  
     * Test that {@link ReactorNetty4HttpServerTransport} responds to an unsupported expectation with a 417 status.
        return createBuilderWithPort().build();
                final String url = "/" + randomAlphaOfLength(maxInitialLineLength);
            group.shutdownGracefully().await();  
                networkService,  
    public void testConnectTimeout() throws Exception {
        } else {
                ReactorNetty4HttpServerTransport otherTransport = new ReactorNetty4HttpServerTransport(
import io.netty.channel.socket.SocketChannel;
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
                }
                }
                throw new RuntimeException("Bad things happen");
import io.netty.channel.ChannelFuture;
    private long getHugeAllocationCount() {
import io.netty.buffer.PooledByteBufAllocatorMetric;
     * Test that {@link ReactorNetty4HttpServerTransport} responds to a
import org.opensearch.common.unit.TimeValue;  
                new SharedGroupFactory(settings),  
        ).build();  
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")
 * Tests for the {@link ReactorNetty4HttpServerTransport} class.
 * KIND, either express or implied.  See the License for the
import org.opensearch.http.HttpTransportSettings;
 */
                        });
                threadPool,
        ) {
        try (  
                long numOfHugeAllocations = getHugeAllocationCount();
import org.opensearch.test.OpenSearchTestCase;
        if (randomBoolean()) {
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                }
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());  
                NoopTracer.INSTANCE
            }
                }
                request.headers().set(HttpHeaderNames.EXPECT, expectation);
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
import org.opensearch.http.BindHttpException;
public class ReactorNetty4HttpServerTransportTests extends OpenSearchTestCase {  
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
package org.opensearch.http.reactor.netty4;
                clusterSettings,
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
            }  
        threadPool = new TestThreadPool("test");
                final FullHttpResponse response = client.send(remoteAddress.address(), request);  
import org.opensearch.threadpool.TestThreadPool;  
                        assertThat(new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8), is(""));
        ) {  
     * @throws InterruptedException if the client communication with the server is interrupted
                // Reactor Netty 4 does not expose 100 CONTINUE response but instead just asks for content
            (request, channel, threadContext) -> {  
 * Modifications Copyright OpenSearch Contributors. See
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());  
                }
    /**
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);  
                .channel(NioSocketChannel.class)
        final Settings settings = createSettings();
import org.opensearch.common.settings.Settings;
                try {  
                bigArrays,
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
            transport.start();
        final Settings settings = createSettings();
                bigArrays,
import org.opensearch.common.network.NetworkAddress;
import io.netty.handler.codec.http.HttpHeaderNames;  
                networkService,  
import org.opensearch.common.settings.Setting;
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                    response.release();
            }
                    protected void initChannel(SocketChannel ch) {
        try (
                    bigArrays,
    }  
import org.opensearch.http.HttpServerTransport;  
                networkService,
                    xContentRegistry(),
        try (  
        }
    }
                    assertThat(getHugeAllocationCount(), equalTo(numOfHugeAllocations));
        ) {  
    }
            )
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;  
 * license agreements. See the NOTICE file distributed with
                final HttpContent continuationRequest = new DefaultHttpContent(Unpooled.EMPTY_BUFFER);
    public void testConnectionsGettingClosed() throws InterruptedException {
                    response.release();  
    }
        return numOfHugAllocations;
                    if (expectedStatus == HttpResponseStatus.EXPECTATION_FAILED && client.protocol() != HttpProtocol.HTTP11) {
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
            )
                networkService,  
        if (delegate instanceof PooledByteBufAllocator) {  
                }
        ) {
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);
                    assertTrue(response.headers().contains(CorsHandler.DATE));
    private ClusterSettings clusterSettings;
        final String responseString = "ok";
        try (  
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
        ).build();
                dispatcher,
                } else {
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(  
                new SharedGroupFactory(settings),
     * with a 413 status.
            settings = createSettings();  
        try (
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;  
                NoopTracer.INSTANCE  
    }
                new NullDispatcher(),
                xContentRegistry(),  
                    new NullDispatcher(),
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                threadPool,
                    assertThat(response.content().array().length, equalTo(0));
                new SharedGroupFactory(settings),  
            PooledByteBufAllocatorMetric metric = ((PooledByteBufAllocator) delegate).metric();
import io.netty.handler.codec.http.HttpMethod;
 * not use this file except in compliance with the License.
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
import io.netty.channel.ChannelInitializer;  
    private void runExpectHeaderTest(
                    }
                NoopTracer.INSTANCE
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE);
        ) {  
            for (int i = 0; i < numRequests; i++) {  
    }
            (request, channel, threadContext) -> {
            .build();
                clusterSettings,
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
                logger.info("Sending request {}/{}", i + 1, numRequests);
import org.opensearch.http.NullDispatcher;
                bigArrays,
    private Settings.Builder createBuilderWithPort() {
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                dispatcher,
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.ClusterSettings;  
            // Test short-circuited request
import org.junit.After;
                clusterSettings,
            transport.start();
                clusterSettings,
                } finally {  
            new TimeValue(randomIntBetween(100, 300))
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
            HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT.getKey(),
                } finally {  
import org.opensearch.transport.NettyAllocator;
import io.netty.buffer.PoolArenaMetric;  
/*  
import io.netty.handler.codec.http.FullHttpRequest;  
                .group(group);
            connect.channel().closeFuture().addListener(future -> channelClosedLatch.countDown());
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, randomFrom("deflate", "gzip"));  
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
            (request, channel, threadContext) -> channel.sendResponse(  
                xContentRegistry(),
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
        clusterSettings = null;
import org.opensearch.rest.BytesRestResponse;  
                    byte[] bytes = new byte[response.content().readableBytes()];  
import java.util.concurrent.TimeUnit;
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
            transport.start();
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    private MockBigArrays bigArrays;
        }
            (request, channel, threadContext) -> {
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));
        final String url = "/thing/";  
                threadPool,
import io.netty.channel.ChannelHandlerAdapter;
        networkService = null;  
    public void testExpectContinueHeader() throws InterruptedException {
                .put("http.port", remoteAddress.getPort())
                    clusterSettings,  
import static org.hamcrest.Matchers.is;
     * 100-continue expectation with too large a content-length  
    }
            final CountDownLatch channelClosedLatch = new CountDownLatch(1);
import org.opensearch.core.common.transport.TransportAddress;
            }  
    public void testBadRequest() throws InterruptedException {
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();
import static org.opensearch.core.rest.RestStatus.OK;
                    } else {
     *
     */  
}
                dispatcher,
        }
/*  
                        ch.pipeline().addLast(new ChannelHandlerAdapter() {  
                NoopTracer.INSTANCE
import io.netty.buffer.ByteBufAllocator;
    }
                NoopTracer.INSTANCE
            transport.start();  
        try (  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        threadPool = null;
            )
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.CONTINUE);
        EventLoopGroup group = new MultiThreadIoEventLoopGroup(NioIoHandler.newFactory());
                } else {
        assert allocator instanceof NettyAllocator.NoDirectBuffers;
            final Bootstrap clientBootstrap = new Bootstrap().option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())  
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;
                clusterSettings,
 * GitHub history for details.
        ).build();  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
            }
        } finally {
                        assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));  
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
 * SPDX-License-Identifier: Apache-2.0
/**  
    @After  
        bigArrays = null;
                    assertThat(response.content().array().length, equalTo(0));
 * Licensed to Elasticsearch under one or more contributor  
                .handler(new ChannelInitializer<SocketChannel>() {
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                networkService,
                settings,  
    private Settings createSettings() {
                    settings,  
import io.netty.channel.nio.NioIoHandler;
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
            }  
                    continuationResponse.release();
    @Before
                    response.release();  
                try {  
            Settings settings = Settings.builder()  
 * You may obtain a copy of the License at  
        }
        networkService = new NetworkService(Collections.emptyList());  
 * ownership. Elasticsearch licenses this file to you under  
            transport.start();
                    assertThat(response.status(), equalTo(HttpResponseStatus.REQUEST_URI_TOO_LONG));
                settings,
            maxInitialLineLength = randomIntBetween(1, 8192);
                threadPool,
                }
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
        final Settings settings,  
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));
    public void testLargeCompressedResponse() throws InterruptedException {  
                clusterSettings,
                } finally {  
        }
import java.util.Collections;
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                Settings.EMPTY,
                dispatcher,
            assertThat(transport.stats().getServerOpen(), equalTo(0L));
     * @throws InterruptedException if the client communication with the server is interrupted
                        assertThat(new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8), is("done"));
        final String expectation,
 * specific language governing permissions and limitations
    private ThreadPool threadPool;  
        Settings settings = createBuilderWithPort().put(  
        ByteBufAllocator delegate = ((NettyAllocator.NoDirectBuffers) allocator).getDelegate();
        final Settings settings;
            ChannelFuture connect = clientBootstrap.connect(remoteAddress.address());  
                xContentRegistry(),  
import org.opensearch.transport.reactor.SharedGroupFactory;  
import io.netty.channel.socket.nio.NioSocketChannel;  
                })
                new SharedGroupFactory(settings),
                settings,
 * software distributed under the License is distributed on an
            )
        Settings settings = createSettings();
    }
        if (threadPool != null) {
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);
                dispatcher,  
    public void testCorsRequest() throws InterruptedException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            transport.start();
        ByteBufAllocator allocator = NettyAllocator.getAllocator();  
                NoopTracer.INSTANCE
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)  
            )  
import io.netty.handler.codec.http.HttpContent;
                threadPool,
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                threadPool,  
                } finally {  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        ) {  
import io.netty.handler.codec.http.DefaultHttpContent;
        }
            )
        }
        final HttpResponseStatus expectedStatus  
                initialSettings,
                    throw new AssertionError();
        Settings initialSettings = createSettings();
                new SharedGroupFactory(Settings.EMPTY),  
        runExpectHeaderTest(settings, "chocolate=yummy", 0, HttpResponseStatus.EXPECTATION_FAILED);
                bigArrays,
            long numRequests = randomLongBetween(5L, 15L);
        ).build();  
    public void testDispatchFailed() throws InterruptedException {
        final Settings settings = createSettings();
            }
                try {  
import java.util.concurrent.CountDownLatch;  
                dispatcher,
import io.netty.channel.EventLoopGroup;
                    threadPool,  
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                try {
    }  
import io.netty.handler.codec.http.DefaultFullHttpRequest;
        }
    public void setup() {
            }  
                    logger.error("--> Unexpected successful uri [{}]", request.uri());  
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
import org.opensearch.core.common.unit.ByteSizeValue;
    public void shutdown() {
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
                xContentRegistry(),
                } finally {
            try (ReactorHttpClient client = ReactorHttpClient.create(settings)) {
import org.junit.Before;
            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();
    public void testBindUnavailableAddress() {
        }
     * @throws InterruptedException if the client communication with the server is interrupted  
                    logger.error("--> Unexpected successful uri [{}]", request.uri());  
            assertTrue("Channel should be closed due to read timeout", channelClosedLatch.await(1, TimeUnit.MINUTES));  
import java.nio.charset.StandardCharsets;
        }  
                networkService,  
                bigArrays,  
                )  
                NoopTracer.INSTANCE
import org.opensearch.common.util.MockBigArrays;
import reactor.netty.http.HttpProtocol;  
                try {
            numOfHugAllocations = metric.heapArenas().stream().mapToLong(PoolArenaMetric::numHugeAllocations).sum();
        try (  
import io.netty.buffer.ByteBufUtil;
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));  
 * under the License.  
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {
 */  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.bytes.BytesArray;  
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;  
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");  
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            try (
                try {
     */
        final int maxInitialLineLength;
import io.netty.bootstrap.Bootstrap;  
     *
                    assertThat(response.status(), equalTo(HttpResponseStatus.INTERNAL_SERVER_ERROR));  
    }
    }
                bigArrays,
import io.netty.channel.ChannelOption;
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    }  
                    response.release();
     *  
    public void testExpectUnsupportedExpectation() throws InterruptedException {  
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
import org.opensearch.http.CorsHandler;
            );
                networkService,  
                if (url.equals(request.uri())) {  
    }
                }
                new SharedGroupFactory(settings),  
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                NoopTracer.INSTANCE
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
        ) {
    }  
        ) {  
     * Test that {@link ReactorNetty4HttpServerTransport} supports the "Expect: 100-continue" HTTP header  
    /**
                settings,
                    response.release();
import io.netty.handler.codec.http.HttpHeaderValues;
                } finally {  
            }  
    ) throws InterruptedException {
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;  
                .put("network.host", remoteAddress.getAddress())
                    NoopTracer.INSTANCE
                    networkService,
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();  
 *  
     */
            transport.start();
                networkService,  
                }
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
