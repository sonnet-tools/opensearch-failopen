                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
                settings,
                    public Optional<KeyManagerFactory> keyManagerFactory() {
            Settings settings = Settings.builder()
                    @Override
    private Settings.Builder createBuilderWithPort() {
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
import java.util.concurrent.atomic.AtomicReference;
                new NullDispatcher(),
                dispatcher,
            public Optional<SecureHttpTransportParameters> parameters(Settings settings) {
            public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {
package org.opensearch.http.netty4;
                }
import static org.opensearch.core.rest.RestStatus.OK;
                    assertThat(response.status(), equalTo(HttpResponseStatus.BAD_REQUEST));
                            HttpMethod.POST,
                xContentRegistry(),
    private MockBigArrays bigArrays;
import static org.hamcrest.Matchers.equalTo;
            transport.start();
 */
            transport.start();
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {
import io.netty.handler.codec.http.FullHttpRequest;
                }
                    }
                    @Override
import static org.hamcrest.Matchers.containsString;
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
                clusterSettings,
                return Optional.of(new SecureHttpTransportParameters() {
            }
import io.netty.handler.codec.http2.Http2SecurityUtil;
                dispatcher,
                    }
                    @Override
            // Test pre-flight request
import static org.junit.Assume.assumeThat;
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");
        final Settings settings = createSettings();
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        final HttpResponseStatus expectedStatus
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                if (url.equals(request.uri())) {
     * Test that {@link Netty4Http3ServerTransportTests} responds to a
        final int contentLength,
        final Settings settings;
        if (randomBoolean()) {
import static org.opensearch.core.rest.RestStatus.BAD_REQUEST;
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")
        runExpectHeaderTest(settings, "chocolate=yummy", 0, HttpResponseStatus.EXPECTATION_FAILED);
        ) {
                    assertThat(response.status(), equalTo(expectedStatus));
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                settings,
        final Settings settings = createSettings();
import org.opensearch.test.KeyStoreUtils;
                }
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());
                            "/",
import org.opensearch.http.netty4.http3.Http3Utils;
     * 100-continue expectation with too large a content-length
 */
        };
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import org.opensearch.http.CorsHandler;
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
        }
import org.opensearch.common.util.MockBigArrays;
                    @Override
                    settings,
import javax.net.ssl.KeyManagerFactory;
        final Settings initialSettings = createSettings();
                xContentRegistry(),
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, randomFrom("deflate", "gzip"));
                final SSLEngine engine = SslContextBuilder.forServer(keyManagerFactory)
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));
        final int maxContentLength = randomIntBetween(1, 104857600);
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);
        }
                try {
        final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
                secureHttpTransportSettingsProvider,
        if (threadPool != null) {
    /**
     * Test that {@link Netty4Http3ServerTransportTests} supports the "Expect: 100-continue" HTTP header
                networkService,
                            continuationResponse.release();
            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();
                try {
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)
import io.netty.handler.codec.http.HttpHeaderNames;
                        return Optional.of(keyManagerFactory);
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {
                    }
                        return Http2SecurityUtil.CIPHERS;
 * SPDX-License-Identifier: Apache-2.0
     */
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
    }
     */
            )
import java.io.IOException;
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                    }
        threadPool = new TestThreadPool("test");
            maxInitialLineLength = randomIntBetween(1, 8192);
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));
                        try {
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
}
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(
                    @Override
     * Test that {@link Netty4Http3ServerTransportTests} responds to an unsupported expectation with a 417 status.
                initialSettings,
        }
    /**
            @Override
import static org.hamcrest.Matchers.is;
                bigArrays,
    ) throws InterruptedException {
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
    }
            try (
import java.util.Collection;
import org.opensearch.common.settings.Setting;
                threadPool,
                    }
                    }
                    );
import static org.hamcrest.Matchers.instanceOf;
                NoopTracer.INSTANCE
                .put("http.port", remoteAddress.getPort())
 * The OpenSearch Contributors require contributions made to
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));
                        new String(response.content().array(), StandardCharsets.UTF_8),
import io.netty.handler.codec.http.DefaultFullHttpRequest;
        final int maxInitialLineLength;
    private NetworkService networkService;
        ) {
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
import io.netty.pkitesting.CertificateBuilder.Algorithm;
public class Netty4Http3ServerTransportTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rest.BytesRestResponse;
                    @Override
                    public Collection<String> cipherSuites() {
        final String url = "/thing";
                            HttpVersion.HTTP_1_1,
                    secureHttpTransportSettingsProvider,
            (channel, threadContext, cause) -> {
                        }
                    assertTrue(response.headers().contains(CorsHandler.DATE));
    public void testCorsRequest() throws InterruptedException {
                bigArrays,
 * compatible open source license.
                networkService,
        ).build();
                secureHttpTransportSettingsProvider,
                request.headers().set(HttpHeaderNames.EXPECT, expectation);
import org.opensearch.test.OpenSearchTestCase;
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));
                NoopTracer.INSTANCE
                        );
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
            public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {
 * Tests for the {@link Netty4Http3ServerTransport} class.
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {
            )
import org.junit.After;
            settings = createSettings();
        clusterSettings = null;
            @Override
                            );
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
import io.netty.handler.codec.http.FullHttpResponse;
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                try {
                }
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
    }
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchBadRequest(
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))
        assertNotNull(causeReference.get());
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        }
import org.opensearch.common.network.NetworkService;
            threadPool.shutdownNow();
            .build();
                )
import javax.net.ssl.TrustManagerFactory;
                    bigArrays,
        final Settings settings,
                        return Optional.empty();
        final String expectation,
                        final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), continuationRequest);
                    response.release();
                    }
    public void testExpectContinueHeader() throws InterruptedException {
                } finally {
                new SharedGroupFactory(settings),
                xContentRegistry(),
            )
import java.util.Arrays;
                return Optional.empty();
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
import org.opensearch.http.NullDispatcher;
                new SharedGroupFactory(initialSettings),
    public void testExpectUnsupportedExpectation() throws InterruptedException {
                NoopTracer.INSTANCE
            @Override
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());
            }
        try (
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);
            transport.start();
                xContentRegistry(),
    public void shutdown() throws Exception {
/**
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    public void setup() throws Exception {
            )
    }
                NoopTracer.INSTANCE
    @After
import org.opensearch.common.settings.ClusterSettings;
                    .build()
        try (
import org.opensearch.transport.NettyAllocator;
    private SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
import io.netty.handler.ssl.SslContextBuilder;
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();
            }
import org.opensearch.plugins.TransportExceptionHandler;
            }
    public void testBadRequest() throws InterruptedException {
                xContentRegistry(),
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(
            }
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                        return Optional.empty();
                    new NullDispatcher(),
     * @throws InterruptedException if the client communication with the server is interrupted
                bigArrays,
                networkService,
        keyManagerFactory.init(KeyStoreUtils.createServerKeyStore(Algorithm.ecp384), KEYSTORE_PASSWORD);
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();
                    byte[] bytes = new byte[response.content().readableBytes()];
                }
            }
                try {
                } finally {
     * @throws InterruptedException if the client communication with the server is interrupted
        ).build();
                    channel.sendResponse(new BytesRestResponse(channel, BAD_REQUEST, e));
                    .newEngine(NettyAllocator.getAllocator());
                            Unpooled.EMPTY_BUFFER
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");
                .put("network.host", remoteAddress.getAddress())
                final String url = "/" + randomAlphaOfLength(maxInitialLineLength);
                new SharedGroupFactory(settings),
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
    }
                }
                HttpUtil.setContentLength(request, contentLength);
                bigArrays,
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(
                    networkService,
        threadPool = null;
import org.opensearch.transport.netty4.ssl.SslUtils;
                causeReference.set(cause);
        bigArrays = null;
        ) {
            transport.start();
                secureHttpTransportSettingsProvider,
        final AtomicReference<Throwable> causeReference = new AtomicReference<>();
                    channel.sendResponse(new BytesRestResponse(OK, responseString));
    }
                    response.release();
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
    }
        try (
                dispatcher,
import java.util.Collections;
                    NoopTracer.INSTANCE
import org.opensearch.transport.SharedGroupFactory;
                    response.release();
                } finally {
    private ThreadPool threadPool;
                } else {
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;
                new SharedGroupFactory(settings),
 *
                    throw new AssertionError();
        return Settings.builder().put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange());
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(
                    final OpenSearchException e = new OpenSearchException("you sent a bad request and you should feel bad");
        secureHttpTransportSettingsProvider = new SecureHttpTransportSettingsProvider() {
                threadPool,
    }
    private Settings createSettings() {
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {
        try (
import org.opensearch.core.common.transport.TransportAddress;
import io.netty.handler.codec.http.HttpResponseStatus;
        networkService = null;
                secureHttpTransportSettingsProvider,
        try (
/*
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {
            )
                networkService,
                return Optional.of(engine);
    @Before
            }
                        return Optional.of(InsecureTrustManagerFactory.INSTANCE);
    public void testLargeCompressedResponse() throws InterruptedException {
                threadPool,
                request.headers().add(CorsHandler.ORIGIN, "google.com");
        networkService = new NetworkService(Collections.emptyList());
            ) {
import org.opensearch.core.common.unit.ByteSizeValue;
                threadPool,
                } catch (final IOException e) {
import io.netty.handler.codec.http.HttpHeaderValues;
                bigArrays,
                    public Collection<String> protocols() {
    }
                secureHttpTransportSettingsProvider,
        }
import io.netty.handler.codec.http.HttpVersion;
                    logger.error("--> Unexpected successful uri [{}]", request.uri());
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.CONTINUE);
    private ClusterSettings clusterSettings;
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
                networkService,
                    response.content().readBytes(bytes);
import org.opensearch.http.HttpTransportSettings;
                NoopTracer.INSTANCE
                        containsString("you sent a bad request and you should feel bad")
    public void testBindUnavailableAddress() {
                    xContentRegistry(),
import org.opensearch.threadpool.TestThreadPool;
                } finally {
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
        ).build();
                    public Optional<String> clientAuth() {
                clusterSettings,
            }
        ) {
        final Settings settings = createSettings();
import io.netty.handler.codec.TooLongFrameException;
                                new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8),
                    public Optional<TrustManagerFactory> trustManagerFactory() {
import io.netty.buffer.ByteBufUtil;
                threadPool,
                    public Optional<String> sslProvider() {
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();
                });
import static org.opensearch.test.KeyStoreUtils.KEYSTORE_PASSWORD;
            )
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
import org.opensearch.common.util.MockPageCacheRecycler;
            }
            }
import org.opensearch.common.network.NetworkAddress;
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");
                        } finally {
            }
import org.junit.Before;
        }
import javax.net.ssl.SSLException;
import io.netty.handler.codec.http.HttpUtil;
            (request, channel, threadContext) -> channel.sendResponse(
                        final FullHttpRequest continuationRequest = new DefaultFullHttpRequest(
import org.opensearch.threadpool.ThreadPool;
        }
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
import io.netty.handler.codec.http.HttpMethod;
     * @throws InterruptedException if the client communication with the server is interrupted
                            assertThat(
                    response.release();
        ) {
                    response.release();
                .build();
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
                    throw new AssertionError(e);
                settings,
                                is("done")
                new SharedGroupFactory(settings),
    private void runExpectHeaderTest(
            (request, channel, threadContext) -> {
                clusterSettings,
                    threadPool,
                    if (expectedStatus.equals(HttpResponseStatus.CONTINUE)) {
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(
        assertThat(causeReference.get(), instanceOf(TooLongFrameException.class));
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");
                Netty4Http3ServerTransport otherTransport = new Netty4Http3ServerTransport(
import org.opensearch.http.BindHttpException;
                try {
import javax.net.ssl.SSLEngine;
            transport.start();
import java.util.Optional;
import org.opensearch.OpenSearchException;
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);
                try {
                clusterSettings,
                dispatcher,
     */
    /**
                    clusterSettings,
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
import org.opensearch.http.HttpServerTransport;
    }
import java.nio.charset.StandardCharsets;
     * with a 413 status.
                        return Arrays.asList(SslUtils.DEFAULT_SSL_PROTOCOLS);
        } else {
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
            // Test short-circuited request
        return createBuilderWithPort().build();
                } finally {
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
                    new SharedGroupFactory(settings),
    }
import org.opensearch.common.settings.Settings;
                }
    }
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {
                    assertThat(
import io.netty.buffer.Unpooled;
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                            assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));
                settings,
