            transport.start();
import io.netty.handler.codec.http.FullHttpResponse;
                        return Optional.of(InsecureTrustManagerFactory.INSTANCE);
            for (int i = 0; i < numRequests; i++) {
                        return Optional.empty();
                xContentRegistry(),
                return Optional.of(engine);
import org.opensearch.transport.reactor.SharedGroupFactory;
    private Settings createSettings() {
        final ToXContent[] chunks = newChunks(responseString);
            HttpRequest request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
import java.io.UncheckedIOException;
    private Settings.Builder createBuilderWithPort() {
                secureHttpTransportSettingsProvider,
    }
                settings,
import static org.opensearch.test.KeyStoreUtils.KEYSTORE_PASSWORD;
            }
        ) {
            );
            threadPool.shutdownNow();
    }
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
        final ToXContent[] chunks = newChunks(responseString);
import org.opensearch.http.HttpTransportSettings;
        networkService = null;
                    response.content().readBytes(bytes);
import io.netty.handler.codec.http.HttpRequest;
                            throw new UncheckedIOException(ex);
                    public Optional<TrustManagerFactory> trustManagerFactory() {
            assertThat(transport.stats().getServerOpen(), equalTo(0L));
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.common.settings.Settings;
 */
import java.util.Arrays;
                    @Override
                NoopTracer.INSTANCE
                    public Collection<String> cipherSuites() {
                    }).collect(Collectors.joining("\r\n", "", "\r\n"))));
    @After
import org.opensearch.common.xcontent.XContentType;
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
            @Override
        try (
import io.netty.handler.codec.http.HttpMethod;
                        }
import java.io.IOException;
    private ClusterSettings clusterSettings;
                    public Collection<String> protocols() {
import org.junit.Before;
import static org.hamcrest.Matchers.equalTo;
    public void testConnectionsGettingClosedForStreamingRequests() throws InterruptedException {
        secureHttpTransportSettingsProvider = new SecureHttpTransportSettingsProvider() {
        networkService = new NetworkService(Collections.emptyList());
                clusterSettings,
import org.opensearch.threadpool.TestThreadPool;
import java.util.Collection;
                    .build()
        if (threadPool != null) {
import org.opensearch.http.reactor.netty4.AbstractReactorNetty4HttpServerTransportStreamingTests;
import org.opensearch.common.settings.ClusterSettings;
                }
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
                        try (XContentBuilder builder = XContentType.JSON.contentBuilder()) {
            transport.start();
        final String responseString = randomAlphaOfLength(4 * 1024);
            }
import javax.net.ssl.SSLEngine;
    public void setup() throws Exception {
        }
/*
            }
            .put(HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(), randomBoolean());
            public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {
                        } catch (final IOException ex) {
import org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport;
                    @Override
        final Settings settings = createSettings();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                    public Optional<String> sslProvider() {
                HttpRequest request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
import java.util.Optional;
            @Override
                dispatcher,
        try (
import org.opensearch.test.KeyStoreUtils;
                networkService,
                } finally {
        bigArrays = null;
        return createBuilderWithPort().build();
        clusterSettings = null;
import javax.net.ssl.SSLException;
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
import org.opensearch.transport.NettyAllocator;
import org.opensearch.common.util.MockPageCacheRecycler;
                threadPool,
                networkService,
                } finally {
    }
                final FullHttpResponse response = client.stream(remoteAddress.address(), request, Arrays.stream(chunks));
            }
            long numRequests = randomLongBetween(5L, 15L);
                    }
                dispatcher,
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.HttpResponseStatus;
                        return Arrays.asList(SslUtils.DEFAULT_SSL_PROTOCOLS);
import org.opensearch.core.common.transport.TransportAddress;
                });
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
            ReactorHttpClient client = ReactorHttpClient.https(settings)
import java.util.Collections;
                        return Optional.empty();
                try {
                bigArrays,
                        return Http2SecurityUtil.CIPHERS;
                secureHttpTransportSettingsProvider,
    }
public class SecureReactorNetty4HttpServerTransportStreamingTests extends AbstractReactorNetty4HttpServerTransportStreamingTests {
                    }
    private MockBigArrays bigArrays;
            .put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange())
                final FullHttpResponse response = client.stream(remoteAddress.address(), request, Arrays.stream(chunks));
                    response.release();
 * this file be licensed under the Apache-2.0 license or a
                    }
import javax.net.ssl.KeyManagerFactory;
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
                new SharedGroupFactory(settings),
    public void shutdown() {
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
 * The OpenSearch Contributors require contributions made to
    private NetworkService networkService;
        keyManagerFactory.init(KeyStoreUtils.createServerKeyStore(Algorithm.ecp384), KEYSTORE_PASSWORD);
                logger.info("Sending request {}/{}", i + 1, numRequests);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                SSLEngine engine = SslContextBuilder.forServer(keyManagerFactory)
                xContentRegistry(),
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
                NoopTracer.INSTANCE
        final HttpServerTransport.Dispatcher dispatcher = createStreamingDispatcher(threadPool, url, responseString);
                    }
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
import org.opensearch.core.xcontent.XContentBuilder;
                    @Override
import java.nio.charset.StandardCharsets;
                clusterSettings,
    private SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
import org.junit.After;
        final String url = "/stream/";
        ) {
/**
    }
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                    response.release();
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
                    .newEngine(NettyAllocator.getAllocator());
                try {
import io.netty.pkitesting.CertificateBuilder.Algorithm;
    @Before
                }
import io.netty.handler.codec.http.DefaultHttpRequest;
                threadPool,
                bigArrays,
            @Override
                    }
                    @Override
                    public Optional<String> clientAuth() {
import javax.net.ssl.TrustManagerFactory;
 * SPDX-License-Identifier: Apache-2.0
        var keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
}
                    }
 */
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.stream.Collectors;
        threadPool = null;
import org.opensearch.http.HttpServerTransport;
                    @Override
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                        return Optional.of(keyManagerFactory);
package org.opensearch.http.reactor.netty4.ssl;
 * Tests for the secure {@link ReactorNetty4HttpServerTransport} class.
        final String responseString = randomAlphaOfLength(4 * 1024);
 *
            assertThat(transport.stats().getTotalOpen(), equalTo(numRequests));
        threadPool = new TestThreadPool("test");
            }
        }
import org.opensearch.plugins.TransportExceptionHandler;
                            return s.toXContent(builder, ToXContent.EMPTY_PARAMS).toString();
import org.opensearch.common.network.NetworkService;
            public Optional<SecureHttpTransportParameters> parameters(Settings settings) {
            )
    }
    private ThreadPool threadPool;
                new SharedGroupFactory(settings),
import io.netty.handler.codec.http2.Http2SecurityUtil;
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(Arrays.stream(newChunks(responseString)).map(s -> {
            public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {
        final String url = "/stream/";
        }
                    byte[] bytes = new byte[response.content().readableBytes()];
        final Settings settings = createSettings();
        };
import org.opensearch.common.util.MockBigArrays;
import io.netty.handler.ssl.SslContextBuilder;
                settings,
    public void testRequestResponseStreaming() throws InterruptedException {
 * compatible open source license.
                return Optional.empty();
import org.opensearch.test.BouncyCastleThreadFilter;
import org.opensearch.http.reactor.netty4.ReactorHttpClient;
                    @Override
        return Settings.builder()
import org.opensearch.threadpool.ThreadPool;
        final HttpServerTransport.Dispatcher dispatcher = createStreamingDispatcher(threadPool, url, responseString);
                    public Optional<KeyManagerFactory> keyManagerFactory() {
                return Optional.of(new SecureHttpTransportParameters() {
