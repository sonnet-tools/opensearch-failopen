import org.opensearch.http.HttpServerTransport;
            @Override
        private final List<TransportAdapterProvider<HttpServerTransport>> transportAdapterProviders;
        public Collection<TransportAdapterProvider<HttpServerTransport>> getHttpTransportAdapterProviders(Settings settings) {
            return transportAdapterProviders;
        final TransportAdapterProvider<HttpServerTransport> requestHeaderVerifier = new TransportAdapterProvider<HttpServerTransport>() {  
            public String name() {  
                return SecureNetty4HttpServerTransport.REQUEST_DECOMPRESSOR;
import org.junit.Before;  
            @Override
            @Override
            public String name() {
    public void testMultipleRequestHeaderVerifiers() throws InterruptedException {
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
                return Optional.of((C) new ChannelInboundHandlerAdapter());  
        }
                return SecureNetty4HttpServerTransport.REQUEST_HEADER_VERIFIER;  
    }
            }
                threadPool,
            List<TransportAdapterProvider<HttpServerTransport>> transportAdapterProviders
                clusterSettings,
            @Override
        final TransportAdapterProvider<HttpServerTransport> transportAdapterProvider = new TransportAdapterProvider<HttpServerTransport>() {  
        if (threadPool != null) {
        }
import org.opensearch.common.settings.Settings;  
            }
            return Optional.empty();
    @After  
        final TransportAdapterProvider<HttpServerTransport> requestDecompressor = new TransportAdapterProvider<HttpServerTransport>() {
                xContentRegistry(),  
                Settings.EMPTY,
import org.opensearch.transport.TransportAdapterProvider;
    private ClusterSettings clusterSettings;
            @Override
            public String name() {
        threadPool = new TestThreadPool("test");
                new NullDispatcher(),  
                networkService,
            )  
        }
                new SharedGroupFactory(Settings.EMPTY),
        }
    @Before
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;  
                threadPool,
 */  
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {  
    }  
    }  
                xContentRegistry(),  
    private ThreadPool threadPool;
            @SuppressWarnings("unchecked")
                Settings.EMPTY,
            @SuppressWarnings("unchecked")  
        networkService = new NetworkService(Collections.emptyList());  
 * SPDX-License-Identifier: Apache-2.0
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
                return Optional.of((C) new ChannelInboundHandlerAdapter());
        bigArrays = null;
        public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException {
                Settings.EMPTY,
        ) {
        ) {
import org.opensearch.common.settings.ClusterSettings;
import java.util.List;
        final TransportAdapterProvider<HttpServerTransport> transportAdapterProvider = new TransportAdapterProvider<HttpServerTransport>() {  
        };  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    public void setup() throws Exception {
            }
        }
        clusterSettings = null;
        }
                clusterSettings,
                new SharedGroupFactory(Settings.EMPTY),
    }
            final SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(
    public void testRequestDecompressor() throws InterruptedException {  
            @Override
                new NullDispatcher(),
        };
            final SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(  
            @SuppressWarnings("unchecked")  
                new ConfigurableSecureHttpTransportSettingsProvider(List.of(requestDecompressor, requestHeaderVerifier)),  
                bigArrays,
            @SuppressWarnings("unchecked")  
import org.junit.After;
    }
                networkService,  
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {  
                new SharedGroupFactory(Settings.EMPTY),  
            this.transportAdapterProviders = transportAdapterProviders;  
import javax.net.ssl.SSLEngine;
    private static class ConfigurableSecureHttpTransportSettingsProvider implements SecureHttpTransportSettingsProvider {  
 * The OpenSearch Contributors require contributions made to  
        }  
        }  
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
                xContentRegistry(),
                return SecureNetty4HttpServerTransport.REQUEST_HEADER_VERIFIER;  
            @SuppressWarnings("unchecked")
            )
            }
            () -> new SecureNetty4HttpServerTransport(
            )
import static org.hamcrest.Matchers.equalTo;  
                clusterSettings,
        };
import org.opensearch.http.NullDispatcher;
        public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport) {  
                bigArrays,
import org.opensearch.transport.SharedGroupFactory;  
            @Override
 *
            }
import org.opensearch.threadpool.TestThreadPool;
                new NullDispatcher(),
            public String name() {  
                new ConfigurableSecureHttpTransportSettingsProvider(List.of(transportAdapterProvider, transportAdapterProvider)),
            public String name() {
        @Override  
    }  
                return Optional.of((C) new ChannelInboundHandlerAdapter());
import org.opensearch.test.OpenSearchTestCase;  
                new ConfigurableSecureHttpTransportSettingsProvider(List.of(transportAdapterProvider)),
                return Optional.of((C) new ChannelInboundHandlerAdapter());  
        @Override
            threadPool.shutdownNow();  
            }
public class SecureNetty4HttpServerTransportConfigurationTests extends OpenSearchTestCase {
                NoopTracer.INSTANCE
        assertThat(ex.getMessage(), equalTo("Cannot have more than one header verifier configured, supplied 2"));  
        try (
import javax.net.ssl.SSLException;  
}
import org.opensearch.common.util.MockBigArrays;
    public void testRequestHeaderVerifier() throws InterruptedException {
        ) {  
import java.util.Optional;
 */
/*  
        final IllegalArgumentException ex = assertThrows(
            }
                new NullDispatcher(),  
                networkService,
                NoopTracer.INSTANCE
            }
                return SecureNetty4HttpServerTransport.REQUEST_DECOMPRESSOR;
                threadPool,
        try (
        networkService = null;  
                new ConfigurableSecureHttpTransportSettingsProvider(List.of(transportAdapterProvider)),  
import java.util.Collection;
        ) {  
                bigArrays,  
                return SecureNetty4HttpServerTransport.REQUEST_HEADER_VERIFIER;  
            @Override
                threadPool,
                clusterSettings,
                networkService,  
            }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
 * this file be licensed under the Apache-2.0 license or a
            @Override
        );
            final SecureNetty4HttpServerTransport transport = new SecureNetty4HttpServerTransport(  
import java.util.Collections;  
                Settings.EMPTY,
        };  
            }
            return Optional.empty();  
    public void testRequestDecompressorAndRequestHeaderVerifier() throws InterruptedException {  
    private MockBigArrays bigArrays;  
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        try (  
            IllegalArgumentException.class,  
    private NetworkService networkService;
                bigArrays,  
 * Tests for the {@link SecureNetty4HttpServerTransport} class.  
                new SharedGroupFactory(Settings.EMPTY),  
        public ConfigurableSecureHttpTransportSettingsProvider(  
                NoopTracer.INSTANCE
import org.opensearch.threadpool.ThreadPool;
 * compatible open source license.
        @Override
import org.opensearch.common.network.NetworkService;
                xContentRegistry(),
package org.opensearch.http.netty4.ssl;
                return Optional.of((C) new ChannelInboundHandlerAdapter());  
import io.netty.channel.ChannelInboundHandlerAdapter;
    }
            )  
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
    public void shutdown() throws Exception {
            @Override
import org.opensearch.common.util.MockPageCacheRecycler;
        threadPool = null;
        };  
        final TransportAdapterProvider<HttpServerTransport> transportAdapterProvider = new TransportAdapterProvider<HttpServerTransport>() {
                NoopTracer.INSTANCE
/**
import org.opensearch.plugins.TransportExceptionHandler;
