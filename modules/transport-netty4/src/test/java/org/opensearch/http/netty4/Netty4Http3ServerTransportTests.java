                new SharedGroupFactory(settings),
 */  
                try {
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));  
            }
            }
        }
import org.junit.After;  
                request.headers().set(HttpHeaderNames.EXPECT, expectation);
    private NetworkService networkService;
        }
            try (
    }  
                try {
import org.opensearch.common.settings.Settings;  
     * 100-continue expectation with too large a content-length
            )
                    assertThat(response.status(), equalTo(expectedStatus));  
                if (url.equals(request.uri())) {
import org.opensearch.transport.NettyAllocator;  
import io.netty.handler.codec.http.HttpUtil;
    }
import io.netty.handler.codec.TooLongFrameException;  
                            );
            @Override
        if (threadPool != null) {  
import org.opensearch.core.common.unit.ByteSizeValue;
                        final FullHttpRequest continuationRequest = new DefaultFullHttpRequest(
                DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
                request.headers().add(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, "POST");
            TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
        final int contentLength,  
        return Settings.builder().put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange());
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {
        final Settings settings = createSettings();
                threadPool,  
                clusterSettings,  
                networkService,
            }
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;
        try (  
    @After
            settings = createSettings();
 * Tests for the {@link Netty4Http3ServerTransport} class.
                new BytesRestResponse(OK, BytesRestResponse.TEXT_CONTENT_TYPE, new BytesArray("done"))
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
            maxInitialLineLength = httpMaxInitialLineLengthSetting.getDefault(Settings.EMPTY).bytesAsInt();  
                    response.release();
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.OPTIONS, "/");
        final AtomicReference<Throwable> causeReference = new AtomicReference<>();
                    @Override
                networkService,
            }
                NoopTracer.INSTANCE
                new NullDispatcher(),
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));  
import static org.opensearch.test.KeyStoreUtils.KEYSTORE_PASSWORD;
    public void testBadRequest() throws InterruptedException {
    public void setup() throws Exception {  
            transport.start();  
                try {
                    @Override
        final int contentLength = randomIntBetween(maxContentLength + 1, Integer.MAX_VALUE);  
import static org.hamcrest.Matchers.is;  
    }  
                    response.release();
                bigArrays,
    public void testExpectContinueHeaderContentLengthTooLong() throws InterruptedException {  
import static org.opensearch.core.rest.RestStatus.OK;
import java.util.Arrays;
                final String url = "/" + randomAlphaOfLength(maxInitialLineLength);
        assertNotNull(causeReference.get());
                secureHttpTransportSettingsProvider,
                                is("done")
    }
import org.opensearch.rest.BytesRestResponse;  
                        return Http2SecurityUtil.CIPHERS;
                    channel.sendResponse(new BytesRestResponse(channel, BAD_REQUEST, e));
                    threadPool,
                            continuationResponse.release();
        final String url = "/thing";
    }
     */  
import java.util.Collection;
            .build();
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
                    public Collection<String> cipherSuites() {
        ) {  
                    channel.sendResponse(new BytesRestResponse(OK, responseString));  
            Settings settings = Settings.builder()
     * Test that {@link Netty4Http3ServerTransportTests} supports the "Expect: 100-continue" HTTP header
                        return Arrays.asList(SslUtils.DEFAULT_SSL_PROTOCOLS);  
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {  
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
import org.opensearch.common.settings.ClusterSettings;
                bigArrays,  
                        );
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
                        try {  
 * this file be licensed under the Apache-2.0 license or a
        ).build();  
import io.netty.handler.codec.http.HttpVersion;  
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {  
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(
    }
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.FullHttpResponse;  
        final String expectation,
import io.netty.handler.ssl.SslContextBuilder;
                clusterSettings,  
    }
            }  
        }
                        final FullHttpResponse continuationResponse = client.send(remoteAddress.address(), continuationRequest);
    @Before
                dispatcher,
     * Test that {@link Netty4Http3ServerTransportTests} responds to an unsupported expectation with a 417 status.
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            )  
            public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.CONTINUE);  
            }  
    /**
                        new String(response.content().array(), StandardCharsets.UTF_8),
        final Settings settings = createSettings();
            )
                bigArrays,
            maxInitialLineLength = randomIntBetween(1, 8192);  
                .put("http.port", remoteAddress.getPort())
                }
import org.opensearch.transport.SharedGroupFactory;
        ) {
 *
            }
import org.opensearch.http.CorsHandler;
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "/");  
                            "/",
            @Override  
     * @throws InterruptedException if the client communication with the server is interrupted
        runExpectHeaderTest(settings, "chocolate=yummy", 0, HttpResponseStatus.EXPECTATION_FAILED);  
    public void testLargeCompressedResponse() throws InterruptedException {  
                    public Optional<TrustManagerFactory> trustManagerFactory() {  
                threadPool,  
                    .build()  
                } finally {
        final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("PKIX");  
                    @Override  
        try (
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            }
 * SPDX-License-Identifier: Apache-2.0
                    assertThat(response.status(), equalTo(HttpResponseStatus.FORBIDDEN));  
                secureHttpTransportSettingsProvider,
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().build();
                    public Optional<KeyManagerFactory> keyManagerFactory() {
        runExpectHeaderTest(settings, HttpHeaderValues.CONTINUE.toString(), contentLength, HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE);
                        return Optional.of(keyManagerFactory);  
                    networkService,
import javax.net.ssl.KeyManagerFactory;  
            (request, channel, threadContext) -> channel.sendResponse(  
    private Settings.Builder createBuilderWithPort() {  
        try (
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {
                } finally {
                    assertThat(response.headers().get(CorsHandler.VARY), equalTo(CorsHandler.ORIGIN));
import org.opensearch.common.settings.Setting;
        if (randomBoolean()) {
import org.opensearch.common.util.MockBigArrays;
                    response.content().readBytes(bytes);
        }  
            public Optional<SecureHttpTransportParameters> parameters(Settings settings) {
                    response.release();
     * with a 413 status.  
                    assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), equalTo("test-cors.org"));  
                clusterSettings,
    public void testBindUnavailableAddress() {
        final Settings settings,
            transport.start();  
                    new NullDispatcher(),  
                                new String(ByteBufUtil.getBytes(continuationResponse.content()), StandardCharsets.UTF_8),  
                xContentRegistry(),  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
                        } finally {  
                bigArrays,
                    public Collection<String> protocols() {
                request.headers().add(CorsHandler.ORIGIN, "google.com");
                    );
     * @throws InterruptedException if the client communication with the server is interrupted  
 * compatible open source license.
                    assertThat(
        secureHttpTransportSettingsProvider = new SecureHttpTransportSettingsProvider() {  
import io.netty.handler.codec.http.FullHttpRequest;
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
                new SharedGroupFactory(settings),
                    }  
                            HttpVersion.HTTP_1_1,  
        final String key = HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.getKey();  
            ) {  
    }
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
            settings = createBuilderWithPort().put(httpMaxInitialLineLengthSetting.getKey(), maxInitialLineLength + "b").build();
    }
import java.io.IOException;
    public void testExpectUnsupportedExpectation() throws InterruptedException {
        }
                }  
import io.netty.buffer.ByteBufUtil;
                    throw new AssertionError();  
import org.opensearch.test.KeyStoreUtils;
        final String responseString = randomAlphaOfLength(4 * 1024 * 1024);
                assertEquals("Failed to bind to " + NetworkAddress.format(remoteAddress.address()), bindHttpException.getMessage());
                threadPool,  
    public void shutdown() throws Exception {
        assertThat(causeReference.get(), instanceOf(TooLongFrameException.class));  
                        return Optional.empty();
        final HttpResponseStatus expectedStatus
                try {
                BindHttpException bindHttpException = expectThrows(BindHttpException.class, otherTransport::start);
                            assertThat(continuationResponse.status(), is(HttpResponseStatus.OK));
import org.opensearch.threadpool.TestThreadPool;
import java.util.Collections;  
            }  
                        return Optional.empty();
            (channel, threadContext, cause) -> {  
        ) {
                HttpUtil.setContentLength(request, contentLength);
            }  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
import io.netty.handler.codec.http.DefaultFullHttpRequest;
                NoopTracer.INSTANCE
                }
                settings,
                    NoopTracer.INSTANCE
import io.netty.buffer.Unpooled;
                dispatcher,  
                    clusterSettings,
                secureHttpTransportSettingsProvider,  
        return createBuilderWithPort().build();  
import io.netty.handler.codec.http.HttpResponseStatus;
        final int maxContentLength = randomIntBetween(1, 104857600);
    }
/**  
                NoopTracer.INSTANCE  
                xContentRegistry(),
                .build();
     * Test that {@link Netty4Http3ServerTransportTests} responds to a
            // Test short-circuited request
                    secureHttpTransportSettingsProvider,  
                request.headers().add(CorsHandler.ORIGIN, "test-cors.org");  
                dispatcher,
                    response.release();  
        networkService = new NetworkService(Collections.emptyList());
                            Unpooled.EMPTY_BUFFER  
            try (Netty4HttpClient client = Netty4HttpClient.http3()) {
                return Optional.of(engine);
                return Optional.empty();
                threadPool,
            }
                    final OpenSearchException e = new OpenSearchException("you sent a bad request and you should feel bad");  
        final Setting<ByteSizeValue> httpMaxInitialLineLengthSetting = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
    private ClusterSettings clusterSettings;
        keyManagerFactory.init(KeyStoreUtils.createServerKeyStore(Algorithm.ecp384), KEYSTORE_PASSWORD);
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(responseString));  
        final int contentLength = randomIntBetween(1, HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).bytesAsInt());
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(
                networkService,  
                        return Optional.of(InsecureTrustManagerFactory.INSTANCE);
                    }
                    byte[] bytes = new byte[response.content().readableBytes()];
        } else {
        }
import org.opensearch.common.util.MockPageCacheRecycler;
                .put("network.host", remoteAddress.getAddress())  
        bigArrays = null;
                new SharedGroupFactory(initialSettings),  
            public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {  
                causeReference.set(cause);
    private Settings createSettings() {
        ) {
                return Optional.of(new SecureHttpTransportParameters() {  
import javax.net.ssl.TrustManagerFactory;  
import static org.hamcrest.Matchers.containsString;  
        threadPool = null;  
        ) {
import org.opensearch.common.network.NetworkService;  
import org.opensearch.core.common.bytes.BytesArray;  
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(
                clusterSettings,
        final Settings initialSettings = createSettings();
                try {
                secureHttpTransportSettingsProvider,
        final int maxInitialLineLength;  
                }  
import org.opensearch.http.HttpServerTransport;  
            Netty4Http3ServerTransport transport = new Netty4Http3ServerTransport(  
                settings,  
                    settings,
import static org.junit.Assume.assumeThat;
    private void runExpectHeaderTest(  
            )
                final FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
                    assertTrue(response.headers().contains(CorsHandler.DATE));
                Netty4Http3ServerTransport otherTransport = new Netty4Http3ServerTransport(  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                initialSettings,
            (request, channel, threadContext) -> {
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                    }
                    }
        final Settings settings = createSettings();  
                networkService,
                xContentRegistry(),
                    xContentRegistry(),
        try (
    /**  
        final Settings settings = createBuilderWithPort().put(key, maxContentLength + "b").build();
        };
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;  
import org.opensearch.http.NullDispatcher;
 */
                        }
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "test-cors.org")
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;  
import io.netty.handler.codec.http.HttpMethod;  
        }
                    logger.error("--> Unexpected successful uri [{}]", request.uri());
                final FullHttpResponse response = client.send(remoteAddress.address(), request);  
                            HttpMethod.POST,
                xContentRegistry(),
                }
            transport.start();
                    if (expectedStatus.equals(HttpResponseStatus.CONTINUE)) {
    public void testCorsRequest() throws InterruptedException {
                    public Optional<String> clientAuth() {  
     */
                });  
                final SSLEngine engine = SslContextBuilder.forServer(keyManagerFactory)
                } finally {
                        containsString("you sent a bad request and you should feel bad")  
                    throw new AssertionError(e);  
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(  
        final Settings settings;
import org.opensearch.OpenSearchException;
                    .newEngine(NettyAllocator.getAllocator());
                }  
    public void testExpectContinueHeader() throws InterruptedException {
                try {
import java.util.concurrent.atomic.AtomicReference;
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
    private ThreadPool threadPool;  
}  
    /**  
                NoopTracer.INSTANCE  
import org.opensearch.plugins.TransportExceptionHandler;
import javax.net.ssl.SSLEngine;
        final Settings settings = createBuilderWithPort().put(SETTING_CORS_ENABLED.getKey(), true)  
import org.opensearch.core.common.transport.TransportAddress;
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
import org.opensearch.http.netty4.http3.Http3Utils;  
 * The OpenSearch Contributors require contributions made to  
                settings,  
                new SharedGroupFactory(settings),
            @Override
            threadPool.shutdownNow();
public class Netty4Http3ServerTransportTests extends OpenSearchTestCase {  
                bigArrays,
                } else {
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));  
import io.netty.handler.codec.http.HttpHeaderValues;
                } finally {  
                    @Override
                    }
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));  
    ) throws InterruptedException {
                    @Override
import org.opensearch.http.BindHttpException;
                settings,  
                    new SharedGroupFactory(settings),
                dispatcher,
        networkService = null;
                } catch (final IOException e) {
package org.opensearch.http.netty4;
import io.netty.handler.codec.http2.Http2SecurityUtil;
        threadPool = new TestThreadPool("test");
                secureHttpTransportSettingsProvider,
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
import static org.hamcrest.Matchers.instanceOf;
    private MockBigArrays bigArrays;
                NoopTracer.INSTANCE  
            )
                    assertThat(response.status(), equalTo(HttpResponseStatus.BAD_REQUEST));  
                )
                new SharedGroupFactory(settings),
                    public Optional<String> sslProvider() {
import org.opensearch.transport.netty4.ssl.SslUtils;
import org.opensearch.common.network.NetworkAddress;
     * @throws InterruptedException if the client communication with the server is interrupted
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, randomFrom("deflate", "gzip"));  
                networkService,
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.http.HttpTransportSettings;
import java.nio.charset.StandardCharsets;  
                threadPool,
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));  
        clusterSettings = null;  
                    @Override  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
import javax.net.ssl.SSLException;
    }  
                } finally {
    }
    private SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;  
                    response.release();
                            assertThat(
import static org.opensearch.core.rest.RestStatus.BAD_REQUEST;  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    }  
                    bigArrays,  
            // Test pre-flight request  
        ).build();  
                xContentRegistry(),
/*  
            transport.start();  
import static org.hamcrest.Matchers.equalTo;
        ).build();  
     */
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchBadRequest(
import org.opensearch.threadpool.ThreadPool;
import java.util.Optional;
import org.junit.Before;
                    }  
                final FullHttpResponse response = client.send(remoteAddress.address(), request);
            transport.start();
            )
import io.netty.pkitesting.CertificateBuilder.Algorithm;
                }
        try (
