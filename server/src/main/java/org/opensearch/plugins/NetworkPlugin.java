        ClusterSettings clusterSettings,  
        NamedXContentRegistry xContentRegistry,
        PageCacheRecycler pageCacheRecycler,
    default Map<String, Supplier<HttpServerTransport>> getSecureHttpTransports(  
     */
 */
        return Collections.emptyMap();  
        CircuitBreakerService circuitBreakerService,  
import org.opensearch.common.network.NetworkService;
import org.opensearch.common.annotation.ExperimentalApi;  
        Settings settings,
        ThreadPool threadPool,
 * ownership. Elasticsearch licenses this file to you under  
     */  
        return Collections.emptyMap();
        ClusterSettings clusterSettings,
        Settings settings,
    /**
        HttpServerTransport.Dispatcher dispatcher,  
    default Map<String, Supplier<AuxTransport>> getSecureAuxTransports(  
        SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,
        BigArrays bigArrays,  
        Tracer tracer  
     * Returns a list of {@link TransportInterceptor} instances that are used to intercept incoming and outgoing  
import org.opensearch.transport.AuxTransport;
        return Collections.emptyMap();
    }
    ) {
        SecureTransportSettingsProvider secureTransportSettingsProvider,
import org.opensearch.common.util.concurrent.ThreadContext;  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
     * transport (inter-node) requests. This must not return <code>null</code>
     *
        return Collections.emptyList();
    ) {  
    /**
     */
        Tracer tracer
     * See {@link org.opensearch.common.network.NetworkModule#TRANSPORT_TYPE_KEY} to configure a specific implementation.
        NamedWriteableRegistry namedWriteableRegistry,
    }
    ) {
        CircuitBreakerService circuitBreakerService,
 * the Apache License, Version 2.0 (the "License"); you may
        PageCacheRecycler pageCacheRecycler,  
        Tracer tracer  
 * SPDX-License-Identifier: Apache-2.0
}  
import java.util.List;  
        return Collections.emptyMap();  
     * Returns a map of secure {@link AuxTransport} suppliers.
        NetworkService networkService,
    default Map<String, Supplier<Transport>> getSecureTransports(
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 *  
 *
    }  
     */  
     *                      headers in the interceptors
    ) {  
 * You may obtain a copy of the License at  
    default Map<String, Supplier<Transport>> getTransports(  
        CircuitBreakerService circuitBreakerService,
 * compatible open source license.
     * See {@link org.opensearch.common.network.NetworkModule#HTTP_TYPE_SETTING} to configure a specific implementation.
     * Returns a map of AuxTransport suppliers.  
        ThreadPool threadPool,
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Returns a map of {@link HttpServerTransport} suppliers.
import org.opensearch.transport.TransportInterceptor;  
 * Unless required by applicable law or agreed to in writing,
/*
     * See {@link org.opensearch.common.network.NetworkModule#HTTP_TYPE_SETTING} to configure a specific implementation.
 * Plugin for extending network and transport related classes
    /**
    /**  
 */
        SecureAuxTransportSettingsProvider secureAuxTransportSettingsProvider,  
/*
     * Auxiliary transports are optional and run in parallel to the default HttpServerTransport.
import org.opensearch.common.util.PageCacheRecycler;
        NetworkService networkService,
 */
import java.util.Collections;
        NamedWriteableRegistry namedWriteableRegistry,
 * GitHub history for details.
        PageCacheRecycler pageCacheRecycler,
 * software distributed under the License is distributed on an
 * @opensearch.api
        ThreadPool threadPool,  
import org.opensearch.common.settings.ClusterSettings;
        return Collections.emptyMap();
     */  
        CircuitBreakerService circuitBreakerService,
    /**
    }
    default Map<String, Supplier<HttpServerTransport>> getHttpTransports(
    default List<TransportInterceptor> getTransportInterceptors(
        ThreadPool threadPool,
        HttpServerTransport.Dispatcher dispatcher,
        Settings settings,
 * not use this file except in compliance with the License.
    @ExperimentalApi
     * See {@link org.opensearch.common.network.NetworkModule#TRANSPORT_TYPE_KEY} to configure a specific implementation.
    ) {
        NetworkService networkService,
    @ExperimentalApi
        ThreadContext threadContext  
 * Licensed to Elasticsearch under one or more contributor  
        NamedXContentRegistry xContentRegistry,  
        NetworkService networkService,
     * Returns a map of {@link Transport} suppliers.  
        ClusterSettings clusterSettings,
public interface NetworkPlugin {  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BigArrays bigArrays,
import org.opensearch.common.util.BigArrays;
        CircuitBreakerService circuitBreakerService,  
     * See {@link org.opensearch.transport.AuxTransport#AUX_TRANSPORT_TYPES_SETTING} to configure a specific implementation.  
import org.opensearch.transport.Transport;
     */
        Settings settings,
    }
        Settings settings,
import org.opensearch.http.HttpServerTransport;
 * under the License.  
import org.opensearch.telemetry.tracing.Tracer;
    ) {
    /**
     * @param threadContext a {@link ThreadContext} of the current nodes or clients {@link ThreadPool} that can be used to set additional
        NetworkService networkService,
        Settings settings,
        ClusterSettings clusterSettings,
import org.opensearch.common.settings.Settings;  
        ThreadPool threadPool,  
 * Modifications Copyright OpenSearch Contributors. See  
        ThreadPool threadPool,
        Tracer tracer
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        PageCacheRecycler pageCacheRecycler,
    }  
 * this work for additional information regarding copyright
        return Collections.emptyMap();
    }  
        Tracer tracer
    /**  
     * @param namedWriteableRegistry registry of all named writeables registered  
        NamedWriteableRegistry namedWriteableRegistry,  
    default Map<String, Supplier<AuxTransport>> getAuxTransports(  
 *
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 *  
/*  
import java.util.function.Supplier;
     */
        NetworkService networkService,  
 */  
     * Returns a map of secure {@link HttpServerTransport} suppliers.  
/**
 * specific language governing permissions and limitations
    ) {
        CircuitBreakerService circuitBreakerService,  
     * Returns a map of secure {@link Transport} suppliers.
        Tracer tracer
package org.opensearch.plugins;
