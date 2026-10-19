            public TaskManager getTaskManager() {
import static org.hamcrest.CoreMatchers.equalTo;  
            null,
            return new TransportMultiSearchAction(  
import org.opensearch.action.IndicesRequest;
                            SearchResponse.Clusters.EMPTY
                actionFilters,
package org.opensearch.action.search;
 * compatible open source license.
        }  
            null,
    @BeforeClass
        if (controlledClock) {
            ) {
            public String getLocalNodeId() {
                client
 * software distributed under the License is distributed on an
                    assertThat(
            };
                threadPool,
                        TimeUnit.MILLISECONDS.convert(expected.get(), TimeUnit.NANOSECONDS),  
                clusterService,
    public static void afterClass() {}
    }
        super.setUp();  
import org.opensearch.search.internal.InternalSearchResponse;
import java.util.concurrent.ExecutorService;  
 * ownership. Elasticsearch licenses this file to you under  
                            0L,
                    long startTimeInNanos
import org.opensearch.action.support.ActionFilters;
    private void runTestTook(boolean controlledClock) throws Exception {
            mock(Transport.class),
                void executeSearch(
    }
import org.opensearch.threadpool.ThreadPool;
        } else {
                } else {  
                @Override  
import org.opensearch.common.Randomness;
                }
 * specific language governing permissions and limitations
                            0,
        NodeClient client = new NodeClient(settings, threadPool) {
    }
                    final AtomicInteger responseCounter,  
        final List<String> threadPoolNames = Arrays.asList(ThreadPool.Names.GENERIC, ThreadPool.Names.SAME);
import org.opensearch.cluster.node.DiscoveryNode;  
                threadPool,  
import org.junit.After;  
    @Before
        };
public class MultiSearchActionTookTests extends OpenSearchTestCase {
import static org.mockito.Mockito.mock;
            @Override
                ) {  
                        new SearchResponse(
                    long elapsed = spinForAtLeastNMilliseconds(randomIntBetween(0, 10));
                    final Queue<SearchRequestSlot> requests,
            @Override  
            return request.indices();
    @After
            public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {  
                actionFilters,
    static class Resolver extends IndexNameExpressionResolver {
        super.tearDown();  
                    super.executeSearch(requests, responses, responseCounter, listener, startTimeInNanos);
import org.opensearch.core.action.ActionListener;
            public void onFailure(Exception e) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
                    );
 * You may obtain a copy of the License at  
import org.opensearch.transport.Transport;  
    // test using System#nanoTime
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.tasks.TaskManager;
                System::nanoTime,  
                    super.executeSearch(requests, responses, responseCounter, listener, startTimeInNanos);
    public void setUp() throws Exception {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
                            ShardSearchFailure.EMPTY_ARRAY,  
        ) {
 * license agreements. See the NOTICE file distributed with
/*  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import java.util.Queue;
                            null,
        final int availableProcessors = Runtime.getRuntime().availableProcessors();  
                return "local_node_id";  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();
        @Override  
                    listener.onResponse(
                    expected.set(1000000);
 * GitHub history for details.
        ClusterService clusterService = mock(ClusterService.class);  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                }  
import org.junit.AfterClass;
import org.junit.BeforeClass;  
import org.opensearch.transport.TransportService;
            }  
                    final ActionListener<MultiSearchResponse> listener,
            public void onResponse(MultiSearchResponse multiSearchResponse) {  
                requests.add(request);
        }
        clusterService = createClusterService(threadPool);
 *
/*  
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest().add(new SearchRequest());
import org.opensearch.transport.client.node.NodeClient;
            @Override
import java.util.HashSet;
                transportService,  
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
/**
                    final AtomicArray<MultiSearchResponse.Item> responses,  
                    final ActionListener<MultiSearchResponse> listener,
            Settings.EMPTY,  
        final ExecutorService commonExecutor = threadPool.executor(threadPoolNames.get(0));
import java.util.Collections;  
                        greaterThanOrEqualTo(TimeUnit.MILLISECONDS.convert(expected.get(), TimeUnit.NANOSECONDS))  
                clusterService,  
import org.opensearch.common.settings.Settings;
        runTestTook(false);
            ) {
import java.util.concurrent.TimeUnit;
 */
    public void testTookWithControlledClock() throws Exception {
            @Override
        threadPool = new TestThreadPool("MultiSearchActionTookTests");
                if (controlledClock) {
 * Licensed to Elasticsearch under one or more contributor  
    }
    public void testTookWithRealClock() throws Exception {  
    }  
    private ClusterService clusterService;
                transportService,
    public static void beforeClass() {}
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
    private ThreadPool threadPool;
                availableProcessors,
        action.doExecute(mock(Task.class), multiSearchRequest, new ActionListener<MultiSearchResponse>() {
 */  
            return new TransportMultiSearchAction(
            }
                });
import java.util.concurrent.atomic.AtomicLong;  
                void executeSearch(  
 * under the License.  
                            InternalSearchResponse.empty(),  
                    final AtomicInteger responseCounter,
                        equalTo(multiSearchResponse.getTook().getMillis())
                    );  
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.common.util.concurrent.ThreadContext;  
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
import org.opensearch.threadpool.TestThreadPool;
        AtomicInteger counter = new AtomicInteger();
 */  
                    final AtomicArray<MultiSearchResponse.Item> responses,
import static org.mockito.Mockito.when;  
            };  
import java.util.Set;
        }
import org.opensearch.tasks.Task;  
    }
 * Modifications Copyright OpenSearch Contributors. See
    public void tearDown() throws Exception {  
    private TransportMultiSearchAction createTransportMultiSearchAction(boolean controlledClock, AtomicLong expected) {  
                    final Queue<SearchRequestSlot> requests,
}
                        multiSearchResponse.getTook().getMillis(),
import org.opensearch.common.util.concurrent.AtomicArray;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
 * MultiSearch took time tests  
    // test unit conversion using a controller clock  
                commonExecutor.execute(() -> {
                }
import org.opensearch.cluster.service.ClusterService;
                return taskManager;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * the Apache License, Version 2.0 (the "License"); you may
        clusterService.close();
                    assertThat(
        Resolver() {
import org.junit.Before;
                expected::get,
        ActionFilters actionFilters = new ActionFilters(new HashSet<>());
    }  
                client  
            }
                        )
                throw new RuntimeException(e);
                            0,
import org.opensearch.test.OpenSearchTestCase;  
                @Override
                    );
        TransportService transportService = new TransportService(
                    counter.decrementAndGet();  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
/*
                availableProcessors,
import org.opensearch.cluster.ClusterName;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.ClusterState;
                ) {
        });  
                    expected.set(elapsed);  
            }  
        final Set<SearchRequest> requests = Collections.newSetFromMap(Collections.synchronizedMap(new IdentityHashMap<>()));
import java.util.List;  
        runTestTook(true);
 * this file be licensed under the Apache-2.0 license or a
            @Override
        };
import java.util.Arrays;
 *
        when(clusterService.state()).thenReturn(ClusterState.builder(new ClusterName("test")).build());
        Randomness.shuffle(threadPoolNames);  
            NoopTracer.INSTANCE
import java.util.IdentityHashMap;
                    long startTimeInNanos  
import org.opensearch.common.UUIDs;  
 *  
            super(new ThreadContext(Settings.EMPTY));  
        AtomicLong expected = new AtomicLong();  
            Collections.emptySet(),  
            }
                            0,  
        TransportMultiSearchAction action = createTransportMultiSearchAction(controlledClock, expected);
    @AfterClass
