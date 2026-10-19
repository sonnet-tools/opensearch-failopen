                    Collections.emptyMap(),  
                clusterService,
            Settings.EMPTY,
            null,
                        )
            new DiscoveryNode(
 * the Apache License, Version 2.0 (the "License"); you may
                fail("Latch should have counted down");  
            10,
                    return localNodeId;
 * You may obtain a copy of the License at  
                    );  
            }  
            @Override
import java.util.IdentityHashMap;  
        } finally {  
                            0,  
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
            public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {
            }  
                }
        ThreadPool threadPool = new ThreadPool(settings);
 * this file be licensed under the Apache-2.0 license or a
                    fail("Should not execute search after parent task is cancelled");  
                transportService,
             * Allow for a large number of search requests in a single batch as previous implementations could stack overflow if the number  
        };  
            int numSearchRequests = scaledRandomIntBetween(1, 8192);  
                public TaskManager getTaskManager() {
                });
        ActionFilters actionFilters = mock(ActionFilters.class);
        Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();
import static org.hamcrest.Matchers.nullValue;
            actionFilters,
                @Override
    }
 * specific language governing permissions and limitations
        ClusterService clusterService = mock(ClusterService.class);
                    executedLatch.countDown();
        try {
import java.util.concurrent.TimeUnit;
            public TaskManager getTaskManager() {
                            ShardSearchFailure.EMPTY_ARRAY,
import static org.mockito.Mockito.when;
        int result = TransportMultiSearchAction.defaultMaxConcurrentSearches(10, state);
            builder.add(
                if (currentConcurrentSearches > maxAllowedConcurrentSearches) {  
    public void testBatchExecute() {
            @Override  
        Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();  
import static org.hamcrest.Matchers.equalTo;
        ActionFilters actionFilters = mock(ActionFilters.class);
        // Initialize dependencies of TransportMultiSearchAction  
            NoopTracer.INSTANCE  
            action.execute(task, multiSearchRequest, future);  
            mock(Transport.class),
            ) {  
            clusterService,
 * this work for additional information regarding copyright
                    Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
import org.opensearch.action.support.ActionFilters;  
            /*
            PlainActionFuture<MultiSearchResponse> future = newFuture();
                    );
        };
                    return taskManager;  
                executorService.execute(() -> {  
import org.opensearch.core.action.ActionListener;  
 * Licensed to Elasticsearch under one or more contributor  
                if (item.isFailure() && item.getFailure().getMessage().contains("Parent task was cancelled")) {
            assertThat(requests.size(), equalTo(numSearchRequests));  
import org.opensearch.cluster.ClusterName;  
        TransportService transportService = new TransportService(
        AtomicReference<AssertionError> errorHolder = new AtomicReference<>();  
            }
        // Initialize dependencies of TransportMultiSearchAction  
        int maxAllowedConcurrentSearches = scaledRandomIntBetween(1, 16);
                Version.CURRENT  
                null,  
                client
                    listener.onResponse(SearchResponse.empty(() -> 1L, SearchResponse.Clusters.EMPTY));
        for (int i = 0; i < numDataNodes; i++) {
        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            public TaskManager getTaskManager() {  
                    Version.CURRENT
                    );
                public String getLocalNodeId() {  
            assertThat(response.getResponses().length, equalTo(numSearchRequests));
        final ExecutorService commonExecutor = threadPool.executor(threadPoolNames.get(0));
                    assertEquals(localNodeId, request.getParentTask().getNodeId());  
                            SearchResponse.Clusters.EMPTY
import org.opensearch.transport.Transport;  
    public void testParentTaskId() throws Exception {
                return taskManager;
        // randomize whether or not requests are executed asynchronously
import org.opensearch.cluster.service.ClusterService;
            threadPool,  
package org.opensearch.action.search;
                @Override
        };
        ExecutorService executorService = threadPool.executor(ThreadPool.Names.GENERIC);
             */
        // Execute the multi search api and fail if we find an error after executing:  
                    counter.incrementAndGet();
                "ingest",
                            ShardSearchFailure.EMPTY_ARRAY,
        builder.add(  
 * software distributed under the License is distributed on an
                }
        ActionFilters actionFilters = mock(ActionFilters.class);
                int currentConcurrentSearches = counter.incrementAndGet();
                return "local_node_id";
        }
        result = TransportMultiSearchAction.defaultMaxConcurrentSearches(10, state);  
 * ownership. Elasticsearch licenses this file to you under  
        TransportService transportService = new TransportService(
        };  
        ThreadPool threadPool = new ThreadPool(settings);  
                        if (!canceledLatch.await(1, TimeUnit.SECONDS)) {
            }
                if (parentTask[0] != null && parentTask[0].isCancelled()) {
                    exceptions[0] = e;
        builder.add(  
 */
        // Execute the multi search api and fail if we find an error after executing:
                @Override  
                Version.CURRENT  
                actionFilters,  
                Collections.emptyMap(),
        ThreadPool threadPool = new ThreadPool(settings);
import java.util.List;
                "cluster_manager",
             */  
            );  
    public void testDefaultMaxConcurrentSearches() {
            multiSearchRequest.maxConcurrentSearchRequests(maxAllowedConcurrentSearches);  
                System::nanoTime,
            assertEquals(numSearchRequests, counter.get());
            future.get();
 * Modifications Copyright OpenSearch Contributors. See
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
 * not use this file except in compliance with the License.
                            0L,  
                            SearchResponse.Clusters.EMPTY  
                    buildNewFakeTransportAddress(),
                            null,
import static org.mockito.Mockito.mock;  
                        new SearchResponse(
            TransportService transportService = new TransportService(  
import org.opensearch.Version;
import org.opensearch.transport.client.node.NodeClient;
            System::nanoTime,
                            null,  
import java.util.concurrent.atomic.AtomicReference;
                    assertEquals(task.getId(), request.getParentTask().getId());
        TransportMultiSearchAction action = new TransportMultiSearchAction(  
            }  
            int numSearchRequests = scaledRandomIntBetween(1024, 8192);
        final List<String> threadPoolNames = Arrays.asList(ThreadPool.Names.GENERIC, ThreadPool.Names.SAME);
            }
import org.opensearch.action.support.ActionTestUtils;
 * Unless required by applicable law or agreed to in writing,
            assertTrue(cancelled);
            String localNodeId = randomAlphaOfLengthBetween(3, 10);  
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
            @Override  
 *
                buildNewFakeTransportAddress(),  
            10,
            MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        int numDataNodes = randomIntBetween(1, 10);
            clusterService,  
        // and if there are more searches than is allowed create an error and remember that.  
                    } catch (InterruptedException e) {
        AtomicInteger counter = new AtomicInteger();
    public void testCancellation() throws InterruptedException {
import org.opensearch.tasks.TaskManager;
/*  
                });  
    }
            multiSearchRequest.maxConcurrentSearchRequests(maxAllowedConcurrentSearches);
            null,
                public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {
        Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();
                        new AssertionError(
import org.opensearch.cluster.node.DiscoveryNodes;
                            0,
                            0,
                            InternalSearchResponse.empty(),
            Exception[] exceptions = new Exception[1];
import org.opensearch.transport.TransportService;
import org.opensearch.action.support.ActionFilter;
                final ExecutorService executorService = rarely() ? rarelyExecutor : commonExecutor;
             * of requests in a single batch was large
            boolean cancelled = false;  
                    counter.decrementAndGet();
/*  
                requests.add(request);
            assertTrue(OpenSearchTestCase.terminate(threadPool));  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                public void onResponse(Task task, MultiSearchResponse items) {  
            for (int i = 0; i < numSearchRequests; i++) {  
        ) {
import java.util.concurrent.ExecutorService;
                        }
        // Initialize dependencies of TransportMultiSearchAction
        when(clusterService.state()).thenReturn(ClusterState.builder(new ClusterName("test")).build());  
            MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        Randomness.shuffle(threadPoolNames);  
                @Override
            client
import java.util.concurrent.CountDownLatch;  
            @Override
                    try {
            transportService,  
        ClusterService clusterService = mock(ClusterService.class);
                new DiscoveryNode(  
                Settings.EMPTY,
            threadPool,
 * compatible open source license.
             * of requests in a single batch was large
                threadPool,  
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();  
                multiSearchRequest.add(new SearchRequest());
        // Keep track of the number of concurrent searches started by multi search api,
            TransportMultiSearchAction action = new TransportMultiSearchAction(
        } finally {
                    counter.decrementAndGet();
                                + "]"
        ClusterState state = ClusterState.builder(new ClusterName("_name")).nodes(builder).build();
            for (int i = 0; i < numSearchRequests; i++) {
            int numSearchRequests = randomIntBetween(1, 100);
import org.opensearch.cluster.ClusterState;
            client  
import org.opensearch.common.UUIDs;
            public String getLocalNodeId() {  
            actionFilters,
                    "_id" + i,
                }
            }
            System::nanoTime,  
                @Override
                return "local_node_id";
import java.util.Set;
        final ExecutorService rarelyExecutor = threadPool.executor(threadPoolNames.get(1));
                executorService.execute(() -> {  
                    cancelled = true;  
            ClusterService clusterService = mock(ClusterService.class);  
                return taskManager;
        ) {
                )  
                        )
            assertTrue(OpenSearchTestCase.terminate(threadPool));  
                    executedLatch.countDown();
        try {
            AtomicInteger counter = new AtomicInteger(0);  
                            "Current concurrent search ["  
                            0L,
            for (MultiSearchResponse.Item item : responses[0].getResponses()) {
            for (int i = 0; i < numSearchRequests; i++) {  
import org.opensearch.test.OpenSearchTestCase;
        );
            /*  
            NodeClient client = new NodeClient(settings, threadPool) {
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.tasks.Task;  
            MultiSearchResponse response = ActionTestUtils.executeBlocking(action, multiSearchRequest);
                        )  
            threadPool,
            MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        );
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);  
        assertThat(result, equalTo(1));
            Collections.emptySet(),  
                    responses[0] = items;
import org.opensearch.cluster.node.DiscoveryNode;
                }  
        TransportMultiSearchAction action = new TransportMultiSearchAction(
                    listener.onResponse(  
public class TransportMultiSearchActionTests extends OpenSearchTestCase {  
import org.opensearch.tasks.CancellableTask;
        CountDownLatch canceledLatch = new CountDownLatch(1);  
                                + currentConcurrentSearches
                    listener.onResponse(
            }
            );
import org.opensearch.action.support.PlainActionFuture;
import java.util.Collections;
        }
        // and if there are more searches than is allowed create an error and remember that.
        // Keep track of the number of concurrent searches started by multi search api,
                                + maxAllowedConcurrentSearches  
                }
            Collections.emptySet(),
                public void onFailure(Task task, Exception e) {  
            Task task = multiSearchRequest.createTask(randomLong(), "type", "action", null, Collections.emptyMap());
                        throw new RuntimeException(e);  
    }
import java.util.concurrent.atomic.AtomicInteger;  
                    }
                threadPool,
                multiSearchRequest.add(new SearchRequest());
import org.opensearch.common.settings.Settings;
        AtomicInteger counter = new AtomicInteger();
        } finally {
            if (!executedLatch.await(10, TimeUnit.SECONDS)) {
 *
            )
        when(clusterService.state()).thenReturn(ClusterState.builder(new ClusterName("test")).build());
                Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                buildNewFakeTransportAddress(),  
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);  
import org.opensearch.common.Randomness;  
                mock(Transport.class),
                                + "] is higher than is allowed ["
            }  
            }  
                multiSearchRequest.add(new SearchRequest());
            public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {  
            transportService,
            canceledLatch.countDown();  
            public String getLocalNodeId() {
        CancellableTask[] parentTask = new CancellableTask[1];
/*
        assertThat(result, equalTo(10 * numDataNodes));  
                    break;
                            InternalSearchResponse.empty(),
            MultiSearchResponse[] responses = new MultiSearchResponse[1];
 * KIND, either express or implied.  See the License for the
                NoopTracer.INSTANCE
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
            NoopTracer.INSTANCE
            });
            when(clusterService.state()).thenReturn(ClusterState.builder(new ClusterName("test")).build());
            parentTask[0].cancel("Giving up");
                Collections.emptySet(),
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
            @Override  
            Settings.EMPTY,  
                            fail("Latch should have counted down");  
                }  
        );
import org.opensearch.threadpool.ThreadPool;
 *    http://www.apache.org/licenses/LICENSE-2.0
            threadPool,
                }  
                }
import org.opensearch.search.internal.InternalSearchResponse;
        NodeClient client = new NodeClient(settings, threadPool) {
                            0,  
                            0,
            @Override
            }
import java.util.Arrays;
            parentTask[0] = (CancellableTask) action.execute(multiSearchRequest, new TaskListener<>() {
                    errorHolder.set(
                        new SearchResponse(  
        final Set<SearchRequest> requests = Collections.newSetFromMap(Collections.synchronizedMap(new IdentityHashMap<>()));  
            mock(Transport.class),  
 */  
            };
        state = ClusterState.builder(new ClusterName("_name")).build();
        int maxAllowedConcurrentSearches = 1; // Allow 1 search at a time.  
import org.opensearch.tasks.TaskListener;
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),  
                boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
        NodeClient client = new NodeClient(settings, threadPool) {
                            0,
             * Allow for a large number of search requests in a single batch as previous implementations could stack overflow if the number
            CountDownLatch executedLatch = new CountDownLatch(1);  
                10,  
 *  
            };  
}  
            )
                Collections.emptyMap(),
        );
 * under the License.  
        }
            assertThat(errorHolder.get(), nullValue());
import static org.opensearch.action.support.PlainActionFuture.newFuture;  
            assertTrue(OpenSearchTestCase.terminate(threadPool));
 */  
 * The OpenSearch Contributors require contributions made to  
    }  
            new DiscoveryNode(
                Collections.singleton(DiscoveryNodeRole.INGEST_ROLE),
