import org.opensearch.plugins.SecureHttpTransportSettingsProvider;  
import java.util.Arrays;
            threadPool.shutdownNow();
 *
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import org.junit.Before;
import io.netty.handler.codec.http2.Http2SecurityUtil;
                logger.info("Sending request {}/{}", i + 1, numRequests);  
            }
            }
    private ClusterSettings clusterSettings;  
                        return Optional.of(InsecureTrustManagerFactory.INSTANCE);
                dispatcher,
    private SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
            try (ReactorHttpClient client = ReactorHttpClient.https(settings)) {
            )  
import io.netty.handler.codec.http.DefaultHttpRequest;
            transport.start();
        bigArrays = null;  
        var keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
                NoopTracer.INSTANCE  
import org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.opensearch.threadpool.TestThreadPool;
                } finally {
                bigArrays,
                    public Optional<String> clientAuth() {
        final Settings settings = createSettings();  
import org.opensearch.plugins.TransportExceptionHandler;
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());
                    .newEngine(NettyAllocator.getAllocator());
                try {
                return Optional.of(new SecureHttpTransportParameters() {
            public Optional<SecureHttpTransportParameters> parameters(Settings settings) {  
                });
import javax.net.ssl.SSLException;
import java.io.IOException;
                    }
                networkService,  
        final ToXContent[] chunks = newChunks(responseString);
                    @Override  
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));  
    }  
                xContentRegistry(),
            @Override
import javax.net.ssl.KeyManagerFactory;  
                new SharedGroupFactory(settings),
                settings,
            }
package org.opensearch.http.reactor.netty4.ssl;
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.core.xcontent.ToXContent;
    }  
                    public Optional<TrustManagerFactory> trustManagerFactory() {
                xContentRegistry(),  
 * this file be licensed under the Apache-2.0 license or a
                    response.content().readBytes(bytes);
                    @Override
                final FullHttpResponse response = client.stream(remoteAddress.address(), request, Arrays.stream(chunks));
                        try (XContentBuilder builder = XContentType.JSON.contentBuilder()) {
import org.opensearch.transport.reactor.SharedGroupFactory;
                        return Http2SecurityUtil.CIPHERS;  
                secureHttpTransportSettingsProvider,
        final String responseString = randomAlphaOfLength(4 * 1024);  
import io.netty.handler.ssl.SslContextBuilder;  
import io.netty.handler.codec.http.HttpResponseStatus;  
    @Before  
import org.junit.After;  
        };
                    @Override  
import static org.opensearch.test.KeyStoreUtils.KEYSTORE_PASSWORD;
        final String url = "/stream/";
import java.nio.charset.StandardCharsets;
        try (  
                    }
import org.opensearch.http.HttpTransportSettings;
                    response.release();
            }
        return createBuilderWithPort().build();
            assertThat(transport.stats().getTotalOpen(), equalTo(numRequests));  
    private NetworkService networkService;  
        final HttpServerTransport.Dispatcher dispatcher = createStreamingDispatcher(threadPool, url, responseString);
        threadPool = new TestThreadPool("test");  
    private Settings.Builder createBuilderWithPort() {
        final String url = "/stream/";  
                bigArrays,
                dispatcher,
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
import io.netty.pkitesting.CertificateBuilder.Algorithm;
    public void testRequestResponseStreaming() throws InterruptedException {
                            return s.toXContent(builder, ToXContent.EMPTY_PARAMS).toString();
            public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {
                try {
    }  
                HttpRequest request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);  
                threadPool,  
                        return Optional.of(keyManagerFactory);
        return Settings.builder()  
        final String responseString = randomAlphaOfLength(4 * 1024);
 * The OpenSearch Contributors require contributions made to  
            long numRequests = randomLongBetween(5L, 15L);
                clusterSettings,  
            for (int i = 0; i < numRequests; i++) {
import javax.net.ssl.SSLEngine;
        }
            );
            transport.start();
        final Settings settings = createSettings();
import org.opensearch.test.KeyStoreUtils;
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(Arrays.stream(newChunks(responseString)).map(s -> {  
                threadPool,
}
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
            HttpRequest request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);  
        }
            @Override
        networkService = null;
                final FullHttpResponse response = client.stream(remoteAddress.address(), request, Arrays.stream(chunks));
    public void testConnectionsGettingClosedForStreamingRequests() throws InterruptedException {
                            throw new UncheckedIOException(ex);
            @Override  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    @After
                        return Optional.empty();  
import java.util.stream.Collectors;  
    }  
                SSLEngine engine = SslContextBuilder.forServer(keyManagerFactory)
        final HttpServerTransport.Dispatcher dispatcher = createStreamingDispatcher(threadPool, url, responseString);
            .put(HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(), randomBoolean());
import java.util.Optional;
                    }  
import org.opensearch.common.xcontent.XContentType;
            assertThat(transport.stats().getServerOpen(), equalTo(0L));
import org.opensearch.test.BouncyCastleThreadFilter;  
import static org.hamcrest.Matchers.equalTo;
import java.util.Collections;
                    }
import org.opensearch.http.reactor.netty4.AbstractReactorNetty4HttpServerTransportStreamingTests;  
            public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {
                    }
                clusterSettings,
import org.opensearch.common.util.MockBigArrays;  
import org.opensearch.common.network.NetworkService;  
    private ThreadPool threadPool;
        keyManagerFactory.init(KeyStoreUtils.createServerKeyStore(Algorithm.ecp384), KEYSTORE_PASSWORD);
        ) {
        try (
 */  
import org.opensearch.http.reactor.netty4.ReactorHttpClient;
                return Optional.empty();  
import java.util.Collection;  
                    .build()
                        return Optional.empty();
import org.opensearch.core.common.transport.TransportAddress;  
                        return Arrays.asList(SslUtils.DEFAULT_SSL_PROTOCOLS);
        }  
 */  
    }
                }  
            }
import java.io.UncheckedIOException;  
                    public Optional<KeyManagerFactory> keyManagerFactory() {  
 * Tests for the secure {@link ReactorNetty4HttpServerTransport} class.
                    @Override
                    }  
                return Optional.of(engine);  
/*  
        secureHttpTransportSettingsProvider = new SecureHttpTransportSettingsProvider() {
import org.opensearch.common.settings.Settings;
    public void setup() throws Exception {
import org.opensearch.http.HttpServerTransport;
public class SecureReactorNetty4HttpServerTransportStreamingTests extends AbstractReactorNetty4HttpServerTransportStreamingTests {
        if (threadPool != null) {
import org.opensearch.transport.NettyAllocator;
                    public Collection<String> cipherSuites() {
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
import javax.net.ssl.TrustManagerFactory;  
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        threadPool = null;
                }  
        ) {  
    private MockBigArrays bigArrays;
                    @Override
                    response.release();
        networkService = new NetworkService(Collections.emptyList());
                NoopTracer.INSTANCE
import io.netty.handler.codec.http.HttpRequest;
                    byte[] bytes = new byte[response.content().readableBytes()];
import org.opensearch.common.settings.ClusterSettings;
        clusterSettings = null;
        final ToXContent[] chunks = newChunks(responseString);  
 * SPDX-License-Identifier: Apache-2.0
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                secureHttpTransportSettingsProvider,
            .put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange())
                    public Collection<String> protocols() {  
/**
import io.netty.handler.codec.http.FullHttpResponse;  
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)  
                        }
                    }).collect(Collectors.joining("\r\n", "", "\r\n"))));  
                    @Override
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));  
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
                    public Optional<String> sslProvider() {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
    private Settings createSettings() {
                networkService,
                new SharedGroupFactory(settings),  
    public void shutdown() {  
                } finally {
import org.opensearch.common.util.MockPageCacheRecycler;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
                settings,  
import org.opensearch.core.xcontent.XContentBuilder;  
                        } catch (final IOException ex) {  
    }
            ReactorHttpClient client = ReactorHttpClient.https(settings)
 * compatible open source license.
