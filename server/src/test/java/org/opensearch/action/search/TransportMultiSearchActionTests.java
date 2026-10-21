                            0,
        assertThat(result, equalTo(1));
        try {
import org.opensearch.common.settings.Settings;
            );
        CountDownLatch canceledLatch = new CountDownLatch(1);
 *
                                + "] is higher than is allowed ["
import java.util.concurrent.TimeUnit;
        Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();
                }
 * SPDX-License-Identifier: Apache-2.0
            @Override
                return "local_node_id";
import org.opensearch.transport.Transport;
                    listener.onResponse(SearchResponse.empty(() -> 1L, SearchResponse.Clusters.EMPTY));
        assertThat(result, equalTo(10 * numDataNodes));
import org.opensearch.tasks.CancellableTask;
                    counter.incrementAndGet();
        } finally {
                    fail("Should not execute search after parent task is cancelled");
                    return localNodeId;
 * this file be licensed under the Apache-2.0 license or a
                fail("Latch should have counted down");
        ) {
    public void testBatchExecute() {
        ActionFilters actionFilters = mock(ActionFilters.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            0L,
            public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {
 * under the License.
                });
        }
            if (!executedLatch.await(10, TimeUnit.SECONDS)) {
import org.opensearch.cluster.service.ClusterService;
                Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            /*
            assertThat(requests.size(), equalTo(numSearchRequests));
        }
                            0L,
 * not use this file except in compliance with the License.
                    counter.decrementAndGet();
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
            MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
            null,
                            SearchResponse.Clusters.EMPTY
            assertThat(response.getResponses().length, equalTo(numSearchRequests));
            public String getLocalNodeId() {
import static org.hamcrest.Matchers.equalTo;
            NoopTracer.INSTANCE
            assertTrue(OpenSearchTestCase.terminate(threadPool));
                null,
            new DiscoveryNode(
            }
            );
            parentTask[0] = (CancellableTask) action.execute(multiSearchRequest, new TaskListener<>() {
            String localNodeId = randomAlphaOfLengthBetween(3, 10);
            assertTrue(OpenSearchTestCase.terminate(threadPool));
            }
             * of requests in a single batch was large
            }
            builder.add(
                                + currentConcurrentSearches
            MultiSearchResponse response = ActionTestUtils.executeBlocking(action, multiSearchRequest);
                            SearchResponse.Clusters.EMPTY
            threadPool,
                    counter.decrementAndGet();
                Collections.singleton(DiscoveryNodeRole.INGEST_ROLE),
        builder.add(
        // and if there are more searches than is allowed create an error and remember that.
            TransportMultiSearchAction action = new TransportMultiSearchAction(
            for (int i = 0; i < numSearchRequests; i++) {
                            0,
                multiSearchRequest.add(new SearchRequest());
        // Initialize dependencies of TransportMultiSearchAction
                    errorHolder.set(
            @Override
            int numSearchRequests = scaledRandomIntBetween(1024, 8192);
        );
                if (parentTask[0] != null && parentTask[0].isCancelled()) {
import org.opensearch.tasks.Task;
                System::nanoTime,
        int result = TransportMultiSearchAction.defaultMaxConcurrentSearches(10, state);
                    break;
            public TaskManager getTaskManager() {
        };
            System::nanoTime,
            }
                        new SearchResponse(
        };
import org.opensearch.cluster.ClusterName;
            for (MultiSearchResponse.Item item : responses[0].getResponses()) {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                Collections.emptyMap(),
            actionFilters,
            null,
            clusterService,
            threadPool,
        ThreadPool threadPool = new ThreadPool(settings);
            }
            Task task = multiSearchRequest.createTask(randomLong(), "type", "action", null, Collections.emptyMap());
                        }
                "ingest",
import java.util.concurrent.CountDownLatch;
            NoopTracer.INSTANCE
        // randomize whether or not requests are executed asynchronously
        int maxAllowedConcurrentSearches = scaledRandomIntBetween(1, 16);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.internal.InternalSearchResponse;
        );
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
                    } catch (InterruptedException e) {
            public String getLocalNodeId() {
            MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
            transportService,
import org.opensearch.action.support.ActionFilters;
        NodeClient client = new NodeClient(settings, threadPool) {
        // Execute the multi search api and fail if we find an error after executing:
        int numDataNodes = randomIntBetween(1, 10);
                    executedLatch.countDown();
        NodeClient client = new NodeClient(settings, threadPool) {
        } finally {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).nodes(builder).build();
            client
        };
        ActionFilters actionFilters = mock(ActionFilters.class);
 * The OpenSearch Contributors require contributions made to
            Collections.emptySet(),
                            fail("Latch should have counted down");
                }
                return taskManager;
            )
            mock(Transport.class),
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
 */
            future.get();
                public String getLocalNodeId() {
/*
            /*
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
                        )
import org.opensearch.tasks.TaskListener;
            AtomicInteger counter = new AtomicInteger(0);
                    );
                            "Current concurrent search ["
public class TransportMultiSearchActionTests extends OpenSearchTestCase {
                        )
            PlainActionFuture<MultiSearchResponse> future = newFuture();
                multiSearchRequest.add(new SearchRequest());
            transportService,
        // Initialize dependencies of TransportMultiSearchAction
            threadPool,
import org.opensearch.core.action.ActionListener;
                            null,
import java.util.List;
                executorService.execute(() -> {
            MultiSearchResponse[] responses = new MultiSearchResponse[1];
import java.util.Set;
                                + maxAllowedConcurrentSearches
            }
                }
            assertTrue(OpenSearchTestCase.terminate(threadPool));
    public void testCancellation() throws InterruptedException {
import org.opensearch.action.support.ActionTestUtils;
                Settings.EMPTY,
                10,
                client
            }
                public void onFailure(Task task, Exception e) {
            ) {
                    return taskManager;
        Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();
        // Keep track of the number of concurrent searches started by multi search api,
        CancellableTask[] parentTask = new CancellableTask[1];
                        new SearchResponse(
        ExecutorService executorService = threadPool.executor(ThreadPool.Names.GENERIC);
 * GitHub history for details.
        int maxAllowedConcurrentSearches = 1; // Allow 1 search at a time.
        }
                    assertEquals(task.getId(), request.getParentTask().getId());
                Collections.emptyMap(),
            }
             * Allow for a large number of search requests in a single batch as previous implementations could stack overflow if the number
                    "_id" + i,
import java.util.concurrent.ExecutorService;
        try {
                    Version.CURRENT
            10,
        when(clusterService.state()).thenReturn(ClusterState.builder(new ClusterName("test")).build());
                "cluster_manager",
        builder.add(
                            0,
                if (currentConcurrentSearches > maxAllowedConcurrentSearches) {
        ClusterService clusterService = mock(ClusterService.class);
                            InternalSearchResponse.empty(),
                buildNewFakeTransportAddress(),
                            ShardSearchFailure.EMPTY_ARRAY,
        Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();
                buildNewFakeTransportAddress(),
 * specific language governing permissions and limitations
            int numSearchRequests = randomIntBetween(1, 100);
            Exception[] exceptions = new Exception[1];
    }
            multiSearchRequest.maxConcurrentSearchRequests(maxAllowedConcurrentSearches);
                            0,
                    assertEquals(localNodeId, request.getParentTask().getNodeId());
                            0,
            multiSearchRequest.maxConcurrentSearchRequests(maxAllowedConcurrentSearches);
        TransportService transportService = new TransportService(
             * Allow for a large number of search requests in a single batch as previous implementations could stack overflow if the number
 */
                            0,
 * Licensed to Elasticsearch under one or more contributor
 * Modifications Copyright OpenSearch Contributors. See
                public void onResponse(Task task, MultiSearchResponse items) {
                NoopTracer.INSTANCE
            10,
            for (int i = 0; i < numSearchRequests; i++) {
                    );
                @Override
import org.opensearch.cluster.ClusterState;
                public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {
 * Unless required by applicable law or agreed to in writing,
                int currentConcurrentSearches = counter.incrementAndGet();
                    listener.onResponse(
        AtomicReference<AssertionError> errorHolder = new AtomicReference<>();
        TransportMultiSearchAction action = new TransportMultiSearchAction(
import static org.hamcrest.Matchers.nullValue;
                    responses[0] = items;
            @Override
        result = TransportMultiSearchAction.defaultMaxConcurrentSearches(10, state);
import static org.mockito.Mockito.mock;
            for (int i = 0; i < numSearchRequests; i++) {
        ActionFilters actionFilters = mock(ActionFilters.class);
            boolean cancelled = false;
                transportService,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                    );
                return "local_node_id";
import org.opensearch.Version;
import org.opensearch.action.support.PlainActionFuture;
        Randomness.shuffle(threadPoolNames);
            MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
import org.opensearch.common.Randomness;
                        throw new RuntimeException(e);
                threadPool,
                new DiscoveryNode(
}
                actionFilters,
                            ShardSearchFailure.EMPTY_ARRAY,
            NodeClient client = new NodeClient(settings, threadPool) {
            mock(Transport.class),
    }
    }
                public TaskManager getTaskManager() {
                Version.CURRENT
import static org.mockito.Mockito.when;
        final ExecutorService rarelyExecutor = threadPool.executor(threadPoolNames.get(1));
        final Set<SearchRequest> requests = Collections.newSetFromMap(Collections.synchronizedMap(new IdentityHashMap<>()));
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
                multiSearchRequest.add(new SearchRequest());
        // Initialize dependencies of TransportMultiSearchAction
            TransportService transportService = new TransportService(
                                + "]"
            new DiscoveryNode(
import java.util.Arrays;
            CountDownLatch executedLatch = new CountDownLatch(1);
            };
        ThreadPool threadPool = new ThreadPool(settings);
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
                        if (!canceledLatch.await(1, TimeUnit.SECONDS)) {
                    try {
import org.opensearch.cluster.node.DiscoveryNode;
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
                if (item.isFailure() && item.getFailure().getMessage().contains("Parent task was cancelled")) {
            Settings.EMPTY,
import org.opensearch.transport.TransportService;
import static org.opensearch.action.support.PlainActionFuture.newFuture;
                        )
 * KIND, either express or implied.  See the License for the
/*
                threadPool,
            }
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                requests.add(request);
 * You may obtain a copy of the License at
                    executedLatch.countDown();
                }
                    Collections.emptyMap(),
import org.opensearch.tasks.TaskManager;
import org.opensearch.cluster.node.DiscoveryNodes;
            }
        AtomicInteger counter = new AtomicInteger();
            )
                            InternalSearchResponse.empty(),
            };
import org.opensearch.action.support.ActionFilter;
    public void testDefaultMaxConcurrentSearches() {
        }
            public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {
                    cancelled = true;
import org.opensearch.transport.client.node.NodeClient;
            when(clusterService.state()).thenReturn(ClusterState.builder(new ClusterName("test")).build());
                @Override
    }
                @Override
            Collections.emptySet(),
                        new AssertionError(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import java.util.concurrent.atomic.AtomicInteger;
        TransportService transportService = new TransportService(
        // and if there are more searches than is allowed create an error and remember that.
                return taskManager;
import org.opensearch.cluster.node.DiscoveryNodeRole;
            ClusterService clusterService = mock(ClusterService.class);
        ThreadPool threadPool = new ThreadPool(settings);
            public TaskManager getTaskManager() {
        try {
             */
        for (int i = 0; i < numDataNodes; i++) {
            System::nanoTime,
                }
            action.execute(task, multiSearchRequest, future);
                }
            assertTrue(cancelled);
 *
        when(clusterService.state()).thenReturn(ClusterState.builder(new ClusterName("test")).build());
 * this work for additional information regarding copyright
            assertThat(errorHolder.get(), nullValue());
                    Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
 * compatible open source license.
import java.util.IdentityHashMap;
                    listener.onResponse(
            @Override
            parentTask[0].cancel("Giving up");
 *
        ClusterService clusterService = mock(ClusterService.class);
                    buildNewFakeTransportAddress(),
                mock(Transport.class),
        // Keep track of the number of concurrent searches started by multi search api,
            int numSearchRequests = scaledRandomIntBetween(1, 8192);
        // Execute the multi search api and fail if we find an error after executing:
            Settings.EMPTY,
                }
        };
        );
            }
    public void testParentTaskId() throws Exception {
package org.opensearch.action.search;
/*
 * the Apache License, Version 2.0 (the "License"); you may
        final ExecutorService commonExecutor = threadPool.executor(threadPoolNames.get(0));
        } finally {
                )
                clusterService,
                boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
import org.opensearch.threadpool.ThreadPool;
            actionFilters,
 */
                    exceptions[0] = e;
             * of requests in a single batch was large
            canceledLatch.countDown();
        ) {
            threadPool,
                    }
                final ExecutorService executorService = rarely() ? rarelyExecutor : commonExecutor;
                Collections.emptySet(),
        final List<String> threadPoolNames = Arrays.asList(ThreadPool.Names.GENERIC, ThreadPool.Names.SAME);
            clusterService,
            @Override
import org.opensearch.common.UUIDs;
 * ownership. Elasticsearch licenses this file to you under
 * software distributed under the License is distributed on an
                @Override
                Version.CURRENT
            client
import org.opensearch.test.OpenSearchTestCase;
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
                @Override
            assertEquals(numSearchRequests, counter.get());
        state = ClusterState.builder(new ClusterName("_name")).build();
                            null,
            @Override
             */
        TransportMultiSearchAction action = new TransportMultiSearchAction(
        AtomicInteger counter = new AtomicInteger();
                executorService.execute(() -> {
                }
            });
                });
