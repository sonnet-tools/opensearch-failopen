import org.opensearch.transport.nio.MockNioTransport;
    public void testBuildDynamicNodes() throws Exception {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.threadpool.ThreadPool;  
            } finally {
                transportService,  
        assertEquals(9305, nodes.get(1).getPort());
import java.util.List;
        }
import org.opensearch.Version;
                transportService,
        final List<String> hostEntries = Arrays.asList("192.168.0.1:9300:9300", "192.168.0.1:9301");
        ) {
 */  
 * GitHub history for details.
/*
        assertEquals(1, addresses.size()); // only one of the two is valid and will be used  
        final MockNioTransport transport = new MockNioTransport(
    private ExecutorService executorService;
import java.util.concurrent.Executors;  
import org.opensearch.test.OpenSearchTestCase;  
    public void testInvalidHostEntries() throws Exception {  
        threadPool = new TestThreadPool(FileBasedSeedHostsProviderTests.class.getName());
        );  
            hosts -> SeedHostsResolver.resolveHostsLists(  
 *  
        assertEquals(9300, nodes.get(2).getPort());  
import java.nio.file.Files;  
        assertEquals("192.168.0.2", nodes.get(1).getAddress());  
    }
        final List<TransportAddress> addresses = setupAndRunHostProvider(hostEntries);
 * this work for additional information regarding copyright
            NoopTracer.INSTANCE
                executorService,  
package org.opensearch.discovery;
 */
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.common.network.NetworkService;
                TimeValue.timeValueSeconds(10)
        executorService = Executors.newSingleThreadExecutor();
    }
import org.opensearch.common.settings.Settings;  
        final Path homeDir = createTempDir();
        final List<String> hostEntries = Collections.singletonList("192.168.0.1:9300:9300");
 */  
    }
 * Modifications Copyright OpenSearch Contributors. See
            threadPool,
import java.net.InetAddress;
            writer.write(String.join("\n", hostEntries));  
import org.opensearch.core.common.transport.TransportAddress;  
        assertEquals(9301, addresses.get(0).getPort());
                TimeValue.timeValueSeconds(10)  
            Settings.EMPTY,  
        final List<TransportAddress> addresses = setupAndRunHostProvider(hostEntries);
            new NetworkService(Collections.emptyList()),  
            new NamedWriteableRegistry(Collections.emptyList()),
        assertEquals("192.168.0.1", addresses.get(0).getAddress());
import org.opensearch.common.unit.TimeValue;
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.discovery.FileBasedSeedHostsProvider.UNICAST_HOSTS_FILE;
                logger,
            }  
    private List<TransportAddress> setupAndRunHostProvider(final List<String> hostEntries) throws IOException {
        } finally {
                    new TransportAddress(InetAddress.getLoopbackAddress(), 9300)
    public void tearDown() throws Exception {
    }
    @Before
        assertEquals(0, addresses.size());  
            )
        assertEquals("255.255.23.15", nodes.get(2).getAddress());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertEquals(hostEntries.size() - 1, nodes.size()); // minus 1 because we are ignoring the first line that's a comment  
    }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import org.opensearch.common.util.CancellableThreads;
            NoopTracer.INSTANCE
import java.util.concurrent.ExecutorService;
                logger,  
                hosts,
 * under the License.  
    public void testEmptyUnicastHostsFile() throws Exception {  
                terminate(threadPool);  
        assertEquals("192.168.0.1", nodes.get(0).getAddress());
import java.util.Arrays;
    }
import org.opensearch.test.transport.MockTransportService;
        );
public class FileBasedSeedHostsProviderTests extends OpenSearchTestCase {
import org.opensearch.core.common.transport.BoundTransportAddress;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
    private ThreadPool threadPool;  
/*  
import org.opensearch.transport.TransportService;
                new CancellableThreads(),
                super.tearDown();
            null,
            Settings.EMPTY,  
    public void testSomeInvalidHostEntries() throws Exception {  
    }
    public void setUp() throws Exception {
            terminate(executorService);  
            try {
 * license agreements. See the NOTICE file distributed with
import org.junit.After;  
        final List<TransportAddress> nodes = setupAndRunHostProvider(hostEntries);
        final Path configPath = randomBoolean() ? homeDir.resolve("config") : createTempDir();  
            new NoneCircuitBreakerService(),  
    // sets up the config dir, writes to the unicast hosts file in the config dir,
    }  
        return new FileBasedSeedHostsProvider(configPath).getSeedAddresses(  
        Files.createDirectories(configPath);
 * You may obtain a copy of the License at  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        super.setUp();  
        createTransportSvc();  
 *
        );  
 * Licensed to Elasticsearch under one or more contributor  
            public BoundTransportAddress boundAddress() {
    @After  
 * ownership. Elasticsearch licenses this file to you under  
                new CancellableThreads(),
            threadPool,
                executorService,
import org.junit.Before;
    private void createTransportSvc() {
        final List<TransportAddress> addresses = provider.getSeedAddresses(
            transport,
 * software distributed under the License is distributed on an
import java.io.BufferedWriter;  
import org.opensearch.common.util.PageCacheRecycler;  
        try (BufferedWriter writer = Files.newBufferedWriter(configPath.resolve(UNICAST_HOSTS_FILE))) {
    public void testUnicastHostsDoesNotExist() {  
        assertEquals(0, addresses.size());  
        }
 * not use this file except in compliance with the License.
 * compatible open source license.
    }
        assertEquals(9300, nodes.get(0).getPort());
import java.io.IOException;
 * specific language governing permissions and limitations
    private MockTransportService transportService;
                );
            Version.CURRENT,
 *
                return new BoundTransportAddress(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override  
        final List<String> hostEntries = Arrays.asList("#comment, should be ignored", "192.168.0.1", "192.168.0.2:9305", "255.255.23.15");
        };
 * this file be licensed under the Apache-2.0 license or a
        try {
 * KIND, either express or implied.  See the License for the
        transportService = new MockTransportService(
        final List<TransportAddress> addresses = setupAndRunHostProvider(hostEntries);
                hosts,
    // and then runs the file-based unicast host provider to get the list of discovery nodes  
            hosts -> SeedHostsResolver.resolveHostsLists(
        assertEquals(0, addresses.size());  
import java.util.Collections;  
}
                    new TransportAddress[] { new TransportAddress(InetAddress.getLoopbackAddress(), 9300) },  
 *    http://www.apache.org/licenses/LICENSE-2.0
        final List<String> hostEntries = Collections.emptyList();
            )
            }  
        final FileBasedSeedHostsProvider provider = new FileBasedSeedHostsProvider(createTempDir().toAbsolutePath());
import java.nio.file.Path;
