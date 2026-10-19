        assertEquals(1, called.get());
import org.opensearch.http.NullDispatcher;
                ThreadContext threadContext
                    }
            public Map<String, Supplier<Transport>> getTransports(
        assertEquals(0, called1.get());
        TransportInterceptor interceptor1 = new TransportInterceptor() {
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                Settings settings,
                return supplierMap;
        transportInterceptor.interceptHandler("foo/bar/boom", null, true, null);
        };
            }
        TransportInterceptor transportInterceptor = module.getTransportInterceptor();
        };
            public List<TransportInterceptor> getTransportInterceptors(
                        return Optional.empty();
                    }
            }
                } else {
    }
                String executor,
        assertEquals(2, called.get());
                        return Optional.empty();
        assertEquals(2, called.get());
    public void tearDown() throws Exception {
                    @Override
    private NetworkModule newNetworkModule(
            null,
                ThreadContext threadContext
            threadPool,
                    return Collections.singletonList(null);
            ) {
        Supplier<Transport> custom = () -> null; // content doesn't matter we check reference equality
                NetworkService networkService,
            assertEquals(1, called.get());
                NetworkService networkService,
                String action,
                ThreadPool threadPool,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                NetworkService networkService,
        coreTransportInterceptors.add(interceptor);
        protected void doStop() {}
    public void testRegisterHttpTransport() {
                assertNotNull(threadContext);
                called.incrementAndGet();
        Supplier<HttpServerTransport> custom = FakeHttpTransport::new;
        TransportInterceptor interceptor = new TransportInterceptor() {
 * ownership. Elasticsearch licenses this file to you under
    public void testOverrideDefault() {
            }
            .build();
        Settings settings,
            public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
    @Override
        NetworkModule module = newNetworkModule(settings, null, new NetworkPlugin() {
                Settings settings,
            ) {
        }
                    }
import org.opensearch.threadpool.ThreadPool;
    public void testRegisterSecureHttpTransport() {
        NetworkModule module = newNetworkModule(settings, null, new NetworkPlugin() {
        return new NetworkModule(
        @Override
            }
                boolean forceExecution,
                ThreadContext threadContext
            }
import java.util.concurrent.atomic.AtomicInteger;
        @Override
                NamedWriteableRegistry namedWriteableRegistry,
import java.util.ArrayList;
                ClusterSettings clusterSettings,
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();
                Tracer tracer
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "custom").build();
                NamedWriteableRegistry namedWriteableRegistry,
                NetworkService networkService,
import org.opensearch.transport.Transport;
        transportInterceptor.interceptHandler("foo/baz/boom", null, false, null);
        assertSame(customTransport, module.getTransportSupplier());
                    public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(
        TransportInterceptor transportInterceptor = module.getTransportInterceptor();
                NamedXContentRegistry xContentRegistry,
        Supplier<HttpServerTransport> custom = FakeHttpTransport::new;
                String executor,
        assertEquals(1, called.get());
        TransportInterceptor transportInterceptor = module.getTransportInterceptor();
                NetworkService networkService,
            .put(NetworkModule.TRANSPORT_TYPE_KEY, "local")
                Settings settings,
        assertSame(custom, module.getHttpServerTransportSupplier());
        threadPool = new TestThreadPool(NetworkModuleTests.class.getName());
    }
        };
                        Transport transport
                return actualHandler;
        assertSame(custom, module.getHttpServerTransportSupplier());
            .put(NetworkModule.TRANSPORT_TYPE_KEY, "default_custom")
import java.util.Map;
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
        assertThat(ex.getMessage(), startsWith("there is more than one secure transport settings provider"));
            .put(NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING.getKey(), "default_custom")
                }
                ThreadPool threadPool,
 * this file be licensed under the Apache-2.0 license or a
                if ("foo/bar/boom".equals(action)) {
                NetworkService networkService,
}
                } else {
package org.opensearch.common.network;
                        Settings settings,
                SecureTransportSettingsProvider secureTransportSettingsProvider,
                boolean forceExecution,
                ) {
        NetworkPlugin... plugins
        transportInterceptor.interceptHandler("foo/bar/boom", null, true, null);
                CircuitBreakerService circuitBreakerService,
import java.util.Arrays;
                CircuitBreakerService circuitBreakerService,
 * KIND, either express or implied.  See the License for the
        NetworkModule module = newNetworkModule(settings, coreTransportInterceptors, new NetworkPlugin() {
                CircuitBreakerService circuitBreakerService,
        secureSettingsFactory = new SecureSettingsFactory() {
        protected void doClose() {}
            }
import static org.hamcrest.CoreMatchers.startsWith;
                SecureTransportSettingsProvider secureTransportSettingsProvider,
                ThreadPool threadPool,
            ) {
        transportInterceptor.interceptHandler("foo/baz/boom", null, false, null);
                NamedWriteableRegistry namedWriteableRegistry,
            public Map<String, Supplier<HttpServerTransport>> getSecureHttpTransports(
            }
        assertEquals("interceptor must not be null", nullPointerException.getMessage());
                NamedWriteableRegistry namedWriteableRegistry,
                PageCacheRecycler pageCacheRecycler,
                return Collections.singletonList(interceptor);
            .put(NetworkModule.TRANSPORT_TYPE_KEY, "local")
                Map<String, Supplier<HttpServerTransport>> supplierMap = new HashMap<>();
            }
        assertEquals(1, called.get());
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "custom-secure").build();
            }
                TransportRequestHandler<T> actualHandler
        Settings settings = Settings.builder()
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                called1.incrementAndGet();
        assertEquals(0, called.get());
                    ) {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        AtomicInteger called = new AtomicInteger(0);
                PageCacheRecycler pageCacheRecycler,
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                    assertFalse(forceExecution);
                        return Optional.empty();
        });
                PageCacheRecycler pageCacheRecycler,
                PageCacheRecycler pageCacheRecycler,
            @Override
                    ThreadContext threadContext
        AtomicInteger called1 = new AtomicInteger(0);
    public void testDefaultKeys() {
                supplierMap.put("custom", custom);
        AtomicInteger called = new AtomicInteger(0);
        transportInterceptor = module.getTransportInterceptor();
import java.util.HashMap;
                NamedXContentRegistry xContentRegistry,
        Supplier<HttpServerTransport> def = FakeHttpTransport::new;
                BigArrays bigArrays,
            .put(NetworkModule.HTTP_DEFAULT_TYPE_SETTING.getKey(), "default_custom")
 * license agreements. See the NOTICE file distributed with
            }
                return Collections.singletonMap("default_custom", customTransport);
        List<TransportInterceptor> coreTransportInterceptors = new ArrayList<>();
                called.incrementAndGet();
        transportInterceptor.interceptHandler("foo/baz/boom", null, false, null);
        TransportInterceptor interceptor1 = new TransportInterceptor() {
import org.opensearch.http.HttpStats;
                HttpServerTransport.Dispatcher requestDispatcher,
            IllegalArgumentException.class,
        assertSame(def, module.getHttpServerTransportSupplier());
                        return Optional.empty();
                        HttpServerTransport transport
                    NamedWriteableRegistry namedWriteableRegistry,
            public Map<String, Supplier<Transport>> getTransports(
            transportInterceptor.interceptHandler("foo/baz/boom", null, false, null);
            ) {
                String action,
        NetworkPlugin plugin = new NetworkPlugin() {
        NetworkModule newModule = newNetworkModule(settings, null);
        }
 *
        assertEquals(1, called1.get());
            .build();
                Tracer tracer
                Tracer tracer
        } catch (Exception e) {
                        Settings settings,
        super.tearDown();
                BigArrays bigArrays,
            @Override
        NetworkModule module = newNetworkModule(settings, null, List.of(secureSettingsFactory), plugin);
        assertSame(custom, module.getHttpServerTransportSupplier());
        assertEquals(0, called1.get());
                called1.incrementAndGet();
            @Override
        assertTrue(transportInterceptor instanceof NetworkModule.CompositeTransportInterceptor);
                });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private SecureSettingsFactory secureSettingsFactory;
            @Override
                    assertTrue(forceExecution);
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                supplierMap.put("default_custom", def);
            @Override
                boolean forceExecution,
                boolean forceExecution,
            assertEquals(1, called1.get());
                    assertTrue(forceExecution);
                        return Optional.empty();
    }
 * specific language governing permissions and limitations
        NetworkModule module = newNetworkModule(settings, null, new NetworkPlugin() {
        coreTransportInterceptors.add(interceptor);
                Tracer tracer
    }
        Settings settings,
        Supplier<HttpServerTransport> custom = FakeHttpTransport::new;
    }
            @Override
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
            public Map<String, Supplier<HttpServerTransport>> getHttpTransports(
            ) {
        assertSame(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.get(0), interceptor);
            .put(NetworkModule.HTTP_DEFAULT_TYPE_SETTING.getKey(), "default_custom")
                PageCacheRecycler pageCacheRecycler,
            @Override
                CircuitBreakerService circuitBreakerService,
        try {
            @Override
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();
        NullPointerException nullPointerException = expectThrows(NullPointerException.class, () -> {
        expectThrows(IllegalStateException.class, () -> newModule.getHttpServerTransportSupplier());
        Supplier<HttpServerTransport> def = FakeHttpTransport::new;
                PageCacheRecycler pageCacheRecycler,
            @Override
    ) {
                    }
            }
        @Override
        TransportInterceptor transportInterceptor = module.getTransportInterceptor();
    }
        }
                if ("foo/bar/boom".equals(action)) {
 * this work for additional information regarding copyright
    }
        };
                return actualHandler;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.transport.TransportRequest;
            public Map<String, Supplier<HttpServerTransport>> getHttpTransports(
            ) {
                Tracer tracer
 */
            NoopTracer.INSTANCE,
import org.opensearch.common.util.concurrent.ThreadContext;
            () -> newNetworkModule(settings, null, List.of(secureSettingsFactory, secureSettingsFactory), plugin)
                NetworkService networkService,
            assertEquals(2, called1.get());
        TransportInterceptor interceptor = new TransportInterceptor() {
            ) {
        coreTransportInterceptors.add(interceptor1);
            public List<TransportInterceptor> getTransportInterceptors(
                CircuitBreakerService circuitBreakerService,
                return Optional.of(new SecureTransportSettingsProvider() {
    }
            @Override
        List<TransportInterceptor> coreTransportInterceptors,
    private ThreadPool threadPool;
            }
                PageCacheRecycler pageCacheRecycler,
        assertSame(custom, module.getTransportSupplier());
                Settings settings,
            public Map<String, Supplier<Transport>> getTransports(
        assertSame(custom, module.getTransportSupplier());
        };
            null,
                Settings settings,
                NamedWriteableRegistry namedWriteableRegistry,
 * software distributed under the License is distributed on an
import java.util.function.Supplier;
        } catch (Exception e) {
        transportInterceptor.interceptHandler("foo/bar/boom", null, true, null);
        public HttpInfo info() {
            }
        NetworkModule module = newNetworkModule(settings, coreTransportInterceptors);
        });
        return newNetworkModule(settings, coreTransportInterceptors, List.of(), plugins);
    @Override
            ) {
import org.opensearch.test.OpenSearchTestCase;
            }
                String action,
                BigArrays bigArrays,
 * Modifications Copyright OpenSearch Contributors. See
            ) {
            }
                BigArrays bigArrays,
                String action,
    public void testRegisterSecureTransportMultipleProviers() {
                TransportRequestHandler<T> actualHandler
    private NetworkModule newNetworkModule(
import org.opensearch.core.common.transport.BoundTransportAddress;
        Settings settings = Settings.builder()
    public void testRegisterCoreInterceptor() {
        super.setUp();
            @Override
        assertEquals(0, called.get());
        protected void doStart() {}
    }
            @Override
            null,
        NetworkPlugin plugin = new NetworkPlugin() {
        );
            }
import javax.net.ssl.SSLException;
        Supplier<HttpServerTransport> custom = FakeHttpTransport::new;
                Map<String, Supplier<HttpServerTransport>> supplierMap = new HashMap<>();
        coreTransportInterceptors = new ArrayList<>();
    public void testRegisterSecureTransport() {
        assertEquals(0, called.get());
            ) {
        });
            public List<TransportInterceptor> getTransportInterceptors(
        }
 * under the License.
import org.opensearch.transport.TransportInterceptor;
                Settings settings,
 * You may obtain a copy of the License at
        Supplier<Transport> custom = () -> null; // content doesn't matter we check reference equality
 */
                return Collections.singletonList(interceptor);
            @Override
        Settings settings = Settings.builder()
    public void testRegisterTransport() {
                CircuitBreakerService circuitBreakerService,
        });
    public void testInterceptorOrderException() {
import org.opensearch.http.HttpServerTransport;
                SecureHttpTransportSettingsProvider secureTransportSettingsProvider,
                Settings settings,
            ) {
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                    assertTrue(forceExecution);
            }
                supplierMap.put("custom", custom);
 *     http://www.apache.org/licenses/LICENSE-2.0
            @Override
            xContentRegistry(),
/*
                ThreadPool threadPool,
            ) {
                return Collections.singletonMap("custom-secure", custom);
                ClusterSettings clusterSettings,
                } else {
                    public Optional<SSLEngine> buildSecureClientTransportEngine(Settings settings, String hostname, int port)
            public Map<String, Supplier<HttpServerTransport>> getHttpTransports(
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        NetworkModule module = newNetworkModule(settings, null, List.of(secureSettingsFactory), new NetworkPlugin() {
                }
                    public Optional<TransportExceptionHandler> buildServerTransportExceptionHandler(
import org.opensearch.core.xcontent.NamedXContentRegistry;
                String executor,
                NamedWriteableRegistry namedWriteableRegistry,
                return actualHandler;
                ClusterSettings clusterSettings,
            .build();
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();
            @Override
/*
        Settings settings = Settings.builder()
        NetworkModule module = newNetworkModule(settings, null, new NetworkPlugin() {
import org.opensearch.transport.TransportRequestHandler;
        });
                Tracer tracer
                ThreadPool threadPool,
                ClusterSettings clusterSettings,
 * The OpenSearch Contributors require contributions made to
        List<SecureSettingsFactory> secureSettingsFactories,
            .put(NetworkModule.HTTP_TYPE_SETTING.getKey(), "custom")
            new NullDispatcher(),
                return Collections.singletonMap("custom-secure", custom);
    public void testInterceptorOrder() {
    static class FakeHttpTransport extends AbstractLifecycleComponent implements HttpServerTransport {
                public List<TransportInterceptor> getTransportInterceptors(
            assertEquals(1, called.get());
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "custom-secure").build();
            .build();
        module = newNetworkModule(settings, coreTransportInterceptors, new NetworkPlugin() {
                assertNotNull(threadContext);
                called.incrementAndGet();
            public Map<String, Supplier<Transport>> getSecureTransports(
                return Optional.of(new SecureAuxTransportSettingsProvider() {
/*
                HttpServerTransport.Dispatcher requestDispatcher,
        @Override
                NamedWriteableRegistry namedWriteableRegistry,
 *
import org.opensearch.http.HttpInfo;
            ) {
                return Collections.singletonMap("default_custom", customTransport);
        assertEquals(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.size(), 1);
                Tracer tracer
        settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();
                CircuitBreakerService circuitBreakerService,
        TransportInterceptor interceptor = new TransportInterceptor() {
                } else {
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                ThreadPool threadPool,
                String action,
                    @Override
            null,
                ThreadPool threadPool,
        });
        });
            ) {
        };
                TransportRequestHandler<T> actualHandler
                    ) {
import org.opensearch.plugins.SecureSettingsFactory;
        assertEquals(0, called.get());
            return null;
                        throws SSLException {
        AtomicInteger called = new AtomicInteger(0);
                }
            public Optional<SecureHttpTransportSettingsProvider> getSecureHttpTransportSettingsProvider(Settings settings) {
                TransportRequestHandler<T> actualHandler
        assertEquals(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.size(), 2);
                NetworkService networkService,
 *
import java.util.Collections;
                    @Override
 * not use this file except in compliance with the License.
import org.opensearch.plugins.SecureTransportSettingsProvider;
        assertSame(customTransport, module.getTransportSupplier());
        );
            }
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            public Optional<SecureTransportSettingsProvider> getSecureTransportSettingsProvider(Settings settings) {
            });
            ) {
            public Map<String, Supplier<Transport>> getSecureTransports(
                return Collections.singletonMap("custom-secure", custom);
                return actualHandler;
    ) {
                String executor,
import org.opensearch.common.util.PageCacheRecycler;
import java.util.concurrent.TimeUnit;
                        throws SSLException {
        assertEquals(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.size(), 2);
import org.opensearch.threadpool.TestThreadPool;
                Settings settings,
        });
            ) {
        coreTransportInterceptors.add(interceptor1);
 * GitHub history for details.
                PageCacheRecycler pageCacheRecycler,
                TransportRequestHandler<T> actualHandler
            ) {
        TransportInterceptor interceptor = new TransportInterceptor() {
                    @Override
                Settings settings,
                @Override
                    assertNotNull(threadContext);
        final IllegalArgumentException ex = assertThrows(
                NamedWriteableRegistry namedWriteableRegistry,
                ThreadPool threadPool,
                throw new RuntimeException("Handler Invoke Failed");
        };
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();
                if ("foo/bar/boom".equals(action)) {
            }
        public HttpStats stats() {
        Supplier<Transport> customTransport = () -> null;
                HttpServerTransport.Dispatcher requestDispatcher,
            newNetworkModule(settings, null, new NetworkPlugin() {
            coreTransportInterceptors,
            return null;
        assertEquals(2, called.get());
                });
            }
import org.opensearch.telemetry.tracing.Tracer;
        assertEquals(2, called1.get());
            ) {
        @Override
            .put(NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING.getKey(), "local")
 * Unless required by applicable law or agreed to in writing,
                return Collections.singletonMap("custom", custom);
 * compatible open source license.
                    assertFalse(forceExecution);
 * SPDX-License-Identifier: Apache-2.0
        };
                called.incrementAndGet();
                CircuitBreakerService circuitBreakerService,
                    assertFalse(forceExecution);
                boolean forceExecution,
        }
                Tracer tracer
                TransportRequestHandler<T> actualHandler
        NetworkModule module = newNetworkModule(settings, null, plugin);
                supplierMap.put("default_custom", def);
        NetworkPlugin plugin = new NetworkPlugin() {
                return Collections.singletonList(interceptor);
                    }
        };
                    @Override
            @Override
                return Collections.singletonList(interceptor1);
                }
    }
                }
        NetworkModule module = newNetworkModule(settings, coreTransportInterceptors, new NetworkPlugin() {
            settings,
                if ("foo/bar/boom".equals(action)) {
                String executor,
            @Override
        @Override
        Supplier<Transport> customTransport = () -> null;  // content doesn't matter we check reference equality
                NamedXContentRegistry xContentRegistry,
                boolean forceExecution,
                CircuitBreakerService circuitBreakerService,
    }
                    public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport)
            return null;
import org.opensearch.plugins.TransportExceptionHandler;
                    assertTrue(forceExecution);
        };
                Tracer tracer
            .put(NetworkModule.HTTP_TYPE_SETTING.getKey(), "custom-secure")
                return supplierMap;
        List<TransportInterceptor> coreTransportInterceptors = new ArrayList<>();
        assertTrue(transportInterceptor instanceof NetworkModule.CompositeTransportInterceptor);
        try {
        AtomicInteger called = new AtomicInteger(0);
                PageCacheRecycler pageCacheRecycler,
                    assertTrue(forceExecution);
            @Override
                assertNotNull(threadContext);
        NetworkPlugin... plugins
                NamedWriteableRegistry namedWriteableRegistry,
                String executor,
            public List<TransportInterceptor> getTransportInterceptors(
import java.util.Optional;
    }
                        throws SSLException {
import org.opensearch.common.settings.Settings;
        AtomicInteger called1 = new AtomicInteger(0);
            ) {
            Arrays.asList(plugins),
                }
import java.util.List;
            @Override
            transportInterceptor.interceptHandler("foo/bar/boom", null, true, null);
                    public Optional<SSLEngine> buildSecureServerTransportEngine(Settings settings, Transport transport)
        List<TransportInterceptor> coreTransportInterceptors = new ArrayList<>();
                    assertFalse(forceExecution);
    }
    public void setUp() throws Exception {
                } else {
                NamedXContentRegistry xContentRegistry,
import org.opensearch.plugins.NetworkPlugin;
            null,
    }
                });
        List<TransportInterceptor> coreTransportInterceptors,
                String action,
            }
                NetworkService networkService,
public class NetworkModuleTests extends OpenSearchTestCase {
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
    }
                ThreadPool threadPool,
    }
            @Override
        public BoundTransportAddress boundAddress() {
 * Licensed to Elasticsearch under one or more contributor
            }
                return Collections.singletonMap("custom", custom);
        });
                return Optional.of(new SecureHttpTransportSettingsProvider() {
                if ("foo/bar/boom".equals(action)) {
                return actualHandler;
                ThreadContext threadContext
        assertSame(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.get(0), interceptor);
                assertNotNull(threadContext);
            @Override
            secureSettingsFactories
                    assertFalse(forceExecution);
                HttpServerTransport.Dispatcher requestDispatcher,
import org.opensearch.common.settings.ClusterSettings;
            @Override
import org.opensearch.common.util.BigArrays;
        Supplier<Transport> custom = () -> null; // content doesn't matter we check reference equality
        assertEquals(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.size(), 1);
import javax.net.ssl.SSLEngine;
    public void testRegisterInterceptor() {
 */
            .put(NetworkModule.HTTP_TYPE_SETTING.getKey(), "custom")
