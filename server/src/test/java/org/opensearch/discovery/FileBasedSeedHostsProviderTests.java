        executorService = Executors.newSingleThreadExecutor();
            transport,
        assertEquals(hostEntries.size() - 1, nodes.size()); // minus 1 because we are ignoring the first line that's a comment
    public void testBuildDynamicNodes() throws Exception {
                super.tearDown();
/*
                terminate(threadPool);
            )
                return new BoundTransportAddress(
    private void createTransportSvc() {
 * You may obtain a copy of the License at
    private List<TransportAddress> setupAndRunHostProvider(final List<String> hostEntries) throws IOException {
        assertEquals(0, addresses.size());
import java.util.Arrays;
 * Modifications Copyright OpenSearch Contributors. See
    }
        assertEquals("192.168.0.1", addresses.get(0).getAddress());
        assertEquals(0, addresses.size());
public class FileBasedSeedHostsProviderTests extends OpenSearchTestCase {
        try {
    // sets up the config dir, writes to the unicast hosts file in the config dir,
                transportService,
    public void tearDown() throws Exception {
    public void setUp() throws Exception {
import org.opensearch.common.util.CancellableThreads;
 * SPDX-License-Identifier: Apache-2.0
        final List<TransportAddress> addresses = setupAndRunHostProvider(hostEntries);
import org.opensearch.threadpool.TestThreadPool;
        final List<String> hostEntries = Collections.emptyList();
 *
        assertEquals(1, addresses.size()); // only one of the two is valid and will be used
                logger,
        );
 */
 * software distributed under the License is distributed on an
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.nio.file.Files;
                TimeValue.timeValueSeconds(10)
 * under the License.
        assertEquals(0, addresses.size());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    public void testUnicastHostsDoesNotExist() {
            threadPool,
                    new TransportAddress[] { new TransportAddress(InetAddress.getLoopbackAddress(), 9300) },
                transportService,
            @Override
        transportService = new MockTransportService(
        ) {
import org.opensearch.core.common.transport.TransportAddress;
            hosts -> SeedHostsResolver.resolveHostsLists(
        try (BufferedWriter writer = Files.newBufferedWriter(configPath.resolve(UNICAST_HOSTS_FILE))) {
            writer.write(String.join("\n", hostEntries));
        return new FileBasedSeedHostsProvider(configPath).getSeedAddresses(
            Settings.EMPTY,
                logger,
                new CancellableThreads(),
        } finally {
 * compatible open source license.
import org.opensearch.common.network.NetworkService;
            } finally {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        final Path homeDir = createTempDir();
        final List<String> hostEntries = Arrays.asList("#comment, should be ignored", "192.168.0.1", "192.168.0.2:9305", "255.255.23.15");
        final List<TransportAddress> nodes = setupAndRunHostProvider(hostEntries);
        }
    }
            }
    @Before
import org.opensearch.transport.TransportService;
        );
            terminate(executorService);
import java.util.List;
 * KIND, either express or implied.  See the License for the
import org.opensearch.Version;
            Version.CURRENT,
}
    public void testSomeInvalidHostEntries() throws Exception {
        assertEquals("192.168.0.2", nodes.get(1).getAddress());
                hosts,
            )
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(9301, addresses.get(0).getPort());
            new NamedWriteableRegistry(Collections.emptyList()),
 * license agreements. See the NOTICE file distributed with
        createTransportSvc();
import java.nio.file.Path;
    }
 *
    }
            NoopTracer.INSTANCE
                    new TransportAddress(InetAddress.getLoopbackAddress(), 9300)
    @After
import org.opensearch.common.settings.Settings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.junit.Before;
import org.opensearch.test.transport.MockTransportService;
package org.opensearch.discovery;
        assertEquals(9300, nodes.get(2).getPort());
        threadPool = new TestThreadPool(FileBasedSeedHostsProviderTests.class.getName());
import org.junit.After;
        assertEquals(9300, nodes.get(0).getPort());
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
    private ThreadPool threadPool;
    }
            try {
/*
                TimeValue.timeValueSeconds(10)
        Files.createDirectories(configPath);
                hosts,
        assertEquals(9305, nodes.get(1).getPort());
            NoopTracer.INSTANCE
import org.opensearch.test.OpenSearchTestCase;
            null,
    }
import java.io.IOException;
import java.util.concurrent.ExecutorService;
    public void testInvalidHostEntries() throws Exception {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
/*
import org.opensearch.threadpool.ThreadPool;
        assertEquals("192.168.0.1", nodes.get(0).getAddress());
        final FileBasedSeedHostsProvider provider = new FileBasedSeedHostsProvider(createTempDir().toAbsolutePath());
        assertEquals("255.255.23.15", nodes.get(2).getAddress());
import org.opensearch.core.common.transport.BoundTransportAddress;
        final List<TransportAddress> addresses = provider.getSeedAddresses(
            new NetworkService(Collections.emptyList()),
        final Path configPath = randomBoolean() ? homeDir.resolve("config") : createTempDir();
    public void testEmptyUnicastHostsFile() throws Exception {
        }
 * not use this file except in compliance with the License.
        final List<String> hostEntries = Collections.singletonList("192.168.0.1:9300:9300");
        };
            public BoundTransportAddress boundAddress() {
import static org.opensearch.discovery.FileBasedSeedHostsProvider.UNICAST_HOSTS_FILE;
                );
import org.opensearch.common.unit.TimeValue;
import java.net.InetAddress;
import org.opensearch.transport.nio.MockNioTransport;
    }
import java.util.Collections;
    }
    private MockTransportService transportService;
 * GitHub history for details.
    private ExecutorService executorService;
            }
import org.opensearch.common.util.PageCacheRecycler;
                new CancellableThreads(),
        super.setUp();
        final List<TransportAddress> addresses = setupAndRunHostProvider(hostEntries);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                executorService,
 * specific language governing permissions and limitations
            Settings.EMPTY,
    // and then runs the file-based unicast host provider to get the list of discovery nodes
            threadPool,
        final MockNioTransport transport = new MockNioTransport(
            hosts -> SeedHostsResolver.resolveHostsLists(
 *
import java.io.BufferedWriter;
 */
            new NoneCircuitBreakerService(),
 * The OpenSearch Contributors require contributions made to
        final List<String> hostEntries = Arrays.asList("192.168.0.1:9300:9300", "192.168.0.1:9301");
        final List<TransportAddress> addresses = setupAndRunHostProvider(hostEntries);
 * the Apache License, Version 2.0 (the "License"); you may
        );
 * this work for additional information regarding copyright
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
import java.util.concurrent.Executors;
                executorService,
