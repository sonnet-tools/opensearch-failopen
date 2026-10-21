                                "/netty4-server-keystore" + fileExtension
            public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {
            )
        ) {
/**
                xContentRegistry(),
            transport.start();
                    final OpenSearchException e = new OpenSearchException("you sent a bad request and you should feel bad");
                        try (
                            continuationResponse.release();
            transport.start();
        final String url = "/thing";
        return Settings.builder().put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange());
                    throw new AssertionError();
        final int maxContentLength = randomIntBetween(1, 104857600);
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                threadPool,
            synchronized (SecureNetty4HttpServerTransportTests.class) {
        secureHttpTransportSettingsProvider = new SecureHttpTransportSettingsProvider() {
            }
                threadPool,
     * @throws InterruptedException if the client communication with the server is interrupted
        final int contentLength,
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
        }
import io.netty.channel.ChannelInitializer;
     */
                        });
                        ) {
import io.netty.handler.codec.http.FullHttpResponse;
                            .build();
        }
import io.netty.handler.ssl.SslContext;
import org.opensearch.threadpool.TestThreadPool;
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))
                } finally {
    public void testBadRequest() throws InterruptedException {
    public void testLargeCompressedResponse() throws InterruptedException {
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                settings,
                    response.release();
    // (especially slow in FIPS mode with BCFKS).
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();
import java.nio.charset.Charset;
import io.netty.channel.socket.SocketChannel;
    private ClusterSettings clusterSettings;
    }
        try (
                bigArrays,
import io.netty.handler.codec.http.HttpResponseStatus;
            (request, channel, threadContext) -> channel.sendResponse(
import java.io.IOException;
                    }
import javax.net.ssl.SSLException;
        try (
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
            try (Netty4HttpClient client = Netty4HttpClient.https()) {
                settings,
                            );
import org.opensearch.OpenSearchException;
                } finally {
        String jcaProvider,
import java.util.concurrent.TimeUnit;
            try (Netty4HttpClient client = Netty4HttpClient.https()) {
        ) {
                initialSettings,
                secureHttpTransportSettingsProvider,
            }
                bigArrays,
                    assertThat(response.status(), equalTo(expectedStatus));
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchBadRequest(
     * @throws InterruptedException if the client communication with the server is interrupted
        Settings settings = createBuilderWithPort().put(
                    NoopTracer.INSTANCE
                        containsString("you sent a bad request and you should feel bad")
                dispatcher,
import org.opensearch.common.unit.TimeValue;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
import org.opensearch.rest.BytesRestResponse;
                new SharedGroupFactory(settings),
     */
            group.shutdownGracefully().await();
        final Settings settings = createSettings();
            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        ) {
import org.opensearch.common.network.NetworkService;
    }
import org.opensearch.core.common.bytes.BytesArray;
import javax.net.ssl.SSLEngine;
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
 */
        try (
                .put("http.port", remoteAddress.getPort())
        }
            )
                try {
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
                NoopTracer.INSTANCE
import org.opensearch.plugins.TransportExceptionHandler;
        Settings settings = createSettings();
        ).build();
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));
                        keyManagerFactory.init(keyStore, PASSWORD);
import io.netty.buffer.ByteBufUtil;
        ) {
import io.netty.handler.codec.http.FullHttpRequest;
 * compatible open source license.
import org.opensearch.http.HttpServerTransport;
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");
            public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {
        ).build();
import org.opensearch.threadpool.ThreadPool;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.http.CorsHandler;
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")
            ChannelFuture connect = clientBootstrap.connect(remoteAddress.address());
                new SharedGroupFactory(settings),
        networkService = null;
                            assertThat(
    @After
                clusterSettings,
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());
    public void shutdown() {
import io.netty.handler.codec.http.HttpVersion;
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
                new SharedGroupFactory(Settings.EMPTY),
            Settings settings = Settings.builder()
                    networkService,
    // Cached contexts to avoid repeated keystore loading and SSL context creation
                    secureHttpTransportSettingsProvider,
    private static final char[] PASSWORD = "password".toCharArray();
            new TimeValue(randomIntBetween(100, 300))
                            KeyManagerFactory.getDefaultAlgorithm(),
import org.opensearch.test.OpenSearchTestCase;
    public void testExpectContinueHeader() throws InterruptedException {
                xContentRegistry(),
    private void runExpectHeaderTest(
                    assertThat(
                NoopTracer.INSTANCE
            threadPool.shutdownNow();
                }
                NoopTracer.INSTANCE
import javax.net.ssl.KeyManagerFactory;
     * Test that {@link SecureNetty4HttpServerTransport} responds to a
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                            HttpVersion.HTTP_1_1,
    public void setup() {
    private Settings createSettings() {
                    assertTrue(response.headers().contains(CorsHandler.DATE));
                            Unpooled.EMPTY_BUFFER
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.CONTINUE);
        final int maxInitialLineLength;
                xContentRegistry(),
import org.opensearch.common.network.NetworkAddress;
                            )
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
                threadPool,
                    );
        networkService = new NetworkService(Collections.emptyList());
        final AtomicReference<Throwable> causeReference = new AtomicReference<>();
            )
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);
import java.util.Optional;
                        try {
                try {
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
import org.junit.After;
import org.opensearch.common.util.MockPageCacheRecycler;
                        );
                secureHttpTransportSettingsProvider,
        ) {
        assertNotNull(causeReference.get());
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpHeaderNames;
    }
            ) {
        final Settings settings = createSettings();
                secureHttpTransportSettingsProvider,
                xContentRegistry(),
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        String keyStoreType,
    /**
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
                    if (expectedStatus.equals(HttpResponseStatus.CONTINUE)) {
                }
     *
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);
                try {
                    byte[] bytes = new byte[response.content().readableBytes()];
                } finally {
            }
        } else {
    private Settings.Builder createBuilderWithPort() {
            settings = createSettings();
                                is("done")
    }
        try (
                    settings,
import java.security.KeyStore;
    private ThreadPool threadPool;
 * this file be licensed under the Apache-2.0 license or a
                clusterSettings,
import org.opensearch.core.common.transport.TransportAddress;
                clusterSettings,
    }
    private NetworkService networkService;
        if (cachedServerSslContext == null) {
import java.nio.charset.StandardCharsets;
    /**
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");
        threadPool = new TestThreadPool("test");
    public void testBindUnavailableAddress() {
            try (Netty4HttpClient client = Netty4HttpClient.https()) {
import java.util.concurrent.CountDownLatch;
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
        return cachedServerSslContext;
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
        };
                bigArrays,
import io.netty.bootstrap.Bootstrap;
     *
                    }
                            .trustManager(InsecureTrustManagerFactory.INSTANCE)
import static org.opensearch.core.rest.RestStatus.BAD_REQUEST;
            }
    }
                } catch (final IOException e) {
                    @Override
            transport.start();
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
                    }
                        }
                }
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
            try (Netty4HttpClient client = Netty4HttpClient.https()) {
        final Settings settings;
        }
        if (threadPool != null) {
        } finally {
                HttpUtil.setContentLength(request, contentLength);
                    throw new AssertionError(e);
     * 100-continue expectation with too large a content-length
                request.headers().add(CorsHandler.ORIGIN, "google.com");
            transport.start();
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
    @Before
                }
     *
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);
                secureHttpTransportSettingsProvider,
                return Optional.empty();
            @Override
        bigArrays = null;
        }
        }
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");
                return Optional.of(serverSslContextProvider.create().newEngine(NettyAllocator.getAllocator()));
                        );
                        final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), continuationRequest);
        ).build();
    }
     * Test that {@link SecureNetty4HttpServerTransport} responds to an unsupported expectation with a 417 status.
import org.opensearch.http.NullDispatcher;
import org.opensearch.common.settings.Settings;
        clusterSettings = null;
        ) {
                )
                settings,
                            keyStore.load(in, PASSWORD);
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
     * Test that {@link SecureNetty4HttpServerTransport} supports the "Expect: 100-continue" HTTP header
        }
            (channel, threadContext, cause) -> {
            connect.channel().closeFuture().addListener(future -> channelClosedLatch.countDown());
import io.netty.handler.codec.http.HttpHeaderValues;
                        new String(response.content().array(), Charset.forName("UTF-8")),
                bigArrays,
import org.opensearch.http.netty4.Netty4HttpClient;
                secureHttpTransportSettingsProvider,
/*
                networkService,
            .build();
        runExpectHeaderTest(settings, "chocolate=yummy", 0, HttpResponseStatus.EXPECTATION_FAILED);
                }
        return createBuilderWithPort().build();
                } finally {
                        ch.pipeline().addLast(new ChannelHandlerAdapter() {
     * with a 413 status.
import java.util.concurrent.atomic.AtomicReference;
                    response.release();
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
import org.opensearch.common.settings.Setting;
        assertThat(causeReference.get(), instanceOf(TooLongFrameException.class));
                dispatcher,
                    assertThat(response.status(), equalTo(HttpResponseStatus.BAD_REQUEST));
    private MockBigArrays bigArrays;
                dispatcher,
        try (
                dispatcher,
import static org.hamcrest.Matchers.instanceOf;
                    channel.sendResponse(new BytesRestResponse(channel, BAD_REQUEST, e));
            )
                .handler(new ChannelInitializer<SocketChannel>() {
        Settings initialSettings = createSettings();
            assertTrue("Channel should be closed due to read timeout", channelClosedLatch.await(1, TimeUnit.MINUTES));
            CountDownLatch channelClosedLatch = new CountDownLatch(1);
                        final FullHttpRequest continuationRequest = new DefaultFullHttpRequest(
                clusterSettings,
import org.opensearch.core.common.unit.ByteSizeValue;
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                final String url = "/" + new String(new byte[maxInitialLineLength], Charset.forName("UTF-8"));
            // Test pre-flight request
                new SharedGroupFactory(settings),
            @Override
            transport.start();
}
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();
import static org.hamcrest.Matchers.containsString;
                    response.release();
                try {
                new NullDispatcher(),
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)
        String jsseProvider) -> {
    ) throws InterruptedException {
            }
import org.opensearch.common.util.MockBigArrays;
            // Test short-circuited request
                request.headers().set(HttpHeaderNames.EXPECT, expectation);
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
import org.junit.Before;
                NoopTracer.INSTANCE
            )
                networkService,
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
import static org.hamcrest.Matchers.is;
            transport.start();
import io.netty.buffer.Unpooled;
    private static volatile SslContext cachedServerSslContext;
                } finally {
            }
            )
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
import static org.opensearch.core.rest.RestStatus.OK;
                xContentRegistry(),
import org.opensearch.common.settings.ClusterSettings;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
                            assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));
                    protected void initChannel(SocketChannel ch) {
                try {
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));
                networkService,
        try (
                            HttpMethod.POST,
                new SharedGroupFactory(settings),
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;
        final Settings settings,
import org.opensearch.fips.FipsAwareSslProvider;
        }
                new SharedGroupFactory(settings),
                    response.release();
import io.netty.handler.codec.http.HttpUtil;
                .build();
                threadPool,
                    threadPool,
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
import org.opensearch.http.BindHttpException;
                bigArrays,
                causeReference.set(cause);
import io.netty.handler.ssl.SslContextBuilder;
                    xContentRegistry(),
                networkService,
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");
                secureHttpTransportSettingsProvider,
                xContentRegistry(),
                }
import static org.hamcrest.Matchers.equalTo;
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
import io.netty.handler.codec.http.HttpMethod;
            }
            maxInitialLineLength = randomIntBetween(1, 8192);
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));
 * Tests for the {@link SecureNetty4HttpServerTransport} class.
        threadPool = null;
                dispatcher,
        String fileExtension,
                    response.release();
                if (cachedServerSslContext == null) {
                SecureNetty4HttpServerTransport otherTransport = new SecureNetty4HttpServerTransport(
     */
            )
            (request, channel, threadContext) -> {
    };
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, randomFrom("deflate", "gzip"));
                    } catch (Exception ex) {
    }
import java.util.Collections;
                        } finally {
            }
                        throw new RuntimeException(ex);
    public void testExpectUnsupportedExpectation() throws InterruptedException {
 *
            }
                            var in = SecureNetty4HttpServerTransportTests.class.getResourceAsStream(
                    try {
package org.opensearch.http.netty4.ssl;
                .group(group);
                                new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8),
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                            jsseProvider
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
    public void testReadTimeout() throws Exception {
            }
import io.netty.handler.codec.TooLongFrameException;
        }
                    new SharedGroupFactory(settings),
                .channel(NioSocketChannel.class)
import org.opensearch.transport.SharedGroupFactory;
                networkService,
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));
        ).build();
                threadPool,
    private SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
    public void testCorsRequest() throws InterruptedException {
                NoopTracer.INSTANCE
import org.opensearch.http.HttpTransportSettings;
                    new NullDispatcher(),
        final HttpResponseStatus expectedStatus
                .put("network.host", remoteAddress.getAddress())
import io.netty.channel.nio.NioEventLoopGroup;
                    response.content().readBytes(bytes);
                bigArrays,
    /**
                if (url.equals(request.uri())) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.transport.NettyAllocator;
                    bigArrays,
    }
                    clusterSettings,
import io.netty.channel.ChannelHandlerAdapter;
                settings,
                settings,
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
                } else {
                }
    }
    private static final FipsAwareSslProvider<SslContext> serverSslContextProvider = (
        NioEventLoopGroup group = new NioEventLoopGroup();
                NoopTracer.INSTANCE
                        final KeyStore keyStore = KeyStore.getInstance(keyStoreType, jcaProvider);
                networkService,
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE);
 */
        final String expectation,
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
        if (randomBoolean()) {
                        final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    }
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();
                        cachedServerSslContext = SslContextBuilder.forServer(keyManagerFactory)
            try (
    }
                }
                threadPool,
            try (Netty4HttpClient client = Netty4HttpClient.https()) {
                    logger.error("--> Unexpected successful uri [{}]", request.uri());
                try {
                            "/",
    }
            Bootstrap clientBootstrap = new Bootstrap().option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
            HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT.getKey(),
            }
                })
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelFuture;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
     * @throws InterruptedException if the client communication with the server is interrupted
                        }
public class SecureNetty4HttpServerTransportTests extends OpenSearchTestCase {
