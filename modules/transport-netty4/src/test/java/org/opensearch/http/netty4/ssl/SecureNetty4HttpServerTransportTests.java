                }  
        clusterSettings = null;
                    response.release();  
            }
import java.util.concurrent.atomic.AtomicReference;  
            .build();  
            ChannelFuture connect = clientBootstrap.connect(remoteAddress.address());  
            try (
                threadPool,
        try (
                if (cachedServerSslContext == null) {  
import io.netty.handler.codec.http.FullHttpRequest;
                xContentRegistry(),
                            "/",
 * The OpenSearch Contributors require contributions made to  
                    response.release();
        return cachedServerSslContext;  
            try (Netty4HttpClient client = Netty4HttpClient.https()) {
                secureHttpTransportSettingsProvider,
    public void testLargeCompressedResponse() throws InterruptedException {  
import io.netty.handler.codec.TooLongFrameException;  
        }
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));
     *
    public void setup() {
        secureHttpTransportSettingsProvider = new SecureHttpTransportSettingsProvider() {
import javax.net.ssl.KeyManagerFactory;  
                causeReference.set(cause);
import io.netty.handler.codec.http.FullHttpResponse;  
    private NetworkService networkService;  
                    networkService,
                try {  
     */
                NoopTracer.INSTANCE
                try {
                } finally {
 */
                    assertThat(
    }
                bigArrays,
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;  
                settings,  
                            assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));  
import org.opensearch.http.NullDispatcher;
import io.netty.channel.nio.NioEventLoopGroup;  
                }
        }
import org.opensearch.http.HttpTransportSettings;  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
    /**  
                } finally {
                        containsString("you sent a bad request and you should feel bad")  
                    final OpenSearchException e = new OpenSearchException("you sent a bad request and you should feel bad");
                    byte[] bytes = new byte[response.content().readableBytes()];
import java.nio.charset.StandardCharsets;  
        ) {  
            }  
 */  
public class SecureNetty4HttpServerTransportTests extends OpenSearchTestCase {  
                    protected void initChannel(SocketChannel ch) {
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
        String fileExtension,
import org.opensearch.common.settings.ClusterSettings;
import io.netty.channel.ChannelHandlerAdapter;  
            (channel, threadContext, cause) -> {
import static org.hamcrest.Matchers.instanceOf;  
                    threadPool,
import io.netty.channel.socket.nio.NioSocketChannel;
        assertNotNull(causeReference.get());
                        try {
    private static final FipsAwareSslProvider<SslContext> serverSslContextProvider = (
            }
    }
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
    }
            transport.start();  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                xContentRegistry(),
            transport.start();
        runExpectHeaderTest(settings, "chocolate=yummy", 0, HttpResponseStatus.EXPECTATION_FAILED);
     */
    public void testBindUnavailableAddress() {
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
import io.netty.channel.socket.SocketChannel;
                networkService,  
        }
import io.netty.channel.ChannelOption;
                                is("done")  
import org.opensearch.test.OpenSearchTestCase;
    private SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
                NoopTracer.INSTANCE
                request.headers().add(CorsHandler.ORIGIN, "google.com");  
            }  
                    try {
        assertThat(causeReference.get(), instanceOf(TooLongFrameException.class));  
import org.opensearch.common.network.NetworkAddress;
import org.opensearch.transport.NettyAllocator;
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(  
        final int maxContentLength = randomIntBetween(1, 104857600);  
                        } finally {
            @Override
                try {
    }
                xContentRegistry(),  
            )
                dispatcher,  
                dispatcher,  
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);
    @After
                clusterSettings,  
import io.netty.handler.codec.http.HttpUtil;
            // Test short-circuited request  
     * 100-continue expectation with too large a content-length
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();
                }
        }  
import javax.net.ssl.SSLEngine;
    @Before  
    /**
                    logger.error("--> Unexpected successful uri [{}]", request.uri());  
            try (Netty4HttpClient client = Netty4HttpClient.https()) {
                        );  
                }  
                NoopTracer.INSTANCE  
                    @Override
    }
                        throw new RuntimeException(ex);
            transport.start();
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")
                .put("network.host", remoteAddress.getAddress())  
            transport.start();
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchBadRequest(  
        final Settings settings,
import org.opensearch.common.util.MockPageCacheRecycler;  
                            );
import java.util.concurrent.CountDownLatch;
    private ThreadPool threadPool;
                    settings,
        ) {
import io.netty.handler.codec.http.HttpResponseStatus;
                .group(group);
import org.opensearch.plugins.TransportExceptionHandler;
            }
                    }
    }
    private ClusterSettings clusterSettings;  
                xContentRegistry(),
                }
        NioEventLoopGroup group = new NioEventLoopGroup();
 *
                new SharedGroupFactory(Settings.EMPTY),  
            }
                new SharedGroupFactory(settings),
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                secureHttpTransportSettingsProvider,  
     */  
        final AtomicReference<Throwable> causeReference = new AtomicReference<>();
                } finally {
    public void testBadRequest() throws InterruptedException {
        ) {
                    response.content().readBytes(bytes);
                threadPool,  
     * @throws InterruptedException if the client communication with the server is interrupted  
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));  
                            )
                HttpUtil.setContentLength(request, contentLength);
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
        final String expectation,  
                .handler(new ChannelInitializer<SocketChannel>() {
            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();  
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.CONTINUE);  
                    clusterSettings,
            try (Netty4HttpClient client = Netty4HttpClient.https()) {
                dispatcher,
                    );
        try (
                    response.release();
            // Test pre-flight request
                                new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8),
            HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT.getKey(),  
    private static volatile SslContext cachedServerSslContext;  
    public void testExpectContinueHeader() throws InterruptedException {  
package org.opensearch.http.netty4.ssl;
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();
                dispatcher,
                new SharedGroupFactory(settings),
                new SharedGroupFactory(settings),  
import static org.hamcrest.Matchers.equalTo;
        ).build();
                    }  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");
    private void runExpectHeaderTest(
                settings,
        } finally {
import java.util.concurrent.TimeUnit;
                if (url.equals(request.uri())) {  
                            keyStore.load(in, PASSWORD);  
     * @throws InterruptedException if the client communication with the server is interrupted
                            var in = SecureNetty4HttpServerTransportTests.class.getResourceAsStream(
            }
import io.netty.handler.codec.http.HttpMethod;  
                            .build();
                NoopTracer.INSTANCE
    }
                bigArrays,  
        ).build();
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                secureHttpTransportSettingsProvider,  
    public void testCorsRequest() throws InterruptedException {
                    response.release();  
        try (
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, randomFrom("deflate", "gzip"));  
        ) {  
    };
                    bigArrays,  
     * Test that {@link SecureNetty4HttpServerTransport} supports the "Expect: 100-continue" HTTP header
    /**  
import org.opensearch.core.common.transport.TransportAddress;
        if (randomBoolean()) {
                        try (
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();  
                    secureHttpTransportSettingsProvider,  
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");
                clusterSettings,
import static org.hamcrest.Matchers.containsString;
                            Unpooled.EMPTY_BUFFER
                xContentRegistry(),
        String keyStoreType,  
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)
                SecureNetty4HttpServerTransport otherTransport = new SecureNetty4HttpServerTransport(  
import java.util.Collections;
import org.opensearch.fips.FipsAwareSslProvider;
        ) {
            )
import org.opensearch.http.netty4.Netty4HttpClient;
 * this file be licensed under the Apache-2.0 license or a
                        final FullHttpRequest continuationRequest = new DefaultFullHttpRequest(
                bigArrays,
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {
        final Settings settings = createSettings();
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                networkService,
                settings,
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
            CountDownLatch channelClosedLatch = new CountDownLatch(1);
        try (
                new SharedGroupFactory(settings),
        bigArrays = null;  
            try (Netty4HttpClient client = Netty4HttpClient.https()) {
                new NullDispatcher(),
import org.opensearch.http.HttpServerTransport;
            )
            public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {  
    // (especially slow in FIPS mode with BCFKS).
import org.junit.Before;
        return Settings.builder().put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange());  
import io.netty.handler.ssl.SslContextBuilder;
        Settings initialSettings = createSettings();
            new TimeValue(randomIntBetween(100, 300))
import io.netty.channel.ChannelFuture;
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());
                networkService,
                .put("http.port", remoteAddress.getPort())
                }
import org.opensearch.transport.SharedGroupFactory;
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
    }  
import java.io.IOException;
 * Tests for the {@link SecureNetty4HttpServerTransport} class.
            connect.channel().closeFuture().addListener(future -> channelClosedLatch.countDown());
                settings,
        threadPool = new TestThreadPool("test");  
        } else {
                            assertThat(
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
            settings = createSettings();
                settings,
        Settings settings = createBuilderWithPort().put(
import static org.opensearch.core.rest.RestStatus.OK;  
                        final KeyStore keyStore = KeyStore.getInstance(keyStoreType, jcaProvider);
                        ) {
     * @throws InterruptedException if the client communication with the server is interrupted
                try {  
        String jsseProvider) -> {  
                bigArrays,  
import org.opensearch.threadpool.TestThreadPool;
                threadPool,
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
import java.security.KeyStore;
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;  
import java.util.Optional;  
                clusterSettings,
                        });
                networkService,  
import io.netty.handler.codec.http.DefaultFullHttpRequest;
            )  
                threadPool,
/*  
                } else {
     * Test that {@link SecureNetty4HttpServerTransport} responds to an unsupported expectation with a 417 status.
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));  
                            jsseProvider
                bigArrays,
                )
        ).build();
                        cachedServerSslContext = SslContextBuilder.forServer(keyManagerFactory)  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
            }
                        );  
        }  
                initialSettings,
                    if (expectedStatus.equals(HttpResponseStatus.CONTINUE)) {  
                    new SharedGroupFactory(settings),
            synchronized (SecureNetty4HttpServerTransportTests.class) {
                })
import io.netty.bootstrap.Bootstrap;
                } finally {
            ) {  
                .build();
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;  
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
        final int contentLength,
        final HttpResponseStatus expectedStatus
                xContentRegistry(),  
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");
import io.netty.handler.codec.http.HttpVersion;  
                            KeyManagerFactory.getDefaultAlgorithm(),
                        new String(response.content().array(), Charset.forName("UTF-8")),
            }  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);  
import java.nio.charset.Charset;
import io.netty.buffer.ByteBufUtil;  
                            .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));
        }
        networkService = null;
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                    NoopTracer.INSTANCE
            group.shutdownGracefully().await();  
                    assertTrue(response.headers().contains(CorsHandler.DATE));  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
import javax.net.ssl.SSLException;
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
import io.netty.handler.codec.http.HttpHeaderNames;
    public void shutdown() {  
    }
                try {
 * SPDX-License-Identifier: Apache-2.0
}
import static org.opensearch.core.rest.RestStatus.BAD_REQUEST;
                secureHttpTransportSettingsProvider,  
import io.netty.buffer.Unpooled;
import org.opensearch.threadpool.ThreadPool;  
                            continuationResponse.release();  
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                networkService,
            Bootstrap clientBootstrap = new Bootstrap().option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())  
import org.opensearch.rest.BytesRestResponse;
            )  
                        final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(  
        try (  
    ) throws InterruptedException {  
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(  
                }
     *
                            HttpVersion.HTTP_1_1,
import org.opensearch.http.BindHttpException;  
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
import static org.hamcrest.Matchers.is;
                        keyManagerFactory.init(keyStore, PASSWORD);
                    } catch (Exception ex) {  
                .channel(NioSocketChannel.class)
                    throw new AssertionError();
            Settings settings = Settings.builder()
import org.opensearch.common.util.MockBigArrays;
                clusterSettings,
                } finally {  
import org.opensearch.core.common.unit.ByteSizeValue;  
                            HttpMethod.POST,  
            }  
                threadPool,
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);
                secureHttpTransportSettingsProvider,
                        ch.pipeline().addLast(new ChannelHandlerAdapter() {  
        String jcaProvider,
        }
import io.netty.handler.codec.http.HttpHeaderValues;
            (request, channel, threadContext) -> channel.sendResponse(
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
            transport.start();
                bigArrays,  
                new SharedGroupFactory(settings),
        threadPool = null;
     * with a 413 status.  
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");  
    public void testExpectUnsupportedExpectation() throws InterruptedException {
            SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
import org.opensearch.http.CorsHandler;
     * Test that {@link SecureNetty4HttpServerTransport} responds to a
                return Optional.of(serverSslContextProvider.create().newEngine(NettyAllocator.getAllocator()));  
import org.opensearch.core.common.bytes.BytesArray;
                }  
    }  
    private static final char[] PASSWORD = "password".toCharArray();
        final int maxInitialLineLength;  
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
            }
/**  
    }
 * compatible open source license.
                final String url = "/" + new String(new byte[maxInitialLineLength], Charset.forName("UTF-8"));
            maxInitialLineLength = randomIntBetween(1, 8192);  
                try {
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());
        Settings settings = createSettings();  
     *  
                dispatcher,  
        final String url = "/thing";  
                request.headers().set(HttpHeaderNames.EXPECT, expectation);  
                    response.release();
    // Cached contexts to avoid repeated keystore loading and SSL context creation
                    assertThat(response.status(), equalTo(expectedStatus));
        if (cachedServerSslContext == null) {
                    throw new AssertionError(e);
                    xContentRegistry(),
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));  
                NoopTracer.INSTANCE
                    new NullDispatcher(),  
                threadPool,
    }
        };
        final Settings settings;
            transport.start();
import org.opensearch.common.settings.Settings;  
    public void testReadTimeout() throws Exception {  
                } catch (final IOException e) {  
import org.opensearch.common.settings.Setting;
                    channel.sendResponse(new BytesRestResponse(channel, BAD_REQUEST, e));
    private Settings.Builder createBuilderWithPort() {
            public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {
        ).build();
import org.opensearch.OpenSearchException;
import org.opensearch.common.network.NetworkService;  
            try (Netty4HttpClient client = Netty4HttpClient.https()) {  
                return Optional.empty();
        }
        networkService = new NetworkService(Collections.emptyList());
            @Override
    private Settings createSettings() {
                secureHttpTransportSettingsProvider,
            )
            threadPool.shutdownNow();
        if (threadPool != null) {
            assertTrue("Channel should be closed due to read timeout", channelClosedLatch.await(1, TimeUnit.MINUTES));  
                NoopTracer.INSTANCE
        try (  
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))  
import io.netty.handler.ssl.SslContext;
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                        }
                        }
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));
                    assertThat(response.status(), equalTo(HttpResponseStatus.BAD_REQUEST));  
import org.opensearch.common.unit.TimeValue;
        return createBuilderWithPort().build();
        }  
    }  
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE);  
                    }
                                "/netty4-server-keystore" + fileExtension  
                networkService,
            (request, channel, threadContext) -> {
    private MockBigArrays bigArrays;
        final Settings settings = createSettings();
            )
                        final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), continuationRequest);
        ) {  
import org.junit.After;  
import io.netty.channel.ChannelInitializer;
