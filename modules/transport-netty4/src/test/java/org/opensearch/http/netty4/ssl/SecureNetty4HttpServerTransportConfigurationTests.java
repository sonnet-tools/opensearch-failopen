            return transportAdapterProviders;
                threadPool,
                NoopTracer.INSTANCE
                new NullDispatcher(),
    }
import io.netty.channel.ChannelInboundHandlerAdapter;
            }
 * SPDX-License-Identifier: Apache-2.0
            @SuppressWarnings("unchecked")
    public void setup() throws Exception {
                Settings.EMPTY,
                bigArrays,
    }
        public Collection<TransportAdapterProvider<HttpServerTransport>> getHttpTransportAdapterProviders(Settings settings) {
            @Override
        @Override
            }
            @SuppressWarnings("unchecked")
            @Override
    }
        ) {
 */
    public void testRequestDecompressorAndRequestHeaderVerifier() throws InterruptedException {
            }
            )
    }
        ) {
import org.opensearch.common.settings.Settings;
        public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {
            )
            }
    }
        }
import java.util.Optional;
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
                NoopTracer.INSTANCE
        assertThat(ex.getMessage(), equalTo("Cannot have more than one header verifier configured, supplied 2"));
        bigArrays = null;
                new ConfigurableSecureHttpTransportSettingsProvider(List.of(transportAdapterProvider, transportAdapterProvider)),
 * this file be licensed under the Apache-2.0 license or a
        if (threadPool != null) {
            threadPool.shutdownNow();
                new NullDispatcher(),
import java.util.List;
        }
        ) {
            IllegalArgumentException.class,
            }
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                return SecureNetty4HttpServerTransport.REQUEST_DECOMPRESSOR;
        final TransportAdapterProvider<HttpServerTransport> transportAdapterProvider = new TransportAdapterProvider<HttpServerTransport>() {
                clusterSettings,
            }
    }
    public void shutdown() throws Exception {
            @Override
                xContentRegistry(),
        };
    @After
                NoopTracer.INSTANCE
                new NullDispatcher(),
    }
        }
        final IllegalArgumentException ex = assertThrows(
            () -> new SecureNetty4HttpServerTransport(
                return SecureNetty4HttpServerTransport.REQUEST_HEADER_VERIFIER;
        private final List<TransportAdapterProvider<HttpServerTransport>> transportAdapterProviders;
            )
import static org.hamcrest.Matchers.equalTo;
                threadPool,
                return SecureNetty4HttpServerTransport.REQUEST_HEADER_VERIFIER;
 * Tests for the {@link SecureNetty4HttpServerTransport} class.
        clusterSettings = null;
import org.opensearch.common.util.MockPageCacheRecycler;
            }
    private ClusterSettings clusterSettings;
    private NetworkService networkService;
        final TransportAdapterProvider<HttpServerTransport> transportAdapterProvider = new TransportAdapterProvider<HttpServerTransport>() {
    private MockBigArrays bigArrays;
 * The OpenSearch Contributors require contributions made to
            final SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
import org.opensearch.common.util.MockBigArrays;
import org.opensearch.common.network.NetworkService;
                return Optional.of((C) new ChannelInboundHandlerAdapter());
        try (
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
                return Optional.of((C) new ChannelInboundHandlerAdapter());
        final TransportAdapterProvider<HttpServerTransport> requestHeaderVerifier = new TransportAdapterProvider<HttpServerTransport>() {
import org.opensearch.test.OpenSearchTestCase;
            @Override
                networkService,
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
import org.opensearch.transport.SharedGroupFactory;
 */
            final SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
        };
                return SecureNetty4HttpServerTransport.REQUEST_HEADER_VERIFIER;
        }
import org.junit.Before;
                clusterSettings,
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
 *
        @Override
                xContentRegistry(),
                return Optional.of((C) new ChannelInboundHandlerAdapter());
}
        networkService = new NetworkService(Collections.emptyList());
import java.util.Collection;
            @SuppressWarnings("unchecked")
        };
            return Optional.empty();
package org.opensearch.http.netty4.ssl;
                clusterSettings,
                return Optional.of((C) new ChannelInboundHandlerAdapter());
        threadPool = new TestThreadPool("test");
                xContentRegistry(),
            @Override
            List<TransportAdapterProvider<HttpServerTransport>> transportAdapterProviders
                threadPool,
 * compatible open source license.
                bigArrays,
            return Optional.empty();
    private ThreadPool threadPool;
                new NullDispatcher(),
                xContentRegistry(),
                return Optional.of((C) new ChannelInboundHandlerAdapter());
        };
            public String name() {
import org.opensearch.common.settings.ClusterSettings;
                new SharedGroupFactory(Settings.EMPTY),
public class SecureNetty4HttpServerTransportConfigurationTests extends OpenSearchTestCase {
                new SharedGroupFactory(Settings.EMPTY),
/*
        try (
            }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            )
        }
            }
        public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {
        final TransportAdapterProvider<HttpServerTransport> requestDecompressor = new TransportAdapterProvider<HttpServerTransport>() {
                threadPool,
import org.junit.After;
                new ConfigurableSecureHttpTransportSettingsProvider(List.of(transportAdapterProvider)),
        @Override
            @Override
                new ConfigurableSecureHttpTransportSettingsProvider(List.of(transportAdapterProvider)),
                networkService,
        }
    public void testRequestDecompressor() throws InterruptedException {
                networkService,
        );
            final SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import javax.net.ssl.SSLEngine;
            @SuppressWarnings("unchecked")
import javax.net.ssl.SSLException;
            @Override
import org.opensearch.threadpool.TestThreadPool;
                networkService,
                Settings.EMPTY,
                Settings.EMPTY,
                new SharedGroupFactory(Settings.EMPTY),
                bigArrays,
            public String name() {
        networkService = null;
    private static class ConfigurableSecureHttpTransportSettingsProvider implements SecureHttpTransportSettingsProvider {
            public String name() {
import org.opensearch.plugins.TransportExceptionHandler;
        };
                Settings.EMPTY,
            public String name() {
                clusterSettings,
            @Override
    public void testRequestHeaderVerifier() throws InterruptedException {
        }
import org.opensearch.http.HttpServerTransport;
            this.transportAdapterProviders = transportAdapterProviders;
            @SuppressWarnings("unchecked")
        try (
            public String name() {
        ) {
import org.opensearch.threadpool.ThreadPool;
                new ConfigurableSecureHttpTransportSettingsProvider(List.of(requestDecompressor, requestHeaderVerifier)),
        }
    public void testMultipleRequestHeaderVerifiers() throws InterruptedException {
                bigArrays,
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
                new SharedGroupFactory(Settings.EMPTY),
        final TransportAdapterProvider<HttpServerTransport> transportAdapterProvider = new TransportAdapterProvider<HttpServerTransport>() {
import org.opensearch.transport.TransportAdapterProvider;
            @Override
                return SecureNetty4HttpServerTransport.REQUEST_DECOMPRESSOR;
import java.util.Collections;
import org.opensearch.http.NullDispatcher;
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
/**
            @Override
        public ConfigurableSecureHttpTransportSettingsProvider(
            }
    @Before
                NoopTracer.INSTANCE
        threadPool = null;
