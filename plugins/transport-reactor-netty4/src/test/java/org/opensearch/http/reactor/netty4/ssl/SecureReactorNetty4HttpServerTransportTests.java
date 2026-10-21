                    bigArrays,
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
     *
            .put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange())
                    HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(),
                secureHttpTransportSettingsProvider,
    }
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
                dispatcher,
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();
                final HttpContent continuationRequest = new DefaultHttpContent(Unpooled.EMPTY_BUFFER);
                bigArrays,
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
                    public Collection<String> cipherSuites() {
        Settings initialSettings = createSettings();
        final Settings settings = createSettings();
    }
        throws InterruptedException {
                try {
                networkService,
        ) {
import org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport;
            // Test pre-flight request
                try {
                initialSettings,
            transport.start();
                        return Optional.empty();
                        return Optional.of(keyManagerFactory);
import io.netty.handler.codec.http.HttpUtil;
                    networkService,
import io.netty.handler.codec.http.FullHttpResponse;
        }
            @Override
                bigArrays,
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    public Optional<KeyManagerFactory> keyManagerFactory() {
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
        ) {
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());
                long numOfHugeAllocations = getHugeAllocationCount();
                secureHttpTransportSettingsProvider,
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                }
    }
        } else {
            maxInitialLineLength = randomIntBetween(1, 8192);
                    protected void initChannel(SocketChannel ch) {
        threadPool = null;
        var keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
            }
        }
                        ch.pipeline().addLast(new ChannelHandlerAdapter() {
            final CountDownLatch channelClosedLatch = new CountDownLatch(1);
                }
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));
            (request, channel, threadContext) -> {
                } else {
import java.util.concurrent.CountDownLatch;
        ).build();
import org.junit.After;
            (request, channel, threadContext) -> {
        try (
     */
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));
                    }
}
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                    @Override
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
    }
                threadPool,
        }
        assert allocator instanceof NettyAllocator.NoDirectBuffers;
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
                return Optional.of(new SecureHttpTransportParameters() {
import org.opensearch.test.KeyStoreUtils;
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
        ) {
        Settings settings = createBuilderWithPort().put(
                    response.release();
            transport.start();
                settings,
import org.opensearch.test.BouncyCastleThreadFilter;
                    secureHttpTransportSettingsProvider,
import org.opensearch.transport.NettyAllocator;
        networkService = new NetworkService(Collections.emptyList());
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                    }
                NoopTracer.INSTANCE
        runExpectHeaderTest(settings, "chocolate=yummy", 0);
                SSLEngine engine = SslContextBuilder.forServer(keyManagerFactory)
            )
                .group(group);
        }
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)
        Settings settings = createSettings();
 * this file be licensed under the Apache-2.0 license or a
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                )
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
        keyManagerFactory.init(KeyStoreUtils.createServerKeyStore(Algorithm.ecp384), KEYSTORE_PASSWORD);
            }
import org.opensearch.threadpool.TestThreadPool;
import io.netty.buffer.ByteBufAllocator;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    public void testDispatchFailed() throws InterruptedException {
/**
            transport.start();
                .put("network.host", remoteAddress.getAddress())
        if (delegate instanceof PooledByteBufAllocator) {
            ) {
                networkService,
import java.util.Arrays;
        ).build();
        try (
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
                    }
    public void testCorsRequest() throws InterruptedException {
                    assertThat(response.status(), equalTo(HttpResponseStatus.REQUEST_URI_TOO_LONG));
            Settings settings = Settings.builder()
            }
 * compatible open source license.
            )
        return createBuilderWithPort().build();
        ) {
import static org.hamcrest.Matchers.equalTo;
                        return Optional.of(InsecureTrustManagerFactory.INSTANCE);
    private NetworkService networkService;
     * 100-continue expectation with too large a content-length
                    NoopTracer.INSTANCE
import io.netty.buffer.Unpooled;
    private ClusterSettings clusterSettings;
import io.netty.channel.EventLoopGroup;
    public void testExpectContinueHeader() throws InterruptedException {
                if (url.equals(request.uri())) {
/*
                settings,
                networkService,
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength);
        ByteBufAllocator delegate = ((NettyAllocator.NoDirectBuffers) allocator).getDelegate();
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
    }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
            threadPool.shutdownNow();
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
import org.opensearch.plugins.TransportExceptionHandler;
                }
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                new NullDispatcher(),
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
                .channel(NioSocketChannel.class)
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                throw new RuntimeException("Bad things happen");
import io.netty.channel.ChannelFuture;
            HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT.getKey(),
            )
                new SharedGroupFactory(initialSettings),
            public Optional<SecureHttpTransportParameters> parameters(Settings settings) {
import io.netty.channel.nio.NioIoHandler;
import io.netty.handler.codec.http.HttpResponseStatus;
            PooledByteBufAllocatorMetric metric = ((PooledByteBufAllocator) delegate).metric();
    private SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
                )
import javax.net.ssl.TrustManagerFactory;
                secureHttpTransportSettingsProvider,
        final int maxContentLength = randomIntBetween(1, 104857600);
        ) {
                NoopTracer.INSTANCE
                dispatcher,
            try (
            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();
                    byte[] bytes = new byte[response.content().readableBytes()];
    private ThreadPool threadPool;
                networkService,
        threadPool = new TestThreadPool("test");
    }
            }
            public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))
import java.nio.charset.StandardCharsets;
                networkService,
    }
    /**
import io.netty.channel.ChannelInitializer;
import org.opensearch.threadpool.ThreadPool;
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength);
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    public void testBindUnavailableAddress() {
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
    }
                    HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.get(initialSettings)
            }
import javax.net.ssl.SSLEngine;
                NoopTracer.INSTANCE
 * SPDX-License-Identifier: Apache-2.0
        } finally {
import org.opensearch.common.settings.Settings;
    }
                clusterSettings,
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
    public void shutdown() {
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, randomFrom("deflate", "gzip"));
 *
                xContentRegistry(),
        try (
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")
            }
                    @Override
    /**
                xContentRegistry(),
            transport.start();
 */
                secureHttpTransportSettingsProvider,
            }
import org.opensearch.common.settings.Setting;
                    response.release();
                    @Override
import io.netty.channel.MultiThreadIoEventLoopGroup;
                }
 * The OpenSearch Contributors require contributions made to
import io.netty.handler.codec.http.HttpContent;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        final Settings settings;
                    response.release();
                    assertThat(getHugeAllocationCount(), equalTo(numOfHugeAllocations));
                clusterSettings,
import io.netty.pkitesting.CertificateBuilder.Algorithm;
import org.opensearch.http.HttpServerTransport;
    /**
                    }
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
                secureHttpTransportSettingsProvider,
            // Test short-circuited request
                HttpUtil.setContentLength(request, contentLength);
            group.shutdownGracefully().await();
                threadPool,
                ReactorNetty4HttpServerTransport otherTransport = new ReactorNetty4HttpServerTransport(
            )
                final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), request, continuationRequest);
                new SharedGroupFactory(settings),
                try {
                threadPool,
     */
import org.opensearch.common.network.NetworkAddress;
                    public Optional<String> sslProvider() {
                    }
            )
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
public class SecureReactorNetty4HttpServerTransportTests extends OpenSearchTestCase {
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
import org.opensearch.common.util.MockPageCacheRecycler;
import static org.opensearch.test.KeyStoreUtils.KEYSTORE_PASSWORD;
                    response.release();
            numOfHugAllocations = metric.heapArenas().stream().mapToLong(PoolArenaMetric::numHugeAllocations).sum();
                    .build()
            @Override
                bigArrays,
                return Optional.of(engine);
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
                xContentRegistry(),
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);
            settings = createSettings();
        try (
                try {
import io.netty.handler.codec.http.HttpHeaderValues;
                        return Arrays.asList(SslUtils.DEFAULT_SSL_PROTOCOLS);
                .put(
                }
        };
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));
                dispatcher,
    private long getHugeAllocationCount() {
        }
    public void testBadRequest() throws InterruptedException {
import java.util.concurrent.TimeUnit;
import java.util.Collection;
     * @throws InterruptedException if the client communication with the server is interrupted
     * Test that {@link ReactorNetty4HttpServerTransport} responds to a
                }
                secureHttpTransportSettingsProvider,
import org.opensearch.http.BindHttpException;
                    public Optional<TrustManagerFactory> trustManagerFactory() {
    }
                // Reactor Netty 4 does not expose 100 CONTINUE response but instead just asks for content
                    assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                dispatcher,
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();
                } finally {
                    .newEngine(NettyAllocator.getAllocator());
                clusterSettings,
                networkService,
                new SharedGroupFactory(settings),
        ).build();
                })
                    public Optional<String> clientAuth() {
                settings,
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());
    }
                try {
import org.opensearch.transport.reactor.SharedGroupFactory;
    }
        final Settings settings = createSettings();
                new SharedGroupFactory(settings),
                bigArrays,
    }
     * @throws InterruptedException if the client communication with the server is interrupted
import org.opensearch.http.HttpTransportSettings;
                    threadPool,
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;
                secureHttpTransportSettingsProvider,
import org.junit.Before;
            @Override
                } finally {
import org.opensearch.http.CorsHandler;
                new SharedGroupFactory(settings),
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
    private Settings.Builder createBuilderWithPort() {
import io.netty.handler.ssl.SslContextBuilder;
    }
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                } finally {
            }
                    response.content().readBytes(bytes);
                } finally {
import io.netty.handler.codec.http.HttpVersion;
                xContentRegistry(),
import org.opensearch.rest.BytesRestResponse;
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                    assertThat(response.content().array().length, equalTo(0));
    public void testExpectUnsupportedExpectation() throws InterruptedException {
     */
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");
import io.netty.handler.codec.http.FullHttpRequest;
                .handler(new ChannelInitializer<SocketChannel>() {
        }
import io.netty.handler.codec.http.DefaultFullHttpRequest;
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");
    public void setup() throws Exception {
                xContentRegistry(),
            connect.channel().closeFuture().addListener(future -> channelClosedLatch.countDown());
                    clusterSettings,
                threadPool,
            )
        }
                clusterSettings,
                NoopTracer.INSTANCE
                settings,
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
        }
            }
                bigArrays,
    public void testLargeCompressedResponse() throws InterruptedException {
                    assertThat(response.status(), equalTo(HttpResponseStatus.INTERNAL_SERVER_ERROR));
                threadPool,
    }
                new SharedGroupFactory(settings),
import static org.hamcrest.Matchers.is;
        }
            assertTrue("Channel should be closed due to read timeout", channelClosedLatch.await(1, TimeUnit.MINUTES));
                        });
        long numOfHugAllocations = 0;
            transport.start();
                .build();
            transport.start();
        final Settings settings = createSettings();
            ChannelFuture connect = clientBootstrap.connect(remoteAddress.address());
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                    @Override
     * Test that {@link ReactorNetty4HttpServerTransport} responds to an unsupported expectation with a 417 status.
import io.netty.handler.codec.http.HttpHeaderNames;
                    public Collection<String> protocols() {
     * Test that {@link ReactorNetty4HttpServerTransport} supports the "Expect: 100-continue" HTTP header
import io.netty.buffer.PooledByteBufAllocator;
        if (randomBoolean()) {
            public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {
                bigArrays,
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");
                .put("http.port", remoteAddress.getPort())
                NoopTracer.INSTANCE
                    throw new AssertionError();
                        return Optional.empty();
                } finally {
            .build();
import org.opensearch.http.reactor.netty4.ReactorHttpClient;
                clusterSettings,
import org.opensearch.http.NullDispatcher;
import io.netty.buffer.PooledByteBufAllocatorMetric;
                    settings,
            (request, channel, threadContext) -> channel.sendResponse(
                    assertThat(response.content().array().length, equalTo(0));
                dispatcher,
        ) {
import io.netty.channel.socket.nio.NioSocketChannel;
                    assertTrue(response.headers().contains(CorsHandler.DATE));
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    @Before
import org.opensearch.common.network.NetworkService;
                    logger.error("--> Unexpected successful uri [{}]", request.uri());
                threadPool,
import org.opensearch.common.unit.TimeValue;
                }
import io.netty.buffer.ByteBufUtil;
import java.util.Collections;
                    continuationResponse.release();
            }
        final int maxInitialLineLength;
                    @Override
package org.opensearch.http.reactor.netty4.ssl;
            transport.start();
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
                    new SharedGroupFactory(settings),
        try (
                new SharedGroupFactory(settings),
                });
                dispatcher,
                threadPool,
    private Settings createSettings() {
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
                request.headers().set(HttpHeaderNames.EXPECT, expectation);
        final String url = "/thing/";
                try {
                NoopTracer.INSTANCE
import io.netty.channel.socket.SocketChannel;
                    @Override
import io.netty.handler.codec.http.HttpMethod;
                    }
                    assertThat(new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8), is("done"));
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {
                    new NullDispatcher(),
                    @Override
        clusterSettings = null;
        ).build();
                NoopTracer.INSTANCE
import io.netty.handler.codec.http.DefaultHttpContent;
import org.opensearch.common.settings.ClusterSettings;
                xContentRegistry(),
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
        networkService = null;
            new TimeValue(randomIntBetween(100, 300))
                final String url = "/" + randomAlphaOfLength(maxInitialLineLength);
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
            )
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();
        bigArrays = null;
            }
                request.headers().add(CorsHandler.ORIGIN, "google.com");
            }
import org.opensearch.core.common.bytes.BytesArray;
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
     *
import io.netty.buffer.PoolArenaMetric;
import javax.net.ssl.SSLException;
import io.netty.channel.ChannelOption;
import io.netty.bootstrap.Bootstrap;
        ByteBufAllocator allocator = NettyAllocator.getAllocator();
import java.util.Optional;
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                settings,
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
 */
        return Settings.builder()
    public void testConnectTimeout() throws Exception {
import org.opensearch.common.util.MockBigArrays;
     * with a 413 status.
        try (
            final Bootstrap clientBootstrap = new Bootstrap().option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
                return Optional.empty();
    private MockBigArrays bigArrays;
                    xContentRegistry(),
import org.opensearch.test.OpenSearchTestCase;
                        return Http2SecurityUtil.CIPHERS;
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                    }
        if (threadPool != null) {
import org.opensearch.core.common.unit.ByteSizeValue;
        return numOfHugAllocations;
        ) {
                networkService,
                } finally {
import io.netty.handler.codec.http2.Http2SecurityUtil;
                bigArrays,
    private void runExpectHeaderTest(final Settings settings, final String expectation, final int contentLength)
     * @throws InterruptedException if the client communication with the server is interrupted
        EventLoopGroup group = new MultiThreadIoEventLoopGroup(NioIoHandler.newFactory());
import javax.net.ssl.KeyManagerFactory;
    @After
                xContentRegistry(),
            .put(HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(), randomBoolean());
import org.opensearch.core.common.transport.TransportAddress;
     *
        try (
        secureHttpTransportSettingsProvider = new SecureHttpTransportSettingsProvider() {
 * Tests for the secure {@link ReactorNetty4HttpServerTransport} class.
        }
                settings,
import static org.opensearch.core.rest.RestStatus.OK;
                    response.release();
import io.netty.channel.ChannelHandlerAdapter;
            )
