import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
import static org.mockito.Mockito.doAnswer;
                            }
                    int numThreads = 10;  
                    )
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes)) {
                StreamTransportService streamTransportService = mock(StreamTransportService.class);
        // sendStreamRequest routes through the stream transport: after ensureConnected on the remote
import java.util.Arrays;
                        handlerError.get() instanceof ConnectTransportException  
                                return ThreadPool.Names.SAME;
                try (RemoteClusterAwareClient client = new RemoteClusterAwareClient(Settings.EMPTY, threadPool, service, "cluster1")) {
    public void testSearchShardsThreadContextHeader() {  
                                .cluster()  
                                    reference.set(resp);
/*  
                        streamTransportService  
        ) {
                }  
                    NoopTracer.INSTANCE
            @Override  
                    IllegalStateException e = expectThrows(  
            ) {  
                    for (int i = 0; i < numThreads; i++) {
            ) {  
 */  
            knownNodes.add(seedTransport.getLocalDiscoNode());  
 * SPDX-License-Identifier: Apache-2.0
                            ThreadContext threadContext = seedTransport.threadPool.getThreadContext();
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
                                .routing(request.routing());  
                    ).local(true).preference(request.preference()).routing(request.routing());
                            } catch (InterruptedException e) {
                    verify(streamTransportService).connectToNode(eq(seedNode), any(), any());  
import org.opensearch.action.LatchedActionListener;
    }
                            public TransportResponse read(StreamInput in) {
                                throw new RuntimeException(e);
        }  
                        () -> client.sendStreamRequest(
                    assertEquals(knownNodes, Arrays.asList(clusterSearchShardsResponse.getNodes()));
            }  
        ) {
                CountDownLatch failed = new CountDownLatch(1);
                            AtomicReference<ClusterSearchShardsResponse> reference = new AtomicReference<>();
                    threadPool,  
                service.start();
                        new SearchRequest("test-index"),
                    ThreadPool.terminate(executorService, 5, TimeUnit.SECONDS);  
import java.util.Collections;  
            }
import java.util.concurrent.ExecutorService;
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;  
 * not use this file except in compliance with the License.
                    l.onFailure(new RuntimeException("no stream route"));  
            public void handleException(TransportException exp) {}
                    client.admin()
                }
        // misconfiguration that surfaces as an error (routed to the handler), not a silent pull.
 * under the License.  
                try (RemoteClusterAwareClient client = new RemoteClusterAwareClient(Settings.EMPTY, threadPool, service, "cluster1")) {
                                .indicesOptions(request.indicesOptions())  
                        "internal:test/stream",
            knownNodes.add(discoverableTransport.getLocalDiscoNode());
                            noopStreamHandler()  
                        "cluster1",
                service.acceptIncomingRequests();
            builder.putList("cluster.remote.cluster1.seeds", seedTransport.getLocalDiscoNode().getAddress().toString());
        try (
                            )  
                            @Override
                        threadPool,  
                                return null;  
                when(streamTransportService.getStreamTransportReqTimeout()).thenReturn(TimeValue.timeValueSeconds(30));
            @Override  
            @Override
                        }
                    SearchRequest request = new SearchRequest("test-index");
                                .local(true)
                }
                MockTransportService service = MockTransportService.createNewService(  
                                responseLatch.await();  
                    Version.CURRENT,
                doAnswer(inv -> {
            Collections.shuffle(knownNodes, random());
 */  
import org.opensearch.core.common.io.stream.StreamInput;
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes)) {  
            }  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
            Settings.Builder builder = Settings.builder();  
import org.opensearch.core.action.ActionListener;
                            new SearchRequest("test-index"),
 * Licensed to Elasticsearch under one or more contributor  
            try (
                        e.getMessage().contains("stream transport is not enabled")
            }
            try (
                    );
            public void handleStreamResponse(StreamTransportResponse<TransportResponse> s) {}
                        );
        // wrapped as a ConnectTransportException delivered to the handler (wrapAsTransportException).
 * specific language governing permissions and limitations
    private static StreamTransportResponseHandler<TransportResponse> noopStreamHandler() {
                    ClusterSearchShardsRequest searchShardsRequest = new ClusterSearchShardsRequest("test-index").indicesOptions(
                        executorService.submit(() -> {
                            "internal:test/stream",  
import java.util.concurrent.atomic.AtomicReference;
            try (
                        )
            knownNodes.add(discoverableTransport.getLocalDiscoNode());
                try (  
        }  
                    AtomicReference<ClusterSearchShardsResponse> reference = new AtomicReference<>();
            Settings.Builder builder = Settings.builder();  
import org.opensearch.common.util.concurrent.ThreadContext;  
                try (RemoteClusterAwareClient client = new RemoteClusterAwareClient(Settings.EMPTY, threadPool, service, "cluster1")) {
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes)
            builder.putList("cluster.remote.cluster1.seeds", seedTransport.getLocalDiscoNode().getAddress().toString());
 */
            Settings.Builder builder = Settings.builder();  
/*  
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
        }
                            CountDownLatch responseLatch = new CountDownLatch(1);
import static org.mockito.ArgumentMatchers.any;  
                    );  
                                handlerError.set(exp);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    Version.CURRENT,
import org.opensearch.Version;
                }
                )
                        "connect failure must be wrapped as ConnectTransportException, was: " + handlerError.get(),
 * software distributed under the License is distributed on an
                            @Override
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes)
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
                return ThreadPool.Names.SAME;
            knownNodes.add(seedTransport.getLocalDiscoNode());
                    builder.build(),
            }
                        });
    }
import org.opensearch.cluster.node.DiscoveryNode;  
            public TransportResponse read(StreamInput in) {  
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes) {
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        // that connect fails, so we can assert (a) it targeted the requested node and (b) the failure is  
                service.acceptIncomingRequests();
                service.start();
            try (
}
            public String executor() {
        // is unavailable — enabling streaming is a deliberate opt-in, so a missing stream transport is a
            }
                        .searchShards(
                    NoopTracer.INSTANCE
import java.util.concurrent.CopyOnWriteArrayList;
                AtomicReference<TransportException> handlerError = new AtomicReference<>();
                                failed.countDown();
                service.start();
import org.opensearch.common.settings.Settings;
 *  
                            }  
                        IllegalStateException.class,
 * GitHub history for details.
                    assertTrue(  
                        seedNode,  
            Collections.shuffle(knownNodes, random());
                            }
                // 4-arg constructor => streamTransportService is null (stream transport not enabled).
                MockTransportService service = MockTransportService.createNewService(  
import java.util.concurrent.CountDownLatch;  
                            client.admin()
        try (
                    responseLatch.await();
                                ActionListener.wrap(reference::set, e -> fail("no failures expected")),
                )
                                responseLatch
    public void tearDown() throws Exception {  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import org.opensearch.transport.stream.StreamTransportResponse;  
                    }
                    builder.build(),
    @Override
                service.acceptIncomingRequests();
import org.opensearch.test.transport.MockTransportService;  
    }
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.ArgumentMatchers.eq;
            @Override  
            Settings.Builder builder = Settings.builder();  
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
 * this work for additional information regarding copyright
                    builder.build(),
                        .cluster()  
                service.start();
import static org.mockito.Mockito.when;
    }
                        new StreamTransportResponseHandler<>() {
import java.util.List;
        // cluster it connects the resolved target node on the StreamTransportService before sending. Here
                            assertNotNull(reference.get());
                        Settings.EMPTY,
 * You may obtain a copy of the License at  
                    );
 * license agreements. See the NOTICE file distributed with
                            public String executor() {  
                )
                    NoopTracer.INSTANCE
                MockTransportService service = MockTransportService.createNewService(  
                            final ClusterSearchShardsRequest searchShardsRequest = new ClusterSearchShardsRequest("test-index")
                            public void handleStreamResponse(StreamTransportResponse<TransportResponse> s) {}  
                                .searchShards(searchShardsRequest, new LatchedActionListener<>(ActionListener.wrap(resp -> {
/*
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    threadPool,  
                    CountDownLatch responseLatch = new CountDownLatch(1);  
                    Version.CURRENT,
 * The OpenSearch Contributors require contributions made to  
                    assertNotNull(reference.get());  
                    NoopTracer.INSTANCE
            knownNodes.add(seedNode);
        }
                            try {
    }  
                                .preference(request.preference())
                service.acceptIncomingRequests();
 * ownership. Elasticsearch licenses this file to you under  
                            new LatchedActionListener<>(  
                    ClusterSearchShardsResponse clusterSearchShardsResponse = reference.get();
    }  
                    threadPool,  
                    threadPool,  
                            }  
                            searchShardsRequest,
                // connectToNode (non-final, stream-transport-specific) fails synchronously.  
                            @Override
 * the Apache License, Version 2.0 (the "License"); you may
                    RemoteClusterAwareClient client = new RemoteClusterAwareClient(
import org.opensearch.threadpool.ThreadPool;
                    );  
        return RemoteClusterConnectionTests.startTransport(id, knownNodes, Version.CURRENT, threadPool);  
                                }, e -> fail("no failures expected")), responseLatch));
                }).when(streamTransportService).connectToNode(any(DiscoveryNode.class), any(), any());
                    assertTrue("handler must be notified of the connect failure", failed.await(5, TimeUnit.SECONDS));
                    SearchRequest request = new SearchRequest("test-index");
import java.util.concurrent.Executors;
                        "message should explain the stream transport is not enabled, was: " + e.getMessage(),
    public void testSendStreamRequestConnectsToTargetNodeOnStreamTransport() throws Exception {  
import static org.mockito.Mockito.mock;  
                        service,
                    Version.CURRENT,
                    return null;
                                    assertEquals(threadId, seedTransport.threadPool.getThreadContext().getHeader("threadId"));  
 *
import org.opensearch.threadpool.TestThreadPool;
import static org.mockito.Mockito.verify;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.transport.TransportResponse;  
                    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
 * Unless required by applicable law or agreed to in writing,
                        final String threadId = Integer.toString(i);  
        };  
import java.util.concurrent.TimeUnit;  
                            ClusterSearchShardsResponse clusterSearchShardsResponse = reference.get();
public class RemoteClusterAwareClientTests extends OpenSearchTestCase {
 *
package org.opensearch.transport;
                        request.indicesOptions()  
                ) {
                            public void handleException(TransportException exp) {  
                    ActionListener<Void> l = inv.getArgument(2);
            ) {  
                    builder.build(),
            MockTransportService seedTransport = startTransport("seed_node", knownNodes);  
                MockTransportService service = MockTransportService.createNewService(  
            builder.putList("cluster.remote.cluster1.seeds", seedTransport.getLocalDiscoNode().getAddress().toString());
    public void testSearchShards() throws Exception {  
                    client.sendStreamRequest(  
                            seedTransport.getLocalDiscoNode(),
        return new StreamTransportResponseHandler<>() {
            MockTransportService seedTransport = startTransport("seed_node", knownNodes);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super.tearDown();
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                            @Override
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    }
                return null;
    public void testSendStreamRequestThrowsWhenStreamTransportDisabled() throws Exception {
                    assertTrue(
            knownNodes.add(seedTransport.getLocalDiscoNode());  
import org.opensearch.action.search.SearchRequest;
                            assertEquals(knownNodes, Arrays.asList(clusterSearchShardsResponse.getNodes()));  
            builder.putList("cluster.remote.cluster1.seeds", seedNode.getAddress().toString());
        // The streaming send path must NOT fall back to the regular transport when the stream transport  
            ) {  
                            threadContext.putHeader("threadId", threadId);  
                )
