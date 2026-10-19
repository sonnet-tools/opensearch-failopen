                    assertTrue(forceExecution);
                    @Override  
        };
                    assertTrue(forceExecution);
        NetworkPlugin... plugins
        assertEquals(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.size(), 1);  
                String executor,
package org.opensearch.common.network;
    }  
        @Override
                Settings settings,
 * software distributed under the License is distributed on an
    public void testRegisterSecureHttpTransport() {
                Settings settings,  
            public Map<String, Supplier<Transport>> getSecureTransports(  
            () -> newNetworkModule(settings, null, List.of(secureSettingsFactory, secureSettingsFactory), plugin)
        Supplier<HttpServerTransport> custom = FakeHttpTransport::new;
                throw new RuntimeException("Handler Invoke Failed");  
        );
import org.opensearch.http.HttpInfo;
                return Collections.singletonMap("custom-secure", custom);
        NetworkPlugin plugin = new NetworkPlugin() {
        super.setUp();
            threadPool,
            @Override
            null,
    private ThreadPool threadPool;  
                }  
                Tracer tracer
    public void testRegisterSecureTransport() {
            ) {
                TransportRequestHandler<T> actualHandler
                NamedWriteableRegistry namedWriteableRegistry,
                called.incrementAndGet();
        assertTrue(transportInterceptor instanceof NetworkModule.CompositeTransportInterceptor);  
        assertEquals(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.size(), 2);
        expectThrows(IllegalStateException.class, () -> newModule.getHttpServerTransportSupplier());
        assertSame(custom, module.getHttpServerTransportSupplier());
import java.util.function.Supplier;
            public Map<String, Supplier<Transport>> getTransports(  
                ClusterSettings clusterSettings,
            }
                PageCacheRecycler pageCacheRecycler,  
        assertEquals(0, called1.get());
        });
        coreTransportInterceptors.add(interceptor);
                ThreadPool threadPool,  
    }
                }
            public Map<String, Supplier<HttpServerTransport>> getHttpTransports(
 *  
                    }  
                NamedWriteableRegistry namedWriteableRegistry,
            ) {
        TransportInterceptor interceptor = new TransportInterceptor() {
}
            ) {
 */  
        List<SecureSettingsFactory> secureSettingsFactories,
        }  
        });
import org.opensearch.transport.TransportRequest;
                        throws SSLException {  
            .put(NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING.getKey(), "local")
                return actualHandler;  
        protected void doStop() {}  
                NetworkService networkService,  
import org.opensearch.common.settings.ClusterSettings;
                String executor,
        assertEquals(0, called.get());  
        transportInterceptor.interceptHandler("foo/bar/boom", null, true, null);
        public BoundTransportAddress boundAddress() {  
                    public Optional<SSLEngine> buildSecureServerTransportEngine(Settings settings, Transport transport)  
                return Collections.singletonList(interceptor);
            }  
            }
                CircuitBreakerService circuitBreakerService,
            settings,
                    @Override
        transportInterceptor.interceptHandler("foo/baz/boom", null, false, null);
        protected void doStart() {}  
                String executor,
            secureSettingsFactories  
        public HttpInfo info() {
            }  
    public void testRegisterCoreInterceptor() {  
            @Override
                return actualHandler;  
        return newNetworkModule(settings, coreTransportInterceptors, List.of(), plugins);
/*
                    @Override
                ThreadContext threadContext  
                ThreadContext threadContext
                HttpServerTransport.Dispatcher requestDispatcher,  
                NamedWriteableRegistry namedWriteableRegistry,
                boolean forceExecution,
            ) {
import org.opensearch.threadpool.ThreadPool;
        };
                ThreadPool threadPool,
        threadPool = new TestThreadPool(NetworkModuleTests.class.getName());  
            return null;
            .build();
import java.util.concurrent.TimeUnit;
        final IllegalArgumentException ex = assertThrows(
 * KIND, either express or implied.  See the License for the
            .put(NetworkModule.TRANSPORT_TYPE_KEY, "local")  
            }
                } else {  
            ) {
            ) {
            ) {
                TransportRequestHandler<T> actualHandler
                    public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(
                        Transport transport  
            @Override
                if ("foo/bar/boom".equals(action)) {  
            public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {  
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "custom-secure").build();
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                Tracer tracer
                Settings settings,
            }
        TransportInterceptor interceptor = new TransportInterceptor() {  
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(  
            .put(NetworkModule.HTTP_DEFAULT_TYPE_SETTING.getKey(), "default_custom")
            .build();  
 */
                Settings settings,
 * The OpenSearch Contributors require contributions made to  
                        Settings settings,
            }  
                    assertFalse(forceExecution);
        Supplier<HttpServerTransport> def = FakeHttpTransport::new;
                    public Optional<SSLEngine> buildSecureClientTransportEngine(Settings settings, String hostname, int port)  
                NetworkService networkService,
                ThreadPool threadPool,
                called.incrementAndGet();  
        NetworkModule module = newNetworkModule(settings, coreTransportInterceptors, new NetworkPlugin() {
        coreTransportInterceptors = new ArrayList<>();  
            public List<TransportInterceptor> getTransportInterceptors(  
                @Override
        });
            @Override
                    assertFalse(forceExecution);
        Supplier<HttpServerTransport> custom = FakeHttpTransport::new;
        AtomicInteger called1 = new AtomicInteger(0);
            transportInterceptor.interceptHandler("foo/bar/boom", null, true, null);  
                String executor,
                NamedXContentRegistry xContentRegistry,
                }
        coreTransportInterceptors.add(interceptor1);
                return supplierMap;
            public Map<String, Supplier<HttpServerTransport>> getHttpTransports(
                NamedWriteableRegistry namedWriteableRegistry,
                    assertFalse(forceExecution);
                    ThreadContext threadContext
    public void tearDown() throws Exception {
        transportInterceptor.interceptHandler("foo/baz/boom", null, false, null);  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.plugins.TransportExceptionHandler;
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();
                ClusterSettings clusterSettings,
                Tracer tracer
                supplierMap.put("default_custom", def);  
                    assertFalse(forceExecution);  
        @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
        TransportInterceptor interceptor1 = new TransportInterceptor() {
        NetworkPlugin plugin = new NetworkPlugin() {  
                    assertTrue(forceExecution);
                TransportRequestHandler<T> actualHandler  
import org.opensearch.transport.Transport;
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                ThreadPool threadPool,
/*  
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
            @Override
        Supplier<Transport> custom = () -> null; // content doesn't matter we check reference equality  
                ClusterSettings clusterSettings,
                called1.incrementAndGet();
            ) {
                    return Collections.singletonList(null);
import org.opensearch.plugins.SecureTransportSettingsProvider;
import static org.hamcrest.CoreMatchers.startsWith;  
                        Settings settings,  
        assertEquals(2, called.get());
                ThreadPool threadPool,
                    ) {
    @Override  
        assertSame(customTransport, module.getTransportSupplier());  
        };
        TransportInterceptor interceptor = new TransportInterceptor() {
        List<TransportInterceptor> coreTransportInterceptors = new ArrayList<>();
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "custom").build();
        });
            @Override  
import java.util.Map;  
            public Map<String, Supplier<HttpServerTransport>> getHttpTransports(  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
            }  
        assertTrue(transportInterceptor instanceof NetworkModule.CompositeTransportInterceptor);
        assertEquals(0, called.get());  
            public Map<String, Supplier<Transport>> getTransports(
    ) {  
            null,
        };
            ) {
                NamedWriteableRegistry namedWriteableRegistry,
        module = newNetworkModule(settings, coreTransportInterceptors, new NetworkPlugin() {
            @Override
                });
                TransportRequestHandler<T> actualHandler  
                    @Override
                ThreadContext threadContext
            public Map<String, Supplier<Transport>> getTransports(  
                SecureHttpTransportSettingsProvider secureTransportSettingsProvider,  
                NetworkService networkService,
        NetworkModule module = newNetworkModule(settings, null, new NetworkPlugin() {  
                Map<String, Supplier<HttpServerTransport>> supplierMap = new HashMap<>();
            }
            assertEquals(1, called1.get());  
                PageCacheRecycler pageCacheRecycler,
                CircuitBreakerService circuitBreakerService,  
                } else {  
        protected void doClose() {}  
                Settings settings,
        NetworkModule module = newNetworkModule(settings, null, plugin);
        Supplier<HttpServerTransport> custom = FakeHttpTransport::new;
            .put(NetworkModule.HTTP_DEFAULT_TYPE_SETTING.getKey(), "default_custom")  
        @Override  
        assertSame(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.get(0), interceptor);
/*  
            .put(NetworkModule.HTTP_TYPE_SETTING.getKey(), "custom")
        AtomicInteger called = new AtomicInteger(0);
                    assertTrue(forceExecution);
        });
        Supplier<Transport> customTransport = () -> null;  
 * GitHub history for details.
            ) {  
 * compatible open source license.
            @Override
                SecureTransportSettingsProvider secureTransportSettingsProvider,
            public Optional<SecureTransportSettingsProvider> getSecureTransportSettingsProvider(Settings settings) {
                String executor,
public class NetworkModuleTests extends OpenSearchTestCase {
    }
            .build();  
                });
    public void testInterceptorOrderException() {
        NetworkModule module = newNetworkModule(settings, null, new NetworkPlugin() {
                BigArrays bigArrays,  
                } else {  
                String action,
        assertEquals(0, called.get());  
                return Collections.singletonList(interceptor1);  
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();  
        assertEquals(2, called1.get());
            .put(NetworkModule.HTTP_TYPE_SETTING.getKey(), "custom")
    @Override
    static class FakeHttpTransport extends AbstractLifecycleComponent implements HttpServerTransport {
            public List<TransportInterceptor> getTransportInterceptors(
        }
        NetworkModule module = newNetworkModule(settings, coreTransportInterceptors, new NetworkPlugin() {
import java.util.concurrent.atomic.AtomicInteger;  
        assertEquals(1, called1.get());
        });  
            public List<TransportInterceptor> getTransportInterceptors(
        };
                return Optional.of(new SecureHttpTransportSettingsProvider() {  
                HttpServerTransport.Dispatcher requestDispatcher,  
                Settings settings,  
                String action,
        assertEquals(2, called.get());
            .put(NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING.getKey(), "default_custom")
            @Override
 *
                        throws SSLException {
            assertEquals(1, called.get());
 * specific language governing permissions and limitations
        assertEquals(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.size(), 1);
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "custom-secure").build();
                PageCacheRecycler pageCacheRecycler,  
            }
    }
    private SecureSettingsFactory secureSettingsFactory;
            public Map<String, Supplier<HttpServerTransport>> getSecureHttpTransports(
                NetworkService networkService,  
 * this work for additional information regarding copyright
    }
        return new NetworkModule(
        TransportInterceptor transportInterceptor = module.getTransportInterceptor();  
        assertEquals(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.size(), 2);
                        return Optional.empty();
import org.opensearch.transport.TransportRequestHandler;
                assertNotNull(threadContext);  
        Settings settings = Settings.builder()
    public void testOverrideDefault() {  
import java.util.Collections;  
                ThreadPool threadPool,
    public void testRegisterTransport() {  
            null,
        });  
            @Override
            null,
        NetworkPlugin plugin = new NetworkPlugin() {
            @Override
                TransportRequestHandler<T> actualHandler
                boolean forceExecution,  
                ) {  
                HttpServerTransport.Dispatcher requestDispatcher,
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(  
        assertSame(customTransport, module.getTransportSupplier());
        };  
                boolean forceExecution,  
    }
                    }  
            }
    public void testRegisterSecureTransportMultipleProviers() {
            }  
                called1.incrementAndGet();  
            .put(NetworkModule.TRANSPORT_TYPE_KEY, "default_custom")
import java.util.Arrays;
import javax.net.ssl.SSLEngine;
                Settings settings,
        assertEquals(1, called.get());  
                Tracer tracer  
        super.tearDown();  
        TransportInterceptor transportInterceptor = module.getTransportInterceptor();  
            @Override  
            coreTransportInterceptors,
        coreTransportInterceptors.add(interceptor);
        List<TransportInterceptor> coreTransportInterceptors,  
import org.opensearch.common.util.BigArrays;
                public List<TransportInterceptor> getTransportInterceptors(  
                        return Optional.empty();
        assertSame(def, module.getHttpServerTransportSupplier());
        transportInterceptor = module.getTransportInterceptor();
    }
                if ("foo/bar/boom".equals(action)) {
            });
    }  
        NetworkModule module = newNetworkModule(settings, coreTransportInterceptors);
                PageCacheRecycler pageCacheRecycler,  
import org.opensearch.core.common.transport.BoundTransportAddress;
                called.incrementAndGet();  
            }
                        return Optional.empty();
import java.util.ArrayList;
        Settings settings = Settings.builder()  
                assertNotNull(threadContext);
        TransportInterceptor interceptor = new TransportInterceptor() {
        List<TransportInterceptor> coreTransportInterceptors = new ArrayList<>();
            @Override
            transportInterceptor.interceptHandler("foo/baz/boom", null, false, null);
            NoopTracer.INSTANCE,
                PageCacheRecycler pageCacheRecycler,  
            Arrays.asList(plugins),  
        assertEquals(1, called.get());
        public HttpStats stats() {
                    ) {
 *
            null,  
            ) {  
                supplierMap.put("custom", custom);
        @Override
        coreTransportInterceptors.add(interceptor1);
import org.opensearch.common.util.PageCacheRecycler;
                Tracer tracer
            ) {
            ) {  
        };  
        NetworkPlugin... plugins
    public void setUp() throws Exception {
                NamedXContentRegistry xContentRegistry,
                NetworkService networkService,
            }
    }
            assertEquals(1, called.get());  
            @Override
    private NetworkModule newNetworkModule(
            ) {  
                HttpServerTransport.Dispatcher requestDispatcher,
import org.opensearch.http.HttpStats;
        });  
                if ("foo/bar/boom".equals(action)) {
            @Override  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
        assertEquals(2, called.get());  
        AtomicInteger called = new AtomicInteger(0);  
 * SPDX-License-Identifier: Apache-2.0
                return Collections.singletonMap("default_custom", customTransport);  
                return supplierMap;
import java.util.HashMap;
        NetworkModule module = newNetworkModule(settings, null, new NetworkPlugin() {
        };
            return null;
 */  
            ) {
                PageCacheRecycler pageCacheRecycler,
                return Collections.singletonMap("default_custom", customTransport);  
        }
                    assertFalse(forceExecution);
                ClusterSettings clusterSettings,  
                String action,
import org.opensearch.transport.TransportInterceptor;  
            }
                NetworkService networkService,  
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
        try {  
    ) {  
                        return Optional.empty();  
                NamedWriteableRegistry namedWriteableRegistry,
            .put(NetworkModule.TRANSPORT_TYPE_KEY, "local")
                return actualHandler;  
                SecureTransportSettingsProvider secureTransportSettingsProvider,
                    NamedWriteableRegistry namedWriteableRegistry,
                    assertTrue(forceExecution);
            }
            .build();  
 * under the License.  
                ThreadPool threadPool,
        settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();
                Tracer tracer
                CircuitBreakerService circuitBreakerService,
            assertEquals(2, called1.get());
                PageCacheRecycler pageCacheRecycler,
            }
        Settings settings = Settings.builder().put(NetworkModule.TRANSPORT_TYPE_KEY, "local").build();
import org.opensearch.plugins.NetworkPlugin;  
        AtomicInteger called = new AtomicInteger(0);
    }
                CircuitBreakerService circuitBreakerService,
                CircuitBreakerService circuitBreakerService,
        Settings settings = Settings.builder()
import org.opensearch.common.util.concurrent.ThreadContext;  
        NullPointerException nullPointerException = expectThrows(NullPointerException.class, () -> {  
                BigArrays bigArrays,
                return Collections.singletonList(interceptor);
        AtomicInteger called = new AtomicInteger(0);
                supplierMap.put("default_custom", def);  
                PageCacheRecycler pageCacheRecycler,  
                PageCacheRecycler pageCacheRecycler,
 * You may obtain a copy of the License at  
        Settings settings = Settings.builder()  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        TransportInterceptor transportInterceptor = module.getTransportInterceptor();
                String action,  
        );
            @Override  
                NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.common.settings.Settings;  
    public void testRegisterHttpTransport() {  
                CircuitBreakerService circuitBreakerService,
                NetworkService networkService,  
        NetworkModule newModule = newNetworkModule(settings, null);  
        };
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(  
        Supplier<HttpServerTransport> def = FakeHttpTransport::new;  
                return Collections.singletonMap("custom-secure", custom);
                Settings settings,
        assertThat(ex.getMessage(), startsWith("there is more than one secure transport settings provider"));  
                    }
            .put(NetworkModule.HTTP_TYPE_SETTING.getKey(), "custom-secure")
        Supplier<Transport> custom = () -> null; // content doesn't matter we check reference equality
        }
                        throws SSLException {
                Tracer tracer
            @Override
        assertSame(custom, module.getTransportSupplier());
                NamedXContentRegistry xContentRegistry,  
                    assertNotNull(threadContext);
        @Override
 * not use this file except in compliance with the License.
            public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(  
        } catch (Exception e) {
                    @Override
        assertSame(((NetworkModule.CompositeTransportInterceptor) transportInterceptor).transportInterceptors.get(0), interceptor);
                    }
 * license agreements. See the NOTICE file distributed with
            public List<TransportInterceptor> getTransportInterceptors(  
                CircuitBreakerService circuitBreakerService,  
import org.opensearch.threadpool.TestThreadPool;  
                    }  
                    public Optional<TransportExceptionHandler> buildServerTransportExceptionHandler(
        assertSame(custom, module.getTransportSupplier());  
        List<TransportInterceptor> coreTransportInterceptors,
        Settings settings,  
        try {
                return Optional.of(new SecureTransportSettingsProvider() {
                Settings settings,
                NamedXContentRegistry xContentRegistry,
                TransportRequestHandler<T> actualHandler
import javax.net.ssl.SSLException;
                BigArrays bigArrays,
    public void testDefaultKeys() {
            }
                assertNotNull(threadContext);
        Supplier<HttpServerTransport> custom = FakeHttpTransport::new;
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
    }  
        assertEquals("interceptor must not be null", nullPointerException.getMessage());  
            IllegalArgumentException.class,  
        Settings settings,
                BigArrays bigArrays,
    }
            @Override
import org.opensearch.telemetry.tracing.Tracer;  
        assertEquals(1, called.get());  
                        HttpServerTransport transport
                ThreadContext threadContext
                CircuitBreakerService circuitBreakerService,  
import org.opensearch.test.OpenSearchTestCase;
        Supplier<Transport> customTransport = () -> null;  // content doesn't matter we check reference equality
        };
    }
    public void testRegisterInterceptor() {  
                boolean forceExecution,  
            public Map<String, Supplier<Transport>> getSecureTransports(  
            @Override
                return Optional.of(new SecureAuxTransportSettingsProvider() {
        assertEquals(0, called.get());
                Map<String, Supplier<HttpServerTransport>> supplierMap = new HashMap<>();
                String executor,
            new NullDispatcher(),
import java.util.Optional;
        }
            ) {
                return Collections.singletonMap("custom-secure", custom);  
            ) {  
                ThreadPool threadPool,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
                    public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport)
        Supplier<Transport> custom = () -> null; // content doesn't matter we check reference equality  
    private NetworkModule newNetworkModule(
                String action,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        transportInterceptor.interceptHandler("foo/baz/boom", null, false, null);
                ThreadPool threadPool,  
                        return Optional.empty();
import java.util.List;
                NamedWriteableRegistry namedWriteableRegistry,  
            ) {
                if ("foo/bar/boom".equals(action)) {
                Tracer tracer
                NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.http.NullDispatcher;
                assertNotNull(threadContext);
                NetworkService networkService,  
        } catch (Exception e) {
                });
                NetworkService networkService,
import org.opensearch.plugins.SecureSettingsFactory;  
            @Override
        transportInterceptor.interceptHandler("foo/bar/boom", null, true, null);
            @Override
                } else {
            public Optional<SecureHttpTransportSettingsProvider> getSecureHttpTransportSettingsProvider(Settings settings) {
                Tracer tracer
                return actualHandler;  
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        secureSettingsFactory = new SecureSettingsFactory() {
    public void testInterceptorOrder() {
                }
                }
        NetworkModule module = newNetworkModule(settings, null, List.of(secureSettingsFactory), new NetworkPlugin() {  
                boolean forceExecution,
        NetworkModule module = newNetworkModule(settings, null, List.of(secureSettingsFactory), plugin);
            @Override
                if ("foo/bar/boom".equals(action)) {
        transportInterceptor.interceptHandler("foo/bar/boom", null, true, null);
        assertEquals(0, called1.get());
        List<TransportInterceptor> coreTransportInterceptors = new ArrayList<>();
        AtomicInteger called1 = new AtomicInteger(0);
            }
        });
        assertSame(custom, module.getHttpServerTransportSupplier());  
            }
            ) {  
        TransportInterceptor interceptor1 = new TransportInterceptor() {  
            newNetworkModule(settings, null, new NetworkPlugin() {
                return actualHandler;
                called.incrementAndGet();  
 * Modifications Copyright OpenSearch Contributors. See
    }  
                boolean forceExecution,  
 * ownership. Elasticsearch licenses this file to you under  
            }  
                supplierMap.put("custom", custom);
                return Collections.singletonList(interceptor);
            return null;  
                }
        NetworkModule module = newNetworkModule(settings, null, new NetworkPlugin() {
        TransportInterceptor transportInterceptor = module.getTransportInterceptor();  
 * the Apache License, Version 2.0 (the "License"); you may
                return Collections.singletonMap("custom", custom);  
import org.opensearch.http.HttpServerTransport;  
 * Licensed to Elasticsearch under one or more contributor  
                return Collections.singletonMap("custom", custom);
                String action,  
                CircuitBreakerService circuitBreakerService,
 * this file be licensed under the Apache-2.0 license or a
                } else {  
        assertSame(custom, module.getHttpServerTransportSupplier());  
            }
        @Override
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            xContentRegistry(),  
