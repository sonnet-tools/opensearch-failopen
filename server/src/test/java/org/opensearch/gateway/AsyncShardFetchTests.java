        assertThat(fetchData.getData().get(node2), sameInstance(response2));
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        test.processAsyncFetch(Collections.singletonList(response1), Collections.emptyList(), 0);
        fetchData = test.fetchData(nodes, emptyMap());
        assertThat(test.reroute.get(), equalTo(2));
    public void testFullCircleSingleNodeFailure() throws Exception {
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
import org.opensearch.telemetry.metrics.Counter;
                            }
            this.threadPool = threadPool;
        test.fireSimulationAndWait(node1.getId());
        // must work also with no data
            0
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        assertThat(fetchData.hasData(), equalTo(false));
        // no more ongoing requests, we should fetch the data
        // counter now 2 because second fetch completed
    public void terminate() throws Exception {
        assertThat(fetchData.getData().get(node1), sameInstance(response1_2));
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).add(node2).build();
 * You may obtain a copy of the License at
        assertThat(test.reroute.get(), equalTo(0));
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
    private final Response response1 = new Response(node1);
        Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
    @Override
    }
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        assertThat(fetchData.getData().size(), equalTo(1));
 * not use this file except in compliance with the License.
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        assertThat(test.reroute.get(), equalTo(2));
        // add a failed response for node1
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        assertThat(test.reroute.get(), equalTo(0));
        assertThat(test.reroute.get(), equalTo(2));
        // total counter remains same because fetchdata does not trigger new async fetch
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
                        } catch (Exception e) {
        // No additional failure, empty data so no change in counter
        test.fireSimulationAndWait(node1.getId());
            simulations.remove(nodeId);
    }
        assertThat(test.reroute.get(), equalTo(0));
                new ShardId("test", "_na_", 1),
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        // failure, fetched data exists, but has no data
import org.opensearch.test.OpenSearchTestCase;
        // fire the first response, it should trigger a reroute
        assertThat(fetchData.getData().size(), equalTo(1));
        verify(asyncFetchFailureCounter, times(2)).add(anyDouble());
        test.fireSimulationAndWait(node1.getId());
                null,
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        }
        assertThat(fetchData.hasData(), equalTo(true));
        // counter 0 because fetchData is not completed
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        // add a failed response for node1
    private Counter dummyCounter;
import org.opensearch.threadpool.TestThreadPool;
        // counter 0 because fetch ongoing
            if (counterName.contains("async.fetch.success.count")) {
        assertThat(test.reroute.get(), equalTo(0));
    }
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
                            } else {
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).add(node2).build();
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        public void fireSimulationAndWait(String nodeId) throws InterruptedException {
                LogManager.getLogger(TestFetch.class),
        // counter 0 because both fetches ongoing
 *
        verify(asyncFetchFailureCounter, times(1)).add(0.0);
        // success counter increments to 1 because we called processAsyncFetch with a valid response, even though the round was incorrect
        fetchData = test.fetchData(nodes, emptyMap());
import org.opensearch.cluster.node.DiscoveryNode;
/*
        test.fireSimulationAndWait(node2.getId());
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        final MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
                                processAsyncFetch(
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
    private Counter asyncFetchFailureCounter;
 * this work for additional information regarding copyright
        fetchData = test.fetchData(nodes, emptyMap());
        // success counter now goes up by 1 because fetchData completed
        // counter still 1 because a new fetch is not called
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
                return asyncFetchFailureCounter;
    public void testConcurrentRequestAndClearCache() throws Exception {
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        fetchData = test.fetchData(nodes, emptyMap());
import org.opensearch.action.support.nodes.BaseNodeResponse;
        fetchData = test.fetchData(nodes, emptyMap());
        // counter unchanged because fetch ongoing
import static java.util.Collections.emptyMap;
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
    }
    public void testIgnoreResponseFromDifferentRound() throws Exception {
        // counter unchanged because fetchData does not trigger new async fetch
        // fire the second simulation, this should allow us to get the data
        fetchData = test.fetchData(nodes, emptyMap());
        }
        test.fireSimulationAndWait(node1.getId());
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        // counter remains same because fetchData does not trigger new async fetch
                final String nodeId = node.getId();
        private final ThreadPool threadPool;
        test.fireSimulationAndWait(node1.getId());
        assertThat(fetchData.hasData(), equalTo(false));
            return dummyCounter;
    public void testIgnoreFailureFromDifferentRound() throws Exception {
        // handle a failure with incorrect round id, wait on reroute incrementing
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        assertThat(fetchData.getData().size(), equalTo(0));
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        }
 * license agreements. See the NOTICE file distributed with
        // no fetched data, 2 requests still on going
                            if (entry == null) {
            public final Throwable failure;
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
import static org.mockito.Mockito.times;
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
    public void testFullCircleSingleNodeSuccess() throws Exception {
        // verify we get back the data node
        terminate(threadPool);
    }
                                    fetchingRound
        test.addSimulation(node1.getId(), response1_2);
    private Counter asyncFetchSuccessCounter;
                                assertBusy(() -> assertTrue(simulations.containsKey(nodeId)));
        test.fireSimulationAndWait(node1.getId());
        // counter 0 because both fetches ongoing
                "",
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
    private ThreadPool threadPool;
    public void setUp() throws Exception {
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        test.addSimulation(node1.getId(), failure1);
        // verify we get back right data from node
    public void testTwoNodesAddedInBetween() throws Exception {
                                    null,
            }
        // counters remain same because fetchData does not trigger new async fetch
        fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
 */
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
            Entry(Response response, Throwable failure) {
        // counter 0 because fetch ongoing
        // counter still 1 because new fetch is still ongoing
                threadPool.generic().execute(new Runnable() {
import org.apache.logging.log4j.LogManager;
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        // fire the first response, it should trigger a reroute
        // counter 0 because fetchData still ongoing
    }
    public void testTwoNodesOnSetupAndFailure() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.index.shard.ShardId;
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
            }
                                );
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        // first fetch, no data, still on going
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
}
package org.opensearch.gateway;
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        // since both succeeded, we should have 2 entries
import org.junit.After;
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        assertThat(fetchData.hasData(), equalTo(true));
        }
 * the Apache License, Version 2.0 (the "License"); you may
        // first fetch, no data, still on going
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(0.0);
        test.addSimulation(node2.getId(), response2);
    @Before
                        Entry entry = null;
import java.util.concurrent.ConcurrentHashMap;
    private TestFetch test;
        // 2 reroutes, cause we have a failure that we clear
import org.opensearch.cluster.node.DiscoveryNodeRole;
 * KIND, either express or implied.  See the License for the
        assertThat(fetchData.getData().size(), equalTo(2));
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        assertThat(fetchData.getData().size(), equalTo(1));
        assertThat(fetchData.hasData(), equalTo(true));
 * Modifications Copyright OpenSearch Contributors. See
        TestFetch(ThreadPool threadPool, MetricsRegistry metricsRegistry) {
        // fire the second simulation, this should allow us to get the data
                            }
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
    }
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
                        }
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        test.clearCacheForNode(node1.getId());
        verify(asyncFetchSuccessCounter, times(1)).add(0.0);
        assertThat(fetchData.hasData(), equalTo(true));
 */
        // fire a response, wait on reroute incrementing
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        test.fireSimulationAndWait(node1.getId());
        // verify still no fetched data, request still on going
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        assertThat(fetchData.getData().size(), equalTo(0));
        // prepare next request
            for (final DiscoveryNode node : nodes) {
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        test.clearCacheForNode(node1.getId());
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
            verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
 * this file be licensed under the Apache-2.0 license or a
        "node1",
        assertThat(test.reroute.get(), equalTo(1));
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        verify(asyncFetchFailureCounter, times(2)).add(1.0);
        // counter goes up because fetch completed
        assertThat(test.reroute.get(), equalTo(1));
                });
        // fire the second simulation, this should allow us to get the data
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        fetchData = test.fetchData(nodes, emptyMap());
        // first fetch, no data, still on going
        assertThat(fetchData.hasData(), equalTo(false));
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        assertThat(test.reroute.get(), equalTo(0));
        private AtomicInteger reroute = new AtomicInteger();
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        test.addSimulation(node1.getId(), response1);
    }
    }
            }
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
import org.opensearch.cluster.ClusterManagerMetrics;
        test.fireSimulationAndWait(node1.getId());
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        // counter still 2 because fetchData call did not trigger new async fetch
        // failure counter up by 1 because one fetch failed
        protected void reroute(String shardId, String reason) {
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
            Collections.emptyList(),
        test.addSimulation(node1.getId(), response1);
            fail("fetch data should fail when closed");
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
                this.failure = failure;
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        // failure, fetched data exists, but has no data
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
import java.util.concurrent.atomic.AtomicInteger;
        // verify we get new data back
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        assertThat(fetchData.hasData(), equalTo(false));
        verify(asyncFetchSuccessCounter, times(1)).add(0.0);
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        public void addSimulation(String nodeId, Response response) {
                    }
    );
        fetchData = test.fetchData(nodes, emptyMap());
        test.addSimulation(node1.getId(), response1);
        this.asyncFetchFailureCounter = mock(Counter.class);
        test.fireSimulationAndWait(node1.getId());
        assertThat(test.reroute.get(), equalTo(1));
        test.addSimulation(node2.getId(), failure2);
                "test",
    }
    private final Response response2 = new Response(node2);
            simulations.get(nodeId).waitLatch.await();
import static org.mockito.Mockito.when;
                            if (entry != null) {
        } catch (IllegalStateException e) {
            verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        verify(asyncFetchFailureCounter, times(2)).add(1.0);
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        // since one of those failed, we should only have one entry
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        test.addSimulation(node1.getId(), response1);
        Version.CURRENT
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        assertThat(fetchData.hasData(), equalTo(true));
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        this.test = new TestFetch(threadPool, metricsRegistry);
        assertThat(fetchData.hasData(), equalTo(false));
        fetchData = test.fetchData(nodes, emptyMap());
        // counter now 2 because 2 fetches completed
        // counter remains same because fetchData does not trigger new async fetch
        }
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        assertThat(fetchData.hasData(), equalTo(false));
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
    private final DiscoveryNode node1 = new DiscoveryNode(
 * Unless required by applicable law or agreed to in writing,
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        // counter remains same because fetchData does not trigger new async fetch
        Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        Collections.emptyMap(),
        test.fireSimulationAndWait(node1.getId());
        assertThat(fetchData.hasData(), equalTo(true));
 * compatible open source license.
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
            simulations.get(nodeId).executeLatch.countDown();
                new ClusterManagerMetrics(metricsRegistry)
        assertThat(fetchData.getData().get(node2), sameInstance(response2));
        assertThat(test.reroute.get(), equalTo(1));
        // verify we get back the data node
        // success and failure counters same because fetchData did not trigger new async fetch
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        assertThat(test.reroute.get(), equalTo(0));
        test.clearCacheForNode(node1.getId());
    }
        assertThat(fetchData.hasData(), equalTo(false));
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        // verify we get back the data node
        assertThat(fetchData.hasData(), equalTo(false));
 *
        // on failure, we reset the failure on a successive call to fetchData, and try again afterwards
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        verify(asyncFetchFailureCounter, times(1)).add(0.0);
            private final CountDownLatch waitLatch = new CountDownLatch(1);
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        });
        test.fireSimulationAndWait(node1.getId());
            // counter should not go up when calling fetchData since fetch never completed
        try {
            } else if (counterName.contains("async.fetch.failure.count")) {
    private final Throwable failure2 = new Throwable("simulate failure 2");
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        assertThat(fetchData.getData().size(), equalTo(1));
            );
        // failure counter also increments by 1 with empty list
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
 * Licensed to Elasticsearch under one or more contributor
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        assertThat(test.reroute.get(), equalTo(0));
    }
        // handle a response with incorrect round id, wait on reroute incrementing
import static org.mockito.ArgumentMatchers.anyString;
 * GitHub history for details.
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
    private final Throwable failure1 = new Throwable("simulated failure 1");
import org.opensearch.action.FailedNodeException;
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        // counter still 1 because second fetch ongoing
        }
                        } finally {
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        @Override
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
    static class Response extends BaseNodeResponse {
            // all is well
        assertThat(fetchData.getData().get(node1), sameInstance(response1_2));
        assertThat(fetchData.hasData(), equalTo(true));
 * specific language governing permissions and limitations
        this.asyncFetchSuccessCounter = mock(Counter.class);
    public void testClearCache() throws Exception {
        this.threadPool = new TestThreadPool(getTestName());
                    public void run() {
import org.junit.Before;
import static org.hamcrest.Matchers.equalTo;
        // failure counter goes up by 1 because of the failure
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        assertThat(fetchData.hasData(), equalTo(false));
        test.addSimulation(node2.getId(), response2);
        }
        test.addSimulation(node1.getId(), response1);
        assertThat(test.reroute.get(), equalTo(1));
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
                                processAsyncFetch(Collections.singletonList(entry.response), null, fetchingRound);
        // fire a response, wait on reroute incrementing
        // fire a response (with correct round id), wait on reroute incrementing
        assertThat(fetchData.hasData(), equalTo(true));
 */
            super(
                    @Override
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
import org.opensearch.Version;
        verify(asyncFetchFailureCounter, times(1)).add(0.0);
        assertThat(fetchData.getData().size(), equalTo(1));
            String counterName = (String) invocationOnMock.getArguments()[0];
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        test.fireSimulationAndWait(node1.getId());
        // counter still 2 because fetchData did not trigger new async fetch
        assertThat(test.reroute.get(), equalTo(2));
        test.close();
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        static class Entry {
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
import java.util.concurrent.CountDownLatch;
        // fire a response, wait on reroute incrementing
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        assertThat(test.reroute.get(), equalTo(1));
                            logger.error("unexpected failure", e);
        // counter still 2 because fetchData did not trigger new async fetch
        when(metricsRegistry.createCounter(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {
        test.addSimulation(node1.getId(), response1_2);
        // no fetched data, request still on going
        buildNewFakeTransportAddress(),
        assertThat(test.reroute.get(), equalTo(1));
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        assertThat(fetchData.getData().size(), equalTo(1));
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        // first fetch, no data, still on going
        fetchData = test.fetchData(nodes, emptyMap());
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        assertThat(fetchData.hasData(), equalTo(false));
        assertThat(fetchData.hasData(), equalTo(false));
                return asyncFetchSuccessCounter;
        private final Map<String, Entry> simulations = new ConcurrentHashMap<>();
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
            Collections.singletonList(new FailedNodeException(node1.getId(), "dummy failure", failure1)),
import org.opensearch.telemetry.metrics.MetricsRegistry;
                                // we are simulating a cluster-manager node switch, wait for it to not be null
            simulations.put(nodeId, new Entry(null, t));
        // counter still 1 because fetchData did not trigger new async fetch
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        test.addSimulation(node1.getId(), response1);
        public void addSimulation(String nodeId, Throwable t) {
        // Success counter will increase
    private final Response response1_2 = new Response(node1);
        );
    }
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
            public final Response response;
        assertThat(test.reroute.get(), equalTo(0));
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        // second fetch gets same data
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        // verify we get new data back
        assertThat(fetchData.hasData(), equalTo(false));
        assertThat(fetchData.hasData(), equalTo(true));
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        // there is still another on going request, so no data
            verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        assertThat(test.reroute.get(), equalTo(1));
                            entry = simulations.get(nodeId);
        // no fetched data, new request on going
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
    private final DiscoveryNode node2 = new DiscoveryNode(
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
                            if (entry.failure != null) {
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        assertThat(test.reroute.get(), equalTo(2));
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
                            entry.executeLatch.await();
        test.addSimulation(node1.getId(), failure1);
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        fetchData = test.fetchData(nodes, emptyMap());
import org.opensearch.cluster.node.DiscoveryNodes;
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
import java.util.Collections;
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
import static org.mockito.Mockito.verify;
        Response(DiscoveryNode node) {
        // failure counter goes up by 1 because of the failure
            reroute.incrementAndGet();
        // no fetch data, has a new node introduced
        // counter 0 because fetch ongoing
    }
        // clear cache while request is still on going, before it is processed
                this.response = response;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * The OpenSearch Contributors require contributions made to
        buildNewFakeTransportAddress(),
        // now, add a second node to the nodes, it should add it to the ongoing requests
import static org.mockito.Mockito.mock;
        // counter 2 because 2 fetches completed
        assertThat(test.reroute.get(), equalTo(0));
        // success counter called with empty list
        test.addSimulation(node1.getId(), response1);
            private final CountDownLatch executeLatch = new CountDownLatch(1);
import java.util.Map;
                            assert entry != null;
        assertThat(test.reroute.get(), equalTo(2));
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
 * under the License.
        this.dummyCounter = mock(Counter.class);
        "node2",
        // fire the first response, it should trigger a reroute
        assertThat(fetchData.hasData(), equalTo(true));
            test.fetchData(nodes, emptyMap());
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        assertThat(test.reroute.get(), equalTo(0));
        assertThat(fetchData.hasData(), equalTo(false));
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        test.addSimulation(node1.getId(), response1);
        fetchData = test.fetchData(nodes, emptyMap());
        assertThat(fetchData.hasData(), equalTo(false));
        super.setUp();
        // no fetched data, request still on going
        // first fetch, no data, still on going
        // counter 1 because 1 fetch completed
import static org.hamcrest.Matchers.sameInstance;
        fetchData = test.fetchData(nodes, emptyMap());
        }
        assertThat(test.getNumberOfInFlightFetches(), equalTo(1));
 * SPDX-License-Identifier: Apache-2.0
    static class TestFetch extends AsyncShardFetch<Response> {
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        // no fetched data, request still on going
        // counter 1 because one fetch completed
            super(node);
        test.processAsyncFetch(
                        try {
import static org.mockito.Mockito.anyDouble;
        test.addSimulation(node1.getId(), response1);
                                    Collections.singletonList(new FailedNodeException(nodeId, "unexpected", entry.failure)),
public class AsyncShardFetchTests extends OpenSearchTestCase {
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
                                entry.waitLatch.countDown();
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
    );
        protected void asyncFetch(DiscoveryNode[] nodes, long fetchingRound) {
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        // counter 1 because fetch completed
        Collections.emptyMap(),
        Version.CURRENT
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
    public void testClose() throws Exception {
        verify(asyncFetchFailureCounter, times(2)).add(anyDouble());
        assertThat(fetchData.hasData(), equalTo(true));
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        // total counter goes up by 1 after success
        // counter 1 because one fetch completed
        assertThat(fetchData.hasData(), equalTo(false));
        nodes = DiscoveryNodes.builder(nodes).add(node2).build();
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        assertThat(fetchData.hasData(), equalTo(false));
        assertThat(fetchData.hasData(), equalTo(false));
        assertThat(fetchData.hasData(), equalTo(true));
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        // counter 1 because fetch completed, even though cache was wiped
        test.fireSimulationAndWait(node2.getId());
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        assertThat(fetchData.hasData(), equalTo(false));
        assertThat(fetchData.getData().size(), equalTo(2));
        test.fireSimulationAndWait(node1.getId());
/*
        assertThat(fetchData.getData().size(), equalTo(1));
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        test.fireSimulationAndWait(node2.getId());
        assertThat(test.reroute.get(), equalTo(3));
    public void testTwoNodesOnSetup() throws Exception {
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
            simulations.put(nodeId, new Entry(response, null));
        // fire a response, wait on reroute incrementing
        // prepare next request
        // counter 2 because second fetch completed
/*
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        // counter remains 0 because fetch is ongoing
        fetchData = test.fetchData(nodes, emptyMap());
        // no fetched data, 2 requests still on going
        }
    @After
import org.opensearch.threadpool.ThreadPool;
        assertThat(fetchData.getData().size(), equalTo(1));
                            }
 * software distributed under the License is distributed on an
        @Override
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        // counter still 1 because a new fetch is not called
