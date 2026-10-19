        }
                    new TransportAddress[] { new TransportAddress(InetAddress.getLoopbackAddress(), 9300) },
            }
 */
        final Transport transport = new MockNioTransport(
            Collections.emptySet(),
            TimeValue.timeValueSeconds(30)
        );
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
                    new TransportAddress(loopbackAddress, 9302)
        final UnknownHostException unknownHostException = new UnknownHostException(hostname);
            }
                return new BoundTransportAddress(
                transportService,
        final List<TransportAddress> transportAddresses = SeedHostsResolver.resolveHostsLists(
            assertThat(transportAddresses, hasSize(1));
        closeables.push(transport);
            }
            threadPool,
                return new BoundTransportAddress(
        recreateSeedHostsResolver(
                resolveTimeout
        );
    }
        final AtomicReference<List<TransportAddress>> resolvedAddressesRef = new AtomicReference<>();
                );
        assertThat(transportAddresses.get(0).getAddress(), equalTo("127.0.0.1"));
            @Override
            }
            resolvedAddressesRef.set(resolvedAddresses);
            logger,
    private void recreateSeedHostsResolver(TransportService transportService, Settings settings) {
        });
                throw unknownHostException;
            Collections.emptySet(),
 * Modifications Copyright OpenSearch Contributors. See
            null,
            Version.CURRENT,
            x -> null,
            new NamedWriteableRegistry(Collections.emptyList()),
    @After
            networkService,
            null,
            transport,
            transportAddresses.add(buildNewFakeTransportAddress());
 * this file be licensed under the Apache-2.0 license or a
                return new BoundTransportAddress(
        };
import java.util.concurrent.atomic.AtomicReference;
 * software distributed under the License is distributed on an
                    new TransportAddress(InetAddress.getLoopbackAddress(), 9500)
        assertThat(resolvedAddressesRef.get(), equalTo(transportAddresses));
 * ownership. Elasticsearch licenses this file to you under
            transportService,
 * Unless required by applicable law or agreed to in writing,
        }
            NoopTracer.INSTANCE
            @Override
    private SeedHostsResolver seedHostsResolver;
                );
        threadPool.generic().execute((() -> fut.onResponse(seedHostsResolver.resolveHosts(Arrays.asList("hostname1", "hostname2")))));
import org.opensearch.common.util.PageCacheRecycler;
            @Override
/*
                if ("hostname1".equals(address)) {
import org.junit.After;
        final NetworkService networkService = new NetworkService(Collections.emptyList());
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        for (int i = 0; i < addressCount; i++) {
 *
                        latch.await();
            try {
        ) {
            threadPool.getThreadContext()
            threadPool,
            null,
        final CountDownLatch latch = new CountDownLatch(1);
            verifyNoMoreInteractions(logger);
            Settings.EMPTY,
    public void stopResolver() throws IOException {
import java.util.Set;
            @Override
        final NetworkService networkService = new NetworkService(Collections.emptyList());
            // JDK stack is broken, it does not iterate in the expected order (http://bugs.java.com/bugdatabase/view_bug.do?bug_id=4475301)
            final List<Closeable> reverse = new ArrayList<>();
import org.mockito.Mockito;
    @Before
    public void testResolvesAddressesInBackgroundAndIgnoresConcurrentCalls() throws Exception {
            TimeUnit.SECONDS,
        closeables.push(transportService);
            NoopTracer.INSTANCE
    // close in reverse order as opened
    private Stack<Closeable> closeables;
        try {
                    try {
                );
        final Transport transport = new MockNioTransport(
            new NoneCircuitBreakerService(),
            new CancellableThreads(),
            x -> null,
            new NamedWriteableRegistry(Collections.emptyList()),
            terminate(executorService);
package org.opensearch.discovery;
            public BoundTransportAddress boundAddress() {
            new NamedWriteableRegistry(Collections.emptyList()),
                    }
        final Logger logger = mock(Logger.class);
import static org.hamcrest.Matchers.hasSize;
            NoopTracer.INSTANCE
            new NoneCircuitBreakerService(),
        } finally {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            logger,
        threadPool = new TestThreadPool("node");
            }
        closeables = new Stack<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            verify(logger).warn("timed out after [{}] resolving host [{}]", resolveTimeout, "hostname2");
            ports.add(address.getPort());
        );
                        throw new RuntimeException(e);
                } else {
            new NoneCircuitBreakerService(),
 * compatible open source license.
            NoopTracer.INSTANCE
            assertTrue(address.address().getAddress().isLoopbackAddress());
import java.util.Arrays;
 * the Apache License, Version 2.0 (the "License"); you may
            null,
        final TransportService transportService = new TransportService(
        seedHostsResolver.start();
            final List<TransportAddress> transportAddresses = SeedHostsResolver.resolveHostsLists(
            transportService,
            public BoundTransportAddress boundAddress() {
import java.util.stream.IntStream;
            logger,
                    new TransportAddress[] { new TransportAddress(InetAddress.getLoopbackAddress(), 9500) },
            logger.info("shutting down...");
        ) {
import org.opensearch.common.util.io.IOUtils;
        assertThat(transportAddresses.get(0).getPort(), equalTo(9301));
        };
        transportAddresses = new ArrayList<>();
                        conditionLatch.countDown();
import java.util.Stack;
        );
            Collections.emptySet(),
    private ExecutorService executorService;
        closeables.push(transport);
            NoopTracer.INSTANCE
import static org.mockito.Mockito.mock;
            x -> null,
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.TimeUnit;
 * The OpenSearch Contributors require contributions made to
            new NoneCircuitBreakerService(),
    public void testInvalidHosts() throws IllegalAccessException {
import org.opensearch.transport.Transport;
                        throw new RuntimeException(e);
            getClass().getName() + "/" + getTestName(),
            transportService,
            seedHostsResolver.stop();
 */
        final TransportService transportService = new TransportService(
        );
            new CancellableThreads(),
}
 * SPDX-License-Identifier: Apache-2.0
            } catch (InterruptedException e) {
            transport,
        final Transport transport = new MockNioTransport(
 * KIND, either express or implied.  See the License for the
            Arrays.asList("127.0.0.1:9300:9300", "127.0.0.1:9301"),
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            NoopTracer.INSTANCE
    }
        assertTrue(endLatch.await(30, TimeUnit.SECONDS));
            Settings.EMPTY,
import org.junit.Before;
            Settings.EMPTY,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            latch.countDown();
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        seedHostsResolver.start();
            public TransportAddress[] addressesFromString(String address) throws UnknownHostException {
        );
                    } catch (InterruptedException e) {
 * not use this file except in compliance with the License.
            new NamedWriteableRegistry(Collections.emptyList()),
            NoopTracer.INSTANCE
 * You may obtain a copy of the License at
    }
            executorService,
        final TransportService transportService = new TransportService(
 *
                    new TransportAddress(InetAddress.getLoopbackAddress(), 9300)
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.Mockito.verifyNoMoreInteractions;
        assertThat(ports, equalTo(IntStream.range(9303, 9310).mapToObj(m -> m).collect(Collectors.toSet())));
import java.util.HashSet;
import org.opensearch.common.network.NetworkService;
import org.opensearch.Version;
                executorService,
        verify(logger).warn(eq("failed to resolve host [127.0.0.1:9300:9300]"), Mockito.any(IllegalArgumentException.class));
        final List<TransportAddress> transportAddresses = SeedHostsResolver.resolveHostsLists(
 */
import org.opensearch.transport.nio.MockNioTransport;
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        for (final TransportAddress address : transportAddresses) {
            Arrays.asList(hostname),
            new NamedWriteableRegistry(Collections.emptyList()),
            threadPool,
 * under the License.
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
    }
            Version.CURRENT,
import org.opensearch.threadpool.ThreadPool;
            null,
        };
 * Licensed to Elasticsearch under one or more contributor
            NoopTracer.INSTANCE
            terminate(threadPool);
            Collections.emptySet(),
            transport,
        final PlainActionFuture<List<TransportAddress>> fut = new PlainActionFuture<>();
import java.util.concurrent.CountDownLatch;
        assertThat(resolvedAddressesRef.get(), nullValue());
            transport,
    }
                return new BoundTransportAddress(
            Settings.EMPTY,
            2,
            NoopTracer.INSTANCE
                        latch.await();
            networkService,
        }
        final Transport transport = new MockNioTransport(
        TransportService transportService = mock(TransportService.class);
import org.opensearch.common.settings.Settings;
import java.util.concurrent.ExecutorService;
            Settings.EMPTY,
        final CountDownLatch latch = new CountDownLatch(1);
import static org.hamcrest.Matchers.equalTo;
                "resolved host [{}] to {}",
        seedHostsResolver.stop();
import org.opensearch.core.common.transport.BoundTransportAddress;
import static org.mockito.Mockito.eq;
        final TransportService transportService = new TransportService(
        executorService = OpenSearchExecutors.newScaling(
        };
import java.util.concurrent.ThreadFactory;
            public TransportAddress[] addressesFromString(String address) throws UnknownHostException {
                );
import org.opensearch.common.unit.TimeValue;
            new NetworkService(Collections.emptyList()),
            threadFactory,
 * specific language governing permissions and limitations
            NoopTracer.INSTANCE
            }
                    new TransportAddress[] { new TransportAddress(loopbackAddress, 9300), new TransportAddress(loopbackAddress, 9301) },
                logger,
            Settings.EMPTY,
            @Override
            networkService,
            }
import org.opensearch.common.network.NetworkAddress;
                );
                new TransportAddress[] { new TransportAddress(TransportAddress.META_ADDRESS, 9300) }
        seedHostsResolver.stop();
        closeables.push(transportService);
                    new TransportAddress(InetAddress.getLoopbackAddress(), 9500)
    private List<TransportAddress> transportAddresses;
        conditionLatch.await();
        seedHostsResolver.resolveConfiguredHosts(resolvedAddresses -> {
                assertTrue(startLatch.await(30, TimeUnit.SECONDS));
            Version.CURRENT,
                return new BoundTransportAddress(
            threadPool,
 * this work for additional information regarding copyright
            }
            threadPool,
        when(transportService.getThreadPool()).thenReturn(threadPool);
import org.apache.logging.log4j.Logger;
        seedHostsResolver = new SeedHostsResolver("test_node", Settings.EMPTY, transportService, hostsResolver -> transportAddresses);
        } finally {
import java.util.Collections;
        closeables.push(transportService);
            verify(logger).trace(
        closeables.push(transportService);
import static org.hamcrest.core.IsNull.nullValue;
            60,
        }
            threadPool,
                        return new TransportAddress[] { new TransportAddress(TransportAddress.META_ADDRESS, 9300) };
        final CountDownLatch startLatch = new CountDownLatch(1);
            public BoundTransportAddress boundAddress() {
            while (!closeables.isEmpty()) {
                }
                }
            Settings.builder().put(SeedHostsResolver.DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING.getKey(), "10m").build()
import org.opensearch.common.util.CancellableThreads;
                new CancellableThreads(),
        final List<TransportAddress> transportAddresses = SeedHostsResolver.resolveHostsLists(
        assertThat(transportAddresses, hasSize(1)); // only one of the two is valid and will be used
import java.net.UnknownHostException;
        assertThat(FutureUtils.get(fut, 10, TimeUnit.SECONDS), hasSize(0));
                } else if ("hostname2".equals(address)) {
            threadPool,
import java.net.InetAddress;
            threadPool,
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
import static org.mockito.Mockito.verify;
            @Override
        seedHostsResolver = new SeedHostsResolver("test_node", settings, transportService, hostsResolver -> transportAddresses);
                    try {
        final NetworkService networkService = new NetworkService(Collections.emptyList());
        );
            public BoundTransportAddress boundAddress() {
            Settings.EMPTY,
        try {
        closeables.push(transport);
        closeables.push(transportService);
                    new TransportAddress[] { new TransportAddress(InetAddress.getLoopbackAddress(), 9500) },
    }
    public void testCancellationOnClose() throws InterruptedException {
        final String hostname = randomAlphaOfLength(8);
            Collections.emptySet(),
                    new TransportAddress[] { new TransportAddress(InetAddress.getLoopbackAddress(), 9300) },
                Arrays.asList("hostname1", "hostname2"),
        ) {
            TimeValue.timeValueSeconds(30)
        };
import org.opensearch.core.common.transport.TransportAddress;
                } else if ("hostname2".equals(address)) {
import java.util.ArrayList;
                reverse.add(closeables.pop());
        seedHostsResolver.resolveConfiguredHosts(resolvedAddresses -> { throw new AssertionError("unexpected concurrent resolution"); });
                    } catch (InterruptedException e) {
            threadPool,
            public TransportAddress[] addressesFromString(String address) throws UnknownHostException {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        final TimeValue resolveTimeout = TimeValue.timeValueSeconds(randomIntBetween(3, 5));
            transport,
    }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        verify(logger).warn("failed to resolve host [" + hostname + "]", unknownHostException);
            0,
        ) {
        final ThreadFactory threadFactory = OpenSearchExecutors.daemonThreadFactory("[" + getClass().getName() + "]");
            }
/*
    public void testUnknownHost() {
        final Transport transport = new MockNioTransport(
        final CountDownLatch conditionLatch = new CountDownLatch(1);
                    throw new UnknownHostException(address);
                } else {
        }
            TimeValue.timeValueSeconds(30)
 * GitHub history for details.
        startLatch.countDown();
            Version.CURRENT,
                    return new TransportAddress[] { new TransportAddress(TransportAddress.META_ADDRESS, 9300) };
        final NetworkService networkService = new NetworkService(Collections.emptyList());
            executorService,
            Settings.EMPTY,
    public void startResolver() {
public class SeedHostsResolverTests extends OpenSearchTestCase {
        final int addressCount = randomIntBetween(0, 5);
import java.io.IOException;
        assertThat(transportAddresses, hasSize(7));
        if (seedHostsResolver != null) {
/*
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        final InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
            x -> null,
        final CountDownLatch endLatch = new CountDownLatch(1);
import java.util.List;
        final Logger logger = mock(Logger.class);
            }
            endLatch.countDown();
                    new TransportAddress(InetAddress.getLoopbackAddress(), 9300)
import static org.hamcrest.Matchers.empty;
            new CancellableThreads(),
    public void testRemovingLocalAddresses() {
        assertThat(transportAddresses, empty());
        ) {
        closeables.push(transport);
            executorService,
        );
        closeables.push(transport);
                        throw new AssertionError("should never be called");
            );
            networkService,
        final Set<Integer> ports = new HashSet<>();
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
            Version.CURRENT,
            transportService,
            x -> null,
                throw new AssertionError(e);
            new NoneCircuitBreakerService(),
        final TransportService transportService = new TransportService(
            IOUtils.close(reverse);
        );
            IntStream.range(9300, 9310).mapToObj(port -> NetworkAddress.format(loopbackAddress) + ":" + port).collect(Collectors.toList()),
            @Override
import java.util.stream.Collectors;
                if ("hostname1".equals(address)) {
            public BoundTransportAddress boundAddress() {
                    return new TransportAddress[] { new TransportAddress(TransportAddress.META_ADDRESS, 9300) };
import org.opensearch.transport.TransportService;
import org.opensearch.threadpool.TestThreadPool;
            @Override
import static org.mockito.Mockito.when;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Logger logger = mock(Logger.class);
            );
import org.opensearch.common.util.concurrent.FutureUtils;
                    }
    public void testResolveTimeout() {
        );
            Settings.EMPTY,
 *
                "hostname1",
import java.io.Closeable;
            threadPool,
                    throw new UnknownHostException(address);
            Settings.EMPTY,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
    private ThreadPool threadPool;
import org.opensearch.action.support.PlainActionFuture;
    }
