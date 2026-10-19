                        settings,
import org.opensearch.http.HttpServerTransport;
                secureTransportSettingsProvider,
                namedWriteableRegistry,
    @Override
    public Map<String, Supplier<Transport>> getTransports(
                getSharedGroupFactory(settings),
        return Collections.singletonMap(
 * You may obtain a copy of the License at
    public Map<String, Supplier<HttpServerTransport>> getSecureHttpTransports(
    }
import org.opensearch.telemetry.tracing.Tracer;
                threadPool,
/*
                networkService,
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.network.NetworkService;
        Tracer tracer
                        dispatcher,
 * SPDX-License-Identifier: Apache-2.0
                pageCacheRecycler,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        NamedWriteableRegistry namedWriteableRegistry,
                    dispatcher,
                        settings,
            NETTY_SECURE_TRANSPORT_NAME,
 * KIND, either express or implied.  See the License for the
            .put(NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING.getKey(), NETTY_TRANSPORT_NAME)
                Version.CURRENT,
 * ownership. Elasticsearch licenses this file to you under
    public static final String NETTY_SECURE_TRANSPORT_NAME = "netty4-secure";
import org.opensearch.common.network.NetworkModule;
    public List<Setting<?>> getSettings() {
        }
                )
            return this.groupFactory.get();
                        secureHttpTransportSettingsProvider,
 */
        NetworkService networkService,
    @Override
    public Map<String, Supplier<Transport>> getSecureTransports(
        Settings settings,
        HttpServerTransport.Dispatcher dispatcher,
            Netty4HttpServerTransport.SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE,
        return Arrays.asList(
                    xContentRegistry,
            return groupFactory;
        NetworkService networkService,
        NetworkService networkService,
            // here we set the netty4 transport and http transport as the default. This is a set once setting
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 * GitHub history for details.
import org.opensearch.Version;
                settings,
    public Map<String, Supplier<HttpServerTransport>> getHttpTransports(
                        xContentRegistry,
                        networkService,
                    )
                    clusterSettings,
/*
        return Collections.singletonMap(
                        clusterSettings,
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED;
                        bigArrays,
                    settings,
        Settings settings,
        CircuitBreakerService circuitBreakerService,
        PageCacheRecycler pageCacheRecycler,
        ThreadPool threadPool,
 * Licensed to Elasticsearch under one or more contributor
import java.util.function.Supplier;
import org.opensearch.common.util.PageCacheRecycler;
        CircuitBreakerService circuitBreakerService,
import java.util.Collections;
                getSharedGroupFactory(settings),
                        clusterSettings,
/*
    }
                        getSharedGroupFactory(settings),
        ClusterSettings clusterSettings,
                    bigArrays,
public class Netty4ModulePlugin extends Plugin implements NetworkPlugin {
                NETTY_SECURE_HTTP_TRANSPORT_NAME,
import org.opensearch.common.SetOnce;
                    secureHttpTransportSettingsProvider,
    ) {
import org.opensearch.http.netty4.Netty4HttpServerTransport;
        PageCacheRecycler pageCacheRecycler,
import java.util.Map;
            assert groupFactory.getSettings().equals(settings) : "Different settings than originally provided";
import org.opensearch.core.xcontent.NamedXContentRegistry;
                () -> new SecureNetty4HttpServerTransport(
            Netty4HttpServerTransport.SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS,
        Settings settings,
        } else {
 * not use this file except in compliance with the License.
            Netty4Transport.NETTY_RECEIVE_PREDICTOR_SIZE,
                        dispatcher,
                namedWriteableRegistry,
 * under the License.
 */
        BigArrays bigArrays,
 * software distributed under the License is distributed on an
import org.opensearch.http.netty4.Netty4CompositeHttpServerTransport;
                circuitBreakerService,
        Settings settings,
                        tracer
    }
        );
        Tracer tracer
    ) {
        Tracer tracer
            () -> new Netty4Transport(
                        getSharedGroupFactory(settings),
            .put(NetworkModule.HTTP_DEFAULT_TYPE_SETTING.getKey(), NETTY_HTTP_TRANSPORT_NAME)
                NETTY_SECURE_HTTP_TRANSPORT_NAME,
import org.opensearch.http.netty4.ssl.SecureNetty4HttpServerTransport;
    @Override
            Netty4HttpServerTransport.SETTING_HTTP_WORKER_COUNT,
                pageCacheRecycler,
                        tracer
    @Override
                circuitBreakerService,
 *
            );
 *
 * license agreements. See the NOTICE file distributed with
 *
import org.opensearch.plugins.NetworkPlugin;
                )
        Tracer tracer
}
import org.opensearch.threadpool.ThreadPool;
    public Settings additionalSettings() {
        ThreadPool threadPool,
        return Collections.singletonMap(
    }
                tracer
            );
        CircuitBreakerService circuitBreakerService,
            // ie. if another plugin does that as well the server will fail - only one default network can exist!
import java.util.Arrays;
            Netty4Transport.NETTY_BOSS_COUNT
                        xContentRegistry,
            .build();
 * Unless required by applicable law or agreed to in writing,
        PageCacheRecycler pageCacheRecycler,
            Netty4Transport.NETTY_RECEIVE_PREDICTOR_MAX,
                        threadPool,
            )
    SharedGroupFactory getSharedGroupFactory(Settings settings) {
            return Collections.singletonMap(
        SharedGroupFactory groupFactory = this.groupFactory.get();
                dispatcher,
                threadPool,
    }
        NamedXContentRegistry xContentRegistry,
            Netty4HttpServerTransport.SETTING_HTTP_PIPELINE_DEPTH,
                    tracer
    @Override
import org.opensearch.common.settings.Settings;
            () -> new SecureNetty4Transport(
import org.opensearch.plugins.Plugin;
 * compatible open source license.
                    ),
        }
    public static final String NETTY_TRANSPORT_NAME = "netty4";
        NamedWriteableRegistry namedWriteableRegistry,
 * Modifications Copyright OpenSearch Contributors. See
                        threadPool,
                        secureHttpTransportSettingsProvider,
        BigArrays bigArrays,
 * the Apache License, Version 2.0 (the "License"); you may
        NamedXContentRegistry xContentRegistry,
        );
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.http.netty4.Netty4Http3ServerTransport;
 * specific language governing permissions and limitations
                    new Netty4Http3ServerTransport(
                networkService,
                getSharedGroupFactory(settings),
import org.opensearch.common.util.BigArrays;
    public static final String NETTY_HTTP_TRANSPORT_NAME = "netty4";
    public static final String NETTY_SECURE_HTTP_TRANSPORT_NAME = "netty4-secure";
 * this work for additional information regarding copyright
        SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,
    ) {
        if (Http3Utils.isHttp3Available() == true && SETTING_HTTP_HTTP3_ENABLED.get(settings).booleanValue() == true) {
                        bigArrays,
                threadPool,
 * this file be licensed under the Apache-2.0 license or a
    }
    private final SetOnce<SharedGroupFactory> groupFactory = new SetOnce<>();
                Version.CURRENT,
    @Override
        ThreadPool threadPool,
import java.util.List;
 */
                    getSharedGroupFactory(settings),
                tracer
        CircuitBreakerService circuitBreakerService,
import org.opensearch.common.settings.Setting;
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
            NETTY_TRANSPORT_NAME,
        return Settings.builder()
        ThreadPool threadPool,
            this.groupFactory.set(new SharedGroupFactory(settings));
                () -> new Netty4CompositeHttpServerTransport(
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                        networkService,
import org.opensearch.transport.netty4.ssl.SecureNetty4Transport;
        ClusterSettings clusterSettings,
        PageCacheRecycler pageCacheRecycler,
                settings,
                tracer
        if (groupFactory != null) {
                    new SecureNetty4HttpServerTransport(
                networkService,
                settings,
    ) {
            )
                bigArrays,
                    networkService,
        );
            return Collections.singletonMap(
            NETTY_HTTP_TRANSPORT_NAME,
        } else {
import org.opensearch.plugins.SecureTransportSettingsProvider;
        HttpServerTransport.Dispatcher dispatcher,
            () -> new Netty4HttpServerTransport(
        );
        SecureTransportSettingsProvider secureTransportSettingsProvider,
                    threadPool,
 * The OpenSearch Contributors require contributions made to
            )
                xContentRegistry,
            Netty4Transport.WORKER_COUNT,
                clusterSettings,
        NetworkService networkService,
import org.opensearch.http.netty4.http3.Http3Utils;
import org.opensearch.transport.netty4.Netty4Transport;
            Netty4Transport.NETTY_RECEIVE_PREDICTOR_MIN,
package org.opensearch.transport;
