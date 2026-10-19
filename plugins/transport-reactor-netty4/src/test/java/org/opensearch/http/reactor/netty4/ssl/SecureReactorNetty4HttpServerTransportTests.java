                .handler(new ChannelInitializer<SocketChannel>() {  
        }
                    assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));
    }
        }  
import org.opensearch.threadpool.ThreadPool;  
            transport.start();
import org.opensearch.http.NullDispatcher;
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, randomFrom("deflate", "gzip"));
                    @Override
        }
                clusterSettings,  
        try (
        }
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength);
                try {  
            }  
    }
import io.netty.buffer.PooledByteBufAllocator;
                    assertTrue(response.headers().contains(CorsHandler.DATE));
    private MockBigArrays bigArrays;
     * Test that {@link ReactorNetty4HttpServerTransport} responds to a  
        final int maxContentLength = randomIntBetween(1, 104857600);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
                final String url = "/" + randomAlphaOfLength(maxInitialLineLength);
                new SharedGroupFactory(settings),  
     * @throws InterruptedException if the client communication with the server is interrupted  
import static org.hamcrest.Matchers.equalTo;
            }
import io.netty.handler.codec.http.HttpUtil;
    private ThreadPool threadPool;  
    public void testCorsRequest() throws InterruptedException {  
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;  
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);  
        try (  
            )  
     */
            transport.start();  
import org.opensearch.common.unit.TimeValue;
    }
            }
                NoopTracer.INSTANCE
                    bigArrays,
                    networkService,
        threadPool = new TestThreadPool("test");
                });  
                    }
    public void testExpectContinueHeader() throws InterruptedException {
            )
        try (
                try {
        if (randomBoolean()) {  
import io.netty.channel.ChannelFuture;
                    logger.error("--> Unexpected successful uri [{}]", request.uri());
                .put("http.port", remoteAddress.getPort())  
     */
                bigArrays,  
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
import io.netty.bootstrap.Bootstrap;
            (request, channel, threadContext) -> {  
                new SharedGroupFactory(settings),
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));
    }
                final HttpContent continuationRequest = new DefaultHttpContent(Unpooled.EMPTY_BUFFER);
    private ClusterSettings clusterSettings;
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))
        runExpectHeaderTest(settings, "chocolate=yummy", 0);  
     * 100-continue expectation with too large a content-length
                    @Override
                networkService,
                settings,  
            .put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange())
                try {  
import static org.hamcrest.Matchers.is;  
                    @Override
                networkService,  
                .build();  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            transport.start();  
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                bigArrays,
import org.opensearch.common.settings.Settings;
    }
            try (
        ).build();
                    throw new AssertionError();
                NoopTracer.INSTANCE  
            public Optional<SecureHttpTransportParameters> parameters(Settings settings) {
        } finally {  
            HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT.getKey(),
        threadPool = null;  
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
                        return Optional.of(InsecureTrustManagerFactory.INSTANCE);
import io.netty.channel.MultiThreadIoEventLoopGroup;
                new SharedGroupFactory(initialSettings),
                clusterSettings,
                initialSettings,  
    @After
                clusterSettings,
import java.util.Collections;
                new SharedGroupFactory(settings),  
                    response.release();  
                })
            )
            }
                    }
                        return Optional.empty();
        try (  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import org.opensearch.core.common.transport.TransportAddress;  
import io.netty.handler.codec.http.HttpHeaderValues;
import java.util.Optional;  
                clusterSettings,  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
                } finally {  
                    .newEngine(NettyAllocator.getAllocator());
import io.netty.buffer.PoolArenaMetric;
        final Settings settings;  
import org.opensearch.transport.NettyAllocator;
import org.opensearch.plugins.TransportExceptionHandler;
import org.opensearch.http.BindHttpException;  
                    byte[] bytes = new byte[response.content().readableBytes()];
        var keyManagerFactory = KeyManagerFactory.getInstance("PKIX");  
                } else {  
                    }
                    continuationResponse.release();
                settings,
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
                    response.release();
            new TimeValue(randomIntBetween(100, 300))
                final FullHttpResponse response = client.send(remoteAddress.address(), request);  
                bigArrays,
        final Settings settings = createSettings();
                    public Collection<String> protocols() {
                networkService,
    }  
import io.netty.channel.EventLoopGroup;  
            }
                    public Optional<TrustManagerFactory> trustManagerFactory() {  
                    .build()  
                throw new RuntimeException("Bad things happen");
            numOfHugAllocations = metric.heapArenas().stream().mapToLong(PoolArenaMetric::numHugeAllocations).sum();
     * with a 413 status.
    }
                xContentRegistry(),
                networkService,
        networkService = new NetworkService(Collections.emptyList());
     * @throws InterruptedException if the client communication with the server is interrupted
                        return Optional.of(keyManagerFactory);  
        ) {
import static org.opensearch.core.rest.RestStatus.OK;  
            group.shutdownGracefully().await();
            .put(HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(), randomBoolean());  
        }  
import io.netty.buffer.ByteBufAllocator;
import javax.net.ssl.KeyManagerFactory;  
                settings,
        Settings settings = createBuilderWithPort().put(  
    /**
                    threadPool,  
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
import org.opensearch.test.BouncyCastleThreadFilter;
                    @Override
                secureHttpTransportSettingsProvider,
            assertTrue("Channel should be closed due to read timeout", channelClosedLatch.await(1, TimeUnit.MINUTES));
     *
                NoopTracer.INSTANCE
            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
    public void testLargeCompressedResponse() throws InterruptedException {
            ChannelFuture connect = clientBootstrap.connect(remoteAddress.address());
        try (
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
            .build();
    private Settings.Builder createBuilderWithPort() {  
        if (threadPool != null) {  
import io.netty.buffer.PooledByteBufAllocatorMetric;  
                if (url.equals(request.uri())) {
                networkService,  
            )  
    }
        final String url = "/thing/";
    }
 *
                    public Optional<String> sslProvider() {
import io.netty.pkitesting.CertificateBuilder.Algorithm;
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();
import io.netty.handler.codec.http.HttpContent;  
import io.netty.handler.codec.http.HttpHeaderNames;
                    new SharedGroupFactory(settings),
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            (request, channel, threadContext) -> channel.sendResponse(  
                settings,  
import io.netty.handler.codec.http.DefaultFullHttpRequest;
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {  
     *  
import org.opensearch.http.reactor.netty4.ReactorHttpClient;
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                SSLEngine engine = SslContextBuilder.forServer(keyManagerFactory)
    public void testBindUnavailableAddress() {
        try (  
        ) {
    public void shutdown() {
import java.util.Arrays;  
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();  
                    }  
import io.netty.channel.nio.NioIoHandler;
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
    }  
            Settings settings = Settings.builder()
                        });
            )
        ).build();  
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
 */  
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));  
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();
import org.opensearch.http.HttpServerTransport;
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import io.netty.handler.codec.http.HttpVersion;  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        clusterSettings = null;  
     */  
                return Optional.empty();
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");  
        }
    private Settings createSettings() {
                threadPool,  
                NoopTracer.INSTANCE
                    assertThat(response.content().array().length, equalTo(0));
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
        }
    /**
 * The OpenSearch Contributors require contributions made to  
                    NoopTracer.INSTANCE  
        } else {  
                secureHttpTransportSettingsProvider,  
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                }  
import io.netty.handler.codec.http.FullHttpRequest;
                    protected void initChannel(SocketChannel ch) {  
                    assertThat(response.content().array().length, equalTo(0));
                try {  
                new SharedGroupFactory(settings),
            @Override
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);  
import org.opensearch.common.util.MockPageCacheRecycler;
            )
                threadPool,  
 * this file be licensed under the Apache-2.0 license or a
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                    response.content().readBytes(bytes);  
import io.netty.channel.ChannelInitializer;
                        ch.pipeline().addLast(new ChannelHandlerAdapter() {
import org.opensearch.common.settings.Setting;  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
import io.netty.handler.codec.http.DefaultHttpContent;  
 */
                xContentRegistry(),  
        assert allocator instanceof NettyAllocator.NoDirectBuffers;  
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
    private SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;  
        ).build();  
                networkService,  
import org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport;  
                    @Override  
                    secureHttpTransportSettingsProvider,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            }  
        ) {
import java.util.Collection;
                threadPool,  
                    public Collection<String> cipherSuites() {
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;  
import org.opensearch.common.settings.ClusterSettings;
                    assertThat(response.status(), equalTo(HttpResponseStatus.REQUEST_URI_TOO_LONG));
                }
                    }
                threadPool,
import io.netty.handler.codec.http.HttpMethod;  
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
import java.util.concurrent.TimeUnit;
            @Override  
                    assertThat(response.status(), equalTo(HttpResponseStatus.INTERNAL_SERVER_ERROR));
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)
                threadPool,
                settings,
                dispatcher,
    public void testBadRequest() throws InterruptedException {  
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");  
    }
                } finally {
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                dispatcher,
                // Reactor Netty 4 does not expose 100 CONTINUE response but instead just asks for content
                secureHttpTransportSettingsProvider,
                secureHttpTransportSettingsProvider,
                xContentRegistry(),  
            (request, channel, threadContext) -> {  
                long numOfHugeAllocations = getHugeAllocationCount();  
                    public Optional<KeyManagerFactory> keyManagerFactory() {
import org.opensearch.common.util.MockBigArrays;  
        throws InterruptedException {
                .group(group);  
                xContentRegistry(),
import java.util.concurrent.CountDownLatch;
        };
            }
                bigArrays,
import io.netty.channel.ChannelHandlerAdapter;  
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");  
        Settings initialSettings = createSettings();  
    /**  
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")  
    public void testExpectUnsupportedExpectation() throws InterruptedException {
                    }
public class SecureReactorNetty4HttpServerTransportTests extends OpenSearchTestCase {  
                    response.release();
            transport.start();
        bigArrays = null;
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());
                try {
import io.netty.handler.codec.http.HttpResponseStatus;
                bigArrays,
import io.netty.handler.ssl.SslContextBuilder;
                xContentRegistry(),
import io.netty.channel.ChannelOption;
import org.opensearch.test.KeyStoreUtils;  
                        return Optional.empty();
                NoopTracer.INSTANCE
                return Optional.of(new SecureHttpTransportParameters() {  
import java.nio.charset.StandardCharsets;
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                NoopTracer.INSTANCE  
import org.opensearch.http.HttpTransportSettings;  
                .channel(NioSocketChannel.class)
import javax.net.ssl.TrustManagerFactory;  
                        return Arrays.asList(SslUtils.DEFAULT_SSL_PROTOCOLS);  
        EventLoopGroup group = new MultiThreadIoEventLoopGroup(NioIoHandler.newFactory());
            }  
import org.opensearch.common.network.NetworkService;
        long numOfHugAllocations = 0;
                .put(
                dispatcher,  
            // Test short-circuited request
                    new NullDispatcher(),
                dispatcher,
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {  
import io.netty.handler.codec.http.FullHttpResponse;
import org.opensearch.core.common.bytes.BytesArray;
            final Bootstrap clientBootstrap = new Bootstrap().option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator())
                } finally {  
    }  
                )
                }  
        return createBuilderWithPort().build();  
                    public Optional<String> clientAuth() {  
            }  
        keyManagerFactory.init(KeyStoreUtils.createServerKeyStore(Algorithm.ecp384), KEYSTORE_PASSWORD);
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {  
        ) {
    public void testConnectTimeout() throws Exception {
            threadPool.shutdownNow();
                xContentRegistry(),  
import org.opensearch.http.CorsHandler;
                }
                clusterSettings,  
                } finally {  
                settings,
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");  
        try (
                        return Http2SecurityUtil.CIPHERS;
/**
        }  
                networkService,
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));
            )
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                secureHttpTransportSettingsProvider,
                xContentRegistry(),
                return Optional.of(engine);
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
     * @throws InterruptedException if the client communication with the server is interrupted
            final CountDownLatch channelClosedLatch = new CountDownLatch(1);
 * compatible open source license.
    private NetworkService networkService;
            transport.start();
        networkService = null;
 * Tests for the secure {@link ReactorNetty4HttpServerTransport} class.  
            )  
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(  
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
import org.opensearch.transport.reactor.SharedGroupFactory;
                } finally {
                    settings,  
                    xContentRegistry(),
import org.junit.After;  
            maxInitialLineLength = randomIntBetween(1, 8192);
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                request.headers().add(CorsHandler.ORIGIN, "google.com");
     *
import static org.opensearch.test.KeyStoreUtils.KEYSTORE_PASSWORD;
                }
        ) {  
                    HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(),  
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
            connect.channel().closeFuture().addListener(future -> channelClosedLatch.countDown());
        final Settings settings = createSettings();  
/*  
            PooledByteBufAllocatorMetric metric = ((PooledByteBufAllocator) delegate).metric();  
                    response.release();  
            // Test pre-flight request
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        ).build();  
                } finally {
                    }  
                NoopTracer.INSTANCE  
            }
                new NullDispatcher(),
                try {
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");
import io.netty.buffer.ByteBufUtil;  
            ) {
        ByteBufAllocator allocator = NettyAllocator.getAllocator();
                }
        ) {
                bigArrays,
                HttpUtil.setContentLength(request, contentLength);
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);  
                secureHttpTransportSettingsProvider,
    public void testDispatchFailed() throws InterruptedException {
}
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength);
        Settings settings = createSettings();
    }  
     * Test that {@link ReactorNetty4HttpServerTransport} supports the "Expect: 100-continue" HTTP header
                    response.release();
    private long getHugeAllocationCount() {  
                new SharedGroupFactory(settings),  
            public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {  
     * Test that {@link ReactorNetty4HttpServerTransport} responds to an unsupported expectation with a 417 status.  
import io.netty.channel.socket.nio.NioSocketChannel;
                    @Override
package org.opensearch.http.reactor.netty4.ssl;
                threadPool,
    @Before
    private void runExpectHeaderTest(final Settings settings, final String expectation, final int contentLength)  
                bigArrays,
            transport.start();  
        return Settings.builder()
            public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {
import org.junit.Before;
                ReactorNetty4HttpServerTransport otherTransport = new ReactorNetty4HttpServerTransport(
import org.opensearch.test.OpenSearchTestCase;
import javax.net.ssl.SSLException;
        return numOfHugAllocations;  
                dispatcher,
import io.netty.buffer.Unpooled;
import org.opensearch.threadpool.TestThreadPool;
                    clusterSettings,  
                final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), request, continuationRequest);  
            @Override
                    assertThat(getHugeAllocationCount(), equalTo(numOfHugeAllocations));  
                secureHttpTransportSettingsProvider,
                }
        final Settings settings = createSettings();
                threadPool,
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
import javax.net.ssl.SSLEngine;
        if (delegate instanceof PooledByteBufAllocator) {
                dispatcher,
        }
            }  
                new SharedGroupFactory(settings),
                .put("network.host", remoteAddress.getAddress())
                    assertThat(new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8), is("done"));  
                    @Override  
import org.opensearch.rest.BytesRestResponse;  
        ByteBufAllocator delegate = ((NettyAllocator.NoDirectBuffers) allocator).getDelegate();
import io.netty.channel.socket.SocketChannel;  
 * SPDX-License-Identifier: Apache-2.0
        final int maxInitialLineLength;
            transport.start();
    public void setup() throws Exception {  
        }
            }
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));
        secureHttpTransportSettingsProvider = new SecureHttpTransportSettingsProvider() {  
                )
import org.opensearch.common.network.NetworkAddress;  
import io.netty.handler.codec.http2.Http2SecurityUtil;
                request.headers().set(HttpHeaderNames.EXPECT, expectation);
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");
    }
        ) {
                    HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.get(initialSettings)
            settings = createSettings();
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
