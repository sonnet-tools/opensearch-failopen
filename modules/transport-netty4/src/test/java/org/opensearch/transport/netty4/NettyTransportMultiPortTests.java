            terminate(threadPool);  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
            terminate(threadPool);
        }
            .build();  
 */  
 * ownership. Elasticsearch licenses this file to you under  
            .put("transport.profiles.default.port", 0)
            new NoneCircuitBreakerService(),
        PageCacheRecycler recycler = new MockPageCacheRecycler(Settings.EMPTY);  
 * Unless required by applicable law or agreed to in writing,
            new NetworkService(Collections.emptyList()),
        assertThat(transport.lifecycleState(), is(Lifecycle.State.STARTED));
 * under the License.  
 * compatible open source license.
        ThreadPool threadPool = new TestThreadPool("tst");
            .build();  
            assertEquals(1, transport.boundAddress().boundAddresses().length);
import org.opensearch.Version;  
    @Before
 * software distributed under the License is distributed on an
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> startTransport(settings, threadPool));  
        }
            terminate(threadPool);  
 *
            terminate(threadPool);
        if (NetworkUtils.SUPPORTS_V6 && randomBoolean()) {
            new SharedGroupFactory(settings),  
 * license agreements. See the NOTICE file distributed with
            assertEquals(1, transport.boundAddress().boundAddresses().length);
            assertEquals(1, transport.profileBoundAddresses().size());
 */
    public void testThatNettyCanBindToMultiplePorts() throws Exception {
    public void testThatDefaultProfilePortOverridesGeneralConfiguration() throws Exception {
            .put(TransportSettings.PORT.getKey(), 22) // will not actually bind to this
            NoopTracer.INSTANCE
            assertEquals(1, transport.boundAddress().boundAddresses().length);
            .put("network.host", host)  
        } finally {
        } finally {  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
    }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        Settings settings = Settings.builder()  
 * specific language governing permissions and limitations
}
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            settings,
        Settings settings = Settings.builder()
            .put(TransportSettings.PORT.getKey(), 0)
            .put("network.host", host)  
            .put("network.host", host)
import org.opensearch.common.network.NetworkUtils;  
    private TcpTransport startTransport(Settings settings, ThreadPool threadPool) {
            recycler,  
        );
        ThreadPool threadPool = new TestThreadPool("tst");
import org.opensearch.transport.SharedGroupFactory;
        }
            .put("transport.profiles.client1.port", 0)
    public void setup() {  
public class NettyTransportMultiPortTests extends OpenSearchTestCase {
package org.opensearch.transport.netty4;
        TcpTransport transport = new Netty4Transport(
        try (TcpTransport transport = startTransport(settings, threadPool)) {  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
        Settings settings = Settings.builder()
            .put("transport.profiles.default.port", 0)  
 *
            assertEquals("profile [client1] has no port configured", ex.getMessage());
import org.opensearch.test.OpenSearchTestCase;
import static org.hamcrest.Matchers.is;
/*
/*
 * the Apache License, Version 2.0 (the "License"); you may
        Settings settings = Settings.builder()
import org.opensearch.common.network.NetworkService;
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
            .put("network.host", host)
            .put("transport.profiles.client1.whatever", "foo")
import java.util.Collections;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.threadpool.ThreadPool;  
            host = "127.0.0.1";
            .put(TransportSettings.PORT.getKey(), 22) // will not actually bind to this
            threadPool,
/*  
        }
            Version.CURRENT,  
            .put("transport.profiles.client1.port", 0)
    }
        try {
            assertEquals(0, transport.profileBoundAddresses().size());
import org.opensearch.transport.TransportSettings;  
        return transport;  
        } else {  
        }
            new NamedWriteableRegistry(Collections.emptyList()),
    private String host;  
            .build();
        } finally {
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
 * GitHub history for details.
            assertEquals(1, transport.profileBoundAddresses().size());  
        try (TcpTransport transport = startTransport(settings, threadPool)) {  
 *  
import org.opensearch.common.lifecycle.Lifecycle;
    public void testThatProfileWithoutPortSettingsFails() throws Exception {
        try (TcpTransport transport = startTransport(settings, threadPool)) {
        transport.start();  
    }  
        } finally {  
import org.opensearch.common.util.PageCacheRecycler;  
            host = "::1";
    }  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.util.MockPageCacheRecycler;
        ThreadPool threadPool = new TestThreadPool("tst");
import org.opensearch.transport.TcpTransport;
        ThreadPool threadPool = new TestThreadPool("tst");
import org.junit.Before;
    public void testThatDefaultProfileInheritsFromStandardSettings() throws Exception {
            .build();
import org.opensearch.threadpool.TestThreadPool;
    }  
            .put(TransportSettings.PORT.getKey(), 0)  
