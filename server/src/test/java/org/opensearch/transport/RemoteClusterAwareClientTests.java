                    SearchRequest request = new SearchRequest("test-index");
                            seedTransport.getLocalDiscoNode(),
                            }
 *
                    threadPool,
package org.opensearch.transport;
                MockTransportService service = MockTransportService.createNewService(
                                responseLatch
                MockTransportService service = MockTransportService.createNewService(
import static org.mockito.ArgumentMatchers.eq;
                                .routing(request.routing());
                            public void handleStreamResponse(StreamTransportResponse<TransportResponse> s) {}
                            }
import org.opensearch.core.common.io.stream.StreamInput;
        }
    }
                                .indicesOptions(request.indicesOptions())
                            }
            knownNodes.add(seedNode);
            MockTransportService seedTransport = startTransport("seed_node", knownNodes);
                    NoopTracer.INSTANCE
                when(streamTransportService.getStreamTransportReqTimeout()).thenReturn(TimeValue.timeValueSeconds(30));
import java.util.concurrent.ExecutorService;
                                .cluster()
                            "internal:test/stream",
 *
        };
                            } catch (InterruptedException e) {
        }
                    Version.CURRENT,
 * Licensed to Elasticsearch under one or more contributor
                // connectToNode (non-final, stream-transport-specific) fails synchronously.
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    IllegalStateException e = expectThrows(
                    threadPool,
            knownNodes.add(seedTransport.getLocalDiscoNode());
 * You may obtain a copy of the License at
                            new SearchRequest("test-index"),
            }
import org.opensearch.threadpool.ThreadPool;
        try (
import org.opensearch.core.action.ActionListener;
import java.util.Arrays;
        return RemoteClusterConnectionTests.startTransport(id, knownNodes, Version.CURRENT, threadPool);
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                                .preference(request.preference())
        return new StreamTransportResponseHandler<>() {
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
import org.opensearch.core.transport.TransportResponse;
            ) {
                AtomicReference<TransportException> handlerError = new AtomicReference<>();
        ) {
                service.start();
import java.util.concurrent.CopyOnWriteArrayList;
 * not use this file except in compliance with the License.
                        );
                    assertTrue(
                    CountDownLatch responseLatch = new CountDownLatch(1);
/*
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
 * The OpenSearch Contributors require contributions made to
                        .searchShards(
                                .searchShards(searchShardsRequest, new LatchedActionListener<>(ActionListener.wrap(resp -> {
import org.opensearch.cluster.node.DiscoveryNode;
                                .local(true)
import org.opensearch.common.util.concurrent.ThreadContext;
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes)
                            try {
                        });
                                    assertEquals(threadId, seedTransport.threadPool.getThreadContext().getHeader("threadId"));
        ) {
}
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // that connect fails, so we can assert (a) it targeted the requested node and (b) the failure is
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes) {
/*
                            @Override
import org.opensearch.action.search.SearchRequest;
                    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
                        }
                    RemoteClusterAwareClient client = new RemoteClusterAwareClient(
            }
                    builder.build(),
            }
                    client.sendStreamRequest(
                    assertNotNull(reference.get());
                service.start();
                            assertEquals(knownNodes, Arrays.asList(clusterSearchShardsResponse.getNodes()));
                            new LatchedActionListener<>(
                    );
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
                            public void handleException(TransportException exp) {
                }
            ) {
            public String executor() {
                        service,
            Collections.shuffle(knownNodes, random());
                service.acceptIncomingRequests();
                            CountDownLatch responseLatch = new CountDownLatch(1);
                            final ClusterSearchShardsRequest searchShardsRequest = new ClusterSearchShardsRequest("test-index")
                        )
                return ThreadPool.Names.SAME;
            Collections.shuffle(knownNodes, random());
                    l.onFailure(new RuntimeException("no stream route"));
        }
import org.opensearch.transport.stream.StreamTransportResponse;
                try (
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.TimeUnit;
                    threadPool,
                CountDownLatch failed = new CountDownLatch(1);
            builder.putList("cluster.remote.cluster1.seeds", seedTransport.getLocalDiscoNode().getAddress().toString());
            knownNodes.add(discoverableTransport.getLocalDiscoNode());
            try (
                            assertNotNull(reference.get());
                    verify(streamTransportService).connectToNode(eq(seedNode), any(), any());
import java.util.concurrent.Executors;
                try (RemoteClusterAwareClient client = new RemoteClusterAwareClient(Settings.EMPTY, threadPool, service, "cluster1")) {
            @Override
        // cluster it connects the resolved target node on the StreamTransportService before sending. Here
                MockTransportService service = MockTransportService.createNewService(
 * specific language governing permissions and limitations
    private static StreamTransportResponseHandler<TransportResponse> noopStreamHandler() {
                    builder.build(),
                    ActionListener<Void> l = inv.getArgument(2);
import java.util.Collections;
                            @Override
                        handlerError.get() instanceof ConnectTransportException
    public void testSearchShards() throws Exception {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    }
 * software distributed under the License is distributed on an
                        e.getMessage().contains("stream transport is not enabled")
 *
            builder.putList("cluster.remote.cluster1.seeds", seedTransport.getLocalDiscoNode().getAddress().toString());
            public TransportResponse read(StreamInput in) {
        }
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        streamTransportService
    }
        // wrapped as a ConnectTransportException delivered to the handler (wrapAsTransportException).
                                return null;
                        seedNode,
import static org.mockito.Mockito.doAnswer;
        try (
                            client.admin()
                service.acceptIncomingRequests();
                        () -> client.sendStreamRequest(
                )
                            )
                        .cluster()
            knownNodes.add(discoverableTransport.getLocalDiscoNode());
    }
/*
                            ClusterSearchShardsResponse clusterSearchShardsResponse = reference.get();
                        executorService.submit(() -> {
import org.opensearch.action.LatchedActionListener;
                        new SearchRequest("test-index"),
        // The streaming send path must NOT fall back to the regular transport when the stream transport
                        threadPool,
    }
                return null;
                    ThreadPool.terminate(executorService, 5, TimeUnit.SECONDS);
                ) {
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
                                failed.countDown();
 * Modifications Copyright OpenSearch Contributors. See
                            @Override
                        "connect failure must be wrapped as ConnectTransportException, was: " + handlerError.get(),
                                throw new RuntimeException(e);
                        final String threadId = Integer.toString(i);
                    client.admin()
                    return null;
                    int numThreads = 10;
            try (
import java.util.List;
                }
import java.util.concurrent.CountDownLatch;
            public void handleException(TransportException exp) {}
            @Override
                    for (int i = 0; i < numThreads; i++) {
 * SPDX-License-Identifier: Apache-2.0
                StreamTransportService streamTransportService = mock(StreamTransportService.class);
                            searchShardsRequest,
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
                    ).local(true).preference(request.preference()).routing(request.routing());
                        "cluster1",
            knownNodes.add(seedTransport.getLocalDiscoNode());
                )
            }
                    responseLatch.await();
                    NoopTracer.INSTANCE
                    Version.CURRENT,
                service.start();
            @Override
            builder.putList("cluster.remote.cluster1.seeds", seedNode.getAddress().toString());
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
import static org.mockito.Mockito.when;
            Settings.Builder builder = Settings.builder();
                    );
                    assertTrue(
                            public TransportResponse read(StreamInput in) {
                    )
                                handlerError.set(exp);
 * Unless required by applicable law or agreed to in writing,
            MockTransportService seedTransport = startTransport("seed_node", knownNodes);
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
import org.opensearch.Version;
                    ClusterSearchShardsResponse clusterSearchShardsResponse = reference.get();
        // sendStreamRequest routes through the stream transport: after ensureConnected on the remote
            try (
import org.opensearch.common.unit.TimeValue;
                    assertTrue("handler must be notified of the connect failure", failed.await(5, TimeUnit.SECONDS));
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes)) {
import org.opensearch.common.settings.Settings;
                            ThreadContext threadContext = seedTransport.threadPool.getThreadContext();
                    Version.CURRENT,
                    assertEquals(knownNodes, Arrays.asList(clusterSearchShardsResponse.getNodes()));
    public void testSearchShardsThreadContextHeader() {
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
                        Settings.EMPTY,
                            }
                    ClusterSearchShardsRequest searchShardsRequest = new ClusterSearchShardsRequest("test-index").indicesOptions(
                                    reference.set(resp);
                    );
                        new StreamTransportResponseHandler<>() {
            builder.putList("cluster.remote.cluster1.seeds", seedTransport.getLocalDiscoNode().getAddress().toString());
 */
            ) {
                // 4-arg constructor => streamTransportService is null (stream transport not enabled).
                            AtomicReference<ClusterSearchShardsResponse> reference = new AtomicReference<>();
        super.tearDown();
                            threadContext.putHeader("threadId", threadId);
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes)
                    AtomicReference<ClusterSearchShardsResponse> reference = new AtomicReference<>();
                }
import java.util.concurrent.atomic.AtomicReference;
            public void handleStreamResponse(StreamTransportResponse<TransportResponse> s) {}
                    builder.build(),
                )
import static org.mockito.Mockito.mock;
public class RemoteClusterAwareClientTests extends OpenSearchTestCase {
 * under the License.
                                responseLatch.await();
                                }, e -> fail("no failures expected")), responseLatch));
                            public String executor() {
            Settings.Builder builder = Settings.builder();
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
            Settings.Builder builder = Settings.builder();
                        IllegalStateException.class,
                    NoopTracer.INSTANCE
 * ownership. Elasticsearch licenses this file to you under
    public void testSendStreamRequestConnectsToTargetNodeOnStreamTransport() throws Exception {
 */
                doAnswer(inv -> {
                service.acceptIncomingRequests();
import static org.mockito.ArgumentMatchers.any;
                            @Override
    }
            Settings.Builder builder = Settings.builder();
            ) {
    @Override
                    }
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes)) {
                }).when(streamTransportService).connectToNode(any(DiscoveryNode.class), any(), any());
import static org.mockito.Mockito.verify;
import org.opensearch.test.transport.MockTransportService;
                )
            knownNodes.add(seedTransport.getLocalDiscoNode());
            }
                        "internal:test/stream",
                        "message should explain the stream transport is not enabled, was: " + e.getMessage(),
                    );
                                ActionListener.wrap(reference::set, e -> fail("no failures expected")),
 * this work for additional information regarding copyright
                service.acceptIncomingRequests();
    public void testSendStreamRequestThrowsWhenStreamTransportDisabled() throws Exception {
                try (RemoteClusterAwareClient client = new RemoteClusterAwareClient(Settings.EMPTY, threadPool, service, "cluster1")) {
                    Version.CURRENT,
                    SearchRequest request = new SearchRequest("test-index");
        // is unavailable — enabling streaming is a deliberate opt-in, so a missing stream transport is a
                MockTransportService service = MockTransportService.createNewService(
                    NoopTracer.INSTANCE
                try (RemoteClusterAwareClient client = new RemoteClusterAwareClient(Settings.EMPTY, threadPool, service, "cluster1")) {
 * GitHub history for details.
                    builder.build(),
                                return ThreadPool.Names.SAME;
        // misconfiguration that surfaces as an error (routed to the handler), not a silent pull.
            }
                    threadPool,
            try (
import org.opensearch.threadpool.TestThreadPool;
                service.start();
    public void tearDown() throws Exception {
 */
                }
                        request.indicesOptions()
 * this file be licensed under the Apache-2.0 license or a
                            noopStreamHandler()
