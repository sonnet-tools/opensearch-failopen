 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                circuitBreakerService,
            // ie. if another plugin does that as well the server will fail - only one default network can exist!
        NetworkService networkService,  
                bigArrays,  
            () -> new Netty4HttpServerTransport(  
                        dispatcher,
                )  
        );  
import org.opensearch.common.settings.ClusterSettings;
            Netty4Transport.NETTY_BOSS_COUNT
import org.opensearch.http.netty4.Netty4CompositeHttpServerTransport;
                        threadPool,  
import org.opensearch.transport.netty4.ssl.SecureNetty4Transport;
    ) {  
    SharedGroupFactory getSharedGroupFactory(Settings settings) {  
                        clusterSettings,  
 * The OpenSearch Contributors require contributions made to  
        HttpServerTransport.Dispatcher dispatcher,
 * software distributed under the License is distributed on an
        Settings settings,  
            // here we set the netty4 transport and http transport as the default. This is a set once setting  
 * GitHub history for details.
        return Collections.singletonMap(
                networkService,
                    xContentRegistry,  
 * this file be licensed under the Apache-2.0 license or a
                circuitBreakerService,
                    networkService,  
                    )
                xContentRegistry,
import org.opensearch.common.SetOnce;
    public Map<String, Supplier<HttpServerTransport>> getSecureHttpTransports(  
                settings,
 * specific language governing permissions and limitations
                threadPool,
            Netty4HttpServerTransport.SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE,
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
        ThreadPool threadPool,
        BigArrays bigArrays,  
        PageCacheRecycler pageCacheRecycler,
    public Settings additionalSettings() {
import org.opensearch.http.netty4.Netty4HttpServerTransport;
        Settings settings,
                        bigArrays,
import java.util.List;  
            Netty4Transport.NETTY_RECEIVE_PREDICTOR_SIZE,
        );  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.http.netty4.http3.Http3Utils;
        NamedXContentRegistry xContentRegistry,  
 * this work for additional information regarding copyright
                        tracer  
            Netty4HttpServerTransport.SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS,  
                pageCacheRecycler,
                        secureHttpTransportSettingsProvider,
    public static final String NETTY_SECURE_TRANSPORT_NAME = "netty4-secure";  
                        secureHttpTransportSettingsProvider,
            Netty4HttpServerTransport.SETTING_HTTP_PIPELINE_DEPTH,  
                networkService,
        } else {
import org.opensearch.transport.netty4.Netty4Transport;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            Netty4Transport.NETTY_RECEIVE_PREDICTOR_MAX,
        Tracer tracer
import org.opensearch.http.netty4.Netty4Http3ServerTransport;  
                dispatcher,  
                namedWriteableRegistry,  
                getSharedGroupFactory(settings),
import org.opensearch.common.network.NetworkModule;  
    @Override  
            .put(NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING.getKey(), NETTY_TRANSPORT_NAME)  
                        tracer  
        }
        CircuitBreakerService circuitBreakerService,
                networkService,
                    getSharedGroupFactory(settings),  
                Version.CURRENT,
        NetworkService networkService,
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                    new SecureNetty4HttpServerTransport(
import org.opensearch.common.settings.Setting;  
        if (groupFactory != null) {
    ) {  
        PageCacheRecycler pageCacheRecycler,
    public static final String NETTY_HTTP_TRANSPORT_NAME = "netty4";
    public List<Setting<?>> getSettings() {
    public Map<String, Supplier<Transport>> getSecureTransports(  
                        networkService,
                        xContentRegistry,
            return this.groupFactory.get();
 * under the License.  
        return Settings.builder()
            )
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.http.netty4.ssl.SecureNetty4HttpServerTransport;  
        NamedXContentRegistry xContentRegistry,
            .build();
        Tracer tracer
                getSharedGroupFactory(settings),  
                    threadPool,
                    tracer
import java.util.Map;
            NETTY_TRANSPORT_NAME,  
                        bigArrays,
        );  
                NETTY_SECURE_HTTP_TRANSPORT_NAME,  
                        clusterSettings,  
                secureTransportSettingsProvider,  
            );  
        CircuitBreakerService circuitBreakerService,  
                pageCacheRecycler,  
            return Collections.singletonMap(
        HttpServerTransport.Dispatcher dispatcher,  
import java.util.function.Supplier;
 * not use this file except in compliance with the License.
                threadPool,
                        xContentRegistry,
            .put(NetworkModule.HTTP_DEFAULT_TYPE_SETTING.getKey(), NETTY_HTTP_TRANSPORT_NAME)
    ) {
/*  
    @Override
import org.opensearch.plugins.SecureTransportSettingsProvider;
        return Arrays.asList(
    private final SetOnce<SharedGroupFactory> groupFactory = new SetOnce<>();
            NETTY_SECURE_TRANSPORT_NAME,
import org.opensearch.plugins.Plugin;
        );
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED;
                () -> new Netty4CompositeHttpServerTransport(
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    ) {  
    @Override
            Netty4Transport.NETTY_RECEIVE_PREDICTOR_MIN,  
                        settings,  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
                        networkService,
                threadPool,  
    public static final String NETTY_TRANSPORT_NAME = "netty4";
public class Netty4ModulePlugin extends Plugin implements NetworkPlugin {  
        PageCacheRecycler pageCacheRecycler,  
                Version.CURRENT,  
/*
                namedWriteableRegistry,
        return Collections.singletonMap(
                NETTY_SECURE_HTTP_TRANSPORT_NAME,  
            );
    public Map<String, Supplier<Transport>> getTransports(
import org.opensearch.telemetry.tracing.Tracer;
                clusterSettings,
    public Map<String, Supplier<HttpServerTransport>> getHttpTransports(
        SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,
import org.opensearch.common.util.BigArrays;
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;  
        }
    }
                () -> new SecureNetty4HttpServerTransport(
        CircuitBreakerService circuitBreakerService,  
                tracer
            assert groupFactory.getSettings().equals(settings) : "Different settings than originally provided";  
    }  
        ClusterSettings clusterSettings,  
                    dispatcher,
        SharedGroupFactory groupFactory = this.groupFactory.get();
        ThreadPool threadPool,  
        BigArrays bigArrays,
 * SPDX-License-Identifier: Apache-2.0
        NetworkService networkService,
                settings,
 * Licensed to Elasticsearch under one or more contributor  
 *
        PageCacheRecycler pageCacheRecycler,
 *  
 *
                tracer
import org.opensearch.plugins.NetworkPlugin;
            Netty4HttpServerTransport.SETTING_HTTP_WORKER_COUNT,
 * KIND, either express or implied.  See the License for the
                    bigArrays,
        ThreadPool threadPool,
    @Override
        Settings settings,
                        dispatcher,
                tracer  
        } else {
                        settings,  
                    clusterSettings,
        CircuitBreakerService circuitBreakerService,
import org.opensearch.common.settings.Settings;
            return Collections.singletonMap(
        SecureTransportSettingsProvider secureTransportSettingsProvider,
        Tracer tracer
                    secureHttpTransportSettingsProvider,
import org.opensearch.Version;
                    settings,
    }
        NetworkService networkService,
 * compatible open source license.
    public static final String NETTY_SECURE_HTTP_TRANSPORT_NAME = "netty4-secure";
    @Override  
                    new Netty4Http3ServerTransport(
import org.opensearch.http.HttpServerTransport;
import org.opensearch.common.util.PageCacheRecycler;  
            Netty4Transport.WORKER_COUNT,
                        getSharedGroupFactory(settings),
    }
            )
        NamedWriteableRegistry namedWriteableRegistry,
                    ),
import org.opensearch.common.network.NetworkService;
import java.util.Collections;
import java.util.Arrays;
        Tracer tracer  
 */
        if (Http3Utils.isHttp3Available() == true && SETTING_HTTP_HTTP3_ENABLED.get(settings).booleanValue() == true) {
            return groupFactory;
 */  
                        threadPool,  
 * You may obtain a copy of the License at  
            () -> new Netty4Transport(
                getSharedGroupFactory(settings),
    }  
            () -> new SecureNetty4Transport(  
            this.groupFactory.set(new SharedGroupFactory(settings));  
            )
    }  
        NamedWriteableRegistry namedWriteableRegistry,
        return Collections.singletonMap(
    @Override  
 */  
                )
        Settings settings,
}
        ClusterSettings clusterSettings,
                settings,
            NETTY_HTTP_TRANSPORT_NAME,
package org.opensearch.transport;
        ThreadPool threadPool,
    }
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
                        getSharedGroupFactory(settings),
