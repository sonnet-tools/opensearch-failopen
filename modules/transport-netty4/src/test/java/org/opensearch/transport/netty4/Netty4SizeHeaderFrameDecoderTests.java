import org.opensearch.common.settings.Settings;  
            new SharedGroupFactory(settings),
import java.util.Collections;
public class Netty4SizeHeaderFrameDecoderTests extends OpenSearchTestCase {  
        nettyTransport.start();
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.common.util.PageCacheRecycler;
 * Unless required by applicable law or agreed to in writing,
            settings,
            }  
import org.opensearch.common.util.MockPageCacheRecycler;
        .put(TransportSettings.PORT.getKey(), "0")
    }
    public void terminateThreadPool() throws InterruptedException {
 * Licensed to Elasticsearch under one or more contributor  
                assertThat(reader.readLine(), is("This is not an HTTP port"));
    public void startThreadPool() {
    private InetAddress host;
            // end of stream  
 * ownership. Elasticsearch licenses this file to you under  
 *
            socket.getOutputStream().flush();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
        try (Socket socket = new Socket(host, port)) {  
 */  
 *  
 */
        TransportAddress transportAddress = randomFrom(boundAddresses);
    @After
import org.opensearch.Version;
        .put(TransportSettings.BIND_HOST.getKey(), "127.0.0.1")
            assertThat(socket.getInputStream().read(), is(-1));
        }
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.transport.SharedGroupFactory;  
            Version.CURRENT,
    private Netty4Transport nettyTransport;  
import java.net.InetAddress;
        nettyTransport = new Netty4Transport(  
    private ThreadPool threadPool;
        port = transportAddress.address().getPort();  
    private final Settings settings = Settings.builder()
            socket.getOutputStream().write("FOOBAR".getBytes(StandardCharsets.UTF_8));  
        NetworkService networkService = new NetworkService(Collections.emptyList());
        threadPool = null;
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Before
    public void testThatNothingIsReturnedForOtherInvalidPackets() throws Exception {
        .put("node.name", "NettySizeHeaderFrameDecoderTests")  
        PageCacheRecycler recycler = new MockPageCacheRecycler(Settings.EMPTY);
import org.opensearch.threadpool.ThreadPool;
/*  
 * license agreements. See the NOTICE file distributed with
        nettyTransport.stop();  
        }
 * actually returns text response instead of just dropping the connection
        );
        terminate(threadPool);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
    private int port;
 * GitHub history for details.
 * under the License.  
        TransportAddress[] boundAddresses = nettyTransport.boundAddress().boundAddresses();
 * the Apache License, Version 2.0 (the "License"); you may
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {
}
            networkService,
 * Modifications Copyright OpenSearch Contributors. See
 * This test checks, if an HTTP look-alike request (starting with an HTTP method and a space)  
import java.io.BufferedReader;
import static org.hamcrest.Matchers.is;  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import java.net.Socket;
        String randomMethod = randomFrom("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH");  
        .build();  
            socket.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
        try (Socket socket = new Socket(host, port)) {
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
            new NoneCircuitBreakerService(),
/**
        threadPool = new ThreadPool(settings);  
 * specific language governing permissions and limitations
    }  
/*
    public void testThatTextMessageIsReturnedOnHTTPLikeRequest() throws Exception {
            new NamedWriteableRegistry(Collections.emptyList()),  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
import org.junit.Before;  
import org.junit.After;
package org.opensearch.transport.netty4;
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.network.NetworkService;
            NoopTracer.INSTANCE  
        host = transportAddress.address().getAddress();
 */  
import org.opensearch.transport.TransportSettings;
 * this work for additional information regarding copyright
            recycler,
    }
import java.io.InputStreamReader;  
/*  
 * SPDX-License-Identifier: Apache-2.0
import java.nio.charset.StandardCharsets;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            socket.getOutputStream().flush();
        String data = randomMethod + " / HTTP/1.1";
            threadPool,  
 * not use this file except in compliance with the License.
 * compatible open source license.
