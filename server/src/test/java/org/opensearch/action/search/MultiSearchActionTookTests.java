 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testTookWithRealClock() throws Exception {
            null,
 * GitHub history for details.
                void executeSearch(
                        TimeUnit.MILLISECONDS.convert(expected.get(), TimeUnit.NANOSECONDS),
    }
    public void setUp() throws Exception {
            return request.indices();
 * this work for additional information regarding copyright
        };
import org.junit.AfterClass;
            NoopTracer.INSTANCE
        };
            }
/*
                        equalTo(multiSearchResponse.getTook().getMillis())
                    final AtomicInteger responseCounter,
            null,
import org.opensearch.test.OpenSearchTestCase;
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest().add(new SearchRequest());
import org.junit.After;
    @AfterClass
        super.setUp();
    static class Resolver extends IndexNameExpressionResolver {
            @Override
                transportService,
import org.opensearch.transport.TransportService;
                    assertThat(
 * Modifications Copyright OpenSearch Contributors. See
        TransportService transportService = new TransportService(
import org.opensearch.search.internal.InternalSearchResponse;
            @Override
 * ownership. Elasticsearch licenses this file to you under
        runTestTook(true);
import org.opensearch.cluster.node.DiscoveryNode;
 * Unless required by applicable law or agreed to in writing,
                if (controlledClock) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * specific language governing permissions and limitations
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
    // test using System#nanoTime
            Collections.emptySet(),
                }
            ) {
                            0,
 * this file be licensed under the Apache-2.0 license or a
                clusterService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public String getLocalNodeId() {
        final ExecutorService commonExecutor = threadPool.executor(threadPoolNames.get(0));
        final List<String> threadPoolNames = Arrays.asList(ThreadPool.Names.GENERIC, ThreadPool.Names.SAME);
import java.util.Collections;
                        new SearchResponse(
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.ClusterState;
                clusterService,
                    long elapsed = spinForAtLeastNMilliseconds(randomIntBetween(0, 10));
 * MultiSearch took time tests
            @Override
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                @Override
        if (controlledClock) {
            };
                    counter.decrementAndGet();
    }
        Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();
 */
                    final AtomicArray<MultiSearchResponse.Item> responses,
                    long startTimeInNanos
        super.tearDown();
 * You may obtain a copy of the License at
                            SearchResponse.Clusters.EMPTY
import org.junit.BeforeClass;
                }
            @Override
                            0,
import org.opensearch.tasks.TaskManager;
 * not use this file except in compliance with the License.
                    final ActionListener<MultiSearchResponse> listener,
import static org.mockito.Mockito.mock;
    // test unit conversion using a controller clock
    public static void beforeClass() {}
import static org.mockito.Mockito.when;
        AtomicInteger counter = new AtomicInteger();
                } else {
                }
                expected::get,
                availableProcessors,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        }
import java.util.List;
                    super.executeSearch(requests, responses, responseCounter, listener, startTimeInNanos);
    }
import java.util.IdentityHashMap;
                availableProcessors,
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.concurrent.ExecutorService;
import org.opensearch.core.action.ActionListener;
        runTestTook(false);
                throw new RuntimeException(e);
    }
 * license agreements. See the NOTICE file distributed with
                actionFilters,
                    expected.set(elapsed);
import java.util.concurrent.atomic.AtomicLong;
import org.opensearch.common.settings.Settings;
 * software distributed under the License is distributed on an
        ClusterService clusterService = mock(ClusterService.class);
 */
                System::nanoTime,
    }
                    );
            }
            ) {
                    final ActionListener<MultiSearchResponse> listener,
import org.opensearch.cluster.service.ClusterService;
                client
    }
import java.util.Set;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        clusterService = createClusterService(threadPool);
 *
                            0L,
import java.util.Queue;
        AtomicLong expected = new AtomicLong();
                    );
import java.util.concurrent.TimeUnit;
        Randomness.shuffle(threadPoolNames);
                client
                return "local_node_id";
 */
import org.opensearch.transport.client.node.NodeClient;
                    listener.onResponse(
                    final AtomicArray<MultiSearchResponse.Item> responses,
            Settings.EMPTY,
        });
                    final Queue<SearchRequestSlot> requests,
                return taskManager;
import org.opensearch.threadpool.TestThreadPool;
                threadPool,
                ) {
 * compatible open source license.
        Resolver() {
public class MultiSearchActionTookTests extends OpenSearchTestCase {
                        greaterThanOrEqualTo(TimeUnit.MILLISECONDS.convert(expected.get(), TimeUnit.NANOSECONDS))
            public void onResponse(MultiSearchResponse multiSearchResponse) {
        ActionFilters actionFilters = new ActionFilters(new HashSet<>());
        }
        threadPool = new TestThreadPool("MultiSearchActionTookTests");
                @Override
                            null,
/*
                    expected.set(1000000);
            mock(Transport.class),
    private void runTestTook(boolean controlledClock) throws Exception {
    @After
                            InternalSearchResponse.empty(),
 * the Apache License, Version 2.0 (the "License"); you may
                        )
        ) {
 * Licensed to Elasticsearch under one or more contributor
    public static void afterClass() {}
/**
                actionFilters,
import java.util.Arrays;
                threadPool,
                    assertThat(
        when(clusterService.state()).thenReturn(ClusterState.builder(new ClusterName("test")).build());
                requests.add(request);
 * The OpenSearch Contributors require contributions made to
 *
 *
import org.opensearch.action.support.ActionFilters;
        action.doExecute(mock(Task.class), multiSearchRequest, new ActionListener<MultiSearchResponse>() {
    public void testTookWithControlledClock() throws Exception {
    @Before
                });
/*
            }
    private ThreadPool threadPool;
import org.opensearch.common.Randomness;
 */
            public void onFailure(Exception e) {
            };
                            0,
            return new TransportMultiSearchAction(
                    long startTimeInNanos
        @Override
import java.util.concurrent.atomic.AtomicInteger;
            public TaskManager getTaskManager() {
        clusterService.close();
    private TransportMultiSearchAction createTransportMultiSearchAction(boolean controlledClock, AtomicLong expected) {
            public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {
                commonExecutor.execute(() -> {
 * SPDX-License-Identifier: Apache-2.0
        final Set<SearchRequest> requests = Collections.newSetFromMap(Collections.synchronizedMap(new IdentityHashMap<>()));
        TransportMultiSearchAction action = createTransportMultiSearchAction(controlledClock, expected);
import org.opensearch.cluster.ClusterName;
import java.util.HashSet;
import org.opensearch.transport.Transport;
package org.opensearch.action.search;
}
            @Override
                transportService,
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        NodeClient client = new NodeClient(settings, threadPool) {
                void executeSearch(
            super(new ThreadContext(Settings.EMPTY));
            }
 * KIND, either express or implied.  See the License for the
        }
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
                    final AtomicInteger responseCounter,
import org.opensearch.common.util.concurrent.AtomicArray;
                            ShardSearchFailure.EMPTY_ARRAY,
    private ClusterService clusterService;
            return new TransportMultiSearchAction(
import org.opensearch.common.UUIDs;
        } else {
                        multiSearchResponse.getTook().getMillis(),
            }
    }
                    );
 * under the License.
                    final Queue<SearchRequestSlot> requests,
import org.junit.Before;
import org.opensearch.threadpool.ThreadPool;
                ) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.tasks.Task;
    @BeforeClass
import org.opensearch.action.IndicesRequest;
                    super.executeSearch(requests, responses, responseCounter, listener, startTimeInNanos);
    public void tearDown() throws Exception {
