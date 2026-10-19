import org.opensearch.Version;  
    public static final String MOCK_NIO_TRANSPORT_NAME = "mock-nio";  
import org.opensearch.threadpool.ThreadPool;  
        );  
        return Collections.singletonMap(  
 * You may obtain a copy of the License at  
            )
        Settings settings,
                tracer
 * Unless required by applicable law or agreed to in writing,
/*
import org.opensearch.common.settings.Settings;
import org.opensearch.common.network.NetworkService;
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
 * compatible open source license.
 */  
/*  
/*
                threadPool,
        NamedWriteableRegistry namedWriteableRegistry,
        ThreadPool threadPool,
 * KIND, either express or implied.  See the License for the
 *
        Tracer tracer
    @Override
import org.opensearch.telemetry.tracing.Tracer;
                pageCacheRecycler,
        NetworkService networkService,  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 */
                circuitBreakerService,  
                namedWriteableRegistry,
            () -> new MockNioTransport(
    ) {
            MOCK_NIO_TRANSPORT_NAME,
}
 * ownership. Elasticsearch licenses this file to you under  
    }
    public Map<String, Supplier<Transport>> getTransports(  
package org.opensearch.transport.nio;
 * under the License.  
 * specific language governing permissions and limitations
 *
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.function.Supplier;
import org.opensearch.plugins.Plugin;
import org.opensearch.common.util.PageCacheRecycler;  
 * GitHub history for details.
import org.opensearch.transport.Transport;
import java.util.Collections;  
 * the Apache License, Version 2.0 (the "License"); you may
                settings,  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * this file be licensed under the Apache-2.0 license or a
                Version.CURRENT,
                networkService,  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        PageCacheRecycler pageCacheRecycler,  
 * this work for additional information regarding copyright
 */
public class MockNioTransportPlugin extends Plugin implements NetworkPlugin {
import org.opensearch.plugins.NetworkPlugin;  
        CircuitBreakerService circuitBreakerService,
 * license agreements. See the NOTICE file distributed with
import java.util.Map;
